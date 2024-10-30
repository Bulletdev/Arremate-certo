/*    */ package ch.qos.logback.classic.pattern;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ClassPackagingData;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class Util
/*    */ {
/* 29 */   static Map<String, ClassPackagingData> cache = new HashMap<String, ClassPackagingData>();
/*    */   
/*    */   public static boolean match(Marker paramMarker, Marker[] paramArrayOfMarker) {
/* 32 */     if (paramArrayOfMarker == null) {
/* 33 */       throw new IllegalArgumentException("markerArray should not be null");
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 38 */     int i = paramArrayOfMarker.length;
/* 39 */     for (byte b = 0; b < i; b++) {
/*    */ 
/*    */       
/* 42 */       if (paramMarker.contains(paramArrayOfMarker[b])) {
/* 43 */         return true;
/*    */       }
/*    */     } 
/* 46 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */