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
/*     */ public interface MaxInclusiveDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxInclusiveDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxInclusiveDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.MaxInclusiveDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxInclusiveDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxinclusive93dbdoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet getMaxInclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMaxInclusive(Facet paramFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet addNewMaxInclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static MaxInclusiveDocument newInstance() {
/*  45 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().newInstance(MaxInclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxInclusiveDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().newInstance(MaxInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MaxInclusiveDocument parse(String param1String) throws XmlException {
/*  52 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1String, MaxInclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1String, MaxInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MaxInclusiveDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1File, MaxInclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1File, MaxInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MaxInclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MaxInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MaxInclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MaxInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MaxInclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MaxInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MaxInclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MaxInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MaxInclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxInclusiveDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MaxInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MaxInclusiveDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MaxInclusiveDocument.type, null);
/*     */     }
/*     */     
/*     */     public static MaxInclusiveDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (MaxInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MaxInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MaxInclusiveDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MaxInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\MaxInclusiveDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */