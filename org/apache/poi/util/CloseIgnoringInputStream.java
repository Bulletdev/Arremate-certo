/*    */ package org.apache.poi.util;
/*    */ 
/*    */ import java.io.FilterInputStream;
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
/*    */ public class CloseIgnoringInputStream
/*    */   extends FilterInputStream
/*    */ {
/*    */   public CloseIgnoringInputStream(InputStream paramInputStream) {
/* 32 */     super(paramInputStream);
/*    */   }
/*    */   
/*    */   public void close() {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\CloseIgnoringInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */