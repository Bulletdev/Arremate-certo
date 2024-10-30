/*     */ package org.apache.http.client.utils;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.client.HttpClient;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HttpClientUtils
/*     */ {
/*     */   public static void closeQuietly(HttpResponse paramHttpResponse) {
/*  71 */     if (paramHttpResponse != null) {
/*  72 */       HttpEntity httpEntity = paramHttpResponse.getEntity();
/*  73 */       if (httpEntity != null) {
/*     */         try {
/*  75 */           EntityUtils.consume(httpEntity);
/*  76 */         } catch (IOException iOException) {}
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void closeQuietly(CloseableHttpResponse paramCloseableHttpResponse) {
/* 105 */     if (paramCloseableHttpResponse != null) {
/*     */       try {
/*     */         try {
/* 108 */           EntityUtils.consume(paramCloseableHttpResponse.getEntity());
/*     */         } finally {
/* 110 */           paramCloseableHttpResponse.close();
/*     */         } 
/* 112 */       } catch (IOException iOException) {}
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void closeQuietly(HttpClient paramHttpClient) {
/* 139 */     if (paramHttpClient != null && 
/* 140 */       paramHttpClient instanceof Closeable)
/*     */       try {
/* 142 */         ((Closeable)paramHttpClient).close();
/* 143 */       } catch (IOException iOException) {} 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\clien\\utils\HttpClientUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */