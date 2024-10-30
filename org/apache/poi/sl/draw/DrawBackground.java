/*    */ package org.apache.poi.sl.draw;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Paint;
/*    */ import java.awt.geom.Rectangle2D;
/*    */ import org.apache.poi.sl.usermodel.Background;
/*    */ import org.apache.poi.sl.usermodel.PlaceableShape;
/*    */ import org.apache.poi.sl.usermodel.Shape;
/*    */ import org.apache.poi.sl.usermodel.ShapeContainer;
/*    */ import org.apache.poi.sl.usermodel.Sheet;
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
/*    */ public class DrawBackground
/*    */   extends DrawShape
/*    */ {
/*    */   public DrawBackground(Background<?, ?> paramBackground) {
/* 33 */     super((Shape<?, ?>)paramBackground);
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(Graphics2D paramGraphics2D) {
/* 38 */     Dimension dimension = this.shape.getSheet().getSlideShow().getPageSize();
/* 39 */     final Rectangle2D.Double anchor = new Rectangle2D.Double(0.0D, 0.0D, dimension.getWidth(), dimension.getHeight());
/*    */     
/* 41 */     PlaceableShape<?, ?> placeableShape = new PlaceableShape() {
/* 42 */         public ShapeContainer<?, ?> getParent() { return null; } public Rectangle2D getAnchor() {
/* 43 */           return anchor;
/*    */         } public void setAnchor(Rectangle2D param1Rectangle2D) {} public double getRotation() {
/* 45 */           return 0.0D;
/*    */         }
/*    */         
/*    */         public void setRotation(double param1Double) {}
/* 49 */         public boolean getFlipHorizontal() { return false; } public void setFlipHorizontal(boolean param1Boolean) {} public void setFlipVertical(boolean param1Boolean) {} public boolean getFlipVertical() {
/* 50 */           return false; } public Sheet<?, ?> getSheet() {
/* 51 */           return DrawBackground.this.shape.getSheet();
/*    */         }
/*    */       };
/* 54 */     DrawFactory drawFactory = DrawFactory.getInstance(paramGraphics2D);
/* 55 */     DrawPaint drawPaint = drawFactory.getPaint(placeableShape);
/* 56 */     Paint paint = drawPaint.getPaint(paramGraphics2D, getShape().getFillStyle().getPaint());
/* 57 */     Rectangle2D rectangle2D = getAnchor(paramGraphics2D, double_);
/*    */     
/* 59 */     if (paint != null) {
/* 60 */       paramGraphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, double_);
/* 61 */       paramGraphics2D.setPaint(paint);
/* 62 */       paramGraphics2D.fill(rectangle2D);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected Background<?, ?> getShape() {
/* 67 */     return (Background<?, ?>)this.shape;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */