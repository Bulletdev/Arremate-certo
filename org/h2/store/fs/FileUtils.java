/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class FileUtils
/*     */ {
/*     */   public static boolean exists(String paramString) {
/*  31 */     return FilePath.get(paramString).exists();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void createDirectory(String paramString) {
/*  42 */     FilePath.get(paramString).createDirectory();
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
/*     */   public static boolean createFile(String paramString) {
/*  54 */     return FilePath.get(paramString).createFile();
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
/*     */   public static void delete(String paramString) {
/*  66 */     FilePath.get(paramString).delete();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toRealPath(String paramString) {
/*  77 */     return FilePath.get(paramString).toRealPath().toString();
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
/*     */   public static String getParent(String paramString) {
/*  89 */     FilePath filePath = FilePath.get(paramString).getParent();
/*  90 */     return (filePath == null) ? null : filePath.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAbsolute(String paramString) {
/* 101 */     return FilePath.get(paramString).isAbsolute();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void move(String paramString1, String paramString2) {
/* 112 */     FilePath.get(paramString1).moveTo(FilePath.get(paramString2), false);
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
/*     */   public static void moveAtomicReplace(String paramString1, String paramString2) {
/* 124 */     FilePath.get(paramString1).moveTo(FilePath.get(paramString2), true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getName(String paramString) {
/* 135 */     return FilePath.get(paramString).getName();
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
/*     */   public static List<String> newDirectoryStream(String paramString) {
/* 147 */     List<FilePath> list = FilePath.get(paramString).newDirectoryStream();
/* 148 */     int i = list.size();
/* 149 */     ArrayList<String> arrayList = New.arrayList(i);
/* 150 */     for (byte b = 0; b < i; b++) {
/* 151 */       arrayList.add(((FilePath)list.get(b)).toString());
/*     */     }
/* 153 */     return arrayList;
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
/*     */   public static long lastModified(String paramString) {
/* 166 */     return FilePath.get(paramString).lastModified();
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
/*     */   public static long size(String paramString) {
/* 179 */     return FilePath.get(paramString).size();
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
/*     */   public static boolean isDirectory(String paramString) {
/* 191 */     return FilePath.get(paramString).isDirectory();
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
/*     */   public static FileChannel open(String paramString1, String paramString2) throws IOException {
/* 205 */     return FilePath.get(paramString1).open(paramString2);
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
/*     */   public static InputStream newInputStream(String paramString) throws IOException {
/* 218 */     return FilePath.get(paramString).newInputStream();
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
/*     */   public static OutputStream newOutputStream(String paramString, boolean paramBoolean) throws IOException {
/* 233 */     return FilePath.get(paramString).newOutputStream(paramBoolean);
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
/*     */   public static boolean canWrite(String paramString) {
/* 245 */     return FilePath.get(paramString).canWrite();
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
/*     */   public static boolean setReadOnly(String paramString) {
/* 257 */     return FilePath.get(paramString).setReadOnly();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String unwrap(String paramString) {
/* 268 */     return FilePath.get(paramString).unwrap().toString();
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
/*     */   public static void deleteRecursive(String paramString, boolean paramBoolean) {
/* 280 */     if (exists(paramString)) {
/* 281 */       if (isDirectory(paramString)) {
/* 282 */         for (String str : newDirectoryStream(paramString)) {
/* 283 */           deleteRecursive(str, paramBoolean);
/*     */         }
/*     */       }
/* 286 */       if (paramBoolean) {
/* 287 */         tryDelete(paramString);
/*     */       } else {
/* 289 */         delete(paramString);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void createDirectories(String paramString) {
/* 300 */     if (paramString != null) {
/* 301 */       if (exists(paramString)) {
/* 302 */         if (!isDirectory(paramString))
/*     */         {
/* 304 */           createDirectory(paramString);
/*     */         }
/*     */       } else {
/* 307 */         String str = getParent(paramString);
/* 308 */         createDirectories(str);
/* 309 */         createDirectory(paramString);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean tryDelete(String paramString) {
/*     */     try {
/* 322 */       FilePath.get(paramString).delete();
/* 323 */       return true;
/* 324 */     } catch (Exception exception) {
/* 325 */       return false;
/*     */     } 
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
/*     */   public static String createTempFile(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
/* 342 */     return FilePath.get(paramString1).createTempFile(paramString2, paramBoolean1, paramBoolean2).toString();
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
/*     */   public static void readFully(FileChannel paramFileChannel, ByteBuffer paramByteBuffer) throws IOException {
/*     */     do {
/* 356 */       int i = paramFileChannel.read(paramByteBuffer);
/* 357 */       if (i < 0) {
/* 358 */         throw new EOFException();
/*     */       }
/* 360 */     } while (paramByteBuffer.remaining() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeFully(FileChannel paramFileChannel, ByteBuffer paramByteBuffer) throws IOException {
/*     */     do {
/* 372 */       paramFileChannel.write(paramByteBuffer);
/* 373 */     } while (paramByteBuffer.remaining() > 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */