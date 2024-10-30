/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.h2.util.MathUtils;
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
/*     */ public abstract class FilePath
/*     */ {
/*     */   private static FilePath defaultProvider;
/*     */   private static Map<String, FilePath> providers;
/*     */   private static String tempRandom;
/*     */   private static long tempSequence;
/*     */   protected String name;
/*     */   
/*     */   public static FilePath get(String paramString) {
/*  50 */     paramString = paramString.replace('\\', '/');
/*  51 */     int i = paramString.indexOf(':');
/*  52 */     registerDefaultProviders();
/*  53 */     if (i < 2)
/*     */     {
/*     */       
/*  56 */       return defaultProvider.getPath(paramString);
/*     */     }
/*  58 */     String str = paramString.substring(0, i);
/*  59 */     FilePath filePath = providers.get(str);
/*  60 */     if (filePath == null)
/*     */     {
/*  62 */       filePath = defaultProvider;
/*     */     }
/*  64 */     return filePath.getPath(paramString);
/*     */   }
/*     */   
/*     */   private static void registerDefaultProviders() {
/*  68 */     if (providers == null || defaultProvider == null) {
/*  69 */       Map<?, ?> map = Collections.synchronizedMap(New.hashMap());
/*     */       
/*  71 */       for (String str : new String[] { "org.h2.store.fs.FilePathDisk", "org.h2.store.fs.FilePathMem", "org.h2.store.fs.FilePathMemLZF", "org.h2.store.fs.FilePathNioMem", "org.h2.store.fs.FilePathNioMemLZF", "org.h2.store.fs.FilePathSplit", "org.h2.store.fs.FilePathNio", "org.h2.store.fs.FilePathNioMapped", "org.h2.store.fs.FilePathZip", "org.h2.store.fs.FilePathRetryOnInterrupt" }) {
/*     */ 
/*     */         
/*     */         try {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  84 */           FilePath filePath = (FilePath)Class.forName(str).newInstance();
/*  85 */           map.put(filePath.getScheme(), filePath);
/*  86 */           if (defaultProvider == null) {
/*  87 */             defaultProvider = filePath;
/*     */           }
/*  89 */         } catch (Exception exception) {}
/*     */       } 
/*     */ 
/*     */       
/*  93 */       providers = (Map)map;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void register(FilePath paramFilePath) {
/* 103 */     registerDefaultProviders();
/* 104 */     providers.put(paramFilePath.getScheme(), paramFilePath);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unregister(FilePath paramFilePath) {
/* 113 */     registerDefaultProviders();
/* 114 */     providers.remove(paramFilePath.getScheme());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract long size();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void moveTo(FilePath paramFilePath, boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean createFile();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean exists();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void delete();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract List<FilePath> newDirectoryStream();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract FilePath toRealPath();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract FilePath getParent();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isDirectory();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isAbsolute();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract long lastModified();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean canWrite();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void createDirectory();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 213 */     int i = Math.max(this.name.indexOf(':'), this.name.lastIndexOf('/'));
/* 214 */     return (i < 0) ? this.name : this.name.substring(i + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract OutputStream newOutputStream(boolean paramBoolean) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract FileChannel open(String paramString) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract InputStream newInputStream() throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean setReadOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilePath createTempFile(String paramString, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
/*     */     FilePath filePath;
/*     */     while (true) {
/* 260 */       filePath = getPath(this.name + getNextTempFileNamePart(false) + paramString);
/* 261 */       if (filePath.exists() || !filePath.createFile()) {
/*     */         
/* 263 */         getNextTempFileNamePart(true); continue;
/*     */       }  break;
/*     */     } 
/* 266 */     filePath.open("rw").close();
/* 267 */     return filePath;
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
/*     */   protected static synchronized String getNextTempFileNamePart(boolean paramBoolean) {
/* 279 */     if (paramBoolean || tempRandom == null) {
/* 280 */       tempRandom = MathUtils.randomInt(2147483647) + ".";
/*     */     }
/* 282 */     return tempRandom + tempSequence++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 293 */     return this.name;
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
/*     */   public abstract String getScheme();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract FilePath getPath(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilePath unwrap() {
/* 323 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FilePath.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */