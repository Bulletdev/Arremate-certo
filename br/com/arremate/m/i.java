/*     */ package br.com.arremate.m;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.nio.file.CopyOption;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.StandardCopyOption;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class i
/*     */ {
/*  16 */   private static final Logger LOG = LoggerFactory.getLogger(i.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(File[] paramArrayOfFile, File paramFile) throws Exception {
/*  29 */     for (File file : paramArrayOfFile) {
/*  30 */       copyFile(file, paramFile);
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
/*     */   public static void copyFile(File paramFile1, File paramFile2) throws Exception {
/*  42 */     if (!paramFile2.isDirectory()) {
/*  43 */       throw new Exception("Destiny file isn't a directory");
/*     */     }
/*     */     
/*  46 */     File file = new File(String.join("", new CharSequence[] { paramFile2.getAbsolutePath(), File.separator, paramFile1.getName() }));
/*  47 */     LOG.info("Copying {} to {}", paramFile1.getName(), file.getAbsolutePath());
/*     */     
/*  49 */     if (file.isDirectory() && file.exists())
/*     */     {
/*  51 */       a(file.listFiles());
/*     */     }
/*     */     
/*  54 */     Files.copy(paramFile1.toPath(), file.toPath(), new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/*     */     
/*  56 */     if (file.isDirectory()) {
/*  57 */       a(paramFile1.listFiles(), file);
/*     */     }
/*     */     
/*  60 */     if (!a(paramFile1, file)) {
/*  61 */       throw new Exception(String.join("", new CharSequence[] { "Copy file ", file.getName(), " failed" }));
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
/*     */   public static boolean a(File paramFile1, File paramFile2) {
/*  74 */     if (!paramFile1.isDirectory()) {
/*  75 */       return paramFile2.exists();
/*     */     }
/*  77 */     return (paramFile2.exists() && (paramFile1.listFiles()).length == (paramFile2.listFiles()).length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(File[] paramArrayOfFile) throws Exception {
/*  87 */     for (File file : paramArrayOfFile) {
/*  88 */       a(file);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(File paramFile) throws Exception {
/*  99 */     if (!paramFile.exists()) {
/*     */       return;
/*     */     }
/*     */     
/* 103 */     if (paramFile.isDirectory()) {
/* 104 */       a(paramFile.listFiles());
/*     */     }
/*     */     
/* 107 */     if (!paramFile.delete()) {
/* 108 */       throw new Exception("Failed to delete file " + paramFile.getName());
/*     */     }
/* 110 */     LOG.info(paramFile.getAbsolutePath() + " deleted");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */