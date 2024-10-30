/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.record.CFRuleBase;
/*     */ import org.apache.poi.hssf.record.cf.PatternFormatting;
/*     */ import org.apache.poi.hssf.util.HSSFColor;
/*     */ import org.apache.poi.ss.usermodel.Color;
/*     */ import org.apache.poi.ss.usermodel.PatternFormatting;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSSFPatternFormatting
/*     */   implements PatternFormatting
/*     */ {
/*     */   private final HSSFWorkbook workbook;
/*     */   private final CFRuleBase cfRuleRecord;
/*     */   private final PatternFormatting patternFormatting;
/*     */   
/*     */   protected HSSFPatternFormatting(CFRuleBase paramCFRuleBase, HSSFWorkbook paramHSSFWorkbook) {
/*  34 */     this.workbook = paramHSSFWorkbook;
/*  35 */     this.cfRuleRecord = paramCFRuleBase;
/*  36 */     this.patternFormatting = paramCFRuleBase.getPatternFormatting();
/*     */   }
/*     */ 
/*     */   
/*     */   protected PatternFormatting getPatternFormattingBlock() {
/*  41 */     return this.patternFormatting;
/*     */   }
/*     */   
/*     */   public HSSFColor getFillBackgroundColorColor() {
/*  45 */     return this.workbook.getCustomPalette().getColor(getFillBackgroundColor());
/*     */   }
/*     */   
/*     */   public HSSFColor getFillForegroundColorColor() {
/*  49 */     return this.workbook.getCustomPalette().getColor(getFillForegroundColor());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFillBackgroundColor() {
/*  57 */     return (short)this.patternFormatting.getFillBackgroundColor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFillForegroundColor() {
/*  65 */     return (short)this.patternFormatting.getFillForegroundColor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFillPattern() {
/*  73 */     return (short)this.patternFormatting.getFillPattern();
/*     */   }
/*     */   
/*     */   public void setFillBackgroundColor(Color paramColor) {
/*  77 */     HSSFColor hSSFColor = HSSFColor.toHSSFColor(paramColor);
/*  78 */     if (hSSFColor == null) {
/*  79 */       setFillBackgroundColor((short)0);
/*     */     } else {
/*  81 */       setFillBackgroundColor(hSSFColor.getIndex());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFillForegroundColor(Color paramColor) {
/*  86 */     HSSFColor hSSFColor = HSSFColor.toHSSFColor(paramColor);
/*  87 */     if (hSSFColor == null) {
/*  88 */       setFillForegroundColor((short)0);
/*     */     } else {
/*  90 */       setFillForegroundColor(hSSFColor.getIndex());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillBackgroundColor(short paramShort) {
/* 100 */     this.patternFormatting.setFillBackgroundColor(paramShort);
/* 101 */     if (paramShort != 0)
/*     */     {
/* 103 */       this.cfRuleRecord.setPatternBackgroundColorModified(true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillForegroundColor(short paramShort) {
/* 113 */     this.patternFormatting.setFillForegroundColor(paramShort);
/* 114 */     if (paramShort != 0)
/*     */     {
/* 116 */       this.cfRuleRecord.setPatternColorModified(true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillPattern(short paramShort) {
/* 126 */     this.patternFormatting.setFillPattern(paramShort);
/* 127 */     if (paramShort != 0)
/*     */     {
/* 129 */       this.cfRuleRecord.setPatternStyleModified(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFPatternFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */