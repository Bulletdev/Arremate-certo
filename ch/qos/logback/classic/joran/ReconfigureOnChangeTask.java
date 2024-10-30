/*     */ package ch.qos.logback.classic.joran;
/*     */ 
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.core.joran.event.SaxEvent;
/*     */ import ch.qos.logback.core.joran.spi.ConfigurationWatchList;
/*     */ import ch.qos.logback.core.joran.spi.JoranException;
/*     */ import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.status.StatusUtil;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReconfigureOnChangeTask
/*     */   extends ContextAwareBase
/*     */   implements Runnable
/*     */ {
/*     */   public static final String DETECTED_CHANGE_IN_CONFIGURATION_FILES = "Detected change in configuration files.";
/*     */   static final String RE_REGISTERING_PREVIOUS_SAFE_CONFIGURATION = "Re-registering previous fallback configuration once more as a fallback configuration point";
/*     */   static final String FALLING_BACK_TO_SAFE_CONFIGURATION = "Given previous errors, falling back to previously registered safe configuration.";
/*  26 */   long birthdate = System.currentTimeMillis();
/*     */   
/*     */   List<ReconfigureOnChangeTaskListener> listeners;
/*     */   
/*     */   void addListener(ReconfigureOnChangeTaskListener paramReconfigureOnChangeTaskListener) {
/*  31 */     if (this.listeners == null)
/*  32 */       this.listeners = new ArrayList<ReconfigureOnChangeTaskListener>(); 
/*  33 */     this.listeners.add(paramReconfigureOnChangeTaskListener);
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  38 */     fireEnteredRunMethod();
/*     */     
/*  40 */     ConfigurationWatchList configurationWatchList = ConfigurationWatchListUtil.getConfigurationWatchList(this.context);
/*  41 */     if (configurationWatchList == null) {
/*  42 */       addWarn("Empty ConfigurationWatchList in context");
/*     */       
/*     */       return;
/*     */     } 
/*  46 */     List list = configurationWatchList.getCopyOfFileWatchList();
/*  47 */     if (list == null || list.isEmpty()) {
/*  48 */       addInfo("Empty watch file list. Disabling ");
/*     */       
/*     */       return;
/*     */     } 
/*  52 */     if (!configurationWatchList.changeDetected()) {
/*     */       return;
/*     */     }
/*     */     
/*  56 */     fireChangeDetected();
/*  57 */     URL uRL = configurationWatchList.getMainURL();
/*     */     
/*  59 */     addInfo("Detected change in configuration files.");
/*  60 */     addInfo("Will reset and reconfigure context named [" + this.context.getName() + "]");
/*     */     
/*  62 */     LoggerContext loggerContext = (LoggerContext)this.context;
/*  63 */     if (uRL.toString().endsWith("xml")) {
/*  64 */       performXMLConfiguration(loggerContext, uRL);
/*     */     }
/*  66 */     fireDoneReconfiguring();
/*     */   }
/*     */   
/*     */   private void fireEnteredRunMethod() {
/*  70 */     if (this.listeners == null) {
/*     */       return;
/*     */     }
/*  73 */     for (ReconfigureOnChangeTaskListener reconfigureOnChangeTaskListener : this.listeners)
/*  74 */       reconfigureOnChangeTaskListener.enteredRunMethod(); 
/*     */   }
/*     */   
/*     */   private void fireChangeDetected() {
/*  78 */     if (this.listeners == null) {
/*     */       return;
/*     */     }
/*  81 */     for (ReconfigureOnChangeTaskListener reconfigureOnChangeTaskListener : this.listeners) {
/*  82 */       reconfigureOnChangeTaskListener.changeDetected();
/*     */     }
/*     */   }
/*     */   
/*     */   private void fireDoneReconfiguring() {
/*  87 */     if (this.listeners == null) {
/*     */       return;
/*     */     }
/*  90 */     for (ReconfigureOnChangeTaskListener reconfigureOnChangeTaskListener : this.listeners)
/*  91 */       reconfigureOnChangeTaskListener.doneReconfiguring(); 
/*     */   }
/*     */   
/*     */   private void performXMLConfiguration(LoggerContext paramLoggerContext, URL paramURL) {
/*  95 */     JoranConfigurator joranConfigurator = new JoranConfigurator();
/*  96 */     joranConfigurator.setContext(this.context);
/*  97 */     StatusUtil statusUtil = new StatusUtil(this.context);
/*  98 */     List<SaxEvent> list = joranConfigurator.recallSafeConfiguration();
/*     */     
/* 100 */     URL uRL = ConfigurationWatchListUtil.getMainWatchURL(this.context);
/* 101 */     paramLoggerContext.reset();
/* 102 */     long l = System.currentTimeMillis();
/*     */     try {
/* 104 */       joranConfigurator.doConfigure(paramURL);
/* 105 */       if (statusUtil.hasXMLParsingErrors(l)) {
/* 106 */         fallbackConfiguration(paramLoggerContext, list, uRL);
/*     */       }
/* 108 */     } catch (JoranException joranException) {
/* 109 */       fallbackConfiguration(paramLoggerContext, list, uRL);
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<SaxEvent> removeIncludeEvents(List<SaxEvent> paramList) {
/* 114 */     ArrayList<SaxEvent> arrayList = new ArrayList();
/* 115 */     if (paramList == null) {
/* 116 */       return arrayList;
/*     */     }
/* 118 */     for (SaxEvent saxEvent : paramList) {
/* 119 */       if (!"include".equalsIgnoreCase(saxEvent.getLocalName())) {
/* 120 */         arrayList.add(saxEvent);
/*     */       }
/*     */     } 
/* 123 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fallbackConfiguration(LoggerContext paramLoggerContext, List<SaxEvent> paramList, URL paramURL) {
/* 130 */     List<SaxEvent> list = removeIncludeEvents(paramList);
/* 131 */     JoranConfigurator joranConfigurator = new JoranConfigurator();
/* 132 */     joranConfigurator.setContext(this.context);
/* 133 */     ConfigurationWatchList configurationWatchList1 = ConfigurationWatchListUtil.getConfigurationWatchList(this.context);
/* 134 */     ConfigurationWatchList configurationWatchList2 = configurationWatchList1.buildClone();
/*     */     
/* 136 */     if (list == null || list.isEmpty()) {
/* 137 */       addWarn("No previous configuration to fall back on.");
/*     */     } else {
/* 139 */       addWarn("Given previous errors, falling back to previously registered safe configuration.");
/*     */       try {
/* 141 */         paramLoggerContext.reset();
/* 142 */         ConfigurationWatchListUtil.registerConfigurationWatchList(this.context, configurationWatchList2);
/* 143 */         joranConfigurator.doConfigure(list);
/* 144 */         addInfo("Re-registering previous fallback configuration once more as a fallback configuration point");
/* 145 */         joranConfigurator.registerSafeConfiguration(paramList);
/*     */         
/* 147 */         addInfo("after registerSafeConfiguration: " + paramList);
/* 148 */       } catch (JoranException joranException) {
/* 149 */         addError("Unexpected exception thrown by a configuration considered safe.", (Throwable)joranException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     return "ReconfigureOnChangeTask(born:" + this.birthdate + ")";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\joran\ReconfigureOnChangeTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */