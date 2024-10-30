/*     */ package org.apache.xmlbeans.impl.store;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ConcurrentModificationException;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlBoolean;
/*     */ import org.apache.xmlbeans.XmlDate;
/*     */ import org.apache.xmlbeans.XmlDecimal;
/*     */ import org.apache.xmlbeans.XmlDouble;
/*     */ import org.apache.xmlbeans.XmlFloat;
/*     */ import org.apache.xmlbeans.XmlInteger;
/*     */ import org.apache.xmlbeans.XmlLong;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.impl.common.XPath;
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
/*     */ public abstract class Path
/*     */ {
/*     */   public static final String PATH_DELEGATE_INTERFACE = "PATH_DELEGATE_INTERFACE";
/*  39 */   public static String _useDelegateForXpath = "use delegate for xpath";
/*  40 */   public static String _useXdkForXpath = "use xdk for xpath";
/*  41 */   public static String _useXqrlForXpath = "use xqrl for xpath";
/*  42 */   public static String _useXbeanForXpath = "use xbean for xpath";
/*  43 */   public static String _forceXqrl2002ForXpathXQuery = "use xqrl-2002 for xpath";
/*     */   
/*     */   private static final int USE_XBEAN = 1;
/*     */   
/*     */   private static final int USE_XQRL = 2;
/*     */   private static final int USE_DELEGATE = 4;
/*     */   private static final int USE_XQRL2002 = 8;
/*     */   private static final int USE_XDK = 16;
/*  51 */   private static Map _xbeanPathCache = new WeakHashMap();
/*  52 */   private static Map _xdkPathCache = new WeakHashMap();
/*  53 */   private static Map _xqrlPathCache = new WeakHashMap();
/*  54 */   private static Map _xqrl2002PathCache = new WeakHashMap();
/*     */   
/*     */   private static Method _xdkCompilePath;
/*     */   
/*     */   private static Method _xqrlCompilePath;
/*     */   
/*     */   private static Method _xqrl2002CompilePath;
/*     */   private static boolean _xdkAvailable = true;
/*     */   private static boolean _xqrlAvailable = true;
/*     */   private static boolean _xqrl2002Available = true;
/*     */   private static String _delIntfName;
/*     */   protected final String _pathKey;
/*     */   
/*     */   static {
/*  68 */     ClassLoader classLoader = Path.class.getClassLoader();
/*  69 */     String str = "META-INF/services/org.apache.xmlbeans.impl.store.PathDelegate.SelectPathInterface";
/*  70 */     InputStream inputStream = classLoader.getResourceAsStream(str);
/*     */     
/*     */     try {
/*  73 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
/*  74 */       _delIntfName = bufferedReader.readLine().trim();
/*  75 */       bufferedReader.close();
/*     */     }
/*  77 */     catch (Exception exception) {
/*     */       
/*  79 */       _delIntfName = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Path(String paramString) {
/*  87 */     this._pathKey = paramString;
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
/*     */   static String getCurrentNodeVar(XmlOptions paramXmlOptions) {
/* 106 */     String str = "this";
/*     */     
/* 108 */     paramXmlOptions = XmlOptions.maskNull(paramXmlOptions);
/*     */     
/* 110 */     if (paramXmlOptions.hasOption("XQUERY_CURRENT_NODE_VAR")) {
/* 111 */       str = (String)paramXmlOptions.get("XQUERY_CURRENT_NODE_VAR");
/*     */       
/* 113 */       if (str.startsWith("$")) {
/* 114 */         throw new IllegalArgumentException("Omit the '$' prefix for the current node variable");
/*     */       }
/*     */     } 
/*     */     
/* 118 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Path getCompiledPath(String paramString, XmlOptions paramXmlOptions) {
/* 123 */     paramXmlOptions = XmlOptions.maskNull(paramXmlOptions);
/*     */     
/* 125 */     boolean bool = paramXmlOptions.hasOption(_useDelegateForXpath) ? true : (paramXmlOptions.hasOption(_useXqrlForXpath) ? true : (paramXmlOptions.hasOption(_useXdkForXpath) ? true : (paramXmlOptions.hasOption(_useXbeanForXpath) ? true : (paramXmlOptions.hasOption(_forceXqrl2002ForXpathXQuery) ? true : true))));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     String str = paramXmlOptions.hasOption("PATH_DELEGATE_INTERFACE") ? (String)paramXmlOptions.get("PATH_DELEGATE_INTERFACE") : _delIntfName;
/*     */ 
/*     */ 
/*     */     
/* 136 */     return getCompiledPath(paramString, bool, getCurrentNodeVar(paramXmlOptions), str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static synchronized Path getCompiledPath(String paramString1, int paramInt, String paramString2, String paramString3) {
/* 142 */     Path path = null;
/* 143 */     WeakReference weakReference = null;
/* 144 */     HashMap hashMap = ((paramInt & 0x4) != 0) ? new HashMap() : null;
/*     */     
/* 146 */     if ((paramInt & 0x1) != 0)
/* 147 */       weakReference = (WeakReference)_xbeanPathCache.get(paramString1); 
/* 148 */     if (weakReference == null && (paramInt & 0x2) != 0)
/* 149 */       weakReference = (WeakReference)_xqrlPathCache.get(paramString1); 
/* 150 */     if (weakReference == null && (paramInt & 0x10) != 0)
/* 151 */       weakReference = (WeakReference)_xdkPathCache.get(paramString1); 
/* 152 */     if (weakReference == null && (paramInt & 0x8) != 0) {
/* 153 */       weakReference = (WeakReference)_xqrl2002PathCache.get(paramString1);
/*     */     }
/* 155 */     if (weakReference != null)
/* 156 */       path = weakReference.get(); 
/* 157 */     if (path != null) {
/* 158 */       return path;
/*     */     }
/* 160 */     if ((paramInt & 0x1) != 0)
/* 161 */       path = getCompiledPathXbean(paramString1, paramString2, hashMap); 
/* 162 */     if (path == null && (paramInt & 0x2) != 0)
/* 163 */       path = getCompiledPathXqrl(paramString1, paramString2); 
/* 164 */     if (path == null && (paramInt & 0x10) != 0)
/* 165 */       path = getCompiledPathXdk(paramString1, paramString2); 
/* 166 */     if (path == null && (paramInt & 0x4) != 0)
/* 167 */       path = getCompiledPathDelegate(paramString1, paramString2, hashMap, paramString3); 
/* 168 */     if (path == null && (paramInt & 0x8) != 0) {
/* 169 */       path = getCompiledPathXqrl2002(paramString1, paramString2);
/*     */     }
/* 171 */     if (path == null) {
/*     */       
/* 173 */       StringBuffer stringBuffer = new StringBuffer();
/* 174 */       if ((paramInt & 0x1) != 0)
/* 175 */         stringBuffer.append(" Trying XBeans path engine..."); 
/* 176 */       if ((paramInt & 0x2) != 0)
/* 177 */         stringBuffer.append(" Trying XQRL..."); 
/* 178 */       if ((paramInt & 0x10) != 0)
/* 179 */         stringBuffer.append(" Trying XDK..."); 
/* 180 */       if ((paramInt & 0x4) != 0)
/* 181 */         stringBuffer.append(" Trying delegated path engine..."); 
/* 182 */       if ((paramInt & 0x8) != 0) {
/* 183 */         stringBuffer.append(" Trying XQRL2002...");
/*     */       }
/* 185 */       throw new RuntimeException(stringBuffer.toString() + " FAILED on " + paramString1);
/*     */     } 
/*     */     
/* 188 */     return path;
/*     */   }
/*     */ 
/*     */   
/*     */   private static synchronized Path getCompiledPathXdk(String paramString1, String paramString2) {
/* 193 */     Path path = createXdkCompiledPath(paramString1, paramString2);
/* 194 */     if (path != null) {
/* 195 */       _xdkPathCache.put(path._pathKey, new WeakReference(path));
/*     */     }
/* 197 */     return path;
/*     */   }
/*     */ 
/*     */   
/*     */   private static synchronized Path getCompiledPathXqrl(String paramString1, String paramString2) {
/* 202 */     Path path = createXqrlCompiledPath(paramString1, paramString2);
/* 203 */     if (path != null) {
/* 204 */       _xqrlPathCache.put(path._pathKey, new WeakReference(path));
/*     */     }
/* 206 */     return path;
/*     */   }
/*     */ 
/*     */   
/*     */   private static synchronized Path getCompiledPathXqrl2002(String paramString1, String paramString2) {
/* 211 */     Path path = createXqrl2002CompiledPath(paramString1, paramString2);
/* 212 */     if (path != null) {
/* 213 */       _xqrl2002PathCache.put(path._pathKey, new WeakReference(path));
/*     */     }
/* 215 */     return path;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static synchronized Path getCompiledPathXbean(String paramString1, String paramString2, Map paramMap) {
/* 221 */     Path path = XbeanPath.create(paramString1, paramString2, paramMap);
/* 222 */     if (path != null) {
/* 223 */       _xbeanPathCache.put(path._pathKey, new WeakReference(path));
/*     */     }
/* 225 */     return path;
/*     */   }
/*     */ 
/*     */   
/*     */   private static synchronized Path getCompiledPathDelegate(String paramString1, String paramString2, Map paramMap, String paramString3) {
/* 230 */     Path path = null;
/* 231 */     if (paramMap == null) {
/* 232 */       paramMap = new HashMap();
/*     */     }
/*     */     
/*     */     try {
/* 236 */       XPath.compileXPath(paramString1, paramString2, paramMap);
/*     */     }
/* 238 */     catch (org.apache.xmlbeans.impl.common.XPath.XPathCompileException xPathCompileException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 243 */     boolean bool = (paramMap.get("$xmlbeans!ns_boundary") == null) ? false : ((Integer)paramMap.get("$xmlbeans!ns_boundary")).intValue();
/*     */ 
/*     */ 
/*     */     
/* 247 */     paramMap.remove("$xmlbeans!ns_boundary");
/* 248 */     path = DelegatePathImpl.create(paramString3, paramString1.substring(bool), paramString2, paramMap);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 253 */     return path;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized String compilePath(String paramString, XmlOptions paramXmlOptions) {
/* 259 */     return (getCompiledPath(paramString, paramXmlOptions))._pathKey;
/*     */   }
/*     */   
/*     */   static interface PathEngine {
/*     */     void release();
/*     */     
/*     */     boolean next(Cur param1Cur); }
/*     */   
/*     */   private static final class XbeanPath extends Path {
/*     */     private final String _currentVar;
/*     */     
/*     */     static Path create(String param1String1, String param1String2, Map param1Map) {
/*     */       try {
/* 272 */         return new XbeanPath(param1String1, param1String2, XPath.compileXPath(param1String1, param1String2, param1Map));
/*     */       
/*     */       }
/* 275 */       catch (org.apache.xmlbeans.impl.common.XPath.XPathCompileException xPathCompileException) {
/* 276 */         return null;
/*     */       } 
/*     */     }
/*     */     private final XPath _compiledPath; public Map namespaces;
/*     */     
/*     */     private XbeanPath(String param1String1, String param1String2, XPath param1XPath) {
/* 282 */       super(param1String1);
/*     */       
/* 284 */       this._currentVar = param1String2;
/* 285 */       this._compiledPath = param1XPath;
/*     */     }
/*     */ 
/*     */     
/*     */     Path.PathEngine execute(Cur param1Cur, XmlOptions param1XmlOptions) {
/* 290 */       param1XmlOptions = XmlOptions.maskNull(param1XmlOptions);
/* 291 */       String str = param1XmlOptions.hasOption("PATH_DELEGATE_INTERFACE") ? (String)param1XmlOptions.get("PATH_DELEGATE_INTERFACE") : Path._delIntfName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 300 */       if (!param1Cur.isContainer() || this._compiledPath.sawDeepDot()) {
/*     */         
/* 302 */         byte b = 22;
/* 303 */         return getCompiledPath(this._pathKey, b, this._currentVar, str).execute(param1Cur, param1XmlOptions);
/*     */       } 
/* 305 */       return new Path.XbeanPathEngine(this._compiledPath, param1Cur);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Path createXdkCompiledPath(String paramString1, String paramString2) {
/* 315 */     if (!_xdkAvailable) {
/* 316 */       return null;
/*     */     }
/* 318 */     if (_xdkCompilePath == null) {
/*     */       
/*     */       try {
/*     */         
/* 322 */         Class clazz = Class.forName("org.apache.xmlbeans.impl.store.OXQXBXqrlImpl");
/*     */         
/* 324 */         _xdkCompilePath = clazz.getDeclaredMethod("compilePath", new Class[] { String.class, String.class, Boolean.class });
/*     */ 
/*     */       
/*     */       }
/* 328 */       catch (ClassNotFoundException classNotFoundException) {
/*     */         
/* 330 */         _xdkAvailable = false;
/* 331 */         return null;
/*     */       }
/* 333 */       catch (Exception exception) {
/*     */         
/* 335 */         _xdkAvailable = false;
/* 336 */         throw new RuntimeException(exception.getMessage(), exception);
/*     */       } 
/*     */     }
/*     */     
/* 340 */     Object[] arrayOfObject = { paramString1, paramString2, new Boolean(true) };
/*     */     
/*     */     try {
/* 343 */       return (Path)_xdkCompilePath.invoke(null, arrayOfObject);
/*     */     }
/* 345 */     catch (InvocationTargetException invocationTargetException) {
/* 346 */       Throwable throwable = invocationTargetException.getCause();
/* 347 */       throw new RuntimeException(throwable.getMessage(), throwable);
/*     */     }
/* 349 */     catch (IllegalAccessException illegalAccessException) {
/* 350 */       throw new RuntimeException(illegalAccessException.getMessage(), illegalAccessException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static Path createXqrlCompiledPath(String paramString1, String paramString2) {
/* 356 */     if (!_xqrlAvailable) {
/* 357 */       return null;
/*     */     }
/* 359 */     if (_xqrlCompilePath == null) {
/*     */       
/*     */       try {
/*     */         
/* 363 */         Class clazz = Class.forName("org.apache.xmlbeans.impl.store.XqrlImpl");
/*     */         
/* 365 */         _xqrlCompilePath = clazz.getDeclaredMethod("compilePath", new Class[] { String.class, String.class, Boolean.class });
/*     */ 
/*     */       
/*     */       }
/* 369 */       catch (ClassNotFoundException classNotFoundException) {
/*     */         
/* 371 */         _xqrlAvailable = false;
/* 372 */         return null;
/*     */       }
/* 374 */       catch (Exception exception) {
/*     */         
/* 376 */         _xqrlAvailable = false;
/* 377 */         throw new RuntimeException(exception.getMessage(), exception);
/*     */       } 
/*     */     }
/*     */     
/* 381 */     Object[] arrayOfObject = { paramString1, paramString2, new Boolean(true) };
/*     */     
/*     */     try {
/* 384 */       return (Path)_xqrlCompilePath.invoke(null, arrayOfObject);
/*     */     }
/* 386 */     catch (InvocationTargetException invocationTargetException) {
/* 387 */       Throwable throwable = invocationTargetException.getCause();
/* 388 */       throw new RuntimeException(throwable.getMessage(), throwable);
/*     */     }
/* 390 */     catch (IllegalAccessException illegalAccessException) {
/* 391 */       throw new RuntimeException(illegalAccessException.getMessage(), illegalAccessException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static Path createXqrl2002CompiledPath(String paramString1, String paramString2) {
/* 397 */     if (!_xqrl2002Available) {
/* 398 */       return null;
/*     */     }
/* 400 */     if (_xqrl2002CompilePath == null) {
/*     */       
/*     */       try {
/*     */         
/* 404 */         Class clazz = Class.forName("org.apache.xmlbeans.impl.store.Xqrl2002Impl");
/*     */         
/* 406 */         _xqrl2002CompilePath = clazz.getDeclaredMethod("compilePath", new Class[] { String.class, String.class, Boolean.class });
/*     */ 
/*     */       
/*     */       }
/* 410 */       catch (ClassNotFoundException classNotFoundException) {
/*     */         
/* 412 */         _xqrl2002Available = false;
/* 413 */         return null;
/*     */       }
/* 415 */       catch (Exception exception) {
/*     */         
/* 417 */         _xqrl2002Available = false;
/* 418 */         throw new RuntimeException(exception.getMessage(), exception);
/*     */       } 
/*     */     }
/*     */     
/* 422 */     Object[] arrayOfObject = { paramString1, paramString2, new Boolean(true) };
/*     */ 
/*     */     
/*     */     try {
/* 426 */       return (Path)_xqrl2002CompilePath.invoke(null, arrayOfObject);
/*     */     }
/* 428 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 430 */       Throwable throwable = invocationTargetException.getCause();
/* 431 */       throw new RuntimeException(throwable.getMessage(), throwable);
/*     */     }
/* 433 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 435 */       throw new RuntimeException(illegalAccessException.getMessage(), illegalAccessException);
/*     */     } 
/*     */   }
/*     */   abstract PathEngine execute(Cur paramCur, XmlOptions paramXmlOptions);
/*     */   
/*     */   private static final class XbeanPathEngine extends XPath.ExecutionContext implements PathEngine { private final long _version;
/*     */     private Cur _cur;
/*     */     static final boolean $assertionsDisabled;
/*     */     
/*     */     XbeanPathEngine(XPath param1XPath, Cur param1Cur) {
/* 445 */       assert param1Cur.isContainer();
/*     */       
/* 447 */       this._version = param1Cur._locale.version();
/* 448 */       this._cur = param1Cur.weakCur(this);
/*     */       
/* 450 */       this._cur.push();
/*     */       
/* 452 */       init(param1XPath);
/*     */       
/* 454 */       int i = start();
/*     */       
/* 456 */       if ((i & 0x1) != 0) {
/* 457 */         param1Cur.addToSelection();
/*     */       }
/* 459 */       doAttrs(i, param1Cur);
/*     */       
/* 461 */       if ((i & 0x2) == 0 || !Locale.toFirstChildElement(this._cur)) {
/* 462 */         release();
/*     */       }
/*     */     }
/*     */     
/*     */     private void advance(Cur param1Cur) {
/* 467 */       assert this._cur != null;
/*     */       
/* 469 */       if (this._cur.isFinish()) {
/*     */         
/* 471 */         if (this._cur.isAtEndOfLastPush()) {
/* 472 */           release();
/*     */         } else {
/* 474 */           end();
/* 475 */           this._cur.next();
/*     */         }
/*     */       
/* 478 */       } else if (this._cur.isElem()) {
/*     */         
/* 480 */         int i = element(this._cur.getName());
/*     */         
/* 482 */         if ((i & 0x1) != 0) {
/* 483 */           param1Cur.addToSelection(this._cur);
/*     */         }
/* 485 */         doAttrs(i, param1Cur);
/*     */         
/* 487 */         if ((i & 0x2) == 0 || !Locale.toFirstChildElement(this._cur)) {
/*     */           
/* 489 */           end();
/* 490 */           this._cur.skip();
/*     */         } 
/*     */       } else {
/*     */         
/*     */         do
/*     */         {
/*     */           
/* 497 */           this._cur.next();
/*     */         }
/* 499 */         while (!this._cur.isContainerOrFinish());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private void doAttrs(int param1Int, Cur param1Cur) {
/* 505 */       assert this._cur.isContainer();
/*     */       
/* 507 */       if ((param1Int & 0x4) != 0 && 
/* 508 */         this._cur.toFirstAttr()) {
/*     */         do {
/* 510 */           if (!attr(this._cur.getName()))
/* 511 */             continue;  param1Cur.addToSelection(this._cur);
/*     */         }
/* 513 */         while (this._cur.toNextAttr());
/*     */         
/* 515 */         this._cur.toParent();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean next(Cur param1Cur) {
/* 522 */       if (this._cur != null && this._version != this._cur._locale.version()) {
/* 523 */         throw new ConcurrentModificationException("Document changed during select");
/*     */       }
/* 525 */       int i = param1Cur.selectionCount();
/*     */       
/* 527 */       while (this._cur != null) {
/* 528 */         advance(param1Cur);
/*     */         
/* 530 */         if (i != param1Cur.selectionCount()) {
/* 531 */           return true;
/*     */         }
/*     */       } 
/* 534 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void release() {
/* 539 */       if (this._cur != null) {
/* 540 */         this._cur.release();
/* 541 */         this._cur = null;
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class DelegatePathImpl
/*     */     extends Path
/*     */   {
/*     */     private PathDelegate.SelectPathInterface _xpathImpl;
/*     */     
/*     */     static final boolean $assertionsDisabled;
/*     */ 
/*     */     
/*     */     static Path create(String param1String1, String param1String2, String param1String3, Map param1Map) {
/* 556 */       assert !param1String3.startsWith("$");
/*     */       
/* 558 */       PathDelegate.SelectPathInterface selectPathInterface = PathDelegate.createInstance(param1String1, param1String2, param1String3, param1Map);
/*     */       
/* 560 */       if (selectPathInterface == null) {
/* 561 */         return null;
/*     */       }
/* 563 */       return new DelegatePathImpl(selectPathInterface, param1String2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private DelegatePathImpl(PathDelegate.SelectPathInterface param1SelectPathInterface, String param1String) {
/* 570 */       super(param1String);
/* 571 */       this._xpathImpl = param1SelectPathInterface;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Path.PathEngine execute(Cur param1Cur, XmlOptions param1XmlOptions) {
/* 576 */       return new DelegatePathEngine(this._xpathImpl, param1Cur);
/*     */     }
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
/*     */     private static class DelegatePathEngine
/*     */       extends XPath.ExecutionContext
/*     */       implements Path.PathEngine
/*     */     {
/*     */       private Cur _cur;
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
/*     */       private PathDelegate.SelectPathInterface _engine;
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
/*     */       private boolean _firstCall;
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
/*     */       private long _version;
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
/*     */       static final boolean $assertionsDisabled;
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
/*     */       DelegatePathEngine(PathDelegate.SelectPathInterface param2SelectPathInterface, Cur param2Cur) {
/* 682 */         this._firstCall = true;
/*     */         this._engine = param2SelectPathInterface;
/*     */         this._version = param2Cur._locale.version();
/*     */         this._cur = param2Cur.weakCur(this);
/*     */       }
/*     */       
/*     */       public boolean next(Cur param2Cur) {
/*     */         if (!this._firstCall)
/*     */           return false; 
/*     */         this._firstCall = false;
/*     */         if (this._cur != null && this._version != this._cur._locale.version())
/*     */           throw new ConcurrentModificationException("Document changed during select"); 
/*     */         DomImpl.Dom dom = this._cur.getDom();
/*     */         List list = this._engine.selectPath(dom);
/*     */         for (byte b = 0; b < list.size(); b++) {
/*     */           DomImpl.Dom dom1 = (DomImpl.Dom)list.get(b);
/*     */           Cur cur = null;
/*     */           if (!(dom1 instanceof org.w3c.dom.Node)) {
/*     */             String str = list.get(b).toString();
/*     */             Locale locale = param2Cur._locale;
/*     */             try {
/*     */               cur = locale.load("<xml-fragment/>").tempCur();
/*     */               cur.setValue(str);
/*     */               SchemaType schemaType = getType(dom1);
/*     */               Locale.autoTypeDocument(cur, schemaType, null);
/*     */               cur.next();
/*     */             } catch (Exception exception) {
/*     */               throw new RuntimeException(exception);
/*     */             } 
/*     */           } else {
/*     */             assert dom1 instanceof DomImpl.Dom : "New object created in XPATH!";
/*     */             cur = ((DomImpl.Dom)dom1).tempCur();
/*     */           } 
/*     */           param2Cur.addToSelection(cur);
/*     */           cur.release();
/*     */         } 
/*     */         release();
/*     */         this._engine = null;
/*     */         return true;
/*     */       }
/*     */       
/*     */       private SchemaType getType(Object param2Object) {
/*     */         SchemaType schemaType;
/*     */         if (param2Object instanceof Integer) {
/*     */           schemaType = XmlInteger.type;
/*     */         } else if (param2Object instanceof Double) {
/*     */           schemaType = XmlDouble.type;
/*     */         } else if (param2Object instanceof Long) {
/*     */           schemaType = XmlLong.type;
/*     */         } else if (param2Object instanceof Float) {
/*     */           schemaType = XmlFloat.type;
/*     */         } else if (param2Object instanceof java.math.BigDecimal) {
/*     */           schemaType = XmlDecimal.type;
/*     */         } else if (param2Object instanceof Boolean) {
/*     */           schemaType = XmlBoolean.type;
/*     */         } else if (param2Object instanceof String) {
/*     */           schemaType = XmlString.type;
/*     */         } else if (param2Object instanceof java.util.Date) {
/*     */           schemaType = XmlDate.type;
/*     */         } else {
/*     */           schemaType = XmlAnySimpleType.type;
/*     */         } 
/*     */         return schemaType;
/*     */       }
/*     */       
/*     */       public void release() {
/*     */         if (this._cur != null) {
/*     */           this._cur.release();
/*     */           this._cur = null;
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\Path.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */