/*    */ package org.apache.poi.hssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.hssf.record.CFRuleBase;
/*    */ import org.apache.poi.hssf.record.cf.Threshold;
/*    */ import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
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
/*    */ public final class HSSFConditionalFormattingThreshold
/*    */   implements ConditionalFormattingThreshold
/*    */ {
/*    */   private final Threshold threshold;
/*    */   private final HSSFSheet sheet;
/*    */   private final HSSFWorkbook workbook;
/*    */   
/*    */   protected HSSFConditionalFormattingThreshold(Threshold paramThreshold, HSSFSheet paramHSSFSheet) {
/* 35 */     this.threshold = paramThreshold;
/* 36 */     this.sheet = paramHSSFSheet;
/* 37 */     this.workbook = paramHSSFSheet.getWorkbook();
/*    */   }
/*    */   protected Threshold getThreshold() {
/* 40 */     return this.threshold;
/*    */   }
/*    */   
/*    */   public ConditionalFormattingThreshold.RangeType getRangeType() {
/* 44 */     return ConditionalFormattingThreshold.RangeType.byId(this.threshold.getType());
/*    */   }
/*    */   public void setRangeType(ConditionalFormattingThreshold.RangeType paramRangeType) {
/* 47 */     this.threshold.setType((byte)paramRangeType.id);
/*    */   }
/*    */   
/*    */   public String getFormula() {
/* 51 */     return HSSFConditionalFormattingRule.toFormulaString(this.threshold.getParsedExpression(), this.workbook);
/*    */   }
/*    */   public void setFormula(String paramString) {
/* 54 */     this.threshold.setParsedExpression(CFRuleBase.parseFormula(paramString, this.sheet));
/*    */   }
/*    */   
/*    */   public Double getValue() {
/* 58 */     return this.threshold.getValue();
/*    */   }
/*    */   public void setValue(Double paramDouble) {
/* 61 */     this.threshold.setValue(paramDouble);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFConditionalFormattingThreshold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */