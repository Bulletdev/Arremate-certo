/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.formula.SheetNameFormatter;
/*    */ import org.apache.poi.ss.usermodel.FormulaError;
/*    */ import org.apache.poi.util.LittleEndianOutput;
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
/*    */ public final class Deleted3DPxg
/*    */   extends OperandPtg
/*    */   implements Pxg
/*    */ {
/* 29 */   private int externalWorkbookNumber = -1;
/*    */   private String sheetName;
/*    */   
/*    */   public Deleted3DPxg(int paramInt, String paramString) {
/* 33 */     this.externalWorkbookNumber = paramInt;
/* 34 */     this.sheetName = paramString;
/*    */   }
/*    */   public Deleted3DPxg(String paramString) {
/* 37 */     this(-1, paramString);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 41 */     StringBuffer stringBuffer = new StringBuffer();
/* 42 */     stringBuffer.append(getClass().getName());
/* 43 */     stringBuffer.append(" [");
/* 44 */     if (this.externalWorkbookNumber >= 0) {
/* 45 */       stringBuffer.append(" [");
/* 46 */       stringBuffer.append("workbook=").append(getExternalWorkbookNumber());
/* 47 */       stringBuffer.append("] ");
/*    */     } 
/* 49 */     stringBuffer.append("sheet=").append(getSheetName());
/* 50 */     stringBuffer.append(" ! ");
/* 51 */     stringBuffer.append(FormulaError.REF.getString());
/* 52 */     stringBuffer.append("]");
/* 53 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public int getExternalWorkbookNumber() {
/* 57 */     return this.externalWorkbookNumber;
/*    */   }
/*    */   public String getSheetName() {
/* 60 */     return this.sheetName;
/*    */   }
/*    */   
/*    */   public void setSheetName(String paramString) {
/* 64 */     this.sheetName = paramString;
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 68 */     StringBuffer stringBuffer = new StringBuffer();
/* 69 */     if (this.externalWorkbookNumber >= 0) {
/* 70 */       stringBuffer.append('[');
/* 71 */       stringBuffer.append(this.externalWorkbookNumber);
/* 72 */       stringBuffer.append(']');
/*    */     } 
/* 74 */     if (this.sheetName != null) {
/* 75 */       SheetNameFormatter.appendFormat(stringBuffer, this.sheetName);
/*    */     }
/* 77 */     stringBuffer.append('!');
/* 78 */     stringBuffer.append(FormulaError.REF.getString());
/* 79 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public byte getDefaultOperandClass() {
/* 83 */     return 32;
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 87 */     return 1;
/*    */   }
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 90 */     throw new IllegalStateException("XSSF-only Ptg, should not be serialised");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\Deleted3DPxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */