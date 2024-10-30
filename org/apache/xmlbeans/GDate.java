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
/*      */ public final class GDate
/*      */   implements Serializable, GDateSpecification
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*      */   static final int MAX_YEAR = 292277265;
/*      */   static final int MIN_YEAR = -292275295;
/*      */   private transient String _canonicalString;
/*      */   private transient String _string;
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
/*   66 */   static final BigDecimal _zero = BigDecimal.valueOf(0L);
/*   67 */   static final BigDecimal _one = BigDecimal.valueOf(1L);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GDate(CharSequence paramCharSequence) {
/*   75 */     int i = paramCharSequence.length();
/*   76 */     byte b = 0;
/*   77 */     while (i > 0 && isSpace(paramCharSequence.charAt(i - 1)))
/*   78 */       i--; 
/*   79 */     while (b < i && isSpace(paramCharSequence.charAt(b))) {
/*   80 */       b++;
/*      */     }
/*      */     
/*   83 */     if (i - b >= 1 && paramCharSequence.charAt(i - 1) == 'Z') {
/*      */       
/*   85 */       this._bits |= 0x1;
/*   86 */       i--;
/*      */     } 
/*   88 */     if (i - b >= 6) {
/*      */       int j;
/*      */ 
/*      */       
/*      */       GDateBuilder gDateBuilder;
/*      */       
/*   94 */       if (paramCharSequence.charAt(i - 3) != ':');
/*      */ 
/*      */       
/*   97 */       switch (paramCharSequence.charAt(i - 6)) {
/*      */         
/*      */         case '-':
/*  100 */           j = -1; break;
/*      */         case '+':
/*  102 */           j = 1;
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         default:
/*  121 */           if (b < i && (b + 2 >= i || paramCharSequence.charAt(b + 2) != ':')) {
/*      */             boolean bool1;
/*      */ 
/*      */             
/*  125 */             j = 0;
/*  126 */             if (b < i && paramCharSequence.charAt(b) == '-') {
/*      */               
/*  128 */               j = 1;
/*  129 */               b++;
/*      */             } 
/*      */ 
/*      */             
/*  133 */             int n = 0;
/*  134 */             int i1 = -b;
/*      */             
/*  136 */             boolean bool2 = (b < i && digitVal(paramCharSequence.charAt(b)) == 0) ? true : false;
/*      */ 
/*      */             
/*      */             while (true) {
/*  140 */               bool1 = (b < i) ? paramCharSequence.charAt(b) : false;
/*  141 */               if (!isDigit(bool1)) {
/*      */                 break;
/*      */               }
/*  144 */               if (bool2 && b + i1 >= 4) {
/*  145 */                 throw new IllegalArgumentException("year value starting with zero must be 4 or less digits: " + paramCharSequence);
/*      */               }
/*  147 */               n = n * 10 + digitVal(bool1);
/*  148 */               b++;
/*      */             } 
/*  150 */             i1 += b;
/*  151 */             if (i1 > 9)
/*  152 */               throw new IllegalArgumentException("year too long (up to 9 digits)"); 
/*  153 */             if (i1 >= 4) {
/*      */               
/*  155 */               this._bits |= 0x2;
/*  156 */               this._CY = (j != 0) ? -n : n;
/*  157 */               if (this._CY == 0) throw new IllegalArgumentException("year must not be zero");
/*      */             
/*  159 */             } else if (i1 > 0) {
/*  160 */               throw new IllegalArgumentException("year must be four digits (may pad with zeroes, e.g., 0560)");
/*      */             } 
/*  162 */             if (this._CY > 292277265) {
/*  163 */               throw new IllegalArgumentException("year value not supported: too big, must be less than 292277265");
/*      */             }
/*  165 */             if (this._CY < -292275295) {
/*  166 */               throw new IllegalArgumentException("year values not supported: too small, must be bigger than -292275295");
/*      */             }
/*      */             
/*  169 */             if (bool1 != 45) {
/*      */               
/*  171 */               if (j != 0 && !hasYear()) {
/*  172 */                 throw new IllegalArgumentException();
/*      */               }
/*      */             } else {
/*      */               
/*  176 */               b++;
/*      */ 
/*      */               
/*  179 */               if (i - b >= 2) {
/*      */                 
/*  181 */                 n = twoDigit(paramCharSequence, b);
/*  182 */                 if (n >= 1 && n <= 12) {
/*      */                   
/*  184 */                   this._bits |= 0x4;
/*  185 */                   this._M = n;
/*  186 */                   b += 2;
/*      */                 } 
/*      */               } 
/*      */ 
/*      */               
/*  191 */               bool1 = (b < i) ? paramCharSequence.charAt(b) : false;
/*  192 */               if (bool1 != 45) {
/*      */                 
/*  194 */                 if (!hasMonth()) {
/*  195 */                   throw new IllegalArgumentException();
/*      */                 }
/*      */               } else {
/*      */                 
/*  199 */                 b++;
/*      */ 
/*      */                 
/*  202 */                 if (i - b >= 2) {
/*      */                   
/*  204 */                   n = twoDigit(paramCharSequence, b);
/*  205 */                   if (n >= 1 && n <= 31) {
/*      */                     
/*  207 */                     this._bits |= 0x8;
/*  208 */                     this._D = n;
/*  209 */                     b += 2;
/*      */                   } 
/*      */                 } 
/*      */                 
/*  213 */                 if (!hasDay())
/*      */                 {
/*      */                   
/*  216 */                   if (hasMonth() && !hasYear())
/*      */                   
/*  218 */                   { bool1 = (b < i) ? paramCharSequence.charAt(b) : false;
/*  219 */                     if (bool1 == 45)
/*      */                     
/*  221 */                     { b++; }
/*      */                     
/*      */                     else
/*      */                     
/*  225 */                     { throw new IllegalArgumentException(); }  } else { throw new IllegalArgumentException(); }
/*      */                    } 
/*      */               } 
/*      */             } 
/*      */           } 
/*  230 */           if (b < i) {
/*      */             
/*  232 */             if (hasYear() || hasMonth() || hasDay()) {
/*      */               
/*  234 */               if (paramCharSequence.charAt(b) != 'T')
/*  235 */                 throw new IllegalArgumentException("date and time must be separated by 'T'"); 
/*  236 */               b++;
/*      */             } 
/*      */             
/*  239 */             if (i < b + 8 || paramCharSequence.charAt(b + 2) != ':' || paramCharSequence.charAt(b + 5) != ':') {
/*  240 */               throw new IllegalArgumentException();
/*      */             }
/*  242 */             j = twoDigit(paramCharSequence, b);
/*  243 */             if (j > 24)
/*  244 */               throw new IllegalArgumentException("hour must be between 00 and 23"); 
/*  245 */             int n = twoDigit(paramCharSequence, b + 3);
/*  246 */             if (n >= 60)
/*  247 */               throw new IllegalArgumentException("minute must be between 00 and 59"); 
/*  248 */             int i1 = twoDigit(paramCharSequence, b + 6);
/*  249 */             if (i1 >= 60) {
/*  250 */               throw new IllegalArgumentException("second must be between 00 and 59");
/*      */             }
/*  252 */             b += 8;
/*      */             
/*  254 */             BigDecimal bigDecimal = _zero;
/*  255 */             if (b < i) {
/*      */               
/*  257 */               if (paramCharSequence.charAt(b) != '.')
/*  258 */                 throw new IllegalArgumentException(); 
/*  259 */               if (b + 1 < i) {
/*      */                 
/*  261 */                 for (int i2 = b + 1; i2 < i; i2++) {
/*      */                   
/*  263 */                   if (!isDigit(paramCharSequence.charAt(i2))) {
/*  264 */                     throw new IllegalArgumentException();
/*      */                   }
/*      */                 } 
/*      */                 try {
/*  268 */                   bigDecimal = new BigDecimal(paramCharSequence.subSequence(b, i).toString());
/*      */                 }
/*  270 */                 catch (Throwable throwable) {
/*      */                   
/*  272 */                   throw new IllegalArgumentException();
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             
/*  277 */             this._bits |= 0x10;
/*  278 */             this._h = j;
/*  279 */             this._m = n;
/*  280 */             this._s = i1;
/*  281 */             this._fs = bigDecimal;
/*      */           } 
/*      */           
/*  284 */           if (hasTime() && this._h == 24) {
/*      */             
/*  286 */             if (this._m != 0 || this._s != 0 || this._fs.compareTo(_zero) != 0) {
/*  287 */               throw new IllegalArgumentException("if hour is 24, minutes, seconds and fraction must be 0");
/*      */             }
/*      */             
/*  290 */             if (hasDate()) {
/*      */               
/*  292 */               gDateBuilder = new GDateBuilder(this._CY, this._M, this._D, this._h, this._m, this._s, this._fs, this._tzsign, this._tzh, this._tzm);
/*  293 */               gDateBuilder.normalize24h();
/*      */               
/*  295 */               this._D = gDateBuilder.getDay();
/*  296 */               this._M = gDateBuilder.getMonth();
/*  297 */               this._CY = gDateBuilder.getYear();
/*  298 */               this._h = 0;
/*      */             }
/*  300 */             else if (hasDay()) {
/*      */               
/*  302 */               this._D++;
/*  303 */               this._h = 0;
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/*  308 */           if (!isValid()) {
/*  309 */             throw new IllegalArgumentException("invalid date");
/*      */           }
/*      */           return;
/*      */       } 
/*      */       int k = twoDigit(paramCharSequence, i - 5);
/*      */       int m = twoDigit(paramCharSequence, i - 2);
/*      */       if (k > 14) {
/*      */         throw new IllegalArgumentException("time zone hour must be two digits between -14 and +14");
/*      */       }
/*      */       if (m > 59) {
/*      */         throw new IllegalArgumentException("time zone minute must be two digits between 00 and 59");
/*      */       }
/*      */       this._bits |= 0x1;
/*      */       this._tzsign = gDateBuilder;
/*      */       this._tzh = k;
/*      */       this._tzm = m;
/*      */       i -= 6;
/*      */     } 
/*      */   }
/*      */   
/*      */   public GDate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, BigDecimal paramBigDecimal) {
/*  330 */     this._bits = 30;
/*      */     
/*  332 */     this._CY = paramInt1;
/*  333 */     this._M = paramInt2;
/*  334 */     this._D = paramInt3;
/*  335 */     this._h = paramInt4;
/*  336 */     this._m = paramInt5;
/*  337 */     this._s = paramInt6;
/*  338 */     this._fs = (paramBigDecimal == null) ? _zero : paramBigDecimal;
/*      */     
/*  340 */     if (!isValid()) {
/*  341 */       throw new IllegalArgumentException();
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
/*      */   public GDate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, BigDecimal paramBigDecimal, int paramInt7, int paramInt8, int paramInt9) {
/*  364 */     this._bits = 31;
/*      */     
/*  366 */     this._CY = paramInt1;
/*  367 */     this._M = paramInt2;
/*  368 */     this._D = paramInt3;
/*  369 */     this._h = paramInt4;
/*  370 */     this._m = paramInt5;
/*  371 */     this._s = paramInt6;
/*  372 */     this._fs = (paramBigDecimal == null) ? _zero : paramBigDecimal;
/*  373 */     this._tzsign = paramInt7;
/*  374 */     this._tzh = paramInt8;
/*  375 */     this._tzm = paramInt9;
/*      */     
/*  377 */     if (!isValid()) {
/*  378 */       throw new IllegalArgumentException();
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
/*      */   public GDate(Date paramDate) {
/*  393 */     this(new GDateBuilder(paramDate));
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
/*      */   public GDate(Calendar paramCalendar) {
/*  410 */     boolean bool1 = paramCalendar.isSet(1);
/*  411 */     boolean bool2 = paramCalendar.isSet(0);
/*  412 */     boolean bool3 = paramCalendar.isSet(2);
/*  413 */     boolean bool4 = paramCalendar.isSet(5);
/*  414 */     boolean bool5 = paramCalendar.isSet(11);
/*  415 */     boolean bool6 = paramCalendar.isSet(10);
/*  416 */     boolean bool7 = paramCalendar.isSet(9);
/*  417 */     boolean bool8 = paramCalendar.isSet(12);
/*  418 */     boolean bool9 = paramCalendar.isSet(13);
/*  419 */     boolean bool10 = paramCalendar.isSet(14);
/*  420 */     boolean bool11 = paramCalendar.isSet(15);
/*  421 */     boolean bool12 = paramCalendar.isSet(16);
/*      */     
/*  423 */     if (bool1) {
/*      */       
/*  425 */       int m = paramCalendar.get(1);
/*  426 */       if (bool2 && paramCalendar instanceof java.util.GregorianCalendar && 
/*  427 */         paramCalendar.get(0) == 0)
/*  428 */         m = -m; 
/*  429 */       this._bits |= 0x2;
/*  430 */       this._CY = m;
/*      */     } 
/*  432 */     if (bool3) {
/*      */       
/*  434 */       this._bits |= 0x4;
/*  435 */       this._M = paramCalendar.get(2) + 1;
/*      */     } 
/*  437 */     if (bool4) {
/*      */       
/*  439 */       this._bits |= 0x8;
/*  440 */       this._D = paramCalendar.get(5);
/*      */     } 
/*  442 */     boolean bool = false;
/*      */     
/*  444 */     int i = 0;
/*  445 */     int j = 0;
/*  446 */     int k = 0;
/*  447 */     BigDecimal bigDecimal = _zero;
/*      */     
/*  449 */     if (bool5) {
/*      */       
/*  451 */       i = paramCalendar.get(11);
/*  452 */       bool = true;
/*      */     }
/*  454 */     else if (bool6 && bool7) {
/*      */       
/*  456 */       i = paramCalendar.get(10) + paramCalendar.get(9) * 12;
/*  457 */       bool = true;
/*      */     } 
/*      */     
/*  460 */     if (bool8) {
/*      */       
/*  462 */       j = paramCalendar.get(12);
/*  463 */       bool = true;
/*      */     } 
/*      */     
/*  466 */     if (bool9) {
/*      */       
/*  468 */       k = paramCalendar.get(13);
/*  469 */       bool = true;
/*      */     } 
/*      */     
/*  472 */     if (bool10) {
/*      */       
/*  474 */       bigDecimal = BigDecimal.valueOf(paramCalendar.get(14), 3);
/*  475 */       bool = true;
/*      */     } 
/*      */     
/*  478 */     if (bool) {
/*      */       
/*  480 */       this._bits |= 0x10;
/*  481 */       this._h = i;
/*  482 */       this._m = j;
/*  483 */       this._s = k;
/*  484 */       this._fs = bigDecimal;
/*      */     } 
/*      */     
/*  487 */     if (bool11) {
/*      */       
/*  489 */       int m = paramCalendar.get(15);
/*  490 */       if (bool12) {
/*  491 */         m += paramCalendar.get(16);
/*      */       }
/*  493 */       this._bits |= 0x1;
/*  494 */       if (m == 0) {
/*      */         
/*  496 */         this._tzsign = 0;
/*  497 */         this._tzh = 0;
/*  498 */         this._tzm = 0;
/*  499 */         TimeZone timeZone = paramCalendar.getTimeZone();
/*  500 */         String str = timeZone.getID();
/*  501 */         if (str != null && str.length() > 3) switch (str.charAt(3)) {
/*      */             case '+':
/*  503 */               this._tzsign = 1; break;
/*  504 */             case '-': this._tzsign = -1;
/*      */               break;
/*      */           } 
/*      */       
/*      */       } else {
/*  509 */         this._tzsign = (m < 0) ? -1 : 1;
/*  510 */         m *= this._tzsign;
/*  511 */         this._tzh = m / 3600000;
/*  512 */         this._tzm = (m - this._tzh * 3600000) / 60000;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GDate(GDateSpecification paramGDateSpecification) {
/*  522 */     if (paramGDateSpecification.hasTimeZone()) {
/*      */       
/*  524 */       this._bits |= 0x1;
/*  525 */       this._tzsign = paramGDateSpecification.getTimeZoneSign();
/*  526 */       this._tzh = paramGDateSpecification.getTimeZoneHour();
/*  527 */       this._tzm = paramGDateSpecification.getTimeZoneMinute();
/*      */     } 
/*      */     
/*  530 */     if (paramGDateSpecification.hasTime()) {
/*      */       
/*  532 */       this._bits |= 0x10;
/*  533 */       this._h = paramGDateSpecification.getHour();
/*  534 */       this._m = paramGDateSpecification.getMinute();
/*  535 */       this._s = paramGDateSpecification.getSecond();
/*  536 */       this._fs = paramGDateSpecification.getFraction();
/*      */     } 
/*      */     
/*  539 */     if (paramGDateSpecification.hasDay()) {
/*      */       
/*  541 */       this._bits |= 0x8;
/*  542 */       this._D = paramGDateSpecification.getDay();
/*      */     } 
/*      */     
/*  545 */     if (paramGDateSpecification.hasMonth()) {
/*      */       
/*  547 */       this._bits |= 0x4;
/*  548 */       this._M = paramGDateSpecification.getMonth();
/*      */     } 
/*      */     
/*  551 */     if (paramGDateSpecification.hasYear()) {
/*      */       
/*  553 */       this._bits |= 0x2;
/*  554 */       this._CY = paramGDateSpecification.getYear();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   static final boolean isDigit(char paramChar) {
/*  560 */     return ((char)(paramChar - 48) <= '\t');
/*      */   }
/*      */ 
/*      */   
/*      */   static final boolean isSpace(char paramChar) {
/*  565 */     switch (paramChar) {
/*      */       
/*      */       case '\t':
/*      */       case '\n':
/*      */       case '\r':
/*      */       case ' ':
/*  571 */         return true;
/*      */     } 
/*  573 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static final int digitVal(char paramChar) {
/*  579 */     return paramChar - 48;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final int twoDigit(CharSequence paramCharSequence, int paramInt) {
/*  584 */     char c1 = paramCharSequence.charAt(paramInt);
/*  585 */     char c2 = paramCharSequence.charAt(paramInt + 1);
/*  586 */     if (!isDigit(c1) || !isDigit(c2))
/*  587 */       return 100; 
/*  588 */     return digitVal(c1) * 10 + digitVal(c2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isImmutable() {
/*  596 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFlags() {
/*  606 */     return this._bits;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasTimeZone() {
/*  613 */     return ((this._bits & 0x1) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasYear() {
/*  619 */     return ((this._bits & 0x2) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasMonth() {
/*  625 */     return ((this._bits & 0x4) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasDay() {
/*  631 */     return ((this._bits & 0x8) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasTime() {
/*  637 */     return ((this._bits & 0x10) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean hasDate() {
/*  643 */     return ((this._bits & 0xE) == 14);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getYear() {
/*  649 */     return this._CY;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getMonth() {
/*  655 */     return this._M;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getDay() {
/*  661 */     return this._D;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getHour() {
/*  667 */     return this._h;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getMinute() {
/*  673 */     return this._m;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getSecond() {
/*  679 */     return this._s;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final BigDecimal getFraction() {
/*  685 */     return this._fs;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getTimeZoneSign() {
/*  692 */     return this._tzsign;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getTimeZoneHour() {
/*  701 */     return this._tzh;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getTimeZoneMinute() {
/*  710 */     return this._tzm;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMillisecond() {
/*  717 */     if (this._fs == null)
/*  718 */       return 0; 
/*  719 */     return this._fs.setScale(3, 1).unscaledValue().intValue();
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
/*      */   public String canonicalString() {
/*  731 */     ensureCanonicalString();
/*  732 */     return this._canonicalString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isValid() {
/*  741 */     return GDateBuilder.isValidGDate(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getJulianDate() {
/*  751 */     return GDateBuilder.julianDateForGDate(this);
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
/*      */   public XmlCalendar getCalendar() {
/*  769 */     return new XmlCalendar(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDate() {
/*  779 */     return GDateBuilder.dateForGDate(this);
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
/*      */   public int compareToGDate(GDateSpecification paramGDateSpecification) {
/*  795 */     return GDateBuilder.compareGDate(this, paramGDateSpecification);
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
/*      */   public int getBuiltinTypeCode() {
/*  817 */     return GDateBuilder.btcForFlags(this._bits);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GDate add(GDurationSpecification paramGDurationSpecification) {
/*  825 */     GDateBuilder gDateBuilder = new GDateBuilder(this);
/*  826 */     gDateBuilder.addGDuration(paramGDurationSpecification);
/*  827 */     return gDateBuilder.toGDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GDate subtract(GDurationSpecification paramGDurationSpecification) {
/*  835 */     GDateBuilder gDateBuilder = new GDateBuilder(this);
/*  836 */     gDateBuilder.subtractGDuration(paramGDurationSpecification);
/*  837 */     return gDateBuilder.toGDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/*  846 */     if (paramObject == this)
/*  847 */       return true; 
/*  848 */     if (!(paramObject instanceof GDate)) {
/*  849 */       return false;
/*      */     }
/*  851 */     ensureCanonicalString();
/*  852 */     return this._canonicalString.equals(((GDate)paramObject).canonicalString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  860 */     ensureCanonicalString();
/*  861 */     return this._canonicalString.hashCode();
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
/*      */   private void ensureCanonicalString() {
/*  873 */     if (this._canonicalString != null) {
/*      */       return;
/*      */     }
/*  876 */     boolean bool = (hasTimeZone() && getTimeZoneSign() != 0 && hasTime() && hasDay() == hasMonth() && hasDay() == hasYear()) ? true : false;
/*      */ 
/*      */ 
/*      */     
/*  880 */     if (!bool && getFraction() != null && getFraction().scale() > 0) {
/*      */       
/*  882 */       BigInteger bigInteger = getFraction().unscaledValue();
/*  883 */       bool = (bigInteger.mod(GDateBuilder.TEN).signum() == 0) ? true : false;
/*      */     } 
/*      */     
/*  886 */     if (!bool) {
/*  887 */       this._canonicalString = toString();
/*      */     } else {
/*      */       
/*  890 */       GDateBuilder gDateBuilder = new GDateBuilder(this);
/*  891 */       gDateBuilder.normalize();
/*  892 */       this._canonicalString = gDateBuilder.toString();
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
/*      */   public String toString() {
/*  910 */     if (this._string == null)
/*  911 */       this._string = formatGDate(this); 
/*  912 */     return this._string;
/*      */   }
/*      */   
/*  915 */   private static final char[] _tensDigit = new char[] { '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9' };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  928 */   private static final char[] _onesDigit = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int _padTwoAppend(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  944 */     assert paramInt2 >= 0 && paramInt2 < 100;
/*  945 */     paramArrayOfchar[paramInt1] = _tensDigit[paramInt2];
/*  946 */     paramArrayOfchar[paramInt1 + 1] = _onesDigit[paramInt2];
/*  947 */     return paramInt1 + 2;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final int _padFourAppend(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  952 */     if (paramInt2 < 0) {
/*      */       
/*  954 */       paramArrayOfchar[paramInt1++] = '-';
/*  955 */       paramInt2 = -paramInt2;
/*      */     } 
/*  957 */     if (paramInt2 >= 10000) {
/*      */       
/*  959 */       String str = Integer.toString(paramInt2);
/*  960 */       str.getChars(0, str.length(), paramArrayOfchar, paramInt1);
/*  961 */       return paramInt1 + str.length();
/*      */     } 
/*  963 */     int i = paramInt2 / 100;
/*  964 */     int j = paramInt2 - i * 100;
/*  965 */     paramArrayOfchar[paramInt1] = _tensDigit[i];
/*  966 */     paramArrayOfchar[paramInt1 + 1] = _onesDigit[i];
/*  967 */     paramArrayOfchar[paramInt1 + 2] = _tensDigit[j];
/*  968 */     paramArrayOfchar[paramInt1 + 3] = _onesDigit[j];
/*  969 */     return paramInt1 + 4;
/*      */   }
/*      */   
/*  972 */   private static final TimeZone GMTZONE = TimeZone.getTimeZone("GMT");
/*  973 */   private static final TimeZone[] MINUSZONE = new TimeZone[] { TimeZone.getTimeZone("GMT-00:00"), TimeZone.getTimeZone("GMT-01:00"), TimeZone.getTimeZone("GMT-02:00"), TimeZone.getTimeZone("GMT-03:00"), TimeZone.getTimeZone("GMT-04:00"), TimeZone.getTimeZone("GMT-05:00"), TimeZone.getTimeZone("GMT-06:00"), TimeZone.getTimeZone("GMT-07:00"), TimeZone.getTimeZone("GMT-08:00"), TimeZone.getTimeZone("GMT-09:00"), TimeZone.getTimeZone("GMT-10:00"), TimeZone.getTimeZone("GMT-11:00"), TimeZone.getTimeZone("GMT-12:00"), TimeZone.getTimeZone("GMT-13:00"), TimeZone.getTimeZone("GMT-14:00") };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  991 */   private static final TimeZone[] PLUSZONE = new TimeZone[] { TimeZone.getTimeZone("GMT+00:00"), TimeZone.getTimeZone("GMT+01:00"), TimeZone.getTimeZone("GMT+02:00"), TimeZone.getTimeZone("GMT+03:00"), TimeZone.getTimeZone("GMT+04:00"), TimeZone.getTimeZone("GMT+05:00"), TimeZone.getTimeZone("GMT+06:00"), TimeZone.getTimeZone("GMT+07:00"), TimeZone.getTimeZone("GMT+08:00"), TimeZone.getTimeZone("GMT+09:00"), TimeZone.getTimeZone("GMT+10:00"), TimeZone.getTimeZone("GMT+11:00"), TimeZone.getTimeZone("GMT+12:00"), TimeZone.getTimeZone("GMT+13:00"), TimeZone.getTimeZone("GMT+14:00") };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final boolean $assertionsDisabled;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final TimeZone timeZoneForGDate(GDateSpecification paramGDateSpecification) {
/* 1013 */     if (!paramGDateSpecification.hasTimeZone())
/* 1014 */       return TimeZone.getDefault(); 
/* 1015 */     if (paramGDateSpecification.getTimeZoneSign() == 0)
/* 1016 */       return GMTZONE; 
/* 1017 */     if (paramGDateSpecification.getTimeZoneMinute() == 0 && paramGDateSpecification.getTimeZoneHour() <= 14 && paramGDateSpecification.getTimeZoneHour() >= 0) {
/* 1018 */       return (paramGDateSpecification.getTimeZoneSign() < 0) ? MINUSZONE[paramGDateSpecification.getTimeZoneHour()] : PLUSZONE[paramGDateSpecification.getTimeZoneHour()];
/*      */     }
/* 1020 */     char[] arrayOfChar = new char[9];
/* 1021 */     arrayOfChar[0] = 'G';
/* 1022 */     arrayOfChar[1] = 'M';
/* 1023 */     arrayOfChar[2] = 'T';
/* 1024 */     arrayOfChar[3] = (paramGDateSpecification.getTimeZoneSign() < 0) ? '-' : '+';
/* 1025 */     _padTwoAppend(arrayOfChar, 4, paramGDateSpecification.getTimeZoneHour());
/* 1026 */     arrayOfChar[6] = ':';
/* 1027 */     _padTwoAppend(arrayOfChar, 7, paramGDateSpecification.getTimeZoneMinute());
/* 1028 */     return TimeZone.getTimeZone(new String(arrayOfChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String formatGDate(GDateSpecification paramGDateSpecification) {
/* 1036 */     BigDecimal bigDecimal = paramGDateSpecification.getFraction();
/* 1037 */     char[] arrayOfChar = new char[33 + ((bigDecimal == null) ? 0 : bigDecimal.scale())];
/* 1038 */     int i = 0;
/*      */     
/* 1040 */     if (paramGDateSpecification.hasYear() || paramGDateSpecification.hasMonth() || paramGDateSpecification.hasDay()) {
/*      */ 
/*      */       
/* 1043 */       if (paramGDateSpecification.hasYear()) {
/* 1044 */         i = _padFourAppend(arrayOfChar, 0, paramGDateSpecification.getYear());
/*      */       } else {
/* 1046 */         arrayOfChar[i++] = '-';
/*      */       } 
/* 1048 */       if (paramGDateSpecification.hasMonth() || paramGDateSpecification.hasDay()) {
/*      */ 
/*      */         
/* 1051 */         arrayOfChar[i++] = '-';
/* 1052 */         if (paramGDateSpecification.hasMonth()) {
/* 1053 */           i = _padTwoAppend(arrayOfChar, i, paramGDateSpecification.getMonth());
/*      */         }
/* 1055 */         if (paramGDateSpecification.hasDay()) {
/*      */ 
/*      */           
/* 1058 */           arrayOfChar[i++] = '-';
/* 1059 */           i = _padTwoAppend(arrayOfChar, i, paramGDateSpecification.getDay());
/*      */         } 
/*      */       } 
/* 1062 */       if (paramGDateSpecification.hasTime()) {
/* 1063 */         arrayOfChar[i++] = 'T';
/*      */       }
/*      */     } 
/* 1066 */     if (paramGDateSpecification.hasTime()) {
/*      */       
/* 1068 */       i = _padTwoAppend(arrayOfChar, i, paramGDateSpecification.getHour());
/* 1069 */       arrayOfChar[i++] = ':';
/* 1070 */       i = _padTwoAppend(arrayOfChar, i, paramGDateSpecification.getMinute());
/* 1071 */       arrayOfChar[i++] = ':';
/* 1072 */       i = _padTwoAppend(arrayOfChar, i, paramGDateSpecification.getSecond());
/* 1073 */       if (bigDecimal != _zero) {
/*      */         
/* 1075 */         String str = bigDecimal.toString();
/* 1076 */         int j = str.indexOf('.');
/* 1077 */         if (j >= 0) {
/*      */           
/* 1079 */           str.getChars(j, str.length(), arrayOfChar, i);
/* 1080 */           i += str.length() - j;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1085 */     if (paramGDateSpecification.hasTimeZone())
/*      */     {
/* 1087 */       if (paramGDateSpecification.getTimeZoneSign() == 0) {
/*      */         
/* 1089 */         arrayOfChar[i++] = 'Z';
/*      */       }
/*      */       else {
/*      */         
/* 1093 */         arrayOfChar[i++] = (paramGDateSpecification.getTimeZoneSign() > 0) ? '+' : '-';
/* 1094 */         i = _padTwoAppend(arrayOfChar, i, paramGDateSpecification.getTimeZoneHour());
/* 1095 */         arrayOfChar[i++] = ':';
/* 1096 */         i = _padTwoAppend(arrayOfChar, i, paramGDateSpecification.getTimeZoneMinute());
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 1101 */     return new String(arrayOfChar, 0, i);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\GDate.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */