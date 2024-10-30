/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Stack;
/*     */ import java.util.TreeSet;
/*     */ import org.apache.poi.ss.formula.atp.AnalysisToolPak;
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.ExternalNameEval;
/*     */ import org.apache.poi.ss.formula.eval.FunctionEval;
/*     */ import org.apache.poi.ss.formula.eval.FunctionNameEval;
/*     */ import org.apache.poi.ss.formula.eval.MissingArgEval;
/*     */ import org.apache.poi.ss.formula.eval.NotImplementedException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.formula.functions.Choose;
/*     */ import org.apache.poi.ss.formula.functions.FreeRefFunction;
/*     */ import org.apache.poi.ss.formula.functions.Function;
/*     */ import org.apache.poi.ss.formula.functions.IfFunc;
/*     */ import org.apache.poi.ss.formula.ptg.Area3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Area3DPxg;
/*     */ import org.apache.poi.ss.formula.ptg.AreaPtg;
/*     */ import org.apache.poi.ss.formula.ptg.AttrPtg;
/*     */ import org.apache.poi.ss.formula.ptg.BoolPtg;
/*     */ import org.apache.poi.ss.formula.ptg.ErrPtg;
/*     */ import org.apache.poi.ss.formula.ptg.FuncVarPtg;
/*     */ import org.apache.poi.ss.formula.ptg.IntPtg;
/*     */ import org.apache.poi.ss.formula.ptg.NamePtg;
/*     */ import org.apache.poi.ss.formula.ptg.NameXPtg;
/*     */ import org.apache.poi.ss.formula.ptg.NameXPxg;
/*     */ import org.apache.poi.ss.formula.ptg.NumberPtg;
/*     */ import org.apache.poi.ss.formula.ptg.OperationPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.ptg.Ref3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ref3DPxg;
/*     */ import org.apache.poi.ss.formula.ptg.RefPtg;
/*     */ import org.apache.poi.ss.formula.ptg.StringPtg;
/*     */ import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
/*     */ import org.apache.poi.ss.formula.udf.UDFFinder;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ @Internal
/*     */ public final class WorkbookEvaluator
/*     */ {
/* 100 */   private static final POILogger LOG = POILogFactory.getLogger(WorkbookEvaluator.class);
/*     */   
/*     */   private final EvaluationWorkbook _workbook;
/*     */   
/*     */   private EvaluationCache _cache;
/*     */   
/*     */   private int _workbookIx;
/*     */   
/*     */   private final IEvaluationListener _evaluationListener;
/*     */   
/*     */   private final Map<EvaluationSheet, Integer> _sheetIndexesBySheet;
/*     */   
/*     */   private final Map<String, Integer> _sheetIndexesByName;
/*     */   
/*     */   private CollaboratingWorkbooksEnvironment _collaboratingWorkbookEnvironment;
/*     */   
/*     */   private final IStabilityClassifier _stabilityClassifier;
/*     */   
/*     */   private final AggregatingUDFFinder _udfFinder;
/*     */   
/*     */   private boolean _ignoreMissingWorkbooks = false;
/*     */   private boolean dbgEvaluationOutputForNextEval = false;
/* 122 */   private final POILogger EVAL_LOG = POILogFactory.getLogger("POI.FormulaEval");
/*     */   
/* 124 */   private int dbgEvaluationOutputIndent = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WorkbookEvaluator(EvaluationWorkbook paramEvaluationWorkbook, IStabilityClassifier paramIStabilityClassifier, UDFFinder paramUDFFinder) {
/* 130 */     this(paramEvaluationWorkbook, null, paramIStabilityClassifier, paramUDFFinder);
/*     */   }
/*     */   
/*     */   WorkbookEvaluator(EvaluationWorkbook paramEvaluationWorkbook, IEvaluationListener paramIEvaluationListener, IStabilityClassifier paramIStabilityClassifier, UDFFinder paramUDFFinder) {
/* 134 */     this._workbook = paramEvaluationWorkbook;
/* 135 */     this._evaluationListener = paramIEvaluationListener;
/* 136 */     this._cache = new EvaluationCache(paramIEvaluationListener);
/* 137 */     this._sheetIndexesBySheet = new IdentityHashMap<EvaluationSheet, Integer>();
/* 138 */     this._sheetIndexesByName = new IdentityHashMap<String, Integer>();
/* 139 */     this._collaboratingWorkbookEnvironment = CollaboratingWorkbooksEnvironment.EMPTY;
/* 140 */     this._workbookIx = 0;
/* 141 */     this._stabilityClassifier = paramIStabilityClassifier;
/*     */     
/* 143 */     AggregatingUDFFinder aggregatingUDFFinder = (paramEvaluationWorkbook == null) ? null : (AggregatingUDFFinder)paramEvaluationWorkbook.getUDFFinder();
/*     */     
/* 145 */     if (aggregatingUDFFinder != null && paramUDFFinder != null) {
/* 146 */       aggregatingUDFFinder.add(paramUDFFinder);
/*     */     }
/* 148 */     this._udfFinder = aggregatingUDFFinder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getSheetName(int paramInt) {
/* 155 */     return this._workbook.getSheetName(paramInt);
/*     */   }
/*     */   
/*     */   EvaluationSheet getSheet(int paramInt) {
/* 159 */     return this._workbook.getSheet(paramInt);
/*     */   }
/*     */   
/*     */   EvaluationWorkbook getWorkbook() {
/* 163 */     return this._workbook;
/*     */   }
/*     */   
/*     */   EvaluationName getName(String paramString, int paramInt) {
/* 167 */     return this._workbook.getName(paramString, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isDebugLogEnabled() {
/* 172 */     return LOG.check(1);
/*     */   }
/*     */   private static boolean isInfoLogEnabled() {
/* 175 */     return LOG.check(3);
/*     */   }
/*     */   private static void logDebug(String paramString) {
/* 178 */     if (isDebugLogEnabled())
/* 179 */       LOG.log(1, new Object[] { paramString }); 
/*     */   }
/*     */   
/*     */   private static void logInfo(String paramString) {
/* 183 */     if (isInfoLogEnabled())
/* 184 */       LOG.log(3, new Object[] { paramString }); 
/*     */   }
/*     */   
/*     */   void attachToEnvironment(CollaboratingWorkbooksEnvironment paramCollaboratingWorkbooksEnvironment, EvaluationCache paramEvaluationCache, int paramInt) {
/* 188 */     this._collaboratingWorkbookEnvironment = paramCollaboratingWorkbooksEnvironment;
/* 189 */     this._cache = paramEvaluationCache;
/* 190 */     this._workbookIx = paramInt;
/*     */   }
/*     */   CollaboratingWorkbooksEnvironment getEnvironment() {
/* 193 */     return this._collaboratingWorkbookEnvironment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void detachFromEnvironment() {
/* 201 */     this._collaboratingWorkbookEnvironment = CollaboratingWorkbooksEnvironment.EMPTY;
/* 202 */     this._cache = new EvaluationCache(this._evaluationListener);
/* 203 */     this._workbookIx = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   WorkbookEvaluator getOtherWorkbookEvaluator(String paramString) throws CollaboratingWorkbooksEnvironment.WorkbookNotFoundException {
/* 209 */     return this._collaboratingWorkbookEnvironment.getWorkbookEvaluator(paramString);
/*     */   }
/*     */   
/*     */   IEvaluationListener getEvaluationListener() {
/* 213 */     return this._evaluationListener;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearAllCachedResultValues() {
/* 222 */     this._cache.clear();
/* 223 */     this._sheetIndexesBySheet.clear();
/* 224 */     this._workbook.clearAllCachedResultValues();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyUpdateCell(EvaluationCell paramEvaluationCell) {
/* 232 */     int i = getSheetIndex(paramEvaluationCell.getSheet());
/* 233 */     this._cache.notifyUpdateCell(this._workbookIx, i, paramEvaluationCell);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyDeleteCell(EvaluationCell paramEvaluationCell) {
/* 240 */     int i = getSheetIndex(paramEvaluationCell.getSheet());
/* 241 */     this._cache.notifyDeleteCell(this._workbookIx, i, paramEvaluationCell);
/*     */   }
/*     */   
/*     */   private int getSheetIndex(EvaluationSheet paramEvaluationSheet) {
/* 245 */     Integer integer = this._sheetIndexesBySheet.get(paramEvaluationSheet);
/* 246 */     if (integer == null) {
/* 247 */       int i = this._workbook.getSheetIndex(paramEvaluationSheet);
/* 248 */       if (i < 0) {
/* 249 */         throw new RuntimeException("Specified sheet from a different book");
/*     */       }
/* 251 */       integer = Integer.valueOf(i);
/* 252 */       this._sheetIndexesBySheet.put(paramEvaluationSheet, integer);
/*     */     } 
/* 254 */     return integer.intValue();
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(EvaluationCell paramEvaluationCell) {
/* 258 */     int i = getSheetIndex(paramEvaluationCell.getSheet());
/* 259 */     return evaluateAny(paramEvaluationCell, i, paramEvaluationCell.getRowIndex(), paramEvaluationCell.getColumnIndex(), new EvaluationTracker(this._cache));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getSheetIndex(String paramString) {
/* 267 */     Integer integer = this._sheetIndexesByName.get(paramString);
/* 268 */     if (integer == null) {
/* 269 */       int i = this._workbook.getSheetIndex(paramString);
/* 270 */       if (i < 0) {
/* 271 */         return -1;
/*     */       }
/* 273 */       integer = Integer.valueOf(i);
/* 274 */       this._sheetIndexesByName.put(paramString, integer);
/*     */     } 
/* 276 */     return integer.intValue();
/*     */   }
/*     */   
/*     */   int getSheetIndexByExternIndex(int paramInt) {
/* 280 */     return this._workbook.convertFromExternSheetIndex(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ValueEval evaluateAny(EvaluationCell paramEvaluationCell, int paramInt1, int paramInt2, int paramInt3, EvaluationTracker paramEvaluationTracker) {
/*     */     ErrorEval errorEval;
/* 291 */     boolean bool = (this._stabilityClassifier == null) ? true : (!this._stabilityClassifier.isCellFinal(paramInt1, paramInt2, paramInt3) ? true : false);
/*     */     
/* 293 */     if (paramEvaluationCell == null || paramEvaluationCell.getCellTypeEnum() != CellType.FORMULA) {
/* 294 */       ValueEval valueEval = getValueFromNonFormulaCell(paramEvaluationCell);
/* 295 */       if (bool) {
/* 296 */         paramEvaluationTracker.acceptPlainValueDependency(this._workbookIx, paramInt1, paramInt2, paramInt3, valueEval);
/*     */       }
/* 298 */       return valueEval;
/*     */     } 
/*     */     
/* 301 */     FormulaCellCacheEntry formulaCellCacheEntry = this._cache.getOrCreateFormulaCellEntry(paramEvaluationCell);
/* 302 */     if (bool || formulaCellCacheEntry.isInputSensitive()) {
/* 303 */       paramEvaluationTracker.acceptFormulaDependency(formulaCellCacheEntry);
/*     */     }
/* 305 */     IEvaluationListener iEvaluationListener = this._evaluationListener;
/*     */     
/* 307 */     if (formulaCellCacheEntry.getValue() == null) {
/* 308 */       if (!paramEvaluationTracker.startEvaluate(formulaCellCacheEntry)) {
/* 309 */         return (ValueEval)ErrorEval.CIRCULAR_REF_ERROR;
/*     */       }
/* 311 */       OperationEvaluationContext operationEvaluationContext = new OperationEvaluationContext(this, this._workbook, paramInt1, paramInt2, paramInt3, paramEvaluationTracker);
/*     */       
/*     */       try {
/*     */         ValueEval valueEval;
/* 315 */         Ptg[] arrayOfPtg = this._workbook.getFormulaTokens(paramEvaluationCell);
/* 316 */         if (iEvaluationListener == null) {
/* 317 */           valueEval = evaluateFormula(operationEvaluationContext, arrayOfPtg);
/*     */         } else {
/* 319 */           iEvaluationListener.onStartEvaluate(paramEvaluationCell, formulaCellCacheEntry);
/* 320 */           valueEval = evaluateFormula(operationEvaluationContext, arrayOfPtg);
/* 321 */           iEvaluationListener.onEndEvaluate(formulaCellCacheEntry, valueEval);
/*     */         } 
/*     */         
/* 324 */         paramEvaluationTracker.updateCacheResult(valueEval);
/*     */       }
/* 326 */       catch (NotImplementedException notImplementedException) {
/* 327 */         throw addExceptionInfo(notImplementedException, paramInt1, paramInt2, paramInt3);
/* 328 */       } catch (RuntimeException runtimeException) {
/* 329 */         if (runtimeException.getCause() instanceof CollaboratingWorkbooksEnvironment.WorkbookNotFoundException && this._ignoreMissingWorkbooks) {
/* 330 */           NumberEval numberEval; StringEval stringEval; BlankEval blankEval; BoolEval boolEval; logInfo(runtimeException.getCause().getMessage() + " - Continuing with cached value!");
/* 331 */           switch (paramEvaluationCell.getCachedFormulaResultTypeEnum()) {
/*     */             case NUMERIC:
/* 333 */               numberEval = new NumberEval(paramEvaluationCell.getNumericCellValue());
/*     */               break;
/*     */             case STRING:
/* 336 */               stringEval = new StringEval(paramEvaluationCell.getStringCellValue());
/*     */               break;
/*     */             case BLANK:
/* 339 */               blankEval = BlankEval.instance;
/*     */               break;
/*     */             case BOOLEAN:
/* 342 */               boolEval = BoolEval.valueOf(paramEvaluationCell.getBooleanCellValue());
/*     */               break;
/*     */             case ERROR:
/* 345 */               errorEval = ErrorEval.valueOf(paramEvaluationCell.getErrorCellValue());
/*     */               break;
/*     */             
/*     */             default:
/* 349 */               throw new RuntimeException("Unexpected cell type '" + paramEvaluationCell.getCellTypeEnum() + "' found!");
/*     */           } 
/*     */         } else {
/* 352 */           throw runtimeException;
/*     */         } 
/*     */       } finally {
/* 355 */         paramEvaluationTracker.endEvaluate(formulaCellCacheEntry);
/*     */       } 
/*     */     } else {
/* 358 */       if (iEvaluationListener != null) {
/* 359 */         iEvaluationListener.onCacheHit(paramInt1, paramInt2, paramInt3, formulaCellCacheEntry.getValue());
/*     */       }
/* 361 */       return formulaCellCacheEntry.getValue();
/*     */     } 
/* 363 */     if (isDebugLogEnabled()) {
/* 364 */       String str = getSheetName(paramInt1);
/* 365 */       CellReference cellReference = new CellReference(paramInt2, paramInt3);
/* 366 */       logDebug("Evaluated " + str + "!" + cellReference.formatAsString() + " to " + errorEval.toString());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 372 */     return (ValueEval)errorEval;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private NotImplementedException addExceptionInfo(NotImplementedException paramNotImplementedException, int paramInt1, int paramInt2, int paramInt3) {
/*     */     try {
/* 383 */       String str1 = this._workbook.getSheetName(paramInt1);
/* 384 */       CellReference cellReference = new CellReference(str1, paramInt2, paramInt3, false, false);
/* 385 */       String str2 = "Error evaluating cell " + cellReference.formatAsString();
/* 386 */       return new NotImplementedException(str2, paramNotImplementedException);
/* 387 */     } catch (Exception exception) {
/*     */       
/* 389 */       LOG.log(7, new Object[] { "Can't add exception info", exception });
/* 390 */       return paramNotImplementedException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static ValueEval getValueFromNonFormulaCell(EvaluationCell paramEvaluationCell) {
/* 399 */     if (paramEvaluationCell == null) {
/* 400 */       return (ValueEval)BlankEval.instance;
/*     */     }
/* 402 */     CellType cellType = paramEvaluationCell.getCellTypeEnum();
/* 403 */     switch (cellType) {
/*     */       case NUMERIC:
/* 405 */         return (ValueEval)new NumberEval(paramEvaluationCell.getNumericCellValue());
/*     */       case STRING:
/* 407 */         return (ValueEval)new StringEval(paramEvaluationCell.getStringCellValue());
/*     */       case BOOLEAN:
/* 409 */         return (ValueEval)BoolEval.valueOf(paramEvaluationCell.getBooleanCellValue());
/*     */       case BLANK:
/* 411 */         return (ValueEval)BlankEval.instance;
/*     */       case ERROR:
/* 413 */         return (ValueEval)ErrorEval.valueOf(paramEvaluationCell.getErrorCellValue());
/*     */     } 
/* 415 */     throw new RuntimeException("Unexpected cell type (" + cellType + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   ValueEval evaluateFormula(OperationEvaluationContext paramOperationEvaluationContext, Ptg[] paramArrayOfPtg) {
/* 425 */     String str = "";
/* 426 */     if (this.dbgEvaluationOutputForNextEval) {
/*     */       
/* 428 */       this.dbgEvaluationOutputIndent = 1;
/* 429 */       this.dbgEvaluationOutputForNextEval = false;
/*     */     } 
/* 431 */     if (this.dbgEvaluationOutputIndent > 0) {
/*     */ 
/*     */       
/* 434 */       str = "                                                                                                    ";
/* 435 */       str = str.substring(0, Math.min(str.length(), this.dbgEvaluationOutputIndent * 2));
/* 436 */       this.EVAL_LOG.log(5, new Object[] { str + "- evaluateFormula('" + paramOperationEvaluationContext.getRefEvaluatorForCurrentSheet().getSheetNameRange() + "'/" + (new CellReference(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex())).formatAsString() + "): " + Arrays.toString((Object[])paramArrayOfPtg).replaceAll("\\Qorg.apache.poi.ss.formula.ptg.\\E", "") });
/*     */ 
/*     */ 
/*     */       
/* 440 */       this.dbgEvaluationOutputIndent++;
/*     */     } 
/*     */     
/* 443 */     Stack<ValueEval> stack = new Stack();
/* 444 */     for (int i = 0, j = paramArrayOfPtg.length; i < j; i++) {
/*     */       OperationPtg operationPtg;
/*     */       ValueEval valueEval;
/* 447 */       Ptg ptg = paramArrayOfPtg[i];
/* 448 */       if (this.dbgEvaluationOutputIndent > 0) {
/* 449 */         this.EVAL_LOG.log(3, new Object[] { str + "  * ptg " + i + ": " + ptg });
/*     */       }
/* 451 */       if (ptg instanceof AttrPtg) {
/* 452 */         AttrPtg attrPtg = (AttrPtg)ptg;
/* 453 */         if (attrPtg.isSum())
/*     */         {
/*     */           
/* 456 */           operationPtg = FuncVarPtg.SUM;
/*     */         }
/* 458 */         if (attrPtg.isOptimizedChoose()) {
/* 459 */           int k; ValueEval valueEval3 = stack.pop();
/* 460 */           int[] arrayOfInt = attrPtg.getJumpTable();
/*     */           
/* 462 */           int m = arrayOfInt.length;
/*     */           try {
/* 464 */             int n = Choose.evaluateFirstArg(valueEval3, paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex());
/* 465 */             if (n < 1 || n > m) {
/* 466 */               stack.push(ErrorEval.VALUE_INVALID);
/* 467 */               k = attrPtg.getChooseFuncOffset() + 4;
/*     */             } else {
/* 469 */               k = arrayOfInt[n - 1];
/*     */             } 
/* 471 */           } catch (EvaluationException evaluationException) {
/* 472 */             stack.push(evaluationException.getErrorEval());
/* 473 */             k = attrPtg.getChooseFuncOffset() + 4;
/*     */           } 
/*     */ 
/*     */           
/* 477 */           k -= m * 2 + 2;
/* 478 */           i += countTokensToBeSkipped(paramArrayOfPtg, i, k);
/*     */           continue;
/*     */         } 
/* 481 */         if (attrPtg.isOptimizedIf()) {
/* 482 */           boolean bool; ValueEval valueEval3 = stack.pop();
/*     */           
/*     */           try {
/* 485 */             bool = IfFunc.evaluateFirstArg(valueEval3, paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex());
/* 486 */           } catch (EvaluationException evaluationException) {
/* 487 */             stack.push(evaluationException.getErrorEval());
/* 488 */             short s = attrPtg.getData();
/* 489 */             i += countTokensToBeSkipped(paramArrayOfPtg, i, s);
/* 490 */             attrPtg = (AttrPtg)paramArrayOfPtg[i];
/* 491 */             int k = attrPtg.getData() + 1;
/* 492 */             i += countTokensToBeSkipped(paramArrayOfPtg, i, k);
/*     */           } 
/*     */           
/* 495 */           if (!bool) {
/*     */ 
/*     */             
/* 498 */             short s = attrPtg.getData();
/* 499 */             i += countTokensToBeSkipped(paramArrayOfPtg, i, s);
/* 500 */             Ptg ptg1 = paramArrayOfPtg[i + 1];
/* 501 */             if (paramArrayOfPtg[i] instanceof AttrPtg && ptg1 instanceof FuncVarPtg && ((FuncVarPtg)ptg1).getFunctionIndex() == 1) {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 506 */               i++;
/* 507 */               stack.push(BoolEval.FALSE);
/*     */             } 
/*     */           } 
/*     */           continue;
/*     */         } 
/* 512 */         if (attrPtg.isSkip()) {
/* 513 */           int k = attrPtg.getData() + 1;
/* 514 */           i += countTokensToBeSkipped(paramArrayOfPtg, i, k);
/* 515 */           if (stack.peek() == MissingArgEval.instance) {
/* 516 */             stack.pop();
/* 517 */             stack.push(BlankEval.instance);
/*     */           } 
/*     */           continue;
/*     */         } 
/*     */       } 
/* 522 */       if (operationPtg instanceof org.apache.poi.ss.formula.ptg.ControlPtg) {
/*     */         continue;
/*     */       }
/*     */       
/* 526 */       if (operationPtg instanceof org.apache.poi.ss.formula.ptg.MemFuncPtg || operationPtg instanceof org.apache.poi.ss.formula.ptg.MemAreaPtg) {
/*     */         continue;
/*     */       }
/*     */       
/* 530 */       if (operationPtg instanceof org.apache.poi.ss.formula.ptg.MemErrPtg) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 535 */       if (operationPtg instanceof OperationPtg) {
/* 536 */         OperationPtg operationPtg1 = operationPtg;
/*     */         
/* 538 */         if (operationPtg1 instanceof org.apache.poi.ss.formula.ptg.UnionPtg) {
/*     */           continue;
/*     */         }
/* 541 */         int k = operationPtg1.getNumberOfOperands();
/* 542 */         ValueEval[] arrayOfValueEval = new ValueEval[k];
/*     */ 
/*     */         
/* 545 */         for (int m = k - 1; m >= 0; m--) {
/* 546 */           ValueEval valueEval3 = stack.pop();
/* 547 */           arrayOfValueEval[m] = valueEval3;
/*     */         } 
/*     */         
/* 550 */         valueEval = OperationEvaluatorFactory.evaluate(operationPtg1, arrayOfValueEval, paramOperationEvaluationContext);
/*     */       } else {
/* 552 */         valueEval = getEvalForPtg((Ptg)operationPtg, paramOperationEvaluationContext);
/*     */       } 
/* 554 */       if (valueEval == null) {
/* 555 */         throw new RuntimeException("Evaluation result must not be null");
/*     */       }
/*     */       
/* 558 */       stack.push(valueEval);
/* 559 */       if (this.dbgEvaluationOutputIndent > 0) {
/* 560 */         this.EVAL_LOG.log(3, new Object[] { str + "    = " + valueEval });
/*     */       }
/*     */       continue;
/*     */     } 
/* 564 */     ValueEval valueEval1 = stack.pop();
/* 565 */     if (!stack.isEmpty()) {
/* 566 */       throw new IllegalStateException("evaluation stack not empty");
/*     */     }
/* 568 */     ValueEval valueEval2 = dereferenceResult(valueEval1, paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex());
/* 569 */     if (this.dbgEvaluationOutputIndent > 0) {
/* 570 */       this.EVAL_LOG.log(3, new Object[] { str + "finshed eval of " + (new CellReference(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex())).formatAsString() + ": " + valueEval2 });
/*     */ 
/*     */       
/* 573 */       this.dbgEvaluationOutputIndent--;
/* 574 */       if (this.dbgEvaluationOutputIndent == 1)
/*     */       {
/* 576 */         this.dbgEvaluationOutputIndent = -1;
/*     */       }
/*     */     } 
/* 579 */     return valueEval2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countTokensToBeSkipped(Ptg[] paramArrayOfPtg, int paramInt1, int paramInt2) {
/* 590 */     int i = paramInt2;
/* 591 */     int j = paramInt1;
/* 592 */     while (i != 0) {
/* 593 */       j++;
/* 594 */       i -= paramArrayOfPtg[j].getSize();
/* 595 */       if (i < 0) {
/* 596 */         throw new RuntimeException("Bad skip distance (wrong token size calculation).");
/*     */       }
/* 598 */       if (j >= paramArrayOfPtg.length) {
/* 599 */         throw new RuntimeException("Skip distance too far (ran out of formula tokens).");
/*     */       }
/*     */     } 
/* 602 */     return j - paramInt1;
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
/*     */   public static ValueEval dereferenceResult(ValueEval paramValueEval, int paramInt1, int paramInt2) {
/*     */     ValueEval valueEval;
/*     */     try {
/* 617 */       valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 618 */     } catch (EvaluationException evaluationException) {
/* 619 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/* 621 */     if (valueEval == BlankEval.instance)
/*     */     {
/* 623 */       return (ValueEval)NumberEval.ZERO;
/*     */     }
/*     */ 
/*     */     
/* 627 */     return valueEval;
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
/*     */   private ValueEval getEvalForPtg(Ptg paramPtg, OperationEvaluationContext paramOperationEvaluationContext) {
/* 640 */     if (paramPtg instanceof NamePtg) {
/*     */       
/* 642 */       NamePtg namePtg = (NamePtg)paramPtg;
/* 643 */       EvaluationName evaluationName = this._workbook.getName(namePtg);
/* 644 */       return getEvalForNameRecord(evaluationName, paramOperationEvaluationContext);
/*     */     } 
/* 646 */     if (paramPtg instanceof NameXPtg)
/*     */     {
/* 648 */       return processNameEval(paramOperationEvaluationContext.getNameXEval((NameXPtg)paramPtg), paramOperationEvaluationContext);
/*     */     }
/* 650 */     if (paramPtg instanceof NameXPxg)
/*     */     {
/* 652 */       return processNameEval(paramOperationEvaluationContext.getNameXEval((NameXPxg)paramPtg), paramOperationEvaluationContext);
/*     */     }
/*     */     
/* 655 */     if (paramPtg instanceof IntPtg) {
/* 656 */       return (ValueEval)new NumberEval(((IntPtg)paramPtg).getValue());
/*     */     }
/* 658 */     if (paramPtg instanceof NumberPtg) {
/* 659 */       return (ValueEval)new NumberEval(((NumberPtg)paramPtg).getValue());
/*     */     }
/* 661 */     if (paramPtg instanceof StringPtg) {
/* 662 */       return (ValueEval)new StringEval(((StringPtg)paramPtg).getValue());
/*     */     }
/* 664 */     if (paramPtg instanceof BoolPtg) {
/* 665 */       return (ValueEval)BoolEval.valueOf(((BoolPtg)paramPtg).getValue());
/*     */     }
/* 667 */     if (paramPtg instanceof ErrPtg) {
/* 668 */       return (ValueEval)ErrorEval.valueOf(((ErrPtg)paramPtg).getErrorCode());
/*     */     }
/* 670 */     if (paramPtg instanceof org.apache.poi.ss.formula.ptg.MissingArgPtg) {
/* 671 */       return (ValueEval)MissingArgEval.instance;
/*     */     }
/* 673 */     if (paramPtg instanceof org.apache.poi.ss.formula.ptg.AreaErrPtg || paramPtg instanceof org.apache.poi.ss.formula.ptg.RefErrorPtg || paramPtg instanceof org.apache.poi.ss.formula.ptg.DeletedArea3DPtg || paramPtg instanceof org.apache.poi.ss.formula.ptg.DeletedRef3DPtg)
/*     */     {
/* 675 */       return (ValueEval)ErrorEval.REF_INVALID;
/*     */     }
/* 677 */     if (paramPtg instanceof Ref3DPtg) {
/* 678 */       return paramOperationEvaluationContext.getRef3DEval((Ref3DPtg)paramPtg);
/*     */     }
/* 680 */     if (paramPtg instanceof Ref3DPxg) {
/* 681 */       return paramOperationEvaluationContext.getRef3DEval((Ref3DPxg)paramPtg);
/*     */     }
/* 683 */     if (paramPtg instanceof Area3DPtg) {
/* 684 */       return paramOperationEvaluationContext.getArea3DEval((Area3DPtg)paramPtg);
/*     */     }
/* 686 */     if (paramPtg instanceof Area3DPxg) {
/* 687 */       return paramOperationEvaluationContext.getArea3DEval((Area3DPxg)paramPtg);
/*     */     }
/* 689 */     if (paramPtg instanceof RefPtg) {
/* 690 */       RefPtg refPtg = (RefPtg)paramPtg;
/* 691 */       return paramOperationEvaluationContext.getRefEval(refPtg.getRow(), refPtg.getColumn());
/*     */     } 
/* 693 */     if (paramPtg instanceof AreaPtg) {
/* 694 */       AreaPtg areaPtg = (AreaPtg)paramPtg;
/* 695 */       return paramOperationEvaluationContext.getAreaEval(areaPtg.getFirstRow(), areaPtg.getFirstColumn(), areaPtg.getLastRow(), areaPtg.getLastColumn());
/*     */     } 
/*     */     
/* 698 */     if (paramPtg instanceof org.apache.poi.ss.formula.ptg.UnknownPtg)
/*     */     {
/*     */ 
/*     */       
/* 702 */       throw new RuntimeException("UnknownPtg not allowed");
/*     */     }
/* 704 */     if (paramPtg instanceof org.apache.poi.ss.formula.ptg.ExpPtg)
/*     */     {
/*     */       
/* 707 */       throw new RuntimeException("ExpPtg currently not supported");
/*     */     }
/*     */     
/* 710 */     throw new RuntimeException("Unexpected ptg class (" + paramPtg.getClass().getName() + ")");
/*     */   }
/*     */   
/*     */   private ValueEval processNameEval(ValueEval paramValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 714 */     if (paramValueEval instanceof ExternalNameEval) {
/* 715 */       EvaluationName evaluationName = ((ExternalNameEval)paramValueEval).getName();
/* 716 */       return getEvalForNameRecord(evaluationName, paramOperationEvaluationContext);
/*     */     } 
/* 718 */     return paramValueEval;
/*     */   }
/*     */   
/*     */   private ValueEval getEvalForNameRecord(EvaluationName paramEvaluationName, OperationEvaluationContext paramOperationEvaluationContext) {
/* 722 */     if (paramEvaluationName.isFunctionName()) {
/* 723 */       return (ValueEval)new FunctionNameEval(paramEvaluationName.getNameText());
/*     */     }
/* 725 */     if (paramEvaluationName.hasFormula()) {
/* 726 */       return evaluateNameFormula(paramEvaluationName.getNameDefinition(), paramOperationEvaluationContext);
/*     */     }
/*     */     
/* 729 */     throw new RuntimeException("Don't now how to evalate name '" + paramEvaluationName.getNameText() + "'");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ValueEval evaluateNameFormula(Ptg[] paramArrayOfPtg, OperationEvaluationContext paramOperationEvaluationContext) {
/* 736 */     if (paramArrayOfPtg.length == 1) {
/* 737 */       return getEvalForPtg(paramArrayOfPtg[0], paramOperationEvaluationContext);
/*     */     }
/* 739 */     return evaluateFormula(paramOperationEvaluationContext, paramArrayOfPtg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ValueEval evaluateReference(EvaluationSheet paramEvaluationSheet, int paramInt1, int paramInt2, int paramInt3, EvaluationTracker paramEvaluationTracker) {
/* 749 */     EvaluationCell evaluationCell = paramEvaluationSheet.getCell(paramInt2, paramInt3);
/* 750 */     return evaluateAny(evaluationCell, paramInt1, paramInt2, paramInt3, paramEvaluationTracker);
/*     */   }
/*     */   public FreeRefFunction findUserDefinedFunction(String paramString) {
/* 753 */     return this._udfFinder.findFunction(paramString);
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
/*     */   public void setIgnoreMissingWorkbooks(boolean paramBoolean) {
/* 773 */     this._ignoreMissingWorkbooks = paramBoolean;
/*     */   }
/*     */   public boolean isIgnoreMissingWorkbooks() {
/* 776 */     return this._ignoreMissingWorkbooks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Collection<String> getSupportedFunctionNames() {
/* 785 */     TreeSet<? extends String> treeSet = new TreeSet();
/* 786 */     treeSet.addAll(FunctionEval.getSupportedFunctionNames());
/* 787 */     treeSet.addAll(AnalysisToolPak.getSupportedFunctionNames());
/* 788 */     return Collections.unmodifiableCollection(treeSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Collection<String> getNotSupportedFunctionNames() {
/* 797 */     TreeSet<? extends String> treeSet = new TreeSet();
/* 798 */     treeSet.addAll(FunctionEval.getNotSupportedFunctionNames());
/* 799 */     treeSet.addAll(AnalysisToolPak.getNotSupportedFunctionNames());
/* 800 */     return Collections.unmodifiableCollection(treeSet);
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
/*     */   public static void registerFunction(String paramString, FreeRefFunction paramFreeRefFunction) {
/* 812 */     AnalysisToolPak.registerFunction(paramString, paramFreeRefFunction);
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
/*     */   public static void registerFunction(String paramString, Function paramFunction) {
/* 824 */     FunctionEval.registerFunction(paramString, paramFunction);
/*     */   }
/*     */   
/*     */   public void setDebugEvaluationOutputForNextEval(boolean paramBoolean) {
/* 828 */     this.dbgEvaluationOutputForNextEval = paramBoolean;
/*     */   }
/*     */   public boolean isDebugEvaluationOutputForNextEval() {
/* 831 */     return this.dbgEvaluationOutputForNextEval;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\WorkbookEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */