/*    */ package org.h2.util;
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
/*    */ public class AutoCloseInputStream
/*    */   extends InputStream
/*    */ {
/*    */   private final InputStream in;
/*    */   private boolean closed;
/*    */   
/*    */   public AutoCloseInputStream(InputStream paramInputStream) {
/* 25 */     this.in = paramInputStream;
/*    */   }
/*    */   
/*    */   private int autoClose(int paramInt) throws IOException {
/* 29 */     if (paramInt < 0) {
/* 30 */       close();
/*    */     }
/* 32 */     return paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 37 */     if (!this.closed) {
/* 38 */       this.in.close();
/* 39 */       this.closed = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 45 */     return this.closed ? -1 : autoClose(this.in.read(paramArrayOfbyte, paramInt1, paramInt2));
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 50 */     return this.closed ? -1 : autoClose(this.in.read(paramArrayOfbyte));
/*    */   }
/*    */ 
/*    */   
/*    */   public int read() throws IOException {
/* 55 */     return this.closed ? -1 : autoClose(this.in.read());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\AutoCloseInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */