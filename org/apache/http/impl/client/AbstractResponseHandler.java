/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpEntity;
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.StatusLine;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.client.HttpResponseException;
/*    */ import org.apache.http.client.ResponseHandler;
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
/*    */ public abstract class AbstractResponseHandler<T>
/*    */   implements ResponseHandler<T>
/*    */ {
/*    */   public T handleResponse(HttpResponse paramHttpResponse) throws HttpResponseException, IOException {
/* 66 */     StatusLine statusLine = paramHttpResponse.getStatusLine();
/* 67 */     HttpEntity httpEntity = paramHttpResponse.getEntity();
/* 68 */     if (statusLine.getStatusCode() >= 300) {
/* 69 */       EntityUtils.consume(httpEntity);
/* 70 */       throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
/*    */     } 
/*    */     
/* 73 */     return (httpEntity == null) ? null : handleEntity(httpEntity);
/*    */   }
/*    */   
/*    */   public abstract T handleEntity(HttpEntity paramHttpEntity) throws IOException;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\AbstractResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */