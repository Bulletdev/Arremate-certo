/*      */ package org.h2.table;
/*      */ 
/*      */ import java.util.AbstractList;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.concurrent.Future;
/*      */ import org.h2.command.dml.Query;
/*      */ import org.h2.command.dml.Select;
/*      */ import org.h2.command.dml.SelectUnion;
/*      */ import org.h2.index.Cursor;
/*      */ import org.h2.index.IndexCursor;
/*      */ import org.h2.index.IndexLookupBatch;
/*      */ import org.h2.index.ViewCursor;
/*      */ import org.h2.index.ViewIndex;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.result.LocalResult;
/*      */ import org.h2.result.Row;
/*      */ import org.h2.result.SearchRow;
/*      */ import org.h2.util.DoneFuture;
/*      */ import org.h2.util.LazyFuture;
/*      */ import org.h2.util.New;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueLong;
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
/*      */ public final class JoinBatch
/*      */ {
/*   45 */   static final Cursor EMPTY_CURSOR = new Cursor()
/*      */     {
/*      */       public boolean previous() {
/*   48 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean next() {
/*   53 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public SearchRow getSearchRow() {
/*   58 */         return null;
/*      */       }
/*      */ 
/*      */       
/*      */       public Row get() {
/*   63 */         return null;
/*      */       }
/*      */ 
/*      */       
/*      */       public String toString() {
/*   68 */         return "EMPTY_CURSOR";
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   75 */   static final Future<Cursor> EMPTY_FUTURE_CURSOR = (Future<Cursor>)new DoneFuture(EMPTY_CURSOR);
/*      */ 
/*      */ 
/*      */   
/*      */   Future<Cursor> viewTopFutureCursor;
/*      */ 
/*      */ 
/*      */   
/*      */   JoinFilter top;
/*      */ 
/*      */ 
/*      */   
/*      */   JoinFilter[] filters;
/*      */ 
/*      */ 
/*      */   
/*      */   boolean batchedSubQuery;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean started;
/*      */ 
/*      */ 
/*      */   
/*      */   private JoinRow current;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean found;
/*      */ 
/*      */ 
/*      */   
/*      */   private final TableFilter additionalFilter;
/*      */ 
/*      */ 
/*      */   
/*      */   public JoinBatch(int paramInt, TableFilter paramTableFilter) {
/*  112 */     if (paramInt > 32)
/*      */     {
/*      */       
/*  115 */       throw DbException.getUnsupportedException("Too many tables in join (at most 32 supported).");
/*      */     }
/*      */     
/*  118 */     this.filters = new JoinFilter[paramInt];
/*  119 */     this.additionalFilter = paramTableFilter;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IndexLookupBatch getLookupBatch(int paramInt) {
/*  129 */     return (this.filters[paramInt]).lookupBatch;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void reset(boolean paramBoolean) {
/*  139 */     this.current = null;
/*  140 */     this.started = false;
/*  141 */     this.found = false;
/*  142 */     for (JoinFilter joinFilter : this.filters) {
/*  143 */       joinFilter.reset(paramBoolean);
/*      */     }
/*  145 */     if (paramBoolean && this.additionalFilter != null) {
/*  146 */       this.additionalFilter.reset();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void register(TableFilter paramTableFilter, IndexLookupBatch paramIndexLookupBatch) {
/*  157 */     assert paramTableFilter != null;
/*  158 */     this.top = new JoinFilter(paramIndexLookupBatch, paramTableFilter, this.top);
/*  159 */     this.filters[this.top.id] = this.top;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value getValue(int paramInt, Column paramColumn) {
/*  170 */     Object object = this.current.row(paramInt);
/*  171 */     assert object != null;
/*  172 */     Row row = this.current.isRow(paramInt) ? (Row)object : ((Cursor)object).get();
/*  173 */     int i = paramColumn.getColumnId();
/*  174 */     if (i == -1) {
/*  175 */       return (Value)ValueLong.get(row.getKey());
/*      */     }
/*  177 */     Value value = row.getValue(paramColumn.getColumnId());
/*  178 */     if (value == null) {
/*  179 */       throw DbException.throwInternalError("value is null: " + paramColumn + " " + row);
/*      */     }
/*  181 */     return value;
/*      */   }
/*      */   
/*      */   private void start() {
/*      */     IndexCursor indexCursor;
/*  186 */     this.current = new JoinRow(new Object[this.filters.length]);
/*      */ 
/*      */     
/*  189 */     if (this.batchedSubQuery) {
/*  190 */       assert this.viewTopFutureCursor != null;
/*  191 */       Cursor cursor = get(this.viewTopFutureCursor);
/*      */     } else {
/*      */       
/*  194 */       TableFilter tableFilter = this.top.filter;
/*  195 */       IndexCursor indexCursor1 = tableFilter.getIndexCursor();
/*  196 */       indexCursor1.find(tableFilter.getSession(), tableFilter.getIndexConditions());
/*  197 */       indexCursor = indexCursor1;
/*      */     } 
/*  199 */     this.current.updateRow(this.top.id, indexCursor, 0L, 2L);
/*      */ 
/*      */     
/*  202 */     JoinRow joinRow = new JoinRow(null);
/*  203 */     joinRow.next = this.current;
/*  204 */     this.current = joinRow;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean next() {
/*  213 */     if (!this.started) {
/*  214 */       start();
/*  215 */       this.started = true;
/*      */     } 
/*  217 */     if (this.additionalFilter == null) {
/*  218 */       if (batchedNext()) {
/*  219 */         assert this.current.isComplete();
/*  220 */         return true;
/*      */       } 
/*  222 */       return false;
/*      */     } 
/*      */     while (true) {
/*  225 */       if (!this.found) {
/*  226 */         if (!batchedNext()) {
/*  227 */           return false;
/*      */         }
/*  229 */         assert this.current.isComplete();
/*  230 */         this.found = true;
/*  231 */         this.additionalFilter.reset();
/*      */       } 
/*      */ 
/*      */       
/*  235 */       if (this.additionalFilter.next()) {
/*  236 */         return true;
/*      */       }
/*  238 */       this.found = false;
/*      */     } 
/*      */   }
/*      */   
/*      */   private static Cursor get(Future<Cursor> paramFuture) {
/*      */     Cursor cursor;
/*      */     try {
/*  245 */       cursor = paramFuture.get();
/*  246 */     } catch (Exception exception) {
/*  247 */       throw DbException.convert(exception);
/*      */     } 
/*  249 */     return (cursor == null) ? EMPTY_CURSOR : cursor;
/*      */   }
/*      */   
/*      */   private boolean batchedNext() {
/*  253 */     if (this.current == null)
/*      */     {
/*  255 */       return false;
/*      */     }
/*      */     
/*  258 */     this.current = this.current.next;
/*  259 */     if (this.current == null) {
/*  260 */       return false;
/*      */     }
/*  262 */     this.current.prev = null;
/*      */     
/*  264 */     int i = this.filters.length - 1;
/*      */     
/*  266 */     int j = i;
/*  267 */     while (this.current.row(j) == null)
/*      */     {
/*  269 */       j--;
/*      */     }
/*      */     
/*      */     while (true) {
/*  273 */       fetchCurrent(j);
/*      */       
/*  275 */       if (!this.current.isDropped()) {
/*      */ 
/*      */         
/*  278 */         if (j == i)
/*      */         {
/*  280 */           return true;
/*      */         }
/*  282 */         JoinFilter joinFilter = this.filters[j + 1];
/*  283 */         if (joinFilter.isBatchFull())
/*      */         {
/*  285 */           this.current = joinFilter.find(this.current);
/*      */         }
/*  287 */         if (this.current.row(joinFilter.id) != null) {
/*      */           
/*  289 */           j = joinFilter.id;
/*      */           
/*      */           continue;
/*      */         } 
/*      */       } 
/*      */       
/*  295 */       if (this.current.next == null) {
/*      */         
/*  297 */         if (this.current.isDropped()) {
/*  298 */           this.current = this.current.prev;
/*  299 */           if (this.current == null) {
/*  300 */             return false;
/*      */           }
/*      */         } 
/*  303 */         assert !this.current.isDropped();
/*  304 */         assert j != i;
/*      */         
/*  306 */         j = 0;
/*  307 */         while (this.current.row(j) != null) {
/*  308 */           j++;
/*      */         }
/*      */ 
/*      */         
/*  312 */         this.current = this.filters[j].find(this.current);
/*      */         continue;
/*      */       } 
/*  315 */       this.current = this.current.next;
/*  316 */       assert !this.current.isRow(j);
/*  317 */       while (this.current.row(j) == null) {
/*  318 */         assert j != this.top.id;
/*      */         
/*  320 */         j--;
/*  321 */         assert !this.current.isRow(j);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchCurrent(int paramInt) {
/*      */     boolean bool2;
/*  329 */     assert this.current.prev == null || this.current.prev.isRow(paramInt) : "prev must be already fetched";
/*  330 */     assert paramInt == 0 || this.current.isRow(paramInt - 1) : "left must be already fetched";
/*      */     
/*  332 */     assert !this.current.isRow(paramInt) : "double fetching";
/*      */     
/*  334 */     Object object = this.current.row(paramInt);
/*  335 */     assert object != null : "x null";
/*      */ 
/*      */     
/*  338 */     boolean bool1 = (object == EMPTY_CURSOR) ? true : false;
/*      */     
/*  340 */     if (bool1) {
/*  341 */       if (paramInt == 0) {
/*      */ 
/*      */         
/*  344 */         this.current.drop();
/*      */         return;
/*      */       } 
/*  347 */     } else if (this.current.isFuture(paramInt)) {
/*      */       
/*  349 */       object = get((Future<Cursor>)object);
/*  350 */       this.current.updateRow(paramInt, object, 1L, 2L);
/*  351 */       bool1 = true;
/*      */     } 
/*      */     
/*  354 */     JoinFilter joinFilter1 = this.filters[paramInt];
/*  355 */     Cursor cursor = (Cursor)object;
/*  356 */     assert cursor != null;
/*  357 */     JoinFilter joinFilter2 = joinFilter1.join;
/*      */     
/*      */     while (true) {
/*  360 */       if (cursor == null || !cursor.next()) {
/*  361 */         if (bool1 && joinFilter1.isOuterJoin()) {
/*      */           
/*  363 */           this.current.updateRow(paramInt, joinFilter1.getNullRow(), 2L, 3L);
/*  364 */           cursor = null;
/*  365 */           bool1 = false;
/*      */         } else {
/*      */           
/*  368 */           this.current.drop();
/*      */           return;
/*      */         } 
/*      */       }
/*  372 */       if (!joinFilter1.isOk((cursor == null))) {
/*      */         continue;
/*      */       }
/*      */       
/*  376 */       bool2 = false;
/*  377 */       if (joinFilter2 != null && !joinFilter2.collectSearchRows()) {
/*  378 */         if (joinFilter2.isOuterJoin()) {
/*  379 */           bool2 = true; break;
/*      */         } 
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/*  385 */     if (cursor != null) {
/*  386 */       this.current = this.current.copyBehind(paramInt);
/*      */       
/*  388 */       this.current.updateRow(paramInt, cursor.get(), 2L, 3L);
/*      */     } 
/*  390 */     if (bool2)
/*      */     {
/*  392 */       this.current.updateRow(joinFilter2.id, EMPTY_CURSOR, 0L, 2L);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private IndexLookupBatch viewIndexLookupBatch(ViewIndex paramViewIndex) {
/*  402 */     return new ViewIndexLookupBatch(paramViewIndex);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static IndexLookupBatch createViewIndexLookupBatch(ViewIndex paramViewIndex) {
/*  413 */     Query query = paramViewIndex.getQuery();
/*  414 */     if (query.isUnion()) {
/*  415 */       ViewIndexLookupBatchUnion viewIndexLookupBatchUnion = new ViewIndexLookupBatchUnion(paramViewIndex);
/*  416 */       return viewIndexLookupBatchUnion.initialize() ? viewIndexLookupBatchUnion : null;
/*      */     } 
/*  418 */     JoinBatch joinBatch = ((Select)query).getJoinBatch();
/*  419 */     if (joinBatch == null || joinBatch.getLookupBatch(0) == null)
/*      */     {
/*  421 */       return null;
/*      */     }
/*  423 */     assert !joinBatch.batchedSubQuery;
/*  424 */     joinBatch.batchedSubQuery = true;
/*  425 */     return joinBatch.viewIndexLookupBatch(paramViewIndex);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static IndexLookupBatch createFakeIndexLookupBatch(TableFilter paramTableFilter) {
/*  435 */     return new FakeLookupBatch(paramTableFilter);
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/*  440 */     return "JoinBatch->\nprev->" + ((this.current == null) ? null : (String)this.current.prev) + "\n" + "curr->" + this.current + "\n" + "next->" + ((this.current == null) ? null : (String)this.current.next);
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class JoinFilter
/*      */   {
/*      */     final IndexLookupBatch lookupBatch;
/*      */     
/*      */     final int id;
/*      */     
/*      */     final JoinFilter join;
/*      */     
/*      */     final TableFilter filter;
/*      */     
/*      */     JoinFilter(IndexLookupBatch param1IndexLookupBatch, TableFilter param1TableFilter, JoinFilter param1JoinFilter) {
/*  455 */       this.filter = param1TableFilter;
/*  456 */       this.id = param1TableFilter.getJoinFilterId();
/*  457 */       this.join = param1JoinFilter;
/*  458 */       this.lookupBatch = param1IndexLookupBatch;
/*  459 */       assert param1IndexLookupBatch != null || this.id == 0;
/*      */     }
/*      */     
/*      */     void reset(boolean param1Boolean) {
/*  463 */       if (this.lookupBatch != null) {
/*  464 */         this.lookupBatch.reset(param1Boolean);
/*      */       }
/*      */     }
/*      */     
/*      */     Row getNullRow() {
/*  469 */       return this.filter.getTable().getNullRow();
/*      */     }
/*      */     
/*      */     boolean isOuterJoin() {
/*  473 */       return this.filter.isJoinOuter();
/*      */     }
/*      */     
/*      */     boolean isBatchFull() {
/*  477 */       return this.lookupBatch.isBatchFull();
/*      */     }
/*      */     
/*      */     boolean isOk(boolean param1Boolean) {
/*  481 */       boolean bool1 = this.filter.isOk(this.filter.getFilterCondition());
/*  482 */       boolean bool2 = this.filter.isOk(this.filter.getJoinCondition());
/*      */       
/*  484 */       return (bool1 && (param1Boolean || bool2));
/*      */     }
/*      */     
/*      */     boolean collectSearchRows() {
/*  488 */       assert !isBatchFull();
/*  489 */       IndexCursor indexCursor = this.filter.getIndexCursor();
/*  490 */       indexCursor.prepare(this.filter.getSession(), this.filter.getIndexConditions());
/*  491 */       if (indexCursor.isAlwaysFalse()) {
/*  492 */         return false;
/*      */       }
/*  494 */       return this.lookupBatch.addSearchRows(indexCursor.getStart(), indexCursor.getEnd());
/*      */     }
/*      */     
/*      */     List<Future<Cursor>> find() {
/*  498 */       return this.lookupBatch.find();
/*      */     }
/*      */     
/*      */     JoinBatch.JoinRow find(JoinBatch.JoinRow param1JoinRow) {
/*  502 */       assert param1JoinRow != null;
/*      */ 
/*      */ 
/*      */       
/*  506 */       List<Future> list = this.lookupBatch.find();
/*      */ 
/*      */       
/*  509 */       for (int i = list.size(); i > 0; ) {
/*  510 */         assert param1JoinRow.isRow(this.id - 1);
/*  511 */         if (param1JoinRow.row(this.id) == JoinBatch.EMPTY_CURSOR) {
/*      */           
/*  513 */           param1JoinRow = param1JoinRow.prev;
/*      */           continue;
/*      */         } 
/*  516 */         assert param1JoinRow.row(this.id) == null;
/*  517 */         Future future = list.get(--i);
/*  518 */         if (future == null) {
/*  519 */           param1JoinRow.updateRow(this.id, JoinBatch.EMPTY_CURSOR, 0L, 2L);
/*      */         } else {
/*  521 */           param1JoinRow.updateRow(this.id, future, 0L, 1L);
/*      */         } 
/*  523 */         if (param1JoinRow.prev == null || i == 0) {
/*      */           break;
/*      */         }
/*  526 */         param1JoinRow = param1JoinRow.prev;
/*      */       } 
/*      */ 
/*      */       
/*  530 */       while (param1JoinRow.prev != null && param1JoinRow.prev.row(this.id) == JoinBatch.EMPTY_CURSOR) {
/*  531 */         param1JoinRow = param1JoinRow.prev;
/*      */       }
/*  533 */       assert param1JoinRow.prev == null || param1JoinRow.prev.isRow(this.id);
/*  534 */       assert param1JoinRow.row(this.id) != null;
/*  535 */       assert !param1JoinRow.isRow(this.id);
/*      */ 
/*      */       
/*  538 */       return param1JoinRow;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  543 */       return "JoinFilter->" + this.filter;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class JoinRow
/*      */   {
/*      */     private static final long S_NULL = 0L;
/*      */ 
/*      */     
/*      */     private static final long S_FUTURE = 1L;
/*      */ 
/*      */     
/*      */     private static final long S_CURSOR = 2L;
/*      */ 
/*      */     
/*      */     private static final long S_ROW = 3L;
/*      */ 
/*      */     
/*      */     private static final long S_MASK = 3L;
/*      */ 
/*      */     
/*      */     JoinRow prev;
/*      */ 
/*      */     
/*      */     JoinRow next;
/*      */ 
/*      */     
/*      */     private Object[] row;
/*      */ 
/*      */     
/*      */     private long state;
/*      */ 
/*      */ 
/*      */     
/*      */     JoinRow(Object[] param1ArrayOfObject) {
/*  581 */       this.row = param1ArrayOfObject;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private long getState(int param1Int) {
/*  589 */       return this.state >>> param1Int << 1 & 0x3L;
/*      */     }
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
/*      */     private void incrementState(int param1Int, long param1Long) {
/*  603 */       assert param1Long > 0L : param1Long;
/*  604 */       this.state += param1Long << param1Int << 1;
/*      */     }
/*      */     
/*      */     void updateRow(int param1Int, Object param1Object, long param1Long1, long param1Long2) {
/*  608 */       assert getState(param1Int) == param1Long1 : "old state: " + getState(param1Int);
/*  609 */       this.row[param1Int] = param1Object;
/*  610 */       incrementState(param1Int, param1Long2 - param1Long1);
/*  611 */       assert getState(param1Int) == param1Long2 : "new state: " + getState(param1Int);
/*      */     }
/*      */     
/*      */     Object row(int param1Int) {
/*  615 */       return this.row[param1Int];
/*      */     }
/*      */     
/*      */     boolean isRow(int param1Int) {
/*  619 */       return (getState(param1Int) == 3L);
/*      */     }
/*      */     
/*      */     boolean isFuture(int param1Int) {
/*  623 */       return (getState(param1Int) == 1L);
/*      */     }
/*      */     
/*      */     private boolean isCursor(int param1Int) {
/*  627 */       return (getState(param1Int) == 2L);
/*      */     }
/*      */     
/*      */     boolean isComplete() {
/*  631 */       return isRow(this.row.length - 1);
/*      */     }
/*      */     
/*      */     boolean isDropped() {
/*  635 */       return (this.row == null);
/*      */     }
/*      */     
/*      */     void drop() {
/*  639 */       if (this.prev != null) {
/*  640 */         this.prev.next = this.next;
/*      */       }
/*  642 */       if (this.next != null) {
/*  643 */         this.next.prev = this.prev;
/*      */       }
/*  645 */       this.row = null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     JoinRow copyBehind(int param1Int) {
/*  656 */       assert isCursor(param1Int);
/*  657 */       assert param1Int + 1 == this.row.length || this.row[param1Int + 1] == null;
/*      */       
/*  659 */       Object[] arrayOfObject = new Object[this.row.length];
/*  660 */       if (param1Int != 0) {
/*  661 */         System.arraycopy(this.row, 0, arrayOfObject, 0, param1Int);
/*      */       }
/*  663 */       JoinRow joinRow = new JoinRow(arrayOfObject);
/*  664 */       joinRow.state = this.state;
/*      */       
/*  666 */       if (this.prev != null) {
/*  667 */         joinRow.prev = this.prev;
/*  668 */         this.prev.next = joinRow;
/*      */       } 
/*  670 */       this.prev = joinRow;
/*  671 */       joinRow.next = this;
/*      */       
/*  673 */       return joinRow;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  678 */       return "JoinRow->" + Arrays.toString(this.row);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class FakeLookupBatch
/*      */     implements IndexLookupBatch
/*      */   {
/*      */     private final TableFilter filter;
/*      */     
/*      */     private SearchRow first;
/*      */     
/*      */     private SearchRow last;
/*      */     
/*      */     private boolean full;
/*      */     
/*  694 */     private final List<Future<Cursor>> result = new JoinBatch.SingletonList<>();
/*      */     
/*      */     FakeLookupBatch(TableFilter param1TableFilter) {
/*  697 */       this.filter = param1TableFilter;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getPlanSQL() {
/*  702 */       return "fake";
/*      */     }
/*      */ 
/*      */     
/*      */     public void reset(boolean param1Boolean) {
/*  707 */       this.full = false;
/*  708 */       this.first = this.last = null;
/*  709 */       this.result.set(0, null);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean addSearchRows(SearchRow param1SearchRow1, SearchRow param1SearchRow2) {
/*  714 */       assert !this.full;
/*  715 */       this.first = param1SearchRow1;
/*  716 */       this.last = param1SearchRow2;
/*  717 */       this.full = true;
/*  718 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isBatchFull() {
/*  723 */       return this.full;
/*      */     }
/*      */ 
/*      */     
/*      */     public List<Future<Cursor>> find() {
/*  728 */       if (!this.full) {
/*  729 */         return Collections.emptyList();
/*      */       }
/*  731 */       Cursor cursor = this.filter.getIndex().find(this.filter, this.first, this.last);
/*  732 */       this.result.set(0, new DoneFuture(cursor));
/*  733 */       this.full = false;
/*  734 */       this.first = this.last = null;
/*  735 */       return this.result;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static final class SingletonList<E>
/*      */     extends AbstractList<E>
/*      */   {
/*      */     private E element;
/*      */ 
/*      */     
/*      */     public E get(int param1Int) {
/*  747 */       assert param1Int == 0;
/*  748 */       return this.element;
/*      */     }
/*      */ 
/*      */     
/*      */     public E set(int param1Int, E param1E) {
/*  753 */       assert param1Int == 0;
/*  754 */       this.element = param1E;
/*  755 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/*  760 */       return 1;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static abstract class ViewIndexLookupBatchBase<R extends QueryRunnerBase>
/*      */     implements IndexLookupBatch
/*      */   {
/*      */     protected final ViewIndex viewIndex;
/*      */     
/*  770 */     private final ArrayList<Future<Cursor>> result = New.arrayList();
/*      */     private int resultSize;
/*      */     private boolean findCalled;
/*      */     
/*      */     protected ViewIndexLookupBatchBase(ViewIndex param1ViewIndex) {
/*  775 */       this.viewIndex = param1ViewIndex;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getPlanSQL() {
/*  780 */       return "view";
/*      */     }
/*      */     
/*      */     protected abstract boolean collectSearchRows(R param1R);
/*      */     
/*      */     protected abstract R newQueryRunner();
/*      */     
/*      */     protected abstract void startQueryRunners(int param1Int);
/*      */     
/*      */     protected final boolean resetAfterFind() {
/*  790 */       if (!this.findCalled) {
/*  791 */         return false;
/*      */       }
/*  793 */       this.findCalled = false;
/*      */ 
/*      */       
/*  796 */       for (byte b = 0; b < this.resultSize; b++) {
/*  797 */         queryRunner(b).reset();
/*      */       }
/*  799 */       this.resultSize = 0;
/*  800 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     protected R queryRunner(int param1Int) {
/*  805 */       return (R)this.result.get(param1Int);
/*      */     }
/*      */     
/*      */     public final boolean addSearchRows(SearchRow param1SearchRow1, SearchRow param1SearchRow2) {
/*      */       R r;
/*  810 */       resetAfterFind();
/*  811 */       this.viewIndex.setupQueryParameters(this.viewIndex.getSession(), param1SearchRow1, param1SearchRow2, null);
/*      */       
/*  813 */       if (this.resultSize < this.result.size()) {
/*      */         
/*  815 */         R r1 = queryRunner(this.resultSize);
/*      */       } else {
/*      */         
/*  818 */         this.result.add((Future<Cursor>)(r = newQueryRunner()));
/*      */       } 
/*  820 */       ((JoinBatch.QueryRunnerBase)r).first = param1SearchRow1;
/*  821 */       ((JoinBatch.QueryRunnerBase)r).last = param1SearchRow2;
/*  822 */       if (!collectSearchRows(r)) {
/*  823 */         r.clear();
/*  824 */         return false;
/*      */       } 
/*  826 */       this.resultSize++;
/*  827 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public void reset(boolean param1Boolean) {
/*  832 */       if (this.resultSize != 0 && !resetAfterFind()) {
/*      */         
/*  834 */         for (byte b = 0; b < this.resultSize; b++) {
/*  835 */           queryRunner(b).clear();
/*      */         }
/*  837 */         this.resultSize = 0;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public final List<Future<Cursor>> find() {
/*  843 */       if (this.resultSize == 0) {
/*  844 */         return Collections.emptyList();
/*      */       }
/*  846 */       this.findCalled = true;
/*  847 */       startQueryRunners(this.resultSize);
/*  848 */       return (this.resultSize == this.result.size()) ? this.result : this.result.subList(0, this.resultSize);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static abstract class QueryRunnerBase
/*      */     extends LazyFuture<Cursor>
/*      */   {
/*      */     protected final ViewIndex viewIndex;
/*      */     protected SearchRow first;
/*      */     protected SearchRow last;
/*      */     
/*      */     public QueryRunnerBase(ViewIndex param1ViewIndex) {
/*  861 */       this.viewIndex = param1ViewIndex;
/*      */     }
/*      */     
/*      */     protected void clear() {
/*  865 */       this.first = this.last = null;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean reset() {
/*  870 */       if (super.reset()) {
/*  871 */         return true;
/*      */       }
/*      */       
/*  874 */       clear();
/*  875 */       return false;
/*      */     }
/*      */     
/*      */     protected final ViewCursor newCursor(LocalResult param1LocalResult) {
/*  879 */       ViewCursor viewCursor = new ViewCursor(this.viewIndex, param1LocalResult, this.first, this.last);
/*  880 */       clear();
/*  881 */       return viewCursor;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private final class ViewIndexLookupBatch
/*      */     extends ViewIndexLookupBatchBase<QueryRunner>
/*      */   {
/*      */     ViewIndexLookupBatch(ViewIndex param1ViewIndex) {
/*  890 */       super(param1ViewIndex);
/*      */     }
/*      */ 
/*      */     
/*      */     protected JoinBatch.QueryRunner newQueryRunner() {
/*  895 */       return new JoinBatch.QueryRunner(this.viewIndex);
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean collectSearchRows(JoinBatch.QueryRunner param1QueryRunner) {
/*  900 */       return JoinBatch.this.top.collectSearchRows();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isBatchFull() {
/*  905 */       return JoinBatch.this.top.isBatchFull();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void startQueryRunners(int param1Int) {
/*  912 */       List<Future<Cursor>> list = JoinBatch.this.top.find();
/*  913 */       if (list.size() != param1Int) {
/*  914 */         throw DbException.throwInternalError("Unexpected result size: " + list.size() + ", expected :" + param1Int);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  919 */       for (byte b = 0; b < param1Int; b++) {
/*  920 */         JoinBatch.QueryRunner queryRunner = queryRunner(b);
/*  921 */         queryRunner.topFutureCursor = list.get(b);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private final class QueryRunner
/*      */     extends QueryRunnerBase
/*      */   {
/*      */     Future<Cursor> topFutureCursor;
/*      */     
/*      */     public QueryRunner(ViewIndex param1ViewIndex) {
/*  933 */       super(param1ViewIndex);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void clear() {
/*  938 */       super.clear();
/*  939 */       this.topFutureCursor = null;
/*      */     }
/*      */     
/*      */     protected Cursor run() throws Exception {
/*      */       LocalResult localResult;
/*  944 */       if (this.topFutureCursor == null)
/*      */       {
/*      */         
/*  947 */         return JoinBatch.EMPTY_CURSOR;
/*      */       }
/*  949 */       this.viewIndex.setupQueryParameters(this.viewIndex.getSession(), this.first, this.last, null);
/*  950 */       JoinBatch.this.viewTopFutureCursor = this.topFutureCursor;
/*      */       
/*      */       try {
/*  953 */         localResult = this.viewIndex.getQuery().query(0);
/*      */       } finally {
/*  955 */         JoinBatch.this.viewTopFutureCursor = null;
/*      */       } 
/*  957 */       return (Cursor)newCursor(localResult);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class ViewIndexLookupBatchUnion
/*      */     extends ViewIndexLookupBatchBase<QueryRunnerUnion>
/*      */   {
/*      */     ArrayList<JoinBatch.JoinFilter> filters;
/*      */     
/*      */     ArrayList<JoinBatch> joinBatches;
/*      */     private boolean onlyBatchedQueries = true;
/*      */     
/*      */     protected ViewIndexLookupBatchUnion(ViewIndex param1ViewIndex) {
/*  971 */       super(param1ViewIndex);
/*      */     }
/*      */     
/*      */     boolean initialize() {
/*  975 */       return (collectJoinBatches(this.viewIndex.getQuery()) && this.joinBatches != null);
/*      */     }
/*      */     
/*      */     private boolean collectJoinBatches(Query param1Query) {
/*  979 */       if (param1Query.isUnion()) {
/*  980 */         SelectUnion selectUnion = (SelectUnion)param1Query;
/*  981 */         return (collectJoinBatches(selectUnion.getLeft()) && collectJoinBatches(selectUnion.getRight()));
/*      */       } 
/*      */       
/*  984 */       Select select = (Select)param1Query;
/*  985 */       JoinBatch joinBatch = select.getJoinBatch();
/*  986 */       if (joinBatch == null) {
/*  987 */         this.onlyBatchedQueries = false;
/*      */       } else {
/*  989 */         if (joinBatch.getLookupBatch(0) == null)
/*      */         {
/*  991 */           return false;
/*      */         }
/*  993 */         assert !joinBatch.batchedSubQuery;
/*  994 */         joinBatch.batchedSubQuery = true;
/*  995 */         if (this.joinBatches == null) {
/*  996 */           this.joinBatches = New.arrayList();
/*  997 */           this.filters = New.arrayList();
/*      */         } 
/*  999 */         this.filters.add(joinBatch.filters[0]);
/* 1000 */         this.joinBatches.add(joinBatch);
/*      */       } 
/* 1002 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isBatchFull() {
/* 1008 */       for (byte b = 0; b < this.filters.size(); b++) {
/* 1009 */         if (((JoinBatch.JoinFilter)this.filters.get(b)).isBatchFull()) {
/* 1010 */           return true;
/*      */         }
/*      */       } 
/* 1013 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean collectSearchRows(JoinBatch.QueryRunnerUnion param1QueryRunnerUnion) {
/* 1018 */       boolean bool = false;
/* 1019 */       for (byte b = 0; b < this.filters.size(); b++) {
/* 1020 */         if (((JoinBatch.JoinFilter)this.filters.get(b)).collectSearchRows()) {
/* 1021 */           bool = true;
/*      */         } else {
/* 1023 */           param1QueryRunnerUnion.topFutureCursors[b] = JoinBatch.EMPTY_FUTURE_CURSOR;
/*      */         } 
/*      */       } 
/* 1026 */       return (bool || !this.onlyBatchedQueries);
/*      */     }
/*      */ 
/*      */     
/*      */     protected JoinBatch.QueryRunnerUnion newQueryRunner() {
/* 1031 */       return new JoinBatch.QueryRunnerUnion(this);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void startQueryRunners(int param1Int) {
/* 1036 */       for (byte b = 0; b < this.filters.size(); b++) {
/* 1037 */         List<Future<Cursor>> list = ((JoinBatch.JoinFilter)this.filters.get(b)).find();
/* 1038 */         byte b1 = 0, b2 = 0;
/* 1039 */         for (; b1 < param1Int; b1++) {
/* 1040 */           Future<Cursor>[] arrayOfFuture = (queryRunner(b1)).topFutureCursors;
/* 1041 */           if (arrayOfFuture[b] == null) {
/* 1042 */             arrayOfFuture[b] = list.get(b2++);
/*      */           }
/*      */         } 
/* 1045 */         assert b1 == param1Int;
/* 1046 */         assert b2 == list.size();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class QueryRunnerUnion
/*      */     extends QueryRunnerBase
/*      */   {
/*      */     Future<Cursor>[] topFutureCursors;
/*      */     
/*      */     private JoinBatch.ViewIndexLookupBatchUnion batchUnion;
/*      */     
/*      */     public QueryRunnerUnion(JoinBatch.ViewIndexLookupBatchUnion param1ViewIndexLookupBatchUnion) {
/* 1060 */       super(param1ViewIndexLookupBatchUnion.viewIndex);
/* 1061 */       this.batchUnion = param1ViewIndexLookupBatchUnion;
/* 1062 */       this.topFutureCursors = (Future<Cursor>[])new Future[param1ViewIndexLookupBatchUnion.filters.size()];
/*      */     }
/*      */ 
/*      */     
/*      */     protected void clear() {
/* 1067 */       super.clear();
/* 1068 */       for (byte b = 0; b < this.topFutureCursors.length; b++) {
/* 1069 */         this.topFutureCursors[b] = null;
/*      */       }
/*      */     }
/*      */     
/*      */     protected Cursor run() throws Exception {
/*      */       LocalResult localResult;
/* 1075 */       this.viewIndex.setupQueryParameters(this.viewIndex.getSession(), this.first, this.last, null);
/* 1076 */       ArrayList<JoinBatch> arrayList = this.batchUnion.joinBatches; int i;
/* 1077 */       for (byte b = 0; b < i; b++) {
/* 1078 */         assert this.topFutureCursors[b] != null;
/* 1079 */         ((JoinBatch)arrayList.get(b)).viewTopFutureCursor = this.topFutureCursors[b];
/*      */       } 
/*      */       
/*      */       try {
/* 1083 */         localResult = this.viewIndex.getQuery().query(0);
/*      */       } finally {
/* 1085 */         byte b1; int j; for (b1 = 0, j = arrayList.size(); b1 < j; b1++) {
/* 1086 */           ((JoinBatch)arrayList.get(b1)).viewTopFutureCursor = null;
/*      */         }
/*      */       } 
/* 1089 */       return (Cursor)newCursor(localResult);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\JoinBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */