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
/*     */ public interface SimpleTypeDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleTypeDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleTypeDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleTypeDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simpletypedef7doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TopLevelSimpleType getSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSimpleType(TopLevelSimpleType paramTopLevelSimpleType);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TopLevelSimpleType addNewSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static SimpleTypeDocument newInstance() {
/*  45 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().newInstance(SimpleTypeDocument.type, null);
/*     */     }
/*     */     public static SimpleTypeDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().newInstance(SimpleTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleTypeDocument parse(String param1String) throws XmlException {
/*  52 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1String, SimpleTypeDocument.type, null);
/*     */     }
/*     */     public static SimpleTypeDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1String, SimpleTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleTypeDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1File, SimpleTypeDocument.type, null);
/*     */     }
/*     */     public static SimpleTypeDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1File, SimpleTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleTypeDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleTypeDocument.type, null);
/*     */     }
/*     */     public static SimpleTypeDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1URL, SimpleTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleTypeDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleTypeDocument.type, null);
/*     */     }
/*     */     public static SimpleTypeDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, SimpleTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleTypeDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleTypeDocument.type, null);
/*     */     }
/*     */     public static SimpleTypeDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, SimpleTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleTypeDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleTypeDocument.type, null);
/*     */     }
/*     */     public static SimpleTypeDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SimpleTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SimpleTypeDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleTypeDocument.type, null);
/*     */     }
/*     */     public static SimpleTypeDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1Node, SimpleTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SimpleTypeDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleTypeDocument.type, null);
/*     */     }
/*     */     
/*     */     public static SimpleTypeDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (SimpleTypeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SimpleTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleTypeDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SimpleTypeDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\SimpleTypeDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */