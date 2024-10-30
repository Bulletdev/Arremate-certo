/*    */ package org.h2.expression;
/*    */ 
/*    */ import org.h2.command.dml.Query;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.result.LocalResult;
/*    */ import org.h2.table.ColumnResolver;
/*    */ import org.h2.table.TableFilter;
/*    */ import org.h2.util.StringUtils;
/*    */ import org.h2.value.Value;
/*    */ import org.h2.value.ValueBoolean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConditionExists
/*    */   extends Condition
/*    */ {
/*    */   private final Query query;
/*    */   
/*    */   public ConditionExists(Query paramQuery) {
/* 25 */     this.query = paramQuery;
/*    */   }
/*    */ 
/*    */   
/*    */   public Value getValue(Session paramSession) {
/* 30 */     this.query.setSession(paramSession);
/* 31 */     LocalResult localResult = this.query.query(1);
/* 32 */     paramSession.addTemporaryResult(localResult);
/* 33 */     boolean bool = (localResult.getRowCount() > 0) ? true : false;
/* 34 */     return (Value)ValueBoolean.get(bool);
/*    */   }
/*    */ 
/*    */   
/*    */   public Expression optimize(Session paramSession) {
/* 39 */     paramSession.optimizeQueryExpression(this.query);
/* 40 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSQL() {
/* 45 */     return "EXISTS(\n" + StringUtils.indent(this.query.getPlanSQL(), 4, false) + ")";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateAggregate(Session paramSession) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 58 */     this.query.mapColumns(paramColumnResolver, paramInt + 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 63 */     this.query.setEvaluatable(paramTableFilter, paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 68 */     return this.query.isEverything(paramExpressionVisitor);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCost() {
/* 73 */     return this.query.getCostAsExpression();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ConditionExists.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */