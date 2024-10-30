/*     */ package oshi.hardware.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.COMException;
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.windows.perfmon.PhysicalDisk;
/*     */ import oshi.driver.windows.wmi.Win32DiskDrive;
/*     */ import oshi.driver.windows.wmi.Win32DiskDriveToDiskPartition;
/*     */ import oshi.driver.windows.wmi.Win32DiskPartition;
/*     */ import oshi.driver.windows.wmi.Win32LogicalDiskToPartition;
/*     */ import oshi.hardware.HWDiskStore;
/*     */ import oshi.hardware.HWPartition;
/*     */ import oshi.hardware.common.AbstractHWDiskStore;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.windows.WmiQueryHandler;
/*     */ import oshi.util.platform.windows.WmiUtil;
/*     */ import oshi.util.tuples.Pair;
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
/*     */ public final class WindowsHWDiskStore
/*     */   extends AbstractHWDiskStore
/*     */ {
/*  68 */   private static final Logger LOG = LoggerFactory.getLogger(WindowsHWDiskStore.class);
/*     */   
/*     */   private static final String PHYSICALDRIVE_PREFIX = "\\\\.\\PHYSICALDRIVE";
/*  71 */   private static final Pattern DEVICE_ID = Pattern.compile(".*\\.DeviceID=\"(.*)\"");
/*     */ 
/*     */   
/*     */   private static final int GUID_BUFSIZE = 100;
/*     */ 
/*     */   
/*  77 */   private long reads = 0L;
/*  78 */   private long readBytes = 0L;
/*  79 */   private long writes = 0L;
/*  80 */   private long writeBytes = 0L;
/*  81 */   private long currentQueueLength = 0L;
/*  82 */   private long transferTime = 0L;
/*  83 */   private long timeStamp = 0L;
/*     */   private List<HWPartition> partitionList;
/*     */   
/*     */   private WindowsHWDiskStore(String paramString1, String paramString2, String paramString3, long paramLong) {
/*  87 */     super(paramString1, paramString2, paramString3, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReads() {
/*  92 */     return this.reads;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReadBytes() {
/*  97 */     return this.readBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWrites() {
/* 102 */     return this.writes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWriteBytes() {
/* 107 */     return this.writeBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCurrentQueueLength() {
/* 112 */     return this.currentQueueLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTransferTime() {
/* 117 */     return this.transferTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 122 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HWPartition> getPartitions() {
/* 127 */     return this.partitionList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 132 */     String str = null;
/* 133 */     List<HWPartition> list = getPartitions();
/* 134 */     if (!list.isEmpty()) {
/*     */ 
/*     */       
/* 137 */       str = Integer.toString(((HWPartition)list.get(0)).getMajor());
/* 138 */     } else if (getName().startsWith("\\\\.\\PHYSICALDRIVE")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 144 */       str = getName().substring("\\\\.\\PHYSICALDRIVE".length(), getName().length());
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 150 */       LOG.warn("Couldn't match index for {}", getName());
/* 151 */       return false;
/*     */     } 
/* 153 */     DiskStats diskStats = queryReadWriteStats(str);
/* 154 */     if (diskStats.readMap.containsKey(str)) {
/* 155 */       this.reads = ((Long)diskStats.readMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/* 156 */       this.readBytes = ((Long)diskStats.readByteMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/* 157 */       this.writes = ((Long)diskStats.writeMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/* 158 */       this.writeBytes = ((Long)diskStats.writeByteMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/* 159 */       this.currentQueueLength = ((Long)diskStats.queueLengthMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/* 160 */       this.transferTime = ((Long)diskStats.diskTimeMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/* 161 */       this.timeStamp = diskStats.timeStamp;
/* 162 */       return true;
/*     */     } 
/* 164 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<HWDiskStore> getDisks() {
/* 174 */     WmiQueryHandler wmiQueryHandler = WmiQueryHandler.createInstance();
/* 175 */     boolean bool = false;
/*     */     try {
/* 177 */       bool = wmiQueryHandler.initCOM();
/*     */       
/* 179 */       ArrayList<WindowsHWDiskStore> arrayList = new ArrayList();
/* 180 */       DiskStats diskStats = queryReadWriteStats(null);
/* 181 */       PartitionMaps partitionMaps = queryPartitionMaps(wmiQueryHandler);
/*     */       
/* 183 */       WbemcliUtil.WmiResult wmiResult = Win32DiskDrive.queryDiskDrive(wmiQueryHandler);
/* 184 */       for (byte b = 0; b < wmiResult.getResultCount(); b++) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 190 */         WindowsHWDiskStore windowsHWDiskStore = new WindowsHWDiskStore(WmiUtil.getString(wmiResult, (Enum)Win32DiskDrive.DiskDriveProperty.NAME, b), String.format("%s %s", new Object[] { WmiUtil.getString(wmiResult, (Enum)Win32DiskDrive.DiskDriveProperty.MODEL, b), WmiUtil.getString(wmiResult, (Enum)Win32DiskDrive.DiskDriveProperty.MANUFACTURER, b) }).trim(), ParseUtil.hexStringToString(WmiUtil.getString(wmiResult, (Enum)Win32DiskDrive.DiskDriveProperty.SERIALNUMBER, b)), WmiUtil.getUint64(wmiResult, (Enum)Win32DiskDrive.DiskDriveProperty.SIZE, b));
/*     */         
/* 192 */         String str = Integer.toString(WmiUtil.getUint32(wmiResult, (Enum)Win32DiskDrive.DiskDriveProperty.INDEX, b));
/* 193 */         windowsHWDiskStore.reads = ((Long)diskStats.readMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/* 194 */         windowsHWDiskStore.readBytes = ((Long)diskStats.readByteMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/* 195 */         windowsHWDiskStore.writes = ((Long)diskStats.writeMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/* 196 */         windowsHWDiskStore.writeBytes = ((Long)diskStats.writeByteMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/* 197 */         windowsHWDiskStore.currentQueueLength = ((Long)diskStats.queueLengthMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 204 */         windowsHWDiskStore.transferTime = ((Long)diskStats.diskTimeMap.getOrDefault(str, Long.valueOf(0L))).longValue();
/* 205 */         windowsHWDiskStore.timeStamp = diskStats.timeStamp;
/*     */         
/* 207 */         ArrayList arrayList1 = new ArrayList();
/* 208 */         List list = (List)partitionMaps.driveToPartitionMap.get(windowsHWDiskStore.getName());
/* 209 */         if (list != null && !list.isEmpty()) {
/* 210 */           for (String str1 : list) {
/* 211 */             if (partitionMaps.partitionMap.containsKey(str1)) {
/* 212 */               arrayList1.addAll((Collection)partitionMaps.partitionMap.get(str1));
/*     */             }
/*     */           } 
/*     */         }
/* 216 */         windowsHWDiskStore.partitionList = Collections.unmodifiableList((List<? extends HWPartition>)arrayList1.stream()
/* 217 */             .sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList()));
/*     */         
/* 219 */         arrayList.add(windowsHWDiskStore);
/*     */       } 
/* 221 */       return (List)arrayList;
/* 222 */     } catch (COMException cOMException) {
/* 223 */       LOG.warn("COM exception: {}", cOMException.getMessage());
/* 224 */       return (List)Collections.emptyList();
/*     */     } finally {
/* 226 */       if (bool) {
/* 227 */         wmiQueryHandler.unInitCOM();
/*     */       }
/*     */     } 
/*     */   }
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
/*     */   private static DiskStats queryReadWriteStats(String paramString) {
/* 242 */     DiskStats diskStats = new DiskStats();
/* 243 */     Pair pair = PhysicalDisk.queryDiskCounters();
/* 244 */     List<String> list = (List)pair.getA();
/* 245 */     Map map = (Map)pair.getB();
/* 246 */     diskStats.timeStamp = System.currentTimeMillis();
/* 247 */     List<Long> list1 = (List)map.get(PhysicalDisk.PhysicalDiskProperty.DISKREADSPERSEC);
/* 248 */     List<Long> list2 = (List)map.get(PhysicalDisk.PhysicalDiskProperty.DISKREADBYTESPERSEC);
/* 249 */     List<Long> list3 = (List)map.get(PhysicalDisk.PhysicalDiskProperty.DISKWRITESPERSEC);
/* 250 */     List<Long> list4 = (List)map.get(PhysicalDisk.PhysicalDiskProperty.DISKWRITEBYTESPERSEC);
/* 251 */     List<Long> list5 = (List)map.get(PhysicalDisk.PhysicalDiskProperty.CURRENTDISKQUEUELENGTH);
/* 252 */     List<Long> list6 = (List)map.get(PhysicalDisk.PhysicalDiskProperty.PERCENTDISKTIME);
/*     */     
/* 254 */     if (list.isEmpty() || list1 == null || list2 == null || list3 == null || list4 == null || list5 == null || list6 == null)
/*     */     {
/* 256 */       return diskStats;
/*     */     }
/* 258 */     for (byte b = 0; b < list.size(); b++) {
/* 259 */       String str = getIndexFromName(list.get(b));
/*     */       
/* 261 */       if (paramString == null || paramString.equals(str)) {
/*     */ 
/*     */         
/* 264 */         diskStats.readMap.put(str, list1.get(b));
/* 265 */         diskStats.readByteMap.put(str, list2.get(b));
/* 266 */         diskStats.writeMap.put(str, list3.get(b));
/* 267 */         diskStats.writeByteMap.put(str, list4.get(b));
/* 268 */         diskStats.queueLengthMap.put(str, list5.get(b));
/* 269 */         diskStats.diskTimeMap.put(str, Long.valueOf(((Long)list6.get(b)).longValue() / 10000L));
/*     */       } 
/* 271 */     }  return diskStats;
/*     */   }
/*     */ 
/*     */   
/*     */   private static PartitionMaps queryPartitionMaps(WmiQueryHandler paramWmiQueryHandler) {
/* 276 */     PartitionMaps partitionMaps = new PartitionMaps();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 283 */     WbemcliUtil.WmiResult wmiResult1 = Win32DiskDriveToDiskPartition.queryDriveToPartition(paramWmiQueryHandler);
/* 284 */     for (byte b1 = 0; b1 < wmiResult1.getResultCount(); b1++) {
/* 285 */       Matcher matcher1 = DEVICE_ID.matcher(WmiUtil.getRefString(wmiResult1, (Enum)Win32DiskDriveToDiskPartition.DriveToPartitionProperty.ANTECEDENT, b1));
/* 286 */       Matcher matcher2 = DEVICE_ID.matcher(WmiUtil.getRefString(wmiResult1, (Enum)Win32DiskDriveToDiskPartition.DriveToPartitionProperty.DEPENDENT, b1));
/* 287 */       if (matcher1.matches() && matcher2.matches()) {
/* 288 */         ((List<String>)partitionMaps.driveToPartitionMap.computeIfAbsent(matcher1.group(1).replace("\\\\", "\\"), paramString -> new ArrayList()))
/* 289 */           .add(matcher2.group(1));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 294 */     WbemcliUtil.WmiResult wmiResult2 = Win32LogicalDiskToPartition.queryDiskToPartition(paramWmiQueryHandler);
/* 295 */     for (byte b2 = 0; b2 < wmiResult2.getResultCount(); b2++) {
/* 296 */       Matcher matcher1 = DEVICE_ID.matcher(WmiUtil.getRefString(wmiResult2, (Enum)Win32LogicalDiskToPartition.DiskToPartitionProperty.ANTECEDENT, b2));
/* 297 */       Matcher matcher2 = DEVICE_ID.matcher(WmiUtil.getRefString(wmiResult2, (Enum)Win32LogicalDiskToPartition.DiskToPartitionProperty.DEPENDENT, b2));
/*     */       
/* 299 */       long l = WmiUtil.getUint64(wmiResult2, (Enum)Win32LogicalDiskToPartition.DiskToPartitionProperty.ENDINGADDRESS, b2) - WmiUtil.getUint64(wmiResult2, (Enum)Win32LogicalDiskToPartition.DiskToPartitionProperty.STARTINGADDRESS, b2) + 1L;
/* 300 */       if (matcher1.matches() && matcher2.matches()) {
/* 301 */         if (partitionMaps.partitionToLogicalDriveMap.containsKey(matcher1.group(1))) {
/* 302 */           ((List<Pair>)partitionMaps.partitionToLogicalDriveMap.get(matcher1.group(1))).add(new Pair(matcher2.group(1) + "\\", Long.valueOf(l)));
/*     */         } else {
/* 304 */           ArrayList<Pair> arrayList = new ArrayList();
/* 305 */           arrayList.add(new Pair(matcher2.group(1) + "\\", Long.valueOf(l)));
/* 306 */           partitionMaps.partitionToLogicalDriveMap.put(matcher1.group(1), arrayList);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 312 */     WbemcliUtil.WmiResult wmiResult3 = Win32DiskPartition.queryPartition(paramWmiQueryHandler);
/* 313 */     for (byte b3 = 0; b3 < wmiResult3.getResultCount(); b3++) {
/* 314 */       String str = WmiUtil.getString(wmiResult3, (Enum)Win32DiskPartition.DiskPartitionProperty.DEVICEID, b3);
/* 315 */       List<Pair> list = (List)partitionMaps.partitionToLogicalDriveMap.get(str);
/* 316 */       if (list != null)
/*     */       {
/*     */         
/* 319 */         for (byte b = 0; b < list.size(); b++) {
/* 320 */           Pair pair = list.get(b);
/* 321 */           if (pair != null && !((String)pair.getA()).isEmpty()) {
/* 322 */             char[] arrayOfChar = new char[100];
/* 323 */             Kernel32.INSTANCE.GetVolumeNameForVolumeMountPoint((String)pair.getA(), arrayOfChar, 100);
/* 324 */             String str1 = ParseUtil.parseUuidOrDefault((new String(arrayOfChar)).trim(), "");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 332 */             HWPartition hWPartition = new HWPartition(WmiUtil.getString(wmiResult3, (Enum)Win32DiskPartition.DiskPartitionProperty.NAME, b3), WmiUtil.getString(wmiResult3, (Enum)Win32DiskPartition.DiskPartitionProperty.TYPE, b3), WmiUtil.getString(wmiResult3, (Enum)Win32DiskPartition.DiskPartitionProperty.DESCRIPTION, b3), str1, ((Long)pair.getB()).longValue(), WmiUtil.getUint32(wmiResult3, (Enum)Win32DiskPartition.DiskPartitionProperty.DISKINDEX, b3), WmiUtil.getUint32(wmiResult3, (Enum)Win32DiskPartition.DiskPartitionProperty.INDEX, b3), (String)pair.getA());
/* 333 */             if (partitionMaps.partitionMap.containsKey(str)) {
/* 334 */               ((List<HWPartition>)partitionMaps.partitionMap.get(str)).add(hWPartition);
/*     */             } else {
/* 336 */               ArrayList<HWPartition> arrayList = new ArrayList();
/* 337 */               arrayList.add(hWPartition);
/* 338 */               partitionMaps.partitionMap.put(str, arrayList);
/*     */             } 
/*     */           } 
/*     */         }  } 
/*     */     } 
/* 343 */     return partitionMaps;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getIndexFromName(String paramString) {
/* 354 */     if (paramString.isEmpty()) {
/* 355 */       return paramString;
/*     */     }
/* 357 */     return paramString.split("\\s")[0];
/*     */   }
/*     */   
/*     */   private static final class DiskStats
/*     */   {
/*     */     private DiskStats() {}
/*     */     
/* 364 */     private final Map<String, Long> readMap = new HashMap<>();
/* 365 */     private final Map<String, Long> readByteMap = new HashMap<>();
/* 366 */     private final Map<String, Long> writeMap = new HashMap<>();
/* 367 */     private final Map<String, Long> writeByteMap = new HashMap<>();
/* 368 */     private final Map<String, Long> queueLengthMap = new HashMap<>();
/* 369 */     private final Map<String, Long> diskTimeMap = new HashMap<>();
/*     */     private long timeStamp;
/*     */   }
/*     */   
/*     */   private static final class PartitionMaps {
/*     */     private final Map<String, List<String>> driveToPartitionMap;
/*     */     
/*     */     private PartitionMaps() {
/* 377 */       this.driveToPartitionMap = new HashMap<>();
/* 378 */       this.partitionToLogicalDriveMap = new HashMap<>();
/* 379 */       this.partitionMap = new HashMap<>();
/*     */     }
/*     */     
/*     */     private final Map<String, List<Pair<String, Long>>> partitionToLogicalDriveMap;
/*     */     private final Map<String, List<HWPartition>> partitionMap;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsHWDiskStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */