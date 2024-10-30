/*    */ package oshi.util;
/*    */ 
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
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
/*    */ @ThreadSafe
/*    */ public final class Util
/*    */ {
/* 36 */   private static final Logger LOG = LoggerFactory.getLogger(Util.class);
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
/*    */   public static void sleep(long paramLong) {
/*    */     try {
/* 49 */       LOG.trace("Sleeping for {} ms", Long.valueOf(paramLong));
/* 50 */       Thread.sleep(paramLong);
/* 51 */     } catch (InterruptedException interruptedException) {
/* 52 */       LOG.warn("Interrupted while sleeping for {} ms: {}", Long.valueOf(paramLong), interruptedException.getMessage());
/* 53 */       Thread.currentThread().interrupt();
/*    */     } 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean wildcardMatch(String paramString1, String paramString2) {
/* 72 */     if (paramString2.length() > 0 && paramString2.charAt(0) == '^') {
/* 73 */       return !wildcardMatch(paramString1, paramString2.substring(1));
/*    */     }
/* 75 */     return paramString1.matches(paramString2.replace("?", ".?").replace("*", ".*?"));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isBlank(String paramString) {
/* 86 */     return (paramString == null || paramString.isEmpty());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isBlankOrUnknown(String paramString) {
/* 97 */     return (isBlank(paramString) || "unknown".equals(paramString));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\Util.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */