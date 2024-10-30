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
/*    */ public interface ComplexRestrictionType extends RestrictionType {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexRestrictionType == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexRestrictionType = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexRestrictionType).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complexrestrictiontype1b7dtype");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static ComplexRestrictionType newInstance() {
/* 29 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().newInstance(ComplexRestrictionType.type, null);
/*    */     }
/*    */     public static ComplexRestrictionType newInstance(XmlOptions param1XmlOptions) {
/* 32 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().newInstance(ComplexRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static ComplexRestrictionType parse(String param1String) throws XmlException {
/* 36 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1String, ComplexRestrictionType.type, null);
/*    */     }
/*    */     public static ComplexRestrictionType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 39 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1String, ComplexRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static ComplexRestrictionType parse(File param1File) throws XmlException, IOException {
/* 43 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1File, ComplexRestrictionType.type, null);
/*    */     }
/*    */     public static ComplexRestrictionType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 46 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1File, ComplexRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     public static ComplexRestrictionType parse(URL param1URL) throws XmlException, IOException {
/* 49 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1URL, ComplexRestrictionType.type, null);
/*    */     }
/*    */     public static ComplexRestrictionType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 52 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1URL, ComplexRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     public static ComplexRestrictionType parse(InputStream param1InputStream) throws XmlException, IOException {
/* 55 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1InputStream, ComplexRestrictionType.type, null);
/*    */     }
/*    */     public static ComplexRestrictionType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 58 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1InputStream, ComplexRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     public static ComplexRestrictionType parse(Reader param1Reader) throws XmlException, IOException {
/* 61 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1Reader, ComplexRestrictionType.type, null);
/*    */     }
/*    */     public static ComplexRestrictionType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 64 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1Reader, ComplexRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     public static ComplexRestrictionType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 67 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ComplexRestrictionType.type, null);
/*    */     }
/*    */     public static ComplexRestrictionType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 70 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ComplexRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     public static ComplexRestrictionType parse(Node param1Node) throws XmlException {
/* 73 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1Node, ComplexRestrictionType.type, null);
/*    */     }
/*    */     public static ComplexRestrictionType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 76 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1Node, ComplexRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static ComplexRestrictionType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 80 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ComplexRestrictionType.type, null);
/*    */     }
/*    */     
/*    */     public static ComplexRestrictionType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 84 */       return (ComplexRestrictionType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ComplexRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 88 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ComplexRestrictionType.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 92 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ComplexRestrictionType.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\ComplexRestrictionType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */