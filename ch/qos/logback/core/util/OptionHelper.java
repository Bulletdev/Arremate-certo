/*     */ package ch.qos.logback.core.util;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.spi.ContextAware;
/*     */ import ch.qos.logback.core.spi.PropertyContainer;
/*     */ import ch.qos.logback.core.spi.ScanException;
/*     */ import ch.qos.logback.core.subst.NodeToStringTransformer;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.Properties;
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
/*     */ public class OptionHelper
/*     */ {
/*     */   static final String DELIM_START = "${";
/*     */   static final char DELIM_STOP = '}';
/*     */   static final String DELIM_DEFAULT = ":-";
/*     */   static final int DELIM_START_LEN = 2;
/*     */   static final int DELIM_STOP_LEN = 1;
/*     */   static final int DELIM_DEFAULT_LEN = 2;
/*     */   static final String _IS_UNDEFINED = "_IS_UNDEFINED";
/*     */   
/*     */   public static Object instantiateByClassName(String paramString, Class<?> paramClass, Context paramContext) throws IncompatibleClassException, DynamicClassLoadingException {
/*  32 */     ClassLoader classLoader = Loader.getClassLoaderOfObject(paramContext);
/*  33 */     return instantiateByClassName(paramString, paramClass, classLoader);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Object instantiateByClassNameAndParameter(String paramString, Class<?> paramClass1, Context paramContext, Class<?> paramClass2, Object paramObject) throws IncompatibleClassException, DynamicClassLoadingException {
/*  38 */     ClassLoader classLoader = Loader.getClassLoaderOfObject(paramContext);
/*  39 */     return instantiateByClassNameAndParameter(paramString, paramClass1, classLoader, paramClass2, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Object instantiateByClassName(String paramString, Class<?> paramClass, ClassLoader paramClassLoader) throws IncompatibleClassException, DynamicClassLoadingException {
/*  44 */     return instantiateByClassNameAndParameter(paramString, paramClass, paramClassLoader, (Class<?>)null, (Object)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object instantiateByClassNameAndParameter(String paramString, Class<?> paramClass1, ClassLoader paramClassLoader, Class<?> paramClass2, Object paramObject) throws IncompatibleClassException, DynamicClassLoadingException {
/*  50 */     if (paramString == null) {
/*  51 */       throw new NullPointerException();
/*     */     }
/*     */     try {
/*  54 */       Class<?> clazz = null;
/*  55 */       clazz = paramClassLoader.loadClass(paramString);
/*  56 */       if (!paramClass1.isAssignableFrom(clazz)) {
/*  57 */         throw new IncompatibleClassException(paramClass1, clazz);
/*     */       }
/*  59 */       if (paramClass2 == null) {
/*  60 */         return clazz.newInstance();
/*     */       }
/*  62 */       Constructor<?> constructor = clazz.getConstructor(new Class[] { paramClass2 });
/*  63 */       return constructor.newInstance(new Object[] { paramObject });
/*     */     }
/*  65 */     catch (IncompatibleClassException incompatibleClassException) {
/*  66 */       throw incompatibleClassException;
/*  67 */     } catch (Throwable throwable) {
/*  68 */       throw new DynamicClassLoadingException("Failed to instantiate type " + paramString, throwable);
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
/*     */   public static String substVars(String paramString, PropertyContainer paramPropertyContainer) {
/* 103 */     return substVars(paramString, paramPropertyContainer, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String substVars(String paramString, PropertyContainer paramPropertyContainer1, PropertyContainer paramPropertyContainer2) {
/*     */     try {
/* 111 */       return NodeToStringTransformer.substituteVariable(paramString, paramPropertyContainer1, paramPropertyContainer2);
/* 112 */     } catch (ScanException scanException) {
/* 113 */       throw new IllegalArgumentException("Failed to parse input [" + paramString + "]", scanException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String propertyLookup(String paramString, PropertyContainer paramPropertyContainer1, PropertyContainer paramPropertyContainer2) {
/* 118 */     String str = null;
/*     */     
/* 120 */     str = paramPropertyContainer1.getProperty(paramString);
/*     */ 
/*     */     
/* 123 */     if (str == null && paramPropertyContainer2 != null) {
/* 124 */       str = paramPropertyContainer2.getProperty(paramString);
/*     */     }
/*     */     
/* 127 */     if (str == null) {
/* 128 */       str = getSystemProperty(paramString, null);
/*     */     }
/* 130 */     if (str == null) {
/* 131 */       str = getEnv(paramString);
/*     */     }
/* 133 */     return str;
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
/*     */   public static String getSystemProperty(String paramString1, String paramString2) {
/*     */     try {
/* 147 */       return System.getProperty(paramString1, paramString2);
/* 148 */     } catch (SecurityException securityException) {
/* 149 */       return paramString2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getEnv(String paramString) {
/*     */     try {
/* 161 */       return System.getenv(paramString);
/* 162 */     } catch (SecurityException securityException) {
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
/*     */   
/*     */   public static String getSystemProperty(String paramString) {
/*     */     try {
/* 176 */       return System.getProperty(paramString);
/* 177 */     } catch (SecurityException securityException) {
/* 178 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setSystemProperties(ContextAware paramContextAware, Properties paramProperties) {
/* 183 */     for (String str1 : paramProperties.keySet()) {
/* 184 */       String str2 = str1;
/* 185 */       String str3 = paramProperties.getProperty(str2);
/* 186 */       setSystemProperty(paramContextAware, str2, str3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setSystemProperty(ContextAware paramContextAware, String paramString1, String paramString2) {
/*     */     try {
/* 192 */       System.setProperty(paramString1, paramString2);
/* 193 */     } catch (SecurityException securityException) {
/* 194 */       paramContextAware.addError("Failed to set system property [" + paramString1 + "]", securityException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Properties getSystemProperties() {
/*     */     try {
/* 206 */       return System.getProperties();
/* 207 */     } catch (SecurityException securityException) {
/* 208 */       return new Properties();
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
/*     */   public static String[] extractDefaultReplacement(String paramString) {
/* 221 */     String[] arrayOfString = new String[2];
/* 222 */     if (paramString == null) {
/* 223 */       return arrayOfString;
/*     */     }
/* 225 */     arrayOfString[0] = paramString;
/* 226 */     int i = paramString.indexOf(":-");
/* 227 */     if (i != -1) {
/* 228 */       arrayOfString[0] = paramString.substring(0, i);
/* 229 */       arrayOfString[1] = paramString.substring(i + 2);
/*     */     } 
/* 231 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean toBoolean(String paramString, boolean paramBoolean) {
/* 242 */     if (paramString == null) {
/* 243 */       return paramBoolean;
/*     */     }
/*     */     
/* 246 */     String str = paramString.trim();
/*     */     
/* 248 */     if ("true".equalsIgnoreCase(str)) {
/* 249 */       return true;
/*     */     }
/*     */     
/* 252 */     if ("false".equalsIgnoreCase(str)) {
/* 253 */       return false;
/*     */     }
/*     */     
/* 256 */     return paramBoolean;
/*     */   }
/*     */   
/*     */   public static boolean isEmpty(String paramString) {
/* 260 */     return (paramString == null || paramString.length() == 0);
/*     */   }
/*     */   
/*     */   public static final boolean isNullOrEmpty(Object[] paramArrayOfObject) {
/* 264 */     if (paramArrayOfObject == null || paramArrayOfObject.length == 0) {
/* 265 */       return true;
/*     */     }
/* 267 */     return false;
/*     */   }
/*     */   
/*     */   public static final boolean isNotEmtpy(Object[] paramArrayOfObject) {
/* 271 */     return !isNullOrEmpty(paramArrayOfObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\OptionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */