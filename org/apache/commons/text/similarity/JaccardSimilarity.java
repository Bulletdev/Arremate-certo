/*    */ package org.apache.commons.text.similarity;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JaccardSimilarity
/*    */   implements SimilarityScore<Double>
/*    */ {
/*    */   public Double apply(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 48 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 49 */       throw new IllegalArgumentException("Input cannot be null");
/*    */     }
/* 51 */     return calculateJaccardSimilarity(paramCharSequence1, paramCharSequence2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Double calculateJaccardSimilarity(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 65 */     int i = paramCharSequence1.length();
/* 66 */     int j = paramCharSequence2.length();
/* 67 */     if (i == 0 || j == 0) {
/* 68 */       return Double.valueOf(0.0D);
/*    */     }
/* 70 */     HashSet<Character> hashSet1 = new HashSet();
/* 71 */     for (byte b1 = 0; b1 < i; b1++) {
/* 72 */       hashSet1.add(Character.valueOf(paramCharSequence1.charAt(b1)));
/*    */     }
/* 74 */     HashSet<Character> hashSet2 = new HashSet();
/* 75 */     for (byte b2 = 0; b2 < j; b2++) {
/* 76 */       hashSet2.add(Character.valueOf(paramCharSequence2.charAt(b2)));
/*    */     }
/* 78 */     HashSet<Character> hashSet3 = new HashSet<>(hashSet1);
/* 79 */     hashSet3.addAll(hashSet2);
/* 80 */     int k = hashSet1.size() + hashSet2.size() - hashSet3.size();
/* 81 */     return Double.valueOf(1.0D * k / hashSet3.size());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\JaccardSimilarity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */