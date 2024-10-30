/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.HttpResponseInterceptor;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.protocol.RequestAddCookies;
/*     */ import org.apache.http.client.protocol.RequestAuthCache;
/*     */ import org.apache.http.client.protocol.RequestClientConnControl;
/*     */ import org.apache.http.client.protocol.RequestDefaultHeaders;
/*     */ import org.apache.http.client.protocol.RequestProxyAuthentication;
/*     */ import org.apache.http.client.protocol.RequestTargetAuthentication;
/*     */ import org.apache.http.client.protocol.ResponseProcessCookies;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.params.HttpConnectionParams;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.params.HttpProtocolParams;
/*     */ import org.apache.http.params.SyncBasicHttpParams;
/*     */ import org.apache.http.protocol.BasicHttpProcessor;
/*     */ import org.apache.http.protocol.HTTP;
/*     */ import org.apache.http.protocol.RequestContent;
/*     */ import org.apache.http.protocol.RequestExpectContinue;
/*     */ import org.apache.http.protocol.RequestTargetHost;
/*     */ import org.apache.http.protocol.RequestUserAgent;
/*     */ import org.apache.http.util.VersionInfo;
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
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*     */ public class DefaultHttpClient
/*     */   extends AbstractHttpClient
/*     */ {
/*     */   public DefaultHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams) {
/* 129 */     super(paramClientConnectionManager, paramHttpParams);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultHttpClient(ClientConnectionManager paramClientConnectionManager) {
/* 138 */     super(paramClientConnectionManager, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public DefaultHttpClient(HttpParams paramHttpParams) {
/* 143 */     super(null, paramHttpParams);
/*     */   }
/*     */ 
/*     */   
/*     */   public DefaultHttpClient() {
/* 148 */     super(null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpParams createHttpParams() {
/* 159 */     SyncBasicHttpParams syncBasicHttpParams = new SyncBasicHttpParams();
/* 160 */     setDefaultHttpParams((HttpParams)syncBasicHttpParams);
/* 161 */     return (HttpParams)syncBasicHttpParams;
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
/*     */   public static void setDefaultHttpParams(HttpParams paramHttpParams) {
/* 181 */     HttpProtocolParams.setVersion(paramHttpParams, (ProtocolVersion)HttpVersion.HTTP_1_1);
/* 182 */     HttpProtocolParams.setContentCharset(paramHttpParams, HTTP.DEF_CONTENT_CHARSET.name());
/* 183 */     HttpConnectionParams.setTcpNoDelay(paramHttpParams, true);
/* 184 */     HttpConnectionParams.setSocketBufferSize(paramHttpParams, 8192);
/* 185 */     HttpProtocolParams.setUserAgent(paramHttpParams, VersionInfo.getUserAgent("Apache-HttpClient", "org.apache.http.client", DefaultHttpClient.class));
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
/*     */   protected BasicHttpProcessor createHttpProcessor() {
/* 209 */     BasicHttpProcessor basicHttpProcessor = new BasicHttpProcessor();
/* 210 */     basicHttpProcessor.addInterceptor((HttpRequestInterceptor)new RequestDefaultHeaders());
/*     */     
/* 212 */     basicHttpProcessor.addInterceptor((HttpRequestInterceptor)new RequestContent());
/* 213 */     basicHttpProcessor.addInterceptor((HttpRequestInterceptor)new RequestTargetHost());
/*     */     
/* 215 */     basicHttpProcessor.addInterceptor((HttpRequestInterceptor)new RequestClientConnControl());
/* 216 */     basicHttpProcessor.addInterceptor((HttpRequestInterceptor)new RequestUserAgent());
/* 217 */     basicHttpProcessor.addInterceptor((HttpRequestInterceptor)new RequestExpectContinue());
/*     */     
/* 219 */     basicHttpProcessor.addInterceptor((HttpRequestInterceptor)new RequestAddCookies());
/* 220 */     basicHttpProcessor.addInterceptor((HttpResponseInterceptor)new ResponseProcessCookies());
/*     */     
/* 222 */     basicHttpProcessor.addInterceptor((HttpRequestInterceptor)new RequestAuthCache());
/* 223 */     basicHttpProcessor.addInterceptor((HttpRequestInterceptor)new RequestTargetAuthentication());
/* 224 */     basicHttpProcessor.addInterceptor((HttpRequestInterceptor)new RequestProxyAuthentication());
/* 225 */     return basicHttpProcessor;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\DefaultHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */