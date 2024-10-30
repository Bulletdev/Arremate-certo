/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.RangeTable;
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
/*     */ public class RangeIndex
/*     */   extends BaseIndex
/*     */ {
/*     */   private final RangeTable rangeTable;
/*     */   
/*     */   public RangeIndex(RangeTable paramRangeTable, IndexColumn[] paramArrayOfIndexColumn) {
/*  28 */     initBaseIndex((Table)paramRangeTable, 0, "RANGE_INDEX", paramArrayOfIndexColumn, IndexType.createNonUnique(true));
/*     */     
/*  30 */     this.rangeTable = paramRangeTable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/*  40 */     throw DbException.getUnsupportedException("SYSTEM_RANGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/*  45 */     throw DbException.getUnsupportedException("SYSTEM_RANGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  50 */     long l1 = this.rangeTable.getMin(paramSession), l2 = l1;
/*  51 */     long l3 = this.rangeTable.getMax(paramSession), l4 = l3;
/*  52 */     long l5 = this.rangeTable.getStep(paramSession);
/*     */     try {
/*  54 */       l2 = Math.max(l1, (paramSearchRow1 == null) ? l1 : paramSearchRow1.getValue(0).getLong());
/*  55 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*     */     try {
/*  59 */       l4 = Math.min(l3, (paramSearchRow2 == null) ? l3 : paramSearchRow2.getValue(0).getLong());
/*  60 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*  63 */     return new RangeCursor(paramSession, l2, l4, l5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/*  70 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  75 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/*  80 */     throw DbException.getUnsupportedException("SYSTEM_RANGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/*  85 */     throw DbException.getUnsupportedException("SYSTEM_RANGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/*  90 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/*  95 */     throw DbException.getUnsupportedException("SYSTEM_RANGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 105 */     long l = paramBoolean ? this.rangeTable.getMin(paramSession) : this.rangeTable.getMax(paramSession);
/* 106 */     return new RangeCursor(paramSession, l, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 111 */     return this.rangeTable.getRowCountApproximation();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 116 */     return this.rangeTable.getRowCountApproximation();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 121 */     return 0L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\RangeIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */