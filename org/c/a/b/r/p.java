/*    */ package org.c.a.b.r;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.net.URL;
/*    */ import java.net.URLDecoder;
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
/*    */ public class p
/*    */ {
/*    */   public static String b(URL paramURL) {
/*    */     try {
/* 42 */       String str = (new File(URLDecoder.decode(paramURL.getPath().replace("+", "%2b"), "UTF-8"))).getAbsolutePath();
/* 43 */       if (str.endsWith("/")) {
/* 44 */         return str.substring(0, str.length() - 1);
/*    */       }
/* 46 */       return str;
/* 47 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 48 */       throw new IllegalStateException("Can never happen", unsupportedEncodingException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */