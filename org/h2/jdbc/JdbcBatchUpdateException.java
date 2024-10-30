/*    */ package org.h2.jdbc;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import java.sql.BatchUpdateException;
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
/*    */ public class JdbcBatchUpdateException
/*    */   extends BatchUpdateException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   JdbcBatchUpdateException(SQLException paramSQLException, int[] paramArrayOfint) {
/* 24 */     super(paramSQLException.getMessage(), paramSQLException.getSQLState(), paramSQLException.getErrorCode(), paramArrayOfint);
/* 25 */     setNextException(paramSQLException);
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
/*    */   public void printStackTrace() {
/* 37 */     printStackTrace(System.err);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void printStackTrace(PrintWriter paramPrintWriter) {
/* 45 */     if (paramPrintWriter != null) {
/* 46 */       super.printStackTrace(paramPrintWriter);
/* 47 */       if (getNextException() != null) {
/* 48 */         getNextException().printStackTrace(paramPrintWriter);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void printStackTrace(PrintStream paramPrintStream) {
/* 58 */     if (paramPrintStream != null) {
/* 59 */       super.printStackTrace(paramPrintStream);
/* 60 */       if (getNextException() != null)
/* 61 */         getNextException().printStackTrace(paramPrintStream); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcBatchUpdateException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */