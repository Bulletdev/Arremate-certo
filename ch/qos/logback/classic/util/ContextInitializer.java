/*     */ package ch.qos.logback.classic.util;
/*     */ 
/*     */ import ch.qos.logback.classic.BasicConfigurator;
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.joran.JoranConfigurator;
/*     */ import ch.qos.logback.classic.spi.Configurator;
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.LogbackException;
/*     */ import ch.qos.logback.core.joran.spi.JoranException;
/*     */ import ch.qos.logback.core.status.ErrorStatus;
/*     */ import ch.qos.logback.core.status.InfoStatus;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.StatusManager;
/*     */ import ch.qos.logback.core.status.WarnStatus;
/*     */ import ch.qos.logback.core.util.Loader;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import ch.qos.logback.core.util.StatusListenerConfigHelper;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContextInitializer
/*     */ {
/*     */   public static final String AUTOCONFIG_FILE = "logback.xml";
/*     */   public static final String TEST_AUTOCONFIG_FILE = "logback-test.xml";
/*     */   public static final String CONFIG_FILE_PROPERTY = "logback.configurationFile";
/*     */   final LoggerContext loggerContext;
/*     */   
/*     */   public ContextInitializer(LoggerContext paramLoggerContext) {
/*  53 */     this.loggerContext = paramLoggerContext;
/*     */   }
/*     */   
/*     */   public void configureByResource(URL paramURL) throws JoranException {
/*  57 */     if (paramURL == null) {
/*  58 */       throw new IllegalArgumentException("URL argument cannot be null");
/*     */     }
/*  60 */     String str = paramURL.toString();
/*  61 */     if (str.endsWith("xml")) {
/*  62 */       JoranConfigurator joranConfigurator = new JoranConfigurator();
/*  63 */       joranConfigurator.setContext((Context)this.loggerContext);
/*  64 */       joranConfigurator.doConfigure(paramURL);
/*     */     } else {
/*  66 */       throw new LogbackException("Unexpected filename extension of file [" + paramURL.toString() + "]. Should be .xml");
/*     */     } 
/*     */   }
/*     */   
/*     */   void joranConfigureByResource(URL paramURL) throws JoranException {
/*  71 */     JoranConfigurator joranConfigurator = new JoranConfigurator();
/*  72 */     joranConfigurator.setContext((Context)this.loggerContext);
/*  73 */     joranConfigurator.doConfigure(paramURL);
/*     */   }
/*     */   
/*     */   private URL findConfigFileURLFromSystemProperties(ClassLoader paramClassLoader, boolean paramBoolean) {
/*  77 */     String str = OptionHelper.getSystemProperty("logback.configurationFile");
/*  78 */     if (str != null) {
/*  79 */       URL uRL = null;
/*     */       try {
/*  81 */         uRL = new URL(str);
/*  82 */         return uRL;
/*  83 */       } catch (MalformedURLException malformedURLException) {
/*     */ 
/*     */         
/*  86 */         uRL = Loader.getResource(str, paramClassLoader);
/*  87 */         if (uRL != null) {
/*  88 */           return uRL;
/*     */         }
/*  90 */         File file = new File(str);
/*  91 */         if (file.exists() && file.isFile()) {
/*     */           try {
/*  93 */             uRL = file.toURI().toURL();
/*  94 */             return uRL;
/*  95 */           } catch (MalformedURLException malformedURLException1) {}
/*     */         }
/*     */       } finally {
/*     */         
/*  99 */         if (paramBoolean) {
/* 100 */           statusOnResourceSearch(str, paramClassLoader, uRL);
/*     */         }
/*     */       } 
/*     */     } 
/* 104 */     return null;
/*     */   }
/*     */   
/*     */   public URL findURLOfDefaultConfigurationFile(boolean paramBoolean) {
/* 108 */     ClassLoader classLoader = Loader.getClassLoaderOfObject(this);
/* 109 */     URL uRL = findConfigFileURLFromSystemProperties(classLoader, paramBoolean);
/* 110 */     if (uRL != null) {
/* 111 */       return uRL;
/*     */     }
/*     */     
/* 114 */     uRL = getResource("logback-test.xml", classLoader, paramBoolean);
/* 115 */     if (uRL != null) {
/* 116 */       return uRL;
/*     */     }
/*     */     
/* 119 */     return getResource("logback.xml", classLoader, paramBoolean);
/*     */   }
/*     */   
/*     */   private URL getResource(String paramString, ClassLoader paramClassLoader, boolean paramBoolean) {
/* 123 */     URL uRL = Loader.getResource(paramString, paramClassLoader);
/* 124 */     if (paramBoolean) {
/* 125 */       statusOnResourceSearch(paramString, paramClassLoader, uRL);
/*     */     }
/* 127 */     return uRL;
/*     */   }
/*     */   
/*     */   public void autoConfig() throws JoranException {
/* 131 */     StatusListenerConfigHelper.installIfAsked((Context)this.loggerContext);
/* 132 */     URL uRL = findURLOfDefaultConfigurationFile(true);
/* 133 */     if (uRL != null) {
/* 134 */       configureByResource(uRL);
/*     */     } else {
/* 136 */       Configurator configurator = EnvUtil.<Configurator>loadFromServiceLoader(Configurator.class);
/* 137 */       if (configurator != null) {
/*     */         try {
/* 139 */           configurator.setContext((Context)this.loggerContext);
/* 140 */           configurator.configure(this.loggerContext);
/* 141 */         } catch (Exception exception) {
/* 142 */           throw new LogbackException(String.format("Failed to initialize Configurator: %s using ServiceLoader", new Object[] { (configurator != null) ? configurator.getClass()
/* 143 */                   .getCanonicalName() : "null" }), exception);
/*     */         } 
/*     */       } else {
/* 146 */         BasicConfigurator basicConfigurator = new BasicConfigurator();
/* 147 */         basicConfigurator.setContext((Context)this.loggerContext);
/* 148 */         basicConfigurator.configure(this.loggerContext);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void statusOnResourceSearch(String paramString, ClassLoader paramClassLoader, URL paramURL) {
/* 154 */     StatusManager statusManager = this.loggerContext.getStatusManager();
/* 155 */     if (paramURL == null) {
/* 156 */       statusManager.add((Status)new InfoStatus("Could NOT find resource [" + paramString + "]", this.loggerContext));
/*     */     } else {
/* 158 */       statusManager.add((Status)new InfoStatus("Found resource [" + paramString + "] at [" + paramURL.toString() + "]", this.loggerContext));
/* 159 */       multiplicityWarning(paramString, paramClassLoader);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void multiplicityWarning(String paramString, ClassLoader paramClassLoader) {
/* 164 */     Set set = null;
/* 165 */     StatusManager statusManager = this.loggerContext.getStatusManager();
/*     */     try {
/* 167 */       set = Loader.getResources(paramString, paramClassLoader);
/* 168 */     } catch (IOException iOException) {
/* 169 */       statusManager.add((Status)new ErrorStatus("Failed to get url list for resource [" + paramString + "]", this.loggerContext, iOException));
/*     */     } 
/* 171 */     if (set != null && set.size() > 1) {
/* 172 */       statusManager.add((Status)new WarnStatus("Resource [" + paramString + "] occurs multiple times on the classpath.", this.loggerContext));
/* 173 */       for (URL uRL : set)
/* 174 */         statusManager.add((Status)new WarnStatus("Resource [" + paramString + "] occurs at [" + uRL.toString() + "]", this.loggerContext)); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classi\\util\ContextInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */