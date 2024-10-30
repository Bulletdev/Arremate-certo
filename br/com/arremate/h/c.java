/*     */ package br.com.arremate.h;
/*     */ 
/*     */ import com.google.a.o.a.af;
/*     */ import java.io.IOException;
/*     */ import java.net.Socket;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.security.KeyManagementException;
/*     */ import java.security.KeyStore;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.net.ssl.HostnameVerifier;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import org.apache.http.ConnectionReuseStrategy;
/*     */ import org.apache.http.client.CookieStore;
/*     */ import org.apache.http.client.RedirectStrategy;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
/*     */ import org.apache.http.conn.ssl.NoopHostnameVerifier;
/*     */ import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
/*     */ import org.apache.http.impl.DefaultConnectionReuseStrategy;
/*     */ import org.apache.http.impl.client.BasicCookieStore;
/*     */ import org.apache.http.impl.client.HttpClientBuilder;
/*     */ import org.apache.http.impl.client.HttpClients;
/*     */ import org.apache.http.impl.client.LaxRedirectStrategy;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.ssl.SSLContextBuilder;
/*     */ import org.apache.http.ssl.SSLContexts;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */ {
/*  42 */   private static final Logger a = LoggerFactory.getLogger(c.class);
/*     */   
/*     */   private static final int al = 5;
/*     */   
/*     */   private static final int am = 25;
/*     */   
/*     */   private KeyStore a;
/*     */   
/*     */   private char[] a;
/*     */   
/*     */   private Set<Integer> d;
/*     */   private Map<String, String> x;
/*     */   private Charset a;
/*     */   private int an;
/*     */   private int ao;
/*     */   private int ap;
/*     */   private int aq;
/*     */   private boolean u;
/*     */   private boolean v;
/*     */   private String cookieSpec;
/*     */   private af a;
/*     */   
/*     */   public void a(KeyStore paramKeyStore, char[] paramArrayOfchar) {
/*  65 */     this.a = (af)paramKeyStore;
/*  66 */     this.a = (af)paramArrayOfchar;
/*     */   }
/*     */   
/*     */   public c a(int paramInt) {
/*  70 */     if (this.d == null) {
/*  71 */       this.d = new HashSet<>();
/*     */     }
/*     */     
/*  74 */     this.d.add(Integer.valueOf(paramInt));
/*  75 */     return this;
/*     */   }
/*     */   
/*     */   public c a(String paramString1, String paramString2) {
/*  79 */     if (this.x == null) {
/*  80 */       this.x = new HashMap<>();
/*     */     }
/*     */     
/*  83 */     this.x.put(paramString1, paramString2);
/*  84 */     return this;
/*     */   }
/*     */   
/*     */   public c a(Charset paramCharset) {
/*  88 */     this.a = (af)paramCharset;
/*  89 */     return this;
/*     */   }
/*     */   
/*     */   public c b(int paramInt) {
/*  93 */     this.an = paramInt;
/*  94 */     return this;
/*     */   }
/*     */   
/*     */   public c c(int paramInt) {
/*  98 */     this.ao = paramInt;
/*  99 */     return this;
/*     */   }
/*     */   
/*     */   public c d(int paramInt) {
/* 103 */     this.ap = paramInt;
/* 104 */     return this;
/*     */   }
/*     */   
/*     */   public c e(int paramInt) {
/* 108 */     this.aq = paramInt;
/* 109 */     return this;
/*     */   }
/*     */   
/*     */   public c a() {
/* 113 */     this.u = true;
/* 114 */     return this;
/*     */   }
/*     */   
/*     */   public c b() {
/* 118 */     this.v = true;
/* 119 */     return this;
/*     */   }
/*     */   
/*     */   public c a(af paramaf) {
/* 123 */     this.a = paramaf;
/* 124 */     return this;
/*     */   }
/*     */   
/*     */   public c a(String paramString) {
/* 128 */     this.cookieSpec = paramString;
/* 129 */     return this;
/*     */   }
/*     */   
/*     */   public b a() {
/* 133 */     BasicCookieStore basicCookieStore = new BasicCookieStore();
/*     */ 
/*     */     
/* 136 */     if (this.an <= 0 && this.ao <= 0) {
/* 137 */       this.an = (int)TimeUnit.SECONDS.toMillis(25L);
/* 138 */       this.ao = (int)TimeUnit.SECONDS.toMillis(25L);
/* 139 */     } else if (this.an > 0 && this.ao <= 0) {
/* 140 */       this.ao = this.an;
/* 141 */     } else if (this.an <= 0) {
/* 142 */       this.an = this.ao;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 147 */     RequestConfig.Builder builder = RequestConfig.custom().setConnectTimeout(this.ao).setConnectionRequestTimeout(this.ao).setSocketTimeout(this.an);
/*     */     
/* 149 */     if (this.cookieSpec != null) {
/* 150 */       builder.setCookieSpec(this.cookieSpec);
/*     */     }
/*     */     
/* 153 */     RequestConfig requestConfig = builder.build();
/*     */     
/* 155 */     HttpClientContext httpClientContext = new HttpClientContext();
/* 156 */     httpClientContext.setRequestConfig(requestConfig);
/*     */ 
/*     */     
/* 159 */     if (this.ap == 0) {
/* 160 */       this.ap = 5;
/*     */     }
/*     */     
/* 163 */     if (this.aq == 0) {
/* 164 */       this.aq = 25;
/*     */     }
/*     */ 
/*     */     
/* 168 */     SSLContext sSLContext = null;
/*     */     try {
/* 170 */       SSLContextBuilder sSLContextBuilder = SSLContexts.custom();
/* 171 */       sSLContextBuilder.loadTrustMaterial(null, (paramArrayOfX509Certificate, paramString) -> true).build();
/*     */       
/* 173 */       if (this.a != null && this.a != null) {
/* 174 */         sSLContextBuilder.loadKeyMaterial((KeyStore)this.a, (char[])this.a);
/*     */       }
/*     */       
/* 177 */       sSLContext = sSLContextBuilder.build();
/* 178 */     } catch (KeyManagementException|java.security.KeyStoreException|java.security.NoSuchAlgorithmException|java.security.UnrecoverableKeyException keyManagementException) {
/* 179 */       a.error("Failed to create SSLContext", keyManagementException);
/*     */     } 
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
/* 193 */     HttpClientBuilder httpClientBuilder1 = HttpClients.custom().setSSLContext(sSLContext).setSSLHostnameVerifier((HostnameVerifier)new NoopHostnameVerifier()).setDefaultCookieStore((CookieStore)basicCookieStore).setConnectionManagerShared(true).setRedirectStrategy((RedirectStrategy)new LaxRedirectStrategy()).setMaxConnPerRoute(this.ap).setMaxConnTotal(this.aq).setConnectionTimeToLive(2L, TimeUnit.MINUTES).setConnectionReuseStrategy((ConnectionReuseStrategy)DefaultConnectionReuseStrategy.INSTANCE).evictExpiredConnections();
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
/* 205 */     HttpClientBuilder httpClientBuilder2 = HttpClients.custom().setSSLContext(sSLContext).setSSLHostnameVerifier((HostnameVerifier)new NoopHostnameVerifier()).setDefaultCookieStore((CookieStore)basicCookieStore).setConnectionManagerShared(true).disableRedirectHandling().setMaxConnPerRoute(this.ap).setMaxConnTotal(this.aq).setConnectionTimeToLive(2L, TimeUnit.MINUTES).setConnectionReuseStrategy((ConnectionReuseStrategy)DefaultConnectionReuseStrategy.INSTANCE).evictExpiredConnections();
/*     */     
/* 207 */     if (this.v) {
/* 208 */       httpClientBuilder1.disableCookieManagement();
/* 209 */       httpClientBuilder2.disableCookieManagement();
/*     */     } 
/*     */ 
/*     */     
/* 213 */     if (this.u) {
/* 214 */       a a = new a(this, sSLContext, (HostnameVerifier)NoopHostnameVerifier.INSTANCE);
/* 215 */       httpClientBuilder1.setSSLSocketFactory((LayeredConnectionSocketFactory)a);
/* 216 */       httpClientBuilder2.setSSLSocketFactory((LayeredConnectionSocketFactory)a);
/*     */     } 
/*     */ 
/*     */     
/* 220 */     d d = new d();
/* 221 */     d.a(basicCookieStore);
/* 222 */     d.a((HttpContext)httpClientContext);
/* 223 */     d.a(httpClientBuilder1.build());
/* 224 */     d.b(httpClientBuilder2.build());
/*     */     
/* 226 */     if (this.d != null) {
/* 227 */       d.a(this.d);
/*     */     }
/*     */     
/* 230 */     if (this.x != null) {
/* 231 */       d.a(this.x);
/*     */     }
/*     */     
/* 234 */     if (this.a != null) {
/* 235 */       d.a((Charset)this.a);
/*     */     } else {
/* 237 */       d.a(StandardCharsets.ISO_8859_1);
/*     */     } 
/*     */     
/* 240 */     if (this.a != null) {
/* 241 */       d.a(this.a);
/*     */     }
/*     */     
/* 244 */     return d;
/*     */   }
/*     */   
/*     */   private final class a
/*     */     extends SSLConnectionSocketFactory
/*     */   {
/*     */     public a(c this$0, SSLContext param1SSLContext, HostnameVerifier param1HostnameVerifier) {
/* 251 */       super(param1SSLContext, param1HostnameVerifier);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Socket createLayeredSocket(Socket param1Socket, String param1String, int param1Int, HttpContext param1HttpContext) throws IOException {
/* 257 */       return super.createLayeredSocket(param1Socket, "", param1Int, param1HttpContext);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\h\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */