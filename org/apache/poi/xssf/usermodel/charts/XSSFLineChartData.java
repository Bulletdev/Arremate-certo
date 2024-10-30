/*     */ package org.apache.poi.xssf.usermodel.charts;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.ss.usermodel.Chart;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartAxis;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartDataSource;
/*     */ import org.apache.poi.ss.usermodel.charts.LineChartData;
/*     */ import org.apache.poi.ss.usermodel.charts.LineChartSeries;
/*     */ import org.apache.poi.xssf.usermodel.XSSFChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerStyle;
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
/*     */ public class XSSFLineChartData
/*     */   implements LineChartData
/*     */ {
/*  49 */   private List<Series> series = new ArrayList<Series>();
/*     */   
/*     */   static class Series
/*     */     extends AbstractXSSFChartSeries
/*     */     implements LineChartSeries
/*     */   {
/*     */     private int id;
/*     */     private int order;
/*     */     private ChartDataSource<?> categories;
/*     */     private ChartDataSource<? extends Number> values;
/*     */     
/*     */     protected Series(int param1Int1, int param1Int2, ChartDataSource<?> param1ChartDataSource, ChartDataSource<? extends Number> param1ChartDataSource1) {
/*  61 */       this.id = param1Int1;
/*  62 */       this.order = param1Int2;
/*  63 */       this.categories = param1ChartDataSource;
/*  64 */       this.values = param1ChartDataSource1;
/*     */     }
/*     */     
/*     */     public ChartDataSource<?> getCategoryAxisData() {
/*  68 */       return this.categories;
/*     */     }
/*     */     
/*     */     public ChartDataSource<? extends Number> getValues() {
/*  72 */       return this.values;
/*     */     }
/*     */     
/*     */     protected void addToChart(CTLineChart param1CTLineChart) {
/*  76 */       CTLineSer cTLineSer = param1CTLineChart.addNewSer();
/*  77 */       cTLineSer.addNewIdx().setVal(this.id);
/*  78 */       cTLineSer.addNewOrder().setVal(this.order);
/*     */ 
/*     */       
/*  81 */       cTLineSer.addNewMarker().addNewSymbol().setVal(STMarkerStyle.NONE);
/*     */       
/*  83 */       CTAxDataSource cTAxDataSource = cTLineSer.addNewCat();
/*  84 */       XSSFChartUtil.buildAxDataSource(cTAxDataSource, this.categories);
/*  85 */       CTNumDataSource cTNumDataSource = cTLineSer.addNewVal();
/*  86 */       XSSFChartUtil.buildNumDataSource(cTNumDataSource, this.values);
/*     */       
/*  88 */       if (isTitleSet()) {
/*  89 */         cTLineSer.setTx(getCTSerTx());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public LineChartSeries addSeries(ChartDataSource<?> paramChartDataSource, ChartDataSource<? extends Number> paramChartDataSource1) {
/*  95 */     if (!paramChartDataSource1.isNumeric()) {
/*  96 */       throw new IllegalArgumentException("Value data source must be numeric.");
/*     */     }
/*  98 */     int i = this.series.size();
/*  99 */     Series series = new Series(i, i, paramChartDataSource, paramChartDataSource1);
/* 100 */     this.series.add(series);
/* 101 */     return series;
/*     */   }
/*     */   
/*     */   public List<? extends LineChartSeries> getSeries() {
/* 105 */     return (List)this.series;
/*     */   }
/*     */   
/*     */   public void fillChart(Chart paramChart, ChartAxis... paramVarArgs) {
/* 109 */     if (!(paramChart instanceof XSSFChart)) {
/* 110 */       throw new IllegalArgumentException("Chart must be instance of XSSFChart");
/*     */     }
/*     */     
/* 113 */     XSSFChart xSSFChart = (XSSFChart)paramChart;
/* 114 */     CTPlotArea cTPlotArea = xSSFChart.getCTChart().getPlotArea();
/* 115 */     CTLineChart cTLineChart = cTPlotArea.addNewLineChart();
/* 116 */     cTLineChart.addNewVaryColors().setVal(false);
/*     */     
/* 118 */     for (Series series : this.series) {
/* 119 */       series.addToChart(cTLineChart);
/*     */     }
/*     */     
/* 122 */     for (ChartAxis chartAxis : paramVarArgs)
/* 123 */       cTLineChart.addNewAxId().setVal(chartAxis.getId()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\charts\XSSFLineChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */