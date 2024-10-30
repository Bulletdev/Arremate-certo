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
/*     */ public class FilePathNioMem
/*     */   extends FilePath
/*     */ {
/*  33 */   private static final TreeMap<String, FileNioMemData> MEMORY_FILES = new TreeMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public FilePathNioMem getPath(String paramString) {
/*  38 */     FilePathNioMem filePathNioMem = new FilePathNioMem();
/*  39 */     filePathNioMem.name = getCanonicalPath(paramString);
/*  40 */     return filePathNioMem;
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() {
/*  45 */     return getMemoryFile().length();
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveTo(FilePath paramFilePath, boolean paramBoolean) {
/*  50 */     synchronized (MEMORY_FILES) {
/*  51 */       if (!paramBoolean && !this.name.equals(paramFilePath.name) && MEMORY_FILES.containsKey(paramFilePath.name))
/*     */       {
/*  53 */         throw DbException.get(90024, new String[] { this.name, paramFilePath + " (exists)" });
/*     */       }
/*     */       
/*  56 */       FileNioMemData fileNioMemData = getMemoryFile();
/*  57 */       fileNioMemData.setName(paramFilePath.name);
/*  58 */       MEMORY_FILES.remove(this.name);
/*  59 */       MEMORY_FILES.put(paramFilePath.name, fileNioMemData);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean createFile() {
/*  65 */     synchronized (MEMORY_FILES) {
/*  66 */       if (exists()) {
/*  67 */         return false;
/*     */       }
/*  69 */       getMemoryFile();
/*     */     } 
/*  71 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean exists() {
/*  76 */     if (isRoot()) {
/*  77 */       return true;
/*     */     }
/*  79 */     synchronized (MEMORY_FILES) {
/*  80 */       return (MEMORY_FILES.get(this.name) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete() {
/*  86 */     if (isRoot()) {
/*     */       return;
/*     */     }
/*  89 */     synchronized (MEMORY_FILES) {
/*  90 */       MEMORY_FILES.remove(this.name);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<FilePath> newDirectoryStream() {
/*  96 */     ArrayList<FilePathNioMem> arrayList = New.arrayList();
/*  97 */     synchronized (MEMORY_FILES) {
/*  98 */       for (String str : MEMORY_FILES.tailMap(this.name).keySet()) {
/*  99 */         if (str.startsWith(this.name)) {
/* 100 */           arrayList.add(getPath(str));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 105 */       return (List)arrayList;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setReadOnly() {
/* 111 */     return getMemoryFile().setReadOnly();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canWrite() {
/* 116 */     return getMemoryFile().canWrite();
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePathNioMem getParent() {
/* 121 */     int i = this.name.lastIndexOf('/');
/* 122 */     return (i < 0) ? null : getPath(this.name.substring(0, i));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDirectory() {
/* 127 */     if (isRoot()) {
/* 128 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 132 */     synchronized (MEMORY_FILES) {
/* 133 */       return (MEMORY_FILES.get(this.name) == null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAbsolute() {
/* 140 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePathNioMem toRealPath() {
/* 145 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public long lastModified() {
/* 150 */     return getMemoryFile().getLastModified();
/*     */   }
/*     */ 
/*     */   
/*     */   public void createDirectory() {
/* 155 */     if (exists() && isDirectory()) {
/* 156 */       throw DbException.get(90062, this.name + " (a file with this name already exists)");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OutputStream newOutputStream(boolean paramBoolean) throws IOException {
/* 164 */     FileNioMemData fileNioMemData = getMemoryFile();
/* 165 */     FileNioMem fileNioMem = new FileNioMem(fileNioMemData, false);
/* 166 */     return new FileChannelOutputStream(fileNioMem, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream newInputStream() {
/* 171 */     FileNioMemData fileNioMemData = getMemoryFile();
/* 172 */     FileNioMem fileNioMem = new FileNioMem(fileNioMemData, true);
/* 173 */     return new FileChannelInputStream(fileNioMem, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel open(String paramString) {
/* 178 */     FileNioMemData fileNioMemData = getMemoryFile();
/* 179 */     return new FileNioMem(fileNioMemData, "r".equals(paramString));
/*     */   }
/*     */   
/*     */   private FileNioMemData getMemoryFile() {
/* 183 */     synchronized (MEMORY_FILES) {
/* 184 */       FileNioMemData fileNioMemData = MEMORY_FILES.get(this.name);
/* 185 */       if (fileNioMemData == null) {
/* 186 */         fileNioMemData = new FileNioMemData(this.name, compressed());
/* 187 */         MEMORY_FILES.put(this.name, fileNioMemData);
/*     */       } 
/* 189 */       return fileNioMemData;
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isRoot() {
/* 194 */     return this.name.equals(getScheme() + ":");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String getCanonicalPath(String paramString) {
/* 205 */     paramString = paramString.replace('\\', '/');
/* 206 */     int i = paramString.indexOf(':') + 1;
/* 207 */     if (paramString.length() > i && paramString.charAt(i) != '/') {
/* 208 */       paramString = paramString.substring(0, i) + "/" + paramString.substring(i);
/*     */     }
/* 210 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getScheme() {
/* 215 */     return "nioMemFS";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean compressed() {
/* 224 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FilePathNioMem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */