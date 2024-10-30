/*    */ package com.google.a.n;
/*    */ 
/*    */ import com.google.a.d.cG;
/*    */ import java.lang.reflect.GenericArrayType;
/*    */ import java.lang.reflect.ParameterizedType;
/*    */ import java.lang.reflect.Type;
/*    */ import java.lang.reflect.TypeVariable;
/*    */ import java.lang.reflect.WildcardType;
/*    */ import java.util.Set;
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
/*    */ abstract class n
/*    */ {
/* 58 */   private final Set<Type> C = cG.a();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(Type... paramVarArgs) {
/* 65 */     for (Type type : paramVarArgs) {
/* 66 */       if (type != null && this.C.add(type))
/*    */       {
/*    */ 
/*    */         
/* 70 */         boolean bool = false;
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   void a(Class<?> paramClass) {}
/*    */   
/*    */   void a(GenericArrayType paramGenericArrayType) {}
/*    */   
/*    */   void a(ParameterizedType paramParameterizedType) {}
/*    */   
/*    */   void a(TypeVariable<?> paramTypeVariable) {}
/*    */   
/*    */   void a(WildcardType paramWildcardType) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */