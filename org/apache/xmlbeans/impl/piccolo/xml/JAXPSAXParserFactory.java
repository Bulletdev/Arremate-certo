/*     */ package org.apache.xmlbeans.impl.piccolo.xml;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.parsers.SAXParser;
/*     */ import javax.xml.parsers.SAXParserFactory;
/*     */ import org.apache.xmlbeans.impl.piccolo.util.FactoryServiceFinder;
/*     */ import org.xml.sax.Parser;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.SAXNotRecognizedException;
/*     */ import org.xml.sax.SAXNotSupportedException;
/*     */ import org.xml.sax.XMLReader;
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
/*     */ public class JAXPSAXParserFactory
/*     */   extends SAXParserFactory
/*     */ {
/*  49 */   private Map featureMap = new HashMap();
/*  50 */   private static Boolean TRUE = new Boolean(true);
/*  51 */   private static Boolean FALSE = new Boolean(false);
/*  52 */   private Piccolo nvParser = new Piccolo();
/*     */ 
/*     */   
/*     */   private SAXParserFactory validatingFactory;
/*     */   
/*     */   private static final String VALIDATING_PROPERTY = "org.apache.xmlbeans.impl.piccolo.xml.ValidatingSAXParserFactory";
/*     */   
/*  59 */   private static Class validatingFactoryClass = findValidatingFactory();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   private ParserConfigurationException pendingValidatingException = null; private ParserConfigurationException pendingNonvalidatingException = null;
/*     */   
/*     */   private boolean validating = false, namespaceAware = false;
/*     */ 
/*     */   
/*     */   public static SAXParserFactory newInstance() {
/*  70 */     return new JAXPSAXParserFactory();
/*     */   }
/*     */   
/*     */   public JAXPSAXParserFactory() {
/*     */     try {
/*  75 */       if (validatingFactoryClass != null) {
/*  76 */         this.validatingFactory = validatingFactoryClass.newInstance();
/*     */         
/*  78 */         this.validatingFactory.setNamespaceAware(false);
/*  79 */         this.validatingFactory.setValidating(true);
/*     */       }
/*     */     
/*  82 */     } catch (Exception exception) {
/*  83 */       this.validatingFactory = null;
/*     */     } 
/*     */     
/*  86 */     setNamespaceAware(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFeature(String paramString) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
/*  93 */     if (this.validating && this.validatingFactory != null) {
/*  94 */       return this.validatingFactory.getFeature(paramString);
/*     */     }
/*  96 */     return this.nvParser.getFeature(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public SAXParser newSAXParser() throws ParserConfigurationException, SAXException {
/* 101 */     if (this.validating) {
/* 102 */       if (this.validatingFactory == null) {
/* 103 */         throw new ParserConfigurationException("XML document validation is not supported");
/*     */       }
/*     */       
/* 106 */       if (this.pendingValidatingException != null) {
/* 107 */         throw this.pendingValidatingException;
/*     */       }
/* 109 */       return this.validatingFactory.newSAXParser();
/*     */     } 
/*     */     
/* 112 */     if (this.pendingNonvalidatingException != null) {
/* 113 */       throw this.pendingNonvalidatingException;
/*     */     }
/* 115 */     return new JAXPSAXParser(new Piccolo(this.nvParser));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFeature(String paramString, boolean paramBoolean) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
/* 124 */     this.featureMap.put(paramString, paramBoolean ? TRUE : FALSE);
/*     */ 
/*     */     
/* 127 */     if (this.validatingFactory != null) {
/* 128 */       if (this.pendingValidatingException != null) {
/* 129 */         reconfigureValidating();
/*     */       } else {
/*     */         try {
/* 132 */           this.validatingFactory.setFeature(paramString, paramBoolean);
/*     */         }
/* 134 */         catch (ParserConfigurationException parserConfigurationException) {
/* 135 */           this.pendingValidatingException = parserConfigurationException;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 141 */     if (this.pendingNonvalidatingException != null) {
/* 142 */       reconfigureNonvalidating();
/*     */     }
/*     */     
/* 145 */     if (this.validating && this.pendingValidatingException != null) {
/* 146 */       throw this.pendingValidatingException;
/*     */     }
/* 148 */     if (!this.validating && this.pendingNonvalidatingException != null)
/* 149 */       throw this.pendingNonvalidatingException; 
/*     */   }
/*     */   
/*     */   public void setNamespaceAware(boolean paramBoolean) {
/* 153 */     super.setNamespaceAware(paramBoolean);
/* 154 */     this.namespaceAware = paramBoolean;
/*     */     
/*     */     try {
/* 157 */       this.nvParser.setFeature("http://xml.org/sax/features/namespaces", paramBoolean);
/*     */       
/* 159 */       this.nvParser.setFeature("http://xml.org/sax/features/namespace-prefixes", !paramBoolean);
/*     */     
/*     */     }
/* 162 */     catch (SAXNotSupportedException sAXNotSupportedException) {
/* 163 */       this.pendingNonvalidatingException = new ParserConfigurationException("Error setting namespace feature: " + sAXNotSupportedException.toString());
/*     */     
/*     */     }
/* 166 */     catch (SAXNotRecognizedException sAXNotRecognizedException) {
/* 167 */       this.pendingNonvalidatingException = new ParserConfigurationException("Error setting namespace feature: " + sAXNotRecognizedException.toString());
/*     */     } 
/*     */ 
/*     */     
/* 171 */     if (this.validatingFactory != null)
/* 172 */       this.validatingFactory.setNamespaceAware(paramBoolean); 
/*     */   }
/*     */   
/*     */   public void setValidating(boolean paramBoolean) {
/* 176 */     super.setValidating(paramBoolean);
/* 177 */     this.validating = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Class findValidatingFactory() {
/*     */     try {
/* 185 */       String str = System.getProperty("org.apache.xmlbeans.impl.piccolo.xml.ValidatingSAXParserFactory");
/*     */       
/* 187 */       if (str != null) {
/* 188 */         return Class.forName(str);
/*     */       }
/* 190 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*     */     try {
/* 194 */       String str1 = System.getProperty("java.home");
/* 195 */       String str2 = str1 + File.separator + "lib" + File.separator + "jaxp.properties";
/*     */       
/* 197 */       File file = new File(str2);
/* 198 */       if (file.exists()) {
/* 199 */         Properties properties = new Properties();
/* 200 */         properties.load(new FileInputStream(file));
/* 201 */         String str = properties.getProperty("org.apache.xmlbeans.impl.piccolo.xml.ValidatingSAXParserFactory");
/* 202 */         if (str != null)
/* 203 */           return Class.forName(str); 
/*     */       } 
/* 205 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 211 */       Enumeration enumeration = FactoryServiceFinder.findServices("javax.xml.parsers.SAXParserFactory");
/*     */       
/* 213 */       while (enumeration.hasMoreElements()) {
/*     */         try {
/* 215 */           String str = enumeration.nextElement();
/* 216 */           if (!str.equals("org.apache.xmlbeans.impl.piccolo.xml.Piccolo")) {
/* 217 */             return Class.forName(str);
/*     */           }
/* 219 */         } catch (ClassNotFoundException classNotFoundException) {}
/*     */       }
/*     */     
/* 222 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*     */     try {
/* 226 */       return Class.forName("org.apache.crimson.jaxp.SAXParserFactoryImpl");
/*     */     
/*     */     }
/* 229 */     catch (ClassNotFoundException classNotFoundException) {
/* 230 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void reconfigureValidating() {
/* 236 */     if (this.validatingFactory == null) {
/*     */       return;
/*     */     }
/*     */     try {
/* 240 */       Iterator iterator = this.featureMap.entrySet().iterator();
/* 241 */       while (iterator.hasNext()) {
/* 242 */         Map.Entry entry = iterator.next();
/* 243 */         this.validatingFactory.setFeature((String)entry.getKey(), ((Boolean)entry.getValue()).booleanValue());
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 248 */     catch (ParserConfigurationException parserConfigurationException) {
/* 249 */       this.pendingValidatingException = parserConfigurationException;
/*     */     }
/* 251 */     catch (SAXNotRecognizedException sAXNotRecognizedException) {
/* 252 */       this.pendingValidatingException = new ParserConfigurationException(sAXNotRecognizedException.toString());
/*     */     
/*     */     }
/* 255 */     catch (SAXNotSupportedException sAXNotSupportedException) {
/* 256 */       this.pendingValidatingException = new ParserConfigurationException(sAXNotSupportedException.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void reconfigureNonvalidating() {
/*     */     try {
/* 263 */       Iterator iterator = this.featureMap.entrySet().iterator();
/* 264 */       while (iterator.hasNext()) {
/* 265 */         Map.Entry entry = iterator.next();
/* 266 */         this.nvParser.setFeature((String)entry.getKey(), ((Boolean)entry.getValue()).booleanValue());
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 271 */     catch (SAXNotRecognizedException sAXNotRecognizedException) {
/* 272 */       this.pendingNonvalidatingException = new ParserConfigurationException(sAXNotRecognizedException.toString());
/*     */     
/*     */     }
/* 275 */     catch (SAXNotSupportedException sAXNotSupportedException) {
/* 276 */       this.pendingNonvalidatingException = new ParserConfigurationException(sAXNotSupportedException.toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   static class JAXPSAXParser
/*     */     extends SAXParser {
/*     */     Piccolo parser;
/*     */     
/*     */     JAXPSAXParser(Piccolo param1Piccolo) {
/* 285 */       this.parser = param1Piccolo;
/*     */     }
/*     */     public Parser getParser() {
/* 288 */       return this.parser;
/*     */     }
/*     */     
/*     */     public Object getProperty(String param1String) throws SAXNotRecognizedException, SAXNotSupportedException {
/* 292 */       return this.parser.getProperty(param1String);
/*     */     }
/*     */     public XMLReader getXMLReader() {
/* 295 */       return this.parser;
/*     */     }
/*     */     public boolean isNamespaceAware() {
/* 298 */       return this.parser.fNamespaces;
/*     */     }
/*     */     public boolean isValidating() {
/* 301 */       return false;
/*     */     }
/*     */     
/*     */     public void setProperty(String param1String, Object param1Object) throws SAXNotRecognizedException, SAXNotSupportedException {
/* 305 */       this.parser.setProperty(param1String, param1Object);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\JAXPSAXParserFactory.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */