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
/*     */ public interface ElementDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$ElementDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$ElementDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$ElementDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("element7f99doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TopLevelElement getElement();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setElement(TopLevelElement paramTopLevelElement);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TopLevelElement addNewElement();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static ElementDocument newInstance() {
/*  45 */       return (ElementDocument)XmlBeans.getContextTypeLoader().newInstance(ElementDocument.type, null);
/*     */     }
/*     */     public static ElementDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (ElementDocument)XmlBeans.getContextTypeLoader().newInstance(ElementDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ElementDocument parse(String param1String) throws XmlException {
/*  52 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1String, ElementDocument.type, null);
/*     */     }
/*     */     public static ElementDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1String, ElementDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ElementDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1File, ElementDocument.type, null);
/*     */     }
/*     */     public static ElementDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1File, ElementDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ElementDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ElementDocument.type, null);
/*     */     }
/*     */     public static ElementDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ElementDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ElementDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ElementDocument.type, null);
/*     */     }
/*     */     public static ElementDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ElementDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ElementDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ElementDocument.type, null);
/*     */     }
/*     */     public static ElementDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ElementDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ElementDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ElementDocument.type, null);
/*     */     }
/*     */     public static ElementDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ElementDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ElementDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ElementDocument.type, null);
/*     */     }
/*     */     public static ElementDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ElementDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ElementDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ElementDocument.type, null);
/*     */     }
/*     */     
/*     */     public static ElementDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (ElementDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ElementDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ElementDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ElementDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\ElementDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */