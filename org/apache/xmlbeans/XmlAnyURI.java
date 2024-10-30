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
/*     */ public interface XmlAnyURI
/*     */   extends XmlAnySimpleType
/*     */ {
/*  30 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_anyURI");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlAnyURI newInstance() {
/*  40 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().newInstance(XmlAnyURI.type, null);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI newInstance(XmlOptions param1XmlOptions) {
/*  44 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().newInstance(XmlAnyURI.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI newValue(Object param1Object) {
/*  48 */       return (XmlAnyURI)XmlAnyURI.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(String param1String) throws XmlException {
/*  52 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1String, XmlAnyURI.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  56 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1String, XmlAnyURI.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(File param1File) throws XmlException, IOException {
/*  60 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1File, XmlAnyURI.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  64 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1File, XmlAnyURI.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(URL param1URL) throws XmlException, IOException {
/*  68 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1URL, XmlAnyURI.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  72 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1URL, XmlAnyURI.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(InputStream param1InputStream) throws XmlException, IOException {
/*  76 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlAnyURI.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  80 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlAnyURI.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(Reader param1Reader) throws XmlException, IOException {
/*  84 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlAnyURI.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  88 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlAnyURI.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(Node param1Node) throws XmlException {
/*  92 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1Node, XmlAnyURI.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  96 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1Node, XmlAnyURI.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlAnyURI parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 102 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlAnyURI.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlAnyURI parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 108 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlAnyURI.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 112 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlAnyURI.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlAnyURI parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 116 */       return (XmlAnyURI)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlAnyURI.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 122 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlAnyURI.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 128 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlAnyURI.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlAnyURI.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */