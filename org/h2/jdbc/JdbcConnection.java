/*      */ package org.h2.jdbc;
/*      */ 
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.Closeable;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.Reader;
/*      */ import java.sql.Array;
/*      */ import java.sql.Blob;
/*      */ import java.sql.CallableStatement;
/*      */ import java.sql.Clob;
/*      */ import java.sql.Connection;
/*      */ import java.sql.DatabaseMetaData;
/*      */ import java.sql.NClob;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLClientInfoException;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.SQLWarning;
/*      */ import java.sql.SQLXML;
/*      */ import java.sql.Savepoint;
/*      */ import java.sql.Statement;
/*      */ import java.sql.Struct;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
/*      */ import java.util.concurrent.Executor;
/*      */ import java.util.regex.Pattern;
/*      */ import org.h2.command.CommandInterface;
/*      */ import org.h2.engine.ConnectionInfo;
/*      */ import org.h2.engine.Mode;
/*      */ import org.h2.engine.SessionInterface;
/*      */ import org.h2.engine.SessionRemote;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.expression.ParameterInterface;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.message.TraceObject;
/*      */ import org.h2.result.ResultInterface;
/*      */ import org.h2.util.CloseWatcher;
/*      */ import org.h2.util.JdbcUtils;
/*      */ import org.h2.util.Utils;
/*      */ import org.h2.value.CompareMode;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueInt;
/*      */ import org.h2.value.ValueNull;
/*      */ import org.h2.value.ValueString;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JdbcConnection
/*      */   extends TraceObject
/*      */   implements Connection, JdbcConnectionBackwardsCompat
/*      */ {
/*      */   private static final String NUM_SERVERS = "numServers";
/*      */   private static final String PREFIX_SERVER = "server";
/*      */   private static boolean keepOpenStackTrace;
/*      */   private final String url;
/*      */   private final String user;
/*   78 */   private int holdability = 1; private SessionInterface session; private CommandInterface commit;
/*      */   private CommandInterface rollback;
/*      */   private CommandInterface getReadOnly;
/*      */   private CommandInterface getGeneratedKeys;
/*      */   private CommandInterface setLockMode;
/*      */   private CommandInterface getLockMode;
/*      */   private CommandInterface setQueryTimeout;
/*      */   private CommandInterface getQueryTimeout;
/*      */   private int savepointId;
/*      */   private String catalog;
/*      */   private Statement executingStatement;
/*      */   private final CloseWatcher watcher;
/*   90 */   private int queryTimeoutCache = -1;
/*      */ 
/*      */   
/*      */   private Map<String, String> clientInfo;
/*      */   
/*      */   private String mode;
/*      */ 
/*      */   
/*      */   public JdbcConnection(String paramString, Properties paramProperties) throws SQLException {
/*   99 */     this(new ConnectionInfo(paramString, paramProperties), true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JdbcConnection(ConnectionInfo paramConnectionInfo, boolean paramBoolean) throws SQLException {
/*      */     try {
/*  108 */       if (paramBoolean) {
/*  109 */         String str = SysProperties.getBaseDir();
/*  110 */         if (str != null) {
/*  111 */           paramConnectionInfo.setBaseDir(str);
/*      */         }
/*      */       } 
/*      */       
/*  115 */       this.session = (new SessionRemote(paramConnectionInfo)).connectEmbeddedOrServer(false);
/*  116 */       this.trace = this.session.getTrace();
/*  117 */       int i = getNextId(1);
/*  118 */       setTrace(this.trace, 1, i);
/*  119 */       this.user = paramConnectionInfo.getUserName();
/*  120 */       if (isInfoEnabled()) {
/*  121 */         this.trace.infoCode("Connection " + getTraceObjectName() + " = DriverManager.getConnection(" + quote(paramConnectionInfo.getOriginalURL()) + ", " + quote(this.user) + ", \"\");");
/*      */       }
/*      */ 
/*      */       
/*  125 */       this.url = paramConnectionInfo.getURL();
/*  126 */       closeOld();
/*  127 */       this.watcher = CloseWatcher.register(this, (Closeable)this.session, keepOpenStackTrace);
/*  128 */     } catch (Exception exception) {
/*  129 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JdbcConnection(JdbcConnection paramJdbcConnection) {
/*  137 */     this.session = paramJdbcConnection.session;
/*  138 */     this.trace = this.session.getTrace();
/*  139 */     int i = getNextId(1);
/*  140 */     setTrace(this.trace, 1, i);
/*  141 */     this.user = paramJdbcConnection.user;
/*  142 */     this.url = paramJdbcConnection.url;
/*  143 */     this.catalog = paramJdbcConnection.catalog;
/*  144 */     this.commit = paramJdbcConnection.commit;
/*  145 */     this.getGeneratedKeys = paramJdbcConnection.getGeneratedKeys;
/*  146 */     this.getLockMode = paramJdbcConnection.getLockMode;
/*  147 */     this.getQueryTimeout = paramJdbcConnection.getQueryTimeout;
/*  148 */     this.getReadOnly = paramJdbcConnection.getReadOnly;
/*  149 */     this.rollback = paramJdbcConnection.rollback;
/*  150 */     this.watcher = null;
/*  151 */     if (paramJdbcConnection.clientInfo != null) {
/*  152 */       this.clientInfo = new HashMap<>(paramJdbcConnection.clientInfo);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JdbcConnection(SessionInterface paramSessionInterface, String paramString1, String paramString2) {
/*  160 */     this.session = paramSessionInterface;
/*  161 */     this.trace = paramSessionInterface.getTrace();
/*  162 */     int i = getNextId(1);
/*  163 */     setTrace(this.trace, 1, i);
/*  164 */     this.user = paramString1;
/*  165 */     this.url = paramString2;
/*  166 */     this.watcher = null;
/*      */   }
/*      */   
/*      */   private void closeOld() {
/*      */     while (true) {
/*  171 */       CloseWatcher closeWatcher = CloseWatcher.pollUnclosed();
/*  172 */       if (closeWatcher == null) {
/*      */         break;
/*      */       }
/*      */       try {
/*  176 */         closeWatcher.getCloseable().close();
/*  177 */       } catch (Exception exception) {
/*  178 */         this.trace.error(exception, "closing session");
/*      */       } 
/*      */ 
/*      */       
/*  182 */       keepOpenStackTrace = true;
/*  183 */       String str = closeWatcher.getOpenStackTrace();
/*  184 */       DbException dbException = DbException.get(90018);
/*  185 */       this.trace.error((Throwable)dbException, str);
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
/*      */   public Statement createStatement() throws SQLException {
/*      */     try {
/*  198 */       int i = getNextId(8);
/*  199 */       if (isDebugEnabled()) {
/*  200 */         debugCodeAssign("Statement", 8, i, "createStatement()");
/*      */       }
/*  202 */       checkClosed();
/*  203 */       return new JdbcStatement(this, i, 1003, 1007, false);
/*      */     
/*      */     }
/*  206 */     catch (Exception exception) {
/*  207 */       throw logAndConvert(exception);
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
/*      */   public Statement createStatement(int paramInt1, int paramInt2) throws SQLException {
/*      */     try {
/*  225 */       int i = getNextId(8);
/*  226 */       if (isDebugEnabled()) {
/*  227 */         debugCodeAssign("Statement", 8, i, "createStatement(" + paramInt1 + ", " + paramInt2 + ")");
/*      */       }
/*      */       
/*  230 */       checkTypeConcurrency(paramInt1, paramInt2);
/*  231 */       checkClosed();
/*  232 */       return new JdbcStatement(this, i, paramInt1, paramInt2, false);
/*  233 */     } catch (Exception exception) {
/*  234 */       throw logAndConvert(exception);
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
/*      */   public Statement createStatement(int paramInt1, int paramInt2, int paramInt3) throws SQLException {
/*      */     try {
/*  254 */       int i = getNextId(8);
/*  255 */       if (isDebugEnabled()) {
/*  256 */         debugCodeAssign("Statement", 8, i, "createStatement(" + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ")");
/*      */       }
/*      */ 
/*      */       
/*  260 */       checkTypeConcurrency(paramInt1, paramInt2);
/*  261 */       checkHoldability(paramInt3);
/*  262 */       checkClosed();
/*  263 */       return new JdbcStatement(this, i, paramInt1, paramInt2, false);
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
/*      */   
/*      */   public PreparedStatement prepareStatement(String paramString) throws SQLException {
/*      */     try {
/*  279 */       int i = getNextId(3);
/*  280 */       if (isDebugEnabled()) {
/*  281 */         debugCodeAssign("PreparedStatement", 3, i, "prepareStatement(" + quote(paramString) + ")");
/*      */       }
/*      */ 
/*      */       
/*  285 */       checkClosed();
/*  286 */       paramString = translateSQL(paramString);
/*  287 */       return new JdbcPreparedStatement(this, paramString, i, 1003, 1007, false);
/*      */     
/*      */     }
/*  290 */     catch (Exception exception) {
/*  291 */       throw logAndConvert(exception);
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
/*      */   PreparedStatement prepareAutoCloseStatement(String paramString) throws SQLException {
/*      */     try {
/*  304 */       int i = getNextId(3);
/*  305 */       if (isDebugEnabled()) {
/*  306 */         debugCodeAssign("PreparedStatement", 3, i, "prepareStatement(" + quote(paramString) + ")");
/*      */       }
/*      */ 
/*      */       
/*  310 */       checkClosed();
/*  311 */       paramString = translateSQL(paramString);
/*  312 */       return new JdbcPreparedStatement(this, paramString, i, 1003, 1007, true);
/*      */     
/*      */     }
/*  315 */     catch (Exception exception) {
/*  316 */       throw logAndConvert(exception);
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
/*      */   public DatabaseMetaData getMetaData() throws SQLException {
/*      */     try {
/*  329 */       int i = getNextId(2);
/*  330 */       if (isDebugEnabled()) {
/*  331 */         debugCodeAssign("DatabaseMetaData", 2, i, "getMetaData()");
/*      */       }
/*      */       
/*  334 */       checkClosed();
/*  335 */       return new JdbcDatabaseMetaData(this, this.trace, i);
/*  336 */     } catch (Exception exception) {
/*  337 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SessionInterface getSession() {
/*  345 */     return this.session;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void close() throws SQLException {
/*      */     try {
/*  357 */       debugCodeCall("close");
/*  358 */       if (this.session == null) {
/*      */         return;
/*      */       }
/*  361 */       CloseWatcher.unregister(this.watcher);
/*  362 */       this.session.cancel();
/*  363 */       if (this.executingStatement != null) {
/*      */         try {
/*  365 */           this.executingStatement.cancel();
/*  366 */         } catch (NullPointerException nullPointerException) {}
/*      */       }
/*      */ 
/*      */       
/*  370 */       synchronized (this.session) {
/*      */         try {
/*  372 */           if (!this.session.isClosed()) {
/*      */             try {
/*  374 */               if (this.session.hasPendingTransaction()) {
/*      */ 
/*      */ 
/*      */                 
/*  378 */                 if (!this.session.isReconnectNeeded(true)) {
/*      */                   try {
/*  380 */                     rollbackInternal();
/*  381 */                   } catch (DbException dbException) {
/*      */ 
/*      */                     
/*  384 */                     if (dbException.getErrorCode() != 90067)
/*      */                     {
/*  386 */                       throw dbException;
/*      */                     }
/*      */                   } 
/*      */                 }
/*  390 */                 this.session.afterWriting();
/*      */               } 
/*  392 */               closePreparedCommands();
/*      */             } finally {
/*  394 */               this.session.close();
/*      */             } 
/*      */           }
/*      */         } finally {
/*  398 */           this.session = null;
/*      */         } 
/*      */       } 
/*  401 */     } catch (Exception exception) {
/*  402 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void closePreparedCommands() {
/*  407 */     this.commit = closeAndSetNull(this.commit);
/*  408 */     this.rollback = closeAndSetNull(this.rollback);
/*  409 */     this.getReadOnly = closeAndSetNull(this.getReadOnly);
/*  410 */     this.getGeneratedKeys = closeAndSetNull(this.getGeneratedKeys);
/*  411 */     this.getLockMode = closeAndSetNull(this.getLockMode);
/*  412 */     this.setLockMode = closeAndSetNull(this.setLockMode);
/*  413 */     this.getQueryTimeout = closeAndSetNull(this.getQueryTimeout);
/*  414 */     this.setQueryTimeout = closeAndSetNull(this.setQueryTimeout);
/*      */   }
/*      */   
/*      */   private static CommandInterface closeAndSetNull(CommandInterface paramCommandInterface) {
/*  418 */     if (paramCommandInterface != null) {
/*  419 */       paramCommandInterface.close();
/*      */     }
/*  421 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void setAutoCommit(boolean paramBoolean) throws SQLException {
/*      */     try {
/*  435 */       if (isDebugEnabled()) {
/*  436 */         debugCode("setAutoCommit(" + paramBoolean + ");");
/*      */       }
/*  438 */       checkClosed();
/*  439 */       if (paramBoolean && !this.session.getAutoCommit()) {
/*  440 */         commit();
/*      */       }
/*  442 */       this.session.setAutoCommit(paramBoolean);
/*  443 */     } catch (Exception exception) {
/*  444 */       throw logAndConvert(exception);
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
/*      */   public synchronized boolean getAutoCommit() throws SQLException {
/*      */     try {
/*  457 */       checkClosed();
/*  458 */       debugCodeCall("getAutoCommit");
/*  459 */       return this.session.getAutoCommit();
/*  460 */     } catch (Exception exception) {
/*  461 */       throw logAndConvert(exception);
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
/*      */   public synchronized void commit() throws SQLException {
/*      */     try {
/*  474 */       debugCodeCall("commit");
/*  475 */       checkClosedForWrite();
/*      */       try {
/*  477 */         this.commit = prepareCommand("COMMIT", this.commit);
/*  478 */         this.commit.executeUpdate();
/*      */       } finally {
/*  480 */         afterWriting();
/*      */       } 
/*  482 */     } catch (Exception exception) {
/*  483 */       throw logAndConvert(exception);
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
/*      */   public synchronized void rollback() throws SQLException {
/*      */     try {
/*  496 */       debugCodeCall("rollback");
/*  497 */       checkClosedForWrite();
/*      */       try {
/*  499 */         rollbackInternal();
/*      */       } finally {
/*  501 */         afterWriting();
/*      */       } 
/*  503 */     } catch (Exception exception) {
/*  504 */       throw logAndConvert(exception);
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
/*  516 */       debugCodeCall("isClosed");
/*  517 */       return (this.session == null || this.session.isClosed());
/*  518 */     } catch (Exception exception) {
/*  519 */       throw logAndConvert(exception);
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
/*      */   public String nativeSQL(String paramString) throws SQLException {
/*      */     try {
/*  533 */       debugCodeCall("nativeSQL", paramString);
/*  534 */       checkClosed();
/*  535 */       return translateSQL(paramString);
/*  536 */     } catch (Exception exception) {
/*  537 */       throw logAndConvert(exception);
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
/*      */   public void setReadOnly(boolean paramBoolean) throws SQLException {
/*      */     try {
/*  551 */       if (isDebugEnabled()) {
/*  552 */         debugCode("setReadOnly(" + paramBoolean + ");");
/*      */       }
/*  554 */       checkClosed();
/*  555 */     } catch (Exception exception) {
/*  556 */       throw logAndConvert(exception);
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
/*      */   public boolean isReadOnly() throws SQLException {
/*      */     try {
/*  569 */       debugCodeCall("isReadOnly");
/*  570 */       checkClosed();
/*  571 */       this.getReadOnly = prepareCommand("CALL READONLY()", this.getReadOnly);
/*  572 */       ResultInterface resultInterface = this.getReadOnly.executeQuery(0, false);
/*  573 */       resultInterface.next();
/*  574 */       return resultInterface.currentRow()[0].getBoolean().booleanValue();
/*      */     }
/*  576 */     catch (Exception exception) {
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
/*      */   public void setCatalog(String paramString) throws SQLException {
/*      */     try {
/*  590 */       debugCodeCall("setCatalog", paramString);
/*  591 */       checkClosed();
/*  592 */     } catch (Exception exception) {
/*  593 */       throw logAndConvert(exception);
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
/*      */   public String getCatalog() throws SQLException {
/*      */     try {
/*  606 */       debugCodeCall("getCatalog");
/*  607 */       checkClosed();
/*  608 */       if (this.catalog == null) {
/*  609 */         CommandInterface commandInterface = prepareCommand("CALL DATABASE()", 2147483647);
/*  610 */         ResultInterface resultInterface = commandInterface.executeQuery(0, false);
/*  611 */         resultInterface.next();
/*  612 */         this.catalog = resultInterface.currentRow()[0].getString();
/*  613 */         commandInterface.close();
/*      */       } 
/*  615 */       return this.catalog;
/*  616 */     } catch (Exception exception) {
/*  617 */       throw logAndConvert(exception);
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
/*  629 */       debugCodeCall("getWarnings");
/*  630 */       checkClosed();
/*  631 */       return null;
/*  632 */     } catch (Exception exception) {
/*  633 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearWarnings() throws SQLException {
/*      */     try {
/*  643 */       debugCodeCall("clearWarnings");
/*  644 */       checkClosed();
/*  645 */     } catch (Exception exception) {
/*  646 */       throw logAndConvert(exception);
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
/*      */   public PreparedStatement prepareStatement(String paramString, int paramInt1, int paramInt2) throws SQLException {
/*      */     try {
/*  666 */       int i = getNextId(3);
/*  667 */       if (isDebugEnabled()) {
/*  668 */         debugCodeAssign("PreparedStatement", 3, i, "prepareStatement(" + quote(paramString) + ", " + paramInt1 + ", " + paramInt2 + ")");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  673 */       checkTypeConcurrency(paramInt1, paramInt2);
/*  674 */       checkClosed();
/*  675 */       paramString = translateSQL(paramString);
/*  676 */       return new JdbcPreparedStatement(this, paramString, i, paramInt1, paramInt2, false);
/*      */     }
/*  678 */     catch (Exception exception) {
/*  679 */       throw logAndConvert(exception);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionIsolation(int paramInt) throws SQLException {
/*      */     try {
/*      */       byte b;
/*  711 */       debugCodeCall("setTransactionIsolation", paramInt);
/*  712 */       checkClosed();
/*      */       
/*  714 */       switch (paramInt) {
/*      */         case 1:
/*  716 */           b = 0;
/*      */           break;
/*      */         case 2:
/*  719 */           b = 3;
/*      */           break;
/*      */         case 4:
/*      */         case 8:
/*  723 */           b = 1;
/*      */           break;
/*      */         default:
/*  726 */           throw DbException.getInvalidValueException("level", Integer.valueOf(paramInt));
/*      */       } 
/*  728 */       commit();
/*  729 */       this.setLockMode = prepareCommand("SET LOCK_MODE ?", this.setLockMode);
/*  730 */       ((ParameterInterface)this.setLockMode.getParameters().get(0)).setValue((Value)ValueInt.get(b), false);
/*  731 */       this.setLockMode.executeUpdate();
/*  732 */     } catch (Exception exception) {
/*  733 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQueryTimeout(int paramInt) throws SQLException {
/*      */     try {
/*  742 */       debugCodeCall("setQueryTimeout", paramInt);
/*  743 */       checkClosed();
/*  744 */       this.setQueryTimeout = prepareCommand("SET QUERY_TIMEOUT ?", this.setQueryTimeout);
/*  745 */       ((ParameterInterface)this.setQueryTimeout.getParameters().get(0)).setValue((Value)ValueInt.get(paramInt * 1000), false);
/*      */       
/*  747 */       this.setQueryTimeout.executeUpdate();
/*  748 */       this.queryTimeoutCache = paramInt;
/*  749 */     } catch (Exception exception) {
/*  750 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int getQueryTimeout() throws SQLException {
/*      */     try {
/*  759 */       if (this.queryTimeoutCache == -1) {
/*  760 */         checkClosed();
/*  761 */         this.getQueryTimeout = prepareCommand("SELECT VALUE FROM INFORMATION_SCHEMA.SETTINGS WHERE NAME=?", this.getQueryTimeout);
/*      */ 
/*      */         
/*  764 */         ((ParameterInterface)this.getQueryTimeout.getParameters().get(0)).setValue(ValueString.get("QUERY_TIMEOUT"), false);
/*      */         
/*  766 */         ResultInterface resultInterface = this.getQueryTimeout.executeQuery(0, false);
/*  767 */         resultInterface.next();
/*  768 */         int i = resultInterface.currentRow()[0].getInt();
/*  769 */         resultInterface.close();
/*  770 */         if (i != 0)
/*      */         {
/*      */           
/*  773 */           i = (i + 999) / 1000;
/*      */         }
/*  775 */         this.queryTimeoutCache = i;
/*      */       } 
/*  777 */       return this.queryTimeoutCache;
/*  778 */     } catch (Exception exception) {
/*  779 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTransactionIsolation() throws SQLException {
/*      */     try {
/*      */       byte b;
/*  792 */       debugCodeCall("getTransactionIsolation");
/*  793 */       checkClosed();
/*  794 */       this.getLockMode = prepareCommand("CALL LOCK_MODE()", this.getLockMode);
/*  795 */       ResultInterface resultInterface = this.getLockMode.executeQuery(0, false);
/*  796 */       resultInterface.next();
/*  797 */       int i = resultInterface.currentRow()[0].getInt();
/*  798 */       resultInterface.close();
/*      */       
/*  800 */       switch (i)
/*      */       { case 0:
/*  802 */           b = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  814 */           return b;case 3: b = 2; return b;case 1: case 2: b = 8; return b; }  throw DbException.throwInternalError("lockMode:" + i);
/*  815 */     } catch (Exception exception) {
/*  816 */       throw logAndConvert(exception);
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
/*      */   public void setHoldability(int paramInt) throws SQLException {
/*      */     try {
/*  833 */       debugCodeCall("setHoldability", paramInt);
/*  834 */       checkClosed();
/*  835 */       checkHoldability(paramInt);
/*  836 */       this.holdability = paramInt;
/*  837 */     } catch (Exception exception) {
/*  838 */       throw logAndConvert(exception);
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
/*      */   public int getHoldability() throws SQLException {
/*      */     try {
/*  851 */       debugCodeCall("getHoldability");
/*  852 */       checkClosed();
/*  853 */       return this.holdability;
/*  854 */     } catch (Exception exception) {
/*  855 */       throw logAndConvert(exception);
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
/*      */   public Map<String, Class<?>> getTypeMap() throws SQLException {
/*      */     try {
/*  868 */       debugCodeCall("getTypeMap");
/*  869 */       checkClosed();
/*  870 */       return null;
/*  871 */     } catch (Exception exception) {
/*  872 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTypeMap(Map<String, Class<?>> paramMap) throws SQLException {
/*      */     try {
/*  883 */       if (isDebugEnabled()) {
/*  884 */         debugCode("setTypeMap(" + quoteMap(paramMap) + ");");
/*      */       }
/*  886 */       checkMap(paramMap);
/*  887 */     } catch (Exception exception) {
/*  888 */       throw logAndConvert(exception);
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
/*      */   public CallableStatement prepareCall(String paramString) throws SQLException {
/*      */     try {
/*  903 */       int i = getNextId(0);
/*  904 */       if (isDebugEnabled()) {
/*  905 */         debugCodeAssign("CallableStatement", 0, i, "prepareCall(" + quote(paramString) + ")");
/*      */       }
/*      */ 
/*      */       
/*  909 */       checkClosed();
/*  910 */       paramString = translateSQL(paramString);
/*  911 */       return new JdbcCallableStatement(this, paramString, i, 1003, 1007);
/*      */     
/*      */     }
/*  914 */     catch (Exception exception) {
/*  915 */       throw logAndConvert(exception);
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
/*      */   public CallableStatement prepareCall(String paramString, int paramInt1, int paramInt2) throws SQLException {
/*      */     try {
/*  935 */       int i = getNextId(0);
/*  936 */       if (isDebugEnabled()) {
/*  937 */         debugCodeAssign("CallableStatement", 0, i, "prepareCall(" + quote(paramString) + ", " + paramInt1 + ", " + paramInt2 + ")");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  942 */       checkTypeConcurrency(paramInt1, paramInt2);
/*  943 */       checkClosed();
/*  944 */       paramString = translateSQL(paramString);
/*  945 */       return new JdbcCallableStatement(this, paramString, i, paramInt1, paramInt2);
/*      */     }
/*  947 */     catch (Exception exception) {
/*  948 */       throw logAndConvert(exception);
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
/*      */   public CallableStatement prepareCall(String paramString, int paramInt1, int paramInt2, int paramInt3) throws SQLException {
/*      */     try {
/*  969 */       int i = getNextId(0);
/*  970 */       if (isDebugEnabled()) {
/*  971 */         debugCodeAssign("CallableStatement", 0, i, "prepareCall(" + quote(paramString) + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ")");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  977 */       checkTypeConcurrency(paramInt1, paramInt2);
/*  978 */       checkHoldability(paramInt3);
/*  979 */       checkClosed();
/*  980 */       paramString = translateSQL(paramString);
/*  981 */       return new JdbcCallableStatement(this, paramString, i, paramInt1, paramInt2);
/*      */     }
/*  983 */     catch (Exception exception) {
/*  984 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Savepoint setSavepoint() throws SQLException {
/*      */     try {
/*  996 */       int i = getNextId(6);
/*  997 */       if (isDebugEnabled()) {
/*  998 */         debugCodeAssign("Savepoint", 6, i, "setSavepoint()");
/*      */       }
/* 1000 */       checkClosed();
/* 1001 */       CommandInterface commandInterface = prepareCommand("SAVEPOINT " + JdbcSavepoint.getName((String)null, this.savepointId), 2147483647);
/*      */ 
/*      */       
/* 1004 */       commandInterface.executeUpdate();
/* 1005 */       JdbcSavepoint jdbcSavepoint = new JdbcSavepoint(this, this.savepointId, null, this.trace, i);
/* 1006 */       this.savepointId++;
/* 1007 */       return jdbcSavepoint;
/* 1008 */     } catch (Exception exception) {
/* 1009 */       throw logAndConvert(exception);
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
/*      */   public Savepoint setSavepoint(String paramString) throws SQLException {
/*      */     try {
/* 1022 */       int i = getNextId(6);
/* 1023 */       if (isDebugEnabled()) {
/* 1024 */         debugCodeAssign("Savepoint", 6, i, "setSavepoint(" + quote(paramString) + ")");
/*      */       }
/*      */       
/* 1027 */       checkClosed();
/* 1028 */       CommandInterface commandInterface = prepareCommand("SAVEPOINT " + JdbcSavepoint.getName(paramString, 0), 2147483647);
/*      */       
/* 1030 */       commandInterface.executeUpdate();
/* 1031 */       return new JdbcSavepoint(this, 0, paramString, this.trace, i);
/*      */     }
/* 1033 */     catch (Exception exception) {
/* 1034 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rollback(Savepoint paramSavepoint) throws SQLException {
/*      */     try {
/* 1046 */       JdbcSavepoint jdbcSavepoint = convertSavepoint(paramSavepoint);
/* 1047 */       if (isDebugEnabled()) {
/* 1048 */         debugCode("rollback(" + jdbcSavepoint.getTraceObjectName() + ");");
/*      */       }
/* 1050 */       checkClosedForWrite();
/*      */       try {
/* 1052 */         jdbcSavepoint.rollback();
/*      */       } finally {
/* 1054 */         afterWriting();
/*      */       } 
/* 1056 */     } catch (Exception exception) {
/* 1057 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void releaseSavepoint(Savepoint paramSavepoint) throws SQLException {
/*      */     try {
/* 1069 */       debugCode("releaseSavepoint(savepoint);");
/* 1070 */       checkClosed();
/* 1071 */       convertSavepoint(paramSavepoint).release();
/* 1072 */     } catch (Exception exception) {
/* 1073 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   private static JdbcSavepoint convertSavepoint(Savepoint paramSavepoint) {
/* 1078 */     if (!(paramSavepoint instanceof JdbcSavepoint)) {
/* 1079 */       throw DbException.get(90063, "" + paramSavepoint);
/*      */     }
/* 1081 */     return (JdbcSavepoint)paramSavepoint;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PreparedStatement prepareStatement(String paramString, int paramInt1, int paramInt2, int paramInt3) throws SQLException {
/*      */     try {
/* 1101 */       int i = getNextId(3);
/* 1102 */       if (isDebugEnabled()) {
/* 1103 */         debugCodeAssign("PreparedStatement", 3, i, "prepareStatement(" + quote(paramString) + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ")");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1108 */       checkTypeConcurrency(paramInt1, paramInt2);
/* 1109 */       checkHoldability(paramInt3);
/* 1110 */       checkClosed();
/* 1111 */       paramString = translateSQL(paramString);
/* 1112 */       return new JdbcPreparedStatement(this, paramString, i, paramInt1, paramInt2, false);
/*      */     }
/* 1114 */     catch (Exception exception) {
/* 1115 */       throw logAndConvert(exception);
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
/*      */   public PreparedStatement prepareStatement(String paramString, int paramInt) throws SQLException {
/*      */     try {
/* 1134 */       if (isDebugEnabled()) {
/* 1135 */         debugCode("prepareStatement(" + quote(paramString) + ", " + paramInt + ");");
/*      */       }
/* 1137 */       return prepareStatement(paramString);
/* 1138 */     } catch (Exception exception) {
/* 1139 */       throw logAndConvert(exception);
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
/*      */   public PreparedStatement prepareStatement(String paramString, int[] paramArrayOfint) throws SQLException {
/*      */     try {
/* 1158 */       if (isDebugEnabled()) {
/* 1159 */         debugCode("prepareStatement(" + quote(paramString) + ", " + quoteIntArray(paramArrayOfint) + ");");
/*      */       }
/*      */       
/* 1162 */       return prepareStatement(paramString);
/* 1163 */     } catch (Exception exception) {
/* 1164 */       throw logAndConvert(exception);
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
/*      */   public PreparedStatement prepareStatement(String paramString, String[] paramArrayOfString) throws SQLException {
/*      */     try {
/* 1183 */       if (isDebugEnabled()) {
/* 1184 */         debugCode("prepareStatement(" + quote(paramString) + ", " + quoteArray(paramArrayOfString) + ");");
/*      */       }
/*      */       
/* 1187 */       return prepareStatement(paramString);
/* 1188 */     } catch (Exception exception) {
/* 1189 */       throw logAndConvert(exception);
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
/*      */   CommandInterface prepareCommand(String paramString, int paramInt) {
/* 1203 */     return this.session.prepareCommand(paramString, paramInt);
/*      */   }
/*      */   
/*      */   private CommandInterface prepareCommand(String paramString, CommandInterface paramCommandInterface) {
/* 1207 */     return (paramCommandInterface == null) ? this.session.prepareCommand(paramString, 2147483647) : paramCommandInterface;
/*      */   }
/*      */   
/*      */   private static int translateGetEnd(String paramString, int paramInt, char paramChar) {
/* 1211 */     int j, i = paramString.length();
/* 1212 */     switch (paramChar) {
/*      */       case '$':
/* 1214 */         if (paramInt < i - 1 && paramString.charAt(paramInt + 1) == '$' && (paramInt == 0 || paramString.charAt(paramInt - 1) <= ' ')) {
/*      */           
/* 1216 */           int k = paramString.indexOf("$$", paramInt + 2);
/* 1217 */           if (k < 0) {
/* 1218 */             throw DbException.getSyntaxError(paramString, paramInt);
/*      */           }
/* 1220 */           return k + 1;
/*      */         } 
/* 1222 */         return paramInt;
/*      */       
/*      */       case '\'':
/* 1225 */         j = paramString.indexOf('\'', paramInt + 1);
/* 1226 */         if (j < 0) {
/* 1227 */           throw DbException.getSyntaxError(paramString, paramInt);
/*      */         }
/* 1229 */         return j;
/*      */       
/*      */       case '"':
/* 1232 */         j = paramString.indexOf('"', paramInt + 1);
/* 1233 */         if (j < 0) {
/* 1234 */           throw DbException.getSyntaxError(paramString, paramInt);
/*      */         }
/* 1236 */         return j;
/*      */       
/*      */       case '/':
/* 1239 */         checkRunOver(paramInt + 1, i, paramString);
/* 1240 */         if (paramString.charAt(paramInt + 1) == '*') {
/*      */           
/* 1242 */           j = paramString.indexOf("*/", paramInt + 2);
/* 1243 */           if (j < 0) {
/* 1244 */             throw DbException.getSyntaxError(paramString, paramInt);
/*      */           }
/* 1246 */           paramInt = j + 1;
/* 1247 */         } else if (paramString.charAt(paramInt + 1) == '/') {
/*      */           
/* 1249 */           paramInt += 2;
/* 1250 */           while (paramInt < i && (paramChar = paramString.charAt(paramInt)) != '\r' && paramChar != '\n') {
/* 1251 */             paramInt++;
/*      */           }
/*      */         } 
/* 1254 */         return paramInt;
/*      */       
/*      */       case '-':
/* 1257 */         checkRunOver(paramInt + 1, i, paramString);
/* 1258 */         if (paramString.charAt(paramInt + 1) == '-') {
/*      */           
/* 1260 */           paramInt += 2;
/* 1261 */           while (paramInt < i && (paramChar = paramString.charAt(paramInt)) != '\r' && paramChar != '\n') {
/* 1262 */             paramInt++;
/*      */           }
/*      */         } 
/* 1265 */         return paramInt;
/*      */     } 
/*      */     
/* 1268 */     throw DbException.throwInternalError("c=" + paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String translateSQL(String paramString) {
/* 1280 */     return translateSQL(paramString, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String translateSQL(String paramString, boolean paramBoolean) {
/* 1292 */     if (paramString == null) {
/* 1293 */       throw DbException.getInvalidValueException("SQL", null);
/*      */     }
/* 1295 */     if (!paramBoolean) {
/* 1296 */       return paramString;
/*      */     }
/* 1298 */     if (paramString.indexOf('{') < 0) {
/* 1299 */       return paramString;
/*      */     }
/* 1301 */     int i = paramString.length();
/* 1302 */     char[] arrayOfChar = null;
/* 1303 */     byte b = 0;
/* 1304 */     for (int j = 0; j < i; j++) {
/* 1305 */       int k, m; char c = paramString.charAt(j);
/* 1306 */       switch (c) {
/*      */         case '"':
/*      */         case '\'':
/*      */         case '-':
/*      */         case '/':
/* 1311 */           j = translateGetEnd(paramString, j, c);
/*      */           break;
/*      */         case '{':
/* 1314 */           b++;
/* 1315 */           if (arrayOfChar == null) {
/* 1316 */             arrayOfChar = paramString.toCharArray();
/*      */           }
/* 1318 */           arrayOfChar[j] = ' ';
/* 1319 */           while (Character.isSpaceChar(arrayOfChar[j])) {
/* 1320 */             j++;
/* 1321 */             checkRunOver(j, i, paramString);
/*      */           } 
/* 1323 */           k = j;
/* 1324 */           if (arrayOfChar[j] >= '0' && arrayOfChar[j] <= '9') {
/* 1325 */             arrayOfChar[j - 1] = '{';
/*      */             while (true) {
/* 1327 */               checkRunOver(j, i, paramString);
/* 1328 */               c = arrayOfChar[j];
/* 1329 */               if (c == '}') {
/*      */                 break;
/*      */               }
/* 1332 */               switch (c) {
/*      */                 case '"':
/*      */                 case '\'':
/*      */                 case '-':
/*      */                 case '/':
/* 1337 */                   j = translateGetEnd(paramString, j, c);
/*      */                   break;
/*      */               } 
/*      */               
/* 1341 */               j++;
/*      */             } 
/* 1343 */             b--; break;
/*      */           } 
/* 1345 */           if (arrayOfChar[j] == '?') {
/* 1346 */             j++;
/* 1347 */             checkRunOver(j, i, paramString);
/* 1348 */             while (Character.isSpaceChar(arrayOfChar[j])) {
/* 1349 */               j++;
/* 1350 */               checkRunOver(j, i, paramString);
/*      */             } 
/* 1352 */             if (paramString.charAt(j) != '=') {
/* 1353 */               throw DbException.getSyntaxError(paramString, j, "=");
/*      */             }
/* 1355 */             j++;
/* 1356 */             checkRunOver(j, i, paramString);
/* 1357 */             while (Character.isSpaceChar(arrayOfChar[j])) {
/* 1358 */               j++;
/* 1359 */               checkRunOver(j, i, paramString);
/*      */             } 
/*      */           } 
/* 1362 */           while (!Character.isSpaceChar(arrayOfChar[j])) {
/* 1363 */             j++;
/* 1364 */             checkRunOver(j, i, paramString);
/*      */           } 
/* 1366 */           m = 0;
/* 1367 */           if (found(paramString, k, "fn"))
/* 1368 */           { m = 2; }
/* 1369 */           else { if (found(paramString, k, "escape"))
/*      */               break; 
/* 1371 */             if (found(paramString, k, "call"))
/*      */               break; 
/* 1373 */             if (found(paramString, k, "oj"))
/* 1374 */             { m = 2; }
/* 1375 */             else { if (found(paramString, k, "ts"))
/*      */                 break; 
/* 1377 */               if (found(paramString, k, "t"))
/*      */                 break; 
/* 1379 */               if (found(paramString, k, "d"))
/*      */                 break; 
/* 1381 */               if (found(paramString, k, "params"))
/* 1382 */                 m = "params".length();  }
/*      */              }
/* 1384 */            for (j = k; m > 0; j++, m--) {
/* 1385 */             arrayOfChar[j] = ' ';
/*      */           }
/*      */           break;
/*      */         case '}':
/* 1389 */           if (--b < 0) {
/* 1390 */             throw DbException.getSyntaxError(paramString, j);
/*      */           }
/* 1392 */           arrayOfChar[j] = ' ';
/*      */           break;
/*      */         case '$':
/* 1395 */           j = translateGetEnd(paramString, j, c);
/*      */           break;
/*      */       } 
/*      */     
/*      */     } 
/* 1400 */     if (b != 0) {
/* 1401 */       throw DbException.getSyntaxError(paramString, paramString.length() - 1);
/*      */     }
/* 1403 */     if (arrayOfChar != null) {
/* 1404 */       paramString = new String(arrayOfChar);
/*      */     }
/* 1406 */     return paramString;
/*      */   }
/*      */   
/*      */   private static void checkRunOver(int paramInt1, int paramInt2, String paramString) {
/* 1410 */     if (paramInt1 >= paramInt2) {
/* 1411 */       throw DbException.getSyntaxError(paramString, paramInt1);
/*      */     }
/*      */   }
/*      */   
/*      */   private static boolean found(String paramString1, int paramInt, String paramString2) {
/* 1416 */     return paramString1.regionMatches(true, paramInt, paramString2, 0, paramString2.length());
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkTypeConcurrency(int paramInt1, int paramInt2) {
/* 1421 */     switch (paramInt1) {
/*      */       case 1003:
/*      */       case 1004:
/*      */       case 1005:
/*      */         break;
/*      */       default:
/* 1427 */         throw DbException.getInvalidValueException("resultSetType", Integer.valueOf(paramInt1));
/*      */     } 
/*      */     
/* 1430 */     switch (paramInt2) {
/*      */       case 1007:
/*      */       case 1008:
/*      */         return;
/*      */     } 
/* 1435 */     throw DbException.getInvalidValueException("resultSetConcurrency", Integer.valueOf(paramInt2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkHoldability(int paramInt) {
/* 1443 */     if (paramInt != 1 && paramInt != 2)
/*      */     {
/* 1445 */       throw DbException.getInvalidValueException("resultSetHoldability", Integer.valueOf(paramInt));
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
/*      */   protected void checkClosed() {
/* 1458 */     checkClosed(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkClosedForWrite() {
/* 1468 */     checkClosed(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void checkClosed(boolean paramBoolean) {
/* 1479 */     if (this.session == null) {
/* 1480 */       throw DbException.get(90007);
/*      */     }
/* 1482 */     if (this.session.isClosed()) {
/* 1483 */       throw DbException.get(90121);
/*      */     }
/* 1485 */     if (this.session.isReconnectNeeded(paramBoolean)) {
/* 1486 */       this.trace.debug("reconnect");
/* 1487 */       closePreparedCommands();
/* 1488 */       this.session = this.session.reconnect(paramBoolean);
/* 1489 */       this.trace = this.session.getTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void afterWriting() {
/* 1498 */     if (this.session != null) {
/* 1499 */       this.session.afterWriting();
/*      */     }
/*      */   }
/*      */   
/*      */   String getURL() {
/* 1504 */     checkClosed();
/* 1505 */     return this.url;
/*      */   }
/*      */   
/*      */   String getUser() {
/* 1509 */     checkClosed();
/* 1510 */     return this.user;
/*      */   }
/*      */   
/*      */   private void rollbackInternal() {
/* 1514 */     this.rollback = prepareCommand("ROLLBACK", this.rollback);
/* 1515 */     this.rollback.executeUpdate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPowerOffCount() {
/* 1522 */     return (this.session == null || this.session.isClosed()) ? 0 : this.session.getPowerOffCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPowerOffCount(int paramInt) {
/* 1530 */     if (this.session != null) {
/* 1531 */       this.session.setPowerOffCount(paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExecutingStatement(Statement paramStatement) {
/* 1539 */     this.executingStatement = paramStatement;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ResultSet getGeneratedKeys(JdbcStatement paramJdbcStatement, int paramInt) {
/* 1546 */     this.getGeneratedKeys = prepareCommand("SELECT SCOPE_IDENTITY() WHERE SCOPE_IDENTITY() IS NOT NULL", this.getGeneratedKeys);
/*      */ 
/*      */     
/* 1549 */     ResultInterface resultInterface = this.getGeneratedKeys.executeQuery(0, false);
/* 1550 */     return new JdbcResultSet(this, paramJdbcStatement, resultInterface, paramInt, false, true, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Clob createClob() throws SQLException {
/*      */     try {
/* 1562 */       int i = getNextId(10);
/* 1563 */       debugCodeAssign("Clob", 10, i, "createClob()");
/* 1564 */       checkClosedForWrite();
/*      */       try {
/* 1566 */         Value value = this.session.getDataHandler().getLobStorage().createClob(new InputStreamReader(new ByteArrayInputStream(Utils.EMPTY_BYTES)), 0L);
/*      */ 
/*      */         
/* 1569 */         this.session.addTemporaryLob(value);
/* 1570 */         return new JdbcClob(this, value, i);
/*      */       } finally {
/* 1572 */         afterWriting();
/*      */       } 
/* 1574 */     } catch (Exception exception) {
/* 1575 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Blob createBlob() throws SQLException {
/*      */     try {
/* 1587 */       int i = getNextId(9);
/* 1588 */       debugCodeAssign("Blob", 9, i, "createClob()");
/* 1589 */       checkClosedForWrite();
/*      */       try {
/* 1591 */         Value value = this.session.getDataHandler().getLobStorage().createBlob(new ByteArrayInputStream(Utils.EMPTY_BYTES), 0L);
/*      */         
/* 1593 */         this.session.addTemporaryLob(value);
/* 1594 */         return new JdbcBlob(this, value, i);
/*      */       } finally {
/* 1596 */         afterWriting();
/*      */       } 
/* 1598 */     } catch (Exception exception) {
/* 1599 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NClob createNClob() throws SQLException {
/*      */     try {
/* 1611 */       int i = getNextId(10);
/* 1612 */       debugCodeAssign("NClob", 10, i, "createNClob()");
/* 1613 */       checkClosedForWrite();
/*      */       try {
/* 1615 */         Value value = this.session.getDataHandler().getLobStorage().createClob(new InputStreamReader(new ByteArrayInputStream(Utils.EMPTY_BYTES)), 0L);
/*      */ 
/*      */         
/* 1618 */         this.session.addTemporaryLob(value);
/* 1619 */         return new JdbcClob(this, value, i);
/*      */       } finally {
/* 1621 */         afterWriting();
/*      */       } 
/* 1623 */     } catch (Exception exception) {
/* 1624 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SQLXML createSQLXML() throws SQLException {
/* 1633 */     throw unsupported("SQLXML");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Array createArrayOf(String paramString, Object[] paramArrayOfObject) throws SQLException {
/* 1642 */     throw unsupported("createArray");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Struct createStruct(String paramString, Object[] paramArrayOfObject) throws SQLException {
/* 1651 */     throw unsupported("Struct");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized boolean isValid(int paramInt) {
/*      */     try {
/* 1664 */       debugCodeCall("isValid", paramInt);
/* 1665 */       if (this.session == null || this.session.isClosed()) {
/* 1666 */         return false;
/*      */       }
/*      */       
/* 1669 */       getTransactionIsolation();
/* 1670 */       return true;
/* 1671 */     } catch (Exception exception) {
/*      */       
/* 1673 */       logAndConvert(exception);
/* 1674 */       return false;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClientInfo(String paramString1, String paramString2) throws SQLClientInfoException {
/*      */     try {
/* 1704 */       if (isDebugEnabled()) {
/* 1705 */         debugCode("setClientInfo(" + quote(paramString1) + ", " + quote(paramString2) + ");");
/*      */       }
/*      */ 
/*      */       
/* 1709 */       checkClosed();
/*      */       
/* 1711 */       if (isInternalProperty(paramString1)) {
/* 1712 */         throw new SQLClientInfoException("Property name '" + paramString1 + " is used internally by H2.", Collections.emptyMap());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1717 */       Pattern pattern = (Mode.getInstance(getMode())).supportedClientInfoPropertiesRegEx;
/*      */ 
/*      */       
/* 1720 */       if (pattern != null && pattern.matcher(paramString1).matches()) {
/* 1721 */         if (this.clientInfo == null) {
/* 1722 */           this.clientInfo = new HashMap<>();
/*      */         }
/* 1724 */         this.clientInfo.put(paramString1, paramString2);
/*      */       } else {
/* 1726 */         throw new SQLClientInfoException("Client info name '" + paramString1 + "' not supported.", Collections.emptyMap());
/*      */       }
/*      */     
/* 1729 */     } catch (Exception exception) {
/* 1730 */       throw convertToClientInfoException(logAndConvert(exception));
/*      */     } 
/*      */   }
/*      */   
/*      */   private static boolean isInternalProperty(String paramString) {
/* 1735 */     return ("numServers".equals(paramString) || paramString.startsWith("server"));
/*      */   }
/*      */ 
/*      */   
/*      */   private static SQLClientInfoException convertToClientInfoException(SQLException paramSQLException) {
/* 1740 */     if (paramSQLException instanceof SQLClientInfoException) {
/* 1741 */       return (SQLClientInfoException)paramSQLException;
/*      */     }
/* 1743 */     return new SQLClientInfoException(paramSQLException.getMessage(), paramSQLException.getSQLState(), paramSQLException.getErrorCode(), null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClientInfo(Properties paramProperties) throws SQLClientInfoException {
/*      */     try {
/* 1759 */       if (isDebugEnabled()) {
/* 1760 */         debugCode("setClientInfo(properties);");
/*      */       }
/* 1762 */       checkClosed();
/* 1763 */       if (this.clientInfo == null) {
/* 1764 */         this.clientInfo = new HashMap<>();
/*      */       } else {
/* 1766 */         this.clientInfo.clear();
/*      */       } 
/* 1768 */       for (Map.Entry<Object, Object> entry : paramProperties.entrySet()) {
/* 1769 */         setClientInfo((String)entry.getKey(), (String)entry.getValue());
/*      */       }
/* 1771 */     } catch (Exception exception) {
/* 1772 */       throw convertToClientInfoException(logAndConvert(exception));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Properties getClientInfo() throws SQLException {
/*      */     try {
/* 1784 */       if (isDebugEnabled()) {
/* 1785 */         debugCode("getClientInfo();");
/*      */       }
/* 1787 */       checkClosed();
/* 1788 */       ArrayList<String> arrayList = this.session.getClusterServers();
/* 1789 */       Properties properties = new Properties();
/*      */       
/* 1791 */       if (this.clientInfo != null) {
/* 1792 */         for (Map.Entry<String, String> entry : this.clientInfo.entrySet()) {
/* 1793 */           properties.setProperty((String)entry.getKey(), (String)entry.getValue());
/*      */         }
/*      */       }
/*      */       
/* 1797 */       properties.setProperty("numServers", String.valueOf(arrayList.size()));
/* 1798 */       for (byte b = 0; b < arrayList.size(); b++) {
/* 1799 */         properties.setProperty("server" + String.valueOf(b), arrayList.get(b));
/*      */       }
/*      */ 
/*      */       
/* 1803 */       return properties;
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
/*      */   public String getClientInfo(String paramString) throws SQLException {
/*      */     try {
/* 1819 */       if (isDebugEnabled()) {
/* 1820 */         debugCodeCall("getClientInfo", paramString);
/*      */       }
/* 1822 */       checkClosed();
/* 1823 */       return getClientInfo().getProperty(paramString);
/* 1824 */     } catch (Exception exception) {
/* 1825 */       throw logAndConvert(exception);
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
/* 1838 */     if (isWrapperFor(paramClass)) {
/* 1839 */       return (T)this;
/*      */     }
/* 1841 */     throw DbException.getInvalidValueException("iface", paramClass);
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
/* 1852 */     return (paramClass != null && paramClass.isAssignableFrom(getClass()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value createClob(Reader paramReader, long paramLong) {
/* 1864 */     if (paramReader == null) {
/* 1865 */       return (Value)ValueNull.INSTANCE;
/*      */     }
/* 1867 */     if (paramLong <= 0L) {
/* 1868 */       paramLong = -1L;
/*      */     }
/* 1870 */     Value value = this.session.getDataHandler().getLobStorage().createClob(paramReader, paramLong);
/* 1871 */     this.session.addTemporaryLob(value);
/* 1872 */     return value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value createBlob(InputStream paramInputStream, long paramLong) {
/* 1884 */     if (paramInputStream == null) {
/* 1885 */       return (Value)ValueNull.INSTANCE;
/*      */     }
/* 1887 */     if (paramLong <= 0L) {
/* 1888 */       paramLong = -1L;
/*      */     }
/* 1890 */     Value value = this.session.getDataHandler().getLobStorage().createBlob(paramInputStream, paramLong);
/* 1891 */     this.session.addTemporaryLob(value);
/* 1892 */     return value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSchema(String paramString) throws SQLException {
/*      */     try {
/* 1904 */       if (isDebugEnabled()) {
/* 1905 */         debugCodeCall("setSchema", paramString);
/*      */       }
/* 1907 */       checkClosed();
/* 1908 */       this.session.setCurrentSchemaName(paramString);
/* 1909 */     } catch (Exception exception) {
/* 1910 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSchema() throws SQLException {
/*      */     try {
/* 1922 */       if (isDebugEnabled()) {
/* 1923 */         debugCodeCall("getSchema");
/*      */       }
/* 1925 */       checkClosed();
/* 1926 */       return this.session.getCurrentSchemaName();
/* 1927 */     } catch (Exception exception) {
/* 1928 */       throw logAndConvert(exception);
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
/*      */   public void abort(Executor paramExecutor) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNetworkTimeout(Executor paramExecutor, int paramInt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNetworkTimeout() {
/* 1958 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void checkMap(Map<String, Class<?>> paramMap) {
/* 1968 */     if (paramMap != null && paramMap.size() > 0) {
/* 1969 */       throw DbException.getUnsupportedException("map.size > 0");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1978 */     return getTraceObjectName() + ": url=" + this.url + " user=" + this.user;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Object convertToDefaultObject(Value paramValue) {
/*      */     JdbcClob jdbcClob;
/*      */     int i;
/* 1990 */     switch (paramValue.getType()) {
/*      */       case 16:
/* 1992 */         i = getNextId(10);
/* 1993 */         return new JdbcClob(this, paramValue, i);
/*      */ 
/*      */       
/*      */       case 15:
/* 1997 */         i = getNextId(9);
/* 1998 */         return new JdbcBlob(this, paramValue, i);
/*      */ 
/*      */       
/*      */       case 19:
/* 2002 */         if (SysProperties.serializeJavaObject) {
/* 2003 */           return JdbcUtils.deserialize(paramValue.getBytesNoCopy(), this.session.getDataHandler());
/*      */         }
/*      */         break;
/*      */     } 
/* 2007 */     return paramValue.getObject();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   CompareMode getCompareMode() {
/* 2013 */     return this.session.getDataHandler().getCompareMode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTraceLevel(int paramInt) {
/* 2020 */     this.trace.setLevel(paramInt);
/*      */   }
/*      */   
/*      */   String getMode() throws SQLException {
/* 2024 */     if (this.mode == null) {
/* 2025 */       PreparedStatement preparedStatement = prepareStatement("SELECT VALUE FROM INFORMATION_SCHEMA.SETTINGS WHERE NAME=?");
/*      */       
/* 2027 */       preparedStatement.setString(1, "MODE");
/* 2028 */       ResultSet resultSet = preparedStatement.executeQuery();
/* 2029 */       resultSet.next();
/* 2030 */       this.mode = resultSet.getString(1);
/* 2031 */       preparedStatement.close();
/*      */     } 
/* 2033 */     return this.mode;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcConnection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */