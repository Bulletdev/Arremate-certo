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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClosedWriter
/*    */   extends Writer
/*    */ {
/* 36 */   public static final ClosedWriter CLOSED_WRITER = new ClosedWriter();
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
/*    */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 48 */     throw new IOException("write(" + new String(paramArrayOfchar) + ", " + paramInt1 + ", " + paramInt2 + ") failed: stream is closed");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void flush() throws IOException {
/* 58 */     throw new IOException("flush() failed: stream is closed");
/*    */   }
/*    */   
/*    */   public void close() throws IOException {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\ClosedWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */