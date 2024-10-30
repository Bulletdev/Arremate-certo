/*    */ package org.apache.poi.hssf.model;
/*    */ 
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RecordStream
/*    */ {
/*    */   private final List<Record> _list;
/*    */   private int _nextIndex;
/*    */   private int _countRead;
/*    */   private final int _endIx;
/*    */   
/*    */   public RecordStream(List<Record> paramList, int paramInt1, int paramInt2) {
/* 41 */     this._list = paramList;
/* 42 */     this._nextIndex = paramInt1;
/* 43 */     this._endIx = paramInt2;
/* 44 */     this._countRead = 0;
/*    */   }
/*    */   
/*    */   public RecordStream(List<Record> paramList, int paramInt) {
/* 48 */     this(paramList, paramInt, paramList.size());
/*    */   }
/*    */   
/*    */   public boolean hasNext() {
/* 52 */     return (this._nextIndex < this._endIx);
/*    */   }
/*    */   
/*    */   public Record getNext() {
/* 56 */     if (!hasNext()) {
/* 57 */       throw new RuntimeException("Attempt to read past end of record stream");
/*    */     }
/* 59 */     this._countRead++;
/* 60 */     return this._list.get(this._nextIndex++);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<? extends Record> peekNextClass() {
/* 67 */     if (!hasNext()) {
/* 68 */       return null;
/*    */     }
/* 70 */     return (Class)((Record)this._list.get(this._nextIndex)).getClass();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int peekNextSid() {
/* 77 */     if (!hasNext()) {
/* 78 */       return -1;
/*    */     }
/* 80 */     return ((Record)this._list.get(this._nextIndex)).getSid();
/*    */   }
/*    */   
/*    */   public int getCountRead() {
/* 84 */     return this._countRead;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\model\RecordStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */