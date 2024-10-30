/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarInputStream;
/*     */ import java.util.jar.JarOutputStream;
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
/*     */ public class JarHelper
/*     */ {
/*     */   private static final int BUFFER_SIZE = 2156;
/*  40 */   private byte[] mBuffer = new byte[2156];
/*  41 */   private int mByteCount = 0;
/*     */   private boolean mVerbose = false;
/*  43 */   private String mDestJarName = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final char SEP = '/';
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void jarDir(File paramFile1, File paramFile2) throws IOException {
/*  62 */     if (paramFile1 == null || paramFile2 == null) {
/*  63 */       throw new IllegalArgumentException();
/*     */     }
/*  65 */     this.mDestJarName = paramFile2.getCanonicalPath();
/*  66 */     FileOutputStream fileOutputStream = new FileOutputStream(paramFile2);
/*  67 */     JarOutputStream jarOutputStream = new JarOutputStream(fileOutputStream);
/*     */     
/*     */     try {
/*  70 */       jarDir(paramFile1, jarOutputStream, null);
/*  71 */     } catch (IOException iOException) {
/*  72 */       throw iOException;
/*     */     } finally {
/*  74 */       jarOutputStream.close();
/*  75 */       fileOutputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unjarDir(File paramFile1, File paramFile2) throws IOException {
/*  83 */     Object object = null;
/*  84 */     FileInputStream fileInputStream = new FileInputStream(paramFile1);
/*  85 */     unjar(fileInputStream, paramFile2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unjar(InputStream paramInputStream, File paramFile) throws IOException {
/*  93 */     BufferedOutputStream bufferedOutputStream = null;
/*  94 */     JarInputStream jarInputStream = new JarInputStream(paramInputStream);
/*     */     JarEntry jarEntry;
/*  96 */     while ((jarEntry = jarInputStream.getNextJarEntry()) != null) {
/*  97 */       if (jarEntry.isDirectory()) {
/*  98 */         File file1 = new File(paramFile, jarEntry.getName());
/*  99 */         file1.mkdir();
/* 100 */         if (jarEntry.getTime() != -1L) file1.setLastModified(jarEntry.getTime());
/*     */         
/*     */         continue;
/*     */       } 
/* 104 */       byte[] arrayOfByte = new byte[2156];
/* 105 */       File file = new File(paramFile, jarEntry.getName());
/* 106 */       if (this.mVerbose) {
/* 107 */         System.out.println("unjarring " + file + " from " + jarEntry.getName());
/*     */       }
/* 109 */       FileOutputStream fileOutputStream = new FileOutputStream(file);
/* 110 */       bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 2156); int i;
/* 111 */       while ((i = jarInputStream.read(arrayOfByte, 0, 2156)) != -1) {
/* 112 */         bufferedOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/* 114 */       bufferedOutputStream.flush();
/* 115 */       bufferedOutputStream.close();
/* 116 */       if (jarEntry.getTime() != -1L) file.setLastModified(jarEntry.getTime()); 
/*     */     } 
/* 118 */     jarInputStream.close();
/*     */   }
/*     */   
/*     */   public void setVerbose(boolean paramBoolean) {
/* 122 */     this.mVerbose = paramBoolean;
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
/*     */   private void jarDir(File paramFile, JarOutputStream paramJarOutputStream, String paramString) throws IOException {
/* 134 */     if (this.mVerbose) System.out.println("checking " + paramFile); 
/* 135 */     if (paramFile.isDirectory()) {
/* 136 */       String[] arrayOfString = paramFile.list();
/* 137 */       String str = (paramString == null) ? "" : (paramString + paramFile.getName() + '/');
/* 138 */       if (paramString != null) {
/* 139 */         JarEntry jarEntry = new JarEntry(str);
/* 140 */         jarEntry.setTime(paramFile.lastModified());
/* 141 */         paramJarOutputStream.putNextEntry(jarEntry);
/* 142 */         paramJarOutputStream.flush();
/* 143 */         paramJarOutputStream.closeEntry();
/*     */       } 
/* 145 */       for (byte b = 0; b < arrayOfString.length; b++) {
/* 146 */         File file = new File(paramFile, arrayOfString[b]);
/* 147 */         jarDir(file, paramJarOutputStream, str);
/*     */       } 
/*     */     } else {
/* 150 */       if (paramFile.getCanonicalPath().equals(this.mDestJarName)) {
/*     */         
/* 152 */         if (this.mVerbose) System.out.println("skipping " + paramFile.getPath());
/*     */         
/*     */         return;
/*     */       } 
/* 156 */       if (this.mVerbose) System.out.println("adding " + paramFile.getPath()); 
/* 157 */       FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */       try {
/* 159 */         JarEntry jarEntry = new JarEntry(paramString + paramFile.getName());
/* 160 */         jarEntry.setTime(paramFile.lastModified());
/* 161 */         paramJarOutputStream.putNextEntry(jarEntry);
/* 162 */         while ((this.mByteCount = fileInputStream.read(this.mBuffer)) != -1) {
/* 163 */           paramJarOutputStream.write(this.mBuffer, 0, this.mByteCount);
/* 164 */           if (this.mVerbose) System.out.println("wrote " + this.mByteCount + " bytes"); 
/*     */         } 
/* 166 */         paramJarOutputStream.flush();
/* 167 */         paramJarOutputStream.closeEntry();
/* 168 */       } catch (IOException iOException) {
/* 169 */         throw iOException;
/*     */       } finally {
/* 171 */         fileInputStream.close();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/* 180 */     if (paramArrayOfString.length < 2) {
/*     */       
/* 182 */       System.err.println("Usage: JarHelper jarname.jar directory");
/*     */       
/*     */       return;
/*     */     } 
/* 186 */     JarHelper jarHelper = new JarHelper();
/* 187 */     jarHelper.mVerbose = true;
/*     */     
/* 189 */     File file1 = new File(paramArrayOfString[0]);
/* 190 */     File file2 = new File(paramArrayOfString[1]);
/*     */     
/* 192 */     jarHelper.jarDir(file2, file1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\JarHelper.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */