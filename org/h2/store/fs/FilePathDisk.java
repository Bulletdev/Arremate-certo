/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.net.URL;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.New;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FilePathDisk
/*     */   extends FilePath
/*     */ {
/*     */   private static final String CLASSPATH_PREFIX = "classpath:";
/*     */   
/*     */   public FilePathDisk getPath(String paramString) {
/*  40 */     FilePathDisk filePathDisk = new FilePathDisk();
/*  41 */     filePathDisk.name = translateFileName(paramString);
/*  42 */     return filePathDisk;
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() {
/*  47 */     return (new File(this.name)).length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String translateFileName(String paramString) {
/*  58 */     paramString = paramString.replace('\\', '/');
/*  59 */     if (paramString.startsWith("file:")) {
/*  60 */       paramString = paramString.substring("file:".length());
/*     */     }
/*  62 */     return expandUserHomeDirectory(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String expandUserHomeDirectory(String paramString) {
/*  73 */     if (paramString.startsWith("~") && (paramString.length() == 1 || paramString.startsWith("~/"))) {
/*     */       
/*  75 */       String str = SysProperties.USER_HOME;
/*  76 */       paramString = str + paramString.substring(1);
/*     */     } 
/*  78 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveTo(FilePath paramFilePath, boolean paramBoolean) {
/*  83 */     File file1 = new File(this.name);
/*  84 */     File file2 = new File(paramFilePath.name);
/*  85 */     if (file1.getAbsolutePath().equals(file2.getAbsolutePath())) {
/*     */       return;
/*     */     }
/*  88 */     if (!file1.exists()) {
/*  89 */       throw DbException.get(90024, new String[] { this.name + " (not found)", paramFilePath.name });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     if (paramBoolean) {
/*  97 */       boolean bool = file1.renameTo(file2);
/*  98 */       if (bool) {
/*     */         return;
/*     */       }
/* 101 */       throw DbException.get(90024, new String[] { this.name, paramFilePath.name });
/*     */     } 
/*     */     
/* 104 */     if (file2.exists()) {
/* 105 */       throw DbException.get(90024, new String[] { this.name, paramFilePath + " (exists)" });
/*     */     }
/*     */     
/* 108 */     for (byte b = 0; b < SysProperties.MAX_FILE_RETRY; b++) {
/* 109 */       IOUtils.trace("rename", this.name + " >" + paramFilePath, null);
/* 110 */       boolean bool = file1.renameTo(file2);
/* 111 */       if (bool) {
/*     */         return;
/*     */       }
/* 114 */       wait(b);
/*     */     } 
/* 116 */     throw DbException.get(90024, new String[] { this.name, paramFilePath.name });
/*     */   }
/*     */ 
/*     */   
/*     */   private static void wait(int paramInt) {
/* 121 */     if (paramInt == 8) {
/* 122 */       System.gc();
/*     */     }
/*     */     
/*     */     try {
/* 126 */       long l = Math.min(256, paramInt * paramInt);
/* 127 */       Thread.sleep(l);
/* 128 */     } catch (InterruptedException interruptedException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean createFile() {
/* 135 */     File file = new File(this.name);
/* 136 */     for (byte b = 0; b < SysProperties.MAX_FILE_RETRY; b++) {
/*     */       try {
/* 138 */         return file.createNewFile();
/* 139 */       } catch (IOException iOException) {
/*     */         
/* 141 */         wait(b);
/*     */       } 
/*     */     } 
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean exists() {
/* 149 */     return (new File(this.name)).exists();
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete() {
/* 154 */     File file = new File(this.name);
/* 155 */     for (byte b = 0; b < SysProperties.MAX_FILE_RETRY; b++) {
/* 156 */       IOUtils.trace("delete", this.name, null);
/* 157 */       boolean bool = file.delete();
/* 158 */       if (bool || !file.exists()) {
/*     */         return;
/*     */       }
/* 161 */       wait(b);
/*     */     } 
/* 163 */     throw DbException.get(90025, this.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<FilePath> newDirectoryStream() {
/* 168 */     ArrayList<FilePathDisk> arrayList = New.arrayList();
/* 169 */     File file = new File(this.name);
/*     */     try {
/* 171 */       String[] arrayOfString = file.list();
/* 172 */       if (arrayOfString != null) {
/* 173 */         String str = file.getCanonicalPath();
/* 174 */         if (!str.endsWith(SysProperties.FILE_SEPARATOR))
/* 175 */           str = str + SysProperties.FILE_SEPARATOR;  byte b;
/*     */         int i;
/* 177 */         for (b = 0, i = arrayOfString.length; b < i; b++) {
/* 178 */           arrayList.add(getPath(str + arrayOfString[b]));
/*     */         }
/*     */       } 
/* 181 */       return (List)arrayList;
/* 182 */     } catch (IOException iOException) {
/* 183 */       throw DbException.convertIOException(iOException, this.name);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canWrite() {
/* 189 */     return canWriteInternal(new File(this.name));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setReadOnly() {
/* 194 */     File file = new File(this.name);
/* 195 */     return file.setReadOnly();
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePathDisk toRealPath() {
/*     */     try {
/* 201 */       String str = (new File(this.name)).getCanonicalPath();
/* 202 */       return getPath(str);
/* 203 */     } catch (IOException iOException) {
/* 204 */       throw DbException.convertIOException(iOException, this.name);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePath getParent() {
/* 210 */     String str = (new File(this.name)).getParent();
/* 211 */     return (str == null) ? null : getPath(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDirectory() {
/* 216 */     return (new File(this.name)).isDirectory();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAbsolute() {
/* 221 */     return (new File(this.name)).isAbsolute();
/*     */   }
/*     */ 
/*     */   
/*     */   public long lastModified() {
/* 226 */     return (new File(this.name)).lastModified();
/*     */   }
/*     */   
/*     */   private static boolean canWriteInternal(File paramFile) {
/*     */     try {
/* 231 */       if (!paramFile.canWrite()) {
/* 232 */         return false;
/*     */       }
/* 234 */     } catch (Exception exception) {
/*     */ 
/*     */       
/* 237 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 242 */     RandomAccessFile randomAccessFile = null;
/*     */     try {
/* 244 */       randomAccessFile = new RandomAccessFile(paramFile, "rw");
/* 245 */       return true;
/* 246 */     } catch (FileNotFoundException fileNotFoundException) {
/* 247 */       return false;
/*     */     } finally {
/* 249 */       if (randomAccessFile != null) {
/*     */         try {
/* 251 */           randomAccessFile.close();
/* 252 */         } catch (IOException iOException) {}
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createDirectory() {
/* 261 */     File file = new File(this.name);
/* 262 */     for (byte b = 0; b < SysProperties.MAX_FILE_RETRY; b++) {
/* 263 */       if (file.exists()) {
/* 264 */         if (file.isDirectory()) {
/*     */           return;
/*     */         }
/* 267 */         throw DbException.get(90062, this.name + " (a file with this name already exists)");
/*     */       } 
/* 269 */       if (file.mkdir()) {
/*     */         return;
/*     */       }
/* 272 */       wait(b);
/*     */     } 
/* 274 */     throw DbException.get(90062, this.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputStream newOutputStream(boolean paramBoolean) throws IOException {
/*     */     try {
/* 280 */       File file1 = new File(this.name);
/* 281 */       File file2 = file1.getParentFile();
/* 282 */       if (file2 != null) {
/* 283 */         FileUtils.createDirectories(file2.getAbsolutePath());
/*     */       }
/* 285 */       FileOutputStream fileOutputStream = new FileOutputStream(this.name, paramBoolean);
/* 286 */       IOUtils.trace("openFileOutputStream", this.name, fileOutputStream);
/* 287 */       return fileOutputStream;
/* 288 */     } catch (IOException iOException) {
/* 289 */       freeMemoryAndFinalize();
/* 290 */       return new FileOutputStream(this.name);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream newInputStream() throws IOException {
/* 296 */     int i = this.name.indexOf(':');
/* 297 */     if (i > 1 && i < 20) {
/*     */ 
/*     */ 
/*     */       
/* 301 */       if (this.name.startsWith("classpath:")) {
/* 302 */         String str = this.name.substring("classpath:".length());
/* 303 */         if (!str.startsWith("/")) {
/* 304 */           str = "/" + str;
/*     */         }
/* 306 */         InputStream inputStream = getClass().getResourceAsStream(str);
/* 307 */         if (inputStream == null) {
/* 308 */           inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(str);
/*     */         }
/*     */         
/* 311 */         if (inputStream == null) {
/* 312 */           throw new FileNotFoundException("resource " + str);
/*     */         }
/* 314 */         return inputStream;
/*     */       } 
/*     */       
/* 317 */       URL uRL = new URL(this.name);
/* 318 */       return uRL.openStream();
/*     */     } 
/*     */     
/* 321 */     FileInputStream fileInputStream = new FileInputStream(this.name);
/* 322 */     IOUtils.trace("openFileInputStream", this.name, fileInputStream);
/* 323 */     return fileInputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void freeMemoryAndFinalize() {
/* 331 */     IOUtils.trace("freeMemoryAndFinalize", null, null);
/* 332 */     Runtime runtime = Runtime.getRuntime();
/* 333 */     long l = runtime.freeMemory();
/* 334 */     for (byte b = 0; b < 16; b++) {
/* 335 */       runtime.gc();
/* 336 */       long l1 = runtime.freeMemory();
/* 337 */       runtime.runFinalization();
/* 338 */       if (l1 == l) {
/*     */         break;
/*     */       }
/* 341 */       l = l1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel open(String paramString) throws IOException {
/*     */     FileDisk fileDisk;
/*     */     try {
/* 349 */       fileDisk = new FileDisk(this.name, paramString);
/* 350 */       IOUtils.trace("open", this.name, fileDisk);
/* 351 */     } catch (IOException iOException) {
/* 352 */       freeMemoryAndFinalize();
/*     */       try {
/* 354 */         fileDisk = new FileDisk(this.name, paramString);
/* 355 */       } catch (IOException iOException1) {
/* 356 */         throw iOException;
/*     */       } 
/*     */     } 
/* 359 */     return fileDisk;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getScheme() {
/* 364 */     return "file";
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePath createTempFile(String paramString, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
/*     */     File file1, file2;
/* 370 */     String str1 = this.name + ".";
/* 371 */     String str2 = (new File(str1)).getName();
/*     */     
/* 373 */     if (paramBoolean2) {
/* 374 */       file1 = new File(System.getProperty("java.io.tmpdir", "."));
/*     */     } else {
/* 376 */       file1 = (new File(str1)).getAbsoluteFile().getParentFile();
/*     */     } 
/* 378 */     FileUtils.createDirectories(file1.getAbsolutePath());
/*     */     while (true) {
/* 380 */       file2 = new File(file1, str2 + getNextTempFileNamePart(false) + paramString);
/* 381 */       if (file2.exists() || !file2.createNewFile()) {
/*     */         
/* 383 */         getNextTempFileNamePart(true); continue;
/*     */       }  break;
/*     */     } 
/* 386 */     if (paramBoolean1) {
/*     */       try {
/* 388 */         file2.deleteOnExit();
/* 389 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 395 */     return get(file2.getCanonicalPath());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FilePathDisk.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */