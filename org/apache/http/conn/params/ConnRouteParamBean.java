/*    */ package org.apache.http.conn.params;
/*    */ 
/*    */ import java.net.InetAddress;
/*    */ import org.apache.http.HttpHost;
/*    */ import org.apache.http.conn.routing.HttpRoute;
/*    */ import org.apache.http.params.HttpAbstractParamBean;
/*    */ import org.apache.http.params.HttpParams;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */ public class ConnRouteParamBean
/*    */   extends HttpAbstractParamBean
/*    */ {
/*    */   public ConnRouteParamBean(HttpParams paramHttpParams) {
/* 50 */     super(paramHttpParams);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setDefaultProxy(HttpHost paramHttpHost) {
/* 55 */     this.params.setParameter("http.route.default-proxy", paramHttpHost);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLocalAddress(InetAddress paramInetAddress) {
/* 60 */     this.params.setParameter("http.route.local-address", paramInetAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setForcedRoute(HttpRoute paramHttpRoute) {
/* 65 */     this.params.setParameter("http.route.forced-route", paramHttpRoute);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\params\ConnRouteParamBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */