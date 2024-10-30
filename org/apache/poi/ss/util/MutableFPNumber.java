/*     */ package org.apache.poi.ss.util;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MutableFPNumber
/*     */ {
/*  37 */   private static final BigInteger BI_MIN_BASE = new BigInteger("0B5E620F47FFFE666", 16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   private static final BigInteger BI_MAX_BASE = new BigInteger("0E35FA9319FFFE000", 16);
/*     */ 
/*     */   
/*     */   private static final int C_64 = 64;
/*     */ 
/*     */   
/*     */   private static final int MIN_PRECISION = 72;
/*     */   
/*     */   private BigInteger _significand;
/*     */   
/*     */   private int _binaryExponent;
/*     */ 
/*     */   
/*     */   public MutableFPNumber(BigInteger paramBigInteger, int paramInt) {
/*  57 */     this._significand = paramBigInteger;
/*  58 */     this._binaryExponent = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public MutableFPNumber copy() {
/*  63 */     return new MutableFPNumber(this._significand, this._binaryExponent);
/*     */   }
/*     */   public void normalise64bit() {
/*  66 */     int i = this._significand.bitLength();
/*  67 */     int j = i - 64;
/*  68 */     if (j == 0) {
/*     */       return;
/*     */     }
/*  71 */     if (j < 0) {
/*  72 */       throw new IllegalStateException("Not enough precision");
/*     */     }
/*  74 */     this._binaryExponent += j;
/*  75 */     if (j > 32) {
/*  76 */       int k = j - 1 & 0xFFFFE0;
/*  77 */       this._significand = this._significand.shiftRight(k);
/*  78 */       j -= k;
/*  79 */       i -= k;
/*     */     } 
/*  81 */     if (j < 1) {
/*  82 */       throw new IllegalStateException();
/*     */     }
/*  84 */     this._significand = Rounder.round(this._significand, j);
/*  85 */     if (this._significand.bitLength() > i) {
/*  86 */       j++;
/*  87 */       this._binaryExponent++;
/*     */     } 
/*  89 */     this._significand = this._significand.shiftRight(j);
/*     */   }
/*     */   public int get64BitNormalisedExponent() {
/*  92 */     return this._binaryExponent + this._significand.bitLength() - 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBelowMaxRep() {
/*  97 */     int i = this._significand.bitLength() - 64;
/*  98 */     return (this._significand.compareTo(BI_MAX_BASE.shiftLeft(i)) < 0);
/*     */   }
/*     */   public boolean isAboveMinRep() {
/* 101 */     int i = this._significand.bitLength() - 64;
/* 102 */     return (this._significand.compareTo(BI_MIN_BASE.shiftLeft(i)) > 0);
/*     */   }
/*     */   
/*     */   public NormalisedDecimal createNormalisedDecimal(int paramInt) {
/* 106 */     int i = this._binaryExponent - 39;
/* 107 */     int j = this._significand.intValue() << i & 0xFFFF80;
/* 108 */     long l = this._significand.shiftRight(64 - this._binaryExponent - 1).longValue();
/* 109 */     return new NormalisedDecimal(l, j, paramInt);
/*     */   }
/*     */   public void multiplyByPowerOfTen(int paramInt) {
/* 112 */     TenPower tenPower = TenPower.getInstance(Math.abs(paramInt));
/* 113 */     if (paramInt < 0) {
/* 114 */       mulShift(tenPower._divisor, tenPower._divisorShift);
/*     */     } else {
/* 116 */       mulShift(tenPower._multiplicand, tenPower._multiplierShift);
/*     */     } 
/*     */   }
/*     */   private void mulShift(BigInteger paramBigInteger, int paramInt) {
/* 120 */     this._significand = this._significand.multiply(paramBigInteger);
/* 121 */     this._binaryExponent += paramInt;
/*     */     
/* 123 */     int i = this._significand.bitLength() - 72 & 0xFFFFFFE0;
/*     */     
/* 125 */     if (i > 0) {
/*     */       
/* 127 */       this._significand = this._significand.shiftRight(i);
/* 128 */       this._binaryExponent += i;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final class Rounder {
/*     */     private static final BigInteger[] HALF_BITS;
/*     */     
/*     */     static {
/* 136 */       BigInteger[] arrayOfBigInteger = new BigInteger[33];
/* 137 */       long l = 1L;
/* 138 */       for (byte b = 1; b < arrayOfBigInteger.length; b++) {
/* 139 */         arrayOfBigInteger[b] = BigInteger.valueOf(l);
/* 140 */         l <<= 1L;
/*     */       } 
/* 142 */       HALF_BITS = arrayOfBigInteger;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static BigInteger round(BigInteger param1BigInteger, int param1Int) {
/* 148 */       if (param1Int < 1) {
/* 149 */         return param1BigInteger;
/*     */       }
/* 151 */       return param1BigInteger.add(HALF_BITS[param1Int]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class TenPower
/*     */   {
/* 159 */     private static final BigInteger FIVE = new BigInteger("5");
/* 160 */     private static final TenPower[] _cache = new TenPower[350];
/*     */     
/*     */     public final BigInteger _multiplicand;
/*     */     public final BigInteger _divisor;
/*     */     public final int _divisorShift;
/*     */     public final int _multiplierShift;
/*     */     
/*     */     private TenPower(int param1Int) {
/* 168 */       BigInteger bigInteger1 = FIVE.pow(param1Int);
/*     */       
/* 170 */       int i = bigInteger1.bitLength();
/* 171 */       int j = 80 + i;
/* 172 */       BigInteger bigInteger2 = BigInteger.ONE.shiftLeft(j).divide(bigInteger1);
/* 173 */       int k = bigInteger2.bitLength() - 80;
/* 174 */       this._divisor = bigInteger2.shiftRight(k);
/* 175 */       i -= k;
/*     */       
/* 177 */       this._divisorShift = -(i + param1Int + 80);
/* 178 */       int m = bigInteger1.bitLength() - 68;
/* 179 */       if (m > 0) {
/* 180 */         this._multiplierShift = param1Int + m;
/* 181 */         this._multiplicand = bigInteger1.shiftRight(m);
/*     */       } else {
/* 183 */         this._multiplierShift = param1Int;
/* 184 */         this._multiplicand = bigInteger1;
/*     */       } 
/*     */     }
/*     */     
/*     */     static TenPower getInstance(int param1Int) {
/* 189 */       TenPower tenPower = _cache[param1Int];
/* 190 */       if (tenPower == null) {
/* 191 */         tenPower = new TenPower(param1Int);
/* 192 */         _cache[param1Int] = tenPower;
/*     */       } 
/* 194 */       return tenPower;
/*     */     }
/*     */   }
/*     */   
/*     */   public ExpandedDouble createExpandedDouble() {
/* 199 */     return new ExpandedDouble(this._significand, this._binaryExponent);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\MutableFPNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */