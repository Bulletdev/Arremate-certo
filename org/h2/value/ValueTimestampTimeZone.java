/*     */ package org.h2.value;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.TimeZone;
/*     */ import org.h2.api.TimestampWithTimeZone;
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
/*     */ public class ValueTimestampTimeZone
/*     */   extends Value
/*     */ {
/*  28 */   private static final TimeZone GMT_TIMEZONE = TimeZone.getTimeZone("GMT");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int PRECISION = 30;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int DISPLAY_SIZE = 30;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int DEFAULT_SCALE = 10;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final long dateValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final long timeNanos;
/*     */ 
/*     */ 
/*     */   
/*     */   private final short timeZoneOffsetMins;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ValueTimestampTimeZone(long paramLong1, long paramLong2, short paramShort) {
/*  62 */     if (paramLong2 < 0L || paramLong2 >= 86400000000000L) {
/*  63 */       throw new IllegalArgumentException("timeNanos out of range " + paramLong2);
/*     */     }
/*     */     
/*  66 */     if (paramShort < -720 || paramShort >= 720)
/*     */     {
/*  68 */       throw new IllegalArgumentException("timeZoneOffsetMins out of range " + paramShort);
/*     */     }
/*     */     
/*  71 */     this.dateValue = paramLong1;
/*  72 */     this.timeNanos = paramLong2;
/*  73 */     this.timeZoneOffsetMins = paramShort;
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
/*     */   public static ValueTimestampTimeZone fromDateValueAndNanos(long paramLong1, long paramLong2, short paramShort) {
/*  87 */     return (ValueTimestampTimeZone)Value.cache(new ValueTimestampTimeZone(paramLong1, paramLong2, paramShort));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueTimestampTimeZone get(TimestampWithTimeZone paramTimestampWithTimeZone) {
/*  98 */     return fromDateValueAndNanos(paramTimestampWithTimeZone.getYMD(), paramTimestampWithTimeZone.getNanosSinceMidnight(), paramTimestampWithTimeZone.getTimeZoneOffsetMins());
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
/*     */   public static ValueTimestampTimeZone parse(String paramString) {
/*     */     try {
/* 113 */       return parseTry(paramString);
/* 114 */     } catch (Exception exception) {
/* 115 */       throw DbException.get(22007, exception, new String[] { "TIMESTAMP WITH TIMEZONE", paramString });
/*     */     } 
/*     */   }
/*     */   private static ValueTimestampTimeZone parseTry(String paramString) {
/*     */     int j;
/*     */     long l2;
/* 121 */     int i = paramString.indexOf(' ');
/* 122 */     if (i < 0)
/*     */     {
/* 124 */       i = paramString.indexOf('T');
/*     */     }
/*     */     
/* 127 */     if (i < 0) {
/* 128 */       i = paramString.length();
/* 129 */       j = -1;
/*     */     } else {
/* 131 */       j = i + 1;
/*     */     } 
/* 133 */     long l1 = DateTimeUtils.parseDateValue(paramString, 0, i);
/*     */     
/* 135 */     short s = 0;
/* 136 */     if (j < 0) {
/* 137 */       l2 = 0L;
/*     */     } else {
/* 139 */       int k = paramString.length();
/* 140 */       if (paramString.endsWith("Z")) {
/* 141 */         k--;
/*     */       } else {
/* 143 */         int m = paramString.indexOf('+', i);
/* 144 */         if (m < 0) {
/* 145 */           m = paramString.indexOf('-', i);
/*     */         }
/* 147 */         TimeZone timeZone = null;
/* 148 */         if (m >= 0) {
/* 149 */           String str = "GMT" + paramString.substring(m);
/* 150 */           timeZone = TimeZone.getTimeZone(str);
/* 151 */           if (!timeZone.getID().startsWith(str)) {
/* 152 */             throw new IllegalArgumentException(str + " (" + timeZone.getID() + "?)");
/*     */           }
/*     */           
/* 155 */           k = m;
/*     */         } else {
/* 157 */           m = paramString.indexOf(' ', i + 1);
/* 158 */           if (m > 0) {
/* 159 */             String str = paramString.substring(m + 1);
/* 160 */             timeZone = TimeZone.getTimeZone(str);
/* 161 */             if (!timeZone.getID().startsWith(str)) {
/* 162 */               throw new IllegalArgumentException(str);
/*     */             }
/* 164 */             k = m;
/*     */           } 
/*     */         } 
/* 167 */         if (timeZone != null) {
/* 168 */           long l = DateTimeUtils.convertDateValueToMillis(GMT_TIMEZONE, l1);
/*     */           
/* 170 */           s = (short)(timeZone.getOffset(l) / 1000 / 60);
/*     */         } 
/*     */       } 
/* 173 */       l2 = DateTimeUtils.parseTimeNanos(paramString, i + 1, k, true);
/*     */     } 
/* 175 */     return fromDateValueAndNanos(l1, l2, s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDateValue() {
/* 186 */     return this.dateValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTimeNanos() {
/* 195 */     return this.timeNanos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getTimeZoneOffsetMins() {
/* 204 */     return this.timeZoneOffsetMins;
/*     */   }
/*     */ 
/*     */   
/*     */   public Timestamp getTimestamp() {
/* 209 */     throw new UnsupportedOperationException("unimplemented");
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 214 */     return 24;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 219 */     StringBuilder stringBuilder = new StringBuilder(30);
/* 220 */     ValueDate.appendDate(stringBuilder, this.dateValue);
/* 221 */     stringBuilder.append(' ');
/* 222 */     ValueTime.appendTime(stringBuilder, this.timeNanos, true);
/* 223 */     appendTimeZone(stringBuilder, this.timeZoneOffsetMins);
/* 224 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void appendTimeZone(StringBuilder paramStringBuilder, short paramShort) {
/* 234 */     if (paramShort < 0) {
/* 235 */       paramStringBuilder.append('-');
/* 236 */       paramShort = (short)-paramShort;
/*     */     } else {
/* 238 */       paramStringBuilder.append('+');
/*     */     } 
/* 240 */     int i = paramShort / 60;
/* 241 */     paramShort = (short)(paramShort - i * 60);
/* 242 */     short s = paramShort;
/* 243 */     StringUtils.appendZeroPadded(paramStringBuilder, 2, i);
/* 244 */     if (s != 0) {
/* 245 */       paramStringBuilder.append(':');
/* 246 */       StringUtils.appendZeroPadded(paramStringBuilder, 2, s);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 252 */     return "TIMESTAMP WITH TIMEZONE '" + getString() + "'";
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 257 */     return 30L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/* 262 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 267 */     return 30;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value convertScale(boolean paramBoolean, int paramInt) {
/* 272 */     if (paramInt >= 10) {
/* 273 */       return this;
/*     */     }
/* 275 */     if (paramInt < 0) {
/* 276 */       throw DbException.getInvalidValueException("scale", Integer.valueOf(paramInt));
/*     */     }
/* 278 */     long l1 = this.timeNanos;
/* 279 */     BigDecimal bigDecimal = BigDecimal.valueOf(l1);
/* 280 */     bigDecimal = bigDecimal.movePointLeft(9);
/* 281 */     bigDecimal = ValueDecimal.setScale(bigDecimal, paramInt);
/* 282 */     bigDecimal = bigDecimal.movePointRight(9);
/* 283 */     long l2 = bigDecimal.longValue();
/* 284 */     if (l2 == l1) {
/* 285 */       return this;
/*     */     }
/* 287 */     return fromDateValueAndNanos(this.dateValue, l2, this.timeZoneOffsetMins);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 292 */     ValueTimestampTimeZone valueTimestampTimeZone = (ValueTimestampTimeZone)paramValue;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 297 */     long l1 = DateTimeUtils.convertDateValueToMillis(TimeZone.getTimeZone("UTC"), this.dateValue) / 60000L;
/*     */ 
/*     */     
/* 300 */     long l2 = this.timeNanos / 60000000000L;
/* 301 */     l1 += l2;
/* 302 */     l1 -= this.timeZoneOffsetMins;
/*     */ 
/*     */     
/* 305 */     long l3 = DateTimeUtils.convertDateValueToMillis(TimeZone.getTimeZone("UTC"), valueTimestampTimeZone.dateValue) / 60000L;
/*     */ 
/*     */     
/* 308 */     long l4 = valueTimestampTimeZone.timeNanos / 60000000000L;
/* 309 */     l3 += l4;
/* 310 */     l3 -= valueTimestampTimeZone.timeZoneOffsetMins;
/*     */ 
/*     */     
/* 313 */     int i = MathUtils.compareLong(l1, l3);
/* 314 */     if (i != 0) {
/* 315 */       return i;
/*     */     }
/*     */     
/* 318 */     long l5 = this.timeNanos - l2 * 1000L * 1000L * 1000L * 60L;
/* 319 */     long l6 = valueTimestampTimeZone.timeNanos - l4 * 1000L * 1000L * 1000L * 60L;
/* 320 */     return MathUtils.compareLong(l5, l6);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 325 */     if (this == paramObject)
/* 326 */       return true; 
/* 327 */     if (!(paramObject instanceof ValueTimestampTimeZone)) {
/* 328 */       return false;
/*     */     }
/* 330 */     ValueTimestampTimeZone valueTimestampTimeZone = (ValueTimestampTimeZone)paramObject;
/* 331 */     return (this.dateValue == valueTimestampTimeZone.dateValue && this.timeNanos == valueTimestampTimeZone.timeNanos && this.timeZoneOffsetMins == valueTimestampTimeZone.timeZoneOffsetMins);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 337 */     return (int)(this.dateValue ^ this.dateValue >>> 32L ^ this.timeNanos ^ this.timeNanos >>> 32L ^ this.timeZoneOffsetMins);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 343 */     return new TimestampWithTimeZone(this.dateValue, this.timeNanos, this.timeZoneOffsetMins);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 350 */     paramPreparedStatement.setString(paramInt, getString());
/*     */   }
/*     */ 
/*     */   
/*     */   public Value add(Value paramValue) {
/* 355 */     throw DbException.getUnsupportedException("manipulating TIMESTAMP WITH TIMEZONE values is unsupported");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Value subtract(Value paramValue) {
/* 361 */     throw DbException.getUnsupportedException("manipulating TIMESTAMP WITH TIMEZONE values is unsupported");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueTimestampTimeZone.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */