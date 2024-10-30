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
/*     */ public interface UniqueDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$UniqueDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$UniqueDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$UniqueDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("unique3752doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase getUnique();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setUnique(Keybase paramKeybase);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase addNewUnique();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static UniqueDocument newInstance() {
/*  45 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().newInstance(UniqueDocument.type, null);
/*     */     }
/*     */     public static UniqueDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().newInstance(UniqueDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static UniqueDocument parse(String param1String) throws XmlException {
/*  52 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1String, UniqueDocument.type, null);
/*     */     }
/*     */     public static UniqueDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1String, UniqueDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static UniqueDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1File, UniqueDocument.type, null);
/*     */     }
/*     */     public static UniqueDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1File, UniqueDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static UniqueDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1URL, UniqueDocument.type, null);
/*     */     }
/*     */     public static UniqueDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1URL, UniqueDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static UniqueDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, UniqueDocument.type, null);
/*     */     }
/*     */     public static UniqueDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, UniqueDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static UniqueDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, UniqueDocument.type, null);
/*     */     }
/*     */     public static UniqueDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, UniqueDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static UniqueDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, UniqueDocument.type, null);
/*     */     }
/*     */     public static UniqueDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, UniqueDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static UniqueDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1Node, UniqueDocument.type, null);
/*     */     }
/*     */     public static UniqueDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1Node, UniqueDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static UniqueDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, UniqueDocument.type, null);
/*     */     }
/*     */     
/*     */     public static UniqueDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (UniqueDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, UniqueDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, UniqueDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, UniqueDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\UniqueDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */