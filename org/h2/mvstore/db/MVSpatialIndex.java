/*     */ package org.h2.mvstore.db;
/*     */ 
/*     */ import com.vividsolutions.jts.geom.Envelope;
/*     */ import com.vividsolutions.jts.geom.Geometry;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.BaseIndex;
/*     */ import org.h2.index.Cursor;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.index.SpatialIndex;
/*     */ import org.h2.index.SpatialTreeIndex;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.MVMap;
/*     */ import org.h2.mvstore.rtree.MVRTreeMap;
/*     */ import org.h2.mvstore.rtree.SpatialKey;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueGeometry;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MVSpatialIndex
/*     */   extends BaseIndex
/*     */   implements SpatialIndex, MVIndex
/*     */ {
/*     */   final MVTable mvTable;
/*     */   private final String mapName;
/*     */   private TransactionStore.TransactionMap<SpatialKey, Value> dataMap;
/*     */   private MVRTreeMap<TransactionStore.VersionedValue> spatialMap;
/*     */   
/*     */   public MVSpatialIndex(Database paramDatabase, MVTable paramMVTable, int paramInt, String paramString, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType) {
/*  71 */     if (paramArrayOfIndexColumn.length != 1) {
/*  72 */       throw DbException.getUnsupportedException("Can only index one column");
/*     */     }
/*     */     
/*  75 */     IndexColumn indexColumn = paramArrayOfIndexColumn[0];
/*  76 */     if ((indexColumn.sortType & 0x1) != 0) {
/*  77 */       throw DbException.getUnsupportedException("Cannot index in descending order");
/*     */     }
/*     */     
/*  80 */     if ((indexColumn.sortType & 0x2) != 0) {
/*  81 */       throw DbException.getUnsupportedException("Nulls first is not supported");
/*     */     }
/*     */     
/*  84 */     if ((indexColumn.sortType & 0x4) != 0) {
/*  85 */       throw DbException.getUnsupportedException("Nulls last is not supported");
/*     */     }
/*     */     
/*  88 */     if (indexColumn.column.getType() != 22) {
/*  89 */       throw DbException.getUnsupportedException("Spatial index on non-geometry column, " + indexColumn.column.getCreateSQL());
/*     */     }
/*     */ 
/*     */     
/*  93 */     this.mvTable = paramMVTable;
/*  94 */     initBaseIndex((Table)paramMVTable, paramInt, paramString, paramArrayOfIndexColumn, paramIndexType);
/*  95 */     if (!this.database.isStarting()) {
/*  96 */       checkIndexColumnTypes(paramArrayOfIndexColumn);
/*     */     }
/*  98 */     this.mapName = "index." + getId();
/*  99 */     ValueDataType valueDataType = new ValueDataType(null, null, null);
/* 100 */     TransactionStore.VersionedValueType versionedValueType = new TransactionStore.VersionedValueType(valueDataType);
/* 101 */     MVRTreeMap.Builder builder = (new MVRTreeMap.Builder()).valueType(versionedValueType);
/*     */ 
/*     */     
/* 104 */     this.spatialMap = (MVRTreeMap<TransactionStore.VersionedValue>)paramDatabase.getMvStore().getStore().openMap(this.mapName, (MVMap.MapBuilder)builder);
/* 105 */     TransactionStore.Transaction transaction = this.mvTable.getTransaction((Session)null);
/* 106 */     this.dataMap = transaction.openMap((MVMap)this.spatialMap);
/* 107 */     transaction.commit();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRowsToBuffer(List<Row> paramList, String paramString) {
/* 112 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addBufferedRows(List<String> paramList) {
/* 117 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/* 127 */     TransactionStore.TransactionMap<SpatialKey, Value> transactionMap = getMap(paramSession);
/* 128 */     SpatialKey spatialKey = getKey((SearchRow)paramRow);
/* 129 */     if (this.indexType.isUnique()) {
/*     */       
/* 131 */       MVRTreeMap.RTreeCursor rTreeCursor = this.spatialMap.findContainedKeys(spatialKey);
/* 132 */       Iterator<SpatialKey> iterator = transactionMap.wrapIterator((Iterator<SpatialKey>)rTreeCursor, false);
/* 133 */       while (iterator.hasNext()) {
/* 134 */         SpatialKey spatialKey1 = iterator.next();
/* 135 */         if (spatialKey1.equalsIgnoringId(spatialKey)) {
/* 136 */           throw getDuplicateKeyException(spatialKey.toString());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     try {
/* 141 */       transactionMap.put(spatialKey, ValueLong.get(0L));
/* 142 */     } catch (IllegalStateException illegalStateException) {
/* 143 */       throw this.mvTable.convertException(illegalStateException);
/*     */     } 
/* 145 */     if (this.indexType.isUnique()) {
/*     */       
/* 147 */       MVRTreeMap.RTreeCursor rTreeCursor = this.spatialMap.findContainedKeys(spatialKey);
/* 148 */       Iterator<SpatialKey> iterator = transactionMap.wrapIterator((Iterator<SpatialKey>)rTreeCursor, true);
/* 149 */       while (iterator.hasNext()) {
/* 150 */         SpatialKey spatialKey1 = iterator.next();
/* 151 */         if (!spatialKey1.equalsIgnoringId(spatialKey) || 
/* 152 */           transactionMap.isSameTransaction(spatialKey1)) {
/*     */           continue;
/*     */         }
/* 155 */         transactionMap.remove(spatialKey);
/* 156 */         if (transactionMap.get(spatialKey1) != null)
/*     */         {
/* 158 */           throw getDuplicateKeyException(spatialKey1.toString());
/*     */         }
/* 160 */         throw DbException.get(90131, this.table.getName());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/* 168 */     SpatialKey spatialKey = getKey((SearchRow)paramRow);
/* 169 */     TransactionStore.TransactionMap<SpatialKey, Value> transactionMap = getMap(paramSession);
/*     */     try {
/* 171 */       Value value = transactionMap.remove(spatialKey);
/* 172 */       if (value == null) {
/* 173 */         value = transactionMap.remove(spatialKey);
/* 174 */         throw DbException.get(90112, getSQL() + ": " + paramRow.getKey());
/*     */       }
/*     */     
/* 177 */     } catch (IllegalStateException illegalStateException) {
/* 178 */       throw this.mvTable.convertException(illegalStateException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(TableFilter paramTableFilter, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 184 */     return find(paramTableFilter.getSession());
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 189 */     return find(paramSession);
/*     */   }
/*     */   
/*     */   private Cursor find(Session paramSession) {
/* 193 */     Iterator<SpatialKey> iterator1 = this.spatialMap.keyIterator(null);
/* 194 */     TransactionStore.TransactionMap<SpatialKey, Value> transactionMap = getMap(paramSession);
/* 195 */     Iterator<SpatialKey> iterator2 = transactionMap.wrapIterator(iterator1, false);
/* 196 */     return new MVStoreCursor(paramSession, iterator2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Cursor findByGeometry(TableFilter paramTableFilter, SearchRow paramSearchRow1, SearchRow paramSearchRow2, SearchRow paramSearchRow3) {
/* 202 */     Session session = paramTableFilter.getSession();
/* 203 */     if (paramSearchRow3 == null) {
/* 204 */       return find(session, paramSearchRow1, paramSearchRow2);
/*     */     }
/* 206 */     MVRTreeMap.RTreeCursor rTreeCursor = this.spatialMap.findIntersectingKeys(getKey(paramSearchRow3));
/*     */     
/* 208 */     TransactionStore.TransactionMap<SpatialKey, Value> transactionMap = getMap(session);
/* 209 */     Iterator<SpatialKey> iterator = transactionMap.wrapIterator((Iterator<SpatialKey>)rTreeCursor, false);
/* 210 */     return new MVStoreCursor(session, iterator);
/*     */   }
/*     */   
/*     */   private SpatialKey getKey(SearchRow paramSearchRow) {
/* 214 */     Value value = paramSearchRow.getValue(this.columnIds[0]);
/* 215 */     if (value == ValueNull.INSTANCE) {
/* 216 */       return new SpatialKey(paramSearchRow.getKey(), new float[0]);
/*     */     }
/* 218 */     Geometry geometry = ((ValueGeometry)value.convertTo(22)).getGeometryNoCopy();
/* 219 */     Envelope envelope = geometry.getEnvelopeInternal();
/* 220 */     return new SpatialKey(paramSearchRow.getKey(), new float[] { (float)envelope.getMinX(), (float)envelope.getMaxX(), (float)envelope.getMinY(), (float)envelope.getMaxY() });
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
/*     */   SearchRow getRow(SpatialKey paramSpatialKey) {
/* 232 */     Row row = this.mvTable.getTemplateRow();
/* 233 */     row.setKey(paramSpatialKey.getId());
/* 234 */     return (SearchRow)row;
/*     */   }
/*     */ 
/*     */   
/*     */   public MVTable getTable() {
/* 239 */     return this.mvTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 246 */     return SpatialTreeIndex.getCostRangeIndex(paramArrayOfint, this.table.getRowCountApproximation(), this.columns);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/* 252 */     TransactionStore.TransactionMap<SpatialKey, Value> transactionMap = getMap(paramSession);
/* 253 */     if (!transactionMap.isClosed()) {
/* 254 */       TransactionStore.Transaction transaction = this.mvTable.getTransaction(paramSession);
/* 255 */       transaction.removeMap(transactionMap);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 261 */     TransactionStore.TransactionMap<SpatialKey, Value> transactionMap = getMap(paramSession);
/* 262 */     transactionMap.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 267 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 272 */     if (!paramBoolean) {
/* 273 */       throw DbException.throwInternalError("Spatial Index can only be fetch in ascending order");
/*     */     }
/*     */     
/* 276 */     return find(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/*     */     try {
/* 282 */       return (this.dataMap.sizeAsLongMax() == 0L);
/* 283 */     } catch (IllegalStateException illegalStateException) {
/* 284 */       throw DbException.get(90007, illegalStateException, new String[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 290 */     TransactionStore.TransactionMap<SpatialKey, Value> transactionMap = getMap(paramSession);
/* 291 */     return transactionMap.sizeAsLong();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/*     */     try {
/* 297 */       return this.dataMap.sizeAsLongMax();
/* 298 */     } catch (IllegalStateException illegalStateException) {
/* 299 */       throw DbException.get(90007, illegalStateException, new String[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 306 */     return 0L;
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
/*     */   TransactionStore.TransactionMap<SpatialKey, Value> getMap(Session paramSession) {
/* 321 */     if (paramSession == null) {
/* 322 */       return this.dataMap;
/*     */     }
/* 324 */     TransactionStore.Transaction transaction = this.mvTable.getTransaction(paramSession);
/* 325 */     return this.dataMap.getInstance(transaction, Long.MAX_VALUE);
/*     */   }
/*     */ 
/*     */   
/*     */   class MVStoreCursor
/*     */     implements Cursor
/*     */   {
/*     */     private final Session session;
/*     */     
/*     */     private final Iterator<SpatialKey> it;
/*     */     private SpatialKey current;
/*     */     private SearchRow searchRow;
/*     */     private Row row;
/*     */     
/*     */     public MVStoreCursor(Session param1Session, Iterator<SpatialKey> param1Iterator) {
/* 340 */       this.session = param1Session;
/* 341 */       this.it = param1Iterator;
/*     */     }
/*     */ 
/*     */     
/*     */     public Row get() {
/* 346 */       if (this.row == null) {
/* 347 */         SearchRow searchRow = getSearchRow();
/* 348 */         if (searchRow != null) {
/* 349 */           this.row = MVSpatialIndex.this.mvTable.getRow(this.session, searchRow.getKey());
/*     */         }
/*     */       } 
/* 352 */       return this.row;
/*     */     }
/*     */ 
/*     */     
/*     */     public SearchRow getSearchRow() {
/* 357 */       if (this.searchRow == null && 
/* 358 */         this.current != null) {
/* 359 */         this.searchRow = MVSpatialIndex.this.getRow(this.current);
/*     */       }
/*     */       
/* 362 */       return this.searchRow;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean next() {
/* 367 */       this.current = this.it.next();
/* 368 */       this.searchRow = null;
/* 369 */       this.row = null;
/* 370 */       return (this.current != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean previous() {
/* 375 */       throw DbException.getUnsupportedException("previous");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\db\MVSpatialIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */