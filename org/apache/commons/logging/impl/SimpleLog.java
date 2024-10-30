/*     */ package org.apache.commons.logging.impl;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Serializable;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Properties;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogConfigurationException;
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
/*     */ public class SimpleLog
/*     */   implements Serializable, Log
/*     */ {
/*     */   private static final long serialVersionUID = 136942970684951178L;
/*     */   protected static final String systemPrefix = "org.apache.commons.logging.simplelog.";
/*  82 */   protected static final Properties simpleLogProps = new Properties();
/*     */ 
/*     */ 
/*     */   
/*     */   protected static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
/*     */ 
/*     */ 
/*     */   
/*     */   protected static volatile boolean showLogName = false;
/*     */ 
/*     */ 
/*     */   
/*     */   protected static volatile boolean showShortName = true;
/*     */ 
/*     */   
/*     */   protected static volatile boolean showDateTime = false;
/*     */ 
/*     */   
/* 100 */   protected static volatile String dateTimeFormat = "yyyy/MM/dd HH:mm:ss:SSS zzz";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   protected static DateFormat dateFormatter = null;
/*     */ 
/*     */   
/*     */   public static final int LOG_LEVEL_TRACE = 1;
/*     */ 
/*     */   
/*     */   public static final int LOG_LEVEL_DEBUG = 2;
/*     */ 
/*     */   
/*     */   public static final int LOG_LEVEL_INFO = 3;
/*     */ 
/*     */   
/*     */   public static final int LOG_LEVEL_WARN = 4;
/*     */ 
/*     */   
/*     */   public static final int LOG_LEVEL_ERROR = 5;
/*     */ 
/*     */   
/*     */   public static final int LOG_LEVEL_FATAL = 6;
/*     */   
/*     */   public static final int LOG_LEVEL_ALL = 0;
/*     */   
/*     */   public static final int LOG_LEVEL_OFF = 7;
/*     */ 
/*     */   
/*     */   private static String getStringProperty(String paramString) {
/* 136 */     String str = null;
/*     */     try {
/* 138 */       str = System.getProperty(paramString);
/* 139 */     } catch (SecurityException securityException) {}
/*     */ 
/*     */     
/* 142 */     return (str == null) ? simpleLogProps.getProperty(paramString) : str;
/*     */   }
/*     */   
/*     */   private static String getStringProperty(String paramString1, String paramString2) {
/* 146 */     String str = getStringProperty(paramString1);
/* 147 */     return (str == null) ? paramString2 : str;
/*     */   }
/*     */   
/*     */   private static boolean getBooleanProperty(String paramString, boolean paramBoolean) {
/* 151 */     String str = getStringProperty(paramString);
/* 152 */     return (str == null) ? paramBoolean : "true".equalsIgnoreCase(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 160 */     InputStream inputStream = getResourceAsStream("simplelog.properties");
/* 161 */     if (null != inputStream) {
/*     */       try {
/* 163 */         simpleLogProps.load(inputStream);
/* 164 */         inputStream.close();
/* 165 */       } catch (IOException iOException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 170 */     showLogName = getBooleanProperty("org.apache.commons.logging.simplelog.showlogname", showLogName);
/* 171 */     showShortName = getBooleanProperty("org.apache.commons.logging.simplelog.showShortLogname", showShortName);
/* 172 */     showDateTime = getBooleanProperty("org.apache.commons.logging.simplelog.showdatetime", showDateTime);
/*     */     
/* 174 */     if (showDateTime) {
/* 175 */       dateTimeFormat = getStringProperty("org.apache.commons.logging.simplelog.dateTimeFormat", dateTimeFormat);
/*     */       
/*     */       try {
/* 178 */         dateFormatter = new SimpleDateFormat(dateTimeFormat);
/* 179 */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */         
/* 181 */         dateTimeFormat = "yyyy/MM/dd HH:mm:ss:SSS zzz";
/* 182 */         dateFormatter = new SimpleDateFormat(dateTimeFormat);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 190 */   protected volatile String logName = null;
/*     */   
/*     */   protected volatile int currentLogLevel;
/*     */   
/* 194 */   private volatile String shortLogName = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleLog(String paramString) {
/* 204 */     this.logName = paramString;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 209 */     setLevel(3);
/*     */ 
/*     */     
/* 212 */     String str = getStringProperty("org.apache.commons.logging.simplelog.log." + this.logName);
/* 213 */     int i = String.valueOf(paramString).lastIndexOf(".");
/* 214 */     while (null == str && i > -1) {
/* 215 */       paramString = paramString.substring(0, i);
/* 216 */       str = getStringProperty("org.apache.commons.logging.simplelog.log." + paramString);
/* 217 */       i = String.valueOf(paramString).lastIndexOf(".");
/*     */     } 
/*     */     
/* 220 */     if (null == str) {
/* 221 */       str = getStringProperty("org.apache.commons.logging.simplelog.defaultlog");
/*     */     }
/*     */     
/* 224 */     if ("all".equalsIgnoreCase(str)) {
/* 225 */       setLevel(0);
/* 226 */     } else if ("trace".equalsIgnoreCase(str)) {
/* 227 */       setLevel(1);
/* 228 */     } else if ("debug".equalsIgnoreCase(str)) {
/* 229 */       setLevel(2);
/* 230 */     } else if ("info".equalsIgnoreCase(str)) {
/* 231 */       setLevel(3);
/* 232 */     } else if ("warn".equalsIgnoreCase(str)) {
/* 233 */       setLevel(4);
/* 234 */     } else if ("error".equalsIgnoreCase(str)) {
/* 235 */       setLevel(5);
/* 236 */     } else if ("fatal".equalsIgnoreCase(str)) {
/* 237 */       setLevel(6);
/* 238 */     } else if ("off".equalsIgnoreCase(str)) {
/* 239 */       setLevel(7);
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
/*     */   public void setLevel(int paramInt) {
/* 251 */     this.currentLogLevel = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLevel() {
/* 258 */     return this.currentLogLevel;
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected void log(int paramInt, Object paramObject, Throwable paramThrowable) {
/* 275 */     StringBuffer stringBuffer = new StringBuffer();
/*     */ 
/*     */     
/* 278 */     if (showDateTime) {
/* 279 */       String str; Date date = new Date();
/*     */       
/* 281 */       synchronized (dateFormatter) {
/* 282 */         str = dateFormatter.format(date);
/*     */       } 
/* 284 */       stringBuffer.append(str);
/* 285 */       stringBuffer.append(" ");
/*     */     } 
/*     */ 
/*     */     
/* 289 */     switch (paramInt) { case 1:
/* 290 */         stringBuffer.append("[TRACE] "); break;
/* 291 */       case 2: stringBuffer.append("[DEBUG] "); break;
/* 292 */       case 3: stringBuffer.append("[INFO] "); break;
/* 293 */       case 4: stringBuffer.append("[WARN] "); break;
/* 294 */       case 5: stringBuffer.append("[ERROR] "); break;
/* 295 */       case 6: stringBuffer.append("[FATAL] ");
/*     */         break; }
/*     */ 
/*     */     
/* 299 */     if (showShortName) {
/* 300 */       if (this.shortLogName == null) {
/*     */         
/* 302 */         String str = this.logName.substring(this.logName.lastIndexOf(".") + 1);
/* 303 */         this.shortLogName = str.substring(str.lastIndexOf("/") + 1);
/*     */       } 
/* 305 */       stringBuffer.append(String.valueOf(this.shortLogName)).append(" - ");
/* 306 */     } else if (showLogName) {
/* 307 */       stringBuffer.append(String.valueOf(this.logName)).append(" - ");
/*     */     } 
/*     */ 
/*     */     
/* 311 */     stringBuffer.append(String.valueOf(paramObject));
/*     */ 
/*     */     
/* 314 */     if (paramThrowable != null) {
/* 315 */       stringBuffer.append(" <");
/* 316 */       stringBuffer.append(paramThrowable.toString());
/* 317 */       stringBuffer.append(">");
/*     */       
/* 319 */       StringWriter stringWriter = new StringWriter(1024);
/* 320 */       PrintWriter printWriter = new PrintWriter(stringWriter);
/* 321 */       paramThrowable.printStackTrace(printWriter);
/* 322 */       printWriter.close();
/* 323 */       stringBuffer.append(stringWriter.toString());
/*     */     } 
/*     */ 
/*     */     
/* 327 */     write(stringBuffer);
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
/*     */   protected void write(StringBuffer paramStringBuffer) {
/* 339 */     System.err.println(paramStringBuffer.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isLevelEnabled(int paramInt) {
/* 350 */     return (paramInt >= this.currentLogLevel);
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
/*     */   public final void debug(Object paramObject) {
/* 363 */     if (isLevelEnabled(2)) {
/* 364 */       log(2, paramObject, null);
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
/*     */   public final void debug(Object paramObject, Throwable paramThrowable) {
/* 377 */     if (isLevelEnabled(2)) {
/* 378 */       log(2, paramObject, paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void trace(Object paramObject) {
/* 389 */     if (isLevelEnabled(1)) {
/* 390 */       log(1, paramObject, null);
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
/*     */   public final void trace(Object paramObject, Throwable paramThrowable) {
/* 402 */     if (isLevelEnabled(1)) {
/* 403 */       log(1, paramObject, paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void info(Object paramObject) {
/* 414 */     if (isLevelEnabled(3)) {
/* 415 */       log(3, paramObject, null);
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
/*     */   public final void info(Object paramObject, Throwable paramThrowable) {
/* 427 */     if (isLevelEnabled(3)) {
/* 428 */       log(3, paramObject, paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void warn(Object paramObject) {
/* 439 */     if (isLevelEnabled(4)) {
/* 440 */       log(4, paramObject, null);
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
/*     */   public final void warn(Object paramObject, Throwable paramThrowable) {
/* 452 */     if (isLevelEnabled(4)) {
/* 453 */       log(4, paramObject, paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void error(Object paramObject) {
/* 464 */     if (isLevelEnabled(5)) {
/* 465 */       log(5, paramObject, null);
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
/*     */   public final void error(Object paramObject, Throwable paramThrowable) {
/* 477 */     if (isLevelEnabled(5)) {
/* 478 */       log(5, paramObject, paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fatal(Object paramObject) {
/* 489 */     if (isLevelEnabled(6)) {
/* 490 */       log(6, paramObject, null);
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
/*     */   public final void fatal(Object paramObject, Throwable paramThrowable) {
/* 502 */     if (isLevelEnabled(6)) {
/* 503 */       log(6, paramObject, paramThrowable);
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
/*     */   public final boolean isDebugEnabled() {
/* 515 */     return isLevelEnabled(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isErrorEnabled() {
/* 526 */     return isLevelEnabled(5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isFatalEnabled() {
/* 537 */     return isLevelEnabled(6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isInfoEnabled() {
/* 548 */     return isLevelEnabled(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isTraceEnabled() {
/* 559 */     return isLevelEnabled(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isWarnEnabled() {
/* 570 */     return isLevelEnabled(4);
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
/*     */   private static ClassLoader getContextClassLoader() {
/* 584 */     ClassLoader classLoader = null;
/*     */ 
/*     */     
/*     */     try {
/* 588 */       Method method = Thread.class.getMethod("getContextClassLoader", (Class[])null);
/*     */ 
/*     */       
/*     */       try {
/* 592 */         classLoader = (ClassLoader)method.invoke(Thread.currentThread(), (Object[])null);
/* 593 */       } catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 595 */       } catch (InvocationTargetException invocationTargetException) {
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
/* 612 */         if (!(invocationTargetException.getTargetException() instanceof SecurityException))
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 617 */           throw new LogConfigurationException("Unexpected InvocationTargetException", invocationTargetException.getTargetException());
/*     */         }
/*     */       }
/*     */     
/* 621 */     } catch (NoSuchMethodException noSuchMethodException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 626 */     if (classLoader == null) {
/* 627 */       classLoader = SimpleLog.class.getClassLoader();
/*     */     }
/*     */ 
/*     */     
/* 631 */     return classLoader;
/*     */   }
/*     */   
/*     */   private static InputStream getResourceAsStream(String paramString) {
/* 635 */     return AccessController.<InputStream>doPrivileged(new PrivilegedAction(paramString) { private final String val$name;
/*     */           
/*     */           public Object run() {
/* 638 */             ClassLoader classLoader = SimpleLog.getContextClassLoader();
/*     */             
/* 640 */             if (classLoader != null) {
/* 641 */               return classLoader.getResourceAsStream(this.val$name);
/*     */             }
/* 643 */             return ClassLoader.getSystemResourceAsStream(this.val$name);
/*     */           } }
/*     */       );
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\impl\SimpleLog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */