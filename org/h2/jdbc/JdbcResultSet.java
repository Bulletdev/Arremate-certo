/*      */ package org.h2.jdbc;
/*      */ 
/*      */ import com.vividsolutions.jts.geom.Geometry;
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
/*      */ import java.util.Calendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.UUID;
/*      */ import org.h2.api.TimestampWithTimeZone;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.message.TraceObject;
/*      */ import org.h2.result.ResultInterface;
/*      */ import org.h2.result.UpdatableRow;
/*      */ import org.h2.util.DateTimeUtils;
/*      */ import org.h2.util.IOUtils;
/*      */ import org.h2.util.LocalDateTimeUtils;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.StringUtils;
/*      */ import org.h2.value.CompareMode;
/*      */ import org.h2.value.DataType;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueBoolean;
/*      */ import org.h2.value.ValueByte;
/*      */ import org.h2.value.ValueBytes;
/*      */ import org.h2.value.ValueDate;
/*      */ import org.h2.value.ValueDecimal;
/*      */ import org.h2.value.ValueDouble;
/*      */ import org.h2.value.ValueFloat;
/*      */ import org.h2.value.ValueInt;
/*      */ import org.h2.value.ValueLong;
/*      */ import org.h2.value.ValueNull;
/*      */ import org.h2.value.ValueShort;
/*      */ import org.h2.value.ValueString;
/*      */ import org.h2.value.ValueTime;
/*      */ import org.h2.value.ValueTimestamp;
/*      */ import org.h2.value.ValueTimestampTimeZone;
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
/*      */ public class JdbcResultSet
/*      */   extends TraceObject
/*      */   implements ResultSet, JdbcResultSetBackwardsCompat
/*      */ {
/*      */   private final boolean closeStatement;
/*      */   private final boolean scrollable;
/*      */   private final boolean updatable;
/*      */   private ResultInterface result;
/*      */   private JdbcConnection conn;
/*      */   private JdbcStatement stat;
/*      */   private int columnCount;
/*      */   private boolean wasNull;
/*      */   private Value[] insertRow;
/*      */   private Value[] updateRow;
/*      */   private HashMap<String, Integer> columnLabelMap;
/*      */   private HashMap<Integer, Value[]> patchedRows;
/*      */   private JdbcPreparedStatement preparedStatement;
/*      */   
/*      */   JdbcResultSet(JdbcConnection paramJdbcConnection, JdbcStatement paramJdbcStatement, ResultInterface paramResultInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  100 */     setTrace(paramJdbcConnection.getSession().getTrace(), 4, paramInt);
/*  101 */     this.conn = paramJdbcConnection;
/*  102 */     this.stat = paramJdbcStatement;
/*  103 */     this.result = paramResultInterface;
/*  104 */     this.columnCount = paramResultInterface.getVisibleColumnCount();
/*  105 */     this.closeStatement = paramBoolean1;
/*  106 */     this.scrollable = paramBoolean2;
/*  107 */     this.updatable = paramBoolean3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   JdbcResultSet(JdbcConnection paramJdbcConnection, JdbcPreparedStatement paramJdbcPreparedStatement, ResultInterface paramResultInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, HashMap<String, Integer> paramHashMap) {
/*  114 */     this(paramJdbcConnection, paramJdbcPreparedStatement, paramResultInterface, paramInt, paramBoolean1, paramBoolean2, paramBoolean3);
/*      */     
/*  116 */     this.columnLabelMap = paramHashMap;
/*  117 */     this.preparedStatement = paramJdbcPreparedStatement;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean next() throws SQLException {
/*      */     try {
/*  128 */       debugCodeCall("next");
/*  129 */       checkClosed();
/*  130 */       return nextRow();
/*  131 */     } catch (Exception exception) {
/*  132 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSetMetaData getMetaData() throws SQLException {
/*      */     try {
/*  144 */       int i = getNextId(5);
/*  145 */       if (isDebugEnabled()) {
/*  146 */         debugCodeAssign("ResultSetMetaData", 5, i, "getMetaData()");
/*      */       }
/*      */       
/*  149 */       checkClosed();
/*  150 */       String str = this.conn.getCatalog();
/*  151 */       return new JdbcResultSetMetaData(this, null, this.result, str, this.conn.getSession().getTrace(), i);
/*      */     
/*      */     }
/*  154 */     catch (Exception exception) {
/*  155 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean wasNull() throws SQLException {
/*      */     try {
/*  167 */       debugCodeCall("wasNull");
/*  168 */       checkClosed();
/*  169 */       return this.wasNull;
/*  170 */     } catch (Exception exception) {
/*  171 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */     try {
/*  187 */       debugCodeCall("findColumn", paramString);
/*  188 */       return getColumnIndex(paramString);
/*  189 */     } catch (Exception exception) {
/*  190 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close() throws SQLException {
/*      */     try {
/*  200 */       debugCodeCall("close");
/*  201 */       closeInternal();
/*  202 */     } catch (Exception exception) {
/*  203 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void closeInternal() throws SQLException {
/*  211 */     if (this.result != null) {
/*      */       try {
/*  213 */         this.result.close();
/*  214 */         if (this.closeStatement && this.stat != null) {
/*  215 */           this.stat.close();
/*      */         }
/*      */       } finally {
/*  218 */         this.columnCount = 0;
/*  219 */         this.result = null;
/*  220 */         this.stat = null;
/*  221 */         this.conn = null;
/*  222 */         this.insertRow = null;
/*  223 */         this.updateRow = null;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Statement getStatement() throws SQLException {
/*      */     try {
/*  237 */       debugCodeCall("getStatement");
/*  238 */       checkClosed();
/*  239 */       if (this.closeStatement)
/*      */       {
/*  241 */         return null;
/*      */       }
/*  243 */       return this.stat;
/*  244 */     } catch (Exception exception) {
/*  245 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SQLWarning getWarnings() throws SQLException {
/*      */     try {
/*  257 */       debugCodeCall("getWarnings");
/*  258 */       checkClosed();
/*  259 */       return null;
/*  260 */     } catch (Exception exception) {
/*  261 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearWarnings() throws SQLException {
/*      */     try {
/*  271 */       debugCodeCall("clearWarnings");
/*  272 */       checkClosed();
/*  273 */     } catch (Exception exception) {
/*  274 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public String getString(int paramInt) throws SQLException {
/*      */     try {
/*  291 */       debugCodeCall("getString", paramInt);
/*  292 */       return get(paramInt).getString();
/*  293 */     } catch (Exception exception) {
/*  294 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public String getString(String paramString) throws SQLException {
/*      */     try {
/*  309 */       debugCodeCall("getString", paramString);
/*  310 */       return get(paramString).getString();
/*  311 */     } catch (Exception exception) {
/*  312 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public int getInt(int paramInt) throws SQLException {
/*      */     try {
/*  327 */       debugCodeCall("getInt", paramInt);
/*  328 */       return get(paramInt).getInt();
/*  329 */     } catch (Exception exception) {
/*  330 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public int getInt(String paramString) throws SQLException {
/*      */     try {
/*  345 */       debugCodeCall("getInt", paramString);
/*  346 */       return get(paramString).getInt();
/*  347 */     } catch (Exception exception) {
/*  348 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public BigDecimal getBigDecimal(int paramInt) throws SQLException {
/*      */     try {
/*  363 */       debugCodeCall("getBigDecimal", paramInt);
/*  364 */       return get(paramInt).getBigDecimal();
/*  365 */     } catch (Exception exception) {
/*  366 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Date getDate(int paramInt) throws SQLException {
/*      */     try {
/*  381 */       debugCodeCall("getDate", paramInt);
/*  382 */       return get(paramInt).getDate();
/*  383 */     } catch (Exception exception) {
/*  384 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Time getTime(int paramInt) throws SQLException {
/*      */     try {
/*  399 */       debugCodeCall("getTime", paramInt);
/*  400 */       return get(paramInt).getTime();
/*  401 */     } catch (Exception exception) {
/*  402 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Timestamp getTimestamp(int paramInt) throws SQLException {
/*      */     try {
/*  417 */       debugCodeCall("getTimestamp", paramInt);
/*  418 */       return get(paramInt).getTimestamp();
/*  419 */     } catch (Exception exception) {
/*  420 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public BigDecimal getBigDecimal(String paramString) throws SQLException {
/*      */     try {
/*  435 */       debugCodeCall("getBigDecimal", paramString);
/*  436 */       return get(paramString).getBigDecimal();
/*  437 */     } catch (Exception exception) {
/*  438 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Date getDate(String paramString) throws SQLException {
/*      */     try {
/*  453 */       debugCodeCall("getDate", paramString);
/*  454 */       return get(paramString).getDate();
/*  455 */     } catch (Exception exception) {
/*  456 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Time getTime(String paramString) throws SQLException {
/*      */     try {
/*  471 */       debugCodeCall("getTime", paramString);
/*  472 */       return get(paramString).getTime();
/*  473 */     } catch (Exception exception) {
/*  474 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Timestamp getTimestamp(String paramString) throws SQLException {
/*      */     try {
/*  489 */       debugCodeCall("getTimestamp", paramString);
/*  490 */       return get(paramString).getTimestamp();
/*  491 */     } catch (Exception exception) {
/*  492 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Object getObject(int paramInt) throws SQLException {
/*      */     try {
/*  508 */       debugCodeCall("getObject", paramInt);
/*  509 */       Value value = get(paramInt);
/*  510 */       return this.conn.convertToDefaultObject(value);
/*  511 */     } catch (Exception exception) {
/*  512 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Object getObject(String paramString) throws SQLException {
/*      */     try {
/*  528 */       debugCodeCall("getObject", paramString);
/*  529 */       Value value = get(paramString);
/*  530 */       return this.conn.convertToDefaultObject(value);
/*  531 */     } catch (Exception exception) {
/*  532 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public boolean getBoolean(int paramInt) throws SQLException {
/*      */     try {
/*  547 */       debugCodeCall("getBoolean", paramInt);
/*  548 */       Boolean bool = get(paramInt).getBoolean();
/*  549 */       return (bool == null) ? false : bool.booleanValue();
/*  550 */     } catch (Exception exception) {
/*  551 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public boolean getBoolean(String paramString) throws SQLException {
/*      */     try {
/*  566 */       debugCodeCall("getBoolean", paramString);
/*  567 */       Boolean bool = get(paramString).getBoolean();
/*  568 */       return (bool == null) ? false : bool.booleanValue();
/*  569 */     } catch (Exception exception) {
/*  570 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public byte getByte(int paramInt) throws SQLException {
/*      */     try {
/*  585 */       debugCodeCall("getByte", paramInt);
/*  586 */       return get(paramInt).getByte();
/*  587 */     } catch (Exception exception) {
/*  588 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public byte getByte(String paramString) throws SQLException {
/*      */     try {
/*  603 */       debugCodeCall("getByte", paramString);
/*  604 */       return get(paramString).getByte();
/*  605 */     } catch (Exception exception) {
/*  606 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public short getShort(int paramInt) throws SQLException {
/*      */     try {
/*  621 */       debugCodeCall("getShort", paramInt);
/*  622 */       return get(paramInt).getShort();
/*  623 */     } catch (Exception exception) {
/*  624 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public short getShort(String paramString) throws SQLException {
/*      */     try {
/*  639 */       debugCodeCall("getShort", paramString);
/*  640 */       return get(paramString).getShort();
/*  641 */     } catch (Exception exception) {
/*  642 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public long getLong(int paramInt) throws SQLException {
/*      */     try {
/*  657 */       debugCodeCall("getLong", paramInt);
/*  658 */       return get(paramInt).getLong();
/*  659 */     } catch (Exception exception) {
/*  660 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public long getLong(String paramString) throws SQLException {
/*      */     try {
/*  675 */       debugCodeCall("getLong", paramString);
/*  676 */       return get(paramString).getLong();
/*  677 */     } catch (Exception exception) {
/*  678 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public float getFloat(int paramInt) throws SQLException {
/*      */     try {
/*  693 */       debugCodeCall("getFloat", paramInt);
/*  694 */       return get(paramInt).getFloat();
/*  695 */     } catch (Exception exception) {
/*  696 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public float getFloat(String paramString) throws SQLException {
/*      */     try {
/*  711 */       debugCodeCall("getFloat", paramString);
/*  712 */       return get(paramString).getFloat();
/*  713 */     } catch (Exception exception) {
/*  714 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public double getDouble(int paramInt) throws SQLException {
/*      */     try {
/*  729 */       debugCodeCall("getDouble", paramInt);
/*  730 */       return get(paramInt).getDouble();
/*  731 */     } catch (Exception exception) {
/*  732 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public double getDouble(String paramString) throws SQLException {
/*      */     try {
/*  747 */       debugCodeCall("getDouble", paramString);
/*  748 */       return get(paramString).getDouble();
/*  749 */     } catch (Exception exception) {
/*  750 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   
/*      */   @Deprecated
/*      */   public BigDecimal getBigDecimal(String paramString, int paramInt) throws SQLException {
/*      */     try {
/*  770 */       if (isDebugEnabled()) {
/*  771 */         debugCode("getBigDecimal(" + StringUtils.quoteJavaString(paramString) + ", " + paramInt + ");");
/*      */       }
/*      */       
/*  774 */       if (paramInt < 0) {
/*  775 */         throw DbException.getInvalidValueException("scale", Integer.valueOf(paramInt));
/*      */       }
/*  777 */       BigDecimal bigDecimal = get(paramString).getBigDecimal();
/*  778 */       return (bigDecimal == null) ? null : ValueDecimal.setScale(bigDecimal, paramInt);
/*  779 */     } catch (Exception exception) {
/*  780 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   
/*      */   @Deprecated
/*      */   public BigDecimal getBigDecimal(int paramInt1, int paramInt2) throws SQLException {
/*      */     try {
/*  800 */       if (isDebugEnabled()) {
/*  801 */         debugCode("getBigDecimal(" + paramInt1 + ", " + paramInt2 + ");");
/*      */       }
/*  803 */       if (paramInt2 < 0) {
/*  804 */         throw DbException.getInvalidValueException("scale", Integer.valueOf(paramInt2));
/*      */       }
/*  806 */       BigDecimal bigDecimal = get(paramInt1).getBigDecimal();
/*  807 */       return (bigDecimal == null) ? null : ValueDecimal.setScale(bigDecimal, paramInt2);
/*  808 */     } catch (Exception exception) {
/*  809 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public InputStream getUnicodeStream(int paramInt) throws SQLException {
/*  820 */     throw unsupported("unicodeStream");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public InputStream getUnicodeStream(String paramString) throws SQLException {
/*  830 */     throw unsupported("unicodeStream");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObject(int paramInt, Map<String, Class<?>> paramMap) throws SQLException {
/*  840 */     throw unsupported("map");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObject(String paramString, Map<String, Class<?>> paramMap) throws SQLException {
/*  850 */     throw unsupported("map");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Ref getRef(int paramInt) throws SQLException {
/*  858 */     throw unsupported("ref");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Ref getRef(String paramString) throws SQLException {
/*  866 */     throw unsupported("ref");
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
/*      */   public Date getDate(int paramInt, Calendar paramCalendar) throws SQLException {
/*      */     try {
/*  882 */       if (isDebugEnabled()) {
/*  883 */         debugCode("getDate(" + paramInt + ", calendar)");
/*      */       }
/*  885 */       return DateTimeUtils.convertDate(get(paramInt), paramCalendar);
/*  886 */     } catch (Exception exception) {
/*  887 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Date getDate(String paramString, Calendar paramCalendar) throws SQLException {
/*      */     try {
/*  905 */       if (isDebugEnabled()) {
/*  906 */         debugCode("getDate(" + StringUtils.quoteJavaString(paramString) + ", calendar)");
/*      */       }
/*      */ 
/*      */       
/*  910 */       return DateTimeUtils.convertDate(get(paramString), paramCalendar);
/*  911 */     } catch (Exception exception) {
/*  912 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Time getTime(int paramInt, Calendar paramCalendar) throws SQLException {
/*      */     try {
/*  929 */       if (isDebugEnabled()) {
/*  930 */         debugCode("getTime(" + paramInt + ", calendar)");
/*      */       }
/*  932 */       return DateTimeUtils.convertTime(get(paramInt), paramCalendar);
/*  933 */     } catch (Exception exception) {
/*  934 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Time getTime(String paramString, Calendar paramCalendar) throws SQLException {
/*      */     try {
/*  952 */       if (isDebugEnabled()) {
/*  953 */         debugCode("getTime(" + StringUtils.quoteJavaString(paramString) + ", calendar)");
/*      */       }
/*      */ 
/*      */       
/*  957 */       return DateTimeUtils.convertTime(get(paramString), paramCalendar);
/*  958 */     } catch (Exception exception) {
/*  959 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Timestamp getTimestamp(int paramInt, Calendar paramCalendar) throws SQLException {
/*      */     try {
/*  977 */       if (isDebugEnabled()) {
/*  978 */         debugCode("getTimestamp(" + paramInt + ", calendar)");
/*      */       }
/*  980 */       Value value = get(paramInt);
/*  981 */       return DateTimeUtils.convertTimestamp(value, paramCalendar);
/*  982 */     } catch (Exception exception) {
/*  983 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Timestamp getTimestamp(String paramString, Calendar paramCalendar) throws SQLException {
/*      */     try {
/* 1000 */       if (isDebugEnabled()) {
/* 1001 */         debugCode("getTimestamp(" + StringUtils.quoteJavaString(paramString) + ", calendar)");
/*      */       }
/*      */ 
/*      */       
/* 1005 */       Value value = get(paramString);
/* 1006 */       return DateTimeUtils.convertTimestamp(value, paramCalendar);
/* 1007 */     } catch (Exception exception) {
/* 1008 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */     try {
/* 1023 */       int i = getNextId(9);
/* 1024 */       if (isDebugEnabled()) {
/* 1025 */         debugCodeAssign("Blob", 9, i, "getBlob(" + paramInt + ")");
/*      */       }
/*      */       
/* 1028 */       Value value = get(paramInt);
/* 1029 */       return (value == ValueNull.INSTANCE) ? null : new JdbcBlob(this.conn, value, i);
/* 1030 */     } catch (Exception exception) {
/* 1031 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */     try {
/* 1046 */       int i = getNextId(9);
/* 1047 */       if (isDebugEnabled()) {
/* 1048 */         debugCodeAssign("Blob", 9, i, "getBlob(" + quote(paramString) + ")");
/*      */       }
/*      */       
/* 1051 */       Value value = get(paramString);
/* 1052 */       return (value == ValueNull.INSTANCE) ? null : new JdbcBlob(this.conn, value, i);
/* 1053 */     } catch (Exception exception) {
/* 1054 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public byte[] getBytes(int paramInt) throws SQLException {
/*      */     try {
/* 1069 */       debugCodeCall("getBytes", paramInt);
/* 1070 */       return get(paramInt).getBytes();
/* 1071 */     } catch (Exception exception) {
/* 1072 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public byte[] getBytes(String paramString) throws SQLException {
/*      */     try {
/* 1087 */       debugCodeCall("getBytes", paramString);
/* 1088 */       return get(paramString).getBytes();
/* 1089 */     } catch (Exception exception) {
/* 1090 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public InputStream getBinaryStream(int paramInt) throws SQLException {
/*      */     try {
/* 1105 */       debugCodeCall("getBinaryStream", paramInt);
/* 1106 */       return get(paramInt).getInputStream();
/* 1107 */     } catch (Exception exception) {
/* 1108 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public InputStream getBinaryStream(String paramString) throws SQLException {
/*      */     try {
/* 1123 */       debugCodeCall("getBinaryStream", paramString);
/* 1124 */       return get(paramString).getInputStream();
/* 1125 */     } catch (Exception exception) {
/* 1126 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Clob getClob(int paramInt) throws SQLException {
/*      */     try {
/* 1142 */       int i = getNextId(10);
/* 1143 */       if (isDebugEnabled()) {
/* 1144 */         debugCodeAssign("Clob", 10, i, "getClob(" + paramInt + ")");
/*      */       }
/* 1146 */       Value value = get(paramInt);
/* 1147 */       return (value == ValueNull.INSTANCE) ? null : new JdbcClob(this.conn, value, i);
/* 1148 */     } catch (Exception exception) {
/* 1149 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */     try {
/* 1164 */       int i = getNextId(10);
/* 1165 */       if (isDebugEnabled()) {
/* 1166 */         debugCodeAssign("Clob", 10, i, "getClob(" + quote(paramString) + ")");
/*      */       }
/*      */       
/* 1169 */       Value value = get(paramString);
/* 1170 */       return (value == ValueNull.INSTANCE) ? null : new JdbcClob(this.conn, value, i);
/* 1171 */     } catch (Exception exception) {
/* 1172 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Array getArray(int paramInt) throws SQLException {
/*      */     try {
/* 1187 */       int i = getNextId(16);
/* 1188 */       if (isDebugEnabled()) {
/* 1189 */         debugCodeAssign("Clob", 16, i, "getArray(" + paramInt + ")");
/*      */       }
/* 1191 */       Value value = get(paramInt);
/* 1192 */       return (value == ValueNull.INSTANCE) ? null : new JdbcArray(this.conn, value, i);
/* 1193 */     } catch (Exception exception) {
/* 1194 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Array getArray(String paramString) throws SQLException {
/*      */     try {
/* 1209 */       int i = getNextId(16);
/* 1210 */       if (isDebugEnabled()) {
/* 1211 */         debugCodeAssign("Clob", 16, i, "getArray(" + quote(paramString) + ")");
/*      */       }
/*      */       
/* 1214 */       Value value = get(paramString);
/* 1215 */       return (value == ValueNull.INSTANCE) ? null : new JdbcArray(this.conn, value, i);
/* 1216 */     } catch (Exception exception) {
/* 1217 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public InputStream getAsciiStream(int paramInt) throws SQLException {
/*      */     try {
/* 1232 */       debugCodeCall("getAsciiStream", paramInt);
/* 1233 */       String str = get(paramInt).getString();
/* 1234 */       return (str == null) ? null : IOUtils.getInputStreamFromString(str);
/* 1235 */     } catch (Exception exception) {
/* 1236 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public InputStream getAsciiStream(String paramString) throws SQLException {
/*      */     try {
/* 1251 */       debugCodeCall("getAsciiStream", paramString);
/* 1252 */       String str = get(paramString).getString();
/* 1253 */       return IOUtils.getInputStreamFromString(str);
/* 1254 */     } catch (Exception exception) {
/* 1255 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */     try {
/* 1270 */       debugCodeCall("getCharacterStream", paramInt);
/* 1271 */       return get(paramInt).getReader();
/* 1272 */     } catch (Exception exception) {
/* 1273 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */     try {
/* 1288 */       debugCodeCall("getCharacterStream", paramString);
/* 1289 */       return get(paramString).getReader();
/* 1290 */     } catch (Exception exception) {
/* 1291 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public URL getURL(int paramInt) throws SQLException {
/* 1300 */     throw unsupported("url");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public URL getURL(String paramString) throws SQLException {
/* 1308 */     throw unsupported("url");
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
/*      */   public void updateNull(int paramInt) throws SQLException {
/*      */     try {
/* 1322 */       debugCodeCall("updateNull", paramInt);
/* 1323 */       update(paramInt, (Value)ValueNull.INSTANCE);
/* 1324 */     } catch (Exception exception) {
/* 1325 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNull(String paramString) throws SQLException {
/*      */     try {
/* 1338 */       debugCodeCall("updateNull", paramString);
/* 1339 */       update(paramString, (Value)ValueNull.INSTANCE);
/* 1340 */     } catch (Exception exception) {
/* 1341 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateBoolean(int paramInt, boolean paramBoolean) throws SQLException {
/*      */     try {
/* 1355 */       if (isDebugEnabled()) {
/* 1356 */         debugCode("updateBoolean(" + paramInt + ", " + paramBoolean + ");");
/*      */       }
/* 1358 */       update(paramInt, (Value)ValueBoolean.get(paramBoolean));
/* 1359 */     } catch (Exception exception) {
/* 1360 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateBoolean(String paramString, boolean paramBoolean) throws SQLException {
/*      */     try {
/* 1375 */       if (isDebugEnabled()) {
/* 1376 */         debugCode("updateBoolean(" + quote(paramString) + ", " + paramBoolean + ");");
/*      */       }
/* 1378 */       update(paramString, (Value)ValueBoolean.get(paramBoolean));
/* 1379 */     } catch (Exception exception) {
/* 1380 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateByte(int paramInt, byte paramByte) throws SQLException {
/*      */     try {
/* 1394 */       if (isDebugEnabled()) {
/* 1395 */         debugCode("updateByte(" + paramInt + ", " + paramByte + ");");
/*      */       }
/* 1397 */       update(paramInt, (Value)ValueByte.get(paramByte));
/* 1398 */     } catch (Exception exception) {
/* 1399 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateByte(String paramString, byte paramByte) throws SQLException {
/*      */     try {
/* 1413 */       if (isDebugEnabled()) {
/* 1414 */         debugCode("updateByte(" + paramString + ", " + paramByte + ");");
/*      */       }
/* 1416 */       update(paramString, (Value)ValueByte.get(paramByte));
/* 1417 */     } catch (Exception exception) {
/* 1418 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateBytes(int paramInt, byte[] paramArrayOfbyte) throws SQLException {
/*      */     try {
/* 1432 */       if (isDebugEnabled()) {
/* 1433 */         debugCode("updateBytes(" + paramInt + ", x);");
/*      */       }
/* 1435 */       update(paramInt, (paramArrayOfbyte == null) ? (Value)ValueNull.INSTANCE : (Value)ValueBytes.get(paramArrayOfbyte));
/* 1436 */     } catch (Exception exception) {
/* 1437 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateBytes(String paramString, byte[] paramArrayOfbyte) throws SQLException {
/*      */     try {
/* 1451 */       if (isDebugEnabled()) {
/* 1452 */         debugCode("updateBytes(" + quote(paramString) + ", x);");
/*      */       }
/* 1454 */       update(paramString, (paramArrayOfbyte == null) ? (Value)ValueNull.INSTANCE : (Value)ValueBytes.get(paramArrayOfbyte));
/* 1455 */     } catch (Exception exception) {
/* 1456 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateShort(int paramInt, short paramShort) throws SQLException {
/*      */     try {
/* 1470 */       if (isDebugEnabled()) {
/* 1471 */         debugCode("updateShort(" + paramInt + ", (short) " + paramShort + ");");
/*      */       }
/* 1473 */       update(paramInt, (Value)ValueShort.get(paramShort));
/* 1474 */     } catch (Exception exception) {
/* 1475 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateShort(String paramString, short paramShort) throws SQLException {
/*      */     try {
/* 1489 */       if (isDebugEnabled()) {
/* 1490 */         debugCode("updateShort(" + quote(paramString) + ", (short) " + paramShort + ");");
/*      */       }
/* 1492 */       update(paramString, (Value)ValueShort.get(paramShort));
/* 1493 */     } catch (Exception exception) {
/* 1494 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateInt(int paramInt1, int paramInt2) throws SQLException {
/*      */     try {
/* 1508 */       if (isDebugEnabled()) {
/* 1509 */         debugCode("updateInt(" + paramInt1 + ", " + paramInt2 + ");");
/*      */       }
/* 1511 */       update(paramInt1, (Value)ValueInt.get(paramInt2));
/* 1512 */     } catch (Exception exception) {
/* 1513 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateInt(String paramString, int paramInt) throws SQLException {
/*      */     try {
/* 1527 */       if (isDebugEnabled()) {
/* 1528 */         debugCode("updateInt(" + quote(paramString) + ", " + paramInt + ");");
/*      */       }
/* 1530 */       update(paramString, (Value)ValueInt.get(paramInt));
/* 1531 */     } catch (Exception exception) {
/* 1532 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateLong(int paramInt, long paramLong) throws SQLException {
/*      */     try {
/* 1546 */       if (isDebugEnabled()) {
/* 1547 */         debugCode("updateLong(" + paramInt + ", " + paramLong + "L);");
/*      */       }
/* 1549 */       update(paramInt, (Value)ValueLong.get(paramLong));
/* 1550 */     } catch (Exception exception) {
/* 1551 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateLong(String paramString, long paramLong) throws SQLException {
/*      */     try {
/* 1565 */       if (isDebugEnabled()) {
/* 1566 */         debugCode("updateLong(" + quote(paramString) + ", " + paramLong + "L);");
/*      */       }
/* 1568 */       update(paramString, (Value)ValueLong.get(paramLong));
/* 1569 */     } catch (Exception exception) {
/* 1570 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateFloat(int paramInt, float paramFloat) throws SQLException {
/*      */     try {
/* 1584 */       if (isDebugEnabled()) {
/* 1585 */         debugCode("updateFloat(" + paramInt + ", " + paramFloat + "f);");
/*      */       }
/* 1587 */       update(paramInt, (Value)ValueFloat.get(paramFloat));
/* 1588 */     } catch (Exception exception) {
/* 1589 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateFloat(String paramString, float paramFloat) throws SQLException {
/*      */     try {
/* 1603 */       if (isDebugEnabled()) {
/* 1604 */         debugCode("updateFloat(" + quote(paramString) + ", " + paramFloat + "f);");
/*      */       }
/* 1606 */       update(paramString, (Value)ValueFloat.get(paramFloat));
/* 1607 */     } catch (Exception exception) {
/* 1608 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateDouble(int paramInt, double paramDouble) throws SQLException {
/*      */     try {
/* 1622 */       if (isDebugEnabled()) {
/* 1623 */         debugCode("updateDouble(" + paramInt + ", " + paramDouble + "d);");
/*      */       }
/* 1625 */       update(paramInt, (Value)ValueDouble.get(paramDouble));
/* 1626 */     } catch (Exception exception) {
/* 1627 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateDouble(String paramString, double paramDouble) throws SQLException {
/*      */     try {
/* 1641 */       if (isDebugEnabled()) {
/* 1642 */         debugCode("updateDouble(" + quote(paramString) + ", " + paramDouble + "d);");
/*      */       }
/* 1644 */       update(paramString, (Value)ValueDouble.get(paramDouble));
/* 1645 */     } catch (Exception exception) {
/* 1646 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateBigDecimal(int paramInt, BigDecimal paramBigDecimal) throws SQLException {
/*      */     try {
/* 1661 */       if (isDebugEnabled()) {
/* 1662 */         debugCode("updateBigDecimal(" + paramInt + ", " + quoteBigDecimal(paramBigDecimal) + ");");
/*      */       }
/* 1664 */       update(paramInt, (paramBigDecimal == null) ? (Value)ValueNull.INSTANCE : (Value)ValueDecimal.get(paramBigDecimal));
/*      */     }
/* 1666 */     catch (Exception exception) {
/* 1667 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateBigDecimal(String paramString, BigDecimal paramBigDecimal) throws SQLException {
/*      */     try {
/* 1682 */       if (isDebugEnabled()) {
/* 1683 */         debugCode("updateBigDecimal(" + quote(paramString) + ", " + quoteBigDecimal(paramBigDecimal) + ");");
/*      */       }
/*      */       
/* 1686 */       update(paramString, (paramBigDecimal == null) ? (Value)ValueNull.INSTANCE : (Value)ValueDecimal.get(paramBigDecimal));
/*      */     }
/* 1688 */     catch (Exception exception) {
/* 1689 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateString(int paramInt, String paramString) throws SQLException {
/*      */     try {
/* 1703 */       if (isDebugEnabled()) {
/* 1704 */         debugCode("updateString(" + paramInt + ", " + quote(paramString) + ");");
/*      */       }
/* 1706 */       update(paramInt, (paramString == null) ? (Value)ValueNull.INSTANCE : ValueString.get(paramString));
/*      */     }
/* 1708 */     catch (Exception exception) {
/* 1709 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateString(String paramString1, String paramString2) throws SQLException {
/*      */     try {
/* 1723 */       if (isDebugEnabled()) {
/* 1724 */         debugCode("updateString(" + quote(paramString1) + ", " + quote(paramString2) + ");");
/*      */       }
/* 1726 */       update(paramString1, (paramString2 == null) ? (Value)ValueNull.INSTANCE : ValueString.get(paramString2));
/*      */     }
/* 1728 */     catch (Exception exception) {
/* 1729 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateDate(int paramInt, Date paramDate) throws SQLException {
/*      */     try {
/* 1743 */       if (isDebugEnabled()) {
/* 1744 */         debugCode("updateDate(" + paramInt + ", x);");
/*      */       }
/* 1746 */       update(paramInt, (paramDate == null) ? (Value)ValueNull.INSTANCE : (Value)ValueDate.get(paramDate));
/* 1747 */     } catch (Exception exception) {
/* 1748 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateDate(String paramString, Date paramDate) throws SQLException {
/*      */     try {
/* 1762 */       if (isDebugEnabled()) {
/* 1763 */         debugCode("updateDate(" + quote(paramString) + ", x);");
/*      */       }
/* 1765 */       update(paramString, (paramDate == null) ? (Value)ValueNull.INSTANCE : (Value)ValueDate.get(paramDate));
/* 1766 */     } catch (Exception exception) {
/* 1767 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateTime(int paramInt, Time paramTime) throws SQLException {
/*      */     try {
/* 1781 */       if (isDebugEnabled()) {
/* 1782 */         debugCode("updateTime(" + paramInt + ", x);");
/*      */       }
/* 1784 */       update(paramInt, (paramTime == null) ? (Value)ValueNull.INSTANCE : (Value)ValueTime.get(paramTime));
/* 1785 */     } catch (Exception exception) {
/* 1786 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateTime(String paramString, Time paramTime) throws SQLException {
/*      */     try {
/* 1800 */       if (isDebugEnabled()) {
/* 1801 */         debugCode("updateTime(" + quote(paramString) + ", x);");
/*      */       }
/* 1803 */       update(paramString, (paramTime == null) ? (Value)ValueNull.INSTANCE : (Value)ValueTime.get(paramTime));
/* 1804 */     } catch (Exception exception) {
/* 1805 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateTimestamp(int paramInt, Timestamp paramTimestamp) throws SQLException {
/*      */     try {
/* 1820 */       if (isDebugEnabled()) {
/* 1821 */         debugCode("updateTimestamp(" + paramInt + ", x);");
/*      */       }
/* 1823 */       update(paramInt, (paramTimestamp == null) ? (Value)ValueNull.INSTANCE : (Value)ValueTimestamp.get(paramTimestamp));
/*      */     }
/* 1825 */     catch (Exception exception) {
/* 1826 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateTimestamp(String paramString, Timestamp paramTimestamp) throws SQLException {
/*      */     try {
/* 1841 */       if (isDebugEnabled()) {
/* 1842 */         debugCode("updateTimestamp(" + quote(paramString) + ", x);");
/*      */       }
/* 1844 */       update(paramString, (paramTimestamp == null) ? (Value)ValueNull.INSTANCE : (Value)ValueTimestamp.get(paramTimestamp));
/*      */     }
/* 1846 */     catch (Exception exception) {
/* 1847 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateAsciiStream(int paramInt1, InputStream paramInputStream, int paramInt2) throws SQLException {
/* 1862 */     updateAsciiStream(paramInt1, paramInputStream, paramInt2);
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
/*      */   public void updateAsciiStream(int paramInt, InputStream paramInputStream) throws SQLException {
/* 1875 */     updateAsciiStream(paramInt, paramInputStream, -1);
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
/*      */   public void updateAsciiStream(int paramInt, InputStream paramInputStream, long paramLong) throws SQLException {
/*      */     try {
/* 1890 */       if (isDebugEnabled()) {
/* 1891 */         debugCode("updateAsciiStream(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/* 1893 */       checkClosed();
/* 1894 */       Value value = this.conn.createClob(IOUtils.getAsciiReader(paramInputStream), paramLong);
/* 1895 */       update(paramInt, value);
/* 1896 */     } catch (Exception exception) {
/* 1897 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateAsciiStream(String paramString, InputStream paramInputStream, int paramInt) throws SQLException {
/* 1912 */     updateAsciiStream(paramString, paramInputStream, paramInt);
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
/*      */   public void updateAsciiStream(String paramString, InputStream paramInputStream) throws SQLException {
/* 1925 */     updateAsciiStream(paramString, paramInputStream, -1);
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
/*      */   public void updateAsciiStream(String paramString, InputStream paramInputStream, long paramLong) throws SQLException {
/*      */     try {
/* 1940 */       if (isDebugEnabled()) {
/* 1941 */         debugCode("updateAsciiStream(" + quote(paramString) + ", x, " + paramLong + "L);");
/*      */       }
/* 1943 */       checkClosed();
/* 1944 */       Value value = this.conn.createClob(IOUtils.getAsciiReader(paramInputStream), paramLong);
/* 1945 */       update(paramString, value);
/* 1946 */     } catch (Exception exception) {
/* 1947 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateBinaryStream(int paramInt1, InputStream paramInputStream, int paramInt2) throws SQLException {
/* 1962 */     updateBinaryStream(paramInt1, paramInputStream, paramInt2);
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
/*      */   public void updateBinaryStream(int paramInt, InputStream paramInputStream) throws SQLException {
/* 1975 */     updateBinaryStream(paramInt, paramInputStream, -1);
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
/*      */   public void updateBinaryStream(int paramInt, InputStream paramInputStream, long paramLong) throws SQLException {
/*      */     try {
/* 1990 */       if (isDebugEnabled()) {
/* 1991 */         debugCode("updateBinaryStream(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/* 1993 */       checkClosed();
/* 1994 */       Value value = this.conn.createBlob(paramInputStream, paramLong);
/* 1995 */       update(paramInt, value);
/* 1996 */     } catch (Exception exception) {
/* 1997 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateBinaryStream(String paramString, InputStream paramInputStream) throws SQLException {
/* 2011 */     updateBinaryStream(paramString, paramInputStream, -1);
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
/*      */   public void updateBinaryStream(String paramString, InputStream paramInputStream, int paramInt) throws SQLException {
/* 2025 */     updateBinaryStream(paramString, paramInputStream, paramInt);
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
/*      */   public void updateBinaryStream(String paramString, InputStream paramInputStream, long paramLong) throws SQLException {
/*      */     try {
/* 2040 */       if (isDebugEnabled()) {
/* 2041 */         debugCode("updateBinaryStream(" + quote(paramString) + ", x, " + paramLong + "L);");
/*      */       }
/* 2043 */       checkClosed();
/* 2044 */       Value value = this.conn.createBlob(paramInputStream, paramLong);
/* 2045 */       update(paramString, value);
/* 2046 */     } catch (Exception exception) {
/* 2047 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateCharacterStream(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/*      */     try {
/* 2063 */       if (isDebugEnabled()) {
/* 2064 */         debugCode("updateCharacterStream(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/* 2066 */       checkClosed();
/* 2067 */       Value value = this.conn.createClob(paramReader, paramLong);
/* 2068 */       update(paramInt, value);
/* 2069 */     } catch (Exception exception) {
/* 2070 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateCharacterStream(int paramInt1, Reader paramReader, int paramInt2) throws SQLException {
/* 2085 */     updateCharacterStream(paramInt1, paramReader, paramInt2);
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
/*      */   public void updateCharacterStream(int paramInt, Reader paramReader) throws SQLException {
/* 2098 */     updateCharacterStream(paramInt, paramReader, -1);
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
/*      */   public void updateCharacterStream(String paramString, Reader paramReader, int paramInt) throws SQLException {
/* 2112 */     updateCharacterStream(paramString, paramReader, paramInt);
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
/*      */   public void updateCharacterStream(String paramString, Reader paramReader) throws SQLException {
/* 2125 */     updateCharacterStream(paramString, paramReader, -1);
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
/*      */   public void updateCharacterStream(String paramString, Reader paramReader, long paramLong) throws SQLException {
/*      */     try {
/* 2140 */       if (isDebugEnabled()) {
/* 2141 */         debugCode("updateCharacterStream(" + quote(paramString) + ", x, " + paramLong + "L);");
/*      */       }
/* 2143 */       checkClosed();
/* 2144 */       Value value = this.conn.createClob(paramReader, paramLong);
/* 2145 */       update(paramString, value);
/* 2146 */     } catch (Exception exception) {
/* 2147 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateObject(int paramInt1, Object paramObject, int paramInt2) throws SQLException {
/*      */     try {
/* 2163 */       if (isDebugEnabled()) {
/* 2164 */         debugCode("updateObject(" + paramInt1 + ", x, " + paramInt2 + ");");
/*      */       }
/* 2166 */       update(paramInt1, convertToUnknownValue(paramObject));
/* 2167 */     } catch (Exception exception) {
/* 2168 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateObject(String paramString, Object paramObject, int paramInt) throws SQLException {
/*      */     try {
/* 2186 */       if (isDebugEnabled()) {
/* 2187 */         debugCode("updateObject(" + quote(paramString) + ", x, " + paramInt + ");");
/*      */       }
/* 2189 */       update(paramString, convertToUnknownValue(paramObject));
/* 2190 */     } catch (Exception exception) {
/* 2191 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateObject(int paramInt, Object paramObject) throws SQLException {
/*      */     try {
/* 2205 */       if (isDebugEnabled()) {
/* 2206 */         debugCode("updateObject(" + paramInt + ", x);");
/*      */       }
/* 2208 */       update(paramInt, convertToUnknownValue(paramObject));
/* 2209 */     } catch (Exception exception) {
/* 2210 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateObject(String paramString, Object paramObject) throws SQLException {
/*      */     try {
/* 2224 */       if (isDebugEnabled()) {
/* 2225 */         debugCode("updateObject(" + quote(paramString) + ", x);");
/*      */       }
/* 2227 */       update(paramString, convertToUnknownValue(paramObject));
/* 2228 */     } catch (Exception exception) {
/* 2229 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRef(int paramInt, Ref paramRef) throws SQLException {
/* 2238 */     throw unsupported("ref");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRef(String paramString, Ref paramRef) throws SQLException {
/* 2246 */     throw unsupported("ref");
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
/*      */   public void updateBlob(int paramInt, InputStream paramInputStream) throws SQLException {
/* 2258 */     updateBlob(paramInt, paramInputStream, -1L);
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
/*      */   public void updateBlob(int paramInt, InputStream paramInputStream, long paramLong) throws SQLException {
/*      */     try {
/* 2273 */       if (isDebugEnabled()) {
/* 2274 */         debugCode("updateBlob(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/* 2276 */       checkClosed();
/* 2277 */       Value value = this.conn.createBlob(paramInputStream, paramLong);
/* 2278 */       update(paramInt, value);
/* 2279 */     } catch (Exception exception) {
/* 2280 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBlob(int paramInt, Blob paramBlob) throws SQLException {
/*      */     try {
/*      */       Value value;
/* 2294 */       if (isDebugEnabled()) {
/* 2295 */         debugCode("updateBlob(" + paramInt + ", x);");
/*      */       }
/* 2297 */       checkClosed();
/*      */       
/* 2299 */       if (paramBlob == null) {
/* 2300 */         ValueNull valueNull = ValueNull.INSTANCE;
/*      */       } else {
/* 2302 */         value = this.conn.createBlob(paramBlob.getBinaryStream(), -1L);
/*      */       } 
/* 2304 */       update(paramInt, value);
/* 2305 */     } catch (Exception exception) {
/* 2306 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBlob(String paramString, Blob paramBlob) throws SQLException {
/*      */     try {
/*      */       Value value;
/* 2320 */       if (isDebugEnabled()) {
/* 2321 */         debugCode("updateBlob(" + quote(paramString) + ", x);");
/*      */       }
/* 2323 */       checkClosed();
/*      */       
/* 2325 */       if (paramBlob == null) {
/* 2326 */         ValueNull valueNull = ValueNull.INSTANCE;
/*      */       } else {
/* 2328 */         value = this.conn.createBlob(paramBlob.getBinaryStream(), -1L);
/*      */       } 
/* 2330 */       update(paramString, value);
/* 2331 */     } catch (Exception exception) {
/* 2332 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateBlob(String paramString, InputStream paramInputStream) throws SQLException {
/* 2345 */     updateBlob(paramString, paramInputStream, -1L);
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
/*      */   public void updateBlob(String paramString, InputStream paramInputStream, long paramLong) throws SQLException {
/*      */     try {
/* 2360 */       if (isDebugEnabled()) {
/* 2361 */         debugCode("updateBlob(" + quote(paramString) + ", x, " + paramLong + "L);");
/*      */       }
/* 2363 */       checkClosed();
/* 2364 */       Value value = this.conn.createBlob(paramInputStream, -1L);
/* 2365 */       update(paramString, value);
/* 2366 */     } catch (Exception exception) {
/* 2367 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateClob(int paramInt, Clob paramClob) throws SQLException {
/*      */     try {
/*      */       Value value;
/* 2381 */       if (isDebugEnabled()) {
/* 2382 */         debugCode("updateClob(" + paramInt + ", x);");
/*      */       }
/* 2384 */       checkClosed();
/*      */       
/* 2386 */       if (paramClob == null) {
/* 2387 */         ValueNull valueNull = ValueNull.INSTANCE;
/*      */       } else {
/* 2389 */         value = this.conn.createClob(paramClob.getCharacterStream(), -1L);
/*      */       } 
/* 2391 */       update(paramInt, value);
/* 2392 */     } catch (Exception exception) {
/* 2393 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateClob(int paramInt, Reader paramReader) throws SQLException {
/* 2406 */     updateClob(paramInt, paramReader, -1L);
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
/*      */   public void updateClob(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/*      */     try {
/* 2421 */       if (isDebugEnabled()) {
/* 2422 */         debugCode("updateClob(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/* 2424 */       checkClosed();
/* 2425 */       Value value = this.conn.createClob(paramReader, paramLong);
/* 2426 */       update(paramInt, value);
/* 2427 */     } catch (Exception exception) {
/* 2428 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateClob(String paramString, Clob paramClob) throws SQLException {
/*      */     try {
/*      */       Value value;
/* 2442 */       if (isDebugEnabled()) {
/* 2443 */         debugCode("updateClob(" + quote(paramString) + ", x);");
/*      */       }
/* 2445 */       checkClosed();
/*      */       
/* 2447 */       if (paramClob == null) {
/* 2448 */         ValueNull valueNull = ValueNull.INSTANCE;
/*      */       } else {
/* 2450 */         value = this.conn.createClob(paramClob.getCharacterStream(), -1L);
/*      */       } 
/* 2452 */       update(paramString, value);
/* 2453 */     } catch (Exception exception) {
/* 2454 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateClob(String paramString, Reader paramReader) throws SQLException {
/* 2467 */     updateClob(paramString, paramReader, -1L);
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
/*      */   public void updateClob(String paramString, Reader paramReader, long paramLong) throws SQLException {
/*      */     try {
/* 2482 */       if (isDebugEnabled()) {
/* 2483 */         debugCode("updateClob(" + quote(paramString) + ", x, " + paramLong + "L);");
/*      */       }
/* 2485 */       checkClosed();
/* 2486 */       Value value = this.conn.createClob(paramReader, paramLong);
/* 2487 */       update(paramString, value);
/* 2488 */     } catch (Exception exception) {
/* 2489 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateArray(int paramInt, Array paramArray) throws SQLException {
/* 2498 */     throw unsupported("setArray");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateArray(String paramString, Array paramArray) throws SQLException {
/* 2506 */     throw unsupported("setArray");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCursorName() throws SQLException {
/* 2516 */     throw unsupported("cursorName");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRow() throws SQLException {
/*      */     try {
/* 2528 */       debugCodeCall("getRow");
/* 2529 */       checkClosed();
/* 2530 */       int i = this.result.getRowId();
/* 2531 */       if (i >= this.result.getRowCount()) {
/* 2532 */         return 0;
/*      */       }
/* 2534 */       return i + 1;
/* 2535 */     } catch (Exception exception) {
/* 2536 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public int getConcurrency() throws SQLException {
/*      */     try {
/* 2551 */       debugCodeCall("getConcurrency");
/* 2552 */       checkClosed();
/* 2553 */       if (!this.updatable) {
/* 2554 */         return 1007;
/*      */       }
/* 2556 */       UpdatableRow updatableRow = new UpdatableRow(this.conn, this.result);
/* 2557 */       return updatableRow.isUpdatable() ? 1008 : 1007;
/*      */     }
/* 2559 */     catch (Exception exception) {
/* 2560 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFetchDirection() throws SQLException {
/*      */     try {
/* 2572 */       debugCodeCall("getFetchDirection");
/* 2573 */       checkClosed();
/* 2574 */       return 1000;
/* 2575 */     } catch (Exception exception) {
/* 2576 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFetchSize() throws SQLException {
/*      */     try {
/* 2588 */       debugCodeCall("getFetchSize");
/* 2589 */       checkClosed();
/* 2590 */       return this.result.getFetchSize();
/* 2591 */     } catch (Exception exception) {
/* 2592 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void setFetchSize(int paramInt) throws SQLException {
/*      */     try {
/* 2608 */       debugCodeCall("setFetchSize", paramInt);
/* 2609 */       checkClosed();
/* 2610 */       if (paramInt < 0)
/* 2611 */         throw DbException.getInvalidValueException("rows", Integer.valueOf(paramInt)); 
/* 2612 */       if (paramInt > 0) {
/* 2613 */         if (this.stat != null) {
/* 2614 */           int i = this.stat.getMaxRows();
/* 2615 */           if (i > 0 && paramInt > i) {
/* 2616 */             throw DbException.getInvalidValueException("rows", Integer.valueOf(paramInt));
/*      */           }
/*      */         } 
/*      */       } else {
/* 2620 */         paramInt = SysProperties.SERVER_RESULT_SET_FETCH_SIZE;
/*      */       } 
/* 2622 */       this.result.setFetchSize(paramInt);
/* 2623 */     } catch (Exception exception) {
/* 2624 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void setFetchDirection(int paramInt) throws SQLException {
/* 2640 */     debugCodeCall("setFetchDirection", paramInt);
/*      */     
/* 2642 */     if (paramInt != 1000) {
/* 2643 */       throw unsupported("setFetchDirection");
/*      */     }
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
/*      */   public int getType() throws SQLException {
/*      */     try {
/* 2658 */       debugCodeCall("getType");
/* 2659 */       checkClosed();
/* 2660 */       return (this.stat == null) ? 1003 : this.stat.resultSetType;
/* 2661 */     } catch (Exception exception) {
/* 2662 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public boolean isBeforeFirst() throws SQLException {
/*      */     try {
/* 2677 */       debugCodeCall("isBeforeFirst");
/* 2678 */       checkClosed();
/* 2679 */       int i = this.result.getRowId();
/* 2680 */       int j = this.result.getRowCount();
/* 2681 */       return (j > 0 && i < 0);
/* 2682 */     } catch (Exception exception) {
/* 2683 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public boolean isAfterLast() throws SQLException {
/*      */     try {
/* 2698 */       debugCodeCall("isAfterLast");
/* 2699 */       checkClosed();
/* 2700 */       int i = this.result.getRowId();
/* 2701 */       int j = this.result.getRowCount();
/* 2702 */       return (j > 0 && i >= j);
/* 2703 */     } catch (Exception exception) {
/* 2704 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public boolean isFirst() throws SQLException {
/*      */     try {
/* 2718 */       debugCodeCall("isFirst");
/* 2719 */       checkClosed();
/* 2720 */       int i = this.result.getRowId();
/* 2721 */       return (i == 0 && i < this.result.getRowCount());
/* 2722 */     } catch (Exception exception) {
/* 2723 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public boolean isLast() throws SQLException {
/*      */     try {
/* 2737 */       debugCodeCall("isLast");
/* 2738 */       checkClosed();
/* 2739 */       int i = this.result.getRowId();
/* 2740 */       return (i >= 0 && i == this.result.getRowCount() - 1);
/* 2741 */     } catch (Exception exception) {
/* 2742 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void beforeFirst() throws SQLException {
/*      */     try {
/* 2755 */       debugCodeCall("beforeFirst");
/* 2756 */       checkClosed();
/* 2757 */       if (this.result.getRowId() >= 0) {
/* 2758 */         resetResult();
/*      */       }
/* 2760 */     } catch (Exception exception) {
/* 2761 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void afterLast() throws SQLException {
/*      */     try {
/* 2774 */       debugCodeCall("afterLast");
/* 2775 */       checkClosed();
/* 2776 */       while (nextRow());
/*      */     
/*      */     }
/* 2779 */     catch (Exception exception) {
/* 2780 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public boolean first() throws SQLException {
/*      */     try {
/* 2794 */       debugCodeCall("first");
/* 2795 */       checkClosed();
/* 2796 */       if (this.result.getRowId() < 0) {
/* 2797 */         return nextRow();
/*      */       }
/* 2799 */       resetResult();
/* 2800 */       return nextRow();
/* 2801 */     } catch (Exception exception) {
/* 2802 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean last() throws SQLException {
/*      */     try {
/* 2815 */       debugCodeCall("last");
/* 2816 */       checkClosed();
/* 2817 */       return absolute(-1);
/* 2818 */     } catch (Exception exception) {
/* 2819 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public boolean absolute(int paramInt) throws SQLException {
/*      */     try {
/* 2837 */       debugCodeCall("absolute", paramInt);
/* 2838 */       checkClosed();
/* 2839 */       if (paramInt < 0) {
/* 2840 */         paramInt = this.result.getRowCount() + paramInt + 1;
/* 2841 */       } else if (paramInt > this.result.getRowCount() + 1) {
/* 2842 */         paramInt = this.result.getRowCount() + 1;
/*      */       } 
/* 2844 */       if (paramInt <= this.result.getRowId()) {
/* 2845 */         resetResult();
/*      */       }
/* 2847 */       while (this.result.getRowId() + 1 < paramInt) {
/* 2848 */         nextRow();
/*      */       }
/* 2850 */       int i = this.result.getRowId();
/* 2851 */       return (i >= 0 && i < this.result.getRowCount());
/* 2852 */     } catch (Exception exception) {
/* 2853 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public boolean relative(int paramInt) throws SQLException {
/*      */     try {
/* 2870 */       debugCodeCall("relative", paramInt);
/* 2871 */       checkClosed();
/* 2872 */       int i = this.result.getRowId() + 1 + paramInt;
/* 2873 */       if (i < 0) {
/* 2874 */         i = 0;
/* 2875 */       } else if (i > this.result.getRowCount()) {
/* 2876 */         i = this.result.getRowCount() + 1;
/*      */       } 
/* 2878 */       return absolute(i);
/* 2879 */     } catch (Exception exception) {
/* 2880 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public boolean previous() throws SQLException {
/*      */     try {
/* 2894 */       debugCodeCall("previous");
/* 2895 */       checkClosed();
/* 2896 */       return relative(-1);
/* 2897 */     } catch (Exception exception) {
/* 2898 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void moveToInsertRow() throws SQLException {
/*      */     try {
/* 2911 */       debugCodeCall("moveToInsertRow");
/* 2912 */       checkUpdatable();
/* 2913 */       this.insertRow = new Value[this.columnCount];
/* 2914 */     } catch (Exception exception) {
/* 2915 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void moveToCurrentRow() throws SQLException {
/*      */     try {
/* 2927 */       debugCodeCall("moveToCurrentRow");
/* 2928 */       checkUpdatable();
/* 2929 */       this.insertRow = null;
/* 2930 */     } catch (Exception exception) {
/* 2931 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean rowUpdated() throws SQLException {
/*      */     try {
/* 2943 */       debugCodeCall("rowUpdated");
/* 2944 */       return false;
/* 2945 */     } catch (Exception exception) {
/* 2946 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean rowInserted() throws SQLException {
/*      */     try {
/* 2958 */       debugCodeCall("rowInserted");
/* 2959 */       return false;
/* 2960 */     } catch (Exception exception) {
/* 2961 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean rowDeleted() throws SQLException {
/*      */     try {
/* 2973 */       debugCodeCall("rowDeleted");
/* 2974 */       return false;
/* 2975 */     } catch (Exception exception) {
/* 2976 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void insertRow() throws SQLException {
/*      */     try {
/* 2989 */       debugCodeCall("insertRow");
/* 2990 */       checkUpdatable();
/* 2991 */       if (this.insertRow == null) {
/* 2992 */         throw DbException.get(90029);
/*      */       }
/* 2994 */       getUpdatableRow().insertRow(this.insertRow);
/* 2995 */       this.insertRow = null;
/* 2996 */     } catch (Exception exception) {
/* 2997 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateRow() throws SQLException {
/*      */     try {
/* 3011 */       debugCodeCall("updateRow");
/* 3012 */       checkUpdatable();
/* 3013 */       if (this.insertRow != null) {
/* 3014 */         throw DbException.get(90029);
/*      */       }
/* 3016 */       checkOnValidRow();
/* 3017 */       if (this.updateRow != null) {
/* 3018 */         UpdatableRow updatableRow = getUpdatableRow();
/* 3019 */         Value[] arrayOfValue1 = new Value[this.columnCount]; byte b;
/* 3020 */         for (b = 0; b < this.updateRow.length; b++) {
/* 3021 */           arrayOfValue1[b] = get(b + 1);
/*      */         }
/* 3023 */         updatableRow.updateRow(arrayOfValue1, this.updateRow);
/* 3024 */         for (b = 0; b < this.updateRow.length; b++) {
/* 3025 */           if (this.updateRow[b] == null) {
/* 3026 */             this.updateRow[b] = arrayOfValue1[b];
/*      */           }
/*      */         } 
/* 3029 */         Value[] arrayOfValue2 = updatableRow.readRow(this.updateRow);
/* 3030 */         patchCurrentRow(arrayOfValue2);
/* 3031 */         this.updateRow = null;
/*      */       } 
/* 3033 */     } catch (Exception exception) {
/* 3034 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void deleteRow() throws SQLException {
/*      */     try {
/* 3048 */       debugCodeCall("deleteRow");
/* 3049 */       checkUpdatable();
/* 3050 */       if (this.insertRow != null) {
/* 3051 */         throw DbException.get(90029);
/*      */       }
/* 3053 */       checkOnValidRow();
/* 3054 */       getUpdatableRow().deleteRow(this.result.currentRow());
/* 3055 */       this.updateRow = null;
/* 3056 */     } catch (Exception exception) {
/* 3057 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void refreshRow() throws SQLException {
/*      */     try {
/* 3071 */       debugCodeCall("refreshRow");
/* 3072 */       checkClosed();
/* 3073 */       if (this.insertRow != null) {
/* 3074 */         throw DbException.get(2000);
/*      */       }
/* 3076 */       checkOnValidRow();
/* 3077 */       patchCurrentRow(getUpdatableRow().readRow(this.result.currentRow()));
/* 3078 */       this.updateRow = null;
/* 3079 */     } catch (Exception exception) {
/* 3080 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cancelRowUpdates() throws SQLException {
/*      */     try {
/* 3093 */       debugCodeCall("cancelRowUpdates");
/* 3094 */       checkClosed();
/* 3095 */       if (this.insertRow != null) {
/* 3096 */         throw DbException.get(2000);
/*      */       }
/* 3098 */       this.updateRow = null;
/* 3099 */     } catch (Exception exception) {
/* 3100 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private UpdatableRow getUpdatableRow() throws SQLException {
/* 3107 */     UpdatableRow updatableRow = new UpdatableRow(this.conn, this.result);
/* 3108 */     if (!updatableRow.isUpdatable()) {
/* 3109 */       throw DbException.get(90127);
/*      */     }
/* 3111 */     return updatableRow;
/*      */   }
/*      */   
/*      */   private int getColumnIndex(String paramString) {
/* 3115 */     checkClosed();
/* 3116 */     if (paramString == null) {
/* 3117 */       throw DbException.getInvalidValueException("columnLabel", null);
/*      */     }
/* 3119 */     if (this.columnCount >= 3) {
/*      */       
/* 3121 */       if (this.columnLabelMap == null) {
/* 3122 */         HashMap<String, Integer> hashMap = New.hashMap(this.columnCount);
/*      */         byte b;
/* 3124 */         for (b = 0; b < this.columnCount; b++) {
/* 3125 */           String str = StringUtils.toUpperEnglish(this.result.getAlias(b));
/* 3126 */           mapColumn(hashMap, str, b);
/*      */         } 
/* 3128 */         for (b = 0; b < this.columnCount; b++) {
/* 3129 */           String str = this.result.getColumnName(b);
/* 3130 */           if (str != null) {
/* 3131 */             str = StringUtils.toUpperEnglish(str);
/* 3132 */             mapColumn(hashMap, str, b);
/* 3133 */             String str1 = this.result.getTableName(b);
/* 3134 */             if (str1 != null) {
/* 3135 */               str = StringUtils.toUpperEnglish(str1) + "." + str;
/* 3136 */               mapColumn(hashMap, str, b);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/* 3141 */         this.columnLabelMap = hashMap;
/* 3142 */         if (this.preparedStatement != null) {
/* 3143 */           this.preparedStatement.setCachedColumnLabelMap(this.columnLabelMap);
/*      */         }
/*      */       } 
/* 3146 */       Integer integer = this.columnLabelMap.get(StringUtils.toUpperEnglish(paramString));
/* 3147 */       if (integer == null) {
/* 3148 */         throw DbException.get(42122, paramString);
/*      */       }
/* 3150 */       return integer.intValue() + 1;
/*      */     }  int i;
/* 3152 */     for (i = 0; i < this.columnCount; i++) {
/* 3153 */       if (paramString.equalsIgnoreCase(this.result.getAlias(i))) {
/* 3154 */         return i + 1;
/*      */       }
/*      */     } 
/* 3157 */     i = paramString.indexOf('.');
/* 3158 */     if (i > 0) {
/* 3159 */       String str1 = paramString.substring(0, i);
/* 3160 */       String str2 = paramString.substring(i + 1);
/* 3161 */       for (byte b = 0; b < this.columnCount; b++) {
/* 3162 */         if (str1.equalsIgnoreCase(this.result.getTableName(b)) && str2.equalsIgnoreCase(this.result.getColumnName(b)))
/*      */         {
/* 3164 */           return b + 1;
/*      */         }
/*      */       } 
/*      */     } else {
/* 3168 */       for (byte b = 0; b < this.columnCount; b++) {
/* 3169 */         if (paramString.equalsIgnoreCase(this.result.getColumnName(b))) {
/* 3170 */           return b + 1;
/*      */         }
/*      */       } 
/*      */     } 
/* 3174 */     throw DbException.get(42122, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void mapColumn(HashMap<String, Integer> paramHashMap, String paramString, int paramInt) {
/* 3180 */     Integer integer = paramHashMap.put(paramString, Integer.valueOf(paramInt));
/* 3181 */     if (integer != null)
/*      */     {
/*      */       
/* 3184 */       paramHashMap.put(paramString, integer);
/*      */     }
/*      */   }
/*      */   
/*      */   private void checkColumnIndex(int paramInt) {
/* 3189 */     checkClosed();
/* 3190 */     if (paramInt < 1 || paramInt > this.columnCount) {
/* 3191 */       throw DbException.getInvalidValueException("columnIndex", Integer.valueOf(paramInt));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void checkClosed() {
/* 3201 */     if (this.result == null) {
/* 3202 */       throw DbException.get(90007);
/*      */     }
/* 3204 */     if (this.stat != null) {
/* 3205 */       this.stat.checkClosed();
/*      */     }
/* 3207 */     if (this.conn != null) {
/* 3208 */       this.conn.checkClosed();
/*      */     }
/*      */   }
/*      */   
/*      */   private void checkOnValidRow() {
/* 3213 */     if (this.result.getRowId() < 0 || this.result.getRowId() >= this.result.getRowCount())
/* 3214 */       throw DbException.get(2000); 
/*      */   }
/*      */   
/*      */   private Value get(int paramInt) {
/*      */     Value[] arrayOfValue;
/* 3219 */     checkColumnIndex(paramInt);
/* 3220 */     checkOnValidRow();
/*      */     
/* 3222 */     if (this.patchedRows == null) {
/* 3223 */       arrayOfValue = this.result.currentRow();
/*      */     } else {
/* 3225 */       arrayOfValue = this.patchedRows.get(Integer.valueOf(this.result.getRowId()));
/* 3226 */       if (arrayOfValue == null) {
/* 3227 */         arrayOfValue = this.result.currentRow();
/*      */       }
/*      */     } 
/* 3230 */     Value value = arrayOfValue[paramInt - 1];
/* 3231 */     this.wasNull = (value == ValueNull.INSTANCE);
/* 3232 */     return value;
/*      */   }
/*      */   
/*      */   private Value get(String paramString) {
/* 3236 */     int i = getColumnIndex(paramString);
/* 3237 */     return get(i);
/*      */   }
/*      */   
/*      */   private void update(String paramString, Value paramValue) {
/* 3241 */     int i = getColumnIndex(paramString);
/* 3242 */     update(i, paramValue);
/*      */   }
/*      */   
/*      */   private void update(int paramInt, Value paramValue) {
/* 3246 */     checkUpdatable();
/* 3247 */     checkColumnIndex(paramInt);
/* 3248 */     if (this.insertRow != null) {
/* 3249 */       this.insertRow[paramInt - 1] = paramValue;
/*      */     } else {
/* 3251 */       if (this.updateRow == null) {
/* 3252 */         this.updateRow = new Value[this.columnCount];
/*      */       }
/* 3254 */       this.updateRow[paramInt - 1] = paramValue;
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean nextRow() {
/* 3259 */     boolean bool = this.result.next();
/* 3260 */     if (!bool && !this.scrollable) {
/* 3261 */       this.result.close();
/*      */     }
/* 3263 */     return bool;
/*      */   }
/*      */   
/*      */   private void resetResult() {
/* 3267 */     if (!this.scrollable) {
/* 3268 */       throw DbException.get(90128);
/*      */     }
/* 3270 */     this.result.reset();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RowId getRowId(int paramInt) throws SQLException {
/* 3280 */     throw unsupported("rowId");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RowId getRowId(String paramString) throws SQLException {
/* 3290 */     throw unsupported("rowId");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRowId(int paramInt, RowId paramRowId) throws SQLException {
/* 3301 */     throw unsupported("rowId");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRowId(String paramString, RowId paramRowId) throws SQLException {
/* 3312 */     throw unsupported("rowId");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getHoldability() throws SQLException {
/*      */     try {
/* 3324 */       debugCodeCall("getHoldability");
/* 3325 */       checkClosed();
/* 3326 */       return this.conn.getHoldability();
/* 3327 */     } catch (Exception exception) {
/* 3328 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isClosed() throws SQLException {
/*      */     try {
/* 3340 */       debugCodeCall("isClosed");
/* 3341 */       return (this.result == null);
/* 3342 */     } catch (Exception exception) {
/* 3343 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateNString(int paramInt, String paramString) throws SQLException {
/*      */     try {
/* 3357 */       if (isDebugEnabled()) {
/* 3358 */         debugCode("updateNString(" + paramInt + ", " + quote(paramString) + ");");
/*      */       }
/* 3360 */       update(paramInt, (paramString == null) ? (Value)ValueNull.INSTANCE : ValueString.get(paramString));
/*      */     }
/* 3362 */     catch (Exception exception) {
/* 3363 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateNString(String paramString1, String paramString2) throws SQLException {
/*      */     try {
/* 3377 */       if (isDebugEnabled()) {
/* 3378 */         debugCode("updateNString(" + quote(paramString1) + ", " + quote(paramString2) + ");");
/*      */       }
/* 3380 */       update(paramString1, (paramString2 == null) ? (Value)ValueNull.INSTANCE : ValueString.get(paramString2));
/*      */     }
/* 3382 */     catch (Exception exception) {
/* 3383 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNClob(int paramInt, NClob paramNClob) throws SQLException {
/* 3392 */     throw unsupported("NClob");
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
/*      */   public void updateNClob(int paramInt, Reader paramReader) throws SQLException {
/* 3404 */     updateClob(paramInt, paramReader, -1L);
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
/*      */   public void updateNClob(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/* 3418 */     updateClob(paramInt, paramReader, paramLong);
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
/*      */   public void updateNClob(String paramString, Reader paramReader) throws SQLException {
/* 3430 */     updateClob(paramString, paramReader, -1L);
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
/*      */   public void updateNClob(String paramString, Reader paramReader, long paramLong) throws SQLException {
/* 3444 */     updateClob(paramString, paramReader, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNClob(String paramString, NClob paramNClob) throws SQLException {
/* 3452 */     throw unsupported("NClob");
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
/*      */   public NClob getNClob(int paramInt) throws SQLException {
/*      */     try {
/* 3466 */       int i = getNextId(10);
/* 3467 */       if (isDebugEnabled()) {
/* 3468 */         debugCodeAssign("NClob", 10, i, "getNClob(" + paramInt + ")");
/*      */       }
/* 3470 */       Value value = get(paramInt);
/* 3471 */       return (value == ValueNull.INSTANCE) ? null : new JdbcClob(this.conn, value, i);
/* 3472 */     } catch (Exception exception) {
/* 3473 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public NClob getNClob(String paramString) throws SQLException {
/*      */     try {
/* 3488 */       int i = getNextId(10);
/* 3489 */       if (isDebugEnabled()) {
/* 3490 */         debugCodeAssign("NClob", 10, i, "getNClob(" + paramString + ")");
/*      */       }
/* 3492 */       Value value = get(paramString);
/* 3493 */       return (value == ValueNull.INSTANCE) ? null : new JdbcClob(this.conn, value, i);
/* 3494 */     } catch (Exception exception) {
/* 3495 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SQLXML getSQLXML(int paramInt) throws SQLException {
/* 3505 */     throw unsupported("SQLXML");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SQLXML getSQLXML(String paramString) throws SQLException {
/* 3514 */     throw unsupported("SQLXML");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateSQLXML(int paramInt, SQLXML paramSQLXML) throws SQLException {
/* 3523 */     throw unsupported("SQLXML");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateSQLXML(String paramString, SQLXML paramSQLXML) throws SQLException {
/* 3532 */     throw unsupported("SQLXML");
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
/*      */   public String getNString(int paramInt) throws SQLException {
/*      */     try {
/* 3546 */       debugCodeCall("getNString", paramInt);
/* 3547 */       return get(paramInt).getString();
/* 3548 */     } catch (Exception exception) {
/* 3549 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public String getNString(String paramString) throws SQLException {
/*      */     try {
/* 3564 */       debugCodeCall("getNString", paramString);
/* 3565 */       return get(paramString).getString();
/* 3566 */     } catch (Exception exception) {
/* 3567 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Reader getNCharacterStream(int paramInt) throws SQLException {
/*      */     try {
/* 3582 */       debugCodeCall("getNCharacterStream", paramInt);
/* 3583 */       return get(paramInt).getReader();
/* 3584 */     } catch (Exception exception) {
/* 3585 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public Reader getNCharacterStream(String paramString) throws SQLException {
/*      */     try {
/* 3600 */       debugCodeCall("getNCharacterStream", paramString);
/* 3601 */       return get(paramString).getReader();
/* 3602 */     } catch (Exception exception) {
/* 3603 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateNCharacterStream(int paramInt, Reader paramReader) throws SQLException {
/* 3617 */     updateNCharacterStream(paramInt, paramReader, -1L);
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
/*      */   public void updateNCharacterStream(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/*      */     try {
/* 3632 */       if (isDebugEnabled()) {
/* 3633 */         debugCode("updateNCharacterStream(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/* 3635 */       checkClosed();
/* 3636 */       Value value = this.conn.createClob(paramReader, paramLong);
/* 3637 */       update(paramInt, value);
/* 3638 */     } catch (Exception exception) {
/* 3639 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public void updateNCharacterStream(String paramString, Reader paramReader) throws SQLException {
/* 3653 */     updateNCharacterStream(paramString, paramReader, -1L);
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
/*      */   public void updateNCharacterStream(String paramString, Reader paramReader, long paramLong) throws SQLException {
/*      */     try {
/* 3668 */       if (isDebugEnabled()) {
/* 3669 */         debugCode("updateNCharacterStream(" + quote(paramString) + ", x, " + paramLong + "L);");
/*      */       }
/* 3671 */       checkClosed();
/* 3672 */       Value value = this.conn.createClob(paramReader, paramLong);
/* 3673 */       update(paramString, value);
/* 3674 */     } catch (Exception exception) {
/* 3675 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public <T> T unwrap(Class<T> paramClass) throws SQLException {
/* 3688 */     if (isWrapperFor(paramClass)) {
/* 3689 */       return (T)this;
/*      */     }
/* 3691 */     throw DbException.getInvalidValueException("iface", paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWrapperFor(Class<?> paramClass) throws SQLException {
/* 3702 */     return (paramClass != null && paramClass.isAssignableFrom(getClass()));
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
/*      */   public <T> T getObject(int paramInt, Class<T> paramClass) throws SQLException {
/*      */     try {
/* 3718 */       if (paramClass == null) {
/* 3719 */         throw DbException.getInvalidValueException("type", paramClass);
/*      */       }
/* 3721 */       debugCodeCall("getObject", paramInt);
/* 3722 */       Value value = get(paramInt);
/* 3723 */       return extractObjectOfType(paramClass, value);
/* 3724 */     } catch (Exception exception) {
/* 3725 */       throw logAndConvert(exception);
/*      */     } 
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
/*      */   public <T> T getObject(String paramString, Class<T> paramClass) throws SQLException {
/*      */     try {
/* 3740 */       if (paramClass == null) {
/* 3741 */         throw DbException.getInvalidValueException("type", paramClass);
/*      */       }
/* 3743 */       debugCodeCall("getObject", paramString);
/* 3744 */       Value value = get(paramString);
/* 3745 */       return extractObjectOfType(paramClass, value);
/* 3746 */     } catch (Exception exception) {
/* 3747 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   private <T> T extractObjectOfType(Class<T> paramClass, Value paramValue) throws SQLException {
/* 3752 */     if (paramValue == ValueNull.INSTANCE) {
/* 3753 */       return null;
/*      */     }
/* 3755 */     if (paramClass == BigDecimal.class)
/* 3756 */       return paramClass.cast(paramValue.getBigDecimal()); 
/* 3757 */     if (paramClass == String.class)
/* 3758 */       return paramClass.cast(paramValue.getString()); 
/* 3759 */     if (paramClass == Boolean.class)
/* 3760 */       return paramClass.cast(paramValue.getBoolean()); 
/* 3761 */     if (paramClass == Byte.class)
/* 3762 */       return paramClass.cast(Byte.valueOf(paramValue.getByte())); 
/* 3763 */     if (paramClass == Short.class)
/* 3764 */       return paramClass.cast(Short.valueOf(paramValue.getShort())); 
/* 3765 */     if (paramClass == Integer.class)
/* 3766 */       return paramClass.cast(Integer.valueOf(paramValue.getInt())); 
/* 3767 */     if (paramClass == Long.class)
/* 3768 */       return paramClass.cast(Long.valueOf(paramValue.getLong())); 
/* 3769 */     if (paramClass == Float.class)
/* 3770 */       return paramClass.cast(Float.valueOf(paramValue.getFloat())); 
/* 3771 */     if (paramClass == Double.class)
/* 3772 */       return paramClass.cast(Double.valueOf(paramValue.getDouble())); 
/* 3773 */     if (paramClass == Date.class)
/* 3774 */       return paramClass.cast(paramValue.getDate()); 
/* 3775 */     if (paramClass == Time.class)
/* 3776 */       return paramClass.cast(paramValue.getTime()); 
/* 3777 */     if (paramClass == Timestamp.class)
/* 3778 */       return paramClass.cast(paramValue.getTimestamp()); 
/* 3779 */     if (paramClass == UUID.class)
/* 3780 */       return paramClass.cast(paramValue.getObject()); 
/* 3781 */     if (paramClass == byte[].class)
/* 3782 */       return paramClass.cast(paramValue.getBytes()); 
/* 3783 */     if (paramClass == TimestampWithTimeZone.class)
/* 3784 */       return paramClass.cast(paramValue.getObject()); 
/* 3785 */     if (paramClass.isAssignableFrom(Geometry.class))
/* 3786 */       return paramClass.cast(paramValue.getObject()); 
/* 3787 */     if (LocalDateTimeUtils.isLocalDate(paramClass))
/* 3788 */       return paramClass.cast(LocalDateTimeUtils.valueToLocalDate(paramValue)); 
/* 3789 */     if (LocalDateTimeUtils.isLocalTime(paramClass))
/* 3790 */       return paramClass.cast(LocalDateTimeUtils.valueToLocalTime(paramValue)); 
/* 3791 */     if (LocalDateTimeUtils.isLocalDateTime(paramClass)) {
/* 3792 */       return paramClass.cast(LocalDateTimeUtils.valueToLocalDateTime((ValueTimestamp)paramValue));
/*      */     }
/* 3794 */     if (LocalDateTimeUtils.isOffsetDateTime(paramClass) && paramValue instanceof ValueTimestampTimeZone)
/*      */     {
/* 3796 */       return paramClass.cast(LocalDateTimeUtils.valueToOffsetDateTime((ValueTimestampTimeZone)paramValue));
/*      */     }
/*      */     
/* 3799 */     throw unsupported(paramClass.getClass().getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 3808 */     return getTraceObjectName() + ": " + this.result;
/*      */   }
/*      */   
/*      */   private void patchCurrentRow(Value[] paramArrayOfValue) {
/* 3812 */     boolean bool = false;
/* 3813 */     Value[] arrayOfValue = this.result.currentRow();
/* 3814 */     CompareMode compareMode = this.conn.getCompareMode();
/* 3815 */     for (byte b = 0; b < paramArrayOfValue.length; b++) {
/* 3816 */       if (paramArrayOfValue[b].compareTo(arrayOfValue[b], compareMode) != 0) {
/* 3817 */         bool = true;
/*      */         break;
/*      */       } 
/*      */     } 
/* 3821 */     if (this.patchedRows == null) {
/* 3822 */       this.patchedRows = New.hashMap();
/*      */     }
/* 3824 */     Integer integer = Integer.valueOf(this.result.getRowId());
/* 3825 */     if (!bool) {
/* 3826 */       this.patchedRows.remove(integer);
/*      */     } else {
/* 3828 */       this.patchedRows.put(integer, paramArrayOfValue);
/*      */     } 
/*      */   }
/*      */   
/*      */   private Value convertToUnknownValue(Object paramObject) {
/* 3833 */     checkClosed();
/* 3834 */     return DataType.convertToValue(this.conn.getSession(), paramObject, -1);
/*      */   }
/*      */   
/*      */   private void checkUpdatable() {
/* 3838 */     checkClosed();
/* 3839 */     if (!this.updatable)
/* 3840 */       throw DbException.get(90140); 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcResultSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */