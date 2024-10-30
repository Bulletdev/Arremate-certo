/*    */ package org.apache.poi.xdgf.util;
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
/*    */ public class Util
/*    */ {
/*    */   public static int countLines(String paramString) {
/* 23 */     byte b = 1;
/* 24 */     int i = 0;
/* 25 */     while ((i = paramString.indexOf("\n", i) + 1) != 0) {
/* 26 */       b++;
/*    */     }
/* 28 */     return b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String sanitizeFilename(String paramString) {
/* 35 */     return paramString.replaceAll("[:\\\\/*\"?|<>]", "_");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\util\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */