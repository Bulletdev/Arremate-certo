/*     */ package org.apache.commons.net;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Proxy;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
/*     */ import javax.net.SocketFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultSocketFactory
/*     */   extends SocketFactory
/*     */ {
/*     */   private final Proxy connProxy;
/*     */   
/*     */   public DefaultSocketFactory() {
/*  53 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultSocketFactory(Proxy paramProxy) {
/*  64 */     this.connProxy = paramProxy;
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
/*     */   public Socket createSocket() throws IOException {
/*  77 */     if (this.connProxy != null)
/*     */     {
/*  79 */       return new Socket(this.connProxy);
/*     */     }
/*  81 */     return new Socket();
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
/*     */   public Socket createSocket(String paramString, int paramInt) throws UnknownHostException, IOException {
/*  97 */     if (this.connProxy != null) {
/*     */       
/*  99 */       Socket socket = new Socket(this.connProxy);
/* 100 */       socket.connect(new InetSocketAddress(paramString, paramInt));
/* 101 */       return socket;
/*     */     } 
/* 103 */     return new Socket(paramString, paramInt);
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
/*     */   public Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
/* 118 */     if (this.connProxy != null) {
/*     */       
/* 120 */       Socket socket = new Socket(this.connProxy);
/* 121 */       socket.connect(new InetSocketAddress(paramInetAddress, paramInt));
/* 122 */       return socket;
/*     */     } 
/* 124 */     return new Socket(paramInetAddress, paramInt);
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
/*     */   public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws UnknownHostException, IOException {
/* 144 */     if (this.connProxy != null) {
/*     */       
/* 146 */       Socket socket = new Socket(this.connProxy);
/* 147 */       socket.bind(new InetSocketAddress(paramInetAddress, paramInt2));
/* 148 */       socket.connect(new InetSocketAddress(paramString, paramInt1));
/* 149 */       return socket;
/*     */     } 
/* 151 */     return new Socket(paramString, paramInt1, paramInetAddress, paramInt2);
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
/*     */   public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
/* 170 */     if (this.connProxy != null) {
/*     */       
/* 172 */       Socket socket = new Socket(this.connProxy);
/* 173 */       socket.bind(new InetSocketAddress(paramInetAddress2, paramInt2));
/* 174 */       socket.connect(new InetSocketAddress(paramInetAddress1, paramInt1));
/* 175 */       return socket;
/*     */     } 
/* 177 */     return new Socket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
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
/*     */   public ServerSocket createServerSocket(int paramInt) throws IOException {
/* 191 */     return new ServerSocket(paramInt);
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
/*     */   public ServerSocket createServerSocket(int paramInt1, int paramInt2) throws IOException {
/* 208 */     return new ServerSocket(paramInt1, paramInt2);
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
/*     */   public ServerSocket createServerSocket(int paramInt1, int paramInt2, InetAddress paramInetAddress) throws IOException {
/* 228 */     return new ServerSocket(paramInt1, paramInt2, paramInetAddress);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\DefaultSocketFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */