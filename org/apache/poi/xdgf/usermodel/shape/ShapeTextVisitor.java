/*    */ package org.apache.poi.xdgf.usermodel.shape;
/*    */ 
/*    */ import java.awt.geom.AffineTransform;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShapeTextVisitor
/*    */   extends ShapeVisitor
/*    */ {
/* 32 */   protected StringBuilder text = new StringBuilder();
/*    */   
/*    */   public static class TextAcceptor implements ShapeVisitorAcceptor {
/*    */     public boolean accept(XDGFShape param1XDGFShape) {
/* 36 */       return param1XDGFShape.hasText();
/*    */     }
/*    */   }
/*    */   
/*    */   protected ShapeVisitorAcceptor getAcceptor() {
/* 41 */     return new TextAcceptor();
/*    */   }
/*    */ 
/*    */   
/*    */   public void visit(XDGFShape paramXDGFShape, AffineTransform paramAffineTransform, int paramInt) {
/* 46 */     this.text.append(paramXDGFShape.getText().getTextContent().trim());
/* 47 */     this.text.append('\n');
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getText() {
/* 54 */     return this.text.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\shape\ShapeTextVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */