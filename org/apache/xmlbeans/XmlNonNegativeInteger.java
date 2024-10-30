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
/*     */ 
/*     */ public interface XmlNonNegativeInteger
/*     */   extends XmlInteger
/*     */ {
/*  33 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_nonNegativeInteger");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlNonNegativeInteger newInstance() {
/*  43 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().newInstance(XmlNonNegativeInteger.type, null);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger newInstance(XmlOptions param1XmlOptions) {
/*  47 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().newInstance(XmlNonNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger newValue(Object param1Object) {
/*  51 */       return (XmlNonNegativeInteger)XmlNonNegativeInteger.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(String param1String) throws XmlException {
/*  55 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1String, XmlNonNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  59 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1String, XmlNonNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(File param1File) throws XmlException, IOException {
/*  63 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1File, XmlNonNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  67 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1File, XmlNonNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(URL param1URL) throws XmlException, IOException {
/*  71 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNonNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  75 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNonNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(InputStream param1InputStream) throws XmlException, IOException {
/*  79 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNonNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  83 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNonNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(Reader param1Reader) throws XmlException, IOException {
/*  87 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNonNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  91 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNonNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(Node param1Node) throws XmlException {
/*  95 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNonNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  99 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNonNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNonNegativeInteger parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 105 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNonNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNonNegativeInteger parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 111 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNonNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 115 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNonNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonNegativeInteger parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 119 */       return (XmlNonNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNonNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 125 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNonNegativeInteger.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 131 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNonNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlNonNegativeInteger.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */