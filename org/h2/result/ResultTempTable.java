/*     */ package org.h2.result;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import org.h2.command.ddl.CreateTableData;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.index.Cursor;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
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
/*     */ public class ResultTempTable
/*     */   implements ResultExternal
/*     */ {
/*     */   private static final String COLUMN_NAME = "DATA";
/*     */   private final boolean distinct;
/*     */   private final SortOrder sort;
/*     */   private Index index;
/*     */   private Session session;
/*     */   private Table table;
/*     */   private Cursor resultCursor;
/*     */   private int rowCount;
/*     */   private int columnCount;
/*     */   private final ResultTempTable parent;
/*     */   private boolean closed;
/*     */   private int childCount;
/*     */   private boolean containsLob;
/*     */   
/*     */   ResultTempTable(Session paramSession, Expression[] paramArrayOfExpression, boolean paramBoolean, SortOrder paramSortOrder) {
/*  47 */     this.session = paramSession;
/*  48 */     this.distinct = paramBoolean;
/*  49 */     this.sort = paramSortOrder;
/*  50 */     this.columnCount = paramArrayOfExpression.length;
/*  51 */     Schema schema = paramSession.getDatabase().getSchema("PUBLIC");
/*  52 */     CreateTableData createTableData = new CreateTableData();
/*  53 */     for (byte b = 0; b < paramArrayOfExpression.length; b++) {
/*  54 */       int i = paramArrayOfExpression[b].getType();
/*  55 */       Column column = new Column("DATA" + b, i);
/*     */       
/*  57 */       if (i == 16 || i == 15) {
/*  58 */         this.containsLob = true;
/*     */       }
/*  60 */       createTableData.columns.add(column);
/*     */     } 
/*  62 */     createTableData.id = paramSession.getDatabase().allocateObjectId();
/*  63 */     createTableData.tableName = "TEMP_RESULT_SET_" + createTableData.id;
/*  64 */     createTableData.temporary = true;
/*  65 */     createTableData.persistIndexes = false;
/*  66 */     createTableData.persistData = true;
/*  67 */     createTableData.create = true;
/*  68 */     createTableData.session = paramSession;
/*  69 */     this.table = schema.createTable(createTableData);
/*  70 */     if (paramSortOrder != null || paramBoolean) {
/*  71 */       createIndex();
/*     */     }
/*  73 */     this.parent = null;
/*     */   }
/*     */   
/*     */   private ResultTempTable(ResultTempTable paramResultTempTable) {
/*  77 */     this.parent = paramResultTempTable;
/*  78 */     this.columnCount = paramResultTempTable.columnCount;
/*  79 */     this.distinct = paramResultTempTable.distinct;
/*  80 */     this.session = paramResultTempTable.session;
/*  81 */     this.table = paramResultTempTable.table;
/*  82 */     this.index = paramResultTempTable.index;
/*  83 */     this.rowCount = paramResultTempTable.rowCount;
/*  84 */     this.sort = paramResultTempTable.sort;
/*  85 */     this.containsLob = paramResultTempTable.containsLob;
/*  86 */     reset();
/*     */   }
/*     */   
/*     */   private void createIndex() {
/*  90 */     IndexColumn[] arrayOfIndexColumn = null;
/*  91 */     if (this.sort != null) {
/*  92 */       int[] arrayOfInt = this.sort.getQueryColumnIndexes();
/*  93 */       arrayOfIndexColumn = new IndexColumn[arrayOfInt.length];
/*  94 */       for (byte b = 0; b < arrayOfInt.length; b++) {
/*  95 */         IndexColumn indexColumn = new IndexColumn();
/*  96 */         indexColumn.column = this.table.getColumn(arrayOfInt[b]);
/*  97 */         indexColumn.sortType = this.sort.getSortTypes()[b];
/*  98 */         indexColumn.columnName = "DATA" + b;
/*  99 */         arrayOfIndexColumn[b] = indexColumn;
/*     */       } 
/*     */     } else {
/* 102 */       arrayOfIndexColumn = new IndexColumn[this.columnCount];
/* 103 */       for (byte b = 0; b < this.columnCount; b++) {
/* 104 */         IndexColumn indexColumn = new IndexColumn();
/* 105 */         indexColumn.column = this.table.getColumn(b);
/* 106 */         indexColumn.columnName = "DATA" + b;
/* 107 */         arrayOfIndexColumn[b] = indexColumn;
/*     */       } 
/*     */     } 
/* 110 */     String str = this.table.getSchema().getUniqueIndexName(this.session, this.table, "INDEX_");
/*     */     
/* 112 */     int i = this.session.getDatabase().allocateObjectId();
/* 113 */     IndexType indexType = IndexType.createNonUnique(true);
/* 114 */     this.index = this.table.addIndex(this.session, str, i, arrayOfIndexColumn, indexType, true, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized ResultExternal createShallowCopy() {
/* 120 */     if (this.parent != null) {
/* 121 */       return this.parent.createShallowCopy();
/*     */     }
/* 123 */     if (this.closed) {
/* 124 */       return null;
/*     */     }
/* 126 */     this.childCount++;
/* 127 */     return new ResultTempTable(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int removeRow(Value[] paramArrayOfValue) {
/* 132 */     Row row = convertToRow(paramArrayOfValue);
/* 133 */     Cursor cursor = find(row);
/* 134 */     if (cursor != null) {
/* 135 */       row = cursor.get();
/* 136 */       this.table.removeRow(this.session, row);
/* 137 */       this.rowCount--;
/*     */     } 
/* 139 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Value[] paramArrayOfValue) {
/* 144 */     return (find(convertToRow(paramArrayOfValue)) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int addRow(Value[] paramArrayOfValue) {
/* 149 */     Row row = convertToRow(paramArrayOfValue);
/* 150 */     if (this.distinct) {
/* 151 */       Cursor cursor = find(row);
/* 152 */       if (cursor == null) {
/* 153 */         this.table.addRow(this.session, row);
/* 154 */         this.rowCount++;
/*     */       } 
/*     */     } else {
/* 157 */       this.table.addRow(this.session, row);
/* 158 */       this.rowCount++;
/*     */     } 
/* 160 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int addRows(ArrayList<Value[]> paramArrayList) {
/* 166 */     if (this.sort != null) {
/* 167 */       this.sort.sort(paramArrayList);
/*     */     }
/* 169 */     for (Value[] arrayOfValue : paramArrayList) {
/* 170 */       addRow(arrayOfValue);
/*     */     }
/* 172 */     return this.rowCount;
/*     */   }
/*     */   
/*     */   private synchronized void closeChild() {
/* 176 */     if (--this.childCount == 0 && this.closed) {
/* 177 */       dropTable();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void close() {
/* 183 */     if (this.closed) {
/*     */       return;
/*     */     }
/* 186 */     this.closed = true;
/* 187 */     if (this.parent != null) {
/* 188 */       this.parent.closeChild();
/*     */     }
/* 190 */     else if (this.childCount == 0) {
/* 191 */       dropTable();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropTable() {
/* 197 */     if (this.table == null) {
/*     */       return;
/*     */     }
/* 200 */     if (this.containsLob) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 206 */       Database database = this.session.getDatabase();
/*     */ 
/*     */ 
/*     */       
/* 210 */       synchronized (this.session) {
/* 211 */         synchronized (database) {
/* 212 */           this.table.truncate(this.session);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 220 */       if (!database.isSysTableLocked()) {
/* 221 */         Session session = database.getSystemSession();
/* 222 */         this.table.removeChildrenAndResources(session);
/* 223 */         if (this.index != null)
/*     */         {
/*     */           
/* 226 */           this.session.removeLocalTempTableIndex(this.index);
/*     */         }
/*     */ 
/*     */         
/* 230 */         synchronized (this.session) {
/* 231 */           synchronized (session) {
/* 232 */             synchronized (database) {
/* 233 */               session.commit(false);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 239 */       this.table = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void done() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Value[] next() {
/* 250 */     if (this.resultCursor == null) {
/*     */       Index index;
/* 252 */       if (this.distinct || this.sort != null) {
/* 253 */         index = this.index;
/*     */       } else {
/* 255 */         index = this.table.getScanIndex(this.session);
/*     */       } 
/* 257 */       if (this.session.getDatabase().getMvStore() != null) {
/*     */ 
/*     */         
/* 260 */         if (index.getRowCount(this.session) == 0L && this.rowCount > 0) {
/*     */           
/* 262 */           this.resultCursor = index.find((Session)null, null, null);
/*     */         } else {
/*     */           
/* 265 */           this.resultCursor = index.find(this.session, null, null);
/*     */         } 
/*     */       } else {
/* 268 */         this.resultCursor = index.find(this.session, null, null);
/*     */       } 
/*     */     } 
/* 271 */     if (!this.resultCursor.next()) {
/* 272 */       return null;
/*     */     }
/* 274 */     Row row = this.resultCursor.get();
/* 275 */     return row.getValueList();
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 280 */     this.resultCursor = null;
/*     */   }
/*     */   
/*     */   private Row convertToRow(Value[] paramArrayOfValue) {
/* 284 */     if (paramArrayOfValue.length < this.columnCount) {
/* 285 */       Value[] arrayOfValue = Arrays.<Value>copyOf(paramArrayOfValue, this.columnCount);
/* 286 */       for (int i = paramArrayOfValue.length; i < this.columnCount; i++) {
/* 287 */         arrayOfValue[i] = (Value)ValueNull.INSTANCE;
/*     */       }
/* 289 */       paramArrayOfValue = arrayOfValue;
/*     */     } 
/* 291 */     return this.session.createRow(paramArrayOfValue, -1);
/*     */   }
/*     */   
/*     */   private Cursor find(Row paramRow) {
/* 295 */     if (this.index == null)
/*     */     {
/*     */ 
/*     */       
/* 299 */       createIndex();
/*     */     }
/* 301 */     Cursor cursor = this.index.find(this.session, paramRow, paramRow);
/* 302 */     while (cursor.next()) {
/* 303 */       SearchRow searchRow = cursor.getSearchRow();
/* 304 */       boolean bool = true;
/* 305 */       Database database = this.session.getDatabase();
/* 306 */       for (byte b = 0; b < paramRow.getColumnCount(); b++) {
/* 307 */         if (!database.areEqual(paramRow.getValue(b), searchRow.getValue(b))) {
/* 308 */           bool = false;
/*     */           break;
/*     */         } 
/*     */       } 
/* 312 */       if (bool) {
/* 313 */         return cursor;
/*     */       }
/*     */     } 
/* 316 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\ResultTempTable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */