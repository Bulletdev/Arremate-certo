/*     */ package org.h2.value;
/*     */ 
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
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
/*     */ public class ValueDate
/*     */   extends Value
/*     */ {
/*     */   public static final int PRECISION = 8;
/*     */   public static final int DISPLAY_SIZE = 10;
/*     */   private final long dateValue;
/*     */   
/*     */   private ValueDate(long paramLong) {
/*  37 */     this.dateValue = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueDate fromDateValue(long paramLong) {
/*  47 */     return (ValueDate)Value.cache(new ValueDate(paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueDate get(Date paramDate) {
/*  57 */     return fromDateValue(DateTimeUtils.dateValueFromDate(paramDate.getTime()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueDate fromMillis(long paramLong) {
/*  68 */     return fromDateValue(DateTimeUtils.dateValueFromDate(paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueDate parse(String paramString) {
/*     */     try {
/*  79 */       return fromDateValue(DateTimeUtils.parseDateValue(paramString, 0, paramString.length()));
/*  80 */     } catch (Exception exception) {
/*  81 */       throw DbException.get(22007, exception, new String[] { "DATE", paramString });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDateValue() {
/*  87 */     return this.dateValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDate() {
/*  92 */     return DateTimeUtils.convertDateValueToDate(this.dateValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  97 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 102 */     StringBuilder stringBuilder = new StringBuilder(10);
/* 103 */     appendDate(stringBuilder, this.dateValue);
/* 104 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 109 */     return "DATE '" + getString() + "'";
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 114 */     return 8L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 119 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 124 */     return MathUtils.compareLong(this.dateValue, ((ValueDate)paramValue).dateValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 129 */     if (this == paramObject) {
/* 130 */       return true;
/*     */     }
/* 132 */     return (paramObject instanceof ValueDate && this.dateValue == ((ValueDate)paramObject).dateValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 138 */     return (int)(this.dateValue ^ this.dateValue >>> 32L);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 143 */     return getDate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 149 */     paramPreparedStatement.setDate(paramInt, getDate());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void appendDate(StringBuilder paramStringBuilder, long paramLong) {
/* 159 */     int i = DateTimeUtils.yearFromDateValue(paramLong);
/* 160 */     int j = DateTimeUtils.monthFromDateValue(paramLong);
/* 161 */     int k = DateTimeUtils.dayFromDateValue(paramLong);
/* 162 */     if (i > 0 && i < 10000) {
/* 163 */       StringUtils.appendZeroPadded(paramStringBuilder, 4, i);
/*     */     } else {
/* 165 */       paramStringBuilder.append(i);
/*     */     } 
/* 167 */     paramStringBuilder.append('-');
/* 168 */     StringUtils.appendZeroPadded(paramStringBuilder, 2, j);
/* 169 */     paramStringBuilder.append('-');
/* 170 */     StringUtils.appendZeroPadded(paramStringBuilder, 2, k);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueDate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */