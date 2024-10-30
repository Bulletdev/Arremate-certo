/*     */ package ch.qos.logback.core.util;
/*     */ 
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Duration
/*     */ {
/*     */   private static final String DOUBLE_PART = "([0-9]*(.[0-9]+)?)";
/*     */   private static final int DOUBLE_GROUP = 1;
/*     */   private static final String UNIT_PART = "(|milli(second)?|second(e)?|minute|hour|day)s?";
/*     */   private static final int UNIT_GROUP = 3;
/*  42 */   private static final Pattern DURATION_PATTERN = Pattern.compile("([0-9]*(.[0-9]+)?)\\s*(|milli(second)?|second(e)?|minute|hour|day)s?", 2);
/*     */   
/*     */   static final long SECONDS_COEFFICIENT = 1000L;
/*     */   
/*     */   static final long MINUTES_COEFFICIENT = 60000L;
/*     */   static final long HOURS_COEFFICIENT = 3600000L;
/*     */   static final long DAYS_COEFFICIENT = 86400000L;
/*     */   final long millis;
/*     */   
/*     */   public Duration(long paramLong) {
/*  52 */     this.millis = paramLong;
/*     */   }
/*     */   
/*     */   public static Duration buildByMilliseconds(double paramDouble) {
/*  56 */     return new Duration((long)paramDouble);
/*     */   }
/*     */   
/*     */   public static Duration buildBySeconds(double paramDouble) {
/*  60 */     return new Duration((long)(1000.0D * paramDouble));
/*     */   }
/*     */   
/*     */   public static Duration buildByMinutes(double paramDouble) {
/*  64 */     return new Duration((long)(60000.0D * paramDouble));
/*     */   }
/*     */   
/*     */   public static Duration buildByHours(double paramDouble) {
/*  68 */     return new Duration((long)(3600000.0D * paramDouble));
/*     */   }
/*     */   
/*     */   public static Duration buildByDays(double paramDouble) {
/*  72 */     return new Duration((long)(8.64E7D * paramDouble));
/*     */   }
/*     */   
/*     */   public static Duration buildUnbounded() {
/*  76 */     return new Duration(Long.MAX_VALUE);
/*     */   }
/*     */   
/*     */   public long getMilliseconds() {
/*  80 */     return this.millis;
/*     */   }
/*     */   
/*     */   public static Duration valueOf(String paramString) {
/*  84 */     Matcher matcher = DURATION_PATTERN.matcher(paramString);
/*     */     
/*  86 */     if (matcher.matches()) {
/*  87 */       String str1 = matcher.group(1);
/*  88 */       String str2 = matcher.group(3);
/*     */       
/*  90 */       double d = Double.valueOf(str1).doubleValue();
/*  91 */       if (str2.equalsIgnoreCase("milli") || str2.equalsIgnoreCase("millisecond") || str2.length() == 0)
/*  92 */         return buildByMilliseconds(d); 
/*  93 */       if (str2.equalsIgnoreCase("second") || str2.equalsIgnoreCase("seconde"))
/*  94 */         return buildBySeconds(d); 
/*  95 */       if (str2.equalsIgnoreCase("minute"))
/*  96 */         return buildByMinutes(d); 
/*  97 */       if (str2.equalsIgnoreCase("hour"))
/*  98 */         return buildByHours(d); 
/*  99 */       if (str2.equalsIgnoreCase("day")) {
/* 100 */         return buildByDays(d);
/*     */       }
/* 102 */       throw new IllegalStateException("Unexpected " + str2);
/*     */     } 
/*     */     
/* 105 */     throw new IllegalArgumentException("String value [" + paramString + "] is not in the expected format.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 111 */     if (this.millis < 1000L)
/* 112 */       return this.millis + " milliseconds"; 
/* 113 */     if (this.millis < 60000L)
/* 114 */       return (this.millis / 1000L) + " seconds"; 
/* 115 */     if (this.millis < 3600000L) {
/* 116 */       return (this.millis / 60000L) + " minutes";
/*     */     }
/* 118 */     return (this.millis / 3600000L) + " hours";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\Duration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */