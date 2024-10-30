/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.util.CellReference;
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
/*    */ abstract class Ref2DPtgBase
/*    */   extends RefPtgBase
/*    */ {
/*    */   private static final int SIZE = 5;
/*    */   
/*    */   protected Ref2DPtgBase(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/* 32 */     setRow(paramInt1);
/* 33 */     setColumn(paramInt2);
/* 34 */     setRowRelative(paramBoolean1);
/* 35 */     setColRelative(paramBoolean2);
/*    */   }
/*    */   
/*    */   protected Ref2DPtgBase(LittleEndianInput paramLittleEndianInput) {
/* 39 */     readCoordinates(paramLittleEndianInput);
/*    */   }
/*    */   
/*    */   protected Ref2DPtgBase(CellReference paramCellReference) {
/* 43 */     super(paramCellReference);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 48 */     paramLittleEndianOutput.writeByte(getSid() + getPtgClass());
/* 49 */     writeCoordinates(paramLittleEndianOutput);
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toFormulaString() {
/* 54 */     return formatReferenceAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract byte getSid();
/*    */   
/*    */   public final int getSize() {
/* 61 */     return 5;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 66 */     StringBuffer stringBuffer = new StringBuffer();
/* 67 */     stringBuffer.append(getClass().getName());
/* 68 */     stringBuffer.append(" [");
/* 69 */     stringBuffer.append(formatReferenceAsString());
/* 70 */     stringBuffer.append("]");
/* 71 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\Ref2DPtgBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */