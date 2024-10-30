/*    */ package ch.qos.logback.core.net;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.net.DatagramPacket;
/*    */ import java.net.DatagramSocket;
/*    */ import java.net.InetAddress;
/*    */ import java.net.SocketException;
/*    */ import java.net.UnknownHostException;
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
/*    */ public class SyslogOutputStream
/*    */   extends OutputStream
/*    */ {
/*    */   private static final int MAX_LEN = 1024;
/*    */   private InetAddress address;
/*    */   private DatagramSocket ds;
/* 39 */   private ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*    */   private final int port;
/*    */   
/*    */   public SyslogOutputStream(String paramString, int paramInt) throws UnknownHostException, SocketException {
/* 43 */     this.address = InetAddress.getByName(paramString);
/* 44 */     this.port = paramInt;
/* 45 */     this.ds = new DatagramSocket();
/*    */   }
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 49 */     this.baos.write(paramArrayOfbyte, paramInt1, paramInt2);
/*    */   }
/*    */   
/*    */   public void flush() throws IOException {
/* 53 */     byte[] arrayOfByte = this.baos.toByteArray();
/* 54 */     DatagramPacket datagramPacket = new DatagramPacket(arrayOfByte, arrayOfByte.length, this.address, this.port);
/*    */ 
/*    */     
/* 57 */     if (this.baos.size() > 1024) {
/* 58 */       this.baos = new ByteArrayOutputStream();
/*    */     } else {
/* 60 */       this.baos.reset();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 65 */     if (arrayOfByte.length == 0) {
/*    */       return;
/*    */     }
/* 68 */     if (this.ds != null) {
/* 69 */       this.ds.send(datagramPacket);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() {
/* 75 */     this.address = null;
/* 76 */     this.ds = null;
/*    */   }
/*    */   
/*    */   public int getPort() {
/* 80 */     return this.port;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int paramInt) throws IOException {
/* 85 */     this.baos.write(paramInt);
/*    */   }
/*    */   
/*    */   int getSendBufferSize() throws SocketException {
/* 89 */     return this.ds.getSendBufferSize();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\SyslogOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */