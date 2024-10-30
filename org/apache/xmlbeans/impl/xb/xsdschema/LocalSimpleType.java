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
/*    */ public interface LocalSimpleType extends SimpleType {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalSimpleType == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalSimpleType = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalSimpleType).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("localsimpletype410etype");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static LocalSimpleType newInstance() {
/* 29 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().newInstance(LocalSimpleType.type, null);
/*    */     }
/*    */     public static LocalSimpleType newInstance(XmlOptions param1XmlOptions) {
/* 32 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().newInstance(LocalSimpleType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static LocalSimpleType parse(String param1String) throws XmlException {
/* 36 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1String, LocalSimpleType.type, null);
/*    */     }
/*    */     public static LocalSimpleType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 39 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1String, LocalSimpleType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static LocalSimpleType parse(File param1File) throws XmlException, IOException {
/* 43 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1File, LocalSimpleType.type, null);
/*    */     }
/*    */     public static LocalSimpleType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 46 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1File, LocalSimpleType.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalSimpleType parse(URL param1URL) throws XmlException, IOException {
/* 49 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1URL, LocalSimpleType.type, null);
/*    */     }
/*    */     public static LocalSimpleType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 52 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1URL, LocalSimpleType.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalSimpleType parse(InputStream param1InputStream) throws XmlException, IOException {
/* 55 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1InputStream, LocalSimpleType.type, null);
/*    */     }
/*    */     public static LocalSimpleType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 58 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1InputStream, LocalSimpleType.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalSimpleType parse(Reader param1Reader) throws XmlException, IOException {
/* 61 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1Reader, LocalSimpleType.type, null);
/*    */     }
/*    */     public static LocalSimpleType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 64 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1Reader, LocalSimpleType.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalSimpleType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 67 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, LocalSimpleType.type, null);
/*    */     }
/*    */     public static LocalSimpleType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 70 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, LocalSimpleType.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalSimpleType parse(Node param1Node) throws XmlException {
/* 73 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1Node, LocalSimpleType.type, null);
/*    */     }
/*    */     public static LocalSimpleType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 76 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1Node, LocalSimpleType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static LocalSimpleType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 80 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, LocalSimpleType.type, null);
/*    */     }
/*    */     
/*    */     public static LocalSimpleType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 84 */       return (LocalSimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, LocalSimpleType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 88 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, LocalSimpleType.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 92 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, LocalSimpleType.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\LocalSimpleType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */