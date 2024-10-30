/*     */ package oshi.software.os.unix.freebsd;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.nio.file.PathMatcher;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.common.AbstractFileSystem;
/*     */ import oshi.software.os.OSFileStore;
/*     */ import oshi.software.os.linux.LinuxOSFileStore;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FileSystemUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
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
/*     */ public final class FreeBsdFileSystem
/*     */   extends AbstractFileSystem
/*     */ {
/*     */   public static final String OSHI_FREEBSD_FS_PATH_EXCLUDES = "oshi.os.freebsd.filesystem.path.excludes";
/*     */   public static final String OSHI_FREEBSD_FS_PATH_INCLUDES = "oshi.os.freebsd.filesystem.path.includes";
/*     */   public static final String OSHI_FREEBSD_FS_VOLUME_EXCLUDES = "oshi.os.freebsd.filesystem.volume.excludes";
/*     */   public static final String OSHI_FREEBSD_FS_VOLUME_INCLUDES = "oshi.os.freebsd.filesystem.volume.includes";
/*  56 */   private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.freebsd.filesystem.path.excludes");
/*     */   
/*  58 */   private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.freebsd.filesystem.path.includes");
/*     */   
/*  60 */   private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.freebsd.filesystem.volume.excludes");
/*     */   
/*  62 */   private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.freebsd.filesystem.volume.includes");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<OSFileStore> getFileStores(boolean paramBoolean) {
/*  68 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*     */     
/*  70 */     String str = "";
/*  71 */     for (String str1 : ExecutingCommand.runNative("geom part list")) {
/*  72 */       if (str1.contains("Name: ")) {
/*  73 */         str = str1.substring(str1.lastIndexOf(' ') + 1);
/*     */       }
/*     */       
/*  76 */       if (str.isEmpty()) {
/*     */         continue;
/*     */       }
/*  79 */       str1 = str1.trim();
/*  80 */       if (str1.startsWith("rawuuid:")) {
/*  81 */         hashMap1.put(str, str1.substring(str1.lastIndexOf(' ') + 1));
/*  82 */         str = "";
/*     */       } 
/*     */     } 
/*     */     
/*  86 */     ArrayList<LinuxOSFileStore> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  89 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  90 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/*  91 */     for (String str1 : ExecutingCommand.runNative("df -i")) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  96 */       if (str1.startsWith("/")) {
/*  97 */         String[] arrayOfString = ParseUtil.whitespaces.split(str1);
/*  98 */         if (arrayOfString.length > 7) {
/*  99 */           hashMap2.put(arrayOfString[0], Long.valueOf(ParseUtil.parseLongOrDefault(arrayOfString[6], 0L)));
/*     */           
/* 101 */           hashMap3.put(arrayOfString[0], 
/* 102 */               Long.valueOf(((Long)hashMap2.get(arrayOfString[0])).longValue() + ParseUtil.parseLongOrDefault(arrayOfString[5], 0L)));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 108 */     for (String str1 : ExecutingCommand.runNative("mount -p")) {
/* 109 */       String str7, arrayOfString[] = ParseUtil.whitespaces.split(str1);
/* 110 */       if (arrayOfString.length < 5) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 118 */       String str2 = arrayOfString[0];
/* 119 */       String str3 = arrayOfString[1];
/* 120 */       String str4 = arrayOfString[2];
/* 121 */       String str5 = arrayOfString[3];
/*     */ 
/*     */       
/* 124 */       if ((paramBoolean && NETWORK_FS_TYPES.contains(str4)) || (
/* 125 */         !str3.equals("/") && (PSEUDO_FS_TYPES.contains(str4) || FileSystemUtil.isFileStoreExcluded(str3, str2, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES)))) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 130 */       String str6 = str3.substring(str3.lastIndexOf('/') + 1);
/*     */       
/* 132 */       if (str6.isEmpty()) {
/* 133 */         str6 = str2.substring(str2.lastIndexOf('/') + 1);
/*     */       }
/* 135 */       File file = new File(str3);
/* 136 */       long l1 = file.getTotalSpace();
/* 137 */       long l2 = file.getUsableSpace();
/* 138 */       long l3 = file.getFreeSpace();
/*     */ 
/*     */       
/* 141 */       if (str2.startsWith("/dev") || str3.equals("/")) {
/* 142 */         str7 = "Local Disk";
/* 143 */       } else if (str2.equals("tmpfs")) {
/* 144 */         str7 = "Ram Disk";
/* 145 */       } else if (NETWORK_FS_TYPES.contains(str4)) {
/* 146 */         str7 = "Network Disk";
/*     */       } else {
/* 148 */         str7 = "Mount Point";
/*     */       } 
/*     */       
/* 151 */       String str8 = (String)hashMap1.getOrDefault(str6, "");
/*     */       
/* 153 */       arrayList.add(new LinuxOSFileStore(str6, str2, str6, str3, str5, str8, "", str7, str4, l3, l2, l1, 
/* 154 */             hashMap2.containsKey(str3) ? ((Long)hashMap2.get(str3)).longValue() : 0L, 
/* 155 */             hashMap3.containsKey(str3) ? ((Long)hashMap3.get(str3)).longValue() : 0L));
/*     */     } 
/* 157 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFileDescriptors() {
/* 162 */     return BsdSysctlUtil.sysctl("kern.openfiles", 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxFileDescriptors() {
/* 167 */     return BsdSysctlUtil.sysctl("kern.maxfiles", 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\freebsd\FreeBsdFileSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */