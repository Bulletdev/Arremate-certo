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
/*    */ public class UnicodeUnpairedSurrogateRemover
/*    */   extends CodePointTranslator
/*    */ {
/*    */   public boolean translate(int paramInt, Writer paramWriter) throws IOException {
/* 34 */     if (paramInt >= 55296 && paramInt <= 57343)
/*    */     {
/* 36 */       return true;
/*    */     }
/*    */     
/* 39 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\UnicodeUnpairedSurrogateRemover.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */