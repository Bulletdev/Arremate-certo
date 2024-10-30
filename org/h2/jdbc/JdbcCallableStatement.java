/*      */ package org.h2.jdbc;
/*      */ 
/*      */ import java.io.InputStream;
/*      */ import java.io.Reader;
/*      */ import java.math.BigDecimal;
/*      */ import java.net.URL;
/*      */ import java.sql.Array;
/*      */ import java.sql.Blob;
/*      */ import java.sql.CallableStatement;
/*      */ import java.sql.Clob;
/*      */ import java.sql.Date;
/*      */ import java.sql.NClob;
/*      */ import java.sql.Ref;
/*      */ import java.sql.ResultSetMetaData;
/*      */ import java.sql.RowId;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.SQLXML;
/*      */ import java.sql.Time;
/*      */ import java.sql.Timestamp;
/*      */ import java.util.Calendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import org.h2.expression.ParameterInterface;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.util.BitField;
/*      */ import org.h2.util.New;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JdbcCallableStatement
/*      */   extends JdbcPreparedStatement
/*      */   implements CallableStatement, JdbcCallableStatementBackwardsCompat
/*      */ {
/*      */   private BitField outParameters;
/*      */   private int maxOutParameters;
/*      */   private HashMap<String, Integer> namedParameters;
/*      */   
/*      */   JdbcCallableStatement(JdbcConnection paramJdbcConnection, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/*   51 */     super(paramJdbcConnection, paramString, paramInt1, paramInt2, paramInt3, false);
/*   52 */     setTrace(this.session.getTrace(), 0, paramInt1);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int executeUpdate() throws SQLException {
/*      */     try {
/*   74 */       checkClosed();
/*   75 */       if (this.command.isQuery()) {
/*   76 */         executeQuery();
/*   77 */         return 0;
/*      */       } 
/*   79 */       return super.executeUpdate();
/*   80 */     } catch (Exception exception) {
/*   81 */       throw logAndConvert(exception);
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
/*      */   public void registerOutParameter(int paramInt1, int paramInt2) throws SQLException {
/*   94 */     registerOutParameter(paramInt1);
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
/*      */   public void registerOutParameter(int paramInt1, int paramInt2, String paramString) throws SQLException {
/*  107 */     registerOutParameter(paramInt1);
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
/*      */   public void registerOutParameter(int paramInt1, int paramInt2, int paramInt3) throws SQLException {
/*  120 */     registerOutParameter(paramInt1);
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
/*      */   public void registerOutParameter(String paramString1, int paramInt, String paramString2) throws SQLException {
/*  133 */     registerOutParameter(getIndexForName(paramString1), paramInt, paramString2);
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
/*      */   public void registerOutParameter(String paramString, int paramInt1, int paramInt2) throws SQLException {
/*  146 */     registerOutParameter(getIndexForName(paramString), paramInt1, paramInt2);
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
/*      */   public void registerOutParameter(String paramString, int paramInt) throws SQLException {
/*  158 */     registerOutParameter(getIndexForName(paramString), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean wasNull() throws SQLException {
/*  168 */     return getOpenResultSet().wasNull();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public URL getURL(int paramInt) throws SQLException {
/*  176 */     throw unsupported("url");
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
/*      */   public String getString(int paramInt) throws SQLException {
/*  189 */     checkRegistered(paramInt);
/*  190 */     return getOpenResultSet().getString(paramInt);
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
/*  203 */     checkRegistered(paramInt);
/*  204 */     return getOpenResultSet().getBoolean(paramInt);
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
/*  217 */     checkRegistered(paramInt);
/*  218 */     return getOpenResultSet().getByte(paramInt);
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
/*  231 */     checkRegistered(paramInt);
/*  232 */     return getOpenResultSet().getShort(paramInt);
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
/*  245 */     checkRegistered(paramInt);
/*  246 */     return getOpenResultSet().getInt(paramInt);
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
/*  259 */     checkRegistered(paramInt);
/*  260 */     return getOpenResultSet().getLong(paramInt);
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
/*  273 */     checkRegistered(paramInt);
/*  274 */     return getOpenResultSet().getFloat(paramInt);
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
/*  287 */     checkRegistered(paramInt);
/*  288 */     return getOpenResultSet().getDouble(paramInt);
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
/*  306 */     checkRegistered(paramInt1);
/*  307 */     return getOpenResultSet().getBigDecimal(paramInt1, paramInt2);
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
/*  320 */     checkRegistered(paramInt);
/*  321 */     return getOpenResultSet().getBytes(paramInt);
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
/*  334 */     checkRegistered(paramInt);
/*  335 */     return getOpenResultSet().getDate(paramInt);
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
/*  348 */     checkRegistered(paramInt);
/*  349 */     return getOpenResultSet().getTime(paramInt);
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
/*  362 */     checkRegistered(paramInt);
/*  363 */     return getOpenResultSet().getTimestamp(paramInt);
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
/*  377 */     checkRegistered(paramInt);
/*  378 */     return getOpenResultSet().getObject(paramInt);
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
/*  391 */     checkRegistered(paramInt);
/*  392 */     return getOpenResultSet().getBigDecimal(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObject(int paramInt, Map<String, Class<?>> paramMap) throws SQLException {
/*  402 */     throw unsupported("map");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Ref getRef(int paramInt) throws SQLException {
/*  410 */     throw unsupported("ref");
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
/*  423 */     checkRegistered(paramInt);
/*  424 */     return getOpenResultSet().getBlob(paramInt);
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
/*  437 */     checkRegistered(paramInt);
/*  438 */     return getOpenResultSet().getClob(paramInt);
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
/*  451 */     checkRegistered(paramInt);
/*  452 */     return getOpenResultSet().getArray(paramInt);
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
/*  467 */     checkRegistered(paramInt);
/*  468 */     return getOpenResultSet().getDate(paramInt, paramCalendar);
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
/*  483 */     checkRegistered(paramInt);
/*  484 */     return getOpenResultSet().getTime(paramInt, paramCalendar);
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
/*  500 */     checkRegistered(paramInt);
/*  501 */     return getOpenResultSet().getTimestamp(paramInt, paramCalendar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public URL getURL(String paramString) throws SQLException {
/*  509 */     throw unsupported("url");
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
/*      */   public Timestamp getTimestamp(String paramString, Calendar paramCalendar) throws SQLException {
/*  525 */     return getTimestamp(getIndexForName(paramString), paramCalendar);
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
/*      */   public Time getTime(String paramString, Calendar paramCalendar) throws SQLException {
/*  540 */     return getTime(getIndexForName(paramString), paramCalendar);
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
/*      */   public Date getDate(String paramString, Calendar paramCalendar) throws SQLException {
/*  555 */     return getDate(getIndexForName(paramString), paramCalendar);
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
/*  568 */     return getArray(getIndexForName(paramString));
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
/*  581 */     return getClob(getIndexForName(paramString));
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
/*  594 */     return getBlob(getIndexForName(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Ref getRef(String paramString) throws SQLException {
/*  602 */     throw unsupported("ref");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObject(String paramString, Map<String, Class<?>> paramMap) throws SQLException {
/*  612 */     throw unsupported("map");
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
/*  625 */     return getBigDecimal(getIndexForName(paramString));
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
/*  639 */     return getObject(getIndexForName(paramString));
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
/*  652 */     return getTimestamp(getIndexForName(paramString));
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
/*  665 */     return getTime(getIndexForName(paramString));
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
/*  678 */     return getDate(getIndexForName(paramString));
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
/*  691 */     return getBytes(getIndexForName(paramString));
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
/*  704 */     return getDouble(getIndexForName(paramString));
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
/*  717 */     return getFloat(getIndexForName(paramString));
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
/*  730 */     return getLong(getIndexForName(paramString));
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
/*  743 */     return getInt(getIndexForName(paramString));
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
/*  756 */     return getShort(getIndexForName(paramString));
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
/*  769 */     return getByte(getIndexForName(paramString));
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
/*  782 */     return getBoolean(getIndexForName(paramString));
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
/*  795 */     return getString(getIndexForName(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RowId getRowId(int paramInt) throws SQLException {
/*  805 */     throw unsupported("rowId");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RowId getRowId(String paramString) throws SQLException {
/*  815 */     throw unsupported("rowId");
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
/*  828 */     checkRegistered(paramInt);
/*  829 */     return getOpenResultSet().getNClob(paramInt);
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
/*  842 */     return getNClob(getIndexForName(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SQLXML getSQLXML(int paramInt) throws SQLException {
/*  851 */     throw unsupported("SQLXML");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SQLXML getSQLXML(String paramString) throws SQLException {
/*  860 */     throw unsupported("SQLXML");
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
/*  873 */     checkRegistered(paramInt);
/*  874 */     return getOpenResultSet().getNString(paramInt);
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
/*  887 */     return getNString(getIndexForName(paramString));
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
/*      */   public Reader getNCharacterStream(int paramInt) throws SQLException {
/*  901 */     checkRegistered(paramInt);
/*  902 */     return getOpenResultSet().getNCharacterStream(paramInt);
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
/*      */   public Reader getNCharacterStream(String paramString) throws SQLException {
/*  916 */     return getNCharacterStream(getIndexForName(paramString));
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
/*      */   public Reader getCharacterStream(int paramInt) throws SQLException {
/*  930 */     checkRegistered(paramInt);
/*  931 */     return getOpenResultSet().getCharacterStream(paramInt);
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
/*      */   public Reader getCharacterStream(String paramString) throws SQLException {
/*  945 */     return getCharacterStream(getIndexForName(paramString));
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
/*      */   public void setNull(String paramString1, int paramInt, String paramString2) throws SQLException {
/*  961 */     setNull(getIndexForName(paramString1), paramInt, paramString2);
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
/*      */   public void setNull(String paramString, int paramInt) throws SQLException {
/*  973 */     setNull(getIndexForName(paramString), paramInt);
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
/*      */   public void setTimestamp(String paramString, Timestamp paramTimestamp, Calendar paramCalendar) throws SQLException {
/*  988 */     setTimestamp(getIndexForName(paramString), paramTimestamp, paramCalendar);
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
/*      */   public void setTime(String paramString, Time paramTime, Calendar paramCalendar) throws SQLException {
/* 1003 */     setTime(getIndexForName(paramString), paramTime, paramCalendar);
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
/*      */   public void setDate(String paramString, Date paramDate, Calendar paramCalendar) throws SQLException {
/* 1018 */     setDate(getIndexForName(paramString), paramDate, paramCalendar);
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
/*      */   public void setCharacterStream(String paramString, Reader paramReader, int paramInt) throws SQLException {
/* 1034 */     setCharacterStream(getIndexForName(paramString), paramReader, paramInt);
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
/*      */   public void setObject(String paramString, Object paramObject) throws SQLException {
/* 1047 */     setObject(getIndexForName(paramString), paramObject);
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
/*      */   public void setObject(String paramString, Object paramObject, int paramInt) throws SQLException {
/* 1063 */     setObject(getIndexForName(paramString), paramObject, paramInt);
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
/*      */   public void setObject(String paramString, Object paramObject, int paramInt1, int paramInt2) throws SQLException {
/* 1080 */     setObject(getIndexForName(paramString), paramObject, paramInt1, paramInt2);
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
/*      */   public void setBinaryStream(String paramString, InputStream paramInputStream, int paramInt) throws SQLException {
/* 1096 */     setBinaryStream(getIndexForName(paramString), paramInputStream, paramInt);
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
/*      */   public void setAsciiStream(String paramString, InputStream paramInputStream, long paramLong) throws SQLException {
/* 1112 */     setAsciiStream(getIndexForName(paramString), paramInputStream, paramLong);
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
/*      */   public void setTimestamp(String paramString, Timestamp paramTimestamp) throws SQLException {
/* 1125 */     setTimestamp(getIndexForName(paramString), paramTimestamp);
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
/*      */   public void setTime(String paramString, Time paramTime) throws SQLException {
/* 1137 */     setTime(getIndexForName(paramString), paramTime);
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
/*      */   public void setDate(String paramString, Date paramDate) throws SQLException {
/* 1149 */     setDate(getIndexForName(paramString), paramDate);
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
/*      */   public void setBytes(String paramString, byte[] paramArrayOfbyte) throws SQLException {
/* 1161 */     setBytes(getIndexForName(paramString), paramArrayOfbyte);
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
/*      */   public void setString(String paramString1, String paramString2) throws SQLException {
/* 1173 */     setString(getIndexForName(paramString1), paramString2);
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
/*      */   public void setBigDecimal(String paramString, BigDecimal paramBigDecimal) throws SQLException {
/* 1186 */     setBigDecimal(getIndexForName(paramString), paramBigDecimal);
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
/*      */   public void setDouble(String paramString, double paramDouble) throws SQLException {
/* 1198 */     setDouble(getIndexForName(paramString), paramDouble);
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
/*      */   public void setFloat(String paramString, float paramFloat) throws SQLException {
/* 1210 */     setFloat(getIndexForName(paramString), paramFloat);
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
/*      */   public void setLong(String paramString, long paramLong) throws SQLException {
/* 1222 */     setLong(getIndexForName(paramString), paramLong);
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
/*      */   public void setInt(String paramString, int paramInt) throws SQLException {
/* 1234 */     setInt(getIndexForName(paramString), paramInt);
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
/*      */   public void setShort(String paramString, short paramShort) throws SQLException {
/* 1246 */     setShort(getIndexForName(paramString), paramShort);
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
/*      */   public void setByte(String paramString, byte paramByte) throws SQLException {
/* 1258 */     setByte(getIndexForName(paramString), paramByte);
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
/*      */   public void setBoolean(String paramString, boolean paramBoolean) throws SQLException {
/* 1270 */     setBoolean(getIndexForName(paramString), paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setURL(String paramString, URL paramURL) throws SQLException {
/* 1278 */     throw unsupported("url");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRowId(String paramString, RowId paramRowId) throws SQLException {
/* 1287 */     throw unsupported("rowId");
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
/*      */   public void setNString(String paramString1, String paramString2) throws SQLException {
/* 1300 */     setNString(getIndexForName(paramString1), paramString2);
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
/*      */   public void setNCharacterStream(String paramString, Reader paramReader, long paramLong) throws SQLException {
/* 1316 */     setNCharacterStream(getIndexForName(paramString), paramReader, paramLong);
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
/*      */   public void setNClob(String paramString, NClob paramNClob) throws SQLException {
/* 1329 */     setNClob(getIndexForName(paramString), paramNClob);
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
/*      */   public void setClob(String paramString, Reader paramReader, long paramLong) throws SQLException {
/* 1345 */     setClob(getIndexForName(paramString), paramReader, paramLong);
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
/*      */   public void setBlob(String paramString, InputStream paramInputStream, long paramLong) throws SQLException {
/* 1361 */     setBlob(getIndexForName(paramString), paramInputStream, paramLong);
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
/*      */   public void setNClob(String paramString, Reader paramReader, long paramLong) throws SQLException {
/* 1377 */     setNClob(getIndexForName(paramString), paramReader, paramLong);
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
/*      */   public void setBlob(String paramString, Blob paramBlob) throws SQLException {
/* 1390 */     setBlob(getIndexForName(paramString), paramBlob);
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
/*      */   public void setClob(String paramString, Clob paramClob) throws SQLException {
/* 1402 */     setClob(getIndexForName(paramString), paramClob);
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
/*      */   public void setAsciiStream(String paramString, InputStream paramInputStream) throws SQLException {
/* 1417 */     setAsciiStream(getIndexForName(paramString), paramInputStream);
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
/*      */   public void setAsciiStream(String paramString, InputStream paramInputStream, int paramInt) throws SQLException {
/* 1433 */     setAsciiStream(getIndexForName(paramString), paramInputStream, paramInt);
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
/*      */   public void setBinaryStream(String paramString, InputStream paramInputStream) throws SQLException {
/* 1448 */     setBinaryStream(getIndexForName(paramString), paramInputStream);
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
/*      */   public void setBinaryStream(String paramString, InputStream paramInputStream, long paramLong) throws SQLException {
/* 1464 */     setBinaryStream(getIndexForName(paramString), paramInputStream, paramLong);
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
/*      */   public void setBlob(String paramString, InputStream paramInputStream) throws SQLException {
/* 1479 */     setBlob(getIndexForName(paramString), paramInputStream);
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
/*      */   public void setCharacterStream(String paramString, Reader paramReader) throws SQLException {
/* 1494 */     setCharacterStream(getIndexForName(paramString), paramReader);
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
/*      */   public void setCharacterStream(String paramString, Reader paramReader, long paramLong) throws SQLException {
/* 1510 */     setCharacterStream(getIndexForName(paramString), paramReader, paramLong);
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
/*      */   public void setClob(String paramString, Reader paramReader) throws SQLException {
/* 1524 */     setClob(getIndexForName(paramString), paramReader);
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
/*      */   public void setNCharacterStream(String paramString, Reader paramReader) throws SQLException {
/* 1539 */     setNCharacterStream(getIndexForName(paramString), paramReader);
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
/*      */   public void setNClob(String paramString, Reader paramReader) throws SQLException {
/* 1554 */     setNClob(getIndexForName(paramString), paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSQLXML(String paramString, SQLXML paramSQLXML) throws SQLException {
/* 1563 */     throw unsupported("SQLXML");
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
/* 1574 */     return getOpenResultSet().getObject(paramInt, paramClass);
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
/* 1585 */     return getObject(getIndexForName(paramString), paramClass);
/*      */   }
/*      */   
/*      */   private ResultSetMetaData getCheckedMetaData() throws SQLException {
/* 1589 */     ResultSetMetaData resultSetMetaData = getMetaData();
/* 1590 */     if (resultSetMetaData == null) {
/* 1591 */       throw DbException.getUnsupportedException("Supported only for calling stored procedures");
/*      */     }
/*      */     
/* 1594 */     return resultSetMetaData;
/*      */   }
/*      */   
/*      */   private void checkIndexBounds(int paramInt) {
/* 1598 */     checkClosed();
/* 1599 */     if (paramInt < 1 || paramInt > this.maxOutParameters) {
/* 1600 */       throw DbException.getInvalidValueException("parameterIndex", Integer.valueOf(paramInt));
/*      */     }
/*      */   }
/*      */   
/*      */   private void registerOutParameter(int paramInt) throws SQLException {
/*      */     try {
/* 1606 */       checkClosed();
/* 1607 */       if (this.outParameters == null) {
/* 1608 */         this.maxOutParameters = Math.min(getParameterMetaData().getParameterCount(), getCheckedMetaData().getColumnCount());
/*      */ 
/*      */         
/* 1611 */         this.outParameters = new BitField();
/*      */       } 
/* 1613 */       checkIndexBounds(paramInt);
/* 1614 */       ParameterInterface parameterInterface = this.command.getParameters().get(--paramInt);
/* 1615 */       if (!parameterInterface.isValueSet()) {
/* 1616 */         parameterInterface.setValue((Value)ValueNull.INSTANCE, false);
/*      */       }
/* 1618 */       this.outParameters.set(paramInt);
/* 1619 */     } catch (Exception exception) {
/* 1620 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void checkRegistered(int paramInt) throws SQLException {
/*      */     try {
/* 1626 */       checkIndexBounds(paramInt);
/* 1627 */       if (!this.outParameters.get(paramInt - 1)) {
/* 1628 */         throw DbException.getInvalidValueException("parameterIndex", Integer.valueOf(paramInt));
/*      */       }
/* 1630 */     } catch (Exception exception) {
/* 1631 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   private int getIndexForName(String paramString) throws SQLException {
/*      */     try {
/* 1637 */       checkClosed();
/* 1638 */       if (this.namedParameters == null) {
/* 1639 */         ResultSetMetaData resultSetMetaData = getCheckedMetaData();
/* 1640 */         int i = resultSetMetaData.getColumnCount();
/* 1641 */         HashMap<String, Integer> hashMap = New.hashMap(i);
/* 1642 */         for (byte b = 1; b <= i; b++) {
/* 1643 */           hashMap.put(resultSetMetaData.getColumnLabel(b), Integer.valueOf(b));
/*      */         }
/* 1645 */         this.namedParameters = hashMap;
/*      */       } 
/* 1647 */       Integer integer = this.namedParameters.get(paramString);
/* 1648 */       if (integer == null) {
/* 1649 */         throw DbException.getInvalidValueException("parameterName", paramString);
/*      */       }
/* 1651 */       return integer.intValue();
/* 1652 */     } catch (Exception exception) {
/* 1653 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   private JdbcResultSet getOpenResultSet() throws SQLException {
/*      */     try {
/* 1659 */       checkClosed();
/* 1660 */       if (this.resultSet == null) {
/* 1661 */         throw DbException.get(2000);
/*      */       }
/* 1663 */       if (this.resultSet.isBeforeFirst()) {
/* 1664 */         this.resultSet.next();
/*      */       }
/* 1666 */       return this.resultSet;
/* 1667 */     } catch (Exception exception) {
/* 1668 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcCallableStatement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */