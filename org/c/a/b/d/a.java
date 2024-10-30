/*     */ package org.c.a.b.d;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.StringReader;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import javax.sql.DataSource;
/*     */ import org.c.a.a.b;
/*     */ import org.c.a.a.b.b;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.a.c.c;
/*     */ import org.c.a.a.c.e;
/*     */ import org.c.a.a.d.c;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.a.h.c;
/*     */ import org.c.a.b.r.h;
/*     */ import org.c.a.b.r.n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */ {
/*  49 */   private static org.c.a.a.f.a a = c.b(a.class);
/*     */   
/*     */   public static final String jU = "flyway.conf";
/*     */   
/*     */   @Deprecated
/*     */   public static final String jV = "flyway.configFile";
/*     */   
/*     */   public static final String jW = "flyway.configFiles";
/*     */   
/*     */   public static final String jX = "flyway.configFileEncoding";
/*     */   
/*     */   public static final String jY = "flyway.baselineDescription";
/*     */   
/*     */   public static final String jZ = "flyway.baselineOnMigrate";
/*     */   
/*     */   public static final String ka = "flyway.baselineVersion";
/*     */   
/*     */   public static final String kb = "flyway.batch";
/*     */   
/*     */   public static final String kc = "flyway.callbacks";
/*     */   
/*     */   public static final String kd = "flyway.cleanDisabled";
/*     */   
/*     */   public static final String ke = "flyway.cleanOnValidationError";
/*     */   
/*     */   public static final String kf = "flyway.connectRetries";
/*     */   
/*     */   public static final String kg = "flyway.driver";
/*     */   
/*     */   public static final String kh = "flyway.dryRunOutput";
/*     */   
/*     */   public static final String ENCODING = "flyway.encoding";
/*     */   
/*     */   @Deprecated
/*     */   public static final String ki = "flyway.errorHandlers";
/*     */   
/*     */   public static final String kj = "flyway.errorOverrides";
/*     */   
/*     */   public static final String kk = "flyway.group";
/*     */   
/*     */   public static final String kl = "flyway.ignoreFutureMigrations";
/*     */   
/*     */   public static final String km = "flyway.ignoreMissingMigrations";
/*     */   
/*     */   public static final String kn = "flyway.ignoreIgnoredMigrations";
/*     */   
/*     */   public static final String ko = "flyway.ignorePendingMigrations";
/*     */   
/*     */   public static final String kp = "flyway.initSql";
/*     */   
/*     */   public static final String kq = "flyway.installedBy";
/*     */   
/*     */   public static final String kr = "flyway.licenseKey";
/*     */   
/*     */   public static final String ks = "flyway.locations";
/*     */   
/*     */   public static final String kt = "flyway.mixed";
/*     */   
/*     */   public static final String ku = "flyway.outOfOrder";
/*     */   public static final String kv = "flyway.password";
/*     */   public static final String kw = "flyway.placeholderPrefix";
/*     */   public static final String kx = "flyway.placeholderReplacement";
/*     */   public static final String ky = "flyway.placeholderSuffix";
/*     */   public static final String kz = "flyway.placeholders.";
/*     */   public static final String kA = "flyway.repeatableSqlMigrationPrefix";
/*     */   public static final String kB = "flyway.resolvers";
/*     */   public static final String kC = "flyway.schemas";
/*     */   public static final String kD = "flyway.skipDefaultCallbacks";
/*     */   public static final String kE = "flyway.skipDefaultResolvers";
/*     */   public static final String kF = "flyway.sqlMigrationPrefix";
/*     */   public static final String kG = "flyway.sqlMigrationSeparator";
/*     */   @Deprecated
/*     */   public static final String kH = "flyway.sqlMigrationSuffix";
/*     */   public static final String kI = "flyway.sqlMigrationSuffixes";
/*     */   public static final String kJ = "flyway.stream";
/*     */   public static final String TABLE = "flyway.table";
/*     */   public static final String kK = "flyway.target";
/*     */   public static final String kL = "flyway.undoSqlMigrationPrefix";
/*     */   public static final String kM = "flyway.url";
/*     */   public static final String kN = "flyway.user";
/*     */   public static final String kO = "flyway.validateOnMigrate";
/*     */   public static final String kP = "flyway.oracle.sqlplus";
/*     */   public static final String kQ = "flyway.jarDirs";
/*     */   public static final String kR = "flyway.configurations";
/*     */   
/*     */   public static void a(Object paramObject, b paramb) {
/* 135 */     if (paramObject instanceof c) {
/* 136 */       ((c)paramObject).a(new e(paramb)
/*     */           {
/*     */             public String el() {
/* 139 */               return this.b.m()[0];
/*     */             }
/*     */ 
/*     */             
/*     */             public ClassLoader getClassLoader() {
/* 144 */               return this.b.getClassLoader();
/*     */             }
/*     */ 
/*     */             
/*     */             public DataSource a() {
/* 149 */               return this.b.a();
/*     */             }
/*     */ 
/*     */             
/*     */             public int bK() {
/* 154 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public String en() {
/* 159 */               return this.b.en();
/*     */             }
/*     */ 
/*     */             
/*     */             public g b() {
/* 164 */               return this.b.b();
/*     */             }
/*     */ 
/*     */             
/*     */             public String em() {
/* 169 */               return this.b.em();
/*     */             }
/*     */ 
/*     */             
/*     */             public c[] a() {
/* 174 */               return this.b.a();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fi() {
/* 179 */               return this.b.fi();
/*     */             }
/*     */ 
/*     */             
/*     */             public b[] a() {
/* 184 */               return this.b.a();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fn() {
/* 189 */               return this.b.fn();
/*     */             }
/*     */ 
/*     */             
/*     */             public String ei() {
/* 194 */               return this.b.ei();
/*     */             }
/*     */ 
/*     */             
/*     */             public String eq() {
/* 199 */               return this.b.eq();
/*     */             }
/*     */ 
/*     */             
/*     */             public String ej() {
/* 204 */               return this.b.ej();
/*     */             }
/*     */ 
/*     */             
/*     */             public String ek() {
/* 209 */               return this.b.ek();
/*     */             }
/*     */ 
/*     */             
/*     */             public String[] m() {
/* 214 */               return this.b.m();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean eY() {
/* 219 */               return this.b.eY();
/*     */             }
/*     */ 
/*     */             
/*     */             public String eh() {
/* 224 */               return this.b.eh();
/*     */             }
/*     */ 
/*     */             
/*     */             public String eg() {
/* 229 */               return this.b.eg();
/*     */             }
/*     */ 
/*     */             
/*     */             public Map<String, String> P() {
/* 234 */               return this.b.P();
/*     */             }
/*     */ 
/*     */             
/*     */             public g a() {
/* 239 */               return this.b.a();
/*     */             }
/*     */ 
/*     */             
/*     */             public String ef() {
/* 244 */               return this.b.ef();
/*     */             }
/*     */ 
/*     */             
/*     */             public String[] l() {
/* 249 */               return this.b.l();
/*     */             }
/*     */ 
/*     */             
/*     */             public Charset a() {
/* 254 */               return this.b.a();
/*     */             }
/*     */ 
/*     */             
/*     */             public b[] a() {
/* 259 */               return this.b.a();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fg() {
/* 264 */               return this.b.fg();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fh() {
/* 269 */               return this.b.fh();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean eZ() {
/* 274 */               return this.b.eZ();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fa() {
/* 279 */               return this.b.fa();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fb() {
/* 284 */               return this.b.fb();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fc() {
/* 289 */               return this.b.fc();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fd() {
/* 294 */               return this.b.fd();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fe() {
/* 299 */               return this.b.fe();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean ff() {
/* 304 */               return this.b.ff();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fj() {
/* 309 */               return this.b.fj();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fk() {
/* 314 */               return this.b.fk();
/*     */             }
/*     */ 
/*     */             
/*     */             public String eo() {
/* 319 */               return this.b.eo();
/*     */             }
/*     */ 
/*     */             
/*     */             public c[] a() {
/* 324 */               return this.b.a();
/*     */             }
/*     */ 
/*     */             
/*     */             public String[] n() {
/* 329 */               return this.b.n();
/*     */             }
/*     */ 
/*     */             
/*     */             public OutputStream d() {
/* 334 */               return this.b.d();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean isStream() {
/* 339 */               return this.b.isStream();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fl() {
/* 344 */               return this.b.fl();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean fm() {
/* 349 */               return this.b.fm();
/*     */             }
/*     */ 
/*     */             
/*     */             public String ep() {
/* 354 */               return this.b.ep();
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, String> Q() {
/* 366 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 368 */     for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
/* 369 */       String str = aL((String)entry.getKey());
/* 370 */       if (str != null)
/*     */       {
/* 372 */         hashMap.put(aL((String)entry.getKey()), entry.getValue());
/*     */       }
/*     */     } 
/*     */     
/* 376 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private static String aL(String paramString) {
/* 380 */     if ("FLYWAY_BASELINE_DESCRIPTION".equals(paramString)) {
/* 381 */       return "flyway.baselineDescription";
/*     */     }
/* 383 */     if ("FLYWAY_BASELINE_ON_MIGRATE".equals(paramString)) {
/* 384 */       return "flyway.baselineOnMigrate";
/*     */     }
/* 386 */     if ("FLYWAY_BASELINE_VERSION".equals(paramString)) {
/* 387 */       return "flyway.baselineVersion";
/*     */     }
/* 389 */     if ("FLYWAY_BATCH".equals(paramString)) {
/* 390 */       return "flyway.batch";
/*     */     }
/* 392 */     if ("FLYWAY_CALLBACKS".equals(paramString)) {
/* 393 */       return "flyway.callbacks";
/*     */     }
/* 395 */     if ("FLYWAY_CLEAN_DISABLED".equals(paramString)) {
/* 396 */       return "flyway.cleanDisabled";
/*     */     }
/* 398 */     if ("FLYWAY_CLEAN_ON_VALIDATION_ERROR".equals(paramString)) {
/* 399 */       return "flyway.cleanOnValidationError";
/*     */     }
/* 401 */     if ("FLYWAY_CONFIG_FILE_ENCODING".equals(paramString)) {
/* 402 */       return "flyway.configFileEncoding";
/*     */     }
/* 404 */     if ("FLYWAY_CONFIG_FILES".equals(paramString)) {
/* 405 */       return "flyway.configFiles";
/*     */     }
/* 407 */     if ("FLYWAY_CONNECT_RETRIES".equals(paramString)) {
/* 408 */       return "flyway.connectRetries";
/*     */     }
/* 410 */     if ("FLYWAY_DRIVER".equals(paramString)) {
/* 411 */       return "flyway.driver";
/*     */     }
/* 413 */     if ("FLYWAY_DRYRUN_OUTPUT".equals(paramString)) {
/* 414 */       return "flyway.dryRunOutput";
/*     */     }
/* 416 */     if ("FLYWAY_ENCODING".equals(paramString)) {
/* 417 */       return "flyway.encoding";
/*     */     }
/* 419 */     if ("FLYWAY_ERROR_HANDLERS".equals(paramString)) {
/* 420 */       return "flyway.errorHandlers";
/*     */     }
/* 422 */     if ("FLYWAY_ERROR_OVERRIDES".equals(paramString)) {
/* 423 */       return "flyway.errorOverrides";
/*     */     }
/* 425 */     if ("FLYWAY_GROUP".equals(paramString)) {
/* 426 */       return "flyway.group";
/*     */     }
/* 428 */     if ("FLYWAY_IGNORE_FUTURE_MIGRATIONS".equals(paramString)) {
/* 429 */       return "flyway.ignoreFutureMigrations";
/*     */     }
/* 431 */     if ("FLYWAY_IGNORE_MISSING_MIGRATIONS".equals(paramString)) {
/* 432 */       return "flyway.ignoreMissingMigrations";
/*     */     }
/* 434 */     if ("FLYWAY_IGNORE_IGNORED_MIGRATIONS".equals(paramString)) {
/* 435 */       return "flyway.ignoreIgnoredMigrations";
/*     */     }
/* 437 */     if ("FLYWAY_IGNORE_PENDING_MIGRATIONS".equals(paramString)) {
/* 438 */       return "flyway.ignorePendingMigrations";
/*     */     }
/* 440 */     if ("FLYWAY_INIT_SQL".equals(paramString)) {
/* 441 */       return "flyway.initSql";
/*     */     }
/* 443 */     if ("FLYWAY_INSTALLED_BY".equals(paramString)) {
/* 444 */       return "flyway.installedBy";
/*     */     }
/* 446 */     if ("FLYWAY_LICENSE_KEY".equals(paramString)) {
/* 447 */       return "flyway.licenseKey";
/*     */     }
/* 449 */     if ("FLYWAY_LOCATIONS".equals(paramString)) {
/* 450 */       return "flyway.locations";
/*     */     }
/* 452 */     if ("FLYWAY_MIXED".equals(paramString)) {
/* 453 */       return "flyway.mixed";
/*     */     }
/* 455 */     if ("FLYWAY_OUT_OF_ORDER".equals(paramString)) {
/* 456 */       return "flyway.outOfOrder";
/*     */     }
/* 458 */     if ("FLYWAY_PASSWORD".equals(paramString)) {
/* 459 */       return "flyway.password";
/*     */     }
/* 461 */     if ("FLYWAY_PLACEHOLDER_PREFIX".equals(paramString)) {
/* 462 */       return "flyway.placeholderPrefix";
/*     */     }
/* 464 */     if ("FLYWAY_PLACEHOLDER_REPLACEMENT".equals(paramString)) {
/* 465 */       return "flyway.placeholderReplacement";
/*     */     }
/* 467 */     if ("FLYWAY_PLACEHOLDER_SUFFIX".equals(paramString)) {
/* 468 */       return "flyway.placeholderSuffix";
/*     */     }
/* 470 */     if (paramString.matches("FLYWAY_PLACEHOLDERS_.+")) {
/* 471 */       return "flyway.placeholders." + paramString.substring("FLYWAY_PLACEHOLDERS_".length()).toLowerCase(Locale.ENGLISH);
/*     */     }
/* 473 */     if ("FLYWAY_REPEATABLE_SQL_MIGRATION_PREFIX".equals(paramString)) {
/* 474 */       return "flyway.repeatableSqlMigrationPrefix";
/*     */     }
/* 476 */     if ("FLYWAY_RESOLVERS".equals(paramString)) {
/* 477 */       return "flyway.resolvers";
/*     */     }
/* 479 */     if ("FLYWAY_SCHEMAS".equals(paramString)) {
/* 480 */       return "flyway.schemas";
/*     */     }
/* 482 */     if ("FLYWAY_SKIP_DEFAULT_CALLBACKS".equals(paramString)) {
/* 483 */       return "flyway.skipDefaultCallbacks";
/*     */     }
/* 485 */     if ("FLYWAY_SKIP_DEFAULT_RESOLVERS".equals(paramString)) {
/* 486 */       return "flyway.skipDefaultResolvers";
/*     */     }
/* 488 */     if ("FLYWAY_SQL_MIGRATION_PREFIX".equals(paramString)) {
/* 489 */       return "flyway.sqlMigrationPrefix";
/*     */     }
/* 491 */     if ("FLYWAY_SQL_MIGRATION_SEPARATOR".equals(paramString)) {
/* 492 */       return "flyway.sqlMigrationSeparator";
/*     */     }
/* 494 */     if ("FLYWAY_SQL_MIGRATION_SUFFIXES".equals(paramString)) {
/* 495 */       return "flyway.sqlMigrationSuffixes";
/*     */     }
/* 497 */     if ("FLYWAY_STREAM".equals(paramString)) {
/* 498 */       return "flyway.stream";
/*     */     }
/* 500 */     if ("FLYWAY_TABLE".equals(paramString)) {
/* 501 */       return "flyway.table";
/*     */     }
/* 503 */     if ("FLYWAY_TARGET".equals(paramString)) {
/* 504 */       return "flyway.target";
/*     */     }
/* 506 */     if ("FLYWAY_UNDO_SQL_MIGRATION_PREFIX".equals(paramString)) {
/* 507 */       return "flyway.undoSqlMigrationPrefix";
/*     */     }
/* 509 */     if ("FLYWAY_URL".equals(paramString)) {
/* 510 */       return "flyway.url";
/*     */     }
/* 512 */     if ("FLYWAY_USER".equals(paramString)) {
/* 513 */       return "flyway.user";
/*     */     }
/* 515 */     if ("FLYWAY_VALIDATE_ON_MIGRATE".equals(paramString)) {
/* 516 */       return "flyway.validateOnMigrate";
/*     */     }
/*     */ 
/*     */     
/* 520 */     if ("FLYWAY_ORACLE_SQLPLUS".equals(paramString)) {
/* 521 */       return "flyway.oracle.sqlplus";
/*     */     }
/*     */ 
/*     */     
/* 525 */     if ("FLYWAY_JAR_DIRS".equals(paramString)) {
/* 526 */       return "flyway.jarDirs";
/*     */     }
/*     */ 
/*     */     
/* 530 */     if ("FLYWAY_CONFIGURATIONS".equals(paramString)) {
/* 531 */       return "flyway.configurations";
/*     */     }
/*     */     
/* 534 */     return null;
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
/*     */   
/*     */   public static Map<String, String> a(File paramFile, String paramString, boolean paramBoolean) throws org.c.a.a.a {
/* 547 */     String str = "Unable to load config file: " + paramFile.getAbsolutePath();
/*     */     
/* 549 */     if (!paramFile.isFile() || !paramFile.canRead()) {
/* 550 */       if (!paramBoolean) {
/* 551 */         a.debug(str);
/* 552 */         return new HashMap<>();
/*     */       } 
/* 554 */       throw new org.c.a.a.a(str);
/*     */     } 
/*     */     
/* 557 */     a.debug("Loading config file: " + paramFile.getAbsolutePath());
/*     */     try {
/* 559 */       String str1 = h.a(new InputStreamReader(new FileInputStream(paramFile), paramString));
/* 560 */       Properties properties = new Properties();
/* 561 */       properties.load(new StringReader(str1.replace("\\", "\\\\")));
/* 562 */       return a(properties);
/* 563 */     } catch (IOException iOException) {
/* 564 */       throw new org.c.a.a.a(str, iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, String> a(Properties paramProperties) {
/* 575 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 576 */     for (Map.Entry<Object, Object> entry : paramProperties.entrySet()) {
/* 577 */       hashMap.put(entry.getKey().toString(), entry.getValue().toString());
/*     */     }
/* 579 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(Map<String, String> paramMap, String paramString, Object... paramVarArgs) {
/* 590 */     for (Object object : paramVarArgs) {
/* 591 */       if (object != null) {
/* 592 */         paramMap.put(paramString, object.toString());
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(Map<String, String> paramMap, String paramString, String[]... paramVarArgs) {
/* 606 */     for (String[] arrayOfString : paramVarArgs) {
/* 607 */       if (arrayOfString != null) {
/* 608 */         paramMap.put(paramString, n.a((Object[])arrayOfString));
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\d\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */