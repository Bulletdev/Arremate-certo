/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.poi.hssf.record.CellValueRecordInterface;
/*     */ import org.apache.poi.hssf.record.ExtendedFormatRecord;
/*     */ import org.apache.poi.hssf.record.RowRecord;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.util.Configurator;
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
/*     */ public final class HSSFRow
/*     */   implements Comparable<HSSFRow>, Row
/*     */ {
/*  41 */   public static final int INITIAL_CAPACITY = Configurator.getIntValue("HSSFRow.ColInitialCapacity", 5);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int rowNum;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HSSFCell[] cells;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final RowRecord row;
/*     */ 
/*     */ 
/*     */   
/*     */   private final HSSFWorkbook book;
/*     */ 
/*     */ 
/*     */   
/*     */   private final HSSFSheet sheet;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   HSSFRow(HSSFWorkbook paramHSSFWorkbook, HSSFSheet paramHSSFSheet, int paramInt) {
/*  70 */     this(paramHSSFWorkbook, paramHSSFSheet, new RowRecord(paramInt));
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
/*     */   HSSFRow(HSSFWorkbook paramHSSFWorkbook, HSSFSheet paramHSSFSheet, RowRecord paramRowRecord) {
/*  83 */     this.book = paramHSSFWorkbook;
/*  84 */     this.sheet = paramHSSFSheet;
/*  85 */     this.row = paramRowRecord;
/*  86 */     setRowNum(paramRowRecord.getRowNumber());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     this.cells = new HSSFCell[paramRowRecord.getLastCol() + INITIAL_CAPACITY];
/*     */ 
/*     */ 
/*     */     
/*  95 */     paramRowRecord.setEmpty();
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
/*     */   public HSSFCell createCell(int paramInt) {
/* 114 */     return createCell(paramInt, CellType.BLANK);
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
/*     */   public HSSFCell createCell(int paramInt1, int paramInt2) {
/* 135 */     return createCell(paramInt1, CellType.forInt(paramInt2));
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
/*     */   public HSSFCell createCell(int paramInt, CellType paramCellType) {
/* 154 */     short s = (short)paramInt;
/* 155 */     if (paramInt > 32767) {
/* 156 */       s = (short)(65535 - paramInt);
/*     */     }
/*     */     
/* 159 */     HSSFCell hSSFCell = new HSSFCell(this.book, this.sheet, getRowNum(), s, paramCellType);
/* 160 */     addCell(hSSFCell);
/* 161 */     this.sheet.getSheet().addValueRecord(getRowNum(), hSSFCell.getCellValueRecord());
/* 162 */     return hSSFCell;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCell(Cell paramCell) {
/* 171 */     if (paramCell == null) {
/* 172 */       throw new IllegalArgumentException("cell must not be null");
/*     */     }
/* 174 */     removeCell((HSSFCell)paramCell, true);
/*     */   }
/*     */   
/*     */   private void removeCell(HSSFCell paramHSSFCell, boolean paramBoolean) {
/* 178 */     int i = paramHSSFCell.getColumnIndex();
/* 179 */     if (i < 0) {
/* 180 */       throw new RuntimeException("Negative cell indexes not allowed");
/*     */     }
/* 182 */     if (i >= this.cells.length || paramHSSFCell != this.cells[i]) {
/* 183 */       throw new RuntimeException("Specified cell is not from this row");
/*     */     }
/* 185 */     if (paramHSSFCell.isPartOfArrayFormulaGroup()) {
/* 186 */       paramHSSFCell.notifyArrayFormulaChanging();
/*     */     }
/*     */     
/* 189 */     this.cells[i] = null;
/*     */     
/* 191 */     if (paramBoolean) {
/* 192 */       CellValueRecordInterface cellValueRecordInterface = paramHSSFCell.getCellValueRecord();
/* 193 */       this.sheet.getSheet().removeValueRecord(getRowNum(), cellValueRecordInterface);
/*     */     } 
/* 195 */     if (paramHSSFCell.getColumnIndex() + 1 == this.row.getLastCol()) {
/* 196 */       this.row.setLastCol(calculateNewLastCellPlusOne(this.row.getLastCol()));
/*     */     }
/* 198 */     if (paramHSSFCell.getColumnIndex() == this.row.getFirstCol()) {
/* 199 */       this.row.setFirstCol(calculateNewFirstCell(this.row.getFirstCol()));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAllCells() {
/* 208 */     for (byte b = 0; b < this.cells.length; b++) {
/* 209 */       if (this.cells[b] != null) {
/* 210 */         removeCell(this.cells[b], true);
/*     */       }
/*     */     } 
/* 213 */     this.cells = new HSSFCell[INITIAL_CAPACITY];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   HSSFCell createCellFromRecord(CellValueRecordInterface paramCellValueRecordInterface) {
/* 223 */     HSSFCell hSSFCell = new HSSFCell(this.book, this.sheet, paramCellValueRecordInterface);
/*     */     
/* 225 */     addCell(hSSFCell);
/* 226 */     short s = paramCellValueRecordInterface.getColumn();
/* 227 */     if (this.row.isEmpty()) {
/* 228 */       this.row.setFirstCol(s);
/* 229 */       this.row.setLastCol(s + 1);
/*     */     }
/* 231 */     else if (s < this.row.getFirstCol()) {
/* 232 */       this.row.setFirstCol(s);
/* 233 */     } else if (s > this.row.getLastCol()) {
/* 234 */       this.row.setLastCol(s + 1);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 240 */     return hSSFCell;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowNum(int paramInt) {
/* 250 */     int i = SpreadsheetVersion.EXCEL97.getLastRowIndex();
/* 251 */     if (paramInt < 0 || paramInt > i) {
/* 252 */       throw new IllegalArgumentException("Invalid row number (" + paramInt + ") outside allowable range (0.." + i + ")");
/*     */     }
/*     */     
/* 255 */     this.rowNum = paramInt;
/* 256 */     if (this.row != null) {
/* 257 */       this.row.setRowNumber(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowNum() {
/* 268 */     return this.rowNum;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFSheet getSheet() {
/* 279 */     return this.sheet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOutlineLevel() {
/* 289 */     return this.row.getOutlineLevel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveCell(HSSFCell paramHSSFCell, short paramShort) {
/* 300 */     if (this.cells.length > paramShort && this.cells[paramShort] != null) {
/* 301 */       throw new IllegalArgumentException("Asked to move cell to column " + paramShort + " but there's already a cell there");
/*     */     }
/*     */ 
/*     */     
/* 305 */     if (!this.cells[paramHSSFCell.getColumnIndex()].equals(paramHSSFCell)) {
/* 306 */       throw new IllegalArgumentException("Asked to move a cell, but it didn't belong to our row");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 311 */     removeCell(paramHSSFCell, false);
/* 312 */     paramHSSFCell.updateCellNum(paramShort);
/* 313 */     addCell(paramHSSFCell);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addCell(HSSFCell paramHSSFCell) {
/* 321 */     int i = paramHSSFCell.getColumnIndex();
/*     */     
/* 323 */     if (i >= this.cells.length) {
/* 324 */       HSSFCell[] arrayOfHSSFCell = this.cells;
/*     */       
/* 326 */       int j = arrayOfHSSFCell.length * 3 / 2 + 1;
/* 327 */       if (j < i + 1) {
/* 328 */         j = i + INITIAL_CAPACITY;
/*     */       }
/* 330 */       this.cells = new HSSFCell[j];
/* 331 */       System.arraycopy(arrayOfHSSFCell, 0, this.cells, 0, arrayOfHSSFCell.length);
/*     */     } 
/* 333 */     this.cells[i] = paramHSSFCell;
/*     */ 
/*     */     
/* 336 */     if (this.row.isEmpty() || i < this.row.getFirstCol()) {
/* 337 */       this.row.setFirstCol((short)i);
/*     */     }
/*     */     
/* 340 */     if (this.row.isEmpty() || i >= this.row.getLastCol()) {
/* 341 */       this.row.setLastCol((short)(i + 1));
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
/*     */ 
/*     */   
/*     */   private HSSFCell retrieveCell(int paramInt) {
/* 355 */     if (paramInt < 0 || paramInt >= this.cells.length) {
/* 356 */       return null;
/*     */     }
/* 358 */     return this.cells[paramInt];
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
/*     */   public HSSFCell getCell(int paramInt) {
/* 372 */     return getCell(paramInt, this.book.getMissingCellPolicy());
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
/*     */   public HSSFCell getCell(int paramInt, Row.MissingCellPolicy paramMissingCellPolicy) {
/*     */     boolean bool;
/* 386 */     HSSFCell hSSFCell = retrieveCell(paramInt);
/* 387 */     switch (paramMissingCellPolicy) {
/*     */       case RETURN_NULL_AND_BLANK:
/* 389 */         return hSSFCell;
/*     */       case RETURN_BLANK_AS_NULL:
/* 391 */         bool = (hSSFCell != null && hSSFCell.getCellTypeEnum() == CellType.BLANK) ? true : false;
/* 392 */         return bool ? null : hSSFCell;
/*     */       case CREATE_NULL_AS_BLANK:
/* 394 */         return (hSSFCell == null) ? createCell(paramInt, CellType.BLANK) : hSSFCell;
/*     */     } 
/* 396 */     throw new IllegalArgumentException("Illegal policy " + paramMissingCellPolicy + " (" + paramMissingCellPolicy.id + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFirstCellNum() {
/* 406 */     if (this.row.isEmpty()) {
/* 407 */       return -1;
/*     */     }
/* 409 */     return (short)this.row.getFirstCol();
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
/* 433 */     if (this.row.isEmpty()) {
/* 434 */       return -1;
/*     */     }
/* 436 */     return (short)this.row.getLastCol();
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
/*     */   public int getPhysicalNumberOfCells() {
/* 449 */     byte b1 = 0;
/* 450 */     for (byte b2 = 0; b2 < this.cells.length; b2++) {
/*     */       
/* 452 */       if (this.cells[b2] != null) b1++; 
/*     */     } 
/* 454 */     return b1;
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
/*     */   public void setHeight(short paramShort) {
/* 466 */     if (paramShort == -1) {
/* 467 */       this.row.setHeight((short)-32513);
/* 468 */       this.row.setBadFontHeight(false);
/*     */     } else {
/* 470 */       this.row.setBadFontHeight(true);
/* 471 */       this.row.setHeight(paramShort);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZeroHeight(boolean paramBoolean) {
/* 481 */     this.row.setZeroHeight(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getZeroHeight() {
/* 490 */     return this.row.getZeroHeight();
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
/* 501 */     if (paramFloat == -1.0F) {
/* 502 */       this.row.setHeight((short)-32513);
/*     */     } else {
/* 504 */       this.row.setBadFontHeight(true);
/* 505 */       this.row.setHeight((short)(int)(paramFloat * 20.0F));
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
/*     */   public short getHeight() {
/* 517 */     short s = this.row.getHeight();
/*     */ 
/*     */ 
/*     */     
/* 521 */     if ((s & 0x8000) != 0) { s = this.sheet.getSheet().getDefaultRowHeight(); }
/* 522 */     else { s = (short)(s & Short.MAX_VALUE); }
/*     */     
/* 524 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getHeightInPoints() {
/* 535 */     return getHeight() / 20.0F;
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
/*     */   protected RowRecord getRowRecord() {
/* 547 */     return this.row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int calculateNewLastCellPlusOne(int paramInt) {
/* 555 */     int i = paramInt - 1;
/* 556 */     HSSFCell hSSFCell = retrieveCell(i);
/*     */     
/* 558 */     while (hSSFCell == null) {
/* 559 */       if (i < 0) {
/* 560 */         return 0;
/*     */       }
/* 562 */       hSSFCell = retrieveCell(--i);
/*     */     } 
/* 564 */     return i + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int calculateNewFirstCell(int paramInt) {
/* 572 */     int i = paramInt + 1;
/* 573 */     HSSFCell hSSFCell = retrieveCell(i);
/*     */     
/* 575 */     while (hSSFCell == null) {
/* 576 */       if (i <= this.cells.length) {
/* 577 */         return 0;
/*     */       }
/* 579 */       hSSFCell = retrieveCell(++i);
/*     */     } 
/* 581 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFormatted() {
/* 591 */     return this.row.getFormatted();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFCellStyle getRowStyle() {
/* 600 */     if (!isFormatted()) return null; 
/* 601 */     short s = this.row.getXFIndex();
/* 602 */     ExtendedFormatRecord extendedFormatRecord = this.book.getWorkbook().getExFormatAt(s);
/* 603 */     return new HSSFCellStyle(s, extendedFormatRecord, this.book);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowStyle(HSSFCellStyle paramHSSFCellStyle) {
/* 609 */     this.row.setFormatted(true);
/* 610 */     this.row.setXFIndex(paramHSSFCellStyle.getIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowStyle(CellStyle paramCellStyle) {
/* 617 */     setRowStyle((HSSFCellStyle)paramCellStyle);
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
/*     */   public Iterator<Cell> cellIterator() {
/* 631 */     return new CellIterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Cell> iterator() {
/* 639 */     return cellIterator();
/*     */   }
/*     */ 
/*     */   
/*     */   private class CellIterator
/*     */     implements Iterator<Cell>
/*     */   {
/* 646 */     int thisId = -1;
/* 647 */     int nextId = -1;
/*     */ 
/*     */     
/*     */     public CellIterator() {
/* 651 */       findNext();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 656 */       return (this.nextId < HSSFRow.this.cells.length);
/*     */     }
/*     */ 
/*     */     
/*     */     public Cell next() {
/* 661 */       if (!hasNext())
/* 662 */         throw new NoSuchElementException("At last element"); 
/* 663 */       HSSFCell hSSFCell = HSSFRow.this.cells[this.nextId];
/* 664 */       this.thisId = this.nextId;
/* 665 */       findNext();
/* 666 */       return hSSFCell;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 671 */       if (this.thisId == -1)
/* 672 */         throw new IllegalStateException("remove() called before next()"); 
/* 673 */       HSSFRow.this.cells[this.thisId] = null;
/*     */     }
/*     */ 
/*     */     
/*     */     private void findNext() {
/* 678 */       int i = this.nextId + 1;
/* 679 */       for (; i < HSSFRow.this.cells.length; i++) {
/*     */         
/* 681 */         if (HSSFRow.this.cells[i] != null)
/*     */           break; 
/* 683 */       }  this.nextId = i;
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
/*     */   public int compareTo(HSSFRow paramHSSFRow) {
/* 712 */     if (getSheet() != paramHSSFRow.getSheet()) {
/* 713 */       throw new IllegalArgumentException("The compared rows must belong to the same sheet");
/*     */     }
/*     */     
/* 716 */     Integer integer1 = Integer.valueOf(getRowNum());
/* 717 */     Integer integer2 = Integer.valueOf(paramHSSFRow.getRowNum());
/* 718 */     return integer1.compareTo(integer2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 724 */     if (!(paramObject instanceof HSSFRow))
/*     */     {
/* 726 */       return false;
/*     */     }
/* 728 */     HSSFRow hSSFRow = (HSSFRow)paramObject;
/*     */     
/* 730 */     return (getRowNum() == hSSFRow.getRowNum() && getSheet() == hSSFRow.getSheet());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 736 */     return this.row.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */