/*     */ package ch.qos.logback.classic.joran.action;
/*     */ 
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.joran.ReconfigureOnChangeTask;
/*     */ import ch.qos.logback.classic.util.EnvUtil;
/*     */ import ch.qos.logback.core.joran.action.Action;
/*     */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*     */ import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
/*     */ import ch.qos.logback.core.status.OnConsoleStatusListener;
/*     */ import ch.qos.logback.core.util.ContextUtil;
/*     */ import ch.qos.logback.core.util.Duration;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import ch.qos.logback.core.util.StatusListenerConfigHelper;
/*     */ import java.net.URL;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.xml.sax.Attributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConfigurationAction
/*     */   extends Action
/*     */ {
/*     */   static final String INTERNAL_DEBUG_ATTR = "debug";
/*     */   static final String PACKAGING_DATA_ATTR = "packagingData";
/*     */   static final String SCAN_ATTR = "scan";
/*     */   static final String SCAN_PERIOD_ATTR = "scanPeriod";
/*     */   static final String DEBUG_SYSTEM_PROPERTY_KEY = "logback.debug";
/*  43 */   long threshold = 0L;
/*     */   
/*     */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/*  46 */     this.threshold = System.currentTimeMillis();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  51 */     String str = getSystemProperty("logback.debug");
/*  52 */     if (str == null) {
/*  53 */       str = paramInterpretationContext.subst(paramAttributes.getValue("debug"));
/*     */     }
/*     */     
/*  56 */     if (OptionHelper.isEmpty(str) || str.equalsIgnoreCase("false") || str.equalsIgnoreCase("null")) {
/*  57 */       addInfo("debug attribute not set");
/*     */     } else {
/*  59 */       StatusListenerConfigHelper.addOnConsoleListenerInstance(this.context, new OnConsoleStatusListener());
/*     */     } 
/*     */     
/*  62 */     processScanAttrib(paramInterpretationContext, paramAttributes);
/*     */     
/*  64 */     LoggerContext loggerContext = (LoggerContext)this.context;
/*  65 */     boolean bool = OptionHelper.toBoolean(paramInterpretationContext.subst(paramAttributes.getValue("packagingData")), false);
/*  66 */     loggerContext.setPackagingDataEnabled(bool);
/*     */     
/*  68 */     if (EnvUtil.isGroovyAvailable()) {
/*  69 */       ContextUtil contextUtil = new ContextUtil(this.context);
/*  70 */       contextUtil.addGroovyPackages(loggerContext.getFrameworkPackages());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  75 */     paramInterpretationContext.pushObject(getContext());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getSystemProperty(String paramString) {
/*     */     try {
/*  84 */       return System.getProperty(paramString);
/*  85 */     } catch (SecurityException securityException) {
/*  86 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   void processScanAttrib(InterpretationContext paramInterpretationContext, Attributes paramAttributes) {
/*  91 */     String str = paramInterpretationContext.subst(paramAttributes.getValue("scan"));
/*  92 */     if (!OptionHelper.isEmpty(str) && !"false".equalsIgnoreCase(str)) {
/*     */       
/*  94 */       ScheduledExecutorService scheduledExecutorService = this.context.getScheduledExecutorService();
/*  95 */       URL uRL = ConfigurationWatchListUtil.getMainWatchURL(this.context);
/*  96 */       if (uRL == null) {
/*  97 */         addWarn("Due to missing top level configuration file, reconfiguration on change (configuration file scanning) cannot be done.");
/*     */         return;
/*     */       } 
/* 100 */       ReconfigureOnChangeTask reconfigureOnChangeTask = new ReconfigureOnChangeTask();
/* 101 */       reconfigureOnChangeTask.setContext(this.context);
/*     */       
/* 103 */       this.context.putObject("RECONFIGURE_ON_CHANGE_TASK", reconfigureOnChangeTask);
/*     */       
/* 105 */       String str1 = paramInterpretationContext.subst(paramAttributes.getValue("scanPeriod"));
/* 106 */       Duration duration = getDuration(str, str1);
/*     */       
/* 108 */       if (duration == null) {
/*     */         return;
/*     */       }
/*     */       
/* 112 */       addInfo("Will scan for changes in [" + uRL + "] ");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 117 */       addInfo("Setting ReconfigureOnChangeTask scanning period to " + duration);
/*     */       
/* 119 */       ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate((Runnable)reconfigureOnChangeTask, duration.getMilliseconds(), duration.getMilliseconds(), TimeUnit.MILLISECONDS);
/*     */       
/* 121 */       this.context.addScheduledFuture(scheduledFuture);
/*     */     } 
/*     */   }
/*     */   
/*     */   private Duration getDuration(String paramString1, String paramString2) {
/* 126 */     Duration duration = null;
/*     */     
/* 128 */     if (!OptionHelper.isEmpty(paramString2)) {
/*     */       try {
/* 130 */         duration = Duration.valueOf(paramString2);
/*     */       }
/* 132 */       catch (NumberFormatException numberFormatException) {
/* 133 */         addError("Error while converting [" + paramString1 + "] to long", numberFormatException);
/*     */       } 
/*     */     }
/* 136 */     return duration;
/*     */   }
/*     */   
/*     */   public void end(InterpretationContext paramInterpretationContext, String paramString) {
/* 140 */     addInfo("End of configuration.");
/* 141 */     paramInterpretationContext.popObject();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\joran\action\ConfigurationAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */