/*    */ package org.apache.commons.text.lookup;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.net.URLDecoder;
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
/*    */ 
/*    */ final class UrlDecoderStringLookup
/*    */   extends AbstractStringLookup
/*    */ {
/* 36 */   static final UrlDecoderStringLookup INSTANCE = new UrlDecoderStringLookup();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   String decode(String paramString1, String paramString2) throws UnsupportedEncodingException {
/* 46 */     return URLDecoder.decode(paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public String lookup(String paramString) {
/* 51 */     if (paramString == null) {
/* 52 */       return null;
/*    */     }
/* 54 */     String str = StandardCharsets.UTF_8.name();
/*    */     try {
/* 56 */       return decode(paramString, str);
/* 57 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*    */       
/* 59 */       throw IllegalArgumentExceptions.format(unsupportedEncodingException, "%s: source=%s, encoding=%s", new Object[] { unsupportedEncodingException, paramString, str });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\UrlDecoderStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */