/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.store.PageStore;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.RegularTable;
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
/*     */ 
/*     */ public class PageDelegateIndex
/*     */   extends PageIndex
/*     */ {
/*     */   private final PageDataIndex mainIndex;
/*     */   
/*     */   public PageDelegateIndex(RegularTable paramRegularTable, int paramInt, String paramString, IndexType paramIndexType, PageDataIndex paramPageDataIndex, boolean paramBoolean, Session paramSession) {
/*  30 */     IndexColumn[] arrayOfIndexColumn = IndexColumn.wrap(new Column[] { paramRegularTable.getColumn(paramPageDataIndex.getMainIndexColumn()) });
/*     */     
/*  32 */     initBaseIndex((Table)paramRegularTable, paramInt, paramString, arrayOfIndexColumn, paramIndexType);
/*  33 */     this.mainIndex = paramPageDataIndex;
/*  34 */     if (!this.database.isPersistent() || paramInt < 0) {
/*  35 */       throw DbException.throwInternalError("" + paramString);
/*     */     }
/*  37 */     PageStore pageStore = this.database.getPageStore();
/*  38 */     pageStore.addIndex(this);
/*  39 */     if (paramBoolean) {
/*  40 */       pageStore.addMeta(this, paramSession);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFindNext() {
/*  51 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  66 */     long l1 = this.mainIndex.getKey(paramSearchRow1, Long.MIN_VALUE, Long.MIN_VALUE);
/*     */ 
/*     */     
/*  69 */     long l2 = this.mainIndex.getKey(paramSearchRow2, Long.MAX_VALUE, Long.MIN_VALUE);
/*  70 */     return this.mainIndex.find(paramSession, l1, l2, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/*     */     Cursor cursor;
/*  76 */     if (paramBoolean) {
/*  77 */       cursor = this.mainIndex.find(paramSession, Long.MIN_VALUE, Long.MAX_VALUE, false);
/*     */     } else {
/*  79 */       long l = this.mainIndex.getLastKey();
/*  80 */       cursor = this.mainIndex.find(paramSession, l, l, false);
/*     */     } 
/*  82 */     cursor.next();
/*  83 */     return cursor;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findNext(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  88 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnIndex(Column paramColumn) {
/*  93 */     if (paramColumn.getColumnId() == this.mainIndex.getMainIndexColumn()) {
/*  94 */       return 0;
/*     */     }
/*  96 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 103 */     return (10L * getCostRangeIndex(paramArrayOfint, this.mainIndex.getRowCount(paramSession), paramArrayOfTableFilter, paramInt, paramSortOrder, false, paramHashSet));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/* 119 */     this.mainIndex.setMainIndexColumn(-1);
/* 120 */     paramSession.getDatabase().getPageStore().removeMeta(this, paramSession);
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
/* 135 */     return this.mainIndex.getRowCount(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 140 */     return this.mainIndex.getRowCountApproximation();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 145 */     return this.mainIndex.getDiskSpaceUsed();
/*     */   }
/*     */   
/*     */   public void writeRowCount() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageDelegateIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */