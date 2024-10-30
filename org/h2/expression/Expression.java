/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueArray;
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
/*     */ public abstract class Expression
/*     */ {
/*     */   private boolean addedToFilter;
/*     */   
/*     */   public abstract Value getValue(Session paramSession);
/*     */   
/*     */   public abstract int getType();
/*     */   
/*     */   public abstract void mapColumns(ColumnResolver paramColumnResolver, int paramInt);
/*     */   
/*     */   public abstract Expression optimize(Session paramSession);
/*     */   
/*     */   public abstract void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean);
/*     */   
/*     */   public abstract int getScale();
/*     */   
/*     */   public abstract long getPrecision();
/*     */   
/*     */   public abstract int getDisplaySize();
/*     */   
/*     */   public abstract String getSQL();
/*     */   
/*     */   public abstract void updateAggregate(Session paramSession);
/*     */   
/*     */   public abstract boolean isEverything(ExpressionVisitor paramExpressionVisitor);
/*     */   
/*     */   public abstract int getCost();
/*     */   
/*     */   public Expression getNotIfPossible(Session paramSession) {
/* 139 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConstant() {
/* 148 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValueSet() {
/* 157 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoIncrement() {
/* 166 */     return false;
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
/*     */   public Boolean getBooleanValue(Session paramSession) {
/* 178 */     return getValue(paramSession).getBoolean();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createIndexConditions(Session paramSession, TableFilter paramTableFilter) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getColumnName() {
/* 197 */     return getAlias();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSchemaName() {
/* 206 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTableName() {
/* 215 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNullable() {
/* 224 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTableAlias() {
/* 234 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAlias() {
/* 244 */     return StringUtils.unEnclose(getSQL());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWildcard() {
/* 253 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression getNonAliasExpression() {
/* 262 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFilterConditions(TableFilter paramTableFilter, boolean paramBoolean) {
/* 272 */     if (!this.addedToFilter && !paramBoolean && isEverything(ExpressionVisitor.EVALUATABLE_VISITOR)) {
/*     */       
/* 274 */       paramTableFilter.addFilterCondition(this, false);
/* 275 */       this.addedToFilter = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 286 */     return getSQL();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression[] getExpressionColumns(Session paramSession) {
/* 296 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Expression[] getExpressionColumns(Session paramSession, ValueArray paramValueArray) {
/* 307 */     Value[] arrayOfValue = paramValueArray.getList();
/* 308 */     ExpressionColumn[] arrayOfExpressionColumn = new ExpressionColumn[arrayOfValue.length]; byte b; int i;
/* 309 */     for (b = 0, i = arrayOfValue.length; b < i; b++) {
/* 310 */       Value value = arrayOfValue[b];
/* 311 */       Column column = new Column("C" + (b + 1), value.getType(), value.getPrecision(), value.getScale(), value.getDisplaySize());
/*     */ 
/*     */       
/* 314 */       arrayOfExpressionColumn[b] = new ExpressionColumn(paramSession.getDatabase(), column);
/*     */     } 
/* 316 */     return (Expression[])arrayOfExpressionColumn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Expression[] getExpressionColumns(Session paramSession, ResultSet paramResultSet) {
/*     */     try {
/* 328 */       ResultSetMetaData resultSetMetaData = paramResultSet.getMetaData();
/* 329 */       int i = resultSetMetaData.getColumnCount();
/* 330 */       Expression[] arrayOfExpression = new Expression[i];
/* 331 */       Database database = (paramSession == null) ? null : paramSession.getDatabase();
/* 332 */       for (byte b = 0; b < i; b++) {
/* 333 */         String str = resultSetMetaData.getColumnLabel(b + 1);
/* 334 */         int j = DataType.getValueTypeFromResultSet(resultSetMetaData, b + 1);
/* 335 */         int k = resultSetMetaData.getPrecision(b + 1);
/* 336 */         int m = resultSetMetaData.getScale(b + 1);
/* 337 */         int n = resultSetMetaData.getColumnDisplaySize(b + 1);
/* 338 */         Column column = new Column(str, j, k, m, n);
/* 339 */         ExpressionColumn expressionColumn = new ExpressionColumn(database, column);
/* 340 */         arrayOfExpression[b] = expressionColumn;
/*     */       } 
/* 342 */       return arrayOfExpression;
/* 343 */     } catch (SQLException sQLException) {
/* 344 */       throw DbException.convert(sQLException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Expression.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */