/*     */ package org.apache.poi.ss.usermodel;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
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
/*     */ public final class CellValue
/*     */ {
/*  28 */   public static final CellValue TRUE = new CellValue(CellType.BOOLEAN, 0.0D, true, null, 0);
/*  29 */   public static final CellValue FALSE = new CellValue(CellType.BOOLEAN, 0.0D, false, null, 0);
/*     */   
/*     */   private final CellType _cellType;
/*     */   
/*     */   private final double _numberValue;
/*     */   private final boolean _booleanValue;
/*     */   private final String _textValue;
/*     */   private final int _errorCode;
/*     */   
/*     */   private CellValue(CellType paramCellType, double paramDouble, boolean paramBoolean, String paramString, int paramInt) {
/*  39 */     this._cellType = paramCellType;
/*  40 */     this._numberValue = paramDouble;
/*  41 */     this._booleanValue = paramBoolean;
/*  42 */     this._textValue = paramString;
/*  43 */     this._errorCode = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public CellValue(double paramDouble) {
/*  48 */     this(CellType.NUMERIC, paramDouble, false, null, 0);
/*     */   }
/*     */   public static CellValue valueOf(boolean paramBoolean) {
/*  51 */     return paramBoolean ? TRUE : FALSE;
/*     */   }
/*     */   public CellValue(String paramString) {
/*  54 */     this(CellType.STRING, 0.0D, false, paramString, 0);
/*     */   }
/*     */   public static CellValue getError(int paramInt) {
/*  57 */     return new CellValue(CellType.ERROR, 0.0D, false, null, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBooleanValue() {
/*  65 */     return this._booleanValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getNumberValue() {
/*  71 */     return this._numberValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/*  77 */     return this._textValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellType getCellTypeEnum() {
/*  84 */     return this._cellType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public int getCellType() {
/*  94 */     return this._cellType.getCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getErrorValue() {
/* 101 */     return (byte)this._errorCode;
/*     */   }
/*     */   public String toString() {
/* 104 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 105 */     stringBuffer.append(getClass().getName()).append(" [");
/* 106 */     stringBuffer.append(formatAsString());
/* 107 */     stringBuffer.append("]");
/* 108 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public String formatAsString() {
/* 112 */     switch (this._cellType) {
/*     */       case NUMERIC:
/* 114 */         return String.valueOf(this._numberValue);
/*     */       case STRING:
/* 116 */         return '"' + this._textValue + '"';
/*     */       case BOOLEAN:
/* 118 */         return this._booleanValue ? "TRUE" : "FALSE";
/*     */       case ERROR:
/* 120 */         return ErrorEval.getText(this._errorCode);
/*     */     } 
/* 122 */     return "<error unexpected cell type " + this._cellType + ">";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\CellValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */