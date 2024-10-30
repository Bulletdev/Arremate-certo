/*     */ package ch.qos.logback.classic.pattern;
/*     */ 
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import ch.qos.logback.classic.util.LevelToSyslogSeverity;
/*     */ import ch.qos.logback.core.net.SyslogAppenderBase;
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SyslogStartConverter
/*     */   extends ClassicConverter
/*     */ {
/*  29 */   long lastTimestamp = -1L;
/*  30 */   String timesmapStr = null;
/*     */   SimpleDateFormat simpleMonthFormat;
/*     */   SimpleDateFormat simpleTimeFormat;
/*  33 */   private final Calendar calendar = Calendar.getInstance(Locale.US);
/*     */   
/*     */   String localHostName;
/*     */   int facility;
/*     */   
/*     */   public void start() {
/*  39 */     byte b = 0;
/*     */     
/*  41 */     String str = getFirstOption();
/*  42 */     if (str == null) {
/*  43 */       addError("was expecting a facility string as an option");
/*     */       
/*     */       return;
/*     */     } 
/*  47 */     this.facility = SyslogAppenderBase.facilityStringToint(str);
/*     */     
/*  49 */     this.localHostName = getLocalHostname();
/*     */     
/*     */     try {
/*  52 */       this.simpleMonthFormat = new SimpleDateFormat("MMM", Locale.US);
/*  53 */       this.simpleTimeFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
/*  54 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  55 */       addError("Could not instantiate SimpleDateFormat", illegalArgumentException);
/*  56 */       b++;
/*     */     } 
/*     */     
/*  59 */     if (b == 0) {
/*  60 */       super.start();
/*     */     }
/*     */   }
/*     */   
/*     */   public String convert(ILoggingEvent paramILoggingEvent) {
/*  65 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  67 */     int i = this.facility + LevelToSyslogSeverity.convert(paramILoggingEvent);
/*     */     
/*  69 */     stringBuilder.append("<");
/*  70 */     stringBuilder.append(i);
/*  71 */     stringBuilder.append(">");
/*  72 */     stringBuilder.append(computeTimeStampString(paramILoggingEvent.getTimeStamp()));
/*  73 */     stringBuilder.append(' ');
/*  74 */     stringBuilder.append(this.localHostName);
/*  75 */     stringBuilder.append(' ');
/*     */     
/*  77 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocalHostname() {
/*     */     try {
/*  88 */       InetAddress inetAddress = InetAddress.getLocalHost();
/*  89 */       return inetAddress.getHostName();
/*  90 */     } catch (UnknownHostException unknownHostException) {
/*  91 */       addError("Could not determine local host name", unknownHostException);
/*  92 */       return "UNKNOWN_LOCALHOST";
/*     */     } 
/*     */   }
/*     */   
/*     */   String computeTimeStampString(long paramLong) {
/*  97 */     synchronized (this) {
/*     */ 
/*     */ 
/*     */       
/* 101 */       if (paramLong / 1000L != this.lastTimestamp) {
/* 102 */         this.lastTimestamp = paramLong / 1000L;
/* 103 */         Date date = new Date(paramLong);
/* 104 */         this.calendar.setTime(date);
/* 105 */         this.timesmapStr = String.format("%s %2d %s", new Object[] { this.simpleMonthFormat.format(date), Integer.valueOf(this.calendar.get(5)), this.simpleTimeFormat
/* 106 */               .format(date) });
/*     */       } 
/* 108 */       return this.timesmapStr;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\SyslogStartConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */