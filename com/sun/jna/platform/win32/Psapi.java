/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.Structure.FieldOrder;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface Psapi
/*    */   extends StdCallLibrary
/*    */ {
/* 46 */   public static final Psapi INSTANCE = (Psapi)Native.load("psapi", Psapi.class, W32APIOptions.DEFAULT_OPTIONS);
/*    */   
/*    */   int GetModuleFileNameExA(WinNT.HANDLE paramHANDLE1, WinNT.HANDLE paramHANDLE2, byte[] paramArrayOfbyte, int paramInt);
/*    */   
/*    */   int GetModuleFileNameExW(WinNT.HANDLE paramHANDLE1, WinNT.HANDLE paramHANDLE2, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   int GetModuleFileNameEx(WinNT.HANDLE paramHANDLE1, WinNT.HANDLE paramHANDLE2, Pointer paramPointer, int paramInt);
/*    */   
/*    */   boolean EnumProcessModules(WinNT.HANDLE paramHANDLE, WinDef.HMODULE[] paramArrayOfHMODULE, int paramInt, IntByReference paramIntByReference);
/*    */   
/*    */   boolean GetModuleInformation(WinNT.HANDLE paramHANDLE, WinDef.HMODULE paramHMODULE, MODULEINFO paramMODULEINFO, int paramInt);
/*    */   
/*    */   int GetProcessImageFileName(WinNT.HANDLE paramHANDLE, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   boolean GetPerformanceInfo(PERFORMANCE_INFORMATION paramPERFORMANCE_INFORMATION, int paramInt);
/*    */   
/*    */   boolean EnumProcesses(int[] paramArrayOfint, int paramInt, IntByReference paramIntByReference);
/*    */   
/*    */   @FieldOrder({"lpBaseOfDll", "SizeOfImage", "EntryPoint"})
/*    */   public static class MODULEINFO extends Structure {
/*    */     public Pointer EntryPoint;
/*    */     public Pointer lpBaseOfDll;
/*    */     public int SizeOfImage;
/*    */   }
/*    */   
/*    */   @FieldOrder({"cb", "CommitTotal", "CommitLimit", "CommitPeak", "PhysicalTotal", "PhysicalAvailable", "SystemCache", "KernelTotal", "KernelPaged", "KernelNonpaged", "PageSize", "HandleCount", "ProcessCount", "ThreadCount"})
/*    */   public static class PERFORMANCE_INFORMATION extends Structure {
/*    */     public WinDef.DWORD cb;
/*    */     public BaseTSD.SIZE_T CommitTotal;
/*    */     public BaseTSD.SIZE_T CommitLimit;
/*    */     public BaseTSD.SIZE_T CommitPeak;
/*    */     public BaseTSD.SIZE_T PhysicalTotal;
/*    */     public BaseTSD.SIZE_T PhysicalAvailable;
/*    */     public BaseTSD.SIZE_T SystemCache;
/*    */     public BaseTSD.SIZE_T KernelTotal;
/*    */     public BaseTSD.SIZE_T KernelPaged;
/*    */     public BaseTSD.SIZE_T KernelNonpaged;
/*    */     public BaseTSD.SIZE_T PageSize;
/*    */     public WinDef.DWORD HandleCount;
/*    */     public WinDef.DWORD ProcessCount;
/*    */     public WinDef.DWORD ThreadCount;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Psapi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */