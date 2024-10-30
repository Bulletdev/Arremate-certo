/*     */ package org.apache.http.client.params;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.params.HttpAbstractParamBean;
/*     */ import org.apache.http.params.HttpParams;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class ClientParamBean
/*     */   extends HttpAbstractParamBean
/*     */ {
/*     */   public ClientParamBean(HttpParams paramHttpParams) {
/*  50 */     super(paramHttpParams);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setConnectionManagerFactoryClassName(String paramString) {
/*  58 */     this.params.setParameter("http.connection-manager.factory-class-name", paramString);
/*     */   }
/*     */   
/*     */   public void setHandleRedirects(boolean paramBoolean) {
/*  62 */     this.params.setBooleanParameter("http.protocol.handle-redirects", paramBoolean);
/*     */   }
/*     */   
/*     */   public void setRejectRelativeRedirect(boolean paramBoolean) {
/*  66 */     this.params.setBooleanParameter("http.protocol.reject-relative-redirect", paramBoolean);
/*     */   }
/*     */   
/*     */   public void setMaxRedirects(int paramInt) {
/*  70 */     this.params.setIntParameter("http.protocol.max-redirects", paramInt);
/*     */   }
/*     */   
/*     */   public void setAllowCircularRedirects(boolean paramBoolean) {
/*  74 */     this.params.setBooleanParameter("http.protocol.allow-circular-redirects", paramBoolean);
/*     */   }
/*     */   
/*     */   public void setHandleAuthentication(boolean paramBoolean) {
/*  78 */     this.params.setBooleanParameter("http.protocol.handle-authentication", paramBoolean);
/*     */   }
/*     */   
/*     */   public void setCookiePolicy(String paramString) {
/*  82 */     this.params.setParameter("http.protocol.cookie-policy", paramString);
/*     */   }
/*     */   
/*     */   public void setVirtualHost(HttpHost paramHttpHost) {
/*  86 */     this.params.setParameter("http.virtual-host", paramHttpHost);
/*     */   }
/*     */   
/*     */   public void setDefaultHeaders(Collection<Header> paramCollection) {
/*  90 */     this.params.setParameter("http.default-headers", paramCollection);
/*     */   }
/*     */   
/*     */   public void setDefaultHost(HttpHost paramHttpHost) {
/*  94 */     this.params.setParameter("http.default-host", paramHttpHost);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConnectionManagerTimeout(long paramLong) {
/* 101 */     this.params.setLongParameter("http.conn-manager.timeout", paramLong);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\params\ClientParamBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */