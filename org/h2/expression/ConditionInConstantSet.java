/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.TreeSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.IndexCondition;
/*     */ import org.h2.message.DbException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConditionInConstantSet
/*     */   extends Condition
/*     */ {
/*     */   private Expression left;
/*     */   private int queryLevel;
/*     */   private final ArrayList<Expression> valueList;
/*     */   private final TreeSet<Value> valueSet;
/*     */   
/*     */   public ConditionInConstantSet(final Session session, Expression paramExpression, ArrayList<Expression> paramArrayList) {
/*  44 */     this.left = paramExpression;
/*  45 */     this.valueList = paramArrayList;
/*  46 */     this.valueSet = new TreeSet<>(new Comparator<Value>()
/*     */         {
/*     */           public int compare(Value param1Value1, Value param1Value2) {
/*  49 */             return session.getDatabase().compare(param1Value1, param1Value2);
/*     */           }
/*     */         });
/*  52 */     int i = paramExpression.getType();
/*  53 */     for (Expression expression : paramArrayList) {
/*  54 */       this.valueSet.add(expression.getValue(session).convertTo(i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  60 */     Value value = this.left.getValue(paramSession);
/*  61 */     if (value == ValueNull.INSTANCE) {
/*  62 */       return value;
/*     */     }
/*  64 */     boolean bool = this.valueSet.contains(value);
/*  65 */     if (!bool) {
/*  66 */       boolean bool1 = this.valueSet.contains(ValueNull.INSTANCE);
/*  67 */       if (bool1) {
/*  68 */         return (Value)ValueNull.INSTANCE;
/*     */       }
/*     */     } 
/*  71 */     return (Value)ValueBoolean.get(bool);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/*  76 */     this.left.mapColumns(paramColumnResolver, paramInt);
/*  77 */     this.queryLevel = Math.max(paramInt, this.queryLevel);
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  82 */     this.left = this.left.optimize(paramSession);
/*  83 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void createIndexConditions(Session paramSession, TableFilter paramTableFilter) {
/*  88 */     if (!(this.left instanceof ExpressionColumn)) {
/*     */       return;
/*     */     }
/*  91 */     ExpressionColumn expressionColumn = (ExpressionColumn)this.left;
/*  92 */     if (paramTableFilter != expressionColumn.getTableFilter()) {
/*     */       return;
/*     */     }
/*  95 */     if ((paramSession.getDatabase().getSettings()).optimizeInList) {
/*  96 */       paramTableFilter.addIndexCondition(IndexCondition.getInList(expressionColumn, this.valueList));
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 103 */     this.left.setEvaluatable(paramTableFilter, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 108 */     StatementBuilder statementBuilder = new StatementBuilder("(");
/* 109 */     statementBuilder.append(this.left.getSQL()).append(" IN(");
/* 110 */     for (Expression expression : this.valueList) {
/* 111 */       statementBuilder.appendExceptFirst(", ");
/* 112 */       statementBuilder.append(expression.getSQL());
/*     */     } 
/* 114 */     return statementBuilder.append("))").toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 119 */     this.left.updateAggregate(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 124 */     if (!this.left.isEverything(paramExpressionVisitor)) {
/* 125 */       return false;
/*     */     }
/* 127 */     switch (paramExpressionVisitor.getType()) {
/*     */       case 0:
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/*     */       case 9:
/* 138 */         return true;
/*     */     } 
/* 140 */     throw DbException.throwInternalError("type=" + paramExpressionVisitor.getType());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 146 */     return this.left.getCost();
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
/*     */   Expression getAdditional(Session paramSession, Comparison paramComparison) {
/* 159 */     Expression expression = paramComparison.getIfEquals(this.left);
/* 160 */     if (expression != null && 
/* 161 */       expression.isConstant()) {
/* 162 */       this.valueList.add(expression);
/* 163 */       this.valueSet.add(expression.getValue(paramSession).convertTo(this.left.getType()));
/* 164 */       return this;
/*     */     } 
/*     */     
/* 167 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ConditionInConstantSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */