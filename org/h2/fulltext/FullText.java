/*      */ package org.h2.fulltext;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.Reader;
/*      */ import java.io.StreamTokenizer;
/*      */ import java.sql.Clob;
/*      */ import java.sql.Connection;
/*      */ import java.sql.DatabaseMetaData;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Statement;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.StringTokenizer;
/*      */ import org.h2.api.Trigger;
/*      */ import org.h2.command.Parser;
/*      */ import org.h2.engine.Session;
/*      */ import org.h2.expression.Comparison;
/*      */ import org.h2.expression.ConditionAndOr;
/*      */ import org.h2.expression.Expression;
/*      */ import org.h2.expression.ExpressionColumn;
/*      */ import org.h2.expression.ValueExpression;
/*      */ import org.h2.jdbc.JdbcConnection;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.tools.SimpleResultSet;
/*      */ import org.h2.util.IOUtils;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.StatementBuilder;
/*      */ import org.h2.util.StringUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FullText
/*      */ {
/*      */   private static final String FIELD_SCHEMA = "SCHEMA";
/*      */   private static final String FIELD_TABLE = "TABLE";
/*      */   private static final String FIELD_COLUMNS = "COLUMNS";
/*      */   private static final String FIELD_KEYS = "KEYS";
/*      */   private static final String FIELD_SCORE = "SCORE";
/*      */   private static final String TRIGGER_PREFIX = "FT_";
/*      */   private static final String SCHEMA = "FT";
/*      */   private static final String SELECT_MAP_BY_WORD_ID = "SELECT ROWID FROM FT.MAP WHERE WORDID=?";
/*      */   private static final String SELECT_ROW_BY_ID = "SELECT KEY, INDEXID FROM FT.ROWS WHERE ID=?";
/*      */   private static final String FIELD_QUERY = "QUERY";
/*      */   
/*      */   public static void init(Connection paramConnection) throws SQLException {
/*  108 */     Statement statement = paramConnection.createStatement();
/*  109 */     statement.execute("CREATE SCHEMA IF NOT EXISTS FT");
/*  110 */     statement.execute("CREATE TABLE IF NOT EXISTS FT.INDEXES(ID INT AUTO_INCREMENT PRIMARY KEY, SCHEMA VARCHAR, TABLE VARCHAR, COLUMNS VARCHAR, UNIQUE(SCHEMA, TABLE))");
/*      */ 
/*      */ 
/*      */     
/*  114 */     statement.execute("CREATE TABLE IF NOT EXISTS FT.WORDS(ID INT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR, UNIQUE(NAME))");
/*      */ 
/*      */     
/*  117 */     statement.execute("CREATE TABLE IF NOT EXISTS FT.ROWS(ID IDENTITY, HASH INT, INDEXID INT, KEY VARCHAR, UNIQUE(HASH, INDEXID, KEY))");
/*      */ 
/*      */     
/*  120 */     statement.execute("CREATE TABLE IF NOT EXISTS FT.MAP(ROWID INT, WORDID INT, PRIMARY KEY(WORDID, ROWID))");
/*      */     
/*  122 */     statement.execute("CREATE TABLE IF NOT EXISTS FT.IGNORELIST(LIST VARCHAR)");
/*      */     
/*  124 */     statement.execute("CREATE TABLE IF NOT EXISTS FT.SETTINGS(KEY VARCHAR PRIMARY KEY, VALUE VARCHAR)");
/*      */     
/*  126 */     statement.execute("CREATE ALIAS IF NOT EXISTS FT_CREATE_INDEX FOR \"" + FullText.class.getName() + ".createIndex\"");
/*      */     
/*  128 */     statement.execute("CREATE ALIAS IF NOT EXISTS FT_DROP_INDEX FOR \"" + FullText.class.getName() + ".dropIndex\"");
/*      */     
/*  130 */     statement.execute("CREATE ALIAS IF NOT EXISTS FT_SEARCH FOR \"" + FullText.class.getName() + ".search\"");
/*      */     
/*  132 */     statement.execute("CREATE ALIAS IF NOT EXISTS FT_SEARCH_DATA FOR \"" + FullText.class.getName() + ".searchData\"");
/*      */     
/*  134 */     statement.execute("CREATE ALIAS IF NOT EXISTS FT_REINDEX FOR \"" + FullText.class.getName() + ".reindex\"");
/*      */     
/*  136 */     statement.execute("CREATE ALIAS IF NOT EXISTS FT_DROP_ALL FOR \"" + FullText.class.getName() + ".dropAll\"");
/*      */     
/*  138 */     FullTextSettings fullTextSettings = FullTextSettings.getInstance(paramConnection);
/*  139 */     ResultSet resultSet = statement.executeQuery("SELECT * FROM FT.IGNORELIST");
/*      */     
/*  141 */     while (resultSet.next()) {
/*  142 */       String str = resultSet.getString(1);
/*  143 */       setIgnoreList(fullTextSettings, str);
/*      */     } 
/*  145 */     resultSet = statement.executeQuery("SELECT * FROM FT.SETTINGS");
/*  146 */     while (resultSet.next()) {
/*  147 */       String str = resultSet.getString(1);
/*  148 */       if ("whitespaceChars".equals(str)) {
/*  149 */         String str1 = resultSet.getString(2);
/*  150 */         fullTextSettings.setWhitespaceChars(str1);
/*      */       } 
/*      */     } 
/*  153 */     resultSet = statement.executeQuery("SELECT * FROM FT.WORDS");
/*  154 */     HashMap<String, Integer> hashMap = fullTextSettings.getWordList();
/*  155 */     while (resultSet.next()) {
/*  156 */       String str = resultSet.getString("NAME");
/*  157 */       int i = resultSet.getInt("ID");
/*  158 */       str = fullTextSettings.convertWord(str);
/*  159 */       if (str != null) {
/*  160 */         hashMap.put(str, Integer.valueOf(i));
/*      */       }
/*      */     } 
/*  163 */     fullTextSettings.setInitialized(true);
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
/*      */   public static void createIndex(Connection paramConnection, String paramString1, String paramString2, String paramString3) throws SQLException {
/*  177 */     init(paramConnection);
/*  178 */     PreparedStatement preparedStatement = paramConnection.prepareStatement("INSERT INTO FT.INDEXES(SCHEMA, TABLE, COLUMNS) VALUES(?, ?, ?)");
/*      */     
/*  180 */     preparedStatement.setString(1, paramString1);
/*  181 */     preparedStatement.setString(2, paramString2);
/*  182 */     preparedStatement.setString(3, paramString3);
/*  183 */     preparedStatement.execute();
/*  184 */     createTrigger(paramConnection, paramString1, paramString2);
/*  185 */     indexExistingRows(paramConnection, paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void reindex(Connection paramConnection) throws SQLException {
/*  195 */     init(paramConnection);
/*  196 */     removeAllTriggers(paramConnection, "FT_");
/*  197 */     FullTextSettings fullTextSettings = FullTextSettings.getInstance(paramConnection);
/*  198 */     fullTextSettings.getWordList().clear();
/*  199 */     Statement statement = paramConnection.createStatement();
/*  200 */     statement.execute("TRUNCATE TABLE FT.WORDS");
/*  201 */     statement.execute("TRUNCATE TABLE FT.ROWS");
/*  202 */     statement.execute("TRUNCATE TABLE FT.MAP");
/*  203 */     ResultSet resultSet = statement.executeQuery("SELECT * FROM FT.INDEXES");
/*  204 */     while (resultSet.next()) {
/*  205 */       String str1 = resultSet.getString("SCHEMA");
/*  206 */       String str2 = resultSet.getString("TABLE");
/*  207 */       createTrigger(paramConnection, str1, str2);
/*  208 */       indexExistingRows(paramConnection, str1, str2);
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
/*      */   public static void dropIndex(Connection paramConnection, String paramString1, String paramString2) throws SQLException {
/*      */     int j;
/*  222 */     init(paramConnection);
/*  223 */     PreparedStatement preparedStatement = paramConnection.prepareStatement("SELECT ID FROM FT.INDEXES WHERE SCHEMA=? AND TABLE=?");
/*      */     
/*  225 */     preparedStatement.setString(1, paramString1);
/*  226 */     preparedStatement.setString(2, paramString2);
/*  227 */     ResultSet resultSet = preparedStatement.executeQuery();
/*  228 */     if (!resultSet.next()) {
/*      */       return;
/*      */     }
/*  231 */     int i = resultSet.getInt(1);
/*  232 */     preparedStatement = paramConnection.prepareStatement("DELETE FROM FT.INDEXES WHERE ID=?");
/*      */     
/*  234 */     preparedStatement.setInt(1, i);
/*  235 */     preparedStatement.execute();
/*  236 */     createOrDropTrigger(paramConnection, paramString1, paramString2, false);
/*  237 */     preparedStatement = paramConnection.prepareStatement("DELETE FROM FT.ROWS WHERE INDEXID=? AND ROWNUM<10000");
/*      */     
/*      */     do {
/*  240 */       preparedStatement.setInt(1, i);
/*  241 */       j = preparedStatement.executeUpdate();
/*  242 */     } while (j != 0);
/*      */ 
/*      */ 
/*      */     
/*  246 */     preparedStatement = paramConnection.prepareStatement("DELETE FROM FT.MAP M WHERE NOT EXISTS (SELECT * FROM FT.ROWS R WHERE R.ID=M.ROWID) AND ROWID<10000");
/*      */ 
/*      */     
/*      */     do {
/*  250 */       j = preparedStatement.executeUpdate();
/*  251 */     } while (j != 0);
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
/*      */   public static void dropAll(Connection paramConnection) throws SQLException {
/*  263 */     init(paramConnection);
/*  264 */     Statement statement = paramConnection.createStatement();
/*  265 */     statement.execute("DROP SCHEMA IF EXISTS FT");
/*  266 */     removeAllTriggers(paramConnection, "FT_");
/*  267 */     FullTextSettings fullTextSettings = FullTextSettings.getInstance(paramConnection);
/*  268 */     fullTextSettings.removeAllIndexes();
/*  269 */     fullTextSettings.getIgnoreList().clear();
/*  270 */     fullTextSettings.getWordList().clear();
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
/*      */   public static ResultSet search(Connection paramConnection, String paramString, int paramInt1, int paramInt2) throws SQLException {
/*      */     try {
/*  292 */       return search(paramConnection, paramString, paramInt1, paramInt2, false);
/*  293 */     } catch (DbException dbException) {
/*  294 */       throw DbException.toSQLException(dbException);
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
/*      */   public static ResultSet searchData(Connection paramConnection, String paramString, int paramInt1, int paramInt2) throws SQLException {
/*      */     try {
/*  323 */       return search(paramConnection, paramString, paramInt1, paramInt2, true);
/*  324 */     } catch (DbException dbException) {
/*  325 */       throw DbException.toSQLException(dbException);
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
/*      */   public static void setIgnoreList(Connection paramConnection, String paramString) throws SQLException {
/*      */     try {
/*  341 */       init(paramConnection);
/*  342 */       FullTextSettings fullTextSettings = FullTextSettings.getInstance(paramConnection);
/*  343 */       setIgnoreList(fullTextSettings, paramString);
/*  344 */       Statement statement = paramConnection.createStatement();
/*  345 */       statement.execute("TRUNCATE TABLE FT.IGNORELIST");
/*  346 */       PreparedStatement preparedStatement = paramConnection.prepareStatement("INSERT INTO FT.IGNORELIST VALUES(?)");
/*      */       
/*  348 */       preparedStatement.setString(1, paramString);
/*  349 */       preparedStatement.execute();
/*  350 */     } catch (DbException dbException) {
/*  351 */       throw DbException.toSQLException(dbException);
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
/*      */   public static void setWhitespaceChars(Connection paramConnection, String paramString) throws SQLException {
/*      */     try {
/*  366 */       init(paramConnection);
/*  367 */       FullTextSettings fullTextSettings = FullTextSettings.getInstance(paramConnection);
/*  368 */       fullTextSettings.setWhitespaceChars(paramString);
/*  369 */       PreparedStatement preparedStatement = paramConnection.prepareStatement("MERGE INTO FT.SETTINGS VALUES(?, ?)");
/*      */       
/*  371 */       preparedStatement.setString(1, "whitespaceChars");
/*  372 */       preparedStatement.setString(2, paramString);
/*  373 */       preparedStatement.execute();
/*  374 */     } catch (DbException dbException) {
/*  375 */       throw DbException.toSQLException(dbException);
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
/*      */   protected static String asString(Object paramObject, int paramInt) throws SQLException {
/*  388 */     if (paramObject == null) {
/*  389 */       return "NULL";
/*      */     }
/*  391 */     switch (paramInt) {
/*      */       case -7:
/*      */       case -6:
/*      */       case -5:
/*      */       case -1:
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*      */       case 4:
/*      */       case 5:
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*      */       case 12:
/*      */       case 16:
/*      */       case 91:
/*      */       case 92:
/*      */       case 93:
/*  409 */         return paramObject.toString();
/*      */       case 2005:
/*      */         try {
/*  412 */           if (paramObject instanceof Clob) {
/*  413 */             paramObject = ((Clob)paramObject).getCharacterStream();
/*      */           }
/*  415 */           return IOUtils.readStringAndClose((Reader)paramObject, -1);
/*  416 */         } catch (IOException iOException) {
/*  417 */           throw DbException.toSQLException(iOException);
/*      */         } 
/*      */       case -4:
/*      */       case -3:
/*      */       case -2:
/*      */       case 0:
/*      */       case 70:
/*      */       case 1111:
/*      */       case 2000:
/*      */       case 2001:
/*      */       case 2002:
/*      */       case 2003:
/*      */       case 2004:
/*      */       case 2006:
/*  431 */         throw throwException("Unsupported column data type: " + paramInt);
/*      */     } 
/*  433 */     return "";
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
/*      */   protected static SimpleResultSet createResultSet(boolean paramBoolean) {
/*  445 */     SimpleResultSet simpleResultSet = new SimpleResultSet();
/*  446 */     if (paramBoolean) {
/*  447 */       simpleResultSet.addColumn("SCHEMA", 12, 0, 0);
/*  448 */       simpleResultSet.addColumn("TABLE", 12, 0, 0);
/*  449 */       simpleResultSet.addColumn("COLUMNS", 2003, 0, 0);
/*  450 */       simpleResultSet.addColumn("KEYS", 2003, 0, 0);
/*      */     } else {
/*  452 */       simpleResultSet.addColumn("QUERY", 12, 0, 0);
/*      */     } 
/*  454 */     simpleResultSet.addColumn("SCORE", 6, 0, 0);
/*  455 */     return simpleResultSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static Object[][] parseKey(Connection paramConnection, String paramString) {
/*  466 */     ArrayList<String> arrayList1 = New.arrayList();
/*  467 */     ArrayList<String> arrayList2 = New.arrayList();
/*  468 */     JdbcConnection jdbcConnection = (JdbcConnection)paramConnection;
/*  469 */     Session session = (Session)jdbcConnection.getSession();
/*  470 */     Parser parser = new Parser(session);
/*  471 */     Expression expression = parser.parseExpression(paramString);
/*  472 */     addColumnData(arrayList1, arrayList2, expression);
/*  473 */     Object[] arrayOfObject1 = new Object[arrayList1.size()];
/*  474 */     arrayList1.toArray(arrayOfObject1);
/*  475 */     Object[] arrayOfObject2 = new Object[arrayList1.size()];
/*  476 */     arrayList2.toArray(arrayOfObject2);
/*  477 */     return new Object[][] { arrayOfObject1, arrayOfObject2 };
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
/*      */   protected static String quoteSQL(Object paramObject, int paramInt) throws SQLException {
/*  490 */     if (paramObject == null) {
/*  491 */       return "NULL";
/*      */     }
/*  493 */     switch (paramInt) {
/*      */       case -7:
/*      */       case -6:
/*      */       case -5:
/*      */       case 2:
/*      */       case 3:
/*      */       case 4:
/*      */       case 5:
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*      */       case 16:
/*  505 */         return paramObject.toString();
/*      */       case -1:
/*      */       case 1:
/*      */       case 12:
/*      */       case 91:
/*      */       case 92:
/*      */       case 93:
/*  512 */         return quoteString(paramObject.toString());
/*      */       case -4:
/*      */       case -3:
/*      */       case -2:
/*  516 */         if (paramObject instanceof java.util.UUID) {
/*  517 */           return "'" + paramObject.toString() + "'";
/*      */         }
/*  519 */         return "'" + StringUtils.convertBytesToHex((byte[])paramObject) + "'";
/*      */       case 0:
/*      */       case 70:
/*      */       case 1111:
/*      */       case 2000:
/*      */       case 2001:
/*      */       case 2002:
/*      */       case 2003:
/*      */       case 2004:
/*      */       case 2005:
/*      */       case 2006:
/*  530 */         throw throwException("Unsupported key data type: " + paramInt);
/*      */     } 
/*  532 */     return "";
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
/*      */   protected static void removeAllTriggers(Connection paramConnection, String paramString) throws SQLException {
/*  544 */     Statement statement1 = paramConnection.createStatement();
/*  545 */     ResultSet resultSet = statement1.executeQuery("SELECT * FROM INFORMATION_SCHEMA.TRIGGERS");
/*  546 */     Statement statement2 = paramConnection.createStatement();
/*  547 */     while (resultSet.next()) {
/*  548 */       String str1 = resultSet.getString("TRIGGER_SCHEMA");
/*  549 */       String str2 = resultSet.getString("TRIGGER_NAME");
/*  550 */       if (str2.startsWith(paramString)) {
/*  551 */         str2 = StringUtils.quoteIdentifier(str1) + "." + StringUtils.quoteIdentifier(str2);
/*      */         
/*  553 */         statement2.execute("DROP TRIGGER " + str2);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static void setColumns(int[] paramArrayOfint, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2) throws SQLException {
/*      */     byte b;
/*      */     int i;
/*  567 */     for (b = 0, i = paramArrayList1.size(); b < i; b++) {
/*  568 */       String str = paramArrayList1.get(b);
/*  569 */       byte b1 = -1;
/*  570 */       int j = paramArrayList2.size();
/*  571 */       for (byte b2 = 0; b1 == -1 && b2 < j; b2++) {
/*  572 */         String str1 = paramArrayList2.get(b2);
/*  573 */         if (str1.equals(str)) {
/*  574 */           b1 = b2;
/*      */         }
/*      */       } 
/*  577 */       if (b1 < 0) {
/*  578 */         throw throwException("Column not found: " + str);
/*      */       }
/*  580 */       paramArrayOfint[b] = b1;
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
/*      */   protected static ResultSet search(Connection paramConnection, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) throws SQLException {
/*  596 */     SimpleResultSet simpleResultSet = createResultSet(paramBoolean);
/*  597 */     if (paramConnection.getMetaData().getURL().startsWith("jdbc:columnlist:"))
/*      */     {
/*  599 */       return (ResultSet)simpleResultSet;
/*      */     }
/*  601 */     if (paramString == null || paramString.trim().length() == 0) {
/*  602 */       return (ResultSet)simpleResultSet;
/*      */     }
/*  604 */     FullTextSettings fullTextSettings = FullTextSettings.getInstance(paramConnection);
/*  605 */     if (!fullTextSettings.isInitialized()) {
/*  606 */       init(paramConnection);
/*      */     }
/*  608 */     HashSet<String> hashSet = New.hashSet();
/*  609 */     addWords(fullTextSettings, hashSet, paramString);
/*  610 */     HashSet<Integer> hashSet1 = null, hashSet2 = null;
/*  611 */     HashMap<String, Integer> hashMap = fullTextSettings.getWordList();
/*      */     
/*  613 */     PreparedStatement preparedStatement1 = fullTextSettings.prepare(paramConnection, "SELECT ROWID FROM FT.MAP WHERE WORDID=?");
/*      */     
/*  615 */     for (String str : hashSet) {
/*  616 */       hashSet2 = hashSet1;
/*  617 */       hashSet1 = New.hashSet();
/*  618 */       Integer integer = hashMap.get(str);
/*  619 */       if (integer == null) {
/*      */         continue;
/*      */       }
/*  622 */       preparedStatement1.setInt(1, integer.intValue());
/*  623 */       ResultSet resultSet = preparedStatement1.executeQuery();
/*  624 */       while (resultSet.next()) {
/*  625 */         Integer integer1 = Integer.valueOf(resultSet.getInt(1));
/*  626 */         if (hashSet2 == null || hashSet2.contains(integer1)) {
/*  627 */           hashSet1.add(integer1);
/*      */         }
/*      */       } 
/*      */     } 
/*  631 */     if (hashSet1 == null || hashSet1.size() == 0) {
/*  632 */       return (ResultSet)simpleResultSet;
/*      */     }
/*  634 */     PreparedStatement preparedStatement2 = fullTextSettings.prepare(paramConnection, "SELECT KEY, INDEXID FROM FT.ROWS WHERE ID=?");
/*  635 */     byte b = 0;
/*  636 */     for (Iterator<Integer> iterator = hashSet1.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  637 */       preparedStatement2.setInt(1, i);
/*  638 */       ResultSet resultSet = preparedStatement2.executeQuery();
/*  639 */       if (!resultSet.next()) {
/*      */         continue;
/*      */       }
/*  642 */       if (paramInt2 > 0) {
/*  643 */         paramInt2--; continue;
/*      */       } 
/*  645 */       String str = resultSet.getString(1);
/*  646 */       int j = resultSet.getInt(2);
/*  647 */       IndexInfo indexInfo = fullTextSettings.getIndexInfo(j);
/*  648 */       if (paramBoolean) {
/*  649 */         Object[][] arrayOfObject = parseKey(paramConnection, str);
/*  650 */         simpleResultSet.addRow(new Object[] { indexInfo.schema, indexInfo.table, arrayOfObject[0], arrayOfObject[1], Double.valueOf(1.0D) });
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/*  657 */         String str1 = StringUtils.quoteIdentifier(indexInfo.schema) + "." + StringUtils.quoteIdentifier(indexInfo.table) + " WHERE " + str;
/*      */ 
/*      */         
/*  660 */         simpleResultSet.addRow(new Object[] { str1, Double.valueOf(1.0D) });
/*      */       } 
/*  662 */       b++;
/*  663 */       if (paramInt1 > 0 && b >= paramInt1) {
/*      */         break;
/*      */       } }
/*      */ 
/*      */     
/*  668 */     return (ResultSet)simpleResultSet;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void addColumnData(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, Expression paramExpression) {
/*  673 */     if (paramExpression instanceof ConditionAndOr) {
/*  674 */       ConditionAndOr conditionAndOr = (ConditionAndOr)paramExpression;
/*  675 */       Expression expression1 = conditionAndOr.getExpression(true);
/*  676 */       Expression expression2 = conditionAndOr.getExpression(false);
/*  677 */       addColumnData(paramArrayList1, paramArrayList2, expression1);
/*  678 */       addColumnData(paramArrayList1, paramArrayList2, expression2);
/*      */     } else {
/*  680 */       Comparison comparison = (Comparison)paramExpression;
/*  681 */       ExpressionColumn expressionColumn = (ExpressionColumn)comparison.getExpression(true);
/*  682 */       ValueExpression valueExpression = (ValueExpression)comparison.getExpression(false);
/*  683 */       String str = expressionColumn.getColumnName();
/*  684 */       paramArrayList1.add(str);
/*  685 */       if (valueExpression == null) {
/*  686 */         paramArrayList2.add(null);
/*      */       } else {
/*  688 */         paramArrayList2.add(valueExpression.getValue(null).getString());
/*      */       } 
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
/*      */   protected static void addWords(FullTextSettings paramFullTextSettings, HashSet<String> paramHashSet, Reader paramReader) {
/*  702 */     StreamTokenizer streamTokenizer = new StreamTokenizer(paramReader);
/*  703 */     streamTokenizer.resetSyntax();
/*  704 */     streamTokenizer.wordChars(33, 255);
/*  705 */     char[] arrayOfChar = paramFullTextSettings.getWhitespaceChars().toCharArray();
/*  706 */     for (char c : arrayOfChar) {
/*  707 */       streamTokenizer.whitespaceChars(c, c);
/*      */     }
/*      */     try {
/*      */       while (true) {
/*  711 */         int i = streamTokenizer.nextToken();
/*  712 */         if (i == -1)
/*      */           break; 
/*  714 */         if (i == -3) {
/*  715 */           String str = streamTokenizer.sval;
/*  716 */           str = paramFullTextSettings.convertWord(str);
/*  717 */           if (str != null) {
/*  718 */             paramHashSet.add(str);
/*      */           }
/*      */         } 
/*      */       } 
/*  722 */     } catch (IOException iOException) {
/*  723 */       throw DbException.convertIOException(iOException, "Tokenizer error");
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
/*      */   protected static void addWords(FullTextSettings paramFullTextSettings, HashSet<String> paramHashSet, String paramString) {
/*  736 */     String str = paramFullTextSettings.getWhitespaceChars();
/*  737 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, str);
/*  738 */     while (stringTokenizer.hasMoreTokens()) {
/*  739 */       String str1 = stringTokenizer.nextToken();
/*  740 */       str1 = paramFullTextSettings.convertWord(str1);
/*  741 */       if (str1 != null) {
/*  742 */         paramHashSet.add(str1);
/*      */       }
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
/*      */   protected static void createTrigger(Connection paramConnection, String paramString1, String paramString2) throws SQLException {
/*  756 */     createOrDropTrigger(paramConnection, paramString1, paramString2, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void createOrDropTrigger(Connection paramConnection, String paramString1, String paramString2, boolean paramBoolean) throws SQLException {
/*  761 */     Statement statement = paramConnection.createStatement();
/*  762 */     String str = StringUtils.quoteIdentifier(paramString1) + "." + StringUtils.quoteIdentifier("FT_" + paramString2);
/*      */     
/*  764 */     statement.execute("DROP TRIGGER IF EXISTS " + str);
/*  765 */     if (paramBoolean) {
/*  766 */       StringBuilder stringBuilder = new StringBuilder("CREATE TRIGGER IF NOT EXISTS ");
/*      */ 
/*      */       
/*  769 */       stringBuilder.append(str).append(" AFTER INSERT, UPDATE, DELETE, ROLLBACK ON ").append(StringUtils.quoteIdentifier(paramString1)).append('.').append(StringUtils.quoteIdentifier(paramString2)).append(" FOR EACH ROW CALL \"").append(FullTextTrigger.class.getName()).append('"');
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  777 */       statement.execute(stringBuilder.toString());
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
/*      */   protected static void indexExistingRows(Connection paramConnection, String paramString1, String paramString2) throws SQLException {
/*  790 */     FullTextTrigger fullTextTrigger = new FullTextTrigger();
/*  791 */     fullTextTrigger.init(paramConnection, paramString1, null, paramString2, false, 1);
/*  792 */     String str = "SELECT * FROM " + StringUtils.quoteIdentifier(paramString1) + "." + StringUtils.quoteIdentifier(paramString2);
/*      */     
/*  794 */     ResultSet resultSet = paramConnection.createStatement().executeQuery(str);
/*  795 */     int i = resultSet.getMetaData().getColumnCount();
/*  796 */     while (resultSet.next()) {
/*  797 */       Object[] arrayOfObject = new Object[i];
/*  798 */       for (byte b = 0; b < i; b++) {
/*  799 */         arrayOfObject[b] = resultSet.getObject(b + 1);
/*      */       }
/*  801 */       fullTextTrigger.fire(paramConnection, null, arrayOfObject);
/*      */     } 
/*      */   }
/*      */   
/*      */   private static String quoteString(String paramString) {
/*  806 */     if (paramString.indexOf('\'') < 0) {
/*  807 */       return "'" + paramString + "'";
/*      */     }
/*  809 */     int i = paramString.length();
/*  810 */     StringBuilder stringBuilder = new StringBuilder(i + 2);
/*  811 */     stringBuilder.append('\'');
/*  812 */     for (byte b = 0; b < i; b++) {
/*  813 */       char c = paramString.charAt(b);
/*  814 */       if (c == '\'') {
/*  815 */         stringBuilder.append(c);
/*      */       }
/*  817 */       stringBuilder.append(c);
/*      */     } 
/*  819 */     stringBuilder.append('\'');
/*  820 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private static void setIgnoreList(FullTextSettings paramFullTextSettings, String paramString) {
/*  825 */     String[] arrayOfString = StringUtils.arraySplit(paramString, ',', true);
/*  826 */     HashSet<String> hashSet = paramFullTextSettings.getIgnoreList();
/*  827 */     for (String str1 : arrayOfString) {
/*  828 */       String str2 = paramFullTextSettings.convertWord(str1);
/*  829 */       if (str2 != null) {
/*  830 */         hashSet.add(str2);
/*      */       }
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
/*      */   protected static boolean hasChanged(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, int[] paramArrayOfint) {
/*  847 */     for (int i : paramArrayOfint) {
/*  848 */       Object object1 = paramArrayOfObject1[i], object2 = paramArrayOfObject2[i];
/*  849 */       if (object1 == null) {
/*  850 */         if (object2 != null) {
/*  851 */           return true;
/*      */         }
/*  853 */       } else if (!object1.equals(object2)) {
/*  854 */         return true;
/*      */       } 
/*      */     } 
/*  857 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static class FullTextTrigger
/*      */     implements Trigger
/*      */   {
/*      */     protected FullTextSettings setting;
/*      */     
/*      */     protected IndexInfo index;
/*      */     
/*      */     protected int[] columnTypes;
/*      */     
/*      */     protected PreparedStatement prepInsertWord;
/*      */     protected PreparedStatement prepInsertRow;
/*      */     protected PreparedStatement prepInsertMap;
/*      */     protected PreparedStatement prepDeleteRow;
/*      */     protected PreparedStatement prepDeleteMap;
/*      */     protected PreparedStatement prepSelectRow;
/*      */     
/*      */     public void init(Connection param1Connection, String param1String1, String param1String2, String param1String3, boolean param1Boolean, int param1Int) throws SQLException {
/*  878 */       this.setting = FullTextSettings.getInstance(param1Connection);
/*  879 */       if (!this.setting.isInitialized()) {
/*  880 */         FullText.init(param1Connection);
/*      */       }
/*  882 */       ArrayList<String> arrayList1 = New.arrayList();
/*  883 */       DatabaseMetaData databaseMetaData = param1Connection.getMetaData();
/*  884 */       ResultSet resultSet = databaseMetaData.getColumns(null, StringUtils.escapeMetaDataPattern(param1String1), StringUtils.escapeMetaDataPattern(param1String3), null);
/*      */ 
/*      */ 
/*      */       
/*  888 */       ArrayList<String> arrayList2 = New.arrayList();
/*  889 */       while (resultSet.next()) {
/*  890 */         arrayList2.add(resultSet.getString("COLUMN_NAME"));
/*      */       }
/*  892 */       this.columnTypes = new int[arrayList2.size()];
/*  893 */       this.index = new IndexInfo();
/*  894 */       this.index.schema = param1String1;
/*  895 */       this.index.table = param1String3;
/*  896 */       this.index.columns = new String[arrayList2.size()];
/*  897 */       arrayList2.toArray(this.index.columns);
/*  898 */       resultSet = databaseMetaData.getColumns(null, StringUtils.escapeMetaDataPattern(param1String1), StringUtils.escapeMetaDataPattern(param1String3), null);
/*      */ 
/*      */ 
/*      */       
/*  902 */       for (byte b = 0; resultSet.next(); b++) {
/*  903 */         this.columnTypes[b] = resultSet.getInt("DATA_TYPE");
/*      */       }
/*  905 */       if (arrayList1.size() == 0) {
/*  906 */         resultSet = databaseMetaData.getPrimaryKeys(null, StringUtils.escapeMetaDataPattern(param1String1), param1String3);
/*      */ 
/*      */         
/*  909 */         while (resultSet.next()) {
/*  910 */           arrayList1.add(resultSet.getString("COLUMN_NAME"));
/*      */         }
/*      */       } 
/*  913 */       if (arrayList1.size() == 0) {
/*  914 */         throw FullText.throwException("No primary key for table " + param1String3);
/*      */       }
/*  916 */       ArrayList<String> arrayList3 = New.arrayList();
/*  917 */       PreparedStatement preparedStatement = param1Connection.prepareStatement("SELECT ID, COLUMNS FROM FT.INDEXES WHERE SCHEMA=? AND TABLE=?");
/*      */       
/*  919 */       preparedStatement.setString(1, param1String1);
/*  920 */       preparedStatement.setString(2, param1String3);
/*  921 */       resultSet = preparedStatement.executeQuery();
/*  922 */       if (resultSet.next()) {
/*  923 */         this.index.id = resultSet.getInt(1);
/*  924 */         String str = resultSet.getString(2);
/*  925 */         if (str != null) {
/*  926 */           for (String str1 : StringUtils.arraySplit(str, ',', true)) {
/*  927 */             arrayList3.add(str1);
/*      */           }
/*      */         }
/*      */       } 
/*  931 */       if (arrayList3.size() == 0) {
/*  932 */         arrayList3.addAll(arrayList2);
/*      */       }
/*  934 */       this.index.keys = new int[arrayList1.size()];
/*  935 */       FullText.setColumns(this.index.keys, arrayList1, arrayList2);
/*  936 */       this.index.indexColumns = new int[arrayList3.size()];
/*  937 */       FullText.setColumns(this.index.indexColumns, arrayList3, arrayList2);
/*  938 */       this.setting.addIndexInfo(this.index);
/*  939 */       this.prepInsertWord = param1Connection.prepareStatement("INSERT INTO FT.WORDS(NAME) VALUES(?)");
/*      */       
/*  941 */       this.prepInsertRow = param1Connection.prepareStatement("INSERT INTO FT.ROWS(HASH, INDEXID, KEY) VALUES(?, ?, ?)");
/*      */       
/*  943 */       this.prepInsertMap = param1Connection.prepareStatement("INSERT INTO FT.MAP(ROWID, WORDID) VALUES(?, ?)");
/*      */       
/*  945 */       this.prepDeleteRow = param1Connection.prepareStatement("DELETE FROM FT.ROWS WHERE HASH=? AND INDEXID=? AND KEY=?");
/*      */       
/*  947 */       this.prepDeleteMap = param1Connection.prepareStatement("DELETE FROM FT.MAP WHERE ROWID=? AND WORDID=?");
/*      */       
/*  949 */       this.prepSelectRow = param1Connection.prepareStatement("SELECT ID FROM FT.ROWS WHERE HASH=? AND INDEXID=? AND KEY=?");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void fire(Connection param1Connection, Object[] param1ArrayOfObject1, Object[] param1ArrayOfObject2) throws SQLException {
/*  959 */       if (param1ArrayOfObject1 != null) {
/*  960 */         if (param1ArrayOfObject2 != null) {
/*      */           
/*  962 */           if (FullText.hasChanged(param1ArrayOfObject1, param1ArrayOfObject2, this.index.indexColumns)) {
/*  963 */             delete(param1ArrayOfObject1);
/*  964 */             insert(param1ArrayOfObject2);
/*      */           } 
/*      */         } else {
/*      */           
/*  968 */           delete(param1ArrayOfObject1);
/*      */         } 
/*  970 */       } else if (param1ArrayOfObject2 != null) {
/*      */         
/*  972 */         insert(param1ArrayOfObject2);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/*  981 */       this.setting.removeIndexInfo(this.index);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void remove() {
/*  989 */       this.setting.removeIndexInfo(this.index);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void insert(Object[] param1ArrayOfObject) throws SQLException {
/*  998 */       String str = getKey(param1ArrayOfObject);
/*  999 */       int i = str.hashCode();
/* 1000 */       this.prepInsertRow.setInt(1, i);
/* 1001 */       this.prepInsertRow.setInt(2, this.index.id);
/* 1002 */       this.prepInsertRow.setString(3, str);
/* 1003 */       this.prepInsertRow.execute();
/* 1004 */       ResultSet resultSet = this.prepInsertRow.getGeneratedKeys();
/* 1005 */       resultSet.next();
/* 1006 */       int j = resultSet.getInt(1);
/* 1007 */       this.prepInsertMap.setInt(1, j);
/* 1008 */       int[] arrayOfInt = getWordIds(param1ArrayOfObject);
/* 1009 */       for (int k : arrayOfInt) {
/* 1010 */         this.prepInsertMap.setInt(2, k);
/* 1011 */         this.prepInsertMap.execute();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void delete(Object[] param1ArrayOfObject) throws SQLException {
/* 1021 */       String str = getKey(param1ArrayOfObject);
/* 1022 */       int i = str.hashCode();
/* 1023 */       this.prepSelectRow.setInt(1, i);
/* 1024 */       this.prepSelectRow.setInt(2, this.index.id);
/* 1025 */       this.prepSelectRow.setString(3, str);
/* 1026 */       ResultSet resultSet = this.prepSelectRow.executeQuery();
/* 1027 */       if (resultSet.next()) {
/* 1028 */         int j = resultSet.getInt(1);
/* 1029 */         this.prepDeleteMap.setInt(1, j);
/* 1030 */         int[] arrayOfInt = getWordIds(param1ArrayOfObject);
/* 1031 */         for (int k : arrayOfInt) {
/* 1032 */           this.prepDeleteMap.setInt(2, k);
/* 1033 */           this.prepDeleteMap.executeUpdate();
/*      */         } 
/* 1035 */         this.prepDeleteRow.setInt(1, i);
/* 1036 */         this.prepDeleteRow.setInt(2, this.index.id);
/* 1037 */         this.prepDeleteRow.setString(3, str);
/* 1038 */         this.prepDeleteRow.executeUpdate();
/*      */       } 
/*      */     }
/*      */     
/*      */     private int[] getWordIds(Object[] param1ArrayOfObject) throws SQLException {
/* 1043 */       HashSet<String> hashSet = New.hashSet();
/* 1044 */       for (int i : this.index.indexColumns) {
/* 1045 */         int j = this.columnTypes[i];
/* 1046 */         Object object = param1ArrayOfObject[i];
/* 1047 */         if (j == 2005 && object != null) {
/*      */           Reader reader;
/* 1049 */           if (object instanceof Reader) {
/* 1050 */             reader = (Reader)object;
/*      */           } else {
/* 1052 */             reader = ((Clob)object).getCharacterStream();
/*      */           } 
/* 1054 */           FullText.addWords(this.setting, hashSet, reader);
/*      */         } else {
/* 1056 */           String str = FullText.asString(object, j);
/* 1057 */           FullText.addWords(this.setting, hashSet, str);
/*      */         } 
/*      */       } 
/* 1060 */       HashMap<String, Integer> hashMap = this.setting.getWordList();
/* 1061 */       int[] arrayOfInt = new int[hashSet.size()];
/* 1062 */       Iterator<String> iterator = hashSet.iterator();
/* 1063 */       for (byte b = 0; iterator.hasNext(); b++) {
/* 1064 */         int i; String str = iterator.next();
/* 1065 */         Integer integer = hashMap.get(str);
/*      */         
/* 1067 */         if (integer == null) {
/* 1068 */           this.prepInsertWord.setString(1, str);
/* 1069 */           this.prepInsertWord.execute();
/* 1070 */           ResultSet resultSet = this.prepInsertWord.getGeneratedKeys();
/* 1071 */           resultSet.next();
/* 1072 */           i = resultSet.getInt(1);
/* 1073 */           hashMap.put(str, Integer.valueOf(i));
/*      */         } else {
/* 1075 */           i = integer.intValue();
/*      */         } 
/* 1077 */         arrayOfInt[b] = i;
/*      */       } 
/* 1079 */       Arrays.sort(arrayOfInt);
/* 1080 */       return arrayOfInt;
/*      */     }
/*      */     
/*      */     private String getKey(Object[] param1ArrayOfObject) throws SQLException {
/* 1084 */       StatementBuilder statementBuilder = new StatementBuilder();
/* 1085 */       for (int i : this.index.keys) {
/* 1086 */         statementBuilder.appendExceptFirst(" AND ");
/* 1087 */         statementBuilder.append(StringUtils.quoteIdentifier(this.index.columns[i]));
/* 1088 */         Object object = param1ArrayOfObject[i];
/* 1089 */         if (object == null) {
/* 1090 */           statementBuilder.append(" IS NULL");
/*      */         } else {
/* 1092 */           statementBuilder.append('=').append(FullText.quoteSQL(object, this.columnTypes[i]));
/*      */         } 
/*      */       } 
/* 1095 */       return statementBuilder.toString();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void closeAll() {
/* 1105 */     FullTextSettings.closeAll();
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
/*      */   protected static SQLException throwException(String paramString) throws SQLException {
/* 1117 */     throw new SQLException(paramString, "FULLTEXT");
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\fulltext\FullText.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */