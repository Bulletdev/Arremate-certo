/*     */ package ch.qos.logback.classic.jul;
/*     */ 
/*     */ import ch.qos.logback.classic.Level;
/*     */ import ch.qos.logback.classic.Logger;
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.spi.LoggerContextListener;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.spi.LifeCycle;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.LogManager;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LevelChangePropagator
/*     */   extends ContextAwareBase
/*     */   implements LoggerContextListener, LifeCycle
/*     */ {
/*  34 */   private Set<Logger> julLoggerSet = new HashSet<Logger>();
/*     */   boolean isStarted = false;
/*     */   boolean resetJUL = false;
/*     */   
/*     */   public void setResetJUL(boolean paramBoolean) {
/*  39 */     this.resetJUL = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isResetResistant() {
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onStart(LoggerContext paramLoggerContext) {}
/*     */ 
/*     */   
/*     */   public void onReset(LoggerContext paramLoggerContext) {}
/*     */ 
/*     */   
/*     */   public void onStop(LoggerContext paramLoggerContext) {}
/*     */   
/*     */   public void onLevelChange(Logger paramLogger, Level paramLevel) {
/*  56 */     propagate(paramLogger, paramLevel);
/*     */   }
/*     */   
/*     */   private void propagate(Logger paramLogger, Level paramLevel) {
/*  60 */     addInfo("Propagating " + paramLevel + " level on " + paramLogger + " onto the JUL framework");
/*  61 */     Logger logger = JULHelper.asJULLogger(paramLogger);
/*     */ 
/*     */     
/*  64 */     this.julLoggerSet.add(logger);
/*  65 */     Level level = JULHelper.asJULLevel(paramLevel);
/*  66 */     logger.setLevel(level);
/*     */   }
/*     */   
/*     */   public void resetJULLevels() {
/*  70 */     LogManager logManager = LogManager.getLogManager();
/*     */     
/*  72 */     Enumeration<String> enumeration = logManager.getLoggerNames();
/*  73 */     while (enumeration.hasMoreElements()) {
/*  74 */       String str = enumeration.nextElement();
/*  75 */       Logger logger = logManager.getLogger(str);
/*  76 */       if (JULHelper.isRegularNonRootLogger(logger) && logger.getLevel() != null) {
/*  77 */         addInfo("Setting level of jul logger [" + str + "] to null");
/*  78 */         logger.setLevel(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void propagateExistingLoggerLevels() {
/*  84 */     LoggerContext loggerContext = (LoggerContext)this.context;
/*  85 */     List list = loggerContext.getLoggerList();
/*  86 */     for (Logger logger : list) {
/*  87 */       if (logger.getLevel() != null) {
/*  88 */         propagate(logger, logger.getLevel());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void start() {
/*  94 */     if (this.resetJUL) {
/*  95 */       resetJULLevels();
/*     */     }
/*  97 */     propagateExistingLoggerLevels();
/*     */     
/*  99 */     this.isStarted = true;
/*     */   }
/*     */   
/*     */   public void stop() {
/* 103 */     this.isStarted = false;
/*     */   }
/*     */   
/*     */   public boolean isStarted() {
/* 107 */     return this.isStarted;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\jul\LevelChangePropagator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */