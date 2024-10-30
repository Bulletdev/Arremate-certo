/*     */ package org.apache.commons.lang3.time;
/*     */ 
/*     */ import java.util.Date;
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
/*     */ class GmtTimeZone
/*     */   extends TimeZone
/*     */ {
/*     */   private static final int MILLISECONDS_PER_MINUTE = 60000;
/*     */   private static final int MINUTES_PER_HOUR = 60;
/*     */   private static final int HOURS_PER_DAY = 24;
/*     */   static final long serialVersionUID = 1L;
/*     */   private final int offset;
/*     */   private final String zoneId;
/*     */   
/*     */   GmtTimeZone(boolean paramBoolean, int paramInt1, int paramInt2) {
/*  40 */     if (paramInt1 >= 24) {
/*  41 */       throw new IllegalArgumentException(paramInt1 + " hours out of range");
/*     */     }
/*  43 */     if (paramInt2 >= 60) {
/*  44 */       throw new IllegalArgumentException(paramInt2 + " minutes out of range");
/*     */     }
/*  46 */     int i = (paramInt2 + paramInt1 * 60) * 60000;
/*  47 */     this.offset = paramBoolean ? -i : i;
/*  48 */     this
/*     */       
/*  50 */       .zoneId = twoDigits(twoDigits((new StringBuilder(9)).append("GMT").append(paramBoolean ? 45 : 43), paramInt1).append(':'), paramInt2).toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static StringBuilder twoDigits(StringBuilder paramStringBuilder, int paramInt) {
/*  55 */     return paramStringBuilder.append((char)(48 + paramInt / 10)).append((char)(48 + paramInt % 10));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOffset(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/*  60 */     return this.offset;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRawOffset(int paramInt) {
/*  65 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRawOffset() {
/*  70 */     return this.offset;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getID() {
/*  75 */     return this.zoneId;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useDaylightTime() {
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean inDaylightTime(Date paramDate) {
/*  85 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  90 */     return "[GmtTimeZone id=\"" + this.zoneId + "\",offset=" + this.offset + ']';
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  95 */     return this.offset;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 100 */     if (!(paramObject instanceof GmtTimeZone)) {
/* 101 */       return false;
/*     */     }
/* 103 */     return (this.zoneId == ((GmtTimeZone)paramObject).zoneId);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\time\GmtTimeZone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */