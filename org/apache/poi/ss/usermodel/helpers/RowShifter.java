/*    */ package org.apache.poi.ss.usermodel.helpers;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import org.apache.poi.ss.formula.FormulaShifter;
/*    */ import org.apache.poi.ss.usermodel.Row;
/*    */ import org.apache.poi.ss.usermodel.Sheet;
/*    */ import org.apache.poi.ss.util.CellRangeAddress;
/*    */ import org.apache.poi.util.Internal;
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
/*    */ public abstract class RowShifter
/*    */ {
/*    */   protected final Sheet sheet;
/*    */   
/*    */   public RowShifter(Sheet paramSheet) {
/* 42 */     this.sheet = paramSheet;
/*    */   }
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
/*    */   public List<CellRangeAddress> shiftMergedRegions(int paramInt1, int paramInt2, int paramInt3) {
/* 55 */     ArrayList<CellRangeAddress> arrayList = new ArrayList();
/* 56 */     HashSet<Integer> hashSet = new HashSet();
/*    */     
/* 58 */     int i = this.sheet.getNumMergedRegions();
/* 59 */     for (byte b = 0; b < i; b++) {
/* 60 */       CellRangeAddress cellRangeAddress = this.sheet.getMergedRegion(b);
/*    */ 
/*    */       
/* 63 */       if (paramInt1 + paramInt3 <= cellRangeAddress.getFirstRow() && paramInt2 + paramInt3 >= cellRangeAddress.getLastRow()) {
/* 64 */         hashSet.add(Integer.valueOf(b));
/*    */       }
/*    */       else {
/*    */         
/* 68 */         boolean bool1 = (cellRangeAddress.getFirstRow() >= paramInt1 || cellRangeAddress.getLastRow() >= paramInt1) ? true : false;
/* 69 */         boolean bool2 = (cellRangeAddress.getFirstRow() <= paramInt2 || cellRangeAddress.getLastRow() <= paramInt2) ? true : false;
/*    */ 
/*    */         
/* 72 */         if (bool1 && bool2)
/*    */         {
/*    */ 
/*    */ 
/*    */           
/* 77 */           if (!cellRangeAddress.containsRow(paramInt1 - 1) && !cellRangeAddress.containsRow(paramInt2 + 1)) {
/* 78 */             cellRangeAddress.setFirstRow(cellRangeAddress.getFirstRow() + paramInt3);
/* 79 */             cellRangeAddress.setLastRow(cellRangeAddress.getLastRow() + paramInt3);
/*    */             
/* 81 */             arrayList.add(cellRangeAddress);
/* 82 */             hashSet.add(Integer.valueOf(b));
/*    */           }  } 
/*    */       } 
/*    */     } 
/* 86 */     if (!hashSet.isEmpty()) {
/* 87 */       this.sheet.removeMergedRegions(hashSet);
/*    */     }
/*    */ 
/*    */     
/* 91 */     for (CellRangeAddress cellRangeAddress : arrayList) {
/* 92 */       this.sheet.addMergedRegion(cellRangeAddress);
/*    */     }
/* 94 */     return arrayList;
/*    */   }
/*    */   
/*    */   public abstract void updateNamedRanges(FormulaShifter paramFormulaShifter);
/*    */   
/*    */   public abstract void updateFormulas(FormulaShifter paramFormulaShifter);
/*    */   
/*    */   @Internal
/*    */   public abstract void updateRowFormulas(Row paramRow, FormulaShifter paramFormulaShifter);
/*    */   
/*    */   public abstract void updateConditionalFormatting(FormulaShifter paramFormulaShifter);
/*    */   
/*    */   public abstract void updateHyperlinks(FormulaShifter paramFormulaShifter);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\helpers\RowShifter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */