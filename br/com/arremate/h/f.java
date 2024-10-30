/*     */ package br.com.arremate.h;
/*     */ 
/*     */ import br.com.arremate.f.x;
/*     */ import java.io.File;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.client.methods.HttpDelete;
/*     */ import org.apache.http.client.methods.HttpGet;
/*     */ import org.apache.http.client.methods.HttpOptions;
/*     */ import org.apache.http.client.methods.HttpPost;
/*     */ import org.apache.http.client.methods.HttpPut;
/*     */ import org.apache.http.client.methods.HttpRequestBase;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.utils.URIBuilder;
/*     */ import org.apache.http.client.utils.URLEncodedUtils;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.entity.StringEntity;
/*     */ import org.apache.http.entity.mime.HttpMultipartMode;
/*     */ import org.apache.http.entity.mime.MultipartEntityBuilder;
/*     */ import org.apache.http.message.BasicNameValuePair;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */ {
/*     */   private final a a;
/*     */   private final StringBuilder a;
/*     */   private Map<String, String> parameters;
/*     */   private i h;
/*     */   private String aN;
/*     */   private File a;
/*     */   private Map<String, String> headers;
/*     */   private Map<String, String> y;
/*     */   private HttpContext b;
/*     */   private x d;
/*     */   private ContentType contentType;
/*     */   private Charset charset;
/*     */   private boolean x;
/*     */   private boolean y;
/*     */   
/*     */   f(a parama) {
/*  52 */     this.a = (File)parama;
/*  53 */     this.a = (File)new StringBuilder();
/*  54 */     this.x = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f a(Object paramObject) {
/*  61 */     this.a.append(paramObject);
/*  62 */     return this;
/*     */   }
/*     */   
/*     */   public f a(String paramString) {
/*  66 */     this.a.append(paramString);
/*  67 */     return this;
/*     */   }
/*     */   
/*     */   public f a(int paramInt) {
/*  71 */     this.a.append(paramInt);
/*  72 */     return this;
/*     */   }
/*     */   
/*     */   public f a(long paramLong) {
/*  76 */     this.a.append(paramLong);
/*  77 */     return this;
/*     */   }
/*     */   
/*     */   public f a(float paramFloat) {
/*  81 */     this.a.append(paramFloat);
/*  82 */     return this;
/*     */   }
/*     */   
/*     */   public f a(double paramDouble) {
/*  86 */     this.a.append(paramDouble);
/*  87 */     return this;
/*     */   }
/*     */   
/*     */   public HttpUriRequest a() {
/*     */     HttpRequestBase httpRequestBase;
/*  92 */     switch (null.h[this.a.ordinal()]) {
/*     */       case 1:
/*  94 */         httpRequestBase = e();
/*     */         break;
/*     */       case 2:
/*  97 */         httpRequestBase = a();
/*     */         break;
/*     */       case 3:
/* 100 */         httpRequestBase = b();
/*     */         break;
/*     */       case 4:
/* 103 */         httpRequestBase = d();
/*     */         break;
/*     */       case 5:
/* 106 */         httpRequestBase = c();
/*     */         break;
/*     */       case 6:
/* 109 */         httpRequestBase = f();
/*     */         break;
/*     */       case 7:
/* 112 */         httpRequestBase = g();
/*     */         break;
/*     */       case 8:
/* 115 */         httpRequestBase = h();
/*     */         break;
/*     */       default:
/* 118 */         httpRequestBase = e();
/*     */         break;
/*     */     } 
/* 121 */     if (this.y != null) {
/* 122 */       if (this.headers == null) {
/* 123 */         this.headers = new HashMap<>();
/*     */       }
/*     */       
/* 126 */       this.headers.putAll(this.y);
/*     */     } 
/*     */     
/* 129 */     if (this.headers != null) {
/* 130 */       this.headers.forEach(httpRequestBase::addHeader);
/*     */     }
/*     */     
/* 133 */     return (HttpUriRequest)httpRequestBase;
/*     */   }
/*     */ 
/*     */   
/*     */   private ContentType a(ContentType paramContentType) {
/*     */     ContentType contentType;
/* 139 */     if (this.contentType == null) {
/* 140 */       contentType = paramContentType.withCharset(this.charset);
/*     */     } else {
/* 142 */       contentType = this.contentType.withCharset(this.charset);
/*     */     } 
/*     */     
/* 145 */     return contentType;
/*     */   }
/*     */   
/*     */   private HttpRequestBase a() {
/* 149 */     ContentType contentType = a(ContentType.APPLICATION_FORM_URLENCODED);
/* 150 */     HttpPost httpPost = new HttpPost(this.a.toString());
/*     */     
/* 152 */     if (this.parameters != null) {
/*     */ 
/*     */       
/* 155 */       List list = (List)this.parameters.entrySet().stream().map(paramEntry -> new BasicNameValuePair((String)paramEntry.getKey(), (String)paramEntry.getValue())).collect(Collectors.toList());
/*     */       
/* 157 */       httpPost.setEntity((HttpEntity)new StringEntity(URLEncodedUtils.format(list, this.charset), contentType));
/*     */     } 
/*     */     
/* 160 */     return (HttpRequestBase)httpPost;
/*     */   }
/*     */   
/*     */   private HttpRequestBase b() {
/* 164 */     ContentType contentType = a(ContentType.APPLICATION_JSON);
/* 165 */     HttpPost httpPost = new HttpPost(this.a.toString());
/*     */     
/* 167 */     if (this.h != null) {
/* 168 */       httpPost.setEntity((HttpEntity)new StringEntity(this.h.toString(), contentType));
/*     */     }
/*     */     
/* 171 */     return (HttpRequestBase)httpPost;
/*     */   }
/*     */   
/*     */   private HttpRequestBase c() {
/* 175 */     ContentType contentType = a(ContentType.create("application/pdf"));
/* 176 */     HttpPost httpPost = new HttpPost(this.a.toString());
/*     */     
/* 178 */     if (this.a != null) {
/* 179 */       MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
/* 180 */       multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
/* 181 */       multipartEntityBuilder.addBinaryBody("pdf", this.a, contentType, "file.pdf");
/* 182 */       httpPost.setEntity(multipartEntityBuilder.build());
/*     */     } 
/*     */     
/* 185 */     return (HttpRequestBase)httpPost;
/*     */   }
/*     */   
/*     */   private HttpRequestBase d() {
/* 189 */     ContentType contentType = a(ContentType.APPLICATION_FORM_URLENCODED);
/* 190 */     HttpPost httpPost = new HttpPost(this.a.toString());
/*     */     
/* 192 */     if (this.aN != null && !this.aN.isEmpty()) {
/* 193 */       httpPost.setEntity((HttpEntity)new StringEntity(this.aN, contentType));
/*     */     }
/*     */     
/* 196 */     return (HttpRequestBase)httpPost;
/*     */   }
/*     */   
/*     */   private HttpRequestBase e() {
/*     */     try {
/* 201 */       return (HttpRequestBase)new HttpGet(a());
/*     */     }
/* 203 */     catch (URISyntaxException uRISyntaxException) {
/*     */ 
/*     */       
/* 206 */       return null;
/*     */     } 
/*     */   }
/*     */   private HttpRequestBase f() {
/*     */     try {
/* 211 */       return (HttpRequestBase)new HttpDelete(a());
/*     */     }
/* 213 */     catch (URISyntaxException uRISyntaxException) {
/*     */ 
/*     */       
/* 216 */       return null;
/*     */     } 
/*     */   }
/*     */   private HttpRequestBase g() {
/*     */     try {
/* 221 */       return (HttpRequestBase)new HttpPut(a());
/*     */     }
/* 223 */     catch (URISyntaxException uRISyntaxException) {
/*     */ 
/*     */       
/* 226 */       return null;
/*     */     } 
/*     */   }
/*     */   private HttpRequestBase h() {
/*     */     try {
/* 231 */       return (HttpRequestBase)new HttpOptions(a());
/*     */     }
/* 233 */     catch (URISyntaxException uRISyntaxException) {
/*     */ 
/*     */       
/* 236 */       return null;
/*     */     } 
/*     */   }
/*     */   private URI a() throws URISyntaxException {
/* 240 */     URIBuilder uRIBuilder = (new URIBuilder(this.a.toString())).setCharset(this.charset);
/* 241 */     if (this.parameters != null) {
/* 242 */       this.parameters.forEach(uRIBuilder::addParameter);
/*     */     }
/*     */     
/* 245 */     return uRIBuilder.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f a(File paramFile) {
/* 252 */     this.a = paramFile;
/* 253 */     return this;
/*     */   }
/*     */   
/*     */   public f a(String paramString1, String paramString2) {
/* 257 */     if (this.parameters == null) {
/* 258 */       this.parameters = new HashMap<>();
/*     */     }
/*     */     
/* 261 */     this.parameters.put(paramString1, paramString2);
/* 262 */     return this;
/*     */   }
/*     */   
/*     */   public f a(String paramString, int paramInt) {
/* 266 */     if (this.parameters == null) {
/* 267 */       this.parameters = new HashMap<>();
/*     */     }
/*     */     
/* 270 */     this.parameters.put(paramString, Integer.toString(paramInt));
/* 271 */     return this;
/*     */   }
/*     */   
/*     */   public f a(String paramString, long paramLong) {
/* 275 */     if (this.parameters == null) {
/* 276 */       this.parameters = new HashMap<>();
/*     */     }
/*     */     
/* 279 */     this.parameters.put(paramString, Long.toString(paramLong));
/* 280 */     return this;
/*     */   }
/*     */   
/*     */   public f a(String paramString, double paramDouble) {
/* 284 */     if (this.parameters == null) {
/* 285 */       this.parameters = new HashMap<>();
/*     */     }
/*     */     
/* 288 */     this.parameters.put(paramString, Double.toString(paramDouble));
/* 289 */     return this;
/*     */   }
/*     */   
/*     */   public f a(Map<String, String> paramMap) {
/* 293 */     if (this.parameters == null) {
/* 294 */       this.parameters = new HashMap<>();
/*     */     }
/*     */     
/* 297 */     paramMap.forEach(this.parameters::put);
/* 298 */     return this;
/*     */   }
/*     */   
/*     */   public f a(i parami) {
/* 302 */     this.h = parami;
/* 303 */     return this;
/*     */   }
/*     */   
/*     */   public f b(String paramString) {
/* 307 */     this.aN = paramString;
/* 308 */     return this;
/*     */   }
/*     */   
/*     */   void a(Map<String, String> paramMap) {
/* 312 */     if (paramMap != null) {
/* 313 */       this.headers = new HashMap<>(paramMap);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f b(String paramString1, String paramString2) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield y : Ljava/util/Map;
/*     */     //   4: ifnonnull -> 18
/*     */     //   7: aload_0
/*     */     //   8: new java/util/HashMap
/*     */     //   11: dup
/*     */     //   12: invokespecial <init> : ()V
/*     */     //   15: putfield y : Ljava/util/Map;
/*     */     //   18: aload_0
/*     */     //   19: getfield y : Ljava/util/Map;
/*     */     //   22: aload_1
/*     */     //   23: aload_2
/*     */     //   24: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   29: pop
/*     */     //   30: aload_0
/*     */     //   31: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #318	-> 0
/*     */     //   #319	-> 7
/*     */     //   #322	-> 18
/*     */     //   #323	-> 30
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f b(Map<String, String> paramMap) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield y : Ljava/util/Map;
/*     */     //   4: ifnonnull -> 18
/*     */     //   7: aload_0
/*     */     //   8: new java/util/HashMap
/*     */     //   11: dup
/*     */     //   12: invokespecial <init> : ()V
/*     */     //   15: putfield y : Ljava/util/Map;
/*     */     //   18: aload_0
/*     */     //   19: getfield y : Ljava/util/Map;
/*     */     //   22: aload_1
/*     */     //   23: invokeinterface putAll : (Ljava/util/Map;)V
/*     */     //   28: aload_0
/*     */     //   29: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #327	-> 0
/*     */     //   #328	-> 7
/*     */     //   #331	-> 18
/*     */     //   #332	-> 28
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   HttpContext a() {
/* 336 */     return this.b;
/*     */   }
/*     */   
/*     */   public f a(HttpContext paramHttpContext) {
/* 340 */     this.b = paramHttpContext;
/* 341 */     return this;
/*     */   }
/*     */   
/*     */   x a() {
/* 345 */     return this.d;
/*     */   }
/*     */   
/*     */   public f a(x paramx) {
/* 349 */     this.d = paramx;
/* 350 */     return this;
/*     */   }
/*     */   
/*     */   public void a(ContentType paramContentType) {
/* 354 */     this.contentType = paramContentType;
/*     */   }
/*     */   
/*     */   boolean Q() {
/* 358 */     return (this.charset == null);
/*     */   }
/*     */   
/*     */   public f a(Charset paramCharset) {
/* 362 */     this.charset = paramCharset;
/* 363 */     return this;
/*     */   }
/*     */   
/*     */   boolean R() {
/* 367 */     return this.x;
/*     */   }
/*     */   
/*     */   public f a() {
/* 371 */     this.x = false;
/* 372 */     return this;
/*     */   }
/*     */   
/*     */   boolean S() {
/* 376 */     return this.y;
/*     */   }
/*     */   
/*     */   public f b() {
/* 380 */     this.y = true;
/* 381 */     return this;
/*     */   }
/*     */   
/*     */   public String getUrl() {
/* 385 */     return this.a.toString();
/*     */   }
/*     */   
/*     */   public enum a {
/* 389 */     b,
/* 390 */     c,
/* 391 */     d,
/* 392 */     e,
/* 393 */     f,
/* 394 */     g,
/* 395 */     h,
/* 396 */     i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\h\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */