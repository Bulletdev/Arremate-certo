/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.util.Calendar;
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
/*     */ public class EnterpriseUnixFTPEntryParser
/*     */   extends RegexFTPFileEntryParserImpl
/*     */ {
/*     */   private static final String MONTHS = "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)";
/*     */   private static final String REGEX = "(([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z]))(\\S*)\\s*(\\S+)\\s*(\\S*)\\s*(\\d*)\\s*(\\d*)\\s*(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s*((?:[012]\\d*)|(?:3[01]))\\s*((\\d\\d\\d\\d)|((?:[01]\\d)|(?:2[0123])):([012345]\\d))\\s(\\S*)(\\s*.*)";
/*     */   
/*     */   public EnterpriseUnixFTPEntryParser() {
/*  74 */     super("(([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z]))(\\S*)\\s*(\\S+)\\s*(\\S*)\\s*(\\d*)\\s*(\\d*)\\s*(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s*((?:[012]\\d*)|(?:3[01]))\\s*((\\d\\d\\d\\d)|((?:[01]\\d)|(?:2[0123])):([012345]\\d))\\s(\\S*)(\\s*.*)");
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
/*  91 */     FTPFile fTPFile = new FTPFile();
/*  92 */     fTPFile.setRawListing(paramString);
/*     */     
/*  94 */     if (matches(paramString)) {
/*     */       
/*  96 */       String str1 = group(14);
/*  97 */       String str2 = group(15);
/*  98 */       String str3 = group(16);
/*  99 */       String str4 = group(17);
/* 100 */       String str5 = group(18);
/* 101 */       String str6 = group(20);
/* 102 */       String str7 = group(21);
/* 103 */       String str8 = group(22);
/* 104 */       String str9 = group(23);
/*     */       
/* 106 */       fTPFile.setType(0);
/* 107 */       fTPFile.setUser(str1);
/* 108 */       fTPFile.setGroup(str2);
/*     */       
/*     */       try {
/* 111 */         fTPFile.setSize(Long.parseLong(str3));
/*     */       }
/* 113 */       catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 118 */       Calendar calendar = Calendar.getInstance();
/* 119 */       calendar.set(14, 0);
/* 120 */       calendar.set(13, 0);
/* 121 */       calendar.set(12, 0);
/* 122 */       calendar.set(11, 0);
/*     */       
/* 124 */       int i = "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)".indexOf(str4);
/* 125 */       int j = i / 4;
/*     */       
/*     */       try {
/*     */         byte b;
/*     */         
/* 130 */         if (str6 != null) {
/*     */ 
/*     */           
/* 133 */           calendar.set(1, Integer.parseInt(str6));
/* 134 */           b = 11;
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 139 */           b = 13;
/* 140 */           int k = calendar.get(1);
/*     */ 
/*     */ 
/*     */           
/* 144 */           if (calendar.get(2) < j)
/*     */           {
/* 146 */             k--;
/*     */           }
/* 148 */           calendar.set(1, k);
/* 149 */           calendar.set(11, Integer.parseInt(str7));
/* 150 */           calendar.set(12, Integer.parseInt(str8));
/*     */         } 
/* 152 */         calendar.set(2, j);
/* 153 */         calendar.set(5, Integer.parseInt(str5));
/* 154 */         calendar.clear(b);
/* 155 */         fTPFile.setTimestamp(calendar);
/*     */       }
/* 157 */       catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */ 
/*     */       
/* 161 */       fTPFile.setName(str9);
/*     */       
/* 163 */       return fTPFile;
/*     */     } 
/* 165 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\EnterpriseUnixFTPEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */