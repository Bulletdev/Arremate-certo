/*     */ package org.apache.commons.text.similarity;
/*     */ 
/*     */ import java.util.Objects;
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
/*     */ public class LevenshteinResults
/*     */ {
/*     */   private final Integer distance;
/*     */   private final Integer insertCount;
/*     */   private final Integer deleteCount;
/*     */   private final Integer substituteCount;
/*     */   
/*     */   public LevenshteinResults(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4) {
/*  59 */     this.distance = paramInteger1;
/*  60 */     this.insertCount = paramInteger2;
/*  61 */     this.deleteCount = paramInteger3;
/*  62 */     this.substituteCount = paramInteger4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getDistance() {
/*  71 */     return this.distance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getInsertCount() {
/*  80 */     return this.insertCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getDeleteCount() {
/*  89 */     return this.deleteCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getSubstituteCount() {
/*  98 */     return this.substituteCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 103 */     if (this == paramObject) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/* 107 */       return false;
/*     */     }
/* 109 */     LevenshteinResults levenshteinResults = (LevenshteinResults)paramObject;
/* 110 */     return (Objects.equals(this.distance, levenshteinResults.distance) && Objects.equals(this.insertCount, levenshteinResults.insertCount) && 
/* 111 */       Objects.equals(this.deleteCount, levenshteinResults.deleteCount) && 
/* 112 */       Objects.equals(this.substituteCount, levenshteinResults.substituteCount));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 117 */     return Objects.hash(new Object[] { this.distance, this.insertCount, this.deleteCount, this.substituteCount });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 122 */     return "Distance: " + this.distance + ", Insert: " + this.insertCount + ", Delete: " + this.deleteCount + ", Substitute: " + this.substituteCount;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\LevenshteinResults.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */