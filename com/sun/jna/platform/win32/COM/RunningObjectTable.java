/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.win32.WinBase;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RunningObjectTable
/*     */   extends Unknown
/*     */   implements IRunningObjectTable
/*     */ {
/*     */   public static class ByReference
/*     */     extends RunningObjectTable
/*     */     implements Structure.ByReference {}
/*     */   
/*     */   public RunningObjectTable() {}
/*     */   
/*     */   public RunningObjectTable(Pointer paramPointer) {
/*  44 */     super(paramPointer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT Register(WinDef.DWORD paramDWORD, Pointer paramPointer1, Pointer paramPointer2, WinDef.DWORDByReference paramDWORDByReference) {
/*  53 */     byte b = 3;
/*     */     
/*  55 */     return (WinNT.HRESULT)_invokeNativeObject(3, new Object[] { getPointer(), paramDWORD, paramPointer1, paramPointer2, paramDWORDByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT Revoke(WinDef.DWORD paramDWORD) {
/*  63 */     byte b = 4;
/*     */     
/*  65 */     return (WinNT.HRESULT)_invokeNativeObject(4, new Object[] { getPointer(), paramDWORD }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT IsRunning(Pointer paramPointer) {
/*  73 */     byte b = 5;
/*     */     
/*  75 */     return (WinNT.HRESULT)_invokeNativeObject(5, new Object[] { getPointer(), paramPointer }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetObject(Pointer paramPointer, PointerByReference paramPointerByReference) {
/*  83 */     byte b = 6;
/*     */     
/*  85 */     return (WinNT.HRESULT)_invokeNativeObject(6, new Object[] { getPointer(), paramPointer, paramPointerByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT NoteChangeTime(WinDef.DWORD paramDWORD, WinBase.FILETIME paramFILETIME) {
/*  93 */     byte b = 7;
/*     */     
/*  95 */     return (WinNT.HRESULT)_invokeNativeObject(7, new Object[] { getPointer(), paramDWORD, paramFILETIME }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetTimeOfLastChange(Pointer paramPointer, WinBase.FILETIME.ByReference paramByReference) {
/* 103 */     byte b = 8;
/*     */     
/* 105 */     return (WinNT.HRESULT)_invokeNativeObject(8, new Object[] { getPointer(), paramPointer, paramByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT EnumRunning(PointerByReference paramPointerByReference) {
/* 113 */     byte b = 9;
/*     */     
/* 115 */     return (WinNT.HRESULT)_invokeNativeObject(9, new Object[] { getPointer(), paramPointerByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\RunningObjectTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */