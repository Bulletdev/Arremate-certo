/*     */ package org.h2.fulltext;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.SoftHashMap;
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
/*     */ class FullTextSettings
/*     */ {
/*  26 */   private static final HashMap<String, FullTextSettings> SETTINGS = New.hashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean initialized;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   private final HashSet<String> ignoreList = New.hashSet();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   private final HashMap<String, Integer> words = New.hashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   private final HashMap<Integer, IndexInfo> indexes = New.hashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   private final SoftHashMap<Connection, SoftHashMap<String, PreparedStatement>> cache = new SoftHashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   private String whitespaceChars = " \t\n\r\f+\"*%&/()=?'!,.;:-_#@|^~`{}[]<>\\";
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
/*     */   protected HashSet<String> getIgnoreList() {
/*  73 */     return this.ignoreList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HashMap<String, Integer> getWordList() {
/*  82 */     return this.words;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IndexInfo getIndexInfo(int paramInt) {
/*  92 */     return this.indexes.get(Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addIndexInfo(IndexInfo paramIndexInfo) {
/* 101 */     this.indexes.put(Integer.valueOf(paramIndexInfo.id), paramIndexInfo);
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
/*     */   protected String convertWord(String paramString) {
/* 113 */     paramString = paramString.toUpperCase();
/* 114 */     if (this.ignoreList.contains(paramString)) {
/* 115 */       return null;
/*     */     }
/* 117 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static FullTextSettings getInstance(Connection paramConnection) throws SQLException {
/* 128 */     String str = getIndexPath(paramConnection);
/* 129 */     FullTextSettings fullTextSettings = SETTINGS.get(str);
/* 130 */     if (fullTextSettings == null) {
/* 131 */       fullTextSettings = new FullTextSettings();
/* 132 */       SETTINGS.put(str, fullTextSettings);
/*     */     } 
/* 134 */     return fullTextSettings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String getIndexPath(Connection paramConnection) throws SQLException {
/* 144 */     Statement statement = paramConnection.createStatement();
/* 145 */     ResultSet resultSet = statement.executeQuery("CALL IFNULL(DATABASE_PATH(), 'MEM:' || DATABASE())");
/*     */     
/* 147 */     resultSet.next();
/* 148 */     String str = resultSet.getString(1);
/* 149 */     if ("MEM:UNNAMED".equals(str)) {
/* 150 */       throw FullText.throwException("Fulltext search for private (unnamed) in-memory databases is not supported.");
/*     */     }
/*     */ 
/*     */     
/* 154 */     resultSet.close();
/* 155 */     return str;
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
/*     */   protected synchronized PreparedStatement prepare(Connection paramConnection, String paramString) throws SQLException {
/* 167 */     SoftHashMap softHashMap = (SoftHashMap)this.cache.get(paramConnection);
/* 168 */     if (softHashMap == null) {
/* 169 */       softHashMap = new SoftHashMap();
/* 170 */       this.cache.put(paramConnection, softHashMap);
/*     */     } 
/* 172 */     PreparedStatement preparedStatement = (PreparedStatement)softHashMap.get(paramString);
/* 173 */     if (preparedStatement != null && preparedStatement.getConnection().isClosed()) {
/* 174 */       preparedStatement = null;
/*     */     }
/* 176 */     if (preparedStatement == null) {
/* 177 */       preparedStatement = paramConnection.prepareStatement(paramString);
/* 178 */       softHashMap.put(paramString, preparedStatement);
/*     */     } 
/* 180 */     return preparedStatement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAllIndexes() {
/* 187 */     this.indexes.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeIndexInfo(IndexInfo paramIndexInfo) {
/* 196 */     this.indexes.remove(Integer.valueOf(paramIndexInfo.id));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setInitialized(boolean paramBoolean) {
/* 205 */     this.initialized = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isInitialized() {
/* 214 */     return this.initialized;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void closeAll() {
/* 221 */     SETTINGS.clear();
/*     */   }
/*     */   
/*     */   protected void setWhitespaceChars(String paramString) {
/* 225 */     this.whitespaceChars = paramString;
/*     */   }
/*     */   
/*     */   protected String getWhitespaceChars() {
/* 229 */     return this.whitespaceChars;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\fulltext\FullTextSettings.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */