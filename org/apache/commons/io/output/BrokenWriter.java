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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BrokenWriter
/*    */   extends Writer
/*    */ {
/*    */   private final IOException exception;
/*    */   
/*    */   public BrokenWriter(IOException paramIOException) {
/* 44 */     this.exception = paramIOException;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BrokenWriter() {
/* 51 */     this(new IOException("Broken writer"));
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
/*    */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 64 */     throw this.exception;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void flush() throws IOException {
/* 74 */     throw this.exception;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 84 */     throw this.exception;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\BrokenWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */