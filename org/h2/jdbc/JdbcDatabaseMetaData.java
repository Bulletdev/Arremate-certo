/*      */ package org.h2.jdbc;
/*      */ 
/*      */ import java.sql.Connection;
/*      */ import java.sql.DatabaseMetaData;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.RowIdLifetime;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Properties;
/*      */ import org.h2.engine.Constants;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.message.Trace;
/*      */ import org.h2.message.TraceObject;
/*      */ import org.h2.tools.SimpleResultSet;
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
/*      */ public class JdbcDatabaseMetaData
/*      */   extends TraceObject
/*      */   implements DatabaseMetaData, JdbcDatabaseMetaDataBackwardsCompat
/*      */ {
/*      */   private final JdbcConnection conn;
/*      */   
/*      */   JdbcDatabaseMetaData(JdbcConnection paramJdbcConnection, Trace paramTrace, int paramInt) {
/*   34 */     setTrace(paramTrace, 2, paramInt);
/*   35 */     this.conn = paramJdbcConnection;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDriverMajorVersion() {
/*   45 */     debugCodeCall("getDriverMajorVersion");
/*   46 */     return 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDriverMinorVersion() {
/*   56 */     debugCodeCall("getDriverMinorVersion");
/*   57 */     return 4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDatabaseProductName() {
/*   67 */     debugCodeCall("getDatabaseProductName");
/*      */ 
/*      */     
/*   70 */     return "H2";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDatabaseProductVersion() {
/*   80 */     debugCodeCall("getDatabaseProductVersion");
/*   81 */     return Constants.getFullVersion();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDriverName() {
/*   91 */     debugCodeCall("getDriverName");
/*   92 */     return "H2 JDBC Driver";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDriverVersion() {
/*  103 */     debugCodeCall("getDriverVersion");
/*  104 */     return Constants.getFullVersion();
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getTables(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) throws SQLException {
/*      */     try {
/*      */       String str;
/*  139 */       if (isDebugEnabled()) {
/*  140 */         debugCode("getTables(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ", " + quoteArray(paramArrayOfString) + ");");
/*      */       }
/*      */ 
/*      */       
/*  144 */       checkClosed();
/*      */       
/*  146 */       if (paramArrayOfString != null && paramArrayOfString.length > 0) {
/*  147 */         StatementBuilder statementBuilder = new StatementBuilder("TABLE_TYPE IN(");
/*  148 */         for (byte b1 = 0; b1 < paramArrayOfString.length; b1++) {
/*  149 */           statementBuilder.appendExceptFirst(", ");
/*  150 */           statementBuilder.append('?');
/*      */         } 
/*  152 */         str = statementBuilder.append(')').toString();
/*      */       } else {
/*  154 */         str = "TRUE";
/*      */       } 
/*  156 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT TABLE_CATALOG TABLE_CAT, TABLE_SCHEMA TABLE_SCHEM, TABLE_NAME, TABLE_TYPE, REMARKS, TYPE_NAME TYPE_CAT, TYPE_NAME TYPE_SCHEM, TYPE_NAME, TYPE_NAME SELF_REFERENCING_COL_NAME, TYPE_NAME REF_GENERATION, SQL FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_CATALOG LIKE ? ESCAPE ? AND TABLE_SCHEMA LIKE ? ESCAPE ? AND TABLE_NAME LIKE ? ESCAPE ? AND (" + str + ") " + "ORDER BY TABLE_TYPE, TABLE_SCHEMA, TABLE_NAME");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  174 */       preparedStatement.setString(1, getCatalogPattern(paramString1));
/*  175 */       preparedStatement.setString(2, "\\");
/*  176 */       preparedStatement.setString(3, getSchemaPattern(paramString2));
/*  177 */       preparedStatement.setString(4, "\\");
/*  178 */       preparedStatement.setString(5, getPattern(paramString3));
/*  179 */       preparedStatement.setString(6, "\\");
/*  180 */       for (byte b = 0; paramArrayOfString != null && b < paramArrayOfString.length; b++) {
/*  181 */         preparedStatement.setString(7 + b, paramArrayOfString[b]);
/*      */       }
/*  183 */       return preparedStatement.executeQuery();
/*  184 */     } catch (Exception exception) {
/*  185 */       throw logAndConvert(exception);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getColumns(String paramString1, String paramString2, String paramString3, String paramString4) throws SQLException {
/*      */     try {
/*  237 */       if (isDebugEnabled()) {
/*  238 */         debugCode("getColumns(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ", " + quote(paramString4) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  243 */       checkClosed();
/*  244 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT TABLE_CATALOG TABLE_CAT, TABLE_SCHEMA TABLE_SCHEM, TABLE_NAME, COLUMN_NAME, DATA_TYPE, TYPE_NAME, CHARACTER_MAXIMUM_LENGTH COLUMN_SIZE, CHARACTER_MAXIMUM_LENGTH BUFFER_LENGTH, NUMERIC_SCALE DECIMAL_DIGITS, NUMERIC_PRECISION_RADIX NUM_PREC_RADIX, NULLABLE, REMARKS, COLUMN_DEFAULT COLUMN_DEF, DATA_TYPE SQL_DATA_TYPE, ZERO() SQL_DATETIME_SUB, CHARACTER_OCTET_LENGTH CHAR_OCTET_LENGTH, ORDINAL_POSITION, IS_NULLABLE IS_NULLABLE, CAST(SOURCE_DATA_TYPE AS VARCHAR) SCOPE_CATALOG, CAST(SOURCE_DATA_TYPE AS VARCHAR) SCOPE_SCHEMA, CAST(SOURCE_DATA_TYPE AS VARCHAR) SCOPE_TABLE, SOURCE_DATA_TYPE, CASE WHEN SEQUENCE_NAME IS NULL THEN CAST(? AS VARCHAR) ELSE CAST(? AS VARCHAR) END IS_AUTOINCREMENT, CAST(SOURCE_DATA_TYPE AS VARCHAR) SCOPE_CATLOG FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_CATALOG LIKE ? ESCAPE ? AND TABLE_SCHEMA LIKE ? ESCAPE ? AND TABLE_NAME LIKE ? ESCAPE ? AND COLUMN_NAME LIKE ? ESCAPE ? ORDER BY TABLE_SCHEM, TABLE_NAME, ORDINAL_POSITION");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  276 */       preparedStatement.setString(1, "NO");
/*  277 */       preparedStatement.setString(2, "YES");
/*  278 */       preparedStatement.setString(3, getCatalogPattern(paramString1));
/*  279 */       preparedStatement.setString(4, "\\");
/*  280 */       preparedStatement.setString(5, getSchemaPattern(paramString2));
/*  281 */       preparedStatement.setString(6, "\\");
/*  282 */       preparedStatement.setString(7, getPattern(paramString3));
/*  283 */       preparedStatement.setString(8, "\\");
/*  284 */       preparedStatement.setString(9, getPattern(paramString4));
/*  285 */       preparedStatement.setString(10, "\\");
/*  286 */       return preparedStatement.executeQuery();
/*  287 */     } catch (Exception exception) {
/*  288 */       throw logAndConvert(exception);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getIndexInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2) throws SQLException {
/*      */     try {
/*      */       String str;
/*  330 */       if (isDebugEnabled()) {
/*  331 */         debugCode("getIndexInfo(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ", " + paramBoolean1 + ", " + paramBoolean2 + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  336 */       if (paramBoolean1) {
/*  337 */         str = "NON_UNIQUE=FALSE";
/*      */       } else {
/*  339 */         str = "TRUE";
/*      */       } 
/*  341 */       checkClosed();
/*  342 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT TABLE_CATALOG TABLE_CAT, TABLE_SCHEMA TABLE_SCHEM, TABLE_NAME, NON_UNIQUE, TABLE_CATALOG INDEX_QUALIFIER, INDEX_NAME, INDEX_TYPE TYPE, ORDINAL_POSITION, COLUMN_NAME, ASC_OR_DESC, CARDINALITY, PAGES, FILTER_CONDITION, SORT_TYPE FROM INFORMATION_SCHEMA.INDEXES WHERE TABLE_CATALOG LIKE ? ESCAPE ? AND TABLE_SCHEMA LIKE ? ESCAPE ? AND (" + str + ") " + "AND TABLE_NAME = ? " + "ORDER BY NON_UNIQUE, TYPE, TABLE_SCHEM, INDEX_NAME, ORDINAL_POSITION");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  364 */       preparedStatement.setString(1, getCatalogPattern(paramString1));
/*  365 */       preparedStatement.setString(2, "\\");
/*  366 */       preparedStatement.setString(3, getSchemaPattern(paramString2));
/*  367 */       preparedStatement.setString(4, "\\");
/*  368 */       preparedStatement.setString(5, paramString3);
/*  369 */       return preparedStatement.executeQuery();
/*  370 */     } catch (Exception exception) {
/*  371 */       throw logAndConvert(exception);
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
/*      */   public ResultSet getPrimaryKeys(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     try {
/*  399 */       if (isDebugEnabled()) {
/*  400 */         debugCode("getPrimaryKeys(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  405 */       checkClosed();
/*  406 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT TABLE_CATALOG TABLE_CAT, TABLE_SCHEMA TABLE_SCHEM, TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION KEY_SEQ, IFNULL(CONSTRAINT_NAME, INDEX_NAME) PK_NAME FROM INFORMATION_SCHEMA.INDEXES WHERE TABLE_CATALOG LIKE ? ESCAPE ? AND TABLE_SCHEMA LIKE ? ESCAPE ? AND TABLE_NAME = ? AND PRIMARY_KEY = TRUE ORDER BY COLUMN_NAME");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  419 */       preparedStatement.setString(1, getCatalogPattern(paramString1));
/*  420 */       preparedStatement.setString(2, "\\");
/*  421 */       preparedStatement.setString(3, getSchemaPattern(paramString2));
/*  422 */       preparedStatement.setString(4, "\\");
/*  423 */       preparedStatement.setString(5, paramString3);
/*  424 */       return preparedStatement.executeQuery();
/*  425 */     } catch (Exception exception) {
/*  426 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean allProceduresAreCallable() {
/*  437 */     debugCodeCall("allProceduresAreCallable");
/*  438 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean allTablesAreSelectable() {
/*  448 */     debugCodeCall("allTablesAreSelectable");
/*  449 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getURL() throws SQLException {
/*      */     try {
/*  460 */       debugCodeCall("getURL");
/*  461 */       return this.conn.getURL();
/*  462 */     } catch (Exception exception) {
/*  463 */       throw logAndConvert(exception);
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
/*      */   public String getUserName() throws SQLException {
/*      */     try {
/*  476 */       debugCodeCall("getUserName");
/*  477 */       return this.conn.getUser();
/*  478 */     } catch (Exception exception) {
/*  479 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isReadOnly() throws SQLException {
/*      */     try {
/*  491 */       debugCodeCall("isReadOnly");
/*  492 */       return this.conn.isReadOnly();
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
/*      */   public boolean nullsAreSortedHigh() {
/*  506 */     debugCodeCall("nullsAreSortedHigh");
/*  507 */     return SysProperties.SORT_NULLS_HIGH;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean nullsAreSortedLow() {
/*  518 */     debugCodeCall("nullsAreSortedLow");
/*  519 */     return !SysProperties.SORT_NULLS_HIGH;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean nullsAreSortedAtStart() {
/*  530 */     debugCodeCall("nullsAreSortedAtStart");
/*  531 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean nullsAreSortedAtEnd() {
/*  541 */     debugCodeCall("nullsAreSortedAtEnd");
/*  542 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Connection getConnection() {
/*  552 */     debugCodeCall("getConnection");
/*  553 */     return this.conn;
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
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getProcedures(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     try {
/*  586 */       if (isDebugEnabled()) {
/*  587 */         debugCode("getProcedures(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  592 */       checkClosed();
/*  593 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT ALIAS_CATALOG PROCEDURE_CAT, ALIAS_SCHEMA PROCEDURE_SCHEM, ALIAS_NAME PROCEDURE_NAME, COLUMN_COUNT NUM_INPUT_PARAMS, ZERO() NUM_OUTPUT_PARAMS, ZERO() NUM_RESULT_SETS, REMARKS, RETURNS_RESULT PROCEDURE_TYPE, ALIAS_NAME SPECIFIC_NAME FROM INFORMATION_SCHEMA.FUNCTION_ALIASES WHERE ALIAS_CATALOG LIKE ? ESCAPE ? AND ALIAS_SCHEMA LIKE ? ESCAPE ? AND ALIAS_NAME LIKE ? ESCAPE ? ORDER BY PROCEDURE_SCHEM, PROCEDURE_NAME, NUM_INPUT_PARAMS");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  608 */       preparedStatement.setString(1, getCatalogPattern(paramString1));
/*  609 */       preparedStatement.setString(2, "\\");
/*  610 */       preparedStatement.setString(3, getSchemaPattern(paramString2));
/*  611 */       preparedStatement.setString(4, "\\");
/*  612 */       preparedStatement.setString(5, getPattern(paramString3));
/*  613 */       preparedStatement.setString(6, "\\");
/*  614 */       return preparedStatement.executeQuery();
/*  615 */     } catch (Exception exception) {
/*  616 */       throw logAndConvert(exception);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getProcedureColumns(String paramString1, String paramString2, String paramString3, String paramString4) throws SQLException {
/*      */     try {
/*  666 */       if (isDebugEnabled()) {
/*  667 */         debugCode("getProcedureColumns(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ", " + quote(paramString4) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  673 */       checkClosed();
/*  674 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT ALIAS_CATALOG PROCEDURE_CAT, ALIAS_SCHEMA PROCEDURE_SCHEM, ALIAS_NAME PROCEDURE_NAME, COLUMN_NAME, COLUMN_TYPE, DATA_TYPE, TYPE_NAME, PRECISION, PRECISION LENGTH, SCALE, RADIX, NULLABLE, REMARKS, COLUMN_DEFAULT COLUMN_DEF, ZERO() SQL_DATA_TYPE, ZERO() SQL_DATETIME_SUB, ZERO() CHAR_OCTET_LENGTH, POS ORDINAL_POSITION, ? IS_NULLABLE, ALIAS_NAME SPECIFIC_NAME FROM INFORMATION_SCHEMA.FUNCTION_COLUMNS WHERE ALIAS_CATALOG LIKE ? ESCAPE ? AND ALIAS_SCHEMA LIKE ? ESCAPE ? AND ALIAS_NAME LIKE ? ESCAPE ? AND COLUMN_NAME LIKE ? ESCAPE ? ORDER BY PROCEDURE_SCHEM, PROCEDURE_NAME, ORDINAL_POSITION");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  701 */       preparedStatement.setString(1, "YES");
/*  702 */       preparedStatement.setString(2, getCatalogPattern(paramString1));
/*  703 */       preparedStatement.setString(3, "\\");
/*  704 */       preparedStatement.setString(4, getSchemaPattern(paramString2));
/*  705 */       preparedStatement.setString(5, "\\");
/*  706 */       preparedStatement.setString(6, getPattern(paramString3));
/*  707 */       preparedStatement.setString(7, "\\");
/*  708 */       preparedStatement.setString(8, getPattern(paramString4));
/*  709 */       preparedStatement.setString(9, "\\");
/*  710 */       return preparedStatement.executeQuery();
/*  711 */     } catch (Exception exception) {
/*  712 */       throw logAndConvert(exception);
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
/*      */   public ResultSet getSchemas() throws SQLException {
/*      */     try {
/*  732 */       debugCodeCall("getSchemas");
/*  733 */       checkClosed();
/*  734 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT SCHEMA_NAME TABLE_SCHEM, CATALOG_NAME TABLE_CATALOG,  IS_DEFAULT FROM INFORMATION_SCHEMA.SCHEMATA ORDER BY SCHEMA_NAME");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  741 */       return preparedStatement.executeQuery();
/*  742 */     } catch (Exception exception) {
/*  743 */       throw logAndConvert(exception);
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
/*      */   public ResultSet getCatalogs() throws SQLException {
/*      */     try {
/*  761 */       debugCodeCall("getCatalogs");
/*  762 */       checkClosed();
/*  763 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT CATALOG_NAME TABLE_CAT FROM INFORMATION_SCHEMA.CATALOGS");
/*      */ 
/*      */       
/*  766 */       return preparedStatement.executeQuery();
/*  767 */     } catch (Exception exception) {
/*  768 */       throw logAndConvert(exception);
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
/*      */   public ResultSet getTableTypes() throws SQLException {
/*      */     try {
/*  785 */       debugCodeCall("getTableTypes");
/*  786 */       checkClosed();
/*  787 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT TYPE TABLE_TYPE FROM INFORMATION_SCHEMA.TABLE_TYPES ORDER BY TABLE_TYPE");
/*      */ 
/*      */ 
/*      */       
/*  791 */       return preparedStatement.executeQuery();
/*  792 */     } catch (Exception exception) {
/*  793 */       throw logAndConvert(exception);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getColumnPrivileges(String paramString1, String paramString2, String paramString3, String paramString4) throws SQLException {
/*      */     try {
/*  828 */       if (isDebugEnabled()) {
/*  829 */         debugCode("getColumnPrivileges(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ", " + quote(paramString4) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  835 */       checkClosed();
/*  836 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT TABLE_CATALOG TABLE_CAT, TABLE_SCHEMA TABLE_SCHEM, TABLE_NAME, COLUMN_NAME, GRANTOR, GRANTEE, PRIVILEGE_TYPE PRIVILEGE, IS_GRANTABLE FROM INFORMATION_SCHEMA.COLUMN_PRIVILEGES WHERE TABLE_CATALOG LIKE ? ESCAPE ? AND TABLE_SCHEMA LIKE ? ESCAPE ? AND TABLE_NAME = ? AND COLUMN_NAME LIKE ? ESCAPE ? ORDER BY COLUMN_NAME, PRIVILEGE");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  851 */       preparedStatement.setString(1, getCatalogPattern(paramString1));
/*  852 */       preparedStatement.setString(2, "\\");
/*  853 */       preparedStatement.setString(3, getSchemaPattern(paramString2));
/*  854 */       preparedStatement.setString(4, "\\");
/*  855 */       preparedStatement.setString(5, paramString3);
/*  856 */       preparedStatement.setString(6, getPattern(paramString4));
/*  857 */       preparedStatement.setString(7, "\\");
/*  858 */       return preparedStatement.executeQuery();
/*  859 */     } catch (Exception exception) {
/*  860 */       throw logAndConvert(exception);
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
/*      */   
/*      */   public ResultSet getTablePrivileges(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     try {
/*  892 */       if (isDebugEnabled()) {
/*  893 */         debugCode("getTablePrivileges(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  898 */       checkClosed();
/*  899 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT TABLE_CATALOG TABLE_CAT, TABLE_SCHEMA TABLE_SCHEM, TABLE_NAME, GRANTOR, GRANTEE, PRIVILEGE_TYPE PRIVILEGE, IS_GRANTABLE FROM INFORMATION_SCHEMA.TABLE_PRIVILEGES WHERE TABLE_CATALOG LIKE ? ESCAPE ? AND TABLE_SCHEMA LIKE ? ESCAPE ? AND TABLE_NAME LIKE ? ESCAPE ? ORDER BY TABLE_SCHEM, TABLE_NAME, PRIVILEGE");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  912 */       preparedStatement.setString(1, getCatalogPattern(paramString1));
/*  913 */       preparedStatement.setString(2, "\\");
/*  914 */       preparedStatement.setString(3, getSchemaPattern(paramString2));
/*  915 */       preparedStatement.setString(4, "\\");
/*  916 */       preparedStatement.setString(5, getPattern(paramString3));
/*  917 */       preparedStatement.setString(6, "\\");
/*  918 */       return preparedStatement.executeQuery();
/*  919 */     } catch (Exception exception) {
/*  920 */       throw logAndConvert(exception);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getBestRowIdentifier(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean) throws SQLException {
/*      */     try {
/*  954 */       if (isDebugEnabled()) {
/*  955 */         debugCode("getBestRowIdentifier(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ", " + paramInt + ", " + paramBoolean + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  961 */       checkClosed();
/*  962 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT CAST(? AS SMALLINT) SCOPE, C.COLUMN_NAME, C.DATA_TYPE, C.TYPE_NAME, C.CHARACTER_MAXIMUM_LENGTH COLUMN_SIZE, C.CHARACTER_MAXIMUM_LENGTH BUFFER_LENGTH, CAST(C.NUMERIC_SCALE AS SMALLINT) DECIMAL_DIGITS, CAST(? AS SMALLINT) PSEUDO_COLUMN FROM INFORMATION_SCHEMA.INDEXES I,  INFORMATION_SCHEMA.COLUMNS C WHERE C.TABLE_NAME = I.TABLE_NAME AND C.COLUMN_NAME = I.COLUMN_NAME AND C.TABLE_CATALOG LIKE ? ESCAPE ? AND C.TABLE_SCHEMA LIKE ? ESCAPE ? AND C.TABLE_NAME = ? AND I.PRIMARY_KEY = TRUE ORDER BY SCOPE");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  981 */       preparedStatement.setInt(1, 2);
/*      */       
/*  983 */       preparedStatement.setInt(2, 1);
/*  984 */       preparedStatement.setString(3, getCatalogPattern(paramString1));
/*  985 */       preparedStatement.setString(4, "\\");
/*  986 */       preparedStatement.setString(5, getSchemaPattern(paramString2));
/*  987 */       preparedStatement.setString(6, "\\");
/*  988 */       preparedStatement.setString(7, paramString3);
/*  989 */       return preparedStatement.executeQuery();
/*  990 */     } catch (Exception exception) {
/*  991 */       throw logAndConvert(exception);
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
/*      */   public ResultSet getVersionColumns(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     try {
/* 1021 */       if (isDebugEnabled()) {
/* 1022 */         debugCode("getVersionColumns(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1027 */       checkClosed();
/* 1028 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT ZERO() SCOPE, COLUMN_NAME, CAST(DATA_TYPE AS INT) DATA_TYPE, TYPE_NAME, NUMERIC_PRECISION COLUMN_SIZE, NUMERIC_PRECISION BUFFER_LENGTH, NUMERIC_PRECISION DECIMAL_DIGITS, ZERO() PSEUDO_COLUMN FROM INFORMATION_SCHEMA.COLUMNS WHERE FALSE");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1039 */       return preparedStatement.executeQuery();
/* 1040 */     } catch (Exception exception) {
/* 1041 */       throw logAndConvert(exception);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getImportedKeys(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     try {
/* 1080 */       if (isDebugEnabled()) {
/* 1081 */         debugCode("getImportedKeys(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1086 */       checkClosed();
/* 1087 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT PKTABLE_CATALOG PKTABLE_CAT, PKTABLE_SCHEMA PKTABLE_SCHEM, PKTABLE_NAME PKTABLE_NAME, PKCOLUMN_NAME, FKTABLE_CATALOG FKTABLE_CAT, FKTABLE_SCHEMA FKTABLE_SCHEM, FKTABLE_NAME, FKCOLUMN_NAME, ORDINAL_POSITION KEY_SEQ, UPDATE_RULE, DELETE_RULE, FK_NAME, PK_NAME, DEFERRABILITY FROM INFORMATION_SCHEMA.CROSS_REFERENCES WHERE FKTABLE_CATALOG LIKE ? ESCAPE ? AND FKTABLE_SCHEMA LIKE ? ESCAPE ? AND FKTABLE_NAME = ? ORDER BY PKTABLE_CAT, PKTABLE_SCHEM, PKTABLE_NAME, FK_NAME, KEY_SEQ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1107 */       preparedStatement.setString(1, getCatalogPattern(paramString1));
/* 1108 */       preparedStatement.setString(2, "\\");
/* 1109 */       preparedStatement.setString(3, getSchemaPattern(paramString2));
/* 1110 */       preparedStatement.setString(4, "\\");
/* 1111 */       preparedStatement.setString(5, paramString3);
/* 1112 */       return preparedStatement.executeQuery();
/* 1113 */     } catch (Exception exception) {
/* 1114 */       throw logAndConvert(exception);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getExportedKeys(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     try {
/* 1153 */       if (isDebugEnabled()) {
/* 1154 */         debugCode("getExportedKeys(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1159 */       checkClosed();
/* 1160 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT PKTABLE_CATALOG PKTABLE_CAT, PKTABLE_SCHEMA PKTABLE_SCHEM, PKTABLE_NAME PKTABLE_NAME, PKCOLUMN_NAME, FKTABLE_CATALOG FKTABLE_CAT, FKTABLE_SCHEMA FKTABLE_SCHEM, FKTABLE_NAME, FKCOLUMN_NAME, ORDINAL_POSITION KEY_SEQ, UPDATE_RULE, DELETE_RULE, FK_NAME, PK_NAME, DEFERRABILITY FROM INFORMATION_SCHEMA.CROSS_REFERENCES WHERE PKTABLE_CATALOG LIKE ? ESCAPE ? AND PKTABLE_SCHEMA LIKE ? ESCAPE ? AND PKTABLE_NAME = ? ORDER BY FKTABLE_CAT, FKTABLE_SCHEM, FKTABLE_NAME, FK_NAME, KEY_SEQ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1180 */       preparedStatement.setString(1, getCatalogPattern(paramString1));
/* 1181 */       preparedStatement.setString(2, "\\");
/* 1182 */       preparedStatement.setString(3, getSchemaPattern(paramString2));
/* 1183 */       preparedStatement.setString(4, "\\");
/* 1184 */       preparedStatement.setString(5, paramString3);
/* 1185 */       return preparedStatement.executeQuery();
/* 1186 */     } catch (Exception exception) {
/* 1187 */       throw logAndConvert(exception);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getCrossReference(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) throws SQLException {
/*      */     try {
/* 1233 */       if (isDebugEnabled()) {
/* 1234 */         debugCode("getCrossReference(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ", " + quote(paramString4) + ", " + quote(paramString5) + ", " + quote(paramString6) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1242 */       checkClosed();
/* 1243 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT PKTABLE_CATALOG PKTABLE_CAT, PKTABLE_SCHEMA PKTABLE_SCHEM, PKTABLE_NAME PKTABLE_NAME, PKCOLUMN_NAME, FKTABLE_CATALOG FKTABLE_CAT, FKTABLE_SCHEMA FKTABLE_SCHEM, FKTABLE_NAME, FKCOLUMN_NAME, ORDINAL_POSITION KEY_SEQ, UPDATE_RULE, DELETE_RULE, FK_NAME, PK_NAME, DEFERRABILITY FROM INFORMATION_SCHEMA.CROSS_REFERENCES WHERE PKTABLE_CATALOG LIKE ? ESCAPE ? AND PKTABLE_SCHEMA LIKE ? ESCAPE ? AND PKTABLE_NAME = ? AND FKTABLE_CATALOG LIKE ? ESCAPE ? AND FKTABLE_SCHEMA LIKE ? ESCAPE ? AND FKTABLE_NAME = ? ORDER BY FKTABLE_CAT, FKTABLE_SCHEM, FKTABLE_NAME, FK_NAME, KEY_SEQ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1266 */       preparedStatement.setString(1, getCatalogPattern(paramString1));
/* 1267 */       preparedStatement.setString(2, "\\");
/* 1268 */       preparedStatement.setString(3, getSchemaPattern(paramString2));
/* 1269 */       preparedStatement.setString(4, "\\");
/* 1270 */       preparedStatement.setString(5, paramString3);
/* 1271 */       preparedStatement.setString(6, getCatalogPattern(paramString4));
/* 1272 */       preparedStatement.setString(7, "\\");
/* 1273 */       preparedStatement.setString(8, getSchemaPattern(paramString5));
/* 1274 */       preparedStatement.setString(9, "\\");
/* 1275 */       preparedStatement.setString(10, paramString6);
/* 1276 */       return preparedStatement.executeQuery();
/* 1277 */     } catch (Exception exception) {
/* 1278 */       throw logAndConvert(exception);
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
/*      */   public ResultSet getUDTs(String paramString1, String paramString2, String paramString3, int[] paramArrayOfint) throws SQLException {
/*      */     try {
/* 1307 */       if (isDebugEnabled()) {
/* 1308 */         debugCode("getUDTs(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ", " + quoteIntArray(paramArrayOfint) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1314 */       checkClosed();
/* 1315 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT CAST(NULL AS VARCHAR) TYPE_CAT, CAST(NULL AS VARCHAR) TYPE_SCHEM, CAST(NULL AS VARCHAR) TYPE_NAME, CAST(NULL AS VARCHAR) CLASS_NAME, CAST(NULL AS SMALLINT) DATA_TYPE, CAST(NULL AS VARCHAR) REMARKS, CAST(NULL AS SMALLINT) BASE_TYPE FROM DUAL WHERE FALSE");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1324 */       return preparedStatement.executeQuery();
/* 1325 */     } catch (Exception exception) {
/* 1326 */       throw logAndConvert(exception);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getTypeInfo() throws SQLException {
/*      */     try {
/* 1363 */       debugCodeCall("getTypeInfo");
/* 1364 */       checkClosed();
/* 1365 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT TYPE_NAME, DATA_TYPE, PRECISION, PREFIX LITERAL_PREFIX, SUFFIX LITERAL_SUFFIX, PARAMS CREATE_PARAMS, NULLABLE, CASE_SENSITIVE, SEARCHABLE, FALSE UNSIGNED_ATTRIBUTE, FALSE FIXED_PREC_SCALE, AUTO_INCREMENT, TYPE_NAME LOCAL_TYPE_NAME, MINIMUM_SCALE, MAXIMUM_SCALE, DATA_TYPE SQL_DATA_TYPE, ZERO() SQL_DATETIME_SUB, RADIX NUM_PREC_RADIX FROM INFORMATION_SCHEMA.TYPE_INFO ORDER BY DATA_TYPE, POS");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1386 */       return preparedStatement.executeQuery();
/*      */     }
/* 1388 */     catch (Exception exception) {
/* 1389 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean usesLocalFiles() {
/* 1400 */     debugCodeCall("usesLocalFiles");
/* 1401 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean usesLocalFilePerTable() {
/* 1411 */     debugCodeCall("usesLocalFilePerTable");
/* 1412 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getIdentifierQuoteString() {
/* 1422 */     debugCodeCall("getIdentifierQuoteString");
/* 1423 */     return "\"";
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
/*      */   public String getSQLKeywords() {
/* 1446 */     debugCodeCall("getSQLKeywords");
/* 1447 */     return "LIMIT,MINUS,ROWNUM,SYSDATE,SYSTIME,SYSTIMESTAMP,TODAY";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNumericFunctions() throws SQLException {
/* 1457 */     debugCodeCall("getNumericFunctions");
/* 1458 */     return getFunctions("Functions (Numeric)");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStringFunctions() throws SQLException {
/* 1468 */     debugCodeCall("getStringFunctions");
/* 1469 */     return getFunctions("Functions (String)");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSystemFunctions() throws SQLException {
/* 1479 */     debugCodeCall("getSystemFunctions");
/* 1480 */     return getFunctions("Functions (System)");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTimeDateFunctions() throws SQLException {
/* 1490 */     debugCodeCall("getTimeDateFunctions");
/* 1491 */     return getFunctions("Functions (Time and Date)");
/*      */   }
/*      */   
/*      */   private String getFunctions(String paramString) throws SQLException {
/*      */     try {
/* 1496 */       checkClosed();
/* 1497 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT TOPIC FROM INFORMATION_SCHEMA.HELP WHERE SECTION = ?");
/*      */       
/* 1499 */       preparedStatement.setString(1, paramString);
/* 1500 */       ResultSet resultSet = preparedStatement.executeQuery();
/* 1501 */       StatementBuilder statementBuilder = new StatementBuilder();
/* 1502 */       while (resultSet.next()) {
/* 1503 */         String str = resultSet.getString(1).trim();
/* 1504 */         String[] arrayOfString = StringUtils.arraySplit(str, ',', true);
/* 1505 */         for (String str1 : arrayOfString) {
/* 1506 */           statementBuilder.appendExceptFirst(",");
/* 1507 */           String str2 = str1.trim();
/* 1508 */           if (str2.indexOf(' ') >= 0)
/*      */           {
/* 1510 */             str2 = str2.substring(0, str2.indexOf(' ')).trim();
/*      */           }
/* 1512 */           statementBuilder.append(str2);
/*      */         } 
/*      */       } 
/* 1515 */       resultSet.close();
/* 1516 */       preparedStatement.close();
/* 1517 */       return statementBuilder.toString();
/* 1518 */     } catch (Exception exception) {
/* 1519 */       throw logAndConvert(exception);
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
/*      */   public String getSearchStringEscape() {
/* 1532 */     debugCodeCall("getSearchStringEscape");
/* 1533 */     return "\\";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExtraNameCharacters() {
/* 1544 */     debugCodeCall("getExtraNameCharacters");
/* 1545 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsAlterTableWithAddColumn() {
/* 1554 */     debugCodeCall("supportsAlterTableWithAddColumn");
/* 1555 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsAlterTableWithDropColumn() {
/* 1565 */     debugCodeCall("supportsAlterTableWithDropColumn");
/* 1566 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsColumnAliasing() {
/* 1576 */     debugCodeCall("supportsColumnAliasing");
/* 1577 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean nullPlusNonNullIsNull() {
/* 1587 */     debugCodeCall("nullPlusNonNullIsNull");
/* 1588 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsConvert() {
/* 1598 */     debugCodeCall("supportsConvert");
/* 1599 */     return true;
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
/*      */   public boolean supportsConvert(int paramInt1, int paramInt2) {
/* 1611 */     if (isDebugEnabled()) {
/* 1612 */       debugCode("supportsConvert(" + paramInt1 + ", " + paramInt1 + ");");
/*      */     }
/* 1614 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsTableCorrelationNames() {
/* 1624 */     debugCodeCall("supportsTableCorrelationNames");
/* 1625 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsDifferentTableCorrelationNames() {
/* 1636 */     debugCodeCall("supportsDifferentTableCorrelationNames");
/* 1637 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsExpressionsInOrderBy() {
/* 1647 */     debugCodeCall("supportsExpressionsInOrderBy");
/* 1648 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsOrderByUnrelated() {
/* 1659 */     debugCodeCall("supportsOrderByUnrelated");
/* 1660 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsGroupBy() {
/* 1670 */     debugCodeCall("supportsGroupBy");
/* 1671 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsGroupByUnrelated() {
/* 1682 */     debugCodeCall("supportsGroupByUnrelated");
/* 1683 */     return true;
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
/*      */   public boolean supportsGroupByBeyondSelect() {
/* 1695 */     debugCodeCall("supportsGroupByBeyondSelect");
/* 1696 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsLikeEscapeClause() {
/* 1706 */     debugCodeCall("supportsLikeEscapeClause");
/* 1707 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsMultipleResultSets() {
/* 1717 */     debugCodeCall("supportsMultipleResultSets");
/* 1718 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsMultipleTransactions() {
/* 1729 */     debugCodeCall("supportsMultipleTransactions");
/* 1730 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsNonNullableColumns() {
/* 1740 */     debugCodeCall("supportsNonNullableColumns");
/* 1741 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsMinimumSQLGrammar() {
/* 1751 */     debugCodeCall("supportsMinimumSQLGrammar");
/* 1752 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsCoreSQLGrammar() {
/* 1762 */     debugCodeCall("supportsCoreSQLGrammar");
/* 1763 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsExtendedSQLGrammar() {
/* 1773 */     debugCodeCall("supportsExtendedSQLGrammar");
/* 1774 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsANSI92EntryLevelSQL() {
/* 1784 */     debugCodeCall("supportsANSI92EntryLevelSQL");
/* 1785 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsANSI92IntermediateSQL() {
/* 1795 */     debugCodeCall("supportsANSI92IntermediateSQL");
/* 1796 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsANSI92FullSQL() {
/* 1806 */     debugCodeCall("supportsANSI92FullSQL");
/* 1807 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsIntegrityEnhancementFacility() {
/* 1817 */     debugCodeCall("supportsIntegrityEnhancementFacility");
/* 1818 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsOuterJoins() {
/* 1828 */     debugCodeCall("supportsOuterJoins");
/* 1829 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsFullOuterJoins() {
/* 1839 */     debugCodeCall("supportsFullOuterJoins");
/* 1840 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsLimitedOuterJoins() {
/* 1850 */     debugCodeCall("supportsLimitedOuterJoins");
/* 1851 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSchemaTerm() {
/* 1861 */     debugCodeCall("getSchemaTerm");
/* 1862 */     return "schema";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getProcedureTerm() {
/* 1872 */     debugCodeCall("getProcedureTerm");
/* 1873 */     return "procedure";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCatalogTerm() {
/* 1883 */     debugCodeCall("getCatalogTerm");
/* 1884 */     return "catalog";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isCatalogAtStart() {
/* 1894 */     debugCodeCall("isCatalogAtStart");
/* 1895 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCatalogSeparator() {
/* 1905 */     debugCodeCall("getCatalogSeparator");
/* 1906 */     return ".";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsSchemasInDataManipulation() {
/* 1916 */     debugCodeCall("supportsSchemasInDataManipulation");
/* 1917 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsSchemasInProcedureCalls() {
/* 1927 */     debugCodeCall("supportsSchemasInProcedureCalls");
/* 1928 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsSchemasInTableDefinitions() {
/* 1938 */     debugCodeCall("supportsSchemasInTableDefinitions");
/* 1939 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsSchemasInIndexDefinitions() {
/* 1949 */     debugCodeCall("supportsSchemasInIndexDefinitions");
/* 1950 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsSchemasInPrivilegeDefinitions() {
/* 1960 */     debugCodeCall("supportsSchemasInPrivilegeDefinitions");
/* 1961 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsCatalogsInDataManipulation() {
/* 1971 */     debugCodeCall("supportsCatalogsInDataManipulation");
/* 1972 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsCatalogsInProcedureCalls() {
/* 1982 */     debugCodeCall("supportsCatalogsInProcedureCalls");
/* 1983 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsCatalogsInTableDefinitions() {
/* 1993 */     debugCodeCall("supportsCatalogsInTableDefinitions");
/* 1994 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsCatalogsInIndexDefinitions() {
/* 2004 */     debugCodeCall("supportsCatalogsInIndexDefinitions");
/* 2005 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsCatalogsInPrivilegeDefinitions() {
/* 2015 */     debugCodeCall("supportsCatalogsInPrivilegeDefinitions");
/* 2016 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsPositionedDelete() {
/* 2026 */     debugCodeCall("supportsPositionedDelete");
/* 2027 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsPositionedUpdate() {
/* 2037 */     debugCodeCall("supportsPositionedUpdate");
/* 2038 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsSelectForUpdate() {
/* 2048 */     debugCodeCall("supportsSelectForUpdate");
/* 2049 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsStoredProcedures() {
/* 2059 */     debugCodeCall("supportsStoredProcedures");
/* 2060 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsSubqueriesInComparisons() {
/* 2070 */     debugCodeCall("supportsSubqueriesInComparisons");
/* 2071 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsSubqueriesInExists() {
/* 2081 */     debugCodeCall("supportsSubqueriesInExists");
/* 2082 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsSubqueriesInIns() {
/* 2092 */     debugCodeCall("supportsSubqueriesInIns");
/* 2093 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsSubqueriesInQuantifieds() {
/* 2103 */     debugCodeCall("supportsSubqueriesInQuantifieds");
/* 2104 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsCorrelatedSubqueries() {
/* 2114 */     debugCodeCall("supportsCorrelatedSubqueries");
/* 2115 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsUnion() {
/* 2125 */     debugCodeCall("supportsUnion");
/* 2126 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsUnionAll() {
/* 2136 */     debugCodeCall("supportsUnionAll");
/* 2137 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsOpenCursorsAcrossCommit() {
/* 2147 */     debugCodeCall("supportsOpenCursorsAcrossCommit");
/* 2148 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsOpenCursorsAcrossRollback() {
/* 2158 */     debugCodeCall("supportsOpenCursorsAcrossRollback");
/* 2159 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsOpenStatementsAcrossCommit() {
/* 2169 */     debugCodeCall("supportsOpenStatementsAcrossCommit");
/* 2170 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsOpenStatementsAcrossRollback() {
/* 2180 */     debugCodeCall("supportsOpenStatementsAcrossRollback");
/* 2181 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsTransactions() {
/* 2191 */     debugCodeCall("supportsTransactions");
/* 2192 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsTransactionIsolationLevel(int paramInt) throws SQLException {
/* 2203 */     debugCodeCall("supportsTransactionIsolationLevel");
/* 2204 */     if (paramInt == 1) {
/*      */ 
/*      */       
/* 2207 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT VALUE FROM INFORMATION_SCHEMA.SETTINGS WHERE NAME=?");
/*      */       
/* 2209 */       preparedStatement.setString(1, "MULTI_THREADED");
/* 2210 */       ResultSet resultSet = preparedStatement.executeQuery();
/* 2211 */       if (resultSet.next() && resultSet.getString(1).equals("1")) {
/* 2212 */         return false;
/*      */       }
/*      */     } 
/* 2215 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsDataDefinitionAndDataManipulationTransactions() {
/* 2226 */     debugCodeCall("supportsDataDefinitionAndDataManipulationTransactions");
/* 2227 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsDataManipulationTransactionsOnly() {
/* 2237 */     debugCodeCall("supportsDataManipulationTransactionsOnly");
/* 2238 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean dataDefinitionCausesTransactionCommit() {
/* 2248 */     debugCodeCall("dataDefinitionCausesTransactionCommit");
/* 2249 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean dataDefinitionIgnoredInTransactions() {
/* 2259 */     debugCodeCall("dataDefinitionIgnoredInTransactions");
/* 2260 */     return false;
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
/*      */   public boolean supportsResultSetType(int paramInt) {
/* 2272 */     debugCodeCall("supportsResultSetType", paramInt);
/* 2273 */     return (paramInt != 1005);
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
/*      */   public boolean supportsResultSetConcurrency(int paramInt1, int paramInt2) {
/* 2286 */     if (isDebugEnabled()) {
/* 2287 */       debugCode("supportsResultSetConcurrency(" + paramInt1 + ", " + paramInt2 + ");");
/*      */     }
/* 2289 */     return (paramInt1 != 1005);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean ownUpdatesAreVisible(int paramInt) {
/* 2300 */     debugCodeCall("ownUpdatesAreVisible", paramInt);
/* 2301 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean ownDeletesAreVisible(int paramInt) {
/* 2312 */     debugCodeCall("ownDeletesAreVisible", paramInt);
/* 2313 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean ownInsertsAreVisible(int paramInt) {
/* 2324 */     debugCodeCall("ownInsertsAreVisible", paramInt);
/* 2325 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean othersUpdatesAreVisible(int paramInt) {
/* 2336 */     debugCodeCall("othersUpdatesAreVisible", paramInt);
/* 2337 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean othersDeletesAreVisible(int paramInt) {
/* 2348 */     debugCodeCall("othersDeletesAreVisible", paramInt);
/* 2349 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean othersInsertsAreVisible(int paramInt) {
/* 2360 */     debugCodeCall("othersInsertsAreVisible", paramInt);
/* 2361 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean updatesAreDetected(int paramInt) {
/* 2372 */     debugCodeCall("updatesAreDetected", paramInt);
/* 2373 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean deletesAreDetected(int paramInt) {
/* 2384 */     debugCodeCall("deletesAreDetected", paramInt);
/* 2385 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean insertsAreDetected(int paramInt) {
/* 2396 */     debugCodeCall("insertsAreDetected", paramInt);
/* 2397 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsBatchUpdates() {
/* 2407 */     debugCodeCall("supportsBatchUpdates");
/* 2408 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean doesMaxRowSizeIncludeBlobs() {
/* 2418 */     debugCodeCall("doesMaxRowSizeIncludeBlobs");
/* 2419 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDefaultTransactionIsolation() {
/* 2429 */     debugCodeCall("getDefaultTransactionIsolation");
/* 2430 */     return 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsMixedCaseIdentifiers() {
/* 2441 */     debugCodeCall("supportsMixedCaseIdentifiers");
/* 2442 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
/* 2453 */     debugCodeCall("supportsMixedCaseQuotedIdentifiers");
/* 2454 */     String str = this.conn.getMode();
/* 2455 */     if (str.equals("MySQL")) {
/* 2456 */       return false;
/*      */     }
/* 2458 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean storesUpperCaseIdentifiers() throws SQLException {
/* 2469 */     debugCodeCall("storesUpperCaseIdentifiers");
/* 2470 */     String str = this.conn.getMode();
/* 2471 */     if (str.equals("MySQL")) {
/* 2472 */       return false;
/*      */     }
/* 2474 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean storesLowerCaseIdentifiers() throws SQLException {
/* 2485 */     debugCodeCall("storesLowerCaseIdentifiers");
/* 2486 */     String str = this.conn.getMode();
/* 2487 */     if (str.equals("MySQL")) {
/* 2488 */       return true;
/*      */     }
/* 2490 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean storesMixedCaseIdentifiers() {
/* 2501 */     debugCodeCall("storesMixedCaseIdentifiers");
/* 2502 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
/* 2513 */     debugCodeCall("storesUpperCaseQuotedIdentifiers");
/* 2514 */     String str = this.conn.getMode();
/* 2515 */     if (str.equals("MySQL")) {
/* 2516 */       return true;
/*      */     }
/* 2518 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
/* 2529 */     debugCodeCall("storesLowerCaseQuotedIdentifiers");
/* 2530 */     String str = this.conn.getMode();
/* 2531 */     if (str.equals("MySQL")) {
/* 2532 */       return true;
/*      */     }
/* 2534 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
/* 2545 */     debugCodeCall("storesMixedCaseQuotedIdentifiers");
/* 2546 */     String str = this.conn.getMode();
/* 2547 */     if (str.equals("MySQL")) {
/* 2548 */       return false;
/*      */     }
/* 2550 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxBinaryLiteralLength() {
/* 2560 */     debugCodeCall("getMaxBinaryLiteralLength");
/* 2561 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxCharLiteralLength() {
/* 2571 */     debugCodeCall("getMaxCharLiteralLength");
/* 2572 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxColumnNameLength() {
/* 2582 */     debugCodeCall("getMaxColumnNameLength");
/* 2583 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxColumnsInGroupBy() {
/* 2593 */     debugCodeCall("getMaxColumnsInGroupBy");
/* 2594 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxColumnsInIndex() {
/* 2604 */     debugCodeCall("getMaxColumnsInIndex");
/* 2605 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxColumnsInOrderBy() {
/* 2615 */     debugCodeCall("getMaxColumnsInOrderBy");
/* 2616 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxColumnsInSelect() {
/* 2626 */     debugCodeCall("getMaxColumnsInSelect");
/* 2627 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxColumnsInTable() {
/* 2637 */     debugCodeCall("getMaxColumnsInTable");
/* 2638 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxConnections() {
/* 2648 */     debugCodeCall("getMaxConnections");
/* 2649 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxCursorNameLength() {
/* 2659 */     debugCodeCall("getMaxCursorNameLength");
/* 2660 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxIndexLength() {
/* 2670 */     debugCodeCall("getMaxIndexLength");
/* 2671 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxSchemaNameLength() {
/* 2681 */     debugCodeCall("getMaxSchemaNameLength");
/* 2682 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxProcedureNameLength() {
/* 2692 */     debugCodeCall("getMaxProcedureNameLength");
/* 2693 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxCatalogNameLength() {
/* 2703 */     debugCodeCall("getMaxCatalogNameLength");
/* 2704 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxRowSize() {
/* 2714 */     debugCodeCall("getMaxRowSize");
/* 2715 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxStatementLength() {
/* 2725 */     debugCodeCall("getMaxStatementLength");
/* 2726 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxStatements() {
/* 2736 */     debugCodeCall("getMaxStatements");
/* 2737 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxTableNameLength() {
/* 2747 */     debugCodeCall("getMaxTableNameLength");
/* 2748 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxTablesInSelect() {
/* 2758 */     debugCodeCall("getMaxTablesInSelect");
/* 2759 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxUserNameLength() {
/* 2769 */     debugCodeCall("getMaxUserNameLength");
/* 2770 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsSavepoints() {
/* 2780 */     debugCodeCall("supportsSavepoints");
/* 2781 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsNamedParameters() {
/* 2791 */     debugCodeCall("supportsNamedParameters");
/* 2792 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsMultipleOpenResults() {
/* 2802 */     debugCodeCall("supportsMultipleOpenResults");
/* 2803 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsGetGeneratedKeys() {
/* 2813 */     debugCodeCall("supportsGetGeneratedKeys");
/* 2814 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getSuperTypes(String paramString1, String paramString2, String paramString3) throws SQLException {
/* 2823 */     throw unsupported("superTypes");
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
/*      */   public ResultSet getSuperTables(String paramString1, String paramString2, String paramString3) throws SQLException {
/*      */     try {
/* 2847 */       if (isDebugEnabled()) {
/* 2848 */         debugCode("getSuperTables(" + quote(paramString1) + ", " + quote(paramString2) + ", " + quote(paramString3) + ");");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 2853 */       checkClosed();
/* 2854 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT CATALOG_NAME TABLE_CAT, CATALOG_NAME TABLE_SCHEM, CATALOG_NAME TABLE_NAME, CATALOG_NAME SUPERTABLE_NAME FROM INFORMATION_SCHEMA.CATALOGS WHERE FALSE");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2861 */       return preparedStatement.executeQuery();
/* 2862 */     } catch (Exception exception) {
/* 2863 */       throw logAndConvert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getAttributes(String paramString1, String paramString2, String paramString3, String paramString4) throws SQLException {
/* 2874 */     throw unsupported("attributes");
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
/*      */   public boolean supportsResultSetHoldability(int paramInt) {
/* 2886 */     debugCodeCall("supportsResultSetHoldability", paramInt);
/* 2887 */     return (paramInt == 2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getResultSetHoldability() {
/* 2897 */     debugCodeCall("getResultSetHoldability");
/* 2898 */     return 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDatabaseMajorVersion() {
/* 2908 */     debugCodeCall("getDatabaseMajorVersion");
/* 2909 */     return 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDatabaseMinorVersion() {
/* 2919 */     debugCodeCall("getDatabaseMinorVersion");
/* 2920 */     return 4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getJDBCMajorVersion() {
/* 2930 */     debugCodeCall("getJDBCMajorVersion");
/* 2931 */     return 4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getJDBCMinorVersion() {
/* 2941 */     debugCodeCall("getJDBCMinorVersion");
/* 2942 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSQLStateType() {
/* 2952 */     debugCodeCall("getSQLStateType");
/* 2953 */     return 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean locatorsUpdateCopy() {
/* 2963 */     debugCodeCall("locatorsUpdateCopy");
/* 2964 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean supportsStatementPooling() {
/* 2974 */     debugCodeCall("supportsStatementPooling");
/* 2975 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkClosed() {
/* 2981 */     this.conn.checkClosed();
/*      */   }
/*      */   
/*      */   private static String getPattern(String paramString) {
/* 2985 */     return (paramString == null) ? "%" : paramString;
/*      */   }
/*      */   
/*      */   private static String getSchemaPattern(String paramString) {
/* 2989 */     return (paramString == null) ? "%" : ((paramString.length() == 0) ? "PUBLIC" : paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String getCatalogPattern(String paramString) {
/* 2996 */     return (paramString == null || paramString.length() == 0) ? "%" : paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RowIdLifetime getRowIdLifetime() {
/* 3007 */     debugCodeCall("getRowIdLifetime");
/* 3008 */     return RowIdLifetime.ROWID_UNSUPPORTED;
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
/*      */   public ResultSet getSchemas(String paramString1, String paramString2) throws SQLException {
/*      */     try {
/* 3031 */       debugCodeCall("getSchemas(String,String)");
/* 3032 */       checkClosed();
/* 3033 */       PreparedStatement preparedStatement = this.conn.prepareAutoCloseStatement("SELECT SCHEMA_NAME TABLE_SCHEM, CATALOG_NAME TABLE_CATALOG,  IS_DEFAULT FROM INFORMATION_SCHEMA.SCHEMATA WHERE CATALOG_NAME LIKE ? ESCAPE ? AND SCHEMA_NAME LIKE ? ESCAPE ? ORDER BY SCHEMA_NAME");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3042 */       preparedStatement.setString(1, getCatalogPattern(paramString1));
/* 3043 */       preparedStatement.setString(2, "\\");
/* 3044 */       preparedStatement.setString(3, getSchemaPattern(paramString2));
/* 3045 */       preparedStatement.setString(4, "\\");
/* 3046 */       return preparedStatement.executeQuery();
/* 3047 */     } catch (Exception exception) {
/* 3048 */       throw logAndConvert(exception);
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
/*      */   public boolean supportsStoredFunctionsUsingCallSyntax() {
/* 3060 */     debugCodeCall("supportsStoredFunctionsUsingCallSyntax");
/* 3061 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean autoCommitFailureClosesAllResultSets() {
/* 3072 */     debugCodeCall("autoCommitFailureClosesAllResultSets");
/* 3073 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public ResultSet getClientInfoProperties() throws SQLException {
/* 3078 */     Properties properties = this.conn.getClientInfo();
/* 3079 */     SimpleResultSet simpleResultSet = new SimpleResultSet();
/* 3080 */     simpleResultSet.addColumn("Name", 12, 0, 0);
/* 3081 */     simpleResultSet.addColumn("Value", 12, 0, 0);
/* 3082 */     for (Object object : properties.keySet()) {
/* 3083 */       simpleResultSet.addRow(new Object[] { object, properties.get(object) });
/*      */     } 
/* 3085 */     return (ResultSet)simpleResultSet;
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
/* 3097 */     if (isWrapperFor(paramClass)) {
/* 3098 */       return (T)this;
/*      */     }
/* 3100 */     throw DbException.getInvalidValueException("iface", paramClass);
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
/* 3111 */     return (paramClass != null && paramClass.isAssignableFrom(getClass()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getFunctionColumns(String paramString1, String paramString2, String paramString3, String paramString4) throws SQLException {
/* 3121 */     throw unsupported("getFunctionColumns");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultSet getFunctions(String paramString1, String paramString2, String paramString3) throws SQLException {
/* 3130 */     throw unsupported("getFunctions");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean generatedKeyAlwaysReturned() {
/* 3138 */     return true;
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
/*      */   public ResultSet getPseudoColumns(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 3155 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 3163 */     return getTraceObjectName() + ": " + this.conn;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcDatabaseMetaData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */