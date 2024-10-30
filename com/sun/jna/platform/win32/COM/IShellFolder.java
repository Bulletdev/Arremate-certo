/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.Function;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.ShTypes;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.IntByReference;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface IShellFolder
/*     */ {
/*  47 */   public static final Guid.IID IID_ISHELLFOLDER = new Guid.IID("{000214E6-0000-0000-C000-000000000046}");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT QueryInterface(Guid.REFIID paramREFIID, PointerByReference paramPointerByReference);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int AddRef();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int Release();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT ParseDisplayName(WinDef.HWND paramHWND, Pointer paramPointer, String paramString, IntByReference paramIntByReference1, PointerByReference paramPointerByReference, IntByReference paramIntByReference2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT EnumObjects(WinDef.HWND paramHWND, int paramInt, PointerByReference paramPointerByReference);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT BindToObject(Pointer paramPointer1, Pointer paramPointer2, Guid.REFIID paramREFIID, PointerByReference paramPointerByReference);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT BindToStorage(Pointer paramPointer1, Pointer paramPointer2, Guid.REFIID paramREFIID, PointerByReference paramPointerByReference);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT CompareIDs(WinDef.LPARAM paramLPARAM, Pointer paramPointer1, Pointer paramPointer2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT CreateViewObject(WinDef.HWND paramHWND, Guid.REFIID paramREFIID, PointerByReference paramPointerByReference);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT GetAttributesOf(int paramInt, Pointer paramPointer, IntByReference paramIntByReference);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT GetUIObjectOf(WinDef.HWND paramHWND, int paramInt, Pointer paramPointer, Guid.REFIID paramREFIID, IntByReference paramIntByReference, PointerByReference paramPointerByReference);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT GetDisplayNameOf(Pointer paramPointer, int paramInt, ShTypes.STRRET paramSTRRET);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SetNameOf(WinDef.HWND paramHWND, Pointer paramPointer, String paramString, int paramInt, PointerByReference paramPointerByReference);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Converter
/*     */   {
/*     */     public static IShellFolder PointerToIShellFolder(PointerByReference param1PointerByReference) {
/* 458 */       final Pointer interfacePointer = param1PointerByReference.getValue();
/* 459 */       Pointer pointer2 = pointer1.getPointer(0L);
/* 460 */       final Pointer[] vTable = new Pointer[13];
/* 461 */       pointer2.read(0L, arrayOfPointer, 0, 13);
/* 462 */       return new IShellFolder()
/*     */         {
/*     */           public WinNT.HRESULT QueryInterface(Guid.REFIID param2REFIID, PointerByReference param2PointerByReference)
/*     */           {
/* 466 */             Function function = Function.getFunction(vTable[0], 63);
/* 467 */             return new WinNT.HRESULT(function.invokeInt(new Object[] { this.val$interfacePointer, param2REFIID, param2PointerByReference }));
/*     */           }
/*     */ 
/*     */           
/*     */           public int AddRef() {
/* 472 */             Function function = Function.getFunction(vTable[1], 63);
/* 473 */             return function.invokeInt(new Object[] { this.val$interfacePointer });
/*     */           }
/*     */           
/*     */           public int Release() {
/* 477 */             Function function = Function.getFunction(vTable[2], 63);
/* 478 */             return function.invokeInt(new Object[] { this.val$interfacePointer });
/*     */           }
/*     */ 
/*     */           
/*     */           public WinNT.HRESULT ParseDisplayName(WinDef.HWND param2HWND, Pointer param2Pointer, String param2String, IntByReference param2IntByReference1, PointerByReference param2PointerByReference, IntByReference param2IntByReference2) {
/* 483 */             Function function = Function.getFunction(vTable[3], 63);
/*     */ 
/*     */             
/* 486 */             char[] arrayOfChar = Native.toCharArray(param2String);
/* 487 */             return new WinNT.HRESULT(function.invokeInt(new Object[] { this.val$interfacePointer, param2HWND, param2Pointer, arrayOfChar, param2IntByReference1, param2PointerByReference, param2IntByReference2 }));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public WinNT.HRESULT EnumObjects(WinDef.HWND param2HWND, int param2Int, PointerByReference param2PointerByReference) {
/* 493 */             Function function = Function.getFunction(vTable[4], 63);
/* 494 */             return new WinNT.HRESULT(function.invokeInt(new Object[] { this.val$interfacePointer, param2HWND, Integer.valueOf(param2Int), param2PointerByReference }));
/*     */           }
/*     */           
/*     */           public WinNT.HRESULT BindToObject(Pointer param2Pointer1, Pointer param2Pointer2, Guid.REFIID param2REFIID, PointerByReference param2PointerByReference) {
/* 498 */             Function function = Function.getFunction(vTable[5], 63);
/* 499 */             return new WinNT.HRESULT(function.invokeInt(new Object[] { this.val$interfacePointer, param2Pointer1, param2Pointer2, param2REFIID, param2PointerByReference }));
/*     */           }
/*     */ 
/*     */           
/*     */           public WinNT.HRESULT BindToStorage(Pointer param2Pointer1, Pointer param2Pointer2, Guid.REFIID param2REFIID, PointerByReference param2PointerByReference) {
/* 504 */             Function function = Function.getFunction(vTable[6], 63);
/* 505 */             return new WinNT.HRESULT(function.invokeInt(new Object[] { this.val$interfacePointer, param2Pointer1, param2Pointer2, param2REFIID, param2PointerByReference }));
/*     */           }
/*     */ 
/*     */           
/*     */           public WinNT.HRESULT CompareIDs(WinDef.LPARAM param2LPARAM, Pointer param2Pointer1, Pointer param2Pointer2) {
/* 510 */             Function function = Function.getFunction(vTable[7], 63);
/* 511 */             return new WinNT.HRESULT(function.invokeInt(new Object[] { this.val$interfacePointer, param2LPARAM, param2Pointer1, param2Pointer2 }));
/*     */           }
/*     */ 
/*     */           
/*     */           public WinNT.HRESULT CreateViewObject(WinDef.HWND param2HWND, Guid.REFIID param2REFIID, PointerByReference param2PointerByReference) {
/* 516 */             Function function = Function.getFunction(vTable[8], 63);
/* 517 */             return new WinNT.HRESULT(function.invokeInt(new Object[] { this.val$interfacePointer, param2HWND, param2REFIID, param2PointerByReference }));
/*     */           }
/*     */ 
/*     */           
/*     */           public WinNT.HRESULT GetAttributesOf(int param2Int, Pointer param2Pointer, IntByReference param2IntByReference) {
/* 522 */             Function function = Function.getFunction(vTable[9], 63);
/* 523 */             return new WinNT.HRESULT(function.invokeInt(new Object[] { this.val$interfacePointer, Integer.valueOf(param2Int), param2Pointer, param2IntByReference }));
/*     */           }
/*     */ 
/*     */           
/*     */           public WinNT.HRESULT GetUIObjectOf(WinDef.HWND param2HWND, int param2Int, Pointer param2Pointer, Guid.REFIID param2REFIID, IntByReference param2IntByReference, PointerByReference param2PointerByReference) {
/* 528 */             Function function = Function.getFunction(vTable[10], 63);
/* 529 */             return new WinNT.HRESULT(function.invokeInt(new Object[] { this.val$interfacePointer, param2HWND, Integer.valueOf(param2Int), param2Pointer, param2REFIID, param2IntByReference, param2PointerByReference }));
/*     */           }
/*     */           
/*     */           public WinNT.HRESULT GetDisplayNameOf(Pointer param2Pointer, int param2Int, ShTypes.STRRET param2STRRET) {
/* 533 */             Function function = Function.getFunction(vTable[11], 63);
/* 534 */             return new WinNT.HRESULT(function.invokeInt(new Object[] { this.val$interfacePointer, param2Pointer, Integer.valueOf(param2Int), param2STRRET }));
/*     */           }
/*     */ 
/*     */           
/*     */           public WinNT.HRESULT SetNameOf(WinDef.HWND param2HWND, Pointer param2Pointer, String param2String, int param2Int, PointerByReference param2PointerByReference) {
/* 539 */             Function function = Function.getFunction(vTable[12], 63);
/* 540 */             return new WinNT.HRESULT(function.invokeInt(new Object[] { this.val$interfacePointer, param2HWND, param2Pointer, param2String, Integer.valueOf(param2Int), param2PointerByReference }));
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\IShellFolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */