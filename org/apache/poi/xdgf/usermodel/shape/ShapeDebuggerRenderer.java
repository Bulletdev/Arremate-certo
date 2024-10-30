/*    */ package org.apache.poi.xdgf.usermodel.shape;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.Path2D;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFShape;
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
/*    */ public class ShapeDebuggerRenderer
/*    */   extends ShapeRenderer
/*    */ {
/* 28 */   ShapeVisitorAcceptor _debugAcceptor = null;
/*    */ 
/*    */   
/*    */   public ShapeDebuggerRenderer() {}
/*    */ 
/*    */   
/*    */   public ShapeDebuggerRenderer(Graphics2D paramGraphics2D) {
/* 35 */     super(paramGraphics2D);
/*    */   }
/*    */   
/*    */   public void setDebugAcceptor(ShapeVisitorAcceptor paramShapeVisitorAcceptor) {
/* 39 */     this._debugAcceptor = paramShapeVisitorAcceptor;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Path2D drawPath(XDGFShape paramXDGFShape) {
/* 45 */     Path2D path2D = super.drawPath(paramXDGFShape);
/* 46 */     if (this._debugAcceptor == null || this._debugAcceptor.accept(paramXDGFShape)) {
/*    */ 
/*    */       
/* 49 */       Font font = this._graphics.getFont();
/* 50 */       this._graphics.scale(1.0D, -1.0D);
/* 51 */       this._graphics.setFont(font.deriveFont(0.05F));
/*    */       
/* 53 */       String str = "" + paramXDGFShape.getID();
/* 54 */       float f = -0.1F;
/*    */       
/* 56 */       if (paramXDGFShape.hasMasterShape()) {
/* 57 */         str = str + " MS:" + paramXDGFShape.getMasterShape().getID();
/* 58 */         f -= 0.15F;
/*    */       } 
/*    */       
/* 61 */       this._graphics.drawString(str, f, 0.0F);
/* 62 */       this._graphics.setFont(font);
/* 63 */       this._graphics.scale(1.0D, -1.0D);
/*    */     } 
/*    */     
/* 66 */     return path2D;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\shape\ShapeDebuggerRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */