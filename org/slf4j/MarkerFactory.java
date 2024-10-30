/*     */ package org.slf4j;
/*     */ 
/*     */ import org.slf4j.helpers.BasicMarkerFactory;
/*     */ import org.slf4j.helpers.Util;
/*     */ import org.slf4j.impl.StaticMarkerBinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MarkerFactory
/*     */ {
/*     */   static IMarkerFactory MARKER_FACTORY;
/*     */   
/*     */   private static IMarkerFactory bwCompatibleGetMarkerFactoryFromBinder() throws NoClassDefFoundError {
/*     */     try {
/*  61 */       return StaticMarkerBinder.getSingleton().getMarkerFactory();
/*  62 */     } catch (NoSuchMethodError noSuchMethodError) {
/*     */       
/*  64 */       return StaticMarkerBinder.SINGLETON.getMarkerFactory();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/*  71 */       MARKER_FACTORY = bwCompatibleGetMarkerFactoryFromBinder();
/*  72 */     } catch (NoClassDefFoundError noClassDefFoundError) {
/*  73 */       MARKER_FACTORY = (IMarkerFactory)new BasicMarkerFactory();
/*  74 */     } catch (Exception exception) {
/*     */       
/*  76 */       Util.report("Unexpected failure while binding MarkerFactory", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Marker getMarker(String paramString) {
/*  89 */     return MARKER_FACTORY.getMarker(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Marker getDetachedMarker(String paramString) {
/* 100 */     return MARKER_FACTORY.getDetachedMarker(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IMarkerFactory getIMarkerFactory() {
/* 112 */     return MARKER_FACTORY;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\MarkerFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */