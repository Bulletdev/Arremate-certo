/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.schema.Schema;
/*    */ import org.h2.schema.SchemaObject;
/*    */ import org.h2.schema.Sequence;
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
/*    */ public class DropSequence
/*    */   extends SchemaCommand
/*    */ {
/*    */   private String sequenceName;
/*    */   private boolean ifExists;
/*    */   
/*    */   public DropSequence(Session paramSession, Schema paramSchema) {
/* 26 */     super(paramSession, paramSchema);
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 30 */     this.ifExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setSequenceName(String paramString) {
/* 34 */     this.sequenceName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 39 */     this.session.getUser().checkAdmin();
/* 40 */     this.session.commit(true);
/* 41 */     Database database = this.session.getDatabase();
/* 42 */     Sequence sequence = getSchema().findSequence(this.sequenceName);
/* 43 */     if (sequence == null) {
/* 44 */       if (!this.ifExists) {
/* 45 */         throw DbException.get(90036, this.sequenceName);
/*    */       }
/*    */     } else {
/* 48 */       if (sequence.getBelongsToTable()) {
/* 49 */         throw DbException.get(90082, this.sequenceName);
/*    */       }
/* 51 */       database.removeSchemaObject(this.session, (SchemaObject)sequence);
/*    */     } 
/* 53 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 58 */     return 43;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropSequence.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */