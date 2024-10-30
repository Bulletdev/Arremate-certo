/*    */ package org.apache.commons.lang3.text.translate;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class UnicodeUnescaper
/*    */   extends CharSequenceTranslator
/*    */ {
/*    */   public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/* 40 */     if (paramCharSequence.charAt(paramInt) == '\\' && paramInt + 1 < paramCharSequence.length() && paramCharSequence.charAt(paramInt + 1) == 'u') {
/*    */       
/* 42 */       byte b = 2;
/* 43 */       while (paramInt + b < paramCharSequence.length() && paramCharSequence.charAt(paramInt + b) == 'u') {
/* 44 */         b++;
/*    */       }
/*    */       
/* 47 */       if (paramInt + b < paramCharSequence.length() && paramCharSequence.charAt(paramInt + b) == '+') {
/* 48 */         b++;
/*    */       }
/*    */       
/* 51 */       if (paramInt + b + 4 <= paramCharSequence.length()) {
/*    */         
/* 53 */         CharSequence charSequence = paramCharSequence.subSequence(paramInt + b, paramInt + b + 4);
/*    */         
/*    */         try {
/* 56 */           int i = Integer.parseInt(charSequence.toString(), 16);
/* 57 */           paramWriter.write((char)i);
/* 58 */         } catch (NumberFormatException numberFormatException) {
/* 59 */           throw new IllegalArgumentException("Unable to parse unicode value: " + charSequence, numberFormatException);
/*    */         } 
/* 61 */         return b + 4;
/*    */       } 
/* 63 */       throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + paramCharSequence.subSequence(paramInt, paramCharSequence.length()) + "' due to end of CharSequence");
/*    */     } 
/*    */     
/* 66 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\translate\UnicodeUnescaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */