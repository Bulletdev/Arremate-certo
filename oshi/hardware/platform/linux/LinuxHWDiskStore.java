/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import com.sun.jna.platform.linux.Udev;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.HWDiskStore;
/*     */ import oshi.hardware.HWPartition;
/*     */ import oshi.hardware.common.AbstractHWDiskStore;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.linux.ProcPath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class LinuxHWDiskStore
/*     */   extends AbstractHWDiskStore
/*     */ {
/*     */   private static final String BLOCK = "block";
/*     */   private static final String DISK = "disk";
/*     */   private static final String PARTITION = "partition";
/*     */   private static final String STAT = "stat";
/*     */   private static final String SIZE = "size";
/*     */   private static final String MINOR = "MINOR";
/*     */   private static final String MAJOR = "MAJOR";
/*     */   private static final String ID_FS_TYPE = "ID_FS_TYPE";
/*     */   private static final String ID_FS_UUID = "ID_FS_UUID";
/*     */   private static final String ID_MODEL = "ID_MODEL";
/*     */   private static final String ID_SERIAL_SHORT = "ID_SERIAL_SHORT";
/*     */   private static final String DM_UUID = "DM_UUID";
/*     */   private static final String DM_VG_NAME = "DM_VG_NAME";
/*     */   private static final String DM_LV_NAME = "DM_LV_NAME";
/*     */   private static final String LOGICAL_VOLUME_GROUP = "Logical Volume Group";
/*     */   private static final String DEV_LOCATION = "/dev/";
/*     */   private static final String DEV_MAPPER = "/dev/mapper/";
/*     */   private static final int SECTORSIZE = 512;
/*  81 */   private static final int[] UDEV_STAT_ORDERS = new int[(UdevStat.values()).length]; private static final int UDEV_STAT_LENGTH;
/*     */   static {
/*  83 */     for (UdevStat udevStat : UdevStat.values()) {
/*  84 */       UDEV_STAT_ORDERS[udevStat.ordinal()] = udevStat.getOrder();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     String str = FileUtil.getStringFromFile(ProcPath.DISKSTATS);
/*  93 */     int i = 11;
/*  94 */     if (!str.isEmpty()) {
/*  95 */       i = ParseUtil.countStringToLongArray(str, ' ');
/*     */     }
/*  97 */     UDEV_STAT_LENGTH = i;
/*     */   }
/*     */   
/* 100 */   private long reads = 0L;
/* 101 */   private long readBytes = 0L;
/* 102 */   private long writes = 0L;
/* 103 */   private long writeBytes = 0L;
/* 104 */   private long currentQueueLength = 0L;
/* 105 */   private long transferTime = 0L;
/* 106 */   private long timeStamp = 0L;
/* 107 */   private List<HWPartition> partitionList = new ArrayList<>();
/*     */   
/*     */   private LinuxHWDiskStore(String paramString1, String paramString2, String paramString3, long paramLong) {
/* 110 */     super(paramString1, paramString2, paramString3, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReads() {
/* 115 */     return this.reads;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReadBytes() {
/* 120 */     return this.readBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWrites() {
/* 125 */     return this.writes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWriteBytes() {
/* 130 */     return this.writeBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCurrentQueueLength() {
/* 135 */     return this.currentQueueLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTransferTime() {
/* 140 */     return this.transferTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 145 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HWPartition> getPartitions() {
/* 150 */     return this.partitionList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<HWDiskStore> getDisks() {
/* 159 */     return getDisks((LinuxHWDiskStore)null);
/*     */   }
/*     */   
/*     */   private static List<HWDiskStore> getDisks(LinuxHWDiskStore paramLinuxHWDiskStore) {
/* 163 */     LinuxHWDiskStore linuxHWDiskStore = null;
/* 164 */     ArrayList<LinuxHWDiskStore> arrayList = new ArrayList();
/*     */     
/* 166 */     Map<String, String> map = readMountsMap();
/*     */     
/* 168 */     Udev.UdevContext udevContext = Udev.INSTANCE.udev_new();
/*     */     try {
/* 170 */       Udev.UdevEnumerate udevEnumerate = udevContext.enumerateNew();
/*     */       try {
/* 172 */         udevEnumerate.addMatchSubsystem("block");
/* 173 */         udevEnumerate.scanDevices();
/* 174 */         for (Udev.UdevListEntry udevListEntry = udevEnumerate.getListEntry(); udevListEntry != null; udevListEntry = udevListEntry.getNext()) {
/* 175 */           String str = udevListEntry.getName();
/* 176 */           Udev.UdevDevice udevDevice = udevContext.deviceNewFromSyspath(str);
/* 177 */           if (udevDevice != null) {
/*     */ 
/*     */             
/* 180 */             try { String str1 = udevDevice.getDevnode();
/*     */               
/* 182 */               if (str1 != null && !str1.startsWith("/dev/loop") && 
/* 183 */                 !str1.startsWith("/dev/ram"))
/* 184 */                 if ("disk".equals(udevDevice.getDevtype()))
/*     */                 
/* 186 */                 { String str2 = udevDevice.getPropertyValue("ID_MODEL");
/* 187 */                   String str3 = udevDevice.getPropertyValue("ID_SERIAL_SHORT");
/* 188 */                   long l = ParseUtil.parseLongOrDefault(udevDevice.getSysattrValue("size"), 0L) * 512L;
/*     */                   
/* 190 */                   if (str1.startsWith("/dev/dm")) {
/* 191 */                     str2 = "Logical Volume Group";
/* 192 */                     str3 = udevDevice.getPropertyValue("DM_UUID");
/*     */                     
/* 194 */                     linuxHWDiskStore = new LinuxHWDiskStore(str1, str2, (str3 == null) ? "unknown" : str3, l);
/* 195 */                     String str4 = udevDevice.getPropertyValue("DM_VG_NAME");
/* 196 */                     String str5 = udevDevice.getPropertyValue("DM_LV_NAME");
/* 197 */                     linuxHWDiskStore.partitionList.add(new HWPartition(
/* 198 */                           getPartitionNameForDmDevice(str4, str5), udevDevice.getSysname(), 
/* 199 */                           (udevDevice.getPropertyValue("ID_FS_TYPE") == null) ? "partition" : 
/* 200 */                           udevDevice.getPropertyValue("ID_FS_TYPE"), 
/* 201 */                           (udevDevice.getPropertyValue("ID_FS_UUID") == null) ? "" : 
/* 202 */                           udevDevice.getPropertyValue("ID_FS_UUID"), 
/* 203 */                           ParseUtil.parseLongOrDefault(udevDevice.getSysattrValue("size"), 0L) * 512L, 
/*     */                           
/* 205 */                           ParseUtil.parseIntOrDefault(udevDevice.getPropertyValue("MAJOR"), 0), 
/* 206 */                           ParseUtil.parseIntOrDefault(udevDevice.getPropertyValue("MINOR"), 0), 
/* 207 */                           getMountPointOfDmDevice(str4, str5)));
/*     */                   }
/*     */                   else {
/*     */                     
/* 211 */                     linuxHWDiskStore = new LinuxHWDiskStore(str1, (str2 == null) ? "unknown" : str2, (str3 == null) ? "unknown" : str3, l);
/*     */                   } 
/* 213 */                   if (paramLinuxHWDiskStore == null)
/*     */                   
/* 215 */                   { computeDiskStats(linuxHWDiskStore, udevDevice.getSysattrValue("stat"));
/* 216 */                     arrayList.add(linuxHWDiskStore); }
/* 217 */                   else if (linuxHWDiskStore.getName().equals(paramLinuxHWDiskStore.getName()) && linuxHWDiskStore
/* 218 */                     .getModel().equals(paramLinuxHWDiskStore.getModel()) && linuxHWDiskStore
/* 219 */                     .getSerial().equals(paramLinuxHWDiskStore.getSerial()) && linuxHWDiskStore
/* 220 */                     .getSize() == paramLinuxHWDiskStore.getSize())
/*     */                   
/*     */                   { 
/*     */                     
/* 224 */                     computeDiskStats(paramLinuxHWDiskStore, udevDevice.getSysattrValue("stat"));
/* 225 */                     arrayList.add(paramLinuxHWDiskStore);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                     
/* 252 */                     udevDevice.unref(); break; }  } else if (paramLinuxHWDiskStore == null && linuxHWDiskStore != null && "partition".equals(udevDevice.getDevtype())) { Udev.UdevDevice udevDevice1 = udevDevice.getParentWithSubsystemDevtype("block", "disk"); if (udevDevice1 != null && linuxHWDiskStore.getName().equals(udevDevice1.getDevnode())) { String str2 = udevDevice.getDevnode(); linuxHWDiskStore.partitionList.add(new HWPartition(str2, udevDevice.getSysname(), (udevDevice.getPropertyValue("ID_FS_TYPE") == null) ? "partition" : udevDevice.getPropertyValue("ID_FS_TYPE"), (udevDevice.getPropertyValue("ID_FS_UUID") == null) ? "" : udevDevice.getPropertyValue("ID_FS_UUID"), ParseUtil.parseLongOrDefault(udevDevice.getSysattrValue("size"), 0L) * 512L, ParseUtil.parseIntOrDefault(udevDevice.getPropertyValue("MAJOR"), 0), ParseUtil.parseIntOrDefault(udevDevice.getPropertyValue("MINOR"), 0), map.getOrDefault(str2, getDependentNamesFromHoldersDirectory(udevDevice.getSysname())))); }  }   udevDevice.unref(); } finally { udevDevice.unref(); }
/*     */           
/*     */           }
/*     */         } 
/*     */       } finally {
/* 257 */         udevEnumerate.unref();
/*     */       } 
/*     */     } finally {
/* 260 */       udevContext.unref();
/*     */     } 
/*     */     
/* 263 */     for (HWDiskStore hWDiskStore : arrayList) {
/* 264 */       ((LinuxHWDiskStore)hWDiskStore).partitionList = Collections.unmodifiableList((List<? extends HWPartition>)hWDiskStore.getPartitions().stream()
/* 265 */           .sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList()));
/*     */     }
/* 267 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 274 */     return !getDisks(this).isEmpty();
/*     */   }
/*     */   
/*     */   private static Map<String, String> readMountsMap() {
/* 278 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 279 */     List list = FileUtil.readFile(ProcPath.MOUNTS);
/* 280 */     for (String str : list) {
/* 281 */       String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 282 */       if (arrayOfString.length < 2 || !arrayOfString[0].startsWith("/dev/")) {
/*     */         continue;
/*     */       }
/* 285 */       hashMap.put(arrayOfString[0], arrayOfString[1]);
/*     */     } 
/* 287 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private static void computeDiskStats(LinuxHWDiskStore paramLinuxHWDiskStore, String paramString) {
/* 291 */     long[] arrayOfLong = ParseUtil.parseStringToLongArray(paramString, UDEV_STAT_ORDERS, UDEV_STAT_LENGTH, ' ');
/* 292 */     paramLinuxHWDiskStore.timeStamp = System.currentTimeMillis();
/*     */ 
/*     */     
/* 295 */     paramLinuxHWDiskStore.reads = arrayOfLong[UdevStat.READS.ordinal()];
/* 296 */     paramLinuxHWDiskStore.readBytes = arrayOfLong[UdevStat.READ_BYTES.ordinal()] * 512L;
/* 297 */     paramLinuxHWDiskStore.writes = arrayOfLong[UdevStat.WRITES.ordinal()];
/* 298 */     paramLinuxHWDiskStore.writeBytes = arrayOfLong[UdevStat.WRITE_BYTES.ordinal()] * 512L;
/* 299 */     paramLinuxHWDiskStore.currentQueueLength = arrayOfLong[UdevStat.QUEUE_LENGTH.ordinal()];
/* 300 */     paramLinuxHWDiskStore.transferTime = arrayOfLong[UdevStat.ACTIVE_MS.ordinal()];
/*     */   }
/*     */   
/*     */   private static String getPartitionNameForDmDevice(String paramString1, String paramString2) {
/* 304 */     return "/dev/" + paramString1 + '/' + paramString2;
/*     */   }
/*     */   
/*     */   private static String getMountPointOfDmDevice(String paramString1, String paramString2) {
/* 308 */     return "/dev/mapper/" + paramString1 + '-' + paramString2;
/*     */   }
/*     */   
/*     */   private static String getDependentNamesFromHoldersDirectory(String paramString) {
/* 312 */     File file = new File(paramString + "/holders");
/* 313 */     File[] arrayOfFile = file.listFiles();
/* 314 */     if (arrayOfFile != null) {
/* 315 */       return Arrays.<File>stream(arrayOfFile).map(File::getName).collect(Collectors.joining(" "));
/*     */     }
/* 317 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   enum UdevStat
/*     */   {
/* 324 */     READS(0), READ_BYTES(2), WRITES(4), WRITE_BYTES(6), QUEUE_LENGTH(8), ACTIVE_MS(9);
/*     */     
/*     */     private int order;
/*     */     
/*     */     public int getOrder() {
/* 329 */       return this.order;
/*     */     }
/*     */     
/*     */     UdevStat(int param1Int1) {
/* 333 */       this.order = param1Int1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxHWDiskStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */