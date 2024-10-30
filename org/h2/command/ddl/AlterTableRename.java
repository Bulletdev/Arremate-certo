/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
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
/*    */ public class AlterTableRename
/*    */   extends SchemaCommand
/*    */ {
/*    */   private boolean ifTableExists;
/*    */   private String oldTableName;
/*    */   private String newTableName;
/*    */   private boolean hidden;
/*    */   
/*    */   public AlterTableRename(Session paramSession, Schema paramSchema) {
/* 29 */     super(paramSession, paramSchema);
/*    */   }
/*    */   
/*    */   public void setIfTableExists(boolean paramBoolean) {
/* 33 */     this.ifTableExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setOldTableName(String paramString) {
/* 37 */     this.oldTableName = paramString;
/*    */   }
/*    */   
/*    */   public void setNewTableName(String paramString) {
/* 41 */     this.newTableName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 46 */     this.session.commit(true);
/* 47 */     Database database = this.session.getDatabase();
/* 48 */     Table table1 = getSchema().findTableOrView(this.session, this.oldTableName);
/* 49 */     if (table1 == null) {
/* 50 */       if (this.ifTableExists) {
/* 51 */         return 0;
/*    */       }
/* 53 */       throw DbException.get(42102, this.oldTableName);
/*    */     } 
/* 55 */     this.session.getUser().checkRight(table1, 15);
/* 56 */     Table table2 = getSchema().findTableOrView(this.session, this.newTableName);
/* 57 */     if (table2 != null && this.hidden && this.newTableName.equals(table1.getName())) {
/* 58 */       if (!table2.isHidden()) {
/* 59 */         table2.setHidden(this.hidden);
/* 60 */         table1.setHidden(true);
/* 61 */         database.updateMeta(this.session, (DbObject)table1);
/*    */       } 
/* 63 */       return 0;
/*    */     } 
/* 65 */     if (table2 != null || this.newTableName.equals(table1.getName())) {
/* 66 */       throw DbException.get(42101, this.newTableName);
/*    */     }
/* 68 */     if (table1.isTemporary()) {
/* 69 */       throw DbException.getUnsupportedException("temp table");
/*    */     }
/* 71 */     database.renameSchemaObject(this.session, (SchemaObject)table1, this.newTableName);
/* 72 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 77 */     return 15;
/*    */   }
/*    */   
/*    */   public void setHidden(boolean paramBoolean) {
/* 81 */     this.hidden = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\AlterTableRename.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */