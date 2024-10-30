/*     */ package org.apache.commons.io;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.StringTokenizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class FileSystemUtils
/*     */ {
/*  53 */   private static final FileSystemUtils INSTANCE = new FileSystemUtils();
/*     */ 
/*     */   
/*     */   private static final int INIT_PROBLEM = -1;
/*     */ 
/*     */   
/*     */   private static final int OTHER = 0;
/*     */   
/*     */   private static final int WINDOWS = 1;
/*     */   
/*     */   private static final int UNIX = 2;
/*     */   
/*     */   private static final int POSIX_UNIX = 3;
/*     */   
/*     */   private static final int OS;
/*     */   
/*     */   private static final String DF;
/*     */ 
/*     */   
/*     */   static {
/*  73 */     byte b = 0;
/*  74 */     String str = "df";
/*     */     try {
/*  76 */       String str1 = System.getProperty("os.name");
/*  77 */       if (str1 == null) {
/*  78 */         throw new IOException("os.name not found");
/*     */       }
/*  80 */       str1 = str1.toLowerCase(Locale.ENGLISH);
/*     */       
/*  82 */       if (str1.contains("windows")) {
/*  83 */         b = 1;
/*  84 */       } else if (str1.contains("linux") || str1
/*  85 */         .contains("mpe/ix") || str1
/*  86 */         .contains("freebsd") || str1
/*  87 */         .contains("openbsd") || str1
/*  88 */         .contains("irix") || str1
/*  89 */         .contains("digital unix") || str1
/*  90 */         .contains("unix") || str1
/*  91 */         .contains("mac os x")) {
/*  92 */         b = 2;
/*  93 */       } else if (str1.contains("sun os") || str1
/*  94 */         .contains("sunos") || str1
/*  95 */         .contains("solaris")) {
/*  96 */         b = 3;
/*  97 */         str = "/usr/xpg4/bin/df";
/*  98 */       } else if (str1.contains("hp-ux") || str1
/*  99 */         .contains("aix")) {
/* 100 */         b = 3;
/*     */       } else {
/* 102 */         b = 0;
/*     */       }
/*     */     
/* 105 */     } catch (Exception exception) {
/* 106 */       b = -1;
/*     */     } 
/* 108 */     OS = b;
/* 109 */     DF = str;
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
/*     */   @Deprecated
/*     */   public static long freeSpace(String paramString) throws IOException {
/* 148 */     return INSTANCE.freeSpaceOS(paramString, OS, false, -1L);
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
/*     */   @Deprecated
/*     */   public static long freeSpaceKb(String paramString) throws IOException {
/* 179 */     return freeSpaceKb(paramString, -1L);
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
/*     */   @Deprecated
/*     */   public static long freeSpaceKb(String paramString, long paramLong) throws IOException {
/* 210 */     return INSTANCE.freeSpaceOS(paramString, OS, true, paramLong);
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
/*     */   @Deprecated
/*     */   public static long freeSpaceKb() throws IOException {
/* 229 */     return freeSpaceKb(-1L);
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
/*     */   @Deprecated
/*     */   public static long freeSpaceKb(long paramLong) throws IOException {
/* 250 */     return freeSpaceKb((new File(".")).getAbsolutePath(), paramLong);
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
/*     */   long freeSpaceOS(String paramString, int paramInt, boolean paramBoolean, long paramLong) throws IOException {
/* 275 */     if (paramString == null) {
/* 276 */       throw new IllegalArgumentException("Path must not be null");
/*     */     }
/* 278 */     switch (paramInt) {
/*     */       case 1:
/* 280 */         return paramBoolean ? (freeSpaceWindows(paramString, paramLong) / 1024L) : freeSpaceWindows(paramString, paramLong);
/*     */       case 2:
/* 282 */         return freeSpaceUnix(paramString, paramBoolean, false, paramLong);
/*     */       case 3:
/* 284 */         return freeSpaceUnix(paramString, paramBoolean, true, paramLong);
/*     */       case 0:
/* 286 */         throw new IllegalStateException("Unsupported operating system");
/*     */     } 
/* 288 */     throw new IllegalStateException("Exception caught when determining operating system");
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
/*     */   long freeSpaceWindows(String paramString, long paramLong) throws IOException {
/* 304 */     String str = FilenameUtils.normalize(paramString, false);
/* 305 */     if (str == null) {
/* 306 */       throw new IllegalArgumentException(paramString);
/*     */     }
/* 308 */     if (str.length() > 0 && str.charAt(0) != '"') {
/* 309 */       str = "\"" + str + "\"";
/*     */     }
/*     */ 
/*     */     
/* 313 */     String[] arrayOfString = { "cmd.exe", "/C", "dir /a /-c " + str };
/*     */ 
/*     */     
/* 316 */     List<String> list = performCommand(arrayOfString, 2147483647, paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 322 */     for (int i = list.size() - 1; i >= 0; i--) {
/* 323 */       String str1 = list.get(i);
/* 324 */       if (str1.length() > 0) {
/* 325 */         return parseDir(str1, str);
/*     */       }
/*     */     } 
/*     */     
/* 329 */     throw new IOException("Command line 'dir /-c' did not return any info for path '" + str + "'");
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
/*     */   long parseDir(String paramString1, String paramString2) throws IOException {
/* 347 */     int i = 0;
/* 348 */     int j = 0;
/* 349 */     int k = paramString1.length() - 1;
/* 350 */     while (k >= 0) {
/* 351 */       char c = paramString1.charAt(k);
/* 352 */       if (Character.isDigit(c)) {
/*     */ 
/*     */         
/* 355 */         j = k + 1;
/*     */         break;
/*     */       } 
/* 358 */       k--;
/*     */     } 
/* 360 */     while (k >= 0) {
/* 361 */       char c = paramString1.charAt(k);
/* 362 */       if (!Character.isDigit(c) && c != ',' && c != '.') {
/*     */ 
/*     */         
/* 365 */         i = k + 1;
/*     */         break;
/*     */       } 
/* 368 */       k--;
/*     */     } 
/* 370 */     if (k < 0) {
/* 371 */       throw new IOException("Command line 'dir /-c' did not return valid info for path '" + paramString2 + "'");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 377 */     StringBuilder stringBuilder = new StringBuilder(paramString1.substring(i, j));
/* 378 */     for (byte b = 0; b < stringBuilder.length(); b++) {
/* 379 */       if (stringBuilder.charAt(b) == ',' || stringBuilder.charAt(b) == '.') {
/* 380 */         stringBuilder.deleteCharAt(b--);
/*     */       }
/*     */     } 
/* 383 */     return parseBytes(stringBuilder.toString(), paramString2);
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
/*     */   long freeSpaceUnix(String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong) throws IOException {
/* 400 */     if (paramString.isEmpty()) {
/* 401 */       throw new IllegalArgumentException("Path must not be empty");
/*     */     }
/*     */ 
/*     */     
/* 405 */     String str1 = "-";
/* 406 */     if (paramBoolean1) {
/* 407 */       str1 = str1 + "k";
/*     */     }
/* 409 */     if (paramBoolean2) {
/* 410 */       str1 = str1 + "P";
/*     */     }
/*     */     
/* 413 */     (new String[3])[0] = DF; (new String[3])[1] = str1; (new String[3])[2] = paramString; (new String[2])[0] = DF; (new String[2])[1] = paramString; String[] arrayOfString = (str1.length() > 1) ? new String[3] : new String[2];
/*     */ 
/*     */     
/* 416 */     List<String> list = performCommand(arrayOfString, 3, paramLong);
/* 417 */     if (list.size() < 2)
/*     */     {
/* 419 */       throw new IOException("Command line '" + DF + "' did not return info as expected for path '" + paramString + "'- response was " + list);
/*     */     }
/*     */ 
/*     */     
/* 423 */     String str2 = list.get(1);
/*     */ 
/*     */     
/* 426 */     StringTokenizer stringTokenizer = new StringTokenizer(str2, " ");
/* 427 */     if (stringTokenizer.countTokens() < 4) {
/*     */       
/* 429 */       if (stringTokenizer.countTokens() == 1 && list.size() >= 3) {
/* 430 */         String str = list.get(2);
/* 431 */         stringTokenizer = new StringTokenizer(str, " ");
/*     */       } else {
/* 433 */         throw new IOException("Command line '" + DF + "' did not return data as expected for path '" + paramString + "'- check path is valid");
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 438 */       stringTokenizer.nextToken();
/*     */     } 
/* 440 */     stringTokenizer.nextToken();
/* 441 */     stringTokenizer.nextToken();
/* 442 */     String str3 = stringTokenizer.nextToken();
/* 443 */     return parseBytes(str3, paramString);
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
/*     */   long parseBytes(String paramString1, String paramString2) throws IOException {
/*     */     try {
/* 457 */       long l = Long.parseLong(paramString1);
/* 458 */       if (l < 0L) {
/* 459 */         throw new IOException("Command line '" + DF + "' did not find free space in response for path '" + paramString2 + "'- check path is valid");
/*     */       }
/*     */ 
/*     */       
/* 463 */       return l;
/*     */     }
/* 465 */     catch (NumberFormatException numberFormatException) {
/* 466 */       throw new IOException("Command line '" + DF + "' did not return numeric data as expected for path '" + paramString2 + "'- check path is valid", numberFormatException);
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
/*     */   List<String> performCommand(String[] paramArrayOfString, int paramInt, long paramLong) throws IOException {
/* 492 */     ArrayList<String> arrayList = new ArrayList(20);
/* 493 */     Process process = null;
/* 494 */     InputStream inputStream1 = null;
/* 495 */     OutputStream outputStream = null;
/* 496 */     InputStream inputStream2 = null;
/* 497 */     BufferedReader bufferedReader = null;
/*     */     
/*     */     try {
/* 500 */       Thread thread = ThreadMonitor.start(paramLong);
/*     */       
/* 502 */       process = openProcess(paramArrayOfString);
/* 503 */       inputStream1 = process.getInputStream();
/* 504 */       outputStream = process.getOutputStream();
/* 505 */       inputStream2 = process.getErrorStream();
/*     */       
/* 507 */       bufferedReader = new BufferedReader(new InputStreamReader(inputStream1, Charset.defaultCharset()));
/* 508 */       String str = bufferedReader.readLine();
/* 509 */       while (str != null && arrayList.size() < paramInt) {
/* 510 */         str = str.toLowerCase(Locale.ENGLISH).trim();
/* 511 */         arrayList.add(str);
/* 512 */         str = bufferedReader.readLine();
/*     */       } 
/*     */       
/* 515 */       process.waitFor();
/*     */       
/* 517 */       ThreadMonitor.stop(thread);
/*     */       
/* 519 */       if (process.exitValue() != 0)
/*     */       {
/* 521 */         throw new IOException("Command line returned OS error code '" + process
/* 522 */             .exitValue() + "' for command " + 
/* 523 */             Arrays.asList(paramArrayOfString));
/*     */       }
/* 525 */       if (arrayList.isEmpty())
/*     */       {
/* 527 */         throw new IOException("Command line did not return any info for command " + 
/*     */             
/* 529 */             Arrays.asList(paramArrayOfString));
/*     */       }
/*     */       
/* 532 */       bufferedReader.close();
/* 533 */       bufferedReader = null;
/*     */       
/* 535 */       inputStream1.close();
/* 536 */       inputStream1 = null;
/*     */       
/* 538 */       if (outputStream != null) {
/* 539 */         outputStream.close();
/* 540 */         outputStream = null;
/*     */       } 
/*     */       
/* 543 */       if (inputStream2 != null) {
/* 544 */         inputStream2.close();
/* 545 */         inputStream2 = null;
/*     */       } 
/*     */       
/* 548 */       return arrayList;
/*     */     }
/* 550 */     catch (InterruptedException interruptedException) {
/* 551 */       throw new IOException("Command line threw an InterruptedException for command " + 
/*     */           
/* 553 */           Arrays.asList(paramArrayOfString) + " timeout=" + paramLong, interruptedException);
/*     */     } finally {
/* 555 */       IOUtils.closeQuietly(inputStream1);
/* 556 */       IOUtils.closeQuietly(outputStream);
/* 557 */       IOUtils.closeQuietly(inputStream2);
/* 558 */       IOUtils.closeQuietly(bufferedReader);
/* 559 */       if (process != null) {
/* 560 */         process.destroy();
/*     */       }
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
/*     */   Process openProcess(String[] paramArrayOfString) throws IOException {
/* 573 */     return Runtime.getRuntime().exec(paramArrayOfString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\FileSystemUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */