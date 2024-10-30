/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.command.dml.Query;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.IndexCondition;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.StringUtils;
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
/*     */ public class ConditionInSelect
/*     */   extends Condition
/*     */ {
/*     */   private final Database database;
/*     */   private Expression left;
/*     */   private final Query query;
/*     */   private final boolean all;
/*     */   private final int compareType;
/*     */   private int queryLevel;
/*     */   
/*     */   public ConditionInSelect(Database paramDatabase, Expression paramExpression, Query paramQuery, boolean paramBoolean, int paramInt) {
/*  36 */     this.database = paramDatabase;
/*  37 */     this.left = paramExpression;
/*  38 */     this.query = paramQuery;
/*  39 */     this.all = paramBoolean;
/*  40 */     this.compareType = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  45 */     this.query.setSession(paramSession);
/*  46 */     if (!this.query.hasOrder()) {
/*  47 */       this.query.setDistinct(true);
/*     */     }
/*  49 */     try (LocalResult null = this.query.query(0)) {
/*  50 */       Value value = this.left.getValue(paramSession);
/*  51 */       if (localResult.getRowCount() == 0)
/*  52 */         return (Value)ValueBoolean.get(this.all); 
/*  53 */       if (value == ValueNull.INSTANCE) {
/*  54 */         return value;
/*     */       }
/*  56 */       if (!(paramSession.getDatabase().getSettings()).optimizeInSelect) {
/*  57 */         return getValueSlow(localResult, value);
/*     */       }
/*  59 */       if (this.all || (this.compareType != 0 && this.compareType != 16))
/*     */       {
/*  61 */         return getValueSlow(localResult, value);
/*     */       }
/*  63 */       int i = localResult.getColumnType(0);
/*  64 */       if (i == 0) {
/*  65 */         return (Value)ValueBoolean.get(false);
/*     */       }
/*  67 */       value = value.convertTo(i);
/*  68 */       if (localResult.containsDistinct(new Value[] { value })) {
/*  69 */         return (Value)ValueBoolean.get(true);
/*     */       }
/*  71 */       if (localResult.containsDistinct(new Value[] { (Value)ValueNull.INSTANCE })) {
/*  72 */         return (Value)ValueNull.INSTANCE;
/*     */       }
/*  74 */       return (Value)ValueBoolean.get(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Value getValueSlow(LocalResult paramLocalResult, Value paramValue) {
/*  81 */     boolean bool = false;
/*  82 */     boolean bool1 = this.all;
/*  83 */     while (paramLocalResult.next()) {
/*     */       boolean bool2;
/*  85 */       Value value = paramLocalResult.currentRow()[0];
/*  86 */       if (value == ValueNull.INSTANCE) {
/*  87 */         bool2 = false;
/*  88 */         bool = true;
/*     */       } else {
/*  90 */         bool2 = Comparison.compareNotNull(this.database, paramValue, value, this.compareType);
/*     */       } 
/*  92 */       if (!bool2 && this.all) {
/*  93 */         bool1 = false; break;
/*     */       } 
/*  95 */       if (bool2 && !this.all) {
/*  96 */         bool1 = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 100 */     if (!bool1 && bool) {
/* 101 */       return (Value)ValueNull.INSTANCE;
/*     */     }
/* 103 */     return (Value)ValueBoolean.get(bool1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 108 */     this.left.mapColumns(paramColumnResolver, paramInt);
/* 109 */     this.query.mapColumns(paramColumnResolver, paramInt + 1);
/* 110 */     this.queryLevel = Math.max(paramInt, this.queryLevel);
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/* 115 */     this.left = this.left.optimize(paramSession);
/* 116 */     this.query.setRandomAccessResult(true);
/* 117 */     paramSession.optimizeQueryExpression(this.query);
/* 118 */     if (this.query.getColumnCount() != 1) {
/* 119 */       throw DbException.get(90052);
/*     */     }
/*     */     
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 127 */     this.left.setEvaluatable(paramTableFilter, paramBoolean);
/* 128 */     this.query.setEvaluatable(paramTableFilter, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 133 */     StringBuilder stringBuilder = new StringBuilder();
/* 134 */     stringBuilder.append('(').append(this.left.getSQL()).append(' ');
/* 135 */     if (this.all) {
/* 136 */       stringBuilder.append(Comparison.getCompareOperator(this.compareType)).append(" ALL");
/*     */     
/*     */     }
/* 139 */     else if (this.compareType == 0) {
/* 140 */       stringBuilder.append("IN");
/*     */     } else {
/* 142 */       stringBuilder.append(Comparison.getCompareOperator(this.compareType)).append(" ANY");
/*     */     } 
/*     */ 
/*     */     
/* 146 */     stringBuilder.append("(\n").append(StringUtils.indent(this.query.getPlanSQL(), 4, false)).append("))");
/*     */     
/* 148 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 153 */     this.left.updateAggregate(paramSession);
/* 154 */     this.query.updateAggregate(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 159 */     return (this.left.isEverything(paramExpressionVisitor) && this.query.isEverything(paramExpressionVisitor));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 164 */     return this.left.getCost() + this.query.getCostAsExpression();
/*     */   }
/*     */ 
/*     */   
/*     */   public void createIndexConditions(Session paramSession, TableFilter paramTableFilter) {
/* 169 */     if (!(paramSession.getDatabase().getSettings()).optimizeInList) {
/*     */       return;
/*     */     }
/* 172 */     if (!(this.left instanceof ExpressionColumn)) {
/*     */       return;
/*     */     }
/* 175 */     ExpressionColumn expressionColumn = (ExpressionColumn)this.left;
/* 176 */     if (paramTableFilter != expressionColumn.getTableFilter()) {
/*     */       return;
/*     */     }
/* 179 */     ExpressionVisitor expressionVisitor = ExpressionVisitor.getNotFromResolverVisitor((ColumnResolver)paramTableFilter);
/* 180 */     if (!this.query.isEverything(expressionVisitor)) {
/*     */       return;
/*     */     }
/* 183 */     paramTableFilter.addIndexCondition(IndexCondition.getInQuery(expressionColumn, this.query));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ConditionInSelect.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */