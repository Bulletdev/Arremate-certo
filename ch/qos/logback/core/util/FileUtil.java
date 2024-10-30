/*     */ package ch.qos.logback.core.util;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.rolling.RolloverFailure;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileUtil
/*     */   extends ContextAwareBase
/*     */ {
/*     */   static final int BUF_SIZE = 32768;
/*     */   
/*     */   public FileUtil(Context paramContext) {
/*  28 */     setContext(paramContext);
/*     */   }
/*     */   
/*     */   public static URL fileToURL(File paramFile) {
/*     */     try {
/*  33 */       return paramFile.toURI().toURL();
/*  34 */     } catch (MalformedURLException malformedURLException) {
/*  35 */       throw new RuntimeException("Unexpected exception on file [" + paramFile + "]", malformedURLException);
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
/*     */   public static boolean createMissingParentDirectories(File paramFile) {
/*  49 */     File file = paramFile.getParentFile();
/*  50 */     if (file == null)
/*     */     {
/*     */       
/*  53 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  58 */     file.mkdirs();
/*  59 */     return file.exists();
/*     */   }
/*     */   
/*     */   public String resourceAsString(ClassLoader paramClassLoader, String paramString) {
/*  63 */     URL uRL = paramClassLoader.getResource(paramString);
/*  64 */     if (uRL == null) {
/*  65 */       addError("Failed to find resource [" + paramString + "]");
/*  66 */       return null;
/*     */     } 
/*     */     
/*  69 */     InputStreamReader inputStreamReader = null;
/*     */     try {
/*  71 */       URLConnection uRLConnection = uRL.openConnection();
/*  72 */       uRLConnection.setUseCaches(false);
/*  73 */       inputStreamReader = new InputStreamReader(uRLConnection.getInputStream());
/*  74 */       char[] arrayOfChar = new char[128];
/*  75 */       StringBuilder stringBuilder = new StringBuilder();
/*  76 */       int i = -1;
/*  77 */       while ((i = inputStreamReader.read(arrayOfChar, 0, arrayOfChar.length)) != -1) {
/*  78 */         stringBuilder.append(arrayOfChar, 0, i);
/*     */       }
/*  80 */       return stringBuilder.toString();
/*  81 */     } catch (IOException iOException) {
/*  82 */       addError("Failed to open " + paramString, iOException);
/*     */     } finally {
/*  84 */       if (inputStreamReader != null) {
/*     */         try {
/*  86 */           inputStreamReader.close();
/*  87 */         } catch (IOException iOException) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void copy(String paramString1, String paramString2) throws RolloverFailure {
/*  98 */     BufferedInputStream bufferedInputStream = null;
/*  99 */     BufferedOutputStream bufferedOutputStream = null;
/*     */     try {
/* 101 */       bufferedInputStream = new BufferedInputStream(new FileInputStream(paramString1));
/* 102 */       bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramString2));
/* 103 */       byte[] arrayOfByte = new byte[32768];
/*     */       
/*     */       int i;
/* 106 */       while ((i = bufferedInputStream.read(arrayOfByte)) != -1) {
/* 107 */         bufferedOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/*     */       
/* 110 */       bufferedInputStream.close();
/* 111 */       bufferedInputStream = null;
/* 112 */       bufferedOutputStream.close();
/* 113 */       bufferedOutputStream = null;
/* 114 */     } catch (IOException iOException) {
/* 115 */       String str = "Failed to copy [" + paramString1 + "] to [" + paramString2 + "]";
/* 116 */       addError(str, iOException);
/* 117 */       throw new RolloverFailure(str);
/*     */     } finally {
/* 119 */       if (bufferedInputStream != null) {
/*     */         try {
/* 121 */           bufferedInputStream.close();
/* 122 */         } catch (IOException iOException) {}
/*     */       }
/*     */ 
/*     */       
/* 126 */       if (bufferedOutputStream != null)
/*     */         try {
/* 128 */           bufferedOutputStream.close();
/* 129 */         } catch (IOException iOException) {} 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */