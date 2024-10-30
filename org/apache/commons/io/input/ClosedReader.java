/*    */ package org.apache.commons.io.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
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
/*    */ public class ClosedReader
/*    */   extends Reader
/*    */ {
/* 38 */   public static final ClosedReader CLOSED_READER = new ClosedReader();
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
/*    */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 50 */     return -1;
/*    */   }
/*    */   
/*    */   public void close() throws IOException {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\ClosedReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */