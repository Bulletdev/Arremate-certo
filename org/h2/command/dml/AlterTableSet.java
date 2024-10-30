/*    */ package org.h2.command.dml;
/*    */ 
/*    */ import org.h2.command.ddl.SchemaCommand;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.schema.Schema;
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
/*    */ public class AlterTableSet
/*    */   extends SchemaCommand
/*    */ {
/*    */   private boolean ifTableExists;
/*    */   private String tableName;
/*    */   private final int type;
/*    */   private final boolean value;
/*    */   private boolean checkExisting;
/*    */   
/*    */   public AlterTableSet(Session paramSession, Schema paramSchema, int paramInt, boolean paramBoolean) {
/* 31 */     super(paramSession, paramSchema);
/* 32 */     this.type = paramInt;
/* 33 */     this.value = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setCheckExisting(boolean paramBoolean) {
/* 37 */     this.checkExisting = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTransactional() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public void setIfTableExists(boolean paramBoolean) {
/* 46 */     this.ifTableExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setTableName(String paramString) {
/* 50 */     this.tableName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 55 */     Table table = getSchema().findTableOrView(this.session, this.tableName);
/* 56 */     if (table == null) {
/* 57 */       if (this.ifTableExists) {
/* 58 */         return 0;
/*    */       }
/* 60 */       throw DbException.get(42102, this.tableName);
/*    */     } 
/* 62 */     this.session.getUser().checkRight(table, 15);
/* 63 */     table.lock(this.session, true, true);
/* 64 */     switch (this.type)
/*    */     { case 55:
/* 66 */         table.setCheckForeignKeyConstraints(this.session, this.value, this.value ? this.checkExisting : false);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 72 */         return 0; }  DbException.throwInternalError("type=" + this.type); return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 77 */     return this.type;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\AlterTableSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */