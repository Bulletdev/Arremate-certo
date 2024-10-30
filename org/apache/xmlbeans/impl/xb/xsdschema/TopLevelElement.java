/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface TopLevelElement extends Element {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelElement == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelElement = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelElement).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("toplevelelement98d8type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlNCName xgetName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setName(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetName(XmlNCName paramXmlNCName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static TopLevelElement newInstance() {
/*  59 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().newInstance(TopLevelElement.type, null);
/*     */     }
/*     */     public static TopLevelElement newInstance(XmlOptions param1XmlOptions) {
/*  62 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().newInstance(TopLevelElement.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelElement parse(String param1String) throws XmlException {
/*  66 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1String, TopLevelElement.type, null);
/*     */     }
/*     */     public static TopLevelElement parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  69 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1String, TopLevelElement.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelElement parse(File param1File) throws XmlException, IOException {
/*  73 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1File, TopLevelElement.type, null);
/*     */     }
/*     */     public static TopLevelElement parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1File, TopLevelElement.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelElement parse(URL param1URL) throws XmlException, IOException {
/*  79 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1URL, TopLevelElement.type, null);
/*     */     }
/*     */     public static TopLevelElement parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1URL, TopLevelElement.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelElement parse(InputStream param1InputStream) throws XmlException, IOException {
/*  85 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1InputStream, TopLevelElement.type, null);
/*     */     }
/*     */     public static TopLevelElement parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1InputStream, TopLevelElement.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelElement parse(Reader param1Reader) throws XmlException, IOException {
/*  91 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1Reader, TopLevelElement.type, null);
/*     */     }
/*     */     public static TopLevelElement parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1Reader, TopLevelElement.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelElement parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  97 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TopLevelElement.type, null);
/*     */     }
/*     */     public static TopLevelElement parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 100 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TopLevelElement.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelElement parse(Node param1Node) throws XmlException {
/* 103 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1Node, TopLevelElement.type, null);
/*     */     }
/*     */     public static TopLevelElement parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 106 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1Node, TopLevelElement.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelElement parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 110 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TopLevelElement.type, null);
/*     */     }
/*     */     
/*     */     public static TopLevelElement parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 114 */       return (TopLevelElement)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TopLevelElement.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TopLevelElement.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 122 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TopLevelElement.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\TopLevelElement.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */