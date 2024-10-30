/*    */ package org.apache.poi.sl.draw;
/*    */ 
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.AffineTransform;
/*    */ import java.awt.geom.Rectangle2D;
/*    */ import org.apache.poi.sl.usermodel.GroupShape;
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
/*    */ public class DrawGroupShape
/*    */   extends DrawShape
/*    */ {
/*    */   public DrawGroupShape(GroupShape<?, ?> paramGroupShape) {
/* 30 */     super((Shape<?, ?>)paramGroupShape);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw(Graphics2D paramGraphics2D) {
/* 36 */     Rectangle2D rectangle2D1 = getShape().getInteriorAnchor();
/*    */     
/* 38 */     Rectangle2D rectangle2D2 = getShape().getAnchor();
/*    */     
/* 40 */     AffineTransform affineTransform1 = (AffineTransform)paramGraphics2D.getRenderingHint(Drawable.GROUP_TRANSFORM);
/* 41 */     AffineTransform affineTransform2 = new AffineTransform(affineTransform1);
/*    */     
/* 43 */     double d1 = (rectangle2D1.getWidth() == 0.0D) ? 1.0D : (rectangle2D2.getWidth() / rectangle2D1.getWidth());
/* 44 */     double d2 = (rectangle2D1.getHeight() == 0.0D) ? 1.0D : (rectangle2D2.getHeight() / rectangle2D1.getHeight());
/*    */     
/* 46 */     affineTransform1.translate(rectangle2D2.getX(), rectangle2D2.getY());
/* 47 */     affineTransform1.scale(d1, d2);
/* 48 */     affineTransform1.translate(-rectangle2D1.getX(), -rectangle2D1.getY());
/*    */     
/* 50 */     DrawFactory drawFactory = DrawFactory.getInstance(paramGraphics2D);
/* 51 */     AffineTransform affineTransform3 = paramGraphics2D.getTransform();
/*    */     
/* 53 */     for (Shape<?, ?> shape : getShape()) {
/*    */       
/* 55 */       AffineTransform affineTransform = paramGraphics2D.getTransform();
/* 56 */       paramGraphics2D.setRenderingHint(Drawable.GSAVE, Boolean.valueOf(true));
/*    */       
/* 58 */       Drawable drawable = drawFactory.getDrawable(shape);
/* 59 */       drawable.applyTransform(paramGraphics2D);
/* 60 */       drawable.draw(paramGraphics2D);
/*    */ 
/*    */       
/* 63 */       paramGraphics2D.setTransform(affineTransform);
/* 64 */       paramGraphics2D.setRenderingHint(Drawable.GRESTORE, Boolean.valueOf(true));
/*    */     } 
/*    */     
/* 67 */     paramGraphics2D.setTransform(affineTransform3);
/* 68 */     paramGraphics2D.setRenderingHint(Drawable.GROUP_TRANSFORM, affineTransform2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected GroupShape<?, ?> getShape() {
/* 73 */     return (GroupShape<?, ?>)this.shape;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawGroupShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */