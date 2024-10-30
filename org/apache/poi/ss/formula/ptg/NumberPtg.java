/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.util.NumberToTextConverter;
/*    */ import org.apache.poi.util.LittleEndianInput;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class NumberPtg
/*    */   extends ScalarConstantPtg
/*    */ {
/*    */   public static final int SIZE = 9;
/*    */   public static final byte sid = 31;
/*    */   private final double field_1_value;
/*    */   
/*    */   public NumberPtg(LittleEndianInput paramLittleEndianInput) {
/* 37 */     this(paramLittleEndianInput.readDouble());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NumberPtg(String paramString) {
/* 48 */     this(Double.parseDouble(paramString));
/*    */   }
/*    */   
/*    */   public NumberPtg(double paramDouble) {
/* 52 */     this.field_1_value = paramDouble;
/*    */   }
/*    */   
/*    */   public double getValue() {
/* 56 */     return this.field_1_value;
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 60 */     paramLittleEndianOutput.writeByte(31 + getPtgClass());
/* 61 */     paramLittleEndianOutput.writeDouble(getValue());
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 65 */     return 9;
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 69 */     return NumberToTextConverter.toText(this.field_1_value);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\NumberPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */