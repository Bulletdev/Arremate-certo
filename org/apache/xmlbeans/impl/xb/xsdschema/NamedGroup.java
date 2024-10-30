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
/*     */ public interface NamedGroup extends RealGroup {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("namedgroup878dtype");
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
/*     */   public static interface All
/*     */     extends All
/*     */   {
/*  58 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NamedGroup.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup$All == null) ? (NamedGroup.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup$All = NamedGroup.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup$All")) : NamedGroup.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup$All).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("all82daelemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static NamedGroup.All newInstance() {
/*  69 */         return (NamedGroup.All)XmlBeans.getContextTypeLoader().newInstance(NamedGroup.All.type, null);
/*     */       }
/*     */       public static NamedGroup.All newInstance(XmlOptions param2XmlOptions) {
/*  72 */         return (NamedGroup.All)XmlBeans.getContextTypeLoader().newInstance(NamedGroup.All.type, param2XmlOptions);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static NamedGroup newInstance() {
/*  86 */       return (NamedGroup)XmlBeans.getContextTypeLoader().newInstance(NamedGroup.type, null);
/*     */     }
/*     */     public static NamedGroup newInstance(XmlOptions param1XmlOptions) {
/*  89 */       return (NamedGroup)XmlBeans.getContextTypeLoader().newInstance(NamedGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamedGroup parse(String param1String) throws XmlException {
/*  93 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1String, NamedGroup.type, null);
/*     */     }
/*     */     public static NamedGroup parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  96 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1String, NamedGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamedGroup parse(File param1File) throws XmlException, IOException {
/* 100 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1File, NamedGroup.type, null);
/*     */     }
/*     */     public static NamedGroup parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 103 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1File, NamedGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static NamedGroup parse(URL param1URL) throws XmlException, IOException {
/* 106 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1URL, NamedGroup.type, null);
/*     */     }
/*     */     public static NamedGroup parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 109 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1URL, NamedGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static NamedGroup parse(InputStream param1InputStream) throws XmlException, IOException {
/* 112 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, NamedGroup.type, null);
/*     */     }
/*     */     public static NamedGroup parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 115 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, NamedGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static NamedGroup parse(Reader param1Reader) throws XmlException, IOException {
/* 118 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, NamedGroup.type, null);
/*     */     }
/*     */     public static NamedGroup parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 121 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, NamedGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static NamedGroup parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 124 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NamedGroup.type, null);
/*     */     }
/*     */     public static NamedGroup parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 127 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NamedGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static NamedGroup parse(Node param1Node) throws XmlException {
/* 130 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1Node, NamedGroup.type, null);
/*     */     }
/*     */     public static NamedGroup parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 133 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1Node, NamedGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamedGroup parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 137 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NamedGroup.type, null);
/*     */     }
/*     */     
/*     */     public static NamedGroup parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 141 */       return (NamedGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NamedGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 145 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NamedGroup.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 149 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NamedGroup.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\NamedGroup.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */