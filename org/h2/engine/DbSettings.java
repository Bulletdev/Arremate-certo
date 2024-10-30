/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DbSettings
/*     */   extends SettingsBase
/*     */ {
/*     */   private static DbSettings defaultSettings;
/*  37 */   public final boolean aliasColumnName = get("ALIAS_COLUMN_NAME", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   public final int analyzeAuto = get("ANALYZE_AUTO", 2000);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   public final int analyzeSample = get("ANALYZE_SAMPLE", 10000);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   public final boolean databaseToUpper = get("DATABASE_TO_UPPER", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public final boolean dbCloseOnExit = get("DB_CLOSE_ON_EXIT", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public boolean defaultConnection = get("DEFAULT_CONNECTION", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   public final String defaultEscape = get("DEFAULT_ESCAPE", "\\");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   public final boolean defragAlways = get("DEFRAG_ALWAYS", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   public final boolean dropRestrict = get("DROP_RESTRICT", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 109 */   public final boolean earlyFilter = get("EARLY_FILTER", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 117 */   public final int estimatedFunctionTableRows = get("ESTIMATED_FUNCTION_TABLE_ROWS", 1000);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public final boolean functionsInSchema = get("FUNCTIONS_IN_SCHEMA", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 134 */   public final boolean largeTransactions = get("LARGE_TRANSACTIONS", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 143 */   public final int lobTimeout = get("LOB_TIMEOUT", 300000);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 150 */   public final int maxCompactCount = get("MAX_COMPACT_COUNT", 2147483647);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   public final int maxCompactTime = get("MAX_COMPACT_TIME", 200);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 165 */   public int maxQueryTimeout = get("MAX_QUERY_TIMEOUT", 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 171 */   public final boolean nestedJoins = get("NESTED_JOINS", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 185 */   public final boolean optimizeDistinct = get("OPTIMIZE_DISTINCT", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 192 */   public final boolean optimizeEvaluatableSubqueries = get("OPTIMIZE_EVALUATABLE_SUBQUERIES", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 201 */   public final boolean optimizeInsertFromSelect = get("OPTIMIZE_INSERT_FROM_SELECT", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 209 */   public final boolean optimizeInList = get("OPTIMIZE_IN_LIST", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 216 */   public final boolean optimizeInSelect = get("OPTIMIZE_IN_SELECT", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 222 */   public final boolean optimizeIsNull = get("OPTIMIZE_IS_NULL", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 228 */   public final boolean optimizeOr = get("OPTIMIZE_OR", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 235 */   public final boolean optimizeTwoEquals = get("OPTIMIZE_TWO_EQUALS", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 242 */   public final boolean optimizeUpdate = get("OPTIMIZE_UPDATE", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 249 */   public final int pageStoreMaxGrowth = get("PAGE_STORE_MAX_GROWTH", 131072);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 257 */   public final boolean pageStoreInternalCount = get("PAGE_STORE_INTERNAL_COUNT", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 264 */   public final boolean pageStoreTrim = get("PAGE_STORE_TRIM", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 277 */   public final int queryCacheSize = get("QUERY_CACHE_SIZE", 8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 283 */   public final boolean recompileAlways = get("RECOMPILE_ALWAYS", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 292 */   public final int reconnectCheckDelay = get("RECONNECT_CHECK_DELAY", 200);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 300 */   public final boolean reuseSpace = get("REUSE_SPACE", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 306 */   public final boolean rowId = get("ROWID", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 314 */   public final boolean selectForUpdateMvcc = get("SELECT_FOR_UPDATE_MVCC", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 323 */   public final boolean shareLinkedConnections = get("SHARE_LINKED_CONNECTIONS", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 331 */   public final String defaultTableEngine = get("DEFAULT_TABLE_ENGINE", (String)null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 338 */   public boolean mvStore = get("MV_STORE", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 345 */   public final boolean compressData = get("COMPRESS", false);
/*     */   
/*     */   private DbSettings(HashMap<String, String> paramHashMap) {
/* 348 */     super(paramHashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DbSettings getInstance(HashMap<String, String> paramHashMap) {
/* 359 */     return new DbSettings(paramHashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DbSettings getDefaultSettings() {
/* 369 */     if (defaultSettings == null) {
/* 370 */       defaultSettings = new DbSettings(new HashMap<>());
/*     */     }
/* 372 */     return defaultSettings;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\DbSettings.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */