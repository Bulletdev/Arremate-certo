/*    */ package org.apache.commons.net;
/*    */ 
/*    */ import java.net.DatagramSocket;
/*    */ import java.net.InetAddress;
/*    */ import java.net.SocketException;
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
/*    */ 
/*    */ public class DefaultDatagramSocketFactory
/*    */   implements DatagramSocketFactory
/*    */ {
/*    */   public DatagramSocket createDatagramSocket() throws SocketException {
/* 48 */     return new DatagramSocket();
/*    */   }
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
/*    */   public DatagramSocket createDatagramSocket(int paramInt) throws SocketException {
/* 61 */     return new DatagramSocket(paramInt);
/*    */   }
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
/*    */   public DatagramSocket createDatagramSocket(int paramInt, InetAddress paramInetAddress) throws SocketException {
/* 77 */     return new DatagramSocket(paramInt, paramInetAddress);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\DefaultDatagramSocketFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */