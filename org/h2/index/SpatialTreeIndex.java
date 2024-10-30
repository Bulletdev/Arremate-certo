/*     */ package org.h2.index;
/*     */ 
/*     */ import com.vividsolutions.jts.geom.Envelope;
/*     */ import com.vividsolutions.jts.geom.Geometry;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.MVMap;
/*     */ import org.h2.mvstore.MVStore;
/*     */ import org.h2.mvstore.db.MVTableEngine;
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
/*     */ public class SpatialTreeIndex
/*     */   extends BaseIndex
/*     */   implements SpatialIndex
/*     */ {
/*     */   private static final String MAP_PREFIX = "RTREE_";
/*     */   private final MVRTreeMap<Long> treeMap;
/*     */   private final MVStore store;
/*     */   private boolean closed;
/*     */   private boolean needRebuild;
/*     */   
/*     */   public SpatialTreeIndex(Table paramTable, int paramInt, String paramString, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType, boolean paramBoolean1, boolean paramBoolean2, Session paramSession) {
/*  61 */     if (paramIndexType.isUnique()) {
/*  62 */       throw DbException.getUnsupportedException("not unique");
/*     */     }
/*  64 */     if (!paramBoolean1 && !paramBoolean2) {
/*  65 */       throw DbException.getUnsupportedException("Non persistent index called with create==false");
/*     */     }
/*     */     
/*  68 */     if (paramArrayOfIndexColumn.length > 1) {
/*  69 */       throw DbException.getUnsupportedException("can only do one column");
/*     */     }
/*     */     
/*  72 */     if (((paramArrayOfIndexColumn[0]).sortType & 0x1) != 0) {
/*  73 */       throw DbException.getUnsupportedException("cannot do descending");
/*     */     }
/*     */     
/*  76 */     if (((paramArrayOfIndexColumn[0]).sortType & 0x2) != 0) {
/*  77 */       throw DbException.getUnsupportedException("cannot do nulls first");
/*     */     }
/*     */     
/*  80 */     if (((paramArrayOfIndexColumn[0]).sortType & 0x4) != 0) {
/*  81 */       throw DbException.getUnsupportedException("cannot do nulls last");
/*     */     }
/*     */     
/*  84 */     initBaseIndex(paramTable, paramInt, paramString, paramArrayOfIndexColumn, paramIndexType);
/*  85 */     this.needRebuild = paramBoolean2;
/*  86 */     this.table = paramTable;
/*  87 */     if (!this.database.isStarting() && 
/*  88 */       (paramArrayOfIndexColumn[0]).column.getType() != 22) {
/*  89 */       throw DbException.getUnsupportedException("spatial index on non-geometry column, " + (paramArrayOfIndexColumn[0]).column.getCreateSQL());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  94 */     if (!paramBoolean1) {
/*     */       
/*  96 */       this.store = MVStore.open(null);
/*  97 */       this.treeMap = (MVRTreeMap<Long>)this.store.openMap("spatialIndex", (MVMap.MapBuilder)new MVRTreeMap.Builder());
/*     */     } else {
/*     */       
/* 100 */       if (paramInt < 0) {
/* 101 */         throw DbException.getUnsupportedException("Persistent index with id<0");
/*     */       }
/*     */       
/* 104 */       MVTableEngine.init(paramSession.getDatabase());
/* 105 */       this.store = paramSession.getDatabase().getMvStore().getStore();
/*     */ 
/*     */       
/* 108 */       this.treeMap = (MVRTreeMap<Long>)this.store.openMap("RTREE_" + getId(), (MVMap.MapBuilder)new MVRTreeMap.Builder());
/*     */       
/* 110 */       if (this.treeMap.isEmpty()) {
/* 111 */         this.needRebuild = true;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {
/* 118 */     this.store.close();
/* 119 */     this.closed = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/* 124 */     if (this.closed) {
/* 125 */       throw DbException.throwInternalError();
/*     */     }
/* 127 */     this.treeMap.add(getKey((SearchRow)paramRow), Long.valueOf(paramRow.getKey()));
/*     */   }
/*     */   
/*     */   private SpatialKey getKey(SearchRow paramSearchRow) {
/* 131 */     if (paramSearchRow == null) {
/* 132 */       return null;
/*     */     }
/* 134 */     Value value = paramSearchRow.getValue(this.columnIds[0]);
/* 135 */     if (value == ValueNull.INSTANCE) {
/* 136 */       return null;
/*     */     }
/* 138 */     Geometry geometry = ((ValueGeometry)value.convertTo(22)).getGeometryNoCopy();
/* 139 */     Envelope envelope = geometry.getEnvelopeInternal();
/* 140 */     return new SpatialKey(paramSearchRow.getKey(), new float[] { (float)envelope.getMinX(), (float)envelope.getMaxX(), (float)envelope.getMinY(), (float)envelope.getMaxY() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/* 147 */     if (this.closed) {
/* 148 */       throw DbException.throwInternalError();
/*     */     }
/* 150 */     if (!this.treeMap.remove(getKey((SearchRow)paramRow), Long.valueOf(paramRow.getKey()))) {
/* 151 */       throw DbException.throwInternalError("row not found");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(TableFilter paramTableFilter, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 157 */     return find(paramTableFilter.getSession());
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 162 */     return find(paramSession);
/*     */   }
/*     */   
/*     */   private Cursor find(Session paramSession) {
/* 166 */     return new SpatialCursor(this.treeMap.keySet().iterator(), this.table, paramSession);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Cursor findByGeometry(TableFilter paramTableFilter, SearchRow paramSearchRow1, SearchRow paramSearchRow2, SearchRow paramSearchRow3) {
/* 172 */     if (paramSearchRow3 == null) {
/* 173 */       return find(paramTableFilter.getSession(), paramSearchRow1, paramSearchRow2);
/*     */     }
/* 175 */     return new SpatialCursor((Iterator<SpatialKey>)this.treeMap.findIntersectingKeys(getKey(paramSearchRow3)), this.table, paramTableFilter.getSession());
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
/*     */ 
/*     */   
/*     */   public static long getCostRangeIndex(int[] paramArrayOfint, long paramLong, Column[] paramArrayOfColumn) {
/* 189 */     if (paramArrayOfColumn.length == 0) {
/* 190 */       return Long.MAX_VALUE;
/*     */     }
/* 192 */     for (Column column : paramArrayOfColumn) {
/* 193 */       int i = column.getColumnId();
/* 194 */       int j = paramArrayOfint[i];
/* 195 */       if ((j & 0x10) != 16) {
/* 196 */         return Long.MAX_VALUE;
/*     */       }
/*     */     } 
/* 199 */     return 2L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 206 */     return getCostRangeIndex(paramArrayOfint, this.table.getRowCountApproximation(), this.columns);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/* 212 */     if (!this.treeMap.isClosed()) {
/* 213 */       this.store.removeMap((MVMap)this.treeMap);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 219 */     this.treeMap.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 229 */     return this.needRebuild;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 234 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 239 */     if (this.closed) {
/* 240 */       throw DbException.throwInternalError();
/*     */     }
/* 242 */     if (!paramBoolean) {
/* 243 */       throw DbException.throwInternalError("Spatial Index can only be fetch by ascending order");
/*     */     }
/*     */     
/* 246 */     return find(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 251 */     return this.treeMap.sizeAsLong();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 256 */     return this.treeMap.sizeAsLong();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 262 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class SpatialCursor
/*     */     implements Cursor
/*     */   {
/*     */     private final Iterator<SpatialKey> it;
/*     */     
/*     */     private SpatialKey current;
/*     */     private final Table table;
/*     */     private Session session;
/*     */     
/*     */     public SpatialCursor(Iterator<SpatialKey> param1Iterator, Table param1Table, Session param1Session) {
/* 276 */       this.it = param1Iterator;
/* 277 */       this.table = param1Table;
/* 278 */       this.session = param1Session;
/*     */     }
/*     */ 
/*     */     
/*     */     public Row get() {
/* 283 */       return this.table.getRow(this.session, this.current.getId());
/*     */     }
/*     */ 
/*     */     
/*     */     public SearchRow getSearchRow() {
/* 288 */       return (SearchRow)get();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean next() {
/* 293 */       if (!this.it.hasNext()) {
/* 294 */         return false;
/*     */       }
/* 296 */       this.current = this.it.next();
/* 297 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean previous() {
/* 302 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\SpatialTreeIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */