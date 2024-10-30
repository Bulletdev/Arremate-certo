/*     */ package org.jsoup.helper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Validate
/*     */ {
/*     */   public static void notNull(Object paramObject) {
/*  15 */     if (paramObject == null) {
/*  16 */       throw new IllegalArgumentException("Object must not be null");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notNull(Object paramObject, String paramString) {
/*  25 */     if (paramObject == null) {
/*  26 */       throw new IllegalArgumentException(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isTrue(boolean paramBoolean) {
/*  34 */     if (!paramBoolean) {
/*  35 */       throw new IllegalArgumentException("Must be true");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isTrue(boolean paramBoolean, String paramString) {
/*  44 */     if (!paramBoolean) {
/*  45 */       throw new IllegalArgumentException(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isFalse(boolean paramBoolean) {
/*  53 */     if (paramBoolean) {
/*  54 */       throw new IllegalArgumentException("Must be false");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isFalse(boolean paramBoolean, String paramString) {
/*  63 */     if (paramBoolean) {
/*  64 */       throw new IllegalArgumentException(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void noNullElements(Object[] paramArrayOfObject) {
/*  72 */     noNullElements(paramArrayOfObject, "Array must not contain any null objects");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void noNullElements(Object[] paramArrayOfObject, String paramString) {
/*  81 */     for (Object object : paramArrayOfObject) {
/*  82 */       if (object == null) {
/*  83 */         throw new IllegalArgumentException(paramString);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notEmpty(String paramString) {
/*  91 */     if (paramString == null || paramString.length() == 0) {
/*  92 */       throw new IllegalArgumentException("String must not be empty");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notEmpty(String paramString1, String paramString2) {
/* 101 */     if (paramString1 == null || paramString1.length() == 0) {
/* 102 */       throw new IllegalArgumentException(paramString2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void fail(String paramString) {
/* 110 */     throw new IllegalArgumentException(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\helper\Validate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */