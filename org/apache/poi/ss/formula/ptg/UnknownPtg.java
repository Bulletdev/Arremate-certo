/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
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
/*    */ public class UnknownPtg
/*    */   extends Ptg
/*    */ {
/* 26 */   private short size = 1;
/*    */   private final int _sid;
/*    */   
/*    */   public UnknownPtg(int paramInt) {
/* 30 */     this._sid = paramInt;
/*    */   }
/*    */   
/*    */   public boolean isBaseToken() {
/* 34 */     return true;
/*    */   }
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 37 */     paramLittleEndianOutput.writeByte(this._sid);
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 41 */     return this.size;
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 45 */     return "UNKNOWN";
/*    */   }
/*    */   public byte getDefaultOperandClass() {
/* 48 */     return 32;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\UnknownPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */