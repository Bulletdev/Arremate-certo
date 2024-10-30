/*    */ package org.apache.http.client.entity;
/*    */ 
/*    */ import org.apache.http.HttpEntity;
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
/*    */ public class DeflateDecompressingEntity
/*    */   extends DecompressingEntity
/*    */ {
/*    */   public DeflateDecompressingEntity(HttpEntity paramHttpEntity) {
/* 57 */     super(paramHttpEntity, DeflateInputStreamFactory.getInstance());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\entity\DeflateDecompressingEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */