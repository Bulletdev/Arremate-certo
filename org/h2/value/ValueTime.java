/*     */ package org.h2.value;
/*     */ 
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Time;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.DateTimeUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.StringUtils;
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
/*     */ public class ValueTime
/*     */   extends Value
/*     */ {
/*     */   public static final int PRECISION = 6;
/*     */   static final int DISPLAY_SIZE = 8;
/*     */   private final long nanos;
/*     */   
/*     */   private ValueTime(long paramLong) {
/*  42 */     this.nanos = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueTime fromNanos(long paramLong) {
/*  52 */     return (ValueTime)Value.cache(new ValueTime(paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueTime get(Time paramTime) {
/*  62 */     return fromNanos(DateTimeUtils.nanosFromDate(paramTime.getTime()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueTime fromMillis(long paramLong) {
/*  73 */     return fromNanos(DateTimeUtils.nanosFromDate(paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueTime parse(String paramString) {
/*     */     try {
/*  84 */       return fromNanos(DateTimeUtils.parseTimeNanos(paramString, 0, paramString.length(), false));
/*  85 */     } catch (Exception exception) {
/*  86 */       throw DbException.get(22007, exception, new String[] { "TIME", paramString });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getNanos() {
/*  95 */     return this.nanos;
/*     */   }
/*     */ 
/*     */   
/*     */   public Time getTime() {
/* 100 */     return DateTimeUtils.convertNanoToTime(this.nanos);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 105 */     return 9;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 110 */     StringBuilder stringBuilder = new StringBuilder(8);
/* 111 */     appendTime(stringBuilder, this.nanos, false);
/* 112 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 117 */     return "TIME '" + getString() + "'";
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 122 */     return 6L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 127 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 132 */     return MathUtils.compareLong(this.nanos, ((ValueTime)paramValue).nanos);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 137 */     if (this == paramObject) {
/* 138 */       return true;
/*     */     }
/* 140 */     return (paramObject instanceof ValueTime && this.nanos == ((ValueTime)paramObject).nanos);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 145 */     return (int)(this.nanos ^ this.nanos >>> 32L);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 150 */     return getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 156 */     paramPreparedStatement.setTime(paramInt, getTime());
/*     */   }
/*     */ 
/*     */   
/*     */   public Value add(Value paramValue) {
/* 161 */     ValueTime valueTime = (ValueTime)paramValue.convertTo(9);
/* 162 */     return fromNanos(this.nanos + valueTime.getNanos());
/*     */   }
/*     */ 
/*     */   
/*     */   public Value subtract(Value paramValue) {
/* 167 */     ValueTime valueTime = (ValueTime)paramValue.convertTo(9);
/* 168 */     return fromNanos(this.nanos - valueTime.getNanos());
/*     */   }
/*     */ 
/*     */   
/*     */   public Value multiply(Value paramValue) {
/* 173 */     return fromNanos((long)(this.nanos * paramValue.getDouble()));
/*     */   }
/*     */ 
/*     */   
/*     */   public Value divide(Value paramValue) {
/* 178 */     return fromNanos((long)(this.nanos / paramValue.getDouble()));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSignum() {
/* 183 */     return Long.signum(this.nanos);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value negate() {
/* 188 */     return fromNanos(-this.nanos);
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
/*     */   static void appendTime(StringBuilder paramStringBuilder, long paramLong, boolean paramBoolean) {
/* 200 */     if (paramLong < 0L) {
/* 201 */       paramStringBuilder.append('-');
/* 202 */       paramLong = -paramLong;
/*     */     } 
/* 204 */     long l1 = paramLong / 1000000L;
/* 205 */     paramLong -= l1 * 1000000L;
/* 206 */     long l2 = l1 / 1000L;
/* 207 */     l1 -= l2 * 1000L;
/* 208 */     long l3 = l2 / 60L;
/* 209 */     l2 -= l3 * 60L;
/* 210 */     long l4 = l3 / 60L;
/* 211 */     l3 -= l4 * 60L;
/* 212 */     StringUtils.appendZeroPadded(paramStringBuilder, 2, l4);
/* 213 */     paramStringBuilder.append(':');
/* 214 */     StringUtils.appendZeroPadded(paramStringBuilder, 2, l3);
/* 215 */     paramStringBuilder.append(':');
/* 216 */     StringUtils.appendZeroPadded(paramStringBuilder, 2, l2);
/* 217 */     if (paramBoolean || l1 > 0L || paramLong > 0L) {
/* 218 */       paramStringBuilder.append('.');
/* 219 */       int i = paramStringBuilder.length();
/* 220 */       StringUtils.appendZeroPadded(paramStringBuilder, 3, l1);
/* 221 */       if (paramLong > 0L) {
/* 222 */         StringUtils.appendZeroPadded(paramStringBuilder, 6, paramLong);
/*     */       }
/* 224 */       for (int j = paramStringBuilder.length() - 1; j > i && 
/* 225 */         paramStringBuilder.charAt(j) == '0'; j--)
/*     */       {
/*     */         
/* 228 */         paramStringBuilder.deleteCharAt(j);
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueTime.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */