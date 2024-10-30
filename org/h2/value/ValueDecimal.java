/*     */ package org.h2.value;
/*     */ 
/*     */ import java.math.BigDecimal;
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
/*     */ public class ValueDecimal
/*     */   extends Value
/*     */ {
/*  24 */   public static final Object ZERO = new ValueDecimal(BigDecimal.ZERO);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  29 */   public static final Object ONE = new ValueDecimal(BigDecimal.ONE);
/*     */ 
/*     */   
/*     */   static final int DEFAULT_PRECISION = 65535;
/*     */ 
/*     */   
/*     */   static final int DEFAULT_SCALE = 32767;
/*     */ 
/*     */   
/*     */   static final int DEFAULT_DISPLAY_SIZE = 65535;
/*     */ 
/*     */   
/*     */   private static final int DIVIDE_SCALE_ADD = 25;
/*     */ 
/*     */   
/*     */   private static final int BIG_DECIMAL_SCALE_MAX = 100000;
/*     */ 
/*     */   
/*     */   private final BigDecimal value;
/*     */ 
/*     */   
/*     */   private String valueString;
/*     */ 
/*     */   
/*     */   private int precision;
/*     */ 
/*     */ 
/*     */   
/*     */   private ValueDecimal(BigDecimal paramBigDecimal) {
/*  58 */     if (paramBigDecimal == null)
/*  59 */       throw new IllegalArgumentException("null"); 
/*  60 */     if (!paramBigDecimal.getClass().equals(BigDecimal.class)) {
/*  61 */       throw DbException.get(90125, new String[] { BigDecimal.class.getName(), paramBigDecimal.getClass().getName() });
/*     */     }
/*     */     
/*  64 */     this.value = paramBigDecimal;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value add(Value paramValue) {
/*  69 */     ValueDecimal valueDecimal = (ValueDecimal)paramValue;
/*  70 */     return get(this.value.add(valueDecimal.value));
/*     */   }
/*     */ 
/*     */   
/*     */   public Value subtract(Value paramValue) {
/*  75 */     ValueDecimal valueDecimal = (ValueDecimal)paramValue;
/*  76 */     return get(this.value.subtract(valueDecimal.value));
/*     */   }
/*     */ 
/*     */   
/*     */   public Value negate() {
/*  81 */     return get(this.value.negate());
/*     */   }
/*     */ 
/*     */   
/*     */   public Value multiply(Value paramValue) {
/*  86 */     ValueDecimal valueDecimal = (ValueDecimal)paramValue;
/*  87 */     return get(this.value.multiply(valueDecimal.value));
/*     */   }
/*     */ 
/*     */   
/*     */   public Value divide(Value paramValue) {
/*  92 */     ValueDecimal valueDecimal = (ValueDecimal)paramValue;
/*  93 */     if (valueDecimal.value.signum() == 0) {
/*  94 */       throw DbException.get(22012, getSQL());
/*     */     }
/*  96 */     BigDecimal bigDecimal = this.value.divide(valueDecimal.value, this.value.scale() + 25, 5);
/*     */ 
/*     */     
/*  99 */     if (bigDecimal.signum() == 0) {
/* 100 */       bigDecimal = BigDecimal.ZERO;
/* 101 */     } else if (bigDecimal.scale() > 0 && 
/* 102 */       !bigDecimal.unscaledValue().testBit(0)) {
/* 103 */       bigDecimal = bigDecimal.stripTrailingZeros();
/*     */     } 
/*     */     
/* 106 */     return get(bigDecimal);
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueDecimal modulus(Value paramValue) {
/* 111 */     ValueDecimal valueDecimal = (ValueDecimal)paramValue;
/* 112 */     if (valueDecimal.value.signum() == 0) {
/* 113 */       throw DbException.get(22012, getSQL());
/*     */     }
/* 115 */     BigDecimal bigDecimal = this.value.remainder(valueDecimal.value);
/* 116 */     return get(bigDecimal);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 121 */     return getString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 126 */     return 6;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 131 */     ValueDecimal valueDecimal = (ValueDecimal)paramValue;
/* 132 */     return this.value.compareTo(valueDecimal.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSignum() {
/* 137 */     return this.value.signum();
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimal() {
/* 142 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 147 */     if (this.valueString == null) {
/* 148 */       String str = this.value.toPlainString();
/* 149 */       if (str.length() < 40) {
/* 150 */         this.valueString = str;
/*     */       } else {
/* 152 */         this.valueString = this.value.toString();
/*     */       } 
/*     */     } 
/* 155 */     return this.valueString;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 160 */     if (this.precision == 0) {
/* 161 */       this.precision = this.value.precision();
/*     */     }
/* 163 */     return this.precision;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkPrecision(long paramLong) {
/* 168 */     if (paramLong == 65535L) {
/* 169 */       return true;
/*     */     }
/* 171 */     return (getPrecision() <= paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/* 176 */     return this.value.scale();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 181 */     return this.value.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 186 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 192 */     paramPreparedStatement.setBigDecimal(paramInt, this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value convertScale(boolean paramBoolean, int paramInt) {
/* 197 */     if (this.value.scale() == paramInt) {
/* 198 */       return this;
/*     */     }
/* 200 */     if ((paramBoolean || paramInt >= 32767) && 
/* 201 */       this.value.scale() < paramInt) {
/* 202 */       return this;
/*     */     }
/*     */     
/* 205 */     BigDecimal bigDecimal = setScale(this.value, paramInt);
/* 206 */     return get(bigDecimal);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value convertPrecision(long paramLong, boolean paramBoolean) {
/* 211 */     if (getPrecision() <= paramLong) {
/* 212 */       return this;
/*     */     }
/* 214 */     if (paramBoolean) {
/* 215 */       return get(BigDecimal.valueOf(this.value.doubleValue()));
/*     */     }
/* 217 */     throw DbException.get(22003, Long.toString(paramLong));
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
/*     */   public static ValueDecimal get(BigDecimal paramBigDecimal) {
/* 229 */     if (BigDecimal.ZERO.equals(paramBigDecimal))
/* 230 */       return (ValueDecimal)ZERO; 
/* 231 */     if (BigDecimal.ONE.equals(paramBigDecimal)) {
/* 232 */       return (ValueDecimal)ONE;
/*     */     }
/* 234 */     return (ValueDecimal)Value.cache(new ValueDecimal(paramBigDecimal));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 240 */     return MathUtils.convertLongToInt(getPrecision() + 2L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 249 */     return (paramObject instanceof ValueDecimal && this.value.equals(((ValueDecimal)paramObject).value));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 255 */     return this.value.precision() + 120;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BigDecimal setScale(BigDecimal paramBigDecimal, int paramInt) {
/* 266 */     if (paramInt > 100000 || paramInt < -100000) {
/* 267 */       throw DbException.getInvalidValueException("scale", Integer.valueOf(paramInt));
/*     */     }
/* 269 */     return paramBigDecimal.setScale(paramInt, 4);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueDecimal.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */