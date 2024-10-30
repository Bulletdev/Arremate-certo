/*    */ package org.h2.index;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.result.Row;
/*    */ import org.h2.result.SearchRow;
/*    */ import org.h2.table.RegularTable;
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
/*    */ public class NonUniqueHashCursor
/*    */   implements Cursor
/*    */ {
/*    */   private final Session session;
/*    */   private final ArrayList<Long> positions;
/*    */   private final RegularTable tableData;
/* 25 */   private int index = -1;
/*    */ 
/*    */   
/*    */   public NonUniqueHashCursor(Session paramSession, RegularTable paramRegularTable, ArrayList<Long> paramArrayList) {
/* 29 */     this.session = paramSession;
/* 30 */     this.tableData = paramRegularTable;
/* 31 */     this.positions = paramArrayList;
/*    */   }
/*    */ 
/*    */   
/*    */   public Row get() {
/* 36 */     if (this.index < 0 || this.index >= this.positions.size()) {
/* 37 */       return null;
/*    */     }
/* 39 */     return this.tableData.getRow(this.session, ((Long)this.positions.get(this.index)).longValue());
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchRow getSearchRow() {
/* 44 */     return (SearchRow)get();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean next() {
/* 49 */     return (this.positions != null && ++this.index < this.positions.size());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean previous() {
/* 54 */     return (this.positions != null && --this.index >= 0);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\NonUniqueHashCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */