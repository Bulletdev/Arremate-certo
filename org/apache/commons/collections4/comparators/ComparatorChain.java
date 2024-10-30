/*     */ package org.apache.commons.collections4.comparators;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ComparatorChain<E>
/*     */   implements Serializable, Comparator<E>
/*     */ {
/*     */   private static final long serialVersionUID = -721644942746081630L;
/*     */   private final List<Comparator<E>> comparatorChain;
/*  58 */   private BitSet orderingBits = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isLocked = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ComparatorChain() {
/*  70 */     this(new ArrayList<Comparator<E>>(), new BitSet());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ComparatorChain(Comparator<E> paramComparator) {
/*  80 */     this(paramComparator, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ComparatorChain(Comparator<E> paramComparator, boolean paramBoolean) {
/*  91 */     this.comparatorChain = new ArrayList<Comparator<E>>(1);
/*  92 */     this.comparatorChain.add(paramComparator);
/*  93 */     this.orderingBits = new BitSet(1);
/*  94 */     if (paramBoolean == true) {
/*  95 */       this.orderingBits.set(0);
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
/*     */   public ComparatorChain(List<Comparator<E>> paramList) {
/* 108 */     this(paramList, new BitSet(paramList.size()));
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
/*     */   public ComparatorChain(List<Comparator<E>> paramList, BitSet paramBitSet) {
/* 127 */     this.comparatorChain = paramList;
/* 128 */     this.orderingBits = paramBitSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addComparator(Comparator<E> paramComparator) {
/* 139 */     addComparator(paramComparator, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addComparator(Comparator<E> paramComparator, boolean paramBoolean) {
/* 150 */     checkLocked();
/*     */     
/* 152 */     this.comparatorChain.add(paramComparator);
/* 153 */     if (paramBoolean == true) {
/* 154 */       this.orderingBits.set(this.comparatorChain.size() - 1);
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
/*     */   public void setComparator(int paramInt, Comparator<E> paramComparator) throws IndexOutOfBoundsException {
/* 168 */     setComparator(paramInt, paramComparator, false);
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
/*     */   public void setComparator(int paramInt, Comparator<E> paramComparator, boolean paramBoolean) {
/* 180 */     checkLocked();
/*     */     
/* 182 */     this.comparatorChain.set(paramInt, paramComparator);
/* 183 */     if (paramBoolean == true) {
/* 184 */       this.orderingBits.set(paramInt);
/*     */     } else {
/* 186 */       this.orderingBits.clear(paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForwardSort(int paramInt) {
/* 197 */     checkLocked();
/* 198 */     this.orderingBits.clear(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReverseSort(int paramInt) {
/* 208 */     checkLocked();
/* 209 */     this.orderingBits.set(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 218 */     return this.comparatorChain.size();
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
/*     */   public boolean isLocked() {
/* 230 */     return this.isLocked;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkLocked() {
/* 239 */     if (this.isLocked == true) {
/* 240 */       throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkChainIntegrity() {
/* 251 */     if (this.comparatorChain.size() == 0) {
/* 252 */       throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
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
/*     */   public int compare(E paramE1, E paramE2) throws UnsupportedOperationException {
/* 268 */     if (!this.isLocked) {
/* 269 */       checkChainIntegrity();
/* 270 */       this.isLocked = true;
/*     */     } 
/*     */ 
/*     */     
/* 274 */     Iterator<Comparator<E>> iterator = this.comparatorChain.iterator();
/* 275 */     for (byte b = 0; iterator.hasNext(); b++) {
/*     */       
/* 277 */       Comparator<E> comparator = iterator.next();
/* 278 */       int i = comparator.compare(paramE1, paramE2);
/* 279 */       if (i != 0) {
/*     */         
/* 281 */         if (this.orderingBits.get(b) == true) {
/* 282 */           if (i > 0) {
/* 283 */             i = -1;
/*     */           } else {
/* 285 */             i = 1;
/*     */           } 
/*     */         }
/* 288 */         return i;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 293 */     return 0;
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
/*     */   public int hashCode() {
/* 306 */     int i = 0;
/* 307 */     if (null != this.comparatorChain) {
/* 308 */       i ^= this.comparatorChain.hashCode();
/*     */     }
/* 310 */     if (null != this.orderingBits) {
/* 311 */       i ^= this.orderingBits.hashCode();
/*     */     }
/* 313 */     return i;
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
/*     */   public boolean equals(Object paramObject) {
/* 334 */     if (this == paramObject) {
/* 335 */       return true;
/*     */     }
/* 337 */     if (null == paramObject) {
/* 338 */       return false;
/*     */     }
/* 340 */     if (paramObject.getClass().equals(getClass())) {
/* 341 */       ComparatorChain comparatorChain = (ComparatorChain)paramObject;
/* 342 */       return (((null == this.orderingBits) ? (null == comparatorChain.orderingBits) : this.orderingBits.equals(comparatorChain.orderingBits)) && ((null == this.comparatorChain) ? (null == comparatorChain.comparatorChain) : this.comparatorChain.equals(comparatorChain.comparatorChain)));
/*     */     } 
/*     */ 
/*     */     
/* 346 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\comparators\ComparatorChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */