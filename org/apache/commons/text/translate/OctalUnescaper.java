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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OctalUnescaper
/*    */   extends CharSequenceTranslator
/*    */ {
/*    */   public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/* 39 */     int i = paramCharSequence.length() - paramInt - 1;
/* 40 */     StringBuilder stringBuilder = new StringBuilder();
/* 41 */     if (paramCharSequence.charAt(paramInt) == '\\' && i > 0 && isOctalDigit(paramCharSequence.charAt(paramInt + 1))) {
/* 42 */       int j = paramInt + 1;
/* 43 */       int k = paramInt + 2;
/* 44 */       int m = paramInt + 3;
/*    */ 
/*    */       
/* 47 */       stringBuilder.append(paramCharSequence.charAt(j));
/*    */       
/* 49 */       if (i > 1 && isOctalDigit(paramCharSequence.charAt(k))) {
/* 50 */         stringBuilder.append(paramCharSequence.charAt(k));
/* 51 */         if (i > 2 && isZeroToThree(paramCharSequence.charAt(j)) && isOctalDigit(paramCharSequence.charAt(m))) {
/* 52 */           stringBuilder.append(paramCharSequence.charAt(m));
/*    */         }
/*    */       } 
/*    */       
/* 56 */       paramWriter.write(Integer.parseInt(stringBuilder.toString(), 8));
/* 57 */       return 1 + stringBuilder.length();
/*    */     } 
/* 59 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean isOctalDigit(char paramChar) {
/* 68 */     return (paramChar >= '0' && paramChar <= '7');
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean isZeroToThree(char paramChar) {
/* 77 */     return (paramChar >= '0' && paramChar <= '3');
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\OctalUnescaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */