/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.util.AreaReference;
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
/*    */ public final class AreaPtg
/*    */   extends Area2DPtgBase
/*    */ {
/*    */   public static final short sid = 37;
/*    */   
/*    */   public AreaPtg(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/* 31 */     super(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*    */   }
/*    */   public AreaPtg(LittleEndianInput paramLittleEndianInput) {
/* 34 */     super(paramLittleEndianInput);
/*    */   }
/*    */   public AreaPtg(String paramString) {
/* 37 */     super(new AreaReference(paramString));
/*    */   }
/*    */   public AreaPtg(AreaReference paramAreaReference) {
/* 40 */     super(paramAreaReference);
/*    */   }
/*    */   
/*    */   protected byte getSid() {
/* 44 */     return 37;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\AreaPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */