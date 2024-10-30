/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.text.ParseException;
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
/*     */ public class OS2FTPEntryParser
/*     */   extends ConfigurableFTPFileEntryParserImpl
/*     */ {
/*     */   private static final String DEFAULT_DATE_FORMAT = "MM-dd-yy HH:mm";
/*     */   private static final String REGEX = "\\s*([0-9]+)\\s*(\\s+|[A-Z]+)\\s*(DIR|\\s+)\\s*(\\S+)\\s+(\\S+)\\s+(\\S.*)";
/*     */   
/*     */   public OS2FTPEntryParser() {
/*  55 */     this((FTPClientConfig)null);
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
/*     */   public OS2FTPEntryParser(FTPClientConfig paramFTPClientConfig) {
/*  72 */     super("\\s*([0-9]+)\\s*(\\s+|[A-Z]+)\\s*(DIR|\\s+)\\s*(\\S+)\\s+(\\S+)\\s+(\\S.*)");
/*  73 */     configure(paramFTPClientConfig);
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
/*     */   public FTPFile parseFTPEntry(String paramString) {
/*  90 */     FTPFile fTPFile = new FTPFile();
/*  91 */     if (matches(paramString)) {
/*     */       
/*  93 */       String str1 = group(1);
/*  94 */       String str2 = group(2);
/*  95 */       String str3 = group(3);
/*  96 */       String str4 = group(4) + " " + group(5);
/*  97 */       String str5 = group(6);
/*     */       
/*     */       try {
/* 100 */         fTPFile.setTimestamp(parseTimestamp(str4));
/*     */       }
/* 102 */       catch (ParseException parseException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 109 */       if (str3.trim().equals("DIR") || str2.trim().equals("DIR")) {
/*     */         
/* 111 */         fTPFile.setType(1);
/*     */       }
/*     */       else {
/*     */         
/* 115 */         fTPFile.setType(0);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 120 */       fTPFile.setName(str5.trim());
/*     */ 
/*     */       
/* 123 */       fTPFile.setSize(Long.parseLong(str1.trim()));
/*     */       
/* 125 */       return fTPFile;
/*     */     } 
/* 127 */     return null;
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
/*     */   protected FTPClientConfig getDefaultConfiguration() {
/* 139 */     return new FTPClientConfig("OS/2", "MM-dd-yy HH:mm", null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\OS2FTPEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */