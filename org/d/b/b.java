/*    */ package org.d.b;
/*    */ 
/*    */ import java.lang.reflect.Method;
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
/*    */ 
/*    */ public class b
/*    */ {
/*    */   private final String methodName;
/*    */   private final int iK;
/*    */   private final int iL;
/*    */   
/*    */   public b(String paramString, int paramInt1, int paramInt2) {
/* 36 */     this.methodName = paramString;
/* 37 */     this.iK = paramInt1;
/* 38 */     this.iL = paramInt2;
/*    */   }
/*    */   
/*    */   public Class<?> f(Class<?> paramClass) {
/* 42 */     for (Class<?> clazz = paramClass; clazz != Object.class; clazz = clazz.getSuperclass()) {
/* 43 */       for (Method method : clazz.getDeclaredMethods()) {
/* 44 */         if (e(method)) {
/* 45 */           return a(method);
/*    */         }
/*    */       } 
/*    */     } 
/* 49 */     throw new Error("Cannot determine correct type for " + this.methodName + "() method.");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean e(Method paramMethod) {
/* 57 */     return (paramMethod.getName().equals(this.methodName) && (paramMethod.getParameterTypes()).length == this.iK && !paramMethod.isSynthetic());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Class<?> a(Method paramMethod) {
/* 68 */     return paramMethod.getParameterTypes()[this.iL];
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\b\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */