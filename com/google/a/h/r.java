/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class r
/*     */   extends FilterInputStream
/*     */ {
/*     */   private final p a;
/*     */   
/*     */   public r(o paramo, InputStream paramInputStream) {
/*  42 */     super((InputStream)D.checkNotNull(paramInputStream));
/*  43 */     this.a = (p)D.checkNotNull(paramo.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public int read() throws IOException {
/*  53 */     int i = this.in.read();
/*  54 */     if (i != -1) {
/*  55 */       this.a.a((byte)i);
/*     */     }
/*  57 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  67 */     int i = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
/*  68 */     if (i != -1) {
/*  69 */       this.a.a(paramArrayOfbyte, paramInt1, i);
/*     */     }
/*  71 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() throws IOException {
/*  95 */     throw new IOException("reset not supported");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public n a() {
/* 103 */     return this.a.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */