/*    */ package org.apache.http.util;
/*    */ 
/*    */ import java.net.InetAddress;
/*    */ import java.net.InetSocketAddress;
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
/*    */ public final class NetUtils
/*    */ {
/*    */   public static void formatAddress(StringBuilder paramStringBuilder, SocketAddress paramSocketAddress) {
/* 42 */     Args.notNull(paramStringBuilder, "Buffer");
/* 43 */     Args.notNull(paramSocketAddress, "Socket address");
/* 44 */     if (paramSocketAddress instanceof InetSocketAddress) {
/* 45 */       InetSocketAddress inetSocketAddress = (InetSocketAddress)paramSocketAddress;
/* 46 */       InetAddress inetAddress = inetSocketAddress.getAddress();
/* 47 */       paramStringBuilder.append((inetAddress != null) ? inetAddress.getHostAddress() : inetAddress).append(':').append(inetSocketAddress.getPort());
/*    */     } else {
/*    */       
/* 50 */       paramStringBuilder.append(paramSocketAddress);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\NetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */