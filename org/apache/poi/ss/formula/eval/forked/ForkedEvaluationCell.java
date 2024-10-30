/*     */ package org.apache.poi.ss.formula.eval.forked;
/*     */ 
/*     */ import org.apache.poi.ss.formula.EvaluationCell;
/*     */ import org.apache.poi.ss.formula.EvaluationSheet;
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
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
/*     */ final class ForkedEvaluationCell
/*     */   implements EvaluationCell
/*     */ {
/*     */   private final EvaluationSheet _sheet;
/*     */   private final EvaluationCell _masterCell;
/*     */   private boolean _booleanValue;
/*     */   private CellType _cellType;
/*     */   private int _errorValue;
/*     */   private double _numberValue;
/*     */   private String _stringValue;
/*     */   
/*     */   public ForkedEvaluationCell(ForkedEvaluationSheet paramForkedEvaluationSheet, EvaluationCell paramEvaluationCell) {
/*  50 */     this._sheet = paramForkedEvaluationSheet;
/*  51 */     this._masterCell = paramEvaluationCell;
/*     */     
/*  53 */     setValue((ValueEval)BlankEval.instance);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getIdentityKey() {
/*  58 */     return this._masterCell.getIdentityKey();
/*     */   }
/*     */   
/*     */   public void setValue(ValueEval paramValueEval) {
/*  62 */     Class<?> clazz = paramValueEval.getClass();
/*     */     
/*  64 */     if (clazz == NumberEval.class) {
/*  65 */       this._cellType = CellType.NUMERIC;
/*  66 */       this._numberValue = ((NumberEval)paramValueEval).getNumberValue();
/*     */       return;
/*     */     } 
/*  69 */     if (clazz == StringEval.class) {
/*  70 */       this._cellType = CellType.STRING;
/*  71 */       this._stringValue = ((StringEval)paramValueEval).getStringValue();
/*     */       return;
/*     */     } 
/*  74 */     if (clazz == BoolEval.class) {
/*  75 */       this._cellType = CellType.BOOLEAN;
/*  76 */       this._booleanValue = ((BoolEval)paramValueEval).getBooleanValue();
/*     */       return;
/*     */     } 
/*  79 */     if (clazz == ErrorEval.class) {
/*  80 */       this._cellType = CellType.ERROR;
/*  81 */       this._errorValue = ((ErrorEval)paramValueEval).getErrorCode();
/*     */       return;
/*     */     } 
/*  84 */     if (clazz == BlankEval.class) {
/*  85 */       this._cellType = CellType.BLANK;
/*     */       return;
/*     */     } 
/*  88 */     throw new IllegalArgumentException("Unexpected value class (" + clazz.getName() + ")");
/*     */   }
/*     */   public void copyValue(Cell paramCell) {
/*  91 */     switch (this._cellType) { case BLANK:
/*  92 */         paramCell.setCellType(CellType.BLANK); return;
/*  93 */       case NUMERIC: paramCell.setCellValue(this._numberValue); return;
/*  94 */       case BOOLEAN: paramCell.setCellValue(this._booleanValue); return;
/*  95 */       case STRING: paramCell.setCellValue(this._stringValue); return;
/*  96 */       case ERROR: paramCell.setCellErrorValue((byte)this._errorValue); return; }
/*  97 */      throw new IllegalStateException("Unexpected data type (" + this._cellType + ")");
/*     */   }
/*     */ 
/*     */   
/*     */   private void checkCellType(CellType paramCellType) {
/* 102 */     if (this._cellType != paramCellType) {
/* 103 */       throw new RuntimeException("Wrong data type (" + this._cellType + ")");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCellType() {
/* 115 */     return this._cellType.getCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellType getCellTypeEnum() {
/* 124 */     return this._cellType;
/*     */   }
/*     */   
/*     */   public boolean getBooleanCellValue() {
/* 128 */     checkCellType(CellType.BOOLEAN);
/* 129 */     return this._booleanValue;
/*     */   }
/*     */   
/*     */   public int getErrorCellValue() {
/* 133 */     checkCellType(CellType.ERROR);
/* 134 */     return this._errorValue;
/*     */   }
/*     */   
/*     */   public double getNumericCellValue() {
/* 138 */     checkCellType(CellType.NUMERIC);
/* 139 */     return this._numberValue;
/*     */   }
/*     */   
/*     */   public String getStringCellValue() {
/* 143 */     checkCellType(CellType.STRING);
/* 144 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public EvaluationSheet getSheet() {
/* 148 */     return this._sheet;
/*     */   }
/*     */   
/*     */   public int getRowIndex() {
/* 152 */     return this._masterCell.getRowIndex();
/*     */   }
/*     */   
/*     */   public int getColumnIndex() {
/* 156 */     return this._masterCell.getColumnIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCachedFormulaResultType() {
/* 167 */     return this._masterCell.getCachedFormulaResultType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellType getCachedFormulaResultTypeEnum() {
/* 176 */     return this._masterCell.getCachedFormulaResultTypeEnum();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\forked\ForkedEvaluationCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */