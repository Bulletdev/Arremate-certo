/*     */ package org.apache.commons.io;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Locale;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum FileSystem
/*     */ {
/*  39 */   GENERIC(false, false, 2147483647, 2147483647, new char[] { Character.MIN_VALUE }, new String[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   LINUX(true, true, 255, 4096, new char[] { Character.MIN_VALUE, '/' }, new String[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   MAC_OSX(true, true, 255, 1024, new char[] { Character.MIN_VALUE, '/', ':' }, new String[0]),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   WINDOWS(false, true, 255, 32000, new char[] { Character.MIN_VALUE, '\001', '\002', '\003', '\004', '\005', '\006', '\007', '\b', '\t', '\n', '\013', '\f', '\r', '\016', '\017', '\020', '\021', '\022', '\023', '\024', '\025', '\026', '\027', '\030', '\031', '\032', '\033', '\034', '\035', '\036', '\037', '"', '*', '/', ':', '<', '>', '?', '\\', '|' }, new String[] { "AUX", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "CON", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9", "NUL", "PRN" });
/*     */   
/*     */   private static final boolean IS_OS_LINUX;
/*     */   
/*     */   private static final boolean IS_OS_MAC;
/*     */   
/*     */   private static final String OS_NAME_WINDOWS_PREFIX = "Windows";
/*     */   
/*     */   private static final boolean IS_OS_WINDOWS;
/*     */   
/*     */   private final boolean casePreserving;
/*     */   
/*     */   private final boolean caseSensitive;
/*     */   
/*     */   private final char[] illegalFileNameChars;
/*     */   
/*     */   private final int maxFileNameLength;
/*     */   
/*     */   private final int maxPathLength;
/*     */   
/*     */   private final String[] reservedFileNames;
/*     */   
/*     */   static {
/*  92 */     IS_OS_LINUX = getOsMatchesName("Linux");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     IS_OS_MAC = getOsMatchesName("Mac");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     IS_OS_WINDOWS = getOsMatchesName("Windows");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FileSystem getCurrent() {
/* 125 */     if (IS_OS_LINUX) {
/* 126 */       return LINUX;
/*     */     }
/* 128 */     if (IS_OS_MAC) {
/* 129 */       return MAC_OSX;
/*     */     }
/* 131 */     if (IS_OS_WINDOWS) {
/* 132 */       return WINDOWS;
/*     */     }
/* 134 */     return GENERIC;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean getOsMatchesName(String paramString) {
/* 145 */     return isOsNameMatch(getSystemProperty("os.name"), paramString);
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
/*     */   private static String getSystemProperty(String paramString) {
/*     */     try {
/* 163 */       return System.getProperty(paramString);
/* 164 */     } catch (SecurityException securityException) {
/*     */       
/* 166 */       System.err.println("Caught a SecurityException reading the system property '" + paramString + "'; the SystemUtils property value will default to null.");
/*     */       
/* 168 */       return null;
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
/*     */   private static boolean isOsNameMatch(String paramString1, String paramString2) {
/* 185 */     if (paramString1 == null) {
/* 186 */       return false;
/*     */     }
/* 188 */     return paramString1.toUpperCase(Locale.ROOT).startsWith(paramString2.toUpperCase(Locale.ROOT));
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
/*     */   FileSystem(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, char[] paramArrayOfchar, String[] paramArrayOfString) {
/* 216 */     this.maxFileNameLength = paramInt1;
/* 217 */     this.maxPathLength = paramInt2;
/* 218 */     this.illegalFileNameChars = Objects.<char[]>requireNonNull(paramArrayOfchar, "illegalFileNameChars");
/* 219 */     this.reservedFileNames = Objects.<String[]>requireNonNull(paramArrayOfString, "reservedFileNames");
/* 220 */     this.caseSensitive = paramBoolean1;
/* 221 */     this.casePreserving = paramBoolean2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char[] getIllegalFileNameChars() {
/* 230 */     return (char[])this.illegalFileNameChars.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxFileNameLength() {
/* 239 */     return this.maxFileNameLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxPathLength() {
/* 248 */     return this.maxPathLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getReservedFileNames() {
/* 257 */     return (String[])this.reservedFileNames.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCasePreserving() {
/* 266 */     return this.casePreserving;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCaseSensitive() {
/* 275 */     return this.caseSensitive;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isIllegalFileNameChar(char paramChar) {
/* 286 */     return (Arrays.binarySearch(this.illegalFileNameChars, paramChar) >= 0);
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
/*     */   public boolean isLegalFileName(CharSequence paramCharSequence) {
/* 299 */     if (paramCharSequence == null || paramCharSequence.length() == 0 || paramCharSequence.length() > this.maxFileNameLength) {
/* 300 */       return false;
/*     */     }
/* 302 */     if (isReservedFileName(paramCharSequence)) {
/* 303 */       return false;
/*     */     }
/* 305 */     for (byte b = 0; b < paramCharSequence.length(); b++) {
/* 306 */       if (isIllegalFileNameChar(paramCharSequence.charAt(b))) {
/* 307 */         return false;
/*     */       }
/*     */     } 
/* 310 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReservedFileName(CharSequence paramCharSequence) {
/* 321 */     return (Arrays.binarySearch((Object[])this.reservedFileNames, paramCharSequence) >= 0);
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
/*     */   public String toLegalFileName(String paramString, char paramChar) {
/* 337 */     if (isIllegalFileNameChar(paramChar))
/* 338 */       throw new IllegalArgumentException(
/* 339 */           String.format("The replacement character '%s' cannot be one of the %s illegal characters: %s", new Object[] {
/*     */               
/* 341 */               (paramChar == '\000') ? "\\0" : Character.valueOf(paramChar), name(), Arrays.toString(this.illegalFileNameChars)
/*     */             })); 
/* 343 */     String str = (paramString.length() > this.maxFileNameLength) ? paramString.substring(0, this.maxFileNameLength) : paramString;
/*     */     
/* 345 */     boolean bool = false;
/* 346 */     char[] arrayOfChar = str.toCharArray();
/* 347 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 348 */       if (isIllegalFileNameChar(arrayOfChar[b])) {
/* 349 */         arrayOfChar[b] = paramChar;
/* 350 */         bool = true;
/*     */       } 
/*     */     } 
/* 353 */     return bool ? String.valueOf(arrayOfChar) : str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\FileSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */