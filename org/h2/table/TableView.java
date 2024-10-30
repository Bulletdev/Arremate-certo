/*     */ package org.h2.table;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.command.dml.Query;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.User;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionColumn;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.index.ViewIndex;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TableView
/*     */   extends Table
/*     */ {
/*     */   private static final long ROW_COUNT_APPROXIMATION = 100L;
/*     */   private String querySQL;
/*     */   private ArrayList<Table> tables;
/*     */   private Column[] columnTemplates;
/*     */   private Query viewQuery;
/*     */   private ViewIndex index;
/*     */   private boolean recursive;
/*     */   private DbException createException;
/*     */   private long lastModificationCheck;
/*     */   private long maxDataModificationId;
/*     */   private User owner;
/*     */   private Query topQuery;
/*     */   private LocalResult recursiveResult;
/*     */   private boolean tableExpression;
/*     */   
/*     */   public TableView(Schema paramSchema, int paramInt, String paramString1, String paramString2, ArrayList<Parameter> paramArrayList, Column[] paramArrayOfColumn, Session paramSession, boolean paramBoolean) {
/*  64 */     super(paramSchema, paramInt, paramString1, false, true);
/*  65 */     init(paramString2, paramArrayList, paramArrayOfColumn, paramSession, paramBoolean);
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
/*     */   public void replace(String paramString, String[] paramArrayOfString, Session paramSession, boolean paramBoolean1, boolean paramBoolean2) {
/*  80 */     String str = this.querySQL;
/*  81 */     Column[] arrayOfColumn = this.columnTemplates;
/*  82 */     boolean bool = this.recursive;
/*  83 */     init(paramString, (ArrayList<Parameter>)null, this.columnTemplates, paramSession, paramBoolean1);
/*  84 */     DbException dbException = recompile(paramSession, paramBoolean2, true);
/*  85 */     if (dbException != null) {
/*  86 */       init(str, (ArrayList<Parameter>)null, arrayOfColumn, paramSession, bool);
/*  87 */       recompile(paramSession, true, false);
/*  88 */       throw dbException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private synchronized void init(String paramString, ArrayList<Parameter> paramArrayList, Column[] paramArrayOfColumn, Session paramSession, boolean paramBoolean) {
/*  94 */     this.querySQL = paramString;
/*  95 */     this.columnTemplates = paramArrayOfColumn;
/*  96 */     this.recursive = paramBoolean;
/*  97 */     this.index = new ViewIndex(this, paramString, paramArrayList, paramBoolean);
/*  98 */     initColumnsAndTables(paramSession);
/*     */   }
/*     */   
/*     */   private static Query compileViewQuery(Session paramSession, String paramString) {
/*     */     Prepared prepared;
/* 103 */     paramSession.setParsingView(true);
/*     */     try {
/* 105 */       prepared = paramSession.prepare(paramString);
/*     */     } finally {
/* 107 */       paramSession.setParsingView(false);
/*     */     } 
/* 109 */     if (!(prepared instanceof Query)) {
/* 110 */       throw DbException.getSyntaxError(paramString, 0);
/*     */     }
/* 112 */     return (Query)prepared;
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
/*     */   public synchronized DbException recompile(Session paramSession, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     try {
/* 127 */       compileViewQuery(paramSession, this.querySQL);
/* 128 */     } catch (DbException dbException) {
/* 129 */       if (!paramBoolean1) {
/* 130 */         return dbException;
/*     */       }
/*     */     } 
/* 133 */     ArrayList<TableView> arrayList = getViews();
/* 134 */     if (arrayList != null) {
/* 135 */       arrayList = New.arrayList(arrayList);
/*     */     }
/* 137 */     initColumnsAndTables(paramSession);
/* 138 */     if (arrayList != null) {
/* 139 */       for (TableView tableView : arrayList) {
/* 140 */         DbException dbException = tableView.recompile(paramSession, paramBoolean1, false);
/* 141 */         if (dbException != null && !paramBoolean1) {
/* 142 */           return dbException;
/*     */         }
/*     */       } 
/*     */     }
/* 146 */     if (paramBoolean2) {
/* 147 */       clearIndexCaches(this.database);
/*     */     }
/* 149 */     return paramBoolean1 ? null : this.createException;
/*     */   }
/*     */   
/*     */   private void initColumnsAndTables(Session paramSession) {
/*     */     Column[] arrayOfColumn;
/* 154 */     removeViewFromTables();
/*     */     try {
/* 156 */       Query query = compileViewQuery(paramSession, this.querySQL);
/* 157 */       this.querySQL = query.getPlanSQL();
/* 158 */       this.tables = New.arrayList(query.getTables());
/* 159 */       ArrayList<Expression> arrayList = query.getExpressions();
/* 160 */       ArrayList<Column> arrayList1 = New.arrayList(); byte b; int i;
/* 161 */       for (b = 0, i = query.getColumnCount(); b < i; b++) {
/* 162 */         Expression expression = arrayList.get(b);
/* 163 */         String str = null;
/* 164 */         int j = -1;
/* 165 */         if (this.columnTemplates != null && this.columnTemplates.length > b) {
/* 166 */           str = this.columnTemplates[b].getName();
/* 167 */           j = this.columnTemplates[b].getType();
/*     */         } 
/* 169 */         if (str == null) {
/* 170 */           str = expression.getAlias();
/*     */         }
/* 172 */         if (j == -1) {
/* 173 */           j = expression.getType();
/*     */         }
/* 175 */         long l = expression.getPrecision();
/* 176 */         int k = expression.getScale();
/* 177 */         int m = expression.getDisplaySize();
/* 178 */         Column column = new Column(str, j, l, k, m);
/* 179 */         column.setTable(this, b);
/*     */         
/* 181 */         ExpressionColumn expressionColumn = null;
/* 182 */         if (expression instanceof ExpressionColumn) {
/* 183 */           expressionColumn = (ExpressionColumn)expression;
/* 184 */         } else if (expression instanceof org.h2.expression.Alias) {
/* 185 */           Expression expression1 = expression.getNonAliasExpression();
/* 186 */           if (expression1 instanceof ExpressionColumn) {
/* 187 */             expressionColumn = (ExpressionColumn)expression1;
/*     */           }
/*     */         } 
/* 190 */         if (expressionColumn != null) {
/* 191 */           Expression expression1 = expressionColumn.getColumn().getCheckConstraint(paramSession, str);
/*     */           
/* 193 */           if (expression1 != null) {
/* 194 */             column.addCheckConstraint(paramSession, expression1);
/*     */           }
/*     */         } 
/* 197 */         arrayList1.add(column);
/*     */       } 
/* 199 */       arrayOfColumn = new Column[arrayList1.size()];
/* 200 */       arrayList1.toArray(arrayOfColumn);
/* 201 */       this.createException = null;
/* 202 */       this.viewQuery = query;
/* 203 */     } catch (DbException dbException) {
/* 204 */       dbException.addSQL(getCreateSQL());
/* 205 */       this.createException = dbException;
/*     */ 
/*     */ 
/*     */       
/* 209 */       this.tables = New.arrayList();
/* 210 */       arrayOfColumn = new Column[0];
/* 211 */       if (this.recursive && this.columnTemplates != null) {
/* 212 */         arrayOfColumn = new Column[this.columnTemplates.length];
/* 213 */         for (byte b = 0; b < this.columnTemplates.length; b++) {
/* 214 */           arrayOfColumn[b] = this.columnTemplates[b].getClone();
/*     */         }
/* 216 */         this.index.setRecursive(true);
/* 217 */         this.createException = null;
/*     */       } 
/*     */     } 
/* 220 */     setColumns(arrayOfColumn);
/* 221 */     if (getId() != 0) {
/* 222 */       addViewToTables();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isView() {
/* 228 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInvalid() {
/* 237 */     return (this.createException != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PlanItem getBestPlanItem(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 244 */     CacheKey cacheKey = new CacheKey(paramArrayOfint, this);
/* 245 */     Map<CacheKey, ViewIndex> map = paramSession.getViewIndexCache((this.topQuery != null));
/* 246 */     ViewIndex viewIndex = (ViewIndex)map.get(cacheKey);
/* 247 */     if (viewIndex == null || viewIndex.isExpired()) {
/* 248 */       viewIndex = new ViewIndex(this, this.index, paramSession, paramArrayOfint, paramArrayOfTableFilter, paramInt, paramSortOrder);
/* 249 */       map.put(cacheKey, viewIndex);
/*     */     } 
/* 251 */     PlanItem planItem = new PlanItem();
/* 252 */     planItem.cost = viewIndex.getCost(paramSession, paramArrayOfint, paramArrayOfTableFilter, paramInt, paramSortOrder, paramHashSet);
/* 253 */     planItem.setIndex((Index)viewIndex);
/* 254 */     return planItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isQueryComparable() {
/* 259 */     if (!super.isQueryComparable()) {
/* 260 */       return false;
/*     */     }
/* 262 */     for (Table table : this.tables) {
/* 263 */       if (!table.isQueryComparable()) {
/* 264 */         return false;
/*     */       }
/*     */     } 
/* 267 */     if (this.topQuery != null && !this.topQuery.isEverything(ExpressionVisitor.QUERY_COMPARABLE_VISITOR))
/*     */     {
/* 269 */       return false;
/*     */     }
/* 271 */     return true;
/*     */   }
/*     */   
/*     */   public Query getTopQuery() {
/* 275 */     return this.topQuery;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/* 280 */     return "DROP VIEW IF EXISTS " + getSQL() + " CASCADE";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 285 */     return getCreateSQL(false, true, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/* 291 */     return getCreateSQL(false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateSQL(boolean paramBoolean1, boolean paramBoolean2) {
/* 302 */     return getCreateSQL(paramBoolean1, paramBoolean2, getSQL());
/*     */   }
/*     */ 
/*     */   
/*     */   private String getCreateSQL(boolean paramBoolean1, boolean paramBoolean2, String paramString) {
/* 307 */     StatementBuilder statementBuilder = new StatementBuilder("CREATE ");
/* 308 */     if (paramBoolean1) {
/* 309 */       statementBuilder.append("OR REPLACE ");
/*     */     }
/* 311 */     if (paramBoolean2) {
/* 312 */       statementBuilder.append("FORCE ");
/*     */     }
/* 314 */     statementBuilder.append("VIEW ");
/* 315 */     statementBuilder.append(paramString);
/* 316 */     if (this.comment != null) {
/* 317 */       statementBuilder.append(" COMMENT ").append(StringUtils.quoteStringSQL(this.comment));
/*     */     }
/* 319 */     if (this.columns != null && this.columns.length > 0) {
/* 320 */       statementBuilder.append('(');
/* 321 */       for (Column column : this.columns) {
/* 322 */         statementBuilder.appendExceptFirst(", ");
/* 323 */         statementBuilder.append(column.getSQL());
/*     */       } 
/* 325 */       statementBuilder.append(')');
/* 326 */     } else if (this.columnTemplates != null) {
/* 327 */       statementBuilder.append('(');
/* 328 */       for (Column column : this.columnTemplates) {
/* 329 */         statementBuilder.appendExceptFirst(", ");
/* 330 */         statementBuilder.append(column.getName());
/*     */       } 
/* 332 */       statementBuilder.append(')');
/*     */     } 
/* 334 */     return statementBuilder.append(" AS\n").append(this.querySQL).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean lock(Session paramSession, boolean paramBoolean1, boolean paramBoolean2) {
/* 345 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void unlock(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLockedExclusively() {
/* 360 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Index addIndex(Session paramSession, String paramString1, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType, boolean paramBoolean, String paramString2) {
/* 367 */     throw DbException.getUnsupportedException("VIEW");
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRow(Session paramSession, Row paramRow) {
/* 372 */     throw DbException.getUnsupportedException("VIEW");
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRow(Session paramSession, Row paramRow) {
/* 377 */     throw DbException.getUnsupportedException("VIEW");
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkSupportAlter() {
/* 382 */     throw DbException.getUnsupportedException("VIEW");
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 387 */     throw DbException.getUnsupportedException("VIEW");
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 392 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canGetRowCount() {
/* 398 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDrop() {
/* 403 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTableType() {
/* 408 */     return "VIEW";
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 413 */     removeViewFromTables();
/* 414 */     super.removeChildrenAndResources(paramSession);
/* 415 */     this.database.removeMeta(paramSession, getId());
/* 416 */     this.querySQL = null;
/* 417 */     this.index = null;
/* 418 */     clearIndexCaches(this.database);
/* 419 */     invalidate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clearIndexCaches(Database paramDatabase) {
/* 428 */     for (Session session : paramDatabase.getSessions(true)) {
/* 429 */       session.clearViewIndexCache();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 435 */     if (isTemporary()) {
/* 436 */       return "(\n" + StringUtils.indent(this.querySQL) + ")";
/*     */     }
/* 438 */     return super.getSQL();
/*     */   }
/*     */   
/*     */   public String getQuery() {
/* 442 */     return this.querySQL;
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getScanIndex(Session paramSession) {
/* 447 */     return getBestPlanItem(paramSession, (int[])null, (TableFilter[])null, -1, (SortOrder)null, (HashSet<Column>)null).getIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Index getScanIndex(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 454 */     if (this.createException != null) {
/* 455 */       String str = this.createException.getMessage();
/* 456 */       throw DbException.get(90109, this.createException, new String[] { getSQL(), str });
/*     */     } 
/*     */     
/* 459 */     PlanItem planItem = getBestPlanItem(paramSession, paramArrayOfint, paramArrayOfTableFilter, paramInt, paramSortOrder, paramHashSet);
/* 460 */     return planItem.getIndex();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canReference() {
/* 465 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Index> getIndexes() {
/* 470 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxDataModificationId() {
/* 475 */     if (this.createException != null) {
/* 476 */       return Long.MAX_VALUE;
/*     */     }
/* 478 */     if (this.viewQuery == null) {
/* 479 */       return Long.MAX_VALUE;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 484 */     long l = this.database.getModificationDataId();
/* 485 */     if (l > this.lastModificationCheck && this.maxDataModificationId <= l) {
/* 486 */       this.maxDataModificationId = this.viewQuery.getMaxDataModificationId();
/* 487 */       this.lastModificationCheck = l;
/*     */     } 
/* 489 */     return this.maxDataModificationId;
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getUniqueIndex() {
/* 494 */     return null;
/*     */   }
/*     */   
/*     */   private void removeViewFromTables() {
/* 498 */     if (this.tables != null) {
/* 499 */       for (Table table : this.tables) {
/* 500 */         table.removeView(this);
/*     */       }
/* 502 */       this.tables.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addViewToTables() {
/* 507 */     for (Table table : this.tables) {
/* 508 */       table.addView(this);
/*     */     }
/*     */   }
/*     */   
/*     */   private void setOwner(User paramUser) {
/* 513 */     this.owner = paramUser;
/*     */   }
/*     */   
/*     */   public User getOwner() {
/* 517 */     return this.owner;
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
/*     */   public static TableView createTempView(Session paramSession, User paramUser, String paramString, Query paramQuery1, Query paramQuery2) {
/* 532 */     Schema schema = paramSession.getDatabase().getSchema("PUBLIC");
/* 533 */     String str = paramQuery1.getPlanSQL();
/* 534 */     TableView tableView = new TableView(schema, 0, paramString, str, paramQuery1.getParameters(), null, paramSession, false);
/*     */ 
/*     */     
/* 537 */     if (tableView.createException != null) {
/* 538 */       throw tableView.createException;
/*     */     }
/* 540 */     tableView.setTopQuery(paramQuery2);
/* 541 */     tableView.setOwner(paramUser);
/* 542 */     tableView.setTemporary(true);
/* 543 */     return tableView;
/*     */   }
/*     */   
/*     */   private void setTopQuery(Query paramQuery) {
/* 547 */     this.topQuery = paramQuery;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 552 */     return 100L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 557 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getParameterOffset(ArrayList<Parameter> paramArrayList) {
/* 567 */     int i = (this.topQuery == null) ? -1 : getMaxParameterIndex(this.topQuery.getParameters());
/* 568 */     if (paramArrayList != null) {
/* 569 */       i = Math.max(i, getMaxParameterIndex(paramArrayList));
/*     */     }
/* 571 */     return i + 1;
/*     */   }
/*     */   
/*     */   private static int getMaxParameterIndex(ArrayList<Parameter> paramArrayList) {
/* 575 */     int i = -1;
/* 576 */     for (Parameter parameter : paramArrayList) {
/* 577 */       i = Math.max(i, parameter.getIndex());
/*     */     }
/* 579 */     return i;
/*     */   }
/*     */   
/*     */   public boolean isRecursive() {
/* 583 */     return this.recursive;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDeterministic() {
/* 588 */     if (this.recursive || this.viewQuery == null) {
/* 589 */       return false;
/*     */     }
/* 591 */     return this.viewQuery.isEverything(ExpressionVisitor.DETERMINISTIC_VISITOR);
/*     */   }
/*     */   
/*     */   public void setRecursiveResult(LocalResult paramLocalResult) {
/* 595 */     if (this.recursiveResult != null) {
/* 596 */       this.recursiveResult.close();
/*     */     }
/* 598 */     this.recursiveResult = paramLocalResult;
/*     */   }
/*     */   
/*     */   public LocalResult getRecursiveResult() {
/* 602 */     return this.recursiveResult;
/*     */   }
/*     */   
/*     */   public void setTableExpression(boolean paramBoolean) {
/* 606 */     this.tableExpression = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isTableExpression() {
/* 610 */     return this.tableExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addDependencies(HashSet<DbObject> paramHashSet) {
/* 615 */     super.addDependencies(paramHashSet);
/* 616 */     if (this.tables != null) {
/* 617 */       for (Table table : this.tables) {
/* 618 */         if (!"VIEW".equals(table.getTableType())) {
/* 619 */           table.addDependencies(paramHashSet);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class CacheKey
/*     */   {
/*     */     private final int[] masks;
/*     */     
/*     */     private final TableView view;
/*     */ 
/*     */     
/*     */     public CacheKey(int[] param1ArrayOfint, TableView param1TableView) {
/* 634 */       this.masks = param1ArrayOfint;
/* 635 */       this.view = param1TableView;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 641 */       int i = 1;
/* 642 */       i = 31 * i + Arrays.hashCode(this.masks);
/* 643 */       i = 31 * i + this.view.hashCode();
/* 644 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 649 */       if (this == param1Object) {
/* 650 */         return true;
/*     */       }
/* 652 */       if (param1Object == null) {
/* 653 */         return false;
/*     */       }
/* 655 */       if (getClass() != param1Object.getClass()) {
/* 656 */         return false;
/*     */       }
/* 658 */       CacheKey cacheKey = (CacheKey)param1Object;
/* 659 */       if (this.view != cacheKey.view) {
/* 660 */         return false;
/*     */       }
/* 662 */       if (!Arrays.equals(this.masks, cacheKey.masks)) {
/* 663 */         return false;
/*     */       }
/* 665 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\TableView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */