/*     */ package oshi.driver.unix;
/*     */ 
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.Year;
/*     */ import java.time.ZoneId;
/*     */ import java.time.format.DateTimeFormatter;
/*     */ import java.time.format.DateTimeFormatterBuilder;
/*     */ import java.time.format.DateTimeParseException;
/*     */ import java.time.temporal.ChronoField;
/*     */ import java.time.temporal.ChronoUnit;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.os.OSSession;
/*     */ import oshi.util.ExecutingCommand;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class Who
/*     */ {
/*  54 */   private static final Pattern WHO_FORMAT_LINUX = Pattern.compile("(\\S+)\\s+(\\S+)\\s+(\\d{4}-\\d{2}-\\d{2})\\s+(\\d{2}:\\d{2})\\s*(?:\\((.+)\\))?");
/*  55 */   private static final DateTimeFormatter WHO_DATE_FORMAT_LINUX = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
/*     */ 
/*     */ 
/*     */   
/*  59 */   private static final Pattern WHO_FORMAT_UNIX = Pattern.compile("(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\d+)\\s+(\\d{2}:\\d{2})\\s*(?:\\((.+)\\))?");
/*  60 */   private static final DateTimeFormatter WHO_DATE_FORMAT_UNIX = (new DateTimeFormatterBuilder())
/*  61 */     .appendPattern("MMM d HH:mm").parseDefaulting(ChronoField.YEAR, Year.now().getValue())
/*  62 */     .toFormatter(Locale.US);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized List<OSSession> queryWho() {
/*  73 */     ArrayList<OSSession> arrayList = new ArrayList();
/*  74 */     boolean bool = false;
/*  75 */     for (String str : ExecutingCommand.runNative("who")) {
/*  76 */       if (bool || !matchLinux(arrayList, str)) {
/*  77 */         bool = matchUnix(arrayList, str);
/*     */       }
/*     */     } 
/*  80 */     return arrayList;
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
/*     */   private static boolean matchLinux(List<OSSession> paramList, String paramString) {
/*  93 */     Matcher matcher = WHO_FORMAT_LINUX.matcher(paramString);
/*  94 */     if (matcher.matches()) {
/*     */       try {
/*  96 */         paramList.add(new OSSession(matcher.group(1), matcher.group(2), 
/*  97 */               LocalDateTime.parse(matcher.group(3) + " " + matcher.group(4), WHO_DATE_FORMAT_LINUX)
/*  98 */               .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), 
/*  99 */               (matcher.group(5) == null) ? "unknown" : matcher.group(5)));
/* 100 */         return true;
/* 101 */       } catch (DateTimeParseException|NullPointerException dateTimeParseException) {}
/*     */     }
/*     */ 
/*     */     
/* 105 */     return false;
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
/*     */   private static boolean matchUnix(List<OSSession> paramList, String paramString) {
/* 118 */     Matcher matcher = WHO_FORMAT_UNIX.matcher(paramString);
/* 119 */     if (matcher.matches()) {
/*     */       
/*     */       try {
/* 122 */         LocalDateTime localDateTime = LocalDateTime.parse(matcher.group(3) + " " + matcher.group(4) + " " + matcher.group(5), WHO_DATE_FORMAT_UNIX);
/*     */ 
/*     */         
/* 125 */         if (localDateTime.isAfter(LocalDateTime.now())) {
/* 126 */           localDateTime = localDateTime.minus(1L, ChronoUnit.YEARS);
/*     */         }
/* 128 */         long l = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
/* 129 */         paramList.add(new OSSession(matcher.group(1), matcher.group(2), l, (matcher.group(6) == null) ? "" : matcher.group(6)));
/* 130 */         return true;
/* 131 */       } catch (DateTimeParseException|NullPointerException dateTimeParseException) {}
/*     */     }
/*     */ 
/*     */     
/* 135 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\Who.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */