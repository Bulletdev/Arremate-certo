/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConditionAndOr
/*     */   extends Condition
/*     */ {
/*     */   public static final int AND = 0;
/*     */   public static final int OR = 1;
/*     */   private final int andOrType;
/*     */   private Expression left;
/*     */   private Expression right;
/*     */   
/*     */   public ConditionAndOr(int paramInt, Expression paramExpression1, Expression paramExpression2) {
/*  36 */     this.andOrType = paramInt;
/*  37 */     this.left = paramExpression1;
/*  38 */     this.right = paramExpression2;
/*  39 */     if (SysProperties.CHECK && (paramExpression1 == null || paramExpression2 == null)) {
/*  40 */       DbException.throwInternalError();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*     */     String str;
/*  47 */     switch (this.andOrType) {
/*     */       case 0:
/*  49 */         str = this.left.getSQL() + "\n    AND " + this.right.getSQL();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  57 */         return "(" + str + ")";case 1: str = this.left.getSQL() + "\n    OR " + this.right.getSQL(); return "(" + str + ")";
/*     */     } 
/*     */     throw DbException.throwInternalError("andOrType=" + this.andOrType);
/*     */   }
/*     */   public void createIndexConditions(Session paramSession, TableFilter paramTableFilter) {
/*  62 */     if (this.andOrType == 0) {
/*  63 */       this.left.createIndexConditions(paramSession, paramTableFilter);
/*  64 */       this.right.createIndexConditions(paramSession, paramTableFilter);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression getNotIfPossible(Session paramSession) {
/*  72 */     Expression expression1 = this.left.getNotIfPossible(paramSession);
/*  73 */     if (expression1 == null) {
/*  74 */       expression1 = new ConditionNot(this.left);
/*     */     }
/*  76 */     Expression expression2 = this.right.getNotIfPossible(paramSession);
/*  77 */     if (expression2 == null) {
/*  78 */       expression2 = new ConditionNot(this.right);
/*     */     }
/*  80 */     boolean bool = (this.andOrType == 0) ? true : false;
/*  81 */     return new ConditionAndOr(bool, expression1, expression2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  86 */     Value value2, value1 = this.left.getValue(paramSession);
/*     */     
/*  88 */     switch (this.andOrType) {
/*     */       case 0:
/*  90 */         if (Boolean.FALSE.equals(value1.getBoolean())) {
/*  91 */           return value1;
/*     */         }
/*  93 */         value2 = this.right.getValue(paramSession);
/*  94 */         if (Boolean.FALSE.equals(value2.getBoolean())) {
/*  95 */           return value2;
/*     */         }
/*  97 */         if (value1 == ValueNull.INSTANCE) {
/*  98 */           return value1;
/*     */         }
/* 100 */         if (value2 == ValueNull.INSTANCE) {
/* 101 */           return value2;
/*     */         }
/* 103 */         return (Value)ValueBoolean.get(true);
/*     */       
/*     */       case 1:
/* 106 */         if (Boolean.TRUE.equals(value1.getBoolean())) {
/* 107 */           return value1;
/*     */         }
/* 109 */         value2 = this.right.getValue(paramSession);
/* 110 */         if (Boolean.TRUE.equals(value2.getBoolean())) {
/* 111 */           return value2;
/*     */         }
/* 113 */         if (value1 == ValueNull.INSTANCE) {
/* 114 */           return value1;
/*     */         }
/* 116 */         if (value2 == ValueNull.INSTANCE) {
/* 117 */           return value2;
/*     */         }
/* 119 */         return (Value)ValueBoolean.get(false);
/*     */     } 
/*     */     
/* 122 */     throw DbException.throwInternalError("type=" + this.andOrType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/* 130 */     this.left = this.left.optimize(paramSession);
/* 131 */     this.right = this.right.optimize(paramSession);
/* 132 */     int i = this.left.getCost(), j = this.right.getCost();
/* 133 */     if (j < i) {
/* 134 */       Expression expression = this.left;
/* 135 */       this.left = this.right;
/* 136 */       this.right = expression;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     if ((paramSession.getDatabase().getSettings()).optimizeTwoEquals && this.andOrType == 0)
/*     */     {
/*     */       
/* 147 */       if (this.left instanceof Comparison && this.right instanceof Comparison) {
/* 148 */         Comparison comparison1 = (Comparison)this.left;
/* 149 */         Comparison comparison2 = (Comparison)this.right;
/* 150 */         Expression expression = comparison1.getAdditional(paramSession, comparison2, true);
/*     */         
/* 152 */         if (expression != null) {
/* 153 */           expression = expression.optimize(paramSession);
/* 154 */           return new ConditionAndOr(0, this, expression);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 161 */     if (this.andOrType == 1 && (paramSession.getDatabase().getSettings()).optimizeOr)
/*     */     {
/*     */       
/* 164 */       if (this.left instanceof Comparison && this.right instanceof Comparison) {
/*     */         
/* 166 */         Comparison comparison1 = (Comparison)this.left;
/* 167 */         Comparison comparison2 = (Comparison)this.right;
/* 168 */         Expression expression = comparison1.getAdditional(paramSession, comparison2, false);
/*     */         
/* 170 */         if (expression != null) {
/* 171 */           return expression.optimize(paramSession);
/*     */         }
/* 173 */       } else if (this.left instanceof ConditionIn && this.right instanceof Comparison) {
/*     */         
/* 175 */         Expression expression = ((ConditionIn)this.left).getAdditional((Comparison)this.right);
/*     */         
/* 177 */         if (expression != null) {
/* 178 */           return expression.optimize(paramSession);
/*     */         }
/* 180 */       } else if (this.right instanceof ConditionIn && this.left instanceof Comparison) {
/*     */         
/* 182 */         Expression expression = ((ConditionIn)this.right).getAdditional((Comparison)this.left);
/*     */         
/* 184 */         if (expression != null) {
/* 185 */           return expression.optimize(paramSession);
/*     */         }
/* 187 */       } else if (this.left instanceof ConditionInConstantSet && this.right instanceof Comparison) {
/*     */         
/* 189 */         Expression expression = ((ConditionInConstantSet)this.left).getAdditional(paramSession, (Comparison)this.right);
/*     */         
/* 191 */         if (expression != null) {
/* 192 */           return expression.optimize(paramSession);
/*     */         }
/* 194 */       } else if (this.right instanceof ConditionInConstantSet && this.left instanceof Comparison) {
/*     */         
/* 196 */         Expression expression = ((ConditionInConstantSet)this.right).getAdditional(paramSession, (Comparison)this.left);
/*     */         
/* 198 */         if (expression != null) {
/* 199 */           return expression.optimize(paramSession);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 204 */     Value value1 = this.left.isConstant() ? this.left.getValue(paramSession) : null;
/* 205 */     Value value2 = this.right.isConstant() ? this.right.getValue(paramSession) : null;
/* 206 */     if (value1 == null && value2 == null) {
/* 207 */       return this;
/*     */     }
/* 209 */     if (value1 != null && value2 != null) {
/* 210 */       return ValueExpression.get(getValue(paramSession));
/*     */     }
/* 212 */     switch (this.andOrType)
/*     */     { case 0:
/* 214 */         if (value1 != null) {
/* 215 */           if (Boolean.FALSE.equals(value1.getBoolean()))
/* 216 */             return ValueExpression.get(value1); 
/* 217 */           if (Boolean.TRUE.equals(value1.getBoolean())) {
/* 218 */             return this.right;
/*     */           }
/* 220 */         } else if (value2 != null) {
/* 221 */           if (Boolean.FALSE.equals(value2.getBoolean()))
/* 222 */             return ValueExpression.get(value2); 
/* 223 */           if (Boolean.TRUE.equals(value2.getBoolean())) {
/* 224 */             return this.left;
/*     */           }
/*     */         } 
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
/*     */ 
/*     */ 
/*     */         
/* 246 */         return this;case 1: if (value1 != null) { if (Boolean.TRUE.equals(value1.getBoolean())) return ValueExpression.get(value1);  if (Boolean.FALSE.equals(value1.getBoolean())) return this.right;  } else if (value2 != null) { if (Boolean.TRUE.equals(value2.getBoolean())) return ValueExpression.get(value2);  if (Boolean.FALSE.equals(value2.getBoolean())) return this.left;  }  return this; }  DbException.throwInternalError("type=" + this.andOrType); return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addFilterConditions(TableFilter paramTableFilter, boolean paramBoolean) {
/* 251 */     if (this.andOrType == 0) {
/* 252 */       this.left.addFilterConditions(paramTableFilter, paramBoolean);
/* 253 */       this.right.addFilterConditions(paramTableFilter, paramBoolean);
/*     */     } else {
/* 255 */       super.addFilterConditions(paramTableFilter, paramBoolean);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 261 */     this.left.mapColumns(paramColumnResolver, paramInt);
/* 262 */     this.right.mapColumns(paramColumnResolver, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 267 */     this.left.setEvaluatable(paramTableFilter, paramBoolean);
/* 268 */     this.right.setEvaluatable(paramTableFilter, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 273 */     this.left.updateAggregate(paramSession);
/* 274 */     this.right.updateAggregate(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 279 */     return (this.left.isEverything(paramExpressionVisitor) && this.right.isEverything(paramExpressionVisitor));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 284 */     return this.left.getCost() + this.right.getCost();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression getExpression(boolean paramBoolean) {
/* 295 */     return paramBoolean ? this.left : this.right;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ConditionAndOr.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */