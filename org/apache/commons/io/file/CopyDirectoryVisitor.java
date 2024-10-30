/*     */ package org.apache.commons.io.file;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.CopyOption;
/*     */ import java.nio.file.FileVisitResult;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.attribute.BasicFileAttributes;
/*     */ import java.nio.file.attribute.FileAttribute;
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
/*     */ public class CopyDirectoryVisitor
/*     */   extends CountingPathVisitor
/*     */ {
/*  38 */   private static final CopyOption[] EMPTY_COPY_OPTIONS = new CopyOption[0];
/*     */ 
/*     */ 
/*     */   
/*     */   private final CopyOption[] copyOptions;
/*     */ 
/*     */ 
/*     */   
/*     */   private final Path sourceDirectory;
/*     */ 
/*     */   
/*     */   private final Path targetDirectory;
/*     */ 
/*     */ 
/*     */   
/*     */   public CopyDirectoryVisitor(Counters.PathCounters paramPathCounters, Path paramPath1, Path paramPath2, CopyOption... paramVarArgs) {
/*  54 */     super(paramPathCounters);
/*  55 */     this.sourceDirectory = paramPath1;
/*  56 */     this.targetDirectory = paramPath2;
/*  57 */     this.copyOptions = (paramVarArgs == null) ? EMPTY_COPY_OPTIONS : (CopyOption[])paramVarArgs.clone();
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
/*     */   protected void copy(Path paramPath1, Path paramPath2) throws IOException {
/*  69 */     Files.copy(paramPath1, paramPath2, this.copyOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  74 */     if (this == paramObject) {
/*  75 */       return true;
/*     */     }
/*  77 */     if (!super.equals(paramObject)) {
/*  78 */       return false;
/*     */     }
/*  80 */     if (getClass() != paramObject.getClass()) {
/*  81 */       return false;
/*     */     }
/*  83 */     CopyDirectoryVisitor copyDirectoryVisitor = (CopyDirectoryVisitor)paramObject;
/*  84 */     return (Arrays.equals((Object[])this.copyOptions, (Object[])copyDirectoryVisitor.copyOptions) && Objects.equals(this.sourceDirectory, copyDirectoryVisitor.sourceDirectory) && 
/*  85 */       Objects.equals(this.targetDirectory, copyDirectoryVisitor.targetDirectory));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CopyOption[] getCopyOptions() {
/*  95 */     return (CopyOption[])this.copyOptions.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Path getSourceDirectory() {
/* 105 */     return this.sourceDirectory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Path getTargetDirectory() {
/* 115 */     return this.targetDirectory;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 120 */     byte b = 31;
/* 121 */     int i = super.hashCode();
/* 122 */     i = 31 * i + Arrays.hashCode((Object[])this.copyOptions);
/* 123 */     i = 31 * i + Objects.hash(new Object[] { this.sourceDirectory, this.targetDirectory });
/* 124 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FileVisitResult preVisitDirectory(Path paramPath, BasicFileAttributes paramBasicFileAttributes) throws IOException {
/* 130 */     Path path = this.targetDirectory.resolve(this.sourceDirectory.relativize(paramPath));
/* 131 */     if (Files.notExists(path, new java.nio.file.LinkOption[0])) {
/* 132 */       Files.createDirectory(path, (FileAttribute<?>[])new FileAttribute[0]);
/*     */     }
/* 134 */     return super.preVisitDirectory(paramPath, paramBasicFileAttributes);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileVisitResult visitFile(Path paramPath, BasicFileAttributes paramBasicFileAttributes) throws IOException {
/* 139 */     Path path = this.targetDirectory.resolve(this.sourceDirectory.relativize(paramPath));
/* 140 */     copy(paramPath, path);
/* 141 */     return super.visitFile(path, paramBasicFileAttributes);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\file\CopyDirectoryVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */