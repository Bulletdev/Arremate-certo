/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface XmlQName
/*     */   extends XmlAnySimpleType
/*     */ {
/*  40 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_QName");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b getQNameValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setQNameValue(b paramb);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b qNameValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(b paramb);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlQName newInstance() {
/*  66 */       return (XmlQName)XmlBeans.getContextTypeLoader().newInstance(XmlQName.type, null);
/*     */     }
/*     */     
/*     */     public static XmlQName newInstance(XmlOptions param1XmlOptions) {
/*  70 */       return (XmlQName)XmlBeans.getContextTypeLoader().newInstance(XmlQName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlQName newValue(Object param1Object) {
/*  74 */       return (XmlQName)XmlQName.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(String param1String) throws XmlException {
/*  78 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1String, XmlQName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  82 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1String, XmlQName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(File param1File) throws XmlException, IOException {
/*  86 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1File, XmlQName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  90 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1File, XmlQName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(URL param1URL) throws XmlException, IOException {
/*  94 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1URL, XmlQName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  98 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1URL, XmlQName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(InputStream param1InputStream) throws XmlException, IOException {
/* 102 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlQName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 106 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlQName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(Reader param1Reader) throws XmlException, IOException {
/* 110 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlQName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 114 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlQName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(Node param1Node) throws XmlException {
/* 118 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1Node, XmlQName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 122 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1Node, XmlQName.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlQName parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 128 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlQName.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlQName parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 134 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlQName.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 138 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlQName.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlQName parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 142 */       return (XmlQName)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlQName.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 148 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlQName.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 154 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlQName.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlQName.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */