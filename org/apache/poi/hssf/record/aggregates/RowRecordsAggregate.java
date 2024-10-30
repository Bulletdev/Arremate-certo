/*     */ package org.apache.poi.hssf.record.aggregates;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.poi.hssf.model.RecordStream;
/*     */ import org.apache.poi.hssf.record.CellValueRecordInterface;
/*     */ import org.apache.poi.hssf.record.DBCellRecord;
/*     */ import org.apache.poi.hssf.record.DimensionsRecord;
/*     */ import org.apache.poi.hssf.record.FormulaRecord;
/*     */ import org.apache.poi.hssf.record.IndexRecord;
/*     */ import org.apache.poi.hssf.record.MulBlankRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RowRecord;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.formula.FormulaShifter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RowRecordsAggregate
/*     */   extends RecordAggregate
/*     */ {
/*  37 */   private int _firstrow = -1;
/*  38 */   private int _lastrow = -1;
/*     */   
/*     */   private final Map<Integer, RowRecord> _rowRecords;
/*     */   
/*     */   private final ValueRecordsAggregate _valuesAgg;
/*     */   
/*     */   private final List<Record> _unknownRecords;
/*     */   private final SharedValueManager _sharedValueManager;
/*  46 */   private RowRecord[] _rowRecordValues = null;
/*     */ 
/*     */   
/*     */   public RowRecordsAggregate() {
/*  50 */     this(SharedValueManager.createEmpty());
/*     */   }
/*     */   private RowRecordsAggregate(SharedValueManager paramSharedValueManager) {
/*  53 */     if (paramSharedValueManager == null) {
/*  54 */       throw new IllegalArgumentException("SharedValueManager must be provided.");
/*     */     }
/*  56 */     this._rowRecords = new TreeMap<Integer, RowRecord>();
/*  57 */     this._valuesAgg = new ValueRecordsAggregate();
/*  58 */     this._unknownRecords = new ArrayList<Record>();
/*  59 */     this._sharedValueManager = paramSharedValueManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RowRecordsAggregate(RecordStream paramRecordStream, SharedValueManager paramSharedValueManager) {
/*  69 */     this(paramSharedValueManager);
/*  70 */     while (paramRecordStream.hasNext()) {
/*  71 */       Record record = paramRecordStream.getNext();
/*  72 */       switch (record.getSid()) {
/*     */         case 520:
/*  74 */           insertRow((RowRecord)record);
/*     */           continue;
/*     */         case 81:
/*  77 */           addUnknownRecord(record);
/*     */           continue;
/*     */         
/*     */         case 215:
/*     */           continue;
/*     */       } 
/*     */       
/*  84 */       if (record instanceof org.apache.poi.hssf.record.UnknownRecord) {
/*     */         
/*  86 */         addUnknownRecord(record);
/*  87 */         while (paramRecordStream.peekNextSid() == 60) {
/*  88 */           addUnknownRecord(paramRecordStream.getNext());
/*     */         }
/*     */         continue;
/*     */       } 
/*  92 */       if (record instanceof MulBlankRecord) {
/*  93 */         this._valuesAgg.addMultipleBlanks((MulBlankRecord)record);
/*     */         continue;
/*     */       } 
/*  96 */       if (!(record instanceof CellValueRecordInterface)) {
/*  97 */         throw new RuntimeException("Unexpected record type (" + record.getClass().getName() + ")");
/*     */       }
/*  99 */       this._valuesAgg.construct((CellValueRecordInterface)record, paramRecordStream, paramSharedValueManager);
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
/*     */   private void addUnknownRecord(Record paramRecord) {
/* 113 */     this._unknownRecords.add(paramRecord);
/*     */   }
/*     */   
/*     */   public void insertRow(RowRecord paramRowRecord) {
/* 117 */     this._rowRecords.put(Integer.valueOf(paramRowRecord.getRowNumber()), paramRowRecord);
/*     */     
/* 119 */     this._rowRecordValues = null;
/* 120 */     if (paramRowRecord.getRowNumber() < this._firstrow || this._firstrow == -1) {
/* 121 */       this._firstrow = paramRowRecord.getRowNumber();
/*     */     }
/* 123 */     if (paramRowRecord.getRowNumber() > this._lastrow || this._lastrow == -1) {
/* 124 */       this._lastrow = paramRowRecord.getRowNumber();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeRow(RowRecord paramRowRecord) {
/* 129 */     int i = paramRowRecord.getRowNumber();
/* 130 */     this._valuesAgg.removeAllCellsValuesForRow(i);
/* 131 */     Integer integer = Integer.valueOf(i);
/* 132 */     RowRecord rowRecord = this._rowRecords.remove(integer);
/* 133 */     if (rowRecord == null) {
/* 134 */       throw new RuntimeException("Invalid row index (" + integer.intValue() + ")");
/*     */     }
/* 136 */     if (paramRowRecord != rowRecord) {
/* 137 */       this._rowRecords.put(integer, rowRecord);
/* 138 */       throw new RuntimeException("Attempt to remove row that does not belong to this sheet");
/*     */     } 
/*     */ 
/*     */     
/* 142 */     this._rowRecordValues = null;
/*     */   }
/*     */   
/*     */   public RowRecord getRow(int paramInt) {
/* 146 */     int i = SpreadsheetVersion.EXCEL97.getLastRowIndex();
/* 147 */     if (paramInt < 0 || paramInt > i) {
/* 148 */       throw new IllegalArgumentException("The row number must be between 0 and " + i + ", but had: " + paramInt);
/*     */     }
/* 150 */     return this._rowRecords.get(Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPhysicalNumberOfRows() {
/* 155 */     return this._rowRecords.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFirstRowNum() {
/* 160 */     return this._firstrow;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLastRowNum() {
/* 165 */     return this._lastrow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowBlockCount() {
/* 173 */     int i = this._rowRecords.size() / 32;
/* 174 */     if (this._rowRecords.size() % 32 != 0)
/* 175 */       i++; 
/* 176 */     return i;
/*     */   }
/*     */   
/*     */   private int getRowBlockSize(int paramInt) {
/* 180 */     return 20 * getRowCountForBlock(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCountForBlock(int paramInt) {
/* 185 */     int i = paramInt * 32;
/* 186 */     int j = i + 32 - 1;
/* 187 */     if (j >= this._rowRecords.size()) {
/* 188 */       j = this._rowRecords.size() - 1;
/*     */     }
/* 190 */     return j - i + 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private int getStartRowNumberForBlock(int paramInt) {
/* 195 */     int i = paramInt * 32;
/*     */     
/* 197 */     if (this._rowRecordValues == null) {
/* 198 */       this._rowRecordValues = (RowRecord[])this._rowRecords.values().toArray((Object[])new RowRecord[this._rowRecords.size()]);
/*     */     }
/*     */     
/*     */     try {
/* 202 */       return this._rowRecordValues[i].getRowNumber();
/* 203 */     } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 204 */       throw new RuntimeException("Did not find start row for block " + paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int getEndRowNumberForBlock(int paramInt) {
/* 210 */     int i = (paramInt + 1) * 32 - 1;
/* 211 */     if (i >= this._rowRecords.size()) {
/* 212 */       i = this._rowRecords.size() - 1;
/*     */     }
/* 214 */     if (this._rowRecordValues == null) {
/* 215 */       this._rowRecordValues = (RowRecord[])this._rowRecords.values().toArray((Object[])new RowRecord[this._rowRecords.size()]);
/*     */     }
/*     */     
/*     */     try {
/* 219 */       return this._rowRecordValues[i].getRowNumber();
/* 220 */     } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 221 */       throw new RuntimeException("Did not find end row for block " + paramInt);
/*     */     } 
/*     */   }
/*     */   
/*     */   private int visitRowRecordsForBlock(int paramInt, RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 226 */     int i = paramInt * 32;
/* 227 */     int j = i + 32;
/*     */     
/* 229 */     Iterator<Record> iterator = this._rowRecords.values().iterator();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 235 */     byte b = 0;
/* 236 */     for (; b < i; b++)
/* 237 */       iterator.next(); 
/* 238 */     int k = 0;
/* 239 */     while (iterator.hasNext() && b++ < j) {
/* 240 */       Record record = iterator.next();
/* 241 */       k += record.getRecordSize();
/* 242 */       paramRecordVisitor.visitRecord(record);
/*     */     } 
/* 244 */     return k;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 250 */     RecordAggregate.PositionTrackingVisitor positionTrackingVisitor = new RecordAggregate.PositionTrackingVisitor(paramRecordVisitor, 0);
/*     */     
/* 252 */     int i = getRowBlockCount();
/* 253 */     for (byte b = 0; b < i; b++) {
/*     */ 
/*     */       
/* 256 */       int j = 0;
/*     */       
/* 258 */       int k = visitRowRecordsForBlock(b, paramRecordVisitor);
/* 259 */       j += k;
/*     */       
/* 261 */       int m = getStartRowNumberForBlock(b);
/* 262 */       int n = getEndRowNumberForBlock(b);
/* 263 */       DBCellRecord.Builder builder = new DBCellRecord.Builder();
/*     */       
/* 265 */       int i1 = k - 20;
/* 266 */       for (int i2 = m; i2 <= n; i2++) {
/* 267 */         if (this._valuesAgg.rowHasCells(i2)) {
/* 268 */           positionTrackingVisitor.setPosition(0);
/* 269 */           this._valuesAgg.visitCellsForRow(i2, positionTrackingVisitor);
/* 270 */           int i3 = positionTrackingVisitor.getPosition();
/* 271 */           j += i3;
/*     */ 
/*     */           
/* 274 */           builder.addCellOffset(i1);
/* 275 */           i1 = i3;
/*     */         } 
/*     */       } 
/*     */       
/* 279 */       paramRecordVisitor.visitRecord((Record)builder.build(j));
/*     */     } 
/* 281 */     for (Record record : this._unknownRecords)
/*     */     {
/* 283 */       paramRecordVisitor.visitRecord(record);
/*     */     }
/*     */   }
/*     */   
/*     */   public Iterator<RowRecord> getIterator() {
/* 288 */     return this._rowRecords.values().iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public int findStartOfRowOutlineGroup(int paramInt) {
/* 293 */     RowRecord rowRecord = getRow(paramInt);
/* 294 */     short s = rowRecord.getOutlineLevel();
/* 295 */     int i = paramInt;
/* 296 */     while (i >= 0 && getRow(i) != null) {
/* 297 */       rowRecord = getRow(i);
/* 298 */       if (rowRecord.getOutlineLevel() < s) {
/* 299 */         return i + 1;
/*     */       }
/* 301 */       i--;
/*     */     } 
/*     */     
/* 304 */     return i + 1;
/*     */   }
/*     */   
/*     */   public int findEndOfRowOutlineGroup(int paramInt) {
/* 308 */     short s = getRow(paramInt).getOutlineLevel();
/*     */     int i;
/* 310 */     for (i = paramInt; i < getLastRowNum() && 
/* 311 */       getRow(i) != null && getRow(i).getOutlineLevel() >= s; i++);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 316 */     return i - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int writeHidden(RowRecord paramRowRecord, int paramInt) {
/* 324 */     int i = paramInt;
/* 325 */     RowRecord rowRecord = paramRowRecord;
/* 326 */     short s = rowRecord.getOutlineLevel();
/* 327 */     while (rowRecord != null && getRow(i).getOutlineLevel() >= s) {
/* 328 */       rowRecord.setZeroHeight(true);
/* 329 */       i++;
/* 330 */       rowRecord = getRow(i);
/*     */     } 
/* 332 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void collapseRow(int paramInt) {
/* 338 */     int i = findStartOfRowOutlineGroup(paramInt);
/* 339 */     RowRecord rowRecord1 = getRow(i);
/*     */ 
/*     */     
/* 342 */     int j = writeHidden(rowRecord1, i);
/*     */     
/* 344 */     RowRecord rowRecord2 = getRow(j);
/* 345 */     if (rowRecord2 == null) {
/* 346 */       rowRecord2 = createRow(j);
/* 347 */       insertRow(rowRecord2);
/*     */     } 
/*     */     
/* 350 */     rowRecord2.setColapsed(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RowRecord createRow(int paramInt) {
/* 361 */     return new RowRecord(paramInt);
/*     */   }
/*     */   
/*     */   public boolean isRowGroupCollapsed(int paramInt) {
/* 365 */     int i = findEndOfRowOutlineGroup(paramInt) + 1;
/*     */     
/* 367 */     return (getRow(i) != null && getRow(i).getColapsed());
/*     */   }
/*     */   
/*     */   public void expandRow(int paramInt) {
/* 371 */     if (paramInt == -1) {
/*     */       return;
/*     */     }
/*     */     
/* 375 */     if (!isRowGroupCollapsed(paramInt)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 380 */     int i = findStartOfRowOutlineGroup(paramInt);
/* 381 */     RowRecord rowRecord = getRow(i);
/*     */ 
/*     */     
/* 384 */     int j = findEndOfRowOutlineGroup(paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 393 */     if (!isRowGroupHiddenByParent(paramInt)) {
/* 394 */       for (int k = i; k <= j; k++) {
/* 395 */         RowRecord rowRecord1 = getRow(k);
/* 396 */         if (rowRecord.getOutlineLevel() == rowRecord1.getOutlineLevel() || !isRowGroupCollapsed(k)) {
/* 397 */           rowRecord1.setZeroHeight(false);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 403 */     getRow(j + 1).setColapsed(false);
/*     */   }
/*     */   public boolean isRowGroupHiddenByParent(int paramInt) {
/*     */     short s1;
/*     */     boolean bool1;
/*     */     short s2;
/*     */     boolean bool2;
/* 410 */     int i = findEndOfRowOutlineGroup(paramInt);
/* 411 */     if (getRow(i + 1) == null) {
/* 412 */       s1 = 0;
/* 413 */       bool1 = false;
/*     */     } else {
/* 415 */       s1 = getRow(i + 1).getOutlineLevel();
/* 416 */       bool1 = getRow(i + 1).getZeroHeight();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 422 */     int j = findStartOfRowOutlineGroup(paramInt);
/* 423 */     if (j - 1 < 0 || getRow(j - 1) == null) {
/* 424 */       s2 = 0;
/* 425 */       bool2 = false;
/*     */     } else {
/* 427 */       s2 = getRow(j - 1).getOutlineLevel();
/* 428 */       bool2 = getRow(j - 1).getZeroHeight();
/*     */     } 
/*     */     
/* 431 */     if (s1 > s2) {
/* 432 */       return bool1;
/*     */     }
/*     */     
/* 435 */     return bool2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<CellValueRecordInterface> getCellValueIterator() {
/* 442 */     return this._valuesAgg.iterator();
/*     */   }
/*     */   
/*     */   public IndexRecord createIndexRecord(int paramInt1, int paramInt2) {
/* 446 */     IndexRecord indexRecord = new IndexRecord();
/* 447 */     indexRecord.setFirstRow(this._firstrow);
/* 448 */     indexRecord.setLastRowAdd1(this._lastrow + 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 456 */     int i = getRowBlockCount();
/*     */     
/* 458 */     int j = IndexRecord.getRecordSizeForBlockCount(i);
/*     */     
/* 460 */     int k = paramInt1 + j + paramInt2;
/*     */     
/* 462 */     for (byte b = 0; b < i; b++) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 467 */       k += getRowBlockSize(b);
/*     */       
/* 469 */       k += this._valuesAgg.getRowCellBlockSize(getStartRowNumberForBlock(b), getEndRowNumberForBlock(b));
/*     */ 
/*     */ 
/*     */       
/* 473 */       indexRecord.addDbcell(k);
/*     */       
/* 475 */       k += 8 + getRowCountForBlock(b) * 2;
/*     */     } 
/* 477 */     return indexRecord;
/*     */   }
/*     */   public void insertCell(CellValueRecordInterface paramCellValueRecordInterface) {
/* 480 */     this._valuesAgg.insertCell(paramCellValueRecordInterface);
/*     */   }
/*     */   public void removeCell(CellValueRecordInterface paramCellValueRecordInterface) {
/* 483 */     if (paramCellValueRecordInterface instanceof FormulaRecordAggregate) {
/* 484 */       ((FormulaRecordAggregate)paramCellValueRecordInterface).notifyFormulaChanging();
/*     */     }
/* 486 */     this._valuesAgg.removeCell(paramCellValueRecordInterface);
/*     */   }
/*     */   public FormulaRecordAggregate createFormula(int paramInt1, int paramInt2) {
/* 489 */     FormulaRecord formulaRecord = new FormulaRecord();
/* 490 */     formulaRecord.setRow(paramInt1);
/* 491 */     formulaRecord.setColumn((short)paramInt2);
/* 492 */     return new FormulaRecordAggregate(formulaRecord, null, this._sharedValueManager);
/*     */   }
/*     */   public void updateFormulasAfterRowShift(FormulaShifter paramFormulaShifter, int paramInt) {
/* 495 */     this._valuesAgg.updateFormulasAfterRowShift(paramFormulaShifter, paramInt);
/*     */   }
/*     */   public DimensionsRecord createDimensions() {
/* 498 */     DimensionsRecord dimensionsRecord = new DimensionsRecord();
/* 499 */     dimensionsRecord.setFirstRow(this._firstrow);
/* 500 */     dimensionsRecord.setLastRow(this._lastrow);
/* 501 */     dimensionsRecord.setFirstCol((short)this._valuesAgg.getFirstCellNum());
/* 502 */     dimensionsRecord.setLastCol((short)this._valuesAgg.getLastCellNum());
/* 503 */     return dimensionsRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\RowRecordsAggregate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */