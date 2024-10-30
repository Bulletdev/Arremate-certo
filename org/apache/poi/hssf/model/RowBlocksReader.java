/*     */ package org.apache.poi.hssf.model;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.record.ArrayRecord;
/*     */ import org.apache.poi.hssf.record.FormulaRecord;
/*     */ import org.apache.poi.hssf.record.MergeCellsRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.SharedFormulaRecord;
/*     */ import org.apache.poi.hssf.record.TableRecord;
/*     */ import org.apache.poi.hssf.record.aggregates.SharedValueManager;
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
/*     */ public final class RowBlocksReader
/*     */ {
/*     */   private final List<Record> _plainRecords;
/*     */   private final SharedValueManager _sfm;
/*     */   private final MergeCellsRecord[] _mergedCellsRecords;
/*     */   
/*     */   public RowBlocksReader(RecordStream paramRecordStream) {
/*  50 */     ArrayList<Record> arrayList1 = new ArrayList();
/*  51 */     ArrayList<Record> arrayList2 = new ArrayList();
/*  52 */     ArrayList<CellReference> arrayList = new ArrayList();
/*  53 */     ArrayList<Record> arrayList3 = new ArrayList();
/*  54 */     ArrayList<Record> arrayList4 = new ArrayList();
/*  55 */     ArrayList<Record> arrayList5 = new ArrayList();
/*     */     
/*  57 */     FormulaRecord formulaRecord = null;
/*  58 */     while (!RecordOrderer.isEndOfRowBlock(paramRecordStream.peekNextSid())) {
/*     */       ArrayList<Record> arrayList6;
/*     */       
/*     */       FormulaRecord formulaRecord1;
/*     */       
/*  63 */       if (!paramRecordStream.hasNext()) {
/*  64 */         throw new RuntimeException("Failed to find end of row/cell records");
/*     */       }
/*     */       
/*  67 */       Record record2 = paramRecordStream.getNext();
/*     */       
/*  69 */       switch (record2.getSid()) { case 229:
/*  70 */           arrayList6 = arrayList5; break;
/*  71 */         case 1212: arrayList6 = arrayList2;
/*  72 */           if (!(formulaRecord instanceof FormulaRecord)) {
/*  73 */             throw new RuntimeException("Shared formula record should follow a FormulaRecord");
/*     */           }
/*  75 */           formulaRecord1 = formulaRecord;
/*  76 */           arrayList.add(new CellReference(formulaRecord1.getRow(), formulaRecord1.getColumn())); break;
/*     */         case 545:
/*  78 */           arrayList6 = arrayList3; break;
/*  79 */         case 566: arrayList6 = arrayList4; break;
/*  80 */         default: arrayList6 = arrayList1; break; }
/*     */       
/*  82 */       arrayList6.add(record2);
/*  83 */       Record record1 = record2;
/*     */     } 
/*  85 */     SharedFormulaRecord[] arrayOfSharedFormulaRecord = new SharedFormulaRecord[arrayList2.size()];
/*  86 */     CellReference[] arrayOfCellReference = new CellReference[arrayList.size()];
/*  87 */     ArrayRecord[] arrayOfArrayRecord = new ArrayRecord[arrayList3.size()];
/*  88 */     TableRecord[] arrayOfTableRecord = new TableRecord[arrayList4.size()];
/*  89 */     arrayList2.toArray(arrayOfSharedFormulaRecord);
/*  90 */     arrayList.toArray(arrayOfCellReference);
/*  91 */     arrayList3.toArray(arrayOfArrayRecord);
/*  92 */     arrayList4.toArray(arrayOfTableRecord);
/*     */     
/*  94 */     this._plainRecords = arrayList1;
/*  95 */     this._sfm = SharedValueManager.create(arrayOfSharedFormulaRecord, arrayOfCellReference, arrayOfArrayRecord, arrayOfTableRecord);
/*  96 */     this._mergedCellsRecords = new MergeCellsRecord[arrayList5.size()];
/*  97 */     arrayList5.toArray(this._mergedCellsRecords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MergeCellsRecord[] getLooseMergedCells() {
/* 106 */     return this._mergedCellsRecords;
/*     */   }
/*     */   
/*     */   public SharedValueManager getSharedFormulaManager() {
/* 110 */     return this._sfm;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RecordStream getPlainRecordStream() {
/* 117 */     return new RecordStream(this._plainRecords, 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\model\RowBlocksReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */