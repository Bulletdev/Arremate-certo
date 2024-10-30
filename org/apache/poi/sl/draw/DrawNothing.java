/*    */ package org.apache.poi.sl.draw;
/*    */ 
/*    */ import java.awt.Graphics2D;
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
/*    */ 
/*    */ public class DrawNothing
/*    */   implements Drawable
/*    */ {
/*    */   protected final Shape<?, ?> shape;
/*    */   
/*    */   public DrawNothing(Shape<?, ?> paramShape) {
/* 30 */     this.shape = paramShape;
/*    */   }
/*    */   
/*    */   public void applyTransform(Graphics2D paramGraphics2D) {}
/*    */   
/*    */   public void draw(Graphics2D paramGraphics2D) {}
/*    */   
/*    */   public void drawContent(Graphics2D paramGraphics2D) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawNothing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */