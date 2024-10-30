/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import org.apache.commons.lang3.Validate;
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
/*     */ public class MultiBackgroundInitializer
/*     */   extends BackgroundInitializer<MultiBackgroundInitializer.MultiBackgroundInitializerResults>
/*     */ {
/* 102 */   private final Map<String, BackgroundInitializer<?>> childInitializers = new HashMap<>();
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
/*     */   public MultiBackgroundInitializer(ExecutorService paramExecutorService) {
/* 120 */     super(paramExecutorService);
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
/*     */   public void addInitializer(String paramString, BackgroundInitializer<?> paramBackgroundInitializer) {
/* 136 */     Validate.notNull(paramString, "Name of child initializer must not be null!", new Object[0]);
/* 137 */     Validate.notNull(paramBackgroundInitializer, "Child initializer must not be null!", new Object[0]);
/*     */     
/* 139 */     synchronized (this) {
/* 140 */       if (isStarted()) {
/* 141 */         throw new IllegalStateException("addInitializer() must not be called after start()!");
/*     */       }
/*     */       
/* 144 */       this.childInitializers.put(paramString, paramBackgroundInitializer);
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
/*     */   protected int getTaskCount() {
/* 160 */     int i = 1;
/*     */     
/* 162 */     for (BackgroundInitializer<?> backgroundInitializer : this.childInitializers.values()) {
/* 163 */       i += backgroundInitializer.getTaskCount();
/*     */     }
/*     */     
/* 166 */     return i;
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
/*     */   protected MultiBackgroundInitializerResults initialize() throws Exception {
/*     */     HashMap<String, BackgroundInitializer<?>> hashMap;
/* 182 */     synchronized (this) {
/*     */       
/* 184 */       hashMap = new HashMap<>(this.childInitializers);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 189 */     ExecutorService executorService = getActiveExecutor();
/* 190 */     for (BackgroundInitializer<?> backgroundInitializer : hashMap.values()) {
/* 191 */       if (backgroundInitializer.getExternalExecutor() == null)
/*     */       {
/* 193 */         backgroundInitializer.setExternalExecutor(executorService);
/*     */       }
/* 195 */       backgroundInitializer.start();
/*     */     } 
/*     */ 
/*     */     
/* 199 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/* 200 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 201 */     for (Map.Entry<String, BackgroundInitializer<?>> entry : hashMap.entrySet()) {
/*     */       try {
/* 203 */         hashMap1.put(entry.getKey(), ((BackgroundInitializer)entry.getValue()).get());
/* 204 */       } catch (ConcurrentException concurrentException) {
/* 205 */         hashMap2.put(entry.getKey(), concurrentException);
/*     */       } 
/*     */     } 
/*     */     
/* 209 */     return new MultiBackgroundInitializerResults(hashMap, hashMap1, hashMap2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultiBackgroundInitializer() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class MultiBackgroundInitializerResults
/*     */   {
/*     */     private final Map<String, BackgroundInitializer<?>> initializers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Map<String, Object> resultObjects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Map<String, ConcurrentException> exceptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private MultiBackgroundInitializerResults(Map<String, BackgroundInitializer<?>> param1Map, Map<String, Object> param1Map1, Map<String, ConcurrentException> param1Map2) {
/* 245 */       this.initializers = param1Map;
/* 246 */       this.resultObjects = param1Map1;
/* 247 */       this.exceptions = param1Map2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public BackgroundInitializer<?> getInitializer(String param1String) {
/* 259 */       return checkName(param1String);
/*     */     }
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
/*     */     public Object getResultObject(String param1String) {
/* 275 */       checkName(param1String);
/* 276 */       return this.resultObjects.get(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isException(String param1String) {
/* 288 */       checkName(param1String);
/* 289 */       return this.exceptions.containsKey(param1String);
/*     */     }
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
/*     */     public ConcurrentException getException(String param1String) {
/* 303 */       checkName(param1String);
/* 304 */       return this.exceptions.get(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<String> initializerNames() {
/* 315 */       return Collections.unmodifiableSet(this.initializers.keySet());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSuccessful() {
/* 325 */       return this.exceptions.isEmpty();
/*     */     }
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
/*     */     private BackgroundInitializer<?> checkName(String param1String) {
/* 338 */       BackgroundInitializer<?> backgroundInitializer = this.initializers.get(param1String);
/* 339 */       if (backgroundInitializer == null) {
/* 340 */         throw new NoSuchElementException("No child initializer with name " + param1String);
/*     */       }
/*     */ 
/*     */       
/* 344 */       return backgroundInitializer;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\MultiBackgroundInitializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */