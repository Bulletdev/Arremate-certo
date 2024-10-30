/*    */ package org.apache.http.cookie.params;
/*    */ 
/*    */ import java.util.Collection;
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
/*    */ 
/*    */ @Deprecated
/*    */ public class CookieSpecParamBean
/*    */   extends HttpAbstractParamBean
/*    */ {
/*    */   public CookieSpecParamBean(HttpParams paramHttpParams) {
/* 49 */     super(paramHttpParams);
/*    */   }
/*    */   
/*    */   public void setDatePatterns(Collection<String> paramCollection) {
/* 53 */     this.params.setParameter("http.protocol.cookie-datepatterns", paramCollection);
/*    */   }
/*    */   
/*    */   public void setSingleHeader(boolean paramBoolean) {
/* 57 */     this.params.setBooleanParameter("http.protocol.single-cookie-header", paramBoolean);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\cookie\params\CookieSpecParamBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */