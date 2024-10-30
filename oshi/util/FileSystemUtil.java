/*     */ package oshi.util;
/*     */ 
/*     */ import java.nio.file.FileSystem;
/*     */ import java.nio.file.FileSystems;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.PathMatcher;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
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
/*     */ public final class FileSystemUtil
/*     */ {
/*     */   private static final String GLOB_PREFIX = "glob:";
/*     */   private static final String REGEX_PREFIX = "regex:";
/*     */   
/*     */   public static boolean isFileStoreExcluded(String paramString1, String paramString2, List<PathMatcher> paramList1, List<PathMatcher> paramList2, List<PathMatcher> paramList3, List<PathMatcher> paramList4) {
/*  73 */     Path path1 = Paths.get(paramString1, new String[0]);
/*  74 */     Path path2 = Paths.get(paramString2, new String[0]);
/*  75 */     if (matches(path1, paramList1) || matches(path2, paramList3)) {
/*  76 */       return false;
/*     */     }
/*  78 */     return (matches(path1, paramList2) || matches(path2, paramList4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<PathMatcher> loadAndParseFileSystemConfig(String paramString) {
/*  89 */     String str = GlobalConfig.get(paramString, "");
/*  90 */     return parseFileSystemConfig(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<PathMatcher> parseFileSystemConfig(String paramString) {
/* 101 */     FileSystem fileSystem = FileSystems.getDefault();
/* 102 */     ArrayList<PathMatcher> arrayList = new ArrayList();
/* 103 */     for (String str : paramString.split(",")) {
/* 104 */       if (str.length() > 0) {
/*     */ 
/*     */         
/* 107 */         if (!str.startsWith("glob:") && !str.startsWith("regex:")) {
/* 108 */           str = "glob:" + str;
/*     */         }
/* 110 */         arrayList.add(fileSystem.getPathMatcher(str));
/*     */       } 
/*     */     } 
/* 113 */     return arrayList;
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
/*     */   public static boolean matches(Path paramPath, List<PathMatcher> paramList) {
/* 129 */     for (PathMatcher pathMatcher : paramList) {
/* 130 */       if (pathMatcher.matches(paramPath)) {
/* 131 */         return true;
/*     */       }
/*     */     } 
/* 134 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\FileSystemUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */