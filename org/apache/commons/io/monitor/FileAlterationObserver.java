/*     */ package org.apache.commons.io.monitor;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.apache.commons.io.IOCase;
/*     */ import org.apache.commons.io.comparator.NameFileComparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileAlterationObserver
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1185122225658782848L;
/* 125 */   private final List<FileAlterationListener> listeners = new CopyOnWriteArrayList<>();
/*     */ 
/*     */   
/*     */   private final FileEntry rootEntry;
/*     */   
/*     */   private final FileFilter fileFilter;
/*     */   
/*     */   private final Comparator<File> comparator;
/*     */ 
/*     */   
/*     */   public FileAlterationObserver(String paramString) {
/* 136 */     this(new File(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileAlterationObserver(String paramString, FileFilter paramFileFilter) {
/* 146 */     this(new File(paramString), paramFileFilter);
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
/*     */   public FileAlterationObserver(String paramString, FileFilter paramFileFilter, IOCase paramIOCase) {
/* 159 */     this(new File(paramString), paramFileFilter, paramIOCase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileAlterationObserver(File paramFile) {
/* 168 */     this(paramFile, (FileFilter)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileAlterationObserver(File paramFile, FileFilter paramFileFilter) {
/* 178 */     this(paramFile, paramFileFilter, (IOCase)null);
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
/*     */   public FileAlterationObserver(File paramFile, FileFilter paramFileFilter, IOCase paramIOCase) {
/* 190 */     this(new FileEntry(paramFile), paramFileFilter, paramIOCase);
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
/*     */   protected FileAlterationObserver(FileEntry paramFileEntry, FileFilter paramFileFilter, IOCase paramIOCase) {
/* 203 */     if (paramFileEntry == null) {
/* 204 */       throw new IllegalArgumentException("Root entry is missing");
/*     */     }
/* 206 */     if (paramFileEntry.getFile() == null) {
/* 207 */       throw new IllegalArgumentException("Root directory is missing");
/*     */     }
/* 209 */     this.rootEntry = paramFileEntry;
/* 210 */     this.fileFilter = paramFileFilter;
/* 211 */     if (paramIOCase == null || paramIOCase.equals(IOCase.SYSTEM)) {
/* 212 */       this.comparator = NameFileComparator.NAME_SYSTEM_COMPARATOR;
/* 213 */     } else if (paramIOCase.equals(IOCase.INSENSITIVE)) {
/* 214 */       this.comparator = NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
/*     */     } else {
/* 216 */       this.comparator = NameFileComparator.NAME_COMPARATOR;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getDirectory() {
/* 226 */     return this.rootEntry.getFile();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileFilter getFileFilter() {
/* 236 */     return this.fileFilter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addListener(FileAlterationListener paramFileAlterationListener) {
/* 245 */     if (paramFileAlterationListener != null) {
/* 246 */       this.listeners.add(paramFileAlterationListener);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeListener(FileAlterationListener paramFileAlterationListener) {
/* 256 */     if (paramFileAlterationListener != null) {
/* 257 */       while (this.listeners.remove(paramFileAlterationListener));
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
/*     */   public Iterable<FileAlterationListener> getListeners() {
/* 269 */     return this.listeners;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() throws Exception {
/* 278 */     this.rootEntry.refresh(this.rootEntry.getFile());
/* 279 */     FileEntry[] arrayOfFileEntry = doListFiles(this.rootEntry.getFile(), this.rootEntry);
/* 280 */     this.rootEntry.setChildren(arrayOfFileEntry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void destroy() throws Exception {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkAndNotify() {
/* 298 */     for (FileAlterationListener fileAlterationListener : this.listeners) {
/* 299 */       fileAlterationListener.onStart(this);
/*     */     }
/*     */ 
/*     */     
/* 303 */     File file = this.rootEntry.getFile();
/* 304 */     if (file.exists()) {
/* 305 */       checkAndNotify(this.rootEntry, this.rootEntry.getChildren(), listFiles(file));
/* 306 */     } else if (this.rootEntry.isExists()) {
/* 307 */       checkAndNotify(this.rootEntry, this.rootEntry.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 313 */     for (FileAlterationListener fileAlterationListener : this.listeners) {
/* 314 */       fileAlterationListener.onStop(this);
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
/*     */   private void checkAndNotify(FileEntry paramFileEntry, FileEntry[] paramArrayOfFileEntry, File[] paramArrayOfFile) {
/* 326 */     byte b = 0;
/* 327 */     FileEntry[] arrayOfFileEntry = (paramArrayOfFile.length > 0) ? new FileEntry[paramArrayOfFile.length] : FileEntry.EMPTY_ENTRIES;
/* 328 */     for (FileEntry fileEntry : paramArrayOfFileEntry) {
/* 329 */       while (b < paramArrayOfFile.length && this.comparator.compare(fileEntry.getFile(), paramArrayOfFile[b]) > 0) {
/* 330 */         arrayOfFileEntry[b] = createFileEntry(paramFileEntry, paramArrayOfFile[b]);
/* 331 */         doCreate(arrayOfFileEntry[b]);
/* 332 */         b++;
/*     */       } 
/* 334 */       if (b < paramArrayOfFile.length && this.comparator.compare(fileEntry.getFile(), paramArrayOfFile[b]) == 0) {
/* 335 */         doMatch(fileEntry, paramArrayOfFile[b]);
/* 336 */         checkAndNotify(fileEntry, fileEntry.getChildren(), listFiles(paramArrayOfFile[b]));
/* 337 */         arrayOfFileEntry[b] = fileEntry;
/* 338 */         b++;
/*     */       } else {
/* 340 */         checkAndNotify(fileEntry, fileEntry.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
/* 341 */         doDelete(fileEntry);
/*     */       } 
/*     */     } 
/* 344 */     for (; b < paramArrayOfFile.length; b++) {
/* 345 */       arrayOfFileEntry[b] = createFileEntry(paramFileEntry, paramArrayOfFile[b]);
/* 346 */       doCreate(arrayOfFileEntry[b]);
/*     */     } 
/* 348 */     paramFileEntry.setChildren(arrayOfFileEntry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FileEntry createFileEntry(FileEntry paramFileEntry, File paramFile) {
/* 359 */     FileEntry fileEntry = paramFileEntry.newChildInstance(paramFile);
/* 360 */     fileEntry.refresh(paramFile);
/* 361 */     FileEntry[] arrayOfFileEntry = doListFiles(paramFile, fileEntry);
/* 362 */     fileEntry.setChildren(arrayOfFileEntry);
/* 363 */     return fileEntry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FileEntry[] doListFiles(File paramFile, FileEntry paramFileEntry) {
/* 373 */     File[] arrayOfFile = listFiles(paramFile);
/* 374 */     FileEntry[] arrayOfFileEntry = (arrayOfFile.length > 0) ? new FileEntry[arrayOfFile.length] : FileEntry.EMPTY_ENTRIES;
/* 375 */     for (byte b = 0; b < arrayOfFile.length; b++) {
/* 376 */       arrayOfFileEntry[b] = createFileEntry(paramFileEntry, arrayOfFile[b]);
/*     */     }
/* 378 */     return arrayOfFileEntry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doCreate(FileEntry paramFileEntry) {
/* 387 */     for (FileAlterationListener fileAlterationListener : this.listeners) {
/* 388 */       if (paramFileEntry.isDirectory()) {
/* 389 */         fileAlterationListener.onDirectoryCreate(paramFileEntry.getFile()); continue;
/*     */       } 
/* 391 */       fileAlterationListener.onFileCreate(paramFileEntry.getFile());
/*     */     } 
/*     */     
/* 394 */     FileEntry[] arrayOfFileEntry = paramFileEntry.getChildren();
/* 395 */     for (FileEntry fileEntry : arrayOfFileEntry) {
/* 396 */       doCreate(fileEntry);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doMatch(FileEntry paramFileEntry, File paramFile) {
/* 407 */     if (paramFileEntry.refresh(paramFile)) {
/* 408 */       for (FileAlterationListener fileAlterationListener : this.listeners) {
/* 409 */         if (paramFileEntry.isDirectory()) {
/* 410 */           fileAlterationListener.onDirectoryChange(paramFile); continue;
/*     */         } 
/* 412 */         fileAlterationListener.onFileChange(paramFile);
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
/*     */   private void doDelete(FileEntry paramFileEntry) {
/* 424 */     for (FileAlterationListener fileAlterationListener : this.listeners) {
/* 425 */       if (paramFileEntry.isDirectory()) {
/* 426 */         fileAlterationListener.onDirectoryDelete(paramFileEntry.getFile()); continue;
/*     */       } 
/* 428 */       fileAlterationListener.onFileDelete(paramFileEntry.getFile());
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
/*     */   private File[] listFiles(File paramFile) {
/* 441 */     File[] arrayOfFile = null;
/* 442 */     if (paramFile.isDirectory()) {
/* 443 */       arrayOfFile = (this.fileFilter == null) ? paramFile.listFiles() : paramFile.listFiles(this.fileFilter);
/*     */     }
/* 445 */     if (arrayOfFile == null) {
/* 446 */       arrayOfFile = FileUtils.EMPTY_FILE_ARRAY;
/*     */     }
/* 448 */     if (this.comparator != null && arrayOfFile.length > 1) {
/* 449 */       Arrays.sort(arrayOfFile, this.comparator);
/*     */     }
/* 451 */     return arrayOfFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 461 */     StringBuilder stringBuilder = new StringBuilder();
/* 462 */     stringBuilder.append(getClass().getSimpleName());
/* 463 */     stringBuilder.append("[file='");
/* 464 */     stringBuilder.append(getDirectory().getPath());
/* 465 */     stringBuilder.append('\'');
/* 466 */     if (this.fileFilter != null) {
/* 467 */       stringBuilder.append(", ");
/* 468 */       stringBuilder.append(this.fileFilter.toString());
/*     */     } 
/* 470 */     stringBuilder.append(", listeners=");
/* 471 */     stringBuilder.append(this.listeners.size());
/* 472 */     stringBuilder.append("]");
/* 473 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\monitor\FileAlterationObserver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */