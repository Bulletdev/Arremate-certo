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
/*     */ public class ValueFloat
/*     */   extends Value
/*     */ {
/*  22 */   public static final int ZERO_BITS = Float.floatToIntBits(0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int PRECISION = 7;
/*     */ 
/*     */ 
/*     */   
/*     */   static final int DISPLAY_SIZE = 15;
/*     */ 
/*     */ 
/*     */   
/*  35 */   private static final ValueFloat ZERO = new ValueFloat(0.0F);
/*  36 */   private static final ValueFloat ONE = new ValueFloat(1.0F);
/*     */   
/*     */   private final float value;
/*     */   
/*     */   private ValueFloat(float paramFloat) {
/*  41 */     this.value = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value add(Value paramValue) {
/*  46 */     ValueFloat valueFloat = (ValueFloat)paramValue;
/*  47 */     return get(this.value + valueFloat.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value subtract(Value paramValue) {
/*  52 */     ValueFloat valueFloat = (ValueFloat)paramValue;
/*  53 */     return get(this.value - valueFloat.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value negate() {
/*  58 */     return get(-this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value multiply(Value paramValue) {
/*  63 */     ValueFloat valueFloat = (ValueFloat)paramValue;
/*  64 */     return get(this.value * valueFloat.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value divide(Value paramValue) {
/*  69 */     ValueFloat valueFloat = (ValueFloat)paramValue;
/*  70 */     if (valueFloat.value == 0.0D) {
/*  71 */       throw DbException.get(22012, getSQL());
/*     */     }
/*  73 */     return get(this.value / valueFloat.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value modulus(Value paramValue) {
/*  78 */     ValueFloat valueFloat = (ValueFloat)paramValue;
/*  79 */     if (valueFloat.value == 0.0F) {
/*  80 */       throw DbException.get(22012, getSQL());
/*     */     }
/*  82 */     return get(this.value % valueFloat.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  87 */     if (this.value == Float.POSITIVE_INFINITY)
/*  88 */       return "POWER(0, -1)"; 
/*  89 */     if (this.value == Float.NEGATIVE_INFINITY)
/*  90 */       return "(-POWER(0, -1))"; 
/*  91 */     if (Double.isNaN(this.value))
/*     */     {
/*  93 */       return "SQRT(-1)";
/*     */     }
/*  95 */     return getString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 100 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 105 */     ValueFloat valueFloat = (ValueFloat)paramValue;
/* 106 */     return Float.compare(this.value, valueFloat.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSignum() {
/* 111 */     return (this.value == 0.0F) ? 0 : ((this.value < 0.0F) ? -1 : 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloat() {
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
/* 126 */     return 7L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/* 131 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     long l = Float.floatToIntBits(this.value);
/* 137 */     return (int)(l ^ l >> 32L);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 142 */     return Float.valueOf(this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 148 */     paramPreparedStatement.setFloat(paramInt, this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueFloat get(float paramFloat) {
/* 158 */     if (paramFloat == 1.0F)
/* 159 */       return ONE; 
/* 160 */     if (paramFloat == 0.0F)
/*     */     {
/* 162 */       return ZERO;
/*     */     }
/* 164 */     return (ValueFloat)Value.cache(new ValueFloat(paramFloat));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 169 */     return 15;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 174 */     if (!(paramObject instanceof ValueFloat)) {
/* 175 */       return false;
/*     */     }
/* 177 */     return (compareSecure((ValueFloat)paramObject, null) == 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueFloat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */