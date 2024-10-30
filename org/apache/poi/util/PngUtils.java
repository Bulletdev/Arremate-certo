/*    */ package org.apache.poi.util;
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
/*    */ public final class PngUtils
/*    */ {
/* 26 */   private static final byte[] PNG_FILE_HEADER = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
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
/*    */   public static boolean matchesPngHeader(byte[] paramArrayOfbyte, int paramInt) {
/* 41 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length - paramInt < PNG_FILE_HEADER.length) {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     for (byte b = 0; b < PNG_FILE_HEADER.length; b++) {
/* 46 */       if (PNG_FILE_HEADER[b] != paramArrayOfbyte[b + paramInt]) {
/* 47 */         return false;
/*    */       }
/*    */     } 
/*    */     
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\PngUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */