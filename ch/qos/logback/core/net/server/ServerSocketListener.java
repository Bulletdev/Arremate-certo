/*    */ package ch.qos.logback.core.net.server;
/*    */ 
/*    */ import ch.qos.logback.core.util.CloseUtil;
/*    */ import java.io.IOException;
/*    */ import java.net.ServerSocket;
/*    */ import java.net.Socket;
/*    */ import java.net.SocketAddress;
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
/*    */ public abstract class ServerSocketListener<T extends Client>
/*    */   implements ServerListener<T>
/*    */ {
/*    */   private final ServerSocket serverSocket;
/*    */   
/*    */   public ServerSocketListener(ServerSocket paramServerSocket) {
/* 37 */     this.serverSocket = paramServerSocket;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T acceptClient() throws IOException {
/* 44 */     Socket socket = this.serverSocket.accept();
/* 45 */     return createClient(socketAddressToString(socket.getRemoteSocketAddress()), socket);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract T createClient(String paramString, Socket paramSocket) throws IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() {
/* 61 */     CloseUtil.closeQuietly(this.serverSocket);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 69 */     return socketAddressToString(this.serverSocket.getLocalSocketAddress());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String socketAddressToString(SocketAddress paramSocketAddress) {
/* 78 */     String str = paramSocketAddress.toString();
/* 79 */     int i = str.indexOf("/");
/* 80 */     if (i >= 0) {
/* 81 */       str = str.substring(i + 1);
/*    */     }
/* 83 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\server\ServerSocketListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */