/*     */ package org.h2.jdbcx;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import javax.sql.ConnectionEvent;
/*     */ import javax.sql.ConnectionEventListener;
/*     */ import javax.sql.StatementEventListener;
/*     */ import javax.sql.XAConnection;
/*     */ import javax.transaction.xa.XAException;
/*     */ import javax.transaction.xa.XAResource;
/*     */ import javax.transaction.xa.Xid;
/*     */ import org.h2.Driver;
/*     */ import org.h2.jdbc.JdbcConnection;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.TraceObject;
/*     */ import org.h2.util.New;
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
/*     */ 
/*     */ 
/*     */ public class JdbcXAConnection
/*     */   extends TraceObject
/*     */   implements XAConnection, XAResource
/*     */ {
/*     */   private final JdbcDataSourceFactory factory;
/*     */   private JdbcConnection physicalConn;
/*     */   private volatile Connection handleConn;
/*  42 */   private final ArrayList<ConnectionEventListener> listeners = New.arrayList();
/*     */   private Xid currentTransaction;
/*     */   private boolean prepared;
/*     */   
/*     */   static {
/*  47 */     Driver.load();
/*     */   }
/*     */ 
/*     */   
/*     */   JdbcXAConnection(JdbcDataSourceFactory paramJdbcDataSourceFactory, int paramInt, JdbcConnection paramJdbcConnection) {
/*  52 */     this.factory = paramJdbcDataSourceFactory;
/*  53 */     setTrace(paramJdbcDataSourceFactory.getTrace(), 13, paramInt);
/*  54 */     this.physicalConn = paramJdbcConnection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XAResource getXAResource() {
/*  64 */     debugCodeCall("getXAResource");
/*  65 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws SQLException {
/*  74 */     debugCodeCall("close");
/*  75 */     Connection connection = this.handleConn;
/*  76 */     if (connection != null) {
/*  77 */       this.listeners.clear();
/*  78 */       connection.close();
/*     */     } 
/*  80 */     if (this.physicalConn != null) {
/*     */       try {
/*  82 */         this.physicalConn.close();
/*     */       } finally {
/*  84 */         this.physicalConn = null;
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
/*     */   public Connection getConnection() throws SQLException {
/*  98 */     debugCodeCall("getConnection");
/*  99 */     Connection connection = this.handleConn;
/* 100 */     if (connection != null) {
/* 101 */       connection.close();
/*     */     }
/*     */     
/* 104 */     this.physicalConn.rollback();
/* 105 */     this.handleConn = (Connection)new PooledJdbcConnection(this.physicalConn);
/* 106 */     return this.handleConn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addConnectionEventListener(ConnectionEventListener paramConnectionEventListener) {
/* 116 */     debugCode("addConnectionEventListener(listener);");
/* 117 */     this.listeners.add(paramConnectionEventListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeConnectionEventListener(ConnectionEventListener paramConnectionEventListener) {
/* 127 */     debugCode("removeConnectionEventListener(listener);");
/* 128 */     this.listeners.remove(paramConnectionEventListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void closedHandle() {
/* 135 */     debugCode("closedHandle();");
/* 136 */     ConnectionEvent connectionEvent = new ConnectionEvent(this);
/*     */ 
/*     */     
/* 139 */     for (int i = this.listeners.size() - 1; i >= 0; i--) {
/* 140 */       ConnectionEventListener connectionEventListener = this.listeners.get(i);
/* 141 */       connectionEventListener.connectionClosed(connectionEvent);
/*     */     } 
/* 143 */     this.handleConn = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTransactionTimeout() {
/* 153 */     debugCodeCall("getTransactionTimeout");
/* 154 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionTimeout(int paramInt) {
/* 165 */     debugCodeCall("setTransactionTimeout", paramInt);
/* 166 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSameRM(XAResource paramXAResource) {
/* 177 */     debugCode("isSameRM(xares);");
/* 178 */     return (paramXAResource == this);
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
/*     */   public Xid[] recover(int paramInt) throws XAException {
/* 191 */     debugCodeCall("recover", quoteFlags(paramInt));
/* 192 */     checkOpen();
/* 193 */     try (Statement null = this.physicalConn.createStatement()) {
/* 194 */       ResultSet resultSet = statement.executeQuery("SELECT * FROM INFORMATION_SCHEMA.IN_DOUBT ORDER BY TRANSACTION");
/*     */       
/* 196 */       ArrayList<JdbcXid> arrayList = New.arrayList();
/* 197 */       while (resultSet.next()) {
/* 198 */         String str = resultSet.getString("TRANSACTION");
/* 199 */         int i = getNextId(15);
/* 200 */         JdbcXid jdbcXid = new JdbcXid(this.factory, i, str);
/* 201 */         arrayList.add(jdbcXid);
/*     */       } 
/* 203 */       resultSet.close();
/* 204 */       Xid[] arrayOfXid = new Xid[arrayList.size()];
/* 205 */       arrayList.toArray(arrayOfXid);
/* 206 */       if (arrayList.size() > 0) {
/* 207 */         this.prepared = true;
/*     */       }
/* 209 */       return arrayOfXid;
/* 210 */     } catch (SQLException sQLException) {
/* 211 */       XAException xAException = new XAException(-3);
/* 212 */       xAException.initCause(sQLException);
/* 213 */       throw xAException;
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
/*     */   public int prepare(Xid paramXid) throws XAException {
/* 225 */     if (isDebugEnabled()) {
/* 226 */       debugCode("prepare(" + JdbcXid.toString(paramXid) + ");");
/*     */     }
/* 228 */     checkOpen();
/* 229 */     if (!this.currentTransaction.equals(paramXid)) {
/* 230 */       throw new XAException(-5);
/*     */     }
/*     */     
/* 233 */     try (Statement null = this.physicalConn.createStatement()) {
/* 234 */       statement.execute("PREPARE COMMIT " + JdbcXid.toString(paramXid));
/* 235 */       this.prepared = true;
/* 236 */     } catch (SQLException sQLException) {
/* 237 */       throw convertException(sQLException);
/*     */     } 
/* 239 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void forget(Xid paramXid) {
/* 250 */     if (isDebugEnabled()) {
/* 251 */       debugCode("forget(" + JdbcXid.toString(paramXid) + ");");
/*     */     }
/* 253 */     this.prepared = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback(Xid paramXid) throws XAException {
/* 263 */     if (isDebugEnabled()) {
/* 264 */       debugCode("rollback(" + JdbcXid.toString(paramXid) + ");");
/*     */     }
/*     */     try {
/* 267 */       if (this.prepared) {
/* 268 */         try (Statement null = this.physicalConn.createStatement()) {
/* 269 */           statement.execute("ROLLBACK TRANSACTION " + JdbcXid.toString(paramXid));
/*     */         } 
/* 271 */         this.prepared = false;
/*     */       } else {
/* 273 */         this.physicalConn.rollback();
/*     */       } 
/* 275 */       this.physicalConn.setAutoCommit(true);
/* 276 */     } catch (SQLException sQLException) {
/* 277 */       throw convertException(sQLException);
/*     */     } 
/* 279 */     this.currentTransaction = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void end(Xid paramXid, int paramInt) throws XAException {
/* 290 */     if (isDebugEnabled()) {
/* 291 */       debugCode("end(" + JdbcXid.toString(paramXid) + ", " + quoteFlags(paramInt) + ");");
/*     */     }
/*     */     
/* 294 */     if (paramInt == 33554432) {
/*     */       return;
/*     */     }
/* 297 */     if (!this.currentTransaction.equals(paramXid)) {
/* 298 */       throw new XAException(-9);
/*     */     }
/* 300 */     this.prepared = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start(Xid paramXid, int paramInt) throws XAException {
/* 311 */     if (isDebugEnabled()) {
/* 312 */       debugCode("start(" + JdbcXid.toString(paramXid) + ", " + quoteFlags(paramInt) + ");");
/*     */     }
/* 314 */     if (paramInt == 134217728) {
/*     */       return;
/*     */     }
/* 317 */     if (paramInt == 2097152) {
/* 318 */       if (this.currentTransaction != null && !this.currentTransaction.equals(paramXid)) {
/* 319 */         throw new XAException(-3);
/*     */       }
/* 321 */     } else if (this.currentTransaction != null) {
/* 322 */       throw new XAException(-4);
/*     */     } 
/*     */     try {
/* 325 */       this.physicalConn.setAutoCommit(false);
/* 326 */     } catch (SQLException sQLException) {
/* 327 */       throw convertException(sQLException);
/*     */     } 
/* 329 */     this.currentTransaction = paramXid;
/* 330 */     this.prepared = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void commit(Xid paramXid, boolean paramBoolean) throws XAException {
/* 341 */     if (isDebugEnabled()) {
/* 342 */       debugCode("commit(" + JdbcXid.toString(paramXid) + ", " + paramBoolean + ");");
/*     */     }
/*     */     
/*     */     try {
/* 346 */       if (paramBoolean) {
/* 347 */         this.physicalConn.commit();
/*     */       } else {
/* 349 */         try (Statement null = this.physicalConn.createStatement()) {
/* 350 */           statement.execute("COMMIT TRANSACTION " + JdbcXid.toString(paramXid));
/* 351 */           this.prepared = false;
/*     */         } 
/*     */       } 
/* 354 */       this.physicalConn.setAutoCommit(true);
/* 355 */     } catch (SQLException sQLException) {
/* 356 */       throw convertException(sQLException);
/*     */     } 
/* 358 */     this.currentTransaction = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addStatementEventListener(StatementEventListener paramStatementEventListener) {
/* 368 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeStatementEventListener(StatementEventListener paramStatementEventListener) {
/* 378 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 386 */     return getTraceObjectName() + ": " + this.physicalConn;
/*     */   }
/*     */   
/*     */   private static XAException convertException(SQLException paramSQLException) {
/* 390 */     XAException xAException = new XAException(paramSQLException.getMessage());
/* 391 */     xAException.initCause(paramSQLException);
/* 392 */     return xAException;
/*     */   }
/*     */   
/*     */   private static String quoteFlags(int paramInt) {
/* 396 */     StringBuilder stringBuilder = new StringBuilder();
/* 397 */     if ((paramInt & 0x800000) != 0) {
/* 398 */       stringBuilder.append("|XAResource.TMENDRSCAN");
/*     */     }
/* 400 */     if ((paramInt & 0x20000000) != 0) {
/* 401 */       stringBuilder.append("|XAResource.TMFAIL");
/*     */     }
/* 403 */     if ((paramInt & 0x200000) != 0) {
/* 404 */       stringBuilder.append("|XAResource.TMJOIN");
/*     */     }
/* 406 */     if ((paramInt & 0x40000000) != 0) {
/* 407 */       stringBuilder.append("|XAResource.TMONEPHASE");
/*     */     }
/* 409 */     if ((paramInt & 0x8000000) != 0) {
/* 410 */       stringBuilder.append("|XAResource.TMRESUME");
/*     */     }
/* 412 */     if ((paramInt & 0x1000000) != 0) {
/* 413 */       stringBuilder.append("|XAResource.TMSTARTRSCAN");
/*     */     }
/* 415 */     if ((paramInt & 0x4000000) != 0) {
/* 416 */       stringBuilder.append("|XAResource.TMSUCCESS");
/*     */     }
/* 418 */     if ((paramInt & 0x2000000) != 0) {
/* 419 */       stringBuilder.append("|XAResource.TMSUSPEND");
/*     */     }
/* 421 */     if ((paramInt & 0x3) != 0) {
/* 422 */       stringBuilder.append("|XAResource.XA_RDONLY");
/*     */     }
/* 424 */     if (stringBuilder.length() == 0) {
/* 425 */       stringBuilder.append("|XAResource.TMNOFLAGS");
/*     */     }
/* 427 */     return stringBuilder.toString().substring(1);
/*     */   }
/*     */   
/*     */   private void checkOpen() throws XAException {
/* 431 */     if (this.physicalConn == null) {
/* 432 */       throw new XAException(-3);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   class PooledJdbcConnection
/*     */     extends JdbcConnection
/*     */   {
/*     */     private boolean isClosed;
/*     */ 
/*     */     
/*     */     public PooledJdbcConnection(JdbcConnection param1JdbcConnection) {
/* 444 */       super(param1JdbcConnection);
/*     */     }
/*     */ 
/*     */     
/*     */     public synchronized void close() throws SQLException {
/* 449 */       if (!this.isClosed) {
/*     */         try {
/* 451 */           rollback();
/* 452 */           setAutoCommit(true);
/* 453 */         } catch (SQLException sQLException) {}
/*     */ 
/*     */         
/* 456 */         JdbcXAConnection.this.closedHandle();
/* 457 */         this.isClosed = true;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public synchronized boolean isClosed() throws SQLException {
/* 463 */       return (this.isClosed || super.isClosed());
/*     */     }
/*     */ 
/*     */     
/*     */     protected synchronized void checkClosed(boolean param1Boolean) {
/* 468 */       if (this.isClosed) {
/* 469 */         throw DbException.get(90007);
/*     */       }
/* 471 */       super.checkClosed(param1Boolean);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbcx\JdbcXAConnection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */