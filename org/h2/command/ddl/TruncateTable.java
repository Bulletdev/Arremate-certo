/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.table.Table;
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
/*    */ public class TruncateTable
/*    */   extends DefineCommand
/*    */ {
/*    */   private Table table;
/*    */   
/*    */   public TruncateTable(Session paramSession) {
/* 24 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setTable(Table paramTable) {
/* 28 */     this.table = paramTable;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 33 */     this.session.commit(true);
/* 34 */     if (!this.table.canTruncate()) {
/* 35 */       throw DbException.get(90106, this.table.getSQL());
/*    */     }
/* 37 */     this.session.getUser().checkRight(this.table, 2);
/* 38 */     this.table.lock(this.session, true, true);
/* 39 */     this.table.truncate(this.session);
/* 40 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 45 */     return 53;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\TruncateTable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */