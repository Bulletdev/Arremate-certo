/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
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
/*     */ public interface XmlLanguage
/*     */   extends XmlToken
/*     */ {
/*  32 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_language");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlLanguage newInstance() {
/*  42 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().newInstance(XmlLanguage.type, null);
/*     */     }
/*     */     
/*     */     public static XmlLanguage newInstance(XmlOptions param1XmlOptions) {
/*  46 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().newInstance(XmlLanguage.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLanguage newValue(Object param1Object) {
/*  50 */       return (XmlLanguage)XmlLanguage.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(String param1String) throws XmlException {
/*  54 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1String, XmlLanguage.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  58 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1String, XmlLanguage.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(File param1File) throws XmlException, IOException {
/*  62 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1File, XmlLanguage.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  66 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1File, XmlLanguage.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(URL param1URL) throws XmlException, IOException {
/*  70 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1URL, XmlLanguage.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1URL, XmlLanguage.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(InputStream param1InputStream) throws XmlException, IOException {
/*  78 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlLanguage.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlLanguage.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(Reader param1Reader) throws XmlException, IOException {
/*  86 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlLanguage.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  90 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlLanguage.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(Node param1Node) throws XmlException {
/*  94 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1Node, XmlLanguage.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  98 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1Node, XmlLanguage.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlLanguage parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 104 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlLanguage.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlLanguage parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 110 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlLanguage.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 114 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlLanguage.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlLanguage parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 118 */       return (XmlLanguage)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlLanguage.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 124 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlLanguage.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 130 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlLanguage.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlLanguage.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */