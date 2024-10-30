/*     */ package org.apache.commons.logging;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.Hashtable;
/*     */ import org.apache.commons.logging.impl.NoOpLog;
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
/*     */ public class LogSource
/*     */ {
/*  59 */   protected static Hashtable logs = new Hashtable();
/*     */ 
/*     */   
/*     */   protected static boolean log4jIsAvailable = false;
/*     */ 
/*     */   
/*     */   protected static boolean jdk14IsAvailable = false;
/*     */ 
/*     */   
/*  68 */   protected static Constructor logImplctor = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/*  76 */       log4jIsAvailable = (null != Class.forName("org.apache.log4j.Logger"));
/*  77 */     } catch (Throwable throwable) {
/*  78 */       log4jIsAvailable = false;
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/*  83 */       jdk14IsAvailable = (null != Class.forName("java.util.logging.Logger") && null != Class.forName("org.apache.commons.logging.impl.Jdk14Logger"));
/*     */     }
/*  85 */     catch (Throwable throwable) {
/*  86 */       jdk14IsAvailable = false;
/*     */     } 
/*     */ 
/*     */     
/*  90 */     String str = null;
/*     */     try {
/*  92 */       str = System.getProperty("org.apache.commons.logging.log");
/*  93 */       if (str == null) {
/*  94 */         str = System.getProperty("org.apache.commons.logging.Log");
/*     */       }
/*  96 */     } catch (Throwable throwable) {}
/*     */     
/*  98 */     if (str != null) {
/*     */       try {
/* 100 */         setLogImplementation(str);
/* 101 */       } catch (Throwable throwable) {
/*     */         try {
/* 103 */           setLogImplementation("org.apache.commons.logging.impl.NoOpLog");
/* 104 */         } catch (Throwable throwable1) {}
/*     */       } 
/*     */     } else {
/*     */ 
/*     */       
/*     */       try {
/* 110 */         if (log4jIsAvailable) {
/* 111 */           setLogImplementation("org.apache.commons.logging.impl.Log4JLogger");
/* 112 */         } else if (jdk14IsAvailable) {
/* 113 */           setLogImplementation("org.apache.commons.logging.impl.Jdk14Logger");
/*     */         } else {
/* 115 */           setLogImplementation("org.apache.commons.logging.impl.NoOpLog");
/*     */         } 
/* 117 */       } catch (Throwable throwable) {
/*     */         try {
/* 119 */           setLogImplementation("org.apache.commons.logging.impl.NoOpLog");
/* 120 */         } catch (Throwable throwable1) {}
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
/*     */   public static void setLogImplementation(String paramString) throws LinkageError, NoSuchMethodException, SecurityException, ClassNotFoundException {
/*     */     try {
/* 145 */       Class clazz = Class.forName(paramString);
/* 146 */       Class[] arrayOfClass = new Class[1];
/* 147 */       arrayOfClass[0] = "".getClass();
/* 148 */       logImplctor = clazz.getConstructor(arrayOfClass);
/* 149 */     } catch (Throwable throwable) {
/* 150 */       logImplctor = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setLogImplementation(Class paramClass) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException {
/* 161 */     Class[] arrayOfClass = new Class[1];
/* 162 */     arrayOfClass[0] = "".getClass();
/* 163 */     logImplctor = paramClass.getConstructor(arrayOfClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Log getInstance(String paramString) {
/* 168 */     Log log = (Log)logs.get(paramString);
/* 169 */     if (null == log) {
/* 170 */       log = makeNewLogInstance(paramString);
/* 171 */       logs.put(paramString, log);
/*     */     } 
/* 173 */     return log;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Log getInstance(Class paramClass) {
/* 178 */     return getInstance(paramClass.getName());
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Log makeNewLogInstance(String paramString) {
/*     */     NoOpLog noOpLog;
/*     */     try {
/* 201 */       Object[] arrayOfObject = { paramString };
/* 202 */       noOpLog = (NoOpLog)logImplctor.newInstance(arrayOfObject);
/* 203 */     } catch (Throwable throwable) {
/* 204 */       noOpLog = null;
/*     */     } 
/* 206 */     if (null == noOpLog) {
/* 207 */       noOpLog = new NoOpLog(paramString);
/*     */     }
/* 209 */     return (Log)noOpLog;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String[] getLogNames() {
/* 217 */     return (String[])logs.keySet().toArray((Object[])new String[logs.size()]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\LogSource.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */