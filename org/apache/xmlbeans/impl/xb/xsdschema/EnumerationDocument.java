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
/*     */ public interface EnumerationDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$EnumerationDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$EnumerationDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$EnumerationDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("enumeration052edoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NoFixedFacet getEnumeration();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setEnumeration(NoFixedFacet paramNoFixedFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NoFixedFacet addNewEnumeration();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static EnumerationDocument newInstance() {
/*  45 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().newInstance(EnumerationDocument.type, null);
/*     */     }
/*     */     public static EnumerationDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().newInstance(EnumerationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static EnumerationDocument parse(String param1String) throws XmlException {
/*  52 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1String, EnumerationDocument.type, null);
/*     */     }
/*     */     public static EnumerationDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1String, EnumerationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static EnumerationDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1File, EnumerationDocument.type, null);
/*     */     }
/*     */     public static EnumerationDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1File, EnumerationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static EnumerationDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1URL, EnumerationDocument.type, null);
/*     */     }
/*     */     public static EnumerationDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1URL, EnumerationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static EnumerationDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, EnumerationDocument.type, null);
/*     */     }
/*     */     public static EnumerationDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, EnumerationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static EnumerationDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, EnumerationDocument.type, null);
/*     */     }
/*     */     public static EnumerationDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, EnumerationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static EnumerationDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, EnumerationDocument.type, null);
/*     */     }
/*     */     public static EnumerationDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, EnumerationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static EnumerationDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1Node, EnumerationDocument.type, null);
/*     */     }
/*     */     public static EnumerationDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1Node, EnumerationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static EnumerationDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, EnumerationDocument.type, null);
/*     */     }
/*     */     
/*     */     public static EnumerationDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (EnumerationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, EnumerationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, EnumerationDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, EnumerationDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\EnumerationDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */