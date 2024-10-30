/*    */ package com.google.a.j;
/*    */ 
/*    */ import com.google.a.a.a;
/*    */ import com.google.a.a.c;
/*    */ import com.google.a.b.D;
/*    */ import java.io.FilterOutputStream;
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
/*    */ @a
/*    */ @c
/*    */ public final class p
/*    */   extends FilterOutputStream
/*    */ {
/*    */   private long count;
/*    */   
/*    */   public p(OutputStream paramOutputStream) {
/* 43 */     super((OutputStream)D.checkNotNull(paramOutputStream));
/*    */   }
/*    */ 
/*    */   
/*    */   public long getCount() {
/* 48 */     return this.count;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 53 */     this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
/* 54 */     this.count += paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int paramInt) throws IOException {
/* 59 */     this.out.write(paramInt);
/* 60 */     this.count++;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 68 */     this.out.close();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */