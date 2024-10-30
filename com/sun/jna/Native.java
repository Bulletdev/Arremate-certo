/*      */ package com.sun.jna;
/*      */ 
/*      */ import java.awt.Component;
/*      */ import java.awt.GraphicsEnvironment;
/*      */ import java.awt.HeadlessException;
/*      */ import java.awt.Window;
/*      */ import java.io.File;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.FilenameFilter;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.lang.ref.Reference;
/*      */ import java.lang.ref.WeakReference;
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.InvocationHandler;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.lang.reflect.Proxy;
/*      */ import java.net.URI;
/*      */ import java.net.URISyntaxException;
/*      */ import java.net.URL;
/*      */ import java.net.URLClassLoader;
/*      */ import java.nio.Buffer;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.charset.Charset;
/*      */ import java.nio.charset.IllegalCharsetNameException;
/*      */ import java.nio.charset.UnsupportedCharsetException;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.StringTokenizer;
/*      */ import java.util.WeakHashMap;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class Native
/*      */   implements Version
/*      */ {
/*  114 */   private static final Logger LOG = Logger.getLogger(Native.class.getName());
/*      */   
/*  116 */   public static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
/*  117 */   public static final String DEFAULT_ENCODING = DEFAULT_CHARSET.name();
/*  118 */   public static final boolean DEBUG_LOAD = Boolean.getBoolean("jna.debug_load");
/*  119 */   public static final boolean DEBUG_JNA_LOAD = Boolean.getBoolean("jna.debug_load.jna");
/*  120 */   private static final Level DEBUG_JNA_LOAD_LEVEL = DEBUG_JNA_LOAD ? Level.INFO : Level.FINE;
/*      */ 
/*      */   
/*  123 */   static String jnidispatchPath = null;
/*  124 */   private static final Map<Class<?>, Map<String, Object>> typeOptions = Collections.synchronizedMap(new WeakHashMap<Class<?>, Map<String, Object>>());
/*  125 */   private static final Map<Class<?>, Reference<?>> libraries = Collections.synchronizedMap(new WeakHashMap<Class<?>, Reference<?>>()); private static final String _OPTION_ENCLOSING_LIBRARY = "enclosing-library";
/*      */   
/*  127 */   private static final Callback.UncaughtExceptionHandler DEFAULT_HANDLER = new Callback.UncaughtExceptionHandler()
/*      */     {
/*      */       public void uncaughtException(Callback param1Callback, Throwable param1Throwable)
/*      */       {
/*  131 */         Native.LOG.log(Level.WARNING, "JNA: Callback " + param1Callback + " threw the following exception", param1Throwable);
/*      */       }
/*      */     };
/*  134 */   private static Callback.UncaughtExceptionHandler callbackExceptionHandler = DEFAULT_HANDLER;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isCompatibleVersion(String paramString1, String paramString2) {
/*  172 */     String[] arrayOfString1 = paramString1.split("\\.");
/*  173 */     String[] arrayOfString2 = paramString2.split("\\.");
/*  174 */     if (arrayOfString1.length < 3 || arrayOfString2.length < 3) {
/*  175 */       return false;
/*      */     }
/*      */     
/*  178 */     int i = Integer.parseInt(arrayOfString1[0]);
/*  179 */     int j = Integer.parseInt(arrayOfString2[0]);
/*  180 */     int k = Integer.parseInt(arrayOfString1[1]);
/*  181 */     int m = Integer.parseInt(arrayOfString2[1]);
/*      */     
/*  183 */     if (i != j) {
/*  184 */       return false;
/*      */     }
/*      */     
/*  187 */     if (k > m) {
/*  188 */       return false;
/*      */     }
/*      */     
/*  191 */     return true;
/*      */   }
/*      */   
/*      */   static {
/*  195 */     loadNativeDispatchLibrary();
/*      */     
/*  197 */     if (!isCompatibleVersion("6.1.1", getNativeVersion())) {
/*  198 */       String str = System.getProperty("line.separator");
/*  199 */       throw new Error(str + str + "There is an incompatible JNA native library installed on this system" + str + "Expected: " + "6.1.1" + str + "Found:    " + 
/*      */ 
/*      */           
/*  202 */           getNativeVersion() + str + ((jnidispatchPath != null) ? ("(at " + jnidispatchPath + ")") : 
/*      */           
/*  204 */           System.getProperty("java.library.path")) + "." + str + "To resolve this issue you may do one of the following:" + str + " - remove or uninstall the offending library" + str + " - set the system property jna.nosys=true" + str + " - set jna.boot.library.path to include the path to the version of the " + str + "   jnidispatch library included with the JNA jar file you are using" + str);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  213 */   public static final int POINTER_SIZE = sizeof(0);
/*  214 */   public static final int LONG_SIZE = sizeof(1);
/*  215 */   public static final int WCHAR_SIZE = sizeof(2);
/*  216 */   public static final int SIZE_T_SIZE = sizeof(3);
/*  217 */   public static final int BOOL_SIZE = sizeof(4);
/*  218 */   public static final int LONG_DOUBLE_SIZE = sizeof(5); private static final int TYPE_VOIDP = 0; private static final int TYPE_LONG = 1; private static final int TYPE_WCHAR_T = 2; private static final int TYPE_SIZE_T = 3; private static final int TYPE_BOOL = 4;
/*      */   private static final int TYPE_LONG_DOUBLE = 5;
/*      */   
/*      */   static {
/*  222 */     initIDs();
/*  223 */     if (Boolean.getBoolean("jna.protected"))
/*  224 */       setProtected(true); 
/*      */   }
/*  226 */   static final int MAX_ALIGNMENT = (Platform.isSPARC() || Platform.isWindows() || (
/*  227 */     Platform.isLinux() && (Platform.isARM() || Platform.isPPC() || Platform.isMIPS())) || 
/*  228 */     Platform.isAIX() || (
/*  229 */     Platform.isAndroid() && !Platform.isIntel())) ? 8 : LONG_SIZE;
/*      */   
/*  231 */   static final int MAX_PADDING = (Platform.isMac() && Platform.isPPC()) ? 8 : MAX_ALIGNMENT; static {
/*  232 */     System.setProperty("jna.loaded", "true");
/*      */   }
/*      */ 
/*      */   
/*  236 */   private static final Object finalizer = new Object()
/*      */     {
/*      */       protected void finalize() throws Throwable {
/*  239 */         Native.dispose();
/*  240 */         super.finalize();
/*      */       }
/*      */     };
/*      */ 
/*      */   
/*      */   static final String JNA_TMPLIB_PREFIX = "jna";
/*      */ 
/*      */   
/*      */   private static void dispose() {
/*  249 */     CallbackReference.disposeAll();
/*  250 */     Memory.disposeAll();
/*  251 */     NativeLibrary.disposeAll();
/*  252 */     unregisterAll();
/*  253 */     jnidispatchPath = null;
/*  254 */     System.setProperty("jna.loaded", "false");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean deleteLibrary(File paramFile) {
/*  269 */     if (paramFile.delete()) {
/*  270 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  274 */     markTemporaryFile(paramFile);
/*      */     
/*  276 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getWindowID(Window paramWindow) throws HeadlessException {
/*  316 */     return AWT.getWindowID(paramWindow);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getComponentID(Component paramComponent) throws HeadlessException {
/*  326 */     return AWT.getComponentID(paramComponent);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Pointer getWindowPointer(Window paramWindow) throws HeadlessException {
/*  336 */     return new Pointer(AWT.getWindowID(paramWindow));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Pointer getComponentPointer(Component paramComponent) throws HeadlessException {
/*  346 */     return new Pointer(AWT.getComponentID(paramComponent));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Pointer getDirectBufferPointer(Buffer paramBuffer) {
/*  355 */     long l = _getDirectBufferPointer(paramBuffer);
/*  356 */     return (l == 0L) ? null : new Pointer(l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Charset getCharset(String paramString) {
/*  369 */     Charset charset = null;
/*  370 */     if (paramString != null) {
/*      */       try {
/*  372 */         charset = Charset.forName(paramString);
/*      */       }
/*  374 */       catch (IllegalCharsetNameException illegalCharsetNameException) {
/*  375 */         LOG.log(Level.WARNING, "JNA Warning: Encoding ''{0}'' is unsupported ({1})", new Object[] { paramString, illegalCharsetNameException
/*  376 */               .getMessage() });
/*      */       }
/*  378 */       catch (UnsupportedCharsetException unsupportedCharsetException) {
/*  379 */         LOG.log(Level.WARNING, "JNA Warning: Encoding ''{0}'' is unsupported ({1})", new Object[] { paramString, unsupportedCharsetException
/*  380 */               .getMessage() });
/*      */       } 
/*      */     }
/*  383 */     if (charset == null) {
/*  384 */       LOG.log(Level.WARNING, "JNA Warning: Using fallback encoding {0}", DEFAULT_CHARSET);
/*  385 */       charset = DEFAULT_CHARSET;
/*      */     } 
/*  387 */     return charset;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(byte[] paramArrayOfbyte) {
/*  399 */     return toString(paramArrayOfbyte, getDefaultStringEncoding());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(byte[] paramArrayOfbyte, String paramString) {
/*  416 */     return toString(paramArrayOfbyte, getCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(byte[] paramArrayOfbyte, Charset paramCharset) {
/*  432 */     int i = paramArrayOfbyte.length;
/*      */     
/*  434 */     for (byte b = 0; b < i; b++) {
/*  435 */       if (paramArrayOfbyte[b] == 0) {
/*  436 */         i = b;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*  441 */     if (i == 0) {
/*  442 */       return "";
/*      */     }
/*      */     
/*  445 */     return new String(paramArrayOfbyte, 0, i, paramCharset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(char[] paramArrayOfchar) {
/*  455 */     int i = paramArrayOfchar.length;
/*  456 */     for (byte b = 0; b < i; b++) {
/*  457 */       if (paramArrayOfchar[b] == '\000') {
/*  458 */         i = b;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*  463 */     if (i == 0) {
/*  464 */       return "";
/*      */     }
/*  466 */     return new String(paramArrayOfchar, 0, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> toStringList(char[] paramArrayOfchar) {
/*  480 */     return toStringList(paramArrayOfchar, 0, paramArrayOfchar.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> toStringList(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  494 */     ArrayList<String> arrayList = new ArrayList();
/*  495 */     int i = paramInt1;
/*  496 */     int j = paramInt1 + paramInt2;
/*  497 */     for (int k = paramInt1; k < j; k++) {
/*  498 */       if (paramArrayOfchar[k] == '\000') {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  503 */         if (i == k) {
/*  504 */           return arrayList;
/*      */         }
/*      */         
/*  507 */         String str = new String(paramArrayOfchar, i, k - i);
/*  508 */         arrayList.add(str);
/*  509 */         i = k + 1;
/*      */       } 
/*      */     } 
/*      */     
/*  513 */     if (i < j) {
/*  514 */       String str = new String(paramArrayOfchar, i, j - i);
/*  515 */       arrayList.add(str);
/*      */     } 
/*      */     
/*  518 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Library> T load(Class<T> paramClass) {
/*  533 */     return load((String)null, paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Library> T load(Class<T> paramClass, Map<String, ?> paramMap) {
/*  552 */     return load(null, paramClass, paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Library> T load(String paramString, Class<T> paramClass) {
/*  570 */     return load(paramString, paramClass, Collections.emptyMap());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Library> T load(String paramString, Class<T> paramClass, Map<String, ?> paramMap) {
/*  590 */     if (!Library.class.isAssignableFrom(paramClass))
/*      */     {
/*  592 */       throw new IllegalArgumentException("Interface (" + paramClass.getSimpleName() + ") of library=" + paramString + " does not extend " + Library.class
/*  593 */           .getSimpleName());
/*      */     }
/*      */     
/*  596 */     Library.Handler handler = new Library.Handler(paramString, paramClass, paramMap);
/*  597 */     ClassLoader classLoader = paramClass.getClassLoader();
/*  598 */     Object object = Proxy.newProxyInstance(classLoader, new Class[] { paramClass }, handler);
/*  599 */     cacheOptions(paramClass, paramMap, object);
/*  600 */     return paramClass.cast(object);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <T> T loadLibrary(Class<T> paramClass) {
/*  610 */     return loadLibrary((String)null, paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <T> T loadLibrary(Class<T> paramClass, Map<String, ?> paramMap) {
/*  620 */     return loadLibrary(null, paramClass, paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <T> T loadLibrary(String paramString, Class<T> paramClass) {
/*  630 */     return loadLibrary(paramString, paramClass, Collections.emptyMap());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <T> T loadLibrary(String paramString, Class<T> paramClass, Map<String, ?> paramMap) {
/*  640 */     if (!Library.class.isAssignableFrom(paramClass))
/*      */     {
/*  642 */       throw new IllegalArgumentException("Interface (" + paramClass.getSimpleName() + ") of library=" + paramString + " does not extend " + Library.class
/*  643 */           .getSimpleName());
/*      */     }
/*      */     
/*  646 */     Library.Handler handler = new Library.Handler(paramString, paramClass, paramMap);
/*  647 */     ClassLoader classLoader = paramClass.getClassLoader();
/*  648 */     Object object = Proxy.newProxyInstance(classLoader, new Class[] { paramClass }, handler);
/*  649 */     cacheOptions(paramClass, paramMap, object);
/*  650 */     return paramClass.cast(object);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void loadLibraryInstance(Class<?> paramClass) {
/*  659 */     if (paramClass != null && !libraries.containsKey(paramClass)) {
/*      */       try {
/*  661 */         Field[] arrayOfField = paramClass.getFields();
/*  662 */         for (byte b = 0; b < arrayOfField.length; b++) {
/*  663 */           Field field = arrayOfField[b];
/*  664 */           if (field.getType() == paramClass && 
/*  665 */             Modifier.isStatic(field.getModifiers())) {
/*      */             
/*  667 */             field.setAccessible(true);
/*  668 */             libraries.put(paramClass, new WeakReference(field.get((Object)null)));
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*  673 */       } catch (Exception exception) {
/*  674 */         throw new IllegalArgumentException("Could not access instance of " + paramClass + " (" + exception + ")");
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Class<?> findEnclosingLibraryClass(Class<?> paramClass) {
/*  688 */     if (paramClass == null) {
/*  689 */       return null;
/*      */     }
/*      */ 
/*      */     
/*  693 */     Map map = typeOptions.get(paramClass);
/*  694 */     if (map != null) {
/*  695 */       Class<?> clazz = (Class)map.get("enclosing-library");
/*  696 */       if (clazz != null) {
/*  697 */         return clazz;
/*      */       }
/*  699 */       return paramClass;
/*      */     } 
/*  701 */     if (Library.class.isAssignableFrom(paramClass)) {
/*  702 */       return paramClass;
/*      */     }
/*  704 */     if (Callback.class.isAssignableFrom(paramClass)) {
/*  705 */       paramClass = CallbackReference.findCallbackClass(paramClass);
/*      */     }
/*  707 */     Class<?> clazz1 = paramClass.getDeclaringClass();
/*  708 */     Class<?> clazz2 = findEnclosingLibraryClass(clazz1);
/*  709 */     if (clazz2 != null) {
/*  710 */       return clazz2;
/*      */     }
/*  712 */     return findEnclosingLibraryClass(paramClass.getSuperclass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Map<String, Object> getLibraryOptions(Class<?> paramClass) {
/*  731 */     Map<String, Object> map = typeOptions.get(paramClass);
/*  732 */     if (map != null) {
/*  733 */       return map;
/*      */     }
/*      */     
/*  736 */     Class<?> clazz = findEnclosingLibraryClass(paramClass);
/*  737 */     if (clazz != null) {
/*  738 */       loadLibraryInstance(clazz);
/*      */     } else {
/*  740 */       clazz = paramClass;
/*      */     } 
/*      */     
/*  743 */     map = typeOptions.get(clazz);
/*  744 */     if (map != null) {
/*  745 */       typeOptions.put(paramClass, map);
/*  746 */       return map;
/*      */     } 
/*      */     
/*      */     try {
/*  750 */       Field field = clazz.getField("OPTIONS");
/*  751 */       field.setAccessible(true);
/*  752 */       map = (Map<String, Object>)field.get((Object)null);
/*  753 */       if (map == null) {
/*  754 */         throw new IllegalStateException("Null options field");
/*      */       }
/*  756 */     } catch (NoSuchFieldException noSuchFieldException) {
/*  757 */       map = Collections.emptyMap();
/*  758 */     } catch (Exception exception) {
/*  759 */       throw new IllegalArgumentException("OPTIONS must be a public field of type java.util.Map (" + exception + "): " + clazz);
/*      */     } 
/*      */     
/*  762 */     map = new HashMap<String, Object>(map);
/*  763 */     if (!map.containsKey("type-mapper")) {
/*  764 */       map.put("type-mapper", lookupField(clazz, "TYPE_MAPPER", TypeMapper.class));
/*      */     }
/*  766 */     if (!map.containsKey("structure-alignment")) {
/*  767 */       map.put("structure-alignment", lookupField(clazz, "STRUCTURE_ALIGNMENT", Integer.class));
/*      */     }
/*  769 */     if (!map.containsKey("string-encoding")) {
/*  770 */       map.put("string-encoding", lookupField(clazz, "STRING_ENCODING", String.class));
/*      */     }
/*  772 */     map = cacheOptions(clazz, map, null);
/*      */     
/*  774 */     if (paramClass != clazz) {
/*  775 */       typeOptions.put(paramClass, map);
/*      */     }
/*  777 */     return map;
/*      */   }
/*      */   
/*      */   private static Object lookupField(Class<?> paramClass1, String paramString, Class<?> paramClass2) {
/*      */     try {
/*  782 */       Field field = paramClass1.getField(paramString);
/*  783 */       field.setAccessible(true);
/*  784 */       return field.get((Object)null);
/*      */     }
/*  786 */     catch (NoSuchFieldException noSuchFieldException) {
/*  787 */       return null;
/*      */     }
/*  789 */     catch (Exception exception) {
/*  790 */       throw new IllegalArgumentException(paramString + " must be a public field of type " + paramClass2
/*  791 */           .getName() + " (" + exception + "): " + paramClass1);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static TypeMapper getTypeMapper(Class<?> paramClass) {
/*  800 */     Map<String, Object> map = getLibraryOptions(paramClass);
/*  801 */     return (TypeMapper)map.get("type-mapper");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getStringEncoding(Class<?> paramClass) {
/*  811 */     Map<String, Object> map = getLibraryOptions(paramClass);
/*  812 */     String str = (String)map.get("string-encoding");
/*  813 */     return (str != null) ? str : getDefaultStringEncoding();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getDefaultStringEncoding() {
/*  821 */     return System.getProperty("jna.encoding", DEFAULT_ENCODING);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getStructureAlignment(Class<?> paramClass) {
/*  830 */     Integer integer = (Integer)getLibraryOptions(paramClass).get("structure-alignment");
/*  831 */     return (integer == null) ? 0 : integer.intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static byte[] getBytes(String paramString) {
/*  840 */     return getBytes(paramString, getDefaultStringEncoding());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static byte[] getBytes(String paramString1, String paramString2) {
/*  852 */     return getBytes(paramString1, getCharset(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static byte[] getBytes(String paramString, Charset paramCharset) {
/*  862 */     return paramString.getBytes(paramCharset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(String paramString) {
/*  872 */     return toByteArray(paramString, getDefaultStringEncoding());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(String paramString1, String paramString2) {
/*  884 */     return toByteArray(paramString1, getCharset(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(String paramString, Charset paramCharset) {
/*  895 */     byte[] arrayOfByte1 = getBytes(paramString, paramCharset);
/*  896 */     byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 1];
/*  897 */     System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
/*  898 */     return arrayOfByte2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static char[] toCharArray(String paramString) {
/*  906 */     char[] arrayOfChar1 = paramString.toCharArray();
/*  907 */     char[] arrayOfChar2 = new char[arrayOfChar1.length + 1];
/*  908 */     System.arraycopy(arrayOfChar1, 0, arrayOfChar2, 0, arrayOfChar1.length);
/*  909 */     return arrayOfChar2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void loadNativeDispatchLibrary() {
/*  918 */     if (!Boolean.getBoolean("jna.nounpack")) {
/*      */       try {
/*  920 */         removeTemporaryFiles();
/*      */       }
/*  922 */       catch (IOException iOException) {
/*  923 */         LOG.log(Level.WARNING, "JNA Warning: IOException removing temporary files", iOException);
/*      */       } 
/*      */     }
/*      */     
/*  927 */     String str1 = System.getProperty("jna.boot.library.name", "jnidispatch");
/*  928 */     String str2 = System.getProperty("jna.boot.library.path");
/*  929 */     if (str2 != null) {
/*      */       
/*  931 */       StringTokenizer stringTokenizer = new StringTokenizer(str2, File.pathSeparator);
/*  932 */       while (stringTokenizer.hasMoreTokens()) {
/*  933 */         String str4 = stringTokenizer.nextToken();
/*  934 */         File file = new File(new File(str4), System.mapLibraryName(str1).replace(".dylib", ".jnilib"));
/*  935 */         String str5 = file.getAbsolutePath();
/*  936 */         LOG.log(DEBUG_JNA_LOAD_LEVEL, "Looking in {0}", str5);
/*  937 */         if (file.exists()) {
/*      */           try {
/*  939 */             LOG.log(DEBUG_JNA_LOAD_LEVEL, "Trying {0}", str5);
/*  940 */             System.setProperty("jnidispatch.path", str5);
/*  941 */             System.load(str5);
/*  942 */             jnidispatchPath = str5;
/*  943 */             LOG.log(DEBUG_JNA_LOAD_LEVEL, "Found jnidispatch at {0}", str5);
/*      */             return;
/*  945 */           } catch (UnsatisfiedLinkError unsatisfiedLinkError) {}
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  951 */         if (Platform.isMac()) {
/*      */           String str6, str7;
/*  953 */           if (str5.endsWith("dylib")) {
/*  954 */             str6 = "dylib";
/*  955 */             str7 = "jnilib";
/*      */           } else {
/*  957 */             str6 = "jnilib";
/*  958 */             str7 = "dylib";
/*      */           } 
/*  960 */           str5 = str5.substring(0, str5.lastIndexOf(str6)) + str7;
/*  961 */           LOG.log(DEBUG_JNA_LOAD_LEVEL, "Looking in {0}", str5);
/*  962 */           if ((new File(str5)).exists()) {
/*      */             try {
/*  964 */               LOG.log(DEBUG_JNA_LOAD_LEVEL, "Trying {0}", str5);
/*  965 */               System.setProperty("jnidispatch.path", str5);
/*  966 */               System.load(str5);
/*  967 */               jnidispatchPath = str5;
/*  968 */               LOG.log(DEBUG_JNA_LOAD_LEVEL, "Found jnidispatch at {0}", str5);
/*      */               return;
/*  970 */             } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  971 */               LOG.log(Level.WARNING, "File found at " + str5 + " but not loadable: " + unsatisfiedLinkError.getMessage(), unsatisfiedLinkError);
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*  977 */     String str3 = System.getProperty("jna.nosys", "true");
/*  978 */     if (!Boolean.parseBoolean(str3) || Platform.isAndroid()) {
/*      */       try {
/*  980 */         LOG.log(DEBUG_JNA_LOAD_LEVEL, "Trying (via loadLibrary) {0}", str1);
/*  981 */         System.loadLibrary(str1);
/*  982 */         LOG.log(DEBUG_JNA_LOAD_LEVEL, "Found jnidispatch on system path");
/*      */         
/*      */         return;
/*  985 */       } catch (UnsatisfiedLinkError unsatisfiedLinkError) {}
/*      */     }
/*      */     
/*  988 */     if (!Boolean.getBoolean("jna.noclasspath")) {
/*  989 */       loadNativeDispatchLibraryFromClasspath();
/*      */     } else {
/*      */       
/*  992 */       throw new UnsatisfiedLinkError("Unable to locate JNA native support library");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void loadNativeDispatchLibraryFromClasspath() {
/*      */     try {
/* 1003 */       String str1 = System.mapLibraryName("jnidispatch").replace(".dylib", ".jnilib");
/* 1004 */       if (Platform.isAIX())
/*      */       {
/*      */         
/* 1007 */         str1 = "libjnidispatch.a";
/*      */       }
/* 1009 */       String str2 = "/com/sun/jna/" + Platform.RESOURCE_PREFIX + "/" + str1;
/* 1010 */       File file = extractFromResourcePath(str2, Native.class.getClassLoader());
/* 1011 */       if (file == null && 
/* 1012 */         file == null) {
/* 1013 */         throw new UnsatisfiedLinkError("Could not find JNA native support");
/*      */       }
/*      */ 
/*      */       
/* 1017 */       LOG.log(DEBUG_JNA_LOAD_LEVEL, "Trying {0}", file.getAbsolutePath());
/* 1018 */       System.setProperty("jnidispatch.path", file.getAbsolutePath());
/* 1019 */       System.load(file.getAbsolutePath());
/* 1020 */       jnidispatchPath = file.getAbsolutePath();
/* 1021 */       LOG.log(DEBUG_JNA_LOAD_LEVEL, "Found jnidispatch at {0}", jnidispatchPath);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1027 */       if (isUnpacked(file) && 
/* 1028 */         !Boolean.getBoolean("jnidispatch.preserve")) {
/* 1029 */         deleteLibrary(file);
/*      */       }
/*      */     }
/* 1032 */     catch (IOException iOException) {
/* 1033 */       throw new UnsatisfiedLinkError(iOException.getMessage());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   static boolean isUnpacked(File paramFile) {
/* 1039 */     return paramFile.getName().startsWith("jna");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File extractFromResourcePath(String paramString) throws IOException {
/* 1054 */     return extractFromResourcePath(paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File extractFromResourcePath(String paramString, ClassLoader paramClassLoader) throws IOException {
/* 1072 */     Level level = (DEBUG_LOAD || (DEBUG_JNA_LOAD && paramString.contains("jnidispatch"))) ? Level.INFO : Level.FINE;
/* 1073 */     if (paramClassLoader == null) {
/* 1074 */       paramClassLoader = Thread.currentThread().getContextClassLoader();
/*      */       
/* 1076 */       if (paramClassLoader == null) {
/* 1077 */         paramClassLoader = Native.class.getClassLoader();
/*      */       }
/*      */     } 
/* 1080 */     LOG.log(level, "Looking in classpath from {0} for {1}", new Object[] { paramClassLoader, paramString });
/* 1081 */     String str1 = paramString.startsWith("/") ? paramString : NativeLibrary.mapSharedLibraryName(paramString);
/* 1082 */     String str2 = paramString.startsWith("/") ? paramString : (Platform.RESOURCE_PREFIX + "/" + str1);
/* 1083 */     if (str2.startsWith("/")) {
/* 1084 */       str2 = str2.substring(1);
/*      */     }
/* 1086 */     URL uRL = paramClassLoader.getResource(str2);
/* 1087 */     if (uRL == null) {
/* 1088 */       if (str2.startsWith(Platform.RESOURCE_PREFIX)) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1093 */         if (Platform.RESOURCE_PREFIX.startsWith("darwin")) {
/* 1094 */           uRL = paramClassLoader.getResource("darwin/" + str2.substring(Platform.RESOURCE_PREFIX.length() + 1));
/*      */         }
/* 1096 */         if (uRL == null)
/*      */         {
/* 1098 */           uRL = paramClassLoader.getResource(str1);
/*      */         }
/* 1100 */       } else if (str2.startsWith("com/sun/jna/" + Platform.RESOURCE_PREFIX + "/")) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1105 */         if (Platform.RESOURCE_PREFIX.startsWith("com/sun/jna/darwin")) {
/* 1106 */           uRL = paramClassLoader.getResource("com/sun/jna/darwin" + str2.substring(("com/sun/jna/" + Platform.RESOURCE_PREFIX).length() + 1));
/*      */         }
/* 1108 */         if (uRL == null)
/*      */         {
/* 1110 */           uRL = paramClassLoader.getResource(str1);
/*      */         }
/*      */       } 
/*      */     }
/* 1114 */     if (uRL == null) {
/* 1115 */       String str = System.getProperty("java.class.path");
/* 1116 */       if (paramClassLoader instanceof URLClassLoader) {
/* 1117 */         str = Arrays.<URL>asList(((URLClassLoader)paramClassLoader).getURLs()).toString();
/*      */       }
/* 1119 */       throw new IOException("Native library (" + str2 + ") not found in resource path (" + str + ")");
/*      */     } 
/* 1121 */     LOG.log(level, "Found library resource at {0}", uRL);
/*      */     
/* 1123 */     File file = null;
/* 1124 */     if (uRL.getProtocol().toLowerCase().equals("file")) {
/*      */       try {
/* 1126 */         file = new File(new URI(uRL.toString()));
/*      */       }
/* 1128 */       catch (URISyntaxException uRISyntaxException) {
/* 1129 */         file = new File(uRL.getPath());
/*      */       } 
/* 1131 */       LOG.log(level, "Looking in {0}", file.getAbsolutePath());
/* 1132 */       if (!file.exists()) {
/* 1133 */         throw new IOException("File URL " + uRL + " could not be properly decoded");
/*      */       }
/*      */     }
/* 1136 */     else if (!Boolean.getBoolean("jna.nounpack")) {
/* 1137 */       InputStream inputStream = uRL.openStream();
/* 1138 */       if (inputStream == null) {
/* 1139 */         throw new IOException("Can't obtain InputStream for " + str2);
/*      */       }
/*      */       
/* 1142 */       FileOutputStream fileOutputStream = null;
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/* 1147 */         File file1 = getTempDir();
/* 1148 */         file = File.createTempFile("jna", Platform.isWindows() ? ".dll" : null, file1);
/* 1149 */         if (!Boolean.getBoolean("jnidispatch.preserve")) {
/* 1150 */           file.deleteOnExit();
/*      */         }
/* 1152 */         LOG.log(level, "Extracting library to {0}", file.getAbsolutePath());
/* 1153 */         fileOutputStream = new FileOutputStream(file);
/*      */         
/* 1155 */         byte[] arrayOfByte = new byte[1024]; int i;
/* 1156 */         while ((i = inputStream.read(arrayOfByte, 0, arrayOfByte.length)) > 0) {
/* 1157 */           fileOutputStream.write(arrayOfByte, 0, i);
/*      */         }
/*      */       }
/* 1160 */       catch (IOException iOException) {
/* 1161 */         throw new IOException("Failed to create temporary file for " + paramString + " library: " + iOException.getMessage());
/*      */       } finally {
/*      */         
/* 1164 */         try { inputStream.close(); } catch (IOException iOException) {}
/* 1165 */         if (fileOutputStream != null) {
/* 1166 */           try { fileOutputStream.close(); } catch (IOException iOException) {}
/*      */         }
/*      */       } 
/*      */     } 
/* 1170 */     return file;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Library synchronizedLibrary(final Library library) {
/* 1213 */     Class<?> clazz = library.getClass();
/* 1214 */     if (!Proxy.isProxyClass(clazz)) {
/* 1215 */       throw new IllegalArgumentException("Library must be a proxy class");
/*      */     }
/* 1217 */     InvocationHandler invocationHandler1 = Proxy.getInvocationHandler(library);
/* 1218 */     if (!(invocationHandler1 instanceof Library.Handler)) {
/* 1219 */       throw new IllegalArgumentException("Unrecognized proxy handler: " + invocationHandler1);
/*      */     }
/* 1221 */     final Library.Handler handler = (Library.Handler)invocationHandler1;
/* 1222 */     InvocationHandler invocationHandler2 = new InvocationHandler()
/*      */       {
/*      */         public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
/* 1225 */           synchronized (handler.getNativeLibrary()) {
/* 1226 */             return handler.invoke(library, param1Method, param1ArrayOfObject);
/*      */           } 
/*      */         }
/*      */       };
/* 1230 */     return (Library)Proxy.newProxyInstance(clazz.getClassLoader(), clazz
/* 1231 */         .getInterfaces(), invocationHandler2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getWebStartLibraryPath(String paramString) {
/* 1251 */     if (System.getProperty("javawebstart.version") == null) {
/* 1252 */       return null;
/*      */     }
/*      */     try {
/* 1255 */       ClassLoader classLoader = Native.class.getClassLoader();
/* 1256 */       Method method = AccessController.<Method>doPrivileged(new PrivilegedAction<Method>()
/*      */           {
/*      */             public Method run() {
/*      */               try {
/* 1260 */                 Method method = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class });
/* 1261 */                 method.setAccessible(true);
/* 1262 */                 return method;
/*      */               }
/* 1264 */               catch (Exception exception) {
/* 1265 */                 return null;
/*      */               } 
/*      */             }
/*      */           });
/* 1269 */       String str = (String)method.invoke(classLoader, new Object[] { paramString });
/* 1270 */       if (str != null) {
/* 1271 */         return (new File(str)).getParent();
/*      */       }
/* 1273 */       return null;
/*      */     }
/* 1275 */     catch (Exception exception) {
/* 1276 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void markTemporaryFile(File paramFile) {
/*      */     try {
/* 1286 */       File file = new File(paramFile.getParentFile(), paramFile.getName() + ".x");
/* 1287 */       file.createNewFile();
/*      */     } catch (IOException iOException) {
/* 1289 */       iOException.printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static File getTempDir() throws IOException {
/*      */     File file;
/* 1297 */     String str = System.getProperty("jna.tmpdir");
/* 1298 */     if (str != null) {
/* 1299 */       file = new File(str);
/* 1300 */       file.mkdirs();
/*      */     } else {
/*      */       
/* 1303 */       File file1 = new File(System.getProperty("java.io.tmpdir"));
/* 1304 */       if (Platform.isMac()) {
/*      */         
/* 1306 */         file = new File(System.getProperty("user.home"), "Library/Caches/JNA/temp");
/* 1307 */       } else if (Platform.isLinux() || Platform.isSolaris() || Platform.isAIX() || Platform.isFreeBSD() || Platform.isNetBSD() || Platform.isOpenBSD() || Platform.iskFreeBSD()) {
/*      */         File file2;
/*      */         
/* 1310 */         String str1 = System.getenv("XDG_CACHE_HOME");
/*      */         
/* 1312 */         if (str1 == null || str1.trim().isEmpty()) {
/* 1313 */           file2 = new File(System.getProperty("user.home"), ".cache");
/*      */         } else {
/* 1315 */           file2 = new File(str1);
/*      */         } 
/* 1317 */         file = new File(file2, "JNA/temp");
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 1322 */         file = new File(file1, "jna-" + System.getProperty("user.name").hashCode());
/*      */       } 
/*      */       
/* 1325 */       file.mkdirs();
/* 1326 */       if (!file.exists() || !file.canWrite()) {
/* 1327 */         file = file1;
/*      */       }
/*      */     } 
/* 1330 */     if (!file.exists()) {
/* 1331 */       throw new IOException("JNA temporary directory '" + file + "' does not exist");
/*      */     }
/* 1333 */     if (!file.canWrite()) {
/* 1334 */       throw new IOException("JNA temporary directory '" + file + "' is not writable");
/*      */     }
/* 1336 */     return file;
/*      */   }
/*      */ 
/*      */   
/*      */   static void removeTemporaryFiles() throws IOException {
/* 1341 */     File file = getTempDir();
/* 1342 */     FilenameFilter filenameFilter = new FilenameFilter()
/*      */       {
/*      */         public boolean accept(File param1File, String param1String) {
/* 1345 */           return (param1String.endsWith(".x") && param1String.startsWith("jna"));
/*      */         }
/*      */       };
/* 1348 */     File[] arrayOfFile = file.listFiles(filenameFilter);
/* 1349 */     for (byte b = 0; arrayOfFile != null && b < arrayOfFile.length; b++) {
/* 1350 */       File file1 = arrayOfFile[b];
/* 1351 */       String str = file1.getName();
/* 1352 */       str = str.substring(0, str.length() - 2);
/* 1353 */       File file2 = new File(file1.getParentFile(), str);
/* 1354 */       if (!file2.exists() || file2.delete()) {
/* 1355 */         file1.delete();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getNativeSize(Class<?> paramClass, Object paramObject) {
/* 1367 */     if (paramClass.isArray()) {
/* 1368 */       int i = Array.getLength(paramObject);
/* 1369 */       if (i > 0) {
/* 1370 */         Object object = Array.get(paramObject, 0);
/* 1371 */         return i * getNativeSize(paramClass.getComponentType(), object);
/*      */       } 
/*      */       
/* 1374 */       throw new IllegalArgumentException("Arrays of length zero not allowed: " + paramClass);
/*      */     } 
/* 1376 */     if (Structure.class.isAssignableFrom(paramClass) && 
/* 1377 */       !Structure.ByReference.class.isAssignableFrom(paramClass)) {
/* 1378 */       return Structure.size(paramClass, paramObject);
/*      */     }
/*      */     try {
/* 1381 */       return getNativeSize(paramClass);
/*      */     }
/* 1383 */     catch (IllegalArgumentException illegalArgumentException) {
/* 1384 */       throw new IllegalArgumentException("The type \"" + paramClass.getName() + "\" is not supported: " + illegalArgumentException
/*      */           
/* 1386 */           .getMessage());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getNativeSize(Class<?> paramClass) {
/* 1399 */     if (NativeMapped.class.isAssignableFrom(paramClass)) {
/* 1400 */       paramClass = NativeMappedConverter.getInstance(paramClass).nativeType();
/*      */     }
/*      */     
/* 1403 */     if (paramClass == boolean.class || paramClass == Boolean.class) return 4; 
/* 1404 */     if (paramClass == byte.class || paramClass == Byte.class) return 1; 
/* 1405 */     if (paramClass == short.class || paramClass == Short.class) return 2; 
/* 1406 */     if (paramClass == char.class || paramClass == Character.class) return WCHAR_SIZE; 
/* 1407 */     if (paramClass == int.class || paramClass == Integer.class) return 4; 
/* 1408 */     if (paramClass == long.class || paramClass == Long.class) return 8; 
/* 1409 */     if (paramClass == float.class || paramClass == Float.class) return 4; 
/* 1410 */     if (paramClass == double.class || paramClass == Double.class) return 8; 
/* 1411 */     if (Structure.class.isAssignableFrom(paramClass)) {
/* 1412 */       if (Structure.ByValue.class.isAssignableFrom(paramClass)) {
/* 1413 */         return Structure.size((Class)paramClass);
/*      */       }
/* 1415 */       return POINTER_SIZE;
/*      */     } 
/* 1417 */     if (Pointer.class.isAssignableFrom(paramClass) || (Platform.HAS_BUFFERS && 
/* 1418 */       Buffers.isBuffer(paramClass)) || Callback.class
/* 1419 */       .isAssignableFrom(paramClass) || String.class == paramClass || WString.class == paramClass)
/*      */     {
/*      */       
/* 1422 */       return POINTER_SIZE;
/*      */     }
/* 1424 */     throw new IllegalArgumentException("Native size for type \"" + paramClass.getName() + "\" is unknown");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSupportedNativeType(Class<?> paramClass) {
/* 1433 */     if (Structure.class.isAssignableFrom(paramClass)) {
/* 1434 */       return true;
/*      */     }
/*      */     try {
/* 1437 */       return (getNativeSize(paramClass) != 0);
/*      */     }
/* 1439 */     catch (IllegalArgumentException illegalArgumentException) {
/* 1440 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setCallbackExceptionHandler(Callback.UncaughtExceptionHandler paramUncaughtExceptionHandler) {
/* 1452 */     callbackExceptionHandler = (paramUncaughtExceptionHandler == null) ? DEFAULT_HANDLER : paramUncaughtExceptionHandler;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Callback.UncaughtExceptionHandler getCallbackExceptionHandler() {
/* 1457 */     return callbackExceptionHandler;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void register(String paramString) {
/* 1467 */     register(findDirectMappedClass(getCallingClass()), paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void register(NativeLibrary paramNativeLibrary) {
/* 1477 */     register(findDirectMappedClass(getCallingClass()), paramNativeLibrary);
/*      */   }
/*      */ 
/*      */   
/*      */   static Class<?> findDirectMappedClass(Class<?> paramClass) {
/* 1482 */     Method[] arrayOfMethod = paramClass.getDeclaredMethods();
/* 1483 */     for (Method method : arrayOfMethod) {
/* 1484 */       if ((method.getModifiers() & 0x100) != 0) {
/* 1485 */         return paramClass;
/*      */       }
/*      */     } 
/* 1488 */     int i = paramClass.getName().lastIndexOf("$");
/* 1489 */     if (i != -1) {
/* 1490 */       String str = paramClass.getName().substring(0, i);
/*      */       try {
/* 1492 */         return findDirectMappedClass(Class.forName(str, true, paramClass.getClassLoader()));
/* 1493 */       } catch (ClassNotFoundException classNotFoundException) {}
/*      */     } 
/*      */ 
/*      */     
/* 1497 */     throw new IllegalArgumentException("Can't determine class with native methods from the current context (" + paramClass + ")");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Class<?> getCallingClass() {
/* 1509 */     Class[] arrayOfClass = (new SecurityManager() { public Class<?>[] getClassContext() { return super.getClassContext(); } }).getClassContext();
/* 1510 */     if (arrayOfClass == null) {
/* 1511 */       throw new IllegalStateException("The SecurityManager implementation on this platform is broken; you must explicitly provide the class to register");
/*      */     }
/* 1513 */     if (arrayOfClass.length < 4) {
/* 1514 */       throw new IllegalStateException("This method must be called from the static initializer of a class");
/*      */     }
/* 1516 */     return arrayOfClass[3];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setCallbackThreadInitializer(Callback paramCallback, CallbackThreadInitializer paramCallbackThreadInitializer) {
/* 1526 */     CallbackReference.setCallbackThreadInitializer(paramCallback, paramCallbackThreadInitializer);
/*      */   }
/*      */   
/* 1529 */   private static final Map<Class<?>, long[]> registeredClasses = (Map)new WeakHashMap<Class<?>, long>();
/* 1530 */   private static final Map<Class<?>, NativeLibrary> registeredLibraries = new WeakHashMap<Class<?>, NativeLibrary>(); static final int CB_HAS_INITIALIZER = 1; private static final int CVT_UNSUPPORTED = -1; private static final int CVT_DEFAULT = 0; private static final int CVT_POINTER = 1; private static final int CVT_STRING = 2; private static final int CVT_STRUCTURE = 3; private static final int CVT_STRUCTURE_BYVAL = 4; private static final int CVT_BUFFER = 5; private static final int CVT_ARRAY_BYTE = 6; private static final int CVT_ARRAY_SHORT = 7; private static final int CVT_ARRAY_CHAR = 8; private static final int CVT_ARRAY_INT = 9; private static final int CVT_ARRAY_LONG = 10; private static final int CVT_ARRAY_FLOAT = 11; private static final int CVT_ARRAY_DOUBLE = 12; private static final int CVT_ARRAY_BOOLEAN = 13; private static final int CVT_BOOLEAN = 14; private static final int CVT_CALLBACK = 15; private static final int CVT_FLOAT = 16; private static final int CVT_NATIVE_MAPPED = 17; private static final int CVT_NATIVE_MAPPED_STRING = 18; private static final int CVT_NATIVE_MAPPED_WSTRING = 19; private static final int CVT_WSTRING = 20; private static final int CVT_INTEGER_TYPE = 21; private static final int CVT_POINTER_TYPE = 22; private static final int CVT_TYPE_MAPPER = 23; private static final int CVT_TYPE_MAPPER_STRING = 24; private static final int CVT_TYPE_MAPPER_WSTRING = 25; private static final int CVT_OBJECT = 26; private static final int CVT_JNIENV = 27; static final int CB_OPTION_DIRECT = 1; static final int CB_OPTION_IN_DLL = 2;
/*      */   
/*      */   private static void unregisterAll() {
/* 1533 */     synchronized (registeredClasses) {
/* 1534 */       for (Map.Entry<Class<?>, long> entry : registeredClasses.entrySet()) {
/* 1535 */         unregister((Class)entry.getKey(), (long[])entry.getValue());
/*      */       }
/*      */       
/* 1538 */       registeredClasses.clear();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void unregister() {
/* 1547 */     unregister(findDirectMappedClass(getCallingClass()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void unregister(Class<?> paramClass) {
/* 1555 */     synchronized (registeredClasses) {
/* 1556 */       long[] arrayOfLong = registeredClasses.get(paramClass);
/* 1557 */       if (arrayOfLong != null) {
/* 1558 */         unregister(paramClass, arrayOfLong);
/* 1559 */         registeredClasses.remove(paramClass);
/* 1560 */         registeredLibraries.remove(paramClass);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean registered(Class<?> paramClass) {
/* 1570 */     synchronized (registeredClasses) {
/* 1571 */       return registeredClasses.containsKey(paramClass);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String getSignature(Class<?> paramClass) {
/* 1579 */     if (paramClass.isArray()) {
/* 1580 */       return "[" + getSignature(paramClass.getComponentType());
/*      */     }
/* 1582 */     if (paramClass.isPrimitive()) {
/* 1583 */       if (paramClass == void.class) return "V"; 
/* 1584 */       if (paramClass == boolean.class) return "Z"; 
/* 1585 */       if (paramClass == byte.class) return "B"; 
/* 1586 */       if (paramClass == short.class) return "S"; 
/* 1587 */       if (paramClass == char.class) return "C"; 
/* 1588 */       if (paramClass == int.class) return "I"; 
/* 1589 */       if (paramClass == long.class) return "J"; 
/* 1590 */       if (paramClass == float.class) return "F"; 
/* 1591 */       if (paramClass == double.class) return "D"; 
/*      */     } 
/* 1593 */     return "L" + replace(".", "/", paramClass.getName()) + ";";
/*      */   }
/*      */ 
/*      */   
/*      */   static String replace(String paramString1, String paramString2, String paramString3) {
/* 1598 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     while (true) {
/* 1600 */       int i = paramString3.indexOf(paramString1);
/* 1601 */       if (i == -1) {
/* 1602 */         stringBuilder.append(paramString3);
/*      */         
/*      */         break;
/*      */       } 
/* 1606 */       stringBuilder.append(paramString3.substring(0, i));
/* 1607 */       stringBuilder.append(paramString2);
/* 1608 */       paramString3 = paramString3.substring(i + paramString1.length());
/*      */     } 
/*      */     
/* 1611 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int getConversion(Class<?> paramClass, TypeMapper paramTypeMapper, boolean paramBoolean) {
/* 1648 */     if (paramClass == Void.class) paramClass = void.class;
/*      */     
/* 1650 */     if (paramTypeMapper != null) {
/* 1651 */       FromNativeConverter fromNativeConverter = paramTypeMapper.getFromNativeConverter(paramClass);
/* 1652 */       ToNativeConverter toNativeConverter = paramTypeMapper.getToNativeConverter(paramClass);
/* 1653 */       if (fromNativeConverter != null) {
/* 1654 */         Class<?> clazz = fromNativeConverter.nativeType();
/* 1655 */         if (clazz == String.class) {
/* 1656 */           return 24;
/*      */         }
/* 1658 */         if (clazz == WString.class) {
/* 1659 */           return 25;
/*      */         }
/* 1661 */         return 23;
/*      */       } 
/* 1663 */       if (toNativeConverter != null) {
/* 1664 */         Class<?> clazz = toNativeConverter.nativeType();
/* 1665 */         if (clazz == String.class) {
/* 1666 */           return 24;
/*      */         }
/* 1668 */         if (clazz == WString.class) {
/* 1669 */           return 25;
/*      */         }
/* 1671 */         return 23;
/*      */       } 
/*      */     } 
/*      */     
/* 1675 */     if (Pointer.class.isAssignableFrom(paramClass)) {
/* 1676 */       return 1;
/*      */     }
/* 1678 */     if (String.class == paramClass) {
/* 1679 */       return 2;
/*      */     }
/* 1681 */     if (WString.class.isAssignableFrom(paramClass)) {
/* 1682 */       return 20;
/*      */     }
/* 1684 */     if (Platform.HAS_BUFFERS && Buffers.isBuffer(paramClass)) {
/* 1685 */       return 5;
/*      */     }
/* 1687 */     if (Structure.class.isAssignableFrom(paramClass)) {
/* 1688 */       if (Structure.ByValue.class.isAssignableFrom(paramClass)) {
/* 1689 */         return 4;
/*      */       }
/* 1691 */       return 3;
/*      */     } 
/* 1693 */     if (paramClass.isArray()) {
/* 1694 */       switch (paramClass.getName().charAt(1)) { case 'Z':
/* 1695 */           return 13;
/* 1696 */         case 'B': return 6;
/* 1697 */         case 'S': return 7;
/* 1698 */         case 'C': return 8;
/* 1699 */         case 'I': return 9;
/* 1700 */         case 'J': return 10;
/* 1701 */         case 'F': return 11;
/* 1702 */         case 'D': return 12; }
/*      */ 
/*      */     
/*      */     }
/* 1706 */     if (paramClass.isPrimitive()) {
/* 1707 */       return (paramClass == boolean.class) ? 14 : 0;
/*      */     }
/* 1709 */     if (Callback.class.isAssignableFrom(paramClass)) {
/* 1710 */       return 15;
/*      */     }
/* 1712 */     if (IntegerType.class.isAssignableFrom(paramClass)) {
/* 1713 */       return 21;
/*      */     }
/* 1715 */     if (PointerType.class.isAssignableFrom(paramClass)) {
/* 1716 */       return 22;
/*      */     }
/* 1718 */     if (NativeMapped.class.isAssignableFrom(paramClass)) {
/* 1719 */       Class<?> clazz = NativeMappedConverter.getInstance(paramClass).nativeType();
/* 1720 */       if (clazz == String.class) {
/* 1721 */         return 18;
/*      */       }
/* 1723 */       if (clazz == WString.class) {
/* 1724 */         return 19;
/*      */       }
/* 1726 */       return 17;
/*      */     } 
/* 1728 */     if (JNIEnv.class == paramClass) {
/* 1729 */       return 27;
/*      */     }
/* 1731 */     return paramBoolean ? 26 : -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void register(Class<?> paramClass, String paramString) {
/* 1746 */     NativeLibrary nativeLibrary = NativeLibrary.getInstance(paramString, Collections.singletonMap("classloader", paramClass.getClassLoader()));
/* 1747 */     register(paramClass, nativeLibrary);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void register(Class<?> paramClass, NativeLibrary paramNativeLibrary) {
/* 1760 */     Method[] arrayOfMethod = paramClass.getDeclaredMethods();
/* 1761 */     ArrayList<Method> arrayList = new ArrayList();
/* 1762 */     Map<String, ?> map = paramNativeLibrary.getOptions();
/* 1763 */     TypeMapper typeMapper = (TypeMapper)map.get("type-mapper");
/* 1764 */     boolean bool = Boolean.TRUE.equals(map.get("allow-objects"));
/* 1765 */     map = cacheOptions(paramClass, map, null);
/*      */     
/* 1767 */     for (Method method : arrayOfMethod) {
/* 1768 */       if ((method.getModifiers() & 0x100) != 0) {
/* 1769 */         arrayList.add(method);
/*      */       }
/*      */     } 
/*      */     
/* 1773 */     long[] arrayOfLong = new long[arrayList.size()];
/* 1774 */     for (byte b = 0; b < arrayOfLong.length; b++) {
/* 1775 */       long l1, l2; Method method = arrayList.get(b);
/* 1776 */       String str = "(";
/* 1777 */       Class<?> clazz = method.getReturnType();
/*      */       
/* 1779 */       Class[] arrayOfClass1 = method.getParameterTypes();
/* 1780 */       long[] arrayOfLong1 = new long[arrayOfClass1.length];
/* 1781 */       long[] arrayOfLong2 = new long[arrayOfClass1.length];
/* 1782 */       int[] arrayOfInt = new int[arrayOfClass1.length];
/* 1783 */       ToNativeConverter[] arrayOfToNativeConverter = new ToNativeConverter[arrayOfClass1.length];
/* 1784 */       FromNativeConverter fromNativeConverter = null;
/* 1785 */       int i = getConversion(clazz, typeMapper, bool);
/* 1786 */       boolean bool1 = false;
/* 1787 */       switch (i) {
/*      */         case -1:
/* 1789 */           throw new IllegalArgumentException(clazz + " is not a supported return type (in method " + method.getName() + " in " + paramClass + ")");
/*      */         case 23:
/*      */         case 24:
/*      */         case 25:
/* 1793 */           fromNativeConverter = typeMapper.getFromNativeConverter(clazz);
/*      */ 
/*      */ 
/*      */           
/* 1797 */           l2 = (Structure.FFIType.get(clazz.isPrimitive() ? clazz : Pointer.class).getPointer()).peer;
/* 1798 */           l1 = (Structure.FFIType.get(fromNativeConverter.nativeType()).getPointer()).peer;
/*      */           break;
/*      */         case 17:
/*      */         case 18:
/*      */         case 19:
/*      */         case 21:
/*      */         case 22:
/* 1805 */           l2 = (Structure.FFIType.get(Pointer.class).getPointer()).peer;
/* 1806 */           l1 = (Structure.FFIType.get(NativeMappedConverter.getInstance(clazz).nativeType()).getPointer()).peer;
/*      */           break;
/*      */         case 3:
/*      */         case 26:
/* 1810 */           l2 = l1 = (Structure.FFIType.get(Pointer.class).getPointer()).peer;
/*      */         
/*      */         case 4:
/* 1813 */           l2 = (Structure.FFIType.get(Pointer.class).getPointer()).peer;
/* 1814 */           l1 = (Structure.FFIType.get(clazz).getPointer()).peer;
/*      */           break;
/*      */         default:
/* 1817 */           l2 = l1 = (Structure.FFIType.get(clazz).getPointer()).peer;
/*      */           break;
/*      */       } 
/* 1820 */       for (byte b1 = 0; b1 < arrayOfClass1.length; b1++) {
/* 1821 */         Class<?> clazz1 = arrayOfClass1[b1];
/* 1822 */         str = str + getSignature(clazz1);
/* 1823 */         int j = getConversion(clazz1, typeMapper, bool);
/* 1824 */         arrayOfInt[b1] = j;
/* 1825 */         if (j == -1) {
/* 1826 */           throw new IllegalArgumentException(clazz1 + " is not a supported argument type (in method " + method.getName() + " in " + paramClass + ")");
/*      */         }
/* 1828 */         if (j == 17 || j == 18 || j == 19 || j == 21) {
/*      */ 
/*      */ 
/*      */           
/* 1832 */           clazz1 = NativeMappedConverter.getInstance(clazz1).nativeType();
/* 1833 */         } else if (j == 23 || j == 24 || j == 25) {
/*      */ 
/*      */           
/* 1836 */           arrayOfToNativeConverter[b1] = typeMapper.getToNativeConverter(clazz1);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1842 */         switch (j) {
/*      */           case 4:
/*      */           case 17:
/*      */           case 18:
/*      */           case 19:
/*      */           case 21:
/*      */           case 22:
/* 1849 */             arrayOfLong1[b1] = (Structure.FFIType.get(clazz1).getPointer()).peer;
/* 1850 */             arrayOfLong2[b1] = (Structure.FFIType.get(Pointer.class).getPointer()).peer;
/*      */             break;
/*      */           case 23:
/*      */           case 24:
/*      */           case 25:
/* 1855 */             arrayOfLong2[b1] = (Structure.FFIType.get(clazz1.isPrimitive() ? clazz1 : Pointer.class).getPointer()).peer;
/* 1856 */             arrayOfLong1[b1] = (Structure.FFIType.get(arrayOfToNativeConverter[b1].nativeType()).getPointer()).peer;
/*      */             break;
/*      */           case 0:
/* 1859 */             arrayOfLong1[b1] = (Structure.FFIType.get(clazz1).getPointer()).peer; arrayOfLong2[b1] = (Structure.FFIType.get(clazz1).getPointer()).peer;
/*      */           
/*      */           default:
/* 1862 */             arrayOfLong1[b1] = (Structure.FFIType.get(Pointer.class).getPointer()).peer; arrayOfLong2[b1] = (Structure.FFIType.get(Pointer.class).getPointer()).peer; break;
/*      */         } 
/*      */       } 
/* 1865 */       str = str + ")";
/* 1866 */       str = str + getSignature(clazz);
/*      */       
/* 1868 */       Class[] arrayOfClass2 = method.getExceptionTypes();
/* 1869 */       for (byte b2 = 0; b2 < arrayOfClass2.length; b2++) {
/* 1870 */         if (LastErrorException.class.isAssignableFrom(arrayOfClass2[b2])) {
/* 1871 */           bool1 = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/* 1876 */       Function function = paramNativeLibrary.getFunction(method.getName(), method);
/*      */       try {
/* 1878 */         arrayOfLong[b] = registerMethod(paramClass, method.getName(), str, arrayOfInt, arrayOfLong2, arrayOfLong1, i, l2, l1, method, function.peer, function
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1883 */             .getCallingConvention(), bool1, arrayOfToNativeConverter, fromNativeConverter, function.encoding);
/*      */ 
/*      */       
/*      */       }
/* 1887 */       catch (NoSuchMethodError noSuchMethodError) {
/* 1888 */         throw new UnsatisfiedLinkError("No method " + method.getName() + " with signature " + str + " in " + paramClass);
/*      */       } 
/*      */     } 
/* 1891 */     synchronized (registeredClasses) {
/* 1892 */       registeredClasses.put(paramClass, arrayOfLong);
/* 1893 */       registeredLibraries.put(paramClass, paramNativeLibrary);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Map<String, Object> cacheOptions(Class<?> paramClass, Map<String, ?> paramMap, Object paramObject) {
/* 1901 */     HashMap<String, Object> hashMap = new HashMap<String, Object>(paramMap);
/* 1902 */     hashMap.put("enclosing-library", paramClass);
/* 1903 */     typeOptions.put(paramClass, hashMap);
/* 1904 */     if (paramObject != null) {
/* 1905 */       libraries.put(paramClass, new WeakReference(paramObject));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1911 */     if (!paramClass.isInterface() && Library.class
/* 1912 */       .isAssignableFrom(paramClass)) {
/* 1913 */       Class[] arrayOfClass = paramClass.getInterfaces();
/* 1914 */       for (Class<?> clazz : arrayOfClass) {
/* 1915 */         if (Library.class.isAssignableFrom(clazz)) {
/* 1916 */           cacheOptions(clazz, hashMap, paramObject);
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1921 */     return hashMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static NativeMapped fromNative(Class<?> paramClass, Object paramObject) {
/* 1945 */     return (NativeMapped)NativeMappedConverter.getInstance(paramClass).fromNative(paramObject, new FromNativeContext(paramClass));
/*      */   }
/*      */   
/*      */   private static NativeMapped fromNative(Method paramMethod, Object paramObject) {
/* 1949 */     Class<?> clazz = paramMethod.getReturnType();
/* 1950 */     return (NativeMapped)NativeMappedConverter.getInstance(clazz).fromNative(paramObject, new MethodResultContext(clazz, null, null, paramMethod));
/*      */   }
/*      */   
/*      */   private static Class<?> nativeType(Class<?> paramClass) {
/* 1954 */     return NativeMappedConverter.getInstance(paramClass).nativeType();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static Object toNative(ToNativeConverter paramToNativeConverter, Object paramObject) {
/* 1960 */     return paramToNativeConverter.toNative(paramObject, new ToNativeContext());
/*      */   }
/*      */   
/*      */   private static Object fromNative(FromNativeConverter paramFromNativeConverter, Object paramObject, Method paramMethod) {
/* 1964 */     return paramFromNativeConverter.fromNative(paramObject, new MethodResultContext(paramMethod.getReturnType(), null, null, paramMethod));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void main(String[] paramArrayOfString) {
/* 1983 */     String str1 = "Java Native Access (JNA)";
/* 1984 */     String str2 = "5.9.0";
/* 1985 */     String str3 = "5.9.0 (package information missing)";
/* 1986 */     Package package_ = Native.class.getPackage();
/*      */     
/* 1988 */     String str4 = (package_ != null) ? package_.getSpecificationTitle() : "Java Native Access (JNA)";
/* 1989 */     if (str4 == null) str4 = "Java Native Access (JNA)";
/*      */     
/* 1991 */     String str5 = (package_ != null) ? package_.getSpecificationVersion() : "5.9.0";
/* 1992 */     if (str5 == null) str5 = "5.9.0"; 
/* 1993 */     str4 = str4 + " API Version " + str5;
/* 1994 */     System.out.println(str4);
/*      */     
/* 1996 */     str5 = (package_ != null) ? package_.getImplementationVersion() : "5.9.0 (package information missing)";
/* 1997 */     if (str5 == null) str5 = "5.9.0 (package information missing)"; 
/* 1998 */     System.out.println("Version: " + str5);
/* 1999 */     System.out.println(" Native: " + getNativeVersion() + " (" + 
/* 2000 */         getAPIChecksum() + ")");
/* 2001 */     System.out.println(" Prefix: " + Platform.RESOURCE_PREFIX);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Structure invokeStructure(Function paramFunction, long paramLong, int paramInt, Object[] paramArrayOfObject, Structure paramStructure) {
/* 2126 */     invokeStructure(paramFunction, paramLong, paramInt, paramArrayOfObject, (paramStructure.getPointer()).peer, 
/* 2127 */         (paramStructure.getTypeInfo()).peer);
/* 2128 */     return paramStructure;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static long open(String paramString) {
/* 2146 */     return open(paramString, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Pointer getPointer(long paramLong) {
/* 2235 */     long l = _getPointer(paramLong);
/* 2236 */     return (l == 0L) ? null : new Pointer(l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String getString(Pointer paramPointer, long paramLong) {
/* 2244 */     return getString(paramPointer, paramLong, getDefaultStringEncoding());
/*      */   }
/*      */   
/*      */   static String getString(Pointer paramPointer, long paramLong, String paramString) {
/* 2248 */     byte[] arrayOfByte = getStringBytes(paramPointer, paramPointer.peer, paramLong);
/* 2249 */     if (paramString != null) {
/*      */       try {
/* 2251 */         return new String(arrayOfByte, paramString);
/*      */       }
/* 2253 */       catch (UnsupportedEncodingException unsupportedEncodingException) {}
/*      */     }
/*      */     
/* 2256 */     return new String(arrayOfByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2298 */   private static final ThreadLocal<Memory> nativeThreadTerminationFlag = new ThreadLocal<Memory>()
/*      */     {
/*      */       protected Memory initialValue()
/*      */       {
/* 2302 */         Memory memory = new Memory(4L);
/* 2303 */         memory.clear();
/* 2304 */         return memory;
/*      */       }
/*      */     };
/* 2307 */   private static final Map<Thread, Pointer> nativeThreads = Collections.synchronizedMap(new WeakHashMap<Thread, Pointer>()); private static native void initIDs(); public static synchronized native void setProtected(boolean paramBoolean); public static synchronized native boolean isProtected(); static native long getWindowHandle0(Component paramComponent); private static native long _getDirectBufferPointer(Buffer paramBuffer); private static native int sizeof(int paramInt);
/*      */   private static native String getNativeVersion();
/*      */   private static native String getAPIChecksum();
/*      */   public static native int getLastError();
/*      */   public static native void setLastError(int paramInt);
/*      */   private static native void unregister(Class<?> paramClass, long[] paramArrayOflong);
/*      */   private static native long registerMethod(Class<?> paramClass, String paramString1, String paramString2, int[] paramArrayOfint, long[] paramArrayOflong1, long[] paramArrayOflong2, int paramInt1, long paramLong1, long paramLong2, Method paramMethod, long paramLong3, int paramInt2, boolean paramBoolean, ToNativeConverter[] paramArrayOfToNativeConverter, FromNativeConverter paramFromNativeConverter, String paramString3);
/*      */   public static native long ffi_prep_cif(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   public static native void ffi_call(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   public static native long ffi_prep_closure(long paramLong, ffi_callback paramffi_callback);
/*      */   public static native void ffi_free_closure(long paramLong);
/*      */   static native int initialize_ffi_type(long paramLong);
/*      */   static synchronized native void freeNativeCallback(long paramLong);
/*      */   public static void detach(boolean paramBoolean) {
/* 2321 */     Thread thread = Thread.currentThread();
/* 2322 */     if (paramBoolean) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2329 */       nativeThreads.remove(thread);
/* 2330 */       Pointer pointer = nativeThreadTerminationFlag.get();
/* 2331 */       setDetachState(true, 0L);
/*      */     
/*      */     }
/* 2334 */     else if (!nativeThreads.containsKey(thread)) {
/* 2335 */       Pointer pointer = nativeThreadTerminationFlag.get();
/* 2336 */       nativeThreads.put(thread, pointer);
/* 2337 */       setDetachState(false, pointer.peer);
/*      */     } 
/*      */   } static synchronized native long createNativeCallback(Callback paramCallback, Method paramMethod, Class<?>[] paramArrayOfClass, Class<?> paramClass, int paramInt1, int paramInt2, String paramString); static native int invokeInt(Function paramFunction, long paramLong, int paramInt, Object[] paramArrayOfObject); static native long invokeLong(Function paramFunction, long paramLong, int paramInt, Object[] paramArrayOfObject); static native void invokeVoid(Function paramFunction, long paramLong, int paramInt, Object[] paramArrayOfObject); static native float invokeFloat(Function paramFunction, long paramLong, int paramInt, Object[] paramArrayOfObject); static native double invokeDouble(Function paramFunction, long paramLong, int paramInt, Object[] paramArrayOfObject); static native long invokePointer(Function paramFunction, long paramLong, int paramInt, Object[] paramArrayOfObject); private static native void invokeStructure(Function paramFunction, long paramLong1, int paramInt, Object[] paramArrayOfObject, long paramLong2, long paramLong3); static native Object invokeObject(Function paramFunction, long paramLong, int paramInt, Object[] paramArrayOfObject); static native long open(String paramString, int paramInt); static native void close(long paramLong); static native long findSymbol(long paramLong, String paramString); static native long indexOf(Pointer paramPointer, long paramLong1, long paramLong2, byte paramByte); static native void read(Pointer paramPointer, long paramLong1, long paramLong2, byte[] paramArrayOfbyte, int paramInt1, int paramInt2); static native void read(Pointer paramPointer, long paramLong1, long paramLong2, short[] paramArrayOfshort, int paramInt1, int paramInt2); static native void read(Pointer paramPointer, long paramLong1, long paramLong2, char[] paramArrayOfchar, int paramInt1, int paramInt2); static native void read(Pointer paramPointer, long paramLong1, long paramLong2, int[] paramArrayOfint, int paramInt1, int paramInt2); static native void read(Pointer paramPointer, long paramLong1, long paramLong2, long[] paramArrayOflong, int paramInt1, int paramInt2); static native void read(Pointer paramPointer, long paramLong1, long paramLong2, float[] paramArrayOffloat, int paramInt1, int paramInt2); static native void read(Pointer paramPointer, long paramLong1, long paramLong2, double[] paramArrayOfdouble, int paramInt1, int paramInt2); static native void write(Pointer paramPointer, long paramLong1, long paramLong2, byte[] paramArrayOfbyte, int paramInt1, int paramInt2); static native void write(Pointer paramPointer, long paramLong1, long paramLong2, short[] paramArrayOfshort, int paramInt1, int paramInt2); static native void write(Pointer paramPointer, long paramLong1, long paramLong2, char[] paramArrayOfchar, int paramInt1, int paramInt2); static native void write(Pointer paramPointer, long paramLong1, long paramLong2, int[] paramArrayOfint, int paramInt1, int paramInt2); static native void write(Pointer paramPointer, long paramLong1, long paramLong2, long[] paramArrayOflong, int paramInt1, int paramInt2); static native void write(Pointer paramPointer, long paramLong1, long paramLong2, float[] paramArrayOffloat, int paramInt1, int paramInt2); static native void write(Pointer paramPointer, long paramLong1, long paramLong2, double[] paramArrayOfdouble, int paramInt1, int paramInt2); static native byte getByte(Pointer paramPointer, long paramLong1, long paramLong2); static native char getChar(Pointer paramPointer, long paramLong1, long paramLong2); static native short getShort(Pointer paramPointer, long paramLong1, long paramLong2); static native int getInt(Pointer paramPointer, long paramLong1, long paramLong2); static native long getLong(Pointer paramPointer, long paramLong1, long paramLong2); static native float getFloat(Pointer paramPointer, long paramLong1, long paramLong2);
/*      */   static native double getDouble(Pointer paramPointer, long paramLong1, long paramLong2);
/*      */   private static native long _getPointer(long paramLong);
/*      */   static Pointer getTerminationFlag(Thread paramThread) {
/* 2343 */     return nativeThreads.get(paramThread);
/*      */   } static native String getWideString(Pointer paramPointer, long paramLong1, long paramLong2); static native byte[] getStringBytes(Pointer paramPointer, long paramLong1, long paramLong2); static native void setMemory(Pointer paramPointer, long paramLong1, long paramLong2, long paramLong3, byte paramByte); static native void setByte(Pointer paramPointer, long paramLong1, long paramLong2, byte paramByte); static native void setShort(Pointer paramPointer, long paramLong1, long paramLong2, short paramShort); static native void setChar(Pointer paramPointer, long paramLong1, long paramLong2, char paramChar); static native void setInt(Pointer paramPointer, long paramLong1, long paramLong2, int paramInt); static native void setLong(Pointer paramPointer, long paramLong1, long paramLong2, long paramLong3); static native void setFloat(Pointer paramPointer, long paramLong1, long paramLong2, float paramFloat); static native void setDouble(Pointer paramPointer, long paramLong1, long paramLong2, double paramDouble); static native void setPointer(Pointer paramPointer, long paramLong1, long paramLong2, long paramLong3); static native void setWideString(Pointer paramPointer, long paramLong1, long paramLong2, String paramString); static native ByteBuffer getDirectByteBuffer(Pointer paramPointer, long paramLong1, long paramLong2, long paramLong3); public static native long malloc(long paramLong);
/*      */   public static native void free(long paramLong);
/*      */   private static native void setDetachState(boolean paramBoolean, long paramLong);
/*      */   public static interface ffi_callback {
/*      */     void invoke(long param1Long1, long param1Long2, long param1Long3); }
/*      */   private static class Buffers { static boolean isBuffer(Class<?> param1Class) {
/* 2350 */       return Buffer.class.isAssignableFrom(param1Class);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class AWT
/*      */   {
/*      */     static long getWindowID(Window param1Window) throws HeadlessException {
/* 2359 */       return getComponentID(param1Window);
/*      */     }
/*      */ 
/*      */     
/*      */     static long getComponentID(Object param1Object) throws HeadlessException {
/* 2364 */       if (GraphicsEnvironment.isHeadless()) {
/* 2365 */         throw new HeadlessException("No native windows when headless");
/*      */       }
/* 2367 */       Component component = (Component)param1Object;
/* 2368 */       if (component.isLightweight()) {
/* 2369 */         throw new IllegalArgumentException("Component must be heavyweight");
/*      */       }
/* 2371 */       if (!component.isDisplayable()) {
/* 2372 */         throw new IllegalStateException("Component must be displayable");
/*      */       }
/* 2374 */       if (Platform.isX11() && 
/* 2375 */         System.getProperty("java.version").startsWith("1.4") && 
/* 2376 */         !component.isVisible()) {
/* 2377 */         throw new IllegalStateException("Component must be visible");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2383 */       return Native.getWindowHandle0(component);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\Native.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */