/*    */ package org.junit.c;
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
/*    */ public final class c
/*    */ {
/*    */   public static <T> T notNull(T paramT) {
/* 16 */     if (paramT == null) {
/* 17 */       throw new NullPointerException();
/*    */     }
/* 19 */     return paramT;
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
/*    */   public static <T> T notNull(T paramT, String paramString) {
/* 32 */     if (paramT == null) {
/* 33 */       throw new NullPointerException(paramString);
/*    */     }
/* 35 */     return paramT;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */