/*     */ package org.apache.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FilenameFilter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.apache.commons.io.IOCase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileFilterUtils
/*     */ {
/*     */   public static File[] filter(IOFileFilter paramIOFileFilter, File... paramVarArgs) {
/*  78 */     if (paramIOFileFilter == null) {
/*  79 */       throw new IllegalArgumentException("file filter is null");
/*     */     }
/*  81 */     if (paramVarArgs == null) {
/*  82 */       return FileUtils.EMPTY_FILE_ARRAY;
/*     */     }
/*  84 */     ArrayList<File> arrayList = new ArrayList();
/*  85 */     for (File file : paramVarArgs) {
/*  86 */       if (file == null) {
/*  87 */         throw new IllegalArgumentException("file array contains null");
/*     */       }
/*  89 */       if (paramIOFileFilter.accept(file)) {
/*  90 */         arrayList.add(file);
/*     */       }
/*     */     } 
/*  93 */     return arrayList.<File>toArray(FileUtils.EMPTY_FILE_ARRAY);
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
/*     */   public static File[] filter(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable) {
/* 123 */     List<File> list = filterList(paramIOFileFilter, paramIterable);
/* 124 */     return list.<File>toArray(FileUtils.EMPTY_FILE_ARRAY);
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
/*     */   public static List<File> filterList(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable) {
/* 153 */     return filter(paramIOFileFilter, paramIterable, new ArrayList<>());
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
/*     */   public static List<File> filterList(IOFileFilter paramIOFileFilter, File... paramVarArgs) {
/* 182 */     File[] arrayOfFile = filter(paramIOFileFilter, paramVarArgs);
/* 183 */     return Arrays.asList(arrayOfFile);
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
/*     */   public static Set<File> filterSet(IOFileFilter paramIOFileFilter, File... paramVarArgs) {
/* 213 */     File[] arrayOfFile = filter(paramIOFileFilter, paramVarArgs);
/* 214 */     return new HashSet<>(Arrays.asList(arrayOfFile));
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
/*     */   public static Set<File> filterSet(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable) {
/* 244 */     return filter(paramIOFileFilter, paramIterable, new HashSet<>());
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
/*     */   private static <T extends java.util.Collection<File>> T filter(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable, T paramT) {
/* 271 */     if (paramIOFileFilter == null) {
/* 272 */       throw new IllegalArgumentException("file filter is null");
/*     */     }
/* 274 */     if (paramIterable != null) {
/* 275 */       for (File file : paramIterable) {
/* 276 */         if (file == null) {
/* 277 */           throw new IllegalArgumentException("file collection contains null");
/*     */         }
/* 279 */         if (paramIOFileFilter.accept(file)) {
/* 280 */           paramT.add(file);
/*     */         }
/*     */       } 
/*     */     }
/* 284 */     return paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter prefixFileFilter(String paramString) {
/* 295 */     return new PrefixFileFilter(paramString);
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
/*     */   public static IOFileFilter prefixFileFilter(String paramString, IOCase paramIOCase) {
/* 308 */     return new PrefixFileFilter(paramString, paramIOCase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter suffixFileFilter(String paramString) {
/* 319 */     return new SuffixFileFilter(paramString);
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
/*     */   public static IOFileFilter suffixFileFilter(String paramString, IOCase paramIOCase) {
/* 332 */     return new SuffixFileFilter(paramString, paramIOCase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter nameFileFilter(String paramString) {
/* 343 */     return new NameFileFilter(paramString);
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
/*     */   public static IOFileFilter nameFileFilter(String paramString, IOCase paramIOCase) {
/* 356 */     return new NameFileFilter(paramString, paramIOCase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter directoryFileFilter() {
/* 366 */     return DirectoryFileFilter.DIRECTORY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter fileFileFilter() {
/* 376 */     return FileFileFilter.FILE;
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
/*     */   @Deprecated
/*     */   public static IOFileFilter andFileFilter(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/* 392 */     return new AndFileFilter(paramIOFileFilter1, paramIOFileFilter2);
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
/*     */   @Deprecated
/*     */   public static IOFileFilter orFileFilter(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/* 407 */     return new OrFileFilter(paramIOFileFilter1, paramIOFileFilter2);
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
/*     */   public static IOFileFilter and(IOFileFilter... paramVarArgs) {
/* 422 */     return new AndFileFilter(toList(paramVarArgs));
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
/*     */   public static IOFileFilter or(IOFileFilter... paramVarArgs) {
/* 437 */     return new OrFileFilter(toList(paramVarArgs));
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
/*     */   public static List<IOFileFilter> toList(IOFileFilter... paramVarArgs) {
/* 450 */     if (paramVarArgs == null) {
/* 451 */       throw new IllegalArgumentException("The filters must not be null");
/*     */     }
/* 453 */     ArrayList<IOFileFilter> arrayList = new ArrayList(paramVarArgs.length);
/* 454 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 455 */       if (paramVarArgs[b] == null) {
/* 456 */         throw new IllegalArgumentException("The filter[" + b + "] is null");
/*     */       }
/* 458 */       arrayList.add(paramVarArgs[b]);
/*     */     } 
/* 460 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter notFileFilter(IOFileFilter paramIOFileFilter) {
/* 471 */     return new NotFileFilter(paramIOFileFilter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter trueFileFilter() {
/* 482 */     return TrueFileFilter.TRUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter falseFileFilter() {
/* 492 */     return FalseFileFilter.FALSE;
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
/*     */   public static IOFileFilter asFileFilter(FileFilter paramFileFilter) {
/* 505 */     return new DelegateFileFilter(paramFileFilter);
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
/*     */   public static IOFileFilter asFileFilter(FilenameFilter paramFilenameFilter) {
/* 517 */     return new DelegateFileFilter(paramFilenameFilter);
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
/*     */   public static IOFileFilter ageFileFilter(long paramLong) {
/* 531 */     return new AgeFileFilter(paramLong);
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
/*     */   public static IOFileFilter ageFileFilter(long paramLong, boolean paramBoolean) {
/* 544 */     return new AgeFileFilter(paramLong, paramBoolean);
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
/*     */   public static IOFileFilter ageFileFilter(Date paramDate) {
/* 557 */     return new AgeFileFilter(paramDate);
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
/*     */   public static IOFileFilter ageFileFilter(Date paramDate, boolean paramBoolean) {
/* 570 */     return new AgeFileFilter(paramDate, paramBoolean);
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
/*     */   public static IOFileFilter ageFileFilter(File paramFile) {
/* 584 */     return new AgeFileFilter(paramFile);
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
/*     */   public static IOFileFilter ageFileFilter(File paramFile, boolean paramBoolean) {
/* 598 */     return new AgeFileFilter(paramFile, paramBoolean);
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
/*     */   public static IOFileFilter sizeFileFilter(long paramLong) {
/* 611 */     return new SizeFileFilter(paramLong);
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
/*     */   public static IOFileFilter sizeFileFilter(long paramLong, boolean paramBoolean) {
/* 624 */     return new SizeFileFilter(paramLong, paramBoolean);
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
/*     */   public static IOFileFilter sizeRangeFileFilter(long paramLong1, long paramLong2) {
/* 638 */     SizeFileFilter sizeFileFilter1 = new SizeFileFilter(paramLong1, true);
/* 639 */     SizeFileFilter sizeFileFilter2 = new SizeFileFilter(paramLong2 + 1L, false);
/* 640 */     return new AndFileFilter(sizeFileFilter1, sizeFileFilter2);
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
/*     */   public static IOFileFilter magicNumberFileFilter(String paramString) {
/* 659 */     return new MagicNumberFileFilter(paramString);
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
/*     */   public static IOFileFilter magicNumberFileFilter(String paramString, long paramLong) {
/* 680 */     return new MagicNumberFileFilter(paramString, paramLong);
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
/*     */   public static IOFileFilter magicNumberFileFilter(byte[] paramArrayOfbyte) {
/* 699 */     return new MagicNumberFileFilter(paramArrayOfbyte);
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
/*     */   public static IOFileFilter magicNumberFileFilter(byte[] paramArrayOfbyte, long paramLong) {
/* 720 */     return new MagicNumberFileFilter(paramArrayOfbyte, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 725 */   private static final IOFileFilter cvsFilter = notFileFilter(
/* 726 */       and(new IOFileFilter[] { directoryFileFilter(), nameFileFilter("CVS") }));
/*     */ 
/*     */   
/* 729 */   private static final IOFileFilter svnFilter = notFileFilter(
/* 730 */       and(new IOFileFilter[] { directoryFileFilter(), nameFileFilter(".svn") }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter makeCVSAware(IOFileFilter paramIOFileFilter) {
/* 742 */     return (paramIOFileFilter == null) ? cvsFilter : and(new IOFileFilter[] { paramIOFileFilter, cvsFilter });
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
/*     */   public static IOFileFilter makeSVNAware(IOFileFilter paramIOFileFilter) {
/* 755 */     return (paramIOFileFilter == null) ? svnFilter : and(new IOFileFilter[] { paramIOFileFilter, svnFilter });
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
/*     */   public static IOFileFilter makeDirectoryOnly(IOFileFilter paramIOFileFilter) {
/* 768 */     if (paramIOFileFilter == null) {
/* 769 */       return DirectoryFileFilter.DIRECTORY;
/*     */     }
/* 771 */     return new AndFileFilter(DirectoryFileFilter.DIRECTORY, paramIOFileFilter);
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
/*     */   public static IOFileFilter makeFileOnly(IOFileFilter paramIOFileFilter) {
/* 783 */     if (paramIOFileFilter == null) {
/* 784 */       return FileFileFilter.FILE;
/*     */     }
/* 786 */     return new AndFileFilter(FileFileFilter.FILE, paramIOFileFilter);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\filefilter\FileFilterUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */