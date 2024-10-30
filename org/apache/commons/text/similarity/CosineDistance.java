/*    */ package org.apache.commons.text.similarity;
/*    */ 
/*    */ import java.util.Map;
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
/*    */ public class CosineDistance
/*    */   implements EditDistance<Double>
/*    */ {
/* 40 */   private final Tokenizer<CharSequence> tokenizer = new RegexTokenizer();
/*    */ 
/*    */ 
/*    */   
/* 44 */   private final CosineSimilarity cosineSimilarity = new CosineSimilarity();
/*    */ 
/*    */   
/*    */   public Double apply(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 48 */     CharSequence[] arrayOfCharSequence1 = this.tokenizer.tokenize(paramCharSequence1);
/* 49 */     CharSequence[] arrayOfCharSequence2 = this.tokenizer.tokenize(paramCharSequence2);
/*    */     
/* 51 */     Map<CharSequence, Integer> map1 = Counter.of(arrayOfCharSequence1);
/* 52 */     Map<CharSequence, Integer> map2 = Counter.of(arrayOfCharSequence2);
/* 53 */     double d = this.cosineSimilarity.cosineSimilarity(map1, map2).doubleValue();
/* 54 */     return Double.valueOf(1.0D - d);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\CosineDistance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */