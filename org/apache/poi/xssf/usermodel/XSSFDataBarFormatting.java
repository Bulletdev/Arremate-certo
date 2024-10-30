/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.Color;
/*    */ import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
/*    */ import org.apache.poi.ss.usermodel.DataBarFormatting;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar;
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
/*    */ public class XSSFDataBarFormatting
/*    */   implements DataBarFormatting
/*    */ {
/*    */   CTDataBar _databar;
/*    */   
/*    */   XSSFDataBarFormatting(CTDataBar paramCTDataBar) {
/* 33 */     this._databar = paramCTDataBar;
/*    */   }
/*    */   
/*    */   public boolean isIconOnly() {
/* 37 */     if (this._databar.isSetShowValue())
/* 38 */       return !this._databar.getShowValue(); 
/* 39 */     return false;
/*    */   }
/*    */   public void setIconOnly(boolean paramBoolean) {
/* 42 */     this._databar.setShowValue(!paramBoolean);
/*    */   }
/*    */   
/*    */   public boolean isLeftToRight() {
/* 46 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLeftToRight(boolean paramBoolean) {}
/*    */   
/*    */   public int getWidthMin() {
/* 53 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setWidthMin(int paramInt) {}
/*    */   
/*    */   public int getWidthMax() {
/* 60 */     return 100;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setWidthMax(int paramInt) {}
/*    */   
/*    */   public XSSFColor getColor() {
/* 67 */     return new XSSFColor(this._databar.getColor());
/*    */   }
/*    */   public void setColor(Color paramColor) {
/* 70 */     this._databar.setColor(((XSSFColor)paramColor).getCTColor());
/*    */   }
/*    */   
/*    */   public XSSFConditionalFormattingThreshold getMinThreshold() {
/* 74 */     return new XSSFConditionalFormattingThreshold(this._databar.getCfvoArray(0));
/*    */   }
/*    */   public XSSFConditionalFormattingThreshold getMaxThreshold() {
/* 77 */     return new XSSFConditionalFormattingThreshold(this._databar.getCfvoArray(1));
/*    */   }
/*    */   
/*    */   public XSSFConditionalFormattingThreshold createThreshold() {
/* 81 */     return new XSSFConditionalFormattingThreshold(this._databar.addNewCfvo());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFDataBarFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */