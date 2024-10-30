/*    */ package com.sun.jna.platform.mac;
/*    */ 
/*    */ import com.sun.jna.Library;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
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
/*    */ interface XAttr
/*    */   extends Library
/*    */ {
/* 37 */   public static final XAttr INSTANCE = (XAttr)Native.load(null, XAttr.class);
/*    */   public static final int XATTR_NOFOLLOW = 1;
/*    */   public static final int XATTR_CREATE = 2;
/*    */   public static final int XATTR_REPLACE = 4;
/*    */   public static final int XATTR_NOSECURITY = 8;
/*    */   public static final int XATTR_NODEFAULT = 16;
/*    */   public static final int XATTR_SHOWCOMPRESSION = 32;
/*    */   public static final int XATTR_MAXNAMELEN = 127;
/*    */   public static final String XATTR_FINDERINFO_NAME = "com.apple.FinderInfo";
/*    */   public static final String XATTR_RESOURCEFORK_NAME = "com.apple.ResourceFork";
/*    */   
/*    */   long getxattr(String paramString1, String paramString2, Pointer paramPointer, long paramLong, int paramInt1, int paramInt2);
/*    */   
/*    */   int setxattr(String paramString1, String paramString2, Pointer paramPointer, long paramLong, int paramInt1, int paramInt2);
/*    */   
/*    */   int removexattr(String paramString1, String paramString2, int paramInt);
/*    */   
/*    */   long listxattr(String paramString, Pointer paramPointer, long paramLong, int paramInt);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\mac\XAttr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */