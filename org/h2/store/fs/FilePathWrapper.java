/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FilePathWrapper
/*     */   extends FilePath
/*     */ {
/*     */   private FilePath base;
/*     */   
/*     */   public FilePathWrapper getPath(String paramString) {
/*  24 */     return create(paramString, unwrap(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilePathWrapper wrap(FilePath paramFilePath) {
/*  34 */     return (paramFilePath == null) ? null : create(getPrefix() + paramFilePath.name, paramFilePath);
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePath unwrap() {
/*  39 */     return unwrap(this.name);
/*     */   }
/*     */   
/*     */   private FilePathWrapper create(String paramString, FilePath paramFilePath) {
/*     */     try {
/*  44 */       FilePathWrapper filePathWrapper = (FilePathWrapper)getClass().newInstance();
/*  45 */       filePathWrapper.name = paramString;
/*  46 */       filePathWrapper.base = paramFilePath;
/*  47 */       return filePathWrapper;
/*  48 */     } catch (Exception exception) {
/*  49 */       throw new IllegalArgumentException("Path: " + paramString, exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected String getPrefix() {
/*  54 */     return getScheme() + ":";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FilePath unwrap(String paramString) {
/*  64 */     return FilePath.get(paramString.substring(getScheme().length() + 1));
/*     */   }
/*     */   
/*     */   protected FilePath getBase() {
/*  68 */     return this.base;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canWrite() {
/*  73 */     return this.base.canWrite();
/*     */   }
/*     */ 
/*     */   
/*     */   public void createDirectory() {
/*  78 */     this.base.createDirectory();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean createFile() {
/*  83 */     return this.base.createFile();
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete() {
/*  88 */     this.base.delete();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean exists() {
/*  93 */     return this.base.exists();
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePath getParent() {
/*  98 */     return wrap(this.base.getParent());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAbsolute() {
/* 103 */     return this.base.isAbsolute();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDirectory() {
/* 108 */     return this.base.isDirectory();
/*     */   }
/*     */ 
/*     */   
/*     */   public long lastModified() {
/* 113 */     return this.base.lastModified();
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePath toRealPath() {
/* 118 */     return wrap(this.base.toRealPath());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<FilePath> newDirectoryStream() {
/* 123 */     List<FilePath> list = this.base.newDirectoryStream(); byte b; int i;
/* 124 */     for (b = 0, i = list.size(); b < i; b++) {
/* 125 */       list.set(b, wrap(list.get(b)));
/*     */     }
/* 127 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveTo(FilePath paramFilePath, boolean paramBoolean) {
/* 132 */     this.base.moveTo(((FilePathWrapper)paramFilePath).base, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream newInputStream() throws IOException {
/* 137 */     return this.base.newInputStream();
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputStream newOutputStream(boolean paramBoolean) throws IOException {
/* 142 */     return this.base.newOutputStream(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel open(String paramString) throws IOException {
/* 147 */     return this.base.open(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setReadOnly() {
/* 152 */     return this.base.setReadOnly();
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() {
/* 157 */     return this.base.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FilePath createTempFile(String paramString, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
/* 163 */     return wrap(this.base.createTempFile(paramString, paramBoolean1, paramBoolean2));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FilePathWrapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */