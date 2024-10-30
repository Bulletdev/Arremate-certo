/*     */ package org.h2.result;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SessionInterface;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.ValueHashMap;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueArray;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LocalResult
/*     */   implements AutoCloseable, ResultInterface, ResultTarget
/*     */ {
/*     */   private int maxMemoryRows;
/*     */   private Session session;
/*     */   private int visibleColumnCount;
/*     */   private Expression[] expressions;
/*     */   private int rowId;
/*     */   private int rowCount;
/*     */   private ArrayList<Value[]> rows;
/*     */   private SortOrder sort;
/*     */   private ValueHashMap<Value[]> distinctRows;
/*     */   private Value[] currentRow;
/*     */   private int offset;
/*  39 */   private int limit = -1;
/*     */ 
/*     */   
/*     */   private ResultExternal external;
/*     */ 
/*     */   
/*     */   private int diskOffset;
/*     */ 
/*     */   
/*     */   private boolean distinct;
/*     */ 
/*     */   
/*     */   private boolean randomAccess;
/*     */ 
/*     */   
/*     */   private boolean closed;
/*     */   
/*     */   private boolean containsLobs;
/*     */ 
/*     */   
/*     */   public LocalResult() {}
/*     */ 
/*     */   
/*     */   public LocalResult(Session paramSession, Expression[] paramArrayOfExpression, int paramInt) {
/*  63 */     this.session = paramSession;
/*  64 */     if (paramSession == null) {
/*  65 */       this.maxMemoryRows = Integer.MAX_VALUE;
/*     */     } else {
/*  67 */       Database database = paramSession.getDatabase();
/*  68 */       if (database.isPersistent() && !database.isReadOnly()) {
/*  69 */         this.maxMemoryRows = paramSession.getDatabase().getMaxMemoryRows();
/*     */       } else {
/*  71 */         this.maxMemoryRows = Integer.MAX_VALUE;
/*     */       } 
/*     */     } 
/*  74 */     this.rows = New.arrayList();
/*  75 */     this.visibleColumnCount = paramInt;
/*  76 */     this.rowId = -1;
/*  77 */     this.expressions = paramArrayOfExpression;
/*     */   }
/*     */   
/*     */   public void setMaxMemoryRows(int paramInt) {
/*  81 */     this.maxMemoryRows = paramInt;
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
/*     */   public static LocalResult read(Session paramSession, ResultSet paramResultSet, int paramInt) {
/*  94 */     Expression[] arrayOfExpression = Expression.getExpressionColumns(paramSession, paramResultSet);
/*  95 */     int i = arrayOfExpression.length;
/*  96 */     LocalResult localResult = new LocalResult(paramSession, arrayOfExpression, i);
/*     */     try {
/*  98 */       for (byte b = 0; (paramInt == 0 || b < paramInt) && paramResultSet.next(); b++) {
/*  99 */         Value[] arrayOfValue = new Value[i];
/* 100 */         for (byte b1 = 0; b1 < i; b1++) {
/* 101 */           int j = localResult.getColumnType(b1);
/* 102 */           arrayOfValue[b1] = DataType.readValue((SessionInterface)paramSession, paramResultSet, b1 + 1, j);
/*     */         } 
/* 104 */         localResult.addRow(arrayOfValue);
/*     */       } 
/* 106 */     } catch (SQLException sQLException) {
/* 107 */       throw DbException.convert(sQLException);
/*     */     } 
/* 109 */     localResult.done();
/* 110 */     return localResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LocalResult createShallowCopy(Session paramSession) {
/* 121 */     if (this.external == null && (this.rows == null || this.rows.size() < this.rowCount)) {
/* 122 */       return null;
/*     */     }
/* 124 */     if (this.containsLobs) {
/* 125 */       return null;
/*     */     }
/* 127 */     ResultExternal resultExternal = null;
/* 128 */     if (this.external != null) {
/* 129 */       resultExternal = this.external.createShallowCopy();
/* 130 */       if (resultExternal == null) {
/* 131 */         return null;
/*     */       }
/*     */     } 
/* 134 */     LocalResult localResult = new LocalResult();
/* 135 */     localResult.maxMemoryRows = this.maxMemoryRows;
/* 136 */     localResult.session = paramSession;
/* 137 */     localResult.visibleColumnCount = this.visibleColumnCount;
/* 138 */     localResult.expressions = this.expressions;
/* 139 */     localResult.rowId = -1;
/* 140 */     localResult.rowCount = this.rowCount;
/* 141 */     localResult.rows = this.rows;
/* 142 */     localResult.sort = this.sort;
/* 143 */     localResult.distinctRows = this.distinctRows;
/* 144 */     localResult.distinct = this.distinct;
/* 145 */     localResult.randomAccess = this.randomAccess;
/* 146 */     localResult.currentRow = null;
/* 147 */     localResult.offset = 0;
/* 148 */     localResult.limit = -1;
/* 149 */     localResult.external = resultExternal;
/* 150 */     localResult.diskOffset = this.diskOffset;
/* 151 */     return localResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(SortOrder paramSortOrder) {
/* 160 */     this.sort = paramSortOrder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDistinct() {
/* 167 */     this.distinct = true;
/* 168 */     this.distinctRows = ValueHashMap.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRandomAccess() {
/* 175 */     this.randomAccess = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeDistinct(Value[] paramArrayOfValue) {
/* 184 */     if (!this.distinct) {
/* 185 */       DbException.throwInternalError();
/*     */     }
/* 187 */     if (this.distinctRows != null) {
/* 188 */       ValueArray valueArray = ValueArray.get(paramArrayOfValue);
/* 189 */       this.distinctRows.remove((Value)valueArray);
/* 190 */       this.rowCount = this.distinctRows.size();
/*     */     } else {
/* 192 */       this.rowCount = this.external.removeRow(paramArrayOfValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsDistinct(Value[] paramArrayOfValue) {
/* 203 */     if (this.external != null) {
/* 204 */       return this.external.contains(paramArrayOfValue);
/*     */     }
/* 206 */     if (this.distinctRows == null) {
/* 207 */       this.distinctRows = ValueHashMap.newInstance();
/* 208 */       for (Value[] arrayOfValue : this.rows) {
/* 209 */         ValueArray valueArray1 = getArrayOfVisible(arrayOfValue);
/* 210 */         this.distinctRows.put((Value)valueArray1, valueArray1.getList());
/*     */       } 
/*     */     } 
/* 213 */     ValueArray valueArray = ValueArray.get(paramArrayOfValue);
/* 214 */     return (this.distinctRows.get((Value)valueArray) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 219 */     this.rowId = -1;
/* 220 */     if (this.external != null) {
/* 221 */       this.external.reset();
/* 222 */       if (this.diskOffset > 0) {
/* 223 */         for (byte b = 0; b < this.diskOffset; b++) {
/* 224 */           this.external.next();
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Value[] currentRow() {
/* 232 */     return this.currentRow;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean next() {
/* 237 */     if (!this.closed && this.rowId < this.rowCount) {
/* 238 */       this.rowId++;
/* 239 */       if (this.rowId < this.rowCount) {
/* 240 */         if (this.external != null) {
/* 241 */           this.currentRow = this.external.next();
/*     */         } else {
/* 243 */           this.currentRow = this.rows.get(this.rowId);
/*     */         } 
/* 245 */         return true;
/*     */       } 
/* 247 */       this.currentRow = null;
/*     */     } 
/* 249 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowId() {
/* 254 */     return this.rowId;
/*     */   }
/*     */   
/*     */   private void cloneLobs(Value[] paramArrayOfValue) {
/* 258 */     for (byte b = 0; b < paramArrayOfValue.length; b++) {
/* 259 */       Value value1 = paramArrayOfValue[b];
/* 260 */       Value value2 = value1.copyToResult();
/* 261 */       if (value2 != value1) {
/* 262 */         this.containsLobs = true;
/* 263 */         this.session.addTemporaryLob(value2);
/* 264 */         paramArrayOfValue[b] = value2;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private ValueArray getArrayOfVisible(Value[] paramArrayOfValue) {
/* 270 */     if (paramArrayOfValue.length > this.visibleColumnCount) {
/* 271 */       Value[] arrayOfValue = new Value[this.visibleColumnCount];
/* 272 */       System.arraycopy(paramArrayOfValue, 0, arrayOfValue, 0, this.visibleColumnCount);
/* 273 */       paramArrayOfValue = arrayOfValue;
/*     */     } 
/* 275 */     return ValueArray.get(paramArrayOfValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRow(Value[] paramArrayOfValue) {
/* 285 */     cloneLobs(paramArrayOfValue);
/* 286 */     if (this.distinct) {
/* 287 */       if (this.distinctRows != null) {
/* 288 */         ValueArray valueArray = getArrayOfVisible(paramArrayOfValue);
/* 289 */         this.distinctRows.put((Value)valueArray, paramArrayOfValue);
/* 290 */         this.rowCount = this.distinctRows.size();
/* 291 */         if (this.rowCount > this.maxMemoryRows) {
/* 292 */           this.external = new ResultTempTable(this.session, this.expressions, true, this.sort);
/* 293 */           this.rowCount = this.external.addRows(this.distinctRows.values());
/* 294 */           this.distinctRows = null;
/*     */         } 
/*     */       } else {
/* 297 */         this.rowCount = this.external.addRow(paramArrayOfValue);
/*     */       } 
/*     */       return;
/*     */     } 
/* 301 */     this.rows.add(paramArrayOfValue);
/* 302 */     this.rowCount++;
/* 303 */     if (this.rows.size() > this.maxMemoryRows) {
/* 304 */       if (this.external == null) {
/* 305 */         this.external = new ResultTempTable(this.session, this.expressions, false, this.sort);
/*     */       }
/* 307 */       addRowsToDisk();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addRowsToDisk() {
/* 312 */     this.rowCount = this.external.addRows(this.rows);
/* 313 */     this.rows.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVisibleColumnCount() {
/* 318 */     return this.visibleColumnCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void done() {
/* 325 */     if (this.distinct) {
/* 326 */       if (this.distinctRows != null) {
/* 327 */         this.rows = this.distinctRows.values();
/*     */       }
/* 329 */       else if (this.external != null && this.sort != null) {
/*     */         
/* 331 */         ResultExternal resultExternal = this.external;
/* 332 */         this.external = null;
/* 333 */         resultExternal.reset();
/* 334 */         this.rows = New.arrayList();
/*     */         
/*     */         while (true) {
/* 337 */           Value[] arrayOfValue = resultExternal.next();
/* 338 */           if (arrayOfValue == null) {
/*     */             break;
/*     */           }
/* 341 */           if (this.external == null) {
/* 342 */             this.external = new ResultTempTable(this.session, this.expressions, true, this.sort);
/*     */           }
/* 344 */           this.rows.add(arrayOfValue);
/* 345 */           if (this.rows.size() > this.maxMemoryRows) {
/* 346 */             this.rowCount = this.external.addRows(this.rows);
/* 347 */             this.rows.clear();
/*     */           } 
/*     */         } 
/* 350 */         resultExternal.close();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 356 */     if (this.external != null) {
/* 357 */       addRowsToDisk();
/* 358 */       this.external.done();
/*     */     }
/* 360 */     else if (this.sort != null) {
/* 361 */       if (this.offset > 0 || this.limit > 0) {
/* 362 */         this.sort.sort(this.rows, this.offset, (this.limit < 0) ? this.rows.size() : this.limit);
/*     */       } else {
/* 364 */         this.sort.sort(this.rows);
/*     */       } 
/*     */     } 
/*     */     
/* 368 */     applyOffset();
/* 369 */     applyLimit();
/* 370 */     reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/* 375 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLimit(int paramInt) {
/* 384 */     this.limit = paramInt;
/*     */   }
/*     */   
/*     */   private void applyLimit() {
/* 388 */     if (this.limit < 0) {
/*     */       return;
/*     */     }
/* 391 */     if (this.external == null) {
/* 392 */       if (this.rows.size() > this.limit) {
/* 393 */         this.rows = New.arrayList(this.rows.subList(0, this.limit));
/* 394 */         this.rowCount = this.limit;
/*     */       }
/*     */     
/* 397 */     } else if (this.limit < this.rowCount) {
/* 398 */       this.rowCount = this.limit;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needToClose() {
/* 405 */     return (this.external != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 410 */     if (this.external != null) {
/* 411 */       this.external.close();
/* 412 */       this.external = null;
/* 413 */       this.closed = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAlias(int paramInt) {
/* 419 */     return this.expressions[paramInt].getAlias();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTableName(int paramInt) {
/* 424 */     return this.expressions[paramInt].getTableName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSchemaName(int paramInt) {
/* 429 */     return this.expressions[paramInt].getSchemaName();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize(int paramInt) {
/* 434 */     return this.expressions[paramInt].getDisplaySize();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnName(int paramInt) {
/* 439 */     return this.expressions[paramInt].getColumnName();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnType(int paramInt) {
/* 444 */     return this.expressions[paramInt].getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getColumnPrecision(int paramInt) {
/* 449 */     return this.expressions[paramInt].getPrecision();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNullable(int paramInt) {
/* 454 */     return this.expressions[paramInt].getNullable();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAutoIncrement(int paramInt) {
/* 459 */     return this.expressions[paramInt].isAutoIncrement();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnScale(int paramInt) {
/* 464 */     return this.expressions[paramInt].getScale();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOffset(int paramInt) {
/* 473 */     this.offset = paramInt;
/*     */   }
/*     */   
/*     */   private void applyOffset() {
/* 477 */     if (this.offset <= 0) {
/*     */       return;
/*     */     }
/* 480 */     if (this.external == null) {
/* 481 */       if (this.offset >= this.rows.size()) {
/* 482 */         this.rows.clear();
/* 483 */         this.rowCount = 0;
/*     */       } else {
/*     */         
/* 486 */         int i = Math.min(this.offset, this.rows.size());
/* 487 */         this.rows = New.arrayList(this.rows.subList(i, this.rows.size()));
/* 488 */         this.rowCount -= i;
/*     */       }
/*     */     
/* 491 */     } else if (this.offset >= this.rowCount) {
/* 492 */       this.rowCount = 0;
/*     */     } else {
/* 494 */       this.diskOffset = this.offset;
/* 495 */       this.rowCount -= this.offset;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 502 */     return super.toString() + " columns: " + this.visibleColumnCount + " rows: " + this.rowCount + " pos: " + this.rowId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClosed() {
/* 512 */     return this.closed;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFetchSize() {
/* 517 */     return 0;
/*     */   }
/*     */   
/*     */   public void setFetchSize(int paramInt) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\LocalResult.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */