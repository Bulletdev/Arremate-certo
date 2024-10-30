/*     */ package com.google.a.n;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class a
/*     */   implements InvocationHandler
/*     */ {
/*  44 */   private static final Object[] o = new Object[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) throws Throwable {
/*  64 */     if (paramArrayOfObject == null) {
/*  65 */       paramArrayOfObject = o;
/*     */     }
/*  67 */     if (paramArrayOfObject.length == 0 && paramMethod.getName().equals("hashCode")) {
/*  68 */       return Integer.valueOf(hashCode());
/*     */     }
/*  70 */     if (paramArrayOfObject.length == 1 && paramMethod
/*  71 */       .getName().equals("equals") && paramMethod
/*  72 */       .getParameterTypes()[0] == Object.class) {
/*  73 */       Object object = paramArrayOfObject[0];
/*  74 */       if (object == null) {
/*  75 */         return Boolean.valueOf(false);
/*     */       }
/*  77 */       if (paramObject == object) {
/*  78 */         return Boolean.valueOf(true);
/*     */       }
/*  80 */       return Boolean.valueOf((a(object, paramObject.getClass()) && 
/*  81 */           equals(Proxy.getInvocationHandler(object))));
/*     */     } 
/*  83 */     if (paramArrayOfObject.length == 0 && paramMethod.getName().equals("toString")) {
/*  84 */       return toString();
/*     */     }
/*  86 */     return a(paramObject, paramMethod, paramArrayOfObject);
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
/*     */   protected abstract Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) throws Throwable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 113 */     return super.equals(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 122 */     return super.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 132 */     return super.toString();
/*     */   }
/*     */   
/*     */   private static boolean a(Object paramObject, Class<?> paramClass) {
/* 136 */     return (paramClass.isInstance(paramObject) || (
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       Proxy.isProxyClass(paramObject.getClass()) && 
/* 143 */       Arrays.equals((Object[])paramObject.getClass().getInterfaces(), (Object[])paramClass.getInterfaces())));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */