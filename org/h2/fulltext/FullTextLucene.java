/*     */ package org.h2.fulltext;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.apache.lucene.analysis.Analyzer;
/*     */ import org.apache.lucene.analysis.standard.StandardAnalyzer;
/*     */ import org.apache.lucene.document.DateTools;
/*     */ import org.apache.lucene.document.Document;
/*     */ import org.apache.lucene.document.Field;
/*     */ import org.apache.lucene.document.Fieldable;
/*     */ import org.apache.lucene.index.IndexReader;
/*     */ import org.apache.lucene.index.IndexWriter;
/*     */ import org.apache.lucene.index.IndexWriterConfig;
/*     */ import org.apache.lucene.index.Term;
/*     */ import org.apache.lucene.queryParser.QueryParser;
/*     */ import org.apache.lucene.search.IndexSearcher;
/*     */ import org.apache.lucene.search.Query;
/*     */ import org.apache.lucene.search.ScoreDoc;
/*     */ import org.apache.lucene.search.TopDocs;
/*     */ import org.apache.lucene.store.Directory;
/*     */ import org.apache.lucene.store.FSDirectory;
/*     */ import org.apache.lucene.store.RAMDirectory;
/*     */ import org.apache.lucene.util.Version;
/*     */ import org.h2.api.Trigger;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.ExpressionColumn;
/*     */ import org.h2.jdbc.JdbcConnection;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.tools.SimpleResultSet;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StatementBuilder;
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
/*     */ public class FullTextLucene
/*     */   extends FullText
/*     */ {
/*  57 */   protected static final boolean STORE_DOCUMENT_TEXT_IN_INDEX = Utils.getProperty("h2.storeDocumentTextInIndex", false);
/*     */ 
/*     */   
/*  60 */   private static final HashMap<String, IndexAccess> INDEX_ACCESS = New.hashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String TRIGGER_PREFIX = "FTL_";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String SCHEMA = "FTL";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String LUCENE_FIELD_DATA = "_DATA";
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String LUCENE_FIELD_QUERY = "_QUERY";
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String LUCENE_FIELD_MODIFIED = "_modified";
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String LUCENE_FIELD_COLUMN_PREFIX = "_";
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String IN_MEMORY_PREFIX = "mem:";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void init(Connection paramConnection) throws SQLException {
/*  97 */     Statement statement = paramConnection.createStatement();
/*  98 */     statement.execute("CREATE SCHEMA IF NOT EXISTS FTL");
/*  99 */     statement.execute("CREATE TABLE IF NOT EXISTS FTL.INDEXES(SCHEMA VARCHAR, TABLE VARCHAR, COLUMNS VARCHAR, PRIMARY KEY(SCHEMA, TABLE))");
/*     */ 
/*     */     
/* 102 */     statement.execute("CREATE ALIAS IF NOT EXISTS FTL_CREATE_INDEX FOR \"" + FullTextLucene.class.getName() + ".createIndex\"");
/*     */     
/* 104 */     statement.execute("CREATE ALIAS IF NOT EXISTS FTL_DROP_INDEX FOR \"" + FullTextLucene.class.getName() + ".dropIndex\"");
/*     */     
/* 106 */     statement.execute("CREATE ALIAS IF NOT EXISTS FTL_SEARCH FOR \"" + FullTextLucene.class.getName() + ".search\"");
/*     */     
/* 108 */     statement.execute("CREATE ALIAS IF NOT EXISTS FTL_SEARCH_DATA FOR \"" + FullTextLucene.class.getName() + ".searchData\"");
/*     */     
/* 110 */     statement.execute("CREATE ALIAS IF NOT EXISTS FTL_REINDEX FOR \"" + FullTextLucene.class.getName() + ".reindex\"");
/*     */     
/* 112 */     statement.execute("CREATE ALIAS IF NOT EXISTS FTL_DROP_ALL FOR \"" + FullTextLucene.class.getName() + ".dropAll\"");
/*     */     
/*     */     try {
/* 115 */       getIndexAccess(paramConnection);
/* 116 */     } catch (SQLException sQLException) {
/* 117 */       throw convertException(sQLException);
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
/*     */   public static void createIndex(Connection paramConnection, String paramString1, String paramString2, String paramString3) throws SQLException {
/* 132 */     init(paramConnection);
/* 133 */     PreparedStatement preparedStatement = paramConnection.prepareStatement("INSERT INTO FTL.INDEXES(SCHEMA, TABLE, COLUMNS) VALUES(?, ?, ?)");
/*     */     
/* 135 */     preparedStatement.setString(1, paramString1);
/* 136 */     preparedStatement.setString(2, paramString2);
/* 137 */     preparedStatement.setString(3, paramString3);
/* 138 */     preparedStatement.execute();
/* 139 */     createTrigger(paramConnection, paramString1, paramString2);
/* 140 */     indexExistingRows(paramConnection, paramString1, paramString2);
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
/*     */   public static void dropIndex(Connection paramConnection, String paramString1, String paramString2) throws SQLException {
/* 153 */     init(paramConnection);
/*     */     
/* 155 */     PreparedStatement preparedStatement = paramConnection.prepareStatement("DELETE FROM FTL.INDEXES WHERE SCHEMA=? AND TABLE=?");
/*     */     
/* 157 */     preparedStatement.setString(1, paramString1);
/* 158 */     preparedStatement.setString(2, paramString2);
/* 159 */     int i = preparedStatement.executeUpdate();
/* 160 */     if (i == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 164 */     reindex(paramConnection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reindex(Connection paramConnection) throws SQLException {
/* 174 */     init(paramConnection);
/* 175 */     removeAllTriggers(paramConnection, "FTL_");
/* 176 */     removeIndexFiles(paramConnection);
/* 177 */     Statement statement = paramConnection.createStatement();
/* 178 */     ResultSet resultSet = statement.executeQuery("SELECT * FROM FTL.INDEXES");
/* 179 */     while (resultSet.next()) {
/* 180 */       String str1 = resultSet.getString("SCHEMA");
/* 181 */       String str2 = resultSet.getString("TABLE");
/* 182 */       createTrigger(paramConnection, str1, str2);
/* 183 */       indexExistingRows(paramConnection, str1, str2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void dropAll(Connection paramConnection) throws SQLException {
/* 193 */     Statement statement = paramConnection.createStatement();
/* 194 */     statement.execute("DROP SCHEMA IF EXISTS FTL");
/* 195 */     removeAllTriggers(paramConnection, "FTL_");
/* 196 */     removeIndexFiles(paramConnection);
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
/*     */   
/*     */   public static ResultSet search(Connection paramConnection, String paramString, int paramInt1, int paramInt2) throws SQLException {
/* 216 */     return search(paramConnection, paramString, paramInt1, paramInt2, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ResultSet searchData(Connection paramConnection, String paramString, int paramInt1, int paramInt2) throws SQLException {
/* 241 */     return search(paramConnection, paramString, paramInt1, paramInt2, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static SQLException convertException(Exception paramException) {
/* 251 */     SQLException sQLException = new SQLException("Error while indexing document", "FULLTEXT");
/*     */     
/* 253 */     sQLException.initCause(paramException);
/* 254 */     return sQLException;
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
/*     */   protected static void createTrigger(Connection paramConnection, String paramString1, String paramString2) throws SQLException {
/* 266 */     createOrDropTrigger(paramConnection, paramString1, paramString2, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void createOrDropTrigger(Connection paramConnection, String paramString1, String paramString2, boolean paramBoolean) throws SQLException {
/* 271 */     Statement statement = paramConnection.createStatement();
/* 272 */     String str = StringUtils.quoteIdentifier(paramString1) + "." + StringUtils.quoteIdentifier("FTL_" + paramString2);
/*     */     
/* 274 */     statement.execute("DROP TRIGGER IF EXISTS " + str);
/* 275 */     if (paramBoolean) {
/* 276 */       StringBuilder stringBuilder = new StringBuilder("CREATE TRIGGER IF NOT EXISTS ");
/*     */ 
/*     */ 
/*     */       
/* 280 */       stringBuilder.append(str).append(" AFTER INSERT, UPDATE, DELETE, ROLLBACK ON ").append(StringUtils.quoteIdentifier(paramString1)).append('.').append(StringUtils.quoteIdentifier(paramString2)).append(" FOR EACH ROW CALL \"").append(FullTextTrigger.class.getName()).append('"');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 288 */       statement.execute(stringBuilder.toString());
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
/*     */   protected static IndexAccess getIndexAccess(Connection paramConnection) throws SQLException {
/* 300 */     String str = getIndexPath(paramConnection);
/* 301 */     synchronized (INDEX_ACCESS) {
/* 302 */       IndexAccess indexAccess = INDEX_ACCESS.get(str);
/* 303 */       if (indexAccess == null) {
/*     */         try {
/* 305 */           Directory directory = (Directory)(str.startsWith("mem:") ? new RAMDirectory() : FSDirectory.open(new File(str)));
/*     */           
/* 307 */           StandardAnalyzer standardAnalyzer = new StandardAnalyzer(Version.LUCENE_30);
/* 308 */           IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_30, (Analyzer)standardAnalyzer);
/* 309 */           indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
/* 310 */           IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
/*     */           
/* 312 */           IndexReader indexReader = IndexReader.open(indexWriter, true);
/* 313 */           indexAccess = new IndexAccess();
/* 314 */           indexAccess.writer = indexWriter;
/* 315 */           indexAccess.reader = indexReader;
/* 316 */           indexAccess.searcher = new IndexSearcher(indexReader);
/* 317 */         } catch (IOException iOException) {
/* 318 */           throw convertException(iOException);
/*     */         } 
/* 320 */         INDEX_ACCESS.put(str, indexAccess);
/*     */       } 
/* 322 */       return indexAccess;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String getIndexPath(Connection paramConnection) throws SQLException {
/* 333 */     Statement statement = paramConnection.createStatement();
/* 334 */     ResultSet resultSet = statement.executeQuery("CALL DATABASE_PATH()");
/* 335 */     resultSet.next();
/* 336 */     String str = resultSet.getString(1);
/* 337 */     if (str == null) {
/* 338 */       return "mem:" + paramConnection.getCatalog();
/*     */     }
/* 340 */     int i = str.lastIndexOf(':');
/*     */     
/* 342 */     if (i > 1) {
/* 343 */       str = str.substring(i + 1);
/*     */     }
/* 345 */     resultSet.close();
/* 346 */     return str;
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
/*     */   protected static void indexExistingRows(Connection paramConnection, String paramString1, String paramString2) throws SQLException {
/* 358 */     FullTextTrigger fullTextTrigger = new FullTextTrigger();
/* 359 */     fullTextTrigger.init(paramConnection, paramString1, null, paramString2, false, 1);
/* 360 */     String str = "SELECT * FROM " + StringUtils.quoteIdentifier(paramString1) + "." + StringUtils.quoteIdentifier(paramString2);
/*     */     
/* 362 */     ResultSet resultSet = paramConnection.createStatement().executeQuery(str);
/* 363 */     int i = resultSet.getMetaData().getColumnCount();
/* 364 */     while (resultSet.next()) {
/* 365 */       Object[] arrayOfObject = new Object[i];
/* 366 */       for (byte b = 0; b < i; b++) {
/* 367 */         arrayOfObject[b] = resultSet.getObject(b + 1);
/*     */       }
/* 369 */       fullTextTrigger.insert(arrayOfObject, false);
/*     */     } 
/* 371 */     fullTextTrigger.commitIndex();
/*     */   }
/*     */   
/*     */   private static void removeIndexFiles(Connection paramConnection) throws SQLException {
/* 375 */     String str = getIndexPath(paramConnection);
/* 376 */     IndexAccess indexAccess = INDEX_ACCESS.get(str);
/* 377 */     if (indexAccess != null) {
/* 378 */       removeIndexAccess(indexAccess, str);
/*     */     }
/* 380 */     if (!str.startsWith("mem:")) {
/* 381 */       FileUtils.deleteRecursive(str, false);
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
/*     */   protected static void removeIndexAccess(IndexAccess paramIndexAccess, String paramString) throws SQLException {
/* 394 */     synchronized (INDEX_ACCESS) {
/*     */       try {
/* 396 */         INDEX_ACCESS.remove(paramString);
/* 397 */         paramIndexAccess.searcher.close();
/* 398 */         paramIndexAccess.reader.close();
/* 399 */         paramIndexAccess.writer.close();
/* 400 */       } catch (Exception exception) {
/* 401 */         throw convertException(exception);
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected static ResultSet search(Connection paramConnection, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) throws SQLException {
/* 418 */     SimpleResultSet simpleResultSet = createResultSet(paramBoolean);
/* 419 */     if (paramConnection.getMetaData().getURL().startsWith("jdbc:columnlist:"))
/*     */     {
/* 421 */       return (ResultSet)simpleResultSet;
/*     */     }
/* 423 */     if (paramString == null || paramString.trim().length() == 0) {
/* 424 */       return (ResultSet)simpleResultSet;
/*     */     }
/*     */     try {
/* 427 */       IndexAccess indexAccess = getIndexAccess(paramConnection);
/*     */       
/* 429 */       IndexSearcher indexSearcher = indexAccess.searcher;
/*     */ 
/*     */       
/* 432 */       Analyzer analyzer = indexAccess.writer.getAnalyzer();
/* 433 */       QueryParser queryParser = new QueryParser(Version.LUCENE_30, "_DATA", analyzer);
/*     */       
/* 435 */       Query query = queryParser.parse(paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 440 */       int i = ((paramInt1 == 0) ? 100 : paramInt1) + paramInt2;
/* 441 */       TopDocs topDocs = indexSearcher.search(query, i);
/* 442 */       if (paramInt1 == 0) {
/* 443 */         paramInt1 = topDocs.totalHits;
/*     */       }
/* 445 */       byte b = 0; int j = topDocs.scoreDocs.length;
/*     */       
/* 447 */       for (; b < paramInt1 && b + paramInt2 < topDocs.totalHits && b + paramInt2 < j; b++) {
/* 448 */         ScoreDoc scoreDoc = topDocs.scoreDocs[b + paramInt2];
/* 449 */         Document document = indexSearcher.doc(scoreDoc.doc);
/* 450 */         float f = scoreDoc.score;
/* 451 */         String str = document.get("_QUERY");
/* 452 */         if (paramBoolean) {
/* 453 */           int k = str.indexOf(" WHERE ");
/* 454 */           JdbcConnection jdbcConnection = (JdbcConnection)paramConnection;
/* 455 */           Session session = (Session)jdbcConnection.getSession();
/* 456 */           Parser parser = new Parser(session);
/* 457 */           String str1 = str.substring(0, k);
/* 458 */           ExpressionColumn expressionColumn = (ExpressionColumn)parser.parseExpression(str1);
/* 459 */           String str2 = expressionColumn.getOriginalTableAliasName();
/* 460 */           String str3 = expressionColumn.getColumnName();
/* 461 */           str = str.substring(k + " WHERE ".length());
/* 462 */           Object[][] arrayOfObject = parseKey(paramConnection, str);
/* 463 */           simpleResultSet.addRow(new Object[] { str2, str3, arrayOfObject[0], arrayOfObject[1], Float.valueOf(f) });
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/* 470 */           simpleResultSet.addRow(new Object[] { str, Float.valueOf(f) });
/*     */         } 
/*     */       } 
/* 473 */     } catch (Exception exception) {
/* 474 */       throw convertException(exception);
/*     */     } 
/* 476 */     return (ResultSet)simpleResultSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class FullTextTrigger
/*     */     implements Trigger
/*     */   {
/*     */     protected String schema;
/*     */     
/*     */     protected String table;
/*     */     
/*     */     protected int[] keys;
/*     */     
/*     */     protected int[] indexColumns;
/*     */     
/*     */     protected String[] columns;
/*     */     
/*     */     protected int[] columnTypes;
/*     */     
/*     */     protected String indexPath;
/*     */     protected FullTextLucene.IndexAccess indexAccess;
/*     */     
/*     */     public void init(Connection param1Connection, String param1String1, String param1String2, String param1String3, boolean param1Boolean, int param1Int) throws SQLException {
/* 499 */       this.schema = param1String1;
/* 500 */       this.table = param1String3;
/* 501 */       this.indexPath = FullTextLucene.getIndexPath(param1Connection);
/* 502 */       this.indexAccess = FullTextLucene.getIndexAccess(param1Connection);
/* 503 */       ArrayList<String> arrayList1 = New.arrayList();
/* 504 */       DatabaseMetaData databaseMetaData = param1Connection.getMetaData();
/* 505 */       ResultSet resultSet = databaseMetaData.getColumns(null, StringUtils.escapeMetaDataPattern(param1String1), StringUtils.escapeMetaDataPattern(param1String3), null);
/*     */ 
/*     */ 
/*     */       
/* 509 */       ArrayList<String> arrayList2 = New.arrayList();
/* 510 */       while (resultSet.next()) {
/* 511 */         arrayList2.add(resultSet.getString("COLUMN_NAME"));
/*     */       }
/* 513 */       this.columnTypes = new int[arrayList2.size()];
/* 514 */       this.columns = new String[arrayList2.size()];
/* 515 */       arrayList2.toArray(this.columns);
/* 516 */       resultSet = databaseMetaData.getColumns(null, StringUtils.escapeMetaDataPattern(param1String1), StringUtils.escapeMetaDataPattern(param1String3), null);
/*     */ 
/*     */ 
/*     */       
/* 520 */       for (byte b = 0; resultSet.next(); b++) {
/* 521 */         this.columnTypes[b] = resultSet.getInt("DATA_TYPE");
/*     */       }
/* 523 */       if (arrayList1.size() == 0) {
/* 524 */         resultSet = databaseMetaData.getPrimaryKeys(null, StringUtils.escapeMetaDataPattern(param1String1), param1String3);
/*     */ 
/*     */         
/* 527 */         while (resultSet.next()) {
/* 528 */           arrayList1.add(resultSet.getString("COLUMN_NAME"));
/*     */         }
/*     */       } 
/* 531 */       if (arrayList1.size() == 0) {
/* 532 */         throw FullText.throwException("No primary key for table " + param1String3);
/*     */       }
/* 534 */       ArrayList<String> arrayList3 = New.arrayList();
/* 535 */       PreparedStatement preparedStatement = param1Connection.prepareStatement("SELECT COLUMNS FROM FTL.INDEXES WHERE SCHEMA=? AND TABLE=?");
/*     */ 
/*     */       
/* 538 */       preparedStatement.setString(1, param1String1);
/* 539 */       preparedStatement.setString(2, param1String3);
/* 540 */       resultSet = preparedStatement.executeQuery();
/* 541 */       if (resultSet.next()) {
/* 542 */         String str = resultSet.getString(1);
/* 543 */         if (str != null) {
/* 544 */           for (String str1 : StringUtils.arraySplit(str, ',', true)) {
/* 545 */             arrayList3.add(str1);
/*     */           }
/*     */         }
/*     */       } 
/* 549 */       if (arrayList3.size() == 0) {
/* 550 */         arrayList3.addAll(arrayList2);
/*     */       }
/* 552 */       this.keys = new int[arrayList1.size()];
/* 553 */       FullText.setColumns(this.keys, arrayList1, arrayList2);
/* 554 */       this.indexColumns = new int[arrayList3.size()];
/* 555 */       FullText.setColumns(this.indexColumns, arrayList3, arrayList2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void fire(Connection param1Connection, Object[] param1ArrayOfObject1, Object[] param1ArrayOfObject2) throws SQLException {
/* 564 */       if (param1ArrayOfObject1 != null) {
/* 565 */         if (param1ArrayOfObject2 != null) {
/*     */           
/* 567 */           if (FullText.hasChanged(param1ArrayOfObject1, param1ArrayOfObject2, this.indexColumns)) {
/* 568 */             delete(param1ArrayOfObject1, false);
/* 569 */             insert(param1ArrayOfObject2, true);
/*     */           } 
/*     */         } else {
/*     */           
/* 573 */           delete(param1ArrayOfObject1, true);
/*     */         } 
/* 575 */       } else if (param1ArrayOfObject2 != null) {
/*     */         
/* 577 */         insert(param1ArrayOfObject2, true);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void close() throws SQLException {
/* 586 */       if (this.indexAccess != null) {
/* 587 */         FullTextLucene.removeIndexAccess(this.indexAccess, this.indexPath);
/* 588 */         this.indexAccess = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void commitIndex() throws SQLException {
/*     */       try {
/* 605 */         this.indexAccess.writer.commit();
/*     */         
/* 607 */         this.indexAccess.searcher.close();
/* 608 */         this.indexAccess.reader.close();
/* 609 */         this.indexAccess.reader = IndexReader.open(this.indexAccess.writer, true);
/* 610 */         this.indexAccess.searcher = new IndexSearcher(this.indexAccess.reader);
/* 611 */       } catch (IOException iOException) {
/* 612 */         throw FullTextLucene.convertException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void insert(Object[] param1ArrayOfObject, boolean param1Boolean) throws SQLException {
/* 623 */       String str = getQuery(param1ArrayOfObject);
/* 624 */       Document document = new Document();
/* 625 */       document.add((Fieldable)new Field("_QUERY", str, Field.Store.YES, Field.Index.NOT_ANALYZED));
/*     */       
/* 627 */       long l = System.currentTimeMillis();
/* 628 */       document.add((Fieldable)new Field("_modified", DateTools.timeToString(l, DateTools.Resolution.SECOND), Field.Store.YES, Field.Index.NOT_ANALYZED));
/*     */ 
/*     */       
/* 631 */       StatementBuilder statementBuilder = new StatementBuilder();
/* 632 */       for (int i : this.indexColumns) {
/* 633 */         String str1 = this.columns[i];
/* 634 */         String str2 = FullText.asString(param1ArrayOfObject[i], this.columnTypes[i]);
/*     */ 
/*     */ 
/*     */         
/* 638 */         if (str1.startsWith("_")) {
/* 639 */           str1 = "_" + str1;
/*     */         }
/* 641 */         document.add((Fieldable)new Field(str1, str2, Field.Store.NO, Field.Index.ANALYZED));
/*     */         
/* 643 */         statementBuilder.appendExceptFirst(" ");
/* 644 */         statementBuilder.append(str2);
/*     */       } 
/* 646 */       Field.Store store = FullTextLucene.STORE_DOCUMENT_TEXT_IN_INDEX ? Field.Store.YES : Field.Store.NO;
/*     */       
/* 648 */       document.add((Fieldable)new Field("_DATA", statementBuilder.toString(), store, Field.Index.ANALYZED));
/*     */       
/*     */       try {
/* 651 */         this.indexAccess.writer.addDocument(document);
/* 652 */         if (param1Boolean) {
/* 653 */           commitIndex();
/*     */         }
/* 655 */       } catch (IOException iOException) {
/* 656 */         throw FullTextLucene.convertException(iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void delete(Object[] param1ArrayOfObject, boolean param1Boolean) throws SQLException {
/* 667 */       String str = getQuery(param1ArrayOfObject);
/*     */       try {
/* 669 */         Term term = new Term("_QUERY", str);
/* 670 */         this.indexAccess.writer.deleteDocuments(term);
/* 671 */         if (param1Boolean) {
/* 672 */           commitIndex();
/*     */         }
/* 674 */       } catch (IOException iOException) {
/* 675 */         throw FullTextLucene.convertException(iOException);
/*     */       } 
/*     */     }
/*     */     
/*     */     private String getQuery(Object[] param1ArrayOfObject) throws SQLException {
/* 680 */       StatementBuilder statementBuilder = new StatementBuilder();
/* 681 */       if (this.schema != null) {
/* 682 */         statementBuilder.append(StringUtils.quoteIdentifier(this.schema)).append('.');
/*     */       }
/* 684 */       statementBuilder.append(StringUtils.quoteIdentifier(this.table)).append(" WHERE ");
/* 685 */       for (int i : this.keys) {
/* 686 */         statementBuilder.appendExceptFirst(" AND ");
/* 687 */         statementBuilder.append(StringUtils.quoteIdentifier(this.columns[i]));
/* 688 */         Object object = param1ArrayOfObject[i];
/* 689 */         if (object == null) {
/* 690 */           statementBuilder.append(" IS NULL");
/*     */         } else {
/* 692 */           statementBuilder.append('=').append(FullText.quoteSQL(object, this.columnTypes[i]));
/*     */         } 
/*     */       } 
/* 695 */       return statementBuilder.toString();
/*     */     }
/*     */   }
/*     */   
/*     */   static class IndexAccess {
/*     */     IndexWriter writer;
/*     */     IndexReader reader;
/*     */     IndexSearcher searcher;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\fulltext\FullTextLucene.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */