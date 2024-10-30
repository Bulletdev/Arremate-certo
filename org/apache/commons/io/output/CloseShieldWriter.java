/*    */ package org.apache.commons.io.output;
/*    */ 
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
/*    */ public class CloseShieldWriter
/*    */   extends ProxyWriter
/*    */ {
/*    */   public CloseShieldWriter(Writer paramWriter) {
/* 38 */     super(paramWriter);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() {
/* 47 */     this.out = ClosedWriter.CLOSED_WRITER;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\CloseShieldWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */