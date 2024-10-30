/*     */ package org.h2.message;
/*     */ 
/*     */ import java.text.MessageFormat;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.expression.ParameterInterface;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.Value;
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
/*     */ public class Trace
/*     */ {
/*     */   public static final int COMMAND = 0;
/*     */   public static final int CONSTRAINT = 1;
/*     */   public static final int DATABASE = 2;
/*     */   public static final int FUNCTION = 3;
/*     */   public static final int FILE_LOCK = 4;
/*     */   public static final int INDEX = 5;
/*     */   public static final int JDBC = 6;
/*     */   public static final int LOCK = 7;
/*     */   public static final int SCHEMA = 8;
/*     */   public static final int SEQUENCE = 9;
/*     */   public static final int SETTING = 10;
/*     */   public static final int TABLE = 11;
/*     */   public static final int TRIGGER = 12;
/*     */   public static final int USER = 13;
/*     */   public static final int PAGE_STORE = 14;
/*     */   public static final int JDBCX = 15;
/* 105 */   public static final String[] MODULE_NAMES = new String[] { "command", "constraint", "database", "function", "fileLock", "index", "jdbc", "lock", "schema", "sequence", "setting", "table", "trigger", "user", "pageStore", "JDBCX" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final TraceWriter traceWriter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String module;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String lineSeparator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 127 */   private int traceLevel = -1;
/*     */   
/*     */   Trace(TraceWriter paramTraceWriter, int paramInt) {
/* 130 */     this(paramTraceWriter, MODULE_NAMES[paramInt]);
/*     */   }
/*     */   
/*     */   Trace(TraceWriter paramTraceWriter, String paramString) {
/* 134 */     this.traceWriter = paramTraceWriter;
/* 135 */     this.module = paramString;
/* 136 */     this.lineSeparator = SysProperties.LINE_SEPARATOR;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevel(int paramInt) {
/* 146 */     this.traceLevel = paramInt;
/*     */   }
/*     */   
/*     */   private boolean isEnabled(int paramInt) {
/* 150 */     if (this.traceLevel == -1) {
/* 151 */       return this.traceWriter.isEnabled(paramInt);
/*     */     }
/* 153 */     return (paramInt <= this.traceLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInfoEnabled() {
/* 162 */     return isEnabled(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDebugEnabled() {
/* 171 */     return isEnabled(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void error(Throwable paramThrowable, String paramString) {
/* 181 */     if (isEnabled(1)) {
/* 182 */       this.traceWriter.write(1, this.module, paramString, paramThrowable);
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
/*     */   public void error(Throwable paramThrowable, String paramString, Object... paramVarArgs) {
/* 194 */     if (isEnabled(1)) {
/* 195 */       paramString = MessageFormat.format(paramString, paramVarArgs);
/* 196 */       this.traceWriter.write(1, this.module, paramString, paramThrowable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void info(String paramString) {
/* 206 */     if (isEnabled(2)) {
/* 207 */       this.traceWriter.write(2, this.module, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void info(String paramString, Object... paramVarArgs) {
/* 218 */     if (isEnabled(2)) {
/* 219 */       paramString = MessageFormat.format(paramString, paramVarArgs);
/* 220 */       this.traceWriter.write(2, this.module, paramString, (Throwable)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void info(Throwable paramThrowable, String paramString) {
/* 231 */     if (isEnabled(2)) {
/* 232 */       this.traceWriter.write(2, this.module, paramString, paramThrowable);
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
/*     */   public static String formatParams(ArrayList<? extends ParameterInterface> paramArrayList) {
/* 244 */     if (paramArrayList.size() == 0) {
/* 245 */       return "";
/*     */     }
/* 247 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 248 */     byte b = 0;
/* 249 */     boolean bool = false;
/* 250 */     for (ParameterInterface parameterInterface : paramArrayList) {
/* 251 */       if (parameterInterface.isValueSet()) {
/* 252 */         if (!bool) {
/* 253 */           statementBuilder.append(" {");
/* 254 */           bool = true;
/*     */         } 
/* 256 */         statementBuilder.appendExceptFirst(", ");
/* 257 */         Value value = parameterInterface.getParamValue();
/* 258 */         statementBuilder.append(++b).append(": ").append(value.getTraceSQL());
/*     */       } 
/*     */     } 
/* 261 */     if (bool) {
/* 262 */       statementBuilder.append('}');
/*     */     }
/* 264 */     return statementBuilder.toString();
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
/*     */   public void infoSQL(String paramString1, String paramString2, int paramInt, long paramLong) {
/* 276 */     if (!isEnabled(2)) {
/*     */       return;
/*     */     }
/* 279 */     StringBuilder stringBuilder = new StringBuilder(paramString1.length() + paramString2.length() + 20);
/* 280 */     stringBuilder.append(this.lineSeparator).append("/*SQL");
/* 281 */     boolean bool = false;
/* 282 */     if (paramString2.length() > 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 289 */       bool = true;
/* 290 */       stringBuilder.append(" l:").append(paramString1.length());
/*     */     } 
/* 292 */     if (paramInt > 0) {
/* 293 */       bool = true;
/* 294 */       stringBuilder.append(" #:").append(paramInt);
/*     */     } 
/* 296 */     if (paramLong > 0L) {
/* 297 */       bool = true;
/* 298 */       stringBuilder.append(" t:").append(paramLong);
/*     */     } 
/* 300 */     if (!bool) {
/* 301 */       stringBuilder.append(' ');
/*     */     }
/* 303 */     stringBuilder.append("*/").append(StringUtils.javaEncode(paramString1)).append(StringUtils.javaEncode(paramString2)).append(';');
/*     */ 
/*     */ 
/*     */     
/* 307 */     paramString1 = stringBuilder.toString();
/* 308 */     this.traceWriter.write(2, this.module, paramString1, (Throwable)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(String paramString, Object... paramVarArgs) {
/* 318 */     if (isEnabled(3)) {
/* 319 */       paramString = MessageFormat.format(paramString, paramVarArgs);
/* 320 */       this.traceWriter.write(3, this.module, paramString, (Throwable)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(String paramString) {
/* 330 */     if (isEnabled(3)) {
/* 331 */       this.traceWriter.write(3, this.module, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(Throwable paramThrowable, String paramString) {
/* 341 */     if (isEnabled(3)) {
/* 342 */       this.traceWriter.write(3, this.module, paramString, paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void infoCode(String paramString) {
/* 353 */     if (isEnabled(2)) {
/* 354 */       this.traceWriter.write(2, this.module, this.lineSeparator + "/**/" + paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void debugCode(String paramString) {
/* 365 */     if (isEnabled(3))
/* 366 */       this.traceWriter.write(3, this.module, this.lineSeparator + "/**/" + paramString, (Throwable)null); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\message\Trace.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */