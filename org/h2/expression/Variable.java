/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
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
/*     */ public class Variable
/*     */   extends Expression
/*     */ {
/*     */   private final String name;
/*     */   private Value lastValue;
/*     */   
/*     */   public Variable(Session paramSession, String paramString) {
/*  24 */     this.name = paramString;
/*  25 */     this.lastValue = paramSession.getVariable(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCost() {
/*  30 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/*  35 */     return this.lastValue.getDisplaySize();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  40 */     return this.lastValue.getPrecision();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  45 */     return "@" + Parser.quoteIdentifier(this.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/*  50 */     return this.lastValue.getScale();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  55 */     return this.lastValue.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  60 */     this.lastValue = paramSession.getVariable(this.name);
/*  61 */     return this.lastValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/*  66 */     switch (paramExpressionVisitor.getType()) {
/*     */ 
/*     */ 
/*     */       
/*     */       case 0:
/*     */       case 1:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/*     */       case 9:
/*  79 */         return true;
/*     */       case 2:
/*  81 */         return false;
/*     */     } 
/*  83 */     throw DbException.throwInternalError("type=" + paramExpressionVisitor.getType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 108 */     return this.name;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Variable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */