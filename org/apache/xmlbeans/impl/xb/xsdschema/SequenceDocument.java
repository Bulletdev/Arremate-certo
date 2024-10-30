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
/*     */ public interface SequenceDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$SequenceDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$SequenceDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$SequenceDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("sequencecba2doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup getSequence();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSequence(ExplicitGroup paramExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup addNewSequence();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static SequenceDocument newInstance() {
/*  45 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().newInstance(SequenceDocument.type, null);
/*     */     }
/*     */     public static SequenceDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().newInstance(SequenceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SequenceDocument parse(String param1String) throws XmlException {
/*  52 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1String, SequenceDocument.type, null);
/*     */     }
/*     */     public static SequenceDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1String, SequenceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SequenceDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1File, SequenceDocument.type, null);
/*     */     }
/*     */     public static SequenceDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1File, SequenceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SequenceDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1URL, SequenceDocument.type, null);
/*     */     }
/*     */     public static SequenceDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1URL, SequenceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SequenceDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, SequenceDocument.type, null);
/*     */     }
/*     */     public static SequenceDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, SequenceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SequenceDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, SequenceDocument.type, null);
/*     */     }
/*     */     public static SequenceDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, SequenceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SequenceDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SequenceDocument.type, null);
/*     */     }
/*     */     public static SequenceDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SequenceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SequenceDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1Node, SequenceDocument.type, null);
/*     */     }
/*     */     public static SequenceDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1Node, SequenceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SequenceDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SequenceDocument.type, null);
/*     */     }
/*     */     
/*     */     public static SequenceDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (SequenceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SequenceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SequenceDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SequenceDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\SequenceDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */