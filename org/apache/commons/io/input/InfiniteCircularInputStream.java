/*    */ package org.apache.commons.io.input;
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
/*    */ public class InfiniteCircularInputStream
/*    */   extends CircularInputStream
/*    */ {
/*    */   public InfiniteCircularInputStream(byte[] paramArrayOfbyte) {
/* 41 */     super(paramArrayOfbyte, -1L);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\InfiniteCircularInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */