/*    */ package org.apache.poi.hssf.util;
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
/*    */ public final class RKUtil
/*    */ {
/*    */   public static double decodeNumber(int paramInt) {
/* 36 */     long l = paramInt;
/*    */ 
/*    */ 
/*    */     
/* 40 */     l >>= 2L;
/* 41 */     double d = 0.0D;
/*    */     
/* 43 */     if ((paramInt & 0x2) == 2) {
/*    */ 
/*    */ 
/*    */       
/* 47 */       d = l;
/*    */ 
/*    */     
/*    */     }
/*    */     else {
/*    */ 
/*    */ 
/*    */       
/* 55 */       d = Double.longBitsToDouble(l << 34L);
/*    */     } 
/* 57 */     if ((paramInt & 0x1) == 1)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 63 */       d /= 100.0D;
/*    */     }
/*    */     
/* 66 */     return d;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\util\RKUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */