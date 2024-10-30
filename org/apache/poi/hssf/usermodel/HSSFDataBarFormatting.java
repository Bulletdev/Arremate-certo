/*    */ package org.apache.poi.hssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.hssf.record.CFRule12Record;
/*    */ import org.apache.poi.hssf.record.cf.DataBarFormatting;
/*    */ import org.apache.poi.hssf.record.cf.DataBarThreshold;
/*    */ import org.apache.poi.hssf.record.cf.Threshold;
/*    */ import org.apache.poi.ss.usermodel.Color;
/*    */ import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
/*    */ import org.apache.poi.ss.usermodel.DataBarFormatting;
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
/*    */ public final class HSSFDataBarFormatting
/*    */   implements DataBarFormatting
/*    */ {
/*    */   private final HSSFSheet sheet;
/*    */   private final CFRule12Record cfRule12Record;
/*    */   private final DataBarFormatting databarFormatting;
/*    */   
/*    */   protected HSSFDataBarFormatting(CFRule12Record paramCFRule12Record, HSSFSheet paramHSSFSheet) {
/* 35 */     this.sheet = paramHSSFSheet;
/* 36 */     this.cfRule12Record = paramCFRule12Record;
/* 37 */     this.databarFormatting = this.cfRule12Record.getDataBarFormatting();
/*    */   }
/*    */   
/*    */   public boolean isLeftToRight() {
/* 41 */     return !this.databarFormatting.isReversed();
/*    */   }
/*    */   public void setLeftToRight(boolean paramBoolean) {
/* 44 */     this.databarFormatting.setReversed(!paramBoolean);
/*    */   }
/*    */   
/*    */   public int getWidthMin() {
/* 48 */     return this.databarFormatting.getPercentMin();
/*    */   }
/*    */   public void setWidthMin(int paramInt) {
/* 51 */     this.databarFormatting.setPercentMin((byte)paramInt);
/*    */   }
/*    */   
/*    */   public int getWidthMax() {
/* 55 */     return this.databarFormatting.getPercentMax();
/*    */   }
/*    */   public void setWidthMax(int paramInt) {
/* 58 */     this.databarFormatting.setPercentMax((byte)paramInt);
/*    */   }
/*    */   
/*    */   public HSSFExtendedColor getColor() {
/* 62 */     return new HSSFExtendedColor(this.databarFormatting.getColor());
/*    */   }
/*    */   public void setColor(Color paramColor) {
/* 65 */     HSSFExtendedColor hSSFExtendedColor = (HSSFExtendedColor)paramColor;
/* 66 */     this.databarFormatting.setColor(hSSFExtendedColor.getExtendedColor());
/*    */   }
/*    */   
/*    */   public HSSFConditionalFormattingThreshold getMinThreshold() {
/* 70 */     return new HSSFConditionalFormattingThreshold((Threshold)this.databarFormatting.getThresholdMin(), this.sheet);
/*    */   }
/*    */   public HSSFConditionalFormattingThreshold getMaxThreshold() {
/* 73 */     return new HSSFConditionalFormattingThreshold((Threshold)this.databarFormatting.getThresholdMax(), this.sheet);
/*    */   }
/*    */   
/*    */   public boolean isIconOnly() {
/* 77 */     return this.databarFormatting.isIconOnly();
/*    */   }
/*    */   public void setIconOnly(boolean paramBoolean) {
/* 80 */     this.databarFormatting.setIconOnly(paramBoolean);
/*    */   }
/*    */   
/*    */   public HSSFConditionalFormattingThreshold createThreshold() {
/* 84 */     return new HSSFConditionalFormattingThreshold((Threshold)new DataBarThreshold(), this.sheet);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFDataBarFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */