/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
/*    */ import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;
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
/*    */ public class XSSFIconMultiStateFormatting
/*    */   implements IconMultiStateFormatting
/*    */ {
/*    */   CTIconSet _iconset;
/*    */   
/*    */   XSSFIconMultiStateFormatting(CTIconSet paramCTIconSet) {
/* 35 */     this._iconset = paramCTIconSet;
/*    */   }
/*    */   
/*    */   public IconMultiStateFormatting.IconSet getIconSet() {
/* 39 */     String str = this._iconset.getIconSet().toString();
/* 40 */     return IconMultiStateFormatting.IconSet.byName(str);
/*    */   }
/*    */   public void setIconSet(IconMultiStateFormatting.IconSet paramIconSet) {
/* 43 */     STIconSetType.Enum enum_ = STIconSetType.Enum.forString(paramIconSet.name);
/* 44 */     this._iconset.setIconSet(enum_);
/*    */   }
/*    */   
/*    */   public boolean isIconOnly() {
/* 48 */     if (this._iconset.isSetShowValue())
/* 49 */       return !this._iconset.getShowValue(); 
/* 50 */     return false;
/*    */   }
/*    */   public void setIconOnly(boolean paramBoolean) {
/* 53 */     this._iconset.setShowValue(!paramBoolean);
/*    */   }
/*    */   
/*    */   public boolean isReversed() {
/* 57 */     if (this._iconset.isSetReverse())
/* 58 */       return this._iconset.getReverse(); 
/* 59 */     return false;
/*    */   }
/*    */   public void setReversed(boolean paramBoolean) {
/* 62 */     this._iconset.setReverse(paramBoolean);
/*    */   }
/*    */   
/*    */   public XSSFConditionalFormattingThreshold[] getThresholds() {
/* 66 */     CTCfvo[] arrayOfCTCfvo = this._iconset.getCfvoArray();
/* 67 */     XSSFConditionalFormattingThreshold[] arrayOfXSSFConditionalFormattingThreshold = new XSSFConditionalFormattingThreshold[arrayOfCTCfvo.length];
/*    */     
/* 69 */     for (byte b = 0; b < arrayOfCTCfvo.length; b++) {
/* 70 */       arrayOfXSSFConditionalFormattingThreshold[b] = new XSSFConditionalFormattingThreshold(arrayOfCTCfvo[b]);
/*    */     }
/* 72 */     return arrayOfXSSFConditionalFormattingThreshold;
/*    */   }
/*    */   public void setThresholds(ConditionalFormattingThreshold[] paramArrayOfConditionalFormattingThreshold) {
/* 75 */     CTCfvo[] arrayOfCTCfvo = new CTCfvo[paramArrayOfConditionalFormattingThreshold.length];
/* 76 */     for (byte b = 0; b < paramArrayOfConditionalFormattingThreshold.length; b++) {
/* 77 */       arrayOfCTCfvo[b] = ((XSSFConditionalFormattingThreshold)paramArrayOfConditionalFormattingThreshold[b]).getCTCfvo();
/*    */     }
/* 79 */     this._iconset.setCfvoArray(arrayOfCTCfvo);
/*    */   }
/*    */   public XSSFConditionalFormattingThreshold createThreshold() {
/* 82 */     return new XSSFConditionalFormattingThreshold(this._iconset.addNewCfvo());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFIconMultiStateFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */