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
/*     */ public interface Qnameconfig extends XmlObject {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnameconfig == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnameconfig = null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig")) : null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnameconfig).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("qnameconfig463ftype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b getName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlQName xgetName();
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
/*     */   List getTarget();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Qnametargetlist xgetTarget();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetTarget();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setTarget(List paramList);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetTarget(Qnametargetlist paramQnametargetlist);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetTarget();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static Qnameconfig newInstance() {
/* 119 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().newInstance(Qnameconfig.type, null);
/*     */     }
/*     */     public static Qnameconfig newInstance(XmlOptions param1XmlOptions) {
/* 122 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().newInstance(Qnameconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Qnameconfig parse(String param1String) throws XmlException {
/* 126 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1String, Qnameconfig.type, null);
/*     */     }
/*     */     public static Qnameconfig parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 129 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1String, Qnameconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Qnameconfig parse(File param1File) throws XmlException, IOException {
/* 133 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1File, Qnameconfig.type, null);
/*     */     }
/*     */     public static Qnameconfig parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 136 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1File, Qnameconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnameconfig parse(URL param1URL) throws XmlException, IOException {
/* 139 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1URL, Qnameconfig.type, null);
/*     */     }
/*     */     public static Qnameconfig parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 142 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1URL, Qnameconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnameconfig parse(InputStream param1InputStream) throws XmlException, IOException {
/* 145 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1InputStream, Qnameconfig.type, null);
/*     */     }
/*     */     public static Qnameconfig parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 148 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1InputStream, Qnameconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnameconfig parse(Reader param1Reader) throws XmlException, IOException {
/* 151 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1Reader, Qnameconfig.type, null);
/*     */     }
/*     */     public static Qnameconfig parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 154 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1Reader, Qnameconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnameconfig parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 157 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Qnameconfig.type, null);
/*     */     }
/*     */     public static Qnameconfig parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 160 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Qnameconfig.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnameconfig parse(Node param1Node) throws XmlException {
/* 163 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1Node, Qnameconfig.type, null);
/*     */     }
/*     */     public static Qnameconfig parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 166 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1Node, Qnameconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Qnameconfig parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 170 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Qnameconfig.type, null);
/*     */     }
/*     */     
/*     */     public static Qnameconfig parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 174 */       return (Qnameconfig)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Qnameconfig.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 178 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Qnameconfig.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 182 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Qnameconfig.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\Qnameconfig.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */