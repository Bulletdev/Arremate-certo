/*    */ package org.apache.http.conn.routing;
/*    */ 
/*    */ import java.net.InetAddress;
/*    */ import org.apache.http.HttpHost;
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
/*    */ public interface RouteInfo
/*    */ {
/*    */   HttpHost getTargetHost();
/*    */   
/*    */   InetAddress getLocalAddress();
/*    */   
/*    */   int getHopCount();
/*    */   
/*    */   HttpHost getHopTarget(int paramInt);
/*    */   
/*    */   HttpHost getProxyHost();
/*    */   
/*    */   TunnelType getTunnelType();
/*    */   
/*    */   boolean isTunnelled();
/*    */   
/*    */   LayerType getLayerType();
/*    */   
/*    */   boolean isLayered();
/*    */   
/*    */   boolean isSecure();
/*    */   
/*    */   public enum TunnelType
/*    */   {
/* 49 */     PLAIN, TUNNELLED;
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
/*    */   public enum LayerType
/*    */   {
/* 65 */     PLAIN, LAYERED;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\routing\RouteInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */