/*     */ package ch.qos.logback.core.rolling.helper;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FilenameFilter;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileFilterUtil
/*     */ {
/*     */   public static void sortFileArrayByName(File[] paramArrayOfFile) {
/*  26 */     Arrays.sort(paramArrayOfFile, new Comparator<File>() {
/*     */           public int compare(File param1File1, File param1File2) {
/*  28 */             String str1 = param1File1.getName();
/*  29 */             String str2 = param1File2.getName();
/*  30 */             return str1.compareTo(str2);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static void reverseSortFileArrayByName(File[] paramArrayOfFile) {
/*  36 */     Arrays.sort(paramArrayOfFile, new Comparator<File>() {
/*     */           public int compare(File param1File1, File param1File2) {
/*  38 */             String str1 = param1File1.getName();
/*  39 */             String str2 = param1File2.getName();
/*  40 */             return str2.compareTo(str1);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static String afterLastSlash(String paramString) {
/*  46 */     int i = paramString.lastIndexOf('/');
/*  47 */     if (i == -1) {
/*  48 */       return paramString;
/*     */     }
/*  50 */     return paramString.substring(i + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isEmptyDirectory(File paramFile) {
/*  55 */     if (!paramFile.isDirectory()) {
/*  56 */       throw new IllegalArgumentException("[" + paramFile + "] must be a directory");
/*     */     }
/*  58 */     String[] arrayOfString = paramFile.list();
/*  59 */     if (arrayOfString == null || arrayOfString.length == 0) {
/*  60 */       return true;
/*     */     }
/*  62 */     return false;
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
/*     */   public static File[] filesInFolderMatchingStemRegex(File paramFile, String paramString) {
/*  76 */     if (paramFile == null) {
/*  77 */       return new File[0];
/*     */     }
/*  79 */     if (!paramFile.exists() || !paramFile.isDirectory()) {
/*  80 */       return new File[0];
/*     */     }
/*  82 */     return paramFile.listFiles(new FilenameFilter(paramString) {
/*     */           public boolean accept(File param1File, String param1String) {
/*  84 */             return param1String.matches(this.gq);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static int findHighestCounter(File[] paramArrayOfFile, String paramString) {
/*  90 */     int i = Integer.MIN_VALUE;
/*  91 */     for (File file : paramArrayOfFile) {
/*  92 */       int j = extractCounter(file, paramString);
/*  93 */       if (i < j)
/*  94 */         i = j; 
/*     */     } 
/*  96 */     return i;
/*     */   }
/*     */   
/*     */   public static int extractCounter(File paramFile, String paramString) {
/* 100 */     Pattern pattern = Pattern.compile(paramString);
/* 101 */     String str1 = paramFile.getName();
/*     */     
/* 103 */     Matcher matcher = pattern.matcher(str1);
/* 104 */     if (!matcher.matches()) {
/* 105 */       throw new IllegalStateException("The regex [" + paramString + "] should match [" + str1 + "]");
/*     */     }
/* 107 */     String str2 = matcher.group(1);
/* 108 */     return (new Integer(str2)).intValue();
/*     */   }
/*     */   
/*     */   public static String slashify(String paramString) {
/* 112 */     return paramString.replace('\\', '/');
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removeEmptyParentDirectories(File paramFile, int paramInt) {
/* 117 */     if (paramInt >= 3) {
/*     */       return;
/*     */     }
/* 120 */     File file = paramFile.getParentFile();
/* 121 */     if (file.isDirectory() && isEmptyDirectory(file)) {
/* 122 */       file.delete();
/* 123 */       removeEmptyParentDirectories(file, paramInt + 1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\FileFilterUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */