/*    */ package com.sun.jna.platform.linux;public interface XAttr extends Library { public static final int XATTR_CREATE = 1; public static final int XATTR_REPLACE = 2; public static final int EPERM = 1; public static final int E2BIG = 7; public static final int EEXIST = 17; public static final int ENOSPC = 28; public static final int ERANGE = 34; public static final int ENODATA = 61; public static final int ENOATTR = 61; public static final int ENOTSUP = 95; public static final int EDQUOT = 122;
/*    */   int setxattr(String paramString1, String paramString2, Pointer paramPointer, size_t paramsize_t, int paramInt);
/*    */   int setxattr(String paramString1, String paramString2, byte[] paramArrayOfbyte, size_t paramsize_t, int paramInt);
/*    */   int lsetxattr(String paramString1, String paramString2, Pointer paramPointer, size_t paramsize_t, int paramInt);
/*    */   int lsetxattr(String paramString1, String paramString2, byte[] paramArrayOfbyte, size_t paramsize_t, int paramInt);
/*    */   
/*    */   int fsetxattr(int paramInt1, String paramString, Pointer paramPointer, size_t paramsize_t, int paramInt2);
/*    */   
/*    */   int fsetxattr(int paramInt1, String paramString, byte[] paramArrayOfbyte, size_t paramsize_t, int paramInt2);
/*    */   
/*    */   ssize_t getxattr(String paramString1, String paramString2, Pointer paramPointer, size_t paramsize_t);
/*    */   
/*    */   ssize_t getxattr(String paramString1, String paramString2, byte[] paramArrayOfbyte, size_t paramsize_t);
/*    */   
/*    */   ssize_t lgetxattr(String paramString1, String paramString2, Pointer paramPointer, size_t paramsize_t);
/*    */   
/*    */   ssize_t lgetxattr(String paramString1, String paramString2, byte[] paramArrayOfbyte, size_t paramsize_t);
/*    */   
/*    */   ssize_t fgetxattr(int paramInt, String paramString, Pointer paramPointer, size_t paramsize_t);
/*    */   
/*    */   ssize_t fgetxattr(int paramInt, String paramString, byte[] paramArrayOfbyte, size_t paramsize_t);
/*    */   
/*    */   ssize_t listxattr(String paramString, Pointer paramPointer, size_t paramsize_t);
/*    */   
/*    */   ssize_t listxattr(String paramString, byte[] paramArrayOfbyte, size_t paramsize_t);
/*    */   
/*    */   ssize_t llistxattr(String paramString, Pointer paramPointer, size_t paramsize_t);
/*    */   
/*    */   ssize_t llistxattr(String paramString, byte[] paramArrayOfbyte, size_t paramsize_t);
/*    */   
/*    */   ssize_t flistxattr(int paramInt, Pointer paramPointer, size_t paramsize_t);
/*    */   
/* 33 */   public static final XAttr INSTANCE = (XAttr)Native.load(XAttr.class); ssize_t flistxattr(int paramInt, byte[] paramArrayOfbyte, size_t paramsize_t); int removexattr(String paramString1, String paramString2);
/*    */   int lremovexattr(String paramString1, String paramString2);
/*    */   int fremovexattr(int paramInt, String paramString);
/* 36 */   public static class size_t extends IntegerType { public static final size_t ZERO = new size_t();
/*    */     private static final long serialVersionUID = 1L;
/*    */     
/*    */     public size_t() {
/* 40 */       this(0L); } public size_t(long param1Long) {
/* 41 */       super(Native.SIZE_T_SIZE, param1Long, true);
/*    */     } }
/*    */   
/*    */   public static class ssize_t extends IntegerType {
/* 45 */     public static final ssize_t ZERO = new ssize_t();
/*    */     
/*    */     private static final long serialVersionUID = 1L;
/*    */     
/*    */     public ssize_t() {
/* 50 */       this(0L);
/*    */     }
/*    */     
/*    */     public ssize_t(long param1Long) {
/* 54 */       super(Native.SIZE_T_SIZE, param1Long, false);
/*    */     }
/*    */   } }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\linux\XAttr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */