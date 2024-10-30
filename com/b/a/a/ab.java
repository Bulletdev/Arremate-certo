/*     */ package com.b.a.a;
/*     */ 
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
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
/*     */ class ab
/*     */   extends FilterOutputStream
/*     */ {
/*     */   public ab(OutputStream paramOutputStream) {
/*  28 */     super(paramOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(String paramString) throws IOException {
/*  35 */     byte[] arrayOfByte = v.e(paramString);
/*     */     
/*  37 */     write(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void v(X paramX) throws IOException {
/*  43 */     w(paramX);
/*  44 */     x(paramX);
/*  45 */     y(paramX);
/*     */ 
/*     */     
/*  48 */     byte[] arrayOfByte = v.nextBytes(4);
/*     */ 
/*     */     
/*  51 */     write(arrayOfByte);
/*     */ 
/*     */     
/*  54 */     a(paramX, arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void w(X paramX) throws IOException {
/*  64 */     int i = (paramX.ea() ? 128 : 0) | (paramX.eb() ? 64 : 0) | (paramX.ec() ? 32 : 0) | (paramX.ed() ? 16 : 0) | paramX.aY() & 0xF;
/*     */     
/*  66 */     write(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void x(X paramX) throws IOException {
/*  73 */     int i = 128;
/*     */     
/*  75 */     int j = paramX.aZ();
/*     */     
/*  77 */     if (j <= 125) {
/*     */       
/*  79 */       i |= j;
/*     */     }
/*  81 */     else if (j <= 65535) {
/*     */       
/*  83 */       i |= 0x7E;
/*     */     }
/*     */     else {
/*     */       
/*  87 */       i |= 0x7F;
/*     */     } 
/*     */     
/*  90 */     write(i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void y(X paramX) throws IOException {
/*  96 */     int i = paramX.aZ();
/*     */     
/*  98 */     if (i <= 125) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 103 */     if (i <= 65535) {
/*     */ 
/*     */       
/* 106 */       write(i >> 8 & 0xFF);
/* 107 */       write(i & 0xFF);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 113 */     write(0);
/* 114 */     write(0);
/* 115 */     write(0);
/* 116 */     write(0);
/* 117 */     write(i >> 24 & 0xFF);
/* 118 */     write(i >> 16 & 0xFF);
/* 119 */     write(i >> 8 & 0xFF);
/* 120 */     write(i & 0xFF);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(X paramX, byte[] paramArrayOfbyte) throws IOException {
/* 126 */     byte[] arrayOfByte = paramX.o();
/*     */     
/* 128 */     if (arrayOfByte == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 133 */     for (byte b = 0; b < arrayOfByte.length; b++) {
/*     */ 
/*     */       
/* 136 */       int i = (arrayOfByte[b] ^ paramArrayOfbyte[b % 4]) & 0xFF;
/*     */ 
/*     */       
/* 139 */       write(i);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\ab.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */