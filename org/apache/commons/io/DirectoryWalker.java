/*     */ package org.apache.commons.io;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.Objects;
/*     */ import org.apache.commons.io.filefilter.FileFilterUtils;
/*     */ import org.apache.commons.io.filefilter.IOFileFilter;
/*     */ import org.apache.commons.io.filefilter.TrueFileFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class DirectoryWalker<T>
/*     */ {
/*     */   private final FileFilter filter;
/*     */   private final int depthLimit;
/*     */   
/*     */   protected DirectoryWalker() {
/* 284 */     this(null, -1);
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
/*     */   protected DirectoryWalker(FileFilter paramFileFilter, int paramInt) {
/* 301 */     this.filter = paramFileFilter;
/* 302 */     this.depthLimit = paramInt;
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
/*     */   protected DirectoryWalker(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2, int paramInt) {
/* 321 */     if (paramIOFileFilter1 == null && paramIOFileFilter2 == null) {
/* 322 */       this.filter = null;
/*     */     } else {
/* 324 */       paramIOFileFilter1 = (paramIOFileFilter1 != null) ? paramIOFileFilter1 : TrueFileFilter.TRUE;
/* 325 */       paramIOFileFilter2 = (paramIOFileFilter2 != null) ? paramIOFileFilter2 : TrueFileFilter.TRUE;
/* 326 */       paramIOFileFilter1 = FileFilterUtils.makeDirectoryOnly(paramIOFileFilter1);
/* 327 */       paramIOFileFilter2 = FileFilterUtils.makeFileOnly(paramIOFileFilter2);
/* 328 */       this.filter = (FileFilter)FileFilterUtils.or(new IOFileFilter[] { paramIOFileFilter1, paramIOFileFilter2 });
/*     */     } 
/* 330 */     this.depthLimit = paramInt;
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
/*     */   protected final void walk(File paramFile, Collection<T> paramCollection) throws IOException {
/* 352 */     Objects.requireNonNull(paramFile, "startDirectory");
/*     */     try {
/* 354 */       handleStart(paramFile, paramCollection);
/* 355 */       walk(paramFile, 0, paramCollection);
/* 356 */       handleEnd(paramCollection);
/* 357 */     } catch (CancelException cancelException) {
/* 358 */       handleCancelled(paramFile, paramCollection, cancelException);
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
/*     */   private void walk(File paramFile, int paramInt, Collection<T> paramCollection) throws IOException {
/* 371 */     checkIfCancelled(paramFile, paramInt, paramCollection);
/* 372 */     if (handleDirectory(paramFile, paramInt, paramCollection)) {
/* 373 */       handleDirectoryStart(paramFile, paramInt, paramCollection);
/* 374 */       int i = paramInt + 1;
/* 375 */       if (this.depthLimit < 0 || i <= this.depthLimit) {
/* 376 */         checkIfCancelled(paramFile, paramInt, paramCollection);
/* 377 */         File[] arrayOfFile = (this.filter == null) ? paramFile.listFiles() : paramFile.listFiles(this.filter);
/* 378 */         arrayOfFile = filterDirectoryContents(paramFile, paramInt, arrayOfFile);
/* 379 */         if (arrayOfFile == null) {
/* 380 */           handleRestricted(paramFile, i, paramCollection);
/*     */         } else {
/* 382 */           for (File file : arrayOfFile) {
/* 383 */             if (file.isDirectory()) {
/* 384 */               walk(file, i, paramCollection);
/*     */             } else {
/* 386 */               checkIfCancelled(file, i, paramCollection);
/* 387 */               handleFile(file, i, paramCollection);
/* 388 */               checkIfCancelled(file, i, paramCollection);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 393 */       handleDirectoryEnd(paramFile, paramInt, paramCollection);
/*     */     } 
/* 395 */     checkIfCancelled(paramFile, paramInt, paramCollection);
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
/*     */   protected final void checkIfCancelled(File paramFile, int paramInt, Collection<T> paramCollection) throws IOException {
/* 416 */     if (handleIsCancelled(paramFile, paramInt, paramCollection)) {
/* 417 */       throw new CancelException(paramFile, paramInt);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean handleIsCancelled(File paramFile, int paramInt, Collection<T> paramCollection) throws IOException {
/* 462 */     return false;
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
/*     */   protected void handleCancelled(File paramFile, Collection<T> paramCollection, CancelException paramCancelException) throws IOException {
/* 482 */     throw paramCancelException;
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
/*     */   protected void handleStart(File paramFile, Collection<T> paramCollection) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean handleDirectory(File paramFile, int paramInt, Collection<T> paramCollection) throws IOException {
/* 520 */     return true;
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
/*     */   protected void handleDirectoryStart(File paramFile, int paramInt, Collection<T> paramCollection) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected File[] filterDirectoryContents(File paramFile, int paramInt, File... paramVarArgs) throws IOException {
/* 554 */     return paramVarArgs;
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
/*     */   protected void handleFile(File paramFile, int paramInt, Collection<T> paramCollection) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleRestricted(File paramFile, int paramInt, Collection<T> paramCollection) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleDirectoryEnd(File paramFile, int paramInt, Collection<T> paramCollection) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleEnd(Collection<T> paramCollection) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CancelException
/*     */     extends IOException
/*     */   {
/*     */     private static final long serialVersionUID = 1347339620135041008L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final File file;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int depth;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CancelException(File param1File, int param1Int) {
/* 640 */       this("Operation Cancelled", param1File, param1Int);
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
/*     */     public CancelException(String param1String, File param1File, int param1Int) {
/* 653 */       super(param1String);
/* 654 */       this.file = param1File;
/* 655 */       this.depth = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public File getFile() {
/* 664 */       return this.file;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getDepth() {
/* 673 */       return this.depth;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\DirectoryWalker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */