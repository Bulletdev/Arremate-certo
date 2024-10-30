/*     */ package ch.qos.logback.core.joran.event;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.spi.ElementPath;
/*     */ import ch.qos.logback.core.joran.spi.JoranException;
/*     */ import ch.qos.logback.core.spi.ContextAware;
/*     */ import ch.qos.logback.core.spi.ContextAwareImpl;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.parsers.SAXParser;
/*     */ import javax.xml.parsers.SAXParserFactory;
/*     */ import org.xml.sax.Attributes;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.Locator;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.SAXParseException;
/*     */ import org.xml.sax.helpers.DefaultHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SaxEventRecorder
/*     */   extends DefaultHandler
/*     */   implements ContextAware
/*     */ {
/*     */   final ContextAwareImpl cai;
/*     */   public List<SaxEvent> saxEventList;
/*     */   Locator locator;
/*     */   ElementPath globalElementPath;
/*     */   
/*     */   public SaxEventRecorder(Context paramContext) {
/*  48 */     this.saxEventList = new ArrayList<SaxEvent>();
/*     */     
/*  50 */     this.globalElementPath = new ElementPath();
/*     */     this.cai = new ContextAwareImpl(paramContext, this);
/*     */   } public final void recordEvents(InputStream paramInputStream) throws JoranException {
/*  53 */     recordEvents(new InputSource(paramInputStream));
/*     */   }
/*     */   
/*     */   public List<SaxEvent> recordEvents(InputSource paramInputSource) throws JoranException {
/*  57 */     SAXParser sAXParser = buildSaxParser();
/*     */     try {
/*  59 */       sAXParser.parse(paramInputSource, this);
/*  60 */       return this.saxEventList;
/*  61 */     } catch (IOException iOException) {
/*  62 */       handleError("I/O error occurred while parsing xml file", iOException);
/*  63 */     } catch (SAXException sAXException) {
/*     */       
/*  65 */       throw new JoranException("Problem parsing XML document. See previously reported errors.", sAXException);
/*  66 */     } catch (Exception exception) {
/*  67 */       handleError("Unexpected exception while parsing XML document.", exception);
/*     */     } 
/*  69 */     throw new IllegalStateException("This point can never be reached");
/*     */   }
/*     */   
/*     */   private void handleError(String paramString, Throwable paramThrowable) throws JoranException {
/*  73 */     addError(paramString, paramThrowable);
/*  74 */     throw new JoranException(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   private SAXParser buildSaxParser() throws JoranException {
/*     */     try {
/*  79 */       SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
/*  80 */       sAXParserFactory.setValidating(false);
/*     */       
/*  82 */       sAXParserFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
/*  83 */       sAXParserFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
/*  84 */       sAXParserFactory.setNamespaceAware(true);
/*  85 */       return sAXParserFactory.newSAXParser();
/*  86 */     } catch (Exception exception) {
/*  87 */       String str = "Parser configuration error occurred";
/*  88 */       addError(str, exception);
/*  89 */       throw new JoranException(str, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void startDocument() {}
/*     */   
/*     */   public Locator getLocator() {
/*  97 */     return this.locator;
/*     */   }
/*     */   
/*     */   public void setDocumentLocator(Locator paramLocator) {
/* 101 */     this.locator = paramLocator;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes) {
/* 106 */     String str = getTagName(paramString2, paramString3);
/* 107 */     this.globalElementPath.push(str);
/* 108 */     ElementPath elementPath = this.globalElementPath.duplicate();
/* 109 */     this.saxEventList.add(new StartEvent(elementPath, paramString1, paramString2, paramString3, paramAttributes, getLocator()));
/*     */   }
/*     */   
/*     */   public void characters(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 113 */     String str = new String(paramArrayOfchar, paramInt1, paramInt2);
/* 114 */     SaxEvent saxEvent = getLastEvent();
/* 115 */     if (saxEvent instanceof BodyEvent) {
/* 116 */       BodyEvent bodyEvent = (BodyEvent)saxEvent;
/* 117 */       bodyEvent.append(str);
/*     */     
/*     */     }
/* 120 */     else if (!isSpaceOnly(str)) {
/* 121 */       this.saxEventList.add(new BodyEvent(str, getLocator()));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   boolean isSpaceOnly(String paramString) {
/* 127 */     String str = paramString.trim();
/* 128 */     return (str.length() == 0);
/*     */   }
/*     */   
/*     */   SaxEvent getLastEvent() {
/* 132 */     if (this.saxEventList.isEmpty()) {
/* 133 */       return null;
/*     */     }
/* 135 */     int i = this.saxEventList.size();
/* 136 */     return this.saxEventList.get(i - 1);
/*     */   }
/*     */   
/*     */   public void endElement(String paramString1, String paramString2, String paramString3) {
/* 140 */     this.saxEventList.add(new EndEvent(paramString1, paramString2, paramString3, getLocator()));
/* 141 */     this.globalElementPath.pop();
/*     */   }
/*     */   
/*     */   String getTagName(String paramString1, String paramString2) {
/* 145 */     String str = paramString1;
/* 146 */     if (str == null || str.length() < 1) {
/* 147 */       str = paramString2;
/*     */     }
/* 149 */     return str;
/*     */   }
/*     */   
/*     */   public void error(SAXParseException paramSAXParseException) throws SAXException {
/* 153 */     addError("XML_PARSING - Parsing error on line " + paramSAXParseException.getLineNumber() + " and column " + paramSAXParseException.getColumnNumber());
/* 154 */     addError(paramSAXParseException.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fatalError(SAXParseException paramSAXParseException) throws SAXException {
/* 159 */     addError("XML_PARSING - Parsing fatal error on line " + paramSAXParseException.getLineNumber() + " and column " + paramSAXParseException.getColumnNumber());
/* 160 */     addError(paramSAXParseException.toString());
/*     */   }
/*     */   
/*     */   public void warning(SAXParseException paramSAXParseException) throws SAXException {
/* 164 */     addWarn("XML_PARSING - Parsing warning on line " + paramSAXParseException.getLineNumber() + " and column " + paramSAXParseException.getColumnNumber(), paramSAXParseException);
/*     */   }
/*     */   
/*     */   public void addError(String paramString) {
/* 168 */     this.cai.addError(paramString);
/*     */   }
/*     */   
/*     */   public void addError(String paramString, Throwable paramThrowable) {
/* 172 */     this.cai.addError(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public void addInfo(String paramString) {
/* 176 */     this.cai.addInfo(paramString);
/*     */   }
/*     */   
/*     */   public void addInfo(String paramString, Throwable paramThrowable) {
/* 180 */     this.cai.addInfo(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public void addStatus(Status paramStatus) {
/* 184 */     this.cai.addStatus(paramStatus);
/*     */   }
/*     */   
/*     */   public void addWarn(String paramString) {
/* 188 */     this.cai.addWarn(paramString);
/*     */   }
/*     */   
/*     */   public void addWarn(String paramString, Throwable paramThrowable) {
/* 192 */     this.cai.addWarn(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public Context getContext() {
/* 196 */     return this.cai.getContext();
/*     */   }
/*     */   
/*     */   public void setContext(Context paramContext) {
/* 200 */     this.cai.setContext(paramContext);
/*     */   }
/*     */   
/*     */   public List<SaxEvent> getSaxEventList() {
/* 204 */     return this.saxEventList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\event\SaxEventRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */