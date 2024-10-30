/*     */ package org.h2.mvstore;
/*     */ 
/*     */ import java.util.Arrays;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConcurrentArrayList<K>
/*     */ {
/*  22 */   K[] array = (K[])new Object[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K peekFirst() {
/*  31 */     K[] arrayOfK = this.array;
/*  32 */     return (arrayOfK.length == 0) ? null : arrayOfK[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K peekLast() {
/*  41 */     K[] arrayOfK = this.array;
/*  42 */     int i = arrayOfK.length;
/*  43 */     return (i == 0) ? null : arrayOfK[i - 1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void add(K paramK) {
/*  52 */     int i = this.array.length;
/*  53 */     this.array = Arrays.copyOf(this.array, i + 1);
/*  54 */     this.array[i] = paramK;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean removeFirst(K paramK) {
/*  64 */     if (peekFirst() != paramK) {
/*  65 */       return false;
/*     */     }
/*  67 */     int i = this.array.length;
/*     */     
/*  69 */     Object[] arrayOfObject = new Object[i - 1];
/*  70 */     System.arraycopy(this.array, 1, arrayOfObject, 0, i - 1);
/*  71 */     this.array = (K[])arrayOfObject;
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean removeLast(K paramK) {
/*  82 */     if (peekLast() != paramK) {
/*  83 */       return false;
/*     */     }
/*  85 */     this.array = Arrays.copyOf(this.array, this.array.length - 1);
/*  86 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<K> iterator() {
/*  95 */     return new Iterator<K>()
/*     */       {
/*  97 */         K[] a = ConcurrentArrayList.this.array;
/*     */         
/*     */         int index;
/*     */         
/*     */         public boolean hasNext() {
/* 102 */           return (this.index < this.a.length);
/*     */         }
/*     */ 
/*     */         
/*     */         public K next() {
/* 107 */           return this.a[this.index++];
/*     */         }
/*     */ 
/*     */         
/*     */         public void remove() {
/* 112 */           throw DataUtils.newUnsupportedOperationException("remove");
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\ConcurrentArrayList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */