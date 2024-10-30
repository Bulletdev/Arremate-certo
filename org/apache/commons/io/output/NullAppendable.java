/*    */ package org.apache.commons.io.output;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public class NullAppendable
/*    */   implements Appendable
/*    */ {
/* 35 */   public static final NullAppendable INSTANCE = new NullAppendable();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Appendable append(char paramChar) throws IOException {
/* 44 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Appendable append(CharSequence paramCharSequence) throws IOException {
/* 49 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Appendable append(CharSequence paramCharSequence, int paramInt1, int paramInt2) throws IOException {
/* 54 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\NullAppendable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */