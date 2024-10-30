/*    */ package org.h2.expression;
/*    */ 
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.table.ColumnResolver;
/*    */ import org.h2.table.TableFilter;
/*    */ import org.h2.value.Value;
/*    */ import org.h2.value.ValueNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConditionNot
/*    */   extends Condition
/*    */ {
/*    */   private Expression condition;
/*    */   
/*    */   public ConditionNot(Expression paramExpression) {
/* 22 */     this.condition = paramExpression;
/*    */   }
/*    */ 
/*    */   
/*    */   public Expression getNotIfPossible(Session paramSession) {
/* 27 */     return this.condition;
/*    */   }
/*    */ 
/*    */   
/*    */   public Value getValue(Session paramSession) {
/* 32 */     Value value = this.condition.getValue(paramSession);
/* 33 */     if (value == ValueNull.INSTANCE) {
/* 34 */       return value;
/*    */     }
/* 36 */     return value.convertTo(1).negate();
/*    */   }
/*    */ 
/*    */   
/*    */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 41 */     this.condition.mapColumns(paramColumnResolver, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public Expression optimize(Session paramSession) {
/* 46 */     Expression expression1 = this.condition.getNotIfPossible(paramSession);
/* 47 */     if (expression1 != null) {
/* 48 */       return expression1.optimize(paramSession);
/*    */     }
/* 50 */     Expression expression2 = this.condition.optimize(paramSession);
/* 51 */     if (expression2.isConstant()) {
/* 52 */       Value value = expression2.getValue(paramSession);
/* 53 */       if (value == ValueNull.INSTANCE) {
/* 54 */         return ValueExpression.getNull();
/*    */       }
/* 56 */       return ValueExpression.get(value.convertTo(1).negate());
/*    */     } 
/* 58 */     this.condition = expression2;
/* 59 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 64 */     this.condition.setEvaluatable(paramTableFilter, paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSQL() {
/* 69 */     return "(NOT " + this.condition.getSQL() + ")";
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateAggregate(Session paramSession) {
/* 74 */     this.condition.updateAggregate(paramSession);
/*    */   }
/*    */ 
/*    */   
/*    */   public void addFilterConditions(TableFilter paramTableFilter, boolean paramBoolean) {
/* 79 */     if (paramBoolean) {
/*    */       return;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 88 */     super.addFilterConditions(paramTableFilter, paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 93 */     return this.condition.isEverything(paramExpressionVisitor);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCost() {
/* 98 */     return this.condition.getCost();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ConditionNot.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */