/*    */ package org.apache.http.util;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.nio.charset.Charset;
/*    */ import java.nio.charset.UnsupportedCharsetException;
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
/*    */ public class CharsetUtils
/*    */ {
/*    */   public static Charset lookup(String paramString) {
/* 37 */     if (paramString == null) {
/* 38 */       return null;
/*    */     }
/*    */     try {
/* 41 */       return Charset.forName(paramString);
/* 42 */     } catch (UnsupportedCharsetException unsupportedCharsetException) {
/* 43 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Charset get(String paramString) throws UnsupportedEncodingException {
/* 48 */     if (paramString == null) {
/* 49 */       return null;
/*    */     }
/*    */     try {
/* 52 */       return Charset.forName(paramString);
/* 53 */     } catch (UnsupportedCharsetException unsupportedCharsetException) {
/* 54 */       throw new UnsupportedEncodingException(paramString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\CharsetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */