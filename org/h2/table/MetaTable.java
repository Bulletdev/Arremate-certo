/*      */ package org.h2.table;
/*      */ 
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStreamReader;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Timestamp;
/*      */ import java.text.Collator;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Locale;
/*      */ import org.h2.command.Command;
/*      */ import org.h2.constraint.Constraint;
/*      */ import org.h2.constraint.ConstraintCheck;
/*      */ import org.h2.constraint.ConstraintReferential;
/*      */ import org.h2.constraint.ConstraintUnique;
/*      */ import org.h2.engine.Constants;
/*      */ import org.h2.engine.Database;
/*      */ import org.h2.engine.DbObject;
/*      */ import org.h2.engine.FunctionAlias;
/*      */ import org.h2.engine.QueryStatisticsData;
/*      */ import org.h2.engine.Right;
/*      */ import org.h2.engine.Role;
/*      */ import org.h2.engine.Session;
/*      */ import org.h2.engine.Setting;
/*      */ import org.h2.engine.User;
/*      */ import org.h2.engine.UserAggregate;
/*      */ import org.h2.engine.UserDataType;
/*      */ import org.h2.expression.ValueExpression;
/*      */ import org.h2.index.Index;
/*      */ import org.h2.index.IndexType;
/*      */ import org.h2.index.MetaIndex;
/*      */ import org.h2.index.MultiVersionIndex;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.mvstore.FileStore;
/*      */ import org.h2.mvstore.db.MVTableEngine;
/*      */ import org.h2.result.Row;
/*      */ import org.h2.result.SearchRow;
/*      */ import org.h2.schema.Constant;
/*      */ import org.h2.schema.Schema;
/*      */ import org.h2.schema.SchemaObject;
/*      */ import org.h2.schema.Sequence;
/*      */ import org.h2.schema.TriggerObject;
/*      */ import org.h2.store.InDoubtTransaction;
/*      */ import org.h2.store.PageStore;
/*      */ import org.h2.tools.Csv;
/*      */ import org.h2.util.MathUtils;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.StatementBuilder;
/*      */ import org.h2.util.StringUtils;
/*      */ import org.h2.util.Utils;
/*      */ import org.h2.value.CompareMode;
/*      */ import org.h2.value.DataType;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueNull;
/*      */ import org.h2.value.ValueString;
/*      */ import org.h2.value.ValueStringIgnoreCase;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MetaTable
/*      */   extends Table
/*      */ {
/*      */   public static final long ROW_COUNT_APPROXIMATION = 1000L;
/*      */   private static final String CHARACTER_SET_NAME = "Unicode";
/*      */   private static final int TABLES = 0;
/*      */   private static final int COLUMNS = 1;
/*      */   private static final int INDEXES = 2;
/*      */   private static final int TABLE_TYPES = 3;
/*      */   private static final int TYPE_INFO = 4;
/*      */   private static final int CATALOGS = 5;
/*      */   private static final int SETTINGS = 6;
/*      */   private static final int HELP = 7;
/*      */   private static final int SEQUENCES = 8;
/*      */   private static final int USERS = 9;
/*      */   private static final int ROLES = 10;
/*      */   private static final int RIGHTS = 11;
/*      */   private static final int FUNCTION_ALIASES = 12;
/*      */   private static final int SCHEMATA = 13;
/*      */   private static final int TABLE_PRIVILEGES = 14;
/*      */   private static final int COLUMN_PRIVILEGES = 15;
/*      */   private static final int COLLATIONS = 16;
/*      */   private static final int VIEWS = 17;
/*      */   private static final int IN_DOUBT = 18;
/*      */   private static final int CROSS_REFERENCES = 19;
/*      */   private static final int CONSTRAINTS = 20;
/*      */   private static final int FUNCTION_COLUMNS = 21;
/*      */   private static final int CONSTANTS = 22;
/*      */   private static final int DOMAINS = 23;
/*      */   private static final int TRIGGERS = 24;
/*      */   private static final int SESSIONS = 25;
/*      */   private static final int LOCKS = 26;
/*      */   private static final int SESSION_STATE = 27;
/*      */   private static final int QUERY_STATISTICS = 28;
/*      */   private static final int META_TABLE_TYPE_COUNT = 29;
/*      */   private final int type;
/*      */   private final int indexColumn;
/*      */   private final MetaIndex metaIndex;
/*      */   
/*      */   public MetaTable(Schema paramSchema, int paramInt1, int paramInt2) {
/*  126 */     super(paramSchema, paramInt1, (String)null, true, true); Column[] arrayOfColumn;
/*  127 */     this.type = paramInt2;
/*      */     
/*  129 */     String str = null;
/*  130 */     switch (paramInt2) {
/*      */       case 0:
/*  132 */         setObjectName("TABLES");
/*  133 */         arrayOfColumn = createColumns(new String[] { "TABLE_CATALOG", "TABLE_SCHEMA", "TABLE_NAME", "TABLE_TYPE", "STORAGE_TYPE", "SQL", "REMARKS", "LAST_MODIFICATION BIGINT", "ID INT", "TYPE_NAME", "TABLE_CLASS", "ROW_COUNT_ESTIMATE BIGINT" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  148 */         str = "TABLE_NAME";
/*      */         break;
/*      */       case 1:
/*  151 */         setObjectName("COLUMNS");
/*  152 */         arrayOfColumn = createColumns(new String[] { "TABLE_CATALOG", "TABLE_SCHEMA", "TABLE_NAME", "COLUMN_NAME", "ORDINAL_POSITION INT", "COLUMN_DEFAULT", "IS_NULLABLE", "DATA_TYPE INT", "CHARACTER_MAXIMUM_LENGTH INT", "CHARACTER_OCTET_LENGTH INT", "NUMERIC_PRECISION INT", "NUMERIC_PRECISION_RADIX INT", "NUMERIC_SCALE INT", "CHARACTER_SET_NAME", "COLLATION_NAME", "TYPE_NAME", "NULLABLE INT", "IS_COMPUTED BIT", "SELECTIVITY INT", "CHECK_CONSTRAINT", "SEQUENCE_NAME", "REMARKS", "SOURCE_DATA_TYPE SMALLINT" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  178 */         str = "TABLE_NAME";
/*      */         break;
/*      */       case 2:
/*  181 */         setObjectName("INDEXES");
/*  182 */         arrayOfColumn = createColumns(new String[] { "TABLE_CATALOG", "TABLE_SCHEMA", "TABLE_NAME", "NON_UNIQUE BIT", "INDEX_NAME", "ORDINAL_POSITION SMALLINT", "COLUMN_NAME", "CARDINALITY INT", "PRIMARY_KEY BIT", "INDEX_TYPE_NAME", "IS_GENERATED BIT", "INDEX_TYPE SMALLINT", "ASC_OR_DESC", "PAGES INT", "FILTER_CONDITION", "REMARKS", "SQL", "ID INT", "SORT_TYPE INT", "CONSTRAINT_NAME", "INDEX_CLASS" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  205 */         str = "TABLE_NAME";
/*      */         break;
/*      */       case 3:
/*  208 */         setObjectName("TABLE_TYPES");
/*  209 */         arrayOfColumn = createColumns(new String[] { "TYPE" });
/*      */         break;
/*      */       case 4:
/*  212 */         setObjectName("TYPE_INFO");
/*  213 */         arrayOfColumn = createColumns(new String[] { "TYPE_NAME", "DATA_TYPE INT", "PRECISION INT", "PREFIX", "SUFFIX", "PARAMS", "AUTO_INCREMENT BIT", "MINIMUM_SCALE SMALLINT", "MAXIMUM_SCALE SMALLINT", "RADIX INT", "POS INT", "CASE_SENSITIVE BIT", "NULLABLE SMALLINT", "SEARCHABLE SMALLINT" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 5:
/*  231 */         setObjectName("CATALOGS");
/*  232 */         arrayOfColumn = createColumns(new String[] { "CATALOG_NAME" });
/*      */         break;
/*      */       case 6:
/*  235 */         setObjectName("SETTINGS");
/*  236 */         arrayOfColumn = createColumns(new String[] { "NAME", "VALUE" });
/*      */         break;
/*      */       case 7:
/*  239 */         setObjectName("HELP");
/*  240 */         arrayOfColumn = createColumns(new String[] { "ID INT", "SECTION", "TOPIC", "SYNTAX", "TEXT" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 8:
/*  249 */         setObjectName("SEQUENCES");
/*  250 */         arrayOfColumn = createColumns(new String[] { "SEQUENCE_CATALOG", "SEQUENCE_SCHEMA", "SEQUENCE_NAME", "CURRENT_VALUE BIGINT", "INCREMENT BIGINT", "IS_GENERATED BIT", "REMARKS", "CACHE BIGINT", "MIN_VALUE BIGINT", "MAX_VALUE BIGINT", "IS_CYCLE BIT", "ID INT" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 9:
/*  266 */         setObjectName("USERS");
/*  267 */         arrayOfColumn = createColumns(new String[] { "NAME", "ADMIN", "REMARKS", "ID INT" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 10:
/*  275 */         setObjectName("ROLES");
/*  276 */         arrayOfColumn = createColumns(new String[] { "NAME", "REMARKS", "ID INT" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 11:
/*  283 */         setObjectName("RIGHTS");
/*  284 */         arrayOfColumn = createColumns(new String[] { "GRANTEE", "GRANTEETYPE", "GRANTEDROLE", "RIGHTS", "TABLE_SCHEMA", "TABLE_NAME", "ID INT" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  293 */         str = "TABLE_NAME";
/*      */         break;
/*      */       case 12:
/*  296 */         setObjectName("FUNCTION_ALIASES");
/*  297 */         arrayOfColumn = createColumns(new String[] { "ALIAS_CATALOG", "ALIAS_SCHEMA", "ALIAS_NAME", "JAVA_CLASS", "JAVA_METHOD", "DATA_TYPE INT", "TYPE_NAME", "COLUMN_COUNT INT", "RETURNS_RESULT SMALLINT", "REMARKS", "ID INT", "SOURCE" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 21:
/*  313 */         setObjectName("FUNCTION_COLUMNS");
/*  314 */         arrayOfColumn = createColumns(new String[] { "ALIAS_CATALOG", "ALIAS_SCHEMA", "ALIAS_NAME", "JAVA_CLASS", "JAVA_METHOD", "COLUMN_COUNT INT", "POS INT", "COLUMN_NAME", "DATA_TYPE INT", "TYPE_NAME", "PRECISION INT", "SCALE SMALLINT", "RADIX SMALLINT", "NULLABLE SMALLINT", "COLUMN_TYPE SMALLINT", "REMARKS", "COLUMN_DEFAULT" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 13:
/*  335 */         setObjectName("SCHEMATA");
/*  336 */         arrayOfColumn = createColumns(new String[] { "CATALOG_NAME", "SCHEMA_NAME", "SCHEMA_OWNER", "DEFAULT_CHARACTER_SET_NAME", "DEFAULT_COLLATION_NAME", "IS_DEFAULT BIT", "REMARKS", "ID INT" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 14:
/*  348 */         setObjectName("TABLE_PRIVILEGES");
/*  349 */         arrayOfColumn = createColumns(new String[] { "GRANTOR", "GRANTEE", "TABLE_CATALOG", "TABLE_SCHEMA", "TABLE_NAME", "PRIVILEGE_TYPE", "IS_GRANTABLE" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  358 */         str = "TABLE_NAME";
/*      */         break;
/*      */       case 15:
/*  361 */         setObjectName("COLUMN_PRIVILEGES");
/*  362 */         arrayOfColumn = createColumns(new String[] { "GRANTOR", "GRANTEE", "TABLE_CATALOG", "TABLE_SCHEMA", "TABLE_NAME", "COLUMN_NAME", "PRIVILEGE_TYPE", "IS_GRANTABLE" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  372 */         str = "TABLE_NAME";
/*      */         break;
/*      */       case 16:
/*  375 */         setObjectName("COLLATIONS");
/*  376 */         arrayOfColumn = createColumns(new String[] { "NAME", "KEY" });
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 17:
/*  382 */         setObjectName("VIEWS");
/*  383 */         arrayOfColumn = createColumns(new String[] { "TABLE_CATALOG", "TABLE_SCHEMA", "TABLE_NAME", "VIEW_DEFINITION", "CHECK_OPTION", "IS_UPDATABLE", "STATUS", "REMARKS", "ID INT" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  394 */         str = "TABLE_NAME";
/*      */         break;
/*      */       case 18:
/*  397 */         setObjectName("IN_DOUBT");
/*  398 */         arrayOfColumn = createColumns(new String[] { "TRANSACTION", "STATE" });
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 19:
/*  404 */         setObjectName("CROSS_REFERENCES");
/*  405 */         arrayOfColumn = createColumns(new String[] { "PKTABLE_CATALOG", "PKTABLE_SCHEMA", "PKTABLE_NAME", "PKCOLUMN_NAME", "FKTABLE_CATALOG", "FKTABLE_SCHEMA", "FKTABLE_NAME", "FKCOLUMN_NAME", "ORDINAL_POSITION SMALLINT", "UPDATE_RULE SMALLINT", "DELETE_RULE SMALLINT", "FK_NAME", "PK_NAME", "DEFERRABILITY SMALLINT" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  421 */         str = "PKTABLE_NAME";
/*      */         break;
/*      */       case 20:
/*  424 */         setObjectName("CONSTRAINTS");
/*  425 */         arrayOfColumn = createColumns(new String[] { "CONSTRAINT_CATALOG", "CONSTRAINT_SCHEMA", "CONSTRAINT_NAME", "CONSTRAINT_TYPE", "TABLE_CATALOG", "TABLE_SCHEMA", "TABLE_NAME", "UNIQUE_INDEX_NAME", "CHECK_EXPRESSION", "COLUMN_LIST", "REMARKS", "SQL", "ID INT" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  440 */         str = "TABLE_NAME";
/*      */         break;
/*      */       case 22:
/*  443 */         setObjectName("CONSTANTS");
/*  444 */         arrayOfColumn = createColumns(new String[] { "CONSTANT_CATALOG", "CONSTANT_SCHEMA", "CONSTANT_NAME", "DATA_TYPE INT", "REMARKS", "SQL", "ID INT" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 23:
/*  455 */         setObjectName("DOMAINS");
/*  456 */         arrayOfColumn = createColumns(new String[] { "DOMAIN_CATALOG", "DOMAIN_SCHEMA", "DOMAIN_NAME", "COLUMN_DEFAULT", "IS_NULLABLE", "DATA_TYPE INT", "PRECISION INT", "SCALE INT", "TYPE_NAME", "SELECTIVITY INT", "CHECK_CONSTRAINT", "REMARKS", "SQL", "ID INT" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 24:
/*  474 */         setObjectName("TRIGGERS");
/*  475 */         arrayOfColumn = createColumns(new String[] { "TRIGGER_CATALOG", "TRIGGER_SCHEMA", "TRIGGER_NAME", "TRIGGER_TYPE", "TABLE_CATALOG", "TABLE_SCHEMA", "TABLE_NAME", "BEFORE BIT", "JAVA_CLASS", "QUEUE_SIZE INT", "NO_WAIT BIT", "REMARKS", "SQL", "ID INT" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 25:
/*  493 */         setObjectName("SESSIONS");
/*  494 */         arrayOfColumn = createColumns(new String[] { "ID INT", "USER_NAME", "SESSION_START", "STATEMENT", "STATEMENT_START", "CONTAINS_UNCOMMITTED" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 26:
/*  505 */         setObjectName("LOCKS");
/*  506 */         arrayOfColumn = createColumns(new String[] { "TABLE_SCHEMA", "TABLE_NAME", "SESSION_ID INT", "LOCK_TYPE" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 27:
/*  515 */         setObjectName("SESSION_STATE");
/*  516 */         arrayOfColumn = createColumns(new String[] { "KEY", "SQL" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 28:
/*  523 */         setObjectName("QUERY_STATISTICS");
/*  524 */         arrayOfColumn = createColumns(new String[] { "SQL_STATEMENT", "EXECUTION_COUNT INT", "MIN_EXECUTION_TIME DOUBLE", "MAX_EXECUTION_TIME DOUBLE", "CUMULATIVE_EXECUTION_TIME DOUBLE", "AVERAGE_EXECUTION_TIME DOUBLE", "STD_DEV_EXECUTION_TIME DOUBLE", "MIN_ROW_COUNT INT", "MAX_ROW_COUNT INT", "CUMULATIVE_ROW_COUNT LONG", "AVERAGE_ROW_COUNT DOUBLE", "STD_DEV_ROW_COUNT DOUBLE" });
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/*  541 */         throw DbException.throwInternalError("type=" + paramInt2);
/*      */     } 
/*  543 */     setColumns(arrayOfColumn);
/*      */     
/*  545 */     if (str == null) {
/*  546 */       this.indexColumn = -1;
/*  547 */       this.metaIndex = null;
/*      */     } else {
/*  549 */       this.indexColumn = getColumn(str).getColumnId();
/*  550 */       IndexColumn[] arrayOfIndexColumn = IndexColumn.wrap(new Column[] { arrayOfColumn[this.indexColumn] });
/*      */       
/*  552 */       this.metaIndex = new MetaIndex(this, arrayOfIndexColumn, false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private Column[] createColumns(String... paramVarArgs) {
/*  557 */     Column[] arrayOfColumn = new Column[paramVarArgs.length];
/*  558 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*  559 */       int j; String str2, str1 = paramVarArgs[b];
/*  560 */       int i = str1.indexOf(' ');
/*      */ 
/*      */       
/*  563 */       if (i < 0) {
/*  564 */         j = (this.database.getMode()).lowerCaseIdentifiers ? 14 : 13;
/*      */         
/*  566 */         str2 = str1;
/*      */       } else {
/*  568 */         j = (DataType.getTypeByName(str1.substring(i + 1))).type;
/*  569 */         str2 = str1.substring(0, i);
/*      */       } 
/*  571 */       arrayOfColumn[b] = new Column(str2, j);
/*      */     } 
/*  573 */     return arrayOfColumn;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getDropSQL() {
/*  578 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCreateSQL() {
/*  583 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Index addIndex(Session paramSession, String paramString1, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType, boolean paramBoolean, String paramString2) {
/*  590 */     throw DbException.getUnsupportedException("META");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean lock(Session paramSession, boolean paramBoolean1, boolean paramBoolean2) {
/*  596 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isLockedExclusively() {
/*  601 */     return false;
/*      */   }
/*      */   
/*      */   private String identifier(String paramString) {
/*  605 */     if ((this.database.getMode()).lowerCaseIdentifiers) {
/*  606 */       paramString = (paramString == null) ? null : StringUtils.toLowerEnglish(paramString);
/*      */     }
/*  608 */     return paramString;
/*      */   }
/*      */   
/*      */   private ArrayList<Table> getAllTables(Session paramSession) {
/*  612 */     ArrayList<Table> arrayList = this.database.getAllTablesAndViews(true);
/*  613 */     ArrayList arrayList1 = paramSession.getLocalTempTables();
/*  614 */     arrayList.addAll(arrayList1);
/*  615 */     return arrayList;
/*      */   }
/*      */   
/*      */   private ArrayList<Table> getTablesByName(Session paramSession, String paramString) {
/*  619 */     if ((this.database.getMode()).lowerCaseIdentifiers) {
/*  620 */       paramString = StringUtils.toUpperEnglish(paramString);
/*      */     }
/*  622 */     ArrayList<Table> arrayList = this.database.getTableOrViewByName(paramString);
/*  623 */     for (Table table : paramSession.getLocalTempTables()) {
/*  624 */       if (table.getName().equals(paramString)) {
/*  625 */         arrayList.add(table);
/*      */       }
/*      */     } 
/*  628 */     return arrayList;
/*      */   }
/*      */   
/*      */   private boolean checkIndex(Session paramSession, String paramString, Value paramValue1, Value paramValue2) {
/*      */     Value value;
/*  633 */     if (paramString == null || (paramValue1 == null && paramValue2 == null)) {
/*  634 */       return true;
/*      */     }
/*  636 */     Database database = paramSession.getDatabase();
/*      */     
/*  638 */     if ((this.database.getMode()).lowerCaseIdentifiers) {
/*  639 */       ValueStringIgnoreCase valueStringIgnoreCase = ValueStringIgnoreCase.get(paramString);
/*      */     } else {
/*  641 */       value = ValueString.get(paramString);
/*      */     } 
/*  643 */     if (paramValue1 != null && database.compare(value, paramValue1) < 0) {
/*  644 */       return false;
/*      */     }
/*  646 */     if (paramValue2 != null && database.compare(value, paramValue2) > 0) {
/*  647 */       return false;
/*      */     }
/*  649 */     return true;
/*      */   }
/*      */   
/*      */   private static String replaceNullWithEmpty(String paramString) {
/*  653 */     return (paramString == null) ? "" : paramString;
/*      */   }
/*      */   
/*      */   private boolean hideTable(Table paramTable, Session paramSession) {
/*  657 */     return (paramTable.isHidden() && paramSession != this.database.getSystemSession());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ArrayList<Row> generateRows(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*      */     ArrayList<Table> arrayList2;
/*      */     String str2;
/*      */     ArrayList arrayList1;
/*      */     long l;
/*      */     String[] arrayOfString;
/*      */     QueryStatisticsData queryStatisticsData;
/*      */     HashMap hashMap;
/*      */     String str3;
/*  671 */     Value value1 = null, value2 = null;
/*      */     
/*  673 */     if (this.indexColumn >= 0) {
/*  674 */       if (paramSearchRow1 != null) {
/*  675 */         value1 = paramSearchRow1.getValue(this.indexColumn);
/*      */       }
/*  677 */       if (paramSearchRow2 != null) {
/*  678 */         value2 = paramSearchRow2.getValue(this.indexColumn);
/*      */       }
/*      */     } 
/*      */     
/*  682 */     ArrayList<Row> arrayList = New.arrayList();
/*  683 */     String str1 = identifier(this.database.getShortName());
/*  684 */     boolean bool = paramSession.getUser().isAdmin();
/*  685 */     switch (this.type)
/*      */     { case 0:
/*  687 */         for (Table table : getAllTables(paramSession)) {
/*  688 */           String str5, str4 = identifier(table.getName());
/*  689 */           if (!checkIndex(paramSession, str4, value1, value2)) {
/*      */             continue;
/*      */           }
/*  692 */           if (hideTable(table, paramSession)) {
/*      */             continue;
/*      */           }
/*      */           
/*  696 */           if (table.isTemporary()) {
/*  697 */             if (table.isGlobalTemporary()) {
/*  698 */               str5 = "GLOBAL TEMPORARY";
/*      */             } else {
/*  700 */               str5 = "LOCAL TEMPORARY";
/*      */             } 
/*      */           } else {
/*  703 */             str5 = table.isPersistIndexes() ? "CACHED" : "MEMORY";
/*      */           } 
/*      */           
/*  706 */           String str6 = table.getCreateSQL();
/*  707 */           if (!bool && 
/*  708 */             str6 != null && str6.contains("--hide--"))
/*      */           {
/*  710 */             str6 = "-";
/*      */           }
/*      */           
/*  713 */           add(arrayList, new String[] { str1, identifier(table.getSchema().getName()), str4, table.getTableType(), str5, str6, replaceNullWithEmpty(table.getComment()), "" + table.getMaxDataModificationId(), "" + table.getId(), null, table.getClass().getName(), "" + table.getRowCountApproximation() });
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1864 */         return arrayList;case 1: if (value1 != null && value2 != null && value1.equals(value2)) { String str = identifier(value1.getString()); arrayList2 = getTablesByName(paramSession, str); } else { arrayList2 = getAllTables(paramSession); }  for (Table table : arrayList2) { String str4 = identifier(table.getName()); if (!checkIndex(paramSession, str4, value1, value2)) continue;  if (hideTable(table, paramSession)) continue;  Column[] arrayOfColumn = table.getColumns(); String str5 = this.database.getCompareMode().getName(); for (byte b = 0; b < arrayOfColumn.length; b++) { Column column = arrayOfColumn[b]; Sequence sequence = column.getSequence(); add(arrayList, new String[] { str1, identifier(table.getSchema().getName()), str4, identifier(column.getName()), String.valueOf(b + 1), column.getDefaultSQL(), column.isNullable() ? "YES" : "NO", "" + DataType.convertTypeToSQLType(column.getType()), "" + column.getPrecisionAsInt(), "" + column.getPrecisionAsInt(), "" + column.getPrecisionAsInt(), "10", "" + column.getScale(), "Unicode", str5, identifier((DataType.getDataType(column.getType())).name), "" + (column.isNullable() ? 1 : 0), "" + (column.getComputed() ? "TRUE" : "FALSE"), "" + column.getSelectivity(), column.getCheckConstraintSQL(paramSession, column.getName()), (sequence == null) ? null : sequence.getName(), replaceNullWithEmpty(column.getComment()), null }); }  }  return arrayList;case 2: if (value1 != null && value2 != null && value1.equals(value2)) { String str = identifier(value1.getString()); arrayList2 = getTablesByName(paramSession, str); } else { arrayList2 = getAllTables(paramSession); }  for (Table table : arrayList2) { String str = identifier(table.getName()); if (!checkIndex(paramSession, str, value1, value2)) continue;  if (hideTable(table, paramSession)) continue;  ArrayList<Index> arrayList3 = table.getIndexes(); ArrayList<Constraint> arrayList4 = table.getConstraints(); for (byte b = 0; arrayList3 != null && b < arrayList3.size(); b++) { Index index = arrayList3.get(b); if (index.getCreateSQL() != null) { String str5, str4 = null; for (byte b1 = 0; arrayList4 != null && b1 < arrayList4.size(); b1++) { Constraint constraint = arrayList4.get(b1); if (constraint.usesIndex(index)) if (index.getIndexType().isPrimaryKey()) { if (constraint.getConstraintType().equals("PRIMARY KEY")) str4 = constraint.getName();  } else { str4 = constraint.getName(); }   }  IndexColumn[] arrayOfIndexColumn = index.getIndexColumns(); if (index instanceof MultiVersionIndex) { str5 = ((MultiVersionIndex)index).getBaseIndex().getClass().getName(); } else { str5 = index.getClass().getName(); }  for (byte b2 = 0; b2 < arrayOfIndexColumn.length; b2++) { IndexColumn indexColumn = arrayOfIndexColumn[b2]; Column column = indexColumn.column; add(arrayList, new String[] { str1, identifier(table.getSchema().getName()), str, index.getIndexType().isUnique() ? "FALSE" : "TRUE", identifier(index.getName()), "" + (b2 + 1), identifier(column.getName()), "0", index.getIndexType().isPrimaryKey() ? "TRUE" : "FALSE", index.getIndexType().getSQL(), index.getIndexType().getBelongsToConstraint() ? "TRUE" : "FALSE", "3", ((indexColumn.sortType & 0x1) != 0) ? "D" : "A", "0", "", replaceNullWithEmpty(index.getComment()), index.getCreateSQL(), "" + index.getId(), "" + indexColumn.sortType, str4, str5 }); }  }  }  }  return arrayList;case 3: add(arrayList, new String[] { "TABLE" }); add(arrayList, new String[] { "TABLE LINK" }); add(arrayList, new String[] { "SYSTEM TABLE" }); add(arrayList, new String[] { "VIEW" }); add(arrayList, new String[] { "EXTERNAL" }); return arrayList;case 5: add(arrayList, new String[] { str1 }); return arrayList;case 6: for (Setting setting : this.database.getAllSettings()) { String str = setting.getStringValue(); if (str == null) str = "" + setting.getIntValue();  add(arrayList, new String[] { identifier(setting.getName()), str }); }  add(arrayList, new String[] { "info.BUILD_ID", "193" }); add(arrayList, new String[] { "info.VERSION_MAJOR", "1" }); add(arrayList, new String[] { "info.VERSION_MINOR", "4" }); add(arrayList, new String[] { "info.VERSION", "" + Constants.getFullVersion() }); if (bool) { String[] arrayOfString1 = { "java.runtime.version", "java.vm.name", "java.vendor", "os.name", "os.arch", "os.version", "sun.os.patch.level", "file.separator", "path.separator", "line.separator", "user.country", "user.language", "user.variant", "file.encoding" }; for (String str : arrayOfString1) { add(arrayList, new String[] { "property." + str, Utils.getProperty(str, "") }); }  }  add(arrayList, new String[] { "EXCLUSIVE", (this.database.getExclusiveSession() == null) ? "FALSE" : "TRUE" }); add(arrayList, new String[] { "MODE", this.database.getMode().getName() }); add(arrayList, new String[] { "MULTI_THREADED", this.database.isMultiThreaded() ? "1" : "0" }); add(arrayList, new String[] { "MVCC", this.database.isMultiVersion() ? "TRUE" : "FALSE" }); add(arrayList, new String[] { "QUERY_TIMEOUT", "" + paramSession.getQueryTimeout() }); add(arrayList, new String[] { "RETENTION_TIME", "" + this.database.getRetentionTime() }); add(arrayList, new String[] { "LOG", "" + this.database.getLogMode() }); arrayList2 = New.arrayList(); hashMap = this.database.getSettings().getSettings(); for (String str : hashMap.keySet()) arrayList2.add(str);  Collections.sort(arrayList2); for (String str : arrayList2) { add(arrayList, new String[] { str, (String)hashMap.get(str) }); }  if (this.database.isPersistent()) { PageStore pageStore = this.database.getPageStore(); if (pageStore != null) { add(arrayList, new String[] { "info.FILE_WRITE_TOTAL", "" + pageStore.getWriteCountTotal() }); add(arrayList, new String[] { "info.FILE_WRITE", "" + pageStore.getWriteCount() }); add(arrayList, new String[] { "info.FILE_READ", "" + pageStore.getReadCount() }); add(arrayList, new String[] { "info.PAGE_COUNT", "" + pageStore.getPageCount() }); add(arrayList, new String[] { "info.PAGE_SIZE", "" + pageStore.getPageSize() }); add(arrayList, new String[] { "info.CACHE_MAX_SIZE", "" + pageStore.getCache().getMaxMemory() }); add(arrayList, new String[] { "info.CACHE_SIZE", "" + pageStore.getCache().getMemory() }); }  MVTableEngine.Store store = this.database.getMvStore(); if (store != null) { long l1; FileStore fileStore = store.getStore().getFileStore(); add(arrayList, new String[] { "info.FILE_WRITE", "" + fileStore.getWriteCount() }); add(arrayList, new String[] { "info.FILE_READ", "" + fileStore.getReadCount() }); try { l1 = fileStore.getFile().size(); } catch (IOException iOException) { throw DbException.convertIOException(iOException, "Can not get size"); }  char c = 'က'; long l2 = l1 / c; add(arrayList, new String[] { "info.PAGE_COUNT", "" + l2 }); add(arrayList, new String[] { "info.PAGE_SIZE", "" + c }); add(arrayList, new String[] { "info.CACHE_MAX_SIZE", "" + store.getStore().getCacheSize() }); add(arrayList, new String[] { "info.CACHE_SIZE", "" + store.getStore().getCacheSizeUsed() }); }  }  return arrayList;case 4: for (DataType dataType : DataType.getTypes()) { if (dataType.hidden || dataType.sqlType == 0) continue;  add(arrayList, new String[] { dataType.name, String.valueOf(dataType.sqlType), String.valueOf(MathUtils.convertLongToInt(dataType.maxPrecision)), dataType.prefix, dataType.suffix, dataType.params, String.valueOf(dataType.autoIncrement), String.valueOf(dataType.minScale), String.valueOf(dataType.maxScale), dataType.decimal ? "10" : null, String.valueOf(dataType.sqlTypePos), String.valueOf(dataType.caseSensitive), "1", "3" }); }  return arrayList;case 7: str2 = "/org/h2/res/help.csv"; try { byte[] arrayOfByte = Utils.getResource(str2); InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(arrayOfByte)); Csv csv = new Csv(); csv.setLineCommentCharacter('#'); ResultSet resultSet = csv.read(inputStreamReader, null); for (byte b = 0; resultSet.next(); b++) { add(arrayList, new String[] { String.valueOf(b), resultSet.getString(1).trim(), resultSet.getString(2).trim(), resultSet.getString(3).trim(), resultSet.getString(4).trim() }); }  } catch (Exception exception) { throw DbException.convert(exception); }  return arrayList;case 8: for (SchemaObject schemaObject : this.database.getAllSchemaObjects(3)) { Sequence sequence = (Sequence)schemaObject; add(arrayList, new String[] { str1, identifier(sequence.getSchema().getName()), identifier(sequence.getName()), String.valueOf(sequence.getCurrentValue()), String.valueOf(sequence.getIncrement()), sequence.getBelongsToTable() ? "TRUE" : "FALSE", replaceNullWithEmpty(sequence.getComment()), String.valueOf(sequence.getCacheSize()), String.valueOf(sequence.getMinValue()), String.valueOf(sequence.getMaxValue()), sequence.getCycle() ? "TRUE" : "FALSE", "" + sequence.getId() }); }  return arrayList;case 9: for (User user : this.database.getAllUsers()) { if (bool || paramSession.getUser() == user) add(arrayList, new String[] { identifier(user.getName()), String.valueOf(user.isAdmin()), replaceNullWithEmpty(user.getComment()), "" + user.getId() });  }  return arrayList;case 10: for (Role role : this.database.getAllRoles()) { if (bool || paramSession.getUser().isRoleGranted(role)) add(arrayList, new String[] { identifier(role.getName()), replaceNullWithEmpty(role.getComment()), "" + role.getId() });  }  return arrayList;case 11: if (bool) for (Right right : this.database.getAllRights()) { Role role = right.getGrantedRole(); DbObject dbObject = right.getGrantee(); String str = (dbObject.getType() == 2) ? "USER" : "ROLE"; if (role == null) { DbObject dbObject1 = right.getGrantedObject(); Schema schema = null; Table table = null; if (dbObject1 != null) if (dbObject1 instanceof Schema) { schema = (Schema)dbObject1; } else if (dbObject1 instanceof Table) { table = (Table)dbObject1; schema = table.getSchema(); }   String str4 = (table != null) ? identifier(table.getName()) : ""; String str5 = (schema != null) ? identifier(schema.getName()) : ""; if (!checkIndex(paramSession, str4, value1, value2)) continue;  add(arrayList, new String[] { identifier(dbObject.getName()), str, "", right.getRights(), str5, str4, "" + right.getId() }); continue; }  add(arrayList, new String[] { identifier(dbObject.getName()), str, identifier(role.getName()), "", "", "", "" + right.getId() }); }   return arrayList;case 12: for (SchemaObject schemaObject : this.database.getAllSchemaObjects(9)) { FunctionAlias.JavaMethod[] arrayOfJavaMethod; FunctionAlias functionAlias = (FunctionAlias)schemaObject; try { arrayOfJavaMethod = functionAlias.getJavaMethods(); } catch (DbException dbException) { arrayOfJavaMethod = new FunctionAlias.JavaMethod[0]; }  for (FunctionAlias.JavaMethod javaMethod : arrayOfJavaMethod) { boolean bool1 = (javaMethod.getDataType() == 0) ? true : true; add(arrayList, new String[] { str1, functionAlias.getSchema().getName(), identifier(functionAlias.getName()), functionAlias.getJavaClassName(), functionAlias.getJavaMethodName(), "" + DataType.convertTypeToSQLType(javaMethod.getDataType()), (DataType.getDataType(javaMethod.getDataType())).name, "" + javaMethod.getParameterCount(), "" + bool1, replaceNullWithEmpty(functionAlias.getComment()), "" + functionAlias.getId(), functionAlias.getSource() }); }  }  for (UserAggregate userAggregate : this.database.getAllAggregates()) { byte b = 2; add(arrayList, new String[] { str1, "PUBLIC", identifier(userAggregate.getName()), userAggregate.getJavaClassName(), "", "" + DataType.convertTypeToSQLType(0), (DataType.getDataType(0)).name, "1", "" + b, replaceNullWithEmpty(userAggregate.getComment()), "" + userAggregate.getId(), "" }); }  return arrayList;case 21: for (SchemaObject schemaObject : this.database.getAllSchemaObjects(9)) { FunctionAlias.JavaMethod[] arrayOfJavaMethod; FunctionAlias functionAlias = (FunctionAlias)schemaObject; try { arrayOfJavaMethod = functionAlias.getJavaMethods(); } catch (DbException dbException) { arrayOfJavaMethod = new FunctionAlias.JavaMethod[0]; }  for (FunctionAlias.JavaMethod javaMethod : arrayOfJavaMethod) { if (javaMethod.getDataType() != 0) { DataType dataType = DataType.getDataType(javaMethod.getDataType()); add(arrayList, new String[] { str1, functionAlias.getSchema().getName(), identifier(functionAlias.getName()), functionAlias.getJavaClassName(), functionAlias.getJavaMethodName(), "" + javaMethod.getParameterCount(), "0", "P0", "" + DataType.convertTypeToSQLType(javaMethod.getDataType()), dataType.name, "" + MathUtils.convertLongToInt(dataType.defaultPrecision), "" + dataType.defaultScale, "10", "2", "5", "", null }); }  Class[] arrayOfClass = javaMethod.getColumnClasses(); for (byte b = 0; b < arrayOfClass.length; b++) { if (!javaMethod.hasConnectionParam() || b != 0) { Class clazz = arrayOfClass[b]; int i = DataType.getTypeFromClass(clazz); DataType dataType = DataType.getDataType(i); boolean bool1 = clazz.isPrimitive() ? false : true; add(arrayList, new String[] { str1, functionAlias.getSchema().getName(), identifier(functionAlias.getName()), functionAlias.getJavaClassName(), functionAlias.getJavaMethodName(), "" + javaMethod.getParameterCount(), "" + (b + (javaMethod.hasConnectionParam() ? 0 : 1)), "P" + (b + 1), "" + DataType.convertTypeToSQLType(dataType.type), dataType.name, "" + MathUtils.convertLongToInt(dataType.defaultPrecision), "" + dataType.defaultScale, "10", "" + bool1, "1", "", null }); }  }  }  }  return arrayList;case 13: str2 = this.database.getCompareMode().getName(); for (Schema schema : this.database.getAllSchemas()) { add(arrayList, new String[] { str1, identifier(schema.getName()), identifier(schema.getOwner().getName()), "Unicode", str2, "PUBLIC".equals(schema.getName()) ? "TRUE" : "FALSE", replaceNullWithEmpty(schema.getComment()), "" + schema.getId() }); }  return arrayList;case 14: for (Right right : this.database.getAllRights()) { DbObject dbObject = right.getGrantedObject(); if (!(dbObject instanceof Table)) continue;  Table table = (Table)dbObject; if (table == null || hideTable(table, paramSession)) continue;  String str = identifier(table.getName()); if (!checkIndex(paramSession, str, value1, value2)) continue;  addPrivileges(arrayList, right.getGrantee(), str1, table, (String)null, right.getRightMask()); }  return arrayList;case 15: for (Right right : this.database.getAllRights()) { DbObject dbObject1 = right.getGrantedObject(); if (!(dbObject1 instanceof Table)) continue;  Table table = (Table)dbObject1; if (table == null || hideTable(table, paramSession)) continue;  String str = identifier(table.getName()); if (!checkIndex(paramSession, str, value1, value2)) continue;  DbObject dbObject2 = right.getGrantee(); int i = right.getRightMask(); for (Column column : table.getColumns()) addPrivileges(arrayList, dbObject2, str1, table, column.getName(), i);  }  return arrayList;case 16: for (Locale locale : Collator.getAvailableLocales()) { add(arrayList, new String[] { CompareMode.getName(locale), locale.toString() }); }  return arrayList;case 17: for (Table table : getAllTables(paramSession)) { if (!table.getTableType().equals("VIEW")) continue;  String str = identifier(table.getName()); if (!checkIndex(paramSession, str, value1, value2)) continue;  TableView tableView = (TableView)table; add(arrayList, new String[] { str1, identifier(table.getSchema().getName()), str, table.getCreateSQL(), "NONE", "NO", tableView.isInvalid() ? "INVALID" : "VALID", replaceNullWithEmpty(tableView.getComment()), "" + tableView.getId() }); }  return arrayList;case 18: arrayList1 = this.database.getInDoubtTransactions(); if (arrayList1 != null && bool) for (InDoubtTransaction inDoubtTransaction : arrayList1) { add(arrayList, new String[] { inDoubtTransaction.getTransactionName(), inDoubtTransaction.getState() }); }   return arrayList;case 19: for (SchemaObject schemaObject : this.database.getAllSchemaObjects(5)) { Constraint constraint = (Constraint)schemaObject; if (!constraint.getConstraintType().equals("REFERENTIAL")) continue;  ConstraintReferential constraintReferential = (ConstraintReferential)constraint; IndexColumn[] arrayOfIndexColumn1 = constraintReferential.getColumns(); IndexColumn[] arrayOfIndexColumn2 = constraintReferential.getRefColumns(); Table table1 = constraintReferential.getTable(); Table table2 = constraintReferential.getRefTable(); String str = identifier(table2.getName()); if (!checkIndex(paramSession, str, value1, value2)) continue;  int i = getRefAction(constraintReferential.getUpdateAction()); int j = getRefAction(constraintReferential.getDeleteAction()); for (byte b = 0; b < arrayOfIndexColumn1.length; b++) { add(arrayList, new String[] { str1, identifier(table2.getSchema().getName()), identifier(table2.getName()), identifier((arrayOfIndexColumn2[b]).column.getName()), str1, identifier(table1.getSchema().getName()), identifier(table1.getName()), identifier((arrayOfIndexColumn1[b]).column.getName()), String.valueOf(b + 1), String.valueOf(i), String.valueOf(j), identifier(constraintReferential.getName()), identifier(constraintReferential.getUniqueIndex().getName()), "7" }); }  }  return arrayList;case 20: for (SchemaObject schemaObject : this.database.getAllSchemaObjects(5)) { Constraint constraint = (Constraint)schemaObject; String str4 = constraint.getConstraintType(); String str5 = null; IndexColumn[] arrayOfIndexColumn = null; Table table = constraint.getTable(); if (hideTable(table, paramSession)) continue;  Index index = constraint.getUniqueIndex(); String str6 = null; if (index != null) str6 = index.getName();  String str7 = identifier(table.getName()); if (!checkIndex(paramSession, str7, value1, value2)) continue;  if (str4.equals("CHECK")) { str5 = ((ConstraintCheck)constraint).getExpression().getSQL(); } else if (str4.equals("UNIQUE") || str4.equals("PRIMARY KEY")) { arrayOfIndexColumn = ((ConstraintUnique)constraint).getColumns(); } else if (str4.equals("REFERENTIAL")) { arrayOfIndexColumn = ((ConstraintReferential)constraint).getColumns(); }  String str8 = null; if (arrayOfIndexColumn != null) { StatementBuilder statementBuilder = new StatementBuilder(); for (IndexColumn indexColumn : arrayOfIndexColumn) { statementBuilder.appendExceptFirst(","); statementBuilder.append(indexColumn.column.getName()); }  str8 = statementBuilder.toString(); }  add(arrayList, new String[] { str1, identifier(constraint.getSchema().getName()), identifier(constraint.getName()), str4, str1, identifier(table.getSchema().getName()), str7, str6, str5, str8, replaceNullWithEmpty(constraint.getComment()), constraint.getCreateSQL(), "" + constraint.getId() }); }  return arrayList;case 22: for (SchemaObject schemaObject : this.database.getAllSchemaObjects(11)) { Constant constant = (Constant)schemaObject; ValueExpression valueExpression = constant.getValue(); add(arrayList, new String[] { str1, identifier(constant.getSchema().getName()), identifier(constant.getName()), "" + DataType.convertTypeToSQLType(valueExpression.getType()), replaceNullWithEmpty(constant.getComment()), valueExpression.getSQL(), "" + constant.getId() }); }  return arrayList;case 23: for (UserDataType userDataType : this.database.getAllUserDataTypes()) { Column column = userDataType.getColumn(); add(arrayList, new String[] { str1, "PUBLIC", identifier(userDataType.getName()), column.getDefaultSQL(), column.isNullable() ? "YES" : "NO", "" + (column.getDataType()).sqlType, "" + column.getPrecisionAsInt(), "" + column.getScale(), (column.getDataType()).name, "" + column.getSelectivity(), "" + column.getCheckConstraintSQL(paramSession, "VALUE"), replaceNullWithEmpty(userDataType.getComment()), "" + userDataType.getCreateSQL(), "" + userDataType.getId() }); }  return arrayList;case 24: for (SchemaObject schemaObject : this.database.getAllSchemaObjects(4)) { TriggerObject triggerObject = (TriggerObject)schemaObject; Table table = triggerObject.getTable(); add(arrayList, new String[] { str1, identifier(triggerObject.getSchema().getName()), identifier(triggerObject.getName()), triggerObject.getTypeNameList(), str1, identifier(table.getSchema().getName()), identifier(table.getName()), "" + triggerObject.isBefore(), triggerObject.getTriggerClassName(), "" + triggerObject.getQueueSize(), "" + triggerObject.isNoWait(), replaceNullWithEmpty(triggerObject.getComment()), triggerObject.getCreateSQL(), "" + triggerObject.getId() }); }  return arrayList;case 25: l = System.currentTimeMillis(); for (Session session : this.database.getSessions(false)) { if (bool || session == paramSession) { Command command = session.getCurrentCommand(); long l1 = session.getCurrentCommandStart(); if (l1 == 0L) l1 = l;  add(arrayList, new String[] { "" + session.getId(), session.getUser().getName(), (new Timestamp(session.getSessionStart())).toString(), (command == null) ? null : command.toString(), (new Timestamp(l1)).toString(), "" + session.containsUncommitted() }); }  }  return arrayList;case 26: for (Session session : this.database.getSessions(false)) { if (bool || session == paramSession) for (Table table : session.getLocks()) { add(arrayList, new String[] { table.getSchema().getName(), table.getName(), "" + session.getId(), table.isLockedExclusivelyBy(session) ? "WRITE" : "READ" }); }   }  return arrayList;case 27: for (String str : paramSession.getVariableNames()) { Value value = paramSession.getVariable(str); add(arrayList, new String[] { "@" + str, "SET @" + str + " " + value.getSQL() }); }  for (Table table : paramSession.getLocalTempTables()) { add(arrayList, new String[] { "TABLE " + table.getName(), table.getCreateSQL() }); }  arrayOfString = paramSession.getSchemaSearchPath(); if (arrayOfString != null && arrayOfString.length > 0) { StatementBuilder statementBuilder = new StatementBuilder("SET SCHEMA_SEARCH_PATH "); for (String str : arrayOfString) { statementBuilder.appendExceptFirst(", "); statementBuilder.append(StringUtils.quoteIdentifier(str)); }  add(arrayList, new String[] { "SCHEMA_SEARCH_PATH", statementBuilder.toString() }); }  str3 = paramSession.getCurrentSchemaName(); if (str3 != null) add(arrayList, new String[] { "SCHEMA", "SET SCHEMA " + StringUtils.quoteIdentifier(str3) });  return arrayList;case 28: queryStatisticsData = this.database.getQueryStatisticsData(); if (queryStatisticsData != null) for (QueryStatisticsData.QueryEntry queryEntry : queryStatisticsData.getQueries()) { add(arrayList, new String[] { queryEntry.sqlStatement, "" + queryEntry.count, "" + (queryEntry.executionTimeMinNanos / 1000.0D / 1000.0D), "" + (queryEntry.executionTimeMaxNanos / 1000.0D / 1000.0D), "" + (queryEntry.executionTimeCumulativeNanos / 1000.0D / 1000.0D), "" + (queryEntry.executionTimeMeanNanos / 1000.0D / 1000.0D), "" + (queryEntry.getExecutionTimeStandardDeviation() / 1000.0D / 1000.0D), "" + queryEntry.rowCountMin, "" + queryEntry.rowCountMax, "" + queryEntry.rowCountCumulative, "" + queryEntry.rowCountMean, "" + queryEntry.getRowCountStandardDeviation() }); }   return arrayList; }  DbException.throwInternalError("type=" + this.type); return arrayList;
/*      */   }
/*      */   
/*      */   private static int getRefAction(int paramInt) {
/* 1868 */     switch (paramInt) {
/*      */       case 1:
/* 1870 */         return 0;
/*      */       case 0:
/* 1872 */         return 1;
/*      */       case 2:
/* 1874 */         return 4;
/*      */       case 3:
/* 1876 */         return 2;
/*      */     } 
/* 1878 */     throw DbException.throwInternalError("action=" + paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeRow(Session paramSession, Row paramRow) {
/* 1884 */     throw DbException.getUnsupportedException("META");
/*      */   }
/*      */ 
/*      */   
/*      */   public void addRow(Session paramSession, Row paramRow) {
/* 1889 */     throw DbException.getUnsupportedException("META");
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeChildrenAndResources(Session paramSession) {
/* 1894 */     throw DbException.getUnsupportedException("META");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close(Session paramSession) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void unlock(Session paramSession) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void addPrivileges(ArrayList<Row> paramArrayList, DbObject paramDbObject, String paramString1, Table paramTable, String paramString2, int paramInt) {
/* 1909 */     if ((paramInt & 0x1) != 0) {
/* 1910 */       addPrivilege(paramArrayList, paramDbObject, paramString1, paramTable, paramString2, "SELECT");
/*      */     }
/* 1912 */     if ((paramInt & 0x4) != 0) {
/* 1913 */       addPrivilege(paramArrayList, paramDbObject, paramString1, paramTable, paramString2, "INSERT");
/*      */     }
/* 1915 */     if ((paramInt & 0x8) != 0) {
/* 1916 */       addPrivilege(paramArrayList, paramDbObject, paramString1, paramTable, paramString2, "UPDATE");
/*      */     }
/* 1918 */     if ((paramInt & 0x2) != 0) {
/* 1919 */       addPrivilege(paramArrayList, paramDbObject, paramString1, paramTable, paramString2, "DELETE");
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void addPrivilege(ArrayList<Row> paramArrayList, DbObject paramDbObject, String paramString1, Table paramTable, String paramString2, String paramString3) {
/* 1925 */     String str = "NO";
/* 1926 */     if (paramDbObject.getType() == 2) {
/* 1927 */       User user = (User)paramDbObject;
/* 1928 */       if (user.isAdmin())
/*      */       {
/* 1930 */         str = "YES";
/*      */       }
/*      */     } 
/* 1933 */     if (paramString2 == null) {
/* 1934 */       add(paramArrayList, new String[] { null, identifier(paramDbObject.getName()), paramString1, identifier(paramTable.getSchema().getName()), identifier(paramTable.getName()), paramString3, str });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1951 */       add(paramArrayList, new String[] { null, identifier(paramDbObject.getName()), paramString1, identifier(paramTable.getSchema().getName()), identifier(paramTable.getName()), identifier(paramString2), paramString3, str });
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
/*      */   private void add(ArrayList<Row> paramArrayList, String... paramVarArgs) {
/* 1973 */     Value[] arrayOfValue = new Value[paramVarArgs.length];
/* 1974 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 1975 */       String str = paramVarArgs[b];
/* 1976 */       Value value = (Value)((str == null) ? ValueNull.INSTANCE : ValueString.get(str));
/* 1977 */       Column column = this.columns[b];
/* 1978 */       value = column.convert(value);
/* 1979 */       arrayOfValue[b] = value;
/*      */     } 
/* 1981 */     Row row = this.database.createRow(arrayOfValue, 1);
/* 1982 */     row.setKey(paramArrayList.size());
/* 1983 */     paramArrayList.add(row);
/*      */   }
/*      */ 
/*      */   
/*      */   public void checkRename() {
/* 1988 */     throw DbException.getUnsupportedException("META");
/*      */   }
/*      */ 
/*      */   
/*      */   public void checkSupportAlter() {
/* 1993 */     throw DbException.getUnsupportedException("META");
/*      */   }
/*      */ 
/*      */   
/*      */   public void truncate(Session paramSession) {
/* 1998 */     throw DbException.getUnsupportedException("META");
/*      */   }
/*      */ 
/*      */   
/*      */   public long getRowCount(Session paramSession) {
/* 2003 */     throw DbException.throwInternalError();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canGetRowCount() {
/* 2008 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canDrop() {
/* 2013 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getTableType() {
/* 2018 */     return "SYSTEM TABLE";
/*      */   }
/*      */ 
/*      */   
/*      */   public Index getScanIndex(Session paramSession) {
/* 2023 */     return (Index)new MetaIndex(this, IndexColumn.wrap(this.columns), true);
/*      */   }
/*      */ 
/*      */   
/*      */   public ArrayList<Index> getIndexes() {
/* 2028 */     ArrayList<Index> arrayList = New.arrayList();
/* 2029 */     if (this.metaIndex == null) {
/* 2030 */       return arrayList;
/*      */     }
/* 2032 */     arrayList.add(new MetaIndex(this, IndexColumn.wrap(this.columns), true));
/*      */     
/* 2034 */     arrayList.add(this.metaIndex);
/* 2035 */     return arrayList;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getMaxDataModificationId() {
/* 2040 */     switch (this.type) {
/*      */       case 6:
/*      */       case 18:
/*      */       case 25:
/*      */       case 26:
/*      */       case 27:
/* 2046 */         return Long.MAX_VALUE;
/*      */     } 
/* 2048 */     return this.database.getModificationDataId();
/*      */   }
/*      */ 
/*      */   
/*      */   public Index getUniqueIndex() {
/* 2053 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMetaTableTypeCount() {
/* 2063 */     return 29;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getRowCountApproximation() {
/* 2068 */     return 1000L;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getDiskSpaceUsed() {
/* 2073 */     return 0L;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isDeterministic() {
/* 2078 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canReference() {
/* 2083 */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\MetaTable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */