/*    */ package org.apache.http.params;
/*    */ 
/*    */ import java.nio.charset.Charset;
/*    */ import java.nio.charset.CodingErrorAction;
/*    */ import org.apache.http.config.ConnectionConfig;
/*    */ import org.apache.http.config.MessageConstraints;
/*    */ import org.apache.http.config.SocketConfig;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public final class HttpParamConfig
/*    */ {
/*    */   public static SocketConfig getSocketConfig(HttpParams paramHttpParams) {
/* 49 */     return SocketConfig.custom().setSoTimeout(paramHttpParams.getIntParameter("http.socket.timeout", 0)).setSoReuseAddress(paramHttpParams.getBooleanParameter("http.socket.reuseaddr", false)).setSoKeepAlive(paramHttpParams.getBooleanParameter("http.socket.keepalive", false)).setSoLinger(paramHttpParams.getIntParameter("http.socket.linger", -1)).setTcpNoDelay(paramHttpParams.getBooleanParameter("http.tcp.nodelay", true)).build();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static MessageConstraints getMessageConstraints(HttpParams paramHttpParams) {
/* 59 */     return MessageConstraints.custom().setMaxHeaderCount(paramHttpParams.getIntParameter("http.connection.max-header-count", -1)).setMaxLineLength(paramHttpParams.getIntParameter("http.connection.max-line-length", -1)).build();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ConnectionConfig getConnectionConfig(HttpParams paramHttpParams) {
/* 66 */     MessageConstraints messageConstraints = getMessageConstraints(paramHttpParams);
/* 67 */     String str = (String)paramHttpParams.getParameter("http.protocol.element-charset");
/* 68 */     return ConnectionConfig.custom().setCharset((str != null) ? Charset.forName(str) : null).setMalformedInputAction((CodingErrorAction)paramHttpParams.getParameter("http.malformed.input.action")).setMalformedInputAction((CodingErrorAction)paramHttpParams.getParameter("http.unmappable.input.action")).setMessageConstraints(messageConstraints).build();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\params\HttpParamConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */