/*     */ package org.h2.mvstore;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Cursor<K, V>
/*     */   implements Iterator<K>
/*     */ {
/*     */   private final MVMap<K, ?> map;
/*     */   private final K from;
/*     */   private CursorPos pos;
/*     */   private K current;
/*     */   private K last;
/*     */   private V currentValue;
/*     */   private V lastValue;
/*     */   private Page lastPage;
/*     */   private final Page root;
/*     */   private boolean initialized;
/*     */   
/*     */   Cursor(MVMap<K, ?> paramMVMap, Page paramPage, K paramK) {
/*  28 */     this.map = paramMVMap;
/*  29 */     this.root = paramPage;
/*  30 */     this.from = paramK;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  35 */     if (!this.initialized) {
/*  36 */       min(this.root, this.from);
/*  37 */       this.initialized = true;
/*  38 */       fetchNext();
/*     */     } 
/*  40 */     return (this.current != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public K next() {
/*  45 */     hasNext();
/*  46 */     K k = this.current;
/*  47 */     this.last = this.current;
/*  48 */     this.lastValue = this.currentValue;
/*  49 */     this.lastPage = (this.pos == null) ? null : this.pos.page;
/*  50 */     fetchNext();
/*  51 */     return k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K getKey() {
/*  60 */     return this.last;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V getValue() {
/*  69 */     return this.lastValue;
/*     */   }
/*     */   
/*     */   Page getPage() {
/*  73 */     return this.lastPage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void skip(long paramLong) {
/*  83 */     if (!hasNext()) {
/*     */       return;
/*     */     }
/*  86 */     if (paramLong < 10L) {
/*  87 */       while (paramLong-- > 0L) {
/*  88 */         fetchNext();
/*     */       }
/*     */       return;
/*     */     } 
/*  92 */     long l = this.map.getKeyIndex(this.current);
/*  93 */     K k = this.map.getKey(l + paramLong);
/*  94 */     this.pos = null;
/*  95 */     min(this.root, k);
/*  96 */     fetchNext();
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove() {
/* 101 */     throw DataUtils.newUnsupportedOperationException("Removing is not supported");
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
/*     */   private void min(Page paramPage, K paramK) {
/*     */     while (true) {
/* 114 */       if (paramPage.isLeaf()) {
/* 115 */         int j = (paramK == null) ? 0 : paramPage.binarySearch(paramK);
/* 116 */         if (j) {
/* 117 */           j = -j - 1;
/*     */         }
/* 119 */         this.pos = new CursorPos(paramPage, j, this.pos);
/*     */         break;
/*     */       } 
/* 122 */       int i = (paramK == null) ? -1 : paramPage.binarySearch(paramK);
/* 123 */       if (i) {
/* 124 */         i = -i - 1;
/*     */       } else {
/* 126 */         i++;
/*     */       } 
/* 128 */       this.pos = new CursorPos(paramPage, i + 1, this.pos);
/* 129 */       paramPage = paramPage.getChildPage(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fetchNext() {
/* 138 */     while (this.pos != null) {
/* 139 */       if (this.pos.index < this.pos.page.getKeyCount()) {
/* 140 */         int i = this.pos.index++;
/* 141 */         this.current = (K)this.pos.page.getKey(i);
/* 142 */         this.currentValue = (V)this.pos.page.getValue(i);
/*     */         return;
/*     */       } 
/* 145 */       this.pos = this.pos.parent;
/* 146 */       if (this.pos == null) {
/*     */         break;
/*     */       }
/* 149 */       if (this.pos.index < this.map.getChildPageCount(this.pos.page)) {
/* 150 */         min(this.pos.page.getChildPage(this.pos.index++), null);
/*     */       }
/*     */     } 
/* 153 */     this.current = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\Cursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */