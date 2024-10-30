/*     */ package org.h2.util;
/*     */ 
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.util.AbstractMap;
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
/*     */ public class SoftHashMap<K, V>
/*     */   extends AbstractMap<K, V>
/*     */ {
/*     */   private final Map<K, SoftValue<V>> map;
/*  26 */   private final ReferenceQueue<V> queue = new ReferenceQueue<>();
/*     */   
/*     */   public SoftHashMap() {
/*  29 */     this.map = New.hashMap();
/*     */   }
/*     */ 
/*     */   
/*     */   private void processQueue() {
/*     */     while (true) {
/*  35 */       Reference<? extends V> reference = this.queue.poll();
/*  36 */       if (reference == null) {
/*     */         return;
/*     */       }
/*  39 */       SoftValue softValue = (SoftValue)reference;
/*  40 */       Object object = softValue.key;
/*  41 */       this.map.remove(object);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/*  47 */     processQueue();
/*  48 */     SoftReference<V> softReference = this.map.get(paramObject);
/*  49 */     if (softReference == null) {
/*  50 */       return null;
/*     */     }
/*  52 */     return softReference.get();
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
/*     */   public V put(K paramK, V paramV) {
/*  65 */     processQueue();
/*  66 */     SoftValue<V> softValue = this.map.put(paramK, new SoftValue<>(paramV, this.queue, paramK));
/*  67 */     return (softValue == null) ? null : softValue.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/*  78 */     processQueue();
/*  79 */     SoftReference<V> softReference = this.map.remove(paramObject);
/*  80 */     return (softReference == null) ? null : softReference.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  85 */     processQueue();
/*  86 */     this.map.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/*  91 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class SoftValue<T>
/*     */     extends SoftReference<T>
/*     */   {
/*     */     final Object key;
/*     */     
/*     */     public SoftValue(T param1T, ReferenceQueue<T> param1ReferenceQueue, Object param1Object) {
/* 101 */       super(param1T, param1ReferenceQueue);
/* 102 */       this.key = param1Object;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\SoftHashMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */