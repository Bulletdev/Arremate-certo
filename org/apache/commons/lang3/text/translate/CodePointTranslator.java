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
/*    */ public abstract class CodePointTranslator
/*    */   extends CharSequenceTranslator
/*    */ {
/*    */   public final int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/* 40 */     int i = Character.codePointAt(paramCharSequence, paramInt);
/* 41 */     boolean bool = translate(i, paramWriter);
/* 42 */     return bool ? 1 : 0;
/*    */   }
/*    */   
/*    */   public abstract boolean translate(int paramInt, Writer paramWriter) throws IOException;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\translate\CodePointTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */