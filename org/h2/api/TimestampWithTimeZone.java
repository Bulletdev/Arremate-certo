/*     */ package org.h2.api;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.h2.util.DateTimeUtils;
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
/*     */ public class TimestampWithTimeZone
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 4413229090646777107L;
/*     */   private final long dateValue;
/*     */   private final long timeNanos;
/*     */   private final short timeZoneOffsetMins;
/*     */   
/*     */   public TimestampWithTimeZone(long paramLong1, long paramLong2, short paramShort) {
/*  37 */     this.dateValue = paramLong1;
/*  38 */     this.timeNanos = paramLong2;
/*  39 */     this.timeZoneOffsetMins = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getYMD() {
/*  46 */     return this.dateValue;
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
/*     */   public int getYear() {
/*  59 */     return DateTimeUtils.yearFromDateValue(this.dateValue);
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
/*     */   public int getMonth() {
/*  72 */     return DateTimeUtils.monthFromDateValue(this.dateValue);
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
/*     */   public int getDay() {
/*  85 */     return DateTimeUtils.dayFromDateValue(this.dateValue);
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
/*     */   public long getNanosSinceMidnight() {
/*  99 */     return this.timeNanos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getTimeZoneOffsetMins() {
/* 108 */     return this.timeZoneOffsetMins;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder stringBuilder = new StringBuilder();
/* 114 */     int i = DateTimeUtils.yearFromDateValue(this.dateValue);
/* 115 */     int j = DateTimeUtils.monthFromDateValue(this.dateValue);
/* 116 */     int k = DateTimeUtils.dayFromDateValue(this.dateValue);
/* 117 */     if (i > 0 && i < 10000) {
/* 118 */       StringUtils.appendZeroPadded(stringBuilder, 4, i);
/*     */     } else {
/* 120 */       stringBuilder.append(i);
/*     */     } 
/* 122 */     stringBuilder.append('-');
/* 123 */     StringUtils.appendZeroPadded(stringBuilder, 2, j);
/* 124 */     stringBuilder.append('-');
/* 125 */     StringUtils.appendZeroPadded(stringBuilder, 2, k);
/* 126 */     stringBuilder.append(' ');
/* 127 */     long l1 = this.timeNanos;
/* 128 */     long l2 = l1 / 1000000L;
/* 129 */     l1 -= l2 * 1000000L;
/* 130 */     long l3 = l2 / 1000L;
/* 131 */     l2 -= l3 * 1000L;
/* 132 */     long l4 = l3 / 60L;
/* 133 */     l3 -= l4 * 60L;
/* 134 */     long l5 = l4 / 60L;
/* 135 */     l4 -= l5 * 60L;
/* 136 */     StringUtils.appendZeroPadded(stringBuilder, 2, l5);
/* 137 */     stringBuilder.append(':');
/* 138 */     StringUtils.appendZeroPadded(stringBuilder, 2, l4);
/* 139 */     stringBuilder.append(':');
/* 140 */     StringUtils.appendZeroPadded(stringBuilder, 2, l3);
/* 141 */     stringBuilder.append('.');
/* 142 */     int m = stringBuilder.length();
/* 143 */     StringUtils.appendZeroPadded(stringBuilder, 3, l2);
/* 144 */     if (l1 > 0L)
/* 145 */       StringUtils.appendZeroPadded(stringBuilder, 6, l1); 
/*     */     int n;
/* 147 */     for (n = stringBuilder.length() - 1; n > m && 
/* 148 */       stringBuilder.charAt(n) == '0'; n--)
/*     */     {
/*     */       
/* 151 */       stringBuilder.deleteCharAt(n);
/*     */     }
/* 153 */     n = this.timeZoneOffsetMins;
/* 154 */     if (n < 0) {
/* 155 */       stringBuilder.append('-');
/* 156 */       n = (short)-n;
/*     */     } else {
/* 158 */       stringBuilder.append('+');
/*     */     } 
/* 160 */     int i1 = n / 60;
/* 161 */     n = (short)(n - i1 * 60);
/* 162 */     int i2 = n;
/* 163 */     StringUtils.appendZeroPadded(stringBuilder, 2, i1);
/* 164 */     if (i2 != 0) {
/* 165 */       stringBuilder.append(':');
/* 166 */       StringUtils.appendZeroPadded(stringBuilder, 2, i2);
/*     */     } 
/* 168 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 174 */     int i = 1;
/* 175 */     i = 31 * i + (int)(this.dateValue ^ this.dateValue >>> 32L);
/* 176 */     i = 31 * i + (int)(this.timeNanos ^ this.timeNanos >>> 32L);
/* 177 */     i = 31 * i + this.timeZoneOffsetMins;
/* 178 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 183 */     if (this == paramObject)
/* 184 */       return true; 
/* 185 */     if (paramObject == null)
/* 186 */       return false; 
/* 187 */     if (getClass() != paramObject.getClass())
/* 188 */       return false; 
/* 189 */     TimestampWithTimeZone timestampWithTimeZone = (TimestampWithTimeZone)paramObject;
/* 190 */     if (this.dateValue != timestampWithTimeZone.dateValue)
/* 191 */       return false; 
/* 192 */     if (this.timeNanos != timestampWithTimeZone.timeNanos)
/* 193 */       return false; 
/* 194 */     if (this.timeZoneOffsetMins != timestampWithTimeZone.timeZoneOffsetMins)
/* 195 */       return false; 
/* 196 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\api\TimestampWithTimeZone.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */