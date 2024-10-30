/*     */ package org.apache.commons.net.ntp;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TimeStamp
/*     */   implements Serializable, Comparable<TimeStamp>
/*     */ {
/*     */   private static final long serialVersionUID = 8139806907588338737L;
/*     */   protected static final long msb0baseTime = 2085978496000L;
/*     */   protected static final long msb1baseTime = -2208988800000L;
/*     */   public static final String NTP_DATE_FORMAT = "EEE, MMM dd yyyy HH:mm:ss.SSS";
/*     */   private final long ntpTime;
/*     */   private DateFormat simpleFormatter;
/*     */   private DateFormat utcFormatter;
/*     */   
/*     */   public TimeStamp(long paramLong) {
/*  94 */     this.ntpTime = paramLong;
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
/*     */   public TimeStamp(String paramString) throws NumberFormatException {
/* 107 */     this.ntpTime = decodeNtpHexString(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimeStamp(Date paramDate) {
/* 118 */     this.ntpTime = (paramDate == null) ? 0L : toNtpTime(paramDate.getTime());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long ntpValue() {
/* 128 */     return this.ntpTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSeconds() {
/* 138 */     return this.ntpTime >>> 32L & 0xFFFFFFFFL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getFraction() {
/* 148 */     return this.ntpTime & 0xFFFFFFFFL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTime() {
/* 159 */     return getTime(this.ntpTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDate() {
/* 169 */     return new Date(getTime(this.ntpTime));
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
/*     */   public static long getTime(long paramLong) {
/* 187 */     long l1 = paramLong >>> 32L & 0xFFFFFFFFL;
/* 188 */     long l2 = paramLong & 0xFFFFFFFFL;
/*     */ 
/*     */     
/* 191 */     l2 = Math.round(1000.0D * l2 / 4.294967296E9D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     long l3 = l1 & 0x80000000L;
/* 203 */     if (l3 == 0L)
/*     */     {
/* 205 */       return 2085978496000L + l1 * 1000L + l2;
/*     */     }
/*     */     
/* 208 */     return -2208988800000L + l1 * 1000L + l2;
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
/*     */   public static TimeStamp getNtpTime(long paramLong) {
/* 223 */     return new TimeStamp(toNtpTime(paramLong));
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
/*     */   public static TimeStamp getCurrentTime() {
/* 235 */     return getNtpTime(System.currentTimeMillis());
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
/*     */   protected static long decodeNtpHexString(String paramString) throws NumberFormatException {
/* 249 */     if (paramString == null) {
/* 250 */       throw new NumberFormatException("null");
/*     */     }
/* 252 */     int i = paramString.indexOf('.');
/* 253 */     if (i == -1) {
/* 254 */       if (paramString.isEmpty()) {
/* 255 */         return 0L;
/*     */       }
/* 257 */       return Long.parseLong(paramString, 16) << 32L;
/*     */     } 
/*     */     
/* 260 */     return Long.parseLong(paramString.substring(0, i), 16) << 32L | 
/* 261 */       Long.parseLong(paramString.substring(i + 1), 16);
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
/*     */   public static TimeStamp parseNtpString(String paramString) throws NumberFormatException {
/* 275 */     return new TimeStamp(decodeNtpHexString(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static long toNtpTime(long paramLong) {
/*     */     long l1;
/* 286 */     boolean bool = (paramLong < 2085978496000L) ? true : false;
/*     */     
/* 288 */     if (bool) {
/* 289 */       l1 = paramLong - -2208988800000L;
/*     */     } else {
/*     */       
/* 292 */       l1 = paramLong - 2085978496000L;
/*     */     } 
/*     */     
/* 295 */     long l2 = l1 / 1000L;
/* 296 */     long l3 = l1 % 1000L * 4294967296L / 1000L;
/*     */     
/* 298 */     if (bool) {
/* 299 */       l2 |= 0x80000000L;
/*     */     }
/*     */     
/* 302 */     return l2 << 32L | l3;
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
/*     */   public int hashCode() {
/* 319 */     return (int)(this.ntpTime ^ this.ntpTime >>> 32L);
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
/*     */   public boolean equals(Object paramObject) {
/* 335 */     if (paramObject instanceof TimeStamp) {
/* 336 */       return (this.ntpTime == ((TimeStamp)paramObject).ntpValue());
/*     */     }
/* 338 */     return false;
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
/*     */   public String toString() {
/* 353 */     return toString(this.ntpTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void appendHexString(StringBuilder paramStringBuilder, long paramLong) {
/* 364 */     String str = Long.toHexString(paramLong);
/* 365 */     for (int i = str.length(); i < 8; i++) {
/* 366 */       paramStringBuilder.append('0');
/*     */     }
/* 368 */     paramStringBuilder.append(str);
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
/*     */   public static String toString(long paramLong) {
/* 383 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 385 */     appendHexString(stringBuilder, paramLong >>> 32L & 0xFFFFFFFFL);
/*     */ 
/*     */     
/* 388 */     stringBuilder.append('.');
/* 389 */     appendHexString(stringBuilder, paramLong & 0xFFFFFFFFL);
/*     */     
/* 391 */     return stringBuilder.toString();
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
/*     */   public String toDateString() {
/* 405 */     if (this.simpleFormatter == null) {
/* 406 */       this.simpleFormatter = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss.SSS", Locale.US);
/* 407 */       this.simpleFormatter.setTimeZone(TimeZone.getDefault());
/*     */     } 
/* 409 */     Date date = getDate();
/* 410 */     return this.simpleFormatter.format(date);
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
/*     */   public String toUTCString() {
/* 424 */     if (this.utcFormatter == null) {
/* 425 */       this.utcFormatter = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss.SSS 'UTC'", Locale.US);
/*     */       
/* 427 */       this.utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
/*     */     } 
/* 429 */     Date date = getDate();
/* 430 */     return this.utcFormatter.format(date);
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
/*     */   public int compareTo(TimeStamp paramTimeStamp) {
/* 447 */     long l1 = this.ntpTime;
/* 448 */     long l2 = paramTimeStamp.ntpTime;
/* 449 */     return (l1 < l2) ? -1 : ((l1 == l2) ? 0 : 1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ntp\TimeStamp.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */