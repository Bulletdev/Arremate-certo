/*    */ package org.apache.commons.text.lookup;
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
/*    */ final class IllegalArgumentExceptions
/*    */ {
/*    */   static IllegalArgumentException format(String paramString, Object... paramVarArgs) {
/* 36 */     return new IllegalArgumentException(String.format(paramString, paramVarArgs));
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
/*    */   static IllegalArgumentException format(Throwable paramThrowable, String paramString, Object... paramVarArgs) {
/* 49 */     return new IllegalArgumentException(String.format(paramString, paramVarArgs), paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\IllegalArgumentExceptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */