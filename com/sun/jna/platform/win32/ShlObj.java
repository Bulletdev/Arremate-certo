/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ShlObj
/*     */ {
/*  35 */   public static final WinDef.DWORD SHGFP_TYPE_CURRENT = new WinDef.DWORD(0L);
/*  36 */   public static final WinDef.DWORD SHGFP_TYPE_DEFAULT = new WinDef.DWORD(1L);
/*     */   
/*     */   public static final int CSIDL_DESKTOP = 0;
/*     */   
/*     */   public static final int CSIDL_INTERNET = 1;
/*     */   
/*     */   public static final int CSIDL_PROGRAMS = 2;
/*     */   
/*     */   public static final int CSIDL_CONTROLS = 3;
/*     */   
/*     */   public static final int CSIDL_PRINTERS = 4;
/*     */   
/*     */   public static final int CSIDL_PERSONAL = 5;
/*     */   
/*     */   public static final int CSIDL_FAVORITES = 6;
/*     */   
/*     */   public static final int CSIDL_STARTUP = 7;
/*     */   public static final int CSIDL_RECENT = 8;
/*     */   public static final int CSIDL_SENDTO = 9;
/*     */   public static final int CSIDL_BITBUCKET = 10;
/*     */   public static final int CSIDL_STARTMENU = 11;
/*     */   public static final int CSIDL_MYDOCUMENTS = 5;
/*     */   public static final int CSIDL_MYMUSIC = 13;
/*     */   public static final int CSIDL_MYVIDEO = 14;
/*     */   public static final int CSIDL_DESKTOPDIRECTORY = 16;
/*     */   public static final int CSIDL_DRIVES = 17;
/*     */   public static final int CSIDL_NETWORK = 18;
/*     */   public static final int CSIDL_NETHOOD = 19;
/*     */   public static final int CSIDL_FONTS = 20;
/*     */   public static final int CSIDL_TEMPLATES = 21;
/*     */   public static final int CSIDL_COMMON_STARTMENU = 22;
/*     */   public static final int CSIDL_COMMON_PROGRAMS = 23;
/*     */   public static final int CSIDL_COMMON_STARTUP = 24;
/*     */   public static final int CSIDL_COMMON_DESKTOPDIRECTORY = 25;
/*     */   public static final int CSIDL_APPDATA = 26;
/*     */   public static final int CSIDL_PRINTHOOD = 27;
/*     */   public static final int CSIDL_LOCAL_APPDATA = 28;
/*     */   public static final int CSIDL_ALTSTARTUP = 29;
/*     */   public static final int CSIDL_COMMON_ALTSTARTUP = 30;
/*     */   public static final int CSIDL_COMMON_FAVORITES = 31;
/*     */   public static final int CSIDL_INTERNET_CACHE = 32;
/*     */   public static final int CSIDL_COOKIES = 33;
/*     */   public static final int CSIDL_HISTORY = 34;
/*     */   public static final int CSIDL_COMMON_APPDATA = 35;
/*     */   public static final int CSIDL_WINDOWS = 36;
/*     */   public static final int CSIDL_SYSTEM = 37;
/*     */   public static final int CSIDL_PROGRAM_FILES = 38;
/*     */   public static final int CSIDL_MYPICTURES = 39;
/*     */   public static final int CSIDL_PROFILE = 40;
/*     */   public static final int CSIDL_SYSTEMX86 = 41;
/*     */   public static final int CSIDL_PROGRAM_FILESX86 = 42;
/*     */   public static final int CSIDL_PROGRAM_FILES_COMMON = 43;
/*     */   public static final int CSIDL_PROGRAM_FILES_COMMONX86 = 44;
/*     */   public static final int CSIDL_COMMON_TEMPLATES = 45;
/*     */   public static final int CSIDL_COMMON_DOCUMENTS = 46;
/*     */   public static final int CSIDL_COMMON_ADMINTOOLS = 47;
/*     */   public static final int CSIDL_ADMINTOOLS = 48;
/*     */   public static final int CSIDL_CONNECTIONS = 49;
/*     */   public static final int CSIDL_COMMON_MUSIC = 53;
/*     */   public static final int CSIDL_COMMON_PICTURES = 54;
/*     */   public static final int CSIDL_COMMON_VIDEO = 55;
/*     */   public static final int CSIDL_RESOURCES = 56;
/*     */   public static final int CSIDL_RESOURCES_LOCALIZED = 57;
/*     */   public static final int CSIDL_COMMON_OEM_LINKS = 58;
/*     */   public static final int CSIDL_CDBURN_AREA = 59;
/*     */   public static final int CSIDL_COMPUTERSNEARME = 61;
/*     */   
/*     */   public enum KNOWN_FOLDER_FLAG
/*     */   {
/* 105 */     NONE(0),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     SIMPLE_IDLIST(256),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     NOT_PARENT_RELATIVE(512),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     DEFAULT_PATH(1024),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 131 */     INIT(2048),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     NO_ALIAS(4096),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     DONT_UNEXPAND(8192),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 155 */     DONT_VERIFY(16384),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     CREATE(32768),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     NO_APPCONTAINER_REDIRECTION(65536),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     ALIAS_ONLY(-2147483648);
/*     */     
/*     */     private int flag;
/*     */ 
/*     */     
/*     */     KNOWN_FOLDER_FLAG(int param1Int1) {
/* 187 */       this.flag = param1Int1;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getFlag() {
/* 192 */       return this.flag;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\ShlObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */