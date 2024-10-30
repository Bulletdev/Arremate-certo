/*      */ package org.apache.commons.lang3.time;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.Serializable;
/*      */ import java.text.DateFormatSymbols;
/*      */ import java.text.FieldPosition;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.TimeZone;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.ConcurrentMap;
/*      */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FastDatePrinter
/*      */   implements Serializable, DatePrinter
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*      */   public static final int FULL = 0;
/*      */   public static final int LONG = 1;
/*      */   public static final int MEDIUM = 2;
/*      */   public static final int SHORT = 3;
/*      */   private final String mPattern;
/*      */   private final TimeZone mTimeZone;
/*      */   private final Locale mLocale;
/*      */   private transient Rule[] mRules;
/*      */   private transient int mMaxLengthEstimate;
/*      */   private static final int MAX_DIGITS = 10;
/*      */   
/*      */   protected FastDatePrinter(String paramString, TimeZone paramTimeZone, Locale paramLocale) {
/*  151 */     this.mPattern = paramString;
/*  152 */     this.mTimeZone = paramTimeZone;
/*  153 */     this.mLocale = paramLocale;
/*      */     
/*  155 */     init();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void init() {
/*  162 */     List<Rule> list = parsePattern();
/*  163 */     this.mRules = list.<Rule>toArray(new Rule[0]);
/*      */     
/*  165 */     int i = 0;
/*  166 */     for (int j = this.mRules.length; --j >= 0;) {
/*  167 */       i += this.mRules[j].estimateLength();
/*      */     }
/*      */     
/*  170 */     this.mMaxLengthEstimate = i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<Rule> parsePattern() {
/*  182 */     DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
/*  183 */     ArrayList<StringLiteral> arrayList = new ArrayList();
/*      */     
/*  185 */     String[] arrayOfString1 = dateFormatSymbols.getEras();
/*  186 */     String[] arrayOfString2 = dateFormatSymbols.getMonths();
/*  187 */     String[] arrayOfString3 = dateFormatSymbols.getShortMonths();
/*  188 */     String[] arrayOfString4 = dateFormatSymbols.getWeekdays();
/*  189 */     String[] arrayOfString5 = dateFormatSymbols.getShortWeekdays();
/*  190 */     String[] arrayOfString6 = dateFormatSymbols.getAmPmStrings();
/*      */     
/*  192 */     int i = this.mPattern.length();
/*  193 */     int[] arrayOfInt = new int[1];
/*      */     
/*  195 */     for (int j = 0; j < i; j++) {
/*  196 */       TextField textField3; NumberRule numberRule3; TextField textField2; DayInWeekField dayInWeekField; NumberRule numberRule2; TextField textField1; TwentyFourHourField twentyFourHourField; NumberRule numberRule1; Iso8601_Rule iso8601_Rule; TimeZoneNameRule timeZoneNameRule; TimeZoneNumberRule timeZoneNumberRule; StringLiteral stringLiteral; String str2; arrayOfInt[0] = j;
/*  197 */       String str1 = parseToken(this.mPattern, arrayOfInt);
/*  198 */       j = arrayOfInt[0];
/*      */       
/*  200 */       int k = str1.length();
/*  201 */       if (k == 0) {
/*      */         break;
/*      */       }
/*      */ 
/*      */       
/*  206 */       char c = str1.charAt(0);
/*      */       
/*  208 */       switch (c) {
/*      */         case 'G':
/*  210 */           textField3 = new TextField(0, arrayOfString1);
/*      */           break;
/*      */         case 'Y':
/*      */         case 'y':
/*  214 */           if (k == 2) {
/*  215 */             numberRule3 = TwoDigitYearField.INSTANCE;
/*      */           } else {
/*  217 */             numberRule3 = selectNumberRule(1, Math.max(k, 4));
/*      */           } 
/*  219 */           if (c == 'Y') {
/*  220 */             numberRule3 = new WeekYear(numberRule3);
/*      */           }
/*      */           break;
/*      */         case 'M':
/*  224 */           if (k >= 4) {
/*  225 */             TextField textField = new TextField(2, arrayOfString2); break;
/*  226 */           }  if (k == 3) {
/*  227 */             TextField textField = new TextField(2, arrayOfString3); break;
/*  228 */           }  if (k == 2) {
/*  229 */             numberRule3 = TwoDigitMonthField.INSTANCE; break;
/*      */           } 
/*  231 */           numberRule3 = UnpaddedMonthField.INSTANCE;
/*      */           break;
/*      */         
/*      */         case 'd':
/*  235 */           numberRule3 = selectNumberRule(5, k);
/*      */           break;
/*      */         case 'h':
/*  238 */           numberRule3 = new TwelveHourField(selectNumberRule(10, k));
/*      */           break;
/*      */         case 'H':
/*  241 */           numberRule3 = selectNumberRule(11, k);
/*      */           break;
/*      */         case 'm':
/*  244 */           numberRule3 = selectNumberRule(12, k);
/*      */           break;
/*      */         case 's':
/*  247 */           numberRule3 = selectNumberRule(13, k);
/*      */           break;
/*      */         case 'S':
/*  250 */           numberRule3 = selectNumberRule(14, k);
/*      */           break;
/*      */         case 'E':
/*  253 */           textField2 = new TextField(7, (k < 4) ? arrayOfString5 : arrayOfString4);
/*      */           break;
/*      */         case 'u':
/*  256 */           dayInWeekField = new DayInWeekField(selectNumberRule(7, k));
/*      */           break;
/*      */         case 'D':
/*  259 */           numberRule2 = selectNumberRule(6, k);
/*      */           break;
/*      */         case 'F':
/*  262 */           numberRule2 = selectNumberRule(8, k);
/*      */           break;
/*      */         case 'w':
/*  265 */           numberRule2 = selectNumberRule(3, k);
/*      */           break;
/*      */         case 'W':
/*  268 */           numberRule2 = selectNumberRule(4, k);
/*      */           break;
/*      */         case 'a':
/*  271 */           textField1 = new TextField(9, arrayOfString6);
/*      */           break;
/*      */         case 'k':
/*  274 */           twentyFourHourField = new TwentyFourHourField(selectNumberRule(11, k));
/*      */           break;
/*      */         case 'K':
/*  277 */           numberRule1 = selectNumberRule(10, k);
/*      */           break;
/*      */         case 'X':
/*  280 */           iso8601_Rule = Iso8601_Rule.getRule(k);
/*      */           break;
/*      */         case 'z':
/*  283 */           if (k >= 4) {
/*  284 */             TimeZoneNameRule timeZoneNameRule1 = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1); break;
/*      */           } 
/*  286 */           timeZoneNameRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
/*      */           break;
/*      */         
/*      */         case 'Z':
/*  290 */           if (k == 1) {
/*  291 */             TimeZoneNumberRule timeZoneNumberRule1 = TimeZoneNumberRule.INSTANCE_NO_COLON; break;
/*  292 */           }  if (k == 2) {
/*  293 */             Iso8601_Rule iso8601_Rule1 = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES; break;
/*      */           } 
/*  295 */           timeZoneNumberRule = TimeZoneNumberRule.INSTANCE_COLON;
/*      */           break;
/*      */         
/*      */         case '\'':
/*  299 */           str2 = str1.substring(1);
/*  300 */           if (str2.length() == 1) {
/*  301 */             CharacterLiteral characterLiteral = new CharacterLiteral(str2.charAt(0)); break;
/*      */           } 
/*  303 */           stringLiteral = new StringLiteral(str2);
/*      */           break;
/*      */         
/*      */         default:
/*  307 */           throw new IllegalArgumentException("Illegal pattern component: " + str1);
/*      */       } 
/*      */       
/*  310 */       arrayList.add(stringLiteral);
/*      */     } 
/*      */     
/*  313 */     return (List)arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String parseToken(String paramString, int[] paramArrayOfint) {
/*  324 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     
/*  326 */     int i = paramArrayOfint[0];
/*  327 */     int j = paramString.length();
/*      */     
/*  329 */     char c = paramString.charAt(i);
/*  330 */     if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
/*      */ 
/*      */       
/*  333 */       stringBuilder.append(c);
/*      */       
/*  335 */       while (i + 1 < j) {
/*  336 */         char c1 = paramString.charAt(i + 1);
/*  337 */         if (c1 == c) {
/*  338 */           stringBuilder.append(c);
/*  339 */           i++;
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  346 */       stringBuilder.append('\'');
/*      */       
/*  348 */       boolean bool = false;
/*      */       
/*  350 */       for (; i < j; i++) {
/*  351 */         c = paramString.charAt(i);
/*      */         
/*  353 */         if (c == '\'')
/*  354 */         { if (i + 1 < j && paramString.charAt(i + 1) == '\'') {
/*      */             
/*  356 */             i++;
/*  357 */             stringBuilder.append(c);
/*      */           } else {
/*  359 */             bool = !bool ? true : false;
/*      */           }  }
/*  361 */         else { if (!bool && ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
/*      */             
/*  363 */             i--;
/*      */             break;
/*      */           } 
/*  366 */           stringBuilder.append(c); }
/*      */       
/*      */       } 
/*      */     } 
/*      */     
/*  371 */     paramArrayOfint[0] = i;
/*  372 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected NumberRule selectNumberRule(int paramInt1, int paramInt2) {
/*  383 */     switch (paramInt2) {
/*      */       case 1:
/*  385 */         return new UnpaddedNumberField(paramInt1);
/*      */       case 2:
/*  387 */         return new TwoDigitNumberField(paramInt1);
/*      */     } 
/*  389 */     return new PaddedNumberField(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition) {
/*  407 */     if (paramObject instanceof Date)
/*  408 */       return format((Date)paramObject, paramStringBuffer); 
/*  409 */     if (paramObject instanceof Calendar)
/*  410 */       return format((Calendar)paramObject, paramStringBuffer); 
/*  411 */     if (paramObject instanceof Long) {
/*  412 */       return format(((Long)paramObject).longValue(), paramStringBuffer);
/*      */     }
/*  414 */     throw new IllegalArgumentException("Unknown class: " + ((paramObject == null) ? "<null>" : paramObject
/*  415 */         .getClass().getName()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   String format(Object paramObject) {
/*  427 */     if (paramObject instanceof Date)
/*  428 */       return format((Date)paramObject); 
/*  429 */     if (paramObject instanceof Calendar)
/*  430 */       return format((Calendar)paramObject); 
/*  431 */     if (paramObject instanceof Long) {
/*  432 */       return format(((Long)paramObject).longValue());
/*      */     }
/*  434 */     throw new IllegalArgumentException("Unknown class: " + ((paramObject == null) ? "<null>" : paramObject
/*  435 */         .getClass().getName()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(long paramLong) {
/*  444 */     Calendar calendar = newCalendar();
/*  445 */     calendar.setTimeInMillis(paramLong);
/*  446 */     return applyRulesToString(calendar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String applyRulesToString(Calendar paramCalendar) {
/*  455 */     return ((StringBuilder)applyRules(paramCalendar, new StringBuilder(this.mMaxLengthEstimate))).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Calendar newCalendar() {
/*  463 */     return Calendar.getInstance(this.mTimeZone, this.mLocale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(Date paramDate) {
/*  471 */     Calendar calendar = newCalendar();
/*  472 */     calendar.setTime(paramDate);
/*  473 */     return applyRulesToString(calendar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(Calendar paramCalendar) {
/*  481 */     return ((StringBuilder)format(paramCalendar, new StringBuilder(this.mMaxLengthEstimate))).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(long paramLong, StringBuffer paramStringBuffer) {
/*  489 */     Calendar calendar = newCalendar();
/*  490 */     calendar.setTimeInMillis(paramLong);
/*  491 */     return applyRules(calendar, paramStringBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer) {
/*  499 */     Calendar calendar = newCalendar();
/*  500 */     calendar.setTime(paramDate);
/*  501 */     return applyRules(calendar, paramStringBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(Calendar paramCalendar, StringBuffer paramStringBuffer) {
/*  510 */     return format(paramCalendar.getTime(), paramStringBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <B extends Appendable> B format(long paramLong, B paramB) {
/*  518 */     Calendar calendar = newCalendar();
/*  519 */     calendar.setTimeInMillis(paramLong);
/*  520 */     return applyRules(calendar, paramB);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <B extends Appendable> B format(Date paramDate, B paramB) {
/*  528 */     Calendar calendar = newCalendar();
/*  529 */     calendar.setTime(paramDate);
/*  530 */     return applyRules(calendar, paramB);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <B extends Appendable> B format(Calendar paramCalendar, B paramB) {
/*  539 */     if (!paramCalendar.getTimeZone().equals(this.mTimeZone)) {
/*  540 */       paramCalendar = (Calendar)paramCalendar.clone();
/*  541 */       paramCalendar.setTimeZone(this.mTimeZone);
/*      */     } 
/*  543 */     return applyRules(paramCalendar, paramB);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   protected StringBuffer applyRules(Calendar paramCalendar, StringBuffer paramStringBuffer) {
/*  558 */     return applyRules(paramCalendar, paramStringBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private <B extends Appendable> B applyRules(Calendar paramCalendar, B paramB) {
/*      */     try {
/*  572 */       for (Rule rule : this.mRules) {
/*  573 */         rule.appendTo((Appendable)paramB, paramCalendar);
/*      */       }
/*  575 */     } catch (IOException iOException) {
/*  576 */       ExceptionUtils.rethrow(iOException);
/*      */     } 
/*  578 */     return paramB;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPattern() {
/*  588 */     return this.mPattern;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TimeZone getTimeZone() {
/*  596 */     return this.mTimeZone;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Locale getLocale() {
/*  604 */     return this.mLocale;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxLengthEstimate() {
/*  617 */     return this.mMaxLengthEstimate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/*  630 */     if (!(paramObject instanceof FastDatePrinter)) {
/*  631 */       return false;
/*      */     }
/*  633 */     FastDatePrinter fastDatePrinter = (FastDatePrinter)paramObject;
/*  634 */     return (this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone
/*  635 */       .equals(fastDatePrinter.mTimeZone) && this.mLocale
/*  636 */       .equals(fastDatePrinter.mLocale));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  646 */     return this.mPattern.hashCode() + 13 * (this.mTimeZone.hashCode() + 13 * this.mLocale.hashCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  656 */     return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/*  670 */     paramObjectInputStream.defaultReadObject();
/*  671 */     init();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void appendDigits(Appendable paramAppendable, int paramInt) throws IOException {
/*  681 */     paramAppendable.append((char)(paramInt / 10 + 48));
/*  682 */     paramAppendable.append((char)(paramInt % 10 + 48));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void appendFullDigits(Appendable paramAppendable, int paramInt1, int paramInt2) throws IOException {
/*  696 */     if (paramInt1 < 10000) {
/*      */ 
/*      */       
/*  699 */       byte b = 4;
/*  700 */       if (paramInt1 < 1000) {
/*  701 */         b--;
/*  702 */         if (paramInt1 < 100) {
/*  703 */           b--;
/*  704 */           if (paramInt1 < 10) {
/*  705 */             b--;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  710 */       for (int i = paramInt2 - b; i > 0; i--) {
/*  711 */         paramAppendable.append('0');
/*      */       }
/*      */       
/*  714 */       switch (b) {
/*      */         case 4:
/*  716 */           paramAppendable.append((char)(paramInt1 / 1000 + 48));
/*  717 */           paramInt1 %= 1000;
/*      */         case 3:
/*  719 */           if (paramInt1 >= 100) {
/*  720 */             paramAppendable.append((char)(paramInt1 / 100 + 48));
/*  721 */             paramInt1 %= 100;
/*      */           } else {
/*  723 */             paramAppendable.append('0');
/*      */           } 
/*      */         case 2:
/*  726 */           if (paramInt1 >= 10) {
/*  727 */             paramAppendable.append((char)(paramInt1 / 10 + 48));
/*  728 */             paramInt1 %= 10;
/*      */           } else {
/*  730 */             paramAppendable.append('0');
/*      */           } 
/*      */         case 1:
/*  733 */           paramAppendable.append((char)(paramInt1 + 48));
/*      */           break;
/*      */       } 
/*      */ 
/*      */     
/*      */     } else {
/*  739 */       char[] arrayOfChar = new char[10];
/*  740 */       byte b = 0;
/*  741 */       while (paramInt1 != 0) {
/*  742 */         arrayOfChar[b++] = (char)(paramInt1 % 10 + 48);
/*  743 */         paramInt1 /= 10;
/*      */       } 
/*      */ 
/*      */       
/*  747 */       while (b < paramInt2) {
/*  748 */         paramAppendable.append('0');
/*  749 */         paramInt2--;
/*      */       } 
/*      */ 
/*      */       
/*  753 */       while (--b >= 0) {
/*  754 */         paramAppendable.append(arrayOfChar[b]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static interface Rule
/*      */   {
/*      */     int estimateLength();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static interface NumberRule
/*      */     extends Rule
/*      */   {
/*      */     void appendTo(Appendable param1Appendable, int param1Int) throws IOException;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class CharacterLiteral
/*      */     implements Rule
/*      */   {
/*      */     private final char mValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CharacterLiteral(char param1Char) {
/*  809 */       this.mValue = param1Char;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/*  817 */       return 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/*  825 */       param1Appendable.append(this.mValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class StringLiteral
/*      */     implements Rule
/*      */   {
/*      */     private final String mValue;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     StringLiteral(String param1String) {
/*  842 */       this.mValue = param1String;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/*  850 */       return this.mValue.length();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/*  858 */       param1Appendable.append(this.mValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TextField
/*      */     implements Rule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */     
/*      */     private final String[] mValues;
/*      */ 
/*      */ 
/*      */     
/*      */     TextField(int param1Int, String[] param1ArrayOfString) {
/*  877 */       this.mField = param1Int;
/*  878 */       this.mValues = param1ArrayOfString;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/*  886 */       int i = 0;
/*  887 */       for (int j = this.mValues.length; --j >= 0; ) {
/*  888 */         int k = this.mValues[j].length();
/*  889 */         if (k > i) {
/*  890 */           i = k;
/*      */         }
/*      */       } 
/*  893 */       return i;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/*  901 */       param1Appendable.append(this.mValues[param1Calendar.get(this.mField)]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class UnpaddedNumberField
/*      */     implements NumberRule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     UnpaddedNumberField(int param1Int) {
/*  917 */       this.mField = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/*  925 */       return 4;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/*  933 */       appendTo(param1Appendable, param1Calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
/*  941 */       if (param1Int < 10) {
/*  942 */         param1Appendable.append((char)(param1Int + 48));
/*  943 */       } else if (param1Int < 100) {
/*  944 */         FastDatePrinter.appendDigits(param1Appendable, param1Int);
/*      */       } else {
/*  946 */         FastDatePrinter.appendFullDigits(param1Appendable, param1Int, 1);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class UnpaddedMonthField
/*      */     implements NumberRule
/*      */   {
/*  955 */     static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/*  970 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/*  978 */       appendTo(param1Appendable, param1Calendar.get(2) + 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
/*  986 */       if (param1Int < 10) {
/*  987 */         param1Appendable.append((char)(param1Int + 48));
/*      */       } else {
/*  989 */         FastDatePrinter.appendDigits(param1Appendable, param1Int);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class PaddedNumberField
/*      */     implements NumberRule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */     
/*      */     private final int mSize;
/*      */ 
/*      */ 
/*      */     
/*      */     PaddedNumberField(int param1Int1, int param1Int2) {
/* 1008 */       if (param1Int2 < 3)
/*      */       {
/* 1010 */         throw new IllegalArgumentException();
/*      */       }
/* 1012 */       this.mField = param1Int1;
/* 1013 */       this.mSize = param1Int2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1021 */       return this.mSize;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/* 1029 */       appendTo(param1Appendable, param1Calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
/* 1037 */       FastDatePrinter.appendFullDigits(param1Appendable, param1Int, this.mSize);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwoDigitNumberField
/*      */     implements NumberRule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwoDigitNumberField(int param1Int) {
/* 1053 */       this.mField = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1061 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/* 1069 */       appendTo(param1Appendable, param1Calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
/* 1077 */       if (param1Int < 100) {
/* 1078 */         FastDatePrinter.appendDigits(param1Appendable, param1Int);
/*      */       } else {
/* 1080 */         FastDatePrinter.appendFullDigits(param1Appendable, param1Int, 2);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class TwoDigitYearField
/*      */     implements NumberRule
/*      */   {
/* 1089 */     static final TwoDigitYearField INSTANCE = new TwoDigitYearField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1103 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/* 1111 */       appendTo(param1Appendable, param1Calendar.get(1) % 100);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
/* 1119 */       FastDatePrinter.appendDigits(param1Appendable, param1Int);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class TwoDigitMonthField
/*      */     implements NumberRule
/*      */   {
/* 1127 */     static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1141 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/* 1149 */       appendTo(param1Appendable, param1Calendar.get(2) + 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
/* 1157 */       FastDatePrinter.appendDigits(param1Appendable, param1Int);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwelveHourField
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDatePrinter.NumberRule mRule;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwelveHourField(FastDatePrinter.NumberRule param1NumberRule) {
/* 1174 */       this.mRule = param1NumberRule;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1182 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/* 1190 */       int i = param1Calendar.get(10);
/* 1191 */       if (i == 0) {
/* 1192 */         i = param1Calendar.getLeastMaximum(10) + 1;
/*      */       }
/* 1194 */       this.mRule.appendTo(param1Appendable, i);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
/* 1202 */       this.mRule.appendTo(param1Appendable, param1Int);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwentyFourHourField
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDatePrinter.NumberRule mRule;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwentyFourHourField(FastDatePrinter.NumberRule param1NumberRule) {
/* 1219 */       this.mRule = param1NumberRule;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1227 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/* 1235 */       int i = param1Calendar.get(11);
/* 1236 */       if (i == 0) {
/* 1237 */         i = param1Calendar.getMaximum(11) + 1;
/*      */       }
/* 1239 */       this.mRule.appendTo(param1Appendable, i);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
/* 1247 */       this.mRule.appendTo(param1Appendable, param1Int);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class DayInWeekField
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDatePrinter.NumberRule mRule;
/*      */     
/*      */     DayInWeekField(FastDatePrinter.NumberRule param1NumberRule) {
/* 1258 */       this.mRule = param1NumberRule;
/*      */     }
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1263 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/* 1268 */       int i = param1Calendar.get(7);
/* 1269 */       this.mRule.appendTo(param1Appendable, (i == 1) ? 7 : (i - 1));
/*      */     }
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
/* 1274 */       this.mRule.appendTo(param1Appendable, param1Int);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class WeekYear
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDatePrinter.NumberRule mRule;
/*      */     
/*      */     WeekYear(FastDatePrinter.NumberRule param1NumberRule) {
/* 1285 */       this.mRule = param1NumberRule;
/*      */     }
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1290 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/* 1295 */       this.mRule.appendTo(param1Appendable, param1Calendar.getWeekYear());
/*      */     }
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
/* 1300 */       this.mRule.appendTo(param1Appendable, param1Int);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/* 1306 */   private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap<>(7);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String getTimeZoneDisplay(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale) {
/* 1318 */     TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(paramTimeZone, paramBoolean, paramInt, paramLocale);
/* 1319 */     String str = cTimeZoneDisplayCache.get(timeZoneDisplayKey);
/* 1320 */     if (str == null) {
/*      */       
/* 1322 */       str = paramTimeZone.getDisplayName(paramBoolean, paramInt, paramLocale);
/* 1323 */       String str1 = cTimeZoneDisplayCache.putIfAbsent(timeZoneDisplayKey, str);
/* 1324 */       if (str1 != null) {
/* 1325 */         str = str1;
/*      */       }
/*      */     } 
/* 1328 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneNameRule
/*      */     implements Rule
/*      */   {
/*      */     private final Locale mLocale;
/*      */ 
/*      */     
/*      */     private final int mStyle;
/*      */ 
/*      */     
/*      */     private final String mStandard;
/*      */     
/*      */     private final String mDaylight;
/*      */ 
/*      */     
/*      */     TimeZoneNameRule(TimeZone param1TimeZone, Locale param1Locale, int param1Int) {
/* 1348 */       this.mLocale = param1Locale;
/* 1349 */       this.mStyle = param1Int;
/*      */       
/* 1351 */       this.mStandard = FastDatePrinter.getTimeZoneDisplay(param1TimeZone, false, param1Int, param1Locale);
/* 1352 */       this.mDaylight = FastDatePrinter.getTimeZoneDisplay(param1TimeZone, true, param1Int, param1Locale);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1363 */       return Math.max(this.mStandard.length(), this.mDaylight.length());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/* 1371 */       TimeZone timeZone = param1Calendar.getTimeZone();
/* 1372 */       if (param1Calendar.get(16) == 0) {
/* 1373 */         param1Appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
/*      */       } else {
/* 1375 */         param1Appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneNumberRule
/*      */     implements Rule
/*      */   {
/* 1385 */     static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
/* 1386 */     static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean mColon;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TimeZoneNumberRule(boolean param1Boolean) {
/* 1396 */       this.mColon = param1Boolean;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1404 */       return 5;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/* 1413 */       int i = param1Calendar.get(15) + param1Calendar.get(16);
/*      */       
/* 1415 */       if (i < 0) {
/* 1416 */         param1Appendable.append('-');
/* 1417 */         i = -i;
/*      */       } else {
/* 1419 */         param1Appendable.append('+');
/*      */       } 
/*      */       
/* 1422 */       int j = i / 3600000;
/* 1423 */       FastDatePrinter.appendDigits(param1Appendable, j);
/*      */       
/* 1425 */       if (this.mColon) {
/* 1426 */         param1Appendable.append(':');
/*      */       }
/*      */       
/* 1429 */       int k = i / 60000 - 60 * j;
/* 1430 */       FastDatePrinter.appendDigits(param1Appendable, k);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class Iso8601_Rule
/*      */     implements Rule
/*      */   {
/* 1441 */     static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
/*      */     
/* 1443 */     static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
/*      */     
/* 1445 */     static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);
/*      */ 
/*      */ 
/*      */     
/*      */     final int length;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static Iso8601_Rule getRule(int param1Int) {
/* 1455 */       switch (param1Int) {
/*      */         case 1:
/* 1457 */           return ISO8601_HOURS;
/*      */         case 2:
/* 1459 */           return ISO8601_HOURS_MINUTES;
/*      */         case 3:
/* 1461 */           return ISO8601_HOURS_COLON_MINUTES;
/*      */       } 
/* 1463 */       throw new IllegalArgumentException("invalid number of X");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Iso8601_Rule(int param1Int) {
/* 1475 */       this.length = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1483 */       return this.length;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
/* 1491 */       int i = param1Calendar.get(15) + param1Calendar.get(16);
/* 1492 */       if (i == 0) {
/* 1493 */         param1Appendable.append("Z");
/*      */         
/*      */         return;
/*      */       } 
/* 1497 */       if (i < 0) {
/* 1498 */         param1Appendable.append('-');
/* 1499 */         i = -i;
/*      */       } else {
/* 1501 */         param1Appendable.append('+');
/*      */       } 
/*      */       
/* 1504 */       int j = i / 3600000;
/* 1505 */       FastDatePrinter.appendDigits(param1Appendable, j);
/*      */       
/* 1507 */       if (this.length < 5) {
/*      */         return;
/*      */       }
/*      */       
/* 1511 */       if (this.length == 6) {
/* 1512 */         param1Appendable.append(':');
/*      */       }
/*      */       
/* 1515 */       int k = i / 60000 - 60 * j;
/* 1516 */       FastDatePrinter.appendDigits(param1Appendable, k);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneDisplayKey
/*      */   {
/*      */     private final TimeZone mTimeZone;
/*      */ 
/*      */ 
/*      */     
/*      */     private final int mStyle;
/*      */ 
/*      */ 
/*      */     
/*      */     private final Locale mLocale;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TimeZoneDisplayKey(TimeZone param1TimeZone, boolean param1Boolean, int param1Int, Locale param1Locale) {
/* 1539 */       this.mTimeZone = param1TimeZone;
/* 1540 */       if (param1Boolean) {
/* 1541 */         this.mStyle = param1Int | Integer.MIN_VALUE;
/*      */       } else {
/* 1543 */         this.mStyle = param1Int;
/*      */       } 
/* 1545 */       this.mLocale = param1Locale;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1553 */       return (this.mStyle * 31 + this.mLocale.hashCode()) * 31 + this.mTimeZone.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/* 1561 */       if (this == param1Object) {
/* 1562 */         return true;
/*      */       }
/* 1564 */       if (param1Object instanceof TimeZoneDisplayKey) {
/* 1565 */         TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey)param1Object;
/* 1566 */         return (this.mTimeZone
/* 1567 */           .equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale
/*      */           
/* 1569 */           .equals(timeZoneDisplayKey.mLocale));
/*      */       } 
/* 1571 */       return false;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\time\FastDatePrinter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */