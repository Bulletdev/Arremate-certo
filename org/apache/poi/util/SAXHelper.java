/*    */ package org.apache.poi.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.StringReader;
/*    */ import java.lang.reflect.Method;
/*    */ import javax.xml.parsers.ParserConfigurationException;
/*    */ import javax.xml.parsers.SAXParserFactory;
/*    */ import org.xml.sax.EntityResolver;
/*    */ import org.xml.sax.InputSource;
/*    */ import org.xml.sax.SAXException;
/*    */ import org.xml.sax.XMLReader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SAXHelper
/*    */ {
/* 38 */   private static POILogger logger = POILogFactory.getLogger(SAXHelper.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized XMLReader newXMLReader() throws SAXException, ParserConfigurationException {
/* 46 */     XMLReader xMLReader = saxFactory.newSAXParser().getXMLReader();
/* 47 */     xMLReader.setEntityResolver(IGNORING_ENTITY_RESOLVER);
/* 48 */     trySetSAXFeature(xMLReader, "http://javax.xml.XMLConstants/feature/secure-processing", true);
/* 49 */     trySetXercesSecurityManager(xMLReader);
/* 50 */     return xMLReader;
/*    */   }
/*    */   
/* 53 */   static final EntityResolver IGNORING_ENTITY_RESOLVER = new EntityResolver()
/*    */     {
/*    */       public InputSource resolveEntity(String param1String1, String param1String2) throws SAXException, IOException
/*    */       {
/* 57 */         return new InputSource(new StringReader(""));
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */   
/* 63 */   private static final SAXParserFactory saxFactory = SAXParserFactory.newInstance(); static {
/* 64 */     saxFactory.setValidating(false);
/* 65 */     saxFactory.setNamespaceAware(true);
/*    */   }
/*    */   
/*    */   private static void trySetSAXFeature(XMLReader paramXMLReader, String paramString, boolean paramBoolean) {
/*    */     try {
/* 70 */       paramXMLReader.setFeature(paramString, paramBoolean);
/* 71 */     } catch (Exception exception) {
/* 72 */       logger.log(5, new Object[] { "SAX Feature unsupported", paramString, exception });
/* 73 */     } catch (AbstractMethodError abstractMethodError) {
/* 74 */       logger.log(5, new Object[] { "Cannot set SAX feature because outdated XML parser in classpath", paramString, abstractMethodError });
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private static void trySetXercesSecurityManager(XMLReader paramXMLReader) {
/* 80 */     for (String str : new String[] { "com.sun.org.apache.xerces.internal.util.SecurityManager", "org.apache.xerces.util.SecurityManager" }) {
/*    */ 
/*    */       
/*    */       try {
/*    */         
/* 85 */         Object object = Class.forName(str).newInstance();
/* 86 */         Method method = object.getClass().getMethod("setEntityExpansionLimit", new Class[] { int.class });
/* 87 */         method.invoke(object, new Object[] { Integer.valueOf(4096) });
/* 88 */         paramXMLReader.setProperty("http://apache.org/xml/properties/security-manager", object);
/*    */         
/*    */         return;
/* 91 */       } catch (Exception exception) {
/* 92 */         logger.log(5, "SAX Security Manager could not be setup", exception);
/* 93 */       } catch (Error error) {
/* 94 */         logger.log(5, "SAX Security Manager could not be setup", error);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\SAXHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */