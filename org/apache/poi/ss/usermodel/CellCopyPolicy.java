/*     */ package org.apache.poi.ss.usermodel;
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
/*     */ public class CellCopyPolicy
/*     */ {
/*     */   public static final boolean DEFAULT_COPY_CELL_VALUE_POLICY = true;
/*     */   public static final boolean DEFAULT_COPY_CELL_STYLE_POLICY = true;
/*     */   public static final boolean DEFAULT_COPY_CELL_FORMULA_POLICY = true;
/*     */   public static final boolean DEFAULT_COPY_HYPERLINK_POLICY = true;
/*     */   public static final boolean DEFAULT_MERGE_HYPERLINK_POLICY = false;
/*     */   public static final boolean DEFAULT_COPY_ROW_HEIGHT_POLICY = true;
/*     */   public static final boolean DEFAULT_CONDENSE_ROWS_POLICY = false;
/*     */   public static final boolean DEFAULT_COPY_MERGED_REGIONS_POLICY = true;
/*     */   private boolean copyCellValue = true;
/*     */   private boolean copyCellStyle = true;
/*     */   private boolean copyCellFormula = true;
/*     */   private boolean copyHyperlink = true;
/*     */   private boolean mergeHyperlink = false;
/*     */   private boolean copyRowHeight = true;
/*     */   private boolean condenseRows = false;
/*     */   private boolean copyMergedRegions = true;
/*     */   
/*     */   public CellCopyPolicy(CellCopyPolicy paramCellCopyPolicy) {
/*  64 */     this.copyCellValue = paramCellCopyPolicy.isCopyCellValue();
/*  65 */     this.copyCellStyle = paramCellCopyPolicy.isCopyCellStyle();
/*  66 */     this.copyCellFormula = paramCellCopyPolicy.isCopyCellFormula();
/*  67 */     this.copyHyperlink = paramCellCopyPolicy.isCopyHyperlink();
/*  68 */     this.mergeHyperlink = paramCellCopyPolicy.isMergeHyperlink();
/*     */     
/*  70 */     this.copyRowHeight = paramCellCopyPolicy.isCopyRowHeight();
/*  71 */     this.condenseRows = paramCellCopyPolicy.isCondenseRows();
/*     */     
/*  73 */     this.copyMergedRegions = paramCellCopyPolicy.isCopyMergedRegions();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CellCopyPolicy(Builder paramBuilder) {
/*  80 */     this.copyCellValue = paramBuilder.copyCellValue;
/*  81 */     this.copyCellStyle = paramBuilder.copyCellStyle;
/*  82 */     this.copyCellFormula = paramBuilder.copyCellFormula;
/*  83 */     this.copyHyperlink = paramBuilder.copyHyperlink;
/*  84 */     this.mergeHyperlink = paramBuilder.mergeHyperlink;
/*     */     
/*  86 */     this.copyRowHeight = paramBuilder.copyRowHeight;
/*  87 */     this.condenseRows = paramBuilder.condenseRows;
/*     */     
/*  89 */     this.copyMergedRegions = paramBuilder.copyMergedRegions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Builder
/*     */   {
/*     */     private boolean copyCellValue = true;
/*     */ 
/*     */     
/*     */     private boolean copyCellStyle = true;
/*     */     
/*     */     private boolean copyCellFormula = true;
/*     */     
/*     */     private boolean copyHyperlink = true;
/*     */     
/*     */     private boolean mergeHyperlink = false;
/*     */     
/*     */     private boolean copyRowHeight = true;
/*     */     
/*     */     private boolean condenseRows = false;
/*     */     
/*     */     private boolean copyMergedRegions = true;
/*     */ 
/*     */     
/*     */     public Builder cellValue(boolean param1Boolean) {
/* 115 */       this.copyCellValue = param1Boolean;
/* 116 */       return this;
/*     */     }
/*     */     public Builder cellStyle(boolean param1Boolean) {
/* 119 */       this.copyCellStyle = param1Boolean;
/* 120 */       return this;
/*     */     }
/*     */     public Builder cellFormula(boolean param1Boolean) {
/* 123 */       this.copyCellFormula = param1Boolean;
/* 124 */       return this;
/*     */     }
/*     */     public Builder copyHyperlink(boolean param1Boolean) {
/* 127 */       this.copyHyperlink = param1Boolean;
/* 128 */       return this;
/*     */     }
/*     */     public Builder mergeHyperlink(boolean param1Boolean) {
/* 131 */       this.mergeHyperlink = param1Boolean;
/* 132 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Builder rowHeight(boolean param1Boolean) {
/* 137 */       this.copyRowHeight = param1Boolean;
/* 138 */       return this;
/*     */     }
/*     */     public Builder condenseRows(boolean param1Boolean) {
/* 141 */       this.condenseRows = param1Boolean;
/* 142 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Builder mergedRegions(boolean param1Boolean) {
/* 147 */       this.copyMergedRegions = param1Boolean;
/* 148 */       return this;
/*     */     }
/*     */     public CellCopyPolicy build() {
/* 151 */       return new CellCopyPolicy(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public Builder createBuilder() {
/* 156 */     return (new Builder()).cellValue(this.copyCellValue).cellStyle(this.copyCellStyle).cellFormula(this.copyCellFormula).copyHyperlink(this.copyHyperlink).mergeHyperlink(this.mergeHyperlink).rowHeight(this.copyRowHeight).condenseRows(this.condenseRows).mergedRegions(this.copyMergedRegions);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCopyCellValue() {
/* 175 */     return this.copyCellValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCopyCellValue(boolean paramBoolean) {
/* 182 */     this.copyCellValue = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCopyCellStyle() {
/* 189 */     return this.copyCellStyle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCopyCellStyle(boolean paramBoolean) {
/* 196 */     this.copyCellStyle = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCopyCellFormula() {
/* 203 */     return this.copyCellFormula;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCopyCellFormula(boolean paramBoolean) {
/* 210 */     this.copyCellFormula = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCopyHyperlink() {
/* 217 */     return this.copyHyperlink;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCopyHyperlink(boolean paramBoolean) {
/* 224 */     this.copyHyperlink = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMergeHyperlink() {
/* 231 */     return this.mergeHyperlink;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMergeHyperlink(boolean paramBoolean) {
/* 238 */     this.mergeHyperlink = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCopyRowHeight() {
/* 248 */     return this.copyRowHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCopyRowHeight(boolean paramBoolean) {
/* 255 */     this.copyRowHeight = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCondenseRows() {
/* 266 */     return this.condenseRows;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCondenseRows(boolean paramBoolean) {
/* 273 */     this.condenseRows = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCopyMergedRegions() {
/* 284 */     return this.copyMergedRegions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCopyMergedRegions(boolean paramBoolean) {
/* 291 */     this.copyMergedRegions = paramBoolean;
/*     */   }
/*     */   
/*     */   public CellCopyPolicy() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\CellCopyPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */