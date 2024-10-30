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
/*    */ 
/*    */ public final class FuncVarPtg
/*    */   extends AbstractFunctionPtg
/*    */ {
/*    */   public static final byte sid = 34;
/*    */   private static final int SIZE = 4;
/* 35 */   public static final OperationPtg SUM = create("SUM", 1);
/*    */   
/*    */   private FuncVarPtg(int paramInt1, int paramInt2, byte[] paramArrayOfbyte, int paramInt3) {
/* 38 */     super(paramInt1, paramInt2, paramArrayOfbyte, paramInt3);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static FuncVarPtg create(LittleEndianInput paramLittleEndianInput) {
/* 45 */     return create(paramLittleEndianInput.readByte(), paramLittleEndianInput.readShort());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static FuncVarPtg create(String paramString, int paramInt) {
/* 52 */     return create(paramInt, lookupIndex(paramString));
/*    */   }
/*    */   
/*    */   private static FuncVarPtg create(int paramInt1, int paramInt2) {
/* 56 */     FunctionMetadata functionMetadata = FunctionMetadataRegistry.getFunctionByIndex(paramInt2);
/* 57 */     if (functionMetadata == null)
/*    */     {
/* 59 */       return new FuncVarPtg(paramInt2, 32, new byte[] { 32 }, paramInt1);
/*    */     }
/* 61 */     return new FuncVarPtg(paramInt2, functionMetadata.getReturnClassCode(), functionMetadata.getParameterClassCodes(), paramInt1);
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 65 */     paramLittleEndianOutput.writeByte(34 + getPtgClass());
/* 66 */     paramLittleEndianOutput.writeByte(getNumberOfOperands());
/* 67 */     paramLittleEndianOutput.writeShort(getFunctionIndex());
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 71 */     return 4;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\FuncVarPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */