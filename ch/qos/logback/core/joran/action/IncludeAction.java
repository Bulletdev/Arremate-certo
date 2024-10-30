/*     */ package ch.qos.logback.core.joran.action;
/*     */ 
/*     */ import ch.qos.logback.core.joran.event.SaxEvent;
/*     */ import ch.qos.logback.core.joran.event.SaxEventRecorder;
/*     */ import ch.qos.logback.core.joran.spi.ActionException;
/*     */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*     */ import ch.qos.logback.core.joran.spi.JoranException;
/*     */ import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
/*     */ import ch.qos.logback.core.util.Loader;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import org.xml.sax.Attributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IncludeAction
/*     */   extends Action
/*     */ {
/*     */   private static final String INCLUDED_TAG = "included";
/*     */   private static final String FILE_ATTR = "file";
/*     */   private static final String URL_ATTR = "url";
/*     */   private static final String RESOURCE_ATTR = "resource";
/*     */   private static final String OPTIONAL_ATTR = "optional";
/*     */   private String attributeInUse;
/*     */   private boolean optional;
/*     */   
/*     */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) throws ActionException {
/*  49 */     SaxEventRecorder saxEventRecorder = new SaxEventRecorder(this.context);
/*     */     
/*  51 */     this.attributeInUse = null;
/*  52 */     this.optional = OptionHelper.toBoolean(paramAttributes.getValue("optional"), false);
/*     */     
/*  54 */     if (!checkAttributes(paramAttributes)) {
/*     */       return;
/*     */     }
/*     */     
/*  58 */     InputStream inputStream = getInputStream(paramInterpretationContext, paramAttributes);
/*     */     
/*     */     try {
/*  61 */       if (inputStream != null) {
/*  62 */         parseAndRecord(inputStream, saxEventRecorder);
/*     */         
/*  64 */         trimHeadAndTail(saxEventRecorder);
/*     */ 
/*     */         
/*  67 */         paramInterpretationContext.getJoranInterpreter().getEventPlayer().addEventsDynamically(saxEventRecorder.saxEventList, 2);
/*     */       } 
/*  69 */     } catch (JoranException joranException) {
/*  70 */       addError("Error while parsing  " + this.attributeInUse, (Throwable)joranException);
/*     */     } finally {
/*  72 */       close(inputStream);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void close(InputStream paramInputStream) {
/*  78 */     if (paramInputStream != null) {
/*     */       try {
/*  80 */         paramInputStream.close();
/*  81 */       } catch (IOException iOException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkAttributes(Attributes paramAttributes) {
/*  87 */     String str1 = paramAttributes.getValue("file");
/*  88 */     String str2 = paramAttributes.getValue("url");
/*  89 */     String str3 = paramAttributes.getValue("resource");
/*     */     
/*  91 */     byte b = 0;
/*     */     
/*  93 */     if (!OptionHelper.isEmpty(str1)) {
/*  94 */       b++;
/*     */     }
/*  96 */     if (!OptionHelper.isEmpty(str2)) {
/*  97 */       b++;
/*     */     }
/*  99 */     if (!OptionHelper.isEmpty(str3)) {
/* 100 */       b++;
/*     */     }
/*     */     
/* 103 */     if (b == 0) {
/* 104 */       addError("One of \"path\", \"resource\" or \"url\" attributes must be set.");
/* 105 */       return false;
/* 106 */     }  if (b > 1) {
/* 107 */       addError("Only one of \"file\", \"url\" or \"resource\" attributes should be set.");
/* 108 */       return false;
/* 109 */     }  if (b == 1) {
/* 110 */       return true;
/*     */     }
/* 112 */     throw new IllegalStateException("Count value [" + b + "] is not expected");
/*     */   }
/*     */   
/*     */   URL attributeToURL(String paramString) {
/*     */     try {
/* 117 */       return new URL(paramString);
/* 118 */     } catch (MalformedURLException malformedURLException) {
/* 119 */       String str = "URL [" + paramString + "] is not well formed.";
/* 120 */       addError(str, malformedURLException);
/* 121 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   InputStream openURL(URL paramURL) {
/*     */     try {
/* 127 */       return paramURL.openStream();
/* 128 */     } catch (IOException iOException) {
/* 129 */       optionalWarning("Failed to open [" + paramURL.toString() + "]");
/* 130 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   URL resourceAsURL(String paramString) {
/* 135 */     URL uRL = Loader.getResourceBySelfClassLoader(paramString);
/* 136 */     if (uRL == null) {
/* 137 */       optionalWarning("Could not find resource corresponding to [" + paramString + "]");
/* 138 */       return null;
/*     */     } 
/* 140 */     return uRL;
/*     */   }
/*     */   
/*     */   private void optionalWarning(String paramString) {
/* 144 */     if (!this.optional) {
/* 145 */       addWarn(paramString);
/*     */     }
/*     */   }
/*     */   
/*     */   URL filePathAsURL(String paramString) {
/* 150 */     URI uRI = (new File(paramString)).toURI();
/*     */     try {
/* 152 */       return uRI.toURL();
/* 153 */     } catch (MalformedURLException malformedURLException) {
/*     */       
/* 155 */       malformedURLException.printStackTrace();
/* 156 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   URL getInputURL(InterpretationContext paramInterpretationContext, Attributes paramAttributes) {
/* 161 */     String str1 = paramAttributes.getValue("file");
/* 162 */     String str2 = paramAttributes.getValue("url");
/* 163 */     String str3 = paramAttributes.getValue("resource");
/*     */     
/* 165 */     if (!OptionHelper.isEmpty(str1)) {
/* 166 */       this.attributeInUse = paramInterpretationContext.subst(str1);
/* 167 */       return filePathAsURL(this.attributeInUse);
/*     */     } 
/*     */     
/* 170 */     if (!OptionHelper.isEmpty(str2)) {
/* 171 */       this.attributeInUse = paramInterpretationContext.subst(str2);
/* 172 */       return attributeToURL(this.attributeInUse);
/*     */     } 
/*     */     
/* 175 */     if (!OptionHelper.isEmpty(str3)) {
/* 176 */       this.attributeInUse = paramInterpretationContext.subst(str3);
/* 177 */       return resourceAsURL(this.attributeInUse);
/*     */     } 
/*     */     
/* 180 */     throw new IllegalStateException("A URL stream should have been returned");
/*     */   }
/*     */ 
/*     */   
/*     */   InputStream getInputStream(InterpretationContext paramInterpretationContext, Attributes paramAttributes) {
/* 185 */     URL uRL = getInputURL(paramInterpretationContext, paramAttributes);
/* 186 */     if (uRL == null) {
/* 187 */       return null;
/*     */     }
/* 189 */     ConfigurationWatchListUtil.addToWatchList(this.context, uRL);
/* 190 */     return openURL(uRL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void trimHeadAndTail(SaxEventRecorder paramSaxEventRecorder) {
/* 197 */     List<SaxEvent> list = paramSaxEventRecorder.saxEventList;
/*     */     
/* 199 */     if (list.size() == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 203 */     SaxEvent saxEvent1 = list.get(0);
/* 204 */     if (saxEvent1 != null && saxEvent1.qName.equalsIgnoreCase("included")) {
/* 205 */       list.remove(0);
/*     */     }
/*     */     
/* 208 */     SaxEvent saxEvent2 = list.get(paramSaxEventRecorder.saxEventList.size() - 1);
/* 209 */     if (saxEvent2 != null && saxEvent2.qName.equalsIgnoreCase("included")) {
/* 210 */       list.remove(paramSaxEventRecorder.saxEventList.size() - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private void parseAndRecord(InputStream paramInputStream, SaxEventRecorder paramSaxEventRecorder) throws JoranException {
/* 215 */     paramSaxEventRecorder.setContext(this.context);
/* 216 */     paramSaxEventRecorder.recordEvents(paramInputStream);
/*     */   }
/*     */   
/*     */   public void end(InterpretationContext paramInterpretationContext, String paramString) throws ActionException {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\IncludeAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */