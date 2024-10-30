/*     */ package org.apache.commons.io.monitor;
/*     */ 
/*     */ import java.io.File;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileEntry
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2505664948818681153L;
/*  47 */   static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
/*     */   
/*     */   private final FileEntry parent;
/*     */   
/*     */   private FileEntry[] children;
/*     */   
/*     */   private final File file;
/*     */   
/*     */   private String name;
/*     */   
/*     */   private boolean exists;
/*     */   
/*     */   private boolean directory;
/*     */   private long lastModified;
/*     */   private long length;
/*     */   
/*     */   public FileEntry(File paramFile) {
/*  64 */     this(null, paramFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileEntry(FileEntry paramFileEntry, File paramFile) {
/*  74 */     if (paramFile == null) {
/*  75 */       throw new IllegalArgumentException("File is missing");
/*     */     }
/*  77 */     this.file = paramFile;
/*  78 */     this.parent = paramFileEntry;
/*  79 */     this.name = paramFile.getName();
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
/*     */   public boolean refresh(File paramFile) {
/*  99 */     boolean bool1 = this.exists;
/* 100 */     long l1 = this.lastModified;
/* 101 */     boolean bool2 = this.directory;
/* 102 */     long l2 = this.length;
/*     */ 
/*     */     
/* 105 */     this.name = paramFile.getName();
/* 106 */     this.exists = paramFile.exists();
/* 107 */     this.directory = (this.exists && paramFile.isDirectory());
/* 108 */     this.lastModified = this.exists ? paramFile.lastModified() : 0L;
/* 109 */     this.length = (this.exists && !this.directory) ? paramFile.length() : 0L;
/*     */ 
/*     */     
/* 112 */     return (this.exists != bool1 || this.lastModified != l1 || this.directory != bool2 || this.length != l2);
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
/*     */   public FileEntry newChildInstance(File paramFile) {
/* 128 */     return new FileEntry(this, paramFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileEntry getParent() {
/* 137 */     return this.parent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLevel() {
/* 146 */     return (this.parent == null) ? 0 : (this.parent.getLevel() + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileEntry[] getChildren() {
/* 157 */     return (this.children != null) ? this.children : EMPTY_ENTRIES;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChildren(FileEntry... paramVarArgs) {
/* 166 */     this.children = paramVarArgs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getFile() {
/* 175 */     return this.file;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 184 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 193 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLastModified() {
/* 203 */     return this.lastModified;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastModified(long paramLong) {
/* 213 */     this.lastModified = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLength() {
/* 222 */     return this.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLength(long paramLong) {
/* 231 */     this.length = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isExists() {
/* 241 */     return this.exists;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExists(boolean paramBoolean) {
/* 251 */     this.exists = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDirectory() {
/* 260 */     return this.directory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDirectory(boolean paramBoolean) {
/* 269 */     this.directory = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\monitor\FileEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */