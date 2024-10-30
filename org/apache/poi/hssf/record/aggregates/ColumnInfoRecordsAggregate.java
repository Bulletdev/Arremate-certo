/*     */ package org.apache.poi.hssf.record.aggregates;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.model.RecordStream;
/*     */ import org.apache.poi.hssf.record.ColumnInfoRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ColumnInfoRecordsAggregate
/*     */   extends RecordAggregate
/*     */   implements Cloneable
/*     */ {
/*     */   private final List<ColumnInfoRecord> records;
/*     */   
/*     */   private static final class CIRComparator
/*     */     implements Comparator<ColumnInfoRecord>
/*     */   {
/*  39 */     public static final Comparator<ColumnInfoRecord> instance = new CIRComparator();
/*     */ 
/*     */ 
/*     */     
/*     */     public int compare(ColumnInfoRecord param1ColumnInfoRecord1, ColumnInfoRecord param1ColumnInfoRecord2) {
/*  44 */       return compareColInfos(param1ColumnInfoRecord1, param1ColumnInfoRecord2);
/*     */     }
/*     */     public static int compareColInfos(ColumnInfoRecord param1ColumnInfoRecord1, ColumnInfoRecord param1ColumnInfoRecord2) {
/*  47 */       return param1ColumnInfoRecord1.getFirstColumn() - param1ColumnInfoRecord2.getFirstColumn();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ColumnInfoRecordsAggregate() {
/*  55 */     this.records = new ArrayList<ColumnInfoRecord>();
/*     */   }
/*     */   public ColumnInfoRecordsAggregate(RecordStream paramRecordStream) {
/*  58 */     this();
/*     */     
/*  60 */     boolean bool = true;
/*  61 */     ColumnInfoRecord columnInfoRecord = null;
/*  62 */     while (paramRecordStream.peekNextClass() == ColumnInfoRecord.class) {
/*  63 */       ColumnInfoRecord columnInfoRecord1 = (ColumnInfoRecord)paramRecordStream.getNext();
/*  64 */       this.records.add(columnInfoRecord1);
/*  65 */       if (columnInfoRecord != null && CIRComparator.compareColInfos(columnInfoRecord, columnInfoRecord1) > 0) {
/*  66 */         bool = false;
/*     */       }
/*  68 */       columnInfoRecord = columnInfoRecord1;
/*     */     } 
/*  70 */     if (this.records.size() < 1) {
/*  71 */       throw new RuntimeException("No column info records found");
/*     */     }
/*  73 */     if (!bool) {
/*  74 */       Collections.sort(this.records, CIRComparator.instance);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ColumnInfoRecordsAggregate clone() {
/*  80 */     ColumnInfoRecordsAggregate columnInfoRecordsAggregate = new ColumnInfoRecordsAggregate();
/*  81 */     for (ColumnInfoRecord columnInfoRecord : this.records) {
/*  82 */       columnInfoRecordsAggregate.records.add(columnInfoRecord.clone());
/*     */     }
/*  84 */     return columnInfoRecordsAggregate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertColumn(ColumnInfoRecord paramColumnInfoRecord) {
/*  91 */     this.records.add(paramColumnInfoRecord);
/*  92 */     Collections.sort(this.records, CIRComparator.instance);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void insertColumn(int paramInt, ColumnInfoRecord paramColumnInfoRecord) {
/* 100 */     this.records.add(paramInt, paramColumnInfoRecord);
/*     */   }
/*     */   
/*     */   int getNumColumns() {
/* 104 */     return this.records.size();
/*     */   }
/*     */   
/*     */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 108 */     int i = this.records.size();
/* 109 */     if (i < 1) {
/*     */       return;
/*     */     }
/* 112 */     ColumnInfoRecord columnInfoRecord = null;
/* 113 */     for (byte b = 0; b < i; b++) {
/* 114 */       ColumnInfoRecord columnInfoRecord1 = this.records.get(b);
/* 115 */       paramRecordVisitor.visitRecord((Record)columnInfoRecord1);
/* 116 */       if (columnInfoRecord != null && CIRComparator.compareColInfos(columnInfoRecord, columnInfoRecord1) > 0)
/*     */       {
/*     */         
/* 119 */         throw new RuntimeException("Column info records are out of order");
/*     */       }
/* 121 */       columnInfoRecord = columnInfoRecord1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int findStartOfColumnOutlineGroup(int paramInt) {
/* 127 */     ColumnInfoRecord columnInfoRecord = this.records.get(paramInt);
/* 128 */     int i = columnInfoRecord.getOutlineLevel();
/* 129 */     int j = paramInt;
/* 130 */     while (j != 0) {
/* 131 */       ColumnInfoRecord columnInfoRecord1 = this.records.get(j - 1);
/* 132 */       if (!columnInfoRecord1.isAdjacentBefore(columnInfoRecord)) {
/*     */         break;
/*     */       }
/* 135 */       if (columnInfoRecord1.getOutlineLevel() < i) {
/*     */         break;
/*     */       }
/* 138 */       j--;
/* 139 */       columnInfoRecord = columnInfoRecord1;
/*     */     } 
/*     */     
/* 142 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   private int findEndOfColumnOutlineGroup(int paramInt) {
/* 147 */     ColumnInfoRecord columnInfoRecord = this.records.get(paramInt);
/* 148 */     int i = columnInfoRecord.getOutlineLevel();
/* 149 */     int j = paramInt;
/* 150 */     while (j < this.records.size() - 1) {
/* 151 */       ColumnInfoRecord columnInfoRecord1 = this.records.get(j + 1);
/* 152 */       if (!columnInfoRecord.isAdjacentBefore(columnInfoRecord1)) {
/*     */         break;
/*     */       }
/* 155 */       if (columnInfoRecord1.getOutlineLevel() < i) {
/*     */         break;
/*     */       }
/* 158 */       j++;
/* 159 */       columnInfoRecord = columnInfoRecord1;
/*     */     } 
/* 161 */     return j;
/*     */   }
/*     */   
/*     */   private ColumnInfoRecord getColInfo(int paramInt) {
/* 165 */     return this.records.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isColumnGroupCollapsed(int paramInt) {
/* 174 */     int i = findEndOfColumnOutlineGroup(paramInt);
/* 175 */     int j = i + 1;
/* 176 */     if (j >= this.records.size()) {
/* 177 */       return false;
/*     */     }
/* 179 */     ColumnInfoRecord columnInfoRecord = getColInfo(j);
/* 180 */     if (!getColInfo(i).isAdjacentBefore(columnInfoRecord)) {
/* 181 */       return false;
/*     */     }
/* 183 */     return columnInfoRecord.getCollapsed();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isColumnGroupHiddenByParent(int paramInt) {
/* 189 */     int i = 0;
/* 190 */     boolean bool1 = false;
/* 191 */     int j = findEndOfColumnOutlineGroup(paramInt);
/* 192 */     if (j < this.records.size()) {
/* 193 */       ColumnInfoRecord columnInfoRecord = getColInfo(j + 1);
/* 194 */       if (getColInfo(j).isAdjacentBefore(columnInfoRecord)) {
/* 195 */         i = columnInfoRecord.getOutlineLevel();
/* 196 */         bool1 = columnInfoRecord.getHidden();
/*     */       } 
/*     */     } 
/*     */     
/* 200 */     int k = 0;
/* 201 */     boolean bool2 = false;
/* 202 */     int m = findStartOfColumnOutlineGroup(paramInt);
/* 203 */     if (m > 0) {
/* 204 */       ColumnInfoRecord columnInfoRecord = getColInfo(m - 1);
/* 205 */       if (columnInfoRecord.isAdjacentBefore(getColInfo(m))) {
/* 206 */         k = columnInfoRecord.getOutlineLevel();
/* 207 */         bool2 = columnInfoRecord.getHidden();
/*     */       } 
/*     */     } 
/* 210 */     if (i > k) {
/* 211 */       return bool1;
/*     */     }
/* 213 */     return bool2;
/*     */   }
/*     */   
/*     */   public void collapseColumn(int paramInt) {
/* 217 */     int i = findColInfoIdx(paramInt, 0);
/* 218 */     if (i == -1) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 223 */     int j = findStartOfColumnOutlineGroup(i);
/* 224 */     ColumnInfoRecord columnInfoRecord = getColInfo(j);
/*     */ 
/*     */     
/* 227 */     int k = setGroupHidden(j, columnInfoRecord.getOutlineLevel(), true);
/*     */ 
/*     */     
/* 230 */     setColumn(k + 1, null, null, null, null, Boolean.TRUE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int setGroupHidden(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 238 */     int i = paramInt1;
/* 239 */     ColumnInfoRecord columnInfoRecord = getColInfo(i);
/* 240 */     while (i < this.records.size()) {
/* 241 */       columnInfoRecord.setHidden(paramBoolean);
/* 242 */       if (i + 1 < this.records.size()) {
/* 243 */         ColumnInfoRecord columnInfoRecord1 = getColInfo(i + 1);
/* 244 */         if (!columnInfoRecord.isAdjacentBefore(columnInfoRecord1)) {
/*     */           break;
/*     */         }
/* 247 */         if (columnInfoRecord1.getOutlineLevel() < paramInt2) {
/*     */           break;
/*     */         }
/* 250 */         columnInfoRecord = columnInfoRecord1;
/*     */       } 
/* 252 */       i++;
/*     */     } 
/* 254 */     return columnInfoRecord.getLastColumn();
/*     */   }
/*     */ 
/*     */   
/*     */   public void expandColumn(int paramInt) {
/* 259 */     int i = findColInfoIdx(paramInt, 0);
/* 260 */     if (i == -1) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 265 */     if (!isColumnGroupCollapsed(i)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 270 */     int j = findStartOfColumnOutlineGroup(i);
/* 271 */     int k = findEndOfColumnOutlineGroup(i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 280 */     ColumnInfoRecord columnInfoRecord = getColInfo(k);
/* 281 */     if (!isColumnGroupHiddenByParent(i)) {
/* 282 */       int m = columnInfoRecord.getOutlineLevel();
/* 283 */       for (int n = j; n <= k; n++) {
/* 284 */         ColumnInfoRecord columnInfoRecord1 = getColInfo(n);
/* 285 */         if (m == columnInfoRecord1.getOutlineLevel()) {
/* 286 */           columnInfoRecord1.setHidden(false);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 291 */     setColumn(columnInfoRecord.getLastColumn() + 1, null, null, null, null, Boolean.FALSE);
/*     */   }
/*     */   
/*     */   private static ColumnInfoRecord copyColInfo(ColumnInfoRecord paramColumnInfoRecord) {
/* 295 */     return paramColumnInfoRecord.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColumn(int paramInt, Short paramShort, Integer paramInteger1, Integer paramInteger2, Boolean paramBoolean1, Boolean paramBoolean2) {
/* 301 */     ColumnInfoRecord columnInfoRecord = null;
/* 302 */     byte b = 0;
/*     */     
/* 304 */     for (b = 0; b < this.records.size(); b++) {
/* 305 */       ColumnInfoRecord columnInfoRecord1 = this.records.get(b);
/* 306 */       if (columnInfoRecord1.containsColumn(paramInt)) {
/* 307 */         columnInfoRecord = columnInfoRecord1;
/*     */         break;
/*     */       } 
/* 310 */       if (columnInfoRecord1.getFirstColumn() > paramInt) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 316 */     if (columnInfoRecord == null) {
/*     */       
/* 318 */       ColumnInfoRecord columnInfoRecord1 = new ColumnInfoRecord();
/*     */       
/* 320 */       columnInfoRecord1.setFirstColumn(paramInt);
/* 321 */       columnInfoRecord1.setLastColumn(paramInt);
/* 322 */       setColumnInfoFields(columnInfoRecord1, paramShort, paramInteger1, paramInteger2, paramBoolean1, paramBoolean2);
/* 323 */       insertColumn(b, columnInfoRecord1);
/* 324 */       attemptMergeColInfoRecords(b);
/*     */       
/*     */       return;
/*     */     } 
/* 328 */     boolean bool1 = (paramShort != null && columnInfoRecord.getXFIndex() != paramShort.shortValue()) ? true : false;
/* 329 */     boolean bool2 = (paramInteger1 != null && columnInfoRecord.getColumnWidth() != paramInteger1.shortValue()) ? true : false;
/* 330 */     boolean bool3 = (paramInteger2 != null && columnInfoRecord.getOutlineLevel() != paramInteger2.intValue()) ? true : false;
/* 331 */     boolean bool4 = (paramBoolean1 != null && columnInfoRecord.getHidden() != paramBoolean1.booleanValue()) ? true : false;
/* 332 */     boolean bool5 = (paramBoolean2 != null && columnInfoRecord.getCollapsed() != paramBoolean2.booleanValue()) ? true : false;
/*     */     
/* 334 */     boolean bool6 = (bool1 || bool2 || bool3 || bool4 || bool5) ? true : false;
/* 335 */     if (!bool6) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 340 */     if (columnInfoRecord.getFirstColumn() == paramInt && columnInfoRecord.getLastColumn() == paramInt) {
/*     */       
/* 342 */       setColumnInfoFields(columnInfoRecord, paramShort, paramInteger1, paramInteger2, paramBoolean1, paramBoolean2);
/* 343 */       attemptMergeColInfoRecords(b);
/*     */       
/*     */       return;
/*     */     } 
/* 347 */     if (columnInfoRecord.getFirstColumn() == paramInt || columnInfoRecord.getLastColumn() == paramInt) {
/*     */ 
/*     */       
/* 350 */       if (columnInfoRecord.getFirstColumn() == paramInt) {
/* 351 */         columnInfoRecord.setFirstColumn(paramInt + 1);
/*     */       } else {
/* 353 */         columnInfoRecord.setLastColumn(paramInt - 1);
/* 354 */         b++;
/*     */       } 
/* 356 */       ColumnInfoRecord columnInfoRecord1 = copyColInfo(columnInfoRecord);
/*     */       
/* 358 */       columnInfoRecord1.setFirstColumn(paramInt);
/* 359 */       columnInfoRecord1.setLastColumn(paramInt);
/* 360 */       setColumnInfoFields(columnInfoRecord1, paramShort, paramInteger1, paramInteger2, paramBoolean1, paramBoolean2);
/*     */       
/* 362 */       insertColumn(b, columnInfoRecord1);
/* 363 */       attemptMergeColInfoRecords(b);
/*     */     } else {
/*     */       
/* 366 */       ColumnInfoRecord columnInfoRecord1 = columnInfoRecord;
/* 367 */       ColumnInfoRecord columnInfoRecord2 = copyColInfo(columnInfoRecord);
/* 368 */       ColumnInfoRecord columnInfoRecord3 = copyColInfo(columnInfoRecord);
/* 369 */       int i = columnInfoRecord.getLastColumn();
/*     */       
/* 371 */       columnInfoRecord1.setLastColumn(paramInt - 1);
/*     */       
/* 373 */       columnInfoRecord2.setFirstColumn(paramInt);
/* 374 */       columnInfoRecord2.setLastColumn(paramInt);
/* 375 */       setColumnInfoFields(columnInfoRecord2, paramShort, paramInteger1, paramInteger2, paramBoolean1, paramBoolean2);
/* 376 */       insertColumn(++b, columnInfoRecord2);
/*     */       
/* 378 */       columnInfoRecord3.setFirstColumn(paramInt + 1);
/* 379 */       columnInfoRecord3.setLastColumn(i);
/* 380 */       insertColumn(++b, columnInfoRecord3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void setColumnInfoFields(ColumnInfoRecord paramColumnInfoRecord, Short paramShort, Integer paramInteger1, Integer paramInteger2, Boolean paramBoolean1, Boolean paramBoolean2) {
/* 391 */     if (paramShort != null) {
/* 392 */       paramColumnInfoRecord.setXFIndex(paramShort.shortValue());
/*     */     }
/* 394 */     if (paramInteger1 != null) {
/* 395 */       paramColumnInfoRecord.setColumnWidth(paramInteger1.intValue());
/*     */     }
/* 397 */     if (paramInteger2 != null) {
/* 398 */       paramColumnInfoRecord.setOutlineLevel(paramInteger2.shortValue());
/*     */     }
/* 400 */     if (paramBoolean1 != null) {
/* 401 */       paramColumnInfoRecord.setHidden(paramBoolean1.booleanValue());
/*     */     }
/* 403 */     if (paramBoolean2 != null) {
/* 404 */       paramColumnInfoRecord.setCollapsed(paramBoolean2.booleanValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private int findColInfoIdx(int paramInt1, int paramInt2) {
/* 409 */     if (paramInt1 < 0) {
/* 410 */       throw new IllegalArgumentException("column parameter out of range: " + paramInt1);
/*     */     }
/* 412 */     if (paramInt2 < 0) {
/* 413 */       throw new IllegalArgumentException("fromIdx parameter out of range: " + paramInt2);
/*     */     }
/*     */     
/* 416 */     for (int i = paramInt2; i < this.records.size(); i++) {
/* 417 */       ColumnInfoRecord columnInfoRecord = getColInfo(i);
/* 418 */       if (columnInfoRecord.containsColumn(paramInt1)) {
/* 419 */         return i;
/*     */       }
/* 421 */       if (columnInfoRecord.getFirstColumn() > paramInt1) {
/*     */         break;
/*     */       }
/*     */     } 
/* 425 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void attemptMergeColInfoRecords(int paramInt) {
/* 433 */     int i = this.records.size();
/* 434 */     if (paramInt < 0 || paramInt >= i) {
/* 435 */       throw new IllegalArgumentException("colInfoIx " + paramInt + " is out of range (0.." + (i - 1) + ")");
/*     */     }
/*     */     
/* 438 */     ColumnInfoRecord columnInfoRecord = getColInfo(paramInt);
/* 439 */     int j = paramInt + 1;
/* 440 */     if (j < i && 
/* 441 */       mergeColInfoRecords(columnInfoRecord, getColInfo(j))) {
/* 442 */       this.records.remove(j);
/*     */     }
/*     */     
/* 445 */     if (paramInt > 0 && 
/* 446 */       mergeColInfoRecords(getColInfo(paramInt - 1), columnInfoRecord)) {
/* 447 */       this.records.remove(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean mergeColInfoRecords(ColumnInfoRecord paramColumnInfoRecord1, ColumnInfoRecord paramColumnInfoRecord2) {
/* 456 */     if (paramColumnInfoRecord1.isAdjacentBefore(paramColumnInfoRecord2) && paramColumnInfoRecord1.formatMatches(paramColumnInfoRecord2)) {
/* 457 */       paramColumnInfoRecord1.setLastColumn(paramColumnInfoRecord2.getLastColumn());
/* 458 */       return true;
/*     */     } 
/* 460 */     return false;
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
/*     */   public void groupColumnRange(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 478 */     int i = 0;
/* 479 */     for (int j = paramInt1; j <= paramInt2; j++) {
/* 480 */       int k = 1;
/* 481 */       int m = findColInfoIdx(j, i);
/* 482 */       if (m != -1) {
/* 483 */         k = getColInfo(m).getOutlineLevel();
/* 484 */         if (paramBoolean) {
/* 485 */           k++;
/*     */         } else {
/* 487 */           k--;
/*     */         } 
/* 489 */         k = Math.max(0, k);
/* 490 */         k = Math.min(7, k);
/* 491 */         i = Math.max(0, m - 1);
/*     */       } 
/* 493 */       setColumn(j, null, null, Integer.valueOf(k), null, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ColumnInfoRecord findColumnInfo(int paramInt) {
/* 502 */     int i = this.records.size();
/* 503 */     for (byte b = 0; b < i; b++) {
/* 504 */       ColumnInfoRecord columnInfoRecord = getColInfo(b);
/* 505 */       if (columnInfoRecord.containsColumn(paramInt)) {
/* 506 */         return columnInfoRecord;
/*     */       }
/*     */     } 
/* 509 */     return null;
/*     */   }
/*     */   public int getMaxOutlineLevel() {
/* 512 */     int i = 0;
/* 513 */     int j = this.records.size();
/* 514 */     for (byte b = 0; b < j; b++) {
/* 515 */       ColumnInfoRecord columnInfoRecord = getColInfo(b);
/* 516 */       i = Math.max(columnInfoRecord.getOutlineLevel(), i);
/*     */     } 
/* 518 */     return i;
/*     */   }
/*     */   public int getOutlineLevel(int paramInt) {
/* 521 */     ColumnInfoRecord columnInfoRecord = findColumnInfo(paramInt);
/* 522 */     if (columnInfoRecord != null) {
/* 523 */       return columnInfoRecord.getOutlineLevel();
/*     */     }
/* 525 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\ColumnInfoRecordsAggregate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */