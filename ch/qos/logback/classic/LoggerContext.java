/*     */ package ch.qos.logback.classic;
/*     */ 
/*     */ import ch.qos.logback.classic.spi.LoggerComparator;
/*     */ import ch.qos.logback.classic.spi.LoggerContextListener;
/*     */ import ch.qos.logback.classic.spi.LoggerContextVO;
/*     */ import ch.qos.logback.classic.spi.TurboFilterList;
/*     */ import ch.qos.logback.classic.turbo.TurboFilter;
/*     */ import ch.qos.logback.classic.util.LoggerNameUtil;
/*     */ import ch.qos.logback.core.ContextBase;
/*     */ import ch.qos.logback.core.spi.FilterReply;
/*     */ import ch.qos.logback.core.spi.LifeCycle;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.StatusListener;
/*     */ import ch.qos.logback.core.status.StatusManager;
/*     */ import ch.qos.logback.core.status.WarnStatus;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import org.slf4j.ILoggerFactory;
/*     */ import org.slf4j.Logger;
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
/*     */ public class LoggerContext
/*     */   extends ContextBase
/*     */   implements LifeCycle, ILoggerFactory
/*     */ {
/*     */   public static final boolean DEFAULT_PACKAGING_DATA = false;
/*     */   final Logger root;
/*     */   private int size;
/*  60 */   private int noAppenderWarning = 0;
/*  61 */   private final List<LoggerContextListener> loggerContextListenerList = new ArrayList<LoggerContextListener>();
/*     */   
/*     */   private Map<String, Logger> loggerCache;
/*     */   
/*     */   private LoggerContextVO loggerContextRemoteView;
/*  66 */   private final TurboFilterList turboFilterList = new TurboFilterList();
/*     */   
/*     */   private boolean packagingDataEnabled = false;
/*  69 */   private int maxCallerDataDepth = 8;
/*     */   
/*  71 */   int resetCount = 0;
/*     */   
/*     */   private List<String> frameworkPackages;
/*     */   
/*     */   public LoggerContext() {
/*  76 */     this.loggerCache = new ConcurrentHashMap<String, Logger>();
/*     */     
/*  78 */     this.loggerContextRemoteView = new LoggerContextVO(this);
/*  79 */     this.root = new Logger("ROOT", null, this);
/*  80 */     this.root.setLevel(Level.DEBUG);
/*  81 */     this.loggerCache.put("ROOT", this.root);
/*  82 */     initEvaluatorMap();
/*  83 */     this.size = 1;
/*  84 */     this.frameworkPackages = new ArrayList<String>();
/*     */   }
/*     */   
/*     */   void initEvaluatorMap() {
/*  88 */     putObject("EVALUATOR_MAP", new HashMap<Object, Object>());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateLoggerContextVO() {
/*  96 */     this.loggerContextRemoteView = new LoggerContextVO(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putProperty(String paramString1, String paramString2) {
/* 101 */     super.putProperty(paramString1, paramString2);
/* 102 */     updateLoggerContextVO();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 107 */     super.setName(paramString);
/* 108 */     updateLoggerContextVO();
/*     */   }
/*     */   
/*     */   public final Logger getLogger(Class<?> paramClass) {
/* 112 */     return getLogger(paramClass.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Logger getLogger(String paramString) {
/* 118 */     if (paramString == null) {
/* 119 */       throw new IllegalArgumentException("name argument cannot be null");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 124 */     if ("ROOT".equalsIgnoreCase(paramString)) {
/* 125 */       return this.root;
/*     */     }
/*     */     
/* 128 */     int i = 0;
/* 129 */     Logger logger1 = this.root;
/*     */ 
/*     */ 
/*     */     
/* 133 */     Logger logger2 = this.loggerCache.get(paramString);
/*     */     
/* 135 */     if (logger2 != null) {
/* 136 */       return logger2;
/*     */     }
/*     */ 
/*     */     
/*     */     while (true) {
/*     */       String str;
/*     */       
/* 143 */       int j = LoggerNameUtil.getSeparatorIndexOf(paramString, i);
/* 144 */       if (j == -1) {
/* 145 */         str = paramString;
/*     */       } else {
/* 147 */         str = paramString.substring(0, j);
/*     */       } 
/*     */       
/* 150 */       i = j + 1;
/* 151 */       synchronized (logger1) {
/* 152 */         logger2 = logger1.getChildByName(str);
/* 153 */         if (logger2 == null) {
/* 154 */           logger2 = logger1.createChildByName(str);
/* 155 */           this.loggerCache.put(str, logger2);
/* 156 */           incSize();
/*     */         } 
/*     */       } 
/* 159 */       logger1 = logger2;
/* 160 */       if (j == -1) {
/* 161 */         return logger2;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void incSize() {
/* 167 */     this.size++;
/*     */   }
/*     */   
/*     */   int size() {
/* 171 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger exists(String paramString) {
/* 181 */     return this.loggerCache.get(paramString);
/*     */   }
/*     */   
/*     */   final void noAppenderDefinedWarning(Logger paramLogger) {
/* 185 */     if (this.noAppenderWarning++ == 0) {
/* 186 */       getStatusManager().add((Status)new WarnStatus("No appenders present in context [" + getName() + "] for logger [" + paramLogger.getName() + "].", paramLogger));
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Logger> getLoggerList() {
/* 191 */     Collection<Logger> collection = this.loggerCache.values();
/* 192 */     ArrayList<Logger> arrayList = new ArrayList<Logger>(collection);
/* 193 */     Collections.sort(arrayList, (Comparator<? super Logger>)new LoggerComparator());
/* 194 */     return arrayList;
/*     */   }
/*     */   
/*     */   public LoggerContextVO getLoggerContextRemoteView() {
/* 198 */     return this.loggerContextRemoteView;
/*     */   }
/*     */   
/*     */   public void setPackagingDataEnabled(boolean paramBoolean) {
/* 202 */     this.packagingDataEnabled = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isPackagingDataEnabled() {
/* 206 */     return this.packagingDataEnabled;
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
/*     */   public void reset() {
/* 219 */     this.resetCount++;
/* 220 */     super.reset();
/* 221 */     initEvaluatorMap();
/* 222 */     initCollisionMaps();
/* 223 */     this.root.recursiveReset();
/* 224 */     resetTurboFilterList();
/* 225 */     cancelScheduledTasks();
/* 226 */     fireOnReset();
/* 227 */     resetListenersExceptResetResistant();
/* 228 */     resetStatusListeners();
/*     */   }
/*     */   
/*     */   private void cancelScheduledTasks() {
/* 232 */     for (ScheduledFuture scheduledFuture : this.scheduledFutures) {
/* 233 */       scheduledFuture.cancel(false);
/*     */     }
/* 235 */     this.scheduledFutures.clear();
/*     */   }
/*     */   
/*     */   private void resetStatusListeners() {
/* 239 */     StatusManager statusManager = getStatusManager();
/* 240 */     for (StatusListener statusListener : statusManager.getCopyOfStatusListenerList()) {
/* 241 */       statusManager.remove(statusListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public TurboFilterList getTurboFilterList() {
/* 246 */     return this.turboFilterList;
/*     */   }
/*     */   
/*     */   public void addTurboFilter(TurboFilter paramTurboFilter) {
/* 250 */     this.turboFilterList.add(paramTurboFilter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTurboFilterList() {
/* 258 */     for (TurboFilter turboFilter : this.turboFilterList) {
/* 259 */       turboFilter.stop();
/*     */     }
/* 261 */     this.turboFilterList.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   final FilterReply getTurboFilterChainDecision_0_3OrMore(Marker paramMarker, Logger paramLogger, Level paramLevel, String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 266 */     if (this.turboFilterList.size() == 0) {
/* 267 */       return FilterReply.NEUTRAL;
/*     */     }
/* 269 */     return this.turboFilterList.getTurboFilterChainDecision(paramMarker, paramLogger, paramLevel, paramString, paramArrayOfObject, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   final FilterReply getTurboFilterChainDecision_1(Marker paramMarker, Logger paramLogger, Level paramLevel, String paramString, Object paramObject, Throwable paramThrowable) {
/* 274 */     if (this.turboFilterList.size() == 0) {
/* 275 */       return FilterReply.NEUTRAL;
/*     */     }
/* 277 */     return this.turboFilterList.getTurboFilterChainDecision(paramMarker, paramLogger, paramLevel, paramString, new Object[] { paramObject }, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   final FilterReply getTurboFilterChainDecision_2(Marker paramMarker, Logger paramLogger, Level paramLevel, String paramString, Object paramObject1, Object paramObject2, Throwable paramThrowable) {
/* 282 */     if (this.turboFilterList.size() == 0) {
/* 283 */       return FilterReply.NEUTRAL;
/*     */     }
/* 285 */     return this.turboFilterList.getTurboFilterChainDecision(paramMarker, paramLogger, paramLevel, paramString, new Object[] { paramObject1, paramObject2 }, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addListener(LoggerContextListener paramLoggerContextListener) {
/* 290 */     this.loggerContextListenerList.add(paramLoggerContextListener);
/*     */   }
/*     */   
/*     */   public void removeListener(LoggerContextListener paramLoggerContextListener) {
/* 294 */     this.loggerContextListenerList.remove(paramLoggerContextListener);
/*     */   }
/*     */   
/*     */   private void resetListenersExceptResetResistant() {
/* 298 */     ArrayList<LoggerContextListener> arrayList = new ArrayList();
/*     */     
/* 300 */     for (LoggerContextListener loggerContextListener : this.loggerContextListenerList) {
/* 301 */       if (loggerContextListener.isResetResistant()) {
/* 302 */         arrayList.add(loggerContextListener);
/*     */       }
/*     */     } 
/* 305 */     this.loggerContextListenerList.retainAll(arrayList);
/*     */   }
/*     */   
/*     */   private void resetAllListeners() {
/* 309 */     this.loggerContextListenerList.clear();
/*     */   }
/*     */   
/*     */   public List<LoggerContextListener> getCopyOfListenerList() {
/* 313 */     return new ArrayList<LoggerContextListener>(this.loggerContextListenerList);
/*     */   }
/*     */   
/*     */   void fireOnLevelChange(Logger paramLogger, Level paramLevel) {
/* 317 */     for (LoggerContextListener loggerContextListener : this.loggerContextListenerList) {
/* 318 */       loggerContextListener.onLevelChange(paramLogger, paramLevel);
/*     */     }
/*     */   }
/*     */   
/*     */   private void fireOnReset() {
/* 323 */     for (LoggerContextListener loggerContextListener : this.loggerContextListenerList) {
/* 324 */       loggerContextListener.onReset(this);
/*     */     }
/*     */   }
/*     */   
/*     */   private void fireOnStart() {
/* 329 */     for (LoggerContextListener loggerContextListener : this.loggerContextListenerList) {
/* 330 */       loggerContextListener.onStart(this);
/*     */     }
/*     */   }
/*     */   
/*     */   private void fireOnStop() {
/* 335 */     for (LoggerContextListener loggerContextListener : this.loggerContextListenerList) {
/* 336 */       loggerContextListener.onStop(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/* 343 */     super.start();
/* 344 */     fireOnStart();
/*     */   }
/*     */   
/*     */   public void stop() {
/* 348 */     reset();
/* 349 */     fireOnStop();
/* 350 */     resetAllListeners();
/* 351 */     super.stop();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 356 */     return getClass().getName() + "[" + getName() + "]";
/*     */   }
/*     */   
/*     */   public int getMaxCallerDataDepth() {
/* 360 */     return this.maxCallerDataDepth;
/*     */   }
/*     */   
/*     */   public void setMaxCallerDataDepth(int paramInt) {
/* 364 */     this.maxCallerDataDepth = paramInt;
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
/*     */   public List<String> getFrameworkPackages() {
/* 377 */     return this.frameworkPackages;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\LoggerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */