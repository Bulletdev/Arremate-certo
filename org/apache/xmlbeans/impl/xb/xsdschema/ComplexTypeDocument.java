/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface ComplexTypeDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexTypeDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexTypeDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexTypeDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complextype83cbdoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TopLevelComplexType getComplexType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setComplexType(TopLevelComplexType paramTopLevelComplexType);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TopLevelComplexType addNewComplexType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static ComplexTypeDocument newInstance() {
/*  45 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().newInstance(ComplexTypeDocument.type, null);
/*     */     }
/*     */     public static ComplexTypeDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().newInstance(ComplexTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ComplexTypeDocument parse(String param1String) throws XmlException {
/*  52 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1String, ComplexTypeDocument.type, null);
/*     */     }
/*     */     public static ComplexTypeDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1String, ComplexTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ComplexTypeDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1File, ComplexTypeDocument.type, null);
/*     */     }
/*     */     public static ComplexTypeDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1File, ComplexTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexTypeDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ComplexTypeDocument.type, null);
/*     */     }
/*     */     public static ComplexTypeDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ComplexTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexTypeDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ComplexTypeDocument.type, null);
/*     */     }
/*     */     public static ComplexTypeDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ComplexTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexTypeDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ComplexTypeDocument.type, null);
/*     */     }
/*     */     public static ComplexTypeDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ComplexTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexTypeDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ComplexTypeDocument.type, null);
/*     */     }
/*     */     public static ComplexTypeDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ComplexTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexTypeDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ComplexTypeDocument.type, null);
/*     */     }
/*     */     public static ComplexTypeDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ComplexTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ComplexTypeDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ComplexTypeDocument.type, null);
/*     */     }
/*     */     
/*     */     public static ComplexTypeDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (ComplexTypeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ComplexTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ComplexTypeDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ComplexTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\ComplexTypeDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */