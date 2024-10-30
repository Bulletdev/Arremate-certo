/*    */ package org.apache.poi.hssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.ddf.EscherChildAnchorRecord;
/*    */ import org.apache.poi.ddf.EscherClientAnchorRecord;
/*    */ import org.apache.poi.ddf.EscherContainerRecord;
/*    */ import org.apache.poi.ddf.EscherRecord;
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
/*    */ public abstract class HSSFAnchor
/*    */ {
/*    */   protected boolean _isHorizontallyFlipped = false;
/*    */   protected boolean _isVerticallyFlipped = false;
/*    */   
/*    */   public HSSFAnchor() {
/* 36 */     createEscherAnchor();
/*    */   }
/*    */   
/*    */   public HSSFAnchor(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 40 */     createEscherAnchor();
/* 41 */     setDx1(paramInt1);
/* 42 */     setDy1(paramInt2);
/* 43 */     setDx2(paramInt3);
/* 44 */     setDy2(paramInt4);
/*    */   }
/*    */   
/*    */   public static HSSFAnchor createAnchorFromEscher(EscherContainerRecord paramEscherContainerRecord) {
/* 48 */     if (null != paramEscherContainerRecord.getChildById((short)-4081)) {
/* 49 */       return new HSSFChildAnchor((EscherChildAnchorRecord)paramEscherContainerRecord.getChildById((short)-4081));
/*    */     }
/* 51 */     if (null != paramEscherContainerRecord.getChildById((short)-4080)) {
/* 52 */       return new HSSFClientAnchor((EscherClientAnchorRecord)paramEscherContainerRecord.getChildById((short)-4080));
/*    */     }
/* 54 */     return null;
/*    */   }
/*    */   
/*    */   public abstract int getDx1();
/*    */   
/*    */   public abstract void setDx1(int paramInt);
/*    */   
/*    */   public abstract int getDy1();
/*    */   
/*    */   public abstract void setDy1(int paramInt);
/*    */   
/*    */   public abstract int getDy2();
/*    */   
/*    */   public abstract void setDy2(int paramInt);
/*    */   
/*    */   public abstract int getDx2();
/*    */   
/*    */   public abstract void setDx2(int paramInt);
/*    */   
/*    */   public abstract boolean isHorizontallyFlipped();
/*    */   
/*    */   public abstract boolean isVerticallyFlipped();
/*    */   
/*    */   protected abstract EscherRecord getEscherAnchor();
/*    */   
/*    */   protected abstract void createEscherAnchor();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */