/*     */ package org.h2.table;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.util.New;
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
/*     */ public class Plan
/*     */ {
/*     */   private final TableFilter[] filters;
/*  26 */   private final HashMap<TableFilter, PlanItem> planItems = New.hashMap();
/*     */ 
/*     */ 
/*     */   
/*     */   private final Expression[] allConditions;
/*     */ 
/*     */   
/*     */   private final TableFilter[] allFilters;
/*     */ 
/*     */ 
/*     */   
/*     */   public Plan(TableFilter[] paramArrayOfTableFilter, int paramInt, Expression paramExpression) {
/*  38 */     this.filters = new TableFilter[paramInt];
/*  39 */     System.arraycopy(paramArrayOfTableFilter, 0, this.filters, 0, paramInt);
/*  40 */     final ArrayList<Expression> allCond = New.arrayList();
/*  41 */     final ArrayList all = New.arrayList();
/*  42 */     if (paramExpression != null) {
/*  43 */       arrayList.add(paramExpression);
/*     */     }
/*  45 */     for (byte b = 0; b < paramInt; b++) {
/*  46 */       TableFilter tableFilter = paramArrayOfTableFilter[b];
/*  47 */       tableFilter.visit(new TableFilter.TableFilterVisitor()
/*     */           {
/*     */             public void accept(TableFilter param1TableFilter) {
/*  50 */               all.add(param1TableFilter);
/*  51 */               if (param1TableFilter.getJoinCondition() != null) {
/*  52 */                 allCond.add(param1TableFilter.getJoinCondition());
/*     */               }
/*     */             }
/*     */           });
/*     */     } 
/*  57 */     this.allConditions = new Expression[arrayList.size()];
/*  58 */     arrayList.toArray(this.allConditions);
/*  59 */     this.allFilters = new TableFilter[arrayList1.size()];
/*  60 */     arrayList1.toArray((Object[])this.allFilters);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PlanItem getItem(TableFilter paramTableFilter) {
/*  70 */     return this.planItems.get(paramTableFilter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableFilter[] getFilters() {
/*  79 */     return this.filters;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeUnusableIndexConditions() {
/*  86 */     for (byte b = 0; b < this.allFilters.length; b++) {
/*  87 */       TableFilter tableFilter = this.allFilters[b];
/*  88 */       setEvaluatable(tableFilter, true);
/*  89 */       if (b < this.allFilters.length - 1 || (tableFilter.getSession().getDatabase().getSettings()).earlyFilter)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*  94 */         tableFilter.optimizeFullCondition(false);
/*     */       }
/*  96 */       tableFilter.removeUnusableIndexConditions();
/*     */     } 
/*  98 */     for (TableFilter tableFilter : this.allFilters) {
/*  99 */       setEvaluatable(tableFilter, false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double calculateCost(Session paramSession) {
/* 110 */     Trace trace = paramSession.getTrace();
/* 111 */     if (trace.isDebugEnabled()) {
/* 112 */       trace.debug("Plan       : calculate cost for plan {0}", new Object[] { Arrays.toString((Object[])this.allFilters) });
/*     */     }
/* 114 */     double d = 1.0D;
/* 115 */     boolean bool = false;
/* 116 */     HashSet<Column> hashSet = ExpressionVisitor.allColumnsForTableFilters(this.allFilters);
/*     */     
/* 118 */     for (byte b = 0; b < this.allFilters.length; b++) {
/* 119 */       TableFilter tableFilter = this.allFilters[b];
/* 120 */       if (trace.isDebugEnabled()) {
/* 121 */         trace.debug("Plan       :   for table filter {0}", new Object[] { tableFilter });
/*     */       }
/* 123 */       PlanItem planItem = tableFilter.getBestPlanItem(paramSession, this.allFilters, b, hashSet);
/* 124 */       this.planItems.put(tableFilter, planItem);
/* 125 */       if (trace.isDebugEnabled()) {
/* 126 */         trace.debug("Plan       :   best plan item cost {0} index {1}", new Object[] { Double.valueOf(planItem.cost), planItem.getIndex().getPlanSQL() });
/*     */       }
/*     */       
/* 129 */       d += d * planItem.cost;
/* 130 */       setEvaluatable(tableFilter, true);
/* 131 */       Expression expression = tableFilter.getJoinCondition();
/* 132 */       if (expression != null && 
/* 133 */         !expression.isEverything(ExpressionVisitor.EVALUATABLE_VISITOR)) {
/* 134 */         bool = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 139 */     if (bool) {
/* 140 */       d = Double.POSITIVE_INFINITY;
/*     */     }
/* 142 */     if (trace.isDebugEnabled()) {
/* 143 */       paramSession.getTrace().debug("Plan       : plan cost {0}", new Object[] { Double.valueOf(d) });
/*     */     }
/* 145 */     for (TableFilter tableFilter : this.allFilters) {
/* 146 */       setEvaluatable(tableFilter, false);
/*     */     }
/* 148 */     return d;
/*     */   }
/*     */   
/*     */   private void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 152 */     paramTableFilter.setEvaluatable(paramTableFilter, paramBoolean);
/* 153 */     for (Expression expression : this.allConditions)
/* 154 */       expression.setEvaluatable(paramTableFilter, paramBoolean); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\Plan.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */