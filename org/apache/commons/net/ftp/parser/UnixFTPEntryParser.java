/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
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
/*     */ public class UnixFTPEntryParser
/*     */   extends ConfigurableFTPFileEntryParserImpl
/*     */ {
/*     */   static final String DEFAULT_DATE_FORMAT = "MMM d yyyy";
/*     */   static final String DEFAULT_RECENT_DATE_FORMAT = "MMM d HH:mm";
/*     */   static final String NUMERIC_DATE_FORMAT = "yyyy-MM-dd HH:mm";
/*     */   private static final String JA_MONTH = "月";
/*     */   private static final String JA_DAY = "日";
/*     */   private static final String JA_YEAR = "年";
/*     */   private static final String DEFAULT_DATE_FORMAT_JA = "M'月' d'日' yyyy'年'";
/*     */   private static final String DEFAULT_RECENT_DATE_FORMAT_JA = "M'月' d'日' HH:mm";
/*  70 */   public static final FTPClientConfig NUMERIC_DATE_CONFIG = new FTPClientConfig("UNIX", "yyyy-MM-dd HH:mm", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String REGEX = "([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s*(\\d+)\\s+(?:(\\S+(?:\\s\\S+)*?)\\s+)?(?:(\\S+(?:\\s\\S+)*)\\s+)?(\\d+(?:,\\s*\\d+)?)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3})|(?:\\d{1,2}月\\s+\\d{1,2}日))\\s+((?:\\d+(?::\\d+)?)|(?:\\d{4}年))\\s(.*)";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final boolean trimLeadingSpaces;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnixFTPEntryParser() {
/* 162 */     this((FTPClientConfig)null);
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
/*     */   public UnixFTPEntryParser(FTPClientConfig paramFTPClientConfig) {
/* 179 */     this(paramFTPClientConfig, false);
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
/*     */   public UnixFTPEntryParser(FTPClientConfig paramFTPClientConfig, boolean paramBoolean) {
/* 197 */     super("([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s*(\\d+)\\s+(?:(\\S+(?:\\s\\S+)*?)\\s+)?(?:(\\S+(?:\\s\\S+)*)\\s+)?(\\d+(?:,\\s*\\d+)?)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3})|(?:\\d{1,2}月\\s+\\d{1,2}日))\\s+((?:\\d+(?::\\d+)?)|(?:\\d{4}年))\\s(.*)");
/* 198 */     configure(paramFTPClientConfig);
/* 199 */     this.trimLeadingSpaces = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> preParse(List<String> paramList) {
/* 207 */     ListIterator<String> listIterator = paramList.listIterator();
/* 208 */     while (listIterator.hasNext()) {
/* 209 */       String str = listIterator.next();
/* 210 */       if (str.matches("^total \\d+$")) {
/* 211 */         listIterator.remove();
/*     */       }
/*     */     } 
/* 214 */     return paramList;
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
/*     */   public FTPFile parseFTPEntry(String paramString) {
/* 229 */     FTPFile fTPFile = new FTPFile();
/* 230 */     fTPFile.setRawListing(paramString);
/*     */     
/* 232 */     boolean bool = false;
/*     */     
/* 234 */     if (matches(paramString)) {
/*     */       byte b1;
/* 236 */       String str1 = group(1);
/* 237 */       String str2 = group(15);
/* 238 */       String str3 = group(16);
/* 239 */       String str4 = group(17);
/* 240 */       String str5 = group(18);
/* 241 */       String str6 = group(19) + " " + group(20);
/* 242 */       String str7 = group(21);
/* 243 */       if (this.trimLeadingSpaces) {
/* 244 */         str7 = str7.replaceFirst("^\\s+", "");
/*     */       }
/*     */ 
/*     */       
/*     */       try {
/* 249 */         if (group(19).contains("月")) {
/* 250 */           FTPTimestampParserImpl fTPTimestampParserImpl = new FTPTimestampParserImpl();
/* 251 */           fTPTimestampParserImpl.configure(new FTPClientConfig("UNIX", "M'月' d'日' yyyy'年'", "M'月' d'日' HH:mm"));
/*     */           
/* 253 */           fTPFile.setTimestamp(fTPTimestampParserImpl.parseTimestamp(str6));
/*     */         } else {
/* 255 */           fTPFile.setTimestamp(parseTimestamp(str6));
/*     */         }
/*     */       
/* 258 */       } catch (ParseException parseException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 267 */       switch (str1.charAt(0)) {
/*     */         
/*     */         case 'd':
/* 270 */           b1 = 1;
/*     */           break;
/*     */         case 'e':
/* 273 */           b1 = 2;
/*     */           break;
/*     */         case 'l':
/* 276 */           b1 = 2;
/*     */           break;
/*     */         case 'b':
/*     */         case 'c':
/* 280 */           bool = true;
/* 281 */           b1 = 0;
/*     */           break;
/*     */         case '-':
/*     */         case 'f':
/* 285 */           b1 = 0;
/*     */           break;
/*     */         default:
/* 288 */           b1 = 3;
/*     */           break;
/*     */       } 
/* 291 */       fTPFile.setType(b1);
/*     */       
/* 293 */       byte b2 = 4; int i;
/* 294 */       for (i = 0; i < 3; i++, b2 += 4) {
/*     */ 
/*     */         
/* 297 */         fTPFile.setPermission(i, 0, 
/* 298 */             !group(b2).equals("-"));
/* 299 */         fTPFile.setPermission(i, 1, 
/* 300 */             !group(b2 + 1).equals("-"));
/*     */         
/* 302 */         String str = group(b2 + 2);
/* 303 */         if (!str.equals("-") && !Character.isUpperCase(str.charAt(0))) {
/*     */           
/* 305 */           fTPFile.setPermission(i, 2, true);
/*     */         }
/*     */         else {
/*     */           
/* 309 */           fTPFile.setPermission(i, 2, false);
/*     */         } 
/*     */       } 
/*     */       
/* 313 */       if (!bool) {
/*     */         
/*     */         try {
/*     */           
/* 317 */           fTPFile.setHardLinkCount(Integer.parseInt(str2));
/*     */         }
/* 319 */         catch (NumberFormatException numberFormatException) {}
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 325 */       fTPFile.setUser(str3);
/* 326 */       fTPFile.setGroup(str4);
/*     */ 
/*     */       
/*     */       try {
/* 330 */         fTPFile.setSize(Long.parseLong(str5));
/*     */       }
/* 332 */       catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 339 */       if (b1 == 2) {
/*     */ 
/*     */         
/* 342 */         i = str7.indexOf(" -> ");
/*     */         
/* 344 */         if (i == -1)
/*     */         {
/* 346 */           fTPFile.setName(str7);
/*     */         }
/*     */         else
/*     */         {
/* 350 */           fTPFile.setName(str7.substring(0, i));
/* 351 */           fTPFile.setLink(str7.substring(i + 4));
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 357 */         fTPFile.setName(str7);
/*     */       } 
/* 359 */       return fTPFile;
/*     */     } 
/* 361 */     return null;
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
/* 372 */     return new FTPClientConfig("UNIX", "MMM d yyyy", "MMM d HH:mm");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\UnixFTPEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */