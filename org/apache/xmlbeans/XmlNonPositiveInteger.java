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
/*     */ public interface XmlNonPositiveInteger
/*     */   extends XmlInteger
/*     */ {
/*  33 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_nonPositiveInteger");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlNonPositiveInteger newInstance() {
/*  43 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().newInstance(XmlNonPositiveInteger.type, null);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger newInstance(XmlOptions param1XmlOptions) {
/*  47 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().newInstance(XmlNonPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger newValue(Object param1Object) {
/*  51 */       return (XmlNonPositiveInteger)XmlNonPositiveInteger.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(String param1String) throws XmlException {
/*  55 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1String, XmlNonPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  59 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1String, XmlNonPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(File param1File) throws XmlException, IOException {
/*  63 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1File, XmlNonPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  67 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1File, XmlNonPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(URL param1URL) throws XmlException, IOException {
/*  71 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNonPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  75 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNonPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(InputStream param1InputStream) throws XmlException, IOException {
/*  79 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNonPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  83 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNonPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(Reader param1Reader) throws XmlException, IOException {
/*  87 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNonPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  91 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNonPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(Node param1Node) throws XmlException {
/*  95 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNonPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  99 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNonPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNonPositiveInteger parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 105 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNonPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNonPositiveInteger parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 111 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNonPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 115 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNonPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNonPositiveInteger parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 119 */       return (XmlNonPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNonPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 125 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNonPositiveInteger.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 131 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNonPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlNonPositiveInteger.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */