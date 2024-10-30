/*     */ package ch.qos.logback.core.util;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
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
/*     */ public class Loader
/*     */ {
/*     */   static final String TSTR = "Caught Exception while in Loader.getResource. This may be innocuous.";
/*     */   private static boolean ignoreTCL = false;
/*     */   public static final String IGNORE_TCL_PROPERTY_NAME = "logback.ignoreTCL";
/*     */   private static boolean HAS_GET_CLASS_LOADER_PERMISSION = false;
/*     */   
/*     */   static {
/*  39 */     String str = OptionHelper.getSystemProperty("logback.ignoreTCL", null);
/*     */     
/*  41 */     if (str != null) {
/*  42 */       ignoreTCL = OptionHelper.toBoolean(str, true);
/*     */     }
/*     */     
/*  45 */     HAS_GET_CLASS_LOADER_PERMISSION = ((Boolean)AccessController.<Boolean>doPrivileged(new PrivilegedAction<Boolean>() {
/*     */           public Boolean a() {
/*     */             try {
/*  48 */               AccessController.checkPermission(new RuntimePermission("getClassLoader"));
/*  49 */               return Boolean.valueOf(true);
/*  50 */             } catch (SecurityException securityException) {
/*     */ 
/*     */               
/*  53 */               return Boolean.valueOf(false);
/*     */             } 
/*     */           }
/*     */         })).booleanValue();
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
/*     */   public static Set<URL> getResources(String paramString, ClassLoader paramClassLoader) throws IOException {
/*  71 */     HashSet<URL> hashSet = new HashSet();
/*  72 */     Enumeration<URL> enumeration = paramClassLoader.getResources(paramString);
/*  73 */     while (enumeration.hasMoreElements()) {
/*  74 */       URL uRL = enumeration.nextElement();
/*  75 */       hashSet.add(uRL);
/*     */     } 
/*  77 */     return hashSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static URL getResource(String paramString, ClassLoader paramClassLoader) {
/*     */     try {
/*  88 */       return paramClassLoader.getResource(paramString);
/*  89 */     } catch (Throwable throwable) {
/*  90 */       return null;
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
/*     */   public static URL getResourceBySelfClassLoader(String paramString) {
/* 102 */     return getResource(paramString, getClassLoaderOfClass(Loader.class));
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
/*     */   public static ClassLoader getTCL() {
/* 115 */     return Thread.currentThread().getContextClassLoader();
/*     */   }
/*     */   
/*     */   public static Class<?> loadClass(String paramString, Context paramContext) throws ClassNotFoundException {
/* 119 */     ClassLoader classLoader = getClassLoaderOfObject(paramContext);
/* 120 */     return classLoader.loadClass(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassLoader getClassLoaderOfObject(Object paramObject) {
/* 131 */     if (paramObject == null) {
/* 132 */       throw new NullPointerException("Argument cannot be null");
/*     */     }
/* 134 */     return getClassLoaderOfClass(paramObject.getClass());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassLoader getClassLoaderAsPrivileged(final Class<?> clazz) {
/* 144 */     if (!HAS_GET_CLASS_LOADER_PERMISSION) {
/* 145 */       return null;
/*     */     }
/* 147 */     return AccessController.<ClassLoader>doPrivileged(new PrivilegedAction<ClassLoader>() {
/*     */           public ClassLoader a() {
/* 149 */             return clazz.getClassLoader();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassLoader getClassLoaderOfClass(Class<?> paramClass) {
/* 162 */     ClassLoader classLoader = paramClass.getClassLoader();
/* 163 */     if (classLoader == null) {
/* 164 */       return ClassLoader.getSystemClassLoader();
/*     */     }
/* 166 */     return classLoader;
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
/*     */   public static Class<?> loadClass(String paramString) throws ClassNotFoundException {
/* 178 */     if (ignoreTCL) {
/* 179 */       return Class.forName(paramString);
/*     */     }
/*     */     try {
/* 182 */       return getTCL().loadClass(paramString);
/* 183 */     } catch (Throwable throwable) {
/*     */ 
/*     */ 
/*     */       
/* 187 */       return Class.forName(paramString);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\Loader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */