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
/*     */ public interface AttributeDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributeedb9doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TopLevelAttribute getAttribute();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAttribute(TopLevelAttribute paramTopLevelAttribute);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TopLevelAttribute addNewAttribute();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static AttributeDocument newInstance() {
/*  45 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().newInstance(AttributeDocument.type, null);
/*     */     }
/*     */     public static AttributeDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().newInstance(AttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeDocument parse(String param1String) throws XmlException {
/*  52 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1String, AttributeDocument.type, null);
/*     */     }
/*     */     public static AttributeDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1String, AttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1File, AttributeDocument.type, null);
/*     */     }
/*     */     public static AttributeDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1File, AttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AttributeDocument.type, null);
/*     */     }
/*     */     public static AttributeDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AttributeDocument.type, null);
/*     */     }
/*     */     public static AttributeDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AttributeDocument.type, null);
/*     */     }
/*     */     public static AttributeDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AttributeDocument.type, null);
/*     */     }
/*     */     public static AttributeDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AttributeDocument.type, null);
/*     */     }
/*     */     public static AttributeDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AttributeDocument.type, null);
/*     */     }
/*     */     
/*     */     public static AttributeDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (AttributeDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AttributeDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AttributeDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\AttributeDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */