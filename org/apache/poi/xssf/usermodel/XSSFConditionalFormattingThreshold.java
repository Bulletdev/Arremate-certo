/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfvoType;
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
/*    */ public class XSSFConditionalFormattingThreshold
/*    */   implements ConditionalFormattingThreshold
/*    */ {
/*    */   private CTCfvo cfvo;
/*    */   
/*    */   protected XSSFConditionalFormattingThreshold(CTCfvo paramCTCfvo) {
/* 33 */     this.cfvo = paramCTCfvo;
/*    */   }
/*    */   
/*    */   protected CTCfvo getCTCfvo() {
/* 37 */     return this.cfvo;
/*    */   }
/*    */   
/*    */   public ConditionalFormattingThreshold.RangeType getRangeType() {
/* 41 */     return ConditionalFormattingThreshold.RangeType.byName(this.cfvo.getType().toString());
/*    */   }
/*    */   public void setRangeType(ConditionalFormattingThreshold.RangeType paramRangeType) {
/* 44 */     STCfvoType.Enum enum_ = STCfvoType.Enum.forString(paramRangeType.name);
/* 45 */     this.cfvo.setType(enum_);
/*    */   }
/*    */   
/*    */   public String getFormula() {
/* 49 */     if (this.cfvo.getType() == STCfvoType.FORMULA) {
/* 50 */       return this.cfvo.getVal();
/*    */     }
/* 52 */     return null;
/*    */   }
/*    */   public void setFormula(String paramString) {
/* 55 */     this.cfvo.setVal(paramString);
/*    */   }
/*    */   
/*    */   public Double getValue() {
/* 59 */     if (this.cfvo.getType() == STCfvoType.FORMULA || this.cfvo.getType() == STCfvoType.MIN || this.cfvo.getType() == STCfvoType.MAX)
/*    */     {
/*    */       
/* 62 */       return null;
/*    */     }
/* 64 */     if (this.cfvo.isSetVal()) {
/* 65 */       return Double.valueOf(Double.parseDouble(this.cfvo.getVal()));
/*    */     }
/* 67 */     return null;
/*    */   }
/*    */   
/*    */   public void setValue(Double paramDouble) {
/* 71 */     if (paramDouble == null) {
/* 72 */       this.cfvo.unsetVal();
/*    */     } else {
/* 74 */       this.cfvo.setVal(paramDouble.toString());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFConditionalFormattingThreshold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */