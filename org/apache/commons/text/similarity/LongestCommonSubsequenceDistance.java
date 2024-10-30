/*    */ package org.apache.commons.text.similarity;
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
/*    */ public class LongestCommonSubsequenceDistance
/*    */   implements EditDistance<Integer>
/*    */ {
/* 42 */   private final LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
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
/*    */   public Integer apply(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 58 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 59 */       throw new IllegalArgumentException("Inputs must not be null");
/*    */     }
/* 61 */     return Integer.valueOf(paramCharSequence1.length() + paramCharSequence2.length() - 2 * this.longestCommonSubsequence.apply(paramCharSequence1, paramCharSequence2).intValue());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\LongestCommonSubsequenceDistance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */