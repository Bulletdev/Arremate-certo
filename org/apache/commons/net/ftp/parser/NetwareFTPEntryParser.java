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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NetwareFTPEntryParser
/*     */   extends ConfigurableFTPFileEntryParserImpl
/*     */ {
/*     */   private static final String DEFAULT_DATE_FORMAT = "MMM dd yyyy";
/*     */   private static final String DEFAULT_RECENT_DATE_FORMAT = "MMM dd HH:mm";
/*     */   private static final String REGEX = "(d|-){1}\\s+\\[([-A-Z]+)\\]\\s+(\\S+)\\s+(\\d+)\\s+(\\S+\\s+\\S+\\s+((\\d+:\\d+)|(\\d{4})))\\s+(.*)";
/*     */   
/*     */   public NetwareFTPEntryParser() {
/*  66 */     this((FTPClientConfig)null);
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
/*     */   public NetwareFTPEntryParser(FTPClientConfig paramFTPClientConfig) {
/*  82 */     super("(d|-){1}\\s+\\[([-A-Z]+)\\]\\s+(\\S+)\\s+(\\d+)\\s+(\\S+\\s+\\S+\\s+((\\d+:\\d+)|(\\d{4})))\\s+(.*)");
/*  83 */     configure(paramFTPClientConfig);
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
/*     */   public FTPFile parseFTPEntry(String paramString) {
/* 116 */     FTPFile fTPFile = new FTPFile();
/* 117 */     if (matches(paramString)) {
/* 118 */       String str1 = group(1);
/* 119 */       String str2 = group(2);
/* 120 */       String str3 = group(3);
/* 121 */       String str4 = group(4);
/* 122 */       String str5 = group(5);
/* 123 */       String str6 = group(9);
/*     */       
/*     */       try {
/* 126 */         fTPFile.setTimestamp(parseTimestamp(str5));
/* 127 */       } catch (ParseException parseException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 132 */       if (str1.trim().equals("d")) {
/* 133 */         fTPFile.setType(1);
/*     */       } else {
/*     */         
/* 136 */         fTPFile.setType(0);
/*     */       } 
/*     */       
/* 139 */       fTPFile.setUser(str3);
/*     */ 
/*     */       
/* 142 */       fTPFile.setName(str6.trim());
/*     */ 
/*     */       
/* 145 */       fTPFile.setSize(Long.parseLong(str4.trim()));
/*     */ 
/*     */ 
/*     */       
/* 149 */       if (str2.indexOf('R') != -1) {
/* 150 */         fTPFile.setPermission(0, 0, true);
/*     */       }
/*     */       
/* 153 */       if (str2.indexOf('W') != -1) {
/* 154 */         fTPFile.setPermission(0, 1, true);
/*     */       }
/*     */ 
/*     */       
/* 158 */       return fTPFile;
/*     */     } 
/* 160 */     return null;
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
/* 172 */     return new FTPClientConfig("NETWARE", "MMM dd yyyy", "MMM dd HH:mm");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\NetwareFTPEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */