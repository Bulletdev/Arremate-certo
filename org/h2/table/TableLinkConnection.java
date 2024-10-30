/*     */ package org.h2.table;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.HashMap;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Utils;
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
/*     */ public class TableLinkConnection
/*     */ {
/*     */   private final HashMap<TableLinkConnection, TableLinkConnection> map;
/*     */   private final String driver;
/*     */   private final String url;
/*     */   private final String user;
/*     */   private final String password;
/*     */   private Connection conn;
/*     */   private int useCounter;
/*     */   
/*     */   private TableLinkConnection(HashMap<TableLinkConnection, TableLinkConnection> paramHashMap, String paramString1, String paramString2, String paramString3, String paramString4) {
/*  45 */     this.map = paramHashMap;
/*  46 */     this.driver = paramString1;
/*  47 */     this.url = paramString2;
/*  48 */     this.user = paramString3;
/*  49 */     this.password = paramString4;
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
/*     */   
/*     */   public static TableLinkConnection open(HashMap<TableLinkConnection, TableLinkConnection> paramHashMap, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
/*  68 */     TableLinkConnection tableLinkConnection = new TableLinkConnection(paramHashMap, paramString1, paramString2, paramString3, paramString4);
/*     */     
/*  70 */     if (!paramBoolean) {
/*  71 */       tableLinkConnection.open();
/*  72 */       return tableLinkConnection;
/*     */     } 
/*  74 */     synchronized (paramHashMap) {
/*  75 */       TableLinkConnection tableLinkConnection1 = paramHashMap.get(tableLinkConnection);
/*  76 */       if (tableLinkConnection1 == null) {
/*  77 */         tableLinkConnection.open();
/*     */ 
/*     */         
/*  80 */         paramHashMap.put(tableLinkConnection, tableLinkConnection);
/*  81 */         tableLinkConnection1 = tableLinkConnection;
/*     */       } 
/*  83 */       tableLinkConnection1.useCounter++;
/*  84 */       return tableLinkConnection1;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void open() {
/*     */     try {
/*  90 */       this.conn = JdbcUtils.getConnection(this.driver, this.url, this.user, this.password);
/*  91 */     } catch (SQLException sQLException) {
/*  92 */       throw DbException.convert(sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  98 */     return Utils.hashCode(this.driver) ^ Utils.hashCode(this.url) ^ Utils.hashCode(this.user) ^ Utils.hashCode(this.password);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 106 */     if (paramObject instanceof TableLinkConnection) {
/* 107 */       TableLinkConnection tableLinkConnection = (TableLinkConnection)paramObject;
/* 108 */       return (StringUtils.equals(this.driver, tableLinkConnection.driver) && StringUtils.equals(this.url, tableLinkConnection.url) && StringUtils.equals(this.user, tableLinkConnection.user) && StringUtils.equals(this.password, tableLinkConnection.password));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 113 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Connection getConnection() {
/* 124 */     return this.conn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void close(boolean paramBoolean) {
/* 134 */     boolean bool = false;
/* 135 */     synchronized (this.map) {
/* 136 */       if (--this.useCounter <= 0 || paramBoolean) {
/* 137 */         bool = true;
/* 138 */         this.map.remove(this);
/*     */       } 
/*     */     } 
/* 141 */     if (bool)
/* 142 */       JdbcUtils.closeSilently(this.conn); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\TableLinkConnection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */