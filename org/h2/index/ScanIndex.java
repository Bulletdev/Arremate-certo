/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class ScanIndex
/*     */   extends BaseIndex
/*     */ {
/*  35 */   private long firstFree = -1L;
/*  36 */   private ArrayList<Row> rows = New.arrayList();
/*     */   
/*     */   private final RegularTable tableData;
/*     */   private int rowCountDiff;
/*     */   private final HashMap<Integer, Integer> sessionRowCount;
/*     */   private HashSet<Row> delta;
/*     */   private long rowCount;
/*     */   
/*     */   public ScanIndex(RegularTable paramRegularTable, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType) {
/*  45 */     initBaseIndex((Table)paramRegularTable, paramInt, paramRegularTable.getName() + "_DATA", paramArrayOfIndexColumn, paramIndexType);
/*  46 */     if (this.database.isMultiVersion()) {
/*  47 */       this.sessionRowCount = New.hashMap();
/*     */     } else {
/*  49 */       this.sessionRowCount = null;
/*     */     } 
/*  51 */     this.tableData = paramRegularTable;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/*  56 */     truncate(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/*  61 */     this.rows = New.arrayList();
/*  62 */     this.firstFree = -1L;
/*  63 */     if (this.tableData.getContainsLargeObject() && this.tableData.isPersistData()) {
/*  64 */       this.database.getLobStorage().removeAllForTable(this.table.getId());
/*     */     }
/*  66 */     this.tableData.setRowCount(0L);
/*  67 */     this.rowCount = 0L;
/*  68 */     this.rowCountDiff = 0;
/*  69 */     if (this.database.isMultiVersion()) {
/*  70 */       this.sessionRowCount.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Row getRow(Session paramSession, long paramLong) {
/*  86 */     return this.rows.get((int)paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/*  92 */     if (this.firstFree == -1L) {
/*  93 */       int i = this.rows.size();
/*  94 */       paramRow.setKey(i);
/*  95 */       this.rows.add(paramRow);
/*     */     } else {
/*  97 */       long l = this.firstFree;
/*  98 */       Row row = this.rows.get((int)l);
/*  99 */       this.firstFree = row.getKey();
/* 100 */       paramRow.setKey(l);
/* 101 */       this.rows.set((int)l, paramRow);
/*     */     } 
/* 103 */     paramRow.setDeleted(false);
/* 104 */     if (this.database.isMultiVersion()) {
/* 105 */       if (this.delta == null) {
/* 106 */         this.delta = New.hashSet();
/*     */       }
/* 108 */       boolean bool = this.delta.remove(paramRow);
/* 109 */       if (!bool) {
/* 110 */         this.delta.add(paramRow);
/*     */       }
/* 112 */       incrementRowCount(paramSession.getId(), 1);
/*     */     } 
/* 114 */     this.rowCount++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void commit(int paramInt, Row paramRow) {
/* 119 */     if (this.database.isMultiVersion()) {
/* 120 */       if (this.delta != null) {
/* 121 */         this.delta.remove(paramRow);
/*     */       }
/* 123 */       incrementRowCount(paramRow.getSessionId(), (paramInt == 1) ? 1 : -1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void incrementRowCount(int paramInt1, int paramInt2) {
/* 129 */     if (this.database.isMultiVersion()) {
/* 130 */       Integer integer1 = Integer.valueOf(paramInt1);
/* 131 */       Integer integer2 = this.sessionRowCount.get(integer1);
/* 132 */       byte b = (integer2 == null) ? 0 : integer2.intValue();
/* 133 */       this.sessionRowCount.put(integer1, Integer.valueOf(b + paramInt2));
/* 134 */       this.rowCountDiff += paramInt2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/* 141 */     if (!this.database.isMultiVersion() && this.rowCount == 1L) {
/* 142 */       this.rows = New.arrayList();
/* 143 */       this.firstFree = -1L;
/*     */     } else {
/* 145 */       Row row = paramSession.createRow(null, 1);
/* 146 */       row.setKey(this.firstFree);
/* 147 */       long l = paramRow.getKey();
/* 148 */       if (this.rows.size() <= l) {
/* 149 */         throw DbException.get(90112, this.rows.size() + ": " + l);
/*     */       }
/*     */       
/* 152 */       this.rows.set((int)l, row);
/* 153 */       this.firstFree = l;
/*     */     } 
/* 155 */     if (this.database.isMultiVersion()) {
/*     */       
/* 157 */       paramRow.setDeleted(true);
/* 158 */       if (this.delta == null) {
/* 159 */         this.delta = New.hashSet();
/*     */       }
/* 161 */       boolean bool = this.delta.remove(paramRow);
/* 162 */       if (!bool) {
/* 163 */         this.delta.add(paramRow);
/*     */       }
/* 165 */       incrementRowCount(paramSession.getId(), -1);
/*     */     } 
/* 167 */     this.rowCount--;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 172 */     return new ScanCursor(paramSession, this, this.database.isMultiVersion());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 179 */     return (this.tableData.getRowCountApproximation() + 1000L);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 184 */     if (this.database.isMultiVersion()) {
/* 185 */       Integer integer = this.sessionRowCount.get(Integer.valueOf(paramSession.getId()));
/* 186 */       long l = (integer == null) ? 0L : integer.intValue();
/* 187 */       l += this.rowCount;
/* 188 */       l -= this.rowCountDiff;
/* 189 */       return l;
/*     */     } 
/* 191 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Row getNextRow(Row paramRow) {
/*     */     long l;
/* 202 */     if (paramRow == null) {
/* 203 */       l = -1L;
/*     */     } else {
/* 205 */       l = paramRow.getKey();
/*     */     } 
/*     */     while (true) {
/* 208 */       l++;
/* 209 */       if (l >= this.rows.size()) {
/* 210 */         return null;
/*     */       }
/* 212 */       paramRow = this.rows.get((int)l);
/* 213 */       if (!paramRow.isEmpty()) {
/* 214 */         return paramRow;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumnIndex(Column paramColumn) {
/* 222 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/* 227 */     throw DbException.getUnsupportedException("SCAN");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 232 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 237 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 242 */     throw DbException.getUnsupportedException("SCAN");
/*     */   }
/*     */   
/*     */   Iterator<Row> getDelta() {
/* 246 */     if (this.delta == null) {
/* 247 */       List<?> list = Collections.emptyList();
/* 248 */       return (Iterator)list.iterator();
/*     */     } 
/* 250 */     return this.delta.iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 255 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 260 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 265 */     return this.table.getSQL() + ".tableScan";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\ScanIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */