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
/*     */ public class EditDistanceFrom<R>
/*     */ {
/*     */   private final EditDistance<R> editDistance;
/*     */   private final CharSequence left;
/*     */   
/*     */   public EditDistanceFrom(EditDistance<R> paramEditDistance, CharSequence paramCharSequence) {
/*  75 */     Validate.isTrue((paramEditDistance != null), "The edit distance may not be null.", new Object[0]);
/*     */     
/*  77 */     this.editDistance = paramEditDistance;
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
/*  91 */     return this.editDistance.apply(this.left, paramCharSequence);
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
/*     */   public EditDistance<R> getEditDistance() {
/* 109 */     return this.editDistance;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\EditDistanceFrom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */