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
/*     */ public interface AnyAttributeDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyAttributeDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyAttributeDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnyAttributeDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anyattribute23b3doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Wildcard getAnyAttribute();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAnyAttribute(Wildcard paramWildcard);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Wildcard addNewAnyAttribute();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static AnyAttributeDocument newInstance() {
/*  45 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().newInstance(AnyAttributeDocument.type, null);
/*     */     }
/*     */     public static AnyAttributeDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().newInstance(AnyAttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AnyAttributeDocument parse(String param1String) throws XmlException {
/*  52 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1String, AnyAttributeDocument.type, null);
/*     */     }
/*     */     public static AnyAttributeDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1String, AnyAttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AnyAttributeDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1File, AnyAttributeDocument.type, null);
/*     */     }
/*     */     public static AnyAttributeDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1File, AnyAttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnyAttributeDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AnyAttributeDocument.type, null);
/*     */     }
/*     */     public static AnyAttributeDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AnyAttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnyAttributeDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AnyAttributeDocument.type, null);
/*     */     }
/*     */     public static AnyAttributeDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AnyAttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnyAttributeDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AnyAttributeDocument.type, null);
/*     */     }
/*     */     public static AnyAttributeDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AnyAttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnyAttributeDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AnyAttributeDocument.type, null);
/*     */     }
/*     */     public static AnyAttributeDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AnyAttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnyAttributeDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AnyAttributeDocument.type, null);
/*     */     }
/*     */     public static AnyAttributeDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AnyAttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AnyAttributeDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AnyAttributeDocument.type, null);
/*     */     }
/*     */     
/*     */     public static AnyAttributeDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (AnyAttributeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AnyAttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AnyAttributeDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AnyAttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\AnyAttributeDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */