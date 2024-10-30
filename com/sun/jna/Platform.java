/*     */ package com.sun.jna;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Platform
/*     */ {
/*     */   public static final int UNSPECIFIED = -1;
/*     */   public static final int MAC = 0;
/*     */   public static final int LINUX = 1;
/*     */   public static final int WINDOWS = 2;
/*     */   public static final int SOLARIS = 3;
/*     */   public static final int FREEBSD = 4;
/*     */   public static final int OPENBSD = 5;
/*     */   public static final int WINDOWSCE = 6;
/*     */   public static final int AIX = 7;
/*     */   public static final int ANDROID = 8;
/*     */   public static final int GNU = 9;
/*     */   public static final int KFREEBSD = 10;
/*     */   public static final int NETBSD = 11;
/*     */   public static final boolean RO_FIELDS;
/*     */   public static final boolean HAS_BUFFERS;
/*     */   
/*     */   static {
/*  72 */     String str = System.getProperty("os.name");
/*  73 */     if (str.startsWith("Linux")) {
/*  74 */       if ("dalvik".equals(System.getProperty("java.vm.name").toLowerCase())) {
/*  75 */         osType = 8;
/*     */         
/*  77 */         System.setProperty("jna.nounpack", "true");
/*     */       } else {
/*     */         
/*  80 */         osType = 1;
/*     */       }
/*     */     
/*  83 */     } else if (str.startsWith("AIX")) {
/*  84 */       osType = 7;
/*     */     }
/*  86 */     else if (str.startsWith("Mac") || str.startsWith("Darwin")) {
/*  87 */       osType = 0;
/*     */     }
/*  89 */     else if (str.startsWith("Windows CE")) {
/*  90 */       osType = 6;
/*     */     }
/*  92 */     else if (str.startsWith("Windows")) {
/*  93 */       osType = 2;
/*     */     }
/*  95 */     else if (str.startsWith("Solaris") || str.startsWith("SunOS")) {
/*  96 */       osType = 3;
/*     */     }
/*  98 */     else if (str.startsWith("FreeBSD")) {
/*  99 */       osType = 4;
/*     */     }
/* 101 */     else if (str.startsWith("OpenBSD")) {
/* 102 */       osType = 5;
/*     */     }
/* 104 */     else if (str.equalsIgnoreCase("gnu")) {
/* 105 */       osType = 9;
/*     */     }
/* 107 */     else if (str.equalsIgnoreCase("gnu/kfreebsd")) {
/* 108 */       osType = 10;
/*     */     }
/* 110 */     else if (str.equalsIgnoreCase("netbsd")) {
/* 111 */       osType = 11;
/*     */     } else {
/*     */       
/* 114 */       osType = -1;
/*     */     } 
/* 116 */     boolean bool = false;
/*     */     try {
/* 118 */       Class.forName("java.nio.Buffer");
/* 119 */       bool = true;
/*     */     }
/* 121 */     catch (ClassNotFoundException classNotFoundException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 126 */   public static final boolean HAS_AWT = (osType != 6 && osType != 8 && osType != 7);
/* 127 */   public static final boolean HAS_JAWT = (HAS_AWT && osType != 0); public static final String MATH_LIBRARY_NAME; public static final String C_LIBRARY_NAME; public static final boolean HAS_DLL_CALLBACKS; static {
/* 128 */     HAS_BUFFERS = bool;
/* 129 */     RO_FIELDS = (osType != 6);
/* 130 */     C_LIBRARY_NAME = (osType == 2) ? "msvcrt" : ((osType == 6) ? "coredll" : "c");
/* 131 */     MATH_LIBRARY_NAME = (osType == 2) ? "msvcrt" : ((osType == 6) ? "coredll" : "m");
/* 132 */     ARCH = getCanonicalArchitecture(System.getProperty("os.arch"), osType);
/*     */     
/* 134 */     HAS_DLL_CALLBACKS = (osType == 2 && !ARCH.startsWith("aarch"));
/* 135 */     RESOURCE_PREFIX = getNativeLibraryResourcePrefix();
/*     */   }
/*     */   public static final String RESOURCE_PREFIX; private static final int osType; public static final String ARCH;
/*     */   public static final int getOSType() {
/* 139 */     return osType;
/*     */   }
/*     */   public static final boolean isMac() {
/* 142 */     return (osType == 0);
/*     */   }
/*     */   public static final boolean isAndroid() {
/* 145 */     return (osType == 8);
/*     */   }
/*     */   public static final boolean isLinux() {
/* 148 */     return (osType == 1);
/*     */   }
/*     */   public static final boolean isAIX() {
/* 151 */     return (osType == 7);
/*     */   }
/*     */   public static final boolean isWindowsCE() {
/* 154 */     return (osType == 6);
/*     */   }
/*     */   
/*     */   public static final boolean isWindows() {
/* 158 */     return (osType == 2 || osType == 6);
/*     */   }
/*     */   public static final boolean isSolaris() {
/* 161 */     return (osType == 3);
/*     */   }
/*     */   public static final boolean isFreeBSD() {
/* 164 */     return (osType == 4);
/*     */   }
/*     */   public static final boolean isOpenBSD() {
/* 167 */     return (osType == 5);
/*     */   }
/*     */   public static final boolean isNetBSD() {
/* 170 */     return (osType == 11);
/*     */   }
/*     */   public static final boolean isGNU() {
/* 173 */     return (osType == 9);
/*     */   }
/*     */   public static final boolean iskFreeBSD() {
/* 176 */     return (osType == 10);
/*     */   }
/*     */   
/*     */   public static final boolean isX11() {
/* 180 */     return (!isWindows() && !isMac());
/*     */   }
/*     */   public static final boolean hasRuntimeExec() {
/* 183 */     if (isWindowsCE() && "J9".equals(System.getProperty("java.vm.name")))
/* 184 */       return false; 
/* 185 */     return true;
/*     */   }
/*     */   public static final boolean is64Bit() {
/* 188 */     String str = System.getProperty("sun.arch.data.model", 
/* 189 */         System.getProperty("com.ibm.vm.bitmode"));
/* 190 */     if (str != null) {
/* 191 */       return "64".equals(str);
/*     */     }
/* 193 */     if ("x86-64".equals(ARCH) || "ia64"
/* 194 */       .equals(ARCH) || "ppc64"
/* 195 */       .equals(ARCH) || "ppc64le".equals(ARCH) || "sparcv9"
/* 196 */       .equals(ARCH) || "mips64"
/* 197 */       .equals(ARCH) || "mips64el".equals(ARCH) || "amd64"
/* 198 */       .equals(ARCH) || "aarch64"
/* 199 */       .equals(ARCH)) {
/* 200 */       return true;
/*     */     }
/* 202 */     return (Native.POINTER_SIZE == 8);
/*     */   }
/*     */   
/*     */   public static final boolean isIntel() {
/* 206 */     if (ARCH.startsWith("x86")) {
/* 207 */       return true;
/*     */     }
/* 209 */     return false;
/*     */   }
/*     */   
/*     */   public static final boolean isPPC() {
/* 213 */     if (ARCH.startsWith("ppc")) {
/* 214 */       return true;
/*     */     }
/* 216 */     return false;
/*     */   }
/*     */   
/*     */   public static final boolean isARM() {
/* 220 */     return (ARCH.startsWith("arm") || ARCH.startsWith("aarch"));
/*     */   }
/*     */   
/*     */   public static final boolean isSPARC() {
/* 224 */     return ARCH.startsWith("sparc");
/*     */   }
/*     */   
/*     */   public static final boolean isMIPS() {
/* 228 */     if (ARCH.equals("mips") || ARCH
/* 229 */       .equals("mips64") || ARCH
/* 230 */       .equals("mipsel") || ARCH
/* 231 */       .equals("mips64el")) {
/* 232 */       return true;
/*     */     }
/* 234 */     return false;
/*     */   }
/*     */   
/*     */   static String getCanonicalArchitecture(String paramString, int paramInt) {
/* 238 */     paramString = paramString.toLowerCase().trim();
/* 239 */     if ("powerpc".equals(paramString)) {
/* 240 */       paramString = "ppc";
/*     */     }
/* 242 */     else if ("powerpc64".equals(paramString)) {
/* 243 */       paramString = "ppc64";
/*     */     }
/* 245 */     else if ("i386".equals(paramString) || "i686".equals(paramString)) {
/* 246 */       paramString = "x86";
/*     */     }
/* 248 */     else if ("x86_64".equals(paramString) || "amd64".equals(paramString)) {
/* 249 */       paramString = "x86-64";
/*     */     } 
/*     */ 
/*     */     
/* 253 */     if ("ppc64".equals(paramString) && "little".equals(System.getProperty("sun.cpu.endian"))) {
/* 254 */       paramString = "ppc64le";
/*     */     }
/*     */     
/* 257 */     if ("arm".equals(paramString) && paramInt == 1 && isSoftFloat()) {
/* 258 */       paramString = "armel";
/*     */     }
/*     */     
/* 261 */     return paramString;
/*     */   }
/*     */   
/*     */   static boolean isSoftFloat() {
/*     */     try {
/* 266 */       File file = new File("/proc/self/exe");
/* 267 */       if (file.exists()) {
/* 268 */         ELFAnalyser eLFAnalyser = ELFAnalyser.analyse(file.getCanonicalPath());
/* 269 */         return !eLFAnalyser.isArmHardFloat();
/*     */       } 
/* 271 */     } catch (IOException iOException) {
/*     */       
/* 273 */       Logger.getLogger(Platform.class.getName()).log(Level.INFO, "Failed to read '/proc/self/exe' or the target binary.", iOException);
/* 274 */     } catch (SecurityException securityException) {
/*     */       
/* 276 */       Logger.getLogger(Platform.class.getName()).log(Level.INFO, "SecurityException while analysing '/proc/self/exe' or the target binary.", securityException);
/*     */     } 
/* 278 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String getNativeLibraryResourcePrefix() {
/* 285 */     String str = System.getProperty("jna.prefix");
/* 286 */     if (str != null) {
/* 287 */       return str;
/*     */     }
/* 289 */     return getNativeLibraryResourcePrefix(getOSType(), System.getProperty("os.arch"), System.getProperty("os.name"));
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
/*     */   static String getNativeLibraryResourcePrefix(int paramInt, String paramString1, String paramString2) {
/* 301 */     paramString1 = getCanonicalArchitecture(paramString1, paramInt);
/* 302 */     switch (paramInt)
/*     */     { case 8:
/* 304 */         if (paramString1.startsWith("arm")) {
/* 305 */           paramString1 = "arm";
/*     */         }
/* 307 */         str = "android-" + paramString1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 345 */         return str;case 2: str = "win32-" + paramString1; return str;case 6: str = "w32ce-" + paramString1; return str;case 0: str = "darwin-" + paramString1; return str;case 1: str = "linux-" + paramString1; return str;case 3: str = "sunos-" + paramString1; return str;case 4: str = "freebsd-" + paramString1; return str;case 5: str = "openbsd-" + paramString1; return str;case 11: str = "netbsd-" + paramString1; return str;case 10: str = "kfreebsd-" + paramString1; return str; }  String str = paramString2.toLowerCase(); int i = str.indexOf(" "); if (i != -1) str = str.substring(0, i);  str = str + "-" + paramString1; return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */