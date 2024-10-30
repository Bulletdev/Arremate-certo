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
/*    */ @Deprecated
/*    */ public class UnicodeUnpairedSurrogateRemover
/*    */   extends CodePointTranslator
/*    */ {
/*    */   public boolean translate(int paramInt, Writer paramWriter) throws IOException {
/* 37 */     if (paramInt >= 55296 && paramInt <= 57343)
/*    */     {
/* 39 */       return true;
/*    */     }
/*    */     
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\translate\UnicodeUnpairedSurrogateRemover.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */