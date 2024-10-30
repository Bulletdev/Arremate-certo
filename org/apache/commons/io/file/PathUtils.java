/*     */ package org.apache.commons.io.file;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.nio.file.CopyOption;
/*     */ import java.nio.file.DirectoryStream;
/*     */ import java.nio.file.FileVisitOption;
/*     */ import java.nio.file.FileVisitor;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.LinkOption;
/*     */ import java.nio.file.NoSuchFileException;
/*     */ import java.nio.file.OpenOption;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.nio.file.attribute.AclEntry;
/*     */ import java.nio.file.attribute.AclFileAttributeView;
/*     */ import java.nio.file.attribute.DosFileAttributeView;
/*     */ import java.nio.file.attribute.PosixFileAttributeView;
/*     */ import java.nio.file.attribute.PosixFileAttributes;
/*     */ import java.nio.file.attribute.PosixFilePermission;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.EnumSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collector;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PathUtils
/*     */ {
/*     */   private static class RelativeSortedPaths
/*     */   {
/*     */     final boolean equals;
/*     */     final List<Path> relativeFileList1;
/*     */     final List<Path> relativeFileList2;
/*     */     
/*     */     private RelativeSortedPaths(Path param1Path1, Path param1Path2, int param1Int, LinkOption[] param1ArrayOfLinkOption, FileVisitOption[] param1ArrayOfFileVisitOption) throws IOException {
/*  84 */       List<Path> list1 = null;
/*  85 */       List<Path> list2 = null;
/*  86 */       List<Path> list3 = null;
/*  87 */       List<Path> list4 = null;
/*  88 */       if (param1Path1 == null && param1Path2 == null) {
/*  89 */         this.equals = true;
/*  90 */       } else if ((((param1Path1 == null) ? 1 : 0) ^ ((param1Path2 == null) ? 1 : 0)) != 0) {
/*  91 */         this.equals = false;
/*     */       } else {
/*  93 */         boolean bool1 = Files.exists(param1Path1, param1ArrayOfLinkOption);
/*  94 */         boolean bool2 = Files.exists(param1Path2, param1ArrayOfLinkOption);
/*  95 */         if (!bool1 || !bool2) {
/*  96 */           this.equals = (!bool1 && !bool2);
/*     */         } else {
/*  98 */           AccumulatorPathVisitor accumulatorPathVisitor1 = PathUtils.accumulate(param1Path1, param1Int, param1ArrayOfFileVisitOption);
/*  99 */           AccumulatorPathVisitor accumulatorPathVisitor2 = PathUtils.accumulate(param1Path2, param1Int, param1ArrayOfFileVisitOption);
/* 100 */           if (accumulatorPathVisitor1.getDirList().size() != accumulatorPathVisitor2.getDirList().size() || accumulatorPathVisitor1
/* 101 */             .getFileList().size() != accumulatorPathVisitor2.getFileList().size()) {
/* 102 */             this.equals = false;
/*     */           } else {
/* 104 */             list1 = accumulatorPathVisitor1.relativizeDirectories(param1Path1, true, null);
/* 105 */             list2 = accumulatorPathVisitor2.relativizeDirectories(param1Path2, true, null);
/* 106 */             if (!list1.equals(list2)) {
/* 107 */               this.equals = false;
/*     */             } else {
/* 109 */               list3 = accumulatorPathVisitor1.relativizeFiles(param1Path1, true, null);
/* 110 */               list4 = accumulatorPathVisitor2.relativizeFiles(param1Path2, true, null);
/* 111 */               this.equals = list3.equals(list4);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 118 */       this.relativeFileList1 = list3;
/* 119 */       this.relativeFileList2 = list4;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public static final DeleteOption[] EMPTY_DELETE_OPTION_ARRAY = new DeleteOption[0];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   public static final FileVisitOption[] EMPTY_FILE_VISIT_OPTION_ARRAY = new FileVisitOption[0];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 138 */   public static final LinkOption[] EMPTY_LINK_OPTION_ARRAY = new LinkOption[0];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 143 */   public static final OpenOption[] EMPTY_OPEN_OPTION_ARRAY = new OpenOption[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static AccumulatorPathVisitor accumulate(Path paramPath, int paramInt, FileVisitOption[] paramArrayOfFileVisitOption) throws IOException {
/* 156 */     return visitFileTree(AccumulatorPathVisitor.withLongCounters(), paramPath, 
/* 157 */         toFileVisitOptionSet(paramArrayOfFileVisitOption), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Counters.PathCounters cleanDirectory(Path paramPath) throws IOException {
/* 168 */     return cleanDirectory(paramPath, EMPTY_DELETE_OPTION_ARRAY);
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
/*     */   public static Counters.PathCounters cleanDirectory(Path paramPath, DeleteOption... paramVarArgs) throws IOException {
/* 181 */     return ((CleaningPathVisitor)visitFileTree(new CleaningPathVisitor(Counters.longPathCounters(), paramVarArgs, new String[0]), paramPath))
/* 182 */       .getPathCounters();
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
/*     */   public static Counters.PathCounters copyDirectory(Path paramPath1, Path paramPath2, CopyOption... paramVarArgs) throws IOException {
/* 196 */     return ((CopyDirectoryVisitor)visitFileTree(new CopyDirectoryVisitor(
/* 197 */           Counters.longPathCounters(), paramPath1, paramPath2, paramVarArgs), paramPath1))
/* 198 */       .getPathCounters();
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
/*     */   public static Path copyFile(URL paramURL, Path paramPath, CopyOption... paramVarArgs) throws IOException {
/* 213 */     try (InputStream null = paramURL.openStream()) {
/* 214 */       Files.copy(inputStream, paramPath, paramVarArgs);
/* 215 */       return paramPath;
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
/*     */   public static Path copyFileToDirectory(Path paramPath1, Path paramPath2, CopyOption... paramVarArgs) throws IOException {
/* 231 */     return Files.copy(paramPath1, paramPath2.resolve(paramPath1.getFileName()), paramVarArgs);
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
/*     */   public static Path copyFileToDirectory(URL paramURL, Path paramPath, CopyOption... paramVarArgs) throws IOException {
/* 246 */     try (InputStream null = paramURL.openStream()) {
/* 247 */       Files.copy(inputStream, paramPath.resolve(paramURL.getFile()), paramVarArgs);
/* 248 */       return paramPath;
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
/*     */   public static Counters.PathCounters countDirectory(Path paramPath) throws IOException {
/* 260 */     return ((CountingPathVisitor)visitFileTree(new CountingPathVisitor(Counters.longPathCounters()), paramPath)).getPathCounters();
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
/*     */   public static Counters.PathCounters delete(Path paramPath) throws IOException {
/* 280 */     return delete(paramPath, EMPTY_DELETE_OPTION_ARRAY);
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
/*     */   public static Counters.PathCounters delete(Path paramPath, DeleteOption... paramVarArgs) throws IOException {
/* 303 */     return Files.isDirectory(paramPath, new LinkOption[] { LinkOption.NOFOLLOW_LINKS }) ? deleteDirectory(paramPath, paramVarArgs) : 
/* 304 */       deleteFile(paramPath, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Counters.PathCounters deleteDirectory(Path paramPath) throws IOException {
/* 315 */     return deleteDirectory(paramPath, EMPTY_DELETE_OPTION_ARRAY);
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
/*     */   public static Counters.PathCounters deleteDirectory(Path paramPath, DeleteOption... paramVarArgs) throws IOException {
/* 328 */     return ((DeletingPathVisitor)visitFileTree(new DeletingPathVisitor(Counters.longPathCounters(), paramVarArgs, new String[0]), paramPath))
/* 329 */       .getPathCounters();
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
/*     */   public static Counters.PathCounters deleteFile(Path paramPath) throws IOException {
/* 341 */     return deleteFile(paramPath, EMPTY_DELETE_OPTION_ARRAY);
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
/*     */   public static Counters.PathCounters deleteFile(Path paramPath, DeleteOption... paramVarArgs) throws IOException {
/* 356 */     if (Files.isDirectory(paramPath, new LinkOption[] { LinkOption.NOFOLLOW_LINKS })) {
/* 357 */       throw new NoSuchFileException(paramPath.toString());
/*     */     }
/* 359 */     Counters.PathCounters pathCounters = Counters.longPathCounters();
/* 360 */     boolean bool = Files.exists(paramPath, new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
/* 361 */     long l = bool ? Files.size(paramPath) : 0L;
/* 362 */     if (overrideReadOnly(paramVarArgs) && bool) {
/* 363 */       setReadOnly(paramPath, false, new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
/*     */     }
/* 365 */     if (Files.deleteIfExists(paramPath)) {
/* 366 */       pathCounters.getFileCounter().increment();
/* 367 */       pathCounters.getByteCounter().add(l);
/*     */     } 
/* 369 */     return pathCounters;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean overrideReadOnly(DeleteOption[] paramArrayOfDeleteOption) {
/* 379 */     if (paramArrayOfDeleteOption == null) {
/* 380 */       return false;
/*     */     }
/* 382 */     for (DeleteOption deleteOption : paramArrayOfDeleteOption) {
/* 383 */       if (deleteOption == StandardDeleteOption.OVERRIDE_READ_ONLY) {
/* 384 */         return true;
/*     */       }
/*     */     } 
/* 387 */     return false;
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
/*     */   public static boolean directoryAndFileContentEquals(Path paramPath1, Path paramPath2) throws IOException {
/* 400 */     return directoryAndFileContentEquals(paramPath1, paramPath2, EMPTY_LINK_OPTION_ARRAY, EMPTY_OPEN_OPTION_ARRAY, EMPTY_FILE_VISIT_OPTION_ARRAY);
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
/*     */   public static boolean directoryAndFileContentEquals(Path paramPath1, Path paramPath2, LinkOption[] paramArrayOfLinkOption, OpenOption[] paramArrayOfOpenOption, FileVisitOption[] paramArrayOfFileVisitOption) throws IOException {
/* 420 */     if (paramPath1 == null && paramPath2 == null) {
/* 421 */       return true;
/*     */     }
/* 423 */     if ((((paramPath1 == null) ? 1 : 0) ^ ((paramPath2 == null) ? 1 : 0)) != 0) {
/* 424 */       return false;
/*     */     }
/* 426 */     if (!Files.exists(paramPath1, new LinkOption[0]) && !Files.exists(paramPath2, new LinkOption[0])) {
/* 427 */       return true;
/*     */     }
/* 429 */     RelativeSortedPaths relativeSortedPaths = new RelativeSortedPaths(paramPath1, paramPath2, 2147483647, paramArrayOfLinkOption, paramArrayOfFileVisitOption);
/*     */ 
/*     */     
/* 432 */     if (!relativeSortedPaths.equals) {
/* 433 */       return false;
/*     */     }
/*     */     
/* 436 */     List<Path> list1 = relativeSortedPaths.relativeFileList1;
/* 437 */     List<Path> list2 = relativeSortedPaths.relativeFileList2;
/* 438 */     for (Path path : list1) {
/* 439 */       int i = Collections.binarySearch((List)list2, path);
/* 440 */       if (i > -1) {
/* 441 */         if (!fileContentEquals(paramPath1.resolve(path), paramPath2.resolve(path), paramArrayOfLinkOption, paramArrayOfOpenOption))
/* 442 */           return false; 
/*     */         continue;
/*     */       } 
/* 445 */       throw new IllegalStateException("Unexpected mismatch.");
/*     */     } 
/*     */     
/* 448 */     return true;
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
/*     */   public static boolean directoryContentEquals(Path paramPath1, Path paramPath2) throws IOException {
/* 461 */     return directoryContentEquals(paramPath1, paramPath2, 2147483647, EMPTY_LINK_OPTION_ARRAY, EMPTY_FILE_VISIT_OPTION_ARRAY);
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
/*     */   public static boolean directoryContentEquals(Path paramPath1, Path paramPath2, int paramInt, LinkOption[] paramArrayOfLinkOption, FileVisitOption[] paramArrayOfFileVisitOption) throws IOException {
/* 479 */     return (new RelativeSortedPaths(paramPath1, paramPath2, paramInt, paramArrayOfLinkOption, paramArrayOfFileVisitOption)).equals;
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
/*     */   public static boolean fileContentEquals(Path paramPath1, Path paramPath2) throws IOException {
/* 496 */     return fileContentEquals(paramPath1, paramPath2, EMPTY_LINK_OPTION_ARRAY, EMPTY_OPEN_OPTION_ARRAY);
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
/*     */   public static boolean fileContentEquals(Path paramPath1, Path paramPath2, LinkOption[] paramArrayOfLinkOption, OpenOption[] paramArrayOfOpenOption) throws IOException {
/* 516 */     if (paramPath1 == null && paramPath2 == null) {
/* 517 */       return true;
/*     */     }
/* 519 */     if ((((paramPath1 == null) ? 1 : 0) ^ ((paramPath2 == null) ? 1 : 0)) != 0) {
/* 520 */       return false;
/*     */     }
/* 522 */     Path path1 = paramPath1.normalize();
/* 523 */     Path path2 = paramPath2.normalize();
/* 524 */     boolean bool = Files.exists(path1, paramArrayOfLinkOption);
/* 525 */     if (bool != Files.exists(path2, paramArrayOfLinkOption)) {
/* 526 */       return false;
/*     */     }
/* 528 */     if (!bool)
/*     */     {
/*     */       
/* 531 */       return true;
/*     */     }
/* 533 */     if (Files.isDirectory(path1, paramArrayOfLinkOption))
/*     */     {
/* 535 */       throw new IOException("Can't compare directories, only files: " + path1);
/*     */     }
/* 537 */     if (Files.isDirectory(path2, paramArrayOfLinkOption))
/*     */     {
/* 539 */       throw new IOException("Can't compare directories, only files: " + path2);
/*     */     }
/* 541 */     if (Files.size(path1) != Files.size(path2))
/*     */     {
/* 543 */       return false;
/*     */     }
/* 545 */     if (paramPath1.equals(paramPath2))
/*     */     {
/* 547 */       return true;
/*     */     }
/* 549 */     try(InputStream null = Files.newInputStream(path1, paramArrayOfOpenOption); 
/* 550 */         InputStream null = Files.newInputStream(path2, paramArrayOfOpenOption)) {
/* 551 */       return IOUtils.contentEquals(inputStream, inputStream1);
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
/*     */   public static List<AclEntry> getAclEntryList(Path paramPath) throws IOException {
/* 564 */     AclFileAttributeView aclFileAttributeView = Files.<AclFileAttributeView>getFileAttributeView(paramPath, AclFileAttributeView.class, new LinkOption[0]);
/*     */     
/* 566 */     return (aclFileAttributeView == null) ? null : aclFileAttributeView.getAcl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isEmpty(Path paramPath) throws IOException {
/* 577 */     return Files.isDirectory(paramPath, new LinkOption[0]) ? isEmptyDirectory(paramPath) : isEmptyFile(paramPath);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isEmptyDirectory(Path paramPath) throws IOException {
/* 588 */     try (DirectoryStream<Path> null = Files.newDirectoryStream(paramPath)) {
/* 589 */       if (directoryStream.iterator().hasNext()) {
/* 590 */         return false;
/*     */       }
/*     */     } 
/* 593 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isEmptyFile(Path paramPath) throws IOException {
/* 604 */     return (Files.size(paramPath) <= 0L);
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
/*     */   static List<Path> relativize(Collection<Path> paramCollection, Path paramPath, boolean paramBoolean, Comparator<? super Path> paramComparator) {
/* 618 */     Stream<T> stream = paramCollection.stream().map(paramPath::relativize);
/* 619 */     if (paramBoolean) {
/* 620 */       stream = (paramComparator == null) ? stream.sorted() : stream.sorted((Comparator)paramComparator);
/*     */     }
/* 622 */     return stream.collect((Collector)Collectors.toList());
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
/*     */   public static Path setReadOnly(Path paramPath, boolean paramBoolean, LinkOption... paramVarArgs) throws IOException {
/* 640 */     DosFileAttributeView dosFileAttributeView = Files.<DosFileAttributeView>getFileAttributeView(paramPath, DosFileAttributeView.class, paramVarArgs);
/*     */     
/* 642 */     if (dosFileAttributeView != null) {
/* 643 */       dosFileAttributeView.setReadOnly(paramBoolean);
/* 644 */       return paramPath;
/*     */     } 
/* 646 */     PosixFileAttributeView posixFileAttributeView = Files.<PosixFileAttributeView>getFileAttributeView(paramPath, PosixFileAttributeView.class, paramVarArgs);
/*     */     
/* 648 */     if (posixFileAttributeView != null) {
/*     */ 
/*     */ 
/*     */       
/* 652 */       PosixFileAttributes posixFileAttributes = posixFileAttributeView.readAttributes();
/* 653 */       Set<PosixFilePermission> set = posixFileAttributes.permissions();
/* 654 */       set.remove(PosixFilePermission.OWNER_WRITE);
/* 655 */       set.remove(PosixFilePermission.GROUP_WRITE);
/* 656 */       set.remove(PosixFilePermission.OTHERS_WRITE);
/* 657 */       return Files.setPosixFilePermissions(paramPath, set);
/*     */     } 
/* 659 */     throw new IOException("No DosFileAttributeView or PosixFileAttributeView for " + paramPath);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Set<FileVisitOption> toFileVisitOptionSet(FileVisitOption... paramVarArgs) {
/* 669 */     return (paramVarArgs == null) ? EnumSet.<FileVisitOption>noneOf(FileVisitOption.class) : 
/* 670 */       (Set<FileVisitOption>)Arrays.<FileVisitOption>stream(paramVarArgs).collect(Collectors.toSet());
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
/*     */   public static <T extends FileVisitor<? super Path>> T visitFileTree(T paramT, Path paramPath) throws IOException {
/* 687 */     Files.walkFileTree(paramPath, (FileVisitor<? super Path>)paramT);
/* 688 */     return paramT;
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
/*     */   public static <T extends FileVisitor<? super Path>> T visitFileTree(T paramT, Path paramPath, Set<FileVisitOption> paramSet, int paramInt) throws IOException {
/* 707 */     Files.walkFileTree(paramPath, paramSet, paramInt, (FileVisitor<? super Path>)paramT);
/* 708 */     return paramT;
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
/*     */   public static <T extends FileVisitor<? super Path>> T visitFileTree(T paramT, String paramString, String... paramVarArgs) throws IOException {
/* 726 */     return visitFileTree(paramT, Paths.get(paramString, paramVarArgs));
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
/*     */   public static <T extends FileVisitor<? super Path>> T visitFileTree(T paramT, URI paramURI) throws IOException {
/* 743 */     return visitFileTree(paramT, Paths.get(paramURI));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\file\PathUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */