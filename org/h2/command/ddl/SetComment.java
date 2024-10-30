/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import org.h2.constraint.Constraint;
/*     */ import org.h2.engine.Comment;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.FunctionAlias;
/*     */ import org.h2.engine.Role;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.User;
/*     */ import org.h2.engine.UserDataType;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Constant;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.Sequence;
/*     */ import org.h2.schema.TriggerObject;
/*     */ import org.h2.table.Table;
/*     */ 
/*     */ public class SetComment
/*     */   extends DefineCommand
/*     */ {
/*     */   private String schemaName;
/*     */   private String objectName;
/*     */   private boolean column;
/*     */   private String columnName;
/*     */   private int objectType;
/*     */   private Expression expr;
/*     */   
/*     */   public SetComment(Session paramSession) {
/*  32 */     super(paramSession); } public int update() { Constraint constraint; FunctionAlias functionAlias; Index index; Role role; Schema schema; Sequence sequence;
/*     */     Table table;
/*     */     TriggerObject triggerObject;
/*     */     User user;
/*     */     UserDataType userDataType;
/*  37 */     this.session.commit(true);
/*  38 */     Database database = this.session.getDatabase();
/*  39 */     this.session.getUser().checkAdmin();
/*  40 */     Constant constant = null;
/*  41 */     int i = 50000;
/*  42 */     if (this.schemaName == null) {
/*  43 */       this.schemaName = this.session.getCurrentSchemaName();
/*     */     }
/*  45 */     switch (this.objectType) {
/*     */       case 11:
/*  47 */         constant = database.getSchema(this.schemaName).getConstant(this.objectName);
/*     */         break;
/*     */       case 5:
/*  50 */         constraint = database.getSchema(this.schemaName).getConstraint(this.objectName);
/*     */         break;
/*     */       case 9:
/*  53 */         functionAlias = database.getSchema(this.schemaName).findFunction(this.objectName);
/*  54 */         i = 90077;
/*     */         break;
/*     */       case 1:
/*  57 */         index = database.getSchema(this.schemaName).getIndex(this.objectName);
/*     */         break;
/*     */       case 7:
/*  60 */         this.schemaName = null;
/*  61 */         role = database.findRole(this.objectName);
/*  62 */         i = 90070;
/*     */         break;
/*     */       case 10:
/*  65 */         this.schemaName = null;
/*  66 */         schema = database.findSchema(this.objectName);
/*  67 */         i = 90079;
/*     */         break;
/*     */       case 3:
/*  70 */         sequence = database.getSchema(this.schemaName).getSequence(this.objectName);
/*     */         break;
/*     */       case 0:
/*  73 */         table = database.getSchema(this.schemaName).getTableOrView(this.session, this.objectName);
/*     */         break;
/*     */       case 4:
/*  76 */         triggerObject = database.getSchema(this.schemaName).findTrigger(this.objectName);
/*  77 */         i = 90042;
/*     */         break;
/*     */       case 2:
/*  80 */         this.schemaName = null;
/*  81 */         user = database.getUser(this.objectName);
/*     */         break;
/*     */       case 12:
/*  84 */         this.schemaName = null;
/*  85 */         userDataType = database.findUserDataType(this.objectName);
/*  86 */         i = 90119;
/*     */         break;
/*     */     } 
/*     */     
/*  90 */     if (userDataType == null) {
/*  91 */       throw DbException.get(i, this.objectName);
/*     */     }
/*  93 */     String str = this.expr.optimize(this.session).getValue(this.session).getString();
/*  94 */     if (this.column) {
/*  95 */       Table table1 = (Table)userDataType;
/*  96 */       table1.getColumn(this.columnName).setComment(str);
/*     */     } else {
/*  98 */       userDataType.setComment(str);
/*     */     } 
/* 100 */     if (this.column || this.objectType == 0 || this.objectType == 2 || this.objectType == 1 || this.objectType == 5) {
/*     */ 
/*     */ 
/*     */       
/* 104 */       database.updateMeta(this.session, (DbObject)userDataType);
/*     */     } else {
/* 106 */       Comment comment = database.findComment((DbObject)userDataType);
/* 107 */       if (comment == null) {
/* 108 */         if (str != null)
/*     */         {
/*     */           
/* 111 */           int j = getObjectId();
/* 112 */           comment = new Comment(database, j, (DbObject)userDataType);
/* 113 */           comment.setCommentText(str);
/* 114 */           database.addDatabaseObject(this.session, (DbObject)comment);
/*     */         }
/*     */       
/* 117 */       } else if (str == null) {
/* 118 */         database.removeDatabaseObject(this.session, (DbObject)comment);
/*     */       } else {
/* 120 */         comment.setCommentText(str);
/* 121 */         database.updateMeta(this.session, (DbObject)comment);
/*     */       } 
/*     */     } 
/*     */     
/* 125 */     return 0; }
/*     */ 
/*     */   
/*     */   public void setCommentExpression(Expression paramExpression) {
/* 129 */     this.expr = paramExpression;
/*     */   }
/*     */   
/*     */   public void setObjectName(String paramString) {
/* 133 */     this.objectName = paramString;
/*     */   }
/*     */   
/*     */   public void setObjectType(int paramInt) {
/* 137 */     this.objectType = paramInt;
/*     */   }
/*     */   
/*     */   public void setColumnName(String paramString) {
/* 141 */     this.columnName = paramString;
/*     */   }
/*     */   
/*     */   public void setSchemaName(String paramString) {
/* 145 */     this.schemaName = paramString;
/*     */   }
/*     */   
/*     */   public void setColumn(boolean paramBoolean) {
/* 149 */     this.column = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 154 */     return 52;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\SetComment.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */