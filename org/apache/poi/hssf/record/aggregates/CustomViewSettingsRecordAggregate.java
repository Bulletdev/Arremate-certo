/*    */ package org.apache.poi.hssf.record.aggregates;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.poi.hssf.model.RecordStream;
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
/*    */ 
/*    */ 
/*    */ public final class CustomViewSettingsRecordAggregate
/*    */   extends RecordAggregate
/*    */ {
/*    */   private final Record _begin;
/*    */   private final Record _end;
/*    */   private final List<RecordBase> _recs;
/*    */   private PageSettingsBlock _psBlock;
/*    */   
/*    */   public CustomViewSettingsRecordAggregate(RecordStream paramRecordStream) {
/* 41 */     this._begin = paramRecordStream.getNext();
/* 42 */     if (this._begin.getSid() != 426) {
/* 43 */       throw new IllegalStateException("Bad begin record");
/*    */     }
/* 45 */     ArrayList<PageSettingsBlock> arrayList = new ArrayList();
/* 46 */     while (paramRecordStream.peekNextSid() != 427) {
/* 47 */       if (PageSettingsBlock.isComponentRecord(paramRecordStream.peekNextSid())) {
/* 48 */         if (this._psBlock != null) {
/* 49 */           if (paramRecordStream.peekNextSid() == 2204) {
/*    */             
/* 51 */             this._psBlock.addLateHeaderFooter((HeaderFooterRecord)paramRecordStream.getNext());
/*    */             continue;
/*    */           } 
/* 54 */           throw new IllegalStateException("Found more than one PageSettingsBlock in chart sub-stream, had sid: " + paramRecordStream.peekNextSid());
/*    */         } 
/*    */         
/* 57 */         this._psBlock = new PageSettingsBlock(paramRecordStream);
/* 58 */         arrayList.add(this._psBlock);
/*    */         continue;
/*    */       } 
/* 61 */       arrayList.add(paramRecordStream.getNext());
/*    */     } 
/* 63 */     this._recs = (List)arrayList;
/* 64 */     this._end = paramRecordStream.getNext();
/* 65 */     if (this._end.getSid() != 427) {
/* 66 */       throw new IllegalStateException("Bad custom view settings end record");
/*    */     }
/*    */   }
/*    */   
/*    */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 71 */     if (this._recs.isEmpty()) {
/*    */       return;
/*    */     }
/* 74 */     paramRecordVisitor.visitRecord(this._begin);
/* 75 */     for (byte b = 0; b < this._recs.size(); b++) {
/* 76 */       RecordBase recordBase = this._recs.get(b);
/* 77 */       if (recordBase instanceof RecordAggregate) {
/* 78 */         ((RecordAggregate)recordBase).visitContainedRecords(paramRecordVisitor);
/*    */       } else {
/* 80 */         paramRecordVisitor.visitRecord((Record)recordBase);
/*    */       } 
/*    */     } 
/* 83 */     paramRecordVisitor.visitRecord(this._end);
/*    */   }
/*    */   
/*    */   public static boolean isBeginRecord(int paramInt) {
/* 87 */     return (paramInt == 426);
/*    */   }
/*    */   
/*    */   public void append(RecordBase paramRecordBase) {
/* 91 */     this._recs.add(paramRecordBase);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\CustomViewSettingsRecordAggregate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */