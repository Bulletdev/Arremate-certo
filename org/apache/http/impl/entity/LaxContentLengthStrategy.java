/*     */ package org.apache.http.impl.entity;
/*     */ 
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.ParseException;
/*     */ import org.apache.http.ProtocolException;
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
/*     */ public class LaxContentLengthStrategy
/*     */   implements ContentLengthStrategy
/*     */ {
/*  54 */   public static final LaxContentLengthStrategy INSTANCE = new LaxContentLengthStrategy();
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
/*     */   public LaxContentLengthStrategy(int paramInt) {
/*  68 */     this.implicitLen = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LaxContentLengthStrategy() {
/*  76 */     this(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   public long determineLength(HttpMessage paramHttpMessage) throws HttpException {
/*  81 */     Args.notNull(paramHttpMessage, "HTTP message");
/*     */     
/*  83 */     Header header1 = paramHttpMessage.getFirstHeader("Transfer-Encoding");
/*     */ 
/*     */     
/*  86 */     if (header1 != null) {
/*     */       HeaderElement[] arrayOfHeaderElement;
/*     */       try {
/*  89 */         arrayOfHeaderElement = header1.getElements();
/*  90 */       } catch (ParseException parseException) {
/*  91 */         throw new ProtocolException("Invalid Transfer-Encoding header value: " + header1, parseException);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  96 */       int i = arrayOfHeaderElement.length;
/*  97 */       if ("identity".equalsIgnoreCase(header1.getValue()))
/*  98 */         return -1L; 
/*  99 */       if (i > 0 && "chunked".equalsIgnoreCase(arrayOfHeaderElement[i - 1].getName()))
/*     */       {
/* 101 */         return -2L;
/*     */       }
/* 103 */       return -1L;
/*     */     } 
/*     */     
/* 106 */     Header header2 = paramHttpMessage.getFirstHeader("Content-Length");
/* 107 */     if (header2 != null) {
/* 108 */       long l = -1L;
/* 109 */       Header[] arrayOfHeader = paramHttpMessage.getHeaders("Content-Length");
/* 110 */       for (int i = arrayOfHeader.length - 1; i >= 0; i--) {
/* 111 */         Header header = arrayOfHeader[i];
/*     */         try {
/* 113 */           l = Long.parseLong(header.getValue());
/*     */           break;
/* 115 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */ 
/*     */       
/* 119 */       return (l >= 0L) ? l : -1L;
/*     */     } 
/* 121 */     return this.implicitLen;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\entity\LaxContentLengthStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */