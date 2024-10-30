/*     */ package org.apache.poi.xssf.usermodel.charts;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.ss.usermodel.Chart;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartAxis;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartDataSource;
/*     */ import org.apache.poi.ss.usermodel.charts.ScatterChartData;
/*     */ import org.apache.poi.ss.usermodel.charts.ScatterChartSeries;
/*     */ import org.apache.poi.xssf.usermodel.XSSFChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.STScatterStyle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFScatterChartData
/*     */   implements ScatterChartData
/*     */ {
/*  51 */   private List<Series> series = new ArrayList<Series>();
/*     */ 
/*     */   
/*     */   static class Series
/*     */     extends AbstractXSSFChartSeries
/*     */     implements ScatterChartSeries
/*     */   {
/*     */     private int id;
/*     */     
/*     */     private int order;
/*     */     
/*     */     private ChartDataSource<?> xs;
/*     */     
/*     */     private ChartDataSource<? extends Number> ys;
/*     */     
/*     */     protected Series(int param1Int1, int param1Int2, ChartDataSource<?> param1ChartDataSource, ChartDataSource<? extends Number> param1ChartDataSource1) {
/*  67 */       this.id = param1Int1;
/*  68 */       this.order = param1Int2;
/*  69 */       this.xs = param1ChartDataSource;
/*  70 */       this.ys = param1ChartDataSource1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ChartDataSource<?> getXValues() {
/*  78 */       return this.xs;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ChartDataSource<? extends Number> getYValues() {
/*  86 */       return this.ys;
/*     */     }
/*     */     
/*     */     protected void addToChart(CTScatterChart param1CTScatterChart) {
/*  90 */       CTScatterSer cTScatterSer = param1CTScatterChart.addNewSer();
/*  91 */       cTScatterSer.addNewIdx().setVal(this.id);
/*  92 */       cTScatterSer.addNewOrder().setVal(this.order);
/*     */       
/*  94 */       CTAxDataSource cTAxDataSource = cTScatterSer.addNewXVal();
/*  95 */       XSSFChartUtil.buildAxDataSource(cTAxDataSource, this.xs);
/*     */       
/*  97 */       CTNumDataSource cTNumDataSource = cTScatterSer.addNewYVal();
/*  98 */       XSSFChartUtil.buildNumDataSource(cTNumDataSource, this.ys);
/*     */       
/* 100 */       if (isTitleSet()) {
/* 101 */         cTScatterSer.setTx(getCTSerTx());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ScatterChartSeries addSerie(ChartDataSource<?> paramChartDataSource, ChartDataSource<? extends Number> paramChartDataSource1) {
/* 108 */     if (!paramChartDataSource1.isNumeric()) {
/* 109 */       throw new IllegalArgumentException("Y axis data source must be numeric.");
/*     */     }
/* 111 */     int i = this.series.size();
/* 112 */     Series series = new Series(i, i, paramChartDataSource, paramChartDataSource1);
/* 113 */     this.series.add(series);
/* 114 */     return series;
/*     */   }
/*     */   
/*     */   public void fillChart(Chart paramChart, ChartAxis... paramVarArgs) {
/* 118 */     if (!(paramChart instanceof XSSFChart)) {
/* 119 */       throw new IllegalArgumentException("Chart must be instance of XSSFChart");
/*     */     }
/*     */     
/* 122 */     XSSFChart xSSFChart = (XSSFChart)paramChart;
/* 123 */     CTPlotArea cTPlotArea = xSSFChart.getCTChart().getPlotArea();
/* 124 */     CTScatterChart cTScatterChart = cTPlotArea.addNewScatterChart();
/* 125 */     addStyle(cTScatterChart);
/*     */     
/* 127 */     for (Series series : this.series) {
/* 128 */       series.addToChart(cTScatterChart);
/*     */     }
/*     */     
/* 131 */     for (ChartAxis chartAxis : paramVarArgs) {
/* 132 */       cTScatterChart.addNewAxId().setVal(chartAxis.getId());
/*     */     }
/*     */   }
/*     */   
/*     */   public List<? extends Series> getSeries() {
/* 137 */     return this.series;
/*     */   }
/*     */   
/*     */   private void addStyle(CTScatterChart paramCTScatterChart) {
/* 141 */     CTScatterStyle cTScatterStyle = paramCTScatterChart.addNewScatterStyle();
/* 142 */     cTScatterStyle.setVal(STScatterStyle.LINE_MARKER);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\charts\XSSFScatterChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */