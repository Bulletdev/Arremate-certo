/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import com.sun.jna.Union;
/*     */ import com.sun.jna.win32.StdCallLibrary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface WinRas
/*     */ {
/*     */   public static final int ERROR_BUFFER_TOO_SMALL = 603;
/*     */   public static final int ERROR_CANNOT_FIND_PHONEBOOK_ENTRY = 623;
/*     */   public static final int MAX_PATH = 260;
/*     */   public static final int UNLEN = 256;
/*     */   public static final int PWLEN = 256;
/*     */   public static final int DNLEN = 15;
/*     */   public static final int RAS_MaxEntryName = 256;
/*     */   public static final int RAS_MaxPhoneNumber = 128;
/*     */   public static final int RAS_MaxCallbackNumber = 128;
/*     */   public static final int RAS_MaxDeviceType = 16;
/*     */   public static final int RAS_MaxDeviceName = 128;
/*     */   public static final int RAS_MaxDnsSuffix = 256;
/*     */   public static final int RAS_MaxAreaCode = 10;
/*     */   public static final int RAS_MaxX25Address = 200;
/*     */   public static final int RAS_MaxIpAddress = 15;
/*     */   public static final int RAS_MaxFacilities = 200;
/*     */   public static final int RAS_MaxUserData = 200;
/*     */   public static final int RAS_MaxPadType = 32;
/*     */   public static final int RASCS_Connected = 8192;
/*     */   public static final int RASCS_Disconnected = 8193;
/*     */   public static final int RASCM_UserName = 1;
/*     */   public static final int RASCM_Password = 2;
/*     */   public static final int RASCM_Domain = 4;
/*     */   public static final int RASTUNNELENDPOINT_IPv4 = 1;
/*     */   public static final int RASTUNNELENDPOINT_IPv6 = 2;
/*     */   public static final String RASDT_Modem = "modem";
/*     */   
/*     */   @FieldOrder({"dwSizeofEapInfo", "pbEapInfo"})
/*     */   public static class RASEAPINFO
/*     */     extends Structure
/*     */   {
/*     */     public int dwSizeofEapInfo;
/*     */     public Pointer pbEapInfo;
/*     */     
/*     */     public RASEAPINFO() {}
/*     */     
/*     */     public RASEAPINFO(Pointer param1Pointer) {
/*  89 */       super(param1Pointer);
/*  90 */       read();
/*     */     }
/*     */     
/*     */     public RASEAPINFO(byte[] param1ArrayOfbyte) {
/*  94 */       this.pbEapInfo = (Pointer)new Memory(param1ArrayOfbyte.length);
/*  95 */       this.pbEapInfo.write(0L, param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
/*  96 */       this.dwSizeofEapInfo = param1ArrayOfbyte.length;
/*  97 */       allocateMemory();
/*     */     }
/*     */     
/*     */     public RASEAPINFO(String param1String) {
/* 101 */       this(Native.toByteArray(param1String));
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
/*     */     public byte[] getData() {
/* 121 */       return (this.pbEapInfo == null) ? null : this.pbEapInfo.getByteArray(0L, this.dwSizeofEapInfo);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"dwSize", "pbDevSpecificInfo"})
/*     */   public static class RASDEVSPECIFICINFO
/*     */     extends Structure
/*     */   {
/*     */     public int dwSize;
/*     */     
/*     */     public Pointer pbDevSpecificInfo;
/*     */     
/*     */     public RASDEVSPECIFICINFO() {}
/*     */     
/*     */     public RASDEVSPECIFICINFO(Pointer param1Pointer) {
/* 137 */       super(param1Pointer);
/* 138 */       read();
/*     */     }
/*     */     
/*     */     public RASDEVSPECIFICINFO(byte[] param1ArrayOfbyte) {
/* 142 */       this.pbDevSpecificInfo = (Pointer)new Memory(param1ArrayOfbyte.length);
/* 143 */       this.pbDevSpecificInfo.write(0L, param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
/* 144 */       this.dwSize = param1ArrayOfbyte.length;
/* 145 */       allocateMemory();
/*     */     }
/*     */     
/*     */     public RASDEVSPECIFICINFO(String param1String) {
/* 149 */       this(Native.toByteArray(param1String));
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
/*     */     public byte[] getData() {
/* 167 */       return (this.pbDevSpecificInfo == null) ? null : this.pbDevSpecificInfo.getByteArray(0L, this.dwSize);
/*     */     }
/*     */   }
/*     */   
/*     */   @FieldOrder({"dwSize", "dwfOptions", "hwndParent", "reserved", "reserved1", "RasEapInfo", "fSkipPppAuth", "RasDevSpecificInfo"})
/*     */   public static class RASDIALEXTENSIONS
/*     */     extends Structure {
/*     */     public int dwSize;
/*     */     public int dwfOptions;
/*     */     public WinDef.HWND hwndParent;
/*     */     public BaseTSD.ULONG_PTR reserved;
/*     */     public BaseTSD.ULONG_PTR reserved1;
/*     */     public WinRas.RASEAPINFO RasEapInfo;
/*     */     public WinDef.BOOL fSkipPppAuth;
/*     */     public WinRas.RASDEVSPECIFICINFO RasDevSpecificInfo;
/*     */     
/*     */     public RASDIALEXTENSIONS() {
/* 184 */       this.dwSize = size();
/*     */     }
/*     */     
/*     */     public RASDIALEXTENSIONS(Pointer param1Pointer) {
/* 188 */       super(param1Pointer);
/* 189 */       read();
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
/*     */     public static class ByReference
/*     */       extends RASDIALEXTENSIONS
/*     */       implements Structure.ByReference {}
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
/*     */   @FieldOrder({"dwSize", "szEntryName", "szPhoneNumber", "szCallbackNumber", "szUserName", "szPassword", "szDomain"})
/*     */   public static class RASDIALPARAMS
/*     */     extends Structure
/*     */   {
/*     */     public int dwSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RASDIALPARAMS() {
/* 249 */       this.dwSize = size();
/*     */     }
/*     */     
/*     */     public RASDIALPARAMS(Pointer param1Pointer) {
/* 253 */       super(param1Pointer);
/* 254 */       read();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends RASDIALPARAMS
/*     */       implements Structure.ByReference {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 270 */     public char[] szEntryName = new char[257];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 276 */     public char[] szPhoneNumber = new char[129];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 284 */     public char[] szCallbackNumber = new char[129];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 290 */     public char[] szUserName = new char[257];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 296 */     public char[] szPassword = new char[257];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 303 */     public char[] szDomain = new char[16];
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"dwSize", "hrasconn", "szEntryName", "szDeviceType", "szDeviceName", "szPhonebook", "dwSubEntry", "guidEntry", "dwFlags", "luid", "guidCorrelationId"})
/*     */   public static class RASCONN
/*     */     extends Structure
/*     */   {
/*     */     public int dwSize;
/*     */     
/*     */     public WinNT.HANDLE hrasconn;
/*     */     
/*     */     public RASCONN() {
/* 316 */       this.dwSize = size();
/*     */     }
/*     */     
/*     */     public RASCONN(Pointer param1Pointer) {
/* 320 */       super(param1Pointer);
/* 321 */       read();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends RASCONN
/*     */       implements Structure.ByReference {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 342 */     public char[] szEntryName = new char[257];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 348 */     public char[] szDeviceType = new char[17];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 353 */     public char[] szDeviceName = new char[129];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 358 */     public char[] szPhonebook = new char[260];
/*     */     
/*     */     public int dwSubEntry;
/*     */     
/*     */     public Guid.GUID guidEntry;
/*     */     
/*     */     public int dwFlags;
/*     */     
/*     */     public WinNT.LUID luid;
/*     */     
/*     */     public Guid.GUID guidCorrelationId;
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"dwSize", "dwBytesXmited", "dwBytesRcved", "dwFramesXmited", "dwFramesRcved", "dwCrcErr", "dwTimeoutErr", "dwAlignmentErr", "dwHardwareOverrunErr", "dwFramingErr", "dwBufferOverrunErr", "dwCompressionRatioIn", "dwCompressionRatioOut", "dwBps", "dwConnectDuration"})
/*     */   public static class RAS_STATS
/*     */     extends Structure
/*     */   {
/*     */     public int dwSize;
/*     */     
/*     */     public int dwBytesXmited;
/*     */     
/*     */     public int dwBytesRcved;
/*     */     
/*     */     public int dwFramesXmited;
/*     */     
/*     */     public int dwFramesRcved;
/*     */     public int dwCrcErr;
/*     */     public int dwTimeoutErr;
/*     */     public int dwAlignmentErr;
/*     */     public int dwHardwareOverrunErr;
/*     */     public int dwFramingErr;
/*     */     public int dwBufferOverrunErr;
/*     */     public int dwCompressionRatioIn;
/*     */     public int dwCompressionRatioOut;
/*     */     public int dwBps;
/*     */     public int dwConnectDuration;
/*     */     
/*     */     public RAS_STATS() {
/* 397 */       this.dwSize = size();
/*     */     }
/*     */     
/*     */     public RAS_STATS(Pointer param1Pointer) {
/* 401 */       super(param1Pointer);
/* 402 */       read();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"addr"})
/*     */   public static class RASIPV4ADDR
/*     */     extends Structure
/*     */   {
/*     */     public RASIPV4ADDR() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RASIPV4ADDR(Pointer param1Pointer) {
/* 484 */       super(param1Pointer);
/* 485 */       read();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 491 */     public byte[] addr = new byte[8];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"addr"})
/*     */   public static class RASIPV6ADDR
/*     */     extends Structure
/*     */   {
/*     */     public RASIPV6ADDR() {}
/*     */ 
/*     */     
/*     */     public RASIPV6ADDR(Pointer param1Pointer) {
/* 504 */       super(param1Pointer);
/* 505 */       read();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 511 */     public byte[] addr = new byte[16];
/*     */   }
/*     */   
/*     */   @FieldOrder({"dwSize", "dwError", "szIpAddress", "szServerIpAddress", "dwOptions", "dwServerOptions"})
/*     */   public static class RASPPPIP
/*     */     extends Structure {
/*     */     public int dwSize;
/*     */     public int dwError;
/*     */     
/*     */     public RASPPPIP() {
/* 521 */       this.dwSize = size();
/*     */     }
/*     */     
/*     */     public RASPPPIP(Pointer param1Pointer) {
/* 525 */       super(param1Pointer);
/* 526 */       read();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends RASPPPIP
/*     */       implements Structure.ByReference {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 545 */     public char[] szIpAddress = new char[16];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 552 */     public char[] szServerIpAddress = new char[16];
/*     */     
/*     */     public int dwOptions;
/*     */     
/*     */     public int dwServerOptions;
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"dwType", "u"})
/*     */   public static class RASTUNNELENDPOINT
/*     */     extends Structure
/*     */   {
/*     */     public int dwType;
/*     */     
/*     */     public UNION u;
/*     */ 
/*     */     
/*     */     public RASTUNNELENDPOINT() {}
/*     */ 
/*     */     
/*     */     public RASTUNNELENDPOINT(Pointer param1Pointer) {
/* 573 */       super(param1Pointer);
/* 574 */       read();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static class UNION
/*     */       extends Union
/*     */     {
/*     */       public WinRas.RASIPV4ADDR ipv4;
/*     */ 
/*     */       
/*     */       public WinRas.RASIPV6ADDR ipv6;
/*     */ 
/*     */ 
/*     */       
/*     */       public static class ByReference
/*     */         extends UNION
/*     */         implements Structure.ByReference {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void read() {
/* 597 */       super.read();
/*     */       
/* 599 */       switch (this.dwType) {
/*     */         case 1:
/* 601 */           this.u.setType(WinRas.RASIPV4ADDR.class);
/*     */           break;
/*     */         case 2:
/* 604 */           this.u.setType(WinRas.RASIPV6ADDR.class);
/*     */           break;
/*     */         default:
/* 607 */           this.u.setType(WinRas.RASIPV4ADDR.class);
/*     */           break;
/*     */       } 
/*     */       
/* 611 */       this.u.read();
/*     */     }
/*     */   }
/*     */   
/*     */   @FieldOrder({"dwSize", "rasconnstate", "dwError", "szDeviceType", "szDeviceName", "szPhoneNumber", "localEndPoint", "remoteEndPoint", "rasconnsubstate"})
/*     */   public static class RASCONNSTATUS extends Structure {
/*     */     public int dwSize;
/*     */     public int rasconnstate;
/*     */     public int dwError;
/*     */     
/*     */     public RASCONNSTATUS() {
/* 622 */       this.dwSize = size();
/*     */     }
/*     */     
/*     */     public RASCONNSTATUS(Pointer param1Pointer) {
/* 626 */       super(param1Pointer);
/* 627 */       read();
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
/* 648 */     public char[] szDeviceType = new char[17];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 654 */     public char[] szDeviceName = new char[129];
/*     */ 
/*     */ 
/*     */     
/* 658 */     public char[] szPhoneNumber = new char[129];
/*     */ 
/*     */     
/*     */     public WinRas.RASTUNNELENDPOINT localEndPoint;
/*     */ 
/*     */     
/*     */     public WinRas.RASTUNNELENDPOINT remoteEndPoint;
/*     */     
/*     */     public int rasconnsubstate;
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"dwSize", "dwMask", "szUserName", "szPassword", "szDomain"})
/*     */   public static class RASCREDENTIALS
/*     */     extends Structure
/*     */   {
/*     */     public int dwSize;
/*     */     
/*     */     public int dwMask;
/*     */ 
/*     */     
/*     */     public RASCREDENTIALS() {
/* 680 */       this.dwSize = size();
/*     */     }
/*     */     
/*     */     public RASCREDENTIALS(Pointer param1Pointer) {
/* 684 */       super(param1Pointer);
/* 685 */       read();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends RASCREDENTIALS
/*     */       implements Structure.ByReference {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 702 */     public char[] szUserName = new char[257];
/*     */ 
/*     */ 
/*     */     
/* 706 */     public char[] szPassword = new char[257];
/*     */ 
/*     */ 
/*     */     
/* 710 */     public char[] szDomain = new char[16];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"addr"})
/*     */   public static class RASIPADDR
/*     */     extends Structure
/*     */   {
/*     */     public RASIPADDR() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public RASIPADDR(Pointer param1Pointer) {
/* 724 */       super(param1Pointer);
/* 725 */       read();
/*     */     }
/*     */     
/* 728 */     public byte[] addr = new byte[4];
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"dwSize", "dwfOptions", "dwCountryID", "dwCountryCode", "szAreaCode", "szLocalPhoneNumber", "dwAlternateOffset", "ipaddr", "ipaddrDns", "ipaddrDnsAlt", "ipaddrWins", "ipaddrWinsAlt", "dwFrameSize", "dwfNetProtocols", "dwFramingProtocol", "szScript", "szAutodialDll", "szAutodialFunc", "szDeviceType", "szDeviceName", "szX25PadType", "szX25Address", "szX25Facilities", "szX25UserData", "dwChannels", "dwReserved1", "dwReserved2", "dwSubEntries", "dwDialMode", "dwDialExtraPercent", "dwDialExtraSampleSeconds", "dwHangUpExtraPercent", "dwHangUpExtraSampleSeconds", "dwIdleDisconnectSeconds", "dwType", "dwEncryptionType", "dwCustomAuthKey", "guidId", "szCustomDialDll", "dwVpnStrategy", "dwfOptions2", "dwfOptions3", "szDnsSuffix", "dwTcpWindowSize", "szPrerequisitePbk", "szPrerequisiteEntry", "dwRedialCount", "dwRedialPause", "ipv6addrDns", "ipv6addrDnsAlt", "dwIPv4InterfaceMetric", "dwIPv6InterfaceMetric", "ipv6addr", "dwIPv6PrefixLength", "dwNetworkOutageTime"})
/*     */   public static class RASENTRY
/*     */     extends Structure
/*     */   {
/*     */     public int dwSize;
/*     */     
/*     */     public int dwfOptions;
/*     */     
/*     */     public int dwCountryID;
/*     */     
/*     */     public int dwCountryCode;
/*     */     
/*     */     public RASENTRY() {
/* 745 */       this.dwSize = size();
/*     */     }
/*     */     
/*     */     public RASENTRY(Pointer param1Pointer) {
/* 749 */       super(param1Pointer);
/* 750 */       read();
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
/*     */     public static class ByReference
/*     */       extends RASENTRY
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
/*     */ 
/*     */     
/* 783 */     public char[] szAreaCode = new char[11];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 788 */     public char[] szLocalPhoneNumber = new char[129];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwAlternateOffset;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WinRas.RASIPADDR ipaddr;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WinRas.RASIPADDR ipaddrDns;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WinRas.RASIPADDR ipaddrDnsAlt;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WinRas.RASIPADDR ipaddrWins;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WinRas.RASIPADDR ipaddrWinsAlt;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwFrameSize;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwfNetProtocols;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwFramingProtocol;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 838 */     public char[] szScript = new char[260];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 843 */     public char[] szAutodialDll = new char[260];
/*     */ 
/*     */ 
/*     */     
/* 847 */     public char[] szAutodialFunc = new char[260];
/*     */ 
/*     */ 
/*     */     
/* 851 */     public char[] szDeviceType = new char[17];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 856 */     public char[] szDeviceName = new char[129];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 861 */     public char[] szX25PadType = new char[33];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 866 */     public char[] szX25Address = new char[201];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 871 */     public char[] szX25Facilities = new char[201];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 876 */     public char[] szX25UserData = new char[201];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwChannels;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwReserved1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwReserved2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwSubEntries;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwDialMode;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwDialExtraPercent;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwDialExtraSampleSeconds;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwHangUpExtraPercent;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwHangUpExtraSampleSeconds;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwIdleDisconnectSeconds;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwType;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwEncryptionType;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwCustomAuthKey;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Guid.GUID guidId;
/*     */ 
/*     */ 
/*     */     
/* 950 */     public char[] szCustomDialDll = new char[260];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwVpnStrategy;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwfOptions2;
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwfOptions3;
/*     */ 
/*     */ 
/*     */     
/* 968 */     public char[] szDnsSuffix = new char[256];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int dwTcpWindowSize;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 978 */     public char[] szPrerequisitePbk = new char[260];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 985 */     public char[] szPrerequisiteEntry = new char[257];
/*     */     public int dwRedialCount;
/*     */     public int dwRedialPause;
/*     */     public WinRas.RASIPV6ADDR ipv6addrDns;
/*     */     public WinRas.RASIPV6ADDR ipv6addrDnsAlt;
/*     */     public int dwIPv4InterfaceMetric;
/*     */     public int dwIPv6InterfaceMetric;
/*     */     public WinRas.RASIPV6ADDR ipv6addr;
/*     */     public int dwIPv6PrefixLength;
/*     */     public int dwNetworkOutageTime;
/*     */   }
/*     */   
/*     */   public static interface RasDialFunc2 extends StdCallLibrary.StdCallCallback {
/*     */     int dialNotification(int param1Int1, int param1Int2, WinNT.HANDLE param1HANDLE, int param1Int3, int param1Int4, int param1Int5, int param1Int6);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\WinRas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */