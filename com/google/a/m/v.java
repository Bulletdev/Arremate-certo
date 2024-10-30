/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @b
/*     */ public final class v
/*     */ {
/*     */   static final long bo = 4294967295L;
/*     */   
/*     */   static int S(int paramInt) {
/*  56 */     return paramInt ^ Integer.MIN_VALUE;
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
/*     */   public static int compare(int paramInt1, int paramInt2) {
/*  71 */     return k.compare(S(paramInt1), S(paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long d(int paramInt) {
/*  80 */     return paramInt & 0xFFFFFFFFL;
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
/*     */   public static int d(long paramLong) {
/*  94 */     D.a((paramLong >> 32L == 0L), "out of range: %s", paramLong);
/*  95 */     return (int)paramLong;
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
/*     */   public static int e(long paramLong) {
/* 108 */     if (paramLong <= 0L)
/* 109 */       return 0; 
/* 110 */     if (paramLong >= 4294967296L) {
/* 111 */       return -1;
/*     */     }
/* 113 */     return (int)paramLong;
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
/*     */   public static int min(int... paramVarArgs) {
/* 126 */     D.checkArgument((paramVarArgs.length > 0));
/* 127 */     int i = S(paramVarArgs[0]);
/* 128 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 129 */       int j = S(paramVarArgs[b]);
/* 130 */       if (j < i) {
/* 131 */         i = j;
/*     */       }
/*     */     } 
/* 134 */     return S(i);
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
/*     */   public static int max(int... paramVarArgs) {
/* 146 */     D.checkArgument((paramVarArgs.length > 0));
/* 147 */     int i = S(paramVarArgs[0]);
/* 148 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 149 */       int j = S(paramVarArgs[b]);
/* 150 */       if (j > i) {
/* 151 */         i = j;
/*     */       }
/*     */     } 
/* 154 */     return S(i);
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
/*     */   public static String a(String paramString, int... paramVarArgs) {
/* 166 */     D.checkNotNull(paramString);
/* 167 */     if (paramVarArgs.length == 0) {
/* 168 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 172 */     StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 5);
/* 173 */     stringBuilder.append(toString(paramVarArgs[0]));
/* 174 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 175 */       stringBuilder.append(paramString).append(toString(paramVarArgs[b]));
/*     */     }
/* 177 */     return stringBuilder.toString();
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
/*     */   public static Comparator<int[]> g() {
/* 191 */     return (Comparator<int[]>)a.a;
/*     */   }
/*     */   
/*     */   enum a implements Comparator<int[]> {
/* 195 */     a;
/*     */ 
/*     */     
/*     */     public int b(int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
/* 199 */       int i = Math.min(param1ArrayOfint1.length, param1ArrayOfint2.length);
/* 200 */       for (byte b = 0; b < i; b++) {
/* 201 */         if (param1ArrayOfint1[b] != param1ArrayOfint2[b]) {
/* 202 */           return v.compare(param1ArrayOfint1[b], param1ArrayOfint2[b]);
/*     */         }
/*     */       } 
/* 205 */       return param1ArrayOfint1.length - param1ArrayOfint2.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 210 */       return "UnsignedInts.lexicographicalComparator()";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void d(int[] paramArrayOfint) {
/* 220 */     D.checkNotNull(paramArrayOfint);
/* 221 */     b(paramArrayOfint, 0, paramArrayOfint.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 231 */     D.checkNotNull(paramArrayOfint);
/* 232 */     D.a(paramInt1, paramInt2, paramArrayOfint.length); int i;
/* 233 */     for (i = paramInt1; i < paramInt2; i++) {
/* 234 */       paramArrayOfint[i] = S(paramArrayOfint[i]);
/*     */     }
/* 236 */     Arrays.sort(paramArrayOfint, paramInt1, paramInt2);
/* 237 */     for (i = paramInt1; i < paramInt2; i++) {
/* 238 */       paramArrayOfint[i] = S(paramArrayOfint[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(int[] paramArrayOfint) {
/* 249 */     D.checkNotNull(paramArrayOfint);
/* 250 */     a(paramArrayOfint, 0, paramArrayOfint.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 260 */     D.checkNotNull(paramArrayOfint);
/* 261 */     D.a(paramInt1, paramInt2, paramArrayOfint.length); int i;
/* 262 */     for (i = paramInt1; i < paramInt2; i++) {
/* 263 */       paramArrayOfint[i] = paramArrayOfint[i] ^ Integer.MAX_VALUE;
/*     */     }
/* 265 */     Arrays.sort(paramArrayOfint, paramInt1, paramInt2);
/* 266 */     for (i = paramInt1; i < paramInt2; i++) {
/* 267 */       paramArrayOfint[i] = paramArrayOfint[i] ^ Integer.MAX_VALUE;
/*     */     }
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
/*     */   public static int B(int paramInt1, int paramInt2) {
/* 282 */     return (int)(d(paramInt1) / d(paramInt2));
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
/*     */   public static int C(int paramInt1, int paramInt2) {
/* 296 */     return (int)(d(paramInt1) % d(paramInt2));
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
/*     */   @com.google.b.a.a
/*     */   public static int d(String paramString) {
/* 316 */     n n = n.a(paramString);
/*     */     
/*     */     try {
/* 319 */       return c(n.iQ, n.gm);
/* 320 */     } catch (NumberFormatException numberFormatException1) {
/* 321 */       String.valueOf(paramString); NumberFormatException numberFormatException2 = new NumberFormatException((String.valueOf(paramString).length() != 0) ? "Error parsing value: ".concat(String.valueOf(paramString)) : new String("Error parsing value: "));
/*     */       
/* 323 */       numberFormatException2.initCause(numberFormatException1);
/* 324 */       throw numberFormatException2;
/*     */     } 
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
/*     */   @com.google.b.a.a
/*     */   public static int e(String paramString) {
/* 339 */     return c(paramString, 10);
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
/*     */   @com.google.b.a.a
/*     */   public static int c(String paramString, int paramInt) {
/* 357 */     D.checkNotNull(paramString);
/* 358 */     long l = Long.parseLong(paramString, paramInt);
/* 359 */     if ((l & 0xFFFFFFFFL) != l) {
/* 360 */       throw new NumberFormatException((new StringBuilder(69 + String.valueOf(paramString).length())).append("Input ").append(paramString).append(" in base ").append(paramInt).append(" is not in the range of an unsigned integer").toString());
/*     */     }
/*     */     
/* 363 */     return (int)l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(int paramInt) {
/* 372 */     return f(paramInt, 10);
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
/*     */   public static String f(int paramInt1, int paramInt2) {
/* 387 */     long l = paramInt1 & 0xFFFFFFFFL;
/* 388 */     return Long.toString(l, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */