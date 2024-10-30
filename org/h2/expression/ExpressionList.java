/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.StatementBuilder;
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
/*     */ public class ExpressionList
/*     */   extends Expression
/*     */ {
/*     */   private final Expression[] list;
/*     */   
/*     */   public ExpressionList(Expression[] paramArrayOfExpression) {
/*  25 */     this.list = paramArrayOfExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  30 */     Value[] arrayOfValue = new Value[this.list.length];
/*  31 */     for (byte b = 0; b < this.list.length; b++) {
/*  32 */       arrayOfValue[b] = this.list[b].getValue(paramSession);
/*     */     }
/*  34 */     return (Value)ValueArray.get(arrayOfValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  39 */     return 17;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/*  44 */     for (Expression expression : this.list) {
/*  45 */       expression.mapColumns(paramColumnResolver, paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  51 */     boolean bool = true;
/*  52 */     for (byte b = 0; b < this.list.length; b++) {
/*  53 */       Expression expression = this.list[b].optimize(paramSession);
/*  54 */       if (!expression.isConstant()) {
/*  55 */         bool = false;
/*     */       }
/*  57 */       this.list[b] = expression;
/*     */     } 
/*  59 */     if (bool) {
/*  60 */       return ValueExpression.get(getValue(paramSession));
/*     */     }
/*  62 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/*  67 */     for (Expression expression : this.list) {
/*  68 */       expression.setEvaluatable(paramTableFilter, paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/*  74 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  79 */     return 2147483647L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/*  84 */     return Integer.MAX_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  89 */     StatementBuilder statementBuilder = new StatementBuilder("(");
/*  90 */     for (Expression expression : this.list) {
/*  91 */       statementBuilder.appendExceptFirst(", ");
/*  92 */       statementBuilder.append(expression.getSQL());
/*     */     } 
/*  94 */     if (this.list.length == 1) {
/*  95 */       statementBuilder.append(',');
/*     */     }
/*  97 */     return statementBuilder.append(')').toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 102 */     for (Expression expression : this.list) {
/* 103 */       expression.updateAggregate(paramSession);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 109 */     for (Expression expression : this.list) {
/* 110 */       if (!expression.isEverything(paramExpressionVisitor)) {
/* 111 */         return false;
/*     */       }
/*     */     } 
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 119 */     int i = 1;
/* 120 */     for (Expression expression : this.list) {
/* 121 */       i += expression.getCost();
/*     */     }
/* 123 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression[] getExpressionColumns(Session paramSession) {
/* 128 */     ExpressionColumn[] arrayOfExpressionColumn = new ExpressionColumn[this.list.length];
/* 129 */     for (byte b = 0; b < this.list.length; b++) {
/* 130 */       Expression expression = this.list[b];
/* 131 */       Column column = new Column("C" + (b + 1), expression.getType(), expression.getPrecision(), expression.getScale(), expression.getDisplaySize());
/*     */ 
/*     */       
/* 134 */       arrayOfExpressionColumn[b] = new ExpressionColumn(paramSession.getDatabase(), column);
/*     */     } 
/* 136 */     return (Expression[])arrayOfExpressionColumn;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ExpressionList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */