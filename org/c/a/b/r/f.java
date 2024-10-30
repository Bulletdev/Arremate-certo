/*    */ package org.c.a.b.r;
/*    */ 
/*    */ import java.sql.SQLException;
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
/*    */ public class f
/*    */ {
/*    */   public static Throwable getRootCause(Throwable paramThrowable) {
/* 38 */     if (paramThrowable == null) {
/* 39 */       return null;
/*    */     }
/*    */     
/* 42 */     Throwable throwable1 = paramThrowable;
/*    */     Throwable throwable2;
/* 44 */     while ((throwable2 = throwable1.getCause()) != null) {
/* 45 */       throwable1 = throwable2;
/*    */     }
/*    */     
/* 48 */     return throwable1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String a(SQLException paramSQLException) {
/* 58 */     SQLException sQLException = paramSQLException;
/* 59 */     while (sQLException.getNextException() != null) {
/* 60 */       sQLException = sQLException.getNextException();
/*    */     }
/*    */ 
/*    */     
/* 64 */     String str = "SQL State  : " + sQLException.getSQLState() + "\nError Code : " + sQLException.getErrorCode() + "\n";
/* 65 */     if (sQLException.getMessage() != null) {
/* 66 */       str = str + "Message    : " + sQLException.getMessage().trim() + "\n";
/*    */     }
/*    */     
/* 69 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */