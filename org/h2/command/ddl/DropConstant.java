/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.schema.Constant;
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
/*    */ public class DropConstant
/*    */   extends SchemaCommand
/*    */ {
/*    */   private String constantName;
/*    */   private boolean ifExists;
/*    */   
/*    */   public DropConstant(Session paramSession, Schema paramSchema) {
/* 26 */     super(paramSession, paramSchema);
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 30 */     this.ifExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setConstantName(String paramString) {
/* 34 */     this.constantName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 39 */     this.session.getUser().checkAdmin();
/* 40 */     this.session.commit(true);
/* 41 */     Database database = this.session.getDatabase();
/* 42 */     Constant constant = getSchema().findConstant(this.constantName);
/* 43 */     if (constant == null) {
/* 44 */       if (!this.ifExists) {
/* 45 */         throw DbException.get(90115, this.constantName);
/*    */       }
/*    */     } else {
/* 48 */       database.removeSchemaObject(this.session, (SchemaObject)constant);
/*    */     } 
/* 50 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 55 */     return 37;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropConstant.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */