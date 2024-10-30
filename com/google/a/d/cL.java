/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.L;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ final class cl
/*     */ {
/*  33 */   private static final Logger logger = Logger.getLogger(cl.class.getName());
/*     */ 
/*     */   
/*     */   static <K, V> Map<K, V> c(int paramInt) {
/*  37 */     return bW.a(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <K, V> Map<K, V> d(int paramInt) {
/*  45 */     return bW.a(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   static <E> Set<E> b(int paramInt) {
/*  50 */     return cG.a(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <E> Set<E> c(int paramInt) {
/*  58 */     return cG.a(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <K, V> Map<K, V> J() {
/*  66 */     return bW.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <E> Set<E> s() {
/*  74 */     return cG.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <T> T[] a(T[] paramArrayOfT, int paramInt) {
/*  84 */     Class<?> clazz = paramArrayOfT.getClass().getComponentType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     return (T[])Array.newInstance(clazz, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static <T> T[] b(Object[] paramArrayOfObject, int paramInt1, int paramInt2, T[] paramArrayOfT) {
/*  95 */     return Arrays.copyOfRange(paramArrayOfObject, paramInt1, paramInt2, (Class)paramArrayOfT.getClass());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static bU a(bU parambU) {
/* 104 */     return parambU.a();
/*     */   }
/*     */   
/*     */   static int B(int paramInt) {
/* 108 */     return paramInt;
/*     */   }
/*     */   
/*     */   static int C(int paramInt) {
/* 112 */     return paramInt;
/*     */   }
/*     */   
/*     */   static void ez() {
/* 116 */     String str = "guava.gwt.emergency_reenable_rpc";
/*     */     
/* 118 */     if (!Boolean.parseBoolean(System.getProperty(str, "false"))) {
/* 119 */       throw new UnsupportedOperationException(
/* 120 */           L.a("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", new Object[] { str, "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ" }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     logger.log(Level.WARNING, "Later in 2020, we will remove GWT-RPC support for Guava types. You are seeing this warning because you are sending a Guava type over GWT-RPC, which will break. You can identify which type by looking at the class name in the attached stack trace.", new Throwable());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */