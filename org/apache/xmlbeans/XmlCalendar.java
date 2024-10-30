/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.TimeZone;
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
/*     */ public class XmlCalendar
/*     */   extends GregorianCalendar
/*     */ {
/*     */   public XmlCalendar(String paramString) {
/* 123 */     this(new GDate(paramString));
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
/*     */   public XmlCalendar(GDateSpecification paramGDateSpecification) {
/* 137 */     this(GDate.timeZoneForGDate(paramGDateSpecification), paramGDateSpecification);
/*     */   }
/*     */ 
/*     */   
/*     */   private XmlCalendar(TimeZone paramTimeZone, GDateSpecification paramGDateSpecification) {
/* 142 */     super(paramTimeZone);
/* 143 */     setGregorianChange(_beginningOfTime);
/* 144 */     clear();
/*     */     
/* 146 */     if (paramGDateSpecification.hasYear()) {
/*     */       
/* 148 */       int i = paramGDateSpecification.getYear();
/* 149 */       if (i > 0) {
/*     */         
/* 151 */         set(0, 1);
/*     */       }
/*     */       else {
/*     */         
/* 155 */         set(0, 0);
/*     */         
/* 157 */         i = -i;
/*     */       } 
/* 159 */       set(1, i);
/*     */     } 
/* 161 */     if (paramGDateSpecification.hasMonth())
/* 162 */       set(2, paramGDateSpecification.getMonth() - 1); 
/* 163 */     if (paramGDateSpecification.hasDay())
/* 164 */       set(5, paramGDateSpecification.getDay()); 
/* 165 */     if (paramGDateSpecification.hasTime()) {
/*     */       
/* 167 */       set(11, paramGDateSpecification.getHour());
/* 168 */       set(12, paramGDateSpecification.getMinute());
/* 169 */       set(13, paramGDateSpecification.getSecond());
/* 170 */       if (paramGDateSpecification.getFraction().scale() > 0)
/* 171 */         set(14, paramGDateSpecification.getMillisecond()); 
/*     */     } 
/* 173 */     if (paramGDateSpecification.hasTimeZone()) {
/*     */       
/* 175 */       set(15, paramGDateSpecification.getTimeZoneSign() * 1000 * 60 * (paramGDateSpecification.getTimeZoneHour() * 60 + paramGDateSpecification.getTimeZoneMinute()));
/* 176 */       set(16, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlCalendar(Date paramDate) {
/* 187 */     this(TimeZone.getDefault(), new GDate(paramDate));
/* 188 */     complete();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlCalendar(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, BigDecimal paramBigDecimal) {
/* 205 */     this(TimeZone.getDefault(), new GDate(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBigDecimal));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlCalendar(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, BigDecimal paramBigDecimal, int paramInt7, int paramInt8, int paramInt9) {
/* 225 */     this(new GDate(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBigDecimal, paramInt7, paramInt8, paramInt9));
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
/*     */   public int get(int paramInt) {
/* 238 */     if (!isSet(paramInt) || this.isTimeSet) {
/* 239 */       return super.get(paramInt);
/*     */     }
/* 241 */     return internalGet(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlCalendar() {
/* 249 */     setGregorianChange(_beginningOfTime);
/* 250 */     clear();
/*     */   }
/*     */   
/* 253 */   private static int defaultYear = Integer.MIN_VALUE;
/*     */ 
/*     */   
/*     */   private static final int DEFAULT_DEFAULT_YEAR = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getDefaultYear() {
/* 261 */     if (defaultYear == Integer.MIN_VALUE) {
/*     */       
/*     */       try {
/*     */         
/* 265 */         String str = SystemProperties.getProperty("user.defaultyear");
/* 266 */         if (str != null) {
/* 267 */           defaultYear = Integer.parseInt(str);
/*     */         } else {
/* 269 */           defaultYear = 0;
/*     */         } 
/* 271 */       } catch (Throwable throwable) {
/*     */         
/* 273 */         defaultYear = 0;
/*     */       } 
/*     */     }
/* 276 */     return defaultYear;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setDefaultYear(int paramInt) {
/* 284 */     defaultYear = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void computeTime() {
/* 293 */     boolean bool = !isSet(1) ? true : false;
/* 294 */     if (bool) {
/* 295 */       set(1, getDefaultYear());
/*     */     }
/*     */     try {
/* 298 */       super.computeTime();
/*     */     }
/*     */     finally {
/*     */       
/* 302 */       if (bool)
/* 303 */         clear(1); 
/*     */     } 
/*     */   }
/*     */   
/* 307 */   private static Date _beginningOfTime = new Date(Long.MIN_VALUE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 315 */     return (new GDate(this)).toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlCalendar.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */