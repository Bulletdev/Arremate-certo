/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.w3c.dom.Node;
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
/*     */ public final class XmlBeans
/*     */ {
/*  37 */   private static String XMLBEANS_TITLE = "org.apache.xmlbeans";
/*  38 */   private static String XMLBEANS_VERSION = "2.6.0";
/*  39 */   private static String XMLBEANS_VENDOR = "Apache Software Foundation";
/*     */ 
/*     */   
/*     */   static {
/*  43 */     Package package_ = XmlBeans.class.getPackage();
/*  44 */     if (package_ != null) {
/*     */       
/*  46 */       XMLBEANS_TITLE = package_.getImplementationTitle();
/*  47 */       XMLBEANS_VERSION = package_.getImplementationVersion();
/*  48 */       XMLBEANS_VENDOR = package_.getImplementationVendor();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String getTitle() {
/*  59 */     return XMLBEANS_TITLE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String getVendor() {
/*  69 */     return XMLBEANS_VENDOR;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String getVersion() {
/*  79 */     return XMLBEANS_VERSION;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   private static final ThreadLocal _threadLocalLoaderQNameCache = new ThreadLocal()
/*     */     {
/*     */       
/*     */       protected Object initialValue()
/*     */       {
/*  90 */         return new SoftReference(new QNameCache(32));
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static QNameCache getQNameCache() {
/*  99 */     SoftReference softReference = _threadLocalLoaderQNameCache.get();
/* 100 */     QNameCache qNameCache = softReference.get();
/* 101 */     if (qNameCache == null) {
/*     */       
/* 103 */       qNameCache = new QNameCache(32);
/* 104 */       _threadLocalLoaderQNameCache.set(new SoftReference(qNameCache));
/*     */     } 
/* 106 */     return qNameCache;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static b getQName(String paramString) {
/* 114 */     return getQNameCache().getName("", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static b getQName(String paramString1, String paramString2) {
/* 123 */     return getQNameCache().getName(paramString1, paramString2);
/*     */   }
/*     */   
/* 126 */   private static final Method _getContextTypeLoaderMethod = buildGetContextTypeLoaderMethod();
/* 127 */   private static final Method _getBuiltinSchemaTypeSystemMethod = buildGetBuiltinSchemaTypeSystemMethod();
/* 128 */   private static final Method _getNoTypeMethod = buildGetNoTypeMethod();
/* 129 */   private static final Method _typeLoaderBuilderMethod = buildTypeLoaderBuilderMethod();
/* 130 */   private static final Method _compilationMethod = buildCompilationMethod();
/* 131 */   private static final Method _nodeToCursorMethod = buildNodeToCursorMethod();
/* 132 */   private static final Method _nodeToXmlObjectMethod = buildNodeToXmlObjectMethod();
/* 133 */   private static final Method _nodeToXmlStreamMethod = buildNodeToXmlStreamMethod();
/* 134 */   private static final Method _streamToNodeMethod = buildStreamToNodeMethod();
/* 135 */   private static final Constructor _pathResourceLoaderConstructor = buildPathResourceLoaderConstructor();
/*     */   private static final String HOLDER_CLASS_NAME = "TypeSystemHolder";
/*     */   
/*     */   private static RuntimeException causedException(RuntimeException paramRuntimeException, Throwable paramThrowable) {
/* 139 */     paramRuntimeException.initCause(paramThrowable);
/*     */     
/* 141 */     return paramRuntimeException;
/*     */   }
/*     */   private static final String TYPE_SYSTEM_FIELD = "typeSystem";
/*     */   
/*     */   private static XmlException wrappedException(Throwable paramThrowable) {
/* 146 */     if (paramThrowable instanceof XmlException) {
/* 147 */       return (XmlException)paramThrowable;
/*     */     }
/* 149 */     return new XmlException(paramThrowable.getMessage(), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Constructor buildConstructor(String paramString, Class[] paramArrayOfClass) {
/*     */     try {
/* 156 */       return Class.forName(paramString, false, XmlBeans.class.getClassLoader()).getConstructor(paramArrayOfClass);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 161 */     catch (Exception exception) {
/*     */       
/* 163 */       throw causedException(new IllegalStateException("Cannot load constructor for " + paramString + ": verify that xbean.jar is on the classpath"), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Method buildMethod(String paramString1, String paramString2, Class[] paramArrayOfClass) {
/*     */     try {
/* 174 */       return Class.forName(paramString1, false, XmlBeans.class.getClassLoader()).getMethod(paramString2, paramArrayOfClass);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 179 */     catch (Exception exception) {
/*     */       
/* 181 */       throw causedException(new IllegalStateException("Cannot load " + paramString2 + ": verify that xbean.jar is on the classpath"), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Method buildNoArgMethod(String paramString1, String paramString2) {
/* 190 */     return buildMethod(paramString1, paramString2, new Class[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final Method buildNodeMethod(String paramString1, String paramString2) {
/* 195 */     return buildMethod(paramString1, paramString2, new Class[] { Node.class });
/*     */   }
/*     */ 
/*     */   
/*     */   private static Method buildGetContextTypeLoaderMethod() {
/* 200 */     return buildNoArgMethod("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl", "getContextTypeLoader");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Method buildGetBuiltinSchemaTypeSystemMethod() {
/* 206 */     return buildNoArgMethod("org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem", "get");
/*     */   }
/*     */ 
/*     */   
/*     */   private static final Method buildGetNoTypeMethod() {
/* 211 */     return buildNoArgMethod("org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem", "getNoType");
/*     */   }
/*     */ 
/*     */   
/*     */   private static final Method buildTypeLoaderBuilderMethod() {
/* 216 */     return buildMethod("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl", "build", new Class[] { (array$Lorg$apache$xmlbeans$SchemaTypeLoader == null) ? (array$Lorg$apache$xmlbeans$SchemaTypeLoader = class$("[Lorg.apache.xmlbeans.SchemaTypeLoader;")) : array$Lorg$apache$xmlbeans$SchemaTypeLoader, ResourceLoader.class, ClassLoader.class });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Method buildCompilationMethod() {
/* 224 */     return buildMethod("org.apache.xmlbeans.impl.schema.SchemaTypeSystemCompiler", "compile", new Class[] { String.class, SchemaTypeSystem.class, (array$Lorg$apache$xmlbeans$XmlObject == null) ? (array$Lorg$apache$xmlbeans$XmlObject = class$("[Lorg.apache.xmlbeans.XmlObject;")) : array$Lorg$apache$xmlbeans$XmlObject, BindingConfig.class, SchemaTypeLoader.class, Filer.class, XmlOptions.class });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Method buildNodeToCursorMethod() {
/* 232 */     return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToCursor");
/*     */   }
/*     */ 
/*     */   
/*     */   private static final Method buildNodeToXmlObjectMethod() {
/* 237 */     return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToXmlObject");
/*     */   }
/*     */ 
/*     */   
/*     */   private static final Method buildNodeToXmlStreamMethod() {
/* 242 */     return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToXmlStream");
/*     */   }
/*     */ 
/*     */   
/*     */   private static final Method buildStreamToNodeMethod() {
/* 247 */     return buildMethod("org.apache.xmlbeans.impl.store.Locale", "streamToNode", new Class[] { XMLStreamReader.class });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Constructor buildPathResourceLoaderConstructor() {
/* 255 */     return buildConstructor("org.apache.xmlbeans.impl.schema.PathResourceLoader", new Class[] { (array$Ljava$io$File == null) ? (array$Ljava$io$File = class$("[Ljava.io.File;")) : array$Ljava$io$File });
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
/*     */   public static String compilePath(String paramString) throws XmlException {
/* 267 */     return compilePath(paramString, null);
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
/*     */   public static String compilePath(String paramString, XmlOptions paramXmlOptions) throws XmlException {
/* 284 */     return getContextTypeLoader().compilePath(paramString, paramXmlOptions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String compileQuery(String paramString) throws XmlException {
/* 293 */     return compileQuery(paramString, null);
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
/*     */   public static String compileQuery(String paramString, XmlOptions paramXmlOptions) throws XmlException {
/* 311 */     return getContextTypeLoader().compileQuery(paramString, paramXmlOptions);
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
/*     */   public static SchemaTypeLoader getContextTypeLoader() {
/*     */     try {
/* 327 */       return (SchemaTypeLoader)_getContextTypeLoaderMethod.invoke(null, null);
/*     */     }
/* 329 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 331 */       throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.getContextTypeLoader(): verify that version of xbean.jar is correct"), illegalAccessException);
/*     */     }
/* 333 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 335 */       Throwable throwable = invocationTargetException.getCause();
/* 336 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/* 337 */       illegalStateException.initCause(throwable);
/* 338 */       throw illegalStateException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SchemaTypeSystem getBuiltinTypeSystem() {
/*     */     try {
/* 350 */       return (SchemaTypeSystem)_getBuiltinSchemaTypeSystemMethod.invoke(null, null);
/*     */     }
/* 352 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 354 */       throw causedException(new IllegalStateException("No access to BuiltinSchemaTypeSystem.get(): verify that version of xbean.jar is correct"), illegalAccessException);
/*     */     }
/* 356 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 358 */       Throwable throwable = invocationTargetException.getCause();
/* 359 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/* 360 */       illegalStateException.initCause(throwable);
/* 361 */       throw illegalStateException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlCursor nodeToCursor(Node paramNode) {
/*     */     try {
/* 372 */       return (XmlCursor)_nodeToCursorMethod.invoke(null, new Object[] { paramNode });
/*     */     }
/* 374 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 376 */       throw causedException(new IllegalStateException("No access to nodeToCursor verify that version of xbean.jar is correct"), illegalAccessException);
/*     */ 
/*     */     
/*     */     }
/* 380 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 382 */       Throwable throwable = invocationTargetException.getCause();
/* 383 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/* 384 */       illegalStateException.initCause(throwable);
/* 385 */       throw illegalStateException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlObject nodeToXmlObject(Node paramNode) {
/*     */     try {
/* 396 */       return (XmlObject)_nodeToXmlObjectMethod.invoke(null, new Object[] { paramNode });
/*     */     }
/* 398 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 400 */       throw causedException(new IllegalStateException("No access to nodeToXmlObject verify that version of xbean.jar is correct"), illegalAccessException);
/*     */ 
/*     */     
/*     */     }
/* 404 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 406 */       Throwable throwable = invocationTargetException.getCause();
/* 407 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/* 408 */       illegalStateException.initCause(throwable);
/* 409 */       throw illegalStateException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMLStreamReader nodeToXmlStreamReader(Node paramNode) {
/*     */     try {
/* 420 */       return (XMLStreamReader)_nodeToXmlStreamMethod.invoke(null, new Object[] { paramNode });
/*     */     }
/* 422 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 424 */       throw causedException(new IllegalStateException("No access to nodeToXmlStreamReader verify that version of xbean.jar is correct"), illegalAccessException);
/*     */ 
/*     */     
/*     */     }
/* 428 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 430 */       Throwable throwable = invocationTargetException.getCause();
/* 431 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/* 432 */       illegalStateException.initCause(throwable);
/* 433 */       throw illegalStateException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Node streamToNode(XMLStreamReader paramXMLStreamReader) {
/*     */     try {
/* 444 */       return (Node)_streamToNodeMethod.invoke(null, new Object[] { paramXMLStreamReader });
/*     */     }
/* 446 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 448 */       throw causedException(new IllegalStateException("No access to streamToNode verify that version of xbean.jar is correct"), illegalAccessException);
/*     */ 
/*     */     
/*     */     }
/* 452 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 454 */       Throwable throwable = invocationTargetException.getCause();
/* 455 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/* 456 */       illegalStateException.initCause(throwable);
/* 457 */       throw illegalStateException;
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
/*     */   public static SchemaTypeLoader loadXsd(XmlObject[] paramArrayOfXmlObject) throws XmlException {
/* 471 */     return loadXsd(paramArrayOfXmlObject, null);
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
/*     */   public static SchemaTypeLoader loadXsd(XmlObject[] paramArrayOfXmlObject, XmlOptions paramXmlOptions) throws XmlException {
/*     */     try {
/* 498 */       SchemaTypeSystem schemaTypeSystem = (SchemaTypeSystem)_compilationMethod.invoke(null, new Object[] { null, null, paramArrayOfXmlObject, null, getContextTypeLoader(), null, paramXmlOptions });
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 503 */       if (schemaTypeSystem == null) {
/* 504 */         return null;
/*     */       }
/* 506 */       return typeLoaderUnion(new SchemaTypeLoader[] { schemaTypeSystem, getContextTypeLoader() });
/*     */ 
/*     */     
/*     */     }
/* 510 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 512 */       throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.forSchemaXml(): verify that version of xbean.jar is correct"), illegalAccessException);
/*     */     }
/* 514 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 516 */       throw wrappedException(invocationTargetException.getCause());
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
/*     */ 
/*     */   
/*     */   public static SchemaTypeSystem compileXsd(XmlObject[] paramArrayOfXmlObject, SchemaTypeLoader paramSchemaTypeLoader, XmlOptions paramXmlOptions) throws XmlException {
/* 553 */     return compileXmlBeans(null, null, paramArrayOfXmlObject, null, paramSchemaTypeLoader, null, paramXmlOptions);
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
/*     */   public static SchemaTypeSystem compileXsd(SchemaTypeSystem paramSchemaTypeSystem, XmlObject[] paramArrayOfXmlObject, SchemaTypeLoader paramSchemaTypeLoader, XmlOptions paramXmlOptions) throws XmlException {
/* 601 */     return compileXmlBeans(null, paramSchemaTypeSystem, paramArrayOfXmlObject, null, paramSchemaTypeLoader, null, paramXmlOptions);
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
/*     */   public static SchemaTypeSystem compileXmlBeans(String paramString, SchemaTypeSystem paramSchemaTypeSystem, XmlObject[] paramArrayOfXmlObject, BindingConfig paramBindingConfig, SchemaTypeLoader paramSchemaTypeLoader, Filer paramFiler, XmlOptions paramXmlOptions) throws XmlException {
/*     */     try {
/* 667 */       return (SchemaTypeSystem)_compilationMethod.invoke(null, new Object[] { paramString, paramSchemaTypeSystem, paramArrayOfXmlObject, paramBindingConfig, (paramSchemaTypeLoader != null) ? paramSchemaTypeLoader : getContextTypeLoader(), paramFiler, paramXmlOptions });
/*     */     }
/* 669 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 671 */       throw new IllegalStateException("No access to SchemaTypeLoaderImpl.forSchemaXml(): verify that version of xbean.jar is correct");
/*     */     }
/* 673 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 675 */       throw wrappedException(invocationTargetException.getCause());
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
/*     */   public static SchemaTypeLoader typeLoaderUnion(SchemaTypeLoader[] paramArrayOfSchemaTypeLoader) {
/*     */     try {
/* 689 */       if (paramArrayOfSchemaTypeLoader.length == 1) {
/* 690 */         return paramArrayOfSchemaTypeLoader[0];
/*     */       }
/* 692 */       return (SchemaTypeLoader)_typeLoaderBuilderMethod.invoke(null, new Object[] { paramArrayOfSchemaTypeLoader, null, null });
/*     */     }
/* 694 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 696 */       throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), illegalAccessException);
/*     */     }
/* 698 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 700 */       Throwable throwable = invocationTargetException.getCause();
/* 701 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/* 702 */       illegalStateException.initCause(throwable);
/* 703 */       throw illegalStateException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SchemaTypeLoader typeLoaderForClassLoader(ClassLoader paramClassLoader) {
/*     */     try {
/* 715 */       return (SchemaTypeLoader)_typeLoaderBuilderMethod.invoke(null, new Object[] { null, null, paramClassLoader });
/*     */     }
/* 717 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 719 */       throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), illegalAccessException);
/*     */     }
/* 721 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 723 */       Throwable throwable = invocationTargetException.getCause();
/* 724 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/* 725 */       illegalStateException.initCause(throwable);
/* 726 */       throw illegalStateException;
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
/*     */   public static SchemaTypeLoader typeLoaderForResource(ResourceLoader paramResourceLoader) {
/*     */     try {
/* 740 */       return (SchemaTypeLoader)_typeLoaderBuilderMethod.invoke(null, new Object[] { null, paramResourceLoader, null });
/*     */     }
/* 742 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 744 */       throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), illegalAccessException);
/*     */     }
/* 746 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 748 */       Throwable throwable = invocationTargetException.getCause();
/* 749 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/* 750 */       illegalStateException.initCause(throwable);
/* 751 */       throw illegalStateException;
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
/*     */   public static SchemaTypeSystem typeSystemForClassLoader(ClassLoader paramClassLoader, String paramString) {
/*     */     try {
/* 769 */       Class clazz = paramClassLoader.loadClass(paramString + "." + "TypeSystemHolder");
/* 770 */       SchemaTypeSystem schemaTypeSystem = (SchemaTypeSystem)clazz.getDeclaredField("typeSystem").get(null);
/*     */       
/* 772 */       if (schemaTypeSystem == null)
/*     */       {
/* 774 */         throw new RuntimeException("SchemaTypeSystem is null for field typeSystem on class with name " + paramString + "." + "TypeSystemHolder" + ". Please verify the version of xbean.jar is correct.");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 779 */       return schemaTypeSystem;
/*     */     }
/* 781 */     catch (ClassNotFoundException classNotFoundException) {
/*     */       
/* 783 */       throw causedException(new RuntimeException("Cannot load SchemaTypeSystem. Unable to load class with name " + paramString + "." + "TypeSystemHolder" + ". Make sure the generated binary files are on the classpath."), classNotFoundException);
/*     */ 
/*     */     
/*     */     }
/* 787 */     catch (NoSuchFieldException noSuchFieldException) {
/*     */       
/* 789 */       throw causedException(new RuntimeException("Cannot find field typeSystem on class " + paramString + "." + "TypeSystemHolder" + ". Please verify the version of xbean.jar is correct."), noSuchFieldException);
/*     */ 
/*     */     
/*     */     }
/* 793 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 795 */       throw causedException(new RuntimeException("Field typeSystem on class " + paramString + "." + "TypeSystemHolder" + "is not accessible. Please verify the version of xbean.jar is correct."), illegalAccessException);
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
/*     */   public static ResourceLoader resourceLoaderForPath(File[] paramArrayOfFile) {
/*     */     try {
/* 809 */       return _pathResourceLoaderConstructor.newInstance(new Object[] { paramArrayOfFile });
/*     */     }
/* 811 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 813 */       throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), illegalAccessException);
/*     */     }
/* 815 */     catch (InstantiationException instantiationException) {
/*     */       
/* 817 */       throw causedException(new IllegalStateException(instantiationException.getMessage()), instantiationException);
/*     */     }
/* 819 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 821 */       Throwable throwable = invocationTargetException.getCause();
/* 822 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/* 823 */       illegalStateException.initCause(throwable);
/* 824 */       throw illegalStateException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SchemaType typeForClass(Class paramClass) {
/* 834 */     if (paramClass == null || !XmlObject.class.isAssignableFrom(paramClass)) {
/* 835 */       return null;
/*     */     }
/*     */     
/*     */     try {
/* 839 */       Field field = paramClass.getField("type");
/*     */       
/* 841 */       if (field == null) {
/* 842 */         return null;
/*     */       }
/* 844 */       return (SchemaType)field.get(null);
/*     */     }
/* 846 */     catch (Exception exception) {
/*     */       
/* 848 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static SchemaType getNoType() {
/*     */     try {
/* 856 */       return (SchemaType)_getNoTypeMethod.invoke(null, null);
/*     */     }
/* 858 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 860 */       throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.getContextTypeLoader(): verify that version of xbean.jar is correct"), illegalAccessException);
/*     */     }
/* 862 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 864 */       Throwable throwable = invocationTargetException.getCause();
/* 865 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/* 866 */       illegalStateException.initCause(throwable);
/* 867 */       throw illegalStateException;
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
/* 881 */   public static SchemaType NO_TYPE = getNoType();
/*     */   static Class array$Lorg$apache$xmlbeans$SchemaTypeLoader;
/*     */   static Class array$Lorg$apache$xmlbeans$XmlObject;
/*     */   static Class array$Ljava$io$File;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlBeans.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */