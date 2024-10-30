/*    */ package org.slf4j.helpers;
/*    */ 
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import java.util.concurrent.ConcurrentMap;
/*    */ import org.slf4j.IMarkerFactory;
/*    */ import org.slf4j.Marker;
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
/*    */ public class BasicMarkerFactory
/*    */   implements IMarkerFactory
/*    */ {
/* 44 */   private final ConcurrentMap<String, Marker> markerMap = new ConcurrentHashMap<String, Marker>();
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
/*    */   public Marker getMarker(String paramString) {
/* 63 */     if (paramString == null) {
/* 64 */       throw new IllegalArgumentException("Marker name cannot be null");
/*    */     }
/*    */     
/* 67 */     Marker marker = this.markerMap.get(paramString);
/* 68 */     if (marker == null) {
/* 69 */       marker = new BasicMarker(paramString);
/* 70 */       Marker marker1 = this.markerMap.putIfAbsent(paramString, marker);
/* 71 */       if (marker1 != null) {
/* 72 */         marker = marker1;
/*    */       }
/*    */     } 
/* 75 */     return marker;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean exists(String paramString) {
/* 82 */     if (paramString == null) {
/* 83 */       return false;
/*    */     }
/* 85 */     return this.markerMap.containsKey(paramString);
/*    */   }
/*    */   
/*    */   public boolean detachMarker(String paramString) {
/* 89 */     if (paramString == null) {
/* 90 */       return false;
/*    */     }
/* 92 */     return (this.markerMap.remove(paramString) != null);
/*    */   }
/*    */   
/*    */   public Marker getDetachedMarker(String paramString) {
/* 96 */     return new BasicMarker(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\helpers\BasicMarkerFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */