/*    */ package org.apache.http.client.fluent;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpEntity;
/*    */ import org.apache.http.entity.ContentType;
/*    */ import org.apache.http.impl.client.AbstractResponseHandler;
/*    */ import org.apache.http.util.EntityUtils;
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
/*    */ public class ContentResponseHandler
/*    */   extends AbstractResponseHandler<Content>
/*    */ {
/*    */   public Content handleEntity(HttpEntity paramHttpEntity) throws IOException {
/* 49 */     return (paramHttpEntity != null) ? new Content(EntityUtils.toByteArray(paramHttpEntity), ContentType.getOrDefault(paramHttpEntity)) : Content.NO_CONTENT;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\fluent\ContentResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */