/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.IndexCondition;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueArray;
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
/*     */ public class ValueExpression
/*     */   extends Expression
/*     */ {
/*  25 */   private static final Object NULL = new ValueExpression((Value)ValueNull.INSTANCE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  32 */   private static final Object DEFAULT = new ValueExpression((Value)ValueNull.INSTANCE);
/*     */   
/*     */   private final Value value;
/*     */   
/*     */   private ValueExpression(Value paramValue) {
/*  37 */     this.value = paramValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueExpression getNull() {
/*  46 */     return (ValueExpression)NULL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueExpression getDefault() {
/*  55 */     return (ValueExpression)DEFAULT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueExpression get(Value paramValue) {
/*  65 */     if (paramValue == ValueNull.INSTANCE) {
/*  66 */       return getNull();
/*     */     }
/*  68 */     return new ValueExpression(paramValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  73 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  78 */     return this.value.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public void createIndexConditions(Session paramSession, TableFilter paramTableFilter) {
/*  83 */     if (this.value.getType() == 1) {
/*  84 */       boolean bool = ((ValueBoolean)this.value).getBoolean().booleanValue();
/*  85 */       if (!bool) {
/*  86 */         paramTableFilter.addIndexCondition(IndexCondition.get(8, null, this));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression getNotIfPossible(Session paramSession) {
/*  93 */     return new Comparison(paramSession, 0, this, get((Value)ValueBoolean.get(false)));
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
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConstant() {
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValueSet() {
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getScale() {
/* 124 */     return this.value.getScale();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 129 */     return this.value.getPrecision();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 134 */     return this.value.getDisplaySize();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 139 */     if (this == DEFAULT) {
/* 140 */       return "DEFAULT";
/*     */     }
/* 142 */     return this.value.getSQL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 152 */     switch (paramExpressionVisitor.getType()) {
/*     */       case 0:
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/*     */       case 9:
/* 163 */         return true;
/*     */     } 
/* 165 */     throw DbException.throwInternalError("type=" + paramExpressionVisitor.getType());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 171 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression[] getExpressionColumns(Session paramSession) {
/* 176 */     if (getType() == 17) {
/* 177 */       return getExpressionColumns(paramSession, (ValueArray)getValue(paramSession));
/*     */     }
/* 179 */     return super.getExpressionColumns(paramSession);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ValueExpression.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */