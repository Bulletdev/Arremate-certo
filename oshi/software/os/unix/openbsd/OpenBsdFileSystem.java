/*     */ package oshi.software.os.unix.openbsd;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.nio.file.PathMatcher;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.common.AbstractFileSystem;
/*     */ import oshi.software.os.OSFileStore;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FileSystemUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.openbsd.OpenBsdSysctlUtil;
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
/*     */ public class OpenBsdFileSystem
/*     */   extends AbstractFileSystem
/*     */ {
/*     */   public static final String OSHI_OPENBSD_FS_PATH_EXCLUDES = "oshi.os.openbsd.filesystem.path.excludes";
/*     */   public static final String OSHI_OPENBSD_FS_PATH_INCLUDES = "oshi.os.openbsd.filesystem.path.includes";
/*     */   public static final String OSHI_OPENBSD_FS_VOLUME_EXCLUDES = "oshi.os.openbsd.filesystem.volume.excludes";
/*     */   public static final String OSHI_OPENBSD_FS_VOLUME_INCLUDES = "oshi.os.openbsd.filesystem.volume.includes";
/*  55 */   private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.openbsd.filesystem.path.excludes");
/*     */   
/*  57 */   private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.openbsd.filesystem.path.includes");
/*     */   
/*  59 */   private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.openbsd.filesystem.volume.excludes");
/*     */   
/*  61 */   private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.openbsd.filesystem.volume.includes");
/*     */ 
/*     */   
/*     */   public List<OSFileStore> getFileStores(boolean paramBoolean) {
/*  65 */     return getFileStoreMatching((String)null, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   static List<OSFileStore> getFileStoreMatching(String paramString) {
/*  70 */     return getFileStoreMatching(paramString, false);
/*     */   }
/*     */   
/*     */   private static List<OSFileStore> getFileStoreMatching(String paramString, boolean paramBoolean) {
/*  74 */     ArrayList<OpenBsdOSFileStore> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  77 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  78 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  79 */     String str = "df -i" + (paramBoolean ? " -l" : "");
/*  80 */     for (String str1 : ExecutingCommand.runNative(str)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  88 */       if (str1.startsWith("/")) {
/*  89 */         String[] arrayOfString = ParseUtil.whitespaces.split(str1);
/*  90 */         if (arrayOfString.length > 6) {
/*  91 */           hashMap2.put(arrayOfString[0], Long.valueOf(ParseUtil.parseLongOrDefault(arrayOfString[5], 0L)));
/*  92 */           hashMap1.put(arrayOfString[0], Long.valueOf(ParseUtil.parseLongOrDefault(arrayOfString[6], 0L)));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  98 */     for (String str1 : ExecutingCommand.runNative("mount -v")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 105 */       String[] arrayOfString = ParseUtil.whitespaces.split(str1, 7);
/* 106 */       if (arrayOfString.length == 7) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 112 */         String str8, str2 = arrayOfString[0];
/* 113 */         String str3 = arrayOfString[1];
/* 114 */         String str4 = arrayOfString[3];
/* 115 */         String str5 = arrayOfString[5];
/* 116 */         String str6 = arrayOfString[6];
/*     */ 
/*     */         
/* 119 */         if ((paramBoolean && NETWORK_FS_TYPES.contains(str5)) || (!str4.equals("/") && (PSEUDO_FS_TYPES
/* 120 */           .contains(str5) || FileSystemUtil.isFileStoreExcluded(str4, str2, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES)))) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */         
/* 125 */         String str7 = str4.substring(str4.lastIndexOf('/') + 1);
/*     */         
/* 127 */         if (str7.isEmpty()) {
/* 128 */           str7 = str2.substring(str2.lastIndexOf('/') + 1);
/*     */         }
/*     */         
/* 131 */         if (paramString != null && !paramString.equals(str7)) {
/*     */           continue;
/*     */         }
/* 134 */         File file = new File(str4);
/* 135 */         long l1 = file.getTotalSpace();
/* 136 */         long l2 = file.getUsableSpace();
/* 137 */         long l3 = file.getFreeSpace();
/*     */ 
/*     */         
/* 140 */         if (str2.startsWith("/dev") || str4.equals("/")) {
/* 141 */           str8 = "Local Disk";
/* 142 */         } else if (str2.equals("tmpfs")) {
/*     */           
/* 144 */           str8 = "Ram Disk (dynamic)";
/* 145 */         } else if (str2.equals("mfs")) {
/*     */           
/* 147 */           str8 = "Ram Disk (fixed)";
/* 148 */         } else if (NETWORK_FS_TYPES.contains(str5)) {
/* 149 */           str8 = "Network Disk";
/*     */         } else {
/* 151 */           str8 = "Mount Point";
/*     */         } 
/*     */         
/* 154 */         arrayList.add(new OpenBsdOSFileStore(str7, str2, str7, str4, str6, str3, "", str8, str5, l3, l2, l1, ((Long)hashMap1
/* 155 */               .getOrDefault(str2, Long.valueOf(0L))).longValue(), ((Long)hashMap2
/* 156 */               .getOrDefault(str2, Long.valueOf(0L))).longValue() + ((Long)hashMap1.getOrDefault(str2, Long.valueOf(0L))).longValue()));
/*     */       } 
/*     */     } 
/* 159 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFileDescriptors() {
/* 164 */     return OpenBsdSysctlUtil.sysctl("kern.nfiles", 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxFileDescriptors() {
/* 169 */     return OpenBsdSysctlUtil.sysctl("kern.maxfiles", 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\openbsd\OpenBsdFileSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */