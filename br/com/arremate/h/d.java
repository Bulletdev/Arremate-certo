/*     */ package br.com.arremate.h;
/*     */ 
/*     */ import br.com.arremate.f.x;
/*     */ import com.google.a.o.a.af;
/*     */ import java.io.IOException;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.apache.commons.codec.binary.Base64;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.impl.client.BasicCookieStore;
/*     */ import org.apache.http.impl.client.CloseableHttpClient;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ public final class d
/*     */   implements b
/*     */ {
/*  31 */   protected static final Logger a = LoggerFactory.getLogger(d.class);
/*     */   
/*     */   private final AtomicBoolean d;
/*     */   
/*     */   private final Set<Integer> d;
/*     */   
/*     */   private BasicCookieStore a;
/*     */   
/*     */   private Map<String, String> x;
/*     */   
/*     */   private Charset a;
/*     */   
/*     */   private CloseableHttpClient a;
/*     */   private CloseableHttpClient b;
/*     */   private HttpContext a;
/*     */   private af a;
/*     */   
/*     */   d() {
/*  49 */     this.d = (Set<Integer>)new AtomicBoolean(true);
/*  50 */     this.d = new HashSet<>(Arrays.asList(new Integer[] { Integer.valueOf(200) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e a(f paramf) {
/*     */     af af1;
/*  58 */     if (!this.d.get() && !paramf.S()) {
/*  59 */       return new e();
/*     */     }
/*     */     
/*  62 */     paramf.a(this.x);
/*     */     
/*  64 */     if (paramf.Q()) {
/*  65 */       paramf.a((Charset)this.a);
/*     */     }
/*     */     
/*  68 */     HttpContext httpContext = paramf.a();
/*  69 */     if (httpContext == null) {
/*  70 */       af1 = this.a;
/*     */     }
/*     */     
/*  73 */     x x = paramf.a();
/*  74 */     if (x == null) {
/*  75 */       x = x.a;
/*     */     }
/*     */     
/*  78 */     HttpUriRequest httpUriRequest = paramf.a();
/*     */     
/*     */     try {
/*  81 */       return a(paramf.R() ? (CloseableHttpClient)this.a : this.b, httpUriRequest, x, (HttpContext)af1);
/*  82 */     } catch (Exception exception) {
/*  83 */       a.error("Failed to make request", exception);
/*     */ 
/*     */       
/*  86 */       return new e();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private e a(CloseableHttpClient paramCloseableHttpClient, HttpUriRequest paramHttpUriRequest, x paramx, HttpContext paramHttpContext) {
/*  93 */     if (this.a != null) {
/*  94 */       this.a.N();
/*     */     }
/*     */     
/*  97 */     long l = System.currentTimeMillis();
/*     */     
/*  99 */     e e = null;
/* 100 */     HttpEntity httpEntity = null;
/*     */     
/* 102 */     try (CloseableHttpResponse null = paramCloseableHttpClient.execute(paramHttpUriRequest, paramHttpContext)) {
/* 103 */       l = System.currentTimeMillis() - l;
/* 104 */       e = new e(l, closeableHttpResponse.getStatusLine().getStatusCode());
/* 105 */       e.a(paramHttpUriRequest.getURI());
/*     */       
/* 107 */       if (this.d.contains(Integer.valueOf(e.getStatusCode()))) {
/* 108 */         httpEntity = closeableHttpResponse.getEntity();
/* 109 */         String str = "";
/*     */         
/* 111 */         if (paramx == x.a) {
/* 112 */           str = EntityUtils.toString(httpEntity);
/* 113 */         } else if (paramx == x.c) {
/* 114 */           byte[] arrayOfByte = Base64.encodeBase64(EntityUtils.toByteArray(httpEntity));
/* 115 */           str = new String(arrayOfByte);
/*     */         } 
/*     */         
/* 118 */         e.setData(str);
/* 119 */         e.setHeaders(closeableHttpResponse.getAllHeaders());
/*     */       } 
/* 121 */     } catch (SocketTimeoutException socketTimeoutException) {
/* 122 */       a.error("Timed out request to {}", paramHttpUriRequest.getURI().toString(), socketTimeoutException);
/*     */       
/* 124 */       if (e == null) {
/* 125 */         l = System.currentTimeMillis() - l;
/*     */         
/* 127 */         e = new e();
/* 128 */         e.q(l);
/*     */       } 
/*     */       
/* 131 */       e.h(true);
/* 132 */       e.a(paramHttpUriRequest.getURI());
/* 133 */     } catch (Exception exception) {
/* 134 */       a.error("Failed to make request to {}", paramHttpUriRequest.getURI().toString(), exception);
/*     */       
/* 136 */       if (e == null) {
/* 137 */         l = System.currentTimeMillis() - l;
/*     */         
/* 139 */         e = new e();
/* 140 */         e.q(l);
/*     */       } 
/*     */       
/* 143 */       e.a(exception);
/* 144 */       e.a(paramHttpUriRequest.getURI());
/*     */     } 
/*     */ 
/*     */     
/* 148 */     if (httpEntity != null) {
/* 149 */       EntityUtils.consumeQuietly(httpEntity);
/*     */     }
/*     */     
/* 152 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void b() {
/*     */     try {
/* 159 */       if (this.a != null) {
/* 160 */         this.a.close();
/*     */       }
/*     */       
/* 163 */       if (this.b != null) {
/* 164 */         this.b.close();
/*     */       }
/* 166 */     } catch (IOException iOException) {
/* 167 */       a.warn("Failed to close connection", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Cookie> getCookies() {
/* 176 */     return this.a.getCookies();
/*     */   }
/*     */ 
/*     */   
/*     */   public String P() {
/* 181 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 183 */     this.a.getCookies().forEach(paramCookie -> paramStringBuilder.append(paramCookie.getName()).append("=").append(paramCookie.getValue()).append(";"));
/*     */ 
/*     */ 
/*     */     
/* 187 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void bB() {
/* 192 */     this.a.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addCookie(Cookie paramCookie) {
/* 197 */     this.a.addCookie(paramCookie);
/*     */   }
/*     */   
/*     */   void a(Map<String, String> paramMap) {
/* 201 */     if (this.x == null) {
/* 202 */       this.x = new HashMap<>();
/*     */     }
/*     */     
/* 205 */     this.x.putAll(paramMap);
/*     */   }
/*     */   
/*     */   void a(Set<Integer> paramSet) {
/* 209 */     this.d.addAll(paramSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bC() {
/* 214 */     this.d.set(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bD() {
/* 219 */     this.d.set(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void a(BasicCookieStore paramBasicCookieStore) {
/* 226 */     this.a = (af)paramBasicCookieStore;
/*     */   }
/*     */   
/*     */   void a(Charset paramCharset) {
/* 230 */     this.a = (af)paramCharset;
/*     */   }
/*     */   
/*     */   void a(CloseableHttpClient paramCloseableHttpClient) {
/* 234 */     this.a = (af)paramCloseableHttpClient;
/*     */   }
/*     */   
/*     */   void b(CloseableHttpClient paramCloseableHttpClient) {
/* 238 */     this.b = paramCloseableHttpClient;
/*     */   }
/*     */   
/*     */   void a(HttpContext paramHttpContext) {
/* 242 */     this.a = (af)paramHttpContext;
/*     */   }
/*     */   
/*     */   void a(af paramaf) {
/* 246 */     this.a = paramaf;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\h\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */