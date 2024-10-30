/*     */ package org.h2.mvstore.rtree;
/*     */ 
/*     */ import java.util.Arrays;
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
/*     */ public class SpatialKey
/*     */ {
/*     */   private final long id;
/*     */   private final float[] minMax;
/*     */   
/*     */   public SpatialKey(long paramLong, float... paramVarArgs) {
/*  25 */     this.id = paramLong;
/*  26 */     this.minMax = paramVarArgs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float min(int paramInt) {
/*  36 */     return this.minMax[paramInt + paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMin(int paramInt, float paramFloat) {
/*  46 */     this.minMax[paramInt + paramInt] = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float max(int paramInt) {
/*  56 */     return this.minMax[paramInt + paramInt + 1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMax(int paramInt, float paramFloat) {
/*  66 */     this.minMax[paramInt + paramInt + 1] = paramFloat;
/*     */   }
/*     */   
/*     */   public long getId() {
/*  70 */     return this.id;
/*     */   }
/*     */   
/*     */   public boolean isNull() {
/*  74 */     return (this.minMax.length == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  79 */     StringBuilder stringBuilder = new StringBuilder();
/*  80 */     stringBuilder.append(this.id).append(": (");
/*  81 */     for (byte b = 0; b < this.minMax.length; b += 2) {
/*  82 */       if (b > 0) {
/*  83 */         stringBuilder.append(", ");
/*     */       }
/*  85 */       stringBuilder.append(this.minMax[b]).append('/').append(this.minMax[b + 1]);
/*     */     } 
/*  87 */     return stringBuilder.append(")").toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  92 */     return (int)(this.id >>> 32L ^ this.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  97 */     if (paramObject == this)
/*  98 */       return true; 
/*  99 */     if (!(paramObject instanceof SpatialKey)) {
/* 100 */       return false;
/*     */     }
/* 102 */     SpatialKey spatialKey = (SpatialKey)paramObject;
/* 103 */     if (this.id != spatialKey.id) {
/* 104 */       return false;
/*     */     }
/* 106 */     return equalsIgnoringId(spatialKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equalsIgnoringId(SpatialKey paramSpatialKey) {
/* 116 */     return Arrays.equals(this.minMax, paramSpatialKey.minMax);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\rtree\SpatialKey.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */