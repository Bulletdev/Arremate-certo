/*    */ package org.apache.commons.net.ftp;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.InetAddress;
/*    */ import java.net.ServerSocket;
/*    */ import javax.net.ServerSocketFactory;
/*    */ import javax.net.ssl.SSLContext;
/*    */ import javax.net.ssl.SSLServerSocket;
/*    */ import javax.net.ssl.SSLServerSocketFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FTPSServerSocketFactory
/*    */   extends ServerSocketFactory
/*    */ {
/*    */   private final SSLContext sslContext;
/*    */   
/*    */   public FTPSServerSocketFactory(SSLContext paramSSLContext) {
/* 45 */     this.sslContext = paramSSLContext;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ServerSocket createServerSocket() throws IOException {
/* 51 */     return init(getServerSocketFactory().createServerSocket());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ServerSocket createServerSocket(int paramInt) throws IOException {
/* 57 */     return init(getServerSocketFactory().createServerSocket(paramInt));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ServerSocket createServerSocket(int paramInt1, int paramInt2) throws IOException {
/* 63 */     return init(getServerSocketFactory().createServerSocket(paramInt1, paramInt2));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ServerSocket createServerSocket(int paramInt1, int paramInt2, InetAddress paramInetAddress) throws IOException {
/* 70 */     return init(getServerSocketFactory().createServerSocket(paramInt1, paramInt2, paramInetAddress));
/*    */   }
/*    */   
/*    */   private SSLServerSocketFactory getServerSocketFactory() {
/* 74 */     return this.sslContext.getServerSocketFactory();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ServerSocket init(ServerSocket paramServerSocket) {
/* 85 */     ((SSLServerSocket)paramServerSocket).setUseClientMode(true);
/* 86 */     return paramServerSocket;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTPSServerSocketFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */