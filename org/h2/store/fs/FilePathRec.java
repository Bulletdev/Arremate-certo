/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.channels.FileChannel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FilePathRec
/*     */   extends FilePathWrapper
/*     */ {
/*  19 */   private static final FilePathRec INSTANCE = new FilePathRec();
/*     */ 
/*     */   
/*     */   private static Recorder recorder;
/*     */ 
/*     */   
/*     */   private boolean trace;
/*     */ 
/*     */   
/*     */   public static void register() {
/*  29 */     FilePath.register(INSTANCE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setRecorder(Recorder paramRecorder) {
/*  38 */     recorder = paramRecorder;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean createFile() {
/*  43 */     log(2, this.name);
/*  44 */     return super.createFile();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FilePath createTempFile(String paramString, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
/*  50 */     log(3, unwrap(this.name) + ":" + paramString + ":" + paramBoolean1 + ":" + paramBoolean2);
/*     */     
/*  52 */     return super.createTempFile(paramString, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete() {
/*  57 */     log(4, this.name);
/*  58 */     super.delete();
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel open(String paramString) throws IOException {
/*  63 */     return new FileRec(this, super.open(paramString), this.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputStream newOutputStream(boolean paramBoolean) throws IOException {
/*  68 */     log(5, this.name);
/*  69 */     return super.newOutputStream(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveTo(FilePath paramFilePath, boolean paramBoolean) {
/*  74 */     log(6, unwrap(this.name) + ":" + unwrap(paramFilePath.name));
/*  75 */     super.moveTo(paramFilePath, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isTrace() {
/*  79 */     return this.trace;
/*     */   }
/*     */   
/*     */   public void setTrace(boolean paramBoolean) {
/*  83 */     this.trace = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void log(int paramInt, String paramString) {
/*  93 */     log(paramInt, paramString, (byte[])null, 0L);
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
/*     */   void log(int paramInt, String paramString, byte[] paramArrayOfbyte, long paramLong) {
/* 105 */     if (recorder != null) {
/* 106 */       recorder.log(paramInt, paramString, paramArrayOfbyte, paramLong);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getScheme() {
/* 117 */     return "rec";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FilePathRec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */