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
/*     */ import org.h2.table.RegularTable;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.New;
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
/*     */ 
/*     */ public class NonUniqueHashIndex
/*     */   extends BaseIndex
/*     */ {
/*     */   private final int indexColumn;
/*     */   private ValueHashMap<ArrayList<Long>> rows;
/*     */   private final RegularTable tableData;
/*     */   private long rowCount;
/*     */   
/*     */   public NonUniqueHashIndex(RegularTable paramRegularTable, int paramInt, String paramString, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType) {
/*  40 */     initBaseIndex((Table)paramRegularTable, paramInt, paramString, paramArrayOfIndexColumn, paramIndexType);
/*  41 */     this.indexColumn = (paramArrayOfIndexColumn[0]).column.getColumnId();
/*  42 */     this.tableData = paramRegularTable;
/*  43 */     reset();
/*     */   }
/*     */   
/*     */   private void reset() {
/*  47 */     this.rows = ValueHashMap.newInstance();
/*  48 */     this.rowCount = 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/*  53 */     reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/*  58 */     Value value = paramRow.getValue(this.indexColumn);
/*  59 */     ArrayList<Long> arrayList = (ArrayList)this.rows.get(value);
/*  60 */     if (arrayList == null) {
/*  61 */       arrayList = New.arrayList();
/*  62 */       this.rows.put(value, arrayList);
/*     */     } 
/*  64 */     arrayList.add(Long.valueOf(paramRow.getKey()));
/*  65 */     this.rowCount++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/*  70 */     if (this.rowCount == 1L) {
/*     */       
/*  72 */       reset();
/*     */     } else {
/*  74 */       Value value = paramRow.getValue(this.indexColumn);
/*  75 */       ArrayList arrayList = (ArrayList)this.rows.get(value);
/*  76 */       if (arrayList.size() == 1) {
/*     */         
/*  78 */         this.rows.remove(value);
/*     */       } else {
/*  80 */         arrayList.remove(Long.valueOf(paramRow.getKey()));
/*     */       } 
/*  82 */       this.rowCount--;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  88 */     if (paramSearchRow1 == null || paramSearchRow2 == null) {
/*  89 */       throw DbException.throwInternalError();
/*     */     }
/*  91 */     if (paramSearchRow1 != paramSearchRow2 && 
/*  92 */       compareKeys(paramSearchRow1, paramSearchRow2) != 0) {
/*  93 */       throw DbException.throwInternalError();
/*     */     }
/*     */     
/*  96 */     Value value = paramSearchRow1.getValue(this.indexColumn);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     value = value.convertTo(this.tableData.getColumn(this.indexColumn).getType());
/* 104 */     ArrayList<Long> arrayList = (ArrayList)this.rows.get(value);
/* 105 */     return new NonUniqueHashCursor(paramSession, this.tableData, arrayList);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 110 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 115 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 120 */     return 0L;
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
/* 137 */     for (Column column : this.columns) {
/* 138 */       int i = column.getColumnId();
/* 139 */       int j = paramArrayOfint[i];
/* 140 */       if ((j & 0x1) != 1) {
/* 141 */         return 9.223372036854776E18D;
/*     */       }
/*     */     } 
/* 144 */     return 2.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 154 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 159 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 164 */     throw DbException.getUnsupportedException("HASH");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canScan() {
/* 169 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\NonUniqueHashIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */