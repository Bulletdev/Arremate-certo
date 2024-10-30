/*    */ package ch.qos.logback.core.recovery;
/*    */ 
/*    */ import java.io.BufferedOutputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.nio.channels.FileChannel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ResilientFileOutputStream
/*    */   extends ResilientOutputStreamBase
/*    */ {
/*    */   private File file;
/*    */   private FileOutputStream fos;
/*    */   
/*    */   public ResilientFileOutputStream(File paramFile, boolean paramBoolean, long paramLong) throws FileNotFoundException {
/* 25 */     this.file = paramFile;
/* 26 */     this.fos = new FileOutputStream(paramFile, paramBoolean);
/* 27 */     this.os = new BufferedOutputStream(this.fos, (int)paramLong);
/* 28 */     this.presumedClean = true;
/*    */   }
/*    */   
/*    */   public FileChannel getChannel() {
/* 32 */     if (this.os == null) {
/* 33 */       return null;
/*    */     }
/* 35 */     return this.fos.getChannel();
/*    */   }
/*    */   
/*    */   public File getFile() {
/* 39 */     return this.file;
/*    */   }
/*    */ 
/*    */   
/*    */   String getDescription() {
/* 44 */     return "file [" + this.file + "]";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   OutputStream openNewOutputStream() throws IOException {
/* 50 */     this.fos = new FileOutputStream(this.file, true);
/* 51 */     return new BufferedOutputStream(this.fos);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 56 */     return "c.q.l.c.recovery.ResilientFileOutputStream@" + System.identityHashCode(this);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\recovery\ResilientFileOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */