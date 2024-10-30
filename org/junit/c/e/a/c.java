/*    */ package org.junit.c.e.a;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class c
/*    */ {
/*    */   public Object run() throws Throwable {
/*    */     try {
/* 12 */       return P();
/* 13 */     } catch (InvocationTargetException invocationTargetException) {
/* 14 */       throw invocationTargetException.getTargetException();
/*    */     } 
/*    */   }
/*    */   
/*    */   protected abstract Object P() throws Throwable;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\a\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */