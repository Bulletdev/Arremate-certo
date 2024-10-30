/*     */ package org.apache.commons.net.bsd;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import org.apache.commons.net.SocketClient;
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
/*     */ public class RExecClient
/*     */   extends SocketClient
/*     */ {
/*     */   protected static final char NULL_CHAR = '\000';
/*     */   public static final int DEFAULT_PORT = 512;
/*     */   private boolean remoteVerificationEnabled;
/*     */   protected InputStream _errorStream_;
/*     */   
/*     */   InputStream createErrorStream() throws IOException {
/*  95 */     ServerSocket serverSocket = this._serverSocketFactory_.createServerSocket(0, 1, getLocalAddress());
/*     */     
/*  97 */     this._output_.write(Integer.toString(serverSocket.getLocalPort()).getBytes(StandardCharsets.UTF_8));
/*  98 */     this._output_.write(0);
/*  99 */     this._output_.flush();
/*     */     
/* 101 */     Socket socket = serverSocket.accept();
/* 102 */     serverSocket.close();
/*     */     
/* 104 */     if (this.remoteVerificationEnabled && !verifyRemote(socket)) {
/*     */       
/* 106 */       socket.close();
/* 107 */       throw new IOException("Security violation: unexpected connection attempt by " + socket
/*     */           
/* 109 */           .getInetAddress().getHostAddress());
/*     */     } 
/*     */     
/* 112 */     return (InputStream)new SocketInputStream(socket, socket.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RExecClient() {
/* 122 */     this._errorStream_ = null;
/* 123 */     setDefaultPort(512);
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
/*     */   public InputStream getInputStream() {
/* 137 */     return this._input_;
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
/*     */   public OutputStream getOutputStream() {
/* 151 */     return this._output_;
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
/*     */   public InputStream getErrorStream() {
/* 167 */     return this._errorStream_;
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
/*     */   public void rexec(String paramString1, String paramString2, String paramString3, boolean paramBoolean) throws IOException {
/* 209 */     if (paramBoolean) {
/*     */       
/* 211 */       this._errorStream_ = createErrorStream();
/*     */     }
/*     */     else {
/*     */       
/* 215 */       this._output_.write(0);
/*     */     } 
/*     */     
/* 218 */     this._output_.write(paramString1.getBytes(getCharset()));
/* 219 */     this._output_.write(0);
/* 220 */     this._output_.write(paramString2.getBytes(getCharset()));
/* 221 */     this._output_.write(0);
/* 222 */     this._output_.write(paramString3.getBytes(getCharset()));
/* 223 */     this._output_.write(0);
/* 224 */     this._output_.flush();
/*     */     
/* 226 */     int i = this._input_.read();
/* 227 */     if (i > 0) {
/* 228 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/* 230 */       while ((i = this._input_.read()) != -1 && i != 10) {
/* 231 */         stringBuilder.append((char)i);
/*     */       }
/*     */       
/* 234 */       throw new IOException(stringBuilder.toString());
/* 235 */     }  if (i < 0) {
/* 236 */       throw new IOException("Server closed connection.");
/*     */     }
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
/*     */   public void rexec(String paramString1, String paramString2, String paramString3) throws IOException {
/* 252 */     rexec(paramString1, paramString2, paramString3, false);
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
/*     */   public void disconnect() throws IOException {
/* 264 */     if (this._errorStream_ != null) {
/* 265 */       this._errorStream_.close();
/*     */     }
/* 267 */     this._errorStream_ = null;
/* 268 */     super.disconnect();
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
/*     */   public final void setRemoteVerificationEnabled(boolean paramBoolean) {
/* 283 */     this.remoteVerificationEnabled = paramBoolean;
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
/*     */   public final boolean isRemoteVerificationEnabled() {
/* 295 */     return this.remoteVerificationEnabled;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\bsd\RExecClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */