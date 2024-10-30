/*      */ package org.apache.commons.logging;
/*      */ 
/*      */ import java.io.BufferedReader;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.PrintStream;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.net.URL;
/*      */ import java.net.URLConnection;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.util.Enumeration;
/*      */ import java.util.Hashtable;
/*      */ import java.util.Properties;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class LogFactory
/*      */ {
/*      */   public static final String PRIORITY_KEY = "priority";
/*      */   public static final String TCCL_KEY = "use_tccl";
/*      */   public static final String FACTORY_PROPERTY = "org.apache.commons.logging.LogFactory";
/*      */   public static final String FACTORY_DEFAULT = "org.apache.commons.logging.impl.LogFactoryImpl";
/*      */   public static final String FACTORY_PROPERTIES = "commons-logging.properties";
/*      */   protected static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
/*      */   public static final String DIAGNOSTICS_DEST_PROPERTY = "org.apache.commons.logging.diagnostics.dest";
/*      */   
/*      */   static {
/*      */     String str;
/*      */   }
/*      */   
/*  136 */   private static PrintStream diagnosticsStream = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String diagnosticPrefix;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String HASHTABLE_IMPLEMENTATION_PROPERTY = "org.apache.commons.logging.LogFactory.HashtableImpl";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String WEAK_HASHTABLE_CLASSNAME = "org.apache.commons.logging.impl.WeakHashtable";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final ClassLoader thisClassLoader;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  282 */   protected static Hashtable factories = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  299 */   protected static volatile LogFactory nullClassLoaderFactory = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final Hashtable createFactoryStore() {
/*      */     String str;
/*  317 */     Hashtable hashtable = null;
/*      */     
/*      */     try {
/*  320 */       str = getSystemProperty("org.apache.commons.logging.LogFactory.HashtableImpl", null);
/*  321 */     } catch (SecurityException securityException) {
/*      */ 
/*      */       
/*  324 */       str = null;
/*      */     } 
/*      */     
/*  327 */     if (str == null) {
/*  328 */       str = "org.apache.commons.logging.impl.WeakHashtable";
/*      */     }
/*      */     try {
/*  331 */       Class clazz = Class.forName(str);
/*  332 */       hashtable = (Hashtable)clazz.newInstance();
/*  333 */     } catch (Throwable throwable) {
/*  334 */       handleThrowable(throwable);
/*      */ 
/*      */       
/*  337 */       if (!"org.apache.commons.logging.impl.WeakHashtable".equals(str))
/*      */       {
/*  339 */         if (isDiagnosticsEnabled()) {
/*      */           
/*  341 */           logDiagnostic("[ERROR] LogFactory: Load of custom hashtable failed");
/*      */         }
/*      */         else {
/*      */           
/*  345 */           System.err.println("[ERROR] LogFactory: Load of custom hashtable failed");
/*      */         } 
/*      */       }
/*      */     } 
/*  349 */     if (hashtable == null) {
/*  350 */       hashtable = new Hashtable();
/*      */     }
/*  352 */     return hashtable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String trim(String paramString) {
/*  359 */     if (paramString == null) {
/*  360 */       return null;
/*      */     }
/*  362 */     return paramString.trim();
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
/*      */   protected static void handleThrowable(Throwable paramThrowable) {
/*  378 */     if (paramThrowable instanceof ThreadDeath) {
/*  379 */       throw (ThreadDeath)paramThrowable;
/*      */     }
/*  381 */     if (paramThrowable instanceof VirtualMachineError) {
/*  382 */       throw (VirtualMachineError)paramThrowable;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LogFactory getFactory() throws LogConfigurationException {
/*  419 */     ClassLoader classLoader1 = getContextClassLoaderInternal();
/*      */     
/*  421 */     if (classLoader1 == null)
/*      */     {
/*      */ 
/*      */       
/*  425 */       if (isDiagnosticsEnabled()) {
/*  426 */         logDiagnostic("Context classloader is null.");
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*  431 */     LogFactory logFactory = getCachedFactory(classLoader1);
/*  432 */     if (logFactory != null) {
/*  433 */       return logFactory;
/*      */     }
/*      */     
/*  436 */     if (isDiagnosticsEnabled()) {
/*  437 */       logDiagnostic("[LOOKUP] LogFactory implementation requested for the first time for context classloader " + objectId(classLoader1));
/*      */ 
/*      */       
/*  440 */       logHierarchy("[LOOKUP] ", classLoader1);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  453 */     Properties properties = getConfigurationFile(classLoader1, "commons-logging.properties");
/*      */ 
/*      */ 
/*      */     
/*  457 */     ClassLoader classLoader2 = classLoader1;
/*  458 */     if (properties != null) {
/*  459 */       String str = properties.getProperty("use_tccl");
/*  460 */       if (str != null)
/*      */       {
/*      */         
/*  463 */         if (!Boolean.valueOf(str).booleanValue())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  471 */           classLoader2 = thisClassLoader;
/*      */         }
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  478 */     if (isDiagnosticsEnabled()) {
/*  479 */       logDiagnostic("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/*  484 */       String str = getSystemProperty("org.apache.commons.logging.LogFactory", null);
/*  485 */       if (str != null) {
/*  486 */         if (isDiagnosticsEnabled()) {
/*  487 */           logDiagnostic("[LOOKUP] Creating an instance of LogFactory class '" + str + "' as specified by system property " + "org.apache.commons.logging.LogFactory");
/*      */         }
/*      */         
/*  490 */         logFactory = newFactory(str, classLoader2, classLoader1);
/*      */       }
/*  492 */       else if (isDiagnosticsEnabled()) {
/*  493 */         logDiagnostic("[LOOKUP] No system property [org.apache.commons.logging.LogFactory] defined.");
/*      */       }
/*      */     
/*  496 */     } catch (SecurityException securityException) {
/*  497 */       if (isDiagnosticsEnabled()) {
/*  498 */         logDiagnostic("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [" + trim(securityException.getMessage()) + "]. Trying alternative implementations...");
/*      */       
/*      */       }
/*      */     
/*      */     }
/*  503 */     catch (RuntimeException runtimeException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  509 */       if (isDiagnosticsEnabled()) {
/*  510 */         logDiagnostic("[LOOKUP] An exception occurred while trying to create an instance of the custom factory class: [" + trim(runtimeException.getMessage()) + "] as specified by a system property.");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  515 */       throw runtimeException;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  524 */     if (logFactory == null) {
/*  525 */       if (isDiagnosticsEnabled()) {
/*  526 */         logDiagnostic("[LOOKUP] Looking for a resource file of name [META-INF/services/org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
/*      */       }
/*      */       
/*      */       try {
/*  530 */         InputStream inputStream = getResourceAsStream(classLoader1, "META-INF/services/org.apache.commons.logging.LogFactory");
/*      */         
/*  532 */         if (inputStream != null) {
/*      */           BufferedReader bufferedReader;
/*      */ 
/*      */           
/*      */           try {
/*  537 */             bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
/*  538 */           } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  539 */             bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
/*      */           } 
/*      */           
/*  542 */           String str = bufferedReader.readLine();
/*  543 */           bufferedReader.close();
/*      */           
/*  545 */           if (str != null && !"".equals(str)) {
/*  546 */             if (isDiagnosticsEnabled()) {
/*  547 */               logDiagnostic("[LOOKUP]  Creating an instance of LogFactory class " + str + " as specified by file '" + "META-INF/services/org.apache.commons.logging.LogFactory" + "' which was present in the path of the context classloader.");
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*  552 */             logFactory = newFactory(str, classLoader2, classLoader1);
/*      */           }
/*      */         
/*      */         }
/*  556 */         else if (isDiagnosticsEnabled()) {
/*  557 */           logDiagnostic("[LOOKUP] No resource file with name 'META-INF/services/org.apache.commons.logging.LogFactory' found.");
/*      */         }
/*      */       
/*  560 */       } catch (Exception exception) {
/*      */ 
/*      */ 
/*      */         
/*  564 */         if (isDiagnosticsEnabled()) {
/*  565 */           logDiagnostic("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [" + trim(exception.getMessage()) + "]. Trying alternative implementations...");
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  577 */     if (logFactory == null) {
/*  578 */       if (properties != null) {
/*  579 */         if (isDiagnosticsEnabled()) {
/*  580 */           logDiagnostic("[LOOKUP] Looking in properties file for entry with key 'org.apache.commons.logging.LogFactory' to define the LogFactory subclass to use...");
/*      */         }
/*      */ 
/*      */         
/*  584 */         String str = properties.getProperty("org.apache.commons.logging.LogFactory");
/*  585 */         if (str != null) {
/*  586 */           if (isDiagnosticsEnabled()) {
/*  587 */             logDiagnostic("[LOOKUP] Properties file specifies LogFactory subclass '" + str + "'");
/*      */           }
/*      */           
/*  590 */           logFactory = newFactory(str, classLoader2, classLoader1);
/*      */ 
/*      */         
/*      */         }
/*  594 */         else if (isDiagnosticsEnabled()) {
/*  595 */           logDiagnostic("[LOOKUP] Properties file has no entry specifying LogFactory subclass.");
/*      */         }
/*      */       
/*      */       }
/*  599 */       else if (isDiagnosticsEnabled()) {
/*  600 */         logDiagnostic("[LOOKUP] No properties file available to determine LogFactory subclass from..");
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  607 */     if (logFactory == null) {
/*  608 */       if (isDiagnosticsEnabled()) {
/*  609 */         logDiagnostic("[LOOKUP] Loading the default LogFactory implementation 'org.apache.commons.logging.impl.LogFactoryImpl' via the same classloader that loaded this LogFactory class (ie not looking in the context classloader).");
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
/*  624 */       logFactory = newFactory("org.apache.commons.logging.impl.LogFactoryImpl", thisClassLoader, classLoader1);
/*      */     } 
/*      */     
/*  627 */     if (logFactory != null) {
/*      */ 
/*      */ 
/*      */       
/*  631 */       cacheFactory(classLoader1, logFactory);
/*      */       
/*  633 */       if (properties != null) {
/*  634 */         Enumeration enumeration = properties.propertyNames();
/*  635 */         while (enumeration.hasMoreElements()) {
/*  636 */           String str1 = (String)enumeration.nextElement();
/*  637 */           String str2 = properties.getProperty(str1);
/*  638 */           logFactory.setAttribute(str1, str2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  643 */     return logFactory;
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
/*      */   public static Log getLog(Class paramClass) throws LogConfigurationException {
/*  655 */     return getFactory().getInstance(paramClass);
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
/*      */   public static Log getLog(String paramString) throws LogConfigurationException {
/*  669 */     return getFactory().getInstance(paramString);
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
/*      */   public static void release(ClassLoader paramClassLoader) {
/*  681 */     if (isDiagnosticsEnabled()) {
/*  682 */       logDiagnostic("Releasing factory for classloader " + objectId(paramClassLoader));
/*      */     }
/*      */     
/*  685 */     Hashtable hashtable = factories;
/*  686 */     synchronized (hashtable) {
/*  687 */       if (paramClassLoader == null) {
/*  688 */         if (nullClassLoaderFactory != null) {
/*  689 */           nullClassLoaderFactory.release();
/*  690 */           nullClassLoaderFactory = null;
/*      */         } 
/*      */       } else {
/*  693 */         LogFactory logFactory = (LogFactory)hashtable.get(paramClassLoader);
/*  694 */         if (logFactory != null) {
/*  695 */           logFactory.release();
/*  696 */           hashtable.remove(paramClassLoader);
/*      */         } 
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
/*      */   public static void releaseAll() {
/*  711 */     if (isDiagnosticsEnabled()) {
/*  712 */       logDiagnostic("Releasing factory for all classloaders.");
/*      */     }
/*      */     
/*  715 */     Hashtable hashtable = factories;
/*  716 */     synchronized (hashtable) {
/*  717 */       Enumeration enumeration = hashtable.elements();
/*  718 */       while (enumeration.hasMoreElements()) {
/*  719 */         LogFactory logFactory = enumeration.nextElement();
/*  720 */         logFactory.release();
/*      */       } 
/*  722 */       hashtable.clear();
/*      */       
/*  724 */       if (nullClassLoaderFactory != null) {
/*  725 */         nullClassLoaderFactory.release();
/*  726 */         nullClassLoaderFactory = null;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static ClassLoader getClassLoader(Class paramClass) {
/*      */     try {
/*  762 */       return paramClass.getClassLoader();
/*  763 */     } catch (SecurityException securityException) {
/*  764 */       if (isDiagnosticsEnabled()) {
/*  765 */         logDiagnostic("Unable to get classloader for class '" + paramClass + "' due to security restrictions - " + securityException.getMessage());
/*      */       }
/*      */       
/*  768 */       throw securityException;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static ClassLoader getContextClassLoader() throws LogConfigurationException {
/*  790 */     return directGetContextClassLoader();
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
/*      */   private static ClassLoader getContextClassLoaderInternal() throws LogConfigurationException {
/*  808 */     return AccessController.<ClassLoader>doPrivileged(new PrivilegedAction()
/*      */         {
/*      */           public Object run() {
/*  811 */             return LogFactory.directGetContextClassLoader();
/*      */           }
/*      */         });
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
/*      */   protected static ClassLoader directGetContextClassLoader() throws LogConfigurationException {
/*  837 */     ClassLoader classLoader = null;
/*      */     
/*      */     try {
/*  840 */       classLoader = Thread.currentThread().getContextClassLoader();
/*  841 */     } catch (SecurityException securityException) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  855 */     return classLoader;
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
/*      */   private static LogFactory getCachedFactory(ClassLoader paramClassLoader) {
/*  873 */     if (paramClassLoader == null)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  878 */       return nullClassLoaderFactory;
/*      */     }
/*  880 */     return (LogFactory)factories.get(paramClassLoader);
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
/*      */   private static void cacheFactory(ClassLoader paramClassLoader, LogFactory paramLogFactory) {
/*  897 */     if (paramLogFactory != null) {
/*  898 */       if (paramClassLoader == null) {
/*  899 */         nullClassLoaderFactory = paramLogFactory;
/*      */       } else {
/*  901 */         factories.put(paramClassLoader, paramLogFactory);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static LogFactory newFactory(String paramString, ClassLoader paramClassLoader1, ClassLoader paramClassLoader2) throws LogConfigurationException {
/*  957 */     LogConfigurationException logConfigurationException = (LogConfigurationException)AccessController.doPrivileged(new PrivilegedAction(paramString, paramClassLoader1) { private final String val$factoryClass;
/*      */           
/*      */           public Object run() {
/*  960 */             return LogFactory.createFactory(this.val$factoryClass, this.val$classLoader);
/*      */           }
/*      */           private final ClassLoader val$classLoader; }
/*      */       );
/*  964 */     if (logConfigurationException instanceof LogConfigurationException) {
/*  965 */       LogConfigurationException logConfigurationException1 = logConfigurationException;
/*  966 */       if (isDiagnosticsEnabled()) {
/*  967 */         logDiagnostic("An error occurred while loading the factory class:" + logConfigurationException1.getMessage());
/*      */       }
/*  969 */       throw logConfigurationException1;
/*      */     } 
/*  971 */     if (isDiagnosticsEnabled()) {
/*  972 */       logDiagnostic("Created object " + objectId(logConfigurationException) + " to manage classloader " + objectId(paramClassLoader2));
/*      */     }
/*      */     
/*  975 */     return (LogFactory)logConfigurationException;
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
/*      */   protected static LogFactory newFactory(String paramString, ClassLoader paramClassLoader) {
/*  995 */     return newFactory(paramString, paramClassLoader, null);
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
/*      */   protected static Object createFactory(String paramString, ClassLoader paramClassLoader) {
/* 1012 */     Class clazz = null;
/*      */     try {
/* 1014 */       if (paramClassLoader != null) {
/*      */         
/*      */         try {
/*      */ 
/*      */ 
/*      */           
/* 1020 */           clazz = paramClassLoader.loadClass(paramString);
/* 1021 */           if (LogFactory.class.isAssignableFrom(clazz)) {
/* 1022 */             if (isDiagnosticsEnabled()) {
/* 1023 */               logDiagnostic("Loaded class " + clazz.getName() + " from classloader " + objectId(paramClassLoader));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/* 1038 */           else if (isDiagnosticsEnabled()) {
/* 1039 */             logDiagnostic("Factory class " + clazz.getName() + " loaded from classloader " + objectId(clazz.getClassLoader()) + " does not extend '" + LogFactory.class.getName() + "' as loaded by this classloader.");
/*      */ 
/*      */ 
/*      */             
/* 1043 */             logHierarchy("[BAD CL TREE] ", paramClassLoader);
/*      */           } 
/*      */ 
/*      */           
/* 1047 */           return clazz.newInstance();
/*      */         }
/* 1049 */         catch (ClassNotFoundException classNotFoundException) {
/* 1050 */           if (paramClassLoader == thisClassLoader)
/*      */           {
/* 1052 */             if (isDiagnosticsEnabled()) {
/* 1053 */               logDiagnostic("Unable to locate any class called '" + paramString + "' via classloader " + objectId(paramClassLoader));
/*      */             }
/*      */             
/* 1056 */             throw classNotFoundException;
/*      */           }
/*      */         
/* 1059 */         } catch (NoClassDefFoundError noClassDefFoundError) {
/* 1060 */           if (paramClassLoader == thisClassLoader)
/*      */           {
/* 1062 */             if (isDiagnosticsEnabled()) {
/* 1063 */               logDiagnostic("Class '" + paramString + "' cannot be loaded" + " via classloader " + objectId(paramClassLoader) + " - it depends on some other class that cannot be found.");
/*      */             }
/*      */ 
/*      */             
/* 1067 */             throw noClassDefFoundError;
/*      */           }
/*      */         
/* 1070 */         } catch (ClassCastException classCastException) {
/* 1071 */           if (paramClassLoader == thisClassLoader) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1077 */             boolean bool = implementsLogFactory(clazz);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1084 */             StringBuffer stringBuffer = new StringBuffer();
/* 1085 */             stringBuffer.append("The application has specified that a custom LogFactory implementation ");
/* 1086 */             stringBuffer.append("should be used but Class '");
/* 1087 */             stringBuffer.append(paramString);
/* 1088 */             stringBuffer.append("' cannot be converted to '");
/* 1089 */             stringBuffer.append(LogFactory.class.getName());
/* 1090 */             stringBuffer.append("'. ");
/* 1091 */             if (bool) {
/* 1092 */               stringBuffer.append("The conflict is caused by the presence of multiple LogFactory classes ");
/* 1093 */               stringBuffer.append("in incompatible classloaders. ");
/* 1094 */               stringBuffer.append("Background can be found in http://commons.apache.org/logging/tech.html. ");
/* 1095 */               stringBuffer.append("If you have not explicitly specified a custom LogFactory then it is likely ");
/* 1096 */               stringBuffer.append("that the container has set one without your knowledge. ");
/* 1097 */               stringBuffer.append("In this case, consider using the commons-logging-adapters.jar file or ");
/* 1098 */               stringBuffer.append("specifying the standard LogFactory from the command line. ");
/*      */             } else {
/* 1100 */               stringBuffer.append("Please check the custom implementation. ");
/*      */             } 
/* 1102 */             stringBuffer.append("Help can be found @http://commons.apache.org/logging/troubleshooting.html.");
/*      */             
/* 1104 */             if (isDiagnosticsEnabled()) {
/* 1105 */               logDiagnostic(stringBuffer.toString());
/*      */             }
/*      */             
/* 1108 */             throw new ClassCastException(stringBuffer.toString());
/*      */           } 
/*      */         } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1142 */       if (isDiagnosticsEnabled()) {
/* 1143 */         logDiagnostic("Unable to load factory class via classloader " + objectId(paramClassLoader) + " - trying the classloader associated with this LogFactory.");
/*      */       }
/*      */       
/* 1146 */       clazz = Class.forName(paramString);
/* 1147 */       return clazz.newInstance();
/* 1148 */     } catch (Exception exception) {
/*      */       
/* 1150 */       if (isDiagnosticsEnabled()) {
/* 1151 */         logDiagnostic("Unable to create LogFactory instance.");
/*      */       }
/* 1153 */       if (clazz != null && !LogFactory.class.isAssignableFrom(clazz)) {
/* 1154 */         return new LogConfigurationException("The chosen LogFactory implementation does not extend LogFactory. Please check your configuration.", exception);
/*      */       }
/*      */ 
/*      */       
/* 1158 */       return new LogConfigurationException(exception);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean implementsLogFactory(Class paramClass) {
/* 1175 */     boolean bool = false;
/* 1176 */     if (paramClass != null) {
/*      */       try {
/* 1178 */         ClassLoader classLoader = paramClass.getClassLoader();
/* 1179 */         if (classLoader == null) {
/* 1180 */           logDiagnostic("[CUSTOM LOG FACTORY] was loaded by the boot classloader");
/*      */         } else {
/* 1182 */           logHierarchy("[CUSTOM LOG FACTORY] ", classLoader);
/* 1183 */           Class clazz = Class.forName("org.apache.commons.logging.LogFactory", false, classLoader);
/*      */           
/* 1185 */           bool = clazz.isAssignableFrom(paramClass);
/* 1186 */           if (bool) {
/* 1187 */             logDiagnostic("[CUSTOM LOG FACTORY] " + paramClass.getName() + " implements LogFactory but was loaded by an incompatible classloader.");
/*      */           } else {
/*      */             
/* 1190 */             logDiagnostic("[CUSTOM LOG FACTORY] " + paramClass.getName() + " does not implement LogFactory.");
/*      */           }
/*      */         
/*      */         } 
/* 1194 */       } catch (SecurityException securityException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1200 */         logDiagnostic("[CUSTOM LOG FACTORY] SecurityException thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: " + securityException.getMessage());
/*      */       }
/* 1202 */       catch (LinkageError linkageError) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1209 */         logDiagnostic("[CUSTOM LOG FACTORY] LinkageError thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: " + linkageError.getMessage());
/*      */       }
/* 1211 */       catch (ClassNotFoundException classNotFoundException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1219 */         logDiagnostic("[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by classloader which loaded the custom LogFactory implementation. Is the custom factory in the right classloader?");
/*      */       } 
/*      */     }
/*      */     
/* 1223 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static InputStream getResourceAsStream(ClassLoader paramClassLoader, String paramString) {
/* 1233 */     return AccessController.<InputStream>doPrivileged(new PrivilegedAction(paramClassLoader, paramString) { private final ClassLoader val$loader; private final String val$name;
/*      */           
/*      */           public Object run() {
/* 1236 */             if (this.val$loader != null) {
/* 1237 */               return this.val$loader.getResourceAsStream(this.val$name);
/*      */             }
/* 1239 */             return ClassLoader.getSystemResourceAsStream(this.val$name);
/*      */           } }
/*      */       );
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
/*      */   private static Enumeration getResources(ClassLoader paramClassLoader, String paramString) {
/* 1259 */     PrivilegedAction privilegedAction = new PrivilegedAction(paramClassLoader, paramString) { private final ClassLoader val$loader; private final String val$name;
/*      */         
/*      */         public Object run() {
/*      */           try {
/* 1263 */             if (this.val$loader != null) {
/* 1264 */               return this.val$loader.getResources(this.val$name);
/*      */             }
/* 1266 */             return ClassLoader.getSystemResources(this.val$name);
/*      */           }
/* 1268 */           catch (IOException iOException) {
/* 1269 */             if (LogFactory.isDiagnosticsEnabled()) {
/* 1270 */               LogFactory.logDiagnostic("Exception while trying to find configuration file " + this.val$name + ":" + iOException.getMessage());
/*      */             }
/*      */             
/* 1273 */             return null;
/* 1274 */           } catch (NoSuchMethodError noSuchMethodError) {
/*      */ 
/*      */ 
/*      */             
/* 1278 */             return null;
/*      */           } 
/*      */         } }
/*      */       ;
/* 1282 */     Enumeration enumeration = (Enumeration)AccessController.doPrivileged(privilegedAction);
/* 1283 */     return enumeration;
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
/*      */   private static Properties getProperties(URL paramURL) {
/* 1295 */     PrivilegedAction privilegedAction = new PrivilegedAction(paramURL) { private final URL val$url;
/*      */         
/*      */         public Object run() {
/* 1298 */           InputStream inputStream = null;
/*      */ 
/*      */ 
/*      */           
/*      */           try {
/* 1303 */             URLConnection uRLConnection = this.val$url.openConnection();
/* 1304 */             uRLConnection.setUseCaches(false);
/* 1305 */             inputStream = uRLConnection.getInputStream();
/* 1306 */             if (inputStream != null) {
/* 1307 */               Properties properties = new Properties();
/* 1308 */               properties.load(inputStream);
/* 1309 */               inputStream.close();
/* 1310 */               inputStream = null;
/* 1311 */               return properties;
/*      */             } 
/* 1313 */           } catch (IOException iOException) {
/* 1314 */             if (LogFactory.isDiagnosticsEnabled()) {
/* 1315 */               LogFactory.logDiagnostic("Unable to read URL " + this.val$url);
/*      */             }
/*      */           } finally {
/* 1318 */             if (inputStream != null) {
/*      */               try {
/* 1320 */                 inputStream.close();
/* 1321 */               } catch (IOException iOException) {
/*      */                 
/* 1323 */                 if (LogFactory.isDiagnosticsEnabled()) {
/* 1324 */                   LogFactory.logDiagnostic("Unable to close stream for URL " + this.val$url);
/*      */                 }
/*      */               } 
/*      */             }
/*      */           } 
/*      */           
/* 1330 */           return null;
/*      */         } }
/*      */       ;
/* 1333 */     return AccessController.<Properties>doPrivileged(privilegedAction);
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
/*      */   private static final Properties getConfigurationFile(ClassLoader paramClassLoader, String paramString) {
/* 1356 */     Properties properties = null;
/* 1357 */     double d = 0.0D;
/* 1358 */     URL uRL = null;
/*      */     try {
/* 1360 */       Enumeration enumeration = getResources(paramClassLoader, paramString);
/*      */       
/* 1362 */       if (enumeration == null) {
/* 1363 */         return null;
/*      */       }
/*      */       
/* 1366 */       while (enumeration.hasMoreElements()) {
/* 1367 */         URL uRL1 = enumeration.nextElement();
/*      */         
/* 1369 */         Properties properties1 = getProperties(uRL1);
/* 1370 */         if (properties1 != null) {
/* 1371 */           if (properties == null) {
/* 1372 */             uRL = uRL1;
/* 1373 */             properties = properties1;
/* 1374 */             String str1 = properties.getProperty("priority");
/* 1375 */             d = 0.0D;
/* 1376 */             if (str1 != null) {
/* 1377 */               d = Double.parseDouble(str1);
/*      */             }
/*      */             
/* 1380 */             if (isDiagnosticsEnabled()) {
/* 1381 */               logDiagnostic("[LOOKUP] Properties file found at '" + uRL1 + "'" + " with priority " + d);
/*      */             }
/*      */             continue;
/*      */           } 
/* 1385 */           String str = properties1.getProperty("priority");
/* 1386 */           double d1 = 0.0D;
/* 1387 */           if (str != null) {
/* 1388 */             d1 = Double.parseDouble(str);
/*      */           }
/*      */           
/* 1391 */           if (d1 > d) {
/* 1392 */             if (isDiagnosticsEnabled()) {
/* 1393 */               logDiagnostic("[LOOKUP] Properties file at '" + uRL1 + "'" + " with priority " + d1 + " overrides file at '" + uRL + "'" + " with priority " + d);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1399 */             uRL = uRL1;
/* 1400 */             properties = properties1;
/* 1401 */             d = d1; continue;
/*      */           } 
/* 1403 */           if (isDiagnosticsEnabled()) {
/* 1404 */             logDiagnostic("[LOOKUP] Properties file at '" + uRL1 + "'" + " with priority " + d1 + " does not override file at '" + uRL + "'" + " with priority " + d);
/*      */           
/*      */           }
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*      */     
/*      */     }
/* 1414 */     catch (SecurityException securityException) {
/* 1415 */       if (isDiagnosticsEnabled()) {
/* 1416 */         logDiagnostic("SecurityException thrown while trying to find/read config files.");
/*      */       }
/*      */     } 
/*      */     
/* 1420 */     if (isDiagnosticsEnabled()) {
/* 1421 */       if (properties == null) {
/* 1422 */         logDiagnostic("[LOOKUP] No properties file of name '" + paramString + "' found.");
/*      */       } else {
/* 1424 */         logDiagnostic("[LOOKUP] Properties file of name '" + paramString + "' found at '" + uRL + '"');
/*      */       } 
/*      */     }
/*      */     
/* 1428 */     return properties;
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
/*      */   private static String getSystemProperty(String paramString1, String paramString2) throws SecurityException {
/* 1442 */     return AccessController.<String>doPrivileged(new PrivilegedAction(paramString1, paramString2) { private final String val$key; private final String val$def;
/*      */           
/*      */           public Object run() {
/* 1445 */             return System.getProperty(this.val$key, this.val$def);
/*      */           } }
/*      */       );
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static PrintStream initDiagnostics() {
/*      */     String str;
/*      */     try {
/* 1459 */       str = getSystemProperty("org.apache.commons.logging.diagnostics.dest", null);
/* 1460 */       if (str == null) {
/* 1461 */         return null;
/*      */       }
/* 1463 */     } catch (SecurityException securityException) {
/*      */ 
/*      */       
/* 1466 */       return null;
/*      */     } 
/*      */     
/* 1469 */     if (str.equals("STDOUT"))
/* 1470 */       return System.out; 
/* 1471 */     if (str.equals("STDERR")) {
/* 1472 */       return System.err;
/*      */     }
/*      */     
/*      */     try {
/* 1476 */       FileOutputStream fileOutputStream = new FileOutputStream(str, true);
/* 1477 */       return new PrintStream(fileOutputStream);
/* 1478 */     } catch (IOException iOException) {
/*      */       
/* 1480 */       return null;
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
/*      */ 
/*      */   
/*      */   protected static boolean isDiagnosticsEnabled() {
/* 1495 */     return (diagnosticsStream != null);
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
/*      */   private static final void logDiagnostic(String paramString) {
/* 1517 */     if (diagnosticsStream != null) {
/* 1518 */       diagnosticsStream.print(diagnosticPrefix);
/* 1519 */       diagnosticsStream.println(paramString);
/* 1520 */       diagnosticsStream.flush();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static final void logRawDiagnostic(String paramString) {
/* 1531 */     if (diagnosticsStream != null) {
/* 1532 */       diagnosticsStream.println(paramString);
/* 1533 */       diagnosticsStream.flush();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void logClassLoaderEnvironment(Class paramClass) {
/*      */     ClassLoader classLoader;
/* 1555 */     if (!isDiagnosticsEnabled()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1563 */       logDiagnostic("[ENV] Extension directories (java.ext.dir): " + System.getProperty("java.ext.dir"));
/* 1564 */       logDiagnostic("[ENV] Application classpath (java.class.path): " + System.getProperty("java.class.path"));
/* 1565 */     } catch (SecurityException securityException) {
/* 1566 */       logDiagnostic("[ENV] Security setting prevent interrogation of system classpaths.");
/*      */     } 
/*      */     
/* 1569 */     String str = paramClass.getName();
/*      */ 
/*      */     
/*      */     try {
/* 1573 */       classLoader = getClassLoader(paramClass);
/* 1574 */     } catch (SecurityException securityException) {
/*      */       
/* 1576 */       logDiagnostic("[ENV] Security forbids determining the classloader for " + str);
/*      */       
/*      */       return;
/*      */     } 
/* 1580 */     logDiagnostic("[ENV] Class " + str + " was loaded via classloader " + objectId(classLoader));
/* 1581 */     logHierarchy("[ENV] Ancestry of classloader which loaded " + str + " is ", classLoader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void logHierarchy(String paramString, ClassLoader paramClassLoader) {
/*      */     ClassLoader classLoader;
/* 1592 */     if (!isDiagnosticsEnabled()) {
/*      */       return;
/*      */     }
/*      */     
/* 1596 */     if (paramClassLoader != null) {
/* 1597 */       String str = paramClassLoader.toString();
/* 1598 */       logDiagnostic(paramString + objectId(paramClassLoader) + " == '" + str + "'");
/*      */     } 
/*      */     
/*      */     try {
/* 1602 */       classLoader = ClassLoader.getSystemClassLoader();
/* 1603 */     } catch (SecurityException securityException) {
/* 1604 */       logDiagnostic(paramString + "Security forbids determining the system classloader.");
/*      */       return;
/*      */     } 
/* 1607 */     if (paramClassLoader != null) {
/* 1608 */       StringBuffer stringBuffer = new StringBuffer(paramString + "ClassLoader tree:");
/*      */       while (true) {
/* 1610 */         stringBuffer.append(objectId(paramClassLoader));
/* 1611 */         if (paramClassLoader == classLoader) {
/* 1612 */           stringBuffer.append(" (SYSTEM) ");
/*      */         }
/*      */         
/*      */         try {
/* 1616 */           paramClassLoader = paramClassLoader.getParent();
/* 1617 */         } catch (SecurityException securityException) {
/* 1618 */           stringBuffer.append(" --> SECRET");
/*      */           
/*      */           break;
/*      */         } 
/* 1622 */         stringBuffer.append(" --> ");
/* 1623 */         if (paramClassLoader == null) {
/* 1624 */           stringBuffer.append("BOOT");
/*      */           break;
/*      */         } 
/*      */       } 
/* 1628 */       logDiagnostic(stringBuffer.toString());
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String objectId(Object paramObject) {
/* 1645 */     if (paramObject == null) {
/* 1646 */       return "null";
/*      */     }
/* 1648 */     return paramObject.getClass().getName() + "@" + System.identityHashCode(paramObject);
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
/*      */   static {
/* 1674 */     thisClassLoader = getClassLoader(LogFactory.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1686 */       ClassLoader classLoader = thisClassLoader;
/* 1687 */       if (thisClassLoader == null) {
/* 1688 */         str = "BOOTLOADER";
/*      */       } else {
/* 1690 */         str = objectId(classLoader);
/*      */       } 
/* 1692 */     } catch (SecurityException securityException) {
/* 1693 */       str = "UNKNOWN";
/*      */     } 
/* 1695 */     diagnosticPrefix = "[LogFactory from " + str + "] ";
/* 1696 */     diagnosticsStream = initDiagnostics();
/* 1697 */     logClassLoaderEnvironment(LogFactory.class);
/* 1698 */     factories = createFactoryStore();
/* 1699 */     if (isDiagnosticsEnabled())
/* 1700 */       logDiagnostic("BOOTSTRAP COMPLETED"); 
/*      */   }
/*      */   
/*      */   public abstract Object getAttribute(String paramString);
/*      */   
/*      */   public abstract String[] getAttributeNames();
/*      */   
/*      */   public abstract Log getInstance(Class paramClass) throws LogConfigurationException;
/*      */   
/*      */   public abstract Log getInstance(String paramString) throws LogConfigurationException;
/*      */   
/*      */   public abstract void release();
/*      */   
/*      */   public abstract void removeAttribute(String paramString);
/*      */   
/*      */   public abstract void setAttribute(String paramString, Object paramObject);
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\LogFactory.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */