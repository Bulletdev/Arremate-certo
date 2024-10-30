/*     */ package org.apache.http.impl;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketAddress;
/*     */ import java.net.SocketException;
/*     */ import org.apache.http.HttpInetConnection;
/*     */ import org.apache.http.impl.io.SocketInputBuffer;
/*     */ import org.apache.http.impl.io.SocketOutputBuffer;
/*     */ import org.apache.http.io.SessionInputBuffer;
/*     */ import org.apache.http.io.SessionOutputBuffer;
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
/*     */ @Deprecated
/*     */ public class SocketHttpServerConnection
/*     */   extends AbstractHttpServerConnection
/*     */   implements HttpInetConnection
/*     */ {
/*     */   private volatile boolean open;
/*  55 */   private volatile Socket socket = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void assertNotOpen() {
/*  62 */     Asserts.check(!this.open, "Connection is already open");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void assertOpen() {
/*  67 */     Asserts.check(this.open, "Connection is not open");
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
/*     */   protected SessionInputBuffer createSessionInputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams) throws IOException {
/*  89 */     return (SessionInputBuffer)new SocketInputBuffer(paramSocket, paramInt, paramHttpParams);
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
/*     */   protected SessionOutputBuffer createSessionOutputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams) throws IOException {
/* 111 */     return (SessionOutputBuffer)new SocketOutputBuffer(paramSocket, paramInt, paramHttpParams);
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
/*     */   protected void bind(Socket paramSocket, HttpParams paramHttpParams) throws IOException {
/* 133 */     Args.notNull(paramSocket, "Socket");
/* 134 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 135 */     this.socket = paramSocket;
/*     */     
/* 137 */     int i = paramHttpParams.getIntParameter("http.socket.buffer-size", -1);
/* 138 */     init(createSessionInputBuffer(paramSocket, i, paramHttpParams), createSessionOutputBuffer(paramSocket, i, paramHttpParams), paramHttpParams);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     this.open = true;
/*     */   }
/*     */   
/*     */   protected Socket getSocket() {
/* 147 */     return this.socket;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpen() {
/* 152 */     return this.open;
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getLocalAddress() {
/* 157 */     if (this.socket != null) {
/* 158 */       return this.socket.getLocalAddress();
/*     */     }
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLocalPort() {
/* 165 */     if (this.socket != null) {
/* 166 */       return this.socket.getLocalPort();
/*     */     }
/* 168 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getRemoteAddress() {
/* 173 */     if (this.socket != null) {
/* 174 */       return this.socket.getInetAddress();
/*     */     }
/* 176 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRemotePort() {
/* 181 */     if (this.socket != null) {
/* 182 */       return this.socket.getPort();
/*     */     }
/* 184 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSocketTimeout(int paramInt) {
/* 189 */     assertOpen();
/* 190 */     if (this.socket != null) {
/*     */       try {
/* 192 */         this.socket.setSoTimeout(paramInt);
/* 193 */       } catch (SocketException socketException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSocketTimeout() {
/* 203 */     if (this.socket != null) {
/*     */       try {
/* 205 */         return this.socket.getSoTimeout();
/* 206 */       } catch (SocketException socketException) {}
/*     */     }
/*     */ 
/*     */     
/* 210 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() throws IOException {
/* 215 */     this.open = false;
/* 216 */     Socket socket = this.socket;
/* 217 */     if (socket != null) {
/* 218 */       socket.close();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 224 */     if (!this.open) {
/*     */       return;
/*     */     }
/* 227 */     this.open = false;
/* 228 */     this.open = false;
/* 229 */     Socket socket = this.socket;
/*     */     try {
/* 231 */       doFlush();
/*     */       try {
/*     */         try {
/* 234 */           socket.shutdownOutput();
/* 235 */         } catch (IOException iOException) {}
/*     */         
/*     */         try {
/* 238 */           socket.shutdownInput();
/* 239 */         } catch (IOException iOException) {}
/*     */       }
/* 241 */       catch (UnsupportedOperationException unsupportedOperationException) {}
/*     */     }
/*     */     finally {
/*     */       
/* 245 */       socket.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void formatAddress(StringBuilder paramStringBuilder, SocketAddress paramSocketAddress) {
/* 250 */     if (paramSocketAddress instanceof InetSocketAddress) {
/* 251 */       InetSocketAddress inetSocketAddress = (InetSocketAddress)paramSocketAddress;
/* 252 */       paramStringBuilder.append((inetSocketAddress.getAddress() != null) ? inetSocketAddress.getAddress().getHostAddress() : inetSocketAddress.getAddress()).append(':').append(inetSocketAddress.getPort());
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 257 */       paramStringBuilder.append(paramSocketAddress);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 263 */     if (this.socket != null) {
/* 264 */       StringBuilder stringBuilder = new StringBuilder();
/* 265 */       SocketAddress socketAddress1 = this.socket.getRemoteSocketAddress();
/* 266 */       SocketAddress socketAddress2 = this.socket.getLocalSocketAddress();
/* 267 */       if (socketAddress1 != null && socketAddress2 != null) {
/* 268 */         formatAddress(stringBuilder, socketAddress2);
/* 269 */         stringBuilder.append("<->");
/* 270 */         formatAddress(stringBuilder, socketAddress1);
/*     */       } 
/* 272 */       return stringBuilder.toString();
/*     */     } 
/* 274 */     return super.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\SocketHttpServerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */