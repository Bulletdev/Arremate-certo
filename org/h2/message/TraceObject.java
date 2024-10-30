/*     */ package org.h2.message;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Date;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Map;
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
/*     */ public class TraceObject
/*     */ {
/*     */   protected static final int CALLABLE_STATEMENT = 0;
/*     */   protected static final int CONNECTION = 1;
/*     */   protected static final int DATABASE_META_DATA = 2;
/*     */   protected static final int PREPARED_STATEMENT = 3;
/*     */   protected static final int RESULT_SET = 4;
/*     */   protected static final int RESULT_SET_META_DATA = 5;
/*     */   protected static final int SAVEPOINT = 6;
/*     */   protected static final int STATEMENT = 8;
/*     */   protected static final int BLOB = 9;
/*     */   protected static final int CLOB = 10;
/*     */   protected static final int PARAMETER_META_DATA = 11;
/*     */   protected static final int DATA_SOURCE = 12;
/*     */   protected static final int XA_DATA_SOURCE = 13;
/*     */   protected static final int XID = 15;
/*     */   protected static final int ARRAY = 16;
/*     */   private static final int LAST = 17;
/*  94 */   private static final int[] ID = new int[17];
/*  95 */   private static final String[] PREFIX = new String[] { "call", "conn", "dbMeta", "prep", "rs", "rsMeta", "sp", "ex", "stat", "blob", "clob", "pMeta", "ds", "xads", "xares", "xid", "ar" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Trace trace;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int traceType;
/*     */ 
/*     */ 
/*     */   
/*     */   private int id;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setTrace(Trace paramTrace, int paramInt1, int paramInt2) {
/* 115 */     this.trace = paramTrace;
/* 116 */     this.traceType = paramInt1;
/* 117 */     this.id = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTraceId() {
/* 124 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTraceObjectName() {
/* 131 */     return PREFIX[this.traceType] + this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static int getNextId(int paramInt) {
/* 141 */     ID[paramInt] = ID[paramInt] + 1; return ID[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isDebugEnabled() {
/* 150 */     return this.trace.isDebugEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isInfoEnabled() {
/* 159 */     return this.trace.isInfoEnabled();
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
/*     */ 
/*     */   
/*     */   protected void debugCodeAssign(String paramString1, int paramInt1, int paramInt2, String paramString2) {
/* 173 */     if (this.trace.isDebugEnabled()) {
/* 174 */       this.trace.debugCode(paramString1 + " " + PREFIX[paramInt1] + paramInt2 + " = " + getTraceObjectName() + "." + paramString2 + ";");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void debugCodeCall(String paramString) {
/* 186 */     if (this.trace.isDebugEnabled()) {
/* 187 */       this.trace.debugCode(getTraceObjectName() + "." + paramString + "();");
/*     */     }
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
/*     */   protected void debugCodeCall(String paramString, long paramLong) {
/* 200 */     if (this.trace.isDebugEnabled()) {
/* 201 */       this.trace.debugCode(getTraceObjectName() + "." + paramString + "(" + paramLong + ");");
/*     */     }
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
/*     */   
/*     */   protected void debugCodeCall(String paramString1, String paramString2) {
/* 215 */     if (this.trace.isDebugEnabled()) {
/* 216 */       this.trace.debugCode(getTraceObjectName() + "." + paramString1 + "(" + quote(paramString2) + ");");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void debugCode(String paramString) {
/* 227 */     if (this.trace.isDebugEnabled()) {
/* 228 */       this.trace.debugCode(getTraceObjectName() + "." + paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String quote(String paramString) {
/* 239 */     return StringUtils.quoteJavaString(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String quoteTime(Time paramTime) {
/* 249 */     if (paramTime == null) {
/* 250 */       return "null";
/*     */     }
/* 252 */     return "Time.valueOf(\"" + paramTime.toString() + "\")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String quoteTimestamp(Timestamp paramTimestamp) {
/* 262 */     if (paramTimestamp == null) {
/* 263 */       return "null";
/*     */     }
/* 265 */     return "Timestamp.valueOf(\"" + paramTimestamp.toString() + "\")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String quoteDate(Date paramDate) {
/* 275 */     if (paramDate == null) {
/* 276 */       return "null";
/*     */     }
/* 278 */     return "Date.valueOf(\"" + paramDate.toString() + "\")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String quoteBigDecimal(BigDecimal paramBigDecimal) {
/* 288 */     if (paramBigDecimal == null) {
/* 289 */       return "null";
/*     */     }
/* 291 */     return "new BigDecimal(\"" + paramBigDecimal.toString() + "\")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String quoteBytes(byte[] paramArrayOfbyte) {
/* 301 */     if (paramArrayOfbyte == null) {
/* 302 */       return "null";
/*     */     }
/* 304 */     return "org.h2.util.StringUtils.convertHexToBytes(\"" + StringUtils.convertBytesToHex(paramArrayOfbyte) + "\")";
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
/*     */   protected static String quoteArray(String[] paramArrayOfString) {
/* 316 */     return StringUtils.quoteJavaStringArray(paramArrayOfString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String quoteIntArray(int[] paramArrayOfint) {
/* 326 */     return StringUtils.quoteJavaIntArray(paramArrayOfint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String quoteMap(Map<String, Class<?>> paramMap) {
/* 336 */     if (paramMap == null) {
/* 337 */       return "null";
/*     */     }
/* 339 */     if (paramMap.size() == 0) {
/* 340 */       return "new Map()";
/*     */     }
/* 342 */     return "new Map() /* " + paramMap.toString() + " */";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SQLException logAndConvert(Exception paramException) {
/* 352 */     SQLException sQLException = DbException.toSQLException(paramException);
/* 353 */     if (this.trace == null) {
/* 354 */       DbException.traceThrowable(sQLException);
/*     */     } else {
/* 356 */       int i = sQLException.getErrorCode();
/* 357 */       if (i >= 23000 && i < 24000) {
/* 358 */         this.trace.info(sQLException, "exception");
/*     */       } else {
/* 360 */         this.trace.error(sQLException, "exception");
/*     */       } 
/*     */     } 
/* 363 */     return sQLException;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SQLException unsupported(String paramString) throws SQLException {
/*     */     try {
/* 375 */       throw DbException.getUnsupportedException(paramString);
/* 376 */     } catch (Exception exception) {
/* 377 */       return logAndConvert(exception);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\message\TraceObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */