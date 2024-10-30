/*    */ package org.apache.poi.util;
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
/*    */ public class SystemOutLogger
/*    */   extends POILogger
/*    */ {
/*    */   private String _cat;
/*    */   
/*    */   public void initialize(String paramString) {
/* 35 */     this._cat = paramString;
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
/*    */   public void log(int paramInt, Object paramObject) {
/* 47 */     log(paramInt, paramObject, null);
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
/*    */   @SuppressForbidden("uses printStackTrace")
/*    */   public void log(int paramInt, Object paramObject, Throwable paramThrowable) {
/* 61 */     if (check(paramInt)) {
/* 62 */       System.out.println("[" + this._cat + "]" + LEVEL_STRINGS_SHORT[Math.min(LEVEL_STRINGS_SHORT.length - 1, paramInt)] + " " + paramObject);
/* 63 */       if (paramThrowable != null) {
/* 64 */         paramThrowable.printStackTrace(System.out);
/*    */       }
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
/*    */   public boolean check(int paramInt) {
/*    */     byte b;
/*    */     try {
/* 84 */       b = Integer.parseInt(System.getProperty("poi.log.level", "5"));
/* 85 */     } catch (SecurityException securityException) {
/* 86 */       b = 1;
/*    */     } 
/*    */     
/* 89 */     return (paramInt >= b);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\SystemOutLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */