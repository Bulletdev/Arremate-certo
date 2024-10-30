/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.DbObject;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.engine.User;
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
/*    */ public class CreateSchema
/*    */   extends DefineCommand
/*    */ {
/*    */   private String schemaName;
/*    */   private String authorization;
/*    */   private boolean ifNotExists;
/*    */   
/*    */   public CreateSchema(Session paramSession) {
/* 27 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setIfNotExists(boolean paramBoolean) {
/* 31 */     this.ifNotExists = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 36 */     this.session.getUser().checkSchemaAdmin();
/* 37 */     this.session.commit(true);
/* 38 */     Database database = this.session.getDatabase();
/* 39 */     User user = database.getUser(this.authorization);
/*    */     
/* 41 */     if (!database.isStarting()) {
/* 42 */       user.checkSchemaAdmin();
/*    */     }
/* 44 */     if (database.findSchema(this.schemaName) != null) {
/* 45 */       if (this.ifNotExists) {
/* 46 */         return 0;
/*    */       }
/* 48 */       throw DbException.get(90078, this.schemaName);
/*    */     } 
/* 50 */     int i = getObjectId();
/* 51 */     Schema schema = new Schema(database, i, this.schemaName, user, false);
/* 52 */     database.addDatabaseObject(this.session, (DbObject)schema);
/* 53 */     return 0;
/*    */   }
/*    */   
/*    */   public void setSchemaName(String paramString) {
/* 57 */     this.schemaName = paramString;
/*    */   }
/*    */   
/*    */   public void setAuthorization(String paramString) {
/* 61 */     this.authorization = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 66 */     return 28;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateSchema.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */