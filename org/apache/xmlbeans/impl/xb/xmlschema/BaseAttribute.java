/*     */ package org.apache.xmlbeans.impl.xb.xmlschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface BaseAttribute extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlschema$BaseAttribute == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlschema$BaseAttribute = null.class$("org.apache.xmlbeans.impl.xb.xmlschema.BaseAttribute")) : null.class$org$apache$xmlbeans$impl$xb$xmlschema$BaseAttribute).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("basece23attrtypetype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getBase();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlAnyURI xgetBase();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetBase();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setBase(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetBase(XmlAnyURI paramXmlAnyURI);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetBase();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static BaseAttribute newInstance() {
/*  60 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().newInstance(BaseAttribute.type, null);
/*     */     }
/*     */     public static BaseAttribute newInstance(XmlOptions param1XmlOptions) {
/*  63 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().newInstance(BaseAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static BaseAttribute parse(String param1String) throws XmlException {
/*  67 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1String, BaseAttribute.type, null);
/*     */     }
/*     */     public static BaseAttribute parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  70 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1String, BaseAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static BaseAttribute parse(File param1File) throws XmlException, IOException {
/*  74 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1File, BaseAttribute.type, null);
/*     */     }
/*     */     public static BaseAttribute parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  77 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1File, BaseAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static BaseAttribute parse(URL param1URL) throws XmlException, IOException {
/*  80 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1URL, BaseAttribute.type, null);
/*     */     }
/*     */     public static BaseAttribute parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  83 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1URL, BaseAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static BaseAttribute parse(InputStream param1InputStream) throws XmlException, IOException {
/*  86 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1InputStream, BaseAttribute.type, null);
/*     */     }
/*     */     public static BaseAttribute parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  89 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1InputStream, BaseAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static BaseAttribute parse(Reader param1Reader) throws XmlException, IOException {
/*  92 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1Reader, BaseAttribute.type, null);
/*     */     }
/*     */     public static BaseAttribute parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  95 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1Reader, BaseAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static BaseAttribute parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  98 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, BaseAttribute.type, null);
/*     */     }
/*     */     public static BaseAttribute parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 101 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, BaseAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static BaseAttribute parse(Node param1Node) throws XmlException {
/* 104 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1Node, BaseAttribute.type, null);
/*     */     }
/*     */     public static BaseAttribute parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 107 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1Node, BaseAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static BaseAttribute parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 111 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, BaseAttribute.type, null);
/*     */     }
/*     */     
/*     */     public static BaseAttribute parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 115 */       return (BaseAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, BaseAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 119 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, BaseAttribute.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 123 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, BaseAttribute.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlschema\BaseAttribute.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */