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
/*     */ public interface XmlNegativeInteger
/*     */   extends XmlNonPositiveInteger
/*     */ {
/*  33 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_negativeInteger");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlNegativeInteger newInstance() {
/*  43 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().newInstance(XmlNegativeInteger.type, null);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger newInstance(XmlOptions param1XmlOptions) {
/*  47 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().newInstance(XmlNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger newValue(Object param1Object) {
/*  51 */       return (XmlNegativeInteger)XmlNegativeInteger.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(String param1String) throws XmlException {
/*  55 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1String, XmlNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  59 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1String, XmlNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(File param1File) throws XmlException, IOException {
/*  63 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1File, XmlNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  67 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1File, XmlNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(URL param1URL) throws XmlException, IOException {
/*  71 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  75 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(InputStream param1InputStream) throws XmlException, IOException {
/*  79 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  83 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(Reader param1Reader) throws XmlException, IOException {
/*  87 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  91 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(Node param1Node) throws XmlException {
/*  95 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  99 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNegativeInteger parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 105 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNegativeInteger parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 111 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 115 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNegativeInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNegativeInteger parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 119 */       return (XmlNegativeInteger)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 125 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNegativeInteger.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 131 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNegativeInteger.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlNegativeInteger.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */