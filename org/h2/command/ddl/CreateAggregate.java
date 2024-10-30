/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.DbObject;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.engine.UserAggregate;
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
/*    */ public class CreateAggregate
/*    */   extends DefineCommand
/*    */ {
/*    */   private Schema schema;
/*    */   private String name;
/*    */   private String javaClassMethod;
/*    */   private boolean ifNotExists;
/*    */   private boolean force;
/*    */   
/*    */   public CreateAggregate(Session paramSession) {
/* 29 */     super(paramSession);
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 34 */     this.session.commit(true);
/* 35 */     this.session.getUser().checkAdmin();
/* 36 */     Database database = this.session.getDatabase();
/* 37 */     if (database.findAggregate(this.name) != null || this.schema.findFunction(this.name) != null) {
/* 38 */       if (!this.ifNotExists) {
/* 39 */         throw DbException.get(90076, this.name);
/*    */       }
/*    */     } else {
/*    */       
/* 43 */       int i = getObjectId();
/* 44 */       UserAggregate userAggregate = new UserAggregate(database, i, this.name, this.javaClassMethod, this.force);
/*    */       
/* 46 */       database.addDatabaseObject(this.session, (DbObject)userAggregate);
/*    */     } 
/* 48 */     return 0;
/*    */   }
/*    */   
/*    */   public void setSchema(Schema paramSchema) {
/* 52 */     this.schema = paramSchema;
/*    */   }
/*    */   
/*    */   public void setName(String paramString) {
/* 56 */     this.name = paramString;
/*    */   }
/*    */   
/*    */   public void setJavaClassMethod(String paramString) {
/* 60 */     this.javaClassMethod = paramString;
/*    */   }
/*    */   
/*    */   public void setIfNotExists(boolean paramBoolean) {
/* 64 */     this.ifNotExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setForce(boolean paramBoolean) {
/* 68 */     this.force = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 73 */     return 22;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateAggregate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */