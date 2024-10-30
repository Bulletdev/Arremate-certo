/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.Socket;
/*    */ import javax.net.ssl.HostnameVerifier;
/*    */ import javax.net.ssl.SSLContext;
/*    */ import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
/*    */ import org.apache.http.protocol.HttpContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class o
/*    */   extends SSLConnectionSocketFactory
/*    */ {
/*    */   public o(SSLContext paramSSLContext, HostnameVerifier paramHostnameVerifier) {
/* 18 */     super(paramSSLContext, paramHostnameVerifier);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, HttpContext paramHttpContext) throws IOException {
/* 28 */     return super.createLayeredSocket(paramSocket, "", paramInt, paramHttpContext);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */