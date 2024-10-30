/*     */ package org.apache.commons.net.ftp;
/*     */ 
/*     */ import java.text.DateFormatSymbols;
/*     */ import java.util.Collection;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FTPClientConfig
/*     */ {
/*     */   public static final String SYST_UNIX = "UNIX";
/*     */   public static final String SYST_UNIX_TRIM_LEADING = "UNIX_LTRIM";
/*     */   public static final String SYST_VMS = "VMS";
/*     */   public static final String SYST_NT = "WINDOWS";
/*     */   public static final String SYST_OS2 = "OS/2";
/*     */   public static final String SYST_OS400 = "OS/400";
/*     */   public static final String SYST_AS400 = "AS/400";
/*     */   public static final String SYST_MVS = "MVS";
/*     */   public static final String SYST_L8 = "TYPE: L8";
/*     */   public static final String SYST_NETWARE = "NETWARE";
/*     */   public static final String SYST_MACOS_PETER = "MACOS PETER";
/*     */   private final String serverSystemKey;
/*     */   private String defaultDateFormatStr;
/*     */   private String recentDateFormatStr;
/*     */   private boolean lenientFutureDates = true;
/*     */   private String serverLanguageCode;
/*     */   private String shortMonthNames;
/*     */   private String serverTimeZoneId;
/*     */   private boolean saveUnparseableEntries;
/*     */   
/*     */   public FTPClientConfig(String paramString) {
/* 241 */     this.serverSystemKey = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPClientConfig() {
/* 249 */     this("UNIX");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPClientConfig(String paramString1, String paramString2, String paramString3) {
/* 267 */     this(paramString1);
/* 268 */     this.defaultDateFormatStr = paramString2;
/* 269 */     this.recentDateFormatStr = paramString3;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPClientConfig(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
/* 295 */     this(paramString1);
/* 296 */     this.defaultDateFormatStr = paramString2;
/* 297 */     this.recentDateFormatStr = paramString3;
/* 298 */     this.serverLanguageCode = paramString4;
/* 299 */     this.shortMonthNames = paramString5;
/* 300 */     this.serverTimeZoneId = paramString6;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPClientConfig(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2) {
/* 332 */     this(paramString1);
/* 333 */     this.defaultDateFormatStr = paramString2;
/* 334 */     this.lenientFutureDates = paramBoolean1;
/* 335 */     this.recentDateFormatStr = paramString3;
/* 336 */     this.saveUnparseableEntries = paramBoolean2;
/* 337 */     this.serverLanguageCode = paramString4;
/* 338 */     this.shortMonthNames = paramString5;
/* 339 */     this.serverTimeZoneId = paramString6;
/*     */   }
/*     */ 
/*     */   
/*     */   FTPClientConfig(String paramString, FTPClientConfig paramFTPClientConfig) {
/* 344 */     this.serverSystemKey = paramString;
/* 345 */     this.defaultDateFormatStr = paramFTPClientConfig.defaultDateFormatStr;
/* 346 */     this.lenientFutureDates = paramFTPClientConfig.lenientFutureDates;
/* 347 */     this.recentDateFormatStr = paramFTPClientConfig.recentDateFormatStr;
/* 348 */     this.saveUnparseableEntries = paramFTPClientConfig.saveUnparseableEntries;
/* 349 */     this.serverLanguageCode = paramFTPClientConfig.serverLanguageCode;
/* 350 */     this.serverTimeZoneId = paramFTPClientConfig.serverTimeZoneId;
/* 351 */     this.shortMonthNames = paramFTPClientConfig.shortMonthNames;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPClientConfig(FTPClientConfig paramFTPClientConfig) {
/* 360 */     this.serverSystemKey = paramFTPClientConfig.serverSystemKey;
/* 361 */     this.defaultDateFormatStr = paramFTPClientConfig.defaultDateFormatStr;
/* 362 */     this.lenientFutureDates = paramFTPClientConfig.lenientFutureDates;
/* 363 */     this.recentDateFormatStr = paramFTPClientConfig.recentDateFormatStr;
/* 364 */     this.saveUnparseableEntries = paramFTPClientConfig.saveUnparseableEntries;
/* 365 */     this.serverLanguageCode = paramFTPClientConfig.serverLanguageCode;
/* 366 */     this.serverTimeZoneId = paramFTPClientConfig.serverTimeZoneId;
/* 367 */     this.shortMonthNames = paramFTPClientConfig.shortMonthNames;
/*     */   }
/*     */   
/* 370 */   private static final Map<String, Object> LANGUAGE_CODE_MAP = new TreeMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 380 */     LANGUAGE_CODE_MAP.put("en", Locale.ENGLISH);
/* 381 */     LANGUAGE_CODE_MAP.put("de", Locale.GERMAN);
/* 382 */     LANGUAGE_CODE_MAP.put("it", Locale.ITALIAN);
/* 383 */     LANGUAGE_CODE_MAP.put("es", new Locale("es", "", ""));
/* 384 */     LANGUAGE_CODE_MAP.put("pt", new Locale("pt", "", ""));
/* 385 */     LANGUAGE_CODE_MAP.put("da", new Locale("da", "", ""));
/* 386 */     LANGUAGE_CODE_MAP.put("sv", new Locale("sv", "", ""));
/* 387 */     LANGUAGE_CODE_MAP.put("no", new Locale("no", "", ""));
/* 388 */     LANGUAGE_CODE_MAP.put("nl", new Locale("nl", "", ""));
/* 389 */     LANGUAGE_CODE_MAP.put("ro", new Locale("ro", "", ""));
/* 390 */     LANGUAGE_CODE_MAP.put("sq", new Locale("sq", "", ""));
/* 391 */     LANGUAGE_CODE_MAP.put("sh", new Locale("sh", "", ""));
/* 392 */     LANGUAGE_CODE_MAP.put("sk", new Locale("sk", "", ""));
/* 393 */     LANGUAGE_CODE_MAP.put("sl", new Locale("sl", "", ""));
/*     */ 
/*     */ 
/*     */     
/* 397 */     LANGUAGE_CODE_MAP.put("fr", "jan|fév|mar|avr|mai|jun|jui|aoû|sep|oct|nov|déc");
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
/*     */ 
/*     */   
/*     */   public String getServerSystemKey() {
/* 412 */     return this.serverSystemKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultDateFormatStr() {
/* 421 */     return this.defaultDateFormatStr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecentDateFormatStr() {
/* 430 */     return this.recentDateFormatStr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServerTimeZoneId() {
/* 438 */     return this.serverTimeZoneId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShortMonthNames() {
/* 449 */     return this.shortMonthNames;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServerLanguageCode() {
/* 459 */     return this.serverLanguageCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLenientFutureDates() {
/* 470 */     return this.lenientFutureDates;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultDateFormatStr(String paramString) {
/* 487 */     this.defaultDateFormatStr = paramString;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecentDateFormatStr(String paramString) {
/* 508 */     this.recentDateFormatStr = paramString;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLenientFutureDates(boolean paramBoolean) {
/* 532 */     this.lenientFutureDates = paramBoolean;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServerTimeZoneId(String paramString) {
/* 549 */     this.serverTimeZoneId = paramString;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShortMonthNames(String paramString) {
/* 570 */     this.shortMonthNames = paramString;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServerLanguageCode(String paramString) {
/* 614 */     this.serverLanguageCode = paramString;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DateFormatSymbols lookupDateFormatSymbols(String paramString) {
/* 631 */     Object object = LANGUAGE_CODE_MAP.get(paramString);
/* 632 */     if (object != null) {
/* 633 */       if (object instanceof Locale)
/* 634 */         return new DateFormatSymbols((Locale)object); 
/* 635 */       if (object instanceof String) {
/* 636 */         return getDateFormatSymbols((String)object);
/*     */       }
/*     */     } 
/* 639 */     return new DateFormatSymbols(Locale.US);
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
/*     */   public static DateFormatSymbols getDateFormatSymbols(String paramString) {
/* 652 */     String[] arrayOfString = splitShortMonthString(paramString);
/* 653 */     DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(Locale.US);
/* 654 */     dateFormatSymbols.setShortMonths(arrayOfString);
/* 655 */     return dateFormatSymbols;
/*     */   }
/*     */   
/*     */   private static String[] splitShortMonthString(String paramString) {
/* 659 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, "|");
/* 660 */     int i = stringTokenizer.countTokens();
/* 661 */     if (12 != i) {
/* 662 */       throw new IllegalArgumentException("expecting a pipe-delimited string containing 12 tokens");
/*     */     }
/*     */     
/* 665 */     String[] arrayOfString = new String[13];
/* 666 */     byte b = 0;
/* 667 */     while (stringTokenizer.hasMoreTokens()) {
/* 668 */       arrayOfString[b++] = stringTokenizer.nextToken();
/*     */     }
/* 670 */     arrayOfString[b] = "";
/* 671 */     return arrayOfString;
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
/*     */   public static Collection<String> getSupportedLanguageCodes() {
/* 683 */     return LANGUAGE_CODE_MAP.keySet();
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
/*     */   public void setUnparseableEntries(boolean paramBoolean) {
/* 695 */     this.saveUnparseableEntries = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getUnparseableEntries() {
/* 706 */     return this.saveUnparseableEntries;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTPClientConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */