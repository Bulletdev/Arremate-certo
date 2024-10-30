/*    */ package org.apache.poi.hssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.hssf.record.CFRule12Record;
/*    */ import org.apache.poi.hssf.record.cf.ColorGradientFormatting;
/*    */ import org.apache.poi.hssf.record.cf.ColorGradientThreshold;
/*    */ import org.apache.poi.hssf.record.cf.Threshold;
/*    */ import org.apache.poi.hssf.record.common.ExtendedColor;
/*    */ import org.apache.poi.ss.usermodel.Color;
/*    */ import org.apache.poi.ss.usermodel.ColorScaleFormatting;
/*    */ import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
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
/*    */ public final class HSSFColorScaleFormatting
/*    */   implements ColorScaleFormatting
/*    */ {
/*    */   private final HSSFSheet sheet;
/*    */   private final CFRule12Record cfRule12Record;
/*    */   private final ColorGradientFormatting colorFormatting;
/*    */   
/*    */   protected HSSFColorScaleFormatting(CFRule12Record paramCFRule12Record, HSSFSheet paramHSSFSheet) {
/* 38 */     this.sheet = paramHSSFSheet;
/* 39 */     this.cfRule12Record = paramCFRule12Record;
/* 40 */     this.colorFormatting = this.cfRule12Record.getColorGradientFormatting();
/*    */   }
/*    */   
/*    */   public int getNumControlPoints() {
/* 44 */     return this.colorFormatting.getNumControlPoints();
/*    */   }
/*    */   public void setNumControlPoints(int paramInt) {
/* 47 */     this.colorFormatting.setNumControlPoints(paramInt);
/*    */   }
/*    */   
/*    */   public HSSFExtendedColor[] getColors() {
/* 51 */     ExtendedColor[] arrayOfExtendedColor = this.colorFormatting.getColors();
/* 52 */     HSSFExtendedColor[] arrayOfHSSFExtendedColor = new HSSFExtendedColor[arrayOfExtendedColor.length];
/* 53 */     for (byte b = 0; b < arrayOfExtendedColor.length; b++) {
/* 54 */       arrayOfHSSFExtendedColor[b] = new HSSFExtendedColor(arrayOfExtendedColor[b]);
/*    */     }
/* 56 */     return arrayOfHSSFExtendedColor;
/*    */   }
/*    */   public void setColors(Color[] paramArrayOfColor) {
/* 59 */     ExtendedColor[] arrayOfExtendedColor = new ExtendedColor[paramArrayOfColor.length];
/* 60 */     for (byte b = 0; b < paramArrayOfColor.length; b++) {
/* 61 */       arrayOfExtendedColor[b] = ((HSSFExtendedColor)paramArrayOfColor[b]).getExtendedColor();
/*    */     }
/* 63 */     this.colorFormatting.setColors(arrayOfExtendedColor);
/*    */   }
/*    */   
/*    */   public HSSFConditionalFormattingThreshold[] getThresholds() {
/* 67 */     ColorGradientThreshold[] arrayOfColorGradientThreshold = this.colorFormatting.getThresholds();
/* 68 */     HSSFConditionalFormattingThreshold[] arrayOfHSSFConditionalFormattingThreshold = new HSSFConditionalFormattingThreshold[arrayOfColorGradientThreshold.length];
/* 69 */     for (byte b = 0; b < arrayOfColorGradientThreshold.length; b++) {
/* 70 */       arrayOfHSSFConditionalFormattingThreshold[b] = new HSSFConditionalFormattingThreshold((Threshold)arrayOfColorGradientThreshold[b], this.sheet);
/*    */     }
/* 72 */     return arrayOfHSSFConditionalFormattingThreshold;
/*    */   }
/*    */   
/*    */   public void setThresholds(ConditionalFormattingThreshold[] paramArrayOfConditionalFormattingThreshold) {
/* 76 */     ColorGradientThreshold[] arrayOfColorGradientThreshold = new ColorGradientThreshold[paramArrayOfConditionalFormattingThreshold.length];
/* 77 */     for (byte b = 0; b < arrayOfColorGradientThreshold.length; b++) {
/* 78 */       HSSFConditionalFormattingThreshold hSSFConditionalFormattingThreshold = (HSSFConditionalFormattingThreshold)paramArrayOfConditionalFormattingThreshold[b];
/* 79 */       arrayOfColorGradientThreshold[b] = (ColorGradientThreshold)hSSFConditionalFormattingThreshold.getThreshold();
/*    */     } 
/* 81 */     this.colorFormatting.setThresholds(arrayOfColorGradientThreshold);
/*    */   }
/*    */   
/*    */   public HSSFConditionalFormattingThreshold createThreshold() {
/* 85 */     return new HSSFConditionalFormattingThreshold((Threshold)new ColorGradientThreshold(), this.sheet);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFColorScaleFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */