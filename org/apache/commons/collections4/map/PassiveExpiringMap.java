/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ public class PassiveExpiringMap<K, V>
/*     */   extends AbstractMapDecorator<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public static interface ExpirationPolicy<K, V>
/*     */     extends Serializable
/*     */   {
/*     */     long expirationTime(K param1K, V param1V);
/*     */   }
/*     */   
/*     */   public static class ConstantTimeToLiveExpirationPolicy<K, V>
/*     */     implements ExpirationPolicy<K, V>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private final long timeToLiveMillis;
/*     */     
/*     */     public ConstantTimeToLiveExpirationPolicy() {
/*  91 */       this(-1L);
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
/*     */     public ConstantTimeToLiveExpirationPolicy(long param1Long) {
/* 107 */       this.timeToLiveMillis = param1Long;
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
/*     */     
/*     */     public ConstantTimeToLiveExpirationPolicy(long param1Long, TimeUnit param1TimeUnit) {
/* 124 */       this(PassiveExpiringMap.validateAndConvertToMillis(param1Long, param1TimeUnit));
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
/*     */     public long expirationTime(K param1K, V param1V) {
/* 138 */       if (this.timeToLiveMillis >= 0L) {
/*     */         
/* 140 */         long l = System.currentTimeMillis();
/* 141 */         if (l > Long.MAX_VALUE - this.timeToLiveMillis)
/*     */         {
/*     */           
/* 144 */           return -1L;
/*     */         }
/*     */ 
/*     */         
/* 148 */         return l + this.timeToLiveMillis;
/*     */       } 
/*     */ 
/*     */       
/* 152 */       return -1L;
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
/*     */   private static long validateAndConvertToMillis(long paramLong, TimeUnit paramTimeUnit) {
/* 195 */     if (paramTimeUnit == null) {
/* 196 */       throw new NullPointerException("Time unit must not be null");
/*     */     }
/* 198 */     return TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/* 202 */   private final Map<Object, Long> expirationMap = new HashMap<Object, Long>();
/*     */ 
/*     */ 
/*     */   
/*     */   private final ExpirationPolicy<K, V> expiringPolicy;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PassiveExpiringMap() {
/* 212 */     this(-1L);
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
/*     */   public PassiveExpiringMap(ExpirationPolicy<K, V> paramExpirationPolicy) {
/* 224 */     this(paramExpirationPolicy, new HashMap<K, V>());
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
/*     */   public PassiveExpiringMap(ExpirationPolicy<K, V> paramExpirationPolicy, Map<K, V> paramMap) {
/* 240 */     super(paramMap);
/* 241 */     if (paramExpirationPolicy == null) {
/* 242 */       throw new NullPointerException("Policy must not be null.");
/*     */     }
/* 244 */     this.expiringPolicy = paramExpirationPolicy;
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
/*     */   public PassiveExpiringMap(long paramLong) {
/* 258 */     this(new ConstantTimeToLiveExpirationPolicy<K, V>(paramLong), new HashMap<K, V>());
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
/*     */ 
/*     */ 
/*     */   
/*     */   public PassiveExpiringMap(long paramLong, Map<K, V> paramMap) {
/* 277 */     this(new ConstantTimeToLiveExpirationPolicy<K, V>(paramLong), paramMap);
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
/*     */   
/*     */   public PassiveExpiringMap(long paramLong, TimeUnit paramTimeUnit) {
/* 294 */     this(validateAndConvertToMillis(paramLong, paramTimeUnit));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PassiveExpiringMap(long paramLong, TimeUnit paramTimeUnit, Map<K, V> paramMap) {
/* 314 */     this(validateAndConvertToMillis(paramLong, paramTimeUnit), paramMap);
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
/*     */   public PassiveExpiringMap(Map<K, V> paramMap) {
/* 326 */     this(-1L, paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 335 */     super.clear();
/* 336 */     this.expirationMap.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 346 */     removeIfExpired(paramObject, now());
/* 347 */     return super.containsKey(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 357 */     removeAllExpired(now());
/* 358 */     return super.containsValue(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 367 */     removeAllExpired(now());
/* 368 */     return super.entrySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/* 377 */     removeIfExpired(paramObject, now());
/* 378 */     return super.get(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 387 */     removeAllExpired(now());
/* 388 */     return super.isEmpty();
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
/*     */   private boolean isExpired(long paramLong, Long paramLong1) {
/* 403 */     if (paramLong1 != null) {
/* 404 */       long l = paramLong1.longValue();
/* 405 */       return (l >= 0L && paramLong >= l);
/*     */     } 
/* 407 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 416 */     removeAllExpired(now());
/* 417 */     return super.keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long now() {
/* 424 */     return System.currentTimeMillis();
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
/*     */   public V put(K paramK, V paramV) {
/* 436 */     long l = this.expiringPolicy.expirationTime(paramK, paramV);
/* 437 */     this.expirationMap.put(paramK, Long.valueOf(l));
/*     */     
/* 439 */     return super.put(paramK, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 444 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 445 */       put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/* 456 */     this.expirationMap.remove(paramObject);
/* 457 */     return super.remove(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeAllExpired(long paramLong) {
/* 468 */     Iterator<Map.Entry> iterator = this.expirationMap.entrySet().iterator();
/* 469 */     while (iterator.hasNext()) {
/* 470 */       Map.Entry entry = iterator.next();
/* 471 */       if (isExpired(paramLong, (Long)entry.getValue())) {
/*     */         
/* 473 */         super.remove(entry.getKey());
/*     */         
/* 475 */         iterator.remove();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeIfExpired(Object paramObject, long paramLong) {
/* 486 */     Long long_ = this.expirationMap.get(paramObject);
/* 487 */     if (isExpired(paramLong, long_)) {
/* 488 */       remove(paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 498 */     removeAllExpired(now());
/* 499 */     return super.size();
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
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 513 */     paramObjectInputStream.defaultReadObject();
/* 514 */     this.map = (Map<K, V>)paramObjectInputStream.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 525 */     paramObjectOutputStream.defaultWriteObject();
/* 526 */     paramObjectOutputStream.writeObject(this.map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 535 */     removeAllExpired(now());
/* 536 */     return super.values();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\PassiveExpiringMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */