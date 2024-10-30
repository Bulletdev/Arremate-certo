/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.Variant;
/*     */ import com.sun.jna.platform.win32.WTypes;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TypeInfoUtil
/*     */ {
/*  60 */   public static final OleAuto OLEAUTO = OleAuto.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ITypeInfo typeInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeInfoUtil(ITypeInfo paramITypeInfo) {
/*  72 */     this.typeInfo = paramITypeInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OaIdl.TYPEATTR getTypeAttr() {
/*  81 */     PointerByReference pointerByReference = new PointerByReference();
/*  82 */     WinNT.HRESULT hRESULT = this.typeInfo.GetTypeAttr(pointerByReference);
/*  83 */     COMUtils.checkRC(hRESULT);
/*     */     
/*  85 */     return new OaIdl.TYPEATTR(pointerByReference.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeComp getTypeComp() {
/*  94 */     PointerByReference pointerByReference = new PointerByReference();
/*  95 */     WinNT.HRESULT hRESULT = this.typeInfo.GetTypeComp(pointerByReference);
/*  96 */     COMUtils.checkRC(hRESULT);
/*     */     
/*  98 */     return new TypeComp(pointerByReference.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OaIdl.FUNCDESC getFuncDesc(int paramInt) {
/* 109 */     PointerByReference pointerByReference = new PointerByReference();
/* 110 */     WinNT.HRESULT hRESULT = this.typeInfo.GetFuncDesc(new WinDef.UINT(paramInt), pointerByReference);
/* 111 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 113 */     return new OaIdl.FUNCDESC(pointerByReference.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OaIdl.VARDESC getVarDesc(int paramInt) {
/* 124 */     PointerByReference pointerByReference = new PointerByReference();
/* 125 */     WinNT.HRESULT hRESULT = this.typeInfo.GetVarDesc(new WinDef.UINT(paramInt), pointerByReference);
/* 126 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 128 */     return new OaIdl.VARDESC(pointerByReference.getValue());
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
/*     */   public String[] getNames(OaIdl.MEMBERID paramMEMBERID, int paramInt) {
/* 141 */     WTypes.BSTR[] arrayOfBSTR = new WTypes.BSTR[paramInt];
/* 142 */     WinDef.UINTByReference uINTByReference = new WinDef.UINTByReference();
/* 143 */     WinNT.HRESULT hRESULT = this.typeInfo.GetNames(paramMEMBERID, arrayOfBSTR, new WinDef.UINT(paramInt), uINTByReference);
/*     */     
/* 145 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 147 */     int i = uINTByReference.getValue().intValue();
/* 148 */     String[] arrayOfString = new String[i];
/*     */     
/* 150 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 151 */       arrayOfString[b] = arrayOfBSTR[b].getValue();
/* 152 */       OLEAUTO.SysFreeString(arrayOfBSTR[b]);
/*     */     } 
/*     */     
/* 155 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OaIdl.HREFTYPE getRefTypeOfImplType(int paramInt) {
/* 166 */     OaIdl.HREFTYPEByReference hREFTYPEByReference = new OaIdl.HREFTYPEByReference();
/* 167 */     WinNT.HRESULT hRESULT = this.typeInfo.GetRefTypeOfImplType(new WinDef.UINT(paramInt), hREFTYPEByReference);
/*     */     
/* 169 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 171 */     return hREFTYPEByReference.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getImplTypeFlags(int paramInt) {
/* 182 */     IntByReference intByReference = new IntByReference();
/* 183 */     WinNT.HRESULT hRESULT = this.typeInfo.GetImplTypeFlags(new WinDef.UINT(paramInt), intByReference);
/*     */     
/* 185 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 187 */     return intByReference.getValue();
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
/*     */   public OaIdl.MEMBERID[] getIDsOfNames(WTypes.LPOLESTR[] paramArrayOfLPOLESTR, int paramInt) {
/* 200 */     OaIdl.MEMBERID[] arrayOfMEMBERID = new OaIdl.MEMBERID[paramInt];
/* 201 */     WinNT.HRESULT hRESULT = this.typeInfo.GetIDsOfNames(paramArrayOfLPOLESTR, new WinDef.UINT(paramInt), arrayOfMEMBERID);
/*     */     
/* 203 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 205 */     return arrayOfMEMBERID;
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
/*     */   public Invoke Invoke(WinDef.PVOID paramPVOID, OaIdl.MEMBERID paramMEMBERID, WinDef.WORD paramWORD, OleAuto.DISPPARAMS.ByReference paramByReference) {
/* 224 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 225 */     OaIdl.EXCEPINFO.ByReference byReference1 = new OaIdl.EXCEPINFO.ByReference();
/* 226 */     WinDef.UINTByReference uINTByReference = new WinDef.UINTByReference();
/*     */     
/* 228 */     WinNT.HRESULT hRESULT = this.typeInfo.Invoke(paramPVOID, paramMEMBERID, paramWORD, paramByReference, byReference, byReference1, uINTByReference);
/*     */     
/* 230 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 232 */     return new Invoke(byReference, byReference1, uINTByReference.getValue()
/* 233 */         .intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Invoke
/*     */   {
/*     */     private Variant.VARIANT.ByReference pVarResult;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private OaIdl.EXCEPINFO.ByReference pExcepInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int puArgErr;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Invoke(Variant.VARIANT.ByReference param1ByReference, OaIdl.EXCEPINFO.ByReference param1ByReference1, int param1Int) {
/* 264 */       this.pVarResult = param1ByReference;
/* 265 */       this.pExcepInfo = param1ByReference1;
/* 266 */       this.puArgErr = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Variant.VARIANT.ByReference getpVarResult() {
/* 275 */       return this.pVarResult;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OaIdl.EXCEPINFO.ByReference getpExcepInfo() {
/* 284 */       return this.pExcepInfo;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getPuArgErr() {
/* 293 */       return this.puArgErr;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeInfoDoc getDocumentation(OaIdl.MEMBERID paramMEMBERID) {
/* 305 */     WTypes.BSTRByReference bSTRByReference1 = new WTypes.BSTRByReference();
/* 306 */     WTypes.BSTRByReference bSTRByReference2 = new WTypes.BSTRByReference();
/* 307 */     WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
/* 308 */     WTypes.BSTRByReference bSTRByReference3 = new WTypes.BSTRByReference();
/*     */     
/* 310 */     WinNT.HRESULT hRESULT = this.typeInfo.GetDocumentation(paramMEMBERID, bSTRByReference1, bSTRByReference2, dWORDByReference, bSTRByReference3);
/*     */     
/* 312 */     COMUtils.checkRC(hRESULT);
/*     */ 
/*     */ 
/*     */     
/* 316 */     TypeInfoDoc typeInfoDoc = new TypeInfoDoc(bSTRByReference1.getString(), bSTRByReference2.getString(), dWORDByReference.getValue().intValue(), bSTRByReference3.getString());
/*     */     
/* 318 */     OLEAUTO.SysFreeString(bSTRByReference1.getValue());
/* 319 */     OLEAUTO.SysFreeString(bSTRByReference2.getValue());
/* 320 */     OLEAUTO.SysFreeString(bSTRByReference3.getValue());
/*     */     
/* 322 */     return typeInfoDoc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class TypeInfoDoc
/*     */   {
/*     */     private String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String docString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int helpContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String helpFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeInfoDoc(String param1String1, String param1String2, int param1Int, String param1String3) {
/* 358 */       this.name = param1String1;
/* 359 */       this.docString = param1String2;
/* 360 */       this.helpContext = param1Int;
/* 361 */       this.helpFile = param1String3;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 370 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDocString() {
/* 379 */       return this.docString;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getHelpContext() {
/* 388 */       return this.helpContext;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getHelpFile() {
/* 397 */       return this.helpFile;
/*     */     }
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
/*     */   public DllEntry GetDllEntry(OaIdl.MEMBERID paramMEMBERID, OaIdl.INVOKEKIND paramINVOKEKIND) {
/* 411 */     WTypes.BSTRByReference bSTRByReference1 = new WTypes.BSTRByReference();
/* 412 */     WTypes.BSTRByReference bSTRByReference2 = new WTypes.BSTRByReference();
/* 413 */     WinDef.WORDByReference wORDByReference = new WinDef.WORDByReference();
/*     */     
/* 415 */     WinNT.HRESULT hRESULT = this.typeInfo.GetDllEntry(paramMEMBERID, paramINVOKEKIND, bSTRByReference1, bSTRByReference2, wORDByReference);
/*     */     
/* 417 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 419 */     OLEAUTO.SysFreeString(bSTRByReference1.getValue());
/* 420 */     OLEAUTO.SysFreeString(bSTRByReference2.getValue());
/*     */     
/* 422 */     return new DllEntry(bSTRByReference1.getString(), bSTRByReference2.getString(), wORDByReference
/* 423 */         .getValue().intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DllEntry
/*     */   {
/*     */     private String dllName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int ordinal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DllEntry(String param1String1, String param1String2, int param1Int) {
/* 453 */       this.dllName = param1String1;
/* 454 */       this.name = param1String2;
/* 455 */       this.ordinal = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDllName() {
/* 464 */       return this.dllName;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setDllName(String param1String) {
/* 474 */       this.dllName = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 483 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setName(String param1String) {
/* 493 */       this.name = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getOrdinal() {
/* 502 */       return this.ordinal;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setOrdinal(int param1Int) {
/* 512 */       this.ordinal = param1Int;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ITypeInfo getRefTypeInfo(OaIdl.HREFTYPE paramHREFTYPE) {
/* 524 */     PointerByReference pointerByReference = new PointerByReference();
/* 525 */     WinNT.HRESULT hRESULT = this.typeInfo.GetRefTypeInfo(paramHREFTYPE, pointerByReference);
/* 526 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 528 */     return new TypeInfo(pointerByReference.getValue());
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
/*     */   public PointerByReference AddressOfMember(OaIdl.MEMBERID paramMEMBERID, OaIdl.INVOKEKIND paramINVOKEKIND) {
/* 541 */     PointerByReference pointerByReference = new PointerByReference();
/* 542 */     WinNT.HRESULT hRESULT = this.typeInfo.AddressOfMember(paramMEMBERID, paramINVOKEKIND, pointerByReference);
/* 543 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 545 */     return pointerByReference;
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
/*     */   public PointerByReference CreateInstance(IUnknown paramIUnknown, Guid.REFIID paramREFIID) {
/* 558 */     PointerByReference pointerByReference = new PointerByReference();
/* 559 */     WinNT.HRESULT hRESULT = this.typeInfo.CreateInstance(paramIUnknown, paramREFIID, pointerByReference);
/* 560 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 562 */     return pointerByReference;
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
/*     */   public String GetMops(OaIdl.MEMBERID paramMEMBERID) {
/* 574 */     WTypes.BSTRByReference bSTRByReference = new WTypes.BSTRByReference();
/* 575 */     WinNT.HRESULT hRESULT = this.typeInfo.GetMops(paramMEMBERID, bSTRByReference);
/* 576 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 578 */     return bSTRByReference.getString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ContainingTypeLib GetContainingTypeLib() {
/* 588 */     PointerByReference pointerByReference = new PointerByReference();
/* 589 */     WinDef.UINTByReference uINTByReference = new WinDef.UINTByReference();
/*     */     
/* 591 */     WinNT.HRESULT hRESULT = this.typeInfo.GetContainingTypeLib(pointerByReference, uINTByReference);
/* 592 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 594 */     return new ContainingTypeLib(new TypeLib(pointerByReference.getValue()), uINTByReference
/* 595 */         .getValue().intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ContainingTypeLib
/*     */   {
/*     */     private ITypeLib typeLib;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int index;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ContainingTypeLib(ITypeLib param1ITypeLib, int param1Int) {
/* 620 */       this.typeLib = param1ITypeLib;
/* 621 */       this.index = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ITypeLib getTypeLib() {
/* 630 */       return this.typeLib;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setTypeLib(ITypeLib param1ITypeLib) {
/* 640 */       this.typeLib = param1ITypeLib;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getIndex() {
/* 649 */       return this.index;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setIndex(int param1Int) {
/* 659 */       this.index = param1Int;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReleaseTypeAttr(OaIdl.TYPEATTR paramTYPEATTR) {
/* 670 */     this.typeInfo.ReleaseTypeAttr(paramTYPEATTR);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReleaseFuncDesc(OaIdl.FUNCDESC paramFUNCDESC) {
/* 680 */     this.typeInfo.ReleaseFuncDesc(paramFUNCDESC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReleaseVarDesc(OaIdl.VARDESC paramVARDESC) {
/* 690 */     this.typeInfo.ReleaseVarDesc(paramVARDESC);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\TypeInfoUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */