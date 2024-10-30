/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.net.URI;
/*     */ import java.nio.channels.FileChannel;
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
/*     */ public class IOUtil
/*     */ {
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public static void copyCompletely(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/*  37 */     if (paramOutputStream instanceof FileOutputStream && paramInputStream instanceof FileInputStream) {
/*     */       
/*     */       try {
/*     */         
/*  41 */         FileChannel fileChannel1 = ((FileOutputStream)paramOutputStream).getChannel();
/*  42 */         FileChannel fileChannel2 = ((FileInputStream)paramInputStream).getChannel();
/*     */         
/*  44 */         fileChannel2.transferTo(0L, 2147483647L, fileChannel1);
/*     */         
/*  46 */         fileChannel2.close();
/*  47 */         fileChannel1.close();
/*     */ 
/*     */         
/*     */         return;
/*  51 */       } catch (Exception exception) {}
/*     */     }
/*     */ 
/*     */     
/*  55 */     byte[] arrayOfByte = new byte[8192];
/*     */     
/*     */     while (true) {
/*  58 */       int i = paramInputStream.read(arrayOfByte);
/*  59 */       if (i < 0)
/*     */         break; 
/*  61 */       paramOutputStream.write(arrayOfByte, 0, i);
/*     */     } 
/*     */     
/*  64 */     try { paramInputStream.close(); } catch (IOException iOException) {} 
/*  65 */     try { paramOutputStream.close(); } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copyCompletely(Reader paramReader, Writer paramWriter) throws IOException {
/*  71 */     char[] arrayOfChar = new char[8192];
/*     */     
/*     */     while (true) {
/*  74 */       int i = paramReader.read(arrayOfChar);
/*  75 */       if (i < 0)
/*     */         break; 
/*  77 */       paramWriter.write(arrayOfChar, 0, i);
/*     */     } 
/*     */     
/*  80 */     try { paramReader.close(); } catch (IOException iOException) {} 
/*  81 */     try { paramWriter.close(); } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copyCompletely(URI paramURI1, URI paramURI2) throws IOException {
/*     */     try {
/*  89 */       InputStream inputStream = null;
/*     */       
/*     */       try {
/*  92 */         File file = new File(paramURI1);
/*  93 */         if (file.exists()) {
/*  94 */           inputStream = new FileInputStream(file);
/*     */         }
/*  96 */       } catch (Exception exception) {}
/*     */ 
/*     */       
/*  99 */       File file1 = new File(paramURI2);
/* 100 */       File file2 = file1.getParentFile();
/* 101 */       file2.mkdirs();
/*     */       
/* 103 */       if (inputStream == null) {
/* 104 */         inputStream = paramURI1.toURL().openStream();
/*     */       }
/* 106 */       copyCompletely(inputStream, new FileOutputStream(file1));
/*     */     }
/* 108 */     catch (IllegalArgumentException illegalArgumentException) {
/*     */       
/* 110 */       throw new IOException("Cannot copy to " + paramURI2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static File createDir(File paramFile, String paramString) {
/* 116 */     File file = (paramString == null) ? paramFile : new File(paramFile, paramString);
/* 117 */     boolean bool = ((file.exists() && file.isDirectory()) || file.mkdirs()) ? true : false;
/* 118 */     assert bool : "Could not create " + file.getAbsolutePath();
/* 119 */     return file;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\IOUtil.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */