/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.ResettableIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntrySetMapIterator<K, V>
/*     */   implements MapIterator<K, V>, ResettableIterator<K>
/*     */ {
/*     */   private final Map<K, V> map;
/*     */   private Iterator<Map.Entry<K, V>> iterator;
/*     */   private Map.Entry<K, V> last;
/*     */   private boolean canRemove = false;
/*     */   
/*     */   public EntrySetMapIterator(Map<K, V> paramMap) {
/*  54 */     this.map = paramMap;
/*  55 */     this.iterator = paramMap.entrySet().iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  65 */     return this.iterator.hasNext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K next() {
/*  75 */     this.last = this.iterator.next();
/*  76 */     this.canRemove = true;
/*  77 */     return this.last.getKey();
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
/*     */   public void remove() {
/*  92 */     if (!this.canRemove) {
/*  93 */       throw new IllegalStateException("Iterator remove() can only be called once after next()");
/*     */     }
/*  95 */     this.iterator.remove();
/*  96 */     this.last = null;
/*  97 */     this.canRemove = false;
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
/*     */   public K getKey() {
/* 109 */     if (this.last == null) {
/* 110 */       throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
/*     */     }
/* 112 */     return this.last.getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V getValue() {
/* 123 */     if (this.last == null) {
/* 124 */       throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
/*     */     }
/* 126 */     return this.last.getValue();
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
/*     */   public V setValue(V paramV) {
/* 140 */     if (this.last == null) {
/* 141 */       throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
/*     */     }
/* 143 */     return this.last.setValue(paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 151 */     this.iterator = this.map.entrySet().iterator();
/* 152 */     this.last = null;
/* 153 */     this.canRemove = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     if (this.last != null) {
/* 164 */       return "MapIterator[" + getKey() + "=" + getValue() + "]";
/*     */     }
/* 166 */     return "MapIterator[]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\EntrySetMapIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */