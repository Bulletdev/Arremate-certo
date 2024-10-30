/*     */ package org.h2.value;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.MathUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueLong
/*     */   extends Value
/*     */ {
/*  25 */   public static final BigInteger MAX = BigInteger.valueOf(Long.MAX_VALUE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  30 */   public static final BigDecimal MIN_BD = BigDecimal.valueOf(Long.MIN_VALUE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int PRECISION = 19;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DISPLAY_SIZE = 20;
/*     */ 
/*     */ 
/*     */   
/*  43 */   private static final BigInteger MIN = BigInteger.valueOf(Long.MIN_VALUE);
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int STATIC_SIZE = 100;
/*     */ 
/*     */   
/*  50 */   private static final ValueLong[] STATIC_CACHE = new ValueLong[100]; static {
/*  51 */     for (byte b = 0; b < 100; b++)
/*  52 */       STATIC_CACHE[b] = new ValueLong(b); 
/*     */   }
/*     */   private final long value;
/*     */   
/*     */   private ValueLong(long paramLong) {
/*  57 */     this.value = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value add(Value paramValue) {
/*  62 */     ValueLong valueLong = (ValueLong)paramValue;
/*  63 */     long l = this.value + valueLong.value;
/*  64 */     int i = Long.signum(this.value);
/*  65 */     int j = Long.signum(valueLong.value);
/*  66 */     int k = Long.signum(l);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  71 */     if (i != j || k == j || i == 0 || j == 0) {
/*  72 */       return get(l);
/*     */     }
/*  74 */     throw getOverflow();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSignum() {
/*  79 */     return Long.signum(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value negate() {
/*  84 */     if (this.value == Long.MIN_VALUE) {
/*  85 */       throw getOverflow();
/*     */     }
/*  87 */     return get(-this.value);
/*     */   }
/*     */   
/*     */   private DbException getOverflow() {
/*  91 */     return DbException.get(22003, Long.toString(this.value));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Value subtract(Value paramValue) {
/*  97 */     ValueLong valueLong = (ValueLong)paramValue;
/*  98 */     int i = Long.signum(this.value);
/*  99 */     int j = Long.signum(valueLong.value);
/*     */ 
/*     */     
/* 102 */     if (i == j || j == 0) {
/* 103 */       return get(this.value - valueLong.value);
/*     */     }
/*     */ 
/*     */     
/* 107 */     return add(valueLong.negate());
/*     */   }
/*     */   
/*     */   private static boolean isInteger(long paramLong) {
/* 111 */     return (paramLong >= -2147483648L && paramLong <= 2147483647L);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value multiply(Value paramValue) {
/* 116 */     ValueLong valueLong = (ValueLong)paramValue;
/* 117 */     long l = this.value * valueLong.value;
/* 118 */     if (this.value == 0L || this.value == 1L || valueLong.value == 0L || valueLong.value == 1L) {
/* 119 */       return get(l);
/*     */     }
/* 121 */     if (isInteger(this.value) && isInteger(valueLong.value)) {
/* 122 */       return get(l);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     BigInteger bigInteger1 = BigInteger.valueOf(this.value);
/* 130 */     BigInteger bigInteger2 = BigInteger.valueOf(valueLong.value);
/* 131 */     BigInteger bigInteger3 = bigInteger1.multiply(bigInteger2);
/* 132 */     if (bigInteger3.compareTo(MIN) < 0 || bigInteger3.compareTo(MAX) > 0) {
/* 133 */       throw getOverflow();
/*     */     }
/* 135 */     return get(bigInteger3.longValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public Value divide(Value paramValue) {
/* 140 */     ValueLong valueLong = (ValueLong)paramValue;
/* 141 */     if (valueLong.value == 0L) {
/* 142 */       throw DbException.get(22012, getSQL());
/*     */     }
/* 144 */     return get(this.value / valueLong.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value modulus(Value paramValue) {
/* 149 */     ValueLong valueLong = (ValueLong)paramValue;
/* 150 */     if (valueLong.value == 0L) {
/* 151 */       throw DbException.get(22012, getSQL());
/*     */     }
/* 153 */     return get(this.value % valueLong.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 158 */     return getString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 163 */     return 5;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong() {
/* 168 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 173 */     ValueLong valueLong = (ValueLong)paramValue;
/* 174 */     return MathUtils.compareLong(this.value, valueLong.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 179 */     return String.valueOf(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 184 */     return 19L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 189 */     return (int)(this.value ^ this.value >> 32L);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 194 */     return Long.valueOf(this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 200 */     paramPreparedStatement.setLong(paramInt, this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueLong get(long paramLong) {
/* 210 */     if (paramLong >= 0L && paramLong < 100L) {
/* 211 */       return STATIC_CACHE[(int)paramLong];
/*     */     }
/* 213 */     return (ValueLong)Value.cache(new ValueLong(paramLong));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 218 */     return 20;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 223 */     return (paramObject instanceof ValueLong && this.value == ((ValueLong)paramObject).value);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueLong.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */