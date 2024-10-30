/*    */ package com.sun.jna.platform.win32.COM;
/*    */ 
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.platform.win32.Guid;
/*    */ import com.sun.jna.platform.win32.WinBase;
/*    */ import com.sun.jna.platform.win32.WinDef;
/*    */ import com.sun.jna.platform.win32.WinNT;
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
/*    */ public interface IRunningObjectTable
/*    */   extends IUnknown
/*    */ {
/* 44 */   public static final Guid.IID IID = new Guid.IID("{00000010-0000-0000-C000-000000000046}");
/*    */   
/*    */   WinNT.HRESULT EnumRunning(PointerByReference paramPointerByReference);
/*    */   
/*    */   WinNT.HRESULT GetObject(Pointer paramPointer, PointerByReference paramPointerByReference);
/*    */   
/*    */   WinNT.HRESULT GetTimeOfLastChange(Pointer paramPointer, WinBase.FILETIME.ByReference paramByReference);
/*    */   
/*    */   WinNT.HRESULT IsRunning(Pointer paramPointer);
/*    */   
/*    */   WinNT.HRESULT NoteChangeTime(WinDef.DWORD paramDWORD, WinBase.FILETIME paramFILETIME);
/*    */   
/*    */   WinNT.HRESULT Register(WinDef.DWORD paramDWORD, Pointer paramPointer1, Pointer paramPointer2, WinDef.DWORDByReference paramDWORDByReference);
/*    */   
/*    */   WinNT.HRESULT Revoke(WinDef.DWORD paramDWORD);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\IRunningObjectTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */