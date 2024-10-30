/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionColumn;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.expression.ValueExpression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.ResultTarget;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.New;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueInt;
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
/*     */ public abstract class Query
/*     */   extends Prepared
/*     */ {
/*     */   protected Expression limitExpr;
/*     */   protected Expression offsetExpr;
/*     */   protected Expression sampleSizeExpr;
/*     */   protected boolean distinct;
/*     */   protected boolean randomAccessResult;
/*     */   private boolean noCache;
/*     */   private int lastLimit;
/*     */   private long lastEvaluated;
/*     */   private LocalResult lastResult;
/*     */   private Value[] lastParameters;
/*     */   private boolean cacheableChecked;
/*     */   
/*     */   Query(Session paramSession) {
/*  71 */     super(paramSession);
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
/*     */   public int getCostAsExpression() {
/* 128 */     return (int)Math.min(1000000.0D, 10.0D + 10.0D * getCost());
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
/*     */   public void setDistinct(boolean paramBoolean) {
/* 232 */     this.distinct = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isDistinct() {
/* 236 */     return this.distinct;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRandomAccessResult(boolean paramBoolean) {
/* 245 */     this.randomAccessResult = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isQuery() {
/* 250 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/* 255 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void disableCache() {
/* 262 */     this.noCache = true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean sameResultAsLast(Session paramSession, Value[] paramArrayOfValue1, Value[] paramArrayOfValue2, long paramLong) {
/* 267 */     if (!this.cacheableChecked) {
/* 268 */       long l = getMaxDataModificationId();
/* 269 */       this.noCache = (l == Long.MAX_VALUE);
/* 270 */       this.cacheableChecked = true;
/*     */     } 
/* 272 */     if (this.noCache) {
/* 273 */       return false;
/*     */     }
/* 275 */     Database database = paramSession.getDatabase();
/* 276 */     for (byte b = 0; b < paramArrayOfValue1.length; b++) {
/* 277 */       Value value1 = paramArrayOfValue2[b], value2 = paramArrayOfValue1[b];
/* 278 */       if (value1.getType() != value2.getType() || !database.areEqual(value1, value2)) {
/* 279 */         return false;
/*     */       }
/*     */     } 
/* 282 */     if (!isEverything(ExpressionVisitor.DETERMINISTIC_VISITOR) || !isEverything(ExpressionVisitor.INDEPENDENT_VISITOR))
/*     */     {
/* 284 */       return false;
/*     */     }
/* 286 */     if (database.getModificationDataId() > paramLong && getMaxDataModificationId() > paramLong)
/*     */     {
/* 288 */       return false;
/*     */     }
/* 290 */     return true;
/*     */   }
/*     */   
/*     */   public final Value[] getParameterValues() {
/* 294 */     ArrayList<Parameter> arrayList = getParameters();
/* 295 */     if (arrayList == null) {
/* 296 */       arrayList = New.arrayList();
/*     */     }
/* 298 */     int i = arrayList.size();
/* 299 */     Value[] arrayOfValue = new Value[i];
/* 300 */     for (byte b = 0; b < i; b++) {
/* 301 */       Value value = ((Parameter)arrayList.get(b)).getParamValue();
/* 302 */       arrayOfValue[b] = value;
/*     */     } 
/* 304 */     return arrayOfValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public LocalResult query(int paramInt) {
/* 309 */     return query(paramInt, (ResultTarget)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LocalResult query(int paramInt, ResultTarget paramResultTarget) {
/* 320 */     fireBeforeSelectTriggers();
/* 321 */     if (this.noCache || !this.session.getDatabase().getOptimizeReuseResults()) {
/* 322 */       return queryWithoutCache(paramInt, paramResultTarget);
/*     */     }
/* 324 */     Value[] arrayOfValue = getParameterValues();
/* 325 */     long l = this.session.getDatabase().getModificationDataId();
/* 326 */     if (isEverything(ExpressionVisitor.DETERMINISTIC_VISITOR) && 
/* 327 */       this.lastResult != null && !this.lastResult.isClosed() && paramInt == this.lastLimit)
/*     */     {
/* 329 */       if (sameResultAsLast(this.session, arrayOfValue, this.lastParameters, this.lastEvaluated)) {
/*     */         
/* 331 */         this.lastResult = this.lastResult.createShallowCopy(this.session);
/* 332 */         if (this.lastResult != null) {
/* 333 */           this.lastResult.reset();
/* 334 */           return this.lastResult;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 339 */     this.lastParameters = arrayOfValue;
/* 340 */     closeLastResult();
/* 341 */     LocalResult localResult = queryWithoutCache(paramInt, paramResultTarget);
/* 342 */     this.lastResult = localResult;
/* 343 */     this.lastEvaluated = l;
/* 344 */     this.lastLimit = paramInt;
/* 345 */     return localResult;
/*     */   }
/*     */   
/*     */   private void closeLastResult() {
/* 349 */     if (this.lastResult != null) {
/* 350 */       this.lastResult.close();
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void initOrder(Session paramSession, ArrayList<Expression> paramArrayList, ArrayList<String> paramArrayList1, ArrayList<SelectOrderBy> paramArrayList2, int paramInt, boolean paramBoolean, ArrayList<TableFilter> paramArrayList3) {
/* 372 */     Database database = paramSession.getDatabase();
/* 373 */     for (SelectOrderBy selectOrderBy : paramArrayList2) {
/* 374 */       Expression expression1 = selectOrderBy.expression;
/* 375 */       if (expression1 == null) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 382 */       boolean bool = false;
/* 383 */       int i = paramArrayList.size();
/* 384 */       if (expression1 instanceof ExpressionColumn) {
/*     */         
/* 386 */         ExpressionColumn expressionColumn = (ExpressionColumn)expression1;
/* 387 */         String str1 = expressionColumn.getOriginalTableAliasName();
/* 388 */         String str2 = expressionColumn.getOriginalColumnName();
/* 389 */         for (byte b = 0; b < paramInt; b++) {
/* 390 */           boolean bool1 = false;
/* 391 */           Expression expression = paramArrayList.get(b);
/* 392 */           if (expression instanceof ExpressionColumn)
/*     */           
/* 394 */           { ExpressionColumn expressionColumn1 = (ExpressionColumn)expression;
/* 395 */             bool1 = database.equalsIdentifiers(str2, expressionColumn1.getColumnName());
/* 396 */             if (bool1 && str1 != null) {
/* 397 */               String str = expressionColumn1.getOriginalTableAliasName();
/* 398 */               if (str == null) {
/* 399 */                 bool1 = false;
/* 400 */                 if (paramArrayList3 != null) {
/*     */                   byte b1; int j;
/* 402 */                   for (b1 = 0, j = paramArrayList3.size(); b1 < j; b1++) {
/* 403 */                     TableFilter tableFilter = paramArrayList3.get(b1);
/* 404 */                     if (database.equalsIdentifiers(tableFilter.getTableAlias(), str1)) {
/* 405 */                       bool1 = true;
/*     */                       break;
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */               } else {
/* 411 */                 bool1 = database.equalsIdentifiers(str, str1);
/*     */               } 
/*     */             }  }
/* 414 */           else { if (!(expression instanceof org.h2.expression.Alias))
/*     */               continue; 
/* 416 */             if (str1 == null && database.equalsIdentifiers(str2, expression.getAlias())) {
/* 417 */               bool1 = true;
/*     */             } else {
/* 419 */               Expression expression3 = expression.getNonAliasExpression();
/* 420 */               if (expression3 instanceof ExpressionColumn) {
/* 421 */                 ExpressionColumn expressionColumn1 = (ExpressionColumn)expression3;
/* 422 */                 String str3 = expressionColumn.getSQL();
/* 423 */                 String str4 = expressionColumn1.getSQL();
/* 424 */                 String str5 = expressionColumn1.getColumnName();
/* 425 */                 bool1 = database.equalsIdentifiers(str2, str5);
/* 426 */                 if (!database.equalsIdentifiers(str3, str4))
/* 427 */                   bool1 = false; 
/*     */               } 
/*     */             }  }
/*     */           
/* 431 */           if (bool1) {
/* 432 */             i = b;
/* 433 */             bool = true; break;
/*     */           } 
/*     */           continue;
/*     */         } 
/*     */       } else {
/* 438 */         String str = expression1.getSQL();
/* 439 */         if (paramArrayList1 != null) {
/* 440 */           byte b; int j; for (b = 0, j = paramArrayList1.size(); b < j; b++) {
/* 441 */             String str1 = paramArrayList1.get(b);
/* 442 */             if (database.equalsIdentifiers(str1, str)) {
/* 443 */               i = b;
/* 444 */               bool = true;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 450 */       if (!bool) {
/* 451 */         if (paramBoolean) {
/* 452 */           throw DbException.get(90068, expression1.getSQL());
/*     */         }
/*     */         
/* 455 */         paramArrayList.add(expression1);
/* 456 */         String str = expression1.getSQL();
/* 457 */         paramArrayList1.add(str);
/*     */       } 
/* 459 */       selectOrderBy.columnIndexExpr = (Expression)ValueExpression.get((Value)ValueInt.get(i + 1));
/* 460 */       Expression expression2 = ((Expression)paramArrayList.get(i)).getNonAliasExpression();
/* 461 */       selectOrderBy.expression = expression2;
/*     */     } 
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
/*     */   public SortOrder prepareOrder(ArrayList<SelectOrderBy> paramArrayList, int paramInt) {
/* 475 */     int i = paramArrayList.size();
/* 476 */     int[] arrayOfInt1 = new int[i];
/* 477 */     int[] arrayOfInt2 = new int[i];
/* 478 */     for (byte b = 0; b < i; b++) {
/* 479 */       int j; SelectOrderBy selectOrderBy = paramArrayList.get(b);
/*     */       
/* 481 */       boolean bool1 = false;
/* 482 */       Expression expression = selectOrderBy.columnIndexExpr;
/* 483 */       Value value = expression.getValue(null);
/* 484 */       if (value == ValueNull.INSTANCE) {
/*     */         
/* 486 */         j = 0;
/*     */       } else {
/* 488 */         j = value.getInt();
/* 489 */         if (j < 0) {
/* 490 */           bool1 = true;
/* 491 */           j = -j;
/*     */         } 
/* 493 */         j--;
/* 494 */         if (j < 0 || j >= paramInt) {
/* 495 */           throw DbException.get(90068, "" + (j + 1));
/*     */         }
/*     */       } 
/* 498 */       arrayOfInt1[b] = j;
/* 499 */       boolean bool = selectOrderBy.descending;
/* 500 */       if (bool1) {
/* 501 */         bool = !bool;
/*     */       }
/* 503 */       boolean bool2 = bool ? true : false;
/* 504 */       if (selectOrderBy.nullsFirst) {
/* 505 */         bool2 += true;
/* 506 */       } else if (selectOrderBy.nullsLast) {
/* 507 */         bool2 += true;
/*     */       } 
/* 509 */       arrayOfInt2[b] = bool2;
/*     */     } 
/* 511 */     return new SortOrder(this.session.getDatabase(), arrayOfInt1, arrayOfInt2, paramArrayList);
/*     */   }
/*     */   
/*     */   public void setOffset(Expression paramExpression) {
/* 515 */     this.offsetExpr = paramExpression;
/*     */   }
/*     */   
/*     */   public Expression getOffset() {
/* 519 */     return this.offsetExpr;
/*     */   }
/*     */   
/*     */   public void setLimit(Expression paramExpression) {
/* 523 */     this.limitExpr = paramExpression;
/*     */   }
/*     */   
/*     */   public Expression getLimit() {
/* 527 */     return this.limitExpr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void addParameter(Parameter paramParameter) {
/* 536 */     if (this.parameters == null) {
/* 537 */       this.parameters = New.arrayList();
/*     */     }
/* 539 */     this.parameters.add(paramParameter);
/*     */   }
/*     */   
/*     */   public void setSampleSize(Expression paramExpression) {
/* 543 */     this.sampleSizeExpr = paramExpression;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getSampleSizeValue(Session paramSession) {
/* 553 */     if (this.sampleSizeExpr == null) {
/* 554 */       return 0;
/*     */     }
/* 556 */     Value value = this.sampleSizeExpr.optimize(paramSession).getValue(paramSession);
/* 557 */     if (value == ValueNull.INSTANCE) {
/* 558 */       return 0;
/*     */     }
/* 560 */     return value.getInt();
/*     */   }
/*     */   
/*     */   public final long getMaxDataModificationId() {
/* 564 */     ExpressionVisitor expressionVisitor = ExpressionVisitor.getMaxModificationIdVisitor();
/* 565 */     isEverything(expressionVisitor);
/* 566 */     return expressionVisitor.getMaxDataModificationId();
/*     */   }
/*     */   
/*     */   public abstract boolean isUnion();
/*     */   
/*     */   public abstract void prepareJoinBatch();
/*     */   
/*     */   protected abstract LocalResult queryWithoutCache(int paramInt, ResultTarget paramResultTarget);
/*     */   
/*     */   public abstract void init();
/*     */   
/*     */   public abstract ArrayList<Expression> getExpressions();
/*     */   
/*     */   public abstract double getCost();
/*     */   
/*     */   public abstract HashSet<Table> getTables();
/*     */   
/*     */   public abstract void setOrder(ArrayList<SelectOrderBy> paramArrayList);
/*     */   
/*     */   public abstract boolean hasOrder();
/*     */   
/*     */   public abstract void setForUpdate(boolean paramBoolean);
/*     */   
/*     */   public abstract int getColumnCount();
/*     */   
/*     */   public abstract void mapColumns(ColumnResolver paramColumnResolver, int paramInt);
/*     */   
/*     */   public abstract void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean);
/*     */   
/*     */   public abstract void addGlobalCondition(Parameter paramParameter, int paramInt1, int paramInt2);
/*     */   
/*     */   public abstract boolean allowGlobalConditions();
/*     */   
/*     */   public abstract boolean isEverything(ExpressionVisitor paramExpressionVisitor);
/*     */   
/*     */   public abstract void updateAggregate(Session paramSession);
/*     */   
/*     */   public abstract void fireBeforeSelectTriggers();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\Query.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */