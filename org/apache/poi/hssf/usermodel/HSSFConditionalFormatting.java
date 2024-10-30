/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.record.CFRuleBase;
/*     */ import org.apache.poi.hssf.record.aggregates.CFRecordsAggregate;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormatting;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
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
/*     */ public final class HSSFConditionalFormatting
/*     */   implements ConditionalFormatting
/*     */ {
/*     */   private final HSSFSheet sheet;
/*     */   private final CFRecordsAggregate cfAggregate;
/*     */   
/*     */   HSSFConditionalFormatting(HSSFSheet paramHSSFSheet, CFRecordsAggregate paramCFRecordsAggregate) {
/*  81 */     if (paramHSSFSheet == null) {
/*  82 */       throw new IllegalArgumentException("sheet must not be null");
/*     */     }
/*  84 */     if (paramCFRecordsAggregate == null) {
/*  85 */       throw new IllegalArgumentException("cfAggregate must not be null");
/*     */     }
/*  87 */     this.sheet = paramHSSFSheet;
/*  88 */     this.cfAggregate = paramCFRecordsAggregate;
/*     */   }
/*     */   CFRecordsAggregate getCFRecordsAggregate() {
/*  91 */     return this.cfAggregate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellRangeAddress[] getFormattingRanges() {
/*  98 */     return this.cfAggregate.getHeader().getCellRanges();
/*     */   }
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
/*     */   public void setRule(int paramInt, HSSFConditionalFormattingRule paramHSSFConditionalFormattingRule) {
/* 111 */     this.cfAggregate.setRule(paramInt, paramHSSFConditionalFormattingRule.getCfRuleRecord());
/*     */   }
/*     */   
/*     */   public void setRule(int paramInt, ConditionalFormattingRule paramConditionalFormattingRule) {
/* 115 */     setRule(paramInt, (HSSFConditionalFormattingRule)paramConditionalFormattingRule);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRule(HSSFConditionalFormattingRule paramHSSFConditionalFormattingRule) {
/* 124 */     this.cfAggregate.addRule(paramHSSFConditionalFormattingRule.getCfRuleRecord());
/*     */   }
/*     */   
/*     */   public void addRule(ConditionalFormattingRule paramConditionalFormattingRule) {
/* 128 */     addRule((HSSFConditionalFormattingRule)paramConditionalFormattingRule);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFConditionalFormattingRule getRule(int paramInt) {
/* 135 */     CFRuleBase cFRuleBase = this.cfAggregate.getRule(paramInt);
/* 136 */     return new HSSFConditionalFormattingRule(this.sheet, cFRuleBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfRules() {
/* 143 */     return this.cfAggregate.getNumberOfRules();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 147 */     return this.cfAggregate.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFConditionalFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */