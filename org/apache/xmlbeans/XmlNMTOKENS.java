/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import java.util.List;
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
/*     */ public interface XmlNMTOKENS
/*     */   extends XmlAnySimpleType
/*     */ {
/*  34 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NMTOKENS");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List getListValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List xgetListValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setListValue(List paramList);
/*     */ 
/*     */ 
/*     */   
/*     */   List listValue();
/*     */ 
/*     */ 
/*     */   
/*     */   List xlistValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(List paramList);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlNMTOKENS newInstance() {
/*  68 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKENS.type, null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS newInstance(XmlOptions param1XmlOptions) {
/*  72 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKENS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS newValue(Object param1Object) {
/*  76 */       return (XmlNMTOKENS)XmlNMTOKENS.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(String param1String) throws XmlException {
/*  80 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1String, XmlNMTOKENS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  84 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1String, XmlNMTOKENS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(File param1File) throws XmlException, IOException {
/*  88 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1File, XmlNMTOKENS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  92 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1File, XmlNMTOKENS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(URL param1URL) throws XmlException, IOException {
/*  96 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNMTOKENS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 100 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1URL, XmlNMTOKENS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(InputStream param1InputStream) throws XmlException, IOException {
/* 104 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNMTOKENS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 108 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlNMTOKENS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(Reader param1Reader) throws XmlException, IOException {
/* 112 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNMTOKENS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 116 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlNMTOKENS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(Node param1Node) throws XmlException {
/* 120 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNMTOKENS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 124 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1Node, XmlNMTOKENS.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNMTOKENS parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 130 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNMTOKENS.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlNMTOKENS parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 136 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlNMTOKENS.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 140 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNMTOKENS.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlNMTOKENS parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 144 */       return (XmlNMTOKENS)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlNMTOKENS.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 150 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNMTOKENS.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 156 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlNMTOKENS.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlNMTOKENS.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */