/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.util.New;
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
/*     */ public class SetTypes
/*     */ {
/*     */   public static final int IGNORECASE = 1;
/*     */   public static final int MAX_LOG_SIZE = 2;
/*     */   public static final int MODE = 3;
/*     */   public static final int READONLY = 4;
/*     */   public static final int LOCK_TIMEOUT = 5;
/*     */   public static final int DEFAULT_LOCK_TIMEOUT = 6;
/*     */   public static final int DEFAULT_TABLE_TYPE = 7;
/*     */   public static final int CACHE_SIZE = 8;
/*     */   public static final int TRACE_LEVEL_SYSTEM_OUT = 9;
/*     */   public static final int TRACE_LEVEL_FILE = 10;
/*     */   public static final int TRACE_MAX_FILE_SIZE = 11;
/*     */   public static final int COLLATION = 12;
/*     */   public static final int CLUSTER = 13;
/*     */   public static final int WRITE_DELAY = 14;
/*     */   public static final int DATABASE_EVENT_LISTENER = 15;
/*     */   public static final int MAX_MEMORY_ROWS = 16;
/*     */   public static final int LOCK_MODE = 17;
/*     */   public static final int DB_CLOSE_DELAY = 18;
/*     */   public static final int LOG = 19;
/*     */   public static final int THROTTLE = 20;
/*     */   public static final int MAX_MEMORY_UNDO = 21;
/*     */   public static final int MAX_LENGTH_INPLACE_LOB = 22;
/*     */   public static final int COMPRESS_LOB = 23;
/*     */   public static final int ALLOW_LITERALS = 24;
/*     */   public static final int MULTI_THREADED = 25;
/*     */   public static final int SCHEMA = 26;
/*     */   public static final int OPTIMIZE_REUSE_RESULTS = 27;
/*     */   public static final int SCHEMA_SEARCH_PATH = 28;
/*     */   public static final int UNDO_LOG = 29;
/*     */   public static final int REFERENTIAL_INTEGRITY = 30;
/*     */   public static final int MVCC = 31;
/*     */   public static final int MAX_OPERATION_MEMORY = 32;
/*     */   public static final int EXCLUSIVE = 33;
/*     */   public static final int CREATE_BUILD = 34;
/*     */   public static final int VARIABLE = 35;
/*     */   public static final int QUERY_TIMEOUT = 36;
/*     */   public static final int REDO_LOG_BINARY = 37;
/*     */   public static final int BINARY_COLLATION = 38;
/*     */   public static final int JAVA_OBJECT_SERIALIZER = 39;
/*     */   public static final int RETENTION_TIME = 40;
/*     */   public static final int QUERY_STATISTICS = 41;
/*     */   public static final int QUERY_STATISTICS_MAX_ENTRIES = 42;
/*     */   public static final int ROW_FACTORY = 43;
/*     */   public static final int BATCH_JOINS = 44;
/*     */   public static final int FORCE_JOIN_ORDER = 45;
/* 241 */   private static final ArrayList<String> TYPES = New.arrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 248 */     ArrayList<String> arrayList = TYPES;
/* 249 */     arrayList.add(null);
/* 250 */     arrayList.add(1, "IGNORECASE");
/* 251 */     arrayList.add(2, "MAX_LOG_SIZE");
/* 252 */     arrayList.add(3, "MODE");
/* 253 */     arrayList.add(4, "READONLY");
/* 254 */     arrayList.add(5, "LOCK_TIMEOUT");
/* 255 */     arrayList.add(6, "DEFAULT_LOCK_TIMEOUT");
/* 256 */     arrayList.add(7, "DEFAULT_TABLE_TYPE");
/* 257 */     arrayList.add(8, "CACHE_SIZE");
/* 258 */     arrayList.add(9, "TRACE_LEVEL_SYSTEM_OUT");
/* 259 */     arrayList.add(10, "TRACE_LEVEL_FILE");
/* 260 */     arrayList.add(11, "TRACE_MAX_FILE_SIZE");
/* 261 */     arrayList.add(12, "COLLATION");
/* 262 */     arrayList.add(13, "CLUSTER");
/* 263 */     arrayList.add(14, "WRITE_DELAY");
/* 264 */     arrayList.add(15, "DATABASE_EVENT_LISTENER");
/* 265 */     arrayList.add(16, "MAX_MEMORY_ROWS");
/* 266 */     arrayList.add(17, "LOCK_MODE");
/* 267 */     arrayList.add(18, "DB_CLOSE_DELAY");
/* 268 */     arrayList.add(19, "LOG");
/* 269 */     arrayList.add(20, "THROTTLE");
/* 270 */     arrayList.add(21, "MAX_MEMORY_UNDO");
/* 271 */     arrayList.add(22, "MAX_LENGTH_INPLACE_LOB");
/* 272 */     arrayList.add(23, "COMPRESS_LOB");
/* 273 */     arrayList.add(24, "ALLOW_LITERALS");
/* 274 */     arrayList.add(25, "MULTI_THREADED");
/* 275 */     arrayList.add(26, "SCHEMA");
/* 276 */     arrayList.add(27, "OPTIMIZE_REUSE_RESULTS");
/* 277 */     arrayList.add(28, "SCHEMA_SEARCH_PATH");
/* 278 */     arrayList.add(29, "UNDO_LOG");
/* 279 */     arrayList.add(30, "REFERENTIAL_INTEGRITY");
/* 280 */     arrayList.add(31, "MVCC");
/* 281 */     arrayList.add(32, "MAX_OPERATION_MEMORY");
/* 282 */     arrayList.add(33, "EXCLUSIVE");
/* 283 */     arrayList.add(34, "CREATE_BUILD");
/* 284 */     arrayList.add(35, "@");
/* 285 */     arrayList.add(36, "QUERY_TIMEOUT");
/* 286 */     arrayList.add(37, "REDO_LOG_BINARY");
/* 287 */     arrayList.add(38, "BINARY_COLLATION");
/* 288 */     arrayList.add(39, "JAVA_OBJECT_SERIALIZER");
/* 289 */     arrayList.add(40, "RETENTION_TIME");
/* 290 */     arrayList.add(41, "QUERY_STATISTICS");
/* 291 */     arrayList.add(42, "QUERY_STATISTICS_MAX_ENTRIES");
/* 292 */     arrayList.add(43, "ROW_FACTORY");
/* 293 */     arrayList.add(44, "BATCH_JOINS");
/* 294 */     arrayList.add(45, "FORCE_JOIN_ORDER");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getType(String paramString) {
/* 304 */     for (byte b = 0; b < getTypes().size(); b++) {
/* 305 */       if (paramString.equals(getTypes().get(b))) {
/* 306 */         return b;
/*     */       }
/*     */     } 
/* 309 */     return -1;
/*     */   }
/*     */   
/*     */   public static ArrayList<String> getTypes() {
/* 313 */     return TYPES;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getTypeName(int paramInt) {
/* 323 */     return getTypes().get(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\SetTypes.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */