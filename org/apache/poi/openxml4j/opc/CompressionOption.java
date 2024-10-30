/*    */ package org.apache.poi.openxml4j.opc;
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
/*    */ public enum CompressionOption
/*    */ {
/* 30 */   FAST(1),
/*    */   
/* 32 */   MAXIMUM(9),
/*    */   
/* 34 */   NORMAL(-1),
/*    */   
/* 36 */   NOT_COMPRESSED(0);
/*    */   
/*    */   private final int value;
/*    */   
/*    */   CompressionOption(int paramInt1) {
/* 41 */     this.value = paramInt1;
/*    */   }
/*    */   
/*    */   public int value() {
/* 45 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\CompressionOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */