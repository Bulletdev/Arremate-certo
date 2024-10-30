/*    */ package org.apache.http;
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
/*    */ public interface ExceptionLogger
/*    */ {
/* 34 */   public static final ExceptionLogger NO_OP = new ExceptionLogger()
/*    */     {
/*    */       public void log(Exception param1Exception) {}
/*    */     };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 43 */   public static final ExceptionLogger STD_ERR = new ExceptionLogger()
/*    */     {
/*    */       public void log(Exception param1Exception)
/*    */       {
/* 47 */         param1Exception.printStackTrace();
/*    */       }
/*    */     };
/*    */   
/*    */   void log(Exception paramException);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\ExceptionLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */