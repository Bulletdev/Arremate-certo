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
/*    */ public abstract class CodePointTranslator
/*    */   extends CharSequenceTranslator
/*    */ {
/*    */   public final int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/* 36 */     int i = Character.codePointAt(paramCharSequence, paramInt);
/* 37 */     boolean bool = translate(i, paramWriter);
/* 38 */     return bool ? 1 : 0;
/*    */   }
/*    */   
/*    */   public abstract boolean translate(int paramInt, Writer paramWriter) throws IOException;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\CodePointTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */