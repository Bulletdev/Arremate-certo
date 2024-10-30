/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.security.SecureRandom;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultTempFileCreationStrategy
/*     */   implements TempFileCreationStrategy
/*     */ {
/*     */   private static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
/*     */   static final String POIFILES = "poifiles";
/*     */   public static final String KEEP_FILES = "poi.keep.tmp.files";
/*  46 */   private static final SecureRandom random = new SecureRandom();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private File dir;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultTempFileCreationStrategy() {
/*  57 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultTempFileCreationStrategy(File paramFile) {
/*  68 */     this.dir = paramFile;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void createPOIFilesDirectory() throws IOException {
/*  74 */     if (this.dir == null) {
/*  75 */       String str = System.getProperty("java.io.tmpdir");
/*  76 */       if (str == null) {
/*  77 */         throw new IOException("Systems temporary directory not defined - set the -Djava.io.tmpdir jvm property!");
/*     */       }
/*  79 */       this.dir = new File(str, "poifiles");
/*     */     } 
/*     */     
/*  82 */     createTempDirectory(this.dir);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void createTempDirectory(File paramFile) throws IOException {
/*  92 */     if ((!paramFile.exists() && !paramFile.mkdirs()) || !paramFile.isDirectory()) {
/*  93 */       throw new IOException("Could not create temporary directory '" + paramFile + "'");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public File createTempFile(String paramString1, String paramString2) throws IOException {
/* 100 */     createPOIFilesDirectory();
/*     */ 
/*     */     
/* 103 */     File file = File.createTempFile(paramString1, paramString2, this.dir);
/*     */ 
/*     */     
/* 106 */     if (System.getProperty("poi.keep.tmp.files") == null) {
/* 107 */       file.deleteOnExit();
/*     */     }
/*     */ 
/*     */     
/* 111 */     return file;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File createTempDirectory(String paramString) throws IOException {
/* 118 */     createPOIFilesDirectory();
/*     */ 
/*     */ 
/*     */     
/* 122 */     long l = random.nextLong();
/* 123 */     File file = new File(this.dir, paramString + Long.toString(l));
/* 124 */     createTempDirectory(file);
/*     */ 
/*     */     
/* 127 */     if (System.getProperty("poi.keep.tmp.files") == null) {
/* 128 */       file.deleteOnExit();
/*     */     }
/*     */ 
/*     */     
/* 132 */     return file;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\DefaultTempFileCreationStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */