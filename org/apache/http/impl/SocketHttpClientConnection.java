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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class SocketHttpClientConnection
/*     */   extends AbstractHttpClientConnection
/*     */   implements HttpInetConnection
/*     */ {
/*     */   private volatile boolean open;
/*  61 */   private volatile Socket socket = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void assertNotOpen() {
/*  68 */     Asserts.check(!this.open, "Connection is already open");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void assertOpen() {
/*  73 */     Asserts.check(this.open, "Connection is not open");
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
/*  95 */     return (SessionInputBuffer)new SocketInputBuffer(paramSocket, paramInt, paramHttpParams);
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
/* 117 */     return (SessionOutputBuffer)new SocketOutputBuffer(paramSocket, paramInt, paramHttpParams);
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
/*     */   protected void bind(Socket paramSocket, HttpParams paramHttpParams) throws IOException {
/* 141 */     Args.notNull(paramSocket, "Socket");
/* 142 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 143 */     this.socket = paramSocket;
/*     */     
/* 145 */     int i = paramHttpParams.getIntParameter("http.socket.buffer-size", -1);
/* 146 */     init(createSessionInputBuffer(paramSocket, i, paramHttpParams), createSessionOutputBuffer(paramSocket, i, paramHttpParams), paramHttpParams);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     this.open = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpen() {
/* 156 */     return this.open;
/*     */   }
/*     */   
/*     */   protected Socket getSocket() {
/* 160 */     return this.socket;
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getLocalAddress() {
/* 165 */     if (this.socket != null) {
/* 166 */       return this.socket.getLocalAddress();
/*     */     }
/* 168 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLocalPort() {
/* 173 */     if (this.socket != null) {
/* 174 */       return this.socket.getLocalPort();
/*     */     }
/* 176 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getRemoteAddress() {
/* 181 */     if (this.socket != null) {
/* 182 */       return this.socket.getInetAddress();
/*     */     }
/* 184 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRemotePort() {
/* 189 */     if (this.socket != null) {
/* 190 */       return this.socket.getPort();
/*     */     }
/* 192 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSocketTimeout(int paramInt) {
/* 197 */     assertOpen();
/* 198 */     if (this.socket != null) {
/*     */       try {
/* 200 */         this.socket.setSoTimeout(paramInt);
/* 201 */       } catch (SocketException socketException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSocketTimeout() {
/* 211 */     if (this.socket != null) {
/*     */       try {
/* 213 */         return this.socket.getSoTimeout();
/* 214 */       } catch (SocketException socketException) {}
/*     */     }
/*     */ 
/*     */     
/* 218 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() throws IOException {
/* 223 */     this.open = false;
/* 224 */     Socket socket = this.socket;
/* 225 */     if (socket != null) {
/* 226 */       socket.close();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 232 */     if (!this.open) {
/*     */       return;
/*     */     }
/* 235 */     this.open = false;
/* 236 */     Socket socket = this.socket;
/*     */     try {
/* 238 */       doFlush();
/*     */       try {
/*     */         try {
/* 241 */           socket.shutdownOutput();
/* 242 */         } catch (IOException iOException) {}
/*     */ 
/*     */         
/*     */         try {
/* 246 */           socket.shutdownInput();
/* 247 */         } catch (IOException iOException) {}
/*     */       
/*     */       }
/* 250 */       catch (UnsupportedOperationException unsupportedOperationException) {}
/*     */     }
/*     */     finally {
/*     */       
/* 254 */       socket.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void formatAddress(StringBuilder paramStringBuilder, SocketAddress paramSocketAddress) {
/* 259 */     if (paramSocketAddress instanceof InetSocketAddress) {
/* 260 */       InetSocketAddress inetSocketAddress = (InetSocketAddress)paramSocketAddress;
/* 261 */       paramStringBuilder.append((inetSocketAddress.getAddress() != null) ? inetSocketAddress.getAddress().getHostAddress() : inetSocketAddress.getAddress()).append(':').append(inetSocketAddress.getPort());
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 266 */       paramStringBuilder.append(paramSocketAddress);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 272 */     if (this.socket != null) {
/* 273 */       StringBuilder stringBuilder = new StringBuilder();
/* 274 */       SocketAddress socketAddress1 = this.socket.getRemoteSocketAddress();
/* 275 */       SocketAddress socketAddress2 = this.socket.getLocalSocketAddress();
/* 276 */       if (socketAddress1 != null && socketAddress2 != null) {
/* 277 */         formatAddress(stringBuilder, socketAddress2);
/* 278 */         stringBuilder.append("<->");
/* 279 */         formatAddress(stringBuilder, socketAddress1);
/*     */       } 
/* 281 */       return stringBuilder.toString();
/*     */     } 
/* 283 */     return super.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\SocketHttpClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */