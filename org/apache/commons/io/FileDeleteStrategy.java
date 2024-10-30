/*     */ package org.apache.commons.io;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileDeleteStrategy
/*     */ {
/*     */   static class ForceFileDeleteStrategy
/*     */     extends FileDeleteStrategy
/*     */   {
/*     */     ForceFileDeleteStrategy() {
/*  43 */       super("Force");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean doDelete(File param1File) throws IOException {
/*  60 */       FileUtils.forceDelete(param1File);
/*  61 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy("Normal");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  75 */   public static final FileDeleteStrategy FORCE = new ForceFileDeleteStrategy();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FileDeleteStrategy(String paramString) {
/*  86 */     this.name = paramString;
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
/*     */   public void delete(File paramFile) throws IOException {
/* 101 */     if (paramFile.exists() && !doDelete(paramFile)) {
/* 102 */       throw new IOException("Deletion failed: " + paramFile);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean deleteQuietly(File paramFile) {
/* 118 */     if (paramFile == null || !paramFile.exists()) {
/* 119 */       return true;
/*     */     }
/*     */     try {
/* 122 */       return doDelete(paramFile);
/* 123 */     } catch (IOException iOException) {
/* 124 */       return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean doDelete(File paramFile) throws IOException {
/* 147 */     return paramFile.delete();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 157 */     return "FileDeleteStrategy[" + this.name + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\FileDeleteStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */