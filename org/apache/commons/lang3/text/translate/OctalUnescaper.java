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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class OctalUnescaper
/*    */   extends CharSequenceTranslator
/*    */ {
/*    */   public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/* 43 */     int i = paramCharSequence.length() - paramInt - 1;
/* 44 */     StringBuilder stringBuilder = new StringBuilder();
/* 45 */     if (paramCharSequence.charAt(paramInt) == '\\' && i > 0 && isOctalDigit(paramCharSequence.charAt(paramInt + 1))) {
/* 46 */       int j = paramInt + 1;
/* 47 */       int k = paramInt + 2;
/* 48 */       int m = paramInt + 3;
/*    */ 
/*    */       
/* 51 */       stringBuilder.append(paramCharSequence.charAt(j));
/*    */       
/* 53 */       if (i > 1 && isOctalDigit(paramCharSequence.charAt(k))) {
/* 54 */         stringBuilder.append(paramCharSequence.charAt(k));
/* 55 */         if (i > 2 && isZeroToThree(paramCharSequence.charAt(j)) && isOctalDigit(paramCharSequence.charAt(m))) {
/* 56 */           stringBuilder.append(paramCharSequence.charAt(m));
/*    */         }
/*    */       } 
/*    */       
/* 60 */       paramWriter.write(Integer.parseInt(stringBuilder.toString(), 8));
/* 61 */       return 1 + stringBuilder.length();
/*    */     } 
/* 63 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean isOctalDigit(char paramChar) {
/* 72 */     return (paramChar >= '0' && paramChar <= '7');
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean isZeroToThree(char paramChar) {
/* 81 */     return (paramChar >= '0' && paramChar <= '3');
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\translate\OctalUnescaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */