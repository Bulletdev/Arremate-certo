/*     */ package com.b.a.a;
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
/*     */ class b
/*     */ {
/*  21 */   private static final byte[] f = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String encode(String paramString) {
/*  31 */     if (paramString == null)
/*     */     {
/*  33 */       return null;
/*     */     }
/*     */     
/*  36 */     return encode(v.e(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String encode(byte[] paramArrayOfbyte) {
/*  42 */     if (paramArrayOfbyte == null)
/*     */     {
/*  44 */       return null;
/*     */     }
/*     */     
/*  47 */     int i = ((paramArrayOfbyte.length * 8 + 5) / 6 + 3) / 4 * 4;
/*     */     
/*  49 */     StringBuilder stringBuilder = new StringBuilder(i);
/*     */     int j;
/*  51 */     for (j = 0;; j += true) {
/*     */       
/*  53 */       int k = d(paramArrayOfbyte, j);
/*     */       
/*  55 */       if (k < 0) {
/*     */         break;
/*     */       }
/*     */ 
/*     */       
/*  60 */       stringBuilder.append((char)f[k]);
/*     */     } 
/*     */     
/*  63 */     for (j = stringBuilder.length(); j < i; j++)
/*     */     {
/*  65 */       stringBuilder.append('=');
/*     */     }
/*     */     
/*  68 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static int d(byte[] paramArrayOfbyte, int paramInt) {
/*     */     byte b1;
/*  74 */     int i = paramInt / 8;
/*     */ 
/*     */     
/*  77 */     if (paramArrayOfbyte.length <= i)
/*     */     {
/*  79 */       return -1;
/*     */     }
/*  81 */     if (paramArrayOfbyte.length - 1 == i) {
/*     */       
/*  83 */       b1 = 0;
/*     */     }
/*     */     else {
/*     */       
/*  87 */       b1 = paramArrayOfbyte[i + 1];
/*     */     } 
/*     */     
/*  90 */     switch (paramInt % 24 / 6) {
/*     */       
/*     */       case 0:
/*  93 */         return paramArrayOfbyte[i] >> 2 & 0x3F;
/*     */       
/*     */       case 1:
/*  96 */         return paramArrayOfbyte[i] << 4 & 0x30 | b1 >> 4 & 0xF;
/*     */       
/*     */       case 2:
/*  99 */         return paramArrayOfbyte[i] << 2 & 0x3C | b1 >> 6 & 0x3;
/*     */       
/*     */       case 3:
/* 102 */         return paramArrayOfbyte[i] & 0x3F;
/*     */     } 
/*     */ 
/*     */     
/* 106 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */