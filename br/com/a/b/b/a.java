/*     */ package br.com.a.b.b;
/*     */ 
/*     */ import br.com.a.d.a.d;
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.net.ssl.HostnameVerifier;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.client.CookieStore;
/*     */ import org.apache.http.client.RedirectStrategy;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.methods.RequestBuilder;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.conn.ssl.NoopHostnameVerifier;
/*     */ import org.apache.http.entity.StringEntity;
/*     */ import org.apache.http.impl.client.BasicCookieStore;
/*     */ import org.apache.http.impl.client.CloseableHttpClient;
/*     */ import org.apache.http.impl.client.HttpClients;
/*     */ import org.apache.http.impl.client.LaxRedirectStrategy;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.ssl.SSLContexts;
/*     */ import org.apache.http.ssl.TrustStrategy;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ import org.e.i;
/*     */ 
/*     */ public class a {
/*     */   private final HttpClientContext b;
/*     */   
/*     */   public a() {
/*  39 */     this.b = HttpClientContext.create();
/*  40 */     this.a = (CloseableHttpClient)new BasicCookieStore();
/*  41 */     this.a = null;
/*  42 */     es();
/*     */   }
/*     */ 
/*     */   
/*     */   private final BasicCookieStore a;
/*     */   
/*     */   private CloseableHttpResponse a;
/*     */   private CloseableHttpClient a;
/*     */   private List<URI> H;
/*     */   private String fQ;
/*     */   
/*     */   public String get(String paramString) throws d {
/*     */     try {
/*  55 */       HttpUriRequest httpUriRequest = RequestBuilder.get().setUri(new URI(paramString)).addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").addHeader("Accept-Encoding", "gzip,deflate,br").addHeader("Accept-Language", "pt-BR,pt;q=0.8,en-US;q=0.5,en;q=0.3").addHeader("Connection", "keep-alive").addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36").build();
/*  56 */       return a(httpUriRequest);
/*  57 */     } catch (Exception exception) {
/*  58 */       throw new d(exception);
/*     */     } 
/*     */   }
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
/*     */   public String b(String paramString, NameValuePair[] paramArrayOfNameValuePair) throws d {
/*     */     try {
/*  73 */       HttpUriRequest httpUriRequest = RequestBuilder.post().setUri(new URI(paramString)).addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").addHeader("Accept-Encoding", "gzip,deflate,br").addHeader("Accept-Language", "pt-BR,pt;q=0.8,en-US;q=0.5,en;q=0.3").addHeader("Connection", "keep-alive").addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36").addParameters(paramArrayOfNameValuePair).build();
/*  74 */       return a(httpUriRequest);
/*  75 */     } catch (Exception exception) {
/*  76 */       throw new d(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String a(String paramString, i parami) throws d {
/*     */     try {
/*  86 */       HttpUriRequest httpUriRequest = RequestBuilder.post().setUri(new URI(paramString)).addHeader("Content-Type", "application/json; charset=utf-8").setEntity((HttpEntity)new StringEntity(parami.toString(), "UTF-8")).build();
/*  87 */       return a(httpUriRequest);
/*  88 */     } catch (Exception exception) {
/*  89 */       throw new d(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String ae(String paramString) throws d {
/*     */     try {
/* 103 */       HttpUriRequest httpUriRequest = RequestBuilder.post().setUri(new URI(paramString)).addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").addHeader("Accept-Encoding", "gzip,deflate,br").addHeader("Accept-Language", "pt-BR,pt;q=0.8,en-US;q=0.5,en;q=0.3").addHeader("Connection", "keep-alive").addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36").build();
/* 104 */       return a(httpUriRequest);
/* 105 */     } catch (Exception exception) {
/* 106 */       throw new d(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String a(HttpUriRequest paramHttpUriRequest) throws d {
/*     */     try {
/* 112 */       this.b.setCookieStore((CookieStore)this.a);
/* 113 */       this.a = (CloseableHttpClient)this.a.execute(paramHttpUriRequest, (HttpContext)this.b);
/* 114 */       this.H = this.b.getRedirectLocations();
/* 115 */       HttpEntity httpEntity = this.a.getEntity();
/* 116 */       int i = this.a.getStatusLine().getStatusCode();
/* 117 */       if (i == 200) {
/* 118 */         return EntityUtils.toString(httpEntity);
/*     */       }
/* 120 */       this.fQ = EntityUtils.toString(httpEntity);
/*     */       
/* 122 */       return Integer.toString(i);
/* 123 */     } catch (Exception exception) {
/* 124 */       throw new d(exception);
/*     */     } finally {
/*     */       try {
/* 127 */         if (this.a != null) {
/* 128 */           this.a.close();
/*     */         }
/* 130 */       } catch (Exception exception) {
/* 131 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private RequestConfig a() {
/* 137 */     return RequestConfig.custom()
/* 138 */       .setConnectTimeout((int)TimeUnit.MINUTES.toMillis(3L))
/* 139 */       .setConnectionRequestTimeout((int)TimeUnit.MINUTES.toMillis(10L))
/* 140 */       .setSocketTimeout((int)TimeUnit.MINUTES.toMillis(10L))
/* 141 */       .build();
/*     */   }
/*     */   
/*     */   private void es() {
/* 145 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 155 */       .a = HttpClients.custom().setSSLContext(b()).setSSLHostnameVerifier((HostnameVerifier)new NoopHostnameVerifier()).setDefaultRequestConfig(a()).setRedirectStrategy((RedirectStrategy)new LaxRedirectStrategy()).addInterceptorFirst((paramHttpRequest, paramHttpContext) -> paramHttpRequest.removeHeaders("Content-Length")).setDefaultCookieStore((CookieStore)this.a).setConnectionManagerShared(true).build();
/*     */   }
/*     */   
/*     */   private SSLContext b() {
/*     */     try {
/* 160 */       return SSLContexts.custom()
/* 161 */         .loadTrustMaterial(null, (TrustStrategy)((paramArrayOfX509Certificate, paramString) -> true))
/* 162 */         .build();
/* 163 */     } catch (Exception exception) {
/* 164 */       exception.printStackTrace();
/*     */       
/* 166 */       return null;
/*     */     } 
/*     */   }
/*     */   public String cG() {
/* 170 */     if (this.H != null && !this.H.isEmpty()) {
/* 171 */       return ((URI)this.H.get(this.H.size() - 1)).toString();
/*     */     }
/* 173 */     return "";
/*     */   }
/*     */   
/*     */   public int getStatusCode() {
/* 177 */     if (this.a != null) {
/* 178 */       return this.a.getStatusLine().getStatusCode();
/*     */     }
/* 180 */     return 0;
/*     */   }
/*     */   
/*     */   public BasicCookieStore a() {
/* 184 */     return (BasicCookieStore)this.a;
/*     */   }
/*     */   
/*     */   public String cH() {
/* 188 */     return this.fQ;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\a\b\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */