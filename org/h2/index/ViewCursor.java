/*    */ package org.h2.index;
/*    */ 
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.result.LocalResult;
/*    */ import org.h2.result.Row;
/*    */ import org.h2.result.SearchRow;
/*    */ import org.h2.table.Table;
/*    */ import org.h2.value.Value;
/*    */ import org.h2.value.ValueNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ViewCursor
/*    */   implements Cursor
/*    */ {
/*    */   private final Table table;
/*    */   private final ViewIndex index;
/*    */   private final LocalResult result;
/*    */   private final SearchRow first;
/*    */   private final SearchRow last;
/*    */   private Row current;
/*    */   
/*    */   public ViewCursor(ViewIndex paramViewIndex, LocalResult paramLocalResult, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 29 */     this.table = paramViewIndex.getTable();
/* 30 */     this.index = paramViewIndex;
/* 31 */     this.result = paramLocalResult;
/* 32 */     this.first = paramSearchRow1;
/* 33 */     this.last = paramSearchRow2;
/*    */   }
/*    */ 
/*    */   
/*    */   public Row get() {
/* 38 */     return this.current;
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchRow getSearchRow() {
/* 43 */     return (SearchRow)this.current;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean next() {
/*    */     while (true) {
/* 49 */       boolean bool = this.result.next();
/* 50 */       if (!bool) {
/* 51 */         if (this.index.isRecursive()) {
/* 52 */           this.result.reset();
/*    */         } else {
/* 54 */           this.result.close();
/*    */         } 
/* 56 */         this.current = null;
/* 57 */         return false;
/*    */       } 
/* 59 */       this.current = this.table.getTemplateRow();
/* 60 */       Value[] arrayOfValue = this.result.currentRow(); int i, j;
/* 61 */       for (i = 0, j = this.current.getColumnCount(); i < j; i++) {
/* 62 */         Value value = (Value)((i < arrayOfValue.length) ? arrayOfValue[i] : ValueNull.INSTANCE);
/* 63 */         this.current.setValue(i, value);
/*    */       } 
/*    */       
/* 66 */       if (this.first != null) {
/* 67 */         i = this.index.compareRows((SearchRow)this.current, this.first);
/* 68 */         if (i < 0) {
/*    */           continue;
/*    */         }
/*    */       } 
/* 72 */       if (this.last != null) {
/* 73 */         i = this.index.compareRows((SearchRow)this.current, this.last);
/* 74 */         if (i > 0)
/*    */           continue; 
/*    */       }  break;
/*    */     } 
/* 78 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean previous() {
/* 84 */     throw DbException.throwInternalError();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\ViewCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */