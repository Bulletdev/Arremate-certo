/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Proxy;
/*     */ import java.net.ProxySelector;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.List;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.SchemePortResolver;
/*     */ import org.apache.http.protocol.HttpContext;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class SystemDefaultRoutePlanner
/*     */   extends DefaultRoutePlanner
/*     */ {
/*     */   private final ProxySelector proxySelector;
/*     */   
/*     */   public SystemDefaultRoutePlanner(SchemePortResolver paramSchemePortResolver, ProxySelector paramProxySelector) {
/*  64 */     super(paramSchemePortResolver);
/*  65 */     this.proxySelector = paramProxySelector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SystemDefaultRoutePlanner(ProxySelector paramProxySelector) {
/*  72 */     this(null, paramProxySelector);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpHost determineProxy(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException {
/*     */     URI uRI;
/*     */     try {
/*  82 */       uRI = new URI(paramHttpHost.toURI());
/*  83 */     } catch (URISyntaxException uRISyntaxException) {
/*  84 */       throw new HttpException("Cannot convert host to URI: " + paramHttpHost, uRISyntaxException);
/*     */     } 
/*  86 */     ProxySelector proxySelector = this.proxySelector;
/*  87 */     if (proxySelector == null) {
/*  88 */       proxySelector = ProxySelector.getDefault();
/*     */     }
/*  90 */     if (proxySelector == null)
/*     */     {
/*  92 */       return null;
/*     */     }
/*  94 */     List<Proxy> list = proxySelector.select(uRI);
/*  95 */     Proxy proxy = chooseProxy(list);
/*  96 */     HttpHost httpHost = null;
/*  97 */     if (proxy.type() == Proxy.Type.HTTP) {
/*     */       
/*  99 */       if (!(proxy.address() instanceof InetSocketAddress)) {
/* 100 */         throw new HttpException("Unable to handle non-Inet proxy address: " + proxy.address());
/*     */       }
/* 102 */       InetSocketAddress inetSocketAddress = (InetSocketAddress)proxy.address();
/*     */       
/* 104 */       httpHost = new HttpHost(getHost(inetSocketAddress), inetSocketAddress.getPort());
/*     */     } 
/*     */     
/* 107 */     return httpHost;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getHost(InetSocketAddress paramInetSocketAddress) {
/* 115 */     return paramInetSocketAddress.isUnresolved() ? paramInetSocketAddress.getHostName() : paramInetSocketAddress.getAddress().getHostAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Proxy chooseProxy(List<Proxy> paramList) {
/* 121 */     Proxy proxy = null;
/*     */     
/* 123 */     for (byte b = 0; proxy == null && b < paramList.size(); b++) {
/* 124 */       Proxy proxy1 = paramList.get(b);
/* 125 */       switch (proxy1.type()) {
/*     */         
/*     */         case DIRECT:
/*     */         case HTTP:
/* 129 */           proxy = proxy1;
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 138 */     if (proxy == null)
/*     */     {
/*     */ 
/*     */       
/* 142 */       proxy = Proxy.NO_PROXY;
/*     */     }
/* 144 */     return proxy;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\SystemDefaultRoutePlanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */