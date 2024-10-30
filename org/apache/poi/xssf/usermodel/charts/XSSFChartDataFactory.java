/*    */ package org.apache.poi.xssf.usermodel.charts;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.charts.ChartDataFactory;
/*    */ import org.apache.poi.ss.usermodel.charts.LineChartData;
/*    */ import org.apache.poi.ss.usermodel.charts.ScatterChartData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XSSFChartDataFactory
/*    */   implements ChartDataFactory
/*    */ {
/*    */   private static XSSFChartDataFactory instance;
/*    */   
/*    */   public XSSFScatterChartData createScatterChartData() {
/* 39 */     return new XSSFScatterChartData();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XSSFLineChartData createLineChartData() {
/* 46 */     return new XSSFLineChartData();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static XSSFChartDataFactory getInstance() {
/* 53 */     if (instance == null) {
/* 54 */       instance = new XSSFChartDataFactory();
/*    */     }
/* 56 */     return instance;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\charts\XSSFChartDataFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */