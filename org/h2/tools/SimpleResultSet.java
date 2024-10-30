/*      */ package org.h2.tools;
/*      */ 
/*      */ import java.io.InputStream;
/*      */ import java.io.Reader;
/*      */ import java.math.BigDecimal;
/*      */ import java.net.URL;
/*      */ import java.sql.Array;
/*      */ import java.sql.Blob;
/*      */ import java.sql.Clob;
/*      */ import java.sql.Date;
/*      */ import java.sql.NClob;
/*      */ import java.sql.Ref;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.ResultSetMetaData;
/*      */ import java.sql.RowId;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.SQLWarning;
/*      */ import java.sql.SQLXML;
/*      */ import java.sql.Statement;
/*      */ import java.sql.Time;
/*      */ import java.sql.Timestamp;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Map;
/*      */ import org.h2.jdbc.JdbcResultSetBackwardsCompat;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.util.JdbcUtils;
/*      */ import org.h2.util.MathUtils;
/*      */ import org.h2.util.New;
/*      */ import org.h2.value.DataType;
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
/*      */ public class SimpleResultSet
/*      */   implements ResultSet, ResultSetMetaData, JdbcResultSetBackwardsCompat
/*      */ {
/*      */   private ArrayList<Object[]> rows;
/*      */   private Object[] currentRow;
/*   62 */   private int rowId = -1;
/*      */   private boolean wasNull;
/*      */   private SimpleRowSource source;
/*   65 */   private ArrayList<Column> columns = New.arrayList();
/*      */ 
/*      */   
/*      */   private boolean autoClose = true;
/*      */ 
/*      */ 
/*      */   
/*      */   public SimpleResultSet() {
/*   73 */     this.rows = New.arrayList();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SimpleResultSet(SimpleRowSource paramSimpleRowSource) {
/*   83 */     this.source = paramSimpleRowSource;
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
/*      */   public void addColumn(String paramString, int paramInt1, int paramInt2, int paramInt3) {
/*   97 */     int i = DataType.convertSQLTypeToValueType(paramInt1);
/*   98 */     addColumn(paramString, paramInt1, (DataType.getDataType(i)).name, paramInt2, paramInt3);
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
/*      */ 
/*      */   
/*      */   public void addColumn(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3) {
/*  114 */     if (this.rows != null && this.rows.size() > 0) {
/*  115 */       throw new IllegalStateException("Cannot add a column after adding rows");
/*      */     }
/*      */     
/*  118 */     if (paramString1 == null) {
/*  119 */       paramString1 = "C" + (this.columns.size() + 1);
/*      */     }
/*  121 */     Column column = new Column();
/*  122 */     column.name = paramString1;
/*  123 */     column.sqlType = paramInt1;
/*  124 */     column.precision = paramInt2;
/*  125 */     column.scale = paramInt3;
/*  126 */     column.sqlTypeName = paramString2;
/*  127 */     this.columns.add(column);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addRow(Object... paramVarArgs) {
/*  137 */     if (this.rows == null) {
/*  138 */       throw new IllegalStateException("Cannot add a row when using RowSource");
/*      */     }
/*      */     
/*  141 */     this.rows.add(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getConcurrency() {
/*  151 */     return 1007;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFetchDirection() {
/*  161 */     return 1000;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFetchSize() {
/*  171 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRow() {
/*  181 */     return (this.currentRow == null) ? 0 : (this.rowId + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getType() {
/*  192 */     if (this.autoClose) {
/*  193 */       return 1003;
/*      */     }
/*  195 */     return 1004;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close() {
/*  203 */     this.currentRow = null;
/*  204 */     this.rows = null;
/*  205 */     this.columns = null;
/*  206 */     this.rowId = -1;
/*  207 */     if (this.source != null) {
/*  208 */       this.source.close();
/*  209 */       this.source = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean next() throws SQLException {
/*  220 */     if (this.source != null) {
/*  221 */       this.rowId++;
/*  222 */       this.currentRow = this.source.readRow();
/*  223 */       if (this.currentRow != null) {
/*  224 */         return true;
/*      */       }
/*  226 */     } else if (this.rows != null && this.rowId < this.rows.size()) {
/*  227 */       this.rowId++;
/*  228 */       if (this.rowId < this.rows.size()) {
/*  229 */         this.currentRow = this.rows.get(this.rowId);
/*  230 */         return true;
/*      */       } 
/*  232 */       this.currentRow = null;
/*      */     } 
/*  234 */     if (this.autoClose) {
/*  235 */       close();
/*      */     }
/*  237 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void beforeFirst() throws SQLException {
/*  246 */     if (this.autoClose) {
/*  247 */       throw DbException.get(90128);
/*      */     }
/*  249 */     this.rowId = -1;
/*  250 */     if (this.source != null) {
/*  251 */       this.source.reset();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean wasNull() {
/*  262 */     return this.wasNull;
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
/*      */   public int findColumn(String paramString) throws SQLException {
/*  276 */     if (paramString != null && this.columns != null) {
/*  277 */       byte b; int i; for (b = 0, i = this.columns.size(); b < i; b++) {
/*  278 */         if (paramString.equalsIgnoreCase((getColumn(b)).name)) {
/*  279 */           return b + 1;
/*      */         }
/*      */       } 
/*      */     } 
/*  283 */     throw DbException.get(42122, paramString).getSQLException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSetMetaData getMetaData() {
/*  294 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SQLWarning getWarnings() {
/*  304 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Statement getStatement() {
/*  314 */     return null;
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
/*      */   public void clearWarnings() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Array getArray(int paramInt) throws SQLException {
/*  335 */     Object[] arrayOfObject = (Object[])get(paramInt);
/*  336 */     return (arrayOfObject == null) ? null : new SimpleArray(arrayOfObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Array getArray(String paramString) throws SQLException {
/*  347 */     return getArray(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStream getAsciiStream(int paramInt) throws SQLException {
/*  355 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStream getAsciiStream(String paramString) throws SQLException {
/*  363 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getBigDecimal(int paramInt) throws SQLException {
/*  374 */     Object object = get(paramInt);
/*  375 */     if (object != null && !(object instanceof BigDecimal)) {
/*  376 */       object = new BigDecimal(object.toString());
/*      */     }
/*  378 */     return (BigDecimal)object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getBigDecimal(String paramString) throws SQLException {
/*  389 */     return getBigDecimal(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public BigDecimal getBigDecimal(int paramInt1, int paramInt2) throws SQLException {
/*  399 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public BigDecimal getBigDecimal(String paramString, int paramInt) throws SQLException {
/*  409 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStream getBinaryStream(int paramInt) throws SQLException {
/*  420 */     return asInputStream(get(paramInt));
/*      */   }
/*      */   
/*      */   private static InputStream asInputStream(Object paramObject) throws SQLException {
/*  424 */     if (paramObject == null)
/*  425 */       return null; 
/*  426 */     if (paramObject instanceof Blob) {
/*  427 */       return ((Blob)paramObject).getBinaryStream();
/*      */     }
/*  429 */     return (InputStream)paramObject;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStream getBinaryStream(String paramString) throws SQLException {
/*  440 */     return getBinaryStream(findColumn(paramString));
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
/*      */   public Blob getBlob(int paramInt) throws SQLException {
/*  453 */     return (Blob)get(paramInt);
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
/*      */   public Blob getBlob(String paramString) throws SQLException {
/*  466 */     return getBlob(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBoolean(int paramInt) throws SQLException {
/*  477 */     Object object = get(paramInt);
/*  478 */     if (object != null && !(object instanceof Boolean)) {
/*  479 */       object = Boolean.valueOf(object.toString());
/*      */     }
/*  481 */     return (object == null) ? false : ((Boolean)object).booleanValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBoolean(String paramString) throws SQLException {
/*  492 */     return getBoolean(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte getByte(int paramInt) throws SQLException {
/*  503 */     Object object = get(paramInt);
/*  504 */     if (object != null && !(object instanceof Number)) {
/*  505 */       object = Byte.decode(object.toString());
/*      */     }
/*  507 */     return (object == null) ? 0 : ((Number)object).byteValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte getByte(String paramString) throws SQLException {
/*  518 */     return getByte(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] getBytes(int paramInt) throws SQLException {
/*  529 */     Object object = get(paramInt);
/*  530 */     if (object == null || object instanceof byte[]) {
/*  531 */       return (byte[])object;
/*      */     }
/*  533 */     return JdbcUtils.serialize(object, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] getBytes(String paramString) throws SQLException {
/*  544 */     return getBytes(findColumn(paramString));
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
/*      */   public Reader getCharacterStream(int paramInt) throws SQLException {
/*  557 */     return asReader(get(paramInt));
/*      */   }
/*      */   
/*      */   private static Reader asReader(Object paramObject) throws SQLException {
/*  561 */     if (paramObject == null)
/*  562 */       return null; 
/*  563 */     if (paramObject instanceof Clob) {
/*  564 */       return ((Clob)paramObject).getCharacterStream();
/*      */     }
/*  566 */     return (Reader)paramObject;
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
/*      */   public Reader getCharacterStream(String paramString) throws SQLException {
/*  579 */     return getCharacterStream(findColumn(paramString));
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
/*      */   public Clob getClob(int paramInt) throws SQLException {
/*  592 */     Clob clob = (Clob)get(paramInt);
/*  593 */     return (clob == null) ? null : clob;
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
/*      */   public Clob getClob(String paramString) throws SQLException {
/*  606 */     return getClob(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDate(int paramInt) throws SQLException {
/*  617 */     return (Date)get(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDate(String paramString) throws SQLException {
/*  628 */     return getDate(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDate(int paramInt, Calendar paramCalendar) throws SQLException {
/*  636 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDate(String paramString, Calendar paramCalendar) throws SQLException {
/*  644 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getDouble(int paramInt) throws SQLException {
/*  655 */     Object object = get(paramInt);
/*  656 */     if (object != null && !(object instanceof Number)) {
/*  657 */       return Double.parseDouble(object.toString());
/*      */     }
/*  659 */     return (object == null) ? 0.0D : ((Number)object).doubleValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getDouble(String paramString) throws SQLException {
/*  670 */     return getDouble(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getFloat(int paramInt) throws SQLException {
/*  681 */     Object object = get(paramInt);
/*  682 */     if (object != null && !(object instanceof Number)) {
/*  683 */       return Float.parseFloat(object.toString());
/*      */     }
/*  685 */     return (object == null) ? 0.0F : ((Number)object).floatValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getFloat(String paramString) throws SQLException {
/*  696 */     return getFloat(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInt(int paramInt) throws SQLException {
/*  707 */     Object object = get(paramInt);
/*  708 */     if (object != null && !(object instanceof Number)) {
/*  709 */       object = Integer.decode(object.toString());
/*      */     }
/*  711 */     return (object == null) ? 0 : ((Number)object).intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInt(String paramString) throws SQLException {
/*  722 */     return getInt(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLong(int paramInt) throws SQLException {
/*  733 */     Object object = get(paramInt);
/*  734 */     if (object != null && !(object instanceof Number)) {
/*  735 */       object = Long.decode(object.toString());
/*      */     }
/*  737 */     return (object == null) ? 0L : ((Number)object).longValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLong(String paramString) throws SQLException {
/*  748 */     return getLong(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Reader getNCharacterStream(int paramInt) throws SQLException {
/*  756 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Reader getNCharacterStream(String paramString) throws SQLException {
/*  764 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NClob getNClob(int paramInt) throws SQLException {
/*  772 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NClob getNClob(String paramString) throws SQLException {
/*  780 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNString(int paramInt) throws SQLException {
/*  788 */     return getString(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNString(String paramString) throws SQLException {
/*  796 */     return getString(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObject(int paramInt) throws SQLException {
/*  807 */     return get(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObject(String paramString) throws SQLException {
/*  818 */     return getObject(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T getObject(int paramInt, Class<T> paramClass) throws SQLException {
/*  829 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T getObject(String paramString, Class<T> paramClass) throws SQLException {
/*  840 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObject(int paramInt, Map<String, Class<?>> paramMap) throws SQLException {
/*  849 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObject(String paramString, Map<String, Class<?>> paramMap) throws SQLException {
/*  858 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Ref getRef(int paramInt) throws SQLException {
/*  866 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Ref getRef(String paramString) throws SQLException {
/*  874 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RowId getRowId(int paramInt) throws SQLException {
/*  882 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RowId getRowId(String paramString) throws SQLException {
/*  890 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getShort(int paramInt) throws SQLException {
/*  901 */     Object object = get(paramInt);
/*  902 */     if (object != null && !(object instanceof Number)) {
/*  903 */       object = Short.decode(object.toString());
/*      */     }
/*  905 */     return (object == null) ? 0 : ((Number)object).shortValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getShort(String paramString) throws SQLException {
/*  916 */     return getShort(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SQLXML getSQLXML(int paramInt) throws SQLException {
/*  924 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SQLXML getSQLXML(String paramString) throws SQLException {
/*  932 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getString(int paramInt) throws SQLException {
/*      */     Clob clob;
/*  943 */     Object object = get(paramInt);
/*  944 */     if (object == null) {
/*  945 */       return null;
/*      */     }
/*  947 */     switch (((Column)this.columns.get(paramInt - 1)).sqlType) {
/*      */       case 2005:
/*  949 */         clob = (Clob)object;
/*  950 */         return clob.getSubString(1L, MathUtils.convertLongToInt(clob.length()));
/*      */     } 
/*  952 */     return object.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getString(String paramString) throws SQLException {
/*  963 */     return getString(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Time getTime(int paramInt) throws SQLException {
/*  974 */     return (Time)get(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Time getTime(String paramString) throws SQLException {
/*  985 */     return getTime(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Time getTime(int paramInt, Calendar paramCalendar) throws SQLException {
/*  993 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Time getTime(String paramString, Calendar paramCalendar) throws SQLException {
/* 1001 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Timestamp getTimestamp(int paramInt) throws SQLException {
/* 1012 */     return (Timestamp)get(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Timestamp getTimestamp(String paramString) throws SQLException {
/* 1023 */     return getTimestamp(findColumn(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Timestamp getTimestamp(int paramInt, Calendar paramCalendar) throws SQLException {
/* 1032 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Timestamp getTimestamp(String paramString, Calendar paramCalendar) throws SQLException {
/* 1041 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public InputStream getUnicodeStream(int paramInt) throws SQLException {
/* 1050 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public InputStream getUnicodeStream(String paramString) throws SQLException {
/* 1059 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public URL getURL(int paramInt) throws SQLException {
/* 1067 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public URL getURL(String paramString) throws SQLException {
/* 1075 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateArray(int paramInt, Array paramArray) throws SQLException {
/* 1085 */     update(paramInt, paramArray);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateArray(String paramString, Array paramArray) throws SQLException {
/* 1093 */     update(paramString, paramArray);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateAsciiStream(int paramInt, InputStream paramInputStream) throws SQLException {
/* 1102 */     update(paramInt, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateAsciiStream(String paramString, InputStream paramInputStream) throws SQLException {
/* 1111 */     update(paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateAsciiStream(int paramInt1, InputStream paramInputStream, int paramInt2) throws SQLException {
/* 1120 */     update(paramInt1, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateAsciiStream(String paramString, InputStream paramInputStream, int paramInt) throws SQLException {
/* 1129 */     update(paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateAsciiStream(int paramInt, InputStream paramInputStream, long paramLong) throws SQLException {
/* 1138 */     update(paramInt, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateAsciiStream(String paramString, InputStream paramInputStream, long paramLong) throws SQLException {
/* 1147 */     update(paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBigDecimal(int paramInt, BigDecimal paramBigDecimal) throws SQLException {
/* 1156 */     update(paramInt, paramBigDecimal);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBigDecimal(String paramString, BigDecimal paramBigDecimal) throws SQLException {
/* 1165 */     update(paramString, paramBigDecimal);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBinaryStream(int paramInt, InputStream paramInputStream) throws SQLException {
/* 1174 */     update(paramInt, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBinaryStream(String paramString, InputStream paramInputStream) throws SQLException {
/* 1183 */     update(paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBinaryStream(int paramInt1, InputStream paramInputStream, int paramInt2) throws SQLException {
/* 1192 */     update(paramInt1, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBinaryStream(String paramString, InputStream paramInputStream, int paramInt) throws SQLException {
/* 1201 */     update(paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBinaryStream(int paramInt, InputStream paramInputStream, long paramLong) throws SQLException {
/* 1210 */     update(paramInt, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBinaryStream(String paramString, InputStream paramInputStream, long paramLong) throws SQLException {
/* 1219 */     update(paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBlob(int paramInt, Blob paramBlob) throws SQLException {
/* 1227 */     update(paramInt, paramBlob);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBlob(String paramString, Blob paramBlob) throws SQLException {
/* 1235 */     update(paramString, paramBlob);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBlob(int paramInt, InputStream paramInputStream) throws SQLException {
/* 1243 */     update(paramInt, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBlob(String paramString, InputStream paramInputStream) throws SQLException {
/* 1252 */     update(paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBlob(int paramInt, InputStream paramInputStream, long paramLong) throws SQLException {
/* 1261 */     update(paramInt, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBlob(String paramString, InputStream paramInputStream, long paramLong) throws SQLException {
/* 1270 */     update(paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBoolean(int paramInt, boolean paramBoolean) throws SQLException {
/* 1278 */     update(paramInt, Boolean.valueOf(paramBoolean));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBoolean(String paramString, boolean paramBoolean) throws SQLException {
/* 1287 */     update(paramString, Boolean.valueOf(paramBoolean));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateByte(int paramInt, byte paramByte) throws SQLException {
/* 1295 */     update(paramInt, Byte.valueOf(paramByte));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateByte(String paramString, byte paramByte) throws SQLException {
/* 1303 */     update(paramString, Byte.valueOf(paramByte));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBytes(int paramInt, byte[] paramArrayOfbyte) throws SQLException {
/* 1311 */     update(paramInt, paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBytes(String paramString, byte[] paramArrayOfbyte) throws SQLException {
/* 1319 */     update(paramString, paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateCharacterStream(int paramInt, Reader paramReader) throws SQLException {
/* 1328 */     update(paramInt, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateCharacterStream(String paramString, Reader paramReader) throws SQLException {
/* 1337 */     update(paramString, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateCharacterStream(int paramInt1, Reader paramReader, int paramInt2) throws SQLException {
/* 1346 */     update(paramInt1, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateCharacterStream(String paramString, Reader paramReader, int paramInt) throws SQLException {
/* 1355 */     update(paramString, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateCharacterStream(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/* 1364 */     update(paramInt, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateCharacterStream(String paramString, Reader paramReader, long paramLong) throws SQLException {
/* 1373 */     update(paramString, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateClob(int paramInt, Clob paramClob) throws SQLException {
/* 1381 */     update(paramInt, paramClob);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateClob(String paramString, Clob paramClob) throws SQLException {
/* 1389 */     update(paramString, paramClob);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateClob(int paramInt, Reader paramReader) throws SQLException {
/* 1397 */     update(paramInt, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateClob(String paramString, Reader paramReader) throws SQLException {
/* 1405 */     update(paramString, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateClob(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/* 1414 */     update(paramInt, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateClob(String paramString, Reader paramReader, long paramLong) throws SQLException {
/* 1423 */     update(paramString, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateDate(int paramInt, Date paramDate) throws SQLException {
/* 1431 */     update(paramInt, paramDate);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateDate(String paramString, Date paramDate) throws SQLException {
/* 1439 */     update(paramString, paramDate);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateDouble(int paramInt, double paramDouble) throws SQLException {
/* 1447 */     update(paramInt, Double.valueOf(paramDouble));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateDouble(String paramString, double paramDouble) throws SQLException {
/* 1455 */     update(paramString, Double.valueOf(paramDouble));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateFloat(int paramInt, float paramFloat) throws SQLException {
/* 1463 */     update(paramInt, Float.valueOf(paramFloat));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateFloat(String paramString, float paramFloat) throws SQLException {
/* 1471 */     update(paramString, Float.valueOf(paramFloat));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateInt(int paramInt1, int paramInt2) throws SQLException {
/* 1479 */     update(paramInt1, Integer.valueOf(paramInt2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateInt(String paramString, int paramInt) throws SQLException {
/* 1487 */     update(paramString, Integer.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateLong(int paramInt, long paramLong) throws SQLException {
/* 1495 */     update(paramInt, Long.valueOf(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateLong(String paramString, long paramLong) throws SQLException {
/* 1503 */     update(paramString, Long.valueOf(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNCharacterStream(int paramInt, Reader paramReader) throws SQLException {
/* 1512 */     update(paramInt, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNCharacterStream(String paramString, Reader paramReader) throws SQLException {
/* 1521 */     update(paramString, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNCharacterStream(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/* 1530 */     update(paramInt, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNCharacterStream(String paramString, Reader paramReader, long paramLong) throws SQLException {
/* 1539 */     update(paramString, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNClob(int paramInt, NClob paramNClob) throws SQLException {
/* 1547 */     update(paramInt, paramNClob);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNClob(String paramString, NClob paramNClob) throws SQLException {
/* 1555 */     update(paramString, paramNClob);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNClob(int paramInt, Reader paramReader) throws SQLException {
/* 1563 */     update(paramInt, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNClob(String paramString, Reader paramReader) throws SQLException {
/* 1571 */     update(paramString, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNClob(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/* 1580 */     update(paramInt, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNClob(String paramString, Reader paramReader, long paramLong) throws SQLException {
/* 1589 */     update(paramString, paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNString(int paramInt, String paramString) throws SQLException {
/* 1597 */     update(paramInt, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNString(String paramString1, String paramString2) throws SQLException {
/* 1605 */     update(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNull(int paramInt) throws SQLException {
/* 1613 */     update(paramInt, (Object)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNull(String paramString) throws SQLException {
/* 1621 */     update(paramString, (Object)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateObject(int paramInt, Object paramObject) throws SQLException {
/* 1629 */     update(paramInt, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateObject(String paramString, Object paramObject) throws SQLException {
/* 1637 */     update(paramString, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateObject(int paramInt1, Object paramObject, int paramInt2) throws SQLException {
/* 1646 */     update(paramInt1, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateObject(String paramString, Object paramObject, int paramInt) throws SQLException {
/* 1655 */     update(paramString, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRef(int paramInt, Ref paramRef) throws SQLException {
/* 1663 */     update(paramInt, paramRef);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRef(String paramString, Ref paramRef) throws SQLException {
/* 1671 */     update(paramString, paramRef);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRowId(int paramInt, RowId paramRowId) throws SQLException {
/* 1679 */     update(paramInt, paramRowId);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRowId(String paramString, RowId paramRowId) throws SQLException {
/* 1687 */     update(paramString, paramRowId);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateShort(int paramInt, short paramShort) throws SQLException {
/* 1695 */     update(paramInt, Short.valueOf(paramShort));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateShort(String paramString, short paramShort) throws SQLException {
/* 1703 */     update(paramString, Short.valueOf(paramShort));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateSQLXML(int paramInt, SQLXML paramSQLXML) throws SQLException {
/* 1711 */     update(paramInt, paramSQLXML);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateSQLXML(String paramString, SQLXML paramSQLXML) throws SQLException {
/* 1719 */     update(paramString, paramSQLXML);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateString(int paramInt, String paramString) throws SQLException {
/* 1727 */     update(paramInt, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateString(String paramString1, String paramString2) throws SQLException {
/* 1735 */     update(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateTime(int paramInt, Time paramTime) throws SQLException {
/* 1743 */     update(paramInt, paramTime);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateTime(String paramString, Time paramTime) throws SQLException {
/* 1751 */     update(paramString, paramTime);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateTimestamp(int paramInt, Timestamp paramTimestamp) throws SQLException {
/* 1760 */     update(paramInt, paramTimestamp);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateTimestamp(String paramString, Timestamp paramTimestamp) throws SQLException {
/* 1769 */     update(paramString, paramTimestamp);
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
/*      */   public int getColumnCount() {
/* 1781 */     return this.columns.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getColumnDisplaySize(int paramInt) {
/* 1792 */     return 15;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getColumnType(int paramInt) throws SQLException {
/* 1803 */     return (getColumn(paramInt - 1)).sqlType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPrecision(int paramInt) throws SQLException {
/* 1814 */     return (getColumn(paramInt - 1)).precision;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getScale(int paramInt) throws SQLException {
/* 1825 */     return (getColumn(paramInt - 1)).scale;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int isNullable(int paramInt) {
/* 1836 */     return 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAutoIncrement(int paramInt) {
/* 1847 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isCaseSensitive(int paramInt) {
/* 1858 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isCurrency(int paramInt) {
/* 1869 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDefinitelyWritable(int paramInt) {
/* 1880 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isReadOnly(int paramInt) {
/* 1891 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSearchable(int paramInt) {
/* 1902 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSigned(int paramInt) {
/* 1913 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWritable(int paramInt) {
/* 1924 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCatalogName(int paramInt) {
/* 1935 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getColumnClassName(int paramInt) throws SQLException {
/* 1946 */     int i = DataType.getValueTypeFromResultSet(this, paramInt);
/* 1947 */     return DataType.getTypeClassName(i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getColumnLabel(int paramInt) throws SQLException {
/* 1958 */     return (getColumn(paramInt - 1)).name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getColumnName(int paramInt) throws SQLException {
/* 1969 */     return getColumnLabel(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getColumnTypeName(int paramInt) throws SQLException {
/* 1980 */     return (getColumn(paramInt - 1)).sqlTypeName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSchemaName(int paramInt) {
/* 1991 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTableName(int paramInt) {
/* 2002 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void afterLast() throws SQLException {
/* 2012 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cancelRowUpdates() throws SQLException {
/* 2020 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deleteRow() throws SQLException {
/* 2028 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void insertRow() throws SQLException {
/* 2036 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void moveToCurrentRow() throws SQLException {
/* 2044 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void moveToInsertRow() throws SQLException {
/* 2052 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshRow() throws SQLException {
/* 2060 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRow() throws SQLException {
/* 2068 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean first() throws SQLException {
/* 2076 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAfterLast() throws SQLException {
/* 2084 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBeforeFirst() throws SQLException {
/* 2092 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFirst() throws SQLException {
/* 2100 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLast() throws SQLException {
/* 2108 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean last() throws SQLException {
/* 2116 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean previous() throws SQLException {
/* 2124 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean rowDeleted() throws SQLException {
/* 2132 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean rowInserted() throws SQLException {
/* 2140 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean rowUpdated() throws SQLException {
/* 2148 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFetchDirection(int paramInt) throws SQLException {
/* 2156 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFetchSize(int paramInt) throws SQLException {
/* 2164 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean absolute(int paramInt) throws SQLException {
/* 2172 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean relative(int paramInt) throws SQLException {
/* 2180 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCursorName() throws SQLException {
/* 2188 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void update(int paramInt, Object paramObject) throws SQLException {
/* 2194 */     checkColumnIndex(paramInt);
/* 2195 */     this.currentRow[paramInt - 1] = paramObject;
/*      */   }
/*      */   
/*      */   private void update(String paramString, Object paramObject) throws SQLException {
/* 2199 */     this.currentRow[findColumn(paramString) - 1] = paramObject;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static SQLException getUnsupportedException() {
/* 2206 */     return DbException.get(50100).getSQLException();
/*      */   }
/*      */ 
/*      */   
/*      */   private void checkColumnIndex(int paramInt) throws SQLException {
/* 2211 */     if (paramInt < 1 || paramInt > this.columns.size()) {
/* 2212 */       throw DbException.getInvalidValueException("columnIndex", Integer.valueOf(paramInt)).getSQLException();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private Object get(int paramInt) throws SQLException {
/* 2218 */     if (this.currentRow == null) {
/* 2219 */       throw DbException.get(2000).getSQLException();
/*      */     }
/*      */     
/* 2222 */     checkColumnIndex(paramInt);
/* 2223 */     paramInt--;
/* 2224 */     Object object = (paramInt < this.currentRow.length) ? this.currentRow[paramInt] : null;
/*      */     
/* 2226 */     this.wasNull = (object == null);
/* 2227 */     return object;
/*      */   }
/*      */   
/*      */   private Column getColumn(int paramInt) throws SQLException {
/* 2231 */     checkColumnIndex(paramInt + 1);
/* 2232 */     return this.columns.get(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getHoldability() {
/* 2242 */     return 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isClosed() {
/* 2252 */     return (this.rows == null && this.source == null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T unwrap(Class<T> paramClass) throws SQLException {
/* 2260 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWrapperFor(Class<?> paramClass) throws SQLException {
/* 2268 */     throw getUnsupportedException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAutoClose(boolean paramBoolean) {
/* 2278 */     this.autoClose = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAutoClose() {
/* 2287 */     return this.autoClose;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class Column
/*      */   {
/*      */     String name;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     String sqlTypeName;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int sqlType;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int precision;
/*      */ 
/*      */ 
/*      */     
/*      */     int scale;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class SimpleArray
/*      */     implements Array
/*      */   {
/*      */     private final Object[] value;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     SimpleArray(Object[] param1ArrayOfObject) {
/* 2330 */       this.value = param1ArrayOfObject;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getArray() {
/* 2340 */       return this.value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getArray(Map<String, Class<?>> param1Map) throws SQLException {
/* 2348 */       throw SimpleResultSet.getUnsupportedException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getArray(long param1Long, int param1Int) throws SQLException {
/* 2356 */       throw SimpleResultSet.getUnsupportedException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getArray(long param1Long, int param1Int, Map<String, Class<?>> param1Map) throws SQLException {
/* 2365 */       throw SimpleResultSet.getUnsupportedException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getBaseType() {
/* 2375 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getBaseTypeName() {
/* 2385 */       return "NULL";
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ResultSet getResultSet() throws SQLException {
/* 2393 */       throw SimpleResultSet.getUnsupportedException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ResultSet getResultSet(Map<String, Class<?>> param1Map) throws SQLException {
/* 2402 */       throw SimpleResultSet.getUnsupportedException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ResultSet getResultSet(long param1Long, int param1Int) throws SQLException {
/* 2411 */       throw SimpleResultSet.getUnsupportedException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ResultSet getResultSet(long param1Long, int param1Int, Map<String, Class<?>> param1Map) throws SQLException {
/* 2420 */       throw SimpleResultSet.getUnsupportedException();
/*      */     }
/*      */     
/*      */     public void free() {}
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\SimpleResultSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */