/*    */ package org.apache.xmlbeans.impl.xb.xsdschema;
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
/*    */ import org.apache.xmlbeans.XmlToken;
/*    */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*    */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*    */ import org.w3c.dom.Node;
/*    */ 
/*    */ public interface Public extends XmlToken {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$Public == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$Public = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.Public")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$Public).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("publicf3catype");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static Public newValue(Object param1Object) {
/* 29 */       return (Public)Public.type.newValue(param1Object);
/*    */     }
/*    */     public static Public newInstance() {
/* 32 */       return (Public)XmlBeans.getContextTypeLoader().newInstance(Public.type, null);
/*    */     }
/*    */     public static Public newInstance(XmlOptions param1XmlOptions) {
/* 35 */       return (Public)XmlBeans.getContextTypeLoader().newInstance(Public.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static Public parse(String param1String) throws XmlException {
/* 39 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1String, Public.type, null);
/*    */     }
/*    */     public static Public parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 42 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1String, Public.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static Public parse(File param1File) throws XmlException, IOException {
/* 46 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1File, Public.type, null);
/*    */     }
/*    */     public static Public parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 49 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1File, Public.type, param1XmlOptions);
/*    */     }
/*    */     public static Public parse(URL param1URL) throws XmlException, IOException {
/* 52 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1URL, Public.type, null);
/*    */     }
/*    */     public static Public parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 55 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1URL, Public.type, param1XmlOptions);
/*    */     }
/*    */     public static Public parse(InputStream param1InputStream) throws XmlException, IOException {
/* 58 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1InputStream, Public.type, null);
/*    */     }
/*    */     public static Public parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 61 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1InputStream, Public.type, param1XmlOptions);
/*    */     }
/*    */     public static Public parse(Reader param1Reader) throws XmlException, IOException {
/* 64 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1Reader, Public.type, null);
/*    */     }
/*    */     public static Public parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 67 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1Reader, Public.type, param1XmlOptions);
/*    */     }
/*    */     public static Public parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 70 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Public.type, null);
/*    */     }
/*    */     public static Public parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 73 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Public.type, param1XmlOptions);
/*    */     }
/*    */     public static Public parse(Node param1Node) throws XmlException {
/* 76 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1Node, Public.type, null);
/*    */     }
/*    */     public static Public parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 79 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1Node, Public.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static Public parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 83 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Public.type, null);
/*    */     }
/*    */     
/*    */     public static Public parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 87 */       return (Public)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Public.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 91 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Public.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 95 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Public.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\Public.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */