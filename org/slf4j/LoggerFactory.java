/*     */ package org.slf4j;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Enumeration;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import org.slf4j.event.LoggingEvent;
/*     */ import org.slf4j.event.SubstituteLoggingEvent;
/*     */ import org.slf4j.helpers.NOPLoggerFactory;
/*     */ import org.slf4j.helpers.SubstituteLogger;
/*     */ import org.slf4j.helpers.SubstituteLoggerFactory;
/*     */ import org.slf4j.helpers.Util;
/*     */ import org.slf4j.impl.StaticLoggerBinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class LoggerFactory
/*     */ {
/*     */   static final String CODES_PREFIX = "http://www.slf4j.org/codes.html";
/*     */   static final String NO_STATICLOGGERBINDER_URL = "http://www.slf4j.org/codes.html#StaticLoggerBinder";
/*     */   static final String MULTIPLE_BINDINGS_URL = "http://www.slf4j.org/codes.html#multiple_bindings";
/*     */   static final String NULL_LF_URL = "http://www.slf4j.org/codes.html#null_LF";
/*     */   static final String VERSION_MISMATCH = "http://www.slf4j.org/codes.html#version_mismatch";
/*     */   static final String SUBSTITUTE_LOGGER_URL = "http://www.slf4j.org/codes.html#substituteLogger";
/*     */   static final String LOGGER_NAME_MISMATCH_URL = "http://www.slf4j.org/codes.html#loggerNameMismatch";
/*     */   static final String REPLAY_URL = "http://www.slf4j.org/codes.html#replay";
/*     */   static final String UNSUCCESSFUL_INIT_URL = "http://www.slf4j.org/codes.html#unsuccessfulInit";
/*     */   static final String UNSUCCESSFUL_INIT_MSG = "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit";
/*     */   static final int UNINITIALIZED = 0;
/*     */   static final int ONGOING_INITIALIZATION = 1;
/*     */   static final int FAILED_INITIALIZATION = 2;
/*     */   static final int SUCCESSFUL_INITIALIZATION = 3;
/*     */   static final int NOP_FALLBACK_INITIALIZATION = 4;
/*  85 */   static volatile int INITIALIZATION_STATE = 0;
/*  86 */   static final SubstituteLoggerFactory SUBST_FACTORY = new SubstituteLoggerFactory();
/*  87 */   static final NOPLoggerFactory NOP_FALLBACK_FACTORY = new NOPLoggerFactory();
/*     */   
/*     */   static final String DETECT_LOGGER_NAME_MISMATCH_PROPERTY = "slf4j.detectLoggerNameMismatch";
/*     */   
/*     */   static final String JAVA_VENDOR_PROPERTY = "java.vendor.url";
/*     */   
/*  93 */   static boolean DETECT_LOGGER_NAME_MISMATCH = Util.safeGetBooleanSystemProperty("slf4j.detectLoggerNameMismatch");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   private static final String[] API_COMPATIBILITY_LIST = new String[] { "1.6", "1.7" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void reset() {
/* 120 */     INITIALIZATION_STATE = 0;
/*     */   }
/*     */   
/*     */   private static final void performInitialization() {
/* 124 */     bind();
/* 125 */     if (INITIALIZATION_STATE == 3) {
/* 126 */       versionSanityCheck();
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean messageContainsOrgSlf4jImplStaticLoggerBinder(String paramString) {
/* 131 */     if (paramString == null)
/* 132 */       return false; 
/* 133 */     if (paramString.contains("org/slf4j/impl/StaticLoggerBinder"))
/* 134 */       return true; 
/* 135 */     if (paramString.contains("org.slf4j.impl.StaticLoggerBinder"))
/* 136 */       return true; 
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   private static final void bind() {
/*     */     try {
/* 142 */       Set<URL> set = null;
/*     */ 
/*     */       
/* 145 */       if (!isAndroid()) {
/* 146 */         set = findPossibleStaticLoggerBinderPathSet();
/* 147 */         reportMultipleBindingAmbiguity(set);
/*     */       } 
/*     */       
/* 150 */       StaticLoggerBinder.getSingleton();
/* 151 */       INITIALIZATION_STATE = 3;
/* 152 */       reportActualBinding(set);
/* 153 */     } catch (NoClassDefFoundError noClassDefFoundError) {
/* 154 */       String str = noClassDefFoundError.getMessage();
/* 155 */       if (messageContainsOrgSlf4jImplStaticLoggerBinder(str)) {
/* 156 */         INITIALIZATION_STATE = 4;
/* 157 */         Util.report("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
/* 158 */         Util.report("Defaulting to no-operation (NOP) logger implementation");
/* 159 */         Util.report("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
/*     */       } else {
/* 161 */         failedBinding(noClassDefFoundError);
/* 162 */         throw noClassDefFoundError;
/*     */       } 
/* 164 */     } catch (NoSuchMethodError noSuchMethodError) {
/* 165 */       String str = noSuchMethodError.getMessage();
/* 166 */       if (str != null && str.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
/* 167 */         INITIALIZATION_STATE = 2;
/* 168 */         Util.report("slf4j-api 1.6.x (or later) is incompatible with this binding.");
/* 169 */         Util.report("Your binding is version 1.5.5 or earlier.");
/* 170 */         Util.report("Upgrade your binding to version 1.6.x.");
/*     */       } 
/* 172 */       throw noSuchMethodError;
/* 173 */     } catch (Exception exception) {
/* 174 */       failedBinding(exception);
/* 175 */       throw new IllegalStateException("Unexpected initialization failure", exception);
/*     */     } finally {
/* 177 */       postBindCleanUp();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void postBindCleanUp() {
/* 182 */     fixSubstituteLoggers();
/* 183 */     replayEvents();
/*     */     
/* 185 */     SUBST_FACTORY.clear();
/*     */   }
/*     */   
/*     */   private static void fixSubstituteLoggers() {
/* 189 */     synchronized (SUBST_FACTORY) {
/* 190 */       SUBST_FACTORY.postInitialization();
/* 191 */       for (SubstituteLogger substituteLogger : SUBST_FACTORY.getLoggers()) {
/* 192 */         Logger logger = getLogger(substituteLogger.getName());
/* 193 */         substituteLogger.setDelegate(logger);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void failedBinding(Throwable paramThrowable) {
/* 200 */     INITIALIZATION_STATE = 2;
/* 201 */     Util.report("Failed to instantiate SLF4J LoggerFactory", paramThrowable);
/*     */   }
/*     */   
/*     */   private static void replayEvents() {
/* 205 */     LinkedBlockingQueue linkedBlockingQueue = SUBST_FACTORY.getEventQueue();
/* 206 */     int i = linkedBlockingQueue.size();
/* 207 */     byte b = 0;
/* 208 */     char c = '';
/* 209 */     ArrayList arrayList = new ArrayList(128);
/*     */     while (true) {
/* 211 */       int j = linkedBlockingQueue.drainTo(arrayList, 128);
/* 212 */       if (j == 0)
/*     */         break; 
/* 214 */       for (SubstituteLoggingEvent substituteLoggingEvent : arrayList) {
/* 215 */         replaySingleEvent(substituteLoggingEvent);
/* 216 */         if (b++ == 0)
/* 217 */           emitReplayOrSubstituionWarning(substituteLoggingEvent, i); 
/*     */       } 
/* 219 */       arrayList.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void emitReplayOrSubstituionWarning(SubstituteLoggingEvent paramSubstituteLoggingEvent, int paramInt) {
/* 224 */     if (paramSubstituteLoggingEvent.getLogger().isDelegateEventAware()) {
/* 225 */       emitReplayWarning(paramInt);
/* 226 */     } else if (!paramSubstituteLoggingEvent.getLogger().isDelegateNOP()) {
/*     */ 
/*     */       
/* 229 */       emitSubstitutionWarning();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void replaySingleEvent(SubstituteLoggingEvent paramSubstituteLoggingEvent) {
/* 234 */     if (paramSubstituteLoggingEvent == null) {
/*     */       return;
/*     */     }
/* 237 */     SubstituteLogger substituteLogger = paramSubstituteLoggingEvent.getLogger();
/* 238 */     String str = substituteLogger.getName();
/* 239 */     if (substituteLogger.isDelegateNull()) {
/* 240 */       throw new IllegalStateException("Delegate logger cannot be null at this state.");
/*     */     }
/*     */     
/* 243 */     if (!substituteLogger.isDelegateNOP())
/*     */     {
/* 245 */       if (substituteLogger.isDelegateEventAware()) {
/* 246 */         substituteLogger.log((LoggingEvent)paramSubstituteLoggingEvent);
/*     */       } else {
/* 248 */         Util.report(str);
/*     */       }  } 
/*     */   }
/*     */   
/*     */   private static void emitSubstitutionWarning() {
/* 253 */     Util.report("The following set of substitute loggers may have been accessed");
/* 254 */     Util.report("during the initialization phase. Logging calls during this");
/* 255 */     Util.report("phase were not honored. However, subsequent logging calls to these");
/* 256 */     Util.report("loggers will work as normally expected.");
/* 257 */     Util.report("See also http://www.slf4j.org/codes.html#substituteLogger");
/*     */   }
/*     */   
/*     */   private static void emitReplayWarning(int paramInt) {
/* 261 */     Util.report("A number (" + paramInt + ") of logging calls during the initialization phase have been intercepted and are");
/* 262 */     Util.report("now being replayed. These are subject to the filtering rules of the underlying logging system.");
/* 263 */     Util.report("See also http://www.slf4j.org/codes.html#replay");
/*     */   }
/*     */   
/*     */   private static final void versionSanityCheck() {
/*     */     try {
/* 268 */       String str = StaticLoggerBinder.REQUESTED_API_VERSION;
/*     */       
/* 270 */       boolean bool = false;
/* 271 */       for (String str1 : API_COMPATIBILITY_LIST) {
/* 272 */         if (str.startsWith(str1)) {
/* 273 */           bool = true;
/*     */         }
/*     */       } 
/* 276 */       if (!bool) {
/* 277 */         Util.report("The requested version " + str + " by your slf4j binding is not compatible with " + 
/* 278 */             Arrays.<String>asList(API_COMPATIBILITY_LIST).toString());
/* 279 */         Util.report("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
/*     */       } 
/* 281 */     } catch (NoSuchFieldError noSuchFieldError) {
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 286 */     catch (Throwable throwable) {
/*     */       
/* 288 */       Util.report("Unexpected problem occured during version sanity check", throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 295 */   private static String STATIC_LOGGER_BINDER_PATH = "org/slf4j/impl/StaticLoggerBinder.class";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Set<URL> findPossibleStaticLoggerBinderPathSet() {
/* 301 */     LinkedHashSet<URL> linkedHashSet = new LinkedHashSet(); try {
/*     */       Enumeration<URL> enumeration;
/* 303 */       ClassLoader classLoader = LoggerFactory.class.getClassLoader();
/*     */       
/* 305 */       if (classLoader == null) {
/* 306 */         enumeration = ClassLoader.getSystemResources(STATIC_LOGGER_BINDER_PATH);
/*     */       } else {
/* 308 */         enumeration = classLoader.getResources(STATIC_LOGGER_BINDER_PATH);
/*     */       } 
/* 310 */       while (enumeration.hasMoreElements()) {
/* 311 */         URL uRL = enumeration.nextElement();
/* 312 */         linkedHashSet.add(uRL);
/*     */       } 
/* 314 */     } catch (IOException iOException) {
/* 315 */       Util.report("Error getting resources from path", iOException);
/*     */     } 
/* 317 */     return linkedHashSet;
/*     */   }
/*     */   
/*     */   private static boolean isAmbiguousStaticLoggerBinderPathSet(Set<URL> paramSet) {
/* 321 */     return (paramSet.size() > 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void reportMultipleBindingAmbiguity(Set<URL> paramSet) {
/* 330 */     if (isAmbiguousStaticLoggerBinderPathSet(paramSet)) {
/* 331 */       Util.report("Class path contains multiple SLF4J bindings.");
/* 332 */       for (URL uRL : paramSet) {
/* 333 */         Util.report("Found binding in [" + uRL + "]");
/*     */       }
/* 335 */       Util.report("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean isAndroid() {
/* 340 */     String str = Util.safeGetSystemProperty("java.vendor.url");
/* 341 */     if (str == null)
/* 342 */       return false; 
/* 343 */     return str.toLowerCase().contains("android");
/*     */   }
/*     */ 
/*     */   
/*     */   private static void reportActualBinding(Set<URL> paramSet) {
/* 348 */     if (paramSet != null && isAmbiguousStaticLoggerBinderPathSet(paramSet)) {
/* 349 */       Util.report("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
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
/*     */   public static Logger getLogger(String paramString) {
/* 362 */     ILoggerFactory iLoggerFactory = getILoggerFactory();
/* 363 */     return iLoggerFactory.getLogger(paramString);
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
/*     */   public static Logger getLogger(Class<?> paramClass) {
/* 388 */     Logger logger = getLogger(paramClass.getName());
/* 389 */     if (DETECT_LOGGER_NAME_MISMATCH) {
/* 390 */       Class<?> clazz = Util.getCallingClass();
/* 391 */       if (clazz != null && nonMatchingClasses(paramClass, clazz)) {
/* 392 */         Util.report(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[] { logger.getName(), clazz
/* 393 */                 .getName() }));
/* 394 */         Util.report("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
/*     */       } 
/*     */     } 
/* 397 */     return logger;
/*     */   }
/*     */   
/*     */   private static boolean nonMatchingClasses(Class<?> paramClass1, Class<?> paramClass2) {
/* 401 */     return !paramClass2.isAssignableFrom(paramClass1);
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
/*     */   public static ILoggerFactory getILoggerFactory() {
/* 413 */     if (INITIALIZATION_STATE == 0) {
/* 414 */       synchronized (LoggerFactory.class) {
/* 415 */         if (INITIALIZATION_STATE == 0) {
/* 416 */           INITIALIZATION_STATE = 1;
/* 417 */           performInitialization();
/*     */         } 
/*     */       } 
/*     */     }
/* 421 */     switch (INITIALIZATION_STATE) {
/*     */       case 3:
/* 423 */         return StaticLoggerBinder.getSingleton().getLoggerFactory();
/*     */       case 4:
/* 425 */         return (ILoggerFactory)NOP_FALLBACK_FACTORY;
/*     */       case 2:
/* 427 */         throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
/*     */ 
/*     */       
/*     */       case 1:
/* 431 */         return (ILoggerFactory)SUBST_FACTORY;
/*     */     } 
/* 433 */     throw new IllegalStateException("Unreachable code");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\LoggerFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */