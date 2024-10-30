/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import org.apache.http.Header;
/*    */ import org.apache.http.HeaderIterator;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.impl.DefaultConnectionReuseStrategy;
/*    */ import org.apache.http.message.BasicHeaderIterator;
/*    */ import org.apache.http.message.BasicTokenIterator;
/*    */ import org.apache.http.protocol.HttpContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultClientConnectionReuseStrategy
/*    */   extends DefaultConnectionReuseStrategy
/*    */ {
/* 44 */   public static final DefaultClientConnectionReuseStrategy INSTANCE = new DefaultClientConnectionReuseStrategy();
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean keepAlive(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
/* 49 */     HttpRequest httpRequest = (HttpRequest)paramHttpContext.getAttribute("http.request");
/* 50 */     if (httpRequest != null) {
/* 51 */       Header[] arrayOfHeader = httpRequest.getHeaders("Connection");
/* 52 */       if (arrayOfHeader.length != 0) {
/* 53 */         BasicTokenIterator basicTokenIterator = new BasicTokenIterator((HeaderIterator)new BasicHeaderIterator(arrayOfHeader, null));
/* 54 */         while (basicTokenIterator.hasNext()) {
/* 55 */           String str = basicTokenIterator.nextToken();
/* 56 */           if ("Close".equalsIgnoreCase(str)) {
/* 57 */             return false;
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/* 62 */     return super.keepAlive(paramHttpResponse, paramHttpContext);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\DefaultClientConnectionReuseStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */