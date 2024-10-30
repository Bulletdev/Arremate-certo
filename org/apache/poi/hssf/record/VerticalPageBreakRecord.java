/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import java.util.Iterator;
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
/*    */ 
/*    */ 
/*    */ public final class VerticalPageBreakRecord
/*    */   extends PageBreakRecord
/*    */ {
/*    */   public static final short sid = 26;
/*    */   
/*    */   public VerticalPageBreakRecord() {}
/*    */   
/*    */   public VerticalPageBreakRecord(RecordInputStream paramRecordInputStream) {
/* 42 */     super(paramRecordInputStream);
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 46 */     return 26;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 50 */     VerticalPageBreakRecord verticalPageBreakRecord = new VerticalPageBreakRecord();
/* 51 */     Iterator<PageBreakRecord.Break> iterator = getBreaksIterator();
/* 52 */     while (iterator.hasNext()) {
/* 53 */       PageBreakRecord.Break break_ = iterator.next();
/* 54 */       verticalPageBreakRecord.addBreak(break_.main, break_.subFrom, break_.subTo);
/*    */     } 
/* 56 */     return verticalPageBreakRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\VerticalPageBreakRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */