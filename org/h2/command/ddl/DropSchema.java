/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.DbObject;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.schema.Schema;
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
/*    */ public class DropSchema
/*    */   extends DefineCommand
/*    */ {
/*    */   private String schemaName;
/*    */   private boolean ifExists;
/*    */   
/*    */   public DropSchema(Session paramSession) {
/* 25 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setSchemaName(String paramString) {
/* 29 */     this.schemaName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 34 */     this.session.getUser().checkSchemaAdmin();
/* 35 */     this.session.commit(true);
/* 36 */     Database database = this.session.getDatabase();
/* 37 */     Schema schema = database.findSchema(this.schemaName);
/* 38 */     if (schema == null) {
/* 39 */       if (!this.ifExists) {
/* 40 */         throw DbException.get(90079, this.schemaName);
/*    */       }
/*    */     } else {
/* 43 */       if (!schema.canDrop()) {
/* 44 */         throw DbException.get(90090, this.schemaName);
/*    */       }
/* 46 */       database.removeDatabaseObject(this.session, (DbObject)schema);
/*    */     } 
/* 48 */     return 0;
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 52 */     this.ifExists = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 57 */     return 42;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropSchema.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */