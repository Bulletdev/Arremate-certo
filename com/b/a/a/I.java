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
/*     */ 
/*     */ 
/*     */ 
/*     */ class i
/*     */ {
/*  24 */   private static int[] ah = new int[] { 16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(c paramc, int[] paramArrayOfint, s[] paramArrayOfs) throws o {
/*  34 */     int j = paramc.a(paramArrayOfint, 5) + 257;
/*     */ 
/*     */     
/*  37 */     int k = paramc.a(paramArrayOfint, 5) + 1;
/*     */ 
/*     */     
/*  40 */     int m = paramc.a(paramArrayOfint, 4) + 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  47 */     int[] arrayOfInt1 = new int[19];
/*  48 */     for (byte b = 0; b < m; b++) {
/*     */       
/*  50 */       byte b1 = (byte)paramc.a(paramArrayOfint, 3);
/*     */ 
/*     */       
/*  53 */       int n = W(b);
/*     */       
/*  55 */       arrayOfInt1[n] = b1;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  60 */     s s1 = new s(arrayOfInt1);
/*     */ 
/*     */ 
/*     */     
/*  64 */     int[] arrayOfInt2 = new int[j];
/*  65 */     a(paramc, paramArrayOfint, arrayOfInt2, s1);
/*     */ 
/*     */ 
/*     */     
/*  69 */     s s2 = new s(arrayOfInt2);
/*     */ 
/*     */ 
/*     */     
/*  73 */     int[] arrayOfInt3 = new int[k];
/*  74 */     a(paramc, paramArrayOfint, arrayOfInt3, s1);
/*     */ 
/*     */ 
/*     */     
/*  78 */     s s3 = new s(arrayOfInt3);
/*     */     
/*  80 */     paramArrayOfs[0] = s2;
/*  81 */     paramArrayOfs[1] = s3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(c paramc, int[] paramArrayOfint1, int[] paramArrayOfint2, s params) throws o {
/*  91 */     for (int j = 0; j < paramArrayOfint2.length; j++) {
/*     */ 
/*     */       
/*  94 */       int k = params.a(paramc, paramArrayOfint1);
/*     */ 
/*     */ 
/*     */       
/*  98 */       if (0 <= k && k <= 15) {
/*     */ 
/*     */         
/* 101 */         paramArrayOfint2[j] = k;
/*     */       } else {
/*     */         int m;
/*     */         
/*     */         String str;
/*     */         
/* 107 */         switch (k) {
/*     */ 
/*     */ 
/*     */           
/*     */           case 16:
/* 112 */             k = paramArrayOfint2[j - 1];
/* 113 */             m = paramc.a(paramArrayOfint1, 2) + 3;
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case 17:
/* 119 */             k = 0;
/* 120 */             m = paramc.a(paramArrayOfint1, 3) + 3;
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case 18:
/* 126 */             k = 0;
/* 127 */             m = paramc.a(paramArrayOfint1, 7) + 11;
/*     */             break;
/*     */ 
/*     */           
/*     */           default:
/* 132 */             str = String.format("[%s] Bad code length '%d' at the bit index '%d'.", new Object[] { i.class
/*     */                   
/* 134 */                   .getSimpleName(), Integer.valueOf(k), paramArrayOfint1 });
/*     */             
/* 136 */             throw new o(str);
/*     */         } 
/*     */ 
/*     */         
/* 140 */         for (byte b = 0; b < m; b++)
/*     */         {
/* 142 */           paramArrayOfint2[j + b] = k;
/*     */         }
/*     */ 
/*     */         
/* 146 */         j += m - 1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int W(int paramInt) {
/* 157 */     return ah[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(c paramc, int[] paramArrayOfint, int paramInt) throws o {
/*     */     char c1;
/*     */     byte b;
/*     */     int j;
/* 169 */     switch (paramInt) {
/*     */       
/*     */       case 257:
/*     */       case 258:
/*     */       case 259:
/*     */       case 260:
/*     */       case 261:
/*     */       case 262:
/*     */       case 263:
/*     */       case 264:
/* 179 */         return paramInt - 254;
/*     */       case 265:
/* 181 */         c1 = '\013'; b = 1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 212 */         j = paramc.a(paramArrayOfint, b);
/*     */         
/* 214 */         return c1 + j;case 266: c1 = '\r'; b = 1; j = paramc.a(paramArrayOfint, b); return c1 + j;case 267: c1 = '\017'; b = 1; j = paramc.a(paramArrayOfint, b); return c1 + j;case 268: c1 = '\021'; b = 1; j = paramc.a(paramArrayOfint, b); return c1 + j;case 269: c1 = '\023'; b = 2; j = paramc.a(paramArrayOfint, b); return c1 + j;case 270: c1 = '\027'; b = 2; j = paramc.a(paramArrayOfint, b); return c1 + j;case 271: c1 = '\033'; b = 2; j = paramc.a(paramArrayOfint, b); return c1 + j;case 272: c1 = '\037'; b = 2; j = paramc.a(paramArrayOfint, b); return c1 + j;case 273: c1 = '#'; b = 3; j = paramc.a(paramArrayOfint, b); return c1 + j;case 274: c1 = '+'; b = 3; j = paramc.a(paramArrayOfint, b); return c1 + j;case 275: c1 = '3'; b = 3; j = paramc.a(paramArrayOfint, b); return c1 + j;case 276: c1 = ';'; b = 3; j = paramc.a(paramArrayOfint, b); return c1 + j;case 277: c1 = 'C'; b = 4; j = paramc.a(paramArrayOfint, b); return c1 + j;case 278: c1 = 'S'; b = 4; j = paramc.a(paramArrayOfint, b); return c1 + j;case 279: c1 = 'c'; b = 4; j = paramc.a(paramArrayOfint, b); return c1 + j;case 280: c1 = 's'; b = 4; j = paramc.a(paramArrayOfint, b); return c1 + j;case 281: c1 = ''; b = 5; j = paramc.a(paramArrayOfint, b); return c1 + j;case 282: c1 = '£'; b = 5; j = paramc.a(paramArrayOfint, b); return c1 + j;case 283: c1 = 'Ã'; b = 5; j = paramc.a(paramArrayOfint, b); return c1 + j;case 284: c1 = 'ã'; b = 5; j = paramc.a(paramArrayOfint, b); return c1 + j;
/*     */       case 285:
/*     */         return 258;
/*     */     } 
/*     */     String str = String.format("[%s] Bad literal/length code '%d' at the bit index '%d'.", new Object[] { i.class.getSimpleName(), Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfint[0]) });
/*     */     throw new o(str);
/*     */   }
/*     */   
/*     */   public static int a(c paramc, int[] paramArrayOfint, s params) throws o {
/*     */     char c1;
/*     */     byte b;
/* 225 */     int k, j = params.a(paramc, paramArrayOfint);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     switch (j) {
/*     */       
/*     */       case 0:
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/* 236 */         return j + 1;
/*     */       case 4:
/* 238 */         c1 = '\005'; b = 1;
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
/* 277 */         k = paramc.a(paramArrayOfint, b);
/*     */         
/* 279 */         return c1 + k;case 5: c1 = '\007'; b = 1; k = paramc.a(paramArrayOfint, b); return c1 + k;case 6: c1 = '\t'; b = 2; k = paramc.a(paramArrayOfint, b); return c1 + k;case 7: c1 = '\r'; b = 2; k = paramc.a(paramArrayOfint, b); return c1 + k;case 8: c1 = '\021'; b = 3; k = paramc.a(paramArrayOfint, b); return c1 + k;case 9: c1 = '\031'; b = 3; k = paramc.a(paramArrayOfint, b); return c1 + k;case 10: c1 = '!'; b = 4; k = paramc.a(paramArrayOfint, b); return c1 + k;case 11: c1 = '1'; b = 4; k = paramc.a(paramArrayOfint, b); return c1 + k;case 12: c1 = 'A'; b = 5; k = paramc.a(paramArrayOfint, b); return c1 + k;case 13: c1 = 'a'; b = 5; k = paramc.a(paramArrayOfint, b); return c1 + k;case 14: c1 = ''; b = 6; k = paramc.a(paramArrayOfint, b); return c1 + k;case 15: c1 = 'Á'; b = 6; k = paramc.a(paramArrayOfint, b); return c1 + k;case 16: c1 = 'ā'; b = 7; k = paramc.a(paramArrayOfint, b); return c1 + k;case 17: c1 = 'Ɓ'; b = 7; k = paramc.a(paramArrayOfint, b); return c1 + k;case 18: c1 = 'ȁ'; b = 8; k = paramc.a(paramArrayOfint, b); return c1 + k;case 19: c1 = '́'; b = 8; k = paramc.a(paramArrayOfint, b); return c1 + k;case 20: c1 = 'Ё'; b = 9; k = paramc.a(paramArrayOfint, b); return c1 + k;case 21: c1 = '؁'; b = 9; k = paramc.a(paramArrayOfint, b); return c1 + k;case 22: c1 = 'ࠁ'; b = 10; k = paramc.a(paramArrayOfint, b); return c1 + k;case 23: c1 = 'ఁ'; b = 10; k = paramc.a(paramArrayOfint, b); return c1 + k;case 24: c1 = 'ခ'; b = 11; k = paramc.a(paramArrayOfint, b); return c1 + k;case 25: c1 = '᠁'; b = 11; k = paramc.a(paramArrayOfint, b); return c1 + k;case 26: c1 = ' '; b = 12; k = paramc.a(paramArrayOfint, b); return c1 + k;case 27: c1 = '、'; b = 12; k = paramc.a(paramArrayOfint, b); return c1 + k;case 28: c1 = '䀁'; b = 13; k = paramc.a(paramArrayOfint, b); return c1 + k;case 29: c1 = '态'; b = 13; k = paramc.a(paramArrayOfint, b); return c1 + k;
/*     */     } 
/*     */     String str = String.format("[%s] Bad distance code '%d' at the bit index '%d'.", new Object[] { i.class.getSimpleName(), Integer.valueOf(j), Integer.valueOf(paramArrayOfint[0]) });
/*     */     throw new o(str);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */