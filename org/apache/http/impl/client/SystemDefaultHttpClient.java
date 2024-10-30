/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.net.ProxySelector;
/*     */ import org.apache.http.ConnectionReuseStrategy;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.conn.routing.HttpRoutePlanner;
/*     */ import org.apache.http.impl.DefaultConnectionReuseStrategy;
/*     */ import org.apache.http.impl.NoConnectionReuseStrategy;
/*     */ import org.apache.http.impl.conn.PoolingClientConnectionManager;
/*     */ import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
/*     */ import org.apache.http.impl.conn.SchemeRegistryFactory;
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
/*     */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*     */ public class SystemDefaultHttpClient
/*     */   extends DefaultHttpClient
/*     */ {
/*     */   public SystemDefaultHttpClient(HttpParams paramHttpParams) {
/* 115 */     super((ClientConnectionManager)null, paramHttpParams);
/*     */   }
/*     */   
/*     */   public SystemDefaultHttpClient() {
/* 119 */     super((ClientConnectionManager)null, (HttpParams)null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ClientConnectionManager createClientConnectionManager() {
/* 124 */     PoolingClientConnectionManager poolingClientConnectionManager = new PoolingClientConnectionManager(SchemeRegistryFactory.createSystemDefault());
/*     */     
/* 126 */     String str = System.getProperty("http.keepAlive", "true");
/* 127 */     if ("true".equalsIgnoreCase(str)) {
/* 128 */       str = System.getProperty("http.maxConnections", "5");
/* 129 */       int i = Integer.parseInt(str);
/* 130 */       poolingClientConnectionManager.setDefaultMaxPerRoute(i);
/* 131 */       poolingClientConnectionManager.setMaxTotal(2 * i);
/*     */     } 
/* 133 */     return (ClientConnectionManager)poolingClientConnectionManager;
/*     */   }
/*     */ 
/*     */   
/*     */   protected HttpRoutePlanner createHttpRoutePlanner() {
/* 138 */     return (HttpRoutePlanner)new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), ProxySelector.getDefault());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ConnectionReuseStrategy createConnectionReuseStrategy() {
/* 144 */     String str = System.getProperty("http.keepAlive", "true");
/* 145 */     if ("true".equalsIgnoreCase(str)) {
/* 146 */       return (ConnectionReuseStrategy)new DefaultConnectionReuseStrategy();
/*     */     }
/* 148 */     return (ConnectionReuseStrategy)new NoConnectionReuseStrategy();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\SystemDefaultHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */