/*    */ package org.c.a.b.r;
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
/*    */ 
/*    */ 
/*    */ public class a
/*    */ {
/*    */   public static String be(String paramString) {
/* 36 */     if (paramString == null) {
/* 37 */       return null;
/*    */     }
/*    */     
/* 40 */     if (paramString.length() <= 200) {
/* 41 */       return paramString;
/*    */     }
/*    */     
/* 44 */     return paramString.substring(0, 197) + "...";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String bf(String paramString) {
/* 54 */     if (paramString == null) {
/* 55 */       return null;
/*    */     }
/*    */     
/* 58 */     if (paramString.length() <= 1000) {
/* 59 */       return paramString;
/*    */     }
/*    */     
/* 62 */     return "..." + paramString.substring(3, 1000);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */