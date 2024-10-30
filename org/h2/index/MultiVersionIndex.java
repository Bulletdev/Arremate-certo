/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.RegularTable;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueNull;
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
/*     */ public class MultiVersionIndex
/*     */   implements Index
/*     */ {
/*     */   private final Index base;
/*     */   private final TreeIndex delta;
/*     */   private final RegularTable table;
/*     */   private final Object sync;
/*     */   private final Column firstColumn;
/*     */   
/*     */   public MultiVersionIndex(Index paramIndex, RegularTable paramRegularTable) {
/*  41 */     this.base = paramIndex;
/*  42 */     this.table = paramRegularTable;
/*  43 */     IndexType indexType = IndexType.createNonUnique(false);
/*  44 */     if (paramIndex instanceof SpatialIndex) {
/*  45 */       throw DbException.get(50100, "MVCC & spatial index");
/*     */     }
/*     */     
/*  48 */     this.delta = new TreeIndex(paramRegularTable, -1, "DELTA", paramIndex.getIndexColumns(), indexType);
/*     */     
/*  50 */     this.delta.setMultiVersion(true);
/*  51 */     this.sync = paramIndex.getDatabase();
/*  52 */     this.firstColumn = paramIndex.getColumns()[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/*  57 */     synchronized (this.sync) {
/*  58 */       this.base.add(paramSession, paramRow);
/*  59 */       if (!removeIfExists(paramSession, paramRow))
/*     */       {
/*  61 */         if (paramRow.getSessionId() != 0)
/*     */         {
/*  63 */           this.delta.add(paramSession, paramRow);
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void close(Session paramSession) {
/*  70 */     synchronized (this.sync) {
/*  71 */       this.base.close(paramSession);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(TableFilter paramTableFilter, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  77 */     synchronized (this.sync) {
/*  78 */       Cursor cursor1 = this.base.find(paramTableFilter, paramSearchRow1, paramSearchRow2);
/*  79 */       Cursor cursor2 = this.delta.find(paramTableFilter, paramSearchRow1, paramSearchRow2);
/*  80 */       return new MultiVersionCursor(paramTableFilter.getSession(), this, cursor1, cursor2, this.sync);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  87 */     synchronized (this.sync) {
/*  88 */       Cursor cursor1 = this.base.find(paramSession, paramSearchRow1, paramSearchRow2);
/*  89 */       Cursor cursor2 = this.delta.find(paramSession, paramSearchRow1, paramSearchRow2);
/*  90 */       return new MultiVersionCursor(paramSession, this, cursor1, cursor2, this.sync);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findNext(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  96 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFindNext() {
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 107 */     return (this.base.canGetFirstOrLast() && this.delta.canGetFirstOrLast());
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 112 */     if (paramBoolean) {
/*     */       
/* 114 */       Cursor cursor = find(paramSession, (SearchRow)null, (SearchRow)null);
/* 115 */       while (cursor.next()) {
/* 116 */         SearchRow searchRow = cursor.getSearchRow();
/* 117 */         Value value = searchRow.getValue(this.firstColumn.getColumnId());
/* 118 */         if (value != ValueNull.INSTANCE) {
/* 119 */           return cursor;
/*     */         }
/*     */       } 
/* 122 */       return cursor;
/*     */     } 
/* 124 */     Cursor cursor1 = this.base.findFirstOrLast(paramSession, false);
/* 125 */     Cursor cursor2 = this.delta.findFirstOrLast(paramSession, false);
/* 126 */     MultiVersionCursor multiVersionCursor = new MultiVersionCursor(paramSession, this, cursor1, cursor2, this.sync);
/*     */     
/* 128 */     multiVersionCursor.loadCurrent();
/*     */     
/* 130 */     while (multiVersionCursor.previous()) {
/* 131 */       SearchRow searchRow = multiVersionCursor.getSearchRow();
/* 132 */       if (searchRow == null) {
/*     */         break;
/*     */       }
/* 135 */       Value value = searchRow.getValue(this.firstColumn.getColumnId());
/* 136 */       if (value != ValueNull.INSTANCE) {
/* 137 */         return multiVersionCursor;
/*     */       }
/*     */     } 
/* 140 */     return multiVersionCursor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 147 */     return this.base.getCost(paramSession, paramArrayOfint, paramArrayOfTableFilter, paramInt, paramSortOrder, paramHashSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 152 */     return this.base.needRebuild();
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
/*     */   public boolean isUncommittedFromOtherSession(Session paramSession, Row paramRow) {
/* 164 */     Cursor cursor = this.delta.find(paramSession, (SearchRow)paramRow, (SearchRow)paramRow);
/* 165 */     if (cursor.next()) {
/* 166 */       Row row = cursor.get();
/* 167 */       return (row.getSessionId() != paramSession.getId());
/*     */     } 
/* 169 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean removeIfExists(Session paramSession, Row paramRow) {
/* 174 */     Cursor cursor = this.delta.find(paramSession, (SearchRow)paramRow, (SearchRow)paramRow);
/* 175 */     while (cursor.next()) {
/* 176 */       Row row = cursor.get();
/* 177 */       if (row.getKey() == paramRow.getKey() && row.getVersion() == paramRow.getVersion()) {
/* 178 */         if (row != paramRow && this.table.getScanIndex(paramSession).compareRows((SearchRow)row, (SearchRow)paramRow) != 0) {
/* 179 */           paramRow.setVersion(row.getVersion() + 1); continue;
/*     */         } 
/* 181 */         this.delta.remove(paramSession, row);
/* 182 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/* 191 */     synchronized (this.sync) {
/* 192 */       this.base.remove(paramSession, paramRow);
/* 193 */       if (!removeIfExists(paramSession, paramRow))
/*     */       {
/*     */         
/* 196 */         this.delta.add(paramSession, paramRow);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/* 203 */     synchronized (this.sync) {
/* 204 */       this.base.remove(paramSession);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 210 */     synchronized (this.sync) {
/* 211 */       this.delta.truncate(paramSession);
/* 212 */       this.base.truncate(paramSession);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void commit(int paramInt, Row paramRow) {
/* 218 */     synchronized (this.sync) {
/* 219 */       removeIfExists(null, paramRow);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareRows(SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 225 */     return this.base.compareRows(paramSearchRow1, paramSearchRow2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnIndex(Column paramColumn) {
/* 230 */     return this.base.getColumnIndex(paramColumn);
/*     */   }
/*     */ 
/*     */   
/*     */   public Column[] getColumns() {
/* 235 */     return this.base.getColumns();
/*     */   }
/*     */ 
/*     */   
/*     */   public IndexColumn[] getIndexColumns() {
/* 240 */     return this.base.getIndexColumns();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/* 245 */     return this.base.getCreateSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 250 */     return this.base.getCreateSQLForCopy(paramTable, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/* 255 */     return this.base.getDropSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public IndexType getIndexType() {
/* 260 */     return this.base.getIndexType();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 265 */     return this.base.getPlanSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 270 */     return this.base.getRowCount(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public Table getTable() {
/* 275 */     return this.base.getTable();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 280 */     return this.base.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 285 */     synchronized (this.sync) {
/* 286 */       this.table.removeIndex(this);
/* 287 */       remove(paramSession);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 293 */     return this.base.getSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public Schema getSchema() {
/* 298 */     return this.base.getSchema();
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/* 303 */     this.base.checkRename();
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<DbObject> getChildren() {
/* 308 */     return this.base.getChildren();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getComment() {
/* 313 */     return this.base.getComment();
/*     */   }
/*     */ 
/*     */   
/*     */   public Database getDatabase() {
/* 318 */     return this.base.getDatabase();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getId() {
/* 323 */     return this.base.getId();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 328 */     return this.base.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTemporary() {
/* 333 */     return this.base.isTemporary();
/*     */   }
/*     */ 
/*     */   
/*     */   public void rename(String paramString) {
/* 338 */     this.base.rename(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setComment(String paramString) {
/* 343 */     this.base.setComment(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTemporary(boolean paramBoolean) {
/* 348 */     this.base.setTemporary(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 353 */     return this.base.getRowCountApproximation();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 358 */     return this.base.getDiskSpaceUsed();
/*     */   }
/*     */   
/*     */   public Index getBaseIndex() {
/* 362 */     return this.base;
/*     */   }
/*     */ 
/*     */   
/*     */   public Row getRow(Session paramSession, long paramLong) {
/* 367 */     return this.base.getRow(paramSession, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHidden() {
/* 372 */     return this.base.isHidden();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRowIdIndex() {
/* 377 */     return (this.base.isRowIdIndex() && this.delta.isRowIdIndex());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canScan() {
/* 382 */     return this.base.canScan();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSortedInsertMode(boolean paramBoolean) {
/* 387 */     this.base.setSortedInsertMode(paramBoolean);
/* 388 */     this.delta.setSortedInsertMode(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexLookupBatch createLookupBatch(TableFilter[] paramArrayOfTableFilter, int paramInt) {
/* 394 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\MultiVersionIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */