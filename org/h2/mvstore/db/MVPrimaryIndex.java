/*     */ package org.h2.mvstore.db;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.BaseIndex;
/*     */ import org.h2.index.Cursor;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.store.DataHandler;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueArray;
/*     */ import org.h2.value.ValueLong;
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
/*     */ 
/*     */ public class MVPrimaryIndex
/*     */   extends BaseIndex
/*     */ {
/*  43 */   static final ValueLong MIN = ValueLong.get(Long.MIN_VALUE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   static final ValueLong MAX = ValueLong.get(Long.MAX_VALUE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   static final ValueLong ZERO = ValueLong.get(0L);
/*     */   
/*     */   private final MVTable mvTable;
/*     */   private final String mapName;
/*     */   private TransactionStore.TransactionMap<Value, Value> dataMap;
/*     */   private long lastKey;
/*  59 */   private int mainIndexColumn = -1;
/*     */ 
/*     */   
/*     */   public MVPrimaryIndex(Database paramDatabase, MVTable paramMVTable, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType) {
/*  63 */     this.mvTable = paramMVTable;
/*  64 */     initBaseIndex((Table)paramMVTable, paramInt, paramMVTable.getName() + "_DATA", paramArrayOfIndexColumn, paramIndexType);
/*  65 */     int[] arrayOfInt = new int[paramArrayOfIndexColumn.length];
/*  66 */     for (byte b = 0; b < paramArrayOfIndexColumn.length; b++) {
/*  67 */       arrayOfInt[b] = 0;
/*     */     }
/*  69 */     ValueDataType valueDataType1 = new ValueDataType(null, null, null);
/*  70 */     ValueDataType valueDataType2 = new ValueDataType(paramDatabase.getCompareMode(), (DataHandler)paramDatabase, arrayOfInt);
/*     */     
/*  72 */     this.mapName = "table." + getId();
/*  73 */     TransactionStore.Transaction transaction = this.mvTable.getTransaction((Session)null);
/*  74 */     this.dataMap = transaction.openMap(this.mapName, valueDataType1, valueDataType2);
/*  75 */     transaction.commit();
/*  76 */     if (!paramMVTable.isPersistData()) {
/*  77 */       this.dataMap.map.setVolatile(true);
/*     */     }
/*  79 */     Value value = this.dataMap.lastKey();
/*  80 */     this.lastKey = (value == null) ? 0L : value.getLong();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  85 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/*  90 */     return this.table.getSQL() + ".tableScan";
/*     */   }
/*     */   
/*     */   public void setMainIndexColumn(int paramInt) {
/*  94 */     this.mainIndexColumn = paramInt;
/*     */   }
/*     */   
/*     */   public int getMainIndexColumn() {
/*  98 */     return this.mainIndexColumn;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/* 108 */     if (this.mainIndexColumn == -1) {
/* 109 */       if (paramRow.getKey() == 0L) {
/* 110 */         paramRow.setKey(++this.lastKey);
/*     */       }
/*     */     } else {
/* 113 */       long l = paramRow.getValue(this.mainIndexColumn).getLong();
/* 114 */       paramRow.setKey(l);
/*     */     } 
/*     */     
/* 117 */     if (this.mvTable.getContainsLargeObject()) {
/* 118 */       byte b; int i; for (b = 0, i = paramRow.getColumnCount(); b < i; b++) {
/* 119 */         Value value1 = paramRow.getValue(b);
/* 120 */         Value value2 = value1.copy((DataHandler)this.database, getId());
/* 121 */         if (value2.isLinkedToTable()) {
/* 122 */           paramSession.removeAtCommitStop(value2);
/*     */         }
/* 124 */         if (value1 != value2) {
/* 125 */           paramRow.setValue(b, value2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 131 */     ValueLong valueLong = ValueLong.get(paramRow.getKey());
/* 132 */     Value value = transactionMap.getLatest(valueLong);
/* 133 */     if (value != null) {
/* 134 */       String str = "PRIMARY KEY ON " + this.table.getSQL();
/* 135 */       if (this.mainIndexColumn >= 0 && this.mainIndexColumn < this.indexColumns.length) {
/* 136 */         str = str + "(" + this.indexColumns[this.mainIndexColumn].getSQL() + ")";
/*     */       }
/* 138 */       DbException dbException = DbException.get(23505, str);
/* 139 */       dbException.setSource(this);
/* 140 */       throw dbException;
/*     */     } 
/*     */     try {
/* 143 */       transactionMap.put(valueLong, ValueArray.get(paramRow.getValueList()));
/* 144 */     } catch (IllegalStateException illegalStateException) {
/* 145 */       throw this.mvTable.convertException(illegalStateException);
/*     */     } 
/* 147 */     this.lastKey = Math.max(this.lastKey, paramRow.getKey());
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/* 152 */     if (this.mvTable.getContainsLargeObject()) {
/* 153 */       byte b; int i; for (b = 0, i = paramRow.getColumnCount(); b < i; b++) {
/* 154 */         Value value = paramRow.getValue(b);
/* 155 */         if (value.isLinkedToTable()) {
/* 156 */           paramSession.removeAtCommit(value);
/*     */         }
/*     */       } 
/*     */     } 
/* 160 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/*     */     try {
/* 162 */       Value value = transactionMap.remove(ValueLong.get(paramRow.getKey()));
/* 163 */       if (value == null) {
/* 164 */         throw DbException.get(90112, getSQL() + ": " + paramRow.getKey());
/*     */       }
/*     */     }
/* 167 */     catch (IllegalStateException illegalStateException) {
/* 168 */       throw this.mvTable.convertException(illegalStateException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*     */     ValueLong valueLong1, valueLong2;
/* 175 */     if (paramSearchRow1 == null) {
/* 176 */       valueLong1 = MIN;
/* 177 */     } else if (this.mainIndexColumn < 0) {
/* 178 */       valueLong1 = ValueLong.get(paramSearchRow1.getKey());
/*     */     } else {
/* 180 */       ValueLong valueLong = (ValueLong)paramSearchRow1.getValue(this.mainIndexColumn);
/* 181 */       if (valueLong == null) {
/* 182 */         valueLong1 = ValueLong.get(paramSearchRow1.getKey());
/*     */       } else {
/* 184 */         valueLong1 = valueLong;
/*     */       } 
/*     */     } 
/* 187 */     if (paramSearchRow2 == null) {
/* 188 */       valueLong2 = MAX;
/* 189 */     } else if (this.mainIndexColumn < 0) {
/* 190 */       valueLong2 = ValueLong.get(paramSearchRow2.getKey());
/*     */     } else {
/* 192 */       ValueLong valueLong = (ValueLong)paramSearchRow2.getValue(this.mainIndexColumn);
/* 193 */       if (valueLong == null) {
/* 194 */         valueLong2 = ValueLong.get(paramSearchRow2.getKey());
/*     */       } else {
/* 196 */         valueLong2 = valueLong;
/*     */       } 
/*     */     } 
/* 199 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 200 */     return new MVStoreCursor(paramSession, (Iterator)transactionMap.entryIterator(valueLong1), valueLong2);
/*     */   }
/*     */ 
/*     */   
/*     */   public MVTable getTable() {
/* 205 */     return this.mvTable;
/*     */   }
/*     */ 
/*     */   
/*     */   public Row getRow(Session paramSession, long paramLong) {
/* 210 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 211 */     Value value = transactionMap.get(ValueLong.get(paramLong));
/* 212 */     ValueArray valueArray = (ValueArray)value;
/* 213 */     Row row = paramSession.createRow(valueArray.getList(), 0);
/* 214 */     row.setKey(paramLong);
/* 215 */     return row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/*     */     try {
/* 223 */       return (10L * getCostRangeIndex(paramArrayOfint, this.dataMap.sizeAsLongMax(), paramArrayOfTableFilter, paramInt, paramSortOrder, true, paramHashSet));
/*     */     }
/* 225 */     catch (IllegalStateException illegalStateException) {
/* 226 */       throw DbException.get(90007, illegalStateException, new String[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumnIndex(Column paramColumn) {
/* 233 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/* 238 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 239 */     if (!transactionMap.isClosed()) {
/* 240 */       TransactionStore.Transaction transaction = this.mvTable.getTransaction(paramSession);
/* 241 */       transaction.removeMap(transactionMap);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 247 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 248 */     if (this.mvTable.getContainsLargeObject()) {
/* 249 */       this.database.getLobStorage().removeAllForTable(this.table.getId());
/*     */     }
/* 251 */     transactionMap.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 256 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 261 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 262 */     ValueLong valueLong = paramBoolean ? (ValueLong)transactionMap.firstKey() : (ValueLong)transactionMap.lastKey();
/* 263 */     if (valueLong == null) {
/* 264 */       return new MVStoreCursor(paramSession, Collections.<Map.Entry<Value, Value>>emptyList().iterator(), null);
/*     */     }
/*     */     
/* 267 */     Value value = transactionMap.get(valueLong);
/* 268 */     DataUtils.MapEntry mapEntry = new DataUtils.MapEntry(valueLong, value);
/*     */     
/* 270 */     List<Map.Entry> list = Arrays.asList(new Map.Entry[] { (Map.Entry)mapEntry });
/* 271 */     MVStoreCursor mVStoreCursor = new MVStoreCursor(paramSession, (Iterator)list.iterator(), valueLong);
/* 272 */     mVStoreCursor.next();
/* 273 */     return mVStoreCursor;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 278 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 283 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 284 */     return transactionMap.sizeAsLong();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRowCountMax() {
/*     */     try {
/* 294 */       return this.dataMap.sizeAsLongMax();
/* 295 */     } catch (IllegalStateException illegalStateException) {
/* 296 */       throw DbException.get(90007, illegalStateException, new String[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 302 */     return getRowCountMax();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 308 */     return 0L;
/*     */   }
/*     */   
/*     */   public String getMapName() {
/* 312 */     return this.mapName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ValueLong getKey(SearchRow paramSearchRow, ValueLong paramValueLong1, ValueLong paramValueLong2) {
/* 329 */     if (paramSearchRow == null) {
/* 330 */       return paramValueLong1;
/*     */     }
/* 332 */     Value value = paramSearchRow.getValue(this.mainIndexColumn);
/* 333 */     if (value == null)
/* 334 */       throw DbException.throwInternalError(paramSearchRow.toString()); 
/* 335 */     if (value == ValueNull.INSTANCE) {
/* 336 */       return paramValueLong2;
/*     */     }
/* 338 */     return (ValueLong)value.convertTo(5);
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
/*     */   Cursor find(Session paramSession, ValueLong paramValueLong1, ValueLong paramValueLong2) {
/* 350 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 351 */     return new MVStoreCursor(paramSession, (Iterator)transactionMap.entryIterator(paramValueLong1), paramValueLong2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRowIdIndex() {
/* 356 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TransactionStore.TransactionMap<Value, Value> getMap(Session paramSession) {
/* 366 */     if (paramSession == null) {
/* 367 */       return this.dataMap;
/*     */     }
/* 369 */     TransactionStore.Transaction transaction = this.mvTable.getTransaction(paramSession);
/* 370 */     return this.dataMap.getInstance(transaction, Long.MAX_VALUE);
/*     */   }
/*     */ 
/*     */   
/*     */   class MVStoreCursor
/*     */     implements Cursor
/*     */   {
/*     */     private final Session session;
/*     */     
/*     */     private final Iterator<Map.Entry<Value, Value>> it;
/*     */     private final ValueLong last;
/*     */     private Map.Entry<Value, Value> current;
/*     */     private Row row;
/*     */     
/*     */     public MVStoreCursor(Session param1Session, Iterator<Map.Entry<Value, Value>> param1Iterator, ValueLong param1ValueLong) {
/* 385 */       this.session = param1Session;
/* 386 */       this.it = param1Iterator;
/* 387 */       this.last = param1ValueLong;
/*     */     }
/*     */ 
/*     */     
/*     */     public Row get() {
/* 392 */       if (this.row == null && 
/* 393 */         this.current != null) {
/* 394 */         ValueArray valueArray = (ValueArray)this.current.getValue();
/* 395 */         this.row = this.session.createRow(valueArray.getList(), 0);
/* 396 */         this.row.setKey(((Value)this.current.getKey()).getLong());
/*     */       } 
/*     */       
/* 399 */       return this.row;
/*     */     }
/*     */ 
/*     */     
/*     */     public SearchRow getSearchRow() {
/* 404 */       return (SearchRow)get();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean next() {
/* 409 */       this.current = this.it.hasNext() ? this.it.next() : null;
/* 410 */       if (this.current != null && ((Value)this.current.getKey()).getLong() > this.last.getLong()) {
/* 411 */         this.current = null;
/*     */       }
/* 413 */       this.row = null;
/* 414 */       return (this.current != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean previous() {
/* 419 */       throw DbException.getUnsupportedException("previous");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\db\MVPrimaryIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */