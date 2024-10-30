/*     */ package org.apache.poi.xssf.usermodel.charts;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.charts.AxisCrossBetween;
/*     */ import org.apache.poi.ss.usermodel.charts.AxisCrosses;
/*     */ import org.apache.poi.ss.usermodel.charts.AxisOrientation;
/*     */ import org.apache.poi.ss.usermodel.charts.AxisPosition;
/*     */ import org.apache.poi.ss.usermodel.charts.AxisTickMark;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartAxis;
/*     */ import org.apache.poi.ss.usermodel.charts.ValueAxis;
/*     */ import org.apache.poi.xssf.usermodel.XSSFChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.STCrossBetween;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFValueAxis
/*     */   extends XSSFChartAxis
/*     */   implements ValueAxis
/*     */ {
/*     */   private CTValAx ctValAx;
/*     */   
/*     */   public XSSFValueAxis(XSSFChart paramXSSFChart, long paramLong, AxisPosition paramAxisPosition) {
/*  51 */     super(paramXSSFChart);
/*  52 */     createAxis(paramLong, paramAxisPosition);
/*     */   }
/*     */   
/*     */   public XSSFValueAxis(XSSFChart paramXSSFChart, CTValAx paramCTValAx) {
/*  56 */     super(paramXSSFChart);
/*  57 */     this.ctValAx = paramCTValAx;
/*     */   }
/*     */   
/*     */   public long getId() {
/*  61 */     return this.ctValAx.getAxId().getVal();
/*     */   }
/*     */   
/*     */   public void setCrossBetween(AxisCrossBetween paramAxisCrossBetween) {
/*  65 */     this.ctValAx.getCrossBetween().setVal(fromCrossBetween(paramAxisCrossBetween));
/*     */   }
/*     */   
/*     */   public AxisCrossBetween getCrossBetween() {
/*  69 */     return toCrossBetween(this.ctValAx.getCrossBetween().getVal());
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTAxPos getCTAxPos() {
/*  74 */     return this.ctValAx.getAxPos();
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTNumFmt getCTNumFmt() {
/*  79 */     if (this.ctValAx.isSetNumFmt()) {
/*  80 */       return this.ctValAx.getNumFmt();
/*     */     }
/*  82 */     return this.ctValAx.addNewNumFmt();
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTScaling getCTScaling() {
/*  87 */     return this.ctValAx.getScaling();
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTCrosses getCTCrosses() {
/*  92 */     return this.ctValAx.getCrosses();
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTBoolean getDelete() {
/*  97 */     return this.ctValAx.getDelete();
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTTickMark getMajorCTTickMark() {
/* 102 */     return this.ctValAx.getMajorTickMark();
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTTickMark getMinorCTTickMark() {
/* 107 */     return this.ctValAx.getMinorTickMark();
/*     */   }
/*     */   
/*     */   public void crossAxis(ChartAxis paramChartAxis) {
/* 111 */     this.ctValAx.getCrossAx().setVal(paramChartAxis.getId());
/*     */   }
/*     */   
/*     */   private void createAxis(long paramLong, AxisPosition paramAxisPosition) {
/* 115 */     this.ctValAx = this.chart.getCTChart().getPlotArea().addNewValAx();
/* 116 */     this.ctValAx.addNewAxId().setVal(paramLong);
/* 117 */     this.ctValAx.addNewAxPos();
/* 118 */     this.ctValAx.addNewScaling();
/* 119 */     this.ctValAx.addNewCrossBetween();
/* 120 */     this.ctValAx.addNewCrosses();
/* 121 */     this.ctValAx.addNewCrossAx();
/* 122 */     this.ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
/* 123 */     this.ctValAx.addNewDelete();
/* 124 */     this.ctValAx.addNewMajorTickMark();
/* 125 */     this.ctValAx.addNewMinorTickMark();
/*     */     
/* 127 */     setPosition(paramAxisPosition);
/* 128 */     setOrientation(AxisOrientation.MIN_MAX);
/* 129 */     setCrossBetween(AxisCrossBetween.MIDPOINT_CATEGORY);
/* 130 */     setCrosses(AxisCrosses.AUTO_ZERO);
/* 131 */     setVisible(true);
/* 132 */     setMajorTickMark(AxisTickMark.CROSS);
/* 133 */     setMinorTickMark(AxisTickMark.NONE);
/*     */   }
/*     */   
/*     */   private static STCrossBetween.Enum fromCrossBetween(AxisCrossBetween paramAxisCrossBetween) {
/* 137 */     switch (paramAxisCrossBetween) { case BETWEEN:
/* 138 */         return STCrossBetween.BETWEEN;
/* 139 */       case MIDPOINT_CATEGORY: return STCrossBetween.MID_CAT; }
/*     */     
/* 141 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */   
/*     */   private static AxisCrossBetween toCrossBetween(STCrossBetween.Enum paramEnum) {
/* 146 */     switch (paramEnum.intValue()) { case 1:
/* 147 */         return AxisCrossBetween.BETWEEN;
/* 148 */       case 2: return AxisCrossBetween.MIDPOINT_CATEGORY; }
/*     */     
/* 150 */     throw new IllegalArgumentException();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\charts\XSSFValueAxis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */