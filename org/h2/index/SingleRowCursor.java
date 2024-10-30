/*    */ package org.h2.index;
/*    */ 
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.result.Row;
/*    */ import org.h2.result.SearchRow;
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
/*    */ public class SingleRowCursor
/*    */   implements Cursor
/*    */ {
/*    */   private Row row;
/*    */   private boolean end;
/*    */   
/*    */   public SingleRowCursor(Row paramRow) {
/* 25 */     this.row = paramRow;
/*    */   }
/*    */ 
/*    */   
/*    */   public Row get() {
/* 30 */     return this.row;
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchRow getSearchRow() {
/* 35 */     return (SearchRow)this.row;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean next() {
/* 40 */     if (this.row == null || this.end) {
/* 41 */       this.row = null;
/* 42 */       return false;
/*    */     } 
/* 44 */     this.end = true;
/* 45 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean previous() {
/* 50 */     throw DbException.throwInternalError();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\SingleRowCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */