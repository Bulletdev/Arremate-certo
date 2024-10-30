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
/*     */ public interface MaxLengthDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxLengthDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxLengthDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.MaxLengthDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxLengthDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxlengthf8abdoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet getMaxLength();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMaxLength(NumFacet paramNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet addNewMaxLength();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static MaxLengthDocument newInstance() {
/*  45 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().newInstance(MaxLengthDocument.type, null);
/*     */     }
/*     */     public static MaxLengthDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().newInstance(MaxLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MaxLengthDocument parse(String param1String) throws XmlException {
/*  52 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1String, MaxLengthDocument.type, null);
/*     */     }
/*     */     public static MaxLengthDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1String, MaxLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MaxLengthDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1File, MaxLengthDocument.type, null);
/*     */     }
/*     */     public static MaxLengthDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1File, MaxLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxLengthDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MaxLengthDocument.type, null);
/*     */     }
/*     */     public static MaxLengthDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MaxLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxLengthDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MaxLengthDocument.type, null);
/*     */     }
/*     */     public static MaxLengthDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MaxLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxLengthDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MaxLengthDocument.type, null);
/*     */     }
/*     */     public static MaxLengthDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MaxLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxLengthDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MaxLengthDocument.type, null);
/*     */     }
/*     */     public static MaxLengthDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MaxLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxLengthDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MaxLengthDocument.type, null);
/*     */     }
/*     */     public static MaxLengthDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MaxLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MaxLengthDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MaxLengthDocument.type, null);
/*     */     }
/*     */     
/*     */     public static MaxLengthDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (MaxLengthDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MaxLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MaxLengthDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MaxLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\MaxLengthDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */