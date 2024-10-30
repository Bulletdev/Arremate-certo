/*    */ package ch.qos.logback.core.util;
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
/*    */ public class ContentTypeUtil
/*    */ {
/*    */   public static boolean isTextual(String paramString) {
/* 25 */     if (paramString == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     return paramString.startsWith("text");
/*    */   }
/*    */   
/*    */   public static String getSubType(String paramString) {
/* 32 */     if (paramString == null) {
/* 33 */       return null;
/*    */     }
/* 35 */     int i = paramString.indexOf('/');
/* 36 */     if (i == -1) {
/* 37 */       return null;
/*    */     }
/* 39 */     int j = i + 1;
/* 40 */     if (j < paramString.length()) {
/* 41 */       return paramString.substring(j);
/*    */     }
/* 43 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\ContentTypeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */