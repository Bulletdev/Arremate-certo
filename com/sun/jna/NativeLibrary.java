/*      */ package com.sun.jna;
/*      */ 
/*      */ import java.io.BufferedReader;
/*      */ import java.io.File;
/*      */ import java.io.FilenameFilter;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStreamReader;
/*      */ import java.lang.ref.Reference;
/*      */ import java.lang.ref.WeakReference;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.StringTokenizer;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class NativeLibrary
/*      */ {
/*   86 */   private static final Logger LOG = Logger.getLogger(NativeLibrary.class.getName());
/*   87 */   private static final Level DEBUG_LOAD_LEVEL = Native.DEBUG_LOAD ? Level.INFO : Level.FINE;
/*      */   
/*      */   private long handle;
/*      */   private final String libraryName;
/*      */   private final String libraryPath;
/*   92 */   private final Map<String, Function> functions = new HashMap<String, Function>();
/*      */   
/*      */   final int callFlags;
/*      */   private String encoding;
/*      */   final Map<String, ?> options;
/*   97 */   private static final Map<String, Reference<NativeLibrary>> libraries = new HashMap<String, Reference<NativeLibrary>>();
/*   98 */   private static final Map<String, List<String>> searchPaths = Collections.synchronizedMap(new HashMap<String, List<String>>());
/*   99 */   private static final LinkedHashSet<String> librarySearchPath = new LinkedHashSet<String>();
/*      */   private static final int DEFAULT_OPEN_OPTIONS = -1;
/*      */   
/*      */   static {
/*  103 */     if (Native.POINTER_SIZE == 0)
/*  104 */       throw new Error("Native library not initialized"); 
/*      */   }
/*      */   
/*      */   private static String functionKey(String paramString1, int paramInt, String paramString2) {
/*  108 */     return paramString1 + "|" + paramInt + "|" + paramString2;
/*      */   }
/*      */   
/*      */   private NativeLibrary(String paramString1, String paramString2, long paramLong, Map<String, ?> paramMap) {
/*  112 */     this.libraryName = getLibraryName(paramString1);
/*  113 */     this.libraryPath = paramString2;
/*  114 */     this.handle = paramLong;
/*  115 */     Object object = paramMap.get("calling-convention");
/*  116 */     boolean bool = (object instanceof Number) ? ((Number)object).intValue() : false;
/*  117 */     this.callFlags = bool;
/*  118 */     this.options = paramMap;
/*  119 */     this.encoding = (String)paramMap.get("string-encoding");
/*  120 */     if (this.encoding == null) {
/*  121 */       this.encoding = Native.getDefaultStringEncoding();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  126 */     if (Platform.isWindows() && "kernel32".equals(this.libraryName.toLowerCase())) {
/*  127 */       synchronized (this.functions) {
/*  128 */         Function function = new Function(this, "GetLastError", 63, this.encoding)
/*      */           {
/*      */             Object invoke(Object[] param1ArrayOfObject, Class<?> param1Class, boolean param1Boolean, int param1Int) {
/*  131 */               return Integer.valueOf(Native.getLastError());
/*      */             }
/*      */ 
/*      */             
/*      */             Object invoke(Method param1Method, Class<?>[] param1ArrayOfClass, Class<?> param1Class, Object[] param1ArrayOfObject, Map<String, ?> param1Map) {
/*  136 */               return Integer.valueOf(Native.getLastError());
/*      */             }
/*      */           };
/*  139 */         this.functions.put(functionKey("GetLastError", this.callFlags, this.encoding), function);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static int openFlags(Map<String, ?> paramMap) {
/*  146 */     Object object = paramMap.get("open-flags");
/*  147 */     if (object instanceof Number) {
/*  148 */       return ((Number)object).intValue();
/*      */     }
/*  150 */     return -1;
/*      */   }
/*      */   
/*      */   private static NativeLibrary loadLibrary(String paramString, Map<String, ?> paramMap) {
/*  154 */     LOG.log(DEBUG_LOAD_LEVEL, "Looking for library '" + paramString + "'");
/*      */     
/*  156 */     ArrayList<UnsatisfiedLinkError> arrayList = new ArrayList();
/*  157 */     boolean bool = (new File(paramString)).isAbsolute();
/*  158 */     LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
/*  159 */     int i = openFlags(paramMap);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  164 */     List list = searchPaths.get(paramString);
/*  165 */     if (list != null) {
/*  166 */       synchronized (list) {
/*  167 */         linkedHashSet.addAll(list);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  173 */     String str1 = Native.getWebStartLibraryPath(paramString);
/*  174 */     if (str1 != null) {
/*  175 */       LOG.log(DEBUG_LOAD_LEVEL, "Adding web start path " + str1);
/*  176 */       linkedHashSet.add(str1);
/*      */     } 
/*      */     
/*  179 */     LOG.log(DEBUG_LOAD_LEVEL, "Adding paths from jna.library.path: " + System.getProperty("jna.library.path"));
/*      */     
/*  181 */     linkedHashSet.addAll(initPaths("jna.library.path"));
/*  182 */     String str2 = findLibraryPath(paramString, linkedHashSet);
/*  183 */     long l = 0L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  190 */       LOG.log(DEBUG_LOAD_LEVEL, "Trying " + str2);
/*  191 */       l = Native.open(str2, i);
/*  192 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*      */       
/*  194 */       LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError.getMessage());
/*  195 */       LOG.log(DEBUG_LOAD_LEVEL, "Adding system paths: " + librarySearchPath);
/*  196 */       arrayList.add(unsatisfiedLinkError);
/*  197 */       linkedHashSet.addAll(librarySearchPath);
/*      */     } 
/*      */     
/*      */     try {
/*  201 */       if (l == 0L) {
/*  202 */         str2 = findLibraryPath(paramString, linkedHashSet);
/*  203 */         LOG.log(DEBUG_LOAD_LEVEL, "Trying " + str2);
/*  204 */         l = Native.open(str2, i);
/*  205 */         if (l == 0L) {
/*  206 */           throw new UnsatisfiedLinkError("Failed to load library '" + paramString + "'");
/*      */         }
/*      */       } 
/*  209 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  210 */       LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError.getMessage());
/*  211 */       arrayList.add(unsatisfiedLinkError);
/*      */ 
/*      */ 
/*      */       
/*  215 */       if (Platform.isAndroid()) {
/*      */         try {
/*  217 */           LOG.log(DEBUG_LOAD_LEVEL, "Preload (via System.loadLibrary) " + paramString);
/*  218 */           System.loadLibrary(paramString);
/*  219 */           l = Native.open(str2, i);
/*      */         }
/*  221 */         catch (UnsatisfiedLinkError unsatisfiedLinkError1) {
/*  222 */           LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError1.getMessage());
/*  223 */           arrayList.add(unsatisfiedLinkError1);
/*      */         }
/*      */       
/*  226 */       } else if (Platform.isLinux() || Platform.isFreeBSD()) {
/*      */ 
/*      */ 
/*      */         
/*  230 */         LOG.log(DEBUG_LOAD_LEVEL, "Looking for version variants");
/*  231 */         str2 = matchLibrary(paramString, linkedHashSet);
/*  232 */         if (str2 != null) {
/*  233 */           LOG.log(DEBUG_LOAD_LEVEL, "Trying " + str2);
/*      */           try {
/*  235 */             l = Native.open(str2, i);
/*      */           }
/*  237 */           catch (UnsatisfiedLinkError unsatisfiedLinkError1) {
/*  238 */             LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError1.getMessage());
/*  239 */             arrayList.add(unsatisfiedLinkError1);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*  244 */       } else if (Platform.isMac() && !paramString.endsWith(".dylib")) {
/*  245 */         for (String str : matchFramework(paramString)) {
/*      */           try {
/*  247 */             LOG.log(DEBUG_LOAD_LEVEL, "Trying " + str);
/*  248 */             l = Native.open(str, i);
/*      */             
/*      */             break;
/*  251 */           } catch (UnsatisfiedLinkError unsatisfiedLinkError1) {
/*  252 */             LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError1.getMessage());
/*  253 */             arrayList.add(unsatisfiedLinkError1);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*  258 */       } else if (Platform.isWindows() && !bool) {
/*  259 */         LOG.log(DEBUG_LOAD_LEVEL, "Looking for lib- prefix");
/*  260 */         str2 = findLibraryPath("lib" + paramString, linkedHashSet);
/*  261 */         if (str2 != null) {
/*  262 */           LOG.log(DEBUG_LOAD_LEVEL, "Trying " + str2);
/*      */           try {
/*  264 */             l = Native.open(str2, i);
/*  265 */           } catch (UnsatisfiedLinkError unsatisfiedLinkError1) {
/*  266 */             LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError1.getMessage());
/*  267 */             arrayList.add(unsatisfiedLinkError1);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  273 */       if (l == 0L) {
/*      */         try {
/*  275 */           File file = Native.extractFromResourcePath(paramString, (ClassLoader)paramMap.get("classloader"));
/*      */           try {
/*  277 */             l = Native.open(file.getAbsolutePath(), i);
/*  278 */             str2 = file.getAbsolutePath();
/*      */           } finally {
/*      */             
/*  281 */             if (Native.isUnpacked(file)) {
/*  282 */               Native.deleteLibrary(file);
/*      */             }
/*      */           }
/*      */         
/*  286 */         } catch (IOException iOException) {
/*  287 */           LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + iOException.getMessage());
/*  288 */           arrayList.add(iOException);
/*      */         } 
/*      */       }
/*      */       
/*  292 */       if (l == 0L) {
/*  293 */         StringBuilder stringBuilder = new StringBuilder();
/*  294 */         stringBuilder.append("Unable to load library '");
/*  295 */         stringBuilder.append(paramString);
/*  296 */         stringBuilder.append("':");
/*  297 */         for (Throwable throwable : arrayList) {
/*  298 */           stringBuilder.append("\n");
/*  299 */           stringBuilder.append(throwable.getMessage());
/*      */         } 
/*  301 */         UnsatisfiedLinkError unsatisfiedLinkError1 = new UnsatisfiedLinkError(stringBuilder.toString());
/*  302 */         for (Throwable throwable : arrayList) {
/*  303 */           addSuppressedReflected(unsatisfiedLinkError1, throwable);
/*      */         }
/*  305 */         throw unsatisfiedLinkError1;
/*      */       } 
/*      */     } 
/*      */     
/*  309 */     LOG.log(DEBUG_LOAD_LEVEL, "Found library '" + paramString + "' at " + str2);
/*  310 */     return new NativeLibrary(paramString, str2, l, paramMap);
/*      */   }
/*      */   
/*  313 */   private static Method addSuppressedMethod = null;
/*      */   private static void addSuppressedReflected(Throwable paramThrowable1, Throwable paramThrowable2) { if (addSuppressedMethod == null) return;  try { addSuppressedMethod.invoke(paramThrowable1, new Object[] { paramThrowable2 }); } catch (IllegalAccessException illegalAccessException) { throw new RuntimeException("Failed to call addSuppressedMethod", illegalAccessException); } catch (IllegalArgumentException illegalArgumentException) { throw new RuntimeException("Failed to call addSuppressedMethod", illegalArgumentException); } catch (InvocationTargetException invocationTargetException) { throw new RuntimeException("Failed to call addSuppressedMethod", invocationTargetException); }  }
/*      */   static String[] matchFramework(String paramString) { LinkedHashSet<String> linkedHashSet = new LinkedHashSet(); File file = new File(paramString); if (file.isAbsolute()) { if (paramString.contains(".framework")) { if (file.exists()) return new String[] { file.getAbsolutePath() };  linkedHashSet.add(file.getAbsolutePath()); } else { file = new File(new File(file.getParentFile(), file.getName() + ".framework"), file.getName()); if (file.exists()) return new String[] { file.getAbsolutePath() };  linkedHashSet.add(file.getAbsolutePath()); }  } else { String[] arrayOfString = { System.getProperty("user.home"), "", "/System" }; String str = !paramString.contains(".framework") ? (paramString + ".framework/" + paramString) : paramString; for (String str1 : arrayOfString) { file = new File(str1 + "/Library/Frameworks/" + str); if (file.exists()) return new String[] { file.getAbsolutePath() };  linkedHashSet.add(file.getAbsolutePath()); }  }  return linkedHashSet.<String>toArray(new String[0]); }
/*  316 */   private String getLibraryName(String paramString) { String str1 = paramString; String str2 = "---"; String str3 = mapSharedLibraryName("---"); int i = str3.indexOf("---"); if (i > 0 && str1.startsWith(str3.substring(0, i))) str1 = str1.substring(i);  String str4 = str3.substring(i + "---".length()); int j = str1.indexOf(str4); if (j != -1) str1 = str1.substring(0, j);  return str1; } public static final NativeLibrary getInstance(String paramString) { return getInstance(paramString, Collections.emptyMap()); } public static final NativeLibrary getInstance(String paramString, ClassLoader paramClassLoader) { return getInstance(paramString, Collections.singletonMap("classloader", paramClassLoader)); } public static final NativeLibrary getInstance(String paramString, Map<String, ?> paramMap) { HashMap<String, Object> hashMap = new HashMap<String, Object>(paramMap); if (hashMap.get("calling-convention") == null) hashMap.put("calling-convention", Integer.valueOf(0));  if ((Platform.isLinux() || Platform.isFreeBSD() || Platform.isAIX()) && Platform.C_LIBRARY_NAME.equals(paramString)) paramString = null;  synchronized (libraries) { Reference<NativeLibrary> reference = libraries.get(paramString + hashMap); NativeLibrary nativeLibrary = (reference != null) ? reference.get() : null; if (nativeLibrary == null) { if (paramString == null) { nativeLibrary = new NativeLibrary("<process>", null, Native.open(null, openFlags(hashMap)), hashMap); } else { nativeLibrary = loadLibrary(paramString, hashMap); }  reference = new WeakReference<NativeLibrary>(nativeLibrary); libraries.put(nativeLibrary.getName() + hashMap, reference); File file = nativeLibrary.getFile(); if (file != null) { libraries.put(file.getAbsolutePath() + hashMap, reference); libraries.put(file.getName() + hashMap, reference); }  }  return nativeLibrary; }  } public static final synchronized NativeLibrary getProcess() { return getInstance(null); } static { try { addSuppressedMethod = Throwable.class.getMethod("addSuppressed", new Class[] { Throwable.class }); }
/*  317 */     catch (NoSuchMethodException noSuchMethodException)
/*      */     {  }
/*  319 */     catch (SecurityException securityException)
/*  320 */     { Logger.getLogger(NativeLibrary.class.getName()).log(Level.SEVERE, "Failed to initialize 'addSuppressed' method", securityException); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  882 */     String str = Native.getWebStartLibraryPath("jnidispatch");
/*  883 */     if (str != null) {
/*  884 */       librarySearchPath.add(str);
/*      */     }
/*  886 */     if (System.getProperty("jna.platform.library.path") == null && 
/*  887 */       !Platform.isWindows()) {
/*      */       
/*  889 */       String str1 = "";
/*  890 */       String str2 = "";
/*  891 */       String str3 = "";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  904 */       if (Platform.isLinux() || Platform.isSolaris() || 
/*  905 */         Platform.isFreeBSD() || Platform.iskFreeBSD())
/*      */       {
/*  907 */         str3 = (Platform.isSolaris() ? "/" : "") + (Native.POINTER_SIZE * 8);
/*      */       }
/*  909 */       String[] arrayOfString = { "/usr/lib" + str3, "/lib" + str3, "/usr/lib", "/lib" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  920 */       if (Platform.isLinux() || Platform.iskFreeBSD() || Platform.isGNU()) {
/*  921 */         String str4 = getMultiArchPath();
/*      */ 
/*      */         
/*  924 */         arrayOfString = new String[] { "/usr/lib/" + str4, "/lib/" + str4, "/usr/lib" + str3, "/lib" + str3, "/usr/lib", "/lib" };
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  940 */       if (Platform.isLinux()) {
/*  941 */         ArrayList<String> arrayList = getLinuxLdPaths();
/*      */         
/*  943 */         for (int i = arrayOfString.length - 1; 0 <= i; i--) {
/*  944 */           int j = arrayList.indexOf(arrayOfString[i]);
/*  945 */           if (j != -1) {
/*  946 */             arrayList.remove(j);
/*      */           }
/*  948 */           arrayList.add(0, arrayOfString[i]);
/*      */         } 
/*  950 */         arrayOfString = arrayList.<String>toArray(new String[0]);
/*      */       } 
/*      */       
/*  953 */       for (byte b = 0; b < arrayOfString.length; b++) {
/*  954 */         File file = new File(arrayOfString[b]);
/*  955 */         if (file.exists() && file.isDirectory()) {
/*  956 */           str1 = str1 + str2 + arrayOfString[b];
/*  957 */           str2 = File.pathSeparator;
/*      */         } 
/*      */       } 
/*  960 */       if (!"".equals(str1)) {
/*  961 */         System.setProperty("jna.platform.library.path", str1);
/*      */       }
/*      */     } 
/*  964 */     librarySearchPath.addAll(initPaths("jna.platform.library.path")); }
/*      */   public static final synchronized NativeLibrary getProcess(Map<String, ?> paramMap) { return getInstance((String)null, paramMap); }
/*      */   public static final void addSearchPath(String paramString1, String paramString2) { synchronized (searchPaths) { List<?> list = searchPaths.get(paramString1); if (list == null) { list = Collections.synchronizedList(new ArrayList()); searchPaths.put(paramString1, list); }  list.add(paramString2); }  }
/*      */   public Function getFunction(String paramString) { return getFunction(paramString, this.callFlags); }
/*  968 */   Function getFunction(String paramString, Method paramMethod) { FunctionMapper functionMapper = (FunctionMapper)this.options.get("function-mapper"); if (functionMapper != null) paramString = functionMapper.getFunctionName(this, paramMethod);  String str = System.getProperty("jna.profiler.prefix", "$$YJP$$"); if (paramString.startsWith(str)) paramString = paramString.substring(str.length());  int i = this.callFlags; Class[] arrayOfClass = paramMethod.getExceptionTypes(); for (byte b = 0; b < arrayOfClass.length; b++) { if (LastErrorException.class.isAssignableFrom(arrayOfClass[b])) i |= 0x40;  }  return getFunction(paramString, i); } public Function getFunction(String paramString, int paramInt) { return getFunction(paramString, paramInt, this.encoding); } public Function getFunction(String paramString1, int paramInt, String paramString2) { if (paramString1 == null) throw new NullPointerException("Function name may not be null");  synchronized (this.functions) { String str = functionKey(paramString1, paramInt, paramString2); Function function = this.functions.get(str); if (function == null) { function = new Function(this, paramString1, paramInt, paramString2); this.functions.put(str, function); }  return function; }  } public Map<String, ?> getOptions() { return this.options; } private static String getMultiArchPath() { String str1 = Platform.ARCH;
/*      */ 
/*      */     
/*  971 */     String str2 = Platform.iskFreeBSD() ? "-kfreebsd" : (Platform.isGNU() ? "" : "-linux");
/*  972 */     String str3 = "-gnu";
/*      */     
/*  974 */     if (Platform.isIntel()) {
/*  975 */       str1 = Platform.is64Bit() ? "x86_64" : "i386";
/*      */     }
/*  977 */     else if (Platform.isPPC()) {
/*  978 */       str1 = Platform.is64Bit() ? "powerpc64" : "powerpc";
/*      */     }
/*  980 */     else if (Platform.isARM()) {
/*  981 */       str1 = "arm";
/*  982 */       str3 = "-gnueabi";
/*      */     }
/*  984 */     else if (Platform.ARCH.equals("mips64el")) {
/*  985 */       str3 = "-gnuabi64";
/*      */     } 
/*      */     
/*  988 */     return str1 + str2 + str3; } public Pointer getGlobalVariableAddress(String paramString) { try { return new Pointer(getSymbolAddress(paramString)); } catch (UnsatisfiedLinkError unsatisfiedLinkError) { throw new UnsatisfiedLinkError("Error looking up '" + paramString + "': " + unsatisfiedLinkError.getMessage()); }  }
/*      */   long getSymbolAddress(String paramString) { if (this.handle == 0L) throw new UnsatisfiedLinkError("Library has been unloaded");  return Native.findSymbol(this.handle, paramString); }
/*      */   public String toString() { return "Native Library <" + this.libraryPath + "@" + this.handle + ">"; }
/*      */   public String getName() { return this.libraryName; }
/*      */   public File getFile() { if (this.libraryPath == null) return null;  return new File(this.libraryPath); }
/*      */   protected void finalize() { dispose(); }
/*      */   static void disposeAll() { LinkedHashSet linkedHashSet; synchronized (libraries) { linkedHashSet = new LinkedHashSet(libraries.values()); }  for (Reference<NativeLibrary> reference : (Iterable<Reference<NativeLibrary>>)linkedHashSet) { NativeLibrary nativeLibrary = reference.get(); if (nativeLibrary != null) nativeLibrary.dispose();  }  }
/*  995 */   private static ArrayList<String> getLinuxLdPaths() { ArrayList<String> arrayList = new ArrayList();
/*  996 */     Process process = null;
/*  997 */     BufferedReader bufferedReader = null;
/*      */     
/*  999 */     try { process = Runtime.getRuntime().exec("/sbin/ldconfig -p");
/* 1000 */       bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
/*      */       String str;
/* 1002 */       while ((str = bufferedReader.readLine()) != null) {
/* 1003 */         int i = str.indexOf(" => ");
/* 1004 */         int j = str.lastIndexOf('/');
/* 1005 */         if (i != -1 && j != -1 && i < j) {
/* 1006 */           String str1 = str.substring(i + 4, j);
/* 1007 */           if (!arrayList.contains(str1)) {
/* 1008 */             arrayList.add(str1);
/*      */           }
/*      */         } 
/*      */       }  }
/* 1012 */     catch (Exception exception) {  }
/*      */     finally
/* 1014 */     { if (bufferedReader != null) {
/*      */         try {
/* 1016 */           bufferedReader.close();
/* 1017 */         } catch (IOException iOException) {}
/*      */       }
/*      */       
/* 1020 */       if (process != null) {
/*      */         try {
/* 1022 */           process.waitFor();
/* 1023 */         } catch (InterruptedException interruptedException) {}
/*      */       } }
/*      */ 
/*      */     
/* 1027 */     return arrayList; }
/*      */ 
/*      */   
/*      */   public void dispose() {
/*      */     HashSet hashSet = new HashSet();
/*      */     synchronized (libraries) {
/*      */       for (Map.Entry<String, Reference<NativeLibrary>> entry : libraries.entrySet()) {
/*      */         Reference<NativeLibrary> reference = (Reference)entry.getValue();
/*      */         if (reference.get() == this)
/*      */           hashSet.add(entry.getKey()); 
/*      */       } 
/*      */       for (String str : hashSet)
/*      */         libraries.remove(str); 
/*      */     } 
/*      */     synchronized (this) {
/*      */       if (this.handle != 0L) {
/*      */         Native.close(this.handle);
/*      */         this.handle = 0L;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static List<String> initPaths(String paramString) {
/*      */     String str = System.getProperty(paramString, "");
/*      */     if ("".equals(str))
/*      */       return Collections.emptyList(); 
/*      */     StringTokenizer stringTokenizer = new StringTokenizer(str, File.pathSeparator);
/*      */     ArrayList<String> arrayList = new ArrayList();
/*      */     while (stringTokenizer.hasMoreTokens()) {
/*      */       String str1 = stringTokenizer.nextToken();
/*      */       if (!"".equals(str1))
/*      */         arrayList.add(str1); 
/*      */     } 
/*      */     return arrayList;
/*      */   }
/*      */   
/*      */   private static String findLibraryPath(String paramString, Collection<String> paramCollection) {
/*      */     if ((new File(paramString)).isAbsolute())
/*      */       return paramString; 
/*      */     String str = mapSharedLibraryName(paramString);
/*      */     for (String str1 : paramCollection) {
/*      */       File file = new File(str1, str);
/*      */       if (file.exists())
/*      */         return file.getAbsolutePath(); 
/*      */       if (Platform.isMac())
/*      */         if (str.endsWith(".dylib")) {
/*      */           file = new File(str1, str.substring(0, str.lastIndexOf(".dylib")) + ".jnilib");
/*      */           if (file.exists())
/*      */             return file.getAbsolutePath(); 
/*      */         }  
/*      */     } 
/*      */     return str;
/*      */   }
/*      */   
/*      */   static String mapSharedLibraryName(String paramString) {
/*      */     if (Platform.isMac()) {
/*      */       if (paramString.startsWith("lib") && (paramString.endsWith(".dylib") || paramString.endsWith(".jnilib")))
/*      */         return paramString; 
/*      */       String str = System.mapLibraryName(paramString);
/*      */       if (str.endsWith(".jnilib"))
/*      */         return str.substring(0, str.lastIndexOf(".jnilib")) + ".dylib"; 
/*      */       return str;
/*      */     } 
/*      */     if (Platform.isLinux() || Platform.isFreeBSD()) {
/*      */       if (isVersionedName(paramString) || paramString.endsWith(".so"))
/*      */         return paramString; 
/*      */     } else if (Platform.isAIX()) {
/*      */       if (paramString.startsWith("lib"))
/*      */         return paramString; 
/*      */     } else if (Platform.isWindows() && (paramString.endsWith(".drv") || paramString.endsWith(".dll") || paramString.endsWith(".ocx"))) {
/*      */       return paramString;
/*      */     } 
/*      */     return System.mapLibraryName(paramString);
/*      */   }
/*      */   
/*      */   private static boolean isVersionedName(String paramString) {
/*      */     if (paramString.startsWith("lib")) {
/*      */       int i = paramString.lastIndexOf(".so.");
/*      */       if (i != -1 && i + 4 < paramString.length()) {
/*      */         for (int j = i + 4; j < paramString.length(); j++) {
/*      */           char c = paramString.charAt(j);
/*      */           if (!Character.isDigit(c) && c != '.')
/*      */             return false; 
/*      */         } 
/*      */         return true;
/*      */       } 
/*      */     } 
/*      */     return false;
/*      */   }
/*      */   
/*      */   static String matchLibrary(final String libName, Collection<String> paramCollection) {
/*      */     File file = new File(libName);
/*      */     if (file.isAbsolute())
/*      */       paramCollection = Arrays.asList(new String[] { file.getParent() }); 
/*      */     FilenameFilter filenameFilter = new FilenameFilter() {
/*      */         public boolean accept(File param1File, String param1String) {
/*      */           return ((param1String.startsWith("lib" + libName + ".so") || (param1String.startsWith(libName + ".so") && libName.startsWith("lib"))) && NativeLibrary.isVersionedName(param1String));
/*      */         }
/*      */       };
/*      */     LinkedList linkedList = new LinkedList();
/*      */     for (String str1 : paramCollection) {
/*      */       File[] arrayOfFile = (new File(str1)).listFiles(filenameFilter);
/*      */       if (arrayOfFile != null && arrayOfFile.length > 0)
/*      */         linkedList.addAll(Arrays.asList(arrayOfFile)); 
/*      */     } 
/*      */     double d = -1.0D;
/*      */     String str = null;
/*      */     for (File file1 : linkedList) {
/*      */       String str1 = file1.getAbsolutePath();
/*      */       String str2 = str1.substring(str1.lastIndexOf(".so.") + 4);
/*      */       double d1 = parseVersion(str2);
/*      */       if (d1 > d) {
/*      */         d = d1;
/*      */         str = str1;
/*      */       } 
/*      */     } 
/*      */     return str;
/*      */   }
/*      */   
/*      */   static double parseVersion(String paramString) {
/*      */     double d1 = 0.0D;
/*      */     double d2 = 1.0D;
/*      */     int i = paramString.indexOf(".");
/*      */     while (paramString != null) {
/*      */       String str;
/*      */       if (i != -1) {
/*      */         str = paramString.substring(0, i);
/*      */         paramString = paramString.substring(i + 1);
/*      */         i = paramString.indexOf(".");
/*      */       } else {
/*      */         str = paramString;
/*      */         paramString = null;
/*      */       } 
/*      */       try {
/*      */         d1 += Integer.parseInt(str) / d2;
/*      */       } catch (NumberFormatException numberFormatException) {
/*      */         return 0.0D;
/*      */       } 
/*      */       d2 *= 100.0D;
/*      */     } 
/*      */     return d1;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\NativeLibrary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */