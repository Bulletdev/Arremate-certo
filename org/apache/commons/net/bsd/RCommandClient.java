/*     */ package org.apache.commons.net.bsd;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.BindException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketException;
/*     */ import java.net.UnknownHostException;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import org.apache.commons.net.io.SocketInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RCommandClient
/*     */   extends RExecClient
/*     */ {
/*     */   public static final int DEFAULT_PORT = 514;
/*     */   public static final int MIN_CLIENT_PORT = 512;
/*     */   public static final int MAX_CLIENT_PORT = 1023;
/*     */   
/*     */   InputStream createErrorStream() throws IOException {
/* 116 */     char c = 'Ͽ';
/* 117 */     ServerSocket serverSocket = null;
/*     */     
/* 119 */     for (c = 'Ͽ'; c >= 'Ȁ'; c--) {
/*     */ 
/*     */       
/*     */       try {
/* 123 */         serverSocket = this._serverSocketFactory_.createServerSocket(c, 1, 
/* 124 */             getLocalAddress());
/*     */         
/*     */         break;
/* 127 */       } catch (SocketException socketException) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     if (serverSocket == null) {
/* 134 */       throw new BindException("All ports in use.");
/*     */     }
/*     */     
/* 137 */     this._output_.write(Integer.toString(serverSocket.getLocalPort()).getBytes(StandardCharsets.UTF_8));
/* 138 */     this._output_.write(0);
/* 139 */     this._output_.flush();
/*     */     
/* 141 */     Socket socket = serverSocket.accept();
/* 142 */     serverSocket.close();
/*     */     
/* 144 */     if (isRemoteVerificationEnabled() && !verifyRemote(socket)) {
/*     */       
/* 146 */       socket.close();
/* 147 */       throw new IOException("Security violation: unexpected connection attempt by " + socket
/*     */           
/* 149 */           .getInetAddress().getHostAddress());
/*     */     } 
/*     */     
/* 152 */     return (InputStream)new SocketInputStream(socket, socket.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RCommandClient() {
/* 161 */     setDefaultPort(514);
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
/*     */   public void connect(InetAddress paramInetAddress1, int paramInt, InetAddress paramInetAddress2) throws SocketException, BindException, IOException {
/* 186 */     char c = 'Ͽ';
/*     */     
/* 188 */     for (c = 'Ͽ'; c >= 'Ȁ'; c--) {
/*     */ 
/*     */       
/*     */       try {
/* 192 */         this
/* 193 */           ._socket_ = this._socketFactory_.createSocket(paramInetAddress1, paramInt, paramInetAddress2, c);
/*     */         break;
/* 195 */       } catch (SocketException socketException) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     if (c < 'Ȁ') {
/* 203 */       throw new BindException("All ports in use or insufficient permssion.");
/*     */     }
/*     */     
/* 206 */     _connectAction_();
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
/*     */   public void connect(InetAddress paramInetAddress, int paramInt) throws SocketException, IOException {
/* 230 */     connect(paramInetAddress, paramInt, InetAddress.getLocalHost());
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
/*     */   public void connect(String paramString, int paramInt) throws SocketException, IOException, UnknownHostException {
/* 254 */     connect(InetAddress.getByName(paramString), paramInt, InetAddress.getLocalHost());
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
/*     */   public void connect(String paramString, int paramInt, InetAddress paramInetAddress) throws SocketException, IOException {
/* 277 */     connect(InetAddress.getByName(paramString), paramInt, paramInetAddress);
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
/*     */ 
/*     */   
/*     */   public void connect(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws SocketException, IOException, IllegalArgumentException {
/* 306 */     if (paramInt2 < 512 || paramInt2 > 1023) {
/* 307 */       throw new IllegalArgumentException("Invalid port number " + paramInt2);
/*     */     }
/* 309 */     super.connect(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws SocketException, IOException, IllegalArgumentException, UnknownHostException {
/* 339 */     if (paramInt2 < 512 || paramInt2 > 1023) {
/* 340 */       throw new IllegalArgumentException("Invalid port number " + paramInt2);
/*     */     }
/* 342 */     super.connect(paramString, paramInt1, paramInetAddress, paramInt2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rcommand(String paramString1, String paramString2, String paramString3, boolean paramBoolean) throws IOException {
/* 386 */     rexec(paramString1, paramString2, paramString3, paramBoolean);
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
/*     */   public void rcommand(String paramString1, String paramString2, String paramString3) throws IOException {
/* 402 */     rcommand(paramString1, paramString2, paramString3, false);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\bsd\RCommandClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */