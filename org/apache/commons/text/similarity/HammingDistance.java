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
/*    */ public class HammingDistance
/*    */   implements EditDistance<Integer>
/*    */ {
/*    */   public Integer apply(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 59 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 60 */       throw new IllegalArgumentException("CharSequences must not be null");
/*    */     }
/*    */     
/* 63 */     if (paramCharSequence1.length() != paramCharSequence2.length()) {
/* 64 */       throw new IllegalArgumentException("CharSequences must have the same length");
/*    */     }
/*    */     
/* 67 */     byte b1 = 0;
/*    */     
/* 69 */     for (byte b2 = 0; b2 < paramCharSequence1.length(); b2++) {
/* 70 */       if (paramCharSequence1.charAt(b2) != paramCharSequence2.charAt(b2)) {
/* 71 */         b1++;
/*    */       }
/*    */     } 
/*    */     
/* 75 */     return Integer.valueOf(b1);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\HammingDistance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */