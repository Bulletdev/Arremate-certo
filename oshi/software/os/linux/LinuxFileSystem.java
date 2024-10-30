/*     */ package oshi.software.os.linux;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.linux.LibC;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.PathMatcher;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.common.AbstractFileSystem;
/*     */ import oshi.software.os.OSFileStore;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FileSystemUtil;
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
/*     */ @ThreadSafe
/*     */ public class LinuxFileSystem
/*     */   extends AbstractFileSystem
/*     */ {
/*  61 */   private static final Logger LOG = LoggerFactory.getLogger(LinuxFileSystem.class);
/*     */   
/*     */   public static final String OSHI_LINUX_FS_PATH_EXCLUDES = "oshi.os.linux.filesystem.path.excludes";
/*     */   
/*     */   public static final String OSHI_LINUX_FS_PATH_INCLUDES = "oshi.os.linux.filesystem.path.includes";
/*     */   
/*     */   public static final String OSHI_LINUX_FS_VOLUME_EXCLUDES = "oshi.os.linux.filesystem.volume.excludes";
/*     */   public static final String OSHI_LINUX_FS_VOLUME_INCLUDES = "oshi.os.linux.filesystem.volume.includes";
/*  69 */   private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.linux.filesystem.path.excludes");
/*     */   
/*  71 */   private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.linux.filesystem.path.includes");
/*     */   
/*  73 */   private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.linux.filesystem.volume.excludes");
/*     */   
/*  75 */   private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.linux.filesystem.volume.includes");
/*     */ 
/*     */   
/*     */   private static final String UNICODE_SPACE = "\\040";
/*     */ 
/*     */   
/*     */   public List<OSFileStore> getFileStores(boolean paramBoolean) {
/*  82 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  83 */     File file1 = new File("/dev/mapper");
/*  84 */     File[] arrayOfFile1 = file1.listFiles();
/*  85 */     if (arrayOfFile1 != null) {
/*  86 */       for (File file : arrayOfFile1) {
/*     */         try {
/*  88 */           hashMap1.put(file.getCanonicalPath(), file.getAbsolutePath());
/*  89 */         } catch (IOException iOException) {
/*  90 */           LOG.error("Couldn't get canonical path for {}. {}", file.getName(), iOException.getMessage());
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*  95 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  96 */     File file2 = new File("/dev/disk/by-uuid");
/*  97 */     File[] arrayOfFile2 = file2.listFiles();
/*  98 */     if (arrayOfFile2 != null) {
/*  99 */       for (File file : arrayOfFile2) {
/*     */         
/*     */         try {
/* 102 */           String str = file.getCanonicalPath();
/* 103 */           hashMap2.put(str, file.getName().toLowerCase());
/* 104 */           if (hashMap1.containsKey(str)) {
/* 105 */             hashMap2.put(hashMap1.get(str), file.getName().toLowerCase());
/*     */           }
/* 107 */         } catch (IOException iOException) {
/* 108 */           LOG.error("Couldn't get canonical path for {}. {}", file.getName(), iOException.getMessage());
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 114 */     return getFileStoreMatching((String)null, (Map)hashMap2, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   static List<OSFileStore> getFileStoreMatching(String paramString, Map<String, String> paramMap) {
/* 119 */     return getFileStoreMatching(paramString, paramMap, false);
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<OSFileStore> getFileStoreMatching(String paramString, Map<String, String> paramMap, boolean paramBoolean) {
/* 124 */     ArrayList<LinuxOSFileStore> arrayList = new ArrayList();
/*     */     
/* 126 */     Map<String, String> map = queryLabelMap();
/*     */ 
/*     */     
/* 129 */     List list = FileUtil.readFile(ProcPath.MOUNTS);
/* 130 */     for (String str1 : list) {
/* 131 */       String str8, arrayOfString[] = str1.split(" ");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       if (arrayOfString.length < 6) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 144 */       String str2 = arrayOfString[0].replace("\\040", " ");
/* 145 */       String str3 = str2;
/* 146 */       String str4 = arrayOfString[1].replace("\\040", " ");
/* 147 */       if (str4.equals("/")) {
/* 148 */         str3 = "/";
/*     */       }
/* 150 */       String str5 = arrayOfString[2];
/*     */ 
/*     */       
/* 153 */       if ((paramBoolean && NETWORK_FS_TYPES.contains(str5)) || (
/* 154 */         !str4.equals("/") && (PSEUDO_FS_TYPES.contains(str5) || FileSystemUtil.isFileStoreExcluded(str4, str2, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES)))) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 159 */       String str6 = arrayOfString[3];
/*     */ 
/*     */       
/* 162 */       if (paramString != null && !paramString.equals(str3)) {
/*     */         continue;
/*     */       }
/*     */       
/* 166 */       String str7 = (paramMap != null) ? paramMap.getOrDefault(arrayOfString[0], "") : "";
/*     */ 
/*     */       
/* 169 */       if (str2.startsWith("/dev")) {
/* 170 */         str8 = "Local Disk";
/* 171 */       } else if (str2.equals("tmpfs")) {
/* 172 */         str8 = "Ram Disk";
/* 173 */       } else if (NETWORK_FS_TYPES.contains(str5)) {
/* 174 */         str8 = "Network Disk";
/*     */       } else {
/* 176 */         str8 = "Mount Point";
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 181 */       String str9 = "";
/* 182 */       String str10 = "/dev/mapper/";
/* 183 */       Path path = Paths.get(str2, new String[0]);
/* 184 */       if (path.toFile().exists() && Files.isSymbolicLink(path)) {
/*     */         try {
/* 186 */           Path path1 = Files.readSymbolicLink(path);
/* 187 */           Path path2 = Paths.get(str10 + path1.toString(), new String[0]);
/* 188 */           if (path2.toFile().exists()) {
/* 189 */             str9 = path2.normalize().toString();
/*     */           }
/* 191 */         } catch (IOException iOException) {
/* 192 */           LOG.warn("Couldn't access symbolic path  {}. {}", path, iOException.getMessage());
/*     */         } 
/*     */       }
/*     */       
/* 196 */       long l1 = 0L;
/* 197 */       long l2 = 0L;
/* 198 */       long l3 = 0L;
/* 199 */       long l4 = 0L;
/* 200 */       long l5 = 0L;
/*     */       
/*     */       try {
/* 203 */         LibC.Statvfs statvfs = new LibC.Statvfs();
/* 204 */         if (0 == LibC.INSTANCE.statvfs(str4, statvfs)) {
/* 205 */           l1 = statvfs.f_files.longValue();
/* 206 */           l2 = statvfs.f_ffree.longValue();
/*     */           
/* 208 */           l3 = statvfs.f_blocks.longValue() * statvfs.f_frsize.longValue();
/* 209 */           l4 = statvfs.f_bavail.longValue() * statvfs.f_frsize.longValue();
/* 210 */           l5 = statvfs.f_bfree.longValue() * statvfs.f_frsize.longValue();
/*     */         } else {
/* 212 */           LOG.warn("Failed to get information to use statvfs. path: {}, Error code: {}", str4, 
/* 213 */               Integer.valueOf(Native.getLastError()));
/*     */         } 
/* 215 */       } catch (UnsatisfiedLinkError|NoClassDefFoundError unsatisfiedLinkError) {
/* 216 */         LOG.error("Failed to get file counts from statvfs. {}", unsatisfiedLinkError.getMessage());
/*     */       } 
/*     */       
/* 219 */       if (l3 == 0L) {
/* 220 */         File file = new File(str4);
/* 221 */         l3 = file.getTotalSpace();
/* 222 */         l4 = file.getUsableSpace();
/* 223 */         l5 = file.getFreeSpace();
/*     */       } 
/*     */       
/* 226 */       arrayList.add(new LinuxOSFileStore(str3, str2, map.getOrDefault(str4, str3), str4, str6, str7, str9, str8, str5, l5, l4, l3, l2, l1));
/*     */     } 
/*     */     
/* 229 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private static Map<String, String> queryLabelMap() {
/* 233 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 234 */     for (String str : ExecutingCommand.runNative("lsblk -o mountpoint,label")) {
/* 235 */       String[] arrayOfString = ParseUtil.whitespaces.split(str, 2);
/* 236 */       if (arrayOfString.length == 2) {
/* 237 */         hashMap.put(arrayOfString[0], arrayOfString[1]);
/*     */       }
/*     */     } 
/* 240 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFileDescriptors() {
/* 245 */     return getFileDescriptors(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxFileDescriptors() {
/* 250 */     return getFileDescriptors(2);
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
/*     */   private static long getFileDescriptors(int paramInt) {
/* 265 */     String str = ProcPath.SYS_FS_FILE_NR;
/* 266 */     if (paramInt < 0 || paramInt > 2) {
/* 267 */       throw new IllegalArgumentException("Index must be between 0 and 2.");
/*     */     }
/* 269 */     List<String> list = FileUtil.readFile(str);
/* 270 */     if (!list.isEmpty()) {
/* 271 */       String[] arrayOfString = ((String)list.get(0)).split("\\D+");
/* 272 */       return ParseUtil.parseLongOrDefault(arrayOfString[paramInt], 0L);
/*     */     } 
/* 274 */     return 0L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\linux\LinuxFileSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */