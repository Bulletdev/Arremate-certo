/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true)
/*     */ public final class ci
/*     */ {
/*     */   @c
/*     */   public static <T> T[] a(Class<T> paramClass, int paramInt) {
/*  49 */     return (T[])Array.newInstance(paramClass, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T[] a(T[] paramArrayOfT, int paramInt) {
/*  59 */     return cl.a(paramArrayOfT, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static <T> T[] a(T[] paramArrayOfT1, T[] paramArrayOfT2, Class<T> paramClass) {
/*  71 */     Object[] arrayOfObject = a((Class)paramClass, paramArrayOfT1.length + paramArrayOfT2.length);
/*  72 */     System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramArrayOfT1.length);
/*  73 */     System.arraycopy(paramArrayOfT2, 0, arrayOfObject, paramArrayOfT1.length, paramArrayOfT2.length);
/*  74 */     return (T[])arrayOfObject;
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
/*     */   public static <T> T[] a(T paramT, T[] paramArrayOfT) {
/*  86 */     Object[] arrayOfObject = a((Object[])paramArrayOfT, paramArrayOfT.length + 1);
/*  87 */     arrayOfObject[0] = paramT;
/*  88 */     System.arraycopy(paramArrayOfT, 0, arrayOfObject, 1, paramArrayOfT.length);
/*  89 */     return (T[])arrayOfObject;
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
/*     */   public static <T> T[] a(T[] paramArrayOfT, T paramT) {
/* 101 */     Object[] arrayOfObject = Arrays.copyOf((Object[])paramArrayOfT, paramArrayOfT.length + 1);
/* 102 */     arrayOfObject[paramArrayOfT.length] = paramT;
/* 103 */     return (T[])arrayOfObject;
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
/*     */   static <T> T[] a(Collection<?> paramCollection, T[] paramArrayOfT) {
/* 128 */     int i = paramCollection.size();
/* 129 */     if (paramArrayOfT.length < i) {
/* 130 */       paramArrayOfT = a(paramArrayOfT, i);
/*     */     }
/* 132 */     b(paramCollection, (Object[])paramArrayOfT);
/* 133 */     if (paramArrayOfT.length > i) {
/* 134 */       paramArrayOfT[i] = null;
/*     */     }
/* 136 */     return paramArrayOfT;
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
/*     */   static <T> T[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, T[] paramArrayOfT) {
/* 151 */     D.a(paramInt1, paramInt1 + paramInt2, paramArrayOfObject.length);
/* 152 */     if (paramArrayOfT.length < paramInt2) {
/* 153 */       paramArrayOfT = a(paramArrayOfT, paramInt2);
/* 154 */     } else if (paramArrayOfT.length > paramInt2) {
/* 155 */       paramArrayOfT[paramInt2] = null;
/*     */     } 
/* 157 */     System.arraycopy(paramArrayOfObject, paramInt1, paramArrayOfT, 0, paramInt2);
/* 158 */     return paramArrayOfT;
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
/*     */   static Object[] a(Collection<?> paramCollection) {
/* 174 */     return b(paramCollection, new Object[paramCollection.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Object[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
/* 182 */     D.a(paramInt1, paramInt1 + paramInt2, paramArrayOfObject.length);
/* 183 */     if (paramInt2 == 0) {
/* 184 */       return new Object[0];
/*     */     }
/* 186 */     Object[] arrayOfObject = new Object[paramInt2];
/* 187 */     System.arraycopy(paramArrayOfObject, paramInt1, arrayOfObject, 0, paramInt2);
/* 188 */     return arrayOfObject;
/*     */   }
/*     */   
/*     */   @a
/*     */   private static Object[] b(Iterable<?> paramIterable, Object[] paramArrayOfObject) {
/* 193 */     byte b = 0;
/* 194 */     for (Object object : paramIterable) {
/* 195 */       paramArrayOfObject[b++] = object;
/*     */     }
/* 197 */     return paramArrayOfObject;
/*     */   }
/*     */ 
/*     */   
/*     */   static void swap(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
/* 202 */     Object object = paramArrayOfObject[paramInt1];
/* 203 */     paramArrayOfObject[paramInt1] = paramArrayOfObject[paramInt2];
/* 204 */     paramArrayOfObject[paramInt2] = object;
/*     */   }
/*     */   
/*     */   @a
/*     */   static Object[] b(Object... paramVarArgs) {
/* 209 */     return b(paramVarArgs, paramVarArgs.length);
/*     */   }
/*     */   
/*     */   @a
/*     */   static Object[] b(Object[] paramArrayOfObject, int paramInt) {
/* 214 */     for (byte b = 0; b < paramInt; b++) {
/* 215 */       a(paramArrayOfObject[b], b);
/*     */     }
/* 217 */     return paramArrayOfObject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   static Object a(Object paramObject, int paramInt) {
/* 224 */     if (paramObject == null) {
/* 225 */       throw new NullPointerException((new StringBuilder(20)).append("at index ").append(paramInt).toString());
/*     */     }
/* 227 */     return paramObject;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ci.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */