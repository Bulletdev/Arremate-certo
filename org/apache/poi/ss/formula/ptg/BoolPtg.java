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
/*    */ public final class BoolPtg
/*    */   extends ScalarConstantPtg
/*    */ {
/*    */   public static final int SIZE = 2;
/*    */   public static final byte sid = 29;
/* 34 */   private static final BoolPtg FALSE = new BoolPtg(false);
/* 35 */   private static final BoolPtg TRUE = new BoolPtg(true);
/*    */   
/*    */   private final boolean _value;
/*    */   
/*    */   private BoolPtg(boolean paramBoolean) {
/* 40 */     this._value = paramBoolean;
/*    */   }
/*    */   
/*    */   public static BoolPtg valueOf(boolean paramBoolean) {
/* 44 */     return paramBoolean ? TRUE : FALSE;
/*    */   }
/*    */   public static BoolPtg read(LittleEndianInput paramLittleEndianInput) {
/* 47 */     return valueOf((paramLittleEndianInput.readByte() == 1));
/*    */   }
/*    */   
/*    */   public boolean getValue() {
/* 51 */     return this._value;
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 55 */     paramLittleEndianOutput.writeByte(29 + getPtgClass());
/* 56 */     paramLittleEndianOutput.writeByte(this._value ? 1 : 0);
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 60 */     return 2;
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 64 */     return this._value ? "TRUE" : "FALSE";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\BoolPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */