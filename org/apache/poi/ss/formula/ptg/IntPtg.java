/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class IntPtg
/*    */   extends ScalarConstantPtg
/*    */ {
/*    */   private static final int MIN_VALUE = 0;
/*    */   private static final int MAX_VALUE = 65535;
/*    */   public static final int SIZE = 3;
/*    */   public static final byte sid = 30;
/*    */   private final int field_1_value;
/*    */   
/*    */   public static boolean isInRange(int paramInt) {
/* 42 */     return (paramInt >= 0 && paramInt <= 65535);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IntPtg(LittleEndianInput paramLittleEndianInput) {
/* 50 */     this(paramLittleEndianInput.readUShort());
/*    */   }
/*    */   
/*    */   public IntPtg(int paramInt) {
/* 54 */     if (!isInRange(paramInt)) {
/* 55 */       throw new IllegalArgumentException("value is out of range: " + paramInt);
/*    */     }
/* 57 */     this.field_1_value = paramInt;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 61 */     return this.field_1_value;
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 65 */     paramLittleEndianOutput.writeByte(30 + getPtgClass());
/* 66 */     paramLittleEndianOutput.writeShort(getValue());
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 70 */     return 3;
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 74 */     return String.valueOf(getValue());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\IntPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */