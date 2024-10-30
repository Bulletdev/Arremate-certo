/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Mode;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.schema.SchemaObjectBase;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.util.StringUtils;
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
/*     */ public abstract class BaseIndex
/*     */   extends SchemaObjectBase
/*     */   implements Index
/*     */ {
/*     */   protected IndexColumn[] indexColumns;
/*     */   protected Column[] columns;
/*     */   protected int[] columnIds;
/*     */   protected Table table;
/*     */   protected IndexType indexType;
/*     */   protected boolean isMultiVersion;
/*     */   
/*     */   protected void initBaseIndex(Table paramTable, int paramInt, String paramString, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType) {
/*  54 */     initSchemaObjectBase(paramTable.getSchema(), paramInt, paramString, 5);
/*  55 */     this.indexType = paramIndexType;
/*  56 */     this.table = paramTable;
/*  57 */     if (paramArrayOfIndexColumn != null) {
/*  58 */       this.indexColumns = paramArrayOfIndexColumn;
/*  59 */       this.columns = new Column[paramArrayOfIndexColumn.length];
/*  60 */       int i = this.columns.length;
/*  61 */       this.columnIds = new int[i];
/*  62 */       for (byte b = 0; b < i; b++) {
/*  63 */         Column column = (paramArrayOfIndexColumn[b]).column;
/*  64 */         this.columns[b] = column;
/*  65 */         this.columnIds[b] = column.getColumnId();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void checkIndexColumnTypes(IndexColumn[] paramArrayOfIndexColumn) {
/*  76 */     for (IndexColumn indexColumn : paramArrayOfIndexColumn) {
/*  77 */       int i = indexColumn.column.getType();
/*  78 */       if (i == 16 || i == 15) {
/*  79 */         throw DbException.getUnsupportedException("Index on BLOB or CLOB column: " + indexColumn.column.getCreateSQL());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/*  87 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DbException getDuplicateKeyException(String paramString) {
/*  98 */     String str = getName() + " ON " + this.table.getSQL() + "(" + getColumnListSQL() + ")";
/*     */     
/* 100 */     if (paramString != null) {
/* 101 */       str = str + " VALUES " + paramString;
/*     */     }
/* 103 */     DbException dbException = DbException.get(23505, str);
/* 104 */     dbException.setSource(this);
/* 105 */     return dbException;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 110 */     return getSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 115 */     this.table.removeIndex(this);
/* 116 */     remove(paramSession);
/* 117 */     this.database.removeMeta(paramSession, getId());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canFindNext() {
/* 122 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Cursor find(TableFilter paramTableFilter, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 128 */     return find(paramTableFilter.getSession(), paramSearchRow1, paramSearchRow2);
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
/*     */ 
/*     */   
/*     */   public Cursor findNext(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 144 */     throw DbException.throwInternalError();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final long getCostRangeIndex(int[] paramArrayOfint, long paramLong, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, boolean paramBoolean, HashSet<Column> paramHashSet) {
/*     */     long l3;
/* 165 */     paramLong += 1000L;
/* 166 */     int i = 0;
/* 167 */     long l1 = paramLong;
/* 168 */     if (paramArrayOfint != null) {
/* 169 */       byte b; int j; for (b = 0, j = this.columns.length; b < j; b++) {
/* 170 */         Column column = this.columns[b];
/* 171 */         int k = column.getColumnId();
/* 172 */         int m = paramArrayOfint[k];
/* 173 */         if ((m & 0x1) == 1)
/* 174 */         { if (b == this.columns.length - 1 && getIndexType().isUnique()) {
/* 175 */             l1 = 3L;
/*     */             break;
/*     */           } 
/* 178 */           i = 100 - (100 - i) * (100 - column.getSelectivity()) / 100;
/*     */           
/* 180 */           long l = paramLong * i / 100L;
/* 181 */           if (l <= 0L) {
/* 182 */             l = 1L;
/*     */           }
/* 184 */           l1 = 2L + Math.max(paramLong / l, 1L); }
/* 185 */         else { if ((m & 0x6) == 6) {
/* 186 */             l1 = 2L + paramLong / 4L; break;
/*     */           } 
/* 188 */           if ((m & 0x2) == 2) {
/* 189 */             l1 = 2L + paramLong / 3L; break;
/*     */           } 
/* 191 */           if ((m & 0x4) == 4) {
/* 192 */             l1 = paramLong / 3L;
/*     */           }
/*     */ 
/*     */           
/*     */           break; }
/*     */       
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 202 */     long l2 = 0L;
/* 203 */     if (paramSortOrder != null) {
/* 204 */       l2 = 100L + paramLong / 10L;
/*     */     }
/* 206 */     if (paramSortOrder != null && !paramBoolean) {
/* 207 */       boolean bool1 = true;
/* 208 */       byte b1 = 0;
/* 209 */       int[] arrayOfInt = paramSortOrder.getSortTypes();
/* 210 */       TableFilter tableFilter = (paramArrayOfTableFilter == null) ? null : paramArrayOfTableFilter[paramInt]; byte b2; int j;
/* 211 */       for (b2 = 0, j = arrayOfInt.length; b2 < j && 
/* 212 */         b2 < this.indexColumns.length; b2++) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 219 */         Column column = paramSortOrder.getColumn(b2, tableFilter);
/* 220 */         if (column == null) {
/* 221 */           bool1 = false;
/*     */           break;
/*     */         } 
/* 224 */         IndexColumn indexColumn = this.indexColumns[b2];
/* 225 */         if (!column.equals(indexColumn.column)) {
/* 226 */           bool1 = false;
/*     */           break;
/*     */         } 
/* 229 */         int k = arrayOfInt[b2];
/* 230 */         if (k != indexColumn.sortType) {
/* 231 */           bool1 = false;
/*     */           break;
/*     */         } 
/* 234 */         b1++;
/*     */       } 
/* 236 */       if (bool1)
/*     */       {
/*     */ 
/*     */         
/* 240 */         l2 = (100 - b1);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 246 */     boolean bool = true;
/* 247 */     if (!paramBoolean && paramHashSet != null && !paramHashSet.isEmpty()) {
/* 248 */       boolean bool1 = true;
/* 249 */       for (Column column : paramHashSet) {
/* 250 */         if (column.getTable() == getTable()) {
/* 251 */           boolean bool2 = false;
/* 252 */           for (Column column1 : this.columns) {
/* 253 */             if (column == column1) {
/* 254 */               bool2 = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 258 */           if (!bool2) {
/* 259 */             bool1 = false;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 264 */       if (bool1) {
/* 265 */         bool = false;
/*     */       }
/*     */     } 
/*     */     
/* 269 */     if (paramBoolean) {
/* 270 */       l3 = l1 + l2 + 20L;
/* 271 */     } else if (bool) {
/* 272 */       l3 = l1 + l1 + l2 + 20L;
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */       
/* 280 */       l3 = l1 + l2 + (20 - this.columns.length);
/*     */     } 
/* 282 */     return l3;
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareRows(SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 287 */     if (paramSearchRow1 == paramSearchRow2)
/* 288 */       return 0;  byte b;
/*     */     int i;
/* 290 */     for (b = 0, i = this.indexColumns.length; b < i; b++) {
/* 291 */       int j = this.columnIds[b];
/* 292 */       Value value1 = paramSearchRow1.getValue(j);
/* 293 */       Value value2 = paramSearchRow2.getValue(j);
/* 294 */       if (value1 == null || value2 == null)
/*     */       {
/* 296 */         return 0;
/*     */       }
/* 298 */       int k = compareValues(value1, value2, (this.indexColumns[b]).sortType);
/* 299 */       if (k != 0) {
/* 300 */         return k;
/*     */       }
/*     */     } 
/* 303 */     return 0;
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
/*     */   protected boolean containsNullAndAllowMultipleNull(SearchRow paramSearchRow) {
/* 316 */     Mode mode = this.database.getMode();
/* 317 */     if (mode.uniqueIndexSingleNull)
/* 318 */       return false; 
/* 319 */     if (mode.uniqueIndexSingleNullExceptAllColumnsAreNull) {
/* 320 */       for (int i : this.columnIds) {
/* 321 */         Value value = paramSearchRow.getValue(i);
/* 322 */         if (value != ValueNull.INSTANCE) {
/* 323 */           return false;
/*     */         }
/*     */       } 
/* 326 */       return true;
/*     */     } 
/* 328 */     for (int i : this.columnIds) {
/* 329 */       Value value = paramSearchRow.getValue(i);
/* 330 */       if (value == ValueNull.INSTANCE) {
/* 331 */         return true;
/*     */       }
/*     */     } 
/* 334 */     return false;
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
/*     */   int compareKeys(SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 346 */     long l1 = paramSearchRow1.getKey();
/* 347 */     long l2 = paramSearchRow2.getKey();
/* 348 */     if (l1 == l2) {
/* 349 */       if (this.isMultiVersion) {
/* 350 */         int i = paramSearchRow1.getVersion();
/* 351 */         int j = paramSearchRow2.getVersion();
/* 352 */         return MathUtils.compareInt(j, i);
/*     */       } 
/* 354 */       return 0;
/*     */     } 
/* 356 */     return (l1 > l2) ? 1 : -1;
/*     */   }
/*     */   
/*     */   private int compareValues(Value paramValue1, Value paramValue2, int paramInt) {
/* 360 */     if (paramValue1 == paramValue2) {
/* 361 */       return 0;
/*     */     }
/* 363 */     int i = this.table.compareTypeSafe(paramValue1, paramValue2);
/* 364 */     if ((paramInt & 0x1) != 0) {
/* 365 */       i = -i;
/*     */     }
/* 367 */     return i;
/*     */   }
/*     */   public int getColumnIndex(Column paramColumn) {
/*     */     byte b;
/*     */     int i;
/* 372 */     for (b = 0, i = this.columns.length; b < i; b++) {
/* 373 */       if (this.columns[b].equals(paramColumn)) {
/* 374 */         return b;
/*     */       }
/*     */     } 
/* 377 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getColumnListSQL() {
/* 386 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 387 */     for (IndexColumn indexColumn : this.indexColumns) {
/* 388 */       statementBuilder.appendExceptFirst(", ");
/* 389 */       statementBuilder.append(indexColumn.getSQL());
/*     */     } 
/* 391 */     return statementBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 396 */     StringBuilder stringBuilder = new StringBuilder("CREATE ");
/* 397 */     stringBuilder.append(this.indexType.getSQL());
/* 398 */     stringBuilder.append(' ');
/* 399 */     if (this.table.isHidden()) {
/* 400 */       stringBuilder.append("IF NOT EXISTS ");
/*     */     }
/* 402 */     stringBuilder.append(paramString);
/* 403 */     stringBuilder.append(" ON ").append(paramTable.getSQL());
/* 404 */     if (this.comment != null) {
/* 405 */       stringBuilder.append(" COMMENT ").append(StringUtils.quoteStringSQL(this.comment));
/*     */     }
/* 407 */     stringBuilder.append('(').append(getColumnListSQL()).append(')');
/* 408 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/* 413 */     return getCreateSQLForCopy(this.table, getSQL());
/*     */   }
/*     */ 
/*     */   
/*     */   public IndexColumn[] getIndexColumns() {
/* 418 */     return this.indexColumns;
/*     */   }
/*     */ 
/*     */   
/*     */   public Column[] getColumns() {
/* 423 */     return this.columns;
/*     */   }
/*     */ 
/*     */   
/*     */   public IndexType getIndexType() {
/* 428 */     return this.indexType;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 433 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public Table getTable() {
/* 438 */     return this.table;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commit(int paramInt, Row paramRow) {}
/*     */ 
/*     */   
/*     */   void setMultiVersion(boolean paramBoolean) {
/* 447 */     this.isMultiVersion = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public Row getRow(Session paramSession, long paramLong) {
/* 452 */     throw DbException.getUnsupportedException(toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHidden() {
/* 457 */     return this.table.isHidden();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRowIdIndex() {
/* 462 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canScan() {
/* 467 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortedInsertMode(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexLookupBatch createLookupBatch(TableFilter[] paramArrayOfTableFilter, int paramInt) {
/* 478 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\BaseIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */