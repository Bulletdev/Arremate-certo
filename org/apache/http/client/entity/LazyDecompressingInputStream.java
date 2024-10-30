/*    */ package org.apache.http.client.entity;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
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
/*    */ class LazyDecompressingInputStream
/*    */   extends InputStream
/*    */ {
/*    */   private final InputStream wrappedStream;
/*    */   private final InputStreamFactory inputStreamFactory;
/*    */   private InputStream wrapperStream;
/*    */   
/*    */   public LazyDecompressingInputStream(InputStream paramInputStream, InputStreamFactory paramInputStreamFactory) {
/* 45 */     this.wrappedStream = paramInputStream;
/* 46 */     this.inputStreamFactory = paramInputStreamFactory;
/*    */   }
/*    */   
/*    */   private void initWrapper() throws IOException {
/* 50 */     if (this.wrapperStream == null) {
/* 51 */       this.wrapperStream = this.inputStreamFactory.create(this.wrappedStream);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int read() throws IOException {
/* 57 */     initWrapper();
/* 58 */     return this.wrapperStream.read();
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 63 */     initWrapper();
/* 64 */     return this.wrapperStream.read(paramArrayOfbyte);
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 69 */     initWrapper();
/* 70 */     return this.wrapperStream.read(paramArrayOfbyte, paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   public long skip(long paramLong) throws IOException {
/* 75 */     initWrapper();
/* 76 */     return this.wrapperStream.skip(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean markSupported() {
/* 81 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int available() throws IOException {
/* 86 */     initWrapper();
/* 87 */     return this.wrapperStream.available();
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/*    */     try {
/* 93 */       if (this.wrapperStream != null) {
/* 94 */         this.wrapperStream.close();
/*    */       }
/*    */     } finally {
/* 97 */       this.wrappedStream.close();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\entity\LazyDecompressingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */