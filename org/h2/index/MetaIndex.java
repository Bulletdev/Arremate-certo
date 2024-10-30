/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.MetaTable;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MetaIndex
/*     */   extends BaseIndex
/*     */ {
/*     */   private final MetaTable meta;
/*     */   private final boolean scan;
/*     */   
/*     */   public MetaIndex(MetaTable paramMetaTable, IndexColumn[] paramArrayOfIndexColumn, boolean paramBoolean) {
/*  29 */     initBaseIndex((Table)paramMetaTable, 0, null, paramArrayOfIndexColumn, IndexType.createNonUnique(true));
/*  30 */     this.meta = paramMetaTable;
/*  31 */     this.scan = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/*  41 */     throw DbException.getUnsupportedException("META");
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/*  46 */     throw DbException.getUnsupportedException("META");
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  51 */     ArrayList<Row> arrayList = this.meta.generateRows(paramSession, paramSearchRow1, paramSearchRow2);
/*  52 */     return new MetaCursor(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/*  59 */     if (this.scan) {
/*  60 */       return 10000.0D;
/*     */     }
/*  62 */     return getCostRangeIndex(paramArrayOfint, 1000L, paramArrayOfTableFilter, paramInt, paramSortOrder, false, paramHashSet);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/*  68 */     throw DbException.getUnsupportedException("META");
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/*  73 */     throw DbException.getUnsupportedException("META");
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnIndex(Column paramColumn) {
/*  78 */     if (this.scan)
/*     */     {
/*  80 */       return -1;
/*     */     }
/*  82 */     return super.getColumnIndex(paramColumn);
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/*  87 */     throw DbException.getUnsupportedException("META");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  97 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 107 */     throw DbException.getUnsupportedException("META");
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 112 */     return 1000L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 117 */     return 1000L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 122 */     return this.meta.getDiskSpaceUsed();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 127 */     return "meta";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\MetaIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */