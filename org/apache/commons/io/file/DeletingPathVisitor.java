/*     */ package org.apache.commons.io.file;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.FileVisitResult;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.LinkOption;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.attribute.BasicFileAttributes;
/*     */ import java.util.Arrays;
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
/*     */ public class DeletingPathVisitor
/*     */   extends CountingPathVisitor
/*     */ {
/*     */   private final String[] skip;
/*     */   private final boolean overrideReadOnly;
/*     */   
/*     */   public static DeletingPathVisitor withBigIntegerCounters() {
/*  45 */     return new DeletingPathVisitor(Counters.bigIntegerPathCounters(), new String[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DeletingPathVisitor withLongCounters() {
/*  54 */     return new DeletingPathVisitor(Counters.longPathCounters(), new String[0]);
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
/*     */   public DeletingPathVisitor(Counters.PathCounters paramPathCounters, DeleteOption[] paramArrayOfDeleteOption, String... paramVarArgs) {
/*  69 */     super(paramPathCounters);
/*  70 */     String[] arrayOfString = (paramVarArgs != null) ? (String[])paramVarArgs.clone() : EMPTY_STRING_ARRAY;
/*  71 */     Arrays.sort((Object[])arrayOfString);
/*  72 */     this.skip = arrayOfString;
/*  73 */     this.overrideReadOnly = StandardDeleteOption.overrideReadOnly(paramArrayOfDeleteOption);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DeletingPathVisitor(Counters.PathCounters paramPathCounters, String... paramVarArgs) {
/*  84 */     this(paramPathCounters, PathUtils.EMPTY_DELETE_OPTION_ARRAY, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean accept(Path paramPath) {
/*  94 */     return (Arrays.binarySearch((Object[])this.skip, Objects.toString(paramPath.getFileName(), null)) < 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  99 */     if (this == paramObject) {
/* 100 */       return true;
/*     */     }
/* 102 */     if (!super.equals(paramObject)) {
/* 103 */       return false;
/*     */     }
/* 105 */     if (getClass() != paramObject.getClass()) {
/* 106 */       return false;
/*     */     }
/* 108 */     DeletingPathVisitor deletingPathVisitor = (DeletingPathVisitor)paramObject;
/* 109 */     return (this.overrideReadOnly == deletingPathVisitor.overrideReadOnly && Arrays.equals((Object[])this.skip, (Object[])deletingPathVisitor.skip));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 114 */     byte b = 31;
/* 115 */     int i = super.hashCode();
/* 116 */     i = 31 * i + Arrays.hashCode((Object[])this.skip);
/* 117 */     i = 31 * i + Objects.hash(new Object[] { Boolean.valueOf(this.overrideReadOnly) });
/* 118 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileVisitResult postVisitDirectory(Path paramPath, IOException paramIOException) throws IOException {
/* 123 */     if (PathUtils.isEmptyDirectory(paramPath)) {
/* 124 */       Files.deleteIfExists(paramPath);
/*     */     }
/* 126 */     return super.postVisitDirectory(paramPath, paramIOException);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileVisitResult preVisitDirectory(Path paramPath, BasicFileAttributes paramBasicFileAttributes) throws IOException {
/* 131 */     super.preVisitDirectory(paramPath, paramBasicFileAttributes);
/* 132 */     return accept(paramPath) ? FileVisitResult.CONTINUE : FileVisitResult.SKIP_SUBTREE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FileVisitResult visitFile(Path paramPath, BasicFileAttributes paramBasicFileAttributes) throws IOException {
/* 138 */     if (accept(paramPath) && Files.exists(paramPath, new LinkOption[] { LinkOption.NOFOLLOW_LINKS })) {
/* 139 */       if (this.overrideReadOnly) {
/* 140 */         PathUtils.setReadOnly(paramPath, false, new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
/*     */       }
/* 142 */       Files.deleteIfExists(paramPath);
/*     */     } 
/* 144 */     updateFileCounters(paramPath, paramBasicFileAttributes);
/* 145 */     return FileVisitResult.CONTINUE;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\file\DeletingPathVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */