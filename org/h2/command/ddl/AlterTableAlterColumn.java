/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.constraint.ConstraintReferential;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.schema.Sequence;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableView;
/*     */ import org.h2.util.New;
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
/*     */ public class AlterTableAlterColumn
/*     */   extends SchemaCommand
/*     */ {
/*     */   private String tableName;
/*     */   private Column oldColumn;
/*     */   private Column newColumn;
/*     */   private int type;
/*     */   private Expression defaultExpression;
/*     */   private Expression newSelectivity;
/*     */   private String addBefore;
/*     */   private String addAfter;
/*     */   private boolean ifTableExists;
/*     */   private boolean ifNotExists;
/*     */   private ArrayList<Column> columnsToAdd;
/*     */   private ArrayList<Column> columnsToRemove;
/*     */   
/*     */   public AlterTableAlterColumn(Session paramSession, Schema paramSchema) {
/*  65 */     super(paramSession, paramSchema);
/*     */   }
/*     */   
/*     */   public void setIfTableExists(boolean paramBoolean) {
/*  69 */     this.ifTableExists = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setTableName(String paramString) {
/*  73 */     this.tableName = paramString;
/*     */   }
/*     */   
/*     */   public void setOldColumn(Column paramColumn) {
/*  77 */     this.oldColumn = paramColumn;
/*     */   }
/*     */   
/*     */   public void setAddBefore(String paramString) {
/*  81 */     this.addBefore = paramString;
/*     */   }
/*     */   
/*     */   public void setAddAfter(String paramString) {
/*  85 */     this.addAfter = paramString;
/*     */   }
/*     */   public int update() {
/*     */     Sequence sequence;
/*     */     int i;
/*  90 */     this.session.commit(true);
/*  91 */     Database database = this.session.getDatabase();
/*  92 */     Table table = getSchema().findTableOrView(this.session, this.tableName);
/*  93 */     if (table == null) {
/*  94 */       if (this.ifTableExists) {
/*  95 */         return 0;
/*     */       }
/*  97 */       throw DbException.get(42102, this.tableName);
/*     */     } 
/*  99 */     this.session.getUser().checkRight(table, 15);
/* 100 */     table.checkSupportAlter();
/* 101 */     table.lock(this.session, true, true);
/* 102 */     if (this.newColumn != null) {
/* 103 */       checkDefaultReferencesTable(table, this.newColumn.getDefaultExpression());
/* 104 */       checkClustering(this.newColumn);
/*     */     } 
/* 106 */     if (this.columnsToAdd != null) {
/* 107 */       for (Column column : this.columnsToAdd) {
/* 108 */         checkDefaultReferencesTable(table, column.getDefaultExpression());
/* 109 */         checkClustering(column);
/*     */       } 
/*     */     }
/* 112 */     switch (this.type)
/*     */     { case 8:
/* 114 */         if (this.oldColumn.isNullable()) {
/*     */ 
/*     */ 
/*     */           
/* 118 */           checkNoNullValues(table);
/* 119 */           this.oldColumn.setNullable(false);
/* 120 */           database.updateMeta(this.session, (DbObject)table);
/*     */         } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 198 */         return 0;case 9: if (!this.oldColumn.isNullable()) { checkNullable(table); this.oldColumn.setNullable(true); database.updateMeta(this.session, (DbObject)table); }  return 0;case 10: sequence = (this.oldColumn == null) ? null : this.oldColumn.getSequence(); checkDefaultReferencesTable(table, this.defaultExpression); this.oldColumn.setSequence(null); this.oldColumn.setDefaultExpression(this.session, this.defaultExpression); removeSequence(table, sequence); database.updateMeta(this.session, (DbObject)table); return 0;case 11: if (this.oldColumn.isWideningConversion(this.newColumn)) { convertAutoIncrementColumn(table, this.newColumn); this.oldColumn.copy(this.newColumn); database.updateMeta(this.session, (DbObject)table); } else { this.oldColumn.setSequence(null); this.oldColumn.setDefaultExpression(this.session, null); this.oldColumn.setConvertNullToDefault(false); if (this.oldColumn.isNullable() && !this.newColumn.isNullable()) { checkNoNullValues(table); } else if (!this.oldColumn.isNullable() && this.newColumn.isNullable()) { checkNullable(table); }  convertAutoIncrementColumn(table, this.newColumn); copyData(table); }  return 0;case 7: if (!this.ifNotExists || this.columnsToAdd.size() != 1 || !table.doesColumnExist(((Column)this.columnsToAdd.get(0)).getName())) { for (Column column : this.columnsToAdd) { if (column.isAutoIncrement()) { int j = getObjectId(); column.convertAutoIncrementToSequence(this.session, getSchema(), j, table.isTemporary()); }  }  copyData(table); }  return 0;case 12: if ((table.getColumns()).length - this.columnsToRemove.size() < 1) throw DbException.get(90084, ((Column)this.columnsToRemove.get(0)).getSQL());  table.dropMultipleColumnsConstraintsAndIndexes(this.session, this.columnsToRemove); copyData(table); return 0;case 13: i = this.newSelectivity.optimize(this.session).getValue(this.session).getInt(); this.oldColumn.setSelectivity(i); database.updateMeta(this.session, (DbObject)table); return 0; }  DbException.throwInternalError("type=" + this.type); return 0;
/*     */   }
/*     */   
/*     */   private void checkDefaultReferencesTable(Table paramTable, Expression paramExpression) {
/* 202 */     if (paramExpression == null) {
/*     */       return;
/*     */     }
/* 205 */     HashSet hashSet = New.hashSet();
/* 206 */     ExpressionVisitor expressionVisitor = ExpressionVisitor.getDependenciesVisitor(hashSet);
/*     */     
/* 208 */     paramExpression.isEverything(expressionVisitor);
/* 209 */     if (hashSet.contains(paramTable)) {
/* 210 */       throw DbException.get(90083, paramExpression.getSQL());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void checkClustering(Column paramColumn) {
/* 216 */     if (!"''".equals(this.session.getDatabase().getCluster()) && paramColumn.isAutoIncrement())
/*     */     {
/*     */       
/* 219 */       throw DbException.getUnsupportedException("CLUSTERING && auto-increment columns");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void convertAutoIncrementColumn(Table paramTable, Column paramColumn) {
/* 225 */     if (paramColumn.isAutoIncrement()) {
/* 226 */       if (paramColumn.isPrimaryKey()) {
/* 227 */         paramColumn.setOriginalSQL("IDENTITY");
/*     */       } else {
/* 229 */         int i = getObjectId();
/* 230 */         paramColumn.convertAutoIncrementToSequence(this.session, getSchema(), i, paramTable.isTemporary());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void removeSequence(Table paramTable, Sequence paramSequence) {
/* 237 */     if (paramSequence != null) {
/* 238 */       paramTable.removeSequence(paramSequence);
/* 239 */       paramSequence.setBelongsToTable(false);
/* 240 */       Database database = this.session.getDatabase();
/* 241 */       database.removeSchemaObject(this.session, (SchemaObject)paramSequence);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void copyData(Table paramTable) {
/* 246 */     if (paramTable.isTemporary()) {
/* 247 */       throw DbException.getUnsupportedException("TEMP TABLE");
/*     */     }
/* 249 */     Database database = this.session.getDatabase();
/* 250 */     String str1 = paramTable.getName();
/* 251 */     String str2 = database.getTempTableName(str1, this.session);
/* 252 */     Column[] arrayOfColumn = paramTable.getColumns();
/* 253 */     ArrayList<Column> arrayList = New.arrayList();
/* 254 */     Table table = cloneTableStructure(paramTable, arrayOfColumn, database, str2, arrayList);
/*     */ 
/*     */     
/*     */     try {
/* 258 */       checkViews((SchemaObject)paramTable, (SchemaObject)table);
/* 259 */     } catch (DbException dbException) {
/* 260 */       execute("DROP TABLE " + table.getName(), true);
/* 261 */       throw DbException.get(90109, dbException, new String[] { getSQL(), dbException.getMessage() });
/*     */     } 
/* 263 */     String str3 = paramTable.getName();
/* 264 */     ArrayList arrayList1 = paramTable.getViews();
/* 265 */     if (arrayList1 != null) {
/* 266 */       arrayList1 = New.arrayList(arrayList1);
/* 267 */       for (TableView tableView : arrayList1) {
/* 268 */         paramTable.removeView(tableView);
/*     */       }
/*     */     } 
/* 271 */     execute("DROP TABLE " + paramTable.getSQL() + " IGNORE", true);
/* 272 */     database.renameSchemaObject(this.session, (SchemaObject)table, str3);
/* 273 */     for (DbObject dbObject : table.getChildren()) {
/* 274 */       if (dbObject instanceof Sequence) {
/*     */         continue;
/*     */       }
/* 277 */       String str = dbObject.getName();
/* 278 */       if (str == null || dbObject.getCreateSQL() == null) {
/*     */         continue;
/*     */       }
/* 281 */       if (str.startsWith(str2 + "_")) {
/* 282 */         str = str.substring(str2.length() + 1);
/* 283 */         SchemaObject schemaObject = (SchemaObject)dbObject;
/* 284 */         if (schemaObject instanceof org.h2.constraint.Constraint) {
/* 285 */           if (schemaObject.getSchema().findConstraint(this.session, str) != null) {
/* 286 */             str = schemaObject.getSchema().getUniqueConstraintName(this.session, table);
/*     */           }
/* 288 */         } else if (schemaObject instanceof Index && 
/* 289 */           schemaObject.getSchema().findIndex(this.session, str) != null) {
/* 290 */           str = schemaObject.getSchema().getUniqueIndexName(this.session, table, str);
/*     */         } 
/*     */         
/* 293 */         database.renameSchemaObject(this.session, schemaObject, str);
/*     */       } 
/*     */     } 
/* 296 */     if (arrayList1 != null) {
/* 297 */       for (TableView tableView : arrayList1) {
/* 298 */         String str = tableView.getCreateSQL(true, true);
/* 299 */         execute(str, true);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private Table cloneTableStructure(Table paramTable, Column[] paramArrayOfColumn, Database paramDatabase, String paramString, ArrayList<Column> paramArrayList) {
/* 306 */     for (Column column : paramArrayOfColumn) {
/* 307 */       paramArrayList.add(column.getClone());
/*     */     }
/* 309 */     if (this.type == 12) {
/* 310 */       for (Column column1 : this.columnsToRemove) {
/* 311 */         Column column2 = null;
/* 312 */         for (Column column : paramArrayList) {
/*     */           
/* 314 */           if (column.getName() == column1.getName()) {
/* 315 */             column2 = column;
/*     */             break;
/*     */           } 
/*     */         } 
/* 319 */         if (column2 == null) {
/* 320 */           throw DbException.throwInternalError(column1.getCreateSQL());
/*     */         }
/* 322 */         paramArrayList.remove(column2);
/*     */       } 
/* 324 */     } else if (this.type == 7) {
/*     */       int j;
/* 326 */       if (this.addBefore != null) {
/* 327 */         j = paramTable.getColumn(this.addBefore).getColumnId();
/* 328 */       } else if (this.addAfter != null) {
/* 329 */         j = paramTable.getColumn(this.addAfter).getColumnId() + 1;
/*     */       } else {
/* 331 */         j = paramArrayOfColumn.length;
/*     */       } 
/* 333 */       for (Column column : this.columnsToAdd) {
/* 334 */         paramArrayList.add(j++, column);
/*     */       }
/* 336 */     } else if (this.type == 11) {
/* 337 */       int j = this.oldColumn.getColumnId();
/* 338 */       paramArrayList.remove(j);
/* 339 */       paramArrayList.add(j, this.newColumn);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 347 */     int i = paramDatabase.allocateObjectId();
/* 348 */     CreateTableData createTableData = new CreateTableData();
/* 349 */     createTableData.tableName = paramString;
/* 350 */     createTableData.id = i;
/* 351 */     createTableData.columns = paramArrayList;
/* 352 */     createTableData.temporary = paramTable.isTemporary();
/* 353 */     createTableData.persistData = paramTable.isPersistData();
/* 354 */     createTableData.persistIndexes = paramTable.isPersistIndexes();
/* 355 */     createTableData.isHidden = paramTable.isHidden();
/* 356 */     createTableData.create = true;
/* 357 */     createTableData.session = this.session;
/* 358 */     Table table = getSchema().createTable(createTableData);
/* 359 */     table.setComment(paramTable.getComment());
/* 360 */     StringBuilder stringBuilder1 = new StringBuilder();
/* 361 */     stringBuilder1.append(table.getCreateSQL());
/* 362 */     StringBuilder stringBuilder2 = new StringBuilder();
/* 363 */     for (Column column : paramArrayList) {
/* 364 */       if (stringBuilder2.length() > 0) {
/* 365 */         stringBuilder2.append(", ");
/*     */       }
/* 367 */       if (this.type == 7 && this.columnsToAdd.contains(column)) {
/*     */         
/* 369 */         Expression expression = column.getDefaultExpression();
/* 370 */         stringBuilder2.append((expression == null) ? "NULL" : expression.getSQL()); continue;
/*     */       } 
/* 372 */       stringBuilder2.append(column.getSQL());
/*     */     } 
/*     */     
/* 375 */     stringBuilder1.append(" AS SELECT ");
/* 376 */     if (stringBuilder2.length() == 0) {
/*     */       
/* 378 */       stringBuilder1.append('*');
/*     */     } else {
/* 380 */       stringBuilder1.append(stringBuilder2);
/*     */     } 
/* 382 */     stringBuilder1.append(" FROM ").append(paramTable.getSQL());
/* 383 */     String str1 = stringBuilder1.toString();
/* 384 */     String str2 = table.getName();
/* 385 */     Schema schema = table.getSchema();
/* 386 */     table.removeChildrenAndResources(this.session);
/*     */     
/* 388 */     execute(str1, true);
/* 389 */     table = schema.getTableOrView(this.session, str2);
/* 390 */     ArrayList<String> arrayList = New.arrayList();
/* 391 */     for (DbObject dbObject : paramTable.getChildren()) {
/* 392 */       if (dbObject instanceof Sequence)
/*     */         continue; 
/* 394 */       if (dbObject instanceof Index) {
/* 395 */         Index index = (Index)dbObject;
/* 396 */         if (index.getIndexType().getBelongsToConstraint()) {
/*     */           continue;
/*     */         }
/*     */       } 
/* 400 */       String str3 = dbObject.getCreateSQL();
/* 401 */       if (str3 == null) {
/*     */         continue;
/*     */       }
/* 404 */       if (dbObject instanceof TableView)
/*     */         continue; 
/* 406 */       if (dbObject.getType() == 0) {
/* 407 */         DbException.throwInternalError();
/*     */       }
/* 409 */       String str4 = Parser.quoteIdentifier(paramString + "_" + dbObject.getName());
/* 410 */       String str5 = null;
/* 411 */       if (dbObject instanceof ConstraintReferential) {
/* 412 */         ConstraintReferential constraintReferential = (ConstraintReferential)dbObject;
/* 413 */         if (constraintReferential.getTable() != paramTable) {
/* 414 */           str5 = constraintReferential.getCreateSQLForCopy(constraintReferential.getTable(), table, str4, false);
/*     */         }
/*     */       } 
/* 417 */       if (str5 == null) {
/* 418 */         str5 = dbObject.getCreateSQLForCopy(table, str4);
/*     */       }
/* 420 */       if (str5 != null) {
/* 421 */         if (dbObject instanceof org.h2.schema.TriggerObject) {
/* 422 */           arrayList.add(str5); continue;
/*     */         } 
/* 424 */         execute(str5, true);
/*     */       } 
/*     */     } 
/*     */     
/* 428 */     paramTable.setModified();
/*     */ 
/*     */     
/* 431 */     for (Column column : paramArrayList) {
/* 432 */       Sequence sequence = column.getSequence();
/* 433 */       if (sequence != null) {
/* 434 */         paramTable.removeSequence(sequence);
/* 435 */         column.setSequence(null);
/*     */       } 
/*     */     } 
/* 438 */     for (String str : arrayList) {
/* 439 */       execute(str, true);
/*     */     }
/* 441 */     return table;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkViews(SchemaObject paramSchemaObject1, SchemaObject paramSchemaObject2) {
/* 448 */     String str1 = paramSchemaObject1.getName();
/* 449 */     String str2 = paramSchemaObject2.getName();
/* 450 */     Database database = paramSchemaObject1.getDatabase();
/*     */     
/* 452 */     String str3 = database.getTempTableName(str1, this.session);
/* 453 */     database.renameSchemaObject(this.session, paramSchemaObject1, str3);
/*     */     
/*     */     try {
/* 456 */       database.renameSchemaObject(this.session, paramSchemaObject2, str1);
/* 457 */       checkViewsAreValid((DbObject)paramSchemaObject1);
/*     */     } finally {
/*     */       
/*     */       try {
/* 461 */         database.renameSchemaObject(this.session, paramSchemaObject2, str2);
/*     */       } finally {
/* 463 */         database.renameSchemaObject(this.session, paramSchemaObject1, str1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkViewsAreValid(DbObject paramDbObject) {
/* 474 */     for (DbObject dbObject : paramDbObject.getChildren()) {
/* 475 */       if (dbObject instanceof TableView) {
/* 476 */         String str = ((TableView)dbObject).getQuery();
/*     */ 
/*     */ 
/*     */         
/* 480 */         this.session.prepare(str);
/* 481 */         checkViewsAreValid(dbObject);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void execute(String paramString, boolean paramBoolean) {
/* 487 */     Prepared prepared = this.session.prepare(paramString);
/* 488 */     prepared.update();
/* 489 */     if (paramBoolean) {
/* 490 */       this.session.commit(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkNullable(Table paramTable) {
/* 495 */     for (Index index : paramTable.getIndexes()) {
/* 496 */       if (index.getColumnIndex(this.oldColumn) < 0) {
/*     */         continue;
/*     */       }
/* 499 */       IndexType indexType = index.getIndexType();
/* 500 */       if (indexType.isPrimaryKey() || indexType.isHash()) {
/* 501 */         throw DbException.get(90075, index.getSQL());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void checkNoNullValues(Table paramTable) {
/* 508 */     String str = "SELECT COUNT(*) FROM " + paramTable.getSQL() + " WHERE " + this.oldColumn.getSQL() + " IS NULL";
/*     */ 
/*     */     
/* 511 */     Prepared prepared = this.session.prepare(str);
/* 512 */     ResultInterface resultInterface = prepared.query(0);
/* 513 */     resultInterface.next();
/* 514 */     if (resultInterface.currentRow()[0].getInt() > 0) {
/* 515 */       throw DbException.get(90081, this.oldColumn.getSQL());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(int paramInt) {
/* 522 */     this.type = paramInt;
/*     */   }
/*     */   
/*     */   public void setSelectivity(Expression paramExpression) {
/* 526 */     this.newSelectivity = paramExpression;
/*     */   }
/*     */   
/*     */   public void setDefaultExpression(Expression paramExpression) {
/* 530 */     this.defaultExpression = paramExpression;
/*     */   }
/*     */   
/*     */   public void setNewColumn(Column paramColumn) {
/* 534 */     this.newColumn = paramColumn;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 539 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setIfNotExists(boolean paramBoolean) {
/* 543 */     this.ifNotExists = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setNewColumns(ArrayList<Column> paramArrayList) {
/* 547 */     this.columnsToAdd = paramArrayList;
/*     */   }
/*     */   
/*     */   public void setColumnsToRemove(ArrayList<Column> paramArrayList) {
/* 551 */     this.columnsToRemove = paramArrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\AlterTableAlterColumn.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */