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
/*     */ public interface AttributeGroupDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributegroup4520doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NamedAttributeGroup getAttributeGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAttributeGroup(NamedAttributeGroup paramNamedAttributeGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NamedAttributeGroup addNewAttributeGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static AttributeGroupDocument newInstance() {
/*  45 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().newInstance(AttributeGroupDocument.type, null);
/*     */     }
/*     */     public static AttributeGroupDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().newInstance(AttributeGroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeGroupDocument parse(String param1String) throws XmlException {
/*  52 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1String, AttributeGroupDocument.type, null);
/*     */     }
/*     */     public static AttributeGroupDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1String, AttributeGroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeGroupDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1File, AttributeGroupDocument.type, null);
/*     */     }
/*     */     public static AttributeGroupDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1File, AttributeGroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroupDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AttributeGroupDocument.type, null);
/*     */     }
/*     */     public static AttributeGroupDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AttributeGroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroupDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AttributeGroupDocument.type, null);
/*     */     }
/*     */     public static AttributeGroupDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AttributeGroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroupDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AttributeGroupDocument.type, null);
/*     */     }
/*     */     public static AttributeGroupDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AttributeGroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroupDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AttributeGroupDocument.type, null);
/*     */     }
/*     */     public static AttributeGroupDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AttributeGroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AttributeGroupDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AttributeGroupDocument.type, null);
/*     */     }
/*     */     public static AttributeGroupDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AttributeGroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AttributeGroupDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AttributeGroupDocument.type, null);
/*     */     }
/*     */     
/*     */     public static AttributeGroupDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (AttributeGroupDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AttributeGroupDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AttributeGroupDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AttributeGroupDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\AttributeGroupDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */