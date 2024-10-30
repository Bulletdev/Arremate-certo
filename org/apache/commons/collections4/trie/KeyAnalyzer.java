/*     */ package org.apache.commons.collections4.trie;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class KeyAnalyzer<K>
/*     */   implements Serializable, Comparator<K>
/*     */ {
/*     */   private static final long serialVersionUID = -20497563720380683L;
/*     */   public static final int NULL_BIT_KEY = -1;
/*     */   public static final int EQUAL_BIT_KEY = -2;
/*     */   public static final int OUT_OF_BOUNDS_BIT_KEY = -3;
/*     */   
/*     */   static boolean isOutOfBoundsIndex(int paramInt) {
/*  58 */     return (paramInt == -3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isEqualBitKey(int paramInt) {
/*  65 */     return (paramInt == -2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isNullBitKey(int paramInt) {
/*  72 */     return (paramInt == -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isValidBitIndex(int paramInt) {
/*  80 */     return (paramInt >= 0);
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
/*     */   public abstract int bitsPerElement();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int lengthInBits(K paramK);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isBitSet(K paramK, int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int bitIndex(K paramK1, int paramInt1, int paramInt2, K paramK2, int paramInt3, int paramInt4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isPrefix(K paramK1, int paramInt1, int paramInt2, K paramK2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compare(K paramK1, K paramK2) {
/* 139 */     if (paramK1 == null)
/* 140 */       return (paramK2 == null) ? 0 : -1; 
/* 141 */     if (paramK2 == null) {
/* 142 */       return 1;
/*     */     }
/*     */     
/* 145 */     return ((Comparable<K>)paramK1).compareTo(paramK2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\trie\KeyAnalyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */