/*     */ package org.a.a.k;
/*     */ 
/*     */ import org.a.a.k.a.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*     */   private a() {
/*  32 */     throw new AssertionError("shouldn't be instantiated");
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
/*     */   @d({"#1"})
/*     */   public static <T> T K(T paramT) {
/*  71 */     assert paramT != null : "Misuse of castNonNull: called with a null argument";
/*  72 */     return paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d({"#1"})
/*     */   public static <T> T[] c(T[] paramArrayOfT) {
/*  84 */     return d(paramArrayOfT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d({"#1"})
/*     */   public static <T> T[][] a(T[][] paramArrayOfT) {
/*  96 */     return (T[][])d((Object[][])paramArrayOfT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d({"#1"})
/*     */   public static <T> T[][][] a(T[][][] paramArrayOfT) {
/* 108 */     return (T[][][])d((Object[][][])paramArrayOfT);
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
/*     */   @d({"#1"})
/*     */   public static <T> T[][][][] a(T[][][][] paramArrayOfT) {
/* 121 */     return (T[][][][])d((Object[][][][])paramArrayOfT);
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
/*     */   @d({"#1"})
/*     */   public static <T> T[][][][][] a(T[][][][][] paramArrayOfT) {
/* 134 */     return (T[][][][][])d((Object[][][][][])paramArrayOfT);
/*     */   }
/*     */ 
/*     */   
/*     */   private static <T> T[] d(T[] paramArrayOfT) {
/* 139 */     assert paramArrayOfT != null : "Misuse of castNonNullArray: called with a null array argument";
/* 140 */     for (byte b = 0; b < paramArrayOfT.length; b++) {
/* 141 */       assert paramArrayOfT[b] != null : "Misuse of castNonNull: called with a null array element";
/* 142 */       E(paramArrayOfT[b]);
/*     */     } 
/* 144 */     return paramArrayOfT;
/*     */   }
/*     */   
/*     */   private static void E(Object paramObject) {
/* 148 */     assert paramObject != null : "Misuse of checkIfArray: called with a null argument";
/* 149 */     Class<?> clazz = paramObject.getClass().getComponentType();
/* 150 */     if (clazz != null)
/*     */     {
/* 152 */       if (!clazz.isPrimitive())
/*     */       {
/*     */ 
/*     */         
/* 156 */         d((Object[])paramObject);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\k\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */