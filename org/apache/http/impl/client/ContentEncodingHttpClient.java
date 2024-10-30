/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import org.apache.http.HttpRequestInterceptor;
/*    */ import org.apache.http.HttpResponseInterceptor;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.client.protocol.RequestAcceptEncoding;
/*    */ import org.apache.http.client.protocol.ResponseContentEncoding;
/*    */ import org.apache.http.conn.ClientConnectionManager;
/*    */ import org.apache.http.params.HttpParams;
/*    */ import org.apache.http.protocol.BasicHttpProcessor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*    */ public class ContentEncodingHttpClient
/*    */   extends DefaultHttpClient
/*    */ {
/*    */   public ContentEncodingHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams) {
/* 64 */     super(paramClientConnectionManager, paramHttpParams);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ContentEncodingHttpClient(HttpParams paramHttpParams) {
/* 71 */     this(null, paramHttpParams);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ContentEncodingHttpClient() {
/* 78 */     this(null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected BasicHttpProcessor createHttpProcessor() {
/* 86 */     BasicHttpProcessor basicHttpProcessor = super.createHttpProcessor();
/*    */     
/* 88 */     basicHttpProcessor.addRequestInterceptor((HttpRequestInterceptor)new RequestAcceptEncoding());
/* 89 */     basicHttpProcessor.addResponseInterceptor((HttpResponseInterceptor)new ResponseContentEncoding());
/*    */     
/* 91 */     return basicHttpProcessor;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\ContentEncodingHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */