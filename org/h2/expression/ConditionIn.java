/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.IndexCondition;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueBoolean;
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
/*     */ public class ConditionIn
/*     */   extends Condition
/*     */ {
/*     */   private final Database database;
/*     */   private Expression left;
/*     */   private final ArrayList<Expression> valueList;
/*     */   private int queryLevel;
/*     */   
/*     */   public ConditionIn(Database paramDatabase, Expression paramExpression, ArrayList<Expression> paramArrayList) {
/*  38 */     this.database = paramDatabase;
/*  39 */     this.left = paramExpression;
/*  40 */     this.valueList = paramArrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  45 */     Value value = this.left.getValue(paramSession);
/*  46 */     if (value == ValueNull.INSTANCE) {
/*  47 */       return value;
/*     */     }
/*  49 */     boolean bool = false;
/*  50 */     boolean bool1 = false;
/*  51 */     for (Expression expression : this.valueList) {
/*  52 */       Value value1 = expression.getValue(paramSession);
/*  53 */       if (value1 == ValueNull.INSTANCE) {
/*  54 */         bool1 = true; continue;
/*     */       } 
/*  56 */       value1 = value1.convertTo(value.getType());
/*  57 */       bool = Comparison.compareNotNull(this.database, value, value1, 0);
/*  58 */       if (bool) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/*  63 */     if (!bool && bool1) {
/*  64 */       return (Value)ValueNull.INSTANCE;
/*     */     }
/*  66 */     return (Value)ValueBoolean.get(bool);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/*  71 */     this.left.mapColumns(paramColumnResolver, paramInt);
/*  72 */     for (Expression expression : this.valueList) {
/*  73 */       expression.mapColumns(paramColumnResolver, paramInt);
/*     */     }
/*  75 */     this.queryLevel = Math.max(paramInt, this.queryLevel);
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  80 */     this.left = this.left.optimize(paramSession);
/*  81 */     boolean bool = this.left.isConstant();
/*  82 */     if (bool && this.left == ValueExpression.getNull()) {
/*  83 */       return this.left;
/*     */     }
/*  85 */     boolean bool1 = true;
/*  86 */     boolean bool2 = true;
/*  87 */     int i = this.valueList.size(); int j;
/*  88 */     for (j = 0; j < i; j++) {
/*  89 */       Expression expression = this.valueList.get(j);
/*  90 */       expression = expression.optimize(paramSession);
/*  91 */       if (expression.isConstant() && expression.getValue(paramSession) != ValueNull.INSTANCE) {
/*  92 */         bool2 = false;
/*     */       }
/*  94 */       if (bool1 && !expression.isConstant()) {
/*  95 */         bool1 = false;
/*     */       }
/*  97 */       if (this.left instanceof ExpressionColumn && expression instanceof Parameter) {
/*  98 */         ((Parameter)expression).setColumn(((ExpressionColumn)this.left).getColumn());
/*     */       }
/*     */       
/* 101 */       this.valueList.set(j, expression);
/*     */     } 
/* 103 */     if (bool && bool1) {
/* 104 */       return ValueExpression.get(getValue(paramSession));
/*     */     }
/* 106 */     if (i == 1) {
/* 107 */       Expression expression = this.valueList.get(0);
/* 108 */       Comparison comparison = new Comparison(paramSession, 0, this.left, expression);
/* 109 */       return comparison.optimize(paramSession);
/*     */     } 
/*     */     
/* 112 */     if (bool1 && !bool2) {
/* 113 */       j = this.left.getType();
/* 114 */       if (j == -1) {
/* 115 */         return this;
/*     */       }
/* 117 */       ConditionInConstantSet conditionInConstantSet = new ConditionInConstantSet(paramSession, this.left, this.valueList);
/* 118 */       return conditionInConstantSet.optimize(paramSession);
/*     */     } 
/*     */     
/* 121 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void createIndexConditions(Session paramSession, TableFilter paramTableFilter) {
/* 126 */     if (!(this.left instanceof ExpressionColumn)) {
/*     */       return;
/*     */     }
/* 129 */     ExpressionColumn expressionColumn = (ExpressionColumn)this.left;
/* 130 */     if (paramTableFilter != expressionColumn.getTableFilter()) {
/*     */       return;
/*     */     }
/* 133 */     if ((paramSession.getDatabase().getSettings()).optimizeInList) {
/* 134 */       ExpressionVisitor expressionVisitor = ExpressionVisitor.getNotFromResolverVisitor((ColumnResolver)paramTableFilter);
/* 135 */       for (Expression expression : this.valueList) {
/* 136 */         if (!expression.isEverything(expressionVisitor)) {
/*     */           return;
/*     */         }
/*     */       } 
/* 140 */       paramTableFilter.addIndexCondition(IndexCondition.getInList(expressionColumn, this.valueList));
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 147 */     this.left.setEvaluatable(paramTableFilter, paramBoolean);
/* 148 */     for (Expression expression : this.valueList) {
/* 149 */       expression.setEvaluatable(paramTableFilter, paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 155 */     StatementBuilder statementBuilder = new StatementBuilder("(");
/* 156 */     statementBuilder.append(this.left.getSQL()).append(" IN(");
/* 157 */     for (Expression expression : this.valueList) {
/* 158 */       statementBuilder.appendExceptFirst(", ");
/* 159 */       statementBuilder.append(expression.getSQL());
/*     */     } 
/* 161 */     return statementBuilder.append("))").toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 166 */     this.left.updateAggregate(paramSession);
/* 167 */     for (Expression expression : this.valueList) {
/* 168 */       expression.updateAggregate(paramSession);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 174 */     if (!this.left.isEverything(paramExpressionVisitor)) {
/* 175 */       return false;
/*     */     }
/* 177 */     return areAllValues(paramExpressionVisitor);
/*     */   }
/*     */   
/*     */   private boolean areAllValues(ExpressionVisitor paramExpressionVisitor) {
/* 181 */     for (Expression expression : this.valueList) {
/* 182 */       if (!expression.isEverything(paramExpressionVisitor)) {
/* 183 */         return false;
/*     */       }
/*     */     } 
/* 186 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 191 */     int i = this.left.getCost();
/* 192 */     for (Expression expression : this.valueList) {
/* 193 */       i += expression.getCost();
/*     */     }
/* 195 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Expression getAdditional(Comparison paramComparison) {
/* 206 */     Expression expression = paramComparison.getIfEquals(this.left);
/* 207 */     if (expression != null) {
/* 208 */       this.valueList.add(expression);
/* 209 */       return this;
/*     */     } 
/* 211 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ConditionIn.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */