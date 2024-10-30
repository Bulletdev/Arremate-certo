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
/*    */ public final class HorizontalPageBreakRecord
/*    */   extends PageBreakRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 27;
/*    */   
/*    */   public HorizontalPageBreakRecord() {}
/*    */   
/*    */   public HorizontalPageBreakRecord(RecordInputStream paramRecordInputStream) {
/* 41 */     super(paramRecordInputStream);
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 45 */     return 27;
/*    */   }
/*    */ 
/*    */   
/*    */   public PageBreakRecord clone() {
/* 50 */     HorizontalPageBreakRecord horizontalPageBreakRecord = new HorizontalPageBreakRecord();
/* 51 */     Iterator<PageBreakRecord.Break> iterator = getBreaksIterator();
/* 52 */     while (iterator.hasNext()) {
/* 53 */       PageBreakRecord.Break break_ = iterator.next();
/* 54 */       horizontalPageBreakRecord.addBreak(break_.main, break_.subFrom, break_.subTo);
/*    */     } 
/* 56 */     return horizontalPageBreakRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\HorizontalPageBreakRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */