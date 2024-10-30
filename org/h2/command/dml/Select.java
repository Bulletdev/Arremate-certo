/*      */ package org.h2.command.dml;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import org.h2.engine.Database;
/*      */ import org.h2.engine.DbObject;
/*      */ import org.h2.engine.Session;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.expression.Comparison;
/*      */ import org.h2.expression.ConditionAndOr;
/*      */ import org.h2.expression.Expression;
/*      */ import org.h2.expression.ExpressionColumn;
/*      */ import org.h2.expression.ExpressionVisitor;
/*      */ import org.h2.expression.Parameter;
/*      */ import org.h2.index.Cursor;
/*      */ import org.h2.index.Index;
/*      */ import org.h2.index.IndexType;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.result.LocalResult;
/*      */ import org.h2.result.ResultInterface;
/*      */ import org.h2.result.ResultTarget;
/*      */ import org.h2.result.SearchRow;
/*      */ import org.h2.result.SortOrder;
/*      */ import org.h2.table.Column;
/*      */ import org.h2.table.ColumnResolver;
/*      */ import org.h2.table.IndexColumn;
/*      */ import org.h2.table.JoinBatch;
/*      */ import org.h2.table.Table;
/*      */ import org.h2.table.TableFilter;
/*      */ import org.h2.table.TableView;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.StatementBuilder;
/*      */ import org.h2.util.StringUtils;
/*      */ import org.h2.util.ValueHashMap;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueArray;
/*      */ import org.h2.value.ValueNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Select
/*      */   extends Query
/*      */ {
/*      */   private TableFilter topTableFilter;
/*   65 */   private final ArrayList<TableFilter> filters = New.arrayList();
/*   66 */   private final ArrayList<TableFilter> topFilters = New.arrayList();
/*      */   
/*      */   private ArrayList<Expression> expressions;
/*      */   
/*      */   private Expression[] expressionArray;
/*      */   
/*      */   private Expression having;
/*      */   
/*      */   private Expression condition;
/*      */   
/*      */   private int visibleColumnCount;
/*      */   
/*      */   private int distinctColumnCount;
/*      */   
/*      */   private ArrayList<SelectOrderBy> orderList;
/*      */   private ArrayList<Expression> group;
/*      */   private int[] groupIndex;
/*      */   private boolean[] groupByExpression;
/*      */   private HashMap<Expression, Object> currentGroup;
/*      */   private int havingIndex;
/*      */   
/*      */   public Select(Session paramSession) {
/*   88 */     super(paramSession);
/*      */   }
/*      */   private boolean isGroupQuery; private boolean isGroupSortedQuery; private boolean isForUpdate; private boolean isForUpdateMvcc; private double cost; private boolean isQuickAggregateQuery; private boolean isDistinctQuery; private boolean isPrepared; private boolean checkInit; private boolean sortUsingIndex; private SortOrder sort; private int currentGroupRowId;
/*      */   
/*      */   public boolean isUnion() {
/*   93 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addTableFilter(TableFilter paramTableFilter, boolean paramBoolean) {
/*  110 */     this.filters.add(paramTableFilter);
/*  111 */     if (paramBoolean) {
/*  112 */       this.topFilters.add(paramTableFilter);
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<TableFilter> getTopFilters() {
/*  117 */     return this.topFilters;
/*      */   }
/*      */   
/*      */   public void setExpressions(ArrayList<Expression> paramArrayList) {
/*  121 */     this.expressions = paramArrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGroupQuery() {
/*  128 */     this.isGroupQuery = true;
/*      */   }
/*      */   
/*      */   public void setGroupBy(ArrayList<Expression> paramArrayList) {
/*  132 */     this.group = paramArrayList;
/*      */   }
/*      */   
/*      */   public ArrayList<Expression> getGroupBy() {
/*  136 */     return this.group;
/*      */   }
/*      */   
/*      */   public HashMap<Expression, Object> getCurrentGroup() {
/*  140 */     return this.currentGroup;
/*      */   }
/*      */   
/*      */   public int getCurrentGroupRowId() {
/*  144 */     return this.currentGroupRowId;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setOrder(ArrayList<SelectOrderBy> paramArrayList) {
/*  149 */     this.orderList = paramArrayList;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasOrder() {
/*  154 */     return (this.orderList != null || this.sort != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCondition(Expression paramExpression) {
/*  163 */     if (this.condition == null) {
/*  164 */       this.condition = paramExpression;
/*      */     } else {
/*  166 */       this.condition = (Expression)new ConditionAndOr(0, paramExpression, this.condition);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void queryGroupSorted(int paramInt, ResultTarget paramResultTarget) {
/*  171 */     byte b = 0;
/*  172 */     setCurrentRowNumber(0);
/*  173 */     this.currentGroup = null;
/*  174 */     Value[] arrayOfValue = null;
/*  175 */     while (this.topTableFilter.next()) {
/*  176 */       setCurrentRowNumber(b + 1);
/*  177 */       if (this.condition == null || Boolean.TRUE.equals(this.condition.getBooleanValue(this.session))) {
/*      */         
/*  179 */         b++;
/*  180 */         Value[] arrayOfValue1 = new Value[this.groupIndex.length];
/*      */         byte b1;
/*  182 */         for (b1 = 0; b1 < this.groupIndex.length; b1++) {
/*  183 */           int i = this.groupIndex[b1];
/*  184 */           Expression expression = this.expressions.get(i);
/*  185 */           arrayOfValue1[b1] = expression.getValue(this.session);
/*      */         } 
/*      */         
/*  188 */         if (arrayOfValue == null) {
/*  189 */           arrayOfValue = arrayOfValue1;
/*  190 */           this.currentGroup = New.hashMap();
/*  191 */         } else if (!Arrays.equals((Object[])arrayOfValue, (Object[])arrayOfValue1)) {
/*  192 */           addGroupSortedRow(arrayOfValue, paramInt, paramResultTarget);
/*  193 */           arrayOfValue = arrayOfValue1;
/*  194 */           this.currentGroup = New.hashMap();
/*      */         } 
/*  196 */         this.currentGroupRowId++;
/*      */         
/*  198 */         for (b1 = 0; b1 < paramInt; b1++) {
/*  199 */           if (this.groupByExpression == null || !this.groupByExpression[b1]) {
/*  200 */             Expression expression = this.expressions.get(b1);
/*  201 */             expression.updateAggregate(this.session);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  206 */     if (arrayOfValue != null) {
/*  207 */       addGroupSortedRow(arrayOfValue, paramInt, paramResultTarget);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void addGroupSortedRow(Value[] paramArrayOfValue, int paramInt, ResultTarget paramResultTarget) {
/*  213 */     Value[] arrayOfValue = new Value[paramInt]; byte b;
/*  214 */     for (b = 0; this.groupIndex != null && b < this.groupIndex.length; b++) {
/*  215 */       arrayOfValue[this.groupIndex[b]] = paramArrayOfValue[b];
/*      */     }
/*  217 */     for (b = 0; b < paramInt; b++) {
/*  218 */       if (this.groupByExpression == null || !this.groupByExpression[b]) {
/*      */ 
/*      */         
/*  221 */         Expression expression = this.expressions.get(b);
/*  222 */         arrayOfValue[b] = expression.getValue(this.session);
/*      */       } 
/*  224 */     }  if (isHavingNullOrFalse(arrayOfValue)) {
/*      */       return;
/*      */     }
/*  227 */     arrayOfValue = keepOnlyDistinct(arrayOfValue, paramInt);
/*  228 */     paramResultTarget.addRow(arrayOfValue);
/*      */   }
/*      */   
/*      */   private Value[] keepOnlyDistinct(Value[] paramArrayOfValue, int paramInt) {
/*  232 */     if (paramInt == this.distinctColumnCount) {
/*  233 */       return paramArrayOfValue;
/*      */     }
/*      */     
/*  236 */     Value[] arrayOfValue = new Value[this.distinctColumnCount];
/*  237 */     System.arraycopy(paramArrayOfValue, 0, arrayOfValue, 0, this.distinctColumnCount);
/*  238 */     return arrayOfValue;
/*      */   }
/*      */   
/*      */   private boolean isHavingNullOrFalse(Value[] paramArrayOfValue) {
/*  242 */     if (this.havingIndex >= 0) {
/*  243 */       Value value = paramArrayOfValue[this.havingIndex];
/*  244 */       if (value == ValueNull.INSTANCE) {
/*  245 */         return true;
/*      */       }
/*  247 */       if (!Boolean.TRUE.equals(value.getBoolean())) {
/*  248 */         return true;
/*      */       }
/*      */     } 
/*  251 */     return false;
/*      */   }
/*      */   
/*      */   private Index getGroupSortedIndex() {
/*  255 */     if (this.groupIndex == null || this.groupByExpression == null) {
/*  256 */       return null;
/*      */     }
/*  258 */     ArrayList<Index> arrayList = this.topTableFilter.getTable().getIndexes();
/*  259 */     if (arrayList != null) {
/*  260 */       byte b; int i; for (b = 0, i = arrayList.size(); b < i; b++) {
/*  261 */         Index index = arrayList.get(b);
/*  262 */         if (!index.getIndexType().isScan())
/*      */         {
/*      */           
/*  265 */           if (!index.getIndexType().isHash())
/*      */           {
/*      */ 
/*      */             
/*  269 */             if (isGroupSortedIndex(this.topTableFilter, index))
/*  270 */               return index;  } 
/*      */         }
/*      */       } 
/*      */     } 
/*  274 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean isGroupSortedIndex(TableFilter paramTableFilter, Index paramIndex) {
/*  279 */     Column[] arrayOfColumn = paramIndex.getColumns();
/*      */     
/*  281 */     boolean[] arrayOfBoolean = new boolean[arrayOfColumn.length]; byte b;
/*      */     int i;
/*  283 */     for (b = 0, i = this.expressions.size(); b < i; b++) {
/*  284 */       if (this.groupByExpression[b]) {
/*      */ 
/*      */         
/*  287 */         Expression expression = ((Expression)this.expressions.get(b)).getNonAliasExpression();
/*  288 */         if (!(expression instanceof ExpressionColumn)) {
/*  289 */           return false;
/*      */         }
/*  291 */         ExpressionColumn expressionColumn = (ExpressionColumn)expression;
/*  292 */         byte b1 = 0; while (true) { if (b1 < arrayOfColumn.length) {
/*  293 */             if (paramTableFilter == expressionColumn.getTableFilter() && 
/*  294 */               arrayOfColumn[b1].equals(expressionColumn.getColumn())) {
/*  295 */               arrayOfBoolean[b1] = true;
/*      */               
/*      */               break;
/*      */             } 
/*      */             b1++;
/*      */             continue;
/*      */           } 
/*  302 */           return false; }
/*      */       
/*      */       } 
/*      */     } 
/*      */     
/*  307 */     for (b = 1; b < arrayOfBoolean.length; b++) {
/*  308 */       if (!arrayOfBoolean[b - 1] && arrayOfBoolean[b]) {
/*  309 */         return false;
/*      */       }
/*      */     } 
/*  312 */     return true;
/*      */   }
/*      */   
/*      */   private int getGroupByExpressionCount() {
/*  316 */     if (this.groupByExpression == null) {
/*  317 */       return 0;
/*      */     }
/*  319 */     byte b = 0;
/*  320 */     for (boolean bool : this.groupByExpression) {
/*  321 */       if (bool) {
/*  322 */         b++;
/*      */       }
/*      */     } 
/*  325 */     return b;
/*      */   }
/*      */   
/*      */   private void queryGroup(int paramInt, LocalResult paramLocalResult) {
/*  329 */     ValueHashMap valueHashMap = ValueHashMap.newInstance();
/*      */     
/*  331 */     byte b = 0;
/*  332 */     setCurrentRowNumber(0);
/*  333 */     this.currentGroup = null;
/*  334 */     ValueArray valueArray = ValueArray.get(new Value[0]);
/*  335 */     int i = getSampleSizeValue(this.session);
/*  336 */     while (this.topTableFilter.next()) {
/*  337 */       setCurrentRowNumber(b + 1);
/*  338 */       if (this.condition == null || Boolean.TRUE.equals(this.condition.getBooleanValue(this.session))) {
/*      */         ValueArray valueArray1;
/*      */         
/*  341 */         b++;
/*  342 */         if (this.groupIndex == null) {
/*  343 */           valueArray1 = valueArray;
/*      */         } else {
/*  345 */           Value[] arrayOfValue = new Value[this.groupIndex.length];
/*      */           
/*  347 */           for (byte b2 = 0; b2 < this.groupIndex.length; b2++) {
/*  348 */             int k = this.groupIndex[b2];
/*  349 */             Expression expression = this.expressions.get(k);
/*  350 */             arrayOfValue[b2] = expression.getValue(this.session);
/*      */           } 
/*  352 */           valueArray1 = ValueArray.get(arrayOfValue);
/*      */         } 
/*  354 */         HashMap<Object, Object> hashMap = (HashMap)valueHashMap.get((Value)valueArray1);
/*  355 */         if (hashMap == null) {
/*  356 */           hashMap = new HashMap<>();
/*  357 */           valueHashMap.put((Value)valueArray1, hashMap);
/*      */         } 
/*  359 */         this.currentGroup = (HashMap)hashMap;
/*  360 */         this.currentGroupRowId++;
/*  361 */         int j = paramInt;
/*  362 */         for (byte b1 = 0; b1 < j; b1++) {
/*  363 */           if (this.groupByExpression == null || !this.groupByExpression[b1]) {
/*  364 */             Expression expression = this.expressions.get(b1);
/*  365 */             expression.updateAggregate(this.session);
/*      */           } 
/*      */         } 
/*  368 */         if (i > 0 && b >= i) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     } 
/*  373 */     if (this.groupIndex == null && valueHashMap.size() == 0) {
/*  374 */       valueHashMap.put((Value)valueArray, new HashMap<>());
/*      */     }
/*  376 */     ArrayList arrayList = valueHashMap.keys();
/*  377 */     for (Value value : arrayList) {
/*  378 */       ValueArray valueArray1 = (ValueArray)value;
/*  379 */       this.currentGroup = (HashMap<Expression, Object>)valueHashMap.get((Value)valueArray1);
/*  380 */       Value[] arrayOfValue1 = valueArray1.getList();
/*  381 */       Value[] arrayOfValue2 = new Value[paramInt]; byte b1;
/*  382 */       for (b1 = 0; this.groupIndex != null && b1 < this.groupIndex.length; b1++) {
/*  383 */         arrayOfValue2[this.groupIndex[b1]] = arrayOfValue1[b1];
/*      */       }
/*  385 */       for (b1 = 0; b1 < paramInt; b1++) {
/*  386 */         if (this.groupByExpression == null || !this.groupByExpression[b1]) {
/*      */ 
/*      */           
/*  389 */           Expression expression = this.expressions.get(b1);
/*  390 */           arrayOfValue2[b1] = expression.getValue(this.session);
/*      */         } 
/*  392 */       }  if (isHavingNullOrFalse(arrayOfValue2)) {
/*      */         continue;
/*      */       }
/*  395 */       arrayOfValue2 = keepOnlyDistinct(arrayOfValue2, paramInt);
/*  396 */       paramLocalResult.addRow(arrayOfValue2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Index getSortIndex() {
/*  409 */     if (this.sort == null) {
/*  410 */       return null;
/*      */     }
/*  412 */     ArrayList<Column> arrayList = New.arrayList();
/*  413 */     for (int i : this.sort.getQueryColumnIndexes()) {
/*  414 */       if (i < 0 || i >= this.expressions.size()) {
/*  415 */         throw DbException.getInvalidValueException("ORDER BY", Integer.valueOf(i + 1));
/*      */       }
/*  417 */       Expression expression = this.expressions.get(i);
/*  418 */       expression = expression.getNonAliasExpression();
/*  419 */       if (!expression.isConstant()) {
/*      */ 
/*      */         
/*  422 */         if (!(expression instanceof ExpressionColumn)) {
/*  423 */           return null;
/*      */         }
/*  425 */         ExpressionColumn expressionColumn = (ExpressionColumn)expression;
/*  426 */         if (expressionColumn.getTableFilter() != this.topTableFilter) {
/*  427 */           return null;
/*      */         }
/*  429 */         arrayList.add(expressionColumn.getColumn());
/*      */       } 
/*  431 */     }  Column[] arrayOfColumn = arrayList.<Column>toArray(new Column[arrayList.size()]);
/*  432 */     int[] arrayOfInt = this.sort.getSortTypes();
/*  433 */     if (arrayOfColumn.length == 0)
/*      */     {
/*  435 */       return this.topTableFilter.getTable().getScanIndex(this.session);
/*      */     }
/*  437 */     ArrayList<Index> arrayList1 = this.topTableFilter.getTable().getIndexes();
/*  438 */     if (arrayList1 != null) {
/*  439 */       byte b; int i; for (b = 0, i = arrayList1.size(); b < i; b++) {
/*  440 */         Index index = arrayList1.get(b);
/*  441 */         if (index.getCreateSQL() != null)
/*      */         {
/*      */ 
/*      */           
/*  445 */           if (!index.getIndexType().isHash()) {
/*      */ 
/*      */             
/*  448 */             IndexColumn[] arrayOfIndexColumn = index.getIndexColumns();
/*  449 */             if (arrayOfIndexColumn.length >= arrayOfColumn.length) {
/*      */ 
/*      */               
/*  452 */               boolean bool = true;
/*  453 */               for (byte b1 = 0; b1 < arrayOfColumn.length; b1++) {
/*      */ 
/*      */                 
/*  456 */                 IndexColumn indexColumn = arrayOfIndexColumn[b1];
/*  457 */                 Column column = arrayOfColumn[b1];
/*  458 */                 if (indexColumn.column != column) {
/*  459 */                   bool = false;
/*      */                   break;
/*      */                 } 
/*  462 */                 if (indexColumn.sortType != arrayOfInt[b1]) {
/*      */ 
/*      */                   
/*  465 */                   bool = false;
/*      */                   break;
/*      */                 } 
/*      */               } 
/*  469 */               if (bool)
/*  470 */                 return index; 
/*      */             } 
/*      */           }  } 
/*      */       } 
/*  474 */     }  if (arrayOfColumn.length == 1 && arrayOfColumn[0].getColumnId() == -1) {
/*      */       
/*  476 */       Index index = this.topTableFilter.getTable().getScanIndex(this.session);
/*  477 */       if (index.isRowIdIndex()) {
/*  478 */         return index;
/*      */       }
/*      */     } 
/*  481 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void queryDistinct(ResultTarget paramResultTarget, long paramLong) {
/*  488 */     if (paramLong > 0L && this.offsetExpr != null) {
/*  489 */       int k = this.offsetExpr.getValue(this.session).getInt();
/*  490 */       if (k > 0) {
/*  491 */         paramLong += k;
/*      */       }
/*      */     } 
/*  494 */     byte b = 0;
/*  495 */     setCurrentRowNumber(0);
/*  496 */     Index index = this.topTableFilter.getIndex();
/*  497 */     SearchRow searchRow = null;
/*  498 */     int i = index.getColumns()[0].getColumnId();
/*  499 */     int j = getSampleSizeValue(this.session);
/*      */     do {
/*  501 */       setCurrentRowNumber(b + 1);
/*  502 */       Cursor cursor = index.findNext(this.session, searchRow, null);
/*  503 */       if (!cursor.next()) {
/*      */         break;
/*      */       }
/*  506 */       SearchRow searchRow1 = cursor.getSearchRow();
/*  507 */       Value value = searchRow1.getValue(i);
/*  508 */       if (searchRow == null) {
/*  509 */         searchRow = this.topTableFilter.getTable().getTemplateSimpleRow(true);
/*      */       }
/*  511 */       searchRow.setValue(i, value);
/*  512 */       Value[] arrayOfValue = { value };
/*  513 */       paramResultTarget.addRow(arrayOfValue);
/*  514 */       b++;
/*  515 */       if ((this.sort == null || this.sortUsingIndex) && paramLong > 0L && b >= paramLong) {
/*      */         break;
/*      */       }
/*      */     }
/*  519 */     while (j <= 0 || b < j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void queryFlat(int paramInt, ResultTarget paramResultTarget, long paramLong) {
/*  529 */     if (paramLong > 0L && this.offsetExpr != null) {
/*  530 */       int j = this.offsetExpr.getValue(this.session).getInt();
/*  531 */       if (j > 0) {
/*  532 */         paramLong += j;
/*      */       }
/*      */     } 
/*  535 */     byte b = 0;
/*  536 */     setCurrentRowNumber(0);
/*  537 */     ArrayList arrayList = null;
/*  538 */     if (this.isForUpdateMvcc) {
/*  539 */       arrayList = New.arrayList();
/*      */     }
/*  541 */     int i = getSampleSizeValue(this.session);
/*  542 */     while (this.topTableFilter.next()) {
/*  543 */       setCurrentRowNumber(b + 1);
/*  544 */       if (this.condition == null || Boolean.TRUE.equals(this.condition.getBooleanValue(this.session))) {
/*      */         
/*  546 */         Value[] arrayOfValue = new Value[paramInt];
/*  547 */         for (byte b1 = 0; b1 < paramInt; b1++) {
/*  548 */           Expression expression = this.expressions.get(b1);
/*  549 */           arrayOfValue[b1] = expression.getValue(this.session);
/*      */         } 
/*  551 */         if (this.isForUpdateMvcc) {
/*  552 */           this.topTableFilter.lockRowAdd(arrayList);
/*      */         }
/*  554 */         paramResultTarget.addRow(arrayOfValue);
/*  555 */         b++;
/*  556 */         if ((this.sort == null || this.sortUsingIndex) && paramLong > 0L && paramResultTarget.getRowCount() >= paramLong) {
/*      */           break;
/*      */         }
/*      */         
/*  560 */         if (i > 0 && b >= i) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     } 
/*  565 */     if (this.isForUpdateMvcc) {
/*  566 */       this.topTableFilter.lockRows(arrayList);
/*      */     }
/*      */   }
/*      */   
/*      */   private void queryQuick(int paramInt, ResultTarget paramResultTarget) {
/*  571 */     Value[] arrayOfValue = new Value[paramInt];
/*  572 */     for (byte b = 0; b < paramInt; b++) {
/*  573 */       Expression expression = this.expressions.get(b);
/*  574 */       arrayOfValue[b] = expression.getValue(this.session);
/*      */     } 
/*  576 */     paramResultTarget.addRow(arrayOfValue);
/*      */   }
/*      */ 
/*      */   
/*      */   public ResultInterface queryMeta() {
/*  581 */     LocalResult localResult = new LocalResult(this.session, this.expressionArray, this.visibleColumnCount);
/*      */     
/*  583 */     localResult.done();
/*  584 */     return (ResultInterface)localResult;
/*      */   }
/*      */ 
/*      */   
/*      */   protected LocalResult queryWithoutCache(int paramInt, ResultTarget paramResultTarget) {
/*  589 */     int i = (paramInt == 0) ? -1 : paramInt;
/*  590 */     if (this.limitExpr != null) {
/*  591 */       Value value = this.limitExpr.getValue(this.session);
/*  592 */       byte b = (value == ValueNull.INSTANCE) ? -1 : value.getInt();
/*  593 */       if (i) {
/*  594 */         i = b;
/*  595 */       } else if (b) {
/*  596 */         i = Math.min(b, i);
/*      */       } 
/*      */     } 
/*  599 */     int j = this.expressions.size();
/*  600 */     LocalResult localResult = null;
/*  601 */     if (paramResultTarget == null || !(this.session.getDatabase().getSettings()).optimizeInsertFromSelect)
/*      */     {
/*  603 */       localResult = createLocalResult(localResult);
/*      */     }
/*  605 */     if (this.sort != null && (!this.sortUsingIndex || this.distinct)) {
/*  606 */       localResult = createLocalResult(localResult);
/*  607 */       localResult.setSortOrder(this.sort);
/*      */     } 
/*  609 */     if (this.distinct && !this.isDistinctQuery) {
/*  610 */       localResult = createLocalResult(localResult);
/*  611 */       localResult.setDistinct();
/*      */     } 
/*  613 */     if (this.randomAccessResult) {
/*  614 */       localResult = createLocalResult(localResult);
/*      */     }
/*  616 */     if (this.isGroupQuery && !this.isGroupSortedQuery) {
/*  617 */       localResult = createLocalResult(localResult);
/*      */     }
/*  619 */     if (i >= 0 || this.offsetExpr != null) {
/*  620 */       localResult = createLocalResult(localResult);
/*      */     }
/*  622 */     this.topTableFilter.startQuery(this.session);
/*  623 */     this.topTableFilter.reset();
/*  624 */     boolean bool = (this.isForUpdate && !this.isForUpdateMvcc) ? true : false;
/*  625 */     if (this.isForUpdateMvcc) {
/*  626 */       if (this.isGroupQuery) {
/*  627 */         throw DbException.getUnsupportedException("MVCC=TRUE && FOR UPDATE && GROUP");
/*      */       }
/*  629 */       if (this.distinct) {
/*  630 */         throw DbException.getUnsupportedException("MVCC=TRUE && FOR UPDATE && DISTINCT");
/*      */       }
/*  632 */       if (this.isQuickAggregateQuery) {
/*  633 */         throw DbException.getUnsupportedException("MVCC=TRUE && FOR UPDATE && AGGREGATE");
/*      */       }
/*  635 */       if (this.topTableFilter.getJoin() != null) {
/*  636 */         throw DbException.getUnsupportedException("MVCC=TRUE && FOR UPDATE && JOIN");
/*      */       }
/*      */     } 
/*      */     
/*  640 */     this.topTableFilter.lock(this.session, bool, bool);
/*  641 */     ResultTarget resultTarget = (ResultTarget)((localResult != null) ? localResult : paramResultTarget);
/*  642 */     if (i != 0) {
/*      */       try {
/*  644 */         if (this.isQuickAggregateQuery) {
/*  645 */           queryQuick(j, resultTarget);
/*  646 */         } else if (this.isGroupQuery) {
/*  647 */           if (this.isGroupSortedQuery) {
/*  648 */             queryGroupSorted(j, resultTarget);
/*      */           } else {
/*  650 */             queryGroup(j, localResult);
/*      */           } 
/*  652 */         } else if (this.isDistinctQuery) {
/*  653 */           queryDistinct(resultTarget, i);
/*      */         } else {
/*  655 */           queryFlat(j, resultTarget, i);
/*      */         } 
/*      */       } finally {
/*  658 */         JoinBatch joinBatch = getJoinBatch();
/*  659 */         if (joinBatch != null) {
/*  660 */           joinBatch.reset(false);
/*      */         }
/*      */       } 
/*      */     }
/*  664 */     if (this.offsetExpr != null) {
/*  665 */       localResult.setOffset(this.offsetExpr.getValue(this.session).getInt());
/*      */     }
/*  667 */     if (i >= 0) {
/*  668 */       localResult.setLimit(i);
/*      */     }
/*  670 */     if (localResult != null) {
/*  671 */       localResult.done();
/*  672 */       if (paramResultTarget != null) {
/*  673 */         while (localResult.next()) {
/*  674 */           paramResultTarget.addRow(localResult.currentRow());
/*      */         }
/*  676 */         localResult.close();
/*  677 */         return null;
/*      */       } 
/*  679 */       return localResult;
/*      */     } 
/*  681 */     return null;
/*      */   }
/*      */   
/*      */   private LocalResult createLocalResult(LocalResult paramLocalResult) {
/*  685 */     return (paramLocalResult != null) ? paramLocalResult : new LocalResult(this.session, this.expressionArray, this.visibleColumnCount);
/*      */   }
/*      */ 
/*      */   
/*      */   private void expandColumnList() {
/*  690 */     Database database = this.session.getDatabase();
/*      */ 
/*      */     
/*  693 */     for (int i = 0; i < this.expressions.size(); i++) {
/*  694 */       Expression expression = this.expressions.get(i);
/*  695 */       if (expression.isWildcard()) {
/*      */ 
/*      */         
/*  698 */         String str1 = expression.getSchemaName();
/*  699 */         String str2 = expression.getTableAlias();
/*  700 */         if (str2 == null) {
/*  701 */           this.expressions.remove(i);
/*  702 */           for (TableFilter tableFilter : this.filters) {
/*  703 */             i = expandColumnList(tableFilter, i);
/*      */           }
/*  705 */           i--;
/*      */         } else {
/*  707 */           TableFilter tableFilter = null;
/*  708 */           for (TableFilter tableFilter1 : this.filters) {
/*  709 */             if (database.equalsIdentifiers(str2, tableFilter1.getTableAlias()) && (
/*  710 */               str1 == null || database.equalsIdentifiers(str1, tableFilter1.getSchemaName()))) {
/*      */ 
/*      */               
/*  713 */               tableFilter = tableFilter1;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*  718 */           if (tableFilter == null) {
/*  719 */             throw DbException.get(42102, str2);
/*      */           }
/*      */           
/*  722 */           this.expressions.remove(i);
/*  723 */           i = expandColumnList(tableFilter, i);
/*  724 */           i--;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private int expandColumnList(TableFilter paramTableFilter, int paramInt) {
/*  730 */     Table table = paramTableFilter.getTable();
/*  731 */     String str = paramTableFilter.getTableAlias();
/*  732 */     Column[] arrayOfColumn = table.getColumns();
/*  733 */     for (Column column : arrayOfColumn) {
/*  734 */       if (!paramTableFilter.isNaturalJoinColumn(column)) {
/*      */ 
/*      */         
/*  737 */         ExpressionColumn expressionColumn = new ExpressionColumn(this.session.getDatabase(), null, str, column.getName());
/*      */         
/*  739 */         this.expressions.add(paramInt++, expressionColumn);
/*      */       } 
/*  741 */     }  return paramInt;
/*      */   }
/*      */   
/*      */   public void init() {
/*      */     ArrayList<String> arrayList;
/*  746 */     if (SysProperties.CHECK && this.checkInit) {
/*  747 */       DbException.throwInternalError();
/*      */     }
/*  749 */     expandColumnList();
/*  750 */     this.visibleColumnCount = this.expressions.size();
/*      */     
/*  752 */     if (this.orderList != null || this.group != null) {
/*  753 */       arrayList = New.arrayList();
/*  754 */       for (byte b = 0; b < this.visibleColumnCount; b++) {
/*  755 */         Expression expression = this.expressions.get(b);
/*  756 */         expression = expression.getNonAliasExpression();
/*  757 */         String str = expression.getSQL();
/*  758 */         arrayList.add(str);
/*      */       } 
/*      */     } else {
/*  761 */       arrayList = null;
/*      */     } 
/*  763 */     if (this.orderList != null) {
/*  764 */       initOrder(this.session, this.expressions, arrayList, this.orderList, this.visibleColumnCount, this.distinct, this.filters);
/*      */     }
/*      */     
/*  767 */     this.distinctColumnCount = this.expressions.size();
/*  768 */     if (this.having != null) {
/*  769 */       this.expressions.add(this.having);
/*  770 */       this.havingIndex = this.expressions.size() - 1;
/*  771 */       this.having = null;
/*      */     } else {
/*  773 */       this.havingIndex = -1;
/*      */     } 
/*      */     
/*  776 */     Database database = this.session.getDatabase();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  782 */     if (this.group != null) {
/*  783 */       int i = this.group.size();
/*  784 */       int j = arrayList.size();
/*  785 */       this.groupIndex = new int[i];
/*  786 */       for (byte b = 0; b < i; b++) {
/*  787 */         Expression expression = this.group.get(b);
/*  788 */         String str = expression.getSQL();
/*  789 */         int k = -1; int m;
/*  790 */         for (m = 0; m < j; m++) {
/*  791 */           String str1 = arrayList.get(m);
/*  792 */           if (database.equalsIdentifiers(str1, str)) {
/*  793 */             k = m;
/*      */             break;
/*      */           } 
/*      */         } 
/*  797 */         if (k < 0)
/*      */         {
/*  799 */           for (m = 0; m < j; m++) {
/*  800 */             Expression expression1 = this.expressions.get(m);
/*  801 */             if (database.equalsIdentifiers(str, expression1.getAlias())) {
/*  802 */               k = m;
/*      */               break;
/*      */             } 
/*  805 */             str = expression.getAlias();
/*  806 */             if (database.equalsIdentifiers(str, expression1.getAlias())) {
/*  807 */               k = m;
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/*  812 */         if (k < 0) {
/*  813 */           m = this.expressions.size();
/*  814 */           this.groupIndex[b] = m;
/*  815 */           this.expressions.add(expression);
/*      */         } else {
/*  817 */           this.groupIndex[b] = k;
/*      */         } 
/*      */       } 
/*  820 */       this.groupByExpression = new boolean[this.expressions.size()];
/*  821 */       for (int k : this.groupIndex) {
/*  822 */         this.groupByExpression[k] = true;
/*      */       }
/*  824 */       this.group = null;
/*      */     } 
/*      */     
/*  827 */     for (TableFilter tableFilter : this.filters) {
/*  828 */       mapColumns((ColumnResolver)tableFilter, 0);
/*      */     }
/*  830 */     if (this.havingIndex >= 0) {
/*  831 */       Expression expression = this.expressions.get(this.havingIndex);
/*  832 */       SelectListColumnResolver selectListColumnResolver = new SelectListColumnResolver(this);
/*  833 */       expression.mapColumns(selectListColumnResolver, 0);
/*      */     } 
/*  835 */     this.checkInit = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void prepare() {
/*  840 */     if (this.isPrepared) {
/*      */       return;
/*      */     }
/*      */     
/*  844 */     if (SysProperties.CHECK && !this.checkInit) {
/*  845 */       DbException.throwInternalError("not initialized");
/*      */     }
/*  847 */     if (this.orderList != null) {
/*  848 */       this.sort = prepareOrder(this.orderList, this.expressions.size());
/*  849 */       this.orderList = null;
/*      */     } 
/*  851 */     for (byte b = 0; b < this.expressions.size(); b++) {
/*  852 */       Expression expression = this.expressions.get(b);
/*  853 */       this.expressions.set(b, expression.optimize(this.session));
/*      */     } 
/*  855 */     if (this.condition != null) {
/*  856 */       this.condition = this.condition.optimize(this.session);
/*  857 */       for (TableFilter tableFilter : this.filters) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  865 */         if (!tableFilter.isJoinOuter() && !tableFilter.isJoinOuterIndirect()) {
/*  866 */           this.condition.createIndexConditions(this.session, tableFilter);
/*      */         }
/*      */       } 
/*      */     } 
/*  870 */     if (this.isGroupQuery && this.groupIndex == null && this.havingIndex < 0 && this.filters.size() == 1)
/*      */     {
/*  872 */       if (this.condition == null) {
/*  873 */         Table table = ((TableFilter)this.filters.get(0)).getTable();
/*  874 */         ExpressionVisitor expressionVisitor = ExpressionVisitor.getOptimizableVisitor(table);
/*      */         
/*  876 */         this.isQuickAggregateQuery = isEverything(expressionVisitor);
/*      */       } 
/*      */     }
/*  879 */     this.cost = preparePlan(this.session.isParsingView());
/*  880 */     if (this.distinct && (this.session.getDatabase().getSettings()).optimizeDistinct && !this.isGroupQuery && this.filters.size() == 1 && this.expressions.size() == 1 && this.condition == null) {
/*      */ 
/*      */       
/*  883 */       Expression expression = this.expressions.get(0);
/*  884 */       expression = expression.getNonAliasExpression();
/*  885 */       if (expression instanceof ExpressionColumn) {
/*  886 */         Column column = ((ExpressionColumn)expression).getColumn();
/*  887 */         int i = column.getSelectivity();
/*  888 */         Index index = this.topTableFilter.getTable().getIndexForColumn(column);
/*      */         
/*  890 */         if (index != null && i != 50 && i < 20) {
/*      */ 
/*      */ 
/*      */           
/*  894 */           boolean bool = ((index.getIndexColumns()[0]).sortType == 0) ? true : false;
/*      */           
/*  896 */           Index index1 = this.topTableFilter.getIndex();
/*      */           
/*  898 */           if (index.canFindNext() && bool && (index1 == null || index1.getIndexType().isScan() || index == index1)) {
/*      */ 
/*      */ 
/*      */             
/*  902 */             IndexType indexType = index.getIndexType();
/*      */ 
/*      */             
/*  905 */             if (!indexType.isHash() && (!indexType.isUnique() || (index.getColumns()).length > 1)) {
/*      */               
/*  907 */               this.topTableFilter.setIndex(index);
/*  908 */               this.isDistinctQuery = true;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  914 */     if (this.sort != null && !this.isQuickAggregateQuery && !this.isGroupQuery) {
/*  915 */       Index index1 = getSortIndex();
/*  916 */       Index index2 = this.topTableFilter.getIndex();
/*  917 */       if (index1 != null && index2 != null) {
/*  918 */         if (index2.getIndexType().isScan() || index2 == index1) {
/*  919 */           this.topTableFilter.setIndex(index1);
/*  920 */           if (!this.topTableFilter.hasInComparisons())
/*      */           {
/*      */             
/*  923 */             this.sortUsingIndex = true;
/*      */           }
/*  925 */         } else if ((index1.getIndexColumns()).length >= (index2.getIndexColumns()).length) {
/*      */           
/*  927 */           IndexColumn[] arrayOfIndexColumn1 = index1.getIndexColumns();
/*  928 */           IndexColumn[] arrayOfIndexColumn2 = index2.getIndexColumns();
/*  929 */           boolean bool = false;
/*  930 */           for (byte b1 = 0; b1 < arrayOfIndexColumn2.length; b1++) {
/*  931 */             if ((arrayOfIndexColumn1[b1]).column != (arrayOfIndexColumn2[b1]).column) {
/*  932 */               bool = false;
/*      */               break;
/*      */             } 
/*  935 */             if ((arrayOfIndexColumn1[b1]).sortType != (arrayOfIndexColumn2[b1]).sortType) {
/*  936 */               bool = true;
/*      */             }
/*      */           } 
/*  939 */           if (bool) {
/*  940 */             this.topTableFilter.setIndex(index1);
/*  941 */             this.sortUsingIndex = true;
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*  946 */     if (!this.isQuickAggregateQuery && this.isGroupQuery && getGroupByExpressionCount() > 0) {
/*      */       
/*  948 */       Index index1 = getGroupSortedIndex();
/*  949 */       Index index2 = this.topTableFilter.getIndex();
/*  950 */       if (index1 != null && index2 != null && (index2.getIndexType().isScan() || index2 == index1)) {
/*      */         
/*  952 */         this.topTableFilter.setIndex(index1);
/*  953 */         this.isGroupSortedQuery = true;
/*      */       } 
/*      */     } 
/*  956 */     this.expressionArray = new Expression[this.expressions.size()];
/*  957 */     this.expressions.toArray(this.expressionArray);
/*  958 */     this.isPrepared = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void prepareJoinBatch() {
/*  963 */     ArrayList<TableFilter> arrayList = New.arrayList();
/*  964 */     TableFilter tableFilter = getTopTableFilter();
/*      */     while (true) {
/*  966 */       if (tableFilter.getNestedJoin() != null) {
/*      */         return;
/*      */       }
/*      */       
/*  970 */       arrayList.add(tableFilter);
/*  971 */       tableFilter = tableFilter.getJoin();
/*  972 */       if (tableFilter == null) {
/*  973 */         TableFilter[] arrayOfTableFilter = arrayList.<TableFilter>toArray(new TableFilter[arrayList.size()]);
/*      */         
/*  975 */         JoinBatch joinBatch = null;
/*  976 */         for (int i = arrayOfTableFilter.length - 1; i >= 0; i--)
/*  977 */           joinBatch = arrayOfTableFilter[i].prepareJoinBatch(joinBatch, arrayOfTableFilter, i); 
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   } public JoinBatch getJoinBatch() {
/*  982 */     return getTopTableFilter().getJoinBatch();
/*      */   }
/*      */ 
/*      */   
/*      */   public double getCost() {
/*  987 */     return this.cost;
/*      */   }
/*      */ 
/*      */   
/*      */   public HashSet<Table> getTables() {
/*  992 */     HashSet<Table> hashSet = New.hashSet();
/*  993 */     for (TableFilter tableFilter : this.filters) {
/*  994 */       hashSet.add(tableFilter.getTable());
/*      */     }
/*  996 */     return hashSet;
/*      */   }
/*      */   public void fireBeforeSelectTriggers() {
/*      */     byte b;
/*      */     int i;
/* 1001 */     for (b = 0, i = this.filters.size(); b < i; b++) {
/* 1002 */       TableFilter tableFilter = this.filters.get(b);
/* 1003 */       tableFilter.getTable().fire(this.session, 8, true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private double preparePlan(boolean paramBoolean) {
/* 1008 */     TableFilter[] arrayOfTableFilter = this.topFilters.<TableFilter>toArray(new TableFilter[this.topFilters.size()]);
/*      */     
/* 1010 */     for (TableFilter tableFilter : arrayOfTableFilter) {
/* 1011 */       tableFilter.setFullCondition(this.condition);
/*      */     }
/*      */     
/* 1014 */     Optimizer optimizer = new Optimizer(arrayOfTableFilter, this.condition, this.session);
/* 1015 */     optimizer.optimize(paramBoolean);
/* 1016 */     this.topTableFilter = optimizer.getTopFilter();
/* 1017 */     double d = optimizer.getCost();
/*      */     
/* 1019 */     setEvaluatableRecursive(this.topTableFilter);
/*      */     
/* 1021 */     if (!paramBoolean) {
/* 1022 */       this.topTableFilter.prepare();
/*      */     }
/* 1024 */     return d;
/*      */   }
/*      */   
/*      */   private void setEvaluatableRecursive(TableFilter paramTableFilter) {
/* 1028 */     for (; paramTableFilter != null; paramTableFilter = paramTableFilter.getJoin()) {
/* 1029 */       paramTableFilter.setEvaluatable(paramTableFilter, true);
/* 1030 */       if (this.condition != null) {
/* 1031 */         this.condition.setEvaluatable(paramTableFilter, true);
/*      */       }
/* 1033 */       TableFilter tableFilter = paramTableFilter.getNestedJoin();
/* 1034 */       if (tableFilter != null) {
/* 1035 */         setEvaluatableRecursive(tableFilter);
/*      */       }
/* 1037 */       Expression expression = paramTableFilter.getJoinCondition();
/* 1038 */       if (expression != null && 
/* 1039 */         !expression.isEverything(ExpressionVisitor.EVALUATABLE_VISITOR)) {
/* 1040 */         if ((this.session.getDatabase().getSettings()).nestedJoins) {
/*      */           
/* 1042 */           expression = expression.optimize(this.session);
/* 1043 */           if (!paramTableFilter.isJoinOuter() && !paramTableFilter.isJoinOuterIndirect()) {
/* 1044 */             paramTableFilter.removeJoinCondition();
/* 1045 */             addCondition(expression);
/*      */           } 
/*      */         } else {
/* 1048 */           if (paramTableFilter.isJoinOuter()) {
/*      */ 
/*      */             
/* 1051 */             expression = expression.optimize(this.session);
/*      */             
/* 1053 */             throw DbException.get(90136, expression.getSQL());
/*      */           } 
/*      */ 
/*      */           
/* 1057 */           paramTableFilter.removeJoinCondition();
/*      */           
/* 1059 */           expression = expression.optimize(this.session);
/* 1060 */           addCondition(expression);
/*      */         } 
/*      */       }
/*      */       
/* 1064 */       expression = paramTableFilter.getFilterCondition();
/* 1065 */       if (expression != null && 
/* 1066 */         !expression.isEverything(ExpressionVisitor.EVALUATABLE_VISITOR)) {
/* 1067 */         paramTableFilter.removeFilterCondition();
/* 1068 */         addCondition(expression);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1073 */       for (Expression expression1 : this.expressions) {
/* 1074 */         expression1.setEvaluatable(paramTableFilter, true);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPlanSQL() {
/* 1084 */     Expression[] arrayOfExpression = this.expressions.<Expression>toArray(new Expression[this.expressions.size()]);
/*      */     
/* 1086 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 1087 */     for (TableFilter tableFilter1 : this.topFilters) {
/* 1088 */       Table table = tableFilter1.getTable();
/* 1089 */       if (table.isView() && ((TableView)table).isRecursive()) {
/* 1090 */         statementBuilder.append("WITH RECURSIVE ").append(table.getName()).append('(');
/* 1091 */         statementBuilder.resetCount();
/* 1092 */         for (Column column : table.getColumns()) {
/* 1093 */           statementBuilder.appendExceptFirst(",");
/* 1094 */           statementBuilder.append(column.getName());
/*      */         } 
/* 1096 */         statementBuilder.append(") AS ").append(table.getSQL()).append("\n");
/*      */       } 
/*      */     } 
/* 1099 */     statementBuilder.resetCount();
/* 1100 */     statementBuilder.append("SELECT");
/* 1101 */     if (this.distinct) {
/* 1102 */       statementBuilder.append(" DISTINCT");
/*      */     }
/* 1104 */     for (byte b = 0; b < this.visibleColumnCount; b++) {
/* 1105 */       statementBuilder.appendExceptFirst(",");
/* 1106 */       statementBuilder.append('\n');
/* 1107 */       statementBuilder.append(StringUtils.indent(arrayOfExpression[b].getSQL(), 4, false));
/*      */     } 
/* 1109 */     statementBuilder.append("\nFROM ");
/* 1110 */     TableFilter tableFilter = this.topTableFilter;
/* 1111 */     if (tableFilter != null) {
/* 1112 */       statementBuilder.resetCount();
/* 1113 */       byte b1 = 0;
/*      */       do {
/* 1115 */         statementBuilder.appendExceptFirst("\n");
/* 1116 */         statementBuilder.append(tableFilter.getPlanSQL((b1++ > 0)));
/* 1117 */         tableFilter = tableFilter.getJoin();
/* 1118 */       } while (tableFilter != null);
/*      */     } else {
/* 1120 */       statementBuilder.resetCount();
/* 1121 */       byte b1 = 0;
/* 1122 */       label92: for (TableFilter tableFilter1 : this.topFilters) {
/*      */         while (true)
/* 1124 */         { statementBuilder.appendExceptFirst("\n");
/* 1125 */           statementBuilder.append(tableFilter1.getPlanSQL((b1++ > 0)));
/* 1126 */           tableFilter1 = tableFilter1.getJoin();
/* 1127 */           if (tableFilter1 == null)
/*      */             continue label92;  } 
/*      */       } 
/* 1130 */     }  if (this.condition != null) {
/* 1131 */       statementBuilder.append("\nWHERE ").append(StringUtils.unEnclose(this.condition.getSQL()));
/*      */     }
/*      */     
/* 1134 */     if (this.groupIndex != null) {
/* 1135 */       statementBuilder.append("\nGROUP BY ");
/* 1136 */       statementBuilder.resetCount();
/* 1137 */       for (int i : this.groupIndex) {
/* 1138 */         Expression expression = arrayOfExpression[i];
/* 1139 */         expression = expression.getNonAliasExpression();
/* 1140 */         statementBuilder.appendExceptFirst(", ");
/* 1141 */         statementBuilder.append(StringUtils.unEnclose(expression.getSQL()));
/*      */       } 
/*      */     } 
/* 1144 */     if (this.group != null) {
/* 1145 */       statementBuilder.append("\nGROUP BY ");
/* 1146 */       statementBuilder.resetCount();
/* 1147 */       for (Expression expression : this.group) {
/* 1148 */         statementBuilder.appendExceptFirst(", ");
/* 1149 */         statementBuilder.append(StringUtils.unEnclose(expression.getSQL()));
/*      */       } 
/*      */     } 
/* 1152 */     if (this.having != null) {
/*      */ 
/*      */ 
/*      */       
/* 1156 */       Expression expression = this.having;
/* 1157 */       statementBuilder.append("\nHAVING ").append(StringUtils.unEnclose(expression.getSQL()));
/*      */     }
/* 1159 */     else if (this.havingIndex >= 0) {
/* 1160 */       Expression expression = arrayOfExpression[this.havingIndex];
/* 1161 */       statementBuilder.append("\nHAVING ").append(StringUtils.unEnclose(expression.getSQL()));
/*      */     } 
/*      */     
/* 1164 */     if (this.sort != null) {
/* 1165 */       statementBuilder.append("\nORDER BY ").append(this.sort.getSQL(arrayOfExpression, this.visibleColumnCount));
/*      */     }
/*      */     
/* 1168 */     if (this.orderList != null) {
/* 1169 */       statementBuilder.append("\nORDER BY ");
/* 1170 */       statementBuilder.resetCount();
/* 1171 */       for (SelectOrderBy selectOrderBy : this.orderList) {
/* 1172 */         statementBuilder.appendExceptFirst(", ");
/* 1173 */         statementBuilder.append(StringUtils.unEnclose(selectOrderBy.getSQL()));
/*      */       } 
/*      */     } 
/* 1176 */     if (this.limitExpr != null) {
/* 1177 */       statementBuilder.append("\nLIMIT ").append(StringUtils.unEnclose(this.limitExpr.getSQL()));
/*      */       
/* 1179 */       if (this.offsetExpr != null) {
/* 1180 */         statementBuilder.append(" OFFSET ").append(StringUtils.unEnclose(this.offsetExpr.getSQL()));
/*      */       }
/*      */     } 
/*      */     
/* 1184 */     if (this.sampleSizeExpr != null) {
/* 1185 */       statementBuilder.append("\nSAMPLE_SIZE ").append(StringUtils.unEnclose(this.sampleSizeExpr.getSQL()));
/*      */     }
/*      */     
/* 1188 */     if (this.isForUpdate) {
/* 1189 */       statementBuilder.append("\nFOR UPDATE");
/*      */     }
/* 1191 */     if (this.isQuickAggregateQuery) {
/* 1192 */       statementBuilder.append("\n/* direct lookup */");
/*      */     }
/* 1194 */     if (this.isDistinctQuery) {
/* 1195 */       statementBuilder.append("\n/* distinct */");
/*      */     }
/* 1197 */     if (this.sortUsingIndex) {
/* 1198 */       statementBuilder.append("\n/* index sorted */");
/*      */     }
/* 1200 */     if (this.isGroupQuery && 
/* 1201 */       this.isGroupSortedQuery) {
/* 1202 */       statementBuilder.append("\n/* group sorted */");
/*      */     }
/*      */ 
/*      */     
/* 1206 */     return statementBuilder.toString();
/*      */   }
/*      */   
/*      */   public void setHaving(Expression paramExpression) {
/* 1210 */     this.having = paramExpression;
/*      */   }
/*      */   
/*      */   public Expression getHaving() {
/* 1214 */     return this.having;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getColumnCount() {
/* 1219 */     return this.visibleColumnCount;
/*      */   }
/*      */   
/*      */   public TableFilter getTopTableFilter() {
/* 1223 */     return this.topTableFilter;
/*      */   }
/*      */ 
/*      */   
/*      */   public ArrayList<Expression> getExpressions() {
/* 1228 */     return this.expressions;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setForUpdate(boolean paramBoolean) {
/* 1233 */     this.isForUpdate = paramBoolean;
/* 1234 */     if ((this.session.getDatabase().getSettings()).selectForUpdateMvcc && this.session.getDatabase().isMultiVersion())
/*      */     {
/* 1236 */       this.isForUpdateMvcc = paramBoolean;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 1242 */     for (Expression expression : this.expressions) {
/* 1243 */       expression.mapColumns(paramColumnResolver, paramInt);
/*      */     }
/* 1245 */     if (this.condition != null) {
/* 1246 */       this.condition.mapColumns(paramColumnResolver, paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 1252 */     for (Expression expression : this.expressions) {
/* 1253 */       expression.setEvaluatable(paramTableFilter, paramBoolean);
/*      */     }
/* 1255 */     if (this.condition != null) {
/* 1256 */       this.condition.setEvaluatable(paramTableFilter, paramBoolean);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isQuickAggregateQuery() {
/* 1268 */     return this.isQuickAggregateQuery;
/*      */   }
/*      */ 
/*      */   
/*      */   public void addGlobalCondition(Parameter paramParameter, int paramInt1, int paramInt2) {
/*      */     Comparison comparison;
/* 1274 */     addParameter(paramParameter);
/*      */     
/* 1276 */     Expression expression2 = this.expressions.get(paramInt1);
/* 1277 */     expression2 = expression2.getNonAliasExpression();
/* 1278 */     if (expression2.isEverything(ExpressionVisitor.QUERY_COMPARABLE_VISITOR)) {
/* 1279 */       comparison = new Comparison(this.session, paramInt2, expression2, (Expression)paramParameter);
/*      */     }
/*      */     else {
/*      */       
/* 1283 */       comparison = new Comparison(this.session, 16, (Expression)paramParameter, (Expression)paramParameter);
/*      */     } 
/* 1285 */     Expression expression1 = comparison.optimize(this.session);
/* 1286 */     boolean bool = true;
/* 1287 */     if (this.isGroupQuery) {
/* 1288 */       bool = false;
/* 1289 */       for (byte b = 0; this.groupIndex != null && b < this.groupIndex.length; b++) {
/* 1290 */         if (this.groupIndex[b] == paramInt1) {
/* 1291 */           bool = true;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1295 */       if (!bool) {
/* 1296 */         if (this.havingIndex >= 0) {
/* 1297 */           this.having = this.expressions.get(this.havingIndex);
/*      */         }
/* 1299 */         if (this.having == null) {
/* 1300 */           this.having = expression1;
/*      */         } else {
/* 1302 */           this.having = (Expression)new ConditionAndOr(0, this.having, expression1);
/*      */         } 
/*      */       } 
/*      */     } 
/* 1306 */     if (bool) {
/* 1307 */       if (this.condition == null) {
/* 1308 */         this.condition = expression1;
/*      */       } else {
/* 1310 */         this.condition = (Expression)new ConditionAndOr(0, this.condition, expression1);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateAggregate(Session paramSession) {
/* 1317 */     for (Expression expression : this.expressions) {
/* 1318 */       expression.updateAggregate(paramSession);
/*      */     }
/* 1320 */     if (this.condition != null) {
/* 1321 */       this.condition.updateAggregate(paramSession);
/*      */     }
/* 1323 */     if (this.having != null) {
/* 1324 */       this.having.updateAggregate(paramSession);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/*      */     byte b1;
/* 1330 */     switch (paramExpressionVisitor.getType()) {
/*      */       case 2:
/* 1332 */         if (this.isForUpdate) {
/* 1333 */           return false;
/*      */         }
/* 1335 */         for (b1 = 0, i = this.filters.size(); b1 < i; b1++) {
/* 1336 */           TableFilter tableFilter = this.filters.get(b1);
/* 1337 */           if (!tableFilter.getTable().isDeterministic()) {
/* 1338 */             return false;
/*      */           }
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 4:
/* 1344 */         for (b1 = 0, i = this.filters.size(); b1 < i; b1++) {
/* 1345 */           TableFilter tableFilter = this.filters.get(b1);
/* 1346 */           long l = tableFilter.getTable().getMaxDataModificationId();
/* 1347 */           paramExpressionVisitor.addDataModificationId(l);
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 3:
/* 1352 */         if (!(this.session.getDatabase().getSettings()).optimizeEvaluatableSubqueries) {
/* 1353 */           return false;
/*      */         }
/*      */         break;
/*      */       
/*      */       case 7:
/* 1358 */         for (b1 = 0, i = this.filters.size(); b1 < i; b1++) {
/* 1359 */           TableFilter tableFilter = this.filters.get(b1);
/* 1360 */           Table table = tableFilter.getTable();
/* 1361 */           paramExpressionVisitor.addDependency((DbObject)table);
/* 1362 */           table.addDependencies(paramExpressionVisitor.getDependencies());
/*      */         } 
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/* 1368 */     ExpressionVisitor expressionVisitor = paramExpressionVisitor.incrementQueryLevel(1);
/* 1369 */     int i = 1; byte b2; int j;
/* 1370 */     for (b2 = 0, j = this.expressions.size(); b2 < j; b2++) {
/* 1371 */       Expression expression = this.expressions.get(b2);
/* 1372 */       if (!expression.isEverything(expressionVisitor)) {
/* 1373 */         i = 0;
/*      */         break;
/*      */       } 
/*      */     } 
/* 1377 */     if (i != 0 && this.condition != null && !this.condition.isEverything(expressionVisitor)) {
/* 1378 */       i = 0;
/*      */     }
/* 1380 */     if (i != 0 && this.having != null && !this.having.isEverything(expressionVisitor)) {
/* 1381 */       i = 0;
/*      */     }
/* 1383 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isReadOnly() {
/* 1388 */     return isEverything(ExpressionVisitor.READONLY_VISITOR);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isCacheable() {
/* 1394 */     return !this.isForUpdate;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getType() {
/* 1399 */     return 66;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean allowGlobalConditions() {
/* 1404 */     if (this.offsetExpr == null && (this.limitExpr == null || this.sort == null)) {
/* 1405 */       return true;
/*      */     }
/* 1407 */     return false;
/*      */   }
/*      */   
/*      */   public SortOrder getSortOrder() {
/* 1411 */     return this.sort;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\Select.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */