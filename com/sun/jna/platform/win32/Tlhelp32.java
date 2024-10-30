/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.NativeLong;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface Tlhelp32
/*     */ {
/*  42 */   public static final WinDef.DWORD TH32CS_SNAPHEAPLIST = new WinDef.DWORD(1L);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   public static final WinDef.DWORD TH32CS_SNAPPROCESS = new WinDef.DWORD(2L);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   public static final WinDef.DWORD TH32CS_SNAPTHREAD = new WinDef.DWORD(4L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   public static final WinDef.DWORD TH32CS_SNAPMODULE = new WinDef.DWORD(8L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   public static final WinDef.DWORD TH32CS_SNAPMODULE32 = new WinDef.DWORD(16L);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   public static final WinDef.DWORD TH32CS_SNAPALL = new WinDef.DWORD((TH32CS_SNAPHEAPLIST.intValue() | TH32CS_SNAPPROCESS
/*  83 */       .intValue() | TH32CS_SNAPTHREAD.intValue() | TH32CS_SNAPMODULE.intValue()));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   public static final WinDef.DWORD TH32CS_INHERIT = new WinDef.DWORD(-2147483648L);
/*     */   public static final int MAX_MODULE_NAME32 = 255;
/*     */   
/*     */   @FieldOrder({"dwSize", "cntUsage", "th32ProcessID", "th32DefaultHeapID", "th32ModuleID", "cntThreads", "th32ParentProcessID", "pcPriClassBase", "dwFlags", "szExeFile"})
/*     */   public static class PROCESSENTRY32 extends Structure {
/*     */     public WinDef.DWORD dwSize;
/*     */     public WinDef.DWORD cntUsage;
/*     */     public WinDef.DWORD th32ProcessID;
/*     */     public BaseTSD.ULONG_PTR th32DefaultHeapID;
/*     */     public WinDef.DWORD th32ModuleID;
/*     */     public WinDef.DWORD cntThreads;
/*     */     public WinDef.DWORD th32ParentProcessID;
/*     */     public WinDef.LONG pcPriClassBase;
/*     */     public WinDef.DWORD dwFlags;
/*     */     
/*     */     public static class ByReference extends PROCESSENTRY32 implements Structure.ByReference {
/*     */       public ByReference(Pointer param2Pointer) {
/* 105 */         super(param2Pointer);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByReference() {}
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 161 */     public char[] szExeFile = new char[260];
/*     */     
/*     */     public PROCESSENTRY32() {
/* 164 */       this.dwSize = new WinDef.DWORD(size());
/*     */     }
/*     */     
/*     */     public PROCESSENTRY32(Pointer param1Pointer) {
/* 168 */       super(param1Pointer);
/* 169 */       read();
/*     */     }
/*     */   }
/*     */   
/*     */   @FieldOrder({"dwSize", "cntUsage", "th32ThreadID", "th32OwnerProcessID", "tpBasePri", "tpDeltaPri", "dwFlags"})
/*     */   public static class THREADENTRY32 extends Structure {
/*     */     public int dwSize;
/*     */     public int cntUsage;
/*     */     public int th32ThreadID;
/*     */     public int th32OwnerProcessID;
/*     */     public NativeLong tpBasePri;
/*     */     public NativeLong tpDeltaPri;
/*     */     public int dwFlags;
/*     */     
/*     */     public static class ByReference extends THREADENTRY32 implements Structure.ByReference {
/*     */       public ByReference(Pointer param2Pointer) {
/* 185 */         super(param2Pointer);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByReference() {}
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
/*     */     
/*     */     public THREADENTRY32() {
/* 230 */       this.dwSize = size();
/*     */     }
/*     */     
/*     */     public THREADENTRY32(Pointer param1Pointer) {
/* 234 */       super(param1Pointer);
/* 235 */       read();
/*     */     }
/*     */   }
/*     */   
/*     */   @FieldOrder({"dwSize", "th32ModuleID", "th32ProcessID", "GlblcntUsage", "ProccntUsage", "modBaseAddr", "modBaseSize", "hModule", "szModule", "szExePath"})
/*     */   public static class MODULEENTRY32W
/*     */     extends Structure
/*     */   {
/*     */     public WinDef.DWORD dwSize;
/*     */     public WinDef.DWORD th32ModuleID;
/*     */     public WinDef.DWORD th32ProcessID;
/*     */     public WinDef.DWORD GlblcntUsage;
/*     */     public WinDef.DWORD ProccntUsage;
/*     */     public Pointer modBaseAddr;
/*     */     public WinDef.DWORD modBaseSize;
/*     */     public WinDef.HMODULE hModule;
/*     */     
/*     */     public static class ByReference
/*     */       extends MODULEENTRY32W
/*     */       implements Structure.ByReference
/*     */     {
/*     */       public ByReference() {}
/*     */       
/*     */       public ByReference(Pointer param2Pointer) {
/* 259 */         super(param2Pointer);
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 310 */     public char[] szModule = new char[256];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 315 */     public char[] szExePath = new char[260];
/*     */     
/*     */     public MODULEENTRY32W() {
/* 318 */       this.dwSize = new WinDef.DWORD(size());
/*     */     }
/*     */     
/*     */     public MODULEENTRY32W(Pointer param1Pointer) {
/* 322 */       super(param1Pointer);
/* 323 */       read();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String szModule() {
/* 330 */       return Native.toString(this.szModule);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String szExePath() {
/* 337 */       return Native.toString(this.szExePath);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Tlhelp32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */