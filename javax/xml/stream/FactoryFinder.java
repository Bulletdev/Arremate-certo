/*     */ package javax.xml.stream;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.Properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FactoryFinder
/*     */ {
/*     */   private static boolean debug = false;
/*     */   
/*     */   static {
/*     */     try {
/*  19 */       debug = (System.getProperty("xml.stream.debug") != null);
/*  20 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   private static void debugPrintln(String paramString) {
/*  25 */     if (debug) {
/*  26 */       System.err.println("STREAM: " + paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ClassLoader findClassLoader() throws FactoryConfigurationError {
/*     */     ClassLoader classLoader;
/*     */     try {
/*  36 */       Class clazz = Class.forName(FactoryFinder.class.getName() + "$ClassLoaderFinderConcrete");
/*     */       
/*  38 */       ClassLoaderFinder classLoaderFinder = (ClassLoaderFinder)clazz.newInstance();
/*  39 */       classLoader = classLoaderFinder.getContextClassLoader();
/*  40 */     } catch (LinkageError linkageError) {
/*     */       
/*  42 */       classLoader = FactoryFinder.class.getClassLoader();
/*  43 */     } catch (ClassNotFoundException classNotFoundException) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  48 */       classLoader = FactoryFinder.class.getClassLoader();
/*  49 */     } catch (Exception exception) {
/*     */       
/*  51 */       throw new FactoryConfigurationError(exception.toString(), exception);
/*     */     } 
/*  53 */     return classLoader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object newInstance(String paramString, ClassLoader paramClassLoader) throws FactoryConfigurationError {
/*     */     try {
/*     */       Class clazz;
/*  65 */       if (paramClassLoader == null) {
/*  66 */         clazz = Class.forName(paramString);
/*     */       } else {
/*  68 */         clazz = paramClassLoader.loadClass(paramString);
/*     */       } 
/*  70 */       return clazz.newInstance();
/*  71 */     } catch (ClassNotFoundException classNotFoundException) {
/*  72 */       throw new FactoryConfigurationError("Provider " + paramString + " not found", classNotFoundException);
/*     */     }
/*  74 */     catch (Exception exception) {
/*  75 */       throw new FactoryConfigurationError("Provider " + paramString + " could not be instantiated: " + exception, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Object find(String paramString) throws FactoryConfigurationError {
/*  84 */     return find(paramString, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Object find(String paramString1, String paramString2) throws FactoryConfigurationError {
/*  91 */     ClassLoader classLoader = findClassLoader();
/*  92 */     return find(paramString1, paramString2, classLoader);
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
/*     */ 
/*     */ 
/*     */   
/*     */   static Object find(String paramString1, String paramString2, ClassLoader paramClassLoader) throws FactoryConfigurationError {
/*     */     try {
/* 116 */       String str1 = System.getProperty(paramString1);
/*     */       
/* 118 */       if (str1 != null) {
/* 119 */         debugPrintln("found system property" + str1);
/* 120 */         return newInstance(str1, paramClassLoader);
/*     */       } 
/* 122 */     } catch (SecurityException securityException) {}
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 127 */       String str1 = System.getProperty("java.home");
/* 128 */       String str2 = str1 + File.separator + "lib" + File.separator + "jaxp.properties";
/*     */       
/* 130 */       File file = new File(str2);
/* 131 */       if (file.exists()) {
/* 132 */         Properties properties = new Properties();
/* 133 */         properties.load(new FileInputStream(file));
/* 134 */         String str3 = properties.getProperty(paramString1);
/* 135 */         if (str3 != null && str3.length() > 0) {
/* 136 */           debugPrintln("found java.home property " + str3);
/* 137 */           return newInstance(str3, paramClassLoader);
/*     */         } 
/*     */       } 
/* 140 */     } catch (Exception exception) {
/* 141 */       if (debug) exception.printStackTrace();
/*     */     
/*     */     } 
/* 144 */     String str = "META-INF/services/" + paramString1;
/*     */     
/*     */     try {
/* 147 */       InputStream inputStream = null;
/* 148 */       if (paramClassLoader == null) {
/* 149 */         inputStream = ClassLoader.getSystemResourceAsStream(str);
/*     */       } else {
/* 151 */         inputStream = paramClassLoader.getResourceAsStream(str);
/*     */       } 
/*     */       
/* 154 */       if (inputStream != null) {
/* 155 */         debugPrintln("found " + str);
/* 156 */         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
/*     */ 
/*     */         
/* 159 */         String str1 = bufferedReader.readLine();
/* 160 */         bufferedReader.close();
/*     */         
/* 162 */         if (str1 != null && !"".equals(str1)) {
/*     */           
/* 164 */           debugPrintln("loaded from services: " + str1);
/* 165 */           return newInstance(str1, paramClassLoader);
/*     */         } 
/*     */       } 
/* 168 */     } catch (Exception exception) {
/* 169 */       if (debug) exception.printStackTrace();
/*     */     
/*     */     } 
/* 172 */     if (paramString2 == null) {
/* 173 */       throw new FactoryConfigurationError("Provider for " + paramString1 + " cannot be found", null);
/*     */     }
/*     */ 
/*     */     
/* 177 */     debugPrintln("loaded from fallback value: " + paramString2);
/* 178 */     return newInstance(paramString2, paramClassLoader);
/*     */   }
/*     */   
/*     */   private static abstract class ClassLoaderFinder
/*     */   {
/*     */     private ClassLoaderFinder() {}
/*     */     
/*     */     abstract ClassLoader getContextClassLoader();
/*     */   }
/*     */   
/*     */   static class ClassLoaderFinderConcrete
/*     */     extends ClassLoaderFinder
/*     */   {
/*     */     ClassLoader getContextClassLoader() {
/* 192 */       return Thread.currentThread().getContextClassLoader();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\FactoryFinder.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */