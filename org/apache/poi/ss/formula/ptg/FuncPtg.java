/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.formula.function.FunctionMetadata;
/*    */ import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
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
/*    */ public final class FuncPtg
/*    */   extends AbstractFunctionPtg
/*    */ {
/*    */   public static final byte sid = 33;
/*    */   public static final int SIZE = 3;
/*    */   
/*    */   public static FuncPtg create(LittleEndianInput paramLittleEndianInput) {
/* 36 */     return create(paramLittleEndianInput.readUShort());
/*    */   }
/*    */   
/*    */   private FuncPtg(int paramInt, FunctionMetadata paramFunctionMetadata) {
/* 40 */     super(paramInt, paramFunctionMetadata.getReturnClassCode(), paramFunctionMetadata.getParameterClassCodes(), paramFunctionMetadata.getMinParams());
/*    */   }
/*    */   
/*    */   public static FuncPtg create(int paramInt) {
/* 44 */     FunctionMetadata functionMetadata = FunctionMetadataRegistry.getFunctionByIndex(paramInt);
/* 45 */     if (functionMetadata == null) {
/* 46 */       throw new RuntimeException("Invalid built-in function index (" + paramInt + ")");
/*    */     }
/* 48 */     return new FuncPtg(paramInt, functionMetadata);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 53 */     paramLittleEndianOutput.writeByte(33 + getPtgClass());
/* 54 */     paramLittleEndianOutput.writeShort(getFunctionIndex());
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 58 */     return 3;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\FuncPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */