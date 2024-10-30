/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.text.ParseException;
/*     */ import java.util.Locale;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OS400FTPEntryParser
/*     */   extends ConfigurableFTPFileEntryParserImpl
/*     */ {
/*     */   private static final String DEFAULT_DATE_FORMAT = "yy/MM/dd HH:mm:ss";
/*     */   private static final String REGEX = "(\\S+)\\s+(?:(\\d+)\\s+)?(?:(\\S+)\\s+(\\S+)\\s+)?(\\*STMF|\\*DIR|\\*FILE|\\*MEM)\\s+(?:(\\S+)\\s*)?";
/*     */   
/*     */   public OS400FTPEntryParser() {
/* 259 */     this((FTPClientConfig)null);
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
/*     */   public OS400FTPEntryParser(FTPClientConfig paramFTPClientConfig) {
/* 276 */     super("(\\S+)\\s+(?:(\\d+)\\s+)?(?:(\\S+)\\s+(\\S+)\\s+)?(\\*STMF|\\*DIR|\\*FILE|\\*MEM)\\s+(?:(\\S+)\\s*)?");
/* 277 */     configure(paramFTPClientConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPFile parseFTPEntry(String paramString) {
/* 285 */     FTPFile fTPFile = new FTPFile();
/* 286 */     fTPFile.setRawListing(paramString);
/*     */ 
/*     */     
/* 289 */     if (matches(paramString)) {
/*     */       byte b;
/* 291 */       String str1 = group(1);
/* 292 */       String str2 = group(2);
/* 293 */       String str3 = "";
/* 294 */       if (!isNullOrEmpty(group(3)) || !isNullOrEmpty(group(4)))
/*     */       {
/* 296 */         str3 = group(3) + " " + group(4);
/*     */       }
/* 298 */       String str4 = group(5);
/* 299 */       String str5 = group(6);
/*     */       
/* 301 */       boolean bool = true;
/*     */ 
/*     */       
/*     */       try {
/* 305 */         fTPFile.setTimestamp(parseTimestamp(str3));
/*     */       }
/* 307 */       catch (ParseException parseException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 313 */       if (str4.equalsIgnoreCase("*STMF")) {
/*     */         
/* 315 */         b = 0;
/* 316 */         if (isNullOrEmpty(str2) || isNullOrEmpty(str5))
/*     */         {
/* 318 */           return null;
/*     */         }
/*     */       }
/* 321 */       else if (str4.equalsIgnoreCase("*DIR")) {
/*     */         
/* 323 */         b = 1;
/* 324 */         if (isNullOrEmpty(str2) || isNullOrEmpty(str5))
/*     */         {
/* 326 */           return null;
/*     */         }
/*     */       }
/* 329 */       else if (str4.equalsIgnoreCase("*FILE")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 338 */         if (str5 != null && str5.toUpperCase(Locale.ROOT).endsWith(".SAVF"))
/*     */         {
/* 340 */           bool = false;
/* 341 */           b = 0;
/*     */         }
/*     */         else
/*     */         {
/* 345 */           return null;
/*     */         }
/*     */       
/* 348 */       } else if (str4.equalsIgnoreCase("*MEM")) {
/*     */         
/* 350 */         bool = false;
/* 351 */         b = 0;
/*     */         
/* 353 */         if (isNullOrEmpty(str5))
/*     */         {
/* 355 */           return null;
/*     */         }
/* 357 */         if (!isNullOrEmpty(str2) || !isNullOrEmpty(str3))
/*     */         {
/* 359 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 367 */         str5 = str5.replace('/', File.separatorChar);
/*     */       }
/*     */       else {
/*     */         
/* 371 */         b = 3;
/*     */       } 
/*     */       
/* 374 */       fTPFile.setType(b);
/*     */       
/* 376 */       fTPFile.setUser(str1);
/*     */ 
/*     */       
/*     */       try {
/* 380 */         fTPFile.setSize(Long.parseLong(str2));
/*     */       }
/* 382 */       catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 387 */       if (str5.endsWith("/"))
/*     */       {
/* 389 */         str5 = str5.substring(0, str5.length() - 1);
/*     */       }
/* 391 */       if (bool) {
/*     */         
/* 393 */         int i = str5.lastIndexOf('/');
/* 394 */         if (i > -1)
/*     */         {
/* 396 */           str5 = str5.substring(i + 1);
/*     */         }
/*     */       } 
/*     */       
/* 400 */       fTPFile.setName(str5);
/*     */       
/* 402 */       return fTPFile;
/*     */     } 
/* 404 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isNullOrEmpty(String paramString) {
/* 415 */     if (paramString == null || paramString.isEmpty()) {
/* 416 */       return true;
/*     */     }
/* 418 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FTPClientConfig getDefaultConfiguration() {
/* 429 */     return new FTPClientConfig("OS/400", "yy/MM/dd HH:mm:ss", null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\OS400FTPEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */