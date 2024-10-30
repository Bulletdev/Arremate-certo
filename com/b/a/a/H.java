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
/*     */ 
/*     */ 
/*     */ class h
/*     */ {
/*     */   public static void a(c paramc1, c paramc2) throws o {
/*  27 */     a(paramc1, 0, paramc2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(c paramc1, int paramInt, c paramc2) throws o {
/*  34 */     int[] arrayOfInt = new int[1];
/*  35 */     arrayOfInt[0] = paramInt * 8;
/*     */ 
/*     */ 
/*     */     
/*  39 */     while (a(paramc1, arrayOfInt, paramc2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(c paramc1, int[] paramArrayOfint, c paramc2) throws o {
/*     */     String str;
/*  50 */     boolean bool = paramc1.a(paramArrayOfint);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     int i = paramc1.a(paramArrayOfint, 2);
/*     */     
/*  62 */     switch (i) {
/*     */ 
/*     */       
/*     */       case 0:
/*  66 */         a(paramc1, paramArrayOfint, paramc2);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 1:
/*  71 */         b(paramc1, paramArrayOfint, paramc2);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/*  76 */         c(paramc1, paramArrayOfint, paramc2);
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/*  82 */         str = String.format("[%s] Bad compression type '11' at the bit index '%d'.", new Object[] { h.class
/*     */               
/*  84 */               .getSimpleName(), Integer.valueOf(paramArrayOfint[0]) });
/*     */         
/*  86 */         throw new o(str);
/*     */     } 
/*     */ 
/*     */     
/*  90 */     if (paramc1.length() <= paramArrayOfint[0] / 8)
/*     */     {
/*     */       
/*  93 */       bool = true;
/*     */     }
/*     */ 
/*     */     
/*  97 */     return !bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(c paramc1, int[] paramArrayOfint, c paramc2) {
/* 106 */     int i = paramArrayOfint[0] + 7 & 0xFFFFFFF8;
/*     */ 
/*     */ 
/*     */     
/* 110 */     int j = i / 8;
/*     */ 
/*     */     
/* 113 */     int k = (paramc1.a(j) & 0xFF) + (paramc1.a(j + 1) & 0xFF) * 256;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     j += 4;
/*     */ 
/*     */     
/* 121 */     paramc2.a(paramc1, j, k);
/*     */ 
/*     */ 
/*     */     
/* 125 */     paramArrayOfint[0] = (j + k) * 8;
/*     */   }
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
/*     */   private static void b(c paramc1, int[] paramArrayOfint, c paramc2) throws o {
/* 144 */     a(paramc1, paramArrayOfint, paramc2, 
/* 145 */         n.a(), 
/* 146 */         m.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void c(c paramc1, int[] paramArrayOfint, c paramc2) throws o {
/* 158 */     s[] arrayOfS = new s[2];
/* 159 */     i.a(paramc1, paramArrayOfint, arrayOfS);
/*     */ 
/*     */ 
/*     */     
/* 163 */     a(paramc1, paramArrayOfint, paramc2, arrayOfS[0], arrayOfS[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(c paramc1, int[] paramArrayOfint, c paramc2, s params1, s params2) throws o {
/*     */     while (true) {
/* 176 */       int i = params1.a(paramc1, paramArrayOfint);
/*     */ 
/*     */       
/* 179 */       if (i == 256) {
/*     */         break;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 186 */       if (0 <= i && i <= 255) {
/*     */ 
/*     */         
/* 189 */         paramc2.aS(i);
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */ 
/*     */       
/* 196 */       int j = i.a(paramc1, paramArrayOfint, i);
/*     */ 
/*     */       
/* 199 */       int k = i.a(paramc1, paramArrayOfint, params2);
/*     */ 
/*     */       
/* 202 */       a(j, k, paramc2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(int paramInt1, int paramInt2, c paramc) {
/* 210 */     int i = paramc.length();
/*     */ 
/*     */     
/* 213 */     byte[] arrayOfByte = new byte[paramInt1];
/*     */ 
/*     */     
/* 216 */     int j = i - paramInt2;
/* 217 */     int k = j;
/*     */     
/* 219 */     for (byte b = 0; b < paramInt1; b++, k++) {
/*     */       
/* 221 */       if (i <= k)
/*     */       {
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
/* 234 */         k = j;
/*     */       }
/*     */       
/* 237 */       arrayOfByte[b] = paramc.a(k);
/*     */     } 
/*     */ 
/*     */     
/* 241 */     paramc.c(arrayOfByte);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */