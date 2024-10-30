/*     */ package org.h2.server.web;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import org.h2.bnf.Bnf;
/*     */ import org.h2.bnf.context.DbContents;
/*     */ import org.h2.bnf.context.DbContextRule;
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
/*     */ class WebSession
/*     */ {
/*     */   private static final int MAX_HISTORY = 1000;
/*     */   long lastAccess;
/*  40 */   final HashMap<String, Object> map = New.hashMap();
/*     */ 
/*     */   
/*     */   Locale locale;
/*     */ 
/*     */   
/*     */   Statement executingStatement;
/*     */ 
/*     */   
/*     */   ResultSet result;
/*     */ 
/*     */   
/*     */   private final WebServer server;
/*     */ 
/*     */   
/*     */   private final ArrayList<String> commandHistory;
/*     */ 
/*     */   
/*     */   private Connection conn;
/*     */ 
/*     */   
/*     */   private DatabaseMetaData meta;
/*     */   
/*  63 */   private DbContents contents = new DbContents();
/*     */   private Bnf bnf;
/*     */   private boolean shutdownServerOnDisconnect;
/*     */   
/*     */   WebSession(WebServer paramWebServer) {
/*  68 */     this.server = paramWebServer;
/*     */ 
/*     */ 
/*     */     
/*  72 */     this.commandHistory = paramWebServer.getCommandHistoryList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void put(String paramString, Object paramObject) {
/*  82 */     this.map.put(paramString, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object get(String paramString) {
/*  92 */     if ("sessions".equals(paramString)) {
/*  93 */       return this.server.getSessions();
/*     */     }
/*  95 */     return this.map.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void remove(String paramString) {
/* 104 */     this.map.remove(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Bnf getBnf() {
/* 113 */     return this.bnf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void loadBnf() {
/*     */     try {
/* 121 */       Bnf bnf = Bnf.getInstance(null);
/* 122 */       DbContextRule dbContextRule1 = new DbContextRule(this.contents, 0);
/*     */       
/* 124 */       DbContextRule dbContextRule2 = new DbContextRule(this.contents, 3);
/*     */       
/* 126 */       DbContextRule dbContextRule3 = new DbContextRule(this.contents, 2);
/*     */       
/* 128 */       DbContextRule dbContextRule4 = new DbContextRule(this.contents, 1);
/*     */       
/* 130 */       DbContextRule dbContextRule5 = new DbContextRule(this.contents, 5);
/*     */       
/* 132 */       DbContextRule dbContextRule6 = new DbContextRule(this.contents, 4);
/*     */       
/* 134 */       DbContextRule dbContextRule7 = new DbContextRule(this.contents, 6);
/*     */       
/* 136 */       bnf.updateTopic("procedure", dbContextRule7);
/* 137 */       bnf.updateTopic("column_name", dbContextRule1);
/* 138 */       bnf.updateTopic("new_table_alias", dbContextRule2);
/* 139 */       bnf.updateTopic("table_alias", dbContextRule3);
/* 140 */       bnf.updateTopic("column_alias", dbContextRule6);
/* 141 */       bnf.updateTopic("table_name", dbContextRule4);
/* 142 */       bnf.updateTopic("schema_name", dbContextRule5);
/* 143 */       bnf.linkStatements();
/* 144 */       this.bnf = bnf;
/* 145 */     } catch (Exception exception) {
/*     */       
/* 147 */       this.server.traceError(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getCommand(int paramInt) {
/* 158 */     return this.commandHistory.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void addCommand(String paramString) {
/* 167 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 170 */     paramString = paramString.trim();
/* 171 */     if (paramString.length() == 0) {
/*     */       return;
/*     */     }
/* 174 */     if (this.commandHistory.size() > 1000) {
/* 175 */       this.commandHistory.remove(0);
/*     */     }
/* 177 */     int i = this.commandHistory.indexOf(paramString);
/* 178 */     if (i >= 0) {
/* 179 */       this.commandHistory.remove(i);
/*     */     }
/* 181 */     this.commandHistory.add(paramString);
/* 182 */     if (this.server.isCommandHistoryAllowed()) {
/* 183 */       this.server.saveCommandHistoryList(this.commandHistory);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ArrayList<String> getCommandHistory() {
/* 193 */     return this.commandHistory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   HashMap<String, Object> getInfo() {
/* 202 */     HashMap<String, Object> hashMap = New.hashMap();
/* 203 */     hashMap.putAll(this.map);
/* 204 */     hashMap.put("lastAccess", (new Timestamp(this.lastAccess)).toString());
/*     */     try {
/* 206 */       hashMap.put("url", (this.conn == null) ? "${text.admin.notConnected}" : this.conn.getMetaData().getURL());
/*     */       
/* 208 */       hashMap.put("user", (this.conn == null) ? "-" : this.conn.getMetaData().getUserName());
/*     */       
/* 210 */       hashMap.put("lastQuery", (this.commandHistory.size() == 0) ? "" : this.commandHistory.get(0));
/*     */       
/* 212 */       hashMap.put("executing", (this.executingStatement == null) ? "${text.admin.no}" : "${text.admin.yes}");
/*     */     }
/* 214 */     catch (SQLException sQLException) {
/* 215 */       DbException.traceThrowable(sQLException);
/*     */     } 
/* 217 */     return hashMap;
/*     */   }
/*     */   
/*     */   void setConnection(Connection paramConnection) throws SQLException {
/* 221 */     this.conn = paramConnection;
/* 222 */     if (paramConnection == null) {
/* 223 */       this.meta = null;
/*     */     } else {
/* 225 */       this.meta = paramConnection.getMetaData();
/*     */     } 
/* 227 */     this.contents = new DbContents();
/*     */   }
/*     */   
/*     */   DatabaseMetaData getMetaData() {
/* 231 */     return this.meta;
/*     */   }
/*     */   
/*     */   Connection getConnection() {
/* 235 */     return this.conn;
/*     */   }
/*     */   
/*     */   DbContents getContents() {
/* 239 */     return this.contents;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setShutdownServerOnDisconnect() {
/* 246 */     this.shutdownServerOnDisconnect = true;
/*     */   }
/*     */   
/*     */   boolean getShutdownServerOnDisconnect() {
/* 250 */     return this.shutdownServerOnDisconnect;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void close() {
/* 258 */     if (this.executingStatement != null) {
/*     */       try {
/* 260 */         this.executingStatement.cancel();
/* 261 */       } catch (Exception exception) {}
/*     */     }
/*     */ 
/*     */     
/* 265 */     if (this.conn != null)
/*     */       try {
/* 267 */         this.conn.close();
/* 268 */       } catch (Exception exception) {} 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\web\WebSession.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */