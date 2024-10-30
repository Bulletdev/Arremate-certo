/*     */ package org.apache.poi.xssf.usermodel.charts;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.charts.AxisCrosses;
/*     */ import org.apache.poi.ss.usermodel.charts.AxisOrientation;
/*     */ import org.apache.poi.ss.usermodel.charts.AxisPosition;
/*     */ import org.apache.poi.ss.usermodel.charts.AxisTickMark;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartAxis;
/*     */ import org.apache.poi.xssf.usermodel.XSSFChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
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
/*     */ public class XSSFCategoryAxis
/*     */   extends XSSFChartAxis
/*     */ {
/*     */   private CTCatAx ctCatAx;
/*     */   
/*     */   public XSSFCategoryAxis(XSSFChart paramXSSFChart, long paramLong, AxisPosition paramAxisPosition) {
/*  36 */     super(paramXSSFChart);
/*  37 */     createAxis(paramLong, paramAxisPosition);
/*     */   }
/*     */   
/*     */   public XSSFCategoryAxis(XSSFChart paramXSSFChart, CTCatAx paramCTCatAx) {
/*  41 */     super(paramXSSFChart);
/*  42 */     this.ctCatAx = paramCTCatAx;
/*     */   }
/*     */   
/*     */   public long getId() {
/*  46 */     return this.ctCatAx.getAxId().getVal();
/*     */   }
/*     */   
/*     */   protected CTAxPos getCTAxPos() {
/*  50 */     return this.ctCatAx.getAxPos();
/*     */   }
/*     */   
/*     */   protected CTNumFmt getCTNumFmt() {
/*  54 */     if (this.ctCatAx.isSetNumFmt()) {
/*  55 */       return this.ctCatAx.getNumFmt();
/*     */     }
/*  57 */     return this.ctCatAx.addNewNumFmt();
/*     */   }
/*     */   
/*     */   protected CTScaling getCTScaling() {
/*  61 */     return this.ctCatAx.getScaling();
/*     */   }
/*     */   
/*     */   protected CTCrosses getCTCrosses() {
/*  65 */     return this.ctCatAx.getCrosses();
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTBoolean getDelete() {
/*  70 */     return this.ctCatAx.getDelete();
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTTickMark getMajorCTTickMark() {
/*  75 */     return this.ctCatAx.getMajorTickMark();
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTTickMark getMinorCTTickMark() {
/*  80 */     return this.ctCatAx.getMinorTickMark();
/*     */   }
/*     */   
/*     */   public void crossAxis(ChartAxis paramChartAxis) {
/*  84 */     this.ctCatAx.getCrossAx().setVal(paramChartAxis.getId());
/*     */   }
/*     */   
/*     */   private void createAxis(long paramLong, AxisPosition paramAxisPosition) {
/*  88 */     this.ctCatAx = this.chart.getCTChart().getPlotArea().addNewCatAx();
/*  89 */     this.ctCatAx.addNewAxId().setVal(paramLong);
/*  90 */     this.ctCatAx.addNewAxPos();
/*  91 */     this.ctCatAx.addNewScaling();
/*  92 */     this.ctCatAx.addNewCrosses();
/*  93 */     this.ctCatAx.addNewCrossAx();
/*  94 */     this.ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
/*  95 */     this.ctCatAx.addNewDelete();
/*  96 */     this.ctCatAx.addNewMajorTickMark();
/*  97 */     this.ctCatAx.addNewMinorTickMark();
/*     */     
/*  99 */     setPosition(paramAxisPosition);
/* 100 */     setOrientation(AxisOrientation.MIN_MAX);
/* 101 */     setCrosses(AxisCrosses.AUTO_ZERO);
/* 102 */     setVisible(true);
/* 103 */     setMajorTickMark(AxisTickMark.CROSS);
/* 104 */     setMinorTickMark(AxisTickMark.NONE);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\charts\XSSFCategoryAxis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */