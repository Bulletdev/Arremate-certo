/*    */ package org.apache.poi.hssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.hssf.record.CFRule12Record;
/*    */ import org.apache.poi.hssf.record.cf.IconMultiStateFormatting;
/*    */ import org.apache.poi.hssf.record.cf.IconMultiStateThreshold;
/*    */ import org.apache.poi.hssf.record.cf.Threshold;
/*    */ import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
/*    */ import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
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
/*    */ public final class HSSFIconMultiStateFormatting
/*    */   implements IconMultiStateFormatting
/*    */ {
/*    */   private final HSSFSheet sheet;
/*    */   private final CFRule12Record cfRule12Record;
/*    */   private final IconMultiStateFormatting iconFormatting;
/*    */   
/*    */   protected HSSFIconMultiStateFormatting(CFRule12Record paramCFRule12Record, HSSFSheet paramHSSFSheet) {
/* 36 */     this.sheet = paramHSSFSheet;
/* 37 */     this.cfRule12Record = paramCFRule12Record;
/* 38 */     this.iconFormatting = this.cfRule12Record.getMultiStateFormatting();
/*    */   }
/*    */   
/*    */   public IconMultiStateFormatting.IconSet getIconSet() {
/* 42 */     return this.iconFormatting.getIconSet();
/*    */   }
/*    */   public void setIconSet(IconMultiStateFormatting.IconSet paramIconSet) {
/* 45 */     this.iconFormatting.setIconSet(paramIconSet);
/*    */   }
/*    */   
/*    */   public boolean isIconOnly() {
/* 49 */     return this.iconFormatting.isIconOnly();
/*    */   }
/*    */   public void setIconOnly(boolean paramBoolean) {
/* 52 */     this.iconFormatting.setIconOnly(paramBoolean);
/*    */   }
/*    */   
/*    */   public boolean isReversed() {
/* 56 */     return this.iconFormatting.isReversed();
/*    */   }
/*    */   public void setReversed(boolean paramBoolean) {
/* 59 */     this.iconFormatting.setReversed(paramBoolean);
/*    */   }
/*    */   
/*    */   public HSSFConditionalFormattingThreshold[] getThresholds() {
/* 63 */     Threshold[] arrayOfThreshold = this.iconFormatting.getThresholds();
/* 64 */     HSSFConditionalFormattingThreshold[] arrayOfHSSFConditionalFormattingThreshold = new HSSFConditionalFormattingThreshold[arrayOfThreshold.length];
/* 65 */     for (byte b = 0; b < arrayOfThreshold.length; b++) {
/* 66 */       arrayOfHSSFConditionalFormattingThreshold[b] = new HSSFConditionalFormattingThreshold(arrayOfThreshold[b], this.sheet);
/*    */     }
/* 68 */     return arrayOfHSSFConditionalFormattingThreshold;
/*    */   }
/*    */   
/*    */   public void setThresholds(ConditionalFormattingThreshold[] paramArrayOfConditionalFormattingThreshold) {
/* 72 */     Threshold[] arrayOfThreshold = new Threshold[paramArrayOfConditionalFormattingThreshold.length];
/* 73 */     for (byte b = 0; b < arrayOfThreshold.length; b++) {
/* 74 */       arrayOfThreshold[b] = ((HSSFConditionalFormattingThreshold)paramArrayOfConditionalFormattingThreshold[b]).getThreshold();
/*    */     }
/* 76 */     this.iconFormatting.setThresholds(arrayOfThreshold);
/*    */   }
/*    */   
/*    */   public HSSFConditionalFormattingThreshold createThreshold() {
/* 80 */     return new HSSFConditionalFormattingThreshold((Threshold)new IconMultiStateThreshold(), this.sheet);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFIconMultiStateFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */