/*    */ package org.apache.poi.xssf.usermodel.charts;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.charts.ChartSeries;
/*    */ import org.apache.poi.ss.usermodel.charts.TitleType;
/*    */ import org.apache.poi.ss.util.CellReference;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
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
/*    */ public abstract class AbstractXSSFChartSeries
/*    */   implements ChartSeries
/*    */ {
/*    */   private String titleValue;
/*    */   private CellReference titleRef;
/*    */   private TitleType titleType;
/*    */   
/*    */   public void setTitle(CellReference paramCellReference) {
/* 35 */     this.titleType = TitleType.CELL_REFERENCE;
/* 36 */     this.titleRef = paramCellReference;
/*    */   }
/*    */   
/*    */   public void setTitle(String paramString) {
/* 40 */     this.titleType = TitleType.STRING;
/* 41 */     this.titleValue = paramString;
/*    */   }
/*    */   
/*    */   public CellReference getTitleCellReference() {
/* 45 */     if (TitleType.CELL_REFERENCE.equals(this.titleType)) {
/* 46 */       return this.titleRef;
/*    */     }
/* 48 */     throw new IllegalStateException("Title type is not CellReference.");
/*    */   }
/*    */   
/*    */   public String getTitleString() {
/* 52 */     if (TitleType.STRING.equals(this.titleType)) {
/* 53 */       return this.titleValue;
/*    */     }
/* 55 */     throw new IllegalStateException("Title type is not String.");
/*    */   }
/*    */   
/*    */   public TitleType getTitleType() {
/* 59 */     return this.titleType;
/*    */   }
/*    */   
/*    */   protected boolean isTitleSet() {
/* 63 */     return (this.titleType != null);
/*    */   }
/*    */   
/*    */   protected CTSerTx getCTSerTx() {
/* 67 */     CTSerTx cTSerTx = CTSerTx.Factory.newInstance();
/* 68 */     switch (this.titleType) {
/*    */       case CELL_REFERENCE:
/* 70 */         cTSerTx.addNewStrRef().setF(this.titleRef.formatAsString());
/* 71 */         return cTSerTx;
/*    */       case STRING:
/* 73 */         cTSerTx.setV(this.titleValue);
/* 74 */         return cTSerTx;
/*    */     } 
/* 76 */     throw new IllegalStateException("Unkown title type: " + this.titleType);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\charts\AbstractXSSFChartSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */