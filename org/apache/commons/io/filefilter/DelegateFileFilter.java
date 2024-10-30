/*     */ package org.apache.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FilenameFilter;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DelegateFileFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -8723373124984771318L;
/*     */   private final FilenameFilter filenameFilter;
/*     */   private final FileFilter fileFilter;
/*     */   
/*     */   public DelegateFileFilter(FilenameFilter paramFilenameFilter) {
/*  47 */     if (paramFilenameFilter == null) {
/*  48 */       throw new IllegalArgumentException("The FilenameFilter must not be null");
/*     */     }
/*  50 */     this.filenameFilter = paramFilenameFilter;
/*  51 */     this.fileFilter = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DelegateFileFilter(FileFilter paramFileFilter) {
/*  60 */     if (paramFileFilter == null) {
/*  61 */       throw new IllegalArgumentException("The FileFilter must not be null");
/*     */     }
/*  63 */     this.fileFilter = paramFileFilter;
/*  64 */     this.filenameFilter = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accept(File paramFile) {
/*  75 */     if (this.fileFilter != null) {
/*  76 */       return this.fileFilter.accept(paramFile);
/*     */     }
/*  78 */     return super.accept(paramFile);
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
/*     */   public boolean accept(File paramFile, String paramString) {
/*  90 */     if (this.filenameFilter != null) {
/*  91 */       return this.filenameFilter.accept(paramFile, paramString);
/*     */     }
/*  93 */     return super.accept(paramFile, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 103 */     String str = (this.fileFilter != null) ? this.fileFilter.toString() : this.filenameFilter.toString();
/* 104 */     return super.toString() + "(" + str + ")";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\filefilter\DelegateFileFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */