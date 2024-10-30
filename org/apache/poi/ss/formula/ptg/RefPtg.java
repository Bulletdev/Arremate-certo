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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RefPtg
/*    */   extends Ref2DPtgBase
/*    */ {
/*    */   public static final byte sid = 36;
/*    */   
/*    */   public RefPtg(String paramString) {
/* 36 */     super(new CellReference(paramString));
/*    */   }
/*    */   
/*    */   public RefPtg(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/* 40 */     super(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
/*    */   }
/*    */   
/*    */   public RefPtg(LittleEndianInput paramLittleEndianInput) {
/* 44 */     super(paramLittleEndianInput);
/*    */   }
/*    */   
/*    */   public RefPtg(CellReference paramCellReference) {
/* 48 */     super(paramCellReference);
/*    */   }
/*    */   
/*    */   protected byte getSid() {
/* 52 */     return 36;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\RefPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */