/*    */ package org.apache.commons.text.translate;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class AggregateTranslator
/*    */   extends CharSequenceTranslator
/*    */ {
/* 35 */   private final List<CharSequenceTranslator> translators = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AggregateTranslator(CharSequenceTranslator... paramVarArgs) {
/* 43 */     if (paramVarArgs != null) {
/* 44 */       for (CharSequenceTranslator charSequenceTranslator : paramVarArgs) {
/* 45 */         if (charSequenceTranslator != null) {
/* 46 */           this.translators.add(charSequenceTranslator);
/*    */         }
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/* 59 */     for (CharSequenceTranslator charSequenceTranslator : this.translators) {
/* 60 */       int i = charSequenceTranslator.translate(paramCharSequence, paramInt, paramWriter);
/* 61 */       if (i != 0) {
/* 62 */         return i;
/*    */       }
/*    */     } 
/* 65 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\AggregateTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */