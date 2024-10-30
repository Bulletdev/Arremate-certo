/*     */ package org.apache.commons.lang3.tuple;
/*     */ 
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MutablePair<L, R>
/*     */   extends Pair<L, R>
/*     */ {
/*  41 */   public static final MutablePair<?, ?>[] EMPTY_ARRAY = (MutablePair<?, ?>[])new MutablePair[0];
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long serialVersionUID = 4954918890077093841L;
/*     */ 
/*     */ 
/*     */   
/*     */   public L left;
/*     */ 
/*     */   
/*     */   public R right;
/*     */ 
/*     */ 
/*     */   
/*     */   public static <L, R> MutablePair<L, R>[] emptyArray() {
/*  57 */     return (MutablePair<L, R>[])EMPTY_ARRAY;
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
/*     */   public static <L, R> MutablePair<L, R> of(L paramL, R paramR) {
/*  73 */     return new MutablePair<>(paramL, paramR);
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
/*     */   public static <L, R> MutablePair<L, R> of(Map.Entry<L, R> paramEntry) {
/*     */     L l;
/*     */     R r;
/*  90 */     if (paramEntry != null) {
/*  91 */       L l1 = paramEntry.getKey();
/*  92 */       R r1 = paramEntry.getValue();
/*     */     } else {
/*  94 */       l = null;
/*  95 */       r = null;
/*     */     } 
/*  97 */     return new MutablePair<>(l, r);
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
/*     */   public MutablePair() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MutablePair(L paramL, R paramR) {
/* 121 */     this.left = paramL;
/* 122 */     this.right = paramR;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public L getLeft() {
/* 131 */     return this.left;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public R getRight() {
/* 139 */     return this.right;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeft(L paramL) {
/* 148 */     this.left = paramL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRight(R paramR) {
/* 157 */     this.right = paramR;
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
/*     */   public R setValue(R paramR) {
/* 169 */     R r = getRight();
/* 170 */     setRight(paramR);
/* 171 */     return r;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\tuple\MutablePair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */