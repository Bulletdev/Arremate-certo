/*    */ package org.d.a;
/*    */ 
/*    */ import org.d.g;
/*    */ import org.d.h;
/*    */ import org.d.i;
/*    */ import org.d.k;
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
/*    */ public class j
/*    */   extends h<Object>
/*    */ {
/*    */   private final Class<?> i;
/*    */   private final Class<?> j;
/*    */   
/*    */   public j(Class<?> paramClass) {
/* 26 */     this.i = paramClass;
/* 27 */     this.j = e(paramClass);
/*    */   }
/*    */   
/*    */   private static Class<?> e(Class<?> paramClass) {
/* 31 */     if (boolean.class.equals(paramClass)) return Boolean.class; 
/* 32 */     if (byte.class.equals(paramClass)) return Byte.class; 
/* 33 */     if (char.class.equals(paramClass)) return Character.class; 
/* 34 */     if (double.class.equals(paramClass)) return Double.class; 
/* 35 */     if (float.class.equals(paramClass)) return Float.class; 
/* 36 */     if (int.class.equals(paramClass)) return Integer.class; 
/* 37 */     if (long.class.equals(paramClass)) return Long.class; 
/* 38 */     if (short.class.equals(paramClass)) return Short.class; 
/* 39 */     return paramClass;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean a(Object paramObject, g paramg) {
/* 44 */     if (null == paramObject) {
/* 45 */       paramg.a("null");
/* 46 */       return false;
/*    */     } 
/*    */     
/* 49 */     if (!this.j.isInstance(paramObject)) {
/* 50 */       paramg.a(paramObject).a(" is a " + paramObject.getClass().getName());
/* 51 */       return false;
/*    */     } 
/*    */     
/* 54 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(g paramg) {
/* 59 */     paramg.a("an instance of ").a(this.i.getName());
/*    */   }
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
/*    */   @i
/*    */   public static <T> k<T> d(Class<?> paramClass) {
/* 76 */     return (k<T>)new j(paramClass);
/*    */   }
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
/*    */   @i
/*    */   public static <T> k<T> c(Class<T> paramClass) {
/* 95 */     return (k<T>)new j(paramClass);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */