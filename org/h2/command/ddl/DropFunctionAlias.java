/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.FunctionAlias;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.schema.Schema;
/*    */ import org.h2.schema.SchemaObject;
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
/*    */ public class DropFunctionAlias
/*    */   extends SchemaCommand
/*    */ {
/*    */   private String aliasName;
/*    */   private boolean ifExists;
/*    */   
/*    */   public DropFunctionAlias(Session paramSession, Schema paramSchema) {
/* 26 */     super(paramSession, paramSchema);
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 31 */     this.session.getUser().checkAdmin();
/* 32 */     this.session.commit(true);
/* 33 */     Database database = this.session.getDatabase();
/* 34 */     FunctionAlias functionAlias = getSchema().findFunction(this.aliasName);
/* 35 */     if (functionAlias == null) {
/* 36 */       if (!this.ifExists) {
/* 37 */         throw DbException.get(90077, this.aliasName);
/*    */       }
/*    */     } else {
/* 40 */       database.removeSchemaObject(this.session, (SchemaObject)functionAlias);
/*    */     } 
/* 42 */     return 0;
/*    */   }
/*    */   
/*    */   public void setAliasName(String paramString) {
/* 46 */     this.aliasName = paramString;
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 50 */     this.ifExists = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 55 */     return 39;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropFunctionAlias.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */