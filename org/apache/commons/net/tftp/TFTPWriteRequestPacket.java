/*    */ package org.apache.commons.net.tftp;
/*    */ 
/*    */ import java.net.DatagramPacket;
/*    */ import java.net.InetAddress;
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
/*    */ public final class TFTPWriteRequestPacket
/*    */   extends TFTPRequestPacket
/*    */ {
/*    */   public TFTPWriteRequestPacket(InetAddress paramInetAddress, int paramInt1, String paramString, int paramInt2) {
/* 61 */     super(paramInetAddress, paramInt1, 2, paramString, paramInt2);
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
/*    */   TFTPWriteRequestPacket(DatagramPacket paramDatagramPacket) throws TFTPPacketException {
/* 76 */     super(2, paramDatagramPacket);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 85 */     return super.toString() + " WRQ " + getFilename() + " " + TFTP.getModeName(getMode());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\tftp\TFTPWriteRequestPacket.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */