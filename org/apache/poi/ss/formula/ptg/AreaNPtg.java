/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.util.LittleEndianInput;
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
/*    */ public final class AreaNPtg
/*    */   extends Area2DPtgBase
/*    */ {
/*    */   public static final short sid = 45;
/*    */   
/*    */   public AreaNPtg(LittleEndianInput paramLittleEndianInput) {
/* 30 */     super(paramLittleEndianInput);
/*    */   }
/*    */   
/*    */   protected byte getSid() {
/* 34 */     return 45;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\AreaNPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */