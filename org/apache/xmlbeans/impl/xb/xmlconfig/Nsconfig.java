/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface Nsconfig extends XmlObject {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Nsconfig == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Nsconfig = null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig")) : null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Nsconfig).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("nsconfigaebatype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getPackage();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlString xgetPackage();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetPackage();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setPackage(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetPackage(XmlString paramXmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetPackage();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getPrefix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlString xgetPrefix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetPrefix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setPrefix(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetPrefix(XmlString paramXmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetPrefix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getSuffix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlString xgetSuffix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetSuffix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSuffix(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetSuffix(XmlString paramXmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetSuffix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object getUri();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NamespaceList xgetUri();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetUri();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setUri(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetUri(NamespaceList paramNamespaceList);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetUri();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List getUriprefix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NamespacePrefixList xgetUriprefix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetUriprefix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setUriprefix(List paramList);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetUriprefix(NamespacePrefixList paramNamespacePrefixList);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetUriprefix();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static Nsconfig newInstance() {
/* 179 */       return (Nsconfig)XmlBeans.getContextTypeLoader().newInstance(Nsconfig.type, null);
/*     */     }
/*     */     public static Nsconfig newInstance(XmlOptions param1XmlOptions) {
/* 182 */       return (Nsconfig)XmlBeans.getContextTypeLoader().newInstance(Nsconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Nsconfig parse(String param1String) throws XmlException {
/* 186 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1String, Nsconfig.type, null);
/*     */     }
/*     */     public static Nsconfig parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 189 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1String, Nsconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Nsconfig parse(File param1File) throws XmlException, IOException {
/* 193 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1File, Nsconfig.type, null);
/*     */     }
/*     */     public static Nsconfig parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 196 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1File, Nsconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Nsconfig parse(URL param1URL) throws XmlException, IOException {
/* 199 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1URL, Nsconfig.type, null);
/*     */     }
/*     */     public static Nsconfig parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 202 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1URL, Nsconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Nsconfig parse(InputStream param1InputStream) throws XmlException, IOException {
/* 205 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1InputStream, Nsconfig.type, null);
/*     */     }
/*     */     public static Nsconfig parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 208 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1InputStream, Nsconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Nsconfig parse(Reader param1Reader) throws XmlException, IOException {
/* 211 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1Reader, Nsconfig.type, null);
/*     */     }
/*     */     public static Nsconfig parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 214 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1Reader, Nsconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Nsconfig parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 217 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Nsconfig.type, null);
/*     */     }
/*     */     public static Nsconfig parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 220 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Nsconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Nsconfig parse(Node param1Node) throws XmlException {
/* 223 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1Node, Nsconfig.type, null);
/*     */     }
/*     */     public static Nsconfig parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 226 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1Node, Nsconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Nsconfig parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 230 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Nsconfig.type, null);
/*     */     }
/*     */     
/*     */     public static Nsconfig parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 234 */       return (Nsconfig)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Nsconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 238 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Nsconfig.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 242 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Nsconfig.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\Nsconfig.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */