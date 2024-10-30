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
/*     */ import org.h2.table.RegularTable;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.ValueHashMap;
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
/*     */ 
/*     */ public class HashIndex
/*     */   extends BaseIndex
/*     */ {
/*     */   private final int indexColumn;
/*     */   private final RegularTable tableData;
/*     */   private ValueHashMap<Long> rows;
/*     */   
/*     */   public HashIndex(RegularTable paramRegularTable, int paramInt, String paramString, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType) {
/*  36 */     initBaseIndex((Table)paramRegularTable, paramInt, paramString, paramArrayOfIndexColumn, paramIndexType);
/*  37 */     this.indexColumn = (paramArrayOfIndexColumn[0]).column.getColumnId();
/*  38 */     this.tableData = paramRegularTable;
/*  39 */     reset();
/*     */   }
/*     */   
/*     */   private void reset() {
/*  43 */     this.rows = ValueHashMap.newInstance();
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/*  48 */     reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/*  53 */     Value value = paramRow.getValue(this.indexColumn);
/*  54 */     Object object = this.rows.get(value);
/*  55 */     if (object != null)
/*     */     {
/*  57 */       throw getDuplicateKeyException(value.toString());
/*     */     }
/*  59 */     this.rows.put(value, Long.valueOf(paramRow.getKey()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/*  64 */     this.rows.remove(paramRow.getValue(this.indexColumn));
/*     */   }
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*     */     Row row;
/*  69 */     if (paramSearchRow1 == null || paramSearchRow2 == null)
/*     */     {
/*  71 */       throw DbException.throwInternalError();
/*     */     }
/*  73 */     Value value = paramSearchRow1.getValue(this.indexColumn);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     value = value.convertTo(this.tableData.getColumn(this.indexColumn).getType());
/*     */     
/*  82 */     Long long_ = (Long)this.rows.get(value);
/*  83 */     if (long_ == null) {
/*  84 */       row = null;
/*     */     } else {
/*  86 */       row = this.tableData.getRow(paramSession, long_.intValue());
/*     */     } 
/*  88 */     return new SingleRowCursor(row);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/*  93 */     return getRowCountApproximation();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/*  98 */     return this.rows.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 103 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 120 */     for (Column column : this.columns) {
/* 121 */       int i = column.getColumnId();
/* 122 */       int j = paramArrayOfint[i];
/* 123 */       if ((j & 0x1) != 1) {
/* 124 */         return 9.223372036854776E18D;
/*     */       }
/*     */     } 
/* 127 */     return 2.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 142 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 147 */     throw DbException.getUnsupportedException("HASH");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canScan() {
/* 152 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\HashIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */