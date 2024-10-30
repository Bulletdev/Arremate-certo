/*     */ package org.apache.http.client.config;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.util.Collection;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class RequestConfig
/*     */   implements Cloneable
/*     */ {
/*  45 */   public static final RequestConfig DEFAULT = (new Builder()).build();
/*     */   
/*     */   private final boolean expectContinueEnabled;
/*     */   
/*     */   private final HttpHost proxy;
/*     */   
/*     */   private final InetAddress localAddress;
/*     */   
/*     */   private final boolean staleConnectionCheckEnabled;
/*     */   private final String cookieSpec;
/*     */   private final boolean redirectsEnabled;
/*     */   private final boolean relativeRedirectsAllowed;
/*     */   private final boolean circularRedirectsAllowed;
/*     */   private final int maxRedirects;
/*     */   private final boolean authenticationEnabled;
/*     */   private final Collection<String> targetPreferredAuthSchemes;
/*     */   private final Collection<String> proxyPreferredAuthSchemes;
/*     */   private final int connectionRequestTimeout;
/*     */   private final int connectTimeout;
/*     */   private final int socketTimeout;
/*     */   private final boolean contentCompressionEnabled;
/*     */   private final boolean normalizeUri;
/*     */   
/*     */   protected RequestConfig() {
/*  69 */     this(false, null, null, false, null, false, false, false, 0, false, null, null, 0, 0, 0, true, true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   RequestConfig(boolean paramBoolean1, HttpHost paramHttpHost, InetAddress paramInetAddress, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, boolean paramBoolean6, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean7, boolean paramBoolean8) {
/*  91 */     this.expectContinueEnabled = paramBoolean1;
/*  92 */     this.proxy = paramHttpHost;
/*  93 */     this.localAddress = paramInetAddress;
/*  94 */     this.staleConnectionCheckEnabled = paramBoolean2;
/*  95 */     this.cookieSpec = paramString;
/*  96 */     this.redirectsEnabled = paramBoolean3;
/*  97 */     this.relativeRedirectsAllowed = paramBoolean4;
/*  98 */     this.circularRedirectsAllowed = paramBoolean5;
/*  99 */     this.maxRedirects = paramInt1;
/* 100 */     this.authenticationEnabled = paramBoolean6;
/* 101 */     this.targetPreferredAuthSchemes = paramCollection1;
/* 102 */     this.proxyPreferredAuthSchemes = paramCollection2;
/* 103 */     this.connectionRequestTimeout = paramInt2;
/* 104 */     this.connectTimeout = paramInt3;
/* 105 */     this.socketTimeout = paramInt4;
/* 106 */     this.contentCompressionEnabled = paramBoolean7;
/* 107 */     this.normalizeUri = paramBoolean8;
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
/*     */   public boolean isExpectContinueEnabled() {
/* 133 */     return this.expectContinueEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpHost getProxy() {
/* 143 */     return this.proxy;
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
/*     */ 
/*     */   
/*     */   public InetAddress getLocalAddress() {
/* 158 */     return this.localAddress;
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
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean isStaleConnectionCheckEnabled() {
/* 175 */     return this.staleConnectionCheckEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCookieSpec() {
/* 186 */     return this.cookieSpec;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRedirectsEnabled() {
/* 196 */     return this.redirectsEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRelativeRedirectsAllowed() {
/* 207 */     return this.relativeRedirectsAllowed;
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
/*     */   public boolean isCircularRedirectsAllowed() {
/* 219 */     return this.circularRedirectsAllowed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxRedirects() {
/* 230 */     return this.maxRedirects;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAuthenticationEnabled() {
/* 240 */     return this.authenticationEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<String> getTargetPreferredAuthSchemes() {
/* 251 */     return this.targetPreferredAuthSchemes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<String> getProxyPreferredAuthSchemes() {
/* 262 */     return this.proxyPreferredAuthSchemes;
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
/*     */ 
/*     */   
/*     */   public int getConnectionRequestTimeout() {
/* 277 */     return this.connectionRequestTimeout;
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
/*     */   
/*     */   public int getConnectTimeout() {
/* 291 */     return this.connectTimeout;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSocketTimeout() {
/* 307 */     return this.socketTimeout;
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
/*     */   @Deprecated
/*     */   public boolean isDecompressionEnabled() {
/* 321 */     return this.contentCompressionEnabled;
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
/*     */   public boolean isContentCompressionEnabled() {
/* 333 */     return this.contentCompressionEnabled;
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
/*     */   public boolean isNormalizeUri() {
/* 345 */     return this.normalizeUri;
/*     */   }
/*     */ 
/*     */   
/*     */   protected RequestConfig clone() throws CloneNotSupportedException {
/* 350 */     return (RequestConfig)super.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 355 */     StringBuilder stringBuilder = new StringBuilder();
/* 356 */     stringBuilder.append("[");
/* 357 */     stringBuilder.append("expectContinueEnabled=").append(this.expectContinueEnabled);
/* 358 */     stringBuilder.append(", proxy=").append(this.proxy);
/* 359 */     stringBuilder.append(", localAddress=").append(this.localAddress);
/* 360 */     stringBuilder.append(", cookieSpec=").append(this.cookieSpec);
/* 361 */     stringBuilder.append(", redirectsEnabled=").append(this.redirectsEnabled);
/* 362 */     stringBuilder.append(", relativeRedirectsAllowed=").append(this.relativeRedirectsAllowed);
/* 363 */     stringBuilder.append(", maxRedirects=").append(this.maxRedirects);
/* 364 */     stringBuilder.append(", circularRedirectsAllowed=").append(this.circularRedirectsAllowed);
/* 365 */     stringBuilder.append(", authenticationEnabled=").append(this.authenticationEnabled);
/* 366 */     stringBuilder.append(", targetPreferredAuthSchemes=").append(this.targetPreferredAuthSchemes);
/* 367 */     stringBuilder.append(", proxyPreferredAuthSchemes=").append(this.proxyPreferredAuthSchemes);
/* 368 */     stringBuilder.append(", connectionRequestTimeout=").append(this.connectionRequestTimeout);
/* 369 */     stringBuilder.append(", connectTimeout=").append(this.connectTimeout);
/* 370 */     stringBuilder.append(", socketTimeout=").append(this.socketTimeout);
/* 371 */     stringBuilder.append(", contentCompressionEnabled=").append(this.contentCompressionEnabled);
/* 372 */     stringBuilder.append(", normalizeUri=").append(this.normalizeUri);
/* 373 */     stringBuilder.append("]");
/* 374 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static Builder custom() {
/* 378 */     return new Builder();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Builder copy(RequestConfig paramRequestConfig) {
/* 383 */     return (new Builder()).setExpectContinueEnabled(paramRequestConfig.isExpectContinueEnabled()).setProxy(paramRequestConfig.getProxy()).setLocalAddress(paramRequestConfig.getLocalAddress()).setStaleConnectionCheckEnabled(paramRequestConfig.isStaleConnectionCheckEnabled()).setCookieSpec(paramRequestConfig.getCookieSpec()).setRedirectsEnabled(paramRequestConfig.isRedirectsEnabled()).setRelativeRedirectsAllowed(paramRequestConfig.isRelativeRedirectsAllowed()).setCircularRedirectsAllowed(paramRequestConfig.isCircularRedirectsAllowed()).setMaxRedirects(paramRequestConfig.getMaxRedirects()).setAuthenticationEnabled(paramRequestConfig.isAuthenticationEnabled()).setTargetPreferredAuthSchemes(paramRequestConfig.getTargetPreferredAuthSchemes()).setProxyPreferredAuthSchemes(paramRequestConfig.getProxyPreferredAuthSchemes()).setConnectionRequestTimeout(paramRequestConfig.getConnectionRequestTimeout()).setConnectTimeout(paramRequestConfig.getConnectTimeout()).setSocketTimeout(paramRequestConfig.getSocketTimeout()).setDecompressionEnabled(paramRequestConfig.isDecompressionEnabled()).setContentCompressionEnabled(paramRequestConfig.isContentCompressionEnabled()).setNormalizeUri(paramRequestConfig.isNormalizeUri());
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Builder
/*     */   {
/*     */     private boolean staleConnectionCheckEnabled = false;
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
/*     */     private boolean redirectsEnabled = true;
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
/* 428 */     private int maxRedirects = 50;
/*     */     private boolean relativeRedirectsAllowed = true;
/*     */     private boolean authenticationEnabled = true;
/* 431 */     private int connectionRequestTimeout = -1;
/* 432 */     private int connectTimeout = -1;
/* 433 */     private int socketTimeout = -1; private boolean contentCompressionEnabled = true;
/*     */     private boolean normalizeUri = true;
/*     */     private boolean expectContinueEnabled;
/*     */     private HttpHost proxy;
/*     */     
/*     */     public Builder setExpectContinueEnabled(boolean param1Boolean) {
/* 439 */       this.expectContinueEnabled = param1Boolean;
/* 440 */       return this;
/*     */     }
/*     */     private InetAddress localAddress; private String cookieSpec; private boolean circularRedirectsAllowed; private Collection<String> targetPreferredAuthSchemes; private Collection<String> proxyPreferredAuthSchemes;
/*     */     public Builder setProxy(HttpHost param1HttpHost) {
/* 444 */       this.proxy = param1HttpHost;
/* 445 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setLocalAddress(InetAddress param1InetAddress) {
/* 449 */       this.localAddress = param1InetAddress;
/* 450 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public Builder setStaleConnectionCheckEnabled(boolean param1Boolean) {
/* 459 */       this.staleConnectionCheckEnabled = param1Boolean;
/* 460 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setCookieSpec(String param1String) {
/* 464 */       this.cookieSpec = param1String;
/* 465 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setRedirectsEnabled(boolean param1Boolean) {
/* 469 */       this.redirectsEnabled = param1Boolean;
/* 470 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setRelativeRedirectsAllowed(boolean param1Boolean) {
/* 474 */       this.relativeRedirectsAllowed = param1Boolean;
/* 475 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setCircularRedirectsAllowed(boolean param1Boolean) {
/* 479 */       this.circularRedirectsAllowed = param1Boolean;
/* 480 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setMaxRedirects(int param1Int) {
/* 484 */       this.maxRedirects = param1Int;
/* 485 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setAuthenticationEnabled(boolean param1Boolean) {
/* 489 */       this.authenticationEnabled = param1Boolean;
/* 490 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setTargetPreferredAuthSchemes(Collection<String> param1Collection) {
/* 494 */       this.targetPreferredAuthSchemes = param1Collection;
/* 495 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setProxyPreferredAuthSchemes(Collection<String> param1Collection) {
/* 499 */       this.proxyPreferredAuthSchemes = param1Collection;
/* 500 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setConnectionRequestTimeout(int param1Int) {
/* 504 */       this.connectionRequestTimeout = param1Int;
/* 505 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setConnectTimeout(int param1Int) {
/* 509 */       this.connectTimeout = param1Int;
/* 510 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setSocketTimeout(int param1Int) {
/* 514 */       this.socketTimeout = param1Int;
/* 515 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public Builder setDecompressionEnabled(boolean param1Boolean) {
/* 524 */       this.contentCompressionEnabled = param1Boolean;
/* 525 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setContentCompressionEnabled(boolean param1Boolean) {
/* 529 */       this.contentCompressionEnabled = param1Boolean;
/* 530 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setNormalizeUri(boolean param1Boolean) {
/* 534 */       this.normalizeUri = param1Boolean;
/* 535 */       return this;
/*     */     }
/*     */     
/*     */     public RequestConfig build() {
/* 539 */       return new RequestConfig(this.expectContinueEnabled, this.proxy, this.localAddress, this.staleConnectionCheckEnabled, this.cookieSpec, this.redirectsEnabled, this.relativeRedirectsAllowed, this.circularRedirectsAllowed, this.maxRedirects, this.authenticationEnabled, this.targetPreferredAuthSchemes, this.proxyPreferredAuthSchemes, this.connectionRequestTimeout, this.connectTimeout, this.socketTimeout, this.contentCompressionEnabled, this.normalizeUri);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\config\RequestConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */