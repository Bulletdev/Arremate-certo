/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.commons.collections4.ResettableListIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LoopingListIterator<E>
/*     */   implements ResettableListIterator<E>
/*     */ {
/*     */   private final List<E> list;
/*     */   private ListIterator<E> iterator;
/*     */   
/*     */   public LoopingListIterator(List<E> paramList) {
/*  58 */     if (paramList == null) {
/*  59 */       throw new NullPointerException("The list must not be null");
/*     */     }
/*  61 */     this.list = paramList;
/*  62 */     _reset();
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
/*     */   public boolean hasNext() {
/*  74 */     return !this.list.isEmpty();
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
/*     */   public E next() {
/*  86 */     if (this.list.isEmpty()) {
/*  87 */       throw new NoSuchElementException("There are no elements for this iterator to loop on");
/*     */     }
/*     */     
/*  90 */     if (!this.iterator.hasNext()) {
/*  91 */       reset();
/*     */     }
/*  93 */     return this.iterator.next();
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
/*     */   public int nextIndex() {
/* 108 */     if (this.list.isEmpty()) {
/* 109 */       throw new NoSuchElementException("There are no elements for this iterator to loop on");
/*     */     }
/*     */     
/* 112 */     if (!this.iterator.hasNext()) {
/* 113 */       return 0;
/*     */     }
/* 115 */     return this.iterator.nextIndex();
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
/*     */   public boolean hasPrevious() {
/* 127 */     return !this.list.isEmpty();
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
/*     */   public E previous() {
/* 140 */     if (this.list.isEmpty()) {
/* 141 */       throw new NoSuchElementException("There are no elements for this iterator to loop on");
/*     */     }
/*     */     
/* 144 */     if (!this.iterator.hasPrevious()) {
/* 145 */       E e = null;
/* 146 */       while (this.iterator.hasNext()) {
/* 147 */         e = this.iterator.next();
/*     */       }
/* 149 */       this.iterator.previous();
/* 150 */       return e;
/*     */     } 
/* 152 */     return this.iterator.previous();
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
/*     */   public int previousIndex() {
/* 167 */     if (this.list.isEmpty()) {
/* 168 */       throw new NoSuchElementException("There are no elements for this iterator to loop on");
/*     */     }
/*     */     
/* 171 */     if (!this.iterator.hasPrevious()) {
/* 172 */       return this.list.size() - 1;
/*     */     }
/* 174 */     return this.iterator.previousIndex();
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
/*     */   public void remove() {
/* 196 */     this.iterator.remove();
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
/*     */   public void add(E paramE) {
/* 215 */     this.iterator.add(paramE);
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
/*     */   public void set(E paramE) {
/* 231 */     this.iterator.set(paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 238 */     _reset();
/*     */   }
/*     */   
/*     */   private void _reset() {
/* 242 */     this.iterator = this.list.listIterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 251 */     return this.list.size();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\LoopingListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */