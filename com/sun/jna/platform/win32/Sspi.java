/*      */ package com.sun.jna.platform.win32;
/*      */ 
/*      */ import com.sun.jna.Memory;
/*      */ import com.sun.jna.Pointer;
/*      */ import com.sun.jna.Structure;
/*      */ import com.sun.jna.Structure.FieldOrder;
/*      */ import com.sun.jna.win32.W32APITypeMapper;
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
/*      */ public interface Sspi
/*      */ {
/*      */   public static final int MAX_TOKEN_SIZE = 12288;
/*      */   public static final int SECPKG_CRED_INBOUND = 1;
/*      */   public static final int SECPKG_CRED_OUTBOUND = 2;
/*      */   public static final int SECURITY_NATIVE_DREP = 16;
/*      */   public static final int SECURITY_NETWORK_DREP = 0;
/*      */   public static final int ISC_REQ_ALLOCATE_MEMORY = 256;
/*      */   public static final int ISC_REQ_CONFIDENTIALITY = 16;
/*      */   public static final int ISC_REQ_CONNECTION = 2048;
/*      */   public static final int ISC_REQ_DELEGATE = 1;
/*      */   public static final int ISC_REQ_EXTENDED_ERROR = 16384;
/*      */   public static final int ISC_REQ_INTEGRITY = 65536;
/*      */   public static final int ISC_REQ_MUTUAL_AUTH = 2;
/*      */   public static final int ISC_REQ_REPLAY_DETECT = 4;
/*      */   public static final int ISC_REQ_SEQUENCE_DETECT = 8;
/*      */   public static final int ISC_REQ_STREAM = 32768;
/*      */   public static final int SECBUFFER_VERSION = 0;
/*      */   public static final int SECBUFFER_EMPTY = 0;
/*      */   public static final int SECBUFFER_DATA = 1;
/*      */   public static final int SECBUFFER_TOKEN = 2;
/*      */   public static final int SECPKG_ATTR_SIZES = 0;
/*      */   public static final int SECPKG_ATTR_NAMES = 1;
/*      */   public static final int SECPKG_ATTR_LIFESPAN = 2;
/*      */   public static final int SECPKG_ATTR_DCE_INFO = 3;
/*      */   public static final int SECPKG_ATTR_STREAM_SIZES = 4;
/*      */   public static final int SECPKG_ATTR_KEY_INFO = 5;
/*      */   public static final int SECPKG_ATTR_AUTHORITY = 6;
/*      */   public static final int SECPKG_ATTR_PROTO_INFO = 7;
/*      */   public static final int SECPKG_ATTR_PASSWORD_EXPIRY = 8;
/*      */   public static final int SECPKG_ATTR_SESSION_KEY = 9;
/*      */   public static final int SECPKG_ATTR_PACKAGE_INFO = 10;
/*      */   public static final int SECPKG_ATTR_USER_FLAGS = 11;
/*      */   public static final int SECPKG_ATTR_NEGOTIATION_INFO = 12;
/*      */   public static final int SECPKG_ATTR_NATIVE_NAMES = 13;
/*      */   public static final int SECPKG_ATTR_FLAGS = 14;
/*      */   public static final int SECPKG_ATTR_USE_VALIDATED = 15;
/*      */   public static final int SECPKG_ATTR_CREDENTIAL_NAME = 16;
/*      */   public static final int SECPKG_ATTR_TARGET_INFORMATION = 17;
/*      */   public static final int SECPKG_ATTR_ACCESS_TOKEN = 18;
/*      */   public static final int SECPKG_ATTR_TARGET = 19;
/*      */   public static final int SECPKG_ATTR_AUTHENTICATION_ID = 20;
/*      */   public static final int SECPKG_ATTR_LOGOFF_TIME = 21;
/*      */   public static final int SECPKG_ATTR_NEGO_KEYS = 22;
/*      */   public static final int SECPKG_ATTR_PROMPTING_NEEDED = 24;
/*      */   public static final int SECPKG_ATTR_UNIQUE_BINDINGS = 25;
/*      */   public static final int SECPKG_ATTR_ENDPOINT_BINDINGS = 26;
/*      */   public static final int SECPKG_ATTR_CLIENT_SPECIFIED_TARGET = 27;
/*      */   public static final int SECPKG_ATTR_LAST_CLIENT_TOKEN_STATUS = 30;
/*      */   public static final int SECPKG_ATTR_NEGO_PKG_INFO = 31;
/*      */   public static final int SECPKG_ATTR_NEGO_STATUS = 32;
/*      */   public static final int SECPKG_ATTR_CONTEXT_DELETED = 33;
/*      */   public static final int SECPKG_ATTR_SUBJECT_SECURITY_ATTRIBUTES = 128;
/*      */   public static final int SECPKG_NEGOTIATION_COMPLETE = 0;
/*      */   public static final int SECPKG_NEGOTIATION_OPTIMISTIC = 1;
/*      */   public static final int SECPKG_NEGOTIATION_IN_PROGRESS = 2;
/*      */   public static final int SECPKG_NEGOTIATION_DIRECT = 3;
/*      */   public static final int SECPKG_NEGOTIATION_TRY_MULTICRED = 4;
/*      */   public static final int SECPKG_FLAG_INTEGRITY = 1;
/*      */   public static final int SECPKG_FLAG_PRIVACY = 2;
/*      */   public static final int SECPKG_FLAG_TOKEN_ONLY = 4;
/*      */   public static final int SECPKG_FLAG_DATAGRAM = 8;
/*      */   public static final int SECPKG_FLAG_CONNECTION = 16;
/*      */   public static final int SECPKG_FLAG_MULTI_REQUIRED = 32;
/*      */   public static final int SECPKG_FLAG_CLIENT_ONLY = 64;
/*      */   public static final int SECPKG_FLAG_EXTENDED_ERROR = 128;
/*      */   public static final int SECPKG_FLAG_IMPERSONATION = 256;
/*      */   public static final int SECPKG_FLAG_ACCEPT_WIN32_NAME = 512;
/*      */   public static final int SECPKG_FLAG_STREAM = 1024;
/*      */   public static final int SECPKG_FLAG_NEGOTIABLE = 2048;
/*      */   public static final int SECPKG_FLAG_GSS_COMPATIBLE = 4096;
/*      */   public static final int SECPKG_FLAG_LOGON = 8192;
/*      */   public static final int SECPKG_FLAG_ASCII_BUFFERS = 16384;
/*      */   public static final int SECPKG_FLAG_FRAGMENT = 32768;
/*      */   public static final int SECPKG_FLAG_MUTUAL_AUTH = 65536;
/*      */   public static final int SECPKG_FLAG_DELEGATION = 131072;
/*      */   public static final int SECPKG_FLAG_RESTRICTED_TOKENS = 524288;
/*      */   public static final int SECPKG_FLAG_NEGO_EXTENDER = 1048576;
/*      */   public static final int SECPKG_FLAG_NEGOTIABLE2 = 2097152;
/*      */   public static final int SECPKG_FLAG_APPCONTAINER_PASSTHROUGH = 4194304;
/*      */   public static final int SECPKG_FLAG_APPCONTAINER_CHECKS = 8388608;
/*      */   public static final int SECPKG_CRED_ATTR_NAMES = 1;
/*      */   public static final int SECQOP_WRAP_NO_ENCRYPT = -2147483647;
/*      */   public static final int SECQOP_WRAP_OOB_DATA = 1073741824;
/*      */   public static final int SEC_WINNT_AUTH_IDENTITY_ANSI = 1;
/*      */   public static final int SEC_WINNT_AUTH_IDENTITY_UNICODE = 2;
/*      */   
/*      */   @FieldOrder({"dwLower", "dwUpper"})
/*      */   public static class SecHandle
/*      */     extends Structure
/*      */   {
/*      */     public Pointer dwLower;
/*      */     public Pointer dwUpper;
/*      */     
/*      */     public static class ByReference
/*      */       extends SecHandle
/*      */       implements Structure.ByReference {}
/*      */     
/*      */     public boolean isNull() {
/*  495 */       return (this.dwLower == null && this.dwUpper == null);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"secHandle"})
/*      */   public static class PSecHandle
/*      */     extends Structure
/*      */   {
/*      */     public Sspi.SecHandle.ByReference secHandle;
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends PSecHandle
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */     
/*      */     public PSecHandle() {}
/*      */ 
/*      */     
/*      */     public PSecHandle(Sspi.SecHandle param1SecHandle) {
/*  518 */       super(param1SecHandle.getPointer());
/*  519 */       read();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class CredHandle
/*      */     extends SecHandle {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class CtxtHandle
/*      */     extends SecHandle {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"cbBuffer", "BufferType", "pvBuffer"})
/*      */   public static class SecBuffer
/*      */     extends Structure
/*      */   {
/*      */     public int cbBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends SecBuffer
/*      */       implements Structure.ByReference
/*      */     {
/*      */       public ByReference() {}
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByReference(int param2Int1, int param2Int2) {
/*  560 */         super(param2Int1, param2Int2);
/*      */       }
/*      */       
/*      */       public ByReference(int param2Int, byte[] param2ArrayOfbyte) {
/*  564 */         super(param2Int, param2ArrayOfbyte);
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
/*  576 */     public int BufferType = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Pointer pvBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SecBuffer() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SecBuffer(int param1Int1, int param1Int2) {
/*  597 */       this.cbBuffer = param1Int2;
/*  598 */       this.pvBuffer = (Pointer)new Memory(param1Int2);
/*  599 */       this.BufferType = param1Int1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SecBuffer(int param1Int, byte[] param1ArrayOfbyte) {
/*  610 */       this.cbBuffer = param1ArrayOfbyte.length;
/*  611 */       this.pvBuffer = (Pointer)new Memory(param1ArrayOfbyte.length);
/*  612 */       this.pvBuffer.write(0L, param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
/*  613 */       this.BufferType = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getBytes() {
/*  622 */       return (this.pvBuffer == null) ? null : this.pvBuffer.getByteArray(0L, this.cbBuffer);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"ulVersion", "cBuffers", "pBuffers"})
/*      */   public static class SecBufferDesc
/*      */     extends Structure
/*      */   {
/*  643 */     public int ulVersion = 0;
/*      */ 
/*      */ 
/*      */     
/*  647 */     public int cBuffers = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Pointer pBuffers;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"dwLower", "dwUpper"})
/*      */   public static class SECURITY_INTEGER
/*      */     extends Structure
/*      */   {
/*      */     public int dwLower;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int dwUpper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class TimeStamp
/*      */     extends SECURITY_INTEGER {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"pPkgInfo"})
/*      */   public static class PSecPkgInfo
/*      */     extends Structure
/*      */   {
/*      */     public Sspi.SecPkgInfo.ByReference pPkgInfo;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends PSecPkgInfo
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Sspi.SecPkgInfo.ByReference[] toArray(int param1Int) {
/*  700 */       return (Sspi.SecPkgInfo.ByReference[])this.pPkgInfo.toArray(param1Int);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"fCapabilities", "wVersion", "wRPCID", "cbMaxToken", "Name", "Comment"})
/*      */   public static class SecPkgInfo
/*      */     extends Structure
/*      */   {
/*      */     public int fCapabilities;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends SecPkgInfo
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  724 */     public short wVersion = 1;
/*      */ 
/*      */ 
/*      */     
/*      */     public short wRPCID;
/*      */ 
/*      */ 
/*      */     
/*      */     public int cbMaxToken;
/*      */ 
/*      */ 
/*      */     
/*      */     public String Name;
/*      */ 
/*      */ 
/*      */     
/*      */     public String Comment;
/*      */ 
/*      */ 
/*      */     
/*      */     public SecPkgInfo() {
/*  745 */       super(W32APITypeMapper.DEFAULT);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"PackageInfo"})
/*      */   public static class SecPkgContext_PackageInfo
/*      */     extends Structure
/*      */   {
/*      */     public Sspi.SecPkgInfo.ByReference PackageInfo;
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends SecPkgContext_PackageInfo
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */ 
/*      */     
/*      */     public SecPkgContext_PackageInfo() {
/*  767 */       super(W32APITypeMapper.DEFAULT);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"sUserName"})
/*      */   public static class SecPkgCredentials_Names
/*      */     extends Structure
/*      */   {
/*      */     public Pointer sUserName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends SecPkgCredentials_Names
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SecPkgCredentials_Names() {
/*  796 */       super(W32APITypeMapper.DEFAULT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public synchronized String getUserName() {
/*  803 */       if (this.sUserName == null) {
/*  804 */         return null;
/*      */       }
/*  806 */       return Boolean.getBoolean("w32.ascii") ? this.sUserName.getString(0L) : this.sUserName.getWideString(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public synchronized int free() {
/*  815 */       if (this.sUserName != null) {
/*  816 */         int i = Secur32.INSTANCE.FreeContextBuffer(this.sUserName);
/*  817 */         this.sUserName = null;
/*  818 */         return i;
/*      */       } 
/*  820 */       return 0;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"cbMaxToken", "cbMaxSignature", "cbBlockSize", "cbSecurityTrailer"})
/*      */   public static class SecPkgContext_Sizes
/*      */     extends Structure
/*      */   {
/*      */     public int cbMaxToken;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int cbMaxSignature;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int cbBlockSize;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int cbSecurityTrailer;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends SecPkgContext_Sizes
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SecPkgContext_Sizes() {
/*  860 */       super(W32APITypeMapper.DEFAULT);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  865 */       return "SecPkgContext_Sizes{cbMaxToken=" + this.cbMaxToken + ", cbMaxSignature=" + this.cbMaxSignature + ", cbBlockSize=" + this.cbBlockSize + ", cbSecurityTrailer=" + this.cbSecurityTrailer + '}';
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"SessionKeyLength", "SessionKey"})
/*      */   public static class SecPkgContext_SessionKey
/*      */     extends Structure
/*      */   {
/*      */     public int SessionKeyLength;
/*      */ 
/*      */     
/*      */     public Pointer SessionKey;
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends SecPkgContext_SessionKey
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */ 
/*      */     
/*      */     public SecPkgContext_SessionKey() {
/*  890 */       super(W32APITypeMapper.DEFAULT);
/*      */     }
/*      */     
/*      */     public byte[] getSessionKey() {
/*  894 */       if (this.SessionKey == null) {
/*  895 */         return null;
/*      */       }
/*  897 */       return this.SessionKey.getByteArray(0L, this.SessionKeyLength);
/*      */     }
/*      */     
/*      */     public synchronized void free() {
/*  901 */       if (this.SessionKey != null) {
/*  902 */         Secur32.INSTANCE.FreeContextBuffer(this.SessionKey);
/*  903 */         this.SessionKey = null;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"sSignatureAlgorithmName", "sEncryptAlgorithmName", "KeySize", "SignatureAlgorithm", "EncryptAlgorithm"})
/*      */   public static class SecPkgContext_KeyInfo
/*      */     extends Structure
/*      */   {
/*      */     public Pointer sSignatureAlgorithmName;
/*      */ 
/*      */ 
/*      */     
/*      */     public Pointer sEncryptAlgorithmName;
/*      */ 
/*      */ 
/*      */     
/*      */     public int KeySize;
/*      */ 
/*      */ 
/*      */     
/*      */     public int SignatureAlgorithm;
/*      */ 
/*      */ 
/*      */     
/*      */     public int EncryptAlgorithm;
/*      */ 
/*      */ 
/*      */     
/*      */     public SecPkgContext_KeyInfo() {
/*  936 */       super(W32APITypeMapper.DEFAULT);
/*      */     }
/*      */     
/*      */     public synchronized String getSignatureAlgorithmName() {
/*  940 */       if (this.sSignatureAlgorithmName == null) {
/*  941 */         return null;
/*      */       }
/*  943 */       return Boolean.getBoolean("w32.ascii") ? this.sSignatureAlgorithmName.getString(0L) : this.sSignatureAlgorithmName.getWideString(0L);
/*      */     }
/*      */     
/*      */     public synchronized String getEncryptAlgorithmName() {
/*  947 */       if (this.sEncryptAlgorithmName == null) {
/*  948 */         return null;
/*      */       }
/*  950 */       return Boolean.getBoolean("w32.ascii") ? this.sEncryptAlgorithmName.getString(0L) : this.sEncryptAlgorithmName.getWideString(0L);
/*      */     }
/*      */     
/*      */     public synchronized void free() {
/*  954 */       if (this.sSignatureAlgorithmName != null) {
/*  955 */         Secur32.INSTANCE.FreeContextBuffer(this.sSignatureAlgorithmName);
/*  956 */         this.sSignatureAlgorithmName = null;
/*      */       } 
/*  958 */       if (this.sEncryptAlgorithmName != null) {
/*  959 */         Secur32.INSTANCE.FreeContextBuffer(this.sEncryptAlgorithmName);
/*  960 */         this.sEncryptAlgorithmName = null;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"tsStart", "tsExpiry"})
/*      */   public static class SecPkgContext_Lifespan
/*      */     extends Structure
/*      */   {
/*      */     public Sspi.TimeStamp tsStart;
/*      */ 
/*      */     
/*      */     public Sspi.TimeStamp tsExpiry;
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends SecPkgContext_Lifespan
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */     
/*      */     public SecPkgContext_Lifespan() {
/*  983 */       super(W32APITypeMapper.DEFAULT);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"PackageInfo", "NegotiationState"})
/*      */   public static class SecPkgContext_NegotiationInfo
/*      */     extends Structure
/*      */   {
/*      */     public Sspi.PSecPkgInfo PackageInfo;
/*      */ 
/*      */     
/*      */     public int NegotiationState;
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends SecPkgContext_NegotiationInfo
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */     
/*      */     public SecPkgContext_NegotiationInfo() {
/* 1005 */       super(W32APITypeMapper.DEFAULT);
/*      */     }
/*      */     
/*      */     public synchronized void free() {
/* 1009 */       if (this.PackageInfo != null) {
/* 1010 */         Secur32.INSTANCE.FreeContextBuffer(this.PackageInfo.pPkgInfo.getPointer());
/* 1011 */         this.PackageInfo = null;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"Flags"})
/*      */   public static class SecPkgContext_Flags
/*      */     extends Structure
/*      */   {
/*      */     public int Flags;
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends SecPkgContext_Flags
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */     
/*      */     public SecPkgContext_Flags() {
/* 1031 */       super(W32APITypeMapper.DEFAULT);
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
/*      */   
/*      */   @FieldOrder({"User", "UserLength", "Domain", "DomainLength", "Password", "PasswordLength", "Flags"})
/*      */   public static class SEC_WINNT_AUTH_IDENTITY
/*      */     extends Structure
/*      */   {
/*      */     public String User;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int UserLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String Domain;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int DomainLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String Password;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int PasswordLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1095 */     public int Flags = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SEC_WINNT_AUTH_IDENTITY() {
/* 1101 */       super(W32APITypeMapper.UNICODE);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write() {
/* 1106 */       this.UserLength = (this.User == null) ? 0 : this.User.length();
/* 1107 */       this.DomainLength = (this.Domain == null) ? 0 : this.Domain.length();
/* 1108 */       this.PasswordLength = (this.Password == null) ? 0 : this.Password.length();
/* 1109 */       super.write();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Sspi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */