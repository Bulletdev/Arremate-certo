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
/*    */ public interface SimpleExplicitGroup extends ExplicitGroup {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleExplicitGroup == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleExplicitGroup = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleExplicitGroup")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleExplicitGroup).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simpleexplicitgroup428ctype");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static SimpleExplicitGroup newInstance() {
/* 29 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().newInstance(SimpleExplicitGroup.type, null);
/*    */     }
/*    */     public static SimpleExplicitGroup newInstance(XmlOptions param1XmlOptions) {
/* 32 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().newInstance(SimpleExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static SimpleExplicitGroup parse(String param1String) throws XmlException {
/* 36 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1String, SimpleExplicitGroup.type, null);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 39 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1String, SimpleExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static SimpleExplicitGroup parse(File param1File) throws XmlException, IOException {
/* 43 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1File, SimpleExplicitGroup.type, null);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 46 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1File, SimpleExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(URL param1URL) throws XmlException, IOException {
/* 49 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleExplicitGroup.type, null);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 52 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(InputStream param1InputStream) throws XmlException, IOException {
/* 55 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleExplicitGroup.type, null);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 58 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(Reader param1Reader) throws XmlException, IOException {
/* 61 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleExplicitGroup.type, null);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 64 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 67 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleExplicitGroup.type, null);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 70 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(Node param1Node) throws XmlException {
/* 73 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleExplicitGroup.type, null);
/*    */     }
/*    */     public static SimpleExplicitGroup parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 76 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static SimpleExplicitGroup parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 80 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleExplicitGroup.type, null);
/*    */     }
/*    */     
/*    */     public static SimpleExplicitGroup parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 84 */       return (SimpleExplicitGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 88 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleExplicitGroup.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 92 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleExplicitGroup.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\SimpleExplicitGroup.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */