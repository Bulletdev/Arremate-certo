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
/*     */ public class ValueShort
/*     */   extends Value
/*     */ {
/*     */   static final int PRECISION = 5;
/*     */   static final int DISPLAY_SIZE = 6;
/*     */   private final short value;
/*     */   
/*     */   private ValueShort(short paramShort) {
/*  34 */     this.value = paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value add(Value paramValue) {
/*  39 */     ValueShort valueShort = (ValueShort)paramValue;
/*  40 */     return checkRange(this.value + valueShort.value);
/*     */   }
/*     */   
/*     */   private static ValueShort checkRange(int paramInt) {
/*  44 */     if (paramInt < -32768 || paramInt > 32767) {
/*  45 */       throw DbException.get(22003, Integer.toString(paramInt));
/*     */     }
/*     */     
/*  48 */     return get((short)paramInt);
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
/*  63 */     ValueShort valueShort = (ValueShort)paramValue;
/*  64 */     return checkRange(this.value - valueShort.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value multiply(Value paramValue) {
/*  69 */     ValueShort valueShort = (ValueShort)paramValue;
/*  70 */     return checkRange(this.value * valueShort.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value divide(Value paramValue) {
/*  75 */     ValueShort valueShort = (ValueShort)paramValue;
/*  76 */     if (valueShort.value == 0) {
/*  77 */       throw DbException.get(22012, getSQL());
/*     */     }
/*  79 */     return get((short)(this.value / valueShort.value));
/*     */   }
/*     */ 
/*     */   
/*     */   public Value modulus(Value paramValue) {
/*  84 */     ValueShort valueShort = (ValueShort)paramValue;
/*  85 */     if (valueShort.value == 0) {
/*  86 */       throw DbException.get(22012, getSQL());
/*     */     }
/*  88 */     return get((short)(this.value % valueShort.value));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  93 */     return getString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  98 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getShort() {
/* 103 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 108 */     ValueShort valueShort = (ValueShort)paramValue;
/* 109 */     return MathUtils.compareInt(this.value, valueShort.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 114 */     return String.valueOf(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 119 */     return 5L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 124 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 129 */     return Short.valueOf(this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 135 */     paramPreparedStatement.setShort(paramInt, this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueShort get(short paramShort) {
/* 145 */     return (ValueShort)Value.cache(new ValueShort(paramShort));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 150 */     return 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 155 */     return (paramObject instanceof ValueShort && this.value == ((ValueShort)paramObject).value);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueShort.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */