/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Memory;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import com.sun.jna.ptr.PointerByReference;
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
/*    */ public class VersionUtil
/*    */ {
/*    */   public static VerRsrc.VS_FIXEDFILEINFO getFileVersionInfo(String paramString) {
/* 55 */     IntByReference intByReference1 = new IntByReference();
/*    */     
/* 57 */     int i = Version.INSTANCE.GetFileVersionInfoSize(paramString, intByReference1);
/*    */ 
/*    */ 
/*    */     
/* 61 */     if (i == 0) {
/* 62 */       throw new Win32Exception(Native.getLastError());
/*    */     }
/*    */ 
/*    */     
/* 66 */     Memory memory = new Memory(i);
/*    */ 
/*    */     
/* 69 */     PointerByReference pointerByReference = new PointerByReference();
/*    */     
/* 71 */     if (!Version.INSTANCE.GetFileVersionInfo(paramString, 0, i, (Pointer)memory)) {
/* 72 */       throw new Win32Exception(Native.getLastError());
/*    */     }
/*    */ 
/*    */     
/* 76 */     IntByReference intByReference2 = new IntByReference();
/*    */ 
/*    */     
/* 79 */     if (!Version.INSTANCE.VerQueryValue((Pointer)memory, "\\", pointerByReference, intByReference2)) {
/* 80 */       throw new UnsupportedOperationException("Unable to extract version info from the file: \"" + paramString + "\"");
/*    */     }
/*    */     
/* 83 */     VerRsrc.VS_FIXEDFILEINFO vS_FIXEDFILEINFO = new VerRsrc.VS_FIXEDFILEINFO(pointerByReference.getValue());
/* 84 */     vS_FIXEDFILEINFO.read();
/* 85 */     return vS_FIXEDFILEINFO;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\VersionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */