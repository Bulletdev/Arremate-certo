/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueBoolean;
/*     */ import org.h2.value.ValueNull;
/*     */ import org.h2.value.ValueString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Parameter
/*     */   extends Expression
/*     */   implements ParameterInterface
/*     */ {
/*     */   private Value value;
/*     */   private Column column;
/*     */   private final int index;
/*     */   
/*     */   public Parameter(int paramInt) {
/*  29 */     this.index = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  34 */     return "?" + (this.index + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Value paramValue, boolean paramBoolean) {
/*  41 */     this.value = paramValue;
/*     */   }
/*     */   
/*     */   public void setValue(Value paramValue) {
/*  45 */     this.value = paramValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getParamValue() {
/*  50 */     if (this.value == null)
/*     */     {
/*  52 */       return (Value)ValueNull.INSTANCE;
/*     */     }
/*  54 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  59 */     return getParamValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  64 */     if (this.value != null) {
/*  65 */       return this.value.getType();
/*     */     }
/*  67 */     if (this.column != null) {
/*  68 */       return this.column.getType();
/*     */     }
/*  70 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkSet() {
/*  80 */     if (this.value == null) {
/*  81 */       throw DbException.get(90012, "#" + (this.index + 1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  87 */     if ((paramSession.getDatabase().getMode()).treatEmptyStringsAsNull && 
/*  88 */       this.value != null && this.value instanceof ValueString) {
/*  89 */       this.value = ValueString.get(this.value.getString(), true);
/*     */     }
/*     */     
/*  92 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConstant() {
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValueSet() {
/* 102 */     return (this.value != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getScale() {
/* 112 */     if (this.value != null) {
/* 113 */       return this.value.getScale();
/*     */     }
/* 115 */     if (this.column != null) {
/* 116 */       return this.column.getScale();
/*     */     }
/* 118 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 123 */     if (this.value != null) {
/* 124 */       return this.value.getPrecision();
/*     */     }
/* 126 */     if (this.column != null) {
/* 127 */       return this.column.getPrecision();
/*     */     }
/* 129 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 134 */     if (this.value != null) {
/* 135 */       return this.value.getDisplaySize();
/*     */     }
/* 137 */     if (this.column != null) {
/* 138 */       return this.column.getDisplaySize();
/*     */     }
/* 140 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 150 */     switch (paramExpressionVisitor.getType()) {
/*     */ 
/*     */ 
/*     */       
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
/*     */       case 0:
/* 165 */         return (this.value != null);
/*     */     } 
/* 167 */     throw DbException.throwInternalError("type=" + paramExpressionVisitor.getType());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 173 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression getNotIfPossible(Session paramSession) {
/* 178 */     return new Comparison(paramSession, 0, this, ValueExpression.get((Value)ValueBoolean.get(false)));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColumn(Column paramColumn) {
/* 183 */     this.column = paramColumn;
/*     */   }
/*     */   
/*     */   public int getIndex() {
/* 187 */     return this.index;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Parameter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */