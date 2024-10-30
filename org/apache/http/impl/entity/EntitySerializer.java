/*     */ package org.apache.http.impl.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.entity.ContentLengthStrategy;
/*     */ import org.apache.http.impl.io.ChunkedOutputStream;
/*     */ import org.apache.http.impl.io.ContentLengthOutputStream;
/*     */ import org.apache.http.impl.io.IdentityOutputStream;
/*     */ import org.apache.http.io.SessionOutputBuffer;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class EntitySerializer
/*     */ {
/*     */   private final ContentLengthStrategy lenStrategy;
/*     */   
/*     */   public EntitySerializer(ContentLengthStrategy paramContentLengthStrategy) {
/*  70 */     this.lenStrategy = (ContentLengthStrategy)Args.notNull(paramContentLengthStrategy, "Content length strategy");
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
/*     */   protected OutputStream doSerialize(SessionOutputBuffer paramSessionOutputBuffer, HttpMessage paramHttpMessage) throws HttpException, IOException {
/*  90 */     long l = this.lenStrategy.determineLength(paramHttpMessage);
/*  91 */     if (l == -2L)
/*  92 */       return (OutputStream)new ChunkedOutputStream(paramSessionOutputBuffer); 
/*  93 */     if (l == -1L) {
/*  94 */       return (OutputStream)new IdentityOutputStream(paramSessionOutputBuffer);
/*     */     }
/*  96 */     return (OutputStream)new ContentLengthOutputStream(paramSessionOutputBuffer, l);
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
/*     */   public void serialize(SessionOutputBuffer paramSessionOutputBuffer, HttpMessage paramHttpMessage, HttpEntity paramHttpEntity) throws HttpException, IOException {
/* 114 */     Args.notNull(paramSessionOutputBuffer, "Session output buffer");
/* 115 */     Args.notNull(paramHttpMessage, "HTTP message");
/* 116 */     Args.notNull(paramHttpEntity, "HTTP entity");
/* 117 */     OutputStream outputStream = doSerialize(paramSessionOutputBuffer, paramHttpMessage);
/* 118 */     paramHttpEntity.writeTo(outputStream);
/* 119 */     outputStream.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\entity\EntitySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */