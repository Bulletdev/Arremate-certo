/*     */ package org.h2.value;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueByte
/*     */   extends Value
/*     */ {
/*     */   static final int PRECISION = 3;
/*     */   static final int DISPLAY_SIZE = 4;
/*     */   private final byte value;
/*     */   
/*     */   private ValueByte(byte paramByte) {
/*  34 */     this.value = paramByte;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value add(Value paramValue) {
/*  39 */     ValueByte valueByte = (ValueByte)paramValue;
/*  40 */     return checkRange(this.value + valueByte.value);
/*     */   }
/*     */   
/*     */   private static ValueByte checkRange(int paramInt) {
/*  44 */     if (paramInt < -128 || paramInt > 127) {
/*  45 */       throw DbException.get(22003, Integer.toString(paramInt));
/*     */     }
/*     */     
/*  48 */     return get((byte)paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSignum() {
/*  53 */     return Integer.signum(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value negate() {
/*  58 */     return checkRange(-this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value subtract(Value paramValue) {
/*  63 */     ValueByte valueByte = (ValueByte)paramValue;
/*  64 */     return checkRange(this.value - valueByte.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value multiply(Value paramValue) {
/*  69 */     ValueByte valueByte = (ValueByte)paramValue;
/*  70 */     return checkRange(this.value * valueByte.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value divide(Value paramValue) {
/*  75 */     ValueByte valueByte = (ValueByte)paramValue;
/*  76 */     if (valueByte.value == 0) {
/*  77 */       throw DbException.get(22012, getSQL());
/*     */     }
/*  79 */     return get((byte)(this.value / valueByte.value));
/*     */   }
/*     */ 
/*     */   
/*     */   public Value modulus(Value paramValue) {
/*  84 */     ValueByte valueByte = (ValueByte)paramValue;
/*  85 */     if (valueByte.value == 0) {
/*  86 */       throw DbException.get(22012, getSQL());
/*     */     }
/*  88 */     return get((byte)(this.value % valueByte.value));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  93 */     return getString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  98 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getByte() {
/* 103 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 108 */     ValueByte valueByte = (ValueByte)paramValue;
/* 109 */     return MathUtils.compareInt(this.value, valueByte.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 114 */     return String.valueOf(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 119 */     return 3L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 124 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 129 */     return Byte.valueOf(this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 135 */     paramPreparedStatement.setByte(paramInt, this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueByte get(byte paramByte) {
/* 145 */     return (ValueByte)Value.cache(new ValueByte(paramByte));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 150 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 155 */     return (paramObject instanceof ValueByte && this.value == ((ValueByte)paramObject).value);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueByte.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */