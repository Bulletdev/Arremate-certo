/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Rownum
/*     */   extends Expression
/*     */ {
/*     */   private final Prepared prepared;
/*     */   
/*     */   public Rownum(Prepared paramPrepared) {
/*  24 */     this.prepared = paramPrepared;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  29 */     return (Value)ValueInt.get(this.prepared.getCurrentRowNumber());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  34 */     return 4;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  44 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getScale() {
/*  54 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  59 */     return 10L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/*  64 */     return 11;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  69 */     return "ROWNUM()";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/*  79 */     switch (paramExpressionVisitor.getType()) {
/*     */       case 0:
/*     */       case 1:
/*     */       case 2:
/*     */       case 8:
/*  84 */         return false;
/*     */       
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 9:
/*  92 */         return true;
/*     */     } 
/*  94 */     throw DbException.throwInternalError("type=" + paramExpressionVisitor.getType());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 100 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Rownum.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */