/*     */ package org.h2.value;
/*     */ 
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.message.DbException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueDouble
/*     */   extends Value
/*     */ {
/*     */   public static final int PRECISION = 17;
/*     */   public static final int DISPLAY_SIZE = 24;
/*  33 */   public static final long ZERO_BITS = Double.doubleToLongBits(0.0D);
/*     */   
/*  35 */   private static final ValueDouble ZERO = new ValueDouble(0.0D);
/*  36 */   private static final ValueDouble ONE = new ValueDouble(1.0D);
/*  37 */   private static final ValueDouble NAN = new ValueDouble(Double.NaN);
/*     */   
/*     */   private final double value;
/*     */   
/*     */   private ValueDouble(double paramDouble) {
/*  42 */     this.value = paramDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value add(Value paramValue) {
/*  47 */     ValueDouble valueDouble = (ValueDouble)paramValue;
/*  48 */     return get(this.value + valueDouble.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value subtract(Value paramValue) {
/*  53 */     ValueDouble valueDouble = (ValueDouble)paramValue;
/*  54 */     return get(this.value - valueDouble.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value negate() {
/*  59 */     return get(-this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value multiply(Value paramValue) {
/*  64 */     ValueDouble valueDouble = (ValueDouble)paramValue;
/*  65 */     return get(this.value * valueDouble.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value divide(Value paramValue) {
/*  70 */     ValueDouble valueDouble = (ValueDouble)paramValue;
/*  71 */     if (valueDouble.value == 0.0D) {
/*  72 */       throw DbException.get(22012, getSQL());
/*     */     }
/*  74 */     return get(this.value / valueDouble.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueDouble modulus(Value paramValue) {
/*  79 */     ValueDouble valueDouble = (ValueDouble)paramValue;
/*  80 */     if (valueDouble.value == 0.0D) {
/*  81 */       throw DbException.get(22012, getSQL());
/*     */     }
/*  83 */     return get(this.value % valueDouble.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  88 */     if (this.value == Double.POSITIVE_INFINITY)
/*  89 */       return "POWER(0, -1)"; 
/*  90 */     if (this.value == Double.NEGATIVE_INFINITY)
/*  91 */       return "(-POWER(0, -1))"; 
/*  92 */     if (Double.isNaN(this.value)) {
/*  93 */       return "SQRT(-1)";
/*     */     }
/*  95 */     return getString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 100 */     return 7;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 105 */     ValueDouble valueDouble = (ValueDouble)paramValue;
/* 106 */     return Double.compare(this.value, valueDouble.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSignum() {
/* 111 */     return (this.value == 0.0D) ? 0 : ((this.value < 0.0D) ? -1 : 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDouble() {
/* 116 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 121 */     return String.valueOf(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 126 */     return 17L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/* 131 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     long l = Double.doubleToLongBits(this.value);
/* 137 */     return (int)(l ^ l >> 32L);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 142 */     return Double.valueOf(this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 148 */     paramPreparedStatement.setDouble(paramInt, this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueDouble get(double paramDouble) {
/* 158 */     if (paramDouble == 1.0D)
/* 159 */       return ONE; 
/* 160 */     if (paramDouble == 0.0D)
/*     */     {
/* 162 */       return ZERO; } 
/* 163 */     if (Double.isNaN(paramDouble)) {
/* 164 */       return NAN;
/*     */     }
/* 166 */     return (ValueDouble)Value.cache(new ValueDouble(paramDouble));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 171 */     return 24;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 176 */     if (!(paramObject instanceof ValueDouble)) {
/* 177 */       return false;
/*     */     }
/* 179 */     return (compareSecure((ValueDouble)paramObject, null) == 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueDouble.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */