/*     */ package org.h2.value;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Calendar;
/*     */ import java.util.TimeZone;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.DateTimeUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueTimestamp
/*     */   extends Value
/*     */ {
/*     */   public static final int PRECISION = 23;
/*     */   static final int DISPLAY_SIZE = 23;
/*     */   static final int DEFAULT_SCALE = 10;
/*     */   private final long dateValue;
/*     */   private final long timeNanos;
/*     */   
/*     */   private ValueTimestamp(long paramLong1, long paramLong2) {
/*  52 */     this.dateValue = paramLong1;
/*  53 */     if (paramLong2 < 0L || paramLong2 >= 86400000000000L) {
/*  54 */       throw new IllegalArgumentException("timeNanos out of range " + paramLong2);
/*     */     }
/*  56 */     this.timeNanos = paramLong2;
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
/*     */   public static ValueTimestamp fromDateValueAndNanos(long paramLong1, long paramLong2) {
/*  68 */     return (ValueTimestamp)Value.cache(new ValueTimestamp(paramLong1, paramLong2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueTimestamp get(Timestamp paramTimestamp) {
/*  78 */     long l1 = paramTimestamp.getTime();
/*  79 */     long l2 = (paramTimestamp.getNanos() % 1000000);
/*  80 */     long l3 = DateTimeUtils.dateValueFromDate(l1);
/*  81 */     l2 += DateTimeUtils.nanosFromDate(l1);
/*  82 */     return fromDateValueAndNanos(l3, l2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueTimestamp fromMillisNanos(long paramLong, int paramInt) {
/*  93 */     long l1 = DateTimeUtils.dateValueFromDate(paramLong);
/*  94 */     long l2 = paramInt + DateTimeUtils.nanosFromDate(paramLong);
/*  95 */     return fromDateValueAndNanos(l1, l2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueTimestamp fromMillis(long paramLong) {
/* 105 */     long l1 = DateTimeUtils.dateValueFromDate(paramLong);
/* 106 */     long l2 = DateTimeUtils.nanosFromDate(paramLong);
/* 107 */     return fromDateValueAndNanos(l1, l2);
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
/*     */   public static ValueTimestamp parse(String paramString) {
/*     */     try {
/* 120 */       return parseTry(paramString);
/* 121 */     } catch (Exception exception) {
/* 122 */       throw DbException.get(22007, exception, new String[] { "TIMESTAMP", paramString });
/*     */     } 
/*     */   }
/*     */   private static ValueTimestamp parseTry(String paramString) {
/*     */     int j;
/*     */     long l2;
/* 128 */     int i = paramString.indexOf(' ');
/* 129 */     if (i < 0)
/*     */     {
/* 131 */       i = paramString.indexOf('T');
/*     */     }
/*     */     
/* 134 */     if (i < 0) {
/* 135 */       i = paramString.length();
/* 136 */       j = -1;
/*     */     } else {
/* 138 */       j = i + 1;
/*     */     } 
/* 140 */     long l1 = DateTimeUtils.parseDateValue(paramString, 0, i);
/*     */     
/* 142 */     if (j < 0) {
/* 143 */       l2 = 0L;
/*     */     } else {
/* 145 */       int k = paramString.length();
/* 146 */       TimeZone timeZone = null;
/* 147 */       if (paramString.endsWith("Z")) {
/* 148 */         timeZone = TimeZone.getTimeZone("UTC");
/* 149 */         k--;
/*     */       } else {
/* 151 */         int m = paramString.indexOf('+', i);
/* 152 */         if (m < 0) {
/* 153 */           m = paramString.indexOf('-', i);
/*     */         }
/* 155 */         if (m >= 0) {
/* 156 */           String str = "GMT" + paramString.substring(m);
/* 157 */           timeZone = TimeZone.getTimeZone(str);
/* 158 */           if (!timeZone.getID().startsWith(str)) {
/* 159 */             throw new IllegalArgumentException(str + " (" + timeZone.getID() + "?)");
/*     */           }
/*     */           
/* 162 */           k = m;
/*     */         } else {
/* 164 */           m = paramString.indexOf(' ', i + 1);
/* 165 */           if (m > 0) {
/* 166 */             String str = paramString.substring(m + 1);
/* 167 */             timeZone = TimeZone.getTimeZone(str);
/* 168 */             if (!timeZone.getID().startsWith(str)) {
/* 169 */               throw new IllegalArgumentException(str);
/*     */             }
/* 171 */             k = m;
/*     */           } 
/*     */         } 
/*     */       } 
/* 175 */       l2 = DateTimeUtils.parseTimeNanos(paramString, i + 1, k, true);
/* 176 */       if (timeZone != null) {
/* 177 */         int m = DateTimeUtils.yearFromDateValue(l1);
/* 178 */         int n = DateTimeUtils.monthFromDateValue(l1);
/* 179 */         int i1 = DateTimeUtils.dayFromDateValue(l1);
/* 180 */         long l3 = l2 / 1000000L;
/* 181 */         l2 -= l3 * 1000000L;
/* 182 */         long l4 = l3 / 1000L;
/* 183 */         l3 -= l4 * 1000L;
/* 184 */         int i2 = (int)(l4 / 60L);
/* 185 */         l4 -= (i2 * 60);
/* 186 */         int i3 = i2 / 60;
/* 187 */         i2 -= i3 * 60;
/* 188 */         long l5 = DateTimeUtils.getMillis(timeZone, m, n, i1, i3, i2, (int)l4, (int)l3);
/*     */         
/* 190 */         l3 = DateTimeUtils.convertToLocal(new Date(l5), Calendar.getInstance(TimeZone.getTimeZone("UTC")));
/*     */ 
/*     */         
/* 193 */         long l6 = 86400000L;
/* 194 */         long l7 = ((l3 >= 0L) ? l3 : (l3 - l6 + 1L)) / l6;
/* 195 */         l1 = DateTimeUtils.dateValueFromAbsoluteDay(l7);
/* 196 */         l3 -= l7 * l6;
/* 197 */         l2 += l3 * 1000000L;
/*     */       } 
/*     */     } 
/* 200 */     return fromDateValueAndNanos(l1, l2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDateValue() {
/* 210 */     return this.dateValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTimeNanos() {
/* 219 */     return this.timeNanos;
/*     */   }
/*     */ 
/*     */   
/*     */   public Timestamp getTimestamp() {
/* 224 */     return DateTimeUtils.convertDateValueToTimestamp(this.dateValue, this.timeNanos);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 229 */     return 11;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 234 */     StringBuilder stringBuilder = new StringBuilder(23);
/* 235 */     ValueDate.appendDate(stringBuilder, this.dateValue);
/* 236 */     stringBuilder.append(' ');
/* 237 */     ValueTime.appendTime(stringBuilder, this.timeNanos, true);
/* 238 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 243 */     return "TIMESTAMP '" + getString() + "'";
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 248 */     return 23L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/* 253 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 258 */     return 23;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value convertScale(boolean paramBoolean, int paramInt) {
/* 263 */     if (paramInt >= 10) {
/* 264 */       return this;
/*     */     }
/* 266 */     if (paramInt < 0) {
/* 267 */       throw DbException.getInvalidValueException("scale", Integer.valueOf(paramInt));
/*     */     }
/* 269 */     long l1 = this.timeNanos;
/* 270 */     BigDecimal bigDecimal = BigDecimal.valueOf(l1);
/* 271 */     bigDecimal = bigDecimal.movePointLeft(9);
/* 272 */     bigDecimal = ValueDecimal.setScale(bigDecimal, paramInt);
/* 273 */     bigDecimal = bigDecimal.movePointRight(9);
/* 274 */     long l2 = bigDecimal.longValue();
/* 275 */     if (l2 == l1) {
/* 276 */       return this;
/*     */     }
/* 278 */     return fromDateValueAndNanos(this.dateValue, l2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 283 */     ValueTimestamp valueTimestamp = (ValueTimestamp)paramValue;
/* 284 */     int i = MathUtils.compareLong(this.dateValue, valueTimestamp.dateValue);
/* 285 */     if (i != 0) {
/* 286 */       return i;
/*     */     }
/* 288 */     return MathUtils.compareLong(this.timeNanos, valueTimestamp.timeNanos);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 293 */     if (this == paramObject)
/* 294 */       return true; 
/* 295 */     if (!(paramObject instanceof ValueTimestamp)) {
/* 296 */       return false;
/*     */     }
/* 298 */     ValueTimestamp valueTimestamp = (ValueTimestamp)paramObject;
/* 299 */     return (this.dateValue == valueTimestamp.dateValue && this.timeNanos == valueTimestamp.timeNanos);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 304 */     return (int)(this.dateValue ^ this.dateValue >>> 32L ^ this.timeNanos ^ this.timeNanos >>> 32L);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 309 */     return getTimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 315 */     paramPreparedStatement.setTimestamp(paramInt, getTimestamp());
/*     */   }
/*     */ 
/*     */   
/*     */   public Value add(Value paramValue) {
/* 320 */     ValueTimestamp valueTimestamp = (ValueTimestamp)paramValue.convertTo(11);
/* 321 */     long l1 = DateTimeUtils.absoluteDayFromDateValue(this.dateValue);
/* 322 */     long l2 = DateTimeUtils.absoluteDayFromDateValue(valueTimestamp.dateValue);
/* 323 */     return DateTimeUtils.normalizeTimestamp(l1 + l2, this.timeNanos + valueTimestamp.timeNanos);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value subtract(Value paramValue) {
/* 328 */     ValueTimestamp valueTimestamp = (ValueTimestamp)paramValue.convertTo(11);
/* 329 */     long l1 = DateTimeUtils.absoluteDayFromDateValue(this.dateValue);
/* 330 */     long l2 = DateTimeUtils.absoluteDayFromDateValue(valueTimestamp.dateValue);
/* 331 */     return DateTimeUtils.normalizeTimestamp(l1 - l2, this.timeNanos - valueTimestamp.timeNanos);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueTimestamp.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */