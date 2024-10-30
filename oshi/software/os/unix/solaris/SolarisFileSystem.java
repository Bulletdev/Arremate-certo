/*     */ package oshi.software.os.unix.solaris;
/*     */ 
/*     */ import com.sun.jna.platform.unix.solaris.LibKstat;
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
/*     */ import oshi.util.platform.unix.solaris.KstatUtil;
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
/*     */ public class SolarisFileSystem
/*     */   extends AbstractFileSystem
/*     */ {
/*     */   public static final String OSHI_SOLARIS_FS_PATH_EXCLUDES = "oshi.os.solaris.filesystem.path.excludes";
/*     */   public static final String OSHI_SOLARIS_FS_PATH_INCLUDES = "oshi.os.solaris.filesystem.path.includes";
/*     */   public static final String OSHI_SOLARIS_FS_VOLUME_EXCLUDES = "oshi.os.solaris.filesystem.volume.excludes";
/*     */   public static final String OSHI_SOLARIS_FS_VOLUME_INCLUDES = "oshi.os.solaris.filesystem.volume.includes";
/*  59 */   private static final List<PathMatcher> FS_PATH_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.solaris.filesystem.path.excludes");
/*     */   
/*  61 */   private static final List<PathMatcher> FS_PATH_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.solaris.filesystem.path.includes");
/*     */   
/*  63 */   private static final List<PathMatcher> FS_VOLUME_EXCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.solaris.filesystem.volume.excludes");
/*     */   
/*  65 */   private static final List<PathMatcher> FS_VOLUME_INCLUDES = FileSystemUtil.loadAndParseFileSystemConfig("oshi.os.solaris.filesystem.volume.includes");
/*     */ 
/*     */   
/*     */   public List<OSFileStore> getFileStores(boolean paramBoolean) {
/*  69 */     return getFileStoreMatching((String)null, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   static List<OSFileStore> getFileStoreMatching(String paramString) {
/*  74 */     return getFileStoreMatching(paramString, false);
/*     */   }
/*     */   
/*     */   private static List<OSFileStore> getFileStoreMatching(String paramString, boolean paramBoolean) {
/*  78 */     ArrayList<SolarisOSFileStore> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  81 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  82 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  83 */     String str1 = null;
/*  84 */     String str2 = null;
/*  85 */     String str3 = null;
/*  86 */     String str4 = "df -g" + (paramBoolean ? " -l" : "");
/*  87 */     for (String str : ExecutingCommand.runNative(str4)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  94 */       if (str.startsWith("/")) {
/*  95 */         str1 = ParseUtil.whitespaces.split(str)[0];
/*  96 */         str2 = null; continue;
/*  97 */       }  if (str.contains("available") && str.contains("total files")) {
/*  98 */         str2 = ParseUtil.getTextBetweenStrings(str, "available", "total files").trim(); continue;
/*  99 */       }  if (str.contains("free files")) {
/* 100 */         str3 = ParseUtil.getTextBetweenStrings(str, "", "free files").trim();
/* 101 */         if (str1 != null && str2 != null) {
/* 102 */           hashMap1.put(str1, Long.valueOf(ParseUtil.parseLongOrDefault(str3, 0L)));
/* 103 */           hashMap2.put(str1, Long.valueOf(ParseUtil.parseLongOrDefault(str2, 0L)));
/* 104 */           str1 = null;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 110 */     for (String str5 : ExecutingCommand.runNative("cat /etc/mnttab")) {
/* 111 */       String str11, arrayOfString[] = ParseUtil.whitespaces.split(str5);
/* 112 */       if (arrayOfString.length < 5) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 120 */       String str6 = arrayOfString[0];
/* 121 */       String str7 = arrayOfString[1];
/* 122 */       String str8 = arrayOfString[2];
/* 123 */       String str9 = arrayOfString[3];
/*     */ 
/*     */       
/* 126 */       if ((paramBoolean && NETWORK_FS_TYPES.contains(str8)) || (
/* 127 */         !str7.equals("/") && (PSEUDO_FS_TYPES.contains(str8) || FileSystemUtil.isFileStoreExcluded(str7, str6, FS_PATH_INCLUDES, FS_PATH_EXCLUDES, FS_VOLUME_INCLUDES, FS_VOLUME_EXCLUDES)))) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 132 */       String str10 = str7.substring(str7.lastIndexOf('/') + 1);
/*     */       
/* 134 */       if (str10.isEmpty()) {
/* 135 */         str10 = str6.substring(str6.lastIndexOf('/') + 1);
/*     */       }
/*     */       
/* 138 */       if (paramString != null && !paramString.equals(str10)) {
/*     */         continue;
/*     */       }
/* 141 */       File file = new File(str7);
/* 142 */       long l1 = file.getTotalSpace();
/* 143 */       long l2 = file.getUsableSpace();
/* 144 */       long l3 = file.getFreeSpace();
/*     */ 
/*     */       
/* 147 */       if (str6.startsWith("/dev") || str7.equals("/")) {
/* 148 */         str11 = "Local Disk";
/* 149 */       } else if (str6.equals("tmpfs")) {
/* 150 */         str11 = "Ram Disk";
/* 151 */       } else if (NETWORK_FS_TYPES.contains(str8)) {
/* 152 */         str11 = "Network Disk";
/*     */       } else {
/* 154 */         str11 = "Mount Point";
/*     */       } 
/*     */       
/* 157 */       arrayList.add(new SolarisOSFileStore(str10, str6, str10, str7, str9, "", "", str11, str8, l3, l2, l1, 
/* 158 */             hashMap1.containsKey(str7) ? ((Long)hashMap1.get(str7)).longValue() : 0L, 
/* 159 */             hashMap2.containsKey(str7) ? ((Long)hashMap2.get(str7)).longValue() : 0L));
/*     */     } 
/* 161 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFileDescriptors() {
/* 166 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/* 167 */     try { LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup(null, -1, "file_cache");
/*     */       
/* 169 */       if (kstat != null && KstatUtil.KstatChain.read(kstat))
/* 170 */       { long l = KstatUtil.dataLookupLong(kstat, "buf_inuse");
/*     */         
/* 172 */         if (kstatChain != null) kstatChain.close();  return l; }  if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/* 173 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxFileDescriptors() {
/* 178 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/* 179 */     try { LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup(null, -1, "file_cache");
/*     */       
/* 181 */       if (kstat != null && KstatUtil.KstatChain.read(kstat))
/* 182 */       { long l = KstatUtil.dataLookupLong(kstat, "buf_max");
/*     */         
/* 184 */         if (kstatChain != null) kstatChain.close();  return l; }  if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/* 185 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  return 0L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\solaris\SolarisFileSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */