/*    */ package oshi.jna.platform.windows;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.Structure.FieldOrder;
/*    */ import com.sun.jna.platform.win32.BaseTSD;
/*    */ import com.sun.jna.platform.win32.NtDll;
/*    */ import com.sun.jna.platform.win32.WinNT;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import com.sun.jna.win32.W32APIOptions;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface NtDll
/*    */   extends NtDll
/*    */ {
/* 37 */   public static final NtDll INSTANCE = (NtDll)Native.load("NtDll", NtDll.class, W32APIOptions.DEFAULT_OPTIONS);
/*    */   public static final int PROCESS_BASIC_INFORMATION = 0;
/*    */   
/*    */   int NtQueryInformationProcess(WinNT.HANDLE paramHANDLE, int paramInt1, Pointer paramPointer, int paramInt2, IntByReference paramIntByReference);
/*    */   
/*    */   @FieldOrder({"Reserved1", "PebBaseAddress", "Reserved2"})
/*    */   public static class PROCESS_BASIC_INFORMATION extends Structure {
/*    */     public Pointer Reserved1;
/* 45 */     public Pointer[] Reserved2 = new Pointer[4];
/*    */     public Pointer PebBaseAddress; }
/*    */   
/*    */   @FieldOrder({"pad", "pad2", "ProcessParameters"})
/*    */   public static class PEB extends Structure {
/* 50 */     public byte[] pad = new byte[4];
/* 51 */     public Pointer[] pad2 = new Pointer[3];
/*    */     
/*    */     public Pointer ProcessParameters;
/*    */   }
/*    */ 
/*    */   
/*    */   @FieldOrder({"MaximumLength", "Length", "Flags", "DebugFlags", "ConsoleHandle", "ConsoleFlags", "StandardInput", "StandardOutput", "StandardError", "CurrentDirectory", "DllPath", "ImagePathName", "CommandLine", "Environment", "StartingX", "StartingY", "CountX", "CountY", "CountCharsX", "CountCharsY", "FillAttribute", "WindowFlags", "ShowWindowFlags", "WindowTitle", "DesktopInfo", "ShellInfo", "RuntimeData", "CurrentDirectories", "EnvironmentSize", "EnvironmentVersion", "PackageDependencyData", "ProcessGroupId", "LoaderThreads", "RedirectionDllName", "HeapPartitionName", "DefaultThreadpoolCpuSetMasks", "DefaultThreadpoolCpuSetMaskCount"})
/*    */   public static class RTL_USER_PROCESS_PARAMETERS
/*    */     extends Structure
/*    */   {
/*    */     public int MaximumLength;
/*    */     
/*    */     public int Length;
/*    */     
/*    */     public int Flags;
/*    */     public int DebugFlags;
/*    */     public WinNT.HANDLE ConsoleHandle;
/*    */     public int ConsoleFlags;
/*    */     public WinNT.HANDLE StandardInput;
/*    */     public WinNT.HANDLE StandardOutput;
/*    */     public WinNT.HANDLE StandardError;
/*    */     public NtDll.CURDIR CurrentDirectory;
/*    */     public NtDll.UNICODE_STRING DllPath;
/*    */     public NtDll.UNICODE_STRING ImagePathName;
/*    */     public NtDll.UNICODE_STRING CommandLine;
/*    */     public Pointer Environment;
/*    */     public int StartingX;
/*    */     public int StartingY;
/*    */     public int CountX;
/*    */     public int CountY;
/*    */     public int CountCharsX;
/*    */     public int CountCharsY;
/*    */     public int FillAttribute;
/*    */     public int WindowFlags;
/*    */     public int ShowWindowFlags;
/*    */     public NtDll.UNICODE_STRING WindowTitle;
/*    */     public NtDll.UNICODE_STRING DesktopInfo;
/*    */     public NtDll.UNICODE_STRING ShellInfo;
/*    */     public NtDll.UNICODE_STRING RuntimeData;
/* 90 */     public NtDll.RTL_DRIVE_LETTER_CURDIR[] CurrentDirectories = new NtDll.RTL_DRIVE_LETTER_CURDIR[32];
/*    */     public BaseTSD.ULONG_PTR EnvironmentSize;
/*    */     public BaseTSD.ULONG_PTR EnvironmentVersion;
/*    */     public Pointer PackageDependencyData;
/*    */     public int ProcessGroupId;
/*    */     public int LoaderThreads;
/*    */     public NtDll.UNICODE_STRING RedirectionDllName;
/*    */     public NtDll.UNICODE_STRING HeapPartitionName;
/*    */     public BaseTSD.ULONG_PTR DefaultThreadpoolCpuSetMasks;
/*    */     public int DefaultThreadpoolCpuSetMaskCount;
/*    */   }
/*    */   
/*    */   @FieldOrder({"Length", "MaximumLength", "Buffer"})
/*    */   public static class UNICODE_STRING extends Structure {
/*    */     public short Length;
/*    */     public short MaximumLength;
/*    */     public Pointer Buffer;
/*    */   }
/*    */   
/*    */   @FieldOrder({"Length", "MaximumLength", "Buffer"})
/*    */   public static class STRING extends Structure {
/*    */     public short Length;
/*    */     public short MaximumLength;
/*    */     public Pointer Buffer;
/*    */   }
/*    */   
/*    */   @FieldOrder({"DosPath", "Handle"})
/*    */   public static class CURDIR extends Structure {
/*    */     public NtDll.UNICODE_STRING DosPath;
/*    */     public Pointer Handle;
/*    */   }
/*    */   
/*    */   @FieldOrder({"Flags", "Length", "TimeStamp", "DosPath"})
/*    */   public static class RTL_DRIVE_LETTER_CURDIR extends Structure {
/*    */     public short Flags;
/*    */     public short Length;
/*    */     public int TimeStamp;
/*    */     public NtDll.STRING DosPath;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\jna\platform\windows\NtDll.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */