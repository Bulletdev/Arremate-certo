/*    */ package ch.qos.logback.classic.turbo;
/*    */ 
/*    */ import ch.qos.logback.classic.Level;
/*    */ import ch.qos.logback.classic.Logger;
/*    */ import ch.qos.logback.core.spi.FilterReply;
/*    */ import org.slf4j.Marker;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DuplicateMessageFilter
/*    */   extends TurboFilter
/*    */ {
/*    */   public static final int DEFAULT_CACHE_SIZE = 100;
/*    */   public static final int DEFAULT_ALLOWED_REPETITIONS = 5;
/* 41 */   public int allowedRepetitions = 5;
/* 42 */   public int cacheSize = 100;
/*    */   
/*    */   private a msgCache;
/*    */ 
/*    */   
/*    */   public void start() {
/* 48 */     this.msgCache = new a(this.cacheSize);
/* 49 */     super.start();
/*    */   }
/*    */ 
/*    */   
/*    */   public void stop() {
/* 54 */     this.msgCache.clear();
/* 55 */     this.msgCache = null;
/* 56 */     super.stop();
/*    */   }
/*    */ 
/*    */   
/*    */   public FilterReply decide(Marker paramMarker, Logger paramLogger, Level paramLevel, String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 61 */     int i = this.msgCache.c(paramString);
/* 62 */     if (i <= this.allowedRepetitions) {
/* 63 */       return FilterReply.NEUTRAL;
/*    */     }
/* 65 */     return FilterReply.DENY;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getAllowedRepetitions() {
/* 70 */     return this.allowedRepetitions;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAllowedRepetitions(int paramInt) {
/* 79 */     this.allowedRepetitions = paramInt;
/*    */   }
/*    */   
/*    */   public int getCacheSize() {
/* 83 */     return this.cacheSize;
/*    */   }
/*    */   
/*    */   public void setCacheSize(int paramInt) {
/* 87 */     this.cacheSize = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\turbo\DuplicateMessageFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */