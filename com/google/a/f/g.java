/*     */ package com.google.a.f;
/*     */ 
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.c.a.i;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.concurrent.Executor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class g
/*     */ {
/*     */   @i
/*     */   private e a;
/*     */   @d
/*     */   final Object target;
/*     */   private final Method method;
/*     */   private final Executor executor;
/*     */   
/*     */   static g a(e parame, Object paramObject, Method paramMethod) {
/*  39 */     return a(paramMethod) ? 
/*  40 */       new g(parame, paramObject, paramMethod) : 
/*  41 */       new a(parame, paramObject, paramMethod);
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
/*     */   private g(e parame, Object paramObject, Method paramMethod) {
/*  57 */     this.a = parame;
/*  58 */     this.target = D.checkNotNull(paramObject);
/*  59 */     this.method = paramMethod;
/*  60 */     paramMethod.setAccessible(true);
/*     */     
/*  62 */     this.executor = parame.a();
/*     */   }
/*     */ 
/*     */   
/*     */   final void r(Object paramObject) {
/*  67 */     this.executor.execute(new Runnable(this, paramObject)
/*     */         {
/*     */           public void run()
/*     */           {
/*     */             try {
/*  72 */               this.b.s(this.ab);
/*  73 */             } catch (InvocationTargetException invocationTargetException) {
/*  74 */               g.a(this.b).a(invocationTargetException.getCause(), g.a(this.b, this.ab));
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   void s(Object paramObject) throws InvocationTargetException {
/*     */     try {
/*  87 */       this.method.invoke(this.target, new Object[] { D.checkNotNull(paramObject) });
/*  88 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  89 */       String str = String.valueOf(paramObject); throw new Error((new StringBuilder(33 + String.valueOf(str).length())).append("Method rejected target/argument: ").append(str).toString(), illegalArgumentException);
/*  90 */     } catch (IllegalAccessException illegalAccessException) {
/*  91 */       String str = String.valueOf(paramObject); throw new Error((new StringBuilder(28 + String.valueOf(str).length())).append("Method became inaccessible: ").append(str).toString(), illegalAccessException);
/*  92 */     } catch (InvocationTargetException invocationTargetException) {
/*  93 */       if (invocationTargetException.getCause() instanceof Error) {
/*  94 */         throw (Error)invocationTargetException.getCause();
/*     */       }
/*  96 */       throw invocationTargetException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private h a(Object paramObject) {
/* 102 */     return new h(this.a, paramObject, this.target, this.method);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 107 */     return (31 + this.method.hashCode()) * 31 + System.identityHashCode(this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 112 */     if (paramObject instanceof g) {
/* 113 */       g g1 = (g)paramObject;
/*     */ 
/*     */ 
/*     */       
/* 117 */       return (this.target == g1.target && this.method.equals(g1.method));
/*     */     } 
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(Method paramMethod) {
/* 127 */     return (paramMethod.getAnnotation(a.class) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   static final class a
/*     */     extends g
/*     */   {
/*     */     private a(e param1e, Object param1Object, Method param1Method) {
/* 138 */       super(param1e, param1Object, param1Method);
/*     */     }
/*     */ 
/*     */     
/*     */     void s(Object param1Object) throws InvocationTargetException {
/* 143 */       synchronized (this) {
/* 144 */         super.s(param1Object);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\f\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */