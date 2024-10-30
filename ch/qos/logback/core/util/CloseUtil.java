/*    */ package ch.qos.logback.core.util;
/*    */ 
/*    */ import java.io.Closeable;
/*    */ import java.io.IOException;
/*    */ import java.net.ServerSocket;
/*    */ import java.net.Socket;
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
/*    */ public class CloseUtil
/*    */ {
/*    */   public static void closeQuietly(Closeable paramCloseable) {
/* 33 */     if (paramCloseable == null)
/*    */       return; 
/*    */     try {
/* 36 */       paramCloseable.close();
/* 37 */     } catch (IOException iOException) {}
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void closeQuietly(Socket paramSocket) {
/* 47 */     if (paramSocket == null)
/*    */       return; 
/*    */     try {
/* 50 */       paramSocket.close();
/* 51 */     } catch (IOException iOException) {}
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void closeQuietly(ServerSocket paramServerSocket) {
/* 62 */     if (paramServerSocket == null)
/*    */       return; 
/*    */     try {
/* 65 */       paramServerSocket.close();
/* 66 */     } catch (IOException iOException) {}
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\CloseUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */