/*      */ package org.h2.engine;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import org.h2.command.Command;
/*      */ import org.h2.command.CommandInterface;
/*      */ import org.h2.command.Parser;
/*      */ import org.h2.command.Prepared;
/*      */ import org.h2.command.dml.Query;
/*      */ import org.h2.command.dml.SetTypes;
/*      */ import org.h2.constraint.Constraint;
/*      */ import org.h2.index.Index;
/*      */ import org.h2.index.ViewIndex;
/*      */ import org.h2.jdbc.JdbcConnection;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.message.Trace;
/*      */ import org.h2.message.TraceSystem;
/*      */ import org.h2.mvstore.db.MVTable;
/*      */ import org.h2.mvstore.db.TransactionStore;
/*      */ import org.h2.result.LocalResult;
/*      */ import org.h2.result.Row;
/*      */ import org.h2.result.SortOrder;
/*      */ import org.h2.schema.Schema;
/*      */ import org.h2.store.DataHandler;
/*      */ import org.h2.store.InDoubtTransaction;
/*      */ import org.h2.table.SubQueryInfo;
/*      */ import org.h2.table.Table;
/*      */ import org.h2.table.TableFilter;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.SmallLRUCache;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueArray;
/*      */ import org.h2.value.ValueLong;
/*      */ import org.h2.value.ValueNull;
/*      */ import org.h2.value.ValueString;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Session
/*      */   extends SessionWithState
/*      */ {
/*      */   public static final int LOG_WRITTEN = -1;
/*      */   private static final String SYSTEM_IDENTIFIER_PREFIX = "_";
/*      */   private static int nextSerialId;
/*   69 */   private final int serialId = nextSerialId++;
/*      */   private final Database database;
/*      */   private ConnectionInfo connectionInfo;
/*      */   private final User user;
/*      */   private final int id;
/*   74 */   private final ArrayList<Table> locks = New.arrayList();
/*      */   private final UndoLog undoLog;
/*      */   private boolean autoCommit = true;
/*      */   private Random random;
/*      */   private int lockTimeout;
/*   79 */   private Value lastIdentity = (Value)ValueLong.get(0L);
/*   80 */   private Value lastScopeIdentity = (Value)ValueLong.get(0L);
/*      */   private Value lastTriggerIdentity;
/*   82 */   private int firstUncommittedLog = -1;
/*   83 */   private int firstUncommittedPos = -1;
/*      */   private HashMap<String, Savepoint> savepoints;
/*      */   private HashMap<String, Table> localTempTables;
/*      */   private HashMap<String, Index> localTempTableIndexes;
/*      */   private HashMap<String, Constraint> localTempTableConstraints;
/*      */   private int throttle;
/*      */   private long lastThrottle;
/*      */   private Command currentCommand;
/*      */   private boolean allowLiterals;
/*      */   private String currentSchemaName;
/*      */   private String[] schemaSearchPath;
/*      */   private Trace trace;
/*      */   private HashMap<String, Value> removeLobMap;
/*      */   private int systemIdentifier;
/*      */   private HashMap<String, Procedure> procedures;
/*      */   private boolean undoLogEnabled = true;
/*      */   private boolean redoLogBinary = true;
/*      */   private boolean autoCommitAtTransactionEnd;
/*      */   private String currentTransactionName;
/*      */   private volatile long cancelAt;
/*      */   private boolean closed;
/*  104 */   private final long sessionStart = System.currentTimeMillis();
/*      */   private long transactionStart;
/*      */   private long currentCommandStart;
/*      */   private HashMap<String, Value> variables;
/*      */   private HashSet<LocalResult> temporaryResults;
/*      */   private int queryTimeout;
/*      */   private boolean commitOrRollbackDisabled;
/*      */   private Table waitForLock;
/*      */   private Thread waitForLockThread;
/*      */   private int modificationId;
/*      */   private int objectId;
/*      */   private final int queryCacheSize;
/*      */   private SmallLRUCache<String, Command> queryCache;
/*  117 */   private long modificationMetaID = -1L;
/*      */ 
/*      */   
/*      */   private SubQueryInfo subQueryInfo;
/*      */ 
/*      */   
/*      */   private int parsingView;
/*      */ 
/*      */   
/*      */   private int preparingQueryExpression;
/*      */   
/*      */   private volatile SmallLRUCache<Object, ViewIndex> viewIndexCache;
/*      */   
/*      */   private HashMap<Object, ViewIndex> subQueryIndexCache;
/*      */   
/*      */   private boolean joinBatchEnabled;
/*      */   
/*      */   private boolean forceJoinOrder;
/*      */   
/*      */   private LinkedList<TimeoutValue> temporaryResultLobs;
/*      */   
/*      */   private ArrayList<Value> temporaryLobs;
/*      */   
/*      */   private TransactionStore.Transaction transaction;
/*      */   
/*  142 */   private long startStatement = -1L;
/*      */   
/*      */   public Session(Database paramDatabase, User paramUser, int paramInt) {
/*  145 */     this.database = paramDatabase;
/*  146 */     this.queryTimeout = (paramDatabase.getSettings()).maxQueryTimeout;
/*  147 */     this.queryCacheSize = (paramDatabase.getSettings()).queryCacheSize;
/*  148 */     this.undoLog = new UndoLog(this);
/*  149 */     this.user = paramUser;
/*  150 */     this.id = paramInt;
/*  151 */     Setting setting = paramDatabase.findSetting(SetTypes.getTypeName(6));
/*      */     
/*  153 */     this.lockTimeout = (setting == null) ? 2000 : setting.getIntValue();
/*      */     
/*  155 */     this.currentSchemaName = "PUBLIC";
/*      */   }
/*      */   
/*      */   public void setForceJoinOrder(boolean paramBoolean) {
/*  159 */     this.forceJoinOrder = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isForceJoinOrder() {
/*  163 */     return this.forceJoinOrder;
/*      */   }
/*      */   
/*      */   public void setJoinBatchEnabled(boolean paramBoolean) {
/*  167 */     this.joinBatchEnabled = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isJoinBatchEnabled() {
/*  171 */     return this.joinBatchEnabled;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Row createRow(Value[] paramArrayOfValue, int paramInt) {
/*  182 */     return this.database.createRow(paramArrayOfValue, paramInt);
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
/*      */   public void pushSubQueryInfo(int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder) {
/*  195 */     this.subQueryInfo = new SubQueryInfo(this.subQueryInfo, paramArrayOfint, paramArrayOfTableFilter, paramInt, paramSortOrder);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void popSubQueryInfo() {
/*  202 */     this.subQueryInfo = this.subQueryInfo.getUpper();
/*      */   }
/*      */   
/*      */   public SubQueryInfo getSubQueryInfo() {
/*  206 */     return this.subQueryInfo;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setParsingView(boolean paramBoolean) {
/*  211 */     this.parsingView += paramBoolean ? 1 : -1;
/*  212 */     assert this.parsingView >= 0;
/*      */   }
/*      */   
/*      */   public boolean isParsingView() {
/*  216 */     assert this.parsingView >= 0;
/*  217 */     return (this.parsingView != 0);
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
/*      */   public void optimizeQueryExpression(Query paramQuery) {
/*  229 */     SubQueryInfo subQueryInfo = this.subQueryInfo;
/*  230 */     this.subQueryInfo = null;
/*  231 */     this.preparingQueryExpression++;
/*      */     try {
/*  233 */       paramQuery.prepare();
/*      */     } finally {
/*  235 */       this.subQueryInfo = subQueryInfo;
/*  236 */       this.preparingQueryExpression--;
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isPreparingQueryExpression() {
/*  241 */     assert this.preparingQueryExpression >= 0;
/*  242 */     return (this.preparingQueryExpression != 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public ArrayList<String> getClusterServers() {
/*  247 */     return new ArrayList<>();
/*      */   }
/*      */   
/*      */   public boolean setCommitOrRollbackDisabled(boolean paramBoolean) {
/*  251 */     boolean bool = this.commitOrRollbackDisabled;
/*  252 */     this.commitOrRollbackDisabled = paramBoolean;
/*  253 */     return bool;
/*      */   }
/*      */   
/*      */   private void initVariables() {
/*  257 */     if (this.variables == null) {
/*  258 */       this.variables = this.database.newStringMap();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVariable(String paramString, Value paramValue) {
/*      */     Value value;
/*  269 */     initVariables();
/*  270 */     this.modificationId++;
/*      */     
/*  272 */     if (paramValue == ValueNull.INSTANCE) {
/*  273 */       value = this.variables.remove(paramString);
/*      */     } else {
/*      */       
/*  276 */       paramValue = paramValue.copy(this.database, -1);
/*      */       
/*  278 */       value = this.variables.put(paramString, paramValue);
/*      */     } 
/*  280 */     if (value != null)
/*      */     {
/*  282 */       value.remove();
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
/*      */   public Value getVariable(String paramString) {
/*  295 */     initVariables();
/*  296 */     Value value = this.variables.get(paramString);
/*  297 */     return (value == null) ? (Value)ValueNull.INSTANCE : value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getVariableNames() {
/*  306 */     if (this.variables == null) {
/*  307 */       return new String[0];
/*      */     }
/*  309 */     String[] arrayOfString = new String[this.variables.size()];
/*  310 */     this.variables.keySet().toArray((Object[])arrayOfString);
/*  311 */     return arrayOfString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Table findLocalTempTable(String paramString) {
/*  322 */     if (this.localTempTables == null) {
/*  323 */       return null;
/*      */     }
/*  325 */     return this.localTempTables.get(paramString);
/*      */   }
/*      */   
/*      */   public ArrayList<Table> getLocalTempTables() {
/*  329 */     if (this.localTempTables == null) {
/*  330 */       return New.arrayList();
/*      */     }
/*  332 */     return New.arrayList(this.localTempTables.values());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addLocalTempTable(Table paramTable) {
/*  342 */     if (this.localTempTables == null) {
/*  343 */       this.localTempTables = this.database.newStringMap();
/*      */     }
/*  345 */     if (this.localTempTables.get(paramTable.getName()) != null) {
/*  346 */       throw DbException.get(42101, paramTable.getSQL());
/*      */     }
/*      */     
/*  349 */     this.modificationId++;
/*  350 */     this.localTempTables.put(paramTable.getName(), paramTable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeLocalTempTable(Table paramTable) {
/*  359 */     this.modificationId++;
/*  360 */     this.localTempTables.remove(paramTable.getName());
/*  361 */     synchronized (this.database) {
/*  362 */       paramTable.removeChildrenAndResources(this);
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
/*      */   public Index findLocalTempTableIndex(String paramString) {
/*  374 */     if (this.localTempTableIndexes == null) {
/*  375 */       return null;
/*      */     }
/*  377 */     return this.localTempTableIndexes.get(paramString);
/*      */   }
/*      */   
/*      */   public HashMap<String, Index> getLocalTempTableIndexes() {
/*  381 */     if (this.localTempTableIndexes == null) {
/*  382 */       return New.hashMap();
/*      */     }
/*  384 */     return this.localTempTableIndexes;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addLocalTempTableIndex(Index paramIndex) {
/*  394 */     if (this.localTempTableIndexes == null) {
/*  395 */       this.localTempTableIndexes = this.database.newStringMap();
/*      */     }
/*  397 */     if (this.localTempTableIndexes.get(paramIndex.getName()) != null) {
/*  398 */       throw DbException.get(42111, paramIndex.getSQL());
/*      */     }
/*      */     
/*  401 */     this.localTempTableIndexes.put(paramIndex.getName(), paramIndex);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeLocalTempTableIndex(Index paramIndex) {
/*  410 */     if (this.localTempTableIndexes != null) {
/*  411 */       this.localTempTableIndexes.remove(paramIndex.getName());
/*  412 */       synchronized (this.database) {
/*  413 */         paramIndex.removeChildrenAndResources(this);
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
/*      */   public Constraint findLocalTempTableConstraint(String paramString) {
/*  426 */     if (this.localTempTableConstraints == null) {
/*  427 */       return null;
/*      */     }
/*  429 */     return this.localTempTableConstraints.get(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HashMap<String, Constraint> getLocalTempTableConstraints() {
/*  439 */     if (this.localTempTableConstraints == null) {
/*  440 */       return New.hashMap();
/*      */     }
/*  442 */     return this.localTempTableConstraints;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addLocalTempTableConstraint(Constraint paramConstraint) {
/*  452 */     if (this.localTempTableConstraints == null) {
/*  453 */       this.localTempTableConstraints = this.database.newStringMap();
/*      */     }
/*  455 */     String str = paramConstraint.getName();
/*  456 */     if (this.localTempTableConstraints.get(str) != null) {
/*  457 */       throw DbException.get(90045, paramConstraint.getSQL());
/*      */     }
/*      */     
/*  460 */     this.localTempTableConstraints.put(str, paramConstraint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void removeLocalTempTableConstraint(Constraint paramConstraint) {
/*  469 */     if (this.localTempTableConstraints != null) {
/*  470 */       this.localTempTableConstraints.remove(paramConstraint.getName());
/*  471 */       synchronized (this.database) {
/*  472 */         paramConstraint.removeChildrenAndResources(this);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getAutoCommit() {
/*  479 */     return this.autoCommit;
/*      */   }
/*      */   
/*      */   public User getUser() {
/*  483 */     return this.user;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAutoCommit(boolean paramBoolean) {
/*  488 */     this.autoCommit = paramBoolean;
/*      */   }
/*      */   
/*      */   public int getLockTimeout() {
/*  492 */     return this.lockTimeout;
/*      */   }
/*      */   
/*      */   public void setLockTimeout(int paramInt) {
/*  496 */     this.lockTimeout = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized CommandInterface prepareCommand(String paramString, int paramInt) {
/*  502 */     return (CommandInterface)prepareLocal(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Prepared prepare(String paramString) {
/*  513 */     return prepare(paramString, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Prepared prepare(String paramString, boolean paramBoolean) {
/*  524 */     Parser parser = new Parser(this);
/*  525 */     parser.setRightsChecked(paramBoolean);
/*  526 */     return parser.prepare(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Command prepareLocal(String paramString) {
/*      */     Command command;
/*  537 */     if (this.closed) {
/*  538 */       throw DbException.get(90067, "session closed");
/*      */     }
/*      */ 
/*      */     
/*  542 */     if (this.queryCacheSize > 0) {
/*  543 */       if (this.queryCache == null) {
/*  544 */         this.queryCache = SmallLRUCache.newInstance(this.queryCacheSize);
/*  545 */         this.modificationMetaID = this.database.getModificationMetaId();
/*      */       } else {
/*  547 */         long l = this.database.getModificationMetaId();
/*  548 */         if (l != this.modificationMetaID) {
/*  549 */           this.queryCache.clear();
/*  550 */           this.modificationMetaID = l;
/*      */         } 
/*  552 */         command = (Command)this.queryCache.get(paramString);
/*  553 */         if (command != null && command.canReuse()) {
/*  554 */           command.reuse();
/*  555 */           return command;
/*      */         } 
/*      */       } 
/*      */     }
/*  559 */     Parser parser = new Parser(this);
/*      */     try {
/*  561 */       command = parser.prepareCommand(paramString);
/*      */     } finally {
/*      */       
/*  564 */       this.subQueryIndexCache = null;
/*      */     } 
/*  566 */     command.prepareJoinBatch();
/*  567 */     if (this.queryCache != null && 
/*  568 */       command.isCacheable()) {
/*  569 */       this.queryCache.put(paramString, command);
/*      */     }
/*      */     
/*  572 */     return command;
/*      */   }
/*      */   
/*      */   public Database getDatabase() {
/*  576 */     return this.database;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getPowerOffCount() {
/*  581 */     return this.database.getPowerOffCount();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPowerOffCount(int paramInt) {
/*  586 */     this.database.setPowerOffCount(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void commit(boolean paramBoolean) {
/*  597 */     checkCommitRollback();
/*  598 */     this.currentTransactionName = null;
/*  599 */     this.transactionStart = 0L;
/*  600 */     if (this.transaction != null) {
/*      */ 
/*      */ 
/*      */       
/*  604 */       if (this.locks.size() > 0) {
/*  605 */         byte b; int i; for (b = 0, i = this.locks.size(); b < i; b++) {
/*  606 */           Table table = this.locks.get(b);
/*  607 */           if (table instanceof MVTable) {
/*  608 */             ((MVTable)table).commit();
/*      */           }
/*      */         } 
/*      */       } 
/*  612 */       this.transaction.commit();
/*  613 */       this.transaction = null;
/*      */     } 
/*  615 */     if (containsUncommitted())
/*      */     {
/*      */       
/*  618 */       this.database.commit(this);
/*      */     }
/*  620 */     removeTemporaryLobs(true);
/*  621 */     if (this.undoLog.size() > 0) {
/*      */       
/*  623 */       if (this.database.isMultiVersion()) {
/*  624 */         ArrayList<Row> arrayList = New.arrayList();
/*  625 */         synchronized (this.database) {
/*  626 */           while (this.undoLog.size() > 0) {
/*  627 */             UndoLogRecord undoLogRecord = this.undoLog.getLast();
/*  628 */             undoLogRecord.commit();
/*  629 */             arrayList.add(undoLogRecord.getRow());
/*  630 */             this.undoLog.removeLast(false);
/*      */           }  byte b; int i;
/*  632 */           for (b = 0, i = arrayList.size(); b < i; b++) {
/*  633 */             Row row = arrayList.get(b);
/*  634 */             row.commit();
/*      */           } 
/*      */         } 
/*      */       } 
/*  638 */       this.undoLog.clear();
/*      */     } 
/*  640 */     if (!paramBoolean) {
/*      */ 
/*      */       
/*  643 */       cleanTempTables(false);
/*  644 */       if (this.autoCommitAtTransactionEnd) {
/*  645 */         this.autoCommit = true;
/*  646 */         this.autoCommitAtTransactionEnd = false;
/*      */       } 
/*      */     } 
/*  649 */     endTransaction();
/*      */   }
/*      */   
/*      */   private void removeTemporaryLobs(boolean paramBoolean) {
/*  653 */     if (SysProperties.CHECK2 && 
/*  654 */       this == getDatabase().getLobSession() && !Thread.holdsLock(this) && !Thread.holdsLock(getDatabase()))
/*      */     {
/*  656 */       throw DbException.throwInternalError();
/*      */     }
/*      */     
/*  659 */     if (this.temporaryLobs != null) {
/*  660 */       for (Value value : this.temporaryLobs) {
/*  661 */         if (!value.isLinkedToTable()) {
/*  662 */           value.remove();
/*      */         }
/*      */       } 
/*  665 */       this.temporaryLobs.clear();
/*      */     } 
/*  667 */     if (this.temporaryResultLobs != null && this.temporaryResultLobs.size() > 0) {
/*  668 */       long l = System.currentTimeMillis() - (this.database.getSettings()).lobTimeout;
/*      */       
/*  670 */       while (this.temporaryResultLobs.size() > 0) {
/*  671 */         TimeoutValue timeoutValue = this.temporaryResultLobs.getFirst();
/*  672 */         if (paramBoolean && timeoutValue.created >= l) {
/*      */           break;
/*      */         }
/*  675 */         Value value = ((TimeoutValue)this.temporaryResultLobs.removeFirst()).value;
/*  676 */         if (!value.isLinkedToTable()) {
/*  677 */           value.remove();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void checkCommitRollback() {
/*  684 */     if (this.commitOrRollbackDisabled && this.locks.size() > 0) {
/*  685 */       throw DbException.get(90058);
/*      */     }
/*      */   }
/*      */   
/*      */   private void endTransaction() {
/*  690 */     if (this.removeLobMap != null && this.removeLobMap.size() > 0) {
/*  691 */       if (this.database.getMvStore() == null)
/*      */       {
/*      */         
/*  694 */         this.database.flush();
/*      */       }
/*  696 */       for (Value value : this.removeLobMap.values()) {
/*  697 */         value.remove();
/*      */       }
/*  699 */       this.removeLobMap = null;
/*      */     } 
/*  701 */     unlockAll();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rollback() {
/*  708 */     checkCommitRollback();
/*  709 */     this.currentTransactionName = null;
/*  710 */     boolean bool = false;
/*  711 */     if (this.undoLog.size() > 0) {
/*  712 */       rollbackTo((Savepoint)null, false);
/*  713 */       bool = true;
/*      */     } 
/*  715 */     if (this.transaction != null) {
/*  716 */       rollbackTo((Savepoint)null, false);
/*  717 */       bool = true;
/*      */ 
/*      */       
/*  720 */       this.transaction.commit();
/*  721 */       this.transaction = null;
/*      */     } 
/*  723 */     if (this.locks.size() > 0 || bool) {
/*  724 */       this.database.commit(this);
/*      */     }
/*  726 */     cleanTempTables(false);
/*  727 */     if (this.autoCommitAtTransactionEnd) {
/*  728 */       this.autoCommit = true;
/*  729 */       this.autoCommitAtTransactionEnd = false;
/*      */     } 
/*  731 */     endTransaction();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rollbackTo(Savepoint paramSavepoint, boolean paramBoolean) {
/*  741 */     byte b = (paramSavepoint == null) ? 0 : paramSavepoint.logIndex;
/*  742 */     while (this.undoLog.size() > b) {
/*  743 */       UndoLogRecord undoLogRecord = this.undoLog.getLast();
/*  744 */       undoLogRecord.undo(this);
/*  745 */       this.undoLog.removeLast(paramBoolean);
/*      */     } 
/*  747 */     if (this.transaction != null) {
/*  748 */       long l = (paramSavepoint == null) ? 0L : paramSavepoint.transactionSavepoint;
/*  749 */       HashMap hashMap = this.database.getMvStore().getTables();
/*      */       
/*  751 */       Iterator<TransactionStore.Change> iterator = this.transaction.getChanges(l);
/*  752 */       while (iterator.hasNext()) {
/*  753 */         TransactionStore.Change change = iterator.next();
/*  754 */         MVTable mVTable = (MVTable)hashMap.get(change.mapName);
/*  755 */         if (mVTable != null) {
/*  756 */           boolean bool; Row row; long l1 = ((ValueLong)change.key).getLong();
/*  757 */           ValueArray valueArray = (ValueArray)change.value;
/*      */ 
/*      */           
/*  760 */           if (valueArray == null) {
/*  761 */             bool = false;
/*  762 */             row = mVTable.getRow(this, l1);
/*      */           } else {
/*  764 */             bool = true;
/*  765 */             row = createRow(valueArray.getList(), -1);
/*      */           } 
/*  767 */           row.setKey(l1);
/*  768 */           UndoLogRecord undoLogRecord = new UndoLogRecord((Table)mVTable, bool, row);
/*  769 */           undoLogRecord.undo(this);
/*      */         } 
/*      */       } 
/*      */     } 
/*  773 */     if (this.savepoints != null) {
/*  774 */       String[] arrayOfString = new String[this.savepoints.size()];
/*  775 */       this.savepoints.keySet().toArray((Object[])arrayOfString);
/*  776 */       for (String str : arrayOfString) {
/*  777 */         Savepoint savepoint = this.savepoints.get(str);
/*  778 */         int i = savepoint.logIndex;
/*  779 */         if (i > b) {
/*  780 */           this.savepoints.remove(str);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasPendingTransaction() {
/*  788 */     return (this.undoLog.size() > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Savepoint setSavepoint() {
/*  797 */     Savepoint savepoint = new Savepoint();
/*  798 */     savepoint.logIndex = this.undoLog.size();
/*  799 */     if (this.database.getMvStore() != null) {
/*  800 */       savepoint.transactionSavepoint = getStatementSavepoint();
/*      */     }
/*  802 */     return savepoint;
/*      */   }
/*      */   
/*      */   public int getId() {
/*  806 */     return this.id;
/*      */   }
/*      */ 
/*      */   
/*      */   public void cancel() {
/*  811 */     this.cancelAt = System.currentTimeMillis();
/*      */   }
/*      */ 
/*      */   
/*      */   public void close() {
/*  816 */     if (!this.closed) {
/*      */       try {
/*  818 */         this.database.checkPowerOff();
/*      */ 
/*      */         
/*  821 */         rollback();
/*      */         
/*  823 */         removeTemporaryLobs(false);
/*  824 */         cleanTempTables(true);
/*  825 */         this.undoLog.clear();
/*  826 */         this.database.removeSession(this);
/*      */       } finally {
/*  828 */         this.closed = true;
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
/*      */   public void addLock(Table paramTable) {
/*  840 */     if (SysProperties.CHECK && 
/*  841 */       this.locks.contains(paramTable)) {
/*  842 */       DbException.throwInternalError();
/*      */     }
/*      */     
/*  845 */     this.locks.add(paramTable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void log(Table paramTable, short paramShort, Row paramRow) {
/*  856 */     if (paramTable.isMVStore()) {
/*      */       return;
/*      */     }
/*  859 */     if (this.undoLogEnabled) {
/*  860 */       UndoLogRecord undoLogRecord = new UndoLogRecord(paramTable, paramShort, paramRow);
/*      */ 
/*      */       
/*  863 */       if (SysProperties.CHECK) {
/*  864 */         int i = this.database.getLockMode();
/*  865 */         if (i != 0 && !this.database.isMultiVersion()) {
/*      */           
/*  867 */           String str = undoLogRecord.getTable().getTableType();
/*  868 */           if (this.locks.indexOf(undoLogRecord.getTable()) < 0 && !"TABLE LINK".equals(str) && !"EXTERNAL".equals(str))
/*      */           {
/*      */             
/*  871 */             DbException.throwInternalError();
/*      */           }
/*      */         } 
/*      */       } 
/*  875 */       this.undoLog.add(undoLogRecord);
/*      */     }
/*  877 */     else if (this.database.isMultiVersion()) {
/*      */       
/*  879 */       ArrayList<Index> arrayList = paramTable.getIndexes(); byte b; int i;
/*  880 */       for (b = 0, i = arrayList.size(); b < i; b++) {
/*  881 */         Index index = arrayList.get(b);
/*  882 */         index.commit(paramShort, paramRow);
/*      */       } 
/*  884 */       paramRow.commit();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unlockReadLocks() {
/*  894 */     if (this.database.isMultiVersion()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  899 */     for (byte b = 0; b < this.locks.size(); b++) {
/*  900 */       Table table = this.locks.get(b);
/*  901 */       if (!table.isLockedExclusively()) {
/*  902 */         synchronized (this.database) {
/*  903 */           table.unlock(this);
/*  904 */           this.locks.remove(b);
/*      */         } 
/*  906 */         b--;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void unlock(Table paramTable) {
/*  917 */     this.locks.remove(paramTable);
/*      */   }
/*      */   
/*      */   private void unlockAll() {
/*  921 */     if (SysProperties.CHECK && 
/*  922 */       this.undoLog.size() > 0) {
/*  923 */       DbException.throwInternalError();
/*      */     }
/*      */     
/*  926 */     if (this.locks.size() > 0) {
/*      */       byte b; int i;
/*  928 */       for (b = 0, i = this.locks.size(); b < i; b++) {
/*  929 */         Table table = this.locks.get(b);
/*  930 */         table.unlock(this);
/*      */       } 
/*  932 */       this.locks.clear();
/*      */     } 
/*  934 */     this.savepoints = null;
/*  935 */     this.sessionStateChanged = true;
/*      */   }
/*      */   
/*      */   private void cleanTempTables(boolean paramBoolean) {
/*  939 */     if (this.localTempTables != null && this.localTempTables.size() > 0) {
/*  940 */       synchronized (this.database) {
/*  941 */         Iterator<Table> iterator = this.localTempTables.values().iterator();
/*  942 */         while (iterator.hasNext()) {
/*  943 */           Table table = iterator.next();
/*  944 */           if (paramBoolean || table.getOnCommitDrop()) {
/*  945 */             this.modificationId++;
/*  946 */             table.setModified();
/*  947 */             iterator.remove();
/*  948 */             table.removeChildrenAndResources(this);
/*  949 */             if (paramBoolean)
/*      */             {
/*      */               
/*  952 */               this.database.commit(this); }  continue;
/*      */           } 
/*  954 */           if (table.getOnCommitTruncate()) {
/*  955 */             table.truncate(this);
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/*  960 */         if (paramBoolean) {
/*  961 */           this.database.unlockMeta(this);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public Random getRandom() {
/*  968 */     if (this.random == null) {
/*  969 */       this.random = new Random();
/*      */     }
/*  971 */     return this.random;
/*      */   }
/*      */ 
/*      */   
/*      */   public Trace getTrace() {
/*  976 */     if (this.trace != null && !this.closed) {
/*  977 */       return this.trace;
/*      */     }
/*  979 */     String str = "jdbc[" + this.id + "]";
/*  980 */     if (this.closed) {
/*  981 */       return (new TraceSystem(null)).getTrace(str);
/*      */     }
/*  983 */     this.trace = this.database.getTraceSystem().getTrace(str);
/*  984 */     return this.trace;
/*      */   }
/*      */   
/*      */   public void setLastIdentity(Value paramValue) {
/*  988 */     this.lastIdentity = paramValue;
/*  989 */     this.lastScopeIdentity = paramValue;
/*      */   }
/*      */   
/*      */   public Value getLastIdentity() {
/*  993 */     return this.lastIdentity;
/*      */   }
/*      */   
/*      */   public void setLastScopeIdentity(Value paramValue) {
/*  997 */     this.lastScopeIdentity = paramValue;
/*      */   }
/*      */   
/*      */   public Value getLastScopeIdentity() {
/* 1001 */     return this.lastScopeIdentity;
/*      */   }
/*      */   
/*      */   public void setLastTriggerIdentity(Value paramValue) {
/* 1005 */     this.lastTriggerIdentity = paramValue;
/*      */   }
/*      */   
/*      */   public Value getLastTriggerIdentity() {
/* 1009 */     return this.lastTriggerIdentity;
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
/*      */   public void addLogPos(int paramInt1, int paramInt2) {
/* 1021 */     if (this.firstUncommittedLog == -1) {
/* 1022 */       this.firstUncommittedLog = paramInt1;
/* 1023 */       this.firstUncommittedPos = paramInt2;
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getFirstUncommittedLog() {
/* 1028 */     return this.firstUncommittedLog;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setAllCommitted() {
/* 1036 */     this.firstUncommittedLog = -1;
/* 1037 */     this.firstUncommittedPos = -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsUncommitted() {
/* 1046 */     if (this.database.getMvStore() != null) {
/* 1047 */       return (this.transaction != null);
/*      */     }
/* 1049 */     return (this.firstUncommittedLog != -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addSavepoint(String paramString) {
/* 1058 */     if (this.savepoints == null) {
/* 1059 */       this.savepoints = this.database.newStringMap();
/*      */     }
/* 1061 */     Savepoint savepoint = new Savepoint();
/* 1062 */     savepoint.logIndex = this.undoLog.size();
/* 1063 */     if (this.database.getMvStore() != null) {
/* 1064 */       savepoint.transactionSavepoint = getStatementSavepoint();
/*      */     }
/* 1066 */     this.savepoints.put(paramString, savepoint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rollbackToSavepoint(String paramString) {
/* 1075 */     checkCommitRollback();
/* 1076 */     if (this.savepoints == null) {
/* 1077 */       throw DbException.get(90063, paramString);
/*      */     }
/* 1079 */     Savepoint savepoint = this.savepoints.get(paramString);
/* 1080 */     if (savepoint == null) {
/* 1081 */       throw DbException.get(90063, paramString);
/*      */     }
/* 1083 */     rollbackTo(savepoint, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void prepareCommit(String paramString) {
/* 1092 */     if (this.transaction != null) {
/* 1093 */       this.database.prepareCommit(this, paramString);
/*      */     }
/* 1095 */     if (containsUncommitted())
/*      */     {
/*      */       
/* 1098 */       this.database.prepareCommit(this, paramString);
/*      */     }
/* 1100 */     this.currentTransactionName = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPreparedTransaction(String paramString, boolean paramBoolean) {
/* 1110 */     if (this.currentTransactionName != null && this.currentTransactionName.equals(paramString)) {
/*      */       
/* 1112 */       if (paramBoolean) {
/* 1113 */         commit(false);
/*      */       } else {
/* 1115 */         rollback();
/*      */       } 
/*      */     } else {
/* 1118 */       ArrayList<InDoubtTransaction> arrayList = this.database.getInDoubtTransactions();
/*      */       
/* 1120 */       boolean bool1 = paramBoolean ? true : true;
/*      */       
/* 1122 */       boolean bool2 = false;
/* 1123 */       if (arrayList != null) {
/* 1124 */         for (InDoubtTransaction inDoubtTransaction : arrayList) {
/* 1125 */           if (inDoubtTransaction.getTransactionName().equals(paramString)) {
/* 1126 */             inDoubtTransaction.setState(bool1);
/* 1127 */             bool2 = true;
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/* 1132 */       if (!bool2) {
/* 1133 */         throw DbException.get(90129, paramString);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isClosed() {
/* 1141 */     return this.closed;
/*      */   }
/*      */   
/*      */   public void setThrottle(int paramInt) {
/* 1145 */     this.throttle = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void throttle() {
/* 1152 */     if (this.currentCommandStart == 0L) {
/* 1153 */       this.currentCommandStart = System.currentTimeMillis();
/*      */     }
/* 1155 */     if (this.throttle == 0) {
/*      */       return;
/*      */     }
/* 1158 */     long l = System.currentTimeMillis();
/* 1159 */     if (this.lastThrottle + 50L > l) {
/*      */       return;
/*      */     }
/* 1162 */     this.lastThrottle = l + this.throttle;
/*      */     try {
/* 1164 */       Thread.sleep(this.throttle);
/* 1165 */     } catch (Exception exception) {}
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
/*      */   public void setCurrentCommand(Command paramCommand) {
/* 1177 */     this.currentCommand = paramCommand;
/* 1178 */     if (this.queryTimeout > 0 && paramCommand != null) {
/* 1179 */       long l = System.currentTimeMillis();
/* 1180 */       this.currentCommandStart = l;
/* 1181 */       this.cancelAt = l + this.queryTimeout;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void checkCanceled() {
/* 1192 */     throttle();
/* 1193 */     if (this.cancelAt == 0L) {
/*      */       return;
/*      */     }
/* 1196 */     long l = System.currentTimeMillis();
/* 1197 */     if (l >= this.cancelAt) {
/* 1198 */       this.cancelAt = 0L;
/* 1199 */       throw DbException.get(57014);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getCancel() {
/* 1209 */     return this.cancelAt;
/*      */   }
/*      */   
/*      */   public Command getCurrentCommand() {
/* 1213 */     return this.currentCommand;
/*      */   }
/*      */   
/*      */   public long getCurrentCommandStart() {
/* 1217 */     return this.currentCommandStart;
/*      */   }
/*      */   
/*      */   public boolean getAllowLiterals() {
/* 1221 */     return this.allowLiterals;
/*      */   }
/*      */   
/*      */   public void setAllowLiterals(boolean paramBoolean) {
/* 1225 */     this.allowLiterals = paramBoolean;
/*      */   }
/*      */   
/*      */   public void setCurrentSchema(Schema paramSchema) {
/* 1229 */     this.modificationId++;
/* 1230 */     this.currentSchemaName = paramSchema.getName();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCurrentSchemaName() {
/* 1235 */     return this.currentSchemaName;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setCurrentSchemaName(String paramString) {
/* 1240 */     Schema schema = this.database.getSchema(paramString);
/* 1241 */     setCurrentSchema(schema);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JdbcConnection createConnection(boolean paramBoolean) {
/*      */     String str;
/* 1253 */     if (paramBoolean) {
/* 1254 */       str = "jdbc:columnlist:connection";
/*      */     } else {
/* 1256 */       str = "jdbc:default:connection";
/*      */     } 
/* 1258 */     return new JdbcConnection(this, getUser().getName(), str);
/*      */   }
/*      */ 
/*      */   
/*      */   public DataHandler getDataHandler() {
/* 1263 */     return this.database;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeAtCommit(Value paramValue) {
/* 1272 */     if (SysProperties.CHECK && !paramValue.isLinkedToTable()) {
/* 1273 */       DbException.throwInternalError();
/*      */     }
/* 1275 */     if (this.removeLobMap == null) {
/* 1276 */       this.removeLobMap = New.hashMap();
/* 1277 */       this.removeLobMap.put(paramValue.toString(), paramValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeAtCommitStop(Value paramValue) {
/* 1287 */     if (this.removeLobMap != null) {
/* 1288 */       this.removeLobMap.remove(paramValue.toString());
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
/*      */   public String getNextSystemIdentifier(String paramString) {
/*      */     while (true) {
/* 1302 */       String str = "_" + this.systemIdentifier++;
/* 1303 */       if (!paramString.contains(str)) {
/* 1304 */         return str;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addProcedure(Procedure paramProcedure) {
/* 1313 */     if (this.procedures == null) {
/* 1314 */       this.procedures = this.database.newStringMap();
/*      */     }
/* 1316 */     this.procedures.put(paramProcedure.getName(), paramProcedure);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeProcedure(String paramString) {
/* 1325 */     if (this.procedures != null) {
/* 1326 */       this.procedures.remove(paramString);
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
/*      */   public Procedure getProcedure(String paramString) {
/* 1338 */     if (this.procedures == null) {
/* 1339 */       return null;
/*      */     }
/* 1341 */     return this.procedures.get(paramString);
/*      */   }
/*      */   
/*      */   public void setSchemaSearchPath(String[] paramArrayOfString) {
/* 1345 */     this.modificationId++;
/* 1346 */     this.schemaSearchPath = paramArrayOfString;
/*      */   }
/*      */   
/*      */   public String[] getSchemaSearchPath() {
/* 1350 */     return this.schemaSearchPath;
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1355 */     return this.serialId;
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1360 */     return "#" + this.serialId + " (user: " + this.user.getName() + ")";
/*      */   }
/*      */   
/*      */   public void setUndoLogEnabled(boolean paramBoolean) {
/* 1364 */     this.undoLogEnabled = paramBoolean;
/*      */   }
/*      */   
/*      */   public void setRedoLogBinary(boolean paramBoolean) {
/* 1368 */     this.redoLogBinary = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isUndoLogEnabled() {
/* 1372 */     return this.undoLogEnabled;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void begin() {
/* 1379 */     this.autoCommitAtTransactionEnd = true;
/* 1380 */     this.autoCommit = false;
/*      */   }
/*      */   
/*      */   public long getSessionStart() {
/* 1384 */     return this.sessionStart;
/*      */   }
/*      */   
/*      */   public long getTransactionStart() {
/* 1388 */     if (this.transactionStart == 0L) {
/* 1389 */       this.transactionStart = System.currentTimeMillis();
/*      */     }
/* 1391 */     return this.transactionStart;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table[] getLocks() {
/* 1396 */     ArrayList arrayList = New.arrayList();
/* 1397 */     for (byte b = 0; b < this.locks.size(); b++) {
/*      */       try {
/* 1399 */         arrayList.add(this.locks.get(b));
/* 1400 */       } catch (Exception exception) {
/*      */         break;
/*      */       } 
/*      */     } 
/*      */     
/* 1405 */     Table[] arrayOfTable = new Table[arrayList.size()];
/* 1406 */     arrayList.toArray((Object[])arrayOfTable);
/* 1407 */     return arrayOfTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void waitIfExclusiveModeEnabled() {
/* 1417 */     if (this.database.getLobSession() == this) {
/*      */       return;
/*      */     }
/*      */     while (true) {
/* 1421 */       Session session = this.database.getExclusiveSession();
/* 1422 */       if (session == null || session == this) {
/*      */         break;
/*      */       }
/* 1425 */       if (Thread.holdsLock(session)) {
/*      */         break;
/*      */       }
/*      */       
/*      */       try {
/* 1430 */         Thread.sleep(100L);
/* 1431 */       } catch (InterruptedException interruptedException) {}
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
/*      */   public Map<Object, ViewIndex> getViewIndexCache(boolean paramBoolean) {
/* 1446 */     if (paramBoolean) {
/*      */ 
/*      */ 
/*      */       
/* 1450 */       if (this.subQueryIndexCache == null) {
/* 1451 */         this.subQueryIndexCache = New.hashMap();
/*      */       }
/* 1453 */       return this.subQueryIndexCache;
/*      */     } 
/* 1455 */     SmallLRUCache<Object, ViewIndex> smallLRUCache = this.viewIndexCache;
/* 1456 */     if (smallLRUCache == null) {
/* 1457 */       this.viewIndexCache = smallLRUCache = SmallLRUCache.newInstance(64);
/*      */     }
/* 1459 */     return (Map<Object, ViewIndex>)smallLRUCache;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addTemporaryResult(LocalResult paramLocalResult) {
/* 1470 */     if (!paramLocalResult.needToClose()) {
/*      */       return;
/*      */     }
/* 1473 */     if (this.temporaryResults == null) {
/* 1474 */       this.temporaryResults = New.hashSet();
/*      */     }
/* 1476 */     if (this.temporaryResults.size() < 100)
/*      */     {
/* 1478 */       this.temporaryResults.add(paramLocalResult);
/*      */     }
/*      */   }
/*      */   
/*      */   private void closeTemporaryResults() {
/* 1483 */     if (this.temporaryResults != null) {
/* 1484 */       for (LocalResult localResult : this.temporaryResults) {
/* 1485 */         localResult.close();
/*      */       }
/* 1487 */       this.temporaryResults = null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setQueryTimeout(int paramInt) {
/* 1492 */     int i = (this.database.getSettings()).maxQueryTimeout;
/* 1493 */     if (i != 0 && (i < paramInt || paramInt == 0))
/*      */     {
/* 1495 */       paramInt = i;
/*      */     }
/* 1497 */     this.queryTimeout = paramInt;
/*      */ 
/*      */     
/* 1500 */     this.cancelAt = 0L;
/*      */   }
/*      */   
/*      */   public int getQueryTimeout() {
/* 1504 */     return this.queryTimeout;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWaitForLock(Table paramTable, Thread paramThread) {
/* 1515 */     this.waitForLock = paramTable;
/* 1516 */     this.waitForLockThread = paramThread;
/*      */   }
/*      */   
/*      */   public Table getWaitForLock() {
/* 1520 */     return this.waitForLock;
/*      */   }
/*      */   
/*      */   public Thread getWaitForLockThread() {
/* 1524 */     return this.waitForLockThread;
/*      */   }
/*      */   
/*      */   public int getModificationId() {
/* 1528 */     return this.modificationId;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isReconnectNeeded(boolean paramBoolean) {
/*      */     while (true) {
/* 1534 */       boolean bool = this.database.isReconnectNeeded();
/* 1535 */       if (bool) {
/* 1536 */         return true;
/*      */       }
/* 1538 */       if (paramBoolean) {
/* 1539 */         if (this.database.beforeWriting())
/* 1540 */           return false;  continue;
/*      */       }  break;
/*      */     } 
/* 1543 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void afterWriting() {
/* 1550 */     this.database.afterWriting();
/*      */   }
/*      */ 
/*      */   
/*      */   public SessionInterface reconnect(boolean paramBoolean) {
/* 1555 */     readSessionState();
/* 1556 */     close();
/* 1557 */     Session session = Engine.getInstance().createSession(this.connectionInfo);
/* 1558 */     session.sessionState = this.sessionState;
/* 1559 */     session.recreateSessionState();
/* 1560 */     if (paramBoolean) {
/* 1561 */       while (!session.database.beforeWriting());
/*      */     }
/*      */ 
/*      */     
/* 1565 */     return session;
/*      */   }
/*      */   
/*      */   public void setConnectionInfo(ConnectionInfo paramConnectionInfo) {
/* 1569 */     this.connectionInfo = paramConnectionInfo;
/*      */   }
/*      */   
/*      */   public Value getTransactionId() {
/* 1573 */     if (this.database.getMvStore() != null) {
/* 1574 */       if (this.transaction == null) {
/* 1575 */         return (Value)ValueNull.INSTANCE;
/*      */       }
/* 1577 */       return ValueString.get(Long.toString(getTransaction().getId()));
/*      */     } 
/* 1579 */     if (!this.database.isPersistent()) {
/* 1580 */       return (Value)ValueNull.INSTANCE;
/*      */     }
/* 1582 */     if (this.undoLog.size() == 0) {
/* 1583 */       return (Value)ValueNull.INSTANCE;
/*      */     }
/* 1585 */     return ValueString.get(this.firstUncommittedLog + "-" + this.firstUncommittedPos + "-" + this.id);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nextObjectId() {
/* 1595 */     return this.objectId++;
/*      */   }
/*      */   
/*      */   public boolean isRedoLogBinaryEnabled() {
/* 1599 */     return this.redoLogBinary;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TransactionStore.Transaction getTransaction() {
/* 1608 */     if (this.transaction == null) {
/* 1609 */       if (this.database.getMvStore().getStore().isClosed()) {
/* 1610 */         this.database.shutdownImmediately();
/* 1611 */         throw DbException.get(90098);
/*      */       } 
/* 1613 */       this.transaction = this.database.getMvStore().getTransactionStore().begin();
/* 1614 */       this.startStatement = -1L;
/*      */     } 
/* 1616 */     return this.transaction;
/*      */   }
/*      */   
/*      */   public long getStatementSavepoint() {
/* 1620 */     if (this.startStatement == -1L) {
/* 1621 */       this.startStatement = getTransaction().setSavepoint();
/*      */     }
/* 1623 */     return this.startStatement;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void startStatementWithinTransaction() {
/* 1630 */     this.startStatement = -1L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void endStatement() {
/* 1638 */     this.startStatement = -1L;
/* 1639 */     closeTemporaryResults();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearViewIndexCache() {
/* 1646 */     this.viewIndexCache = null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void addTemporaryLob(Value paramValue) {
/* 1651 */     if (paramValue.getType() != 16 && paramValue.getType() != 15) {
/*      */       return;
/*      */     }
/* 1654 */     if (paramValue.getTableId() == -3 || paramValue.getTableId() == -2) {
/*      */       
/* 1656 */       if (this.temporaryResultLobs == null) {
/* 1657 */         this.temporaryResultLobs = new LinkedList<>();
/*      */       }
/* 1659 */       this.temporaryResultLobs.add(new TimeoutValue(paramValue));
/*      */     } else {
/* 1661 */       if (this.temporaryLobs == null) {
/* 1662 */         this.temporaryLobs = new ArrayList<>();
/*      */       }
/* 1664 */       this.temporaryLobs.add(paramValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isRemote() {
/* 1670 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Savepoint
/*      */   {
/*      */     int logIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     long transactionSavepoint;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class TimeoutValue
/*      */   {
/* 1698 */     final long created = System.currentTimeMillis();
/*      */ 
/*      */     
/*      */     final Value value;
/*      */ 
/*      */ 
/*      */     
/*      */     TimeoutValue(Value param1Value) {
/* 1706 */       this.value = param1Value;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\Session.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */