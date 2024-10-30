/*     */ package org.apache.commons.io.file;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.FileVisitResult;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.attribute.BasicFileAttributes;
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
/*     */ public class CountingPathVisitor
/*     */   extends SimplePathVisitor
/*     */ {
/*  36 */   static final String[] EMPTY_STRING_ARRAY = new String[0];
/*     */ 
/*     */   
/*     */   private final Counters.PathCounters pathCounters;
/*     */ 
/*     */ 
/*     */   
/*     */   public static CountingPathVisitor withBigIntegerCounters() {
/*  44 */     return new CountingPathVisitor(Counters.bigIntegerPathCounters());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CountingPathVisitor withLongCounters() {
/*  53 */     return new CountingPathVisitor(Counters.longPathCounters());
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
/*     */   public CountingPathVisitor(Counters.PathCounters paramPathCounters) {
/*  65 */     this.pathCounters = Objects.<Counters.PathCounters>requireNonNull(paramPathCounters, "pathCounter");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  70 */     if (this == paramObject) {
/*  71 */       return true;
/*     */     }
/*  73 */     if (!(paramObject instanceof CountingPathVisitor)) {
/*  74 */       return false;
/*     */     }
/*  76 */     CountingPathVisitor countingPathVisitor = (CountingPathVisitor)paramObject;
/*  77 */     return Objects.equals(this.pathCounters, countingPathVisitor.pathCounters);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Counters.PathCounters getPathCounters() {
/*  86 */     return this.pathCounters;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  91 */     return Objects.hash(new Object[] { this.pathCounters });
/*     */   }
/*     */ 
/*     */   
/*     */   public FileVisitResult postVisitDirectory(Path paramPath, IOException paramIOException) throws IOException {
/*  96 */     this.pathCounters.getDirectoryCounter().increment();
/*  97 */     return FileVisitResult.CONTINUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 102 */     return this.pathCounters.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFileCounters(Path paramPath, BasicFileAttributes paramBasicFileAttributes) {
/* 112 */     this.pathCounters.getFileCounter().increment();
/* 113 */     this.pathCounters.getByteCounter().add(paramBasicFileAttributes.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public FileVisitResult visitFile(Path paramPath, BasicFileAttributes paramBasicFileAttributes) throws IOException {
/* 118 */     if (Files.exists(paramPath, new java.nio.file.LinkOption[0])) {
/* 119 */       updateFileCounters(paramPath, paramBasicFileAttributes);
/*     */     }
/* 121 */     return FileVisitResult.CONTINUE;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\file\CountingPathVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */