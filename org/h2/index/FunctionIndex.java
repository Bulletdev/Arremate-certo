/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.FunctionTable;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FunctionIndex
/*     */   extends BaseIndex
/*     */ {
/*     */   private final FunctionTable functionTable;
/*     */   
/*     */   public FunctionIndex(FunctionTable paramFunctionTable, IndexColumn[] paramArrayOfIndexColumn) {
/*  28 */     initBaseIndex((Table)paramFunctionTable, 0, (String)null, paramArrayOfIndexColumn, IndexType.createNonUnique(true));
/*  29 */     this.functionTable = paramFunctionTable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/*  39 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/*  44 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  49 */     if (this.functionTable.isBufferResultSetToLocalTemp()) {
/*  50 */       return new FunctionCursor(paramSession, this.functionTable.getResult(paramSession));
/*     */     }
/*  52 */     return new FunctionCursorResultSet(paramSession, this.functionTable.getResultSet(paramSession));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/*     */     long l;
/*  60 */     if (paramArrayOfint != null) {
/*  61 */       throw DbException.getUnsupportedException("ALIAS");
/*     */     }
/*     */     
/*  64 */     if (this.functionTable.canGetRowCount()) {
/*  65 */       l = this.functionTable.getRowCountApproximation();
/*     */     } else {
/*  67 */       l = (this.database.getSettings()).estimatedFunctionTableRows;
/*     */     } 
/*  69 */     return (l * 10L);
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/*  74 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/*  79 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/*  84 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/*  89 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/*  94 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/*  99 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 104 */     return this.functionTable.getRowCount(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 109 */     return this.functionTable.getRowCountApproximation();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 114 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 119 */     return "function";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canScan() {
/* 124 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\FunctionIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */