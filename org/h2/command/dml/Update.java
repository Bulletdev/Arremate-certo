/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.expression.ValueExpression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.RowList;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.PlanItem;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
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
/*     */ public class Update
/*     */   extends Prepared
/*     */ {
/*     */   private Expression condition;
/*     */   private TableFilter tableFilter;
/*     */   private Expression limitExpr;
/*  46 */   private final ArrayList<Column> columns = New.arrayList();
/*  47 */   private final HashMap<Column, Expression> expressionMap = New.hashMap();
/*     */   
/*     */   public Update(Session paramSession) {
/*  50 */     super(paramSession);
/*     */   }
/*     */   
/*     */   public void setTableFilter(TableFilter paramTableFilter) {
/*  54 */     this.tableFilter = paramTableFilter;
/*     */   }
/*     */   
/*     */   public void setCondition(Expression paramExpression) {
/*  58 */     this.condition = paramExpression;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAssignment(Column paramColumn, Expression paramExpression) {
/*  68 */     if (this.expressionMap.containsKey(paramColumn)) {
/*  69 */       throw DbException.get(42121, paramColumn.getName());
/*     */     }
/*     */     
/*  72 */     this.columns.add(paramColumn);
/*  73 */     this.expressionMap.put(paramColumn, paramExpression);
/*  74 */     if (paramExpression instanceof Parameter) {
/*  75 */       Parameter parameter = (Parameter)paramExpression;
/*  76 */       parameter.setColumn(paramColumn);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  82 */     this.tableFilter.startQuery(this.session);
/*  83 */     this.tableFilter.reset();
/*  84 */     RowList rowList = new RowList(this.session);
/*     */     try {
/*  86 */       Table table = this.tableFilter.getTable();
/*  87 */       this.session.getUser().checkRight(table, 8);
/*  88 */       table.fire(this.session, 2, true);
/*  89 */       table.lock(this.session, true, false);
/*  90 */       int i = (table.getColumns()).length;
/*     */       
/*  92 */       setCurrentRowNumber(0);
/*  93 */       byte b = 0;
/*  94 */       Column[] arrayOfColumn = table.getColumns();
/*  95 */       int j = -1;
/*  96 */       if (this.limitExpr != null) {
/*  97 */         Value value = this.limitExpr.getValue(this.session);
/*  98 */         if (value != ValueNull.INSTANCE) {
/*  99 */           j = value.getInt();
/*     */         }
/*     */       } 
/* 102 */       while (this.tableFilter.next()) {
/* 103 */         setCurrentRowNumber(b + 1);
/* 104 */         if (j >= 0 && b >= j) {
/*     */           break;
/*     */         }
/* 107 */         if (this.condition == null || Boolean.TRUE.equals(this.condition.getBooleanValue(this.session))) {
/*     */           boolean bool;
/* 109 */           Row row1 = this.tableFilter.get();
/* 110 */           Row row2 = table.getTemplateRow(); byte b1;
/* 111 */           for (b1 = 0; b1 < i; b1++) {
/* 112 */             Value value; Expression expression = this.expressionMap.get(arrayOfColumn[b1]);
/*     */             
/* 114 */             if (expression == null) {
/* 115 */               value = row1.getValue(b1);
/* 116 */             } else if (expression == ValueExpression.getDefault()) {
/* 117 */               Column column = table.getColumn(b1);
/* 118 */               value = table.getDefaultValue(this.session, column);
/*     */             } else {
/* 120 */               Column column = table.getColumn(b1);
/* 121 */               value = column.convert(expression.getValue(this.session));
/*     */             } 
/* 123 */             row2.setValue(b1, value);
/*     */           } 
/* 125 */           table.validateConvertUpdateSequence(this.session, row2);
/* 126 */           b1 = 0;
/* 127 */           if (table.fireRow()) {
/* 128 */             bool = table.fireBeforeRow(this.session, row1, row2);
/*     */           }
/* 130 */           if (!bool) {
/* 131 */             rowList.add(row1);
/* 132 */             rowList.add(row2);
/*     */           } 
/* 134 */           b++;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       table.updateRows(this, this.session, rowList);
/* 146 */       if (table.fireRow()) {
/* 147 */         rowList.invalidateCache();
/* 148 */         rowList.reset(); while (rowList.hasNext()) {
/* 149 */           Row row1 = rowList.next();
/* 150 */           Row row2 = rowList.next();
/* 151 */           table.fireAfterRow(this.session, row1, row2, false);
/*     */         } 
/*     */       } 
/* 154 */       table.fire(this.session, 2, false);
/* 155 */       return b;
/*     */     } finally {
/* 157 */       rowList.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 163 */     StatementBuilder statementBuilder = new StatementBuilder("UPDATE ");
/* 164 */     statementBuilder.append(this.tableFilter.getPlanSQL(false)).append("\nSET\n    "); byte b; int i;
/* 165 */     for (b = 0, i = this.columns.size(); b < i; b++) {
/* 166 */       Column column = this.columns.get(b);
/* 167 */       Expression expression = this.expressionMap.get(column);
/* 168 */       statementBuilder.appendExceptFirst(",\n    ");
/* 169 */       statementBuilder.append(column.getName()).append(" = ").append(expression.getSQL());
/*     */     } 
/* 171 */     if (this.condition != null) {
/* 172 */       statementBuilder.append("\nWHERE ").append(StringUtils.unEnclose(this.condition.getSQL()));
/*     */     }
/* 174 */     if (this.limitExpr != null) {
/* 175 */       statementBuilder.append("\nLIMIT ").append(StringUtils.unEnclose(this.limitExpr.getSQL()));
/*     */     }
/*     */     
/* 178 */     return statementBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/* 183 */     if (this.condition != null) {
/* 184 */       this.condition.mapColumns((ColumnResolver)this.tableFilter, 0);
/* 185 */       this.condition = this.condition.optimize(this.session);
/* 186 */       this.condition.createIndexConditions(this.session, this.tableFilter);
/*     */     }  byte b; int i;
/* 188 */     for (b = 0, i = this.columns.size(); b < i; b++) {
/* 189 */       Column column = this.columns.get(b);
/* 190 */       Expression expression = this.expressionMap.get(column);
/* 191 */       expression.mapColumns((ColumnResolver)this.tableFilter, 0);
/* 192 */       this.expressionMap.put(column, expression.optimize(this.session));
/*     */     } 
/* 194 */     TableFilter[] arrayOfTableFilter = { this.tableFilter };
/* 195 */     PlanItem planItem = this.tableFilter.getBestPlanItem(this.session, arrayOfTableFilter, 0, ExpressionVisitor.allColumnsForTableFilters(arrayOfTableFilter));
/*     */     
/* 197 */     this.tableFilter.setPlanItem(planItem);
/* 198 */     this.tableFilter.prepare();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/* 203 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/* 208 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 213 */     return 68;
/*     */   }
/*     */   
/*     */   public void setLimit(Expression paramExpression) {
/* 217 */     this.limitExpr = paramExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCacheable() {
/* 222 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\Update.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */