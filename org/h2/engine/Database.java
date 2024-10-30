/*      */ package org.h2.engine;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.sql.SQLException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Properties;
/*      */ import java.util.Set;
/*      */ import java.util.StringTokenizer;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import org.h2.api.DatabaseEventListener;
/*      */ import org.h2.api.JavaObjectSerializer;
/*      */ import org.h2.api.TableEngine;
/*      */ import org.h2.command.ddl.CreateTableData;
/*      */ import org.h2.command.dml.SetTypes;
/*      */ import org.h2.constraint.Constraint;
/*      */ import org.h2.index.Cursor;
/*      */ import org.h2.index.Index;
/*      */ import org.h2.index.IndexType;
/*      */ import org.h2.jdbc.JdbcConnection;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.message.Trace;
/*      */ import org.h2.message.TraceSystem;
/*      */ import org.h2.mvstore.db.MVTableEngine;
/*      */ import org.h2.result.Row;
/*      */ import org.h2.result.RowFactory;
/*      */ import org.h2.result.SearchRow;
/*      */ import org.h2.schema.Schema;
/*      */ import org.h2.schema.SchemaObject;
/*      */ import org.h2.schema.Sequence;
/*      */ import org.h2.schema.TriggerObject;
/*      */ import org.h2.store.DataHandler;
/*      */ import org.h2.store.FileLock;
/*      */ import org.h2.store.FileStore;
/*      */ import org.h2.store.InDoubtTransaction;
/*      */ import org.h2.store.LobStorageBackend;
/*      */ import org.h2.store.LobStorageInterface;
/*      */ import org.h2.store.LobStorageMap;
/*      */ import org.h2.store.PageStore;
/*      */ import org.h2.store.WriterThread;
/*      */ import org.h2.store.fs.FileUtils;
/*      */ import org.h2.table.Column;
/*      */ import org.h2.table.IndexColumn;
/*      */ import org.h2.table.MetaTable;
/*      */ import org.h2.table.Table;
/*      */ import org.h2.table.TableLinkConnection;
/*      */ import org.h2.table.TableView;
/*      */ import org.h2.tools.DeleteDbFiles;
/*      */ import org.h2.tools.Server;
/*      */ import org.h2.util.BitField;
/*      */ import org.h2.util.JdbcUtils;
/*      */ import org.h2.util.MathUtils;
/*      */ import org.h2.util.NetUtils;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.SmallLRUCache;
/*      */ import org.h2.util.SourceCompiler;
/*      */ import org.h2.util.StringUtils;
/*      */ import org.h2.util.TempFileDeleter;
/*      */ import org.h2.util.Utils;
/*      */ import org.h2.value.CaseInsensitiveConcurrentMap;
/*      */ import org.h2.value.CaseInsensitiveMap;
/*      */ import org.h2.value.CompareMode;
/*      */ import org.h2.value.NullableKeyConcurrentMap;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueInt;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Database
/*      */   implements DataHandler
/*      */ {
/*      */   private static int initialPowerOffCount;
/*      */   private static final String SYSTEM_USER_NAME = "DBA";
/*      */   private final boolean persistent;
/*      */   private final String databaseName;
/*      */   private final String databaseShortName;
/*      */   private final String databaseURL;
/*      */   private final String cipher;
/*      */   private final byte[] filePasswordHash;
/*      */   private final byte[] fileEncryptionKey;
/*  103 */   private final HashMap<String, Role> roles = New.hashMap();
/*  104 */   private final HashMap<String, User> users = New.hashMap();
/*  105 */   private final HashMap<String, Setting> settings = New.hashMap();
/*  106 */   private final HashMap<String, Schema> schemas = New.hashMap();
/*  107 */   private final HashMap<String, Right> rights = New.hashMap();
/*  108 */   private final HashMap<String, UserDataType> userDataTypes = New.hashMap();
/*  109 */   private final HashMap<String, UserAggregate> aggregates = New.hashMap();
/*  110 */   private final HashMap<String, Comment> comments = New.hashMap();
/*  111 */   private final HashMap<String, TableEngine> tableEngines = New.hashMap();
/*      */   
/*  113 */   private final Set<Session> userSessions = Collections.synchronizedSet(new HashSet<>());
/*      */   
/*      */   private Session exclusiveSession;
/*  116 */   private final BitField objectIds = new BitField();
/*  117 */   private final Object lobSyncObject = new Object();
/*      */   
/*      */   private Schema mainSchema;
/*      */   private Schema infoSchema;
/*      */   private int nextSessionId;
/*      */   private int nextTempTableId;
/*      */   private User systemUser;
/*      */   private Session systemSession;
/*      */   private Session lobSession;
/*      */   private Table meta;
/*      */   private Index metaIdIndex;
/*      */   private FileLock lock;
/*      */   private WriterThread writer;
/*      */   private boolean starting;
/*      */   private TraceSystem traceSystem;
/*      */   private Trace trace;
/*      */   private final int fileLockMethod;
/*      */   private Role publicRole;
/*      */   private long modificationDataId;
/*      */   private long modificationMetaId;
/*      */   private CompareMode compareMode;
/*  138 */   private String cluster = "''";
/*      */   private boolean readOnly;
/*  140 */   private int writeDelay = 500;
/*      */   private DatabaseEventListener eventListener;
/*  142 */   private int maxMemoryRows = SysProperties.MAX_MEMORY_ROWS;
/*  143 */   private int maxMemoryUndo = 50000;
/*  144 */   private int lockMode = 3;
/*      */   private int maxLengthInplaceLob;
/*  146 */   private int allowLiterals = 2;
/*      */   
/*  148 */   private int powerOffCount = initialPowerOffCount;
/*      */   private int closeDelay;
/*      */   private DatabaseCloser delayedCloser;
/*      */   private volatile boolean closing;
/*      */   private boolean ignoreCase;
/*      */   private boolean deleteFilesOnDisconnect;
/*      */   private String lobCompressionAlgorithm;
/*      */   private boolean optimizeReuseResults = true;
/*      */   private final String cacheType;
/*      */   private final String accessModeData;
/*      */   private boolean referentialIntegrity = true;
/*      */   private boolean multiVersion;
/*      */   private DatabaseCloser closeOnExit;
/*  161 */   private Mode mode = Mode.getInstance("REGULAR");
/*      */   private boolean multiThreaded;
/*  163 */   private int maxOperationMemory = 100000;
/*      */   
/*      */   private SmallLRUCache<String, String[]> lobFileListCache;
/*      */   private final boolean autoServerMode;
/*      */   private final int autoServerPort;
/*      */   private Server server;
/*      */   private HashMap<TableLinkConnection, TableLinkConnection> linkConnections;
/*  170 */   private final TempFileDeleter tempFileDeleter = TempFileDeleter.getInstance();
/*      */   private PageStore pageStore;
/*      */   private Properties reconnectLastLock;
/*      */   private volatile long reconnectCheckNext;
/*      */   private volatile boolean reconnectChangePending;
/*      */   private volatile int checkpointAllowed;
/*      */   private volatile boolean checkpointRunning;
/*  177 */   private final Object reconnectSync = new Object();
/*      */   private int cacheSize;
/*      */   private int compactMode;
/*      */   private SourceCompiler compiler;
/*      */   private volatile boolean metaTablesInitialized;
/*      */   private boolean flushOnEachCommit;
/*      */   private LobStorageInterface lobStorage;
/*      */   private final int pageSize;
/*  185 */   private int defaultTableType = 0;
/*      */   private final DbSettings dbSettings;
/*      */   private final int reconnectCheckDelay;
/*      */   private int logMode;
/*      */   private MVTableEngine.Store mvStore;
/*      */   private int retentionTime;
/*      */   private DbException backgroundException;
/*      */   private JavaObjectSerializer javaObjectSerializer;
/*      */   private String javaObjectSerializerName;
/*      */   private volatile boolean javaObjectSerializerInitialized;
/*      */   private boolean queryStatistics;
/*  196 */   private int queryStatisticsMaxEntries = 100;
/*      */   private QueryStatisticsData queryStatisticsData;
/*  198 */   private RowFactory rowFactory = RowFactory.DEFAULT;
/*      */   
/*      */   public Database(ConnectionInfo paramConnectionInfo, String paramString) {
/*  201 */     String str1 = paramConnectionInfo.getName();
/*  202 */     this.dbSettings = paramConnectionInfo.getDbSettings();
/*  203 */     this.reconnectCheckDelay = this.dbSettings.reconnectCheckDelay;
/*  204 */     this.compareMode = CompareMode.getInstance(null, 0);
/*  205 */     this.persistent = paramConnectionInfo.isPersistent();
/*  206 */     this.filePasswordHash = paramConnectionInfo.getFilePasswordHash();
/*  207 */     this.fileEncryptionKey = paramConnectionInfo.getFileEncryptionKey();
/*  208 */     this.databaseName = str1;
/*  209 */     this.databaseShortName = parseDatabaseShortName();
/*  210 */     this.maxLengthInplaceLob = 256;
/*  211 */     this.cipher = paramString;
/*  212 */     String str2 = paramConnectionInfo.getProperty("FILE_LOCK", (String)null);
/*  213 */     this.accessModeData = StringUtils.toLowerEnglish(paramConnectionInfo.getProperty("ACCESS_MODE_DATA", "rw"));
/*      */     
/*  215 */     this.autoServerMode = paramConnectionInfo.getProperty("AUTO_SERVER", false);
/*  216 */     this.autoServerPort = paramConnectionInfo.getProperty("AUTO_SERVER_PORT", 0);
/*  217 */     int i = Utils.scaleForAvailableMemory(65536);
/*      */     
/*  219 */     this.cacheSize = paramConnectionInfo.getProperty("CACHE_SIZE", i);
/*      */     
/*  221 */     this.pageSize = paramConnectionInfo.getProperty("PAGE_SIZE", 4096);
/*      */     
/*  223 */     if ("r".equals(this.accessModeData)) {
/*  224 */       this.readOnly = true;
/*      */     }
/*  226 */     if (this.dbSettings.mvStore && str2 == null) {
/*  227 */       if (this.autoServerMode) {
/*  228 */         this.fileLockMethod = 1;
/*      */       } else {
/*  230 */         this.fileLockMethod = 4;
/*      */       } 
/*      */     } else {
/*  233 */       this.fileLockMethod = FileLock.getFileLockMethod(str2);
/*      */     } 
/*  235 */     if (this.dbSettings.mvStore && this.fileLockMethod == 3) {
/*  236 */       throw DbException.getUnsupportedException("MV_STORE combined with FILE_LOCK=SERIALIZED");
/*      */     }
/*      */     
/*  239 */     this.databaseURL = paramConnectionInfo.getURL();
/*  240 */     String str3 = paramConnectionInfo.removeProperty("DATABASE_EVENT_LISTENER", (String)null);
/*  241 */     if (str3 != null) {
/*  242 */       str3 = StringUtils.trim(str3, true, true, "'");
/*  243 */       setEventListenerClass(str3);
/*      */     } 
/*  245 */     String str4 = paramConnectionInfo.removeProperty("MODE", (String)null);
/*  246 */     if (str4 != null) {
/*  247 */       this.mode = Mode.getInstance(str4);
/*      */     }
/*  249 */     this.multiVersion = paramConnectionInfo.getProperty("MVCC", this.dbSettings.mvStore);
/*      */     
/*  251 */     this.logMode = paramConnectionInfo.getProperty("LOG", 2);
/*      */     
/*  253 */     this.javaObjectSerializerName = paramConnectionInfo.getProperty("JAVA_OBJECT_SERIALIZER", (String)null);
/*      */     
/*  255 */     this.multiThreaded = paramConnectionInfo.getProperty("MULTI_THREADED", false);
/*      */     
/*  257 */     boolean bool = this.dbSettings.dbCloseOnExit;
/*      */     
/*  259 */     int j = paramConnectionInfo.getIntProperty(10, 1);
/*      */ 
/*      */     
/*  262 */     int k = paramConnectionInfo.getIntProperty(9, 0);
/*      */ 
/*      */     
/*  265 */     this.cacheType = StringUtils.toUpperEnglish(paramConnectionInfo.removeProperty("CACHE_TYPE", "LRU"));
/*      */     
/*  267 */     openDatabase(j, k, bool);
/*      */   }
/*      */ 
/*      */   
/*      */   private void openDatabase(int paramInt1, int paramInt2, boolean paramBoolean) {
/*      */     try {
/*  273 */       open(paramInt1, paramInt2);
/*  274 */       if (paramBoolean) {
/*      */         try {
/*  276 */           this.closeOnExit = new DatabaseCloser(this, 0, true);
/*  277 */           Runtime.getRuntime().addShutdownHook(this.closeOnExit);
/*  278 */         } catch (IllegalStateException illegalStateException) {
/*      */ 
/*      */         
/*      */         }
/*  282 */         catch (SecurityException securityException) {}
/*      */ 
/*      */       
/*      */       }
/*      */     
/*      */     }
/*  288 */     catch (Throwable throwable) {
/*  289 */       if (throwable instanceof OutOfMemoryError) {
/*  290 */         throwable.fillInStackTrace();
/*      */       }
/*  292 */       if (this.traceSystem != null) {
/*  293 */         if (throwable instanceof SQLException) {
/*  294 */           SQLException sQLException = (SQLException)throwable;
/*  295 */           if (sQLException.getErrorCode() != 90020)
/*      */           {
/*      */             
/*  298 */             this.trace.error(throwable, "opening {0}", new Object[] { this.databaseName });
/*      */           }
/*      */         } 
/*  301 */         this.traceSystem.close();
/*      */       } 
/*  303 */       closeOpenFilesAndUnlock(false);
/*  304 */       throw DbException.convert(throwable);
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
/*      */   public Row createRow(Value[] paramArrayOfValue, int paramInt) {
/*  316 */     return this.rowFactory.createRow(paramArrayOfValue, paramInt);
/*      */   }
/*      */   
/*      */   public RowFactory getRowFactory() {
/*  320 */     return this.rowFactory;
/*      */   }
/*      */   
/*      */   public void setRowFactory(RowFactory paramRowFactory) {
/*  324 */     this.rowFactory = paramRowFactory;
/*      */   }
/*      */   
/*      */   public static void setInitialPowerOffCount(int paramInt) {
/*  328 */     initialPowerOffCount = paramInt;
/*      */   }
/*      */   
/*      */   public void setPowerOffCount(int paramInt) {
/*  332 */     if (this.powerOffCount == -1) {
/*      */       return;
/*      */     }
/*  335 */     this.powerOffCount = paramInt;
/*      */   }
/*      */   
/*      */   public MVTableEngine.Store getMvStore() {
/*  339 */     return this.mvStore;
/*      */   }
/*      */   
/*      */   public void setMvStore(MVTableEngine.Store paramStore) {
/*  343 */     this.mvStore = paramStore;
/*  344 */     this.retentionTime = paramStore.getStore().getRetentionTime();
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
/*      */   public boolean areEqual(Value paramValue1, Value paramValue2) {
/*  356 */     return (paramValue1.compareTo(paramValue2, this.compareMode) == 0);
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
/*      */   public int compare(Value paramValue1, Value paramValue2) {
/*  369 */     return paramValue1.compareTo(paramValue2, this.compareMode);
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
/*      */   public int compareTypeSafe(Value paramValue1, Value paramValue2) {
/*  382 */     return paramValue1.compareTypeSafe(paramValue2, this.compareMode);
/*      */   }
/*      */   
/*      */   public long getModificationDataId() {
/*  386 */     return this.modificationDataId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private synchronized boolean reconnectModified(boolean paramBoolean) {
/*  397 */     if (this.readOnly || this.lock == null || this.fileLockMethod != 3)
/*      */     {
/*  399 */       return true;
/*      */     }
/*      */     try {
/*  402 */       if (paramBoolean == this.reconnectChangePending) {
/*  403 */         long l = System.currentTimeMillis();
/*  404 */         if (l > this.reconnectCheckNext) {
/*  405 */           if (paramBoolean) {
/*  406 */             String str1 = (this.pageStore == null) ? null : ("" + this.pageStore.getWriteCountTotal());
/*      */             
/*  408 */             this.lock.setProperty("logPos", str1);
/*  409 */             this.lock.save();
/*      */           } 
/*  411 */           this.reconnectCheckNext = l + this.reconnectCheckDelay;
/*      */         } 
/*  413 */         return true;
/*      */       } 
/*  415 */       Properties properties = this.lock.load();
/*  416 */       if (paramBoolean) {
/*  417 */         if (properties.getProperty("changePending") != null) {
/*  418 */           return false;
/*      */         }
/*  420 */         this.trace.debug("wait before writing");
/*  421 */         Thread.sleep((int)(this.reconnectCheckDelay * 1.1D));
/*  422 */         Properties properties1 = this.lock.load();
/*  423 */         if (!properties1.equals(properties))
/*      */         {
/*  425 */           return false;
/*      */         }
/*      */       } 
/*  428 */       String str = (this.pageStore == null) ? null : ("" + this.pageStore.getWriteCountTotal());
/*      */       
/*  430 */       this.lock.setProperty("logPos", str);
/*  431 */       if (paramBoolean) {
/*  432 */         this.lock.setProperty("changePending", "true-" + Math.random());
/*      */       } else {
/*  434 */         this.lock.setProperty("changePending", null);
/*      */       } 
/*      */ 
/*      */       
/*  438 */       this.reconnectCheckNext = System.currentTimeMillis() + (2 * this.reconnectCheckDelay);
/*      */       
/*  440 */       properties = this.lock.save();
/*  441 */       if (paramBoolean) {
/*  442 */         this.trace.debug("wait before writing again");
/*  443 */         Thread.sleep((int)(this.reconnectCheckDelay * 1.1D));
/*  444 */         Properties properties1 = this.lock.load();
/*  445 */         if (!properties1.equals(properties))
/*      */         {
/*  447 */           return false;
/*      */         }
/*      */       } else {
/*  450 */         Thread.sleep(1L);
/*      */       } 
/*  452 */       this.reconnectLastLock = properties;
/*  453 */       this.reconnectChangePending = paramBoolean;
/*  454 */       this.reconnectCheckNext = System.currentTimeMillis() + this.reconnectCheckDelay;
/*      */       
/*  456 */       return true;
/*  457 */     } catch (Exception exception) {
/*  458 */       this.trace.error(exception, "pending {0}", new Object[] { Boolean.valueOf(paramBoolean) });
/*  459 */       return false;
/*      */     } 
/*      */   }
/*      */   
/*      */   public long getNextModificationDataId() {
/*  464 */     return ++this.modificationDataId;
/*      */   }
/*      */   
/*      */   public long getModificationMetaId() {
/*  468 */     return this.modificationMetaId;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public long getNextModificationMetaId() {
/*  474 */     this.modificationDataId++;
/*  475 */     return this.modificationMetaId++;
/*      */   }
/*      */   
/*      */   public int getPowerOffCount() {
/*  479 */     return this.powerOffCount;
/*      */   }
/*      */ 
/*      */   
/*      */   public void checkPowerOff() {
/*  484 */     if (this.powerOffCount == 0) {
/*      */       return;
/*      */     }
/*  487 */     if (this.powerOffCount > 1) {
/*  488 */       this.powerOffCount--;
/*      */       return;
/*      */     } 
/*  491 */     if (this.powerOffCount != -1) {
/*      */       try {
/*  493 */         this.powerOffCount = -1;
/*  494 */         stopWriter();
/*  495 */         if (this.mvStore != null) {
/*  496 */           this.mvStore.closeImmediately();
/*      */         }
/*  498 */         if (this.pageStore != null) {
/*      */           try {
/*  500 */             this.pageStore.close();
/*  501 */           } catch (DbException dbException) {}
/*      */ 
/*      */           
/*  504 */           this.pageStore = null;
/*      */         } 
/*  506 */         if (this.lock != null) {
/*  507 */           stopServer();
/*  508 */           if (this.fileLockMethod != 3)
/*      */           {
/*  510 */             this.lock.unlock();
/*      */           }
/*  512 */           this.lock = null;
/*      */         } 
/*  514 */         if (this.traceSystem != null) {
/*  515 */           this.traceSystem.close();
/*      */         }
/*  517 */       } catch (DbException dbException) {
/*  518 */         DbException.traceThrowable((Throwable)dbException);
/*      */       } 
/*      */     }
/*  521 */     Engine.getInstance().close(this.databaseName);
/*  522 */     throw DbException.get(90098);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean exists(String paramString) {
/*  532 */     if (FileUtils.exists(paramString + ".h2.db")) {
/*  533 */       return true;
/*      */     }
/*  535 */     return FileUtils.exists(paramString + ".mv.db");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Trace getTrace(int paramInt) {
/*  545 */     return this.traceSystem.getTrace(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public FileStore openFile(String paramString1, String paramString2, boolean paramBoolean) {
/*  550 */     if (paramBoolean && !FileUtils.exists(paramString1)) {
/*  551 */       throw DbException.get(90124, paramString1);
/*      */     }
/*  553 */     FileStore fileStore = FileStore.open(this, paramString1, paramString2, this.cipher, this.filePasswordHash);
/*      */     
/*      */     try {
/*  556 */       fileStore.init();
/*  557 */     } catch (DbException dbException) {
/*  558 */       fileStore.closeSilently();
/*  559 */       throw dbException;
/*      */     } 
/*  561 */     return fileStore;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean validateFilePasswordHash(String paramString, byte[] paramArrayOfbyte) {
/*  572 */     if (!StringUtils.equals(paramString, this.cipher)) {
/*  573 */       return false;
/*      */     }
/*  575 */     return Utils.compareSecure(paramArrayOfbyte, this.filePasswordHash);
/*      */   }
/*      */   
/*      */   private String parseDatabaseShortName() {
/*  579 */     String str = this.databaseName;
/*  580 */     if (str.endsWith(":")) {
/*  581 */       str = null;
/*      */     }
/*  583 */     if (str != null) {
/*  584 */       StringTokenizer stringTokenizer = new StringTokenizer(str, "/\\:,;");
/*  585 */       while (stringTokenizer.hasMoreTokens()) {
/*  586 */         str = stringTokenizer.nextToken();
/*      */       }
/*      */     } 
/*  589 */     if (str == null || str.length() == 0) {
/*  590 */       str = "unnamed";
/*      */     }
/*  592 */     return this.dbSettings.databaseToUpper ? StringUtils.toUpperEnglish(str) : str;
/*      */   }
/*      */   
/*      */   private synchronized void open(int paramInt1, int paramInt2) {
/*  596 */     if (this.persistent) {
/*  597 */       String str1 = this.databaseName + ".data.db";
/*  598 */       boolean bool1 = FileUtils.exists(str1);
/*  599 */       String str2 = this.databaseName + ".h2.db";
/*  600 */       String str3 = this.databaseName + ".mv.db";
/*  601 */       boolean bool2 = FileUtils.exists(str2);
/*  602 */       boolean bool3 = FileUtils.exists(str3);
/*  603 */       if (bool1 && !bool2 && !bool3) {
/*  604 */         throw DbException.get(90048, "Old database: " + str1 + " - please convert the database " + "to a SQL script and re-create it.");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  610 */       if (bool2 && !FileUtils.canWrite(str2)) {
/*  611 */         this.readOnly = true;
/*      */       }
/*  613 */       if (bool3 && !FileUtils.canWrite(str3)) {
/*  614 */         this.readOnly = true;
/*      */       }
/*  616 */       if (bool2 && !bool3) {
/*  617 */         this.dbSettings.mvStore = false;
/*      */       }
/*  619 */       if (this.readOnly) {
/*  620 */         if (paramInt1 >= 3) {
/*  621 */           String str = Utils.getProperty("java.io.tmpdir", ".") + "/" + "h2_" + System.currentTimeMillis();
/*      */           
/*  623 */           this.traceSystem = new TraceSystem(str + ".trace.db");
/*      */         } else {
/*      */           
/*  626 */           this.traceSystem = new TraceSystem(null);
/*      */         } 
/*      */       } else {
/*  629 */         this.traceSystem = new TraceSystem(this.databaseName + ".trace.db");
/*      */       } 
/*      */       
/*  632 */       this.traceSystem.setLevelFile(paramInt1);
/*  633 */       this.traceSystem.setLevelSystemOut(paramInt2);
/*  634 */       this.trace = this.traceSystem.getTrace(2);
/*  635 */       this.trace.info("opening {0} (build {1})", new Object[] { this.databaseName, Integer.valueOf(193) });
/*  636 */       if (this.autoServerMode && (
/*  637 */         this.readOnly || this.fileLockMethod == 0 || this.fileLockMethod == 3 || this.fileLockMethod == 4 || !this.persistent))
/*      */       {
/*      */ 
/*      */ 
/*      */         
/*  642 */         throw DbException.getUnsupportedException("autoServerMode && (readOnly || fileLockMethod == NO || fileLockMethod == SERIALIZED || fileLockMethod == FS || inMemory)");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  650 */       String str4 = this.databaseName + ".lock.db";
/*  651 */       if (this.readOnly && 
/*  652 */         FileUtils.exists(str4)) {
/*  653 */         throw DbException.get(90020, "Lock file exists: " + str4);
/*      */       }
/*      */ 
/*      */       
/*  657 */       if (!this.readOnly && this.fileLockMethod != 0 && 
/*  658 */         this.fileLockMethod != 4) {
/*  659 */         this.lock = new FileLock(this.traceSystem, str4, 1000);
/*  660 */         this.lock.lock(this.fileLockMethod);
/*  661 */         if (this.autoServerMode) {
/*  662 */           startServer(this.lock.getUniqueId());
/*      */         }
/*      */       } 
/*      */       
/*  666 */       if (SysProperties.MODIFY_ON_WRITE) {
/*  667 */         while (isReconnectNeeded());
/*      */       }
/*      */       else {
/*      */         
/*  671 */         while (isReconnectNeeded() && !beforeWriting());
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  677 */       deleteOldTempFiles();
/*  678 */       this.starting = true;
/*  679 */       if (SysProperties.MODIFY_ON_WRITE) {
/*      */         try {
/*  681 */           getPageStore();
/*  682 */         } catch (DbException dbException) {
/*  683 */           if (dbException.getErrorCode() != 90097) {
/*  684 */             throw dbException;
/*      */           }
/*  686 */           this.pageStore = null;
/*  687 */           while (!beforeWriting());
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  692 */           getPageStore();
/*      */         } 
/*      */       } else {
/*  695 */         getPageStore();
/*      */       } 
/*  697 */       this.starting = false;
/*  698 */       if (this.mvStore == null) {
/*  699 */         this.writer = WriterThread.create(this, this.writeDelay);
/*      */       } else {
/*  701 */         setWriteDelay(this.writeDelay);
/*      */       } 
/*      */     } else {
/*  704 */       if (this.autoServerMode) {
/*  705 */         throw DbException.getUnsupportedException("autoServerMode && inMemory");
/*      */       }
/*      */       
/*  708 */       this.traceSystem = new TraceSystem(null);
/*  709 */       this.trace = this.traceSystem.getTrace(2);
/*  710 */       if (this.dbSettings.mvStore) {
/*  711 */         getPageStore();
/*      */       }
/*      */     } 
/*  714 */     this.systemUser = new User(this, 0, "DBA", true);
/*  715 */     this.mainSchema = new Schema(this, 0, "PUBLIC", this.systemUser, true);
/*  716 */     this.infoSchema = new Schema(this, -1, "INFORMATION_SCHEMA", this.systemUser, true);
/*  717 */     this.schemas.put(this.mainSchema.getName(), this.mainSchema);
/*  718 */     this.schemas.put(this.infoSchema.getName(), this.infoSchema);
/*  719 */     this.publicRole = new Role(this, 0, "PUBLIC", true);
/*  720 */     this.roles.put("PUBLIC", this.publicRole);
/*  721 */     this.systemUser.setAdmin(true);
/*  722 */     this.systemSession = new Session(this, this.systemUser, ++this.nextSessionId);
/*  723 */     this.lobSession = new Session(this, this.systemUser, ++this.nextSessionId);
/*  724 */     CreateTableData createTableData = new CreateTableData();
/*  725 */     ArrayList<Column> arrayList = createTableData.columns;
/*  726 */     Column column = new Column("ID", 4);
/*  727 */     column.setNullable(false);
/*  728 */     arrayList.add(column);
/*  729 */     arrayList.add(new Column("HEAD", 4));
/*  730 */     arrayList.add(new Column("TYPE", 4));
/*  731 */     arrayList.add(new Column("SQL", 13));
/*  732 */     boolean bool = true;
/*  733 */     if (this.pageStore != null) {
/*  734 */       bool = this.pageStore.isNew();
/*      */     }
/*  736 */     createTableData.tableName = "SYS";
/*  737 */     createTableData.id = 0;
/*  738 */     createTableData.temporary = false;
/*  739 */     createTableData.persistData = this.persistent;
/*  740 */     createTableData.persistIndexes = this.persistent;
/*  741 */     createTableData.create = bool;
/*  742 */     createTableData.isHidden = true;
/*  743 */     createTableData.session = this.systemSession;
/*  744 */     this.meta = this.mainSchema.createTable(createTableData);
/*  745 */     IndexColumn[] arrayOfIndexColumn = IndexColumn.wrap(new Column[] { column });
/*  746 */     this.metaIdIndex = this.meta.addIndex(this.systemSession, "SYS_ID", 0, arrayOfIndexColumn, IndexType.createPrimaryKey(false, false), true, null);
/*      */ 
/*      */     
/*  749 */     this.objectIds.set(0);
/*  750 */     this.starting = true;
/*  751 */     Cursor cursor = this.metaIdIndex.find(this.systemSession, null, null);
/*  752 */     ArrayList<MetaRecord> arrayList1 = New.arrayList();
/*  753 */     while (cursor.next()) {
/*  754 */       MetaRecord metaRecord = new MetaRecord((SearchRow)cursor.get());
/*  755 */       this.objectIds.set(metaRecord.getId());
/*  756 */       arrayList1.add(metaRecord);
/*      */     } 
/*  758 */     Collections.sort(arrayList1);
/*  759 */     synchronized (this.systemSession) {
/*  760 */       for (MetaRecord metaRecord : arrayList1) {
/*  761 */         metaRecord.execute(this, this.systemSession, this.eventListener);
/*      */       }
/*      */     } 
/*  764 */     if (this.mvStore != null) {
/*  765 */       this.mvStore.initTransactions();
/*  766 */       this.mvStore.removeTemporaryMaps(this.objectIds);
/*      */     } 
/*  768 */     recompileInvalidViews(this.systemSession);
/*  769 */     this.starting = false;
/*  770 */     if (!this.readOnly) {
/*      */       
/*  772 */       String str = SetTypes.getTypeName(34);
/*  773 */       if (this.settings.get(str) == null) {
/*  774 */         Setting setting = new Setting(this, allocateObjectId(), str);
/*  775 */         setting.setIntValue(193);
/*  776 */         lockMeta(this.systemSession);
/*  777 */         addDatabaseObject(this.systemSession, setting);
/*      */       } 
/*      */       
/*  780 */       if (this.pageStore != null) {
/*  781 */         BitField bitField = this.pageStore.getObjectIds(); byte b; int i;
/*  782 */         for (b = 0, i = bitField.length(); b < i; b++) {
/*  783 */           if (bitField.get(b) && !this.objectIds.get(b)) {
/*  784 */             this.trace.info("unused object id: " + b);
/*  785 */             this.objectIds.set(b);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  790 */     getLobStorage().init();
/*  791 */     this.systemSession.commit(true);
/*      */     
/*  793 */     this.trace.info("opened {0}", new Object[] { this.databaseName });
/*  794 */     if (this.checkpointAllowed > 0) {
/*  795 */       afterWriting();
/*      */     }
/*      */   }
/*      */   
/*      */   private void startServer(String paramString) {
/*      */     try {
/*  801 */       this.server = Server.createTcpServer(new String[] { "-tcpPort", Integer.toString(this.autoServerPort), "-tcpAllowOthers", "-tcpDaemon", "-key", paramString, this.databaseName });
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  806 */       this.server.start();
/*  807 */     } catch (SQLException sQLException) {
/*  808 */       throw DbException.convert(sQLException);
/*      */     } 
/*  810 */     String str1 = NetUtils.getLocalAddress();
/*  811 */     String str2 = str1 + ":" + this.server.getPort();
/*  812 */     this.lock.setProperty("server", str2);
/*  813 */     String str3 = NetUtils.getHostName(str1);
/*  814 */     this.lock.setProperty("hostName", str3);
/*  815 */     this.lock.save();
/*      */   }
/*      */   
/*      */   private void stopServer() {
/*  819 */     if (this.server != null) {
/*  820 */       Server server = this.server;
/*      */ 
/*      */ 
/*      */       
/*  824 */       this.server = null;
/*  825 */       server.stop();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void recompileInvalidViews(Session paramSession) {
/*      */     while (true) {
/*  832 */       boolean bool = false;
/*  833 */       for (Table table : getAllTablesAndViews(false)) {
/*  834 */         if (table instanceof TableView) {
/*  835 */           TableView tableView = (TableView)table;
/*  836 */           if (tableView.isInvalid()) {
/*  837 */             tableView.recompile(paramSession, true, false);
/*  838 */             if (!tableView.isInvalid()) {
/*  839 */               bool = true;
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*  844 */       if (!bool) {
/*  845 */         TableView.clearIndexCaches(paramSession.getDatabase());
/*      */         return;
/*      */       } 
/*      */     }  } private void initMetaTables() {
/*  849 */     if (this.metaTablesInitialized) {
/*      */       return;
/*      */     }
/*  852 */     synchronized (this.infoSchema) {
/*  853 */       if (!this.metaTablesInitialized) {
/*  854 */         byte b = 0; int i = MetaTable.getMetaTableTypeCount();
/*  855 */         for (; b < i; b++) {
/*  856 */           MetaTable metaTable = new MetaTable(this.infoSchema, -1 - b, b);
/*  857 */           this.infoSchema.add((SchemaObject)metaTable);
/*      */         } 
/*  859 */         this.metaTablesInitialized = true;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private synchronized void addMeta(Session paramSession, DbObject paramDbObject) {
/*  865 */     int i = paramDbObject.getId();
/*  866 */     if (i > 0 && !this.starting && !paramDbObject.isTemporary()) {
/*  867 */       Row row = this.meta.getTemplateRow();
/*  868 */       MetaRecord metaRecord = new MetaRecord(paramDbObject);
/*  869 */       metaRecord.setRecord((SearchRow)row);
/*  870 */       this.objectIds.set(i);
/*  871 */       if (SysProperties.CHECK) {
/*  872 */         verifyMetaLocked(paramSession);
/*      */       }
/*  874 */       this.meta.addRow(paramSession, row);
/*  875 */       if (isMultiVersion())
/*      */       {
/*      */         
/*  878 */         paramSession.log(this.meta, (short)0, row);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void verifyMetaLocked(Session paramSession) {
/*  889 */     if (this.meta != null && !this.meta.isLockedExclusivelyBy(paramSession) && this.lockMode != 0)
/*      */     {
/*  891 */       throw DbException.throwInternalError();
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
/*      */   public boolean lockMeta(Session paramSession) {
/*  906 */     if (this.meta == null) {
/*  907 */       return true;
/*      */     }
/*  909 */     return this.meta.lock(paramSession, true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unlockMeta(Session paramSession) {
/*  919 */     this.meta.unlock(paramSession);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void removeMeta(Session paramSession, int paramInt) {
/*  929 */     if (paramInt > 0 && !this.starting) {
/*  930 */       SearchRow searchRow = this.meta.getTemplateSimpleRow(false);
/*  931 */       searchRow.setValue(0, (Value)ValueInt.get(paramInt));
/*  932 */       boolean bool = lockMeta(paramSession);
/*  933 */       Cursor cursor = this.metaIdIndex.find(paramSession, searchRow, searchRow);
/*  934 */       if (cursor.next()) {
/*  935 */         if (SysProperties.CHECK && 
/*  936 */           this.lockMode != 0 && !bool) {
/*  937 */           throw DbException.throwInternalError();
/*      */         }
/*      */         
/*  940 */         Row row = cursor.get();
/*  941 */         this.meta.removeRow(paramSession, row);
/*  942 */         if (isMultiVersion())
/*      */         {
/*      */           
/*  945 */           paramSession.log(this.meta, (short)1, row);
/*      */         }
/*  947 */         if (SysProperties.CHECK) {
/*  948 */           checkMetaFree(paramSession, paramInt);
/*      */         }
/*  950 */       } else if (!bool) {
/*      */ 
/*      */         
/*  953 */         this.meta.unlock(paramSession);
/*  954 */         paramSession.unlock(this.meta);
/*      */       } 
/*  956 */       this.objectIds.clear(paramInt);
/*      */     }  } private HashMap<String, DbObject> getMap(int paramInt) { HashMap<String, User> hashMap6; HashMap<String, Setting> hashMap5;
/*      */     HashMap<String, Role> hashMap4;
/*      */     HashMap<String, Right> hashMap3;
/*      */     HashMap<String, Schema> hashMap2;
/*      */     HashMap<String, UserDataType> hashMap1;
/*      */     HashMap<String, Comment> hashMap;
/*  963 */     switch (paramInt) {
/*      */       case 2:
/*  965 */         return (HashMap)this.users;
/*      */       
/*      */       case 6:
/*  968 */         return (HashMap)this.settings;
/*      */       
/*      */       case 7:
/*  971 */         return (HashMap)this.roles;
/*      */       
/*      */       case 8:
/*  974 */         return (HashMap)this.rights;
/*      */       
/*      */       case 10:
/*  977 */         return (HashMap)this.schemas;
/*      */       
/*      */       case 12:
/*  980 */         return (HashMap)this.userDataTypes;
/*      */       
/*      */       case 13:
/*  983 */         return (HashMap)this.comments;
/*      */       
/*      */       case 14:
/*  986 */         return (HashMap)this.aggregates;
/*      */     } 
/*      */     
/*  989 */     throw DbException.throwInternalError("type=" + paramInt); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addSchemaObject(Session paramSession, SchemaObject paramSchemaObject) {
/* 1001 */     int i = paramSchemaObject.getId();
/* 1002 */     if (i > 0 && !this.starting) {
/* 1003 */       checkWritingAllowed();
/*      */     }
/* 1005 */     lockMeta(paramSession);
/* 1006 */     synchronized (this) {
/* 1007 */       paramSchemaObject.getSchema().add(paramSchemaObject);
/* 1008 */       addMeta(paramSession, (DbObject)paramSchemaObject);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void addDatabaseObject(Session paramSession, DbObject paramDbObject) {
/* 1019 */     int i = paramDbObject.getId();
/* 1020 */     if (i > 0 && !this.starting) {
/* 1021 */       checkWritingAllowed();
/*      */     }
/* 1023 */     HashMap<String, DbObject> hashMap = getMap(paramDbObject.getType());
/* 1024 */     if (paramDbObject.getType() == 2) {
/* 1025 */       User user = (User)paramDbObject;
/* 1026 */       if (user.isAdmin() && this.systemUser.getName().equals("DBA")) {
/* 1027 */         this.systemUser.rename(user.getName());
/*      */       }
/*      */     } 
/* 1030 */     String str = paramDbObject.getName();
/* 1031 */     if (SysProperties.CHECK && hashMap.get(str) != null) {
/* 1032 */       DbException.throwInternalError("object already exists");
/*      */     }
/* 1034 */     lockMeta(paramSession);
/* 1035 */     addMeta(paramSession, paramDbObject);
/* 1036 */     hashMap.put(str, paramDbObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public UserAggregate findAggregate(String paramString) {
/* 1046 */     return this.aggregates.get(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Comment findComment(DbObject paramDbObject) {
/* 1057 */     if (paramDbObject.getType() == 13) {
/* 1058 */       return null;
/*      */     }
/* 1060 */     String str = Comment.getKey(paramDbObject);
/* 1061 */     return this.comments.get(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Role findRole(String paramString) {
/* 1071 */     return this.roles.get(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Schema findSchema(String paramString) {
/* 1081 */     Schema schema = this.schemas.get(paramString);
/* 1082 */     if (schema == this.infoSchema) {
/* 1083 */       initMetaTables();
/*      */     }
/* 1085 */     return schema;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Setting findSetting(String paramString) {
/* 1095 */     return this.settings.get(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public User findUser(String paramString) {
/* 1105 */     return this.users.get(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public UserDataType findUserDataType(String paramString) {
/* 1115 */     return this.userDataTypes.get(paramString);
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
/*      */   public User getUser(String paramString) {
/* 1127 */     User user = findUser(paramString);
/* 1128 */     if (user == null) {
/* 1129 */       throw DbException.get(90032, paramString);
/*      */     }
/* 1131 */     return user;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   synchronized Session createSession(User paramUser) {
/* 1142 */     if (this.closing) {
/* 1143 */       return null;
/*      */     }
/* 1145 */     if (this.exclusiveSession != null) {
/* 1146 */       throw DbException.get(90135);
/*      */     }
/* 1148 */     Session session = new Session(this, paramUser, ++this.nextSessionId);
/* 1149 */     this.userSessions.add(session);
/* 1150 */     this.trace.info("connecting session #{0} to {1}", new Object[] { Integer.valueOf(session.getId()), this.databaseName });
/* 1151 */     if (this.delayedCloser != null) {
/* 1152 */       this.delayedCloser.reset();
/* 1153 */       this.delayedCloser = null;
/*      */     } 
/* 1155 */     return session;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void removeSession(Session paramSession) {
/* 1164 */     if (paramSession != null) {
/* 1165 */       if (this.exclusiveSession == paramSession) {
/* 1166 */         this.exclusiveSession = null;
/*      */       }
/* 1168 */       this.userSessions.remove(paramSession);
/* 1169 */       if (paramSession != this.systemSession && paramSession != this.lobSession) {
/* 1170 */         this.trace.info("disconnecting session #{0}", new Object[] { Integer.valueOf(paramSession.getId()) });
/*      */       }
/*      */     } 
/* 1173 */     if (this.userSessions.size() == 0 && paramSession != this.systemSession && paramSession != this.lobSession)
/*      */     {
/* 1175 */       if (this.closeDelay == 0)
/* 1176 */       { close(false); }
/* 1177 */       else { if (this.closeDelay < 0) {
/*      */           return;
/*      */         }
/* 1180 */         this.delayedCloser = new DatabaseCloser(this, this.closeDelay * 1000, false);
/* 1181 */         this.delayedCloser.setName("H2 Close Delay " + getShortName());
/* 1182 */         this.delayedCloser.setDaemon(true);
/* 1183 */         this.delayedCloser.start(); }
/*      */     
/*      */     }
/* 1186 */     if (paramSession != this.systemSession && paramSession != this.lobSession && paramSession != null)
/*      */     {
/* 1188 */       this.trace.info("disconnected session #{0}", new Object[] { Integer.valueOf(paramSession.getId()) });
/*      */     }
/*      */   }
/*      */   
/*      */   private synchronized void closeAllSessionsException(Session paramSession) {
/* 1193 */     Session[] arrayOfSession = new Session[this.userSessions.size()];
/* 1194 */     this.userSessions.toArray(arrayOfSession);
/* 1195 */     for (Session session : arrayOfSession) {
/* 1196 */       if (session != paramSession) {
/*      */         
/*      */         try {
/*      */ 
/*      */           
/* 1201 */           session.rollback();
/* 1202 */           session.close();
/* 1203 */         } catch (DbException dbException) {
/* 1204 */           this.trace.error((Throwable)dbException, "disconnecting session #{0}", new Object[] { Integer.valueOf(session.getId()) });
/*      */         } 
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
/*      */   synchronized void close(boolean paramBoolean) {
/* 1217 */     if (this.closing) {
/*      */       return;
/*      */     }
/* 1220 */     throwLastBackgroundException();
/* 1221 */     if (this.fileLockMethod == 3 && !this.reconnectChangePending) {
/*      */ 
/*      */       
/*      */       try {
/* 1225 */         closeOpenFilesAndUnlock(false);
/* 1226 */       } catch (DbException dbException) {}
/*      */ 
/*      */       
/* 1229 */       this.traceSystem.close();
/* 1230 */       Engine.getInstance().close(this.databaseName);
/*      */       return;
/*      */     } 
/* 1233 */     this.closing = true;
/* 1234 */     stopServer();
/* 1235 */     if (this.userSessions.size() > 0) {
/* 1236 */       if (!paramBoolean) {
/*      */         return;
/*      */       }
/* 1239 */       this.trace.info("closing {0} from shutdown hook", new Object[] { this.databaseName });
/* 1240 */       closeAllSessionsException(null);
/*      */     } 
/* 1242 */     this.trace.info("closing {0}", new Object[] { this.databaseName });
/* 1243 */     if (this.eventListener != null) {
/*      */       
/* 1245 */       this.closing = false;
/* 1246 */       DatabaseEventListener databaseEventListener = this.eventListener;
/*      */       
/* 1248 */       this.eventListener = null;
/* 1249 */       databaseEventListener.closingDatabase();
/* 1250 */       if (this.userSessions.size() > 0) {
/*      */         return;
/*      */       }
/*      */       
/* 1254 */       this.closing = true;
/*      */     } 
/* 1256 */     removeOrphanedLobs();
/*      */     try {
/* 1258 */       if (this.systemSession != null) {
/* 1259 */         if (this.powerOffCount != -1) {
/* 1260 */           for (Table table : getAllTablesAndViews(false)) {
/* 1261 */             if (table.isGlobalTemporary()) {
/* 1262 */               table.removeChildrenAndResources(this.systemSession); continue;
/*      */             } 
/* 1264 */             table.close(this.systemSession);
/*      */           } 
/*      */           
/* 1267 */           for (SchemaObject schemaObject : getAllSchemaObjects(3)) {
/*      */             
/* 1269 */             Sequence sequence = (Sequence)schemaObject;
/* 1270 */             sequence.close();
/*      */           } 
/*      */         } 
/* 1273 */         for (SchemaObject schemaObject : getAllSchemaObjects(4)) {
/*      */           
/* 1275 */           TriggerObject triggerObject = (TriggerObject)schemaObject;
/*      */           try {
/* 1277 */             triggerObject.close();
/* 1278 */           } catch (SQLException sQLException) {
/* 1279 */             this.trace.error(sQLException, "close");
/*      */           } 
/*      */         } 
/* 1282 */         if (this.powerOffCount != -1) {
/* 1283 */           this.meta.close(this.systemSession);
/* 1284 */           this.systemSession.commit(true);
/*      */         } 
/*      */       } 
/* 1287 */     } catch (DbException dbException) {
/* 1288 */       this.trace.error((Throwable)dbException, "close");
/*      */     } 
/* 1290 */     this.tempFileDeleter.deleteAll();
/*      */     try {
/* 1292 */       closeOpenFilesAndUnlock(true);
/* 1293 */     } catch (DbException dbException) {
/* 1294 */       this.trace.error((Throwable)dbException, "close");
/*      */     } 
/* 1296 */     this.trace.info("closed");
/* 1297 */     this.traceSystem.close();
/* 1298 */     if (this.closeOnExit != null) {
/* 1299 */       this.closeOnExit.reset();
/*      */       try {
/* 1301 */         Runtime.getRuntime().removeShutdownHook(this.closeOnExit);
/* 1302 */       } catch (IllegalStateException illegalStateException) {
/*      */       
/* 1304 */       } catch (SecurityException securityException) {}
/*      */ 
/*      */       
/* 1307 */       this.closeOnExit = null;
/*      */     } 
/* 1309 */     Engine.getInstance().close(this.databaseName);
/* 1310 */     if (this.deleteFilesOnDisconnect && this.persistent) {
/* 1311 */       this.deleteFilesOnDisconnect = false;
/*      */       try {
/* 1313 */         String str1 = FileUtils.getParent(this.databaseName);
/* 1314 */         String str2 = FileUtils.getName(this.databaseName);
/* 1315 */         DeleteDbFiles.execute(str1, str2, true);
/* 1316 */       } catch (Exception exception) {}
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void removeOrphanedLobs() {
/* 1324 */     if (!this.persistent) {
/*      */       return;
/*      */     }
/* 1327 */     int i = (this.infoSchema.findTableOrView(this.systemSession, "LOB_DATA") != null) ? 1 : 0;
/*      */     
/* 1329 */     i |= (this.mvStore != null) ? 1 : 0;
/* 1330 */     if (i == 0) {
/*      */       return;
/*      */     }
/*      */     try {
/* 1334 */       getLobStorage();
/* 1335 */       this.lobStorage.removeAllForTable(-1);
/*      */     }
/* 1337 */     catch (DbException dbException) {
/* 1338 */       this.trace.error((Throwable)dbException, "close");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void stopWriter() {
/* 1343 */     if (this.writer != null) {
/* 1344 */       this.writer.stopThread();
/* 1345 */       this.writer = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private synchronized void closeOpenFilesAndUnlock(boolean paramBoolean) {
/* 1355 */     stopWriter();
/* 1356 */     if (this.pageStore != null && 
/* 1357 */       paramBoolean) {
/*      */       try {
/* 1359 */         this.pageStore.checkpoint();
/* 1360 */         if (!this.readOnly) {
/* 1361 */           lockMeta(this.pageStore.getPageStoreSession());
/* 1362 */           this.pageStore.compact(this.compactMode);
/*      */         } 
/* 1364 */       } catch (DbException dbException) {
/* 1365 */         if (SysProperties.CHECK2) {
/* 1366 */           int i = dbException.getErrorCode();
/* 1367 */           if (i != 90098 && i != 50200 && i != 90031)
/*      */           {
/*      */             
/* 1370 */             dbException.printStackTrace();
/*      */           }
/*      */         } 
/* 1373 */         this.trace.error((Throwable)dbException, "close");
/* 1374 */       } catch (Throwable throwable) {
/* 1375 */         if (SysProperties.CHECK2) {
/* 1376 */           throwable.printStackTrace();
/*      */         }
/* 1378 */         this.trace.error(throwable, "close");
/*      */       } 
/*      */     }
/*      */     
/* 1382 */     reconnectModified(false);
/* 1383 */     if (this.mvStore != null) {
/* 1384 */       long l = this.dbSettings.maxCompactTime;
/* 1385 */       if (this.compactMode == 82) {
/* 1386 */         this.mvStore.compactFile(this.dbSettings.maxCompactTime);
/* 1387 */       } else if (this.compactMode == 84) {
/* 1388 */         l = Long.MAX_VALUE;
/* 1389 */       } else if ((getSettings()).defragAlways) {
/* 1390 */         l = Long.MAX_VALUE;
/*      */       } 
/* 1392 */       this.mvStore.close(l);
/*      */     } 
/* 1394 */     closeFiles();
/* 1395 */     if (this.persistent && this.lock == null && this.fileLockMethod != 0 && this.fileLockMethod != 4) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1403 */     if (this.persistent) {
/* 1404 */       deleteOldTempFiles();
/*      */     }
/* 1406 */     if (this.systemSession != null) {
/* 1407 */       this.systemSession.close();
/* 1408 */       this.systemSession = null;
/*      */     } 
/* 1410 */     if (this.lobSession != null) {
/* 1411 */       this.lobSession.close();
/* 1412 */       this.lobSession = null;
/*      */     } 
/* 1414 */     if (this.lock != null) {
/* 1415 */       if (this.fileLockMethod == 3)
/*      */       {
/*      */         
/* 1418 */         if (this.lock.load().containsKey("changePending")) {
/*      */           try {
/* 1420 */             Thread.sleep((int)(this.reconnectCheckDelay * 1.1D));
/* 1421 */           } catch (InterruptedException interruptedException) {
/* 1422 */             this.trace.error(interruptedException, "close");
/*      */           } 
/*      */         }
/*      */       }
/* 1426 */       this.lock.unlock();
/* 1427 */       this.lock = null;
/*      */     } 
/*      */   }
/*      */   
/*      */   private synchronized void closeFiles() {
/*      */     try {
/* 1433 */       if (this.mvStore != null) {
/* 1434 */         this.mvStore.closeImmediately();
/*      */       }
/* 1436 */       if (this.pageStore != null) {
/* 1437 */         this.pageStore.close();
/* 1438 */         this.pageStore = null;
/*      */       } 
/* 1440 */     } catch (DbException dbException) {
/* 1441 */       this.trace.error((Throwable)dbException, "close");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void checkMetaFree(Session paramSession, int paramInt) {
/* 1446 */     SearchRow searchRow = this.meta.getTemplateSimpleRow(false);
/* 1447 */     searchRow.setValue(0, (Value)ValueInt.get(paramInt));
/* 1448 */     Cursor cursor = this.metaIdIndex.find(paramSession, searchRow, searchRow);
/* 1449 */     if (cursor.next()) {
/* 1450 */       DbException.throwInternalError();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized int allocateObjectId() {
/* 1460 */     int i = this.objectIds.nextClearBit(0);
/* 1461 */     this.objectIds.set(i);
/* 1462 */     return i;
/*      */   }
/*      */   
/*      */   public ArrayList<UserAggregate> getAllAggregates() {
/* 1466 */     return New.arrayList(this.aggregates.values());
/*      */   }
/*      */   
/*      */   public ArrayList<Comment> getAllComments() {
/* 1470 */     return New.arrayList(this.comments.values());
/*      */   }
/*      */   
/*      */   public int getAllowLiterals() {
/* 1474 */     if (this.starting) {
/* 1475 */       return 2;
/*      */     }
/* 1477 */     return this.allowLiterals;
/*      */   }
/*      */   
/*      */   public ArrayList<Right> getAllRights() {
/* 1481 */     return New.arrayList(this.rights.values());
/*      */   }
/*      */   
/*      */   public ArrayList<Role> getAllRoles() {
/* 1485 */     return New.arrayList(this.roles.values());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ArrayList<SchemaObject> getAllSchemaObjects() {
/* 1494 */     initMetaTables();
/* 1495 */     ArrayList<SchemaObject> arrayList = New.arrayList();
/* 1496 */     for (Schema schema : this.schemas.values()) {
/* 1497 */       arrayList.addAll(schema.getAll());
/*      */     }
/* 1499 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ArrayList<SchemaObject> getAllSchemaObjects(int paramInt) {
/* 1509 */     if (paramInt == 0) {
/* 1510 */       initMetaTables();
/*      */     }
/* 1512 */     ArrayList<SchemaObject> arrayList = New.arrayList();
/* 1513 */     for (Schema schema : this.schemas.values()) {
/* 1514 */       arrayList.addAll(schema.getAll(paramInt));
/*      */     }
/* 1516 */     return arrayList;
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
/*      */   public ArrayList<Table> getAllTablesAndViews(boolean paramBoolean) {
/* 1528 */     if (paramBoolean) {
/* 1529 */       initMetaTables();
/*      */     }
/* 1531 */     ArrayList<Table> arrayList = New.arrayList();
/* 1532 */     for (Schema schema : this.schemas.values()) {
/* 1533 */       arrayList.addAll(schema.getAllTablesAndViews());
/*      */     }
/* 1535 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ArrayList<Table> getTableOrViewByName(String paramString) {
/* 1545 */     ArrayList<Table> arrayList = New.arrayList();
/* 1546 */     for (Schema schema : this.schemas.values()) {
/* 1547 */       Table table = schema.getTableOrViewByName(paramString);
/* 1548 */       if (table != null) {
/* 1549 */         arrayList.add(table);
/*      */       }
/*      */     } 
/* 1552 */     return arrayList;
/*      */   }
/*      */   
/*      */   public ArrayList<Schema> getAllSchemas() {
/* 1556 */     initMetaTables();
/* 1557 */     return New.arrayList(this.schemas.values());
/*      */   }
/*      */   
/*      */   public ArrayList<Setting> getAllSettings() {
/* 1561 */     return New.arrayList(this.settings.values());
/*      */   }
/*      */   
/*      */   public ArrayList<UserDataType> getAllUserDataTypes() {
/* 1565 */     return New.arrayList(this.userDataTypes.values());
/*      */   }
/*      */   
/*      */   public ArrayList<User> getAllUsers() {
/* 1569 */     return New.arrayList(this.users.values());
/*      */   }
/*      */   
/*      */   public String getCacheType() {
/* 1573 */     return this.cacheType;
/*      */   }
/*      */   
/*      */   public String getCluster() {
/* 1577 */     return this.cluster;
/*      */   }
/*      */ 
/*      */   
/*      */   public CompareMode getCompareMode() {
/* 1582 */     return this.compareMode;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getDatabasePath() {
/* 1587 */     if (this.persistent) {
/* 1588 */       return FileUtils.toRealPath(this.databaseName);
/*      */     }
/* 1590 */     return null;
/*      */   }
/*      */   
/*      */   public String getShortName() {
/* 1594 */     return this.databaseShortName;
/*      */   }
/*      */   
/*      */   public String getName() {
/* 1598 */     return this.databaseName;
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
/*      */   public Session[] getSessions(boolean paramBoolean) {
/*      */     ArrayList<Session> arrayList;
/* 1612 */     synchronized (this.userSessions) {
/* 1613 */       arrayList = New.arrayList(this.userSessions);
/*      */     } 
/*      */     
/* 1616 */     Session session1 = this.systemSession;
/* 1617 */     Session session2 = this.lobSession;
/* 1618 */     if (paramBoolean && session1 != null) {
/* 1619 */       arrayList.add(session1);
/*      */     }
/* 1621 */     if (paramBoolean && session2 != null) {
/* 1622 */       arrayList.add(session2);
/*      */     }
/* 1624 */     Session[] arrayOfSession = new Session[arrayList.size()];
/* 1625 */     arrayList.toArray(arrayOfSession);
/* 1626 */     return arrayOfSession;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void updateMeta(Session paramSession, DbObject paramDbObject) {
/* 1636 */     lockMeta(paramSession);
/* 1637 */     int i = paramDbObject.getId();
/* 1638 */     removeMeta(paramSession, i);
/* 1639 */     addMeta(paramSession, paramDbObject);
/*      */     
/* 1641 */     if (i > 0) {
/* 1642 */       this.objectIds.set(i);
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
/*      */   public synchronized void renameSchemaObject(Session paramSession, SchemaObject paramSchemaObject, String paramString) {
/* 1655 */     checkWritingAllowed();
/* 1656 */     paramSchemaObject.getSchema().rename(paramSchemaObject, paramString);
/* 1657 */     updateMetaAndFirstLevelChildren(paramSession, (DbObject)paramSchemaObject);
/*      */   }
/*      */   
/*      */   private synchronized void updateMetaAndFirstLevelChildren(Session paramSession, DbObject paramDbObject) {
/* 1661 */     ArrayList<DbObject> arrayList = paramDbObject.getChildren();
/* 1662 */     Comment comment = findComment(paramDbObject);
/* 1663 */     if (comment != null) {
/* 1664 */       DbException.throwInternalError();
/*      */     }
/* 1666 */     updateMeta(paramSession, paramDbObject);
/*      */     
/* 1668 */     if (arrayList != null) {
/* 1669 */       for (DbObject dbObject : arrayList) {
/* 1670 */         if (dbObject.getCreateSQL() != null) {
/* 1671 */           updateMeta(paramSession, dbObject);
/*      */         }
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
/*      */   public synchronized void renameDatabaseObject(Session paramSession, DbObject paramDbObject, String paramString) {
/* 1686 */     checkWritingAllowed();
/* 1687 */     int i = paramDbObject.getType();
/* 1688 */     HashMap<String, DbObject> hashMap = getMap(i);
/* 1689 */     if (SysProperties.CHECK) {
/* 1690 */       if (!hashMap.containsKey(paramDbObject.getName())) {
/* 1691 */         DbException.throwInternalError("not found: " + paramDbObject.getName());
/*      */       }
/* 1693 */       if (paramDbObject.getName().equals(paramString) || hashMap.containsKey(paramString)) {
/* 1694 */         DbException.throwInternalError("object already exists: " + paramString);
/*      */       }
/*      */     } 
/* 1697 */     paramDbObject.checkRename();
/* 1698 */     int j = paramDbObject.getId();
/* 1699 */     lockMeta(paramSession);
/* 1700 */     removeMeta(paramSession, j);
/* 1701 */     hashMap.remove(paramDbObject.getName());
/* 1702 */     paramDbObject.rename(paramString);
/* 1703 */     hashMap.put(paramString, paramDbObject);
/* 1704 */     updateMetaAndFirstLevelChildren(paramSession, paramDbObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String createTempFile() {
/*      */     try {
/* 1714 */       boolean bool = this.readOnly;
/* 1715 */       String str = this.databaseName;
/* 1716 */       if (!this.persistent) {
/* 1717 */         str = "memFS:" + str;
/*      */       }
/* 1719 */       return FileUtils.createTempFile(str, ".temp.db", true, bool);
/*      */     }
/* 1721 */     catch (IOException iOException) {
/* 1722 */       throw DbException.convertIOException(iOException, this.databaseName);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void deleteOldTempFiles() {
/* 1727 */     String str = FileUtils.getParent(this.databaseName);
/* 1728 */     for (String str1 : FileUtils.newDirectoryStream(str)) {
/* 1729 */       if (str1.endsWith(".temp.db") && str1.startsWith(this.databaseName))
/*      */       {
/*      */         
/* 1732 */         FileUtils.tryDelete(str1);
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
/*      */   public Schema getSchema(String paramString) {
/* 1745 */     Schema schema = findSchema(paramString);
/* 1746 */     if (schema == null) {
/* 1747 */       throw DbException.get(90079, paramString);
/*      */     }
/* 1749 */     return schema;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void removeDatabaseObject(Session paramSession, DbObject paramDbObject) {
/* 1759 */     checkWritingAllowed();
/* 1760 */     String str = paramDbObject.getName();
/* 1761 */     int i = paramDbObject.getType();
/* 1762 */     HashMap<String, DbObject> hashMap = getMap(i);
/* 1763 */     if (SysProperties.CHECK && !hashMap.containsKey(str)) {
/* 1764 */       DbException.throwInternalError("not found: " + str);
/*      */     }
/* 1766 */     Comment comment = findComment(paramDbObject);
/* 1767 */     lockMeta(paramSession);
/* 1768 */     if (comment != null) {
/* 1769 */       removeDatabaseObject(paramSession, comment);
/*      */     }
/* 1771 */     int j = paramDbObject.getId();
/* 1772 */     paramDbObject.removeChildrenAndResources(paramSession);
/* 1773 */     hashMap.remove(str);
/* 1774 */     removeMeta(paramSession, j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Table getDependentTable(SchemaObject paramSchemaObject, Table paramTable) {
/* 1785 */     switch (paramSchemaObject.getType()) {
/*      */       case 1:
/*      */       case 2:
/*      */       case 4:
/*      */       case 5:
/*      */       case 8:
/*      */       case 13:
/* 1792 */         return null;
/*      */     } 
/*      */     
/* 1795 */     HashSet hashSet = New.hashSet();
/* 1796 */     for (Table table : getAllTablesAndViews(false)) {
/* 1797 */       if (paramTable == table)
/*      */         continue; 
/* 1799 */       if ("VIEW".equals(table.getTableType())) {
/*      */         continue;
/*      */       }
/* 1802 */       hashSet.clear();
/* 1803 */       table.addDependencies(hashSet);
/* 1804 */       if (hashSet.contains(paramSchemaObject)) {
/* 1805 */         return table;
/*      */       }
/*      */     } 
/* 1808 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeSchemaObject(Session paramSession, SchemaObject paramSchemaObject) {
/* 1819 */     int i = paramSchemaObject.getType();
/* 1820 */     if (i == 0) {
/* 1821 */       Table table = (Table)paramSchemaObject;
/* 1822 */       if (table.isTemporary() && !table.isGlobalTemporary()) {
/* 1823 */         paramSession.removeLocalTempTable(table);
/*      */         return;
/*      */       } 
/* 1826 */     } else if (i == 1) {
/* 1827 */       Index index = (Index)paramSchemaObject;
/* 1828 */       Table table = index.getTable();
/* 1829 */       if (table.isTemporary() && !table.isGlobalTemporary()) {
/* 1830 */         paramSession.removeLocalTempTableIndex(index);
/*      */         return;
/*      */       } 
/* 1833 */     } else if (i == 5) {
/* 1834 */       Constraint constraint = (Constraint)paramSchemaObject;
/* 1835 */       Table table = constraint.getTable();
/* 1836 */       if (table.isTemporary() && !table.isGlobalTemporary()) {
/* 1837 */         paramSession.removeLocalTempTableConstraint(constraint);
/*      */         return;
/*      */       } 
/*      */     } 
/* 1841 */     checkWritingAllowed();
/* 1842 */     lockMeta(paramSession);
/* 1843 */     synchronized (this) {
/* 1844 */       Comment comment = findComment((DbObject)paramSchemaObject);
/* 1845 */       if (comment != null) {
/* 1846 */         removeDatabaseObject(paramSession, comment);
/*      */       }
/* 1848 */       paramSchemaObject.getSchema().remove(paramSchemaObject);
/* 1849 */       int j = paramSchemaObject.getId();
/* 1850 */       if (!this.starting) {
/* 1851 */         Table table = getDependentTable(paramSchemaObject, null);
/* 1852 */         if (table != null) {
/* 1853 */           paramSchemaObject.getSchema().add(paramSchemaObject);
/* 1854 */           throw DbException.get(90107, new String[] { paramSchemaObject.getSQL(), table.getSQL() });
/*      */         } 
/*      */         
/* 1857 */         paramSchemaObject.removeChildrenAndResources(paramSession);
/*      */       } 
/* 1859 */       removeMeta(paramSession, j);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPersistent() {
/* 1869 */     return this.persistent;
/*      */   }
/*      */   
/*      */   public TraceSystem getTraceSystem() {
/* 1873 */     return this.traceSystem;
/*      */   }
/*      */   
/*      */   public synchronized void setCacheSize(int paramInt) {
/* 1877 */     if (this.starting) {
/* 1878 */       int i = MathUtils.convertLongToInt(Utils.getMemoryMax()) / 2;
/* 1879 */       paramInt = Math.min(paramInt, i);
/*      */     } 
/* 1881 */     this.cacheSize = paramInt;
/* 1882 */     if (this.pageStore != null) {
/* 1883 */       this.pageStore.getCache().setMaxMemory(paramInt);
/*      */     }
/* 1885 */     if (this.mvStore != null) {
/* 1886 */       this.mvStore.setCacheSize(Math.max(1, paramInt));
/*      */     }
/*      */   }
/*      */   
/*      */   public synchronized void setMasterUser(User paramUser) {
/* 1891 */     lockMeta(this.systemSession);
/* 1892 */     addDatabaseObject(this.systemSession, paramUser);
/* 1893 */     this.systemSession.commit(true);
/*      */   }
/*      */   
/*      */   public Role getPublicRole() {
/* 1897 */     return this.publicRole;
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
/*      */   public synchronized String getTempTableName(String paramString, Session paramSession) {
/*      */     while (true) {
/* 1910 */       String str = paramString + "_COPY_" + paramSession.getId() + "_" + this.nextTempTableId++;
/*      */       
/* 1912 */       if (this.mainSchema.findTableOrView(paramSession, str) == null)
/* 1913 */         return str; 
/*      */     } 
/*      */   }
/*      */   public void setCompareMode(CompareMode paramCompareMode) {
/* 1917 */     this.compareMode = paramCompareMode;
/*      */   }
/*      */   
/*      */   public void setCluster(String paramString) {
/* 1921 */     this.cluster = paramString;
/*      */   }
/*      */ 
/*      */   
/*      */   public void checkWritingAllowed() {
/* 1926 */     if (this.readOnly) {
/* 1927 */       throw DbException.get(90097);
/*      */     }
/* 1929 */     if (this.fileLockMethod == 3 && 
/* 1930 */       !this.reconnectChangePending) {
/* 1931 */       throw DbException.get(90097);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isReadOnly() {
/* 1937 */     return this.readOnly;
/*      */   }
/*      */   
/*      */   public void setWriteDelay(int paramInt) {
/* 1941 */     this.writeDelay = paramInt;
/* 1942 */     if (this.writer != null) {
/* 1943 */       this.writer.setWriteDelay(paramInt);
/*      */       
/* 1945 */       this.flushOnEachCommit = (this.writeDelay < 5);
/*      */     } 
/* 1947 */     if (this.mvStore != null) {
/* 1948 */       boolean bool = (paramInt < 0) ? false : paramInt;
/* 1949 */       this.mvStore.getStore().setAutoCommitDelay(bool);
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getRetentionTime() {
/* 1954 */     return this.retentionTime;
/*      */   }
/*      */   
/*      */   public void setRetentionTime(int paramInt) {
/* 1958 */     this.retentionTime = paramInt;
/* 1959 */     if (this.mvStore != null) {
/* 1960 */       this.mvStore.getStore().setRetentionTime(paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getFlushOnEachCommit() {
/* 1970 */     return this.flushOnEachCommit;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ArrayList<InDoubtTransaction> getInDoubtTransactions() {
/* 1979 */     if (this.mvStore != null) {
/* 1980 */       return this.mvStore.getInDoubtTransactions();
/*      */     }
/* 1982 */     return (this.pageStore == null) ? null : this.pageStore.getInDoubtTransactions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   synchronized void prepareCommit(Session paramSession, String paramString) {
/* 1992 */     if (this.readOnly) {
/*      */       return;
/*      */     }
/* 1995 */     if (this.mvStore != null) {
/* 1996 */       this.mvStore.prepareCommit(paramSession, paramString);
/*      */       return;
/*      */     } 
/* 1999 */     if (this.pageStore != null) {
/* 2000 */       this.pageStore.flushLog();
/* 2001 */       this.pageStore.prepareCommit(paramSession, paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   synchronized void commit(Session paramSession) {
/* 2011 */     throwLastBackgroundException();
/* 2012 */     if (this.readOnly) {
/*      */       return;
/*      */     }
/* 2015 */     if (this.pageStore != null) {
/* 2016 */       this.pageStore.commit(paramSession);
/*      */     }
/* 2018 */     paramSession.setAllCommitted();
/*      */   }
/*      */   
/*      */   private void throwLastBackgroundException() {
/* 2022 */     if (this.backgroundException != null) {
/*      */ 
/*      */ 
/*      */       
/* 2026 */       DbException dbException = this.backgroundException;
/* 2027 */       this.backgroundException = null;
/* 2028 */       if (dbException != null)
/*      */       {
/* 2030 */         throw DbException.get(dbException.getErrorCode(), dbException, new String[] { dbException.getMessage() });
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setBackgroundException(DbException paramDbException) {
/* 2036 */     if (this.backgroundException == null) {
/* 2037 */       this.backgroundException = paramDbException;
/* 2038 */       TraceSystem traceSystem = getTraceSystem();
/* 2039 */       if (traceSystem != null) {
/* 2040 */         traceSystem.getTrace(2).error((Throwable)paramDbException, "flush");
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void flush() {
/* 2049 */     if (this.readOnly) {
/*      */       return;
/*      */     }
/* 2052 */     if (this.pageStore != null) {
/* 2053 */       this.pageStore.flushLog();
/*      */     }
/* 2055 */     if (this.mvStore != null) {
/*      */       try {
/* 2057 */         this.mvStore.flush();
/* 2058 */       } catch (RuntimeException runtimeException) {
/* 2059 */         this.backgroundException = DbException.convert(runtimeException);
/* 2060 */         throw runtimeException;
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void setEventListener(DatabaseEventListener paramDatabaseEventListener) {
/* 2066 */     this.eventListener = paramDatabaseEventListener;
/*      */   }
/*      */   
/*      */   public void setEventListenerClass(String paramString) {
/* 2070 */     if (paramString == null || paramString.length() == 0) {
/* 2071 */       this.eventListener = null;
/*      */     } else {
/*      */       try {
/* 2074 */         this.eventListener = JdbcUtils.loadUserClass(paramString).newInstance();
/*      */         
/* 2076 */         String str = this.databaseURL;
/* 2077 */         if (this.cipher != null) {
/* 2078 */           str = str + ";CIPHER=" + this.cipher;
/*      */         }
/* 2080 */         this.eventListener.init(str);
/* 2081 */       } catch (Throwable throwable) {
/* 2082 */         throw DbException.get(90099, throwable, new String[] { paramString, throwable.toString() });
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
/*      */   public void setProgress(int paramInt1, String paramString, int paramInt2, int paramInt3) {
/* 2099 */     if (this.eventListener != null) {
/*      */       try {
/* 2101 */         this.eventListener.setProgress(paramInt1, paramString, paramInt2, paramInt3);
/* 2102 */       } catch (Exception exception) {}
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
/*      */   public void exceptionThrown(SQLException paramSQLException, String paramString) {
/* 2116 */     if (this.eventListener != null) {
/*      */       try {
/* 2118 */         this.eventListener.exceptionThrown(paramSQLException, paramString);
/* 2119 */       } catch (Exception exception) {}
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void sync() {
/* 2130 */     if (this.readOnly) {
/*      */       return;
/*      */     }
/* 2133 */     if (this.mvStore != null) {
/* 2134 */       this.mvStore.sync();
/*      */     }
/* 2136 */     if (this.pageStore != null) {
/* 2137 */       this.pageStore.sync();
/*      */     }
/*      */   }
/*      */   
/*      */   public int getMaxMemoryRows() {
/* 2142 */     return this.maxMemoryRows;
/*      */   }
/*      */   
/*      */   public void setMaxMemoryRows(int paramInt) {
/* 2146 */     this.maxMemoryRows = paramInt;
/*      */   }
/*      */   
/*      */   public void setMaxMemoryUndo(int paramInt) {
/* 2150 */     this.maxMemoryUndo = paramInt;
/*      */   }
/*      */   
/*      */   public int getMaxMemoryUndo() {
/* 2154 */     return this.maxMemoryUndo;
/*      */   }
/*      */   
/*      */   public void setLockMode(int paramInt) {
/* 2158 */     switch (paramInt) {
/*      */       case 0:
/* 2160 */         if (this.multiThreaded)
/*      */         {
/*      */ 
/*      */           
/* 2164 */           throw DbException.get(90021, "LOCK_MODE=0 & MULTI_THREADED");
/*      */         }
/*      */         break;
/*      */       
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*      */         break;
/*      */       
/*      */       default:
/* 2174 */         throw DbException.getInvalidValueException("lock mode", Integer.valueOf(paramInt));
/*      */     } 
/* 2176 */     this.lockMode = paramInt;
/*      */   }
/*      */   
/*      */   public int getLockMode() {
/* 2180 */     return this.lockMode;
/*      */   }
/*      */   
/*      */   public synchronized void setCloseDelay(int paramInt) {
/* 2184 */     this.closeDelay = paramInt;
/*      */   }
/*      */   
/*      */   public Session getSystemSession() {
/* 2188 */     return this.systemSession;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isClosing() {
/* 2197 */     return this.closing;
/*      */   }
/*      */   
/*      */   public void setMaxLengthInplaceLob(int paramInt) {
/* 2201 */     this.maxLengthInplaceLob = paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getMaxLengthInplaceLob() {
/* 2206 */     return this.maxLengthInplaceLob;
/*      */   }
/*      */   
/*      */   public void setIgnoreCase(boolean paramBoolean) {
/* 2210 */     this.ignoreCase = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean getIgnoreCase() {
/* 2214 */     if (this.starting)
/*      */     {
/* 2216 */       return false;
/*      */     }
/* 2218 */     return this.ignoreCase;
/*      */   }
/*      */   
/*      */   public synchronized void setDeleteFilesOnDisconnect(boolean paramBoolean) {
/* 2222 */     this.deleteFilesOnDisconnect = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getLobCompressionAlgorithm(int paramInt) {
/* 2227 */     return this.lobCompressionAlgorithm;
/*      */   }
/*      */   
/*      */   public void setLobCompressionAlgorithm(String paramString) {
/* 2231 */     this.lobCompressionAlgorithm = paramString;
/*      */   }
/*      */   
/*      */   public synchronized void setMaxLogSize(long paramLong) {
/* 2235 */     if (this.pageStore != null) {
/* 2236 */       this.pageStore.setMaxLogSize(paramLong);
/*      */     }
/*      */   }
/*      */   
/*      */   public void setAllowLiterals(int paramInt) {
/* 2241 */     this.allowLiterals = paramInt;
/*      */   }
/*      */   
/*      */   public boolean getOptimizeReuseResults() {
/* 2245 */     return this.optimizeReuseResults;
/*      */   }
/*      */   
/*      */   public void setOptimizeReuseResults(boolean paramBoolean) {
/* 2249 */     this.optimizeReuseResults = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getLobSyncObject() {
/* 2254 */     return this.lobSyncObject;
/*      */   }
/*      */   
/*      */   public int getSessionCount() {
/* 2258 */     return this.userSessions.size();
/*      */   }
/*      */   
/*      */   public void setReferentialIntegrity(boolean paramBoolean) {
/* 2262 */     this.referentialIntegrity = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean getReferentialIntegrity() {
/* 2266 */     return this.referentialIntegrity;
/*      */   }
/*      */   
/*      */   public void setQueryStatistics(boolean paramBoolean) {
/* 2270 */     this.queryStatistics = paramBoolean;
/* 2271 */     synchronized (this) {
/* 2272 */       if (!paramBoolean) {
/* 2273 */         this.queryStatisticsData = null;
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean getQueryStatistics() {
/* 2279 */     return this.queryStatistics;
/*      */   }
/*      */   
/*      */   public void setQueryStatisticsMaxEntries(int paramInt) {
/* 2283 */     this.queryStatisticsMaxEntries = paramInt;
/* 2284 */     if (this.queryStatisticsData != null) {
/* 2285 */       synchronized (this) {
/* 2286 */         if (this.queryStatisticsData != null) {
/* 2287 */           this.queryStatisticsData.setMaxQueryEntries(this.queryStatisticsMaxEntries);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public QueryStatisticsData getQueryStatisticsData() {
/* 2294 */     if (!this.queryStatistics) {
/* 2295 */       return null;
/*      */     }
/* 2297 */     if (this.queryStatisticsData == null) {
/* 2298 */       synchronized (this) {
/* 2299 */         if (this.queryStatisticsData == null) {
/* 2300 */           this.queryStatisticsData = new QueryStatisticsData(this.queryStatisticsMaxEntries);
/*      */         }
/*      */       } 
/*      */     }
/* 2304 */     return this.queryStatisticsData;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStarting() {
/* 2314 */     return this.starting;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isMultiVersion() {
/* 2323 */     return this.multiVersion;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void opened() {
/* 2331 */     if (this.eventListener != null) {
/* 2332 */       this.eventListener.opened();
/*      */     }
/* 2334 */     if (this.writer != null) {
/* 2335 */       this.writer.startThread();
/*      */     }
/*      */   }
/*      */   
/*      */   public void setMode(Mode paramMode) {
/* 2340 */     this.mode = paramMode;
/*      */   }
/*      */   
/*      */   public Mode getMode() {
/* 2344 */     return this.mode;
/*      */   }
/*      */   
/*      */   public boolean isMultiThreaded() {
/* 2348 */     return this.multiThreaded;
/*      */   }
/*      */   
/*      */   public void setMultiThreaded(boolean paramBoolean) {
/* 2352 */     if (paramBoolean && this.multiThreaded != paramBoolean) {
/* 2353 */       if (this.multiVersion && this.mvStore == null)
/*      */       {
/*      */         
/* 2356 */         throw DbException.get(90021, "MVCC & MULTI_THREADED");
/*      */       }
/*      */ 
/*      */       
/* 2360 */       if (this.lockMode == 0)
/*      */       {
/*      */         
/* 2363 */         throw DbException.get(90021, "LOCK_MODE=0 & MULTI_THREADED");
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2368 */     this.multiThreaded = paramBoolean;
/*      */   }
/*      */   
/*      */   public void setMaxOperationMemory(int paramInt) {
/* 2372 */     this.maxOperationMemory = paramInt;
/*      */   }
/*      */   
/*      */   public int getMaxOperationMemory() {
/* 2376 */     return this.maxOperationMemory;
/*      */   }
/*      */   
/*      */   public Session getExclusiveSession() {
/* 2380 */     return this.exclusiveSession;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExclusiveSession(Session paramSession, boolean paramBoolean) {
/* 2390 */     this.exclusiveSession = paramSession;
/* 2391 */     if (paramBoolean) {
/* 2392 */       closeAllSessionsException(paramSession);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public SmallLRUCache<String, String[]> getLobFileListCache() {
/* 2398 */     if (this.lobFileListCache == null) {
/* 2399 */       this.lobFileListCache = SmallLRUCache.newInstance(128);
/*      */     }
/* 2401 */     return this.lobFileListCache;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSysTableLocked() {
/* 2410 */     return (this.meta == null || this.meta.isLockedExclusively());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSysTableLockedBy(Session paramSession) {
/* 2421 */     return (this.meta == null || this.meta.isLockedExclusivelyBy(paramSession));
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
/*      */   public TableLinkConnection getLinkConnection(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 2435 */     if (this.linkConnections == null) {
/* 2436 */       this.linkConnections = New.hashMap();
/*      */     }
/* 2438 */     return TableLinkConnection.open(this.linkConnections, paramString1, paramString2, paramString3, paramString4, this.dbSettings.shareLinkedConnections);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 2444 */     return this.databaseShortName + ":" + super.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void shutdownImmediately() {
/* 2451 */     setPowerOffCount(1);
/*      */     try {
/* 2453 */       checkPowerOff();
/* 2454 */     } catch (DbException dbException) {}
/*      */ 
/*      */     
/* 2457 */     closeFiles();
/*      */   }
/*      */ 
/*      */   
/*      */   public TempFileDeleter getTempFileDeleter() {
/* 2462 */     return this.tempFileDeleter;
/*      */   }
/*      */   
/*      */   public PageStore getPageStore() {
/* 2466 */     if (this.dbSettings.mvStore) {
/* 2467 */       if (this.mvStore == null) {
/* 2468 */         this.mvStore = MVTableEngine.init(this);
/*      */       }
/* 2470 */       return null;
/*      */     } 
/* 2472 */     if (this.pageStore == null) {
/* 2473 */       this.pageStore = new PageStore(this, this.databaseName + ".h2.db", this.accessModeData, this.cacheSize);
/*      */       
/* 2475 */       if (this.pageSize != 4096) {
/* 2476 */         this.pageStore.setPageSize(this.pageSize);
/*      */       }
/* 2478 */       if (!this.readOnly && this.fileLockMethod == 4) {
/* 2479 */         this.pageStore.setLockFile(true);
/*      */       }
/* 2481 */       this.pageStore.setLogMode(this.logMode);
/* 2482 */       this.pageStore.open();
/*      */     } 
/* 2484 */     return this.pageStore;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Table getFirstUserTable() {
/* 2493 */     for (Table table : getAllTablesAndViews(false)) {
/* 2494 */       if (table.getCreateSQL() == null || 
/* 2495 */         table.isHidden()) {
/*      */         continue;
/*      */       }
/*      */       
/* 2499 */       return table;
/*      */     } 
/*      */     
/* 2502 */     return null;
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
/*      */   public boolean isReconnectNeeded() {
/* 2514 */     if (this.fileLockMethod != 3) {
/* 2515 */       return false;
/*      */     }
/* 2517 */     if (this.reconnectChangePending) {
/* 2518 */       return false;
/*      */     }
/* 2520 */     long l = System.currentTimeMillis();
/* 2521 */     if (l < this.reconnectCheckNext) {
/* 2522 */       return false;
/*      */     }
/* 2524 */     this.reconnectCheckNext = l + this.reconnectCheckDelay;
/* 2525 */     if (this.lock == null) {
/* 2526 */       this.lock = new FileLock(this.traceSystem, this.databaseName + ".lock.db", 1000);
/*      */     }
/*      */     
/*      */     try {
/* 2530 */       Properties properties1 = this.lock.load(), properties2 = properties1;
/*      */       while (true) {
/* 2532 */         if (properties1.equals(this.reconnectLastLock)) {
/* 2533 */           return false;
/*      */         }
/* 2535 */         if (properties1.getProperty("changePending", (String)null) == null) {
/*      */           break;
/*      */         }
/* 2538 */         if (System.currentTimeMillis() > l + (this.reconnectCheckDelay * 10))
/*      */         {
/* 2540 */           if (properties2.equals(properties1)) {
/*      */ 
/*      */             
/* 2543 */             this.lock.setProperty("changePending", null);
/* 2544 */             this.lock.save();
/*      */             break;
/*      */           } 
/*      */         }
/* 2548 */         this.trace.debug("delay (change pending)");
/* 2549 */         Thread.sleep(this.reconnectCheckDelay);
/* 2550 */         properties1 = this.lock.load();
/*      */       } 
/* 2552 */       this.reconnectLastLock = properties1;
/* 2553 */     } catch (Exception exception) {
/*      */       
/* 2555 */       this.trace.error(exception, "readOnly {0}", new Object[] { Boolean.valueOf(this.readOnly) });
/*      */     } 
/*      */     
/* 2558 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void checkpointIfRequired() {
/* 2568 */     if (this.fileLockMethod != 3 || this.readOnly || !this.reconnectChangePending || this.closing) {
/*      */       return;
/*      */     }
/*      */     
/* 2572 */     long l = System.currentTimeMillis();
/* 2573 */     if (l > this.reconnectCheckNext + this.reconnectCheckDelay) {
/* 2574 */       if (SysProperties.CHECK && this.checkpointAllowed < 0) {
/* 2575 */         DbException.throwInternalError();
/*      */       }
/* 2577 */       synchronized (this.reconnectSync) {
/* 2578 */         if (this.checkpointAllowed > 0) {
/*      */           return;
/*      */         }
/* 2581 */         this.checkpointRunning = true;
/*      */       } 
/* 2583 */       synchronized (this) {
/* 2584 */         this.trace.debug("checkpoint start");
/* 2585 */         flushSequences();
/* 2586 */         checkpoint();
/* 2587 */         reconnectModified(false);
/* 2588 */         this.trace.debug("checkpoint end");
/*      */       } 
/* 2590 */       synchronized (this.reconnectSync) {
/* 2591 */         this.checkpointRunning = false;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isFileLockSerialized() {
/* 2597 */     return (this.fileLockMethod == 3);
/*      */   }
/*      */   
/*      */   private void flushSequences() {
/* 2601 */     for (SchemaObject schemaObject : getAllSchemaObjects(3)) {
/* 2602 */       Sequence sequence = (Sequence)schemaObject;
/* 2603 */       sequence.flushWithoutMargin();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void checkpoint() {
/* 2611 */     if (this.persistent) {
/* 2612 */       synchronized (this) {
/* 2613 */         if (this.pageStore != null) {
/* 2614 */           this.pageStore.checkpoint();
/*      */         }
/*      */       } 
/* 2617 */       if (this.mvStore != null) {
/* 2618 */         this.mvStore.flush();
/*      */       }
/*      */     } 
/* 2621 */     getTempFileDeleter().deleteUnused();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean beforeWriting() {
/* 2631 */     if (this.fileLockMethod != 3) {
/* 2632 */       return true;
/*      */     }
/* 2634 */     while (this.checkpointRunning) {
/*      */       try {
/* 2636 */         Thread.sleep((10 + (int)(Math.random() * 10.0D)));
/* 2637 */       } catch (Exception exception) {}
/*      */     } 
/*      */ 
/*      */     
/* 2641 */     synchronized (this.reconnectSync) {
/* 2642 */       if (reconnectModified(true)) {
/* 2643 */         this.checkpointAllowed++;
/* 2644 */         if (SysProperties.CHECK && this.checkpointAllowed > 20) {
/* 2645 */           throw DbException.throwInternalError();
/*      */         }
/* 2647 */         return true;
/*      */       } 
/*      */     } 
/*      */     
/* 2651 */     this.reconnectCheckNext = System.currentTimeMillis() - 1L;
/* 2652 */     this.reconnectLastLock = null;
/* 2653 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void afterWriting() {
/* 2660 */     if (this.fileLockMethod != 3) {
/*      */       return;
/*      */     }
/* 2663 */     synchronized (this.reconnectSync) {
/* 2664 */       this.checkpointAllowed--;
/*      */     } 
/* 2666 */     if (SysProperties.CHECK && this.checkpointAllowed < 0) {
/* 2667 */       throw DbException.throwInternalError();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReadOnly(boolean paramBoolean) {
/* 2677 */     this.readOnly = paramBoolean;
/*      */   }
/*      */   
/*      */   public void setCompactMode(int paramInt) {
/* 2681 */     this.compactMode = paramInt;
/*      */   }
/*      */   
/*      */   public SourceCompiler getCompiler() {
/* 2685 */     if (this.compiler == null) {
/* 2686 */       this.compiler = new SourceCompiler();
/*      */     }
/* 2688 */     return this.compiler;
/*      */   }
/*      */ 
/*      */   
/*      */   public LobStorageInterface getLobStorage() {
/* 2693 */     if (this.lobStorage == null) {
/* 2694 */       if (this.dbSettings.mvStore) {
/* 2695 */         this.lobStorage = (LobStorageInterface)new LobStorageMap(this);
/*      */       } else {
/* 2697 */         this.lobStorage = (LobStorageInterface)new LobStorageBackend(this);
/*      */       } 
/*      */     }
/* 2700 */     return this.lobStorage;
/*      */   }
/*      */   
/*      */   public JdbcConnection getLobConnectionForInit() {
/* 2704 */     String str = "jdbc:default:connection";
/* 2705 */     JdbcConnection jdbcConnection = new JdbcConnection(this.systemSession, this.systemUser.getName(), str);
/*      */     
/* 2707 */     jdbcConnection.setTraceLevel(0);
/* 2708 */     return jdbcConnection;
/*      */   }
/*      */   
/*      */   public JdbcConnection getLobConnectionForRegularUse() {
/* 2712 */     String str = "jdbc:default:connection";
/* 2713 */     JdbcConnection jdbcConnection = new JdbcConnection(this.lobSession, this.systemUser.getName(), str);
/*      */     
/* 2715 */     jdbcConnection.setTraceLevel(0);
/* 2716 */     return jdbcConnection;
/*      */   }
/*      */   
/*      */   public Session getLobSession() {
/* 2720 */     return this.lobSession;
/*      */   }
/*      */   
/*      */   public void setLogMode(int paramInt) {
/* 2724 */     if (paramInt < 0 || paramInt > 2) {
/* 2725 */       throw DbException.getInvalidValueException("LOG", Integer.valueOf(paramInt));
/*      */     }
/* 2727 */     if (this.pageStore != null) {
/* 2728 */       if (paramInt != 2 || this.pageStore.getLogMode() != 2)
/*      */       {
/*      */ 
/*      */         
/* 2732 */         this.trace.error(null, "log {0}", new Object[] { Integer.valueOf(paramInt) });
/*      */       }
/* 2734 */       this.logMode = paramInt;
/* 2735 */       this.pageStore.setLogMode(paramInt);
/*      */     } 
/* 2737 */     if (this.mvStore != null) {
/* 2738 */       this.logMode = paramInt;
/*      */     }
/*      */   }
/*      */   
/*      */   public int getLogMode() {
/* 2743 */     if (this.pageStore != null) {
/* 2744 */       return this.pageStore.getLogMode();
/*      */     }
/* 2746 */     if (this.mvStore != null) {
/* 2747 */       return this.logMode;
/*      */     }
/* 2749 */     return 0;
/*      */   }
/*      */   
/*      */   public int getDefaultTableType() {
/* 2753 */     return this.defaultTableType;
/*      */   }
/*      */   
/*      */   public void setDefaultTableType(int paramInt) {
/* 2757 */     this.defaultTableType = paramInt;
/*      */   }
/*      */   
/*      */   public void setMultiVersion(boolean paramBoolean) {
/* 2761 */     this.multiVersion = paramBoolean;
/*      */   }
/*      */   
/*      */   public DbSettings getSettings() {
/* 2765 */     return this.dbSettings;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <V> HashMap<String, V> newStringMap() {
/* 2776 */     return this.dbSettings.databaseToUpper ? new HashMap<>() : (HashMap<String, V>)new CaseInsensitiveMap();
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
/*      */   public <V> ConcurrentHashMap<String, V> newConcurrentStringMap() {
/* 2789 */     return this.dbSettings.databaseToUpper ? (ConcurrentHashMap<String, V>)new NullableKeyConcurrentMap() : (ConcurrentHashMap<String, V>)new CaseInsensitiveConcurrentMap();
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
/*      */   public boolean equalsIdentifiers(String paramString1, String paramString2) {
/* 2803 */     if (paramString1 == paramString2 || paramString1.equals(paramString2)) {
/* 2804 */       return true;
/*      */     }
/* 2806 */     if (!this.dbSettings.databaseToUpper && paramString1.equalsIgnoreCase(paramString2)) {
/* 2807 */       return true;
/*      */     }
/* 2809 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int readLob(long paramLong1, byte[] paramArrayOfbyte1, long paramLong2, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2) {
/* 2815 */     throw DbException.throwInternalError();
/*      */   }
/*      */   
/*      */   public byte[] getFileEncryptionKey() {
/* 2819 */     return this.fileEncryptionKey;
/*      */   }
/*      */   
/*      */   public int getPageSize() {
/* 2823 */     return this.pageSize;
/*      */   }
/*      */ 
/*      */   
/*      */   public JavaObjectSerializer getJavaObjectSerializer() {
/* 2828 */     initJavaObjectSerializer();
/* 2829 */     return this.javaObjectSerializer;
/*      */   }
/*      */   
/*      */   private void initJavaObjectSerializer() {
/* 2833 */     if (this.javaObjectSerializerInitialized) {
/*      */       return;
/*      */     }
/* 2836 */     synchronized (this) {
/* 2837 */       if (this.javaObjectSerializerInitialized) {
/*      */         return;
/*      */       }
/* 2840 */       String str = this.javaObjectSerializerName;
/* 2841 */       if (str != null) {
/* 2842 */         str = str.trim();
/* 2843 */         if (!str.isEmpty() && !str.equals("null")) {
/*      */           
/*      */           try {
/* 2846 */             this.javaObjectSerializer = JdbcUtils.loadUserClass(str).newInstance();
/*      */           }
/* 2848 */           catch (Exception exception) {
/* 2849 */             throw DbException.convert(exception);
/*      */           } 
/*      */         }
/*      */       } 
/* 2853 */       this.javaObjectSerializerInitialized = true;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setJavaObjectSerializerName(String paramString) {
/* 2858 */     synchronized (this) {
/* 2859 */       this.javaObjectSerializerInitialized = false;
/* 2860 */       this.javaObjectSerializerName = paramString;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TableEngine getTableEngine(String paramString) {
/* 2871 */     assert Thread.holdsLock(this);
/*      */     
/* 2873 */     TableEngine tableEngine = this.tableEngines.get(paramString);
/* 2874 */     if (tableEngine == null) {
/*      */       try {
/* 2876 */         tableEngine = JdbcUtils.loadUserClass(paramString).newInstance();
/* 2877 */       } catch (Exception exception) {
/* 2878 */         throw DbException.convert(exception);
/*      */       } 
/* 2880 */       this.tableEngines.put(paramString, tableEngine);
/*      */     } 
/* 2882 */     return tableEngine;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\Database.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */