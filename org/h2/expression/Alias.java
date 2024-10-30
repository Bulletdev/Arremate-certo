/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Alias
/*     */   extends Expression
/*     */ {
/*     */   private final String alias;
/*     */   private Expression expr;
/*     */   private final boolean aliasColumnName;
/*     */   
/*     */   public Alias(Expression paramExpression, String paramString, boolean paramBoolean) {
/*  24 */     this.expr = paramExpression;
/*  25 */     this.alias = paramString;
/*  26 */     this.aliasColumnName = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression getNonAliasExpression() {
/*  31 */     return this.expr;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  36 */     return this.expr.getValue(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  41 */     return this.expr.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/*  46 */     this.expr.mapColumns(paramColumnResolver, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  51 */     this.expr = this.expr.optimize(paramSession);
/*  52 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/*  57 */     this.expr.setEvaluatable(paramTableFilter, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/*  62 */     return this.expr.getScale();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  67 */     return this.expr.getPrecision();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/*  72 */     return this.expr.getDisplaySize();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAutoIncrement() {
/*  77 */     return this.expr.isAutoIncrement();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  82 */     return this.expr.getSQL() + " AS " + Parser.quoteIdentifier(this.alias);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/*  87 */     this.expr.updateAggregate(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAlias() {
/*  92 */     return this.alias;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNullable() {
/*  97 */     return this.expr.getNullable();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 102 */     return this.expr.isEverything(paramExpressionVisitor);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 107 */     return this.expr.getCost();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTableName() {
/* 112 */     if (this.aliasColumnName) {
/* 113 */       return super.getTableName();
/*     */     }
/* 115 */     return this.expr.getTableName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnName() {
/* 120 */     if (!(this.expr instanceof ExpressionColumn) || this.aliasColumnName) {
/* 121 */       return super.getColumnName();
/*     */     }
/* 123 */     return this.expr.getColumnName();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Alias.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */