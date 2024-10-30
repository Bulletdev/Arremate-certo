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
/*     */ 
/*     */ public class Merge
/*     */   extends Prepared
/*     */ {
/*     */   private Table table;
/*     */   private Column[] columns;
/*     */   private Column[] keys;
/*  39 */   private final ArrayList<Expression[]> list = New.arrayList();
/*     */   private Query query;
/*     */   private Prepared update;
/*     */   
/*     */   public Merge(Session paramSession) {
/*  44 */     super(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCommand(Command paramCommand) {
/*  49 */     super.setCommand(paramCommand);
/*  50 */     if (this.query != null) {
/*  51 */       this.query.setCommand(paramCommand);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setTable(Table paramTable) {
/*  56 */     this.table = paramTable;
/*     */   }
/*     */   
/*     */   public void setColumns(Column[] paramArrayOfColumn) {
/*  60 */     this.columns = paramArrayOfColumn;
/*     */   }
/*     */   
/*     */   public void setKeys(Column[] paramArrayOfColumn) {
/*  64 */     this.keys = paramArrayOfColumn;
/*     */   }
/*     */   
/*     */   public void setQuery(Query paramQuery) {
/*  68 */     this.query = paramQuery;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRow(Expression[] paramArrayOfExpression) {
/*  77 */     this.list.add(paramArrayOfExpression);
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*     */     byte b;
/*  83 */     this.session.getUser().checkRight(this.table, 4);
/*  84 */     this.session.getUser().checkRight(this.table, 8);
/*  85 */     setCurrentRowNumber(0);
/*  86 */     if (this.list.size() > 0) {
/*  87 */       b = 0; byte b1; int i;
/*  88 */       for (b1 = 0, i = this.list.size(); b1 < i; b1++) {
/*  89 */         setCurrentRowNumber(b1 + 1);
/*  90 */         Expression[] arrayOfExpression = this.list.get(b1);
/*  91 */         Row row = this.table.getTemplateRow(); byte b2; int j;
/*  92 */         for (b2 = 0, j = this.columns.length; b2 < j; b2++) {
/*  93 */           Column column = this.columns[b2];
/*  94 */           int k = column.getColumnId();
/*  95 */           Expression expression = arrayOfExpression[b2];
/*  96 */           if (expression != null) {
/*     */             
/*     */             try {
/*  99 */               Value value = column.convert(expression.getValue(this.session));
/* 100 */               row.setValue(k, value);
/* 101 */             } catch (DbException dbException) {
/* 102 */               throw setRow(dbException, b, getSQL(arrayOfExpression));
/*     */             } 
/*     */           }
/*     */         } 
/* 106 */         merge(row);
/* 107 */         b++;
/*     */       } 
/*     */     } else {
/* 110 */       LocalResult localResult = this.query.query(0);
/* 111 */       b = 0;
/* 112 */       this.table.fire(this.session, 3, true);
/* 113 */       this.table.lock(this.session, true, false);
/* 114 */       while (localResult.next()) {
/* 115 */         b++;
/* 116 */         Value[] arrayOfValue = localResult.currentRow();
/* 117 */         Row row = this.table.getTemplateRow();
/* 118 */         setCurrentRowNumber(b);
/* 119 */         for (byte b1 = 0; b1 < this.columns.length; b1++) {
/* 120 */           Column column = this.columns[b1];
/* 121 */           int i = column.getColumnId();
/*     */           try {
/* 123 */             Value value = column.convert(arrayOfValue[b1]);
/* 124 */             row.setValue(i, value);
/* 125 */           } catch (DbException dbException) {
/* 126 */             throw setRow(dbException, b, getSQL(arrayOfValue));
/*     */           } 
/*     */         } 
/* 129 */         merge(row);
/*     */       } 
/* 131 */       localResult.close();
/* 132 */       this.table.fire(this.session, 3, false);
/*     */     } 
/* 134 */     return b;
/*     */   }
/*     */   
/*     */   private void merge(Row paramRow) {
/* 138 */     ArrayList<Parameter> arrayList = this.update.getParameters(); int i;
/* 139 */     for (i = 0; i < this.columns.length; i++) {
/* 140 */       Column column = this.columns[i];
/* 141 */       Value value = paramRow.getValue(column.getColumnId());
/* 142 */       Parameter parameter = arrayList.get(i);
/* 143 */       parameter.setValue(value);
/*     */     } 
/* 145 */     for (i = 0; i < this.keys.length; i++) {
/* 146 */       Column column = this.keys[i];
/* 147 */       Value value = paramRow.getValue(column.getColumnId());
/* 148 */       if (value == null) {
/* 149 */         throw DbException.get(90081, column.getSQL());
/*     */       }
/* 151 */       Parameter parameter = arrayList.get(this.columns.length + i);
/* 152 */       parameter.setValue(value);
/*     */     } 
/* 154 */     i = this.update.update();
/* 155 */     if (i == 0) {
/*     */       try {
/* 157 */         this.table.validateConvertUpdateSequence(this.session, paramRow);
/* 158 */         boolean bool = this.table.fireBeforeRow(this.session, null, paramRow);
/* 159 */         if (!bool) {
/* 160 */           this.table.lock(this.session, true, false);
/* 161 */           this.table.addRow(this.session, paramRow);
/* 162 */           this.session.log(this.table, (short)0, paramRow);
/* 163 */           this.table.fireAfterRow(this.session, null, paramRow, false);
/*     */         } 
/* 165 */       } catch (DbException dbException) {
/* 166 */         if (dbException.getErrorCode() == 23505) {
/*     */           
/* 168 */           Index index = (Index)dbException.getSource();
/* 169 */           if (index != null) {
/*     */             
/* 171 */             Column[] arrayOfColumn = index.getColumns();
/* 172 */             boolean bool = false;
/* 173 */             if (arrayOfColumn.length <= this.keys.length) {
/* 174 */               for (byte b = 0; b < arrayOfColumn.length; b++) {
/* 175 */                 if (arrayOfColumn[b] != this.keys[b]) {
/* 176 */                   bool = false;
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             }
/* 181 */             if (bool) {
/* 182 */               throw DbException.get(90131, this.table.getName());
/*     */             }
/*     */           } 
/*     */         } 
/* 186 */         throw dbException;
/*     */       } 
/* 188 */     } else if (i != 1) {
/* 189 */       throw DbException.get(23505, this.table.getSQL());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 195 */     StatementBuilder statementBuilder = new StatementBuilder("MERGE INTO ");
/* 196 */     statementBuilder.append(this.table.getSQL()).append('(');
/* 197 */     for (Column column : this.columns) {
/* 198 */       statementBuilder.appendExceptFirst(", ");
/* 199 */       statementBuilder.append(column.getSQL());
/*     */     } 
/* 201 */     statementBuilder.append(')');
/* 202 */     if (this.keys != null) {
/* 203 */       statementBuilder.append(" KEY(");
/* 204 */       statementBuilder.resetCount();
/* 205 */       for (Column column : this.keys) {
/* 206 */         statementBuilder.appendExceptFirst(", ");
/* 207 */         statementBuilder.append(column.getSQL());
/*     */       } 
/* 209 */       statementBuilder.append(')');
/*     */     } 
/* 211 */     statementBuilder.append('\n');
/* 212 */     if (this.list.size() > 0) {
/* 213 */       statementBuilder.append("VALUES ");
/* 214 */       byte b = 0;
/* 215 */       for (Expression[] arrayOfExpression : this.list) {
/* 216 */         if (b++ > 0) {
/* 217 */           statementBuilder.append(", ");
/*     */         }
/* 219 */         statementBuilder.append('(');
/* 220 */         statementBuilder.resetCount();
/* 221 */         for (Expression expression : arrayOfExpression) {
/* 222 */           statementBuilder.appendExceptFirst(", ");
/* 223 */           if (expression == null) {
/* 224 */             statementBuilder.append("DEFAULT");
/*     */           } else {
/* 226 */             statementBuilder.append(expression.getSQL());
/*     */           } 
/*     */         } 
/* 229 */         statementBuilder.append(')');
/*     */       } 
/*     */     } else {
/* 232 */       statementBuilder.append(this.query.getPlanSQL());
/*     */     } 
/* 234 */     return statementBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/* 239 */     if (this.columns == null) {
/* 240 */       if (this.list.size() > 0 && ((Expression[])this.list.get(0)).length == 0) {
/*     */         
/* 242 */         this.columns = new Column[0];
/*     */       } else {
/* 244 */         this.columns = this.table.getColumns();
/*     */       } 
/*     */     }
/* 247 */     if (this.list.size() > 0) {
/* 248 */       for (Expression[] arrayOfExpression : this.list) {
/* 249 */         if (arrayOfExpression.length != this.columns.length) {
/* 250 */           throw DbException.get(21002);
/*     */         }
/* 252 */         for (byte b = 0; b < arrayOfExpression.length; b++) {
/* 253 */           Expression expression = arrayOfExpression[b];
/* 254 */           if (expression != null) {
/* 255 */             arrayOfExpression[b] = expression.optimize(this.session);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } else {
/* 260 */       this.query.prepare();
/* 261 */       if (this.query.getColumnCount() != this.columns.length) {
/* 262 */         throw DbException.get(21002);
/*     */       }
/*     */     } 
/* 265 */     if (this.keys == null) {
/* 266 */       Index index = this.table.getPrimaryKey();
/* 267 */       if (index == null) {
/* 268 */         throw DbException.get(90057, "PRIMARY KEY");
/*     */       }
/* 270 */       this.keys = index.getColumns();
/*     */     } 
/* 272 */     StatementBuilder statementBuilder = new StatementBuilder("UPDATE ");
/* 273 */     statementBuilder.append(this.table.getSQL()).append(" SET ");
/* 274 */     for (Column column : this.columns) {
/* 275 */       statementBuilder.appendExceptFirst(", ");
/* 276 */       statementBuilder.append(column.getSQL()).append("=?");
/*     */     } 
/* 278 */     statementBuilder.append(" WHERE ");
/* 279 */     statementBuilder.resetCount();
/* 280 */     for (Column column : this.keys) {
/* 281 */       statementBuilder.appendExceptFirst(" AND ");
/* 282 */       statementBuilder.append(column.getSQL()).append("=?");
/*     */     } 
/* 284 */     String str = statementBuilder.toString();
/* 285 */     this.update = this.session.prepare(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/* 290 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/* 295 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 300 */     return 62;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCacheable() {
/* 305 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\Merge.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */