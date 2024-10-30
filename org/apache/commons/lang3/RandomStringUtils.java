/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.util.Random;
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
/*     */ public class RandomStringUtils
/*     */ {
/*  56 */   private static final Random RANDOM = new Random();
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
/*     */   public static String random(int paramInt) {
/*  82 */     return random(paramInt, false, false);
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
/*     */   public static String randomAscii(int paramInt) {
/*  96 */     return random(paramInt, 32, 127, false, false);
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
/*     */   public static String randomAscii(int paramInt1, int paramInt2) {
/* 112 */     return randomAscii(RandomUtils.nextInt(paramInt1, paramInt2));
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
/*     */   public static String randomAlphabetic(int paramInt) {
/* 126 */     return random(paramInt, true, false);
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
/*     */   public static String randomAlphabetic(int paramInt1, int paramInt2) {
/* 141 */     return randomAlphabetic(RandomUtils.nextInt(paramInt1, paramInt2));
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
/*     */   public static String randomAlphanumeric(int paramInt) {
/* 155 */     return random(paramInt, true, true);
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
/*     */   public static String randomAlphanumeric(int paramInt1, int paramInt2) {
/* 171 */     return randomAlphanumeric(RandomUtils.nextInt(paramInt1, paramInt2));
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
/*     */   public static String randomGraph(int paramInt) {
/* 186 */     return random(paramInt, 33, 126, false, false);
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
/*     */   public static String randomGraph(int paramInt1, int paramInt2) {
/* 201 */     return randomGraph(RandomUtils.nextInt(paramInt1, paramInt2));
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
/*     */   public static String randomNumeric(int paramInt) {
/* 215 */     return random(paramInt, false, true);
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
/*     */   public static String randomNumeric(int paramInt1, int paramInt2) {
/* 230 */     return randomNumeric(RandomUtils.nextInt(paramInt1, paramInt2));
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
/*     */   public static String randomPrint(int paramInt) {
/* 245 */     return random(paramInt, 32, 126, false, false);
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
/*     */   public static String randomPrint(int paramInt1, int paramInt2) {
/* 260 */     return randomPrint(RandomUtils.nextInt(paramInt1, paramInt2));
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
/*     */   public static String random(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 278 */     return random(paramInt, 0, 0, paramBoolean1, paramBoolean2);
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
/*     */   
/*     */   public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
/* 298 */     return random(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, null, RANDOM);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char... paramVarArgs) {
/* 322 */     return random(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramVarArgs, RANDOM);
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
/*     */   public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfchar, Random paramRandom) {
/* 360 */     if (paramInt1 == 0)
/* 361 */       return ""; 
/* 362 */     if (paramInt1 < 0) {
/* 363 */       throw new IllegalArgumentException("Requested random string length " + paramInt1 + " is less than 0.");
/*     */     }
/* 365 */     if (paramArrayOfchar != null && paramArrayOfchar.length == 0) {
/* 366 */       throw new IllegalArgumentException("The chars array must not be empty");
/*     */     }
/*     */     
/* 369 */     if (paramInt2 == 0 && paramInt3 == 0) {
/* 370 */       if (paramArrayOfchar != null) {
/* 371 */         paramInt3 = paramArrayOfchar.length;
/*     */       }
/* 373 */       else if (!paramBoolean1 && !paramBoolean2) {
/* 374 */         paramInt3 = 1114111;
/*     */       } else {
/* 376 */         paramInt3 = 123;
/* 377 */         paramInt2 = 32;
/*     */       }
/*     */     
/*     */     }
/* 381 */     else if (paramInt3 <= paramInt2) {
/* 382 */       throw new IllegalArgumentException("Parameter end (" + paramInt3 + ") must be greater than start (" + paramInt2 + ")");
/*     */     } 
/*     */ 
/*     */     
/* 386 */     byte b1 = 48;
/* 387 */     byte b2 = 65;
/*     */     
/* 389 */     if (paramArrayOfchar == null && ((paramBoolean2 && paramInt3 <= 48) || (paramBoolean1 && paramInt3 <= 65)))
/*     */     {
/* 391 */       throw new IllegalArgumentException("Parameter end (" + paramInt3 + ") must be greater then (" + '0' + ") for generating digits or greater then (" + 'A' + ") for generating letters.");
/*     */     }
/*     */ 
/*     */     
/* 395 */     StringBuilder stringBuilder = new StringBuilder(paramInt1);
/* 396 */     int i = paramInt3 - paramInt2;
/*     */     
/* 398 */     while (paramInt1-- != 0) {
/*     */       int j;
/* 400 */       if (paramArrayOfchar == null) {
/* 401 */         j = paramRandom.nextInt(i) + paramInt2;
/*     */         
/* 403 */         switch (Character.getType(j)) {
/*     */           case 0:
/*     */           case 18:
/*     */           case 19:
/* 407 */             paramInt1++;
/*     */             continue;
/*     */         } 
/*     */       
/*     */       } else {
/* 412 */         j = paramArrayOfchar[paramRandom.nextInt(i) + paramInt2];
/*     */       } 
/*     */       
/* 415 */       int k = Character.charCount(j);
/* 416 */       if (paramInt1 == 0 && k > 1) {
/* 417 */         paramInt1++;
/*     */         
/*     */         continue;
/*     */       } 
/* 421 */       if ((paramBoolean1 && Character.isLetter(j)) || (paramBoolean2 && 
/* 422 */         Character.isDigit(j)) || (!paramBoolean1 && !paramBoolean2)) {
/*     */         
/* 424 */         stringBuilder.appendCodePoint(j);
/*     */         
/* 426 */         if (k == 2) {
/* 427 */           paramInt1--;
/*     */         }
/*     */         continue;
/*     */       } 
/* 431 */       paramInt1++;
/*     */     } 
/*     */     
/* 434 */     return stringBuilder.toString();
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
/*     */   public static String random(int paramInt, String paramString) {
/* 453 */     if (paramString == null) {
/* 454 */       return random(paramInt, 0, 0, false, false, null, RANDOM);
/*     */     }
/* 456 */     return random(paramInt, paramString.toCharArray());
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
/*     */   public static String random(int paramInt, char... paramVarArgs) {
/* 472 */     if (paramVarArgs == null) {
/* 473 */       return random(paramInt, 0, 0, false, false, null, RANDOM);
/*     */     }
/* 475 */     return random(paramInt, 0, paramVarArgs.length, false, false, paramVarArgs, RANDOM);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\RandomStringUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */