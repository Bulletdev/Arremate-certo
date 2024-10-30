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
/*     */ public interface TopLevelSimpleType extends SimpleType {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelSimpleType == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelSimpleType = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelSimpleType).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("toplevelsimpletypec958type");
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
/*     */     public static TopLevelSimpleType newInstance() {
/*  59 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().newInstance(TopLevelSimpleType.type, null);
/*     */     }
/*     */     public static TopLevelSimpleType newInstance(XmlOptions param1XmlOptions) {
/*  62 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().newInstance(TopLevelSimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelSimpleType parse(String param1String) throws XmlException {
/*  66 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1String, TopLevelSimpleType.type, null);
/*     */     }
/*     */     public static TopLevelSimpleType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  69 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1String, TopLevelSimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelSimpleType parse(File param1File) throws XmlException, IOException {
/*  73 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1File, TopLevelSimpleType.type, null);
/*     */     }
/*     */     public static TopLevelSimpleType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1File, TopLevelSimpleType.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelSimpleType parse(URL param1URL) throws XmlException, IOException {
/*  79 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1URL, TopLevelSimpleType.type, null);
/*     */     }
/*     */     public static TopLevelSimpleType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1URL, TopLevelSimpleType.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelSimpleType parse(InputStream param1InputStream) throws XmlException, IOException {
/*  85 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1InputStream, TopLevelSimpleType.type, null);
/*     */     }
/*     */     public static TopLevelSimpleType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1InputStream, TopLevelSimpleType.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelSimpleType parse(Reader param1Reader) throws XmlException, IOException {
/*  91 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1Reader, TopLevelSimpleType.type, null);
/*     */     }
/*     */     public static TopLevelSimpleType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1Reader, TopLevelSimpleType.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelSimpleType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  97 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TopLevelSimpleType.type, null);
/*     */     }
/*     */     public static TopLevelSimpleType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 100 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TopLevelSimpleType.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelSimpleType parse(Node param1Node) throws XmlException {
/* 103 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1Node, TopLevelSimpleType.type, null);
/*     */     }
/*     */     public static TopLevelSimpleType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 106 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1Node, TopLevelSimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelSimpleType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 110 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TopLevelSimpleType.type, null);
/*     */     }
/*     */     
/*     */     public static TopLevelSimpleType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 114 */       return (TopLevelSimpleType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TopLevelSimpleType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TopLevelSimpleType.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 122 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TopLevelSimpleType.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\TopLevelSimpleType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */