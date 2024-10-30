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
/*    */ public interface ExplicitGroup extends Group {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$ExplicitGroup == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$ExplicitGroup = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$ExplicitGroup).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("explicitgroup4efatype");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static ExplicitGroup newInstance() {
/* 29 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().newInstance(ExplicitGroup.type, null);
/*    */     }
/*    */     public static ExplicitGroup newInstance(XmlOptions param1XmlOptions) {
/* 32 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().newInstance(ExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static ExplicitGroup parse(String param1String) throws XmlException {
/* 36 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1String, ExplicitGroup.type, null);
/*    */     }
/*    */     public static ExplicitGroup parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 39 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1String, ExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static ExplicitGroup parse(File param1File) throws XmlException, IOException {
/* 43 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1File, ExplicitGroup.type, null);
/*    */     }
/*    */     public static ExplicitGroup parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 46 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1File, ExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     public static ExplicitGroup parse(URL param1URL) throws XmlException, IOException {
/* 49 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1URL, ExplicitGroup.type, null);
/*    */     }
/*    */     public static ExplicitGroup parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 52 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1URL, ExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     public static ExplicitGroup parse(InputStream param1InputStream) throws XmlException, IOException {
/* 55 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, ExplicitGroup.type, null);
/*    */     }
/*    */     public static ExplicitGroup parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 58 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, ExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     public static ExplicitGroup parse(Reader param1Reader) throws XmlException, IOException {
/* 61 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, ExplicitGroup.type, null);
/*    */     }
/*    */     public static ExplicitGroup parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 64 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, ExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     public static ExplicitGroup parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 67 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ExplicitGroup.type, null);
/*    */     }
/*    */     public static ExplicitGroup parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 70 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     public static ExplicitGroup parse(Node param1Node) throws XmlException {
/* 73 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1Node, ExplicitGroup.type, null);
/*    */     }
/*    */     public static ExplicitGroup parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 76 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1Node, ExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static ExplicitGroup parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 80 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ExplicitGroup.type, null);
/*    */     }
/*    */     
/*    */     public static ExplicitGroup parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 84 */       return (ExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 88 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ExplicitGroup.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 92 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\ExplicitGroup.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */