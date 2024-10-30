/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormatting;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
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
/*     */ public class XSSFConditionalFormatting
/*     */   implements ConditionalFormatting
/*     */ {
/*     */   private final CTConditionalFormatting _cf;
/*     */   private final XSSFSheet _sh;
/*     */   
/*     */   XSSFConditionalFormatting(XSSFSheet paramXSSFSheet) {
/*  37 */     this._cf = CTConditionalFormatting.Factory.newInstance();
/*  38 */     this._sh = paramXSSFSheet;
/*     */   }
/*     */   
/*     */   XSSFConditionalFormatting(XSSFSheet paramXSSFSheet, CTConditionalFormatting paramCTConditionalFormatting) {
/*  42 */     this._cf = paramCTConditionalFormatting;
/*  43 */     this._sh = paramXSSFSheet;
/*     */   }
/*     */   
/*     */   CTConditionalFormatting getCTConditionalFormatting() {
/*  47 */     return this._cf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellRangeAddress[] getFormattingRanges() {
/*  54 */     ArrayList<CellRangeAddress> arrayList = new ArrayList();
/*  55 */     for (Object object : this._cf.getSqref()) {
/*  56 */       String[] arrayOfString = object.toString().split(" ");
/*  57 */       for (byte b = 0; b < arrayOfString.length; b++) {
/*  58 */         arrayList.add(CellRangeAddress.valueOf(arrayOfString[b]));
/*     */       }
/*     */     } 
/*  61 */     return arrayList.<CellRangeAddress>toArray(new CellRangeAddress[arrayList.size()]);
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
/*     */   public void setRule(int paramInt, ConditionalFormattingRule paramConditionalFormattingRule) {
/*  73 */     XSSFConditionalFormattingRule xSSFConditionalFormattingRule = (XSSFConditionalFormattingRule)paramConditionalFormattingRule;
/*  74 */     this._cf.getCfRuleArray(paramInt).set((XmlObject)xSSFConditionalFormattingRule.getCTCfRule());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRule(ConditionalFormattingRule paramConditionalFormattingRule) {
/*  84 */     XSSFConditionalFormattingRule xSSFConditionalFormattingRule = (XSSFConditionalFormattingRule)paramConditionalFormattingRule;
/*  85 */     this._cf.addNewCfRule().set((XmlObject)xSSFConditionalFormattingRule.getCTCfRule());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFConditionalFormattingRule getRule(int paramInt) {
/*  92 */     return new XSSFConditionalFormattingRule(this._sh, this._cf.getCfRuleArray(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfRules() {
/*  99 */     return this._cf.sizeOfCfRuleArray();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     return this._cf.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFConditionalFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */