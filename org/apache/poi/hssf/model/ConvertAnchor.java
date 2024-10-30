/*    */ package org.apache.poi.hssf.model;
/*    */ 
/*    */ import org.apache.poi.ddf.EscherChildAnchorRecord;
/*    */ import org.apache.poi.ddf.EscherClientAnchorRecord;
/*    */ import org.apache.poi.ddf.EscherRecord;
/*    */ import org.apache.poi.hssf.usermodel.HSSFAnchor;
/*    */ import org.apache.poi.hssf.usermodel.HSSFChildAnchor;
/*    */ import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
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
/*    */ public class ConvertAnchor
/*    */ {
/*    */   public static EscherRecord createAnchor(HSSFAnchor paramHSSFAnchor) {
/* 34 */     if (paramHSSFAnchor instanceof HSSFClientAnchor) {
/*    */       
/* 36 */       HSSFClientAnchor hSSFClientAnchor = (HSSFClientAnchor)paramHSSFAnchor;
/*    */       
/* 38 */       EscherClientAnchorRecord escherClientAnchorRecord = new EscherClientAnchorRecord();
/* 39 */       escherClientAnchorRecord.setRecordId((short)-4080);
/* 40 */       escherClientAnchorRecord.setOptions((short)0);
/* 41 */       escherClientAnchorRecord.setFlag((hSSFClientAnchor.getAnchorType()).value);
/* 42 */       escherClientAnchorRecord.setCol1((short)Math.min(hSSFClientAnchor.getCol1(), hSSFClientAnchor.getCol2()));
/* 43 */       escherClientAnchorRecord.setDx1((short)hSSFClientAnchor.getDx1());
/* 44 */       escherClientAnchorRecord.setRow1((short)Math.min(hSSFClientAnchor.getRow1(), hSSFClientAnchor.getRow2()));
/* 45 */       escherClientAnchorRecord.setDy1((short)hSSFClientAnchor.getDy1());
/*    */       
/* 47 */       escherClientAnchorRecord.setCol2((short)Math.max(hSSFClientAnchor.getCol1(), hSSFClientAnchor.getCol2()));
/* 48 */       escherClientAnchorRecord.setDx2((short)hSSFClientAnchor.getDx2());
/* 49 */       escherClientAnchorRecord.setRow2((short)Math.max(hSSFClientAnchor.getRow1(), hSSFClientAnchor.getRow2()));
/* 50 */       escherClientAnchorRecord.setDy2((short)hSSFClientAnchor.getDy2());
/* 51 */       return (EscherRecord)escherClientAnchorRecord;
/*    */     } 
/* 53 */     HSSFChildAnchor hSSFChildAnchor = (HSSFChildAnchor)paramHSSFAnchor;
/* 54 */     EscherChildAnchorRecord escherChildAnchorRecord = new EscherChildAnchorRecord();
/* 55 */     escherChildAnchorRecord.setRecordId((short)-4081);
/* 56 */     escherChildAnchorRecord.setOptions((short)0);
/* 57 */     escherChildAnchorRecord.setDx1((short)Math.min(hSSFChildAnchor.getDx1(), hSSFChildAnchor.getDx2()));
/* 58 */     escherChildAnchorRecord.setDy1((short)Math.min(hSSFChildAnchor.getDy1(), hSSFChildAnchor.getDy2()));
/* 59 */     escherChildAnchorRecord.setDx2((short)Math.max(hSSFChildAnchor.getDx2(), hSSFChildAnchor.getDx1()));
/* 60 */     escherChildAnchorRecord.setDy2((short)Math.max(hSSFChildAnchor.getDy2(), hSSFChildAnchor.getDy1()));
/* 61 */     return (EscherRecord)escherChildAnchorRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\model\ConvertAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */