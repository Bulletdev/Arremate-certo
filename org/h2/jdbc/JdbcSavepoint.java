/*     */ package org.h2.jdbc;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Savepoint;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.message.TraceObject;
/*     */ import org.h2.util.StringUtils;
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
/*     */ public class JdbcSavepoint
/*     */   extends TraceObject
/*     */   implements Savepoint
/*     */ {
/*     */   private static final String SYSTEM_SAVEPOINT_PREFIX = "SYSTEM_SAVEPOINT_";
/*     */   private final int savepointId;
/*     */   private final String name;
/*     */   private JdbcConnection conn;
/*     */   
/*     */   JdbcSavepoint(JdbcConnection paramJdbcConnection, int paramInt1, String paramString, Trace paramTrace, int paramInt2) {
/*  32 */     setTrace(paramTrace, 6, paramInt2);
/*  33 */     this.conn = paramJdbcConnection;
/*  34 */     this.savepointId = paramInt1;
/*  35 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void release() {
/*  43 */     this.conn = null;
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
/*     */   static String getName(String paramString, int paramInt) {
/*  55 */     if (paramString != null) {
/*  56 */       return StringUtils.quoteJavaString(paramString);
/*     */     }
/*  58 */     return "SYSTEM_SAVEPOINT_" + paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void rollback() {
/*  65 */     checkValid();
/*  66 */     this.conn.prepareCommand("ROLLBACK TO SAVEPOINT " + getName(this.name, this.savepointId), 2147483647).executeUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkValid() {
/*  72 */     if (this.conn == null) {
/*  73 */       throw DbException.get(90063, getName(this.name, this.savepointId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSavepointId() throws SQLException {
/*     */     try {
/*  85 */       debugCodeCall("getSavepointId");
/*  86 */       checkValid();
/*  87 */       if (this.name != null) {
/*  88 */         throw DbException.get(90065);
/*     */       }
/*  90 */       return this.savepointId;
/*  91 */     } catch (Exception exception) {
/*  92 */       throw logAndConvert(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSavepointName() throws SQLException {
/*     */     try {
/* 103 */       debugCodeCall("getSavepointName");
/* 104 */       checkValid();
/* 105 */       if (this.name == null) {
/* 106 */         throw DbException.get(90064);
/*     */       }
/* 108 */       return this.name;
/* 109 */     } catch (Exception exception) {
/* 110 */       throw logAndConvert(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     return getTraceObjectName() + ": id=" + this.savepointId + " name=" + this.name;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcSavepoint.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */