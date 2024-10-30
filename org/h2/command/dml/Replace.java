/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.command.Command;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.value.Value;
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
/*     */ public class Replace
/*     */   extends Prepared
/*     */ {
/*     */   private Table table;
/*     */   private Column[] columns;
/*     */   private Column[] keys;
/*  38 */   private final ArrayList<Expression[]> list = New.arrayList();
/*     */   private Query query;
/*     */   private Prepared update;
/*     */   
/*     */   public Replace(Session paramSession) {
/*  43 */     super(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCommand(Command paramCommand) {
/*  48 */     super.setCommand(paramCommand);
/*  49 */     if (this.query != null) {
/*  50 */       this.query.setCommand(paramCommand);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setTable(Table paramTable) {
/*  55 */     this.table = paramTable;
/*     */   }
/*     */   
/*     */   public void setColumns(Column[] paramArrayOfColumn) {
/*  59 */     this.columns = paramArrayOfColumn;
/*     */   }
/*     */   
/*     */   public void setKeys(Column[] paramArrayOfColumn) {
/*  63 */     this.keys = paramArrayOfColumn;
/*     */   }
/*     */   
/*     */   public void setQuery(Query paramQuery) {
/*  67 */     this.query = paramQuery;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRow(Expression[] paramArrayOfExpression) {
/*  76 */     this.list.add(paramArrayOfExpression);
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*     */     byte b;
/*  82 */     this.session.getUser().checkRight(this.table, 4);
/*  83 */     this.session.getUser().checkRight(this.table, 8);
/*  84 */     setCurrentRowNumber(0);
/*  85 */     if (this.list.size() > 0) {
/*  86 */       b = 0; byte b1; int i;
/*  87 */       for (b1 = 0, i = this.list.size(); b1 < i; b1++) {
/*  88 */         setCurrentRowNumber(b1 + 1);
/*  89 */         Expression[] arrayOfExpression = this.list.get(b1);
/*  90 */         Row row = this.table.getTemplateRow(); byte b2; int j;
/*  91 */         for (b2 = 0, j = this.columns.length; b2 < j; b2++) {
/*  92 */           Column column = this.columns[b2];
/*  93 */           int k = column.getColumnId();
/*  94 */           Expression expression = arrayOfExpression[b2];
/*  95 */           if (expression != null) {
/*     */             
/*     */             try {
/*  98 */               Value value = column.convert(expression.getValue(this.session));
/*  99 */               row.setValue(k, value);
/* 100 */             } catch (DbException dbException) {
/* 101 */               throw setRow(dbException, b, getSQL(arrayOfExpression));
/*     */             } 
/*     */           }
/*     */         } 
/* 105 */         replace(row);
/* 106 */         b++;
/*     */       } 
/*     */     } else {
/* 109 */       LocalResult localResult = this.query.query(0);
/* 110 */       b = 0;
/* 111 */       this.table.fire(this.session, 3, true);
/* 112 */       this.table.lock(this.session, true, false);
/* 113 */       while (localResult.next()) {
/* 114 */         b++;
/* 115 */         Value[] arrayOfValue = localResult.currentRow();
/* 116 */         Row row = this.table.getTemplateRow();
/* 117 */         setCurrentRowNumber(b);
/* 118 */         for (byte b1 = 0; b1 < this.columns.length; b1++) {
/* 119 */           Column column = this.columns[b1];
/* 120 */           int i = column.getColumnId();
/*     */           try {
/* 122 */             Value value = column.convert(arrayOfValue[b1]);
/* 123 */             row.setValue(i, value);
/* 124 */           } catch (DbException dbException) {
/* 125 */             throw setRow(dbException, b, getSQL(arrayOfValue));
/*     */           } 
/*     */         } 
/* 128 */         replace(row);
/*     */       } 
/* 130 */       localResult.close();
/* 131 */       this.table.fire(this.session, 3, false);
/*     */     } 
/* 133 */     return b;
/*     */   }
/*     */   
/*     */   private void replace(Row paramRow) {
/* 137 */     int i = update(paramRow);
/* 138 */     if (i == 0) {
/*     */       try {
/* 140 */         this.table.validateConvertUpdateSequence(this.session, paramRow);
/* 141 */         boolean bool = this.table.fireBeforeRow(this.session, null, paramRow);
/* 142 */         if (!bool) {
/* 143 */           this.table.lock(this.session, true, false);
/* 144 */           this.table.addRow(this.session, paramRow);
/* 145 */           this.session.log(this.table, (short)0, paramRow);
/* 146 */           this.table.fireAfterRow(this.session, null, paramRow, false);
/*     */         } 
/* 148 */       } catch (DbException dbException) {
/* 149 */         if (dbException.getErrorCode() == 23505) {
/*     */           
/* 151 */           Index index = (Index)dbException.getSource();
/* 152 */           if (index != null) {
/*     */             
/* 154 */             Column[] arrayOfColumn = index.getColumns();
/* 155 */             boolean bool = false;
/* 156 */             if (arrayOfColumn.length <= this.keys.length) {
/* 157 */               for (byte b = 0; b < arrayOfColumn.length; b++) {
/* 158 */                 if (arrayOfColumn[b] != this.keys[b]) {
/* 159 */                   bool = false;
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             }
/* 164 */             if (bool) {
/* 165 */               throw DbException.get(90131, this.table.getName());
/*     */             }
/*     */           } 
/*     */         } 
/* 169 */         throw dbException;
/*     */       } 
/* 171 */     } else if (i != 1) {
/* 172 */       throw DbException.get(23505, this.table.getSQL());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int update(Row paramRow) {
/* 179 */     if (this.update == null) {
/* 180 */       return 0;
/*     */     }
/* 182 */     ArrayList<Parameter> arrayList = this.update.getParameters(); byte b;
/* 183 */     for (b = 0; b < this.columns.length; b++) {
/* 184 */       Column column = this.columns[b];
/* 185 */       Value value = paramRow.getValue(column.getColumnId());
/* 186 */       Parameter parameter = arrayList.get(b);
/* 187 */       parameter.setValue(value);
/*     */     } 
/* 189 */     for (b = 0; b < this.keys.length; b++) {
/* 190 */       Column column = this.keys[b];
/* 191 */       Value value = paramRow.getValue(column.getColumnId());
/* 192 */       if (value == null) {
/* 193 */         throw DbException.get(90081, column.getSQL());
/*     */       }
/* 195 */       Parameter parameter = arrayList.get(this.columns.length + b);
/* 196 */       parameter.setValue(value);
/*     */     } 
/* 198 */     return this.update.update();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 203 */     StatementBuilder statementBuilder = new StatementBuilder("REPLACE INTO ");
/* 204 */     statementBuilder.append(this.table.getSQL()).append('(');
/* 205 */     for (Column column : this.columns) {
/* 206 */       statementBuilder.appendExceptFirst(", ");
/* 207 */       statementBuilder.append(column.getSQL());
/*     */     } 
/* 209 */     statementBuilder.append(')');
/* 210 */     statementBuilder.append('\n');
/* 211 */     if (this.list.size() > 0) {
/* 212 */       statementBuilder.append("VALUES ");
/* 213 */       byte b = 0;
/* 214 */       for (Expression[] arrayOfExpression : this.list) {
/* 215 */         if (b++ > 0) {
/* 216 */           statementBuilder.append(", ");
/*     */         }
/* 218 */         statementBuilder.append('(');
/* 219 */         statementBuilder.resetCount();
/* 220 */         for (Expression expression : arrayOfExpression) {
/* 221 */           statementBuilder.appendExceptFirst(", ");
/* 222 */           if (expression == null) {
/* 223 */             statementBuilder.append("DEFAULT");
/*     */           } else {
/* 225 */             statementBuilder.append(expression.getSQL());
/*     */           } 
/*     */         } 
/* 228 */         statementBuilder.append(')');
/*     */       } 
/*     */     } else {
/* 231 */       statementBuilder.append(this.query.getPlanSQL());
/*     */     } 
/* 233 */     return statementBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/* 238 */     if (this.columns == null) {
/* 239 */       if (this.list.size() > 0 && ((Expression[])this.list.get(0)).length == 0) {
/*     */         
/* 241 */         this.columns = new Column[0];
/*     */       } else {
/* 243 */         this.columns = this.table.getColumns();
/*     */       } 
/*     */     }
/* 246 */     if (this.list.size() > 0) {
/* 247 */       for (Expression[] arrayOfExpression : this.list) {
/* 248 */         if (arrayOfExpression.length != this.columns.length) {
/* 249 */           throw DbException.get(21002);
/*     */         }
/* 251 */         for (byte b = 0; b < arrayOfExpression.length; b++) {
/* 252 */           Expression expression = arrayOfExpression[b];
/* 253 */           if (expression != null) {
/* 254 */             arrayOfExpression[b] = expression.optimize(this.session);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } else {
/* 259 */       this.query.prepare();
/* 260 */       if (this.query.getColumnCount() != this.columns.length) {
/* 261 */         throw DbException.get(21002);
/*     */       }
/*     */     } 
/* 264 */     if (this.keys == null) {
/* 265 */       Index index = this.table.getPrimaryKey();
/* 266 */       if (index == null) {
/* 267 */         throw DbException.get(90057, "PRIMARY KEY");
/*     */       }
/* 269 */       this.keys = index.getColumns();
/*     */     } 
/*     */ 
/*     */     
/* 273 */     for (Column column : this.keys) {
/* 274 */       boolean bool = false;
/* 275 */       for (Column column1 : this.columns) {
/* 276 */         if (column1.getColumnId() == column.getColumnId()) {
/* 277 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 281 */       if (!bool) {
/*     */         return;
/*     */       }
/*     */     } 
/* 285 */     StatementBuilder statementBuilder = new StatementBuilder("UPDATE ");
/* 286 */     statementBuilder.append(this.table.getSQL()).append(" SET ");
/* 287 */     for (Column column : this.columns) {
/* 288 */       statementBuilder.appendExceptFirst(", ");
/* 289 */       statementBuilder.append(column.getSQL()).append("=?");
/*     */     } 
/* 291 */     statementBuilder.append(" WHERE ");
/* 292 */     statementBuilder.resetCount();
/* 293 */     for (Column column : this.keys) {
/* 294 */       statementBuilder.appendExceptFirst(" AND ");
/* 295 */       statementBuilder.append(column.getSQL()).append("=?");
/*     */     } 
/* 297 */     String str = statementBuilder.toString();
/* 298 */     this.update = this.session.prepare(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/* 303 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/* 308 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 313 */     return 63;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCacheable() {
/* 318 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\Replace.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */