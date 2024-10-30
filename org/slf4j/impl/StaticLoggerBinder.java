/*     */ package org.slf4j.impl;
/*     */ 
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.util.ContextInitializer;
/*     */ import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.spi.JoranException;
/*     */ import ch.qos.logback.core.status.StatusUtil;
/*     */ import ch.qos.logback.core.util.StatusPrinter;
/*     */ import org.slf4j.ILoggerFactory;
/*     */ import org.slf4j.helpers.Util;
/*     */ import org.slf4j.spi.LoggerFactoryBinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StaticLoggerBinder
/*     */   implements LoggerFactoryBinder
/*     */ {
/*  43 */   public static String REQUESTED_API_VERSION = "1.7.16";
/*     */ 
/*     */ 
/*     */   
/*     */   static final String NULL_CS_URL = "http://logback.qos.ch/codes.html#null_CS";
/*     */ 
/*     */   
/*  50 */   private static StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
/*     */   
/*  52 */   private static Object KEY = new Object();
/*     */   
/*     */   static {
/*  55 */     SINGLETON.init();
/*     */   }
/*     */   
/*     */   private boolean initialized = false;
/*  59 */   private LoggerContext defaultLoggerContext = new LoggerContext();
/*  60 */   private final ContextSelectorStaticBinder contextSelectorBinder = ContextSelectorStaticBinder.getSingleton();
/*     */   
/*     */   private StaticLoggerBinder() {
/*  63 */     this.defaultLoggerContext.setName("default");
/*     */   }
/*     */   
/*     */   public static StaticLoggerBinder getSingleton() {
/*  67 */     return SINGLETON;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void reset() {
/*  74 */     SINGLETON = new StaticLoggerBinder();
/*  75 */     SINGLETON.init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void init() {
/*     */     try {
/*     */       try {
/*  84 */         (new ContextInitializer(this.defaultLoggerContext)).autoConfig();
/*  85 */       } catch (JoranException joranException) {
/*  86 */         Util.report("Failed to auto configure default logger context", (Throwable)joranException);
/*     */       } 
/*     */       
/*  89 */       if (!StatusUtil.contextHasStatusListener((Context)this.defaultLoggerContext)) {
/*  90 */         StatusPrinter.printInCaseOfErrorsOrWarnings((Context)this.defaultLoggerContext);
/*     */       }
/*  92 */       this.contextSelectorBinder.init(this.defaultLoggerContext, KEY);
/*  93 */       this.initialized = true;
/*  94 */     } catch (Exception exception) {
/*  95 */       Util.report("Failed to instantiate [" + LoggerContext.class.getName() + "]", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ILoggerFactory getLoggerFactory() {
/* 100 */     if (!this.initialized) {
/* 101 */       return (ILoggerFactory)this.defaultLoggerContext;
/*     */     }
/*     */     
/* 104 */     if (this.contextSelectorBinder.getContextSelector() == null) {
/* 105 */       throw new IllegalStateException("contextSelector cannot be null. See also http://logback.qos.ch/codes.html#null_CS");
/*     */     }
/* 107 */     return (ILoggerFactory)this.contextSelectorBinder.getContextSelector().getLoggerContext();
/*     */   }
/*     */   
/*     */   public String getLoggerFactoryClassStr() {
/* 111 */     return this.contextSelectorBinder.getClass().getName();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\impl\StaticLoggerBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */