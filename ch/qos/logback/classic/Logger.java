/*     */ package ch.qos.logback.classic;
/*     */ 
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import ch.qos.logback.classic.spi.LoggingEvent;
/*     */ import ch.qos.logback.classic.util.LoggerNameUtil;
/*     */ import ch.qos.logback.core.Appender;
/*     */ import ch.qos.logback.core.spi.AppenderAttachable;
/*     */ import ch.qos.logback.core.spi.AppenderAttachableImpl;
/*     */ import ch.qos.logback.core.spi.FilterReply;
/*     */ import java.io.ObjectStreamException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.slf4j.Marker;
/*     */ import org.slf4j.event.LoggingEvent;
/*     */ import org.slf4j.spi.LocationAwareLogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Logger
/*     */   implements AppenderAttachable<ILoggingEvent>, Serializable, Logger, LocationAwareLogger
/*     */ {
/*     */   private static final long serialVersionUID = 5454405123156820674L;
/*  44 */   public static final String FQCN = Logger.class.getName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient Level level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient int effectiveLevelInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient Logger parent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient List<Logger> childrenList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient AppenderAttachableImpl<ILoggingEvent> aai;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient boolean additive = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final transient LoggerContext loggerContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Logger(String paramString, Logger paramLogger, LoggerContext paramLoggerContext) {
/* 103 */     this.name = paramString;
/* 104 */     this.parent = paramLogger;
/* 105 */     this.loggerContext = paramLoggerContext;
/*     */   }
/*     */   
/*     */   public Level getEffectiveLevel() {
/* 109 */     return Level.toLevel(this.effectiveLevelInt);
/*     */   }
/*     */   
/*     */   int getEffectiveLevelInt() {
/* 113 */     return this.effectiveLevelInt;
/*     */   }
/*     */   
/*     */   public Level getLevel() {
/* 117 */     return this.level;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 121 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isRootLogger() {
/* 126 */     return (this.parent == null);
/*     */   }
/*     */   
/*     */   Logger getChildByName(String paramString) {
/* 130 */     if (this.childrenList == null) {
/* 131 */       return null;
/*     */     }
/* 133 */     int i = this.childrenList.size();
/* 134 */     for (byte b = 0; b < i; b++) {
/* 135 */       Logger logger = this.childrenList.get(b);
/* 136 */       String str = logger.getName();
/*     */       
/* 138 */       if (paramString.equals(str)) {
/* 139 */         return logger;
/*     */       }
/*     */     } 
/*     */     
/* 143 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void setLevel(Level paramLevel) {
/* 148 */     if (this.level == paramLevel) {
/*     */       return;
/*     */     }
/*     */     
/* 152 */     if (paramLevel == null && isRootLogger()) {
/* 153 */       throw new IllegalArgumentException("The level of the root logger cannot be set to null");
/*     */     }
/*     */     
/* 156 */     this.level = paramLevel;
/* 157 */     if (paramLevel == null) {
/* 158 */       this.effectiveLevelInt = this.parent.effectiveLevelInt;
/* 159 */       paramLevel = this.parent.getEffectiveLevel();
/*     */     } else {
/* 161 */       this.effectiveLevelInt = paramLevel.levelInt;
/*     */     } 
/*     */     
/* 164 */     if (this.childrenList != null) {
/* 165 */       int i = this.childrenList.size();
/* 166 */       for (byte b = 0; b < i; b++) {
/* 167 */         Logger logger = this.childrenList.get(b);
/*     */         
/* 169 */         logger.handleParentLevelChange(this.effectiveLevelInt);
/*     */       } 
/*     */     } 
/*     */     
/* 173 */     this.loggerContext.fireOnLevelChange(this, paramLevel);
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
/*     */   private synchronized void handleParentLevelChange(int paramInt) {
/* 185 */     if (this.level == null) {
/* 186 */       this.effectiveLevelInt = paramInt;
/*     */ 
/*     */       
/* 189 */       if (this.childrenList != null) {
/* 190 */         int i = this.childrenList.size();
/* 191 */         for (byte b = 0; b < i; b++) {
/* 192 */           Logger logger = this.childrenList.get(b);
/* 193 */           logger.handleParentLevelChange(paramInt);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void detachAndStopAllAppenders() {
/* 205 */     if (this.aai != null) {
/* 206 */       this.aai.detachAndStopAllAppenders();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean detachAppender(String paramString) {
/* 211 */     if (this.aai == null) {
/* 212 */       return false;
/*     */     }
/* 214 */     return this.aai.detachAppender(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void addAppender(Appender<ILoggingEvent> paramAppender) {
/* 220 */     if (this.aai == null) {
/* 221 */       this.aai = new AppenderAttachableImpl();
/*     */     }
/* 223 */     this.aai.addAppender(paramAppender);
/*     */   }
/*     */   
/*     */   public boolean isAttached(Appender<ILoggingEvent> paramAppender) {
/* 227 */     if (this.aai == null) {
/* 228 */       return false;
/*     */     }
/* 230 */     return this.aai.isAttached(paramAppender);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<Appender<ILoggingEvent>> iteratorForAppenders() {
/* 235 */     if (this.aai == null) {
/* 236 */       return Collections.EMPTY_LIST.iterator();
/*     */     }
/* 238 */     return this.aai.iteratorForAppenders();
/*     */   }
/*     */   
/*     */   public Appender<ILoggingEvent> getAppender(String paramString) {
/* 242 */     if (this.aai == null) {
/* 243 */       return null;
/*     */     }
/* 245 */     return this.aai.getAppender(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void callAppenders(ILoggingEvent paramILoggingEvent) {
/* 255 */     int i = 0;
/* 256 */     for (Logger logger = this; logger != null; logger = logger.parent) {
/* 257 */       i += logger.appendLoopOnAppenders(paramILoggingEvent);
/* 258 */       if (!logger.additive) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 263 */     if (i == 0) {
/* 264 */       this.loggerContext.noAppenderDefinedWarning(this);
/*     */     }
/*     */   }
/*     */   
/*     */   private int appendLoopOnAppenders(ILoggingEvent paramILoggingEvent) {
/* 269 */     if (this.aai != null) {
/* 270 */       return this.aai.appendLoopOnAppenders(paramILoggingEvent);
/*     */     }
/* 272 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean detachAppender(Appender<ILoggingEvent> paramAppender) {
/* 280 */     if (this.aai == null) {
/* 281 */       return false;
/*     */     }
/* 283 */     return this.aai.detachAppender(paramAppender);
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
/*     */   Logger createChildByLastNamePart(String paramString) {
/*     */     Logger logger;
/* 302 */     int i = LoggerNameUtil.getFirstSeparatorIndexOf(paramString);
/* 303 */     if (i != -1) {
/* 304 */       throw new IllegalArgumentException("Child name [" + paramString + " passed as parameter, may not include [" + '.' + "]");
/*     */     }
/*     */     
/* 307 */     if (this.childrenList == null) {
/* 308 */       this.childrenList = new CopyOnWriteArrayList<Logger>();
/*     */     }
/*     */     
/* 311 */     if (isRootLogger()) {
/* 312 */       logger = new Logger(paramString, this, this.loggerContext);
/*     */     } else {
/* 314 */       logger = new Logger(this.name + '.' + paramString, this, this.loggerContext);
/*     */     } 
/* 316 */     this.childrenList.add(logger);
/* 317 */     logger.effectiveLevelInt = this.effectiveLevelInt;
/* 318 */     return logger;
/*     */   }
/*     */   
/*     */   private void localLevelReset() {
/* 322 */     this.effectiveLevelInt = 10000;
/* 323 */     if (isRootLogger()) {
/* 324 */       this.level = Level.DEBUG;
/*     */     } else {
/* 326 */       this.level = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   void recursiveReset() {
/* 331 */     detachAndStopAllAppenders();
/* 332 */     localLevelReset();
/* 333 */     this.additive = true;
/* 334 */     if (this.childrenList == null) {
/*     */       return;
/*     */     }
/* 337 */     for (Logger logger : this.childrenList) {
/* 338 */       logger.recursiveReset();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Logger createChildByName(String paramString) {
/* 348 */     int i = LoggerNameUtil.getSeparatorIndexOf(paramString, this.name.length() + 1);
/* 349 */     if (i != -1) {
/* 350 */       throw new IllegalArgumentException("For logger [" + this.name + "] child name [" + paramString + " passed as parameter, may not include '.' after index" + (this.name
/* 351 */           .length() + 1));
/*     */     }
/*     */     
/* 354 */     if (this.childrenList == null) {
/* 355 */       this.childrenList = new CopyOnWriteArrayList<Logger>();
/*     */     }
/*     */     
/* 358 */     Logger logger = new Logger(paramString, this, this.loggerContext);
/* 359 */     this.childrenList.add(logger);
/* 360 */     logger.effectiveLevelInt = this.effectiveLevelInt;
/* 361 */     return logger;
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
/*     */   private void filterAndLog_0_Or3Plus(String paramString1, Marker paramMarker, Level paramLevel, String paramString2, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 373 */     FilterReply filterReply = this.loggerContext.getTurboFilterChainDecision_0_3OrMore(paramMarker, this, paramLevel, paramString2, paramArrayOfObject, paramThrowable);
/*     */     
/* 375 */     if (filterReply == FilterReply.NEUTRAL) {
/* 376 */       if (this.effectiveLevelInt > paramLevel.levelInt) {
/*     */         return;
/*     */       }
/* 379 */     } else if (filterReply == FilterReply.DENY) {
/*     */       return;
/*     */     } 
/*     */     
/* 383 */     buildLoggingEventAndAppend(paramString1, paramMarker, paramLevel, paramString2, paramArrayOfObject, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   private void filterAndLog_1(String paramString1, Marker paramMarker, Level paramLevel, String paramString2, Object paramObject, Throwable paramThrowable) {
/* 388 */     FilterReply filterReply = this.loggerContext.getTurboFilterChainDecision_1(paramMarker, this, paramLevel, paramString2, paramObject, paramThrowable);
/*     */     
/* 390 */     if (filterReply == FilterReply.NEUTRAL) {
/* 391 */       if (this.effectiveLevelInt > paramLevel.levelInt) {
/*     */         return;
/*     */       }
/* 394 */     } else if (filterReply == FilterReply.DENY) {
/*     */       return;
/*     */     } 
/*     */     
/* 398 */     buildLoggingEventAndAppend(paramString1, paramMarker, paramLevel, paramString2, new Object[] { paramObject }, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void filterAndLog_2(String paramString1, Marker paramMarker, Level paramLevel, String paramString2, Object paramObject1, Object paramObject2, Throwable paramThrowable) {
/* 404 */     FilterReply filterReply = this.loggerContext.getTurboFilterChainDecision_2(paramMarker, this, paramLevel, paramString2, paramObject1, paramObject2, paramThrowable);
/*     */     
/* 406 */     if (filterReply == FilterReply.NEUTRAL) {
/* 407 */       if (this.effectiveLevelInt > paramLevel.levelInt) {
/*     */         return;
/*     */       }
/* 410 */     } else if (filterReply == FilterReply.DENY) {
/*     */       return;
/*     */     } 
/*     */     
/* 414 */     buildLoggingEventAndAppend(paramString1, paramMarker, paramLevel, paramString2, new Object[] { paramObject1, paramObject2 }, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   private void buildLoggingEventAndAppend(String paramString1, Marker paramMarker, Level paramLevel, String paramString2, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 419 */     LoggingEvent loggingEvent = new LoggingEvent(paramString1, this, paramLevel, paramString2, paramThrowable, paramArrayOfObject);
/* 420 */     loggingEvent.setMarker(paramMarker);
/* 421 */     callAppenders((ILoggingEvent)loggingEvent);
/*     */   }
/*     */   
/*     */   public void trace(String paramString) {
/* 425 */     filterAndLog_0_Or3Plus(FQCN, null, Level.TRACE, paramString, null, null);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Object paramObject) {
/* 429 */     filterAndLog_1(FQCN, null, Level.TRACE, paramString, paramObject, null);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Object paramObject1, Object paramObject2) {
/* 433 */     filterAndLog_2(FQCN, null, Level.TRACE, paramString, paramObject1, paramObject2, null);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Object... paramVarArgs) {
/* 437 */     filterAndLog_0_Or3Plus(FQCN, null, Level.TRACE, paramString, paramVarArgs, null);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Throwable paramThrowable) {
/* 441 */     filterAndLog_0_Or3Plus(FQCN, null, Level.TRACE, paramString, null, paramThrowable);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString) {
/* 445 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.TRACE, paramString, null, null);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject) {
/* 449 */     filterAndLog_1(FQCN, paramMarker, Level.TRACE, paramString, paramObject, null);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 453 */     filterAndLog_2(FQCN, paramMarker, Level.TRACE, paramString, paramObject1, paramObject2, null);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 457 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.TRACE, paramString, paramVarArgs, null);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 461 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.TRACE, paramString, null, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isDebugEnabled() {
/* 465 */     return isDebugEnabled(null);
/*     */   }
/*     */   
/*     */   public boolean isDebugEnabled(Marker paramMarker) {
/* 469 */     FilterReply filterReply = callTurboFilters(paramMarker, Level.DEBUG);
/* 470 */     if (filterReply == FilterReply.NEUTRAL)
/* 471 */       return (this.effectiveLevelInt <= 10000); 
/* 472 */     if (filterReply == FilterReply.DENY)
/* 473 */       return false; 
/* 474 */     if (filterReply == FilterReply.ACCEPT) {
/* 475 */       return true;
/*     */     }
/* 477 */     throw new IllegalStateException("Unknown FilterReply value: " + filterReply);
/*     */   }
/*     */ 
/*     */   
/*     */   public void debug(String paramString) {
/* 482 */     filterAndLog_0_Or3Plus(FQCN, null, Level.DEBUG, paramString, null, null);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object paramObject) {
/* 486 */     filterAndLog_1(FQCN, null, Level.DEBUG, paramString, paramObject, null);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object paramObject1, Object paramObject2) {
/* 490 */     filterAndLog_2(FQCN, null, Level.DEBUG, paramString, paramObject1, paramObject2, null);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object... paramVarArgs) {
/* 494 */     filterAndLog_0_Or3Plus(FQCN, null, Level.DEBUG, paramString, paramVarArgs, null);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Throwable paramThrowable) {
/* 498 */     filterAndLog_0_Or3Plus(FQCN, null, Level.DEBUG, paramString, null, paramThrowable);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString) {
/* 502 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.DEBUG, paramString, null, null);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject) {
/* 506 */     filterAndLog_1(FQCN, paramMarker, Level.DEBUG, paramString, paramObject, null);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 510 */     filterAndLog_2(FQCN, paramMarker, Level.DEBUG, paramString, paramObject1, paramObject2, null);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 514 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.DEBUG, paramString, paramVarArgs, null);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 518 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.DEBUG, paramString, null, paramThrowable);
/*     */   }
/*     */   
/*     */   public void error(String paramString) {
/* 522 */     filterAndLog_0_Or3Plus(FQCN, null, Level.ERROR, paramString, null, null);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object paramObject) {
/* 526 */     filterAndLog_1(FQCN, null, Level.ERROR, paramString, paramObject, null);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object paramObject1, Object paramObject2) {
/* 530 */     filterAndLog_2(FQCN, null, Level.ERROR, paramString, paramObject1, paramObject2, null);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object... paramVarArgs) {
/* 534 */     filterAndLog_0_Or3Plus(FQCN, null, Level.ERROR, paramString, paramVarArgs, null);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Throwable paramThrowable) {
/* 538 */     filterAndLog_0_Or3Plus(FQCN, null, Level.ERROR, paramString, null, paramThrowable);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString) {
/* 542 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.ERROR, paramString, null, null);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject) {
/* 546 */     filterAndLog_1(FQCN, paramMarker, Level.ERROR, paramString, paramObject, null);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 550 */     filterAndLog_2(FQCN, paramMarker, Level.ERROR, paramString, paramObject1, paramObject2, null);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 554 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.ERROR, paramString, paramVarArgs, null);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 558 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.ERROR, paramString, null, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isInfoEnabled() {
/* 562 */     return isInfoEnabled(null);
/*     */   }
/*     */   
/*     */   public boolean isInfoEnabled(Marker paramMarker) {
/* 566 */     FilterReply filterReply = callTurboFilters(paramMarker, Level.INFO);
/* 567 */     if (filterReply == FilterReply.NEUTRAL)
/* 568 */       return (this.effectiveLevelInt <= 20000); 
/* 569 */     if (filterReply == FilterReply.DENY)
/* 570 */       return false; 
/* 571 */     if (filterReply == FilterReply.ACCEPT) {
/* 572 */       return true;
/*     */     }
/* 574 */     throw new IllegalStateException("Unknown FilterReply value: " + filterReply);
/*     */   }
/*     */ 
/*     */   
/*     */   public void info(String paramString) {
/* 579 */     filterAndLog_0_Or3Plus(FQCN, null, Level.INFO, paramString, null, null);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object paramObject) {
/* 583 */     filterAndLog_1(FQCN, null, Level.INFO, paramString, paramObject, null);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object paramObject1, Object paramObject2) {
/* 587 */     filterAndLog_2(FQCN, null, Level.INFO, paramString, paramObject1, paramObject2, null);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object... paramVarArgs) {
/* 591 */     filterAndLog_0_Or3Plus(FQCN, null, Level.INFO, paramString, paramVarArgs, null);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Throwable paramThrowable) {
/* 595 */     filterAndLog_0_Or3Plus(FQCN, null, Level.INFO, paramString, null, paramThrowable);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString) {
/* 599 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.INFO, paramString, null, null);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject) {
/* 603 */     filterAndLog_1(FQCN, paramMarker, Level.INFO, paramString, paramObject, null);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 607 */     filterAndLog_2(FQCN, paramMarker, Level.INFO, paramString, paramObject1, paramObject2, null);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 611 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.INFO, paramString, paramVarArgs, null);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 615 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.INFO, paramString, null, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isTraceEnabled() {
/* 619 */     return isTraceEnabled(null);
/*     */   }
/*     */   
/*     */   public boolean isTraceEnabled(Marker paramMarker) {
/* 623 */     FilterReply filterReply = callTurboFilters(paramMarker, Level.TRACE);
/* 624 */     if (filterReply == FilterReply.NEUTRAL)
/* 625 */       return (this.effectiveLevelInt <= 5000); 
/* 626 */     if (filterReply == FilterReply.DENY)
/* 627 */       return false; 
/* 628 */     if (filterReply == FilterReply.ACCEPT) {
/* 629 */       return true;
/*     */     }
/* 631 */     throw new IllegalStateException("Unknown FilterReply value: " + filterReply);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isErrorEnabled() {
/* 636 */     return isErrorEnabled(null);
/*     */   }
/*     */   
/*     */   public boolean isErrorEnabled(Marker paramMarker) {
/* 640 */     FilterReply filterReply = callTurboFilters(paramMarker, Level.ERROR);
/* 641 */     if (filterReply == FilterReply.NEUTRAL)
/* 642 */       return (this.effectiveLevelInt <= 40000); 
/* 643 */     if (filterReply == FilterReply.DENY)
/* 644 */       return false; 
/* 645 */     if (filterReply == FilterReply.ACCEPT) {
/* 646 */       return true;
/*     */     }
/* 648 */     throw new IllegalStateException("Unknown FilterReply value: " + filterReply);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWarnEnabled() {
/* 653 */     return isWarnEnabled(null);
/*     */   }
/*     */   
/*     */   public boolean isWarnEnabled(Marker paramMarker) {
/* 657 */     FilterReply filterReply = callTurboFilters(paramMarker, Level.WARN);
/* 658 */     if (filterReply == FilterReply.NEUTRAL)
/* 659 */       return (this.effectiveLevelInt <= 30000); 
/* 660 */     if (filterReply == FilterReply.DENY)
/* 661 */       return false; 
/* 662 */     if (filterReply == FilterReply.ACCEPT) {
/* 663 */       return true;
/*     */     }
/* 665 */     throw new IllegalStateException("Unknown FilterReply value: " + filterReply);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabledFor(Marker paramMarker, Level paramLevel) {
/* 671 */     FilterReply filterReply = callTurboFilters(paramMarker, paramLevel);
/* 672 */     if (filterReply == FilterReply.NEUTRAL)
/* 673 */       return (this.effectiveLevelInt <= paramLevel.levelInt); 
/* 674 */     if (filterReply == FilterReply.DENY)
/* 675 */       return false; 
/* 676 */     if (filterReply == FilterReply.ACCEPT) {
/* 677 */       return true;
/*     */     }
/* 679 */     throw new IllegalStateException("Unknown FilterReply value: " + filterReply);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEnabledFor(Level paramLevel) {
/* 684 */     return isEnabledFor(null, paramLevel);
/*     */   }
/*     */   
/*     */   public void warn(String paramString) {
/* 688 */     filterAndLog_0_Or3Plus(FQCN, null, Level.WARN, paramString, null, null);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Throwable paramThrowable) {
/* 692 */     filterAndLog_0_Or3Plus(FQCN, null, Level.WARN, paramString, null, paramThrowable);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object paramObject) {
/* 696 */     filterAndLog_1(FQCN, null, Level.WARN, paramString, paramObject, null);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object paramObject1, Object paramObject2) {
/* 700 */     filterAndLog_2(FQCN, null, Level.WARN, paramString, paramObject1, paramObject2, null);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object... paramVarArgs) {
/* 704 */     filterAndLog_0_Or3Plus(FQCN, null, Level.WARN, paramString, paramVarArgs, null);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString) {
/* 708 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.WARN, paramString, null, null);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject) {
/* 712 */     filterAndLog_1(FQCN, paramMarker, Level.WARN, paramString, paramObject, null);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 716 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.WARN, paramString, paramVarArgs, null);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 720 */     filterAndLog_2(FQCN, paramMarker, Level.WARN, paramString, paramObject1, paramObject2, null);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 724 */     filterAndLog_0_Or3Plus(FQCN, paramMarker, Level.WARN, paramString, null, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isAdditive() {
/* 728 */     return this.additive;
/*     */   }
/*     */   
/*     */   public void setAdditive(boolean paramBoolean) {
/* 732 */     this.additive = paramBoolean;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 736 */     return "Logger[" + this.name + "]";
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
/*     */   private FilterReply callTurboFilters(Marker paramMarker, Level paramLevel) {
/* 751 */     return this.loggerContext.getTurboFilterChainDecision_0_3OrMore(paramMarker, this, paramLevel, null, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LoggerContext getLoggerContext() {
/* 760 */     return this.loggerContext;
/*     */   }
/*     */   
/*     */   public void log(Marker paramMarker, String paramString1, int paramInt, String paramString2, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 764 */     Level level = Level.fromLocationAwareLoggerInteger(paramInt);
/* 765 */     filterAndLog_0_Or3Plus(paramString1, paramMarker, level, paramString2, paramArrayOfObject, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void log(LoggingEvent paramLoggingEvent) {
/* 774 */     Level level = Level.fromLocationAwareLoggerInteger(paramLoggingEvent.getLevel().toInt());
/* 775 */     filterAndLog_0_Or3Plus(FQCN, paramLoggingEvent.getMarker(), level, paramLoggingEvent.getMessage(), paramLoggingEvent.getArgumentArray(), paramLoggingEvent.getThrowable());
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
/*     */   protected Object readResolve() throws ObjectStreamException {
/* 787 */     return LoggerFactory.getLogger(getName());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */