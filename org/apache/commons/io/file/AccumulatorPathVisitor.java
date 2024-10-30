/*     */ package org.apache.commons.io.file;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.FileVisitResult;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.attribute.BasicFileAttributes;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
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
/*     */ 
/*     */ public class AccumulatorPathVisitor
/*     */   extends CountingPathVisitor
/*     */ {
/*     */   public static AccumulatorPathVisitor withBigIntegerCounters() {
/*  48 */     return new AccumulatorPathVisitor(Counters.bigIntegerPathCounters());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AccumulatorPathVisitor withLongCounters() {
/*  57 */     return new AccumulatorPathVisitor(Counters.longPathCounters());
/*     */   }
/*     */   
/*  60 */   private final List<Path> dirList = new ArrayList<>();
/*     */   
/*  62 */   private final List<Path> fileList = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AccumulatorPathVisitor(Counters.PathCounters paramPathCounters) {
/*  70 */     super(paramPathCounters);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  75 */     if (this == paramObject) {
/*  76 */       return true;
/*     */     }
/*  78 */     if (!super.equals(paramObject)) {
/*  79 */       return false;
/*     */     }
/*  81 */     if (!(paramObject instanceof AccumulatorPathVisitor)) {
/*  82 */       return false;
/*     */     }
/*  84 */     AccumulatorPathVisitor accumulatorPathVisitor = (AccumulatorPathVisitor)paramObject;
/*  85 */     return (Objects.equals(this.dirList, accumulatorPathVisitor.dirList) && Objects.equals(this.fileList, accumulatorPathVisitor.fileList));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Path> getDirList() {
/*  94 */     return this.dirList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Path> getFileList() {
/* 103 */     return this.fileList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 108 */     byte b = 31;
/* 109 */     int i = super.hashCode();
/* 110 */     i = 31 * i + Objects.hash(new Object[] { this.dirList, this.fileList });
/* 111 */     return i;
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
/*     */   public List<Path> relativizeDirectories(Path paramPath, boolean paramBoolean, Comparator<? super Path> paramComparator) {
/* 124 */     return PathUtils.relativize(getDirList(), paramPath, paramBoolean, paramComparator);
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
/*     */   public List<Path> relativizeFiles(Path paramPath, boolean paramBoolean, Comparator<? super Path> paramComparator) {
/* 137 */     return PathUtils.relativize(getFileList(), paramPath, paramBoolean, paramComparator);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileVisitResult visitFile(Path paramPath, BasicFileAttributes paramBasicFileAttributes) throws IOException {
/* 142 */     (Files.isDirectory(paramPath, new java.nio.file.LinkOption[0]) ? this.dirList : this.fileList).add(paramPath.normalize());
/* 143 */     return super.visitFile(paramPath, paramBasicFileAttributes);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\file\AccumulatorPathVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */