/*     */ package org.apache.http.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.scheme.SocketFactory;
/*     */ import org.apache.http.params.HttpConnectionParams;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class MultihomePlainSocketFactory
/*     */   implements SocketFactory
/*     */ {
/*  68 */   private static final MultihomePlainSocketFactory DEFAULT_FACTORY = new MultihomePlainSocketFactory();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MultihomePlainSocketFactory getSocketFactory() {
/*  75 */     return DEFAULT_FACTORY;
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
/*     */   public Socket createSocket() {
/*  89 */     return new Socket();
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
/*     */   public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams) throws IOException {
/* 112 */     Args.notNull(paramString, "Target host");
/* 113 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*     */     
/* 115 */     Socket socket = paramSocket;
/* 116 */     if (socket == null) {
/* 117 */       socket = createSocket();
/*     */     }
/*     */     
/* 120 */     if (paramInetAddress != null || paramInt2 > 0) {
/* 121 */       InetSocketAddress inetSocketAddress = new InetSocketAddress(paramInetAddress, (paramInt2 > 0) ? paramInt2 : 0);
/*     */       
/* 123 */       socket.bind(inetSocketAddress);
/*     */     } 
/*     */     
/* 126 */     int i = HttpConnectionParams.getConnectionTimeout(paramHttpParams);
/*     */     
/* 128 */     InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(paramString);
/* 129 */     ArrayList<?> arrayList = new ArrayList(arrayOfInetAddress.length);
/* 130 */     arrayList.addAll(Arrays.asList(arrayOfInetAddress));
/* 131 */     Collections.shuffle(arrayList);
/*     */     
/* 133 */     IOException iOException = null;
/* 134 */     for (InetAddress inetAddress : arrayList) {
/*     */       try {
/* 136 */         socket.connect(new InetSocketAddress(inetAddress, paramInt1), i);
/*     */         break;
/* 138 */       } catch (SocketTimeoutException socketTimeoutException) {
/* 139 */         throw new ConnectTimeoutException("Connect to " + inetAddress + " timed out");
/* 140 */       } catch (IOException iOException1) {
/*     */         
/* 142 */         socket = new Socket();
/*     */         
/* 144 */         iOException = iOException1;
/*     */       } 
/*     */     } 
/* 147 */     if (iOException != null) {
/* 148 */       throw iOException;
/*     */     }
/* 150 */     return socket;
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
/*     */   public boolean isSecure(Socket paramSocket) throws IllegalArgumentException {
/* 169 */     Args.notNull(paramSocket, "Socket");
/*     */ 
/*     */     
/* 172 */     Asserts.check(!paramSocket.isClosed(), "Socket is closed");
/* 173 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\MultihomePlainSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */