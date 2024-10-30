/*    */ package org.apache.poi.hssf.record.aggregates;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.poi.hssf.model.RecordStream;
/*    */ import org.apache.poi.hssf.record.BOFRecord;
/*    */ import org.apache.poi.hssf.record.EOFRecord;
/*    */ import org.apache.poi.hssf.record.HeaderFooterRecord;
/*    */ import org.apache.poi.hssf.record.Record;
/*    */ import org.apache.poi.hssf.record.RecordBase;
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
/*    */ public final class ChartSubstreamRecordAggregate
/*    */   extends RecordAggregate
/*    */ {
/*    */   private final BOFRecord _bofRec;
/*    */   private final List<RecordBase> _recs;
/*    */   private PageSettingsBlock _psBlock;
/*    */   
/*    */   public ChartSubstreamRecordAggregate(RecordStream paramRecordStream) {
/* 40 */     this._bofRec = (BOFRecord)paramRecordStream.getNext();
/* 41 */     ArrayList<PageSettingsBlock> arrayList = new ArrayList();
/* 42 */     while (paramRecordStream.peekNextClass() != EOFRecord.class) {
/* 43 */       if (PageSettingsBlock.isComponentRecord(paramRecordStream.peekNextSid())) {
/* 44 */         if (this._psBlock != null) {
/* 45 */           if (paramRecordStream.peekNextSid() == 2204) {
/*    */             
/* 47 */             this._psBlock.addLateHeaderFooter((HeaderFooterRecord)paramRecordStream.getNext());
/*    */             continue;
/*    */           } 
/* 50 */           throw new IllegalStateException("Found more than one PageSettingsBlock in chart sub-stream, had sid: " + paramRecordStream.peekNextSid());
/*    */         } 
/*    */         
/* 53 */         this._psBlock = new PageSettingsBlock(paramRecordStream);
/* 54 */         arrayList.add(this._psBlock);
/*    */         continue;
/*    */       } 
/* 57 */       arrayList.add(paramRecordStream.getNext());
/*    */     } 
/* 59 */     this._recs = (List)arrayList;
/* 60 */     Record record = paramRecordStream.getNext();
/* 61 */     if (!(record instanceof EOFRecord)) {
/* 62 */       throw new IllegalStateException("Bad chart EOF");
/*    */     }
/*    */   }
/*    */   
/*    */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 67 */     if (this._recs.isEmpty()) {
/*    */       return;
/*    */     }
/* 70 */     paramRecordVisitor.visitRecord((Record)this._bofRec);
/* 71 */     for (byte b = 0; b < this._recs.size(); b++) {
/* 72 */       RecordBase recordBase = this._recs.get(b);
/* 73 */       if (recordBase instanceof RecordAggregate) {
/* 74 */         ((RecordAggregate)recordBase).visitContainedRecords(paramRecordVisitor);
/*    */       } else {
/* 76 */         paramRecordVisitor.visitRecord((Record)recordBase);
/*    */       } 
/*    */     } 
/* 79 */     paramRecordVisitor.visitRecord((Record)EOFRecord.instance);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\ChartSubstreamRecordAggregate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */