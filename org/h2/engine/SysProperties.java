/*     */ package org.h2.engine;
/*     */ 
/*     */ import org.h2.util.MathUtils;
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
/*     */ public class SysProperties
/*     */ {
/*     */   public static final String H2_SCRIPT_DIRECTORY = "h2.scriptDirectory";
/*     */   public static final String H2_BROWSER = "h2.browser";
/*  49 */   public static final String FILE_ENCODING = Utils.getProperty("file.encoding", "Cp1252");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   public static final String FILE_SEPARATOR = Utils.getProperty("file.separator", "/");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   public static final String JAVA_SPECIFICATION_VERSION = Utils.getProperty("java.specification.version", "1.4");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   public static final String LINE_SEPARATOR = Utils.getProperty("line.separator", "\n");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   public static final String USER_HOME = Utils.getProperty("user.home", "");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   public static final String ALLOWED_CLASSES = Utils.getProperty("h2.allowedClasses", "*");
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
/*  96 */   public static final String BROWSER = Utils.getProperty("h2.browser", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   public static final boolean ENABLE_ANONYMOUS_TLS = Utils.getProperty("h2.enableAnonymousTLS", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   public static final String BIND_ADDRESS = Utils.getProperty("h2.bindAddress", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 118 */   public static final boolean CHECK = Utils.getProperty("h2.check", true);
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
/* 129 */   public static final boolean CHECK2 = Utils.getProperty("h2.check2", false);
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
/* 141 */   public static final String CLIENT_TRACE_DIRECTORY = Utils.getProperty("h2.clientTraceDirectory", "trace.db/");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 149 */   public static final int COLLATOR_CACHE_SIZE = Utils.getProperty("h2.collatorCacheSize", 32000);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   public static final int CONSOLE_MAX_TABLES_LIST_INDEXES = Utils.getProperty("h2.consoleTableIndexes", 100);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 165 */   public static final int CONSOLE_MAX_TABLES_LIST_COLUMNS = Utils.getProperty("h2.consoleTableColumns", 500);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 173 */   public static final int CONSOLE_MAX_PROCEDURES_LIST_COLUMNS = Utils.getProperty("h2.consoleProcedureColumns", 300);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 180 */   public static final boolean CONSOLE_STREAM = Utils.getProperty("h2.consoleStream", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 187 */   public static final int CONSOLE_TIMEOUT = Utils.getProperty("h2.consoleTimeout", 1800000);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 195 */   public static final int DATASOURCE_TRACE_LEVEL = Utils.getProperty("h2.dataSourceTraceLevel", 1);
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
/* 207 */   public static final int DELAY_WRONG_PASSWORD_MIN = Utils.getProperty("h2.delayWrongPasswordMin", 250);
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
/* 218 */   public static final int DELAY_WRONG_PASSWORD_MAX = Utils.getProperty("h2.delayWrongPasswordMax", 4000);
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
/* 229 */   public static final boolean JAVA_SYSTEM_COMPILER = Utils.getProperty("h2.javaSystemCompiler", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 237 */   public static boolean lobCloseBetweenReads = Utils.getProperty("h2.lobCloseBetweenReads", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 245 */   public static final int LOB_FILES_PER_DIRECTORY = Utils.getProperty("h2.lobFilesPerDirectory", 256);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 254 */   public static final int LOB_CLIENT_MAX_SIZE_MEMORY = Utils.getProperty("h2.lobClientMaxSizeMemory", 1048576);
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
/* 265 */   public static final int MAX_FILE_RETRY = Math.max(1, Utils.getProperty("h2.maxFileRetry", 16));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 272 */   public static final int MAX_RECONNECT = Utils.getProperty("h2.maxReconnect", 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 280 */   public static final int MAX_MEMORY_ROWS = getAutoScaledForMemoryProperty("h2.maxMemoryRows", 40000);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 289 */   public static final long MAX_TRACE_DATA_LENGTH = Utils.getProperty("h2.maxTraceDataLength", 65535);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 299 */   public static final boolean MODIFY_ON_WRITE = Utils.getProperty("h2.modifyOnWrite", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 307 */   public static final boolean NIO_LOAD_MAPPED = Utils.getProperty("h2.nioLoadMapped", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 317 */   public static final boolean NIO_CLEANER_HACK = Utils.getProperty("h2.nioCleanerHack", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 325 */   public static final boolean OBJECT_CACHE = Utils.getProperty("h2.objectCache", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 333 */   public static final int OBJECT_CACHE_MAX_PER_ELEMENT_SIZE = Utils.getProperty("h2.objectCacheMaxPerElementSize", 4096);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 341 */   public static final int OBJECT_CACHE_SIZE = MathUtils.nextPowerOf2(Utils.getProperty("h2.objectCacheSize", 1024));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 349 */   public static final boolean OLD_STYLE_OUTER_JOIN = Utils.getProperty("h2.oldStyleOuterJoin", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 358 */   public static final String PG_DEFAULT_CLIENT_ENCODING = Utils.getProperty("h2.pgClientEncoding", "UTF-8");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 365 */   public static final String PREFIX_TEMP_FILE = Utils.getProperty("h2.prefixTempFile", "h2.temp");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 372 */   public static final int SERVER_CACHED_OBJECTS = Utils.getProperty("h2.serverCachedObjects", 64);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 380 */   public static final int SERVER_RESULT_SET_FETCH_SIZE = Utils.getProperty("h2.serverResultSetFetchSize", 100);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 389 */   public static final int SOCKET_CONNECT_RETRY = Utils.getProperty("h2.socketConnectRetry", 16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 397 */   public static final int SOCKET_CONNECT_TIMEOUT = Utils.getProperty("h2.socketConnectTimeout", 2000);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 406 */   public static final boolean SORT_BINARY_UNSIGNED = Utils.getProperty("h2.sortBinaryUnsigned", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 416 */   public static final boolean SORT_NULLS_HIGH = Utils.getProperty("h2.sortNullsHigh", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 423 */   public static final long SPLIT_FILE_SIZE_SHIFT = Utils.getProperty("h2.splitFileSizeShift", 30);
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
/* 436 */   public static final String SYNC_METHOD = Utils.getProperty("h2.syncMethod", "sync");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 443 */   public static final boolean TRACE_IO = Utils.getProperty("h2.traceIO", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 451 */   public static final boolean THREAD_DEADLOCK_DETECTOR = Utils.getProperty("h2.threadDeadlockDetector", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 460 */   public static final boolean IMPLICIT_RELATIVE_PATH = Utils.getProperty("h2.implicitRelativePath", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 470 */   public static final String URL_MAP = Utils.getProperty("h2.urlMap", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 479 */   public static final boolean USE_THREAD_CONTEXT_CLASS_LOADER = Utils.getProperty("h2.useThreadContextClassLoader", false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 512 */   public static boolean serializeJavaObject = Utils.getProperty("h2.serializeJavaObject", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 522 */   public static final String JAVA_OBJECT_SERIALIZER = Utils.getProperty("h2.javaObjectSerializer", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String H2_BASE_DIR = "h2.baseDir";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setBaseDir(String paramString) {
/* 535 */     if (!paramString.endsWith("/")) {
/* 536 */       paramString = paramString + "/";
/*     */     }
/* 538 */     System.setProperty("h2.baseDir", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getBaseDir() {
/* 545 */     return Utils.getProperty("h2.baseDir", null);
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
/*     */   public static String getScriptDirectory() {
/* 557 */     return Utils.getProperty("h2.scriptDirectory", "");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getAutoScaledForMemoryProperty(String paramString, int paramInt) {
/* 567 */     String str = Utils.getProperty(paramString, null);
/* 568 */     if (str != null) {
/*     */       try {
/* 570 */         return Integer.decode(str).intValue();
/* 571 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */     
/* 575 */     return Utils.scaleForAvailableMemory(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\SysProperties.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */