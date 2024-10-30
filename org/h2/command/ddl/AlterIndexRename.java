/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.index.Index;
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
/*    */ public class AlterIndexRename
/*    */   extends DefineCommand
/*    */ {
/*    */   private boolean ifExists;
/*    */   private Schema oldSchema;
/*    */   private String oldIndexName;
/*    */   private Index oldIndex;
/*    */   private String newIndexName;
/*    */   
/*    */   public AlterIndexRename(Session paramSession) {
/* 30 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 34 */     this.ifExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setOldSchema(Schema paramSchema) {
/* 38 */     this.oldSchema = paramSchema;
/*    */   }
/*    */   
/*    */   public void setOldName(String paramString) {
/* 42 */     this.oldIndexName = paramString;
/*    */   }
/*    */   
/*    */   public void setNewName(String paramString) {
/* 46 */     this.newIndexName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 51 */     this.session.commit(true);
/* 52 */     Database database = this.session.getDatabase();
/* 53 */     this.oldIndex = this.oldSchema.findIndex(this.session, this.oldIndexName);
/* 54 */     if (this.oldIndex == null) {
/* 55 */       if (!this.ifExists) {
/* 56 */         throw DbException.get(42112, this.newIndexName);
/*    */       }
/*    */       
/* 59 */       return 0;
/*    */     } 
/*    */     
/* 62 */     if (this.oldSchema.findIndex(this.session, this.newIndexName) != null || this.newIndexName.equals(this.oldIndexName))
/*    */     {
/* 64 */       throw DbException.get(42111, this.newIndexName);
/*    */     }
/*    */     
/* 67 */     this.session.getUser().checkRight(this.oldIndex.getTable(), 15);
/* 68 */     database.renameSchemaObject(this.session, (SchemaObject)this.oldIndex, this.newIndexName);
/* 69 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 74 */     return 1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\AlterIndexRename.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */