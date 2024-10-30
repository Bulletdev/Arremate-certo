/*    */ package org.apache.http.impl.conn;
/*    */ 
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpHost;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.conn.SchemePortResolver;
/*    */ import org.apache.http.protocol.HttpContext;
/*    */ import org.apache.http.util.Args;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*    */ public class DefaultProxyRoutePlanner
/*    */   extends DefaultRoutePlanner
/*    */ {
/*    */   private final HttpHost proxy;
/*    */   
/*    */   public DefaultProxyRoutePlanner(HttpHost paramHttpHost, SchemePortResolver paramSchemePortResolver) {
/* 51 */     super(paramSchemePortResolver);
/* 52 */     this.proxy = (HttpHost)Args.notNull(paramHttpHost, "Proxy host");
/*    */   }
/*    */   
/*    */   public DefaultProxyRoutePlanner(HttpHost paramHttpHost) {
/* 56 */     this(paramHttpHost, null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected HttpHost determineProxy(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException {
/* 64 */     return this.proxy;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\DefaultProxyRoutePlanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */