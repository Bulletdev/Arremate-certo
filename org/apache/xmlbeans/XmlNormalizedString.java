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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface XmlNormalizedString
/*     */   extends XmlString
/*     */ {
/*  40 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_normalizedString");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlNormalizedString newInstance() {
/*  50 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().newInstance(XmlNormalizedString.type, null);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString newInstance(XmlOptions param1XmlOptions) {
/*  54 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().newInstance(XmlNormalizedString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString newValue(Object param1Object) {
/*  58 */       return (XmlNormalizedString)XmlNormalizedString.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(String param1String) throws XmlException {
/*  62 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1String, XmlNormalizedString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  66 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1String, XmlNormalizedString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(File param1File) throws XmlException, IOException {
/*  70 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1File, XmlNormalizedString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  74 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1File, XmlNormalizedString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(URL param1URL) throws XmlException, IOException {
/*  78 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNormalizedString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  82 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNormalizedString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(InputStream param1InputStream) throws XmlException, IOException {
/*  86 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNormalizedString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  90 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNormalizedString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(Reader param1Reader) throws XmlException, IOException {
/*  94 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNormalizedString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  98 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNormalizedString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(Node param1Node) throws XmlException {
/* 102 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNormalizedString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 106 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNormalizedString.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNormalizedString parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 112 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNormalizedString.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNormalizedString parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 118 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNormalizedString.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 122 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNormalizedString.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNormalizedString parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 126 */       return (XmlNormalizedString)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNormalizedString.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 132 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNormalizedString.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 138 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNormalizedString.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlNormalizedString.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */