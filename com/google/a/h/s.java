/*    */ package com.google.a.h;
/*    */ 
/*    */ import com.google.a.a.a;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @a
/*    */ public final class s
/*    */   extends FilterOutputStream
/*    */ {
/*    */   private final p a;
/*    */   
/*    */   public s(o paramo, OutputStream paramOutputStream) {
/* 45 */     super((OutputStream)D.checkNotNull(paramOutputStream));
/* 46 */     this.a = (p)D.checkNotNull(paramo.a());
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int paramInt) throws IOException {
/* 51 */     this.a.a((byte)paramInt);
/* 52 */     this.out.write(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 57 */     this.a.a(paramArrayOfbyte, paramInt1, paramInt2);
/* 58 */     this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public n a() {
/* 66 */     return this.a.a();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 74 */     this.out.close();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */