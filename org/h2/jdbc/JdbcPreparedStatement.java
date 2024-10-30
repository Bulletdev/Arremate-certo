/*      */ package org.h2.jdbc;
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
/*      */ import java.sql.ParameterMetaData;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.Ref;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.ResultSetMetaData;
/*      */ import java.sql.RowId;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.SQLXML;
/*      */ import java.sql.Time;
/*      */ import java.sql.Timestamp;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.HashMap;
/*      */ import org.h2.command.CommandInterface;
/*      */ import org.h2.expression.ParameterInterface;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.result.ResultInterface;
/*      */ import org.h2.tools.SimpleResultSet;
/*      */ import org.h2.util.DateTimeUtils;
/*      */ import org.h2.util.IOUtils;
/*      */ import org.h2.util.New;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JdbcPreparedStatement
/*      */   extends JdbcStatement
/*      */   implements PreparedStatement
/*      */ {
/*      */   protected CommandInterface command;
/*      */   private final String sqlStatement;
/*      */   private ArrayList<Value[]> batchParameters;
/*      */   private ArrayList<Object> batchIdentities;
/*      */   private HashMap<String, Integer> cachedColumnLabelMap;
/*      */   
/*      */   JdbcPreparedStatement(JdbcConnection paramJdbcConnection, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/*   70 */     super(paramJdbcConnection, paramInt1, paramInt2, paramInt3, paramBoolean);
/*   71 */     setTrace(this.session.getTrace(), 3, paramInt1);
/*   72 */     this.sqlStatement = paramString;
/*   73 */     this.command = paramJdbcConnection.prepareCommand(paramString, this.fetchSize);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setCachedColumnLabelMap(HashMap<String, Integer> paramHashMap) {
/*   83 */     this.cachedColumnLabelMap = paramHashMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet executeQuery() throws SQLException {
/*      */     try {
/*   97 */       int i = getNextId(4);
/*   98 */       if (isDebugEnabled()) {
/*   99 */         debugCodeAssign("ResultSet", 4, i, "executeQuery()");
/*      */       }
/*  101 */       this.batchIdentities = null;
/*  102 */       synchronized (this.session) {
/*  103 */         ResultInterface resultInterface; checkClosed();
/*  104 */         closeOldResultSet();
/*      */         
/*  106 */         boolean bool1 = (this.resultSetType != 1003) ? true : false;
/*  107 */         boolean bool2 = (this.resultSetConcurrency == 1008) ? true : false;
/*      */         try {
/*  109 */           setExecutingStatement(this.command);
/*  110 */           resultInterface = this.command.executeQuery(this.maxRows, bool1);
/*      */         } finally {
/*  112 */           setExecutingStatement((CommandInterface)null);
/*      */         } 
/*  114 */         this.resultSet = new JdbcResultSet(this.conn, this, resultInterface, i, this.closedByResultSet, bool1, bool2, this.cachedColumnLabelMap);
/*      */       } 
/*      */       
/*  117 */       return this.resultSet;
/*  118 */     } catch (Exception exception) {
/*  119 */       throw logAndConvert(exception);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int executeUpdate() throws SQLException {
/*      */     try {
/*  142 */       debugCodeCall("executeUpdate");
/*  143 */       checkClosedForWrite();
/*  144 */       this.batchIdentities = null;
/*      */       try {
/*  146 */         return executeUpdateInternal();
/*      */       } finally {
/*  148 */         afterWriting();
/*      */       } 
/*  150 */     } catch (Exception exception) {
/*  151 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   private int executeUpdateInternal() throws SQLException {
/*  156 */     closeOldResultSet();
/*  157 */     synchronized (this.session) {
/*      */       try {
/*  159 */         setExecutingStatement(this.command);
/*  160 */         this.updateCount = this.command.executeUpdate();
/*      */       } finally {
/*  162 */         setExecutingStatement((CommandInterface)null);
/*      */       } 
/*      */     } 
/*  165 */     return this.updateCount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean execute() throws SQLException {
/*      */     try {
/*  180 */       int i = getNextId(4);
/*  181 */       if (isDebugEnabled()) {
/*  182 */         debugCodeCall("execute");
/*      */       }
/*  184 */       checkClosedForWrite();
/*      */       try {
/*      */         boolean bool;
/*  187 */         synchronized (this.conn.getSession()) {
/*  188 */           closeOldResultSet();
/*      */           try {
/*  190 */             setExecutingStatement(this.command);
/*  191 */             if (this.command.isQuery()) {
/*  192 */               bool = true;
/*  193 */               boolean bool1 = (this.resultSetType != 1003) ? true : false;
/*  194 */               boolean bool2 = (this.resultSetConcurrency == 1008) ? true : false;
/*  195 */               ResultInterface resultInterface = this.command.executeQuery(this.maxRows, bool1);
/*  196 */               this.resultSet = new JdbcResultSet(this.conn, this, resultInterface, i, this.closedByResultSet, bool1, bool2);
/*      */             }
/*      */             else {
/*      */               
/*  200 */               bool = false;
/*  201 */               this.updateCount = this.command.executeUpdate();
/*      */             } 
/*      */           } finally {
/*  204 */             setExecutingStatement((CommandInterface)null);
/*      */           } 
/*      */         } 
/*  207 */         return bool;
/*      */       } finally {
/*  209 */         afterWriting();
/*      */       } 
/*  211 */     } catch (Exception exception) {
/*  212 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearParameters() throws SQLException {
/*      */     try {
/*  224 */       debugCodeCall("clearParameters");
/*  225 */       checkClosed();
/*  226 */       ArrayList<ParameterInterface> arrayList = this.command.getParameters(); byte b; int i;
/*  227 */       for (b = 0, i = arrayList.size(); b < i; b++) {
/*  228 */         ParameterInterface parameterInterface = arrayList.get(b);
/*      */         
/*  230 */         parameterInterface.setValue(null, (this.batchParameters == null));
/*      */       } 
/*  232 */     } catch (Exception exception) {
/*  233 */       throw logAndConvert(exception);
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
/*      */   public ResultSet executeQuery(String paramString) throws SQLException {
/*      */     try {
/*  246 */       debugCodeCall("executeQuery", paramString);
/*  247 */       throw DbException.get(90130);
/*  248 */     } catch (Exception exception) {
/*  249 */       throw logAndConvert(exception);
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
/*      */   public void addBatch(String paramString) throws SQLException {
/*      */     try {
/*  262 */       debugCodeCall("addBatch", paramString);
/*  263 */       throw DbException.get(90130);
/*  264 */     } catch (Exception exception) {
/*  265 */       throw logAndConvert(exception);
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
/*      */   public int executeUpdate(String paramString) throws SQLException {
/*      */     try {
/*  278 */       debugCodeCall("executeUpdate", paramString);
/*  279 */       throw DbException.get(90130);
/*  280 */     } catch (Exception exception) {
/*  281 */       throw logAndConvert(exception);
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
/*      */   public boolean execute(String paramString) throws SQLException {
/*      */     try {
/*  294 */       debugCodeCall("execute", paramString);
/*  295 */       throw DbException.get(90130);
/*  296 */     } catch (Exception exception) {
/*  297 */       throw logAndConvert(exception);
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
/*      */   public void setNull(int paramInt1, int paramInt2) throws SQLException {
/*      */     try {
/*  313 */       if (isDebugEnabled()) {
/*  314 */         debugCode("setNull(" + paramInt1 + ", " + paramInt2 + ");");
/*      */       }
/*  316 */       setParameter(paramInt1, (Value)ValueNull.INSTANCE);
/*  317 */     } catch (Exception exception) {
/*  318 */       throw logAndConvert(exception);
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
/*      */   public void setInt(int paramInt1, int paramInt2) throws SQLException {
/*      */     try {
/*  332 */       if (isDebugEnabled()) {
/*  333 */         debugCode("setInt(" + paramInt1 + ", " + paramInt2 + ");");
/*      */       }
/*  335 */       setParameter(paramInt1, (Value)ValueInt.get(paramInt2));
/*  336 */     } catch (Exception exception) {
/*  337 */       throw logAndConvert(exception);
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
/*      */   public void setString(int paramInt, String paramString) throws SQLException {
/*      */     try {
/*  351 */       if (isDebugEnabled()) {
/*  352 */         debugCode("setString(" + paramInt + ", " + quote(paramString) + ");");
/*      */       }
/*  354 */       Value value = (Value)((paramString == null) ? ValueNull.INSTANCE : ValueString.get(paramString));
/*  355 */       setParameter(paramInt, value);
/*  356 */     } catch (Exception exception) {
/*  357 */       throw logAndConvert(exception);
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
/*      */   public void setBigDecimal(int paramInt, BigDecimal paramBigDecimal) throws SQLException {
/*      */     try {
/*  372 */       if (isDebugEnabled()) {
/*  373 */         debugCode("setBigDecimal(" + paramInt + ", " + quoteBigDecimal(paramBigDecimal) + ");");
/*      */       }
/*  375 */       Value value = (Value)((paramBigDecimal == null) ? ValueNull.INSTANCE : ValueDecimal.get(paramBigDecimal));
/*  376 */       setParameter(paramInt, value);
/*  377 */     } catch (Exception exception) {
/*  378 */       throw logAndConvert(exception);
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
/*      */   public void setDate(int paramInt, Date paramDate) throws SQLException {
/*      */     try {
/*  393 */       if (isDebugEnabled()) {
/*  394 */         debugCode("setDate(" + paramInt + ", " + quoteDate(paramDate) + ");");
/*      */       }
/*  396 */       Value value = (Value)((paramDate == null) ? ValueNull.INSTANCE : ValueDate.get(paramDate));
/*  397 */       setParameter(paramInt, value);
/*  398 */     } catch (Exception exception) {
/*  399 */       throw logAndConvert(exception);
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
/*      */   public void setTime(int paramInt, Time paramTime) throws SQLException {
/*      */     try {
/*  414 */       if (isDebugEnabled()) {
/*  415 */         debugCode("setTime(" + paramInt + ", " + quoteTime(paramTime) + ");");
/*      */       }
/*  417 */       Value value = (Value)((paramTime == null) ? ValueNull.INSTANCE : ValueTime.get(paramTime));
/*  418 */       setParameter(paramInt, value);
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
/*      */   public void setTimestamp(int paramInt, Timestamp paramTimestamp) throws SQLException {
/*      */     try {
/*  435 */       if (isDebugEnabled()) {
/*  436 */         debugCode("setTimestamp(" + paramInt + ", " + quoteTimestamp(paramTimestamp) + ");");
/*      */       }
/*  438 */       Value value = (Value)((paramTimestamp == null) ? ValueNull.INSTANCE : ValueTimestamp.get(paramTimestamp));
/*  439 */       setParameter(paramInt, value);
/*  440 */     } catch (Exception exception) {
/*  441 */       throw logAndConvert(exception);
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
/*      */   public void setObject(int paramInt, Object paramObject) throws SQLException {
/*      */     try {
/*  456 */       if (isDebugEnabled()) {
/*  457 */         debugCode("setObject(" + paramInt + ", x);");
/*      */       }
/*  459 */       if (paramObject == null) {
/*      */         
/*  461 */         setParameter(paramInt, (Value)ValueNull.INSTANCE);
/*      */       } else {
/*  463 */         setParameter(paramInt, DataType.convertToValue(this.session, paramObject, -1));
/*      */       }
/*      */     
/*  466 */     } catch (Exception exception) {
/*  467 */       throw logAndConvert(exception);
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
/*      */   public void setObject(int paramInt1, Object paramObject, int paramInt2) throws SQLException {
/*      */     try {
/*  485 */       if (isDebugEnabled()) {
/*  486 */         debugCode("setObject(" + paramInt1 + ", x, " + paramInt2 + ");");
/*      */       }
/*  488 */       int i = DataType.convertSQLTypeToValueType(paramInt2);
/*  489 */       if (paramObject == null) {
/*  490 */         setParameter(paramInt1, (Value)ValueNull.INSTANCE);
/*      */       } else {
/*  492 */         Value value = DataType.convertToValue(this.conn.getSession(), paramObject, i);
/*  493 */         setParameter(paramInt1, value.convertTo(i));
/*      */       } 
/*  495 */     } catch (Exception exception) {
/*  496 */       throw logAndConvert(exception);
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
/*      */   public void setObject(int paramInt1, Object paramObject, int paramInt2, int paramInt3) throws SQLException {
/*      */     try {
/*  515 */       if (isDebugEnabled()) {
/*  516 */         debugCode("setObject(" + paramInt1 + ", x, " + paramInt2 + ", " + paramInt3 + ");");
/*      */       }
/*  518 */       setObject(paramInt1, paramObject, paramInt2);
/*  519 */     } catch (Exception exception) {
/*  520 */       throw logAndConvert(exception);
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
/*      */   public void setBoolean(int paramInt, boolean paramBoolean) throws SQLException {
/*      */     try {
/*  534 */       if (isDebugEnabled()) {
/*  535 */         debugCode("setBoolean(" + paramInt + ", " + paramBoolean + ");");
/*      */       }
/*  537 */       setParameter(paramInt, (Value)ValueBoolean.get(paramBoolean));
/*  538 */     } catch (Exception exception) {
/*  539 */       throw logAndConvert(exception);
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
/*      */   public void setByte(int paramInt, byte paramByte) throws SQLException {
/*      */     try {
/*  553 */       if (isDebugEnabled()) {
/*  554 */         debugCode("setByte(" + paramInt + ", " + paramByte + ");");
/*      */       }
/*  556 */       setParameter(paramInt, (Value)ValueByte.get(paramByte));
/*  557 */     } catch (Exception exception) {
/*  558 */       throw logAndConvert(exception);
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
/*      */   public void setShort(int paramInt, short paramShort) throws SQLException {
/*      */     try {
/*  572 */       if (isDebugEnabled()) {
/*  573 */         debugCode("setShort(" + paramInt + ", (short) " + paramShort + ");");
/*      */       }
/*  575 */       setParameter(paramInt, (Value)ValueShort.get(paramShort));
/*  576 */     } catch (Exception exception) {
/*  577 */       throw logAndConvert(exception);
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
/*      */   public void setLong(int paramInt, long paramLong) throws SQLException {
/*      */     try {
/*  591 */       if (isDebugEnabled()) {
/*  592 */         debugCode("setLong(" + paramInt + ", " + paramLong + "L);");
/*      */       }
/*  594 */       setParameter(paramInt, (Value)ValueLong.get(paramLong));
/*  595 */     } catch (Exception exception) {
/*  596 */       throw logAndConvert(exception);
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
/*      */   public void setFloat(int paramInt, float paramFloat) throws SQLException {
/*      */     try {
/*  610 */       if (isDebugEnabled()) {
/*  611 */         debugCode("setFloat(" + paramInt + ", " + paramFloat + "f);");
/*      */       }
/*  613 */       setParameter(paramInt, (Value)ValueFloat.get(paramFloat));
/*  614 */     } catch (Exception exception) {
/*  615 */       throw logAndConvert(exception);
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
/*      */   public void setDouble(int paramInt, double paramDouble) throws SQLException {
/*      */     try {
/*  629 */       if (isDebugEnabled()) {
/*  630 */         debugCode("setDouble(" + paramInt + ", " + paramDouble + "d);");
/*      */       }
/*  632 */       setParameter(paramInt, (Value)ValueDouble.get(paramDouble));
/*  633 */     } catch (Exception exception) {
/*  634 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRef(int paramInt, Ref paramRef) throws SQLException {
/*  643 */     throw unsupported("ref");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDate(int paramInt, Date paramDate, Calendar paramCalendar) throws SQLException {
/*      */     try {
/*  659 */       if (isDebugEnabled()) {
/*  660 */         debugCode("setDate(" + paramInt + ", " + quoteDate(paramDate) + ", calendar);");
/*      */       }
/*  662 */       if (paramDate == null) {
/*  663 */         setParameter(paramInt, (Value)ValueNull.INSTANCE);
/*      */       } else {
/*  665 */         setParameter(paramInt, (Value)DateTimeUtils.convertDate(paramDate, paramCalendar));
/*      */       } 
/*  667 */     } catch (Exception exception) {
/*  668 */       throw logAndConvert(exception);
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
/*      */   public void setTime(int paramInt, Time paramTime, Calendar paramCalendar) throws SQLException {
/*      */     try {
/*  685 */       if (isDebugEnabled()) {
/*  686 */         debugCode("setTime(" + paramInt + ", " + quoteTime(paramTime) + ", calendar);");
/*      */       }
/*  688 */       if (paramTime == null) {
/*  689 */         setParameter(paramInt, (Value)ValueNull.INSTANCE);
/*      */       } else {
/*  691 */         setParameter(paramInt, (Value)DateTimeUtils.convertTime(paramTime, paramCalendar));
/*      */       } 
/*  693 */     } catch (Exception exception) {
/*  694 */       throw logAndConvert(exception);
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
/*      */   public void setTimestamp(int paramInt, Timestamp paramTimestamp, Calendar paramCalendar) throws SQLException {
/*      */     try {
/*  711 */       if (isDebugEnabled()) {
/*  712 */         debugCode("setTimestamp(" + paramInt + ", " + quoteTimestamp(paramTimestamp) + ", calendar);");
/*      */       }
/*      */       
/*  715 */       if (paramTimestamp == null) {
/*  716 */         setParameter(paramInt, (Value)ValueNull.INSTANCE);
/*      */       } else {
/*  718 */         setParameter(paramInt, (Value)DateTimeUtils.convertTimestamp(paramTimestamp, paramCalendar));
/*      */       } 
/*  720 */     } catch (Exception exception) {
/*  721 */       throw logAndConvert(exception);
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
/*      */   @Deprecated
/*      */   public void setUnicodeStream(int paramInt1, InputStream paramInputStream, int paramInt2) throws SQLException {
/*  734 */     throw unsupported("unicodeStream");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNull(int paramInt1, int paramInt2, String paramString) throws SQLException {
/*      */     try {
/*  749 */       if (isDebugEnabled()) {
/*  750 */         debugCode("setNull(" + paramInt1 + ", " + paramInt2 + ", " + quote(paramString) + ");");
/*      */       }
/*  752 */       setNull(paramInt1, paramInt2);
/*  753 */     } catch (Exception exception) {
/*  754 */       throw logAndConvert(exception);
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
/*      */   public void setBlob(int paramInt, Blob paramBlob) throws SQLException {
/*      */     try {
/*  768 */       if (isDebugEnabled()) {
/*  769 */         debugCode("setBlob(" + paramInt + ", x);");
/*      */       }
/*  771 */       checkClosedForWrite();
/*      */       try {
/*      */         Value value;
/*  774 */         if (paramBlob == null) {
/*  775 */           ValueNull valueNull = ValueNull.INSTANCE;
/*      */         } else {
/*  777 */           value = this.conn.createBlob(paramBlob.getBinaryStream(), -1L);
/*      */         } 
/*  779 */         setParameter(paramInt, value);
/*      */       } finally {
/*  781 */         afterWriting();
/*      */       } 
/*  783 */     } catch (Exception exception) {
/*  784 */       throw logAndConvert(exception);
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
/*      */   public void setBlob(int paramInt, InputStream paramInputStream) throws SQLException {
/*      */     try {
/*  800 */       if (isDebugEnabled()) {
/*  801 */         debugCode("setBlob(" + paramInt + ", x);");
/*      */       }
/*  803 */       checkClosedForWrite();
/*      */       try {
/*  805 */         Value value = this.conn.createBlob(paramInputStream, -1L);
/*  806 */         setParameter(paramInt, value);
/*      */       } finally {
/*  808 */         afterWriting();
/*      */       } 
/*  810 */     } catch (Exception exception) {
/*  811 */       throw logAndConvert(exception);
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
/*      */   public void setClob(int paramInt, Clob paramClob) throws SQLException {
/*      */     try {
/*  825 */       if (isDebugEnabled()) {
/*  826 */         debugCode("setClob(" + paramInt + ", x);");
/*      */       }
/*  828 */       checkClosedForWrite();
/*      */       try {
/*      */         Value value;
/*  831 */         if (paramClob == null) {
/*  832 */           ValueNull valueNull = ValueNull.INSTANCE;
/*      */         } else {
/*  834 */           value = this.conn.createClob(paramClob.getCharacterStream(), -1L);
/*      */         } 
/*  836 */         setParameter(paramInt, value);
/*      */       } finally {
/*  838 */         afterWriting();
/*      */       } 
/*  840 */     } catch (Exception exception) {
/*  841 */       throw logAndConvert(exception);
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
/*      */   public void setClob(int paramInt, Reader paramReader) throws SQLException {
/*      */     try {
/*  857 */       if (isDebugEnabled()) {
/*  858 */         debugCode("setClob(" + paramInt + ", x);");
/*      */       }
/*  860 */       checkClosedForWrite();
/*      */       try {
/*      */         Value value;
/*  863 */         if (paramReader == null) {
/*  864 */           ValueNull valueNull = ValueNull.INSTANCE;
/*      */         } else {
/*  866 */           value = this.conn.createClob(paramReader, -1L);
/*      */         } 
/*  868 */         setParameter(paramInt, value);
/*      */       } finally {
/*  870 */         afterWriting();
/*      */       } 
/*  872 */     } catch (Exception exception) {
/*  873 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setArray(int paramInt, Array paramArray) throws SQLException {
/*  882 */     throw unsupported("setArray");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBytes(int paramInt, byte[] paramArrayOfbyte) throws SQLException {
/*      */     try {
/*  895 */       if (isDebugEnabled()) {
/*  896 */         debugCode("setBytes(" + paramInt + ", " + quoteBytes(paramArrayOfbyte) + ");");
/*      */       }
/*  898 */       Value value = (Value)((paramArrayOfbyte == null) ? ValueNull.INSTANCE : ValueBytes.get(paramArrayOfbyte));
/*  899 */       setParameter(paramInt, value);
/*  900 */     } catch (Exception exception) {
/*  901 */       throw logAndConvert(exception);
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
/*      */   public void setBinaryStream(int paramInt, InputStream paramInputStream, long paramLong) throws SQLException {
/*      */     try {
/*  919 */       if (isDebugEnabled()) {
/*  920 */         debugCode("setBinaryStream(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/*  922 */       checkClosedForWrite();
/*      */       try {
/*  924 */         Value value = this.conn.createBlob(paramInputStream, paramLong);
/*  925 */         setParameter(paramInt, value);
/*      */       } finally {
/*  927 */         afterWriting();
/*      */       } 
/*  929 */     } catch (Exception exception) {
/*  930 */       throw logAndConvert(exception);
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
/*      */   public void setBinaryStream(int paramInt1, InputStream paramInputStream, int paramInt2) throws SQLException {
/*  947 */     setBinaryStream(paramInt1, paramInputStream, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBinaryStream(int paramInt, InputStream paramInputStream) throws SQLException {
/*  962 */     setBinaryStream(paramInt, paramInputStream, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAsciiStream(int paramInt1, InputStream paramInputStream, int paramInt2) throws SQLException {
/*  978 */     setAsciiStream(paramInt1, paramInputStream, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAsciiStream(int paramInt, InputStream paramInputStream, long paramLong) throws SQLException {
/*      */     try {
/*  995 */       if (isDebugEnabled()) {
/*  996 */         debugCode("setAsciiStream(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/*  998 */       checkClosedForWrite();
/*      */       try {
/* 1000 */         Value value = this.conn.createClob(IOUtils.getAsciiReader(paramInputStream), paramLong);
/* 1001 */         setParameter(paramInt, value);
/*      */       } finally {
/* 1003 */         afterWriting();
/*      */       } 
/* 1005 */     } catch (Exception exception) {
/* 1006 */       throw logAndConvert(exception);
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
/*      */   public void setAsciiStream(int paramInt, InputStream paramInputStream) throws SQLException {
/* 1022 */     setAsciiStream(paramInt, paramInputStream, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCharacterStream(int paramInt1, Reader paramReader, int paramInt2) throws SQLException {
/* 1038 */     setCharacterStream(paramInt1, paramReader, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCharacterStream(int paramInt, Reader paramReader) throws SQLException {
/* 1053 */     setCharacterStream(paramInt, paramReader, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCharacterStream(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/*      */     try {
/* 1070 */       if (isDebugEnabled()) {
/* 1071 */         debugCode("setCharacterStream(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/* 1073 */       checkClosedForWrite();
/*      */       try {
/* 1075 */         Value value = this.conn.createClob(paramReader, paramLong);
/* 1076 */         setParameter(paramInt, value);
/*      */       } finally {
/* 1078 */         afterWriting();
/*      */       } 
/* 1080 */     } catch (Exception exception) {
/* 1081 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setURL(int paramInt, URL paramURL) throws SQLException {
/* 1090 */     throw unsupported("url");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSetMetaData getMetaData() throws SQLException {
/*      */     try {
/* 1103 */       debugCodeCall("getMetaData");
/* 1104 */       checkClosed();
/* 1105 */       ResultInterface resultInterface = this.command.getMetaData();
/* 1106 */       if (resultInterface == null) {
/* 1107 */         return null;
/*      */       }
/* 1109 */       int i = getNextId(5);
/* 1110 */       if (isDebugEnabled()) {
/* 1111 */         debugCodeAssign("ResultSetMetaData", 5, i, "getMetaData()");
/*      */       }
/*      */       
/* 1114 */       String str = this.conn.getCatalog();
/* 1115 */       return new JdbcResultSetMetaData(null, this, resultInterface, str, this.session.getTrace(), i);
/*      */     
/*      */     }
/* 1118 */     catch (Exception exception) {
/* 1119 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearBatch() throws SQLException {
/*      */     try {
/* 1129 */       debugCodeCall("clearBatch");
/* 1130 */       checkClosed();
/* 1131 */       this.batchParameters = null;
/* 1132 */     } catch (Exception exception) {
/* 1133 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close() throws SQLException {
/*      */     try {
/* 1145 */       super.close();
/* 1146 */       this.batchParameters = null;
/* 1147 */       if (this.command != null) {
/* 1148 */         this.command.close();
/* 1149 */         this.command = null;
/*      */       } 
/* 1151 */     } catch (Exception exception) {
/* 1152 */       throw logAndConvert(exception);
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
/*      */   public int[] executeBatch() throws SQLException {
/*      */     try {
/* 1165 */       int i = getNextId(3);
/* 1166 */       debugCodeCall("executeBatch");
/* 1167 */       if (this.batchParameters == null)
/*      */       {
/*      */         
/* 1170 */         this.batchParameters = New.arrayList();
/*      */       }
/* 1172 */       this.batchIdentities = New.arrayList();
/* 1173 */       int j = this.batchParameters.size();
/* 1174 */       int[] arrayOfInt = new int[j];
/* 1175 */       boolean bool = false;
/* 1176 */       SQLException sQLException = null;
/* 1177 */       checkClosedForWrite();
/*      */       try {
/* 1179 */         for (byte b = 0; b < j; b++) {
/* 1180 */           Value[] arrayOfValue = this.batchParameters.get(b);
/* 1181 */           ArrayList<ParameterInterface> arrayList = this.command.getParameters();
/*      */           
/* 1183 */           for (byte b1 = 0; b1 < arrayOfValue.length; b1++) {
/* 1184 */             Value value = arrayOfValue[b1];
/* 1185 */             ParameterInterface parameterInterface = arrayList.get(b1);
/* 1186 */             parameterInterface.setValue(value, false);
/*      */           } 
/*      */           try {
/* 1189 */             arrayOfInt[b] = executeUpdateInternal();
/* 1190 */             ResultSet resultSet = this.conn.getGeneratedKeys(this, i);
/* 1191 */             while (resultSet.next()) {
/* 1192 */               this.batchIdentities.add(resultSet.getObject(1));
/*      */             }
/* 1194 */           } catch (Exception exception) {
/* 1195 */             SQLException sQLException1 = logAndConvert(exception);
/* 1196 */             if (sQLException == null) {
/* 1197 */               sQLException = sQLException1;
/*      */             } else {
/* 1199 */               sQLException1.setNextException(sQLException);
/* 1200 */               sQLException = sQLException1;
/*      */             } 
/* 1202 */             arrayOfInt[b] = -3;
/* 1203 */             bool = true;
/*      */           } 
/*      */         } 
/* 1206 */         this.batchParameters = null;
/* 1207 */         if (bool) {
/* 1208 */           JdbcBatchUpdateException jdbcBatchUpdateException = new JdbcBatchUpdateException(sQLException, arrayOfInt);
/* 1209 */           throw jdbcBatchUpdateException;
/*      */         } 
/* 1211 */         return arrayOfInt;
/*      */       } finally {
/* 1213 */         afterWriting();
/*      */       } 
/* 1215 */     } catch (Exception exception) {
/* 1216 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public ResultSet getGeneratedKeys() throws SQLException {
/* 1222 */     if (this.batchIdentities != null && !this.batchIdentities.isEmpty()) {
/* 1223 */       SimpleResultSet simpleResultSet = new SimpleResultSet();
/* 1224 */       simpleResultSet.addColumn("identity", 4, 10, 0);
/*      */       
/* 1226 */       for (Object object : this.batchIdentities) {
/* 1227 */         simpleResultSet.addRow(new Object[] { object });
/*      */       } 
/* 1229 */       return (ResultSet)simpleResultSet;
/*      */     } 
/* 1231 */     return super.getGeneratedKeys();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addBatch() throws SQLException {
/*      */     try {
/* 1240 */       debugCodeCall("addBatch");
/* 1241 */       checkClosedForWrite();
/*      */       try {
/* 1243 */         ArrayList<ParameterInterface> arrayList = this.command.getParameters();
/*      */         
/* 1245 */         int i = arrayList.size();
/* 1246 */         Value[] arrayOfValue = new Value[i];
/* 1247 */         for (byte b = 0; b < i; b++) {
/* 1248 */           ParameterInterface parameterInterface = arrayList.get(b);
/* 1249 */           Value value = parameterInterface.getParamValue();
/* 1250 */           arrayOfValue[b] = value;
/*      */         } 
/* 1252 */         if (this.batchParameters == null) {
/* 1253 */           this.batchParameters = New.arrayList();
/*      */         }
/* 1255 */         this.batchParameters.add(arrayOfValue);
/*      */       } finally {
/* 1257 */         afterWriting();
/*      */       } 
/* 1259 */     } catch (Exception exception) {
/* 1260 */       throw logAndConvert(exception);
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
/*      */   public int executeUpdate(String paramString, int paramInt) throws SQLException {
/*      */     try {
/* 1275 */       if (isDebugEnabled()) {
/* 1276 */         debugCode("executeUpdate(" + quote(paramString) + ", " + paramInt + ");");
/*      */       }
/* 1278 */       throw DbException.get(90130);
/* 1279 */     } catch (Exception exception) {
/* 1280 */       throw logAndConvert(exception);
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
/*      */   public int executeUpdate(String paramString, int[] paramArrayOfint) throws SQLException {
/*      */     try {
/* 1296 */       if (isDebugEnabled()) {
/* 1297 */         debugCode("executeUpdate(" + quote(paramString) + ", " + quoteIntArray(paramArrayOfint) + ");");
/*      */       }
/*      */       
/* 1300 */       throw DbException.get(90130);
/* 1301 */     } catch (Exception exception) {
/* 1302 */       throw logAndConvert(exception);
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
/*      */   public int executeUpdate(String paramString, String[] paramArrayOfString) throws SQLException {
/*      */     try {
/* 1317 */       if (isDebugEnabled()) {
/* 1318 */         debugCode("executeUpdate(" + quote(paramString) + ", " + quoteArray(paramArrayOfString) + ");");
/*      */       }
/*      */       
/* 1321 */       throw DbException.get(90130);
/*      */     }
/* 1323 */     catch (Exception exception) {
/* 1324 */       throw logAndConvert(exception);
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
/*      */   public boolean execute(String paramString, int paramInt) throws SQLException {
/*      */     try {
/* 1339 */       if (isDebugEnabled()) {
/* 1340 */         debugCode("execute(" + quote(paramString) + ", " + paramInt + ");");
/*      */       }
/* 1342 */       throw DbException.get(90130);
/*      */     }
/* 1344 */     catch (Exception exception) {
/* 1345 */       throw logAndConvert(exception);
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
/*      */   public boolean execute(String paramString, int[] paramArrayOfint) throws SQLException {
/*      */     try {
/* 1359 */       if (isDebugEnabled()) {
/* 1360 */         debugCode("execute(" + quote(paramString) + ", " + quoteIntArray(paramArrayOfint) + ");");
/*      */       }
/* 1362 */       throw DbException.get(90130);
/* 1363 */     } catch (Exception exception) {
/* 1364 */       throw logAndConvert(exception);
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
/*      */   public boolean execute(String paramString, String[] paramArrayOfString) throws SQLException {
/*      */     try {
/* 1379 */       if (isDebugEnabled()) {
/* 1380 */         debugCode("execute(" + quote(paramString) + ", " + quoteArray(paramArrayOfString) + ");");
/*      */       }
/* 1382 */       throw DbException.get(90130);
/*      */     }
/* 1384 */     catch (Exception exception) {
/* 1385 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ParameterMetaData getParameterMetaData() throws SQLException {
/*      */     try {
/* 1397 */       int i = getNextId(11);
/* 1398 */       if (isDebugEnabled()) {
/* 1399 */         debugCodeAssign("ParameterMetaData", 11, i, "getParameterMetaData()");
/*      */       }
/*      */       
/* 1402 */       checkClosed();
/* 1403 */       return new JdbcParameterMetaData(this.session.getTrace(), this, this.command, i);
/*      */     
/*      */     }
/* 1406 */     catch (Exception exception) {
/* 1407 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setParameter(int paramInt, Value paramValue) {
/* 1414 */     checkClosed();
/* 1415 */     paramInt--;
/* 1416 */     ArrayList<ParameterInterface> arrayList = this.command.getParameters();
/* 1417 */     if (paramInt < 0 || paramInt >= arrayList.size()) {
/* 1418 */       throw DbException.getInvalidValueException("parameterIndex", Integer.valueOf(paramInt + 1));
/*      */     }
/*      */     
/* 1421 */     ParameterInterface parameterInterface = arrayList.get(paramInt);
/*      */     
/* 1423 */     parameterInterface.setValue(paramValue, (this.batchParameters == null));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRowId(int paramInt, RowId paramRowId) throws SQLException {
/* 1431 */     throw unsupported("rowId");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNString(int paramInt, String paramString) throws SQLException {
/*      */     try {
/* 1444 */       if (isDebugEnabled()) {
/* 1445 */         debugCode("setNString(" + paramInt + ", " + quote(paramString) + ");");
/*      */       }
/* 1447 */       Value value = (Value)((paramString == null) ? ValueNull.INSTANCE : ValueString.get(paramString));
/* 1448 */       setParameter(paramInt, value);
/* 1449 */     } catch (Exception exception) {
/* 1450 */       throw logAndConvert(exception);
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
/*      */   public void setNCharacterStream(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/*      */     try {
/* 1468 */       if (isDebugEnabled()) {
/* 1469 */         debugCode("setNCharacterStream(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/*      */       
/* 1472 */       checkClosedForWrite();
/*      */       try {
/* 1474 */         Value value = this.conn.createClob(paramReader, paramLong);
/* 1475 */         setParameter(paramInt, value);
/*      */       } finally {
/* 1477 */         afterWriting();
/*      */       } 
/* 1479 */     } catch (Exception exception) {
/* 1480 */       throw logAndConvert(exception);
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
/*      */   public void setNCharacterStream(int paramInt, Reader paramReader) throws SQLException {
/* 1496 */     setNCharacterStream(paramInt, paramReader, -1L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNClob(int paramInt, NClob paramNClob) throws SQLException {
/*      */     try {
/*      */       Value value;
/* 1509 */       if (isDebugEnabled()) {
/* 1510 */         debugCode("setNClob(" + paramInt + ", x);");
/*      */       }
/* 1512 */       checkClosedForWrite();
/*      */       
/* 1514 */       if (paramNClob == null) {
/* 1515 */         ValueNull valueNull = ValueNull.INSTANCE;
/*      */       } else {
/* 1517 */         value = this.conn.createClob(paramNClob.getCharacterStream(), -1L);
/*      */       } 
/* 1519 */       setParameter(paramInt, value);
/* 1520 */     } catch (Exception exception) {
/* 1521 */       throw logAndConvert(exception);
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
/*      */   public void setNClob(int paramInt, Reader paramReader) throws SQLException {
/*      */     try {
/* 1537 */       if (isDebugEnabled()) {
/* 1538 */         debugCode("setNClob(" + paramInt + ", x);");
/*      */       }
/* 1540 */       checkClosedForWrite();
/*      */       try {
/* 1542 */         Value value = this.conn.createClob(paramReader, -1L);
/* 1543 */         setParameter(paramInt, value);
/*      */       } finally {
/* 1545 */         afterWriting();
/*      */       } 
/* 1547 */     } catch (Exception exception) {
/* 1548 */       throw logAndConvert(exception);
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
/*      */   public void setClob(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/*      */     try {
/* 1565 */       if (isDebugEnabled()) {
/* 1566 */         debugCode("setClob(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/* 1568 */       checkClosedForWrite();
/*      */       try {
/* 1570 */         Value value = this.conn.createClob(paramReader, paramLong);
/* 1571 */         setParameter(paramInt, value);
/*      */       } finally {
/* 1573 */         afterWriting();
/*      */       } 
/* 1575 */     } catch (Exception exception) {
/* 1576 */       throw logAndConvert(exception);
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
/*      */   public void setBlob(int paramInt, InputStream paramInputStream, long paramLong) throws SQLException {
/*      */     try {
/* 1594 */       if (isDebugEnabled()) {
/* 1595 */         debugCode("setBlob(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/* 1597 */       checkClosedForWrite();
/*      */       try {
/* 1599 */         Value value = this.conn.createBlob(paramInputStream, paramLong);
/* 1600 */         setParameter(paramInt, value);
/*      */       } finally {
/* 1602 */         afterWriting();
/*      */       } 
/* 1604 */     } catch (Exception exception) {
/* 1605 */       throw logAndConvert(exception);
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
/*      */   public void setNClob(int paramInt, Reader paramReader, long paramLong) throws SQLException {
/*      */     try {
/* 1623 */       if (isDebugEnabled()) {
/* 1624 */         debugCode("setNClob(" + paramInt + ", x, " + paramLong + "L);");
/*      */       }
/* 1626 */       checkClosedForWrite();
/*      */       try {
/* 1628 */         Value value = this.conn.createClob(paramReader, paramLong);
/* 1629 */         setParameter(paramInt, value);
/*      */       } finally {
/* 1631 */         afterWriting();
/*      */       } 
/* 1633 */     } catch (Exception exception) {
/* 1634 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSQLXML(int paramInt, SQLXML paramSQLXML) throws SQLException {
/* 1643 */     throw unsupported("SQLXML");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1651 */     return getTraceObjectName() + ": " + this.command;
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean checkClosed(boolean paramBoolean) {
/* 1656 */     if (super.checkClosed(paramBoolean)) {
/*      */       
/* 1658 */       ArrayList<ParameterInterface> arrayList1 = this.command.getParameters();
/* 1659 */       this.command = this.conn.prepareCommand(this.sqlStatement, this.fetchSize);
/* 1660 */       ArrayList<ParameterInterface> arrayList2 = this.command.getParameters(); byte b; int i;
/* 1661 */       for (b = 0, i = arrayList1.size(); b < i; b++) {
/* 1662 */         ParameterInterface parameterInterface = arrayList1.get(b);
/* 1663 */         Value value = parameterInterface.getParamValue();
/* 1664 */         if (value != null) {
/* 1665 */           ParameterInterface parameterInterface1 = arrayList2.get(b);
/* 1666 */           parameterInterface1.setValue(value, false);
/*      */         } 
/*      */       } 
/* 1669 */       return true;
/*      */     } 
/* 1671 */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcPreparedStatement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */