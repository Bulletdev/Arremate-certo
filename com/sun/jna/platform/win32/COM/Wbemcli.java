/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.WString;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.OaIdlUtil;
/*     */ import com.sun.jna.platform.win32.Ole32;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.Variant;
/*     */ import com.sun.jna.platform.win32.WTypes;
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
/*     */ public interface Wbemcli
/*     */ {
/*     */   public static final int WBEM_FLAG_RETURN_IMMEDIATELY = 16;
/*     */   public static final int WBEM_FLAG_FORWARD_ONLY = 32;
/*     */   public static final int WBEM_INFINITE = -1;
/*     */   public static final int WBEM_S_NO_ERROR = 0;
/*     */   public static final int WBEM_S_FALSE = 1;
/*     */   public static final int WBEM_S_TIMEDOUT = 262148;
/*     */   public static final int WBEM_S_NO_MORE_DATA = 262149;
/*     */   public static final int WBEM_E_INVALID_NAMESPACE = -2147217394;
/*     */   public static final int WBEM_E_INVALID_CLASS = -2147217392;
/*     */   public static final int WBEM_E_INVALID_QUERY = -2147217385;
/*     */   public static final int CIM_ILLEGAL = 4095;
/*     */   public static final int CIM_EMPTY = 0;
/*     */   public static final int CIM_SINT8 = 16;
/*     */   public static final int CIM_UINT8 = 17;
/*     */   public static final int CIM_SINT16 = 2;
/*     */   public static final int CIM_UINT16 = 18;
/*     */   public static final int CIM_SINT32 = 3;
/*     */   public static final int CIM_UINT32 = 19;
/*     */   public static final int CIM_SINT64 = 20;
/*     */   public static final int CIM_UINT64 = 21;
/*     */   public static final int CIM_REAL32 = 4;
/*     */   public static final int CIM_REAL64 = 5;
/*     */   public static final int CIM_BOOLEAN = 11;
/*     */   public static final int CIM_STRING = 8;
/*     */   public static final int CIM_DATETIME = 101;
/*     */   public static final int CIM_REFERENCE = 102;
/*     */   public static final int CIM_CHAR16 = 103;
/*     */   public static final int CIM_OBJECT = 13;
/*     */   public static final int CIM_FLAG_ARRAY = 8192;
/*     */   
/*     */   public static interface WBEM_CONDITION_FLAG_TYPE
/*     */   {
/*     */     public static final int WBEM_FLAG_ALWAYS = 0;
/*     */     public static final int WBEM_FLAG_ONLY_IF_TRUE = 1;
/*     */     public static final int WBEM_FLAG_ONLY_IF_FALSE = 2;
/*     */     public static final int WBEM_FLAG_ONLY_IF_IDENTICAL = 3;
/*     */     public static final int WBEM_MASK_PRIMARY_CONDITION = 3;
/*     */     public static final int WBEM_FLAG_KEYS_ONLY = 4;
/*     */     public static final int WBEM_FLAG_REFS_ONLY = 8;
/*     */     public static final int WBEM_FLAG_LOCAL_ONLY = 16;
/*     */     public static final int WBEM_FLAG_PROPAGATED_ONLY = 32;
/*     */     public static final int WBEM_FLAG_SYSTEM_ONLY = 48;
/*     */     public static final int WBEM_FLAG_NONSYSTEM_ONLY = 64;
/*     */     public static final int WBEM_MASK_CONDITION_ORIGIN = 112;
/*     */     public static final int WBEM_FLAG_CLASS_OVERRIDES_ONLY = 256;
/*     */     public static final int WBEM_FLAG_CLASS_LOCAL_AND_OVERRIDES = 512;
/*     */     public static final int WBEM_MASK_CLASS_CONDITION = 768;
/*     */   }
/*     */   
/*     */   public static class IWbemClassObject
/*     */     extends Unknown
/*     */   {
/*     */     public IWbemClassObject() {}
/*     */     
/*     */     public IWbemClassObject(Pointer param1Pointer) {
/* 114 */       super(param1Pointer);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public WinNT.HRESULT Get(WString param1WString, int param1Int, Variant.VARIANT.ByReference param1ByReference, IntByReference param1IntByReference1, IntByReference param1IntByReference2) {
/* 120 */       return (WinNT.HRESULT)_invokeNativeObject(4, new Object[] {
/* 121 */             getPointer(), param1WString, Integer.valueOf(param1Int), param1ByReference, param1IntByReference1, param1IntByReference2 }, WinNT.HRESULT.class);
/*     */     }
/*     */ 
/*     */     
/*     */     public WinNT.HRESULT Get(String param1String, int param1Int, Variant.VARIANT.ByReference param1ByReference, IntByReference param1IntByReference1, IntByReference param1IntByReference2) {
/* 126 */       return Get((param1String == null) ? null : new WString(param1String), param1Int, param1ByReference, param1IntByReference1, param1IntByReference2);
/*     */     }
/*     */     
/*     */     public WinNT.HRESULT GetNames(String param1String, int param1Int, Variant.VARIANT.ByReference param1ByReference, PointerByReference param1PointerByReference) {
/* 130 */       return GetNames((param1String == null) ? null : new WString(param1String), param1Int, param1ByReference, param1PointerByReference);
/*     */     }
/*     */ 
/*     */     
/*     */     public WinNT.HRESULT GetNames(WString param1WString, int param1Int, Variant.VARIANT.ByReference param1ByReference, PointerByReference param1PointerByReference) {
/* 135 */       return (WinNT.HRESULT)_invokeNativeObject(7, new Object[] {
/* 136 */             getPointer(), param1WString, Integer.valueOf(param1Int), param1ByReference, param1PointerByReference }, WinNT.HRESULT.class);
/*     */     }
/*     */     
/*     */     public String[] GetNames(String param1String, int param1Int, Variant.VARIANT.ByReference param1ByReference) {
/* 140 */       PointerByReference pointerByReference = new PointerByReference();
/* 141 */       COMUtils.checkRC(GetNames(param1String, param1Int, param1ByReference, pointerByReference));
/* 142 */       Object[] arrayOfObject = (Object[])OaIdlUtil.toPrimitiveArray(new OaIdl.SAFEARRAY(pointerByReference.getValue()), true);
/* 143 */       String[] arrayOfString = new String[arrayOfObject.length];
/* 144 */       for (byte b = 0; b < arrayOfObject.length; b++) {
/* 145 */         arrayOfString[b] = (String)arrayOfObject[b];
/*     */       }
/* 147 */       return arrayOfString;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IEnumWbemClassObject
/*     */     extends Unknown
/*     */   {
/*     */     public IEnumWbemClassObject() {}
/*     */ 
/*     */     
/*     */     public IEnumWbemClassObject(Pointer param1Pointer) {
/* 160 */       super(param1Pointer);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public WinNT.HRESULT Next(int param1Int1, int param1Int2, Pointer[] param1ArrayOfPointer, IntByReference param1IntByReference) {
/* 166 */       return (WinNT.HRESULT)_invokeNativeObject(4, new Object[] {
/* 167 */             getPointer(), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2), param1ArrayOfPointer, param1IntByReference }, WinNT.HRESULT.class);
/*     */     }
/*     */     
/*     */     public Wbemcli.IWbemClassObject[] Next(int param1Int1, int param1Int2) {
/* 171 */       Pointer[] arrayOfPointer = new Pointer[param1Int2];
/* 172 */       IntByReference intByReference = new IntByReference();
/* 173 */       WinNT.HRESULT hRESULT = Next(param1Int1, param1Int2, arrayOfPointer, intByReference);
/* 174 */       COMUtils.checkRC(hRESULT);
/* 175 */       Wbemcli.IWbemClassObject[] arrayOfIWbemClassObject = new Wbemcli.IWbemClassObject[intByReference.getValue()];
/* 176 */       for (byte b = 0; b < intByReference.getValue(); b++) {
/* 177 */         arrayOfIWbemClassObject[b] = new Wbemcli.IWbemClassObject(arrayOfPointer[b]);
/*     */       }
/* 179 */       return arrayOfIWbemClassObject;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IWbemLocator
/*     */     extends Unknown
/*     */   {
/* 189 */     public static final Guid.CLSID CLSID_WbemLocator = new Guid.CLSID("4590f811-1d3a-11d0-891f-00aa004b2e24");
/* 190 */     public static final Guid.GUID IID_IWbemLocator = new Guid.GUID("dc12a687-737f-11cf-884d-00aa004b2e24");
/*     */ 
/*     */     
/*     */     public IWbemLocator() {}
/*     */     
/*     */     private IWbemLocator(Pointer param1Pointer) {
/* 196 */       super(param1Pointer);
/*     */     }
/*     */     
/*     */     public static IWbemLocator create() {
/* 200 */       PointerByReference pointerByReference = new PointerByReference();
/*     */       
/* 202 */       WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoCreateInstance((Guid.GUID)CLSID_WbemLocator, null, 1, IID_IWbemLocator, pointerByReference);
/*     */       
/* 204 */       if (COMUtils.FAILED(hRESULT)) {
/* 205 */         return null;
/*     */       }
/*     */       
/* 208 */       return new IWbemLocator(pointerByReference.getValue());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public WinNT.HRESULT ConnectServer(WTypes.BSTR param1BSTR1, WTypes.BSTR param1BSTR2, WTypes.BSTR param1BSTR3, WTypes.BSTR param1BSTR4, int param1Int, WTypes.BSTR param1BSTR5, Wbemcli.IWbemContext param1IWbemContext, PointerByReference param1PointerByReference) {
/* 214 */       return (WinNT.HRESULT)_invokeNativeObject(3, new Object[] { getPointer(), param1BSTR1, param1BSTR2, param1BSTR3, param1BSTR4, 
/* 215 */             Integer.valueOf(param1Int), param1BSTR5, param1IWbemContext, param1PointerByReference }, WinNT.HRESULT.class);
/*     */     }
/*     */ 
/*     */     
/*     */     public Wbemcli.IWbemServices ConnectServer(String param1String1, String param1String2, String param1String3, String param1String4, int param1Int, String param1String5, Wbemcli.IWbemContext param1IWbemContext) {
/* 220 */       WTypes.BSTR bSTR1 = OleAuto.INSTANCE.SysAllocString(param1String1);
/* 221 */       WTypes.BSTR bSTR2 = OleAuto.INSTANCE.SysAllocString(param1String2);
/* 222 */       WTypes.BSTR bSTR3 = OleAuto.INSTANCE.SysAllocString(param1String3);
/* 223 */       WTypes.BSTR bSTR4 = OleAuto.INSTANCE.SysAllocString(param1String4);
/* 224 */       WTypes.BSTR bSTR5 = OleAuto.INSTANCE.SysAllocString(param1String5);
/*     */       
/* 226 */       PointerByReference pointerByReference = new PointerByReference();
/*     */       
/*     */       try {
/* 229 */         WinNT.HRESULT hRESULT = ConnectServer(bSTR1, bSTR2, bSTR3, bSTR4, param1Int, bSTR5, param1IWbemContext, pointerByReference);
/*     */ 
/*     */         
/* 232 */         COMUtils.checkRC(hRESULT);
/*     */         
/* 234 */         return new Wbemcli.IWbemServices(pointerByReference.getValue());
/*     */       } finally {
/* 236 */         OleAuto.INSTANCE.SysFreeString(bSTR1);
/* 237 */         OleAuto.INSTANCE.SysFreeString(bSTR2);
/* 238 */         OleAuto.INSTANCE.SysFreeString(bSTR3);
/* 239 */         OleAuto.INSTANCE.SysFreeString(bSTR4);
/* 240 */         OleAuto.INSTANCE.SysFreeString(bSTR5);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IWbemServices
/*     */     extends Unknown
/*     */   {
/*     */     public IWbemServices() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public IWbemServices(Pointer param1Pointer) {
/* 255 */       super(param1Pointer);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public WinNT.HRESULT ExecQuery(WTypes.BSTR param1BSTR1, WTypes.BSTR param1BSTR2, int param1Int, Wbemcli.IWbemContext param1IWbemContext, PointerByReference param1PointerByReference) {
/* 261 */       return (WinNT.HRESULT)_invokeNativeObject(20, new Object[] {
/* 262 */             getPointer(), param1BSTR1, param1BSTR2, Integer.valueOf(param1Int), param1IWbemContext, param1PointerByReference }, WinNT.HRESULT.class);
/*     */     }
/*     */     
/*     */     public Wbemcli.IEnumWbemClassObject ExecQuery(String param1String1, String param1String2, int param1Int, Wbemcli.IWbemContext param1IWbemContext) {
/* 266 */       WTypes.BSTR bSTR1 = OleAuto.INSTANCE.SysAllocString(param1String1);
/* 267 */       WTypes.BSTR bSTR2 = OleAuto.INSTANCE.SysAllocString(param1String2);
/*     */       try {
/* 269 */         PointerByReference pointerByReference = new PointerByReference();
/*     */         
/* 271 */         WinNT.HRESULT hRESULT = ExecQuery(bSTR1, bSTR2, param1Int, param1IWbemContext, pointerByReference);
/*     */         
/* 273 */         COMUtils.checkRC(hRESULT);
/*     */         
/* 275 */         return new Wbemcli.IEnumWbemClassObject(pointerByReference.getValue());
/*     */       } finally {
/* 277 */         OleAuto.INSTANCE.SysFreeString(bSTR1);
/* 278 */         OleAuto.INSTANCE.SysFreeString(bSTR2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IWbemContext
/*     */     extends Unknown
/*     */   {
/*     */     public IWbemContext() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public IWbemContext(Pointer param1Pointer) {
/* 293 */       super(param1Pointer);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\Wbemcli.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */