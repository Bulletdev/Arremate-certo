/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import org.h2.command.dml.Query;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionColumn;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.value.CompareMode;
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
/*     */ public class IndexCondition
/*     */ {
/*     */   public static final int EQUALITY = 1;
/*     */   public static final int START = 2;
/*     */   public static final int END = 4;
/*     */   public static final int RANGE = 6;
/*     */   public static final int ALWAYS_FALSE = 8;
/*     */   public static final int SPATIAL_INTERSECTS = 16;
/*     */   private final Column column;
/*     */   private final int compareType;
/*     */   private final Expression expression;
/*     */   private List<Expression> expressionList;
/*     */   private Query expressionQuery;
/*     */   
/*     */   private IndexCondition(int paramInt, ExpressionColumn paramExpressionColumn, Expression paramExpression) {
/*  84 */     this.compareType = paramInt;
/*  85 */     this.column = (paramExpressionColumn == null) ? null : paramExpressionColumn.getColumn();
/*  86 */     this.expression = paramExpression;
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
/*     */   public static IndexCondition get(int paramInt, ExpressionColumn paramExpressionColumn, Expression paramExpression) {
/* 100 */     return new IndexCondition(paramInt, paramExpressionColumn, paramExpression);
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
/*     */   public static IndexCondition getInList(ExpressionColumn paramExpressionColumn, List<Expression> paramList) {
/* 113 */     IndexCondition indexCondition = new IndexCondition(9, paramExpressionColumn, null);
/*     */     
/* 115 */     indexCondition.expressionList = paramList;
/* 116 */     return indexCondition;
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
/*     */   public static IndexCondition getInQuery(ExpressionColumn paramExpressionColumn, Query paramQuery) {
/* 128 */     IndexCondition indexCondition = new IndexCondition(10, paramExpressionColumn, null);
/*     */     
/* 130 */     indexCondition.expressionQuery = paramQuery;
/* 131 */     return indexCondition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Value getCurrentValue(Session paramSession) {
/* 141 */     return this.expression.getValue(paramSession);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Value[] getCurrentValueList(Session paramSession) {
/* 152 */     HashSet<Value> hashSet = new HashSet();
/* 153 */     for (Expression expression : this.expressionList) {
/* 154 */       Value value = expression.getValue(paramSession);
/* 155 */       value = this.column.convert(value);
/* 156 */       hashSet.add(value);
/*     */     } 
/* 158 */     Value[] arrayOfValue = new Value[hashSet.size()];
/* 159 */     hashSet.toArray((Object[])arrayOfValue);
/* 160 */     final CompareMode mode = paramSession.getDatabase().getCompareMode();
/* 161 */     Arrays.sort(arrayOfValue, new Comparator<Value>()
/*     */         {
/*     */           public int compare(Value param1Value1, Value param1Value2) {
/* 164 */             return param1Value1.compareTo(param1Value2, mode);
/*     */           }
/*     */         });
/* 167 */     return arrayOfValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultInterface getCurrentResult() {
/* 177 */     return (ResultInterface)this.expressionQuery.query(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 186 */     if (this.compareType == 8) {
/* 187 */       return "FALSE";
/*     */     }
/* 189 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 190 */     statementBuilder.append(this.column.getSQL());
/* 191 */     switch (this.compareType) {
/*     */       case 0:
/* 193 */         statementBuilder.append(" = ");
/*     */         break;
/*     */       case 16:
/* 196 */         statementBuilder.append(" IS ");
/*     */         break;
/*     */       case 1:
/* 199 */         statementBuilder.append(" >= ");
/*     */         break;
/*     */       case 2:
/* 202 */         statementBuilder.append(" > ");
/*     */         break;
/*     */       case 3:
/* 205 */         statementBuilder.append(" <= ");
/*     */         break;
/*     */       case 4:
/* 208 */         statementBuilder.append(" < ");
/*     */         break;
/*     */       case 9:
/* 211 */         statementBuilder.append(" IN(");
/* 212 */         for (Expression expression : this.expressionList) {
/* 213 */           statementBuilder.appendExceptFirst(", ");
/* 214 */           statementBuilder.append(expression.getSQL());
/*     */         } 
/* 216 */         statementBuilder.append(')');
/*     */         break;
/*     */       case 10:
/* 219 */         statementBuilder.append(" IN(");
/* 220 */         statementBuilder.append(this.expressionQuery.getPlanSQL());
/* 221 */         statementBuilder.append(')');
/*     */         break;
/*     */       case 11:
/* 224 */         statementBuilder.append(" && ");
/*     */         break;
/*     */       default:
/* 227 */         DbException.throwInternalError("type=" + this.compareType); break;
/*     */     } 
/* 229 */     if (this.expression != null) {
/* 230 */       statementBuilder.append(this.expression.getSQL());
/*     */     }
/* 232 */     return statementBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMask(ArrayList<IndexCondition> paramArrayList) {
/* 242 */     switch (this.compareType) {
/*     */       case 8:
/* 244 */         return 8;
/*     */       case 0:
/*     */       case 16:
/* 247 */         return 1;
/*     */       case 9:
/*     */       case 10:
/* 250 */         if (paramArrayList.size() > 1 && 
/* 251 */           !"TABLE".equals(this.column.getTable().getTableType()))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 260 */           return 0;
/*     */         }
/*     */         
/* 263 */         return 1;
/*     */       case 1:
/*     */       case 2:
/* 266 */         return 2;
/*     */       case 3:
/*     */       case 4:
/* 269 */         return 4;
/*     */       case 11:
/* 271 */         return 16;
/*     */     } 
/* 273 */     throw DbException.throwInternalError("type=" + this.compareType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAlwaysFalse() {
/* 283 */     return (this.compareType == 8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStart() {
/* 293 */     switch (this.compareType) {
/*     */       case 0:
/*     */       case 1:
/*     */       case 2:
/*     */       case 16:
/* 298 */         return true;
/*     */     } 
/* 300 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnd() {
/* 311 */     switch (this.compareType) {
/*     */       case 0:
/*     */       case 3:
/*     */       case 4:
/*     */       case 16:
/* 316 */         return true;
/*     */     } 
/* 318 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSpatialIntersects() {
/* 329 */     switch (this.compareType) {
/*     */       case 11:
/* 331 */         return true;
/*     */     } 
/* 333 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCompareType() {
/* 338 */     return this.compareType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Column getColumn() {
/* 347 */     return this.column;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression getExpression() {
/* 356 */     return this.expression;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Expression> getExpressionList() {
/* 365 */     return this.expressionList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Query getExpressionQuery() {
/* 374 */     return this.expressionQuery;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEvaluatable() {
/* 383 */     if (this.expression != null) {
/* 384 */       return this.expression.isEverything(ExpressionVisitor.EVALUATABLE_VISITOR);
/*     */     }
/*     */     
/* 387 */     if (this.expressionList != null) {
/* 388 */       for (Expression expression : this.expressionList) {
/* 389 */         if (!expression.isEverything(ExpressionVisitor.EVALUATABLE_VISITOR)) {
/* 390 */           return false;
/*     */         }
/*     */       } 
/* 393 */       return true;
/*     */     } 
/* 395 */     return this.expressionQuery.isEverything(ExpressionVisitor.EVALUATABLE_VISITOR);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 401 */     return "column=" + this.column + ", compareType=" + compareTypeToString(this.compareType) + ", expression=" + this.expression + ", expressionList=" + this.expressionList.toString() + ", expressionQuery=" + this.expressionQuery;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String compareTypeToString(int paramInt) {
/* 409 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 410 */     if ((paramInt & 0x1) == 1) {
/* 411 */       statementBuilder.appendExceptFirst("&");
/* 412 */       statementBuilder.append("EQUALITY");
/*     */     } 
/* 414 */     if ((paramInt & 0x2) == 2) {
/* 415 */       statementBuilder.appendExceptFirst("&");
/* 416 */       statementBuilder.append("START");
/*     */     } 
/* 418 */     if ((paramInt & 0x4) == 4) {
/* 419 */       statementBuilder.appendExceptFirst("&");
/* 420 */       statementBuilder.append("END");
/*     */     } 
/* 422 */     if ((paramInt & 0x8) == 8) {
/* 423 */       statementBuilder.appendExceptFirst("&");
/* 424 */       statementBuilder.append("ALWAYS_FALSE");
/*     */     } 
/* 426 */     if ((paramInt & 0x10) == 16) {
/* 427 */       statementBuilder.appendExceptFirst("&");
/* 428 */       statementBuilder.append("SPATIAL_INTERSECTS");
/*     */     } 
/* 430 */     return statementBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\IndexCondition.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */