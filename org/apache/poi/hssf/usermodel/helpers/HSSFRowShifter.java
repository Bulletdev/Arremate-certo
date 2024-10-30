/*    */ package org.apache.poi.hssf.usermodel.helpers;
/*    */ 
/*    */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*    */ import org.apache.poi.ss.formula.FormulaShifter;
/*    */ import org.apache.poi.ss.formula.eval.NotImplementedException;
/*    */ import org.apache.poi.ss.usermodel.Row;
/*    */ import org.apache.poi.ss.usermodel.Sheet;
/*    */ import org.apache.poi.ss.usermodel.helpers.RowShifter;
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.poi.util.NotImplemented;
/*    */ import org.apache.poi.util.POILogFactory;
/*    */ import org.apache.poi.util.POILogger;
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
/*    */ public final class HSSFRowShifter
/*    */   extends RowShifter
/*    */ {
/* 36 */   private static final POILogger logger = POILogFactory.getLogger(HSSFRowShifter.class);
/*    */   
/*    */   public HSSFRowShifter(HSSFSheet paramHSSFSheet) {
/* 39 */     super((Sheet)paramHSSFSheet);
/*    */   }
/*    */   
/*    */   @NotImplemented
/*    */   public void updateNamedRanges(FormulaShifter paramFormulaShifter) {
/* 44 */     throw new NotImplementedException("HSSFRowShifter.updateNamedRanges");
/*    */   }
/*    */   
/*    */   @NotImplemented
/*    */   public void updateFormulas(FormulaShifter paramFormulaShifter) {
/* 49 */     throw new NotImplementedException("updateFormulas");
/*    */   }
/*    */   
/*    */   @Internal
/*    */   @NotImplemented
/*    */   public void updateRowFormulas(Row paramRow, FormulaShifter paramFormulaShifter) {
/* 55 */     throw new NotImplementedException("updateRowFormulas");
/*    */   }
/*    */   
/*    */   @NotImplemented
/*    */   public void updateConditionalFormatting(FormulaShifter paramFormulaShifter) {
/* 60 */     throw new NotImplementedException("updateConditionalFormatting");
/*    */   }
/*    */   
/*    */   @NotImplemented
/*    */   public void updateHyperlinks(FormulaShifter paramFormulaShifter) {
/* 65 */     throw new NotImplementedException("updateHyperlinks");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\helpers\HSSFRowShifter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */