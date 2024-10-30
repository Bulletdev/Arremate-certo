/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.New;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExpressionVisitor
/*     */ {
/*     */   public static final int INDEPENDENT = 0;
/*  32 */   public static final ExpressionVisitor INDEPENDENT_VISITOR = new ExpressionVisitor(0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int OPTIMIZABLE_MIN_MAX_COUNT_ALL = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DETERMINISTIC = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   public static final ExpressionVisitor DETERMINISTIC_VISITOR = new ExpressionVisitor(2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int EVALUATABLE = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   public static final ExpressionVisitor EVALUATABLE_VISITOR = new ExpressionVisitor(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int SET_MAX_DATA_MODIFICATION_ID = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int READONLY = 5;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   public static final ExpressionVisitor READONLY_VISITOR = new ExpressionVisitor(5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int NOT_FROM_RESOLVER = 6;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GET_DEPENDENCIES = 7;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int QUERY_COMPARABLE = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GET_COLUMNS = 9;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   public static final ExpressionVisitor QUERY_COMPARABLE_VISITOR = new ExpressionVisitor(8);
/*     */   
/*     */   private final int type;
/*     */   
/*     */   private final int queryLevel;
/*     */   
/*     */   private final HashSet<DbObject> dependencies;
/*     */   
/*     */   private final HashSet<Column> columns;
/*     */   
/*     */   private final Table table;
/*     */   
/*     */   private final long[] maxDataModificationId;
/*     */   
/*     */   private final ColumnResolver resolver;
/*     */   
/*     */   private ExpressionVisitor(int paramInt1, int paramInt2, HashSet<DbObject> paramHashSet, HashSet<Column> paramHashSet1, Table paramTable, ColumnResolver paramColumnResolver, long[] paramArrayOflong) {
/* 124 */     this.type = paramInt1;
/* 125 */     this.queryLevel = paramInt2;
/* 126 */     this.dependencies = paramHashSet;
/* 127 */     this.columns = paramHashSet1;
/* 128 */     this.table = paramTable;
/* 129 */     this.resolver = paramColumnResolver;
/* 130 */     this.maxDataModificationId = paramArrayOflong;
/*     */   }
/*     */   
/*     */   private ExpressionVisitor(int paramInt) {
/* 134 */     this.type = paramInt;
/* 135 */     this.queryLevel = 0;
/* 136 */     this.dependencies = null;
/* 137 */     this.columns = null;
/* 138 */     this.table = null;
/* 139 */     this.resolver = null;
/* 140 */     this.maxDataModificationId = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ExpressionVisitor getDependenciesVisitor(HashSet<DbObject> paramHashSet) {
/* 151 */     return new ExpressionVisitor(7, 0, paramHashSet, null, null, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ExpressionVisitor getOptimizableVisitor(Table paramTable) {
/* 162 */     return new ExpressionVisitor(1, 0, null, null, paramTable, null, null);
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
/*     */   static ExpressionVisitor getNotFromResolverVisitor(ColumnResolver paramColumnResolver) {
/* 174 */     return new ExpressionVisitor(6, 0, null, null, null, paramColumnResolver, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ExpressionVisitor getColumnsVisitor(HashSet<Column> paramHashSet) {
/* 185 */     return new ExpressionVisitor(9, 0, null, paramHashSet, null, null, null);
/*     */   }
/*     */   
/*     */   public static ExpressionVisitor getMaxModificationIdVisitor() {
/* 189 */     return new ExpressionVisitor(4, 0, null, null, null, null, new long[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDependency(DbObject paramDbObject) {
/* 200 */     this.dependencies.add(paramDbObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void addColumn(Column paramColumn) {
/* 210 */     this.columns.add(paramColumn);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashSet<DbObject> getDependencies() {
/* 220 */     return this.dependencies;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExpressionVisitor incrementQueryLevel(int paramInt) {
/* 230 */     return new ExpressionVisitor(this.type, this.queryLevel + paramInt, this.dependencies, this.columns, this.table, this.resolver, this.maxDataModificationId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ColumnResolver getResolver() {
/* 241 */     return this.resolver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDataModificationId(long paramLong) {
/* 252 */     long l = this.maxDataModificationId[0];
/* 253 */     if (paramLong > l) {
/* 254 */       this.maxDataModificationId[0] = paramLong;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMaxDataModificationId() {
/* 265 */     return this.maxDataModificationId[0];
/*     */   }
/*     */   
/*     */   int getQueryLevel() {
/* 269 */     return this.queryLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Table getTable() {
/* 279 */     return this.table;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getType() {
/* 288 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HashSet<Column> allColumnsForTableFilters(TableFilter[] paramArrayOfTableFilter) {
/* 298 */     HashSet<Column> hashSet = New.hashSet();
/* 299 */     for (byte b = 0; b < paramArrayOfTableFilter.length; b++) {
/* 300 */       if (paramArrayOfTableFilter[b].getSelect() != null) {
/* 301 */         paramArrayOfTableFilter[b].getSelect().isEverything(getColumnsVisitor(hashSet));
/*     */       }
/*     */     } 
/*     */     
/* 305 */     return hashSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ExpressionVisitor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */