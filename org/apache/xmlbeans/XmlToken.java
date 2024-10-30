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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface XmlToken
/*     */   extends XmlNormalizedString
/*     */ {
/*  44 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_token");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlToken newInstance() {
/*  54 */       return (XmlToken)XmlBeans.getContextTypeLoader().newInstance(XmlToken.type, null);
/*     */     }
/*     */     
/*     */     public static XmlToken newInstance(XmlOptions param1XmlOptions) {
/*  58 */       return (XmlToken)XmlBeans.getContextTypeLoader().newInstance(XmlToken.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlToken newValue(Object param1Object) {
/*  62 */       return (XmlToken)XmlToken.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(String param1String) throws XmlException {
/*  66 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1String, XmlToken.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  70 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1String, XmlToken.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(File param1File) throws XmlException, IOException {
/*  74 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1File, XmlToken.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  78 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1File, XmlToken.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(URL param1URL) throws XmlException, IOException {
/*  82 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1URL, XmlToken.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  86 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1URL, XmlToken.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(InputStream param1InputStream) throws XmlException, IOException {
/*  90 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlToken.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  94 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlToken.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(Reader param1Reader) throws XmlException, IOException {
/*  98 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlToken.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 102 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlToken.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(Node param1Node) throws XmlException {
/* 106 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1Node, XmlToken.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 110 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1Node, XmlToken.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlToken parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 116 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlToken.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlToken parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 122 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlToken.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 126 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlToken.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlToken parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 130 */       return (XmlToken)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlToken.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 136 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlToken.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 142 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlToken.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlToken.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */