/*    */ package org.apache.poi.xdgf.usermodel.shape;
/*    */ 
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
/*    */ public class ShapeDataAcceptor
/*    */   implements ShapeVisitorAcceptor
/*    */ {
/*    */   public boolean accept(XDGFShape paramXDGFShape) {
/* 37 */     if (paramXDGFShape.isDeleted()) {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (paramXDGFShape.hasText() && paramXDGFShape.getTextAsString().length() != 0) {
/* 42 */       return true;
/*    */     }
/*    */     
/* 45 */     if (paramXDGFShape.isShape1D()) {
/* 46 */       return true;
/*    */     }
/*    */     
/* 49 */     if (!paramXDGFShape.hasMaster() && !paramXDGFShape.hasMasterShape()) {
/* 50 */       return true;
/*    */     }
/* 52 */     if (paramXDGFShape.hasMaster() && !paramXDGFShape.hasMasterShape()) {
/* 53 */       return true;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 59 */     if (paramXDGFShape.hasMasterShape() && paramXDGFShape.getMasterShape().isTopmost()) {
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\shape\ShapeDataAcceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */