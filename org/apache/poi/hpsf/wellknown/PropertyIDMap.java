/*     */ package org.apache.poi.hpsf.wellknown;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PropertyIDMap
/*     */   extends HashMap<Long, String>
/*     */ {
/*     */   public static final int PID_TITLE = 2;
/*     */   public static final int PID_SUBJECT = 3;
/*     */   public static final int PID_AUTHOR = 4;
/*     */   public static final int PID_KEYWORDS = 5;
/*     */   public static final int PID_COMMENTS = 6;
/*     */   public static final int PID_TEMPLATE = 7;
/*     */   public static final int PID_LASTAUTHOR = 8;
/*     */   public static final int PID_REVNUMBER = 9;
/*     */   public static final int PID_EDITTIME = 10;
/*     */   public static final int PID_LASTPRINTED = 11;
/*     */   public static final int PID_CREATE_DTM = 12;
/*     */   public static final int PID_LASTSAVE_DTM = 13;
/*     */   public static final int PID_PAGECOUNT = 14;
/*     */   public static final int PID_WORDCOUNT = 15;
/*     */   public static final int PID_CHARCOUNT = 16;
/*     */   public static final int PID_THUMBNAIL = 17;
/*     */   public static final int PID_APPNAME = 18;
/*     */   public static final int PID_SECURITY = 19;
/*     */   public static final int PID_DICTIONARY = 0;
/*     */   public static final int PID_CODEPAGE = 1;
/*     */   public static final int PID_CATEGORY = 2;
/*     */   public static final int PID_PRESFORMAT = 3;
/*     */   public static final int PID_BYTECOUNT = 4;
/*     */   public static final int PID_LINECOUNT = 5;
/*     */   public static final int PID_PARCOUNT = 6;
/*     */   public static final int PID_SLIDECOUNT = 7;
/*     */   public static final int PID_NOTECOUNT = 8;
/*     */   public static final int PID_HIDDENCOUNT = 9;
/*     */   public static final int PID_MMCLIPCOUNT = 10;
/*     */   public static final int PID_SCALE = 11;
/*     */   public static final int PID_HEADINGPAIR = 12;
/*     */   public static final int PID_DOCPARTS = 13;
/*     */   public static final int PID_MANAGER = 14;
/*     */   public static final int PID_COMPANY = 15;
/*     */   public static final int PID_LINKSDIRTY = 16;
/*     */   public static final int PID_CCHWITHSPACES = 17;
/*     */   public static final int PID_HYPERLINKSCHANGED = 22;
/*     */   public static final int PID_VERSION = 23;
/*     */   public static final int PID_DIGSIG = 24;
/*     */   public static final int PID_CONTENTTYPE = 26;
/*     */   public static final int PID_CONTENTSTATUS = 27;
/*     */   public static final int PID_LANGUAGE = 28;
/*     */   public static final int PID_DOCVERSION = 29;
/*     */   public static final int PID_MAX = 31;
/*     */   private static PropertyIDMap summaryInformationProperties;
/*     */   private static PropertyIDMap documentSummaryInformationProperties;
/*     */   
/*     */   public PropertyIDMap(int paramInt, float paramFloat) {
/* 318 */     super(paramInt, paramFloat);
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
/*     */   public PropertyIDMap(Map<Long, String> paramMap) {
/* 330 */     super(paramMap);
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
/*     */   public Object put(long paramLong, String paramString) {
/* 348 */     return put(Long.valueOf(paramLong), paramString);
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
/*     */   public Object get(long paramLong) {
/* 362 */     return get(Long.valueOf(paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PropertyIDMap getSummaryInformationProperties() {
/* 372 */     if (summaryInformationProperties == null) {
/*     */       
/* 374 */       PropertyIDMap propertyIDMap = new PropertyIDMap(18, 1.0F);
/* 375 */       propertyIDMap.put(2L, "PID_TITLE");
/* 376 */       propertyIDMap.put(3L, "PID_SUBJECT");
/* 377 */       propertyIDMap.put(4L, "PID_AUTHOR");
/* 378 */       propertyIDMap.put(5L, "PID_KEYWORDS");
/* 379 */       propertyIDMap.put(6L, "PID_COMMENTS");
/* 380 */       propertyIDMap.put(7L, "PID_TEMPLATE");
/* 381 */       propertyIDMap.put(8L, "PID_LASTAUTHOR");
/* 382 */       propertyIDMap.put(9L, "PID_REVNUMBER");
/* 383 */       propertyIDMap.put(10L, "PID_EDITTIME");
/* 384 */       propertyIDMap.put(11L, "PID_LASTPRINTED");
/* 385 */       propertyIDMap.put(12L, "PID_CREATE_DTM");
/* 386 */       propertyIDMap.put(13L, "PID_LASTSAVE_DTM");
/* 387 */       propertyIDMap.put(14L, "PID_PAGECOUNT");
/* 388 */       propertyIDMap.put(15L, "PID_WORDCOUNT");
/* 389 */       propertyIDMap.put(16L, "PID_CHARCOUNT");
/* 390 */       propertyIDMap.put(17L, "PID_THUMBNAIL");
/* 391 */       propertyIDMap.put(18L, "PID_APPNAME");
/* 392 */       propertyIDMap.put(19L, "PID_SECURITY");
/* 393 */       summaryInformationProperties = new PropertyIDMap(Collections.unmodifiableMap(propertyIDMap));
/*     */     } 
/*     */     
/* 396 */     return summaryInformationProperties;
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
/*     */   public static PropertyIDMap getDocumentSummaryInformationProperties() {
/* 409 */     if (documentSummaryInformationProperties == null) {
/*     */       
/* 411 */       PropertyIDMap propertyIDMap = new PropertyIDMap(17, 1.0F);
/* 412 */       propertyIDMap.put(0L, "PID_DICTIONARY");
/* 413 */       propertyIDMap.put(1L, "PID_CODEPAGE");
/* 414 */       propertyIDMap.put(2L, "PID_CATEGORY");
/* 415 */       propertyIDMap.put(3L, "PID_PRESFORMAT");
/* 416 */       propertyIDMap.put(4L, "PID_BYTECOUNT");
/* 417 */       propertyIDMap.put(5L, "PID_LINECOUNT");
/* 418 */       propertyIDMap.put(6L, "PID_PARCOUNT");
/* 419 */       propertyIDMap.put(7L, "PID_SLIDECOUNT");
/* 420 */       propertyIDMap.put(8L, "PID_NOTECOUNT");
/* 421 */       propertyIDMap.put(9L, "PID_HIDDENCOUNT");
/* 422 */       propertyIDMap.put(10L, "PID_MMCLIPCOUNT");
/* 423 */       propertyIDMap.put(11L, "PID_SCALE");
/* 424 */       propertyIDMap.put(12L, "PID_HEADINGPAIR");
/* 425 */       propertyIDMap.put(13L, "PID_DOCPARTS");
/* 426 */       propertyIDMap.put(14L, "PID_MANAGER");
/* 427 */       propertyIDMap.put(15L, "PID_COMPANY");
/* 428 */       propertyIDMap.put(16L, "PID_LINKSDIRTY");
/* 429 */       documentSummaryInformationProperties = new PropertyIDMap(Collections.unmodifiableMap(propertyIDMap));
/*     */     } 
/*     */     
/* 432 */     return documentSummaryInformationProperties;
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
/*     */   public static void main(String[] paramArrayOfString) {
/* 444 */     PropertyIDMap propertyIDMap1 = getSummaryInformationProperties();
/* 445 */     PropertyIDMap propertyIDMap2 = getDocumentSummaryInformationProperties();
/* 446 */     System.out.println("s1: " + propertyIDMap1);
/* 447 */     System.out.println("s2: " + propertyIDMap2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\wellknown\PropertyIDMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */