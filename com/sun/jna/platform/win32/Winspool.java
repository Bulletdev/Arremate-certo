/*      */ package com.sun.jna.platform.win32;
/*      */ 
/*      */ import com.sun.jna.Memory;
/*      */ import com.sun.jna.Native;
/*      */ import com.sun.jna.Pointer;
/*      */ import com.sun.jna.Structure;
/*      */ import com.sun.jna.Structure.FieldOrder;
/*      */ import com.sun.jna.Union;
/*      */ import com.sun.jna.ptr.IntByReference;
/*      */ import com.sun.jna.ptr.PointerByReference;
/*      */ import com.sun.jna.win32.StdCallLibrary;
/*      */ import com.sun.jna.win32.W32APIOptions;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface Winspool
/*      */   extends StdCallLibrary
/*      */ {
/*   51 */   public static final Winspool INSTANCE = (Winspool)Native.load("Winspool.drv", Winspool.class, W32APIOptions.DEFAULT_OPTIONS);
/*      */   
/*      */   public static final int CCHDEVICENAME = 32;
/*      */   
/*      */   public static final int PRINTER_STATUS_PAUSED = 1;
/*      */   
/*      */   public static final int PRINTER_STATUS_ERROR = 2;
/*      */   
/*      */   public static final int PRINTER_STATUS_PENDING_DELETION = 4;
/*      */   
/*      */   public static final int PRINTER_STATUS_PAPER_JAM = 8;
/*      */   
/*      */   public static final int PRINTER_STATUS_PAPER_OUT = 16;
/*      */   
/*      */   public static final int PRINTER_STATUS_MANUAL_FEED = 32;
/*      */   
/*      */   public static final int PRINTER_STATUS_PAPER_PROBLEM = 64;
/*      */   
/*      */   public static final int PRINTER_STATUS_OFFLINE = 128;
/*      */   
/*      */   public static final int PRINTER_STATUS_IO_ACTIVE = 256;
/*      */   
/*      */   public static final int PRINTER_STATUS_BUSY = 512;
/*      */   
/*      */   public static final int PRINTER_STATUS_PRINTING = 1024;
/*      */   
/*      */   public static final int PRINTER_STATUS_OUTPUT_BIN_FULL = 2048;
/*      */   
/*      */   public static final int PRINTER_STATUS_NOT_AVAILABLE = 4096;
/*      */   
/*      */   public static final int PRINTER_STATUS_WAITING = 8192;
/*      */   
/*      */   public static final int PRINTER_STATUS_PROCESSING = 16384;
/*      */   
/*      */   public static final int PRINTER_STATUS_INITIALIZING = 32768;
/*      */   
/*      */   public static final int PRINTER_STATUS_WARMING_UP = 65536;
/*      */   
/*      */   public static final int PRINTER_STATUS_TONER_LOW = 131072;
/*      */   
/*      */   public static final int PRINTER_STATUS_NO_TONER = 262144;
/*      */   
/*      */   public static final int PRINTER_STATUS_PAGE_PUNT = 524288;
/*      */   
/*      */   public static final int PRINTER_STATUS_USER_INTERVENTION = 1048576;
/*      */   
/*      */   public static final int PRINTER_STATUS_OUT_OF_MEMORY = 2097152;
/*      */   
/*      */   public static final int PRINTER_STATUS_DOOR_OPEN = 4194304;
/*      */   
/*      */   public static final int PRINTER_STATUS_SERVER_UNKNOWN = 8388608;
/*      */   
/*      */   public static final int PRINTER_STATUS_POWER_SAVE = 16777216;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_QUEUED = 1;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_DIRECT = 2;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_DEFAULT = 4;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_SHARED = 8;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_NETWORK = 16;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_HIDDEN = 32;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_LOCAL = 64;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_ENABLE_DEVQ = 128;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_KEEPPRINTEDJOBS = 256;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_DO_COMPLETE_FIRST = 512;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_WORK_OFFLINE = 1024;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_ENABLE_BIDI = 2048;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_RAW_ONLY = 4096;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_PUBLISHED = 8192;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_FAX = 16384;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_TS = 32768;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_PUSHED_USER = 131072;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_PUSHED_MACHINE = 262144;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_MACHINE = 524288;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_FRIENDLY_NAME = 1048576;
/*      */   
/*      */   public static final int PRINTER_ATTRIBUTE_TS_GENERIC_DRIVER = 2097152;
/*      */   
/*      */   public static final int PRINTER_CHANGE_ADD_PRINTER = 1;
/*      */   
/*      */   public static final int PRINTER_CHANGE_SET_PRINTER = 2;
/*      */   
/*      */   public static final int PRINTER_CHANGE_DELETE_PRINTER = 4;
/*      */   
/*      */   public static final int PRINTER_CHANGE_FAILED_CONNECTION_PRINTER = 8;
/*      */   
/*      */   public static final int PRINTER_CHANGE_PRINTER = 255;
/*      */   
/*      */   public static final int PRINTER_CHANGE_ADD_JOB = 256;
/*      */   
/*      */   public static final int PRINTER_CHANGE_SET_JOB = 512;
/*      */   
/*      */   public static final int PRINTER_CHANGE_DELETE_JOB = 1024;
/*      */   
/*      */   public static final int PRINTER_CHANGE_WRITE_JOB = 2048;
/*      */   
/*      */   public static final int PRINTER_CHANGE_JOB = 65280;
/*      */   
/*      */   public static final int PRINTER_CHANGE_ADD_FORM = 65536;
/*      */   
/*      */   public static final int PRINTER_CHANGE_SET_FORM = 131072;
/*      */   
/*      */   public static final int PRINTER_CHANGE_DELETE_FORM = 262144;
/*      */   
/*      */   public static final int PRINTER_CHANGE_FORM = 458752;
/*      */   
/*      */   public static final int PRINTER_CHANGE_ADD_PORT = 1048576;
/*      */   
/*      */   public static final int PRINTER_CHANGE_CONFIGURE_PORT = 2097152;
/*      */   
/*      */   public static final int PRINTER_CHANGE_DELETE_PORT = 4194304;
/*      */   
/*      */   public static final int PRINTER_CHANGE_PORT = 7340032;
/*      */   
/*      */   public static final int PRINTER_CHANGE_ADD_PRINT_PROCESSOR = 16777216;
/*      */   
/*      */   public static final int PRINTER_CHANGE_DELETE_PRINT_PROCESSOR = 67108864;
/*      */   
/*      */   public static final int PRINTER_CHANGE_PRINT_PROCESSOR = 117440512;
/*      */   
/*      */   public static final int PRINTER_CHANGE_SERVER = 134217728;
/*      */   
/*      */   public static final int PRINTER_CHANGE_ADD_PRINTER_DRIVER = 268435456;
/*      */   
/*      */   public static final int PRINTER_CHANGE_SET_PRINTER_DRIVER = 536870912;
/*      */   
/*      */   public static final int PRINTER_CHANGE_DELETE_PRINTER_DRIVER = 1073741824;
/*      */   
/*      */   public static final int PRINTER_CHANGE_PRINTER_DRIVER = 1879048192;
/*      */   
/*      */   public static final int PRINTER_CHANGE_TIMEOUT = -2147483648;
/*      */   
/*      */   public static final int PRINTER_CHANGE_ALL_WIN7 = 2138570751;
/*      */   
/*      */   public static final int PRINTER_CHANGE_ALL = 2004353023;
/*      */   
/*      */   public static final int PRINTER_ENUM_DEFAULT = 1;
/*      */   
/*      */   public static final int PRINTER_ENUM_LOCAL = 2;
/*      */   
/*      */   public static final int PRINTER_ENUM_CONNECTIONS = 4;
/*      */   
/*      */   public static final int PRINTER_ENUM_FAVORITE = 4;
/*      */   
/*      */   public static final int PRINTER_ENUM_NAME = 8;
/*      */   
/*      */   public static final int PRINTER_ENUM_REMOTE = 16;
/*      */   
/*      */   public static final int PRINTER_ENUM_SHARED = 32;
/*      */   
/*      */   public static final int PRINTER_ENUM_NETWORK = 64;
/*      */   
/*      */   public static final int PRINTER_ENUM_EXPAND = 16384;
/*      */   
/*      */   public static final int PRINTER_ENUM_CONTAINER = 32768;
/*      */   
/*      */   public static final int PRINTER_ENUM_ICONMASK = 16711680;
/*      */   
/*      */   public static final int PRINTER_ENUM_ICON1 = 65536;
/*      */   
/*      */   public static final int PRINTER_ENUM_ICON2 = 131072;
/*      */   
/*      */   public static final int PRINTER_ENUM_ICON3 = 262144;
/*      */   
/*      */   public static final int PRINTER_ENUM_ICON4 = 524288;
/*      */   
/*      */   public static final int PRINTER_ENUM_ICON5 = 1048576;
/*      */   
/*      */   public static final int PRINTER_ENUM_ICON6 = 2097152;
/*      */   
/*      */   public static final int PRINTER_ENUM_ICON7 = 4194304;
/*      */   
/*      */   public static final int PRINTER_ENUM_ICON8 = 8388608;
/*      */   
/*      */   public static final int PRINTER_ENUM_HIDE = 16777216;
/*      */   
/*      */   public static final int PRINTER_NOTIFY_OPTIONS_REFRESH = 1;
/*      */   
/*      */   public static final int PRINTER_NOTIFY_INFO_DISCARDED = 1;
/*      */   
/*      */   public static final int PRINTER_NOTIFY_TYPE = 0;
/*      */   
/*      */   public static final int JOB_NOTIFY_TYPE = 1;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_SERVER_NAME = 0;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_PRINTER_NAME = 1;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_SHARE_NAME = 2;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_PORT_NAME = 3;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_DRIVER_NAME = 4;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_COMMENT = 5;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_LOCATION = 6;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_DEVMODE = 7;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_SEPFILE = 8;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_PRINT_PROCESSOR = 9;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_PARAMETERS = 10;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_DATATYPE = 11;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_SECURITY_DESCRIPTOR = 12;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_ATTRIBUTES = 13;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_PRIORITY = 14;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_DEFAULT_PRIORITY = 15;
/*      */   
/*      */   public static final short PRINTER_NOTIFY_FIELD_START_TIME = 16;
/*      */   public static final short PRINTER_NOTIFY_FIELD_UNTIL_TIME = 17;
/*      */   public static final short PRINTER_NOTIFY_FIELD_STATUS = 18;
/*      */   public static final short PRINTER_NOTIFY_FIELD_STATUS_STRING = 19;
/*      */   public static final short PRINTER_NOTIFY_FIELD_CJOBS = 20;
/*      */   public static final short PRINTER_NOTIFY_FIELD_AVERAGE_PPM = 21;
/*      */   public static final short PRINTER_NOTIFY_FIELD_TOTAL_PAGES = 22;
/*      */   public static final short PRINTER_NOTIFY_FIELD_PAGES_PRINTED = 23;
/*      */   public static final short PRINTER_NOTIFY_FIELD_TOTAL_BYTES = 24;
/*      */   public static final short PRINTER_NOTIFY_FIELD_BYTES_PRINTED = 25;
/*      */   public static final short PRINTER_NOTIFY_FIELD_OBJECT_GUID = 26;
/*      */   public static final short PRINTER_NOTIFY_FIELD_FRIENDLY_NAME = 27;
/*      */   public static final short PRINTER_NOTIFY_FIELD_BRANCH_OFFICE_PRINTING = 28;
/*      */   public static final short JOB_NOTIFY_FIELD_PRINTER_NAME = 0;
/*      */   public static final short JOB_NOTIFY_FIELD_MACHINE_NAME = 1;
/*      */   public static final short JOB_NOTIFY_FIELD_PORT_NAME = 2;
/*      */   public static final short JOB_NOTIFY_FIELD_USER_NAME = 3;
/*      */   public static final short JOB_NOTIFY_FIELD_NOTIFY_NAME = 4;
/*      */   public static final short JOB_NOTIFY_FIELD_DATATYPE = 5;
/*      */   public static final short JOB_NOTIFY_FIELD_PRINT_PROCESSOR = 6;
/*      */   public static final short JOB_NOTIFY_FIELD_PARAMETERS = 7;
/*      */   public static final short JOB_NOTIFY_FIELD_DRIVER_NAME = 8;
/*      */   public static final short JOB_NOTIFY_FIELD_DEVMODE = 9;
/*      */   public static final short JOB_NOTIFY_FIELD_STATUS = 10;
/*      */   public static final short JOB_NOTIFY_FIELD_STATUS_STRING = 11;
/*      */   public static final short JOB_NOTIFY_FIELD_SECURITY_DESCRIPTOR = 12;
/*      */   public static final short JOB_NOTIFY_FIELD_DOCUMENT = 13;
/*      */   public static final short JOB_NOTIFY_FIELD_PRIORITY = 14;
/*      */   public static final short JOB_NOTIFY_FIELD_POSITION = 15;
/*      */   public static final short JOB_NOTIFY_FIELD_SUBMITTED = 16;
/*      */   public static final short JOB_NOTIFY_FIELD_START_TIME = 17;
/*      */   public static final short JOB_NOTIFY_FIELD_UNTIL_TIME = 18;
/*      */   public static final short JOB_NOTIFY_FIELD_TIME = 19;
/*      */   public static final short JOB_NOTIFY_FIELD_TOTAL_PAGES = 20;
/*      */   public static final short JOB_NOTIFY_FIELD_PAGES_PRINTED = 21;
/*      */   public static final short JOB_NOTIFY_FIELD_TOTAL_BYTES = 22;
/*      */   public static final short JOB_NOTIFY_FIELD_BYTES_PRINTED = 23;
/*      */   public static final short JOB_NOTIFY_FIELD_REMOTE_JOB_ID = 24;
/*      */   public static final int PRINTER_NOTIFY_CATEGORY_ALL = 4096;
/*      */   public static final int PRINTER_NOTIFY_CATEGORY_3D = 8192;
/*      */   
/*      */   boolean EnumPrinters(int paramInt1, String paramString, int paramInt2, Pointer paramPointer, int paramInt3, IntByReference paramIntByReference1, IntByReference paramIntByReference2);
/*      */   
/*      */   boolean GetPrinter(WinNT.HANDLE paramHANDLE, int paramInt1, Pointer paramPointer, int paramInt2, IntByReference paramIntByReference);
/*      */   
/*      */   boolean OpenPrinter(String paramString, WinNT.HANDLEByReference paramHANDLEByReference, LPPRINTER_DEFAULTS paramLPPRINTER_DEFAULTS);
/*      */   
/*      */   boolean ClosePrinter(WinNT.HANDLE paramHANDLE);
/*      */   
/*      */   @Deprecated
/*      */   WinNT.HANDLE FindFirstPrinterChangeNotification(WinNT.HANDLE paramHANDLE, int paramInt1, int paramInt2, WinDef.LPVOID paramLPVOID);
/*      */   
/*      */   WinNT.HANDLE FindFirstPrinterChangeNotification(WinNT.HANDLE paramHANDLE, int paramInt1, int paramInt2, PRINTER_NOTIFY_OPTIONS paramPRINTER_NOTIFY_OPTIONS);
/*      */   
/*      */   @Deprecated
/*      */   boolean FindNextPrinterChangeNotification(WinNT.HANDLE paramHANDLE, WinDef.DWORDByReference paramDWORDByReference, WinDef.LPVOID paramLPVOID1, WinDef.LPVOID paramLPVOID2);
/*      */   
/*      */   boolean FindNextPrinterChangeNotification(WinNT.HANDLE paramHANDLE, WinDef.DWORDByReference paramDWORDByReference, PRINTER_NOTIFY_OPTIONS paramPRINTER_NOTIFY_OPTIONS, PointerByReference paramPointerByReference);
/*      */   
/*      */   boolean FindClosePrinterChangeNotification(WinNT.HANDLE paramHANDLE);
/*      */   
/*      */   boolean FreePrinterNotifyInfo(Pointer paramPointer);
/*      */   
/*      */   boolean EnumJobs(WinNT.HANDLE paramHANDLE, int paramInt1, int paramInt2, int paramInt3, Pointer paramPointer, int paramInt4, IntByReference paramIntByReference1, IntByReference paramIntByReference2);
/*      */   
/*      */   @FieldOrder({"Flags", "pDescription", "pName", "pComment"})
/*      */   public static class PRINTER_INFO_1
/*      */     extends Structure
/*      */   {
/*      */     public int Flags;
/*      */     public String pDescription;
/*      */     public String pName;
/*      */     public String pComment;
/*      */     
/*      */     public PRINTER_INFO_1() {}
/*      */     
/*      */     public PRINTER_INFO_1(int param1Int) {
/*  362 */       super((Pointer)new Memory(param1Int));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"pServerName", "pPrinterName", "pShareName", "pPortName", "pDriverName", "pComment", "pLocation", "pDevMode", "pSepFile", "pPrintProcessor", "pDatatype", "pParameters", "pSecurityDescriptor", "Attributes", "Priority", "DefaultPriority", "StartTime", "UntilTime", "Status", "cJobs", "AveragePPM"})
/*      */   public static class PRINTER_INFO_2
/*      */     extends Structure
/*      */   {
/*      */     public String pServerName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pPrinterName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pShareName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pPortName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pDriverName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pComment;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pLocation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.INT_PTR pDevMode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pSepFile;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pPrintProcessor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pDatatype;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pParameters;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.INT_PTR pSecurityDescriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Attributes;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Priority;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int DefaultPriority;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int StartTime;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int UntilTime;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Status;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int cJobs;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int AveragePPM;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PRINTER_INFO_2() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PRINTER_INFO_2(int param1Int) {
/*  499 */       super((Pointer)new Memory(param1Int));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasAttribute(int param1Int) {
/*  507 */       return ((this.Attributes & param1Int) == param1Int);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"pPrinterName", "pServerName", "Attributes"})
/*      */   public static class PRINTER_INFO_4
/*      */     extends Structure
/*      */   {
/*      */     public String pPrinterName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pServerName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.DWORD Attributes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PRINTER_INFO_4() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PRINTER_INFO_4(int param1Int) {
/*  545 */       super((Pointer)new Memory(param1Int));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"pDatatype", "pDevMode", "DesiredAccess"})
/*      */   public static class LPPRINTER_DEFAULTS
/*      */     extends Structure
/*      */   {
/*      */     public String pDatatype;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Pointer pDevMode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int DesiredAccess;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"Version", "Flags", "Count", "pTypes"})
/*      */   public static class PRINTER_NOTIFY_OPTIONS
/*      */     extends Structure
/*      */   {
/*  651 */     public int Version = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Flags;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Count;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Winspool.PRINTER_NOTIFY_OPTIONS_TYPE.ByReference pTypes;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"Type", "Reserved0", "Reserved1", "Reserved2", "Count", "pFields"})
/*      */   public static class PRINTER_NOTIFY_OPTIONS_TYPE
/*      */     extends Structure
/*      */   {
/*      */     public short Type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public short Reserved0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Reserved1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Reserved2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Count;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Pointer pFields;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends PRINTER_NOTIFY_OPTIONS_TYPE
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setFields(short[] param1ArrayOfshort) {
/*  728 */       long l = 2L;
/*  729 */       Memory memory = new Memory(param1ArrayOfshort.length * 2L);
/*  730 */       memory.write(0L, param1ArrayOfshort, 0, param1ArrayOfshort.length);
/*  731 */       this.pFields = (Pointer)memory;
/*  732 */       this.Count = param1ArrayOfshort.length;
/*      */     }
/*      */     
/*      */     public short[] getFields() {
/*  736 */       return this.pFields.getShortArray(0L, this.Count);
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
/*      */   @FieldOrder({"Version", "Flags", "Count", "aData"})
/*      */   public static class PRINTER_NOTIFY_INFO
/*      */     extends Structure
/*      */   {
/*      */     public int Version;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Flags;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Count;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  776 */     public Winspool.PRINTER_NOTIFY_INFO_DATA[] aData = new Winspool.PRINTER_NOTIFY_INFO_DATA[1];
/*      */ 
/*      */ 
/*      */     
/*      */     public void read() {
/*  781 */       int i = ((Integer)readField("Count")).intValue();
/*  782 */       this.aData = new Winspool.PRINTER_NOTIFY_INFO_DATA[i];
/*  783 */       if (i == 0) {
/*  784 */         this.Count = i;
/*  785 */         this.Version = ((Integer)readField("Version")).intValue();
/*  786 */         this.Flags = ((Integer)readField("Flags")).intValue();
/*      */       } else {
/*  788 */         super.read();
/*      */       } 
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
/*      */   @FieldOrder({"cbBuf", "pBuf"})
/*      */   public static class NOTIFY_DATA_DATA
/*      */     extends Structure
/*      */   {
/*      */     public int cbBuf;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Pointer pBuf;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class NOTIFY_DATA
/*      */     extends Union
/*      */   {
/*  825 */     public int[] adwData = new int[2];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Winspool.NOTIFY_DATA_DATA Data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"Type", "Field", "Reserved", "Id", "NotifyData"})
/*      */   public static class PRINTER_NOTIFY_INFO_DATA
/*      */     extends Structure
/*      */   {
/*      */     public short Type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public short Field;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Reserved;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Id;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Winspool.NOTIFY_DATA NotifyData;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void read() {
/*      */       boolean bool;
/*  875 */       super.read();
/*      */ 
/*      */       
/*  878 */       if (this.Type == 0) {
/*  879 */         switch (this.Field) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           case 13:
/*      */           case 14:
/*      */           case 15:
/*      */           case 16:
/*      */           case 17:
/*      */           case 18:
/*      */           case 20:
/*      */           case 21:
/*  895 */             bool = true; break;
/*      */         } 
/*  897 */         bool = false;
/*      */       } else {
/*      */         
/*  900 */         switch (this.Field) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           case 10:
/*      */           case 14:
/*      */           case 15:
/*      */           case 17:
/*      */           case 18:
/*      */           case 19:
/*      */           case 20:
/*      */           case 21:
/*      */           case 22:
/*      */           case 23:
/*  920 */             bool = true; break;
/*      */         } 
/*  922 */         bool = false;
/*      */       } 
/*      */       
/*  925 */       if (bool) {
/*  926 */         this.NotifyData.setType(int[].class);
/*      */       } else {
/*  928 */         this.NotifyData.setType(Winspool.NOTIFY_DATA_DATA.class);
/*      */       } 
/*  930 */       this.NotifyData.read();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"JobId", "pPrinterName", "pMachineName", "pUserName", "pDocument", "pDatatype", "pStatus", "Status", "Priority", "Position", "TotalPages", "PagesPrinted", "Submitted"})
/*      */   public static class JOB_INFO_1
/*      */     extends Structure
/*      */   {
/*      */     public int JobId;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pPrinterName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pMachineName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pUserName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pDocument;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pDatatype;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String pStatus;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Status;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Priority;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Position;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int TotalPages;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int PagesPrinted;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinBase.SYSTEMTIME Submitted;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public JOB_INFO_1() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public JOB_INFO_1(int param1Int) {
/* 1275 */       super((Pointer)new Memory(param1Int));
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Winspool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */