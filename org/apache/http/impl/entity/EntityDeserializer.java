/*     */ package org.apache.http.impl.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.entity.BasicHttpEntity;
/*     */ import org.apache.http.entity.ContentLengthStrategy;
/*     */ import org.apache.http.impl.io.ChunkedInputStream;
/*     */ import org.apache.http.impl.io.ContentLengthInputStream;
/*     */ import org.apache.http.impl.io.IdentityInputStream;
/*     */ import org.apache.http.io.SessionInputBuffer;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class EntityDeserializer
/*     */ {
/*     */   private final ContentLengthStrategy lenStrategy;
/*     */   
/*     */   public EntityDeserializer(ContentLengthStrategy paramContentLengthStrategy) {
/*  73 */     this.lenStrategy = (ContentLengthStrategy)Args.notNull(paramContentLengthStrategy, "Content length strategy");
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
/*     */   protected BasicHttpEntity doDeserialize(SessionInputBuffer paramSessionInputBuffer, HttpMessage paramHttpMessage) throws HttpException, IOException {
/*  94 */     BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
/*     */     
/*  96 */     long l = this.lenStrategy.determineLength(paramHttpMessage);
/*  97 */     if (l == -2L) {
/*  98 */       basicHttpEntity.setChunked(true);
/*  99 */       basicHttpEntity.setContentLength(-1L);
/* 100 */       basicHttpEntity.setContent((InputStream)new ChunkedInputStream(paramSessionInputBuffer));
/* 101 */     } else if (l == -1L) {
/* 102 */       basicHttpEntity.setChunked(false);
/* 103 */       basicHttpEntity.setContentLength(-1L);
/* 104 */       basicHttpEntity.setContent((InputStream)new IdentityInputStream(paramSessionInputBuffer));
/*     */     } else {
/* 106 */       basicHttpEntity.setChunked(false);
/* 107 */       basicHttpEntity.setContentLength(l);
/* 108 */       basicHttpEntity.setContent((InputStream)new ContentLengthInputStream(paramSessionInputBuffer, l));
/*     */     } 
/*     */     
/* 111 */     Header header1 = paramHttpMessage.getFirstHeader("Content-Type");
/* 112 */     if (header1 != null) {
/* 113 */       basicHttpEntity.setContentType(header1);
/*     */     }
/* 115 */     Header header2 = paramHttpMessage.getFirstHeader("Content-Encoding");
/* 116 */     if (header2 != null) {
/* 117 */       basicHttpEntity.setContentEncoding(header2);
/*     */     }
/* 119 */     return basicHttpEntity;
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
/*     */   public HttpEntity deserialize(SessionInputBuffer paramSessionInputBuffer, HttpMessage paramHttpMessage) throws HttpException, IOException {
/* 139 */     Args.notNull(paramSessionInputBuffer, "Session input buffer");
/* 140 */     Args.notNull(paramHttpMessage, "HTTP message");
/* 141 */     return (HttpEntity)doDeserialize(paramSessionInputBuffer, paramHttpMessage);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\entity\EntityDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */