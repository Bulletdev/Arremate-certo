/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.schema.Schema;
/*    */ import org.h2.schema.SchemaObject;
/*    */ import org.h2.schema.TriggerObject;
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
/*    */ public class DropTrigger
/*    */   extends SchemaCommand
/*    */ {
/*    */   private String triggerName;
/*    */   private boolean ifExists;
/*    */   
/*    */   public DropTrigger(Session paramSession, Schema paramSchema) {
/* 28 */     super(paramSession, paramSchema);
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 32 */     this.ifExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setTriggerName(String paramString) {
/* 36 */     this.triggerName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 41 */     this.session.commit(true);
/* 42 */     Database database = this.session.getDatabase();
/* 43 */     TriggerObject triggerObject = getSchema().findTrigger(this.triggerName);
/* 44 */     if (triggerObject == null) {
/* 45 */       if (!this.ifExists) {
/* 46 */         throw DbException.get(90042, this.triggerName);
/*    */       }
/*    */     } else {
/* 49 */       Table table = triggerObject.getTable();
/* 50 */       this.session.getUser().checkRight(table, 15);
/* 51 */       database.removeSchemaObject(this.session, (SchemaObject)triggerObject);
/*    */     } 
/* 53 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 58 */     return 45;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropTrigger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */