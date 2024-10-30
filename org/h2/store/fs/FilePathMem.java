/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.TreeMap;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.New;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FilePathMem
/*     */   extends FilePath
/*     */ {
/*  33 */   private static final TreeMap<String, FileMemData> MEMORY_FILES = new TreeMap<>();
/*     */   
/*  35 */   private static final FileMemData DIRECTORY = new FileMemData("", false);
/*     */ 
/*     */   
/*     */   public FilePathMem getPath(String paramString) {
/*  39 */     FilePathMem filePathMem = new FilePathMem();
/*  40 */     filePathMem.name = getCanonicalPath(paramString);
/*  41 */     return filePathMem;
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() {
/*  46 */     return getMemoryFile().length();
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveTo(FilePath paramFilePath, boolean paramBoolean) {
/*  51 */     synchronized (MEMORY_FILES) {
/*  52 */       if (!paramBoolean && !paramFilePath.name.equals(this.name) && MEMORY_FILES.containsKey(paramFilePath.name))
/*     */       {
/*  54 */         throw DbException.get(90024, new String[] { this.name, paramFilePath + " (exists)" });
/*     */       }
/*     */       
/*  57 */       FileMemData fileMemData = getMemoryFile();
/*  58 */       fileMemData.setName(paramFilePath.name);
/*  59 */       MEMORY_FILES.remove(this.name);
/*  60 */       MEMORY_FILES.put(paramFilePath.name, fileMemData);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean createFile() {
/*  66 */     synchronized (MEMORY_FILES) {
/*  67 */       if (exists()) {
/*  68 */         return false;
/*     */       }
/*  70 */       getMemoryFile();
/*     */     } 
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean exists() {
/*  77 */     if (isRoot()) {
/*  78 */       return true;
/*     */     }
/*  80 */     synchronized (MEMORY_FILES) {
/*  81 */       return (MEMORY_FILES.get(this.name) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete() {
/*  87 */     if (isRoot()) {
/*     */       return;
/*     */     }
/*  90 */     synchronized (MEMORY_FILES) {
/*  91 */       FileMemData fileMemData = MEMORY_FILES.remove(this.name);
/*  92 */       if (fileMemData != null) {
/*  93 */         fileMemData.truncate(0L);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<FilePath> newDirectoryStream() {
/* 100 */     ArrayList<FilePathMem> arrayList = New.arrayList();
/* 101 */     synchronized (MEMORY_FILES) {
/* 102 */       for (String str : MEMORY_FILES.tailMap(this.name).keySet()) {
/* 103 */         if (str.startsWith(this.name)) {
/* 104 */           if (!str.equals(this.name) && str.indexOf('/', this.name.length() + 1) < 0) {
/* 105 */             arrayList.add(getPath(str));
/*     */           }
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 111 */       return (List)arrayList;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setReadOnly() {
/* 117 */     return getMemoryFile().setReadOnly();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canWrite() {
/* 122 */     return getMemoryFile().canWrite();
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePathMem getParent() {
/* 127 */     int i = this.name.lastIndexOf('/');
/* 128 */     return (i < 0) ? null : getPath(this.name.substring(0, i));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDirectory() {
/* 133 */     if (isRoot()) {
/* 134 */       return true;
/*     */     }
/* 136 */     synchronized (MEMORY_FILES) {
/* 137 */       FileMemData fileMemData = MEMORY_FILES.get(this.name);
/* 138 */       return (fileMemData == DIRECTORY);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAbsolute() {
/* 145 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePathMem toRealPath() {
/* 150 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public long lastModified() {
/* 155 */     return getMemoryFile().getLastModified();
/*     */   }
/*     */ 
/*     */   
/*     */   public void createDirectory() {
/* 160 */     if (exists()) {
/* 161 */       throw DbException.get(90062, this.name + " (a file with this name already exists)");
/*     */     }
/*     */     
/* 164 */     synchronized (MEMORY_FILES) {
/* 165 */       MEMORY_FILES.put(this.name, DIRECTORY);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputStream newOutputStream(boolean paramBoolean) throws IOException {
/* 171 */     FileMemData fileMemData = getMemoryFile();
/* 172 */     FileMem fileMem = new FileMem(fileMemData, false);
/* 173 */     return new FileChannelOutputStream(fileMem, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream newInputStream() {
/* 178 */     FileMemData fileMemData = getMemoryFile();
/* 179 */     FileMem fileMem = new FileMem(fileMemData, true);
/* 180 */     return new FileChannelInputStream(fileMem, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel open(String paramString) {
/* 185 */     FileMemData fileMemData = getMemoryFile();
/* 186 */     return new FileMem(fileMemData, "r".equals(paramString));
/*     */   }
/*     */   
/*     */   private FileMemData getMemoryFile() {
/* 190 */     synchronized (MEMORY_FILES) {
/* 191 */       FileMemData fileMemData = MEMORY_FILES.get(this.name);
/* 192 */       if (fileMemData == DIRECTORY) {
/* 193 */         throw DbException.get(90062, this.name + " (a directory with this name already exists)");
/*     */       }
/*     */       
/* 196 */       if (fileMemData == null) {
/* 197 */         fileMemData = new FileMemData(this.name, compressed());
/* 198 */         MEMORY_FILES.put(this.name, fileMemData);
/*     */       } 
/* 200 */       return fileMemData;
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isRoot() {
/* 205 */     return this.name.equals(getScheme() + ":");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String getCanonicalPath(String paramString) {
/* 215 */     paramString = paramString.replace('\\', '/');
/* 216 */     int i = paramString.indexOf(':') + 1;
/* 217 */     if (paramString.length() > i && paramString.charAt(i) != '/') {
/* 218 */       paramString = paramString.substring(0, i) + "/" + paramString.substring(i);
/*     */     }
/* 220 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getScheme() {
/* 225 */     return "memFS";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean compressed() {
/* 234 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FilePathMem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */