/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import com.sun.jna.win32.StdCallLibrary;
/*    */ import com.sun.jna.win32.W32APIOptions;
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
/*    */ public interface NtDll
/*    */   extends StdCallLibrary
/*    */ {
/* 40 */   public static final NtDll INSTANCE = (NtDll)Native.load("NtDll", NtDll.class, W32APIOptions.DEFAULT_OPTIONS);
/*    */   
/*    */   int ZwQueryKey(WinNT.HANDLE paramHANDLE, int paramInt1, Structure paramStructure, int paramInt2, IntByReference paramIntByReference);
/*    */   
/*    */   int NtSetSecurityObject(WinNT.HANDLE paramHANDLE, int paramInt, Pointer paramPointer);
/*    */   
/*    */   int NtQuerySecurityObject(WinNT.HANDLE paramHANDLE, int paramInt1, Pointer paramPointer, int paramInt2, IntByReference paramIntByReference);
/*    */   
/*    */   int RtlNtStatusToDosError(int paramInt);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\NtDll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */