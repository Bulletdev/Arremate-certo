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
/*     */ public interface XmlNOTATION
/*     */   extends XmlAnySimpleType
/*     */ {
/*  34 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NOTATION");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlNOTATION newInstance() {
/*  44 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().newInstance(XmlNOTATION.type, null);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION newInstance(XmlOptions param1XmlOptions) {
/*  48 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().newInstance(XmlNOTATION.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION newValue(Object param1Object) {
/*  52 */       return (XmlNOTATION)XmlNOTATION.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(String param1String) throws XmlException {
/*  56 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1String, XmlNOTATION.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  60 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1String, XmlNOTATION.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(File param1File) throws XmlException, IOException {
/*  64 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1File, XmlNOTATION.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  68 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1File, XmlNOTATION.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(URL param1URL) throws XmlException, IOException {
/*  72 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNOTATION.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  76 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNOTATION.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(InputStream param1InputStream) throws XmlException, IOException {
/*  80 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNOTATION.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  84 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNOTATION.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(Reader param1Reader) throws XmlException, IOException {
/*  88 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNOTATION.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  92 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNOTATION.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(Node param1Node) throws XmlException {
/*  96 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNOTATION.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 100 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNOTATION.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNOTATION parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 106 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNOTATION.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNOTATION parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 112 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNOTATION.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 116 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNOTATION.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNOTATION parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 120 */       return (XmlNOTATION)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNOTATION.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 126 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNOTATION.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 132 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNOTATION.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlNOTATION.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */