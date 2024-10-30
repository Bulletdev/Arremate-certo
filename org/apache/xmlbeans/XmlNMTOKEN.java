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
/*     */ public interface XmlNMTOKEN
/*     */   extends XmlToken
/*     */ {
/*  35 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NMTOKEN");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlNMTOKEN newInstance() {
/*  45 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKEN.type, null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN newInstance(XmlOptions param1XmlOptions) {
/*  49 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKEN.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN newValue(Object param1Object) {
/*  53 */       return (XmlNMTOKEN)XmlNMTOKEN.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(String param1String) throws XmlException {
/*  57 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1String, XmlNMTOKEN.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  61 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1String, XmlNMTOKEN.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(File param1File) throws XmlException, IOException {
/*  65 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1File, XmlNMTOKEN.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  69 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1File, XmlNMTOKEN.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(URL param1URL) throws XmlException, IOException {
/*  73 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNMTOKEN.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  77 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNMTOKEN.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(InputStream param1InputStream) throws XmlException, IOException {
/*  81 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNMTOKEN.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  85 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNMTOKEN.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(Reader param1Reader) throws XmlException, IOException {
/*  89 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNMTOKEN.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  93 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNMTOKEN.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(Node param1Node) throws XmlException {
/*  97 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNMTOKEN.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 101 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNMTOKEN.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNMTOKEN parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 107 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNMTOKEN.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNMTOKEN parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 113 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNMTOKEN.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 117 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNMTOKEN.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKEN parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 121 */       return (XmlNMTOKEN)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNMTOKEN.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 127 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNMTOKEN.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 133 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNMTOKEN.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlNMTOKEN.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */