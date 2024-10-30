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
/*    */ 
/*    */ public class AlterTableDropConstraint
/*    */   extends SchemaCommand
/*    */ {
/*    */   private String constraintName;
/*    */   private final boolean ifExists;
/*    */   
/*    */   public AlterTableDropConstraint(Session paramSession, Schema paramSchema, boolean paramBoolean) {
/* 27 */     super(paramSession, paramSchema);
/* 28 */     this.ifExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setConstraintName(String paramString) {
/* 32 */     this.constraintName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 37 */     this.session.commit(true);
/* 38 */     Constraint constraint = getSchema().findConstraint(this.session, this.constraintName);
/* 39 */     if (constraint == null) {
/* 40 */       if (!this.ifExists) {
/* 41 */         throw DbException.get(90057, this.constraintName);
/*    */       }
/*    */     } else {
/* 44 */       this.session.getUser().checkRight(constraint.getTable(), 15);
/* 45 */       this.session.getUser().checkRight(constraint.getRefTable(), 15);
/* 46 */       this.session.getDatabase().removeSchemaObject(this.session, (SchemaObject)constraint);
/*    */     } 
/* 48 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 53 */     return 14;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\AlterTableDropConstraint.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */