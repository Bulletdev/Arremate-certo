/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.expression.Expression;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.schema.Constant;
/*    */ import org.h2.schema.Schema;
/*    */ import org.h2.schema.SchemaObject;
/*    */ import org.h2.value.Value;
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
/*    */ public class CreateConstant
/*    */   extends SchemaCommand
/*    */ {
/*    */   private String constantName;
/*    */   private Expression expression;
/*    */   private boolean ifNotExists;
/*    */   
/*    */   public CreateConstant(Session paramSession, Schema paramSchema) {
/* 29 */     super(paramSession, paramSchema);
/*    */   }
/*    */   
/*    */   public void setIfNotExists(boolean paramBoolean) {
/* 33 */     this.ifNotExists = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 38 */     this.session.commit(true);
/* 39 */     this.session.getUser().checkAdmin();
/* 40 */     Database database = this.session.getDatabase();
/* 41 */     if (getSchema().findConstant(this.constantName) != null) {
/* 42 */       if (this.ifNotExists) {
/* 43 */         return 0;
/*    */       }
/* 45 */       throw DbException.get(90114, this.constantName);
/*    */     } 
/* 47 */     int i = getObjectId();
/* 48 */     Constant constant = new Constant(getSchema(), i, this.constantName);
/* 49 */     this.expression = this.expression.optimize(this.session);
/* 50 */     Value value = this.expression.getValue(this.session);
/* 51 */     constant.setValue(value);
/* 52 */     database.addSchemaObject(this.session, (SchemaObject)constant);
/* 53 */     return 0;
/*    */   }
/*    */   
/*    */   public void setConstantName(String paramString) {
/* 57 */     this.constantName = paramString;
/*    */   }
/*    */   
/*    */   public void setExpression(Expression paramExpression) {
/* 61 */     this.expression = paramExpression;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 66 */     return 23;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateConstant.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */