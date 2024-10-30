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
/*     */ public interface XmlPositiveInteger
/*     */   extends XmlNonNegativeInteger
/*     */ {
/*  33 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_positiveInteger");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlPositiveInteger newInstance() {
/*  43 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().newInstance(XmlPositiveInteger.type, null);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger newInstance(XmlOptions param1XmlOptions) {
/*  47 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().newInstance(XmlPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger newValue(Object param1Object) {
/*  51 */       return (XmlPositiveInteger)XmlPositiveInteger.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(String param1String) throws XmlException {
/*  55 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1String, XmlPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  59 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1String, XmlPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(File param1File) throws XmlException, IOException {
/*  63 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1File, XmlPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  67 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1File, XmlPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(URL param1URL) throws XmlException, IOException {
/*  71 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1URL, XmlPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  75 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1URL, XmlPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(InputStream param1InputStream) throws XmlException, IOException {
/*  79 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  83 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(Reader param1Reader) throws XmlException, IOException {
/*  87 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  91 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(Node param1Node) throws XmlException {
/*  95 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1Node, XmlPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  99 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1Node, XmlPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlPositiveInteger parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 105 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlPositiveInteger parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 111 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 115 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlPositiveInteger.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlPositiveInteger parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 119 */       return (XmlPositiveInteger)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 125 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlPositiveInteger.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 131 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlPositiveInteger.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlPositiveInteger.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */