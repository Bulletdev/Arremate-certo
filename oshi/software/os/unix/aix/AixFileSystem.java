/*     */ package oshi.software.os.unix.aix;
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
/*     */ public class AixFileSystem
/*     */   extends AbstractFileSystem
/*     */ {
/*     */   public static final String OSHI_AIX_FS_PATH_EXCLUDES = "oshi.os.aix.filesystem.path.excludes";
/*     */   public static final String OSHI_AIX_FS_PATH_INCLUDES = "oshi.os.aix.filesystem.path.includes";
/*     */   public static final String OSHI_AIX_FS_VOLUME_EXCLUDES = "oshi.os.aix.filesystem.volume.excludes";
/*     */   public static final String OSHI_AIX_FS_VOLUME_INCLUDES = "oshi.os.aix.filesystem.volume.includes";
/*  54 */   private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.aix.filesystem.path.excludes");
/*     */   
/*  56 */   private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.aix.filesystem.path.includes");
/*     */   
/*  58 */   private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.aix.filesystem.volume.excludes");
/*     */   
/*  60 */   private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.aix.filesystem.volume.includes");
/*     */ 
/*     */   
/*     */   public List<OSFileStore> getFileStores(boolean paramBoolean) {
/*  64 */     return getFileStoreMatching((String)null, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   static List<OSFileStore> getFileStoreMatching(String paramString) {
/*  69 */     return getFileStoreMatching(paramString, false);
/*     */   }
/*     */   
/*     */   private static List<OSFileStore> getFileStoreMatching(String paramString, boolean paramBoolean) {
/*  73 */     ArrayList<AixOSFileStore> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  76 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  77 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  78 */     String str = "df -i" + (paramBoolean ? " -l" : "");
/*  79 */     for (String str1 : ExecutingCommand.runNative(str)) {
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
/*  93 */       if (str1.startsWith("/")) {
/*  94 */         String[] arrayOfString = ParseUtil.whitespaces.split(str1);
/*  95 */         if (arrayOfString.length > 5) {
/*  96 */           hashMap2.put(arrayOfString[0], Long.valueOf(ParseUtil.parseLongOrDefault(arrayOfString[1], 0L)));
/*  97 */           hashMap1.put(arrayOfString[0], Long.valueOf(ParseUtil.parseLongOrDefault(arrayOfString[3], 0L)));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 103 */     for (String str1 : ExecutingCommand.runNative("mount")) {
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
/* 119 */       String[] arrayOfString = ParseUtil.whitespaces.split("x" + str1);
/* 120 */       if (arrayOfString.length > 7) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 126 */         String str7, str2 = arrayOfString[1];
/* 127 */         String str3 = arrayOfString[2];
/* 128 */         String str4 = arrayOfString[3];
/* 129 */         String str5 = arrayOfString[4];
/*     */ 
/*     */         
/* 132 */         if ((paramBoolean && NETWORK_FS_TYPES.contains(str4)) || (!str3.equals("/") && (PSEUDO_FS_TYPES
/* 133 */           .contains(str4) || FileSystemUtil.isFileStoreExcluded(str3, str2, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES)))) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */         
/* 138 */         String str6 = str3.substring(str3.lastIndexOf('/') + 1);
/*     */         
/* 140 */         if (str6.isEmpty()) {
/* 141 */           str6 = str2.substring(str2.lastIndexOf('/') + 1);
/*     */         }
/*     */         
/* 144 */         if (paramString != null && !paramString.equals(str6)) {
/*     */           continue;
/*     */         }
/* 147 */         File file = new File(str3);
/* 148 */         long l1 = file.getTotalSpace();
/* 149 */         long l2 = file.getUsableSpace();
/* 150 */         long l3 = file.getFreeSpace();
/*     */ 
/*     */         
/* 153 */         if (str2.startsWith("/dev") || str3.equals("/")) {
/* 154 */           str7 = "Local Disk";
/* 155 */         } else if (str2.equals("tmpfs")) {
/* 156 */           str7 = "Ram Disk";
/* 157 */         } else if (NETWORK_FS_TYPES.contains(str4)) {
/* 158 */           str7 = "Network Disk";
/*     */         } else {
/* 160 */           str7 = "Mount Point";
/*     */         } 
/*     */         
/* 163 */         arrayList.add(new AixOSFileStore(str6, str2, str6, str3, str5, "", "", str7, str4, l3, l2, l1, ((Long)hashMap1
/* 164 */               .getOrDefault(str2, Long.valueOf(0L))).longValue(), ((Long)hashMap2
/* 165 */               .getOrDefault(str2, Long.valueOf(0L))).longValue()));
/*     */       } 
/*     */     } 
/* 168 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFileDescriptors() {
/* 173 */     boolean bool = false;
/* 174 */     long l = 0L;
/* 175 */     for (String str : ExecutingCommand.runNative("lsof -nl")) {
/* 176 */       if (!bool) {
/* 177 */         bool = str.startsWith("COMMAND"); continue;
/*     */       } 
/* 179 */       l++;
/*     */     } 
/*     */     
/* 182 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxFileDescriptors() {
/* 187 */     return ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("ulimit -n"), 0L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\aix\AixFileSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */