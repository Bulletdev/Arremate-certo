/*    */ package org.h2.compress;
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
/*    */ public class CompressNo
/*    */   implements Compressor
/*    */ {
/*    */   public int getAlgorithm() {
/* 17 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setOptions(String paramString) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public int compress(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2) {
/* 27 */     System.arraycopy(paramArrayOfbyte1, 0, paramArrayOfbyte2, paramInt2, paramInt1);
/* 28 */     return paramInt2 + paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void expand(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, int paramInt4) {
/* 34 */     System.arraycopy(paramArrayOfbyte1, paramInt1, paramArrayOfbyte2, paramInt3, paramInt4);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\compress\CompressNo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */