/*     */ package org.h2.jdbc;
/*     */ 
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.message.TraceObject;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.value.DataType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JdbcResultSetMetaData
/*     */   extends TraceObject
/*     */   implements ResultSetMetaData
/*     */ {
/*     */   private final String catalog;
/*     */   private final JdbcResultSet rs;
/*     */   private final JdbcPreparedStatement prep;
/*     */   private final ResultInterface result;
/*     */   private final int columnCount;
/*     */   
/*     */   JdbcResultSetMetaData(JdbcResultSet paramJdbcResultSet, JdbcPreparedStatement paramJdbcPreparedStatement, ResultInterface paramResultInterface, String paramString, Trace paramTrace, int paramInt) {
/*  31 */     setTrace(paramTrace, 5, paramInt);
/*  32 */     this.catalog = paramString;
/*  33 */     this.rs = paramJdbcResultSet;
/*  34 */     this.prep = paramJdbcPreparedStatement;
/*  35 */     this.result = paramResultInterface;
/*  36 */     this.columnCount = paramResultInterface.getVisibleColumnCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumnCount() throws SQLException {
/*     */     try {
/*  48 */       debugCodeCall("getColumnCount");
/*  49 */       checkClosed();
/*  50 */       return this.columnCount;
/*  51 */     } catch (Exception exception) {
/*  52 */       throw logAndConvert(exception);
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
/*     */   public String getColumnLabel(int paramInt) throws SQLException {
/*     */     try {
/*  66 */       debugCodeCall("getColumnLabel", paramInt);
/*  67 */       checkColumnIndex(paramInt);
/*  68 */       return this.result.getAlias(--paramInt);
/*  69 */     } catch (Exception exception) {
/*  70 */       throw logAndConvert(exception);
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
/*     */   public String getColumnName(int paramInt) throws SQLException {
/*     */     try {
/*  84 */       debugCodeCall("getColumnName", paramInt);
/*  85 */       checkColumnIndex(paramInt);
/*  86 */       return this.result.getColumnName(--paramInt);
/*  87 */     } catch (Exception exception) {
/*  88 */       throw logAndConvert(exception);
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
/*     */   public int getColumnType(int paramInt) throws SQLException {
/*     */     try {
/* 103 */       debugCodeCall("getColumnType", paramInt);
/* 104 */       checkColumnIndex(paramInt);
/* 105 */       int i = this.result.getColumnType(--paramInt);
/* 106 */       return DataType.convertTypeToSQLType(i);
/* 107 */     } catch (Exception exception) {
/* 108 */       throw logAndConvert(exception);
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
/*     */   public String getColumnTypeName(int paramInt) throws SQLException {
/*     */     try {
/* 122 */       debugCodeCall("getColumnTypeName", paramInt);
/* 123 */       checkColumnIndex(paramInt);
/* 124 */       int i = this.result.getColumnType(--paramInt);
/* 125 */       return (DataType.getDataType(i)).name;
/* 126 */     } catch (Exception exception) {
/* 127 */       throw logAndConvert(exception);
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
/*     */   public String getSchemaName(int paramInt) throws SQLException {
/*     */     try {
/* 141 */       debugCodeCall("getSchemaName", paramInt);
/* 142 */       checkColumnIndex(paramInt);
/* 143 */       String str = this.result.getSchemaName(--paramInt);
/* 144 */       return (str == null) ? "" : str;
/* 145 */     } catch (Exception exception) {
/* 146 */       throw logAndConvert(exception);
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
/*     */   public String getTableName(int paramInt) throws SQLException {
/*     */     try {
/* 160 */       debugCodeCall("getTableName", paramInt);
/* 161 */       checkColumnIndex(paramInt);
/* 162 */       String str = this.result.getTableName(--paramInt);
/* 163 */       return (str == null) ? "" : str;
/* 164 */     } catch (Exception exception) {
/* 165 */       throw logAndConvert(exception);
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
/*     */   public String getCatalogName(int paramInt) throws SQLException {
/*     */     try {
/* 179 */       debugCodeCall("getCatalogName", paramInt);
/* 180 */       checkColumnIndex(paramInt);
/* 181 */       return (this.catalog == null) ? "" : this.catalog;
/* 182 */     } catch (Exception exception) {
/* 183 */       throw logAndConvert(exception);
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
/*     */   public boolean isAutoIncrement(int paramInt) throws SQLException {
/*     */     try {
/* 197 */       debugCodeCall("isAutoIncrement", paramInt);
/* 198 */       checkColumnIndex(paramInt);
/* 199 */       return this.result.isAutoIncrement(--paramInt);
/* 200 */     } catch (Exception exception) {
/* 201 */       throw logAndConvert(exception);
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
/*     */   public boolean isCaseSensitive(int paramInt) throws SQLException {
/*     */     try {
/* 216 */       debugCodeCall("isCaseSensitive", paramInt);
/* 217 */       checkColumnIndex(paramInt);
/* 218 */       return true;
/* 219 */     } catch (Exception exception) {
/* 220 */       throw logAndConvert(exception);
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
/*     */   public boolean isSearchable(int paramInt) throws SQLException {
/*     */     try {
/* 235 */       debugCodeCall("isSearchable", paramInt);
/* 236 */       checkColumnIndex(paramInt);
/* 237 */       return true;
/* 238 */     } catch (Exception exception) {
/* 239 */       throw logAndConvert(exception);
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
/*     */   public boolean isCurrency(int paramInt) throws SQLException {
/*     */     try {
/* 254 */       debugCodeCall("isCurrency", paramInt);
/* 255 */       checkColumnIndex(paramInt);
/* 256 */       return false;
/* 257 */     } catch (Exception exception) {
/* 258 */       throw logAndConvert(exception);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public int isNullable(int paramInt) throws SQLException {
/*     */     try {
/* 276 */       debugCodeCall("isNullable", paramInt);
/* 277 */       checkColumnIndex(paramInt);
/* 278 */       return this.result.getNullable(--paramInt);
/* 279 */     } catch (Exception exception) {
/* 280 */       throw logAndConvert(exception);
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
/*     */   public boolean isSigned(int paramInt) throws SQLException {
/*     */     try {
/* 295 */       debugCodeCall("isSigned", paramInt);
/* 296 */       checkColumnIndex(paramInt);
/* 297 */       return true;
/* 298 */     } catch (Exception exception) {
/* 299 */       throw logAndConvert(exception);
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
/*     */   public boolean isReadOnly(int paramInt) throws SQLException {
/*     */     try {
/* 314 */       debugCodeCall("isReadOnly", paramInt);
/* 315 */       checkColumnIndex(paramInt);
/* 316 */       return false;
/* 317 */     } catch (Exception exception) {
/* 318 */       throw logAndConvert(exception);
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
/*     */   public boolean isWritable(int paramInt) throws SQLException {
/*     */     try {
/* 333 */       debugCodeCall("isWritable", paramInt);
/* 334 */       checkColumnIndex(paramInt);
/* 335 */       return true;
/* 336 */     } catch (Exception exception) {
/* 337 */       throw logAndConvert(exception);
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
/*     */   public boolean isDefinitelyWritable(int paramInt) throws SQLException {
/*     */     try {
/* 352 */       debugCodeCall("isDefinitelyWritable", paramInt);
/* 353 */       checkColumnIndex(paramInt);
/* 354 */       return false;
/* 355 */     } catch (Exception exception) {
/* 356 */       throw logAndConvert(exception);
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
/*     */   public String getColumnClassName(int paramInt) throws SQLException {
/*     */     try {
/* 371 */       debugCodeCall("getColumnClassName", paramInt);
/* 372 */       checkColumnIndex(paramInt);
/* 373 */       int i = this.result.getColumnType(--paramInt);
/* 374 */       return DataType.getTypeClassName(i);
/* 375 */     } catch (Exception exception) {
/* 376 */       throw logAndConvert(exception);
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
/*     */   public int getPrecision(int paramInt) throws SQLException {
/*     */     try {
/* 390 */       debugCodeCall("getPrecision", paramInt);
/* 391 */       checkColumnIndex(paramInt);
/* 392 */       long l = this.result.getColumnPrecision(--paramInt);
/* 393 */       return MathUtils.convertLongToInt(l);
/* 394 */     } catch (Exception exception) {
/* 395 */       throw logAndConvert(exception);
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
/*     */   public int getScale(int paramInt) throws SQLException {
/*     */     try {
/* 409 */       debugCodeCall("getScale", paramInt);
/* 410 */       checkColumnIndex(paramInt);
/* 411 */       return this.result.getColumnScale(--paramInt);
/* 412 */     } catch (Exception exception) {
/* 413 */       throw logAndConvert(exception);
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
/*     */   public int getColumnDisplaySize(int paramInt) throws SQLException {
/*     */     try {
/* 427 */       debugCodeCall("getColumnDisplaySize", paramInt);
/* 428 */       checkColumnIndex(paramInt);
/* 429 */       return this.result.getDisplaySize(--paramInt);
/* 430 */     } catch (Exception exception) {
/* 431 */       throw logAndConvert(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void checkClosed() {
/* 436 */     if (this.rs != null) {
/* 437 */       this.rs.checkClosed();
/*     */     }
/* 439 */     if (this.prep != null) {
/* 440 */       this.prep.checkClosed();
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkColumnIndex(int paramInt) {
/* 445 */     checkClosed();
/* 446 */     if (paramInt < 1 || paramInt > this.columnCount) {
/* 447 */       throw DbException.getInvalidValueException("columnIndex", Integer.valueOf(paramInt));
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
/*     */   public <T> T unwrap(Class<T> paramClass) throws SQLException {
/* 460 */     if (isWrapperFor(paramClass)) {
/* 461 */       return (T)this;
/*     */     }
/* 463 */     throw DbException.getInvalidValueException("iface", paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWrapperFor(Class<?> paramClass) throws SQLException {
/* 474 */     return (paramClass != null && paramClass.isAssignableFrom(getClass()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 482 */     return getTraceObjectName() + ": columns=" + this.columnCount;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcResultSetMetaData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */