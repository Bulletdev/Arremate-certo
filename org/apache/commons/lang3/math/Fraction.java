/*     */ package org.apache.commons.lang3.math;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Fraction
/*     */   extends Number
/*     */   implements Comparable<Fraction>
/*     */ {
/*     */   private static final long serialVersionUID = 65382027393090L;
/*  48 */   public static final Fraction ZERO = new Fraction(0, 1);
/*     */ 
/*     */ 
/*     */   
/*  52 */   public static final Fraction ONE = new Fraction(1, 1);
/*     */ 
/*     */ 
/*     */   
/*  56 */   public static final Fraction ONE_HALF = new Fraction(1, 2);
/*     */ 
/*     */ 
/*     */   
/*  60 */   public static final Fraction ONE_THIRD = new Fraction(1, 3);
/*     */ 
/*     */ 
/*     */   
/*  64 */   public static final Fraction TWO_THIRDS = new Fraction(2, 3);
/*     */ 
/*     */ 
/*     */   
/*  68 */   public static final Fraction ONE_QUARTER = new Fraction(1, 4);
/*     */ 
/*     */ 
/*     */   
/*  72 */   public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
/*     */ 
/*     */ 
/*     */   
/*  76 */   public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
/*     */ 
/*     */ 
/*     */   
/*  80 */   public static final Fraction ONE_FIFTH = new Fraction(1, 5);
/*     */ 
/*     */ 
/*     */   
/*  84 */   public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
/*     */ 
/*     */ 
/*     */   
/*  88 */   public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
/*     */ 
/*     */ 
/*     */   
/*  92 */   public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int numerator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int denominator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   private transient int hashCode = 0;
/*     */ 
/*     */ 
/*     */   
/* 111 */   private transient String toString = null;
/*     */ 
/*     */ 
/*     */   
/* 115 */   private transient String toProperString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Fraction(int paramInt1, int paramInt2) {
/* 126 */     this.numerator = paramInt1;
/* 127 */     this.denominator = paramInt2;
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
/*     */   public static Fraction getFraction(int paramInt1, int paramInt2) {
/* 143 */     if (paramInt2 == 0) {
/* 144 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 146 */     if (paramInt2 < 0) {
/* 147 */       if (paramInt1 == Integer.MIN_VALUE || paramInt2 == Integer.MIN_VALUE) {
/* 148 */         throw new ArithmeticException("overflow: can't negate");
/*     */       }
/* 150 */       paramInt1 = -paramInt1;
/* 151 */       paramInt2 = -paramInt2;
/*     */     } 
/* 153 */     return new Fraction(paramInt1, paramInt2);
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
/*     */   public static Fraction getFraction(int paramInt1, int paramInt2, int paramInt3) {
/*     */     long l;
/* 173 */     if (paramInt3 == 0) {
/* 174 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 176 */     if (paramInt3 < 0) {
/* 177 */       throw new ArithmeticException("The denominator must not be negative");
/*     */     }
/* 179 */     if (paramInt2 < 0) {
/* 180 */       throw new ArithmeticException("The numerator must not be negative");
/*     */     }
/*     */     
/* 183 */     if (paramInt1 < 0) {
/* 184 */       l = paramInt1 * paramInt3 - paramInt2;
/*     */     } else {
/* 186 */       l = paramInt1 * paramInt3 + paramInt2;
/*     */     } 
/* 188 */     if (l < -2147483648L || l > 2147483647L) {
/* 189 */       throw new ArithmeticException("Numerator too large to represent as an Integer.");
/*     */     }
/* 191 */     return new Fraction((int)l, paramInt3);
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
/*     */   public static Fraction getReducedFraction(int paramInt1, int paramInt2) {
/* 209 */     if (paramInt2 == 0) {
/* 210 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 212 */     if (paramInt1 == 0) {
/* 213 */       return ZERO;
/*     */     }
/*     */     
/* 216 */     if (paramInt2 == Integer.MIN_VALUE && (paramInt1 & 0x1) == 0) {
/* 217 */       paramInt1 /= 2;
/* 218 */       paramInt2 /= 2;
/*     */     } 
/* 220 */     if (paramInt2 < 0) {
/* 221 */       if (paramInt1 == Integer.MIN_VALUE || paramInt2 == Integer.MIN_VALUE) {
/* 222 */         throw new ArithmeticException("overflow: can't negate");
/*     */       }
/* 224 */       paramInt1 = -paramInt1;
/* 225 */       paramInt2 = -paramInt2;
/*     */     } 
/*     */     
/* 228 */     int i = greatestCommonDivisor(paramInt1, paramInt2);
/* 229 */     paramInt1 /= i;
/* 230 */     paramInt2 /= i;
/* 231 */     return new Fraction(paramInt1, paramInt2);
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
/*     */   public static Fraction getFraction(double paramDouble) {
/*     */     double d5;
/* 249 */     byte b1 = (paramDouble < 0.0D) ? -1 : 1;
/* 250 */     paramDouble = Math.abs(paramDouble);
/* 251 */     if (paramDouble > 2.147483647E9D || Double.isNaN(paramDouble)) {
/* 252 */       throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
/*     */     }
/* 254 */     int i = (int)paramDouble;
/* 255 */     paramDouble -= i;
/*     */     
/* 257 */     int j = 0;
/* 258 */     int k = 1;
/* 259 */     int m = 1;
/* 260 */     int n = 0;
/* 261 */     int i1 = 0;
/* 262 */     int i2 = 0;
/* 263 */     int i3 = (int)paramDouble;
/* 264 */     int i4 = 0;
/* 265 */     double d1 = 1.0D;
/* 266 */     double d2 = 0.0D;
/* 267 */     double d3 = paramDouble - i3;
/* 268 */     double d4 = 0.0D;
/* 269 */     double d6 = Double.MAX_VALUE;
/*     */     
/* 271 */     byte b2 = 1;
/*     */     do {
/* 273 */       d5 = d6;
/* 274 */       i4 = (int)(d1 / d3);
/* 275 */       d2 = d3;
/* 276 */       d4 = d1 - i4 * d3;
/* 277 */       i1 = i3 * m + j;
/* 278 */       i2 = i3 * n + k;
/* 279 */       double d = i1 / i2;
/* 280 */       d6 = Math.abs(paramDouble - d);
/* 281 */       i3 = i4;
/* 282 */       d1 = d2;
/* 283 */       d3 = d4;
/* 284 */       j = m;
/* 285 */       k = n;
/* 286 */       m = i1;
/* 287 */       n = i2;
/* 288 */       b2++;
/* 289 */     } while (d5 > d6 && i2 <= 10000 && i2 > 0 && b2 < 25);
/* 290 */     if (b2 == 25) {
/* 291 */       throw new ArithmeticException("Unable to convert double to fraction");
/*     */     }
/* 293 */     return getReducedFraction((j + i * k) * b1, k);
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
/*     */   public static Fraction getFraction(String paramString) {
/* 315 */     Validate.notNull(paramString, "The string must not be null", new Object[0]);
/*     */     
/* 317 */     int i = paramString.indexOf('.');
/* 318 */     if (i >= 0) {
/* 319 */       return getFraction(Double.parseDouble(paramString));
/*     */     }
/*     */ 
/*     */     
/* 323 */     i = paramString.indexOf(' ');
/* 324 */     if (i > 0) {
/* 325 */       int m = Integer.parseInt(paramString.substring(0, i));
/* 326 */       paramString = paramString.substring(i + 1);
/* 327 */       i = paramString.indexOf('/');
/* 328 */       if (i < 0) {
/* 329 */         throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
/*     */       }
/* 331 */       int n = Integer.parseInt(paramString.substring(0, i));
/* 332 */       int i1 = Integer.parseInt(paramString.substring(i + 1));
/* 333 */       return getFraction(m, n, i1);
/*     */     } 
/*     */ 
/*     */     
/* 337 */     i = paramString.indexOf('/');
/* 338 */     if (i < 0)
/*     */     {
/* 340 */       return getFraction(Integer.parseInt(paramString), 1);
/*     */     }
/* 342 */     int j = Integer.parseInt(paramString.substring(0, i));
/* 343 */     int k = Integer.parseInt(paramString.substring(i + 1));
/* 344 */     return getFraction(j, k);
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
/*     */   public int getNumerator() {
/* 359 */     return this.numerator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDenominator() {
/* 368 */     return this.denominator;
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
/*     */   public int getProperNumerator() {
/* 383 */     return Math.abs(this.numerator % this.denominator);
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
/*     */   public int getProperWhole() {
/* 398 */     return this.numerator / this.denominator;
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
/*     */   public int intValue() {
/* 412 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long longValue() {
/* 423 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float floatValue() {
/* 434 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double doubleValue() {
/* 445 */     return this.numerator / this.denominator;
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
/*     */   public Fraction reduce() {
/* 461 */     if (this.numerator == 0) {
/* 462 */       return equals(ZERO) ? this : ZERO;
/*     */     }
/* 464 */     int i = greatestCommonDivisor(Math.abs(this.numerator), this.denominator);
/* 465 */     if (i == 1) {
/* 466 */       return this;
/*     */     }
/* 468 */     return getFraction(this.numerator / i, this.denominator / i);
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
/*     */   public Fraction invert() {
/* 481 */     if (this.numerator == 0) {
/* 482 */       throw new ArithmeticException("Unable to invert zero.");
/*     */     }
/* 484 */     if (this.numerator == Integer.MIN_VALUE) {
/* 485 */       throw new ArithmeticException("overflow: can't negate numerator");
/*     */     }
/* 487 */     if (this.numerator < 0) {
/* 488 */       return new Fraction(-this.denominator, -this.numerator);
/*     */     }
/* 490 */     return new Fraction(this.denominator, this.numerator);
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
/*     */   public Fraction negate() {
/* 502 */     if (this.numerator == Integer.MIN_VALUE) {
/* 503 */       throw new ArithmeticException("overflow: too large to negate");
/*     */     }
/* 505 */     return new Fraction(-this.numerator, this.denominator);
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
/*     */   public Fraction abs() {
/* 518 */     if (this.numerator >= 0) {
/* 519 */       return this;
/*     */     }
/* 521 */     return negate();
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
/*     */   public Fraction pow(int paramInt) {
/* 537 */     if (paramInt == 1)
/* 538 */       return this; 
/* 539 */     if (paramInt == 0)
/* 540 */       return ONE; 
/* 541 */     if (paramInt < 0) {
/* 542 */       if (paramInt == Integer.MIN_VALUE) {
/* 543 */         return invert().pow(2).pow(-(paramInt / 2));
/*     */       }
/* 545 */       return invert().pow(-paramInt);
/*     */     } 
/* 547 */     Fraction fraction = multiplyBy(this);
/* 548 */     if (paramInt % 2 == 0) {
/* 549 */       return fraction.pow(paramInt / 2);
/*     */     }
/* 551 */     return fraction.pow(paramInt / 2).multiplyBy(this);
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
/*     */   private static int greatestCommonDivisor(int paramInt1, int paramInt2) {
/* 567 */     if (paramInt1 == 0 || paramInt2 == 0) {
/* 568 */       if (paramInt1 == Integer.MIN_VALUE || paramInt2 == Integer.MIN_VALUE) {
/* 569 */         throw new ArithmeticException("overflow: gcd is 2^31");
/*     */       }
/* 571 */       return Math.abs(paramInt1) + Math.abs(paramInt2);
/*     */     } 
/*     */     
/* 574 */     if (Math.abs(paramInt1) == 1 || Math.abs(paramInt2) == 1) {
/* 575 */       return 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 581 */     if (paramInt1 > 0) {
/* 582 */       paramInt1 = -paramInt1;
/*     */     }
/* 584 */     if (paramInt2 > 0) {
/* 585 */       paramInt2 = -paramInt2;
/*     */     }
/*     */     
/* 588 */     byte b = 0;
/* 589 */     while ((paramInt1 & 0x1) == 0 && (paramInt2 & 0x1) == 0 && b < 31) {
/* 590 */       paramInt1 /= 2;
/* 591 */       paramInt2 /= 2;
/* 592 */       b++;
/*     */     } 
/* 594 */     if (b == 31) {
/* 595 */       throw new ArithmeticException("overflow: gcd is 2^31");
/*     */     }
/*     */ 
/*     */     
/* 599 */     int i = ((paramInt1 & 0x1) == 1) ? paramInt2 : -(paramInt1 / 2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 605 */       while ((i & 0x1) == 0) {
/* 606 */         i /= 2;
/*     */       }
/*     */       
/* 609 */       if (i > 0) {
/* 610 */         paramInt1 = -i;
/*     */       } else {
/* 612 */         paramInt2 = i;
/*     */       } 
/*     */       
/* 615 */       i = (paramInt2 - paramInt1) / 2;
/*     */ 
/*     */       
/* 618 */       if (i == 0) {
/* 619 */         return -paramInt1 * (1 << b);
/*     */       }
/*     */     } 
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
/*     */   private static int mulAndCheck(int paramInt1, int paramInt2) {
/* 635 */     long l = paramInt1 * paramInt2;
/* 636 */     if (l < -2147483648L || l > 2147483647L) {
/* 637 */       throw new ArithmeticException("overflow: mul");
/*     */     }
/* 639 */     return (int)l;
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
/*     */   private static int mulPosAndCheck(int paramInt1, int paramInt2) {
/* 653 */     long l = paramInt1 * paramInt2;
/* 654 */     if (l > 2147483647L) {
/* 655 */       throw new ArithmeticException("overflow: mulPos");
/*     */     }
/* 657 */     return (int)l;
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
/*     */   private static int addAndCheck(int paramInt1, int paramInt2) {
/* 670 */     long l = paramInt1 + paramInt2;
/* 671 */     if (l < -2147483648L || l > 2147483647L) {
/* 672 */       throw new ArithmeticException("overflow: add");
/*     */     }
/* 674 */     return (int)l;
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
/*     */   private static int subAndCheck(int paramInt1, int paramInt2) {
/* 687 */     long l = paramInt1 - paramInt2;
/* 688 */     if (l < -2147483648L || l > 2147483647L) {
/* 689 */       throw new ArithmeticException("overflow: add");
/*     */     }
/* 691 */     return (int)l;
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
/*     */   public Fraction add(Fraction paramFraction) {
/* 705 */     return addSub(paramFraction, true);
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
/*     */   public Fraction subtract(Fraction paramFraction) {
/* 719 */     return addSub(paramFraction, false);
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
/*     */   private Fraction addSub(Fraction paramFraction, boolean paramBoolean) {
/* 733 */     Validate.notNull(paramFraction, "The fraction must not be null", new Object[0]);
/*     */     
/* 735 */     if (this.numerator == 0) {
/* 736 */       return paramBoolean ? paramFraction : paramFraction.negate();
/*     */     }
/* 738 */     if (paramFraction.numerator == 0) {
/* 739 */       return this;
/*     */     }
/*     */ 
/*     */     
/* 743 */     int i = greatestCommonDivisor(this.denominator, paramFraction.denominator);
/* 744 */     if (i == 1) {
/*     */       
/* 746 */       int m = mulAndCheck(this.numerator, paramFraction.denominator);
/* 747 */       int n = mulAndCheck(paramFraction.numerator, this.denominator);
/* 748 */       return new Fraction(paramBoolean ? addAndCheck(m, n) : subAndCheck(m, n), mulPosAndCheck(this.denominator, paramFraction.denominator));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 754 */     BigInteger bigInteger1 = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf((paramFraction.denominator / i)));
/* 755 */     BigInteger bigInteger2 = BigInteger.valueOf(paramFraction.numerator).multiply(BigInteger.valueOf((this.denominator / i)));
/* 756 */     BigInteger bigInteger3 = paramBoolean ? bigInteger1.add(bigInteger2) : bigInteger1.subtract(bigInteger2);
/*     */ 
/*     */     
/* 759 */     int j = bigInteger3.mod(BigInteger.valueOf(i)).intValue();
/* 760 */     int k = (j == 0) ? i : greatestCommonDivisor(j, i);
/*     */ 
/*     */     
/* 763 */     BigInteger bigInteger4 = bigInteger3.divide(BigInteger.valueOf(k));
/* 764 */     if (bigInteger4.bitLength() > 31) {
/* 765 */       throw new ArithmeticException("overflow: numerator too large after multiply");
/*     */     }
/* 767 */     return new Fraction(bigInteger4.intValue(), mulPosAndCheck(this.denominator / i, paramFraction.denominator / k));
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
/*     */   public Fraction multiplyBy(Fraction paramFraction) {
/* 781 */     Validate.notNull(paramFraction, "The fraction must not be null", new Object[0]);
/* 782 */     if (this.numerator == 0 || paramFraction.numerator == 0) {
/* 783 */       return ZERO;
/*     */     }
/*     */ 
/*     */     
/* 787 */     int i = greatestCommonDivisor(this.numerator, paramFraction.denominator);
/* 788 */     int j = greatestCommonDivisor(paramFraction.numerator, this.denominator);
/* 789 */     return getReducedFraction(mulAndCheck(this.numerator / i, paramFraction.numerator / j), 
/* 790 */         mulPosAndCheck(this.denominator / j, paramFraction.denominator / i));
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
/*     */   public Fraction divideBy(Fraction paramFraction) {
/* 804 */     Validate.notNull(paramFraction, "The fraction must not be null", new Object[0]);
/* 805 */     if (paramFraction.numerator == 0) {
/* 806 */       throw new ArithmeticException("The fraction to divide by must not be zero");
/*     */     }
/* 808 */     return multiplyBy(paramFraction.invert());
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
/* 824 */     if (paramObject == this) {
/* 825 */       return true;
/*     */     }
/* 827 */     if (!(paramObject instanceof Fraction)) {
/* 828 */       return false;
/*     */     }
/* 830 */     Fraction fraction = (Fraction)paramObject;
/* 831 */     return (getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 841 */     if (this.hashCode == 0)
/*     */     {
/* 843 */       this.hashCode = 37 * (629 + getNumerator()) + getDenominator();
/*     */     }
/* 845 */     return this.hashCode;
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
/*     */   public int compareTo(Fraction paramFraction) {
/* 862 */     if (this == paramFraction) {
/* 863 */       return 0;
/*     */     }
/* 865 */     if (this.numerator == paramFraction.numerator && this.denominator == paramFraction.denominator) {
/* 866 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 870 */     long l1 = this.numerator * paramFraction.denominator;
/* 871 */     long l2 = paramFraction.numerator * this.denominator;
/* 872 */     return Long.compare(l1, l2);
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
/*     */   public String toString() {
/* 884 */     if (this.toString == null) {
/* 885 */       this.toString = getNumerator() + "/" + getDenominator();
/*     */     }
/* 887 */     return this.toString;
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
/*     */   public String toProperString() {
/* 900 */     if (this.toProperString == null) {
/* 901 */       if (this.numerator == 0) {
/* 902 */         this.toProperString = "0";
/* 903 */       } else if (this.numerator == this.denominator) {
/* 904 */         this.toProperString = "1";
/* 905 */       } else if (this.numerator == -1 * this.denominator) {
/* 906 */         this.toProperString = "-1";
/* 907 */       } else if (((this.numerator > 0) ? -this.numerator : this.numerator) < -this.denominator) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 912 */         int i = getProperNumerator();
/* 913 */         if (i == 0) {
/* 914 */           this.toProperString = Integer.toString(getProperWhole());
/*     */         } else {
/* 916 */           this.toProperString = getProperWhole() + " " + i + "/" + getDenominator();
/*     */         } 
/*     */       } else {
/* 919 */         this.toProperString = getNumerator() + "/" + getDenominator();
/*     */       } 
/*     */     }
/* 922 */     return this.toProperString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\math\Fraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */