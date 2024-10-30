/*     */ package org.h2.mvstore.db;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.BaseIndex;
/*     */ import org.h2.index.Cursor;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.ValueLong;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MVDelegateIndex
/*     */   extends BaseIndex
/*     */   implements MVIndex
/*     */ {
/*     */   private final MVPrimaryIndex mainIndex;
/*     */   
/*     */   public MVDelegateIndex(MVTable paramMVTable, int paramInt, String paramString, MVPrimaryIndex paramMVPrimaryIndex, IndexType paramIndexType) {
/*  33 */     IndexColumn[] arrayOfIndexColumn = IndexColumn.wrap(new Column[] { paramMVTable.getColumn(paramMVPrimaryIndex.getMainIndexColumn()) });
/*     */     
/*  35 */     initBaseIndex((Table)paramMVTable, paramInt, paramString, arrayOfIndexColumn, paramIndexType);
/*  36 */     this.mainIndex = paramMVPrimaryIndex;
/*  37 */     if (paramInt < 0) {
/*  38 */       throw DbException.throwInternalError("" + paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRowsToBuffer(List<Row> paramList, String paramString) {
/*  44 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addBufferedRows(List<String> paramList) {
/*  49 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/*  59 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  69 */     ValueLong valueLong1 = this.mainIndex.getKey(paramSearchRow1, MVPrimaryIndex.MIN, MVPrimaryIndex.MIN);
/*     */ 
/*     */ 
/*     */     
/*  73 */     ValueLong valueLong2 = this.mainIndex.getKey(paramSearchRow2, MVPrimaryIndex.MAX, MVPrimaryIndex.MIN);
/*     */     
/*  75 */     return this.mainIndex.find(paramSession, valueLong1, valueLong2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/*  80 */     return this.mainIndex.findFirstOrLast(paramSession, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnIndex(Column paramColumn) {
/*  85 */     if (paramColumn.getColumnId() == this.mainIndex.getMainIndexColumn()) {
/*  86 */       return 0;
/*     */     }
/*  88 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/*  95 */     return (10L * getCostRangeIndex(paramArrayOfint, this.mainIndex.getRowCountApproximation(), paramArrayOfTableFilter, paramInt, paramSortOrder, true, paramHashSet));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/* 111 */     this.mainIndex.setMainIndexColumn(-1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 126 */     return this.mainIndex.getRowCount(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 131 */     return this.mainIndex.getRowCountApproximation();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 136 */     return 0L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\db\MVDelegateIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */