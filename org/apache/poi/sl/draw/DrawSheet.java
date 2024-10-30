/*    */ package org.apache.poi.sl.draw;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.AffineTransform;
/*    */ import org.apache.poi.sl.usermodel.MasterSheet;
/*    */ import org.apache.poi.sl.usermodel.Shape;
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
/*    */ 
/*    */ public class DrawSheet
/*    */   implements Drawable
/*    */ {
/*    */   protected final Sheet<?, ?> sheet;
/*    */   
/*    */   public DrawSheet(Sheet<?, ?> paramSheet) {
/* 34 */     this.sheet = paramSheet;
/*    */   }
/*    */   
/*    */   public void draw(Graphics2D paramGraphics2D) {
/* 38 */     Dimension dimension = this.sheet.getSlideShow().getPageSize();
/* 39 */     Color color = new Color(1.0F, 1.0F, 1.0F, 0.0F);
/* 40 */     paramGraphics2D.setColor(color);
/* 41 */     paramGraphics2D.fillRect(0, 0, (int)dimension.getWidth(), (int)dimension.getHeight());
/*    */     
/* 43 */     DrawFactory drawFactory = DrawFactory.getInstance(paramGraphics2D);
/* 44 */     MasterSheet<?, ?> masterSheet = this.sheet.getMasterSheet();
/*    */     
/* 46 */     if (this.sheet.getFollowMasterGraphics() && masterSheet != null) {
/* 47 */       DrawMasterSheet drawMasterSheet = drawFactory.getDrawable(masterSheet);
/* 48 */       drawMasterSheet.draw(paramGraphics2D);
/*    */     } 
/*    */     
/* 51 */     paramGraphics2D.setRenderingHint(Drawable.GROUP_TRANSFORM, new AffineTransform());
/*    */     
/* 53 */     for (Shape<?, ?> shape : (Iterable<Shape<?, ?>>)this.sheet.getShapes()) {
/* 54 */       if (!canDraw(shape)) {
/*    */         continue;
/*    */       }
/* 57 */       AffineTransform affineTransform = paramGraphics2D.getTransform();
/*    */ 
/*    */ 
/*    */       
/* 61 */       paramGraphics2D.setRenderingHint(Drawable.GSAVE, Boolean.valueOf(true));
/*    */ 
/*    */       
/* 64 */       Drawable drawable = drawFactory.getDrawable(shape);
/* 65 */       drawable.applyTransform(paramGraphics2D);
/*    */       
/* 67 */       drawable.draw(paramGraphics2D);
/*    */ 
/*    */       
/* 70 */       paramGraphics2D.setTransform(affineTransform);
/*    */       
/* 72 */       paramGraphics2D.setRenderingHint(Drawable.GRESTORE, Boolean.valueOf(true));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void applyTransform(Graphics2D paramGraphics2D) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawContent(Graphics2D paramGraphics2D) {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean canDraw(Shape<?, ?> paramShape) {
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */