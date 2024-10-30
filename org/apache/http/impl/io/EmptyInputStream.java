/*    */ package org.apache.http.impl.io;
/*    */ 
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
/*    */ public final class EmptyInputStream
/*    */   extends InputStream
/*    */ {
/* 37 */   public static final EmptyInputStream INSTANCE = new EmptyInputStream();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int available() {
/* 44 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mark(int paramInt) {}
/*    */ 
/*    */   
/*    */   public boolean markSupported() {
/* 57 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read() {
/* 62 */     return -1;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte) {
/* 67 */     return -1;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 72 */     return -1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void reset() {}
/*    */ 
/*    */   
/*    */   public long skip(long paramLong) {
/* 81 */     return 0L;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\EmptyInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */