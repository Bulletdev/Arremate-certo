/*    */ package org.apache.http.impl.conn;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
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
/*    */ class LoggingOutputStream
/*    */   extends OutputStream
/*    */ {
/*    */   private final OutputStream out;
/*    */   private final Wire wire;
/*    */   
/*    */   public LoggingOutputStream(OutputStream paramOutputStream, Wire paramWire) {
/* 45 */     this.out = paramOutputStream;
/* 46 */     this.wire = paramWire;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int paramInt) throws IOException {
/*    */     try {
/* 52 */       this.wire.output(paramInt);
/* 53 */     } catch (IOException iOException) {
/* 54 */       this.wire.output("[write] I/O error: " + iOException.getMessage());
/* 55 */       throw iOException;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte) throws IOException {
/*    */     try {
/* 62 */       this.wire.output(paramArrayOfbyte);
/* 63 */       this.out.write(paramArrayOfbyte);
/* 64 */     } catch (IOException iOException) {
/* 65 */       this.wire.output("[write] I/O error: " + iOException.getMessage());
/* 66 */       throw iOException;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*    */     try {
/* 73 */       this.wire.output(paramArrayOfbyte, paramInt1, paramInt2);
/* 74 */       this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
/* 75 */     } catch (IOException iOException) {
/* 76 */       this.wire.output("[write] I/O error: " + iOException.getMessage());
/* 77 */       throw iOException;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void flush() throws IOException {
/*    */     try {
/* 84 */       this.out.flush();
/* 85 */     } catch (IOException iOException) {
/* 86 */       this.wire.output("[flush] I/O error: " + iOException.getMessage());
/* 87 */       throw iOException;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/*    */     try {
/* 94 */       this.out.close();
/* 95 */     } catch (IOException iOException) {
/* 96 */       this.wire.output("[close] I/O error: " + iOException.getMessage());
/* 97 */       throw iOException;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\LoggingOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */