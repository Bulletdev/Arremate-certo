/*      */ package org.apache.xmlbeans;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.TimeZone;
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
/*      */ public final class GDateBuilder
/*      */   implements Serializable, GDateSpecification
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*      */   private int _bits;
/*      */   private int _CY;
/*      */   private int _M;
/*      */   private int _D;
/*      */   private int _h;
/*      */   private int _m;
/*      */   private int _s;
/*      */   private BigDecimal _fs;
/*      */   private int _tzsign;
/*      */   private int _tzh;
/*      */   private int _tzm;
/*      */   
/*      */   public GDateBuilder() {}
/*      */   
/*      */   public Object clone() {
/*   68 */     return new GDateBuilder(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GDate toGDate() {
/*   76 */     return new GDate(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GDateBuilder(GDateSpecification paramGDateSpecification) {
/*   84 */     if (paramGDateSpecification.hasTimeZone()) {
/*   85 */       setTimeZone(paramGDateSpecification.getTimeZoneSign(), paramGDateSpecification.getTimeZoneHour(), paramGDateSpecification.getTimeZoneMinute());
/*      */     }
/*   87 */     if (paramGDateSpecification.hasTime()) {
/*   88 */       setTime(paramGDateSpecification.getHour(), paramGDateSpecification.getMinute(), paramGDateSpecification.getSecond(), paramGDateSpecification.getFraction());
/*      */     }
/*   90 */     if (paramGDateSpecification.hasDay()) {
/*   91 */       setDay(paramGDateSpecification.getDay());
/*      */     }
/*   93 */     if (paramGDateSpecification.hasMonth()) {
/*   94 */       setMonth(paramGDateSpecification.getMonth());
/*      */     }
/*   96 */     if (paramGDateSpecification.hasYear()) {
/*   97 */       setYear(paramGDateSpecification.getYear());
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
/*      */   public GDateBuilder(CharSequence paramCharSequence) {
/*  124 */     this(new GDate(paramCharSequence));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public GDateBuilder(Calendar paramCalendar) {
/*  130 */     this(new GDate(paramCalendar));
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
/*      */   public GDateBuilder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, BigDecimal paramBigDecimal) {
/*  159 */     this._bits = 30;
/*      */     
/*  161 */     if (paramInt1 == 0) {
/*  162 */       throw new IllegalArgumentException();
/*      */     }
/*  164 */     this._CY = (paramInt1 > 0) ? paramInt1 : (paramInt1 + 1);
/*  165 */     this._M = paramInt2;
/*  166 */     this._D = paramInt3;
/*  167 */     this._h = paramInt4;
/*  168 */     this._m = paramInt5;
/*  169 */     this._s = paramInt6;
/*  170 */     this._fs = (paramBigDecimal == null) ? GDate._zero : paramBigDecimal;
/*      */     
/*  172 */     if (!isValid()) {
/*  173 */       throw new IllegalArgumentException();
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
/*      */   public GDateBuilder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, BigDecimal paramBigDecimal, int paramInt7, int paramInt8, int paramInt9) {
/*  210 */     this._bits = 31;
/*      */     
/*  212 */     if (paramInt1 == 0) {
/*  213 */       throw new IllegalArgumentException();
/*      */     }
/*  215 */     this._CY = (paramInt1 > 0) ? paramInt1 : (paramInt1 + 1);
/*  216 */     this._M = paramInt2;
/*  217 */     this._D = paramInt3;
/*  218 */     this._h = paramInt4;
/*  219 */     this._m = paramInt5;
/*  220 */     this._s = paramInt6;
/*  221 */     this._fs = (paramBigDecimal == null) ? GDate._zero : paramBigDecimal;
/*  222 */     this._tzsign = paramInt7;
/*  223 */     this._tzh = paramInt8;
/*  224 */     this._tzm = paramInt9;
/*      */     
/*  226 */     if (!isValid()) {
/*  227 */       throw new IllegalArgumentException();
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GDateBuilder(Date paramDate) {
/*  243 */     setDate(paramDate);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isImmutable() {
/*  251 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFlags() {
/*  261 */     return this._bits;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasTimeZone() {
/*  268 */     return ((this._bits & 0x1) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasYear() {
/*  274 */     return ((this._bits & 0x2) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasMonth() {
/*  280 */     return ((this._bits & 0x4) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasDay() {
/*  286 */     return ((this._bits & 0x8) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasTime() {
/*  292 */     return ((this._bits & 0x10) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasDate() {
/*  298 */     return ((this._bits & 0xE) == 14);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getYear() {
/*  304 */     return (this._CY > 0) ? this._CY : (this._CY - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getMonth() {
/*  310 */     return this._M;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getDay() {
/*  316 */     return this._D;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getHour() {
/*  322 */     return this._h;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getMinute() {
/*  328 */     return this._m;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getSecond() {
/*  334 */     return this._s;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final BigDecimal getFraction() {
/*  341 */     return this._fs;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getMillisecond() {
/*  349 */     if (this._fs == null || this._fs == GDate._zero)
/*  350 */       return 0; 
/*  351 */     return this._fs.setScale(3, 4).unscaledValue().intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getTimeZoneSign() {
/*  359 */     return this._tzsign;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getTimeZoneHour() {
/*  367 */     return this._tzh;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getTimeZoneMinute() {
/*  375 */     return this._tzm;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setYear(int paramInt) {
/*  385 */     if (paramInt < -292275295 || paramInt > 292277265)
/*  386 */       throw new IllegalArgumentException("year out of range"); 
/*  387 */     if (paramInt == 0)
/*  388 */       throw new IllegalArgumentException("year cannot be 0"); 
/*  389 */     this._bits |= 0x2; this._CY = (paramInt > 0) ? paramInt : (paramInt + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMonth(int paramInt) {
/*  398 */     if (paramInt < 1 || paramInt > 12)
/*  399 */       throw new IllegalArgumentException("month out of range"); 
/*  400 */     this._bits |= 0x4; this._M = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDay(int paramInt) {
/*  409 */     if (paramInt < 1 || paramInt > 31)
/*  410 */       throw new IllegalArgumentException("day out of range"); 
/*  411 */     this._bits |= 0x8; this._D = paramInt;
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
/*      */   public void setTime(int paramInt1, int paramInt2, int paramInt3, BigDecimal paramBigDecimal) {
/*  426 */     if (paramInt1 < 0 || paramInt1 > 24)
/*  427 */       throw new IllegalArgumentException("hour out of range"); 
/*  428 */     if (paramInt2 < 0 || paramInt2 > 59)
/*  429 */       throw new IllegalArgumentException("minute out of range"); 
/*  430 */     if (paramInt3 < 0 || paramInt3 > 59)
/*  431 */       throw new IllegalArgumentException("second out of range"); 
/*  432 */     if (paramBigDecimal != null && (paramBigDecimal.signum() < 0 || paramBigDecimal.compareTo(GDate._one) > 1))
/*  433 */       throw new IllegalArgumentException("fraction out of range"); 
/*  434 */     if (paramInt1 == 24 && (paramInt2 != 0 || paramInt3 != 0 || (paramBigDecimal != null && GDate._zero.compareTo(paramBigDecimal) != 0))) {
/*  435 */       throw new IllegalArgumentException("when hour is 24, min sec and fracton must be 0");
/*      */     }
/*  437 */     this._bits |= 0x10;
/*  438 */     this._h = paramInt1;
/*  439 */     this._m = paramInt2;
/*  440 */     this._s = paramInt3;
/*  441 */     this._fs = (paramBigDecimal == null) ? GDate._zero : paramBigDecimal;
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
/*      */ 
/*      */   
/*      */   public void setTimeZone(int paramInt1, int paramInt2, int paramInt3) {
/*  460 */     if ((paramInt1 != 0 || paramInt2 != 0 || paramInt3 != 0) && ((paramInt1 != -1 && paramInt1 != 1) || paramInt2 < 0 || paramInt3 < 0 || ((paramInt2 != 14 || paramInt3 != 0) && (paramInt2 >= 14 || paramInt3 >= 60))))
/*      */     {
/*      */ 
/*      */       
/*  464 */       throw new IllegalArgumentException("time zone out of range (-14:00 to +14:00). (" + ((paramInt1 < 0) ? "-" : "+") + paramInt2 + ":" + paramInt3 + ")");
/*      */     }
/*      */     
/*  467 */     this._bits |= 0x1;
/*  468 */     this._tzsign = paramInt1;
/*  469 */     this._tzh = paramInt2;
/*  470 */     this._tzm = paramInt3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTimeZone(int paramInt) {
/*  480 */     if (paramInt < -840 || paramInt > 840) {
/*  481 */       throw new IllegalArgumentException("time zone out of range (-840 to 840 minutes). (" + paramInt + ")");
/*      */     }
/*  483 */     byte b = (paramInt < 0) ? -1 : ((paramInt > 0) ? 1 : 0);
/*  484 */     paramInt *= b;
/*  485 */     int i = paramInt / 60;
/*  486 */     int j = paramInt - i * 60;
/*      */     
/*  488 */     setTimeZone(b, i, j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearYear() {
/*  496 */     this._bits &= 0xFFFFFFFD; this._CY = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearMonth() {
/*  503 */     this._bits &= 0xFFFFFFFB; this._M = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearDay() {
/*  510 */     this._bits &= 0xFFFFFFF7; this._D = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearTime() {
/*  519 */     this._bits &= 0xFFFFFFEF;
/*  520 */     this._h = 0;
/*  521 */     this._m = 0;
/*  522 */     this._s = 0;
/*  523 */     this._fs = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearTimeZone() {
/*  533 */     this._bits &= 0xFFFFFFFE;
/*  534 */     this._tzsign = 0;
/*  535 */     this._tzh = 0;
/*  536 */     this._tzm = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isValid() {
/*  546 */     return isValidGDate(this);
/*      */   }
/*      */ 
/*      */   
/*      */   static final boolean isValidGDate(GDateSpecification paramGDateSpecification) {
/*  551 */     if (paramGDateSpecification.hasYear() && paramGDateSpecification.getYear() == 0) {
/*  552 */       return false;
/*      */     }
/*  554 */     if (paramGDateSpecification.hasMonth() && (paramGDateSpecification.getMonth() < 1 || paramGDateSpecification.getMonth() > 12)) {
/*  555 */       return false;
/*      */     }
/*  557 */     if (paramGDateSpecification.hasDay() && (paramGDateSpecification.getDay() < 1 || paramGDateSpecification.getDay() > 31 || (paramGDateSpecification.getDay() > 28 && paramGDateSpecification.hasMonth() && (paramGDateSpecification.hasYear() ? (paramGDateSpecification.getDay() > _maxDayInMonthFor((paramGDateSpecification.getYear() > 0) ? paramGDateSpecification.getYear() : (paramGDateSpecification.getYear() + 1), paramGDateSpecification.getMonth())) : (paramGDateSpecification.getDay() > _maxDayInMonth(paramGDateSpecification.getMonth()))))))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  567 */       return false;
/*      */     }
/*  569 */     if (paramGDateSpecification.hasTime() && (paramGDateSpecification.getHour() < 0 || paramGDateSpecification.getHour() > 23 || paramGDateSpecification.getMinute() < 0 || paramGDateSpecification.getMinute() > 59 || paramGDateSpecification.getSecond() < 0 || paramGDateSpecification.getSecond() > 59 || paramGDateSpecification.getFraction().signum() < 0 || paramGDateSpecification.getFraction().compareTo(GDate._one) >= 0) && (paramGDateSpecification.getHour() != 24 || paramGDateSpecification.getMinute() != 0 || paramGDateSpecification.getSecond() != 0 || paramGDateSpecification.getFraction().compareTo(GDate._zero) != 0))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  576 */       return false;
/*      */     }
/*  578 */     if (paramGDateSpecification.hasTimeZone() && (paramGDateSpecification.getTimeZoneSign() != 0 || paramGDateSpecification.getTimeZoneHour() != 0 || paramGDateSpecification.getTimeZoneMinute() != 0) && ((paramGDateSpecification.getTimeZoneSign() != -1 && paramGDateSpecification.getTimeZoneSign() != 1) || paramGDateSpecification.getTimeZoneHour() < 0 || paramGDateSpecification.getTimeZoneMinute() < 0 || ((paramGDateSpecification.getTimeZoneHour() != 14 || paramGDateSpecification.getTimeZoneMinute() != 0) && (paramGDateSpecification.getTimeZoneHour() >= 14 || paramGDateSpecification.getTimeZoneMinute() >= 60))))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  585 */       return false;
/*      */     }
/*      */     
/*  588 */     return true;
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
/*      */   
/*      */   public void normalize() {
/*  606 */     if (hasDay() == hasMonth() && hasDay() == hasYear() && hasTimeZone() && hasTime()) {
/*      */ 
/*      */       
/*  609 */       normalizeToTimeZone(0, 0, 0);
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  614 */       _normalizeTimeAndDate();
/*      */     } 
/*      */ 
/*      */     
/*  618 */     if (hasTime() && this._fs != null && this._fs.scale() > 0)
/*      */     {
/*  620 */       if (this._fs.signum() == 0) {
/*  621 */         this._fs = GDate._zero;
/*      */       } else {
/*      */         
/*  624 */         BigInteger bigInteger = this._fs.unscaledValue();
/*  625 */         String str = bigInteger.toString();
/*      */         int i;
/*  627 */         for (i = str.length(); i > 0 && 
/*  628 */           str.charAt(i - 1) == '0'; i--);
/*      */         
/*  630 */         if (i < str.length()) {
/*  631 */           this._fs = this._fs.setScale(this._fs.scale() - str.length() + i);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void normalize24h() {
/*  641 */     if (!hasTime() || getHour() != 24) {
/*      */       return;
/*      */     }
/*  644 */     _normalizeTimeAndDate();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void _normalizeTimeAndDate() {
/*  650 */     long l = 0L;
/*      */     
/*  652 */     if (hasTime()) {
/*  653 */       l = _normalizeTime();
/*      */     }
/*  655 */     if (hasDay()) {
/*  656 */       this._D = (int)(this._D + l);
/*      */     }
/*  658 */     if (hasDate()) {
/*      */       
/*  660 */       _normalizeDate();
/*      */     }
/*  662 */     else if (hasMonth()) {
/*      */ 
/*      */ 
/*      */       
/*  666 */       if (this._M < 1 || this._M > 12) {
/*      */         
/*  668 */         int i = this._M;
/*  669 */         this._M = _modulo(i, 1, 13);
/*  670 */         if (hasYear()) {
/*  671 */           this._CY += (int)_fQuotient(i, 1, 13);
/*      */         }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void normalizeToTimeZone(int paramInt1, int paramInt2, int paramInt3) {
/*  690 */     if ((paramInt1 != 0 || paramInt2 != 0 || paramInt3 != 0) && ((paramInt1 != -1 && paramInt1 != 1) || paramInt2 < 0 || paramInt3 < 0 || ((paramInt2 != 14 || paramInt3 != 0) && (paramInt2 >= 14 || paramInt3 >= 60))))
/*      */     {
/*      */ 
/*      */       
/*  694 */       throw new IllegalArgumentException("time zone must be between -14:00 and +14:00");
/*      */     }
/*  696 */     if (!hasTimeZone() || !hasTime()) {
/*  697 */       throw new IllegalStateException("cannot normalize time zone without both time and timezone");
/*      */     }
/*  699 */     if (hasDay() != hasMonth() || hasDay() != hasYear()) {
/*  700 */       throw new IllegalStateException("cannot do date math without a complete date");
/*      */     }
/*  702 */     int i = paramInt1 * paramInt2 - this._tzsign * this._tzh;
/*  703 */     int j = paramInt1 * paramInt3 - this._tzsign * this._tzm;
/*      */     
/*  705 */     this._tzsign = paramInt1;
/*  706 */     this._tzh = paramInt2;
/*  707 */     this._tzm = paramInt3;
/*  708 */     addDuration(1, 0, 0, 0, i, j, 0, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void normalizeToTimeZone(int paramInt) {
/*  718 */     if (paramInt < -840 || paramInt > 840) {
/*  719 */       throw new IllegalArgumentException("time zone out of range (-840 to 840 minutes). (" + paramInt + ")");
/*      */     }
/*  721 */     byte b = (paramInt < 0) ? -1 : ((paramInt > 0) ? 1 : 0);
/*  722 */     paramInt *= b;
/*  723 */     int i = paramInt / 60;
/*  724 */     int j = paramInt - i * 60;
/*      */     
/*  726 */     normalizeToTimeZone(b, i, j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addGDuration(GDurationSpecification paramGDurationSpecification) {
/*  737 */     addDuration(paramGDurationSpecification.getSign(), paramGDurationSpecification.getYear(), paramGDurationSpecification.getMonth(), paramGDurationSpecification.getDay(), paramGDurationSpecification.getHour(), paramGDurationSpecification.getMinute(), paramGDurationSpecification.getSecond(), paramGDurationSpecification.getFraction());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void subtractGDuration(GDurationSpecification paramGDurationSpecification) {
/*  748 */     addDuration(-paramGDurationSpecification.getSign(), paramGDurationSpecification.getYear(), paramGDurationSpecification.getMonth(), paramGDurationSpecification.getDay(), paramGDurationSpecification.getHour(), paramGDurationSpecification.getMinute(), paramGDurationSpecification.getSecond(), paramGDurationSpecification.getFraction());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void _normalizeDate() {
/*  759 */     if (this._M < 1 || this._M > 12 || this._D < 1 || this._D > _maxDayInMonthFor(this._CY, this._M)) {
/*      */ 
/*      */       
/*  762 */       int i = this._M;
/*  763 */       this._M = _modulo(i, 1, 13);
/*  764 */       this._CY += (int)_fQuotient(i, 1, 13);
/*      */ 
/*      */       
/*  767 */       int j = this._D - 1;
/*  768 */       this._D = 1;
/*      */ 
/*      */       
/*  771 */       setJulianDate(getJulianDate() + j);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long _normalizeTime() {
/*  782 */     long l = 0L;
/*      */ 
/*      */ 
/*      */     
/*  786 */     if (this._fs != null && (this._fs.signum() < 0 || this._fs.compareTo(GDate._one) >= 0)) {
/*      */       
/*  788 */       BigDecimal bigDecimal = this._fs.setScale(0, 3);
/*  789 */       this._fs = this._fs.subtract(bigDecimal);
/*  790 */       l = bigDecimal.longValue();
/*      */     } 
/*      */     
/*  793 */     if (l != 0L || this._s < 0 || this._s > 59 || this._m < 0 || this._m > 50 || this._h < 0 || this._h > 23) {
/*      */ 
/*      */       
/*  796 */       long l1 = this._s + l;
/*  797 */       l = _fQuotient(l1, 60);
/*  798 */       this._s = _mod(l1, 60, l);
/*      */ 
/*      */       
/*  801 */       l1 = this._m + l;
/*  802 */       l = _fQuotient(l1, 60);
/*  803 */       this._m = _mod(l1, 60, l);
/*      */ 
/*      */       
/*  806 */       l1 = this._h + l;
/*  807 */       l = _fQuotient(l1, 24);
/*  808 */       this._h = _mod(l1, 24, l);
/*      */     } 
/*      */     
/*  811 */     return l;
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
/*      */   
/*      */   public void addDuration(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, BigDecimal paramBigDecimal) {
/*  829 */     boolean bool1 = (paramInt5 != 0 || paramInt6 != 0 || paramInt7 != 0 || (paramBigDecimal != null && paramBigDecimal.signum() != 0)) ? true : false;
/*  830 */     if (bool1 && !hasTime())
/*  831 */       throw new IllegalStateException("cannot do time math without a complete time"); 
/*  832 */     boolean bool2 = (hasDay() && (paramInt4 != 0 || bool1)) ? true : false;
/*  833 */     if (bool2 && !hasDate()) {
/*  834 */       throw new IllegalStateException("cannot do date math without a complete date");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  839 */     if (paramInt3 != 0 || paramInt2 != 0) {
/*      */ 
/*      */       
/*  842 */       if (hasDay()) {
/*  843 */         _normalizeDate();
/*      */       }
/*      */       
/*  846 */       int i = this._M + paramInt1 * paramInt3;
/*  847 */       this._M = _modulo(i, 1, 13);
/*  848 */       this._CY = this._CY + paramInt1 * paramInt2 + (int)_fQuotient(i, 1, 13);
/*      */ 
/*      */       
/*  851 */       if (hasDay()) {
/*      */         
/*  853 */         assert this._D >= 1;
/*  854 */         i = _maxDayInMonthFor(this._CY, this._M);
/*  855 */         if (this._D > i) {
/*  856 */           this._D = i;
/*      */         }
/*      */       } 
/*      */     } 
/*  860 */     long l = 0L;
/*      */     
/*  862 */     if (bool1) {
/*      */ 
/*      */       
/*  865 */       if (paramBigDecimal != null && paramBigDecimal.signum() != 0)
/*      */       {
/*  867 */         if (this._fs.signum() == 0 && paramInt1 == 1) {
/*  868 */           this._fs = paramBigDecimal;
/*      */         } else {
/*  870 */           this._fs = (paramInt1 == 1) ? this._fs.add(paramBigDecimal) : this._fs.subtract(paramBigDecimal);
/*      */         } 
/*      */       }
/*      */       
/*  874 */       this._s += paramInt1 * paramInt7;
/*  875 */       this._m += paramInt1 * paramInt6;
/*  876 */       this._h += paramInt1 * paramInt5;
/*      */ 
/*      */       
/*  879 */       l = _normalizeTime();
/*      */     } 
/*      */     
/*  882 */     if (bool2) {
/*      */ 
/*      */       
/*  885 */       this._D = (int)(this._D + (paramInt1 * paramInt4) + l);
/*  886 */       _normalizeDate();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int _maxDayInMonthFor(int paramInt1, int paramInt2) {
/*  896 */     if (paramInt2 == 4 || paramInt2 == 6 || paramInt2 == 9 || paramInt2 == 11) {
/*  897 */       return 30;
/*      */     }
/*  899 */     if (paramInt2 == 2) {
/*  900 */       return _isLeapYear(paramInt1) ? 29 : 28;
/*      */     }
/*  902 */     return 31;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int _maxDayInMonth(int paramInt) {
/*  911 */     if (paramInt == 4 || paramInt == 6 || paramInt == 9 || paramInt == 11) {
/*  912 */       return 30;
/*      */     }
/*  914 */     if (paramInt == 2) {
/*  915 */       return 29;
/*      */     }
/*  917 */     return 31;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getJulianDate() {
/*  927 */     return julianDateForGDate(this);
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
/*      */   public void setJulianDate(int paramInt) {
/*  940 */     if (paramInt < 0) {
/*  941 */       throw new IllegalArgumentException("date before year -4713");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  947 */     int i = paramInt + 68569;
/*  948 */     int j = 4 * i / 146097;
/*  949 */     i -= (146097 * j + 3) / 4;
/*  950 */     this._CY = 4000 * (i + 1) / 1461001;
/*  951 */     i = i - 1461 * this._CY / 4 + 31;
/*  952 */     this._M = 80 * i / 2447;
/*  953 */     this._D = i - 2447 * this._M / 80;
/*  954 */     i = this._M / 11;
/*  955 */     this._M = this._M + 2 - 12 * i;
/*  956 */     this._CY = 100 * (j - 49) + this._CY + i;
/*      */     
/*  958 */     this._bits |= 0xE;
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
/*      */ 
/*      */   
/*      */   public void setDate(Date paramDate) {
/*  977 */     TimeZone timeZone = TimeZone.getDefault();
/*  978 */     int i = timeZone.getOffset(paramDate.getTime());
/*  979 */     byte b = 1;
/*  980 */     if (i < 0) {
/*      */       
/*  982 */       b = -1;
/*  983 */       i = -i;
/*      */     } 
/*  985 */     int j = i / 60000;
/*  986 */     int k = j / 60;
/*  987 */     j -= k * 60;
/*      */     
/*  989 */     setTimeZone(b, k, j);
/*      */ 
/*      */     
/*  992 */     int m = b * (k * 60 + j) * 60 * 1000;
/*      */ 
/*      */     
/*  995 */     setTime(0, 0, 0, GDate._zero);
/*      */ 
/*      */ 
/*      */     
/*  999 */     this._bits |= 0xE;
/* 1000 */     this._CY = 1970;
/* 1001 */     this._M = 1;
/* 1002 */     this._D = 1;
/*      */ 
/*      */     
/* 1005 */     addGDuration(new GDuration(1, 0, 0, 0, 0, 0, 0, BigDecimal.valueOf(paramDate.getTime() + m, 3)));
/*      */ 
/*      */ 
/*      */     
/* 1009 */     if (this._fs.signum() == 0) {
/* 1010 */       this._fs = GDate._zero;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGDate(GDateSpecification paramGDateSpecification) {
/* 1021 */     this._bits = paramGDateSpecification.getFlags() & 0x1F;
/* 1022 */     int i = paramGDateSpecification.getYear();
/* 1023 */     this._CY = (i > 0) ? i : (i + 1);
/* 1024 */     this._M = paramGDateSpecification.getMonth();
/* 1025 */     this._D = paramGDateSpecification.getDay();
/* 1026 */     this._h = paramGDateSpecification.getHour();
/* 1027 */     this._m = paramGDateSpecification.getMinute();
/* 1028 */     this._s = paramGDateSpecification.getSecond();
/* 1029 */     this._fs = paramGDateSpecification.getFraction();
/* 1030 */     this._tzsign = paramGDateSpecification.getTimeZoneSign();
/* 1031 */     this._tzh = paramGDateSpecification.getTimeZoneHour();
/* 1032 */     this._tzm = paramGDateSpecification.getTimeZoneMinute();
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
/*      */ 
/*      */   
/*      */   public XmlCalendar getCalendar() {
/* 1051 */     return new XmlCalendar(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDate() {
/* 1060 */     return dateForGDate(this);
/*      */   }
/*      */ 
/*      */   
/*      */   static int julianDateForGDate(GDateSpecification paramGDateSpecification) {
/* 1065 */     if (!paramGDateSpecification.hasDate()) {
/* 1066 */       throw new IllegalStateException("cannot do date math without a complete date");
/*      */     }
/*      */     
/* 1069 */     int i = paramGDateSpecification.getDay();
/* 1070 */     int j = paramGDateSpecification.getMonth();
/* 1071 */     int k = paramGDateSpecification.getYear();
/* 1072 */     k = (k > 0) ? k : (k + 1);
/* 1073 */     int m = i - 32075 + 1461 * (k + 4800 + (j - 14) / 12) / 4 + 367 * (j - 2 - (j - 14) / 12 * 12) / 12 - 3 * (k + 4900 + (j - 14) / 12) / 100 / 4;
/*      */ 
/*      */     
/* 1076 */     if (m < 0) {
/* 1077 */       throw new IllegalStateException("date too far in the past (year allowed to -4713)");
/*      */     }
/* 1079 */     return m;
/*      */   }
/*      */ 
/*      */   
/*      */   static Date dateForGDate(GDateSpecification paramGDateSpecification) {
/* 1084 */     long l1 = julianDateForGDate(paramGDateSpecification);
/* 1085 */     long l2 = l1 - 2440588L;
/* 1086 */     long l3 = 86400000L * l2;
/*      */     
/* 1088 */     l3 += paramGDateSpecification.getMillisecond();
/* 1089 */     l3 += (paramGDateSpecification.getSecond() * 1000);
/* 1090 */     l3 += (paramGDateSpecification.getMinute() * 60 * 1000);
/* 1091 */     l3 += (paramGDateSpecification.getHour() * 60 * 60 * 1000);
/* 1092 */     if (paramGDateSpecification.hasTimeZone()) {
/*      */       
/* 1094 */       l3 -= (paramGDateSpecification.getTimeZoneMinute() * paramGDateSpecification.getTimeZoneSign() * 60 * 1000);
/* 1095 */       l3 -= (paramGDateSpecification.getTimeZoneHour() * paramGDateSpecification.getTimeZoneSign() * 60 * 60 * 1000);
/*      */     }
/*      */     else {
/*      */       
/* 1099 */       TimeZone timeZone = TimeZone.getDefault();
/* 1100 */       int i = timeZone.getOffset(l3);
/* 1101 */       l3 -= i;
/*      */     } 
/*      */     
/* 1104 */     return new Date(l3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean _isLeapYear(int paramInt) {
/* 1113 */     return (paramInt % 4 == 0 && (paramInt % 100 != 0 || paramInt % 400 == 0));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final long _fQuotient(long paramLong, int paramInt) {
/* 1121 */     if (((paramLong < 0L) ? true : false) == ((paramInt < 0) ? true : false)) {
/* 1122 */       return paramLong / paramInt;
/*      */     }
/* 1124 */     return -((paramInt - paramLong - 1L) / paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int _mod(long paramLong1, int paramInt, long paramLong2) {
/* 1132 */     return (int)(paramLong1 - paramLong2 * paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int _modulo(long paramLong, int paramInt1, int paramInt2) {
/* 1140 */     long l = paramLong - paramInt1;
/* 1141 */     int i = paramInt2 - paramInt1;
/* 1142 */     return _mod(l, i, _fQuotient(l, i)) + paramInt1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final long _fQuotient(long paramLong, int paramInt1, int paramInt2) {
/* 1150 */     return _fQuotient(paramLong - paramInt1, paramInt2 - paramInt1);
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
/*      */   private void _setToFirstMoment() {
/* 1163 */     if (!hasYear()) {
/* 1164 */       setYear(1584);
/*      */     }
/* 1166 */     if (!hasMonth()) {
/* 1167 */       setMonth(1);
/*      */     }
/* 1169 */     if (!hasDay()) {
/* 1170 */       setDay(1);
/*      */     }
/* 1172 */     if (!hasTime()) {
/* 1173 */       setTime(0, 0, 0, GDate._zero);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int compareToGDate(GDateSpecification paramGDateSpecification) {
/* 1191 */     return compareGDate(this, paramGDateSpecification);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final int compareGDate(GDateSpecification paramGDateSpecification1, GDateSpecification paramGDateSpecification2) {
/* 1198 */     int i = paramGDateSpecification1.getFlags() ^ paramGDateSpecification2.getFlags();
/*      */     
/* 1200 */     if ((i & 0x1F) == 0) {
/*      */ 
/*      */ 
/*      */       
/* 1204 */       if (paramGDateSpecification1.hasTimeZone() && (paramGDateSpecification2.getTimeZoneHour() != paramGDateSpecification1.getTimeZoneHour() || paramGDateSpecification2.getTimeZoneMinute() != paramGDateSpecification1.getTimeZoneMinute() || paramGDateSpecification2.getTimeZoneSign() != paramGDateSpecification1.getTimeZoneSign())) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1209 */         paramGDateSpecification2 = new GDateBuilder(paramGDateSpecification2);
/*      */         
/* 1211 */         int j = paramGDateSpecification1.getFlags() & 0xE;
/* 1212 */         if ((j != 0 && j != 14) || !paramGDateSpecification1.hasTime()) {
/*      */ 
/*      */           
/* 1215 */           ((GDateBuilder)paramGDateSpecification2)._setToFirstMoment();
/* 1216 */           paramGDateSpecification1 = new GDateBuilder(paramGDateSpecification1);
/* 1217 */           ((GDateBuilder)paramGDateSpecification1)._setToFirstMoment();
/*      */         } 
/*      */         
/* 1220 */         ((GDateBuilder)paramGDateSpecification2).normalizeToTimeZone(paramGDateSpecification1.getTimeZoneSign(), paramGDateSpecification1.getTimeZoneHour(), paramGDateSpecification1.getTimeZoneMinute());
/*      */       } 
/*      */ 
/*      */       
/* 1224 */       return fieldwiseCompare(paramGDateSpecification1, paramGDateSpecification2);
/*      */     } 
/*      */ 
/*      */     
/* 1228 */     if ((i & 0x1E) != 0) {
/* 1229 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1235 */     if (!paramGDateSpecification1.hasTimeZone()) {
/*      */       
/* 1237 */       int j = compareGDate(paramGDateSpecification2, paramGDateSpecification1);
/* 1238 */       return (j == 2) ? 2 : -j;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1244 */     GDateBuilder gDateBuilder1 = new GDateBuilder(paramGDateSpecification1);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1249 */     if ((paramGDateSpecification1.getFlags() & 0xE) == 12)
/*      */     {
/* 1251 */       if (paramGDateSpecification1.getDay() == 28 && paramGDateSpecification1.getMonth() == 2) {
/*      */         
/* 1253 */         if (paramGDateSpecification2.getDay() == 1 && paramGDateSpecification2.getMonth() == 3)
/*      */         {
/* 1255 */           gDateBuilder1.setDay(29);
/*      */         }
/*      */       }
/* 1258 */       else if (paramGDateSpecification2.getDay() == 28 && paramGDateSpecification2.getMonth() == 2) {
/*      */         
/* 1260 */         if (paramGDateSpecification1.getDay() == 1 && paramGDateSpecification1.getMonth() == 3) {
/*      */           
/* 1262 */           gDateBuilder1.setMonth(2);
/* 1263 */           gDateBuilder1.setDay(29);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1271 */     gDateBuilder1._setToFirstMoment();
/*      */ 
/*      */     
/* 1274 */     GDateBuilder gDateBuilder2 = new GDateBuilder(paramGDateSpecification2);
/* 1275 */     gDateBuilder2._setToFirstMoment();
/* 1276 */     gDateBuilder2.setTimeZone(1, 14, 0);
/* 1277 */     gDateBuilder2.normalizeToTimeZone(paramGDateSpecification1.getTimeZoneSign(), paramGDateSpecification1.getTimeZoneHour(), paramGDateSpecification1.getTimeZoneMinute());
/* 1278 */     if (fieldwiseCompare(gDateBuilder1, gDateBuilder2) == -1) {
/* 1279 */       return -1;
/*      */     }
/*      */     
/* 1282 */     GDateBuilder gDateBuilder3 = gDateBuilder2;
/* 1283 */     gDateBuilder3.setGDate(paramGDateSpecification2);
/* 1284 */     gDateBuilder3._setToFirstMoment();
/* 1285 */     gDateBuilder3.setTimeZone(-1, 14, 0);
/* 1286 */     gDateBuilder3.normalizeToTimeZone(paramGDateSpecification1.getTimeZoneSign(), paramGDateSpecification1.getTimeZoneHour(), paramGDateSpecification1.getTimeZoneMinute());
/* 1287 */     if (fieldwiseCompare(gDateBuilder1, gDateBuilder3) == 1) {
/* 1288 */       return 1;
/*      */     }
/*      */     
/* 1291 */     return 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int fieldwiseCompare(GDateSpecification paramGDateSpecification1, GDateSpecification paramGDateSpecification2) {
/* 1301 */     if (paramGDateSpecification1.hasYear()) {
/*      */       
/* 1303 */       int i = paramGDateSpecification2.getYear();
/* 1304 */       int j = paramGDateSpecification1.getYear();
/* 1305 */       if (j < i) return -1; 
/* 1306 */       if (j > i) return 1; 
/*      */     } 
/* 1308 */     if (paramGDateSpecification1.hasMonth()) {
/*      */       
/* 1310 */       int i = paramGDateSpecification2.getMonth();
/* 1311 */       int j = paramGDateSpecification1.getMonth();
/* 1312 */       if (j < i) return -1; 
/* 1313 */       if (j > i) return 1; 
/*      */     } 
/* 1315 */     if (paramGDateSpecification1.hasDay()) {
/*      */       
/* 1317 */       int i = paramGDateSpecification2.getDay();
/* 1318 */       int j = paramGDateSpecification1.getDay();
/* 1319 */       if (j < i) return -1; 
/* 1320 */       if (j > i) return 1; 
/*      */     } 
/* 1322 */     if (paramGDateSpecification1.hasTime()) {
/*      */       
/* 1324 */       int i = paramGDateSpecification2.getHour();
/* 1325 */       int j = paramGDateSpecification1.getHour();
/* 1326 */       if (j < i) return -1; 
/* 1327 */       if (j > i) return 1; 
/* 1328 */       int k = paramGDateSpecification2.getMinute();
/* 1329 */       int m = paramGDateSpecification1.getMinute();
/* 1330 */       if (m < k) return -1; 
/* 1331 */       if (m > k) return 1; 
/* 1332 */       int n = paramGDateSpecification2.getSecond();
/* 1333 */       int i1 = paramGDateSpecification1.getSecond();
/* 1334 */       if (i1 < n) return -1; 
/* 1335 */       if (i1 > n) return 1; 
/* 1336 */       BigDecimal bigDecimal1 = paramGDateSpecification2.getFraction();
/* 1337 */       BigDecimal bigDecimal2 = paramGDateSpecification1.getFraction();
/* 1338 */       if (bigDecimal2 == null && bigDecimal1 == null) return 0; 
/* 1339 */       return ((bigDecimal2 == null) ? GDate._zero : bigDecimal2).compareTo((bigDecimal1 == null) ? GDate._zero : bigDecimal1);
/*      */     } 
/*      */     
/* 1342 */     return 0;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getBuiltinTypeCode() {
/* 1364 */     return btcForFlags(this._bits);
/*      */   }
/*      */ 
/*      */   
/*      */   static int btcForFlags(int paramInt) {
/* 1369 */     switch (paramInt & 0x1E) {
/*      */       
/*      */       case 2:
/* 1372 */         return 18;
/*      */       case 6:
/* 1374 */         return 17;
/*      */       case 4:
/* 1376 */         return 21;
/*      */       case 12:
/* 1378 */         return 19;
/*      */       case 8:
/* 1380 */         return 20;
/*      */       case 14:
/* 1382 */         return 16;
/*      */       case 30:
/* 1384 */         return 14;
/*      */       case 16:
/* 1386 */         return 15;
/*      */     } 
/* 1388 */     return 0;
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
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBuiltinTypeCode(int paramInt) {
/* 1408 */     switch (paramInt) {
/*      */ 
/*      */       
/*      */       case 18:
/* 1412 */         clearMonth();
/* 1413 */         clearDay();
/* 1414 */         clearTime();
/*      */         return;
/*      */       
/*      */       case 17:
/* 1418 */         clearDay();
/* 1419 */         clearTime();
/*      */         return;
/*      */       
/*      */       case 21:
/* 1423 */         clearYear();
/* 1424 */         clearDay();
/* 1425 */         clearTime();
/*      */         return;
/*      */       
/*      */       case 19:
/* 1429 */         clearYear();
/* 1430 */         clearTime();
/*      */         return;
/*      */       
/*      */       case 20:
/* 1434 */         clearYear();
/* 1435 */         clearMonth();
/* 1436 */         clearTime();
/*      */         return;
/*      */       
/*      */       case 16:
/* 1440 */         clearTime();
/*      */         return;
/*      */       
/*      */       case 14:
/*      */         return;
/*      */       
/*      */       case 15:
/* 1447 */         clearYear();
/* 1448 */         clearMonth();
/* 1449 */         clearDay();
/*      */         return;
/*      */     } 
/* 1452 */     throw new IllegalArgumentException("codeType must be one of SchemaType BTC_  DATE TIME related types.");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/* 1457 */   static final BigInteger TEN = BigInteger.valueOf(10L);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final boolean $assertionsDisabled;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String canonicalString() {
/* 1468 */     boolean bool = (hasTimeZone() && getTimeZoneSign() != 0 && hasTime() && hasDay() == hasMonth() && hasDay() == hasYear()) ? true : false;
/*      */ 
/*      */ 
/*      */     
/* 1472 */     if (!bool && getFraction() != null && getFraction().scale() > 0) {
/*      */       
/* 1474 */       BigInteger bigInteger = getFraction().unscaledValue();
/* 1475 */       bool = (bigInteger.mod(TEN).signum() == 0) ? true : false;
/*      */     } 
/*      */     
/* 1478 */     if (!bool) {
/* 1479 */       return toString();
/*      */     }
/* 1481 */     GDateBuilder gDateBuilder = new GDateBuilder(this);
/* 1482 */     gDateBuilder.normalize();
/* 1483 */     return gDateBuilder.toString();
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
/*      */   public final String toString() {
/* 1500 */     return GDate.formatGDate(this);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\GDateBuilder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */