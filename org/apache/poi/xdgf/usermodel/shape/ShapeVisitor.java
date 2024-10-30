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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ShapeVisitor
/*    */ {
/* 38 */   protected ShapeVisitorAcceptor _acceptor = getAcceptor();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ShapeVisitorAcceptor getAcceptor() {
/* 46 */     return new ShapeVisitorAcceptor()
/*    */       {
/*    */         public boolean accept(XDGFShape param1XDGFShape) {
/* 49 */           return !param1XDGFShape.isDeleted();
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public void setAcceptor(ShapeVisitorAcceptor paramShapeVisitorAcceptor) {
/* 55 */     this._acceptor = paramShapeVisitorAcceptor;
/*    */   }
/*    */   
/*    */   public boolean accept(XDGFShape paramXDGFShape) {
/* 59 */     return this._acceptor.accept(paramXDGFShape);
/*    */   }
/*    */   
/*    */   public abstract void visit(XDGFShape paramXDGFShape, AffineTransform paramAffineTransform, int paramInt);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\shape\ShapeVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */