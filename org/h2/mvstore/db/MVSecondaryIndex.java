/*     */ package org.h2.mvstore.db;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.TreeSet;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.BaseIndex;
/*     */ import org.h2.index.Cursor;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.MVMap;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.store.DataHandler;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.New;
/*     */ import org.h2.value.CompareMode;
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
/*     */ 
/*     */ public class MVSecondaryIndex
/*     */   extends BaseIndex
/*     */   implements MVIndex
/*     */ {
/*     */   final MVTable mvTable;
/*     */   private final int keyColumns;
/*     */   private final String mapName;
/*     */   private TransactionStore.TransactionMap<Value, Value> dataMap;
/*     */   
/*     */   public MVSecondaryIndex(Database paramDatabase, MVTable paramMVTable, int paramInt, String paramString, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType) {
/*  53 */     this.mvTable = paramMVTable;
/*  54 */     initBaseIndex((Table)paramMVTable, paramInt, paramString, paramArrayOfIndexColumn, paramIndexType);
/*  55 */     if (!this.database.isStarting()) {
/*  56 */       checkIndexColumnTypes(paramArrayOfIndexColumn);
/*     */     }
/*     */ 
/*     */     
/*  60 */     this.keyColumns = paramArrayOfIndexColumn.length + 1;
/*  61 */     this.mapName = "index." + getId();
/*  62 */     int[] arrayOfInt = new int[this.keyColumns];
/*  63 */     for (byte b = 0; b < paramArrayOfIndexColumn.length; b++) {
/*  64 */       arrayOfInt[b] = (paramArrayOfIndexColumn[b]).sortType;
/*     */     }
/*  66 */     arrayOfInt[this.keyColumns - 1] = 0;
/*  67 */     ValueDataType valueDataType1 = new ValueDataType(paramDatabase.getCompareMode(), (DataHandler)paramDatabase, arrayOfInt);
/*     */     
/*  69 */     ValueDataType valueDataType2 = new ValueDataType(null, null, null);
/*  70 */     TransactionStore.Transaction transaction = this.mvTable.getTransaction((Session)null);
/*  71 */     this.dataMap = transaction.openMap(this.mapName, valueDataType1, valueDataType2);
/*  72 */     transaction.commit();
/*  73 */     if (!valueDataType1.equals(this.dataMap.getKeyType())) {
/*  74 */       throw DbException.throwInternalError("Incompatible key type");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRowsToBuffer(List<Row> paramList, String paramString) {
/*  80 */     MVMap<Value, Value> mVMap = openMap(paramString);
/*  81 */     for (Row row : paramList) {
/*  82 */       ValueArray valueArray = convertToKey((SearchRow)row);
/*  83 */       mVMap.put(valueArray, ValueNull.INSTANCE);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addBufferedRows(List<String> paramList) {
/*  89 */     ArrayList arrayList = New.arrayList(paramList);
/*  90 */     final CompareMode compareMode = this.database.getCompareMode();
/*     */     class Source
/*     */       implements Comparable<Source>
/*     */     {
/*     */       Value value;
/*     */       
/*     */       Iterator<Value> next;
/*     */       int sourceId;
/*     */       
/*     */       public int compareTo(Source param1Source) {
/* 100 */         int i = this.value.compareTo(param1Source.value, compareMode);
/* 101 */         if (i == 0) {
/* 102 */           i = this.sourceId - param1Source.sourceId;
/*     */         }
/* 104 */         return i;
/*     */       }
/*     */     };
/* 107 */     TreeSet<Source> treeSet = new TreeSet();
/* 108 */     for (byte b = 0; b < paramList.size(); b++) {
/* 109 */       MVMap<Value, Value> mVMap = openMap(paramList.get(b));
/* 110 */       Iterator<Value> iterator = mVMap.keyIterator(null);
/* 111 */       if (iterator.hasNext()) {
/* 112 */         Source source = new Source();
/* 113 */         source.value = iterator.next();
/* 114 */         source.next = iterator;
/* 115 */         source.sourceId = b;
/* 116 */         treeSet.add(source);
/*     */       } 
/*     */     } 
/*     */     try {
/*     */       while (true) {
/* 121 */         Source source = treeSet.first();
/* 122 */         Value value1 = source.value;
/*     */         
/* 124 */         if (this.indexType.isUnique()) {
/* 125 */           Value[] arrayOfValue = ((ValueArray)value1).getList();
/*     */           
/* 127 */           arrayOfValue = (Value[])arrayOfValue.clone();
/* 128 */           arrayOfValue[this.keyColumns - 1] = (Value)ValueLong.get(Long.MIN_VALUE);
/* 129 */           ValueArray valueArray = ValueArray.get(arrayOfValue);
/* 130 */           SearchRow searchRow = convertToSearchRow((ValueArray)value1);
/* 131 */           checkUnique(searchRow, this.dataMap, valueArray);
/*     */         } 
/*     */         
/* 134 */         this.dataMap.putCommitted(value1, ValueNull.INSTANCE);
/*     */         
/* 136 */         Iterator<Value> iterator = source.next;
/* 137 */         if (!iterator.hasNext()) {
/* 138 */           treeSet.remove(source);
/* 139 */           if (treeSet.size() == 0)
/*     */             break; 
/*     */           continue;
/*     */         } 
/* 143 */         Value value2 = iterator.next();
/* 144 */         treeSet.remove(source);
/* 145 */         source.value = value2;
/* 146 */         treeSet.add(source);
/*     */       } 
/*     */     } finally {
/*     */       
/* 150 */       for (String str : arrayList) {
/* 151 */         MVMap<Value, Value> mVMap = openMap(str);
/* 152 */         mVMap.getStore().removeMap(mVMap);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private MVMap<Value, Value> openMap(String paramString) {
/* 158 */     int[] arrayOfInt = new int[this.keyColumns];
/* 159 */     for (byte b = 0; b < this.indexColumns.length; b++) {
/* 160 */       arrayOfInt[b] = (this.indexColumns[b]).sortType;
/*     */     }
/* 162 */     arrayOfInt[this.keyColumns - 1] = 0;
/* 163 */     ValueDataType valueDataType1 = new ValueDataType(this.database.getCompareMode(), (DataHandler)this.database, arrayOfInt);
/*     */     
/* 165 */     ValueDataType valueDataType2 = new ValueDataType(null, null, null);
/* 166 */     MVMap.Builder builder = (new MVMap.Builder()).keyType(valueDataType1).valueType(valueDataType2);
/*     */     
/* 168 */     MVMap<Value, Value> mVMap = this.database.getMvStore().getStore().openMap(paramString, (MVMap.MapBuilder)builder);
/*     */     
/* 170 */     if (!valueDataType1.equals(mVMap.getKeyType())) {
/* 171 */       throw DbException.throwInternalError("Incompatible key type");
/*     */     }
/* 173 */     return mVMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/* 183 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 184 */     ValueArray valueArray1 = convertToKey((SearchRow)paramRow);
/* 185 */     ValueArray valueArray2 = null;
/* 186 */     if (this.indexType.isUnique()) {
/*     */       
/* 188 */       valueArray2 = convertToKey((SearchRow)paramRow);
/* 189 */       valueArray2.getList()[this.keyColumns - 1] = (Value)ValueLong.get(Long.MIN_VALUE);
/* 190 */       checkUnique((SearchRow)paramRow, transactionMap, valueArray2);
/*     */     } 
/*     */     try {
/* 193 */       transactionMap.put(valueArray1, ValueNull.INSTANCE);
/* 194 */     } catch (IllegalStateException illegalStateException) {
/* 195 */       throw this.mvTable.convertException(illegalStateException);
/*     */     } 
/* 197 */     if (this.indexType.isUnique()) {
/* 198 */       Iterator<?> iterator = transactionMap.keyIterator(valueArray2, true);
/* 199 */       while (iterator.hasNext()) {
/* 200 */         ValueArray valueArray = (ValueArray)iterator.next();
/* 201 */         SearchRow searchRow = convertToSearchRow(valueArray);
/* 202 */         if (compareRows((SearchRow)paramRow, searchRow) != 0) {
/*     */           break;
/*     */         }
/* 205 */         if (containsNullAndAllowMultipleNull(searchRow)) {
/*     */           continue;
/*     */         }
/*     */         
/* 209 */         if (transactionMap.isSameTransaction(valueArray)) {
/*     */           continue;
/*     */         }
/* 212 */         if (transactionMap.get(valueArray) != null)
/*     */         {
/* 214 */           throw getDuplicateKeyException(valueArray.toString());
/*     */         }
/* 216 */         throw DbException.get(90131, this.table.getName());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void checkUnique(SearchRow paramSearchRow, TransactionStore.TransactionMap<Value, Value> paramTransactionMap, ValueArray paramValueArray) {
/* 222 */     Iterator<?> iterator = paramTransactionMap.keyIterator(paramValueArray, true);
/* 223 */     while (iterator.hasNext()) {
/* 224 */       ValueArray valueArray = (ValueArray)iterator.next();
/* 225 */       SearchRow searchRow = convertToSearchRow(valueArray);
/* 226 */       if (compareRows(paramSearchRow, searchRow) != 0) {
/*     */         break;
/*     */       }
/* 229 */       if (paramTransactionMap.get(valueArray) != null && 
/* 230 */         !containsNullAndAllowMultipleNull(searchRow)) {
/* 231 */         throw getDuplicateKeyException(valueArray.toString());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/* 239 */     ValueArray valueArray = convertToKey((SearchRow)paramRow);
/* 240 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/*     */     try {
/* 242 */       Value value = transactionMap.remove(valueArray);
/* 243 */       if (value == null) {
/* 244 */         throw DbException.get(90112, getSQL() + ": " + paramRow.getKey());
/*     */       }
/*     */     }
/* 247 */     catch (IllegalStateException illegalStateException) {
/* 248 */       throw this.mvTable.convertException(illegalStateException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 254 */     return find(paramSession, paramSearchRow1, false, paramSearchRow2);
/*     */   }
/*     */   
/*     */   private Cursor find(Session paramSession, SearchRow paramSearchRow1, boolean paramBoolean, SearchRow paramSearchRow2) {
/* 258 */     ValueArray valueArray = convertToKey(paramSearchRow1);
/* 259 */     if (valueArray != null) {
/* 260 */       valueArray.getList()[this.keyColumns - 1] = (Value)ValueLong.get(Long.MIN_VALUE);
/*     */     }
/* 262 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 263 */     if (paramBoolean && valueArray != null) {
/*     */ 
/*     */ 
/*     */       
/* 267 */       int i = 1;
/*     */       while (true) {
/* 269 */         ValueArray valueArray1 = (ValueArray)transactionMap.relativeKey(valueArray, i);
/* 270 */         if (valueArray1 != null) {
/* 271 */           boolean bool = false;
/* 272 */           for (byte b = 0; b < this.keyColumns - 1; b++) {
/* 273 */             int j = this.columnIds[b];
/* 274 */             Value value1 = paramSearchRow1.getValue(j);
/* 275 */             if (value1 == null) {
/*     */               break;
/*     */             }
/* 278 */             Value value2 = valueArray1.getList()[b];
/* 279 */             if (this.database.compare(value2, value1) > 0) {
/* 280 */               bool = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 284 */           if (!bool) {
/* 285 */             i += i;
/* 286 */             valueArray = valueArray1;
/*     */             continue;
/*     */           } 
/*     */         } 
/* 290 */         if (i > 1) {
/* 291 */           i /= 2;
/*     */           continue;
/*     */         } 
/* 294 */         if (transactionMap.get(valueArray1) == null) {
/* 295 */           valueArray = (ValueArray)transactionMap.higherKey(valueArray);
/* 296 */           if (valueArray == null) {
/*     */             break;
/*     */           }
/*     */           continue;
/*     */         } 
/* 301 */         valueArray = valueArray1;
/*     */         break;
/*     */       } 
/* 304 */       if (valueArray == null) {
/* 305 */         return new MVStoreCursor(paramSession, Collections.<Value>emptyList().iterator(), null);
/*     */       }
/*     */     } 
/*     */     
/* 309 */     return new MVStoreCursor(paramSession, (Iterator)transactionMap.keyIterator(valueArray), paramSearchRow2);
/*     */   }
/*     */   
/*     */   private ValueArray convertToKey(SearchRow paramSearchRow) {
/* 313 */     if (paramSearchRow == null) {
/* 314 */       return null;
/*     */     }
/* 316 */     Value[] arrayOfValue = new Value[this.keyColumns];
/* 317 */     for (byte b = 0; b < this.columns.length; b++) {
/* 318 */       Column column = this.columns[b];
/* 319 */       int i = column.getColumnId();
/* 320 */       Value value = paramSearchRow.getValue(i);
/* 321 */       if (value != null) {
/* 322 */         arrayOfValue[b] = value.convertTo(column.getType());
/*     */       }
/*     */     } 
/* 325 */     arrayOfValue[this.keyColumns - 1] = (Value)ValueLong.get(paramSearchRow.getKey());
/* 326 */     return ValueArray.get(arrayOfValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SearchRow convertToSearchRow(ValueArray paramValueArray) {
/* 336 */     Value[] arrayOfValue = paramValueArray.getList();
/* 337 */     Row row = this.mvTable.getTemplateRow();
/* 338 */     row.setKey(arrayOfValue[arrayOfValue.length - 1].getLong());
/* 339 */     Column[] arrayOfColumn = getColumns();
/* 340 */     for (byte b = 0; b < arrayOfValue.length - 1; b++) {
/* 341 */       Column column = arrayOfColumn[b];
/* 342 */       int i = column.getColumnId();
/* 343 */       Value value = arrayOfValue[b];
/* 344 */       row.setValue(i, value);
/*     */     } 
/* 346 */     return (SearchRow)row;
/*     */   }
/*     */ 
/*     */   
/*     */   public MVTable getTable() {
/* 351 */     return this.mvTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/*     */     try {
/* 359 */       return (10L * getCostRangeIndex(paramArrayOfint, this.dataMap.sizeAsLongMax(), paramArrayOfTableFilter, paramInt, paramSortOrder, false, paramHashSet));
/*     */     }
/* 361 */     catch (IllegalStateException illegalStateException) {
/* 362 */       throw DbException.get(90007, illegalStateException, new String[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/* 368 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 369 */     if (!transactionMap.isClosed()) {
/* 370 */       TransactionStore.Transaction transaction = this.mvTable.getTransaction(paramSession);
/* 371 */       transaction.removeMap(transactionMap);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 377 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 378 */     transactionMap.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 383 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 388 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 389 */     Value value = paramBoolean ? transactionMap.firstKey() : transactionMap.lastKey();
/*     */     while (true) {
/* 391 */       if (value == null) {
/* 392 */         return new MVStoreCursor(paramSession, Collections.<Value>emptyList().iterator(), null);
/*     */       }
/*     */       
/* 395 */       if (((ValueArray)value).getList()[0] != ValueNull.INSTANCE) {
/*     */         break;
/*     */       }
/* 398 */       value = paramBoolean ? transactionMap.higherKey(value) : transactionMap.lowerKey(value);
/*     */     } 
/* 400 */     ArrayList<Value> arrayList = New.arrayList();
/* 401 */     arrayList.add(value);
/* 402 */     MVStoreCursor mVStoreCursor = new MVStoreCursor(paramSession, arrayList.iterator(), null);
/* 403 */     mVStoreCursor.next();
/* 404 */     return mVStoreCursor;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/*     */     try {
/* 410 */       return (this.dataMap.sizeAsLongMax() == 0L);
/* 411 */     } catch (IllegalStateException illegalStateException) {
/* 412 */       throw DbException.get(90007, illegalStateException, new String[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 418 */     TransactionStore.TransactionMap<Value, Value> transactionMap = getMap(paramSession);
/* 419 */     return transactionMap.sizeAsLong();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/*     */     try {
/* 425 */       return this.dataMap.sizeAsLongMax();
/* 426 */     } catch (IllegalStateException illegalStateException) {
/* 427 */       throw DbException.get(90007, illegalStateException, new String[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 434 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canFindNext() {
/* 439 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findNext(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 444 */     return find(paramSession, paramSearchRow1, true, paramSearchRow2);
/*     */   }
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
/*     */   TransactionStore.TransactionMap<Value, Value> getMap(Session paramSession) {
/* 459 */     if (paramSession == null) {
/* 460 */       return this.dataMap;
/*     */     }
/* 462 */     TransactionStore.Transaction transaction = this.mvTable.getTransaction(paramSession);
/* 463 */     return this.dataMap.getInstance(transaction, Long.MAX_VALUE);
/*     */   }
/*     */ 
/*     */   
/*     */   class MVStoreCursor
/*     */     implements Cursor
/*     */   {
/*     */     private final Session session;
/*     */     
/*     */     private final Iterator<Value> it;
/*     */     private final SearchRow last;
/*     */     private Value current;
/*     */     private SearchRow searchRow;
/*     */     private Row row;
/*     */     
/*     */     public MVStoreCursor(Session param1Session, Iterator<Value> param1Iterator, SearchRow param1SearchRow) {
/* 479 */       this.session = param1Session;
/* 480 */       this.it = param1Iterator;
/* 481 */       this.last = param1SearchRow;
/*     */     }
/*     */ 
/*     */     
/*     */     public Row get() {
/* 486 */       if (this.row == null) {
/* 487 */         SearchRow searchRow = getSearchRow();
/* 488 */         if (searchRow != null) {
/* 489 */           this.row = MVSecondaryIndex.this.mvTable.getRow(this.session, searchRow.getKey());
/*     */         }
/*     */       } 
/* 492 */       return this.row;
/*     */     }
/*     */ 
/*     */     
/*     */     public SearchRow getSearchRow() {
/* 497 */       if (this.searchRow == null && 
/* 498 */         this.current != null) {
/* 499 */         this.searchRow = MVSecondaryIndex.this.convertToSearchRow((ValueArray)this.current);
/*     */       }
/*     */       
/* 502 */       return this.searchRow;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean next() {
/* 507 */       this.current = this.it.hasNext() ? this.it.next() : null;
/* 508 */       this.searchRow = null;
/* 509 */       if (this.current != null && 
/* 510 */         this.last != null && MVSecondaryIndex.this.compareRows(getSearchRow(), this.last) > 0) {
/* 511 */         this.searchRow = null;
/* 512 */         this.current = null;
/*     */       } 
/*     */       
/* 515 */       this.row = null;
/* 516 */       return (this.current != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean previous() {
/* 521 */       throw DbException.getUnsupportedException("previous");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\db\MVSecondaryIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */