/*     */ package org.apache.xmlbeans.impl.store;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlBoolean;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlDate;
/*     */ import org.apache.xmlbeans.XmlDecimal;
/*     */ import org.apache.xmlbeans.XmlDouble;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlFloat;
/*     */ import org.apache.xmlbeans.XmlInteger;
/*     */ import org.apache.xmlbeans.XmlLong;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlRuntimeException;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.impl.common.XPath;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Query
/*     */ {
/*     */   public static final String QUERY_DELEGATE_INTERFACE = "QUERY_DELEGATE_INTERFACE";
/*  35 */   public static String _useDelegateForXQuery = "use delegate for xquery";
/*  36 */   public static String _useXdkForXQuery = "use xdk for xquery";
/*     */ 
/*     */   
/*     */   private static String _delIntfName;
/*     */   
/*  41 */   private static HashMap _xdkQueryCache = new HashMap();
/*     */   
/*     */   private static Method _xdkCompileQuery;
/*     */   private static boolean _xdkAvailable = true;
/*  45 */   private static HashMap _xqrlQueryCache = new HashMap();
/*     */   
/*     */   private static Method _xqrlCompileQuery;
/*     */   private static boolean _xqrlAvailable = true;
/*  49 */   private static HashMap _xqrl2002QueryCache = new HashMap();
/*     */   private static Method _xqrl2002CompileQuery;
/*     */   private static boolean _xqrl2002Available = true;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   static {
/*  55 */     ClassLoader classLoader = Query.class.getClassLoader();
/*  56 */     String str = "META-INF/services/org.apache.xmlbeans.impl.store.QueryDelegate.QueryInterface";
/*  57 */     InputStream inputStream = classLoader.getResourceAsStream(str);
/*     */     
/*     */     try {
/*  60 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
/*  61 */       _delIntfName = bufferedReader.readLine().trim();
/*  62 */       bufferedReader.close();
/*     */     }
/*  64 */     catch (Exception exception) {
/*     */       
/*  66 */       _delIntfName = null;
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
/*     */   static XmlObject[] objectExecQuery(Cur paramCur, String paramString, XmlOptions paramXmlOptions) {
/*  80 */     return getCompiledQuery(paramString, paramXmlOptions).objectExecute(paramCur, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   static XmlCursor cursorExecQuery(Cur paramCur, String paramString, XmlOptions paramXmlOptions) {
/*  85 */     return getCompiledQuery(paramString, paramXmlOptions).cursorExecute(paramCur, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public static synchronized Query getCompiledQuery(String paramString, XmlOptions paramXmlOptions) {
/*  90 */     return getCompiledQuery(paramString, Path.getCurrentNodeVar(paramXmlOptions), paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   static synchronized Query getCompiledQuery(String paramString1, String paramString2, XmlOptions paramXmlOptions) {
/*  95 */     assert paramString1 != null;
/*  96 */     paramXmlOptions = XmlOptions.maskNull(paramXmlOptions);
/*     */ 
/*     */     
/*  99 */     if (paramXmlOptions.hasOption(Path._forceXqrl2002ForXpathXQuery)) {
/*     */       
/* 101 */       Query query1 = (Query)_xqrl2002QueryCache.get(paramString1);
/* 102 */       if (query1 != null) {
/* 103 */         return query1;
/*     */       }
/* 105 */       query1 = getXqrl2002CompiledQuery(paramString1, paramString2);
/* 106 */       if (query1 != null) {
/*     */         
/* 108 */         _xqrl2002QueryCache.put(paramString1, query1);
/* 109 */         return query1;
/*     */       } 
/* 111 */       throw new RuntimeException("No 2002 query engine found.");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 116 */     HashMap hashMap = new HashMap();
/* 117 */     boolean bool = false;
/*     */     
/*     */     try {
/* 120 */       XPath.compileXPath(paramString1, paramString2, hashMap);
/*     */     }
/* 122 */     catch (org.apache.xmlbeans.impl.common.XPath.XPathCompileException xPathCompileException) {
/*     */ 
/*     */     
/*     */     }
/*     */     finally {
/*     */       
/* 128 */       bool = (hashMap.get("$xmlbeans!ns_boundary") == null) ? false : ((Integer)hashMap.get("$xmlbeans!ns_boundary")).intValue();
/*     */     } 
/*     */ 
/*     */     
/* 132 */     if (paramXmlOptions.hasOption(_useXdkForXQuery)) {
/*     */ 
/*     */       
/* 135 */       Query query1 = (Query)_xdkQueryCache.get(paramString1);
/* 136 */       if (query1 != null) {
/* 137 */         return query1;
/*     */       }
/* 139 */       query1 = createXdkCompiledQuery(paramString1, paramString2);
/* 140 */       if (query1 != null) {
/*     */         
/* 142 */         _xdkQueryCache.put(paramString1, query1);
/* 143 */         return query1;
/*     */       } 
/*     */     } 
/*     */     
/* 147 */     if (!paramXmlOptions.hasOption(_useDelegateForXQuery)) {
/*     */ 
/*     */       
/* 150 */       Query query1 = (Query)_xqrlQueryCache.get(paramString1);
/* 151 */       if (query1 != null) {
/* 152 */         return query1;
/*     */       }
/* 154 */       query1 = createXqrlCompiledQuery(paramString1, paramString2);
/* 155 */       if (query1 != null) {
/*     */         
/* 157 */         _xqrlQueryCache.put(paramString1, query1);
/* 158 */         return query1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 169 */     String str = paramXmlOptions.hasOption("QUERY_DELEGATE_INTERFACE") ? (String)paramXmlOptions.get("QUERY_DELEGATE_INTERFACE") : _delIntfName;
/*     */ 
/*     */     
/* 172 */     Query query = DelegateQueryImpl.createDelegateCompiledQuery(str, paramString1, paramString2, bool);
/*     */     
/* 174 */     if (query != null)
/*     */     {
/*     */       
/* 177 */       return query;
/*     */     }
/*     */     
/* 180 */     throw new RuntimeException("No query engine found");
/*     */   }
/*     */ 
/*     */   
/*     */   public static synchronized String compileQuery(String paramString, XmlOptions paramXmlOptions) {
/* 185 */     getCompiledQuery(paramString, paramXmlOptions);
/* 186 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Query createXdkCompiledQuery(String paramString1, String paramString2) {
/* 192 */     if (!_xdkAvailable) return null; 
/* 193 */     if (_xdkCompileQuery == null) {
/*     */       
/*     */       try {
/*     */         
/* 197 */         Class clazz = Class.forName("org.apache.xmlbeans.impl.store.OXQXBXqrlImpl");
/*     */         
/* 199 */         _xdkCompileQuery = clazz.getDeclaredMethod("compileQuery", new Class[] { String.class, String.class, Boolean.class });
/*     */ 
/*     */       
/*     */       }
/* 203 */       catch (ClassNotFoundException classNotFoundException) {
/*     */         
/* 205 */         _xdkAvailable = false;
/* 206 */         return null;
/*     */       }
/* 208 */       catch (Exception exception) {
/*     */         
/* 210 */         _xdkAvailable = false;
/* 211 */         throw new RuntimeException(exception.getMessage(), exception);
/*     */       } 
/*     */     }
/*     */     
/* 215 */     Object[] arrayOfObject = { paramString1, paramString2, new Boolean(true) };
/*     */ 
/*     */     
/*     */     try {
/* 219 */       return (Query)_xdkCompileQuery.invoke(null, arrayOfObject);
/*     */     }
/* 221 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 223 */       Throwable throwable = invocationTargetException.getCause();
/* 224 */       throw new RuntimeException(throwable.getMessage(), throwable);
/*     */     }
/* 226 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 228 */       throw new RuntimeException(illegalAccessException.getMessage(), illegalAccessException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Query createXqrlCompiledQuery(String paramString1, String paramString2) {
/* 235 */     if (!_xqrlAvailable) return null; 
/* 236 */     if (_xqrlCompileQuery == null) {
/*     */       
/*     */       try {
/*     */         
/* 240 */         Class clazz = Class.forName("org.apache.xmlbeans.impl.store.XqrlImpl");
/*     */         
/* 242 */         _xqrlCompileQuery = clazz.getDeclaredMethod("compileQuery", new Class[] { String.class, String.class, Boolean.class });
/*     */ 
/*     */       
/*     */       }
/* 246 */       catch (ClassNotFoundException classNotFoundException) {
/*     */         
/* 248 */         _xqrlAvailable = false;
/* 249 */         return null;
/*     */       }
/* 251 */       catch (Exception exception) {
/*     */         
/* 253 */         _xqrlAvailable = false;
/* 254 */         throw new RuntimeException(exception.getMessage(), exception);
/*     */       } 
/*     */     }
/*     */     
/* 258 */     Object[] arrayOfObject = { paramString1, paramString2, new Boolean(true) };
/*     */ 
/*     */     
/*     */     try {
/* 262 */       return (Query)_xqrlCompileQuery.invoke(null, arrayOfObject);
/*     */     }
/* 264 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 266 */       Throwable throwable = invocationTargetException.getCause();
/* 267 */       throw new RuntimeException(throwable.getMessage(), throwable);
/*     */     }
/* 269 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 271 */       throw new RuntimeException(illegalAccessException.getMessage(), illegalAccessException);
/*     */     } 
/*     */   }
/*     */   abstract XmlObject[] objectExecute(Cur paramCur, XmlOptions paramXmlOptions);
/*     */   
/*     */   private static Query getXqrl2002CompiledQuery(String paramString1, String paramString2) {
/* 277 */     if (_xqrl2002Available && _xqrl2002CompileQuery == null) {
/*     */       
/*     */       try {
/*     */         
/* 281 */         Class clazz = Class.forName("org.apache.xmlbeans.impl.store.Xqrl2002Impl");
/*     */         
/* 283 */         _xqrl2002CompileQuery = clazz.getDeclaredMethod("compileQuery", new Class[] { String.class, String.class, Boolean.class });
/*     */ 
/*     */       
/*     */       }
/* 287 */       catch (ClassNotFoundException classNotFoundException) {
/*     */         
/* 289 */         _xqrl2002Available = false;
/* 290 */         return null;
/*     */       }
/* 292 */       catch (Exception exception) {
/*     */         
/* 294 */         _xqrl2002Available = false;
/* 295 */         throw new RuntimeException(exception.getMessage(), exception);
/*     */       } 
/*     */     }
/*     */     
/* 299 */     Object[] arrayOfObject = { paramString1, paramString2, new Boolean(true) };
/*     */ 
/*     */     
/*     */     try {
/* 303 */       return (Query)_xqrl2002CompileQuery.invoke(null, arrayOfObject);
/*     */     }
/* 305 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 307 */       Throwable throwable = invocationTargetException.getCause();
/* 308 */       throw new RuntimeException(throwable.getMessage(), throwable);
/*     */     }
/* 310 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 312 */       throw new RuntimeException(illegalAccessException.getMessage(), illegalAccessException);
/*     */     } 
/*     */   }
/*     */   
/*     */   abstract XmlCursor cursorExecute(Cur paramCur, XmlOptions paramXmlOptions);
/*     */   
/*     */   private static final class DelegateQueryImpl extends Query {
/*     */     private DelegateQueryImpl(QueryDelegate.QueryInterface param1QueryInterface) {
/* 320 */       this._xqueryImpl = param1QueryInterface;
/*     */     }
/*     */ 
/*     */     
/*     */     private QueryDelegate.QueryInterface _xqueryImpl;
/*     */     static final boolean $assertionsDisabled;
/*     */     
/*     */     public static Query createDelegateCompiledQuery(String param1String1, String param1String2, String param1String3, int param1Int) {
/* 328 */       assert !param1String3.startsWith(".") && !param1String3.startsWith("..");
/* 329 */       QueryDelegate.QueryInterface queryInterface = QueryDelegate.createInstance(param1String1, param1String2, param1String3, param1Int);
/*     */ 
/*     */       
/* 332 */       if (queryInterface == null) {
/* 333 */         return null;
/*     */       }
/* 335 */       return new DelegateQueryImpl(queryInterface);
/*     */     }
/*     */ 
/*     */     
/*     */     XmlObject[] objectExecute(Cur param1Cur, XmlOptions param1XmlOptions) {
/* 340 */       return (new DelegateQueryEngine(this._xqueryImpl, param1Cur, param1XmlOptions)).objectExecute();
/*     */     }
/*     */ 
/*     */     
/*     */     XmlCursor cursorExecute(Cur param1Cur, XmlOptions param1XmlOptions) {
/* 345 */       return (new DelegateQueryEngine(this._xqueryImpl, param1Cur, param1XmlOptions)).cursorExecute();
/*     */     }
/*     */     
/*     */     private static class DelegateQueryEngine { private Cur _cur;
/*     */       private QueryDelegate.QueryInterface _engine;
/*     */       private long _version;
/*     */       private XmlOptions _options;
/*     */       static final boolean $assertionsDisabled;
/*     */       
/*     */       public DelegateQueryEngine(QueryDelegate.QueryInterface param2QueryInterface, Cur param2Cur, XmlOptions param2XmlOptions) {
/* 355 */         this._engine = param2QueryInterface;
/* 356 */         this._version = param2Cur._locale.version();
/* 357 */         this._cur = param2Cur.weakCur(this);
/* 358 */         this._options = param2XmlOptions;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public XmlObject[] objectExecute() {
/* 364 */         if (this._cur == null || this._version != this._cur._locale.version());
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 369 */         Map map = (Map)XmlOptions.maskNull(this._options).get("XQUERY_VARIABLE_MAP");
/*     */ 
/*     */         
/* 372 */         List list = this._engine.execQuery(this._cur.getDom(), map);
/*     */         
/* 374 */         assert list.size() > -1;
/*     */         
/* 376 */         XmlObject[] arrayOfXmlObject = new XmlObject[list.size()];
/*     */         
/* 378 */         for (byte b = 0; b < list.size(); b++) {
/*     */           
/* 380 */           Locale locale = Locale.getLocale(this._cur._locale._schemaTypeLoader, this._options);
/*     */ 
/*     */           
/* 383 */           locale.enter();
/* 384 */           Node node = (Node)list.get(b);
/* 385 */           Cur cur = null;
/*     */           
/*     */           try {
/* 388 */             if (!(node instanceof Node)) {
/*     */ 
/*     */ 
/*     */               
/* 392 */               cur = locale.load("<xml-fragment/>").tempCur();
/* 393 */               cur.setValue(node.toString());
/* 394 */               SchemaType schemaType = getType(node);
/* 395 */               Locale.autoTypeDocument(cur, schemaType, null);
/* 396 */               arrayOfXmlObject[b] = cur.getObject();
/*     */             } else {
/*     */               
/* 399 */               cur = loadNode(locale, node);
/* 400 */             }  arrayOfXmlObject[b] = cur.getObject();
/*     */           }
/* 402 */           catch (XmlException xmlException) {
/* 403 */             throw new RuntimeException(xmlException);
/*     */           } finally {
/*     */             
/* 406 */             locale.exit();
/*     */           } 
/* 408 */           cur.release();
/*     */         } 
/* 410 */         release();
/* 411 */         this._engine = null;
/* 412 */         return arrayOfXmlObject;
/*     */       }
/*     */       
/*     */       private SchemaType getType(Object param2Object) {
/*     */         SchemaType schemaType;
/* 417 */         if (param2Object instanceof Integer) {
/* 418 */           schemaType = XmlInteger.type;
/* 419 */         } else if (param2Object instanceof Double) {
/* 420 */           schemaType = XmlDouble.type;
/* 421 */         } else if (param2Object instanceof Long) {
/* 422 */           schemaType = XmlLong.type;
/* 423 */         } else if (param2Object instanceof Float) {
/* 424 */           schemaType = XmlFloat.type;
/* 425 */         } else if (param2Object instanceof java.math.BigDecimal) {
/* 426 */           schemaType = XmlDecimal.type;
/* 427 */         } else if (param2Object instanceof Boolean) {
/* 428 */           schemaType = XmlBoolean.type;
/* 429 */         } else if (param2Object instanceof String) {
/* 430 */           schemaType = XmlString.type;
/* 431 */         } else if (param2Object instanceof java.util.Date) {
/* 432 */           schemaType = XmlDate.type;
/*     */         } else {
/* 434 */           schemaType = XmlAnySimpleType.type;
/* 435 */         }  return schemaType;
/*     */       }
/*     */       
/*     */       public XmlCursor cursorExecute() {
/* 439 */         if (this._cur == null || this._version != this._cur._locale.version());
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 444 */         Map map = (Map)XmlOptions.maskNull(this._options).get("XQUERY_VARIABLE_MAP");
/*     */ 
/*     */         
/* 447 */         List list = this._engine.execQuery(this._cur.getDom(), map);
/*     */         
/* 449 */         assert list.size() > -1;
/*     */ 
/*     */         
/* 452 */         this._engine = null;
/*     */         
/* 454 */         Locale locale = Locale.getLocale(this._cur._locale._schemaTypeLoader, this._options);
/* 455 */         locale.enter();
/* 456 */         Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(locale, this._options);
/* 457 */         Cursor cursor = null;
/*     */         try {
/* 459 */           for (byte b = 0; b < list.size(); b++) {
/* 460 */             loadNodeHelper(locale, list.get(b), curLoadContext);
/*     */           }
/* 462 */           Cur cur = curLoadContext.finish();
/* 463 */           Locale.associateSourceName(cur, this._options);
/* 464 */           Locale.autoTypeDocument(cur, null, this._options);
/* 465 */           cursor = new Cursor(cur);
/*     */         }
/* 467 */         catch (Exception exception) {
/*     */         
/*     */         } finally {
/* 470 */           locale.exit();
/*     */         } 
/* 472 */         release();
/* 473 */         return cursor;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void release() {
/* 479 */         if (this._cur != null) {
/* 480 */           this._cur.release();
/* 481 */           this._cur = null;
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       private Cur loadNode(Locale param2Locale, Node param2Node) {
/* 488 */         Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(param2Locale, this._options);
/*     */         
/*     */         try {
/* 491 */           loadNodeHelper(param2Locale, param2Node, curLoadContext);
/* 492 */           Cur cur = curLoadContext.finish();
/* 493 */           Locale.associateSourceName(cur, this._options);
/* 494 */           Locale.autoTypeDocument(cur, null, this._options);
/* 495 */           return cur;
/*     */         }
/* 497 */         catch (Exception exception) {
/* 498 */           throw new XmlRuntimeException(exception.getMessage(), exception);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       private void loadNodeHelper(Locale param2Locale, Node param2Node, Locale.LoadContext param2LoadContext) {
/* 504 */         if (param2Node.getNodeType() == 2) {
/* 505 */           b b = new b(param2Node.getNamespaceURI(), param2Node.getLocalName(), param2Node.getPrefix());
/*     */ 
/*     */           
/* 508 */           param2LoadContext.attr(b, param2Node.getNodeValue());
/*     */         } else {
/*     */           
/* 511 */           param2Locale.loadNode(param2Node, param2LoadContext);
/*     */         } 
/*     */       } }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\Query.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */