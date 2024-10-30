/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.text.ParseException;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.commons.net.ftp.FTPClientConfig;
/*     */ import org.apache.commons.net.ftp.FTPFile;
/*     */ import org.apache.commons.net.ftp.FTPFileEntryParser;
/*     */ import org.apache.commons.net.ftp.FTPListParseEngine;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VMSFTPEntryParser
/*     */   extends ConfigurableFTPFileEntryParserImpl
/*     */ {
/*     */   private static final String DEFAULT_DATE_FORMAT = "d-MMM-yyyy HH:mm:ss";
/*     */   private static final String REGEX = "(.*?;[0-9]+)\\s*(\\d+)(?:/\\d+)?\\s*(\\S+)\\s+(\\S+)\\s+\\[(([0-9$A-Za-z_]+)|([0-9$A-Za-z_]+),([0-9$a-zA-Z_]+))\\]?\\s*\\([a-zA-Z]*,([a-zA-Z]*),([a-zA-Z]*),([a-zA-Z]*)\\)";
/*     */   
/*     */   public VMSFTPEntryParser() {
/*  73 */     this((FTPClientConfig)null);
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
/*     */   public VMSFTPEntryParser(FTPClientConfig paramFTPClientConfig) {
/*  90 */     super("(.*?;[0-9]+)\\s*(\\d+)(?:/\\d+)?\\s*(\\S+)\\s+(\\S+)\\s+\\[(([0-9$A-Za-z_]+)|([0-9$A-Za-z_]+),([0-9$a-zA-Z_]+))\\]?\\s*\\([a-zA-Z]*,([a-zA-Z]*),([a-zA-Z]*),([a-zA-Z]*)\\)");
/*  91 */     configure(paramFTPClientConfig);
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
/* 108 */     long l = 512L;
/*     */     
/* 110 */     if (matches(paramString)) {
/*     */       String str5, str6;
/* 112 */       FTPFile fTPFile = new FTPFile();
/* 113 */       fTPFile.setRawListing(paramString);
/* 114 */       String str1 = group(1);
/* 115 */       String str2 = group(2);
/* 116 */       String str3 = group(3) + " " + group(4);
/* 117 */       String str4 = group(5);
/* 118 */       String[] arrayOfString = new String[3];
/* 119 */       arrayOfString[0] = group(9);
/* 120 */       arrayOfString[1] = group(10);
/* 121 */       arrayOfString[2] = group(11);
/*     */       
/*     */       try {
/* 124 */         fTPFile.setTimestamp(parseTimestamp(str3));
/*     */       }
/* 126 */       catch (ParseException parseException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       StringTokenizer stringTokenizer = new StringTokenizer(str4, ",");
/* 135 */       switch (stringTokenizer.countTokens()) {
/*     */         case 1:
/* 137 */           str5 = null;
/* 138 */           str6 = stringTokenizer.nextToken();
/*     */           break;
/*     */         case 2:
/* 141 */           str5 = stringTokenizer.nextToken();
/* 142 */           str6 = stringTokenizer.nextToken();
/*     */           break;
/*     */         default:
/* 145 */           str5 = null;
/* 146 */           str6 = null;
/*     */           break;
/*     */       } 
/* 149 */       if (str1.lastIndexOf(".DIR") != -1) {
/*     */         
/* 151 */         fTPFile.setType(1);
/*     */       }
/*     */       else {
/*     */         
/* 155 */         fTPFile.setType(0);
/*     */       } 
/*     */ 
/*     */       
/* 159 */       if (isVersioning()) {
/*     */         
/* 161 */         fTPFile.setName(str1);
/*     */       }
/*     */       else {
/*     */         
/* 165 */         str1 = str1.substring(0, str1.lastIndexOf(';'));
/* 166 */         fTPFile.setName(str1);
/*     */       } 
/*     */ 
/*     */       
/* 170 */       long l1 = Long.parseLong(str2) * 512L;
/* 171 */       fTPFile.setSize(l1);
/*     */       
/* 173 */       fTPFile.setGroup(str5);
/* 174 */       fTPFile.setUser(str6);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 182 */       for (byte b = 0; b < 3; b++) {
/*     */         
/* 184 */         String str = arrayOfString[b];
/*     */         
/* 186 */         fTPFile.setPermission(b, 0, (str.indexOf('R') >= 0));
/* 187 */         fTPFile.setPermission(b, 1, (str.indexOf('W') >= 0));
/* 188 */         fTPFile.setPermission(b, 2, (str.indexOf('E') >= 0));
/*     */       } 
/*     */       
/* 191 */       return fTPFile;
/*     */     } 
/* 193 */     return null;
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
/*     */   public String readNextEntry(BufferedReader paramBufferedReader) throws IOException {
/* 212 */     String str = paramBufferedReader.readLine();
/* 213 */     StringBuilder stringBuilder = new StringBuilder();
/* 214 */     while (str != null) {
/*     */       
/* 216 */       if (str.startsWith("Directory") || str.startsWith("Total")) {
/* 217 */         str = paramBufferedReader.readLine();
/*     */         
/*     */         continue;
/*     */       } 
/* 221 */       stringBuilder.append(str);
/* 222 */       if (str.trim().endsWith(")")) {
/*     */         break;
/*     */       }
/*     */       
/* 226 */       str = paramBufferedReader.readLine();
/*     */     } 
/* 228 */     return (stringBuilder.length() == 0) ? null : stringBuilder.toString();
/*     */   }
/*     */   
/*     */   protected boolean isVersioning() {
/* 232 */     return false;
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
/* 243 */     return new FTPClientConfig("VMS", "d-MMM-yyyy HH:mm:ss", null);
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
/*     */   @Deprecated
/*     */   public FTPFile[] parseFileList(InputStream paramInputStream) throws IOException {
/* 260 */     FTPListParseEngine fTPListParseEngine = new FTPListParseEngine((FTPFileEntryParser)this);
/* 261 */     fTPListParseEngine.readServerList(paramInputStream, null);
/* 262 */     return fTPListParseEngine.getFiles();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\VMSFTPEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */