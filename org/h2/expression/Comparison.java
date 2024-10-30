/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.index.IndexCondition;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.New;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueBoolean;
/*     */ import org.h2.value.ValueGeometry;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Comparison
/*     */   extends Condition
/*     */ {
/*     */   public static final int NULL_SAFE = 16;
/*     */   public static final int EQUAL = 0;
/*     */   public static final int EQUAL_NULL_SAFE = 16;
/*     */   public static final int BIGGER_EQUAL = 1;
/*     */   public static final int BIGGER = 2;
/*     */   public static final int SMALLER_EQUAL = 3;
/*     */   public static final int SMALLER = 4;
/*     */   public static final int NOT_EQUAL = 5;
/*     */   public static final int NOT_EQUAL_NULL_SAFE = 21;
/*     */   public static final int IS_NULL = 6;
/*     */   public static final int IS_NOT_NULL = 7;
/*     */   public static final int FALSE = 8;
/*     */   public static final int IN_LIST = 9;
/*     */   public static final int IN_QUERY = 10;
/*     */   public static final int SPATIAL_INTERSECTS = 11;
/*     */   private final Database database;
/*     */   private int compareType;
/*     */   private Expression left;
/*     */   private Expression right;
/*     */   
/*     */   public Comparison(Session paramSession, int paramInt, Expression paramExpression1, Expression paramExpression2) {
/* 119 */     this.database = paramSession.getDatabase();
/* 120 */     this.left = paramExpression1;
/* 121 */     this.right = paramExpression2;
/* 122 */     this.compareType = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 128 */     switch (this.compareType)
/*     */     { case 6:
/* 130 */         str = this.left.getSQL() + " IS NULL";
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
/* 142 */         return "(" + str + ")";case 7: str = this.left.getSQL() + " IS NOT NULL"; return "(" + str + ")";case 11: str = "INTERSECTS(" + this.left.getSQL() + ", " + this.right.getSQL() + ")"; return "(" + str + ")"; }  String str = this.left.getSQL() + " " + getCompareOperator(this.compareType) + " " + this.right.getSQL(); return "(" + str + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String getCompareOperator(int paramInt) {
/* 152 */     switch (paramInt) {
/*     */       case 0:
/* 154 */         return "=";
/*     */       case 16:
/* 156 */         return "IS";
/*     */       case 1:
/* 158 */         return ">=";
/*     */       case 2:
/* 160 */         return ">";
/*     */       case 3:
/* 162 */         return "<=";
/*     */       case 4:
/* 164 */         return "<";
/*     */       case 5:
/* 166 */         return "<>";
/*     */       case 21:
/* 168 */         return "IS NOT";
/*     */       case 11:
/* 170 */         return "&&";
/*     */     } 
/* 172 */     throw DbException.throwInternalError("compareType=" + paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/* 178 */     this.left = this.left.optimize(paramSession);
/* 179 */     if (this.right != null) {
/* 180 */       this.right = this.right.optimize(paramSession);
/* 181 */       if (this.right instanceof ExpressionColumn && (
/* 182 */         this.left.isConstant() || this.left instanceof Parameter)) {
/* 183 */         Expression expression = this.left;
/* 184 */         this.left = this.right;
/* 185 */         this.right = expression;
/* 186 */         this.compareType = getReversedCompareType(this.compareType);
/*     */       } 
/*     */       
/* 189 */       if (this.left instanceof ExpressionColumn) {
/* 190 */         if (this.right.isConstant()) {
/* 191 */           Value value = this.right.getValue(paramSession);
/* 192 */           if (value == ValueNull.INSTANCE && (
/* 193 */             this.compareType & 0x10) == 0) {
/* 194 */             return ValueExpression.getNull();
/*     */           }
/*     */         }
/* 197 */         else if (this.right instanceof Parameter) {
/* 198 */           ((Parameter)this.right).setColumn(((ExpressionColumn)this.left).getColumn());
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 203 */     if (this.compareType == 6 || this.compareType == 7) {
/* 204 */       if (this.left.isConstant()) {
/* 205 */         return ValueExpression.get(getValue(paramSession));
/*     */       }
/*     */     } else {
/* 208 */       if (SysProperties.CHECK && (this.left == null || this.right == null)) {
/* 209 */         DbException.throwInternalError();
/*     */       }
/* 211 */       if (this.left == ValueExpression.getNull() || this.right == ValueExpression.getNull())
/*     */       {
/*     */ 
/*     */         
/* 215 */         if ((this.compareType & 0x10) == 0) {
/* 216 */           return ValueExpression.getNull();
/*     */         }
/*     */       }
/* 219 */       if (this.left.isConstant() && this.right.isConstant()) {
/* 220 */         return ValueExpression.get(getValue(paramSession));
/*     */       }
/*     */     } 
/* 223 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/* 228 */     Value value1 = this.left.getValue(paramSession);
/* 229 */     if (this.right == null) {
/*     */       boolean bool1;
/* 231 */       switch (this.compareType) {
/*     */         case 6:
/* 233 */           bool1 = (value1 == ValueNull.INSTANCE) ? true : false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 241 */           return (Value)ValueBoolean.get(bool1);case 7: bool1 = (value1 != ValueNull.INSTANCE) ? true : false; return (Value)ValueBoolean.get(bool1);
/*     */       }  throw DbException.throwInternalError("type=" + this.compareType);
/* 243 */     }  if (value1 == ValueNull.INSTANCE && (
/* 244 */       this.compareType & 0x10) == 0) {
/* 245 */       return (Value)ValueNull.INSTANCE;
/*     */     }
/*     */     
/* 248 */     Value value2 = this.right.getValue(paramSession);
/* 249 */     if (value2 == ValueNull.INSTANCE && (
/* 250 */       this.compareType & 0x10) == 0) {
/* 251 */       return (Value)ValueNull.INSTANCE;
/*     */     }
/*     */     
/* 254 */     int i = Value.getHigherOrder(this.left.getType(), this.right.getType());
/* 255 */     value1 = value1.convertTo(i);
/* 256 */     value2 = value2.convertTo(i);
/* 257 */     boolean bool = compareNotNull(this.database, value1, value2, this.compareType);
/* 258 */     return (Value)ValueBoolean.get(bool);
/*     */   }
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
/*     */   static boolean compareNotNull(Database paramDatabase, Value paramValue1, Value paramValue2, int paramInt) {
/*     */     boolean bool;
/*     */     ValueGeometry valueGeometry1;
/*     */     ValueGeometry valueGeometry2;
/* 274 */     switch (paramInt) {
/*     */       case 0:
/*     */       case 16:
/* 277 */         bool = paramDatabase.areEqual(paramValue1, paramValue2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 304 */         return bool;case 5: case 21: bool = !paramDatabase.areEqual(paramValue1, paramValue2); return bool;case 1: bool = (paramDatabase.compare(paramValue1, paramValue2) >= 0); return bool;case 2: bool = (paramDatabase.compare(paramValue1, paramValue2) > 0); return bool;case 3: bool = (paramDatabase.compare(paramValue1, paramValue2) <= 0); return bool;case 4: bool = (paramDatabase.compare(paramValue1, paramValue2) < 0); return bool;case 11: valueGeometry1 = (ValueGeometry)paramValue1.convertTo(22); valueGeometry2 = (ValueGeometry)paramValue2.convertTo(22); bool = valueGeometry1.intersectsBoundingBox(valueGeometry2); return bool;
/*     */     } 
/*     */     throw DbException.throwInternalError("type=" + paramInt);
/*     */   } private int getReversedCompareType(int paramInt) {
/* 308 */     switch (this.compareType) {
/*     */       case 0:
/*     */       case 5:
/*     */       case 11:
/*     */       case 16:
/*     */       case 21:
/* 314 */         return paramInt;
/*     */       case 1:
/* 316 */         return 3;
/*     */       case 2:
/* 318 */         return 4;
/*     */       case 3:
/* 320 */         return 1;
/*     */       case 4:
/* 322 */         return 2;
/*     */     } 
/* 324 */     throw DbException.throwInternalError("type=" + this.compareType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression getNotIfPossible(Session paramSession) {
/* 330 */     if (this.compareType == 11) {
/* 331 */       return null;
/*     */     }
/* 333 */     int i = getNotCompareType();
/* 334 */     return new Comparison(paramSession, i, this.left, this.right);
/*     */   }
/*     */   
/*     */   private int getNotCompareType() {
/* 338 */     switch (this.compareType) {
/*     */       case 0:
/* 340 */         return 5;
/*     */       case 16:
/* 342 */         return 21;
/*     */       case 5:
/* 344 */         return 0;
/*     */       case 21:
/* 346 */         return 16;
/*     */       case 1:
/* 348 */         return 4;
/*     */       case 2:
/* 350 */         return 3;
/*     */       case 3:
/* 352 */         return 2;
/*     */       case 4:
/* 354 */         return 1;
/*     */       case 6:
/* 356 */         return 7;
/*     */       case 7:
/* 358 */         return 6;
/*     */     } 
/* 360 */     throw DbException.throwInternalError("type=" + this.compareType);
/*     */   }
/*     */ 
/*     */   
/*     */   public void createIndexConditions(Session paramSession, TableFilter paramTableFilter) {
/*     */     boolean bool;
/* 366 */     if (!paramTableFilter.getTable().isQueryComparable()) {
/*     */       return;
/*     */     }
/* 369 */     ExpressionColumn expressionColumn1 = null;
/* 370 */     if (this.left instanceof ExpressionColumn) {
/* 371 */       expressionColumn1 = (ExpressionColumn)this.left;
/* 372 */       if (paramTableFilter != expressionColumn1.getTableFilter()) {
/* 373 */         expressionColumn1 = null;
/*     */       }
/*     */     } 
/* 376 */     if (this.right == null) {
/* 377 */       if (expressionColumn1 != null) {
/* 378 */         switch (this.compareType) {
/*     */           case 6:
/* 380 */             if ((paramSession.getDatabase().getSettings()).optimizeIsNull) {
/* 381 */               paramTableFilter.addIndexCondition(IndexCondition.get(16, expressionColumn1, ValueExpression.getNull()));
/*     */             }
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/*     */       }
/*     */       return;
/*     */     } 
/* 390 */     ExpressionColumn expressionColumn2 = null;
/* 391 */     if (this.right instanceof ExpressionColumn) {
/* 392 */       expressionColumn2 = (ExpressionColumn)this.right;
/* 393 */       if (paramTableFilter != expressionColumn2.getTableFilter()) {
/* 394 */         expressionColumn2 = null;
/*     */       }
/*     */     } 
/*     */     
/* 398 */     if (expressionColumn1 == null && expressionColumn2 == null) {
/*     */       return;
/*     */     }
/* 401 */     if (expressionColumn1 != null && expressionColumn2 != null) {
/*     */       return;
/*     */     }
/* 404 */     if (expressionColumn1 == null) {
/* 405 */       ExpressionVisitor expressionVisitor = ExpressionVisitor.getNotFromResolverVisitor((ColumnResolver)paramTableFilter);
/*     */       
/* 407 */       if (!this.left.isEverything(expressionVisitor)) {
/*     */         return;
/*     */       }
/* 410 */     } else if (expressionColumn2 == null) {
/* 411 */       ExpressionVisitor expressionVisitor = ExpressionVisitor.getNotFromResolverVisitor((ColumnResolver)paramTableFilter);
/*     */       
/* 413 */       if (!this.right.isEverything(expressionVisitor)) {
/*     */         return;
/*     */       }
/*     */     } else {
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 422 */     switch (this.compareType) {
/*     */       case 5:
/*     */       case 21:
/* 425 */         bool = false;
/*     */         break;
/*     */       case 0:
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 11:
/*     */       case 16:
/* 434 */         bool = true;
/*     */         break;
/*     */       default:
/* 437 */         throw DbException.throwInternalError("type=" + this.compareType);
/*     */     } 
/* 439 */     if (bool) {
/* 440 */       if (expressionColumn1 != null) {
/* 441 */         paramTableFilter.addIndexCondition(IndexCondition.get(this.compareType, expressionColumn1, this.right));
/*     */       }
/* 443 */       else if (expressionColumn2 != null) {
/* 444 */         int i = getReversedCompareType(this.compareType);
/* 445 */         paramTableFilter.addIndexCondition(IndexCondition.get(i, expressionColumn2, this.left));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 453 */     this.left.setEvaluatable(paramTableFilter, paramBoolean);
/* 454 */     if (this.right != null) {
/* 455 */       this.right.setEvaluatable(paramTableFilter, paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 461 */     this.left.updateAggregate(paramSession);
/* 462 */     if (this.right != null) {
/* 463 */       this.right.updateAggregate(paramSession);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void addFilterConditions(TableFilter paramTableFilter, boolean paramBoolean) {
/* 469 */     if (this.compareType == 6 && paramBoolean) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 478 */     super.addFilterConditions(paramTableFilter, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 483 */     this.left.mapColumns(paramColumnResolver, paramInt);
/* 484 */     if (this.right != null) {
/* 485 */       this.right.mapColumns(paramColumnResolver, paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 491 */     return (this.left.isEverything(paramExpressionVisitor) && (this.right == null || this.right.isEverything(paramExpressionVisitor)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 497 */     return this.left.getCost() + ((this.right == null) ? 0 : this.right.getCost()) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Expression getIfEquals(Expression paramExpression) {
/* 508 */     if (this.compareType == 0) {
/* 509 */       String str = paramExpression.getSQL();
/* 510 */       if (this.left.getSQL().equals(str))
/* 511 */         return this.right; 
/* 512 */       if (this.right.getSQL().equals(str)) {
/* 513 */         return this.left;
/*     */       }
/*     */     } 
/* 516 */     return null;
/*     */   }
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
/*     */   Expression getAdditional(Session paramSession, Comparison paramComparison, boolean paramBoolean) {
/* 530 */     if (this.compareType == paramComparison.compareType && this.compareType == 0) {
/* 531 */       boolean bool1 = this.left.isConstant();
/* 532 */       boolean bool2 = this.right.isConstant();
/* 533 */       boolean bool3 = paramComparison.left.isConstant();
/* 534 */       boolean bool4 = paramComparison.right.isConstant();
/* 535 */       String str1 = this.left.getSQL();
/* 536 */       String str2 = paramComparison.left.getSQL();
/* 537 */       String str3 = this.right.getSQL();
/* 538 */       String str4 = paramComparison.right.getSQL();
/* 539 */       if (paramBoolean) {
/*     */ 
/*     */         
/* 542 */         if ((!bool2 || !bool4) && str1.equals(str2))
/* 543 */           return new Comparison(paramSession, 0, this.right, paramComparison.right); 
/* 544 */         if ((!bool2 || !bool3) && str1.equals(str4))
/* 545 */           return new Comparison(paramSession, 0, this.right, paramComparison.left); 
/* 546 */         if ((!bool1 || !bool4) && str3.equals(str2))
/* 547 */           return new Comparison(paramSession, 0, this.left, paramComparison.right); 
/* 548 */         if ((!bool1 || !bool3) && str3.equals(str4)) {
/* 549 */           return new Comparison(paramSession, 0, this.left, paramComparison.left);
/*     */         }
/*     */       } else {
/*     */         
/* 553 */         Database database = paramSession.getDatabase();
/* 554 */         if (bool2 && bool4 && str1.equals(str2)) {
/* 555 */           return new ConditionIn(database, this.left, New.arrayList(Arrays.asList(new Expression[] { this.right, paramComparison.right })));
/*     */         }
/* 557 */         if (bool2 && bool3 && str1.equals(str4)) {
/* 558 */           return new ConditionIn(database, this.left, New.arrayList(Arrays.asList(new Expression[] { this.right, paramComparison.left })));
/*     */         }
/* 560 */         if (bool1 && bool4 && str3.equals(str2)) {
/* 561 */           return new ConditionIn(database, this.right, New.arrayList(Arrays.asList(new Expression[] { this.left, paramComparison.right })));
/*     */         }
/* 563 */         if (bool1 && bool3 && str3.equals(str4)) {
/* 564 */           return new ConditionIn(database, this.right, New.arrayList(Arrays.asList(new Expression[] { this.left, paramComparison.left })));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 569 */     return null;
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
/* 580 */     return paramBoolean ? this.left : this.right;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Comparison.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */