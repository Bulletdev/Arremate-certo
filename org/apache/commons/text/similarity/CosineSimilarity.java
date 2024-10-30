/*    */ package org.apache.commons.text.similarity;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
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
/*    */ public class CosineSimilarity
/*    */ {
/*    */   public Double cosineSimilarity(Map<CharSequence, Integer> paramMap1, Map<CharSequence, Integer> paramMap2) {
/*    */     double d4;
/* 45 */     if (paramMap1 == null || paramMap2 == null) {
/* 46 */       throw new IllegalArgumentException("Vectors must not be null");
/*    */     }
/*    */     
/* 49 */     Set<CharSequence> set = getIntersection(paramMap1, paramMap2);
/*    */     
/* 51 */     double d1 = dot(paramMap1, paramMap2, set);
/* 52 */     double d2 = 0.0D;
/* 53 */     for (Integer integer : paramMap1.values()) {
/* 54 */       d2 += Math.pow(integer.intValue(), 2.0D);
/*    */     }
/* 56 */     double d3 = 0.0D;
/* 57 */     for (Integer integer : paramMap2.values()) {
/* 58 */       d3 += Math.pow(integer.intValue(), 2.0D);
/*    */     }
/*    */     
/* 61 */     if (d2 <= 0.0D || d3 <= 0.0D) {
/* 62 */       d4 = 0.0D;
/*    */     } else {
/* 64 */       d4 = d1 / Math.sqrt(d2) * Math.sqrt(d3);
/*    */     } 
/* 66 */     return Double.valueOf(d4);
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
/*    */   private Set<CharSequence> getIntersection(Map<CharSequence, Integer> paramMap1, Map<CharSequence, Integer> paramMap2) {
/* 78 */     HashSet<CharSequence> hashSet = new HashSet(paramMap1.keySet());
/* 79 */     hashSet.retainAll(paramMap2.keySet());
/* 80 */     return hashSet;
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
/*    */   
/*    */   private double dot(Map<CharSequence, Integer> paramMap1, Map<CharSequence, Integer> paramMap2, Set<CharSequence> paramSet) {
/* 95 */     long l = 0L;
/* 96 */     for (CharSequence charSequence : paramSet) {
/* 97 */       l += ((Integer)paramMap1.get(charSequence)).intValue() * ((Integer)paramMap2.get(charSequence)).intValue();
/*    */     }
/* 99 */     return l;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\CosineSimilarity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */