/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.h2.constraint.Constraint;
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.index.Index;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.schema.Schema;
/*    */ import org.h2.schema.SchemaObject;
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
/*    */ 
/*    */ public class DropIndex
/*    */   extends SchemaCommand
/*    */ {
/*    */   private String indexName;
/*    */   private boolean ifExists;
/*    */   
/*    */   public DropIndex(Session paramSession, Schema paramSchema) {
/* 31 */     super(paramSession, paramSchema);
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 35 */     this.ifExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setIndexName(String paramString) {
/* 39 */     this.indexName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 44 */     this.session.commit(true);
/* 45 */     Database database = this.session.getDatabase();
/* 46 */     Index index = getSchema().findIndex(this.session, this.indexName);
/* 47 */     if (index == null) {
/* 48 */       if (!this.ifExists) {
/* 49 */         throw DbException.get(42112, this.indexName);
/*    */       }
/*    */     } else {
/* 52 */       Table table = index.getTable();
/* 53 */       this.session.getUser().checkRight(index.getTable(), 15);
/* 54 */       Constraint constraint = null;
/* 55 */       ArrayList<Constraint> arrayList = table.getConstraints();
/* 56 */       for (byte b = 0; arrayList != null && b < arrayList.size(); b++) {
/* 57 */         Constraint constraint1 = arrayList.get(b);
/* 58 */         if (constraint1.usesIndex(index))
/*    */         {
/* 60 */           if ("PRIMARY KEY".equals(constraint1.getConstraintType())) {
/* 61 */             constraint = constraint1;
/*    */           } else {
/* 63 */             throw DbException.get(90085, new String[] { this.indexName, constraint1.getName() });
/*    */           } 
/*    */         }
/*    */       } 
/*    */ 
/*    */       
/* 69 */       index.getTable().setModified();
/* 70 */       if (constraint != null) {
/* 71 */         database.removeSchemaObject(this.session, (SchemaObject)constraint);
/*    */       } else {
/* 73 */         database.removeSchemaObject(this.session, (SchemaObject)index);
/*    */       } 
/*    */     } 
/* 76 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 81 */     return 40;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */