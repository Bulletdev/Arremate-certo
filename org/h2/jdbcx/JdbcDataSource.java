/*     */ package org.h2.jdbcx;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Serializable;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Properties;
/*     */ import java.util.logging.Logger;
/*     */ import javax.naming.Reference;
/*     */ import javax.naming.Referenceable;
/*     */ import javax.naming.StringRefAddr;
/*     */ import javax.sql.ConnectionPoolDataSource;
/*     */ import javax.sql.DataSource;
/*     */ import javax.sql.PooledConnection;
/*     */ import javax.sql.XAConnection;
/*     */ import javax.sql.XADataSource;
/*     */ import org.h2.Driver;
/*     */ import org.h2.jdbc.JdbcConnection;
/*     */ import org.h2.message.TraceObject;
/*     */ import org.h2.util.StringUtils;
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
/*     */ public class JdbcDataSource
/*     */   extends TraceObject
/*     */   implements Serializable, Referenceable, ConnectionPoolDataSource, DataSource, XADataSource, JdbcDataSourceBackwardsCompat
/*     */ {
/*     */   private static final long serialVersionUID = 1288136338451857771L;
/*     */   private transient JdbcDataSourceFactory factory;
/*     */   private transient PrintWriter logWriter;
/*     */   private int loginTimeout;
/*  71 */   private String userName = "";
/*  72 */   private char[] passwordChars = new char[0];
/*  73 */   private String url = "";
/*     */   private String description;
/*     */   
/*     */   static {
/*  77 */     Driver.load();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JdbcDataSource() {
/*  84 */     initFactory();
/*  85 */     int i = getNextId(12);
/*  86 */     setTrace(this.factory.getTrace(), 12, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/*  96 */     initFactory();
/*  97 */     paramObjectInputStream.defaultReadObject();
/*     */   }
/*     */   
/*     */   private void initFactory() {
/* 101 */     this.factory = new JdbcDataSourceFactory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLoginTimeout() {
/* 111 */     debugCodeCall("getLoginTimeout");
/* 112 */     return this.loginTimeout;
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
/*     */   public void setLoginTimeout(int paramInt) {
/* 124 */     debugCodeCall("setLoginTimeout", paramInt);
/* 125 */     this.loginTimeout = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrintWriter getLogWriter() {
/* 135 */     debugCodeCall("getLogWriter");
/* 136 */     return this.logWriter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogWriter(PrintWriter paramPrintWriter) {
/* 147 */     debugCodeCall("setLogWriter(out)");
/* 148 */     this.logWriter = paramPrintWriter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection() throws SQLException {
/* 158 */     debugCodeCall("getConnection");
/* 159 */     return (Connection)getJdbcConnection(this.userName, StringUtils.cloneCharArray(this.passwordChars));
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
/*     */   public Connection getConnection(String paramString1, String paramString2) throws SQLException {
/* 174 */     if (isDebugEnabled()) {
/* 175 */       debugCode("getConnection(" + quote(paramString1) + ", \"\");");
/*     */     }
/* 177 */     return (Connection)getJdbcConnection(paramString1, convertToCharArray(paramString2));
/*     */   }
/*     */ 
/*     */   
/*     */   private JdbcConnection getJdbcConnection(String paramString, char[] paramArrayOfchar) throws SQLException {
/* 182 */     if (isDebugEnabled()) {
/* 183 */       debugCode("getJdbcConnection(" + quote(paramString) + ", new char[0]);");
/*     */     }
/* 185 */     Properties properties = new Properties();
/* 186 */     properties.setProperty("user", paramString);
/* 187 */     properties.put("password", paramArrayOfchar);
/* 188 */     Connection connection = Driver.load().connect(this.url, properties);
/* 189 */     if (connection == null) {
/* 190 */       throw new SQLException("No suitable driver found for " + this.url, "08001", 8001);
/*     */     }
/* 192 */     if (!(connection instanceof JdbcConnection)) {
/* 193 */       throw new SQLException("Connecting with old version is not supported: " + this.url, "08001", 8001);
/*     */     }
/*     */ 
/*     */     
/* 197 */     return (JdbcConnection)connection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getURL() {
/* 206 */     debugCodeCall("getURL");
/* 207 */     return this.url;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setURL(String paramString) {
/* 216 */     debugCodeCall("setURL", paramString);
/* 217 */     this.url = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUrl() {
/* 228 */     debugCodeCall("getUrl");
/* 229 */     return this.url;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUrl(String paramString) {
/* 240 */     debugCodeCall("setUrl", paramString);
/* 241 */     this.url = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPassword(String paramString) {
/* 250 */     debugCodeCall("setPassword", "");
/* 251 */     this.passwordChars = convertToCharArray(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPasswordChars(char[] paramArrayOfchar) {
/* 260 */     if (isDebugEnabled()) {
/* 261 */       debugCode("setPasswordChars(new char[0]);");
/*     */     }
/* 263 */     this.passwordChars = paramArrayOfchar;
/*     */   }
/*     */   
/*     */   private static char[] convertToCharArray(String paramString) {
/* 267 */     return (paramString == null) ? null : paramString.toCharArray();
/*     */   }
/*     */   
/*     */   private static String convertToString(char[] paramArrayOfchar) {
/* 271 */     return (paramArrayOfchar == null) ? null : new String(paramArrayOfchar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPassword() {
/* 280 */     debugCodeCall("getPassword");
/* 281 */     return convertToString(this.passwordChars);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUser() {
/* 290 */     debugCodeCall("getUser");
/* 291 */     return this.userName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUser(String paramString) {
/* 300 */     debugCodeCall("setUser", paramString);
/* 301 */     this.userName = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 310 */     debugCodeCall("getDescription");
/* 311 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String paramString) {
/* 320 */     debugCodeCall("getDescription", paramString);
/* 321 */     this.description = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Reference getReference() {
/* 331 */     debugCodeCall("getReference");
/* 332 */     String str = JdbcDataSourceFactory.class.getName();
/* 333 */     Reference reference = new Reference(getClass().getName(), str, null);
/* 334 */     reference.add(new StringRefAddr("url", this.url));
/* 335 */     reference.add(new StringRefAddr("user", this.userName));
/* 336 */     reference.add(new StringRefAddr("password", convertToString(this.passwordChars)));
/* 337 */     reference.add(new StringRefAddr("loginTimeout", String.valueOf(this.loginTimeout)));
/* 338 */     reference.add(new StringRefAddr("description", this.description));
/* 339 */     return reference;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XAConnection getXAConnection() throws SQLException {
/* 349 */     debugCodeCall("getXAConnection");
/* 350 */     int i = getNextId(13);
/* 351 */     return new JdbcXAConnection(this.factory, i, getJdbcConnection(this.userName, StringUtils.cloneCharArray(this.passwordChars)));
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
/*     */   public XAConnection getXAConnection(String paramString1, String paramString2) throws SQLException {
/* 366 */     if (isDebugEnabled()) {
/* 367 */       debugCode("getXAConnection(" + quote(paramString1) + ", \"\");");
/*     */     }
/* 369 */     int i = getNextId(13);
/* 370 */     return new JdbcXAConnection(this.factory, i, getJdbcConnection(paramString1, convertToCharArray(paramString2)));
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
/*     */   public PooledConnection getPooledConnection() throws SQLException {
/* 382 */     debugCodeCall("getPooledConnection");
/* 383 */     return getXAConnection();
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
/*     */   public PooledConnection getPooledConnection(String paramString1, String paramString2) throws SQLException {
/* 397 */     if (isDebugEnabled()) {
/* 398 */       debugCode("getPooledConnection(" + quote(paramString1) + ", \"\");");
/*     */     }
/* 400 */     return getXAConnection(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T unwrap(Class<T> paramClass) throws SQLException {
/* 410 */     throw unsupported("unwrap");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWrapperFor(Class<?> paramClass) throws SQLException {
/* 420 */     throw unsupported("isWrapperFor");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger getParentLogger() {
/* 428 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 436 */     return getTraceObjectName() + ": url=" + this.url + " user=" + this.userName;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbcx\JdbcDataSource.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */