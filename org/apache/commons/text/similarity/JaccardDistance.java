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
/*    */ public class JaccardDistance
/*    */   implements EditDistance<Double>
/*    */ {
/* 36 */   private final JaccardSimilarity jaccardSimilarity = new JaccardSimilarity();
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
/*    */   public Double apply(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 50 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 51 */       throw new IllegalArgumentException("Input cannot be null");
/*    */     }
/* 53 */     return Double.valueOf(1.0D - this.jaccardSimilarity.apply(paramCharSequence1, paramCharSequence2).doubleValue());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\JaccardDistance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */