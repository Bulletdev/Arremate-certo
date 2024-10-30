/*    */ package org.apache.http.client.entity;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class DeflateInputStreamFactory
/*    */   implements InputStreamFactory
/*    */ {
/* 47 */   private static final DeflateInputStreamFactory INSTANCE = new DeflateInputStreamFactory();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DeflateInputStreamFactory getInstance() {
/* 55 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */   
/*    */   public InputStream create(InputStream paramInputStream) throws IOException {
/* 60 */     return new DeflateInputStream(paramInputStream);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\entity\DeflateInputStreamFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */