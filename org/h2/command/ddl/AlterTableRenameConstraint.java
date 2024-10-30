/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.constraint.Constraint;
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
/*    */ 
/*    */ public class AlterTableRenameConstraint
/*    */   extends SchemaCommand
/*    */ {
/*    */   private String constraintName;
/*    */   private String newConstraintName;
/*    */   
/*    */   public AlterTableRenameConstraint(Session paramSession, Schema paramSchema) {
/* 26 */     super(paramSession, paramSchema);
/*    */   }
/*    */   
/*    */   public void setConstraintName(String paramString) {
/* 30 */     this.constraintName = paramString;
/*    */   }
/*    */   public void setNewConstraintName(String paramString) {
/* 33 */     this.newConstraintName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 38 */     this.session.commit(true);
/* 39 */     Constraint constraint = getSchema().findConstraint(this.session, this.constraintName);
/* 40 */     if (constraint == null) {
/* 41 */       throw DbException.get(90057, this.constraintName);
/*    */     }
/* 43 */     if (getSchema().findConstraint(this.session, this.newConstraintName) != null || this.newConstraintName.equals(this.constraintName))
/*    */     {
/* 45 */       throw DbException.get(90045, this.newConstraintName);
/*    */     }
/*    */     
/* 48 */     this.session.getUser().checkRight(constraint.getTable(), 15);
/* 49 */     this.session.getUser().checkRight(constraint.getRefTable(), 15);
/* 50 */     this.session.getDatabase().renameSchemaObject(this.session, (SchemaObject)constraint, this.newConstraintName);
/* 51 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 56 */     return 85;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\AlterTableRenameConstraint.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */