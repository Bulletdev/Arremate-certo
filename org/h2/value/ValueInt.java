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
/*     */ 
/*     */ public class ValueInt
/*     */   extends Value
/*     */ {
/*     */   public static final int PRECISION = 10;
/*     */   public static final int DISPLAY_SIZE = 11;
/*     */   private static final int STATIC_SIZE = 128;
/*     */   private static final int DYNAMIC_SIZE = 256;
/*  34 */   private static final ValueInt[] STATIC_CACHE = new ValueInt[128];
/*  35 */   private static final ValueInt[] DYNAMIC_CACHE = new ValueInt[256];
/*     */   
/*     */   private final int value;
/*     */   
/*     */   static {
/*  40 */     for (byte b = 0; b < ''; b++) {
/*  41 */       STATIC_CACHE[b] = new ValueInt(b);
/*     */     }
/*     */   }
/*     */   
/*     */   private ValueInt(int paramInt) {
/*  46 */     this.value = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueInt get(int paramInt) {
/*  56 */     if (paramInt >= 0 && paramInt < 128) {
/*  57 */       return STATIC_CACHE[paramInt];
/*     */     }
/*  59 */     ValueInt valueInt = DYNAMIC_CACHE[paramInt & 0xFF];
/*  60 */     if (valueInt == null || valueInt.value != paramInt) {
/*  61 */       valueInt = new ValueInt(paramInt);
/*  62 */       DYNAMIC_CACHE[paramInt & 0xFF] = valueInt;
/*     */     } 
/*  64 */     return valueInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value add(Value paramValue) {
/*  69 */     ValueInt valueInt = (ValueInt)paramValue;
/*  70 */     return checkRange(this.value + valueInt.value);
/*     */   }
/*     */   
/*     */   private static ValueInt checkRange(long paramLong) {
/*  74 */     if (paramLong < -2147483648L || paramLong > 2147483647L) {
/*  75 */       throw DbException.get(22003, Long.toString(paramLong));
/*     */     }
/*  77 */     return get((int)paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSignum() {
/*  82 */     return Integer.signum(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value negate() {
/*  87 */     return checkRange(-(this.value));
/*     */   }
/*     */ 
/*     */   
/*     */   public Value subtract(Value paramValue) {
/*  92 */     ValueInt valueInt = (ValueInt)paramValue;
/*  93 */     return checkRange(this.value - valueInt.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value multiply(Value paramValue) {
/*  98 */     ValueInt valueInt = (ValueInt)paramValue;
/*  99 */     return checkRange(this.value * valueInt.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value divide(Value paramValue) {
/* 104 */     ValueInt valueInt = (ValueInt)paramValue;
/* 105 */     if (valueInt.value == 0) {
/* 106 */       throw DbException.get(22012, getSQL());
/*     */     }
/* 108 */     return get(this.value / valueInt.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value modulus(Value paramValue) {
/* 113 */     ValueInt valueInt = (ValueInt)paramValue;
/* 114 */     if (valueInt.value == 0) {
/* 115 */       throw DbException.get(22012, getSQL());
/*     */     }
/* 117 */     return get(this.value % valueInt.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 122 */     return getString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 127 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInt() {
/* 132 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong() {
/* 137 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 142 */     ValueInt valueInt = (ValueInt)paramValue;
/* 143 */     return MathUtils.compareInt(this.value, valueInt.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 148 */     return String.valueOf(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 153 */     return 10L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 158 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 163 */     return Integer.valueOf(this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 169 */     paramPreparedStatement.setInt(paramInt, this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 174 */     return 11;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 179 */     return (paramObject instanceof ValueInt && this.value == ((ValueInt)paramObject).value);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueInt.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */