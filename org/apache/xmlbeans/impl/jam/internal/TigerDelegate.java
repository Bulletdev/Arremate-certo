/*     */ package org.apache.xmlbeans.impl.jam.internal;
/*     */ 
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamLogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class TigerDelegate
/*     */ {
/*     */   private static final String SOME_TIGER_SPECIFIC_JAVADOC_CLASS = "com.sun.javadoc.AnnotationDesc";
/*     */   private static final String SOME_TIGER_SPECIFIC_REFLECT_CLASS = "java.lang.annotation.Annotation";
/*  44 */   protected JamLogger mLogger = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   protected ElementContext mContext = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean m14RuntimeWarningDone = false;
/*     */ 
/*     */   
/*     */   private static boolean m14BuildWarningDone = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ElementContext paramElementContext) {
/*  61 */     this.mContext = paramElementContext;
/*  62 */     init(paramElementContext.getLogger());
/*     */   }
/*     */   public void init(JamLogger paramJamLogger) {
/*  65 */     this.mLogger = paramJamLogger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected JamLogger getLogger() {
/*  72 */     return this.mLogger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void issue14BuildWarning(Throwable paramThrowable, JamLogger paramJamLogger) {
/*  80 */     if (!m14BuildWarningDone) {
/*  81 */       paramJamLogger.warning("This build of JAM was not made with JDK 1.5.Even though you are now running under JDK 1.5, JSR175-style annotations will not be available");
/*     */ 
/*     */       
/*  84 */       if (paramJamLogger.isVerbose(TigerDelegate.class)) paramJamLogger.verbose(paramThrowable); 
/*  85 */       m14BuildWarningDone = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void issue14RuntimeWarning(Throwable paramThrowable, JamLogger paramJamLogger) {
/*  94 */     if (!m14RuntimeWarningDone) {
/*  95 */       paramJamLogger.warning("You are running under a pre-1.5 JDK.  JSR175-style source annotations will not be available");
/*     */       
/*  97 */       if (paramJamLogger.isVerbose(TigerDelegate.class)) paramJamLogger.verbose(paramThrowable); 
/*  98 */       m14RuntimeWarningDone = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static boolean isTigerJavadocAvailable(JamLogger paramJamLogger) {
/*     */     try {
/* 106 */       Class.forName("com.sun.javadoc.AnnotationDesc");
/* 107 */       return true;
/* 108 */     } catch (ClassNotFoundException classNotFoundException) {
/* 109 */       issue14RuntimeWarning(classNotFoundException, paramJamLogger);
/* 110 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static boolean isTigerReflectionAvailable(JamLogger paramJamLogger) {
/*     */     try {
/* 118 */       Class.forName("java.lang.annotation.Annotation");
/* 119 */       return true;
/* 120 */     } catch (ClassNotFoundException classNotFoundException) {
/* 121 */       issue14RuntimeWarning(classNotFoundException, paramJamLogger);
/* 122 */       return false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\TigerDelegate.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */