/*    */ package org.h2.index;
/*    */ 
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.result.Row;
/*    */ import org.h2.result.SearchRow;
/*    */ import org.h2.value.Value;
/*    */ import org.h2.value.ValueLong;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RangeCursor
/*    */   implements Cursor
/*    */ {
/*    */   private Session session;
/*    */   private boolean beforeFirst;
/*    */   private long current;
/*    */   private Row currentRow;
/*    */   private final long start;
/*    */   private final long end;
/*    */   private final long step;
/*    */   
/*    */   RangeCursor(Session paramSession, long paramLong1, long paramLong2) {
/* 27 */     this(paramSession, paramLong1, paramLong2, 1L);
/*    */   }
/*    */   
/*    */   RangeCursor(Session paramSession, long paramLong1, long paramLong2, long paramLong3) {
/* 31 */     this.session = paramSession;
/* 32 */     this.start = paramLong1;
/* 33 */     this.end = paramLong2;
/* 34 */     this.step = paramLong3;
/* 35 */     this.beforeFirst = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public Row get() {
/* 40 */     return this.currentRow;
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchRow getSearchRow() {
/* 45 */     return (SearchRow)this.currentRow;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean next() {
/* 50 */     if (this.beforeFirst) {
/* 51 */       this.beforeFirst = false;
/* 52 */       this.current = this.start;
/*    */     } else {
/* 54 */       this.current += this.step;
/*    */     } 
/* 56 */     this.currentRow = this.session.createRow(new Value[] { (Value)ValueLong.get(this.current) }, 1);
/* 57 */     return (this.step > 0L) ? ((this.current <= this.end)) : ((this.current >= this.end));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean previous() {
/* 62 */     throw DbException.throwInternalError();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\RangeCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */