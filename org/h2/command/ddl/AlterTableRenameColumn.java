/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.DbObject;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.expression.Expression;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.schema.Schema;
/*    */ import org.h2.table.Column;
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
/*    */ public class AlterTableRenameColumn
/*    */   extends SchemaCommand
/*    */ {
/*    */   private boolean ifTableExists;
/*    */   private String tableName;
/*    */   private String oldName;
/*    */   private String newName;
/*    */   
/*    */   public AlterTableRenameColumn(Session paramSession, Schema paramSchema) {
/* 32 */     super(paramSession, paramSchema);
/*    */   }
/*    */   
/*    */   public void setIfTableExists(boolean paramBoolean) {
/* 36 */     this.ifTableExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setTableName(String paramString) {
/* 40 */     this.tableName = paramString;
/*    */   }
/*    */   
/*    */   public void setOldColumnName(String paramString) {
/* 44 */     this.oldName = paramString;
/*    */   }
/*    */   
/*    */   public void setNewColumnName(String paramString) {
/* 48 */     this.newName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 53 */     this.session.commit(true);
/* 54 */     Database database = this.session.getDatabase();
/* 55 */     Table table = getSchema().findTableOrView(this.session, this.tableName);
/* 56 */     if (table == null) {
/* 57 */       if (this.ifTableExists) {
/* 58 */         return 0;
/*    */       }
/* 60 */       throw DbException.get(42102, this.tableName);
/*    */     } 
/* 62 */     Column column = table.getColumn(this.oldName);
/* 63 */     this.session.getUser().checkRight(table, 15);
/* 64 */     table.checkSupportAlter();
/*    */ 
/*    */     
/* 67 */     Expression expression = column.getCheckConstraint(this.session, this.newName);
/* 68 */     table.renameColumn(column, this.newName);
/* 69 */     column.removeCheckConstraint();
/* 70 */     column.addCheckConstraint(this.session, expression);
/* 71 */     table.setModified();
/* 72 */     database.updateMeta(this.session, (DbObject)table);
/* 73 */     for (DbObject dbObject : table.getChildren()) {
/* 74 */       if (dbObject.getCreateSQL() != null) {
/* 75 */         database.updateMeta(this.session, dbObject);
/*    */       }
/*    */     } 
/* 78 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 83 */     return 16;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\AlterTableRenameColumn.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */