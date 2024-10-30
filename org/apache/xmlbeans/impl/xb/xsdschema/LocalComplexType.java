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
/*    */ public interface LocalComplexType extends ComplexType {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalComplexType == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalComplexType = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.LocalComplexType")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalComplexType).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("localcomplextype6494type");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static LocalComplexType newInstance() {
/* 29 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().newInstance(LocalComplexType.type, null);
/*    */     }
/*    */     public static LocalComplexType newInstance(XmlOptions param1XmlOptions) {
/* 32 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().newInstance(LocalComplexType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static LocalComplexType parse(String param1String) throws XmlException {
/* 36 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1String, LocalComplexType.type, null);
/*    */     }
/*    */     public static LocalComplexType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 39 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1String, LocalComplexType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static LocalComplexType parse(File param1File) throws XmlException, IOException {
/* 43 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1File, LocalComplexType.type, null);
/*    */     }
/*    */     public static LocalComplexType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 46 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1File, LocalComplexType.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalComplexType parse(URL param1URL) throws XmlException, IOException {
/* 49 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1URL, LocalComplexType.type, null);
/*    */     }
/*    */     public static LocalComplexType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 52 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1URL, LocalComplexType.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalComplexType parse(InputStream param1InputStream) throws XmlException, IOException {
/* 55 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1InputStream, LocalComplexType.type, null);
/*    */     }
/*    */     public static LocalComplexType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 58 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1InputStream, LocalComplexType.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalComplexType parse(Reader param1Reader) throws XmlException, IOException {
/* 61 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1Reader, LocalComplexType.type, null);
/*    */     }
/*    */     public static LocalComplexType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 64 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1Reader, LocalComplexType.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalComplexType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 67 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, LocalComplexType.type, null);
/*    */     }
/*    */     public static LocalComplexType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 70 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, LocalComplexType.type, param1XmlOptions);
/*    */     }
/*    */     public static LocalComplexType parse(Node param1Node) throws XmlException {
/* 73 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1Node, LocalComplexType.type, null);
/*    */     }
/*    */     public static LocalComplexType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 76 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1Node, LocalComplexType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static LocalComplexType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 80 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, LocalComplexType.type, null);
/*    */     }
/*    */     
/*    */     public static LocalComplexType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 84 */       return (LocalComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, LocalComplexType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 88 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, LocalComplexType.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 92 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, LocalComplexType.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\LocalComplexType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */