/*    */ package org.apache.commons.text.translate;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
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
/*    */ public class UnicodeUnescaper
/*    */   extends CharSequenceTranslator
/*    */ {
/*    */   public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/* 36 */     if (paramCharSequence.charAt(paramInt) == '\\' && paramInt + 1 < paramCharSequence.length() && paramCharSequence.charAt(paramInt + 1) == 'u') {
/*    */       
/* 38 */       byte b = 2;
/* 39 */       while (paramInt + b < paramCharSequence.length() && paramCharSequence.charAt(paramInt + b) == 'u') {
/* 40 */         b++;
/*    */       }
/*    */       
/* 43 */       if (paramInt + b < paramCharSequence.length() && paramCharSequence.charAt(paramInt + b) == '+') {
/* 44 */         b++;
/*    */       }
/*    */       
/* 47 */       if (paramInt + b + 4 <= paramCharSequence.length()) {
/*    */         
/* 49 */         CharSequence charSequence = paramCharSequence.subSequence(paramInt + b, paramInt + b + 4);
/*    */         
/*    */         try {
/* 52 */           int i = Integer.parseInt(charSequence.toString(), 16);
/* 53 */           paramWriter.write((char)i);
/* 54 */         } catch (NumberFormatException numberFormatException) {
/* 55 */           throw new IllegalArgumentException("Unable to parse unicode value: " + charSequence, numberFormatException);
/*    */         } 
/* 57 */         return b + 4;
/*    */       } 
/* 59 */       throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + paramCharSequence
/* 60 */           .subSequence(paramInt, paramCharSequence.length()) + "' due to end of CharSequence");
/*    */     } 
/*    */     
/* 63 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\UnicodeUnescaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */