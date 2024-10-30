/*    */ package com.google.a.n;
/*    */ 
/*    */ import com.google.a.b.D;
/*    */ import java.lang.reflect.ParameterizedType;
/*    */ import java.lang.reflect.Type;
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
/*    */ abstract class i<T>
/*    */ {
/*    */   final Type b() {
/* 31 */     Type type = getClass().getGenericSuperclass();
/* 32 */     D.a(type instanceof ParameterizedType, "%s isn't parameterized", type);
/* 33 */     return ((ParameterizedType)type).getActualTypeArguments()[0];
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */