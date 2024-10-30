/*    */ package org.apache.http.impl.io;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import org.apache.http.io.SessionOutputBuffer;
/*    */ import org.apache.http.util.Args;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IdentityOutputStream
/*    */   extends OutputStream
/*    */ {
/*    */   private final SessionOutputBuffer out;
/*    */   private boolean closed = false;
/*    */   
/*    */   public IdentityOutputStream(SessionOutputBuffer paramSessionOutputBuffer) {
/* 60 */     this.out = (SessionOutputBuffer)Args.notNull(paramSessionOutputBuffer, "Session output buffer");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 70 */     if (!this.closed) {
/* 71 */       this.closed = true;
/* 72 */       this.out.flush();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void flush() throws IOException {
/* 78 */     this.out.flush();
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 83 */     if (this.closed) {
/* 84 */       throw new IOException("Attempted write to closed stream.");
/*    */     }
/* 86 */     this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte) throws IOException {
/* 91 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int paramInt) throws IOException {
/* 96 */     if (this.closed) {
/* 97 */       throw new IOException("Attempted write to closed stream.");
/*    */     }
/* 99 */     this.out.write(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\IdentityOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */