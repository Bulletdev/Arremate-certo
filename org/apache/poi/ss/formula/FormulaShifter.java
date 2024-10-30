/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.formula.ptg.Area3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Area3DPxg;
/*     */ import org.apache.poi.ss.formula.ptg.AreaErrPtg;
/*     */ import org.apache.poi.ss.formula.ptg.AreaPtgBase;
/*     */ import org.apache.poi.ss.formula.ptg.Deleted3DPxg;
/*     */ import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.ptg.Ref3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ref3DPxg;
/*     */ import org.apache.poi.ss.formula.ptg.RefErrorPtg;
/*     */ import org.apache.poi.ss.formula.ptg.RefPtg;
/*     */ import org.apache.poi.ss.formula.ptg.RefPtgBase;
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
/*     */ public final class FormulaShifter
/*     */ {
/*     */   private final int _externSheetIndex;
/*     */   private final String _sheetName;
/*     */   private final int _firstMovedIndex;
/*     */   private final int _lastMovedIndex;
/*     */   private final int _amountToMove;
/*     */   private final int _srcSheetIndex;
/*     */   private final int _dstSheetIndex;
/*     */   private final SpreadsheetVersion _version;
/*     */   private final ShiftMode _mode;
/*     */   
/*     */   private enum ShiftMode
/*     */   {
/*  44 */     RowMove,
/*  45 */     RowCopy,
/*  46 */     SheetMove;
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
/*     */   private FormulaShifter(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, ShiftMode paramShiftMode, SpreadsheetVersion paramSpreadsheetVersion) {
/*  77 */     if (paramInt4 == 0) {
/*  78 */       throw new IllegalArgumentException("amountToMove must not be zero");
/*     */     }
/*  80 */     if (paramInt2 > paramInt3) {
/*  81 */       throw new IllegalArgumentException("firstMovedIndex, lastMovedIndex out of order");
/*     */     }
/*  83 */     this._externSheetIndex = paramInt1;
/*  84 */     this._sheetName = paramString;
/*  85 */     this._firstMovedIndex = paramInt2;
/*  86 */     this._lastMovedIndex = paramInt3;
/*  87 */     this._amountToMove = paramInt4;
/*  88 */     this._mode = paramShiftMode;
/*  89 */     this._version = paramSpreadsheetVersion;
/*     */     
/*  91 */     this._srcSheetIndex = this._dstSheetIndex = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FormulaShifter(int paramInt1, int paramInt2) {
/* 100 */     this._externSheetIndex = this._firstMovedIndex = this._lastMovedIndex = this._amountToMove = -1;
/* 101 */     this._sheetName = null;
/* 102 */     this._version = null;
/*     */     
/* 104 */     this._srcSheetIndex = paramInt1;
/* 105 */     this._dstSheetIndex = paramInt2;
/* 106 */     this._mode = ShiftMode.SheetMove;
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
/*     */   @Deprecated
/*     */   public static FormulaShifter createForRowShift(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4) {
/* 121 */     return createForRowShift(paramInt1, paramString, paramInt2, paramInt3, paramInt4, SpreadsheetVersion.EXCEL97);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FormulaShifter createForRowShift(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, SpreadsheetVersion paramSpreadsheetVersion) {
/* 126 */     return new FormulaShifter(paramInt1, paramString, paramInt2, paramInt3, paramInt4, ShiftMode.RowMove, paramSpreadsheetVersion);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FormulaShifter createForRowCopy(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, SpreadsheetVersion paramSpreadsheetVersion) {
/* 131 */     return new FormulaShifter(paramInt1, paramString, paramInt2, paramInt3, paramInt4, ShiftMode.RowCopy, paramSpreadsheetVersion);
/*     */   }
/*     */   
/*     */   public static FormulaShifter createForSheetShift(int paramInt1, int paramInt2) {
/* 135 */     return new FormulaShifter(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 140 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 142 */     stringBuffer.append(getClass().getName());
/* 143 */     stringBuffer.append(" [");
/* 144 */     stringBuffer.append(this._firstMovedIndex);
/* 145 */     stringBuffer.append(this._lastMovedIndex);
/* 146 */     stringBuffer.append(this._amountToMove);
/* 147 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean adjustFormula(Ptg[] paramArrayOfPtg, int paramInt) {
/* 156 */     boolean bool = false;
/* 157 */     for (byte b = 0; b < paramArrayOfPtg.length; b++) {
/* 158 */       Ptg ptg = adjustPtg(paramArrayOfPtg[b], paramInt);
/* 159 */       if (ptg != null) {
/* 160 */         bool = true;
/* 161 */         paramArrayOfPtg[b] = ptg;
/*     */       } 
/*     */     } 
/* 164 */     return bool;
/*     */   }
/*     */   
/*     */   private Ptg adjustPtg(Ptg paramPtg, int paramInt) {
/* 168 */     switch (this._mode) {
/*     */       case RowMove:
/* 170 */         return adjustPtgDueToRowMove(paramPtg, paramInt);
/*     */ 
/*     */ 
/*     */       
/*     */       case RowCopy:
/* 175 */         return adjustPtgDueToRowCopy(paramPtg);
/*     */       case SheetMove:
/* 177 */         return adjustPtgDueToSheetMove(paramPtg);
/*     */     } 
/* 179 */     throw new IllegalStateException("Unsupported shift mode: " + this._mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Ptg adjustPtgDueToRowMove(Ptg paramPtg, int paramInt) {
/* 188 */     if (paramPtg instanceof RefPtg) {
/* 189 */       if (paramInt != this._externSheetIndex)
/*     */       {
/* 191 */         return null;
/*     */       }
/* 193 */       RefPtg refPtg = (RefPtg)paramPtg;
/* 194 */       return rowMoveRefPtg((RefPtgBase)refPtg);
/*     */     } 
/* 196 */     if (paramPtg instanceof Ref3DPtg) {
/* 197 */       Ref3DPtg ref3DPtg = (Ref3DPtg)paramPtg;
/* 198 */       if (this._externSheetIndex != ref3DPtg.getExternSheetIndex())
/*     */       {
/*     */         
/* 201 */         return null;
/*     */       }
/* 203 */       return rowMoveRefPtg((RefPtgBase)ref3DPtg);
/*     */     } 
/* 205 */     if (paramPtg instanceof Ref3DPxg) {
/* 206 */       Ref3DPxg ref3DPxg = (Ref3DPxg)paramPtg;
/* 207 */       if (ref3DPxg.getExternalWorkbookNumber() > 0 || !this._sheetName.equals(ref3DPxg.getSheetName()))
/*     */       {
/*     */         
/* 210 */         return null;
/*     */       }
/* 212 */       return rowMoveRefPtg((RefPtgBase)ref3DPxg);
/*     */     } 
/* 214 */     if (paramPtg instanceof org.apache.poi.ss.formula.ptg.Area2DPtgBase) {
/* 215 */       if (paramInt != this._externSheetIndex)
/*     */       {
/* 217 */         return paramPtg;
/*     */       }
/* 219 */       return rowMoveAreaPtg((AreaPtgBase)paramPtg);
/*     */     } 
/* 221 */     if (paramPtg instanceof Area3DPtg) {
/* 222 */       Area3DPtg area3DPtg = (Area3DPtg)paramPtg;
/* 223 */       if (this._externSheetIndex != area3DPtg.getExternSheetIndex())
/*     */       {
/*     */         
/* 226 */         return null;
/*     */       }
/* 228 */       return rowMoveAreaPtg((AreaPtgBase)area3DPtg);
/*     */     } 
/* 230 */     if (paramPtg instanceof Area3DPxg) {
/* 231 */       Area3DPxg area3DPxg = (Area3DPxg)paramPtg;
/* 232 */       if (area3DPxg.getExternalWorkbookNumber() > 0 || !this._sheetName.equals(area3DPxg.getSheetName()))
/*     */       {
/*     */         
/* 235 */         return null;
/*     */       }
/* 237 */       return rowMoveAreaPtg((AreaPtgBase)area3DPxg);
/*     */     } 
/* 239 */     return null;
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
/*     */   private Ptg adjustPtgDueToRowCopy(Ptg paramPtg) {
/* 258 */     if (paramPtg instanceof RefPtg) {
/* 259 */       RefPtg refPtg = (RefPtg)paramPtg;
/* 260 */       return rowCopyRefPtg((RefPtgBase)refPtg);
/*     */     } 
/* 262 */     if (paramPtg instanceof Ref3DPtg) {
/* 263 */       Ref3DPtg ref3DPtg = (Ref3DPtg)paramPtg;
/* 264 */       return rowCopyRefPtg((RefPtgBase)ref3DPtg);
/*     */     } 
/* 266 */     if (paramPtg instanceof Ref3DPxg) {
/* 267 */       Ref3DPxg ref3DPxg = (Ref3DPxg)paramPtg;
/* 268 */       return rowCopyRefPtg((RefPtgBase)ref3DPxg);
/*     */     } 
/* 270 */     if (paramPtg instanceof org.apache.poi.ss.formula.ptg.Area2DPtgBase) {
/* 271 */       return rowCopyAreaPtg((AreaPtgBase)paramPtg);
/*     */     }
/* 273 */     if (paramPtg instanceof Area3DPtg) {
/* 274 */       Area3DPtg area3DPtg = (Area3DPtg)paramPtg;
/* 275 */       return rowCopyAreaPtg((AreaPtgBase)area3DPtg);
/*     */     } 
/* 277 */     if (paramPtg instanceof Area3DPxg) {
/* 278 */       Area3DPxg area3DPxg = (Area3DPxg)paramPtg;
/* 279 */       return rowCopyAreaPtg((AreaPtgBase)area3DPxg);
/*     */     } 
/* 281 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private Ptg adjustPtgDueToSheetMove(Ptg paramPtg) {
/* 286 */     if (paramPtg instanceof Ref3DPtg) {
/* 287 */       Ref3DPtg ref3DPtg = (Ref3DPtg)paramPtg;
/* 288 */       int i = ref3DPtg.getExternSheetIndex();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 293 */       if (i < this._srcSheetIndex && i < this._dstSheetIndex)
/*     */       {
/* 295 */         return null;
/*     */       }
/* 297 */       if (i > this._srcSheetIndex && i > this._dstSheetIndex)
/*     */       {
/* 299 */         return null;
/*     */       }
/*     */ 
/*     */       
/* 303 */       if (i == this._srcSheetIndex) {
/* 304 */         ref3DPtg.setExternSheetIndex(this._dstSheetIndex);
/* 305 */         return (Ptg)ref3DPtg;
/*     */       } 
/*     */ 
/*     */       
/* 309 */       if (this._dstSheetIndex < this._srcSheetIndex) {
/* 310 */         ref3DPtg.setExternSheetIndex(i + 1);
/* 311 */         return (Ptg)ref3DPtg;
/*     */       } 
/*     */ 
/*     */       
/* 315 */       if (this._dstSheetIndex > this._srcSheetIndex) {
/* 316 */         ref3DPtg.setExternSheetIndex(i - 1);
/* 317 */         return (Ptg)ref3DPtg;
/*     */       } 
/*     */     } 
/*     */     
/* 321 */     return null;
/*     */   }
/*     */   
/*     */   private Ptg rowMoveRefPtg(RefPtgBase paramRefPtgBase) {
/* 325 */     int i = paramRefPtgBase.getRow();
/* 326 */     if (this._firstMovedIndex <= i && i <= this._lastMovedIndex) {
/*     */ 
/*     */       
/* 329 */       paramRefPtgBase.setRow(i + this._amountToMove);
/* 330 */       return (Ptg)paramRefPtgBase;
/*     */     } 
/*     */ 
/*     */     
/* 334 */     int j = this._firstMovedIndex + this._amountToMove;
/* 335 */     int k = this._lastMovedIndex + this._amountToMove;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 340 */     if (k < i || i < j)
/*     */     {
/* 342 */       return null;
/*     */     }
/*     */     
/* 345 */     if (j <= i && i <= k)
/*     */     {
/* 347 */       return createDeletedRef((Ptg)paramRefPtgBase);
/*     */     }
/* 349 */     throw new IllegalStateException("Situation not covered: (" + this._firstMovedIndex + ", " + this._lastMovedIndex + ", " + this._amountToMove + ", " + i + ", " + i + ")");
/*     */   }
/*     */ 
/*     */   
/*     */   private Ptg rowMoveAreaPtg(AreaPtgBase paramAreaPtgBase) {
/* 354 */     int i = paramAreaPtgBase.getFirstRow();
/* 355 */     int j = paramAreaPtgBase.getLastRow();
/* 356 */     if (this._firstMovedIndex <= i && j <= this._lastMovedIndex) {
/*     */ 
/*     */       
/* 359 */       paramAreaPtgBase.setFirstRow(i + this._amountToMove);
/* 360 */       paramAreaPtgBase.setLastRow(j + this._amountToMove);
/* 361 */       return (Ptg)paramAreaPtgBase;
/*     */     } 
/*     */ 
/*     */     
/* 365 */     int k = this._firstMovedIndex + this._amountToMove;
/* 366 */     int m = this._lastMovedIndex + this._amountToMove;
/*     */     
/* 368 */     if (i < this._firstMovedIndex && this._lastMovedIndex < j) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 373 */       if (k < i && i <= m) {
/*     */         
/* 375 */         paramAreaPtgBase.setFirstRow(m + 1);
/* 376 */         return (Ptg)paramAreaPtgBase;
/* 377 */       }  if (k <= j && j < m) {
/*     */         
/* 379 */         paramAreaPtgBase.setLastRow(k - 1);
/* 380 */         return (Ptg)paramAreaPtgBase;
/*     */       } 
/*     */ 
/*     */       
/* 384 */       return null;
/*     */     } 
/* 386 */     if (this._firstMovedIndex <= i && i <= this._lastMovedIndex) {
/*     */ 
/*     */       
/* 389 */       if (this._amountToMove < 0) {
/*     */         
/* 391 */         paramAreaPtgBase.setFirstRow(i + this._amountToMove);
/* 392 */         return (Ptg)paramAreaPtgBase;
/*     */       } 
/* 394 */       if (k > j)
/*     */       {
/* 396 */         return null;
/*     */       }
/* 398 */       int n = i + this._amountToMove;
/* 399 */       if (m < j) {
/*     */ 
/*     */         
/* 402 */         paramAreaPtgBase.setFirstRow(n);
/* 403 */         return (Ptg)paramAreaPtgBase;
/*     */       } 
/*     */       
/* 406 */       int i1 = this._lastMovedIndex + 1;
/* 407 */       if (k > i1)
/*     */       {
/* 409 */         n = i1;
/*     */       }
/* 411 */       paramAreaPtgBase.setFirstRow(n);
/* 412 */       paramAreaPtgBase.setLastRow(Math.max(j, m));
/* 413 */       return (Ptg)paramAreaPtgBase;
/*     */     } 
/* 415 */     if (this._firstMovedIndex <= j && j <= this._lastMovedIndex) {
/*     */ 
/*     */       
/* 418 */       if (this._amountToMove > 0) {
/*     */         
/* 420 */         paramAreaPtgBase.setLastRow(j + this._amountToMove);
/* 421 */         return (Ptg)paramAreaPtgBase;
/*     */       } 
/* 423 */       if (m < i)
/*     */       {
/* 425 */         return null;
/*     */       }
/* 427 */       int n = j + this._amountToMove;
/* 428 */       if (k > i) {
/*     */ 
/*     */         
/* 431 */         paramAreaPtgBase.setLastRow(n);
/* 432 */         return (Ptg)paramAreaPtgBase;
/*     */       } 
/*     */       
/* 435 */       int i1 = this._firstMovedIndex - 1;
/* 436 */       if (m < i1)
/*     */       {
/* 438 */         n = i1;
/*     */       }
/* 440 */       paramAreaPtgBase.setFirstRow(Math.min(i, k));
/* 441 */       paramAreaPtgBase.setLastRow(n);
/* 442 */       return (Ptg)paramAreaPtgBase;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 447 */     if (m < i || j < k)
/*     */     {
/* 449 */       return null;
/*     */     }
/*     */     
/* 452 */     if (k <= i && j <= m)
/*     */     {
/* 454 */       return createDeletedRef((Ptg)paramAreaPtgBase);
/*     */     }
/*     */     
/* 457 */     if (i <= k && m <= j)
/*     */     {
/* 459 */       return null;
/*     */     }
/*     */     
/* 462 */     if (k < i && i <= m) {
/*     */ 
/*     */       
/* 465 */       paramAreaPtgBase.setFirstRow(m + 1);
/* 466 */       return (Ptg)paramAreaPtgBase;
/*     */     } 
/* 468 */     if (k <= j && j < m) {
/*     */ 
/*     */       
/* 471 */       paramAreaPtgBase.setLastRow(k - 1);
/* 472 */       return (Ptg)paramAreaPtgBase;
/*     */     } 
/* 474 */     throw new IllegalStateException("Situation not covered: (" + this._firstMovedIndex + ", " + this._lastMovedIndex + ", " + this._amountToMove + ", " + i + ", " + j + ")");
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
/*     */   private Ptg rowCopyRefPtg(RefPtgBase paramRefPtgBase) {
/* 487 */     int i = paramRefPtgBase.getRow();
/* 488 */     if (paramRefPtgBase.isRowRelative()) {
/* 489 */       int j = this._firstMovedIndex + this._amountToMove;
/* 490 */       if (j < 0 || this._version.getLastRowIndex() < j)
/* 491 */         return createDeletedRef((Ptg)paramRefPtgBase); 
/* 492 */       paramRefPtgBase.setRow(i + this._amountToMove);
/* 493 */       return (Ptg)paramRefPtgBase;
/*     */     } 
/* 495 */     return null;
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
/*     */   private Ptg rowCopyAreaPtg(AreaPtgBase paramAreaPtgBase) {
/* 507 */     boolean bool = false;
/*     */     
/* 509 */     int i = paramAreaPtgBase.getFirstRow();
/* 510 */     int j = paramAreaPtgBase.getLastRow();
/*     */     
/* 512 */     if (paramAreaPtgBase.isFirstRowRelative()) {
/* 513 */       int k = i + this._amountToMove;
/* 514 */       if (k < 0 || this._version.getLastRowIndex() < k)
/* 515 */         return createDeletedRef((Ptg)paramAreaPtgBase); 
/* 516 */       paramAreaPtgBase.setFirstRow(k);
/* 517 */       bool = true;
/*     */     } 
/* 519 */     if (paramAreaPtgBase.isLastRowRelative()) {
/* 520 */       int k = j + this._amountToMove;
/* 521 */       if (k < 0 || this._version.getLastRowIndex() < k)
/* 522 */         return createDeletedRef((Ptg)paramAreaPtgBase); 
/* 523 */       paramAreaPtgBase.setLastRow(k);
/* 524 */       bool = true;
/*     */     } 
/* 526 */     if (bool) {
/* 527 */       paramAreaPtgBase.sortTopLeftToBottomRight();
/*     */     }
/*     */     
/* 530 */     return bool ? (Ptg)paramAreaPtgBase : null;
/*     */   }
/*     */   
/*     */   private static Ptg createDeletedRef(Ptg paramPtg) {
/* 534 */     if (paramPtg instanceof RefPtg) {
/* 535 */       return (Ptg)new RefErrorPtg();
/*     */     }
/* 537 */     if (paramPtg instanceof Ref3DPtg) {
/* 538 */       Ref3DPtg ref3DPtg = (Ref3DPtg)paramPtg;
/* 539 */       return (Ptg)new DeletedRef3DPtg(ref3DPtg.getExternSheetIndex());
/*     */     } 
/* 541 */     if (paramPtg instanceof org.apache.poi.ss.formula.ptg.AreaPtg) {
/* 542 */       return (Ptg)new AreaErrPtg();
/*     */     }
/* 544 */     if (paramPtg instanceof Area3DPtg) {
/* 545 */       Area3DPtg area3DPtg = (Area3DPtg)paramPtg;
/* 546 */       return (Ptg)new DeletedArea3DPtg(area3DPtg.getExternSheetIndex());
/*     */     } 
/* 548 */     if (paramPtg instanceof Ref3DPxg) {
/* 549 */       Ref3DPxg ref3DPxg = (Ref3DPxg)paramPtg;
/* 550 */       return (Ptg)new Deleted3DPxg(ref3DPxg.getExternalWorkbookNumber(), ref3DPxg.getSheetName());
/*     */     } 
/* 552 */     if (paramPtg instanceof Area3DPxg) {
/* 553 */       Area3DPxg area3DPxg = (Area3DPxg)paramPtg;
/* 554 */       return (Ptg)new Deleted3DPxg(area3DPxg.getExternalWorkbookNumber(), area3DPxg.getSheetName());
/*     */     } 
/*     */     
/* 557 */     throw new IllegalArgumentException("Unexpected ref ptg class (" + paramPtg.getClass().getName() + ")");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\FormulaShifter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */