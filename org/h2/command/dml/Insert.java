/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.h2.command.Command;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Comparison;
/*     */ import org.h2.expression.ConditionAndOr;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionColumn;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.db.MVPrimaryIndex;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.ResultTarget;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StatementBuilder;
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
/*     */ public class Insert
/*     */   extends Prepared
/*     */   implements ResultTarget
/*     */ {
/*     */   private Table table;
/*     */   private Column[] columns;
/*  44 */   private final ArrayList<Expression[]> list = New.arrayList();
/*     */   
/*     */   private Query query;
/*     */   
/*     */   private boolean sortedInsertMode;
/*     */   
/*     */   private int rowNumber;
/*     */   
/*     */   private boolean insertFromSelect;
/*     */   private HashMap<Column, Expression> duplicateKeyAssignmentMap;
/*     */   
/*     */   public Insert(Session paramSession) {
/*  56 */     super(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCommand(Command paramCommand) {
/*  61 */     super.setCommand(paramCommand);
/*  62 */     if (this.query != null) {
/*  63 */       this.query.setCommand(paramCommand);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setTable(Table paramTable) {
/*  68 */     this.table = paramTable;
/*     */   }
/*     */   
/*     */   public void setColumns(Column[] paramArrayOfColumn) {
/*  72 */     this.columns = paramArrayOfColumn;
/*     */   }
/*     */   
/*     */   public void setQuery(Query paramQuery) {
/*  76 */     this.query = paramQuery;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAssignmentForDuplicate(Column paramColumn, Expression paramExpression) {
/*  87 */     if (this.duplicateKeyAssignmentMap == null) {
/*  88 */       this.duplicateKeyAssignmentMap = New.hashMap();
/*     */     }
/*  90 */     if (this.duplicateKeyAssignmentMap.containsKey(paramColumn)) {
/*  91 */       throw DbException.get(42121, paramColumn.getName());
/*     */     }
/*     */     
/*  94 */     this.duplicateKeyAssignmentMap.put(paramColumn, paramExpression);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRow(Expression[] paramArrayOfExpression) {
/* 103 */     this.list.add(paramArrayOfExpression);
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/* 108 */     Index index = null;
/* 109 */     if (this.sortedInsertMode) {
/* 110 */       index = this.table.getScanIndex(this.session);
/* 111 */       index.setSortedInsertMode(true);
/*     */     } 
/*     */     try {
/* 114 */       return insertRows();
/*     */     } finally {
/* 116 */       if (index != null) {
/* 117 */         index.setSortedInsertMode(false);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private int insertRows() {
/* 123 */     this.session.getUser().checkRight(this.table, 4);
/* 124 */     setCurrentRowNumber(0);
/* 125 */     this.table.fire(this.session, 1, true);
/* 126 */     this.rowNumber = 0;
/* 127 */     int i = this.list.size();
/* 128 */     if (i > 0) {
/* 129 */       int j = this.columns.length;
/* 130 */       for (byte b = 0; b < i; b++) {
/* 131 */         this.session.startStatementWithinTransaction();
/* 132 */         Row row = this.table.getTemplateRow();
/* 133 */         Expression[] arrayOfExpression = this.list.get(b);
/* 134 */         setCurrentRowNumber(b + 1);
/* 135 */         for (byte b1 = 0; b1 < j; b1++) {
/* 136 */           Column column = this.columns[b1];
/* 137 */           int k = column.getColumnId();
/* 138 */           Expression expression = arrayOfExpression[b1];
/* 139 */           if (expression != null) {
/*     */             
/* 141 */             expression = expression.optimize(this.session);
/*     */             try {
/* 143 */               Value value = column.convert(expression.getValue(this.session));
/* 144 */               row.setValue(k, value);
/* 145 */             } catch (DbException dbException) {
/* 146 */               throw setRow(dbException, b, getSQL(arrayOfExpression));
/*     */             } 
/*     */           } 
/*     */         } 
/* 150 */         this.rowNumber++;
/* 151 */         this.table.validateConvertUpdateSequence(this.session, row);
/* 152 */         boolean bool = this.table.fireBeforeRow(this.session, null, row);
/* 153 */         if (!bool) {
/* 154 */           this.table.lock(this.session, true, false);
/*     */           try {
/* 156 */             this.table.addRow(this.session, row);
/* 157 */           } catch (DbException dbException) {
/* 158 */             handleOnDuplicate(dbException);
/*     */           } 
/* 160 */           this.session.log(this.table, (short)0, row);
/* 161 */           this.table.fireAfterRow(this.session, null, row, false);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 165 */       this.table.lock(this.session, true, false);
/* 166 */       if (this.insertFromSelect) {
/* 167 */         this.query.query(0, this);
/*     */       } else {
/* 169 */         LocalResult localResult = this.query.query(0);
/* 170 */         while (localResult.next()) {
/* 171 */           Value[] arrayOfValue = localResult.currentRow();
/* 172 */           addRow(arrayOfValue);
/*     */         } 
/* 174 */         localResult.close();
/*     */       } 
/*     */     } 
/* 177 */     this.table.fire(this.session, 1, false);
/* 178 */     return this.rowNumber;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRow(Value[] paramArrayOfValue) {
/* 183 */     Row row = this.table.getTemplateRow();
/* 184 */     setCurrentRowNumber(++this.rowNumber); byte b; int i;
/* 185 */     for (b = 0, i = this.columns.length; b < i; b++) {
/* 186 */       Column column = this.columns[b];
/* 187 */       int j = column.getColumnId();
/*     */       try {
/* 189 */         Value value = column.convert(paramArrayOfValue[b]);
/* 190 */         row.setValue(j, value);
/* 191 */       } catch (DbException dbException) {
/* 192 */         throw setRow(dbException, this.rowNumber, getSQL(paramArrayOfValue));
/*     */       } 
/*     */     } 
/* 195 */     this.table.validateConvertUpdateSequence(this.session, row);
/* 196 */     boolean bool = this.table.fireBeforeRow(this.session, null, row);
/* 197 */     if (!bool) {
/* 198 */       this.table.addRow(this.session, row);
/* 199 */       this.session.log(this.table, (short)0, row);
/* 200 */       this.table.fireAfterRow(this.session, null, row, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/* 206 */     return this.rowNumber;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 211 */     StatementBuilder statementBuilder = new StatementBuilder("INSERT INTO ");
/* 212 */     statementBuilder.append(this.table.getSQL()).append('(');
/* 213 */     for (Column column : this.columns) {
/* 214 */       statementBuilder.appendExceptFirst(", ");
/* 215 */       statementBuilder.append(column.getSQL());
/*     */     } 
/* 217 */     statementBuilder.append(")\n");
/* 218 */     if (this.insertFromSelect) {
/* 219 */       statementBuilder.append("DIRECT ");
/*     */     }
/* 221 */     if (this.sortedInsertMode) {
/* 222 */       statementBuilder.append("SORTED ");
/*     */     }
/* 224 */     if (this.list.size() > 0) {
/* 225 */       statementBuilder.append("VALUES ");
/* 226 */       byte b = 0;
/* 227 */       if (this.list.size() > 1) {
/* 228 */         statementBuilder.append('\n');
/*     */       }
/* 230 */       for (Expression[] arrayOfExpression : this.list) {
/* 231 */         if (b++ > 0) {
/* 232 */           statementBuilder.append(",\n");
/*     */         }
/* 234 */         statementBuilder.append('(');
/* 235 */         statementBuilder.resetCount();
/* 236 */         for (Expression expression : arrayOfExpression) {
/* 237 */           statementBuilder.appendExceptFirst(", ");
/* 238 */           if (expression == null) {
/* 239 */             statementBuilder.append("DEFAULT");
/*     */           } else {
/* 241 */             statementBuilder.append(expression.getSQL());
/*     */           } 
/*     */         } 
/* 244 */         statementBuilder.append(')');
/*     */       } 
/*     */     } else {
/* 247 */       statementBuilder.append(this.query.getPlanSQL());
/*     */     } 
/* 249 */     return statementBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/* 254 */     if (this.columns == null) {
/* 255 */       if (this.list.size() > 0 && ((Expression[])this.list.get(0)).length == 0) {
/*     */         
/* 257 */         this.columns = new Column[0];
/*     */       } else {
/* 259 */         this.columns = this.table.getColumns();
/*     */       } 
/*     */     }
/* 262 */     if (this.list.size() > 0) {
/* 263 */       for (Expression[] arrayOfExpression : this.list) {
/* 264 */         if (arrayOfExpression.length != this.columns.length)
/* 265 */           throw DbException.get(21002);  byte b;
/*     */         int i;
/* 267 */         for (b = 0, i = arrayOfExpression.length; b < i; b++) {
/* 268 */           Expression expression = arrayOfExpression[b];
/* 269 */           if (expression != null) {
/* 270 */             expression = expression.optimize(this.session);
/* 271 */             if (expression instanceof Parameter) {
/* 272 */               Parameter parameter = (Parameter)expression;
/* 273 */               parameter.setColumn(this.columns[b]);
/*     */             } 
/* 275 */             arrayOfExpression[b] = expression;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/* 280 */       this.query.prepare();
/* 281 */       if (this.query.getColumnCount() != this.columns.length) {
/* 282 */         throw DbException.get(21002);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/* 289 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/* 294 */     return null;
/*     */   }
/*     */   
/*     */   public void setSortedInsertMode(boolean paramBoolean) {
/* 298 */     this.sortedInsertMode = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 303 */     return 61;
/*     */   }
/*     */   
/*     */   public void setInsertFromSelect(boolean paramBoolean) {
/* 307 */     this.insertFromSelect = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCacheable() {
/* 312 */     return (this.duplicateKeyAssignmentMap == null || this.duplicateKeyAssignmentMap.isEmpty());
/*     */   }
/*     */ 
/*     */   
/*     */   private void handleOnDuplicate(DbException paramDbException) {
/* 317 */     if (paramDbException.getErrorCode() != 23505) {
/* 318 */       throw paramDbException;
/*     */     }
/* 320 */     if (this.duplicateKeyAssignmentMap == null || this.duplicateKeyAssignmentMap.isEmpty())
/*     */     {
/* 322 */       throw paramDbException;
/*     */     }
/*     */     
/* 325 */     ArrayList<String> arrayList = new ArrayList(this.duplicateKeyAssignmentMap.size());
/*     */     
/* 327 */     for (byte b = 0; b < this.columns.length; b++) {
/* 328 */       String str1 = this.table.getSchema().getName() + "." + this.table.getName() + "." + this.columns[b].getName();
/*     */       
/* 330 */       arrayList.add(str1);
/* 331 */       this.session.setVariable(str1, ((Expression[])this.list.get(getCurrentRowNumber() - 1))[b].getValue(this.session));
/*     */     } 
/*     */ 
/*     */     
/* 335 */     StatementBuilder statementBuilder = new StatementBuilder("UPDATE ");
/* 336 */     statementBuilder.append(this.table.getSQL()).append(" SET ");
/* 337 */     for (Column column : this.duplicateKeyAssignmentMap.keySet()) {
/* 338 */       statementBuilder.appendExceptFirst(", ");
/* 339 */       Expression expression = this.duplicateKeyAssignmentMap.get(column);
/* 340 */       statementBuilder.append(column.getSQL()).append("=").append(expression.getSQL());
/*     */     } 
/* 342 */     statementBuilder.append(" WHERE ");
/* 343 */     Index index = (Index)paramDbException.getSource();
/* 344 */     if (index == null) {
/* 345 */       throw DbException.getUnsupportedException("Unable to apply ON DUPLICATE KEY UPDATE, no index found!");
/*     */     }
/*     */     
/* 348 */     statementBuilder.append(prepareUpdateCondition(index).getSQL());
/* 349 */     String str = statementBuilder.toString();
/* 350 */     Prepared prepared = this.session.prepare(str);
/* 351 */     for (Parameter parameter1 : prepared.getParameters()) {
/* 352 */       Parameter parameter2 = this.parameters.get(parameter1.getIndex());
/* 353 */       parameter1.setValue(parameter2.getValue(this.session));
/*     */     } 
/* 355 */     prepared.update();
/* 356 */     for (String str1 : arrayList) {
/* 357 */       this.session.setVariable(str1, (Value)ValueNull.INSTANCE);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Expression prepareUpdateCondition(Index paramIndex) {
/*     */     Column[] arrayOfColumn;
/*     */     ConditionAndOr conditionAndOr;
/* 368 */     if (paramIndex instanceof MVPrimaryIndex) {
/* 369 */       MVPrimaryIndex mVPrimaryIndex = (MVPrimaryIndex)paramIndex;
/* 370 */       arrayOfColumn = new Column[] { (mVPrimaryIndex.getIndexColumns()[mVPrimaryIndex.getMainIndexColumn()]).column };
/*     */     } else {
/*     */       
/* 373 */       arrayOfColumn = paramIndex.getColumns();
/*     */     } 
/*     */     
/* 376 */     Comparison comparison = null;
/* 377 */     for (Column column : arrayOfColumn) {
/* 378 */       ExpressionColumn expressionColumn = new ExpressionColumn(this.session.getDatabase(), this.table.getSchema().getName(), this.table.getName(), column.getName());
/*     */ 
/*     */       
/* 381 */       for (byte b = 0; b < this.columns.length; b++) {
/* 382 */         if (expressionColumn.getColumnName().equals(this.columns[b].getName())) {
/* 383 */           if (comparison == null) {
/* 384 */             comparison = new Comparison(this.session, 0, (Expression)expressionColumn, ((Expression[])this.list.get(getCurrentRowNumber() - 1))[b++]);
/*     */           } else {
/*     */             
/* 387 */             conditionAndOr = new ConditionAndOr(0, (Expression)comparison, (Expression)new Comparison(this.session, 0, (Expression)expressionColumn, ((Expression[])this.list.get(0))[b++]));
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 395 */     return (Expression)conditionAndOr;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\Insert.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */