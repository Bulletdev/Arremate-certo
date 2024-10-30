/*     */ package ch.qos.logback.classic.selector;
/*     */ 
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.joran.JoranConfigurator;
/*     */ import ch.qos.logback.classic.util.ContextInitializer;
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.spi.JoranException;
/*     */ import ch.qos.logback.core.status.InfoStatus;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.StatusManager;
/*     */ import ch.qos.logback.core.status.StatusUtil;
/*     */ import ch.qos.logback.core.status.WarnStatus;
/*     */ import ch.qos.logback.core.util.JNDIUtil;
/*     */ import ch.qos.logback.core.util.Loader;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import ch.qos.logback.core.util.StatusPrinter;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.naming.Context;
/*     */ import javax.naming.NamingException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContextJNDISelector
/*     */   implements ContextSelector
/*     */ {
/*     */   private final Map<String, LoggerContext> synchronizedContextMap;
/*     */   private final LoggerContext defaultContext;
/*  58 */   private static final ThreadLocal<LoggerContext> threadLocal = new ThreadLocal<LoggerContext>();
/*     */   
/*     */   public ContextJNDISelector(LoggerContext paramLoggerContext) {
/*  61 */     this.synchronizedContextMap = Collections.synchronizedMap(new HashMap<String, LoggerContext>());
/*  62 */     this.defaultContext = paramLoggerContext;
/*     */   }
/*     */   
/*     */   public LoggerContext getDefaultLoggerContext() {
/*  66 */     return this.defaultContext;
/*     */   }
/*     */   
/*     */   public LoggerContext detachLoggerContext(String paramString) {
/*  70 */     return this.synchronizedContextMap.remove(paramString);
/*     */   }
/*     */   
/*     */   public LoggerContext getLoggerContext() {
/*  74 */     String str = null;
/*  75 */     Context context = null;
/*     */ 
/*     */     
/*  78 */     LoggerContext loggerContext1 = threadLocal.get();
/*  79 */     if (loggerContext1 != null) {
/*  80 */       return loggerContext1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  86 */       context = JNDIUtil.getInitialContext();
/*  87 */       str = JNDIUtil.lookupString(context, "java:comp/env/logback/context-name");
/*  88 */     } catch (NamingException namingException) {}
/*     */ 
/*     */ 
/*     */     
/*  92 */     if (OptionHelper.isEmpty(str))
/*     */     {
/*  94 */       return this.defaultContext;
/*     */     }
/*     */     
/*  97 */     LoggerContext loggerContext2 = this.synchronizedContextMap.get(str);
/*     */     
/*  99 */     if (loggerContext2 == null) {
/*     */       
/* 101 */       loggerContext2 = new LoggerContext();
/* 102 */       loggerContext2.setName(str);
/* 103 */       this.synchronizedContextMap.put(str, loggerContext2);
/* 104 */       URL uRL = findConfigFileURL(context, loggerContext2);
/* 105 */       if (uRL != null) {
/* 106 */         configureLoggerContextByURL(loggerContext2, uRL);
/*     */       } else {
/*     */         try {
/* 109 */           (new ContextInitializer(loggerContext2)).autoConfig();
/* 110 */         } catch (JoranException joranException) {}
/*     */       } 
/*     */ 
/*     */       
/* 114 */       if (!StatusUtil.contextHasStatusListener((Context)loggerContext2))
/* 115 */         StatusPrinter.printInCaseOfErrorsOrWarnings((Context)loggerContext2); 
/*     */     } 
/* 117 */     return loggerContext2;
/*     */   }
/*     */ 
/*     */   
/*     */   private String conventionalConfigFileName(String paramString) {
/* 122 */     return "logback-" + paramString + ".xml";
/*     */   }
/*     */   
/*     */   private URL findConfigFileURL(Context paramContext, LoggerContext paramLoggerContext) {
/* 126 */     StatusManager statusManager = paramLoggerContext.getStatusManager();
/*     */     
/* 128 */     String str1 = null;
/*     */     try {
/* 130 */       str1 = JNDIUtil.lookupString(paramContext, "java:comp/env/logback/configuration-resource");
/* 131 */     } catch (NamingException namingException) {}
/*     */ 
/*     */     
/* 134 */     if (str1 != null) {
/* 135 */       statusManager.add((Status)new InfoStatus("Searching for [" + str1 + "]", this));
/* 136 */       URL uRL = urlByResourceName(statusManager, str1);
/* 137 */       if (uRL == null) {
/* 138 */         String str = "The jndi resource [" + str1 + "] for context [" + paramLoggerContext.getName() + "] does not lead to a valid file";
/*     */         
/* 140 */         statusManager.add((Status)new WarnStatus(str, this));
/*     */       } 
/* 142 */       return uRL;
/*     */     } 
/* 144 */     String str2 = conventionalConfigFileName(paramLoggerContext.getName());
/* 145 */     return urlByResourceName(statusManager, str2);
/*     */   }
/*     */ 
/*     */   
/*     */   private URL urlByResourceName(StatusManager paramStatusManager, String paramString) {
/* 150 */     paramStatusManager.add((Status)new InfoStatus("Searching for [" + paramString + "]", this));
/* 151 */     URL uRL = Loader.getResource(paramString, Loader.getTCL());
/* 152 */     if (uRL != null) {
/* 153 */       return uRL;
/*     */     }
/* 155 */     return Loader.getResourceBySelfClassLoader(paramString);
/*     */   }
/*     */   
/*     */   private void configureLoggerContextByURL(LoggerContext paramLoggerContext, URL paramURL) {
/*     */     try {
/* 160 */       JoranConfigurator joranConfigurator = new JoranConfigurator();
/* 161 */       paramLoggerContext.reset();
/* 162 */       joranConfigurator.setContext((Context)paramLoggerContext);
/* 163 */       joranConfigurator.doConfigure(paramURL);
/* 164 */     } catch (JoranException joranException) {}
/*     */     
/* 166 */     StatusPrinter.printInCaseOfErrorsOrWarnings((Context)paramLoggerContext);
/*     */   }
/*     */   
/*     */   public List<String> getContextNames() {
/* 170 */     ArrayList<String> arrayList = new ArrayList();
/* 171 */     arrayList.addAll(this.synchronizedContextMap.keySet());
/* 172 */     return arrayList;
/*     */   }
/*     */   
/*     */   public LoggerContext getLoggerContext(String paramString) {
/* 176 */     return this.synchronizedContextMap.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCount() {
/* 185 */     return this.synchronizedContextMap.size();
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
/*     */   public void setLocalContext(LoggerContext paramLoggerContext) {
/* 197 */     threadLocal.set(paramLoggerContext);
/*     */   }
/*     */   
/*     */   public void removeLocalContext() {
/* 201 */     threadLocal.remove();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\selector\ContextJNDISelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */