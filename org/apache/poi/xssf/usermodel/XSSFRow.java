/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.formula.FormulaShifter;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellCopyPolicy;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.model.CalculationChain;
/*     */ import org.apache.poi.xssf.model.StylesTable;
/*     */ import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;
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
/*     */ public class XSSFRow
/*     */   implements Comparable<XSSFRow>, Row
/*     */ {
/*     */   private final CTRow _row;
/*     */   private final TreeMap<Integer, XSSFCell> _cells;
/*     */   private final XSSFSheet _sheet;
/*     */   
/*     */   protected XSSFRow(CTRow paramCTRow, XSSFSheet paramXSSFSheet) {
/*  71 */     this._row = paramCTRow;
/*  72 */     this._sheet = paramXSSFSheet;
/*  73 */     this._cells = new TreeMap<Integer, XSSFCell>();
/*  74 */     for (CTCell cTCell : paramCTRow.getCArray()) {
/*  75 */       XSSFCell xSSFCell = new XSSFCell(this, cTCell);
/*     */       
/*  77 */       Integer integer = new Integer(xSSFCell.getColumnIndex());
/*  78 */       this._cells.put(integer, xSSFCell);
/*  79 */       paramXSSFSheet.onReadCell(xSSFCell);
/*     */     } 
/*     */     
/*  82 */     if (!paramCTRow.isSetR()) {
/*     */ 
/*     */       
/*  85 */       int i = paramXSSFSheet.getLastRowNum() + 2;
/*  86 */       if (i == 2 && paramXSSFSheet.getPhysicalNumberOfRows() == 0) {
/*  87 */         i = 1;
/*     */       }
/*  89 */       paramCTRow.setR(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFSheet getSheet() {
/* 100 */     return this._sheet;
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
/*     */   public Iterator<Cell> cellIterator() {
/* 117 */     return this._cells.values().iterator();
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
/*     */   public Iterator<Cell> iterator() {
/* 132 */     return cellIterator();
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
/*     */   public int compareTo(XSSFRow paramXSSFRow) {
/* 158 */     if (getSheet() != paramXSSFRow.getSheet()) {
/* 159 */       throw new IllegalArgumentException("The compared rows must belong to the same sheet");
/*     */     }
/*     */     
/* 162 */     Integer integer1 = Integer.valueOf(getRowNum());
/* 163 */     Integer integer2 = Integer.valueOf(paramXSSFRow.getRowNum());
/* 164 */     return integer1.compareTo(integer2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 170 */     if (!(paramObject instanceof XSSFRow))
/*     */     {
/* 172 */       return false;
/*     */     }
/* 174 */     XSSFRow xSSFRow = (XSSFRow)paramObject;
/*     */     
/* 176 */     return (getRowNum() == xSSFRow.getRowNum() && getSheet() == xSSFRow.getSheet());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 182 */     return this._row.hashCode();
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
/*     */   public XSSFCell createCell(int paramInt) {
/* 198 */     return createCell(paramInt, CellType.BLANK);
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
/*     */   public XSSFCell createCell(int paramInt1, int paramInt2) {
/* 219 */     return createCell(paramInt1, CellType.forInt(paramInt2));
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
/*     */   public XSSFCell createCell(int paramInt, CellType paramCellType) {
/*     */     CTCell cTCell;
/* 233 */     Integer integer = new Integer(paramInt);
/*     */     
/* 235 */     XSSFCell xSSFCell1 = this._cells.get(integer);
/* 236 */     if (xSSFCell1 != null) {
/* 237 */       cTCell = xSSFCell1.getCTCell();
/* 238 */       cTCell.set((XmlObject)CTCell.Factory.newInstance());
/*     */     } else {
/* 240 */       cTCell = this._row.addNewC();
/*     */     } 
/* 242 */     XSSFCell xSSFCell2 = new XSSFCell(this, cTCell);
/* 243 */     xSSFCell2.setCellNum(paramInt);
/* 244 */     if (paramCellType != CellType.BLANK) {
/* 245 */       xSSFCell2.setCellType(paramCellType);
/*     */     }
/* 247 */     this._cells.put(integer, xSSFCell2);
/* 248 */     return xSSFCell2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFCell getCell(int paramInt) {
/* 259 */     return getCell(paramInt, this._sheet.getWorkbook().getMissingCellPolicy());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFCell getCell(int paramInt, Row.MissingCellPolicy paramMissingCellPolicy) {
/*     */     boolean bool;
/* 270 */     if (paramInt < 0) throw new IllegalArgumentException("Cell index must be >= 0");
/*     */ 
/*     */     
/* 273 */     Integer integer = new Integer(paramInt);
/* 274 */     XSSFCell xSSFCell = this._cells.get(integer);
/* 275 */     switch (paramMissingCellPolicy) {
/*     */       case RETURN_NULL_AND_BLANK:
/* 277 */         return xSSFCell;
/*     */       case RETURN_BLANK_AS_NULL:
/* 279 */         bool = (xSSFCell != null && xSSFCell.getCellTypeEnum() == CellType.BLANK) ? true : false;
/* 280 */         return bool ? null : xSSFCell;
/*     */       case CREATE_NULL_AS_BLANK:
/* 282 */         return (xSSFCell == null) ? createCell(paramInt, CellType.BLANK) : xSSFCell;
/*     */     } 
/* 284 */     throw new IllegalArgumentException("Illegal policy " + paramMissingCellPolicy + " (" + paramMissingCellPolicy.id + ")");
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
/*     */   public short getFirstCellNum() {
/* 296 */     return (short)((this._cells.size() == 0) ? -1 : ((Integer)this._cells.firstKey()).intValue());
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
/*     */   public short getLastCellNum() {
/* 320 */     return (short)((this._cells.size() == 0) ? -1 : (((Integer)this._cells.lastKey()).intValue() + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getHeight() {
/* 331 */     return (short)(int)(getHeightInPoints() * 20.0F);
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
/*     */   public float getHeightInPoints() {
/* 343 */     if (this._row.isSetHt()) {
/* 344 */       return (float)this._row.getHt();
/*     */     }
/* 346 */     return this._sheet.getDefaultRowHeightInPoints();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeight(short paramShort) {
/* 356 */     if (paramShort == -1) {
/* 357 */       if (this._row.isSetHt()) this._row.unsetHt(); 
/* 358 */       if (this._row.isSetCustomHeight()) this._row.unsetCustomHeight(); 
/*     */     } else {
/* 360 */       this._row.setHt(paramShort / 20.0D);
/* 361 */       this._row.setCustomHeight(true);
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
/*     */   public void setHeightInPoints(float paramFloat) {
/* 373 */     setHeight((short)(int)((paramFloat == -1.0F) ? -1.0F : (paramFloat * 20.0F)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPhysicalNumberOfCells() {
/* 384 */     return this._cells.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowNum() {
/* 394 */     return (int)(this._row.getR() - 1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowNum(int paramInt) {
/* 405 */     int i = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
/* 406 */     if (paramInt < 0 || paramInt > i) {
/* 407 */       throw new IllegalArgumentException("Invalid row number (" + paramInt + ") outside allowable range (0.." + i + ")");
/*     */     }
/*     */     
/* 410 */     this._row.setR((paramInt + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getZeroHeight() {
/* 420 */     return this._row.getHidden();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZeroHeight(boolean paramBoolean) {
/* 430 */     this._row.setHidden(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFormatted() {
/* 441 */     return this._row.isSetS();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFCellStyle getRowStyle() {
/* 450 */     if (!isFormatted()) return null;
/*     */     
/* 452 */     StylesTable stylesTable = getSheet().getWorkbook().getStylesSource();
/* 453 */     if (stylesTable.getNumCellStyles() > 0) {
/* 454 */       return stylesTable.getStyleAt((int)this._row.getS());
/*     */     }
/* 456 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowStyle(CellStyle paramCellStyle) {
/* 467 */     if (paramCellStyle == null) {
/* 468 */       if (this._row.isSetS()) {
/* 469 */         this._row.unsetS();
/* 470 */         this._row.unsetCustomFormat();
/*     */       } 
/*     */     } else {
/* 473 */       StylesTable stylesTable = getSheet().getWorkbook().getStylesSource();
/*     */       
/* 475 */       XSSFCellStyle xSSFCellStyle = (XSSFCellStyle)paramCellStyle;
/* 476 */       xSSFCellStyle.verifyBelongsToStylesSource(stylesTable);
/*     */       
/* 478 */       long l = stylesTable.putStyle(xSSFCellStyle);
/* 479 */       this._row.setS(l);
/* 480 */       this._row.setCustomFormat(true);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCell(Cell paramCell) {
/* 491 */     if (paramCell.getRow() != this) {
/* 492 */       throw new IllegalArgumentException("Specified cell does not belong to this row");
/*     */     }
/*     */     
/* 495 */     XSSFCell xSSFCell = (XSSFCell)paramCell;
/* 496 */     if (xSSFCell.isPartOfArrayFormulaGroup()) {
/* 497 */       xSSFCell.notifyArrayFormulaChanging();
/*     */     }
/* 499 */     if (paramCell.getCellTypeEnum() == CellType.FORMULA) {
/* 500 */       this._sheet.getWorkbook().onDeleteFormula(xSSFCell);
/*     */     }
/*     */     
/* 503 */     Integer integer = new Integer(paramCell.getColumnIndex());
/* 504 */     this._cells.remove(integer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTRow getCTRow() {
/* 514 */     return this._row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onDocumentWrite() {
/* 524 */     boolean bool = true;
/* 525 */     CTCell[] arrayOfCTCell = this._row.getCArray();
/* 526 */     if (arrayOfCTCell.length != this._cells.size()) {
/* 527 */       bool = false;
/*     */     } else {
/* 529 */       byte b = 0;
/* 530 */       for (XSSFCell xSSFCell : this._cells.values()) {
/* 531 */         CTCell cTCell1 = xSSFCell.getCTCell();
/* 532 */         CTCell cTCell2 = arrayOfCTCell[b++];
/*     */         
/* 534 */         String str1 = cTCell1.getR();
/* 535 */         String str2 = cTCell2.getR();
/* 536 */         if ((str1 == null) ? (str2 == null) : str1.equals(str2))
/* 537 */           continue;  bool = false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 543 */     if (!bool) {
/* 544 */       arrayOfCTCell = new CTCell[this._cells.size()];
/* 545 */       byte b = 0;
/* 546 */       for (XSSFCell xSSFCell : this._cells.values()) {
/* 547 */         arrayOfCTCell[b] = (CTCell)xSSFCell.getCTCell().copy();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 554 */         xSSFCell.setCTCell(arrayOfCTCell[b]);
/* 555 */         b++;
/*     */       } 
/*     */       
/* 558 */       this._row.setCArray(arrayOfCTCell);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 567 */     return this._row.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void shift(int paramInt) {
/* 576 */     int i = getRowNum() + paramInt;
/* 577 */     CalculationChain calculationChain = this._sheet.getWorkbook().getCalculationChain();
/* 578 */     int j = (int)this._sheet.sheet.getSheetId();
/* 579 */     String str = "Row[rownum=" + getRowNum() + "] contains cell(s) included in a multi-cell array formula. " + "You cannot change part of an array.";
/*     */     
/* 581 */     for (Cell cell : this) {
/* 582 */       XSSFCell xSSFCell = (XSSFCell)cell;
/* 583 */       if (xSSFCell.isPartOfArrayFormulaGroup()) {
/* 584 */         xSSFCell.notifyArrayFormulaChanging(str);
/*     */       }
/*     */ 
/*     */       
/* 588 */       if (calculationChain != null) calculationChain.removeItem(j, xSSFCell.getReference());
/*     */       
/* 590 */       CTCell cTCell = xSSFCell.getCTCell();
/* 591 */       String str1 = (new CellReference(i, xSSFCell.getColumnIndex())).formatAsString();
/* 592 */       cTCell.setR(str1);
/*     */     } 
/* 594 */     setRowNum(i);
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
/*     */   public void copyRowFrom(Row paramRow, CellCopyPolicy paramCellCopyPolicy) {
/* 608 */     if (paramRow == null) {
/*     */       
/* 610 */       for (Cell cell1 : this) {
/* 611 */         Cell cell2 = null;
/*     */         
/* 613 */         ((XSSFCell)cell1).copyCellFrom(cell2, paramCellCopyPolicy);
/*     */       } 
/*     */       
/* 616 */       if (paramCellCopyPolicy.isCopyMergedRegions()) {
/*     */         
/* 618 */         int i = getRowNum();
/* 619 */         byte b = 0;
/* 620 */         HashSet<Integer> hashSet = new HashSet();
/* 621 */         for (CellRangeAddress cellRangeAddress : getSheet().getMergedRegions()) {
/* 622 */           if (i == cellRangeAddress.getFirstRow() && i == cellRangeAddress.getLastRow()) {
/* 623 */             hashSet.add(Integer.valueOf(b));
/*     */           }
/* 625 */           b++;
/*     */         } 
/* 627 */         getSheet().removeMergedRegions(hashSet);
/*     */       } 
/*     */       
/* 630 */       if (paramCellCopyPolicy.isCopyRowHeight())
/*     */       {
/* 632 */         setHeight((short)-1);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 637 */       for (Cell cell : paramRow) {
/* 638 */         XSSFCell xSSFCell1 = (XSSFCell)cell;
/* 639 */         XSSFCell xSSFCell2 = createCell(xSSFCell1.getColumnIndex(), xSSFCell1.getCellTypeEnum());
/* 640 */         xSSFCell2.copyCellFrom(xSSFCell1, paramCellCopyPolicy);
/*     */       } 
/*     */       
/* 643 */       XSSFRowShifter xSSFRowShifter = new XSSFRowShifter(this._sheet);
/* 644 */       int i = this._sheet.getWorkbook().getSheetIndex(this._sheet);
/* 645 */       String str = this._sheet.getWorkbook().getSheetName(i);
/* 646 */       int j = paramRow.getRowNum();
/* 647 */       int k = getRowNum();
/* 648 */       int m = k - j;
/* 649 */       FormulaShifter formulaShifter = FormulaShifter.createForRowCopy(i, str, j, j, m, SpreadsheetVersion.EXCEL2007);
/* 650 */       xSSFRowShifter.updateRowFormulas(this, formulaShifter);
/*     */ 
/*     */ 
/*     */       
/* 654 */       if (paramCellCopyPolicy.isCopyMergedRegions()) {
/* 655 */         for (CellRangeAddress cellRangeAddress : paramRow.getSheet().getMergedRegions()) {
/* 656 */           if (j == cellRangeAddress.getFirstRow() && j == cellRangeAddress.getLastRow()) {
/* 657 */             CellRangeAddress cellRangeAddress1 = cellRangeAddress.copy();
/* 658 */             cellRangeAddress1.setFirstRow(k);
/* 659 */             cellRangeAddress1.setLastRow(k);
/* 660 */             getSheet().addMergedRegion(cellRangeAddress1);
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 665 */       if (paramCellCopyPolicy.isCopyRowHeight()) {
/* 666 */         setHeight(paramRow.getHeight());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOutlineLevel() {
/* 673 */     return this._row.getOutlineLevel();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */