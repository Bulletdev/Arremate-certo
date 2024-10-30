/*    */ package org.h2.index;
/*    */ 
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.result.ResultInterface;
/*    */ import org.h2.result.Row;
/*    */ import org.h2.result.SearchRow;
/*    */ import org.h2.value.Value;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FunctionCursor
/*    */   implements Cursor
/*    */ {
/*    */   private Session session;
/*    */   private final ResultInterface result;
/*    */   private Value[] values;
/*    */   private Row row;
/*    */   
/*    */   FunctionCursor(Session paramSession, ResultInterface paramResultInterface) {
/* 26 */     this.session = paramSession;
/* 27 */     this.result = paramResultInterface;
/*    */   }
/*    */ 
/*    */   
/*    */   public Row get() {
/* 32 */     if (this.values == null) {
/* 33 */       return null;
/*    */     }
/* 35 */     if (this.row == null) {
/* 36 */       this.row = this.session.createRow(this.values, 1);
/*    */     }
/* 38 */     return this.row;
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchRow getSearchRow() {
/* 43 */     return (SearchRow)get();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean next() {
/* 48 */     this.row = null;
/* 49 */     if (this.result != null && this.result.next()) {
/* 50 */       this.values = this.result.currentRow();
/*    */     } else {
/* 52 */       this.values = null;
/*    */     } 
/* 54 */     return (this.values != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean previous() {
/* 59 */     throw DbException.throwInternalError();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\FunctionCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */