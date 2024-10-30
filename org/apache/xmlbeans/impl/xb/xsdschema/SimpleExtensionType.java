/*    */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.Reader;
/*    */ import java.net.URL;
/*    */ import javax.xml.stream.XMLStreamReader;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlBeans;
/*    */ import org.apache.xmlbeans.XmlException;
/*    */ import org.apache.xmlbeans.XmlOptions;
/*    */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*    */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*    */ import org.w3c.dom.Node;
/*    */ 
/*    */ public interface SimpleExtensionType extends ExtensionType {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleExtensionType == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleExtensionType = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleExtensionType).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simpleextensiontypee0detype");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static SimpleExtensionType newInstance() {
/* 29 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().newInstance(SimpleExtensionType.type, null);
/*    */     }
/*    */     public static SimpleExtensionType newInstance(XmlOptions param1XmlOptions) {
/* 32 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().newInstance(SimpleExtensionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static SimpleExtensionType parse(String param1String) throws XmlException {
/* 36 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1String, SimpleExtensionType.type, null);
/*    */     }
/*    */     public static SimpleExtensionType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 39 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1String, SimpleExtensionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static SimpleExtensionType parse(File param1File) throws XmlException, IOException {
/* 43 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1File, SimpleExtensionType.type, null);
/*    */     }
/*    */     public static SimpleExtensionType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 46 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1File, SimpleExtensionType.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleExtensionType parse(URL param1URL) throws XmlException, IOException {
/* 49 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleExtensionType.type, null);
/*    */     }
/*    */     public static SimpleExtensionType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 52 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleExtensionType.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleExtensionType parse(InputStream param1InputStream) throws XmlException, IOException {
/* 55 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleExtensionType.type, null);
/*    */     }
/*    */     public static SimpleExtensionType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 58 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleExtensionType.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleExtensionType parse(Reader param1Reader) throws XmlException, IOException {
/* 61 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleExtensionType.type, null);
/*    */     }
/*    */     public static SimpleExtensionType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 64 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleExtensionType.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleExtensionType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 67 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleExtensionType.type, null);
/*    */     }
/*    */     public static SimpleExtensionType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 70 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleExtensionType.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleExtensionType parse(Node param1Node) throws XmlException {
/* 73 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleExtensionType.type, null);
/*    */     }
/*    */     public static SimpleExtensionType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 76 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleExtensionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static SimpleExtensionType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 80 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleExtensionType.type, null);
/*    */     }
/*    */     
/*    */     public static SimpleExtensionType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 84 */       return (SimpleExtensionType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleExtensionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 88 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleExtensionType.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 92 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleExtensionType.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\SimpleExtensionType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */