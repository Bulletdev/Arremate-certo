/*     */ package org.apache.poi.xssf.usermodel.charts;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.charts.ChartLegend;
/*     */ import org.apache.poi.ss.usermodel.charts.LegendPosition;
/*     */ import org.apache.poi.ss.usermodel.charts.ManualLayout;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.usermodel.XSSFChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.STLegendPos;
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
/*     */ public final class XSSFChartLegend
/*     */   implements ChartLegend
/*     */ {
/*     */   private CTLegend legend;
/*     */   
/*     */   public XSSFChartLegend(XSSFChart paramXSSFChart) {
/*  47 */     CTChart cTChart = paramXSSFChart.getCTChart();
/*  48 */     this.legend = cTChart.isSetLegend() ? cTChart.getLegend() : cTChart.addNewLegend();
/*     */ 
/*     */ 
/*     */     
/*  52 */     setDefaults();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setDefaults() {
/*  59 */     if (!this.legend.isSetOverlay()) {
/*  60 */       this.legend.addNewOverlay();
/*     */     }
/*  62 */     this.legend.getOverlay().setVal(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTLegend getCTLegend() {
/*  72 */     return this.legend;
/*     */   }
/*     */   
/*     */   public void setPosition(LegendPosition paramLegendPosition) {
/*  76 */     if (!this.legend.isSetLegendPos()) {
/*  77 */       this.legend.addNewLegendPos();
/*     */     }
/*  79 */     this.legend.getLegendPos().setVal(fromLegendPosition(paramLegendPosition));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LegendPosition getPosition() {
/*  86 */     if (this.legend.isSetLegendPos()) {
/*  87 */       return toLegendPosition(this.legend.getLegendPos());
/*     */     }
/*  89 */     return LegendPosition.RIGHT;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFManualLayout getManualLayout() {
/*  94 */     if (!this.legend.isSetLayout()) {
/*  95 */       this.legend.addNewLayout();
/*     */     }
/*  97 */     return new XSSFManualLayout(this.legend.getLayout());
/*     */   }
/*     */   
/*     */   public boolean isOverlay() {
/* 101 */     return this.legend.getOverlay().getVal();
/*     */   }
/*     */   
/*     */   public void setOverlay(boolean paramBoolean) {
/* 105 */     this.legend.getOverlay().setVal(paramBoolean);
/*     */   }
/*     */   
/*     */   private STLegendPos.Enum fromLegendPosition(LegendPosition paramLegendPosition) {
/* 109 */     switch (paramLegendPosition) { case BOTTOM:
/* 110 */         return STLegendPos.B;
/* 111 */       case LEFT: return STLegendPos.L;
/* 112 */       case RIGHT: return STLegendPos.R;
/* 113 */       case TOP: return STLegendPos.T;
/* 114 */       case TOP_RIGHT: return STLegendPos.TR; }
/*     */     
/* 116 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */   
/*     */   private LegendPosition toLegendPosition(CTLegendPos paramCTLegendPos) {
/* 121 */     switch (paramCTLegendPos.getVal().intValue()) { case 1:
/* 122 */         return LegendPosition.BOTTOM;
/* 123 */       case 3: return LegendPosition.LEFT;
/* 124 */       case 4: return LegendPosition.RIGHT;
/* 125 */       case 5: return LegendPosition.TOP;
/* 126 */       case 2: return LegendPosition.TOP_RIGHT; }
/*     */     
/* 128 */     throw new IllegalArgumentException();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\charts\XSSFChartLegend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */