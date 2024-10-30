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
/*     */ public interface MinLengthDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$MinLengthDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$MinLengthDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.MinLengthDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$MinLengthDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("minlengthe7fddoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet getMinLength();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMinLength(NumFacet paramNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet addNewMinLength();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static MinLengthDocument newInstance() {
/*  45 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().newInstance(MinLengthDocument.type, null);
/*     */     }
/*     */     public static MinLengthDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().newInstance(MinLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MinLengthDocument parse(String param1String) throws XmlException {
/*  52 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1String, MinLengthDocument.type, null);
/*     */     }
/*     */     public static MinLengthDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1String, MinLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MinLengthDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1File, MinLengthDocument.type, null);
/*     */     }
/*     */     public static MinLengthDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1File, MinLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinLengthDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MinLengthDocument.type, null);
/*     */     }
/*     */     public static MinLengthDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MinLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinLengthDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MinLengthDocument.type, null);
/*     */     }
/*     */     public static MinLengthDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MinLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinLengthDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MinLengthDocument.type, null);
/*     */     }
/*     */     public static MinLengthDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MinLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinLengthDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MinLengthDocument.type, null);
/*     */     }
/*     */     public static MinLengthDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MinLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinLengthDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MinLengthDocument.type, null);
/*     */     }
/*     */     public static MinLengthDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MinLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MinLengthDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MinLengthDocument.type, null);
/*     */     }
/*     */     
/*     */     public static MinLengthDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (MinLengthDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MinLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MinLengthDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MinLengthDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\MinLengthDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */