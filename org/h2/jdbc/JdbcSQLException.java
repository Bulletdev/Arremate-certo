/*     */ package org.h2.jdbc;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JdbcSQLException
/*     */   extends SQLException
/*     */ {
/*     */   public static final String HIDE_SQL = "--hide--";
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String originalMessage;
/*     */   private final Throwable cause;
/*     */   private final String stackTrace;
/*     */   private String message;
/*     */   private String sql;
/*     */   
/*     */   public JdbcSQLException(String paramString1, String paramString2, String paramString3, int paramInt, Throwable paramThrowable, String paramString4) {
/*  45 */     super(paramString1, paramString3, paramInt);
/*  46 */     this.originalMessage = paramString1;
/*  47 */     setSQL(paramString2);
/*  48 */     this.cause = paramThrowable;
/*  49 */     this.stackTrace = paramString4;
/*  50 */     buildMessage();
/*  51 */     initCause(paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/*  61 */     return this.message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOriginalMessage() {
/*  68 */     return this.originalMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace() {
/*  80 */     printStackTrace(System.err);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintWriter paramPrintWriter) {
/*  90 */     if (paramPrintWriter != null) {
/*  91 */       super.printStackTrace(paramPrintWriter);
/*     */ 
/*     */       
/*  94 */       SQLException sQLException = getNextException();
/*  95 */       for (byte b = 0; b < 100 && sQLException != null; b++) {
/*  96 */         paramPrintWriter.println(sQLException.toString());
/*  97 */         sQLException = sQLException.getNextException();
/*     */       } 
/*  99 */       if (sQLException != null) {
/* 100 */         paramPrintWriter.println("(truncated)");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintStream paramPrintStream) {
/* 112 */     if (paramPrintStream != null) {
/* 113 */       super.printStackTrace(paramPrintStream);
/*     */ 
/*     */       
/* 116 */       SQLException sQLException = getNextException();
/* 117 */       for (byte b = 0; b < 100 && sQLException != null; b++) {
/* 118 */         paramPrintStream.println(sQLException.toString());
/* 119 */         sQLException = sQLException.getNextException();
/*     */       } 
/* 121 */       if (sQLException != null) {
/* 122 */         paramPrintStream.println("(truncated)");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getOriginalCause() {
/* 131 */     return this.cause;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 141 */     return this.sql;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSQL(String paramString) {
/* 148 */     if (paramString != null && paramString.contains("--hide--")) {
/* 149 */       paramString = "-";
/*     */     }
/* 151 */     this.sql = paramString;
/* 152 */     buildMessage();
/*     */   }
/*     */   
/*     */   private void buildMessage() {
/* 156 */     StringBuilder stringBuilder = new StringBuilder((this.originalMessage == null) ? "- " : this.originalMessage);
/*     */     
/* 158 */     if (this.sql != null) {
/* 159 */       stringBuilder.append("; SQL statement:\n").append(this.sql);
/*     */     }
/* 161 */     stringBuilder.append(" [").append(getErrorCode()).append('-').append(193).append(']');
/*     */     
/* 163 */     this.message = stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 174 */     if (this.stackTrace == null) {
/* 175 */       return super.toString();
/*     */     }
/* 177 */     return this.stackTrace;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcSQLException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */