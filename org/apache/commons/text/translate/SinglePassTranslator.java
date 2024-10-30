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
/*    */ abstract class SinglePassTranslator
/*    */   extends CharSequenceTranslator
/*    */ {
/*    */   public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/* 30 */     if (paramInt != 0) {
/* 31 */       throw new IllegalArgumentException(getClassName() + ".translate(final CharSequence input, final int index, final Writer out) can not handle a non-zero index.");
/*    */     }
/*    */ 
/*    */     
/* 35 */     translateWhole(paramCharSequence, paramWriter);
/*    */     
/* 37 */     return Character.codePointCount(paramCharSequence, paramInt, paramCharSequence.length());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String getClassName() {
/* 46 */     Class<?> clazz = getClass();
/* 47 */     return clazz.isAnonymousClass() ? clazz.getName() : clazz.getSimpleName();
/*    */   }
/*    */   
/*    */   abstract void translateWhole(CharSequence paramCharSequence, Writer paramWriter) throws IOException;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\SinglePassTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */