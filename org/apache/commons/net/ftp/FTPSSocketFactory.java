/*     */ package org.apache.commons.net.ftp;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
/*     */ import javax.net.SocketFactory;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.SSLServerSocket;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FTPSSocketFactory
/*     */   extends SocketFactory
/*     */ {
/*     */   private final SSLContext context;
/*     */   
/*     */   public FTPSSocketFactory(SSLContext paramSSLContext) {
/*  39 */     this.context = paramSSLContext;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket createSocket() throws IOException {
/*  45 */     return this.context.getSocketFactory().createSocket();
/*     */   }
/*     */ 
/*     */   
/*     */   public Socket createSocket(String paramString, int paramInt) throws UnknownHostException, IOException {
/*  50 */     return this.context.getSocketFactory().createSocket(paramString, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
/*  55 */     return this.context.getSocketFactory().createSocket(paramInetAddress, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws UnknownHostException, IOException {
/*  61 */     return this.context.getSocketFactory().createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
/*  67 */     return this.context.getSocketFactory().createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ServerSocket createServerSocket(int paramInt) throws IOException {
/*  78 */     return init(this.context.getServerSocketFactory().createServerSocket(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ServerSocket createServerSocket(int paramInt1, int paramInt2) throws IOException {
/*  88 */     return init(this.context.getServerSocketFactory().createServerSocket(paramInt1, paramInt2));
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
/*     */   public ServerSocket createServerSocket(int paramInt1, int paramInt2, InetAddress paramInetAddress) throws IOException {
/* 100 */     return init(this.context.getServerSocketFactory().createServerSocket(paramInt1, paramInt2, paramInetAddress));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ServerSocket init(ServerSocket paramServerSocket) throws IOException {
/* 109 */     ((SSLServerSocket)paramServerSocket).setUseClientMode(true);
/* 110 */     return paramServerSocket;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTPSSocketFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */