/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.WString;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.Ole32;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.Variant;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class COMBindingBaseObject
/*     */   extends COMInvoker
/*     */ {
/*  55 */   public static final WinDef.LCID LOCALE_USER_DEFAULT = Kernel32.INSTANCE
/*  56 */     .GetUserDefaultLCID();
/*     */ 
/*     */   
/*  59 */   public static final WinDef.LCID LOCALE_SYSTEM_DEFAULT = Kernel32.INSTANCE
/*  60 */     .GetSystemDefaultLCID();
/*     */ 
/*     */   
/*     */   private IUnknown iUnknown;
/*     */ 
/*     */   
/*     */   private IDispatch iDispatch;
/*     */ 
/*     */   
/*  69 */   private PointerByReference pDispatch = new PointerByReference();
/*     */ 
/*     */   
/*  72 */   private PointerByReference pUnknown = new PointerByReference();
/*     */ 
/*     */   
/*     */   public COMBindingBaseObject(IDispatch paramIDispatch) {
/*  76 */     this.iDispatch = paramIDispatch;
/*     */   }
/*     */   
/*     */   public COMBindingBaseObject(Guid.CLSID paramCLSID, boolean paramBoolean) {
/*  80 */     this(paramCLSID, paramBoolean, 21);
/*     */   }
/*     */ 
/*     */   
/*     */   public COMBindingBaseObject(Guid.CLSID paramCLSID, boolean paramBoolean, int paramInt) {
/*  85 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/*  87 */     init(paramBoolean, (Guid.GUID)paramCLSID, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public COMBindingBaseObject(String paramString, boolean paramBoolean, int paramInt) throws COMException {
/*  92 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/*  94 */     Guid.CLSID.ByReference byReference = new Guid.CLSID.ByReference();
/*  95 */     WinNT.HRESULT hRESULT = Ole32.INSTANCE.CLSIDFromProgID(paramString, byReference);
/*     */     
/*  97 */     COMUtils.checkRC(hRESULT);
/*     */     
/*  99 */     init(paramBoolean, (Guid.GUID)byReference, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public COMBindingBaseObject(String paramString, boolean paramBoolean) throws COMException {
/* 104 */     this(paramString, paramBoolean, 21);
/*     */   }
/*     */   
/*     */   private void init(boolean paramBoolean, Guid.GUID paramGUID, int paramInt) throws COMException {
/*     */     WinNT.HRESULT hRESULT;
/* 109 */     if (paramBoolean) {
/* 110 */       hRESULT = OleAuto.INSTANCE.GetActiveObject(paramGUID, null, this.pUnknown);
/*     */       
/* 112 */       if (COMUtils.SUCCEEDED(hRESULT)) {
/* 113 */         this.iUnknown = new Unknown(this.pUnknown.getValue());
/* 114 */         hRESULT = this.iUnknown.QueryInterface(new Guid.REFIID(IDispatch.IID_IDISPATCH), this.pDispatch);
/*     */       } else {
/*     */         
/* 117 */         hRESULT = Ole32.INSTANCE.CoCreateInstance(paramGUID, null, paramInt, (Guid.GUID)IDispatch.IID_IDISPATCH, this.pDispatch);
/*     */       } 
/*     */     } else {
/*     */       
/* 121 */       hRESULT = Ole32.INSTANCE.CoCreateInstance(paramGUID, null, paramInt, (Guid.GUID)IDispatch.IID_IDISPATCH, this.pDispatch);
/*     */     } 
/*     */ 
/*     */     
/* 125 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 127 */     this.iDispatch = new Dispatch(this.pDispatch.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDispatch getIDispatch() {
/* 136 */     return this.iDispatch;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerByReference getIDispatchPointer() {
/* 145 */     return this.pDispatch;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IUnknown getIUnknown() {
/* 154 */     return this.iUnknown;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerByReference getIUnknownPointer() {
/* 163 */     return this.pUnknown;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void release() {
/* 170 */     if (this.iDispatch != null) {
/* 171 */       this.iDispatch.Release();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, String paramString, Variant.VARIANT[] paramArrayOfVARIANT) throws COMException {
/* 179 */     WString[] arrayOfWString = { new WString(paramString) };
/* 180 */     OaIdl.DISPIDByReference dISPIDByReference = new OaIdl.DISPIDByReference();
/*     */ 
/*     */     
/* 183 */     WinNT.HRESULT hRESULT = this.iDispatch.GetIDsOfNames(new Guid.REFIID(Guid.IID_NULL), arrayOfWString, 1, LOCALE_USER_DEFAULT, dISPIDByReference);
/*     */ 
/*     */     
/* 186 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 188 */     return oleMethod(paramInt, paramByReference, dISPIDByReference.getValue(), paramArrayOfVARIANT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, OaIdl.DISPID paramDISPID, Variant.VARIANT[] paramArrayOfVARIANT) throws COMException {
/* 196 */     int j, i = 0;
/* 197 */     Variant.VARIANT[] arrayOfVARIANT = null;
/* 198 */     OleAuto.DISPPARAMS.ByReference byReference = new OleAuto.DISPPARAMS.ByReference();
/* 199 */     OaIdl.EXCEPINFO.ByReference byReference1 = new OaIdl.EXCEPINFO.ByReference();
/* 200 */     IntByReference intByReference = new IntByReference();
/*     */ 
/*     */     
/* 203 */     if (paramArrayOfVARIANT != null && paramArrayOfVARIANT.length > 0) {
/* 204 */       i = paramArrayOfVARIANT.length;
/* 205 */       arrayOfVARIANT = new Variant.VARIANT[i];
/*     */       
/* 207 */       j = i;
/* 208 */       for (byte b = 0; b < i; b++) {
/* 209 */         arrayOfVARIANT[b] = paramArrayOfVARIANT[--j];
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 214 */     if (paramInt == 4) {
/* 215 */       byReference.setRgdispidNamedArgs(new OaIdl.DISPID[] { OaIdl.DISPID_PROPERTYPUT });
/*     */     }
/*     */ 
/*     */     
/* 219 */     if (i > 0) {
/* 220 */       byReference.setArgs(arrayOfVARIANT);
/*     */ 
/*     */       
/* 223 */       byReference.write();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 251 */     if (paramInt == 1 || paramInt == 2) {
/* 252 */       j = 3;
/*     */     } else {
/* 254 */       j = paramInt;
/*     */     } 
/*     */ 
/*     */     
/* 258 */     WinNT.HRESULT hRESULT = this.iDispatch.Invoke(paramDISPID, new Guid.REFIID(Guid.IID_NULL), LOCALE_SYSTEM_DEFAULT, new WinDef.WORD(j), byReference, paramByReference, byReference1, intByReference);
/*     */ 
/*     */     
/* 261 */     COMUtils.checkRC(hRESULT, (OaIdl.EXCEPINFO)byReference1, intByReference);
/* 262 */     return hRESULT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, String paramString, Variant.VARIANT paramVARIANT) throws COMException {
/* 283 */     return oleMethod(paramInt, paramByReference, paramString, new Variant.VARIANT[] { paramVARIANT });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, OaIdl.DISPID paramDISPID, Variant.VARIANT paramVARIANT) throws COMException {
/* 289 */     return oleMethod(paramInt, paramByReference, paramDISPID, new Variant.VARIANT[] { paramVARIANT });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, String paramString) throws COMException {
/* 308 */     return oleMethod(paramInt, paramByReference, paramString, (Variant.VARIANT[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, OaIdl.DISPID paramDISPID) throws COMException {
/* 314 */     return oleMethod(paramInt, paramByReference, paramDISPID, (Variant.VARIANT[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, String paramString, Variant.VARIANT[] paramArrayOfVARIANT) throws COMException {
/* 324 */     if (paramIDispatch == null) {
/* 325 */       throw new COMException("pDisp (IDispatch) parameter is null!");
/*     */     }
/*     */     
/* 328 */     WString[] arrayOfWString = { new WString(paramString) };
/* 329 */     OaIdl.DISPIDByReference dISPIDByReference = new OaIdl.DISPIDByReference();
/*     */ 
/*     */     
/* 332 */     WinNT.HRESULT hRESULT = paramIDispatch.GetIDsOfNames(new Guid.REFIID(Guid.IID_NULL), arrayOfWString, 1, LOCALE_USER_DEFAULT, dISPIDByReference);
/*     */ 
/*     */     
/* 335 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 337 */     return 
/* 338 */       oleMethod(paramInt, paramByReference, paramIDispatch, dISPIDByReference.getValue(), paramArrayOfVARIANT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, OaIdl.DISPID paramDISPID, Variant.VARIANT[] paramArrayOfVARIANT) throws COMException {
/*     */     int j;
/* 349 */     if (paramIDispatch == null) {
/* 350 */       throw new COMException("pDisp (IDispatch) parameter is null!");
/*     */     }
/*     */     
/* 353 */     int i = 0;
/* 354 */     Variant.VARIANT[] arrayOfVARIANT = null;
/* 355 */     OleAuto.DISPPARAMS.ByReference byReference = new OleAuto.DISPPARAMS.ByReference();
/* 356 */     OaIdl.EXCEPINFO.ByReference byReference1 = new OaIdl.EXCEPINFO.ByReference();
/* 357 */     IntByReference intByReference = new IntByReference();
/*     */ 
/*     */     
/* 360 */     if (paramArrayOfVARIANT != null && paramArrayOfVARIANT.length > 0) {
/* 361 */       i = paramArrayOfVARIANT.length;
/* 362 */       arrayOfVARIANT = new Variant.VARIANT[i];
/*     */       
/* 364 */       j = i;
/* 365 */       for (byte b = 0; b < i; b++) {
/* 366 */         arrayOfVARIANT[b] = paramArrayOfVARIANT[--j];
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 371 */     if (paramInt == 4) {
/* 372 */       byReference.setRgdispidNamedArgs(new OaIdl.DISPID[] { OaIdl.DISPID_PROPERTYPUT });
/*     */     }
/*     */ 
/*     */     
/* 376 */     if (i > 0) {
/* 377 */       byReference.setArgs(arrayOfVARIANT);
/*     */ 
/*     */       
/* 380 */       byReference.write();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 408 */     if (paramInt == 1 || paramInt == 2) {
/* 409 */       j = 3;
/*     */     } else {
/* 411 */       j = paramInt;
/*     */     } 
/*     */ 
/*     */     
/* 415 */     WinNT.HRESULT hRESULT = paramIDispatch.Invoke(paramDISPID, new Guid.REFIID(Guid.IID_NULL), LOCALE_SYSTEM_DEFAULT, new WinDef.WORD(j), byReference, paramByReference, byReference1, intByReference);
/*     */ 
/*     */     
/* 418 */     COMUtils.checkRC(hRESULT, (OaIdl.EXCEPINFO)byReference1, intByReference);
/* 419 */     return hRESULT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, String paramString, Variant.VARIANT paramVARIANT) throws COMException {
/* 429 */     return oleMethod(paramInt, paramByReference, paramIDispatch, paramString, new Variant.VARIANT[] { paramVARIANT });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, OaIdl.DISPID paramDISPID, Variant.VARIANT paramVARIANT) throws COMException {
/* 440 */     return oleMethod(paramInt, paramByReference, paramIDispatch, paramDISPID, new Variant.VARIANT[] { paramVARIANT });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, String paramString) throws COMException {
/* 451 */     return oleMethod(paramInt, paramByReference, paramIDispatch, paramString, (Variant.VARIANT[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, OaIdl.DISPID paramDISPID) throws COMException {
/* 461 */     return oleMethod(paramInt, paramByReference, paramIDispatch, paramDISPID, (Variant.VARIANT[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void checkFailed(WinNT.HRESULT paramHRESULT) {
/* 473 */     COMUtils.checkRC(paramHRESULT);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\COMBindingBaseObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */