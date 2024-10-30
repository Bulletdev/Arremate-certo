/*     */ package org.h2.constraint;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.index.Cursor;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueNull;
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
/*     */ public class ConstraintReferential
/*     */   extends Constraint
/*     */ {
/*     */   public static final int RESTRICT = 0;
/*     */   public static final int CASCADE = 1;
/*     */   public static final int SET_DEFAULT = 2;
/*     */   public static final int SET_NULL = 3;
/*     */   private IndexColumn[] columns;
/*     */   private IndexColumn[] refColumns;
/*     */   private int deleteAction;
/*     */   private int updateAction;
/*     */   private Table refTable;
/*     */   private Index index;
/*     */   private Index refIndex;
/*     */   private boolean indexOwner;
/*     */   private boolean refIndexOwner;
/*     */   private String deleteSQL;
/*     */   private String updateSQL;
/*     */   private boolean skipOwnTable;
/*     */   
/*     */   public ConstraintReferential(Schema paramSchema, int paramInt, String paramString, Table paramTable) {
/*  71 */     super(paramSchema, paramInt, paramString, paramTable);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getConstraintType() {
/*  76 */     return "REFERENTIAL";
/*     */   }
/*     */   
/*     */   private static void appendAction(StatementBuilder paramStatementBuilder, int paramInt) {
/*  80 */     switch (paramInt) {
/*     */       case 1:
/*  82 */         paramStatementBuilder.append("CASCADE");
/*     */         return;
/*     */       case 2:
/*  85 */         paramStatementBuilder.append("SET DEFAULT");
/*     */         return;
/*     */       case 3:
/*  88 */         paramStatementBuilder.append("SET NULL");
/*     */         return;
/*     */     } 
/*  91 */     DbException.throwInternalError("action=" + paramInt);
/*     */   }
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
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 105 */     return getCreateSQLForCopy(paramTable, this.refTable, paramString, true);
/*     */   }
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
/*     */   public String getCreateSQLForCopy(Table paramTable1, Table paramTable2, String paramString, boolean paramBoolean) {
/*     */     String str2;
/* 120 */     StatementBuilder statementBuilder = new StatementBuilder("ALTER TABLE ");
/* 121 */     String str1 = paramTable1.getSQL();
/* 122 */     statementBuilder.append(str1).append(" ADD CONSTRAINT ");
/* 123 */     if (paramTable1.isHidden()) {
/* 124 */       statementBuilder.append("IF NOT EXISTS ");
/*     */     }
/* 126 */     statementBuilder.append(paramString);
/* 127 */     if (this.comment != null) {
/* 128 */       statementBuilder.append(" COMMENT ").append(StringUtils.quoteStringSQL(this.comment));
/*     */     }
/* 130 */     IndexColumn[] arrayOfIndexColumn1 = this.columns;
/* 131 */     IndexColumn[] arrayOfIndexColumn2 = this.refColumns;
/* 132 */     statementBuilder.append(" FOREIGN KEY(");
/* 133 */     for (IndexColumn indexColumn : arrayOfIndexColumn1) {
/* 134 */       statementBuilder.appendExceptFirst(", ");
/* 135 */       statementBuilder.append(indexColumn.getSQL());
/*     */     } 
/* 137 */     statementBuilder.append(')');
/* 138 */     if (paramBoolean && this.indexOwner && paramTable1 == this.table) {
/* 139 */       statementBuilder.append(" INDEX ").append(this.index.getSQL());
/*     */     }
/* 141 */     statementBuilder.append(" REFERENCES ");
/*     */     
/* 143 */     if (this.table == this.refTable) {
/*     */       
/* 145 */       str2 = paramTable1.getSQL();
/*     */     } else {
/* 147 */       str2 = paramTable2.getSQL();
/*     */     } 
/* 149 */     statementBuilder.append(str2).append('(');
/* 150 */     statementBuilder.resetCount();
/* 151 */     for (IndexColumn indexColumn : arrayOfIndexColumn2) {
/* 152 */       statementBuilder.appendExceptFirst(", ");
/* 153 */       statementBuilder.append(indexColumn.getSQL());
/*     */     } 
/* 155 */     statementBuilder.append(')');
/* 156 */     if (paramBoolean && this.refIndexOwner && paramTable1 == this.table) {
/* 157 */       statementBuilder.append(" INDEX ").append(this.refIndex.getSQL());
/*     */     }
/* 159 */     if (this.deleteAction != 0) {
/* 160 */       statementBuilder.append(" ON DELETE ");
/* 161 */       appendAction(statementBuilder, this.deleteAction);
/*     */     } 
/* 163 */     if (this.updateAction != 0) {
/* 164 */       statementBuilder.append(" ON UPDATE ");
/* 165 */       appendAction(statementBuilder, this.updateAction);
/*     */     } 
/* 167 */     return statementBuilder.append(" NOCHECK").toString();
/*     */   }
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
/*     */   private String getShortDescription(Index paramIndex, SearchRow paramSearchRow) {
/* 180 */     StatementBuilder statementBuilder = new StatementBuilder(getName());
/* 181 */     statementBuilder.append(": ").append(this.table.getSQL()).append(" FOREIGN KEY(");
/* 182 */     for (IndexColumn indexColumn : this.columns) {
/* 183 */       statementBuilder.appendExceptFirst(", ");
/* 184 */       statementBuilder.append(indexColumn.getSQL());
/*     */     } 
/* 186 */     statementBuilder.append(") REFERENCES ").append(this.refTable.getSQL()).append('(');
/* 187 */     statementBuilder.resetCount();
/* 188 */     for (IndexColumn indexColumn : this.refColumns) {
/* 189 */       statementBuilder.appendExceptFirst(", ");
/* 190 */       statementBuilder.append(indexColumn.getSQL());
/*     */     } 
/* 192 */     statementBuilder.append(')');
/* 193 */     if (paramIndex != null && paramSearchRow != null) {
/* 194 */       statementBuilder.append(" (");
/* 195 */       statementBuilder.resetCount();
/* 196 */       Column[] arrayOfColumn = paramIndex.getColumns();
/* 197 */       int i = Math.min(this.columns.length, arrayOfColumn.length);
/* 198 */       for (byte b = 0; b < i; b++) {
/* 199 */         int j = arrayOfColumn[b].getColumnId();
/* 200 */         Value value = paramSearchRow.getValue(j);
/* 201 */         statementBuilder.appendExceptFirst(", ");
/* 202 */         statementBuilder.append((value == null) ? "" : value.toString());
/*     */       } 
/* 204 */       statementBuilder.append(')');
/*     */     } 
/* 206 */     return statementBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLWithoutIndexes() {
/* 211 */     return getCreateSQLForCopy(this.table, this.refTable, getSQL(), false);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/* 216 */     return getCreateSQLForCopy(this.table, getSQL());
/*     */   }
/*     */   
/*     */   public void setColumns(IndexColumn[] paramArrayOfIndexColumn) {
/* 220 */     this.columns = paramArrayOfIndexColumn;
/*     */   }
/*     */   
/*     */   public IndexColumn[] getColumns() {
/* 224 */     return this.columns;
/*     */   }
/*     */ 
/*     */   
/*     */   public HashSet<Column> getReferencedColumns(Table paramTable) {
/* 229 */     HashSet<Column> hashSet = New.hashSet();
/* 230 */     if (paramTable == this.table) {
/* 231 */       for (IndexColumn indexColumn : this.columns) {
/* 232 */         hashSet.add(indexColumn.column);
/*     */       }
/* 234 */     } else if (paramTable == this.refTable) {
/* 235 */       for (IndexColumn indexColumn : this.refColumns) {
/* 236 */         hashSet.add(indexColumn.column);
/*     */       }
/*     */     } 
/* 239 */     return hashSet;
/*     */   }
/*     */   
/*     */   public void setRefColumns(IndexColumn[] paramArrayOfIndexColumn) {
/* 243 */     this.refColumns = paramArrayOfIndexColumn;
/*     */   }
/*     */   
/*     */   public IndexColumn[] getRefColumns() {
/* 247 */     return this.refColumns;
/*     */   }
/*     */   
/*     */   public void setRefTable(Table paramTable) {
/* 251 */     this.refTable = paramTable;
/* 252 */     if (paramTable.isTemporary()) {
/* 253 */       setTemporary(true);
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
/*     */   public void setIndex(Index paramIndex, boolean paramBoolean) {
/* 265 */     this.index = paramIndex;
/* 266 */     this.indexOwner = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRefIndex(Index paramIndex, boolean paramBoolean) {
/* 277 */     this.refIndex = paramIndex;
/* 278 */     this.refIndexOwner = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 283 */     this.table.removeConstraint(this);
/* 284 */     this.refTable.removeConstraint(this);
/* 285 */     if (this.indexOwner) {
/* 286 */       this.table.removeIndexOrTransferOwnership(paramSession, this.index);
/*     */     }
/* 288 */     if (this.refIndexOwner) {
/* 289 */       this.refTable.removeIndexOrTransferOwnership(paramSession, this.refIndex);
/*     */     }
/* 291 */     this.database.removeMeta(paramSession, getId());
/* 292 */     this.refTable = null;
/* 293 */     this.index = null;
/* 294 */     this.refIndex = null;
/* 295 */     this.columns = null;
/* 296 */     this.refColumns = null;
/* 297 */     this.deleteSQL = null;
/* 298 */     this.updateSQL = null;
/* 299 */     this.table = null;
/* 300 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRow(Session paramSession, Table paramTable, Row paramRow1, Row paramRow2) {
/* 305 */     if (!this.database.getReferentialIntegrity()) {
/*     */       return;
/*     */     }
/* 308 */     if (!this.table.getCheckForeignKeyConstraints() || !this.refTable.getCheckForeignKeyConstraints()) {
/*     */       return;
/*     */     }
/*     */     
/* 312 */     if (paramTable == this.table && 
/* 313 */       !this.skipOwnTable) {
/* 314 */       checkRowOwnTable(paramSession, paramRow1, paramRow2);
/*     */     }
/*     */     
/* 317 */     if (paramTable == this.refTable) {
/* 318 */       checkRowRefTable(paramSession, paramRow1, paramRow2);
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkRowOwnTable(Session paramSession, Row paramRow1, Row paramRow2) {
/* 323 */     if (paramRow2 == null) {
/*     */       return;
/*     */     }
/* 326 */     boolean bool = (paramRow1 != null) ? true : false;
/* 327 */     for (IndexColumn indexColumn : this.columns) {
/* 328 */       int j = indexColumn.column.getColumnId();
/* 329 */       Value value = paramRow2.getValue(j);
/* 330 */       if (value == ValueNull.INSTANCE) {
/*     */         return;
/*     */       }
/*     */       
/* 334 */       if (bool && 
/* 335 */         !this.database.areEqual(value, paramRow1.getValue(j))) {
/* 336 */         bool = false;
/*     */       }
/*     */     } 
/*     */     
/* 340 */     if (bool) {
/*     */       return;
/*     */     }
/*     */     
/* 344 */     if (this.refTable == this.table) {
/*     */ 
/*     */       
/* 347 */       boolean bool1 = true; byte b1; int j;
/* 348 */       for (b1 = 0, j = this.columns.length; b1 < j; b1++) {
/* 349 */         int k = (this.columns[b1]).column.getColumnId();
/* 350 */         Value value1 = paramRow2.getValue(k);
/* 351 */         Column column = (this.refColumns[b1]).column;
/* 352 */         int m = column.getColumnId();
/* 353 */         Value value2 = paramRow2.getValue(m);
/* 354 */         if (!this.database.areEqual(value2, value1)) {
/* 355 */           bool1 = false;
/*     */           break;
/*     */         } 
/*     */       } 
/* 359 */       if (bool1) {
/*     */         return;
/*     */       }
/*     */     } 
/* 363 */     Row row = this.refTable.getTemplateRow(); byte b; int i;
/* 364 */     for (b = 0, i = this.columns.length; b < i; b++) {
/* 365 */       int j = (this.columns[b]).column.getColumnId();
/* 366 */       Value value = paramRow2.getValue(j);
/* 367 */       Column column = (this.refColumns[b]).column;
/* 368 */       int k = column.getColumnId();
/* 369 */       row.setValue(k, column.convert(value));
/*     */     } 
/* 371 */     if (!existsRow(paramSession, this.refIndex, (SearchRow)row, (Row)null)) {
/* 372 */       throw DbException.get(23506, getShortDescription(this.refIndex, row));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean existsRow(Session paramSession, Index paramIndex, SearchRow paramSearchRow, Row paramRow) {
/* 379 */     Table table = paramIndex.getTable();
/* 380 */     table.lock(paramSession, false, false);
/* 381 */     Cursor cursor = paramIndex.find(paramSession, paramSearchRow, paramSearchRow);
/* 382 */     while (cursor.next()) {
/*     */       
/* 384 */       SearchRow searchRow = cursor.getSearchRow();
/* 385 */       if (paramRow != null && searchRow.getKey() == paramRow.getKey()) {
/*     */         continue;
/*     */       }
/* 388 */       Column[] arrayOfColumn = paramIndex.getColumns();
/* 389 */       boolean bool = true;
/* 390 */       int i = Math.min(this.columns.length, arrayOfColumn.length);
/* 391 */       for (byte b = 0; b < i; b++) {
/* 392 */         int j = arrayOfColumn[b].getColumnId();
/* 393 */         Value value1 = paramSearchRow.getValue(j);
/* 394 */         Value value2 = searchRow.getValue(j);
/* 395 */         if (table.compareTypeSafe(value1, value2) != 0) {
/* 396 */           bool = false;
/*     */           break;
/*     */         } 
/*     */       } 
/* 400 */       if (bool) {
/* 401 */         return true;
/*     */       }
/*     */     } 
/* 404 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isEqual(Row paramRow1, Row paramRow2) {
/* 408 */     return (this.refIndex.compareRows((SearchRow)paramRow1, (SearchRow)paramRow2) == 0);
/*     */   }
/*     */   
/*     */   private void checkRow(Session paramSession, Row paramRow) {
/* 412 */     SearchRow searchRow = this.table.getTemplateSimpleRow(false); byte b; int i;
/* 413 */     for (b = 0, i = this.columns.length; b < i; b++) {
/* 414 */       Column column1 = (this.refColumns[b]).column;
/* 415 */       int j = column1.getColumnId();
/* 416 */       Column column2 = (this.columns[b]).column;
/* 417 */       Value value = column2.convert(paramRow.getValue(j));
/* 418 */       if (value == ValueNull.INSTANCE) {
/*     */         return;
/*     */       }
/* 421 */       searchRow.setValue(column2.getColumnId(), value);
/*     */     } 
/*     */     
/* 424 */     Row row = (this.refTable == this.table) ? paramRow : null;
/* 425 */     if (existsRow(paramSession, this.index, searchRow, row)) {
/* 426 */       throw DbException.get(23503, getShortDescription(this.index, searchRow));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void checkRowRefTable(Session paramSession, Row paramRow1, Row paramRow2) {
/* 432 */     if (paramRow1 == null) {
/*     */       return;
/*     */     }
/*     */     
/* 436 */     if (paramRow2 != null && isEqual(paramRow1, paramRow2)) {
/*     */       return;
/*     */     }
/*     */     
/* 440 */     if (paramRow2 == null) {
/*     */       
/* 442 */       if (this.deleteAction == 0) {
/* 443 */         checkRow(paramSession, paramRow1);
/*     */       } else {
/* 445 */         boolean bool = (this.deleteAction == 1) ? false : this.columns.length;
/* 446 */         Prepared prepared = getDelete(paramSession);
/* 447 */         setWhere(prepared, bool, paramRow1);
/* 448 */         updateWithSkipCheck(prepared);
/*     */       }
/*     */     
/*     */     }
/* 452 */     else if (this.updateAction == 0) {
/* 453 */       checkRow(paramSession, paramRow1);
/*     */     } else {
/* 455 */       Prepared prepared = getUpdate(paramSession);
/* 456 */       if (this.updateAction == 1) {
/* 457 */         ArrayList<Parameter> arrayList = prepared.getParameters(); byte b; int i;
/* 458 */         for (b = 0, i = this.columns.length; b < i; b++) {
/* 459 */           Parameter parameter = arrayList.get(b);
/* 460 */           Column column = (this.refColumns[b]).column;
/* 461 */           parameter.setValue(paramRow2.getValue(column.getColumnId()));
/*     */         } 
/*     */       } 
/* 464 */       setWhere(prepared, this.columns.length, paramRow1);
/* 465 */       updateWithSkipCheck(prepared);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateWithSkipCheck(Prepared paramPrepared) {
/*     */     try {
/* 476 */       this.skipOwnTable = true;
/* 477 */       paramPrepared.update();
/*     */     } finally {
/* 479 */       this.skipOwnTable = false;
/*     */     } 
/*     */   } private void setWhere(Prepared paramPrepared, int paramInt, Row paramRow) {
/*     */     byte b;
/*     */     int i;
/* 484 */     for (b = 0, i = this.refColumns.length; b < i; b++) {
/* 485 */       int j = (this.refColumns[b]).column.getColumnId();
/* 486 */       Value value = paramRow.getValue(j);
/* 487 */       ArrayList<Parameter> arrayList = paramPrepared.getParameters();
/* 488 */       Parameter parameter = arrayList.get(paramInt + b);
/* 489 */       parameter.setValue(value);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getDeleteAction() {
/* 494 */     return this.deleteAction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDeleteAction(int paramInt) {
/* 503 */     if (paramInt == this.deleteAction && this.deleteSQL == null) {
/*     */       return;
/*     */     }
/* 506 */     if (this.deleteAction != 0) {
/* 507 */       throw DbException.get(90045, "ON DELETE");
/*     */     }
/* 509 */     this.deleteAction = paramInt;
/* 510 */     buildDeleteSQL();
/*     */   }
/*     */   
/*     */   private void buildDeleteSQL() {
/* 514 */     if (this.deleteAction == 0) {
/*     */       return;
/*     */     }
/* 517 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 518 */     if (this.deleteAction == 1) {
/* 519 */       statementBuilder.append("DELETE FROM ").append(this.table.getSQL());
/*     */     } else {
/* 521 */       appendUpdate(statementBuilder);
/*     */     } 
/* 523 */     appendWhere(statementBuilder);
/* 524 */     this.deleteSQL = statementBuilder.toString();
/*     */   }
/*     */   
/*     */   private Prepared getUpdate(Session paramSession) {
/* 528 */     return prepare(paramSession, this.updateSQL, this.updateAction);
/*     */   }
/*     */   
/*     */   private Prepared getDelete(Session paramSession) {
/* 532 */     return prepare(paramSession, this.deleteSQL, this.deleteAction);
/*     */   }
/*     */   
/*     */   public int getUpdateAction() {
/* 536 */     return this.updateAction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateAction(int paramInt) {
/* 545 */     if (paramInt == this.updateAction && this.updateSQL == null) {
/*     */       return;
/*     */     }
/* 548 */     if (this.updateAction != 0) {
/* 549 */       throw DbException.get(90045, "ON UPDATE");
/*     */     }
/* 551 */     this.updateAction = paramInt;
/* 552 */     buildUpdateSQL();
/*     */   }
/*     */   
/*     */   private void buildUpdateSQL() {
/* 556 */     if (this.updateAction == 0) {
/*     */       return;
/*     */     }
/* 559 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 560 */     appendUpdate(statementBuilder);
/* 561 */     appendWhere(statementBuilder);
/* 562 */     this.updateSQL = statementBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void rebuild() {
/* 567 */     buildUpdateSQL();
/* 568 */     buildDeleteSQL();
/*     */   }
/*     */   
/*     */   private Prepared prepare(Session paramSession, String paramString, int paramInt) {
/* 572 */     Prepared prepared = paramSession.prepare(paramString);
/* 573 */     if (paramInt != 1) {
/* 574 */       ArrayList<Parameter> arrayList = prepared.getParameters(); byte b; int i;
/* 575 */       for (b = 0, i = this.columns.length; b < i; b++) {
/* 576 */         Value value; Column column = (this.columns[b]).column;
/* 577 */         Parameter parameter = arrayList.get(b);
/*     */         
/* 579 */         if (paramInt == 3) {
/* 580 */           ValueNull valueNull = ValueNull.INSTANCE;
/*     */         } else {
/* 582 */           Expression expression = column.getDefaultExpression();
/* 583 */           if (expression == null) {
/* 584 */             throw DbException.get(23507, column.getName());
/*     */           }
/* 586 */           value = expression.getValue(paramSession);
/*     */         } 
/* 588 */         parameter.setValue(value);
/*     */       } 
/*     */     } 
/* 591 */     return prepared;
/*     */   }
/*     */   
/*     */   private void appendUpdate(StatementBuilder paramStatementBuilder) {
/* 595 */     paramStatementBuilder.append("UPDATE ").append(this.table.getSQL()).append(" SET ");
/* 596 */     paramStatementBuilder.resetCount();
/* 597 */     for (IndexColumn indexColumn : this.columns) {
/* 598 */       paramStatementBuilder.appendExceptFirst(" , ");
/* 599 */       paramStatementBuilder.append(Parser.quoteIdentifier(indexColumn.column.getName())).append("=?");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void appendWhere(StatementBuilder paramStatementBuilder) {
/* 604 */     paramStatementBuilder.append(" WHERE ");
/* 605 */     paramStatementBuilder.resetCount();
/* 606 */     for (IndexColumn indexColumn : this.columns) {
/* 607 */       paramStatementBuilder.appendExceptFirst(" AND ");
/* 608 */       paramStatementBuilder.append(Parser.quoteIdentifier(indexColumn.column.getName())).append("=?");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Table getRefTable() {
/* 614 */     return this.refTable;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesIndex(Index paramIndex) {
/* 619 */     return (paramIndex == this.index || paramIndex == this.refIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIndexOwner(Index paramIndex) {
/* 624 */     if (this.index == paramIndex) {
/* 625 */       this.indexOwner = true;
/* 626 */     } else if (this.refIndex == paramIndex) {
/* 627 */       this.refIndexOwner = true;
/*     */     } else {
/* 629 */       DbException.throwInternalError();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBefore() {
/* 635 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkExistingData(Session paramSession) {
/* 640 */     if (paramSession.getDatabase().isStarting()) {
/*     */       return;
/*     */     }
/*     */     
/* 644 */     paramSession.startStatementWithinTransaction();
/* 645 */     StatementBuilder statementBuilder = new StatementBuilder("SELECT 1 FROM (SELECT ");
/* 646 */     for (IndexColumn indexColumn : this.columns) {
/* 647 */       statementBuilder.appendExceptFirst(", ");
/* 648 */       statementBuilder.append(indexColumn.getSQL());
/*     */     } 
/* 650 */     statementBuilder.append(" FROM ").append(this.table.getSQL()).append(" WHERE ");
/* 651 */     statementBuilder.resetCount();
/* 652 */     for (IndexColumn indexColumn : this.columns) {
/* 653 */       statementBuilder.appendExceptFirst(" AND ");
/* 654 */       statementBuilder.append(indexColumn.getSQL()).append(" IS NOT NULL ");
/*     */     } 
/* 656 */     statementBuilder.append(" ORDER BY ");
/* 657 */     statementBuilder.resetCount();
/* 658 */     for (IndexColumn indexColumn : this.columns) {
/* 659 */       statementBuilder.appendExceptFirst(", ");
/* 660 */       statementBuilder.append(indexColumn.getSQL());
/*     */     } 
/* 662 */     statementBuilder.append(") C WHERE NOT EXISTS(SELECT 1 FROM ").append(this.refTable.getSQL()).append(" P WHERE ");
/*     */     
/* 664 */     statementBuilder.resetCount();
/* 665 */     byte b = 0;
/* 666 */     for (IndexColumn indexColumn : this.columns) {
/* 667 */       statementBuilder.appendExceptFirst(" AND ");
/* 668 */       statementBuilder.append("C.").append(indexColumn.getSQL()).append('=').append("P.").append(this.refColumns[b++].getSQL());
/*     */     } 
/*     */     
/* 671 */     statementBuilder.append(')');
/* 672 */     String str = statementBuilder.toString();
/* 673 */     ResultInterface resultInterface = paramSession.prepare(str).query(1);
/* 674 */     if (resultInterface.next()) {
/* 675 */       throw DbException.get(23506, getShortDescription(null, null));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Index getUniqueIndex() {
/* 682 */     return this.refIndex;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\constraint\ConstraintReferential.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */