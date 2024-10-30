/*     */ package org.apache.poi.xssf.streaming;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.util.Internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SXSSFRow
/*     */   implements Comparable<SXSSFRow>, Row
/*     */ {
/*  39 */   private static final Boolean UNDEFINED = null;
/*     */   
/*     */   private final SXSSFSheet _sheet;
/*  42 */   private final SortedMap<Integer, SXSSFCell> _cells = new TreeMap<Integer, SXSSFCell>();
/*  43 */   private short _style = -1;
/*  44 */   private short _height = -1;
/*     */   private boolean _zHeight = false;
/*  46 */   private int _outlineLevel = 0;
/*     */   
/*  48 */   private Boolean _hidden = UNDEFINED;
/*  49 */   private Boolean _collapsed = UNDEFINED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public SXSSFRow(SXSSFSheet paramSXSSFSheet, int paramInt) {
/*  60 */     this(paramSXSSFSheet);
/*     */   }
/*     */ 
/*     */   
/*     */   public SXSSFRow(SXSSFSheet paramSXSSFSheet) {
/*  65 */     this._sheet = paramSXSSFSheet;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<Cell> allCellsIterator() {
/*  70 */     return new CellIterator();
/*     */   }
/*     */   
/*     */   public boolean hasCustomHeight() {
/*  74 */     return (this._height != -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOutlineLevel() {
/*  79 */     return this._outlineLevel;
/*     */   }
/*     */   void setOutlineLevel(int paramInt) {
/*  82 */     this._outlineLevel = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getHidden() {
/*  91 */     return this._hidden;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHidden(Boolean paramBoolean) {
/* 100 */     this._hidden = paramBoolean;
/*     */   }
/*     */   
/*     */   public Boolean getCollapsed() {
/* 104 */     return this._collapsed;
/*     */   }
/*     */   
/*     */   public void setCollapsed(Boolean paramBoolean) {
/* 108 */     this._collapsed = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Cell> iterator() {
/* 117 */     return new FilledCellIterator();
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
/*     */   public SXSSFCell createCell(int paramInt) {
/* 134 */     return createCell(paramInt, CellType.BLANK);
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
/*     */   public SXSSFCell createCell(int paramInt1, int paramInt2) {
/* 152 */     return createCell(paramInt1, CellType.forInt(paramInt2));
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
/*     */   public SXSSFCell createCell(int paramInt, CellType paramCellType) {
/* 168 */     checkBounds(paramInt);
/* 169 */     SXSSFCell sXSSFCell = new SXSSFCell(this, paramCellType);
/* 170 */     this._cells.put(Integer.valueOf(paramInt), sXSSFCell);
/* 171 */     return sXSSFCell;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void checkBounds(int paramInt) {
/* 178 */     SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL2007;
/* 179 */     int i = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
/* 180 */     if (paramInt < 0 || paramInt > i) {
/* 181 */       throw new IllegalArgumentException("Invalid column index (" + paramInt + ").  Allowable column range for " + spreadsheetVersion.name() + " is (0.." + i + ") or ('A'..'" + spreadsheetVersion.getLastColumnName() + "')");
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
/*     */   public void removeCell(Cell paramCell) {
/* 195 */     int i = getCellIndex((SXSSFCell)paramCell);
/* 196 */     this._cells.remove(Integer.valueOf(i));
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
/*     */   int getCellIndex(SXSSFCell paramSXSSFCell) {
/* 208 */     for (Map.Entry<Integer, SXSSFCell> entry : this._cells.entrySet()) {
/* 209 */       if (entry.getValue() == paramSXSSFCell) {
/* 210 */         return ((Integer)entry.getKey()).intValue();
/*     */       }
/*     */     } 
/* 213 */     return -1;
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
/*     */   public void setRowNum(int paramInt) {
/* 225 */     this._sheet.changeRowNum(this, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowNum() {
/* 236 */     return this._sheet.getRowNum(this);
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
/*     */   public SXSSFCell getCell(int paramInt) {
/* 251 */     Row.MissingCellPolicy missingCellPolicy = this._sheet.getWorkbook().getMissingCellPolicy();
/* 252 */     return getCell(paramInt, missingCellPolicy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SXSSFCell getCell(int paramInt, Row.MissingCellPolicy paramMissingCellPolicy) {
/*     */     boolean bool;
/* 264 */     checkBounds(paramInt);
/*     */     
/* 266 */     SXSSFCell sXSSFCell = this._cells.get(Integer.valueOf(paramInt));
/* 267 */     switch (paramMissingCellPolicy) {
/*     */       case RETURN_NULL_AND_BLANK:
/* 269 */         return sXSSFCell;
/*     */       case RETURN_BLANK_AS_NULL:
/* 271 */         bool = (sXSSFCell != null && sXSSFCell.getCellTypeEnum() == CellType.BLANK) ? true : false;
/* 272 */         return bool ? null : sXSSFCell;
/*     */       case CREATE_NULL_AS_BLANK:
/* 274 */         return (sXSSFCell == null) ? createCell(paramInt, CellType.BLANK) : sXSSFCell;
/*     */     } 
/* 276 */     throw new IllegalArgumentException("Illegal policy " + paramMissingCellPolicy + " (" + paramMissingCellPolicy.id + ")");
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
/*     */   public short getFirstCellNum() {
/*     */     try {
/* 290 */       return ((Integer)this._cells.firstKey()).shortValue();
/* 291 */     } catch (NoSuchElementException noSuchElementException) {
/* 292 */       return -1;
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
/*     */   public short getLastCellNum() {
/* 318 */     return this._cells.isEmpty() ? -1 : (short)(((Integer)this._cells.lastKey()).intValue() + 1);
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
/*     */   public int getPhysicalNumberOfCells() {
/* 330 */     return this._cells.size();
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
/* 342 */     this._height = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZeroHeight(boolean paramBoolean) {
/* 353 */     this._zHeight = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getZeroHeight() {
/* 364 */     return this._zHeight;
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
/* 375 */     if (paramFloat == -1.0F) {
/* 376 */       this._height = -1;
/*     */     } else {
/* 378 */       this._height = (short)(int)(paramFloat * 20.0F);
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
/* 390 */     return (short)(int)((this._height == -1) ? (getSheet().getDefaultRowHeightInPoints() * 20.0F) : this._height);
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
/*     */   public float getHeightInPoints() {
/* 403 */     return (float)((this._height == -1) ? getSheet().getDefaultRowHeightInPoints() : (this._height / 20.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFormatted() {
/* 413 */     return (this._style > -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellStyle getRowStyle() {
/* 422 */     if (!isFormatted()) return null;
/*     */     
/* 424 */     return getSheet().getWorkbook().getCellStyleAt(this._style);
/*     */   }
/*     */   
/*     */   @Internal
/*     */   int getRowStyleIndex() {
/* 429 */     return this._style;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowStyle(CellStyle paramCellStyle) {
/* 438 */     if (paramCellStyle == null) {
/* 439 */       this._style = -1;
/*     */     } else {
/* 441 */       this._style = paramCellStyle.getIndex();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Cell> cellIterator() {
/* 451 */     return iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SXSSFSheet getSheet() {
/* 462 */     return this._sheet;
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
/*     */   public class FilledCellIterator
/*     */     implements Iterator<Cell>
/*     */   {
/* 477 */     private final Iterator<SXSSFCell> iter = SXSSFRow.this._cells.values().iterator();
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 482 */       return this.iter.hasNext();
/*     */     }
/*     */ 
/*     */     
/*     */     public Cell next() throws NoSuchElementException {
/* 487 */       return this.iter.next();
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class CellIterator
/*     */     implements Iterator<Cell>
/*     */   {
/* 504 */     final int maxColumn = SXSSFRow.this.getLastCellNum();
/* 505 */     int pos = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 510 */       return (this.pos < this.maxColumn);
/*     */     }
/*     */ 
/*     */     
/*     */     public Cell next() throws NoSuchElementException {
/* 515 */       if (hasNext()) {
/* 516 */         return (Cell)SXSSFRow.this._cells.get(Integer.valueOf(this.pos++));
/*     */       }
/* 518 */       throw new NoSuchElementException();
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 523 */       throw new UnsupportedOperationException();
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
/*     */   public int compareTo(SXSSFRow paramSXSSFRow) {
/* 550 */     if (getSheet() != paramSXSSFRow.getSheet()) {
/* 551 */       throw new IllegalArgumentException("The compared rows must belong to the same sheet");
/*     */     }
/*     */     
/* 554 */     Integer integer1 = Integer.valueOf(getRowNum());
/* 555 */     Integer integer2 = Integer.valueOf(paramSXSSFRow.getRowNum());
/* 556 */     return integer1.compareTo(integer2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 562 */     if (!(paramObject instanceof SXSSFRow))
/*     */     {
/* 564 */       return false;
/*     */     }
/* 566 */     SXSSFRow sXSSFRow = (SXSSFRow)paramObject;
/*     */     
/* 568 */     return (getRowNum() == sXSSFRow.getRowNum() && getSheet() == sXSSFRow.getSheet());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 574 */     return this._cells.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\SXSSFRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */