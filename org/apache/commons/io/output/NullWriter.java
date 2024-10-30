/*    */ package org.apache.commons.io.output;
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
/*    */ public class NullWriter
/*    */   extends Writer
/*    */ {
/* 32 */   public static final NullWriter NULL_WRITER = new NullWriter();
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
/*    */   public Writer append(char paramChar) {
/* 49 */     return this;
/*    */   }
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
/*    */   public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 63 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Writer append(CharSequence paramCharSequence) {
/* 75 */     return this;
/*    */   }
/*    */   
/*    */   public void write(int paramInt) {}
/*    */   
/*    */   public void write(char[] paramArrayOfchar) {}
/*    */   
/*    */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {}
/*    */   
/*    */   public void write(String paramString) {}
/*    */   
/*    */   public void write(String paramString, int paramInt1, int paramInt2) {}
/*    */   
/*    */   public void flush() {}
/*    */   
/*    */   public void close() {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\NullWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */