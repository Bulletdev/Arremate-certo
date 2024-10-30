/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.nio.charset.Charset;
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
/*     */ public class Constants
/*     */ {
/*     */   public static final String BUILD_DATE = "2016-10-31";
/*     */   public static final String BUILD_DATE_STABLE = "2014-04-05";
/*     */   public static final int BUILD_ID = 193;
/*     */   public static final int BUILD_ID_STABLE = 176;
/*     */   public static final boolean BUILD_SNAPSHOT = false;
/*  47 */   public static final String BUILD_VENDOR_AND_VERSION = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TCP_PROTOCOL_VERSION_6 = 6;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TCP_PROTOCOL_VERSION_7 = 7;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TCP_PROTOCOL_VERSION_8 = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TCP_PROTOCOL_VERSION_9 = 9;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TCP_PROTOCOL_VERSION_10 = 10;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TCP_PROTOCOL_VERSION_11 = 11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TCP_PROTOCOL_VERSION_12 = 12;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TCP_PROTOCOL_VERSION_13 = 13;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TCP_PROTOCOL_VERSION_14 = 14;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TCP_PROTOCOL_VERSION_15 = 15;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int VERSION_MAJOR = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int VERSION_MINOR = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_MODE_OFF = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_MODE_READ_COMMITTED = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_MODE_TABLE = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_MODE_TABLE_GC = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int ALLOW_LITERALS_ALL = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int ALLOW_LITERALS_NONE = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int ALLOW_LITERALS_NUMBERS = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean BLOB_SEARCH = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int CACHE_MIN_RECORDS = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int CACHE_SIZE_DEFAULT = 65536;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String CACHE_TYPE_DEFAULT = "LRU";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String CLUSTERING_DISABLED = "''";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String CLUSTERING_ENABLED = "TRUE";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String CONN_URL_COLUMNLIST = "jdbc:columnlist:connection";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String CONN_URL_INTERNAL = "jdbc:default:connection";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int COST_ROW_OFFSET = 1000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DEADLOCK_CHECK = 100;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DEFAULT_HTTP_PORT = 8082;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DEFAULT_LOCK_MODE = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DEFAULT_MAX_LENGTH_INPLACE_LOB = 256;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final long DEFAULT_MAX_LOG_SIZE = 16777216L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DEFAULT_MAX_MEMORY_UNDO = 50000;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DEFAULT_MAX_OPERATION_MEMORY = 100000;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DEFAULT_PAGE_SIZE = 4096;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DEFAULT_RESULT_SET_CONCURRENCY = 1007;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DEFAULT_TCP_PORT = 9092;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DEFAULT_WRITE_DELAY = 500;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int ENCRYPTION_KEY_HASH_ITERATIONS = 1024;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FILE_BLOCK_SIZE = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int INITIAL_LOCK_TIMEOUT = 2000;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int IO_BUFFER_SIZE = 4096;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int IO_BUFFER_SIZE_COMPRESS = 131072;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LOCK_SLEEP = 1000;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MAX_PARAMETER_INDEX = 100000;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MEMORY_DATA = 24;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MEMORY_FACTOR = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MEMORY_OBJECT = 24;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MEMORY_PAGE_BTREE = 184;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MEMORY_PAGE_DATA = 240;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MEMORY_PAGE_DATA_OVERFLOW = 120;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MEMORY_POINTER = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MEMORY_ROW = 40;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MIN_WRITE_DELAY = 5;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String PREFIX_INDEX = "INDEX_";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String PREFIX_JOIN = "SYSTEM_JOIN_";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String PREFIX_PRIMARY_KEY = "PRIMARY_KEY_";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String PUBLIC_ROLE_NAME = "PUBLIC";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int SALT_LEN = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SCHEMA_MAIN = "PUBLIC";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int SELECTIVITY_DEFAULT = 50;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int SELECTIVITY_DISTINCT_COUNT = 10000;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SERVER_PROPERTIES_DIR = "~";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SERVER_PROPERTIES_NAME = ".h2.server.properties";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final long SLOW_QUERY_LIMIT_MS = 100L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String START_URL = "jdbc:h2:";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SUFFIX_DB_FILE = ".db";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SUFFIX_LOB_FILE = ".lob.db";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SUFFIX_LOBS_DIRECTORY = ".lobs.db";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SUFFIX_LOCK_FILE = ".lock.db";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SUFFIX_OLD_DATABASE_FILE = ".data.db";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SUFFIX_PAGE_FILE = ".h2.db";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SUFFIX_MV_FILE = ".mv.db";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SUFFIX_MV_STORE_NEW_FILE = ".newFile";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SUFFIX_MV_STORE_TEMP_FILE = ".tempFile";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SUFFIX_TEMP_FILE = ".temp.db";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String SUFFIX_TRACE_FILE = ".trace.db";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int THROTTLE_DELAY = 50;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int UNDO_BLOCK_SIZE = 1048576;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String URL_FORMAT = "jdbc:h2:{ {.|mem:}[name] | [file:]fileName | {tcp|ssl}:[//]server[:port][,server2[:port]]/name }[;key=value...]";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String USER_PACKAGE = "org.h2.dynamic";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 494 */   public static final Charset UTF8 = Charset.forName("UTF-8");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int VIEW_COST_CACHE_MAX_AGE = 10000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int VIEW_INDEX_CACHE_SIZE = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int QUERY_STATISTICS_MAX_ENTRIES = 100;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getVersion() {
/* 524 */     String str = "1.4.193";
/* 525 */     if (BUILD_VENDOR_AND_VERSION != null) {
/* 526 */       str = str + "_" + BUILD_VENDOR_AND_VERSION;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 531 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object getVersionStable() {
/* 540 */     return "1.3.176";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getFullVersion() {
/* 550 */     return getVersion() + " (" + "2016-10-31" + ")";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\Constants.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */