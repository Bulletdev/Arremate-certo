/*     */ package org.apache.poi.hssf.record.aggregates;
/*     */ 
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class RecordAggregate
/*     */   extends RecordBase
/*     */ {
/*     */   public abstract void visitContainedRecords(RecordVisitor paramRecordVisitor);
/*     */   
/*     */   public final int serialize(int paramInt, byte[] paramArrayOfbyte) {
/*  41 */     SerializingRecordVisitor serializingRecordVisitor = new SerializingRecordVisitor(paramArrayOfbyte, paramInt);
/*  42 */     visitContainedRecords(serializingRecordVisitor);
/*  43 */     return serializingRecordVisitor.countBytesWritten();
/*     */   }
/*     */   public int getRecordSize() {
/*  46 */     RecordSizingVisitor recordSizingVisitor = new RecordSizingVisitor();
/*  47 */     visitContainedRecords(recordSizingVisitor);
/*  48 */     return recordSizingVisitor.getTotalSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface RecordVisitor
/*     */   {
/*     */     void visitRecord(Record param1Record);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class SerializingRecordVisitor
/*     */     implements RecordVisitor
/*     */   {
/*     */     private final byte[] _data;
/*     */     private final int _startOffset;
/*     */     private int _countBytesWritten;
/*     */     
/*     */     public SerializingRecordVisitor(byte[] param1ArrayOfbyte, int param1Int) {
/*  66 */       this._data = param1ArrayOfbyte;
/*  67 */       this._startOffset = param1Int;
/*  68 */       this._countBytesWritten = 0;
/*     */     }
/*     */     public int countBytesWritten() {
/*  71 */       return this._countBytesWritten;
/*     */     }
/*     */     public void visitRecord(Record param1Record) {
/*  74 */       int i = this._startOffset + this._countBytesWritten;
/*  75 */       this._countBytesWritten += param1Record.serialize(i, this._data);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class RecordSizingVisitor
/*     */     implements RecordVisitor
/*     */   {
/*  83 */     private int _totalSize = 0;
/*     */     
/*     */     public int getTotalSize() {
/*  86 */       return this._totalSize;
/*     */     }
/*     */     public void visitRecord(Record param1Record) {
/*  89 */       this._totalSize += param1Record.getRecordSize();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class PositionTrackingVisitor
/*     */     implements RecordVisitor
/*     */   {
/*     */     private final RecordAggregate.RecordVisitor _rv;
/*     */     private int _position;
/*     */     
/*     */     public PositionTrackingVisitor(RecordAggregate.RecordVisitor param1RecordVisitor, int param1Int) {
/* 101 */       this._rv = param1RecordVisitor;
/* 102 */       this._position = param1Int;
/*     */     }
/*     */     public void visitRecord(Record param1Record) {
/* 105 */       this._position += param1Record.getRecordSize();
/* 106 */       this._rv.visitRecord(param1Record);
/*     */     }
/*     */     public void setPosition(int param1Int) {
/* 109 */       this._position = param1Int;
/*     */     }
/*     */     public int getPosition() {
/* 112 */       return this._position;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\RecordAggregate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */