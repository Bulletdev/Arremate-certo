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
/*    */ public interface SimpleRestrictionType extends RestrictionType {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleRestrictionType == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleRestrictionType = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleRestrictionType).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplerestrictiontypeeab1type");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static SimpleRestrictionType newInstance() {
/* 29 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().newInstance(SimpleRestrictionType.type, null);
/*    */     }
/*    */     public static SimpleRestrictionType newInstance(XmlOptions param1XmlOptions) {
/* 32 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().newInstance(SimpleRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static SimpleRestrictionType parse(String param1String) throws XmlException {
/* 36 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1String, SimpleRestrictionType.type, null);
/*    */     }
/*    */     public static SimpleRestrictionType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 39 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1String, SimpleRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static SimpleRestrictionType parse(File param1File) throws XmlException, IOException {
/* 43 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1File, SimpleRestrictionType.type, null);
/*    */     }
/*    */     public static SimpleRestrictionType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 46 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1File, SimpleRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleRestrictionType parse(URL param1URL) throws XmlException, IOException {
/* 49 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleRestrictionType.type, null);
/*    */     }
/*    */     public static SimpleRestrictionType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 52 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleRestrictionType parse(InputStream param1InputStream) throws XmlException, IOException {
/* 55 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleRestrictionType.type, null);
/*    */     }
/*    */     public static SimpleRestrictionType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 58 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleRestrictionType parse(Reader param1Reader) throws XmlException, IOException {
/* 61 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleRestrictionType.type, null);
/*    */     }
/*    */     public static SimpleRestrictionType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 64 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleRestrictionType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 67 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleRestrictionType.type, null);
/*    */     }
/*    */     public static SimpleRestrictionType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 70 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     public static SimpleRestrictionType parse(Node param1Node) throws XmlException {
/* 73 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleRestrictionType.type, null);
/*    */     }
/*    */     public static SimpleRestrictionType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 76 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static SimpleRestrictionType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 80 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleRestrictionType.type, null);
/*    */     }
/*    */     
/*    */     public static SimpleRestrictionType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 84 */       return (SimpleRestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 88 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleRestrictionType.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 92 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\SimpleRestrictionType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */