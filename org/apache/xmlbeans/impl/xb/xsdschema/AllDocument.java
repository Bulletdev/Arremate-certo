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
/*     */ public interface AllDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$AllDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$AllDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AllDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$AllDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("all7214doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All getAll();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAll(All paramAll);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All addNewAll();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static AllDocument newInstance() {
/*  45 */       return (AllDocument)XmlBeans.getContextTypeLoader().newInstance(AllDocument.type, null);
/*     */     }
/*     */     public static AllDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (AllDocument)XmlBeans.getContextTypeLoader().newInstance(AllDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AllDocument parse(String param1String) throws XmlException {
/*  52 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1String, AllDocument.type, null);
/*     */     }
/*     */     public static AllDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1String, AllDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AllDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1File, AllDocument.type, null);
/*     */     }
/*     */     public static AllDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1File, AllDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AllDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AllDocument.type, null);
/*     */     }
/*     */     public static AllDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AllDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AllDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AllDocument.type, null);
/*     */     }
/*     */     public static AllDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AllDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AllDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AllDocument.type, null);
/*     */     }
/*     */     public static AllDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AllDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AllDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AllDocument.type, null);
/*     */     }
/*     */     public static AllDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AllDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AllDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AllDocument.type, null);
/*     */     }
/*     */     public static AllDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AllDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AllDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AllDocument.type, null);
/*     */     }
/*     */     
/*     */     public static AllDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (AllDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AllDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AllDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AllDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\AllDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */