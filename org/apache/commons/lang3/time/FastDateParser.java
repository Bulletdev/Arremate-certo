/*     */ package org.apache.commons.lang3.time;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.Serializable;
/*     */ import java.text.DateFormatSymbols;
/*     */ import java.text.ParseException;
/*     */ import java.text.ParsePosition;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.TimeZone;
/*     */ import java.util.TreeSet;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FastDateParser
/*     */   implements Serializable, DateParser
/*     */ {
/*     */   private static final long serialVersionUID = 3L;
/*  82 */   static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
/*     */ 
/*     */   
/*     */   private final String pattern;
/*     */   
/*     */   private final TimeZone timeZone;
/*     */   
/*     */   private final Locale locale;
/*     */   
/*     */   private final int century;
/*     */   
/*     */   private final int startYear;
/*     */   
/*     */   private transient List<StrategyAndWidth> patterns;
/*     */   
/*  97 */   private static final Comparator<String> LONGER_FIRST_LOWERCASE = Comparator.reverseOrder();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FastDateParser(String paramString, TimeZone paramTimeZone, Locale paramLocale) {
/* 111 */     this(paramString, paramTimeZone, paramLocale, null);
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
/*     */   protected FastDateParser(String paramString, TimeZone paramTimeZone, Locale paramLocale, Date paramDate) {
/*     */     int i;
/* 126 */     this.pattern = paramString;
/* 127 */     this.timeZone = paramTimeZone;
/* 128 */     this.locale = paramLocale;
/*     */     
/* 130 */     Calendar calendar = Calendar.getInstance(paramTimeZone, paramLocale);
/*     */ 
/*     */     
/* 133 */     if (paramDate != null) {
/* 134 */       calendar.setTime(paramDate);
/* 135 */       i = calendar.get(1);
/* 136 */     } else if (paramLocale.equals(JAPANESE_IMPERIAL)) {
/* 137 */       i = 0;
/*     */     } else {
/*     */       
/* 140 */       calendar.setTime(new Date());
/* 141 */       i = calendar.get(1) - 80;
/*     */     } 
/* 143 */     this.century = i / 100 * 100;
/* 144 */     this.startYear = i - this.century;
/*     */     
/* 146 */     init(calendar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void init(Calendar paramCalendar) {
/* 156 */     this.patterns = new ArrayList<>();
/*     */     
/* 158 */     StrategyParser strategyParser = new StrategyParser(paramCalendar);
/*     */     while (true) {
/* 160 */       StrategyAndWidth strategyAndWidth = strategyParser.getNextStrategy();
/* 161 */       if (strategyAndWidth == null) {
/*     */         break;
/*     */       }
/* 164 */       this.patterns.add(strategyAndWidth);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class StrategyAndWidth
/*     */   {
/*     */     final FastDateParser.Strategy strategy;
/*     */ 
/*     */     
/*     */     final int width;
/*     */ 
/*     */     
/*     */     StrategyAndWidth(FastDateParser.Strategy param1Strategy, int param1Int) {
/* 179 */       this.strategy = param1Strategy;
/* 180 */       this.width = param1Int;
/*     */     }
/*     */     
/*     */     int getMaxWidth(ListIterator<StrategyAndWidth> param1ListIterator) {
/* 184 */       if (!this.strategy.isNumber() || !param1ListIterator.hasNext()) {
/* 185 */         return 0;
/*     */       }
/* 187 */       FastDateParser.Strategy strategy = ((StrategyAndWidth)param1ListIterator.next()).strategy;
/* 188 */       param1ListIterator.previous();
/* 189 */       return strategy.isNumber() ? this.width : 0;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class StrategyParser
/*     */   {
/*     */     private final Calendar definingCalendar;
/*     */     
/*     */     private int currentIdx;
/*     */     
/*     */     StrategyParser(Calendar param1Calendar) {
/* 201 */       this.definingCalendar = param1Calendar;
/*     */     }
/*     */     
/*     */     FastDateParser.StrategyAndWidth getNextStrategy() {
/* 205 */       if (this.currentIdx >= FastDateParser.this.pattern.length()) {
/* 206 */         return null;
/*     */       }
/*     */       
/* 209 */       char c = FastDateParser.this.pattern.charAt(this.currentIdx);
/* 210 */       if (FastDateParser.isFormatLetter(c)) {
/* 211 */         return letterPattern(c);
/*     */       }
/* 213 */       return literal();
/*     */     }
/*     */     
/*     */     private FastDateParser.StrategyAndWidth letterPattern(char param1Char) {
/* 217 */       int i = this.currentIdx; do {  }
/* 218 */       while (++this.currentIdx < FastDateParser.this.pattern.length() && 
/* 219 */         FastDateParser.this.pattern.charAt(this.currentIdx) == param1Char);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 224 */       int j = this.currentIdx - i;
/* 225 */       return new FastDateParser.StrategyAndWidth(FastDateParser.this.getStrategy(param1Char, j, this.definingCalendar), j);
/*     */     }
/*     */     
/*     */     private FastDateParser.StrategyAndWidth literal() {
/* 229 */       boolean bool = false;
/*     */       
/* 231 */       StringBuilder stringBuilder = new StringBuilder();
/* 232 */       while (this.currentIdx < FastDateParser.this.pattern.length()) {
/* 233 */         char c = FastDateParser.this.pattern.charAt(this.currentIdx);
/* 234 */         if (!bool && FastDateParser.isFormatLetter(c))
/*     */           break; 
/* 236 */         if (c == '\'' && (++this.currentIdx == FastDateParser.this.pattern.length() || FastDateParser.this.pattern.charAt(this.currentIdx) != '\'')) {
/* 237 */           bool = !bool ? true : false;
/*     */           continue;
/*     */         } 
/* 240 */         this.currentIdx++;
/* 241 */         stringBuilder.append(c);
/*     */       } 
/*     */       
/* 244 */       if (bool) {
/* 245 */         throw new IllegalArgumentException("Unterminated quote");
/*     */       }
/*     */       
/* 248 */       String str = stringBuilder.toString();
/* 249 */       return new FastDateParser.StrategyAndWidth(new FastDateParser.CopyQuotedStrategy(str), str.length());
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean isFormatLetter(char paramChar) {
/* 254 */     return ((paramChar >= 'A' && paramChar <= 'Z') || (paramChar >= 'a' && paramChar <= 'z'));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPattern() {
/* 264 */     return this.pattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimeZone getTimeZone() {
/* 272 */     return this.timeZone;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Locale getLocale() {
/* 280 */     return this.locale;
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
/*     */   public boolean equals(Object paramObject) {
/* 294 */     if (!(paramObject instanceof FastDateParser)) {
/* 295 */       return false;
/*     */     }
/* 297 */     FastDateParser fastDateParser = (FastDateParser)paramObject;
/* 298 */     return (this.pattern.equals(fastDateParser.pattern) && this.timeZone
/* 299 */       .equals(fastDateParser.timeZone) && this.locale
/* 300 */       .equals(fastDateParser.locale));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 310 */     return this.pattern.hashCode() + 13 * (this.timeZone.hashCode() + 13 * this.locale.hashCode());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 320 */     return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
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
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 334 */     paramObjectInputStream.defaultReadObject();
/*     */     
/* 336 */     Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
/* 337 */     init(calendar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object parseObject(String paramString) throws ParseException {
/* 345 */     return parse(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date parse(String paramString) throws ParseException {
/* 353 */     ParsePosition parsePosition = new ParsePosition(0);
/* 354 */     Date date = parse(paramString, parsePosition);
/* 355 */     if (date == null) {
/*     */       
/* 357 */       if (this.locale.equals(JAPANESE_IMPERIAL)) {
/* 358 */         throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + paramString, parsePosition
/*     */             
/* 360 */             .getErrorIndex());
/*     */       }
/* 362 */       throw new ParseException("Unparseable date: " + paramString, parsePosition.getErrorIndex());
/*     */     } 
/* 364 */     return date;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object parseObject(String paramString, ParsePosition paramParsePosition) {
/* 372 */     return parse(paramString, paramParsePosition);
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
/*     */   public Date parse(String paramString, ParsePosition paramParsePosition) {
/* 390 */     Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
/* 391 */     calendar.clear();
/*     */     
/* 393 */     return parse(paramString, paramParsePosition, calendar) ? calendar.getTime() : null;
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
/*     */   public boolean parse(String paramString, ParsePosition paramParsePosition, Calendar paramCalendar) {
/* 411 */     ListIterator<StrategyAndWidth> listIterator = this.patterns.listIterator();
/* 412 */     while (listIterator.hasNext()) {
/* 413 */       StrategyAndWidth strategyAndWidth = listIterator.next();
/* 414 */       int i = strategyAndWidth.getMaxWidth(listIterator);
/* 415 */       if (!strategyAndWidth.strategy.parse(this, paramCalendar, paramString, paramParsePosition, i)) {
/* 416 */         return false;
/*     */       }
/*     */     } 
/* 419 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static StringBuilder simpleQuote(StringBuilder paramStringBuilder, String paramString) {
/* 426 */     for (byte b = 0; b < paramString.length(); b++) {
/* 427 */       char c = paramString.charAt(b);
/* 428 */       switch (c) {
/*     */         case '$':
/*     */         case '(':
/*     */         case ')':
/*     */         case '*':
/*     */         case '+':
/*     */         case '.':
/*     */         case '?':
/*     */         case '[':
/*     */         case '\\':
/*     */         case '^':
/*     */         case '{':
/*     */         case '|':
/* 441 */           paramStringBuilder.append('\\'); break;
/*     */       } 
/* 443 */       paramStringBuilder.append(c);
/*     */     } 
/*     */     
/* 446 */     if (paramStringBuilder.charAt(paramStringBuilder.length() - 1) == '.')
/*     */     {
/* 448 */       paramStringBuilder.append('?');
/*     */     }
/* 450 */     return paramStringBuilder;
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
/*     */   private static Map<String, Integer> appendDisplayNames(Calendar paramCalendar, Locale paramLocale, int paramInt, StringBuilder paramStringBuilder) {
/* 462 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 464 */     Map<String, Integer> map = paramCalendar.getDisplayNames(paramInt, 0, paramLocale);
/* 465 */     TreeSet<String> treeSet = new TreeSet<>(LONGER_FIRST_LOWERCASE);
/* 466 */     for (Map.Entry<String, Integer> entry : map.entrySet()) {
/* 467 */       String str = ((String)entry.getKey()).toLowerCase(paramLocale);
/* 468 */       if (treeSet.add(str)) {
/* 469 */         hashMap.put(str, entry.getValue());
/*     */       }
/*     */     } 
/* 472 */     for (String str : treeSet) {
/* 473 */       simpleQuote(paramStringBuilder, str).append('|');
/*     */     }
/* 475 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int adjustYear(int paramInt) {
/* 484 */     int i = this.century + paramInt;
/* 485 */     return (paramInt >= this.startYear) ? i : (i + 100);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static abstract class Strategy
/*     */   {
/*     */     private Strategy() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isNumber() {
/* 499 */       return false;
/*     */     }
/*     */     
/*     */     abstract boolean parse(FastDateParser param1FastDateParser, Calendar param1Calendar, String param1String, ParsePosition param1ParsePosition, int param1Int);
/*     */   }
/*     */   
/*     */   private static abstract class PatternStrategy
/*     */     extends Strategy
/*     */   {
/*     */     private Pattern pattern;
/*     */     
/*     */     private PatternStrategy() {}
/*     */     
/*     */     void createPattern(StringBuilder param1StringBuilder) {
/* 513 */       createPattern(param1StringBuilder.toString());
/*     */     }
/*     */     
/*     */     void createPattern(String param1String) {
/* 517 */       this.pattern = Pattern.compile(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isNumber() {
/* 528 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean parse(FastDateParser param1FastDateParser, Calendar param1Calendar, String param1String, ParsePosition param1ParsePosition, int param1Int) {
/* 533 */       Matcher matcher = this.pattern.matcher(param1String.substring(param1ParsePosition.getIndex()));
/* 534 */       if (!matcher.lookingAt()) {
/* 535 */         param1ParsePosition.setErrorIndex(param1ParsePosition.getIndex());
/* 536 */         return false;
/*     */       } 
/* 538 */       param1ParsePosition.setIndex(param1ParsePosition.getIndex() + matcher.end(1));
/* 539 */       setCalendar(param1FastDateParser, param1Calendar, matcher.group(1));
/* 540 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract void setCalendar(FastDateParser param1FastDateParser, Calendar param1Calendar, String param1String);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Strategy getStrategy(char paramChar, int paramInt, Calendar paramCalendar) {
/* 553 */     switch (paramChar) {
/*     */       default:
/* 555 */         throw new IllegalArgumentException("Format '" + paramChar + "' not supported");
/*     */       case 'D':
/* 557 */         return DAY_OF_YEAR_STRATEGY;
/*     */       case 'E':
/* 559 */         return getLocaleSpecificStrategy(7, paramCalendar);
/*     */       case 'F':
/* 561 */         return DAY_OF_WEEK_IN_MONTH_STRATEGY;
/*     */       case 'G':
/* 563 */         return getLocaleSpecificStrategy(0, paramCalendar);
/*     */       case 'H':
/* 565 */         return HOUR_OF_DAY_STRATEGY;
/*     */       case 'K':
/* 567 */         return HOUR_STRATEGY;
/*     */       case 'M':
/* 569 */         return (paramInt >= 3) ? getLocaleSpecificStrategy(2, paramCalendar) : NUMBER_MONTH_STRATEGY;
/*     */       case 'S':
/* 571 */         return MILLISECOND_STRATEGY;
/*     */       case 'W':
/* 573 */         return WEEK_OF_MONTH_STRATEGY;
/*     */       case 'a':
/* 575 */         return getLocaleSpecificStrategy(9, paramCalendar);
/*     */       case 'd':
/* 577 */         return DAY_OF_MONTH_STRATEGY;
/*     */       case 'h':
/* 579 */         return HOUR12_STRATEGY;
/*     */       case 'k':
/* 581 */         return HOUR24_OF_DAY_STRATEGY;
/*     */       case 'm':
/* 583 */         return MINUTE_STRATEGY;
/*     */       case 's':
/* 585 */         return SECOND_STRATEGY;
/*     */       case 'u':
/* 587 */         return DAY_OF_WEEK_STRATEGY;
/*     */       case 'w':
/* 589 */         return WEEK_OF_YEAR_STRATEGY;
/*     */       case 'Y':
/*     */       case 'y':
/* 592 */         return (paramInt > 2) ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY;
/*     */       case 'X':
/* 594 */         return ISO8601TimeZoneStrategy.getStrategy(paramInt);
/*     */       case 'Z':
/* 596 */         if (paramInt == 2)
/* 597 */           return ISO8601TimeZoneStrategy.ISO_8601_3_STRATEGY;  break;
/*     */       case 'z':
/*     */         break;
/*     */     } 
/* 601 */     return getLocaleSpecificStrategy(15, paramCalendar);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 606 */   private static final ConcurrentMap<Locale, Strategy>[] caches = (ConcurrentMap<Locale, Strategy>[])new ConcurrentMap[17];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ConcurrentMap<Locale, Strategy> getCache(int paramInt) {
/* 614 */     synchronized (caches) {
/* 615 */       if (caches[paramInt] == null) {
/* 616 */         caches[paramInt] = new ConcurrentHashMap<>(3);
/*     */       }
/* 618 */       return caches[paramInt];
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Strategy getLocaleSpecificStrategy(int paramInt, Calendar paramCalendar) {
/* 629 */     ConcurrentMap<Locale, Strategy> concurrentMap = getCache(paramInt);
/* 630 */     Strategy strategy = concurrentMap.get(this.locale);
/* 631 */     if (strategy == null) {
/* 632 */       strategy = (paramInt == 15) ? new TimeZoneStrategy(this.locale) : new CaseInsensitiveTextStrategy(paramInt, paramCalendar, this.locale);
/*     */ 
/*     */       
/* 635 */       Strategy strategy1 = concurrentMap.putIfAbsent(this.locale, strategy);
/* 636 */       if (strategy1 != null) {
/* 637 */         return strategy1;
/*     */       }
/*     */     } 
/* 640 */     return strategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class CopyQuotedStrategy
/*     */     extends Strategy
/*     */   {
/*     */     private final String formatField;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     CopyQuotedStrategy(String param1String) {
/* 655 */       this.formatField = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isNumber() {
/* 663 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean parse(FastDateParser param1FastDateParser, Calendar param1Calendar, String param1String, ParsePosition param1ParsePosition, int param1Int) {
/* 668 */       for (byte b = 0; b < this.formatField.length(); b++) {
/* 669 */         int i = b + param1ParsePosition.getIndex();
/* 670 */         if (i == param1String.length()) {
/* 671 */           param1ParsePosition.setErrorIndex(i);
/* 672 */           return false;
/*     */         } 
/* 674 */         if (this.formatField.charAt(b) != param1String.charAt(i)) {
/* 675 */           param1ParsePosition.setErrorIndex(i);
/* 676 */           return false;
/*     */         } 
/*     */       } 
/* 679 */       param1ParsePosition.setIndex(this.formatField.length() + param1ParsePosition.getIndex());
/* 680 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class CaseInsensitiveTextStrategy
/*     */     extends PatternStrategy
/*     */   {
/*     */     private final int field;
/*     */ 
/*     */     
/*     */     final Locale locale;
/*     */ 
/*     */     
/*     */     private final Map<String, Integer> lKeyValues;
/*     */ 
/*     */     
/*     */     CaseInsensitiveTextStrategy(int param1Int, Calendar param1Calendar, Locale param1Locale) {
/* 699 */       this.field = param1Int;
/* 700 */       this.locale = param1Locale;
/*     */       
/* 702 */       StringBuilder stringBuilder = new StringBuilder();
/* 703 */       stringBuilder.append("((?iu)");
/* 704 */       this.lKeyValues = FastDateParser.appendDisplayNames(param1Calendar, param1Locale, param1Int, stringBuilder);
/* 705 */       stringBuilder.setLength(stringBuilder.length() - 1);
/* 706 */       stringBuilder.append(")");
/* 707 */       createPattern(stringBuilder);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setCalendar(FastDateParser param1FastDateParser, Calendar param1Calendar, String param1String) {
/* 715 */       String str = param1String.toLowerCase(this.locale);
/* 716 */       Integer integer = this.lKeyValues.get(str);
/* 717 */       if (integer == null)
/*     */       {
/* 719 */         integer = this.lKeyValues.get(str + '.');
/*     */       }
/* 721 */       param1Calendar.set(this.field, integer.intValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class NumberStrategy
/*     */     extends Strategy
/*     */   {
/*     */     private final int field;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NumberStrategy(int param1Int) {
/* 737 */       this.field = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isNumber() {
/* 745 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean parse(FastDateParser param1FastDateParser, Calendar param1Calendar, String param1String, ParsePosition param1ParsePosition, int param1Int) {
/* 750 */       int i = param1ParsePosition.getIndex();
/* 751 */       int j = param1String.length();
/*     */       
/* 753 */       if (param1Int == 0) {
/*     */         
/* 755 */         for (; i < j; i++) {
/* 756 */           char c = param1String.charAt(i);
/* 757 */           if (!Character.isWhitespace(c)) {
/*     */             break;
/*     */           }
/*     */         } 
/* 761 */         param1ParsePosition.setIndex(i);
/*     */       } else {
/* 763 */         int m = i + param1Int;
/* 764 */         if (j > m) {
/* 765 */           j = m;
/*     */         }
/*     */       } 
/*     */       
/* 769 */       for (; i < j; i++) {
/* 770 */         char c = param1String.charAt(i);
/* 771 */         if (!Character.isDigit(c)) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */       
/* 776 */       if (param1ParsePosition.getIndex() == i) {
/* 777 */         param1ParsePosition.setErrorIndex(i);
/* 778 */         return false;
/*     */       } 
/*     */       
/* 781 */       int k = Integer.parseInt(param1String.substring(param1ParsePosition.getIndex(), i));
/* 782 */       param1ParsePosition.setIndex(i);
/*     */       
/* 784 */       param1Calendar.set(this.field, modify(param1FastDateParser, k));
/* 785 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int modify(FastDateParser param1FastDateParser, int param1Int) {
/* 795 */       return param1Int;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 800 */   private static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1)
/*     */     {
/*     */ 
/*     */       
/*     */       int modify(FastDateParser param1FastDateParser, int param1Int)
/*     */       {
/* 806 */         return (param1Int < 100) ? param1FastDateParser.adjustYear(param1Int) : param1Int;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   static class TimeZoneStrategy
/*     */     extends PatternStrategy
/*     */   {
/*     */     private static final String RFC_822_TIME_ZONE = "[+-]\\d{4}";
/*     */     
/*     */     private static final String GMT_OPTION = "GMT[+-]\\d{1,2}:\\d{2}";
/*     */     private final Locale locale;
/* 818 */     private final Map<String, TzInfo> tzNames = new HashMap<>();
/*     */     private static final int ID = 0;
/*     */     
/*     */     private static class TzInfo { TimeZone zone;
/*     */       int dstOffset;
/*     */       
/*     */       TzInfo(TimeZone param2TimeZone, boolean param2Boolean) {
/* 825 */         this.zone = param2TimeZone;
/* 826 */         this.dstOffset = param2Boolean ? param2TimeZone.getDSTSavings() : 0;
/*     */       } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TimeZoneStrategy(Locale param1Locale) {
/* 840 */       this.locale = param1Locale;
/*     */       
/* 842 */       StringBuilder stringBuilder = new StringBuilder();
/* 843 */       stringBuilder.append("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
/*     */       
/* 845 */       TreeSet<String> treeSet = new TreeSet(FastDateParser.LONGER_FIRST_LOWERCASE);
/*     */       
/* 847 */       String[][] arrayOfString = DateFormatSymbols.getInstance(param1Locale).getZoneStrings();
/* 848 */       for (String[] arrayOfString1 : arrayOfString) {
/*     */         
/* 850 */         String str = arrayOfString1[0];
/* 851 */         if (!str.equalsIgnoreCase("GMT")) {
/*     */ 
/*     */           
/* 854 */           TimeZone timeZone = TimeZone.getTimeZone(str);
/*     */ 
/*     */           
/* 857 */           TzInfo tzInfo1 = new TzInfo(timeZone, false);
/* 858 */           TzInfo tzInfo2 = tzInfo1;
/* 859 */           for (byte b = 1; b < arrayOfString1.length; b++) {
/* 860 */             switch (b) {
/*     */               
/*     */               case 3:
/* 863 */                 tzInfo2 = new TzInfo(timeZone, true);
/*     */                 break;
/*     */               case 5:
/* 866 */                 tzInfo2 = tzInfo1;
/*     */                 break;
/*     */             } 
/*     */ 
/*     */             
/* 871 */             if (arrayOfString1[b] != null) {
/* 872 */               String str1 = arrayOfString1[b].toLowerCase(param1Locale);
/*     */ 
/*     */               
/* 875 */               if (treeSet.add(str1)) {
/* 876 */                 this.tzNames.put(str1, tzInfo2);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 883 */       for (String str : treeSet) {
/* 884 */         FastDateParser.simpleQuote(stringBuilder.append('|'), str);
/*     */       }
/* 886 */       stringBuilder.append(")");
/* 887 */       createPattern(stringBuilder);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setCalendar(FastDateParser param1FastDateParser, Calendar param1Calendar, String param1String) {
/* 895 */       TimeZone timeZone = FastTimeZone.getGmtTimeZone(param1String);
/* 896 */       if (timeZone != null) {
/* 897 */         param1Calendar.setTimeZone(timeZone);
/*     */       } else {
/* 899 */         String str = param1String.toLowerCase(this.locale);
/* 900 */         TzInfo tzInfo = this.tzNames.get(str);
/* 901 */         if (tzInfo == null)
/*     */         {
/* 903 */           tzInfo = this.tzNames.get(str + '.');
/*     */         }
/* 905 */         param1Calendar.set(16, tzInfo.dstOffset);
/* 906 */         param1Calendar.set(15, tzInfo.zone.getRawOffset());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class ISO8601TimeZoneStrategy
/*     */     extends PatternStrategy
/*     */   {
/*     */     ISO8601TimeZoneStrategy(String param1String) {
/* 919 */       createPattern(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setCalendar(FastDateParser param1FastDateParser, Calendar param1Calendar, String param1String) {
/* 927 */       param1Calendar.setTimeZone(FastTimeZone.getGmtTimeZone(param1String));
/*     */     }
/*     */     
/* 930 */     private static final FastDateParser.Strategy ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
/* 931 */     private static final FastDateParser.Strategy ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
/* 932 */     private static final FastDateParser.Strategy ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static FastDateParser.Strategy getStrategy(int param1Int) {
/* 942 */       switch (param1Int) {
/*     */         case 1:
/* 944 */           return ISO_8601_1_STRATEGY;
/*     */         case 2:
/* 946 */           return ISO_8601_2_STRATEGY;
/*     */         case 3:
/* 948 */           return ISO_8601_3_STRATEGY;
/*     */       } 
/* 950 */       throw new IllegalArgumentException("invalid number of X");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 955 */   private static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2)
/*     */     {
/*     */       int modify(FastDateParser param1FastDateParser, int param1Int) {
/* 958 */         return param1Int - 1;
/*     */       }
/*     */     };
/*     */   
/* 962 */   private static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
/* 963 */   private static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
/* 964 */   private static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
/* 965 */   private static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
/* 966 */   private static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
/* 967 */   private static final Strategy DAY_OF_WEEK_STRATEGY = new NumberStrategy(7)
/*     */     {
/*     */       int modify(FastDateParser param1FastDateParser, int param1Int) {
/* 970 */         return (param1Int == 7) ? 1 : (param1Int + 1);
/*     */       }
/*     */     };
/*     */   
/* 974 */   private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
/* 975 */   private static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
/* 976 */   private static final Strategy HOUR24_OF_DAY_STRATEGY = new NumberStrategy(11)
/*     */     {
/*     */       int modify(FastDateParser param1FastDateParser, int param1Int) {
/* 979 */         return (param1Int == 24) ? 0 : param1Int;
/*     */       }
/*     */     };
/*     */   
/* 983 */   private static final Strategy HOUR12_STRATEGY = new NumberStrategy(10)
/*     */     {
/*     */       int modify(FastDateParser param1FastDateParser, int param1Int) {
/* 986 */         return (param1Int == 12) ? 0 : param1Int;
/*     */       }
/*     */     };
/*     */   
/* 990 */   private static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
/* 991 */   private static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
/* 992 */   private static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
/* 993 */   private static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\time\FastDateParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */