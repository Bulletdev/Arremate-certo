/*    */ package ch.qos.logback.classic.pattern;
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
/*    */ public class ClassNameOnlyAbbreviator
/*    */   implements Abbreviator
/*    */ {
/*    */   public String abbreviate(String paramString) {
/* 30 */     int i = paramString.lastIndexOf('.');
/* 31 */     if (i != -1) {
/* 32 */       return paramString.substring(i + 1, paramString.length());
/*    */     }
/* 34 */     return paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\ClassNameOnlyAbbreviator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */