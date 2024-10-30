/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.PointerType;
/*     */ import com.sun.jna.Structure;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface WTypes
/*     */ {
/*     */   public static final int CLSCTX_INPROC_SERVER = 1;
/*     */   public static final int CLSCTX_INPROC_HANDLER = 2;
/*     */   public static final int CLSCTX_LOCAL_SERVER = 4;
/*     */   public static final int CLSCTX_INPROC_SERVER16 = 8;
/*     */   public static final int CLSCTX_REMOTE_SERVER = 16;
/*     */   public static final int CLSCTX_INPROC_HANDLER16 = 32;
/*     */   public static final int CLSCTX_RESERVED1 = 64;
/*     */   public static final int CLSCTX_RESERVED2 = 128;
/*     */   public static final int CLSCTX_RESERVED3 = 256;
/*     */   public static final int CLSCTX_RESERVED4 = 512;
/*     */   public static final int CLSCTX_NO_CODE_DOWNLOAD = 1024;
/*     */   public static final int CLSCTX_RESERVED5 = 2048;
/*     */   public static final int CLSCTX_NO_CUSTOM_MARSHAL = 4096;
/*     */   public static final int CLSCTX_ENABLE_CODE_DOWNLOAD = 8192;
/*     */   public static final int CLSCTX_NO_FAILURE_LOG = 16384;
/*     */   public static final int CLSCTX_DISABLE_AAA = 32768;
/*     */   public static final int CLSCTX_ENABLE_AAA = 65536;
/*     */   public static final int CLSCTX_FROM_DEFAULT_CONTEXT = 131072;
/*     */   public static final int CLSCTX_ACTIVATE_32_BIT_SERVER = 262144;
/*     */   public static final int CLSCTX_ACTIVATE_64_BIT_SERVER = 524288;
/*     */   public static final int CLSCTX_ENABLE_CLOAKING = 1048576;
/*     */   public static final int CLSCTX_APPCONTAINER = 4194304;
/*     */   public static final int CLSCTX_ACTIVATE_AAA_AS_IU = 8388608;
/*     */   public static final int CLSCTX_PS_DLL = -2147483648;
/*     */   public static final int CLSCTX_SERVER = 21;
/*     */   public static final int CLSCTX_ALL = 7;
/*     */   
/*     */   public static class BSTR
/*     */     extends PointerType
/*     */   {
/*     */     public BSTR() {
/* 104 */       super(Pointer.NULL);
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
/*     */     public BSTR(Pointer param1Pointer) {
/* 117 */       super(param1Pointer);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public BSTR(String param1String) {
/* 127 */       setValue(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public void setValue(String param1String) {
/* 135 */       if (param1String == null) {
/* 136 */         param1String = "";
/*     */       }
/*     */       try {
/* 139 */         byte[] arrayOfByte = param1String.getBytes("UTF-16LE");
/*     */ 
/*     */         
/* 142 */         Memory memory = new Memory((4 + arrayOfByte.length + 2));
/* 143 */         memory.clear();
/* 144 */         memory.setInt(0L, arrayOfByte.length);
/* 145 */         memory.write(4L, arrayOfByte, 0, arrayOfByte.length);
/* 146 */         setPointer(memory.share(4L));
/* 147 */       } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 148 */         throw new RuntimeException("UTF-16LE charset is not supported", unsupportedEncodingException);
/*     */       } 
/*     */     }
/*     */     
/*     */     public String getValue() {
/*     */       try {
/* 154 */         Pointer pointer = getPointer();
/* 155 */         if (pointer == null) {
/* 156 */           return "";
/*     */         }
/* 158 */         int i = pointer.getInt(-4L);
/* 159 */         return new String(pointer.getByteArray(0L, i), "UTF-16LE");
/* 160 */       } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 161 */         throw new RuntimeException("UTF-16LE charset is not supported", unsupportedEncodingException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 167 */       return getValue();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BSTRByReference extends com.sun.jna.ptr.ByReference {
/*     */     public BSTRByReference() {
/* 173 */       super(Native.POINTER_SIZE);
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
/*     */     public BSTRByReference(WTypes.BSTR param1BSTR) {
/* 187 */       this();
/* 188 */       setValue(param1BSTR);
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
/*     */     public void setValue(WTypes.BSTR param1BSTR) {
/* 202 */       getPointer().setPointer(0L, param1BSTR.getPointer());
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
/*     */     public WTypes.BSTR getValue() {
/* 214 */       return new WTypes.BSTR(getPointer().getPointer(0L));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getString() {
/* 224 */       WTypes.BSTR bSTR = getValue();
/* 225 */       return (bSTR == null) ? null : bSTR.getValue();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LPSTR
/*     */     extends PointerType {
/*     */     public static class ByReference
/*     */       extends LPSTR implements Structure.ByReference {}
/*     */     
/*     */     public LPSTR() {
/* 235 */       super(Pointer.NULL);
/*     */     }
/*     */     
/*     */     public LPSTR(Pointer param1Pointer) {
/* 239 */       super(param1Pointer);
/*     */     }
/*     */     
/*     */     public LPSTR(String param1String) {
/* 243 */       this((Pointer)new Memory(param1String.length() + 1L));
/* 244 */       setValue(param1String);
/*     */     }
/*     */     
/*     */     public void setValue(String param1String) {
/* 248 */       getPointer().setString(0L, param1String);
/*     */     }
/*     */     
/*     */     public String getValue() {
/* 252 */       Pointer pointer = getPointer();
/* 253 */       String str = null;
/* 254 */       if (pointer != null) {
/* 255 */         str = pointer.getString(0L);
/*     */       }
/* 257 */       return str;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 262 */       return getValue();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LPWSTR
/*     */     extends PointerType {
/*     */     public static class ByReference
/*     */       extends LPWSTR implements Structure.ByReference {}
/*     */     
/*     */     public LPWSTR() {
/* 272 */       super(Pointer.NULL);
/*     */     }
/*     */     
/*     */     public LPWSTR(Pointer param1Pointer) {
/* 276 */       super(param1Pointer);
/*     */     }
/*     */     
/*     */     public LPWSTR(String param1String) {
/* 280 */       this((Pointer)new Memory((param1String.length() + 1L) * Native.WCHAR_SIZE));
/* 281 */       setValue(param1String);
/*     */     }
/*     */     
/*     */     public void setValue(String param1String) {
/* 285 */       getPointer().setWideString(0L, param1String);
/*     */     }
/*     */     
/*     */     public String getValue() {
/* 289 */       Pointer pointer = getPointer();
/* 290 */       String str = null;
/* 291 */       if (pointer != null) {
/* 292 */         str = pointer.getWideString(0L);
/*     */       }
/* 294 */       return str;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 299 */       return getValue();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LPOLESTR
/*     */     extends PointerType {
/*     */     public static class ByReference
/*     */       extends LPOLESTR implements Structure.ByReference {}
/*     */     
/*     */     public LPOLESTR() {
/* 309 */       super(Pointer.NULL);
/*     */     }
/*     */     
/*     */     public LPOLESTR(Pointer param1Pointer) {
/* 313 */       super(param1Pointer);
/*     */     }
/*     */     
/*     */     public LPOLESTR(String param1String) {
/* 317 */       super((Pointer)new Memory((param1String.length() + 1L) * Native.WCHAR_SIZE));
/* 318 */       setValue(param1String);
/*     */     }
/*     */     
/*     */     public void setValue(String param1String) {
/* 322 */       getPointer().setWideString(0L, param1String);
/*     */     }
/*     */     
/*     */     public String getValue() {
/* 326 */       Pointer pointer = getPointer();
/* 327 */       String str = null;
/* 328 */       if (pointer != null) {
/* 329 */         str = pointer.getWideString(0L);
/*     */       }
/* 331 */       return str;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 336 */       return getValue();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class VARTYPE extends WinDef.USHORT {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public VARTYPE() {
/* 344 */       this(0);
/*     */     }
/*     */     
/*     */     public VARTYPE(int param1Int) {
/* 348 */       super(param1Int);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class VARTYPEByReference extends com.sun.jna.ptr.ByReference {
/*     */     public VARTYPEByReference() {
/* 354 */       super(2);
/*     */     }
/*     */     
/*     */     public VARTYPEByReference(WTypes.VARTYPE param1VARTYPE) {
/* 358 */       super(2);
/* 359 */       setValue(param1VARTYPE);
/*     */     }
/*     */     
/*     */     public VARTYPEByReference(short param1Short) {
/* 363 */       super(2);
/* 364 */       getPointer().setShort(0L, param1Short);
/*     */     }
/*     */     
/*     */     public void setValue(WTypes.VARTYPE param1VARTYPE) {
/* 368 */       getPointer().setShort(0L, param1VARTYPE.shortValue());
/*     */     }
/*     */     
/*     */     public WTypes.VARTYPE getValue() {
/* 372 */       return new WTypes.VARTYPE(getPointer().getShort(0L));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\WTypes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */