/*    */ package org.apache.poi.hssf.record.aggregates;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.poi.hssf.model.RecordStream;
/*    */ import org.apache.poi.hssf.record.CFHeader12Record;
/*    */ import org.apache.poi.hssf.record.CFHeaderRecord;
/*    */ import org.apache.poi.ss.formula.FormulaShifter;
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
/*    */ public final class ConditionalFormattingTable
/*    */   extends RecordAggregate
/*    */ {
/*    */   private final List<CFRecordsAggregate> _cfHeaders;
/*    */   
/*    */   public ConditionalFormattingTable() {
/* 40 */     this._cfHeaders = new ArrayList<CFRecordsAggregate>();
/*    */   }
/*    */ 
/*    */   
/*    */   public ConditionalFormattingTable(RecordStream paramRecordStream) {
/* 45 */     ArrayList<CFRecordsAggregate> arrayList = new ArrayList();
/* 46 */     while (paramRecordStream.peekNextClass() == CFHeaderRecord.class || paramRecordStream.peekNextClass() == CFHeader12Record.class)
/*    */     {
/* 48 */       arrayList.add(CFRecordsAggregate.createCFAggregate(paramRecordStream));
/*    */     }
/* 50 */     this._cfHeaders = arrayList;
/*    */   }
/*    */   
/*    */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 54 */     for (CFRecordsAggregate cFRecordsAggregate : this._cfHeaders) {
/* 55 */       cFRecordsAggregate.visitContainedRecords(paramRecordVisitor);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int add(CFRecordsAggregate paramCFRecordsAggregate) {
/* 63 */     paramCFRecordsAggregate.getHeader().setID(this._cfHeaders.size());
/* 64 */     this._cfHeaders.add(paramCFRecordsAggregate);
/* 65 */     return this._cfHeaders.size() - 1;
/*    */   }
/*    */   
/*    */   public int size() {
/* 69 */     return this._cfHeaders.size();
/*    */   }
/*    */   
/*    */   public CFRecordsAggregate get(int paramInt) {
/* 73 */     checkIndex(paramInt);
/* 74 */     return this._cfHeaders.get(paramInt);
/*    */   }
/*    */   
/*    */   public void remove(int paramInt) {
/* 78 */     checkIndex(paramInt);
/* 79 */     this._cfHeaders.remove(paramInt);
/*    */   }
/*    */   
/*    */   private void checkIndex(int paramInt) {
/* 83 */     if (paramInt < 0 || paramInt >= this._cfHeaders.size()) {
/* 84 */       throw new IllegalArgumentException("Specified CF index " + paramInt + " is outside the allowable range (0.." + (this._cfHeaders.size() - 1) + ")");
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateFormulasAfterCellShift(FormulaShifter paramFormulaShifter, int paramInt) {
/* 90 */     for (byte b = 0; b < this._cfHeaders.size(); b++) {
/* 91 */       CFRecordsAggregate cFRecordsAggregate = this._cfHeaders.get(b);
/* 92 */       boolean bool = cFRecordsAggregate.updateFormulasAfterCellShift(paramFormulaShifter, paramInt);
/* 93 */       if (!bool) {
/* 94 */         this._cfHeaders.remove(b);
/* 95 */         b--;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\ConditionalFormattingTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */