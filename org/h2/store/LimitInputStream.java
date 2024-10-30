/*    */ package org.h2.store;
/*    */ 
/*    */ import java.io.FilterInputStream;
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
/*    */ public class LimitInputStream
/*    */   extends FilterInputStream
/*    */ {
/*    */   private long remaining;
/*    */   
/*    */   public LimitInputStream(InputStream paramInputStream, long paramLong) {
/* 20 */     super(paramInputStream);
/* 21 */     this.remaining = paramLong;
/*    */   }
/*    */ 
/*    */   
/*    */   public int available() throws IOException {
/* 26 */     return (int)Math.min(this.remaining, this.in.available());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean markSupported() {
/* 31 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read() throws IOException {
/* 36 */     if (this.remaining == 0L) {
/* 37 */       return -1;
/*    */     }
/* 39 */     int i = this.in.read();
/* 40 */     if (i >= 0) {
/* 41 */       this.remaining--;
/*    */     }
/* 43 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 48 */     if (this.remaining == 0L) {
/* 49 */       return -1;
/*    */     }
/* 51 */     paramInt2 = (int)Math.min(paramInt2, this.remaining);
/* 52 */     int i = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 53 */     if (i >= 0) {
/* 54 */       this.remaining -= i;
/*    */     }
/* 56 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\LimitInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */