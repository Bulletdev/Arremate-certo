/*    */ package org.apache.poi.sl.draw;
/*    */ 
/*    */ import java.awt.Graphics2D;
/*    */ import org.apache.poi.sl.usermodel.GraphicalFrame;
/*    */ import org.apache.poi.sl.usermodel.PictureShape;
/*    */ import org.apache.poi.sl.usermodel.Shape;
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
/*    */ public class DrawGraphicalFrame
/*    */   extends DrawShape
/*    */ {
/*    */   public DrawGraphicalFrame(GraphicalFrame<?, ?> paramGraphicalFrame) {
/* 29 */     super((Shape<?, ?>)paramGraphicalFrame);
/*    */   }
/*    */   
/*    */   public void draw(Graphics2D paramGraphics2D) {
/* 33 */     PictureShape<?, ?> pictureShape = ((GraphicalFrame)getShape()).getFallbackPicture();
/* 34 */     if (pictureShape == null) {
/*    */       return;
/*    */     }
/* 37 */     DrawPictureShape drawPictureShape = DrawFactory.getInstance(paramGraphics2D).getDrawable(pictureShape);
/* 38 */     drawPictureShape.draw(paramGraphics2D);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawGraphicalFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */