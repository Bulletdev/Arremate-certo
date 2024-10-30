/*     */ package org.apache.poi.xdgf.usermodel.section;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CombinedIterable<T>
/*     */   implements Iterable<T>
/*     */ {
/*     */   final SortedMap<Long, T> _baseItems;
/*     */   final SortedMap<Long, T> _masterItems;
/*     */   
/*     */   public CombinedIterable(SortedMap<Long, T> paramSortedMap1, SortedMap<Long, T> paramSortedMap2) {
/*  39 */     this._baseItems = paramSortedMap1;
/*  40 */     this._masterItems = paramSortedMap2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<T> iterator() {
/*     */     final Iterator<?> vmasterI;
/*  48 */     if (this._masterItems != null) {
/*  49 */       iterator = this._masterItems.entrySet().iterator();
/*     */     } else {
/*  51 */       Set<?> set = Collections.emptySet();
/*  52 */       iterator = set.iterator();
/*     */     } 
/*     */     
/*  55 */     return new Iterator<T>()
/*     */       {
/*  57 */         Long lastI = Long.valueOf(Long.MIN_VALUE);
/*     */         
/*  59 */         Map.Entry<Long, T> currentBase = null;
/*  60 */         Map.Entry<Long, T> currentMaster = null;
/*     */ 
/*     */         
/*  63 */         Iterator<Map.Entry<Long, T>> baseI = CombinedIterable.this._baseItems.entrySet().iterator();
/*  64 */         Iterator<Map.Entry<Long, T>> masterI = vmasterI;
/*     */ 
/*     */         
/*     */         public boolean hasNext() {
/*  68 */           return (this.currentBase != null || this.currentMaster != null || this.baseI.hasNext() || this.masterI.hasNext());
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public T next() {
/*     */           T t;
/*  77 */           long l1 = Long.MAX_VALUE;
/*  78 */           long l2 = Long.MAX_VALUE;
/*     */           
/*  80 */           if (this.currentBase == null) {
/*  81 */             while (this.baseI.hasNext()) {
/*  82 */               this.currentBase = this.baseI.next();
/*  83 */               if (((Long)this.currentBase.getKey()).longValue() > this.lastI.longValue()) {
/*  84 */                 l1 = ((Long)this.currentBase.getKey()).longValue();
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } else {
/*  89 */             l1 = ((Long)this.currentBase.getKey()).longValue();
/*     */           } 
/*     */           
/*  92 */           if (this.currentMaster == null) {
/*  93 */             while (this.masterI.hasNext()) {
/*  94 */               this.currentMaster = this.masterI.next();
/*  95 */               if (((Long)this.currentMaster.getKey()).longValue() > this.lastI.longValue()) {
/*  96 */                 l2 = ((Long)this.currentMaster.getKey()).longValue();
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } else {
/* 101 */             l2 = ((Long)this.currentMaster.getKey()).longValue();
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 106 */           if (this.currentBase != null) {
/*     */             
/* 108 */             if (l1 <= l2) {
/* 109 */               this.lastI = Long.valueOf(l1);
/* 110 */               T t1 = this.currentBase.getValue();
/*     */ 
/*     */               
/* 113 */               if (l2 == l1) {
/* 114 */                 this.currentMaster = null;
/*     */               }
/*     */               
/* 117 */               this.currentBase = null;
/*     */             } else {
/*     */               
/* 120 */               this.lastI = Long.valueOf(l2);
/* 121 */               T t1 = this.currentMaster.getValue();
/* 122 */               this.currentMaster = null;
/*     */             }
/*     */           
/* 125 */           } else if (this.currentMaster != null) {
/* 126 */             this.lastI = this.currentMaster.getKey();
/* 127 */             t = this.currentMaster.getValue();
/*     */             
/* 129 */             this.currentMaster = null;
/*     */           } else {
/* 131 */             throw new NoSuchElementException();
/*     */           } 
/*     */           
/* 134 */           return t;
/*     */         }
/*     */ 
/*     */         
/*     */         public void remove() {
/* 139 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\CombinedIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */