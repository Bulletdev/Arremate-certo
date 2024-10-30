/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.text.DateFormatSymbols;
/*     */ import java.text.ParseException;
/*     */ import java.text.ParsePosition;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.TimeZone;
/*     */ import org.apache.commons.net.ftp.Configurable;
/*     */ import org.apache.commons.net.ftp.FTPClientConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FTPTimestampParserImpl
/*     */   implements Configurable, FTPTimestampParser
/*     */ {
/*     */   private SimpleDateFormat defaultDateFormat;
/*     */   private int defaultDateSmallestUnitIndex;
/*     */   private SimpleDateFormat recentDateFormat;
/*     */   private int recentDateSmallestUnitIndex;
/*     */   private boolean lenientFutureDates;
/*  68 */   private static final int[] CALENDAR_UNITS = new int[] { 14, 13, 12, 11, 5, 2, 1 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getEntry(SimpleDateFormat paramSimpleDateFormat) {
/*  83 */     if (paramSimpleDateFormat == null) {
/*  84 */       return 0;
/*     */     }
/*  86 */     String str1 = "SsmHdM";
/*  87 */     String str2 = paramSimpleDateFormat.toPattern();
/*  88 */     for (char c : "SsmHdM".toCharArray()) {
/*  89 */       if (str2.indexOf(c) != -1) {
/*  90 */         switch (c) {
/*     */           case 'S':
/*  92 */             return indexOf(14);
/*     */           case 's':
/*  94 */             return indexOf(13);
/*     */           case 'm':
/*  96 */             return indexOf(12);
/*     */           case 'H':
/*  98 */             return indexOf(11);
/*     */           case 'd':
/* 100 */             return indexOf(5);
/*     */           case 'M':
/* 102 */             return indexOf(2);
/*     */         } 
/*     */       }
/*     */     } 
/* 106 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int indexOf(int paramInt) {
/* 114 */     for (byte b = 0; b < CALENDAR_UNITS.length; b++) {
/* 115 */       if (paramInt == CALENDAR_UNITS[b]) {
/* 116 */         return b;
/*     */       }
/*     */     } 
/* 119 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void setPrecision(int paramInt, Calendar paramCalendar) {
/* 128 */     if (paramInt <= 0) {
/*     */       return;
/*     */     }
/* 131 */     int i = CALENDAR_UNITS[paramInt - 1];
/*     */ 
/*     */     
/* 134 */     int j = paramCalendar.get(i);
/* 135 */     if (j == 0)
/*     */     {
/*     */       
/* 138 */       paramCalendar.clear(i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPTimestampParserImpl() {
/* 146 */     setDefaultDateFormat("MMM d yyyy", null);
/* 147 */     setRecentDateFormat("MMM d HH:mm", null);
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
/*     */   public Calendar parseTimestamp(String paramString) throws ParseException {
/* 169 */     Calendar calendar = Calendar.getInstance();
/* 170 */     return parseTimestamp(paramString, calendar);
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
/*     */   public Calendar parseTimestamp(String paramString, Calendar paramCalendar) throws ParseException {
/* 190 */     Calendar calendar = (Calendar)paramCalendar.clone();
/* 191 */     calendar.setTimeZone(getServerTimeZone());
/*     */     
/* 193 */     Date date = null;
/*     */     
/* 195 */     if (this.recentDateFormat != null) {
/* 196 */       Calendar calendar1 = (Calendar)paramCalendar.clone();
/* 197 */       calendar1.setTimeZone(getServerTimeZone());
/* 198 */       if (this.lenientFutureDates)
/*     */       {
/*     */         
/* 201 */         calendar1.add(5, 1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 212 */       String str1 = Integer.toString(calendar1.get(1));
/* 213 */       String str2 = paramString + " " + str1;
/*     */       
/* 215 */       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.recentDateFormat.toPattern() + " yyyy", this.recentDateFormat.getDateFormatSymbols());
/* 216 */       simpleDateFormat.setLenient(false);
/* 217 */       simpleDateFormat.setTimeZone(this.recentDateFormat.getTimeZone());
/* 218 */       ParsePosition parsePosition1 = new ParsePosition(0);
/* 219 */       date = simpleDateFormat.parse(str2, parsePosition1);
/*     */       
/* 221 */       if (date != null && parsePosition1.getIndex() == str2.length()) {
/* 222 */         calendar.setTime(date);
/* 223 */         if (calendar.after(calendar1)) {
/* 224 */           calendar.add(1, -1);
/*     */         }
/* 226 */         setPrecision(this.recentDateSmallestUnitIndex, calendar);
/* 227 */         return calendar;
/*     */       } 
/*     */     } 
/*     */     
/* 231 */     ParsePosition parsePosition = new ParsePosition(0);
/* 232 */     date = this.defaultDateFormat.parse(paramString, parsePosition);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 240 */     if (date != null && parsePosition.getIndex() == paramString.length()) {
/* 241 */       calendar.setTime(date);
/*     */     } else {
/* 243 */       throw new ParseException("Timestamp '" + paramString + "' could not be parsed using a server time of " + paramCalendar
/*     */           
/* 245 */           .getTime().toString(), parsePosition
/* 246 */           .getErrorIndex());
/*     */     } 
/* 248 */     setPrecision(this.defaultDateSmallestUnitIndex, calendar);
/* 249 */     return calendar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleDateFormat getDefaultDateFormat() {
/* 256 */     return this.defaultDateFormat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultDateFormatString() {
/* 262 */     return this.defaultDateFormat.toPattern();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setDefaultDateFormat(String paramString, DateFormatSymbols paramDateFormatSymbols) {
/* 269 */     if (paramString != null) {
/* 270 */       if (paramDateFormatSymbols != null) {
/* 271 */         this.defaultDateFormat = new SimpleDateFormat(paramString, paramDateFormatSymbols);
/*     */       } else {
/* 273 */         this.defaultDateFormat = new SimpleDateFormat(paramString);
/*     */       } 
/* 275 */       this.defaultDateFormat.setLenient(false);
/*     */     } else {
/* 277 */       this.defaultDateFormat = null;
/*     */     } 
/* 279 */     this.defaultDateSmallestUnitIndex = getEntry(this.defaultDateFormat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleDateFormat getRecentDateFormat() {
/* 285 */     return this.recentDateFormat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecentDateFormatString() {
/* 291 */     return this.recentDateFormat.toPattern();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRecentDateFormat(String paramString, DateFormatSymbols paramDateFormatSymbols) {
/* 298 */     if (paramString != null) {
/* 299 */       if (paramDateFormatSymbols != null) {
/* 300 */         this.recentDateFormat = new SimpleDateFormat(paramString, paramDateFormatSymbols);
/*     */       } else {
/* 302 */         this.recentDateFormat = new SimpleDateFormat(paramString);
/*     */       } 
/* 304 */       this.recentDateFormat.setLenient(false);
/*     */     } else {
/* 306 */       this.recentDateFormat = null;
/*     */     } 
/* 308 */     this.recentDateSmallestUnitIndex = getEntry(this.recentDateFormat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getShortMonths() {
/* 316 */     return this.defaultDateFormat.getDateFormatSymbols().getShortMonths();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimeZone getServerTimeZone() {
/* 324 */     return this.defaultDateFormat.getTimeZone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setServerTimeZone(String paramString) {
/* 333 */     TimeZone timeZone = TimeZone.getDefault();
/* 334 */     if (paramString != null) {
/* 335 */       timeZone = TimeZone.getTimeZone(paramString);
/*     */     }
/* 337 */     this.defaultDateFormat.setTimeZone(timeZone);
/* 338 */     if (this.recentDateFormat != null) {
/* 339 */       this.recentDateFormat.setTimeZone(timeZone);
/*     */     }
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
/*     */   public void configure(FTPClientConfig paramFTPClientConfig) {
/* 368 */     DateFormatSymbols dateFormatSymbols = null;
/*     */     
/* 370 */     String str1 = paramFTPClientConfig.getServerLanguageCode();
/* 371 */     String str2 = paramFTPClientConfig.getShortMonthNames();
/* 372 */     if (str2 != null) {
/* 373 */       dateFormatSymbols = FTPClientConfig.getDateFormatSymbols(str2);
/* 374 */     } else if (str1 != null) {
/* 375 */       dateFormatSymbols = FTPClientConfig.lookupDateFormatSymbols(str1);
/*     */     } else {
/* 377 */       dateFormatSymbols = FTPClientConfig.lookupDateFormatSymbols("en");
/*     */     } 
/*     */ 
/*     */     
/* 381 */     String str3 = paramFTPClientConfig.getRecentDateFormatStr();
/* 382 */     setRecentDateFormat(str3, dateFormatSymbols);
/*     */     
/* 384 */     String str4 = paramFTPClientConfig.getDefaultDateFormatStr();
/* 385 */     if (str4 == null) {
/* 386 */       throw new IllegalArgumentException("defaultFormatString cannot be null");
/*     */     }
/* 388 */     setDefaultDateFormat(str4, dateFormatSymbols);
/*     */     
/* 390 */     setServerTimeZone(paramFTPClientConfig.getServerTimeZoneId());
/*     */     
/* 392 */     this.lenientFutureDates = paramFTPClientConfig.isLenientFutureDates();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isLenientFutureDates() {
/* 398 */     return this.lenientFutureDates;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void setLenientFutureDates(boolean paramBoolean) {
/* 404 */     this.lenientFutureDates = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\FTPTimestampParserImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */