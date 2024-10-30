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
/*     */ public interface MaxExclusiveDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxExclusiveDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxExclusiveDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxExclusiveDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxexclusive6d69doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet getMaxExclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMaxExclusive(Facet paramFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet addNewMaxExclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static MaxExclusiveDocument newInstance() {
/*  45 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().newInstance(MaxExclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxExclusiveDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().newInstance(MaxExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MaxExclusiveDocument parse(String param1String) throws XmlException {
/*  52 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1String, MaxExclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1String, MaxExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MaxExclusiveDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1File, MaxExclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1File, MaxExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MaxExclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MaxExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MaxExclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MaxExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MaxExclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MaxExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MaxExclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MaxExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MaxExclusiveDocument.type, null);
/*     */     }
/*     */     public static MaxExclusiveDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MaxExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MaxExclusiveDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MaxExclusiveDocument.type, null);
/*     */     }
/*     */     
/*     */     public static MaxExclusiveDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (MaxExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MaxExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MaxExclusiveDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MaxExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\MaxExclusiveDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */