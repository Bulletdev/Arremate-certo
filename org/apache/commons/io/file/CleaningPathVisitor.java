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
/*     */ public class CleaningPathVisitor
/*     */   extends CountingPathVisitor
/*     */ {
/*     */   private final String[] skip;
/*     */   private final boolean overrideReadOnly;
/*     */   
/*     */   public static CountingPathVisitor withBigIntegerCounters() {
/*  44 */     return new CleaningPathVisitor(Counters.bigIntegerPathCounters(), new String[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CountingPathVisitor withLongCounters() {
/*  53 */     return new CleaningPathVisitor(Counters.longPathCounters(), new String[0]);
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
/*     */   public CleaningPathVisitor(Counters.PathCounters paramPathCounters, DeleteOption[] paramArrayOfDeleteOption, String... paramVarArgs) {
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
/*     */   public CleaningPathVisitor(Counters.PathCounters paramPathCounters, String... paramVarArgs) {
/*  83 */     this(paramPathCounters, PathUtils.EMPTY_DELETE_OPTION_ARRAY, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean accept(Path paramPath) {
/*  93 */     return (Arrays.binarySearch((Object[])this.skip, Objects.toString(paramPath.getFileName(), null)) < 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  98 */     if (this == paramObject) {
/*  99 */       return true;
/*     */     }
/* 101 */     if (!super.equals(paramObject)) {
/* 102 */       return false;
/*     */     }
/* 104 */     if (getClass() != paramObject.getClass()) {
/* 105 */       return false;
/*     */     }
/* 107 */     CleaningPathVisitor cleaningPathVisitor = (CleaningPathVisitor)paramObject;
/* 108 */     return (this.overrideReadOnly == cleaningPathVisitor.overrideReadOnly && Arrays.equals((Object[])this.skip, (Object[])cleaningPathVisitor.skip));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 113 */     byte b = 31;
/* 114 */     int i = super.hashCode();
/* 115 */     i = 31 * i + Arrays.hashCode((Object[])this.skip);
/* 116 */     i = 31 * i + Objects.hash(new Object[] { Boolean.valueOf(this.overrideReadOnly) });
/* 117 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileVisitResult preVisitDirectory(Path paramPath, BasicFileAttributes paramBasicFileAttributes) throws IOException {
/* 122 */     super.preVisitDirectory(paramPath, paramBasicFileAttributes);
/* 123 */     return accept(paramPath) ? FileVisitResult.CONTINUE : FileVisitResult.SKIP_SUBTREE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FileVisitResult visitFile(Path paramPath, BasicFileAttributes paramBasicFileAttributes) throws IOException {
/* 129 */     if (accept(paramPath) && Files.exists(paramPath, new LinkOption[] { LinkOption.NOFOLLOW_LINKS })) {
/* 130 */       if (this.overrideReadOnly) {
/* 131 */         PathUtils.setReadOnly(paramPath, false, new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
/*     */       }
/* 133 */       Files.deleteIfExists(paramPath);
/*     */     } 
/* 135 */     updateFileCounters(paramPath, paramBasicFileAttributes);
/* 136 */     return FileVisitResult.CONTINUE;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\file\CleaningPathVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */