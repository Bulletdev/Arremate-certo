/*    */ package org.apache.poi.ss.formula.ptg;
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
/*    */ public abstract class ControlPtg
/*    */   extends Ptg
/*    */ {
/*    */   public boolean isBaseToken() {
/* 33 */     return true;
/*    */   }
/*    */   public final byte getDefaultOperandClass() {
/* 36 */     throw new IllegalStateException("Control tokens are not classified");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\ControlPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */