/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import java.net.Socket;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import javax.net.ssl.SSLSession;
/*     */ import javax.net.ssl.SSLSocket;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.config.MessageConstraints;
/*     */ import org.apache.http.conn.ManagedHttpClientConnection;
/*     */ import org.apache.http.entity.ContentLengthStrategy;
/*     */ import org.apache.http.impl.DefaultBHttpClientConnection;
/*     */ import org.apache.http.io.HttpMessageParserFactory;
/*     */ import org.apache.http.io.HttpMessageWriterFactory;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultManagedHttpClientConnection
/*     */   extends DefaultBHttpClientConnection
/*     */   implements ManagedHttpClientConnection, HttpContext
/*     */ {
/*     */   private final String id;
/*     */   private final Map<String, Object> attributes;
/*     */   private volatile boolean shutdown;
/*     */   
/*     */   public DefaultManagedHttpClientConnection(String paramString, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, MessageConstraints paramMessageConstraints, ContentLengthStrategy paramContentLengthStrategy1, ContentLengthStrategy paramContentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> paramHttpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> paramHttpMessageParserFactory) {
/*  74 */     super(paramInt1, paramInt2, paramCharsetDecoder, paramCharsetEncoder, paramMessageConstraints, paramContentLengthStrategy1, paramContentLengthStrategy2, paramHttpMessageWriterFactory, paramHttpMessageParserFactory);
/*     */ 
/*     */     
/*  77 */     this.id = paramString;
/*  78 */     this.attributes = new ConcurrentHashMap<String, Object>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultManagedHttpClientConnection(String paramString, int paramInt) {
/*  84 */     this(paramString, paramInt, paramInt, null, null, null, null, null, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getId() {
/*  89 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() throws IOException {
/*  94 */     this.shutdown = true;
/*  95 */     super.shutdown();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getAttribute(String paramString) {
/* 100 */     return this.attributes.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object removeAttribute(String paramString) {
/* 105 */     return this.attributes.remove(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttribute(String paramString, Object paramObject) {
/* 110 */     this.attributes.put(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bind(Socket paramSocket) throws IOException {
/* 115 */     if (this.shutdown) {
/* 116 */       paramSocket.close();
/*     */       
/* 118 */       throw new InterruptedIOException("Connection already shutdown");
/*     */     } 
/* 120 */     super.bind(paramSocket);
/*     */   }
/*     */ 
/*     */   
/*     */   public Socket getSocket() {
/* 125 */     return super.getSocket();
/*     */   }
/*     */ 
/*     */   
/*     */   public SSLSession getSSLSession() {
/* 130 */     Socket socket = super.getSocket();
/* 131 */     return (socket instanceof SSLSocket) ? ((SSLSocket)socket).getSession() : null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\DefaultManagedHttpClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */