/*     */ package org.apache.poi.hssf.record.aggregates;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.model.RecordStream;
/*     */ import org.apache.poi.hssf.record.MergeCellsRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.ss.util.CellRangeAddressList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MergedCellsTable
/*     */   extends RecordAggregate
/*     */ {
/*  33 */   private static int MAX_MERGED_REGIONS = 1027;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   private final List<CellRangeAddress> _mergedRegions = new ArrayList<CellRangeAddress>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void read(RecordStream paramRecordStream) {
/*  49 */     List<CellRangeAddress> list = this._mergedRegions;
/*  50 */     while (paramRecordStream.peekNextClass() == MergeCellsRecord.class) {
/*  51 */       MergeCellsRecord mergeCellsRecord = (MergeCellsRecord)paramRecordStream.getNext();
/*  52 */       short s = mergeCellsRecord.getNumAreas();
/*  53 */       for (byte b = 0; b < s; b++) {
/*  54 */         CellRangeAddress cellRangeAddress = mergeCellsRecord.getAreaAt(b);
/*  55 */         list.add(cellRangeAddress);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/*  62 */     int i = this._mergedRegions.size();
/*  63 */     if (i < 1)
/*     */     {
/*  65 */       return 0;
/*     */     }
/*  67 */     int j = i / MAX_MERGED_REGIONS;
/*  68 */     int k = i % MAX_MERGED_REGIONS;
/*     */     
/*  70 */     return j * (4 + CellRangeAddressList.getEncodedSize(MAX_MERGED_REGIONS)) + 4 + CellRangeAddressList.getEncodedSize(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor) {
/*  77 */     int i = this._mergedRegions.size();
/*  78 */     if (i < 1) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  83 */     int j = i / MAX_MERGED_REGIONS;
/*  84 */     int k = i % MAX_MERGED_REGIONS;
/*  85 */     CellRangeAddress[] arrayOfCellRangeAddress = new CellRangeAddress[i];
/*  86 */     this._mergedRegions.toArray(arrayOfCellRangeAddress);
/*     */     int m;
/*  88 */     for (m = 0; m < j; m++) {
/*  89 */       int n = m * MAX_MERGED_REGIONS;
/*  90 */       paramRecordVisitor.visitRecord((Record)new MergeCellsRecord(arrayOfCellRangeAddress, n, MAX_MERGED_REGIONS));
/*     */     } 
/*  92 */     if (k > 0) {
/*  93 */       m = j * MAX_MERGED_REGIONS;
/*  94 */       paramRecordVisitor.visitRecord((Record)new MergeCellsRecord(arrayOfCellRangeAddress, m, k));
/*     */     } 
/*     */   }
/*     */   public void addRecords(MergeCellsRecord[] paramArrayOfMergeCellsRecord) {
/*  98 */     for (byte b = 0; b < paramArrayOfMergeCellsRecord.length; b++) {
/*  99 */       addMergeCellsRecord(paramArrayOfMergeCellsRecord[b]);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addMergeCellsRecord(MergeCellsRecord paramMergeCellsRecord) {
/* 104 */     short s = paramMergeCellsRecord.getNumAreas();
/* 105 */     for (byte b = 0; b < s; b++) {
/* 106 */       CellRangeAddress cellRangeAddress = paramMergeCellsRecord.getAreaAt(b);
/* 107 */       this._mergedRegions.add(cellRangeAddress);
/*     */     } 
/*     */   }
/*     */   
/*     */   public CellRangeAddress get(int paramInt) {
/* 112 */     checkIndex(paramInt);
/* 113 */     return this._mergedRegions.get(paramInt);
/*     */   }
/*     */   
/*     */   public void remove(int paramInt) {
/* 117 */     checkIndex(paramInt);
/* 118 */     this._mergedRegions.remove(paramInt);
/*     */   }
/*     */   
/*     */   private void checkIndex(int paramInt) {
/* 122 */     if (paramInt < 0 || paramInt >= this._mergedRegions.size()) {
/* 123 */       throw new IllegalArgumentException("Specified CF index " + paramInt + " is outside the allowable range (0.." + (this._mergedRegions.size() - 1) + ")");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void addArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 129 */     this._mergedRegions.add(new CellRangeAddress(paramInt1, paramInt3, paramInt2, paramInt4));
/*     */   }
/*     */   
/*     */   public int getNumberOfMergedRegions() {
/* 133 */     return this._mergedRegions.size();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\MergedCellsTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */