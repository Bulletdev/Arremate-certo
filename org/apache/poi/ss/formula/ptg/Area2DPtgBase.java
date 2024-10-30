/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.util.AreaReference;
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
/*    */ public abstract class Area2DPtgBase
/*    */   extends AreaPtgBase
/*    */ {
/*    */   private static final int SIZE = 9;
/*    */   
/*    */   protected Area2DPtgBase(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/* 31 */     super(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*    */   }
/*    */   protected Area2DPtgBase(AreaReference paramAreaReference) {
/* 34 */     super(paramAreaReference);
/*    */   }
/*    */   
/*    */   protected Area2DPtgBase(LittleEndianInput paramLittleEndianInput) {
/* 38 */     readCoordinates(paramLittleEndianInput);
/*    */   }
/*    */   
/*    */   protected abstract byte getSid();
/*    */   
/*    */   public final void write(LittleEndianOutput paramLittleEndianOutput) {
/* 44 */     paramLittleEndianOutput.writeByte(getSid() + getPtgClass());
/* 45 */     writeCoordinates(paramLittleEndianOutput);
/*    */   }
/*    */   
/*    */   public final int getSize() {
/* 49 */     return 9;
/*    */   }
/*    */   
/*    */   public final String toFormulaString() {
/* 53 */     return formatReferenceAsString();
/*    */   }
/*    */   
/*    */   public final String toString() {
/* 57 */     StringBuffer stringBuffer = new StringBuffer();
/* 58 */     stringBuffer.append(getClass().getName());
/* 59 */     stringBuffer.append(" [");
/* 60 */     stringBuffer.append(formatReferenceAsString());
/* 61 */     stringBuffer.append("]");
/* 62 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\Area2DPtgBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */