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
/*     */ public interface MinExclusiveDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$MinExclusiveDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$MinExclusiveDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$MinExclusiveDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("minexclusive64d7doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet getMinExclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMinExclusive(Facet paramFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet addNewMinExclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static MinExclusiveDocument newInstance() {
/*  45 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().newInstance(MinExclusiveDocument.type, null);
/*     */     }
/*     */     public static MinExclusiveDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().newInstance(MinExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MinExclusiveDocument parse(String param1String) throws XmlException {
/*  52 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1String, MinExclusiveDocument.type, null);
/*     */     }
/*     */     public static MinExclusiveDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1String, MinExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MinExclusiveDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1File, MinExclusiveDocument.type, null);
/*     */     }
/*     */     public static MinExclusiveDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1File, MinExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinExclusiveDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MinExclusiveDocument.type, null);
/*     */     }
/*     */     public static MinExclusiveDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MinExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinExclusiveDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MinExclusiveDocument.type, null);
/*     */     }
/*     */     public static MinExclusiveDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MinExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinExclusiveDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MinExclusiveDocument.type, null);
/*     */     }
/*     */     public static MinExclusiveDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MinExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinExclusiveDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MinExclusiveDocument.type, null);
/*     */     }
/*     */     public static MinExclusiveDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MinExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinExclusiveDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MinExclusiveDocument.type, null);
/*     */     }
/*     */     public static MinExclusiveDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MinExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MinExclusiveDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MinExclusiveDocument.type, null);
/*     */     }
/*     */     
/*     */     public static MinExclusiveDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (MinExclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MinExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MinExclusiveDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MinExclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\MinExclusiveDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */