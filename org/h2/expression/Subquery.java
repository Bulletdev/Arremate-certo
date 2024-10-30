/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.command.dml.Query;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueArray;
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
/*     */ public class Subquery
/*     */   extends Expression
/*     */ {
/*     */   private final Query query;
/*     */   private Expression expression;
/*     */   
/*     */   public Subquery(Query paramQuery) {
/*  30 */     this.query = paramQuery;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  35 */     this.query.setSession(paramSession);
/*  36 */     try (LocalResult null = this.query.query(2)) {
/*  37 */       ValueArray valueArray; int i = localResult.getRowCount();
/*  38 */       if (i > 1) {
/*  39 */         throw DbException.get(90053);
/*     */       }
/*     */       
/*  42 */       if (i <= 0) {
/*  43 */         ValueNull valueNull = ValueNull.INSTANCE;
/*     */       } else {
/*  45 */         localResult.next();
/*  46 */         Value[] arrayOfValue = localResult.currentRow();
/*  47 */         if (localResult.getVisibleColumnCount() == 1) {
/*  48 */           Value value = arrayOfValue[0];
/*     */         } else {
/*  50 */           valueArray = ValueArray.get(arrayOfValue);
/*     */         } 
/*     */       } 
/*  53 */       return (Value)valueArray;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  59 */     return getExpression().getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/*  64 */     this.query.mapColumns(paramColumnResolver, paramInt + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  69 */     paramSession.optimizeQueryExpression(this.query);
/*  70 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/*  75 */     this.query.setEvaluatable(paramTableFilter, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/*  80 */     return getExpression().getScale();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  85 */     return getExpression().getPrecision();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/*  90 */     return getExpression().getDisplaySize();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  95 */     return "(" + this.query.getPlanSQL() + ")";
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 100 */     this.query.updateAggregate(paramSession);
/*     */   }
/*     */   
/*     */   private Expression getExpression() {
/* 104 */     if (this.expression == null) {
/* 105 */       ArrayList<Expression> arrayList = this.query.getExpressions();
/* 106 */       int i = this.query.getColumnCount();
/* 107 */       if (i == 1) {
/* 108 */         this.expression = arrayList.get(0);
/*     */       } else {
/* 110 */         Expression[] arrayOfExpression = new Expression[i];
/* 111 */         for (byte b = 0; b < i; b++) {
/* 112 */           arrayOfExpression[b] = arrayList.get(b);
/*     */         }
/* 114 */         this.expression = new ExpressionList(arrayOfExpression);
/*     */       } 
/*     */     } 
/* 117 */     return this.expression;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 122 */     return this.query.isEverything(paramExpressionVisitor);
/*     */   }
/*     */   
/*     */   public Query getQuery() {
/* 126 */     return this.query;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 131 */     return this.query.getCostAsExpression();
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression[] getExpressionColumns(Session paramSession) {
/* 136 */     return getExpression().getExpressionColumns(paramSession);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Subquery.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */