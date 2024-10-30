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
/*     */ public class IntersectionResult
/*     */ {
/*     */   private final int sizeA;
/*     */   private final int sizeB;
/*     */   private final int intersection;
/*     */   
/*     */   public IntersectionResult(int paramInt1, int paramInt2, int paramInt3) {
/*  56 */     if (paramInt1 < 0) {
/*  57 */       throw new IllegalArgumentException("Set size |A| is not positive: " + paramInt1);
/*     */     }
/*  59 */     if (paramInt2 < 0) {
/*  60 */       throw new IllegalArgumentException("Set size |B| is not positive: " + paramInt2);
/*     */     }
/*  62 */     if (paramInt3 < 0 || paramInt3 > Math.min(paramInt1, paramInt2)) {
/*  63 */       throw new IllegalArgumentException("Invalid intersection of |A| and |B|: " + paramInt3);
/*     */     }
/*  65 */     this.sizeA = paramInt1;
/*  66 */     this.sizeB = paramInt2;
/*  67 */     this.intersection = paramInt3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSizeA() {
/*  76 */     return this.sizeA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSizeB() {
/*  85 */     return this.sizeB;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIntersection() {
/*  94 */     return this.intersection;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  99 */     if (this == paramObject) {
/* 100 */       return true;
/*     */     }
/* 102 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/* 103 */       return false;
/*     */     }
/* 105 */     IntersectionResult intersectionResult = (IntersectionResult)paramObject;
/* 106 */     return (this.sizeA == intersectionResult.sizeA && this.sizeB == intersectionResult.sizeB && this.intersection == intersectionResult.intersection);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 111 */     return Objects.hash(new Object[] { Integer.valueOf(this.sizeA), Integer.valueOf(this.sizeB), Integer.valueOf(this.intersection) });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 116 */     return "Size A: " + this.sizeA + ", Size B: " + this.sizeB + ", Intersection: " + this.intersection;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\IntersectionResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */