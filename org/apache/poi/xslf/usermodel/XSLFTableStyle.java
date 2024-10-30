/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
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
/*    */ public class XSLFTableStyle
/*    */ {
/*    */   private CTTableStyle _tblStyle;
/*    */   
/*    */   public enum TablePartStyle
/*    */   {
/* 32 */     wholeTbl, band1H, band2H, band1V, band2V, firstCol, lastCol, firstRow, lastRow, seCell, swCell, neCell, nwCell;
/*    */   }
/*    */   
/*    */   XSLFTableStyle(CTTableStyle paramCTTableStyle) {
/* 36 */     this._tblStyle = paramCTTableStyle;
/*    */   }
/*    */   
/*    */   public CTTableStyle getXmlObject() {
/* 40 */     return this._tblStyle;
/*    */   }
/*    */   
/*    */   public String getStyleName() {
/* 44 */     return this._tblStyle.getStyleName();
/*    */   }
/*    */   
/*    */   public String getStyleId() {
/* 48 */     return this._tblStyle.getStyleId();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected CTTablePartStyle getTablePartStyle(TablePartStyle paramTablePartStyle) {
/* 55 */     switch (paramTablePartStyle)
/*    */     
/*    */     { default:
/* 58 */         return this._tblStyle.getWholeTbl();
/*    */       case band1H:
/* 60 */         return this._tblStyle.getBand1H();
/*    */       case band2H:
/* 62 */         return this._tblStyle.getBand2H();
/*    */       case band1V:
/* 64 */         return this._tblStyle.getBand1V();
/*    */       case band2V:
/* 66 */         return this._tblStyle.getBand2V();
/*    */       case firstCol:
/* 68 */         return this._tblStyle.getFirstCol();
/*    */       case lastCol:
/* 70 */         return this._tblStyle.getLastCol();
/*    */       case firstRow:
/* 72 */         return this._tblStyle.getFirstRow();
/*    */       case lastRow:
/* 74 */         return this._tblStyle.getLastRow();
/*    */       case seCell:
/* 76 */         return this._tblStyle.getSeCell();
/*    */       case swCell:
/* 78 */         return this._tblStyle.getSwCell();
/*    */       case neCell:
/* 80 */         return this._tblStyle.getNeCell();
/*    */       case nwCell:
/* 82 */         break; }  return this._tblStyle.getNwCell();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFTableStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */