/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.DbObject;
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
/*    */ public class AlterSchemaRename
/*    */   extends DefineCommand
/*    */ {
/*    */   private Schema oldSchema;
/*    */   private String newSchemaName;
/*    */   
/*    */   public AlterSchemaRename(Session paramSession) {
/* 28 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setOldSchema(Schema paramSchema) {
/* 32 */     this.oldSchema = paramSchema;
/*    */   }
/*    */   
/*    */   public void setNewName(String paramString) {
/* 36 */     this.newSchemaName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 41 */     this.session.commit(true);
/* 42 */     Database database = this.session.getDatabase();
/* 43 */     if (!this.oldSchema.canDrop()) {
/* 44 */       throw DbException.get(90090, this.oldSchema.getName());
/*    */     }
/*    */     
/* 47 */     if (database.findSchema(this.newSchemaName) != null || this.newSchemaName.equals(this.oldSchema.getName()))
/*    */     {
/* 49 */       throw DbException.get(90078, this.newSchemaName);
/*    */     }
/*    */     
/* 52 */     this.session.getUser().checkSchemaAdmin();
/* 53 */     database.renameDatabaseObject(this.session, (DbObject)this.oldSchema, this.newSchemaName);
/* 54 */     ArrayList arrayList = database.getAllSchemaObjects();
/* 55 */     for (SchemaObject schemaObject : arrayList) {
/* 56 */       database.updateMeta(this.session, (DbObject)schemaObject);
/*    */     }
/* 58 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 63 */     return 2;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\AlterSchemaRename.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */