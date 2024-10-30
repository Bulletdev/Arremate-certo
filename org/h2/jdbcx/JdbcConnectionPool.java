/*     */ package org.h2.jdbcx;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Logger;
/*     */ import javax.sql.ConnectionEvent;
/*     */ import javax.sql.ConnectionEventListener;
/*     */ import javax.sql.ConnectionPoolDataSource;
/*     */ import javax.sql.DataSource;
/*     */ import javax.sql.PooledConnection;
/*     */ import org.h2.message.DbException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JdbcConnectionPool
/*     */   implements ConnectionEventListener, DataSource, JdbcConnectionPoolBackwardsCompat
/*     */ {
/*     */   private static final int DEFAULT_TIMEOUT = 30;
/*     */   private static final int DEFAULT_MAX_CONNECTIONS = 10;
/*     */   private final ConnectionPoolDataSource dataSource;
/*  69 */   private final ArrayList<PooledConnection> recycledConnections = New.arrayList();
/*     */   private PrintWriter logWriter;
/*  71 */   private int maxConnections = 10;
/*  72 */   private int timeout = 30;
/*     */   private int activeConnections;
/*     */   private boolean isDisposed;
/*     */   
/*     */   protected JdbcConnectionPool(ConnectionPoolDataSource paramConnectionPoolDataSource) {
/*  77 */     this.dataSource = paramConnectionPoolDataSource;
/*  78 */     if (paramConnectionPoolDataSource != null) {
/*     */       try {
/*  80 */         this.logWriter = paramConnectionPoolDataSource.getLogWriter();
/*  81 */       } catch (SQLException sQLException) {}
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
/*     */   public static JdbcConnectionPool create(ConnectionPoolDataSource paramConnectionPoolDataSource) {
/*  94 */     return new JdbcConnectionPool(paramConnectionPoolDataSource);
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
/*     */   public static JdbcConnectionPool create(String paramString1, String paramString2, String paramString3) {
/* 107 */     JdbcDataSource jdbcDataSource = new JdbcDataSource();
/* 108 */     jdbcDataSource.setURL(paramString1);
/* 109 */     jdbcDataSource.setUser(paramString2);
/* 110 */     jdbcDataSource.setPassword(paramString3);
/* 111 */     return new JdbcConnectionPool(jdbcDataSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void setMaxConnections(int paramInt) {
/* 121 */     if (paramInt < 1) {
/* 122 */       throw new IllegalArgumentException("Invalid maxConnections value: " + paramInt);
/*     */     }
/* 124 */     this.maxConnections = paramInt;
/*     */     
/* 126 */     notifyAll();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int getMaxConnections() {
/* 135 */     return this.maxConnections;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int getLoginTimeout() {
/* 145 */     return this.timeout;
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
/*     */   public synchronized void setLoginTimeout(int paramInt) {
/* 157 */     if (paramInt == 0) {
/* 158 */       paramInt = 30;
/*     */     }
/* 160 */     this.timeout = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void dispose() {
/* 168 */     if (this.isDisposed) {
/*     */       return;
/*     */     }
/* 171 */     this.isDisposed = true;
/* 172 */     ArrayList<PooledConnection> arrayList = this.recycledConnections; byte b; int i;
/* 173 */     for (b = 0, i = arrayList.size(); b < i; b++) {
/* 174 */       closeConnection(arrayList.get(b));
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
/*     */ 
/*     */   
/*     */   public Connection getConnection() throws SQLException {
/* 193 */     long l = System.currentTimeMillis() + (this.timeout * 1000);
/*     */     while (true) {
/* 195 */       synchronized (this) {
/* 196 */         if (this.activeConnections < this.maxConnections) {
/* 197 */           return getConnectionNow();
/*     */         }
/*     */         try {
/* 200 */           wait(1000L);
/* 201 */         } catch (InterruptedException interruptedException) {}
/*     */       } 
/*     */ 
/*     */       
/* 205 */       if (System.currentTimeMillis() > l) {
/* 206 */         throw new SQLException("Login timeout", "08001", 8001);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection(String paramString1, String paramString2) {
/* 214 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   private Connection getConnectionNow() throws SQLException {
/*     */     PooledConnection pooledConnection;
/* 218 */     if (this.isDisposed) {
/* 219 */       throw new IllegalStateException("Connection pool has been disposed.");
/*     */     }
/*     */     
/* 222 */     if (!this.recycledConnections.isEmpty()) {
/* 223 */       pooledConnection = this.recycledConnections.remove(this.recycledConnections.size() - 1);
/*     */     } else {
/* 225 */       pooledConnection = this.dataSource.getPooledConnection();
/*     */     } 
/* 227 */     Connection connection = pooledConnection.getConnection();
/* 228 */     this.activeConnections++;
/* 229 */     pooledConnection.addConnectionEventListener(this);
/* 230 */     return connection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized void recycleConnection(PooledConnection paramPooledConnection) {
/* 241 */     if (this.activeConnections <= 0) {
/* 242 */       throw new AssertionError();
/*     */     }
/* 244 */     this.activeConnections--;
/* 245 */     if (!this.isDisposed && this.activeConnections < this.maxConnections) {
/* 246 */       this.recycledConnections.add(paramPooledConnection);
/*     */     } else {
/* 248 */       closeConnection(paramPooledConnection);
/*     */     } 
/* 250 */     if (this.activeConnections >= this.maxConnections - 1) {
/* 251 */       notifyAll();
/*     */     }
/*     */   }
/*     */   
/*     */   private void closeConnection(PooledConnection paramPooledConnection) {
/*     */     try {
/* 257 */       paramPooledConnection.close();
/* 258 */     } catch (SQLException sQLException) {
/* 259 */       if (this.logWriter != null) {
/* 260 */         sQLException.printStackTrace(this.logWriter);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connectionClosed(ConnectionEvent paramConnectionEvent) {
/* 270 */     PooledConnection pooledConnection = (PooledConnection)paramConnectionEvent.getSource();
/* 271 */     pooledConnection.removeConnectionEventListener(this);
/* 272 */     recycleConnection(pooledConnection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connectionErrorOccurred(ConnectionEvent paramConnectionEvent) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int getActiveConnections() {
/* 292 */     return this.activeConnections;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrintWriter getLogWriter() {
/* 300 */     return this.logWriter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogWriter(PrintWriter paramPrintWriter) {
/* 308 */     this.logWriter = paramPrintWriter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T unwrap(Class<T> paramClass) throws SQLException {
/* 318 */     throw DbException.getUnsupportedException("unwrap");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWrapperFor(Class<?> paramClass) throws SQLException {
/* 328 */     throw DbException.getUnsupportedException("isWrapperFor");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger getParentLogger() {
/* 336 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbcx\JdbcConnectionPool.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */