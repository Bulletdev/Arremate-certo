/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ddf.EscherChildAnchorRecord;
/*     */ import org.apache.poi.ddf.EscherRecord;
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
/*     */ public final class HSSFChildAnchor
/*     */   extends HSSFAnchor
/*     */ {
/*     */   private EscherChildAnchorRecord _escherChildAnchor;
/*     */   
/*     */   public HSSFChildAnchor(EscherChildAnchorRecord paramEscherChildAnchorRecord) {
/*  33 */     this._escherChildAnchor = paramEscherChildAnchorRecord;
/*     */   }
/*     */   
/*     */   public HSSFChildAnchor() {
/*  37 */     this._escherChildAnchor = new EscherChildAnchorRecord();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFChildAnchor(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  48 */     super(Math.min(paramInt1, paramInt3), Math.min(paramInt2, paramInt4), Math.max(paramInt1, paramInt3), Math.max(paramInt2, paramInt4));
/*  49 */     if (paramInt1 > paramInt3) {
/*  50 */       this._isHorizontallyFlipped = true;
/*     */     }
/*  52 */     if (paramInt2 > paramInt4) {
/*  53 */       this._isVerticallyFlipped = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDx1() {
/*  59 */     return this._escherChildAnchor.getDx1();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDx1(int paramInt) {
/*  64 */     this._escherChildAnchor.setDx1(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDy1() {
/*  69 */     return this._escherChildAnchor.getDy1();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDy1(int paramInt) {
/*  74 */     this._escherChildAnchor.setDy1(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDy2() {
/*  79 */     return this._escherChildAnchor.getDy2();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDy2(int paramInt) {
/*  84 */     this._escherChildAnchor.setDy2(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDx2() {
/*  89 */     return this._escherChildAnchor.getDx2();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDx2(int paramInt) {
/*  94 */     this._escherChildAnchor.setDx2(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnchor(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 104 */     setDx1(Math.min(paramInt1, paramInt3));
/* 105 */     setDy1(Math.min(paramInt2, paramInt4));
/* 106 */     setDx2(Math.max(paramInt1, paramInt3));
/* 107 */     setDy2(Math.max(paramInt2, paramInt4));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHorizontallyFlipped() {
/* 112 */     return this._isHorizontallyFlipped;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVerticallyFlipped() {
/* 117 */     return this._isVerticallyFlipped;
/*     */   }
/*     */ 
/*     */   
/*     */   protected EscherRecord getEscherAnchor() {
/* 122 */     return (EscherRecord)this._escherChildAnchor;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void createEscherAnchor() {
/* 127 */     this._escherChildAnchor = new EscherChildAnchorRecord();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 132 */     if (paramObject == null)
/* 133 */       return false; 
/* 134 */     if (paramObject == this)
/* 135 */       return true; 
/* 136 */     if (paramObject.getClass() != getClass())
/* 137 */       return false; 
/* 138 */     HSSFChildAnchor hSSFChildAnchor = (HSSFChildAnchor)paramObject;
/*     */     
/* 140 */     return (hSSFChildAnchor.getDx1() == getDx1() && hSSFChildAnchor.getDx2() == getDx2() && hSSFChildAnchor.getDy1() == getDy1() && hSSFChildAnchor.getDy2() == getDy2());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 146 */     assert false : "hashCode not designed";
/* 147 */     return 42;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFChildAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */