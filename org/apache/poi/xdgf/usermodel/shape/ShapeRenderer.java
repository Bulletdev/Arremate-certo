/*    */ package org.apache.poi.xdgf.usermodel.shape;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.AffineTransform;
/*    */ import java.awt.geom.Path2D;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFShape;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFText;
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
/*    */ public class ShapeRenderer
/*    */   extends ShapeVisitor
/*    */ {
/*    */   protected Graphics2D _graphics;
/*    */   
/*    */   public ShapeRenderer() {
/* 37 */     this._graphics = null;
/*    */   }
/*    */   
/*    */   public ShapeRenderer(Graphics2D paramGraphics2D) {
/* 41 */     this._graphics = paramGraphics2D;
/*    */   }
/*    */   
/*    */   public void setGraphics(Graphics2D paramGraphics2D) {
/* 45 */     this._graphics = paramGraphics2D;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void visit(XDGFShape paramXDGFShape, AffineTransform paramAffineTransform, int paramInt) {
/* 52 */     AffineTransform affineTransform = this._graphics.getTransform();
/* 53 */     this._graphics.transform(paramAffineTransform);
/*    */     
/* 55 */     drawPath(paramXDGFShape);
/* 56 */     drawText(paramXDGFShape);
/*    */ 
/*    */     
/* 59 */     this._graphics.setTransform(affineTransform);
/*    */   }
/*    */   
/*    */   protected Path2D drawPath(XDGFShape paramXDGFShape) {
/* 63 */     Path2D.Double double_ = paramXDGFShape.getPath();
/* 64 */     if (double_ != null) {
/*    */ 
/*    */ 
/*    */       
/* 68 */       this._graphics.setColor(paramXDGFShape.getLineColor());
/* 69 */       this._graphics.setStroke(paramXDGFShape.getStroke());
/* 70 */       this._graphics.draw(double_);
/*    */     } 
/*    */     
/* 73 */     return double_;
/*    */   }
/*    */   
/*    */   protected void drawText(XDGFShape paramXDGFShape) {
/* 77 */     XDGFText xDGFText = paramXDGFShape.getText();
/* 78 */     if (xDGFText != null) {
/*    */       
/* 80 */       if (xDGFText.getTextContent().equals("Header")) {
/* 81 */         xDGFText.getTextBounds();
/*    */       }
/* 83 */       Font font = this._graphics.getFont();
/*    */       
/* 85 */       this._graphics.setFont(font.deriveFont(paramXDGFShape.getFontSize().floatValue()));
/*    */       
/* 87 */       this._graphics.setColor(paramXDGFShape.getFontColor());
/*    */       
/* 89 */       xDGFText.draw(this._graphics);
/* 90 */       this._graphics.setFont(font);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\shape\ShapeRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */