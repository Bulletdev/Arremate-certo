/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.DbObject;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.schema.Schema;
/*    */ import org.h2.schema.SchemaObject;
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
/*    */ 
/*    */ public class DropView
/*    */   extends SchemaCommand
/*    */ {
/*    */   private String viewName;
/*    */   private boolean ifExists;
/*    */   private int dropAction;
/*    */   
/*    */   public DropView(Session paramSession, Schema paramSchema) {
/* 30 */     super(paramSession, paramSchema);
/* 31 */     this.dropAction = (paramSession.getDatabase().getSettings()).dropRestrict ? 0 : 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 37 */     this.ifExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setDropAction(int paramInt) {
/* 41 */     this.dropAction = paramInt;
/*    */   }
/*    */   
/*    */   public void setViewName(String paramString) {
/* 45 */     this.viewName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 50 */     this.session.commit(true);
/* 51 */     Table table = getSchema().findTableOrView(this.session, this.viewName);
/* 52 */     if (table == null) {
/* 53 */       if (!this.ifExists) {
/* 54 */         throw DbException.get(90037, this.viewName);
/*    */       }
/*    */     } else {
/* 57 */       if (!"VIEW".equals(table.getTableType())) {
/* 58 */         throw DbException.get(90037, this.viewName);
/*    */       }
/* 60 */       this.session.getUser().checkRight(table, 15);
/*    */       
/* 62 */       if (this.dropAction == 0) {
/* 63 */         for (DbObject dbObject : table.getChildren()) {
/* 64 */           if (dbObject instanceof org.h2.table.TableView) {
/* 65 */             throw DbException.get(90107, new String[] { this.viewName, dbObject.getName() });
/*    */           }
/*    */         } 
/*    */       }
/*    */       
/* 70 */       table.lock(this.session, true, true);
/* 71 */       this.session.getDatabase().removeSchemaObject(this.session, (SchemaObject)table);
/*    */     } 
/* 73 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 78 */     return 48;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */