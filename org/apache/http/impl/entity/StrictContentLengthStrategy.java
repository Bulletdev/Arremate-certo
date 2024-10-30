/*     */ package org.apache.http.impl.entity;
/*     */ 
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ProtocolException;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.entity.ContentLengthStrategy;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class StrictContentLengthStrategy
/*     */   implements ContentLengthStrategy
/*     */ {
/*  54 */   public static final StrictContentLengthStrategy INSTANCE = new StrictContentLengthStrategy();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int implicitLen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StrictContentLengthStrategy(int paramInt) {
/*  68 */     this.implicitLen = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StrictContentLengthStrategy() {
/*  76 */     this(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   public long determineLength(HttpMessage paramHttpMessage) throws HttpException {
/*  81 */     Args.notNull(paramHttpMessage, "HTTP message");
/*     */ 
/*     */ 
/*     */     
/*  85 */     Header header1 = paramHttpMessage.getFirstHeader("Transfer-Encoding");
/*  86 */     if (header1 != null) {
/*  87 */       String str = header1.getValue();
/*  88 */       if ("chunked".equalsIgnoreCase(str)) {
/*  89 */         if (paramHttpMessage.getProtocolVersion().lessEquals((ProtocolVersion)HttpVersion.HTTP_1_0)) {
/*  90 */           throw new ProtocolException("Chunked transfer encoding not allowed for " + paramHttpMessage.getProtocolVersion());
/*     */         }
/*     */ 
/*     */         
/*  94 */         return -2L;
/*  95 */       }  if ("identity".equalsIgnoreCase(str)) {
/*  96 */         return -1L;
/*     */       }
/*  98 */       throw new ProtocolException("Unsupported transfer encoding: " + str);
/*     */     } 
/*     */ 
/*     */     
/* 102 */     Header header2 = paramHttpMessage.getFirstHeader("Content-Length");
/* 103 */     if (header2 != null) {
/* 104 */       String str = header2.getValue();
/*     */       try {
/* 106 */         long l = Long.parseLong(str);
/* 107 */         if (l < 0L) {
/* 108 */           throw new ProtocolException("Negative content length: " + str);
/*     */         }
/* 110 */         return l;
/* 111 */       } catch (NumberFormatException numberFormatException) {
/* 112 */         throw new ProtocolException("Invalid content length: " + str);
/*     */       } 
/*     */     } 
/* 115 */     return this.implicitLen;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\entity\StrictContentLengthStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */