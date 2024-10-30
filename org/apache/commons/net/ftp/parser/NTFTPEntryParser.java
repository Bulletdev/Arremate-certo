/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import org.apache.commons.net.ftp.Configurable;
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
/*     */ public class NTFTPEntryParser
/*     */   extends ConfigurableFTPFileEntryParserImpl
/*     */ {
/*     */   private static final String DEFAULT_DATE_FORMAT = "MM-dd-yy hh:mma";
/*     */   private static final String DEFAULT_DATE_FORMAT2 = "MM-dd-yy kk:mm";
/*     */   private final FTPTimestampParser timestampParser;
/*     */   private static final String REGEX = "(\\S+)\\s+(\\S+)\\s+(?:(<DIR>)|([0-9]+))\\s+(\\S.*)";
/*     */   
/*     */   public NTFTPEntryParser() {
/*  60 */     this((FTPClientConfig)null);
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
/*     */   public NTFTPEntryParser(FTPClientConfig paramFTPClientConfig) {
/*  77 */     super("(\\S+)\\s+(\\S+)\\s+(?:(<DIR>)|([0-9]+))\\s+(\\S.*)", 32);
/*  78 */     configure(paramFTPClientConfig);
/*  79 */     FTPClientConfig fTPClientConfig = new FTPClientConfig("WINDOWS", "MM-dd-yy kk:mm", null);
/*     */ 
/*     */ 
/*     */     
/*  83 */     fTPClientConfig.setDefaultDateFormatStr("MM-dd-yy kk:mm");
/*  84 */     this.timestampParser = new FTPTimestampParserImpl();
/*  85 */     ((Configurable)this.timestampParser).configure(fTPClientConfig);
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
/* 101 */     FTPFile fTPFile = new FTPFile();
/* 102 */     fTPFile.setRawListing(paramString);
/*     */     
/* 104 */     if (matches(paramString)) {
/*     */       
/* 106 */       String str1 = group(1) + " " + group(2);
/* 107 */       String str2 = group(3);
/* 108 */       String str3 = group(4);
/* 109 */       String str4 = group(5);
/*     */       
/*     */       try {
/* 112 */         fTPFile.setTimestamp(parseTimestamp(str1));
/*     */       }
/* 114 */       catch (ParseException parseException) {
/*     */ 
/*     */         
/*     */         try {
/*     */           
/* 119 */           fTPFile.setTimestamp(this.timestampParser.parseTimestamp(str1));
/*     */         }
/* 121 */         catch (ParseException parseException1) {}
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 127 */       if (null == str4 || str4.equals(".") || str4.equals(".."))
/*     */       {
/* 129 */         return null;
/*     */       }
/* 131 */       fTPFile.setName(str4);
/*     */ 
/*     */       
/* 134 */       if ("<DIR>".equals(str2)) {
/*     */         
/* 136 */         fTPFile.setType(1);
/* 137 */         fTPFile.setSize(0L);
/*     */       }
/*     */       else {
/*     */         
/* 141 */         fTPFile.setType(0);
/* 142 */         if (null != str3)
/*     */         {
/* 144 */           fTPFile.setSize(Long.parseLong(str3));
/*     */         }
/*     */       } 
/* 147 */       return fTPFile;
/*     */     } 
/* 149 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPClientConfig getDefaultConfiguration() {
/* 160 */     return new FTPClientConfig("WINDOWS", "MM-dd-yy hh:mma", null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\NTFTPEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */