/*    */ package org.apache.poi.sl.usermodel;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ 
/*    */ public interface PaintStyle
/*    */ {
/*    */   public static interface TexturePaint
/*    */     extends PaintStyle
/*    */   {
/*    */     InputStream getImageData();
/*    */     
/*    */     String getContentType();
/*    */     
/*    */     int getAlpha();
/*    */   }
/*    */   
/*    */   public static interface GradientPaint
/*    */     extends PaintStyle
/*    */   {
/*    */     double getGradientAngle();
/*    */     
/*    */     ColorStyle[] getGradientColors();
/*    */     
/*    */     float[] getGradientFractions();
/*    */     
/*    */     boolean isRotatedWithShape();
/*    */     
/*    */     GradientType getGradientType();
/*    */     
/*    */     public enum GradientType {
/* 31 */       linear, circular, shape;
/*    */     }
/*    */   }
/*    */   
/*    */   public static interface SolidPaint extends PaintStyle {
/*    */     ColorStyle getSolidColor();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\PaintStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */