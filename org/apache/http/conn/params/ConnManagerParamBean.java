/*    */ package org.apache.http.conn.params;
/*    */ 
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
/*    */ @Deprecated
/*    */ public class ConnManagerParamBean
/*    */   extends HttpAbstractParamBean
/*    */ {
/*    */   public ConnManagerParamBean(HttpParams paramHttpParams) {
/* 46 */     super(paramHttpParams);
/*    */   }
/*    */   
/*    */   public void setTimeout(long paramLong) {
/* 50 */     this.params.setLongParameter("http.conn-manager.timeout", paramLong);
/*    */   }
/*    */   
/*    */   public void setMaxTotalConnections(int paramInt) {
/* 54 */     this.params.setIntParameter("http.conn-manager.max-total", paramInt);
/*    */   }
/*    */   
/*    */   public void setConnectionsPerRoute(ConnPerRouteBean paramConnPerRouteBean) {
/* 58 */     this.params.setParameter("http.conn-manager.max-per-route", paramConnPerRouteBean);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\params\ConnManagerParamBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */