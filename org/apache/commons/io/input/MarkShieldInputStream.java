/*    */ package org.apache.commons.io.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MarkShieldInputStream
/*    */   extends ProxyInputStream
/*    */ {
/*    */   public MarkShieldInputStream(InputStream paramInputStream) {
/* 45 */     super(paramInputStream);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mark(int paramInt) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean markSupported() {
/* 56 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void reset() throws IOException {
/* 62 */     throw new IOException("mark/reset not supported");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\MarkShieldInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */