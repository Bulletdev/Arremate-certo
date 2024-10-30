/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.command.dml.Query;
/*     */ import org.h2.command.dml.SelectUnion;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.JoinBatch;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.table.TableView;
/*     */ import org.h2.util.IntArray;
/*     */ import org.h2.util.New;
/*     */ import org.h2.value.Value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ViewIndex
/*     */   extends BaseIndex
/*     */   implements SpatialIndex
/*     */ {
/*  41 */   private static final long MAX_AGE_NANOS = TimeUnit.MILLISECONDS.toNanos(10000L);
/*     */ 
/*     */   
/*     */   private final TableView view;
/*     */ 
/*     */   
/*     */   private final String querySQL;
/*     */ 
/*     */   
/*     */   private final ArrayList<Parameter> originalParameters;
/*     */ 
/*     */   
/*     */   private boolean recursive;
/*     */ 
/*     */   
/*     */   private final int[] indexMasks;
/*     */ 
/*     */   
/*     */   private Query query;
/*     */   
/*     */   private final Session createSession;
/*     */   
/*     */   private final long evaluatedAt;
/*     */ 
/*     */   
/*     */   public ViewIndex(TableView paramTableView, String paramString, ArrayList<Parameter> paramArrayList, boolean paramBoolean) {
/*  67 */     initBaseIndex((Table)paramTableView, 0, null, null, IndexType.createNonUnique(false));
/*  68 */     this.view = paramTableView;
/*  69 */     this.querySQL = paramString;
/*  70 */     this.originalParameters = paramArrayList;
/*  71 */     this.recursive = paramBoolean;
/*  72 */     this.columns = new Column[0];
/*  73 */     this.createSession = null;
/*  74 */     this.indexMasks = null;
/*     */ 
/*     */     
/*  77 */     this.evaluatedAt = Long.MIN_VALUE;
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
/*     */   public ViewIndex(TableView paramTableView, ViewIndex paramViewIndex, Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder) {
/*  94 */     initBaseIndex((Table)paramTableView, 0, null, null, IndexType.createNonUnique(false));
/*  95 */     this.view = paramTableView;
/*  96 */     this.querySQL = paramViewIndex.querySQL;
/*  97 */     this.originalParameters = paramViewIndex.originalParameters;
/*  98 */     this.recursive = paramViewIndex.recursive;
/*  99 */     this.indexMasks = paramArrayOfint;
/* 100 */     this.createSession = paramSession;
/* 101 */     this.columns = new Column[0];
/* 102 */     if (!this.recursive) {
/* 103 */       this.query = getQuery(paramSession, paramArrayOfint, paramArrayOfTableFilter, paramInt, paramSortOrder);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     this.evaluatedAt = (this.recursive || paramTableView.getTopQuery() != null) ? Long.MAX_VALUE : System.nanoTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public IndexLookupBatch createLookupBatch(TableFilter[] paramArrayOfTableFilter, int paramInt) {
/* 114 */     if (this.recursive)
/*     */     {
/* 116 */       return null;
/*     */     }
/* 118 */     return JoinBatch.createViewIndexLookupBatch(this);
/*     */   }
/*     */   
/*     */   public Session getSession() {
/* 122 */     return this.createSession;
/*     */   }
/*     */   
/*     */   public boolean isExpired() {
/* 126 */     assert this.evaluatedAt != Long.MIN_VALUE : "must not be called for main index of TableView";
/* 127 */     return (!this.recursive && this.view.getTopQuery() == null && System.nanoTime() - this.evaluatedAt > MAX_AGE_NANOS);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 133 */     return (this.query == null) ? null : this.query.getPlanSQL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/* 143 */     throw DbException.getUnsupportedException("VIEW");
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/* 148 */     throw DbException.getUnsupportedException("VIEW");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 155 */     return this.recursive ? 1000.0D : this.query.getCost();
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 160 */     return find(paramSession, paramSearchRow1, paramSearchRow2, (SearchRow)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Cursor findByGeometry(TableFilter paramTableFilter, SearchRow paramSearchRow1, SearchRow paramSearchRow2, SearchRow paramSearchRow3) {
/* 166 */     return find(paramTableFilter.getSession(), paramSearchRow1, paramSearchRow2, paramSearchRow3);
/*     */   }
/*     */   
/*     */   private static Query prepareSubQuery(String paramString, Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder) {
/*     */     Prepared prepared;
/* 171 */     assert paramArrayOfTableFilter != null;
/*     */     
/* 173 */     paramSession.pushSubQueryInfo(paramArrayOfint, paramArrayOfTableFilter, paramInt, paramSortOrder);
/*     */     try {
/* 175 */       prepared = paramSession.prepare(paramString, true);
/*     */     } finally {
/* 177 */       paramSession.popSubQueryInfo();
/*     */     } 
/* 179 */     return (Query)prepared;
/*     */   }
/*     */   
/*     */   private Cursor findRecursive(SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 183 */     assert this.recursive;
/* 184 */     LocalResult localResult1 = this.view.getRecursiveResult();
/* 185 */     if (localResult1 != null) {
/* 186 */       localResult1.reset();
/* 187 */       return new ViewCursor(this, localResult1, paramSearchRow1, paramSearchRow2);
/*     */     } 
/* 189 */     if (this.query == null) {
/* 190 */       Parser parser = new Parser(this.createSession);
/* 191 */       parser.setRightsChecked(true);
/* 192 */       parser.setSuppliedParameterList(this.originalParameters);
/* 193 */       this.query = (Query)parser.prepare(this.querySQL);
/*     */     } 
/* 195 */     if (!this.query.isUnion()) {
/* 196 */       throw DbException.get(42001, "recursive queries without UNION ALL");
/*     */     }
/*     */     
/* 199 */     SelectUnion selectUnion = (SelectUnion)this.query;
/* 200 */     if (selectUnion.getUnionType() != 1) {
/* 201 */       throw DbException.get(42001, "recursive queries without UNION ALL");
/*     */     }
/*     */     
/* 204 */     Query query1 = selectUnion.getLeft();
/*     */     
/* 206 */     query1.disableCache();
/* 207 */     LocalResult localResult2 = query1.query(0);
/* 208 */     LocalResult localResult3 = selectUnion.getEmptyResult();
/*     */ 
/*     */     
/* 211 */     localResult3.setMaxMemoryRows(2147483647);
/* 212 */     while (localResult2.next()) {
/* 213 */       localResult3.addRow(localResult2.currentRow());
/*     */     }
/* 215 */     Query query2 = selectUnion.getRight();
/* 216 */     localResult2.reset();
/* 217 */     this.view.setRecursiveResult(localResult2);
/*     */     
/* 219 */     query2.disableCache();
/*     */     while (true) {
/* 221 */       localResult2 = query2.query(0);
/* 222 */       if (localResult2.getRowCount() == 0) {
/*     */         break;
/*     */       }
/* 225 */       while (localResult2.next()) {
/* 226 */         localResult3.addRow(localResult2.currentRow());
/*     */       }
/* 228 */       localResult2.reset();
/* 229 */       this.view.setRecursiveResult(localResult2);
/*     */     } 
/* 231 */     this.view.setRecursiveResult(null);
/* 232 */     localResult3.done();
/* 233 */     return new ViewCursor(this, localResult3, paramSearchRow1, paramSearchRow2);
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
/*     */   public void setupQueryParameters(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2, SearchRow paramSearchRow3) {
/*     */     byte b1;
/* 246 */     ArrayList<Parameter> arrayList = this.query.getParameters();
/* 247 */     if (this.originalParameters != null) {
/* 248 */       int j; for (b1 = 0, j = this.originalParameters.size(); b1 < j; b1++) {
/* 249 */         Parameter parameter = this.originalParameters.get(b1);
/* 250 */         int k = parameter.getIndex();
/* 251 */         Value value = parameter.getValue(paramSession);
/* 252 */         setParameter(arrayList, k, value);
/*     */       } 
/*     */     } 
/*     */     
/* 256 */     if (paramSearchRow1 != null) {
/* 257 */       b1 = paramSearchRow1.getColumnCount();
/* 258 */     } else if (paramSearchRow2 != null) {
/* 259 */       b1 = paramSearchRow2.getColumnCount();
/* 260 */     } else if (paramSearchRow3 != null) {
/* 261 */       b1 = paramSearchRow3.getColumnCount();
/*     */     } else {
/* 263 */       b1 = 0;
/*     */     } 
/* 265 */     int i = this.view.getParameterOffset(this.originalParameters);
/* 266 */     for (byte b2 = 0; b2 < b1; b2++) {
/* 267 */       int j = this.indexMasks[b2];
/* 268 */       if ((j & 0x1) != 0) {
/* 269 */         setParameter(arrayList, i++, paramSearchRow1.getValue(b2));
/*     */       }
/* 271 */       if ((j & 0x2) != 0) {
/* 272 */         setParameter(arrayList, i++, paramSearchRow1.getValue(b2));
/*     */       }
/* 274 */       if ((j & 0x4) != 0) {
/* 275 */         setParameter(arrayList, i++, paramSearchRow2.getValue(b2));
/*     */       }
/* 277 */       if ((j & 0x10) != 0) {
/* 278 */         setParameter(arrayList, i++, paramSearchRow3.getValue(b2));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2, SearchRow paramSearchRow3) {
/* 285 */     if (this.recursive) {
/* 286 */       return findRecursive(paramSearchRow1, paramSearchRow2);
/*     */     }
/* 288 */     setupQueryParameters(paramSession, paramSearchRow1, paramSearchRow2, paramSearchRow3);
/* 289 */     LocalResult localResult = this.query.query(0);
/* 290 */     return new ViewCursor(this, localResult, paramSearchRow1, paramSearchRow2);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void setParameter(ArrayList<Parameter> paramArrayList, int paramInt, Value paramValue) {
/* 295 */     if (paramInt >= paramArrayList.size()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 300 */     Parameter parameter = paramArrayList.get(paramInt);
/* 301 */     parameter.setValue(paramValue);
/*     */   }
/*     */   
/*     */   public Query getQuery() {
/* 305 */     return this.query;
/*     */   }
/*     */ 
/*     */   
/*     */   private Query getQuery(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder) {
/* 310 */     Query query = prepareSubQuery(this.querySQL, paramSession, paramArrayOfint, paramArrayOfTableFilter, paramInt, paramSortOrder);
/* 311 */     if (paramArrayOfint == null) {
/* 312 */       return query;
/*     */     }
/* 314 */     if (!query.allowGlobalConditions()) {
/* 315 */       return query;
/*     */     }
/* 317 */     int i = this.view.getParameterOffset(this.originalParameters);
/*     */ 
/*     */ 
/*     */     
/* 321 */     IntArray intArray = new IntArray();
/* 322 */     byte b1 = 0; int j;
/* 323 */     for (j = 0; j < paramArrayOfint.length; j++) {
/* 324 */       int k = paramArrayOfint[j];
/* 325 */       if (k != 0) {
/*     */ 
/*     */         
/* 328 */         b1++;
/*     */ 
/*     */ 
/*     */         
/* 332 */         int m = Integer.bitCount(k);
/* 333 */         for (byte b = 0; b < m; b++)
/* 334 */           intArray.add(j); 
/*     */       } 
/*     */     } 
/* 337 */     j = intArray.size();
/* 338 */     ArrayList<Column> arrayList = New.arrayList(); byte b2;
/* 339 */     for (b2 = 0; b2 < j; ) {
/* 340 */       int k = intArray.get(b2);
/* 341 */       arrayList.add(this.table.getColumn(k));
/* 342 */       int m = paramArrayOfint[k];
/* 343 */       if ((m & 0x1) != 0) {
/* 344 */         Parameter parameter = new Parameter(i + b2);
/* 345 */         query.addGlobalCondition(parameter, k, 16);
/* 346 */         b2++;
/*     */       } 
/* 348 */       if ((m & 0x2) != 0) {
/* 349 */         Parameter parameter = new Parameter(i + b2);
/* 350 */         query.addGlobalCondition(parameter, k, 1);
/* 351 */         b2++;
/*     */       } 
/* 353 */       if ((m & 0x4) != 0) {
/* 354 */         Parameter parameter = new Parameter(i + b2);
/* 355 */         query.addGlobalCondition(parameter, k, 3);
/* 356 */         b2++;
/*     */       } 
/* 358 */       if ((m & 0x10) != 0) {
/* 359 */         Parameter parameter = new Parameter(i + b2);
/* 360 */         query.addGlobalCondition(parameter, k, 11);
/* 361 */         b2++;
/*     */       } 
/*     */     } 
/* 364 */     this.columns = new Column[arrayList.size()];
/* 365 */     arrayList.toArray(this.columns);
/*     */ 
/*     */     
/* 368 */     this.indexColumns = new IndexColumn[b1];
/* 369 */     this.columnIds = new int[b1]; byte b3;
/* 370 */     for (b2 = 0, b3 = 0; b2 < 2; b2++) {
/* 371 */       for (byte b = 0; b < paramArrayOfint.length; b++) {
/* 372 */         int k = paramArrayOfint[b];
/* 373 */         if (k != 0)
/*     */         {
/*     */           
/* 376 */           if ((b2 == 0) ? ((
/* 377 */             k & 0x1) == 0) : ((
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 382 */             k & 0x1) != 0)) {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 387 */             IndexColumn indexColumn = new IndexColumn();
/* 388 */             indexColumn.column = this.table.getColumn(b);
/* 389 */             this.indexColumns[b3] = indexColumn;
/* 390 */             this.columnIds[b3] = indexColumn.column.getColumnId();
/* 391 */             b3++;
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 395 */     String str = query.getPlanSQL();
/* 396 */     query = prepareSubQuery(str, paramSession, paramArrayOfint, paramArrayOfTableFilter, paramInt, paramSortOrder);
/* 397 */     return query;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/* 402 */     throw DbException.getUnsupportedException("VIEW");
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 407 */     throw DbException.getUnsupportedException("VIEW");
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/* 412 */     throw DbException.getUnsupportedException("VIEW");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 417 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 422 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 427 */     throw DbException.getUnsupportedException("VIEW");
/*     */   }
/*     */   
/*     */   public void setRecursive(boolean paramBoolean) {
/* 431 */     this.recursive = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 436 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 441 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 446 */     return 0L;
/*     */   }
/*     */   
/*     */   public boolean isRecursive() {
/* 450 */     return this.recursive;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\ViewIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */