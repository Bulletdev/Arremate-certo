/*    */ package org.apache.commons.io.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import org.apache.commons.io.IOUtils;
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
/*    */ public class DemuxInputStream
/*    */   extends InputStream
/*    */ {
/* 30 */   private final InheritableThreadLocal<InputStream> inputStream = new InheritableThreadLocal<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InputStream bindStream(InputStream paramInputStream) {
/* 39 */     InputStream inputStream = this.inputStream.get();
/* 40 */     this.inputStream.set(paramInputStream);
/* 41 */     return inputStream;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 51 */     IOUtils.close(this.inputStream.get());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int read() throws IOException {
/* 62 */     InputStream inputStream = this.inputStream.get();
/* 63 */     if (null != inputStream) {
/* 64 */       return inputStream.read();
/*    */     }
/* 66 */     return -1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\DemuxInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */