/*    */ package org.apache.poi.hssf.record.aggregates;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.poi.hssf.model.RecordStream;
/*    */ import org.apache.poi.hssf.record.DVALRecord;
/*    */ import org.apache.poi.hssf.record.DVRecord;
/*    */ import org.apache.poi.hssf.record.Record;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class DataValidityTable
/*    */   extends RecordAggregate
/*    */ {
/*    */   private final DVALRecord _headerRec;
/*    */   private final List<DVRecord> _validationList;
/*    */   
/*    */   public DataValidityTable(RecordStream paramRecordStream) {
/* 41 */     this._headerRec = (DVALRecord)paramRecordStream.getNext();
/* 42 */     ArrayList<DVRecord> arrayList = new ArrayList();
/* 43 */     while (paramRecordStream.peekNextClass() == DVRecord.class) {
/* 44 */       arrayList.add((DVRecord)paramRecordStream.getNext());
/*    */     }
/* 46 */     this._validationList = arrayList;
/*    */   }
/*    */   
/*    */   public DataValidityTable() {
/* 50 */     this._headerRec = new DVALRecord();
/* 51 */     this._validationList = new ArrayList<DVRecord>();
/*    */   }
/*    */   
/*    */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 55 */     if (this._validationList.isEmpty()) {
/*    */       return;
/*    */     }
/* 58 */     paramRecordVisitor.visitRecord((Record)this._headerRec);
/* 59 */     for (byte b = 0; b < this._validationList.size(); b++) {
/* 60 */       paramRecordVisitor.visitRecord((Record)this._validationList.get(b));
/*    */     }
/*    */   }
/*    */   
/*    */   public void addDataValidation(DVRecord paramDVRecord) {
/* 65 */     this._validationList.add(paramDVRecord);
/* 66 */     this._headerRec.setDVRecNo(this._validationList.size());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\DataValidityTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */