/*    */ package org.junit.c.c;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import org.d.b;
/*    */ import org.junit.c.i;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public abstract class d<T>
/*    */   extends b<T>
/*    */ {
/*    */   private Class<?> h;
/*    */   
/*    */   public abstract boolean F(T paramT);
/*    */   
/*    */   protected d() {
/* 27 */     this.h = f(getClass());
/*    */   }
/*    */   
/*    */   private static Class<?> f(Class<?> paramClass) {
/* 31 */     for (Class<?> clazz = paramClass; clazz != Object.class; clazz = clazz.getSuperclass()) {
/* 32 */       for (Method method : i.a(clazz)) {
/* 33 */         if (f(method)) {
/* 34 */           return method.getParameterTypes()[0];
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 39 */     throw new Error("Cannot determine correct type for matchesSafely() method.");
/*    */   }
/*    */   
/*    */   private static boolean f(Method paramMethod) {
/* 43 */     return ("matchesSafely".equals(paramMethod.getName()) && (paramMethod.getParameterTypes()).length == 1 && !paramMethod.isSynthetic());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected d(Class<T> paramClass) {
/* 49 */     this.h = paramClass;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean E(Object paramObject) {
/* 59 */     return (paramObject != null && this.h.isInstance(paramObject) && F((T)paramObject));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\c\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */