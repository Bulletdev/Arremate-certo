/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.RowList;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.PlanItem;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.Value;
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
/*     */ public class Delete
/*     */   extends Prepared
/*     */ {
/*     */   private Expression condition;
/*     */   private TableFilter tableFilter;
/*     */   private Expression limitExpr;
/*     */   
/*     */   public Delete(Session paramSession) {
/*  41 */     super(paramSession);
/*     */   }
/*     */   
/*     */   public void setTableFilter(TableFilter paramTableFilter) {
/*  45 */     this.tableFilter = paramTableFilter;
/*     */   }
/*     */   
/*     */   public void setCondition(Expression paramExpression) {
/*  49 */     this.condition = paramExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  54 */     this.tableFilter.startQuery(this.session);
/*  55 */     this.tableFilter.reset();
/*  56 */     Table table = this.tableFilter.getTable();
/*  57 */     this.session.getUser().checkRight(table, 2);
/*  58 */     table.fire(this.session, 4, true);
/*  59 */     table.lock(this.session, true, false);
/*  60 */     RowList rowList = new RowList(this.session);
/*  61 */     int i = -1;
/*  62 */     if (this.limitExpr != null) {
/*  63 */       Value value = this.limitExpr.getValue(this.session);
/*  64 */       if (value != ValueNull.INSTANCE) {
/*  65 */         i = value.getInt();
/*     */       }
/*     */     } 
/*     */     try {
/*  69 */       setCurrentRowNumber(0);
/*  70 */       byte b1 = 0;
/*  71 */       while (i != 0 && this.tableFilter.next()) {
/*  72 */         setCurrentRowNumber(rowList.size() + 1);
/*  73 */         if (this.condition == null || Boolean.TRUE.equals(this.condition.getBooleanValue(this.session))) {
/*     */           
/*  75 */           Row row = this.tableFilter.get();
/*  76 */           boolean bool = false;
/*  77 */           if (table.fireRow()) {
/*  78 */             bool = table.fireBeforeRow(this.session, row, null);
/*     */           }
/*  80 */           if (!bool) {
/*  81 */             rowList.add(row);
/*     */           }
/*  83 */           b1++;
/*  84 */           if (i >= 0 && b1 >= i) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*  89 */       byte b2 = 0;
/*  90 */       rowList.reset(); while (rowList.hasNext()) {
/*  91 */         if ((++b2 & 0x7F) == 0) {
/*  92 */           checkCanceled();
/*     */         }
/*  94 */         Row row = rowList.next();
/*  95 */         table.removeRow(this.session, row);
/*  96 */         this.session.log(table, (short)1, row);
/*     */       } 
/*  98 */       if (table.fireRow()) {
/*  99 */         rowList.reset(); while (rowList.hasNext()) {
/* 100 */           Row row = rowList.next();
/* 101 */           table.fireAfterRow(this.session, row, null, false);
/*     */         } 
/*     */       } 
/* 104 */       table.fire(this.session, 4, false);
/* 105 */       return b1;
/*     */     } finally {
/* 107 */       rowList.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 113 */     StringBuilder stringBuilder = new StringBuilder();
/* 114 */     stringBuilder.append("DELETE ");
/* 115 */     stringBuilder.append("FROM ").append(this.tableFilter.getPlanSQL(false));
/* 116 */     if (this.condition != null) {
/* 117 */       stringBuilder.append("\nWHERE ").append(StringUtils.unEnclose(this.condition.getSQL()));
/*     */     }
/*     */     
/* 120 */     if (this.limitExpr != null) {
/* 121 */       stringBuilder.append("\nLIMIT (").append(StringUtils.unEnclose(this.limitExpr.getSQL())).append(')');
/*     */     }
/*     */     
/* 124 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/* 129 */     if (this.condition != null) {
/* 130 */       this.condition.mapColumns((ColumnResolver)this.tableFilter, 0);
/* 131 */       this.condition = this.condition.optimize(this.session);
/* 132 */       this.condition.createIndexConditions(this.session, this.tableFilter);
/*     */     } 
/* 134 */     TableFilter[] arrayOfTableFilter = { this.tableFilter };
/* 135 */     PlanItem planItem = this.tableFilter.getBestPlanItem(this.session, arrayOfTableFilter, 0, ExpressionVisitor.allColumnsForTableFilters(arrayOfTableFilter));
/*     */     
/* 137 */     this.tableFilter.setPlanItem(planItem);
/* 138 */     this.tableFilter.prepare();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/* 143 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/* 148 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 153 */     return 58;
/*     */   }
/*     */   
/*     */   public void setLimit(Expression paramExpression) {
/* 157 */     this.limitExpr = paramExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCacheable() {
/* 162 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\Delete.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */