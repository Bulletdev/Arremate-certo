/*     */ package oshi.software.os.windows;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import com.sun.jna.platform.win32.WinBase;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.windows.perfmon.ProcessInformation;
/*     */ import oshi.driver.windows.wmi.Win32LogicalDisk;
/*     */ import oshi.software.common.AbstractFileSystem;
/*     */ import oshi.software.os.OSFileStore;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.windows.WmiUtil;
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
/*     */ public class WindowsFileSystem
/*     */   extends AbstractFileSystem
/*     */ {
/*     */   private static final int BUFSIZE = 255;
/*     */   private static final int SEM_FAILCRITICALERRORS = 1;
/*     */   private static final int FILE_CASE_SENSITIVE_SEARCH = 1;
/*     */   private static final int FILE_CASE_PRESERVED_NAMES = 2;
/*     */   private static final int FILE_FILE_COMPRESSION = 16;
/*     */   private static final int FILE_DAX_VOLUME = 536870912;
/*     */   private static final int FILE_NAMED_STREAMS = 262144;
/*     */   private static final int FILE_PERSISTENT_ACLS = 8;
/*     */   private static final int FILE_READ_ONLY_VOLUME = 524288;
/*     */   private static final int FILE_SEQUENTIAL_WRITE_ONCE = 1048576;
/*     */   private static final int FILE_SUPPORTS_ENCRYPTION = 131072;
/*     */   private static final int FILE_SUPPORTS_OBJECT_IDS = 65536;
/*     */   private static final int FILE_SUPPORTS_REPARSE_POINTS = 128;
/*     */   private static final int FILE_SUPPORTS_SPARSE_FILES = 64;
/*     */   private static final int FILE_SUPPORTS_TRANSACTIONS = 2097152;
/*     */   private static final int FILE_SUPPORTS_USN_JOURNAL = 33554432;
/*     */   private static final int FILE_UNICODE_ON_DISK = 4;
/*     */   private static final int FILE_VOLUME_IS_COMPRESSED = 32768;
/*     */   private static final int FILE_VOLUME_QUOTAS = 32;
/*  80 */   private static final Map<Integer, String> OPTIONS_MAP = new HashMap<>();
/*     */   static {
/*  82 */     OPTIONS_MAP.put(Integer.valueOf(2), "casepn");
/*  83 */     OPTIONS_MAP.put(Integer.valueOf(1), "casess");
/*  84 */     OPTIONS_MAP.put(Integer.valueOf(16), "fcomp");
/*  85 */     OPTIONS_MAP.put(Integer.valueOf(536870912), "dax");
/*  86 */     OPTIONS_MAP.put(Integer.valueOf(262144), "streams");
/*  87 */     OPTIONS_MAP.put(Integer.valueOf(8), "acls");
/*  88 */     OPTIONS_MAP.put(Integer.valueOf(1048576), "wronce");
/*  89 */     OPTIONS_MAP.put(Integer.valueOf(131072), "efs");
/*  90 */     OPTIONS_MAP.put(Integer.valueOf(65536), "oids");
/*  91 */     OPTIONS_MAP.put(Integer.valueOf(128), "reparse");
/*  92 */     OPTIONS_MAP.put(Integer.valueOf(64), "sparse");
/*  93 */     OPTIONS_MAP.put(Integer.valueOf(2097152), "trans");
/*  94 */     OPTIONS_MAP.put(Integer.valueOf(33554432), "journaled");
/*  95 */     OPTIONS_MAP.put(Integer.valueOf(4), "unicode");
/*  96 */     OPTIONS_MAP.put(Integer.valueOf(32768), "vcomp");
/*  97 */     OPTIONS_MAP.put(Integer.valueOf(32), "quota");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     if (System.getenv("ProgramFiles(x86)") == null) {
/* 106 */       MAX_WINDOWS_HANDLES = 16744448L;
/*     */     } else {
/* 108 */       MAX_WINDOWS_HANDLES = 16711680L;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long MAX_WINDOWS_HANDLES;
/*     */ 
/*     */ 
/*     */   
/*     */   public WindowsFileSystem() {
/* 119 */     Kernel32.INSTANCE.SetErrorMode(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<OSFileStore> getFileStores(boolean paramBoolean) {
/* 128 */     ArrayList<OSFileStore> arrayList = getLocalVolumes(null);
/*     */ 
/*     */     
/* 131 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 132 */     for (OSFileStore oSFileStore : arrayList) {
/* 133 */       hashMap.put(oSFileStore.getMount(), oSFileStore);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 138 */     for (OSFileStore oSFileStore : getWmiVolumes(null, paramBoolean)) {
/* 139 */       if (hashMap.containsKey(oSFileStore.getMount())) {
/*     */ 
/*     */         
/* 142 */         OSFileStore oSFileStore1 = (OSFileStore)hashMap.get(oSFileStore.getMount());
/* 143 */         arrayList.remove(oSFileStore1);
/* 144 */         arrayList.add(new WindowsOSFileStore(oSFileStore.getName(), oSFileStore1.getVolume(), 
/* 145 */               oSFileStore1.getLabel().isEmpty() ? oSFileStore.getLabel() : oSFileStore1.getLabel(), oSFileStore1.getMount(), oSFileStore1
/* 146 */               .getOptions(), oSFileStore1.getUUID(), "", oSFileStore1.getDescription(), oSFileStore1.getType(), oSFileStore1
/* 147 */               .getFreeSpace(), oSFileStore1.getUsableSpace(), oSFileStore1.getTotalSpace(), 0L, 0L)); continue;
/* 148 */       }  if (!paramBoolean)
/*     */       {
/* 150 */         arrayList.add(oSFileStore);
/*     */       }
/*     */     } 
/* 153 */     return arrayList;
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
/*     */   static ArrayList<OSFileStore> getLocalVolumes(String paramString) {
/* 180 */     ArrayList<OSFileStore> arrayList = new ArrayList();
/* 181 */     char[] arrayOfChar = new char[255];
/*     */     
/* 183 */     WinNT.HANDLE hANDLE = Kernel32.INSTANCE.FindFirstVolume(arrayOfChar, 255);
/* 184 */     if (hANDLE == WinBase.INVALID_HANDLE_VALUE) {
/* 185 */       return arrayList;
/*     */     }
/*     */     
/*     */     try { while (true) {
/* 189 */         char[] arrayOfChar1 = new char[16];
/* 190 */         char[] arrayOfChar2 = new char[255];
/* 191 */         char[] arrayOfChar3 = new char[255];
/* 192 */         IntByReference intByReference = new IntByReference();
/*     */         
/* 194 */         WinNT.LARGE_INTEGER lARGE_INTEGER1 = new WinNT.LARGE_INTEGER(0L);
/* 195 */         WinNT.LARGE_INTEGER lARGE_INTEGER2 = new WinNT.LARGE_INTEGER(0L);
/* 196 */         WinNT.LARGE_INTEGER lARGE_INTEGER3 = new WinNT.LARGE_INTEGER(0L);
/*     */         
/* 198 */         String str1 = Native.toString(arrayOfChar);
/* 199 */         Kernel32.INSTANCE.GetVolumeInformation(str1, arrayOfChar2, 255, null, null, intByReference, arrayOfChar1, 16);
/* 200 */         int i = intByReference.getValue();
/* 201 */         Kernel32.INSTANCE.GetVolumePathNamesForVolumeName(str1, arrayOfChar3, 255, null);
/*     */         
/* 203 */         String str2 = Native.toString(arrayOfChar3);
/* 204 */         if (!str2.isEmpty() && (paramString == null || paramString.equals(str1))) {
/* 205 */           String str4 = Native.toString(arrayOfChar2);
/* 206 */           String str3 = Native.toString(arrayOfChar1);
/*     */           
/* 208 */           StringBuilder stringBuilder = new StringBuilder(((0x80000 & i) == 0) ? "rw" : "ro");
/*     */           
/* 210 */           String str5 = OPTIONS_MAP.entrySet().stream().filter(paramEntry -> ((((Integer)paramEntry.getKey()).intValue() & paramInt) > 0)).map(Map.Entry::getValue).collect(Collectors.joining(","));
/* 211 */           if (!str5.isEmpty()) {
/* 212 */             stringBuilder.append(',').append(str5);
/*     */           }
/* 214 */           Kernel32.INSTANCE.GetDiskFreeSpaceEx(str1, lARGE_INTEGER1, lARGE_INTEGER2, lARGE_INTEGER3);
/*     */           
/* 216 */           String str6 = ParseUtil.parseUuidOrDefault(str1, "");
/*     */           
/* 218 */           arrayList.add(new WindowsOSFileStore(String.format("%s (%s)", new Object[] { str4, str2 }), str1, str4, str2, stringBuilder
/* 219 */                 .toString(), str6, "", getDriveType(str2), str3, lARGE_INTEGER3
/* 220 */                 .getValue(), lARGE_INTEGER1.getValue(), lARGE_INTEGER2.getValue(), 0L, 0L));
/*     */         } 
/* 222 */         if (!Kernel32.INSTANCE.FindNextVolume(hANDLE, arrayOfChar, 255))
/* 223 */           return arrayList; 
/*     */       }  }
/* 225 */     finally { Kernel32.INSTANCE.FindVolumeClose(hANDLE); }
/*     */   
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
/*     */ 
/*     */ 
/*     */   
/*     */   static List<OSFileStore> getWmiVolumes(String paramString, boolean paramBoolean) {
/* 242 */     ArrayList<WindowsOSFileStore> arrayList = new ArrayList();
/* 243 */     WbemcliUtil.WmiResult wmiResult = Win32LogicalDisk.queryLogicalDisk(paramString, paramBoolean);
/* 244 */     for (byte b = 0; b < wmiResult.getResultCount(); b++) {
/* 245 */       String str5; long l1 = WmiUtil.getUint64(wmiResult, (Enum)Win32LogicalDisk.LogicalDiskProperty.FREESPACE, b);
/* 246 */       long l2 = WmiUtil.getUint64(wmiResult, (Enum)Win32LogicalDisk.LogicalDiskProperty.SIZE, b);
/* 247 */       String str1 = WmiUtil.getString(wmiResult, (Enum)Win32LogicalDisk.LogicalDiskProperty.DESCRIPTION, b);
/* 248 */       String str2 = WmiUtil.getString(wmiResult, (Enum)Win32LogicalDisk.LogicalDiskProperty.NAME, b);
/* 249 */       String str3 = WmiUtil.getString(wmiResult, (Enum)Win32LogicalDisk.LogicalDiskProperty.VOLUMENAME, b);
/* 250 */       String str4 = (WmiUtil.getUint16(wmiResult, (Enum)Win32LogicalDisk.LogicalDiskProperty.ACCESS, b) == 1) ? "ro" : "rw";
/* 251 */       int i = WmiUtil.getUint32(wmiResult, (Enum)Win32LogicalDisk.LogicalDiskProperty.DRIVETYPE, b);
/*     */       
/* 253 */       if (i != 4) {
/* 254 */         char[] arrayOfChar = new char[255];
/* 255 */         Kernel32.INSTANCE.GetVolumeNameForVolumeMountPoint(str2 + "\\", arrayOfChar, 255);
/* 256 */         str5 = Native.toString(arrayOfChar);
/*     */       } else {
/* 258 */         str5 = WmiUtil.getString(wmiResult, (Enum)Win32LogicalDisk.LogicalDiskProperty.PROVIDERNAME, b);
/* 259 */         String[] arrayOfString = str5.split("\\\\");
/* 260 */         if (arrayOfString.length > 1 && arrayOfString[arrayOfString.length - 1].length() > 0) {
/* 261 */           str1 = arrayOfString[arrayOfString.length - 1];
/*     */         }
/*     */       } 
/* 264 */       arrayList.add(new WindowsOSFileStore(String.format("%s (%s)", new Object[] { str1, str2 }), str5, str3, str2 + "\\", str4, "", "", 
/* 265 */             getDriveType(str2), WmiUtil.getString(wmiResult, (Enum)Win32LogicalDisk.LogicalDiskProperty.FILESYSTEM, b), l1, l1, l2, 0L, 0L));
/*     */     } 
/*     */     
/* 268 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getDriveType(String paramString) {
/* 279 */     switch (Kernel32.INSTANCE.GetDriveType(paramString)) {
/*     */       case 2:
/* 281 */         return "Removable drive";
/*     */       case 3:
/* 283 */         return "Fixed drive";
/*     */       case 4:
/* 285 */         return "Network drive";
/*     */       case 5:
/* 287 */         return "CD-ROM";
/*     */       case 6:
/* 289 */         return "RAM drive";
/*     */     } 
/* 291 */     return "Unknown drive type";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOpenFileDescriptors() {
/* 297 */     Map map = (Map)ProcessInformation.queryHandles().getB();
/* 298 */     List<Long> list = (List)map.get(ProcessInformation.HandleCountProperty.HANDLECOUNT);
/* 299 */     long l = 0L;
/* 300 */     if (list != null) {
/* 301 */       for (byte b = 0; b < list.size(); b++) {
/* 302 */         l += ((Long)list.get(b)).longValue();
/*     */       }
/*     */     }
/* 305 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxFileDescriptors() {
/* 310 */     return MAX_WINDOWS_HANDLES;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\windows\WindowsFileSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */