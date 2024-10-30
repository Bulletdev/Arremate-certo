/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.Ole32;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.WTypes;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TypeLibUtil
/*     */ {
/*  56 */   public static final OleAuto OLEAUTO = OleAuto.INSTANCE;
/*     */ 
/*     */   
/*     */   private ITypeLib typelib;
/*     */ 
/*     */   
/*  62 */   private WinDef.LCID lcid = Kernel32.INSTANCE.GetUserDefaultLCID();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String name;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String docString;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int helpContext;
/*     */ 
/*     */ 
/*     */   
/*     */   private String helpFile;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeLibUtil(String paramString, int paramInt1, int paramInt2) {
/*  87 */     Guid.CLSID.ByReference byReference = new Guid.CLSID.ByReference();
/*     */     
/*  89 */     WinNT.HRESULT hRESULT = Ole32.INSTANCE.CLSIDFromString(paramString, byReference);
/*  90 */     COMUtils.checkRC(hRESULT);
/*     */ 
/*     */     
/*  93 */     PointerByReference pointerByReference = new PointerByReference();
/*  94 */     hRESULT = OleAuto.INSTANCE.LoadRegTypeLib((Guid.GUID)byReference, paramInt1, paramInt2, this.lcid, pointerByReference);
/*     */     
/*  96 */     COMUtils.checkRC(hRESULT);
/*     */ 
/*     */     
/*  99 */     this.typelib = new TypeLib(pointerByReference.getValue());
/*     */     
/* 101 */     initTypeLibInfo();
/*     */   }
/*     */ 
/*     */   
/*     */   public TypeLibUtil(String paramString) {
/* 106 */     PointerByReference pointerByReference = new PointerByReference();
/* 107 */     WinNT.HRESULT hRESULT = OleAuto.INSTANCE.LoadTypeLib(paramString, pointerByReference);
/* 108 */     COMUtils.checkRC(hRESULT);
/*     */ 
/*     */     
/* 111 */     this.typelib = new TypeLib(pointerByReference.getValue());
/*     */     
/* 113 */     initTypeLibInfo();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initTypeLibInfo() {
/* 120 */     TypeLibDoc typeLibDoc = getDocumentation(-1);
/* 121 */     this.name = typeLibDoc.getName();
/* 122 */     this.docString = typeLibDoc.getDocString();
/* 123 */     this.helpContext = typeLibDoc.getHelpContext();
/* 124 */     this.helpFile = typeLibDoc.getHelpFile();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTypeInfoCount() {
/* 133 */     return this.typelib.GetTypeInfoCount().intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OaIdl.TYPEKIND getTypeInfoType(int paramInt) {
/* 144 */     OaIdl.TYPEKIND.ByReference byReference = new OaIdl.TYPEKIND.ByReference();
/* 145 */     WinNT.HRESULT hRESULT = this.typelib.GetTypeInfoType(new WinDef.UINT(paramInt), byReference);
/* 146 */     COMUtils.checkRC(hRESULT);
/* 147 */     return (OaIdl.TYPEKIND)byReference;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ITypeInfo getTypeInfo(int paramInt) {
/* 158 */     PointerByReference pointerByReference = new PointerByReference();
/* 159 */     WinNT.HRESULT hRESULT = this.typelib.GetTypeInfo(new WinDef.UINT(paramInt), pointerByReference);
/* 160 */     COMUtils.checkRC(hRESULT);
/* 161 */     return new TypeInfo(pointerByReference.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeInfoUtil getTypeInfoUtil(int paramInt) {
/* 172 */     return new TypeInfoUtil(getTypeInfo(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OaIdl.TLIBATTR getLibAttr() {
/* 181 */     PointerByReference pointerByReference = new PointerByReference();
/* 182 */     WinNT.HRESULT hRESULT = this.typelib.GetLibAttr(pointerByReference);
/* 183 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 185 */     return new OaIdl.TLIBATTR(pointerByReference.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeComp GetTypeComp() {
/* 194 */     PointerByReference pointerByReference = new PointerByReference();
/* 195 */     WinNT.HRESULT hRESULT = this.typelib.GetTypeComp(pointerByReference);
/* 196 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 198 */     return new TypeComp(pointerByReference.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeLibDoc getDocumentation(int paramInt) {
/* 209 */     WTypes.BSTRByReference bSTRByReference1 = new WTypes.BSTRByReference();
/* 210 */     WTypes.BSTRByReference bSTRByReference2 = new WTypes.BSTRByReference();
/* 211 */     WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
/* 212 */     WTypes.BSTRByReference bSTRByReference3 = new WTypes.BSTRByReference();
/*     */     
/* 214 */     WinNT.HRESULT hRESULT = this.typelib.GetDocumentation(paramInt, bSTRByReference1, bSTRByReference2, dWORDByReference, bSTRByReference3);
/*     */     
/* 216 */     COMUtils.checkRC(hRESULT);
/*     */ 
/*     */ 
/*     */     
/* 220 */     TypeLibDoc typeLibDoc = new TypeLibDoc(bSTRByReference1.getString(), bSTRByReference2.getString(), dWORDByReference.getValue().intValue(), bSTRByReference3.getString());
/*     */     
/* 222 */     OLEAUTO.SysFreeString(bSTRByReference1.getValue());
/* 223 */     OLEAUTO.SysFreeString(bSTRByReference2.getValue());
/* 224 */     OLEAUTO.SysFreeString(bSTRByReference3.getValue());
/*     */     
/* 226 */     return typeLibDoc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class TypeLibDoc
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
/*     */     public TypeLibDoc(String param1String1, String param1String2, int param1Int, String param1String3) {
/* 262 */       this.name = param1String1;
/* 263 */       this.docString = param1String2;
/* 264 */       this.helpContext = param1Int;
/* 265 */       this.helpFile = param1String3;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 274 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDocString() {
/* 283 */       return this.docString;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getHelpContext() {
/* 292 */       return this.helpContext;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getHelpFile() {
/* 301 */       return this.helpFile;
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
/*     */   
/*     */   public IsName IsName(String paramString, int paramInt) {
/* 316 */     WTypes.LPOLESTR lPOLESTR = new WTypes.LPOLESTR(paramString);
/* 317 */     WinDef.ULONG uLONG = new WinDef.ULONG(paramInt);
/* 318 */     WinDef.BOOLByReference bOOLByReference = new WinDef.BOOLByReference();
/*     */     
/* 320 */     WinNT.HRESULT hRESULT = this.typelib.IsName(lPOLESTR, uLONG, bOOLByReference);
/* 321 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 323 */     return new IsName(lPOLESTR.getValue(), bOOLByReference.getValue()
/* 324 */         .booleanValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IsName
/*     */   {
/*     */     private String nameBuf;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IsName(String param1String, boolean param1Boolean) {
/* 349 */       this.nameBuf = param1String;
/* 350 */       this.name = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getNameBuf() {
/* 359 */       return this.nameBuf;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isName() {
/* 368 */       return this.name;
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
/*     */ 
/*     */   
/*     */   public FindName FindName(String paramString, int paramInt, short paramShort) {
/* 384 */     Pointer pointer = Ole32.INSTANCE.CoTaskMemAlloc((paramString.length() + 1L) * Native.WCHAR_SIZE);
/* 385 */     WTypes.LPOLESTR lPOLESTR = new WTypes.LPOLESTR(pointer);
/* 386 */     lPOLESTR.setValue(paramString);
/*     */     
/* 388 */     WinDef.ULONG uLONG = new WinDef.ULONG(paramInt);
/* 389 */     WinDef.USHORTByReference uSHORTByReference = new WinDef.USHORTByReference(paramShort);
/*     */     
/* 391 */     Pointer[] arrayOfPointer = new Pointer[paramShort];
/* 392 */     OaIdl.MEMBERID[] arrayOfMEMBERID = new OaIdl.MEMBERID[paramShort];
/* 393 */     WinNT.HRESULT hRESULT = this.typelib.FindName(lPOLESTR, uLONG, arrayOfPointer, arrayOfMEMBERID, uSHORTByReference);
/*     */     
/* 395 */     COMUtils.checkRC(hRESULT);
/*     */ 
/*     */     
/* 398 */     FindName findName = new FindName(lPOLESTR.getValue(), arrayOfPointer, arrayOfMEMBERID, uSHORTByReference.getValue().shortValue());
/*     */     
/* 400 */     Ole32.INSTANCE.CoTaskMemFree(pointer);
/*     */     
/* 402 */     return findName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FindName
/*     */   {
/*     */     private String nameBuf;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Pointer[] pTInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private OaIdl.MEMBERID[] rgMemId;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private short pcFound;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FindName(String param1String, Pointer[] param1ArrayOfPointer, OaIdl.MEMBERID[] param1ArrayOfMEMBERID, short param1Short) {
/* 436 */       this.nameBuf = param1String;
/* 437 */       this.pTInfo = new Pointer[param1Short];
/* 438 */       this.rgMemId = new OaIdl.MEMBERID[param1Short];
/* 439 */       this.pcFound = param1Short;
/* 440 */       System.arraycopy(param1ArrayOfPointer, 0, this.pTInfo, 0, param1Short);
/* 441 */       System.arraycopy(param1ArrayOfMEMBERID, 0, this.rgMemId, 0, param1Short);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getNameBuf() {
/* 450 */       return this.nameBuf;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ITypeInfo[] getTInfo() {
/* 459 */       ITypeInfo[] arrayOfITypeInfo = new ITypeInfo[this.pcFound];
/* 460 */       for (byte b = 0; b < this.pcFound; b++)
/*     */       {
/* 462 */         arrayOfITypeInfo[b] = new TypeInfo(this.pTInfo[b]);
/*     */       }
/* 464 */       return arrayOfITypeInfo;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OaIdl.MEMBERID[] getMemId() {
/* 473 */       return this.rgMemId;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public short getFound() {
/* 482 */       return this.pcFound;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReleaseTLibAttr(OaIdl.TLIBATTR paramTLIBATTR) {
/* 493 */     this.typelib.ReleaseTLibAttr(paramTLIBATTR);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinDef.LCID getLcid() {
/* 502 */     return this.lcid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ITypeLib getTypelib() {
/* 511 */     return this.typelib;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 520 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocString() {
/* 529 */     return this.docString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHelpContext() {
/* 538 */     return this.helpContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHelpFile() {
/* 547 */     return this.helpFile;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\TypeLibUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */