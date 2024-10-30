/*    */ package org.apache.commons.lang3.text.translate;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import org.apache.commons.lang3.ArrayUtils;
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
/*    */ public class AggregateTranslator
/*    */   extends CharSequenceTranslator
/*    */ {
/*    */   private final CharSequenceTranslator[] translators;
/*    */   
/*    */   public AggregateTranslator(CharSequenceTranslator... paramVarArgs) {
/* 44 */     this.translators = (CharSequenceTranslator[])ArrayUtils.clone((Object[])paramVarArgs);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/* 54 */     for (CharSequenceTranslator charSequenceTranslator : this.translators) {
/* 55 */       int i = charSequenceTranslator.translate(paramCharSequence, paramInt, paramWriter);
/* 56 */       if (i != 0) {
/* 57 */         return i;
/*    */       }
/*    */     } 
/* 60 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\translate\AggregateTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */