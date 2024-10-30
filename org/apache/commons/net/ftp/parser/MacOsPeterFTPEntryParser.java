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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MacOsPeterFTPEntryParser
/*     */   extends ConfigurableFTPFileEntryParserImpl
/*     */ {
/*     */   static final String DEFAULT_DATE_FORMAT = "MMM d yyyy";
/*     */   static final String DEFAULT_RECENT_DATE_FORMAT = "MMM d HH:mm";
/*     */   private static final String REGEX = "([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s+((folder\\s+)|((\\d+)\\s+(\\d+)\\s+))(\\d+)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3}))\\s+(\\d+(?::\\d+)?)\\s+(\\S*)(\\s*.*)";
/*     */   
/*     */   public MacOsPeterFTPEntryParser() {
/*  96 */     this((FTPClientConfig)null);
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
/*     */   public MacOsPeterFTPEntryParser(FTPClientConfig paramFTPClientConfig) {
/* 113 */     super("([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s+((folder\\s+)|((\\d+)\\s+(\\d+)\\s+))(\\d+)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3}))\\s+(\\d+(?::\\d+)?)\\s+(\\S*)(\\s*.*)");
/* 114 */     configure(paramFTPClientConfig);
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
/* 129 */     FTPFile fTPFile = new FTPFile();
/* 130 */     fTPFile.setRawListing(paramString);
/*     */     
/* 132 */     boolean bool = false;
/*     */     
/* 134 */     if (matches(paramString)) {
/*     */       byte b1;
/* 136 */       String str1 = group(1);
/* 137 */       String str2 = "0";
/* 138 */       String str3 = null;
/* 139 */       String str4 = null;
/* 140 */       String str5 = group(20);
/* 141 */       String str6 = group(21) + " " + group(22);
/* 142 */       String str7 = group(23);
/* 143 */       String str8 = group(24);
/*     */ 
/*     */       
/*     */       try {
/* 147 */         fTPFile.setTimestamp(parseTimestamp(str6));
/*     */       }
/* 149 */       catch (ParseException parseException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       switch (str1.charAt(0)) {
/*     */         
/*     */         case 'd':
/* 161 */           b1 = 1;
/*     */           break;
/*     */         case 'e':
/* 164 */           b1 = 2;
/*     */           break;
/*     */         case 'l':
/* 167 */           b1 = 2;
/*     */           break;
/*     */         case 'b':
/*     */         case 'c':
/* 171 */           bool = true;
/* 172 */           b1 = 0;
/*     */           break;
/*     */         case '-':
/*     */         case 'f':
/* 176 */           b1 = 0;
/*     */           break;
/*     */         default:
/* 179 */           b1 = 3;
/*     */           break;
/*     */       } 
/* 182 */       fTPFile.setType(b1);
/*     */       
/* 184 */       byte b2 = 4; int i;
/* 185 */       for (i = 0; i < 3; i++, b2 += 4) {
/*     */ 
/*     */         
/* 188 */         fTPFile.setPermission(i, 0, 
/* 189 */             !group(b2).equals("-"));
/* 190 */         fTPFile.setPermission(i, 1, 
/* 191 */             !group(b2 + 1).equals("-"));
/*     */         
/* 193 */         String str = group(b2 + 2);
/* 194 */         if (!str.equals("-") && !Character.isUpperCase(str.charAt(0))) {
/*     */           
/* 196 */           fTPFile.setPermission(i, 2, true);
/*     */         }
/*     */         else {
/*     */           
/* 200 */           fTPFile.setPermission(i, 2, false);
/*     */         } 
/*     */       } 
/*     */       
/* 204 */       if (!bool) {
/*     */         
/*     */         try {
/*     */           
/* 208 */           fTPFile.setHardLinkCount(Integer.parseInt("0"));
/*     */         }
/* 210 */         catch (NumberFormatException numberFormatException) {}
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 216 */       fTPFile.setUser(str3);
/* 217 */       fTPFile.setGroup(str4);
/*     */ 
/*     */       
/*     */       try {
/* 221 */         fTPFile.setSize(Long.parseLong(str5));
/*     */       }
/* 223 */       catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 228 */       if (null == str8) {
/*     */         
/* 230 */         fTPFile.setName(str7);
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 236 */         str7 = str7 + str8;
/* 237 */         if (b1 == 2) {
/*     */ 
/*     */           
/* 240 */           i = str7.indexOf(" -> ");
/*     */           
/* 242 */           if (i == -1)
/*     */           {
/* 244 */             fTPFile.setName(str7);
/*     */           }
/*     */           else
/*     */           {
/* 248 */             fTPFile.setName(str7.substring(0, i));
/* 249 */             fTPFile.setLink(str7.substring(i + 4));
/*     */           }
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 255 */           fTPFile.setName(str7);
/*     */         } 
/*     */       } 
/* 258 */       return fTPFile;
/*     */     } 
/* 260 */     return null;
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
/* 271 */     return new FTPClientConfig("UNIX", "MMM d yyyy", "MMM d HH:mm");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\MacOsPeterFTPEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */