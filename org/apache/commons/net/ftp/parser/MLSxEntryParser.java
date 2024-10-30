/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.text.ParsePosition;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import org.apache.commons.net.ftp.FTPFile;
/*     */ import org.apache.commons.net.ftp.FTPFileEntryParserImpl;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MLSxEntryParser
/*     */   extends FTPFileEntryParserImpl
/*     */ {
/*  63 */   private static final MLSxEntryParser INSTANCE = new MLSxEntryParser();
/*     */   
/*  65 */   private static final HashMap<String, Integer> TYPE_TO_INT = new HashMap<>();
/*     */   static {
/*  67 */     TYPE_TO_INT.put("file", Integer.valueOf(0));
/*  68 */     TYPE_TO_INT.put("cdir", Integer.valueOf(1));
/*  69 */     TYPE_TO_INT.put("pdir", Integer.valueOf(1));
/*  70 */     TYPE_TO_INT.put("dir", Integer.valueOf(1));
/*     */   }
/*     */   
/*  73 */   private static final int[] UNIX_GROUPS = new int[] { 0, 1, 2 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   private static final int[][] UNIX_PERMS = new int[][] { {}, { 2 }, { 1 }, { 2, 1 }, { 0 }, { 0, 2 }, { 0, 1 }, { 0, 1, 2 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 100 */     if (paramString.startsWith(" ")) {
/* 101 */       if (paramString.length() > 1) {
/* 102 */         FTPFile fTPFile1 = new FTPFile();
/* 103 */         fTPFile1.setRawListing(paramString);
/* 104 */         fTPFile1.setName(paramString.substring(1));
/* 105 */         return fTPFile1;
/*     */       } 
/* 107 */       return null;
/*     */     } 
/*     */     
/* 110 */     String[] arrayOfString1 = paramString.split(" ", 2);
/* 111 */     if (arrayOfString1.length != 2 || arrayOfString1[1].isEmpty()) {
/* 112 */       return null;
/*     */     }
/* 114 */     String str = arrayOfString1[0];
/* 115 */     if (!str.endsWith(";")) {
/* 116 */       return null;
/*     */     }
/* 118 */     FTPFile fTPFile = new FTPFile();
/* 119 */     fTPFile.setRawListing(paramString);
/* 120 */     fTPFile.setName(arrayOfString1[1]);
/* 121 */     String[] arrayOfString2 = str.split(";");
/* 122 */     boolean bool = arrayOfString1[0].toLowerCase(Locale.ENGLISH).contains("unix.mode=");
/* 123 */     for (String str1 : arrayOfString2) {
/* 124 */       String[] arrayOfString = str1.split("=", -1);
/*     */ 
/*     */ 
/*     */       
/* 128 */       if (arrayOfString.length != 2) {
/* 129 */         return null;
/*     */       }
/* 131 */       String str2 = arrayOfString[0].toLowerCase(Locale.ENGLISH);
/* 132 */       String str3 = arrayOfString[1];
/* 133 */       if (!str3.isEmpty()) {
/*     */ 
/*     */         
/* 136 */         String str4 = str3.toLowerCase(Locale.ENGLISH);
/* 137 */         if ("size".equals(str2) || "sizd".equals(str2)) {
/* 138 */           fTPFile.setSize(Long.parseLong(str3));
/*     */         }
/* 140 */         else if ("modify".equals(str2)) {
/* 141 */           Calendar calendar = parseGMTdateTime(str3);
/* 142 */           if (calendar == null) {
/* 143 */             return null;
/*     */           }
/* 145 */           fTPFile.setTimestamp(calendar);
/*     */         }
/* 147 */         else if ("type".equals(str2)) {
/* 148 */           Integer integer = TYPE_TO_INT.get(str4);
/* 149 */           if (integer == null) {
/* 150 */             fTPFile.setType(3);
/*     */           } else {
/* 152 */             fTPFile.setType(integer.intValue());
/*     */           }
/*     */         
/* 155 */         } else if (str2.startsWith("unix.")) {
/* 156 */           String str5 = str2.substring("unix.".length()).toLowerCase(Locale.ENGLISH);
/* 157 */           if ("group".equals(str5)) {
/* 158 */             fTPFile.setGroup(str3);
/* 159 */           } else if ("owner".equals(str5)) {
/* 160 */             fTPFile.setUser(str3);
/* 161 */           } else if ("mode".equals(str5)) {
/* 162 */             int i = str3.length() - 3;
/* 163 */             for (byte b = 0; b < 3; b++) {
/* 164 */               int j = str3.charAt(i + b) - 48;
/* 165 */               if (j >= 0 && j <= 7) {
/* 166 */                 for (int k : UNIX_PERMS[j]) {
/* 167 */                   fTPFile.setPermission(UNIX_GROUPS[b], k, true);
/*     */                 }
/*     */               }
/*     */             }
/*     */           
/*     */           }
/*     */         
/*     */         }
/* 175 */         else if (!bool && "perm".equals(str2)) {
/* 176 */           doUnixPerms(fTPFile, str4);
/*     */         } 
/*     */       } 
/* 179 */     }  return fTPFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Calendar parseGMTdateTime(String paramString) {
/*     */     SimpleDateFormat simpleDateFormat;
/*     */     boolean bool;
/* 192 */     if (paramString.contains(".")) {
/* 193 */       simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
/* 194 */       bool = true;
/*     */     } else {
/* 196 */       simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
/* 197 */       bool = false;
/*     */     } 
/* 199 */     TimeZone timeZone = TimeZone.getTimeZone("GMT");
/*     */     
/* 201 */     simpleDateFormat.setTimeZone(timeZone);
/* 202 */     GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
/* 203 */     ParsePosition parsePosition = new ParsePosition(0);
/* 204 */     simpleDateFormat.setLenient(false);
/* 205 */     Date date = simpleDateFormat.parse(paramString, parsePosition);
/* 206 */     if (parsePosition.getIndex() != paramString.length()) {
/* 207 */       return null;
/*     */     }
/* 209 */     gregorianCalendar.setTime(date);
/* 210 */     if (!bool) {
/* 211 */       gregorianCalendar.clear(14);
/*     */     }
/* 213 */     return gregorianCalendar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doUnixPerms(FTPFile paramFTPFile, String paramString) {
/* 220 */     for (char c : paramString.toCharArray()) {
/*     */       
/* 222 */       switch (c) {
/*     */         case 'a':
/* 224 */           paramFTPFile.setPermission(0, 1, true);
/*     */           break;
/*     */         case 'c':
/* 227 */           paramFTPFile.setPermission(0, 1, true);
/*     */           break;
/*     */         case 'd':
/* 230 */           paramFTPFile.setPermission(0, 1, true);
/*     */           break;
/*     */         case 'e':
/* 233 */           paramFTPFile.setPermission(0, 0, true);
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         case 'l':
/* 239 */           paramFTPFile.setPermission(0, 2, true);
/*     */           break;
/*     */         case 'm':
/* 242 */           paramFTPFile.setPermission(0, 1, true);
/*     */           break;
/*     */         case 'p':
/* 245 */           paramFTPFile.setPermission(0, 1, true);
/*     */           break;
/*     */         case 'r':
/* 248 */           paramFTPFile.setPermission(0, 0, true);
/*     */           break;
/*     */         case 'w':
/* 251 */           paramFTPFile.setPermission(0, 1, true);
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FTPFile parseEntry(String paramString) {
/* 261 */     return INSTANCE.parseFTPEntry(paramString);
/*     */   }
/*     */   
/*     */   public static MLSxEntryParser getInstance() {
/* 265 */     return INSTANCE;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\MLSxEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */