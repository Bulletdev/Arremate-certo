/*    */ package org.apache.poi.ss.formula;
/*    */ 
/*    */ import org.apache.poi.ss.SpreadsheetVersion;
/*    */ import org.apache.poi.ss.formula.ptg.AreaPtg;
/*    */ import org.apache.poi.ss.formula.ptg.AreaPtgBase;
/*    */ import org.apache.poi.ss.formula.ptg.OperandPtg;
/*    */ import org.apache.poi.ss.formula.ptg.Ptg;
/*    */ import org.apache.poi.ss.formula.ptg.RefPtg;
/*    */ import org.apache.poi.ss.formula.ptg.RefPtgBase;
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
/*    */ public class SharedFormula
/*    */ {
/*    */   private final int _columnWrappingMask;
/*    */   private final int _rowWrappingMask;
/*    */   
/*    */   public SharedFormula(SpreadsheetVersion paramSpreadsheetVersion) {
/* 31 */     this._columnWrappingMask = paramSpreadsheetVersion.getLastColumnIndex();
/* 32 */     this._rowWrappingMask = paramSpreadsheetVersion.getLastRowIndex();
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
/*    */   
/*    */   public Ptg[] convertSharedFormulas(Ptg[] paramArrayOfPtg, int paramInt1, int paramInt2) {
/* 46 */     Ptg[] arrayOfPtg = new Ptg[paramArrayOfPtg.length];
/*    */     
/* 48 */     for (byte b = 0; b < paramArrayOfPtg.length; b++) {
/* 49 */       RefPtg refPtg; OperandPtg operandPtg; Ptg ptg = paramArrayOfPtg[b];
/* 50 */       byte b1 = -1;
/* 51 */       if (!ptg.isBaseToken()) {
/* 52 */         b1 = ptg.getPtgClass();
/*    */       }
/* 54 */       if (ptg instanceof RefPtgBase)
/* 55 */       { RefPtgBase refPtgBase = (RefPtgBase)ptg;
/* 56 */         refPtg = new RefPtg(fixupRelativeRow(paramInt1, refPtgBase.getRow(), refPtgBase.isRowRelative()), fixupRelativeColumn(paramInt2, refPtgBase.getColumn(), refPtgBase.isColRelative()), refPtgBase.isRowRelative(), refPtgBase.isColRelative());
/*    */ 
/*    */ 
/*    */         
/* 60 */         refPtg.setClass(b1); }
/* 61 */       else { AreaPtg areaPtg; if (refPtg instanceof AreaPtgBase) {
/* 62 */           AreaPtgBase areaPtgBase = (AreaPtgBase)refPtg;
/* 63 */           areaPtg = new AreaPtg(fixupRelativeRow(paramInt1, areaPtgBase.getFirstRow(), areaPtgBase.isFirstRowRelative()), fixupRelativeRow(paramInt1, areaPtgBase.getLastRow(), areaPtgBase.isLastRowRelative()), fixupRelativeColumn(paramInt2, areaPtgBase.getFirstColumn(), areaPtgBase.isFirstColRelative()), fixupRelativeColumn(paramInt2, areaPtgBase.getLastColumn(), areaPtgBase.isLastColRelative()), areaPtgBase.isFirstRowRelative(), areaPtgBase.isLastRowRelative(), areaPtgBase.isFirstColRelative(), areaPtgBase.isLastColRelative());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 71 */           areaPtg.setClass(b1);
/* 72 */         } else if (areaPtg instanceof OperandPtg) {
/*    */           
/* 74 */           operandPtg = ((OperandPtg)areaPtg).copy();
/*    */         }  }
/*    */ 
/*    */       
/* 78 */       arrayOfPtg[b] = (Ptg)operandPtg;
/*    */     } 
/* 80 */     return arrayOfPtg;
/*    */   }
/*    */   
/*    */   private int fixupRelativeColumn(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 84 */     if (paramBoolean)
/*    */     {
/* 86 */       return paramInt2 + paramInt1 & this._columnWrappingMask;
/*    */     }
/* 88 */     return paramInt2;
/*    */   }
/*    */   
/*    */   private int fixupRelativeRow(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 92 */     if (paramBoolean) {
/* 93 */       return paramInt2 + paramInt1 & this._rowWrappingMask;
/*    */     }
/* 95 */     return paramInt2;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\SharedFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */