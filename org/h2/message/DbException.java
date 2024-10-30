/*     */ package org.h2.message;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import org.h2.api.ErrorCode;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.jdbc.JdbcSQLException;
/*     */ import org.h2.util.SortedProperties;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Utils;
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
/*     */ public class DbException
/*     */   extends RuntimeException
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  35 */   private static final Properties MESSAGES = new Properties();
/*     */   
/*     */   private Object source;
/*     */   
/*     */   static {
/*     */     try {
/*  41 */       byte[] arrayOfByte = Utils.getResource("/org/h2/res/_messages_en.prop");
/*     */       
/*  43 */       if (arrayOfByte != null) {
/*  44 */         MESSAGES.load(new ByteArrayInputStream(arrayOfByte));
/*     */       }
/*  46 */       String str = Locale.getDefault().getLanguage();
/*  47 */       if (!"en".equals(str)) {
/*  48 */         byte[] arrayOfByte1 = Utils.getResource("/org/h2/res/_messages_" + str + ".prop");
/*     */ 
/*     */ 
/*     */         
/*  52 */         if (arrayOfByte1 != null) {
/*  53 */           SortedProperties sortedProperties = SortedProperties.fromLines(new String(arrayOfByte1, Constants.UTF8));
/*     */           
/*  55 */           for (Map.Entry<Object, Object> entry : sortedProperties.entrySet()) {
/*  56 */             String str1 = (String)entry.getKey();
/*  57 */             String str2 = (String)entry.getValue();
/*  58 */             if (str2 != null && !str2.startsWith("#")) {
/*  59 */               String str3 = MESSAGES.getProperty(str1);
/*  60 */               String str4 = str2 + "\n" + str3;
/*  61 */               MESSAGES.put(str1, str4);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*  66 */     } catch (OutOfMemoryError outOfMemoryError) {
/*  67 */       traceThrowable(outOfMemoryError);
/*  68 */     } catch (IOException iOException) {
/*  69 */       traceThrowable(iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private DbException(SQLException paramSQLException) {
/*  74 */     super(paramSQLException.getMessage(), paramSQLException);
/*     */   }
/*     */   
/*     */   private static String translate(String paramString, String... paramVarArgs) {
/*  78 */     String str = null;
/*  79 */     if (MESSAGES != null)
/*     */     {
/*  81 */       str = MESSAGES.getProperty(paramString);
/*     */     }
/*  83 */     if (str == null) {
/*  84 */       str = "(Message " + paramString + " not found)";
/*     */     }
/*  86 */     if (paramVarArgs != null) {
/*  87 */       for (byte b = 0; b < paramVarArgs.length; b++) {
/*  88 */         String str1 = paramVarArgs[b];
/*  89 */         if (str1 != null && str1.length() > 0) {
/*  90 */           paramVarArgs[b] = StringUtils.quoteIdentifier(str1);
/*     */         }
/*     */       } 
/*  93 */       str = MessageFormat.format(str, (Object[])paramVarArgs);
/*     */     } 
/*  95 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SQLException getSQLException() {
/* 104 */     return (SQLException)getCause();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getErrorCode() {
/* 113 */     return getSQLException().getErrorCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DbException addSQL(String paramString) {
/* 124 */     SQLException sQLException = getSQLException();
/* 125 */     if (sQLException instanceof JdbcSQLException) {
/* 126 */       JdbcSQLException jdbcSQLException1 = (JdbcSQLException)sQLException;
/* 127 */       if (jdbcSQLException1.getSQL() == null) {
/* 128 */         jdbcSQLException1.setSQL(paramString);
/*     */       }
/* 130 */       return this;
/*     */     } 
/* 132 */     JdbcSQLException jdbcSQLException = new JdbcSQLException(sQLException.getMessage(), paramString, sQLException.getSQLState(), sQLException.getErrorCode(), sQLException, null);
/*     */     
/* 134 */     return new DbException((SQLException)jdbcSQLException);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DbException get(int paramInt) {
/* 144 */     return get(paramInt, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DbException get(int paramInt, String paramString) {
/* 155 */     return get(paramInt, new String[] { paramString });
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
/*     */   public static DbException get(int paramInt, Throwable paramThrowable, String... paramVarArgs) {
/* 168 */     return new DbException((SQLException)getJdbcSQLException(paramInt, paramThrowable, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DbException get(int paramInt, String... paramVarArgs) {
/* 179 */     return new DbException((SQLException)getJdbcSQLException(paramInt, null, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DbException getSyntaxError(String paramString, int paramInt) {
/* 190 */     paramString = StringUtils.addAsterisk(paramString, paramInt);
/* 191 */     return get(42000, paramString);
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
/*     */   public static DbException getSyntaxError(String paramString1, int paramInt, String paramString2) {
/* 204 */     paramString1 = StringUtils.addAsterisk(paramString1, paramInt);
/* 205 */     return new DbException((SQLException)getJdbcSQLException(42001, null, new String[] { paramString1, paramString2 }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DbException getUnsupportedException(String paramString) {
/* 216 */     return get(50100, paramString);
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
/*     */   public static DbException getInvalidValueException(String paramString, Object paramObject) {
/* 228 */     return get(90008, new String[] { (paramObject == null) ? "null" : paramObject.toString(), paramString });
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
/*     */   public static RuntimeException throwInternalError(String paramString) {
/* 242 */     RuntimeException runtimeException = new RuntimeException(paramString);
/* 243 */     traceThrowable(runtimeException);
/* 244 */     throw runtimeException;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RuntimeException throwInternalError() {
/* 255 */     return throwInternalError("Unexpected code path");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SQLException toSQLException(Exception paramException) {
/* 265 */     if (paramException instanceof SQLException) {
/* 266 */       return (SQLException)paramException;
/*     */     }
/* 268 */     return convert(paramException).getSQLException();
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
/*     */   public static DbException convert(Throwable paramThrowable) {
/* 280 */     if (paramThrowable instanceof DbException)
/* 281 */       return (DbException)paramThrowable; 
/* 282 */     if (paramThrowable instanceof SQLException)
/* 283 */       return new DbException((SQLException)paramThrowable); 
/* 284 */     if (paramThrowable instanceof InvocationTargetException)
/* 285 */       return convertInvocation((InvocationTargetException)paramThrowable, null); 
/* 286 */     if (paramThrowable instanceof IOException)
/* 287 */       return get(90028, paramThrowable, new String[] { paramThrowable.toString() }); 
/* 288 */     if (paramThrowable instanceof OutOfMemoryError)
/* 289 */       return get(90108, paramThrowable, new String[0]); 
/* 290 */     if (paramThrowable instanceof StackOverflowError || paramThrowable instanceof LinkageError)
/* 291 */       return get(50000, paramThrowable, new String[] { paramThrowable.toString() }); 
/* 292 */     if (paramThrowable instanceof Error) {
/* 293 */       throw (Error)paramThrowable;
/*     */     }
/* 295 */     return get(50000, paramThrowable, new String[] { paramThrowable.toString() });
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
/*     */   public static DbException convertInvocation(InvocationTargetException paramInvocationTargetException, String paramString) {
/* 307 */     Throwable throwable = paramInvocationTargetException.getTargetException();
/* 308 */     if (throwable instanceof SQLException || throwable instanceof DbException) {
/* 309 */       return convert(throwable);
/*     */     }
/* 311 */     paramString = (paramString == null) ? throwable.getMessage() : (paramString + ": " + throwable.getMessage());
/* 312 */     return get(90105, throwable, new String[] { paramString });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DbException convertIOException(IOException paramIOException, String paramString) {
/* 323 */     if (paramString == null) {
/* 324 */       Throwable throwable = paramIOException.getCause();
/* 325 */       if (throwable instanceof DbException) {
/* 326 */         return (DbException)throwable;
/*     */       }
/* 328 */       return get(90028, paramIOException, new String[] { paramIOException.toString() });
/*     */     } 
/* 330 */     return get(90031, paramIOException, new String[] { paramIOException.toString(), paramString });
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
/*     */   private static JdbcSQLException getJdbcSQLException(int paramInt, Throwable paramThrowable, String... paramVarArgs) {
/* 343 */     String str1 = ErrorCode.getState(paramInt);
/* 344 */     String str2 = translate(str1, paramVarArgs);
/* 345 */     return new JdbcSQLException(str2, null, str1, paramInt, paramThrowable, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOException convertToIOException(Throwable paramThrowable) {
/* 355 */     if (paramThrowable instanceof IOException) {
/* 356 */       return (IOException)paramThrowable;
/*     */     }
/* 358 */     if (paramThrowable instanceof JdbcSQLException) {
/* 359 */       JdbcSQLException jdbcSQLException = (JdbcSQLException)paramThrowable;
/* 360 */       if (jdbcSQLException.getOriginalCause() != null) {
/* 361 */         paramThrowable = jdbcSQLException.getOriginalCause();
/*     */       }
/*     */     } 
/* 364 */     return new IOException(paramThrowable.toString(), paramThrowable);
/*     */   }
/*     */   
/*     */   public Object getSource() {
/* 368 */     return this.source;
/*     */   }
/*     */   
/*     */   public void setSource(Object paramObject) {
/* 372 */     this.source = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void traceThrowable(Throwable paramThrowable) {
/* 381 */     PrintWriter printWriter = DriverManager.getLogWriter();
/* 382 */     if (printWriter != null)
/* 383 */       paramThrowable.printStackTrace(printWriter); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\message\DbException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */