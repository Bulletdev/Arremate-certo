/*      */ package org.apache.commons.logging.impl;
/*      */ 
/*      */ import java.io.PrintWriter;
/*      */ import java.io.StringWriter;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.net.URL;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.util.Hashtable;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.apache.commons.logging.LogConfigurationException;
/*      */ import org.apache.commons.logging.LogFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class LogFactoryImpl
/*      */   extends LogFactory
/*      */ {
/*      */   private static final String LOGGING_IMPL_LOG4J_LOGGER = "org.apache.commons.logging.impl.Log4JLogger";
/*      */   private static final String LOGGING_IMPL_JDK14_LOGGER = "org.apache.commons.logging.impl.Jdk14Logger";
/*      */   private static final String LOGGING_IMPL_LUMBERJACK_LOGGER = "org.apache.commons.logging.impl.Jdk13LumberjackLogger";
/*      */   private static final String LOGGING_IMPL_SIMPLE_LOGGER = "org.apache.commons.logging.impl.SimpleLog";
/*      */   private static final String PKG_IMPL = "org.apache.commons.logging.impl.";
/*   78 */   private static final int PKG_LEN = "org.apache.commons.logging.impl.".length();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String ALLOW_FLAWED_CONTEXT_PROPERTY = "org.apache.commons.logging.Log.allowFlawedContext";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String ALLOW_FLAWED_DISCOVERY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedDiscovery";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String ALLOW_FLAWED_HIERARCHY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedHierarchy";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LogFactoryImpl() {
/*  175 */     this.useTCCL = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  185 */     this.attributes = new Hashtable();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  191 */     this.instances = new Hashtable();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  205 */     this.logConstructor = null;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  210 */     this.logConstructorSignature = new Class[] { String.class };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  216 */     this.logMethod = null;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  221 */     this.logMethodSignature = new Class[] { LogFactory.class };
/*      */     initDiagnostics();
/*      */     if (isDiagnosticsEnabled()) {
/*      */       logDiagnostic("Instance created.");
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final String[] classesToDiscover = new String[] { "org.apache.commons.logging.impl.Log4JLogger", "org.apache.commons.logging.impl.Jdk14Logger", "org.apache.commons.logging.impl.Jdk13LumberjackLogger", "org.apache.commons.logging.impl.SimpleLog" };
/*      */   
/*      */   private boolean useTCCL;
/*      */   
/*      */   private String diagnosticPrefix;
/*      */   
/*      */   protected Hashtable attributes;
/*      */   protected Hashtable instances;
/*      */   private String logClassName;
/*      */   protected Constructor logConstructor;
/*      */   protected Class[] logConstructorSignature;
/*      */   protected Method logMethod;
/*      */   protected Class[] logMethodSignature;
/*      */   private boolean allowFlawedContext;
/*      */   private boolean allowFlawedDiscovery;
/*      */   private boolean allowFlawedHierarchy;
/*      */   
/*      */   public Object getAttribute(String paramString) {
/*  247 */     return this.attributes.get(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getAttributeNames() {
/*  256 */     return (String[])this.attributes.keySet().toArray((Object[])new String[this.attributes.size()]);
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
/*      */   public Log getInstance(Class paramClass) throws LogConfigurationException {
/*  269 */     return getInstance(paramClass.getName());
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
/*      */   public Log getInstance(String paramString) throws LogConfigurationException {
/*  290 */     Log log = (Log)this.instances.get(paramString);
/*  291 */     if (log == null) {
/*  292 */       log = newInstance(paramString);
/*  293 */       this.instances.put(paramString, log);
/*      */     } 
/*  295 */     return log;
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
/*      */   public void release() {
/*  308 */     logDiagnostic("Releasing all known loggers");
/*  309 */     this.instances.clear();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeAttribute(String paramString) {
/*  319 */     this.attributes.remove(paramString);
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
/*      */   public void setAttribute(String paramString, Object paramObject) {
/*  347 */     if (this.logConstructor != null) {
/*  348 */       logDiagnostic("setAttribute: call too late; configuration already performed.");
/*      */     }
/*      */     
/*  351 */     if (paramObject == null) {
/*  352 */       this.attributes.remove(paramString);
/*      */     } else {
/*  354 */       this.attributes.put(paramString, paramObject);
/*      */     } 
/*      */     
/*  357 */     if (paramString.equals("use_tccl")) {
/*  358 */       this.useTCCL = (paramObject != null && Boolean.valueOf(paramObject.toString()).booleanValue());
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
/*      */   protected static ClassLoader getContextClassLoader() throws LogConfigurationException {
/*  375 */     return LogFactory.getContextClassLoader();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean isDiagnosticsEnabled() {
/*  383 */     return LogFactory.isDiagnosticsEnabled();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static ClassLoader getClassLoader(Class paramClass) {
/*  392 */     return LogFactory.getClassLoader(paramClass);
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
/*      */   private void initDiagnostics() {
/*      */     String str;
/*  419 */     Class clazz = getClass();
/*  420 */     ClassLoader classLoader = getClassLoader(clazz);
/*      */     
/*      */     try {
/*  423 */       if (classLoader == null) {
/*  424 */         str = "BOOTLOADER";
/*      */       } else {
/*  426 */         str = objectId(classLoader);
/*      */       } 
/*  428 */     } catch (SecurityException securityException) {
/*  429 */       str = "UNKNOWN";
/*      */     } 
/*  431 */     this.diagnosticPrefix = "[LogFactoryImpl@" + System.identityHashCode(this) + " from " + str + "] ";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void logDiagnostic(String paramString) {
/*  442 */     if (isDiagnosticsEnabled()) {
/*  443 */       logRawDiagnostic(this.diagnosticPrefix + paramString);
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
/*      */   protected String getLogClassName() {
/*  455 */     if (this.logClassName == null) {
/*  456 */       discoverLogImplementation(getClass().getName());
/*      */     }
/*      */     
/*  459 */     return this.logClassName;
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
/*      */   protected Constructor getLogConstructor() throws LogConfigurationException {
/*  482 */     if (this.logConstructor == null) {
/*  483 */       discoverLogImplementation(getClass().getName());
/*      */     }
/*      */     
/*  486 */     return this.logConstructor;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isJdk13LumberjackAvailable() {
/*  496 */     return isLogLibraryAvailable("Jdk13Lumberjack", "org.apache.commons.logging.impl.Jdk13LumberjackLogger");
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
/*      */   protected boolean isJdk14Available() {
/*  511 */     return isLogLibraryAvailable("Jdk14", "org.apache.commons.logging.impl.Jdk14Logger");
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
/*      */   protected boolean isLog4JAvailable() {
/*  523 */     return isLogLibraryAvailable("Log4J", "org.apache.commons.logging.impl.Log4JLogger");
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
/*      */   protected Log newInstance(String paramString) throws LogConfigurationException {
/*      */     try {
/*      */       Log log;
/*  540 */       if (this.logConstructor == null) {
/*  541 */         log = discoverLogImplementation(paramString);
/*      */       } else {
/*      */         
/*  544 */         Object[] arrayOfObject = { paramString };
/*  545 */         log = this.logConstructor.newInstance(arrayOfObject);
/*      */       } 
/*      */       
/*  548 */       if (this.logMethod != null) {
/*  549 */         Object[] arrayOfObject = { this };
/*  550 */         this.logMethod.invoke(log, arrayOfObject);
/*      */       } 
/*      */       
/*  553 */       return log;
/*      */     }
/*  555 */     catch (LogConfigurationException logConfigurationException) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  560 */       throw logConfigurationException;
/*      */     }
/*  562 */     catch (InvocationTargetException invocationTargetException) {
/*      */ 
/*      */       
/*  565 */       Throwable throwable = invocationTargetException.getTargetException();
/*  566 */       throw new LogConfigurationException((throwable == null) ? invocationTargetException : throwable);
/*  567 */     } catch (Throwable throwable) {
/*  568 */       handleThrowable(throwable);
/*      */ 
/*      */       
/*  571 */       throw new LogConfigurationException(throwable);
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
/*      */   private static ClassLoader getContextClassLoaderInternal() throws LogConfigurationException {
/*  597 */     return AccessController.<ClassLoader>doPrivileged(new PrivilegedAction()
/*      */         {
/*      */           public Object run() {
/*  600 */             return LogFactoryImpl.directGetContextClassLoader();
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
/*      */   private static String getSystemProperty(String paramString1, String paramString2) throws SecurityException {
/*  616 */     return AccessController.<String>doPrivileged(new PrivilegedAction(paramString1, paramString2) { private final String val$key;
/*      */           
/*      */           public Object run() {
/*  619 */             return System.getProperty(this.val$key, this.val$def);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final String val$def; }
/*      */       );
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private ClassLoader getParentClassLoader(ClassLoader paramClassLoader) {
/*      */     try {
/*  633 */       return AccessController.<ClassLoader>doPrivileged(new PrivilegedAction(this, paramClassLoader) { private final ClassLoader val$cl;
/*      */             
/*      */             public Object run() {
/*  636 */               return this.val$cl.getParent();
/*      */             } private final LogFactoryImpl this$0; }
/*      */         );
/*  639 */     } catch (SecurityException securityException) {
/*  640 */       logDiagnostic("[SECURITY] Unable to obtain parent classloader");
/*  641 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isLogLibraryAvailable(String paramString1, String paramString2) {
/*  652 */     if (isDiagnosticsEnabled()) {
/*  653 */       logDiagnostic("Checking for '" + paramString1 + "'.");
/*      */     }
/*      */     try {
/*  656 */       Log log = createLogFromClass(paramString2, getClass().getName(), false);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  661 */       if (log == null) {
/*  662 */         if (isDiagnosticsEnabled()) {
/*  663 */           logDiagnostic("Did not find '" + paramString1 + "'.");
/*      */         }
/*  665 */         return false;
/*      */       } 
/*  667 */       if (isDiagnosticsEnabled()) {
/*  668 */         logDiagnostic("Found '" + paramString1 + "'.");
/*      */       }
/*  670 */       return true;
/*      */     }
/*  672 */     catch (LogConfigurationException logConfigurationException) {
/*  673 */       if (isDiagnosticsEnabled()) {
/*  674 */         logDiagnostic("Logging system '" + paramString1 + "' is available but not useable.");
/*      */       }
/*  676 */       return false;
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
/*      */   private String getConfigurationValue(String paramString) {
/*  692 */     if (isDiagnosticsEnabled()) {
/*  693 */       logDiagnostic("[ENV] Trying to get configuration for item " + paramString);
/*      */     }
/*      */     
/*  696 */     Object object = getAttribute(paramString);
/*  697 */     if (object != null) {
/*  698 */       if (isDiagnosticsEnabled()) {
/*  699 */         logDiagnostic("[ENV] Found LogFactory attribute [" + object + "] for " + paramString);
/*      */       }
/*  701 */       return object.toString();
/*      */     } 
/*      */     
/*  704 */     if (isDiagnosticsEnabled()) {
/*  705 */       logDiagnostic("[ENV] No LogFactory attribute found for " + paramString);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  713 */       String str = getSystemProperty(paramString, (String)null);
/*  714 */       if (str != null) {
/*  715 */         if (isDiagnosticsEnabled()) {
/*  716 */           logDiagnostic("[ENV] Found system property [" + str + "] for " + paramString);
/*      */         }
/*  718 */         return str;
/*      */       } 
/*      */       
/*  721 */       if (isDiagnosticsEnabled()) {
/*  722 */         logDiagnostic("[ENV] No system property found for property " + paramString);
/*      */       }
/*  724 */     } catch (SecurityException securityException) {
/*  725 */       if (isDiagnosticsEnabled()) {
/*  726 */         logDiagnostic("[ENV] Security prevented reading system property " + paramString);
/*      */       }
/*      */     } 
/*      */     
/*  730 */     if (isDiagnosticsEnabled()) {
/*  731 */       logDiagnostic("[ENV] No configuration defined for item " + paramString);
/*      */     }
/*      */     
/*  734 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean getBooleanConfiguration(String paramString, boolean paramBoolean) {
/*  742 */     String str = getConfigurationValue(paramString);
/*  743 */     if (str == null) {
/*  744 */       return paramBoolean;
/*      */     }
/*  746 */     return Boolean.valueOf(str).booleanValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void initConfiguration() {
/*  757 */     this.allowFlawedContext = getBooleanConfiguration("org.apache.commons.logging.Log.allowFlawedContext", true);
/*  758 */     this.allowFlawedDiscovery = getBooleanConfiguration("org.apache.commons.logging.Log.allowFlawedDiscovery", true);
/*  759 */     this.allowFlawedHierarchy = getBooleanConfiguration("org.apache.commons.logging.Log.allowFlawedHierarchy", true);
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
/*      */   private Log discoverLogImplementation(String paramString) throws LogConfigurationException {
/*  773 */     if (isDiagnosticsEnabled()) {
/*  774 */       logDiagnostic("Discovering a Log implementation...");
/*      */     }
/*      */     
/*  777 */     initConfiguration();
/*      */     
/*  779 */     Log log = null;
/*      */ 
/*      */     
/*  782 */     String str = findUserSpecifiedLogClassName();
/*      */     
/*  784 */     if (str != null) {
/*  785 */       if (isDiagnosticsEnabled()) {
/*  786 */         logDiagnostic("Attempting to load user-specified log class '" + str + "'...");
/*      */       }
/*      */ 
/*      */       
/*  790 */       log = createLogFromClass(str, paramString, true);
/*      */ 
/*      */       
/*  793 */       if (log == null) {
/*  794 */         StringBuffer stringBuffer = new StringBuffer("User-specified log class '");
/*  795 */         stringBuffer.append(str);
/*  796 */         stringBuffer.append("' cannot be found or is not useable.");
/*      */ 
/*      */ 
/*      */         
/*  800 */         informUponSimilarName(stringBuffer, str, "org.apache.commons.logging.impl.Log4JLogger");
/*  801 */         informUponSimilarName(stringBuffer, str, "org.apache.commons.logging.impl.Jdk14Logger");
/*  802 */         informUponSimilarName(stringBuffer, str, "org.apache.commons.logging.impl.Jdk13LumberjackLogger");
/*  803 */         informUponSimilarName(stringBuffer, str, "org.apache.commons.logging.impl.SimpleLog");
/*  804 */         throw new LogConfigurationException(stringBuffer.toString());
/*      */       } 
/*      */       
/*  807 */       return log;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  838 */     if (isDiagnosticsEnabled()) {
/*  839 */       logDiagnostic("No user-specified Log implementation; performing discovery using the standard supported logging implementations...");
/*      */     }
/*      */ 
/*      */     
/*  843 */     for (byte b = 0; b < classesToDiscover.length && log == null; b++) {
/*  844 */       log = createLogFromClass(classesToDiscover[b], paramString, true);
/*      */     }
/*      */     
/*  847 */     if (log == null) {
/*  848 */       throw new LogConfigurationException("No suitable Log implementation");
/*      */     }
/*      */ 
/*      */     
/*  852 */     return log;
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
/*      */   private void informUponSimilarName(StringBuffer paramStringBuffer, String paramString1, String paramString2) {
/*  864 */     if (paramString1.equals(paramString2)) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  873 */     if (paramString1.regionMatches(true, 0, paramString2, 0, PKG_LEN + 5)) {
/*  874 */       paramStringBuffer.append(" Did you mean '");
/*  875 */       paramStringBuffer.append(paramString2);
/*  876 */       paramStringBuffer.append("'?");
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
/*      */   private String findUserSpecifiedLogClassName() {
/*  888 */     if (isDiagnosticsEnabled()) {
/*  889 */       logDiagnostic("Trying to get log class from attribute 'org.apache.commons.logging.Log'");
/*      */     }
/*  891 */     String str = (String)getAttribute("org.apache.commons.logging.Log");
/*      */     
/*  893 */     if (str == null) {
/*  894 */       if (isDiagnosticsEnabled()) {
/*  895 */         logDiagnostic("Trying to get log class from attribute 'org.apache.commons.logging.log'");
/*      */       }
/*      */       
/*  898 */       str = (String)getAttribute("org.apache.commons.logging.log");
/*      */     } 
/*      */     
/*  901 */     if (str == null) {
/*  902 */       if (isDiagnosticsEnabled()) {
/*  903 */         logDiagnostic("Trying to get log class from system property 'org.apache.commons.logging.Log'");
/*      */       }
/*      */       
/*      */       try {
/*  907 */         str = getSystemProperty("org.apache.commons.logging.Log", (String)null);
/*  908 */       } catch (SecurityException securityException) {
/*  909 */         if (isDiagnosticsEnabled()) {
/*  910 */           logDiagnostic("No access allowed to system property 'org.apache.commons.logging.Log' - " + securityException.getMessage());
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  916 */     if (str == null) {
/*  917 */       if (isDiagnosticsEnabled()) {
/*  918 */         logDiagnostic("Trying to get log class from system property 'org.apache.commons.logging.log'");
/*      */       }
/*      */       
/*      */       try {
/*  922 */         str = getSystemProperty("org.apache.commons.logging.log", (String)null);
/*  923 */       } catch (SecurityException securityException) {
/*  924 */         if (isDiagnosticsEnabled()) {
/*  925 */           logDiagnostic("No access allowed to system property 'org.apache.commons.logging.log' - " + securityException.getMessage());
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  934 */     if (str != null) {
/*  935 */       str = str.trim();
/*      */     }
/*      */     
/*  938 */     return str;
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
/*      */   private Log createLogFromClass(String paramString1, String paramString2, boolean paramBoolean) throws LogConfigurationException {
/*  960 */     if (isDiagnosticsEnabled()) {
/*  961 */       logDiagnostic("Attempting to instantiate '" + paramString1 + "'");
/*      */     }
/*      */     
/*  964 */     Object[] arrayOfObject = { paramString2 };
/*  965 */     Log log = null;
/*  966 */     Constructor constructor = null;
/*      */     
/*  968 */     Class clazz = null;
/*  969 */     ClassLoader classLoader = getBaseClassLoader();
/*      */ 
/*      */ 
/*      */     
/*      */     while (true) {
/*  974 */       logDiagnostic("Trying to load '" + paramString1 + "' from classloader " + objectId(classLoader)); try {
/*      */         Class clazz1;
/*  976 */         if (isDiagnosticsEnabled()) {
/*      */           URL uRL;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  982 */           String str = paramString1.replace('.', '/') + ".class";
/*  983 */           if (classLoader != null) {
/*  984 */             uRL = classLoader.getResource(str);
/*      */           } else {
/*  986 */             uRL = ClassLoader.getSystemResource(str + ".class");
/*      */           } 
/*      */           
/*  989 */           if (uRL == null) {
/*  990 */             logDiagnostic("Class '" + paramString1 + "' [" + str + "] cannot be found.");
/*      */           } else {
/*  992 */             logDiagnostic("Class '" + paramString1 + "' was found at '" + uRL + "'");
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*      */         try {
/*  998 */           clazz1 = Class.forName(paramString1, true, classLoader);
/*  999 */         } catch (ClassNotFoundException classNotFoundException) {
/*      */ 
/*      */ 
/*      */           
/* 1003 */           String str = classNotFoundException.getMessage();
/* 1004 */           logDiagnostic("The log adapter '" + paramString1 + "' is not available via classloader " + objectId(classLoader) + ": " + str.trim());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           try {
/* 1014 */             clazz1 = Class.forName(paramString1);
/* 1015 */           } catch (ClassNotFoundException classNotFoundException1) {
/*      */             
/* 1017 */             str = classNotFoundException1.getMessage();
/* 1018 */             logDiagnostic("The log adapter '" + paramString1 + "' is not available via the LogFactoryImpl class classloader: " + str.trim());
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */         
/* 1024 */         constructor = clazz1.getConstructor(this.logConstructorSignature);
/* 1025 */         Object object = constructor.newInstance(arrayOfObject);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1031 */         if (object instanceof Log) {
/* 1032 */           clazz = clazz1;
/* 1033 */           log = (Log)object;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           break;
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1047 */         handleFlawedHierarchy(classLoader, clazz1);
/* 1048 */       } catch (NoClassDefFoundError noClassDefFoundError) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1054 */         String str = noClassDefFoundError.getMessage();
/* 1055 */         logDiagnostic("The log adapter '" + paramString1 + "' is missing dependencies when loaded via classloader " + objectId(classLoader) + ": " + str.trim());
/*      */ 
/*      */         
/*      */         break;
/* 1059 */       } catch (ExceptionInInitializerError exceptionInInitializerError) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1066 */         String str = exceptionInInitializerError.getMessage();
/* 1067 */         logDiagnostic("The log adapter '" + paramString1 + "' is unable to initialize itself when loaded via classloader " + objectId(classLoader) + ": " + str.trim());
/*      */ 
/*      */         
/*      */         break;
/* 1071 */       } catch (LogConfigurationException logConfigurationException) {
/*      */ 
/*      */         
/* 1074 */         throw logConfigurationException;
/* 1075 */       } catch (Throwable throwable) {
/* 1076 */         handleThrowable(throwable);
/*      */ 
/*      */ 
/*      */         
/* 1080 */         handleFlawedDiscovery(paramString1, classLoader, throwable);
/*      */       } 
/*      */       
/* 1083 */       if (classLoader == null) {
/*      */         break;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1089 */       classLoader = getParentClassLoader(classLoader);
/*      */     } 
/*      */     
/* 1092 */     if (clazz != null && paramBoolean) {
/*      */       
/* 1094 */       this.logClassName = paramString1;
/* 1095 */       this.logConstructor = constructor;
/*      */ 
/*      */       
/*      */       try {
/* 1099 */         this.logMethod = clazz.getMethod("setLogFactory", this.logMethodSignature);
/* 1100 */         logDiagnostic("Found method setLogFactory(LogFactory) in '" + paramString1 + "'");
/* 1101 */       } catch (Throwable throwable) {
/* 1102 */         handleThrowable(throwable);
/* 1103 */         this.logMethod = null;
/* 1104 */         logDiagnostic("[INFO] '" + paramString1 + "' from classloader " + objectId(classLoader) + " does not declare optional method " + "setLogFactory(LogFactory)");
/*      */       } 
/*      */ 
/*      */       
/* 1108 */       logDiagnostic("Log adapter '" + paramString1 + "' from classloader " + objectId(clazz.getClassLoader()) + " has been selected for use.");
/*      */     } 
/*      */ 
/*      */     
/* 1112 */     return log;
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
/*      */   private ClassLoader getBaseClassLoader() throws LogConfigurationException {
/* 1134 */     ClassLoader classLoader1 = getClassLoader(LogFactoryImpl.class);
/*      */     
/* 1136 */     if (!this.useTCCL) {
/* 1137 */       return classLoader1;
/*      */     }
/*      */     
/* 1140 */     ClassLoader classLoader2 = getContextClassLoaderInternal();
/*      */     
/* 1142 */     ClassLoader classLoader3 = getLowestClassLoader(classLoader2, classLoader1);
/*      */ 
/*      */     
/* 1145 */     if (classLoader3 == null) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1150 */       if (this.allowFlawedContext) {
/* 1151 */         if (isDiagnosticsEnabled()) {
/* 1152 */           logDiagnostic("[WARNING] the context classloader is not part of a parent-child relationship with the classloader that loaded LogFactoryImpl.");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1159 */         return classLoader2;
/*      */       } 
/*      */       
/* 1162 */       throw new LogConfigurationException("Bad classloader hierarchy; LogFactoryImpl was loaded via a classloader that is not related to the current context classloader.");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1168 */     if (classLoader3 != classLoader2)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1174 */       if (this.allowFlawedContext) {
/* 1175 */         if (isDiagnosticsEnabled()) {
/* 1176 */           logDiagnostic("Warning: the context classloader is an ancestor of the classloader that loaded LogFactoryImpl; it should be the same or a descendant. The application using commons-logging should ensure the context classloader is used correctly.");
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/* 1184 */         throw new LogConfigurationException("Bad classloader hierarchy; LogFactoryImpl was loaded via a classloader that is not related to the current context classloader.");
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1191 */     return classLoader3;
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
/*      */   private ClassLoader getLowestClassLoader(ClassLoader paramClassLoader1, ClassLoader paramClassLoader2) {
/* 1207 */     if (paramClassLoader1 == null) {
/* 1208 */       return paramClassLoader2;
/*      */     }
/*      */     
/* 1211 */     if (paramClassLoader2 == null) {
/* 1212 */       return paramClassLoader1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1218 */     ClassLoader classLoader = paramClassLoader1;
/* 1219 */     while (classLoader != null) {
/* 1220 */       if (classLoader == paramClassLoader2) {
/* 1221 */         return paramClassLoader1;
/*      */       }
/*      */       
/* 1224 */       classLoader = getParentClassLoader(classLoader);
/*      */     } 
/*      */ 
/*      */     
/* 1228 */     classLoader = paramClassLoader2;
/* 1229 */     while (classLoader != null) {
/* 1230 */       if (classLoader == paramClassLoader1) {
/* 1231 */         return paramClassLoader2;
/*      */       }
/*      */       
/* 1234 */       classLoader = getParentClassLoader(classLoader);
/*      */     } 
/*      */     
/* 1237 */     return null;
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
/*      */   private void handleFlawedDiscovery(String paramString, ClassLoader paramClassLoader, Throwable paramThrowable) {
/* 1259 */     if (isDiagnosticsEnabled()) {
/* 1260 */       logDiagnostic("Could not instantiate Log '" + paramString + "' -- " + paramThrowable.getClass().getName() + ": " + paramThrowable.getLocalizedMessage());
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1265 */       if (paramThrowable instanceof InvocationTargetException) {
/*      */ 
/*      */ 
/*      */         
/* 1269 */         InvocationTargetException invocationTargetException = (InvocationTargetException)paramThrowable;
/* 1270 */         Throwable throwable = invocationTargetException.getTargetException();
/* 1271 */         if (throwable != null) {
/* 1272 */           logDiagnostic("... InvocationTargetException: " + throwable.getClass().getName() + ": " + throwable.getLocalizedMessage());
/*      */ 
/*      */ 
/*      */           
/* 1276 */           if (throwable instanceof ExceptionInInitializerError) {
/* 1277 */             ExceptionInInitializerError exceptionInInitializerError = (ExceptionInInitializerError)throwable;
/* 1278 */             Throwable throwable1 = exceptionInInitializerError.getException();
/* 1279 */             if (throwable1 != null) {
/* 1280 */               StringWriter stringWriter = new StringWriter();
/* 1281 */               throwable1.printStackTrace(new PrintWriter(stringWriter, true));
/* 1282 */               logDiagnostic("... ExceptionInInitializerError: " + stringWriter.toString());
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1289 */     if (!this.allowFlawedDiscovery) {
/* 1290 */       throw new LogConfigurationException(paramThrowable);
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
/*      */   private void handleFlawedHierarchy(ClassLoader paramClassLoader, Class paramClass) throws LogConfigurationException {
/* 1323 */     boolean bool = false;
/* 1324 */     String str = Log.class.getName();
/* 1325 */     Class[] arrayOfClass = paramClass.getInterfaces();
/* 1326 */     for (byte b = 0; b < arrayOfClass.length; b++) {
/* 1327 */       if (str.equals(arrayOfClass[b].getName())) {
/* 1328 */         bool = true;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 1333 */     if (bool) {
/*      */ 
/*      */       
/* 1336 */       if (isDiagnosticsEnabled()) {
/*      */         try {
/* 1338 */           ClassLoader classLoader = getClassLoader(Log.class);
/* 1339 */           logDiagnostic("Class '" + paramClass.getName() + "' was found in classloader " + objectId(paramClassLoader) + ". It is bound to a Log interface which is not" + " the one loaded from classloader " + objectId(classLoader));
/*      */         
/*      */         }
/* 1342 */         catch (Throwable throwable) {
/* 1343 */           handleThrowable(throwable);
/* 1344 */           logDiagnostic("Error while trying to output diagnostics about bad class '" + paramClass + "'");
/*      */         } 
/*      */       }
/*      */       
/* 1348 */       if (!this.allowFlawedHierarchy) {
/* 1349 */         StringBuffer stringBuffer = new StringBuffer();
/* 1350 */         stringBuffer.append("Terminating logging for this context ");
/* 1351 */         stringBuffer.append("due to bad log hierarchy. ");
/* 1352 */         stringBuffer.append("You have more than one version of '");
/* 1353 */         stringBuffer.append(Log.class.getName());
/* 1354 */         stringBuffer.append("' visible.");
/* 1355 */         if (isDiagnosticsEnabled()) {
/* 1356 */           logDiagnostic(stringBuffer.toString());
/*      */         }
/* 1358 */         throw new LogConfigurationException(stringBuffer.toString());
/*      */       } 
/*      */       
/* 1361 */       if (isDiagnosticsEnabled()) {
/* 1362 */         StringBuffer stringBuffer = new StringBuffer();
/* 1363 */         stringBuffer.append("Warning: bad log hierarchy. ");
/* 1364 */         stringBuffer.append("You have more than one version of '");
/* 1365 */         stringBuffer.append(Log.class.getName());
/* 1366 */         stringBuffer.append("' visible.");
/* 1367 */         logDiagnostic(stringBuffer.toString());
/*      */       } 
/*      */     } else {
/*      */       
/* 1371 */       if (!this.allowFlawedDiscovery) {
/* 1372 */         StringBuffer stringBuffer = new StringBuffer();
/* 1373 */         stringBuffer.append("Terminating logging for this context. ");
/* 1374 */         stringBuffer.append("Log class '");
/* 1375 */         stringBuffer.append(paramClass.getName());
/* 1376 */         stringBuffer.append("' does not implement the Log interface.");
/* 1377 */         if (isDiagnosticsEnabled()) {
/* 1378 */           logDiagnostic(stringBuffer.toString());
/*      */         }
/*      */         
/* 1381 */         throw new LogConfigurationException(stringBuffer.toString());
/*      */       } 
/*      */       
/* 1384 */       if (isDiagnosticsEnabled()) {
/* 1385 */         StringBuffer stringBuffer = new StringBuffer();
/* 1386 */         stringBuffer.append("[WARNING] Log class '");
/* 1387 */         stringBuffer.append(paramClass.getName());
/* 1388 */         stringBuffer.append("' does not implement the Log interface.");
/* 1389 */         logDiagnostic(stringBuffer.toString());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\impl\LogFactoryImpl.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */