/*    */ package org.apache.poi.ss.formula;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IStabilityClassifier
/*    */ {
/* 64 */   public static final IStabilityClassifier TOTALLY_IMMUTABLE = new IStabilityClassifier() {
/*    */       public boolean isCellFinal(int param1Int1, int param1Int2, int param1Int3) {
/* 66 */         return true;
/*    */       }
/*    */     };
/*    */   
/*    */   boolean isCellFinal(int paramInt1, int paramInt2, int paramInt3);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\IStabilityClassifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */