/*    */ package org.apache.commons.text.lookup;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.net.URLEncoder;
/*    */ import java.nio.charset.StandardCharsets;
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
/*    */ final class UrlEncoderStringLookup
/*    */   extends AbstractStringLookup
/*    */ {
/* 35 */   static final UrlEncoderStringLookup INSTANCE = new UrlEncoderStringLookup();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   String encode(String paramString1, String paramString2) throws UnsupportedEncodingException {
/* 45 */     return URLEncoder.encode(paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public String lookup(String paramString) {
/* 50 */     if (paramString == null) {
/* 51 */       return null;
/*    */     }
/* 53 */     String str = StandardCharsets.UTF_8.name();
/*    */     try {
/* 55 */       return encode(paramString, str);
/* 56 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*    */       
/* 58 */       throw IllegalArgumentExceptions.format(unsupportedEncodingException, "%s: source=%s, encoding=%s", new Object[] { unsupportedEncodingException, paramString, str });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\UrlEncoderStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */