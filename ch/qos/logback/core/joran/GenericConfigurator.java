/*     */ package ch.qos.logback.core.joran;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.event.SaxEvent;
/*     */ import ch.qos.logback.core.joran.event.SaxEventRecorder;
/*     */ import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
/*     */ import ch.qos.logback.core.joran.spi.ElementPath;
/*     */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*     */ import ch.qos.logback.core.joran.spi.Interpreter;
/*     */ import ch.qos.logback.core.joran.spi.JoranException;
/*     */ import ch.qos.logback.core.joran.spi.RuleStore;
/*     */ import ch.qos.logback.core.joran.spi.SimpleRuleStore;
/*     */ import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
/*     */ import ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.status.StatusUtil;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.util.List;
/*     */ import org.xml.sax.InputSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GenericConfigurator
/*     */   extends ContextAwareBase
/*     */ {
/*     */   private BeanDescriptionCache beanDescriptionCache;
/*     */   protected Interpreter interpreter;
/*     */   
/*     */   public final void doConfigure(URL paramURL) throws JoranException {
/*  44 */     InputStream inputStream = null;
/*     */     try {
/*  46 */       informContextOfURLUsedForConfiguration(getContext(), paramURL);
/*  47 */       URLConnection uRLConnection = paramURL.openConnection();
/*     */ 
/*     */       
/*  50 */       uRLConnection.setUseCaches(false);
/*     */       
/*  52 */       inputStream = uRLConnection.getInputStream();
/*  53 */       doConfigure(inputStream, paramURL.toExternalForm());
/*  54 */     } catch (IOException iOException) {
/*  55 */       String str = "Could not open URL [" + paramURL + "].";
/*  56 */       addError(str, iOException);
/*  57 */       throw new JoranException(str, iOException);
/*     */     } finally {
/*  59 */       if (inputStream != null) {
/*     */         try {
/*  61 */           inputStream.close();
/*  62 */         } catch (IOException iOException) {
/*  63 */           String str = "Could not close input stream";
/*  64 */           addError(str, iOException);
/*  65 */           throw new JoranException(str, iOException);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void doConfigure(String paramString) throws JoranException {
/*  72 */     doConfigure(new File(paramString));
/*     */   }
/*     */   
/*     */   public final void doConfigure(File paramFile) throws JoranException {
/*  76 */     FileInputStream fileInputStream = null;
/*     */     try {
/*  78 */       URL uRL = paramFile.toURI().toURL();
/*  79 */       informContextOfURLUsedForConfiguration(getContext(), uRL);
/*  80 */       fileInputStream = new FileInputStream(paramFile);
/*  81 */       doConfigure(fileInputStream, uRL.toExternalForm());
/*  82 */     } catch (IOException iOException) {
/*  83 */       String str = "Could not open [" + paramFile.getPath() + "].";
/*  84 */       addError(str, iOException);
/*  85 */       throw new JoranException(str, iOException);
/*     */     } finally {
/*  87 */       if (fileInputStream != null) {
/*     */         try {
/*  89 */           fileInputStream.close();
/*  90 */         } catch (IOException iOException) {
/*  91 */           String str = "Could not close [" + paramFile.getName() + "].";
/*  92 */           addError(str, iOException);
/*  93 */           throw new JoranException(str, iOException);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void informContextOfURLUsedForConfiguration(Context paramContext, URL paramURL) {
/* 100 */     ConfigurationWatchListUtil.setMainWatchURL(paramContext, paramURL);
/*     */   }
/*     */   
/*     */   public final void doConfigure(InputStream paramInputStream) throws JoranException {
/* 104 */     doConfigure(new InputSource(paramInputStream));
/*     */   }
/*     */   
/*     */   public final void doConfigure(InputStream paramInputStream, String paramString) throws JoranException {
/* 108 */     InputSource inputSource = new InputSource(paramInputStream);
/* 109 */     inputSource.setSystemId(paramString);
/* 110 */     doConfigure(inputSource);
/*     */   }
/*     */   
/*     */   protected BeanDescriptionCache getBeanDescriptionCache() {
/* 114 */     if (this.beanDescriptionCache == null) {
/* 115 */       this.beanDescriptionCache = new BeanDescriptionCache(getContext());
/*     */     }
/* 117 */     return this.beanDescriptionCache;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void addInstanceRules(RuleStore paramRuleStore);
/*     */ 
/*     */   
/*     */   protected abstract void addImplicitRules(Interpreter paramInterpreter);
/*     */   
/*     */   protected void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry paramDefaultNestedComponentRegistry) {}
/*     */   
/*     */   protected ElementPath initialElementPath() {
/* 129 */     return new ElementPath();
/*     */   }
/*     */   
/*     */   protected void buildInterpreter() {
/* 133 */     SimpleRuleStore simpleRuleStore = new SimpleRuleStore(this.context);
/* 134 */     addInstanceRules((RuleStore)simpleRuleStore);
/* 135 */     this.interpreter = new Interpreter(this.context, (RuleStore)simpleRuleStore, initialElementPath());
/* 136 */     InterpretationContext interpretationContext = this.interpreter.getInterpretationContext();
/* 137 */     interpretationContext.setContext(this.context);
/* 138 */     addImplicitRules(this.interpreter);
/* 139 */     addDefaultNestedComponentRegistryRules(interpretationContext.getDefaultNestedComponentRegistry());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void doConfigure(InputSource paramInputSource) throws JoranException {
/* 146 */     long l = System.currentTimeMillis();
/*     */ 
/*     */ 
/*     */     
/* 150 */     SaxEventRecorder saxEventRecorder = new SaxEventRecorder(this.context);
/* 151 */     saxEventRecorder.recordEvents(paramInputSource);
/* 152 */     doConfigure(saxEventRecorder.saxEventList);
/*     */     
/* 154 */     StatusUtil statusUtil = new StatusUtil(this.context);
/* 155 */     if (statusUtil.noXMLParsingErrorsOccurred(l)) {
/* 156 */       addInfo("Registering current configuration as safe fallback point");
/* 157 */       registerSafeConfiguration(saxEventRecorder.saxEventList);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void doConfigure(List<SaxEvent> paramList) throws JoranException {
/* 162 */     buildInterpreter();
/*     */     
/* 164 */     synchronized (this.context.getConfigurationLock()) {
/* 165 */       this.interpreter.getEventPlayer().play(paramList);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerSafeConfiguration(List<SaxEvent> paramList) {
/* 176 */     this.context.putObject("SAFE_JORAN_CONFIGURATION", paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<SaxEvent> recallSafeConfiguration() {
/* 184 */     return (List<SaxEvent>)this.context.getObject("SAFE_JORAN_CONFIGURATION");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\GenericConfigurator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */