/*      */ package org.h2.command;
/*      */ 
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.nio.charset.Charset;
/*      */ import java.text.Collator;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashSet;
/*      */ import org.h2.command.ddl.AlterIndexRename;
/*      */ import org.h2.command.ddl.AlterSchemaRename;
/*      */ import org.h2.command.ddl.AlterTableAddConstraint;
/*      */ import org.h2.command.ddl.AlterTableAlterColumn;
/*      */ import org.h2.command.ddl.AlterTableDropConstraint;
/*      */ import org.h2.command.ddl.AlterTableRename;
/*      */ import org.h2.command.ddl.AlterTableRenameColumn;
/*      */ import org.h2.command.ddl.AlterTableRenameConstraint;
/*      */ import org.h2.command.ddl.AlterUser;
/*      */ import org.h2.command.ddl.AlterView;
/*      */ import org.h2.command.ddl.Analyze;
/*      */ import org.h2.command.ddl.CreateAggregate;
/*      */ import org.h2.command.ddl.CreateConstant;
/*      */ import org.h2.command.ddl.CreateFunctionAlias;
/*      */ import org.h2.command.ddl.CreateIndex;
/*      */ import org.h2.command.ddl.CreateLinkedTable;
/*      */ import org.h2.command.ddl.CreateRole;
/*      */ import org.h2.command.ddl.CreateSchema;
/*      */ import org.h2.command.ddl.CreateSequence;
/*      */ import org.h2.command.ddl.CreateTable;
/*      */ import org.h2.command.ddl.CreateTableData;
/*      */ import org.h2.command.ddl.CreateTrigger;
/*      */ import org.h2.command.ddl.CreateUser;
/*      */ import org.h2.command.ddl.CreateUserDataType;
/*      */ import org.h2.command.ddl.CreateView;
/*      */ import org.h2.command.ddl.DeallocateProcedure;
/*      */ import org.h2.command.ddl.DefineCommand;
/*      */ import org.h2.command.ddl.DropAggregate;
/*      */ import org.h2.command.ddl.DropConstant;
/*      */ import org.h2.command.ddl.DropDatabase;
/*      */ import org.h2.command.ddl.DropFunctionAlias;
/*      */ import org.h2.command.ddl.DropIndex;
/*      */ import org.h2.command.ddl.DropRole;
/*      */ import org.h2.command.ddl.DropSchema;
/*      */ import org.h2.command.ddl.DropSequence;
/*      */ import org.h2.command.ddl.DropTable;
/*      */ import org.h2.command.ddl.DropTrigger;
/*      */ import org.h2.command.ddl.DropUser;
/*      */ import org.h2.command.ddl.DropUserDataType;
/*      */ import org.h2.command.ddl.DropView;
/*      */ import org.h2.command.ddl.GrantRevoke;
/*      */ import org.h2.command.ddl.PrepareProcedure;
/*      */ import org.h2.command.ddl.SetComment;
/*      */ import org.h2.command.ddl.TruncateTable;
/*      */ import org.h2.command.dml.AlterSequence;
/*      */ import org.h2.command.dml.AlterTableSet;
/*      */ import org.h2.command.dml.BackupCommand;
/*      */ import org.h2.command.dml.Call;
/*      */ import org.h2.command.dml.Delete;
/*      */ import org.h2.command.dml.ExecuteProcedure;
/*      */ import org.h2.command.dml.Explain;
/*      */ import org.h2.command.dml.Insert;
/*      */ import org.h2.command.dml.Merge;
/*      */ import org.h2.command.dml.NoOperation;
/*      */ import org.h2.command.dml.Query;
/*      */ import org.h2.command.dml.Replace;
/*      */ import org.h2.command.dml.RunScriptCommand;
/*      */ import org.h2.command.dml.ScriptCommand;
/*      */ import org.h2.command.dml.Select;
/*      */ import org.h2.command.dml.SelectOrderBy;
/*      */ import org.h2.command.dml.SelectUnion;
/*      */ import org.h2.command.dml.Set;
/*      */ import org.h2.command.dml.SetTypes;
/*      */ import org.h2.command.dml.TransactionCommand;
/*      */ import org.h2.command.dml.Update;
/*      */ import org.h2.engine.Database;
/*      */ import org.h2.engine.FunctionAlias;
/*      */ import org.h2.engine.Procedure;
/*      */ import org.h2.engine.Session;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.engine.User;
/*      */ import org.h2.engine.UserAggregate;
/*      */ import org.h2.engine.UserDataType;
/*      */ import org.h2.expression.Aggregate;
/*      */ import org.h2.expression.Alias;
/*      */ import org.h2.expression.CompareLike;
/*      */ import org.h2.expression.Comparison;
/*      */ import org.h2.expression.ConditionAndOr;
/*      */ import org.h2.expression.ConditionExists;
/*      */ import org.h2.expression.ConditionIn;
/*      */ import org.h2.expression.ConditionInSelect;
/*      */ import org.h2.expression.ConditionNot;
/*      */ import org.h2.expression.Expression;
/*      */ import org.h2.expression.ExpressionColumn;
/*      */ import org.h2.expression.ExpressionList;
/*      */ import org.h2.expression.Function;
/*      */ import org.h2.expression.FunctionCall;
/*      */ import org.h2.expression.JavaAggregate;
/*      */ import org.h2.expression.JavaFunction;
/*      */ import org.h2.expression.Operation;
/*      */ import org.h2.expression.Parameter;
/*      */ import org.h2.expression.Rownum;
/*      */ import org.h2.expression.SequenceValue;
/*      */ import org.h2.expression.Subquery;
/*      */ import org.h2.expression.TableFunction;
/*      */ import org.h2.expression.ValueExpression;
/*      */ import org.h2.expression.Variable;
/*      */ import org.h2.expression.Wildcard;
/*      */ import org.h2.index.Index;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.schema.Schema;
/*      */ import org.h2.schema.Sequence;
/*      */ import org.h2.table.Column;
/*      */ import org.h2.table.ColumnResolver;
/*      */ import org.h2.table.FunctionTable;
/*      */ import org.h2.table.IndexColumn;
/*      */ import org.h2.table.RangeTable;
/*      */ import org.h2.table.Table;
/*      */ import org.h2.table.TableFilter;
/*      */ import org.h2.table.TableView;
/*      */ import org.h2.util.MathUtils;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.StatementBuilder;
/*      */ import org.h2.util.StringUtils;
/*      */ import org.h2.value.CompareMode;
/*      */ import org.h2.value.DataType;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueBoolean;
/*      */ import org.h2.value.ValueBytes;
/*      */ import org.h2.value.ValueDate;
/*      */ import org.h2.value.ValueDecimal;
/*      */ import org.h2.value.ValueInt;
/*      */ import org.h2.value.ValueLong;
/*      */ import org.h2.value.ValueNull;
/*      */ import org.h2.value.ValueString;
/*      */ import org.h2.value.ValueTime;
/*      */ import org.h2.value.ValueTimestamp;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Parser
/*      */ {
/*      */   private static final int CHAR_END = 1;
/*      */   private static final int CHAR_VALUE = 2;
/*      */   private static final int CHAR_QUOTED = 3;
/*      */   private static final int CHAR_NAME = 4;
/*      */   private static final int CHAR_SPECIAL_1 = 5;
/*      */   private static final int CHAR_SPECIAL_2 = 6;
/*      */   private static final int CHAR_STRING = 7;
/*      */   private static final int CHAR_DOT = 8;
/*      */   private static final int CHAR_DOLLAR_QUOTED_STRING = 9;
/*      */   private static final int KEYWORD = 1;
/*      */   private static final int IDENTIFIER = 2;
/*      */   private static final int PARAMETER = 3;
/*      */   private static final int END = 4;
/*      */   private static final int VALUE = 5;
/*      */   private static final int EQUAL = 6;
/*      */   private static final int BIGGER_EQUAL = 7;
/*      */   private static final int BIGGER = 8;
/*      */   private static final int SMALLER = 9;
/*      */   private static final int SMALLER_EQUAL = 10;
/*      */   private static final int NOT_EQUAL = 11;
/*      */   private static final int AT = 12;
/*      */   private static final int MINUS = 13;
/*      */   private static final int PLUS = 14;
/*      */   private static final int STRING_CONCAT = 15;
/*      */   private static final int OPEN = 16;
/*      */   private static final int CLOSE = 17;
/*      */   private static final int NULL = 18;
/*      */   private static final int TRUE = 19;
/*      */   private static final int FALSE = 20;
/*      */   private static final int CURRENT_TIMESTAMP = 21;
/*      */   private static final int CURRENT_DATE = 22;
/*      */   private static final int CURRENT_TIME = 23;
/*      */   private static final int ROWNUM = 24;
/*      */   private static final int SPATIAL_INTERSECTS = 25;
/*      */   
/*  183 */   private static final Comparator<TableFilter> TABLE_FILTER_COMPARATOR = new Comparator<TableFilter>()
/*      */     {
/*      */       public int compare(TableFilter param1TableFilter1, TableFilter param1TableFilter2)
/*      */       {
/*  187 */         return (param1TableFilter1 == param1TableFilter2) ? 0 : Parser.compareTableFilters(param1TableFilter1, param1TableFilter2);
/*      */       }
/*      */     };
/*      */ 
/*      */   
/*      */   private final Database database;
/*      */   
/*      */   private final Session session;
/*      */   
/*      */   private final boolean identifiersToUpper;
/*      */   
/*      */   private int[] characterTypes;
/*      */   
/*      */   private int currentTokenType;
/*      */   
/*      */   private String currentToken;
/*      */   
/*      */   private boolean currentTokenQuoted;
/*      */   
/*      */   private Value currentValue;
/*      */   
/*      */   private String originalSQL;
/*      */   private String sqlCommand;
/*      */   private char[] sqlCommandChars;
/*      */   private int lastParseIndex;
/*      */   private int parseIndex;
/*      */   private CreateView createView;
/*      */   private Prepared currentPrepared;
/*      */   private Select currentSelect;
/*      */   private ArrayList<Parameter> parameters;
/*      */   private String schemaName;
/*      */   private ArrayList<String> expectedList;
/*      */   private boolean rightsChecked;
/*      */   private boolean recompileAlways;
/*      */   private ArrayList<Parameter> indexedParameterList;
/*      */   private int orderInFrom;
/*      */   private ArrayList<Parameter> suppliedParameterList;
/*      */   
/*      */   public Parser(Session paramSession) {
/*  226 */     this.database = paramSession.getDatabase();
/*  227 */     this.identifiersToUpper = (this.database.getSettings()).databaseToUpper;
/*  228 */     this.session = paramSession;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Prepared prepare(String paramString) {
/*  238 */     Prepared prepared = parse(paramString);
/*  239 */     prepared.prepare();
/*  240 */     if (this.currentTokenType != 4) {
/*  241 */       throw getSyntaxError();
/*      */     }
/*  243 */     return prepared;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Command prepareCommand(String paramString) {
/*      */     try {
/*      */       CommandList commandList;
/*  254 */       Prepared prepared = parse(paramString);
/*  255 */       boolean bool = isToken(";");
/*  256 */       if (!bool && this.currentTokenType != 4) {
/*  257 */         throw getSyntaxError();
/*      */       }
/*  259 */       prepared.prepare();
/*  260 */       CommandContainer commandContainer = new CommandContainer(this, paramString, prepared);
/*  261 */       if (bool) {
/*  262 */         String str = this.originalSQL.substring(this.parseIndex);
/*  263 */         if (str.trim().length() != 0) {
/*  264 */           CommandList commandList1 = new CommandList(this, paramString, commandContainer, str);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  270 */           commandList = commandList1;
/*      */         } 
/*      */       } 
/*  273 */       return commandList;
/*  274 */     } catch (DbException dbException) {
/*  275 */       throw dbException.addSQL(this.originalSQL);
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
/*      */   Prepared parse(String paramString) {
/*      */     Prepared prepared;
/*      */     try {
/*  289 */       prepared = parse(paramString, false);
/*  290 */     } catch (DbException dbException) {
/*  291 */       if (dbException.getErrorCode() == 42000) {
/*      */         
/*  293 */         prepared = parse(paramString, true);
/*      */       } else {
/*  295 */         throw dbException.addSQL(paramString);
/*      */       } 
/*      */     } 
/*  298 */     prepared.setPrepareAlways(this.recompileAlways);
/*  299 */     prepared.setParameterList(this.parameters);
/*  300 */     return prepared;
/*      */   }
/*      */   
/*      */   private Prepared parse(String paramString, boolean paramBoolean) {
/*  304 */     initialize(paramString);
/*  305 */     if (paramBoolean) {
/*  306 */       this.expectedList = New.arrayList();
/*      */     } else {
/*  308 */       this.expectedList = null;
/*      */     } 
/*  310 */     this.parameters = New.arrayList();
/*  311 */     this.currentSelect = null;
/*  312 */     this.currentPrepared = null;
/*  313 */     this.createView = null;
/*  314 */     this.recompileAlways = false;
/*  315 */     this.indexedParameterList = this.suppliedParameterList;
/*  316 */     read();
/*  317 */     return parsePrepared();
/*      */   }
/*      */   
/*      */   private Prepared parsePrepared() {
/*  321 */     int i = this.lastParseIndex;
/*  322 */     NoOperation noOperation = null;
/*  323 */     String str = this.currentToken;
/*  324 */     if (str.length() == 0) {
/*  325 */       noOperation = new NoOperation(this.session);
/*      */     } else {
/*  327 */       Call call; Query query; char c = str.charAt(0);
/*  328 */       switch (c) {
/*      */         
/*      */         case '?':
/*  331 */           readTerm();
/*      */           
/*  333 */           ((Parameter)this.parameters.get(0)).setValue((Value)ValueNull.INSTANCE);
/*  334 */           read("=");
/*  335 */           read("CALL");
/*  336 */           call = parseCall();
/*      */           break;
/*      */         case '(':
/*  339 */           query = parseSelect();
/*      */           break;
/*      */         case 'A':
/*      */         case 'a':
/*  343 */           if (readIf("ALTER")) {
/*  344 */             Prepared prepared = parseAlter(); break;
/*  345 */           }  if (readIf("ANALYZE")) {
/*  346 */             Prepared prepared = parseAnalyze();
/*      */           }
/*      */           break;
/*      */         case 'B':
/*      */         case 'b':
/*  351 */           if (readIf("BACKUP")) {
/*  352 */             Prepared prepared = parseBackup(); break;
/*  353 */           }  if (readIf("BEGIN")) {
/*  354 */             TransactionCommand transactionCommand = parseBegin();
/*      */           }
/*      */           break;
/*      */         case 'C':
/*      */         case 'c':
/*  359 */           if (readIf("COMMIT")) {
/*  360 */             TransactionCommand transactionCommand = parseCommit(); break;
/*  361 */           }  if (readIf("CREATE")) {
/*  362 */             Prepared prepared = parseCreate(); break;
/*  363 */           }  if (readIf("CALL")) {
/*  364 */             Call call1 = parseCall(); break;
/*  365 */           }  if (readIf("CHECKPOINT")) {
/*  366 */             TransactionCommand transactionCommand = parseCheckpoint(); break;
/*  367 */           }  if (readIf("COMMENT")) {
/*  368 */             Prepared prepared = parseComment();
/*      */           }
/*      */           break;
/*      */         case 'D':
/*      */         case 'd':
/*  373 */           if (readIf("DELETE")) {
/*  374 */             Delete delete = parseDelete(); break;
/*  375 */           }  if (readIf("DROP")) {
/*  376 */             Prepared prepared = parseDrop(); break;
/*  377 */           }  if (readIf("DECLARE")) {
/*      */             
/*  379 */             Prepared prepared = parseCreate(); break;
/*  380 */           }  if (readIf("DEALLOCATE")) {
/*  381 */             DeallocateProcedure deallocateProcedure = parseDeallocate();
/*      */           }
/*      */           break;
/*      */         case 'E':
/*      */         case 'e':
/*  386 */           if (readIf("EXPLAIN")) {
/*  387 */             Explain explain = parseExplain(); break;
/*  388 */           }  if (readIf("EXECUTE")) {
/*  389 */             Prepared prepared = parseExecute();
/*      */           }
/*      */           break;
/*      */         case 'F':
/*      */         case 'f':
/*  394 */           if (isToken("FROM")) {
/*  395 */             query = parseSelect();
/*      */           }
/*      */           break;
/*      */         case 'G':
/*      */         case 'g':
/*  400 */           if (readIf("GRANT")) {
/*  401 */             GrantRevoke grantRevoke = parseGrantRevoke(49);
/*      */           }
/*      */           break;
/*      */         case 'H':
/*      */         case 'h':
/*  406 */           if (readIf("HELP")) {
/*  407 */             Prepared prepared = parseHelp();
/*      */           }
/*      */           break;
/*      */         case 'I':
/*      */         case 'i':
/*  412 */           if (readIf("INSERT")) {
/*  413 */             Insert insert = parseInsert();
/*      */           }
/*      */           break;
/*      */         case 'M':
/*      */         case 'm':
/*  418 */           if (readIf("MERGE")) {
/*  419 */             Merge merge = parseMerge();
/*      */           }
/*      */           break;
/*      */         case 'P':
/*      */         case 'p':
/*  424 */           if (readIf("PREPARE")) {
/*  425 */             Prepared prepared = parsePrepare();
/*      */           }
/*      */           break;
/*      */         case 'R':
/*      */         case 'r':
/*  430 */           if (readIf("ROLLBACK")) {
/*  431 */             TransactionCommand transactionCommand = parseRollback(); break;
/*  432 */           }  if (readIf("REVOKE")) {
/*  433 */             GrantRevoke grantRevoke = parseGrantRevoke(50); break;
/*  434 */           }  if (readIf("RUNSCRIPT")) {
/*  435 */             RunScriptCommand runScriptCommand = parseRunScript(); break;
/*  436 */           }  if (readIf("RELEASE")) {
/*  437 */             Prepared prepared = parseReleaseSavepoint(); break;
/*  438 */           }  if (readIf("REPLACE")) {
/*  439 */             Replace replace = parseReplace();
/*      */           }
/*      */           break;
/*      */         case 'S':
/*      */         case 's':
/*  444 */           if (isToken("SELECT")) {
/*  445 */             query = parseSelect(); break;
/*  446 */           }  if (readIf("SET")) {
/*  447 */             Prepared prepared = parseSet(); break;
/*  448 */           }  if (readIf("SAVEPOINT")) {
/*  449 */             TransactionCommand transactionCommand = parseSavepoint(); break;
/*  450 */           }  if (readIf("SCRIPT")) {
/*  451 */             ScriptCommand scriptCommand = parseScript(); break;
/*  452 */           }  if (readIf("SHUTDOWN")) {
/*  453 */             TransactionCommand transactionCommand = parseShutdown(); break;
/*  454 */           }  if (readIf("SHOW")) {
/*  455 */             Prepared prepared = parseShow();
/*      */           }
/*      */           break;
/*      */         case 'T':
/*      */         case 't':
/*  460 */           if (readIf("TRUNCATE")) {
/*  461 */             Prepared prepared = parseTruncate();
/*      */           }
/*      */           break;
/*      */         case 'U':
/*      */         case 'u':
/*  466 */           if (readIf("UPDATE")) {
/*  467 */             Update update = parseUpdate(); break;
/*  468 */           }  if (readIf("USE")) {
/*  469 */             Prepared prepared = parseUse();
/*      */           }
/*      */           break;
/*      */         case 'V':
/*      */         case 'v':
/*  474 */           if (readIf("VALUES")) {
/*  475 */             Select select = parseValues();
/*      */           }
/*      */           break;
/*      */         case 'W':
/*      */         case 'w':
/*  480 */           if (isToken("WITH")) {
/*  481 */             query = parseSelect();
/*      */           }
/*      */           break;
/*      */         case ';':
/*  485 */           noOperation = new NoOperation(this.session);
/*      */           break;
/*      */         default:
/*  488 */           throw getSyntaxError();
/*      */       } 
/*  490 */       if (this.indexedParameterList != null) {
/*  491 */         byte b = 0; int j = this.indexedParameterList.size();
/*  492 */         for (; b < j; b++) {
/*  493 */           if (this.indexedParameterList.get(b) == null) {
/*  494 */             this.indexedParameterList.set(b, new Parameter(b));
/*      */           }
/*      */         } 
/*  497 */         this.parameters = this.indexedParameterList;
/*      */       } 
/*  499 */       if (readIf("{"))
/*      */         while (true) {
/*  501 */           int j = (int)readLong() - 1;
/*  502 */           if (j < 0 || j >= this.parameters.size()) {
/*  503 */             throw getSyntaxError();
/*      */           }
/*  505 */           parameter = this.parameters.get(j);
/*  506 */           if (parameter == null) {
/*  507 */             throw getSyntaxError();
/*      */           }
/*  509 */           read(":");
/*  510 */           Expression expression = readExpression();
/*  511 */           expression = expression.optimize(this.session);
/*  512 */           parameter.setValue(expression.getValue(this.session));
/*  513 */           if (!readIf(",")) {
/*  514 */             read("}");
/*  515 */             for (Parameter parameter : this.parameters) {
/*  516 */               parameter.checkSet();
/*      */             }
/*  518 */             this.parameters.clear(); break;
/*      */           } 
/*      */         }  
/*  521 */     }  if (noOperation == null) {
/*  522 */       throw getSyntaxError();
/*      */     }
/*  524 */     setSQL((Prepared)noOperation, null, i);
/*  525 */     return (Prepared)noOperation;
/*      */   }
/*      */   
/*      */   private DbException getSyntaxError() {
/*  529 */     if (this.expectedList == null || this.expectedList.size() == 0) {
/*  530 */       return DbException.getSyntaxError(this.sqlCommand, this.parseIndex);
/*      */     }
/*  532 */     StatementBuilder statementBuilder = new StatementBuilder();
/*  533 */     for (String str : this.expectedList) {
/*  534 */       statementBuilder.appendExceptFirst(", ");
/*  535 */       statementBuilder.append(str);
/*      */     } 
/*  537 */     return DbException.getSyntaxError(this.sqlCommand, this.parseIndex, statementBuilder.toString());
/*      */   }
/*      */ 
/*      */   
/*      */   private Prepared parseBackup() {
/*  542 */     BackupCommand backupCommand = new BackupCommand(this.session);
/*  543 */     read("TO");
/*  544 */     backupCommand.setFileName(readExpression());
/*  545 */     return (Prepared)backupCommand;
/*      */   }
/*      */   
/*      */   private Prepared parseAnalyze() {
/*  549 */     Analyze analyze = new Analyze(this.session);
/*  550 */     if (readIf("SAMPLE_SIZE")) {
/*  551 */       analyze.setTop(readPositiveInt());
/*      */     }
/*  553 */     return (Prepared)analyze;
/*      */   }
/*      */ 
/*      */   
/*      */   private TransactionCommand parseBegin() {
/*  558 */     if (!readIf("WORK")) {
/*  559 */       readIf("TRANSACTION");
/*      */     }
/*  561 */     return new TransactionCommand(this.session, 83);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private TransactionCommand parseCommit() {
/*  567 */     if (readIf("TRANSACTION")) {
/*  568 */       TransactionCommand transactionCommand1 = new TransactionCommand(this.session, 78);
/*      */       
/*  570 */       transactionCommand1.setTransactionName(readUniqueIdentifier());
/*  571 */       return transactionCommand1;
/*      */     } 
/*  573 */     TransactionCommand transactionCommand = new TransactionCommand(this.session, 71);
/*      */     
/*  575 */     readIf("WORK");
/*  576 */     return transactionCommand;
/*      */   }
/*      */   
/*      */   private TransactionCommand parseShutdown() {
/*  580 */     byte b = 80;
/*  581 */     if (readIf("IMMEDIATELY")) {
/*  582 */       b = 81;
/*  583 */     } else if (readIf("COMPACT")) {
/*  584 */       b = 82;
/*  585 */     } else if (readIf("DEFRAG")) {
/*  586 */       b = 84;
/*      */     } else {
/*  588 */       readIf("SCRIPT");
/*      */     } 
/*  590 */     return new TransactionCommand(this.session, b);
/*      */   }
/*      */   
/*      */   private TransactionCommand parseRollback() {
/*      */     TransactionCommand transactionCommand;
/*  595 */     if (readIf("TRANSACTION")) {
/*  596 */       transactionCommand = new TransactionCommand(this.session, 79);
/*      */       
/*  598 */       transactionCommand.setTransactionName(readUniqueIdentifier());
/*  599 */       return transactionCommand;
/*      */     } 
/*  601 */     if (readIf("TO")) {
/*  602 */       read("SAVEPOINT");
/*  603 */       transactionCommand = new TransactionCommand(this.session, 75);
/*      */       
/*  605 */       transactionCommand.setSavepointName(readUniqueIdentifier());
/*      */     } else {
/*  607 */       readIf("WORK");
/*  608 */       transactionCommand = new TransactionCommand(this.session, 72);
/*      */     } 
/*      */     
/*  611 */     return transactionCommand;
/*      */   }
/*      */   
/*      */   private Prepared parsePrepare() {
/*  615 */     if (readIf("COMMIT")) {
/*  616 */       TransactionCommand transactionCommand = new TransactionCommand(this.session, 77);
/*      */       
/*  618 */       transactionCommand.setTransactionName(readUniqueIdentifier());
/*  619 */       return (Prepared)transactionCommand;
/*      */     } 
/*  621 */     String str = readAliasIdentifier();
/*  622 */     if (readIf("(")) {
/*  623 */       ArrayList<Column> arrayList = New.arrayList();
/*  624 */       for (byte b = 0;; b++) {
/*  625 */         Column column = parseColumnForTable("C" + b, true);
/*  626 */         arrayList.add(column);
/*  627 */         if (readIf(")")) {
/*      */           break;
/*      */         }
/*  630 */         read(",");
/*      */       } 
/*      */     } 
/*  633 */     read("AS");
/*  634 */     Prepared prepared = parsePrepared();
/*  635 */     PrepareProcedure prepareProcedure = new PrepareProcedure(this.session);
/*  636 */     prepareProcedure.setProcedureName(str);
/*  637 */     prepareProcedure.setPrepared(prepared);
/*  638 */     return (Prepared)prepareProcedure;
/*      */   }
/*      */   
/*      */   private TransactionCommand parseSavepoint() {
/*  642 */     TransactionCommand transactionCommand = new TransactionCommand(this.session, 74);
/*      */     
/*  644 */     transactionCommand.setSavepointName(readUniqueIdentifier());
/*  645 */     return transactionCommand;
/*      */   }
/*      */   
/*      */   private Prepared parseReleaseSavepoint() {
/*  649 */     NoOperation noOperation = new NoOperation(this.session);
/*  650 */     readIf("SAVEPOINT");
/*  651 */     readUniqueIdentifier();
/*  652 */     return (Prepared)noOperation;
/*      */   }
/*      */   
/*      */   private Schema findSchema(String paramString) {
/*  656 */     if (paramString == null) {
/*  657 */       return null;
/*      */     }
/*  659 */     Schema schema = this.database.findSchema(paramString);
/*  660 */     if (schema == null) {
/*  661 */       if (equalsToken("SESSION", paramString)) {
/*      */         
/*  663 */         schema = this.database.getSchema(this.session.getCurrentSchemaName());
/*  664 */       } else if ((this.database.getMode()).sysDummy1 && "SYSIBM".equals(paramString)) {
/*      */ 
/*      */         
/*  667 */         schema = this.database.getSchema(this.session.getCurrentSchemaName());
/*      */       } 
/*      */     }
/*  670 */     return schema;
/*      */   }
/*      */   
/*      */   private Schema getSchema(String paramString) {
/*  674 */     if (paramString == null) {
/*  675 */       return null;
/*      */     }
/*  677 */     Schema schema = findSchema(paramString);
/*  678 */     if (schema == null) {
/*  679 */       throw DbException.get(90079, paramString);
/*      */     }
/*  681 */     return schema;
/*      */   }
/*      */   
/*      */   private Schema getSchema() {
/*  685 */     return getSchema(this.schemaName);
/*      */   }
/*      */   
/*      */   private Column readTableColumn(TableFilter paramTableFilter) {
/*  689 */     String str1 = null;
/*  690 */     String str2 = readColumnIdentifier();
/*  691 */     if (readIf(".")) {
/*  692 */       str1 = str2;
/*  693 */       str2 = readColumnIdentifier();
/*  694 */       if (readIf(".")) {
/*  695 */         String str = str1;
/*  696 */         str1 = str2;
/*  697 */         str2 = readColumnIdentifier();
/*  698 */         if (readIf(".")) {
/*  699 */           String str3 = str;
/*  700 */           str = str1;
/*  701 */           str1 = str2;
/*  702 */           str2 = readColumnIdentifier();
/*  703 */           if (!equalsToken(str3, this.database.getShortName())) {
/*  704 */             throw DbException.get(90013, str3);
/*      */           }
/*      */         } 
/*      */         
/*  708 */         if (!equalsToken(str, paramTableFilter.getTable().getSchema().getName()))
/*      */         {
/*  710 */           throw DbException.get(90079, str);
/*      */         }
/*      */       } 
/*  713 */       if (!equalsToken(str1, paramTableFilter.getTableAlias())) {
/*  714 */         throw DbException.get(42102, str1);
/*      */       }
/*      */     } 
/*      */     
/*  718 */     if ((this.database.getSettings()).rowId && 
/*  719 */       "_ROWID_".equals(str2)) {
/*  720 */       return paramTableFilter.getRowIdColumn();
/*      */     }
/*      */     
/*  723 */     return paramTableFilter.getTable().getColumn(str2);
/*      */   }
/*      */   
/*      */   private Update parseUpdate() {
/*  727 */     Update update = new Update(this.session);
/*  728 */     this.currentPrepared = (Prepared)update;
/*  729 */     int i = this.lastParseIndex;
/*  730 */     TableFilter tableFilter = readSimpleTableFilter(0);
/*  731 */     update.setTableFilter(tableFilter);
/*  732 */     read("SET");
/*  733 */     if (readIf("("))
/*  734 */     { ArrayList<Column> arrayList = New.arrayList();
/*      */       while (true)
/*  736 */       { Column column = readTableColumn(tableFilter);
/*  737 */         arrayList.add(column);
/*  738 */         if (!readIf(",")) {
/*  739 */           read(")");
/*  740 */           read("=");
/*  741 */           Expression expression = readExpression();
/*  742 */           if (arrayList.size() == 1) {
/*      */             
/*  744 */             update.setAssignment(arrayList.get(0), expression);
/*      */           } else {
/*  746 */             byte b; int j; for (b = 0, j = arrayList.size(); b < j; b++) {
/*  747 */               Column column1 = arrayList.get(b);
/*  748 */               Function function = Function.getFunction(this.database, "ARRAY_GET");
/*  749 */               function.setParameter(0, expression);
/*  750 */               function.setParameter(1, (Expression)ValueExpression.get((Value)ValueInt.get(b + 1)));
/*  751 */               function.doneWithParameters();
/*  752 */               update.setAssignment(column1, (Expression)function);
/*      */             } 
/*      */           } 
/*      */         } else {
/*      */           continue;
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
/*  768 */         if (readIf("WHERE")) {
/*  769 */           Expression expression = readExpression();
/*  770 */           update.setCondition(expression);
/*      */         } 
/*  772 */         if (readIf("ORDER")) {
/*      */ 
/*      */           
/*  775 */           read("BY");
/*  776 */           parseSimpleOrderList();
/*      */         } 
/*  778 */         if (readIf("LIMIT")) {
/*  779 */           Expression expression = readTerm().optimize(this.session);
/*  780 */           update.setLimit(expression);
/*      */         } 
/*  782 */         setSQL((Prepared)update, "UPDATE", i);
/*  783 */         return update; }  }  do { Expression expression; Column column = readTableColumn(tableFilter); read("="); if (readIf("DEFAULT")) { ValueExpression valueExpression = ValueExpression.getDefault(); } else { expression = readExpression(); }  update.setAssignment(column, expression); } while (readIf(",")); if (readIf("WHERE")) { Expression expression = readExpression(); update.setCondition(expression); }  if (readIf("ORDER")) { read("BY"); parseSimpleOrderList(); }  if (readIf("LIMIT")) { Expression expression = readTerm().optimize(this.session); update.setLimit(expression); }  setSQL((Prepared)update, "UPDATE", i); return update;
/*      */   }
/*      */   
/*      */   private TableFilter readSimpleTableFilter(int paramInt) {
/*  787 */     Table table = readTableOrView();
/*  788 */     String str = null;
/*  789 */     if (readIf("AS")) {
/*  790 */       str = readAliasIdentifier();
/*  791 */     } else if (this.currentTokenType == 2 && 
/*  792 */       !equalsToken("SET", this.currentToken)) {
/*      */       
/*  794 */       str = readAliasIdentifier();
/*      */     } 
/*      */     
/*  797 */     return new TableFilter(this.session, table, str, this.rightsChecked, this.currentSelect, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   private Delete parseDelete() {
/*  802 */     Delete delete = new Delete(this.session);
/*  803 */     Expression expression = null;
/*  804 */     if (readIf("TOP")) {
/*  805 */       expression = readTerm().optimize(this.session);
/*      */     }
/*  807 */     this.currentPrepared = (Prepared)delete;
/*  808 */     int i = this.lastParseIndex;
/*  809 */     readIf("FROM");
/*  810 */     TableFilter tableFilter = readSimpleTableFilter(0);
/*  811 */     delete.setTableFilter(tableFilter);
/*  812 */     if (readIf("WHERE")) {
/*  813 */       Expression expression1 = readExpression();
/*  814 */       delete.setCondition(expression1);
/*      */     } 
/*  816 */     if (readIf("LIMIT") && expression == null) {
/*  817 */       expression = readTerm().optimize(this.session);
/*      */     }
/*  819 */     delete.setLimit(expression);
/*  820 */     setSQL((Prepared)delete, "DELETE", i);
/*  821 */     return delete;
/*      */   }
/*      */   
/*      */   private IndexColumn[] parseIndexColumnList() {
/*  825 */     ArrayList<IndexColumn> arrayList = New.arrayList();
/*      */     while (true) {
/*  827 */       IndexColumn indexColumn = new IndexColumn();
/*  828 */       indexColumn.columnName = readColumnIdentifier();
/*  829 */       arrayList.add(indexColumn);
/*  830 */       if (!readIf("ASC"))
/*      */       {
/*  832 */         if (readIf("DESC"))
/*  833 */           indexColumn.sortType = 1; 
/*      */       }
/*  835 */       if (readIf("NULLS")) {
/*  836 */         if (readIf("FIRST")) {
/*  837 */           indexColumn.sortType |= 0x2;
/*      */         } else {
/*  839 */           read("LAST");
/*  840 */           indexColumn.sortType |= 0x4;
/*      */         } 
/*      */       }
/*  843 */       if (!readIf(",")) {
/*  844 */         read(")");
/*  845 */         return arrayList.<IndexColumn>toArray(new IndexColumn[arrayList.size()]);
/*      */       } 
/*      */     } 
/*      */   } private String[] parseColumnList() {
/*  849 */     ArrayList<String> arrayList = New.arrayList();
/*      */     while (true) {
/*  851 */       String str = readColumnIdentifier();
/*  852 */       arrayList.add(str);
/*  853 */       if (!readIfMore())
/*  854 */         return arrayList.<String>toArray(new String[arrayList.size()]); 
/*      */     } 
/*      */   }
/*      */   private Column[] parseColumnList(Table paramTable) {
/*  858 */     ArrayList<Column> arrayList = New.arrayList();
/*  859 */     HashSet<Column> hashSet = New.hashSet();
/*  860 */     if (!readIf(")")) {
/*      */       do {
/*  862 */         Column column = parseColumn(paramTable);
/*  863 */         if (!hashSet.add(column)) {
/*  864 */           throw DbException.get(42121, column.getSQL());
/*      */         }
/*      */         
/*  867 */         arrayList.add(column);
/*  868 */       } while (readIfMore());
/*      */     }
/*  870 */     return arrayList.<Column>toArray(new Column[arrayList.size()]);
/*      */   }
/*      */   
/*      */   private Column parseColumn(Table paramTable) {
/*  874 */     String str = readColumnIdentifier();
/*  875 */     if ((this.database.getSettings()).rowId && "_ROWID_".equals(str)) {
/*  876 */       return paramTable.getRowIdColumn();
/*      */     }
/*  878 */     return paramTable.getColumn(str);
/*      */   }
/*      */   
/*      */   private boolean readIfMore() {
/*  882 */     if (readIf(",")) {
/*  883 */       return !readIf(")");
/*      */     }
/*  885 */     read(")");
/*  886 */     return false;
/*      */   }
/*      */   
/*      */   private Prepared parseHelp() {
/*  890 */     StringBuilder stringBuilder = new StringBuilder("SELECT * FROM INFORMATION_SCHEMA.HELP");
/*      */     
/*  892 */     byte b = 0;
/*  893 */     ArrayList<Value> arrayList = New.arrayList();
/*  894 */     while (this.currentTokenType != 4) {
/*  895 */       String str = this.currentToken;
/*  896 */       read();
/*  897 */       if (!b) {
/*  898 */         stringBuilder.append(" WHERE ");
/*      */       } else {
/*  900 */         stringBuilder.append(" AND ");
/*      */       } 
/*  902 */       b++;
/*  903 */       stringBuilder.append("UPPER(TOPIC) LIKE ?");
/*  904 */       arrayList.add(ValueString.get("%" + str + "%"));
/*      */     } 
/*  906 */     return prepare(this.session, stringBuilder.toString(), arrayList);
/*      */   }
/*      */   
/*      */   private Prepared parseShow() {
/*  910 */     ArrayList<Value> arrayList = New.arrayList();
/*  911 */     StringBuilder stringBuilder = new StringBuilder("SELECT ");
/*  912 */     if (readIf("CLIENT_ENCODING")) {
/*      */       
/*  914 */       stringBuilder.append("'UNICODE' AS CLIENT_ENCODING FROM DUAL");
/*  915 */     } else if (readIf("DEFAULT_TRANSACTION_ISOLATION")) {
/*      */       
/*  917 */       stringBuilder.append("'read committed' AS DEFAULT_TRANSACTION_ISOLATION FROM DUAL");
/*      */     }
/*  919 */     else if (readIf("TRANSACTION")) {
/*      */       
/*  921 */       read("ISOLATION");
/*  922 */       read("LEVEL");
/*  923 */       stringBuilder.append("'read committed' AS TRANSACTION_ISOLATION FROM DUAL");
/*      */     }
/*  925 */     else if (readIf("DATESTYLE")) {
/*      */       
/*  927 */       stringBuilder.append("'ISO' AS DATESTYLE FROM DUAL");
/*  928 */     } else if (readIf("SERVER_VERSION")) {
/*      */       
/*  930 */       stringBuilder.append("'8.1.4' AS SERVER_VERSION FROM DUAL");
/*  931 */     } else if (readIf("SERVER_ENCODING")) {
/*      */       
/*  933 */       stringBuilder.append("'UTF8' AS SERVER_ENCODING FROM DUAL");
/*  934 */     } else if (readIf("TABLES")) {
/*      */       
/*  936 */       String str = "PUBLIC";
/*  937 */       if (readIf("FROM")) {
/*  938 */         str = readUniqueIdentifier();
/*      */       }
/*  940 */       stringBuilder.append("TABLE_NAME, TABLE_SCHEMA FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA=? ORDER BY TABLE_NAME");
/*      */ 
/*      */       
/*  943 */       arrayList.add(ValueString.get(str));
/*  944 */     } else if (readIf("COLUMNS")) {
/*      */       
/*  946 */       read("FROM");
/*  947 */       String str1 = readIdentifierWithSchema();
/*  948 */       String str2 = getSchema().getName();
/*  949 */       arrayList.add(ValueString.get(str1));
/*  950 */       if (readIf("FROM")) {
/*  951 */         str2 = readUniqueIdentifier();
/*      */       }
/*  953 */       stringBuilder.append("C.COLUMN_NAME FIELD, C.TYPE_NAME || '(' || C.NUMERIC_PRECISION || ')' TYPE, C.IS_NULLABLE \"NULL\", CASE (SELECT MAX(I.INDEX_TYPE_NAME) FROM INFORMATION_SCHEMA.INDEXES I WHERE I.TABLE_SCHEMA=C.TABLE_SCHEMA AND I.TABLE_NAME=C.TABLE_NAME AND I.COLUMN_NAME=C.COLUMN_NAME)WHEN 'PRIMARY KEY' THEN 'PRI' WHEN 'UNIQUE INDEX' THEN 'UNI' ELSE '' END KEY, IFNULL(COLUMN_DEFAULT, 'NULL') DEFAULT FROM INFORMATION_SCHEMA.COLUMNS C WHERE C.TABLE_NAME=? AND C.TABLE_SCHEMA=? ORDER BY C.ORDINAL_POSITION");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  967 */       arrayList.add(ValueString.get(str2));
/*  968 */     } else if (readIf("DATABASES") || readIf("SCHEMAS")) {
/*      */       
/*  970 */       stringBuilder.append("SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA");
/*      */     } 
/*  972 */     boolean bool = this.session.getAllowLiterals();
/*      */ 
/*      */     
/*      */     try {
/*  976 */       this.session.setAllowLiterals(true);
/*  977 */       return prepare(this.session, stringBuilder.toString(), arrayList);
/*      */     } finally {
/*  979 */       this.session.setAllowLiterals(bool);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static Prepared prepare(Session paramSession, String paramString, ArrayList<Value> paramArrayList) {
/*  985 */     Prepared prepared = paramSession.prepare(paramString);
/*  986 */     ArrayList<Parameter> arrayList = prepared.getParameters();
/*  987 */     if (arrayList != null) {
/*  988 */       byte b; int i; for (b = 0, i = arrayList.size(); b < i; b++) {
/*  989 */         Parameter parameter = arrayList.get(b);
/*  990 */         parameter.setValue(paramArrayList.get(b));
/*      */       } 
/*      */     } 
/*  993 */     return prepared;
/*      */   }
/*      */   
/*      */   private boolean isSelect() {
/*  997 */     int i = this.lastParseIndex;
/*  998 */     while (readIf("("));
/*      */ 
/*      */ 
/*      */     
/* 1002 */     boolean bool = (isToken("SELECT") || isToken("FROM") || isToken("WITH")) ? true : false;
/* 1003 */     this.parseIndex = i;
/* 1004 */     read();
/* 1005 */     return bool;
/*      */   }
/*      */   
/*      */   private Merge parseMerge() {
/* 1009 */     Merge merge = new Merge(this.session);
/* 1010 */     this.currentPrepared = (Prepared)merge;
/* 1011 */     read("INTO");
/* 1012 */     Table table = readTableOrView();
/* 1013 */     merge.setTable(table);
/* 1014 */     if (readIf("(")) {
/* 1015 */       if (isSelect()) {
/* 1016 */         merge.setQuery(parseSelect());
/* 1017 */         read(")");
/* 1018 */         return merge;
/*      */       } 
/* 1020 */       Column[] arrayOfColumn = parseColumnList(table);
/* 1021 */       merge.setColumns(arrayOfColumn);
/*      */     } 
/* 1023 */     if (readIf("KEY")) {
/* 1024 */       read("(");
/* 1025 */       Column[] arrayOfColumn = parseColumnList(table);
/* 1026 */       merge.setKeys(arrayOfColumn);
/*      */     } 
/* 1028 */     if (readIf("VALUES")) {
/*      */       do {
/* 1030 */         ArrayList<Expression> arrayList = New.arrayList();
/* 1031 */         read("(");
/* 1032 */         if (!readIf(")")) {
/*      */           do {
/* 1034 */             if (readIf("DEFAULT")) {
/* 1035 */               arrayList.add(null);
/*      */             } else {
/* 1037 */               arrayList.add(readExpression());
/*      */             } 
/* 1039 */           } while (readIfMore());
/*      */         }
/* 1041 */         merge.addRow(arrayList.<Expression>toArray(new Expression[arrayList.size()]));
/* 1042 */       } while (readIf(","));
/*      */     } else {
/* 1044 */       merge.setQuery(parseSelect());
/*      */     } 
/* 1046 */     return merge;
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
/*      */   private Insert parseInsert() {
/*      */     // Byte code:
/*      */     //   0: new org/h2/command/dml/Insert
/*      */     //   3: dup
/*      */     //   4: aload_0
/*      */     //   5: getfield session : Lorg/h2/engine/Session;
/*      */     //   8: invokespecial <init> : (Lorg/h2/engine/Session;)V
/*      */     //   11: astore_1
/*      */     //   12: aload_0
/*      */     //   13: aload_1
/*      */     //   14: putfield currentPrepared : Lorg/h2/command/Prepared;
/*      */     //   17: aload_0
/*      */     //   18: ldc 'INTO'
/*      */     //   20: invokespecial read : (Ljava/lang/String;)V
/*      */     //   23: aload_0
/*      */     //   24: invokespecial readTableOrView : ()Lorg/h2/table/Table;
/*      */     //   27: astore_2
/*      */     //   28: aload_1
/*      */     //   29: aload_2
/*      */     //   30: invokevirtual setTable : (Lorg/h2/table/Table;)V
/*      */     //   33: aconst_null
/*      */     //   34: astore_3
/*      */     //   35: aload_0
/*      */     //   36: ldc '('
/*      */     //   38: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   41: ifeq -> 78
/*      */     //   44: aload_0
/*      */     //   45: invokespecial isSelect : ()Z
/*      */     //   48: ifeq -> 67
/*      */     //   51: aload_1
/*      */     //   52: aload_0
/*      */     //   53: invokespecial parseSelect : ()Lorg/h2/command/dml/Query;
/*      */     //   56: invokevirtual setQuery : (Lorg/h2/command/dml/Query;)V
/*      */     //   59: aload_0
/*      */     //   60: ldc ')'
/*      */     //   62: invokespecial read : (Ljava/lang/String;)V
/*      */     //   65: aload_1
/*      */     //   66: areturn
/*      */     //   67: aload_0
/*      */     //   68: aload_2
/*      */     //   69: invokespecial parseColumnList : (Lorg/h2/table/Table;)[Lorg/h2/table/Column;
/*      */     //   72: astore_3
/*      */     //   73: aload_1
/*      */     //   74: aload_3
/*      */     //   75: invokevirtual setColumns : ([Lorg/h2/table/Column;)V
/*      */     //   78: aload_0
/*      */     //   79: ldc 'DIRECT'
/*      */     //   81: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   84: ifeq -> 92
/*      */     //   87: aload_1
/*      */     //   88: iconst_1
/*      */     //   89: invokevirtual setInsertFromSelect : (Z)V
/*      */     //   92: aload_0
/*      */     //   93: ldc_w 'SORTED'
/*      */     //   96: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   99: ifeq -> 107
/*      */     //   102: aload_1
/*      */     //   103: iconst_1
/*      */     //   104: invokevirtual setSortedInsertMode : (Z)V
/*      */     //   107: aload_0
/*      */     //   108: ldc 'DEFAULT'
/*      */     //   110: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   113: ifeq -> 138
/*      */     //   116: aload_0
/*      */     //   117: ldc_w 'VALUES'
/*      */     //   120: invokespecial read : (Ljava/lang/String;)V
/*      */     //   123: iconst_0
/*      */     //   124: anewarray org/h2/expression/Expression
/*      */     //   127: astore #4
/*      */     //   129: aload_1
/*      */     //   130: aload #4
/*      */     //   132: invokevirtual addRow : ([Lorg/h2/expression/Expression;)V
/*      */     //   135: goto -> 382
/*      */     //   138: aload_0
/*      */     //   139: ldc_w 'VALUES'
/*      */     //   142: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   145: ifeq -> 245
/*      */     //   148: aload_0
/*      */     //   149: ldc '('
/*      */     //   151: invokespecial read : (Ljava/lang/String;)V
/*      */     //   154: invokestatic arrayList : ()Ljava/util/ArrayList;
/*      */     //   157: astore #4
/*      */     //   159: aload_0
/*      */     //   160: ldc ')'
/*      */     //   162: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   165: ifne -> 204
/*      */     //   168: aload_0
/*      */     //   169: ldc 'DEFAULT'
/*      */     //   171: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   174: ifeq -> 187
/*      */     //   177: aload #4
/*      */     //   179: aconst_null
/*      */     //   180: invokevirtual add : (Ljava/lang/Object;)Z
/*      */     //   183: pop
/*      */     //   184: goto -> 197
/*      */     //   187: aload #4
/*      */     //   189: aload_0
/*      */     //   190: invokespecial readExpression : ()Lorg/h2/expression/Expression;
/*      */     //   193: invokevirtual add : (Ljava/lang/Object;)Z
/*      */     //   196: pop
/*      */     //   197: aload_0
/*      */     //   198: invokespecial readIfMore : ()Z
/*      */     //   201: ifne -> 168
/*      */     //   204: aload_1
/*      */     //   205: aload #4
/*      */     //   207: aload #4
/*      */     //   209: invokevirtual size : ()I
/*      */     //   212: anewarray org/h2/expression/Expression
/*      */     //   215: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*      */     //   218: checkcast [Lorg/h2/expression/Expression;
/*      */     //   221: invokevirtual addRow : ([Lorg/h2/expression/Expression;)V
/*      */     //   224: aload_0
/*      */     //   225: ldc ','
/*      */     //   227: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   230: ifeq -> 382
/*      */     //   233: aload_0
/*      */     //   234: ldc '('
/*      */     //   236: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   239: ifne -> 154
/*      */     //   242: goto -> 382
/*      */     //   245: aload_0
/*      */     //   246: ldc_w 'SET'
/*      */     //   249: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   252: ifeq -> 374
/*      */     //   255: aload_3
/*      */     //   256: ifnull -> 264
/*      */     //   259: aload_0
/*      */     //   260: invokespecial getSyntaxError : ()Lorg/h2/message/DbException;
/*      */     //   263: athrow
/*      */     //   264: invokestatic arrayList : ()Ljava/util/ArrayList;
/*      */     //   267: astore #4
/*      */     //   269: invokestatic arrayList : ()Ljava/util/ArrayList;
/*      */     //   272: astore #5
/*      */     //   274: aload #4
/*      */     //   276: aload_0
/*      */     //   277: aload_2
/*      */     //   278: invokespecial parseColumn : (Lorg/h2/table/Table;)Lorg/h2/table/Column;
/*      */     //   281: invokevirtual add : (Ljava/lang/Object;)Z
/*      */     //   284: pop
/*      */     //   285: aload_0
/*      */     //   286: ldc '='
/*      */     //   288: invokespecial read : (Ljava/lang/String;)V
/*      */     //   291: aload_0
/*      */     //   292: ldc 'DEFAULT'
/*      */     //   294: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   297: ifeq -> 308
/*      */     //   300: invokestatic getDefault : ()Lorg/h2/expression/ValueExpression;
/*      */     //   303: astore #6
/*      */     //   305: goto -> 314
/*      */     //   308: aload_0
/*      */     //   309: invokespecial readExpression : ()Lorg/h2/expression/Expression;
/*      */     //   312: astore #6
/*      */     //   314: aload #5
/*      */     //   316: aload #6
/*      */     //   318: invokevirtual add : (Ljava/lang/Object;)Z
/*      */     //   321: pop
/*      */     //   322: aload_0
/*      */     //   323: ldc ','
/*      */     //   325: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   328: ifne -> 274
/*      */     //   331: aload_1
/*      */     //   332: aload #4
/*      */     //   334: aload #4
/*      */     //   336: invokevirtual size : ()I
/*      */     //   339: anewarray org/h2/table/Column
/*      */     //   342: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*      */     //   345: checkcast [Lorg/h2/table/Column;
/*      */     //   348: invokevirtual setColumns : ([Lorg/h2/table/Column;)V
/*      */     //   351: aload_1
/*      */     //   352: aload #5
/*      */     //   354: aload #5
/*      */     //   356: invokevirtual size : ()I
/*      */     //   359: anewarray org/h2/expression/Expression
/*      */     //   362: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*      */     //   365: checkcast [Lorg/h2/expression/Expression;
/*      */     //   368: invokevirtual addRow : ([Lorg/h2/expression/Expression;)V
/*      */     //   371: goto -> 382
/*      */     //   374: aload_1
/*      */     //   375: aload_0
/*      */     //   376: invokespecial parseSelect : ()Lorg/h2/command/dml/Query;
/*      */     //   379: invokevirtual setQuery : (Lorg/h2/command/dml/Query;)V
/*      */     //   382: aload_0
/*      */     //   383: getfield database : Lorg/h2/engine/Database;
/*      */     //   386: invokevirtual getMode : ()Lorg/h2/engine/Mode;
/*      */     //   389: getfield onDuplicateKeyUpdate : Z
/*      */     //   392: ifeq -> 477
/*      */     //   395: aload_0
/*      */     //   396: ldc_w 'ON'
/*      */     //   399: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   402: ifeq -> 477
/*      */     //   405: aload_0
/*      */     //   406: ldc 'DUPLICATE'
/*      */     //   408: invokespecial read : (Ljava/lang/String;)V
/*      */     //   411: aload_0
/*      */     //   412: ldc 'KEY'
/*      */     //   414: invokespecial read : (Ljava/lang/String;)V
/*      */     //   417: aload_0
/*      */     //   418: ldc_w 'UPDATE'
/*      */     //   421: invokespecial read : (Ljava/lang/String;)V
/*      */     //   424: aload_0
/*      */     //   425: aload_2
/*      */     //   426: invokespecial parseColumn : (Lorg/h2/table/Table;)Lorg/h2/table/Column;
/*      */     //   429: astore #4
/*      */     //   431: aload_0
/*      */     //   432: ldc '='
/*      */     //   434: invokespecial read : (Ljava/lang/String;)V
/*      */     //   437: aload_0
/*      */     //   438: ldc 'DEFAULT'
/*      */     //   440: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   443: ifeq -> 454
/*      */     //   446: invokestatic getDefault : ()Lorg/h2/expression/ValueExpression;
/*      */     //   449: astore #5
/*      */     //   451: goto -> 460
/*      */     //   454: aload_0
/*      */     //   455: invokespecial readExpression : ()Lorg/h2/expression/Expression;
/*      */     //   458: astore #5
/*      */     //   460: aload_1
/*      */     //   461: aload #4
/*      */     //   463: aload #5
/*      */     //   465: invokevirtual addAssignmentForDuplicate : (Lorg/h2/table/Column;Lorg/h2/expression/Expression;)V
/*      */     //   468: aload_0
/*      */     //   469: ldc ','
/*      */     //   471: invokespecial readIf : (Ljava/lang/String;)Z
/*      */     //   474: ifne -> 424
/*      */     //   477: aload_0
/*      */     //   478: getfield database : Lorg/h2/engine/Database;
/*      */     //   481: invokevirtual getMode : ()Lorg/h2/engine/Mode;
/*      */     //   484: getfield isolationLevelInSelectOrInsertStatement : Z
/*      */     //   487: ifeq -> 494
/*      */     //   490: aload_0
/*      */     //   491: invokespecial parseIsolationClause : ()V
/*      */     //   494: aload_1
/*      */     //   495: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1050	-> 0
/*      */     //   #1051	-> 12
/*      */     //   #1052	-> 17
/*      */     //   #1053	-> 23
/*      */     //   #1054	-> 28
/*      */     //   #1055	-> 33
/*      */     //   #1056	-> 35
/*      */     //   #1057	-> 44
/*      */     //   #1058	-> 51
/*      */     //   #1059	-> 59
/*      */     //   #1060	-> 65
/*      */     //   #1062	-> 67
/*      */     //   #1063	-> 73
/*      */     //   #1065	-> 78
/*      */     //   #1066	-> 87
/*      */     //   #1068	-> 92
/*      */     //   #1069	-> 102
/*      */     //   #1071	-> 107
/*      */     //   #1072	-> 116
/*      */     //   #1073	-> 123
/*      */     //   #1074	-> 129
/*      */     //   #1075	-> 135
/*      */     //   #1076	-> 148
/*      */     //   #1078	-> 154
/*      */     //   #1079	-> 159
/*      */     //   #1081	-> 168
/*      */     //   #1082	-> 177
/*      */     //   #1084	-> 187
/*      */     //   #1086	-> 197
/*      */     //   #1088	-> 204
/*      */     //   #1090	-> 224
/*      */     //   #1091	-> 245
/*      */     //   #1092	-> 255
/*      */     //   #1093	-> 259
/*      */     //   #1095	-> 264
/*      */     //   #1096	-> 269
/*      */     //   #1098	-> 274
/*      */     //   #1099	-> 285
/*      */     //   #1101	-> 291
/*      */     //   #1102	-> 300
/*      */     //   #1104	-> 308
/*      */     //   #1106	-> 314
/*      */     //   #1107	-> 322
/*      */     //   #1108	-> 331
/*      */     //   #1109	-> 351
/*      */     //   #1110	-> 371
/*      */     //   #1111	-> 374
/*      */     //   #1113	-> 382
/*      */     //   #1114	-> 395
/*      */     //   #1115	-> 405
/*      */     //   #1116	-> 411
/*      */     //   #1117	-> 417
/*      */     //   #1119	-> 424
/*      */     //   #1120	-> 431
/*      */     //   #1122	-> 437
/*      */     //   #1123	-> 446
/*      */     //   #1125	-> 454
/*      */     //   #1127	-> 460
/*      */     //   #1128	-> 468
/*      */     //   #1131	-> 477
/*      */     //   #1132	-> 490
/*      */     //   #1134	-> 494
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
/*      */   private Replace parseReplace() {
/* 1141 */     Replace replace = new Replace(this.session);
/* 1142 */     this.currentPrepared = (Prepared)replace;
/* 1143 */     read("INTO");
/* 1144 */     Table table = readTableOrView();
/* 1145 */     replace.setTable(table);
/* 1146 */     if (readIf("(")) {
/* 1147 */       if (isSelect()) {
/* 1148 */         replace.setQuery(parseSelect());
/* 1149 */         read(")");
/* 1150 */         return replace;
/*      */       } 
/* 1152 */       Column[] arrayOfColumn = parseColumnList(table);
/* 1153 */       replace.setColumns(arrayOfColumn);
/*      */     } 
/* 1155 */     if (readIf("VALUES")) {
/*      */       do {
/* 1157 */         ArrayList<Expression> arrayList = New.arrayList();
/* 1158 */         read("(");
/* 1159 */         if (!readIf(")")) {
/*      */           do {
/* 1161 */             if (readIf("DEFAULT")) {
/* 1162 */               arrayList.add(null);
/*      */             } else {
/* 1164 */               arrayList.add(readExpression());
/*      */             } 
/* 1166 */           } while (readIfMore());
/*      */         }
/* 1168 */         replace.addRow(arrayList.<Expression>toArray(new Expression[arrayList.size()]));
/* 1169 */       } while (readIf(","));
/*      */     } else {
/* 1171 */       replace.setQuery(parseSelect());
/*      */     } 
/* 1173 */     return replace;
/*      */   }
/*      */   
/*      */   private TableFilter readTableFilter(boolean paramBoolean) {
/*      */     Table table;
/* 1178 */     String str = null;
/* 1179 */     if (readIf("(")) {
/* 1180 */       if (isSelect()) {
/* 1181 */         Session session; Query query = parseSelectUnion();
/* 1182 */         read(")");
/* 1183 */         query.setParameterList(New.arrayList(this.parameters));
/* 1184 */         query.init();
/*      */         
/* 1186 */         if (this.createView != null) {
/* 1187 */           session = this.database.getSystemSession();
/*      */         } else {
/* 1189 */           session = this.session;
/*      */         } 
/* 1191 */         str = this.session.getNextSystemIdentifier(this.sqlCommand);
/* 1192 */         TableView tableView = TableView.createTempView(session, this.session.getUser(), str, query, (Query)this.currentSelect);
/*      */       } else {
/*      */         TableFilter tableFilter;
/*      */         
/* 1196 */         if ((this.database.getSettings()).nestedJoins) {
/* 1197 */           tableFilter = readTableFilter(false);
/* 1198 */           tableFilter = readJoin(tableFilter, this.currentSelect, false, false);
/* 1199 */           tableFilter = getNested(tableFilter);
/*      */         } else {
/* 1201 */           tableFilter = readTableFilter(paramBoolean);
/* 1202 */           tableFilter = readJoin(tableFilter, this.currentSelect, false, paramBoolean);
/*      */         } 
/* 1204 */         read(")");
/* 1205 */         str = readFromAlias(null);
/* 1206 */         if (str != null) {
/* 1207 */           tableFilter.setAlias(str);
/*      */         }
/* 1209 */         return tableFilter;
/*      */       } 
/* 1211 */     } else if (readIf("VALUES")) {
/* 1212 */       table = parseValuesTable(0).getTable();
/*      */     } else {
/* 1214 */       String str1 = readIdentifierWithSchema(null);
/* 1215 */       Schema schema = getSchema();
/* 1216 */       boolean bool = readIf("(");
/* 1217 */       if (bool && readIf("INDEX")) {
/*      */ 
/*      */         
/* 1220 */         readIdentifierWithSchema(null);
/* 1221 */         read(")");
/* 1222 */         bool = false;
/*      */       } 
/* 1224 */       if (bool) {
/* 1225 */         Schema schema1 = this.database.getSchema("PUBLIC");
/* 1226 */         if (equalsToken(str1, "SYSTEM_RANGE") || equalsToken(str1, "GENERATE_SERIES")) {
/*      */           
/* 1228 */           Expression expression1 = readExpression();
/* 1229 */           read(",");
/* 1230 */           Expression expression2 = readExpression();
/* 1231 */           if (readIf(",")) {
/* 1232 */             Expression expression = readExpression();
/* 1233 */             read(")");
/* 1234 */             RangeTable rangeTable = new RangeTable(schema1, expression1, expression2, expression, false);
/*      */           } else {
/*      */             
/* 1237 */             read(")");
/* 1238 */             RangeTable rangeTable = new RangeTable(schema1, expression1, expression2, false);
/*      */           } 
/*      */         } else {
/* 1241 */           Expression expression = readFunction(schema, str1);
/* 1242 */           if (!(expression instanceof FunctionCall)) {
/* 1243 */             throw getSyntaxError();
/*      */           }
/* 1245 */           FunctionCall functionCall = (FunctionCall)expression;
/* 1246 */           if (!functionCall.isDeterministic()) {
/* 1247 */             this.recompileAlways = true;
/*      */           }
/* 1249 */           FunctionTable functionTable = new FunctionTable(schema1, this.session, expression, functionCall);
/*      */         } 
/* 1251 */       } else if (equalsToken("DUAL", str1)) {
/* 1252 */         table = getDualTable(false);
/* 1253 */       } else if ((this.database.getMode()).sysDummy1 && equalsToken("SYSDUMMY1", str1)) {
/*      */         
/* 1255 */         table = getDualTable(false);
/*      */       } else {
/* 1257 */         table = readTableOrView(str1);
/*      */       } 
/*      */     } 
/* 1260 */     str = readFromAlias(str);
/* 1261 */     return new TableFilter(this.session, table, str, this.rightsChecked, this.currentSelect, this.orderInFrom++);
/*      */   }
/*      */ 
/*      */   
/*      */   private String readFromAlias(String paramString) {
/* 1266 */     if (readIf("AS")) {
/* 1267 */       paramString = readAliasIdentifier();
/* 1268 */     } else if (this.currentTokenType == 2) {
/*      */ 
/*      */       
/* 1271 */       if (!isToken("LEFT") && !isToken("RIGHT") && !isToken("FULL")) {
/* 1272 */         paramString = readAliasIdentifier();
/*      */       }
/*      */     } 
/* 1275 */     return paramString;
/*      */   }
/*      */   
/*      */   private Prepared parseTruncate() {
/* 1279 */     read("TABLE");
/* 1280 */     Table table = readTableOrView();
/* 1281 */     TruncateTable truncateTable = new TruncateTable(this.session);
/* 1282 */     truncateTable.setTable(table);
/* 1283 */     return (Prepared)truncateTable;
/*      */   }
/*      */   
/*      */   private boolean readIfExists(boolean paramBoolean) {
/* 1287 */     if (readIf("IF")) {
/* 1288 */       read("EXISTS");
/* 1289 */       paramBoolean = true;
/*      */     } 
/* 1291 */     return paramBoolean;
/*      */   }
/*      */   
/*      */   private Prepared parseComment() {
/* 1295 */     byte b = 0;
/* 1296 */     read("ON");
/* 1297 */     boolean bool = false;
/* 1298 */     if (readIf("TABLE") || readIf("VIEW")) {
/* 1299 */       b = 0;
/* 1300 */     } else if (readIf("COLUMN")) {
/* 1301 */       bool = true;
/* 1302 */       b = 0;
/* 1303 */     } else if (readIf("CONSTANT")) {
/* 1304 */       b = 11;
/* 1305 */     } else if (readIf("CONSTRAINT")) {
/* 1306 */       b = 5;
/* 1307 */     } else if (readIf("ALIAS")) {
/* 1308 */       b = 9;
/* 1309 */     } else if (readIf("INDEX")) {
/* 1310 */       b = 1;
/* 1311 */     } else if (readIf("ROLE")) {
/* 1312 */       b = 7;
/* 1313 */     } else if (readIf("SCHEMA")) {
/* 1314 */       b = 10;
/* 1315 */     } else if (readIf("SEQUENCE")) {
/* 1316 */       b = 3;
/* 1317 */     } else if (readIf("TRIGGER")) {
/* 1318 */       b = 4;
/* 1319 */     } else if (readIf("USER")) {
/* 1320 */       b = 2;
/* 1321 */     } else if (readIf("DOMAIN")) {
/* 1322 */       b = 12;
/*      */     } else {
/* 1324 */       throw getSyntaxError();
/*      */     } 
/* 1326 */     SetComment setComment = new SetComment(this.session);
/*      */     
/* 1328 */     if (bool)
/*      */     
/*      */     { 
/*      */       
/* 1332 */       ArrayList<String> arrayList = New.arrayList();
/*      */       while (true)
/* 1334 */       { arrayList.add(readUniqueIdentifier());
/* 1335 */         if (!readIf("."))
/* 1336 */         { this.schemaName = this.session.getCurrentSchemaName();
/* 1337 */           if (arrayList.size() == 4) {
/* 1338 */             if (!equalsToken(this.database.getShortName(), arrayList.get(0))) {
/* 1339 */               throw DbException.getSyntaxError(this.sqlCommand, this.parseIndex, "database name");
/*      */             }
/*      */             
/* 1342 */             arrayList.remove(0);
/*      */           } 
/* 1344 */           if (arrayList.size() == 3) {
/* 1345 */             this.schemaName = arrayList.get(0);
/* 1346 */             arrayList.remove(0);
/*      */           } 
/* 1348 */           if (arrayList.size() != 2) {
/* 1349 */             throw DbException.getSyntaxError(this.sqlCommand, this.parseIndex, "table.column");
/*      */           }
/*      */           
/* 1352 */           String str1 = arrayList.get(0);
/* 1353 */           setComment.setColumn(true);
/* 1354 */           setComment.setColumnName(arrayList.get(1));
/*      */ 
/*      */ 
/*      */           
/* 1358 */           setComment.setSchemaName(this.schemaName);
/* 1359 */           setComment.setObjectName(str1);
/* 1360 */           setComment.setObjectType(b);
/* 1361 */           read("IS");
/* 1362 */           setComment.setCommentExpression(readExpression());
/* 1363 */           return (Prepared)setComment; }  }  }  String str = readIdentifierWithSchema(); setComment.setSchemaName(this.schemaName); setComment.setObjectName(str); setComment.setObjectType(b); read("IS"); setComment.setCommentExpression(readExpression()); return (Prepared)setComment;
/*      */   }
/*      */   
/*      */   private Prepared parseDrop() {
/* 1367 */     if (readIf("TABLE")) {
/* 1368 */       boolean bool = readIfExists(false);
/* 1369 */       String str = readIdentifierWithSchema();
/* 1370 */       DropTable dropTable = new DropTable(this.session, getSchema());
/* 1371 */       dropTable.setTableName(str);
/* 1372 */       while (readIf(",")) {
/* 1373 */         str = readIdentifierWithSchema();
/* 1374 */         DropTable dropTable1 = new DropTable(this.session, getSchema());
/* 1375 */         dropTable1.setTableName(str);
/* 1376 */         dropTable.addNextDropTable(dropTable1);
/*      */       } 
/* 1378 */       bool = readIfExists(bool);
/* 1379 */       dropTable.setIfExists(bool);
/* 1380 */       if (readIf("CASCADE")) {
/* 1381 */         dropTable.setDropAction(1);
/* 1382 */         readIf("CONSTRAINTS");
/* 1383 */       } else if (readIf("RESTRICT")) {
/* 1384 */         dropTable.setDropAction(0);
/* 1385 */       } else if (readIf("IGNORE")) {
/* 1386 */         dropTable.setDropAction(2);
/*      */       } 
/* 1388 */       return (Prepared)dropTable;
/* 1389 */     }  if (readIf("INDEX")) {
/* 1390 */       boolean bool = readIfExists(false);
/* 1391 */       String str = readIdentifierWithSchema();
/* 1392 */       DropIndex dropIndex = new DropIndex(this.session, getSchema());
/* 1393 */       dropIndex.setIndexName(str);
/* 1394 */       bool = readIfExists(bool);
/* 1395 */       dropIndex.setIfExists(bool);
/* 1396 */       return (Prepared)dropIndex;
/* 1397 */     }  if (readIf("USER")) {
/* 1398 */       boolean bool = readIfExists(false);
/* 1399 */       DropUser dropUser = new DropUser(this.session);
/* 1400 */       dropUser.setUserName(readUniqueIdentifier());
/* 1401 */       bool = readIfExists(bool);
/* 1402 */       readIf("CASCADE");
/* 1403 */       dropUser.setIfExists(bool);
/* 1404 */       return (Prepared)dropUser;
/* 1405 */     }  if (readIf("SEQUENCE")) {
/* 1406 */       boolean bool = readIfExists(false);
/* 1407 */       String str = readIdentifierWithSchema();
/* 1408 */       DropSequence dropSequence = new DropSequence(this.session, getSchema());
/* 1409 */       dropSequence.setSequenceName(str);
/* 1410 */       bool = readIfExists(bool);
/* 1411 */       dropSequence.setIfExists(bool);
/* 1412 */       return (Prepared)dropSequence;
/* 1413 */     }  if (readIf("CONSTANT")) {
/* 1414 */       boolean bool = readIfExists(false);
/* 1415 */       String str = readIdentifierWithSchema();
/* 1416 */       DropConstant dropConstant = new DropConstant(this.session, getSchema());
/* 1417 */       dropConstant.setConstantName(str);
/* 1418 */       bool = readIfExists(bool);
/* 1419 */       dropConstant.setIfExists(bool);
/* 1420 */       return (Prepared)dropConstant;
/* 1421 */     }  if (readIf("TRIGGER")) {
/* 1422 */       boolean bool = readIfExists(false);
/* 1423 */       String str = readIdentifierWithSchema();
/* 1424 */       DropTrigger dropTrigger = new DropTrigger(this.session, getSchema());
/* 1425 */       dropTrigger.setTriggerName(str);
/* 1426 */       bool = readIfExists(bool);
/* 1427 */       dropTrigger.setIfExists(bool);
/* 1428 */       return (Prepared)dropTrigger;
/* 1429 */     }  if (readIf("VIEW")) {
/* 1430 */       boolean bool = readIfExists(false);
/* 1431 */       String str = readIdentifierWithSchema();
/* 1432 */       DropView dropView = new DropView(this.session, getSchema());
/* 1433 */       dropView.setViewName(str);
/* 1434 */       bool = readIfExists(bool);
/* 1435 */       dropView.setIfExists(bool);
/* 1436 */       Integer integer = parseCascadeOrRestrict();
/* 1437 */       if (integer != null) {
/* 1438 */         dropView.setDropAction(integer.intValue());
/*      */       }
/* 1440 */       return (Prepared)dropView;
/* 1441 */     }  if (readIf("ROLE")) {
/* 1442 */       boolean bool = readIfExists(false);
/* 1443 */       DropRole dropRole = new DropRole(this.session);
/* 1444 */       dropRole.setRoleName(readUniqueIdentifier());
/* 1445 */       bool = readIfExists(bool);
/* 1446 */       dropRole.setIfExists(bool);
/* 1447 */       return (Prepared)dropRole;
/* 1448 */     }  if (readIf("ALIAS")) {
/* 1449 */       boolean bool = readIfExists(false);
/* 1450 */       String str = readIdentifierWithSchema();
/* 1451 */       DropFunctionAlias dropFunctionAlias = new DropFunctionAlias(this.session, getSchema());
/*      */       
/* 1453 */       dropFunctionAlias.setAliasName(str);
/* 1454 */       bool = readIfExists(bool);
/* 1455 */       dropFunctionAlias.setIfExists(bool);
/* 1456 */       return (Prepared)dropFunctionAlias;
/* 1457 */     }  if (readIf("SCHEMA")) {
/* 1458 */       boolean bool = readIfExists(false);
/* 1459 */       DropSchema dropSchema = new DropSchema(this.session);
/* 1460 */       dropSchema.setSchemaName(readUniqueIdentifier());
/* 1461 */       bool = readIfExists(bool);
/* 1462 */       dropSchema.setIfExists(bool);
/* 1463 */       return (Prepared)dropSchema;
/* 1464 */     }  if (readIf("ALL")) {
/* 1465 */       read("OBJECTS");
/* 1466 */       DropDatabase dropDatabase = new DropDatabase(this.session);
/* 1467 */       dropDatabase.setDropAllObjects(true);
/* 1468 */       if (readIf("DELETE")) {
/* 1469 */         read("FILES");
/* 1470 */         dropDatabase.setDeleteFiles(true);
/*      */       } 
/* 1472 */       return (Prepared)dropDatabase;
/* 1473 */     }  if (readIf("DOMAIN"))
/* 1474 */       return (Prepared)parseDropUserDataType(); 
/* 1475 */     if (readIf("TYPE"))
/* 1476 */       return (Prepared)parseDropUserDataType(); 
/* 1477 */     if (readIf("DATATYPE"))
/* 1478 */       return (Prepared)parseDropUserDataType(); 
/* 1479 */     if (readIf("AGGREGATE")) {
/* 1480 */       return (Prepared)parseDropAggregate();
/*      */     }
/* 1482 */     throw getSyntaxError();
/*      */   }
/*      */   
/*      */   private DropUserDataType parseDropUserDataType() {
/* 1486 */     boolean bool = readIfExists(false);
/* 1487 */     DropUserDataType dropUserDataType = new DropUserDataType(this.session);
/* 1488 */     dropUserDataType.setTypeName(readUniqueIdentifier());
/* 1489 */     bool = readIfExists(bool);
/* 1490 */     dropUserDataType.setIfExists(bool);
/* 1491 */     return dropUserDataType;
/*      */   }
/*      */   
/*      */   private DropAggregate parseDropAggregate() {
/* 1495 */     boolean bool = readIfExists(false);
/* 1496 */     DropAggregate dropAggregate = new DropAggregate(this.session);
/* 1497 */     dropAggregate.setName(readUniqueIdentifier());
/* 1498 */     bool = readIfExists(bool);
/* 1499 */     dropAggregate.setIfExists(bool);
/* 1500 */     return dropAggregate;
/*      */   }
/*      */ 
/*      */   
/*      */   private TableFilter readJoin(TableFilter paramTableFilter, Select paramSelect, boolean paramBoolean1, boolean paramBoolean2) {
/* 1505 */     boolean bool = false;
/* 1506 */     TableFilter tableFilter = paramTableFilter;
/* 1507 */     boolean bool1 = (this.database.getSettings()).nestedJoins;
/*      */     while (true) {
/* 1509 */       while (readIf("RIGHT")) {
/* 1510 */         readIf("OUTER");
/* 1511 */         read("JOIN");
/* 1512 */         bool = true;
/*      */         
/* 1514 */         TableFilter tableFilter1 = readTableFilter(paramBoolean2);
/* 1515 */         tableFilter1 = readJoin(tableFilter1, paramSelect, paramBoolean1, true);
/* 1516 */         Expression expression = null;
/* 1517 */         if (readIf("ON")) {
/* 1518 */           expression = readExpression();
/*      */         }
/* 1520 */         if (bool1) {
/* 1521 */           paramTableFilter = getNested(paramTableFilter);
/* 1522 */           tableFilter1.addJoin(paramTableFilter, true, false, expression);
/*      */         } else {
/* 1524 */           tableFilter1.addJoin(paramTableFilter, true, false, expression);
/*      */         } 
/* 1526 */         paramTableFilter = tableFilter1;
/* 1527 */         tableFilter = tableFilter1;
/* 1528 */       }  if (readIf("LEFT")) {
/* 1529 */         readIf("OUTER");
/* 1530 */         read("JOIN");
/* 1531 */         bool = true;
/* 1532 */         TableFilter tableFilter1 = readTableFilter(true);
/* 1533 */         if (bool1) {
/* 1534 */           tableFilter1 = readJoin(tableFilter1, paramSelect, true, true);
/*      */         } else {
/* 1536 */           paramTableFilter = readJoin(paramTableFilter, paramSelect, false, true);
/*      */         } 
/* 1538 */         Expression expression = null;
/* 1539 */         if (readIf("ON")) {
/* 1540 */           expression = readExpression();
/*      */         }
/* 1542 */         paramTableFilter.addJoin(tableFilter1, true, false, expression);
/* 1543 */         tableFilter = tableFilter1; continue;
/* 1544 */       }  if (readIf("FULL"))
/* 1545 */         throw getSyntaxError(); 
/* 1546 */       if (readIf("INNER")) {
/* 1547 */         read("JOIN");
/* 1548 */         bool = true;
/* 1549 */         TableFilter tableFilter1 = readTableFilter(paramBoolean2);
/* 1550 */         paramTableFilter = readJoin(paramTableFilter, paramSelect, false, false);
/* 1551 */         Expression expression = null;
/* 1552 */         if (readIf("ON")) {
/* 1553 */           expression = readExpression();
/*      */         }
/* 1555 */         if (bool1) {
/* 1556 */           paramTableFilter.addJoin(tableFilter1, false, false, expression);
/*      */         } else {
/* 1558 */           paramTableFilter.addJoin(tableFilter1, paramBoolean2, false, expression);
/*      */         } 
/* 1560 */         tableFilter = tableFilter1; continue;
/* 1561 */       }  if (readIf("JOIN")) {
/* 1562 */         bool = true;
/* 1563 */         TableFilter tableFilter1 = readTableFilter(paramBoolean2);
/* 1564 */         paramTableFilter = readJoin(paramTableFilter, paramSelect, false, false);
/* 1565 */         Expression expression = null;
/* 1566 */         if (readIf("ON")) {
/* 1567 */           expression = readExpression();
/*      */         }
/* 1569 */         if (bool1) {
/* 1570 */           paramTableFilter.addJoin(tableFilter1, false, false, expression);
/*      */         } else {
/* 1572 */           paramTableFilter.addJoin(tableFilter1, paramBoolean2, false, expression);
/*      */         } 
/* 1574 */         tableFilter = tableFilter1; continue;
/* 1575 */       }  if (readIf("CROSS")) {
/* 1576 */         read("JOIN");
/* 1577 */         bool = true;
/* 1578 */         TableFilter tableFilter1 = readTableFilter(paramBoolean2);
/* 1579 */         if (bool1) {
/* 1580 */           paramTableFilter.addJoin(tableFilter1, false, false, null);
/*      */         } else {
/* 1582 */           paramTableFilter.addJoin(tableFilter1, paramBoolean2, false, null);
/*      */         } 
/* 1584 */         tableFilter = tableFilter1; continue;
/* 1585 */       }  if (readIf("NATURAL")) {
/* 1586 */         ConditionAndOr conditionAndOr; read("JOIN");
/* 1587 */         bool = true;
/* 1588 */         TableFilter tableFilter1 = readTableFilter(paramBoolean2);
/* 1589 */         Column[] arrayOfColumn1 = tableFilter.getTable().getColumns();
/* 1590 */         Column[] arrayOfColumn2 = tableFilter1.getTable().getColumns();
/* 1591 */         String str1 = tableFilter.getTable().getSchema().getName();
/* 1592 */         String str2 = tableFilter1.getTable().getSchema().getName();
/* 1593 */         Comparison comparison = null;
/* 1594 */         for (Column column : arrayOfColumn1) {
/* 1595 */           String str = column.getName();
/* 1596 */           for (Column column1 : arrayOfColumn2) {
/* 1597 */             String str3 = column1.getName();
/* 1598 */             if (equalsToken(str, str3)) {
/* 1599 */               tableFilter1.addNaturalJoinColumn(column1);
/* 1600 */               ExpressionColumn expressionColumn1 = new ExpressionColumn(this.database, str1, tableFilter.getTableAlias(), str);
/*      */ 
/*      */               
/* 1603 */               ExpressionColumn expressionColumn2 = new ExpressionColumn(this.database, str2, tableFilter1.getTableAlias(), str3);
/*      */ 
/*      */               
/* 1606 */               Comparison comparison1 = new Comparison(this.session, 0, (Expression)expressionColumn1, (Expression)expressionColumn2);
/*      */               
/* 1608 */               if (comparison == null) {
/* 1609 */                 comparison = comparison1;
/*      */               } else {
/* 1611 */                 conditionAndOr = new ConditionAndOr(0, (Expression)comparison, (Expression)comparison1);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/* 1617 */         if (bool1) {
/* 1618 */           paramTableFilter.addJoin(tableFilter1, false, paramBoolean1, (Expression)conditionAndOr);
/*      */         } else {
/* 1620 */           paramTableFilter.addJoin(tableFilter1, paramBoolean2, false, (Expression)conditionAndOr);
/*      */         } 
/* 1622 */         tableFilter = tableFilter1;
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/* 1627 */     if (paramBoolean1 && bool) {
/* 1628 */       paramTableFilter = getNested(paramTableFilter);
/*      */     }
/* 1630 */     return paramTableFilter;
/*      */   }
/*      */   
/*      */   private TableFilter getNested(TableFilter paramTableFilter) {
/* 1634 */     String str = "SYSTEM_JOIN_" + this.parseIndex;
/* 1635 */     TableFilter tableFilter = new TableFilter(this.session, getDualTable(true), str, this.rightsChecked, this.currentSelect, paramTableFilter.getOrderInFrom());
/*      */     
/* 1637 */     tableFilter.addJoin(paramTableFilter, false, true, null);
/* 1638 */     return tableFilter;
/*      */   }
/*      */   
/*      */   private Prepared parseExecute() {
/* 1642 */     ExecuteProcedure executeProcedure = new ExecuteProcedure(this.session);
/* 1643 */     String str = readAliasIdentifier();
/* 1644 */     Procedure procedure = this.session.getProcedure(str);
/* 1645 */     if (procedure == null) {
/* 1646 */       throw DbException.get(90077, str);
/*      */     }
/*      */     
/* 1649 */     executeProcedure.setProcedure(procedure);
/* 1650 */     if (readIf("(")) {
/* 1651 */       for (byte b = 0;; b++) {
/* 1652 */         executeProcedure.setExpression(b, readExpression());
/* 1653 */         if (readIf(")")) {
/*      */           break;
/*      */         }
/* 1656 */         read(",");
/*      */       } 
/*      */     }
/* 1659 */     return (Prepared)executeProcedure;
/*      */   }
/*      */   
/*      */   private DeallocateProcedure parseDeallocate() {
/* 1663 */     readIf("PLAN");
/* 1664 */     String str = readAliasIdentifier();
/* 1665 */     DeallocateProcedure deallocateProcedure = new DeallocateProcedure(this.session);
/* 1666 */     deallocateProcedure.setProcedureName(str);
/* 1667 */     return deallocateProcedure;
/*      */   }
/*      */   
/*      */   private Explain parseExplain() {
/* 1671 */     Explain explain = new Explain(this.session);
/* 1672 */     if (readIf("ANALYZE")) {
/* 1673 */       explain.setExecuteCommand(true);
/*      */     }
/* 1675 */     else if (readIf("PLAN")) {
/* 1676 */       readIf("FOR");
/*      */     } 
/*      */     
/* 1679 */     if (isToken("SELECT") || isToken("FROM") || isToken("(") || isToken("WITH")) {
/* 1680 */       explain.setCommand((Prepared)parseSelect());
/* 1681 */     } else if (readIf("DELETE")) {
/* 1682 */       explain.setCommand((Prepared)parseDelete());
/* 1683 */     } else if (readIf("UPDATE")) {
/* 1684 */       explain.setCommand((Prepared)parseUpdate());
/* 1685 */     } else if (readIf("INSERT")) {
/* 1686 */       explain.setCommand((Prepared)parseInsert());
/* 1687 */     } else if (readIf("MERGE")) {
/* 1688 */       explain.setCommand((Prepared)parseMerge());
/*      */     } else {
/* 1690 */       throw getSyntaxError();
/*      */     } 
/* 1692 */     return explain;
/*      */   }
/*      */   
/*      */   private Query parseSelect() {
/* 1696 */     int i = this.parameters.size();
/* 1697 */     Query query = parseSelectUnion();
/* 1698 */     ArrayList arrayList = New.arrayList();
/* 1699 */     for (int j = i, k = this.parameters.size(); j < k; j++) {
/* 1700 */       arrayList.add(this.parameters.get(j));
/*      */     }
/* 1702 */     query.setParameterList(arrayList);
/* 1703 */     query.init();
/* 1704 */     return query;
/*      */   }
/*      */   
/*      */   private Query parseSelectUnion() {
/* 1708 */     int i = this.lastParseIndex;
/* 1709 */     Query query = parseSelectSub();
/* 1710 */     return parseSelectUnionExtension(query, i, false);
/*      */   }
/*      */   
/*      */   private Query parseSelectUnionExtension(Query paramQuery, int paramInt, boolean paramBoolean) {
/*      */     SelectUnion selectUnion;
/*      */     while (true) {
/* 1716 */       while (readIf("UNION")) {
/* 1717 */         SelectUnion selectUnion1 = new SelectUnion(this.session, paramQuery);
/* 1718 */         if (readIf("ALL")) {
/* 1719 */           selectUnion1.setUnionType(1);
/*      */         } else {
/* 1721 */           readIf("DISTINCT");
/* 1722 */           selectUnion1.setUnionType(0);
/*      */         } 
/* 1724 */         selectUnion1.setRight(parseSelectSub());
/* 1725 */         selectUnion = selectUnion1;
/* 1726 */       }  if (readIf("MINUS") || readIf("EXCEPT")) {
/* 1727 */         SelectUnion selectUnion1 = new SelectUnion(this.session, (Query)selectUnion);
/* 1728 */         selectUnion1.setUnionType(2);
/* 1729 */         selectUnion1.setRight(parseSelectSub());
/* 1730 */         selectUnion = selectUnion1; continue;
/* 1731 */       }  if (readIf("INTERSECT")) {
/* 1732 */         SelectUnion selectUnion1 = new SelectUnion(this.session, (Query)selectUnion);
/* 1733 */         selectUnion1.setUnionType(3);
/* 1734 */         selectUnion1.setRight(parseSelectSub());
/* 1735 */         selectUnion = selectUnion1;
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/* 1740 */     if (!paramBoolean) {
/* 1741 */       parseEndOfQuery((Query)selectUnion);
/*      */     }
/* 1743 */     setSQL((Prepared)selectUnion, null, paramInt);
/* 1744 */     return (Query)selectUnion;
/*      */   }
/*      */   
/*      */   private void parseEndOfQuery(Query paramQuery) {
/* 1748 */     if (readIf("ORDER")) {
/* 1749 */       read("BY");
/* 1750 */       Select select = this.currentSelect;
/* 1751 */       if (paramQuery instanceof Select) {
/* 1752 */         this.currentSelect = (Select)paramQuery;
/*      */       }
/* 1754 */       ArrayList<SelectOrderBy> arrayList = New.arrayList();
/*      */       while (true) {
/* 1756 */         boolean bool = true;
/* 1757 */         if (readIf("=")) {
/* 1758 */           bool = false;
/*      */         }
/* 1760 */         SelectOrderBy selectOrderBy = new SelectOrderBy();
/* 1761 */         Expression expression = readExpression();
/* 1762 */         if (bool && expression instanceof ValueExpression && expression.getType() == 4) {
/*      */           
/* 1764 */           selectOrderBy.columnIndexExpr = expression;
/* 1765 */         } else if (expression instanceof Parameter) {
/* 1766 */           this.recompileAlways = true;
/* 1767 */           selectOrderBy.columnIndexExpr = expression;
/*      */         } else {
/* 1769 */           selectOrderBy.expression = expression;
/*      */         } 
/* 1771 */         if (readIf("DESC")) {
/* 1772 */           selectOrderBy.descending = true;
/*      */         } else {
/* 1774 */           readIf("ASC");
/*      */         } 
/* 1776 */         if (readIf("NULLS")) {
/* 1777 */           if (readIf("FIRST")) {
/* 1778 */             selectOrderBy.nullsFirst = true;
/*      */           } else {
/* 1780 */             read("LAST");
/* 1781 */             selectOrderBy.nullsLast = true;
/*      */           } 
/*      */         }
/* 1784 */         arrayList.add(selectOrderBy);
/* 1785 */         if (!readIf(","))
/* 1786 */         { paramQuery.setOrder(arrayList);
/* 1787 */           this.currentSelect = select; break; } 
/*      */       } 
/* 1789 */     }  if ((this.database.getMode()).supportOffsetFetch) {
/*      */       
/* 1791 */       Select select = this.currentSelect;
/* 1792 */       this.currentSelect = null;
/*      */ 
/*      */       
/* 1795 */       if (readIf("OFFSET")) {
/* 1796 */         paramQuery.setOffset(readExpression().optimize(this.session));
/* 1797 */         if (!readIf("ROW")) {
/* 1798 */           readIf("ROWS");
/*      */         }
/*      */       } 
/* 1801 */       if (readIf("FETCH")) {
/* 1802 */         if (!readIf("FIRST")) {
/* 1803 */           read("NEXT");
/*      */         }
/* 1805 */         if (readIf("ROW")) {
/* 1806 */           paramQuery.setLimit((Expression)ValueExpression.get((Value)ValueInt.get(1)));
/*      */         } else {
/* 1808 */           Expression expression = readExpression().optimize(this.session);
/* 1809 */           paramQuery.setLimit(expression);
/* 1810 */           if (!readIf("ROW")) {
/* 1811 */             read("ROWS");
/*      */           }
/*      */         } 
/* 1814 */         read("ONLY");
/*      */       } 
/*      */       
/* 1817 */       this.currentSelect = select;
/*      */     } 
/* 1819 */     if (readIf("LIMIT")) {
/* 1820 */       Select select = this.currentSelect;
/*      */       
/* 1822 */       this.currentSelect = null;
/* 1823 */       Expression expression = readExpression().optimize(this.session);
/* 1824 */       paramQuery.setLimit(expression);
/* 1825 */       if (readIf("OFFSET")) {
/* 1826 */         Expression expression1 = readExpression().optimize(this.session);
/* 1827 */         paramQuery.setOffset(expression1);
/* 1828 */       } else if (readIf(",")) {
/*      */         
/* 1830 */         Expression expression1 = expression;
/* 1831 */         expression = readExpression().optimize(this.session);
/* 1832 */         paramQuery.setOffset(expression1);
/* 1833 */         paramQuery.setLimit(expression);
/*      */       } 
/* 1835 */       if (readIf("SAMPLE_SIZE")) {
/* 1836 */         Expression expression1 = readExpression().optimize(this.session);
/* 1837 */         paramQuery.setSampleSize(expression1);
/*      */       } 
/* 1839 */       this.currentSelect = select;
/*      */     } 
/* 1841 */     if (readIf("FOR")) {
/* 1842 */       if (readIf("UPDATE")) {
/* 1843 */         if (readIf("OF")) {
/*      */           do {
/* 1845 */             readIdentifierWithSchema();
/* 1846 */           } while (readIf(","));
/* 1847 */         } else if (readIf("NOWAIT")) {
/*      */         
/*      */         } 
/* 1850 */         paramQuery.setForUpdate(true);
/* 1851 */       } else if (readIf("READ") || readIf("FETCH")) {
/* 1852 */         read("ONLY");
/*      */       } 
/*      */     }
/* 1855 */     if ((this.database.getMode()).isolationLevelInSelectOrInsertStatement) {
/* 1856 */       parseIsolationClause();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void parseIsolationClause() {
/* 1864 */     if (readIf("WITH")) {
/* 1865 */       if (readIf("RR") || readIf("RS")) {
/*      */         
/* 1867 */         if (readIf("USE")) {
/* 1868 */           read("AND");
/* 1869 */           read("KEEP");
/* 1870 */           if (readIf("SHARE") || readIf("UPDATE") || readIf("EXCLUSIVE"));
/*      */ 
/*      */ 
/*      */           
/* 1874 */           read("LOCKS");
/*      */         } 
/* 1876 */       } else if (readIf("CS") || readIf("UR")) {
/*      */       
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private Query parseSelectSub() {
/* 1883 */     if (readIf("(")) {
/* 1884 */       Query query = parseSelectUnion();
/* 1885 */       read(")");
/* 1886 */       return query;
/*      */     } 
/* 1888 */     if (readIf("WITH")) {
/* 1889 */       return parseWith();
/*      */     }
/* 1891 */     return (Query)parseSelectSimple();
/*      */   }
/*      */ 
/*      */   
/*      */   private void parseSelectSimpleFromPart(Select paramSelect) {
/*      */     do {
/* 1897 */       TableFilter tableFilter = readTableFilter(false);
/* 1898 */       parseJoinTableFilter(tableFilter, paramSelect);
/* 1899 */     } while (readIf(","));
/*      */ 
/*      */ 
/*      */     
/* 1903 */     if (this.session.isForceJoinOrder()) {
/* 1904 */       sortTableFilters(paramSelect.getTopFilters());
/*      */     }
/*      */   }
/*      */   
/*      */   private static void sortTableFilters(ArrayList<TableFilter> paramArrayList) {
/* 1909 */     if (paramArrayList.size() < 2) {
/*      */       return;
/*      */     }
/*      */     
/* 1913 */     boolean bool = true;
/* 1914 */     TableFilter tableFilter = paramArrayList.get(0);
/* 1915 */     for (byte b = 1; b < paramArrayList.size(); b++) {
/* 1916 */       TableFilter tableFilter1 = paramArrayList.get(b);
/* 1917 */       if (compareTableFilters(tableFilter, tableFilter1) > 0) {
/* 1918 */         bool = false;
/*      */         break;
/*      */       } 
/* 1921 */       tableFilter = tableFilter1;
/*      */     } 
/*      */     
/* 1924 */     if (!bool) {
/* 1925 */       Collections.sort(paramArrayList, TABLE_FILTER_COMPARATOR);
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
/*      */   static int compareTableFilters(TableFilter paramTableFilter1, TableFilter paramTableFilter2) {
/* 1937 */     assert paramTableFilter1.getOrderInFrom() != paramTableFilter2.getOrderInFrom();
/* 1938 */     return (paramTableFilter1.getOrderInFrom() > paramTableFilter2.getOrderInFrom()) ? 1 : -1;
/*      */   }
/*      */   
/*      */   private void parseJoinTableFilter(TableFilter paramTableFilter, final Select command) {
/* 1942 */     paramTableFilter = readJoin(paramTableFilter, command, false, paramTableFilter.isJoinOuter());
/* 1943 */     command.addTableFilter(paramTableFilter, true);
/* 1944 */     boolean bool = false;
/*      */     while (true) {
/* 1946 */       TableFilter tableFilter1 = paramTableFilter.getNestedJoin();
/* 1947 */       if (tableFilter1 != null) {
/* 1948 */         tableFilter1.visit(new TableFilter.TableFilterVisitor()
/*      */             {
/*      */               public void accept(TableFilter param1TableFilter) {
/* 1951 */                 command.addTableFilter(param1TableFilter, false);
/*      */               }
/*      */             });
/*      */       }
/* 1955 */       TableFilter tableFilter2 = paramTableFilter.getJoin();
/* 1956 */       if (tableFilter2 == null) {
/*      */         break;
/*      */       }
/* 1959 */       bool |= tableFilter2.isJoinOuter();
/* 1960 */       if (bool) {
/* 1961 */         command.addTableFilter(tableFilter2, false);
/*      */       } else {
/*      */         
/* 1964 */         Expression expression = tableFilter2.getJoinCondition();
/* 1965 */         if (expression != null) {
/* 1966 */           command.addCondition(expression);
/*      */         }
/* 1968 */         tableFilter2.removeJoinCondition();
/* 1969 */         paramTableFilter.removeJoin();
/* 1970 */         command.addTableFilter(tableFilter2, true);
/*      */       } 
/* 1972 */       paramTableFilter = tableFilter2;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void parseSelectSimpleSelectPart(Select paramSelect) {
/* 1977 */     Select select = this.currentSelect;
/*      */     
/* 1979 */     this.currentSelect = null;
/* 1980 */     if (readIf("TOP")) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1985 */       Expression expression = readTerm().optimize(this.session);
/* 1986 */       paramSelect.setLimit(expression);
/* 1987 */     } else if (readIf("LIMIT")) {
/* 1988 */       Expression expression1 = readTerm().optimize(this.session);
/* 1989 */       paramSelect.setOffset(expression1);
/* 1990 */       Expression expression2 = readTerm().optimize(this.session);
/* 1991 */       paramSelect.setLimit(expression2);
/*      */     } 
/* 1993 */     this.currentSelect = select;
/* 1994 */     if (readIf("DISTINCT")) {
/* 1995 */       paramSelect.setDistinct(true);
/*      */     } else {
/* 1997 */       readIf("ALL");
/*      */     } 
/* 1999 */     ArrayList<Wildcard> arrayList = New.arrayList();
/*      */     while (true) {
/* 2001 */       if (readIf("*")) {
/* 2002 */         arrayList.add(new Wildcard(null, null));
/*      */       } else {
/* 2004 */         Alias alias; Expression expression = readExpression();
/* 2005 */         if (readIf("AS") || this.currentTokenType == 2) {
/* 2006 */           String str = readAliasIdentifier();
/* 2007 */           boolean bool = (this.database.getSettings()).aliasColumnName;
/* 2008 */           bool |= (this.database.getMode()).aliasColumnName;
/* 2009 */           alias = new Alias(expression, str, bool);
/*      */         } 
/* 2011 */         arrayList.add(alias);
/*      */       } 
/* 2013 */       if (!readIf(",")) {
/* 2014 */         paramSelect.setExpressions(arrayList);
/*      */         return;
/*      */       } 
/*      */     }  } private Select parseSelectSimple() {
/*      */     boolean bool;
/* 2019 */     if (readIf("SELECT")) {
/* 2020 */       bool = false;
/* 2021 */     } else if (readIf("FROM")) {
/* 2022 */       bool = true;
/*      */     } else {
/* 2024 */       throw getSyntaxError();
/*      */     } 
/* 2026 */     Select select1 = new Select(this.session);
/* 2027 */     int i = this.lastParseIndex;
/* 2028 */     Select select2 = this.currentSelect;
/* 2029 */     this.currentSelect = select1;
/* 2030 */     this.currentPrepared = (Prepared)select1;
/* 2031 */     if (bool) {
/* 2032 */       parseSelectSimpleFromPart(select1);
/* 2033 */       read("SELECT");
/* 2034 */       parseSelectSimpleSelectPart(select1);
/*      */     } else {
/* 2036 */       parseSelectSimpleSelectPart(select1);
/* 2037 */       if (!readIf("FROM")) {
/*      */ 
/*      */         
/* 2040 */         Table table = getDualTable(false);
/* 2041 */         TableFilter tableFilter = new TableFilter(this.session, table, null, this.rightsChecked, this.currentSelect, 0);
/*      */         
/* 2043 */         select1.addTableFilter(tableFilter, true);
/*      */       } else {
/* 2045 */         parseSelectSimpleFromPart(select1);
/*      */       } 
/*      */     } 
/* 2048 */     if (readIf("WHERE")) {
/* 2049 */       Expression expression = readExpression();
/* 2050 */       select1.addCondition(expression);
/*      */     } 
/*      */ 
/*      */     
/* 2054 */     this.currentSelect = select2;
/* 2055 */     if (readIf("GROUP")) {
/* 2056 */       read("BY");
/* 2057 */       select1.setGroupQuery();
/* 2058 */       ArrayList<Expression> arrayList = New.arrayList();
/*      */       while (true) {
/* 2060 */         Expression expression = readExpression();
/* 2061 */         arrayList.add(expression);
/* 2062 */         if (!readIf(","))
/* 2063 */         { select1.setGroupBy(arrayList); break; } 
/*      */       } 
/* 2065 */     }  this.currentSelect = select1;
/* 2066 */     if (readIf("HAVING")) {
/* 2067 */       select1.setGroupQuery();
/* 2068 */       Expression expression = readExpression();
/* 2069 */       select1.setHaving(expression);
/*      */     } 
/* 2071 */     select1.setParameterList(this.parameters);
/* 2072 */     this.currentSelect = select2;
/* 2073 */     setSQL((Prepared)select1, "SELECT", i);
/* 2074 */     return select1;
/*      */   }
/*      */   
/*      */   private Table getDualTable(boolean paramBoolean) {
/* 2078 */     Schema schema = this.database.findSchema("PUBLIC");
/* 2079 */     ValueExpression valueExpression = ValueExpression.get((Value)ValueLong.get(1L));
/* 2080 */     return (Table)new RangeTable(schema, (Expression)valueExpression, (Expression)valueExpression, paramBoolean);
/*      */   }
/*      */   
/*      */   private void setSQL(Prepared paramPrepared, String paramString, int paramInt) {
/* 2084 */     String str = this.originalSQL.substring(paramInt, this.lastParseIndex).trim();
/* 2085 */     if (paramString != null) {
/* 2086 */       str = paramString + " " + str;
/*      */     }
/* 2088 */     paramPrepared.setSQL(str);
/*      */   }
/*      */   private Expression readExpression() {
/*      */     ConditionAndOr conditionAndOr;
/* 2092 */     Expression expression = readAnd();
/* 2093 */     while (readIf("OR")) {
/* 2094 */       conditionAndOr = new ConditionAndOr(1, expression, readAnd());
/*      */     }
/* 2096 */     return (Expression)conditionAndOr;
/*      */   }
/*      */   private Expression readAnd() {
/*      */     ConditionAndOr conditionAndOr;
/* 2100 */     Expression expression = readCondition();
/* 2101 */     while (readIf("AND")) {
/* 2102 */       conditionAndOr = new ConditionAndOr(0, expression, readCondition());
/*      */     }
/* 2104 */     return (Expression)conditionAndOr;
/*      */   }
/*      */   private Expression readCondition() {
/*      */     ConditionNot conditionNot;
/* 2108 */     if (readIf("NOT")) {
/* 2109 */       return (Expression)new ConditionNot(readCondition());
/*      */     }
/* 2111 */     if (readIf("EXISTS")) {
/* 2112 */       read("(");
/* 2113 */       Query query = parseSelect();
/*      */ 
/*      */       
/* 2116 */       read(")");
/* 2117 */       return (Expression)new ConditionExists(query);
/*      */     } 
/* 2119 */     if (readIf("INTERSECTS")) {
/* 2120 */       read("(");
/* 2121 */       Expression expression1 = readConcat();
/* 2122 */       read(",");
/* 2123 */       Expression expression2 = readConcat();
/* 2124 */       read(")");
/* 2125 */       return (Expression)new Comparison(this.session, 11, expression1, expression2);
/*      */     } 
/*      */     
/* 2128 */     Expression expression = readConcat();
/*      */     while (true) {
/*      */       CompareLike compareLike;
/*      */       Comparison comparison;
/* 2132 */       int i = this.parseIndex;
/* 2133 */       boolean bool = false;
/* 2134 */       if (readIf("NOT")) {
/* 2135 */         bool = true;
/* 2136 */         if (isToken("NULL")) {
/*      */           
/* 2138 */           this.parseIndex = i;
/* 2139 */           this.currentToken = "NOT";
/*      */           break;
/*      */         } 
/*      */       } 
/* 2143 */       if (readIf("LIKE")) {
/* 2144 */         Expression expression1 = readConcat();
/* 2145 */         Expression expression2 = null;
/* 2146 */         if (readIf("ESCAPE")) {
/* 2147 */           expression2 = readConcat();
/*      */         }
/* 2149 */         this.recompileAlways = true;
/* 2150 */         compareLike = new CompareLike(this.database, expression, expression1, expression2, false);
/* 2151 */       } else if (readIf("REGEXP")) {
/* 2152 */         Expression expression1 = readConcat();
/* 2153 */         compareLike = new CompareLike(this.database, (Expression)compareLike, expression1, null, true);
/* 2154 */       } else if (readIf("IS")) {
/* 2155 */         if (readIf("NOT")) {
/* 2156 */           if (readIf("NULL")) {
/* 2157 */             comparison = new Comparison(this.session, 7, (Expression)compareLike, null);
/*      */           }
/* 2159 */           else if (readIf("DISTINCT")) {
/* 2160 */             read("FROM");
/* 2161 */             comparison = new Comparison(this.session, 16, (Expression)comparison, readConcat());
/*      */           } else {
/*      */             
/* 2164 */             comparison = new Comparison(this.session, 21, (Expression)comparison, readConcat());
/*      */           }
/*      */         
/* 2167 */         } else if (readIf("NULL")) {
/* 2168 */           comparison = new Comparison(this.session, 6, (Expression)comparison, null);
/* 2169 */         } else if (readIf("DISTINCT")) {
/* 2170 */           read("FROM");
/* 2171 */           comparison = new Comparison(this.session, 21, (Expression)comparison, readConcat());
/*      */         } else {
/*      */           
/* 2174 */           comparison = new Comparison(this.session, 16, (Expression)comparison, readConcat());
/*      */         } 
/*      */       } else {
/* 2177 */         ConditionIn conditionIn; if (readIf("IN"))
/* 2178 */         { ValueExpression valueExpression; read("(");
/* 2179 */           if (readIf(")")) {
/* 2180 */             if ((this.database.getMode()).prohibitEmptyInPredicate) {
/* 2181 */               throw getSyntaxError();
/*      */             }
/* 2183 */             valueExpression = ValueExpression.get((Value)ValueBoolean.get(false));
/*      */           } else {
/* 2185 */             ConditionInSelect conditionInSelect; if (isSelect()) {
/* 2186 */               Query query = parseSelect();
/* 2187 */               conditionInSelect = new ConditionInSelect(this.database, (Expression)valueExpression, query, false, 0);
/*      */               continue;
/*      */             } 
/* 2190 */             ArrayList<Expression> arrayList = New.arrayList();
/*      */             
/*      */             while (true)
/* 2193 */             { Expression expression1 = readExpression();
/* 2194 */               arrayList.add(expression1);
/* 2195 */               if (!readIf(","))
/* 2196 */               { if (arrayList.size() == 1 && expression1 instanceof Subquery) {
/* 2197 */                   Subquery subquery = (Subquery)expression1;
/* 2198 */                   Query query = subquery.getQuery();
/* 2199 */                   conditionInSelect = new ConditionInSelect(this.database, (Expression)conditionInSelect, query, false, 0);
/*      */                 } else {
/*      */                   
/* 2202 */                   conditionIn = new ConditionIn(this.database, (Expression)conditionInSelect, arrayList);
/*      */                 } 
/*      */                 
/* 2205 */                 read(")"); break; }  } 
/*      */           }  }
/* 2207 */         else { ConditionAndOr conditionAndOr; if (readIf("BETWEEN")) {
/* 2208 */             Expression expression1 = readConcat();
/* 2209 */             read("AND");
/* 2210 */             Expression expression2 = readConcat();
/* 2211 */             Comparison comparison1 = new Comparison(this.session, 3, expression1, (Expression)conditionIn);
/*      */             
/* 2213 */             Comparison comparison2 = new Comparison(this.session, 1, expression2, (Expression)conditionIn);
/*      */             
/* 2215 */             conditionAndOr = new ConditionAndOr(0, (Expression)comparison1, (Expression)comparison2);
/*      */           } else {
/* 2217 */             ConditionInSelect conditionInSelect; int j = getCompareType(this.currentTokenType);
/* 2218 */             if (j < 0) {
/*      */               break;
/*      */             }
/* 2221 */             read();
/* 2222 */             if (readIf("ALL")) {
/* 2223 */               read("(");
/* 2224 */               Query query = parseSelect();
/* 2225 */               conditionInSelect = new ConditionInSelect(this.database, (Expression)conditionAndOr, query, true, j);
/*      */               
/* 2227 */               read(")");
/* 2228 */             } else if (readIf("ANY") || readIf("SOME")) {
/* 2229 */               read("(");
/* 2230 */               Query query = parseSelect();
/* 2231 */               conditionInSelect = new ConditionInSelect(this.database, (Expression)conditionInSelect, query, false, j);
/*      */               
/* 2233 */               read(")");
/*      */             } else {
/* 2235 */               ValueExpression valueExpression; Expression expression1 = readConcat();
/* 2236 */               if (SysProperties.OLD_STYLE_OUTER_JOIN && readIf("(") && readIf("+") && readIf(")"))
/*      */               
/*      */               { 
/*      */                 
/* 2240 */                 if (conditionInSelect instanceof ExpressionColumn && expression1 instanceof ExpressionColumn) {
/*      */                   
/* 2242 */                   ExpressionColumn expressionColumn1 = (ExpressionColumn)conditionInSelect;
/* 2243 */                   ExpressionColumn expressionColumn2 = (ExpressionColumn)expression1;
/* 2244 */                   ArrayList arrayList = this.currentSelect.getTopFilters();
/*      */                   
/* 2246 */                   for (TableFilter tableFilter : arrayList) {
/* 2247 */                     while (tableFilter != null) {
/* 2248 */                       expressionColumn1.mapColumns((ColumnResolver)tableFilter, 0);
/* 2249 */                       expressionColumn2.mapColumns((ColumnResolver)tableFilter, 0);
/* 2250 */                       tableFilter = tableFilter.getJoin();
/*      */                     } 
/*      */                   } 
/* 2253 */                   TableFilter tableFilter1 = expressionColumn1.getTableFilter();
/* 2254 */                   TableFilter tableFilter2 = expressionColumn2.getTableFilter();
/* 2255 */                   comparison = new Comparison(this.session, j, (Expression)conditionInSelect, expression1);
/* 2256 */                   if (tableFilter1 != null && tableFilter2 != null) {
/* 2257 */                     int k = arrayList.indexOf(tableFilter2);
/* 2258 */                     if (k >= 0) {
/* 2259 */                       arrayList.remove(k);
/* 2260 */                       tableFilter1.addJoin(tableFilter2, true, false, (Expression)comparison);
/*      */                     } else {
/*      */                       
/* 2263 */                       tableFilter2.mapAndAddFilter((Expression)comparison);
/*      */                     } 
/* 2265 */                     valueExpression = ValueExpression.get((Value)ValueBoolean.get(true));
/*      */                   } 
/*      */                 }  }
/*      */               else
/* 2269 */               { comparison = new Comparison(this.session, j, (Expression)valueExpression, expression1); } 
/*      */             } 
/*      */           }  }
/*      */       
/* 2273 */       }  if (bool) {
/* 2274 */         conditionNot = new ConditionNot((Expression)comparison);
/*      */       }
/*      */     } 
/* 2277 */     return (Expression)conditionNot;
/*      */   }
/*      */   private Expression readConcat() {
/*      */     ConditionNot conditionNot;
/* 2281 */     Expression expression = readSum(); while (true) {
/*      */       Operation operation; CompareLike compareLike;
/* 2283 */       while (readIf("||"))
/* 2284 */         operation = new Operation(0, expression, readSum()); 
/* 2285 */       if (readIf("~")) {
/* 2286 */         Function function; if (readIf("*")) {
/* 2287 */           Function function1 = Function.getFunction(this.database, "CAST");
/* 2288 */           function1.setDataType(new Column("X", 14));
/*      */           
/* 2290 */           function1.setParameter(0, (Expression)operation);
/* 2291 */           function = function1;
/*      */         } 
/* 2293 */         compareLike = new CompareLike(this.database, (Expression)function, readSum(), null, true); continue;
/* 2294 */       }  if (readIf("!~")) {
/* 2295 */         Function function; if (readIf("*")) {
/* 2296 */           Function function1 = Function.getFunction(this.database, "CAST");
/* 2297 */           function1.setDataType(new Column("X", 14));
/*      */           
/* 2299 */           function1.setParameter(0, (Expression)compareLike);
/* 2300 */           function = function1;
/*      */         } 
/* 2302 */         conditionNot = new ConditionNot((Expression)new CompareLike(this.database, (Expression)function, readSum(), null, true)); continue;
/*      */       }  break;
/*      */     } 
/* 2305 */     return (Expression)conditionNot;
/*      */   }
/*      */ 
/*      */   
/*      */   private Expression readSum() {
/*      */     Operation operation;
/* 2311 */     Expression expression = readFactor();
/*      */     while (true) {
/* 2313 */       while (readIf("+"))
/* 2314 */         operation = new Operation(1, expression, readFactor()); 
/* 2315 */       if (readIf("-")) {
/* 2316 */         operation = new Operation(2, (Expression)operation, readFactor()); continue;
/*      */       }  break;
/* 2318 */     }  return (Expression)operation;
/*      */   }
/*      */ 
/*      */   
/*      */   private Expression readFactor() {
/*      */     Operation operation;
/* 2324 */     Expression expression = readTerm();
/*      */     while (true) {
/* 2326 */       while (readIf("*"))
/* 2327 */         operation = new Operation(3, expression, readTerm()); 
/* 2328 */       if (readIf("/")) {
/* 2329 */         operation = new Operation(4, (Expression)operation, readTerm()); continue;
/* 2330 */       }  if (readIf("%")) {
/* 2331 */         operation = new Operation(6, (Expression)operation, readTerm()); continue;
/*      */       }  break;
/* 2333 */     }  return (Expression)operation;
/*      */   }
/*      */ 
/*      */   
/*      */   private Expression readAggregate(int paramInt, String paramString) {
/*      */     Aggregate aggregate;
/* 2339 */     if (this.currentSelect == null) {
/* 2340 */       throw getSyntaxError();
/*      */     }
/* 2342 */     this.currentSelect.setGroupQuery();
/*      */     
/* 2344 */     if (paramInt == 1) {
/* 2345 */       if (readIf("*")) {
/* 2346 */         aggregate = new Aggregate(0, null, this.currentSelect, false);
/*      */       } else {
/*      */         
/* 2349 */         boolean bool = readIf("DISTINCT");
/* 2350 */         Expression expression = readExpression();
/* 2351 */         if (expression instanceof Wildcard && !bool) {
/*      */           
/* 2353 */           aggregate = new Aggregate(0, null, this.currentSelect, false);
/*      */         } else {
/*      */           
/* 2356 */           aggregate = new Aggregate(1, expression, this.currentSelect, bool);
/*      */         }
/*      */       
/*      */       } 
/* 2360 */     } else if (paramInt == 2) {
/* 2361 */       Aggregate aggregate1 = null;
/* 2362 */       boolean bool = readIf("DISTINCT");
/*      */       
/* 2364 */       if (equalsToken("GROUP_CONCAT", paramString)) {
/* 2365 */         aggregate1 = new Aggregate(2, readExpression(), this.currentSelect, bool);
/*      */         
/* 2367 */         if (readIf("ORDER")) {
/* 2368 */           read("BY");
/* 2369 */           aggregate1.setGroupConcatOrder(parseSimpleOrderList());
/*      */         } 
/*      */         
/* 2372 */         if (readIf("SEPARATOR")) {
/* 2373 */           aggregate1.setGroupConcatSeparator(readExpression());
/*      */         }
/* 2375 */       } else if (equalsToken("STRING_AGG", paramString)) {
/*      */         
/* 2377 */         aggregate1 = new Aggregate(2, readExpression(), this.currentSelect, bool);
/*      */         
/* 2379 */         read(",");
/* 2380 */         aggregate1.setGroupConcatSeparator(readExpression());
/* 2381 */         if (readIf("ORDER")) {
/* 2382 */           read("BY");
/* 2383 */           aggregate1.setGroupConcatOrder(parseSimpleOrderList());
/*      */         } 
/*      */       } 
/* 2386 */       aggregate = aggregate1;
/*      */     } else {
/* 2388 */       boolean bool = readIf("DISTINCT");
/* 2389 */       aggregate = new Aggregate(paramInt, readExpression(), this.currentSelect, bool);
/*      */     } 
/*      */     
/* 2392 */     read(")");
/* 2393 */     return (Expression)aggregate;
/*      */   }
/*      */   
/*      */   private ArrayList<SelectOrderBy> parseSimpleOrderList() {
/* 2397 */     ArrayList<SelectOrderBy> arrayList = New.arrayList();
/*      */     while (true) {
/* 2399 */       SelectOrderBy selectOrderBy = new SelectOrderBy();
/* 2400 */       Expression expression = readExpression();
/* 2401 */       selectOrderBy.expression = expression;
/* 2402 */       if (readIf("DESC")) {
/* 2403 */         selectOrderBy.descending = true;
/*      */       } else {
/* 2405 */         readIf("ASC");
/*      */       } 
/* 2407 */       arrayList.add(selectOrderBy);
/* 2408 */       if (!readIf(","))
/* 2409 */         return arrayList; 
/*      */     } 
/*      */   }
/*      */   private JavaFunction readJavaFunction(Schema paramSchema, String paramString) {
/* 2413 */     FunctionAlias functionAlias = null;
/* 2414 */     if (paramSchema != null) {
/* 2415 */       functionAlias = paramSchema.findFunction(paramString);
/*      */     } else {
/* 2417 */       functionAlias = findFunctionAlias(this.session.getCurrentSchemaName(), paramString);
/*      */     } 
/*      */     
/* 2420 */     if (functionAlias == null) {
/* 2421 */       throw DbException.get(90022, paramString);
/*      */     }
/*      */     
/* 2424 */     ArrayList<Expression> arrayList = New.arrayList();
/* 2425 */     byte b = 0;
/* 2426 */     while (!readIf(")")) {
/* 2427 */       if (b++ > 0) {
/* 2428 */         read(",");
/*      */       }
/* 2430 */       arrayList.add(readExpression());
/*      */     } 
/* 2432 */     Expression[] arrayOfExpression = new Expression[b];
/* 2433 */     arrayList.toArray(arrayOfExpression);
/* 2434 */     return new JavaFunction(functionAlias, arrayOfExpression);
/*      */   }
/*      */ 
/*      */   
/*      */   private JavaAggregate readJavaAggregate(UserAggregate paramUserAggregate) {
/* 2439 */     ArrayList<Expression> arrayList = New.arrayList();
/*      */     while (true) {
/* 2441 */       arrayList.add(readExpression());
/* 2442 */       if (!readIf(",")) {
/* 2443 */         read(")");
/* 2444 */         Expression[] arrayOfExpression = new Expression[arrayList.size()];
/* 2445 */         arrayList.toArray(arrayOfExpression);
/* 2446 */         JavaAggregate javaAggregate = new JavaAggregate(paramUserAggregate, arrayOfExpression, this.currentSelect);
/* 2447 */         this.currentSelect.setGroupQuery();
/* 2448 */         return javaAggregate;
/*      */       } 
/*      */     } 
/*      */   }
/* 2452 */   private int getAggregateType(String paramString) { if (!this.identifiersToUpper)
/*      */     {
/* 2454 */       paramString = StringUtils.toUpperEnglish(paramString);
/*      */     }
/* 2456 */     return Aggregate.getAggregateType(paramString); } private Expression readFunction(Schema paramSchema, String paramString) { Column column; Expression expression1;
/*      */     byte b;
/*      */     Expression expression2;
/*      */     ArrayList<Column> arrayList;
/* 2460 */     if (paramSchema != null) {
/* 2461 */       return (Expression)readJavaFunction(paramSchema, paramString);
/*      */     }
/* 2463 */     int i = getAggregateType(paramString);
/* 2464 */     if (i >= 0) {
/* 2465 */       return readAggregate(i, paramString);
/*      */     }
/* 2467 */     Function function = Function.getFunction(this.database, paramString);
/* 2468 */     if (function == null) {
/* 2469 */       UserAggregate userAggregate = this.database.findAggregate(paramString);
/* 2470 */       if (userAggregate != null) {
/* 2471 */         return (Expression)readJavaAggregate(userAggregate);
/*      */       }
/* 2473 */       return (Expression)readJavaFunction(null, paramString);
/*      */     } 
/* 2475 */     switch (function.getFunctionType())
/*      */     { case 203:
/* 2477 */         function.setParameter(0, readExpression());
/* 2478 */         read("AS");
/* 2479 */         column = parseColumnWithType(null);
/* 2480 */         function.setDataType(column);
/* 2481 */         read(")");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2628 */         function.doneWithParameters();
/* 2629 */         return (Expression)function;case 202: if ((this.database.getMode()).swapConvertFunctionParameters) { column = parseColumnWithType(null); function.setDataType(column); read(","); function.setParameter(0, readExpression()); read(")"); } else { function.setParameter(0, readExpression()); read(","); column = parseColumnWithType(null); function.setDataType(column); read(")"); }  function.doneWithParameters(); return (Expression)function;case 120: function.setParameter(0, (Expression)ValueExpression.get(ValueString.get(this.currentToken))); read(); read("FROM"); function.setParameter(1, readExpression()); read(")"); function.doneWithParameters(); return (Expression)function;case 102: case 103: if (Function.isDatePart(this.currentToken)) { function.setParameter(0, (Expression)ValueExpression.get(ValueString.get(this.currentToken))); read(); } else { function.setParameter(0, readExpression()); }  read(","); function.setParameter(1, readExpression()); read(","); function.setParameter(2, readExpression()); read(")"); function.doneWithParameters(); return (Expression)function;case 73: function.setParameter(0, readExpression()); if (readIf("FROM")) { function.setParameter(1, readExpression()); if (readIf("FOR")) function.setParameter(2, readExpression());  } else if (readIf("FOR")) { function.setParameter(1, (Expression)ValueExpression.get((Value)ValueInt.get(0))); function.setParameter(2, readExpression()); } else { read(","); function.setParameter(1, readExpression()); if (readIf(",")) function.setParameter(2, readExpression());  }  read(")"); function.doneWithParameters(); return (Expression)function;case 77: function.setParameter(0, readConcat()); if (!readIf(",")) read("IN");  function.setParameter(1, readExpression()); read(")"); function.doneWithParameters(); return (Expression)function;case 78: column = null; if (readIf("LEADING")) { function = Function.getFunction(this.database, "LTRIM"); if (!readIf("FROM")) { expression1 = readExpression(); read("FROM"); }  } else if (readIf("TRAILING")) { function = Function.getFunction(this.database, "RTRIM"); if (!readIf("FROM")) { expression1 = readExpression(); read("FROM"); }  } else if (readIf("BOTH") && !readIf("FROM")) { expression1 = readExpression(); read("FROM"); }  expression2 = readExpression(); if (readIf(",")) { expression1 = readExpression(); } else if (readIf("FROM")) { expression1 = expression2; expression2 = readExpression(); }  function.setParameter(0, expression2); if (expression1 != null) function.setParameter(1, expression1);  read(")"); function.doneWithParameters(); return (Expression)function;case 223: case 224: b = 0; arrayList = New.arrayList(); while (true) { String str = readAliasIdentifier(); Column column1 = parseColumnWithType(str); arrayList.add(column1); read("="); function.setParameter(b, readExpression()); b++; if (!readIf(",")) { read(")"); TableFunction tableFunction = (TableFunction)function; tableFunction.setColumns(arrayList); function.doneWithParameters(); return (Expression)function; }  } case 300: read(")"); read("OVER"); read("("); read(")"); return (Expression)new Rownum((this.currentSelect == null) ? this.currentPrepared : (Prepared)this.currentSelect); }  if (!readIf(")")) { b = 0; while (true) { function.setParameter(b++, readExpression()); if (!readIf(",")) { read(")"); break; }  }  }  function.doneWithParameters(); return (Expression)function; }
/*      */ 
/*      */   
/*      */   private Function readFunctionWithoutParameters(String paramString) {
/* 2633 */     if (readIf("(")) {
/* 2634 */       read(")");
/*      */     }
/* 2636 */     Function function = Function.getFunction(this.database, paramString);
/* 2637 */     function.doneWithParameters();
/* 2638 */     return function;
/*      */   }
/*      */ 
/*      */   
/*      */   private Expression readWildcardOrSequenceValue(String paramString1, String paramString2) {
/* 2643 */     if (readIf("*")) {
/* 2644 */       return (Expression)new Wildcard(paramString1, paramString2);
/*      */     }
/* 2646 */     if (paramString1 == null) {
/* 2647 */       paramString1 = this.session.getCurrentSchemaName();
/*      */     }
/* 2649 */     if (readIf("NEXTVAL")) {
/* 2650 */       Sequence sequence = findSequence(paramString1, paramString2);
/* 2651 */       if (sequence != null) {
/* 2652 */         return (Expression)new SequenceValue(sequence);
/*      */       }
/* 2654 */     } else if (readIf("CURRVAL")) {
/* 2655 */       Sequence sequence = findSequence(paramString1, paramString2);
/* 2656 */       if (sequence != null) {
/* 2657 */         Function function = Function.getFunction(this.database, "CURRVAL");
/* 2658 */         function.setParameter(0, (Expression)ValueExpression.get(ValueString.get(sequence.getSchema().getName())));
/*      */         
/* 2660 */         function.setParameter(1, (Expression)ValueExpression.get(ValueString.get(sequence.getName())));
/*      */         
/* 2662 */         function.doneWithParameters();
/* 2663 */         return (Expression)function;
/*      */       } 
/*      */     } 
/* 2666 */     return null;
/*      */   }
/*      */   
/*      */   private Expression readTermObjectDot(String paramString) {
/* 2670 */     Expression expression = readWildcardOrSequenceValue(null, paramString);
/* 2671 */     if (expression != null) {
/* 2672 */       return expression;
/*      */     }
/* 2674 */     String str = readColumnIdentifier();
/* 2675 */     Schema schema = this.database.findSchema(paramString);
/* 2676 */     if ((!SysProperties.OLD_STYLE_OUTER_JOIN || schema != null) && readIf("("))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2682 */       return readFunction(schema, str); } 
/* 2683 */     if (readIf(".")) {
/* 2684 */       String str1 = paramString;
/* 2685 */       paramString = str;
/* 2686 */       expression = readWildcardOrSequenceValue(str1, paramString);
/* 2687 */       if (expression != null) {
/* 2688 */         return expression;
/*      */       }
/* 2690 */       str = readColumnIdentifier();
/* 2691 */       if (readIf("(")) {
/* 2692 */         String str2 = str1;
/* 2693 */         if (!equalsToken(this.database.getShortName(), str2)) {
/* 2694 */           throw DbException.get(90013, str2);
/*      */         }
/*      */         
/* 2697 */         str1 = paramString;
/* 2698 */         return readFunction(this.database.getSchema(str1), str);
/* 2699 */       }  if (readIf(".")) {
/* 2700 */         String str2 = str1;
/* 2701 */         if (!equalsToken(this.database.getShortName(), str2)) {
/* 2702 */           throw DbException.get(90013, str2);
/*      */         }
/*      */         
/* 2705 */         str1 = paramString;
/* 2706 */         paramString = str;
/* 2707 */         expression = readWildcardOrSequenceValue(str1, paramString);
/* 2708 */         if (expression != null) {
/* 2709 */           return expression;
/*      */         }
/* 2711 */         str = readColumnIdentifier();
/* 2712 */         return (Expression)new ExpressionColumn(this.database, str1, paramString, str);
/*      */       } 
/* 2714 */       return (Expression)new ExpressionColumn(this.database, str1, paramString, str);
/*      */     } 
/* 2716 */     return (Expression)new ExpressionColumn(this.database, null, paramString, str); } private Expression readTerm() { Variable variable; Parameter parameter1; ExpressionColumn expressionColumn; Operation operation; Expression expression; ValueExpression valueExpression2; Function function2; Rownum rownum; ValueExpression valueExpression1; Function function1;
/*      */     boolean bool;
/*      */     Parameter parameter2;
/*      */     String str;
/*      */     Function function3;
/* 2721 */     switch (this.currentTokenType) {
/*      */       case 12:
/* 2723 */         read();
/* 2724 */         variable = new Variable(this.session, readAliasIdentifier());
/* 2725 */         if (readIf(":=")) {
/* 2726 */           Expression expression1 = readExpression();
/* 2727 */           Function function = Function.getFunction(this.database, "SET");
/* 2728 */           function.setParameter(0, (Expression)variable);
/* 2729 */           function.setParameter(1, expression1);
/* 2730 */           function1 = function;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 3:
/* 2735 */         bool = Character.isDigit(this.sqlCommandChars[this.parseIndex]);
/* 2736 */         read();
/*      */         
/* 2738 */         if (bool && this.currentTokenType == 5 && this.currentValue.getType() == 4) {
/*      */           
/* 2740 */           if (this.indexedParameterList == null) {
/* 2741 */             if (this.parameters == null)
/*      */             {
/*      */               
/* 2744 */               throw getSyntaxError(); } 
/* 2745 */             if (this.parameters.size() > 0) {
/* 2746 */               throw DbException.get(90123);
/*      */             }
/*      */             
/* 2749 */             this.indexedParameterList = New.arrayList();
/*      */           } 
/* 2751 */           int i = this.currentValue.getInt() - 1;
/* 2752 */           if (i < 0 || i >= 100000) {
/* 2753 */             throw DbException.getInvalidValueException("parameter index", Integer.valueOf(i));
/*      */           }
/*      */           
/* 2756 */           if (this.indexedParameterList.size() <= i) {
/* 2757 */             this.indexedParameterList.ensureCapacity(i + 1);
/* 2758 */             while (this.indexedParameterList.size() <= i) {
/* 2759 */               this.indexedParameterList.add(null);
/*      */             }
/*      */           } 
/* 2762 */           parameter2 = this.indexedParameterList.get(i);
/* 2763 */           if (parameter2 == null) {
/* 2764 */             parameter2 = new Parameter(i);
/* 2765 */             this.indexedParameterList.set(i, parameter2);
/*      */           } 
/* 2767 */           read();
/*      */         } else {
/* 2769 */           if (this.indexedParameterList != null) {
/* 2770 */             throw DbException.get(90123);
/*      */           }
/*      */           
/* 2773 */           parameter2 = new Parameter(this.parameters.size());
/*      */         } 
/* 2775 */         this.parameters.add(parameter2);
/* 2776 */         parameter1 = parameter2;
/*      */         break;
/*      */       case 1:
/* 2779 */         if (isToken("SELECT") || isToken("FROM") || isToken("WITH")) {
/* 2780 */           Query query = parseSelect();
/* 2781 */           Subquery subquery = new Subquery(query); break;
/*      */         } 
/* 2783 */         throw getSyntaxError();
/*      */ 
/*      */       
/*      */       case 2:
/* 2787 */         str = this.currentToken;
/* 2788 */         if (this.currentTokenQuoted) {
/* 2789 */           read();
/* 2790 */           if (readIf("(")) {
/* 2791 */             Expression expression1 = readFunction(null, str); break;
/* 2792 */           }  if (readIf(".")) {
/* 2793 */             Expression expression1 = readTermObjectDot(str); break;
/*      */           } 
/* 2795 */           ExpressionColumn expressionColumn1 = new ExpressionColumn(this.database, null, null, str);
/*      */           break;
/*      */         } 
/* 2798 */         read();
/* 2799 */         if (readIf(".")) {
/* 2800 */           Expression expression1 = readTermObjectDot(str); break;
/* 2801 */         }  if (equalsToken("CASE", str)) {
/*      */ 
/*      */ 
/*      */           
/* 2805 */           Expression expression1 = readCase(); break;
/* 2806 */         }  if (readIf("(")) {
/* 2807 */           Expression expression1 = readFunction(null, str); break;
/* 2808 */         }  if (equalsToken("CURRENT_USER", str)) {
/* 2809 */           function1 = readFunctionWithoutParameters("USER"); break;
/* 2810 */         }  if (equalsToken("CURRENT", str)) {
/* 2811 */           if (readIf("TIMESTAMP")) {
/* 2812 */             function1 = readFunctionWithoutParameters("CURRENT_TIMESTAMP"); break;
/* 2813 */           }  if (readIf("TIME")) {
/* 2814 */             function1 = readFunctionWithoutParameters("CURRENT_TIME"); break;
/* 2815 */           }  if (readIf("DATE")) {
/* 2816 */             function1 = readFunctionWithoutParameters("CURRENT_DATE"); break;
/*      */           } 
/* 2818 */           ExpressionColumn expressionColumn1 = new ExpressionColumn(this.database, null, null, str); break;
/*      */         } 
/* 2820 */         if (equalsToken("NEXT", str) && readIf("VALUE")) {
/* 2821 */           read("FOR");
/* 2822 */           Sequence sequence = readSequence();
/* 2823 */           SequenceValue sequenceValue = new SequenceValue(sequence); break;
/* 2824 */         }  if (this.currentTokenType == 5 && this.currentValue.getType() == 13) {
/*      */           
/* 2826 */           if (equalsToken("DATE", str) || equalsToken("D", str)) {
/*      */             
/* 2828 */             String str1 = this.currentValue.getString();
/* 2829 */             read();
/* 2830 */             ValueExpression valueExpression = ValueExpression.get((Value)ValueDate.parse(str1)); break;
/* 2831 */           }  if (equalsToken("TIME", str) || equalsToken("T", str)) {
/*      */             
/* 2833 */             String str1 = this.currentValue.getString();
/* 2834 */             read();
/* 2835 */             ValueExpression valueExpression = ValueExpression.get((Value)ValueTime.parse(str1)); break;
/* 2836 */           }  if (equalsToken("TIMESTAMP", str) || equalsToken("TS", str)) {
/*      */             
/* 2838 */             String str1 = this.currentValue.getString();
/* 2839 */             read();
/* 2840 */             ValueExpression valueExpression = ValueExpression.get((Value)ValueTimestamp.parse(str1)); break;
/*      */           } 
/* 2842 */           if (equalsToken("X", str)) {
/* 2843 */             read();
/* 2844 */             byte[] arrayOfByte = StringUtils.convertHexToBytes(this.currentValue.getString());
/*      */             
/* 2846 */             ValueExpression valueExpression = ValueExpression.get((Value)ValueBytes.getNoCopy(arrayOfByte)); break;
/* 2847 */           }  if (equalsToken("E", str)) {
/* 2848 */             String str1 = this.currentValue.getString();
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2853 */             str1 = StringUtils.replaceAll(str1, "\\\\", "\\");
/* 2854 */             read();
/* 2855 */             ValueExpression valueExpression = ValueExpression.get(ValueString.get(str1)); break;
/* 2856 */           }  if (equalsToken("N", str)) {
/*      */             
/* 2858 */             String str1 = this.currentValue.getString();
/* 2859 */             read();
/* 2860 */             ValueExpression valueExpression = ValueExpression.get(ValueString.get(str1)); break;
/*      */           } 
/* 2862 */           ExpressionColumn expressionColumn1 = new ExpressionColumn(this.database, null, null, str);
/*      */           break;
/*      */         } 
/* 2865 */         expressionColumn = new ExpressionColumn(this.database, null, null, str);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 13:
/* 2870 */         read();
/* 2871 */         if (this.currentTokenType == 5) {
/* 2872 */           ValueExpression valueExpression = ValueExpression.get(this.currentValue.negate());
/* 2873 */           if (valueExpression.getType() == 5 && valueExpression.getValue(this.session).getLong() == -2147483648L) {
/*      */ 
/*      */ 
/*      */             
/* 2877 */             valueExpression = ValueExpression.get((Value)ValueInt.get(-2147483648));
/* 2878 */           } else if (valueExpression.getType() == 6 && valueExpression.getValue(this.session).getBigDecimal().compareTo(ValueLong.MIN_BD) == 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2883 */             valueExpression = ValueExpression.get((Value)ValueLong.get(Long.MIN_VALUE));
/*      */           } 
/* 2885 */           read(); break;
/*      */         } 
/* 2887 */         operation = new Operation(5, readTerm(), null);
/*      */         break;
/*      */       
/*      */       case 14:
/* 2891 */         read();
/* 2892 */         expression = readTerm();
/*      */         break;
/*      */       case 16:
/* 2895 */         read();
/* 2896 */         if (readIf(")")) {
/* 2897 */           ExpressionList expressionList = new ExpressionList(new Expression[0]); break;
/*      */         } 
/* 2899 */         expression = readExpression();
/* 2900 */         if (readIf(",")) {
/* 2901 */           ArrayList<Expression> arrayList = New.arrayList();
/* 2902 */           arrayList.add(expression);
/* 2903 */           while (!readIf(")")) {
/* 2904 */             expression = readExpression();
/* 2905 */             arrayList.add(expression);
/* 2906 */             if (!readIf(",")) {
/* 2907 */               read(")");
/*      */               break;
/*      */             } 
/*      */           } 
/* 2911 */           Expression[] arrayOfExpression = new Expression[arrayList.size()];
/* 2912 */           arrayList.toArray(arrayOfExpression);
/* 2913 */           ExpressionList expressionList = new ExpressionList(arrayOfExpression); break;
/*      */         } 
/* 2915 */         read(")");
/*      */         break;
/*      */ 
/*      */       
/*      */       case 19:
/* 2920 */         read();
/* 2921 */         valueExpression2 = ValueExpression.get((Value)ValueBoolean.get(true));
/*      */         break;
/*      */       case 20:
/* 2924 */         read();
/* 2925 */         valueExpression2 = ValueExpression.get((Value)ValueBoolean.get(false));
/*      */         break;
/*      */       case 23:
/* 2928 */         read();
/* 2929 */         function2 = readFunctionWithoutParameters("CURRENT_TIME");
/*      */         break;
/*      */       case 22:
/* 2932 */         read();
/* 2933 */         function2 = readFunctionWithoutParameters("CURRENT_DATE");
/*      */         break;
/*      */       case 21:
/* 2936 */         function3 = Function.getFunction(this.database, "CURRENT_TIMESTAMP");
/*      */         
/* 2938 */         read();
/* 2939 */         if (readIf("(") && 
/* 2940 */           !readIf(")")) {
/* 2941 */           function3.setParameter(0, readExpression());
/* 2942 */           read(")");
/*      */         } 
/*      */         
/* 2945 */         function3.doneWithParameters();
/* 2946 */         function2 = function3;
/*      */         break;
/*      */       
/*      */       case 24:
/* 2950 */         read();
/* 2951 */         if (readIf("(")) {
/* 2952 */           read(")");
/*      */         }
/* 2954 */         rownum = new Rownum((this.currentSelect == null) ? this.currentPrepared : (Prepared)this.currentSelect);
/*      */         break;
/*      */       
/*      */       case 18:
/* 2958 */         read();
/* 2959 */         valueExpression1 = ValueExpression.getNull();
/*      */         break;
/*      */       case 5:
/* 2962 */         valueExpression1 = ValueExpression.get(this.currentValue);
/* 2963 */         read();
/*      */         break;
/*      */       default:
/* 2966 */         throw getSyntaxError();
/*      */     } 
/* 2968 */     if (readIf("[")) {
/* 2969 */       Function function = Function.getFunction(this.database, "ARRAY_GET");
/* 2970 */       function.setParameter(0, (Expression)valueExpression1);
/* 2971 */       Expression expression1 = readExpression();
/* 2972 */       Operation operation1 = new Operation(1, expression1, (Expression)ValueExpression.get((Value)ValueInt.get(1)));
/*      */       
/* 2974 */       function.setParameter(1, (Expression)operation1);
/* 2975 */       function1 = function;
/* 2976 */       read("]");
/*      */     } 
/* 2978 */     if (readIf("::")) {
/*      */       JavaFunction javaFunction;
/* 2980 */       if (isToken("PG_CATALOG")) {
/* 2981 */         read("PG_CATALOG");
/* 2982 */         read(".");
/*      */       } 
/* 2984 */       if (readIf("REGCLASS")) {
/* 2985 */         FunctionAlias functionAlias = findFunctionAlias("PUBLIC", "PG_GET_OID");
/*      */         
/* 2987 */         if (functionAlias == null) {
/* 2988 */           throw getSyntaxError();
/*      */         }
/* 2990 */         Expression[] arrayOfExpression = { (Expression)function1 };
/* 2991 */         JavaFunction javaFunction1 = new JavaFunction(functionAlias, arrayOfExpression);
/* 2992 */         javaFunction = javaFunction1;
/*      */       } else {
/* 2994 */         Column column = parseColumnWithType(null);
/* 2995 */         Function function = Function.getFunction(this.database, "CAST");
/* 2996 */         function.setDataType(column);
/* 2997 */         function.setParameter(0, (Expression)javaFunction);
/* 2998 */         function1 = function;
/*      */       } 
/*      */     } 
/* 3001 */     return (Expression)function1; }
/*      */    private Expression readCase() {
/*      */     byte b;
/*      */     Function function;
/* 3005 */     if (readIf("END")) {
/* 3006 */       readIf("CASE");
/* 3007 */       return (Expression)ValueExpression.getNull();
/*      */     } 
/* 3009 */     if (readIf("ELSE")) {
/* 3010 */       Expression expression = readExpression().optimize(this.session);
/* 3011 */       read("END");
/* 3012 */       readIf("CASE");
/* 3013 */       return expression;
/*      */     } 
/*      */ 
/*      */     
/* 3017 */     if (readIf("WHEN")) {
/* 3018 */       function = Function.getFunction(this.database, "CASE");
/* 3019 */       function.setParameter(0, null);
/* 3020 */       b = 1;
/*      */       do {
/* 3022 */         function.setParameter(b++, readExpression());
/* 3023 */         read("THEN");
/* 3024 */         function.setParameter(b++, readExpression());
/* 3025 */       } while (readIf("WHEN"));
/*      */     } else {
/* 3027 */       Expression expression = readExpression();
/* 3028 */       if (readIf("END")) {
/* 3029 */         readIf("CASE");
/* 3030 */         return (Expression)ValueExpression.getNull();
/*      */       } 
/* 3032 */       if (readIf("ELSE")) {
/* 3033 */         Expression expression1 = readExpression().optimize(this.session);
/* 3034 */         read("END");
/* 3035 */         readIf("CASE");
/* 3036 */         return expression1;
/*      */       } 
/* 3038 */       function = Function.getFunction(this.database, "CASE");
/* 3039 */       function.setParameter(0, expression);
/* 3040 */       b = 1;
/* 3041 */       read("WHEN");
/*      */       do {
/* 3043 */         function.setParameter(b++, readExpression());
/* 3044 */         read("THEN");
/* 3045 */         function.setParameter(b++, readExpression());
/* 3046 */       } while (readIf("WHEN"));
/*      */     } 
/* 3048 */     if (readIf("ELSE")) {
/* 3049 */       function.setParameter(b, readExpression());
/*      */     }
/* 3051 */     read("END");
/* 3052 */     readIf("CASE");
/* 3053 */     function.doneWithParameters();
/* 3054 */     return (Expression)function;
/*      */   }
/*      */   
/*      */   private int readPositiveInt() {
/* 3058 */     int i = readInt();
/* 3059 */     if (i < 0) {
/* 3060 */       throw DbException.getInvalidValueException("positive integer", Integer.valueOf(i));
/*      */     }
/* 3062 */     return i;
/*      */   }
/*      */   
/*      */   private int readInt() {
/* 3066 */     boolean bool = false;
/* 3067 */     if (this.currentTokenType == 13) {
/* 3068 */       bool = true;
/* 3069 */       read();
/* 3070 */     } else if (this.currentTokenType == 14) {
/* 3071 */       read();
/*      */     } 
/* 3073 */     if (this.currentTokenType != 5) {
/* 3074 */       throw DbException.getSyntaxError(this.sqlCommand, this.parseIndex, "integer");
/*      */     }
/* 3076 */     if (bool)
/*      */     {
/* 3078 */       this.currentValue = this.currentValue.negate();
/*      */     }
/* 3080 */     int i = this.currentValue.getInt();
/* 3081 */     read();
/* 3082 */     return i;
/*      */   }
/*      */   
/*      */   private long readLong() {
/* 3086 */     boolean bool = false;
/* 3087 */     if (this.currentTokenType == 13) {
/* 3088 */       bool = true;
/* 3089 */       read();
/* 3090 */     } else if (this.currentTokenType == 14) {
/* 3091 */       read();
/*      */     } 
/* 3093 */     if (this.currentTokenType != 5) {
/* 3094 */       throw DbException.getSyntaxError(this.sqlCommand, this.parseIndex, "long");
/*      */     }
/* 3096 */     if (bool)
/*      */     {
/* 3098 */       this.currentValue = this.currentValue.negate();
/*      */     }
/* 3100 */     long l = this.currentValue.getLong();
/* 3101 */     read();
/* 3102 */     return l;
/*      */   }
/*      */   
/*      */   private boolean readBooleanSetting() {
/* 3106 */     if (this.currentTokenType == 5) {
/* 3107 */       boolean bool = this.currentValue.getBoolean().booleanValue();
/* 3108 */       read();
/* 3109 */       return bool;
/*      */     } 
/* 3111 */     if (readIf("TRUE") || readIf("ON"))
/* 3112 */       return true; 
/* 3113 */     if (readIf("FALSE") || readIf("OFF")) {
/* 3114 */       return false;
/*      */     }
/* 3116 */     throw getSyntaxError();
/*      */   }
/*      */ 
/*      */   
/*      */   private String readString() {
/* 3121 */     Expression expression = readExpression().optimize(this.session);
/* 3122 */     if (!(expression instanceof ValueExpression)) {
/* 3123 */       throw DbException.getSyntaxError(this.sqlCommand, this.parseIndex, "string");
/*      */     }
/* 3125 */     return expression.getValue(this.session).getString();
/*      */   }
/*      */ 
/*      */   
/*      */   private String readIdentifierWithSchema(String paramString) {
/* 3130 */     if (this.currentTokenType != 2) {
/* 3131 */       throw DbException.getSyntaxError(this.sqlCommand, this.parseIndex, "identifier");
/*      */     }
/*      */     
/* 3134 */     String str = this.currentToken;
/* 3135 */     read();
/* 3136 */     this.schemaName = paramString;
/* 3137 */     if (readIf(".")) {
/* 3138 */       this.schemaName = str;
/* 3139 */       if (this.currentTokenType != 2) {
/* 3140 */         throw DbException.getSyntaxError(this.sqlCommand, this.parseIndex, "identifier");
/*      */       }
/*      */       
/* 3143 */       str = this.currentToken;
/* 3144 */       read();
/*      */     } 
/* 3146 */     if (equalsToken(".", this.currentToken) && 
/* 3147 */       equalsToken(this.schemaName, this.database.getShortName())) {
/* 3148 */       read(".");
/* 3149 */       this.schemaName = str;
/* 3150 */       if (this.currentTokenType != 2) {
/* 3151 */         throw DbException.getSyntaxError(this.sqlCommand, this.parseIndex, "identifier");
/*      */       }
/*      */       
/* 3154 */       str = this.currentToken;
/* 3155 */       read();
/*      */     } 
/*      */     
/* 3158 */     return str;
/*      */   }
/*      */   
/*      */   private String readIdentifierWithSchema() {
/* 3162 */     return readIdentifierWithSchema(this.session.getCurrentSchemaName());
/*      */   }
/*      */   
/*      */   private String readAliasIdentifier() {
/* 3166 */     return readColumnIdentifier();
/*      */   }
/*      */   
/*      */   private String readUniqueIdentifier() {
/* 3170 */     return readColumnIdentifier();
/*      */   }
/*      */   
/*      */   private String readColumnIdentifier() {
/* 3174 */     if (this.currentTokenType != 2) {
/* 3175 */       throw DbException.getSyntaxError(this.sqlCommand, this.parseIndex, "identifier");
/*      */     }
/*      */     
/* 3178 */     String str = this.currentToken;
/* 3179 */     read();
/* 3180 */     return str;
/*      */   }
/*      */   
/*      */   private void read(String paramString) {
/* 3184 */     if (this.currentTokenQuoted || !equalsToken(paramString, this.currentToken)) {
/* 3185 */       addExpected(paramString);
/* 3186 */       throw getSyntaxError();
/*      */     } 
/* 3188 */     read();
/*      */   }
/*      */   
/*      */   private boolean readIf(String paramString) {
/* 3192 */     if (!this.currentTokenQuoted && equalsToken(paramString, this.currentToken)) {
/* 3193 */       read();
/* 3194 */       return true;
/*      */     } 
/* 3196 */     addExpected(paramString);
/* 3197 */     return false;
/*      */   }
/*      */   
/*      */   private boolean isToken(String paramString) {
/* 3201 */     boolean bool = (equalsToken(paramString, this.currentToken) && !this.currentTokenQuoted) ? true : false;
/*      */     
/* 3203 */     if (bool) {
/* 3204 */       return true;
/*      */     }
/* 3206 */     addExpected(paramString);
/* 3207 */     return false;
/*      */   }
/*      */   
/*      */   private boolean equalsToken(String paramString1, String paramString2) {
/* 3211 */     if (paramString1 == null)
/* 3212 */       return (paramString2 == null); 
/* 3213 */     if (paramString1.equals(paramString2))
/* 3214 */       return true; 
/* 3215 */     if (!this.identifiersToUpper && paramString1.equalsIgnoreCase(paramString2)) {
/* 3216 */       return true;
/*      */     }
/* 3218 */     return false;
/*      */   }
/*      */   
/*      */   private void addExpected(String paramString) {
/* 3222 */     if (this.expectedList != null)
/* 3223 */       this.expectedList.add(paramString);  } private void read() {
/*      */     String str1;
/*      */     long l;
/*      */     String str2;
/*      */     int m;
/* 3228 */     this.currentTokenQuoted = false;
/* 3229 */     if (this.expectedList != null) {
/* 3230 */       this.expectedList.clear();
/*      */     }
/* 3232 */     int[] arrayOfInt = this.characterTypes;
/* 3233 */     this.lastParseIndex = this.parseIndex;
/* 3234 */     int i = this.parseIndex;
/* 3235 */     int j = arrayOfInt[i];
/* 3236 */     while (j == 0) {
/* 3237 */       j = arrayOfInt[++i];
/*      */     }
/* 3239 */     int k = i;
/* 3240 */     char[] arrayOfChar = this.sqlCommandChars;
/* 3241 */     char c = arrayOfChar[i++];
/* 3242 */     this.currentToken = "";
/* 3243 */     switch (j) {
/*      */       case 4:
/*      */         while (true) {
/* 3246 */           j = arrayOfInt[i];
/* 3247 */           if (j != 4 && j != 2) {
/*      */             break;
/*      */           }
/* 3250 */           i++;
/*      */         } 
/* 3252 */         this.currentToken = StringUtils.fromCacheOrNew(this.sqlCommand.substring(k, i));
/*      */         
/* 3254 */         this.currentTokenType = getTokenType(this.currentToken);
/* 3255 */         this.parseIndex = i;
/*      */         return;
/*      */       case 3:
/* 3258 */         str1 = null;
/*      */         while (true) {
/* 3260 */           for (int n = i;; i++) {
/* 3261 */             if (arrayOfChar[i] == '"') {
/* 3262 */               if (str1 == null) {
/* 3263 */                 str1 = this.sqlCommand.substring(n, i); break;
/*      */               } 
/* 3265 */               str1 = str1 + this.sqlCommand.substring(n - 1, i);
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/* 3270 */           if (arrayOfChar[++i] != '"') {
/*      */             break;
/*      */           }
/* 3273 */           i++;
/*      */         } 
/* 3275 */         this.currentToken = StringUtils.fromCacheOrNew(str1);
/* 3276 */         this.parseIndex = i;
/* 3277 */         this.currentTokenQuoted = true;
/* 3278 */         this.currentTokenType = 2;
/*      */         return;
/*      */       
/*      */       case 6:
/* 3282 */         if (arrayOfInt[i] == 6) {
/* 3283 */           i++;
/*      */         }
/* 3285 */         this.currentToken = this.sqlCommand.substring(k, i);
/* 3286 */         this.currentTokenType = getSpecialType(this.currentToken);
/* 3287 */         this.parseIndex = i;
/*      */         return;
/*      */       case 5:
/* 3290 */         this.currentToken = this.sqlCommand.substring(k, i);
/* 3291 */         this.currentTokenType = getSpecialType(this.currentToken);
/* 3292 */         this.parseIndex = i;
/*      */         return;
/*      */       case 2:
/* 3295 */         if (c == '0' && arrayOfChar[i] == 'X') {
/*      */           
/* 3297 */           long l1 = 0L;
/* 3298 */           k += 2;
/* 3299 */           i++;
/*      */           while (true) {
/* 3301 */             c = arrayOfChar[i];
/* 3302 */             if ((c < '0' || c > '9') && (c < 'A' || c > 'F')) {
/* 3303 */               checkLiterals(false);
/* 3304 */               this.currentValue = (Value)ValueInt.get((int)l1);
/* 3305 */               this.currentTokenType = 5;
/* 3306 */               this.currentToken = "0";
/* 3307 */               this.parseIndex = i;
/*      */               return;
/*      */             } 
/* 3310 */             l1 = (l1 << 4L) + c - ((c >= 'A') ? 55L : 48L);
/*      */             
/* 3312 */             if (l1 > 2147483647L) {
/* 3313 */               readHexDecimal(k, i);
/*      */               return;
/*      */             } 
/* 3316 */             i++;
/*      */           } 
/*      */         } 
/* 3319 */         l = (c - 48);
/*      */         while (true) {
/* 3321 */           c = arrayOfChar[i];
/* 3322 */           if (c < '0' || c > '9') {
/* 3323 */             if (c == '.' || c == 'E' || c == 'L') {
/* 3324 */               readDecimal(k, i);
/*      */               break;
/*      */             } 
/* 3327 */             checkLiterals(false);
/* 3328 */             this.currentValue = (Value)ValueInt.get((int)l);
/* 3329 */             this.currentTokenType = 5;
/* 3330 */             this.currentToken = "0";
/* 3331 */             this.parseIndex = i;
/*      */             break;
/*      */           } 
/* 3334 */           l = l * 10L + (c - 48);
/* 3335 */           if (l > 2147483647L) {
/* 3336 */             readDecimal(k, i);
/*      */             break;
/*      */           } 
/* 3339 */           i++;
/*      */         } 
/*      */         return;
/*      */       case 8:
/* 3343 */         if (arrayOfInt[i] != 2) {
/* 3344 */           this.currentTokenType = 1;
/* 3345 */           this.currentToken = ".";
/* 3346 */           this.parseIndex = i;
/*      */           return;
/*      */         } 
/* 3349 */         readDecimal(i - 1, i);
/*      */         return;
/*      */       case 7:
/* 3352 */         str2 = null;
/*      */         while (true) {
/* 3354 */           for (int n = i;; i++) {
/* 3355 */             if (arrayOfChar[i] == '\'') {
/* 3356 */               if (str2 == null) {
/* 3357 */                 str2 = this.sqlCommand.substring(n, i); break;
/*      */               } 
/* 3359 */               str2 = str2 + this.sqlCommand.substring(n - 1, i);
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/* 3364 */           if (arrayOfChar[++i] != '\'') {
/*      */             break;
/*      */           }
/* 3367 */           i++;
/*      */         } 
/* 3369 */         this.currentToken = "'";
/* 3370 */         checkLiterals(true);
/* 3371 */         this.currentValue = ValueString.get(StringUtils.fromCacheOrNew(str2), (this.database.getMode()).treatEmptyStringsAsNull);
/*      */         
/* 3373 */         this.parseIndex = i;
/* 3374 */         this.currentTokenType = 5;
/*      */         return;
/*      */       
/*      */       case 9:
/* 3378 */         str2 = null;
/* 3379 */         m = i - 1;
/* 3380 */         while (arrayOfInt[i] == 9) {
/* 3381 */           i++;
/*      */         }
/* 3383 */         str2 = this.sqlCommand.substring(m, i);
/* 3384 */         this.currentToken = "'";
/* 3385 */         checkLiterals(true);
/* 3386 */         this.currentValue = ValueString.get(StringUtils.fromCacheOrNew(str2), (this.database.getMode()).treatEmptyStringsAsNull);
/*      */         
/* 3388 */         this.parseIndex = i;
/* 3389 */         this.currentTokenType = 5;
/*      */         return;
/*      */       
/*      */       case 1:
/* 3393 */         this.currentToken = "";
/* 3394 */         this.currentTokenType = 4;
/* 3395 */         this.parseIndex = i;
/*      */         return;
/*      */     } 
/* 3398 */     throw getSyntaxError();
/*      */   }
/*      */ 
/*      */   
/*      */   private void checkLiterals(boolean paramBoolean) {
/* 3403 */     if (!this.session.getAllowLiterals()) {
/* 3404 */       int i = this.database.getAllowLiterals();
/* 3405 */       if (i == 0 || (paramBoolean && i != 2))
/*      */       {
/* 3407 */         throw DbException.get(90116);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void readHexDecimal(int paramInt1, int paramInt2) {
/* 3413 */     char c, arrayOfChar[] = this.sqlCommandChars;
/*      */     
/*      */     do {
/* 3416 */       c = arrayOfChar[++paramInt2];
/* 3417 */     } while ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F'));
/* 3418 */     this.parseIndex = paramInt2;
/* 3419 */     String str = this.sqlCommand.substring(paramInt1, paramInt2);
/* 3420 */     BigDecimal bigDecimal = new BigDecimal(new BigInteger(str, 16));
/* 3421 */     checkLiterals(false);
/* 3422 */     this.currentValue = (Value)ValueDecimal.get(bigDecimal);
/* 3423 */     this.currentTokenType = 5;
/*      */   }
/*      */   private void readDecimal(int paramInt1, int paramInt2) {
/*      */     BigDecimal bigDecimal;
/* 3427 */     char[] arrayOfChar = this.sqlCommandChars;
/* 3428 */     int[] arrayOfInt = this.characterTypes;
/*      */     
/*      */     while (true) {
/* 3431 */       int i = arrayOfInt[paramInt2];
/* 3432 */       if (i != 8 && i != 2) {
/*      */         break;
/*      */       }
/* 3435 */       paramInt2++;
/*      */     } 
/* 3437 */     boolean bool = false;
/* 3438 */     if (arrayOfChar[paramInt2] == 'E' || arrayOfChar[paramInt2] == 'e') {
/* 3439 */       bool = true;
/* 3440 */       paramInt2++;
/* 3441 */       if (arrayOfChar[paramInt2] == '+' || arrayOfChar[paramInt2] == '-') {
/* 3442 */         paramInt2++;
/*      */       }
/* 3444 */       if (arrayOfInt[paramInt2] != 2) {
/* 3445 */         throw getSyntaxError();
/*      */       }
/* 3447 */       while (arrayOfInt[++paramInt2] == 2);
/*      */     } 
/*      */ 
/*      */     
/* 3451 */     this.parseIndex = paramInt2;
/* 3452 */     String str = this.sqlCommand.substring(paramInt1, paramInt2);
/* 3453 */     checkLiterals(false);
/* 3454 */     if (!bool && str.indexOf('.') < 0) {
/* 3455 */       BigInteger bigInteger = new BigInteger(str);
/* 3456 */       if (bigInteger.compareTo(ValueLong.MAX) <= 0) {
/*      */         
/* 3458 */         if (arrayOfChar[paramInt2] == 'L') {
/* 3459 */           this.parseIndex++;
/*      */         }
/* 3461 */         this.currentValue = (Value)ValueLong.get(bigInteger.longValue());
/* 3462 */         this.currentTokenType = 5;
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/*      */     try {
/* 3468 */       bigDecimal = new BigDecimal(str);
/* 3469 */     } catch (NumberFormatException numberFormatException) {
/* 3470 */       throw DbException.get(22018, numberFormatException, new String[] { str });
/*      */     } 
/* 3472 */     this.currentValue = (Value)ValueDecimal.get(bigDecimal);
/* 3473 */     this.currentTokenType = 5;
/*      */   }
/*      */   
/*      */   public Session getSession() {
/* 3477 */     return this.session;
/*      */   }
/*      */   
/*      */   private void initialize(String paramString) {
/* 3481 */     if (paramString == null) {
/* 3482 */       paramString = "";
/*      */     }
/* 3484 */     this.originalSQL = paramString;
/* 3485 */     this.sqlCommand = paramString;
/* 3486 */     int i = paramString.length() + 1;
/* 3487 */     char[] arrayOfChar = new char[i];
/* 3488 */     int[] arrayOfInt = new int[i];
/* 3489 */     i--;
/* 3490 */     paramString.getChars(0, i, arrayOfChar, 0);
/* 3491 */     boolean bool = false;
/* 3492 */     arrayOfChar[i] = ' ';
/* 3493 */     byte b1 = 0;
/* 3494 */     byte b2 = 0;
/* 3495 */     for (byte b3 = 0; b3 < i; b3++) {
/* 3496 */       char c = arrayOfChar[b3];
/* 3497 */       byte b = 0;
/* 3498 */       switch (c) {
/*      */         case '/':
/* 3500 */           if (arrayOfChar[b3 + 1] == '*') {
/*      */             
/* 3502 */             bool = true;
/* 3503 */             arrayOfChar[b3] = ' ';
/* 3504 */             arrayOfChar[b3 + 1] = ' ';
/* 3505 */             b1 = b3;
/* 3506 */             b3 += 2;
/* 3507 */             checkRunOver(b3, i, b1);
/* 3508 */             while (arrayOfChar[b3] != '*' || arrayOfChar[b3 + 1] != '/') {
/* 3509 */               arrayOfChar[b3++] = ' ';
/* 3510 */               checkRunOver(b3, i, b1);
/*      */             } 
/* 3512 */             arrayOfChar[b3] = ' ';
/* 3513 */             arrayOfChar[b3 + 1] = ' ';
/* 3514 */             b3++; break;
/* 3515 */           }  if (arrayOfChar[b3 + 1] == '/') {
/*      */             
/* 3517 */             bool = true;
/* 3518 */             b1 = b3;
/*      */             while (true) {
/* 3520 */               c = arrayOfChar[b3];
/* 3521 */               if (c == '\n' || c == '\r' || b3 >= i - 1) {
/*      */                 break;
/*      */               }
/* 3524 */               arrayOfChar[b3++] = ' ';
/* 3525 */               checkRunOver(b3, i, b1);
/*      */             }  break;
/*      */           } 
/* 3528 */           b = 5;
/*      */           break;
/*      */         
/*      */         case '-':
/* 3532 */           if (arrayOfChar[b3 + 1] == '-') {
/*      */             
/* 3534 */             bool = true;
/* 3535 */             b1 = b3;
/*      */             while (true) {
/* 3537 */               c = arrayOfChar[b3];
/* 3538 */               if (c == '\n' || c == '\r' || b3 >= i - 1) {
/*      */                 break;
/*      */               }
/* 3541 */               arrayOfChar[b3++] = ' ';
/* 3542 */               checkRunOver(b3, i, b1);
/*      */             }  break;
/*      */           } 
/* 3545 */           b = 5;
/*      */           break;
/*      */         
/*      */         case '$':
/* 3549 */           if (arrayOfChar[b3 + 1] == '$' && (b3 == 0 || arrayOfChar[b3 - 1] <= ' ')) {
/*      */             
/* 3551 */             bool = true;
/* 3552 */             arrayOfChar[b3] = ' ';
/* 3553 */             arrayOfChar[b3 + 1] = ' ';
/* 3554 */             b1 = b3;
/* 3555 */             b3 += 2;
/* 3556 */             checkRunOver(b3, i, b1);
/* 3557 */             while (arrayOfChar[b3] != '$' || arrayOfChar[b3 + 1] != '$') {
/* 3558 */               arrayOfInt[b3++] = 9;
/* 3559 */               checkRunOver(b3, i, b1);
/*      */             } 
/* 3561 */             arrayOfChar[b3] = ' ';
/* 3562 */             arrayOfChar[b3 + 1] = ' ';
/* 3563 */             b3++; break;
/*      */           } 
/* 3565 */           if (b2 == 4 || b2 == 2) {
/*      */             
/* 3567 */             b = 4;
/*      */             break;
/*      */           } 
/* 3570 */           b = 5;
/*      */           break;
/*      */ 
/*      */         
/*      */         case '%':
/*      */         case '(':
/*      */         case ')':
/*      */         case '*':
/*      */         case '+':
/*      */         case ',':
/*      */         case ';':
/*      */         case '?':
/*      */         case '@':
/*      */         case ']':
/*      */         case '{':
/*      */         case '}':
/* 3586 */           b = 5;
/*      */           break;
/*      */         case '!':
/*      */         case '&':
/*      */         case ':':
/*      */         case '<':
/*      */         case '=':
/*      */         case '>':
/*      */         case '|':
/*      */         case '~':
/* 3596 */           b = 6;
/*      */           break;
/*      */         case '.':
/* 3599 */           b = 8;
/*      */           break;
/*      */         case '\'':
/* 3602 */           b = arrayOfInt[b3] = 7;
/* 3603 */           b1 = b3;
/* 3604 */           while (arrayOfChar[++b3] != '\'') {
/* 3605 */             checkRunOver(b3, i, b1);
/*      */           }
/*      */           break;
/*      */         case '[':
/* 3609 */           if ((this.database.getMode()).squareBracketQuotedNames) {
/*      */             
/* 3611 */             arrayOfChar[b3] = '"';
/* 3612 */             bool = true;
/* 3613 */             b = arrayOfInt[b3] = 3;
/* 3614 */             b1 = b3;
/* 3615 */             while (arrayOfChar[++b3] != ']') {
/* 3616 */               checkRunOver(b3, i, b1);
/*      */             }
/* 3618 */             arrayOfChar[b3] = '"'; break;
/*      */           } 
/* 3620 */           b = 5;
/*      */           break;
/*      */ 
/*      */         
/*      */         case '`':
/* 3625 */           arrayOfChar[b3] = '"';
/* 3626 */           bool = true;
/* 3627 */           b = arrayOfInt[b3] = 3;
/* 3628 */           b1 = b3;
/* 3629 */           while (arrayOfChar[++b3] != '`') {
/* 3630 */             checkRunOver(b3, i, b1);
/* 3631 */             c = arrayOfChar[b3];
/* 3632 */             arrayOfChar[b3] = Character.toUpperCase(c);
/*      */           } 
/* 3634 */           arrayOfChar[b3] = '"';
/*      */           break;
/*      */         case '"':
/* 3637 */           b = arrayOfInt[b3] = 3;
/* 3638 */           b1 = b3;
/* 3639 */           while (arrayOfChar[++b3] != '"') {
/* 3640 */             checkRunOver(b3, i, b1);
/*      */           }
/*      */           break;
/*      */         case '_':
/* 3644 */           b = 4;
/*      */           break;
/*      */         case '#':
/* 3647 */           if ((this.database.getMode()).supportPoundSymbolForColumnNames) {
/* 3648 */             b = 4;
/*      */             break;
/*      */           } 
/*      */         default:
/* 3652 */           if (c >= 'a' && c <= 'z') {
/* 3653 */             if (this.identifiersToUpper) {
/* 3654 */               arrayOfChar[b3] = (char)(c - 32);
/* 3655 */               bool = true;
/*      */             } 
/* 3657 */             b = 4; break;
/* 3658 */           }  if (c >= 'A' && c <= 'Z') {
/* 3659 */             b = 4; break;
/* 3660 */           }  if (c >= '0' && c <= '9') {
/* 3661 */             b = 2; break;
/*      */           } 
/* 3663 */           if (c <= ' ' || Character.isSpaceChar(c))
/*      */             break; 
/* 3665 */           if (Character.isJavaIdentifierPart(c)) {
/* 3666 */             b = 4;
/* 3667 */             if (this.identifiersToUpper) {
/* 3668 */               char c1 = Character.toUpperCase(c);
/* 3669 */               if (c1 != c) {
/* 3670 */                 arrayOfChar[b3] = c1;
/* 3671 */                 bool = true;
/*      */               } 
/*      */             }  break;
/*      */           } 
/* 3675 */           b = 5;
/*      */           break;
/*      */       } 
/*      */       
/* 3679 */       arrayOfInt[b3] = b;
/* 3680 */       b2 = b;
/*      */     } 
/* 3682 */     this.sqlCommandChars = arrayOfChar;
/* 3683 */     arrayOfInt[i] = 1;
/* 3684 */     this.characterTypes = arrayOfInt;
/* 3685 */     if (bool) {
/* 3686 */       this.sqlCommand = new String(arrayOfChar);
/*      */     }
/* 3688 */     this.parseIndex = 0;
/*      */   }
/*      */   
/*      */   private void checkRunOver(int paramInt1, int paramInt2, int paramInt3) {
/* 3692 */     if (paramInt1 >= paramInt2) {
/* 3693 */       this.parseIndex = paramInt3;
/* 3694 */       throw getSyntaxError();
/*      */     } 
/*      */   }
/*      */   
/*      */   private int getSpecialType(String paramString) {
/* 3699 */     char c = paramString.charAt(0);
/* 3700 */     if (paramString.length() == 1) {
/* 3701 */       switch (c) {
/*      */         case '$':
/*      */         case '?':
/* 3704 */           return 3;
/*      */         case '@':
/* 3706 */           return 12;
/*      */         case '+':
/* 3708 */           return 14;
/*      */         case '-':
/* 3710 */           return 13;
/*      */         case '%':
/*      */         case '*':
/*      */         case ',':
/*      */         case '/':
/*      */         case ':':
/*      */         case ';':
/*      */         case '[':
/*      */         case ']':
/*      */         case '{':
/*      */         case '}':
/*      */         case '~':
/* 3722 */           return 1;
/*      */         case '(':
/* 3724 */           return 16;
/*      */         case ')':
/* 3726 */           return 17;
/*      */         case '<':
/* 3728 */           return 9;
/*      */         case '>':
/* 3730 */           return 8;
/*      */         case '=':
/* 3732 */           return 6;
/*      */       } 
/*      */ 
/*      */     
/* 3736 */     } else if (paramString.length() == 2) {
/* 3737 */       switch (c) {
/*      */         case ':':
/* 3739 */           if ("::".equals(paramString))
/* 3740 */             return 1; 
/* 3741 */           if (":=".equals(paramString)) {
/* 3742 */             return 1;
/*      */           }
/*      */           break;
/*      */         case '>':
/* 3746 */           if (">=".equals(paramString)) {
/* 3747 */             return 7;
/*      */           }
/*      */           break;
/*      */         case '<':
/* 3751 */           if ("<=".equals(paramString))
/* 3752 */             return 10; 
/* 3753 */           if ("<>".equals(paramString)) {
/* 3754 */             return 11;
/*      */           }
/*      */           break;
/*      */         case '!':
/* 3758 */           if ("!=".equals(paramString))
/* 3759 */             return 11; 
/* 3760 */           if ("!~".equals(paramString)) {
/* 3761 */             return 1;
/*      */           }
/*      */           break;
/*      */         case '|':
/* 3765 */           if ("||".equals(paramString)) {
/* 3766 */             return 15;
/*      */           }
/*      */           break;
/*      */         case '&':
/* 3770 */           if ("&&".equals(paramString)) {
/* 3771 */             return 25;
/*      */           }
/*      */           break;
/*      */       } 
/*      */     } 
/* 3776 */     throw getSyntaxError();
/*      */   }
/*      */   
/*      */   private int getTokenType(String paramString) {
/* 3780 */     int i = paramString.length();
/* 3781 */     if (i == 0) {
/* 3782 */       throw getSyntaxError();
/*      */     }
/* 3784 */     if (!this.identifiersToUpper)
/*      */     {
/* 3786 */       paramString = StringUtils.toUpperEnglish(paramString);
/*      */     }
/* 3788 */     return getSaveTokenType(paramString, (this.database.getMode()).supportOffsetFetch);
/*      */   }
/*      */   
/*      */   private boolean isKeyword(String paramString) {
/* 3792 */     if (!this.identifiersToUpper)
/*      */     {
/* 3794 */       paramString = StringUtils.toUpperEnglish(paramString);
/*      */     }
/* 3796 */     return isKeyword(paramString, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isKeyword(String paramString, boolean paramBoolean) {
/* 3807 */     if (paramString == null || paramString.length() == 0) {
/* 3808 */       return false;
/*      */     }
/* 3810 */     return (getSaveTokenType(paramString, paramBoolean) != 2);
/*      */   }
/*      */   
/*      */   private static int getSaveTokenType(String paramString, boolean paramBoolean) {
/* 3814 */     switch (paramString.charAt(0)) {
/*      */       case 'C':
/* 3816 */         if (paramString.equals("CURRENT_TIMESTAMP"))
/* 3817 */           return 21; 
/* 3818 */         if (paramString.equals("CURRENT_TIME"))
/* 3819 */           return 23; 
/* 3820 */         if (paramString.equals("CURRENT_DATE")) {
/* 3821 */           return 22;
/*      */         }
/* 3823 */         return getKeywordOrIdentifier(paramString, "CROSS", 1);
/*      */       case 'D':
/* 3825 */         return getKeywordOrIdentifier(paramString, "DISTINCT", 1);
/*      */       case 'E':
/* 3827 */         if ("EXCEPT".equals(paramString)) {
/* 3828 */           return 1;
/*      */         }
/* 3830 */         return getKeywordOrIdentifier(paramString, "EXISTS", 1);
/*      */       case 'F':
/* 3832 */         if ("FROM".equals(paramString))
/* 3833 */           return 1; 
/* 3834 */         if ("FOR".equals(paramString))
/* 3835 */           return 1; 
/* 3836 */         if ("FULL".equals(paramString))
/* 3837 */           return 1; 
/* 3838 */         if (paramBoolean && "FETCH".equals(paramString)) {
/* 3839 */           return 1;
/*      */         }
/* 3841 */         return getKeywordOrIdentifier(paramString, "FALSE", 20);
/*      */       case 'G':
/* 3843 */         return getKeywordOrIdentifier(paramString, "GROUP", 1);
/*      */       case 'H':
/* 3845 */         return getKeywordOrIdentifier(paramString, "HAVING", 1);
/*      */       case 'I':
/* 3847 */         if ("INNER".equals(paramString))
/* 3848 */           return 1; 
/* 3849 */         if ("INTERSECT".equals(paramString)) {
/* 3850 */           return 1;
/*      */         }
/* 3852 */         return getKeywordOrIdentifier(paramString, "IS", 1);
/*      */       case 'J':
/* 3854 */         return getKeywordOrIdentifier(paramString, "JOIN", 1);
/*      */       case 'L':
/* 3856 */         if ("LIMIT".equals(paramString)) {
/* 3857 */           return 1;
/*      */         }
/* 3859 */         return getKeywordOrIdentifier(paramString, "LIKE", 1);
/*      */       case 'M':
/* 3861 */         return getKeywordOrIdentifier(paramString, "MINUS", 1);
/*      */       case 'N':
/* 3863 */         if ("NOT".equals(paramString))
/* 3864 */           return 1; 
/* 3865 */         if ("NATURAL".equals(paramString)) {
/* 3866 */           return 1;
/*      */         }
/* 3868 */         return getKeywordOrIdentifier(paramString, "NULL", 18);
/*      */       case 'O':
/* 3870 */         if ("ON".equals(paramString))
/* 3871 */           return 1; 
/* 3872 */         if (paramBoolean && "OFFSET".equals(paramString)) {
/* 3873 */           return 1;
/*      */         }
/* 3875 */         return getKeywordOrIdentifier(paramString, "ORDER", 1);
/*      */       case 'P':
/* 3877 */         return getKeywordOrIdentifier(paramString, "PRIMARY", 1);
/*      */       case 'R':
/* 3879 */         return getKeywordOrIdentifier(paramString, "ROWNUM", 24);
/*      */       case 'S':
/* 3881 */         if (paramString.equals("SYSTIMESTAMP"))
/* 3882 */           return 21; 
/* 3883 */         if (paramString.equals("SYSTIME"))
/* 3884 */           return 23; 
/* 3885 */         if (paramString.equals("SYSDATE")) {
/* 3886 */           return 21;
/*      */         }
/* 3888 */         return getKeywordOrIdentifier(paramString, "SELECT", 1);
/*      */       case 'T':
/* 3890 */         if ("TODAY".equals(paramString)) {
/* 3891 */           return 22;
/*      */         }
/* 3893 */         return getKeywordOrIdentifier(paramString, "TRUE", 19);
/*      */       case 'U':
/* 3895 */         if ("UNIQUE".equals(paramString)) {
/* 3896 */           return 1;
/*      */         }
/* 3898 */         return getKeywordOrIdentifier(paramString, "UNION", 1);
/*      */       case 'W':
/* 3900 */         if ("WITH".equals(paramString)) {
/* 3901 */           return 1;
/*      */         }
/* 3903 */         return getKeywordOrIdentifier(paramString, "WHERE", 1);
/*      */     } 
/* 3905 */     return 2;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static int getKeywordOrIdentifier(String paramString1, String paramString2, int paramInt) {
/* 3911 */     if (paramString1.equals(paramString2)) {
/* 3912 */       return paramInt;
/*      */     }
/* 3914 */     return 2;
/*      */   }
/*      */ 
/*      */   
/*      */   private Column parseColumnForTable(String paramString, boolean paramBoolean) {
/*      */     Column column;
/* 3920 */     boolean bool = false;
/* 3921 */     if (readIf("IDENTITY") || readIf("BIGSERIAL")) {
/* 3922 */       column = new Column(paramString, 5);
/* 3923 */       column.setOriginalSQL("IDENTITY");
/* 3924 */       parseAutoIncrement(column);
/*      */       
/* 3926 */       if (!(this.database.getMode()).serialColumnIsNotPK) {
/* 3927 */         column.setPrimaryKey(true);
/*      */       }
/* 3929 */     } else if (readIf("SERIAL")) {
/* 3930 */       column = new Column(paramString, 4);
/* 3931 */       column.setOriginalSQL("SERIAL");
/* 3932 */       parseAutoIncrement(column);
/*      */       
/* 3934 */       if (!(this.database.getMode()).serialColumnIsNotPK) {
/* 3935 */         column.setPrimaryKey(true);
/*      */       }
/*      */     } else {
/* 3938 */       column = parseColumnWithType(paramString);
/*      */     } 
/* 3940 */     if (readIf("NOT")) {
/* 3941 */       read("NULL");
/* 3942 */       column.setNullable(false);
/* 3943 */     } else if (readIf("NULL")) {
/* 3944 */       column.setNullable(true);
/*      */     } else {
/*      */       
/* 3947 */       column.setNullable(paramBoolean & column.isNullable());
/*      */     } 
/* 3949 */     if (readIf("AS")) {
/* 3950 */       if (bool) {
/* 3951 */         getSyntaxError();
/*      */       }
/* 3953 */       Expression expression = readExpression();
/* 3954 */       column.setComputedExpression(expression);
/* 3955 */     } else if (readIf("DEFAULT")) {
/* 3956 */       Expression expression = readExpression();
/* 3957 */       column.setDefaultExpression(this.session, expression);
/* 3958 */     } else if (readIf("GENERATED")) {
/* 3959 */       if (!readIf("ALWAYS")) {
/* 3960 */         read("BY");
/* 3961 */         read("DEFAULT");
/*      */       } 
/* 3963 */       read("AS");
/* 3964 */       read("IDENTITY");
/* 3965 */       long l1 = 1L, l2 = 1L;
/* 3966 */       if (readIf("(")) {
/* 3967 */         read("START");
/* 3968 */         readIf("WITH");
/* 3969 */         l1 = readLong();
/* 3970 */         readIf(",");
/* 3971 */         if (readIf("INCREMENT")) {
/* 3972 */           readIf("BY");
/* 3973 */           l2 = readLong();
/*      */         } 
/* 3975 */         read(")");
/*      */       } 
/* 3977 */       column.setPrimaryKey(true);
/* 3978 */       column.setAutoIncrement(true, l1, l2);
/*      */     } 
/* 3980 */     if (readIf("NOT")) {
/* 3981 */       read("NULL");
/* 3982 */       column.setNullable(false);
/*      */     } else {
/* 3984 */       readIf("NULL");
/*      */     } 
/* 3986 */     if (readIf("AUTO_INCREMENT") || readIf("BIGSERIAL") || readIf("SERIAL")) {
/* 3987 */       parseAutoIncrement(column);
/* 3988 */       if (readIf("NOT")) {
/* 3989 */         read("NULL");
/*      */       }
/* 3991 */     } else if (readIf("IDENTITY")) {
/* 3992 */       parseAutoIncrement(column);
/* 3993 */       column.setPrimaryKey(true);
/* 3994 */       if (readIf("NOT")) {
/* 3995 */         read("NULL");
/*      */       }
/*      */     } 
/* 3998 */     if (readIf("NULL_TO_DEFAULT")) {
/* 3999 */       column.setConvertNullToDefault(true);
/*      */     }
/* 4001 */     if (readIf("SEQUENCE")) {
/* 4002 */       Sequence sequence = readSequence();
/* 4003 */       column.setSequence(sequence);
/*      */     } 
/* 4005 */     if (readIf("SELECTIVITY")) {
/* 4006 */       int i = readPositiveInt();
/* 4007 */       column.setSelectivity(i);
/*      */     } 
/* 4009 */     String str = readCommentIf();
/* 4010 */     if (str != null) {
/* 4011 */       column.setComment(str);
/*      */     }
/* 4013 */     return column;
/*      */   }
/*      */   
/*      */   private void parseAutoIncrement(Column paramColumn) {
/* 4017 */     long l1 = 1L, l2 = 1L;
/* 4018 */     if (readIf("(")) {
/* 4019 */       l1 = readLong();
/* 4020 */       if (readIf(",")) {
/* 4021 */         l2 = readLong();
/*      */       }
/* 4023 */       read(")");
/*      */     } 
/* 4025 */     paramColumn.setAutoIncrement(true, l1, l2);
/*      */   }
/*      */   
/*      */   private String readCommentIf() {
/* 4029 */     if (readIf("COMMENT")) {
/* 4030 */       readIf("IS");
/* 4031 */       return readString();
/*      */     } 
/* 4033 */     return null;
/*      */   }
/*      */   private Column parseColumnWithType(String paramString) {
/*      */     DataType dataType;
/* 4037 */     String str1 = this.currentToken;
/* 4038 */     boolean bool = false;
/* 4039 */     if (readIf("LONG")) {
/* 4040 */       if (readIf("RAW")) {
/* 4041 */         str1 = str1 + " RAW";
/*      */       }
/* 4043 */     } else if (readIf("DOUBLE")) {
/* 4044 */       if (readIf("PRECISION")) {
/* 4045 */         str1 = str1 + " PRECISION";
/*      */       }
/* 4047 */     } else if (readIf("CHARACTER")) {
/* 4048 */       if (readIf("VARYING")) {
/* 4049 */         str1 = str1 + " VARYING";
/*      */       }
/* 4051 */     } else if (readIf("TIMESTAMP")) {
/* 4052 */       if (readIf("WITH")) {
/* 4053 */         read("TIMEZONE");
/* 4054 */         str1 = str1 + " WITH TIMEZONE";
/*      */       } 
/*      */     } else {
/* 4057 */       bool = true;
/*      */     } 
/* 4059 */     long l = -1L;
/* 4060 */     int i = -1;
/* 4061 */     int j = -1;
/* 4062 */     String str2 = null;
/* 4063 */     Column column1 = null;
/*      */     
/* 4065 */     if (!this.identifiersToUpper) {
/* 4066 */       str1 = StringUtils.toUpperEnglish(str1);
/*      */     }
/* 4068 */     UserDataType userDataType = this.database.findUserDataType(str1);
/* 4069 */     if (userDataType != null) {
/* 4070 */       column1 = userDataType.getColumn();
/* 4071 */       dataType = DataType.getDataType(column1.getType());
/* 4072 */       str2 = column1.getComment();
/* 4073 */       str1 = column1.getOriginalSQL();
/* 4074 */       l = column1.getPrecision();
/* 4075 */       i = column1.getDisplaySize();
/* 4076 */       j = column1.getScale();
/*      */     } else {
/* 4078 */       dataType = DataType.getTypeByName(str1);
/* 4079 */       if (dataType == null) {
/* 4080 */         throw DbException.get(50004, this.currentToken);
/*      */       }
/*      */     } 
/*      */     
/* 4084 */     if (this.database.getIgnoreCase() && dataType.type == 13 && !equalsToken("VARCHAR_CASESENSITIVE", str1)) {
/*      */       
/* 4086 */       str1 = "VARCHAR_IGNORECASE";
/* 4087 */       dataType = DataType.getTypeByName(str1);
/*      */     } 
/* 4089 */     if (bool) {
/* 4090 */       read();
/*      */     }
/* 4092 */     l = (l == -1L) ? dataType.defaultPrecision : l;
/* 4093 */     i = (i == -1) ? dataType.defaultDisplaySize : i;
/*      */     
/* 4095 */     j = (j == -1) ? dataType.defaultScale : j;
/* 4096 */     if (dataType.supportsPrecision || dataType.supportsScale) {
/* 4097 */       if (readIf("(")) {
/* 4098 */         if (!readIf("MAX")) {
/* 4099 */           long l1 = readLong();
/* 4100 */           if (readIf("K")) {
/* 4101 */             l1 *= 1024L;
/* 4102 */           } else if (readIf("M")) {
/* 4103 */             l1 *= 1048576L;
/* 4104 */           } else if (readIf("G")) {
/* 4105 */             l1 *= 1073741824L;
/*      */           } 
/* 4107 */           if (l1 > Long.MAX_VALUE) {
/* 4108 */             l1 = Long.MAX_VALUE;
/*      */           }
/* 4110 */           str1 = str1 + "(" + l1;
/*      */           
/* 4112 */           readIf("CHAR");
/* 4113 */           if (dataType.supportsScale) {
/* 4114 */             if (readIf(",")) {
/* 4115 */               j = readInt();
/* 4116 */               str1 = str1 + ", " + j;
/*      */ 
/*      */             
/*      */             }
/* 4120 */             else if (dataType.type == 11) {
/* 4121 */               j = MathUtils.convertLongToInt(l1);
/* 4122 */               l1 = l;
/*      */             } else {
/* 4124 */               j = 0;
/*      */             } 
/*      */           }
/*      */           
/* 4128 */           l = l1;
/* 4129 */           i = MathUtils.convertLongToInt(l);
/* 4130 */           str1 = str1 + ")";
/*      */         } 
/* 4132 */         read(")");
/*      */       } 
/* 4134 */     } else if (readIf("(")) {
/*      */ 
/*      */       
/* 4137 */       readPositiveInt();
/* 4138 */       read(")");
/*      */     } 
/* 4140 */     if (readIf("FOR")) {
/* 4141 */       read("BIT");
/* 4142 */       read("DATA");
/* 4143 */       if (dataType.type == 13) {
/* 4144 */         dataType = DataType.getTypeByName("BINARY");
/*      */       }
/*      */     } 
/*      */     
/* 4148 */     readIf("UNSIGNED");
/* 4149 */     int k = dataType.type;
/* 4150 */     if (j > l) {
/* 4151 */       throw DbException.get(90051, new String[] { Integer.toString(j), Long.toString(l) });
/*      */     }
/*      */     
/* 4154 */     Column column2 = new Column(paramString, k, l, j, i);
/*      */     
/* 4156 */     if (column1 != null) {
/* 4157 */       column2.setNullable(column1.isNullable());
/* 4158 */       column2.setDefaultExpression(this.session, column1.getDefaultExpression());
/*      */       
/* 4160 */       int m = column1.getSelectivity();
/* 4161 */       if (m != 50) {
/* 4162 */         column2.setSelectivity(m);
/*      */       }
/* 4164 */       Expression expression = column1.getCheckConstraint(this.session, paramString);
/*      */       
/* 4166 */       column2.addCheckConstraint(this.session, expression);
/*      */     } 
/* 4168 */     column2.setComment(str2);
/* 4169 */     column2.setOriginalSQL(str1);
/* 4170 */     return column2;
/*      */   }
/*      */   
/*      */   private Prepared parseCreate() {
/* 4174 */     boolean bool1 = false;
/* 4175 */     if (readIf("OR")) {
/* 4176 */       read("REPLACE");
/* 4177 */       bool1 = true;
/*      */     } 
/* 4179 */     boolean bool2 = readIf("FORCE");
/* 4180 */     if (readIf("VIEW"))
/* 4181 */       return (Prepared)parseCreateView(bool2, bool1); 
/* 4182 */     if (readIf("ALIAS"))
/* 4183 */       return (Prepared)parseCreateFunctionAlias(bool2); 
/* 4184 */     if (readIf("SEQUENCE"))
/* 4185 */       return (Prepared)parseCreateSequence(); 
/* 4186 */     if (readIf("USER"))
/* 4187 */       return (Prepared)parseCreateUser(); 
/* 4188 */     if (readIf("TRIGGER"))
/* 4189 */       return (Prepared)parseCreateTrigger(bool2); 
/* 4190 */     if (readIf("ROLE"))
/* 4191 */       return (Prepared)parseCreateRole(); 
/* 4192 */     if (readIf("SCHEMA"))
/* 4193 */       return (Prepared)parseCreateSchema(); 
/* 4194 */     if (readIf("CONSTANT"))
/* 4195 */       return (Prepared)parseCreateConstant(); 
/* 4196 */     if (readIf("DOMAIN"))
/* 4197 */       return (Prepared)parseCreateUserDataType(); 
/* 4198 */     if (readIf("TYPE"))
/* 4199 */       return (Prepared)parseCreateUserDataType(); 
/* 4200 */     if (readIf("DATATYPE"))
/* 4201 */       return (Prepared)parseCreateUserDataType(); 
/* 4202 */     if (readIf("AGGREGATE"))
/* 4203 */       return (Prepared)parseCreateAggregate(bool2); 
/* 4204 */     if (readIf("LINKED")) {
/* 4205 */       return (Prepared)parseCreateLinkedTable(false, false, bool2);
/*      */     }
/*      */     
/* 4208 */     boolean bool3 = false, bool4 = false;
/* 4209 */     if (readIf("MEMORY")) {
/* 4210 */       bool3 = true;
/* 4211 */     } else if (readIf("CACHED")) {
/* 4212 */       bool4 = true;
/*      */     } 
/* 4214 */     if (readIf("LOCAL")) {
/* 4215 */       read("TEMPORARY");
/* 4216 */       if (readIf("LINKED")) {
/* 4217 */         return (Prepared)parseCreateLinkedTable(true, false, bool2);
/*      */       }
/* 4219 */       read("TABLE");
/* 4220 */       return (Prepared)parseCreateTable(true, false, bool4);
/* 4221 */     }  if (readIf("GLOBAL")) {
/* 4222 */       read("TEMPORARY");
/* 4223 */       if (readIf("LINKED")) {
/* 4224 */         return (Prepared)parseCreateLinkedTable(true, true, bool2);
/*      */       }
/* 4226 */       read("TABLE");
/* 4227 */       return (Prepared)parseCreateTable(true, true, bool4);
/* 4228 */     }  if (readIf("TEMP") || readIf("TEMPORARY")) {
/* 4229 */       if (readIf("LINKED")) {
/* 4230 */         return (Prepared)parseCreateLinkedTable(true, true, bool2);
/*      */       }
/* 4232 */       read("TABLE");
/* 4233 */       return (Prepared)parseCreateTable(true, true, bool4);
/* 4234 */     }  if (readIf("TABLE")) {
/* 4235 */       if (!bool4 && !bool3) {
/* 4236 */         bool4 = (this.database.getDefaultTableType() == 0) ? true : false;
/*      */       }
/* 4238 */       return (Prepared)parseCreateTable(false, false, bool4);
/*      */     } 
/* 4240 */     boolean bool5 = false, bool6 = false;
/* 4241 */     boolean bool7 = false, bool8 = false;
/* 4242 */     String str1 = null;
/* 4243 */     Schema schema = null;
/* 4244 */     boolean bool9 = false;
/* 4245 */     if (readIf("PRIMARY")) {
/* 4246 */       read("KEY");
/* 4247 */       if (readIf("HASH")) {
/* 4248 */         bool5 = true;
/*      */       }
/* 4250 */       bool6 = true;
/* 4251 */       if (!isToken("ON")) {
/* 4252 */         bool9 = readIfNotExists();
/* 4253 */         str1 = readIdentifierWithSchema(null);
/* 4254 */         schema = getSchema();
/*      */       } 
/*      */     } else {
/* 4257 */       if (readIf("UNIQUE")) {
/* 4258 */         bool7 = true;
/*      */       }
/* 4260 */       if (readIf("HASH")) {
/* 4261 */         bool5 = true;
/*      */       }
/* 4263 */       if (readIf("SPATIAL")) {
/* 4264 */         bool8 = true;
/*      */       }
/* 4266 */       if (readIf("INDEX")) {
/* 4267 */         if (!isToken("ON")) {
/* 4268 */           bool9 = readIfNotExists();
/* 4269 */           str1 = readIdentifierWithSchema(null);
/* 4270 */           schema = getSchema();
/*      */         } 
/*      */       } else {
/* 4273 */         throw getSyntaxError();
/*      */       } 
/*      */     } 
/* 4276 */     read("ON");
/* 4277 */     String str2 = readIdentifierWithSchema();
/* 4278 */     checkSchema(schema);
/* 4279 */     CreateIndex createIndex = new CreateIndex(this.session, getSchema());
/* 4280 */     createIndex.setIfNotExists(bool9);
/* 4281 */     createIndex.setPrimaryKey(bool6);
/* 4282 */     createIndex.setTableName(str2);
/* 4283 */     createIndex.setUnique(bool7);
/* 4284 */     createIndex.setIndexName(str1);
/* 4285 */     createIndex.setComment(readCommentIf());
/* 4286 */     read("(");
/* 4287 */     createIndex.setIndexColumns(parseIndexColumnList());
/*      */     
/* 4289 */     if (readIf("USING")) {
/* 4290 */       if (bool5) {
/* 4291 */         throw getSyntaxError();
/*      */       }
/* 4293 */       if (bool8) {
/* 4294 */         throw getSyntaxError();
/*      */       }
/* 4296 */       if (!readIf("BTREE"))
/*      */       {
/* 4298 */         if (readIf("RTREE")) {
/* 4299 */           bool8 = true;
/* 4300 */         } else if (readIf("HASH")) {
/* 4301 */           bool5 = true;
/*      */         } else {
/* 4303 */           throw getSyntaxError();
/*      */         } 
/*      */       }
/*      */     } 
/* 4307 */     createIndex.setHash(bool5);
/* 4308 */     createIndex.setSpatial(bool8);
/* 4309 */     return (Prepared)createIndex;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean addRoleOrRight(GrantRevoke paramGrantRevoke) {
/* 4317 */     if (readIf("SELECT")) {
/* 4318 */       paramGrantRevoke.addRight(1);
/* 4319 */       return true;
/* 4320 */     }  if (readIf("DELETE")) {
/* 4321 */       paramGrantRevoke.addRight(2);
/* 4322 */       return true;
/* 4323 */     }  if (readIf("INSERT")) {
/* 4324 */       paramGrantRevoke.addRight(4);
/* 4325 */       return true;
/* 4326 */     }  if (readIf("UPDATE")) {
/* 4327 */       paramGrantRevoke.addRight(8);
/* 4328 */       return true;
/* 4329 */     }  if (readIf("ALL")) {
/* 4330 */       paramGrantRevoke.addRight(15);
/* 4331 */       return true;
/* 4332 */     }  if (readIf("ALTER")) {
/* 4333 */       read("ANY");
/* 4334 */       read("SCHEMA");
/* 4335 */       paramGrantRevoke.addRight(16);
/* 4336 */       paramGrantRevoke.addTable(null);
/* 4337 */       return false;
/* 4338 */     }  if (readIf("CONNECT"))
/*      */     {
/* 4340 */       return true; } 
/* 4341 */     if (readIf("RESOURCE"))
/*      */     {
/* 4343 */       return true;
/*      */     }
/* 4345 */     paramGrantRevoke.addRoleName(readUniqueIdentifier());
/* 4346 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private GrantRevoke parseGrantRevoke(int paramInt) {
/* 4351 */     GrantRevoke grantRevoke = new GrantRevoke(this.session);
/* 4352 */     grantRevoke.setOperationType(paramInt);
/* 4353 */     boolean bool = addRoleOrRight(grantRevoke);
/* 4354 */     while (readIf(",")) {
/* 4355 */       addRoleOrRight(grantRevoke);
/* 4356 */       if (grantRevoke.isRightMode() && grantRevoke.isRoleMode()) {
/* 4357 */         throw DbException.get(90072);
/*      */       }
/*      */     } 
/*      */     
/* 4361 */     if (bool && 
/* 4362 */       readIf("ON")) {
/* 4363 */       if (readIf("SCHEMA")) {
/* 4364 */         Schema schema = this.database.getSchema(readAliasIdentifier());
/* 4365 */         grantRevoke.setSchema(schema);
/*      */       } else {
/*      */         do {
/* 4368 */           Table table = readTableOrView();
/* 4369 */           grantRevoke.addTable(table);
/* 4370 */         } while (readIf(","));
/*      */       } 
/*      */     }
/*      */     
/* 4374 */     if (paramInt == 49) {
/* 4375 */       read("TO");
/*      */     } else {
/* 4377 */       read("FROM");
/*      */     } 
/* 4379 */     grantRevoke.setGranteeName(readUniqueIdentifier());
/* 4380 */     return grantRevoke;
/*      */   }
/*      */   
/*      */   private Select parseValues() {
/* 4384 */     Select select = new Select(this.session);
/* 4385 */     this.currentSelect = select;
/* 4386 */     TableFilter tableFilter = parseValuesTable(0);
/* 4387 */     ArrayList<Wildcard> arrayList = New.arrayList();
/* 4388 */     arrayList.add(new Wildcard(null, null));
/* 4389 */     select.setExpressions(arrayList);
/* 4390 */     select.addTableFilter(tableFilter, true);
/* 4391 */     select.init();
/* 4392 */     return select;
/*      */   }
/*      */   
/*      */   private TableFilter parseValuesTable(int paramInt) {
/* 4396 */     Schema schema = this.database.getSchema("PUBLIC");
/* 4397 */     TableFunction tableFunction = (TableFunction)Function.getFunction(this.database, "TABLE");
/*      */     
/* 4399 */     ArrayList<Column> arrayList = New.arrayList();
/* 4400 */     ArrayList<ArrayList<Expression>> arrayList1 = New.arrayList();
/*      */     while (true) {
/* 4402 */       int i = 0;
/* 4403 */       ArrayList<Expression> arrayList2 = New.arrayList();
/* 4404 */       boolean bool = readIf("(");
/*      */       do {
/* 4406 */         Expression expression = readExpression();
/* 4407 */         expression = expression.optimize(this.session);
/* 4408 */         int j = expression.getType();
/*      */ 
/*      */ 
/*      */         
/* 4412 */         String str = "C" + (i + 1);
/* 4413 */         if (arrayList1.size() == 0) {
/* 4414 */           if (j == -1) {
/* 4415 */             j = 13;
/*      */           }
/* 4417 */           DataType dataType = DataType.getDataType(j);
/* 4418 */           long l1 = dataType.defaultPrecision;
/* 4419 */           int n = dataType.defaultScale;
/* 4420 */           int i1 = dataType.defaultDisplaySize;
/* 4421 */           Column column = new Column(str, j, l1, n, i1);
/*      */           
/* 4423 */           arrayList.add(column);
/*      */         } 
/* 4425 */         long l = expression.getPrecision();
/* 4426 */         int k = expression.getScale();
/* 4427 */         int m = expression.getDisplaySize();
/* 4428 */         if (i >= arrayList.size()) {
/* 4429 */           throw DbException.get(21002);
/*      */         }
/*      */         
/* 4432 */         Column column2 = arrayList.get(i);
/* 4433 */         j = Value.getHigherOrder(column2.getType(), j);
/* 4434 */         l = Math.max(column2.getPrecision(), l);
/* 4435 */         k = Math.max(column2.getScale(), k);
/* 4436 */         m = Math.max(column2.getDisplaySize(), m);
/* 4437 */         Column column1 = new Column(str, j, l, k, m);
/* 4438 */         arrayList.set(i, column1);
/* 4439 */         arrayList2.add(expression);
/* 4440 */         i++;
/* 4441 */       } while (bool && readIf(","));
/* 4442 */       if (bool) {
/* 4443 */         read(")");
/*      */       }
/* 4445 */       arrayList1.add(arrayList2);
/* 4446 */       if (!readIf(",")) {
/* 4447 */         i = arrayList.size();
/* 4448 */         int j = arrayList1.size();
/* 4449 */         for (bool = false; bool < j; bool++) {
/* 4450 */           if (((ArrayList)arrayList1.get(bool)).size() != i) {
/* 4451 */             throw DbException.get(21002);
/*      */           }
/*      */         } 
/* 4454 */         for (bool = false; bool < i; bool++) {
/* 4455 */           Column column = arrayList.get(bool);
/* 4456 */           if (column.getType() == -1) {
/* 4457 */             column = new Column(column.getName(), 13, 0L, 0, 0);
/* 4458 */             arrayList.set(bool, column);
/*      */           } 
/* 4460 */           Expression[] arrayOfExpression = new Expression[j];
/* 4461 */           for (byte b = 0; b < j; b++) {
/* 4462 */             arrayOfExpression[b] = ((ArrayList<Expression>)arrayList1.get(b)).get(bool);
/*      */           }
/* 4464 */           ExpressionList expressionList = new ExpressionList(arrayOfExpression);
/* 4465 */           tableFunction.setParameter(bool, (Expression)expressionList);
/*      */         } 
/* 4467 */         tableFunction.setColumns(arrayList);
/* 4468 */         tableFunction.doneWithParameters();
/* 4469 */         FunctionTable functionTable = new FunctionTable(schema, this.session, (Expression)tableFunction, (FunctionCall)tableFunction);
/* 4470 */         return new TableFilter(this.session, (Table)functionTable, null, this.rightsChecked, this.currentSelect, paramInt);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private Call parseCall() {
/* 4476 */     Call call = new Call(this.session);
/* 4477 */     this.currentPrepared = (Prepared)call;
/* 4478 */     call.setExpression(readExpression());
/* 4479 */     return call;
/*      */   }
/*      */   
/*      */   private CreateRole parseCreateRole() {
/* 4483 */     CreateRole createRole = new CreateRole(this.session);
/* 4484 */     createRole.setIfNotExists(readIfNotExists());
/* 4485 */     createRole.setRoleName(readUniqueIdentifier());
/* 4486 */     return createRole;
/*      */   }
/*      */   
/*      */   private CreateSchema parseCreateSchema() {
/* 4490 */     CreateSchema createSchema = new CreateSchema(this.session);
/* 4491 */     createSchema.setIfNotExists(readIfNotExists());
/* 4492 */     createSchema.setSchemaName(readUniqueIdentifier());
/* 4493 */     if (readIf("AUTHORIZATION")) {
/* 4494 */       createSchema.setAuthorization(readUniqueIdentifier());
/*      */     } else {
/* 4496 */       createSchema.setAuthorization(this.session.getUser().getName());
/*      */     } 
/* 4498 */     return createSchema;
/*      */   }
/*      */   
/*      */   private CreateSequence parseCreateSequence() {
/* 4502 */     boolean bool = readIfNotExists();
/* 4503 */     String str = readIdentifierWithSchema();
/* 4504 */     CreateSequence createSequence = new CreateSequence(this.session, getSchema());
/* 4505 */     createSequence.setIfNotExists(bool);
/* 4506 */     createSequence.setSequenceName(str);
/*      */     while (true) {
/* 4508 */       while (readIf("START")) {
/* 4509 */         readIf("WITH");
/* 4510 */         createSequence.setStartWith(readExpression());
/* 4511 */       }  if (readIf("INCREMENT")) {
/* 4512 */         readIf("BY");
/* 4513 */         createSequence.setIncrement(readExpression()); continue;
/* 4514 */       }  if (readIf("MINVALUE")) {
/* 4515 */         createSequence.setMinValue(readExpression()); continue;
/* 4516 */       }  if (readIf("NOMINVALUE")) {
/* 4517 */         createSequence.setMinValue(null); continue;
/* 4518 */       }  if (readIf("MAXVALUE")) {
/* 4519 */         createSequence.setMaxValue(readExpression()); continue;
/* 4520 */       }  if (readIf("NOMAXVALUE")) {
/* 4521 */         createSequence.setMaxValue(null); continue;
/* 4522 */       }  if (readIf("CYCLE")) {
/* 4523 */         createSequence.setCycle(true); continue;
/* 4524 */       }  if (readIf("NOCYCLE")) {
/* 4525 */         createSequence.setCycle(false); continue;
/* 4526 */       }  if (readIf("NO")) {
/* 4527 */         if (readIf("MINVALUE")) {
/* 4528 */           createSequence.setMinValue(null); continue;
/* 4529 */         }  if (readIf("MAXVALUE")) {
/* 4530 */           createSequence.setMaxValue(null); continue;
/* 4531 */         }  if (readIf("CYCLE")) {
/* 4532 */           createSequence.setCycle(false); continue;
/* 4533 */         }  if (readIf("CACHE")) {
/* 4534 */           createSequence.setCacheSize((Expression)ValueExpression.get((Value)ValueLong.get(1L))); continue;
/*      */         } 
/*      */         break;
/*      */       } 
/* 4538 */       if (readIf("CACHE")) {
/* 4539 */         createSequence.setCacheSize(readExpression()); continue;
/* 4540 */       }  if (readIf("NOCACHE")) {
/* 4541 */         createSequence.setCacheSize((Expression)ValueExpression.get((Value)ValueLong.get(1L))); continue;
/* 4542 */       }  if (readIf("BELONGS_TO_TABLE")) {
/* 4543 */         createSequence.setBelongsToTable(true);
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/* 4548 */     return createSequence;
/*      */   }
/*      */   
/*      */   private boolean readIfNotExists() {
/* 4552 */     if (readIf("IF")) {
/* 4553 */       read("NOT");
/* 4554 */       read("EXISTS");
/* 4555 */       return true;
/*      */     } 
/* 4557 */     return false;
/*      */   }
/*      */   
/*      */   private CreateConstant parseCreateConstant() {
/* 4561 */     boolean bool = readIfNotExists();
/* 4562 */     String str = readIdentifierWithSchema();
/* 4563 */     Schema schema = getSchema();
/* 4564 */     if (isKeyword(str)) {
/* 4565 */       throw DbException.get(90114, str);
/*      */     }
/*      */     
/* 4568 */     read("VALUE");
/* 4569 */     Expression expression = readExpression();
/* 4570 */     CreateConstant createConstant = new CreateConstant(this.session, schema);
/* 4571 */     createConstant.setConstantName(str);
/* 4572 */     createConstant.setExpression(expression);
/* 4573 */     createConstant.setIfNotExists(bool);
/* 4574 */     return createConstant;
/*      */   }
/*      */   
/*      */   private CreateAggregate parseCreateAggregate(boolean paramBoolean) {
/* 4578 */     boolean bool = readIfNotExists();
/* 4579 */     CreateAggregate createAggregate = new CreateAggregate(this.session);
/* 4580 */     createAggregate.setForce(paramBoolean);
/* 4581 */     String str = readIdentifierWithSchema();
/* 4582 */     if (isKeyword(str) || Function.getFunction(this.database, str) != null || getAggregateType(str) >= 0)
/*      */     {
/* 4584 */       throw DbException.get(90076, str);
/*      */     }
/*      */     
/* 4587 */     createAggregate.setName(str);
/* 4588 */     createAggregate.setSchema(getSchema());
/* 4589 */     createAggregate.setIfNotExists(bool);
/* 4590 */     read("FOR");
/* 4591 */     createAggregate.setJavaClassMethod(readUniqueIdentifier());
/* 4592 */     return createAggregate;
/*      */   }
/*      */   
/*      */   private CreateUserDataType parseCreateUserDataType() {
/* 4596 */     boolean bool = readIfNotExists();
/* 4597 */     CreateUserDataType createUserDataType = new CreateUserDataType(this.session);
/* 4598 */     createUserDataType.setTypeName(readUniqueIdentifier());
/* 4599 */     read("AS");
/* 4600 */     Column column = parseColumnForTable("VALUE", true);
/* 4601 */     if (readIf("CHECK")) {
/* 4602 */       Expression expression = readExpression();
/* 4603 */       column.addCheckConstraint(this.session, expression);
/*      */     } 
/* 4605 */     column.rename(null);
/* 4606 */     createUserDataType.setColumn(column);
/* 4607 */     createUserDataType.setIfNotExists(bool);
/* 4608 */     return createUserDataType;
/*      */   }
/*      */   private CreateTrigger parseCreateTrigger(boolean paramBoolean) {
/*      */     boolean bool1, bool2;
/* 4612 */     boolean bool = readIfNotExists();
/* 4613 */     String str = readIdentifierWithSchema(null);
/* 4614 */     Schema schema = getSchema();
/*      */     
/* 4616 */     if (readIf("INSTEAD")) {
/* 4617 */       read("OF");
/* 4618 */       bool2 = true;
/* 4619 */       bool1 = true;
/* 4620 */     } else if (readIf("BEFORE")) {
/* 4621 */       bool1 = false;
/* 4622 */       bool2 = true;
/*      */     } else {
/* 4624 */       read("AFTER");
/* 4625 */       bool1 = false;
/* 4626 */       bool2 = false;
/*      */     } 
/* 4628 */     int i = 0;
/* 4629 */     boolean bool3 = false;
/*      */     while (true) {
/* 4631 */       if (readIf("INSERT")) {
/* 4632 */         i |= 0x1;
/* 4633 */       } else if (readIf("UPDATE")) {
/* 4634 */         i |= 0x2;
/* 4635 */       } else if (readIf("DELETE")) {
/* 4636 */         i |= 0x4;
/* 4637 */       } else if (readIf("SELECT")) {
/* 4638 */         i |= 0x8;
/* 4639 */       } else if (readIf("ROLLBACK")) {
/* 4640 */         bool3 = true;
/*      */       } else {
/* 4642 */         throw getSyntaxError();
/*      */       } 
/* 4644 */       if (!readIf(",")) {
/* 4645 */         read("ON");
/* 4646 */         String str1 = readIdentifierWithSchema();
/* 4647 */         checkSchema(schema);
/* 4648 */         CreateTrigger createTrigger = new CreateTrigger(this.session, getSchema());
/* 4649 */         createTrigger.setForce(paramBoolean);
/* 4650 */         createTrigger.setTriggerName(str);
/* 4651 */         createTrigger.setIfNotExists(bool);
/* 4652 */         createTrigger.setInsteadOf(bool1);
/* 4653 */         createTrigger.setBefore(bool2);
/* 4654 */         createTrigger.setOnRollback(bool3);
/* 4655 */         createTrigger.setTypeMask(i);
/* 4656 */         createTrigger.setTableName(str1);
/* 4657 */         if (readIf("FOR")) {
/* 4658 */           read("EACH");
/* 4659 */           read("ROW");
/* 4660 */           createTrigger.setRowBased(true);
/*      */         } else {
/* 4662 */           createTrigger.setRowBased(false);
/*      */         } 
/* 4664 */         if (readIf("QUEUE")) {
/* 4665 */           createTrigger.setQueueSize(readPositiveInt());
/*      */         }
/* 4667 */         createTrigger.setNoWait(readIf("NOWAIT"));
/* 4668 */         if (readIf("AS")) {
/* 4669 */           createTrigger.setTriggerSource(readString());
/*      */         } else {
/* 4671 */           read("CALL");
/* 4672 */           createTrigger.setTriggerClassName(readUniqueIdentifier());
/*      */         } 
/* 4674 */         return createTrigger;
/*      */       } 
/*      */     } 
/*      */   } private CreateUser parseCreateUser() {
/* 4678 */     CreateUser createUser = new CreateUser(this.session);
/* 4679 */     createUser.setIfNotExists(readIfNotExists());
/* 4680 */     createUser.setUserName(readUniqueIdentifier());
/* 4681 */     createUser.setComment(readCommentIf());
/* 4682 */     if (readIf("PASSWORD")) {
/* 4683 */       createUser.setPassword(readExpression());
/* 4684 */     } else if (readIf("SALT")) {
/* 4685 */       createUser.setSalt(readExpression());
/* 4686 */       read("HASH");
/* 4687 */       createUser.setHash(readExpression());
/* 4688 */     } else if (readIf("IDENTIFIED")) {
/* 4689 */       read("BY");
/*      */       
/* 4691 */       createUser.setPassword((Expression)ValueExpression.get(ValueString.get(readColumnIdentifier())));
/*      */     } else {
/*      */       
/* 4694 */       throw getSyntaxError();
/*      */     } 
/* 4696 */     if (readIf("ADMIN")) {
/* 4697 */       createUser.setAdmin(true);
/*      */     }
/* 4699 */     return createUser;
/*      */   }
/*      */   
/*      */   private CreateFunctionAlias parseCreateFunctionAlias(boolean paramBoolean) {
/* 4703 */     boolean bool = readIfNotExists();
/* 4704 */     String str = readIdentifierWithSchema();
/* 4705 */     if (isKeyword(str) || Function.getFunction(this.database, str) != null || getAggregateType(str) >= 0)
/*      */     {
/*      */       
/* 4708 */       throw DbException.get(90076, str);
/*      */     }
/*      */     
/* 4711 */     CreateFunctionAlias createFunctionAlias = new CreateFunctionAlias(this.session, getSchema());
/*      */     
/* 4713 */     createFunctionAlias.setForce(paramBoolean);
/* 4714 */     createFunctionAlias.setAliasName(str);
/* 4715 */     createFunctionAlias.setIfNotExists(bool);
/* 4716 */     createFunctionAlias.setDeterministic(readIf("DETERMINISTIC"));
/* 4717 */     createFunctionAlias.setBufferResultSetToLocalTemp(!readIf("NOBUFFER"));
/* 4718 */     if (readIf("AS")) {
/* 4719 */       createFunctionAlias.setSource(readString());
/*      */     } else {
/* 4721 */       read("FOR");
/* 4722 */       createFunctionAlias.setJavaClassMethod(readUniqueIdentifier());
/*      */     } 
/* 4724 */     return createFunctionAlias;
/*      */   }
/*      */   private Query parseWith() {
/*      */     String str2;
/* 4728 */     readIf("RECURSIVE");
/* 4729 */     String str1 = readIdentifierWithSchema();
/* 4730 */     Schema schema = getSchema();
/*      */     
/* 4732 */     read("(");
/* 4733 */     ArrayList<Column> arrayList = New.arrayList();
/* 4734 */     String[] arrayOfString = parseColumnList();
/* 4735 */     for (String str : arrayOfString) {
/* 4736 */       arrayList.add(new Column(str, 13));
/*      */     }
/* 4738 */     Table table2 = this.session.findLocalTempTable(str1);
/* 4739 */     if (table2 != null) {
/* 4740 */       if (!(table2 instanceof TableView)) {
/* 4741 */         throw DbException.get(42101, str1);
/*      */       }
/*      */       
/* 4744 */       TableView tableView1 = (TableView)table2;
/* 4745 */       if (!tableView1.isTableExpression()) {
/* 4746 */         throw DbException.get(42101, str1);
/*      */       }
/*      */       
/* 4749 */       this.session.removeLocalTempTable(table2);
/*      */     } 
/* 4751 */     CreateTableData createTableData = new CreateTableData();
/* 4752 */     createTableData.id = this.database.allocateObjectId();
/* 4753 */     createTableData.columns = arrayList;
/* 4754 */     createTableData.tableName = str1;
/* 4755 */     createTableData.temporary = true;
/* 4756 */     createTableData.persistData = true;
/* 4757 */     createTableData.persistIndexes = false;
/* 4758 */     createTableData.create = true;
/* 4759 */     createTableData.session = this.session;
/* 4760 */     Table table1 = schema.createTable(createTableData);
/* 4761 */     this.session.addLocalTempTable(table1);
/*      */     
/* 4763 */     Column[] arrayOfColumn = new Column[arrayOfString.length];
/*      */     try {
/* 4765 */       read("AS");
/* 4766 */       read("(");
/* 4767 */       Query query1 = parseSelect();
/* 4768 */       read(")");
/* 4769 */       query1.prepare();
/* 4770 */       str2 = StringUtils.fromCacheOrNew(query1.getPlanSQL());
/* 4771 */       ArrayList<Expression> arrayList1 = query1.getExpressions();
/* 4772 */       for (byte b = 0; b < arrayOfString.length; b++) {
/* 4773 */         arrayOfColumn[b] = new Column(arrayOfString[b], ((Expression)arrayList1.get(b)).getType());
/*      */       }
/*      */     } finally {
/* 4776 */       this.session.removeLocalTempTable(table1);
/*      */     } 
/* 4778 */     int i = this.database.allocateObjectId();
/* 4779 */     TableView tableView = new TableView(schema, i, str1, str2, this.parameters, arrayOfColumn, this.session, true);
/*      */     
/* 4781 */     tableView.setTableExpression(true);
/* 4782 */     tableView.setTemporary(true);
/* 4783 */     this.session.addLocalTempTable((Table)tableView);
/* 4784 */     tableView.setOnCommitDrop(true);
/* 4785 */     Query query = parseSelectUnion();
/* 4786 */     query.setPrepareAlways(true);
/* 4787 */     return query;
/*      */   }
/*      */   
/*      */   private CreateView parseCreateView(boolean paramBoolean1, boolean paramBoolean2) {
/* 4791 */     boolean bool = readIfNotExists();
/* 4792 */     String str1 = readIdentifierWithSchema();
/* 4793 */     CreateView createView = new CreateView(this.session, getSchema());
/* 4794 */     this.createView = createView;
/* 4795 */     createView.setViewName(str1);
/* 4796 */     createView.setIfNotExists(bool);
/* 4797 */     createView.setComment(readCommentIf());
/* 4798 */     createView.setOrReplace(paramBoolean2);
/* 4799 */     createView.setForce(paramBoolean1);
/* 4800 */     if (readIf("(")) {
/* 4801 */       String[] arrayOfString = parseColumnList();
/* 4802 */       createView.setColumnNames(arrayOfString);
/*      */     } 
/* 4804 */     String str2 = StringUtils.fromCacheOrNew(this.sqlCommand.substring(this.parseIndex));
/*      */     
/* 4806 */     read("AS");
/*      */     try {
/*      */       Query query;
/* 4809 */       this.session.setParsingView(true);
/*      */       try {
/* 4811 */         query = parseSelect();
/* 4812 */         query.prepare();
/*      */       } finally {
/* 4814 */         this.session.setParsingView(false);
/*      */       } 
/* 4816 */       createView.setSelect(query);
/* 4817 */     } catch (DbException dbException) {
/* 4818 */       if (paramBoolean1) {
/* 4819 */         createView.setSelectSQL(str2);
/* 4820 */         while (this.currentTokenType != 4) {
/* 4821 */           read();
/*      */         }
/*      */       } else {
/* 4824 */         throw dbException;
/*      */       } 
/*      */     } 
/* 4827 */     return createView;
/*      */   }
/*      */   
/*      */   private TransactionCommand parseCheckpoint() {
/*      */     TransactionCommand transactionCommand;
/* 4832 */     if (readIf("SYNC")) {
/* 4833 */       transactionCommand = new TransactionCommand(this.session, 76);
/*      */     } else {
/*      */       
/* 4836 */       transactionCommand = new TransactionCommand(this.session, 73);
/*      */     } 
/*      */     
/* 4839 */     return transactionCommand;
/*      */   }
/*      */   
/*      */   private Prepared parseAlter() {
/* 4843 */     if (readIf("TABLE"))
/* 4844 */       return parseAlterTable(); 
/* 4845 */     if (readIf("USER"))
/* 4846 */       return (Prepared)parseAlterUser(); 
/* 4847 */     if (readIf("INDEX"))
/* 4848 */       return (Prepared)parseAlterIndex(); 
/* 4849 */     if (readIf("SCHEMA"))
/* 4850 */       return parseAlterSchema(); 
/* 4851 */     if (readIf("SEQUENCE"))
/* 4852 */       return (Prepared)parseAlterSequence(); 
/* 4853 */     if (readIf("VIEW")) {
/* 4854 */       return (Prepared)parseAlterView();
/*      */     }
/* 4856 */     throw getSyntaxError();
/*      */   }
/*      */   
/*      */   private void checkSchema(Schema paramSchema) {
/* 4860 */     if (paramSchema != null && getSchema() != paramSchema) {
/* 4861 */       throw DbException.get(90080);
/*      */     }
/*      */   }
/*      */   
/*      */   private AlterIndexRename parseAlterIndex() {
/* 4866 */     boolean bool = readIfExists(false);
/* 4867 */     String str1 = readIdentifierWithSchema();
/* 4868 */     Schema schema = getSchema();
/* 4869 */     AlterIndexRename alterIndexRename = new AlterIndexRename(this.session);
/* 4870 */     alterIndexRename.setOldSchema(schema);
/* 4871 */     alterIndexRename.setOldName(str1);
/* 4872 */     alterIndexRename.setIfExists(bool);
/* 4873 */     read("RENAME");
/* 4874 */     read("TO");
/* 4875 */     String str2 = readIdentifierWithSchema(schema.getName());
/* 4876 */     checkSchema(schema);
/* 4877 */     alterIndexRename.setNewName(str2);
/* 4878 */     return alterIndexRename;
/*      */   }
/*      */   
/*      */   private AlterView parseAlterView() {
/* 4882 */     AlterView alterView = new AlterView(this.session);
/* 4883 */     boolean bool = readIfExists(false);
/* 4884 */     alterView.setIfExists(bool);
/* 4885 */     String str = readIdentifierWithSchema();
/* 4886 */     Table table = getSchema().findTableOrView(this.session, str);
/* 4887 */     if (!(table instanceof TableView) && !bool) {
/* 4888 */       throw DbException.get(90037, str);
/*      */     }
/* 4890 */     TableView tableView = (TableView)table;
/* 4891 */     alterView.setView(tableView);
/* 4892 */     read("RECOMPILE");
/* 4893 */     return alterView;
/*      */   }
/*      */   
/*      */   private Prepared parseAlterSchema() {
/* 4897 */     boolean bool = readIfExists(false);
/* 4898 */     String str1 = readIdentifierWithSchema();
/* 4899 */     Schema schema1 = getSchema();
/* 4900 */     read("RENAME");
/* 4901 */     read("TO");
/* 4902 */     String str2 = readIdentifierWithSchema(schema1.getName());
/* 4903 */     Schema schema2 = findSchema(str1);
/* 4904 */     if (schema2 == null) {
/* 4905 */       if (bool) {
/* 4906 */         return (Prepared)new NoOperation(this.session);
/*      */       }
/* 4908 */       throw DbException.get(90079, str1);
/*      */     } 
/* 4910 */     AlterSchemaRename alterSchemaRename = new AlterSchemaRename(this.session);
/* 4911 */     alterSchemaRename.setOldSchema(schema2);
/* 4912 */     checkSchema(schema1);
/* 4913 */     alterSchemaRename.setNewName(str2);
/* 4914 */     return (Prepared)alterSchemaRename;
/*      */   }
/*      */   
/*      */   private AlterSequence parseAlterSequence() {
/* 4918 */     boolean bool = readIfExists(false);
/* 4919 */     String str = readIdentifierWithSchema();
/* 4920 */     AlterSequence alterSequence = new AlterSequence(this.session, getSchema());
/* 4921 */     alterSequence.setSequenceName(str);
/* 4922 */     alterSequence.setIfExists(bool);
/*      */     while (true) {
/* 4924 */       while (readIf("RESTART")) {
/* 4925 */         read("WITH");
/* 4926 */         alterSequence.setStartWith(readExpression());
/* 4927 */       }  if (readIf("INCREMENT")) {
/* 4928 */         read("BY");
/* 4929 */         alterSequence.setIncrement(readExpression()); continue;
/* 4930 */       }  if (readIf("MINVALUE")) {
/* 4931 */         alterSequence.setMinValue(readExpression()); continue;
/* 4932 */       }  if (readIf("NOMINVALUE")) {
/* 4933 */         alterSequence.setMinValue(null); continue;
/* 4934 */       }  if (readIf("MAXVALUE")) {
/* 4935 */         alterSequence.setMaxValue(readExpression()); continue;
/* 4936 */       }  if (readIf("NOMAXVALUE")) {
/* 4937 */         alterSequence.setMaxValue(null); continue;
/* 4938 */       }  if (readIf("CYCLE")) {
/* 4939 */         alterSequence.setCycle(Boolean.valueOf(true)); continue;
/* 4940 */       }  if (readIf("NOCYCLE")) {
/* 4941 */         alterSequence.setCycle(Boolean.valueOf(false)); continue;
/* 4942 */       }  if (readIf("NO")) {
/* 4943 */         if (readIf("MINVALUE")) {
/* 4944 */           alterSequence.setMinValue(null); continue;
/* 4945 */         }  if (readIf("MAXVALUE")) {
/* 4946 */           alterSequence.setMaxValue(null); continue;
/* 4947 */         }  if (readIf("CYCLE")) {
/* 4948 */           alterSequence.setCycle(Boolean.valueOf(false)); continue;
/* 4949 */         }  if (readIf("CACHE")) {
/* 4950 */           alterSequence.setCacheSize((Expression)ValueExpression.get((Value)ValueLong.get(1L))); continue;
/*      */         } 
/*      */         break;
/*      */       } 
/* 4954 */       if (readIf("CACHE")) {
/* 4955 */         alterSequence.setCacheSize(readExpression()); continue;
/* 4956 */       }  if (readIf("NOCACHE")) {
/* 4957 */         alterSequence.setCacheSize((Expression)ValueExpression.get((Value)ValueLong.get(1L)));
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/* 4962 */     return alterSequence;
/*      */   }
/*      */   
/*      */   private AlterUser parseAlterUser() {
/* 4966 */     String str = readUniqueIdentifier();
/* 4967 */     if (readIf("SET")) {
/* 4968 */       AlterUser alterUser = new AlterUser(this.session);
/* 4969 */       alterUser.setType(19);
/* 4970 */       alterUser.setUser(this.database.getUser(str));
/* 4971 */       if (readIf("PASSWORD")) {
/* 4972 */         alterUser.setPassword(readExpression());
/* 4973 */       } else if (readIf("SALT")) {
/* 4974 */         alterUser.setSalt(readExpression());
/* 4975 */         read("HASH");
/* 4976 */         alterUser.setHash(readExpression());
/*      */       } else {
/* 4978 */         throw getSyntaxError();
/*      */       } 
/* 4980 */       return alterUser;
/* 4981 */     }  if (readIf("RENAME")) {
/* 4982 */       read("TO");
/* 4983 */       AlterUser alterUser = new AlterUser(this.session);
/* 4984 */       alterUser.setType(18);
/* 4985 */       alterUser.setUser(this.database.getUser(str));
/* 4986 */       String str1 = readUniqueIdentifier();
/* 4987 */       alterUser.setNewName(str1);
/* 4988 */       return alterUser;
/* 4989 */     }  if (readIf("ADMIN")) {
/* 4990 */       AlterUser alterUser = new AlterUser(this.session);
/* 4991 */       alterUser.setType(17);
/* 4992 */       User user = this.database.getUser(str);
/* 4993 */       alterUser.setUser(user);
/* 4994 */       if (readIf("TRUE")) {
/* 4995 */         alterUser.setAdmin(true);
/* 4996 */       } else if (readIf("FALSE")) {
/* 4997 */         alterUser.setAdmin(false);
/*      */       } else {
/* 4999 */         throw getSyntaxError();
/*      */       } 
/* 5001 */       return alterUser;
/*      */     } 
/* 5003 */     throw getSyntaxError();
/*      */   }
/*      */   
/*      */   private void readIfEqualOrTo() {
/* 5007 */     if (!readIf("=")) {
/* 5008 */       readIf("TO");
/*      */     }
/*      */   }
/*      */   
/*      */   private Prepared parseSet() {
/* 5013 */     if (readIf("@")) {
/* 5014 */       Set set1 = new Set(this.session, 35);
/* 5015 */       set1.setString(readAliasIdentifier());
/* 5016 */       readIfEqualOrTo();
/* 5017 */       set1.setExpression(readExpression());
/* 5018 */       return (Prepared)set1;
/* 5019 */     }  if (readIf("AUTOCOMMIT")) {
/* 5020 */       readIfEqualOrTo();
/* 5021 */       boolean bool = readBooleanSetting();
/* 5022 */       byte b = bool ? 69 : 70;
/*      */       
/* 5024 */       return (Prepared)new TransactionCommand(this.session, b);
/* 5025 */     }  if (readIf("MVCC")) {
/* 5026 */       readIfEqualOrTo();
/* 5027 */       boolean bool = readBooleanSetting();
/* 5028 */       Set set1 = new Set(this.session, 31);
/* 5029 */       set1.setInt(bool ? 1 : 0);
/* 5030 */       return (Prepared)set1;
/* 5031 */     }  if (readIf("EXCLUSIVE")) {
/* 5032 */       readIfEqualOrTo();
/* 5033 */       Set set1 = new Set(this.session, 33);
/* 5034 */       set1.setExpression(readExpression());
/* 5035 */       return (Prepared)set1;
/* 5036 */     }  if (readIf("IGNORECASE")) {
/* 5037 */       readIfEqualOrTo();
/* 5038 */       boolean bool = readBooleanSetting();
/* 5039 */       Set set1 = new Set(this.session, 1);
/* 5040 */       set1.setInt(bool ? 1 : 0);
/* 5041 */       return (Prepared)set1;
/* 5042 */     }  if (readIf("PASSWORD")) {
/* 5043 */       readIfEqualOrTo();
/* 5044 */       AlterUser alterUser = new AlterUser(this.session);
/* 5045 */       alterUser.setType(19);
/* 5046 */       alterUser.setUser(this.session.getUser());
/* 5047 */       alterUser.setPassword(readExpression());
/* 5048 */       return (Prepared)alterUser;
/* 5049 */     }  if (readIf("SALT")) {
/* 5050 */       readIfEqualOrTo();
/* 5051 */       AlterUser alterUser = new AlterUser(this.session);
/* 5052 */       alterUser.setType(19);
/* 5053 */       alterUser.setUser(this.session.getUser());
/* 5054 */       alterUser.setSalt(readExpression());
/* 5055 */       read("HASH");
/* 5056 */       alterUser.setHash(readExpression());
/* 5057 */       return (Prepared)alterUser;
/* 5058 */     }  if (readIf("MODE")) {
/* 5059 */       readIfEqualOrTo();
/* 5060 */       Set set1 = new Set(this.session, 3);
/* 5061 */       set1.setString(readAliasIdentifier());
/* 5062 */       return (Prepared)set1;
/* 5063 */     }  if (readIf("COMPRESS_LOB")) {
/* 5064 */       readIfEqualOrTo();
/* 5065 */       Set set1 = new Set(this.session, 23);
/* 5066 */       if (this.currentTokenType == 5) {
/* 5067 */         set1.setString(readString());
/*      */       } else {
/* 5069 */         set1.setString(readUniqueIdentifier());
/*      */       } 
/* 5071 */       return (Prepared)set1;
/* 5072 */     }  if (readIf("DATABASE")) {
/* 5073 */       readIfEqualOrTo();
/* 5074 */       read("COLLATION");
/* 5075 */       return (Prepared)parseSetCollation();
/* 5076 */     }  if (readIf("COLLATION")) {
/* 5077 */       readIfEqualOrTo();
/* 5078 */       return (Prepared)parseSetCollation();
/* 5079 */     }  if (readIf("BINARY_COLLATION")) {
/* 5080 */       readIfEqualOrTo();
/* 5081 */       return (Prepared)parseSetBinaryCollation();
/* 5082 */     }  if (readIf("CLUSTER")) {
/* 5083 */       readIfEqualOrTo();
/* 5084 */       Set set1 = new Set(this.session, 13);
/* 5085 */       set1.setString(readString());
/* 5086 */       return (Prepared)set1;
/* 5087 */     }  if (readIf("DATABASE_EVENT_LISTENER")) {
/* 5088 */       readIfEqualOrTo();
/* 5089 */       Set set1 = new Set(this.session, 15);
/* 5090 */       set1.setString(readString());
/* 5091 */       return (Prepared)set1;
/* 5092 */     }  if (readIf("ALLOW_LITERALS")) {
/* 5093 */       readIfEqualOrTo();
/* 5094 */       Set set1 = new Set(this.session, 24);
/* 5095 */       if (readIf("NONE")) {
/* 5096 */         set1.setInt(0);
/* 5097 */       } else if (readIf("ALL")) {
/* 5098 */         set1.setInt(2);
/* 5099 */       } else if (readIf("NUMBERS")) {
/* 5100 */         set1.setInt(1);
/*      */       } else {
/* 5102 */         set1.setInt(readPositiveInt());
/*      */       } 
/* 5104 */       return (Prepared)set1;
/* 5105 */     }  if (readIf("DEFAULT_TABLE_TYPE")) {
/* 5106 */       readIfEqualOrTo();
/* 5107 */       Set set1 = new Set(this.session, 7);
/* 5108 */       if (readIf("MEMORY")) {
/* 5109 */         set1.setInt(1);
/* 5110 */       } else if (readIf("CACHED")) {
/* 5111 */         set1.setInt(0);
/*      */       } else {
/* 5113 */         set1.setInt(readPositiveInt());
/*      */       } 
/* 5115 */       return (Prepared)set1;
/* 5116 */     }  if (readIf("CREATE")) {
/* 5117 */       readIfEqualOrTo();
/*      */       
/* 5119 */       read();
/* 5120 */       return (Prepared)new NoOperation(this.session);
/* 5121 */     }  if (readIf("HSQLDB.DEFAULT_TABLE_TYPE")) {
/* 5122 */       readIfEqualOrTo();
/* 5123 */       read();
/* 5124 */       return (Prepared)new NoOperation(this.session);
/* 5125 */     }  if (readIf("PAGE_STORE")) {
/* 5126 */       readIfEqualOrTo();
/* 5127 */       read();
/* 5128 */       return (Prepared)new NoOperation(this.session);
/* 5129 */     }  if (readIf("CACHE_TYPE")) {
/* 5130 */       readIfEqualOrTo();
/* 5131 */       read();
/* 5132 */       return (Prepared)new NoOperation(this.session);
/* 5133 */     }  if (readIf("FILE_LOCK")) {
/* 5134 */       readIfEqualOrTo();
/* 5135 */       read();
/* 5136 */       return (Prepared)new NoOperation(this.session);
/* 5137 */     }  if (readIf("DB_CLOSE_ON_EXIT")) {
/* 5138 */       readIfEqualOrTo();
/* 5139 */       read();
/* 5140 */       return (Prepared)new NoOperation(this.session);
/* 5141 */     }  if (readIf("AUTO_SERVER")) {
/* 5142 */       readIfEqualOrTo();
/* 5143 */       read();
/* 5144 */       return (Prepared)new NoOperation(this.session);
/* 5145 */     }  if (readIf("AUTO_SERVER_PORT")) {
/* 5146 */       readIfEqualOrTo();
/* 5147 */       read();
/* 5148 */       return (Prepared)new NoOperation(this.session);
/* 5149 */     }  if (readIf("AUTO_RECONNECT")) {
/* 5150 */       readIfEqualOrTo();
/* 5151 */       read();
/* 5152 */       return (Prepared)new NoOperation(this.session);
/* 5153 */     }  if (readIf("ASSERT")) {
/* 5154 */       readIfEqualOrTo();
/* 5155 */       read();
/* 5156 */       return (Prepared)new NoOperation(this.session);
/* 5157 */     }  if (readIf("ACCESS_MODE_DATA")) {
/* 5158 */       readIfEqualOrTo();
/* 5159 */       read();
/* 5160 */       return (Prepared)new NoOperation(this.session);
/* 5161 */     }  if (readIf("OPEN_NEW")) {
/* 5162 */       readIfEqualOrTo();
/* 5163 */       read();
/* 5164 */       return (Prepared)new NoOperation(this.session);
/* 5165 */     }  if (readIf("JMX")) {
/* 5166 */       readIfEqualOrTo();
/* 5167 */       read();
/* 5168 */       return (Prepared)new NoOperation(this.session);
/* 5169 */     }  if (readIf("PAGE_SIZE")) {
/* 5170 */       readIfEqualOrTo();
/* 5171 */       read();
/* 5172 */       return (Prepared)new NoOperation(this.session);
/* 5173 */     }  if (readIf("RECOVER")) {
/* 5174 */       readIfEqualOrTo();
/* 5175 */       read();
/* 5176 */       return (Prepared)new NoOperation(this.session);
/* 5177 */     }  if (readIf("NAMES")) {
/*      */       
/* 5179 */       readIfEqualOrTo();
/* 5180 */       read();
/* 5181 */       return (Prepared)new NoOperation(this.session);
/* 5182 */     }  if (readIf("SCHEMA")) {
/* 5183 */       readIfEqualOrTo();
/* 5184 */       Set set1 = new Set(this.session, 26);
/* 5185 */       set1.setString(readAliasIdentifier());
/* 5186 */       return (Prepared)set1;
/* 5187 */     }  if (readIf("DATESTYLE")) {
/*      */       
/* 5189 */       readIfEqualOrTo();
/* 5190 */       if (!readIf("ISO")) {
/* 5191 */         String str = readString();
/* 5192 */         if (!equalsToken(str, "ISO")) {
/* 5193 */           throw getSyntaxError();
/*      */         }
/*      */       } 
/* 5196 */       return (Prepared)new NoOperation(this.session);
/* 5197 */     }  if (readIf("SEARCH_PATH") || readIf(SetTypes.getTypeName(28))) {
/*      */       
/* 5199 */       readIfEqualOrTo();
/* 5200 */       Set set1 = new Set(this.session, 28);
/* 5201 */       ArrayList<String> arrayList = New.arrayList();
/* 5202 */       arrayList.add(readAliasIdentifier());
/* 5203 */       while (readIf(",")) {
/* 5204 */         arrayList.add(readAliasIdentifier());
/*      */       }
/* 5206 */       String[] arrayOfString = new String[arrayList.size()];
/* 5207 */       arrayList.toArray(arrayOfString);
/* 5208 */       set1.setStringArray(arrayOfString);
/* 5209 */       return (Prepared)set1;
/* 5210 */     }  if (readIf("JAVA_OBJECT_SERIALIZER")) {
/* 5211 */       readIfEqualOrTo();
/* 5212 */       return (Prepared)parseSetJavaObjectSerializer();
/*      */     } 
/* 5214 */     if (isToken("LOGSIZE"))
/*      */     {
/* 5216 */       this.currentToken = SetTypes.getTypeName(2);
/*      */     }
/* 5218 */     if (isToken("FOREIGN_KEY_CHECKS"))
/*      */     {
/* 5220 */       this.currentToken = SetTypes.getTypeName(30);
/*      */     }
/*      */     
/* 5223 */     int i = SetTypes.getType(this.currentToken);
/* 5224 */     if (i < 0) {
/* 5225 */       throw getSyntaxError();
/*      */     }
/* 5227 */     read();
/* 5228 */     readIfEqualOrTo();
/* 5229 */     Set set = new Set(this.session, i);
/* 5230 */     set.setExpression(readExpression());
/* 5231 */     return (Prepared)set;
/*      */   }
/*      */ 
/*      */   
/*      */   private Prepared parseUse() {
/* 5236 */     readIfEqualOrTo();
/* 5237 */     Set set = new Set(this.session, 26);
/* 5238 */     set.setString(readAliasIdentifier());
/* 5239 */     return (Prepared)set;
/*      */   }
/*      */   
/*      */   private Set parseSetCollation() {
/* 5243 */     Set set = new Set(this.session, 12);
/* 5244 */     String str = readAliasIdentifier();
/* 5245 */     set.setString(str);
/* 5246 */     if (equalsToken(str, "OFF")) {
/* 5247 */       return set;
/*      */     }
/* 5249 */     Collator collator = CompareMode.getCollator(str);
/* 5250 */     if (collator == null) {
/* 5251 */       throw DbException.getInvalidValueException("collation", str);
/*      */     }
/* 5253 */     if (readIf("STRENGTH")) {
/* 5254 */       if (readIf("PRIMARY")) {
/* 5255 */         set.setInt(0);
/* 5256 */       } else if (readIf("SECONDARY")) {
/* 5257 */         set.setInt(1);
/* 5258 */       } else if (readIf("TERTIARY")) {
/* 5259 */         set.setInt(2);
/* 5260 */       } else if (readIf("IDENTICAL")) {
/* 5261 */         set.setInt(3);
/*      */       } 
/*      */     } else {
/* 5264 */       set.setInt(collator.getStrength());
/*      */     } 
/* 5266 */     return set;
/*      */   }
/*      */   
/*      */   private Set parseSetBinaryCollation() {
/* 5270 */     Set set = new Set(this.session, 38);
/* 5271 */     String str = readAliasIdentifier();
/* 5272 */     set.setString(str);
/* 5273 */     if (equalsToken(str, "UNSIGNED") || equalsToken(str, "SIGNED"))
/*      */     {
/* 5275 */       return set;
/*      */     }
/* 5277 */     throw DbException.getInvalidValueException("BINARY_COLLATION", str);
/*      */   }
/*      */   
/*      */   private Set parseSetJavaObjectSerializer() {
/* 5281 */     Set set = new Set(this.session, 39);
/* 5282 */     String str = readString();
/* 5283 */     set.setString(str);
/* 5284 */     return set;
/*      */   }
/*      */   
/*      */   private RunScriptCommand parseRunScript() {
/* 5288 */     RunScriptCommand runScriptCommand = new RunScriptCommand(this.session);
/* 5289 */     read("FROM");
/* 5290 */     runScriptCommand.setFileNameExpr(readExpression());
/* 5291 */     if (readIf("COMPRESSION")) {
/* 5292 */       runScriptCommand.setCompressionAlgorithm(readUniqueIdentifier());
/*      */     }
/* 5294 */     if (readIf("CIPHER")) {
/* 5295 */       runScriptCommand.setCipher(readUniqueIdentifier());
/* 5296 */       if (readIf("PASSWORD")) {
/* 5297 */         runScriptCommand.setPassword(readExpression());
/*      */       }
/*      */     } 
/* 5300 */     if (readIf("CHARSET")) {
/* 5301 */       runScriptCommand.setCharset(Charset.forName(readString()));
/*      */     }
/* 5303 */     return runScriptCommand;
/*      */   }
/*      */   
/*      */   private ScriptCommand parseScript() {
/* 5307 */     ScriptCommand scriptCommand = new ScriptCommand(this.session);
/* 5308 */     boolean bool1 = true, bool2 = true, bool3 = true;
/* 5309 */     boolean bool4 = false, bool5 = false;
/* 5310 */     if (readIf("SIMPLE")) {
/* 5311 */       bool5 = true;
/*      */     }
/* 5313 */     if (readIf("NODATA")) {
/* 5314 */       bool1 = false;
/*      */     }
/* 5316 */     if (readIf("NOPASSWORDS")) {
/* 5317 */       bool2 = false;
/*      */     }
/* 5319 */     if (readIf("NOSETTINGS")) {
/* 5320 */       bool3 = false;
/*      */     }
/* 5322 */     if (readIf("DROP")) {
/* 5323 */       bool4 = true;
/*      */     }
/* 5325 */     if (readIf("BLOCKSIZE")) {
/* 5326 */       long l = readLong();
/* 5327 */       scriptCommand.setLobBlockSize(l);
/*      */     } 
/* 5329 */     scriptCommand.setData(bool1);
/* 5330 */     scriptCommand.setPasswords(bool2);
/* 5331 */     scriptCommand.setSettings(bool3);
/* 5332 */     scriptCommand.setDrop(bool4);
/* 5333 */     scriptCommand.setSimple(bool5);
/* 5334 */     if (readIf("TO")) {
/* 5335 */       scriptCommand.setFileNameExpr(readExpression());
/* 5336 */       if (readIf("COMPRESSION")) {
/* 5337 */         scriptCommand.setCompressionAlgorithm(readUniqueIdentifier());
/*      */       }
/* 5339 */       if (readIf("CIPHER")) {
/* 5340 */         scriptCommand.setCipher(readUniqueIdentifier());
/* 5341 */         if (readIf("PASSWORD")) {
/* 5342 */           scriptCommand.setPassword(readExpression());
/*      */         }
/*      */       } 
/* 5345 */       if (readIf("CHARSET")) {
/* 5346 */         scriptCommand.setCharset(Charset.forName(readString()));
/*      */       }
/*      */     } 
/* 5349 */     if (readIf("SCHEMA"))
/* 5350 */     { HashSet<String> hashSet = New.hashSet();
/*      */       while (true)
/* 5352 */       { hashSet.add(readUniqueIdentifier());
/* 5353 */         if (!readIf(","))
/* 5354 */         { scriptCommand.setSchemaNames(hashSet);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5362 */           return scriptCommand; }  }  }  if (readIf("TABLE")) { ArrayList<Table> arrayList = New.arrayList(); while (true) { arrayList.add(readTableOrView()); if (!readIf(",")) { scriptCommand.setTables(arrayList); break; }  }  }  return scriptCommand;
/*      */   }
/*      */   
/*      */   private Table readTableOrView() {
/* 5366 */     return readTableOrView(readIdentifierWithSchema(null));
/*      */   }
/*      */ 
/*      */   
/*      */   private Table readTableOrView(String paramString) {
/* 5371 */     if (this.schemaName != null) {
/* 5372 */       return getSchema().getTableOrView(this.session, paramString);
/*      */     }
/* 5374 */     Table table = this.database.getSchema(this.session.getCurrentSchemaName()).findTableOrView(this.session, paramString);
/*      */     
/* 5376 */     if (table != null) {
/* 5377 */       return table;
/*      */     }
/* 5379 */     String[] arrayOfString = this.session.getSchemaSearchPath();
/* 5380 */     if (arrayOfString != null) {
/* 5381 */       for (String str : arrayOfString) {
/* 5382 */         Schema schema = this.database.getSchema(str);
/* 5383 */         table = schema.findTableOrView(this.session, paramString);
/* 5384 */         if (table != null) {
/* 5385 */           return table;
/*      */         }
/*      */       } 
/*      */     }
/* 5389 */     throw DbException.get(42102, paramString);
/*      */   }
/*      */   
/*      */   private FunctionAlias findFunctionAlias(String paramString1, String paramString2) {
/* 5393 */     FunctionAlias functionAlias = this.database.getSchema(paramString1).findFunction(paramString2);
/*      */     
/* 5395 */     if (functionAlias != null) {
/* 5396 */       return functionAlias;
/*      */     }
/* 5398 */     String[] arrayOfString = this.session.getSchemaSearchPath();
/* 5399 */     if (arrayOfString != null) {
/* 5400 */       for (String str : arrayOfString) {
/* 5401 */         functionAlias = this.database.getSchema(str).findFunction(paramString2);
/* 5402 */         if (functionAlias != null) {
/* 5403 */           return functionAlias;
/*      */         }
/*      */       } 
/*      */     }
/* 5407 */     return null;
/*      */   }
/*      */   
/*      */   private Sequence findSequence(String paramString1, String paramString2) {
/* 5411 */     Sequence sequence = this.database.getSchema(paramString1).findSequence(paramString2);
/*      */     
/* 5413 */     if (sequence != null) {
/* 5414 */       return sequence;
/*      */     }
/* 5416 */     String[] arrayOfString = this.session.getSchemaSearchPath();
/* 5417 */     if (arrayOfString != null) {
/* 5418 */       for (String str : arrayOfString) {
/* 5419 */         sequence = this.database.getSchema(str).findSequence(paramString2);
/* 5420 */         if (sequence != null) {
/* 5421 */           return sequence;
/*      */         }
/*      */       } 
/*      */     }
/* 5425 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private Sequence readSequence() {
/* 5430 */     String str = readIdentifierWithSchema(null);
/* 5431 */     if (this.schemaName != null) {
/* 5432 */       return getSchema().getSequence(str);
/*      */     }
/* 5434 */     Sequence sequence = findSequence(this.session.getCurrentSchemaName(), str);
/*      */     
/* 5436 */     if (sequence != null) {
/* 5437 */       return sequence;
/*      */     }
/* 5439 */     throw DbException.get(90036, str);
/*      */   }
/*      */   
/*      */   private Prepared parseAlterTable() {
/* 5443 */     boolean bool = readIfExists(false);
/* 5444 */     String str = readIdentifierWithSchema();
/* 5445 */     Schema schema = getSchema();
/* 5446 */     if (readIf("ADD")) {
/* 5447 */       DefineCommand defineCommand = parseAlterTableAddConstraintIf(str, schema, bool);
/*      */       
/* 5449 */       if (defineCommand != null) {
/* 5450 */         return (Prepared)defineCommand;
/*      */       }
/* 5452 */       return (Prepared)parseAlterTableAddColumn(str, schema, bool);
/* 5453 */     }  if (readIf("SET")) {
/* 5454 */       read("REFERENTIAL_INTEGRITY");
/* 5455 */       byte b = 55;
/* 5456 */       boolean bool1 = readBooleanSetting();
/* 5457 */       AlterTableSet alterTableSet = new AlterTableSet(this.session, schema, b, bool1);
/*      */       
/* 5459 */       alterTableSet.setTableName(str);
/* 5460 */       alterTableSet.setIfTableExists(bool);
/* 5461 */       if (readIf("CHECK")) {
/* 5462 */         alterTableSet.setCheckExisting(true);
/* 5463 */       } else if (readIf("NOCHECK")) {
/* 5464 */         alterTableSet.setCheckExisting(false);
/*      */       } 
/* 5466 */       return (Prepared)alterTableSet;
/* 5467 */     }  if (readIf("RENAME")) {
/* 5468 */       if (readIf("COLUMN")) {
/*      */         
/* 5470 */         String str2 = readColumnIdentifier();
/* 5471 */         read("TO");
/* 5472 */         AlterTableRenameColumn alterTableRenameColumn = new AlterTableRenameColumn(this.session, schema);
/*      */         
/* 5474 */         alterTableRenameColumn.setTableName(str);
/* 5475 */         alterTableRenameColumn.setIfTableExists(bool);
/* 5476 */         alterTableRenameColumn.setOldColumnName(str2);
/* 5477 */         String str3 = readColumnIdentifier();
/* 5478 */         alterTableRenameColumn.setNewColumnName(str3);
/* 5479 */         return (Prepared)alterTableRenameColumn;
/* 5480 */       }  if (readIf("CONSTRAINT")) {
/* 5481 */         String str2 = readIdentifierWithSchema(schema.getName());
/* 5482 */         checkSchema(schema);
/* 5483 */         read("TO");
/* 5484 */         AlterTableRenameConstraint alterTableRenameConstraint = new AlterTableRenameConstraint(this.session, schema);
/*      */         
/* 5486 */         alterTableRenameConstraint.setConstraintName(str2);
/* 5487 */         String str3 = readColumnIdentifier();
/* 5488 */         alterTableRenameConstraint.setNewConstraintName(str3);
/* 5489 */         return commandIfTableExists(schema, str, bool, (Prepared)alterTableRenameConstraint);
/*      */       } 
/* 5491 */       read("TO");
/* 5492 */       String str1 = readIdentifierWithSchema(schema.getName());
/* 5493 */       checkSchema(schema);
/* 5494 */       AlterTableRename alterTableRename = new AlterTableRename(this.session, getSchema());
/*      */       
/* 5496 */       alterTableRename.setOldTableName(str);
/* 5497 */       alterTableRename.setNewTableName(str1);
/* 5498 */       alterTableRename.setIfTableExists(bool);
/* 5499 */       alterTableRename.setHidden(readIf("HIDDEN"));
/* 5500 */       return (Prepared)alterTableRename;
/*      */     } 
/* 5502 */     if (readIf("DROP")) {
/* 5503 */       if (readIf("CONSTRAINT")) {
/* 5504 */         boolean bool2 = readIfExists(false);
/* 5505 */         String str1 = readIdentifierWithSchema(schema.getName());
/* 5506 */         bool2 = readIfExists(bool2);
/* 5507 */         checkSchema(schema);
/* 5508 */         AlterTableDropConstraint alterTableDropConstraint = new AlterTableDropConstraint(this.session, getSchema(), bool2);
/*      */         
/* 5510 */         alterTableDropConstraint.setConstraintName(str1);
/* 5511 */         return commandIfTableExists(schema, str, bool, (Prepared)alterTableDropConstraint);
/* 5512 */       }  if (readIf("FOREIGN")) {
/*      */         
/* 5514 */         read("KEY");
/* 5515 */         String str1 = readIdentifierWithSchema(schema.getName());
/* 5516 */         checkSchema(schema);
/* 5517 */         AlterTableDropConstraint alterTableDropConstraint = new AlterTableDropConstraint(this.session, getSchema(), false);
/*      */         
/* 5519 */         alterTableDropConstraint.setConstraintName(str1);
/* 5520 */         return commandIfTableExists(schema, str, bool, (Prepared)alterTableDropConstraint);
/* 5521 */       }  if (readIf("INDEX")) {
/*      */         
/* 5523 */         String str1 = readIdentifierWithSchema();
/* 5524 */         DropIndex dropIndex = new DropIndex(this.session, getSchema());
/* 5525 */         dropIndex.setIndexName(str1);
/* 5526 */         return commandIfTableExists(schema, str, bool, (Prepared)dropIndex);
/* 5527 */       }  if (readIf("PRIMARY")) {
/* 5528 */         read("KEY");
/* 5529 */         Table table1 = tableIfTableExists(schema, str, bool);
/* 5530 */         if (table1 == null) {
/* 5531 */           return (Prepared)new NoOperation(this.session);
/*      */         }
/* 5533 */         Index index = table1.getPrimaryKey();
/* 5534 */         DropIndex dropIndex = new DropIndex(this.session, schema);
/* 5535 */         dropIndex.setIndexName(index.getName());
/* 5536 */         return (Prepared)dropIndex;
/*      */       } 
/* 5538 */       readIf("COLUMN");
/* 5539 */       boolean bool1 = readIfExists(false);
/* 5540 */       AlterTableAlterColumn alterTableAlterColumn = new AlterTableAlterColumn(this.session, schema);
/*      */       
/* 5542 */       alterTableAlterColumn.setType(12);
/* 5543 */       ArrayList<Column> arrayList = New.arrayList();
/* 5544 */       Table table = tableIfTableExists(schema, str, bool);
/*      */       while (true) {
/* 5546 */         String str1 = readColumnIdentifier();
/* 5547 */         if (table == null) {
/* 5548 */           return (Prepared)new NoOperation(this.session);
/*      */         }
/* 5550 */         if (bool1 && !table.doesColumnExist(str1)) {
/* 5551 */           return (Prepared)new NoOperation(this.session);
/*      */         }
/* 5553 */         Column column = table.getColumn(str1);
/* 5554 */         arrayList.add(column);
/* 5555 */         if (!readIf(","))
/* 5556 */         { alterTableAlterColumn.setTableName(str);
/* 5557 */           alterTableAlterColumn.setIfTableExists(bool);
/* 5558 */           alterTableAlterColumn.setColumnsToRemove(arrayList);
/* 5559 */           return (Prepared)alterTableAlterColumn; } 
/*      */       } 
/* 5561 */     }  if (readIf("CHANGE")) {
/*      */       
/* 5563 */       readIf("COLUMN");
/* 5564 */       String str1 = readColumnIdentifier();
/* 5565 */       String str2 = readColumnIdentifier();
/* 5566 */       Column column = columnIfTableExists(schema, str, str1, bool);
/* 5567 */       boolean bool1 = (column == null) ? true : column.isNullable();
/*      */ 
/*      */       
/* 5570 */       parseColumnForTable(str2, bool1);
/* 5571 */       AlterTableRenameColumn alterTableRenameColumn = new AlterTableRenameColumn(this.session, schema);
/* 5572 */       alterTableRenameColumn.setTableName(str);
/* 5573 */       alterTableRenameColumn.setIfTableExists(bool);
/* 5574 */       alterTableRenameColumn.setOldColumnName(str1);
/* 5575 */       alterTableRenameColumn.setNewColumnName(str2);
/* 5576 */       return (Prepared)alterTableRenameColumn;
/* 5577 */     }  if (readIf("MODIFY")) {
/*      */       
/* 5579 */       readIf("COLUMN");
/* 5580 */       String str1 = readColumnIdentifier();
/* 5581 */       return (Prepared)parseAlterTableAlterColumnType(schema, str, str1, bool);
/* 5582 */     }  if (readIf("ALTER")) {
/* 5583 */       readIf("COLUMN");
/* 5584 */       String str1 = readColumnIdentifier();
/* 5585 */       Column column = columnIfTableExists(schema, str, str1, bool);
/* 5586 */       if (readIf("RENAME")) {
/* 5587 */         read("TO");
/* 5588 */         AlterTableRenameColumn alterTableRenameColumn = new AlterTableRenameColumn(this.session, schema);
/*      */         
/* 5590 */         alterTableRenameColumn.setTableName(str);
/* 5591 */         alterTableRenameColumn.setIfTableExists(bool);
/* 5592 */         alterTableRenameColumn.setOldColumnName(str1);
/* 5593 */         String str2 = readColumnIdentifier();
/* 5594 */         alterTableRenameColumn.setNewColumnName(str2);
/* 5595 */         return (Prepared)alterTableRenameColumn;
/* 5596 */       }  if (readIf("DROP")) {
/*      */         
/* 5598 */         if (readIf("DEFAULT")) {
/* 5599 */           AlterTableAlterColumn alterTableAlterColumn1 = new AlterTableAlterColumn(this.session, schema);
/*      */           
/* 5601 */           alterTableAlterColumn1.setTableName(str);
/* 5602 */           alterTableAlterColumn1.setIfTableExists(bool);
/* 5603 */           alterTableAlterColumn1.setOldColumn(column);
/* 5604 */           alterTableAlterColumn1.setType(10);
/* 5605 */           alterTableAlterColumn1.setDefaultExpression(null);
/* 5606 */           return (Prepared)alterTableAlterColumn1;
/*      */         } 
/* 5608 */         read("NOT");
/* 5609 */         read("NULL");
/* 5610 */         AlterTableAlterColumn alterTableAlterColumn = new AlterTableAlterColumn(this.session, schema);
/*      */         
/* 5612 */         alterTableAlterColumn.setTableName(str);
/* 5613 */         alterTableAlterColumn.setIfTableExists(bool);
/* 5614 */         alterTableAlterColumn.setOldColumn(column);
/* 5615 */         alterTableAlterColumn.setType(9);
/* 5616 */         return (Prepared)alterTableAlterColumn;
/* 5617 */       }  if (readIf("TYPE"))
/*      */       {
/* 5619 */         return (Prepared)parseAlterTableAlterColumnType(schema, str, str1, bool);
/*      */       }
/* 5621 */       if (readIf("SET"))
/* 5622 */       { if (readIf("DATA")) {
/*      */           
/* 5624 */           read("TYPE");
/* 5625 */           return (Prepared)parseAlterTableAlterColumnType(schema, str, str1, bool);
/*      */         } 
/*      */         
/* 5628 */         AlterTableAlterColumn alterTableAlterColumn = new AlterTableAlterColumn(this.session, schema);
/*      */         
/* 5630 */         alterTableAlterColumn.setTableName(str);
/* 5631 */         alterTableAlterColumn.setIfTableExists(bool);
/* 5632 */         alterTableAlterColumn.setOldColumn(column);
/* 5633 */         if (readIf("NULL")) {
/* 5634 */           alterTableAlterColumn.setType(9);
/* 5635 */           return (Prepared)alterTableAlterColumn;
/* 5636 */         }  if (readIf("NOT")) {
/* 5637 */           read("NULL");
/* 5638 */           alterTableAlterColumn.setType(8);
/* 5639 */           return (Prepared)alterTableAlterColumn;
/* 5640 */         }  if (readIf("DEFAULT")) {
/* 5641 */           Expression expression = readExpression();
/* 5642 */           alterTableAlterColumn.setType(10);
/* 5643 */           alterTableAlterColumn.setDefaultExpression(expression);
/* 5644 */           return (Prepared)alterTableAlterColumn;
/*      */         }  }
/* 5646 */       else { if (readIf("RESTART")) {
/* 5647 */           readIf("WITH");
/* 5648 */           Expression expression = readExpression();
/* 5649 */           AlterSequence alterSequence = new AlterSequence(this.session, schema);
/* 5650 */           alterSequence.setColumn(column);
/* 5651 */           alterSequence.setStartWith(expression);
/* 5652 */           return commandIfTableExists(schema, str, bool, (Prepared)alterSequence);
/* 5653 */         }  if (readIf("SELECTIVITY")) {
/* 5654 */           AlterTableAlterColumn alterTableAlterColumn = new AlterTableAlterColumn(this.session, schema);
/*      */           
/* 5656 */           alterTableAlterColumn.setTableName(str);
/* 5657 */           alterTableAlterColumn.setIfTableExists(bool);
/* 5658 */           alterTableAlterColumn.setType(13);
/* 5659 */           alterTableAlterColumn.setOldColumn(column);
/* 5660 */           alterTableAlterColumn.setSelectivity(readExpression());
/* 5661 */           return (Prepared)alterTableAlterColumn;
/*      */         } 
/* 5663 */         return (Prepared)parseAlterTableAlterColumnType(schema, str, str1, bool); }
/*      */     
/*      */     } 
/*      */     
/* 5667 */     throw getSyntaxError();
/*      */   }
/*      */   
/*      */   private Table tableIfTableExists(Schema paramSchema, String paramString, boolean paramBoolean) {
/* 5671 */     Table table = paramSchema.findTableOrView(this.session, paramString);
/* 5672 */     if (table == null && !paramBoolean) {
/* 5673 */       throw DbException.get(42102, paramString);
/*      */     }
/* 5675 */     return table;
/*      */   }
/*      */ 
/*      */   
/*      */   private Column columnIfTableExists(Schema paramSchema, String paramString1, String paramString2, boolean paramBoolean) {
/* 5680 */     Table table = tableIfTableExists(paramSchema, paramString1, paramBoolean);
/* 5681 */     return (table == null) ? null : table.getColumn(paramString2);
/*      */   }
/*      */ 
/*      */   
/*      */   private Prepared commandIfTableExists(Schema paramSchema, String paramString, boolean paramBoolean, Prepared paramPrepared) {
/* 5686 */     return (tableIfTableExists(paramSchema, paramString, paramBoolean) == null) ? (Prepared)new NoOperation(this.session) : paramPrepared;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AlterTableAlterColumn parseAlterTableAlterColumnType(Schema paramSchema, String paramString1, String paramString2, boolean paramBoolean) {
/* 5693 */     Column column1 = columnIfTableExists(paramSchema, paramString1, paramString2, paramBoolean);
/* 5694 */     Column column2 = parseColumnForTable(paramString2, (column1 == null) ? true : column1.isNullable());
/*      */     
/* 5696 */     AlterTableAlterColumn alterTableAlterColumn = new AlterTableAlterColumn(this.session, paramSchema);
/*      */     
/* 5698 */     alterTableAlterColumn.setTableName(paramString1);
/* 5699 */     alterTableAlterColumn.setIfTableExists(paramBoolean);
/* 5700 */     alterTableAlterColumn.setType(11);
/* 5701 */     alterTableAlterColumn.setOldColumn(column1);
/* 5702 */     alterTableAlterColumn.setNewColumn(column2);
/* 5703 */     return alterTableAlterColumn;
/*      */   }
/*      */ 
/*      */   
/*      */   private AlterTableAlterColumn parseAlterTableAddColumn(String paramString, Schema paramSchema, boolean paramBoolean) {
/* 5708 */     readIf("COLUMN");
/* 5709 */     AlterTableAlterColumn alterTableAlterColumn = new AlterTableAlterColumn(this.session, paramSchema);
/*      */     
/* 5711 */     alterTableAlterColumn.setType(7);
/* 5712 */     alterTableAlterColumn.setTableName(paramString);
/* 5713 */     alterTableAlterColumn.setIfTableExists(paramBoolean);
/* 5714 */     ArrayList<Column> arrayList = New.arrayList();
/* 5715 */     if (readIf("("))
/* 5716 */     { alterTableAlterColumn.setIfNotExists(false);
/*      */       while (true)
/* 5718 */       { String str1 = readColumnIdentifier();
/* 5719 */         Column column1 = parseColumnForTable(str1, true);
/* 5720 */         arrayList.add(column1);
/* 5721 */         if (!readIf(","))
/* 5722 */         { read(")");
/* 5723 */           if (readIf("BEFORE")) {
/* 5724 */             alterTableAlterColumn.setAddBefore(readColumnIdentifier());
/* 5725 */           } else if (readIf("AFTER")) {
/* 5726 */             alterTableAlterColumn.setAddAfter(readColumnIdentifier());
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5740 */           alterTableAlterColumn.setNewColumns(arrayList);
/* 5741 */           return alterTableAlterColumn; }  }  }  boolean bool = readIfNotExists(); alterTableAlterColumn.setIfNotExists(bool); String str = readColumnIdentifier(); Column column = parseColumnForTable(str, true); arrayList.add(column); if (readIf("BEFORE")) { alterTableAlterColumn.setAddBefore(readColumnIdentifier()); } else if (readIf("AFTER")) { alterTableAlterColumn.setAddAfter(readColumnIdentifier()); }  alterTableAlterColumn.setNewColumns(arrayList); return alterTableAlterColumn;
/*      */   }
/*      */   
/*      */   private int parseAction() {
/* 5745 */     Integer integer = parseCascadeOrRestrict();
/* 5746 */     if (integer != null) {
/* 5747 */       return integer.intValue();
/*      */     }
/* 5749 */     if (readIf("NO")) {
/* 5750 */       read("ACTION");
/* 5751 */       return 0;
/*      */     } 
/* 5753 */     read("SET");
/* 5754 */     if (readIf("NULL")) {
/* 5755 */       return 3;
/*      */     }
/* 5757 */     read("DEFAULT");
/* 5758 */     return 2;
/*      */   }
/*      */   
/*      */   private Integer parseCascadeOrRestrict() {
/* 5762 */     if (readIf("CASCADE"))
/* 5763 */       return Integer.valueOf(1); 
/* 5764 */     if (readIf("RESTRICT")) {
/* 5765 */       return Integer.valueOf(0);
/*      */     }
/* 5767 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private DefineCommand parseAlterTableAddConstraintIf(String paramString, Schema paramSchema, boolean paramBoolean) {
/*      */     AlterTableAddConstraint alterTableAddConstraint;
/* 5773 */     String str1 = null, str2 = null;
/* 5774 */     boolean bool1 = false;
/* 5775 */     boolean bool2 = (this.database.getMode()).indexDefinitionInCreateTable;
/* 5776 */     if (readIf("CONSTRAINT")) {
/* 5777 */       bool1 = readIfNotExists();
/* 5778 */       str1 = readIdentifierWithSchema(paramSchema.getName());
/* 5779 */       checkSchema(paramSchema);
/* 5780 */       str2 = readCommentIf();
/* 5781 */       bool2 = true;
/*      */     } 
/* 5783 */     if (readIf("PRIMARY")) {
/* 5784 */       read("KEY");
/* 5785 */       alterTableAddConstraint = new AlterTableAddConstraint(this.session, paramSchema, bool1);
/*      */       
/* 5787 */       alterTableAddConstraint.setType(6);
/* 5788 */       alterTableAddConstraint.setComment(str2);
/* 5789 */       alterTableAddConstraint.setConstraintName(str1);
/* 5790 */       alterTableAddConstraint.setTableName(paramString);
/* 5791 */       alterTableAddConstraint.setIfTableExists(paramBoolean);
/* 5792 */       if (readIf("HASH")) {
/* 5793 */         alterTableAddConstraint.setPrimaryKeyHash(true);
/*      */       }
/* 5795 */       read("(");
/* 5796 */       alterTableAddConstraint.setIndexColumns(parseIndexColumnList());
/* 5797 */       if (readIf("INDEX")) {
/* 5798 */         String str = readIdentifierWithSchema();
/* 5799 */         alterTableAddConstraint.setIndex(getSchema().findIndex(this.session, str));
/*      */       } 
/* 5801 */       return (DefineCommand)alterTableAddConstraint;
/* 5802 */     }  if (bool2 && (isToken("INDEX") || isToken("KEY"))) {
/*      */ 
/*      */       
/* 5805 */       int i = this.lastParseIndex;
/* 5806 */       read();
/* 5807 */       if (DataType.getTypeByName(this.currentToken) != null) {
/*      */         
/* 5809 */         this.parseIndex = i;
/* 5810 */         read();
/* 5811 */         return null;
/*      */       } 
/* 5813 */       CreateIndex createIndex = new CreateIndex(this.session, paramSchema);
/* 5814 */       createIndex.setComment(str2);
/* 5815 */       createIndex.setTableName(paramString);
/* 5816 */       createIndex.setIfTableExists(paramBoolean);
/* 5817 */       if (!readIf("(")) {
/* 5818 */         createIndex.setIndexName(readUniqueIdentifier());
/* 5819 */         read("(");
/*      */       } 
/* 5821 */       createIndex.setIndexColumns(parseIndexColumnList());
/*      */       
/* 5823 */       if (readIf("USING")) {
/* 5824 */         read("BTREE");
/*      */       }
/* 5826 */       return (DefineCommand)createIndex;
/*      */     } 
/*      */     
/* 5829 */     if (readIf("CHECK")) {
/* 5830 */       alterTableAddConstraint = new AlterTableAddConstraint(this.session, paramSchema, bool1);
/* 5831 */       alterTableAddConstraint.setType(3);
/* 5832 */       alterTableAddConstraint.setCheckExpression(readExpression());
/* 5833 */     } else if (readIf("UNIQUE")) {
/* 5834 */       readIf("KEY");
/* 5835 */       readIf("INDEX");
/* 5836 */       alterTableAddConstraint = new AlterTableAddConstraint(this.session, paramSchema, bool1);
/* 5837 */       alterTableAddConstraint.setType(4);
/* 5838 */       if (!readIf("(")) {
/* 5839 */         str1 = readUniqueIdentifier();
/* 5840 */         read("(");
/*      */       } 
/* 5842 */       alterTableAddConstraint.setIndexColumns(parseIndexColumnList());
/* 5843 */       if (readIf("INDEX")) {
/* 5844 */         String str = readIdentifierWithSchema();
/* 5845 */         alterTableAddConstraint.setIndex(getSchema().findIndex(this.session, str));
/*      */       } 
/*      */       
/* 5848 */       if (readIf("USING")) {
/* 5849 */         read("BTREE");
/*      */       }
/* 5851 */     } else if (readIf("FOREIGN")) {
/* 5852 */       alterTableAddConstraint = new AlterTableAddConstraint(this.session, paramSchema, bool1);
/* 5853 */       alterTableAddConstraint.setType(5);
/* 5854 */       read("KEY");
/* 5855 */       read("(");
/* 5856 */       alterTableAddConstraint.setIndexColumns(parseIndexColumnList());
/* 5857 */       if (readIf("INDEX")) {
/* 5858 */         String str = readIdentifierWithSchema();
/* 5859 */         alterTableAddConstraint.setIndex(paramSchema.findIndex(this.session, str));
/*      */       } 
/* 5861 */       read("REFERENCES");
/* 5862 */       parseReferences(alterTableAddConstraint, paramSchema, paramString);
/*      */     } else {
/* 5864 */       if (str1 != null) {
/* 5865 */         throw getSyntaxError();
/*      */       }
/* 5867 */       return null;
/*      */     } 
/* 5869 */     if (readIf("NOCHECK")) {
/* 5870 */       alterTableAddConstraint.setCheckExisting(false);
/*      */     } else {
/* 5872 */       readIf("CHECK");
/* 5873 */       alterTableAddConstraint.setCheckExisting(true);
/*      */     } 
/* 5875 */     alterTableAddConstraint.setTableName(paramString);
/* 5876 */     alterTableAddConstraint.setIfTableExists(paramBoolean);
/* 5877 */     alterTableAddConstraint.setConstraintName(str1);
/* 5878 */     alterTableAddConstraint.setComment(str2);
/* 5879 */     return (DefineCommand)alterTableAddConstraint;
/*      */   }
/*      */ 
/*      */   
/*      */   private void parseReferences(AlterTableAddConstraint paramAlterTableAddConstraint, Schema paramSchema, String paramString) {
/* 5884 */     if (readIf("(")) {
/* 5885 */       paramAlterTableAddConstraint.setRefTableName(paramSchema, paramString);
/* 5886 */       paramAlterTableAddConstraint.setRefIndexColumns(parseIndexColumnList());
/*      */     } else {
/* 5888 */       String str = readIdentifierWithSchema(paramSchema.getName());
/* 5889 */       paramAlterTableAddConstraint.setRefTableName(getSchema(), str);
/* 5890 */       if (readIf("(")) {
/* 5891 */         paramAlterTableAddConstraint.setRefIndexColumns(parseIndexColumnList());
/*      */       }
/*      */     } 
/* 5894 */     if (readIf("INDEX")) {
/* 5895 */       String str = readIdentifierWithSchema();
/* 5896 */       paramAlterTableAddConstraint.setRefIndex(getSchema().findIndex(this.session, str));
/*      */     } 
/* 5898 */     while (readIf("ON")) {
/* 5899 */       if (readIf("DELETE")) {
/* 5900 */         paramAlterTableAddConstraint.setDeleteAction(parseAction()); continue;
/*      */       } 
/* 5902 */       read("UPDATE");
/* 5903 */       paramAlterTableAddConstraint.setUpdateAction(parseAction());
/*      */     } 
/*      */     
/* 5906 */     if (readIf("NOT")) {
/* 5907 */       read("DEFERRABLE");
/*      */     } else {
/* 5909 */       readIf("DEFERRABLE");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private CreateLinkedTable parseCreateLinkedTable(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 5915 */     read("TABLE");
/* 5916 */     boolean bool = readIfNotExists();
/* 5917 */     String str1 = readIdentifierWithSchema();
/* 5918 */     CreateLinkedTable createLinkedTable = new CreateLinkedTable(this.session, getSchema());
/* 5919 */     createLinkedTable.setTemporary(paramBoolean1);
/* 5920 */     createLinkedTable.setGlobalTemporary(paramBoolean2);
/* 5921 */     createLinkedTable.setForce(paramBoolean3);
/* 5922 */     createLinkedTable.setIfNotExists(bool);
/* 5923 */     createLinkedTable.setTableName(str1);
/* 5924 */     createLinkedTable.setComment(readCommentIf());
/* 5925 */     read("(");
/* 5926 */     createLinkedTable.setDriver(readString());
/* 5927 */     read(",");
/* 5928 */     createLinkedTable.setUrl(readString());
/* 5929 */     read(",");
/* 5930 */     createLinkedTable.setUser(readString());
/* 5931 */     read(",");
/* 5932 */     createLinkedTable.setPassword(readString());
/* 5933 */     read(",");
/* 5934 */     String str2 = readString();
/* 5935 */     if (readIf(",")) {
/* 5936 */       createLinkedTable.setOriginalSchema(str2);
/* 5937 */       str2 = readString();
/*      */     } 
/* 5939 */     createLinkedTable.setOriginalTable(str2);
/* 5940 */     read(")");
/* 5941 */     if (readIf("EMIT")) {
/* 5942 */       read("UPDATES");
/* 5943 */       createLinkedTable.setEmitUpdates(true);
/* 5944 */     } else if (readIf("READONLY")) {
/* 5945 */       createLinkedTable.setReadOnly(true);
/*      */     } 
/* 5947 */     return createLinkedTable;
/*      */   }
/*      */ 
/*      */   
/*      */   private CreateTable parseCreateTable(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 5952 */     boolean bool = readIfNotExists();
/* 5953 */     String str = readIdentifierWithSchema();
/* 5954 */     if (paramBoolean1 && paramBoolean2 && equalsToken("SESSION", this.schemaName)) {
/*      */ 
/*      */       
/* 5957 */       this.schemaName = this.session.getCurrentSchemaName();
/* 5958 */       paramBoolean2 = false;
/*      */     } 
/* 5960 */     Schema schema = getSchema();
/* 5961 */     CreateTable createTable = new CreateTable(this.session, schema);
/* 5962 */     createTable.setPersistIndexes(paramBoolean3);
/* 5963 */     createTable.setTemporary(paramBoolean1);
/* 5964 */     createTable.setGlobalTemporary(paramBoolean2);
/* 5965 */     createTable.setIfNotExists(bool);
/* 5966 */     createTable.setTableName(str);
/* 5967 */     createTable.setComment(readCommentIf());
/* 5968 */     if (readIf("(") && 
/* 5969 */       !readIf(")")) {
/*      */       do {
/* 5971 */         DefineCommand defineCommand = parseAlterTableAddConstraintIf(str, schema, false);
/*      */         
/* 5973 */         if (defineCommand != null) {
/* 5974 */           createTable.addConstraintCommand(defineCommand);
/*      */         } else {
/* 5976 */           String str1 = readColumnIdentifier();
/* 5977 */           Column column = parseColumnForTable(str1, true);
/* 5978 */           if (column.isAutoIncrement() && column.isPrimaryKey()) {
/* 5979 */             column.setPrimaryKey(false);
/* 5980 */             IndexColumn[] arrayOfIndexColumn = { new IndexColumn() };
/* 5981 */             (arrayOfIndexColumn[0]).columnName = column.getName();
/* 5982 */             AlterTableAddConstraint alterTableAddConstraint = new AlterTableAddConstraint(this.session, schema, false);
/*      */             
/* 5984 */             alterTableAddConstraint.setType(6);
/* 5985 */             alterTableAddConstraint.setTableName(str);
/* 5986 */             alterTableAddConstraint.setIndexColumns(arrayOfIndexColumn);
/* 5987 */             createTable.addConstraintCommand((DefineCommand)alterTableAddConstraint);
/*      */           } 
/* 5989 */           createTable.addColumn(column);
/* 5990 */           String str2 = null;
/* 5991 */           if (readIf("CONSTRAINT")) {
/* 5992 */             str2 = readColumnIdentifier();
/*      */           }
/* 5994 */           if (readIf("PRIMARY")) {
/* 5995 */             read("KEY");
/* 5996 */             boolean bool1 = readIf("HASH");
/* 5997 */             IndexColumn[] arrayOfIndexColumn = { new IndexColumn() };
/* 5998 */             (arrayOfIndexColumn[0]).columnName = column.getName();
/* 5999 */             AlterTableAddConstraint alterTableAddConstraint = new AlterTableAddConstraint(this.session, schema, false);
/*      */             
/* 6001 */             alterTableAddConstraint.setPrimaryKeyHash(bool1);
/* 6002 */             alterTableAddConstraint.setType(6);
/* 6003 */             alterTableAddConstraint.setTableName(str);
/* 6004 */             alterTableAddConstraint.setIndexColumns(arrayOfIndexColumn);
/* 6005 */             createTable.addConstraintCommand((DefineCommand)alterTableAddConstraint);
/* 6006 */             if (readIf("AUTO_INCREMENT")) {
/* 6007 */               parseAutoIncrement(column);
/*      */             }
/* 6009 */           } else if (readIf("UNIQUE")) {
/* 6010 */             AlterTableAddConstraint alterTableAddConstraint = new AlterTableAddConstraint(this.session, schema, false);
/*      */             
/* 6012 */             alterTableAddConstraint.setConstraintName(str2);
/* 6013 */             alterTableAddConstraint.setType(4);
/* 6014 */             IndexColumn[] arrayOfIndexColumn = { new IndexColumn() };
/* 6015 */             (arrayOfIndexColumn[0]).columnName = str1;
/* 6016 */             alterTableAddConstraint.setIndexColumns(arrayOfIndexColumn);
/* 6017 */             alterTableAddConstraint.setTableName(str);
/* 6018 */             createTable.addConstraintCommand((DefineCommand)alterTableAddConstraint);
/*      */           } 
/* 6020 */           if (readIf("NOT")) {
/* 6021 */             read("NULL");
/* 6022 */             column.setNullable(false);
/*      */           } else {
/* 6024 */             readIf("NULL");
/*      */           } 
/* 6026 */           if (readIf("CHECK")) {
/* 6027 */             Expression expression = readExpression();
/* 6028 */             column.addCheckConstraint(this.session, expression);
/*      */           } 
/* 6030 */           if (readIf("REFERENCES")) {
/* 6031 */             AlterTableAddConstraint alterTableAddConstraint = new AlterTableAddConstraint(this.session, schema, false);
/*      */             
/* 6033 */             alterTableAddConstraint.setConstraintName(str2);
/* 6034 */             alterTableAddConstraint.setType(5);
/* 6035 */             IndexColumn[] arrayOfIndexColumn = { new IndexColumn() };
/* 6036 */             (arrayOfIndexColumn[0]).columnName = str1;
/* 6037 */             alterTableAddConstraint.setIndexColumns(arrayOfIndexColumn);
/* 6038 */             alterTableAddConstraint.setTableName(str);
/* 6039 */             parseReferences(alterTableAddConstraint, schema, str);
/* 6040 */             createTable.addConstraintCommand((DefineCommand)alterTableAddConstraint);
/*      */           } 
/*      */         } 
/* 6043 */       } while (readIfMore());
/*      */     }
/*      */ 
/*      */     
/* 6047 */     if (readIf("COMMENT") && 
/* 6048 */       readIf("="))
/*      */     {
/* 6050 */       readString();
/*      */     }
/*      */     
/* 6053 */     if (readIf("ENGINE"))
/* 6054 */       if (readIf("=")) {
/*      */         
/* 6056 */         String str1 = readUniqueIdentifier();
/* 6057 */         if (!"InnoDb".equalsIgnoreCase(str1))
/*      */         {
/* 6059 */           if (!"MyISAM".equalsIgnoreCase(str1))
/* 6060 */             throw DbException.getUnsupportedException(str1); 
/*      */         }
/*      */       } else {
/* 6063 */         createTable.setTableEngine(readUniqueIdentifier());
/* 6064 */         if (readIf("WITH")) {
/* 6065 */           ArrayList<String> arrayList = New.arrayList();
/*      */           while (true) {
/* 6067 */             arrayList.add(readUniqueIdentifier());
/* 6068 */             if (!readIf(",")) {
/* 6069 */               createTable.setTableEngineParams(arrayList); break;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }  
/* 6074 */     if (readIf("AUTO_INCREMENT")) {
/* 6075 */       read("=");
/* 6076 */       if (this.currentTokenType != 5 || this.currentValue.getType() != 4)
/*      */       {
/* 6078 */         throw DbException.getSyntaxError(this.sqlCommand, this.parseIndex, "integer");
/*      */       }
/*      */       
/* 6081 */       read();
/*      */     } 
/* 6083 */     readIf("DEFAULT");
/* 6084 */     if (readIf("CHARSET")) {
/* 6085 */       read("=");
/* 6086 */       if (!readIf("UTF8")) {
/* 6087 */         read("UTF8MB4");
/*      */       }
/*      */     } 
/* 6090 */     if (paramBoolean1) {
/* 6091 */       if (readIf("ON")) {
/* 6092 */         read("COMMIT");
/* 6093 */         if (readIf("DROP")) {
/* 6094 */           createTable.setOnCommitDrop();
/* 6095 */         } else if (readIf("DELETE")) {
/* 6096 */           read("ROWS");
/* 6097 */           createTable.setOnCommitTruncate();
/*      */         } 
/* 6099 */       } else if (readIf("NOT")) {
/* 6100 */         if (readIf("PERSISTENT")) {
/* 6101 */           createTable.setPersistData(false);
/*      */         } else {
/* 6103 */           read("LOGGED");
/*      */         } 
/*      */       } 
/* 6106 */       if (readIf("TRANSACTIONAL")) {
/* 6107 */         createTable.setTransactional(true);
/*      */       }
/* 6109 */     } else if (!paramBoolean3 && readIf("NOT")) {
/* 6110 */       read("PERSISTENT");
/* 6111 */       createTable.setPersistData(false);
/*      */     } 
/* 6113 */     if (readIf("HIDDEN")) {
/* 6114 */       createTable.setHidden(true);
/*      */     }
/* 6116 */     if (readIf("AS")) {
/* 6117 */       if (readIf("SORTED")) {
/* 6118 */         createTable.setSortedInsertMode(true);
/*      */       }
/* 6120 */       createTable.setQuery(parseSelect());
/*      */     } 
/*      */     
/* 6123 */     if (readIf("ROW_FORMAT") && 
/* 6124 */       readIf("=")) {
/* 6125 */       readColumnIdentifier();
/*      */     }
/*      */     
/* 6128 */     return createTable;
/*      */   }
/*      */   
/*      */   private static int getCompareType(int paramInt) {
/* 6132 */     switch (paramInt) {
/*      */       case 6:
/* 6134 */         return 0;
/*      */       case 7:
/* 6136 */         return 1;
/*      */       case 8:
/* 6138 */         return 2;
/*      */       case 9:
/* 6140 */         return 4;
/*      */       case 10:
/* 6142 */         return 3;
/*      */       case 11:
/* 6144 */         return 5;
/*      */       case 25:
/* 6146 */         return 11;
/*      */     } 
/* 6148 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String quoteIdentifier(String paramString) {
/* 6159 */     if (paramString == null || paramString.length() == 0) {
/* 6160 */       return "\"\"";
/*      */     }
/* 6162 */     char c = paramString.charAt(0);
/*      */     
/* 6164 */     if ((!Character.isLetter(c) && c != '_') || Character.isLowerCase(c))
/* 6165 */       return StringUtils.quoteIdentifier(paramString);  byte b;
/*      */     int i;
/* 6167 */     for (b = 1, i = paramString.length(); b < i; b++) {
/* 6168 */       c = paramString.charAt(b);
/* 6169 */       if ((!Character.isLetterOrDigit(c) && c != '_') || Character.isLowerCase(c))
/*      */       {
/* 6171 */         return StringUtils.quoteIdentifier(paramString);
/*      */       }
/*      */     } 
/* 6174 */     if (isKeyword(paramString, true)) {
/* 6175 */       return StringUtils.quoteIdentifier(paramString);
/*      */     }
/* 6177 */     return paramString;
/*      */   }
/*      */   
/*      */   public void setRightsChecked(boolean paramBoolean) {
/* 6181 */     this.rightsChecked = paramBoolean;
/*      */   }
/*      */   
/*      */   public void setSuppliedParameterList(ArrayList<Parameter> paramArrayList) {
/* 6185 */     this.suppliedParameterList = paramArrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Expression parseExpression(String paramString) {
/* 6195 */     this.parameters = New.arrayList();
/* 6196 */     initialize(paramString);
/* 6197 */     read();
/* 6198 */     return readExpression();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Table parseTableName(String paramString) {
/* 6208 */     this.parameters = New.arrayList();
/* 6209 */     initialize(paramString);
/* 6210 */     read();
/* 6211 */     return readTableOrView();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\Parser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */