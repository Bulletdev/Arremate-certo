/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.FormulaError;
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
/*    */ public final class ErrPtg
/*    */   extends ScalarConstantPtg
/*    */ {
/* 27 */   public static final ErrPtg NULL_INTERSECTION = new ErrPtg(FormulaError.NULL.getCode());
/*    */   
/* 29 */   public static final ErrPtg DIV_ZERO = new ErrPtg(FormulaError.DIV0.getCode());
/*    */   
/* 31 */   public static final ErrPtg VALUE_INVALID = new ErrPtg(FormulaError.VALUE.getCode());
/*    */   
/* 33 */   public static final ErrPtg REF_INVALID = new ErrPtg(FormulaError.REF.getCode());
/*    */   
/* 35 */   public static final ErrPtg NAME_INVALID = new ErrPtg(FormulaError.NAME.getCode());
/*    */   
/* 37 */   public static final ErrPtg NUM_ERROR = new ErrPtg(FormulaError.NUM.getCode());
/*    */   
/* 39 */   public static final ErrPtg N_A = new ErrPtg(FormulaError.NA.getCode());
/*    */   
/*    */   public static final short sid = 28;
/*    */   
/*    */   private static final int SIZE = 2;
/*    */   
/*    */   private final int field_1_error_code;
/*    */ 
/*    */   
/*    */   private ErrPtg(int paramInt) {
/* 49 */     if (!FormulaError.isValidCode(paramInt)) {
/* 50 */       throw new IllegalArgumentException("Invalid error code (" + paramInt + ")");
/*    */     }
/* 52 */     this.field_1_error_code = paramInt;
/*    */   }
/*    */   
/*    */   public static ErrPtg read(LittleEndianInput paramLittleEndianInput) {
/* 56 */     return valueOf(paramLittleEndianInput.readByte());
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 60 */     paramLittleEndianOutput.writeByte(28 + getPtgClass());
/* 61 */     paramLittleEndianOutput.writeByte(this.field_1_error_code);
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 65 */     return FormulaError.forInt(this.field_1_error_code).getString();
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 69 */     return 2;
/*    */   }
/*    */   
/*    */   public int getErrorCode() {
/* 73 */     return this.field_1_error_code;
/*    */   }
/*    */   
/*    */   public static ErrPtg valueOf(int paramInt) {
/* 77 */     switch (FormulaError.forInt(paramInt)) { case DIV0:
/* 78 */         return DIV_ZERO;
/* 79 */       case NA: return N_A;
/* 80 */       case NAME: return NAME_INVALID;
/* 81 */       case NULL: return NULL_INTERSECTION;
/* 82 */       case NUM: return NUM_ERROR;
/* 83 */       case REF: return REF_INVALID;
/* 84 */       case VALUE: return VALUE_INVALID; }
/*    */     
/* 86 */     throw new RuntimeException("Unexpected error code (" + paramInt + ")");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\ErrPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */