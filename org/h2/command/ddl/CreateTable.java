/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import org.h2.command.dml.Insert;
/*     */ import org.h2.command.dml.Query;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.schema.Sequence;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.New;
/*     */ import org.h2.value.DataType;
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
/*     */ public class CreateTable
/*     */   extends SchemaCommand
/*     */ {
/*  34 */   private final CreateTableData data = new CreateTableData();
/*  35 */   private final ArrayList<DefineCommand> constraintCommands = New.arrayList();
/*     */   private IndexColumn[] pkColumns;
/*     */   private boolean ifNotExists;
/*     */   private boolean onCommitDrop;
/*     */   private boolean onCommitTruncate;
/*     */   private Query asQuery;
/*     */   private String comment;
/*     */   private boolean sortedInsertMode;
/*     */   
/*     */   public CreateTable(Session paramSession, Schema paramSchema) {
/*  45 */     super(paramSession, paramSchema);
/*  46 */     this.data.persistIndexes = true;
/*  47 */     this.data.persistData = true;
/*     */   }
/*     */   
/*     */   public void setQuery(Query paramQuery) {
/*  51 */     this.asQuery = paramQuery;
/*     */   }
/*     */   
/*     */   public void setTemporary(boolean paramBoolean) {
/*  55 */     this.data.temporary = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setTableName(String paramString) {
/*  59 */     this.data.tableName = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addColumn(Column paramColumn) {
/*  68 */     this.data.columns.add(paramColumn);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addConstraintCommand(DefineCommand paramDefineCommand) {
/*  78 */     if (paramDefineCommand instanceof CreateIndex) {
/*  79 */       this.constraintCommands.add(paramDefineCommand);
/*     */     } else {
/*  81 */       boolean bool; AlterTableAddConstraint alterTableAddConstraint = (AlterTableAddConstraint)paramDefineCommand;
/*     */       
/*  83 */       if (alterTableAddConstraint.getType() == 6) {
/*  84 */         bool = setPrimaryKeyColumns(alterTableAddConstraint.getIndexColumns());
/*     */       } else {
/*  86 */         bool = false;
/*     */       } 
/*  88 */       if (!bool) {
/*  89 */         this.constraintCommands.add(paramDefineCommand);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setIfNotExists(boolean paramBoolean) {
/*  95 */     this.ifNotExists = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/* 100 */     if (!this.transactional) {
/* 101 */       this.session.commit(true);
/*     */     }
/* 103 */     Database database = this.session.getDatabase();
/* 104 */     if (!database.isPersistent()) {
/* 105 */       this.data.persistIndexes = false;
/*     */     }
/* 107 */     boolean bool = (this.data.temporary && !this.data.globalTemporary) ? true : false;
/* 108 */     if (!bool) {
/* 109 */       database.lockMeta(this.session);
/*     */     }
/* 111 */     if (getSchema().findTableOrView(this.session, this.data.tableName) != null) {
/* 112 */       if (this.ifNotExists) {
/* 113 */         return 0;
/*     */       }
/* 115 */       throw DbException.get(42101, this.data.tableName);
/*     */     } 
/* 117 */     if (this.asQuery != null) {
/* 118 */       this.asQuery.prepare();
/* 119 */       if (this.data.columns.size() == 0) {
/* 120 */         generateColumnsFromQuery();
/* 121 */       } else if (this.data.columns.size() != this.asQuery.getColumnCount()) {
/* 122 */         throw DbException.get(21002);
/*     */       } 
/*     */     } 
/* 125 */     if (this.pkColumns != null) {
/* 126 */       for (Column column : this.data.columns) {
/* 127 */         for (IndexColumn indexColumn : this.pkColumns) {
/* 128 */           if (column.getName().equals(indexColumn.columnName)) {
/* 129 */             column.setNullable(false);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/* 134 */     this.data.id = getObjectId();
/* 135 */     this.data.create = this.create;
/* 136 */     this.data.session = this.session;
/* 137 */     Table table = getSchema().createTable(this.data);
/* 138 */     ArrayList<Sequence> arrayList = New.arrayList();
/* 139 */     for (Column column : this.data.columns) {
/* 140 */       if (column.isAutoIncrement()) {
/* 141 */         int i = getObjectId();
/* 142 */         column.convertAutoIncrementToSequence(this.session, getSchema(), i, this.data.temporary);
/* 143 */         if (!"''".equals(this.session.getDatabase().getCluster()))
/*     */         {
/* 145 */           throw DbException.getUnsupportedException("CLUSTERING && auto-increment columns");
/*     */         }
/*     */       } 
/*     */       
/* 149 */       Sequence sequence = column.getSequence();
/* 150 */       if (sequence != null) {
/* 151 */         arrayList.add(sequence);
/*     */       }
/*     */     } 
/* 154 */     table.setComment(this.comment);
/* 155 */     if (bool) {
/* 156 */       if (this.onCommitDrop) {
/* 157 */         table.setOnCommitDrop(true);
/*     */       }
/* 159 */       if (this.onCommitTruncate) {
/* 160 */         table.setOnCommitTruncate(true);
/*     */       }
/* 162 */       this.session.addLocalTempTable(table);
/*     */     } else {
/* 164 */       database.lockMeta(this.session);
/* 165 */       database.addSchemaObject(this.session, (SchemaObject)table);
/*     */     } 
/*     */     try {
/* 168 */       for (Column column : this.data.columns) {
/* 169 */         column.prepareExpression(this.session);
/*     */       }
/* 171 */       for (Sequence sequence : arrayList) {
/* 172 */         table.addSequence(sequence);
/*     */       }
/* 174 */       for (DefineCommand defineCommand : this.constraintCommands) {
/* 175 */         defineCommand.setTransactional(this.transactional);
/* 176 */         defineCommand.update();
/*     */       } 
/* 178 */       if (this.asQuery != null) {
/* 179 */         boolean bool1 = this.session.isUndoLogEnabled();
/*     */         try {
/* 181 */           this.session.setUndoLogEnabled(false);
/* 182 */           this.session.startStatementWithinTransaction();
/* 183 */           Insert insert = null;
/* 184 */           insert = new Insert(this.session);
/* 185 */           insert.setSortedInsertMode(this.sortedInsertMode);
/* 186 */           insert.setQuery(this.asQuery);
/* 187 */           insert.setTable(table);
/* 188 */           insert.setInsertFromSelect(true);
/* 189 */           insert.prepare();
/* 190 */           insert.update();
/*     */         } finally {
/* 192 */           this.session.setUndoLogEnabled(bool1);
/*     */         } 
/*     */       } 
/* 195 */       HashSet hashSet = New.hashSet();
/* 196 */       hashSet.clear();
/* 197 */       table.addDependencies(hashSet);
/* 198 */       for (DbObject dbObject : hashSet) {
/* 199 */         if (dbObject == table) {
/*     */           continue;
/*     */         }
/* 202 */         if (dbObject.getType() == 0 && 
/* 203 */           dbObject instanceof Table) {
/* 204 */           Table table1 = (Table)dbObject;
/* 205 */           if (table1.getId() > table.getId()) {
/* 206 */             throw DbException.get(50100, "Table depends on another table with a higher ID: " + table1 + ", this is currently not supported, " + "as it would prevent the database from " + "being re-opened");
/*     */           
/*     */           }
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 217 */     catch (DbException dbException) {
/* 218 */       database.checkPowerOff();
/* 219 */       database.removeSchemaObject(this.session, (SchemaObject)table);
/* 220 */       if (!this.transactional) {
/* 221 */         this.session.commit(true);
/*     */       }
/* 223 */       throw dbException;
/*     */     } 
/* 225 */     return 0;
/*     */   }
/*     */   
/*     */   private void generateColumnsFromQuery() {
/* 229 */     int i = this.asQuery.getColumnCount();
/* 230 */     ArrayList<Expression> arrayList = this.asQuery.getExpressions();
/* 231 */     for (byte b = 0; b < i; b++) {
/* 232 */       Expression expression = arrayList.get(b);
/* 233 */       int j = expression.getType();
/* 234 */       String str = expression.getAlias();
/* 235 */       long l = expression.getPrecision();
/* 236 */       int k = expression.getDisplaySize();
/* 237 */       DataType dataType = DataType.getDataType(j);
/* 238 */       if (l > 0L && (dataType.defaultPrecision == 0L || (dataType.defaultPrecision > l && dataType.defaultPrecision < 127L)))
/*     */       {
/*     */         
/* 241 */         l = dataType.defaultPrecision;
/*     */       }
/* 243 */       int m = expression.getScale();
/* 244 */       if (m > 0 && (dataType.defaultScale == 0 || (dataType.defaultScale > m && dataType.defaultScale < l)))
/*     */       {
/* 246 */         m = dataType.defaultScale;
/*     */       }
/* 248 */       if (m > l) {
/* 249 */         l = m;
/*     */       }
/* 251 */       Column column = new Column(str, j, l, m, k);
/* 252 */       addColumn(column);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean setPrimaryKeyColumns(IndexColumn[] paramArrayOfIndexColumn) {
/* 264 */     if (this.pkColumns != null) {
/* 265 */       int i = paramArrayOfIndexColumn.length;
/* 266 */       if (i != this.pkColumns.length) {
/* 267 */         throw DbException.get(90017);
/*     */       }
/* 269 */       for (byte b = 0; b < i; b++) {
/* 270 */         if (!(paramArrayOfIndexColumn[b]).columnName.equals((this.pkColumns[b]).columnName)) {
/* 271 */           throw DbException.get(90017);
/*     */         }
/*     */       } 
/* 274 */       return true;
/*     */     } 
/* 276 */     this.pkColumns = paramArrayOfIndexColumn;
/* 277 */     return false;
/*     */   }
/*     */   
/*     */   public void setPersistIndexes(boolean paramBoolean) {
/* 281 */     this.data.persistIndexes = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setGlobalTemporary(boolean paramBoolean) {
/* 285 */     this.data.globalTemporary = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOnCommitDrop() {
/* 292 */     this.onCommitDrop = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOnCommitTruncate() {
/* 299 */     this.onCommitTruncate = true;
/*     */   }
/*     */   
/*     */   public void setComment(String paramString) {
/* 303 */     this.comment = paramString;
/*     */   }
/*     */   
/*     */   public void setPersistData(boolean paramBoolean) {
/* 307 */     this.data.persistData = paramBoolean;
/* 308 */     if (!paramBoolean) {
/* 309 */       this.data.persistIndexes = false;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setSortedInsertMode(boolean paramBoolean) {
/* 314 */     this.sortedInsertMode = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setTableEngine(String paramString) {
/* 318 */     this.data.tableEngine = paramString;
/*     */   }
/*     */   
/*     */   public void setTableEngineParams(ArrayList<String> paramArrayList) {
/* 322 */     this.data.tableEngineParams = paramArrayList;
/*     */   }
/*     */   
/*     */   public void setHidden(boolean paramBoolean) {
/* 326 */     this.data.isHidden = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 331 */     return 30;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateTable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */