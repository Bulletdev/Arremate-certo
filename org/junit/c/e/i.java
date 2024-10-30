/*    */ package org.junit.c.e;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.lang.reflect.Method;
/*    */ import java.lang.reflect.Modifier;
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
/*    */ public class i
/*    */   extends e
/*    */ {
/*    */   public i(Class<?> paramClass) throws Throwable {
/* 24 */     super(b(paramClass));
/*    */   }
/*    */   
/*    */   public static junit.b.i b(Class<?> paramClass) throws Throwable {
/* 28 */     Method method = null;
/* 29 */     junit.b.i i1 = null;
/*    */     try {
/* 31 */       method = paramClass.getMethod("suite", new Class[0]);
/* 32 */       if (!Modifier.isStatic(method.getModifiers())) {
/* 33 */         throw new Exception(paramClass.getName() + ".suite() must be static");
/*    */       }
/* 35 */       i1 = (junit.b.i)method.invoke(null, new Object[0]);
/* 36 */     } catch (InvocationTargetException invocationTargetException) {
/* 37 */       throw invocationTargetException.getCause();
/*    */     } 
/* 39 */     return i1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */