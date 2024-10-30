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
/*     */ public interface MinInclusiveDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$MinInclusiveDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$MinInclusiveDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.MinInclusiveDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$MinInclusiveDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("mininclusive8b49doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet getMinInclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setMinInclusive(Facet paramFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Facet addNewMinInclusive();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static MinInclusiveDocument newInstance() {
/*  45 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().newInstance(MinInclusiveDocument.type, null);
/*     */     }
/*     */     public static MinInclusiveDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().newInstance(MinInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MinInclusiveDocument parse(String param1String) throws XmlException {
/*  52 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1String, MinInclusiveDocument.type, null);
/*     */     }
/*     */     public static MinInclusiveDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1String, MinInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MinInclusiveDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1File, MinInclusiveDocument.type, null);
/*     */     }
/*     */     public static MinInclusiveDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1File, MinInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinInclusiveDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MinInclusiveDocument.type, null);
/*     */     }
/*     */     public static MinInclusiveDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1URL, MinInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinInclusiveDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MinInclusiveDocument.type, null);
/*     */     }
/*     */     public static MinInclusiveDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, MinInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinInclusiveDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MinInclusiveDocument.type, null);
/*     */     }
/*     */     public static MinInclusiveDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, MinInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinInclusiveDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MinInclusiveDocument.type, null);
/*     */     }
/*     */     public static MinInclusiveDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, MinInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static MinInclusiveDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MinInclusiveDocument.type, null);
/*     */     }
/*     */     public static MinInclusiveDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1Node, MinInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static MinInclusiveDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MinInclusiveDocument.type, null);
/*     */     }
/*     */     
/*     */     public static MinInclusiveDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (MinInclusiveDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, MinInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MinInclusiveDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, MinInclusiveDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\MinInclusiveDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */