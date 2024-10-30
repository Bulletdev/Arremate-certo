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
/*    */ public final class RefNPtg
/*    */   extends Ref2DPtgBase
/*    */ {
/*    */   public static final byte sid = 44;
/*    */   
/*    */   public RefNPtg(LittleEndianInput paramLittleEndianInput) {
/* 30 */     super(paramLittleEndianInput);
/*    */   }
/*    */   
/*    */   protected byte getSid() {
/* 34 */     return 44;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\RefNPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */