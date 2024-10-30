/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import com.sun.jna.ptr.DoubleByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import com.sun.jna.win32.StdCallLibrary;
/*     */ import com.sun.jna.win32.W32APIOptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface OleAuto
/*     */   extends StdCallLibrary
/*     */ {
/*  63 */   public static final OleAuto INSTANCE = (OleAuto)Native.load("OleAut32", OleAuto.class, W32APIOptions.DEFAULT_OPTIONS);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DISPATCH_METHOD = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DISPATCH_PROPERTYGET = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DISPATCH_PROPERTYPUT = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DISPATCH_PROPERTYPUTREF = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_AUTO = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_STATIC = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_EMBEDDED = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_FIXEDSIZE = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_RECORD = 32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_HAVEIID = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_HAVEVARTYPE = 128;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_BSTR = 256;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_UNKNOWN = 512;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_DISPATCH = 1024;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_VARIANT = 2048;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FADF_RESERVED = 61448;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short VARIANT_NOVALUEPROP = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short VARIANT_ALPHABOOL = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short VARIANT_NOUSEROVERRIDE = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short VARIANT_CALENDAR_HIJRI = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short VARIANT_LOCALBOOL = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short VARIANT_CALENDAR_THAI = 32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short VARIANT_CALENDAR_GREGORIAN = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short VARIANT_USE_NLS = 128;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WTypes.BSTR SysAllocString(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void SysFreeString(WTypes.BSTR paramBSTR);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int SysStringByteLen(WTypes.BSTR paramBSTR);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int SysStringLen(WTypes.BSTR paramBSTR);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void VariantInit(Variant.VARIANT.ByReference paramByReference);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void VariantInit(Variant.VARIANT paramVARIANT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT VariantCopy(Pointer paramPointer, Variant.VARIANT paramVARIANT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT VariantClear(Variant.VARIANT paramVARIANT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT VariantChangeType(Variant.VARIANT paramVARIANT1, Variant.VARIANT paramVARIANT2, short paramShort, WTypes.VARTYPE paramVARTYPE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT VariantChangeType(Variant.VARIANT.ByReference paramByReference1, Variant.VARIANT.ByReference paramByReference2, short paramShort, WTypes.VARTYPE paramVARTYPE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   OaIdl.SAFEARRAY.ByReference SafeArrayCreate(WTypes.VARTYPE paramVARTYPE, WinDef.UINT paramUINT, OaIdl.SAFEARRAYBOUND[] paramArrayOfSAFEARRAYBOUND);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayPutElement(OaIdl.SAFEARRAY paramSAFEARRAY, WinDef.LONG[] paramArrayOfLONG, Pointer paramPointer);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayGetUBound(OaIdl.SAFEARRAY paramSAFEARRAY, WinDef.UINT paramUINT, WinDef.LONGByReference paramLONGByReference);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayGetLBound(OaIdl.SAFEARRAY paramSAFEARRAY, WinDef.UINT paramUINT, WinDef.LONGByReference paramLONGByReference);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayGetElement(OaIdl.SAFEARRAY paramSAFEARRAY, WinDef.LONG[] paramArrayOfLONG, Pointer paramPointer);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayPtrOfIndex(OaIdl.SAFEARRAY paramSAFEARRAY, WinDef.LONG[] paramArrayOfLONG, PointerByReference paramPointerByReference);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayLock(OaIdl.SAFEARRAY paramSAFEARRAY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayUnlock(OaIdl.SAFEARRAY paramSAFEARRAY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayDestroy(OaIdl.SAFEARRAY paramSAFEARRAY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayRedim(OaIdl.SAFEARRAY paramSAFEARRAY, OaIdl.SAFEARRAYBOUND paramSAFEARRAYBOUND);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayGetVartype(OaIdl.SAFEARRAY paramSAFEARRAY, WTypes.VARTYPEByReference paramVARTYPEByReference);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinDef.UINT SafeArrayGetDim(OaIdl.SAFEARRAY paramSAFEARRAY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayAccessData(OaIdl.SAFEARRAY paramSAFEARRAY, PointerByReference paramPointerByReference);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT SafeArrayUnaccessData(OaIdl.SAFEARRAY paramSAFEARRAY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinDef.UINT SafeArrayGetElemsize(OaIdl.SAFEARRAY paramSAFEARRAY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT GetActiveObject(Guid.GUID paramGUID, WinDef.PVOID paramPVOID, PointerByReference paramPointerByReference);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT LoadRegTypeLib(Guid.GUID paramGUID, int paramInt1, int paramInt2, WinDef.LCID paramLCID, PointerByReference paramPointerByReference);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WinNT.HRESULT LoadTypeLib(String paramString, PointerByReference paramPointerByReference);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int SystemTimeToVariantTime(WinBase.SYSTEMTIME paramSYSTEMTIME, DoubleByReference paramDoubleByReference);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"rgvarg", "rgdispidNamedArgs", "cArgs", "cNamedArgs"})
/*     */   public static class DISPPARAMS
/*     */     extends Structure
/*     */   {
/*     */     public Variant.VariantArg.ByReference rgvarg;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends DISPPARAMS
/*     */       implements Structure.ByReference {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 779 */     public Pointer rgdispidNamedArgs = Pointer.NULL;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 784 */     public WinDef.UINT cArgs = new WinDef.UINT(0L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 790 */     public WinDef.UINT cNamedArgs = new WinDef.UINT(0L);
/*     */     
/*     */     public OaIdl.DISPID[] getRgdispidNamedArgs() {
/* 793 */       OaIdl.DISPID[] arrayOfDISPID = null;
/* 794 */       int i = this.cNamedArgs.intValue();
/* 795 */       if (this.rgdispidNamedArgs != null && i > 0) {
/* 796 */         int[] arrayOfInt = this.rgdispidNamedArgs.getIntArray(0L, i);
/* 797 */         arrayOfDISPID = new OaIdl.DISPID[i];
/* 798 */         for (byte b = 0; b < i; b++) {
/* 799 */           arrayOfDISPID[b] = new OaIdl.DISPID(arrayOfInt[b]);
/*     */         }
/*     */       } else {
/* 802 */         arrayOfDISPID = new OaIdl.DISPID[0];
/*     */       } 
/* 804 */       return arrayOfDISPID;
/*     */     }
/*     */     
/*     */     public void setRgdispidNamedArgs(OaIdl.DISPID[] param1ArrayOfDISPID) {
/* 808 */       if (param1ArrayOfDISPID == null) {
/* 809 */         param1ArrayOfDISPID = new OaIdl.DISPID[0];
/*     */       }
/* 811 */       this.cNamedArgs = new WinDef.UINT(param1ArrayOfDISPID.length);
/* 812 */       this.rgdispidNamedArgs = (Pointer)new Memory((OaIdl.DISPID.SIZE * param1ArrayOfDISPID.length));
/* 813 */       int[] arrayOfInt = new int[param1ArrayOfDISPID.length];
/* 814 */       for (byte b = 0; b < arrayOfInt.length; b++) {
/* 815 */         arrayOfInt[b] = param1ArrayOfDISPID[b].intValue();
/*     */       }
/* 817 */       this.rgdispidNamedArgs.write(0L, arrayOfInt, 0, param1ArrayOfDISPID.length);
/*     */     }
/*     */     
/*     */     public Variant.VARIANT[] getArgs() {
/* 821 */       if (this.rgvarg != null) {
/* 822 */         this.rgvarg.setArraySize(this.cArgs.intValue());
/* 823 */         return this.rgvarg.variantArg;
/*     */       } 
/* 825 */       return new Variant.VARIANT[0];
/*     */     }
/*     */ 
/*     */     
/*     */     public void setArgs(Variant.VARIANT[] param1ArrayOfVARIANT) {
/* 830 */       if (param1ArrayOfVARIANT == null) {
/* 831 */         param1ArrayOfVARIANT = new Variant.VARIANT[0];
/*     */       }
/*     */       
/* 834 */       this.rgvarg = new Variant.VariantArg.ByReference(param1ArrayOfVARIANT);
/* 835 */       this.cArgs = new WinDef.UINT(param1ArrayOfVARIANT.length);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DISPPARAMS() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DISPPARAMS(Pointer param1Pointer) {
/* 851 */       super(param1Pointer);
/* 852 */       read();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\OleAuto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */