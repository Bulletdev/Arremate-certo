/*     */ package ch.qos.logback.classic.jmx;
/*     */ 
/*     */ import ch.qos.logback.classic.Level;
/*     */ import ch.qos.logback.classic.Logger;
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.joran.JoranConfigurator;
/*     */ import ch.qos.logback.classic.spi.LoggerContextListener;
/*     */ import ch.qos.logback.classic.util.ContextInitializer;
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.spi.JoranException;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.StatusListener;
/*     */ import ch.qos.logback.core.status.StatusListenerAsList;
/*     */ import ch.qos.logback.core.status.StatusManager;
/*     */ import ch.qos.logback.core.util.StatusPrinter;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.management.InstanceNotFoundException;
/*     */ import javax.management.MBeanRegistrationException;
/*     */ import javax.management.MBeanServer;
/*     */ import javax.management.ObjectName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JMXConfigurator
/*     */   extends ContextAwareBase
/*     */   implements JMXConfiguratorMBean, LoggerContextListener
/*     */ {
/*  56 */   private static String EMPTY = "";
/*     */   
/*     */   LoggerContext loggerContext;
/*     */   
/*     */   MBeanServer mbs;
/*     */   
/*     */   ObjectName objectName;
/*     */   
/*     */   String objectNameAsString;
/*     */   
/*     */   boolean debug = true;
/*     */   boolean started;
/*     */   
/*     */   public JMXConfigurator(LoggerContext paramLoggerContext, MBeanServer paramMBeanServer, ObjectName paramObjectName) {
/*  70 */     this.started = true;
/*  71 */     this.context = (Context)paramLoggerContext;
/*  72 */     this.loggerContext = paramLoggerContext;
/*  73 */     this.mbs = paramMBeanServer;
/*  74 */     this.objectName = paramObjectName;
/*  75 */     this.objectNameAsString = paramObjectName.toString();
/*  76 */     if (previouslyRegisteredListenerWithSameObjectName()) {
/*  77 */       addError("Previously registered JMXConfigurator named [" + this.objectNameAsString + "] in the logger context named [" + paramLoggerContext.getName() + "]");
/*     */     } else {
/*     */       
/*  80 */       paramLoggerContext.addListener(this);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean previouslyRegisteredListenerWithSameObjectName() {
/*  85 */     List list = this.loggerContext.getCopyOfListenerList();
/*  86 */     for (LoggerContextListener loggerContextListener : list) {
/*  87 */       if (loggerContextListener instanceof JMXConfigurator) {
/*  88 */         JMXConfigurator jMXConfigurator = (JMXConfigurator)loggerContextListener;
/*  89 */         if (this.objectName.equals(jMXConfigurator.objectName)) {
/*  90 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public void reloadDefaultConfiguration() throws JoranException {
/*  98 */     ContextInitializer contextInitializer = new ContextInitializer(this.loggerContext);
/*  99 */     URL uRL = contextInitializer.findURLOfDefaultConfigurationFile(true);
/* 100 */     reloadByURL(uRL);
/*     */   }
/*     */   
/*     */   public void reloadByFileName(String paramString) throws JoranException, FileNotFoundException {
/* 104 */     File file = new File(paramString);
/* 105 */     if (file.exists() && file.isFile()) {
/*     */       
/*     */       try {
/* 108 */         URL uRL = file.toURI().toURL();
/* 109 */         reloadByURL(uRL);
/* 110 */       } catch (MalformedURLException malformedURLException) {
/* 111 */         throw new RuntimeException("Unexpected MalformedURLException occured. See nexted cause.", malformedURLException);
/*     */       } 
/*     */     } else {
/*     */       
/* 115 */       String str = "Could not find [" + paramString + "]";
/* 116 */       addInfo(str);
/* 117 */       throw new FileNotFoundException(str);
/*     */     } 
/*     */   }
/*     */   
/*     */   void addStatusListener(StatusListener paramStatusListener) {
/* 122 */     StatusManager statusManager = this.loggerContext.getStatusManager();
/* 123 */     statusManager.add(paramStatusListener);
/*     */   }
/*     */   
/*     */   void removeStatusListener(StatusListener paramStatusListener) {
/* 127 */     StatusManager statusManager = this.loggerContext.getStatusManager();
/* 128 */     statusManager.remove(paramStatusListener);
/*     */   }
/*     */   
/*     */   public void reloadByURL(URL paramURL) throws JoranException {
/* 132 */     StatusListenerAsList statusListenerAsList = new StatusListenerAsList();
/*     */     
/* 134 */     addStatusListener((StatusListener)statusListenerAsList);
/* 135 */     addInfo("Resetting context: " + this.loggerContext.getName());
/* 136 */     this.loggerContext.reset();
/*     */ 
/*     */     
/* 139 */     addStatusListener((StatusListener)statusListenerAsList);
/*     */     
/*     */     try {
/* 142 */       if (paramURL != null) {
/* 143 */         JoranConfigurator joranConfigurator = new JoranConfigurator();
/* 144 */         joranConfigurator.setContext((Context)this.loggerContext);
/* 145 */         joranConfigurator.doConfigure(paramURL);
/* 146 */         addInfo("Context: " + this.loggerContext.getName() + " reloaded.");
/*     */       } 
/*     */     } finally {
/* 149 */       removeStatusListener((StatusListener)statusListenerAsList);
/* 150 */       if (this.debug) {
/* 151 */         StatusPrinter.print(statusListenerAsList.getStatusList());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setLoggerLevel(String paramString1, String paramString2) {
/* 157 */     if (paramString1 == null) {
/*     */       return;
/*     */     }
/* 160 */     if (paramString2 == null) {
/*     */       return;
/*     */     }
/* 163 */     paramString1 = paramString1.trim();
/* 164 */     paramString2 = paramString2.trim();
/*     */     
/* 166 */     addInfo("Trying to set level " + paramString2 + " to logger " + paramString1);
/* 167 */     LoggerContext loggerContext = (LoggerContext)this.context;
/*     */     
/* 169 */     Logger logger = loggerContext.getLogger(paramString1);
/* 170 */     if ("null".equalsIgnoreCase(paramString2)) {
/* 171 */       logger.setLevel(null);
/*     */     } else {
/* 173 */       Level level = Level.toLevel(paramString2, null);
/* 174 */       if (level != null) {
/* 175 */         logger.setLevel(level);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getLoggerLevel(String paramString) {
/* 181 */     if (paramString == null) {
/* 182 */       return EMPTY;
/*     */     }
/*     */     
/* 185 */     paramString = paramString.trim();
/*     */     
/* 187 */     LoggerContext loggerContext = (LoggerContext)this.context;
/* 188 */     Logger logger = loggerContext.exists(paramString);
/* 189 */     if (logger != null && logger.getLevel() != null) {
/* 190 */       return logger.getLevel().toString();
/*     */     }
/* 192 */     return EMPTY;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLoggerEffectiveLevel(String paramString) {
/* 197 */     if (paramString == null) {
/* 198 */       return EMPTY;
/*     */     }
/*     */     
/* 201 */     paramString = paramString.trim();
/*     */     
/* 203 */     LoggerContext loggerContext = (LoggerContext)this.context;
/* 204 */     Logger logger = loggerContext.exists(paramString);
/* 205 */     if (logger != null) {
/* 206 */       return logger.getEffectiveLevel().toString();
/*     */     }
/* 208 */     return EMPTY;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getLoggerList() {
/* 213 */     LoggerContext loggerContext = (LoggerContext)this.context;
/* 214 */     ArrayList<String> arrayList = new ArrayList();
/* 215 */     Iterator<Logger> iterator = loggerContext.getLoggerList().iterator();
/* 216 */     while (iterator.hasNext()) {
/* 217 */       Logger logger = iterator.next();
/* 218 */       arrayList.add(logger.getName());
/*     */     } 
/* 220 */     return arrayList;
/*     */   }
/*     */   
/*     */   public List<String> getStatuses() {
/* 224 */     ArrayList<String> arrayList = new ArrayList();
/* 225 */     Iterator<Status> iterator = this.context.getStatusManager().getCopyOfStatusList().iterator();
/* 226 */     while (iterator.hasNext()) {
/* 227 */       arrayList.add(((Status)iterator.next()).toString());
/*     */     }
/* 229 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onStop(LoggerContext paramLoggerContext) {
/* 237 */     if (!this.started) {
/* 238 */       addInfo("onStop() method called on a stopped JMXActivator [" + this.objectNameAsString + "]");
/*     */       return;
/*     */     } 
/* 241 */     if (this.mbs.isRegistered(this.objectName)) {
/*     */       try {
/* 243 */         addInfo("Unregistering mbean [" + this.objectNameAsString + "]");
/* 244 */         this.mbs.unregisterMBean(this.objectName);
/* 245 */       } catch (InstanceNotFoundException instanceNotFoundException) {
/*     */         
/* 247 */         addError("Unable to find a verifiably registered mbean [" + this.objectNameAsString + "]", instanceNotFoundException);
/* 248 */       } catch (MBeanRegistrationException mBeanRegistrationException) {
/* 249 */         addError("Failed to unregister [" + this.objectNameAsString + "]", mBeanRegistrationException);
/*     */       } 
/*     */     } else {
/* 252 */       addInfo("mbean [" + this.objectNameAsString + "] was not in the mbean registry. This is OK.");
/*     */     } 
/* 254 */     stop();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onLevelChange(Logger paramLogger, Level paramLevel) {}
/*     */ 
/*     */   
/*     */   public void onReset(LoggerContext paramLoggerContext) {
/* 262 */     addInfo("onReset() method called JMXActivator [" + this.objectNameAsString + "]");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isResetResistant() {
/* 271 */     return true;
/*     */   }
/*     */   
/*     */   private void clearFields() {
/* 275 */     this.mbs = null;
/* 276 */     this.objectName = null;
/* 277 */     this.loggerContext = null;
/*     */   }
/*     */   
/*     */   private void stop() {
/* 281 */     this.started = false;
/* 282 */     clearFields();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onStart(LoggerContext paramLoggerContext) {}
/*     */ 
/*     */   
/*     */   public String toString() {
/* 291 */     return getClass().getName() + "(" + this.context.getName() + ")";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\jmx\JMXConfigurator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */