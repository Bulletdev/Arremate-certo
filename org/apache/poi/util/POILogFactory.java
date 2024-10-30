/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ public final class POILogFactory
/*     */ {
/*  38 */   private static Map<String, POILogger> _loggers = new HashMap<String, POILogger>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   private static final POILogger _nullLogger = new NullLogger();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   static String _loggerClassName = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static POILogger getLogger(Class<?> paramClass) {
/*  64 */     return getLogger(paramClass.getName());
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
/*     */   public static POILogger getLogger(String paramString) {
/*  80 */     if (_loggerClassName == null) {
/*     */       try {
/*  82 */         _loggerClassName = System.getProperty("org.apache.poi.util.POILogger");
/*  83 */       } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  89 */       if (_loggerClassName == null) {
/*  90 */         _loggerClassName = _nullLogger.getClass().getName();
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  96 */     if (_loggerClassName.equals(_nullLogger.getClass().getName())) {
/*  97 */       return _nullLogger;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     POILogger pOILogger = _loggers.get(paramString);
/* 104 */     if (pOILogger == null) {
/*     */       
/*     */       try {
/* 107 */         Class<?> clazz = Class.forName(_loggerClassName);
/*     */         
/* 109 */         pOILogger = (POILogger)clazz.newInstance();
/* 110 */         pOILogger.initialize(paramString);
/* 111 */       } catch (Exception exception) {
/*     */         
/* 113 */         pOILogger = _nullLogger;
/* 114 */         _loggerClassName = _nullLogger.getClass().getName();
/*     */       } 
/*     */ 
/*     */       
/* 118 */       _loggers.put(paramString, pOILogger);
/*     */     } 
/* 120 */     return pOILogger;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\POILogFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */