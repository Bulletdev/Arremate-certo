/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GDurationBuilder
/*     */   implements Serializable, GDurationSpecification
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int _sign;
/*     */   private int _CY;
/*     */   private int _M;
/*     */   private int _D;
/*     */   private int _h;
/*     */   private int _m;
/*     */   private int _s;
/*     */   private BigDecimal _fs;
/*     */   
/*     */   public GDurationBuilder() {
/*  42 */     this._sign = 1;
/*  43 */     this._fs = GDate._zero;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDurationBuilder(String paramString) {
/*  52 */     this(new GDuration(paramString));
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
/*     */   public GDurationBuilder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, BigDecimal paramBigDecimal) {
/*  72 */     if (paramInt1 != 1 && paramInt1 != -1)
/*  73 */       throw new IllegalArgumentException(); 
/*  74 */     this._sign = paramInt1;
/*  75 */     this._CY = paramInt2;
/*  76 */     this._M = paramInt3;
/*  77 */     this._D = paramInt4;
/*  78 */     this._h = paramInt5;
/*  79 */     this._m = paramInt6;
/*  80 */     this._s = paramInt7;
/*  81 */     this._fs = (paramBigDecimal == null) ? GDate._zero : paramBigDecimal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDurationBuilder(GDurationSpecification paramGDurationSpecification) {
/*  89 */     this._sign = paramGDurationSpecification.getSign();
/*  90 */     this._CY = paramGDurationSpecification.getYear();
/*  91 */     this._M = paramGDurationSpecification.getMonth();
/*  92 */     this._D = paramGDurationSpecification.getDay();
/*  93 */     this._h = paramGDurationSpecification.getHour();
/*  94 */     this._m = paramGDurationSpecification.getMinute();
/*  95 */     this._s = paramGDurationSpecification.getSecond();
/*  96 */     this._fs = paramGDurationSpecification.getFraction();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 105 */     return new GDurationBuilder(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDuration toGDuration() {
/* 113 */     return new GDuration(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addGDuration(GDurationSpecification paramGDurationSpecification) {
/* 122 */     int i = this._sign * paramGDurationSpecification.getSign();
/* 123 */     _add(paramGDurationSpecification, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void subtractGDuration(GDurationSpecification paramGDurationSpecification) {
/* 132 */     int i = -this._sign * paramGDurationSpecification.getSign();
/* 133 */     _add(paramGDurationSpecification, i);
/*     */   }
/*     */ 
/*     */   
/*     */   private void _add(GDurationSpecification paramGDurationSpecification, int paramInt) {
/* 138 */     this._CY += paramInt * paramGDurationSpecification.getYear();
/* 139 */     this._M += paramInt * paramGDurationSpecification.getMonth();
/* 140 */     this._D += paramInt * paramGDurationSpecification.getDay();
/* 141 */     this._h += paramInt * paramGDurationSpecification.getHour();
/* 142 */     this._m += paramInt * paramGDurationSpecification.getMinute();
/* 143 */     this._s += paramInt * paramGDurationSpecification.getSecond();
/*     */     
/* 145 */     if (paramGDurationSpecification.getFraction().signum() == 0) {
/*     */       return;
/*     */     }
/* 148 */     if (this._fs.signum() == 0 && paramInt == 1) {
/* 149 */       this._fs = paramGDurationSpecification.getFraction();
/*     */     } else {
/* 151 */       this._fs = (paramInt > 0) ? this._fs.add(paramGDurationSpecification.getFraction()) : this._fs.subtract(paramGDurationSpecification.getFraction());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setSign(int paramInt) {
/* 161 */     if (paramInt != 1 && paramInt != -1)
/* 162 */       throw new IllegalArgumentException(); 
/* 163 */     this._sign = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setYear(int paramInt) {
/* 170 */     this._CY = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMonth(int paramInt) {
/* 176 */     this._M = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDay(int paramInt) {
/* 182 */     this._D = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHour(int paramInt) {
/* 188 */     this._h = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinute(int paramInt) {
/* 194 */     this._m = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecond(int paramInt) {
/* 200 */     this._s = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFraction(BigDecimal paramBigDecimal) {
/* 206 */     this._fs = (paramBigDecimal == null) ? GDate._zero : paramBigDecimal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isImmutable() {
/* 213 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSign() {
/* 224 */     return this._sign;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getYear() {
/* 230 */     return this._CY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMonth() {
/* 236 */     return this._M;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getDay() {
/* 242 */     return this._D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getHour() {
/* 248 */     return this._h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMinute() {
/* 254 */     return this._m;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSecond() {
/* 260 */     return this._s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getFraction() {
/* 267 */     return this._fs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/* 275 */     return isValidDuration(this);
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
/*     */   public void normalize() {
/* 300 */     _normalizeImpl(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long _fQuotient(long paramLong, int paramInt) {
/* 308 */     if (((paramLong < 0L) ? true : false) == ((paramInt < 0) ? true : false)) {
/* 309 */       return paramLong / paramInt;
/*     */     }
/* 311 */     return -((paramInt - paramLong - 1L) / paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int _mod(long paramLong1, int paramInt, long paramLong2) {
/* 319 */     return (int)(paramLong1 - paramLong2 * paramInt);
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
/*     */   private void _normalizeImpl(boolean paramBoolean) {
/* 333 */     if (this._M < 0 || this._M > 11) {
/*     */       
/* 335 */       long l1 = this._M;
/* 336 */       long l2 = _fQuotient(l1, 12);
/* 337 */       this._M = _mod(l1, 12, l2);
/* 338 */       this._CY = (int)(this._CY + l2);
/*     */     } 
/*     */     
/* 341 */     long l = 0L;
/*     */ 
/*     */     
/* 344 */     if (this._fs != null && (this._fs.signum() < 0 || this._fs.compareTo(GDate._one) >= 0)) {
/*     */       
/* 346 */       BigDecimal bigDecimal = this._fs.setScale(0, 3);
/* 347 */       this._fs = this._fs.subtract(bigDecimal);
/* 348 */       l = bigDecimal.intValue();
/*     */     } 
/*     */     
/* 351 */     if (l != 0L || this._s < 0 || this._s > 59 || this._m < 0 || this._m > 50 || this._h < 0 || this._h > 23) {
/*     */ 
/*     */       
/* 354 */       long l1 = this._s + l;
/* 355 */       l = _fQuotient(l1, 60);
/* 356 */       this._s = _mod(l1, 60, l);
/*     */ 
/*     */       
/* 359 */       l1 = this._m + l;
/* 360 */       l = _fQuotient(l1, 60);
/* 361 */       this._m = _mod(l1, 60, l);
/*     */ 
/*     */       
/* 364 */       l1 = this._h + l;
/* 365 */       l = _fQuotient(l1, 24);
/* 366 */       this._h = _mod(l1, 24, l);
/* 367 */       this._D = (int)(this._D + l);
/*     */     } 
/*     */     
/* 370 */     if (this._CY == 0 && this._M == 0 && this._D == 0 && this._h == 0 && this._m == 0 && this._s == 0 && (this._fs == null || this._fs.signum() == 0)) {
/* 371 */       this._sign = 1;
/*     */     }
/* 373 */     if (paramBoolean && (this._D < 0 || this._CY < 0)) {
/*     */       
/* 375 */       int i = (this._D <= 0 && (this._CY < 0 || (this._CY == 0 && this._M == 0))) ? -this._sign : _getTotalSignSlowly();
/* 376 */       if (i == 2)
/* 377 */         i = (this._CY < 0) ? -this._sign : this._sign; 
/* 378 */       if (i == 0)
/* 379 */         i = 1; 
/* 380 */       if (i != this._sign) {
/*     */         
/* 382 */         this._sign = i;
/* 383 */         this._CY = -this._CY;
/* 384 */         this._M = -this._M;
/* 385 */         this._D = -this._D;
/* 386 */         this._h = -this._h;
/* 387 */         this._m = -this._m;
/* 388 */         this._s = -this._s;
/* 389 */         if (this._fs != null)
/* 390 */           this._fs = this._fs.negate(); 
/*     */       } 
/* 392 */       _normalizeImpl(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isValidDuration(GDurationSpecification paramGDurationSpecification) {
/* 399 */     if (paramGDurationSpecification.getSign() != 1 && paramGDurationSpecification.getSign() != -1) {
/* 400 */       return false;
/*     */     }
/* 402 */     return (paramGDurationSpecification.getYear() >= 0 && paramGDurationSpecification.getMonth() >= 0 && paramGDurationSpecification.getDay() >= 0 && paramGDurationSpecification.getHour() >= 0 && paramGDurationSpecification.getMinute() >= 0 && paramGDurationSpecification.getSecond() >= 0 && paramGDurationSpecification.getFraction().signum() >= 0);
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
/*     */   public final int compareToGDuration(GDurationSpecification paramGDurationSpecification) {
/* 420 */     return compareDurations(this, paramGDurationSpecification);
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
/*     */   public String toString() {
/* 434 */     return formatDuration(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static int compareDurations(GDurationSpecification paramGDurationSpecification1, GDurationSpecification paramGDurationSpecification2) {
/* 440 */     if (paramGDurationSpecification1.getFraction().signum() == 0 && paramGDurationSpecification2.getFraction().signum() == 0) {
/*     */       
/* 442 */       int i = paramGDurationSpecification1.getSign();
/* 443 */       int j = paramGDurationSpecification2.getSign();
/* 444 */       long l1 = i * (paramGDurationSpecification1.getYear() * 12L + paramGDurationSpecification1.getMonth());
/* 445 */       long l2 = j * (paramGDurationSpecification2.getYear() * 12L + paramGDurationSpecification2.getMonth());
/* 446 */       long l3 = i * (((paramGDurationSpecification1.getDay() * 24L + paramGDurationSpecification1.getHour()) * 60L + paramGDurationSpecification1.getMinute()) * 60L + paramGDurationSpecification1.getSecond());
/* 447 */       long l4 = j * (((paramGDurationSpecification2.getDay() * 24L + paramGDurationSpecification2.getHour()) * 60L + paramGDurationSpecification2.getMinute()) * 60L + paramGDurationSpecification2.getSecond());
/* 448 */       if (l1 == l2) {
/*     */         
/* 450 */         if (l3 == l4)
/* 451 */           return 0; 
/* 452 */         if (l3 < l4)
/* 453 */           return -1; 
/* 454 */         if (l3 > l4)
/* 455 */           return 1; 
/*     */       } 
/* 457 */       if (l1 < l2 && l3 - l4 < 2419200L)
/* 458 */         return -1; 
/* 459 */       if (l1 > l2 && l4 - l3 < 2419200L) {
/* 460 */         return 1;
/*     */       }
/*     */     } 
/*     */     
/* 464 */     GDurationBuilder gDurationBuilder = new GDurationBuilder(paramGDurationSpecification1);
/* 465 */     gDurationBuilder.subtractGDuration(paramGDurationSpecification2);
/* 466 */     return gDurationBuilder._getTotalSignSlowly();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 475 */   private static final GDate[] _compDate = new GDate[] { new GDate(1696, 9, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1697, 2, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1903, 3, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1903, 7, 1, 0, 0, 0, null, 0, 0, 0) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int _getTotalSignSlowly() {
/* 495 */     byte b1 = 0;
/* 496 */     byte b2 = 0;
/* 497 */     byte b3 = 0;
/*     */     
/* 499 */     GDateBuilder gDateBuilder = new GDateBuilder();
/* 500 */     for (byte b4 = 0; b4 < _compDate.length; b4++) {
/*     */       
/* 502 */       gDateBuilder.setGDate(_compDate[b4]);
/* 503 */       gDateBuilder.addGDuration(this);
/* 504 */       switch (gDateBuilder.compareToGDate(_compDate[b4])) {
/*     */         
/*     */         case -1:
/* 507 */           b2++; break;
/*     */         case 0:
/* 509 */           b3++; break;
/*     */         case 1:
/* 511 */           b1++;
/*     */           break;
/*     */       } 
/*     */     } 
/* 515 */     if (b1 == _compDate.length)
/* 516 */       return 1; 
/* 517 */     if (b2 == _compDate.length)
/* 518 */       return -1; 
/* 519 */     if (b3 == _compDate.length)
/* 520 */       return 0; 
/* 521 */     return 2;
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
/*     */   static String formatDuration(GDurationSpecification paramGDurationSpecification) {
/* 535 */     StringBuffer stringBuffer = new StringBuffer(30);
/*     */     
/* 537 */     if (paramGDurationSpecification.getSign() < 0) {
/* 538 */       stringBuffer.append('-');
/*     */     }
/* 540 */     stringBuffer.append('P');
/*     */     
/* 542 */     if (paramGDurationSpecification.getYear() != 0) {
/*     */       
/* 544 */       stringBuffer.append(paramGDurationSpecification.getYear());
/* 545 */       stringBuffer.append('Y');
/*     */     } 
/*     */     
/* 548 */     if (paramGDurationSpecification.getMonth() != 0) {
/*     */       
/* 550 */       stringBuffer.append(paramGDurationSpecification.getMonth());
/* 551 */       stringBuffer.append('M');
/*     */     } 
/*     */     
/* 554 */     if (paramGDurationSpecification.getDay() != 0) {
/*     */       
/* 556 */       stringBuffer.append(paramGDurationSpecification.getDay());
/* 557 */       stringBuffer.append('D');
/*     */     } 
/*     */     
/* 560 */     if (paramGDurationSpecification.getHour() != 0 || paramGDurationSpecification.getMinute() != 0 || paramGDurationSpecification.getSecond() != 0 || paramGDurationSpecification.getFraction().signum() != 0)
/*     */     {
/*     */       
/* 563 */       stringBuffer.append('T');
/*     */     }
/*     */     
/* 566 */     if (paramGDurationSpecification.getHour() != 0) {
/*     */       
/* 568 */       stringBuffer.append(paramGDurationSpecification.getHour());
/* 569 */       stringBuffer.append('H');
/*     */     } 
/*     */     
/* 572 */     if (paramGDurationSpecification.getMinute() != 0) {
/*     */       
/* 574 */       stringBuffer.append(paramGDurationSpecification.getMinute());
/* 575 */       stringBuffer.append('M');
/*     */     } 
/*     */     
/* 578 */     if (paramGDurationSpecification.getFraction().signum() != 0) {
/*     */       
/* 580 */       BigDecimal bigDecimal = paramGDurationSpecification.getFraction();
/* 581 */       if (paramGDurationSpecification.getSecond() != 0) {
/* 582 */         bigDecimal = bigDecimal.add(BigDecimal.valueOf(paramGDurationSpecification.getSecond()));
/*     */       }
/* 584 */       stringBuffer.append(stripTrailingZeros(toPlainString(bigDecimal)));
/* 585 */       stringBuffer.append('S');
/*     */     }
/* 587 */     else if (paramGDurationSpecification.getSecond() != 0) {
/*     */       
/* 589 */       stringBuffer.append(paramGDurationSpecification.getSecond());
/* 590 */       stringBuffer.append('S');
/*     */     }
/* 592 */     else if (stringBuffer.length() <= 2) {
/*     */       
/* 594 */       stringBuffer.append("T0S");
/*     */     } 
/* 596 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String toPlainString(BigDecimal paramBigDecimal) {
/* 601 */     BigInteger bigInteger = paramBigDecimal.unscaledValue();
/* 602 */     int i = paramBigDecimal.scale();
/* 603 */     String str = bigInteger.toString();
/* 604 */     if (i == 0) {
/* 605 */       return str;
/*     */     }
/* 607 */     boolean bool = (str.charAt(0) == '-') ? true : false;
/*     */     
/* 609 */     int j = str.length() - i - (bool ? 1 : 0);
/*     */     
/* 611 */     StringBuffer stringBuffer = new StringBuffer(str.length() + 2 + ((j <= 0) ? (-j + 1) : 0));
/* 612 */     if (j <= 0) {
/*     */ 
/*     */       
/* 615 */       if (bool) stringBuffer.append('-'); 
/* 616 */       stringBuffer.append('0').append('.');
/* 617 */       while (j < 0) {
/*     */         
/* 619 */         stringBuffer.append('0');
/* 620 */         j++;
/*     */       } 
/* 622 */       stringBuffer.append(str.substring(bool ? 1 : 0));
/*     */     }
/* 624 */     else if (j < str.length()) {
/*     */ 
/*     */       
/* 627 */       stringBuffer.append(str);
/* 628 */       stringBuffer.insert(j + (bool ? 1 : 0), '.');
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 633 */       stringBuffer.append(str);
/* 634 */       if (!bigInteger.equals(BigInteger.ZERO))
/* 635 */         for (int k = str.length(); k < j; k++)
/* 636 */           stringBuffer.append('0');  
/*     */     } 
/* 638 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String stripTrailingZeros(String paramString) {
/* 643 */     boolean bool = false;
/* 644 */     int i = paramString.length() - 1;
/* 645 */     int j = i;
/*     */     
/* 647 */     while (i >= 0) {
/*     */       
/* 649 */       if (paramString.charAt(i) != '0')
/*     */         break; 
/* 651 */       i--;
/* 652 */       j--;
/*     */     } 
/* 654 */     while (i >= 0) {
/*     */       
/* 656 */       if (paramString.charAt(i) == 'E')
/* 657 */         return paramString; 
/* 658 */       if (paramString.charAt(i) == '.') {
/*     */         
/* 660 */         bool = true;
/*     */         break;
/*     */       } 
/* 663 */       i--;
/*     */     } 
/*     */     
/* 666 */     return bool ? paramString.substring(0, j + 1) : paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\GDurationBuilder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */