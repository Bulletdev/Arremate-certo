/*      */ package org.h2.value;
/*      */ 
/*      */ import java.io.BufferedReader;
/*      */ import java.io.InputStream;
/*      */ import java.io.Reader;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.sql.Array;
/*      */ import java.sql.Blob;
/*      */ import java.sql.Clob;
/*      */ import java.sql.Date;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.ResultSetMetaData;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Time;
/*      */ import java.sql.Timestamp;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.UUID;
/*      */ import org.h2.api.TimestampWithTimeZone;
/*      */ import org.h2.engine.Constants;
/*      */ import org.h2.engine.SessionInterface;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.jdbc.JdbcBlob;
/*      */ import org.h2.jdbc.JdbcClob;
/*      */ import org.h2.jdbc.JdbcConnection;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.util.JdbcUtils;
/*      */ import org.h2.util.LocalDateTimeUtils;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.Utils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DataType
/*      */ {
/*      */   public static final int TYPE_RESULT_SET = -10;
/*      */   public static final Class<?> GEOMETRY_CLASS;
/*      */   private static final String GEOMETRY_CLASS_NAME = "com.vividsolutions.jts.geom.Geometry";
/*   68 */   private static final ArrayList<DataType> TYPES = New.arrayList();
/*   69 */   private static final HashMap<String, DataType> TYPES_BY_NAME = New.hashMap();
/*   70 */   private static final HashMap<Integer, DataType> TYPES_BY_VALUE_TYPE = New.hashMap();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int type;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String name;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sqlType;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String jdbc;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sqlTypePos;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long maxPrecision;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int minScale;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int maxScale;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean decimal;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String prefix;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String suffix;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String params;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean autoIncrement;
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean caseSensitive;
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsPrecision;
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsScale;
/*      */ 
/*      */ 
/*      */   
/*      */   public long defaultPrecision;
/*      */ 
/*      */ 
/*      */   
/*      */   public int defaultScale;
/*      */ 
/*      */ 
/*      */   
/*      */   public int defaultDisplaySize;
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hidden;
/*      */ 
/*      */ 
/*      */   
/*      */   public int memory;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*      */     Class clazz;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*      */     try {
/*  181 */       clazz = JdbcUtils.loadUserClass("com.vividsolutions.jts.geom.Geometry");
/*  182 */     } catch (Exception exception) {
/*      */       
/*  184 */       clazz = null;
/*      */     } 
/*  186 */     GEOMETRY_CLASS = clazz;
/*      */ 
/*      */ 
/*      */     
/*  190 */     add(0, 0, "Null", new DataType(), new String[] { "NULL" }, 0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  196 */     add(13, 12, "String", createString(true), new String[] { "VARCHAR", "VARCHAR2", "NVARCHAR", "NVARCHAR2", "VARCHAR_CASESENSITIVE", "CHARACTER VARYING", "TID" }, 48);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  203 */     add(13, -1, "String", createString(true), new String[] { "LONGVARCHAR", "LONGNVARCHAR" }, 48);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  208 */     add(21, 1, "String", createString(true), new String[] { "CHAR", "CHARACTER", "NCHAR" }, 48);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  213 */     add(14, 12, "String", createString(false), new String[] { "VARCHAR_IGNORECASE" }, 48);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  218 */     add(1, 16, "Boolean", createDecimal(1, 1, 0, 5, false, false), new String[] { "BOOLEAN", "BIT", "BOOL" }, 0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  225 */     add(2, -6, "Byte", createDecimal(3, 3, 0, 4, false, false), new String[] { "TINYINT" }, 1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  232 */     add(3, 5, "Short", createDecimal(5, 5, 0, 6, false, false), new String[] { "SMALLINT", "YEAR", "INT2" }, 20);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  239 */     add(4, 4, "Int", createDecimal(10, 10, 0, 11, false, false), new String[] { "INTEGER", "INT", "MEDIUMINT", "INT4", "SIGNED" }, 20);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  246 */     add(4, 4, "Int", createDecimal(10, 10, 0, 11, false, true), new String[] { "SERIAL" }, 20);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  252 */     add(5, -5, "Long", createDecimal(19, 19, 0, 20, false, false), new String[] { "BIGINT", "INT8", "LONG" }, 24);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  258 */     add(5, -5, "Long", createDecimal(19, 19, 0, 20, false, true), new String[] { "IDENTITY", "BIGSERIAL" }, 24);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  264 */     add(6, 3, "BigDecimal", createDecimal(2147483647, 65535, 32767, 65535, true, false), new String[] { "DECIMAL", "DEC" }, 64);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  273 */     add(6, 2, "BigDecimal", createDecimal(2147483647, 65535, 32767, 65535, true, false), new String[] { "NUMERIC", "NUMBER" }, 64);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  281 */     add(8, 7, "Float", createDecimal(7, 7, 0, 15, false, false), new String[] { "REAL", "FLOAT4" }, 24);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  287 */     add(7, 8, "Double", createDecimal(17, 17, 0, 24, false, false), new String[] { "DOUBLE", "DOUBLE PRECISION" }, 24);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  293 */     add(7, 6, "Double", createDecimal(17, 17, 0, 24, false, false), new String[] { "FLOAT", "FLOAT8" }, 24);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  299 */     add(9, 92, "Time", createDate(6, "TIME", 0, 8), new String[] { "TIME" }, 56);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  305 */     add(10, 91, "Date", createDate(8, "DATE", 0, 10), new String[] { "DATE" }, 56);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  311 */     add(11, 93, "Timestamp", createDate(23, "TIMESTAMP", 10, 23), new String[] { "TIMESTAMP", "DATETIME", "DATETIME2", "SMALLDATETIME" }, 56);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  318 */     add(24, 1111, "TimestampTimeZone", createDate(30, "TIMESTAMP_TZ", 10, 30), new String[] { "TIMESTAMP WITH TIMEZONE" }, 58);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  325 */     add(12, -3, "Bytes", createString(false), new String[] { "VARBINARY" }, 32);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  330 */     add(12, -2, "Bytes", createString(false), new String[] { "BINARY", "RAW", "BYTEA", "LONG RAW" }, 32);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  335 */     add(12, -4, "Bytes", createString(false), new String[] { "LONGVARBINARY" }, 32);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  340 */     add(20, -2, "Bytes", createString(false), new String[] { "UUID" }, 32);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  345 */     add(19, 1111, "Object", createString(false), new String[] { "OTHER", "OBJECT", "JAVA_OBJECT" }, 24);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  350 */     add(15, 2004, "Blob", createLob(), new String[] { "BLOB", "TINYBLOB", "MEDIUMBLOB", "LONGBLOB", "IMAGE", "OID" }, 104);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  357 */     add(16, 2005, "Clob", createLob(), new String[] { "CLOB", "TINYTEXT", "TEXT", "MEDIUMTEXT", "LONGTEXT", "NTEXT", "NCLOB" }, 104);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  364 */     add(22, 1111, "Geometry", createString(false), new String[] { "GEOMETRY" }, 32);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  369 */     DataType dataType = new DataType();
/*  370 */     dataType.prefix = "(";
/*  371 */     dataType.suffix = "')";
/*  372 */     add(17, 2003, "Array", dataType, new String[] { "ARRAY" }, 32);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  377 */     dataType = new DataType();
/*  378 */     add(18, -10, "ResultSet", dataType, new String[] { "RESULT_SET" }, 400);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  383 */     for (Integer integer : TYPES_BY_VALUE_TYPE.keySet()) {
/*  384 */       Value.getOrder(integer.intValue());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static void add(int paramInt1, int paramInt2, String paramString, DataType paramDataType, String[] paramArrayOfString, int paramInt3) {
/*  390 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  391 */       DataType dataType = new DataType();
/*  392 */       dataType.type = paramInt1;
/*  393 */       dataType.sqlType = paramInt2;
/*  394 */       dataType.jdbc = paramString;
/*  395 */       dataType.name = paramArrayOfString[b];
/*  396 */       dataType.autoIncrement = paramDataType.autoIncrement;
/*  397 */       dataType.decimal = paramDataType.decimal;
/*  398 */       dataType.maxPrecision = paramDataType.maxPrecision;
/*  399 */       dataType.maxScale = paramDataType.maxScale;
/*  400 */       dataType.minScale = paramDataType.minScale;
/*  401 */       dataType.params = paramDataType.params;
/*  402 */       dataType.prefix = paramDataType.prefix;
/*  403 */       dataType.suffix = paramDataType.suffix;
/*  404 */       dataType.supportsPrecision = paramDataType.supportsPrecision;
/*  405 */       dataType.supportsScale = paramDataType.supportsScale;
/*  406 */       dataType.defaultPrecision = paramDataType.defaultPrecision;
/*  407 */       dataType.defaultScale = paramDataType.defaultScale;
/*  408 */       dataType.defaultDisplaySize = paramDataType.defaultDisplaySize;
/*  409 */       dataType.caseSensitive = paramDataType.caseSensitive;
/*  410 */       dataType.hidden = (b > 0);
/*  411 */       dataType.memory = paramInt3;
/*  412 */       for (DataType dataType1 : TYPES) {
/*  413 */         if (dataType1.sqlType == dataType.sqlType) {
/*  414 */           dataType.sqlTypePos++;
/*      */         }
/*      */       } 
/*  417 */       TYPES_BY_NAME.put(dataType.name, dataType);
/*  418 */       if (TYPES_BY_VALUE_TYPE.get(Integer.valueOf(paramInt1)) == null) {
/*  419 */         TYPES_BY_VALUE_TYPE.put(Integer.valueOf(paramInt1), dataType);
/*      */       }
/*  421 */       TYPES.add(dataType);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static DataType createDecimal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/*  428 */     DataType dataType = new DataType();
/*  429 */     dataType.maxPrecision = paramInt1;
/*  430 */     dataType.defaultPrecision = paramInt2;
/*  431 */     dataType.defaultScale = paramInt3;
/*  432 */     dataType.defaultDisplaySize = paramInt4;
/*  433 */     if (paramBoolean1) {
/*  434 */       dataType.params = "PRECISION,SCALE";
/*  435 */       dataType.supportsPrecision = true;
/*  436 */       dataType.supportsScale = true;
/*      */     } 
/*  438 */     dataType.decimal = true;
/*  439 */     dataType.autoIncrement = paramBoolean2;
/*  440 */     return dataType;
/*      */   }
/*      */ 
/*      */   
/*      */   private static DataType createDate(int paramInt1, String paramString, int paramInt2, int paramInt3) {
/*  445 */     DataType dataType = new DataType();
/*  446 */     dataType.prefix = paramString + " '";
/*  447 */     dataType.suffix = "'";
/*  448 */     dataType.maxPrecision = paramInt1;
/*  449 */     dataType.supportsScale = (paramInt2 != 0);
/*  450 */     dataType.maxScale = paramInt2;
/*  451 */     dataType.defaultPrecision = paramInt1;
/*  452 */     dataType.defaultScale = paramInt2;
/*  453 */     dataType.defaultDisplaySize = paramInt3;
/*  454 */     return dataType;
/*      */   }
/*      */   
/*      */   private static DataType createString(boolean paramBoolean) {
/*  458 */     DataType dataType = new DataType();
/*  459 */     dataType.prefix = "'";
/*  460 */     dataType.suffix = "'";
/*  461 */     dataType.params = "LENGTH";
/*  462 */     dataType.caseSensitive = paramBoolean;
/*  463 */     dataType.supportsPrecision = true;
/*  464 */     dataType.maxPrecision = 2147483647L;
/*  465 */     dataType.defaultPrecision = 2147483647L;
/*  466 */     dataType.defaultDisplaySize = Integer.MAX_VALUE;
/*  467 */     return dataType;
/*      */   }
/*      */   
/*      */   private static DataType createLob() {
/*  471 */     DataType dataType = createString(true);
/*  472 */     dataType.maxPrecision = Long.MAX_VALUE;
/*  473 */     dataType.defaultPrecision = Long.MAX_VALUE;
/*  474 */     return dataType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ArrayList<DataType> getTypes() {
/*  483 */     return TYPES; } public static Value readValue(SessionInterface paramSessionInterface, ResultSet paramResultSet, int paramInt1, int paramInt2) { 
/*      */     try { Value value; byte[] arrayOfByte; boolean bool; byte b; Date date; Time time; Timestamp timestamp; TimestampWithTimeZone timestampWithTimeZone; BigDecimal bigDecimal;
/*      */       double d;
/*      */       float f;
/*      */       int i;
/*      */       long l;
/*      */       short s;
/*      */       String str;
/*      */       InputStream inputStream;
/*      */       Array array;
/*      */       ResultSet resultSet;
/*      */       Object object;
/*      */       Object[] arrayOfObject;
/*      */       int j;
/*      */       Value[] arrayOfValue;
/*      */       byte b1;
/*  499 */       switch (paramInt2)
/*      */       { case 0:
/*  501 */           return ValueNull.INSTANCE;
/*      */         
/*      */         case 12:
/*  504 */           arrayOfByte = paramResultSet.getBytes(paramInt1);
/*  505 */           value = (Value)((arrayOfByte == null) ? ValueNull.INSTANCE : ValueBytes.getNoCopy(arrayOfByte));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  684 */           return value;case 20: arrayOfByte = paramResultSet.getBytes(paramInt1); value = (arrayOfByte == null) ? ValueNull.INSTANCE : ValueUuid.get(arrayOfByte); return value;case 1: bool = paramResultSet.getBoolean(paramInt1); value = paramResultSet.wasNull() ? ValueNull.INSTANCE : ValueBoolean.get(bool); return value;case 2: b = paramResultSet.getByte(paramInt1); value = paramResultSet.wasNull() ? ValueNull.INSTANCE : ValueByte.get(b); return value;case 10: date = paramResultSet.getDate(paramInt1); value = (date == null) ? ValueNull.INSTANCE : ValueDate.get(date); return value;case 9: time = paramResultSet.getTime(paramInt1); value = (time == null) ? ValueNull.INSTANCE : ValueTime.get(time); return value;case 11: timestamp = paramResultSet.getTimestamp(paramInt1); value = (timestamp == null) ? ValueNull.INSTANCE : ValueTimestamp.get(timestamp); return value;case 24: timestampWithTimeZone = (TimestampWithTimeZone)paramResultSet.getObject(paramInt1); value = (timestampWithTimeZone == null) ? ValueNull.INSTANCE : ValueTimestampTimeZone.get(timestampWithTimeZone); return value;case 6: bigDecimal = paramResultSet.getBigDecimal(paramInt1); value = (bigDecimal == null) ? ValueNull.INSTANCE : ValueDecimal.get(bigDecimal); return value;case 7: d = paramResultSet.getDouble(paramInt1); value = paramResultSet.wasNull() ? ValueNull.INSTANCE : ValueDouble.get(d); return value;case 8: f = paramResultSet.getFloat(paramInt1); value = paramResultSet.wasNull() ? ValueNull.INSTANCE : ValueFloat.get(f); return value;case 4: i = paramResultSet.getInt(paramInt1); value = paramResultSet.wasNull() ? ValueNull.INSTANCE : ValueInt.get(i); return value;case 5: l = paramResultSet.getLong(paramInt1); value = paramResultSet.wasNull() ? ValueNull.INSTANCE : ValueLong.get(l); return value;case 3: s = paramResultSet.getShort(paramInt1); value = paramResultSet.wasNull() ? ValueNull.INSTANCE : ValueShort.get(s); return value;case 14: str = paramResultSet.getString(paramInt1); value = (str == null) ? ValueNull.INSTANCE : ValueStringIgnoreCase.get(str); return value;case 21: str = paramResultSet.getString(paramInt1); value = (str == null) ? ValueNull.INSTANCE : ValueStringFixed.get(str); return value;case 13: str = paramResultSet.getString(paramInt1); value = (str == null) ? ValueNull.INSTANCE : ValueString.get(str); return value;case 16: if (paramSessionInterface == null) { str = paramResultSet.getString(paramInt1); value = (str == null) ? ValueNull.INSTANCE : ValueLobDb.createSmallLob(16, str.getBytes(Constants.UTF8)); } else { Reader reader = paramResultSet.getCharacterStream(paramInt1); if (reader == null) { value = ValueNull.INSTANCE; } else { value = paramSessionInterface.getDataHandler().getLobStorage().createClob(new BufferedReader(reader), -1L); }  }  if (paramSessionInterface != null) paramSessionInterface.addTemporaryLob(value);  return value;case 15: if (paramSessionInterface == null) { byte[] arrayOfByte1 = paramResultSet.getBytes(paramInt1); return (arrayOfByte1 == null) ? ValueNull.INSTANCE : ValueLobDb.createSmallLob(15, arrayOfByte1); }  inputStream = paramResultSet.getBinaryStream(paramInt1); value = (inputStream == null) ? ValueNull.INSTANCE : paramSessionInterface.getDataHandler().getLobStorage().createBlob(inputStream, -1L); if (paramSessionInterface != null) paramSessionInterface.addTemporaryLob(value);  return value;case 19: if (SysProperties.serializeJavaObject) { byte[] arrayOfByte1 = paramResultSet.getBytes(paramInt1); value = (arrayOfByte1 == null) ? ValueNull.INSTANCE : ValueJavaObject.getNoCopy(null, arrayOfByte1, paramSessionInterface.getDataHandler()); } else { Object object1 = paramResultSet.getObject(paramInt1); value = (object1 == null) ? ValueNull.INSTANCE : ValueJavaObject.getNoCopy(object1, null, paramSessionInterface.getDataHandler()); }  return value;case 17: array = paramResultSet.getArray(paramInt1); if (array == null) return ValueNull.INSTANCE;  arrayOfObject = (Object[])array.getArray(); if (arrayOfObject == null) return ValueNull.INSTANCE;  j = arrayOfObject.length; arrayOfValue = new Value[j]; for (b1 = 0; b1 < j; b1++) arrayOfValue[b1] = convertToValue(paramSessionInterface, arrayOfObject[b1], 0);  value = ValueArray.get(arrayOfValue); return value;case 18: resultSet = (ResultSet)paramResultSet.getObject(paramInt1); if (resultSet == null) return ValueNull.INSTANCE;  return ValueResultSet.get(resultSet);case 22: object = paramResultSet.getObject(paramInt1); if (object == null)
/*  685 */             return ValueNull.INSTANCE;  return ValueGeometry.getFromGeometry(object); }  throw DbException.throwInternalError("type=" + paramInt2); } catch (SQLException sQLException)
/*  686 */     { throw DbException.convert(sQLException); }
/*      */      }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getTypeClassName(int paramInt) {
/*  697 */     switch (paramInt) {
/*      */       
/*      */       case 1:
/*  700 */         return Boolean.class.getName();
/*      */       
/*      */       case 2:
/*  703 */         return Byte.class.getName();
/*      */       
/*      */       case 3:
/*  706 */         return Short.class.getName();
/*      */       
/*      */       case 4:
/*  709 */         return Integer.class.getName();
/*      */       
/*      */       case 5:
/*  712 */         return Long.class.getName();
/*      */       
/*      */       case 6:
/*  715 */         return BigDecimal.class.getName();
/*      */       
/*      */       case 9:
/*  718 */         return Time.class.getName();
/*      */       
/*      */       case 10:
/*  721 */         return Date.class.getName();
/*      */       
/*      */       case 11:
/*  724 */         return Timestamp.class.getName();
/*      */       
/*      */       case 24:
/*  727 */         return TimestampWithTimeZone.class.getName();
/*      */       
/*      */       case 12:
/*      */       case 20:
/*  731 */         return byte[].class.getName();
/*      */       
/*      */       case 13:
/*      */       case 14:
/*      */       case 21:
/*  736 */         return String.class.getName();
/*      */       
/*      */       case 15:
/*  739 */         return Blob.class.getName();
/*      */       
/*      */       case 16:
/*  742 */         return Clob.class.getName();
/*      */       
/*      */       case 7:
/*  745 */         return Double.class.getName();
/*      */       
/*      */       case 8:
/*  748 */         return Float.class.getName();
/*      */       case 0:
/*  750 */         return null;
/*      */       
/*      */       case 19:
/*  753 */         return Object.class.getName();
/*      */       
/*      */       case -1:
/*  756 */         return Object.class.getName();
/*      */       case 17:
/*  758 */         return Array.class.getName();
/*      */       case 18:
/*  760 */         return ResultSet.class.getName();
/*      */       case 22:
/*  762 */         return "com.vividsolutions.jts.geom.Geometry";
/*      */     } 
/*  764 */     throw DbException.throwInternalError("type=" + paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static DataType getDataType(int paramInt) {
/*  775 */     if (paramInt == -1) {
/*  776 */       throw DbException.get(50004, "?");
/*      */     }
/*  778 */     DataType dataType = TYPES_BY_VALUE_TYPE.get(Integer.valueOf(paramInt));
/*  779 */     if (dataType == null) {
/*  780 */       dataType = TYPES_BY_VALUE_TYPE.get(Integer.valueOf(0));
/*      */     }
/*  782 */     return dataType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int convertTypeToSQLType(int paramInt) {
/*  792 */     return (getDataType(paramInt)).sqlType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int convertSQLTypeToValueType(int paramInt, String paramString) {
/*  804 */     switch (paramInt) {
/*      */       case 1111:
/*      */       case 2000:
/*  807 */         if (paramString.equalsIgnoreCase("geometry"))
/*  808 */           return 22; 
/*      */         break;
/*      */     } 
/*  811 */     return convertSQLTypeToValueType(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getValueTypeFromResultSet(ResultSetMetaData paramResultSetMetaData, int paramInt) throws SQLException {
/*  824 */     return convertSQLTypeToValueType(paramResultSetMetaData.getColumnType(paramInt), paramResultSetMetaData.getColumnTypeName(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int convertSQLTypeToValueType(int paramInt) {
/*  836 */     switch (paramInt) {
/*      */       case -15:
/*      */       case 1:
/*  839 */         return 21;
/*      */       case -16:
/*      */       case -9:
/*      */       case -1:
/*      */       case 12:
/*  844 */         return 13;
/*      */       case 2:
/*      */       case 3:
/*  847 */         return 6;
/*      */       case -7:
/*      */       case 16:
/*  850 */         return 1;
/*      */       case 4:
/*  852 */         return 4;
/*      */       case 5:
/*  854 */         return 3;
/*      */       case -6:
/*  856 */         return 2;
/*      */       case -5:
/*  858 */         return 5;
/*      */       case 7:
/*  860 */         return 8;
/*      */       case 6:
/*      */       case 8:
/*  863 */         return 7;
/*      */       case -4:
/*      */       case -3:
/*      */       case -2:
/*  867 */         return 12;
/*      */       case 1111:
/*      */       case 2000:
/*  870 */         return 19;
/*      */       case 91:
/*  872 */         return 10;
/*      */       case 92:
/*  874 */         return 9;
/*      */       case 93:
/*  876 */         return 11;
/*      */       case 2004:
/*  878 */         return 15;
/*      */       case 2005:
/*      */       case 2011:
/*  881 */         return 16;
/*      */       case 0:
/*  883 */         return 0;
/*      */       case 2003:
/*  885 */         return 17;
/*      */       case -10:
/*  887 */         return 18;
/*      */     } 
/*  889 */     throw DbException.get(50004, "" + paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getTypeFromClass(Class<?> paramClass) {
/*  902 */     if (paramClass == null || void.class == paramClass) {
/*  903 */       return 0;
/*      */     }
/*  905 */     if (paramClass.isPrimitive()) {
/*  906 */       paramClass = Utils.getNonPrimitiveClass(paramClass);
/*      */     }
/*  908 */     if (String.class == paramClass)
/*  909 */       return 13; 
/*  910 */     if (Integer.class == paramClass)
/*  911 */       return 4; 
/*  912 */     if (Long.class == paramClass)
/*  913 */       return 5; 
/*  914 */     if (Boolean.class == paramClass)
/*  915 */       return 1; 
/*  916 */     if (Double.class == paramClass)
/*  917 */       return 7; 
/*  918 */     if (Byte.class == paramClass)
/*  919 */       return 2; 
/*  920 */     if (Short.class == paramClass)
/*  921 */       return 3; 
/*  922 */     if (Character.class == paramClass) {
/*  923 */       throw DbException.get(22018, "char (not supported)");
/*      */     }
/*  925 */     if (Float.class == paramClass)
/*  926 */       return 8; 
/*  927 */     if (byte[].class == paramClass)
/*  928 */       return 12; 
/*  929 */     if (UUID.class == paramClass)
/*  930 */       return 20; 
/*  931 */     if (Void.class == paramClass)
/*  932 */       return 0; 
/*  933 */     if (BigDecimal.class.isAssignableFrom(paramClass))
/*  934 */       return 6; 
/*  935 */     if (ResultSet.class.isAssignableFrom(paramClass))
/*  936 */       return 18; 
/*  937 */     if (Value.ValueBlob.class.isAssignableFrom(paramClass))
/*  938 */       return 15; 
/*  939 */     if (Value.ValueClob.class.isAssignableFrom(paramClass))
/*  940 */       return 16; 
/*  941 */     if (Date.class.isAssignableFrom(paramClass))
/*  942 */       return 10; 
/*  943 */     if (Time.class.isAssignableFrom(paramClass))
/*  944 */       return 9; 
/*  945 */     if (Timestamp.class.isAssignableFrom(paramClass))
/*  946 */       return 11; 
/*  947 */     if (Date.class.isAssignableFrom(paramClass))
/*  948 */       return 11; 
/*  949 */     if (Reader.class.isAssignableFrom(paramClass))
/*  950 */       return 16; 
/*  951 */     if (Clob.class.isAssignableFrom(paramClass))
/*  952 */       return 16; 
/*  953 */     if (InputStream.class.isAssignableFrom(paramClass))
/*  954 */       return 15; 
/*  955 */     if (Blob.class.isAssignableFrom(paramClass))
/*  956 */       return 15; 
/*  957 */     if (Object[].class.isAssignableFrom(paramClass))
/*      */     {
/*  959 */       return 17; } 
/*  960 */     if (isGeometryClass(paramClass))
/*  961 */       return 22; 
/*  962 */     if (LocalDateTimeUtils.isLocalDate(paramClass))
/*  963 */       return 10; 
/*  964 */     if (LocalDateTimeUtils.isLocalTime(paramClass))
/*  965 */       return 9; 
/*  966 */     if (LocalDateTimeUtils.isLocalDateTime(paramClass))
/*  967 */       return 11; 
/*  968 */     if (LocalDateTimeUtils.isOffsetDateTime(paramClass)) {
/*  969 */       return 24;
/*      */     }
/*  971 */     return 19;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Value convertToValue(SessionInterface paramSessionInterface, Object paramObject, int paramInt) {
/*  985 */     Value value = convertToValue1(paramSessionInterface, paramObject, paramInt);
/*  986 */     if (paramSessionInterface != null) {
/*  987 */       paramSessionInterface.addTemporaryLob(value);
/*      */     }
/*  989 */     return value;
/*      */   }
/*      */ 
/*      */   
/*      */   private static Value convertToValue1(SessionInterface paramSessionInterface, Object paramObject, int paramInt) {
/*  994 */     if (paramObject == null) {
/*  995 */       return ValueNull.INSTANCE;
/*      */     }
/*  997 */     if (paramInt == 19) {
/*  998 */       return ValueJavaObject.getNoCopy(paramObject, null, paramSessionInterface.getDataHandler());
/*      */     }
/* 1000 */     if (paramObject instanceof String)
/* 1001 */       return ValueString.get((String)paramObject); 
/* 1002 */     if (paramObject instanceof Value)
/* 1003 */       return (Value)paramObject; 
/* 1004 */     if (paramObject instanceof Long)
/* 1005 */       return ValueLong.get(((Long)paramObject).longValue()); 
/* 1006 */     if (paramObject instanceof Integer)
/* 1007 */       return ValueInt.get(((Integer)paramObject).intValue()); 
/* 1008 */     if (paramObject instanceof BigInteger)
/* 1009 */       return ValueDecimal.get(new BigDecimal((BigInteger)paramObject)); 
/* 1010 */     if (paramObject instanceof BigDecimal)
/* 1011 */       return ValueDecimal.get((BigDecimal)paramObject); 
/* 1012 */     if (paramObject instanceof Boolean)
/* 1013 */       return ValueBoolean.get(((Boolean)paramObject).booleanValue()); 
/* 1014 */     if (paramObject instanceof Byte)
/* 1015 */       return ValueByte.get(((Byte)paramObject).byteValue()); 
/* 1016 */     if (paramObject instanceof Short)
/* 1017 */       return ValueShort.get(((Short)paramObject).shortValue()); 
/* 1018 */     if (paramObject instanceof Float)
/* 1019 */       return ValueFloat.get(((Float)paramObject).floatValue()); 
/* 1020 */     if (paramObject instanceof Double)
/* 1021 */       return ValueDouble.get(((Double)paramObject).doubleValue()); 
/* 1022 */     if (paramObject instanceof byte[])
/* 1023 */       return ValueBytes.get((byte[])paramObject); 
/* 1024 */     if (paramObject instanceof Date)
/* 1025 */       return ValueDate.get((Date)paramObject); 
/* 1026 */     if (paramObject instanceof Time)
/* 1027 */       return ValueTime.get((Time)paramObject); 
/* 1028 */     if (paramObject instanceof Timestamp)
/* 1029 */       return ValueTimestamp.get((Timestamp)paramObject); 
/* 1030 */     if (paramObject instanceof Date)
/* 1031 */       return ValueTimestamp.fromMillis(((Date)paramObject).getTime()); 
/* 1032 */     if (paramObject instanceof Reader) {
/* 1033 */       BufferedReader bufferedReader = new BufferedReader((Reader)paramObject);
/* 1034 */       return paramSessionInterface.getDataHandler().getLobStorage().createClob(bufferedReader, -1L);
/*      */     } 
/* 1036 */     if (paramObject instanceof Clob)
/*      */       try {
/* 1038 */         Clob clob = (Clob)paramObject;
/* 1039 */         BufferedReader bufferedReader = new BufferedReader(clob.getCharacterStream());
/* 1040 */         return paramSessionInterface.getDataHandler().getLobStorage().createClob(bufferedReader, clob.length());
/*      */       }
/* 1042 */       catch (SQLException sQLException) {
/* 1043 */         throw DbException.convert(sQLException);
/*      */       }  
/* 1045 */     if (paramObject instanceof InputStream) {
/* 1046 */       return paramSessionInterface.getDataHandler().getLobStorage().createBlob((InputStream)paramObject, -1L);
/*      */     }
/* 1048 */     if (paramObject instanceof Blob)
/*      */       try {
/* 1050 */         Blob blob = (Blob)paramObject;
/* 1051 */         return paramSessionInterface.getDataHandler().getLobStorage().createBlob(blob.getBinaryStream(), blob.length());
/*      */       }
/* 1053 */       catch (SQLException sQLException) {
/* 1054 */         throw DbException.convert(sQLException);
/*      */       }  
/* 1056 */     if (paramObject instanceof ResultSet) {
/* 1057 */       if (paramObject instanceof org.h2.tools.SimpleResultSet) {
/* 1058 */         return ValueResultSet.get((ResultSet)paramObject);
/*      */       }
/* 1060 */       return ValueResultSet.getCopy((ResultSet)paramObject, 2147483647);
/* 1061 */     }  if (paramObject instanceof UUID) {
/* 1062 */       UUID uUID = (UUID)paramObject;
/* 1063 */       return ValueUuid.get(uUID.getMostSignificantBits(), uUID.getLeastSignificantBits());
/* 1064 */     }  if (paramObject instanceof Object[]) {
/*      */ 
/*      */       
/* 1067 */       Object[] arrayOfObject = (Object[])paramObject;
/* 1068 */       int i = arrayOfObject.length;
/* 1069 */       Value[] arrayOfValue = new Value[i];
/* 1070 */       for (byte b = 0; b < i; b++) {
/* 1071 */         arrayOfValue[b] = convertToValue(paramSessionInterface, arrayOfObject[b], paramInt);
/*      */       }
/* 1073 */       return ValueArray.get(paramObject.getClass().getComponentType(), arrayOfValue);
/* 1074 */     }  if (paramObject instanceof Character)
/* 1075 */       return ValueStringFixed.get(((Character)paramObject).toString()); 
/* 1076 */     if (isGeometry(paramObject))
/* 1077 */       return ValueGeometry.getFromGeometry(paramObject); 
/* 1078 */     if (LocalDateTimeUtils.isLocalDate(paramObject.getClass()))
/* 1079 */       return LocalDateTimeUtils.localDateToDateValue(paramObject); 
/* 1080 */     if (LocalDateTimeUtils.isLocalTime(paramObject.getClass()))
/* 1081 */       return LocalDateTimeUtils.localTimeToTimeValue(paramObject); 
/* 1082 */     if (LocalDateTimeUtils.isLocalDateTime(paramObject.getClass()))
/* 1083 */       return LocalDateTimeUtils.localDateTimeToValue(paramObject); 
/* 1084 */     if (LocalDateTimeUtils.isOffsetDateTime(paramObject.getClass())) {
/* 1085 */       return LocalDateTimeUtils.offsetDateTimeToValue(paramObject);
/*      */     }
/* 1087 */     return ValueJavaObject.getNoCopy(paramObject, null, paramSessionInterface.getDataHandler());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isGeometryClass(Class<?> paramClass) {
/* 1099 */     if (paramClass == null || GEOMETRY_CLASS == null) {
/* 1100 */       return false;
/*      */     }
/* 1102 */     return GEOMETRY_CLASS.isAssignableFrom(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isGeometry(Object paramObject) {
/* 1112 */     if (paramObject == null) {
/* 1113 */       return false;
/*      */     }
/* 1115 */     return isGeometryClass(paramObject.getClass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static DataType getTypeByName(String paramString) {
/* 1125 */     return TYPES_BY_NAME.get(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isLargeObject(int paramInt) {
/* 1135 */     if (paramInt == 15 || paramInt == 16) {
/* 1136 */       return true;
/*      */     }
/* 1138 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isStringType(int paramInt) {
/* 1148 */     if (paramInt == 13 || paramInt == 21 || paramInt == 14)
/*      */     {
/* 1150 */       return true;
/*      */     }
/* 1152 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean supportsAdd(int paramInt) {
/* 1162 */     switch (paramInt) {
/*      */       case 2:
/*      */       case 3:
/*      */       case 4:
/*      */       case 5:
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/* 1170 */         return true;
/*      */     } 
/* 1172 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getAddProofType(int paramInt) {
/* 1184 */     switch (paramInt) {
/*      */       case 2:
/* 1186 */         return 5;
/*      */       case 8:
/* 1188 */         return 7;
/*      */       case 4:
/* 1190 */         return 5;
/*      */       case 5:
/* 1192 */         return 6;
/*      */       case 3:
/* 1194 */         return 5;
/*      */     } 
/* 1196 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object getDefaultForPrimitiveType(Class<?> paramClass) {
/* 1208 */     if (paramClass == boolean.class)
/* 1209 */       return Boolean.FALSE; 
/* 1210 */     if (paramClass == byte.class)
/* 1211 */       return Byte.valueOf((byte)0); 
/* 1212 */     if (paramClass == char.class)
/* 1213 */       return Character.valueOf(false); 
/* 1214 */     if (paramClass == short.class)
/* 1215 */       return Short.valueOf((short)0); 
/* 1216 */     if (paramClass == int.class)
/* 1217 */       return Integer.valueOf(0); 
/* 1218 */     if (paramClass == long.class)
/* 1219 */       return Long.valueOf(0L); 
/* 1220 */     if (paramClass == float.class)
/* 1221 */       return Float.valueOf(0.0F); 
/* 1222 */     if (paramClass == double.class) {
/* 1223 */       return Double.valueOf(0.0D);
/*      */     }
/* 1225 */     throw DbException.throwInternalError("primitive=" + paramClass.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object convertTo(JdbcConnection paramJdbcConnection, Value paramValue, Class<?> paramClass) {
/* 1239 */     if (paramClass == Blob.class)
/* 1240 */       return new JdbcBlob(paramJdbcConnection, paramValue, 0); 
/* 1241 */     if (paramClass == Clob.class) {
/* 1242 */       return new JdbcClob(paramJdbcConnection, paramValue, 0);
/*      */     }
/* 1244 */     if (paramValue.getType() == 19) {
/* 1245 */       Object object = SysProperties.serializeJavaObject ? JdbcUtils.deserialize(paramValue.getBytes(), paramJdbcConnection.getSession().getDataHandler()) : paramValue.getObject();
/*      */       
/* 1247 */       if (paramClass.isAssignableFrom(object.getClass())) {
/* 1248 */         return object;
/*      */       }
/*      */     } 
/* 1251 */     throw DbException.getUnsupportedException("converting to class " + paramClass.getName());
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\DataType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */