/*     */ package ch.qos.logback.core.spi;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public abstract class AbstractComponentTracker<C>
/*     */   implements ComponentTracker<C>
/*     */ {
/*     */   private static final boolean ACCESS_ORDERED = true;
/*     */   public static final long LINGERING_TIMEOUT = 10000L;
/*     */   public static final long WAIT_BETWEEN_SUCCESSIVE_REMOVAL_ITERATIONS = 1000L;
/*  42 */   protected int maxComponents = Integer.MAX_VALUE;
/*  43 */   protected long timeout = 1800000L;
/*     */ 
/*     */   
/*  46 */   LinkedHashMap<String, a<C>> liveMap = new LinkedHashMap<String, a<C>>(32, 0.75F, true);
/*     */ 
/*     */   
/*  49 */   LinkedHashMap<String, a<C>> lingerersMap = new LinkedHashMap<String, a<C>>(16, 0.75F, true);
/*  50 */   long lastCheck = 0L;
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
/*     */   public int getComponentCount() {
/*  77 */     return this.liveMap.size() + this.lingerersMap.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a<C> getFromEitherMap(String paramString) {
/*  87 */     a<C> a = this.liveMap.get(paramString);
/*  88 */     if (a != null) {
/*  89 */       return a;
/*     */     }
/*  91 */     return this.lingerersMap.get(paramString);
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
/*     */   public synchronized C find(String paramString) {
/* 105 */     a<C> a = getFromEitherMap(paramString);
/* 106 */     if (a == null) {
/* 107 */       return null;
/*     */     }
/* 109 */     return a.h;
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
/*     */   public synchronized C getOrCreate(String paramString, long paramLong) {
/* 122 */     a<C> a = getFromEitherMap(paramString);
/* 123 */     if (a == null) {
/* 124 */       C c = buildComponent(paramString);
/* 125 */       a = new a<C>(paramString, c, paramLong);
/*     */       
/* 127 */       this.liveMap.put(paramString, a);
/*     */     } else {
/* 129 */       a.D(paramLong);
/*     */     } 
/* 131 */     return a.h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void endOfLife(String paramString) {
/* 140 */     a<C> a = this.liveMap.remove(paramString);
/* 141 */     if (a == null)
/*     */       return; 
/* 143 */     this.lingerersMap.put(paramString, a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void removeStaleComponents(long paramLong) {
/* 153 */     if (isTooSoonForRemovalIteration(paramLong))
/*     */       return; 
/* 155 */     removeExcedentComponents();
/* 156 */     removeStaleComponentsFromMainMap(paramLong);
/* 157 */     removeStaleComponentsFromLingerersMap(paramLong);
/*     */   }
/*     */   
/*     */   private void removeExcedentComponents() {
/* 161 */     genericStaleComponentRemover(this.liveMap, 0L, this.byExcedent);
/*     */   }
/*     */   
/*     */   private void removeStaleComponentsFromMainMap(long paramLong) {
/* 165 */     genericStaleComponentRemover(this.liveMap, paramLong, this.byTimeout);
/*     */   }
/*     */   
/*     */   private void removeStaleComponentsFromLingerersMap(long paramLong) {
/* 169 */     genericStaleComponentRemover(this.lingerersMap, paramLong, this.byLingering);
/*     */   }
/*     */   
/*     */   private void genericStaleComponentRemover(LinkedHashMap<String, a<C>> paramLinkedHashMap, long paramLong, b<C> paramb) {
/* 173 */     Iterator<Map.Entry> iterator = paramLinkedHashMap.entrySet().iterator();
/* 174 */     while (iterator.hasNext()) {
/* 175 */       Map.Entry entry = iterator.next();
/* 176 */       a<C> a = (a)entry.getValue();
/* 177 */       if (paramb.a(a, paramLong)) {
/* 178 */         iterator.remove();
/* 179 */         C c = a.h;
/* 180 */         processPriorToRemoval(c);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 187 */   private b<C> byExcedent = new b<C>(this) {
/*     */       public boolean a(AbstractComponentTracker.a<C> param1a, long param1Long) {
/* 189 */         return (this.a.liveMap.size() > this.a.maxComponents);
/*     */       }
/*     */     };
/*     */   
/* 193 */   private b<C> byTimeout = new b<C>(this) {
/*     */       public boolean a(AbstractComponentTracker.a<C> param1a, long param1Long) {
/* 195 */         return this.a.isEntryStale(param1a, param1Long);
/*     */       }
/*     */     };
/* 198 */   private b<C> byLingering = new b<C>(this) {
/*     */       public boolean a(AbstractComponentTracker.a<C> param1a, long param1Long) {
/* 200 */         return this.a.isEntryDoneLingering(param1a, param1Long);
/*     */       }
/*     */     };
/*     */   
/*     */   private boolean isTooSoonForRemovalIteration(long paramLong) {
/* 205 */     if (this.lastCheck + 1000L > paramLong) {
/* 206 */       return true;
/*     */     }
/* 208 */     this.lastCheck = paramLong;
/* 209 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isEntryStale(a<C> parama, long paramLong) {
/* 215 */     C c = parama.h;
/* 216 */     if (isComponentStale(c)) {
/* 217 */       return true;
/*     */     }
/* 219 */     return (parama.V + this.timeout < paramLong);
/*     */   }
/*     */   
/*     */   private boolean isEntryDoneLingering(a<C> parama, long paramLong) {
/* 223 */     return (parama.V + 10000L < paramLong);
/*     */   }
/*     */   
/*     */   public Set<String> allKeys() {
/* 227 */     HashSet<String> hashSet = new HashSet(this.liveMap.keySet());
/* 228 */     hashSet.addAll(this.lingerersMap.keySet());
/* 229 */     return hashSet;
/*     */   }
/*     */   
/*     */   public Collection<C> allComponents() {
/* 233 */     ArrayList<C> arrayList = new ArrayList();
/* 234 */     for (a<C> a : this.liveMap.values())
/* 235 */       arrayList.add(a.h); 
/* 236 */     for (a<C> a : this.lingerersMap.values()) {
/* 237 */       arrayList.add(a.h);
/*     */     }
/* 239 */     return arrayList;
/*     */   }
/*     */   
/*     */   public long getTimeout() {
/* 243 */     return this.timeout;
/*     */   }
/*     */   
/*     */   public void setTimeout(long paramLong) {
/* 247 */     this.timeout = paramLong;
/*     */   }
/*     */   
/*     */   public int getMaxComponents() {
/* 251 */     return this.maxComponents;
/*     */   }
/*     */   
/*     */   public void setMaxComponents(int paramInt) {
/* 255 */     this.maxComponents = paramInt;
/*     */   }
/*     */   
/*     */   protected abstract void processPriorToRemoval(C paramC);
/*     */   
/*     */   protected abstract C buildComponent(String paramString);
/*     */   
/*     */   protected abstract boolean isComponentStale(C paramC);
/*     */   
/*     */   private static interface b<C> {
/*     */     boolean a(AbstractComponentTracker.a<C> param1a, long param1Long); }
/*     */   
/*     */   private static class a<C> { String key;
/*     */     
/*     */     a(String param1String, C param1C, long param1Long) {
/* 270 */       this.key = param1String;
/* 271 */       this.h = param1C;
/* 272 */       this.V = param1Long;
/*     */     }
/*     */     C h; long V;
/*     */     public void D(long param1Long) {
/* 276 */       this.V = param1Long;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 281 */       return this.key.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 286 */       if (this == param1Object)
/* 287 */         return true; 
/* 288 */       if (param1Object == null)
/* 289 */         return false; 
/* 290 */       if (getClass() != param1Object.getClass()) {
/* 291 */         return false;
/*     */       }
/* 293 */       a a1 = (a)param1Object;
/* 294 */       if (this.key == null) {
/* 295 */         if (a1.key != null)
/* 296 */           return false; 
/* 297 */       } else if (!this.key.equals(a1.key)) {
/* 298 */         return false;
/* 299 */       }  if (this.h == null) {
/* 300 */         if (a1.h != null)
/* 301 */           return false; 
/* 302 */       } else if (!this.h.equals(a1.h)) {
/* 303 */         return false;
/* 304 */       }  return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 309 */       return "(" + this.key + ", " + this.h + ")";
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\spi\AbstractComponentTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */