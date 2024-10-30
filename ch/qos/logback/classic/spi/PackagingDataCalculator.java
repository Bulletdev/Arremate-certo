/*     */ package ch.qos.logback.classic.spi;
/*     */ 
/*     */ import java.net.URL;
/*     */ import java.security.CodeSource;
/*     */ import java.util.HashMap;
/*     */ import sun.reflect.Reflection;
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
/*     */ public class PackagingDataCalculator
/*     */ {
/*  31 */   static final StackTraceElementProxy[] STEP_ARRAY_TEMPLATE = new StackTraceElementProxy[0];
/*     */   
/*  33 */   HashMap<String, ClassPackagingData> cache = new HashMap<String, ClassPackagingData>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean GET_CALLER_CLASS_METHOD_AVAILABLE = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     
/*  45 */     try { Reflection.getCallerClass(2);
/*  46 */       GET_CALLER_CLASS_METHOD_AVAILABLE = true; }
/*  47 */     catch (NoClassDefFoundError noClassDefFoundError) {  }
/*  48 */     catch (NoSuchMethodError noSuchMethodError) {  }
/*  49 */     catch (UnsupportedOperationException unsupportedOperationException) {  }
/*  50 */     catch (Throwable throwable)
/*  51 */     { System.err.println("Unexpected exception");
/*  52 */       throwable.printStackTrace(); }
/*     */   
/*     */   }
/*     */   
/*     */   public void calculate(IThrowableProxy paramIThrowableProxy) {
/*  57 */     while (paramIThrowableProxy != null) {
/*  58 */       populateFrames(paramIThrowableProxy.getStackTraceElementProxyArray());
/*  59 */       IThrowableProxy[] arrayOfIThrowableProxy = paramIThrowableProxy.getSuppressed();
/*  60 */       if (arrayOfIThrowableProxy != null) {
/*  61 */         for (IThrowableProxy iThrowableProxy : arrayOfIThrowableProxy) {
/*  62 */           populateFrames(iThrowableProxy.getStackTraceElementProxyArray());
/*     */         }
/*     */       }
/*  65 */       paramIThrowableProxy = paramIThrowableProxy.getCause();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void populateFrames(StackTraceElementProxy[] paramArrayOfStackTraceElementProxy) {
/*  72 */     Throwable throwable = new Throwable("local stack reference");
/*  73 */     StackTraceElement[] arrayOfStackTraceElement = throwable.getStackTrace();
/*  74 */     int i = STEUtil.findNumberOfCommonFrames(arrayOfStackTraceElement, paramArrayOfStackTraceElementProxy);
/*  75 */     int j = arrayOfStackTraceElement.length - i;
/*  76 */     int k = paramArrayOfStackTraceElementProxy.length - i;
/*     */     
/*  78 */     ClassLoader classLoader1 = null;
/*  79 */     ClassLoader classLoader2 = null;
/*     */     
/*  81 */     byte b1 = 0;
/*  82 */     for (byte b2 = 0; b2 < i; b2++) {
/*  83 */       Class<?> clazz = null;
/*  84 */       if (GET_CALLER_CLASS_METHOD_AVAILABLE) {
/*  85 */         clazz = Reflection.getCallerClass(j + b2 - b1 + 1);
/*     */       }
/*  87 */       StackTraceElementProxy stackTraceElementProxy = paramArrayOfStackTraceElementProxy[k + b2];
/*  88 */       String str = stackTraceElementProxy.ste.getClassName();
/*     */       
/*  90 */       if (clazz != null && str.equals(clazz.getName())) {
/*     */         
/*  92 */         classLoader1 = clazz.getClassLoader();
/*  93 */         if (classLoader2 == null) {
/*  94 */           classLoader2 = classLoader1;
/*     */         }
/*  96 */         ClassPackagingData classPackagingData = calculateByExactType(clazz);
/*  97 */         stackTraceElementProxy.setClassPackagingData(classPackagingData);
/*     */       } else {
/*  99 */         b1++;
/* 100 */         ClassPackagingData classPackagingData = computeBySTEP(stackTraceElementProxy, classLoader1);
/* 101 */         stackTraceElementProxy.setClassPackagingData(classPackagingData);
/*     */       } 
/*     */     } 
/* 104 */     populateUncommonFrames(i, paramArrayOfStackTraceElementProxy, classLoader2);
/*     */   }
/*     */   
/*     */   void populateUncommonFrames(int paramInt, StackTraceElementProxy[] paramArrayOfStackTraceElementProxy, ClassLoader paramClassLoader) {
/* 108 */     int i = paramArrayOfStackTraceElementProxy.length - paramInt;
/* 109 */     for (byte b = 0; b < i; b++) {
/* 110 */       StackTraceElementProxy stackTraceElementProxy = paramArrayOfStackTraceElementProxy[b];
/* 111 */       ClassPackagingData classPackagingData = computeBySTEP(stackTraceElementProxy, paramClassLoader);
/* 112 */       stackTraceElementProxy.setClassPackagingData(classPackagingData);
/*     */     } 
/*     */   }
/*     */   
/*     */   private ClassPackagingData calculateByExactType(Class paramClass) {
/* 117 */     String str1 = paramClass.getName();
/* 118 */     ClassPackagingData classPackagingData = this.cache.get(str1);
/* 119 */     if (classPackagingData != null) {
/* 120 */       return classPackagingData;
/*     */     }
/* 122 */     String str2 = getImplementationVersion(paramClass);
/* 123 */     String str3 = getCodeLocation(paramClass);
/* 124 */     classPackagingData = new ClassPackagingData(str3, str2);
/* 125 */     this.cache.put(str1, classPackagingData);
/* 126 */     return classPackagingData;
/*     */   }
/*     */   
/*     */   private ClassPackagingData computeBySTEP(StackTraceElementProxy paramStackTraceElementProxy, ClassLoader paramClassLoader) {
/* 130 */     String str1 = paramStackTraceElementProxy.ste.getClassName();
/* 131 */     ClassPackagingData classPackagingData = this.cache.get(str1);
/* 132 */     if (classPackagingData != null) {
/* 133 */       return classPackagingData;
/*     */     }
/* 135 */     Class clazz = bestEffortLoadClass(paramClassLoader, str1);
/* 136 */     String str2 = getImplementationVersion(clazz);
/* 137 */     String str3 = getCodeLocation(clazz);
/* 138 */     classPackagingData = new ClassPackagingData(str3, str2, false);
/* 139 */     this.cache.put(str1, classPackagingData);
/* 140 */     return classPackagingData;
/*     */   }
/*     */   
/*     */   String getImplementationVersion(Class paramClass) {
/* 144 */     if (paramClass == null) {
/* 145 */       return "na";
/*     */     }
/* 147 */     Package package_ = paramClass.getPackage();
/* 148 */     if (package_ != null) {
/* 149 */       String str = package_.getImplementationVersion();
/* 150 */       if (str == null) {
/* 151 */         return "na";
/*     */       }
/* 153 */       return str;
/*     */     } 
/*     */     
/* 156 */     return "na";
/*     */   }
/*     */ 
/*     */   
/*     */   String getCodeLocation(Class paramClass) {
/*     */     try {
/* 162 */       if (paramClass != null) {
/*     */         
/* 164 */         CodeSource codeSource = paramClass.getProtectionDomain().getCodeSource();
/* 165 */         if (codeSource != null) {
/* 166 */           URL uRL = codeSource.getLocation();
/* 167 */           if (uRL != null) {
/* 168 */             String str1 = uRL.toString();
/*     */             
/* 170 */             String str2 = getCodeLocation(str1, '/');
/* 171 */             if (str2 != null) {
/* 172 */               return str2;
/*     */             }
/* 174 */             return getCodeLocation(str1, '\\');
/*     */           } 
/*     */         } 
/*     */       } 
/* 178 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 181 */     return "na";
/*     */   }
/*     */   
/*     */   private String getCodeLocation(String paramString, char paramChar) {
/* 185 */     int i = paramString.lastIndexOf(paramChar);
/* 186 */     if (isFolder(i, paramString)) {
/* 187 */       i = paramString.lastIndexOf(paramChar, i - 1);
/* 188 */       return paramString.substring(i + 1);
/* 189 */     }  if (i > 0) {
/* 190 */       return paramString.substring(i + 1);
/*     */     }
/* 192 */     return null;
/*     */   }
/*     */   
/*     */   private boolean isFolder(int paramInt, String paramString) {
/* 196 */     return (paramInt != -1 && paramInt + 1 == paramString.length());
/*     */   }
/*     */   
/*     */   private Class loadClass(ClassLoader paramClassLoader, String paramString) {
/* 200 */     if (paramClassLoader == null) {
/* 201 */       return null;
/*     */     }
/*     */     try {
/* 204 */       return paramClassLoader.loadClass(paramString);
/* 205 */     } catch (ClassNotFoundException classNotFoundException) {
/* 206 */       return null;
/* 207 */     } catch (NoClassDefFoundError noClassDefFoundError) {
/* 208 */       return null;
/* 209 */     } catch (Exception exception) {
/* 210 */       exception.printStackTrace();
/* 211 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Class bestEffortLoadClass(ClassLoader paramClassLoader, String paramString) {
/* 222 */     Class clazz = loadClass(paramClassLoader, paramString);
/* 223 */     if (clazz != null) {
/* 224 */       return clazz;
/*     */     }
/* 226 */     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/* 227 */     if (classLoader != paramClassLoader) {
/* 228 */       clazz = loadClass(classLoader, paramString);
/*     */     }
/* 230 */     if (clazz != null) {
/* 231 */       return clazz;
/*     */     }
/*     */     
/*     */     try {
/* 235 */       return Class.forName(paramString);
/* 236 */     } catch (ClassNotFoundException classNotFoundException) {
/* 237 */       return null;
/* 238 */     } catch (NoClassDefFoundError noClassDefFoundError) {
/* 239 */       return null;
/* 240 */     } catch (Exception exception) {
/* 241 */       exception.printStackTrace();
/* 242 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\PackagingDataCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */