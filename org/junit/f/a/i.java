/*    */ package org.junit.f.a;
/*    */ 
/*    */ import java.lang.reflect.GenericArrayType;
/*    */ import java.lang.reflect.Method;
/*    */ import java.lang.reflect.ParameterizedType;
/*    */ import java.lang.reflect.Type;
/*    */ import java.lang.reflect.WildcardType;
/*    */ import java.util.List;
/*    */ 
/*    */ class i
/*    */ {
/*    */   private final Method method;
/*    */   
/*    */   i(Method paramMethod) {
/* 15 */     this.method = paramMethod;
/*    */   }
/*    */   
/*    */   void J(List<Throwable> paramList) {
/* 19 */     for (Type type : this.method.getGenericParameterTypes()) {
/* 20 */       a(type, paramList);
/*    */     }
/*    */   }
/*    */   
/*    */   private void a(Type paramType, List<Throwable> paramList) {
/* 25 */     if (paramType instanceof java.lang.reflect.TypeVariable) {
/* 26 */       paramList.add(new Exception("Method " + this.method.getName() + "() contains unresolved type variable " + paramType));
/*    */     }
/* 28 */     else if (paramType instanceof ParameterizedType) {
/* 29 */       a((ParameterizedType)paramType, paramList);
/* 30 */     } else if (paramType instanceof WildcardType) {
/* 31 */       a((WildcardType)paramType, paramList);
/* 32 */     } else if (paramType instanceof GenericArrayType) {
/* 33 */       a((GenericArrayType)paramType, paramList);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void a(ParameterizedType paramParameterizedType, List<Throwable> paramList) {
/* 39 */     for (Type type : paramParameterizedType.getActualTypeArguments()) {
/* 40 */       a(type, paramList);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private void a(WildcardType paramWildcardType, List<Throwable> paramList) {
/* 46 */     for (Type type : paramWildcardType.getUpperBounds()) {
/* 47 */       a(type, paramList);
/*    */     }
/* 49 */     for (Type type : paramWildcardType.getLowerBounds()) {
/* 50 */       a(type, paramList);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private void a(GenericArrayType paramGenericArrayType, List<Throwable> paramList) {
/* 56 */     a(paramGenericArrayType.getGenericComponentType(), paramList);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\a\i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */