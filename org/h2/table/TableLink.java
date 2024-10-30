/*     */ package org.h2.table;
/*     */ 
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.index.LinkedIndex;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.RowList;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.DataType;
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
/*     */ public class TableLink
/*     */   extends Table
/*     */ {
/*     */   private static final int MAX_RETRY = 2;
/*     */   private static final long ROW_COUNT_APPROXIMATION = 100000L;
/*     */   private final String originalSchema;
/*     */   private String driver;
/*     */   private String url;
/*     */   private String user;
/*     */   private String password;
/*     */   private String originalTable;
/*     */   private String qualifiedTableName;
/*     */   private TableLinkConnection conn;
/*  53 */   private HashMap<String, PreparedStatement> preparedMap = New.hashMap();
/*  54 */   private final ArrayList<Index> indexes = New.arrayList();
/*     */   
/*     */   private final boolean emitUpdates;
/*     */   
/*     */   private LinkedIndex linkedIndex;
/*     */   private DbException connectException;
/*     */   private boolean storesLowerCase;
/*     */   private boolean storesMixedCase;
/*     */   private boolean storesMixedCaseQuoted;
/*     */   private boolean supportsMixedCaseIdentifiers;
/*     */   private boolean globalTemporary;
/*     */   private boolean readOnly;
/*     */   
/*     */   public TableLink(Schema paramSchema, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2) {
/*  68 */     super(paramSchema, paramInt, paramString1, false, true);
/*  69 */     this.driver = paramString2;
/*  70 */     this.url = paramString3;
/*  71 */     this.user = paramString4;
/*  72 */     this.password = paramString5;
/*  73 */     this.originalSchema = paramString6;
/*  74 */     this.originalTable = paramString7;
/*  75 */     this.emitUpdates = paramBoolean1;
/*     */     try {
/*  77 */       connect();
/*  78 */     } catch (DbException dbException) {
/*  79 */       if (!paramBoolean2) {
/*  80 */         throw dbException;
/*     */       }
/*  82 */       Column[] arrayOfColumn = new Column[0];
/*  83 */       setColumns(arrayOfColumn);
/*  84 */       this.linkedIndex = new LinkedIndex(this, paramInt, IndexColumn.wrap(arrayOfColumn), IndexType.createNonUnique(false));
/*     */       
/*  86 */       this.indexes.add(this.linkedIndex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void connect() {
/*  91 */     this.connectException = null;
/*  92 */     for (byte b = 0;; b++) {
/*     */       try {
/*  94 */         this.conn = this.database.getLinkConnection(this.driver, this.url, this.user, this.password);
/*  95 */         synchronized (this.conn) {
/*     */           
/*  97 */           readMetaData();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/* 106 */       } catch (DbException dbException) {
/* 107 */         if (b >= 2) {
/* 108 */           this.connectException = dbException;
/* 109 */           throw dbException;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void readMetaData() throws SQLException {
/* 116 */     DatabaseMetaData databaseMetaData = this.conn.getConnection().getMetaData();
/* 117 */     this.storesLowerCase = databaseMetaData.storesLowerCaseIdentifiers();
/* 118 */     this.storesMixedCase = databaseMetaData.storesMixedCaseIdentifiers();
/* 119 */     this.storesMixedCaseQuoted = databaseMetaData.storesMixedCaseQuotedIdentifiers();
/* 120 */     this.supportsMixedCaseIdentifiers = databaseMetaData.supportsMixedCaseIdentifiers();
/* 121 */     ResultSet resultSet = databaseMetaData.getTables(null, this.originalSchema, this.originalTable, null);
/* 122 */     if (resultSet.next() && resultSet.next()) {
/* 123 */       throw DbException.get(90080, this.originalTable);
/*     */     }
/* 125 */     resultSet.close();
/* 126 */     resultSet = databaseMetaData.getColumns(null, this.originalSchema, this.originalTable, null);
/* 127 */     byte b = 0;
/* 128 */     ArrayList<Column> arrayList1 = New.arrayList();
/* 129 */     HashMap<String, Column> hashMap = New.hashMap();
/* 130 */     String str1 = null, str2 = null;
/* 131 */     while (resultSet.next()) {
/* 132 */       String str5 = resultSet.getString("TABLE_CAT");
/* 133 */       if (str1 == null) {
/* 134 */         str1 = str5;
/*     */       }
/* 136 */       String str6 = resultSet.getString("TABLE_SCHEM");
/* 137 */       if (str2 == null) {
/* 138 */         str2 = str6;
/*     */       }
/* 140 */       if (!StringUtils.equals(str1, str5) || !StringUtils.equals(str2, str6)) {
/*     */ 
/*     */ 
/*     */         
/* 144 */         hashMap.clear();
/* 145 */         arrayList1.clear();
/*     */         break;
/*     */       } 
/* 148 */       String str7 = resultSet.getString("COLUMN_NAME");
/* 149 */       str7 = convertColumnName(str7);
/* 150 */       int j = resultSet.getInt("DATA_TYPE");
/* 151 */       String str8 = resultSet.getString("TYPE_NAME");
/* 152 */       long l = resultSet.getInt("COLUMN_SIZE");
/* 153 */       l = convertPrecision(j, l);
/* 154 */       int k = resultSet.getInt("DECIMAL_DIGITS");
/* 155 */       k = convertScale(j, k);
/* 156 */       int m = MathUtils.convertLongToInt(l);
/* 157 */       int n = DataType.convertSQLTypeToValueType(j, str8);
/* 158 */       Column column = new Column(str7, n, l, k, m);
/* 159 */       column.setTable(this, b++);
/* 160 */       arrayList1.add(column);
/* 161 */       hashMap.put(str7, column);
/*     */     } 
/* 163 */     resultSet.close();
/* 164 */     if (this.originalTable.indexOf('.') < 0 && !StringUtils.isNullOrEmpty(str2)) {
/* 165 */       this.qualifiedTableName = str2 + "." + this.originalTable;
/*     */     } else {
/* 167 */       this.qualifiedTableName = this.originalTable;
/*     */     } 
/*     */ 
/*     */     
/* 171 */     try (Statement null = this.conn.getConnection().createStatement()) {
/* 172 */       resultSet = statement.executeQuery("SELECT * FROM " + this.qualifiedTableName + " T WHERE 1=0");
/*     */       
/* 174 */       if (arrayList1.size() == 0) {
/*     */         
/* 176 */         ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
/* 177 */         for (b = 0; b < resultSetMetaData.getColumnCount(); ) {
/* 178 */           String str = resultSetMetaData.getColumnName(b + 1);
/* 179 */           str = convertColumnName(str);
/* 180 */           int j = resultSetMetaData.getColumnType(b + 1);
/* 181 */           long l = resultSetMetaData.getPrecision(b + 1);
/* 182 */           l = convertPrecision(j, l);
/* 183 */           int k = resultSetMetaData.getScale(b + 1);
/* 184 */           k = convertScale(j, k);
/* 185 */           int m = resultSetMetaData.getColumnDisplaySize(b + 1);
/* 186 */           int n = DataType.getValueTypeFromResultSet(resultSetMetaData, b + 1);
/* 187 */           Column column = new Column(str, n, l, k, m);
/* 188 */           column.setTable(this, b++);
/* 189 */           arrayList1.add(column);
/* 190 */           hashMap.put(str, column);
/*     */         } 
/*     */       } 
/* 193 */       resultSet.close();
/* 194 */     } catch (Exception exception) {
/* 195 */       throw DbException.get(42102, exception, new String[] { this.originalTable + "(" + exception.toString() + ")" });
/*     */     } 
/*     */     
/* 198 */     Column[] arrayOfColumn = new Column[arrayList1.size()];
/* 199 */     arrayList1.toArray(arrayOfColumn);
/* 200 */     setColumns(arrayOfColumn);
/* 201 */     int i = getId();
/* 202 */     this.linkedIndex = new LinkedIndex(this, i, IndexColumn.wrap(arrayOfColumn), IndexType.createNonUnique(false));
/*     */     
/* 204 */     this.indexes.add(this.linkedIndex);
/*     */     try {
/* 206 */       resultSet = databaseMetaData.getPrimaryKeys(null, this.originalSchema, this.originalTable);
/* 207 */     } catch (Exception exception) {
/*     */ 
/*     */ 
/*     */       
/* 211 */       resultSet = null;
/*     */     } 
/* 213 */     String str3 = "";
/*     */     
/* 215 */     if (resultSet != null && resultSet.next()) {
/*     */       
/* 217 */       ArrayList<Column> arrayList = New.arrayList();
/*     */       while (true) {
/* 219 */         int j = resultSet.getInt("KEY_SEQ");
/* 220 */         if (str3 == null) {
/* 221 */           str3 = resultSet.getString("PK_NAME");
/*     */         }
/* 223 */         while (arrayList.size() < j) {
/* 224 */           arrayList.add(null);
/*     */         }
/* 226 */         String str = resultSet.getString("COLUMN_NAME");
/* 227 */         str = convertColumnName(str);
/* 228 */         Column column = hashMap.get(str);
/* 229 */         if (j == 0) {
/*     */           
/* 231 */           arrayList.add(column);
/*     */         } else {
/* 233 */           arrayList.set(j - 1, column);
/*     */         } 
/* 235 */         if (!resultSet.next()) {
/* 236 */           addIndex(arrayList, IndexType.createPrimaryKey(false, false));
/* 237 */           resultSet.close(); break;
/*     */         } 
/*     */       } 
/* 240 */     }  try { resultSet = databaseMetaData.getIndexInfo(null, this.originalSchema, this.originalTable, false, true); }
/* 241 */     catch (Exception exception)
/*     */     
/*     */     { 
/* 244 */       resultSet = null; }
/*     */     
/* 246 */     String str4 = null;
/* 247 */     ArrayList<Column> arrayList2 = New.arrayList();
/* 248 */     IndexType indexType = null;
/* 249 */     if (resultSet != null) {
/* 250 */       while (resultSet.next()) {
/* 251 */         if (resultSet.getShort("TYPE") == 0) {
/*     */           continue;
/*     */         }
/*     */         
/* 255 */         String str5 = resultSet.getString("INDEX_NAME");
/* 256 */         if (str3.equals(str5)) {
/*     */           continue;
/*     */         }
/* 259 */         if (str4 != null && !str4.equals(str5)) {
/* 260 */           addIndex(arrayList2, indexType);
/* 261 */           str4 = null;
/*     */         } 
/* 263 */         if (str4 == null) {
/* 264 */           str4 = str5;
/* 265 */           arrayList2.clear();
/*     */         } 
/* 267 */         boolean bool = !resultSet.getBoolean("NON_UNIQUE") ? true : false;
/* 268 */         indexType = bool ? IndexType.createUnique(false, false) : IndexType.createNonUnique(false);
/*     */         
/* 270 */         String str6 = resultSet.getString("COLUMN_NAME");
/* 271 */         str6 = convertColumnName(str6);
/* 272 */         Column column = hashMap.get(str6);
/* 273 */         arrayList2.add(column);
/*     */       } 
/* 275 */       resultSet.close();
/*     */     } 
/* 277 */     if (str4 != null) {
/* 278 */       addIndex(arrayList2, indexType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long convertPrecision(int paramInt, long paramLong) {
/* 286 */     switch (paramInt) {
/*     */       case 2:
/*     */       case 3:
/* 289 */         if (paramLong == 0L) {
/* 290 */           paramLong = 65535L;
/*     */         }
/*     */         break;
/*     */       case 91:
/* 294 */         paramLong = Math.max(8L, paramLong);
/*     */         break;
/*     */       case 93:
/* 297 */         paramLong = Math.max(23L, paramLong);
/*     */         break;
/*     */       case 92:
/* 300 */         paramLong = Math.max(6L, paramLong);
/*     */         break;
/*     */     } 
/* 303 */     return paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int convertScale(int paramInt1, int paramInt2) {
/* 309 */     switch (paramInt1) {
/*     */       case 2:
/*     */       case 3:
/* 312 */         if (paramInt2 < 0) {
/* 313 */           paramInt2 = 32767;
/*     */         }
/*     */         break;
/*     */     } 
/* 317 */     return paramInt2;
/*     */   }
/*     */   
/*     */   private String convertColumnName(String paramString) {
/* 321 */     if ((this.storesMixedCase || this.storesLowerCase) && paramString.equals(StringUtils.toLowerEnglish(paramString))) {
/*     */       
/* 323 */       paramString = StringUtils.toUpperEnglish(paramString);
/* 324 */     } else if (this.storesMixedCase && !this.supportsMixedCaseIdentifiers) {
/*     */       
/* 326 */       paramString = StringUtils.toUpperEnglish(paramString);
/* 327 */     } else if (this.storesMixedCase && this.storesMixedCaseQuoted) {
/*     */       
/* 329 */       paramString = StringUtils.toUpperEnglish(paramString);
/*     */     } 
/* 331 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void addIndex(List<Column> paramList, IndexType paramIndexType) {
/* 337 */     int i = paramList.indexOf(null);
/* 338 */     if (i == 0) {
/* 339 */       this.trace.info("Omitting linked index - no recognized columns."); return;
/*     */     } 
/* 341 */     if (i > 0) {
/* 342 */       this.trace.info("Unrecognized columns in linked index. Registering the index against the leading {0} recognized columns of {1} total columns.", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()) });
/*     */ 
/*     */       
/* 345 */       paramList = paramList.subList(0, i);
/*     */     } 
/* 347 */     Column[] arrayOfColumn = new Column[paramList.size()];
/* 348 */     paramList.toArray(arrayOfColumn);
/* 349 */     LinkedIndex linkedIndex = new LinkedIndex(this, 0, IndexColumn.wrap(arrayOfColumn), paramIndexType);
/* 350 */     this.indexes.add(linkedIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/* 355 */     return "DROP TABLE IF EXISTS " + getSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/* 360 */     StringBuilder stringBuilder = new StringBuilder("CREATE FORCE ");
/* 361 */     if (isTemporary()) {
/* 362 */       if (this.globalTemporary) {
/* 363 */         stringBuilder.append("GLOBAL ");
/*     */       } else {
/* 365 */         stringBuilder.append("LOCAL ");
/*     */       } 
/* 367 */       stringBuilder.append("TEMPORARY ");
/*     */     } 
/* 369 */     stringBuilder.append("LINKED TABLE ").append(getSQL());
/* 370 */     if (this.comment != null) {
/* 371 */       stringBuilder.append(" COMMENT ").append(StringUtils.quoteStringSQL(this.comment));
/*     */     }
/* 373 */     stringBuilder.append('(').append(StringUtils.quoteStringSQL(this.driver)).append(", ").append(StringUtils.quoteStringSQL(this.url)).append(", ").append(StringUtils.quoteStringSQL(this.user)).append(", ").append(StringUtils.quoteStringSQL(this.password)).append(", ").append(StringUtils.quoteStringSQL(this.originalTable)).append(')');
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
/* 384 */     if (this.emitUpdates) {
/* 385 */       stringBuilder.append(" EMIT UPDATES");
/*     */     }
/* 387 */     if (this.readOnly) {
/* 388 */       stringBuilder.append(" READONLY");
/*     */     }
/* 390 */     stringBuilder.append(" /*--hide--*/");
/* 391 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Index addIndex(Session paramSession, String paramString1, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType, boolean paramBoolean, String paramString2) {
/* 398 */     throw DbException.getUnsupportedException("LINK");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean lock(Session paramSession, boolean paramBoolean1, boolean paramBoolean2) {
/* 404 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLockedExclusively() {
/* 409 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getScanIndex(Session paramSession) {
/* 414 */     return (Index)this.linkedIndex;
/*     */   }
/*     */   
/*     */   private void checkReadOnly() {
/* 418 */     if (this.readOnly) {
/* 419 */       throw DbException.get(90097);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRow(Session paramSession, Row paramRow) {
/* 425 */     checkReadOnly();
/* 426 */     getScanIndex(paramSession).remove(paramSession, paramRow);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRow(Session paramSession, Row paramRow) {
/* 431 */     checkReadOnly();
/* 432 */     getScanIndex(paramSession).add(paramSession, paramRow);
/*     */   }
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {
/* 437 */     if (this.conn != null) {
/*     */       try {
/* 439 */         this.conn.close(false);
/*     */       } finally {
/* 441 */         this.conn = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized long getRowCount(Session paramSession) {
/* 448 */     String str = "SELECT COUNT(*) FROM " + this.qualifiedTableName;
/*     */     try {
/* 450 */       PreparedStatement preparedStatement = execute(str, (ArrayList<Value>)null, false);
/* 451 */       ResultSet resultSet = preparedStatement.getResultSet();
/* 452 */       resultSet.next();
/* 453 */       long l = resultSet.getLong(1);
/* 454 */       resultSet.close();
/* 455 */       reusePreparedStatement(preparedStatement, str);
/* 456 */       return l;
/* 457 */     } catch (Exception exception) {
/* 458 */       throw wrapException(str, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DbException wrapException(String paramString, Exception paramException) {
/* 470 */     SQLException sQLException = DbException.toSQLException(paramException);
/* 471 */     return DbException.get(90111, sQLException, new String[] { paramString, sQLException.toString() });
/*     */   }
/*     */ 
/*     */   
/*     */   public String getQualifiedTable() {
/* 476 */     return this.qualifiedTableName;
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
/*     */   public PreparedStatement execute(String paramString, ArrayList<Value> paramArrayList, boolean paramBoolean) {
/* 490 */     if (this.conn == null) {
/* 491 */       throw this.connectException;
/*     */     }
/* 493 */     for (byte b = 0;; b++) {
/*     */       try {
/* 495 */         synchronized (this.conn) {
/* 496 */           PreparedStatement preparedStatement = this.preparedMap.remove(paramString);
/* 497 */           if (preparedStatement == null) {
/* 498 */             preparedStatement = this.conn.getConnection().prepareStatement(paramString);
/*     */           }
/* 500 */           if (this.trace.isDebugEnabled()) {
/* 501 */             StatementBuilder statementBuilder = new StatementBuilder();
/* 502 */             statementBuilder.append(getName()).append(":\n").append(paramString);
/* 503 */             if (paramArrayList != null && paramArrayList.size() > 0) {
/* 504 */               statementBuilder.append(" {");
/* 505 */               byte b1 = 1;
/* 506 */               for (Value value : paramArrayList) {
/* 507 */                 statementBuilder.appendExceptFirst(", ");
/* 508 */                 statementBuilder.append(b1++).append(": ").append(value.getSQL());
/*     */               } 
/* 510 */               statementBuilder.append('}');
/*     */             } 
/* 512 */             statementBuilder.append(';');
/* 513 */             this.trace.debug(statementBuilder.toString());
/*     */           } 
/* 515 */           if (paramArrayList != null) {
/* 516 */             byte b1; int i; for (b1 = 0, i = paramArrayList.size(); b1 < i; b1++) {
/* 517 */               Value value = paramArrayList.get(b1);
/* 518 */               value.set(preparedStatement, b1 + 1);
/*     */             } 
/*     */           } 
/* 521 */           preparedStatement.execute();
/* 522 */           if (paramBoolean) {
/* 523 */             reusePreparedStatement(preparedStatement, paramString);
/* 524 */             return null;
/*     */           } 
/* 526 */           return preparedStatement;
/*     */         } 
/* 528 */       } catch (SQLException sQLException) {
/* 529 */         if (b >= 2) {
/* 530 */           throw DbException.convert(sQLException);
/*     */         }
/* 532 */         this.conn.close(true);
/* 533 */         connect();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unlock(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkSupportAlter() {
/* 550 */     throw DbException.getUnsupportedException("LINK");
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 555 */     throw DbException.getUnsupportedException("LINK");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetRowCount() {
/* 560 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDrop() {
/* 565 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTableType() {
/* 570 */     return "TABLE LINK";
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 575 */     super.removeChildrenAndResources(paramSession);
/* 576 */     close(paramSession);
/* 577 */     this.database.removeMeta(paramSession, getId());
/* 578 */     this.driver = null;
/* 579 */     this.url = this.user = this.password = this.originalTable = null;
/* 580 */     this.preparedMap = null;
/* 581 */     invalidate();
/*     */   }
/*     */   
/*     */   public boolean isOracle() {
/* 585 */     return this.url.startsWith("jdbc:oracle:");
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Index> getIndexes() {
/* 590 */     return this.indexes;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMaxDataModificationId() {
/* 596 */     return Long.MAX_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getUniqueIndex() {
/* 601 */     for (Index index : this.indexes) {
/* 602 */       if (index.getIndexType().isUnique()) {
/* 603 */         return index;
/*     */       }
/*     */     } 
/* 606 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRows(Prepared paramPrepared, Session paramSession, RowList paramRowList) {
/*     */     boolean bool;
/* 612 */     checkReadOnly();
/* 613 */     if (this.emitUpdates) {
/* 614 */       paramRowList.reset(); while (paramRowList.hasNext()) {
/* 615 */         paramPrepared.checkCanceled();
/* 616 */         Row row1 = paramRowList.next();
/* 617 */         Row row2 = paramRowList.next();
/* 618 */         this.linkedIndex.update(row1, row2);
/* 619 */         paramSession.log(this, (short)1, row1);
/* 620 */         paramSession.log(this, (short)0, row2);
/*     */       } 
/* 622 */       bool = false;
/*     */     } else {
/* 624 */       bool = true;
/*     */     } 
/* 626 */     if (bool) {
/* 627 */       super.updateRows(paramPrepared, paramSession, paramRowList);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setGlobalTemporary(boolean paramBoolean) {
/* 632 */     this.globalTemporary = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setReadOnly(boolean paramBoolean) {
/* 636 */     this.readOnly = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 641 */     return 100000L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 646 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reusePreparedStatement(PreparedStatement paramPreparedStatement, String paramString) {
/* 656 */     synchronized (this.conn) {
/* 657 */       this.preparedMap.put(paramString, paramPreparedStatement);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDeterministic() {
/* 663 */     return false;
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
/*     */   public void checkWritingAllowed() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void validateConvertUpdateSequence(Session paramSession, Row paramRow) {
/* 684 */     for (byte b = 0; b < this.columns.length; b++) {
/* 685 */       Value value = paramRow.getValue(b);
/* 686 */       if (value != null) {
/*     */         
/* 688 */         Column column = this.columns[b];
/* 689 */         Value value1 = column.validateConvertUpdateSequence(paramSession, value);
/* 690 */         if (value1 != value) {
/* 691 */           paramRow.setValue(b, value1);
/*     */         }
/*     */       } 
/*     */     } 
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
/*     */   public Value getDefaultValue(Session paramSession, Column paramColumn) {
/* 707 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\TableLink.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */