/*     */ package org.apache.commons.text.similarity;
/*     */ 
/*     */ import org.apache.commons.lang3.Validate;
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
/*     */ public class SimilarityScoreFrom<R>
/*     */ {
/*     */   private final SimilarityScore<R> similarityScore;
/*     */   private final CharSequence left;
/*     */   
/*     */   public SimilarityScoreFrom(SimilarityScore<R> paramSimilarityScore, CharSequence paramCharSequence) {
/*  75 */     Validate.isTrue((paramSimilarityScore != null), "The edit distance may not be null.", new Object[0]);
/*     */     
/*  77 */     this.similarityScore = paramSimilarityScore;
/*  78 */     this.left = paramCharSequence;
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
/*     */   public R apply(CharSequence paramCharSequence) {
/*  91 */     return this.similarityScore.apply(this.left, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence getLeft() {
/* 100 */     return this.left;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimilarityScore<R> getSimilarityScore() {
/* 109 */     return this.similarityScore;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\SimilarityScoreFrom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */