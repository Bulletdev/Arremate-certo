/*     */ package org.apache.xmlbeans.impl.xb.xmlschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlLanguage;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface LangAttribute extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlschema$LangAttribute == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlschema$LangAttribute = null.class$("org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute")) : null.class$org$apache$xmlbeans$impl$xb$xmlschema$LangAttribute).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("lange126attrtypetype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getLang();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlLanguage xgetLang();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetLang();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setLang(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetLang(XmlLanguage paramXmlLanguage);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetLang();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static LangAttribute newInstance() {
/*  60 */       return (LangAttribute)XmlBeans.getContextTypeLoader().newInstance(LangAttribute.type, null);
/*     */     }
/*     */     public static LangAttribute newInstance(XmlOptions param1XmlOptions) {
/*  63 */       return (LangAttribute)XmlBeans.getContextTypeLoader().newInstance(LangAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static LangAttribute parse(String param1String) throws XmlException {
/*  67 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1String, LangAttribute.type, null);
/*     */     }
/*     */     public static LangAttribute parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  70 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1String, LangAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static LangAttribute parse(File param1File) throws XmlException, IOException {
/*  74 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1File, LangAttribute.type, null);
/*     */     }
/*     */     public static LangAttribute parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  77 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1File, LangAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static LangAttribute parse(URL param1URL) throws XmlException, IOException {
/*  80 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1URL, LangAttribute.type, null);
/*     */     }
/*     */     public static LangAttribute parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  83 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1URL, LangAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static LangAttribute parse(InputStream param1InputStream) throws XmlException, IOException {
/*  86 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1InputStream, LangAttribute.type, null);
/*     */     }
/*     */     public static LangAttribute parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  89 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1InputStream, LangAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static LangAttribute parse(Reader param1Reader) throws XmlException, IOException {
/*  92 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1Reader, LangAttribute.type, null);
/*     */     }
/*     */     public static LangAttribute parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  95 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1Reader, LangAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static LangAttribute parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  98 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, LangAttribute.type, null);
/*     */     }
/*     */     public static LangAttribute parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 101 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, LangAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static LangAttribute parse(Node param1Node) throws XmlException {
/* 104 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1Node, LangAttribute.type, null);
/*     */     }
/*     */     public static LangAttribute parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 107 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1Node, LangAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static LangAttribute parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 111 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, LangAttribute.type, null);
/*     */     }
/*     */     
/*     */     public static LangAttribute parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 115 */       return (LangAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, LangAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 119 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, LangAttribute.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 123 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, LangAttribute.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlschema\LangAttribute.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */