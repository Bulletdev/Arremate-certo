/*     */ package org.apache.http.conn.scheme;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.net.UnknownHostException;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.ConnectTimeoutException;
/*     */ import org.apache.http.params.HttpConnectionParams;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class PlainSocketFactory
/*     */   implements SchemeSocketFactory, SocketFactory
/*     */ {
/*     */   private final HostNameResolver nameResolver;
/*     */   
/*     */   public static PlainSocketFactory getSocketFactory() {
/*  63 */     return new PlainSocketFactory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PlainSocketFactory(HostNameResolver paramHostNameResolver) {
/*  72 */     this.nameResolver = paramHostNameResolver;
/*     */   }
/*     */ 
/*     */   
/*     */   public PlainSocketFactory() {
/*  77 */     this.nameResolver = null;
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
/*     */   public Socket createSocket(HttpParams paramHttpParams) {
/*  89 */     return new Socket();
/*     */   }
/*     */ 
/*     */   
/*     */   public Socket createSocket() {
/*  94 */     return new Socket();
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
/*     */   public Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpParams paramHttpParams) throws IOException, ConnectTimeoutException {
/* 106 */     Args.notNull(paramInetSocketAddress1, "Remote address");
/* 107 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 108 */     Socket socket = paramSocket;
/* 109 */     if (socket == null) {
/* 110 */       socket = createSocket();
/*     */     }
/* 112 */     if (paramInetSocketAddress2 != null) {
/* 113 */       socket.setReuseAddress(HttpConnectionParams.getSoReuseaddr(paramHttpParams));
/* 114 */       socket.bind(paramInetSocketAddress2);
/*     */     } 
/* 116 */     int i = HttpConnectionParams.getConnectionTimeout(paramHttpParams);
/* 117 */     int j = HttpConnectionParams.getSoTimeout(paramHttpParams);
/*     */     
/*     */     try {
/* 120 */       socket.setSoTimeout(j);
/* 121 */       socket.connect(paramInetSocketAddress1, i);
/* 122 */     } catch (SocketTimeoutException socketTimeoutException) {
/* 123 */       throw new ConnectTimeoutException("Connect to " + paramInetSocketAddress1 + " timed out");
/*     */     } 
/* 125 */     return socket;
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
/*     */   public final boolean isSecure(Socket paramSocket) {
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams) throws IOException, UnknownHostException, ConnectTimeoutException {
/*     */     InetAddress inetAddress;
/* 152 */     InetSocketAddress inetSocketAddress1 = null;
/* 153 */     if (paramInetAddress != null || paramInt2 > 0) {
/* 154 */       inetSocketAddress1 = new InetSocketAddress(paramInetAddress, (paramInt2 > 0) ? paramInt2 : 0);
/*     */     }
/*     */     
/* 157 */     if (this.nameResolver != null) {
/* 158 */       inetAddress = this.nameResolver.resolve(paramString);
/*     */     } else {
/* 160 */       inetAddress = InetAddress.getByName(paramString);
/*     */     } 
/* 162 */     InetSocketAddress inetSocketAddress2 = new InetSocketAddress(inetAddress, paramInt1);
/* 163 */     return connectSocket(paramSocket, inetSocketAddress2, inetSocketAddress1, paramHttpParams);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\scheme\PlainSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */