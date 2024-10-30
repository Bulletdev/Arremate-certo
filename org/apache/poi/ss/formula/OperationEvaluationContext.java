/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.ExternalNameEval;
/*     */ import org.apache.poi.ss.formula.eval.FunctionNameEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.formula.functions.FreeRefFunction;
/*     */ import org.apache.poi.ss.formula.ptg.Area3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Area3DPxg;
/*     */ import org.apache.poi.ss.formula.ptg.NameXPtg;
/*     */ import org.apache.poi.ss.formula.ptg.NameXPxg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.ptg.Ref3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ref3DPxg;
/*     */ import org.apache.poi.ss.util.CellReference;
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
/*     */ public final class OperationEvaluationContext
/*     */ {
/*  49 */   public static final FreeRefFunction UDF = UserDefinedFunction.instance;
/*     */   
/*     */   private final EvaluationWorkbook _workbook;
/*     */   private final int _sheetIndex;
/*     */   private final int _rowIndex;
/*     */   private final int _columnIndex;
/*     */   private final EvaluationTracker _tracker;
/*     */   private final WorkbookEvaluator _bookEvaluator;
/*     */   
/*     */   public OperationEvaluationContext(WorkbookEvaluator paramWorkbookEvaluator, EvaluationWorkbook paramEvaluationWorkbook, int paramInt1, int paramInt2, int paramInt3, EvaluationTracker paramEvaluationTracker) {
/*  59 */     this._bookEvaluator = paramWorkbookEvaluator;
/*  60 */     this._workbook = paramEvaluationWorkbook;
/*  61 */     this._sheetIndex = paramInt1;
/*  62 */     this._rowIndex = paramInt2;
/*  63 */     this._columnIndex = paramInt3;
/*  64 */     this._tracker = paramEvaluationTracker;
/*     */   }
/*     */   
/*     */   public EvaluationWorkbook getWorkbook() {
/*  68 */     return this._workbook;
/*     */   }
/*     */   
/*     */   public int getRowIndex() {
/*  72 */     return this._rowIndex;
/*     */   }
/*     */   
/*     */   public int getColumnIndex() {
/*  76 */     return this._columnIndex;
/*     */   }
/*     */   
/*     */   SheetRangeEvaluator createExternSheetRefEvaluator(ExternSheetReferenceToken paramExternSheetReferenceToken) {
/*  80 */     return createExternSheetRefEvaluator(paramExternSheetReferenceToken.getExternSheetIndex());
/*     */   }
/*     */   SheetRangeEvaluator createExternSheetRefEvaluator(String paramString1, String paramString2, int paramInt) {
/*  83 */     EvaluationWorkbook.ExternalSheet externalSheet = this._workbook.getExternalSheet(paramString1, paramString2, paramInt);
/*  84 */     return createExternSheetRefEvaluator(externalSheet);
/*     */   }
/*     */   SheetRangeEvaluator createExternSheetRefEvaluator(int paramInt) {
/*  87 */     EvaluationWorkbook.ExternalSheet externalSheet = this._workbook.getExternalSheet(paramInt);
/*  88 */     return createExternSheetRefEvaluator(externalSheet);
/*     */   }
/*     */   
/*     */   SheetRangeEvaluator createExternSheetRefEvaluator(EvaluationWorkbook.ExternalSheet paramExternalSheet) {
/*     */     WorkbookEvaluator workbookEvaluator;
/*  93 */     int i, j = -1;
/*  94 */     if (paramExternalSheet == null || paramExternalSheet.getWorkbookName() == null) {
/*     */       
/*  96 */       workbookEvaluator = this._bookEvaluator;
/*  97 */       if (paramExternalSheet == null) {
/*  98 */         i = 0;
/*     */       } else {
/* 100 */         i = this._workbook.getSheetIndex(paramExternalSheet.getSheetName());
/*     */       } 
/*     */       
/* 103 */       if (paramExternalSheet instanceof EvaluationWorkbook.ExternalSheetRange) {
/* 104 */         String str = ((EvaluationWorkbook.ExternalSheetRange)paramExternalSheet).getLastSheetName();
/* 105 */         j = this._workbook.getSheetIndex(str);
/*     */       } 
/*     */     } else {
/*     */       
/* 109 */       String str = paramExternalSheet.getWorkbookName();
/*     */       try {
/* 111 */         workbookEvaluator = this._bookEvaluator.getOtherWorkbookEvaluator(str);
/* 112 */       } catch (WorkbookNotFoundException workbookNotFoundException) {
/* 113 */         throw new RuntimeException(workbookNotFoundException.getMessage(), workbookNotFoundException);
/*     */       } 
/*     */       
/* 116 */       i = workbookEvaluator.getSheetIndex(paramExternalSheet.getSheetName());
/* 117 */       if (paramExternalSheet instanceof EvaluationWorkbook.ExternalSheetRange) {
/* 118 */         String str1 = ((EvaluationWorkbook.ExternalSheetRange)paramExternalSheet).getLastSheetName();
/* 119 */         j = workbookEvaluator.getSheetIndex(str1);
/*     */       } 
/*     */       
/* 122 */       if (i < 0) {
/* 123 */         throw new RuntimeException("Invalid sheet name '" + paramExternalSheet.getSheetName() + "' in bool '" + str + "'.");
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 128 */     if (j == -1)
/*     */     {
/* 130 */       j = i;
/*     */     }
/*     */     
/* 133 */     SheetRefEvaluator[] arrayOfSheetRefEvaluator = new SheetRefEvaluator[j - i + 1];
/* 134 */     for (byte b = 0; b < arrayOfSheetRefEvaluator.length; b++) {
/* 135 */       int k = b + i;
/* 136 */       arrayOfSheetRefEvaluator[b] = new SheetRefEvaluator(workbookEvaluator, this._tracker, k);
/*     */     } 
/* 138 */     return new SheetRangeEvaluator(i, j, arrayOfSheetRefEvaluator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SheetRefEvaluator createExternSheetRefEvaluator(String paramString1, String paramString2) {
/*     */     WorkbookEvaluator workbookEvaluator;
/* 146 */     if (paramString1 == null) {
/* 147 */       workbookEvaluator = this._bookEvaluator;
/*     */     } else {
/* 149 */       if (paramString2 == null) {
/* 150 */         throw new IllegalArgumentException("sheetName must not be null if workbookName is provided");
/*     */       }
/*     */       try {
/* 153 */         workbookEvaluator = this._bookEvaluator.getOtherWorkbookEvaluator(paramString1);
/* 154 */       } catch (WorkbookNotFoundException workbookNotFoundException) {
/* 155 */         return null;
/*     */       } 
/*     */     } 
/* 158 */     int i = (paramString2 == null) ? this._sheetIndex : workbookEvaluator.getSheetIndex(paramString2);
/* 159 */     if (i < 0) {
/* 160 */       return null;
/*     */     }
/* 162 */     return new SheetRefEvaluator(workbookEvaluator, this._tracker, i);
/*     */   }
/*     */   
/*     */   public SheetRangeEvaluator getRefEvaluatorForCurrentSheet() {
/* 166 */     SheetRefEvaluator sheetRefEvaluator = new SheetRefEvaluator(this._bookEvaluator, this._tracker, this._sheetIndex);
/* 167 */     return new SheetRangeEvaluator(this._sheetIndex, sheetRefEvaluator);
/*     */   }
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
/*     */   public ValueEval getDynamicReference(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
/*     */     EvaluationName evaluationName;
/*     */     int i, j, k, m;
/*     */     CellReference cellReference;
/* 191 */     if (!paramBoolean) {
/* 192 */       throw new RuntimeException("R1C1 style not supported yet");
/*     */     }
/* 194 */     SheetRefEvaluator sheetRefEvaluator = createExternSheetRefEvaluator(paramString1, paramString2);
/* 195 */     if (sheetRefEvaluator == null) {
/* 196 */       return (ValueEval)ErrorEval.REF_INVALID;
/*     */     }
/* 198 */     SheetRangeEvaluator sheetRangeEvaluator = new SheetRangeEvaluator(this._sheetIndex, sheetRefEvaluator);
/*     */ 
/*     */     
/* 201 */     SpreadsheetVersion spreadsheetVersion = ((FormulaParsingWorkbook)this._workbook).getSpreadsheetVersion();
/*     */     
/* 203 */     CellReference.NameType nameType1 = classifyCellReference(paramString3, spreadsheetVersion);
/* 204 */     switch (nameType1) {
/*     */       case BAD_CELL_OR_NAMED_RANGE:
/* 206 */         return (ValueEval)ErrorEval.REF_INVALID;
/*     */       case NAMED_RANGE:
/* 208 */         evaluationName = ((FormulaParsingWorkbook)this._workbook).getName(paramString3, this._sheetIndex);
/* 209 */         if (!evaluationName.isRange()) {
/* 210 */           throw new RuntimeException("Specified name '" + paramString3 + "' is not a range as expected.");
/*     */         }
/* 212 */         return this._bookEvaluator.evaluateNameFormula(evaluationName.getNameDefinition(), this);
/*     */     } 
/* 214 */     if (paramString4 == null) {
/*     */       CellReference cellReference1;
/* 216 */       switch (nameType1) {
/*     */         case COLUMN:
/*     */         case ROW:
/* 219 */           return (ValueEval)ErrorEval.REF_INVALID;
/*     */         case CELL:
/* 221 */           cellReference1 = new CellReference(paramString3);
/* 222 */           return (ValueEval)new LazyRefEval(cellReference1.getRow(), cellReference1.getCol(), sheetRangeEvaluator);
/*     */       } 
/* 224 */       throw new IllegalStateException("Unexpected reference classification of '" + paramString3 + "'.");
/*     */     } 
/* 226 */     CellReference.NameType nameType2 = classifyCellReference(paramString3, spreadsheetVersion);
/* 227 */     switch (nameType2) {
/*     */       case BAD_CELL_OR_NAMED_RANGE:
/* 229 */         return (ValueEval)ErrorEval.REF_INVALID;
/*     */       case NAMED_RANGE:
/* 231 */         throw new RuntimeException("Cannot evaluate '" + paramString3 + "'. Indirect evaluation of defined names not supported yet");
/*     */     } 
/*     */ 
/*     */     
/* 235 */     if (nameType2 != nameType1)
/*     */     {
/* 237 */       return (ValueEval)ErrorEval.REF_INVALID;
/*     */     }
/*     */     
/* 240 */     switch (nameType1) {
/*     */       case COLUMN:
/* 242 */         i = 0;
/* 243 */         if (nameType2.equals(CellReference.NameType.COLUMN)) {
/*     */           
/* 245 */           k = spreadsheetVersion.getLastRowIndex();
/* 246 */           j = parseRowRef(paramString3);
/* 247 */           m = parseRowRef(paramString4);
/*     */         } else {
/*     */           
/* 250 */           k = spreadsheetVersion.getLastRowIndex();
/* 251 */           j = parseColRef(paramString3);
/* 252 */           m = parseColRef(paramString4);
/*     */         } 
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
/* 281 */         return (ValueEval)new LazyAreaEval(i, j, k, m, sheetRangeEvaluator);case ROW: j = 0; if (nameType2.equals(CellReference.NameType.ROW)) { i = parseColRef(paramString3); k = parseColRef(paramString4); m = spreadsheetVersion.getLastColumnIndex(); } else { m = spreadsheetVersion.getLastColumnIndex(); i = parseRowRef(paramString3); k = parseRowRef(paramString4); }  return (ValueEval)new LazyAreaEval(i, j, k, m, sheetRangeEvaluator);case CELL: cellReference = new CellReference(paramString3); i = cellReference.getRow(); j = cellReference.getCol(); cellReference = new CellReference(paramString4); k = cellReference.getRow(); m = cellReference.getCol(); return (ValueEval)new LazyAreaEval(i, j, k, m, sheetRangeEvaluator);
/*     */     } 
/*     */     throw new IllegalStateException("Unexpected reference classification of '" + paramString3 + "'.");
/*     */   } private static int parseRowRef(String paramString) {
/* 285 */     return CellReference.convertColStringToIndex(paramString);
/*     */   }
/*     */   
/*     */   private static int parseColRef(String paramString) {
/* 289 */     return Integer.parseInt(paramString) - 1;
/*     */   }
/*     */   
/*     */   private static CellReference.NameType classifyCellReference(String paramString, SpreadsheetVersion paramSpreadsheetVersion) {
/* 293 */     int i = paramString.length();
/* 294 */     if (i < 1) {
/* 295 */       return CellReference.NameType.BAD_CELL_OR_NAMED_RANGE;
/*     */     }
/* 297 */     return CellReference.classifyCellReference(paramString, paramSpreadsheetVersion);
/*     */   }
/*     */   
/*     */   public FreeRefFunction findUserDefinedFunction(String paramString) {
/* 301 */     return this._bookEvaluator.findUserDefinedFunction(paramString);
/*     */   }
/*     */   
/*     */   public ValueEval getRefEval(int paramInt1, int paramInt2) {
/* 305 */     SheetRangeEvaluator sheetRangeEvaluator = getRefEvaluatorForCurrentSheet();
/* 306 */     return (ValueEval)new LazyRefEval(paramInt1, paramInt2, sheetRangeEvaluator);
/*     */   }
/*     */   public ValueEval getRef3DEval(Ref3DPtg paramRef3DPtg) {
/* 309 */     SheetRangeEvaluator sheetRangeEvaluator = createExternSheetRefEvaluator(paramRef3DPtg.getExternSheetIndex());
/* 310 */     return (ValueEval)new LazyRefEval(paramRef3DPtg.getRow(), paramRef3DPtg.getColumn(), sheetRangeEvaluator);
/*     */   }
/*     */   public ValueEval getRef3DEval(Ref3DPxg paramRef3DPxg) {
/* 313 */     SheetRangeEvaluator sheetRangeEvaluator = createExternSheetRefEvaluator(paramRef3DPxg.getSheetName(), paramRef3DPxg.getLastSheetName(), paramRef3DPxg.getExternalWorkbookNumber());
/*     */     
/* 315 */     return (ValueEval)new LazyRefEval(paramRef3DPxg.getRow(), paramRef3DPxg.getColumn(), sheetRangeEvaluator);
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueEval getAreaEval(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 320 */     SheetRangeEvaluator sheetRangeEvaluator = getRefEvaluatorForCurrentSheet();
/* 321 */     return (ValueEval)new LazyAreaEval(paramInt1, paramInt2, paramInt3, paramInt4, sheetRangeEvaluator);
/*     */   }
/*     */   public ValueEval getArea3DEval(Area3DPtg paramArea3DPtg) {
/* 324 */     SheetRangeEvaluator sheetRangeEvaluator = createExternSheetRefEvaluator(paramArea3DPtg.getExternSheetIndex());
/* 325 */     return (ValueEval)new LazyAreaEval(paramArea3DPtg.getFirstRow(), paramArea3DPtg.getFirstColumn(), paramArea3DPtg.getLastRow(), paramArea3DPtg.getLastColumn(), sheetRangeEvaluator);
/*     */   }
/*     */   
/*     */   public ValueEval getArea3DEval(Area3DPxg paramArea3DPxg) {
/* 329 */     SheetRangeEvaluator sheetRangeEvaluator = createExternSheetRefEvaluator(paramArea3DPxg.getSheetName(), paramArea3DPxg.getLastSheetName(), paramArea3DPxg.getExternalWorkbookNumber());
/*     */     
/* 331 */     return (ValueEval)new LazyAreaEval(paramArea3DPxg.getFirstRow(), paramArea3DPxg.getFirstColumn(), paramArea3DPxg.getLastRow(), paramArea3DPxg.getLastColumn(), sheetRangeEvaluator);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval getNameXEval(NameXPtg paramNameXPtg) {
/* 337 */     EvaluationWorkbook.ExternalSheet externalSheet = this._workbook.getExternalSheet(paramNameXPtg.getSheetRefIndex());
/* 338 */     if (externalSheet == null || externalSheet.getWorkbookName() == null)
/*     */     {
/* 340 */       return getLocalNameXEval(paramNameXPtg);
/*     */     }
/*     */ 
/*     */     
/* 344 */     String str = externalSheet.getWorkbookName();
/* 345 */     EvaluationWorkbook.ExternalName externalName = this._workbook.getExternalName(paramNameXPtg.getSheetRefIndex(), paramNameXPtg.getNameIndex());
/*     */ 
/*     */ 
/*     */     
/* 349 */     return getExternalNameXEval(externalName, str);
/*     */   }
/*     */   public ValueEval getNameXEval(NameXPxg paramNameXPxg) {
/* 352 */     EvaluationWorkbook.ExternalSheet externalSheet = this._workbook.getExternalSheet(paramNameXPxg.getSheetName(), null, paramNameXPxg.getExternalWorkbookNumber());
/* 353 */     if (externalSheet == null || externalSheet.getWorkbookName() == null)
/*     */     {
/* 355 */       return getLocalNameXEval(paramNameXPxg);
/*     */     }
/*     */ 
/*     */     
/* 359 */     String str = externalSheet.getWorkbookName();
/* 360 */     EvaluationWorkbook.ExternalName externalName = this._workbook.getExternalName(paramNameXPxg.getNameName(), paramNameXPxg.getSheetName(), paramNameXPxg.getExternalWorkbookNumber());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 365 */     return getExternalNameXEval(externalName, str);
/*     */   }
/*     */ 
/*     */   
/*     */   private ValueEval getLocalNameXEval(NameXPxg paramNameXPxg) {
/* 370 */     int i = -1;
/* 371 */     if (paramNameXPxg.getSheetName() != null) {
/* 372 */       i = this._workbook.getSheetIndex(paramNameXPxg.getSheetName());
/*     */     }
/*     */ 
/*     */     
/* 376 */     String str = paramNameXPxg.getNameName();
/* 377 */     EvaluationName evaluationName = this._workbook.getName(str, i);
/* 378 */     if (evaluationName != null)
/*     */     {
/* 380 */       return (ValueEval)new ExternalNameEval(evaluationName);
/*     */     }
/*     */     
/* 383 */     return (ValueEval)new FunctionNameEval(str);
/*     */   }
/*     */   
/*     */   private ValueEval getLocalNameXEval(NameXPtg paramNameXPtg) {
/* 387 */     String str = this._workbook.resolveNameXText(paramNameXPtg);
/*     */ 
/*     */     
/* 390 */     int i = str.indexOf('!');
/* 391 */     EvaluationName evaluationName = null;
/* 392 */     if (i > -1) {
/*     */       
/* 394 */       String str1 = str.substring(0, i);
/* 395 */       String str2 = str.substring(i + 1);
/* 396 */       evaluationName = this._workbook.getName(str2, this._workbook.getSheetIndex(str1));
/*     */     } else {
/*     */       
/* 399 */       evaluationName = this._workbook.getName(str, -1);
/*     */     } 
/*     */     
/* 402 */     if (evaluationName != null)
/*     */     {
/* 404 */       return (ValueEval)new ExternalNameEval(evaluationName);
/*     */     }
/*     */     
/* 407 */     return (ValueEval)new FunctionNameEval(str);
/*     */   }
/*     */   
/*     */   public int getSheetIndex() {
/* 411 */     return this._sheetIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   private ValueEval getExternalNameXEval(EvaluationWorkbook.ExternalName paramExternalName, String paramString) {
/*     */     try {
/* 417 */       WorkbookEvaluator workbookEvaluator = this._bookEvaluator.getOtherWorkbookEvaluator(paramString);
/* 418 */       EvaluationName evaluationName = workbookEvaluator.getName(paramExternalName.getName(), paramExternalName.getIx() - 1);
/* 419 */       if (evaluationName != null && evaluationName.hasFormula()) {
/* 420 */         if ((evaluationName.getNameDefinition()).length > 1) {
/* 421 */           throw new RuntimeException("Complex name formulas not supported yet");
/*     */         }
/*     */ 
/*     */         
/* 425 */         OperationEvaluationContext operationEvaluationContext = new OperationEvaluationContext(workbookEvaluator, workbookEvaluator.getWorkbook(), -1, -1, -1, this._tracker);
/*     */ 
/*     */         
/* 428 */         Ptg ptg = evaluationName.getNameDefinition()[0];
/* 429 */         if (ptg instanceof Ref3DPtg) {
/* 430 */           Ref3DPtg ref3DPtg = (Ref3DPtg)ptg;
/* 431 */           return operationEvaluationContext.getRef3DEval(ref3DPtg);
/* 432 */         }  if (ptg instanceof Ref3DPxg) {
/* 433 */           Ref3DPxg ref3DPxg = (Ref3DPxg)ptg;
/* 434 */           return operationEvaluationContext.getRef3DEval(ref3DPxg);
/* 435 */         }  if (ptg instanceof Area3DPtg) {
/* 436 */           Area3DPtg area3DPtg = (Area3DPtg)ptg;
/* 437 */           return operationEvaluationContext.getArea3DEval(area3DPtg);
/* 438 */         }  if (ptg instanceof Area3DPxg) {
/* 439 */           Area3DPxg area3DPxg = (Area3DPxg)ptg;
/* 440 */           return operationEvaluationContext.getArea3DEval(area3DPxg);
/*     */         } 
/*     */       } 
/* 443 */       return (ValueEval)ErrorEval.REF_INVALID;
/* 444 */     } catch (WorkbookNotFoundException workbookNotFoundException) {
/* 445 */       return (ValueEval)ErrorEval.REF_INVALID;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\OperationEvaluationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */