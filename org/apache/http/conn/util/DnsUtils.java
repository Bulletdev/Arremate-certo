/*    */ package org.apache.http.conn.util;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DnsUtils
/*    */ {
/*    */   private static boolean isUpper(char paramChar) {
/* 41 */     return (paramChar >= 'A' && paramChar <= 'Z');
/*    */   }
/*    */   
/*    */   public static String normalize(String paramString) {
/* 45 */     if (paramString == null) {
/* 46 */       return null;
/*    */     }
/* 48 */     byte b = 0;
/* 49 */     int i = paramString.length();
/* 50 */     while (i > 0 && 
/* 51 */       !isUpper(paramString.charAt(b))) {
/*    */ 
/*    */       
/* 54 */       b++;
/* 55 */       i--;
/*    */     } 
/* 57 */     if (i > 0) {
/* 58 */       StringBuilder stringBuilder = new StringBuilder(paramString.length());
/* 59 */       stringBuilder.append(paramString, 0, b);
/* 60 */       while (i > 0) {
/* 61 */         char c = paramString.charAt(b);
/* 62 */         if (isUpper(c)) {
/* 63 */           stringBuilder.append((char)(c + 32));
/*    */         } else {
/* 65 */           stringBuilder.append(c);
/*    */         } 
/* 67 */         b++;
/* 68 */         i--;
/*    */       } 
/* 70 */       return stringBuilder.toString();
/*    */     } 
/* 72 */     return paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\con\\util\DnsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */