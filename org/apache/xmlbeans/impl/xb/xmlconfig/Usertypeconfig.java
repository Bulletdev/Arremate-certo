/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface Usertypeconfig extends XmlObject {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Usertypeconfig == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Usertypeconfig = null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig")) : null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Usertypeconfig).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("usertypeconfig7bbatype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getStaticHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlString xgetStaticHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setStaticHandler(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetStaticHandler(XmlString paramXmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b getName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlQName xgetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setName(b paramb);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetName(XmlQName paramXmlQName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getJavaname();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlString xgetJavaname();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetJavaname();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setJavaname(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetJavaname(XmlString paramXmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetJavaname();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static Usertypeconfig newInstance() {
/* 109 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().newInstance(Usertypeconfig.type, null);
/*     */     }
/*     */     public static Usertypeconfig newInstance(XmlOptions param1XmlOptions) {
/* 112 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().newInstance(Usertypeconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Usertypeconfig parse(String param1String) throws XmlException {
/* 116 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1String, Usertypeconfig.type, null);
/*     */     }
/*     */     public static Usertypeconfig parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 119 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1String, Usertypeconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Usertypeconfig parse(File param1File) throws XmlException, IOException {
/* 123 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1File, Usertypeconfig.type, null);
/*     */     }
/*     */     public static Usertypeconfig parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 126 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1File, Usertypeconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Usertypeconfig parse(URL param1URL) throws XmlException, IOException {
/* 129 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1URL, Usertypeconfig.type, null);
/*     */     }
/*     */     public static Usertypeconfig parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 132 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1URL, Usertypeconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Usertypeconfig parse(InputStream param1InputStream) throws XmlException, IOException {
/* 135 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1InputStream, Usertypeconfig.type, null);
/*     */     }
/*     */     public static Usertypeconfig parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 138 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1InputStream, Usertypeconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Usertypeconfig parse(Reader param1Reader) throws XmlException, IOException {
/* 141 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1Reader, Usertypeconfig.type, null);
/*     */     }
/*     */     public static Usertypeconfig parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 144 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1Reader, Usertypeconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Usertypeconfig parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 147 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Usertypeconfig.type, null);
/*     */     }
/*     */     public static Usertypeconfig parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 150 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Usertypeconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Usertypeconfig parse(Node param1Node) throws XmlException {
/* 153 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1Node, Usertypeconfig.type, null);
/*     */     }
/*     */     public static Usertypeconfig parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 156 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1Node, Usertypeconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Usertypeconfig parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 160 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Usertypeconfig.type, null);
/*     */     }
/*     */     
/*     */     public static Usertypeconfig parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 164 */       return (Usertypeconfig)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Usertypeconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 168 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Usertypeconfig.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 172 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Usertypeconfig.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\Usertypeconfig.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */