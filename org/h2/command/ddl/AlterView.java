/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.table.Table;
/*    */ import org.h2.table.TableView;
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
/*    */ public class AlterView
/*    */   extends DefineCommand
/*    */ {
/*    */   private boolean ifExists;
/*    */   private TableView view;
/*    */   
/*    */   public AlterView(Session paramSession) {
/* 24 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 28 */     this.ifExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setView(TableView paramTableView) {
/* 32 */     this.view = paramTableView;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 37 */     this.session.commit(true);
/* 38 */     if (this.view == null && this.ifExists) {
/* 39 */       return 0;
/*    */     }
/* 41 */     this.session.getUser().checkRight((Table)this.view, 15);
/* 42 */     DbException dbException = this.view.recompile(this.session, false, true);
/* 43 */     if (dbException != null) {
/* 44 */       throw dbException;
/*    */     }
/* 46 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 51 */     return 20;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\AlterView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */