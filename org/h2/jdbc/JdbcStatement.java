/*      */ package org.h2.jdbc;
/*      */ 
/*      */ import java.sql.Connection;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.SQLWarning;
/*      */ import java.sql.Statement;
/*      */ import java.util.ArrayList;
/*      */ import org.h2.command.CommandInterface;
/*      */ import org.h2.engine.SessionInterface;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.message.TraceObject;
/*      */ import org.h2.result.ResultInterface;
/*      */ import org.h2.util.New;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JdbcStatement
/*      */   extends TraceObject
/*      */   implements Statement, JdbcStatementBackwardsCompat
/*      */ {
/*      */   protected JdbcConnection conn;
/*      */   protected SessionInterface session;
/*      */   protected JdbcResultSet resultSet;
/*      */   protected int maxRows;
/*   32 */   protected int fetchSize = SysProperties.SERVER_RESULT_SET_FETCH_SIZE;
/*      */   
/*      */   protected int updateCount;
/*      */   protected final int resultSetType;
/*      */   protected final int resultSetConcurrency;
/*      */   protected final boolean closedByResultSet;
/*      */   private CommandInterface executingCommand;
/*      */   private int lastExecutedCommandType;
/*      */   private ArrayList<String> batchCommands;
/*      */   private boolean escapeProcessing = true;
/*      */   private boolean cancelled;
/*      */   
/*      */   JdbcStatement(JdbcConnection paramJdbcConnection, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/*   45 */     this.conn = paramJdbcConnection;
/*   46 */     this.session = paramJdbcConnection.getSession();
/*   47 */     setTrace(this.session.getTrace(), 8, paramInt1);
/*   48 */     this.resultSetType = paramInt2;
/*   49 */     this.resultSetConcurrency = paramInt3;
/*   50 */     this.closedByResultSet = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
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
/*   64 */       int i = getNextId(4);
/*   65 */       if (isDebugEnabled()) {
/*   66 */         debugCodeAssign("ResultSet", 4, i, "executeQuery(" + quote(paramString) + ")");
/*      */       }
/*      */       
/*   69 */       synchronized (this.session) {
/*   70 */         ResultInterface resultInterface; checkClosed();
/*   71 */         closeOldResultSet();
/*   72 */         paramString = JdbcConnection.translateSQL(paramString, this.escapeProcessing);
/*   73 */         CommandInterface commandInterface = this.conn.prepareCommand(paramString, this.fetchSize);
/*      */         
/*   75 */         boolean bool1 = (this.resultSetType != 1003) ? true : false;
/*   76 */         boolean bool2 = (this.resultSetConcurrency == 1008) ? true : false;
/*   77 */         setExecutingStatement(commandInterface);
/*      */         try {
/*   79 */           resultInterface = commandInterface.executeQuery(this.maxRows, bool1);
/*      */         } finally {
/*   81 */           setExecutingStatement((CommandInterface)null);
/*      */         } 
/*   83 */         commandInterface.close();
/*   84 */         this.resultSet = new JdbcResultSet(this.conn, this, resultInterface, i, this.closedByResultSet, bool1, bool2);
/*      */       } 
/*      */       
/*   87 */       return this.resultSet;
/*   88 */     } catch (Exception exception) {
/*   89 */       throw logAndConvert(exception);
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
/*      */ 
/*      */   
/*      */   public int executeUpdate(String paramString) throws SQLException {
/*      */     try {
/*  114 */       debugCodeCall("executeUpdate", paramString);
/*  115 */       return executeUpdateInternal(paramString);
/*  116 */     } catch (Exception exception) {
/*  117 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   private int executeUpdateInternal(String paramString) throws SQLException {
/*  122 */     checkClosedForWrite();
/*      */     try {
/*  124 */       closeOldResultSet();
/*  125 */       paramString = JdbcConnection.translateSQL(paramString, this.escapeProcessing);
/*  126 */       CommandInterface commandInterface = this.conn.prepareCommand(paramString, this.fetchSize);
/*  127 */       synchronized (this.session) {
/*  128 */         setExecutingStatement(commandInterface);
/*      */         try {
/*  130 */           this.updateCount = commandInterface.executeUpdate();
/*      */         } finally {
/*  132 */           setExecutingStatement((CommandInterface)null);
/*      */         } 
/*      */       } 
/*  135 */       commandInterface.close();
/*  136 */       return this.updateCount;
/*      */     } finally {
/*  138 */       afterWriting();
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
/*      */   public boolean execute(String paramString) throws SQLException {
/*      */     try {
/*  157 */       debugCodeCall("execute", paramString);
/*  158 */       return executeInternal(paramString);
/*  159 */     } catch (Exception exception) {
/*  160 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean executeInternal(String paramString) throws SQLException {
/*  165 */     int i = getNextId(4);
/*  166 */     checkClosedForWrite(); try {
/*      */       boolean bool;
/*  168 */       closeOldResultSet();
/*  169 */       paramString = JdbcConnection.translateSQL(paramString, this.escapeProcessing);
/*  170 */       CommandInterface commandInterface = this.conn.prepareCommand(paramString, this.fetchSize);
/*      */       
/*  172 */       synchronized (this.session) {
/*  173 */         setExecutingStatement(commandInterface);
/*      */         try {
/*  175 */           if (commandInterface.isQuery()) {
/*  176 */             bool = true;
/*  177 */             boolean bool1 = (this.resultSetType != 1003) ? true : false;
/*  178 */             boolean bool2 = (this.resultSetConcurrency == 1008) ? true : false;
/*  179 */             ResultInterface resultInterface = commandInterface.executeQuery(this.maxRows, bool1);
/*  180 */             this.resultSet = new JdbcResultSet(this.conn, this, resultInterface, i, this.closedByResultSet, bool1, bool2);
/*      */           } else {
/*      */             
/*  183 */             bool = false;
/*  184 */             this.updateCount = commandInterface.executeUpdate();
/*      */           } 
/*      */         } finally {
/*  187 */           setExecutingStatement((CommandInterface)null);
/*      */         } 
/*      */       } 
/*  190 */       commandInterface.close();
/*  191 */       return bool;
/*      */     } finally {
/*  193 */       afterWriting();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getResultSet() throws SQLException {
/*      */     try {
/*  205 */       checkClosed();
/*  206 */       if (this.resultSet != null) {
/*  207 */         int i = this.resultSet.getTraceId();
/*  208 */         debugCodeAssign("ResultSet", 4, i, "getResultSet()");
/*      */       } else {
/*  210 */         debugCodeCall("getResultSet");
/*      */       } 
/*  212 */       return this.resultSet;
/*  213 */     } catch (Exception exception) {
/*  214 */       throw logAndConvert(exception);
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
/*      */   public int getUpdateCount() throws SQLException {
/*      */     try {
/*  229 */       debugCodeCall("getUpdateCount");
/*  230 */       checkClosed();
/*  231 */       return this.updateCount;
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
/*      */   public void close() throws SQLException {
/*      */     try {
/*  245 */       debugCodeCall("close");
/*  246 */       synchronized (this.session) {
/*  247 */         closeOldResultSet();
/*  248 */         if (this.conn != null) {
/*  249 */           this.conn = null;
/*      */         }
/*      */       } 
/*  252 */     } catch (Exception exception) {
/*  253 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Connection getConnection() {
/*  264 */     debugCodeCall("getConnection");
/*  265 */     return this.conn;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SQLWarning getWarnings() throws SQLException {
/*      */     try {
/*  277 */       debugCodeCall("getWarnings");
/*  278 */       checkClosed();
/*  279 */       return null;
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
/*      */   public void clearWarnings() throws SQLException {
/*      */     try {
/*  292 */       debugCodeCall("clearWarnings");
/*  293 */       checkClosed();
/*  294 */     } catch (Exception exception) {
/*  295 */       throw logAndConvert(exception);
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
/*      */   public void setCursorName(String paramString) throws SQLException {
/*      */     try {
/*  308 */       debugCodeCall("setCursorName", paramString);
/*  309 */       checkClosed();
/*  310 */     } catch (Exception exception) {
/*  311 */       throw logAndConvert(exception);
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
/*      */   public void setFetchDirection(int paramInt) throws SQLException {
/*      */     try {
/*  325 */       debugCodeCall("setFetchDirection", paramInt);
/*  326 */       checkClosed();
/*  327 */     } catch (Exception exception) {
/*  328 */       throw logAndConvert(exception);
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
/*      */   public int getFetchDirection() throws SQLException {
/*      */     try {
/*  341 */       debugCodeCall("getFetchDirection");
/*  342 */       checkClosed();
/*  343 */       return 1000;
/*  344 */     } catch (Exception exception) {
/*  345 */       throw logAndConvert(exception);
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
/*      */   public int getMaxRows() throws SQLException {
/*      */     try {
/*  358 */       debugCodeCall("getMaxRows");
/*  359 */       checkClosed();
/*  360 */       return this.maxRows;
/*  361 */     } catch (Exception exception) {
/*  362 */       throw logAndConvert(exception);
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
/*      */   public void setMaxRows(int paramInt) throws SQLException {
/*      */     try {
/*  375 */       debugCodeCall("setMaxRows", paramInt);
/*  376 */       checkClosed();
/*  377 */       if (paramInt < 0) {
/*  378 */         throw DbException.getInvalidValueException("maxRows", Integer.valueOf(paramInt));
/*      */       }
/*  380 */       this.maxRows = paramInt;
/*  381 */     } catch (Exception exception) {
/*  382 */       throw logAndConvert(exception);
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
/*      */   public void setFetchSize(int paramInt) throws SQLException {
/*      */     try {
/*  400 */       debugCodeCall("setFetchSize", paramInt);
/*  401 */       checkClosed();
/*  402 */       if (paramInt < 0 || (paramInt > 0 && this.maxRows > 0 && paramInt > this.maxRows)) {
/*  403 */         throw DbException.getInvalidValueException("rows", Integer.valueOf(paramInt));
/*      */       }
/*  405 */       if (paramInt == 0) {
/*  406 */         paramInt = SysProperties.SERVER_RESULT_SET_FETCH_SIZE;
/*      */       }
/*  408 */       this.fetchSize = paramInt;
/*  409 */     } catch (Exception exception) {
/*  410 */       throw logAndConvert(exception);
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
/*      */   public int getFetchSize() throws SQLException {
/*      */     try {
/*  423 */       debugCodeCall("getFetchSize");
/*  424 */       checkClosed();
/*  425 */       return this.fetchSize;
/*  426 */     } catch (Exception exception) {
/*  427 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getResultSetConcurrency() throws SQLException {
/*      */     try {
/*  439 */       debugCodeCall("getResultSetConcurrency");
/*  440 */       checkClosed();
/*  441 */       return this.resultSetConcurrency;
/*  442 */     } catch (Exception exception) {
/*  443 */       throw logAndConvert(exception);
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
/*      */   public int getResultSetType() throws SQLException {
/*      */     try {
/*  456 */       debugCodeCall("getResultSetType");
/*  457 */       checkClosed();
/*  458 */       return this.resultSetType;
/*  459 */     } catch (Exception exception) {
/*  460 */       throw logAndConvert(exception);
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
/*      */   public int getMaxFieldSize() throws SQLException {
/*      */     try {
/*  473 */       debugCodeCall("getMaxFieldSize");
/*  474 */       checkClosed();
/*  475 */       return 0;
/*  476 */     } catch (Exception exception) {
/*  477 */       throw logAndConvert(exception);
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
/*      */   public void setMaxFieldSize(int paramInt) throws SQLException {
/*      */     try {
/*  491 */       debugCodeCall("setMaxFieldSize", paramInt);
/*  492 */       checkClosed();
/*  493 */     } catch (Exception exception) {
/*  494 */       throw logAndConvert(exception);
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
/*      */   public void setEscapeProcessing(boolean paramBoolean) throws SQLException {
/*      */     try {
/*  508 */       if (isDebugEnabled()) {
/*  509 */         debugCode("setEscapeProcessing(" + paramBoolean + ");");
/*      */       }
/*  511 */       checkClosed();
/*  512 */       this.escapeProcessing = paramBoolean;
/*  513 */     } catch (Exception exception) {
/*  514 */       throw logAndConvert(exception);
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
/*      */   public void cancel() throws SQLException {
/*      */     try {
/*  530 */       debugCodeCall("cancel");
/*  531 */       checkClosed();
/*      */       
/*  533 */       CommandInterface commandInterface = this.executingCommand;
/*      */       try {
/*  535 */         if (commandInterface != null) {
/*  536 */           commandInterface.cancel();
/*  537 */           this.cancelled = true;
/*      */         } 
/*      */       } finally {
/*  540 */         setExecutingStatement((CommandInterface)null);
/*      */       } 
/*  542 */     } catch (Exception exception) {
/*  543 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean wasCancelled() {
/*  553 */     return this.cancelled;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getQueryTimeout() throws SQLException {
/*      */     try {
/*  571 */       debugCodeCall("getQueryTimeout");
/*  572 */       checkClosed();
/*  573 */       return this.conn.getQueryTimeout();
/*  574 */     } catch (Exception exception) {
/*  575 */       throw logAndConvert(exception);
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
/*      */   public void setQueryTimeout(int paramInt) throws SQLException {
/*      */     try {
/*  592 */       debugCodeCall("setQueryTimeout", paramInt);
/*  593 */       checkClosed();
/*  594 */       if (paramInt < 0) {
/*  595 */         throw DbException.getInvalidValueException("seconds", Integer.valueOf(paramInt));
/*      */       }
/*  597 */       this.conn.setQueryTimeout(paramInt);
/*  598 */     } catch (Exception exception) {
/*  599 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addBatch(String paramString) throws SQLException {
/*      */     try {
/*  611 */       debugCodeCall("addBatch", paramString);
/*  612 */       checkClosed();
/*  613 */       paramString = JdbcConnection.translateSQL(paramString, this.escapeProcessing);
/*  614 */       if (this.batchCommands == null) {
/*  615 */         this.batchCommands = New.arrayList();
/*      */       }
/*  617 */       this.batchCommands.add(paramString);
/*  618 */     } catch (Exception exception) {
/*  619 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearBatch() throws SQLException {
/*      */     try {
/*  629 */       debugCodeCall("clearBatch");
/*  630 */       checkClosed();
/*  631 */       this.batchCommands = null;
/*  632 */     } catch (Exception exception) {
/*  633 */       throw logAndConvert(exception);
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
/*  646 */       debugCodeCall("executeBatch");
/*  647 */       checkClosedForWrite();
/*      */       try {
/*  649 */         if (this.batchCommands == null)
/*      */         {
/*      */           
/*  652 */           this.batchCommands = New.arrayList();
/*      */         }
/*  654 */         int i = this.batchCommands.size();
/*  655 */         int[] arrayOfInt = new int[i];
/*  656 */         boolean bool = false;
/*  657 */         SQLException sQLException = null;
/*  658 */         for (byte b = 0; b < i; b++) {
/*  659 */           String str = this.batchCommands.get(b);
/*      */           try {
/*  661 */             arrayOfInt[b] = executeUpdateInternal(str);
/*  662 */           } catch (Exception exception) {
/*  663 */             SQLException sQLException1 = logAndConvert(exception);
/*  664 */             if (sQLException == null) {
/*  665 */               sQLException = sQLException1;
/*      */             } else {
/*  667 */               sQLException1.setNextException(sQLException);
/*  668 */               sQLException = sQLException1;
/*      */             } 
/*  670 */             arrayOfInt[b] = -3;
/*  671 */             bool = true;
/*      */           } 
/*      */         } 
/*  674 */         this.batchCommands = null;
/*  675 */         if (bool) {
/*  676 */           throw new JdbcBatchUpdateException(sQLException, arrayOfInt);
/*      */         }
/*  678 */         return arrayOfInt;
/*      */       } finally {
/*  680 */         afterWriting();
/*      */       } 
/*  682 */     } catch (Exception exception) {
/*  683 */       throw logAndConvert(exception);
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
/*      */   public ResultSet getGeneratedKeys() throws SQLException {
/*      */     try {
/*  699 */       int i = getNextId(4);
/*  700 */       if (isDebugEnabled()) {
/*  701 */         debugCodeAssign("ResultSet", 4, i, "getGeneratedKeys()");
/*      */       }
/*  703 */       checkClosed();
/*  704 */       return this.conn.getGeneratedKeys(this, i);
/*  705 */     } catch (Exception exception) {
/*  706 */       throw logAndConvert(exception);
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
/*      */   public boolean getMoreResults() throws SQLException {
/*      */     try {
/*  722 */       debugCodeCall("getMoreResults");
/*  723 */       checkClosed();
/*  724 */       closeOldResultSet();
/*  725 */       return false;
/*  726 */     } catch (Exception exception) {
/*  727 */       throw logAndConvert(exception);
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
/*      */   public boolean getMoreResults(int paramInt) throws SQLException {
/*      */     try {
/*  743 */       debugCodeCall("getMoreResults", paramInt);
/*  744 */       switch (paramInt)
/*      */       { case 1:
/*      */         case 3:
/*  747 */           checkClosed();
/*  748 */           closeOldResultSet();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 2:
/*  756 */           return false; }  throw DbException.getInvalidValueException("current", Integer.valueOf(paramInt));
/*  757 */     } catch (Exception exception) {
/*  758 */       throw logAndConvert(exception);
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
/*      */   public int executeUpdate(String paramString, int paramInt) throws SQLException {
/*      */     try {
/*  779 */       if (isDebugEnabled()) {
/*  780 */         debugCode("executeUpdate(" + quote(paramString) + ", " + paramInt + ");");
/*      */       }
/*  782 */       return executeUpdateInternal(paramString);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int executeUpdate(String paramString, int[] paramArrayOfint) throws SQLException {
/*      */     try {
/*  804 */       if (isDebugEnabled()) {
/*  805 */         debugCode("executeUpdate(" + quote(paramString) + ", " + quoteIntArray(paramArrayOfint) + ");");
/*      */       }
/*  807 */       return executeUpdateInternal(paramString);
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
/*  829 */       if (isDebugEnabled()) {
/*  830 */         debugCode("executeUpdate(" + quote(paramString) + ", " + quoteArray(paramArrayOfString) + ");");
/*      */       }
/*  832 */       return executeUpdateInternal(paramString);
/*  833 */     } catch (Exception exception) {
/*  834 */       throw logAndConvert(exception);
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
/*      */   public boolean execute(String paramString, int paramInt) throws SQLException {
/*      */     try {
/*  854 */       if (isDebugEnabled()) {
/*  855 */         debugCode("execute(" + quote(paramString) + ", " + paramInt + ");");
/*      */       }
/*  857 */       return executeInternal(paramString);
/*  858 */     } catch (Exception exception) {
/*  859 */       throw logAndConvert(exception);
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
/*      */   public boolean execute(String paramString, int[] paramArrayOfint) throws SQLException {
/*      */     try {
/*  879 */       if (isDebugEnabled()) {
/*  880 */         debugCode("execute(" + quote(paramString) + ", " + quoteIntArray(paramArrayOfint) + ");");
/*      */       }
/*  882 */       return executeInternal(paramString);
/*  883 */     } catch (Exception exception) {
/*  884 */       throw logAndConvert(exception);
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
/*      */   public boolean execute(String paramString, String[] paramArrayOfString) throws SQLException {
/*      */     try {
/*  904 */       if (isDebugEnabled()) {
/*  905 */         debugCode("execute(" + quote(paramString) + ", " + quoteArray(paramArrayOfString) + ");");
/*      */       }
/*  907 */       return executeInternal(paramString);
/*  908 */     } catch (Exception exception) {
/*  909 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getResultSetHoldability() throws SQLException {
/*      */     try {
/*  921 */       debugCodeCall("getResultSetHoldability");
/*  922 */       checkClosed();
/*  923 */       return 1;
/*  924 */     } catch (Exception exception) {
/*  925 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void closeOnCompletion() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isCloseOnCompletion() {
/*  942 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean checkClosed() {
/*  955 */     return checkClosed(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean checkClosedForWrite() {
/*  966 */     return checkClosed(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean checkClosed(boolean paramBoolean) {
/*  978 */     if (this.conn == null) {
/*  979 */       throw DbException.get(90007);
/*      */     }
/*  981 */     this.conn.checkClosed(paramBoolean);
/*  982 */     SessionInterface sessionInterface = this.conn.getSession();
/*  983 */     if (sessionInterface != this.session) {
/*  984 */       this.session = sessionInterface;
/*  985 */       this.trace = this.session.getTrace();
/*  986 */       return true;
/*      */     } 
/*  988 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void afterWriting() {
/*  995 */     if (this.conn != null) {
/*  996 */       this.conn.afterWriting();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void closeOldResultSet() throws SQLException {
/*      */     try {
/* 1006 */       if (!this.closedByResultSet && 
/* 1007 */         this.resultSet != null) {
/* 1008 */         this.resultSet.closeInternal();
/*      */       }
/*      */     } finally {
/*      */       
/* 1012 */       this.cancelled = false;
/* 1013 */       this.resultSet = null;
/* 1014 */       this.updateCount = -1;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setExecutingStatement(CommandInterface paramCommandInterface) {
/* 1025 */     if (paramCommandInterface == null) {
/* 1026 */       this.conn.setExecutingStatement(null);
/*      */     } else {
/* 1028 */       this.conn.setExecutingStatement(this);
/* 1029 */       this.lastExecutedCommandType = paramCommandInterface.getCommandType();
/*      */     } 
/* 1031 */     this.executingCommand = paramCommandInterface;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLastExecutedCommandType() {
/* 1039 */     return this.lastExecutedCommandType;
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
/* 1050 */       debugCodeCall("isClosed");
/* 1051 */       return (this.conn == null);
/* 1052 */     } catch (Exception exception) {
/* 1053 */       throw logAndConvert(exception);
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
/* 1066 */     if (isWrapperFor(paramClass)) {
/* 1067 */       return (T)this;
/*      */     }
/* 1069 */     throw DbException.getInvalidValueException("iface", paramClass);
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
/* 1080 */     return (paramClass != null && paramClass.isAssignableFrom(getClass()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPoolable() {
/* 1089 */     debugCodeCall("isPoolable");
/* 1090 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPoolable(boolean paramBoolean) {
/* 1101 */     if (isDebugEnabled()) {
/* 1102 */       debugCode("setPoolable(" + paramBoolean + ");");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1111 */     return getTraceObjectName();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcStatement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */