/*     */ package org.apache.http.client.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Locale;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseInterceptor;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.entity.DecompressingEntity;
/*     */ import org.apache.http.client.entity.DeflateInputStreamFactory;
/*     */ import org.apache.http.client.entity.GZIPInputStreamFactory;
/*     */ import org.apache.http.client.entity.InputStreamFactory;
/*     */ import org.apache.http.config.Lookup;
/*     */ import org.apache.http.config.RegistryBuilder;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class ResponseContentEncoding
/*     */   implements HttpResponseInterceptor
/*     */ {
/*     */   public static final String UNCOMPRESSED = "http.client.response.uncompressed";
/*     */   private final Lookup<InputStreamFactory> decoderRegistry;
/*     */   private final boolean ignoreUnknown;
/*     */   
/*     */   public ResponseContentEncoding(Lookup<InputStreamFactory> paramLookup, boolean paramBoolean) {
/*  70 */     this.decoderRegistry = (paramLookup != null) ? paramLookup : (Lookup<InputStreamFactory>)RegistryBuilder.create().register("gzip", GZIPInputStreamFactory.getInstance()).register("x-gzip", GZIPInputStreamFactory.getInstance()).register("deflate", DeflateInputStreamFactory.getInstance()).build();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     this.ignoreUnknown = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResponseContentEncoding(boolean paramBoolean) {
/*  83 */     this(null, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResponseContentEncoding(Lookup<InputStreamFactory> paramLookup) {
/*  90 */     this(paramLookup, true);
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
/*     */   public ResponseContentEncoding() {
/* 102 */     this((Lookup<InputStreamFactory>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws HttpException, IOException {
/* 109 */     HttpEntity httpEntity = paramHttpResponse.getEntity();
/*     */     
/* 111 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/* 112 */     RequestConfig requestConfig = httpClientContext.getRequestConfig();
/*     */ 
/*     */     
/* 115 */     if (requestConfig.isContentCompressionEnabled() && httpEntity != null && httpEntity.getContentLength() != 0L) {
/* 116 */       Header header = httpEntity.getContentEncoding();
/* 117 */       if (header != null) {
/* 118 */         HeaderElement[] arrayOfHeaderElement = header.getElements();
/* 119 */         for (HeaderElement headerElement : arrayOfHeaderElement) {
/* 120 */           String str = headerElement.getName().toLowerCase(Locale.ROOT);
/* 121 */           InputStreamFactory inputStreamFactory = (InputStreamFactory)this.decoderRegistry.lookup(str);
/* 122 */           if (inputStreamFactory != null) {
/* 123 */             paramHttpResponse.setEntity((HttpEntity)new DecompressingEntity(paramHttpResponse.getEntity(), inputStreamFactory));
/* 124 */             paramHttpResponse.removeHeaders("Content-Length");
/* 125 */             paramHttpResponse.removeHeaders("Content-Encoding");
/* 126 */             paramHttpResponse.removeHeaders("Content-MD5");
/*     */           }
/* 128 */           else if (!"identity".equals(str) && !this.ignoreUnknown) {
/* 129 */             throw new HttpException("Unsupported Content-Encoding: " + headerElement.getName());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\ResponseContentEncoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */