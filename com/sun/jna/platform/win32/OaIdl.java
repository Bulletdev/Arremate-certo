/*      */ package com.sun.jna.platform.win32;
/*      */ 
/*      */ import com.sun.jna.IntegerType;
/*      */ import com.sun.jna.Memory;
/*      */ import com.sun.jna.NativeLong;
/*      */ import com.sun.jna.Pointer;
/*      */ import com.sun.jna.Structure;
/*      */ import com.sun.jna.Structure.FieldOrder;
/*      */ import com.sun.jna.Union;
/*      */ import com.sun.jna.platform.win32.COM.COMUtils;
/*      */ import com.sun.jna.platform.win32.COM.Dispatch;
/*      */ import com.sun.jna.platform.win32.COM.TypeComp;
/*      */ import com.sun.jna.platform.win32.COM.Unknown;
/*      */ import com.sun.jna.ptr.PointerByReference;
/*      */ import java.io.Closeable;
/*      */ import java.util.Date;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface OaIdl
/*      */ {
/*   91 */   public static final long DATE_OFFSET = (new Date(-1, 11, 30, 0, 0, 0)).getTime();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"wCode", "wReserved", "bstrSource", "bstrDescription", "bstrHelpFile", "dwHelpContext", "pvReserved", "pfnDeferredFillIn", "scode"})
/*      */   public static class EXCEPINFO
/*      */     extends Structure
/*      */   {
/*      */     public WinDef.WORD wCode;
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.WORD wReserved;
/*      */ 
/*      */ 
/*      */     
/*      */     public WTypes.BSTR bstrSource;
/*      */ 
/*      */ 
/*      */     
/*      */     public WTypes.BSTR bstrDescription;
/*      */ 
/*      */ 
/*      */     
/*      */     public WTypes.BSTR bstrHelpFile;
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.DWORD dwHelpContext;
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.PVOID pvReserved;
/*      */ 
/*      */ 
/*      */     
/*      */     public ByReference pfnDeferredFillIn;
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.SCODE scode;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends EXCEPINFO
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public EXCEPINFO() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public EXCEPINFO(Pointer param1Pointer) {
/*  149 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class VARIANT_BOOL extends IntegerType {
/*      */     private static final long serialVersionUID = 1L;
/*      */     public static final int SIZE = 2;
/*      */     
/*      */     public VARIANT_BOOL() {
/*  158 */       this(0L);
/*      */     }
/*      */     
/*      */     public VARIANT_BOOL(long param1Long) {
/*  162 */       super(2, param1Long);
/*      */     }
/*      */     
/*      */     public VARIANT_BOOL(boolean param1Boolean) {
/*  166 */       this(param1Boolean ? 65535L : 0L);
/*      */     }
/*      */     
/*      */     public boolean booleanValue() {
/*  170 */       return (shortValue() != 0);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class _VARIANT_BOOL extends VARIANT_BOOL {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */     public _VARIANT_BOOL() {
/*  178 */       this(0L);
/*      */     }
/*      */     
/*      */     public _VARIANT_BOOL(long param1Long) {
/*  182 */       super(param1Long);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class VARIANT_BOOLByReference extends com.sun.jna.ptr.ByReference {
/*      */     public VARIANT_BOOLByReference() {
/*  188 */       this(new OaIdl.VARIANT_BOOL(0L));
/*      */     }
/*      */     
/*      */     public VARIANT_BOOLByReference(OaIdl.VARIANT_BOOL param1VARIANT_BOOL) {
/*  192 */       super(2);
/*  193 */       setValue(param1VARIANT_BOOL);
/*      */     }
/*      */     
/*      */     public void setValue(OaIdl.VARIANT_BOOL param1VARIANT_BOOL) {
/*  197 */       getPointer().setShort(0L, param1VARIANT_BOOL.shortValue());
/*      */     }
/*      */     
/*      */     public OaIdl.VARIANT_BOOL getValue() {
/*  201 */       return new OaIdl.VARIANT_BOOL(getPointer().getShort(0L));
/*      */     }
/*      */   }
/*      */   
/*      */   public static class _VARIANT_BOOLByReference extends com.sun.jna.ptr.ByReference {
/*      */     public _VARIANT_BOOLByReference() {
/*  207 */       this(new OaIdl.VARIANT_BOOL(0L));
/*      */     }
/*      */     
/*      */     public _VARIANT_BOOLByReference(OaIdl.VARIANT_BOOL param1VARIANT_BOOL) {
/*  211 */       super(2);
/*  212 */       setValue(param1VARIANT_BOOL);
/*      */     }
/*      */     
/*      */     public void setValue(OaIdl.VARIANT_BOOL param1VARIANT_BOOL) {
/*  216 */       getPointer().setShort(0L, param1VARIANT_BOOL.shortValue());
/*      */     }
/*      */     
/*      */     public OaIdl.VARIANT_BOOL getValue() {
/*  220 */       return new OaIdl.VARIANT_BOOL(getPointer().getShort(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"date"})
/*      */   public static class DATE
/*      */     extends Structure
/*      */   {
/*      */     private static final long MICRO_SECONDS_PER_DAY = 86400000L;
/*      */     public double date;
/*      */     
/*      */     public static class ByReference
/*      */       extends DATE
/*      */       implements Structure.ByReference {}
/*      */     
/*      */     public DATE() {}
/*      */     
/*      */     public DATE(double param1Double) {
/*  239 */       this.date = param1Double;
/*      */     }
/*      */     
/*      */     public DATE(Date param1Date) {
/*  243 */       setFromJavaDate(param1Date);
/*      */     }
/*      */     
/*      */     public Date getAsJavaDate() {
/*  247 */       long l = (long)this.date * 86400000L + OaIdl.DATE_OFFSET;
/*  248 */       double d = 24.0D * Math.abs(this.date - (long)this.date);
/*  249 */       int i = (int)d;
/*  250 */       d = 60.0D * (d - (int)d);
/*  251 */       int j = (int)d;
/*  252 */       d = 60.0D * (d - (int)d);
/*  253 */       int k = (int)d;
/*  254 */       d = 1000.0D * (d - (int)d);
/*  255 */       int m = (int)d;
/*      */       
/*  257 */       Date date = new Date(l);
/*  258 */       date.setHours(i);
/*  259 */       date.setMinutes(j);
/*  260 */       date.setSeconds(k);
/*  261 */       date.setTime(date.getTime() + m);
/*  262 */       return date;
/*      */     }
/*      */     
/*      */     public void setFromJavaDate(Date param1Date) {
/*  266 */       double d1 = (param1Date.getTime() - OaIdl.DATE_OFFSET);
/*  267 */       double d2 = d1 / 8.64E7D;
/*      */       
/*  269 */       Date date = new Date(param1Date.getTime());
/*  270 */       date.setHours(0);
/*  271 */       date.setMinutes(0);
/*  272 */       date.setSeconds(0);
/*  273 */       date.setTime(date.getTime() / 1000L * 1000L);
/*      */       
/*  275 */       double d3 = Math.floor(d2);
/*  276 */       double d4 = Math.signum(d2) * (param1Date.getTime() - date.getTime()) / 8.64E7D;
/*      */       
/*  278 */       this.date = d3 + d4;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class DISPID
/*      */     extends WinDef.LONG
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */     public DISPID() {
/*  289 */       this(0);
/*      */     }
/*      */     
/*      */     public DISPID(int param1Int) {
/*  293 */       super(param1Int);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class DISPIDByReference extends com.sun.jna.ptr.ByReference {
/*      */     public DISPIDByReference() {
/*  299 */       this(new OaIdl.DISPID(0));
/*      */     }
/*      */     
/*      */     public DISPIDByReference(OaIdl.DISPID param1DISPID) {
/*  303 */       super(OaIdl.DISPID.SIZE);
/*  304 */       setValue(param1DISPID);
/*      */     }
/*      */     
/*      */     public void setValue(OaIdl.DISPID param1DISPID) {
/*  308 */       getPointer().setInt(0L, param1DISPID.intValue());
/*      */     }
/*      */     
/*      */     public OaIdl.DISPID getValue() {
/*  312 */       return new OaIdl.DISPID(getPointer().getInt(0L));
/*      */     }
/*      */   }
/*      */   
/*      */   public static class MEMBERID extends DISPID {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */     public MEMBERID() {
/*  320 */       this(0);
/*      */     }
/*      */     
/*      */     public MEMBERID(int param1Int) {
/*  324 */       super(param1Int);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class MEMBERIDByReference extends com.sun.jna.ptr.ByReference {
/*      */     public MEMBERIDByReference() {
/*  330 */       this(new OaIdl.MEMBERID(0));
/*      */     }
/*      */     
/*      */     public MEMBERIDByReference(OaIdl.MEMBERID param1MEMBERID) {
/*  334 */       super(OaIdl.MEMBERID.SIZE);
/*  335 */       setValue(param1MEMBERID);
/*      */     }
/*      */     
/*      */     public void setValue(OaIdl.MEMBERID param1MEMBERID) {
/*  339 */       getPointer().setInt(0L, param1MEMBERID.intValue());
/*      */     }
/*      */     
/*      */     public OaIdl.MEMBERID getValue() {
/*  343 */       return new OaIdl.MEMBERID(getPointer().getInt(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  350 */   public static final DISPID DISPID_COLLECT = new DISPID(-8);
/*      */ 
/*      */ 
/*      */   
/*  354 */   public static final DISPID DISPID_CONSTRUCTOR = new DISPID(-6);
/*      */ 
/*      */ 
/*      */   
/*  358 */   public static final DISPID DISPID_DESTRUCTOR = new DISPID(-7);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  364 */   public static final DISPID DISPID_EVALUATE = new DISPID(-5);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  370 */   public static final DISPID DISPID_NEWENUM = new DISPID(-4);
/*      */ 
/*      */ 
/*      */   
/*  374 */   public static final DISPID DISPID_PROPERTYPUT = new DISPID(-3);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  379 */   public static final DISPID DISPID_UNKNOWN = new DISPID(-1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  385 */   public static final DISPID DISPID_VALUE = new DISPID(0);
/*      */   
/*  387 */   public static final MEMBERID MEMBERID_NIL = new MEMBERID(DISPID_UNKNOWN
/*  388 */       .intValue());
/*      */   
/*      */   public static final int FADF_AUTO = 1;
/*      */   
/*      */   public static final int FADF_STATIC = 2;
/*      */   
/*      */   public static final int FADF_EMBEDDED = 4;
/*      */   
/*      */   public static final int FADF_FIXEDSIZE = 16;
/*      */   
/*      */   public static final int FADF_RECORD = 32;
/*      */   
/*      */   public static final int FADF_HAVEIID = 64;
/*      */   
/*      */   public static final int FADF_HAVEVARTYPE = 128;
/*      */   
/*      */   public static final int FADF_BSTR = 256;
/*      */   
/*      */   public static final int FADF_UNKNOWN = 512;
/*      */   
/*      */   public static final int FADF_DISPATCH = 1024;
/*      */   
/*      */   public static final int FADF_VARIANT = 2048;
/*      */   
/*      */   public static final int FADF_RESERVED = 61448;
/*      */ 
/*      */   
/*      */   @FieldOrder({"value"})
/*      */   public static class TYPEKIND
/*      */     extends Structure
/*      */   {
/*      */     public int value;
/*      */     
/*      */     public static final int TKIND_ENUM = 0;
/*      */     
/*      */     public static final int TKIND_RECORD = 1;
/*      */     
/*      */     public static final int TKIND_MODULE = 2;
/*      */     
/*      */     public static final int TKIND_INTERFACE = 3;
/*      */     
/*      */     public static final int TKIND_DISPATCH = 4;
/*      */     
/*      */     public static final int TKIND_COCLASS = 5;
/*      */     
/*      */     public static final int TKIND_ALIAS = 6;
/*      */     
/*      */     public static final int TKIND_UNION = 7;
/*      */     public static final int TKIND_MAX = 8;
/*      */     
/*      */     public static class ByReference
/*      */       extends TYPEKIND
/*      */       implements Structure.ByReference
/*      */     {
/*      */       public ByReference() {}
/*      */       
/*      */       public ByReference(int param2Int) {
/*  445 */         super(param2Int);
/*      */       }
/*      */       
/*      */       public ByReference(OaIdl.TYPEKIND param2TYPEKIND) {
/*  449 */         super(param2TYPEKIND.getPointer());
/*  450 */         this.value = param2TYPEKIND.value;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public TYPEKIND() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public TYPEKIND(int param1Int) {
/*  461 */       this.value = param1Int;
/*      */     }
/*      */     
/*      */     public TYPEKIND(Pointer param1Pointer) {
/*  465 */       super(param1Pointer);
/*  466 */       read();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"value"})
/*      */   public static class DESCKIND
/*      */     extends Structure
/*      */   {
/*      */     public int value;
/*      */ 
/*      */     
/*      */     public static final int DESCKIND_NONE = 0;
/*      */ 
/*      */     
/*      */     public static final int DESCKIND_FUNCDESC = 1;
/*      */     
/*      */     public static final int DESCKIND_VARDESC = 2;
/*      */     
/*      */     public static final int DESCKIND_TYPECOMP = 3;
/*      */     
/*      */     public static final int DESCKIND_IMPLICITAPPOBJ = 4;
/*      */     
/*      */     public static final int DESCKIND_MAX = 5;
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends DESCKIND
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */     
/*      */     public DESCKIND() {}
/*      */ 
/*      */     
/*      */     public DESCKIND(int param1Int) {
/*  502 */       this.value = param1Int;
/*      */     }
/*      */     
/*      */     public DESCKIND(Pointer param1Pointer) {
/*  506 */       super(param1Pointer);
/*  507 */       read();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"cDims", "fFeatures", "cbElements", "cLocks", "pvData", "rgsabound"})
/*      */   public static class SAFEARRAY
/*      */     extends Structure
/*      */     implements Closeable
/*      */   {
/*      */     public WinDef.USHORT cDims;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.USHORT fFeatures;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.ULONG cbElements;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.ULONG cLocks;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.PVOID pvData;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends SAFEARRAY
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  573 */     public OaIdl.SAFEARRAYBOUND[] rgsabound = new OaIdl.SAFEARRAYBOUND[] { new OaIdl.SAFEARRAYBOUND() };
/*      */ 
/*      */     
/*      */     public SAFEARRAY() {}
/*      */ 
/*      */     
/*      */     public SAFEARRAY(Pointer param1Pointer) {
/*  580 */       super(param1Pointer);
/*  581 */       read();
/*      */     }
/*      */ 
/*      */     
/*      */     public void read() {
/*  586 */       super.read();
/*  587 */       if (this.cDims.intValue() > 0) {
/*  588 */         this.rgsabound = (OaIdl.SAFEARRAYBOUND[])this.rgsabound[0].toArray(this.cDims.intValue());
/*      */       } else {
/*  590 */         this.rgsabound = new OaIdl.SAFEARRAYBOUND[] { new OaIdl.SAFEARRAYBOUND() };
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ByReference createSafeArray(int... param1VarArgs) {
/*  607 */       return createSafeArray(new WTypes.VARTYPE(12), param1VarArgs);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ByReference createSafeArray(WTypes.VARTYPE param1VARTYPE, int... param1VarArgs) {
/*  623 */       OaIdl.SAFEARRAYBOUND[] arrayOfSAFEARRAYBOUND = (OaIdl.SAFEARRAYBOUND[])(new OaIdl.SAFEARRAYBOUND()).toArray(param1VarArgs.length);
/*  624 */       for (byte b = 0; b < param1VarArgs.length; b++) {
/*  625 */         (arrayOfSAFEARRAYBOUND[b]).lLbound = new WinDef.LONG(0L);
/*  626 */         (arrayOfSAFEARRAYBOUND[b]).cElements = new WinDef.ULONG(param1VarArgs[param1VarArgs.length - b - 1]);
/*      */       } 
/*  628 */       return OleAuto.INSTANCE.SafeArrayCreate(param1VARTYPE, new WinDef.UINT(param1VarArgs.length), arrayOfSAFEARRAYBOUND);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void putElement(Object param1Object, int... param1VarArgs) {
/*      */       WinNT.HRESULT hRESULT;
/*      */       Memory memory;
/*  643 */       WinDef.LONG[] arrayOfLONG = new WinDef.LONG[param1VarArgs.length];
/*  644 */       for (byte b = 0; b < param1VarArgs.length; b++) {
/*  645 */         arrayOfLONG[b] = new WinDef.LONG(param1VarArgs[param1VarArgs.length - b - 1]);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  650 */       switch (getVarType().intValue()) {
/*      */         case 11:
/*  652 */           memory = new Memory(2L);
/*  653 */           if (param1Object instanceof Boolean) {
/*  654 */             memory.setShort(0L, (short)(((Boolean)param1Object).booleanValue() ? 65535 : 0));
/*      */           } else {
/*  656 */             memory.setShort(0L, (short)((((Number)param1Object).intValue() > 0) ? 65535 : 0));
/*      */           } 
/*  658 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, (Pointer)memory);
/*  659 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 16:
/*      */         case 17:
/*  663 */           memory = new Memory(1L);
/*  664 */           memory.setByte(0L, ((Number)param1Object).byteValue());
/*  665 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, (Pointer)memory);
/*  666 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 2:
/*      */         case 18:
/*  670 */           memory = new Memory(2L);
/*  671 */           memory.setShort(0L, ((Number)param1Object).shortValue());
/*  672 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, (Pointer)memory);
/*  673 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 3:
/*      */         case 19:
/*      */         case 22:
/*      */         case 23:
/*  679 */           memory = new Memory(4L);
/*  680 */           memory.setInt(0L, ((Number)param1Object).intValue());
/*  681 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, (Pointer)memory);
/*  682 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 10:
/*  685 */           memory = new Memory(4L);
/*  686 */           memory.setInt(0L, ((Number)param1Object).intValue());
/*  687 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, (Pointer)memory);
/*  688 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 4:
/*  691 */           memory = new Memory(4L);
/*  692 */           memory.setFloat(0L, ((Number)param1Object).floatValue());
/*  693 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, (Pointer)memory);
/*  694 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 5:
/*  697 */           memory = new Memory(8L);
/*  698 */           memory.setDouble(0L, ((Number)param1Object).doubleValue());
/*  699 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, (Pointer)memory);
/*  700 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 7:
/*  703 */           memory = new Memory(8L);
/*  704 */           memory.setDouble(0L, ((OaIdl.DATE)param1Object).date);
/*  705 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, (Pointer)memory);
/*  706 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 8:
/*  709 */           if (param1Object instanceof String) {
/*  710 */             WTypes.BSTR bSTR = OleAuto.INSTANCE.SysAllocString((String)param1Object);
/*  711 */             hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, bSTR.getPointer());
/*  712 */             OleAuto.INSTANCE.SysFreeString(bSTR);
/*  713 */             COMUtils.checkRC(hRESULT);
/*      */           } else {
/*  715 */             hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, ((WTypes.BSTR)param1Object).getPointer());
/*  716 */             COMUtils.checkRC(hRESULT);
/*      */           } 
/*      */           return;
/*      */         case 12:
/*  720 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, ((Variant.VARIANT)param1Object).getPointer());
/*  721 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 13:
/*  724 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, ((Unknown)param1Object).getPointer());
/*  725 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 9:
/*  728 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, ((Dispatch)param1Object).getPointer());
/*  729 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 6:
/*  732 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, ((OaIdl.CURRENCY)param1Object).getPointer());
/*  733 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */         case 14:
/*  736 */           hRESULT = OleAuto.INSTANCE.SafeArrayPutElement(this, arrayOfLONG, ((OaIdl.DECIMAL)param1Object).getPointer());
/*  737 */           COMUtils.checkRC(hRESULT);
/*      */           return;
/*      */       } 
/*      */       
/*  741 */       throw new IllegalStateException("Can't parse array content - type not supported: " + getVarType().intValue()); } public Object getElement(int... param1VarArgs) { Boolean bool; Byte byte_; Short short_; Integer integer; WinDef.SCODE sCODE; Float float_; Double double_;
/*      */       OaIdl.DATE dATE;
/*      */       String str;
/*      */       Variant.VARIANT vARIANT1;
/*      */       Unknown unknown;
/*      */       Dispatch dispatch;
/*      */       OaIdl.CURRENCY cURRENCY1;
/*      */       WinNT.HRESULT hRESULT;
/*      */       Memory memory;
/*      */       PointerByReference pointerByReference;
/*      */       WTypes.BSTR bSTR;
/*      */       Variant.VARIANT vARIANT2;
/*      */       OaIdl.CURRENCY cURRENCY2;
/*      */       OaIdl.DECIMAL dECIMAL;
/*  755 */       WinDef.LONG[] arrayOfLONG = new WinDef.LONG[param1VarArgs.length];
/*  756 */       for (byte b = 0; b < param1VarArgs.length; b++) {
/*  757 */         arrayOfLONG[b] = new WinDef.LONG(param1VarArgs[param1VarArgs.length - b - 1]);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  764 */       switch (getVarType().intValue()) {
/*      */         case 11:
/*  766 */           memory = new Memory(2L);
/*  767 */           hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, (Pointer)memory);
/*  768 */           COMUtils.checkRC(hRESULT);
/*  769 */           return Boolean.valueOf((memory.getShort(0L) != 0));
/*      */         
/*      */         case 16:
/*      */         case 17:
/*  773 */           memory = new Memory(1L);
/*  774 */           hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, (Pointer)memory);
/*  775 */           COMUtils.checkRC(hRESULT);
/*  776 */           return Byte.valueOf(memory.getByte(0L));
/*      */         
/*      */         case 2:
/*      */         case 18:
/*  780 */           memory = new Memory(2L);
/*  781 */           hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, (Pointer)memory);
/*  782 */           COMUtils.checkRC(hRESULT);
/*  783 */           return Short.valueOf(memory.getShort(0L));
/*      */         
/*      */         case 3:
/*      */         case 19:
/*      */         case 22:
/*      */         case 23:
/*  789 */           memory = new Memory(4L);
/*  790 */           hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, (Pointer)memory);
/*  791 */           COMUtils.checkRC(hRESULT);
/*  792 */           return Integer.valueOf(memory.getInt(0L));
/*      */         
/*      */         case 10:
/*  795 */           memory = new Memory(4L);
/*  796 */           hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, (Pointer)memory);
/*  797 */           COMUtils.checkRC(hRESULT);
/*  798 */           return new WinDef.SCODE(memory.getInt(0L));
/*      */         
/*      */         case 4:
/*  801 */           memory = new Memory(4L);
/*  802 */           hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, (Pointer)memory);
/*  803 */           COMUtils.checkRC(hRESULT);
/*  804 */           return Float.valueOf(memory.getFloat(0L));
/*      */         
/*      */         case 5:
/*  807 */           memory = new Memory(8L);
/*  808 */           hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, (Pointer)memory);
/*  809 */           COMUtils.checkRC(hRESULT);
/*  810 */           return Double.valueOf(memory.getDouble(0L));
/*      */         
/*      */         case 7:
/*  813 */           memory = new Memory(8L);
/*  814 */           hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, (Pointer)memory);
/*  815 */           COMUtils.checkRC(hRESULT);
/*  816 */           return new OaIdl.DATE(memory.getDouble(0L));
/*      */         
/*      */         case 8:
/*  819 */           pointerByReference = new PointerByReference();
/*  820 */           hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, pointerByReference.getPointer());
/*  821 */           COMUtils.checkRC(hRESULT);
/*  822 */           bSTR = new WTypes.BSTR(pointerByReference.getValue());
/*  823 */           str = bSTR.getValue();
/*  824 */           OleAuto.INSTANCE.SysFreeString(bSTR);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  861 */           return str;
/*      */         case 12:
/*      */           vARIANT2 = new Variant.VARIANT(); hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, vARIANT2.getPointer()); COMUtils.checkRC(hRESULT); return vARIANT2;
/*      */         case 13:
/*      */           pointerByReference = new PointerByReference(); hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, pointerByReference.getPointer()); COMUtils.checkRC(hRESULT); return new Unknown(pointerByReference.getValue());
/*      */         case 9:
/*      */           pointerByReference = new PointerByReference(); hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, pointerByReference.getPointer()); COMUtils.checkRC(hRESULT); return new Dispatch(pointerByReference.getValue());
/*      */         case 6:
/*      */           cURRENCY2 = new OaIdl.CURRENCY(); hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, cURRENCY2.getPointer()); COMUtils.checkRC(hRESULT);
/*      */           return cURRENCY2;
/*      */         case 14:
/*      */           dECIMAL = new OaIdl.DECIMAL();
/*      */           hRESULT = OleAuto.INSTANCE.SafeArrayGetElement(this, arrayOfLONG, dECIMAL.getPointer());
/*      */           COMUtils.checkRC(hRESULT);
/*      */           return dECIMAL;
/*      */       } 
/*  877 */       throw new IllegalStateException("Can't parse array content - type not supported: " + getVarType().intValue()); } public Pointer ptrOfIndex(int... param1VarArgs) { WinDef.LONG[] arrayOfLONG = new WinDef.LONG[param1VarArgs.length];
/*  878 */       for (byte b = 0; b < param1VarArgs.length; b++) {
/*  879 */         arrayOfLONG[b] = new WinDef.LONG(param1VarArgs[param1VarArgs.length - b - 1]);
/*      */       }
/*  881 */       PointerByReference pointerByReference = new PointerByReference();
/*  882 */       WinNT.HRESULT hRESULT = OleAuto.INSTANCE.SafeArrayPtrOfIndex(this, arrayOfLONG, pointerByReference);
/*  883 */       COMUtils.checkRC(hRESULT);
/*  884 */       return pointerByReference.getValue(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void destroy() {
/*  891 */       WinNT.HRESULT hRESULT = OleAuto.INSTANCE.SafeArrayDestroy(this);
/*  892 */       COMUtils.checkRC(hRESULT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/*  899 */       destroy();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getLBound(int param1Int) {
/*  912 */       int i = getDimensionCount() - param1Int;
/*  913 */       WinDef.LONGByReference lONGByReference = new WinDef.LONGByReference();
/*  914 */       WinNT.HRESULT hRESULT = OleAuto.INSTANCE.SafeArrayGetLBound(this, new WinDef.UINT(i), lONGByReference);
/*  915 */       COMUtils.checkRC(hRESULT);
/*  916 */       return lONGByReference.getValue().intValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getUBound(int param1Int) {
/*  929 */       int i = getDimensionCount() - param1Int;
/*  930 */       WinDef.LONGByReference lONGByReference = new WinDef.LONGByReference();
/*  931 */       WinNT.HRESULT hRESULT = OleAuto.INSTANCE.SafeArrayGetUBound(this, new WinDef.UINT(i), lONGByReference);
/*  932 */       COMUtils.checkRC(hRESULT);
/*  933 */       return lONGByReference.getValue().intValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getDimensionCount() {
/*  942 */       return OleAuto.INSTANCE.SafeArrayGetDim(this).intValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Pointer accessData() {
/*  951 */       PointerByReference pointerByReference = new PointerByReference();
/*  952 */       WinNT.HRESULT hRESULT = OleAuto.INSTANCE.SafeArrayAccessData(this, pointerByReference);
/*  953 */       COMUtils.checkRC(hRESULT);
/*  954 */       return pointerByReference.getValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unaccessData() {
/*  962 */       WinNT.HRESULT hRESULT = OleAuto.INSTANCE.SafeArrayUnaccessData(this);
/*  963 */       COMUtils.checkRC(hRESULT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void lock() {
/*  971 */       WinNT.HRESULT hRESULT = OleAuto.INSTANCE.SafeArrayLock(this);
/*  972 */       COMUtils.checkRC(hRESULT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unlock() {
/*  979 */       WinNT.HRESULT hRESULT = OleAuto.INSTANCE.SafeArrayUnlock(this);
/*  980 */       COMUtils.checkRC(hRESULT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void redim(int param1Int1, int param1Int2) {
/*  991 */       WinNT.HRESULT hRESULT = OleAuto.INSTANCE.SafeArrayRedim(this, new OaIdl.SAFEARRAYBOUND(param1Int1, param1Int2));
/*  992 */       COMUtils.checkRC(hRESULT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WTypes.VARTYPE getVarType() {
/* 1001 */       WTypes.VARTYPEByReference vARTYPEByReference = new WTypes.VARTYPEByReference();
/* 1002 */       WinNT.HRESULT hRESULT = OleAuto.INSTANCE.SafeArrayGetVartype(this, vARTYPEByReference);
/* 1003 */       COMUtils.checkRC(hRESULT);
/* 1004 */       return vARTYPEByReference.getValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public long getElemsize() {
/* 1013 */       return OleAuto.INSTANCE.SafeArrayGetElemsize(this).longValue();
/*      */     }
/*      */   }
/*      */   
/*      */   @FieldOrder({"pSAFEARRAY"})
/*      */   public static class SAFEARRAYByReference extends Structure implements Structure.ByReference {
/*      */     public OaIdl.SAFEARRAY.ByReference pSAFEARRAY;
/*      */     
/*      */     public SAFEARRAYByReference() {}
/*      */     
/*      */     public SAFEARRAYByReference(Pointer param1Pointer) {
/* 1024 */       super(param1Pointer);
/* 1025 */       read();
/*      */     }
/*      */     
/*      */     public SAFEARRAYByReference(OaIdl.SAFEARRAY.ByReference param1ByReference) {
/* 1029 */       this.pSAFEARRAY = param1ByReference;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"cElements", "lLbound"})
/*      */   public static class SAFEARRAYBOUND
/*      */     extends Structure
/*      */   {
/*      */     public WinDef.ULONG cElements;
/*      */     
/*      */     public WinDef.LONG lLbound;
/*      */     
/*      */     public static class ByReference
/*      */       extends SAFEARRAYBOUND
/*      */       implements Structure.ByReference {}
/*      */     
/*      */     public SAFEARRAYBOUND() {}
/*      */     
/*      */     public SAFEARRAYBOUND(Pointer param1Pointer) {
/* 1049 */       super(param1Pointer);
/* 1050 */       read();
/*      */     }
/*      */     
/*      */     public SAFEARRAYBOUND(int param1Int1, int param1Int2) {
/* 1054 */       this.cElements = new WinDef.ULONG(param1Int1);
/* 1055 */       this.lLbound = new WinDef.LONG(param1Int2);
/* 1056 */       write();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class CURRENCY
/*      */     extends Union
/*      */   {
/*      */     public _CURRENCY currency;
/*      */     public WinDef.LONGLONG int64;
/*      */     
/*      */     public static class ByReference
/*      */       extends CURRENCY
/*      */       implements Structure.ByReference {}
/*      */     
/*      */     public CURRENCY() {}
/*      */     
/*      */     public CURRENCY(Pointer param1Pointer) {
/* 1074 */       super(param1Pointer);
/* 1075 */       read();
/*      */     }
/*      */     
/*      */     @FieldOrder({"Lo", "Hi"})
/*      */     public static class _CURRENCY
/*      */       extends Structure
/*      */     {
/*      */       public WinDef.ULONG Lo;
/*      */       public WinDef.LONG Hi;
/*      */       
/*      */       public _CURRENCY() {}
/*      */       
/*      */       public _CURRENCY(Pointer param2Pointer) {
/* 1088 */         super(param2Pointer);
/* 1089 */         read();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   @FieldOrder({"wReserved", "decimal1", "Hi32", "decimal2"})
/*      */   public static class DECIMAL extends Structure { public short wReserved;
/*      */     public _DECIMAL1 decimal1;
/*      */     public NativeLong Hi32;
/*      */     public _DECIMAL2 decimal2;
/*      */     
/*      */     public static class ByReference extends DECIMAL implements Structure.ByReference {}
/*      */     
/*      */     public static class _DECIMAL1 extends Union {
/*      */       public WinDef.USHORT signscale;
/*      */       public _DECIMAL1_DECIMAL decimal1_DECIMAL;
/*      */       
/*      */       public _DECIMAL1() {
/* 1107 */         setType("signscale");
/*      */       }
/*      */       
/*      */       public _DECIMAL1(Pointer param2Pointer) {
/* 1111 */         super(param2Pointer);
/* 1112 */         setType("signscale");
/* 1113 */         read();
/*      */       }
/*      */       
/*      */       @FieldOrder({"scale", "sign"})
/*      */       public static class _DECIMAL1_DECIMAL
/*      */         extends Structure
/*      */       {
/*      */         public WinDef.BYTE scale;
/*      */         public WinDef.BYTE sign;
/*      */         
/*      */         public _DECIMAL1_DECIMAL() {}
/*      */         
/*      */         public _DECIMAL1_DECIMAL(Pointer param3Pointer) {
/* 1126 */           super(param3Pointer);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     public static class _DECIMAL2 extends Union {
/*      */       public WinDef.ULONGLONG Lo64;
/*      */       public _DECIMAL2_DECIMAL decimal2_DECIMAL;
/*      */       
/*      */       public _DECIMAL2() {
/* 1136 */         setType("Lo64");
/*      */       }
/*      */       
/*      */       public _DECIMAL2(Pointer param2Pointer) {
/* 1140 */         super(param2Pointer);
/* 1141 */         setType("Lo64");
/* 1142 */         read();
/*      */       }
/*      */ 
/*      */       
/*      */       @FieldOrder({"Lo32", "Mid32"})
/*      */       public static class _DECIMAL2_DECIMAL
/*      */         extends Structure
/*      */       {
/*      */         public WinDef.BYTE Lo32;
/*      */         public WinDef.BYTE Mid32;
/*      */         
/*      */         public _DECIMAL2_DECIMAL() {}
/*      */         
/*      */         public _DECIMAL2_DECIMAL(Pointer param3Pointer) {
/* 1156 */           super(param3Pointer);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public DECIMAL() {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public DECIMAL(Pointer param1Pointer) {
/* 1171 */       super(param1Pointer);
/*      */     } }
/*      */   
/*      */   @FieldOrder({"value"})
/*      */   public static class SYSKIND extends Structure {
/*      */     public int value;
/*      */     public static final int SYS_WIN16 = 0;
/*      */     public static final int SYS_WIN32 = 1;
/*      */     public static final int SYS_MAC = 2;
/*      */     public static final int SYS_WIN64 = 3;
/*      */     
/*      */     public static class ByReference extends SYSKIND implements Structure.ByReference {}
/*      */     
/*      */     public SYSKIND() {}
/*      */     
/*      */     public SYSKIND(int param1Int) {
/* 1187 */       this.value = param1Int;
/*      */     }
/*      */     
/*      */     public SYSKIND(Pointer param1Pointer) {
/* 1191 */       super(param1Pointer);
/* 1192 */       read();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"value"})
/*      */   public static class LIBFLAGS
/*      */     extends Structure
/*      */   {
/*      */     public int value;
/*      */     public static final int LIBFLAG_FRESTRICTED = 1;
/*      */     public static final int LIBFLAG_FCONTROL = 2;
/*      */     public static final int LIBFLAG_FHIDDEN = 4;
/*      */     public static final int LIBFLAG_FHASDISKIMAGE = 8;
/*      */     
/*      */     public static class ByReference
/*      */       extends LIBFLAGS
/*      */       implements Structure.ByReference {}
/*      */     
/*      */     public LIBFLAGS() {}
/*      */     
/*      */     public LIBFLAGS(int param1Int) {
/* 1214 */       this.value = param1Int;
/*      */     }
/*      */     
/*      */     public LIBFLAGS(Pointer param1Pointer) {
/* 1218 */       super(param1Pointer);
/* 1219 */       read();
/*      */     }
/*      */   }
/*      */   
/*      */   @FieldOrder({"guid", "lcid", "syskind", "wMajorVerNum", "wMinorVerNum", "wLibFlags"})
/*      */   public static class TLIBATTR
/*      */     extends Structure {
/*      */     public Guid.GUID guid;
/*      */     public WinDef.LCID lcid;
/*      */     public OaIdl.SYSKIND syskind;
/*      */     public WinDef.WORD wMajorVerNum;
/*      */     public WinDef.WORD wMinorVerNum;
/*      */     public WinDef.WORD wLibFlags;
/*      */     
/*      */     public static class ByReference
/*      */       extends TLIBATTR implements Structure.ByReference {
/*      */       public ByReference() {}
/*      */       
/*      */       public ByReference(Pointer param2Pointer) {
/* 1238 */         super(param2Pointer);
/* 1239 */         read();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TLIBATTR() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TLIBATTR(Pointer param1Pointer) {
/* 1255 */       super(param1Pointer);
/* 1256 */       read();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class BINDPTR
/*      */     extends Union
/*      */   {
/*      */     public OaIdl.FUNCDESC lpfuncdesc;
/*      */     
/*      */     public OaIdl.VARDESC lpvardesc;
/*      */     
/*      */     public TypeComp lptcomp;
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends BINDPTR
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */     
/*      */     public BINDPTR() {}
/*      */     
/*      */     public BINDPTR(OaIdl.VARDESC param1VARDESC) {
/* 1279 */       this.lpvardesc = param1VARDESC;
/* 1280 */       setType(OaIdl.VARDESC.class);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public BINDPTR(TypeComp param1TypeComp) {
/* 1286 */       this.lptcomp = param1TypeComp;
/* 1287 */       setType(TypeComp.class);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public BINDPTR(OaIdl.FUNCDESC param1FUNCDESC) {
/* 1293 */       this.lpfuncdesc = param1FUNCDESC;
/* 1294 */       setType(OaIdl.FUNCDESC.class);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"memid", "lprgscode", "lprgelemdescParam", "funckind", "invkind", "callconv", "cParams", "cParamsOpt", "oVft", "cScodes", "elemdescFunc", "wFuncFlags"})
/*      */   public static class FUNCDESC
/*      */     extends Structure
/*      */   {
/*      */     public OaIdl.MEMBERID memid;
/*      */     
/*      */     public OaIdl.ScodeArg.ByReference lprgscode;
/*      */     public OaIdl.ElemDescArg.ByReference lprgelemdescParam;
/*      */     public OaIdl.FUNCKIND funckind;
/*      */     public OaIdl.INVOKEKIND invkind;
/*      */     public OaIdl.CALLCONV callconv;
/*      */     public WinDef.SHORT cParams;
/*      */     public WinDef.SHORT cParamsOpt;
/*      */     public WinDef.SHORT oVft;
/*      */     public WinDef.SHORT cScodes;
/*      */     public OaIdl.ELEMDESC elemdescFunc;
/*      */     public WinDef.WORD wFuncFlags;
/*      */     
/*      */     public static class ByReference
/*      */       extends FUNCDESC
/*      */       implements Structure.ByReference {}
/*      */     
/*      */     public FUNCDESC() {}
/*      */     
/*      */     public FUNCDESC(Pointer param1Pointer) {
/* 1324 */       super(param1Pointer);
/* 1325 */       read();
/*      */       
/* 1327 */       if (this.cParams.shortValue() > 1) {
/* 1328 */         this.lprgelemdescParam
/* 1329 */           .elemDescArg = new OaIdl.ELEMDESC[this.cParams.shortValue()];
/* 1330 */         this.lprgelemdescParam.read();
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   @FieldOrder({"elemDescArg"})
/*      */   public static class ElemDescArg
/*      */     extends Structure {
/*      */     public static class ByReference
/*      */       extends ElemDescArg implements Structure.ByReference {}
/*      */     
/* 1341 */     public OaIdl.ELEMDESC[] elemDescArg = new OaIdl.ELEMDESC[] { new OaIdl.ELEMDESC() };
/*      */ 
/*      */     
/*      */     public ElemDescArg() {}
/*      */ 
/*      */     
/*      */     public ElemDescArg(Pointer param1Pointer) {
/* 1348 */       super(param1Pointer);
/* 1349 */       read();
/*      */     }
/*      */   }
/*      */   
/*      */   @FieldOrder({"scodeArg"})
/*      */   public static class ScodeArg
/*      */     extends Structure {
/*      */     public static class ByReference
/*      */       extends ScodeArg implements Structure.ByReference {}
/*      */     
/* 1359 */     public WinDef.SCODE[] scodeArg = new WinDef.SCODE[] { new WinDef.SCODE() };
/*      */ 
/*      */     
/*      */     public ScodeArg() {}
/*      */ 
/*      */     
/*      */     public ScodeArg(Pointer param1Pointer) {
/* 1366 */       super(param1Pointer);
/* 1367 */       read();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"memid", "lpstrSchema", "_vardesc", "elemdescVar", "wVarFlags", "varkind"})
/*      */   public static class VARDESC
/*      */     extends Structure
/*      */   {
/*      */     public OaIdl.MEMBERID memid;
/*      */     
/*      */     public WTypes.LPOLESTR lpstrSchema;
/*      */     
/*      */     public _VARDESC _vardesc;
/*      */     
/*      */     public OaIdl.ELEMDESC elemdescVar;
/*      */     
/*      */     public WinDef.WORD wVarFlags;
/*      */     
/*      */     public OaIdl.VARKIND varkind;
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends VARDESC
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */     
/*      */     public static class _VARDESC
/*      */       extends Union
/*      */     {
/*      */       public NativeLong oInst;
/*      */       
/*      */       public Variant.VARIANT.ByReference lpvarValue;
/*      */ 
/*      */       
/*      */       public static class ByReference
/*      */         extends _VARDESC
/*      */         implements Structure.ByReference {}
/*      */ 
/*      */       
/*      */       public _VARDESC() {
/* 1408 */         setType("lpvarValue");
/* 1409 */         read();
/*      */       }
/*      */       
/*      */       public _VARDESC(Pointer param2Pointer) {
/* 1413 */         super(param2Pointer);
/* 1414 */         setType("lpvarValue");
/* 1415 */         read();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public _VARDESC(Variant.VARIANT.ByReference param2ByReference) {
/* 1424 */         this.lpvarValue = param2ByReference;
/* 1425 */         setType("lpvarValue");
/*      */       }
/*      */ 
/*      */       
/*      */       public _VARDESC(NativeLong param2NativeLong) {
/* 1430 */         this.oInst = param2NativeLong;
/* 1431 */         setType("oInst");
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public VARDESC() {}
/*      */ 
/*      */     
/*      */     public VARDESC(Pointer param1Pointer) {
/* 1440 */       super(param1Pointer);
/* 1441 */       this._vardesc.setType("lpvarValue");
/* 1442 */       read();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"tdesc", "_elemdesc"})
/*      */   public static class ELEMDESC
/*      */     extends Structure
/*      */   {
/*      */     public OaIdl.TYPEDESC tdesc;
/*      */ 
/*      */     
/*      */     public _ELEMDESC _elemdesc;
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends ELEMDESC
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */ 
/*      */     
/*      */     public static class _ELEMDESC
/*      */       extends Union
/*      */     {
/*      */       public OaIdl.IDLDESC idldesc;
/*      */       
/*      */       public OaIdl.PARAMDESC paramdesc;
/*      */ 
/*      */       
/*      */       public static class ByReference
/*      */         extends _ELEMDESC
/*      */         implements Structure.ByReference {}
/*      */ 
/*      */       
/*      */       public _ELEMDESC() {}
/*      */ 
/*      */       
/*      */       public _ELEMDESC(Pointer param2Pointer) {
/* 1482 */         super(param2Pointer);
/* 1483 */         setType("paramdesc");
/* 1484 */         read();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public _ELEMDESC(OaIdl.PARAMDESC param2PARAMDESC) {
/* 1493 */         this.paramdesc = param2PARAMDESC;
/* 1494 */         setType("paramdesc");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public _ELEMDESC(OaIdl.IDLDESC param2IDLDESC) {
/* 1503 */         this.idldesc = param2IDLDESC;
/* 1504 */         setType("idldesc");
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public ELEMDESC() {}
/*      */ 
/*      */     
/*      */     public ELEMDESC(Pointer param1Pointer) {
/* 1513 */       super(param1Pointer);
/* 1514 */       read();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"value"})
/*      */   public static class FUNCKIND
/*      */     extends Structure
/*      */   {
/*      */     public static final int FUNC_VIRTUAL = 0;
/*      */     
/*      */     public static final int FUNC_PUREVIRTUAL = 1;
/*      */     
/*      */     public static final int FUNC_NONVIRTUAL = 2;
/*      */     
/*      */     public static final int FUNC_STATIC = 3;
/*      */     
/*      */     public static final int FUNC_DISPATCH = 4;
/*      */     
/*      */     public int value;
/*      */     
/*      */     public static class ByReference
/*      */       extends FUNCKIND
/*      */       implements Structure.ByReference {}
/*      */     
/*      */     public FUNCKIND() {}
/*      */     
/*      */     public FUNCKIND(int param1Int) {
/* 1542 */       this.value = param1Int;
/*      */     }
/*      */   }
/*      */   
/*      */   @FieldOrder({"value"})
/*      */   public static class INVOKEKIND
/*      */     extends Structure
/*      */   {
/*      */     public static class ByReference
/*      */       extends INVOKEKIND
/*      */       implements Structure.ByReference {}
/*      */     
/* 1554 */     public static final INVOKEKIND INVOKE_FUNC = new INVOKEKIND(1);
/*      */     
/* 1556 */     public static final INVOKEKIND INVOKE_PROPERTYGET = new INVOKEKIND(2);
/*      */     
/* 1558 */     public static final INVOKEKIND INVOKE_PROPERTYPUT = new INVOKEKIND(4);
/*      */     
/* 1560 */     public static final INVOKEKIND INVOKE_PROPERTYPUTREF = new INVOKEKIND(8);
/*      */     
/*      */     public int value;
/*      */ 
/*      */     
/*      */     public INVOKEKIND() {}
/*      */ 
/*      */     
/*      */     public INVOKEKIND(int param1Int) {
/* 1569 */       this.value = param1Int;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"value"})
/*      */   public static class CALLCONV
/*      */     extends Structure
/*      */   {
/*      */     public static final int CC_FASTCALL = 0;
/*      */     
/*      */     public static final int CC_CDECL = 1;
/*      */     
/*      */     public static final int CC_MSCPASCAL = 2;
/*      */     
/*      */     public static final int CC_PASCAL = 2;
/*      */     
/*      */     public static final int CC_MACPASCAL = 3;
/*      */     
/*      */     public static final int CC_STDCALL = 4;
/*      */     
/*      */     public static final int CC_FPFASTCALL = 5;
/*      */     
/*      */     public static final int CC_SYSCALL = 6;
/*      */     
/*      */     public static final int CC_MPWCDECL = 7;
/*      */     
/*      */     public static final int CC_MPWPASCAL = 8;
/*      */     
/*      */     public static final int CC_MAX = 9;
/*      */     
/*      */     public int value;
/*      */     
/*      */     public static class ByReference
/*      */       extends CALLCONV
/*      */       implements Structure.ByReference {}
/*      */     
/*      */     public CALLCONV() {}
/*      */     
/*      */     public CALLCONV(int param1Int) {
/* 1609 */       this.value = param1Int;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"value"})
/*      */   public static class VARKIND
/*      */     extends Structure
/*      */   {
/*      */     public static final int VAR_PERINSTANCE = 0;
/*      */     
/*      */     public static final int VAR_STATIC = 1;
/*      */     
/*      */     public static final int VAR_CONST = 2;
/*      */     
/*      */     public static final int VAR_DISPATCH = 3;
/*      */     
/*      */     public int value;
/*      */     
/*      */     public static class ByReference
/*      */       extends VARKIND
/*      */       implements Structure.ByReference {}
/*      */     
/*      */     public VARKIND() {}
/*      */     
/*      */     public VARKIND(int param1Int) {
/* 1635 */       this.value = param1Int;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"_typedesc", "vt"})
/*      */   public static class TYPEDESC
/*      */     extends Structure
/*      */   {
/*      */     public _TYPEDESC _typedesc;
/*      */     
/*      */     public WTypes.VARTYPE vt;
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends TYPEDESC
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */     
/*      */     public static class _TYPEDESC
/*      */       extends Union
/*      */     {
/*      */       public OaIdl.TYPEDESC.ByReference lptdesc;
/*      */       
/*      */       public OaIdl.ARRAYDESC.ByReference lpadesc;
/*      */       
/*      */       public OaIdl.HREFTYPE hreftype;
/*      */       
/*      */       public _TYPEDESC() {
/* 1664 */         setType("hreftype");
/* 1665 */         read();
/*      */       }
/*      */       
/*      */       public _TYPEDESC(Pointer param2Pointer) {
/* 1669 */         super(param2Pointer);
/* 1670 */         setType("hreftype");
/* 1671 */         read();
/*      */       }
/*      */       
/*      */       public OaIdl.TYPEDESC.ByReference getLptdesc() {
/* 1675 */         setType("lptdesc");
/* 1676 */         read();
/* 1677 */         return this.lptdesc;
/*      */       }
/*      */       
/*      */       public OaIdl.ARRAYDESC.ByReference getLpadesc() {
/* 1681 */         setType("lpadesc");
/* 1682 */         read();
/* 1683 */         return this.lpadesc;
/*      */       }
/*      */       
/*      */       public OaIdl.HREFTYPE getHreftype() {
/* 1687 */         setType("hreftype");
/* 1688 */         read();
/* 1689 */         return this.hreftype;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TYPEDESC() {
/* 1697 */       read();
/*      */     }
/*      */     
/*      */     public TYPEDESC(Pointer param1Pointer) {
/* 1701 */       super(param1Pointer);
/* 1702 */       read();
/*      */     }
/*      */     
/*      */     public TYPEDESC(_TYPEDESC param1_TYPEDESC, WTypes.VARTYPE param1VARTYPE) {
/* 1706 */       this._typedesc = param1_TYPEDESC;
/* 1707 */       this.vt = param1VARTYPE;
/*      */     }
/*      */   }
/*      */   
/*      */   @FieldOrder({"dwReserved", "wIDLFlags"})
/*      */   public static class IDLDESC
/*      */     extends Structure {
/*      */     public BaseTSD.ULONG_PTR dwReserved;
/*      */     public WinDef.USHORT wIDLFlags;
/*      */     
/*      */     public static class ByReference extends IDLDESC implements Structure.ByReference {
/*      */       public ByReference() {}
/*      */       
/*      */       public ByReference(OaIdl.IDLDESC param2IDLDESC) {
/* 1721 */         super(param2IDLDESC.dwReserved, param2IDLDESC.wIDLFlags);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public IDLDESC() {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public IDLDESC(Pointer param1Pointer) {
/* 1734 */       super(param1Pointer);
/* 1735 */       read();
/*      */     }
/*      */ 
/*      */     
/*      */     public IDLDESC(BaseTSD.ULONG_PTR param1ULONG_PTR, WinDef.USHORT param1USHORT) {
/* 1740 */       this.dwReserved = param1ULONG_PTR;
/* 1741 */       this.wIDLFlags = param1USHORT;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"tdescElem", "cDims", "rgbounds"})
/*      */   public static class ARRAYDESC
/*      */     extends Structure
/*      */   {
/*      */     public OaIdl.TYPEDESC tdescElem;
/*      */     
/*      */     public short cDims;
/*      */     
/* 1754 */     public OaIdl.SAFEARRAYBOUND[] rgbounds = new OaIdl.SAFEARRAYBOUND[] { new OaIdl.SAFEARRAYBOUND() };
/*      */ 
/*      */     
/*      */     public ARRAYDESC() {}
/*      */ 
/*      */     
/*      */     public ARRAYDESC(Pointer param1Pointer) {
/* 1761 */       super(param1Pointer);
/* 1762 */       read();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ARRAYDESC(OaIdl.TYPEDESC param1TYPEDESC, short param1Short, OaIdl.SAFEARRAYBOUND[] param1ArrayOfSAFEARRAYBOUND) {
/* 1774 */       this.tdescElem = param1TYPEDESC;
/* 1775 */       this.cDims = param1Short;
/* 1776 */       if (param1ArrayOfSAFEARRAYBOUND.length != this.rgbounds.length)
/* 1777 */         throw new IllegalArgumentException("Wrong array size !"); 
/* 1778 */       this.rgbounds = param1ArrayOfSAFEARRAYBOUND;
/*      */     }
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends ARRAYDESC
/*      */       implements Structure.ByReference {}
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"pparamdescex", "wParamFlags"})
/*      */   public static class PARAMDESC
/*      */     extends Structure
/*      */   {
/*      */     public Pointer pparamdescex;
/*      */     
/*      */     public WinDef.USHORT wParamFlags;
/*      */     
/*      */     public static class ByReference
/*      */       extends PARAMDESC
/*      */       implements Structure.ByReference {}
/*      */     
/*      */     public PARAMDESC() {}
/*      */     
/*      */     public PARAMDESC(Pointer param1Pointer) {
/* 1803 */       super(param1Pointer);
/* 1804 */       read();
/*      */     }
/*      */   }
/*      */   
/*      */   @FieldOrder({"cBytes", "varDefaultValue"})
/*      */   public static class PARAMDESCEX
/*      */     extends Structure
/*      */   {
/*      */     public WinDef.ULONG cBytes;
/*      */     public Variant.VariantArg varDefaultValue;
/*      */     
/*      */     public static class ByReference
/*      */       extends PARAMDESCEX
/*      */       implements Structure.ByReference {}
/*      */     
/*      */     public PARAMDESCEX() {}
/*      */     
/*      */     public PARAMDESCEX(Pointer param1Pointer) {
/* 1822 */       super(param1Pointer);
/* 1823 */       read();
/*      */     }
/*      */   }
/*      */   
/*      */   public static class HREFTYPE
/*      */     extends WinDef.DWORD
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */     public HREFTYPE() {}
/*      */     
/*      */     public HREFTYPE(long param1Long) {
/* 1835 */       super(param1Long);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class HREFTYPEByReference extends WinDef.DWORDByReference {
/*      */     public HREFTYPEByReference() {
/* 1841 */       this(new OaIdl.HREFTYPE(0L));
/*      */     }
/*      */     
/*      */     public HREFTYPEByReference(WinDef.DWORD param1DWORD) {
/* 1845 */       super(param1DWORD);
/*      */     }
/*      */     
/*      */     public void setValue(OaIdl.HREFTYPE param1HREFTYPE) {
/* 1849 */       getPointer().setInt(0L, param1HREFTYPE.intValue());
/*      */     }
/*      */ 
/*      */     
/*      */     public OaIdl.HREFTYPE getValue() {
/* 1854 */       return new OaIdl.HREFTYPE(getPointer().getInt(0L));
/*      */     }
/*      */   }
/*      */   
/*      */   @FieldOrder({"guid", "lcid", "dwReserved", "memidConstructor", "memidDestructor", "lpstrSchema", "cbSizeInstance", "typekind", "cFuncs", "cVars", "cImplTypes", "cbSizeVft", "cbAlignment", "wTypeFlags", "wMajorVerNum", "wMinorVerNum", "tdescAlias", "idldescType"})
/*      */   public static class TYPEATTR
/*      */     extends Structure {
/*      */     public Guid.GUID guid;
/*      */     public WinDef.LCID lcid;
/*      */     public WinDef.DWORD dwReserved;
/*      */     public OaIdl.MEMBERID memidConstructor;
/*      */     public OaIdl.MEMBERID memidDestructor;
/*      */     public WTypes.LPOLESTR lpstrSchema;
/*      */     public WinDef.ULONG cbSizeInstance;
/*      */     public OaIdl.TYPEKIND typekind;
/*      */     public WinDef.WORD cFuncs;
/*      */     public WinDef.WORD cVars;
/*      */     public WinDef.WORD cImplTypes;
/*      */     public WinDef.WORD cbSizeVft;
/*      */     public WinDef.WORD cbAlignment;
/*      */     public WinDef.WORD wTypeFlags;
/*      */     public WinDef.WORD wMajorVerNum;
/*      */     public WinDef.WORD wMinorVerNum;
/*      */     public OaIdl.TYPEDESC tdescAlias;
/*      */     public OaIdl.IDLDESC idldescType;
/*      */     public static final int TYPEFLAGS_FAPPOBJECT = 1;
/*      */     public static final int TYPEFLAGS_FCANCREATE = 2;
/*      */     public static final int TYPEFLAGS_FLICENSED = 4;
/*      */     public static final int TYPEFLAGS_FPREDECLID = 8;
/*      */     public static final int TYPEFLAGS_FHIDDEN = 16;
/*      */     public static final int TYPEFLAGS_FCONTROL = 32;
/*      */     public static final int TYPEFLAGS_FDUAL = 64;
/*      */     public static final int TYPEFLAGS_FNONEXTENSIBLE = 128;
/*      */     public static final int TYPEFLAGS_FOLEAUTOMATION = 256;
/*      */     public static final int TYPEFLAGS_FRESTRICTED = 512;
/*      */     public static final int TYPEFLAGS_FAGGREGATABLE = 1024;
/*      */     public static final int TYPEFLAGS_FREPLACEABLE = 2048;
/*      */     public static final int TYPEFLAGS_FDISPATCHABLE = 4096;
/*      */     public static final int TYPEFLAGS_FREVERSEBIND = 8192;
/*      */     public static final int TYPEFLAGS_FPROXY = 16384;
/*      */     
/*      */     public static class ByReference
/*      */       extends TYPEATTR implements Structure.ByReference {}
/*      */     
/*      */     public TYPEATTR() {}
/*      */     
/*      */     public TYPEATTR(Pointer param1Pointer) {
/* 1901 */       super(param1Pointer);
/* 1902 */       read();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\OaIdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */