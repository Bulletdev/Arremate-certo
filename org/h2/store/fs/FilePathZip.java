/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
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
/*     */ public class FilePathZip
/*     */   extends FilePath
/*     */ {
/*     */   public FilePathZip getPath(String paramString) {
/*  31 */     FilePathZip filePathZip = new FilePathZip();
/*  32 */     filePathZip.name = paramString;
/*  33 */     return filePathZip;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void createDirectory() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean createFile() {
/*  43 */     throw DbException.getUnsupportedException("write");
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete() {
/*  48 */     throw DbException.getUnsupportedException("write");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean exists() {
/*     */     try {
/*  54 */       String str = getEntryName();
/*  55 */       if (str.length() == 0) {
/*  56 */         return true;
/*     */       }
/*  58 */       try (ZipFile null = openZipFile()) {
/*  59 */         return (zipFile.getEntry(str) != null);
/*     */       } 
/*  61 */     } catch (IOException iOException) {
/*  62 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long lastModified() {
/*  68 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePath getParent() {
/*  73 */     int i = this.name.lastIndexOf('/');
/*  74 */     return (i < 0) ? null : getPath(this.name.substring(0, i));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAbsolute() {
/*  79 */     String str = translateFileName(this.name);
/*  80 */     return FilePath.get(str).isAbsolute();
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePath unwrap() {
/*  85 */     return FilePath.get(this.name.substring(getScheme().length() + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDirectory() {
/*     */     try {
/*  91 */       String str = getEntryName();
/*  92 */       if (str.length() == 0) {
/*  93 */         return true;
/*     */       }
/*  95 */       try (ZipFile null = openZipFile()) {
/*  96 */         Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
/*  97 */         while (enumeration.hasMoreElements()) {
/*  98 */           ZipEntry zipEntry = enumeration.nextElement();
/*  99 */           String str1 = zipEntry.getName();
/* 100 */           if (str1.equals(str))
/* 101 */             return zipEntry.isDirectory(); 
/* 102 */           if (str1.startsWith(str) && 
/* 103 */             str1.length() == str.length() + 1 && 
/* 104 */             str1.equals(str + "/")) {
/* 105 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 111 */       return false;
/* 112 */     } catch (IOException iOException) {
/* 113 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canWrite() {
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setReadOnly() {
/* 124 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long size() {
/* 130 */     try (ZipFile null = openZipFile()) {
/* 131 */       ZipEntry zipEntry = zipFile.getEntry(getEntryName());
/* 132 */       return (zipEntry == null) ? 0L : zipEntry.getSize();
/*     */     }
/* 134 */     catch (IOException iOException) {
/* 135 */       return 0L;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<FilePath> newDirectoryStream() {
/* 141 */     String str = this.name;
/* 142 */     ArrayList<FilePathZip> arrayList = New.arrayList();
/*     */     try {
/* 144 */       if (str.indexOf('!') < 0) {
/* 145 */         str = str + "!";
/*     */       }
/* 147 */       if (!str.endsWith("/")) {
/* 148 */         str = str + "/";
/*     */       }
/* 150 */       try (ZipFile null = openZipFile()) {
/* 151 */         String str1 = getEntryName();
/* 152 */         String str2 = str.substring(0, str.length() - str1.length());
/* 153 */         Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
/* 154 */         while (enumeration.hasMoreElements()) {
/* 155 */           ZipEntry zipEntry = enumeration.nextElement();
/* 156 */           String str3 = zipEntry.getName();
/* 157 */           if (!str3.startsWith(str1)) {
/*     */             continue;
/*     */           }
/* 160 */           if (str3.length() <= str1.length()) {
/*     */             continue;
/*     */           }
/* 163 */           int i = str3.indexOf('/', str1.length());
/* 164 */           if (i < 0 || i >= str3.length() - 1) {
/* 165 */             arrayList.add(getPath(str2 + str3));
/*     */           }
/*     */         } 
/*     */       } 
/* 169 */       return (ArrayList)arrayList;
/* 170 */     } catch (IOException iOException) {
/* 171 */       throw DbException.convertIOException(iOException, "listFiles " + str);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream newInputStream() throws IOException {
/* 177 */     return new FileChannelInputStream(open("r"), true);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel open(String paramString) throws IOException {
/* 182 */     ZipFile zipFile = openZipFile();
/* 183 */     ZipEntry zipEntry = zipFile.getEntry(getEntryName());
/* 184 */     if (zipEntry == null) {
/* 185 */       zipFile.close();
/* 186 */       throw new FileNotFoundException(this.name);
/*     */     } 
/* 188 */     return new FileZip(zipFile, zipEntry);
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputStream newOutputStream(boolean paramBoolean) throws IOException {
/* 193 */     throw new IOException("write");
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveTo(FilePath paramFilePath, boolean paramBoolean) {
/* 198 */     throw DbException.getUnsupportedException("write");
/*     */   }
/*     */   
/*     */   private static String translateFileName(String paramString) {
/* 202 */     if (paramString.startsWith("zip:")) {
/* 203 */       paramString = paramString.substring("zip:".length());
/*     */     }
/* 205 */     int i = paramString.indexOf('!');
/* 206 */     if (i >= 0) {
/* 207 */       paramString = paramString.substring(0, i);
/*     */     }
/* 209 */     return FilePathDisk.expandUserHomeDirectory(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePath toRealPath() {
/* 214 */     return this;
/*     */   }
/*     */   
/*     */   private String getEntryName() {
/* 218 */     int i = this.name.indexOf('!');
/*     */     
/* 220 */     if (i <= 0) {
/* 221 */       str = "";
/*     */     } else {
/* 223 */       str = this.name.substring(i + 1);
/*     */     } 
/* 225 */     String str = str.replace('\\', '/');
/* 226 */     if (str.startsWith("/")) {
/* 227 */       str = str.substring(1);
/*     */     }
/* 229 */     return str;
/*     */   }
/*     */   
/*     */   private ZipFile openZipFile() throws IOException {
/* 233 */     String str = translateFileName(this.name);
/* 234 */     return new ZipFile(str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FilePath createTempFile(String paramString, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
/* 240 */     if (!paramBoolean2) {
/* 241 */       throw new IOException("File system is read-only");
/*     */     }
/* 243 */     return (new FilePathDisk()).getPath(this.name).createTempFile(paramString, paramBoolean1, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getScheme() {
/* 249 */     return "zip";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FilePathZip.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */