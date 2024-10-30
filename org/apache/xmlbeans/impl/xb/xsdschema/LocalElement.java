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
/*    */ public interface LocalElement extends Element {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalElement == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalElement = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.LocalElement")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalElement).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("localelement2ce2type");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static LocalElement newInstance() {
/* 29 */       return (LocalElement)XmlBeans.getContextTypeLoader().newInstance(LocalElement.type, null);
/*    */     }
/*    */     public static LocalElement newInstance(XmlOptions param1XmlOptions) {
/* 32 */       return (LocalElement)XmlBeans.getContextTypeLoader().newInstance(LocalElement.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static LocalElement parse(String param1String) throws XmlException {
/* 36 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1String, LocalElement.type, null);
/*    */     }
/*    */     public static LocalElement parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 39 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1String, LocalElement.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static LocalElement parse(File param1File) throws XmlException, IOException {
/* 43 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1File, LocalElement.type, null);
/*    */     }
/*    */     public static LocalElement parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 46 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1File, LocalElement.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalElement parse(URL param1URL) throws XmlException, IOException {
/* 49 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1URL, LocalElement.type, null);
/*    */     }
/*    */     public static LocalElement parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 52 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1URL, LocalElement.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalElement parse(InputStream param1InputStream) throws XmlException, IOException {
/* 55 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1InputStream, LocalElement.type, null);
/*    */     }
/*    */     public static LocalElement parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 58 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1InputStream, LocalElement.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalElement parse(Reader param1Reader) throws XmlException, IOException {
/* 61 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1Reader, LocalElement.type, null);
/*    */     }
/*    */     public static LocalElement parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 64 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1Reader, LocalElement.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalElement parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 67 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, LocalElement.type, null);
/*    */     }
/*    */     public static LocalElement parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 70 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, LocalElement.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalElement parse(Node param1Node) throws XmlException {
/* 73 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1Node, LocalElement.type, null);
/*    */     }
/*    */     public static LocalElement parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 76 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1Node, LocalElement.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static LocalElement parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 80 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, LocalElement.type, null);
/*    */     }
/*    */     
/*    */     public static LocalElement parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 84 */       return (LocalElement)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, LocalElement.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 88 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, LocalElement.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 92 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, LocalElement.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\LocalElement.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */