/*    */ package ch.qos.logback.core.util;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.TimeZone;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CachingDateFormatter
/*    */ {
/* 28 */   long lastTimestamp = -1L;
/* 29 */   String cachedStr = null;
/*    */   final SimpleDateFormat sdf;
/*    */   
/*    */   public CachingDateFormatter(String paramString) {
/* 33 */     this.sdf = new SimpleDateFormat(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final String format(long paramLong) {
/* 45 */     synchronized (this) {
/* 46 */       if (paramLong != this.lastTimestamp) {
/* 47 */         this.lastTimestamp = paramLong;
/* 48 */         this.cachedStr = this.sdf.format(new Date(paramLong));
/*    */       } 
/* 50 */       return this.cachedStr;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setTimeZone(TimeZone paramTimeZone) {
/* 55 */     this.sdf.setTimeZone(paramTimeZone);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\CachingDateFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */