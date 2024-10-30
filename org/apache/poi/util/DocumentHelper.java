/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Method;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.stream.events.Namespace;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.xml.sax.ErrorHandler;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.SAXParseException;
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
/*     */ public final class DocumentHelper
/*     */ {
/*  38 */   private static POILogger logger = POILogFactory.getLogger(DocumentHelper.class);
/*     */   
/*     */   private static class DocHelperErrorHandler
/*     */     implements ErrorHandler {
/*     */     private DocHelperErrorHandler() {}
/*     */     
/*     */     public void warning(SAXParseException param1SAXParseException) throws SAXException {
/*  45 */       printError(5, param1SAXParseException);
/*     */     }
/*     */     
/*     */     public void error(SAXParseException param1SAXParseException) throws SAXException {
/*  49 */       printError(7, param1SAXParseException);
/*     */     }
/*     */     
/*     */     public void fatalError(SAXParseException param1SAXParseException) throws SAXException {
/*  53 */       printError(9, param1SAXParseException);
/*  54 */       throw param1SAXParseException;
/*     */     }
/*     */ 
/*     */     
/*     */     private void printError(int param1Int, SAXParseException param1SAXParseException) {
/*  59 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/*  61 */       String str = param1SAXParseException.getSystemId();
/*  62 */       if (str != null) {
/*  63 */         int i = str.lastIndexOf('/');
/*  64 */         if (i != -1)
/*  65 */           str = str.substring(i + 1); 
/*  66 */         stringBuilder.append(str);
/*     */       } 
/*  68 */       stringBuilder.append(':');
/*  69 */       stringBuilder.append(param1SAXParseException.getLineNumber());
/*  70 */       stringBuilder.append(':');
/*  71 */       stringBuilder.append(param1SAXParseException.getColumnNumber());
/*  72 */       stringBuilder.append(": ");
/*  73 */       stringBuilder.append(param1SAXParseException.getMessage());
/*     */       
/*  75 */       DocumentHelper.logger.log(param1Int, stringBuilder.toString(), param1SAXParseException);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized DocumentBuilder newDocumentBuilder() {
/*     */     try {
/*  84 */       DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
/*  85 */       documentBuilder.setEntityResolver(SAXHelper.IGNORING_ENTITY_RESOLVER);
/*  86 */       documentBuilder.setErrorHandler(new DocHelperErrorHandler());
/*  87 */       return documentBuilder;
/*  88 */     } catch (ParserConfigurationException parserConfigurationException) {
/*  89 */       throw new IllegalStateException("cannot create a DocumentBuilder", parserConfigurationException);
/*     */     } 
/*     */   }
/*     */   
/*  93 */   private static final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
/*     */   static {
/*  95 */     documentBuilderFactory.setNamespaceAware(true);
/*  96 */     documentBuilderFactory.setValidating(false);
/*  97 */     trySetSAXFeature(documentBuilderFactory, "http://javax.xml.XMLConstants/feature/secure-processing", true);
/*  98 */     trySetXercesSecurityManager(documentBuilderFactory);
/*     */   }
/*     */   
/*     */   private static void trySetSAXFeature(DocumentBuilderFactory paramDocumentBuilderFactory, String paramString, boolean paramBoolean) {
/*     */     try {
/* 103 */       paramDocumentBuilderFactory.setFeature(paramString, paramBoolean);
/* 104 */     } catch (Exception exception) {
/* 105 */       logger.log(5, new Object[] { "SAX Feature unsupported", paramString, exception });
/* 106 */     } catch (AbstractMethodError abstractMethodError) {
/* 107 */       logger.log(5, new Object[] { "Cannot set SAX feature because outdated XML parser in classpath", paramString, abstractMethodError });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void trySetXercesSecurityManager(DocumentBuilderFactory paramDocumentBuilderFactory) {
/* 113 */     for (String str : new String[] { "com.sun.org.apache.xerces.internal.util.SecurityManager", "org.apache.xerces.util.SecurityManager" }) {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 118 */         Object object = Class.forName(str).newInstance();
/* 119 */         Method method = object.getClass().getMethod("setEntityExpansionLimit", new Class[] { int.class });
/* 120 */         method.invoke(object, new Object[] { Integer.valueOf(4096) });
/* 121 */         paramDocumentBuilderFactory.setAttribute("http://apache.org/xml/properties/security-manager", object);
/*     */         
/*     */         return;
/* 124 */       } catch (Throwable throwable) {
/* 125 */         logger.log(5, "SAX Security Manager could not be setup", throwable);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Document readDocument(InputStream paramInputStream) throws IOException, SAXException {
/* 137 */     return newDocumentBuilder().parse(paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Document readDocument(InputSource paramInputSource) throws IOException, SAXException {
/* 147 */     return newDocumentBuilder().parse(paramInputSource);
/*     */   }
/*     */ 
/*     */   
/* 151 */   private static final DocumentBuilder documentBuilderSingleton = newDocumentBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized Document createDocument() {
/* 157 */     return documentBuilderSingleton.newDocument();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addNamespaceDeclaration(Element paramElement, String paramString1, String paramString2) {
/* 164 */     paramElement.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:" + paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addNamespaceDeclaration(Element paramElement, Namespace paramNamespace) {
/* 173 */     addNamespaceDeclaration(paramElement, paramNamespace.getPrefix(), paramNamespace.getNamespaceURI());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\DocumentHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */