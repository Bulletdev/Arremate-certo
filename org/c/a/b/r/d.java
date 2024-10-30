/*     */ package org.c.a.b.r;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.net.URLDecoder;
/*     */ import java.security.CodeSource;
/*     */ import java.security.ProtectionDomain;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.c.a.a.a;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
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
/*     */ public class d
/*     */ {
/*  39 */   private static final a a = c.b(d.class);
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
/*     */   public static synchronized <T> T a(String paramString, ClassLoader paramClassLoader) {
/*     */     try {
/*  61 */       return Class.forName(paramString, true, paramClassLoader).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
/*  62 */     } catch (Exception exception) {
/*  63 */       throw new a("Unable to instantiate class " + paramString + " : " + exception.getMessage(), exception);
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
/*     */   public static synchronized <T> T c(Class<T> paramClass) {
/*     */     try {
/*  79 */       return paramClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
/*  80 */     } catch (Exception exception) {
/*  81 */       throw new a("Unable to instantiate class " + paramClass.getName() + " : " + exception.getMessage(), exception);
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
/*     */   public static <T> List<T> a(String[] paramArrayOfString, ClassLoader paramClassLoader) {
/*  94 */     ArrayList<T> arrayList = new ArrayList();
/*  95 */     for (String str : paramArrayOfString) {
/*  96 */       if (n.W(str)) {
/*  97 */         arrayList.add(a(str, paramClassLoader));
/*     */       }
/*     */     } 
/* 100 */     return arrayList;
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
/*     */   public static boolean a(String paramString, ClassLoader paramClassLoader) {
/*     */     try {
/* 114 */       paramClassLoader.loadClass(paramString);
/* 115 */       return true;
/* 116 */     } catch (Throwable throwable) {
/*     */       
/* 118 */       return false;
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
/*     */   public static Class<?> a(String paramString, ClassLoader paramClassLoader) {
/*     */     try {
/* 131 */       Class<?> clazz = paramClassLoader.loadClass(paramString);
/* 132 */       if (Modifier.isAbstract(clazz.getModifiers()) || clazz.isEnum() || clazz.isAnonymousClass()) {
/* 133 */         a.debug("Skipping non-instantiable class: " + paramString);
/* 134 */         return null;
/*     */       } 
/*     */       
/* 137 */       clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
/* 138 */       a.debug("Found class: " + paramString);
/* 139 */       return clazz;
/* 140 */     } catch (InternalError internalError) {
/* 141 */       a.debug("Skipping invalid class: " + paramString);
/* 142 */       return null;
/* 143 */     } catch (IncompatibleClassChangeError incompatibleClassChangeError) {
/* 144 */       a.warn("Skipping incompatibly changed class: " + paramString);
/* 145 */       return null;
/* 146 */     } catch (NoClassDefFoundError noClassDefFoundError) {
/* 147 */       a.debug("Skipping non-loadable class definition: " + paramString);
/* 148 */       return null;
/* 149 */     } catch (ClassNotFoundException classNotFoundException) {
/* 150 */       a.debug("Skipping non-loadable class: " + paramString);
/* 151 */       return null;
/* 152 */     } catch (IllegalAccessException illegalAccessException) {
/* 153 */       a.debug("Skipping non-instantiable class (illegal access): " + paramString);
/* 154 */       return null;
/* 155 */     } catch (InstantiationException instantiationException) {
/* 156 */       a.debug("Skipping non-instantiable class (instantiation error): " + paramString);
/* 157 */       return null;
/* 158 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 159 */       a.debug("Skipping non-instantiable class (no default constructor): " + paramString);
/* 160 */       return null;
/* 161 */     } catch (InvocationTargetException invocationTargetException) {
/* 162 */       a.debug("Skipping non-instantiable class (invocation error): " + paramString);
/* 163 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String b(Class<?> paramClass) {
/* 174 */     String str = paramClass.getName();
/* 175 */     return str.substring(str.lastIndexOf(".") + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String c(Class<?> paramClass) {
/*     */     try {
/* 186 */       ProtectionDomain protectionDomain = paramClass.getProtectionDomain();
/* 187 */       if (protectionDomain == null)
/*     */       {
/* 189 */         return null;
/*     */       }
/* 191 */       CodeSource codeSource = protectionDomain.getCodeSource();
/* 192 */       if (codeSource == null)
/*     */       {
/* 194 */         return null;
/*     */       }
/* 196 */       String str = codeSource.getLocation().getPath();
/* 197 */       return URLDecoder.decode(str, "UTF-8");
/* 198 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */       
/* 200 */       return null;
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
/*     */   public static ClassLoader a(ClassLoader paramClassLoader, String paramString) throws IOException {
/* 213 */     a.debug("Adding location to classpath: " + paramString);
/*     */     
/*     */     try {
/* 216 */       URL uRL = (new File(paramString)).toURI().toURL();
/* 217 */       return new URLClassLoader(new URL[] { uRL }, paramClassLoader);
/* 218 */     } catch (Exception exception) {
/* 219 */       throw new a("Unable to load " + paramString, exception);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */