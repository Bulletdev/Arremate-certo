/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
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
/*    */ public final class XSSFChildAnchor
/*    */   extends XSSFAnchor
/*    */ {
/*    */   private CTTransform2D t2d;
/*    */   
/*    */   public XSSFChildAnchor(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 32 */     this.t2d = CTTransform2D.Factory.newInstance();
/* 33 */     CTPoint2D cTPoint2D = this.t2d.addNewOff();
/* 34 */     CTPositiveSize2D cTPositiveSize2D = this.t2d.addNewExt();
/*    */     
/* 36 */     cTPoint2D.setX(paramInt1);
/* 37 */     cTPoint2D.setY(paramInt2);
/* 38 */     cTPositiveSize2D.setCx(Math.abs(paramInt3 - paramInt1));
/* 39 */     cTPositiveSize2D.setCy(Math.abs(paramInt4 - paramInt2));
/* 40 */     if (paramInt1 > paramInt3) this.t2d.setFlipH(true); 
/* 41 */     if (paramInt2 > paramInt4) this.t2d.setFlipV(true); 
/*    */   }
/*    */   
/*    */   public XSSFChildAnchor(CTTransform2D paramCTTransform2D) {
/* 45 */     this.t2d = paramCTTransform2D;
/*    */   }
/*    */   
/*    */   @Internal
/*    */   public CTTransform2D getCTTransform2D() {
/* 50 */     return this.t2d;
/*    */   }
/*    */   
/*    */   public int getDx1() {
/* 54 */     return (int)this.t2d.getOff().getX();
/*    */   }
/*    */   
/*    */   public void setDx1(int paramInt) {
/* 58 */     this.t2d.getOff().setX(paramInt);
/*    */   }
/*    */   
/*    */   public int getDy1() {
/* 62 */     return (int)this.t2d.getOff().getY();
/*    */   }
/*    */   
/*    */   public void setDy1(int paramInt) {
/* 66 */     this.t2d.getOff().setY(paramInt);
/*    */   }
/*    */   
/*    */   public int getDy2() {
/* 70 */     return (int)(getDy1() + this.t2d.getExt().getCy());
/*    */   }
/*    */   
/*    */   public void setDy2(int paramInt) {
/* 74 */     this.t2d.getExt().setCy((paramInt - getDy1()));
/*    */   }
/*    */   
/*    */   public int getDx2() {
/* 78 */     return (int)(getDx1() + this.t2d.getExt().getCx());
/*    */   }
/*    */   
/*    */   public void setDx2(int paramInt) {
/* 82 */     this.t2d.getExt().setCx((paramInt - getDx1()));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFChildAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */