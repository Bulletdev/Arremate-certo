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
/*     */ public interface NamedAttributeGroup extends AttributeGroup {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedAttributeGroup == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedAttributeGroup = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedAttributeGroup).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("namedattributegroup2e29type");
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
/*     */     public static NamedAttributeGroup newInstance() {
/*  59 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().newInstance(NamedAttributeGroup.type, null);
/*     */     }
/*     */     public static NamedAttributeGroup newInstance(XmlOptions param1XmlOptions) {
/*  62 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().newInstance(NamedAttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamedAttributeGroup parse(String param1String) throws XmlException {
/*  66 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1String, NamedAttributeGroup.type, null);
/*     */     }
/*     */     public static NamedAttributeGroup parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  69 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1String, NamedAttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamedAttributeGroup parse(File param1File) throws XmlException, IOException {
/*  73 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1File, NamedAttributeGroup.type, null);
/*     */     }
/*     */     public static NamedAttributeGroup parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1File, NamedAttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static NamedAttributeGroup parse(URL param1URL) throws XmlException, IOException {
/*  79 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1URL, NamedAttributeGroup.type, null);
/*     */     }
/*     */     public static NamedAttributeGroup parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1URL, NamedAttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static NamedAttributeGroup parse(InputStream param1InputStream) throws XmlException, IOException {
/*  85 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, NamedAttributeGroup.type, null);
/*     */     }
/*     */     public static NamedAttributeGroup parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, NamedAttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static NamedAttributeGroup parse(Reader param1Reader) throws XmlException, IOException {
/*  91 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, NamedAttributeGroup.type, null);
/*     */     }
/*     */     public static NamedAttributeGroup parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, NamedAttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static NamedAttributeGroup parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  97 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NamedAttributeGroup.type, null);
/*     */     }
/*     */     public static NamedAttributeGroup parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 100 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NamedAttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static NamedAttributeGroup parse(Node param1Node) throws XmlException {
/* 103 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1Node, NamedAttributeGroup.type, null);
/*     */     }
/*     */     public static NamedAttributeGroup parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 106 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1Node, NamedAttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NamedAttributeGroup parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 110 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NamedAttributeGroup.type, null);
/*     */     }
/*     */     
/*     */     public static NamedAttributeGroup parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 114 */       return (NamedAttributeGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NamedAttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 118 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NamedAttributeGroup.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 122 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NamedAttributeGroup.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\NamedAttributeGroup.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */