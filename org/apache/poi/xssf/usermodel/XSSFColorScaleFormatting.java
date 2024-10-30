/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.Color;
/*    */ import org.apache.poi.ss.usermodel.ColorScaleFormatting;
/*    */ import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale;
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
/*    */ public class XSSFColorScaleFormatting
/*    */   implements ColorScaleFormatting
/*    */ {
/*    */   CTColorScale _scale;
/*    */   
/*    */   XSSFColorScaleFormatting(CTColorScale paramCTColorScale) {
/* 36 */     this._scale = paramCTColorScale;
/*    */   }
/*    */   
/*    */   public int getNumControlPoints() {
/* 40 */     return this._scale.sizeOfCfvoArray();
/*    */   }
/*    */   public void setNumControlPoints(int paramInt) {
/* 43 */     while (paramInt < this._scale.sizeOfCfvoArray()) {
/* 44 */       this._scale.removeCfvo(this._scale.sizeOfCfvoArray() - 1);
/* 45 */       this._scale.removeColor(this._scale.sizeOfColorArray() - 1);
/*    */     } 
/* 47 */     while (paramInt > this._scale.sizeOfCfvoArray()) {
/* 48 */       this._scale.addNewCfvo();
/* 49 */       this._scale.addNewColor();
/*    */     } 
/*    */   }
/*    */   
/*    */   public XSSFColor[] getColors() {
/* 54 */     CTColor[] arrayOfCTColor = this._scale.getColorArray();
/* 55 */     XSSFColor[] arrayOfXSSFColor = new XSSFColor[arrayOfCTColor.length];
/* 56 */     for (byte b = 0; b < arrayOfCTColor.length; b++) {
/* 57 */       arrayOfXSSFColor[b] = new XSSFColor(arrayOfCTColor[b]);
/*    */     }
/* 59 */     return arrayOfXSSFColor;
/*    */   }
/*    */   public void setColors(Color[] paramArrayOfColor) {
/* 62 */     CTColor[] arrayOfCTColor = new CTColor[paramArrayOfColor.length];
/* 63 */     for (byte b = 0; b < paramArrayOfColor.length; b++) {
/* 64 */       arrayOfCTColor[b] = ((XSSFColor)paramArrayOfColor[b]).getCTColor();
/*    */     }
/* 66 */     this._scale.setColorArray(arrayOfCTColor);
/*    */   }
/*    */   
/*    */   public XSSFConditionalFormattingThreshold[] getThresholds() {
/* 70 */     CTCfvo[] arrayOfCTCfvo = this._scale.getCfvoArray();
/* 71 */     XSSFConditionalFormattingThreshold[] arrayOfXSSFConditionalFormattingThreshold = new XSSFConditionalFormattingThreshold[arrayOfCTCfvo.length];
/*    */     
/* 73 */     for (byte b = 0; b < arrayOfCTCfvo.length; b++) {
/* 74 */       arrayOfXSSFConditionalFormattingThreshold[b] = new XSSFConditionalFormattingThreshold(arrayOfCTCfvo[b]);
/*    */     }
/* 76 */     return arrayOfXSSFConditionalFormattingThreshold;
/*    */   }
/*    */   public void setThresholds(ConditionalFormattingThreshold[] paramArrayOfConditionalFormattingThreshold) {
/* 79 */     CTCfvo[] arrayOfCTCfvo = new CTCfvo[paramArrayOfConditionalFormattingThreshold.length];
/* 80 */     for (byte b = 0; b < paramArrayOfConditionalFormattingThreshold.length; b++) {
/* 81 */       arrayOfCTCfvo[b] = ((XSSFConditionalFormattingThreshold)paramArrayOfConditionalFormattingThreshold[b]).getCTCfvo();
/*    */     }
/* 83 */     this._scale.setCfvoArray(arrayOfCTCfvo);
/*    */   }
/*    */   
/*    */   public XSSFColor createColor() {
/* 87 */     return new XSSFColor(this._scale.addNewColor());
/*    */   }
/*    */   public XSSFConditionalFormattingThreshold createThreshold() {
/* 90 */     return new XSSFConditionalFormattingThreshold(this._scale.addNewCfvo());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFColorScaleFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */