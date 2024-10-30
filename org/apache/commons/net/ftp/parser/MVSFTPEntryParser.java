/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.util.List;
/*     */ import org.apache.commons.net.ftp.FTPClientConfig;
/*     */ import org.apache.commons.net.ftp.FTPFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MVSFTPEntryParser
/*     */   extends ConfigurableFTPFileEntryParserImpl
/*     */ {
/*     */   static final int UNKNOWN_LIST_TYPE = -1;
/*     */   static final int FILE_LIST_TYPE = 0;
/*     */   static final int MEMBER_LIST_TYPE = 1;
/*     */   static final int UNIX_LIST_TYPE = 2;
/*     */   static final int JES_LEVEL_1_LIST_TYPE = 3;
/*     */   static final int JES_LEVEL_2_LIST_TYPE = 4;
/*  42 */   private int isType = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UnixFTPEntryParser unixFTPEntryParser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd HH:mm";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final String FILE_LIST_REGEX = "\\S+\\s+\\S+\\s+\\S+\\s+\\S+\\s+(?:\\S+\\s+)?(?:F|FB|V|VB|U)\\s+\\S+\\s+\\S+\\s+(PS|PO|PO-E)\\s+(\\S+)\\s*";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final String MEMBER_LIST_REGEX = "(\\S+)\\s+\\S+\\s+\\S+\\s+(\\S+)\\s+(\\S+)\\s+\\S+\\s+\\S+\\s+\\S+\\s+\\S+\\s*";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final String JES_LEVEL_1_LIST_REGEX = "(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s*";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final String JES_LEVEL_2_LIST_REGEX = "(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+).*";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MVSFTPEntryParser() {
/* 251 */     super("");
/* 252 */     configure((FTPClientConfig)null);
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
/*     */   public FTPFile parseFTPEntry(String paramString) {
/* 268 */     if (this.isType == 0)
/* 269 */       return parseFileList(paramString); 
/* 270 */     if (this.isType == 1)
/* 271 */       return parseMemberList(paramString); 
/* 272 */     if (this.isType == 2)
/* 273 */       return this.unixFTPEntryParser.parseFTPEntry(paramString); 
/* 274 */     if (this.isType == 3)
/* 275 */       return parseJeslevel1List(paramString); 
/* 276 */     if (this.isType == 4) {
/* 277 */       return parseJeslevel2List(paramString);
/*     */     }
/*     */     
/* 280 */     return null;
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
/*     */   private FTPFile parseFileList(String paramString) {
/* 307 */     if (matches(paramString)) {
/* 308 */       FTPFile fTPFile = new FTPFile();
/* 309 */       fTPFile.setRawListing(paramString);
/* 310 */       String str1 = group(2);
/* 311 */       String str2 = group(1);
/* 312 */       fTPFile.setName(str1);
/*     */ 
/*     */       
/* 315 */       if ("PS".equals(str2)) {
/* 316 */         fTPFile.setType(0);
/*     */       }
/* 318 */       else if ("PO".equals(str2) || "PO-E".equals(str2)) {
/*     */         
/* 320 */         fTPFile.setType(1);
/*     */       } else {
/*     */         
/* 323 */         return null;
/*     */       } 
/*     */       
/* 326 */       return fTPFile;
/*     */     } 
/*     */     
/* 329 */     return null;
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
/*     */   private FTPFile parseMemberList(String paramString) {
/* 357 */     FTPFile fTPFile = new FTPFile();
/* 358 */     if (matches(paramString)) {
/* 359 */       fTPFile.setRawListing(paramString);
/* 360 */       String str1 = group(1);
/* 361 */       String str2 = group(2) + " " + group(3);
/* 362 */       fTPFile.setName(str1);
/* 363 */       fTPFile.setType(0);
/*     */       try {
/* 365 */         fTPFile.setTimestamp(parseTimestamp(str2));
/* 366 */       } catch (ParseException parseException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 371 */       return fTPFile;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 379 */     if (paramString != null && !paramString.trim().isEmpty()) {
/* 380 */       fTPFile.setRawListing(paramString);
/* 381 */       String str = paramString.split(" ")[0];
/* 382 */       fTPFile.setName(str);
/* 383 */       fTPFile.setType(0);
/* 384 */       return fTPFile;
/*     */     } 
/* 386 */     return null;
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
/*     */   private FTPFile parseJeslevel1List(String paramString) {
/* 409 */     if (matches(paramString)) {
/* 410 */       FTPFile fTPFile = new FTPFile();
/* 411 */       if (group(3).equalsIgnoreCase("OUTPUT")) {
/* 412 */         fTPFile.setRawListing(paramString);
/* 413 */         String str = group(2);
/* 414 */         fTPFile.setName(str);
/* 415 */         fTPFile.setType(0);
/* 416 */         return fTPFile;
/*     */       } 
/*     */     } 
/*     */     
/* 420 */     return null;
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
/*     */   private FTPFile parseJeslevel2List(String paramString) {
/* 446 */     if (matches(paramString)) {
/* 447 */       FTPFile fTPFile = new FTPFile();
/* 448 */       if (group(4).equalsIgnoreCase("OUTPUT")) {
/* 449 */         fTPFile.setRawListing(paramString);
/* 450 */         String str = group(2);
/* 451 */         fTPFile.setName(str);
/* 452 */         fTPFile.setType(0);
/* 453 */         return fTPFile;
/*     */       } 
/*     */     } 
/*     */     
/* 457 */     return null;
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
/*     */   public List<String> preParse(List<String> paramList) {
/* 474 */     if (paramList != null && !paramList.isEmpty()) {
/* 475 */       String str = paramList.get(0);
/* 476 */       if (str.indexOf("Volume") >= 0 && str.indexOf("Dsname") >= 0) {
/* 477 */         setType(0);
/* 478 */         setRegex("\\S+\\s+\\S+\\s+\\S+\\s+\\S+\\s+(?:\\S+\\s+)?(?:F|FB|V|VB|U)\\s+\\S+\\s+\\S+\\s+(PS|PO|PO-E)\\s+(\\S+)\\s*");
/* 479 */       } else if (str.indexOf("Name") >= 0 && str.indexOf("Id") >= 0) {
/* 480 */         setType(1);
/* 481 */         setRegex("(\\S+)\\s+\\S+\\s+\\S+\\s+(\\S+)\\s+(\\S+)\\s+\\S+\\s+\\S+\\s+\\S+\\s+\\S+\\s*");
/* 482 */       } else if (str.indexOf("total") == 0) {
/* 483 */         setType(2);
/* 484 */         this.unixFTPEntryParser = new UnixFTPEntryParser();
/* 485 */       } else if (str.indexOf("Spool Files") >= 30) {
/* 486 */         setType(3);
/* 487 */         setRegex("(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s*");
/* 488 */       } else if (str.indexOf("JOBNAME") == 0 && str
/* 489 */         .indexOf("JOBID") > 8) {
/* 490 */         setType(4);
/* 491 */         setRegex("(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+).*");
/*     */       } else {
/* 493 */         setType(-1);
/*     */       } 
/*     */       
/* 496 */       if (this.isType != 3) {
/* 497 */         paramList.remove(0);
/*     */       }
/*     */     } 
/*     */     
/* 501 */     return paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setType(int paramInt) {
/* 509 */     this.isType = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FTPClientConfig getDefaultConfiguration() {
/* 517 */     return new FTPClientConfig("MVS", "yyyy/MM/dd HH:mm", null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\MVSFTPEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */