/*     */ package org.junit.c;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Arrays;
/*     */ import org.junit.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class e
/*     */ {
/*     */   public void h(String paramString, Object paramObject1, Object paramObject2) throws a {
/*  28 */     a(paramString, paramObject1, paramObject2, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(String paramString, Object paramObject1, Object paramObject2, boolean paramBoolean) throws a {
/*  33 */     if (paramObject1 == paramObject2 || Arrays.deepEquals(new Object[] { paramObject1 }, new Object[] { paramObject2 })) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  40 */     String str1 = (paramString == null) ? "" : (paramString + ": ");
/*     */ 
/*     */     
/*  43 */     String str2 = paramBoolean ? str1 : "";
/*     */     
/*  45 */     if (paramObject1 == null) {
/*  46 */       c.fail(str2 + "expected array was null");
/*     */     }
/*  48 */     if (paramObject2 == null) {
/*  49 */       c.fail(str2 + "actual array was null");
/*     */     }
/*     */     
/*  52 */     int i = Array.getLength(paramObject2);
/*  53 */     int j = Array.getLength(paramObject1);
/*  54 */     if (i != j) {
/*  55 */       str1 = str1 + "array lengths differed, expected.length=" + j + " actual.length=" + i + "; ";
/*     */     }
/*     */     
/*  58 */     int k = Math.min(i, j);
/*     */     
/*  60 */     for (byte b = 0; b < k; b++) {
/*  61 */       Object object1 = Array.get(paramObject1, b);
/*  62 */       Object object2 = Array.get(paramObject2, b);
/*     */       
/*  64 */       if (isArray(object1) && isArray(object2)) {
/*     */         try {
/*  66 */           a(paramString, object1, object2, false);
/*  67 */         } catch (a a) {
/*  68 */           a.bt(b);
/*  69 */           throw a;
/*  70 */         } catch (AssertionError assertionError) {
/*     */           
/*  72 */           throw new a(str1, assertionError, b);
/*     */         } 
/*     */       } else {
/*     */         try {
/*  76 */           l(object1, object2);
/*  77 */         } catch (AssertionError assertionError) {
/*  78 */           throw new a(str1, assertionError, b);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  83 */     if (i != j) {
/*  84 */       Object object1 = a(paramObject1, j, k);
/*  85 */       Object object2 = a(paramObject2, i, k);
/*     */       try {
/*  87 */         c.h(object1, object2);
/*  88 */       } catch (AssertionError assertionError) {
/*  89 */         throw new a(str1, assertionError, k);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*  94 */   private static final Object aE = g("end of array");
/*     */   
/*     */   private Object a(Object paramObject, int paramInt1, int paramInt2) {
/*  97 */     if (paramInt2 < paramInt1) {
/*  98 */       Object object = Array.get(paramObject, paramInt2);
/*  99 */       if (isArray(object)) {
/* 100 */         return g(e(object.getClass()) + "[" + Array.getLength(object) + "]");
/*     */       }
/* 102 */       return object;
/*     */     } 
/*     */     
/* 105 */     return aE;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Object g(String paramString) {
/* 110 */     return new Object(paramString)
/*     */       {
/*     */         public String toString() {
/* 113 */           return this.lR;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private String e(Class<?> paramClass) {
/* 119 */     Class<?> clazz = paramClass.getComponentType();
/* 120 */     if (clazz.isArray()) {
/* 121 */       return e(clazz) + "[]";
/*     */     }
/* 123 */     return clazz.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isArray(Object paramObject) {
/* 128 */     return (paramObject != null && paramObject.getClass().isArray());
/*     */   }
/*     */   
/*     */   protected abstract void l(Object paramObject1, Object paramObject2);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */