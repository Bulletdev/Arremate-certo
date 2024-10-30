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
/*     */ public interface ChoiceDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$ChoiceDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$ChoiceDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ChoiceDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$ChoiceDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("choicedf82doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup getChoice();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setChoice(ExplicitGroup paramExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup addNewChoice();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static ChoiceDocument newInstance() {
/*  45 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().newInstance(ChoiceDocument.type, null);
/*     */     }
/*     */     public static ChoiceDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().newInstance(ChoiceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ChoiceDocument parse(String param1String) throws XmlException {
/*  52 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1String, ChoiceDocument.type, null);
/*     */     }
/*     */     public static ChoiceDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1String, ChoiceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ChoiceDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1File, ChoiceDocument.type, null);
/*     */     }
/*     */     public static ChoiceDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1File, ChoiceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ChoiceDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ChoiceDocument.type, null);
/*     */     }
/*     */     public static ChoiceDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ChoiceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ChoiceDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ChoiceDocument.type, null);
/*     */     }
/*     */     public static ChoiceDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ChoiceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ChoiceDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ChoiceDocument.type, null);
/*     */     }
/*     */     public static ChoiceDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ChoiceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ChoiceDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ChoiceDocument.type, null);
/*     */     }
/*     */     public static ChoiceDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ChoiceDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ChoiceDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ChoiceDocument.type, null);
/*     */     }
/*     */     public static ChoiceDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ChoiceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ChoiceDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ChoiceDocument.type, null);
/*     */     }
/*     */     
/*     */     public static ChoiceDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (ChoiceDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ChoiceDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ChoiceDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ChoiceDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\ChoiceDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */