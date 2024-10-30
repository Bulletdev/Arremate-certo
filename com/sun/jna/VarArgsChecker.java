/*    */ package com.sun.jna;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class VarArgsChecker
/*    */ {
/*    */   private VarArgsChecker() {}
/*    */   
/*    */   private static final class RealVarArgsChecker
/*    */     extends VarArgsChecker
/*    */   {
/*    */     private RealVarArgsChecker() {}
/*    */     
/*    */     boolean isVarArgs(Method param1Method) {
/* 47 */       return param1Method.isVarArgs();
/*    */     }
/*    */ 
/*    */     
/*    */     int fixedArgs(Method param1Method) {
/* 52 */       return param1Method.isVarArgs() ? ((param1Method.getParameterTypes()).length - 1) : 0;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private static final class NoVarArgsChecker
/*    */     extends VarArgsChecker
/*    */   {
/*    */     private NoVarArgsChecker() {}
/*    */     
/*    */     boolean isVarArgs(Method param1Method) {
/* 63 */       return false;
/*    */     }
/*    */     
/*    */     int fixedArgs(Method param1Method) {
/* 67 */       return 0;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static VarArgsChecker create() {
/*    */     try {
/* 79 */       Method method = Method.class.getMethod("isVarArgs", new Class[0]);
/* 80 */       if (method != null)
/*    */       {
/* 82 */         return new RealVarArgsChecker();
/*    */       }
/* 84 */       return new NoVarArgsChecker();
/*    */     }
/* 86 */     catch (NoSuchMethodException noSuchMethodException) {
/* 87 */       return new NoVarArgsChecker();
/* 88 */     } catch (SecurityException securityException) {
/* 89 */       return new NoVarArgsChecker();
/*    */     } 
/*    */   }
/*    */   
/*    */   abstract boolean isVarArgs(Method paramMethod);
/*    */   
/*    */   abstract int fixedArgs(Method paramMethod);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\VarArgsChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */