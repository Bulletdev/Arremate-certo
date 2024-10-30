/*    */ package org.apache.xmlbeans.impl.common;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStreamWriter;
/*    */ import java.io.Reader;
/*    */ import java.io.UnsupportedEncodingException;
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
/*    */ public class ReaderInputStream
/*    */   extends PushedInputStream
/*    */ {
/*    */   private Reader reader;
/*    */   private Writer writer;
/*    */   private char[] buf;
/* 29 */   public static int defaultBufferSize = 2048;
/*    */ 
/*    */   
/*    */   public ReaderInputStream(Reader paramReader, String paramString) throws UnsupportedEncodingException {
/* 33 */     this(paramReader, paramString, defaultBufferSize);
/*    */   }
/*    */ 
/*    */   
/*    */   public ReaderInputStream(Reader paramReader, String paramString, int paramInt) throws UnsupportedEncodingException {
/* 38 */     if (paramInt <= 0) {
/* 39 */       throw new IllegalArgumentException("Buffer size <= 0");
/*    */     }
/* 41 */     this.reader = paramReader;
/* 42 */     this.writer = new OutputStreamWriter(getOutputStream(), paramString);
/* 43 */     this.buf = new char[paramInt];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fill(int paramInt) throws IOException {
/*    */     do {
/* 50 */       int i = this.reader.read(this.buf);
/* 51 */       if (i < 0) {
/*    */         return;
/*    */       }
/* 54 */       this.writer.write(this.buf, 0, i);
/* 55 */       this.writer.flush();
/*    */     }
/* 57 */     while (available() <= 0);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\ReaderInputStream.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */