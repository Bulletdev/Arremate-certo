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
/*     */ public interface TopLevelAttribute extends Attribute {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelAttribute == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelAttribute = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelAttribute).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("toplevelattributeb338type");
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
/*     */     public static TopLevelAttribute newInstance() {
/*  59 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().newInstance(TopLevelAttribute.type, null);
/*     */     }
/*     */     public static TopLevelAttribute newInstance(XmlOptions param1XmlOptions) {
/*  62 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().newInstance(TopLevelAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelAttribute parse(String param1String) throws XmlException {
/*  66 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1String, TopLevelAttribute.type, null);
/*     */     }
/*     */     public static TopLevelAttribute parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  69 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1String, TopLevelAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelAttribute parse(File param1File) throws XmlException, IOException {
/*  73 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1File, TopLevelAttribute.type, null);
/*     */     }
/*     */     public static TopLevelAttribute parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1File, TopLevelAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelAttribute parse(URL param1URL) throws XmlException, IOException {
/*  79 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1URL, TopLevelAttribute.type, null);
/*     */     }
/*     */     public static TopLevelAttribute parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1URL, TopLevelAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelAttribute parse(InputStream param1InputStream) throws XmlException, IOException {
/*  85 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1InputStream, TopLevelAttribute.type, null);
/*     */     }
/*     */     public static TopLevelAttribute parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1InputStream, TopLevelAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelAttribute parse(Reader param1Reader) throws XmlException, IOException {
/*  91 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1Reader, TopLevelAttribute.type, null);
/*     */     }
/*     */     public static TopLevelAttribute parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1Reader, TopLevelAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelAttribute parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  97 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TopLevelAttribute.type, null);
/*     */     }
/*     */     public static TopLevelAttribute parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 100 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TopLevelAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelAttribute parse(Node param1Node) throws XmlException {
/* 103 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1Node, TopLevelAttribute.type, null);
/*     */     }
/*     */     public static TopLevelAttribute parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 106 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1Node, TopLevelAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelAttribute parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 110 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TopLevelAttribute.type, null);
/*     */     }
/*     */     
/*     */     public static TopLevelAttribute parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 114 */       return (TopLevelAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TopLevelAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TopLevelAttribute.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 122 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TopLevelAttribute.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\TopLevelAttribute.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */