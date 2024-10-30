/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.command.dml.Query;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableView;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CreateView
/*     */   extends SchemaCommand
/*     */ {
/*     */   private Query select;
/*     */   private String viewName;
/*     */   private boolean ifNotExists;
/*     */   private String selectSQL;
/*     */   private String[] columnNames;
/*     */   private String comment;
/*     */   private boolean orReplace;
/*     */   private boolean force;
/*     */   
/*     */   public CreateView(Session paramSession, Schema paramSchema) {
/*  39 */     super(paramSession, paramSchema);
/*     */   }
/*     */   
/*     */   public void setViewName(String paramString) {
/*  43 */     this.viewName = paramString;
/*     */   }
/*     */   
/*     */   public void setSelect(Query paramQuery) {
/*  47 */     this.select = paramQuery;
/*     */   }
/*     */   
/*     */   public void setIfNotExists(boolean paramBoolean) {
/*  51 */     this.ifNotExists = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setSelectSQL(String paramString) {
/*  55 */     this.selectSQL = paramString;
/*     */   }
/*     */   
/*     */   public void setColumnNames(String[] paramArrayOfString) {
/*  59 */     this.columnNames = paramArrayOfString;
/*     */   }
/*     */   
/*     */   public void setComment(String paramString) {
/*  63 */     this.comment = paramString;
/*     */   }
/*     */   
/*     */   public void setOrReplace(boolean paramBoolean) {
/*  67 */     this.orReplace = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setForce(boolean paramBoolean) {
/*  71 */     this.force = paramBoolean;
/*     */   }
/*     */   
/*     */   public int update() {
/*     */     String str;
/*  76 */     this.session.commit(true);
/*  77 */     this.session.getUser().checkAdmin();
/*  78 */     Database database = this.session.getDatabase();
/*  79 */     TableView tableView = null;
/*  80 */     Table table = getSchema().findTableOrView(this.session, this.viewName);
/*  81 */     if (table != null) {
/*  82 */       if (this.ifNotExists) {
/*  83 */         return 0;
/*     */       }
/*  85 */       if (!this.orReplace || !"VIEW".equals(table.getTableType())) {
/*  86 */         throw DbException.get(90038, this.viewName);
/*     */       }
/*  88 */       tableView = (TableView)table;
/*     */     } 
/*  90 */     int i = getObjectId();
/*     */     
/*  92 */     if (this.select == null) {
/*  93 */       str = this.selectSQL;
/*     */     } else {
/*  95 */       ArrayList arrayList = this.select.getParameters();
/*  96 */       if (arrayList != null && arrayList.size() > 0) {
/*  97 */         throw DbException.getUnsupportedException("parameters in views");
/*     */       }
/*  99 */       str = this.select.getPlanSQL();
/*     */     } 
/*     */ 
/*     */     
/* 103 */     Session session = database.getSystemSession();
/* 104 */     synchronized (session) {
/*     */       try {
/* 106 */         if (tableView == null) {
/* 107 */           Schema schema = this.session.getDatabase().getSchema(this.session.getCurrentSchemaName());
/*     */           
/* 109 */           session.setCurrentSchema(schema);
/* 110 */           Column[] arrayOfColumn = null;
/* 111 */           if (this.columnNames != null) {
/* 112 */             arrayOfColumn = new Column[this.columnNames.length];
/* 113 */             for (byte b = 0; b < this.columnNames.length; b++) {
/* 114 */               arrayOfColumn[b] = new Column(this.columnNames[b], -1);
/*     */             }
/*     */           } 
/* 117 */           tableView = new TableView(getSchema(), i, this.viewName, str, null, arrayOfColumn, session, false);
/*     */         } else {
/*     */           
/* 120 */           tableView.replace(str, this.columnNames, session, false, this.force);
/* 121 */           tableView.setModified();
/*     */         } 
/*     */       } finally {
/* 124 */         session.setCurrentSchema(database.getSchema("PUBLIC"));
/*     */       } 
/*     */     } 
/* 127 */     if (this.comment != null) {
/* 128 */       tableView.setComment(this.comment);
/*     */     }
/* 130 */     if (table == null) {
/* 131 */       database.addSchemaObject(this.session, (SchemaObject)tableView);
/*     */     } else {
/* 133 */       database.updateMeta(this.session, (DbObject)tableView);
/*     */     } 
/* 135 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 140 */     return 34;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */