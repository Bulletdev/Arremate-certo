/*     */ package ch.qos.logback.core;
/*     */ 
/*     */ import ch.qos.logback.core.spi.LifeCycle;
/*     */ import ch.qos.logback.core.spi.LogbackLock;
/*     */ import ch.qos.logback.core.status.StatusManager;
/*     */ import ch.qos.logback.core.util.ContextUtil;
/*     */ import ch.qos.logback.core.util.ExecutorServiceUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ScheduledFuture;
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
/*     */ public class ContextBase
/*     */   implements Context, LifeCycle
/*     */ {
/*  38 */   private long birthTime = System.currentTimeMillis();
/*     */   
/*     */   private String name;
/*  41 */   private StatusManager sm = new BasicStatusManager();
/*     */ 
/*     */ 
/*     */   
/*  45 */   Map<String, String> propertyMap = new HashMap<String, String>();
/*  46 */   Map<String, Object> objectMap = new HashMap<String, Object>();
/*     */   
/*  48 */   LogbackLock configurationLock = new LogbackLock();
/*     */   
/*     */   private ScheduledExecutorService scheduledExecutorService;
/*  51 */   protected List<ScheduledFuture<?>> scheduledFutures = new ArrayList<ScheduledFuture<?>>(1);
/*     */   private LifeCycleManager lifeCycleManager;
/*     */   private boolean started;
/*     */   
/*     */   public ContextBase() {
/*  56 */     initCollisionMaps();
/*     */   }
/*     */   
/*     */   public StatusManager getStatusManager() {
/*  60 */     return this.sm;
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
/*     */   public void setStatusManager(StatusManager paramStatusManager) {
/*  75 */     if (paramStatusManager == null) {
/*  76 */       throw new IllegalArgumentException("null StatusManager not allowed");
/*     */     }
/*  78 */     this.sm = paramStatusManager;
/*     */   }
/*     */   
/*     */   public Map<String, String> getCopyOfPropertyMap() {
/*  82 */     return new HashMap<String, String>(this.propertyMap);
/*     */   }
/*     */   
/*     */   public void putProperty(String paramString1, String paramString2) {
/*  86 */     if ("HOSTNAME".equalsIgnoreCase(paramString1)) {
/*  87 */       putHostnameProperty(paramString2);
/*     */     } else {
/*  89 */       this.propertyMap.put(paramString1, paramString2);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void initCollisionMaps() {
/*  94 */     putObject("FA_FILENAME_COLLISION_MAP", new HashMap<Object, Object>());
/*  95 */     putObject("RFA_FILENAME_PATTERN_COLLISION_MAP", new HashMap<Object, Object>());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getProperty(String paramString) {
/* 106 */     if ("CONTEXT_NAME".equals(paramString))
/* 107 */       return getName(); 
/* 108 */     if ("HOSTNAME".equalsIgnoreCase(paramString)) {
/* 109 */       return lazyGetHostname();
/*     */     }
/*     */     
/* 112 */     return this.propertyMap.get(paramString);
/*     */   }
/*     */   
/*     */   private String lazyGetHostname() {
/* 116 */     String str = this.propertyMap.get("HOSTNAME");
/* 117 */     if (str == null) {
/* 118 */       str = (new ContextUtil(this)).safelyGetLocalHostName();
/* 119 */       putHostnameProperty(str);
/*     */     } 
/* 121 */     return str;
/*     */   }
/*     */   
/*     */   private void putHostnameProperty(String paramString) {
/* 125 */     String str = this.propertyMap.get("HOSTNAME");
/* 126 */     if (str == null) {
/* 127 */       this.propertyMap.put("HOSTNAME", paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObject(String paramString) {
/* 134 */     return this.objectMap.get(paramString);
/*     */   }
/*     */   
/*     */   public void putObject(String paramString, Object paramObject) {
/* 138 */     this.objectMap.put(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void removeObject(String paramString) {
/* 142 */     this.objectMap.remove(paramString);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 146 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/* 153 */     this.started = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/* 159 */     stopExecutorService();
/*     */     
/* 161 */     this.started = false;
/*     */   }
/*     */   
/*     */   public boolean isStarted() {
/* 165 */     return this.started;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 174 */     removeShutdownHook();
/* 175 */     getLifeCycleManager().reset();
/* 176 */     this.propertyMap.clear();
/* 177 */     this.objectMap.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) throws IllegalStateException {
/* 188 */     if (paramString != null && paramString.equals(this.name)) {
/*     */       return;
/*     */     }
/* 191 */     if (this.name == null || "default".equals(this.name)) {
/* 192 */       this.name = paramString;
/*     */     } else {
/* 194 */       throw new IllegalStateException("Context has been already given a name");
/*     */     } 
/*     */   }
/*     */   
/*     */   public long getBirthTime() {
/* 199 */     return this.birthTime;
/*     */   }
/*     */   
/*     */   public Object getConfigurationLock() {
/* 203 */     return this.configurationLock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized ExecutorService getExecutorService() {
/* 211 */     return getScheduledExecutorService();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized ScheduledExecutorService getScheduledExecutorService() {
/* 216 */     if (this.scheduledExecutorService == null) {
/* 217 */       this.scheduledExecutorService = ExecutorServiceUtil.newScheduledExecutorService();
/*     */     }
/* 219 */     return this.scheduledExecutorService;
/*     */   }
/*     */   
/*     */   private synchronized void stopExecutorService() {
/* 223 */     if (this.scheduledExecutorService != null) {
/* 224 */       ExecutorServiceUtil.shutdown(this.scheduledExecutorService);
/* 225 */       this.scheduledExecutorService = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void removeShutdownHook() {
/* 230 */     Thread thread = (Thread)getObject("SHUTDOWN_HOOK");
/* 231 */     if (thread != null) {
/* 232 */       removeObject("SHUTDOWN_HOOK");
/*     */       try {
/* 234 */         Runtime.getRuntime().removeShutdownHook(thread);
/* 235 */       } catch (IllegalStateException illegalStateException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void register(LifeCycle paramLifeCycle) {
/* 243 */     getLifeCycleManager().register(paramLifeCycle);
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
/*     */   synchronized LifeCycleManager getLifeCycleManager() {
/* 259 */     if (this.lifeCycleManager == null) {
/* 260 */       this.lifeCycleManager = new LifeCycleManager();
/*     */     }
/* 262 */     return this.lifeCycleManager;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 267 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addScheduledFuture(ScheduledFuture<?> paramScheduledFuture) {
/* 272 */     this.scheduledFutures.add(paramScheduledFuture);
/*     */   }
/*     */   
/*     */   public List<ScheduledFuture<?>> getScheduledFutures() {
/* 276 */     return new ArrayList<ScheduledFuture<?>>(this.scheduledFutures);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\ContextBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */