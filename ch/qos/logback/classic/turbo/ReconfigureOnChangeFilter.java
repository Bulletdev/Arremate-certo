/*     */ package ch.qos.logback.classic.turbo;
/*     */ 
/*     */ import ch.qos.logback.classic.Level;
/*     */ import ch.qos.logback.classic.Logger;
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.joran.JoranConfigurator;
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.event.SaxEvent;
/*     */ import ch.qos.logback.core.joran.spi.ConfigurationWatchList;
/*     */ import ch.qos.logback.core.joran.spi.JoranException;
/*     */ import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
/*     */ import ch.qos.logback.core.spi.FilterReply;
/*     */ import ch.qos.logback.core.status.StatusUtil;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import org.slf4j.Marker;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReconfigureOnChangeFilter
/*     */   extends TurboFilter
/*     */ {
/*     */   public static final long DEFAULT_REFRESH_PERIOD = 60000L;
/*  49 */   long refreshPeriod = 60000L;
/*     */   
/*     */   URL mainConfigurationURL;
/*     */   
/*     */   protected volatile long nextCheck;
/*     */   ConfigurationWatchList configurationWatchList;
/*     */   
/*     */   public void start() {
/*  57 */     this.configurationWatchList = ConfigurationWatchListUtil.getConfigurationWatchList(this.context);
/*  58 */     if (this.configurationWatchList != null) {
/*  59 */       this.mainConfigurationURL = this.configurationWatchList.getMainURL();
/*  60 */       if (this.mainConfigurationURL == null) {
/*  61 */         addWarn("Due to missing top level configuration file, automatic reconfiguration is impossible.");
/*     */         return;
/*     */       } 
/*  64 */       List list = this.configurationWatchList.getCopyOfFileWatchList();
/*  65 */       long l = this.refreshPeriod / 1000L;
/*  66 */       addInfo("Will scan for changes in [" + list + "] every " + l + " seconds. ");
/*  67 */       synchronized (this.configurationWatchList) {
/*  68 */         updateNextCheck(System.currentTimeMillis());
/*     */       } 
/*  70 */       super.start();
/*     */     } else {
/*  72 */       addWarn("Empty ConfigurationWatchList in context");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  78 */     return "ReconfigureOnChangeFilter{invocationCounter=" + this.invocationCounter + '}';
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  87 */   private long invocationCounter = 0L;
/*     */   
/*  89 */   private volatile long mask = 15L;
/*  90 */   private volatile long lastMaskCheck = System.currentTimeMillis();
/*     */   private static final int MAX_MASK = 65535;
/*     */   
/*     */   public FilterReply decide(Marker paramMarker, Logger paramLogger, Level paramLevel, String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/*  94 */     if (!isStarted()) {
/*  95 */       return FilterReply.NEUTRAL;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     if ((this.invocationCounter++ & this.mask) != this.mask) {
/* 102 */       return FilterReply.NEUTRAL;
/*     */     }
/*     */     
/* 105 */     long l = System.currentTimeMillis();
/*     */     
/* 107 */     synchronized (this.configurationWatchList) {
/* 108 */       updateMaskIfNecessary(l);
/* 109 */       if (changeDetected(l)) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 114 */         disableSubsequentReconfiguration();
/* 115 */         detachReconfigurationToNewThread();
/*     */       } 
/*     */     } 
/*     */     
/* 119 */     return FilterReply.NEUTRAL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long MASK_INCREASE_THRESHOLD = 100L;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long MASK_DECREASE_THRESHOLD = 800L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateMaskIfNecessary(long paramLong) {
/* 136 */     long l = paramLong - this.lastMaskCheck;
/* 137 */     this.lastMaskCheck = paramLong;
/* 138 */     if (l < 100L && this.mask < 65535L) {
/* 139 */       this.mask = this.mask << 1L | 0x1L;
/* 140 */     } else if (l > 800L) {
/* 141 */       this.mask >>>= 2L;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void detachReconfigurationToNewThread() {
/* 149 */     addInfo("Detected change in [" + this.configurationWatchList.getCopyOfFileWatchList() + "]");
/* 150 */     this.context.getExecutorService().submit(new a(this));
/*     */   }
/*     */   
/*     */   void updateNextCheck(long paramLong) {
/* 154 */     this.nextCheck = paramLong + this.refreshPeriod;
/*     */   }
/*     */   
/*     */   protected boolean changeDetected(long paramLong) {
/* 158 */     if (paramLong >= this.nextCheck) {
/* 159 */       updateNextCheck(paramLong);
/* 160 */       return this.configurationWatchList.changeDetected();
/*     */     } 
/* 162 */     return false;
/*     */   }
/*     */   
/*     */   void disableSubsequentReconfiguration() {
/* 166 */     this.nextCheck = Long.MAX_VALUE;
/*     */   }
/*     */   
/*     */   public long getRefreshPeriod() {
/* 170 */     return this.refreshPeriod;
/*     */   }
/*     */   
/*     */   public void setRefreshPeriod(long paramLong) {
/* 174 */     this.refreshPeriod = paramLong;
/*     */   }
/*     */   
/*     */   class a implements Runnable {
/*     */     public void run() {
/* 179 */       if (this.a.mainConfigurationURL == null) {
/* 180 */         this.a.addInfo("Due to missing top level configuration file, skipping reconfiguration");
/*     */         return;
/*     */       } 
/* 183 */       LoggerContext loggerContext = (LoggerContext)this.a.context;
/* 184 */       this.a.addInfo("Will reset and reconfigure context named [" + this.a.context.getName() + "]");
/* 185 */       if (this.a.mainConfigurationURL.toString().endsWith("xml")) {
/* 186 */         a(loggerContext);
/*     */       }
/*     */     }
/*     */     
/*     */     private void a(LoggerContext param1LoggerContext) {
/* 191 */       JoranConfigurator joranConfigurator = new JoranConfigurator();
/* 192 */       joranConfigurator.setContext(this.a.context);
/* 193 */       StatusUtil statusUtil = new StatusUtil(this.a.context);
/* 194 */       List<SaxEvent> list = joranConfigurator.recallSafeConfiguration();
/* 195 */       URL uRL = ConfigurationWatchListUtil.getMainWatchURL(this.a.context);
/* 196 */       param1LoggerContext.reset();
/* 197 */       long l = System.currentTimeMillis();
/*     */       try {
/* 199 */         joranConfigurator.doConfigure(this.a.mainConfigurationURL);
/* 200 */         if (statusUtil.hasXMLParsingErrors(l)) {
/* 201 */           fallbackConfiguration(param1LoggerContext, list, uRL);
/*     */         }
/* 203 */       } catch (JoranException joranException) {
/* 204 */         fallbackConfiguration(param1LoggerContext, list, uRL);
/*     */       } 
/*     */     }
/*     */     a(ReconfigureOnChangeFilter this$0) {}
/*     */     private void fallbackConfiguration(LoggerContext param1LoggerContext, List<SaxEvent> param1List, URL param1URL) {
/* 209 */       JoranConfigurator joranConfigurator = new JoranConfigurator();
/* 210 */       joranConfigurator.setContext(this.a.context);
/* 211 */       if (param1List != null) {
/* 212 */         this.a.addWarn("Falling back to previously registered safe configuration.");
/*     */         try {
/* 214 */           param1LoggerContext.reset();
/* 215 */           JoranConfigurator.informContextOfURLUsedForConfiguration(this.a.context, param1URL);
/* 216 */           joranConfigurator.doConfigure(param1List);
/* 217 */           this.a.addInfo("Re-registering previous fallback configuration once more as a fallback configuration point");
/* 218 */           joranConfigurator.registerSafeConfiguration(param1List);
/* 219 */         } catch (JoranException joranException) {
/* 220 */           this.a.addError("Unexpected exception thrown by a configuration considered safe.", (Throwable)joranException);
/*     */         } 
/*     */       } else {
/* 223 */         this.a.addWarn("No previous configuration to fall back on.");
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\turbo\ReconfigureOnChangeFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */