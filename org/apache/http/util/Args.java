/*     */ package org.apache.http.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Args
/*     */ {
/*     */   public static void check(boolean paramBoolean, String paramString) {
/*  35 */     if (!paramBoolean) {
/*  36 */       throw new IllegalArgumentException(paramString);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void check(boolean paramBoolean, String paramString, Object... paramVarArgs) {
/*  41 */     if (!paramBoolean) {
/*  42 */       throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void check(boolean paramBoolean, String paramString, Object paramObject) {
/*  47 */     if (!paramBoolean) {
/*  48 */       throw new IllegalArgumentException(String.format(paramString, new Object[] { paramObject }));
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> T notNull(T paramT, String paramString) {
/*  53 */     if (paramT == null) {
/*  54 */       throw new IllegalArgumentException(paramString + " may not be null");
/*     */     }
/*  56 */     return paramT;
/*     */   }
/*     */   
/*     */   public static <T extends CharSequence> T notEmpty(T paramT, String paramString) {
/*  60 */     if (paramT == null) {
/*  61 */       throw new IllegalArgumentException(paramString + " may not be null");
/*     */     }
/*  63 */     if (TextUtils.isEmpty((CharSequence)paramT)) {
/*  64 */       throw new IllegalArgumentException(paramString + " may not be empty");
/*     */     }
/*  66 */     return paramT;
/*     */   }
/*     */   
/*     */   public static <T extends CharSequence> T notBlank(T paramT, String paramString) {
/*  70 */     if (paramT == null) {
/*  71 */       throw new IllegalArgumentException(paramString + " may not be null");
/*     */     }
/*  73 */     if (TextUtils.isBlank((CharSequence)paramT)) {
/*  74 */       throw new IllegalArgumentException(paramString + " may not be blank");
/*     */     }
/*  76 */     return paramT;
/*     */   }
/*     */   
/*     */   public static <T extends CharSequence> T containsNoBlanks(T paramT, String paramString) {
/*  80 */     if (paramT == null) {
/*  81 */       throw new IllegalArgumentException(paramString + " may not be null");
/*     */     }
/*  83 */     if (paramT.length() == 0) {
/*  84 */       throw new IllegalArgumentException(paramString + " may not be empty");
/*     */     }
/*  86 */     if (TextUtils.containsBlanks((CharSequence)paramT)) {
/*  87 */       throw new IllegalArgumentException(paramString + " may not contain blanks");
/*     */     }
/*  89 */     return paramT;
/*     */   }
/*     */   
/*     */   public static <E, T extends java.util.Collection<E>> T notEmpty(T paramT, String paramString) {
/*  93 */     if (paramT == null) {
/*  94 */       throw new IllegalArgumentException(paramString + " may not be null");
/*     */     }
/*  96 */     if (paramT.isEmpty()) {
/*  97 */       throw new IllegalArgumentException(paramString + " may not be empty");
/*     */     }
/*  99 */     return paramT;
/*     */   }
/*     */   
/*     */   public static int positive(int paramInt, String paramString) {
/* 103 */     if (paramInt <= 0) {
/* 104 */       throw new IllegalArgumentException(paramString + " may not be negative or zero");
/*     */     }
/* 106 */     return paramInt;
/*     */   }
/*     */   
/*     */   public static long positive(long paramLong, String paramString) {
/* 110 */     if (paramLong <= 0L) {
/* 111 */       throw new IllegalArgumentException(paramString + " may not be negative or zero");
/*     */     }
/* 113 */     return paramLong;
/*     */   }
/*     */   
/*     */   public static int notNegative(int paramInt, String paramString) {
/* 117 */     if (paramInt < 0) {
/* 118 */       throw new IllegalArgumentException(paramString + " may not be negative");
/*     */     }
/* 120 */     return paramInt;
/*     */   }
/*     */   
/*     */   public static long notNegative(long paramLong, String paramString) {
/* 124 */     if (paramLong < 0L) {
/* 125 */       throw new IllegalArgumentException(paramString + " may not be negative");
/*     */     }
/* 127 */     return paramLong;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\Args.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */