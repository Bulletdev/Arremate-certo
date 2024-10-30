/*      */ package org.apache.commons.io;
/*      */ 
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileFilter;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStream;
/*      */ import java.math.BigInteger;
/*      */ import java.net.URL;
/*      */ import java.net.URLConnection;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.charset.Charset;
/*      */ import java.nio.charset.StandardCharsets;
/*      */ import java.nio.file.CopyOption;
/*      */ import java.nio.file.Files;
/*      */ import java.nio.file.Path;
/*      */ import java.nio.file.StandardCopyOption;
/*      */ import java.time.Instant;
/*      */ import java.time.LocalTime;
/*      */ import java.time.ZoneId;
/*      */ import java.time.chrono.ChronoLocalDate;
/*      */ import java.time.chrono.ChronoLocalDateTime;
/*      */ import java.time.chrono.ChronoZonedDateTime;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Objects;
/*      */ import java.util.zip.CRC32;
/*      */ import java.util.zip.CheckedInputStream;
/*      */ import java.util.zip.Checksum;
/*      */ import org.apache.commons.io.file.Counters;
/*      */ import org.apache.commons.io.file.PathUtils;
/*      */ import org.apache.commons.io.filefilter.DirectoryFileFilter;
/*      */ import org.apache.commons.io.filefilter.FalseFileFilter;
/*      */ import org.apache.commons.io.filefilter.FileFilterUtils;
/*      */ import org.apache.commons.io.filefilter.IOFileFilter;
/*      */ import org.apache.commons.io.filefilter.SuffixFileFilter;
/*      */ import org.apache.commons.io.filefilter.TrueFileFilter;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FileUtils
/*      */ {
/*      */   public static final long ONE_KB = 1024L;
/*  102 */   public static final BigInteger ONE_KB_BI = BigInteger.valueOf(1024L);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long ONE_MB = 1048576L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  114 */   public static final BigInteger ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long ONE_GB = 1073741824L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  126 */   public static final BigInteger ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long ONE_TB = 1099511627776L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  138 */   public static final BigInteger ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long ONE_PB = 1125899906842624L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  150 */   public static final BigInteger ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long ONE_EB = 1152921504606846976L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  162 */   public static final BigInteger ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  167 */   public static final BigInteger ONE_ZB = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  172 */   public static final BigInteger ONE_YB = ONE_KB_BI.multiply(ONE_ZB);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  177 */   public static final File[] EMPTY_FILE_ARRAY = new File[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String byteCountToDisplaySize(BigInteger paramBigInteger) {
/*      */     String str;
/*  198 */     if (paramBigInteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  199 */       str = String.valueOf(paramBigInteger.divide(ONE_EB_BI)) + " EB";
/*  200 */     } else if (paramBigInteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  201 */       str = String.valueOf(paramBigInteger.divide(ONE_PB_BI)) + " PB";
/*  202 */     } else if (paramBigInteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  203 */       str = String.valueOf(paramBigInteger.divide(ONE_TB_BI)) + " TB";
/*  204 */     } else if (paramBigInteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  205 */       str = String.valueOf(paramBigInteger.divide(ONE_GB_BI)) + " GB";
/*  206 */     } else if (paramBigInteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  207 */       str = String.valueOf(paramBigInteger.divide(ONE_MB_BI)) + " MB";
/*  208 */     } else if (paramBigInteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  209 */       str = String.valueOf(paramBigInteger.divide(ONE_KB_BI)) + " KB";
/*      */     } else {
/*  211 */       str = String.valueOf(paramBigInteger) + " bytes";
/*      */     } 
/*  213 */     return str;
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
/*      */   public static String byteCountToDisplaySize(long paramLong) {
/*  232 */     return byteCountToDisplaySize(BigInteger.valueOf(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkDirectory(File paramFile) {
/*  242 */     if (!paramFile.exists()) {
/*  243 */       throw new IllegalArgumentException(paramFile + " does not exist");
/*      */     }
/*  245 */     if (!paramFile.isDirectory()) {
/*  246 */       throw new IllegalArgumentException(paramFile + " is not a directory");
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
/*      */   private static void checkEqualSizes(File paramFile1, File paramFile2, long paramLong1, long paramLong2) throws IOException {
/*  261 */     if (paramLong1 != paramLong2) {
/*  262 */       throw new IOException("Failed to copy full contents from '" + paramFile1 + "' to '" + paramFile2 + "' Expected length: " + paramLong1 + " Actual: " + paramLong2);
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
/*      */   private static void checkFileRequirements(File paramFile1, File paramFile2) throws FileNotFoundException {
/*  275 */     Objects.requireNonNull(paramFile1, "source");
/*  276 */     Objects.requireNonNull(paramFile2, "target");
/*  277 */     if (!paramFile1.exists()) {
/*  278 */       throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
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
/*      */   public static Checksum checksum(File paramFile, Checksum paramChecksum) throws IOException {
/*  300 */     if (paramFile.isDirectory()) {
/*  301 */       throw new IllegalArgumentException("Checksums can't be computed on directories");
/*      */     }
/*  303 */     try (CheckedInputStream null = new CheckedInputStream(new FileInputStream(paramFile), paramChecksum)) {
/*  304 */       IOUtils.consume(checkedInputStream);
/*      */     } 
/*  306 */     return paramChecksum;
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
/*      */   public static long checksumCRC32(File paramFile) throws IOException {
/*  321 */     return checksum(paramFile, new CRC32()).getValue();
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
/*      */   public static void cleanDirectory(File paramFile) throws IOException {
/*  333 */     File[] arrayOfFile = verifiedListFiles(paramFile);
/*      */     
/*  335 */     ArrayList<IOException> arrayList = new ArrayList();
/*  336 */     for (File file : arrayOfFile) {
/*      */       try {
/*  338 */         forceDelete(file);
/*  339 */       } catch (IOException iOException) {
/*  340 */         arrayList.add(iOException);
/*      */       } 
/*      */     } 
/*      */     
/*  344 */     if (!arrayList.isEmpty()) {
/*  345 */       throw new IOExceptionList(arrayList);
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
/*      */   private static void cleanDirectoryOnExit(File paramFile) throws IOException {
/*  358 */     File[] arrayOfFile = verifiedListFiles(paramFile);
/*      */     
/*  360 */     ArrayList<IOException> arrayList = new ArrayList();
/*  361 */     for (File file : arrayOfFile) {
/*      */       try {
/*  363 */         forceDeleteOnExit(file);
/*  364 */       } catch (IOException iOException) {
/*  365 */         arrayList.add(iOException);
/*      */       } 
/*      */     } 
/*      */     
/*  369 */     if (!arrayList.isEmpty()) {
/*  370 */       throw new IOExceptionList(arrayList);
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
/*      */   public static boolean contentEquals(File paramFile1, File paramFile2) throws IOException {
/*  393 */     if (paramFile1 == null && paramFile2 == null) {
/*  394 */       return true;
/*      */     }
/*  396 */     if ((((paramFile1 == null) ? 1 : 0) ^ ((paramFile2 == null) ? 1 : 0)) != 0) {
/*  397 */       return false;
/*      */     }
/*  399 */     boolean bool = paramFile1.exists();
/*  400 */     if (bool != paramFile2.exists()) {
/*  401 */       return false;
/*      */     }
/*      */     
/*  404 */     if (!bool)
/*      */     {
/*  406 */       return true;
/*      */     }
/*      */     
/*  409 */     if (paramFile1.isDirectory() || paramFile2.isDirectory())
/*      */     {
/*  411 */       throw new IOException("Can't compare directories, only files");
/*      */     }
/*      */     
/*  414 */     if (paramFile1.length() != paramFile2.length())
/*      */     {
/*  416 */       return false;
/*      */     }
/*      */     
/*  419 */     if (paramFile1.getCanonicalFile().equals(paramFile2.getCanonicalFile()))
/*      */     {
/*  421 */       return true;
/*      */     }
/*      */     
/*  424 */     try(FileInputStream null = new FileInputStream(paramFile1); 
/*  425 */         FileInputStream null = new FileInputStream(paramFile2)) {
/*  426 */       return IOUtils.contentEquals(fileInputStream, fileInputStream1);
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
/*      */   public static boolean contentEqualsIgnoreEOL(File paramFile1, File paramFile2, String paramString) throws IOException {
/*  449 */     if (paramFile1 == null && paramFile2 == null) {
/*  450 */       return true;
/*      */     }
/*  452 */     if ((((paramFile1 == null) ? 1 : 0) ^ ((paramFile2 == null) ? 1 : 0)) != 0) {
/*  453 */       return false;
/*      */     }
/*  455 */     boolean bool = paramFile1.exists();
/*  456 */     if (bool != paramFile2.exists()) {
/*  457 */       return false;
/*      */     }
/*      */     
/*  460 */     if (!bool)
/*      */     {
/*  462 */       return true;
/*      */     }
/*      */     
/*  465 */     if (paramFile1.isDirectory() || paramFile2.isDirectory())
/*      */     {
/*  467 */       throw new IOException("Can't compare directories, only files");
/*      */     }
/*      */     
/*  470 */     if (paramFile1.getCanonicalFile().equals(paramFile2.getCanonicalFile()))
/*      */     {
/*  472 */       return true;
/*      */     }
/*      */     
/*  475 */     try(InputStreamReader null = new InputStreamReader(new FileInputStream(paramFile1), Charsets.toCharset(paramString)); 
/*  476 */         InputStreamReader null = new InputStreamReader(new FileInputStream(paramFile2), Charsets.toCharset(paramString))) {
/*  477 */       return IOUtils.contentEqualsIgnoreEOL(inputStreamReader, inputStreamReader1);
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
/*      */   public static File[] convertFileCollectionToFileArray(Collection<File> paramCollection) {
/*  490 */     return paramCollection.<File>toArray(new File[paramCollection.size()]);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyDirectory(File paramFile1, File paramFile2) throws IOException {
/*  521 */     copyDirectory(paramFile1, paramFile2, true);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyDirectory(File paramFile1, File paramFile2, boolean paramBoolean) throws IOException {
/*  555 */     copyDirectory(paramFile1, paramFile2, null, paramBoolean);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter) throws IOException {
/*  606 */     copyDirectory(paramFile1, paramFile2, paramFileFilter, true);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean) throws IOException {
/*  659 */     copyDirectory(paramFile1, paramFile2, paramFileFilter, paramBoolean, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean, CopyOption... paramVarArgs) throws IOException {
/*  713 */     checkFileRequirements(paramFile1, paramFile2);
/*  714 */     if (!paramFile1.isDirectory()) {
/*  715 */       throw new IOException("Source '" + paramFile1 + "' exists but is not a directory");
/*      */     }
/*  717 */     if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
/*  718 */       throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
/*      */     }
/*      */ 
/*      */     
/*  722 */     ArrayList<String> arrayList = null;
/*  723 */     if (paramFile2.getCanonicalPath().startsWith(paramFile1.getCanonicalPath())) {
/*  724 */       File[] arrayOfFile = (paramFileFilter == null) ? paramFile1.listFiles() : paramFile1.listFiles(paramFileFilter);
/*  725 */       if (arrayOfFile != null && arrayOfFile.length > 0) {
/*  726 */         arrayList = new ArrayList(arrayOfFile.length);
/*  727 */         for (File file1 : arrayOfFile) {
/*  728 */           File file2 = new File(paramFile2, file1.getName());
/*  729 */           arrayList.add(file2.getCanonicalPath());
/*      */         } 
/*      */       } 
/*      */     } 
/*  733 */     doCopyDirectory(paramFile1, paramFile2, paramFileFilter, paramBoolean, arrayList, paramVarArgs);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyDirectoryToDirectory(File paramFile1, File paramFile2) throws IOException {
/*  764 */     Objects.requireNonNull(paramFile1, "sourceDir");
/*  765 */     if (paramFile1.exists() && !paramFile1.isDirectory()) {
/*  766 */       throw new IllegalArgumentException("Source '" + paramFile1 + "' is not a directory");
/*      */     }
/*  768 */     Objects.requireNonNull(paramFile2, "destinationDir");
/*  769 */     if (paramFile2.exists() && !paramFile2.isDirectory()) {
/*  770 */       throw new IllegalArgumentException("Destination '" + paramFile2 + "' is not a directory");
/*      */     }
/*  772 */     copyDirectory(paramFile1, new File(paramFile2, paramFile1.getName()), true);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyFile(File paramFile1, File paramFile2) throws IOException {
/*  802 */     copyFile(paramFile1, paramFile2, true);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyFile(File paramFile1, File paramFile2, boolean paramBoolean) throws IOException {
/*  835 */     copyFile(paramFile1, paramFile2, paramBoolean, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyFile(File paramFile1, File paramFile2, boolean paramBoolean, CopyOption... paramVarArgs) throws IOException {
/*  869 */     checkFileRequirements(paramFile1, paramFile2);
/*  870 */     if (paramFile1.isDirectory()) {
/*  871 */       throw new IOException("Source '" + paramFile1 + "' exists but is a directory");
/*      */     }
/*  873 */     if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
/*  874 */       throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
/*      */     }
/*  876 */     File file = paramFile2.getParentFile();
/*  877 */     if (file != null && 
/*  878 */       !file.mkdirs() && !file.isDirectory()) {
/*  879 */       throw new IOException("Destination '" + file + "' directory cannot be created");
/*      */     }
/*      */     
/*  882 */     if (paramFile2.exists() && !paramFile2.canWrite()) {
/*  883 */       throw new IOException("Destination '" + paramFile2 + "' exists but is read-only");
/*      */     }
/*  885 */     doCopyFile(paramFile1, paramFile2, paramBoolean, paramVarArgs);
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
/*      */   public static long copyFile(File paramFile, OutputStream paramOutputStream) throws IOException {
/*  902 */     try (FileInputStream null = new FileInputStream(paramFile)) {
/*  903 */       return IOUtils.copyLarge(fileInputStream, paramOutputStream);
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
/*      */   public static void copyFileToDirectory(File paramFile1, File paramFile2) throws IOException {
/*  931 */     copyFileToDirectory(paramFile1, paramFile2, true);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyFileToDirectory(File paramFile1, File paramFile2, boolean paramBoolean) throws IOException {
/*  965 */     Objects.requireNonNull(paramFile2, "destinationDir");
/*  966 */     if (paramFile2.exists() && !paramFile2.isDirectory()) {
/*  967 */       throw new IllegalArgumentException("Destination '" + paramFile2 + "' is not a directory");
/*      */     }
/*  969 */     File file = new File(paramFile2, paramFile1.getName());
/*  970 */     copyFile(paramFile1, file, paramBoolean);
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
/*      */   public static void copyInputStreamToFile(InputStream paramInputStream, File paramFile) throws IOException {
/*  991 */     try (InputStream null = paramInputStream) {
/*  992 */       copyToFile(inputStream, paramFile);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyToDirectory(File paramFile1, File paramFile2) throws IOException {
/* 1025 */     Objects.requireNonNull(paramFile1, "sourceFile");
/* 1026 */     if (paramFile1.isFile()) {
/* 1027 */       copyFileToDirectory(paramFile1, paramFile2);
/* 1028 */     } else if (paramFile1.isDirectory()) {
/* 1029 */       copyDirectoryToDirectory(paramFile1, paramFile2);
/*      */     } else {
/* 1031 */       throw new IOException("The source " + paramFile1 + " does not exist");
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
/*      */ 
/*      */   
/*      */   public static void copyToDirectory(Iterable<File> paramIterable, File paramFile) throws IOException {
/* 1061 */     Objects.requireNonNull(paramIterable, "sourceIterable");
/* 1062 */     for (File file : paramIterable) {
/* 1063 */       copyFileToDirectory(file, paramFile);
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
/*      */   public static void copyToFile(InputStream paramInputStream, File paramFile) throws IOException {
/* 1085 */     try (FileOutputStream null = openOutputStream(paramFile)) {
/* 1086 */       IOUtils.copy(paramInputStream, fileOutputStream);
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
/*      */   public static void copyURLToFile(URL paramURL, File paramFile) throws IOException {
/* 1111 */     try (InputStream null = paramURL.openStream()) {
/* 1112 */       copyInputStreamToFile(inputStream, paramFile);
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
/*      */   public static void copyURLToFile(URL paramURL, File paramFile, int paramInt1, int paramInt2) throws IOException {
/* 1138 */     URLConnection uRLConnection = paramURL.openConnection();
/* 1139 */     uRLConnection.setConnectTimeout(paramInt1);
/* 1140 */     uRLConnection.setReadTimeout(paramInt2);
/* 1141 */     try (InputStream null = uRLConnection.getInputStream()) {
/* 1142 */       copyInputStreamToFile(inputStream, paramFile);
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
/*      */   static String decodeUrl(String paramString) {
/* 1161 */     String str = paramString;
/* 1162 */     if (paramString != null && paramString.indexOf('%') >= 0) {
/* 1163 */       int i = paramString.length();
/* 1164 */       StringBuilder stringBuilder = new StringBuilder();
/* 1165 */       ByteBuffer byteBuffer = ByteBuffer.allocate(i);
/* 1166 */       for (byte b = 0; b < i; ) {
/* 1167 */         if (paramString.charAt(b) == '%') {
/*      */           try {
/*      */             do {
/* 1170 */               byte b1 = (byte)Integer.parseInt(paramString.substring(b + 1, b + 3), 16);
/* 1171 */               byteBuffer.put(b1);
/* 1172 */               b += 3;
/* 1173 */             } while (b < i && paramString.charAt(b) == '%');
/*      */             continue;
/* 1175 */           } catch (RuntimeException runtimeException) {
/*      */ 
/*      */           
/*      */           } finally {
/* 1179 */             if (byteBuffer.position() > 0) {
/* 1180 */               byteBuffer.flip();
/* 1181 */               stringBuilder.append(StandardCharsets.UTF_8.decode(byteBuffer).toString());
/* 1182 */               byteBuffer.clear();
/*      */             } 
/*      */           } 
/*      */         }
/* 1186 */         stringBuilder.append(paramString.charAt(b++));
/*      */       } 
/* 1188 */       str = stringBuilder.toString();
/*      */     } 
/* 1190 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void deleteDirectory(File paramFile) throws IOException {
/* 1201 */     if (!paramFile.exists()) {
/*      */       return;
/*      */     }
/*      */     
/* 1205 */     if (!isSymlink(paramFile)) {
/* 1206 */       cleanDirectory(paramFile);
/*      */     }
/*      */     
/* 1209 */     if (!paramFile.delete()) {
/* 1210 */       String str = "Unable to delete directory " + paramFile + ".";
/*      */       
/* 1212 */       throw new IOException(str);
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
/*      */   private static void deleteDirectoryOnExit(File paramFile) throws IOException {
/* 1224 */     if (!paramFile.exists()) {
/*      */       return;
/*      */     }
/*      */     
/* 1228 */     paramFile.deleteOnExit();
/* 1229 */     if (!isSymlink(paramFile)) {
/* 1230 */       cleanDirectoryOnExit(paramFile);
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
/*      */   public static boolean deleteQuietly(File paramFile) {
/* 1251 */     if (paramFile == null) {
/* 1252 */       return false;
/*      */     }
/*      */     try {
/* 1255 */       if (paramFile.isDirectory()) {
/* 1256 */         cleanDirectory(paramFile);
/*      */       }
/* 1258 */     } catch (Exception exception) {}
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1263 */       return paramFile.delete();
/* 1264 */     } catch (Exception exception) {
/* 1265 */       return false;
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
/*      */   
/*      */   public static boolean directoryContains(File paramFile1, File paramFile2) throws IOException {
/* 1294 */     if (paramFile1 == null) {
/* 1295 */       throw new IllegalArgumentException("Directory must not be null");
/*      */     }
/*      */     
/* 1298 */     if (!paramFile1.isDirectory()) {
/* 1299 */       throw new IllegalArgumentException("Not a directory: " + paramFile1);
/*      */     }
/*      */     
/* 1302 */     if (paramFile2 == null) {
/* 1303 */       return false;
/*      */     }
/*      */     
/* 1306 */     if (!paramFile1.exists() || !paramFile2.exists()) {
/* 1307 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1311 */     String str1 = paramFile1.getCanonicalPath();
/* 1312 */     String str2 = paramFile2.getCanonicalPath();
/*      */     
/* 1314 */     return FilenameUtils.directoryContains(str1, str2);
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
/*      */   private static void doCopyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean, List<String> paramList, CopyOption... paramVarArgs) throws IOException {
/* 1332 */     File[] arrayOfFile = (paramFileFilter == null) ? paramFile1.listFiles() : paramFile1.listFiles(paramFileFilter);
/* 1333 */     if (arrayOfFile == null) {
/* 1334 */       throw new IOException("Failed to list contents of " + paramFile1);
/*      */     }
/* 1336 */     if (paramFile2.exists()) {
/* 1337 */       if (!paramFile2.isDirectory()) {
/* 1338 */         throw new IOException("Destination '" + paramFile2 + "' exists but is not a directory");
/*      */       }
/*      */     }
/* 1341 */     else if (!paramFile2.mkdirs() && !paramFile2.isDirectory()) {
/* 1342 */       throw new IOException("Destination '" + paramFile2 + "' directory cannot be created");
/*      */     } 
/*      */     
/* 1345 */     if (!paramFile2.canWrite()) {
/* 1346 */       throw new IOException("Destination '" + paramFile2 + "' cannot be written to");
/*      */     }
/* 1348 */     for (File file1 : arrayOfFile) {
/* 1349 */       File file2 = new File(paramFile2, file1.getName());
/* 1350 */       if (paramList == null || !paramList.contains(file1.getCanonicalPath())) {
/* 1351 */         if (file1.isDirectory()) {
/* 1352 */           doCopyDirectory(file1, file2, paramFileFilter, paramBoolean, paramList, paramVarArgs);
/*      */         } else {
/* 1354 */           doCopyFile(file1, file2, paramBoolean, paramVarArgs);
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1360 */     if (paramBoolean) {
/* 1361 */       setLastModified(paramFile1, paramFile2);
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
/*      */   private static void doCopyFile(File paramFile1, File paramFile2, boolean paramBoolean, CopyOption... paramVarArgs) throws IOException {
/* 1385 */     if (paramFile2.exists() && paramFile2.isDirectory()) {
/* 1386 */       throw new IOException("Destination '" + paramFile2 + "' exists but is a directory");
/*      */     }
/*      */     
/* 1389 */     Path path1 = paramFile1.toPath();
/* 1390 */     Path path2 = paramFile2.toPath();
/*      */     
/* 1392 */     Files.copy(path1, path2, paramVarArgs);
/*      */ 
/*      */     
/* 1395 */     checkEqualSizes(paramFile1, paramFile2, Files.size(path1), Files.size(path2));
/*      */     
/* 1397 */     checkEqualSizes(paramFile1, paramFile2, paramFile1.length(), paramFile2.length());
/*      */     
/* 1399 */     if (paramBoolean) {
/* 1400 */       setLastModified(paramFile1, paramFile2);
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
/*      */   public static void forceDelete(File paramFile) throws IOException {
/*      */     Counters.PathCounters pathCounters;
/*      */     try {
/* 1423 */       pathCounters = PathUtils.delete(paramFile.toPath());
/* 1424 */     } catch (IOException iOException) {
/* 1425 */       throw new IOException("Unable to delete file: " + paramFile, iOException);
/*      */     } 
/*      */     
/* 1428 */     if (pathCounters.getFileCounter().get() < 1L && pathCounters.getDirectoryCounter().get() < 1L)
/*      */     {
/* 1430 */       throw new FileNotFoundException("File does not exist: " + paramFile);
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
/*      */   public static void forceDeleteOnExit(File paramFile) throws IOException {
/* 1443 */     if (paramFile.isDirectory()) {
/* 1444 */       deleteDirectoryOnExit(paramFile);
/*      */     } else {
/* 1446 */       paramFile.deleteOnExit();
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
/*      */   public static void forceMkdir(File paramFile) throws IOException {
/* 1462 */     if (paramFile.exists()) {
/* 1463 */       if (!paramFile.isDirectory()) {
/* 1464 */         String str = "File " + paramFile + " exists and is not a directory. Unable to create directory.";
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1469 */         throw new IOException(str);
/*      */       }
/*      */     
/* 1472 */     } else if (!paramFile.mkdirs()) {
/*      */ 
/*      */       
/* 1475 */       if (!paramFile.isDirectory()) {
/* 1476 */         String str = "Unable to create directory " + paramFile;
/*      */         
/* 1478 */         throw new IOException(str);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static void forceMkdirParent(File paramFile) throws IOException {
/* 1494 */     File file = paramFile.getParentFile();
/* 1495 */     if (file == null) {
/*      */       return;
/*      */     }
/* 1498 */     forceMkdir(file);
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
/*      */   public static File getFile(File paramFile, String... paramVarArgs) {
/* 1510 */     Objects.requireNonNull(paramFile, "directory");
/* 1511 */     Objects.requireNonNull(paramVarArgs, "names");
/* 1512 */     File file = paramFile;
/* 1513 */     for (String str : paramVarArgs) {
/* 1514 */       file = new File(file, str);
/*      */     }
/* 1516 */     return file;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File getFile(String... paramVarArgs) {
/* 1527 */     Objects.requireNonNull(paramVarArgs, "names");
/* 1528 */     File file = null;
/* 1529 */     for (String str : paramVarArgs) {
/* 1530 */       if (file == null) {
/* 1531 */         file = new File(str);
/*      */       } else {
/* 1533 */         file = new File(file, str);
/*      */       } 
/*      */     } 
/* 1536 */     return file;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File getTempDirectory() {
/* 1547 */     return new File(getTempDirectoryPath());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getTempDirectoryPath() {
/* 1558 */     return System.getProperty("java.io.tmpdir");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File getUserDirectory() {
/* 1569 */     return new File(getUserDirectoryPath());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getUserDirectoryPath() {
/* 1580 */     return System.getProperty("user.home");
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
/*      */   private static void innerListFiles(Collection<File> paramCollection, File paramFile, IOFileFilter paramIOFileFilter, boolean paramBoolean) {
/* 1594 */     File[] arrayOfFile = paramFile.listFiles((FileFilter)paramIOFileFilter);
/*      */     
/* 1596 */     if (arrayOfFile != null) {
/* 1597 */       for (File file : arrayOfFile) {
/* 1598 */         if (file.isDirectory()) {
/* 1599 */           if (paramBoolean) {
/* 1600 */             paramCollection.add(file);
/*      */           }
/* 1602 */           innerListFiles(paramCollection, file, paramIOFileFilter, paramBoolean);
/*      */         } else {
/* 1604 */           paramCollection.add(file);
/*      */         } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Collection<File> innerListFilesOrDirectories(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2, boolean paramBoolean) {
/* 1628 */     validateListFilesParameters(paramFile, paramIOFileFilter1);
/*      */     
/* 1630 */     IOFileFilter iOFileFilter1 = setUpEffectiveFileFilter(paramIOFileFilter1);
/* 1631 */     IOFileFilter iOFileFilter2 = setUpEffectiveDirFilter(paramIOFileFilter2);
/*      */ 
/*      */     
/* 1634 */     LinkedList<File> linkedList = new LinkedList();
/* 1635 */     if (paramBoolean) {
/* 1636 */       linkedList.add(paramFile);
/*      */     }
/* 1638 */     innerListFiles(linkedList, paramFile, 
/* 1639 */         FileFilterUtils.or(new IOFileFilter[] { iOFileFilter1, iOFileFilter2 }, ), paramBoolean);
/* 1640 */     return linkedList;
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
/*      */   public static boolean isFileNewer(File paramFile, ChronoLocalDate paramChronoLocalDate) {
/* 1656 */     return isFileNewer(paramFile, paramChronoLocalDate, LocalTime.now());
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
/*      */   public static boolean isFileNewer(File paramFile, ChronoLocalDate paramChronoLocalDate, LocalTime paramLocalTime) {
/* 1673 */     Objects.requireNonNull(paramChronoLocalDate, "chronoLocalDate");
/* 1674 */     Objects.requireNonNull(paramLocalTime, "localTime");
/* 1675 */     return isFileNewer(paramFile, paramChronoLocalDate.atTime(paramLocalTime));
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
/*      */   public static boolean isFileNewer(File paramFile, ChronoLocalDateTime<?> paramChronoLocalDateTime) {
/* 1691 */     return isFileNewer(paramFile, paramChronoLocalDateTime, ZoneId.systemDefault());
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
/*      */   public static boolean isFileNewer(File paramFile, ChronoLocalDateTime<?> paramChronoLocalDateTime, ZoneId paramZoneId) {
/* 1708 */     Objects.requireNonNull(paramChronoLocalDateTime, "chronoLocalDateTime");
/* 1709 */     Objects.requireNonNull(paramZoneId, "zoneId");
/* 1710 */     return isFileNewer(paramFile, paramChronoLocalDateTime.atZone(paramZoneId));
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
/*      */   public static boolean isFileNewer(File paramFile, ChronoZonedDateTime<?> paramChronoZonedDateTime) {
/* 1725 */     Objects.requireNonNull(paramChronoZonedDateTime, "chronoZonedDateTime");
/* 1726 */     return isFileNewer(paramFile, paramChronoZonedDateTime.toInstant());
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
/*      */   public static boolean isFileNewer(File paramFile, Date paramDate) {
/* 1739 */     Objects.requireNonNull(paramDate, "date");
/* 1740 */     return isFileNewer(paramFile, paramDate.getTime());
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
/*      */   public static boolean isFileNewer(File paramFile1, File paramFile2) {
/* 1754 */     Objects.requireNonNull(paramFile2, "reference");
/* 1755 */     if (!paramFile2.exists()) {
/* 1756 */       throw new IllegalArgumentException("The reference file '" + paramFile2 + "' doesn't exist");
/*      */     }
/*      */     
/* 1759 */     return isFileNewer(paramFile1, paramFile2.lastModified());
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
/*      */   public static boolean isFileNewer(File paramFile, Instant paramInstant) {
/* 1773 */     Objects.requireNonNull(paramInstant, "instant");
/* 1774 */     return isFileNewer(paramFile, paramInstant.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
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
/*      */   public static boolean isFileNewer(File paramFile, long paramLong) {
/* 1787 */     Objects.requireNonNull(paramFile, "file");
/* 1788 */     if (!paramFile.exists()) {
/* 1789 */       return false;
/*      */     }
/* 1791 */     return (paramFile.lastModified() > paramLong);
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
/*      */   public static boolean isFileOlder(File paramFile, ChronoLocalDate paramChronoLocalDate) {
/* 1807 */     return isFileOlder(paramFile, paramChronoLocalDate, LocalTime.now());
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
/*      */   public static boolean isFileOlder(File paramFile, ChronoLocalDate paramChronoLocalDate, LocalTime paramLocalTime) {
/* 1824 */     Objects.requireNonNull(paramChronoLocalDate, "chronoLocalDate");
/* 1825 */     Objects.requireNonNull(paramLocalTime, "localTime");
/* 1826 */     return isFileOlder(paramFile, paramChronoLocalDate.atTime(paramLocalTime));
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
/*      */   public static boolean isFileOlder(File paramFile, ChronoLocalDateTime<?> paramChronoLocalDateTime) {
/* 1842 */     return isFileOlder(paramFile, paramChronoLocalDateTime, ZoneId.systemDefault());
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
/*      */   public static boolean isFileOlder(File paramFile, ChronoLocalDateTime<?> paramChronoLocalDateTime, ZoneId paramZoneId) {
/* 1859 */     Objects.requireNonNull(paramChronoLocalDateTime, "chronoLocalDateTime");
/* 1860 */     Objects.requireNonNull(paramZoneId, "zoneId");
/* 1861 */     return isFileOlder(paramFile, paramChronoLocalDateTime.atZone(paramZoneId));
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
/*      */   public static boolean isFileOlder(File paramFile, ChronoZonedDateTime<?> paramChronoZonedDateTime) {
/* 1876 */     Objects.requireNonNull(paramChronoZonedDateTime, "chronoZonedDateTime");
/* 1877 */     return isFileOlder(paramFile, paramChronoZonedDateTime.toInstant());
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
/*      */   public static boolean isFileOlder(File paramFile, Date paramDate) {
/* 1889 */     Objects.requireNonNull(paramDate, "date");
/* 1890 */     return isFileOlder(paramFile, paramDate.getTime());
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
/*      */   public static boolean isFileOlder(File paramFile1, File paramFile2) {
/* 1903 */     if (!((File)Objects.<File>requireNonNull(paramFile2, "reference")).exists()) {
/* 1904 */       throw new IllegalArgumentException("The reference file '" + paramFile2 + "' doesn't exist");
/*      */     }
/*      */     
/* 1907 */     return isFileOlder(paramFile1, paramFile2.lastModified());
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
/*      */   public static boolean isFileOlder(File paramFile, Instant paramInstant) {
/* 1921 */     Objects.requireNonNull(paramInstant, "instant");
/* 1922 */     return isFileOlder(paramFile, paramInstant.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
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
/*      */   public static boolean isFileOlder(File paramFile, long paramLong) {
/* 1935 */     Objects.requireNonNull(paramFile, "file");
/* 1936 */     if (!paramFile.exists()) {
/* 1937 */       return false;
/*      */     }
/* 1939 */     return (paramFile.lastModified() < paramLong);
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
/*      */   public static boolean isSymlink(File paramFile) {
/* 1966 */     Objects.requireNonNull(paramFile, "file");
/* 1967 */     return Files.isSymbolicLink(paramFile.toPath());
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
/*      */   public static Iterator<File> iterateFiles(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/* 1991 */     return listFiles(paramFile, paramIOFileFilter1, paramIOFileFilter2).iterator();
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
/*      */   public static Iterator<File> iterateFiles(File paramFile, String[] paramArrayOfString, boolean paramBoolean) {
/* 2009 */     return listFiles(paramFile, paramArrayOfString, paramBoolean).iterator();
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
/*      */   public static Iterator<File> iterateFilesAndDirs(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/* 2036 */     return listFilesAndDirs(paramFile, paramIOFileFilter1, paramIOFileFilter2).iterator();
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
/*      */   public static LineIterator lineIterator(File paramFile) throws IOException {
/* 2049 */     return lineIterator(paramFile, null);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LineIterator lineIterator(File paramFile, String paramString) throws IOException {
/* 2087 */     FileInputStream fileInputStream = null;
/*      */     try {
/* 2089 */       fileInputStream = openInputStream(paramFile);
/* 2090 */       return IOUtils.lineIterator(fileInputStream, paramString);
/* 2091 */     } catch (IOException|RuntimeException iOException) {
/* 2092 */       IOUtils.closeQuietly(fileInputStream, paramIOException -> paramException.addSuppressed(paramIOException));
/* 2093 */       throw iOException;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Collection<File> listFiles(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/* 2128 */     return innerListFilesOrDirectories(paramFile, paramIOFileFilter1, paramIOFileFilter2, false);
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
/*      */   public static Collection<File> listFiles(File paramFile, String[] paramArrayOfString, boolean paramBoolean) {
/*      */     SuffixFileFilter suffixFileFilter;
/* 2144 */     if (paramArrayOfString == null) {
/* 2145 */       IOFileFilter iOFileFilter = TrueFileFilter.INSTANCE;
/*      */     } else {
/* 2147 */       String[] arrayOfString = toSuffixes(paramArrayOfString);
/* 2148 */       suffixFileFilter = new SuffixFileFilter(arrayOfString);
/*      */     } 
/* 2150 */     return listFiles(paramFile, (IOFileFilter)suffixFileFilter, paramBoolean ? TrueFileFilter.INSTANCE : FalseFileFilter.INSTANCE);
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
/*      */   public static Collection<File> listFilesAndDirs(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/* 2176 */     return innerListFilesOrDirectories(paramFile, paramIOFileFilter1, paramIOFileFilter2, true);
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
/*      */   public static void moveDirectory(File paramFile1, File paramFile2) throws IOException {
/* 2194 */     validateMoveParameters(paramFile1, paramFile2);
/* 2195 */     if (!paramFile1.isDirectory()) {
/* 2196 */       throw new IOException("Source '" + paramFile1 + "' is not a directory");
/*      */     }
/* 2198 */     if (paramFile2.exists()) {
/* 2199 */       throw new FileExistsException("Destination '" + paramFile2 + "' already exists");
/*      */     }
/* 2201 */     boolean bool = paramFile1.renameTo(paramFile2);
/* 2202 */     if (!bool) {
/* 2203 */       if (paramFile2.getCanonicalPath().startsWith(paramFile1.getCanonicalPath() + File.separator)) {
/* 2204 */         throw new IOException("Cannot move directory: " + paramFile1 + " to a subdirectory of itself: " + paramFile2);
/*      */       }
/* 2206 */       copyDirectory(paramFile1, paramFile2);
/* 2207 */       deleteDirectory(paramFile1);
/* 2208 */       if (paramFile1.exists()) {
/* 2209 */         throw new IOException("Failed to delete original directory '" + paramFile1 + "' after copy to '" + paramFile2 + "'");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void moveDirectoryToDirectory(File paramFile1, File paramFile2, boolean paramBoolean) throws IOException {
/* 2230 */     validateMoveParameters(paramFile1, paramFile2);
/* 2231 */     if (!paramFile2.exists() && paramBoolean && 
/* 2232 */       !paramFile2.mkdirs()) {
/* 2233 */       throw new IOException("Could not create destination directories '" + paramFile2 + "'");
/*      */     }
/*      */     
/* 2236 */     if (!paramFile2.exists()) {
/* 2237 */       throw new FileNotFoundException("Destination directory '" + paramFile2 + "' does not exist [createDestDir=" + paramBoolean + "]");
/*      */     }
/*      */     
/* 2240 */     if (!paramFile2.isDirectory()) {
/* 2241 */       throw new IOException("Destination '" + paramFile2 + "' is not a directory");
/*      */     }
/* 2243 */     moveDirectory(paramFile1, new File(paramFile2, paramFile1.getName()));
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
/*      */   public static void moveFile(File paramFile1, File paramFile2) throws IOException {
/* 2261 */     validateMoveParameters(paramFile1, paramFile2);
/* 2262 */     if (paramFile1.isDirectory()) {
/* 2263 */       throw new IOException("Source '" + paramFile1 + "' is a directory");
/*      */     }
/* 2265 */     if (paramFile2.exists()) {
/* 2266 */       throw new FileExistsException("Destination '" + paramFile2 + "' already exists");
/*      */     }
/* 2268 */     if (paramFile2.isDirectory()) {
/* 2269 */       throw new IOException("Destination '" + paramFile2 + "' is a directory");
/*      */     }
/* 2271 */     boolean bool = paramFile1.renameTo(paramFile2);
/* 2272 */     if (!bool) {
/* 2273 */       copyFile(paramFile1, paramFile2);
/* 2274 */       if (!paramFile1.delete()) {
/* 2275 */         deleteQuietly(paramFile2);
/* 2276 */         throw new IOException("Failed to delete original file '" + paramFile1 + "' after copy to '" + paramFile2 + "'");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void moveFileToDirectory(File paramFile1, File paramFile2, boolean paramBoolean) throws IOException {
/* 2297 */     validateMoveParameters(paramFile1, paramFile2);
/* 2298 */     if (!paramFile2.exists() && paramBoolean && 
/* 2299 */       !paramFile2.mkdirs()) {
/* 2300 */       throw new IOException("Could not create destination directories '" + paramFile2 + "'");
/*      */     }
/*      */     
/* 2303 */     if (!paramFile2.exists()) {
/* 2304 */       throw new FileNotFoundException("Destination directory '" + paramFile2 + "' does not exist [createDestDir=" + paramBoolean + "]");
/*      */     }
/*      */     
/* 2307 */     if (!paramFile2.isDirectory()) {
/* 2308 */       throw new IOException("Destination '" + paramFile2 + "' is not a directory");
/*      */     }
/* 2310 */     moveFile(paramFile1, new File(paramFile2, paramFile1.getName()));
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
/*      */   public static void moveToDirectory(File paramFile1, File paramFile2, boolean paramBoolean) throws IOException {
/* 2331 */     validateMoveParameters(paramFile1, paramFile2);
/* 2332 */     if (paramFile1.isDirectory()) {
/* 2333 */       moveDirectoryToDirectory(paramFile1, paramFile2, paramBoolean);
/*      */     } else {
/* 2335 */       moveFileToDirectory(paramFile1, paramFile2, paramBoolean);
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
/*      */   public static FileInputStream openInputStream(File paramFile) throws IOException {
/* 2360 */     if (paramFile.exists()) {
/* 2361 */       if (paramFile.isDirectory()) {
/* 2362 */         throw new IOException("File '" + paramFile + "' exists but is a directory");
/*      */       }
/* 2364 */       if (!paramFile.canRead()) {
/* 2365 */         throw new IOException("File '" + paramFile + "' cannot be read");
/*      */       }
/*      */     } else {
/* 2368 */       throw new FileNotFoundException("File '" + paramFile + "' does not exist");
/*      */     } 
/* 2370 */     return new FileInputStream(paramFile);
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
/*      */   public static FileOutputStream openOutputStream(File paramFile) throws IOException {
/* 2397 */     return openOutputStream(paramFile, false);
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
/*      */   
/*      */   public static FileOutputStream openOutputStream(File paramFile, boolean paramBoolean) throws IOException {
/* 2425 */     if (paramFile.exists()) {
/* 2426 */       if (paramFile.isDirectory()) {
/* 2427 */         throw new IOException("File '" + paramFile + "' exists but is a directory");
/*      */       }
/* 2429 */       if (!paramFile.canWrite()) {
/* 2430 */         throw new IOException("File '" + paramFile + "' cannot be written to");
/*      */       }
/*      */     } else {
/* 2433 */       File file = paramFile.getParentFile();
/* 2434 */       if (file != null && 
/* 2435 */         !file.mkdirs() && !file.isDirectory()) {
/* 2436 */         throw new IOException("Directory '" + file + "' could not be created");
/*      */       }
/*      */     } 
/*      */     
/* 2440 */     return new FileOutputStream(paramFile, paramBoolean);
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
/*      */   public static byte[] readFileToByteArray(File paramFile) throws IOException {
/* 2453 */     try (FileInputStream null = openInputStream(paramFile)) {
/* 2454 */       long l = paramFile.length();
/*      */       
/* 2456 */       return (l > 0L) ? IOUtils.toByteArray(fileInputStream, l) : IOUtils.toByteArray(fileInputStream);
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
/*      */   @Deprecated
/*      */   public static String readFileToString(File paramFile) throws IOException {
/* 2472 */     return readFileToString(paramFile, Charset.defaultCharset());
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
/*      */   public static String readFileToString(File paramFile, Charset paramCharset) throws IOException {
/* 2486 */     try (FileInputStream null = openInputStream(paramFile)) {
/* 2487 */       return IOUtils.toString(fileInputStream, Charsets.toCharset(paramCharset));
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
/*      */   public static String readFileToString(File paramFile, String paramString) throws IOException {
/* 2503 */     return readFileToString(paramFile, Charsets.toCharset(paramString));
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
/*      */   @Deprecated
/*      */   public static List<String> readLines(File paramFile) throws IOException {
/* 2518 */     return readLines(paramFile, Charset.defaultCharset());
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
/*      */   public static List<String> readLines(File paramFile, Charset paramCharset) throws IOException {
/* 2532 */     try (FileInputStream null = openInputStream(paramFile)) {
/* 2533 */       return IOUtils.readLines(fileInputStream, Charsets.toCharset(paramCharset));
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
/*      */   public static List<String> readLines(File paramFile, String paramString) throws IOException {
/* 2549 */     return readLines(paramFile, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void setLastModified(File paramFile1, File paramFile2) throws IOException {
/* 2560 */     if (!paramFile2.setLastModified(paramFile1.lastModified())) {
/* 2561 */       throw new IOException("Failed setLastModified on " + paramFile1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static IOFileFilter setUpEffectiveDirFilter(IOFileFilter paramIOFileFilter) {
/* 2572 */     return (paramIOFileFilter == null) ? FalseFileFilter.INSTANCE : FileFilterUtils.and(new IOFileFilter[] { paramIOFileFilter, DirectoryFileFilter.INSTANCE });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static IOFileFilter setUpEffectiveFileFilter(IOFileFilter paramIOFileFilter) {
/* 2583 */     return FileFilterUtils.and(new IOFileFilter[] { paramIOFileFilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE) });
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
/*      */   
/*      */   public static long sizeOf(File paramFile) {
/* 2611 */     if (!paramFile.exists()) {
/* 2612 */       String str = paramFile + " does not exist";
/* 2613 */       throw new IllegalArgumentException(str);
/*      */     } 
/*      */     
/* 2616 */     if (paramFile.isDirectory()) {
/* 2617 */       return sizeOfDirectory0(paramFile);
/*      */     }
/* 2619 */     return paramFile.length();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long sizeOf0(File paramFile) {
/* 2629 */     if (paramFile.isDirectory()) {
/* 2630 */       return sizeOfDirectory0(paramFile);
/*      */     }
/* 2632 */     return paramFile.length();
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
/*      */   public static BigInteger sizeOfAsBigInteger(File paramFile) {
/* 2655 */     if (!paramFile.exists()) {
/* 2656 */       String str = paramFile + " does not exist";
/* 2657 */       throw new IllegalArgumentException(str);
/*      */     } 
/*      */     
/* 2660 */     if (paramFile.isDirectory()) {
/* 2661 */       return sizeOfDirectoryBig0(paramFile);
/*      */     }
/* 2663 */     return BigInteger.valueOf(paramFile.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static BigInteger sizeOfBig0(File paramFile) {
/* 2673 */     if (paramFile.isDirectory()) {
/* 2674 */       return sizeOfDirectoryBig0(paramFile);
/*      */     }
/* 2676 */     return BigInteger.valueOf(paramFile.length());
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
/*      */   public static long sizeOfDirectory(File paramFile) {
/* 2693 */     checkDirectory(paramFile);
/* 2694 */     return sizeOfDirectory0(paramFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long sizeOfDirectory0(File paramFile) {
/* 2703 */     File[] arrayOfFile = paramFile.listFiles();
/* 2704 */     if (arrayOfFile == null) {
/* 2705 */       return 0L;
/*      */     }
/* 2707 */     long l = 0L;
/*      */     
/* 2709 */     for (File file : arrayOfFile) {
/* 2710 */       if (!isSymlink(file)) {
/* 2711 */         l += sizeOf0(file);
/* 2712 */         if (l < 0L) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2718 */     return l;
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
/*      */   public static BigInteger sizeOfDirectoryAsBigInteger(File paramFile) {
/* 2730 */     checkDirectory(paramFile);
/* 2731 */     return sizeOfDirectoryBig0(paramFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static BigInteger sizeOfDirectoryBig0(File paramFile) {
/* 2741 */     File[] arrayOfFile = paramFile.listFiles();
/* 2742 */     if (arrayOfFile == null) {
/* 2743 */       return BigInteger.ZERO;
/*      */     }
/* 2745 */     BigInteger bigInteger = BigInteger.ZERO;
/*      */     
/* 2747 */     for (File file : arrayOfFile) {
/* 2748 */       if (!isSymlink(file)) {
/* 2749 */         bigInteger = bigInteger.add(sizeOfBig0(file));
/*      */       }
/*      */     } 
/*      */     
/* 2753 */     return bigInteger;
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
/*      */   public static File toFile(URL paramURL) {
/* 2772 */     if (paramURL == null || !"file".equalsIgnoreCase(paramURL.getProtocol())) {
/* 2773 */       return null;
/*      */     }
/* 2775 */     String str = paramURL.getFile().replace('/', File.separatorChar);
/* 2776 */     str = decodeUrl(str);
/* 2777 */     return new File(str);
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
/*      */   public static File[] toFiles(URL... paramVarArgs) {
/* 2802 */     if (paramVarArgs == null || paramVarArgs.length == 0) {
/* 2803 */       return EMPTY_FILE_ARRAY;
/*      */     }
/* 2805 */     File[] arrayOfFile = new File[paramVarArgs.length];
/* 2806 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 2807 */       URL uRL = paramVarArgs[b];
/* 2808 */       if (uRL != null) {
/* 2809 */         if (!uRL.getProtocol().equals("file")) {
/* 2810 */           throw new IllegalArgumentException("URL could not be converted to a File: " + uRL);
/*      */         }
/*      */         
/* 2813 */         arrayOfFile[b] = toFile(uRL);
/*      */       } 
/*      */     } 
/* 2816 */     return arrayOfFile;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String[] toSuffixes(String... paramVarArgs) {
/* 2827 */     String[] arrayOfString = new String[paramVarArgs.length];
/* 2828 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 2829 */       arrayOfString[b] = "." + paramVarArgs[b];
/*      */     }
/* 2831 */     return arrayOfString;
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
/*      */   public static void touch(File paramFile) throws IOException {
/* 2848 */     if (!paramFile.exists()) {
/* 2849 */       openOutputStream(paramFile).close();
/*      */     }
/* 2851 */     boolean bool = paramFile.setLastModified(System.currentTimeMillis());
/* 2852 */     if (!bool) {
/* 2853 */       throw new IOException("Unable to set the last modification time for " + paramFile);
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
/*      */   public static URL[] toURLs(File... paramVarArgs) throws IOException {
/* 2869 */     URL[] arrayOfURL = new URL[paramVarArgs.length];
/*      */     
/* 2871 */     for (byte b = 0; b < arrayOfURL.length; b++) {
/* 2872 */       arrayOfURL[b] = paramVarArgs[b].toURI().toURL();
/*      */     }
/*      */     
/* 2875 */     return arrayOfURL;
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
/*      */   private static void validateListFilesParameters(File paramFile, IOFileFilter paramIOFileFilter) {
/* 2889 */     if (!paramFile.isDirectory()) {
/* 2890 */       throw new IllegalArgumentException("Parameter 'directory' is not a directory: " + paramFile);
/*      */     }
/* 2892 */     Objects.requireNonNull(paramIOFileFilter, "fileFilter");
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
/*      */   private static void validateMoveParameters(File paramFile1, File paramFile2) throws FileNotFoundException {
/* 2908 */     Objects.requireNonNull(paramFile1, "source");
/* 2909 */     Objects.requireNonNull(paramFile2, "destination");
/* 2910 */     if (!paramFile1.exists()) {
/* 2911 */       throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
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
/*      */   private static File[] verifiedListFiles(File paramFile) throws IOException {
/* 2923 */     if (!paramFile.exists()) {
/* 2924 */       String str = paramFile + " does not exist";
/* 2925 */       throw new IllegalArgumentException(str);
/*      */     } 
/*      */     
/* 2928 */     if (!paramFile.isDirectory()) {
/* 2929 */       String str = paramFile + " is not a directory";
/* 2930 */       throw new IllegalArgumentException(str);
/*      */     } 
/*      */     
/* 2933 */     File[] arrayOfFile = paramFile.listFiles();
/* 2934 */     if (arrayOfFile == null) {
/* 2935 */       throw new IOException("Failed to list contents of " + paramFile);
/*      */     }
/* 2937 */     return arrayOfFile;
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
/*      */   public static boolean waitFor(File paramFile, int paramInt) {
/* 2953 */     long l = System.currentTimeMillis() + paramInt * 1000L;
/* 2954 */     boolean bool = false;
/*      */     try {
/* 2956 */       while (!paramFile.exists()) {
/* 2957 */         long l1 = l - System.currentTimeMillis();
/* 2958 */         if (l1 < 0L) {
/* 2959 */           return false;
/*      */         }
/*      */         try {
/* 2962 */           Thread.sleep(Math.min(100L, l1));
/* 2963 */         } catch (InterruptedException interruptedException) {
/* 2964 */           bool = true;
/* 2965 */         } catch (Exception exception) {
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } finally {
/* 2970 */       if (bool) {
/* 2971 */         Thread.currentThread().interrupt();
/*      */       }
/*      */     } 
/* 2974 */     return true;
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
/*      */   @Deprecated
/*      */   public static void write(File paramFile, CharSequence paramCharSequence) throws IOException {
/* 2988 */     write(paramFile, paramCharSequence, Charset.defaultCharset(), false);
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
/*      */   @Deprecated
/*      */   public static void write(File paramFile, CharSequence paramCharSequence, boolean paramBoolean) throws IOException {
/* 3004 */     write(paramFile, paramCharSequence, Charset.defaultCharset(), paramBoolean);
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
/*      */   public static void write(File paramFile, CharSequence paramCharSequence, Charset paramCharset) throws IOException {
/* 3017 */     write(paramFile, paramCharSequence, paramCharset, false);
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
/*      */   public static void write(File paramFile, CharSequence paramCharSequence, Charset paramCharset, boolean paramBoolean) throws IOException {
/* 3033 */     String str = (paramCharSequence == null) ? null : paramCharSequence.toString();
/* 3034 */     writeStringToFile(paramFile, str, paramCharset, paramBoolean);
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
/*      */   public static void write(File paramFile, CharSequence paramCharSequence, String paramString) throws IOException {
/* 3050 */     write(paramFile, paramCharSequence, paramString, false);
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
/*      */   public static void write(File paramFile, CharSequence paramCharSequence, String paramString, boolean paramBoolean) throws IOException {
/* 3070 */     write(paramFile, paramCharSequence, Charsets.toCharset(paramString), paramBoolean);
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
/*      */   public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfbyte) throws IOException {
/* 3086 */     writeByteArrayToFile(paramFile, paramArrayOfbyte, false);
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
/*      */   public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfbyte, boolean paramBoolean) throws IOException {
/* 3103 */     writeByteArrayToFile(paramFile, paramArrayOfbyte, 0, paramArrayOfbyte.length, paramBoolean);
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
/*      */   public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 3122 */     writeByteArrayToFile(paramFile, paramArrayOfbyte, paramInt1, paramInt2, false);
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
/*      */   public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) throws IOException {
/* 3141 */     try (FileOutputStream null = openOutputStream(paramFile, paramBoolean)) {
/* 3142 */       fileOutputStream.write(paramArrayOfbyte, paramInt1, paramInt2);
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
/*      */   public static void writeLines(File paramFile, Collection<?> paramCollection) throws IOException {
/* 3157 */     writeLines(paramFile, null, paramCollection, null, false);
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
/*      */   public static void writeLines(File paramFile, Collection<?> paramCollection, boolean paramBoolean) throws IOException {
/* 3173 */     writeLines(paramFile, null, paramCollection, null, paramBoolean);
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
/*      */   public static void writeLines(File paramFile, Collection<?> paramCollection, String paramString) throws IOException {
/* 3189 */     writeLines(paramFile, null, paramCollection, paramString, false);
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
/*      */   public static void writeLines(File paramFile, Collection<?> paramCollection, String paramString, boolean paramBoolean) throws IOException {
/* 3208 */     writeLines(paramFile, null, paramCollection, paramString, paramBoolean);
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
/*      */   public static void writeLines(File paramFile, String paramString, Collection<?> paramCollection) throws IOException {
/* 3229 */     writeLines(paramFile, paramString, paramCollection, null, false);
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
/*      */   public static void writeLines(File paramFile, String paramString, Collection<?> paramCollection, boolean paramBoolean) throws IOException {
/* 3248 */     writeLines(paramFile, paramString, paramCollection, null, paramBoolean);
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
/*      */   public static void writeLines(File paramFile, String paramString1, Collection<?> paramCollection, String paramString2) throws IOException {
/* 3270 */     writeLines(paramFile, paramString1, paramCollection, paramString2, false);
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
/*      */   public static void writeLines(File paramFile, String paramString1, Collection<?> paramCollection, String paramString2, boolean paramBoolean) throws IOException {
/* 3290 */     try (BufferedOutputStream null = new BufferedOutputStream(openOutputStream(paramFile, paramBoolean))) {
/* 3291 */       IOUtils.writeLines(paramCollection, paramString2, bufferedOutputStream, paramString1);
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
/*      */   @Deprecated
/*      */   public static void writeStringToFile(File paramFile, String paramString) throws IOException {
/* 3305 */     writeStringToFile(paramFile, paramString, Charset.defaultCharset(), false);
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
/*      */   @Deprecated
/*      */   public static void writeStringToFile(File paramFile, String paramString, boolean paramBoolean) throws IOException {
/* 3321 */     writeStringToFile(paramFile, paramString, Charset.defaultCharset(), paramBoolean);
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
/*      */   public static void writeStringToFile(File paramFile, String paramString, Charset paramCharset) throws IOException {
/* 3340 */     writeStringToFile(paramFile, paramString, paramCharset, false);
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
/*      */   public static void writeStringToFile(File paramFile, String paramString, Charset paramCharset, boolean paramBoolean) throws IOException {
/* 3356 */     try (FileOutputStream null = openOutputStream(paramFile, paramBoolean)) {
/* 3357 */       IOUtils.write(paramString, fileOutputStream, paramCharset);
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
/*      */   public static void writeStringToFile(File paramFile, String paramString1, String paramString2) throws IOException {
/* 3375 */     writeStringToFile(paramFile, paramString1, paramString2, false);
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
/*      */   public static void writeStringToFile(File paramFile, String paramString1, String paramString2, boolean paramBoolean) throws IOException {
/* 3393 */     writeStringToFile(paramFile, paramString1, Charsets.toCharset(paramString2), paramBoolean);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\FileUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */