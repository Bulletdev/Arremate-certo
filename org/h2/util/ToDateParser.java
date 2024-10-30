/*     */ package org.h2.util;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ToDateParser
/*     */ {
/*     */   private final String unmodifiedInputStr;
/*     */   private final String unmodifiedFormatStr;
/*     */   private final ConfigParam functionName;
/*     */   private String inputStr;
/*     */   private String formatStr;
/*  24 */   private final Calendar resultCalendar = (Calendar)Calendar.getInstance().clone();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Integer nanos;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ToDateParser(ConfigParam paramConfigParam, String paramString1, String paramString2) {
/*  35 */     this.resultCalendar.set(1, 1970);
/*  36 */     this.resultCalendar.set(2, Calendar.getInstance().get(2));
/*  37 */     this.resultCalendar.clear(6);
/*  38 */     this.resultCalendar.clear(7);
/*  39 */     this.resultCalendar.clear(8);
/*  40 */     this.resultCalendar.set(5, 1);
/*  41 */     this.resultCalendar.set(10, 0);
/*  42 */     this.resultCalendar.set(11, 0);
/*  43 */     this.resultCalendar.set(12, 0);
/*  44 */     this.resultCalendar.set(13, 0);
/*  45 */     this.resultCalendar.set(14, 0);
/*  46 */     this.resultCalendar.set(9, 0);
/*     */     
/*  48 */     this.functionName = paramConfigParam;
/*  49 */     this.inputStr = paramString1.trim();
/*     */     
/*  51 */     this.unmodifiedInputStr = this.inputStr;
/*  52 */     if (paramString2 == null || paramString2.isEmpty()) {
/*     */       
/*  54 */       this.formatStr = paramConfigParam.getDefaultFormatStr();
/*     */     } else {
/*  56 */       this.formatStr = paramString2.trim();
/*     */     } 
/*     */     
/*  59 */     this.unmodifiedFormatStr = this.formatStr;
/*     */   }
/*     */   
/*     */   private static ToDateParser getDateParser(String paramString1, String paramString2) {
/*  63 */     ToDateParser toDateParser = new ToDateParser(ConfigParam.TO_DATE, paramString1, paramString2);
/*  64 */     parse(toDateParser);
/*  65 */     return toDateParser;
/*     */   }
/*     */   
/*     */   private static ToDateParser getTimestampParser(String paramString1, String paramString2) {
/*  69 */     ToDateParser toDateParser = new ToDateParser(ConfigParam.TO_TIMESTAMP, paramString1, paramString2);
/*  70 */     parse(toDateParser);
/*  71 */     return toDateParser;
/*     */   }
/*     */   
/*     */   private Timestamp getResultingTimestamp() {
/*  75 */     Calendar calendar = (Calendar)getResultCalendar().clone();
/*  76 */     int i = (this.nanos == null) ? (calendar.get(14) * 1000000) : this.nanos.intValue();
/*     */     
/*  78 */     calendar.set(14, 0);
/*  79 */     Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
/*  80 */     timestamp.setNanos(i);
/*  81 */     return timestamp;
/*     */   }
/*     */   
/*     */   Calendar getResultCalendar() {
/*  85 */     return this.resultCalendar;
/*     */   }
/*     */   
/*     */   String getInputStr() {
/*  89 */     return this.inputStr;
/*     */   }
/*     */   
/*     */   String getFormatStr() {
/*  93 */     return this.formatStr;
/*     */   }
/*     */   
/*     */   String getFunctionName() {
/*  97 */     return this.functionName.name();
/*     */   }
/*     */   
/*     */   void setNanos(int paramInt) {
/* 101 */     this.nanos = Integer.valueOf(paramInt);
/*     */   }
/*     */   
/*     */   private boolean hasToParseData() {
/* 105 */     return (this.formatStr.length() > 0);
/*     */   }
/*     */   
/*     */   private void removeFirstChar() {
/* 109 */     if (!this.formatStr.isEmpty()) {
/* 110 */       this.formatStr = this.formatStr.substring(1);
/*     */     }
/* 112 */     if (!this.inputStr.isEmpty()) {
/* 113 */       this.inputStr = this.inputStr.substring(1);
/*     */     }
/*     */   }
/*     */   
/*     */   private static ToDateParser parse(ToDateParser paramToDateParser) {
/* 118 */     while (paramToDateParser.hasToParseData()) {
/* 119 */       List<ToDateTokenizer.FormatTokenEnum> list = ToDateTokenizer.FormatTokenEnum.getTokensInQuestion(paramToDateParser.getFormatStr());
/*     */       
/* 121 */       if (list.isEmpty()) {
/* 122 */         paramToDateParser.removeFirstChar();
/*     */         continue;
/*     */       } 
/* 125 */       boolean bool = false;
/* 126 */       for (ToDateTokenizer.FormatTokenEnum formatTokenEnum : list) {
/* 127 */         if (formatTokenEnum.parseFormatStrWithToken(paramToDateParser)) {
/* 128 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 132 */       if (!bool) {
/* 133 */         paramToDateParser.removeFirstChar();
/*     */       }
/*     */     } 
/*     */     
/* 137 */     return paramToDateParser;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void remove(String paramString1, String paramString2) {
/* 147 */     if (paramString1 != null && this.inputStr.length() >= paramString1.length()) {
/* 148 */       this.inputStr = this.inputStr.substring(paramString1.length());
/*     */     }
/* 150 */     if (paramString2 != null && this.formatStr.length() >= paramString2.length()) {
/* 151 */       this.formatStr = this.formatStr.substring(paramString2.length());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 157 */     int i = this.inputStr.length();
/* 158 */     int j = this.unmodifiedInputStr.length();
/* 159 */     int k = j - i;
/* 160 */     int m = (i <= 0) ? i : (i - 1);
/*     */     
/* 162 */     int n = this.unmodifiedFormatStr.length();
/* 163 */     int i1 = n - this.formatStr.length();
/*     */     
/* 165 */     StringBuilder stringBuilder = new StringBuilder();
/* 166 */     stringBuilder.append(String.format("\n    %s('%s', '%s')", new Object[] { this.functionName, this.unmodifiedInputStr, this.unmodifiedFormatStr }));
/*     */     
/* 168 */     stringBuilder.append(String.format("\n      %s^%s ,  %s^ <-- Parsing failed at this point", new Object[] { String.format("%" + (this.functionName.name().length() + k) + "s", new Object[] { "" }), (m <= 0) ? "" : String.format("%" + m + "s", new Object[] { "" }), (i1 <= 0) ? "" : String.format("%" + i1 + "s", new Object[] { "" }) }));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Timestamp toTimestamp(String paramString1, String paramString2) {
/* 184 */     ToDateParser toDateParser = getTimestampParser(paramString1, paramString2);
/* 185 */     return toDateParser.getResultingTimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Timestamp toDate(String paramString1, String paramString2) {
/* 196 */     ToDateParser toDateParser = getDateParser(paramString1, paramString2);
/* 197 */     return toDateParser.getResultingTimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private enum ConfigParam
/*     */   {
/* 204 */     TO_DATE("DD MON YYYY"),
/* 205 */     TO_TIMESTAMP("DD MON YYYY HH:MI:SS");
/*     */     private final String defaultFormatStr;
/*     */     
/*     */     ConfigParam(String param1String1) {
/* 209 */       this.defaultFormatStr = param1String1;
/*     */     }
/*     */     String getDefaultFormatStr() {
/* 212 */       return this.defaultFormatStr;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\ToDateParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */