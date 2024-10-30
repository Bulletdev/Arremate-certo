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
/*     */ public interface FractionDigitsDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$FractionDigitsDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$FractionDigitsDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.FractionDigitsDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$FractionDigitsDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("fractiondigitsed7bdoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet getFractionDigits();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFractionDigits(NumFacet paramNumFacet);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NumFacet addNewFractionDigits();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static FractionDigitsDocument newInstance() {
/*  45 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().newInstance(FractionDigitsDocument.type, null);
/*     */     }
/*     */     public static FractionDigitsDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().newInstance(FractionDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FractionDigitsDocument parse(String param1String) throws XmlException {
/*  52 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1String, FractionDigitsDocument.type, null);
/*     */     }
/*     */     public static FractionDigitsDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1String, FractionDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FractionDigitsDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1File, FractionDigitsDocument.type, null);
/*     */     }
/*     */     public static FractionDigitsDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1File, FractionDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static FractionDigitsDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1URL, FractionDigitsDocument.type, null);
/*     */     }
/*     */     public static FractionDigitsDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1URL, FractionDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static FractionDigitsDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, FractionDigitsDocument.type, null);
/*     */     }
/*     */     public static FractionDigitsDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, FractionDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static FractionDigitsDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, FractionDigitsDocument.type, null);
/*     */     }
/*     */     public static FractionDigitsDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, FractionDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static FractionDigitsDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, FractionDigitsDocument.type, null);
/*     */     }
/*     */     public static FractionDigitsDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, FractionDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static FractionDigitsDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1Node, FractionDigitsDocument.type, null);
/*     */     }
/*     */     public static FractionDigitsDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1Node, FractionDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FractionDigitsDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, FractionDigitsDocument.type, null);
/*     */     }
/*     */     
/*     */     public static FractionDigitsDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (FractionDigitsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, FractionDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, FractionDigitsDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, FractionDigitsDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\FractionDigitsDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */