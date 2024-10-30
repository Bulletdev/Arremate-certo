/*     */ package org.apache.xmlbeans.impl.soap;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.Properties;
/*     */ import org.apache.xmlbeans.SystemProperties;
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
/*     */ class FactoryFinder
/*     */ {
/*     */   private static Object newInstance(String paramString) throws SOAPException {
/*  41 */     ClassLoader classLoader = null;
/*     */     try {
/*  43 */       classLoader = Thread.currentThread().getContextClassLoader();
/*  44 */     } catch (Exception exception) {
/*  45 */       throw new SOAPException(exception.toString(), exception);
/*     */     } 
/*     */     
/*     */     try {
/*  49 */       Class clazz = null;
/*  50 */       if (classLoader == null) {
/*  51 */         clazz = Class.forName(paramString);
/*     */       } else {
/*     */         try {
/*  54 */           clazz = classLoader.loadClass(paramString);
/*  55 */         } catch (ClassNotFoundException classNotFoundException) {}
/*     */       } 
/*  57 */       if (clazz == null) {
/*  58 */         classLoader = FactoryFinder.class.getClassLoader();
/*  59 */         clazz = classLoader.loadClass(paramString);
/*     */       } 
/*  61 */       return clazz.newInstance();
/*  62 */     } catch (ClassNotFoundException classNotFoundException) {
/*  63 */       throw new SOAPException("Provider " + paramString + " not found", classNotFoundException);
/*  64 */     } catch (Exception exception) {
/*  65 */       throw new SOAPException("Provider " + paramString + " could not be instantiated: " + exception, exception);
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
/*     */   static Object find(String paramString1, String paramString2) throws SOAPException {
/*     */     try {
/*  80 */       String str1 = SystemProperties.getProperty(paramString1);
/*  81 */       if (str1 != null) {
/*  82 */         return newInstance(str1);
/*     */       }
/*  84 */     } catch (SecurityException securityException) {}
/*     */     
/*     */     try {
/*  87 */       String str1 = SystemProperties.getProperty("java.home") + File.separator + "lib" + File.separator + "jaxm.properties";
/*     */ 
/*     */       
/*  90 */       File file = new File(str1);
/*  91 */       if (file.exists()) {
/*  92 */         FileInputStream fileInputStream = new FileInputStream(file);
/*  93 */         Properties properties = new Properties();
/*  94 */         properties.load(fileInputStream);
/*  95 */         fileInputStream.close();
/*  96 */         String str2 = properties.getProperty(paramString1);
/*  97 */         return newInstance(str2);
/*     */       } 
/*  99 */     } catch (Exception exception) {}
/*     */     
/* 101 */     String str = "META-INF/services/" + paramString1;
/*     */     
/*     */     try {
/* 104 */       InputStream inputStream = getResource(str);
/* 105 */       if (inputStream != null) {
/* 106 */         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
/* 107 */         String str1 = bufferedReader.readLine();
/* 108 */         bufferedReader.close();
/* 109 */         if (str1 != null && !"".equals(str1)) {
/* 110 */           return newInstance(str1);
/*     */         }
/*     */       } 
/* 113 */     } catch (Exception exception) {}
/*     */     
/* 115 */     if (paramString2 == null) {
/* 116 */       throw new SOAPException("Provider for " + paramString1 + " cannot be found", null);
/*     */     }
/* 118 */     return newInstance(paramString2);
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
/*     */   private static InputStream getResource(String paramString) {
/*     */     InputStream inputStream;
/* 137 */     ClassLoader classLoader = null;
/*     */     try {
/* 139 */       classLoader = Thread.currentThread().getContextClassLoader();
/* 140 */     } catch (SecurityException securityException) {}
/*     */ 
/*     */     
/* 143 */     if (classLoader == null) {
/* 144 */       inputStream = ClassLoader.getSystemResourceAsStream(paramString);
/*     */     } else {
/* 146 */       inputStream = classLoader.getResourceAsStream(paramString);
/*     */     } 
/*     */     
/* 149 */     if (inputStream == null) {
/* 150 */       inputStream = FactoryFinder.class.getClassLoader().getResourceAsStream(paramString);
/*     */     }
/* 152 */     return inputStream;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\FactoryFinder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */