/*    */ package com.sun.jna.platform.win32;
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
/*    */ public abstract class WinioctlUtil
/*    */ {
/*    */   public static int CTL_CODE(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 45 */     return paramInt1 << 16 | paramInt4 << 14 | paramInt2 << 2 | paramInt3;
/*    */   }
/*    */   
/* 48 */   public static final int FSCTL_GET_COMPRESSION = CTL_CODE(9, 15, 0, 0);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 54 */   public static final int FSCTL_SET_COMPRESSION = CTL_CODE(9, 16, 0, 3);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 60 */   public static final int FSCTL_SET_REPARSE_POINT = CTL_CODE(9, 41, 0, 0);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 66 */   public static final int FSCTL_GET_REPARSE_POINT = CTL_CODE(9, 42, 0, 0);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 72 */   public static final int FSCTL_DELETE_REPARSE_POINT = CTL_CODE(9, 43, 0, 0);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\WinioctlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */