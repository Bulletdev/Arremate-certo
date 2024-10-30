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
/*     */ public interface TopLevelComplexType extends ComplexType {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelComplexType == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelComplexType = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelComplexType).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("toplevelcomplextypee58atype");
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
/*     */     public static TopLevelComplexType newInstance() {
/*  59 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().newInstance(TopLevelComplexType.type, null);
/*     */     }
/*     */     public static TopLevelComplexType newInstance(XmlOptions param1XmlOptions) {
/*  62 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().newInstance(TopLevelComplexType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelComplexType parse(String param1String) throws XmlException {
/*  66 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1String, TopLevelComplexType.type, null);
/*     */     }
/*     */     public static TopLevelComplexType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  69 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1String, TopLevelComplexType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelComplexType parse(File param1File) throws XmlException, IOException {
/*  73 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1File, TopLevelComplexType.type, null);
/*     */     }
/*     */     public static TopLevelComplexType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1File, TopLevelComplexType.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelComplexType parse(URL param1URL) throws XmlException, IOException {
/*  79 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1URL, TopLevelComplexType.type, null);
/*     */     }
/*     */     public static TopLevelComplexType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1URL, TopLevelComplexType.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelComplexType parse(InputStream param1InputStream) throws XmlException, IOException {
/*  85 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1InputStream, TopLevelComplexType.type, null);
/*     */     }
/*     */     public static TopLevelComplexType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1InputStream, TopLevelComplexType.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelComplexType parse(Reader param1Reader) throws XmlException, IOException {
/*  91 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1Reader, TopLevelComplexType.type, null);
/*     */     }
/*     */     public static TopLevelComplexType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1Reader, TopLevelComplexType.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelComplexType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  97 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TopLevelComplexType.type, null);
/*     */     }
/*     */     public static TopLevelComplexType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 100 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TopLevelComplexType.type, param1XmlOptions);
/*     */     }
/*     */     public static TopLevelComplexType parse(Node param1Node) throws XmlException {
/* 103 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1Node, TopLevelComplexType.type, null);
/*     */     }
/*     */     public static TopLevelComplexType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 106 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1Node, TopLevelComplexType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TopLevelComplexType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 110 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TopLevelComplexType.type, null);
/*     */     }
/*     */     
/*     */     public static TopLevelComplexType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 114 */       return (TopLevelComplexType)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TopLevelComplexType.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TopLevelComplexType.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 122 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TopLevelComplexType.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\TopLevelComplexType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */