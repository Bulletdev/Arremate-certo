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
/*     */ public interface KeyDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("key5d16doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase getKey();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setKey(Keybase paramKeybase);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Keybase addNewKey();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static KeyDocument newInstance() {
/*  45 */       return (KeyDocument)XmlBeans.getContextTypeLoader().newInstance(KeyDocument.type, null);
/*     */     }
/*     */     public static KeyDocument newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (KeyDocument)XmlBeans.getContextTypeLoader().newInstance(KeyDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static KeyDocument parse(String param1String) throws XmlException {
/*  52 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1String, KeyDocument.type, null);
/*     */     }
/*     */     public static KeyDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  55 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1String, KeyDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static KeyDocument parse(File param1File) throws XmlException, IOException {
/*  59 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1File, KeyDocument.type, null);
/*     */     }
/*     */     public static KeyDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  62 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1File, KeyDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static KeyDocument parse(URL param1URL) throws XmlException, IOException {
/*  65 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1URL, KeyDocument.type, null);
/*     */     }
/*     */     public static KeyDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1URL, KeyDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static KeyDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/*  71 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, KeyDocument.type, null);
/*     */     }
/*     */     public static KeyDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, KeyDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static KeyDocument parse(Reader param1Reader) throws XmlException, IOException {
/*  77 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, KeyDocument.type, null);
/*     */     }
/*     */     public static KeyDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, KeyDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static KeyDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  83 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, KeyDocument.type, null);
/*     */     }
/*     */     public static KeyDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  86 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, KeyDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static KeyDocument parse(Node param1Node) throws XmlException {
/*  89 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1Node, KeyDocument.type, null);
/*     */     }
/*     */     public static KeyDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  92 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1Node, KeyDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static KeyDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  96 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, KeyDocument.type, null);
/*     */     }
/*     */     
/*     */     public static KeyDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 100 */       return (KeyDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, KeyDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, KeyDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, KeyDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\KeyDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */